package ru.gb.homework.file_handler;

import java.io.*;
import java.nio.file.Path;

public class FileHandler {
    public void write(Path path, String content) throws IOException{
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile(), true))) {
            writer.write(content);
        }
    }

    public String read(Path path) throws IOException {
        String s = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            while ((reader.readLine()) != null) {
                s = reader.readLine();
            }
        }
        return s;
    }
}
