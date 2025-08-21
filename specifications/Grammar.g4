grammar Grammar;

import Tokenizer;

@header {
	import ast.*;
	import ast.datatype.*;
	import ast.expression.*;
	import ast.stmt.*;
}

program returns[Program ast]: 
	classDef global? create features 'end' runInvoc EOF
	{$ast = new Program(
		$classDef.ast, 
		($ctx.global != null ? $global.ast : null), 
		$create.ast, 
		$features.list,
		$runInvoc.ast
	);}
;

classDef returns[ClassDef ast]: 
	'class' IDENT ';' 
	{$ast = new ClassDef($IDENT);}
;

runInvoc returns[RunInvocation ast]: 
	'run' procedure ';'
	{ $ast = new RunInvocation($procedure.ast); }
;

stmts returns[List<Stmt> list = new ArrayList<Stmt>()]:
	(stmt {$list.add($stmt.ast);})+
;
stmt returns[Stmt ast]: 
	'read' args ';' 
	{$ast = new ReadStmt(($args.list != null ? $args.list : new ArrayList<>()));}
    | ('print' args? ';' 
	{$ast = new PrintStmt(($ctx.args != null ? $args.list : new ArrayList<>()), "");} ) 
    | ('println' args? ';' 
	{$ast = new PrintStmt(($ctx.args != null ? $args.list : new ArrayList<>()), "ln");} )
	| assign 
	{$ast = new AssignStmt($assign.ast);}
	| 'if' expression 'then' ifstmt = stmts ('else' elsestmt = stmts)? 'end' 
	{ $ast = new IfStmt(
		$expression.ast,
		$ifstmt.list, 
		($ctx.elsestmt != null ? $elsestmt.list : new ArrayList<>())
	);}
	| ('from' assigns? )? 'until' expression 'loop' stmts 'end' 
	{ $ast = new FromStmt(
		($ctx.assigns != null ? $assigns.list : new ArrayList<>()), 
		$expression.ast, 
		$stmts.list
	);}
	| procedure ';' 
	{$ast = new ProcedureStmt($procedure.ast);}
	| returnInvoc
	{$ast = new ReturnStmt($returnInvoc.ast);}
;

assigns returns[List<Assignment> list = new ArrayList<Assignment>()]:
	(assign {$list.add($assign.ast);})+
;
assign returns[Assignment ast]: 
	left = expression ':=' right = expression ';'
	{ $ast = new Assignment(
		$left.ast, 
		$right.ast
	);}
;

procedure returns[Procedure ast]: 
	IDENT op='(' args? cp=')' 
	{ $ast = new Procedure(
		$IDENT.text, 
		($ctx.args != null ? $args.list : new ArrayList<>())
	);
	$ast.updatePositions($IDENT,$op,($ctx.args != null ? $args.list : null),$cp);}
;
	
expression returns[Expression ast]: 
	value = INT_LITERAL 
	{ $ast = new IntLiteral($value); }
	| value = REAL_LITERAL 
	{ $ast = new RealLiteral($value); }
	| value = CHAR_LITERAL 
	{ $ast = new CharLiteral($value); }
	| name = IDENT 
	{ $ast = new Variable($name.text); $ast.updatePositions($name);}
	| procedure 
	{ $ast = new ProcedureExpression($procedure.ast); }
	| exprArray = expression '[' index = expression ']' 
	{ $ast = new ArrayExpression($exprArray.ast, $index.ast); }
	| expStruct = expression '.' IDENT 
	{ $ast = new StructExpression($expStruct.ast, $IDENT); }
	| '-' expression 
	{ $ast = new MinusExpression($expression.ast); }
	| '(' expression ')' 
	{ $ast = $expression.ast; }
	| 'not' expression 
	{ $ast = new NotExpression($expression.ast); }
	| 'to' '<' dataType '>' '(' expression ')' 
	{ $ast = new Cast($dataType.ast, $expression.ast);} 
	| left = expression operator = ('*' | '/' | 'mod') right = expression 
	{ $ast = new ArithmeticExpression($left.ast, $operator.text, $right.ast); } 
	| left = expression operator = ('+' | '-') right = expression 
	{ $ast = new ArithmeticExpression($left.ast, $operator.text, $right.ast); } 
	| left = expression operator = ('<' | '>' | '<=' | '>=') right = expression 
	{ $ast = new ComparisonExpression($left.ast, $operator.text, $right.ast); } 
	| left = expression operator = ('=' | '<>') right = expression 
	{ $ast = new ComparisonExpression($left.ast, $operator.text, $right.ast); } 
	| left = expression operator = 'and' right = expression 
	{ $ast = new LogicExpression($left.ast, $operator.text, $right.ast); } 
	| left = expression operator = 'or' right = expression 
	{ $ast = new LogicExpression($left.ast, $operator.text, $right.ast); } 
;

args returns[List<Expression> list = new ArrayList<Expression>()]: 
	expression {$list.add($expression.ast);} (',' expression {$list.add($expression.ast);} )*
;

create returns[Create ast]:
	c='create' idents {$ast = new Create($idents.list ); $ast.updatePositions($c,$idents.list);}
;

idents returns[List<String> list = new ArrayList<String>()]:
	(IDENT ';' {$list.add($IDENT.text);})+
;

varsDefinitions returns[List<VarDefinition> list = new ArrayList<VarDefinition>()]:
  (varListDefinition { $list.addAll($varListDefinition.list);})*
;

varListDefinition returns[List<VarDefinition> list = new ArrayList<VarDefinition>()]:
	varListIdents ':' dataType ';'
	 { for (int i = 0; i < $varListIdents.list.size(); i++) $list.add(
	  new VarDefinition($varListIdents.list.get(i),$dataType.ast)
	  );}
;

varListIdents returns[List<String> list = new ArrayList<>()]:
	(IDENT {$list.add($IDENT.text);}) (',' IDENT {$list.add($IDENT.text);})*
;

fields returns[List<Field> list = new ArrayList<>()]:
	(field {$list.add($field.ast);})*
;

field returns[Field ast]:
	IDENT ':' dataType ';'
	{$ast = new Field($IDENT.text, $dataType.ast);}
;

dataType returns[DataType ast]:
	intType = 'INTEGER' 
	{$ast = new IntegerType(); $ast.updatePositions($intType);}
    |  doubleType = 'DOUBLE'
	{$ast = new DoubleType(); $ast.updatePositions($doubleType);}
    |  characterType = 'CHARACTER' 
	{$ast = new CharacterType(); $ast.updatePositions($characterType);}
    |  name = IDENT 
	{$ast = new StructType($name);}
    | '[' INT_LITERAL ']' dataType 
	{$ast = new ArrayType($INT_LITERAL.text, $dataType.ast);}
;

features returns[List<Feature> list = new ArrayList<Feature>()]:
	(feature {$list.add($feature.ast);})+
;
feature returns[Feature ast]: 
	'feature' IDENT params? (':' dataType)? 'is' localBlock? doBlock 'end'
	{$ast = new Feature(
		$IDENT.text, 
		($ctx.params != null ? $params.list : new ArrayList<>()),  
		($ctx.dataType != null ? $dataType.ast : null), 
		($ctx.localBlock != null ? $localBlock.ast : null),
		$doBlock.ast
	) ;}
;

params returns[List<VarDefinition> list = new ArrayList<VarDefinition>()]:
	'(' IDENT ':' dataType {$list.add(new VarDefinition($IDENT,$dataType.ast));} 
	(',' IDENT ':' dataType {$list.add(new VarDefinition($IDENT,$dataType.ast));} )* ')'
;
		
localBlock returns[LocalBlock ast]: 
	'local' varsDefinitions 
	{$ast = new LocalBlock(
		($ctx.varsDefinitions != null ? $varsDefinitions.list : new ArrayList<>())
	);}
;
doBlock returns[DoBlock ast]: 
	'do' stmts? 
	{$ast = new DoBlock(
		($ctx.stmts != null ? $stmts.list : new ArrayList<>())
	);}
;
returnInvoc returns[ReturnInvoc ast]: 
	'return' expression? ';' 
	{$ast = new ReturnInvoc(
		($ctx.expression != null ? $expression.ast : null)
	);}
;

global returns[Global ast]: 
	'global' globalTypes? varsTypes? 
	{$ast = new Global(
		($ctx.globalTypes != null ? $globalTypes.ast : null),
		($ctx.varsTypes != null ? $varsTypes.ast : null)
	);}
;

globalTypes returns[GlobalTypes ast]:
	'types' deftuples?
	{$ast = new GlobalTypes(
		($ctx.deftuples != null ? $deftuples.list : new ArrayList<>())
	);}
;

varsTypes returns[VarsTypes ast]:
	'vars' varsDefinitions
	{$ast = new VarsTypes(
		($ctx.varsDefinitions != null ? $varsDefinitions.list : new ArrayList<>())
	);}
;

deftuples returns[List<Deftuple> list = new ArrayList<Deftuple>()]:
	(deftuple {$list.add($deftuple.ast);})+
;
deftuple returns[Deftuple ast]: 
	'deftuple' IDENT 'as' fields 'end' 
	{$ast = new Deftuple(
		$IDENT.text, 
		($ctx.fields != null ? $fields.list : new ArrayList<>())
	);}
;