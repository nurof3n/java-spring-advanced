package hw1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

@Data
@AllArgsConstructor
public class User {
    static private int CRT_ID = 0;

    private int id;
    private String name;
    private int age;

    /**
     * Creates a user with incremental id, random name of length 10 and random age between 0 and 100.
     *
     * @return a new user
     */
    public static User createUser() {
        return new User(++CRT_ID, RandomStringUtils.randomAlphabetic(10), (int) (Math.random() * 100));
    }
}
