package mate.academy.boot.bootdemo.service;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface FileReaderService {

    List<String> readFile(String path);
}
