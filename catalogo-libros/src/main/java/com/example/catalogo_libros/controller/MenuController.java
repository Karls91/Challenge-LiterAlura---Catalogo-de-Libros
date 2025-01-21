package com.example.catalogo_libros.controller;

import com.example.catalogo_libros.service.GutendexApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class MenuController {

    @Autowired
    private GutendexApiService gutendexApiService;

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== Menú del Catálogo de Libros ===");
            System.out.println("1. Buscar libro por título");
            System.out.println("2. Listar todos los libros");
            System.out.println("3. Listar todos los autores");
            System.out.println("4. Listar autores vivos en un año específico");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título del libro: ");
                    String titulo = scanner.nextLine();
                    gutendexApiService.buscarLibroPorTitulo(titulo);
                    break;
                case 2:
                    gutendexApiService.listarTodosLosLibros();
                    break;
                case 3:
                    gutendexApiService.listarTodosLosAutores();
                    break;
                case 4:
                    System.out.print("Ingrese el año: ");
                    int año = scanner.nextInt();
                    gutendexApiService.listarAutoresVivosEnAño(año);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
