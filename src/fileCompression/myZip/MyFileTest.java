package fileCompression.myZip;

import org.junit.Test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class MyFileTest {
    @Test
    public void testGetAllFiles() {
        String path = "F:\\001AAA期末复习\\";
        File file = new File(path);
        if (file.isFile()) {//如果路径最终指向是文件
            System.out.println(file.getAbsolutePath());//输出文件路径,绝对路径，但不会解析..和.
            return;
        }
        List<String> filesGlobalPath = new ArrayList<>();//存放获取到的所有文件的地址
        filesGlobalPath = getAllFiles(file,filesGlobalPath);
        for (String item : filesGlobalPath){
            System.out.println(item);
        }
    }
    private List<String> getAllFiles(File file,List<String> filesGlobalPath) {
        File[] files = file.listFiles();//获取当前路径下所有文件和文件夹
        for(int i = 0; i < files.length; i++){
            file = files[i];
            if(file.isFile()){
                filesGlobalPath.add(file.getAbsolutePath());
                continue;//跳过本次循环
            }
            getAllFiles(file,filesGlobalPath);
        }
        return filesGlobalPath;
    }


}
/**
*  file.getAbsolutePath();//输出文件路径,绝对路径，但不会解析..和.
 * file.getPath();//输出文件路径,相对路径，取绝于输入时的路径是相对的还是绝对的
 * file.getCanonicalPath();//输出文件路径，绝对路径，能够解析..和.
*/
