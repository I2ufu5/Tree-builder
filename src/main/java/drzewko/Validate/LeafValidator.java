package drzewko.Validate;

public class LeafValidator implements ValidatorInterface<Character>{

    public boolean validate(Character leaf) {
        if(Character.isLetter(leaf.charValue()))
        return true;
        else{
            System.out.println("Incorrect leaf character entered");
            return false;
        }
    }
}
