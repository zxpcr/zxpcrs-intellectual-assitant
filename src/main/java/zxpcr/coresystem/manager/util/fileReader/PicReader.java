package zxpcr.coresystem.manager.util.fileReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Base64;

public class PicReader {

    private Logger logger = LoggerFactory.getLogger(PicReader.class);


    public static byte[] readFile(String fileDir) {
        InputStream inputStream = null;
        byte[] fileByte = null;
        try {
            inputStream = new FileInputStream(fileDir);
            fileByte = new byte[inputStream.available()];
            inputStream.read(fileByte);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileByte;
    }


    public static String getBase64Str(final Base64.Encoder encoder, byte[] bytes) {
        return encoder.encodeToString(bytes);
    }












}
