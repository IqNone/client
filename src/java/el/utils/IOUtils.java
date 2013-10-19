package el.utils;

import java.io.IOException;
import java.io.InputStream;

public class IOUtils {
    public static void closeQuite(InputStream is) {
        if(is != null) {
            try {is.close(); } catch (IOException ignored) { }
        }
    }
}
