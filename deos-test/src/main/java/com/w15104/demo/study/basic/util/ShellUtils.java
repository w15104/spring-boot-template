package com.w15104.demo.study.basic.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 *
 * @Description java程序执行shell工具类
 *
 * @author b15873
 * @date: 2019-03-15
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
public abstract class ShellUtils {
    private static final Logger log = LoggerFactory.getLogger(ShellUtils.class);

    /**
     * 执行Linux环境的shell脚本，并传入参数
     *
     * @param shellPath 脚本文件绝对路径
     * @param params    参数
     */
    public static void execShell(String shellPath, String params) {
        Process process;
        try {
            String initCommand = " chmod 655 " + shellPath;
            process = Runtime.getRuntime().exec(initCommand);
            process.waitFor();
            Runtime.getRuntime().exec(String.format("/bin/bash %s %s ", shellPath, params)).waitFor();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        log.info("run shell successfully");
    }
}
