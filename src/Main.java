import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
    Set st0=new HashSet<Integer>();
    for(int i=1;i<=5;i++){
        st0.add(5-i);
    }
    Set<Integer> st=new TreeSet<Integer>(st0);
    for(int u:st){
        System.out.println(u);
    }

    }
}