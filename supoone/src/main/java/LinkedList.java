package supoone.src.main.java;

public class LinkedList {

  public Node head;

  public LinkedList(int val) {
    this.head = new Node(val);
  }

  public Node getLastElement() {
    Node node = head;
    while (node.next != null) {
      node = node.next;
    }
    return node;
  }

  public void append(int val) {
    Node node = getLastElement();
    node.next = new Node(val);
  }

  public void printList() {
    Node node = head;
    while (node != null) {
      System.out.println(node.val);
      node = node.next;
    }
  }

  public Node getHead() {
    return head;
  }

  public int getHeadVal() {
    return head.val;
  }

  public Node getNthElement(int n) {
    Node node = head;
    for (int i = 0; i < n; i++) {
      node = node.next;
    }
    return node;
  }

  public void deleteNode(int n) {
    Node node = head;
    for (int i = 0; i < n - 1; i++) {
      node = node.next;
    }

    node.next = node.next.next;
  }

  public int getLength() {
    Node node = head;
    int length = 0;
    while (node != null) {
      length++;
      node = node.next;
    }
    return length;
  }

  public boolean detectCycles() {
    Node node = this.head;
    Node tPointer = node;
    Node hPointer = node;

    while (tPointer != null && hPointer != null && hPointer.next != null) {
      tPointer = tPointer.next;
      hPointer = hPointer.next.next;

      if (tPointer == hPointer) {
        return true;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    LinkedList list = new LinkedList(1);
    list.append(2);
    list.append(3);
    list.append(4);
    list.append(5);
    list.printList();
    System.out.println(list.detectCycles());

    System.out.println(list.getNthElement(3).val);
    list.deleteNode(3);
    list.printList();
    System.out.println(list.getLength());

    list.getLastElement().next = list.getHead();
    System.out.println(list.detectCycles());
  }

}
