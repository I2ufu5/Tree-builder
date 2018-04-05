package drzewko.Build;

public class UpBuilder extends Builder{

    public UpBuilder(int height, char leaf) {
        super(height,leaf);
    }

    public void buildTree() {
        builtTreeContainer = new String[height];

        for (int i = 0; i < height; i++) {
            builtTreeContainer[i] = "";

            for (int j = height - i; 0 <= j; j--) {
                builtTreeContainer[i] += " ";
            }
            for (int h = height - i * 2; h <= height; h++) {
                builtTreeContainer[i] += leaf;
            }

        }
    }
}
