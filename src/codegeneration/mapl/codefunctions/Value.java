// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.Procedure;
import ast.datatype.DataType;
import ast.datatype.DoubleType;
import ast.datatype.IntegerType;
import ast.expression.*;
import codegeneration.mapl.*;


public class Value extends AbstractCodeFunction {
	private CodeGenerator cg = CodeGenerator.getInstance();

    public Value(MaplCodeSpecification specification) {
        super(specification);
    }


	// class IntLiteral(String value)
	// phase TypeChecking { DataType type, boolean lvalue }
	@Override
	public Object visit(IntLiteral intLiteral, Object param) {
		// PUSHI {value}
		cg.pushi(Integer.parseInt(intLiteral.getValue()));
		return null;
	}

	// class RealLiteral(String value)
	// phase TypeChecking { DataType type, boolean lvalue }
	@Override
	public Object visit(RealLiteral realLiteral, Object param) {
		// PUSHF {value}
		cg.pushf(Double.parseDouble(realLiteral.getValue()));
		return null;
	}

	// class CharLiteral(String value)
	// phase TypeChecking { DataType type, boolean lvalue }
	@Override
	public Object visit(CharLiteral charLiteral, Object param) {
		// PUSHB {(int)value.charAt(1)}
		cg.pushb(((int) charLiteral.getValue().charAt(1)));
		return null;
	}

	// class Variable(String name)
	// phase Identification { VarDefinition definition }
	// phase TypeChecking { DataType type, boolean lvalue }
	@Override
	public Object visit(Variable variable, Object param) {
		// address⟦variable⟧
		address(variable);
		// LOAD<{variable.type.suffix()}>
		cg.load(variable.getType());
		return null;
	}

	// class ProcedureExpression(Procedure procedure)
	// phase TypeChecking { DataType type, boolean lvalue }
	@Override
	public Object visit(ProcedureExpression procedureExpression, Object param) {
		// procedure.expression*.foreach(arg => value⟦arg⟧)
		Procedure procedure = procedureExpression.getProcedure();
		procedure.getExpressions().forEach(arg -> value(arg));
		// CALL {procedure.name}
		cg.call(procedure.getName());
		// !) El valor de retorno queda en la pila
		return null;
	}

	// class ArrayExpression(Expression array, Expression index)
	// phase TypeChecking { DataType type, boolean lvalue }
	@Override
	public Object visit(ArrayExpression arrayExpression, Object param) {
		// address⟦arrayExpression⟧
		address(arrayExpression);
		// LOAD<{arrayExpression.type.suffix()}>
		cg.load(arrayExpression.getType());
		return null;
	}

	// class StructExpression(Expression struct, String field)
	// phase TypeChecking { DataType type, boolean lvalue }
	@Override
	public Object visit(StructExpression structExpression, Object param) {
		// address⟦structExpression⟧
		address(structExpression);
		// LOAD<{structExpression.type.suffix()}>
		cg.load(structExpression.getType());
		return null;
	}

	// class MinusExpression(Expression expression)
	// phase TypeChecking { DataType type, boolean lvalue }
	@Override
	public Object visit(MinusExpression minusExpression, Object param) {
		// if(expression.type instanceof IntegerType) PUSHI 0 else PUSHF 0.0
		Expression exp = minusExpression.getExpression();
		
		if (exp.getType() instanceof IntegerType) {
			cg.pushi(0);
        } else if (exp.getType() instanceof DoubleType) {
        	cg.pushf(0.0);
        }
		
		// value ⟦expression⟧
		value(exp);
		 
		// SUB<{expression.type.suffix()}>
		cg.sub(exp.getType());
		return null;
	}

	// class NotExpression(Expression expression)
	// phase TypeChecking { DataType type, boolean lvalue }
	@Override
	public Object visit(NotExpression notExpression, Object param) {
		//  value⟦expression⟧
		value(notExpression.getExpression());
		// NOT
		cg.not();
		return null;
	}

	// class Cast(DataType dataType, Expression expression)
	// phase TypeChecking { DataType type, boolean lvalue }
	@Override
	public Object visit(Cast cast, Object param) {
		// value⟦expression⟧
		value(cast.getExpression());
		
		// CONVERT<{expression.type.suffix()}2{dataType.suffix()}>
		cg.convert(cast.getExpression().getType(), cast.getDataType());

		return null;
	}

	// class ArithmeticExpression(Expression left, String operator, Expression right)
	// phase TypeChecking { DataType type, boolean lvalue }
	@Override
	public Object visit(ArithmeticExpression arithmeticExpression, Object param) {
		// value⟦left⟧
		value(arithmeticExpression.getLeft());
		// value⟦right⟧
		value(arithmeticExpression.getRight());
		
		// {getMAPLOperator(operator, type)}<{type.suffix()}>
		DataType resultType = arithmeticExpression.getType();
		cg.arithmetic(arithmeticExpression.getOperator(), resultType);

		return null;
	}

	// class ComparisonExpression(Expression left, String operator, Expression right)
	// phase TypeChecking { DataType type, boolean lvalue }
	@Override
	public Object visit(ComparisonExpression comparisonExpression, Object param) {
		// value⟦left⟧
		value(comparisonExpression.getLeft());
		// value⟦right⟧
		value(comparisonExpression.getRight());
		
		// {getMAPLOperator(operator, type)}
		DataType operandType = comparisonExpression.getType();
		cg.comparison(comparisonExpression.getOperator(), operandType);

		return null;
	}

	// class LogicExpression(Expression left, String operator, Expression right)
	// phase TypeChecking { DataType type, boolean lvalue }
	@Override
	public Object visit(LogicExpression logicExpression, Object param) {
		// value⟦left⟧
		value(logicExpression.getLeft()); // Apila 0 o 1
		// value⟦right⟧
		value(logicExpression.getRight()); // Apila 0 o 1
		
		// {getMAPLOperator(operator, expression.type)}
		cg.logical(logicExpression.getOperator()); // and, or

		return null;
	}

}
