package br.edu.ifce.bingo.sheets.core.shared;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public interface IHash {

    static String sha256(final String texto) {
        try {
            final var digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(
                    texto.getBytes(StandardCharsets.UTF_8)
            );
            return HexFormat.of().formatHex(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 não disponível", e);
        }
    }
}
