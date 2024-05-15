package utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PayloadGenerator {

    public static String generateStringPayload(String fileName) throws IOException {
        String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\resource\\" + fileName;
        // src/main/java/resource/createRepo.json
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

}