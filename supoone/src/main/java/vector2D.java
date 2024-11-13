
public class vector2D {
  public static void main(String[] args) {
    int a = 0;
    int b = 2;

    int[] res = vectorAdd(a, b, 1, 1);
    a = res[0];
    b = res[1];

    System.out.println(a + " " + b);
  }

  public static int[] vectorAdd(int x, int y, int dx, int dy) {
    x += dx;
    y += dy;
    int[] vec = { x, y };
    return vec;
  }
}
