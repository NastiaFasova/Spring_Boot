package mate.academy.boot.bootdemo.service.impl;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import java.util.ArrayList;
import java.util.List;
import mate.academy.boot.bootdemo.model.dto.ReviewLineDto;
import mate.academy.boot.bootdemo.model.mapper.ReviewFromLinesMapper;
import mate.academy.boot.bootdemo.service.FileParser;
import org.springframework.stereotype.Service;

@Service
public class CsvLinesParser implements FileParser<List<ReviewLineDto>> {
    private final ReviewFromLinesMapper mapper;

    public CsvLinesParser(ReviewFromLinesMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<ReviewLineDto> parse(List<String> usersData) {
        CsvParserSettings settings = new CsvParserSettings();
        settings.setMaxCharsPerColumn(100000);
        CsvParser csvParser = new CsvParser(settings);
        List<ReviewLineDto> reviewLineDtos = new ArrayList<>();
        for (String user : usersData) {
            String[] parsedLine = csvParser.parseLine(user);
            reviewLineDtos.add(mapper.getReviewLinesDtoFromLines(parsedLine));
        }
        return reviewLineDtos;
    }
}
