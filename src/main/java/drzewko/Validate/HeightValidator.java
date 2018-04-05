package drzewko.Validate;

public class HeightValidator implements ValidatorInterface<Integer> {

    @Override
    public boolean validate(Integer height) {
        if(height>0 & height<1000){
            return true;
        }else if(height<0){
            System.out.println("Height can not be non-positive");
            return false;
        }else if(height>1000){
            System.out.println("No point in drawing such a huge tree");
            return false;
        }else return false;

    }
}
