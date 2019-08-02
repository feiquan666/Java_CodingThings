package fileCompression;


import fileCompression.myZip.MyZip;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        inputProcess();
    }
    private static void inputProcess(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要压缩的文件或文件夹,输入文件时以英文逗号分隔");
        String text = scanner.next();
        if(text.contains(",")){
            List<File> fileList = buildFileList(text);
            System.out.println("请输入要输出的文件地址，以zip为文件后缀");
            text = scanner.next();
            compressFiles(text,fileList);
           deleteScheduler(text);
            return;
        }
        System.out.println("请输入要输出的文件地址，以zip为文件后缀");
        String target = scanner.next();
        compressFiled(text,target);
        deleteScheduler(target);
        return;
    }
    private static List<File> buildFileList(String text){
        List<File> fileList = new ArrayList<>();
        String[] files = text.split(",");
        for(String item : files){
            fileList.add(new File(item));
        }
        return fileList;
    }
    private static void compressFiles(String text,List<File> fileList){
        MyZip myZip = new MyZip();
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(text);
            myZip.toZip(fileList,fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static void compressFiled(String src,String target){
        MyZip myZip = new MyZip();
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(target);
            myZip.toZip(src,fileOutputStream,true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static void deleteScheduler(String text){
        MyTimerTask myTimerTask = MyTimerTask.getMyTimerTask(new File(text));
        Timer timer = new Timer();
        timer.schedule(myTimerTask,10*1000);
    }
}
