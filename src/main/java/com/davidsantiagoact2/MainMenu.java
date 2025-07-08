package com.davidsantiagoact2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Animal> animales = new ArrayList<>();
    private static int contadorId = 1;

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            int opcion = leerOpcion();

            switch (opcion) {
                case 1 -> crearAnimal();
                case 2 -> consultarAnimales();
                case 3 -> actualizarAnimal();
                case 4 -> eliminarAnimal();
                case 5 -> {
                    System.out.println("Saliendo del sistema...");
                    salir = true;
                }
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n===== MENÚ PRINCIPAL =====");
        System.out.println("1. Crear Animal");
        System.out.println("2. Consultar Animal");
        System.out.println("3. Actualizar Animal");
        System.out.println("4. Eliminar Animal");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // opción inválida
        }
    }

    private static void crearAnimal() {
        System.out.print("Ingrese el nombre del animal: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la edad del animal: ");
        int edad = Integer.parseInt(scanner.nextLine());

        System.out.print("Ingrese el sexo del animal (M/F): ");
        String sexo = scanner.nextLine();

        Animal animal = new Animal(contadorId++, nombre, edad, sexo);
        animales.add(animal);

        System.out.println("✅ Animal creado correctamente.");
    }

    private static void consultarAnimales() {
        if (animales.isEmpty()) {
            System.out.println("📭 No hay animales registrados.");
            return;
        }

        System.out.println("\n📋 Lista de Animales:");
        for (Animal animal : animales) {
            System.out.println(animal);
        }
    }

    private static void actualizarAnimal() {
        System.out.print("Ingrese el ID del animal a actualizar: ");
        int id = Integer.parseInt(scanner.nextLine());

        Animal animal = buscarAnimalPorId(id);
        if (animal == null) {
            System.out.println("⚠️ Animal no encontrado.");
            return;
        }

        System.out.print("Nuevo nombre: ");
        animal.setNombre(scanner.nextLine());

        System.out.print("Nueva edad: ");
        animal.setEdad(Integer.parseInt(scanner.nextLine()));

        System.out.print("Nuevo sexo (M/F): ");
        animal.setSexo(scanner.nextLine());

        System.out.println("✅ Animal actualizado correctamente.");
    }

    private static void eliminarAnimal() {
        System.out.print("Ingrese el ID del animal a eliminar: ");
        int id = Integer.parseInt(scanner.nextLine());

        Animal animal = buscarAnimalPorId(id);
        if (animal == null) {
            System.out.println("⚠️ Animal no encontrado.");
            return;
        }

        animales.remove(animal);
        System.out.println("🗑️ Animal eliminado correctamente.");
    }

    private static Animal buscarAnimalPorId(int id) {
        for (Animal animal : animales) {
            if (animal.getIdAnimal() == id) {
                return animal;
            }
        }
        return null;
    }
}
