package Test;

import Tree.BinaryTree;

import java.io.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {

        BinaryTree abb = new BinaryTree();
        int option;
        int value;
        String fileName;
        Scanner in = new Scanner(System.in);
        boolean running = true;

        menu(); // Se imprime el menú

        while (running) {
            System.out.println("Ingrese una opción (presione 0 para ver el menú)");
            System.out.print("> ");
            option = in.nextInt();
            in.nextLine();

            switch (option) {
                case 0:
                    menu();
                    break;

                case 1:
                    try {
                        System.out.println("Ingrese el nombre de un archivo(Elemplo: abb)");
                        fileName = in.nextLine();
                        FileInputStream entrada = new FileInputStream("Arboles/" + fileName + ".txt");
                        ObjectInputStream reader = new ObjectInputStream(entrada);
                        //Lectura de objeto
                        System.out.println("------------ Contenido de " + fileName + ".txt ---------------");
                        abb = (BinaryTree) reader.readObject();
                        abb.print(abb.root, 0);
                    } catch (java.io.InvalidClassException e) {
                        System.out.println("\nNo hay archivos disponibles o el archivo se ha corrompido\n");
                    } catch (java.io.FileNotFoundException ex) {
                        System.out.println("No existe el archivo");
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    System.out.println("Valor a insertar: ");
                    value = in.nextInt();
                    abb.insertNode(value, abb.root);

                    break;

                case 3:
                    if (!abb.estaVacia()) {
                        System.out.println("Valor a eliminar: ");
                        value = in.nextInt();
                        if (!abb.deleteNode(value)) {
                            System.out.println("El elemento no se encuentra en el árbol");
                        } else
                            System.out.println("El elemento se elimino");
                    } else {
                        System.out.println("El árbol está vacío");
                    }
                    break;

                case 4:
                    System.out.println("Valor a buscar: ");
                    value = in.nextInt();
                    if (abb.searchNode(value, abb.root) != null)
                        System.out.println("Existe");
                    else
                        System.out.println("No existe");

                    break;

                case 5:
                    if (abb.estaVacia())
                        System.out.println("El arbol esta vacío");
                    break;

                case 6:
                    System.out.println("Recorrido preorden:");
                    abb.preorden(abb.root);
                    System.out.println();
                    break;

                case 7:
                    System.out.println("Recorrido inorden:");
                    abb.inorden(abb.root);
                    System.out.println();
                    break;

                case 8:
                    System.out.println("Recorrido en postorden:");
                    abb.postorden(abb.root);
                    System.out.println();
                    break;

                case 9:
                    System.out.println("Recorrido en preorden converso:");
                    abb.preordenConverso(abb.root);
                    System.out.println();

                    break;

                case 10:
                    System.out.println("Recorrido inorden converso:");
                    abb.inordenConverso(abb.root);
                    System.out.println();
                    break;

                case 11:
                    System.out.println("Recorrido en postorden converso:");
                    abb.postordenConverso(abb.root);
                    System.out.println();

                case 12:
                    break;

                case 13:
                    abb.print(abb.root, 0);
                    break;

                case 14:
                    running = false;
                    break;

                case 15:
                    System.out.println("Nombre del archivo:");
                    fileName = in.nextLine();
                    File abbTxt = new File("Arboles/" + fileName + ".txt");
                    FileOutputStream fileOS = new FileOutputStream(abbTxt); // Se pasa el archivo
                    ObjectOutputStream objectOS = new ObjectOutputStream(fileOS);
                    objectOS.writeObject(abb); // Se esecribe
                    objectOS.close(); // Se cierra el archivo
                    System.out.println("Se guardó correctamente" + fileName);
                    System.out.println();
                    break;

                default:
                    System.out.println("Ingrese una opción válida");
                    break;
            }
        }
    }

    public static void menu() {
        System.out.println("1.Abrir desde un archivo");
        System.out.println("2.Insertar un nodo");
        System.out.println("3.Eliminar un nodo");
        System.out.println("4.Buscar un nodo");
        System.out.println("5.Está vacío");
        System.out.println("6.Preorden");
        System.out.println("7.Inorden");
        System.out.println("8.Postorden");
        System.out.println("9.Preorden converso");
        System.out.println("10.Inorden converso");
        System.out.println("11.Postorden converso");
        System.out.println("12.Guardar como");
        System.out.println("13. Imprimir el árbol");
        System.out.println("14. Salir");
        System.out.println("15. Guardar como");
    }
}
