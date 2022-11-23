class  struct{
    int a,b;
    public  struct(int a,int b){
        this.a=a;
        this.b=b;
    }
}
class  test {
    struct x,y;
    public test (  struct x,struct y){
        this.x=x;
        this.y=y;
    }
//    public int compareTo(test t){
//        if( x+y<t.x+t.y)return -1;
//        return 1;
//    }
    void addd(){
        x.a++;
        y.b++;
    }
}
