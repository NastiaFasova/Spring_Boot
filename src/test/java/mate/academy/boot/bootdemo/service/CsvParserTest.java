package mate.academy.boot.bootdemo.service;

import java.time.Instant;
import java.time.ZoneId;
import java.util.List;

import mate.academy.boot.bootdemo.model.dto.ReviewDto;
import mate.academy.boot.bootdemo.model.dto.ReviewLineDto;
import mate.academy.boot.bootdemo.model.mapper.ReviewFromLinesMapper;
import mate.academy.boot.bootdemo.service.impl.CsvLinesParser;
import org.junit.Assert;
import org.junit.Test;

public class CsvParserTest {

    private ReviewFromLinesMapper mapper = new ReviewFromLinesMapper();

    private CsvLinesParser parser = new CsvLinesParser(mapper);

    @Test
    public void csvParserTest() {
        ReviewLineDto reviewLineDto = new ReviewLineDto();
        reviewLineDto.setProductId("B001E4KFG0");
        reviewLineDto.setUserId("A3SGXH7AUHU8GW");
        reviewLineDto.setProfileName("delmartian");
        reviewLineDto.setHelpfulnessNumerator(1L);
        reviewLineDto.setHelpfulnessDenominator(1L);
        reviewLineDto.setScore(5L);
        reviewLineDto.setTime(Instant.ofEpochMilli(1303862400)
                .atZone(ZoneId.systemDefault()).toLocalDateTime());
        reviewLineDto.setSummary("Good Quality Dog Food");
        reviewLineDto.setText("I have bought several of the Vitality canned dog "
                + "food products and have found them all to be of good quality. "
                + "The product looks more like a stew than a processed meat and it smells better."
                + " My Labrador is finicky and she appreciates this product better than  most.");

        ReviewLineDto secondReviewLineDto = new ReviewLineDto();
        secondReviewLineDto.setProductId("B001E4KFG0");
        secondReviewLineDto.setUserId("A3SGXH7AUHU8GW");
        secondReviewLineDto.setProfileName("delmartian");
        secondReviewLineDto.setHelpfulnessNumerator(1L);
        secondReviewLineDto.setHelpfulnessDenominator(1L);
        secondReviewLineDto.setScore(5L);
        secondReviewLineDto.setTime(Instant.ofEpochMilli(1303862400)
                .atZone(ZoneId.systemDefault()).toLocalDateTime());
        secondReviewLineDto.setSummary("Good Quality Dog Food");
        secondReviewLineDto.setText("I have bought several of the Vitality canned dog "
                + "food products and have found them all to be of good quality. "
                + "The product looks more like a stew than a processed meat and it smells better."
                + " My Labrador is finicky and she appreciates this product better than  most.");

        String firstUserData = "1,B001E4KFG0,A3SGXH7AUHU8GW,delmartian,1,1,5,1303862400,"
                + "Good Quality Dog Food,I have bought several of the Vitality canned "
                + "dog food products and have found them all to be of good quality. "
                + "The product looks more like a stew than a processed meat and it smells better. "
                + "My Labrador is finicky and she appreciates this product better than  most.";
        String secondUserData = "1,B001E4KFG0,A3SGXH7AUHU8GW,delmartian,1,1,5,1303862400,Good Quality Dog Food,"
                + "I have bought several of the Vitality canned dog food products and have found "
                + "them all to be of good quality. The product looks more like a stew than a"
                + " processed meat and it smells better. My Labrador is finicky and she "
                + "appreciates this product better than  most.";
        List<String> usersList = List.of(firstUserData, secondUserData);
        Assert.assertEquals(List.of(reviewLineDto, secondReviewLineDto), parser.parse(usersList));
    }
}
