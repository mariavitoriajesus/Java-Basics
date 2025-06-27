package Util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataUtil {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static String formatar(LocalDateTime dataHora) {
        return dataHora.format(FORMATTER);
    }
}
