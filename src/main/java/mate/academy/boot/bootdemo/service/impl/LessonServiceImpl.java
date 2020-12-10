package mate.academy.boot.bootdemo.service.impl;

import mate.academy.boot.bootdemo.model.Lesson;
import mate.academy.boot.bootdemo.repository.LessonRepository;
import mate.academy.boot.bootdemo.service.LessonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;

    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public List<Lesson> getAllLessonsByGroupId(String id) {
        return lessonRepository.getAllLessonsByGroupId(id);
    }
}
