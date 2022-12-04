import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
public class SC_Enum {
    int n;
    OriGraph G,H;
    VertexSet C,R,Hv; // H中的点集
    int Kmin,Kmax;
    int l,h,q;
    Heuristical HH;  // 初始解

    HashMap<Integer,Vertex>Id2Vetx; // 编号映射
public SC_Enum(int q, int l, int h){
    // input n
    G=new OriGraph();
    // input G
    G.DataReader();

    for(Vertex v: G.vertices)R.Add(v);

    C=new VertexSet();
}
    public void SCEnum(){
        Heuristical HH=new Heuristical(G,Id2Vetx.get(q),l,h,Kmin);  // 初始解
        HH.GenerateInitAns(G,Id2Vetx.get(q));
        H=HH.H;
        Kmin=G.MinDegree;
        Hv=new VertexSet(H.vertices);
        Kmax=Math.min(H.CoreNumber.get(q),h-1);
        if(Kmin<Kmax){
            for(Vertex v:G.vertices){
                if(G.CoreNumber.get(v.id)<=Kmin){
                    G.DelFromG(v); //
                }
            }
            C.UpdateTset1();//生成有序set (每次要计算Dmin(C))    用处不大
            dfs(C,R);
        }
    }
    void dfs( VertexSet C, VertexSet R){
        int DminC= C.Tset.iterator().next().degree;// C中最小度
        if(C.Size()>=l&&C.Size()<=h&&DminC>Kmin){
            Kmin=DminC;
            Hv=new VertexSet(C);//
        }
        if(C.Size()<h&&R.Size()>0){
            for(Vertex v: R.Hset){ // java全是传引用
                VertexSet C1 =new VertexSet(C);
                VertexSet R1=new VertexSet(R);
                VertexSet C2 =new VertexSet(C);
                VertexSet R2=new VertexSet(R);
                Instance Inst1= new Instance(G,C1,R1);
                Instance Inst2=new Instance(G,C2,R2);
                Inst1.SelectFromC2R(v);
                Inst2.DelFromR(v);
                dfs(C1, R1);
                dfs(C2, R2);
            }

        }
    }
    public  void Output(){
        for(Vertex v:H.vertices){
            System.out.println(v.id);
        }
    }
}
