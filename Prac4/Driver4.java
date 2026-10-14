public class Driver4 {
    public static void main(String[] args){
        String[] p={"hello","hello123","Hello123!"};

        for(String x:p){
            System.out.println("Password: "+x);
            System.out.println("Length: "+PasswordChecker.len(x));
            System.out.println("Uppercase: "+PasswordChecker.upper(x));
            System.out.println("Digit: "+PasswordChecker.digit(x));
            System.out.println("Special: "+PasswordChecker.special(x));
            System.out.println("Strength: "+PasswordChecker.strength(x));
            System.out.println();
        }
    }
}