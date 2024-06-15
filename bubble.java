
class Celula {
    int valor;
    Celula prox;

    Celula() {
        this(0);
    }

    Celula(int valor) {
        this.valor = valor;
        this.prox = null;
    }

}

class Lista {
    public Celula prim, ult;
    private int tamanho;

    Lista() {
        prim = new Celula();// sentinela
        ult = prim;
        tamanho = 0;
    }

    void bubbleSort() {

        boolean troca;
        do {
            troca = false;
            Celula j = prim.prox;
            while (j.prox != null) {
                if (j.valor > j.prox.valor) {
                    int tmp = j.valor;
                    j.valor = j.prox.valor;
                    j.prox.valor = tmp;
                    troca = true;
                }
                j = j.prox;
            }
        } while (troca);
    }
    

    void inverter() {
        boolean troca;
        do {
            troca = false;
            Celula j = prim.prox;
            while (j.prox != null) {
                if (j.valor < j.prox.valor) {
                    int tmp = j.valor;
                    j.valor = j.prox.valor;
                    j.prox.valor = tmp;
                    troca = true;
                }
                j = j.prox;
            }
        } while (troca);
    }

    public void inserirFim(int x) {
        Celula celulaNova = new Celula(x);
        ult.prox = celulaNova;
        ult = celulaNova;
        tamanho++;
    }

    public boolean vazia() {
        if (prim == ult) {
            return true;
        }
        return false;
    }

    public void mostrar() {
        if (!vazia()) {
            for (Celula i = prim.prox; i != null; i = i.prox) {
                MyIO.print(i.valor + " ");
            }
        } else {
            MyIO.println("Lista vazia! Nada a mostrar oua remover.");
        }
    }

    public void ImprimirRecursivo(Celula x) {
        if (x != null) {
            MyIO.print(x.valor + " ");
            ImprimirRecursivo(x.prox);
        }
    }
}

public class bubble {
    public static void main(String[] args) throws Exception {
        Lista lista = new Lista();

        lista.inserirFim(4);
        lista.inserirFim(3);
        lista.inserirFim(1);
        lista.inserirFim(6);
        lista.inserirFim(9);
        lista.inserirFim(2);
        lista.inserirFim(3);
        lista.inserirFim(7);
        lista.inserirFim(8);
        lista.inserirFim(0);

        System.out.println("Mostrando a lista");
        lista.ImprimirRecursivo(lista.prim.prox);

        System.out.println("\nMostrando a lista ordenada por Bubblesort");
        lista.bubbleSort();
        lista.mostrar();

        System.out.println("\nImprimindo recursivamente");
        lista.ImprimirRecursivo(lista.prim.prox);

        System.out.println("\nMostrando a lista invertida");
        lista.inverter();
        lista.mostrar();
    }
}
