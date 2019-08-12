package Logger;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class LoggerFactory {

    public boolean isFileLogginEnabled() {
        Properties p = new Properties();

        try {
            p.load(ClassLoader.getSystemResourceAsStream("logger.properties"));
                String fileLogginValue = p.getProperty("FileLoggin");
                if (fileLogginValue.equalsIgnoreCase("ON") == true)
                {
                    return true;
                }
                else
                {
                    return false;
                }

        }
        catch (IOException e)
        {
            return false;
        }
    }

    //Factory Method
    public Logger getLogger() {
        if (isFileLogginEnabled()) {
            return FileLogger.getFileLogger();
        }
        else
        {
            return new ConsoleLogger();
        }
    }
}
