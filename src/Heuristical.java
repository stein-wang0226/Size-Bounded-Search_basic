import java.util.TreeSet;

public class Heuristical {
    OriGraph H, S;
    int l, h, Kmin;
    Vertex q;

    public Heuristical(OriGraph G, Vertex q, int l, int h, int Kmin) {
        H = new OriGraph();
        S = new OriGraph();
        this.q = q;
        this.l = l;
        this.h = h;
        this.Kmin = Kmin;
    }
    public void GenerateInitAns(OriGraph G, Vertex q) {
        //生成初始解H
        //G.CalDegree();
        S.vertices.add(new Vertex(q.id)); // 不改变 可浅拷贝
        if (q.degree >= h - 1) {
            // 生成 network
            for (Vertex v : G.Graph.get(q.id).Hset) { // 只有连到q的边  q<->v
                S.vertices.add(new Vertex(v.id)); // 度要重新计算
                if (S.Graph.get(q.id) == null) S.Graph.put(q.id, new VertexSet());
                S.Graph.get(q.id).Add(v);
                if (S.Graph.get(v.id) == null) S.Graph.put(v.id, new VertexSet());
                S.Graph.get(v.id).Add(q);
            }
            for (Vertex v : S.vertices) {
                for (Vertex u : G.Graph.get(v.id).Hset) { //v u 都在S中
                    if (S.vertices.contains(u)) {/// u<->v
                        if (S.Graph.get(u.id) == null) S.Graph.put(u.id, new VertexSet());
                        S.Graph.get(u.id).Add(v);
                        if (S.Graph.get(v.id) == null) S.Graph.put(v.id, new VertexSet());
                        S.Graph.get(v.id).Add(u);
                    }
                }
            }
            S.CalDegree();//
            Comparators Cmp = new Comparators();
            TreeSet<Vertex> Order = new TreeSet<>(Cmp.cmp1);
            Order.addAll(S.vertices);
            while (S.vertices.size() >= l) {
                Vertex minnV = Order.iterator().next();
                int DminS = minnV.degree;
                if (S.vertices.size() <= h && DminS > Kmin) {
                    Kmin = DminS;
                    H = new OriGraph(S);
                }
                S.DelFromG(minnV);
                Order.remove(minnV); //Order中点的度会随S修改
            }
        } else {
            S.CalDegree();
            while (S.vertices.size()<h){
                double maxx=0;Vertex res=null;
                for(Vertex u:G.vertices){
                    double score=0;
                    for(Vertex v:G.Graph.get(u.id).Hset){
                        if(S.vertices.contains(v)){
                            score+=1.0/v.degree;
                        }
                    }
                    if(score>maxx){
                        maxx=score;
                        res=u;
                    }
                    S.vertices.add(res);
                    S.Graph.put(res.id,new VertexSet());
                    for(Vertex v:G.Graph.get(res.id).Hset){
                        if(S.vertices.contains(v)){
                            S.Graph.get(res.id).Add(v);
                            S.Graph.get(v.id).Add(res);
                        }
                    }
                    S.CalDegree();//
                    if(S.vertices.size()>=l&&S.MinDegree>=Kmin){
                        Kmin=S.MinDegree;
                        H=new OriGraph(S);
                    }
                }
            }
        }
    }
}
