// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.*;
import ast.datatype.DataType;
import ast.datatype.VoidType;
import ast.expression.Expression;
import ast.stmt.*;
import codegeneration.mapl.*;


public class Execute extends AbstractCodeFunction {
	private CodeGenerator cg = CodeGenerator.getInstance();

    public Execute(MaplCodeSpecification specification) {
        super(specification);
    }


	// class RunInvocation(Procedure procedure)
	@Override
	public Object visit(RunInvocation runInvocation, Object param) {
		if(runInvocation.start() != null) {
            cg.line(runInvocation.start().getLine());
        }
		
		// procedure.expression*.foreach(arg => value⟦arg⟧)
		Procedure procedure = runInvocation.getProcedure();
		procedure.getExpressions().forEach(arg -> value(arg));
		
		// CALL {procedure.name}
		cg.call(procedure.getName());
		
		// Si devuelve algo lo eliminamos de la pila
		DataType returnType = procedure.getInvocation().getReturntype();
		if(!(returnType instanceof VoidType)) {
			cg.pop(returnType);
		}
		return null;
	}

	// class Assignment(Expression left, Expression right)
	@Override
	public Object visit(Assignment assignment, Object param) {
		// '#line {assignment.start.line}'
		if(assignment.start()!=null) {
			cg.line(assignment.start().getLine());
		}
		// address⟦left⟧
		address(assignment.getLeft());
		// value⟦right⟧
		value(assignment.getRight());
		
		// STORE<{left.type.suffix()}>
		DataType leftType = assignment.getLeft().getType();
		cg.store(leftType);
		return null;
	}

	// class Feature(String name, List<VarDefinition> params, Optional<DataType> dataType, Optional<LocalBlock> localBlock, DoBlock doBlock)
	// phase TypeChecking { DataType returntype, boolean constructor }
	@Override
	public Object visit(Feature feature, Object param) {
		// {name}:
		cg.functionStart(feature.getName());
		// '#line {feature.start.line}'
		if(feature.start()!= null) {
			cg.line(feature.start().getLine());
		}
		
		// Generar directiva #func
        cg.func(feature.getName());
		
		// Metadatos #param, #local, #ret
		feature.getParams().forEach(p ->
	        cg.param(p.getName(), p.getType(), p.getAddress())
	    );
	    feature.getLocalBlock().ifPresent(lb ->
	        lb.getVarDefinitions().forEach(l ->
	            cg.local(l.getName(), l.getType(), l.getAddress())
	        )
	    );
	    cg.retMetadata(feature.getReturntype());
		
		// Calculamos bytes de Locales y Parámetros 
		int localBytes = 0; // Valor por defecto si no hay locales
		if (feature.getLocalBlock().isPresent()) {
		     localBytes = feature.getLocalBlock().get().getVarDefinitions().stream()
		                           .mapToInt(vd -> vd.getType().getMemorySize())
		                           .sum();
		}
		
		int paramBytes = feature.getParams().stream()
				.mapToInt(p -> p.getType().getMemorySize())
				.sum();
		
		// if(localBytes > 0) ENTER {localBytes} 
		if (localBytes > 0) {
			cg.enter(localBytes);
		}
		
		// execute⟦doBlock⟧({localBytes}, {paramBytes})
		Object[] contextParams = new Object[]{localBytes, paramBytes};
		
		execute(feature.getDoBlock(), contextParams);
		
		// RET implícito para void
		if (feature.getDataType().isEmpty() || feature.getDataType().get() instanceof VoidType) {
			cg.ret(0, localBytes, paramBytes);
		}
		return null;
	}

	// class ReturnInvoc(Optional<Expression> expression)
	@Override
	public Object visit(ReturnInvoc returnInvoc, Object param) {
		if(returnInvoc.start() != null) {
            cg.line(returnInvoc.start().getLine());
        }
		
		int returnBytes = 0;
		// if(expression.isPresent())
		if(returnInvoc.getExpression().isPresent()) {
			Expression expr = returnInvoc.getExpression().get();
			// value ⟦expression.get()⟧
			value(expr);
			// returnBytes = expression.get().type.numberOfBytes()
			returnBytes = expr.getType().getMemorySize();
		}
		
		// Obtenemos localBytes, paramBytes del contexto
		int localBytes = 0;
		int paramBytes = 0;
		if (param instanceof Object[] && ((Object[]) param).length == 2) {
			localBytes = (int) ((Object[]) param)[0];
            paramBytes = (int) ((Object[]) param)[1];
		}

		// RET {returnBytes}, {localBytes}, {paramBytes}
		cg.ret(returnBytes, localBytes, paramBytes);
		return null;
	}

	// class DoBlock(List<Stmt> stmts)
	// phase TypeChecking { boolean returnable }
	@Override
	public Object visit(DoBlock doBlock, Object param) {
		// stmt*.foreach(s => execute ⟦s⟧(localBytes, paramBytes))
		doBlock.getStmts().forEach(s -> execute(s, param));
		return null;
	}

	// class ReadStmt(List<Expression> expressions)
	// phase TypeChecking { Feature feature, boolean returnable }
	@Override
	public Object visit(ReadStmt readStmt, Object param) {
		// '#line {readStmt.start.line}'
		if(readStmt.start()!=null) {
			cg.line(readStmt.start().getLine());
		}
		// expression*.foreach(expr => ... )
		readStmt.getExpressions().forEach(expr -> {
			// address⟦expr⟧
            address(expr);
            // IN<{expr.type.suffix()}>
            cg.in(expr.getType());
            // STORE<{expr.type.suffix()}>
            cg.store(expr.getType());
        });
		return null;
	}

	// class PrintStmt(List<Expression> expressions, String format)
	// phase TypeChecking { Feature feature, boolean returnable }
	@Override
	public Object visit(PrintStmt printStmt, Object param) {
		// '#line {printStmt.start.line}'
		if(printStmt.start() != null) {
			cg.line(printStmt.start().getLine());
		}
		// expression*.foreach(exp => ... )
		printStmt.getExpressions().forEach(expr -> {
			// value⟦exp⟧
			value(expr);
			// OUT<{exp.type.suffix()}>
			cg.out(expr.getType());
		});
		// if(format == "ln") PUSHB 10; OUTB
		if ("ln".equals(printStmt.getFormat())) {
			cg.pushb(10);
			cg.outb();
        }
		return null;
	}

	// class AssignStmt(Assignment assignment)
	// phase TypeChecking { Feature feature, boolean returnable }
	@Override
	public Object visit(AssignStmt assignStmt, Object param) {
		// execute⟦assignment⟧
		execute(assignStmt.getAssignment(), param);
		return null;
	}

	// class IfStmt(Expression condition, List<Stmt> ifStmts, List<Stmt> elseStmts)
	// phase TypeChecking { Feature feature, boolean returnable }
	@Override
	public Object visit(IfStmt ifStmt, Object param) {
		// string elseLabel = util.nextLabel()
		String elseLabel = cg.nextLabel();
		// string endIfLabel = util.nextLabel()
		String endIfLabel = cg.nextLabel();
		
		// '#line {condition.start.line}'
		if(ifStmt.getCondition().start()!=null) {
			cg.line(ifStmt.getCondition().start().getLine());
		}
		// value⟦condition⟧
		value(ifStmt.getCondition());
		// JZ {"else_" + elseLabel}
		cg.jz("else_" + elseLabel);
		
		// ifStmts*.foreach(s => execute⟦s⟧(localBytes, paramBytes))
		ifStmt.getIfStmts().forEach(s -> execute(s, param));
		// JMP {"endif_" + endIfLabel}
		cg.jmp("endif_" + endIfLabel);
		
		// {"else_" + elseLabel}:
		cg.printLabel("else_" + elseLabel);
		// elseStmts*.foreach(s => execute⟦s⟧(localBytes, paramBytes))
		if (!ifStmt.getElseStmts().isEmpty()) {
			ifStmt.getElseStmts().forEach(s -> execute(s, param));
		}

		// {"endif_" + endIfLabel}:
		cg.printLabel("endif_" + endIfLabel);
		return null;
	}

	// class FromStmt(List<Assignment> declarations, Expression condition, List<Stmt> stmts)
	// phase TypeChecking { Feature feature, boolean returnable }
	@Override
	public Object visit(FromStmt fromStmt, Object param) {
		// string label = util.nextLabel()
		String label = cg.nextLabel();
		
		// ' inicio from_{label}
		cg.comment("inicio from_" + label);
		
		// declarations*.foreach(decl => execute⟦decl⟧)
		// !) Las declaraciones no necesitan el contexto de RET
		fromStmt.getDeclarations().forEach(decl -> execute(decl, null));
		
		// {condLabel}:
		String condLabel = "FromCond_" + label;
		cg.printLabel(condLabel);
		
		// '#line {condition.start.line}'
		if(fromStmt.getCondition().start()!=null) {
			cg.line(fromStmt.getCondition().start().getLine());
		}
		// value⟦condition⟧
		value(fromStmt.getCondition());
		
		// JNZ {endLabel}
		String endLabel = "FromEnd_" + label;
		cg.jnz(endLabel);
		
		// stmts*.foreach(s => execute⟦s⟧(localBytes, paramBytes))
		fromStmt.getStmts().forEach(s -> execute(s, param)); // !) Pasamos el contexto
		
		// JMP {condLabel}
		cg.jmp(condLabel);
		
		// {endLabel}:
		cg.printLabel(endLabel);
		return null;
	}

	// class ProcedureStmt(Procedure procedure)
	// phase TypeChecking { Feature feature, boolean returnable }
	@Override
	public Object visit(ProcedureStmt procedureStmt, Object param) {
		// '#line {procedureStmt.start.line}'
		if(procedureStmt.start()!=null) {
			cg.line(procedureStmt.start().getLine());
		}
		
		Procedure procedure = procedureStmt.getProcedure();
		// procedure.expression*.foreach(arg => value⟦arg⟧)
		procedure.getExpressions().forEach(arg -> value(arg));
		
		// CALL {procedure.name}
		cg.call(procedure.getName());
		
		// if(procedure.invocation.returnType != null) POP<...>
		Feature calledFeature = procedure.getInvocation();
		if(calledFeature != null && calledFeature.getReturntype()!= null 
				&& !(calledFeature.getReturntype() instanceof VoidType)) {
			
			cg.pop(calledFeature.getReturntype());
		}
		return null;
	}

	// class ReturnStmt(ReturnInvoc returnInvoc)
	// phase TypeChecking { Feature feature, boolean returnable }
	@Override
	public Object visit(ReturnStmt returnStmt, Object param) {
		// '#line {returnStmt.start.line}'
		if(returnStmt.start()!=null) {
			cg.line(returnStmt.start().getLine());
		}
		// execute⟦returnInvoc⟧ ({localBytes}, {paramBytes})
		execute(returnStmt.getReturnInvoc(), param); // !) Pasamos el contexto recibido a ReturnInvoc
		return null;
	}

}
