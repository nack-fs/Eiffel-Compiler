package codegeneration;

import visitor.DefaultVisitor;

import java.util.List;

import ast.*;
import ast.stmt.*;
import ast.expression.*;
import ast.datatype.*;


public class MemoryAllocation extends DefaultVisitor {
	
    private int currentGlobalOffset = 0;
    private int currentFieldOffset = 0;

    public void process(AST ast) {
        ast.accept(this, null);
    }

    // Visit Methods --------------------------------------------------------------

	// class Program(ClassDef classDef, Optional<Global> global, Create create, List<Feature> features, RunInvocation runInvocation)
	@Override
	public Object visit(Program program, Object param) {
		// Calculamos el offset de los campos en Structs
		if(program.getGlobal().isPresent() && program.getGlobal().get().getGlobalTypes().isPresent()) {
			program
				.getGlobal().get()
				.getGlobalTypes().get()
				.accept(this, null);
		}
		
		// Calculamos las direcciones de las variables GLOBAL
		currentGlobalOffset=0;
		if(program.getGlobal().isPresent() && program.getGlobal().get().getVarsTypes().isPresent()) {
			program
				.getGlobal().get()
				.getVarsTypes().get()
				.accept(this, null);
		}
		
		// Calculamos los offsets de variables PARAMETER y LOCAL para cada feature
		for(Feature feature : program.getFeatures()) {
			feature.accept(this, null);
		}
		return null;
	}

	// class Feature(String name, List<VarDefinition> params, Optional<DataType> dataType, Optional<LocalBlock> localBlock, DoBlock doBlock)
	// phase TypeChecking { DataType returntype, boolean constructor }
	@Override
	public Object visit(Feature feature, Object param) {

		// -------- Calculamos offset de PARÁMETROS y establecemos address -----------
		int paramOffset = 4; // Offset inicial para parámetros
		List<VarDefinition> params = feature.getParams();
		
		// De izquierda a derecha
		for(int i=params.size()-1; i>=0; i--) {
			VarDefinition par = params.get(i);
			par.setAddress(paramOffset); // El offset es el acumulado hasta ahora
			paramOffset += par.getType().getMemorySize(); // El siguiente tendrá el offset acumulado + tamaño de este param
		}
		
		// -------- Calculamos offset de VARIABLES LOCALES y establecemos address -----------
		int localOffset = 0;
		if(feature.getLocalBlock().isPresent()) {
			for(VarDefinition vd : feature.getLocalBlock().get().getVarDefinitions()) {
				localOffset -= vd.getType().getMemorySize(); // Decrementamos el tamaño
				vd.setAddress(localOffset); // Asignamos el offset
				vd.getType().accept(this, null);
			}
		}
		
		// Visitamos el doBlock
		feature.getDoBlock().accept(this, null);
		return null;
	}

	// class VarsTypes(List<VarDefinition> varDefinitions)
	@Override
	public Object visit(VarsTypes varsTypes, Object param) {
		// Calculamos el offset de las variables globales y establecemos la dirección de memoria
		for (var varDefinition : varsTypes.getVarDefinitions()) {
			varDefinition.setAddress(currentGlobalOffset); // Asignamos el offset actual
			currentGlobalOffset += varDefinition.getType().getMemorySize(); // Actualizamos el offset global
			varDefinition.getType().accept(this, null);
		}
		return null;
	}

	// class Deftuple(String name, List<Field> fields)
	@Override
	public Object visit(Deftuple deftuple, Object param) {
		// Calculamos el offset de los campos
		currentFieldOffset=0;
		for(Field field : deftuple.getFields()) {
			field.setOffset(currentFieldOffset); // Asignamos el offset actual
			currentFieldOffset += field.getType().getMemorySize(); // Actualizamos el offset del campo
			field.getType().accept(this, null);
		}
		return null;
	}

}
