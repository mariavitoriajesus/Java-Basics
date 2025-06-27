package Util;

import java.util.concurrent.atomic.AtomicLong;

public class GeradorNumeroConta {
    private static final AtomicLong contador = new AtomicLong(1);

    public static String gerar() {
        return String.format("%06d", contador.getAndIncrement());
    }
}
