// Generated with VGen 2.0.0

package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	create -> idents:string*
*/
public class Create extends AbstractAST  {

    // ----------------------------------
    // Instance Variables

	// create -> idents:string*
	private List<String> idents;

    // ----------------------------------
    // Constructors

	public Create(List<String> idents) {
		super();

		if (idents == null)
			idents = new ArrayList<>();
		this.idents = idents;

		updatePositions(idents);
	}

	public Create(Object idents) {
		super();

        this.idents = castList(idents,
            unwrapIfContext
            .andThen(unwrapIfToken)
            .andThen(String.class::cast));

		updatePositions(idents);
	}


    // ----------------------------------
    // create -> idents:string*

	// Child 'idents:string*' 

	public void setIdents(List<String> idents) {
		if (idents == null)
			idents = new ArrayList<>();
		this.idents = idents;

	}

    public List<String> getIdents() {
        return idents;
    }

    public Stream<String> idents() {
        return idents.stream();
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Create{" + " idents=" + this.getIdents() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
