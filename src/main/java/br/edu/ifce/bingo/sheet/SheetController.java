package br.edu.ifce.bingo.sheet;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("api/v1/sheets")
public class SheetController {

    @PostMapping
    public Map<String, List<Integer>> generate() {
        var map = new HashMap<String, List<Integer>>();
        map.put("B", new ArrayList<>());
        map.put("I", new ArrayList<>());
        map.put("N", new ArrayList<>());
        map.put("G", new ArrayList<>());
        map.put("O", new ArrayList<>());
        var listB = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
        var listI = new ArrayList<>(List.of(16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30));
        var listN = new ArrayList<>(List.of(31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45));
        var listG = new ArrayList<>(List.of(46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60));
        var listO = new ArrayList<>(List.of(61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75));
        for (var i = 0; i < 5; i++) {
            var indexB = new Random().nextInt(listB.size());
            var indexI = new Random().nextInt(listI.size());
            var indexN = new Random().nextInt(listN.size());
            var indexG = new Random().nextInt(listG.size());
            var indexO = new Random().nextInt(listO.size());
            map.get("B").add(listB.get(indexB));
            map.get("I").add(listI.get(indexI));
            map.get("N").add(listN.get(indexN));
            map.get("G").add(listG.get(indexG));
            map.get("O").add(listO.get(indexO));
            listB.remove(indexB);
            listI.remove(indexI);
            listN.remove(indexN);
            listG.remove(indexG);
            listO.remove(indexO);
        }
        map.get("N").removeLast();
        Collections.sort(map.get("B"));
        Collections.sort(map.get("I"));
        Collections.sort(map.get("N"));
        Collections.sort(map.get("G"));
        Collections.sort(map.get("O"));
        return map;
    }
}
