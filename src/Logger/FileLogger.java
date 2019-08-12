package Logger;

import java.io.File;

public class FileLogger implements Logger{

    private static  FileLogger logger;

    //Private constructor
    private FileLogger() {

    }

    public static FileLogger getFileLogger() {
        if (logger == null) {
            logger = new FileLogger();
        }
        return logger;
    }

    public synchronized  void log(String msg) {
        FileUtil fileUtil = new FileUtil();
        fileUtil.writeToFile("log.txt", msg, true, true);
    }



}
