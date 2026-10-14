public class   Driver6 {
    public static void main(String[] args){
        String t="Dear {name}, order {id} ships {date}.";
        String[] n={"name","id"};
        String[] v={"Harshit","A07"};
        System.out.println(TemplateFiller.fill(t,n,v));
    }
}