package Tree;

import java.io.Serializable;

public class BinaryTree implements Serializable { // Arbol binario
    public Node root;

    public BinaryTree() {
        root = null;
    } // Constructor por default

    public Node searchNode(int value, Node aux) {
        if (aux != null) {
            if (aux.data == value) // Cuando se encuentra retornamos el nodo
                return aux;
            else {
                if (aux.data > value) // Lo busca por la izquierda
                    return searchNode(value, aux.leftNode);
                else // Lo busca por la derecha
                    return searchNode(value, aux.rightNode);
            }
        } else
            return null; // Si no lo encuentra retornamos null
    }

    public void insertNode(int value, Node aux) {
        if (root == null) // si es la raíz lo insertamos y termina el algoritmo
            root = new Node(value);
        else {
            // Si es menor verificamos si a la izquiera hay un nodo
            if (value < aux.data) {
                if (aux.leftNode == null) // En caso de no haber lo insertamos
                    aux.leftNode = new Node(value); // insertamos y termina el algoritmo
                else // Si hay un nodo, seguimos buscando
                    insertNode(value, aux.leftNode);
            } else { // Si es mayor verificamos si a la derecha hay un nodo
                if (aux.rightNode == null) // En caso de no haber lo insertamos
                    aux.rightNode = new Node(value); // insertamos y termina el algoritmo
                else // Si hay un nodo, seguimos buscando
                    insertNode(value, aux.rightNode);
            }
        }
    }

    public boolean estaVacia() {
        return root == null;
    }

    public boolean deleteNode(int value) {
        Node a1 = root;
        Node a2 = root;
        boolean nodoIzq = true;

        while (a1.data != value) {
            a2 = a1;
            if (value < a1.data) {//para buscar del lado izq. del árbol
                nodoIzq = true;
                a1 = a1.leftNode;
            } else {// Para buscar del lado derecho del árbol
                nodoIzq = false;
                a1 = a1.rightNode;
            }
            if (a1 == null) //No existe nodo a eliminar
                return false;
        }// fin while

        if (a1.leftNode == null && a1.rightNode == null) { //Verifica si es un nodo hoja o raiz
            if (a1 == root) //Caso nodo raiz
                root = null;
            else if (nodoIzq) {
                a2.leftNode = null;
            } else {
                a2.rightNode = null;
            }
        } else if (a1.rightNode == null) {
            if (a1 == root)
                root = a1.leftNode;
            else if (nodoIzq) {
                a2.leftNode = a1.leftNode;
            } else {
                a2.rightNode = a1.leftNode;
            }
        } else if (a1.leftNode == null) {
            if (a1 == root)
                root = a1.rightNode;
            else if (nodoIzq) {
                a2.leftNode = a1.rightNode;
            } else {
                a2.rightNode = a1.leftNode;
            }
        } else {//se buscara el nodo que remplazara al que sera eliminado
            Node nnodo = obtenerRemplazo(a1);
            if (a1 == root) {
                root = nnodo;
            } else if (nodoIzq)
                a2.leftNode = nnodo;
            else {
                a2.rightNode = nnodo;
            }
            nnodo.leftNode = a1.leftNode;
        }
        return true;
    }


    public Node obtenerRemplazo(Node aux) {
        Node remp = aux;
        Node remp2 = aux;
        Node aux3 = aux.rightNode;
        while (aux3 != null) {
            remp = remp2;
            remp2 = aux3;
            aux3 = aux3.leftNode;
        }
        if (remp2 != aux.rightNode) {
            remp.leftNode = remp2.rightNode;
            remp2.rightNode = aux.rightNode;
        }
        return remp2;
    }

    public void preorden(Node raiz) {
        if (raiz != null) {
            System.out.print(raiz.data + ", ");
            preorden(raiz.leftNode);
            preorden(raiz.rightNode);
        }
    }

    public void inorden(Node raiz) {
        if (raiz != null) {
            inorden(raiz.leftNode);
            System.out.print(raiz.data + ", ");
            inorden(raiz.rightNode);
        }
    }

    public void postorden(Node aux) {
        if (aux != null) {
            postorden(aux.leftNode);
            postorden(aux.rightNode);
            System.out.print(aux.data + ", ");
        }
    }

    public void preordenConverso(Node raiz) {
        if (raiz != null) {
            System.out.print(raiz.data + ", ");
            preorden(raiz.rightNode);
            preorden(raiz.leftNode);
        }
    }

    public void inordenConverso(Node raiz) {
        if (raiz != null) {
            inorden(raiz.rightNode);
            System.out.print(raiz.data + ", ");
            inorden(raiz.leftNode);
        }
    }

    public void postordenConverso(Node aux) {
        if (aux != null) {
            postorden(aux.rightNode);
            postorden(aux.leftNode);
            System.out.print(aux.data + ", ");
        }
    }

    public void print(Node aux, int counter) { //imprimir arbol completo
        if (aux != null) {
            print(aux.rightNode, counter + 1);
            for (int i = 0; i < counter; i++) {
                System.out.print("       ");
            }
            System.out.println(aux.data);
            print(aux.leftNode, counter + 1);
        }
    }

}



