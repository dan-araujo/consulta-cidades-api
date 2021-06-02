package br.com.daniel.arj.consultacidadesapi.utils;

public class LocalizacaoStringUtils {
    public static Double[] transform(String geolocation) {
        String resultado = geolocation.replace("(", "").replace(")", "");
        String[] strings = resultado.trim().split(",");
        return new Double[] {Double.valueOf(strings[0]), Double.valueOf(strings[1])};
    }
}
