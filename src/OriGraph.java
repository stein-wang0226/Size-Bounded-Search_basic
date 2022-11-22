import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
class Vertex implements Comparable<Vertex> {
    int id;
    int degree;
    int degreeC;
    public int getId() {
        return id;
    }
    public Vertex(int id){
        this.id=id;
    }
    public int compareTo(Vertex v){ // 用于set
        if(degree==v.degree)return Integer.compare(this.id,v.id);
        return  Integer.compare(this.degree,v.degree);
    }
}
class VertexSet {
    HashSet<Vertex> Hset;
    TreeSet<Vertex> Tset;//

    public Integer Size(){
        return  Hset.size();
    }
    public void Add(Vertex v){
        Hset.add(v);
    }
    public void Add2All(Vertex v){
        Hset.add(v);
        Tset.add(v);
    }
    public void DelV(Vertex v){
        Hset.remove(v);
        Tset.remove(v);
    }
    public VertexSet() {
        Hset =new HashSet<>();
        Tset = new TreeSet<>(Hset);
    }
    public void  UpdateTset() { // 若一直只对Hset操作
        Tset = new TreeSet<>(Hset);
    }//
}
public class OriGraph {
    Integer num;

    int MinDregree,MaxDegree;
    Vertex [] vertices  ;
    VertexSet U;
    HashMap <Integer,Vertex>Id2Vex;
    HashMap<Vertex, VertexSet> Graph;
    HashMap<Integer,Integer>CoreNumber;
    public OriGraph(int n) {
        num = n;
        vertices = new Vertex[n];
        Graph = new HashMap<>();
        U = new VertexSet();
    }
    void DataReader(){
        //input
    }
    void CalDegree(){ // 计算每个点原图度数
        MinDregree=MaxDegree=Graph.get(vertices[0]).Size();
        for(Vertex v:U.Hset){
            v.degree=Graph.get(v).Hset.size();
            MinDregree=Math.min(MinDregree,v.degree);
            MaxDegree=Math.max(MaxDegree,v.degree);
        }

    }

    int cn(Vertex q){ // k-core 计算

    return 0;
    }

    void DelFromG(Vertex v){//从图中删除
        Graph.remove(v);
        U.DelV(v);
        num--;
    }

    void CalAllCN(){

    }



}
