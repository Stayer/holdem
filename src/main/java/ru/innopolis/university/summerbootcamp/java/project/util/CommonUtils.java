package ru.innopolis.university.summerbootcamp.java.project.util;


public class CommonUtils {
    public static <T extends Comparable<T>> boolean isInRange(T begin, T value, T end) {
        return (begin.compareTo(value) <=0 ) && (value.compareTo(end) <= 0);
    }
}
