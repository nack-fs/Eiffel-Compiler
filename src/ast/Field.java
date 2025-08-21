// Generated with VGen 2.0.0

package ast;

import ast.datatype.*;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	field -> name:string type:dataType
	
	PHASE Identification
	field -> deftuple:deftuple
	
	PHASE MemoryAllocation
	field -> offset:int
*/
public class Field extends AbstractAST  {

    // ----------------------------------
    // Instance Variables

	// field -> name:string type:dataType
	private String name;
	private DataType type;

    // PHASE Identification
	private Deftuple deftuple;

    // PHASE MemoryAllocation
	private int offset;

    // ----------------------------------
    // Constructors

	public Field(String name, DataType type) {
		super();

		if (name == null)
			throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = name;

		if (type == null)
			throw new IllegalArgumentException("Parameter 'type' can't be null. Pass a non-null value or use 'dataType?' in the abstract grammar");
		this.type = type;

		updatePositions(name, type);
	}

	public Field(Object name, Object type) {
		super();

        if (name == null)
            throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;

        if (type == null)
            throw new IllegalArgumentException("Parameter 'type' can't be null. Pass a non-null value or use 'dataType?' in the abstract grammar");
		this.type = (DataType) type;

		updatePositions(name, type);
	}


    // ----------------------------------
    // field -> name:string type:dataType

	// Child 'name:string' 

	public void setName(String name) {
		if (name == null)
			throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = name;

	}

    public String getName() {
        return name;
    }


	// Child 'type:dataType' 

	public void setType(DataType type) {
		if (type == null)
			throw new IllegalArgumentException("Parameter 'type' can't be null. Pass a non-null value or use 'dataType?' in the abstract grammar");
		this.type = type;

	}

    public DataType getType() {
        return type;
    }



    // --------------------------------
    // PHASE Identification

	// Attribute 'deftuple' 

	public void setDeftuple(Deftuple deftuple) {
		if (deftuple == null)
			throw new IllegalArgumentException("Parameter 'deftuple' can't be null. Pass a non-null value or use 'deftuple?' in the abstract grammar");
		this.deftuple = deftuple;

	}

    public Deftuple getDeftuple() {
        return deftuple;
    }



    // --------------------------------
    // PHASE MemoryAllocation

	// Attribute 'offset:int' 

	public void setOffset(int offset) {
		this.offset = offset;

	}

    public int getOffset() {
        return offset;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Field{" + " name=" + this.getName() + " type=" + this.getType() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
