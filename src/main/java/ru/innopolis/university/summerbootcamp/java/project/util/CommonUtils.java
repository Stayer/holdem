package ru.innopolis.university.summerbootcamp.java.project.util;


public class CommonUtils {
    /**
     * checks if value in [begin; end]
     * @param begin
     * @param value
     * @param end
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> boolean isIn(T begin, T value, T end) {
        return (begin.compareTo(value) <= 0 ) && (value.compareTo(end) <= 0);
    }

    /**
     * checks if value in (begin; end]
     * @param begin
     * @param value
     * @param end
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> boolean isInExclusiveL(T begin, T value, T end) {
        return (begin.compareTo(value) < 0 ) && (value.compareTo(end) <= 0);
    }

    /**
     * checks if value in [begin; end)
     * @param begin
     * @param value
     * @param end
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> boolean isInExclusiveR(T begin, T value, T end) {
        return (begin.compareTo(value) <= 0 ) && (value.compareTo(end) < 0);
    }

    /**
     * checks if value in (begin; end)
     * @param begin
     * @param value
     * @param end
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> boolean isInExclusive(T begin, T value, T end) {
        return (begin.compareTo(value) < 0 ) && (value.compareTo(end) < 0);
    }
}
