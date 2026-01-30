package cn.jonhon.jump.framework.banner.core;

import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.util.ClassUtils;

import java.util.concurrent.TimeUnit;

/**
 * 项目启动成功后，提供文档相关的地址
 *
 * @author 中航光电
 */
@Slf4j
public class BannerApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        ThreadUtil.execute(() -> {
            ThreadUtil.sleep(1, TimeUnit.SECONDS); // 延迟 1 秒，保证输出到结尾
            log.info("\n----------------------------------------------------------\n\t" +
                            "项目启动成功！\n" +
                            "----------------------------------------------------------");

//            // AI 大模型
//            if (isNotPresent("cn.jonhon.jump.module.ai.framework.web.config.AiWebConfiguration")) {
//                System.out.println("[AI 大模型 jump-module-ai - 已禁用][参考 https://doc.iocoder.cn/ai/build/ 开启]");
//            }
//            // IoT 物联网
//            if (isNotPresent("cn.jonhon.jump.module.iot.framework.web.config.IotWebConfiguration")) {
//                System.out.println("[IoT 物联网 jump-module-iot - 已禁用][参考 https://doc.iocoder.cn/iot/build/ 开启]");
//            }
        });
    }

    private static boolean isNotPresent(String className) {
        return !ClassUtils.isPresent(className, ClassUtils.getDefaultClassLoader());
    }

}
