package com.cihatturhan.datareader.dataloader.utils;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
public class CSVFileReader {
    public List<String> csvFileToStringList(String filePath) {
        List<String> linesInFile = new ArrayList<>();

        try {
            BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(filePath));

            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                linesInFile.add(line);

            }

        } catch (NoSuchFileException noSuchFileException) {
            System.out.println("csv file can not be found");

        } catch (Exception e) {
            System.out.println(e);
        }

        return linesInFile;
    }
}
