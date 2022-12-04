import java.util.*;
public class OriGraph {
    Integer num;
    int MinDegree,MaxDegree;// 图中最大/小度数
    HashSet<Vertex> vertices ;// 存点
    //HashMap <Integer,Vertex>Id2Vex;
    HashMap<Integer, VertexSet> Graph;
    HashMap<Integer,Integer>CoreNumber; // cn[q]的值
    public OriGraph(int n) {
        num = n;
        vertices = new HashSet<>(n);
        Graph = new HashMap<>();
    }
    public OriGraph() {
        num = 0;
        vertices =  new HashSet<>();
        Graph = new HashMap<>();
    }
    public OriGraph(OriGraph G) {
        num = G.num;
        vertices = G.vertices;
        Graph = new HashMap<>(G.Graph);
    }
    void DataReader(){
        //input

    }
    void CalDegree(){ // 计算每个点原图度数
        MinDegree=MaxDegree=Graph.get(vertices.iterator().next().id).Size();
        for(Vertex v:vertices){
            v.degree=Graph.get(v.id).Size();
            MinDegree=Math.min(MinDegree,v.degree);
            MaxDegree=Math.max(MaxDegree,v.degree);
        }
    }
    void CalAllCN(){ // 计算所有k-core
      //  Vertex [] vertices1 = vertices;
        HashMap<Integer , VertexSet>G=Graph;
        Queue<Vertex>que= new LinkedList<>() ;//
        //剩余点
        HashSet<Vertex> rest = vertices;
        for(int k=1;k<=MaxDegree;k++){ // 计算 coreness
            if(rest.isEmpty())break;
            for(Vertex u:rest){
                if(u.degree<k){
                    if(!CoreNumber.containsKey(u)){
                        CoreNumber.put(u.id,k-1);
                        que.add(u);
                        rest.remove(u);
                    }
                }
            }
            while(que.size()>0){
                Vertex u=que.poll();
                for(Vertex v:G.get(u).Hset){
                    if(--v.degree<k){
                        que.add(v);
                        rest.remove(v);
                        if(!CoreNumber.containsKey(u)) {
                            CoreNumber.put(u.id, k - 1);
                        }
                    }
                }
            }

        }
    }
    void DelFromG(Vertex u){//从图中删除 O(nlogn)
        Graph.remove(u.id);
        num--;
        for(Vertex v:vertices){//
            Graph.get(v.id).DelAll(v);
        }
        for(Vertex v:Graph.get(u.id).Hset){
            v.degree--;
        }
    }
}
