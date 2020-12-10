package mate.academy.boot.bootdemo.service.impl;

import mate.academy.boot.bootdemo.model.Day;
import mate.academy.boot.bootdemo.repository.DayRepository;
import mate.academy.boot.bootdemo.service.DayService;
import org.springframework.stereotype.Service;

@Service
public class DayServiceImpl implements DayService {
    private final DayRepository dayRepository;

    public DayServiceImpl(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
    }

    @Override
    public Day save(Day day) {
        return dayRepository.save(day);
    }
}
