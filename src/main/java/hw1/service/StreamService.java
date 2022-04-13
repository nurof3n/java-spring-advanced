package hw1.service;

import hw1.model.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StreamService {
    private final User[] users;

    public StreamService() {
        users = new User[]{User.createUser(), User.createUser(), User.createUser()};
    }


    public List<User> getFullStream() {
        System.out.println("----Full Stream Request----");
        Stream<User> stream = Arrays.stream(users);
        return stream.collect(Collectors.toList());
    }

    public Optional<User> getResultOfFilterByAge() {
        System.out.println("----Filter by age request----");
        return Arrays.stream(users)
                .filter(user -> user.getAge() < 18)             // only minors
                .peek(user -> user.setAge(user.getAge() * 2))   // double the age
                .reduce((first, second) -> second);             // get last element in stream
    }

    public Optional<User> getUserWithTSmallestAge() {
        System.out.println("----User with the smallest age request----");
        return Arrays.stream(users)
                .reduce((first, second) -> first.getAge() < second.getAge() ? first : second);
    }

    public Optional<User> getUserWithBiggestAge() {
        System.out.println("----User with the biggest age request----");
        return Arrays.stream(users)
                .reduce((first, second) -> first.getAge() > second.getAge() ? first : second);
    }

    public List<User> getResultOfRemovingDuplicates() {
        System.out.println("----Remove duplicates request----");
        return Arrays.stream(users)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<User> getResultOfSortingByAge() {
        System.out.println("----Sort by age request----");
        return Arrays.stream(users)
                .filter(user -> user.getAge() > 30)                                          // only adults
                .peek(user -> user.setName(user.getName().toUpperCase()))                    // uppercase the name
                .sorted((first, second) -> Integer.compare(second.getAge(), first.getAge())) // sort by age, descending
                .collect(Collectors.toList());
    }
}
