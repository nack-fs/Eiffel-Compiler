// Generated with VGen 2.0.0

package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.Optional;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	program -> classDef:classDef global:global? create:create features:feature* runInvocation:runInvocation
*/
public class Program extends AbstractAST  {

    // ----------------------------------
    // Instance Variables

	// program -> classDef global? create feature* runInvocation
	private ClassDef classDef;
	private Optional<Global> global;
	private Create create;
	private List<Feature> features;
	private RunInvocation runInvocation;

    // ----------------------------------
    // Constructors

	public Program(ClassDef classDef, Optional<Global> global, Create create, List<Feature> features, RunInvocation runInvocation) {
		super();

		if (classDef == null)
			throw new IllegalArgumentException("Parameter 'classDef' can't be null. Pass a non-null value or use 'classDef?' in the abstract grammar");
		this.classDef = classDef;

		if (global == null)
			global = Optional.empty();
		this.global = global;

		if (create == null)
			throw new IllegalArgumentException("Parameter 'create' can't be null. Pass a non-null value or use 'create?' in the abstract grammar");
		this.create = create;

		if (features == null)
			features = new ArrayList<>();
		this.features = features;

		if (runInvocation == null)
			throw new IllegalArgumentException("Parameter 'runInvocation' can't be null. Pass a non-null value or use 'runInvocation?' in the abstract grammar");
		this.runInvocation = runInvocation;

		updatePositions(classDef, global, create, features, runInvocation);
	}

	public Program(Object classDef, Object global, Object create, Object features, Object runInvocation) {
		super();

        if (classDef == null)
            throw new IllegalArgumentException("Parameter 'classDef' can't be null. Pass a non-null value or use 'classDef?' in the abstract grammar");
		this.classDef = (ClassDef) classDef;

        this.global = castOptional(global, Global.class);
        if (create == null)
            throw new IllegalArgumentException("Parameter 'create' can't be null. Pass a non-null value or use 'create?' in the abstract grammar");
		this.create = (Create) create;

        this.features = castList(features, unwrapIfContext.andThen(Feature.class::cast));
        if (runInvocation == null)
            throw new IllegalArgumentException("Parameter 'runInvocation' can't be null. Pass a non-null value or use 'runInvocation?' in the abstract grammar");
		this.runInvocation = (RunInvocation) runInvocation;

		updatePositions(classDef, global, create, features, runInvocation);
	}


    // ----------------------------------
    // program -> classDef global? create feature* runInvocation

	// Child 'classDef' 

	public void setClassDef(ClassDef classDef) {
		if (classDef == null)
			throw new IllegalArgumentException("Parameter 'classDef' can't be null. Pass a non-null value or use 'classDef?' in the abstract grammar");
		this.classDef = classDef;

	}

    public ClassDef getClassDef() {
        return classDef;
    }


	// Child 'global?' 

	public void setGlobal(Optional<Global> global) {
		if (global == null)
			global = Optional.empty();
		this.global = global;

	}

    public Optional<Global> getGlobal() {
        return global;
    }


	// Child 'create' 

	public void setCreate(Create create) {
		if (create == null)
			throw new IllegalArgumentException("Parameter 'create' can't be null. Pass a non-null value or use 'create?' in the abstract grammar");
		this.create = create;

	}

    public Create getCreate() {
        return create;
    }


	// Child 'feature*' 

	public void setFeatures(List<Feature> features) {
		if (features == null)
			features = new ArrayList<>();
		this.features = features;

	}

    public List<Feature> getFeatures() {
        return features;
    }

    public Stream<Feature> features() {
        return features.stream();
    }


	// Child 'runInvocation' 

	public void setRunInvocation(RunInvocation runInvocation) {
		if (runInvocation == null)
			throw new IllegalArgumentException("Parameter 'runInvocation' can't be null. Pass a non-null value or use 'runInvocation?' in the abstract grammar");
		this.runInvocation = runInvocation;

	}

    public RunInvocation getRunInvocation() {
        return runInvocation;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Program{" + " classDef=" + this.getClassDef() + " global=" + this.getGlobal() + " create=" + this.getCreate() + " features=" + this.getFeatures() + " runInvocation=" + this.getRunInvocation() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
