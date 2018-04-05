package drzewko.Build;

public class DownBuilder extends Builder {

    public DownBuilder(int height, char leaf) {
        super(height,leaf);
    }

    public void buildTree() {
        builtTreeContainer = new String[height];

        for(int i=0; i<height; i++){
            builtTreeContainer[i] = "";

            for(int h=height-i; h<=height; h++){
                builtTreeContainer[i] += " ";
            }
            for(int j = height*2-i*2-1; 0 < j; j--){
                builtTreeContainer[i] += leaf;
            }

        }
    }
}
