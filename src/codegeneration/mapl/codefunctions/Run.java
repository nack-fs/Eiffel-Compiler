// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.*;
import codegeneration.mapl.*;


public class Run extends AbstractCodeFunction {
	private CodeGenerator cg = CodeGenerator.getInstance();

    public Run(MaplCodeSpecification specification) {
        super(specification);
    }


	// class Program(ClassDef classDef, Optional<Global> global, Create create, List<Feature> features, RunInvocation runInvocation)
	@Override
	public Object visit(Program program, Object param) {
		// Generamos metadatos iniciales (#source, #type, #global)
		metadata(program);
		
		cg.comment("Inicio del programa");
		
		execute(program.getRunInvocation());
		
		// Generamos HALT para detener la ejecución después de que 'run' retorne
		cg.halt();
		
		cg.comment("Definiciones de funciones");
		
		// Generamos el código de todas las features
		program.getFeatures().forEach(feature -> execute(feature));
		
		cg.comment("Fin del programa MAPL");
		
		return null;
	}

}
