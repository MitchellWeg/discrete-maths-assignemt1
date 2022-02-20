package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    private static ISentient Trump = new Human("Trump");

    public static void main(String[] args) {
        List<ISentient> allDomain = prepareForAllDomain();
        List<ISentient> existsDomain = prepareThereExistsDomain();
        Predicate<ISentient> predicate = preparePredicate();

        boolean resultForAll = forAll(allDomain, predicate);
        boolean resultForAllShouldBeFalse = forAll(existsDomain, predicate);
        boolean resulThereExists = thereExists(existsDomain, predicate);

        System.out.println("True: " + resultForAll);
        System.out.println("False: " + resultForAllShouldBeFalse);
        System.out.println("True: " + resulThereExists);
    }

    private static boolean thereExists(List<ISentient> domain, Predicate<ISentient> predicate) {
        return domain.stream().anyMatch(predicate);
    }

    private static boolean forAll(List<ISentient> domain, Predicate<ISentient> predicate) {
        return domain.stream().allMatch(predicate);
    }

    private static Predicate<ISentient> preparePredicate() {
        return pred -> pred.likes(Trump);
    }

    private static List<ISentient> prepareThereExistsDomain() {
        List<ISentient> humans = new ArrayList<>();

        Human human1 = new Human("Piet");
        Human human2 = new Human("Klaas");

        human1.setLikes(Trump);

        humans.add(human1);
        humans.add(human2);

        return humans;
    }

    private static List<ISentient> prepareForAllDomain() {
        List<ISentient> humans = new ArrayList<>();

        Human human1 = new Human("Henk");
        Human human2 = new Human("Kees");

        human1.setLikes(Trump);
        human2.setLikes(Trump);

        humans.add(human1);
        humans.add(human2);

        return humans;
    }
}

