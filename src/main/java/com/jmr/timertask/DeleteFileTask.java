package com.jmr.timertask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @auther 张旭博
 */
@Component
//使用配置开关定时器
@ConditionalOnProperty(prefix = "deletetask", name = "enabled", havingValue = "true")
@EnableScheduling
public class DeleteFileTask {
    static String FILE_PATH="src\\main\\webapp";
    static Logger logger = LoggerFactory.getLogger(DeleteFileTask.class);

    /**
     * 定时器
     * @auther 张旭博
     */
    @Scheduled(cron = "0 0/1 * * * ? ")
    private void mainTask(){
        File file = new File(FILE_PATH);
        deleteFile(file);
        logger.info("执行时间:"+datatime());
    }

    /**
     * 删除文件的方法
     * @auther 张旭博
     * @param file
     */
    private void deleteFile(File file){
        File[] files = file.listFiles();
        if(files.length!=0){
            for (File nf:files) {
                if (nf.isDirectory()){
                    deleteFile(nf);
                }else{
                    nf.delete();
                }
            }
            logger.info("成功清空"+FILE_PATH+"下的文件,共清理了"+files.length+"个文件");
        }else {
            logger.warn("文件夹下无文件！");
        }

    }

    /**
     * 时间信息
     * @auther 张旭博
     * @return datatime
     */
    public static String datatime(){
        Date date = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datatime = sdf1.format(date);
        return datatime;
    }
}
