// Generated with VGen 2.0.0

package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	deftuple -> name:string fields:field*
*/
public class Deftuple extends AbstractAST  {

    // ----------------------------------
    // Instance Variables

	// deftuple -> name:string field*
	private String name;
	private List<Field> fields;

    // ----------------------------------
    // Constructors

	public Deftuple(String name, List<Field> fields) {
		super();

		if (name == null)
			throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = name;

		if (fields == null)
			fields = new ArrayList<>();
		this.fields = fields;

		updatePositions(name, fields);
	}

	public Deftuple(Object name, Object fields) {
		super();

        if (name == null)
            throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;

        this.fields = castList(fields, unwrapIfContext.andThen(Field.class::cast));
		updatePositions(name, fields);
	}


    // ----------------------------------
    // deftuple -> name:string field*

	// Child 'name:string' 

	public void setName(String name) {
		if (name == null)
			throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = name;

	}

    public String getName() {
        return name;
    }


	// Child 'field*' 

	public void setFields(List<Field> fields) {
		if (fields == null)
			fields = new ArrayList<>();
		this.fields = fields;

	}

    public List<Field> getFields() {
        return fields;
    }

    public Stream<Field> fields() {
        return fields.stream();
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Deftuple{" + " name=" + this.getName() + " fields=" + this.getFields() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
