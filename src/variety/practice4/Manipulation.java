package variety.practice4;

public class Manipulation {
    public static void main(String[] args) {
        Manipulator manipulator = new Manipulator(new HasFun());
        System.out.println(manipulator.getObj());
    }
}
class HasFun{
    public void f(){
        System.out.println("HasF.f()");
    }
}
class A extends HasFun{
    public void g(){
        System.out.println("i am A");
    }
}
class Manipulator<T extends HasFun>{
    T obj;

    public Manipulator(T obj) {
        this.obj = obj;
    }
    public void manipulate(){
        obj.f();
    }
    public HasFun getObj(){
        return this.obj;
    }
}
