package ru.pda;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

import static ru.pda.constants.ConstantDirPath.*;

public class Main {

    public static void main(String[] args) {

        LocalDateTime ldt = LocalDateTime.now();
        StringBuilder strb = new StringBuilder();
        strb.append(ldt).append("\n");

        createDirectory(SRCDIRPATH, strb);
        createDirectory(MAINDIRPATH, strb);
        createFile(MAINFILEPATH, strb);
        createFile(UTILSFILEPATH, strb);
        createDirectory(TESTDIRPATH, strb);
        createDirectory(RESDIRPATH, strb);
        createDirectory(DRAWDIRPATH, strb);
        createDirectory(VECTORDIRPATH, strb);
        createDirectory(ICONDIRPATH, strb);
        createDirectory(SAVEDIRPATH, strb);
        createDirectory(TMPDIRPATH, strb);
        createFile(TMPFILEPATH, strb);

        try {
            FileWriter fileWriter = new FileWriter(TMPFILEPATH);
            fileWriter.write(strb.toString());
            fileWriter.close();
        } catch (IOException e) {
            strb.append(e);
            e.printStackTrace();
        }
    }

    static void createDirectory(String path, StringBuilder strb) {
        File file = new File(path);
        strb.append(file.mkdir() ? "Каталог " + path + " создан.\n" :
                "Не удалось создать каталог " + path + "\n");
    }

    static void createFile(String path, StringBuilder strb) {
        File file = new File(path);
        try {
            strb.append(file.createNewFile() ? "Файл " + path + " успешно создан.\n" :
                    "Не удалось создать файл " + path + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
