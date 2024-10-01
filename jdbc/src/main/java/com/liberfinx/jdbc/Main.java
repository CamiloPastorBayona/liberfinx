package com.liberfinx.jdbc;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UsuarioControlador controlador = new UsuarioControlador();

        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("1. Crear Usuario");
            System.out.println("2. Actualizar Usuario");
            System.out.println("3. Borrar Usuario");
            System.out.println("4. Mostrar todos los usuarios");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese correo: ");
                    String correo = scanner.nextLine();
                    System.out.print("Ingrese contraseña: ");
                    String contraseña = scanner.nextLine();
                    System.out.print("Ingrese imagen perfil: ");
                    String imagen_perfil = scanner.nextLine();
                    controlador.crearUsuario(nombre, correo, contraseña, imagen_perfil);
                    System.out.println("Usuario creado correctamente");
                    controlador.MostrarTodo();
                    break;
                case 2:
                    controlador.MostrarTodo();
                    int idModificar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Ingrese nuevo correo: ");
                    String nuevoCorreo = scanner.nextLine();
                    System.out.print("Ingrese nueva contraseña: ");
                    String nuevaContraseña = scanner.nextLine();
                    System.out.print("Ingrese nueva imagen: ");
                    String nuevaImagen = scanner.nextLine();
                    controlador.actualizarUsuario(idModificar, nuevoNombre, nuevoCorreo, nuevaContraseña, nuevaImagen);
                    System.out.println("Usuario actualizado exitosamente");
                    controlador.MostrarTodo();
                    break;
                case 3:
                    controlador.MostrarTodo();
                    int idEliminar = scanner.nextInt();
                    controlador.eliminarUsuario(idEliminar);
                    System.out.println("Usuario eliminado");
                    controlador.MostrarTodo();
                break;
                case 4:
                    System.out.println("\nLista de usuarios:");
                    controlador.MostrarTodo();
                    break;
                default:
                    System.out.println("\nno sirve:"+opcion);
            }
        }
    }
}