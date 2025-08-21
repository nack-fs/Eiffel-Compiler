// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import java.util.List;

import ast.Field;
import ast.VarDefinition;
import ast.datatype.ArrayType;
import ast.datatype.StructType;
import ast.expression.*;
import codegeneration.mapl.*;


public class Address extends AbstractCodeFunction {
	private CodeGenerator cg = CodeGenerator.getInstance();

    public Address(MaplCodeSpecification specification) {
        super(specification);
    }

	// class Variable(String name)
	// phase Identification { VarDefinition definition }
	// phase TypeChecking { DataType type, boolean lvalue }
	@Override
	public Object visit(Variable variable, Object param) {
		// if(variable.definition.scope == GLOBAL)
		VarDefinition definition = variable.getDefinition();
		if(definition.getScope().equals(CodeGenerator.Scope.GLOBAL.toString())) {
			// PUSHA {variable.definition.address}
			cg.pusha(definition.getAddress());
		}else {// LOCAL o PARAM
			// PUSH BP
			cg.pushBP();
			// PUSHI {variable.definition.address}
			cg.pushi(definition.getAddress());
			// ADD
			cg.addi();
		}
		return null;
	}

	// class ArrayExpression(Expression array, Expression index)
	// phase TypeChecking { DataType type, boolean lvalue }
	@Override
	public Object visit(ArrayExpression arrayExpression, Object param) {
		// address⟦array⟧
		address(arrayExpression.getArray());
		// value⟦index⟧
		value(arrayExpression.getIndex());

		// PUSHI {array.type.dataType.numberOfBytes()}
		ArrayType arrayType = (ArrayType) arrayExpression.getArray().getType();
		int elementSize = arrayType.getDataType().getMemorySize();
		cg.pushi(elementSize);
		// MUL
		cg.muli(); // index * elementSize
		// ADD
		cg.addi(); // base + offset
		return null;
	}

	// class StructExpression(Expression struct, String field)
	// phase TypeChecking { DataType type, boolean lvalue }
	@Override
	public Object visit(StructExpression structExpression, Object param) {
		// address ⟦struct⟧
		address(structExpression.getStruct());
		
		// PUSHI {struct.type.deftuple.getField(field).offset}
		StructType structType = (StructType) structExpression.getStruct().getType();
		int fieldOffset=-1;
		List<Field> fields = structType.getDeftuple().getFields();
		for(Field f: fields) {
			if(f.getName().equals(structExpression.getField())) {
				fieldOffset = f.getOffset();
			}
		}
		cg.pushi(fieldOffset);
		// ADD
		cg.addi(); // base + offset
		return null;
	}

}
