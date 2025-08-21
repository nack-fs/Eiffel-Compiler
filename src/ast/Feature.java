// Generated with VGen 2.0.0

package ast;

import ast.datatype.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.Optional;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	feature -> name:string params:varDefinition* dataType:dataType? localBlock:localBlock? doBlock:doBlock
	
	PHASE TypeChecking
	feature -> returntype:dataType
	feature -> constructor:boolean
*/
public class Feature extends AbstractAST  {

    // ----------------------------------
    // Instance Variables

	// feature -> name:string params:varDefinition* dataType? localBlock? doBlock
	private String name;
	private List<VarDefinition> params;
	private Optional<DataType> dataType;
	private Optional<LocalBlock> localBlock;
	private DoBlock doBlock;

    // PHASE TypeChecking
	private DataType returntype;
	private boolean constructor;

    // ----------------------------------
    // Constructors

	public Feature(String name, List<VarDefinition> params, Optional<DataType> dataType, Optional<LocalBlock> localBlock, DoBlock doBlock) {
		super();

		if (name == null)
			throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = name;

		if (params == null)
			params = new ArrayList<>();
		this.params = params;

		if (dataType == null)
			dataType = Optional.empty();
		this.dataType = dataType;

		if (localBlock == null)
			localBlock = Optional.empty();
		this.localBlock = localBlock;

		if (doBlock == null)
			throw new IllegalArgumentException("Parameter 'doBlock' can't be null. Pass a non-null value or use 'doBlock?' in the abstract grammar");
		this.doBlock = doBlock;

		updatePositions(name, params, dataType, localBlock, doBlock);
	}

	public Feature(Object name, Object params, Object dataType, Object localBlock, Object doBlock) {
		super();

        if (name == null)
            throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;

        this.params = castList(params, unwrapIfContext.andThen(VarDefinition.class::cast));
        this.dataType = castOptional(dataType, DataType.class);
        this.localBlock = castOptional(localBlock, LocalBlock.class);
        if (doBlock == null)
            throw new IllegalArgumentException("Parameter 'doBlock' can't be null. Pass a non-null value or use 'doBlock?' in the abstract grammar");
		this.doBlock = (DoBlock) doBlock;

		updatePositions(name, params, dataType, localBlock, doBlock);
	}


    // ----------------------------------
    // feature -> name:string params:varDefinition* dataType? localBlock? doBlock

	// Child 'name:string' 

	public void setName(String name) {
		if (name == null)
			throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = name;

	}

    public String getName() {
        return name;
    }


	// Child 'params:varDefinition*' 

	public void setParams(List<VarDefinition> params) {
		if (params == null)
			params = new ArrayList<>();
		this.params = params;

	}

    public List<VarDefinition> getParams() {
        return params;
    }

    public Stream<VarDefinition> params() {
        return params.stream();
    }


	// Child 'dataType?' 

	public void setDataType(Optional<DataType> dataType) {
		if (dataType == null)
			dataType = Optional.empty();
		this.dataType = dataType;

	}

    public Optional<DataType> getDataType() {
        return dataType;
    }


	// Child 'localBlock?' 

	public void setLocalBlock(Optional<LocalBlock> localBlock) {
		if (localBlock == null)
			localBlock = Optional.empty();
		this.localBlock = localBlock;

	}

    public Optional<LocalBlock> getLocalBlock() {
        return localBlock;
    }


	// Child 'doBlock' 

	public void setDoBlock(DoBlock doBlock) {
		if (doBlock == null)
			throw new IllegalArgumentException("Parameter 'doBlock' can't be null. Pass a non-null value or use 'doBlock?' in the abstract grammar");
		this.doBlock = doBlock;

	}

    public DoBlock getDoBlock() {
        return doBlock;
    }



    // --------------------------------
    // PHASE TypeChecking

	// Attribute 'returntype:dataType' 

	public void setReturntype(DataType returntype) {
		if (returntype == null)
			throw new IllegalArgumentException("Parameter 'returntype' can't be null. Pass a non-null value or use 'dataType?' in the abstract grammar");
		this.returntype = returntype;

	}

    public DataType getReturntype() {
        return returntype;
    }


	// Attribute 'constructor:boolean' 

	public void setConstructor(boolean constructor) {
		this.constructor = constructor;

	}

    public boolean isConstructor() {
        return constructor;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Feature{" + " name=" + this.getName() + " params=" + this.getParams() + " dataType=" + this.getDataType() + " localBlock=" + this.getLocalBlock() + " doBlock=" + this.getDoBlock() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
