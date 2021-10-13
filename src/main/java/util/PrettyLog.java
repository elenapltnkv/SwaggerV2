package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.internal.platform.Platform;
import okhttp3.logging.HttpLoggingInterceptor;

import javax.swing.text.html.ObjectView;

public class PrettyLog implements HttpLoggingInterceptor.Logger {

    @Override
    public void log(String s) {
        String massage = s.trim();
        ObjectMapper mapper = new ObjectMapper();
        if (massage.startsWith("{") && (massage.endsWith("}"))||(massage.startsWith("[") && massage.endsWith("]"))){
            massage= s;
            try {
                Object value = mapper.readValue(massage, Object.class);
                String prettyJsonValue = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(value);
                Platform.get().log(Platform.INFO, prettyJsonValue, null);
                mapper.writerWithDefaultPrettyPrinter().writeValueAsString(s);
            } catch (JsonProcessingException e) {
                Platform.get().log(Platform.WARN, massage, e);
            }
        }else {
            Platform.get().log(Platform.INFO, massage, null);
        }
    }
}
