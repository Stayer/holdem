package ru.innopolis.university.summerbootcamp.java.project.util;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReaderWriterUtil {

    private static String readFileToString(String path) {

        FileReaderWriterUtil fileReaderWriterUtil = new FileReaderWriterUtil();
        ClassLoader classLoader = fileReaderWriterUtil.getClass().getClassLoader();
        File file = new File(classLoader.getResource(path).getFile());

        byte[] encoded = new byte[0];
        try {
            encoded = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(encoded, StandardCharsets.UTF_8);
    }

    public static String readFile(String templateName) {
        return readFileToString(templateName);
    }

    public static void writeGeneratedStringToFile(String text, String fileName) {
        FileReaderWriterUtil fileReaderWriterUtil = new FileReaderWriterUtil();
        ClassLoader classLoader = fileReaderWriterUtil.getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter(file, false));
            out.write(text);
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

}
