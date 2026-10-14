import java.util.regex.Pattern;

class Validator{
    private static final Pattern Mobile = Pattern.compile("^[6-9][0-9]{9}$");
    private static final Pattern Email = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private static final Pattern Pan = Pattern.compile("^[A-Z]{5}[0-9]{4}[a-z]$");
    private static final Pattern Ifsc = Pattern.compile("^[A-Z]{4}0[A-Z0-9]{6}$");

    public static boolean isValidmobile(String mobile){
        return Mobile.matcher(mobile).matches();
    }
    public static boolean isValidemail(String email){
        return Email.matcher(email).matches();
    }
    public static boolean isValidpan(String pan){
        return Pan.matcher(pan).matches();
    }
    public static boolean  isValidifsc(String ifsc){
        return Ifsc.matcher(ifsc).matches();
    }

    public enum TransactionType {
        DEPOSIT,
        WITHDRAW,
        TRANSFER
    }
}