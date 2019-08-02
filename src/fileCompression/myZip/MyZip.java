
package fileCompression.myZip;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @description: Zip格式压缩，可以实现文件夹压缩和文件列表压缩
 * @Author：飞拳
 * @CreateDate：2019/7/31
*/
public class MyZip {
    private final int BUFFER_SIZE = 2 * 1024;
    /**
     * 压缩成ZIP 方法1
     *
     * @param srcDir           压缩文件夹路径
     * @param outputStream              压缩文件输出流
     * @param KeepDirStructure 是否保留原来的目录结构,true:保留目录结构;
     *                         <p>
     *                         false:所有文件跑到压缩包根目录下(注意：不保留目录结构可能会出现同名文件,会压缩失败)
     * @throws RuntimeException 压缩失败会抛出运行时异常
     */
    public void toZip(String srcDir, OutputStream outputStream, boolean KeepDirStructure) throws RuntimeException {
        long start = System.currentTimeMillis();
        ZipOutputStream zipOutputStream = null;
        try {
            zipOutputStream = new ZipOutputStream(outputStream);
            File sourceFile = new File(srcDir);
            compress(sourceFile, zipOutputStream, sourceFile.getName(), KeepDirStructure);
            long end = System.currentTimeMillis();
            System.out.println("压缩完成，耗时：" + (end - start) + " ms");
        } catch (Exception e) {
            throw new RuntimeException("zip error from ZipUtils", e);
        } finally {
            if (zipOutputStream != null) {
                try {
                    zipOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 压缩成ZIP 方法2
     * @param srcFiles 需要压缩的文件列表
     * @param outputStream      压缩文件输出流
     * @throws RuntimeException 压缩失败会抛出运行时异常
     */
    public void toZip(List<File> srcFiles, OutputStream outputStream) throws RuntimeException {
        long start = System.currentTimeMillis();
        ZipOutputStream zipOutputStream = null;
        try {
            zipOutputStream = new ZipOutputStream(outputStream);
            for (File srcFile : srcFiles) {
                byte[] buffer = new byte[BUFFER_SIZE];
                zipOutputStream.putNextEntry(new ZipEntry(srcFile.getName()));
                int len;
                FileInputStream in = new FileInputStream(srcFile);
                while ((len = in.read(buffer)) != -1) {
                    zipOutputStream.write(buffer, 0, len);
                }
                zipOutputStream.closeEntry();
                in.close();
            }
            long end = System.currentTimeMillis();
            System.out.println("压缩完成，耗时：" + (end - start) + " ms");
        } catch (Exception e) {
            throw new RuntimeException("zip error from ZipUtils", e);
        } finally {
            if (zipOutputStream != null) {
                try {
                    zipOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 递归压缩方法
     * @param sourceFile       源文件
     * @param zipOutputStream  zip输出流
     * @param name             压缩后的名称
     * @param KeepDirStructure 是否保留原来的目录结构,
     *                         true:保留目录结构;
     *                         false:所有文件跑到压缩包根目录下(注意：不保留目录结构可能会出现同名文件,会压缩失败)
     * @throws Exception
     */
    private void compress(File sourceFile, ZipOutputStream zipOutputStream, String name, boolean KeepDirStructure) throws Exception {
        byte[] buf = new byte[BUFFER_SIZE];
        if (sourceFile.isFile()) {
            // 向zip输出流中添加一个zip实体，构造器中name为zip实体的文件的名字
            zipOutputStream.putNextEntry(new ZipEntry(name));
            // copy文件到zip输出流中
            int length;
            FileInputStream fileInputStream = new FileInputStream(sourceFile);
            while ((length = fileInputStream.read(buf)) != -1) {
                zipOutputStream.write(buf, 0, length);
            }
            // Complete the entry
            zipOutputStream.closeEntry();
            fileInputStream.close();
        } else {
            File[] listFiles = sourceFile.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                // 需要保留原来的文件结构时,需要对空文件夹进行处理
                if (KeepDirStructure) {
                    // 空文件夹的处理
                    zipOutputStream.putNextEntry(new ZipEntry(name + "/"));
                    // 没有文件，不需要文件的copy
                    zipOutputStream.closeEntry();
                }
            } else {
                for (File file : listFiles) {
                    // 判断是否需要保留原来的文件结构
                    if (KeepDirStructure) {
                        // 注意：file.getName()前面需要带上父文件夹的名字加一斜杠,
                        // 不然最后压缩包中就不能保留原来的文件结构,即：所有文件都跑到压缩包根目录下了
                        compress(file, zipOutputStream, name + "/" + file.getName(), true);
                    } else {
                        compress(file, zipOutputStream, file.getName(), false);
                    }
                }
            }
        }
    }

    @Test
    public void testToZip() throws Exception {
        FileOutputStream fos1 = new FileOutputStream(new File("F:\\test.zip"));
        toZip("F:\\001AAA期末复习", fos1, true);
    }

    @Test
    public void testToZip2() throws FileNotFoundException {
        List<File> fileList = new ArrayList<>();
        fileList.add(new File("F:\\软件工程答辩\\即时通讯软件用户手册.docx"));
        fileList.add(new File("F:\\matlab\\test\\install_guide.pdf"));
        FileOutputStream fileOutputStream = new FileOutputStream(new File("F:\\test2.zip"));
        toZip(fileList, fileOutputStream);
    }

    @Test
    public void testDeleteFile(){
        File file = new File("F:\\test.zip");
        file.delete();
    }
}