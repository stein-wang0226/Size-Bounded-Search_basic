public class Instance {
    OriGraph G;
    VertexSet C,R;
    public  Instance(OriGraph G,VertexSet C,VertexSet R){
        this.G=G;
        this.C=C;
        this.R=R;
    }
    public void  SelectFromC2R(Vertex v){
        C.AddT2(v);//
        R.DelV(v);
    }
    public  void DelFromR(Vertex v){
        R.DelV(v);
    }
}
