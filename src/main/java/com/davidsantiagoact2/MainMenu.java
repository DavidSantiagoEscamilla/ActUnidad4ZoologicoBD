package com.davidsantiagoact2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.davidsantiagoact2.clases.Animal;
import com.davidsantiagoact2.clases.Cuidador;

public class MainMenu {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Animal> animales = new ArrayList<>();
    private static final List<Cuidador> cuidadores = new ArrayList<>();
    private static int contadorIdAnimal = 1;
    private static int contadorIdCuidador = 1;

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
                case 5 -> crearCuidador();
                case 6 -> consultarCuidadores();
                case 7 -> actualizarCuidador();
                case 8 -> eliminarCuidador();
                case 9 -> {
                    System.out.println("👋 Saliendo del sistema...");
                    salir = true;
                }
                default -> System.out.println("❌ Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n===== MENÚ PRINCIPAL =====");
        System.out.println("1. Crear Animal");
        System.out.println("2. Consultar Animales");
        System.out.println("3. Actualizar Animal");
        System.out.println("4. Eliminar Animal");
        System.out.println("5. Crear Cuidador");
        System.out.println("6. Consultar Cuidadores");
        System.out.println("7. Actualizar Cuidador");
        System.out.println("8. Eliminar Cuidador");
        System.out.println("9. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void crearAnimal() {
        System.out.print("Ingrese el nombre del animal: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la edad del animal: ");
        int edad = Integer.parseInt(scanner.nextLine());

        System.out.print("Ingrese el sexo del animal (M/F): ");
        String sexo = scanner.nextLine();

        Animal animal = new Animal(contadorIdAnimal++, nombre, edad, sexo);
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

    private static void crearCuidador() {
        System.out.print("Ingrese el nombre del cuidador: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la especialidad del cuidador: ");
        String especialidad = scanner.nextLine();

        Cuidador cuidador = new Cuidador(contadorIdCuidador++, nombre, especialidad);
        cuidadores.add(cuidador);

        System.out.println("✅ Cuidador creado correctamente.");
    }

    private static void consultarCuidadores() {
        if (cuidadores.isEmpty()) {
            System.out.println("📭 No hay cuidadores registrados.");
            return;
        }

        System.out.println("\n📋 Lista de Cuidadores:");
        for (Cuidador c : cuidadores) {
            System.out.println("ID: " + c.getIdCuidador() + ", Nombre: " + c.getNombre() + ", Especialidad: " + c.getEspecialidad());
        }
    }

    private static void actualizarCuidador() {
        System.out.print("Ingrese el ID del cuidador a actualizar: ");
        int id = Integer.parseInt(scanner.nextLine());

        Cuidador cuidador = buscarCuidadorPorId(id);
        if (cuidador == null) {
            System.out.println("⚠️ Cuidador no encontrado.");
            return;
        }

        System.out.print("Nuevo nombre: ");
        cuidador.setNombre(scanner.nextLine());

        System.out.print("Nueva especialidad: ");
        cuidador.setEspecialidad(scanner.nextLine());

        System.out.println("✅ Cuidador actualizado correctamente.");
    }

    private static void eliminarCuidador() {
        System.out.print("Ingrese el ID del cuidador a eliminar: ");
        int id = Integer.parseInt(scanner.nextLine());

        Cuidador cuidador = buscarCuidadorPorId(id);
        if (cuidador == null) {
            System.out.println("⚠️ Cuidador no encontrado.");
            return;
        }

        cuidadores.remove(cuidador);
        System.out.println("🗑️ Cuidador eliminado correctamente.");
    }

    private static Cuidador buscarCuidadorPorId(int id) {
        for (Cuidador c : cuidadores) {
            if (c.getIdCuidador() == id) {
                return c;
            }
        }
        return null;
    }
}
