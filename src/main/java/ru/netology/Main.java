package ru.netology;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        StringBuilder log = new StringBuilder();

        List<String> directories = List.of("Games/src", "Games/res", "Games/savegames", "Games/temp",
                "Games/src/main", "Games/src/test", "Games/res/drawables", "Games/res/vectors", "Games/res/icons");
        List<String> files = List.of("Games/src/main/Main.java", "Games/src/main/Utils.java", "Games/temp/temp.txt");

        createFolder(directories, log);
        createFiles(files, log);
    }

    static SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public static void createFiles(List<String> files, StringBuilder log) {
        Logger logger = new Logger();
        for (String filesPath : files) {
            File newFiles = new File(filesPath);

            try {
                if (newFiles.createNewFile()) {
                    log.append(date.format(new Date()) + " создан файл " + newFiles.getName() + "\n");
                } else {
                    log.append(date.format(new Date()) + " ошибка создания файла!!! " + newFiles.getName() + "\n");
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            logger.loggerWrite(newFiles, log);
        }
    }

    public static void createFolder(List<String> directories, StringBuilder log) {
        log.append("------------------------------------------------------------ \n");
        for (String dirPath : directories) {
            File newDir = new File(dirPath);

            if (newDir.mkdir()) {
                log.append(date.format(new Date()) + " создан каталог " + newDir.getName() + "\n");
            } else {
                log.append(date.format(new Date()) + " ошибка создания каталога!!! " + newDir.getName() + "\n");
            }
        }
    }
}

