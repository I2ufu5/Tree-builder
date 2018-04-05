package drzewko;

import drzewko.Validate.HeightValidator;
import drzewko.Validate.LeafValidator;

import java.util.*;

public class Menu {
    private HashMap<String,Tree> trees = new HashMap<>();

    public void showMenu(){
        System.out.println("Choose option: ");
        System.out.println("1 for  new Tree");
        System.out.println("2 for modify existing Tree ");
        System.out.println("3 for delete existing Tree");
        System.out.println("4 to draw your tree");
        System.out.println("9 to stop program");
        getMenuAnswer();
    }

    private void getMenuAnswer(){
        int menuPick;
        Scanner scan = new Scanner(System.in);
        menuPick = scan.nextInt();
        switch (menuPick){
            case 1:
                treeInitialize();
                break;
            case 2:
                treeModify();
                break;
            case 3:
                treeErase();
                break;
            case 4:
                drawTree();
            case 9:
                System.exit(0);
                break;
            default:
                System.out.println("No case for that! Choose valid option");
                showMenu();
                break;
        }

    }

    private void treeInitialize(){
        String name;
        int height;
        char leaf;
        Direction orientation;

        Scanner scan = new Scanner(System.in);

        try {
            System.out.println("Name your tree ");
            name = scan.nextLine();

            System.out.println("Type tree height ");
            height = scan.nextInt();
//            HeightValidator heightValidator = new HeightValidator();
//            if (!heightValidator.validate(height)) {
//                throw new IllegalArgumentException();
//            }

            System.out.println("Type tree leaf character ");
            leaf = scan.next().charAt(0);
//            LeafValidator leafValidator = new LeafValidator();
//            if (!leafValidator.validate(leaf)) {
//                throw new IllegalArgumentException();
//            }

            System.out.println("Type tree orientation ");
            orientation = choseDirection();

            trees.put(name, new Tree(height, leaf, orientation));
            System.out.println("Tree created");

        }catch (Exception e){
            System.out.println("Tree initalizing ended with failure " + e);
        }

        showMenu();
    }

    private Direction choseDirection(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Chose orientation od tree ");
        System.out.println("1 for upwards");
        System.out.println("2 for downwards");
        System.out.println("3 for leftwards");
        System.out.println("4 for rightwards");
        int choice = scan.nextInt();
        switch (choice){
            case 1:
                return Direction.UP;
            case 2:
                return Direction.DOWN;
            case 3:
                return Direction.LEFT;
            case 4:
                return Direction.RIGHT;
            default:
                System.out.println("Not expected value, setting default (Upwards)");
                return Direction.UP;
        }

    }

    private boolean lookForTree(String name){
        if(trees.containsKey(name))
        return true;
        else{
            System.out.println("No such tree");
            return false;
        }
    }

    private void treeModify(){
        String accessName = getTreeAccessName();
        if(lookForTree(accessName)){
            Tree tree = trees.get(accessName);
            System.out.println("Choose option: ");
            System.out.println("1 to rotate tree");
            System.out.println("2 to change height");
            System.out.println("3 to change leaf");
            System.out.println("anything else to return to main menu");

            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    tree.rotateTree();
                    break;
                case 2:
                    tree.changeTreeHeight();
                    break;
                case 3:
                    tree.changeTreeLeaf();
                    break;
            }
        }
        showMenu();
    }

    private void treeErase(){
       String name = getTreeAccessName();
        if(lookForTree(name)){
            trees.remove(name);
            System.out.println("Tree removed successfully");
        }
        showMenu();
    }

    private String getTreeAccessName(){
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the tree called? ");
        String name = scan.nextLine();
        return name;
    }

    private void drawTree(){
        String name = getTreeAccessName();
        if(lookForTree(name)){
            trees.get(name).drawTree();
        }
        showMenu();
    }
}
