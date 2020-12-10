package mate.academy.boot.bootdemo.service;

import mate.academy.boot.bootdemo.model.Lesson;

import java.util.List;

public interface LessonService {
    List<Lesson> getAllLessonsByGroupId(String id);
}
