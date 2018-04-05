package drzewko;

import drzewko.Build.*;
import drzewko.Validate.HeightValidator;
import drzewko.Validate.LeafValidator;

import java.util.Scanner;

import static drzewko.Direction.*;


public class Tree{
    private int height;
    private char leaf;
    private Direction direction;
    private String[] treeContainer;

    public Tree(int height, char leaf, Direction dir) {
        this.height = height;
        this.leaf = leaf;
        this.direction = dir;
        buildTree();
    }

    public void drawTree(){
        for(String line:treeContainer){
            System.out.println(line);
        }
    }

    public void rotateTree(){
            Scanner scan = new Scanner(System.in);
            System.out.println("Chose orientation od tree ");
            System.out.println("1 for upwards");
            System.out.println("2 for downwards");
            System.out.println("3 for leftwards");
            System.out.println("4 for rightwards");
            int choice = scan.nextInt();
            switch (choice){
                case 1:
                    this.direction = UP;
                    break;
                case 2:
                    this.direction = DOWN;
                    break;
                case 3:
                    this.direction = LEFT;
                    break;
                case 4:
                    this.direction = RIGHT;
                    break;
                default:
                    System.out.println("Not expected value");
                    break;
            }
            buildTree();

    }

    public void changeTreeHeight(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Type new height");
        int height = scan.nextInt();
        HeightValidator validator = new HeightValidator();
        try {
            if (validator.validate(this.height)) {
                this.height = height;
                this.buildTree();
                System.out.println("Changed height, and rebuilt tree");
            }
        }catch (IllegalArgumentException e){
        }
    }

    public void changeTreeLeaf(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Type new leaf character");
        char leaf = scan.next().charAt(0);
        LeafValidator validator = new LeafValidator();
        try {
            if (validator.validate(this.leaf)) {
                this.leaf = leaf;
                this.buildTree();
                System.out.println("Changed leaf, and rebuilt tree");
            }
        }catch (IllegalArgumentException e){
        }
    }

    private void buildTree(){
        Builder builder;
        switch (direction){
            case UP:
                builder = new UpBuilder(this.height,this.leaf);
                builder.buildTree();
                treeContainer = builder.getBuiltTreeContainer();
                break;
            case DOWN:
                builder = new DownBuilder(this.height,this.leaf);
                builder.buildTree();
                treeContainer = builder.getBuiltTreeContainer();
                break;
            case LEFT:
                builder = new LeftBuilder(this.height,this.leaf);
                builder.buildTree();
                treeContainer = builder.getBuiltTreeContainer();
                break;
            case RIGHT:
                builder = new RightBuilder(this.height,this.leaf);
                builder.buildTree();
                treeContainer = builder.getBuiltTreeContainer();
                break;
        }
    }
}
