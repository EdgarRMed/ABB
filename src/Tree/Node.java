package Tree;

public class Node {

    public int data;
    protected Node leftNode;
    protected Node rightNode;

    public Node( int data) { // Constructor del nodo inicial
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }

    public Node( int data, Node leftNode, Node rightNode) { // Constructor del nodo con conexiones
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return Integer.toString(data);
    }
}
