public class ChatFilter{
    public static String filter(String[] logs,String key){
        StringBuilder sb=new StringBuilder();
        int c=0;
        for(String x:logs){
            String[] p=x.split(" ",3);
            if(p.length<3) continue;
            if(p[2].toLowerCase().contains(key.toLowerCase())){
                c++;
                sb.append(p[0]+" "+p[1]+": "+p[2]+"\n");
            }
        }
        return "Matches: "+c+"\n"+sb;
    }
}