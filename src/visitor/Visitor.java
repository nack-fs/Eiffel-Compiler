// Generated with VGen 2.0.0

/**
* Este interfaz es el resultado de la aplicación del patrón Visitor a los nodos del AST.
*/

package visitor;

import ast.*;
import ast.stmt.*;
import ast.expression.*;
import ast.datatype.*;




public interface Visitor {
	public Object visit(Program program, Object param);

	public Object visit(ClassDef classDef, Object param);

	public Object visit(RunInvocation runInvocation, Object param);

	public Object visit(ReadStmt readStmt, Object param);

	public Object visit(PrintStmt printStmt, Object param);

	public Object visit(AssignStmt assignStmt, Object param);

	public Object visit(IfStmt ifStmt, Object param);

	public Object visit(FromStmt fromStmt, Object param);

	public Object visit(ProcedureStmt procedureStmt, Object param);

	public Object visit(ReturnStmt returnStmt, Object param);

	public Object visit(Assignment assignment, Object param);

	public Object visit(IntLiteral intLiteral, Object param);

	public Object visit(RealLiteral realLiteral, Object param);

	public Object visit(CharLiteral charLiteral, Object param);

	public Object visit(Variable variable, Object param);

	public Object visit(ProcedureExpression procedureExpression, Object param);

	public Object visit(ArrayExpression arrayExpression, Object param);

	public Object visit(StructExpression structExpression, Object param);

	public Object visit(MinusExpression minusExpression, Object param);

	public Object visit(NotExpression notExpression, Object param);

	public Object visit(Cast cast, Object param);

	public Object visit(ArithmeticExpression arithmeticExpression, Object param);

	public Object visit(ComparisonExpression comparisonExpression, Object param);

	public Object visit(LogicExpression logicExpression, Object param);

	public Object visit(Procedure procedure, Object param);

	public Object visit(IntegerType integerType, Object param);

	public Object visit(DoubleType doubleType, Object param);

	public Object visit(CharacterType characterType, Object param);

	public Object visit(StructType structType, Object param);

	public Object visit(ArrayType arrayType, Object param);

	public Object visit(VoidType voidType, Object param);

	public Object visit(ErrorType errorType, Object param);

	public Object visit(Create create, Object param);

	public Object visit(Feature feature, Object param);

	public Object visit(ReturnInvoc returnInvoc, Object param);

	public Object visit(LocalBlock localBlock, Object param);

	public Object visit(DoBlock doBlock, Object param);

	public Object visit(Global global, Object param);

	public Object visit(GlobalTypes globalTypes, Object param);

	public Object visit(VarsTypes varsTypes, Object param);

	public Object visit(Deftuple deftuple, Object param);

	public Object visit(Field field, Object param);

	public Object visit(VarDefinition varDefinition, Object param);


}
