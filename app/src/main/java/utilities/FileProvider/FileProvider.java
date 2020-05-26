package utilities.FileProvider;

import java.lang.Object;
import com.google.gson.Gson;
import java.io.*;

//TODO evtl. Generics
public class FileProvider {
    private Gson gson;
    private String filePath;

    public FileProvider(String filePath) {
        this.filePath = filePath;
        gson = new Gson();
    }

    private Object read() {
        String content = "";
        try {
            FileReader reader = new FileReader(filePath);
            while(reader.read() != -1) {
                content += (char) reader.read();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gson.fromJson(content, Object.class);
    }

    private void write(Object obj) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(gson.toJson(obj));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
