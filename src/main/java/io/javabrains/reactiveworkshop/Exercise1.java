package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream().forEach(i -> System.out.println(i));

        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream().filter(i -> i < 5)
                .forEach(n -> System.out.println(n));


        // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream().filter(i -> i > 5)
                .skip(1)
                .limit(2)
                .forEach(n -> System.out.println(n));

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        Integer value = StreamSources.intNumbersStream()
                .filter(i -> i > 5)
                .findFirst()
                .orElse(-1);
        System.out.println(value);

        // Print first names of all users in userStream
        StreamSources.userStream()
                .map(user -> user.getFirstName())
                .forEach(firstName -> System.out.println(firstName));

        // Print first names in userStream for users that have IDs from number stream
//      Cristiano
//      Diego
//      Zinedine
//      Gareth
//        StreamSources.intNumbersStream()
//                .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
//                .forEach(user -> System.out.println(user.getFirstName()));

//        User{id=2, firstName='Cristiano', lastName='Ronaldo'}
//        User{id=2, firstName='Diego', lastName='Maradona'}
//        User{id=4, firstName='Zinedine', lastName='Zidane'}
//        User{id=6, firstName='Gareth', lastName='Bale'}
        StreamSources.userStream()
                .filter(u -> StreamSources.intNumbersStream().anyMatch(i -> i == u.getId()))
                .forEach(System.out::println);

    }

}
