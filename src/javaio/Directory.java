package javaio;

import net.mindview.util.PPrint;
import org.junit.Test;

import javax.swing.*;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class Directory {
    public static File[] local(File dir, final String regx) {
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regx);

            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(new File(name).getName()).matches();
            }
        });
    }

    public static File[] local(String path, final String regx) {
        return local(new File(path), regx);
    }

    public static class TreeInfo implements Iterable<File> {
        public List<File> files = new ArrayList<>();
        public List<File> dirs = new ArrayList<>();

        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo other) {
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        @Override
        public String toString() {
            return "dirs: " + PPrint.pformat(dirs) + "\n\nfiles: " + PPrint.pformat(files);
        }
    }

    public static TreeInfo walk(String start, String regx) {
        return recurseDirs(new File(start), regx);
    }

    public static TreeInfo walk(File start, String regx) {
        return recurseDirs(start, regx);
    }

    public static TreeInfo walk(File start) {
        return recurseDirs(start, ".*");
    }

    public static TreeInfo walk(String start) {
        return recurseDirs(new File(start), ".*");
    }

    static TreeInfo recurseDirs(File startDir, String regx) {
        TreeInfo result = new TreeInfo();
        for (File item : startDir.listFiles()) {
            if (item.isDirectory()) {
                result.dirs.add(item);
                result.addAll(recurseDirs(item, regx));
            } else {
                if (item.getName().matches(regx)) {
                    result.files.add(item);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws InterruptedException {
//        if (args.length == 0) {
//            System.out.println(walk("."));
//        } else {
//            for (String arg : args) {
//                System.out.println(walk(arg));
//            }
//        }
        JFrame frame = new JFrame("Hello Swing");
        JLabel label = new JLabel("A Label");
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,100);
        frame.setVisible(true);
        Scanner scanner = new Scanner(System.in);
        while (true){
            String text = scanner.next();
            label.setText(text);
        }
    }
    @Test
    public void test(){

    }
}
