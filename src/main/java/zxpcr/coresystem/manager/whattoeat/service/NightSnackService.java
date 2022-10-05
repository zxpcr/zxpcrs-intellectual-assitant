package zxpcr.coresystem.manager.whattoeat.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import zxpcr.coresystem.manager.util.fileReader.DirReader;
import zxpcr.coresystem.manager.util.fileReader.PicReader;
import zxpcr.coresystem.manager.whattoeat.controller.NightStackController;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NightSnackService {

    private Logger logger = LoggerFactory.getLogger(NightStackController.class);


    public Map getSnack() {
        String standradDir = "C:\\Users\\Administrator\\Desktop\\app\\pcrbot\\hoshino\\res\\img\\foods";
        List<String> foodList = DirReader.getDirFileList(standradDir);
        Map resMap = new HashMap();

        if (foodList.isEmpty()) {
            resMap.put("result", null);
            resMap.put("msg", "读取食物列表失败");
            logger.info("食物列表读取失败");
            return resMap;
        }


        byte[] foodBytes = PicReader.readFile(foodList.get((int) (Math.random()* foodList.size())));
        Base64.Encoder encoder = Base64.getEncoder();
        resMap.put("result", PicReader.getBase64Str(encoder, foodBytes));
        resMap.put("msg", "读取完成");
        return resMap;



    }







}
