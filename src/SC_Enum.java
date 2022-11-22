import java.util.Iterator;

public class SC_Enum {
    int n;
    OriGraph G;
    VertexSet C,H,R;
    int Kmin,Kmax;
    int l,h;
    Heuristical HH;  // 初始解

    void SelectFromR2C(Vertex v){
        R.Add(v);
        C.DelV(v);
    }

    int CalDegreeC(Vertex u){
        int cnt=0;
        for(Vertex v:G.Graph.get(u).Hset){// u 的邻居在v中的个数
            if(C.Hset.contains(v))cnt++;
        }
        u.degreeC=cnt;
        return cnt;
    }
//    public void CalAllDegreeC(){//计算所有Dc(u)
//        for(Vertex v:G.U.Hset){
//            CalDegreeC(v);
//        }
//    }
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
        Heuristical HH=new Heuristical();  // 初始解
        H=HH.H;
        if(Kmin<Kmax){
            for(Vertex v:G.U.Hset){
                if(G.cn(v)<=Kmin){
                    G.DelFromG(v); //
                }
            }
            C.UpdateTset();//生成有序set (每次要计算Dmin(C))
            dfs(C,R);
        }
    }

    void dfs(VertexSet C, VertexSet R){
        int DminC= C.Tset.iterator().next().degree;// C中最小度
        if(C.Size()>=l&&C.Size()<=h&&DminC>Kmin){
            Kmin=DminC;
            H=C;
        }

    }


}
