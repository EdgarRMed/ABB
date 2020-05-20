package Tree;

public class BinaryTree { // Arbol binario
    public Node root;

    public BinaryTree(){root = null; } // Constructor por default

    public Node searchNode(int value, Node aux){
        if (aux != null) {
            if (aux.data == value) // Cuando se encuentra retornamos el nodo
                return aux;
            else {
                if (aux.data > value) // Lo busca por la izquierda
                    return searchNode(value, aux.leftNode);
                else // Lo busca por la derecha
                    return searchNode(value, aux.rightNode);
            }
        }
        else
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

    public void deleteNode(int value){

    }

    public void print(Node aux){ // Imprime nodo por nodo con sus dos hijos
        if (aux.leftNode!= null && aux.rightNode != null)
            System.out.println(aux + ": " + aux.leftNode + ", " + aux.rightNode);
        if (aux.leftNode!= null && aux.rightNode == null)
            System.out.println(aux + ": " + aux.leftNode + ", none");
        if (aux.leftNode== null && aux.rightNode != null)
            System.out.println(aux + ": " + "none ," + aux.rightNode);
        if (aux.leftNode != null){
            print(aux.leftNode);
        }
        if (aux.rightNode != null){
            print(aux.rightNode);
        }
    }



}



