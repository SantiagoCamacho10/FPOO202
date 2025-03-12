import java.util.Random;
import java.time.Year;
import javax.swing.*;
/*Usando P.O.O, con su Clase Encapsulada y con su respectivo constructor:
1. Crea un Programa que solicite Nombre, Apellido Paterno, Apellido Materno, Año de nacimiento y carrera
2. Con los datos solicitados el programa debe de generar una matricula con las siguientes caracteristicas
- Primera Letra del nombre
- 2 letras de cada apellido
- 2 ultimos digitos del año de nacimiento
- 2 ultimos digitos del año en curso
- 3 primeras letras de la carrera
- 2 digitos aleatorios
3. Debe solicitar los datos con JOptionPane, e igual mostrar el resultado
Resultado Esperado IGULO8725SIS79
Info del Resultado Esperado:
Nombre: Ivan
Apellido paterno: Guerra
Apellido materno: Lopez
Año de nacimiento: 1987
Carrera: Sistemas
Ultimos dos digitos son aleatorios
-----E  X   A   M   E   N       T   I   P   O       "A"*/
import javax.swing.JOptionPane;
public class Main {
    public static void main(String[] args) {
        // Solicitar datos al usuario con JOptionPane
        String nombre = JOptionPane.showInputDialog("Nombre:");
        String apellidoPaterno = JOptionPane.showInputDialog("Apellido Paterno:");
        String apellidoMaterno = JOptionPane.showInputDialog("Apellido Materno:");
        int anioNacimiento = Integer.parseInt(JOptionPane.showInputDialog("Año de Nacimiento:"));
        String carrera = JOptionPane.showInputDialog("Carrera:");

        // Crear objeto GenerarMatricula
        GenerarMatricula estudiante = new GenerarMatricula(nombre, apellidoPaterno, apellidoMaterno, anioNacimiento, carrera);

        // Mostrar matrícula generada por separado
        JOptionPane.showMessageDialog(null, "Matrícula Generada: " + estudiante.getMatricula());


    }
}

