package mate.academy.boot.bootdemo.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import mate.academy.boot.bootdemo.service.FileReaderService;
import org.springframework.stereotype.Service;

@Service
public class FileReaderServiceImpl implements FileReaderService {

    @Override
    public List<String> readFile(String path) {
        List<String> fileData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileData.add(line);
            }
            return fileData;
        } catch (IOException e) {
            throw new RuntimeException("Some errors while reading the file", e);
        }
    }
}
