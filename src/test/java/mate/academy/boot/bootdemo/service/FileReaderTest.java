package mate.academy.boot.bootdemo.service;

import java.io.File;
import java.util.List;
import mate.academy.boot.bootdemo.service.impl.FileReaderServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class FileReaderTest {
    private final FileReaderServiceImpl fileReaderService
            = new FileReaderServiceImpl();

    @Test
    public void readFileTest() {
        String path = "src/test/resources/test_file.txt";
        assertTrue(new File(path).exists());

        List<String> expected = List.of("test review file");
        List<String> actual = fileReaderService.readFile(path);
        Assert.assertEquals(expected,actual);
    }
}
