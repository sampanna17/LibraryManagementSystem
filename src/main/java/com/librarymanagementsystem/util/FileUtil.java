package com.librarymanagementsystem.util;

import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

    public static void save(String fileName,
                            String data) {

        try (FileWriter writer =
                     new FileWriter(fileName, true)) {

            writer.write(data);
            writer.write("\n");

        } catch (IOException e) {

            System.out.println(
                    "Error writing file: "
                            + e.getMessage()
            );
        }
    }
}