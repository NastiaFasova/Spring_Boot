package mate.academy.boot.bootdemo.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.boot.bootdemo.service.FileReaderService;
import org.springframework.stereotype.Service;

@Service
public class FileReaderServiceImpl implements FileReaderService {
    private static final int FIRST_ROW = 1;

    @Override
    public List<String> readFile(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            return reader.lines().skip(FIRST_ROW).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Some errors while reading the file", e);
        }
    }
}
