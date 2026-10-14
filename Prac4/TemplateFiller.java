import java.util.regex.*;
public class TemplateFiller{
    public static String fill(String t,String[] n,String[] v){
        Pattern p=Pattern.compile("\\{(\\w+)\\}");
        Matcher m=p.matcher(t);
        StringBuilder s=new StringBuilder();
        while(m.find()){
            String key=m.group(1);
            String value="[?]";
            for(int i=0;i<n.length;i++){
                if(n[i].equals(key))
                    value=v[i];
            }
            m.appendReplacement(s,value);
        }
        m.appendTail(s);
        return s.toString();
    }
}