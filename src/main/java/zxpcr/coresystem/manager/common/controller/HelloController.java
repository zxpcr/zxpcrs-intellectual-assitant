package zxpcr.coresystem.manager.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    public HelloController() {
        logger.info("HELLO!");
    }

    /**
     * 请求 /hello  输出hello springboot!
     * @return
     */
    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello springboot!";
    }
}
