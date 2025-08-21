// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.*;
import codegeneration.mapl.*;


public class Metadata extends AbstractCodeFunction {
	private CodeGenerator cg = CodeGenerator.getInstance();

    public Metadata(MaplCodeSpecification specification) {
        super(specification);
    }


	// class Program(ClassDef classDef, Optional<Global> global, Create create, List<Feature> features, RunInvocation runInvocation)
	@Override
	public Object visit(Program program, Object param) {
		// '#source "{program.sourceFile}"'
		cg.source();
		
		// metadata⟦global⟧
		metadata(program.getGlobal());
		return null;
	}

	// class Global(Optional<GlobalTypes> globalTypes, Optional<VarsTypes> varsTypes)
	@Override
	public Object visit(Global global, Object param) {
		// metadata⟦globalTypes⟧
		global.getGlobalTypes().ifPresent(gt -> metadata(gt));
		// metadata⟦varsTypes⟧
		global.getVarsTypes().ifPresent(vt -> metadata(vt));
		return null;
	}

	// class GlobalTypes(List<Deftuple> deftuples)
	@Override
	public Object visit(GlobalTypes globalTypes, Object param) {
		// deftuple*.foreach(dt => metadata⟦dt⟧)
		globalTypes.deftuples().forEach(dt -> metadata(dt));
		return null;
	}

	// class VarsTypes(List<VarDefinition> varDefinitions)
	@Override
	public Object visit(VarsTypes varsTypes, Object param) {
		// varDefinition*.foreach(vd => metadata⟦vd⟧)
		varsTypes.varDefinitions().forEach(vd -> metadata(vd));
		return null;
	}

	// class Deftuple(String name, List<Field> fields)
	@Override
	public Object visit(Deftuple deftuple, Object param) {
		// '#type {name} : {' + field*.map(f => metadata⟦f⟧).join(", ") + '}'
		cg.type(deftuple);
		
		return null;
	}

	// class VarDefinition(String name, DataType type)
	// phase Identification { String scope }
	// phase MemoryAllocation { int address }
	@Override
	public Object visit(VarDefinition varDefinition, Object param) {
		// if(varDefinition.scope == GLOBAL) '#global {name} : {getMAPLTypeName(type)} (offset {address})'
		if(varDefinition.getScope().equals(CodeGenerator.Scope.GLOBAL.toString())) {
			cg.global(varDefinition.getName(), varDefinition.getType(), varDefinition.getAddress());
		}
		return null;
	}

}
