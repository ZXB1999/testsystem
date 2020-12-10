package com.jmr.timertask;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
//开启定时任务注解
@EnableScheduling
public class TimerTask {
    String path = "d:\\test\\";
    private String user = "root";
    private String password = "system";
    private String database = "testjmr";
    private String filepath = path + datatime().substring(19,33) + ".sql";
    //mysqldump语句 musqldump+库命+地址+-u+用户名+-p+密码+默认编码格式+文件生成路径与格式
    private final String STMT = "mysqldump " + database + " -h 127.0.0.1 " + " -u " + user + " -p" +
            password + " --default-character-set=utf8 --result-file=" + filepath;
    private int nameNo = filepath.lastIndexOf("\\");
    static Logger logger = LoggerFactory.getLogger(TimerTask.class);

    /**
     * 定时任务,一天一次
     * @Author TTMY
     * @throws Exception
     */
    @Scheduled(cron = "0 0 0 1/1 * ? ")
    private void configureTasks() throws Exception {
        logger.info("开始时间：" + datatime().substring(0,19));
            if (cun()) {
                logger.info("备份成功");
            } else {
                logger.error("备份失败，重新备份");
                cun();
            }
            if (del()==2) {
                logger.info("执行了删除操作。");
            } else {
                logger.warn("文件不存在！");
            }
    }
    public boolean cun() throws Exception {
        File newsql = new File(path, datatime().substring(19,33) + ".sql");
        File isexist = new File(path, filepath.substring(nameNo + 1));
        if (!newsql.exists()) {
            newsql.createNewFile();
        }
        Runtime.getRuntime().exec(STMT);
        logger.info("已经保存到 " + this.filepath + " 中");
        return isexist.exists();
    }
    /**
     * 清理30天前的备份(测试环境下删除60秒前文件)，传回code判断文件的存在状态，code为1时，没进行操作，为2时进行了删除操作
     * @Author TTMY
     * @return code
     */
    public int del(){
        int code = 1;
        File file = new File(path,datatime().substring(33)+ ".sql");
        if(file.exists()){
            file.delete();
            code = 2;
        }
        return code;
    }
    /**
     * 获取时间串
     * 1.创建时间date
     * 2.格式化时间 参数为时间的格式
     * 3.拼串
     * 串的格式为：0-19——当前时间标准格式化、19-33——当前时间数字化格式化、33后为n秒或n天前时间数字格式化
     * @Author TTMY
     * @return datatime
     */
    public static String datatime(){
        Date date = new Date();//
        Date startDate = DateUtils.addDays(date, -30);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
        String beginDate1 = sdf1.format(date);
        String beginDate2 = sdf2.format(date);
        String delDate = sdf2.format(startDate);
        StringBuffer alltime = new StringBuffer();
        alltime.append(beginDate1);
        alltime.append(beginDate2);
        alltime.append(delDate);
        String datatime=alltime.toString();
        return datatime;
    }
}

