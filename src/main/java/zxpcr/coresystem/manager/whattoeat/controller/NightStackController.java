package zxpcr.coresystem.manager.whattoeat.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import zxpcr.coresystem.manager.whattoeat.service.NightSnackService;

import java.util.Map;

@RestController
@RequestMapping("whattoeat")
public class NightStackController {

    private Logger logger = LoggerFactory.getLogger(NightStackController.class);

    @Autowired
    private NightSnackService snackService;

    @PostMapping("/getSnack")
    @ResponseBody
    public Map getSnack() {
        return snackService.getSnack();
    }




}
