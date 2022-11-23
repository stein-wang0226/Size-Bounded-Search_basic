public class ReducingTechniques {
    OriGraph G;
    VertexSet C, R;
    int l, h, kmin, kmax;

    public ReducingTechniques(OriGraph G0, VertexSet C0, VertexSet R0, int l0, int h0, int kmin, int kmax) {// 直接修改C,R
        G = G0;
        C = C0;
        R = R0;
        l = l0;
        h = h0;
        this.kmin = kmin;
        this.kmax = kmax;
    }

    void ReduceTechs() {
        G.CalDegree();//
    }

    void Tech1() {
        Integer Min = Integer.MAX_VALUE;
        for (Vertex v : R.Hset) {
            if (Math.min(v.degree, v.degreeC + h - C.Size()) <= kmin) {// 想办法在递归时动态维护degreeC
                R.DelV(v);
            }
        }
    }

    int n(int k, int D) {
        if (D >= 1 && D <= 2 || k == 1) return k + D;
        else return k + D + 1 + D / 3 * (k - 2);
    }

    void Tech2() {
        Instance Inst = new Instance(G, C, R);

    }

    void Tech3() {
        Instance Inst = new Instance(G, C, R);
        for (Vertex u : C.Hset) {
            if (u.degree == kmin + 1) {
                for (Vertex v : G.Graph.get(u.id).Hset) {
                    if (R.Hset.contains(v)) R.DelV(v);
                }
            }
        }
    }

    void reduce(){
        Tech1();Tech2();Tech3();
    }


}

