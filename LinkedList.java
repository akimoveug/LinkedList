class Node {
    Integer data;
    Node left;
    Node right;

    Node(int data) {
        left = null;
        right = null;
    }
}

class List {
    private Integer size;
    private Node head;
    private Node tail;

    List() {
        size = 0;
        head = null;
        tail = null;
    }

    public int getSize() {
        return size;
    }

    public Node getHead() {
        if (head != null) {
            return head;
        }
        return null;
    }

    public Node getTail() {
        if (tail != null) {
            return tail;
        }
        return null;
    }

    public void addFirst(int data) {            //добавляем новый узел в начало
        if (size > 0) {                         //если список не пустой
            Node node = new Node(data);
            node.data = data;
            Node oldNode = head;
            node.right = oldNode;               //присваиваем ссылочной переменной правого узла нового узла бывший головной узел
            oldNode.left = node;
            head = node;
            size++;
        }
        if (size == 0) {                        //если список пустой
            Node node = new Node(data);
            node.data = data;
            Node oldNode = head;
            node.right = oldNode;
            oldNode.left = node;
            head = node;
            tail = node;
            size++;
        }

    }

    public void addLast(int data) {             //добавляем новый узел в конец
        if (size > 0) {
            Node node = new Node(data);
            node.data = data;
            Node oldNode = tail;
            node.left = oldNode;
            tail = node;
            oldNode.right = tail;
            size++;
        }
        if (size == 0) {
            Node node = new Node(data);
            node.data = data;
            node.left = null;
            node.right = null;
            head = node;
            tail = node;
            size++;
        }
    }

    public void printFirst() {                  //выводим список с начала
        Node node;
        node = head;
        if (tail != null) {
            for (int i = 0; i < size; i++) {
                if (node.right != null) {
                    System.out.print(node.data + "<->");
                    node = node.right;
                } else {
                    System.out.println(node.data);
                }
            }
        } else {
            System.out.println("Список пуст");
        }
    }

    public void printLast() {                   //выводим список с конца
        Node node;
        node = tail;
        if (tail != null) {
            for (int i = size; i > 0; i--) {
                if (node.left != null) {
                    System.out.print(node.data + "<->");
                    node = node.left;
                } else {
                    System.out.println(node.data);
                }
            }
        } else {
            System.out.println("Список пуст");
        }
    }

    public void deleteFirst() {                 //удаляем первый узел
        if (tail.left != null) {
            head = head.right;
            head.left = null;
            size--;
        }
        else{
            head = null;
            tail = null;
            size--;
        }
    }

    public void deleteLast() {                  //удаляем последний узел
        if (tail.left != null) {
            tail = tail.left;
            tail.right = null;
            size--;
        }
        else{
            head = null;
            tail = null;
            size--;
        }
    }

    public Node find(int data) {                //поиск с начала списка
        Node node;
        node = head;
        if (tail != null) {
            for (int i = 0; i < size; i++) {
                if (node.data == data) {
                    return node;
                }
                node = node.right;
            }
        }
        return node;
    }

    public Node findLast(int data) {                //поиск с конца списка
        Node node;
        node = tail;
        if (tail != null) {
            for (int i = size; i > 0; i--) {
                if (node.data == data) {
                    return node;
                }
                node = node.left;
            }
        }
        return node;
    }
}

public class LinkedList {
    public static void main(String[] args) {
        List lst = new List();
        lst.addLast(1);
        lst.addLast(2);
        lst.addLast(3);
        lst.addLast(4);
        lst.addFirst(5);
        lst.addFirst(6);
        lst.addLast(7);
        System.out.println("Размер списка " + lst.getSize());
        lst.printFirst();
        lst.deleteFirst();
        lst.deleteLast();
        lst.printLast();
        System.out.println("Node with data = 7: " + lst.find(7));
        System.out.println("Node with data = 3: " + lst.findLast(3));
        System.out.println("Head: " + lst.getHead().data);
        System.out.println("Tail: " + lst.getTail().data);
    }
}