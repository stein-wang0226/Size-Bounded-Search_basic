public class Instance {
    OriGraph G;
    VertexSet C,R;
    int [][]dist;
    public  Instance(OriGraph G,VertexSet C,VertexSet R){
        this.G=G;
        this.C=C;
        this.R=R;
        dist= new int[G.num+5][G.num+5];
    }
    int CalDegreeC(Vertex u){
        int cnt=0;
        for(Vertex v:G.Graph.get(u).Hset){// u 的邻居在v中的个数
            if(C.Hset.contains(v))cnt++;
        }
        u.degreeC=cnt;
        return cnt;
    }
    public void CalAllDegreeC(){//计算所有Dc(u) 一次
        for(Vertex v:G.vertices){
            G.vertices[v.id].degreeC=CalDegreeC(v);
        }
    }
    public void  SelectFromC2R(Vertex v){
        C.AddT2(v);//
        R.DelV(v);
    }
    public  void DelFromR(Vertex v){
        R.DelV(v);
    }
    int dist(int u,int v){
        //bfs floyed  二分？
        return 0;//
    }

}
