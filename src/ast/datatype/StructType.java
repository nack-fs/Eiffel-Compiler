// Generated with VGen 2.0.0

package ast.datatype;

import ast.*;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	structType: dataType -> name:string
	dataType -> 
	
	PHASE Identification
	structType -> deftuple:deftuple
*/
public class StructType extends AbstractDataType  {

    // ----------------------------------
    // Instance Variables

	// structType: dataType -> name:string
	private String name;

    // PHASE Identification
	private Deftuple deftuple;

    // ----------------------------------
    // Constructors

	public StructType(String name) {
		super();

		if (name == null)
			throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = name;

		updatePositions(name);
	}

	public StructType(Object name) {
		super();

        if (name == null)
            throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;

		updatePositions(name);
	}


    // ----------------------------------
    // structType: dataType -> name:string

	// Child 'name:string' 

	public void setName(String name) {
		if (name == null)
			throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = name;

	}

    public String getName() {
        return name;
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


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "StructType{" + " name=" + this.getName() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed
	    @Override
		public String getTypeName() {
			return "struct";
		}
	    
	    @Override
	    public int getMemorySize() {
	    	if(this.deftuple == null) {return 0;}
	    	
	    	int total=0;
	    	for(Field field : this.deftuple.getFields()) {
	    		total += field.getType().getMemorySize();
	    	}
	    	return total;
	    }

    // %% --------------------------------------
}
