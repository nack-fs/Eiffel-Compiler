package semantic;

import java.util.List;
import java.util.Optional;

import ast.*;
import ast.stmt.*;
import ast.expression.*;
import ast.datatype.*;
import main.ErrorManager;
import visitor.DefaultVisitor;

// This class will be implemented in type checking phase

public class TypeChecking extends DefaultVisitor {

	private ErrorManager errorManager;

	public TypeChecking(ErrorManager errorManager) {
		this.errorManager = errorManager;
	}

	public void process(AST ast) {
		ast.accept(this, null);
	}

	// Visit Methods --------------------------------------------------------------

	// class RunInvocation(Procedure procedure)
	@Override
	public Object visit(RunInvocation runInvocation, Object param) {
		super.visit(runInvocation, param);

		Procedure procedure = runInvocation.getProcedure();
		Feature invoked = procedure.getInvocation();
		
		if (invoked != null) {
			// Comprobamos que la feature invocada en 'run' sea un constructor
			// En identification ya marcamos las features como 'isConstructor'
			predicate(invoked.isConstructor(),
             		"La feature '" + invoked.getName() + "' llamada en 'run' no es un constructor, no estaba en 'create'",
            		runInvocation);
		}
		return null;
	}

	// class ReadStmt(List<Expression> expressions)
	// phase TypeChecking { Feature feature, boolean returnable }
	@Override
	public Object visit(ReadStmt readStmt, Object param) {
		super.visit(readStmt, param);

		for (Expression exp : readStmt.getExpressions()) {
			// Comprobamos que la expresión sea un lvalue
			predicate(exp.isLvalue(),
 					"La expresión para 'read' debe ser modificable. '" + exp.toString() + "' no lo es.",
 					exp);
			
			// Comprobamos que la expresión sea de tipo simple
			predicate(isSimpleType(exp.getType()),
 					"La expresión para 'read' debe ser de tipo simple ('integer', 'double', 'char'). Pero el tipo es: '" + exp.getType().getTypeName() + "'",
 					exp);
		}
		return null;
	}

	// class PrintStmt(List<Expression> expressions, String format)
	// phase TypeChecking { Feature feature, boolean returnable }
	@Override
	public Object visit(PrintStmt printStmt, Object param) {
		super.visit(printStmt, param);

		// Comprobamos que cada expresión sea de tipo simple
		for (Expression exp : printStmt.getExpressions()) {
 			predicate(isSimpleType(exp.getType()),
 					"La expresión para 'print' debe ser de tipo simple ('integer', 'double', 'char'). Pero el tipo es: '" + exp.getType().getTypeName() + "'",
 					exp);
 		}
		return null;
	}

	// class IfStmt(Expression condition, List<Stmt> ifStmts, List<Stmt> elseStmts)
	// phase TypeChecking { Feature feature, boolean returnable }
	@Override
	public Object visit(IfStmt ifStmt, Object param) {
		// Primero visitamos la condición
		ifStmt.getCondition().accept(this, param);
        DataType condType = ifStmt.getCondition().getType();
        
        // Comprobamos que la condición sea de tipo 'integer'
        predicate(condType instanceof IntegerType,
 				"La condición del 'if' debe ser de tipo 'integer', no '" + condType.getTypeName() + "'",
 				ifStmt.getCondition());
        
        // Visitamos los stmts de la parte 'if'
        for(Stmt s : ifStmt.getIfStmts()) {
             s.accept(this, param);
        }
        
        // Visitamos los stmts de la parte 'else'
        for(Stmt s : ifStmt.getElseStmts()) {
             s.accept(this, param);
        }
        
		return null;
	}

	// class FromStmt(List<Assignment> declarations, Expression condition, List<Stmt> stmts)
	// phase TypeChecking { Feature feature, boolean returnable }
	@Override
	public Object visit(FromStmt fromStmt, Object param) {
		// Visitamos las declaraciones
		for(Assignment a : fromStmt.getDeclarations()) a.accept(this, param);
		
		// Visitamos la condición
		fromStmt.getCondition().accept(this, param);
        DataType condType = fromStmt.getCondition().getType();
        
        // Comprobamos que la condición del until sea de tipo 'integer'
        predicate(condType instanceof IntegerType,
 				"La condición del bucle 'until' debe ser de tipo 'integer', no '" + condType.getTypeName() + "'",
 				fromStmt.getCondition());
        
        // Visitamos los stmts
        for(Stmt s : fromStmt.getStmts()) {
            s.accept(this, param);
        }
		
		return null;
	}

	// class ReturnStmt(ReturnInvoc returnInvoc)
	// phase TypeChecking { Feature feature, boolean returnable }
	@Override
	public Object visit(ReturnStmt returnStmt, Object param) {
		Feature currentFeature = (Feature) param; // Pasamos la feature actual
		if (currentFeature == null) return null;
		
		// Obtenemos el tipo de retorno
		DataType featureReturnType = currentFeature.getReturntype();
		Optional<Expression> optExpr = returnStmt.getReturnInvoc().getExpression();
		
		if (optExpr.isPresent()) {
			// Hay una expresión en el return
            Expression returnedExpr = optExpr.get();
            // Visitamos la expresión para obtener su tipo
            returnedExpr.accept(this, param);
            DataType returnedType = returnedExpr.getType();

            // Comprobamos que la feature no sea de tipo void
            predicate(!(featureReturnType instanceof VoidType),
                "La feature '" + currentFeature.getName() + "' es de tipo 'void' y no debería retornar un valor",
                returnStmt);

            // Comprobamos que si devuelve un tipo sea del mismo tipo que el tipo de retorno de la feature
            if (!(featureReturnType instanceof VoidType)) {
                 predicate(areSameType(featureReturnType, returnedType),
                    "El tipo retornado '" + returnedType.getTypeName() + "' no es del mismo tipo que el tipo de retorno '" + featureReturnType.getTypeName() + "' de la feature '" + currentFeature.getName() + "'",
                    returnedExpr);
            }
        } else {
        	// No hay expresión en el return
            // Comprobamos que la feature sea de tipo void
             predicate(featureReturnType instanceof VoidType,
                "La feature '" + currentFeature.getName() + "' debe retornar un valor de tipo '" + featureReturnType.getTypeName() + "', pero el return está vacío",
                returnStmt);
        }
		// Definimos como isReturnable
        returnStmt.setReturnable(true);
        return null;
	}

	// class Assignment(Expression left, Expression right)
	@Override
	public Object visit(Assignment assignment, Object param) {
		super.visit(assignment, param);
		
		DataType leftType = assignment.getLeft().getType();
        DataType rightType = assignment.getRight().getType();
        boolean leftIsLvalue = assignment.getLeft().isLvalue();
        
        // Comprobamos que el lado izquierdo sea lvalue
        predicate(leftIsLvalue,
 				"La expresión izquierda de la asignación debe ser modificable (lvalue)",
 				assignment.getLeft());
        
        // Comprobamos que el lado izquierdo sea de tipo simple
        predicate(isSimpleType(leftType),
 				"La expresión izquierda de la asignación debe ser de tipo simple ('integer', 'double', 'char'), no '" + leftType.getTypeName() + "'",
 				assignment.getLeft());
        
        // Comprobamos que ambos tipos sean iguales
        predicate(areSameType(leftType, rightType),
 				"La asignación solo puede aplicarse cuando ambas expresiones son del mismo tipo, no de un tipo '" + rightType.getTypeName() + "' a un tipo '" + leftType.getTypeName() + "'",
 				assignment);

		return null;
	}

	// class IntLiteral(String value)
	// phase TypeChecking { DataType type, boolean lvalue }
	@Override
	public Object visit(IntLiteral intLiteral, Object param) {
		intLiteral.setType(new IntegerType());
		intLiteral.setLvalue(false);
		return null;
	}

	// class RealLiteral(String value)
	// phase TypeChecking { DataType type, boolean lvalue }
	@Override
	public Object visit(RealLiteral realLiteral, Object param) {
		realLiteral.setType(new DoubleType());
		realLiteral.setLvalue(false);
		return null;
	}

	// class CharLiteral(String value)
	// phase TypeChecking { DataType type, boolean lvalue }
	@Override
	public Object visit(CharLiteral charLiteral, Object param) {
		charLiteral.setType(new CharacterType());
		charLiteral.setLvalue(false);
		return null;
	}

	// class Variable(String name)
	// phase Identification { VarDefinition definition }
	// phase TypeChecking { DataType type, boolean lvalue }
	@Override
	public Object visit(Variable variable, Object param) {
		// !) En Identification ya enlazamos definition
		if(variable.getDefinition() != null) {
			// Inferimos el tipo desde definition
			variable.setType(variable.getDefinition().getType());
			variable.setLvalue(true);
		}else {
			variable.setType(new ErrorType());
			variable.setLvalue(false);
		}
		return null;
	}

	// class ProcedureExpression(Procedure procedure)
	// phase TypeChecking { DataType type, boolean lvalue }
	@Override
	public Object visit(ProcedureExpression procedureExpression, Object param) {
		super.visit(procedureExpression, param);

		DataType resultType = new ErrorType(); // Por defecto en caso de error
		
		// En identification enlazamos en 'invocation' a la feature, y visitamos
		// ya la feature por lo que la feature ta tiene el 'returntype'
		Procedure procedure = procedureExpression.getProcedure();
		Feature invocation = procedure.getInvocation();
		if (invocation != null) {
			// Inferimos el tipo
			resultType = procedure.getInvocation().getReturntype();
			
			// Comprobamos que feature usada como expresión no sea Void
			predicate(!(resultType instanceof VoidType),
	                "La función '" + procedure.getName() + "' devuelve 'void' y no puede ser usada como expresión",
	                procedureExpression);
		}else {
			// Error, en la identificación no se enlazó la invocación
			predicate(false, "No se encontró la definición para la función '" + procedure.getName() + "'", procedure);
		}
		
		procedureExpression.setType(resultType);
		procedureExpression.setLvalue(false);
		return null;
	}

	// class ArrayExpression(Expression array, Expression index)
	// phase TypeChecking { DataType type, boolean lvalue }
	@Override
	public Object visit(ArrayExpression arrayExpression, Object param) {
		super.visit(arrayExpression, param);

		DataType arrayBaseType = arrayExpression.getArray().getType();
		DataType indexType = arrayExpression.getIndex().getType();
		DataType resultType = new ErrorType(); // Por defecto en caso de error
		boolean isLvalue = false;

		// Comprobamos que efectivamente sea de tipo array
		if(predicate(arrayBaseType instanceof ArrayType,
				"La expresión para el acceso a array debe ser de tipo 'array', no '" + arrayBaseType.getTypeName() + "'",
				arrayExpression.getArray())) {

			// Comprobamos si el índice es de tipo 'integer'
			if(predicate(indexType instanceof IntegerType,
					"El índice del array debe ser de tipo 'integer', no '" + indexType.getTypeName() + "'",
					arrayExpression.getIndex())) {

				// Inferimos el tipo
				resultType = ((ArrayType) arrayBaseType).getDataType();
				isLvalue = arrayExpression.getArray().isLvalue();
			}
		}

		arrayExpression.setType(resultType);
		arrayExpression.setLvalue(isLvalue);
		return null;
	}

	// class StructExpression(Expression struct, String field)
	// phase TypeChecking { DataType type, boolean lvalue }
	@Override
	public Object visit(StructExpression structExpression, Object param) {
		super.visit(structExpression, param);

		DataType structBaseType = structExpression.getStruct().getType();
		DataType resultType = new ErrorType(); // Por defecto en caso de error
		boolean isLvalue = false;

		// Comprobamos que la base sea de tipo struct
		if(predicate(structBaseType instanceof StructType,
				"La expresión para el acceso a una deftuple debe ser de tipo 'struct', no '" + structBaseType.getTypeName() + "'",
				structExpression.getStruct())) {

			StructType structType = (StructType) structBaseType;
			// En Identification enlazamos la deftuple en StructType
			Deftuple definition = structType.getDeftuple();

			if(definition != null) {
				// Comprobamos que el campo exista en la definición de la deftuple
				Field fieldDefinition = getField(definition, structExpression.getField());
				if(predicate(fieldDefinition != null,
                        "El campo '" + structExpression.getField() + "' no existe en la definición de la tupla '" + definition.getName() + "'",
                        structExpression)) {
					
					// Inferimos el tipo
					resultType = fieldDefinition.getType();
					isLvalue = structExpression.getStruct().isLvalue();
				}
			}else {
				// Error, no tenía enlazada la tupla
				predicate(false, "No se encontró la definición para el tipo tupla '" + structType.getName() + "'", structExpression.getStruct());
			}
		}
		
 		structExpression.setType(resultType);
 		structExpression.setLvalue(isLvalue);
		return null;
	}

	// class MinusExpression(Expression expression)
	// phase TypeChecking { DataType type, boolean lvalue }
	@Override
	public Object visit(MinusExpression minusExpression, Object param) {
		super.visit(minusExpression, param);

		DataType expType = minusExpression.getExpression().getType();
		DataType resultType = new ErrorType(); // Por defecto en caso de error
        
		// Comprobamos que la expresión sea de tipo 'integer' o 'double'
		if(predicate(expType instanceof IntegerType || expType instanceof DoubleType,
 				"El operador menos unario solo puede aplicarse a tipos 'integer' o 'double', no a '" + expType.getTypeName() + "'",
 				minusExpression)) {
			
			// Inferimos el tipo
			resultType = expType;
		}
		
		minusExpression.setType(resultType);
		minusExpression.setLvalue(false);
		return null;
	}

	// class NotExpression(Expression expression)
	// phase TypeChecking { DataType type, boolean lvalue }
	@Override
	public Object visit(NotExpression notExpression, Object param) {
		super.visit(notExpression, param);

		DataType exprType = notExpression.getExpression().getType();
		DataType resultType = new ErrorType(); // Por defecto en caso de error
        
		// Comprobamos que la expresión sea de tipo 'integer'
		if(predicate(exprType instanceof IntegerType,
 				"El operador 'not' solo puede aplicarse a tipo 'integer', no a '" + exprType.getTypeName() + "'",
 				notExpression)) {
			
			// Inferimos el tipo
			resultType = new IntegerType();
		}
		
		notExpression.setType(resultType);
		notExpression.setLvalue(false);
		return null;
	}

	// class Cast(DataType dataType, Expression expression)
	// phase TypeChecking { DataType type, boolean lvalue }
	@Override
	public Object visit(Cast cast, Object param) {
		super.visit(cast, param);

		DataType originType = cast.getExpression().getType();
		DataType destinationType = cast.getDataType();
		DataType resultType = new ErrorType(); // Por defecto en caso de error
		
		// Comprobamos que el cast cumpla las reglas permitidas
		if(predicate(isValidCast(originType, destinationType),
 				"No es posible hacer un cast de '" + originType.getTypeName() + "' a '" + destinationType.getTypeName() + "'",
 				cast)) {
			
			// Inferimos el tipo
			resultType = destinationType;
		}
		
		cast.setType(resultType);
		cast.setLvalue(false);
		return null;
	}

	// class ArithmeticExpression(Expression left, String operator, Expression right)
	// phase TypeChecking { DataType type, boolean lvalue }
	@Override
	public Object visit(ArithmeticExpression arithmeticExpression, Object param) {
		super.visit(arithmeticExpression, param);

		DataType leftType = arithmeticExpression.getLeft().getType();
        DataType rightType = arithmeticExpression.getRight().getType();
        DataType resultType = new ErrorType(); // Por defecto en caso de error
        String operator = arithmeticExpression.getOperator();
        
        // Comprobamos que ambas expresiones sean del mismo tipo
        if(predicate(areSameType(leftType, rightType),
                "La operación aritmética '" + operator + "':  en la izquierda es de tipo '" + leftType.getTypeName() + "' y en la derecha de tipo '" + rightType.getTypeName() 
                + "', cuando deberían ser del mismo tipo",
                arithmeticExpression)) {
        	
        	// Comprobamos si es 'mod', ya que en mod ambos tipos deben ser 'integer'
        	if (operator.equals("mod")) {
        		if(predicate(leftType instanceof IntegerType && rightType instanceof IntegerType,
                        "El operador 'mod' requiere operandos de tipo 'integer'",
                        arithmeticExpression)) {
        			
        			resultType = new IntegerType();
        		}
        	}else {
        		if (leftType instanceof DoubleType || rightType instanceof DoubleType) {
                    resultType = new DoubleType();
                } else {
                    resultType = new IntegerType();
                }
        	}
        }
        
        arithmeticExpression.setType(resultType);
        arithmeticExpression.setLvalue(false);
		return null;
	}

	// class ComparisonExpression(Expression left, String operator, Expression right)
	// phase TypeChecking { DataType type, boolean lvalue }
	@Override
	public Object visit(ComparisonExpression comparisonExpression, Object param) {
		super.visit(comparisonExpression, param);

		DataType leftType = comparisonExpression.getLeft().getType();
        DataType rightType = comparisonExpression.getRight().getType();
        DataType resultType = new ErrorType(); // Por defecto en caso de error
        
        // Comprobamos que los operandos deben ser del mismo tipo, pudiendo ser 'integer' o 'double'
        if(predicate(areSameType(leftType, rightType) && (leftType instanceof IntegerType || leftType instanceof DoubleType),
                "Para la comparación, el tipo de la izquierda es '" + leftType.getTypeName() + "' y el de la derecha '" + rightType.getTypeName() 
                + "' .Cuando deben ser 'integer' o 'double' y del ambos del mismo tipo",
 				comparisonExpression)) {
        	
        	resultType = new IntegerType();
        }
        
        comparisonExpression.setType(resultType);
        comparisonExpression.setLvalue(false);
		return null;
	}

	// class LogicExpression(Expression left, String operator, Expression right)
	// phase TypeChecking { DataType type, boolean lvalue }
	@Override
	public Object visit(LogicExpression logicExpression, Object param) {
		super.visit(logicExpression, param);

		DataType leftType = logicExpression.getLeft().getType();
        DataType rightType = logicExpression.getRight().getType();
        DataType resultType = new ErrorType(); // Por defecto en caso de error
        
        // Comprobamos que ambas expresiones sean de tipo 'integer'
        if(predicate(leftType instanceof IntegerType && rightType instanceof IntegerType,
 				"Los operandos para operaciones lógicas deben ser de tipo 'integer', no '" + leftType.getTypeName() + "' y '" + rightType.getTypeName() + "'",
 				logicExpression)) {
        	
        	resultType = new IntegerType();
        }
        
        logicExpression.setType(resultType);
        logicExpression.setLvalue(false);
		return null;
	}

	// class Procedure(String name, List<Expression> expressions)
	// phase Identification { Feature invocation }
	@Override
	public Object visit(Procedure procedure, Object param) {
		super.visit(procedure, param);

		// En identification ya asignamos el 'invocation'
		Feature invocation = procedure.getInvocation();
		if(invocation == null) {
            predicate(false, "No se encontró la definición para la feature '" + procedure.getName() + "'", procedure);
            return null;
        }
		
		List<Expression> arguments = procedure.getExpressions();
        List<VarDefinition> parameters = invocation.getParams();
        
        // Comprobamos el mismo número de argugemntos que de parámetros
        if(predicate(arguments.size() == parameters.size(),
 				"La llamada a la feature '" + invocation.getName() + "' tiene " + arguments.size() + " argumentos, pero se esperaban " + parameters.size(),
 				procedure)) {
        	
        	// Comprobamos que los argumentos sean del mismo tipo
        	for (int i = 0; i < arguments.size(); i++) {
                DataType argType = arguments.get(i).getType();
                DataType paramType = parameters.get(i).getType();
 	 			predicate(areSameType(paramType, argType),
 	 					"El argumento " + (i+1) + " de tipo '" + argType.getTypeName() + "' no es del mismo tipo que el parámetro '" + parameters.get(i).getName() + "' de tipo '" + paramType.getTypeName() + "' en la llamada a '" + invocation.getName() + "'",
 	 					arguments.get(i));
 	 		}
        }
		return null;
	}

	// class ArrayType(String size, DataType dataType)
	@Override
	public Object visit(ArrayType arrayType, Object param) {
		super.visit(arrayType, param);

		// Comprobamos que el tamaño sea un entero literal positivo
		predicate(isPositiveIntegerLiteral(arrayType.getSize()),
 				"El tamaño del array debe ser un literal entero positivo.",
 				arrayType);
		return null;
	}
	
	// class DoBlock(List<Stmt> stmts)
	// phase TypeChecking { boolean returnable }
	@Override
    public Object visit(DoBlock doBlock, Object param) {
		// Visitamos las sentencias
        if (doBlock.getStmts() != null) {
            for(Stmt s : doBlock.getStmts()) {
                s.accept(this, param);
                // NO estamos comprobando si devuelven todos los caminos, ya que eso es una funcionalidad EXTRA
                // solo comprobamos si hay por lo menos un return (Funcionalidad Básica Obligatoria)
                if(s.isReturnable()) {
                	doBlock.setReturnable(true);
                }
            }
        }
        return null;
    }

	// class Feature(String name, List<VarDefinition> params, Optional<DataType> dataType, Optional<LocalBlock> localBlock, DoBlock doBlock)
	// phase TypeChecking { DataType returntype, boolean isConstructor }
	@Override
	public Object visit(Feature feature, Object param) {
		DataType calculatedReturnType;
		
		// Comprobamos que si existe tipo de retorno este sea simple
		if (feature.getDataType().isPresent()) {
			DataType declaredReturnType = feature.getDataType().get();
            declaredReturnType.accept(this, null);
			feature.setReturntype(declaredReturnType);
			calculatedReturnType = declaredReturnType;

            predicate(isSimpleType(calculatedReturnType),
                      "El tipo de retorno de la feature '" + feature.getName() + "' debe ser simple ('integer', 'double', 'char'), no '" + calculatedReturnType.getTypeName() + "'",
                      declaredReturnType);
		} else {
			calculatedReturnType = new VoidType();
			feature.setReturntype(calculatedReturnType);
		}

		// Comprobamos que los tipos de los parámetros sean simples
		for (VarDefinition p : feature.getParams()) {
            p.getType().accept(this, null);
 			predicate(isSimpleType(p.getType()),
 					"El parámetro '" + p.getName() + "' en la feature '" + feature.getName() + "' debe ser de tipo simple ('integer', 'double', 'char'), no '" + p.getType().getTypeName() + "'",
 					p);
 		}

		// Visitamos el localBock
		if (feature.getLocalBlock().isPresent()) {feature.getLocalBlock().get().accept(this, feature);}

		// Visitamos el doBlock
		if (feature.getDoBlock() != null) {feature.getDoBlock().accept(this, feature);
            // Comprobamos que si el tipo de retorno es distinto de 'void' haya por lo menos un return
			// NO estamos comprobando si devuelven todos los caminos, ya que eso es una funcionalidad EXTRA
        	// solo comprobamos si hay por lo menos un return (Funcionalidad Básica Obligatoria)
            if (!(calculatedReturnType instanceof VoidType)) {
                predicate(feature.getDoBlock().isReturnable(),
                    "La feature '" + feature.getName() + "' debe devolver un valor de tipo '" + calculatedReturnType.getTypeName() + "', pero no todas las rutas de ejecución garantizan un 'return'.",
                    feature);
            }
        } else {
             if (!(calculatedReturnType instanceof VoidType)) {
                  predicate(false,
                      "La feature '" + feature.getName() + "' debe devolver un valor de tipo '" + calculatedReturnType.getTypeName() + "', pero no tiene bloque 'do'.",
                      feature);
             }
        }
		return null;
	}

	//# ----------------------------------------------------------
	//# Auxiliary Methods

	private void notifyError(String errorMessage, Position position) {
		errorManager.notify("Type Checking", errorMessage, position);
	}

	private void notifyError(String msg) {
		errorManager.notify("Type Checking", msg);
	}

	private boolean predicate(boolean condition, String errorMessage, Position position) {
		if (!condition) {
			notifyError(errorMessage, position);
			return false;
		}
		return true;
	}

	private boolean predicate(boolean condition, String errorMessage, AST node) {
		return predicate(condition, errorMessage, node.start());
	}

	//# ----------------------------------------------------------
	//# Auxiliary Methods for TypeChecking

	// Comprueba que el tipo es simple
	private boolean isSimpleType(DataType type) {
		return (type instanceof IntegerType) || (type instanceof DoubleType) || (type instanceof CharacterType);
	}

	// Comprueba si dos tipos son del mismo tipo
	private boolean areSameType(DataType typeA, DataType typeB) {
		if (typeA == null || typeB == null) return false;
		if (typeA instanceof ErrorType || typeB instanceof ErrorType) return false;

		if (typeA.getClass().equals(typeB.getClass())) {
			if (typeA instanceof StructType) {
				// Dos structTypes son iguales si referencian la misma deftuple
				Deftuple defA = ((StructType) typeA).getDeftuple();
				Deftuple defB = ((StructType) typeB).getDeftuple();
				return defA != null && defA == defB;
			} else if (typeA instanceof ArrayType) {
				// Dos arrayTypes son iguales si sus tipos base son iguales
				return areSameType(((ArrayType) typeA).getDataType(), ((ArrayType) typeB).getDataType());
			} else {
				return true;
			}
		}
		return false;
	}
	
	// Comprueba las reglas del cast
	private boolean isValidCast(DataType origin, DataType destination) {
       return (origin instanceof DoubleType && destination instanceof IntegerType) ||
   			(origin instanceof CharacterType && destination instanceof IntegerType) ||
   			(origin instanceof IntegerType && destination instanceof DoubleType) ||
   			(origin instanceof IntegerType && destination instanceof CharacterType);
    }
	
	// Comprueba si un string puede parsearse a integer
	private boolean isPositiveIntegerLiteral(String size) {
        if (size == null || size.isEmpty()) {
            return false;
        }
        try {
            int value = Integer.parseInt(size);
            return value > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
	
	// Devuelve el campo de una deftuple dado el nombre del mismo
	private Field getField(Deftuple def, String name) {
	        if (def == null || name == null) return null;
	    	for (Field f : def.getFields()) {
	    		if (name.equals(f.getName())) {
	    			return f;
	    		}
	    	}
	    	return null;
	 }
}
