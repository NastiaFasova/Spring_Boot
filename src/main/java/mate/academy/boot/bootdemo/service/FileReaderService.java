package mate.academy.boot.bootdemo.service;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface FileReaderService {

    List<String> readFile(String path);
}
