package mate.academy.boot.bootdemo.service;

import java.time.Instant;
import java.time.ZoneId;
import java.util.List;
import mate.academy.boot.bootdemo.model.dto.UserDto;
import mate.academy.boot.bootdemo.model.dto.mapper.UserDtoFromLinesMapper;
import mate.academy.boot.bootdemo.service.impl.CsvLinesParser;
import org.junit.Assert;
import org.junit.Test;

public class CsvParserTest {

    private UserDtoFromLinesMapper mapper = new UserDtoFromLinesMapper();

    private CsvLinesParser parser = new CsvLinesParser(mapper);

    @Test
    public void csvParserTest() {
        UserDto firstUser = new UserDto();
        firstUser.setId(1L);
        firstUser.setProductId("B001E4KFG0");
        firstUser.setUserId("A3SGXH7AUHU8GW");
        firstUser.setProfileName("delmartian");
        firstUser.setHelpfulnessNumerator(1L);
        firstUser.setHelpfulnessDenominator(1L);
        firstUser.setScore(5L);
        firstUser.setTime(Instant.ofEpochMilli(1303862400)
                .atZone(ZoneId.systemDefault()).toLocalDateTime());
        firstUser.setSummary("Good Quality Dog Food");
        firstUser.setText("I have bought several of the Vitality canned dog "
                + "food products and have found them all to be of good quality. "
                + "The product looks more like a stew than a processed meat and it smells better."
                + " My Labrador is finicky and she appreciates this product better than  most.");

        UserDto secondUser = new UserDto();
        secondUser.setId(1L);
        secondUser.setProductId("B001E4KFG0");
        secondUser.setUserId("A3SGXH7AUHU8GW");
        secondUser.setProfileName("delmartian");
        secondUser.setHelpfulnessNumerator(1L);
        secondUser.setHelpfulnessDenominator(1L);
        secondUser.setScore(5L);
        secondUser.setTime(Instant.ofEpochMilli(1303862400)
                .atZone(ZoneId.systemDefault()).toLocalDateTime());
        secondUser.setSummary("Good Quality Dog Food");
        secondUser.setText("I have bought several of the Vitality canned dog "
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
        Assert.assertEquals(List.of(firstUser, secondUser), parser.parse(usersList));
    }
}
