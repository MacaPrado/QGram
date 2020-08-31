import java.util.HashMap;
import java.util.Map;

public class QGram {
    private static int N;
    public QGram(int n) {
        N = n;
    }

    public void printTokens(String str){
        HashMap<String,Integer> map = getMap(str);
        map.forEach((k,v) -> System.out.println(String.format("%s    %d", k,v)));
    }

    public static HashMap<String,Integer> getMap(String str){
        // Build a string with as many # as necessary
        StringBuilder string = new StringBuilder();
        appends(string);
        string.append(str);
        appends(string);
        // HashMap is more efficient than an ArrayList
        HashMap<String, Integer> map = new HashMap<>();
        int count;
        for(int i=0; i<string.length()-(N-1); i++){
            String key = makeKey(string,i);
            if(!map.containsKey(key)){
                map.put(key,1);
            }
            else{
                count = map.get(key);
                map.put(key, count+1);
            }
        }

        return map;
    }

    static private String makeKey(StringBuilder str, int index){
        StringBuilder string = new StringBuilder();
        for(int i=index; i<index+N;i++){
            string.append(str.charAt(i));
        }
        return string.toString();
    }

    static private void appends(StringBuilder str){
        for(int i=0; i<N-1; i++){
            str.append("#");
        }
    }

    static double similarity(String str1, String str2){
        HashMap<String,Integer> map1 = getMap(str1);
        HashMap<String,Integer> map2 = getMap(str2);
        int totalKeys = 0;
        int sharedKeys = 0;
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            if(map2.containsKey(entry.getKey())){
                int comparison = entry.getValue() - map2.get(entry.getKey());
                if(comparison <= 0){
                    sharedKeys += entry.getValue();
                }
                else{
                    sharedKeys += map2.get(entry.getKey());
                }
            }
            totalKeys += entry.getValue();
        }
        for(Map.Entry<String, Integer> entry : map2.entrySet()){
            totalKeys += entry.getValue();
        }
        return (double)(sharedKeys*2)/totalKeys;    //(double)Math.round(value * 100000d) / 100000d
    }
}
