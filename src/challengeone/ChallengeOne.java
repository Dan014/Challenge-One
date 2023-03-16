/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challengeone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author DANIEL GARCIA
 */
public class ChallengeOne {

    public static void main(String[] args) {
        inputData();
    }
    
     /**
     * Se encarga de capturar los datos por teclado para crear
     * una lista numeros
     */
    public static void inputData() {
        Scanner sc = new Scanner(System.in);
        List<Integer> numberList = new ArrayList<>();// Se crea una lista vacía para almacenar los números
        int n = 0;
        while (n == 0) {
            System.out.print("Ingrese el tamaño de la lista de nuemeros que desea crear(máximo 100): ");
            if (sc.hasNextInt()) { // Comprueba si el siguiente valor en la entrada es un número entero
                n = sc.nextInt();
                if (n > 100) {
                    System.out.println("La cantidad de números no puede ser mayor a 100. Intente de nuevo.");
                    n = 0;
                }
            } else {
                System.out.println("Debe ingresar un número entero. Intente de nuevo.");
                sc.next(); // Limpia la entrada de caracteres no numéricos
            }
        }
        // Se pide al usuario que ingrese cada uno de los números y se agregan a la lista
        for (int i = 0; i < n; i++) {
            int number = 0;
            while (number == 0) {
                System.out.print("Ingrese el número " + (i + 1) + " de la lista: ");
                if (sc.hasNextInt()) { // Comprueba si el siguiente valor en la entrada es un número entero
                    number = sc.nextInt();
                    if (number >= 100) {
                        System.out.println("El número no puede ser mayor a 100. Intente de nuevo.");
                        number = 0;
                    }
                } else {
                    System.out.println("Debe ingresar un número entero. Intente de nuevo.");
                    sc.next(); // Limpia la entrada de caracteres no numéricos
                }
            }
            numberList.add(number);
        }
        System.out.println("Inicial");
        System.out.println(numberList);
        deleteDigits(numberList);
    }

    /**
     * Elimina los dígitos mayores a 8 de cada número en la lista de entrada y
     * devuelve una nueva lista con los números resultantes en orden inverso.
     * @param numbers lista de enteros
     */
    public static void deleteDigits(List<Integer> numbers) {
        List<Integer> numberList2 = new ArrayList<>();// Se crea una lista vacía para almacenar los nuevos números
        // Se recorre la lista de números y se crea un nuevo número sin los digitos mayores a 8 para cada número
        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i); // Se obtiene el número de la lista
            int newNumber = 0; // Se inicializa el nuevo número
            int potency = 1; // Se inicializa la potencia de 10 que se usará para construir el nuevo número
            while (number > 0) { // Mientras queden dígitos por procesar en el número original
                int digit = number % 10; // Se obtiene el último dígito del número original
                if (digit < 8) { // Si el dígito es diferente de 8
                    newNumber += digit * potency; // Se agrega el dígito al nuevo número
                    potency *= 10; // Se aumenta la potencia de 10 para agregar el siguiente dígito al nuevo número
                }
                number /= 10; // Se elimina el último dígito del número original
            }
            if (newNumber != 0) { // Si el nuevo número es diferente de cero o el número original es cero, se agrega a la lista final
                numberList2.add(newNumber);
            }
        }
        // Se invierte el orden de la lista
        // Se crea una lista vacía para almacenar los números invertidos
        List<Integer> finalList = new ArrayList<>();// Se recorre la lista numeros2 y se agrega cada elemento al principio de la nueva lista
        for (int i = numberList2.size() - 1; i >= 0; i--) {
            finalList.add(numberList2.get(i));
        }
        System.out.println("Final");
        System.out.println(finalList);
    }
}
