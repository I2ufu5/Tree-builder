package drzewko.Build;

import drzewko.Validate.HeightValidator;
import drzewko.Validate.LeafValidator;

public abstract class Builder {
    protected int height;
    protected char leaf;
    protected String[] builtTreeContainer;

    public String[] getBuiltTreeContainer() {
        return builtTreeContainer;
    }

    public Builder(int height, char leaf){
        HeightValidator heightValidator = new HeightValidator();
        if (!heightValidator.validate(height)) {
            throw new IllegalArgumentException();
        }
        this.height = height;
        LeafValidator leafValidator = new LeafValidator();
        if (!leafValidator.validate(leaf)) {
            throw new IllegalArgumentException();
        }
        this.leaf = leaf;
    }

    public abstract void buildTree();

}
