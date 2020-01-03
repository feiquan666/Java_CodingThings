package myannoation;

import java.util.List;

public class PasswordUtils {

    @UseCase(id = 47,description = "密码至少包含一个数据")
    public boolean validatePassword(String password){
        return (password.matches("\\w*\\d\\w*"));
    }

    @UseCase(id = 48)
    public String encryptPassword(String password){
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id = 49,description = "新密码不能和旧密码相同")
    public boolean prevPassword(List<String> prevPassword,String password){
        return !prevPassword.contains(password);
    }
}
