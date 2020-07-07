package mate.academy.boot.bootdemo.service;


import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class FileReaderTest {
    private final FileReaderService fileReaderService
            = new FileReaderService();

    @Test
    public void readFileTest() {
        String path = "src/test/resources/test_file.txt";
        assertTrue(new File(path).exists());

        List<String> expected = List.of("test review file");
        List<String> actual = fileReaderService.readFile(path);
        Assert.assertEquals(expected,actual);
    }
}
