package zxpcr.coresystem.manager.util.fileReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirReader {

    public static List<String> getDirFileList(String baseDir) {
        File file = new File(baseDir);
        //检查是否是已存在的目录
        if (file.isDirectory()) {
            File[] dirFile = file.listFiles();
            List<String> fileDir = new ArrayList<>();
            for (File f : dirFile) {
                if (f.isFile()) {
                    fileDir.add(f.getAbsolutePath());
                }
            }
            return fileDir;
        } else {
            return new ArrayList<>();
        }




    }



}
