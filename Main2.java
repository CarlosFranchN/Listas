import java.util.*;

public class Main {

  public static <ListaEstatica> void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    // int N = 10;// sc.nextInt();
    ArrayList List = new ArrayList(N);

    for (int i = 0; i < N; i++) {
      int aux = sc.nextInt();
      List.addF(aux);
    }


    System.out.println(List.temRepetido());
    List.Ordem();
    List.showYourself();
    // List.Ordem();
  }
}

class ArrayList {
  private int[] carlos;
  private int size;

  public ArrayList(int n) {
    carlos = new int[n];
    size = 0;

  }

  public void addF(int valor) {
    if (size < carlos.length) {
      carlos[size] = valor;
      size++;
    }
  }

  // 5 8 2 0 10
  // 5 5 8 10
  public void addI(int valor) {

    for (int i = size; i > 0; i--) {

      carlos[i] = carlos[i - 1];

    }
    size++;
    carlos[0] = valor;
    // System.out.println(size);

  }

  public void eliminar(int pos) {
    if (size == 0)
      System.out.println("Lista vazia!");
    else if (pos < 0 || pos >= size)
      System.out.println("Posicao invalida!");
    else {
      for (int i = pos; i < size - 1; i++) {
        carlos[i] = carlos[i + 1];
      }
      size--;
    }

  }

  public void eliminateInicio() {
    int aux = 0;
    for (int i = 0; i < size - 1; i++) {
      aux = carlos[i + 1];
      carlos[i] = aux;
      // carlos[i - 1] = aux;

    }
    size--;
  }

  public void eliminateFim() {

    size--;

  }

  public void eliminarRepetido() {

  }

  public void inverterLista() {
    for (int i = 0; i < size / 2; i++) {
      int aux = carlos[0 + i];
      carlos[0 + i] = carlos[size - 1 - i];
      carlos[size - 1 - i] = aux;

    }

  }

  public boolean temRepetido() {
    for (int i = 0; i < size; i++) {
      for (int j = i + 1; j < size; j++) {
        if (carlos[i] == carlos[j]) {
          return true;
        }
      }
    }
    return false;

  }

  public void QuatRepetidos1() {
    int count = 0;
    for (int i = 0; i < size; i++) {

      if (carlos[i] == 1) {
        count++;
      }

    }
    System.out.println(count);
  }

  public void QtsRepetidos() {
    int count = 0;
    if (temRepetido() == true) {
      count = 1;
    }
    for (int i = 0; i < size; i++) {
      for (int j = i + 1; j < size; j++) {
        if (carlos[i] == carlos[j]) {
          count++;
        }
      }
    }
  }

  public void Ordem() {

    int aux;
    for (int i = 1; i < size; i++) {
      aux = carlos[i];
      int j = i;
      while (j > 0 && aux < carlos[j - 1]) {
        carlos[j] = carlos[j - 1];
        j--;
      }
      carlos[j] = aux;
    }
  }
  // System.out.println(alfa);

  public void showYourself() {
    for (int i = 0; i < size; i++) {
      System.out.print(carlos[i] + " ");
    }
    System.out.println();

  }

}
