class Main {
  public static void main(String[] args) {
    // ListaEstatica lista = new ListaEstatica(10);
    ListaDinamica lista = new ListaDinamica();

    lista.adicionarInicio(5);
    lista.exibir();
    lista.adicionarInicio(1);
    lista.exibir();
    lista.adicionarFinal(16);
    lista.exibir();
    lista.adicionarFinal(2);
    lista.exibir();
    lista.adicionarFinal(4);
    // lista.inverterLista();
    lista.exibir();
    lista.add_1();
    lista.exibir();
    System.out.print(lista.tamanho());

  }

}
