package semantic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ast.*;
import ast.stmt.*;
import ast.expression.*;
import ast.datatype.*;
import main.ErrorManager;
import visitor.DefaultVisitor;

// This class will be implemented in identification phase

public class Identification extends DefaultVisitor {

    private ErrorManager errorManager;
    private ContextMap<String, VarDefinition> varTable = new ContextMap<>();
    private Map<String, Deftuple> deftuples = new HashMap<>();
    private Map<String, Feature> features = new HashMap<>();
    private Set<String> constructor = new HashSet<>();

    private Create createNode = null;

    public enum Scope { GLOBAL, LOCAL, PARAMETER }

    public Identification(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }

    public void process(AST ast) {
        ast.accept(this, null);
    }

    // Visit Methods --------------------------------------------------------------

    // class Program(ClassDef classDef, Optional<Global> global, Create create, List<Feature> features, RunInvocation runInvocation)
 	@Override
 	public Object visit(Program program, Object param) {
 		varTable.set(); // [SET - Ámbito GLOBAL]

 		super.visit(program, param);

 		// Comprobamos si quedan features en la lista de constructores que no se definieron
 		predicate(createNode == null || constructor.isEmpty(),
 				"Las siguientes features listadas en 'create' no fueron definidas: "+
 						String.join(", ", constructor),
 				program.end());

 		// Marcamos las features que son constructores, es decir las que estaban en 'create' y si se definieron
 		if (createNode != null) {
 			for(String name: createNode.getIdents()) {
 				Feature feature = features.get(name);
 				if(feature != null) {
 					// Marcamos la feature como constructor
 					feature.setConstructor(true);
 				}
 			}
 		}

 		varTable.reset(); // [RESET - Ámbito GLOBAL]
 		return null;
 	}

 	// class Variable(String name)
 	// phase Identification { VarDefinition definition }
 	@Override
 	public Object visit(Variable variable, Object param) {
 		VarDefinition definition = varTable.getFromAny(variable.getName());
 		// Comprobamos que la variable haya sido declarada
 		if (predicate(definition != null,
 				"La variable '" + variable.getName() + "' no ha sido declarada",
 				variable)) {
 			// Enlazamos a la definción de la variable
 			variable.setDefinition(definition);
 		}
 		return null;
 	}

 	// class Procedure(String name, List<Expression> expressions)
 	// phase Identification { Feature invocation }
 	@Override
 	public Object visit(Procedure procedure, Object param) {
 		super.visit(procedure, param);

 		// Comprobamos que la invocación sea a una feature existente
 		Feature definition = features.get(procedure.getName());
 		if (predicate(definition != null,
 				"La feature '" + procedure.getName() + "' invocada no existe",
 				procedure)) {
 			// Enlazamos la invocación a la feature
 			procedure.setInvocation(definition);
 		}
 		return null;
 	}

 	// class StructType(String name)
 	// phase Identification { Deftuple deftuple }
 	@Override
 	public Object visit(StructType structType, Object param) {
 		Deftuple definition = deftuples.get(structType.getName());
 		if (predicate(definition != null,
 				"El tipo deftuple '" + structType.getName() + "' no ha sido definido",
 				structType)) {
 			structType.setDeftuple(definition);
 		}
 		return null;
 	}

 	// class Create(List<String> idents)
 	@Override
 	public Object visit(Create create, Object param) {
 		this.createNode = create;
 		Set<String> names = new HashSet<>();

 		for (String featureName : create.getIdents()) {
 			// Comprobamos que no haya elementos repetidos en esta lista de constructores
 			if (!names.add(featureName)) {
 				predicate(false,
 	 					"La feature '" + featureName + "' aparece múltiples veces en el 'create'",
 	 					create);
 			} else {
 				constructor.add(featureName);
 			}
 		}
 		return null;
 	}

 	// class Feature(String name, List<VarDefinition> params, Optional<DataType> dataType, Optional<LocalBlock> localBlock, DoBlock doBlock)
 	@Override
 	public Object visit(Feature feature, Object param) {
 		// Comprobamos que no existan declaraciones de features ya declaradas
 		if (features.containsKey(feature.getName())) {
 			predicate(false, "La feature '" + feature.getName() + "' ya ha sido declarada", feature);
 		} else {
 			features.put(feature.getName(), feature);
 			// Al definirla la quitamos de la lista constructors
            constructor.remove(feature.getName());
 		}

 		varTable.set(); // [SET - Ámbito Feature]
 		Set<String> names = new HashSet<>();

 		// ---------- PARAMETERS -----------
 		for (VarDefinition vd : feature.getParams()) {
 			vd.setScope(Scope.PARAMETER.toString());

 			// Comprobamos que no existan parámetros duplicados dentro de la feature
 			if (!names.add(vd.getName())) {
 				predicate(false, "Parámetro '" + vd.getName() + "' repetido en la feature '" + feature.getName() + "'", vd);
 			} else {
 				varTable.put(vd.getName(), vd);
 			}
 		}

 		// ---------- LOCALS -----------
 		if (feature.getLocalBlock().isPresent()) {
 			for (VarDefinition vd : feature.getLocalBlock().get().getVarDefinitions()) {
 				vd.setScope(Scope.LOCAL.toString());

 				// Comprobamos que no existan duplicados con locales y parámetros
 				if (!names.add(vd.getName())) {
 					predicate(false, "Variable local '" + vd.getName() + "' repetida o choca con un parámetro en la feature '" + feature.getName() + "'", vd);
 				} else {
 					varTable.put(vd.getName(), vd);
 				}
 			}
 		}
 		super.visit(feature, param);

 		varTable.reset(); // [RESET - Ámbito Feature]
 		return null;
 	}

 	// class VarsTypes(List<VarDefinition> varDefinitions)
 	@Override
 	public Object visit(VarsTypes varsTypes, Object param) {
 		for(VarDefinition vd: varsTypes.getVarDefinitions()) {
 			vd.setScope(Scope.GLOBAL.toString());

 			// Comprobamos si hay variables duplicadas en el ámbito global
 			if (varTable.getFromTop(vd.getName()) != null) {
 				predicate(false, "La variable global '" + vd.getName() + "' ya ha sido declarada", vd);
 			} else {
 				varTable.put(vd.getName(), vd);
 			}
 		}
 		super.visit(varsTypes, param);
 		
 		return null;
 	}

 	// class Deftuple(String name, List<Field> fields)
 	@Override
 	public Object visit(Deftuple deftuple, Object param) {
 		// Comprobar que la deftuple no exista ya
 		if (deftuples.containsKey(deftuple.getName())) {
            predicate(false, "La deftuple '" + deftuple.getName() + "' ya existe", deftuple);
        } else {
 			deftuples.put(deftuple.getName(), deftuple);
 		}

 		Set<String> names = new HashSet<>();
 		for(Field field : deftuple.getFields()) {
 			// Comprobamos que no haya campos duplicados
 			if (!names.add(field.getName())) {
 				predicate(false, "Campo '" + field.getName() + "' repetido en la deftuple '" + deftuple.getName() + "'", field);
 			} else {
 				// Ascociamos el field a su deftuple padre
 				field.setDeftuple(deftuple);
 			}
 		}
 		super.visit(deftuple, param);
 		
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
}