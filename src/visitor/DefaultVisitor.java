// Generated with VGen 2.0.0

/**
* El objetivo de esta clase DefaultVisitor es ser la implementación base de la que
* deriven todos los demás visitor.
*
* Sus métodos visit recorren los hijos del nodo que se está visitando. Por tanto,
* todo visitor que derive de este ya tendrá implementado todo el código de
* recorrido del AST.
*
* Para crear nuevos visitor, en vez de modificar esta clase, se recomienda copiar
* 'SkeletonForNewVisitors.java' o, mejor aún, definir una nueva PHASE en la gramática
* y usar el visitor generado para la misma.
*/

package visitor;

import ast.*;
import ast.stmt.*;
import ast.expression.*;
import ast.datatype.*;




public class DefaultVisitor implements Visitor {
	@Override
	public Object visit(Program program, Object param) {

		program.getClassDef().accept(this, param);
		program.getGlobal().ifPresent(global -> global.accept(this, param));
		program.getCreate().accept(this, param);
		program.getFeatures().forEach(feature -> feature.accept(this, param));
		program.getRunInvocation().accept(this, param);
		return null;
	}

	@Override
	public Object visit(ClassDef classDef, Object param) {

		return null;
	}

	@Override
	public Object visit(RunInvocation runInvocation, Object param) {

		runInvocation.getProcedure().accept(this, param);
		return null;
	}

	@Override
	public Object visit(ReadStmt readStmt, Object param) {

		readStmt.getExpressions().forEach(expression -> expression.accept(this, param));
		return null;
	}

	@Override
	public Object visit(PrintStmt printStmt, Object param) {

		printStmt.getExpressions().forEach(expression -> expression.accept(this, param));
		return null;
	}

	@Override
	public Object visit(AssignStmt assignStmt, Object param) {

		assignStmt.getAssignment().accept(this, param);
		return null;
	}

	@Override
	public Object visit(IfStmt ifStmt, Object param) {

		ifStmt.getCondition().accept(this, param);
		ifStmt.getIfStmts().forEach(stmt -> stmt.accept(this, param));
		ifStmt.getElseStmts().forEach(stmt -> stmt.accept(this, param));
		return null;
	}

	@Override
	public Object visit(FromStmt fromStmt, Object param) {

		fromStmt.getDeclarations().forEach(assignment -> assignment.accept(this, param));
		fromStmt.getCondition().accept(this, param);
		fromStmt.getStmts().forEach(stmt -> stmt.accept(this, param));
		return null;
	}

	@Override
	public Object visit(ProcedureStmt procedureStmt, Object param) {

		procedureStmt.getProcedure().accept(this, param);
		return null;
	}

	@Override
	public Object visit(ReturnStmt returnStmt, Object param) {

		returnStmt.getReturnInvoc().accept(this, param);
		return null;
	}

	@Override
	public Object visit(Assignment assignment, Object param) {

		assignment.getLeft().accept(this, param);
		assignment.getRight().accept(this, param);
		return null;
	}

	@Override
	public Object visit(IntLiteral intLiteral, Object param) {

		return null;
	}

	@Override
	public Object visit(RealLiteral realLiteral, Object param) {

		return null;
	}

	@Override
	public Object visit(CharLiteral charLiteral, Object param) {

		return null;
	}

	@Override
	public Object visit(Variable variable, Object param) {

		return null;
	}

	@Override
	public Object visit(ProcedureExpression procedureExpression, Object param) {

		procedureExpression.getProcedure().accept(this, param);
		return null;
	}

	@Override
	public Object visit(ArrayExpression arrayExpression, Object param) {

		arrayExpression.getArray().accept(this, param);
		arrayExpression.getIndex().accept(this, param);
		return null;
	}

	@Override
	public Object visit(StructExpression structExpression, Object param) {

		structExpression.getStruct().accept(this, param);
		return null;
	}

	@Override
	public Object visit(MinusExpression minusExpression, Object param) {

		minusExpression.getExpression().accept(this, param);
		return null;
	}

	@Override
	public Object visit(NotExpression notExpression, Object param) {

		notExpression.getExpression().accept(this, param);
		return null;
	}

	@Override
	public Object visit(Cast cast, Object param) {

		cast.getDataType().accept(this, param);
		cast.getExpression().accept(this, param);
		return null;
	}

	@Override
	public Object visit(ArithmeticExpression arithmeticExpression, Object param) {

		arithmeticExpression.getLeft().accept(this, param);
		arithmeticExpression.getRight().accept(this, param);
		return null;
	}

	@Override
	public Object visit(ComparisonExpression comparisonExpression, Object param) {

		comparisonExpression.getLeft().accept(this, param);
		comparisonExpression.getRight().accept(this, param);
		return null;
	}

	@Override
	public Object visit(LogicExpression logicExpression, Object param) {

		logicExpression.getLeft().accept(this, param);
		logicExpression.getRight().accept(this, param);
		return null;
	}

	@Override
	public Object visit(Procedure procedure, Object param) {

		procedure.getExpressions().forEach(expression -> expression.accept(this, param));
		return null;
	}

	@Override
	public Object visit(IntegerType integerType, Object param) {

		return null;
	}

	@Override
	public Object visit(DoubleType doubleType, Object param) {

		return null;
	}

	@Override
	public Object visit(CharacterType characterType, Object param) {

		return null;
	}

	@Override
	public Object visit(StructType structType, Object param) {

		return null;
	}

	@Override
	public Object visit(ArrayType arrayType, Object param) {

		arrayType.getDataType().accept(this, param);
		return null;
	}

	@Override
	public Object visit(VoidType voidType, Object param) {

		return null;
	}

	@Override
	public Object visit(ErrorType errorType, Object param) {

		return null;
	}

	@Override
	public Object visit(Create create, Object param) {

		return null;
	}

	@Override
	public Object visit(Feature feature, Object param) {

		feature.getParams().forEach(varDefinition -> varDefinition.accept(this, param));
		feature.getDataType().ifPresent(dataType -> dataType.accept(this, param));
		feature.getLocalBlock().ifPresent(localBlock -> localBlock.accept(this, param));
		feature.getDoBlock().accept(this, param);
		return null;
	}

	@Override
	public Object visit(ReturnInvoc returnInvoc, Object param) {

		returnInvoc.getExpression().ifPresent(expression -> expression.accept(this, param));
		return null;
	}

	@Override
	public Object visit(LocalBlock localBlock, Object param) {

		localBlock.getVarDefinitions().forEach(varDefinition -> varDefinition.accept(this, param));
		return null;
	}

	@Override
	public Object visit(DoBlock doBlock, Object param) {

		doBlock.getStmts().forEach(stmt -> stmt.accept(this, param));
		return null;
	}

	@Override
	public Object visit(Global global, Object param) {

		global.getGlobalTypes().ifPresent(globalTypes -> globalTypes.accept(this, param));
		global.getVarsTypes().ifPresent(varsTypes -> varsTypes.accept(this, param));
		return null;
	}

	@Override
	public Object visit(GlobalTypes globalTypes, Object param) {

		globalTypes.getDeftuples().forEach(deftuple -> deftuple.accept(this, param));
		return null;
	}

	@Override
	public Object visit(VarsTypes varsTypes, Object param) {

		varsTypes.getVarDefinitions().forEach(varDefinition -> varDefinition.accept(this, param));
		return null;
	}

	@Override
	public Object visit(Deftuple deftuple, Object param) {

		deftuple.getFields().forEach(field -> field.accept(this, param));
		return null;
	}

	@Override
	public Object visit(Field field, Object param) {

		field.getType().accept(this, param);
		return null;
	}

	@Override
	public Object visit(VarDefinition varDefinition, Object param) {

		varDefinition.getType().accept(this, param);
		return null;
	}


}
