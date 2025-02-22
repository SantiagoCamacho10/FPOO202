import javax.swing.*;

public class generar_Pass {
    public int lenght = 8;
    public boolean include_May;
    public boolean caract_Esp;

    public static String NUMEROS = "0123456789";
    public static String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
    public static String ESPECIALES = "!@#$%&*?_-";

    // Si no se especifican opciones
    public static String getPassword(int length) {
        return getPassword(NUMEROS + MAYUSCULAS + MINUSCULAS, length);
    }

    // Generar una contraseña a partir de la clave "key"
    public static String getPassword(String key, int length) {
        String pswd = "";

        for (int i = 0; i < length; i++) {
            pswd += (key.charAt((int) (Math.random() * key.length())));
        }
        return pswd;
    }

    // Generar contraseña de acuerdo con las opciones elegidas
    public static String getPassword(int length, boolean includeMay, boolean includeEsp) {
        // Siempre incluimos números y minúsculas
        String key = MINUSCULAS + NUMEROS;

        if (includeMay) {
            key += MAYUSCULAS;
        }
        if (includeEsp) {
            key += ESPECIALES;
        }
        return getPassword(key, length);
    }
}


