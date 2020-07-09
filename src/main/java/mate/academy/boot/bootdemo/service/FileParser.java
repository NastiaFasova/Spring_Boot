package mate.academy.boot.bootdemo.service;

import java.util.List;

public interface FileParser<T> {
    T parse(List<String> fileData);
}
