// Generated with VGen 2.0.0

/**
* Visitor del que derivar cuando se quiera que todo visit no redefinido lance
* una excepción si es invocado.
*
*/

package visitor;

import ast.*;
import ast.stmt.*;
import ast.expression.*;
import ast.datatype.*;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------


public class ExceptionThrowerVisitor implements Visitor {
	@Override
	public Object visit(Program program, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(Program)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(ClassDef classDef, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(ClassDef)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(RunInvocation runInvocation, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(RunInvocation)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(ReadStmt readStmt, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(ReadStmt)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(PrintStmt printStmt, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(PrintStmt)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(AssignStmt assignStmt, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(AssignStmt)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(IfStmt ifStmt, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(IfStmt)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(FromStmt fromStmt, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(FromStmt)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(ProcedureStmt procedureStmt, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(ProcedureStmt)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(ReturnStmt returnStmt, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(ReturnStmt)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(Assignment assignment, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(Assignment)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(IntLiteral intLiteral, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(IntLiteral)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(RealLiteral realLiteral, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(RealLiteral)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(CharLiteral charLiteral, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(CharLiteral)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(Variable variable, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(Variable)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(ProcedureExpression procedureExpression, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(ProcedureExpression)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(ArrayExpression arrayExpression, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(ArrayExpression)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(StructExpression structExpression, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(StructExpression)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(MinusExpression minusExpression, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(MinusExpression)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(NotExpression notExpression, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(NotExpression)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(Cast cast, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(Cast)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(ArithmeticExpression arithmeticExpression, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(ArithmeticExpression)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(ComparisonExpression comparisonExpression, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(ComparisonExpression)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(LogicExpression logicExpression, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(LogicExpression)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(Procedure procedure, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(Procedure)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(IntegerType integerType, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(IntegerType)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(DoubleType doubleType, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(DoubleType)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(CharacterType characterType, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(CharacterType)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(StructType structType, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(StructType)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(ArrayType arrayType, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(ArrayType)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(VoidType voidType, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(VoidType)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(ErrorType errorType, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(ErrorType)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(Create create, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(Create)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(Feature feature, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(Feature)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(ReturnInvoc returnInvoc, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(ReturnInvoc)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(LocalBlock localBlock, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(LocalBlock)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(DoBlock doBlock, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(DoBlock)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(Global global, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(Global)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(GlobalTypes globalTypes, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(GlobalTypes)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(VarsTypes varsTypes, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(VarsTypes)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(Deftuple deftuple, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(Deftuple)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(Field field, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(Field)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(VarDefinition varDefinition, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(VarDefinition)' has been invoked but it has not been implemented.");
	}

    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
