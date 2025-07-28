package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoadFile {
    public static String loadFile(String fileName) throws IOException {
        return Files.readString(Paths.get("src/test/resources/" + fileName));
    }
}
