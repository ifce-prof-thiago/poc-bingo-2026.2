//package br.edu.ifce.bingo.sheets.domain.usecases;
//
//import br.edu.ifce.bingo.sheets.domain.model.Sheet;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.stereotype.Component;
//
//import java.nio.charset.StandardCharsets;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.util.HexFormat;
//import java.util.List;
//
//@Component
//public class CreateSheetUseCase {
//
//    private final MongoTemplate mongo;
//
//    public CreateSheetUseCase(MongoTemplate mongo) {
//        this.mongo = mongo;
//    }
//
//    public void execute() {
//        var gameId = "11";
//        var listB = List.of(1, 2, 3);
//        var listI = List.of(1, 2, 2);
//        var listN = List.of(1, 2, 3);
//        var listG = List.of(1, 2, 3);
//        var listO = List.of(1, 2, 3);
//        var text = "%s%s%s%s%s%s".formatted(
//                gameId,
//                listB,
//                listI,
//                listN,
//                listG,
//                listO
//        );
//        var hash = sha256(text);
//        var sheet = new Sheet(
//                null,
//                gameId,
//                listB,
//                listI,
//                listN,
//                listG,
//                listO,
//                hash
//        );
//        mongo.insert(sheet);
//    }
//
//    public static String sha256(String texto) {
//        try {
//            MessageDigest digest = MessageDigest.getInstance("SHA-256");
//            byte[] hash = digest.digest(
//                    texto.getBytes(StandardCharsets.UTF_8)
//            );
//            return HexFormat.of().formatHex(hash);
//
//        } catch (NoSuchAlgorithmException e) {
//            throw new IllegalStateException("SHA-256 não disponível", e);
//        }
//    }
//}
