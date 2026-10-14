import java.util.Scanner;
public class Driver5 {
    public static void main(String[] args){
        String[] logs={
            "10:05 alice Hello there",
            "10:10 bob How are you",
            "10:15"
        };
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter keyword: ");
        String key=sc.nextLine();
        System.out.print(ChatFilter.filter(logs,key));
        sc.close();
    }
}