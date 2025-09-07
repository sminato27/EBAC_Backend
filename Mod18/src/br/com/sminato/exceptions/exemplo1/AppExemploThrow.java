package br.com.sminato.exceptions.exemplo1;

public class AppExemploThrow {
    public static void main(String[] args) {
        exception();
        runtimeException();
    }

    private static void exception() {
        try {
            ExemploThrow.saque(500);
        } catch (LimiteSaqueException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    private static void runtimeException() {
        ExemploThrow.saqueRuntimeException(500);
    }
}
