package hw1;

import hw1.model.User;

import java.util.Arrays;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        User[] users = {User.createUser(), User.createUser(), User.createUser()};

        printInitialStream(users);
        printResultOfFilterByAge(users);
        printUserWithTSmallestAge(users);
        printUserWithBiggestAge(users);
        printResultOfRemovingDuplicates(users);
        printResultOfSortingByAge(users);
    }

    public static void printInitialStream(User[] users) {
        System.out.println("----Initial Stream----");
        Stream<User> stream = Arrays.stream(users);
        stream.forEach(System.out::println);
    }

    public static void printResultOfFilterByAge(User[] users) {
        System.out.println("\n----Result of filtering by age----");
        Arrays.stream(users)
                .filter(user -> user.getAge() < 18)             // only minors
                .peek(user -> user.setAge(user.getAge() * 2))   // double the age
                .reduce((first, second) -> second)              // get last element in stream
                .ifPresentOrElse(System.out::println, () -> System.out.println("No users found"));
    }

    public static void printUserWithTSmallestAge(User[] users) {
        System.out.println("\n----The User with the smallest age----");
        Arrays.stream(users)
                .reduce((first, second) -> first.getAge() < second.getAge() ? first : second)
                .ifPresent(System.out::println);
    }

    public static void printUserWithBiggestAge(User[] users) {
        System.out.println("\n----The User with the biggest age----");
        Arrays.stream(users)
                .reduce((first, second) -> first.getAge() > second.getAge() ? first : second)
                .ifPresent(System.out::println);
    }

    public static void printResultOfRemovingDuplicates(User[] users) {
        System.out.println("\n----Result of removing duplicates----");
        Arrays.stream(users)
                .distinct()
                .forEach(System.out::println);
    }

    public static void printResultOfSortingByAge(User[] users) {
        System.out.println("\n----Result of sorting by age----");
        Arrays.stream(users)
                .filter(user -> user.getAge() > 30)                                          // only adults
                .peek(user -> user.setName(user.getName().toUpperCase()))                    // uppercase the name
                .sorted((first, second) -> Integer.compare(second.getAge(), first.getAge())) // sort by age, descending
                .forEach(System.out::println);
    }
}
