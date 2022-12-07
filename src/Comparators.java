import java.util.Comparator;

public class Comparators {
    Comparator<Vertex> cmp1;

    public Comparators() {
        cmp1 = Comparator.comparingInt(o -> o.degree);
    }
}
