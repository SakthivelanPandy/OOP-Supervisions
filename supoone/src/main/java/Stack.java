
public class Stack {

  public int[] stack;
  public int hPointer = 0;
  public int maxSize;

  public Stack(int length) {
    stack = new int[length];
    maxSize = length;
  }

  public boolean checkEmpty() {
    return this.hPointer == 0;
  }

  public boolean checkFull() {
    return this.hPointer == maxSize;
  }

  public void push(int val) {
    if (this.checkFull()) {
      throw Exception("Stack Full");
    }

    this.stack[hPointer] = val;
    hPointer++;
  }

  public int pop() {
    if (this.checkEmpty()) {
      throw Exception("Stack Empty");
    }

    int num = this.stack[hPointer];
    hPointer--;
    return num;
  }

  public int peek() {
    return this.stack[hPointer];
  }

}
