// Generated with VGen 2.0.0

package ast.datatype;

import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	integerType: dataType -> 
	dataType -> 
*/
public class IntegerType extends AbstractDataType  {



    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "IntegerType{" + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed
	    @Override
		public String getTypeName() {
			return "integer";
		}
	    
	    @Override
	    public int getMemorySize() {
	    	return 2; // 2 Bytes
	    }

    // %% --------------------------------------
}
