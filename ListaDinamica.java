public class ListaDinamica {
  private No primeiro;
  private No ultimo;
  private int tamanho;

  public ListaDinamica() {
    primeiro = null;
    ultimo = null;
    tamanho = 0;
  }

  public void add_1() {
    No aux = primeiro;
    while (aux != ultimo) {
      aux.valor++;
      aux = aux.proximo;
    }
    if (ultimo != null)
      ultimo.valor++;
  }

  // 1 -> 2 -> 3 -> 4 -> null

  public void adicionarFinal(int valor) {
    No novo = new No(valor);

    if (primeiro == null) {
      primeiro = novo;
      ultimo = novo;
    } else {
      ultimo.proximo = novo;
      ultimo = novo;
    }
    tamanho++;

    // ultimo.proximo = primeiro; //circularidade
  }

  public void adicionarInicio(int valor) {
    No novo = new No(valor);

    if (primeiro == null) {
      primeiro = novo;
      ultimo = novo;
    } else {
      novo.proximo = primeiro;
      primeiro = novo;
    }

    // ultimo.proximo = primeiro;
  }

  public void removerInicio() {
    if (primeiro != null) {
      if (primeiro == ultimo) {
        primeiro = null;
        ultimo = null;
      } else {
        No aux = primeiro;
        primeiro = primeiro.proximo;
        aux.proximo = null;

        // ultimo.proximo = primeiro;
      }
    }
  }

  public void removerFinal() {
    if (ultimo != null) {
      if (primeiro == ultimo) {
        primeiro = null;
        ultimo = null;
      } else {
        No atual = primeiro;

        while (atual.proximo != ultimo) {
          atual = atual.proximo;
        }

        ultimo = atual;
        // ultimo.proximo = primeiro;
      }
    }
  }

  // Muito bem.. Caros tentar encontrar um erro no metodo
  public void removerPosicao(int posicao) {
    int tam = tamanho();

    if (posicao < 0 || posicao >= tam) {
      System.out.println("Posicao (" + posicao + ") Invalida!!!");
      return;
    }

    if (posicao == (tam - 1)) {
      removerFinal();
    } else {
      if (posicao == 0) {
        removerInicio();
      } else {
        No atual = primeiro;
        for (int i = 0; i < posicao - 1; i++) {
          atual = atual.proximo;
        }
        // atual = atual.proximo.proximo;
        No apagar = atual.proximo;
        atual.proximo = atual.proximo.proximo;
        apagar.proximo = null;
      }
    }
  }

  public void exibir() {
    No atual = primeiro;

    while (atual.proximo != null) {
      System.out.print(atual.valor + " ");
      atual = atual.proximo;
    }

    System.out.print(atual.valor + " ");

    System.out.println();
  }

  public int tamanho() {
    int cont = 0;
    No atual = primeiro;
    while (atual != null) {
      cont++;
      // System.out.println(atual);
      atual = atual.proximo;
    }

    if (atual != null) {
      cont++;
    }

    return cont;
  }

  public void adicionarPosicao(int valor, int pos) {
    int tam = tamanho();
    // posicao invalida...
    if (pos < 0 || pos > tam) {
      System.out.println("Posicao Invalida!!!");
      return;
    }
    if (pos == 0) {
      adicionarInicio(valor);
    } else if (pos == tamanho()) {
      adicionarFinal(valor);
    } else {
      No atual = primeiro;
      // inserir em poiscoes entre o inicio e o fim
      for (int i = 0; i < pos - 1; i++) {
        atual = atual.proximo;
      }
      No novo = new No(valor);
      novo.proximo = atual.proximo;
      atual.proximo = novo;
    }
  }

  // Questao 1 - Lista 1 AV2 - semanal
  // Supondo que nao existe a referencia ultimo
  public int retornarUltimo() {
    No atual = primeiro;
    while (atual.proximo != null) {
      atual = atual.proximo;
    }

    return atual.valor;
  }

  public int retornaPenultimo() {
    No atual = primeiro;
    while (atual.proximo.proximo != null) {
      atual = atual.proximo;
    }

    return atual.valor;
  }

  public int retornaPosicao(int pos) {
    No atual = primeiro;
    int tamanho = tamanho();
    if (pos < 0 || pos >= tamanho) {
      System.out.println("Posicao invalida");
      return -1;
    }
    for (int i = 0; i < pos; i++) {
      atual = atual.proximo;
    }
    return atual.valor;
  }

  public No retornaItem(int pos) {
    No atual = primeiro;

    for (int i = 0; i < pos; i++) {
      atual = atual.proximo;
    }

    return atual;
  }

  // exercicio 1 - transforma essa LSE nao circular em circular
  public void transformarLSENaoCircularCircular() {
    ultimo.proximo = primeiro;
  }

  public void inverterLista() {
    int tam = tamanho();

    No atual = ultimo;

    for (int i = tam - 2; i >= 0; i--) {
      atual.proximo = retornaItem(i);
      atual = atual.proximo;
    }

    atual.proximo = ultimo;

    ultimo = primeiro;
    primeiro = atual.proximo;

  }

  public boolean jaNaLista(int valor) {
    int tam = tamanho();
    No atual = primeiro;

    if (primeiro != null) {
      for (int i = 0; i < tam; i++) {
        if (atual.valor == valor) {
          return true;
        }

        atual = atual.proximo;
      }
    }

    return false;
  }

  public boolean temRepetido() {
    if (primeiro != null) {
      int tam = tamanho();
      No atual1 = primeiro;
      No atual2 = primeiro;

      ListaDinamica repetidos = new ListaDinamica();

      for (int i = 0; i < tam; i++) {
        atual1 = atual1.proximo;

        for (int j = 0; j < tam; j++) {
          atual2 = atual2.proximo;

          if (atual1.valor == atual2.valor && !atual1.equals(atual2)) {

            if (!repetidos.jaNaLista(atual1.valor)) {
              repetidos.adicionarInicio(atual1.valor);
            }

          }
        }
      }

      if (repetidos.tamanho() > 0) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  public void itensRepetidos() {
    if (primeiro != null) {
      int tam = tamanho();
      No atual1 = primeiro;
      No atual2 = primeiro;

      ListaDinamica repetidos = new ListaDinamica();

      for (int i = 0; i < tam; i++) {
        atual1 = atual1.proximo;

        for (int j = 0; j < tam; j++) {
          atual2 = atual2.proximo;

          if (atual1.valor == atual2.valor && !atual1.equals(atual2)) {

            if (!repetidos.jaNaLista(atual1.valor)) {
              repetidos.adicionarInicio(atual1.valor);
            }

          }
        }
      }

      if (repetidos.tamanho() > 0) {
        repetidos.exibir();
      } else {
        System.out.println("Nao tem itens repetidos");
      }
    } else {
      System.out.println("Nao tem itens repetidos");
    }
  }

  // exercicio 1 - transforma essa LSE nao circular em circular
  // public void transformarLSENaoCircularCircular() {
  // ultimo.proximo = primeiro;
  // }

  // Lista Tarefas para transformar esse codigo em uma LSE
  // transformarLSENaoCircularCircular
  ///// LSE Nao Circular ====> LSE Circular ???

  // 1) metodo tamanho: while ( *atual != null *)
  // 2) retornarUltimo() ? => (while(atual.proximo != null))
  // 3) retornaPenultimo()? => (atual.proximo != null)
  // 4)
}