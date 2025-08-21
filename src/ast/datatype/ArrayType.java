// Generated with VGen 2.0.0

package ast.datatype;

import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	arrayType: dataType -> size:string dataType:dataType
	dataType -> 
*/
public class ArrayType extends AbstractDataType  {

    // ----------------------------------
    // Instance Variables

	// arrayType: dataType -> size:string dataType
	private String size;
	private DataType dataType;

    // ----------------------------------
    // Constructors

	public ArrayType(String size, DataType dataType) {
		super();

		if (size == null)
			throw new IllegalArgumentException("Parameter 'size' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.size = size;

		if (dataType == null)
			throw new IllegalArgumentException("Parameter 'dataType' can't be null. Pass a non-null value or use 'dataType?' in the abstract grammar");
		this.dataType = dataType;

		updatePositions(size, dataType);
	}

	public ArrayType(Object size, Object dataType) {
		super();

        if (size == null)
            throw new IllegalArgumentException("Parameter 'size' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.size = (size instanceof Token) ? ((Token) size).getText() : (String) size;

        if (dataType == null)
            throw new IllegalArgumentException("Parameter 'dataType' can't be null. Pass a non-null value or use 'dataType?' in the abstract grammar");
		this.dataType = (DataType) dataType;

		updatePositions(size, dataType);
	}


    // ----------------------------------
    // arrayType: dataType -> size:string dataType

	// Child 'size:string' 

	public void setSize(String size) {
		if (size == null)
			throw new IllegalArgumentException("Parameter 'size' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.size = size;

	}

    public String getSize() {
        return size;
    }


	// Child 'dataType' 

	public void setDataType(DataType dataType) {
		if (dataType == null)
			throw new IllegalArgumentException("Parameter 'dataType' can't be null. Pass a non-null value or use 'dataType?' in the abstract grammar");
		this.dataType = dataType;

	}

    public DataType getDataType() {
        return dataType;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "ArrayType{" + " size=" + this.getSize() + " dataType=" + this.getDataType() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed
	    @Override
		public String getTypeName() {
			return "array";
		}
	    
	    @Override
	    public int getMemorySize() {
	    	// Calculamos el tamaño del array
	    	int numberOfElements = Integer.parseInt(this.size);
	    	
	    	// Obtenemos el tamaño del tipo base
	    	int elementSize = this.dataType.getMemorySize();
	    	
	    	return numberOfElements * elementSize;
	    }

    // %% --------------------------------------
}
