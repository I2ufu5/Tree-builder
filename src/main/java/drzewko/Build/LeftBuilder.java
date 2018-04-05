package drzewko.Build;

public class LeftBuilder extends Builder{

     public LeftBuilder(int height, char leaf) {
         super(height,leaf);
    }

    public void buildTree() {
        builtTreeContainer = new String[height*2-1];

        for(int i=0; i<height; i++){
            builtTreeContainer[i] = "";
            for(int j = height-i; 0 < j; j--){
                builtTreeContainer[i] += " ";
            }
            for(int h=0; h<=i; h++){
                builtTreeContainer[i] += leaf;
            }
        }
        for(int i=height; i>0; i--){
            builtTreeContainer[i+height-2] = "";
            for(int h=1; h<=i; h++){
                builtTreeContainer[i+height-2] += " " ;
            }
            for(int j = height-i; 0 <= j; j--){
                builtTreeContainer[i+height-2] += leaf;
            }
        }
    }
}
