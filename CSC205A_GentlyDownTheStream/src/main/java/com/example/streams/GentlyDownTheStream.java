package com.example.streams;

import java.util.*;
import java.util.stream.Collectors;


public class GentlyDownTheStream {


    protected List<String> fruits;
    protected List<String> veggies;
    protected List<Integer> integerValues;

    public GentlyDownTheStream() {
        fruits = Arrays.asList("Apple", "Orange", "Banana", "Pear", "Peach", "Tomato");
        veggies = Arrays.asList("Corn", "Potato", "Carrot", "Pea", "Tomato");
        integerValues = new Random().ints(0, 1001)
                .boxed()
                .limit(1000)
                .collect(Collectors.toList());
    }



    // TODO - return a list of sorted fruits based on the fruits list
    //done
    public List<String> sortedFruits() {
        return fruits.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    // TODO - return a list of sorted fruits with all fruits filtered out that start with "A"
    //done
    public List<String> sortedFruitsException() {
        return fruits.stream()
                .filter(x -> !x.startsWith("A"))
                .sorted()
                .collect(Collectors.toList());
    }

    // TODO - return a list with the first 2 elements of a sorted list of fruits
    //done
    public List<String> sortedFruitsFirstTwo() {
        return fruits.stream()
                .sorted()
                .limit(2)
                .collect(Collectors.toList());
    }

    // TODO - return a comma separated String of sorted fruits
    //done
    public String commaSeparatedListOfFruits() {
        return fruits.stream()
                .sorted()
                .collect(Collectors.joining(", "));
    }

    // TODO - return a list of veggies that are sorted in reverse (descending) order
    public List<String> reverseSortedVeggies() {
        return veggies.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    // TODO - return a list of veggies that are sorted in reverse order, and all in upper case
    //done
    public List<String> reverseSortedVeggiesInUpperCase() {
        return veggies.stream()
                .sorted(Comparator.reverseOrder())
                .map(v -> v.toUpperCase())
                .collect(Collectors.toList());
    }

    // TODO - return a list of the top 10 values in the list of random integers
    //done
    public List<Integer> topTen() {
        return integerValues.stream()
                .sorted(Comparator.reverseOrder())
                .limit(10)
                .collect(Collectors.toList());
    }

    // TODO - return a list of the top 10 unique values in the list of random integers
    //done
    public List<Integer> topTenUnique() {
        return integerValues.stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .limit(10)
                .collect(Collectors.toList());
    }

    // TODO - return a list of the top 10 unique values in the list of random integers that are odd
    //done
    public List<Integer> topTenUniqueOdd() {
        return integerValues.stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .filter(x -> x % 2 != 0)
                .limit(10)
                .collect(Collectors.toList());
    }

    // TODO - return a single value that represents the average of all of your random numbers
    //done
    public Double average() {
        return integerValues.stream()
                .mapToInt(i -> i)
                .average()
                .getAsDouble();
    }
}


