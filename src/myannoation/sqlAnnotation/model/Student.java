package myannoation.sqlAnnotation.model;

import myannoation.sqlAnnotation.Constraints;
import myannoation.sqlAnnotation.DBTable;
import myannoation.sqlAnnotation.SQLString;

@DBTable(name = "tb_student")
public class Student {
    @SQLString(name = "stu_code", value = 30)
    private String stuCode;
//    @SQLInteger(name = "class_id",@Constraints(allowNull = false))
//    private Integer classId;
//    @SQLString(name = "stu_name",value = 30,@Constraints(primaryKey = true,allowNull = false,unique = true))
//    private String name;
//    @SQLInteger(name = "stu_age",@Constraints(allowNull = false))
//    private Integer age;
//
//    public String getStuCode() {
//        return stuCode;
//    }
//
//    public void setStuCode(String stuCode) {
//        this.stuCode = stuCode;
//    }
//
//    public Integer getClassId() {
//        return classId;
//    }
//
//    public void setClassId(Integer classId) {
//        this.classId = classId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
}
