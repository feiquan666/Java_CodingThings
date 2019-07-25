package fileUpload;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
* 基于Spring的MultipartFile的文件上传实现
 * 为了可以在SSM框架中使用，须一如以下包
 *  <!-- spring-web包-->
 *         <dependency>
 *             <groupId>org.springframework</groupId>
 *             <artifactId>spring-web</artifactId>
 *             <version>5.0.9.RELEASE</version>
 *         </dependency>
 *
 *         <!-- 上传文件组件包 -->
 *         <dependency>
 *             <groupId>commons-fileupload</groupId>
 *             <artifactId>commons-fileupload</artifactId>
 *             <version>1.3.1</version>
 *         </dependency>
 *         <dependency>
 *             <groupId>commons-io</groupId>
 *             <artifactId>commons-io</artifactId>
 *             <version>2.4</version>
 *         </dependency>
 *         <dependency>
 *             <groupId>commons-codec</groupId>
 *             <artifactId>commons-codec</artifactId>
 *             <version>1.9</version>
 *         </dependency>
*/

public class MyMultipartFile<T> {

    /**
    * 之所以在这里添加路径是为了上层调用时只需要传入具体的文件夹名称，注意，以下方法传入的均需要以 \\ 结尾；
     * 举个栗子：比如你的项目需要保存用户头像和用户的聊天文件
     * AAAA
     * =>BBBB
     *  =>CCCC
     *   =>userHead
     *   =>userChat
     *   =>以后可能会扩充更多
     * 那么这里的 PATH = "AAAA/BBBB/CCCC/"，传入的应该是 "userHead/"，注意windows应该指定盘符
     *
    */
    private final String PATH = "F:\\workspace\\files\\";

    /**
     * 保存文件的对内部提供的唯一入口方法
     * 参数 multipartFiles是存放文件信息的数组
     * 参数 type 表示带哦用上传文件的模块
     * 参数 path 表示将本文件存储的地址
     */
    public T saveFiles(MultipartFile[] multipartFiles,String path){
        String finalPath = PATH + path;//拼接最终存放文件的文件夹位置
        List<String> fileNames = generatorFileNames(multipartFiles);//为防止文件名冲突，这里使用自定义的文件命名
        return (T) saveMultipleFile(multipartFiles, finalPath, fileNames);
    }

    /**
     * 保存文件的对内部提供的唯一入口方法
     * 参数 multipartFiles是存放文件信息
     * 参数 type 表示带哦用上传文件的模块
     * 参数 path 表示将本文件存储的地址
     */
    public String saveFile(MultipartFile multipartFile,String path) {
        String finalPath = PATH + path;
        return saveSingleFile(multipartFile,finalPath,generatorFileName());
    }

    private String saveMultipleFile(MultipartFile[] multipartFiles, String filePath, List<String> fileNames) {
        List<String> succeed = new ArrayList<>();
        String suffix;
        String[] test;
        for (int i = 0; i < multipartFiles.length; i++) {
            if (!multipartFiles[i].isEmpty()) {
                test = multipartFiles[i].getOriginalFilename().split("\\.");
                suffix = test[test.length-1];
                try {
                    FileUtils.copyInputStreamToFile(multipartFiles[i].getInputStream(), new File(filePath+fileNames.get(i)+"."+suffix));
                    succeed.add(fileNames.get(i)+"."+suffix);
                } catch (IOException e) {
                    for (String item : succeed) {
                        FileUtils.deleteQuietly(new File(filePath, item));
                    }
                    System.out.println("上传失败二来");
                    succeed.clear();
                    return "上传失败";
                }
            }
        }
        if(succeed.size() == 0){
            return "上传失败";
        }else {
            return "上传成功";
        }
    }

    private String saveSingleFile(MultipartFile multipartFile, String filePath, String fileName) {
        String suffix;
        String[] test;
        test = multipartFile.getOriginalFilename().split("\\.");
        suffix = test[test.length-1];
        if (!multipartFile.isEmpty()) {
            try {
                FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), new File(filePath+fileName+"."+suffix));
                return "文件上传成功";
            } catch (IOException i) {
                return "上传失败";
            }
        }
        return "文件为空，上传失败";
    }

    /**
     * 生成文件名称列表
     */
    private List<String> generatorFileNames(MultipartFile[] multipartFiles){
        int length = multipartFiles.length;
        List<String> fileNames = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            fileNames.add(generatorFileName());
        }
        return fileNames;
    }
    /**
     * 生成文件名称
     */
    private String generatorFileName() {
        StringBuilder fileName = new StringBuilder("fq520");//皮一下而已
        fileName.append(UUID.randomUUID().toString().replace("-", String.valueOf(new Random().nextInt(10))));
        return fileName.toString();
    }
}
