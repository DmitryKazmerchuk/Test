package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

class MainTest {
    static List<String> files = List.of("Games/src/main/Main.java", "Games/src/main/Utils.java", "Games/temp/temp.txt");
    StringBuilder log = new StringBuilder();
    @Test
    void createFolder() {
        List<String> dirTrue = List.of("Games/src", "Games/res", "Games/savegames", "Games/temp",
                "Games/src/main", "Games/src/test", "Games/res/drawables", "Games/res/vectors", "Games/res/icons");
        Main.createFolder(dirTrue,log);
        for(String dirPath : dirTrue) {
            Assertions.assertTrue(Files.exists(Path.of(dirPath)));
        }
    }

    @Test
    void createFiles() {
        Main.createFiles(files,log);
        for(String filesPath : files) {
            Assertions.assertTrue(Files.exists(Path.of(filesPath)));
        }
    }
    @Test
    void canReadFiles() {
        Main.createFiles(files,log);
        for(String filesPath : files) {
            Assertions.assertTrue(new File(filesPath).canRead());
        }
    }
    @Test
    void canWriteFiles() {
        Main.createFiles(files,log);
        for(String filesPath : files) {
            Assertions.assertTrue(new File(filesPath).canWrite());
        }
    }
}