public class PasswordChecker{

    public static boolean len(String p){
        return p.length()>=8;
    }

    public static boolean upper(String p){
        return p.matches(".*[A-Z].*");
    }

    public static boolean digit(String p){
        return p.matches(".*[0-9].*");
    }

    public static boolean special(String p){
        return p.matches(".*[^a-zA-Z0-9].*");
    }
    
    public static String strength(String p){
        int c=0;
        if(len(p)) c++;
        if(upper(p)) c++;
        if(digit(p)) c++;
        if(special(p)) c++;
        if(c<=1) return "Weak";
        if(c<=3) return "Medium";
        return "Strong";
    }
}