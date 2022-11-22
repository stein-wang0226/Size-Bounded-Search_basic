public class SC_Enum {
    int n;
    OriGraph G;
    VertexSet C,R;
    int Kmin,Kmax;
    int l,r;
    void SelectFromR2C(Vertex v){
        R.Add(v);
        C.DelV(v);
    }
    public SC_Enum(int q, int l, int h){
        // input n
        G=new OriGraph(n);
        // input G
        Kmin=G.MinDregree;
        Kmax=Math.min(G.cn(G.Id2Vex.get(q)),h-1);
        C=G.U;
        R=new VertexSet();
    }
    public void SCEnum(int q,int l,int h){
        if(Kmin<Kmax){
            for(Vertex v:G.U.Hset){
                if(G.cn(v)<=Kmin){
                    G.DelFromG(v); //
                }
            }
            dfs(C,R);
        }
    }
    int CalDegreeC(Vertex u){
        int cnt=0;
        for(Vertex v:G.Graph.get(u).Hset){// u 的邻居在v中的个数
            if(C.Hset.contains(v))cnt++;
        }
        u.degreeC=cnt;
        return cnt;
    }

    void dfs(VertexSet C, VertexSet R){
        if(C.Size()>=l&&C.Size()<=h&&)


    }


}
