import java.util.Comparator;

public class Comparators {
    Comparator<Vertex>cmp1,cmp2;
    public Comparators() {
        Comparator<Vertex>cmp1= new Comparator<>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                return Integer.compare(o1.degree, o2.degree);
            }
        };
        Comparator<Vertex>cmp2= new Comparator<>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                return Integer.compare(o1.degreeC, o2.degreeC);
            }
        };
    }
    }
