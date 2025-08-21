// Generated with VGen 2.0.0

package ast;

import ast.datatype.*;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	varDefinition -> name:string type:dataType
	
	PHASE Identification
	varDefinition -> scope:string
	
	PHASE MemoryAllocation
	varDefinition -> address:int
*/
public class VarDefinition extends AbstractAST  {

    // ----------------------------------
    // Instance Variables

	// varDefinition -> name:string type:dataType
	private String name;
	private DataType type;

    // PHASE Identification
	private String scope;

    // PHASE MemoryAllocation
	private int address;

    // ----------------------------------
    // Constructors

	public VarDefinition(String name, DataType type) {
		super();

		if (name == null)
			throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = name;

		if (type == null)
			throw new IllegalArgumentException("Parameter 'type' can't be null. Pass a non-null value or use 'dataType?' in the abstract grammar");
		this.type = type;

		updatePositions(name, type);
	}

	public VarDefinition(Object name, Object type) {
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
    // varDefinition -> name:string type:dataType

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

	// Attribute 'scope:string' 

	public void setScope(String scope) {
		if (scope == null)
			throw new IllegalArgumentException("Parameter 'scope' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.scope = scope;

	}

    public String getScope() {
        return scope;
    }



    // --------------------------------
    // PHASE MemoryAllocation

	// Attribute 'address:int' 

	public void setAddress(int address) {
		this.address = address;

	}

    public int getAddress() {
        return address;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "VarDefinition{" + " name=" + this.getName() + " type=" + this.getType() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
