package drzewko.Build;

public class RightBuilder extends Builder {
    private String[] builtTreeContainer;

    public String[] getBuiltTreeContainer() {
        return builtTreeContainer;
    }

    public RightBuilder(int height, char leaf) {
        super(height,leaf);
    }

    public void buildTree() {
        builtTreeContainer = new String[height*2-1];

        for(int i=0; i<height; i++){
            builtTreeContainer[i] = "";
            for(int h=0; h<=i; h++){
                builtTreeContainer[i] += leaf;
            }
            for(int j = height-i; 0 < j; j--){
                builtTreeContainer[i] += " ";
            }
        }
        for(int i=height; i>0; i--){
            builtTreeContainer[i+height-2] = "";
            for(int j = height-i; 0 <= j; j--){
                builtTreeContainer[i+height-2] += leaf;
            }
            for(int h=1; h<=i; h++){
                builtTreeContainer[i+height-2] += " ";
            }
        }
    }
}
