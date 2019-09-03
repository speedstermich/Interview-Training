import java.util.*;
import java.io.*;


class Main {

    /* you only have to complete the function given below.
    Node is defined as

    class Node {
        int data;
        Node left;
        Node right;
    }

    */
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        //print root
        System.out.print(root.data + " ");
        //print left
        preOrder(root.left);
        //print right
        preOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        //print left
        postOrder(root.left);
        //print right
        postOrder(root.right);
        //print root
        System.out.print(root.data + " ");
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        //print left
        inOrder(root.left);
        //print root
        System.out.print(root.data + " ");
        //print right
        inOrder(root.right);
    }
    /*public static void printLevelOrder(Node root){
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++) {
            printLevel(root, i);
        }
    }*/

    /*public static void printLevel(Node root, int level){
        if (root == null){
            return;
        }
        if (level == 1){
            System.out.print(root.data + " ");
        }
        else if (level > 1){
            printLevel(root.left, level-1);
            printLevel(root.right, level-1);
        }
    }*/

    public static void printLevelOrder(Node root){
        Queue <Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
            if (tempNode.left != null){
                queue.add(tempNode.left);
            }
            if (tempNode.right != null){
                queue.add(tempNode.right);
            }
        }
    }

    public static int height(Node root) {
        /*int lDepth = height(root.left);
        int rDepth = height(root.right);

            if (root.left != null) {
                lDepth = height(root.left);
            }

            if (root.right != null){
                rDepth = height(root.right);
            }
        if (rDepth > lDepth) {
        rDepth = rDepth + 1;
        return (rDepth + 1);
        } else {
        lDepth = lDepth + 1;
        return (lDepth + 1);
        }*/
        // Write your code here.
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }



    public static void topView(Node root) {
        //Structure of pair
        class QueueObj {
            Node node;
            int hd;

            QueueObj(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }
        // Queue to do BFS
        Queue<QueueObj> queue = new LinkedList<QueueObj>();
        // map to store node at each vartical distance
        Map<Integer, Node> topViewMap = new TreeMap<Integer, Node>();

        if (root == null) {
            return;
        } else {
            queue.add(new QueueObj(root, 0));
        }

        // If any node is not at that vertical distance
        // just insert that node in map and print it
        while (!queue.isEmpty()) {
            QueueObj tmpNode = queue.poll();
            if (!topViewMap.containsKey(tmpNode.hd)) {
                topViewMap.put(tmpNode.hd, tmpNode.node);
            }

            if (tmpNode.node.left != null) {
                queue.add(new QueueObj(tmpNode.node.left, tmpNode.hd - 1));
            }

            if (tmpNode.node.right != null){
                queue.add(new QueueObj(tmpNode.node.right, tmpNode.hd + 1));
            }
        }
        for (Map.Entry<Integer, Node> entry : topViewMap.entrySet()){
            System.out.print(entry.getValue().data + " ");
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        //preOrder(root);
        //postOrder(root);
        //inOrder(root);
        //int h = height(root);
        //System.out.println(h);
        topView(root);
        System.out.println();
        printLevelOrder(root);
    }
}
/*import java.util.*;
import java.text.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        Locale indiaLocale = new Locale("en", "IN");
        // Write your code here.
        NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat india = NumberFormat.getCurrencyInstance(indiaLocale);
        NumberFormat china = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat france = NumberFormat.getCurrencyInstance(Locale.FRANCE);

        System.out.println("US: " + us.format(payment));
        System.out.println("India: " + india.format(payment));
        System.out.println("China: " + china.format(payment));
        System.out.println("France: " + france.format(payment));
    }
}*/

