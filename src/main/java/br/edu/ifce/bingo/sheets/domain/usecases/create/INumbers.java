package br.edu.ifce.bingo.sheets.domain.usecases.create;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public interface INumbers {
    List<Integer> listB = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
    List<Integer> listI = List.of(16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30);
    List<Integer> listN = List.of(31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45);
    List<Integer> listG = List.of(46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60);
    List<Integer> listO = List.of(61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75);

    static List<Integer> randomB() {
        return random(listB, 5);
    }

    static List<Integer> randomI() {
        return random(listI, 5);
    }

    static List<Integer> randomN() {
        return random(listN, 4);
    }

    static List<Integer> randomG() {
        return random(listG, 5);
    }

    static List<Integer> randomO() {
        return random(listO, 5);
    }

    static List<Integer> random(List<Integer> list, int n) {
        var numbers = new ArrayList<Integer>();
        var copyList = new ArrayList<>(list);
        for (var i = 0; i < n; i++) {
            var index = new Random().nextInt(copyList.size());
            numbers.add(copyList.get(index));
            copyList.remove(index);
        }
        Collections.sort(numbers);
        return numbers;
    }

}
