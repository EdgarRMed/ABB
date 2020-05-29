package Test;
import Tree.BinaryTree;
import java.util.Scanner;

public class Test {
    public static void main (String [] args) {

        BinaryTree abb = new BinaryTree();
        int option;
        int value;
        Scanner in = new Scanner(System.in);
        boolean running = true;

        menu(); // Se imprime el menú

        while (running) {
            System.out.println("Ingrese una opción (presione 0 para ver el menú)");
            System.out.print("> ");
            option = in.nextInt();
            in.nextLine();

            switch (option){
                case 0:
                    menu();
                    break;

                case 1:
                    break;

                case 2:
                    System.out.println("Valor a insertar: ");
                    value = in.nextInt();
                    abb.insertNode(value,abb.root);

                    break;

                case 3:
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
                    break;

                case 9:
                    break;

                case 10:
                    System.out.println("Recorrido inorden converso:");
                    abb.inordenConverso(abb.root);
                    System.out.println();
                    break;

                case 11:

                case 12:
                    break;

                case 13:
                    abb.print(abb.root, 0);
                    break;

                case 14:
                    running = false;
                    break;

                default:
                    System.out.println("Ingrese una opción válida");
                    break;
            }
        }
    }

    public static void menu(){
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
    }
}
