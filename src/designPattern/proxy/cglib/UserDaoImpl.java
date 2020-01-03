package designPattern.proxy.cglib;

public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("Save Product");
    }

    @Override
    public void delete() {
        System.out.println("Delete Product");
    }
}
