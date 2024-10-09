package helper;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;
import java.util.Random;

public class Utility {
    public static File getJSONSchemaFile(String JSONFile) {
        return new File("src/test/java/helper/JSONSchemaData/" + JSONFile);
    }

    public static String generateRandomEmail() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
        String email = "";
        String temp = RandomStringUtils.randomAlphanumeric(10);
        email = temp + "@testdata.com";
        return email;
    }

    public static String generate1CharName() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz";
        String name = "";
        String temp = RandomStringUtils.randomAlphabetic(1);
        name = temp;
        return name;
    }

    public static String generate200CharName() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz";
        String name = "";
        String temp = RandomStringUtils.randomAlphabetic(200);
        name = temp;
        return name;
    }

    public static String generate201CharName() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz";
        String name = "";
        String temp = RandomStringUtils.randomAlphabetic(201);
        name = temp;
        return name;
    }

    public static String generate1CharEmail() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
        String email = "";
        String temp = RandomStringUtils.randomAlphanumeric(1);
        email = temp + "@testdata.com";
        return email;
    }

    public static String generate200CharEmail() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
        String email = "";
        String temp = RandomStringUtils.randomAlphanumeric(187);
        email = temp + "@testdata.com";
        return email;
    }

    public static String generate201CharEmail() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
        String email = "";
        String temp = RandomStringUtils.randomAlphanumeric(188);
        email = temp + "@testdata.com";
        return email;
    }

    public static String generateInvalidEmail() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
        String email = "";
        String temp = RandomStringUtils.randomAlphanumeric(10);
        email = temp;
        return email;
    }

    public static String generateValidGender() {
        String[] validGenders = {"male", "female"};
        Random random = new Random();
        int randomIndex = random.nextInt(validGenders.length);
        return validGenders[randomIndex];
    }

    public static String generateValidStatus() {
        String[] validGenders = {"active", "inactive"};
        Random random = new Random();
        int randomIndex = random.nextInt(validGenders.length);
        return validGenders[randomIndex];
    }
}

