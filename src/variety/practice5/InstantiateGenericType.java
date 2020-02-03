package variety.practice5;


class ClassAsFactory<T>{
    T x;
    public ClassAsFactory(Class<T> kind){
        try {
            this.x = kind.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
class Employee{}
public class InstantiateGenericType {
    public static void main(String[] args) {
        ClassAsFactory<Employee> employeeClassFactory = new ClassAsFactory(Employee.class);
        System.out.println("创建成功");
        try {
            ClassAsFactory<Integer> integerClassAsFactory = new ClassAsFactory(Integer.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
