package myannoation.sqlAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TableCreator {
    /**
     * 检查控制台是否输入了参数？如果没有则提示并立即退出程序
     * 循环args
     */
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("arguments: annotated classes");
            System.exit(0);
        }
        for (String className : args) {
            Class<?> cl = Class.forName(className);// 按参数（类名加载类）
            DBTable dbTable = cl.getAnnotation(DBTable.class);// 按注解类型实例化注解
            if (dbTable == null) {
                System.out.println("No DBTable annotation in class " + className);// 没有DBTable注解在该类上
                continue;// 下一个循环
            }
            String tableName = dbTable.name(); // 获取表名
            if (tableName.length() < 1) { // 如果表名为""
                tableName = cl.getName().toUpperCase();// 将表名赋值为类名的全大写
            }
            List<String> columnDefs = new ArrayList<>(); // 存储列的定义
            // 遍历类的成员变量
            for (Field field : cl.getFields()) {
                String columnName;
                Annotation[] anns = field.getDeclaredAnnotations();// 获取成员变量上的所有注解
                if (anns.length < 1) {
                    continue; // 该成员变量没有任何注解，下一个；
                }
                if (anns[0] instanceof SQLInteger) {
                    SQLInteger sInt = (SQLInteger) anns[0];
                    if (sInt.name().length() < 1) {
                        columnName = field.getName().toUpperCase();// 如果未指定名称，则使用字段名
                    } else {
                        columnName = sInt.name();
                        columnDefs.add(columnName + "INT" + getConstraints(sInt.constraints()));
                    }
                }
                if (anns[0] instanceof SQLString) {
                    SQLString sString = (SQLString) anns[0];
                    if (sString.name().length() < 1) {
                        columnName = field.getName().toUpperCase();// 如果未指定名称，则使用字段名
                    } else {
                        columnName = sString.name();
                        columnDefs.add(columnName + "VARCHAR(" + sString.value() + ")" + getConstraints(sString.constraints()));
                    }
                }
                StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tableName + "(");
                for (String columnDef : columnDefs) {
                    createCommand.append("\n " + columnDef + ",");
                }
                // 删除尾部逗号
                String tableCreate = createCommand.substring(0, createCommand.length() - 1) + ");";
                System.out.println("Table Creating SQL for " + className + " is :\n" + tableCreate);
            }
        }
    }

    private static String getConstraints(Constraints con) {
        StringBuilder constraints = new StringBuilder("");
        if (!con.allowNull()) {
            constraints.append(" NOT NULL");
        }
        if (con.primaryKey()) {
            constraints.append(" PRIMARY KEY");
        }
        if (con.unique()) {
            constraints.append(" UNIQUE");
        }
        return constraints.toString();
    }
}
