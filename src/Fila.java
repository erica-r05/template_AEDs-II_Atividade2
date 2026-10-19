import java.util.NoSuchElementException;

public class Fila<E>{
    private Celula<E> fim;
    private Celula<E> inicio;
    ;
    int tamanho;
    public Fila(){
        inicio = null;
        fim = inicio;
        tamanho = 0;
    }

    public Fila(E dado){
        inicio = new Celula<>(dado);
        fim = inicio;
        fim.setProximo(null);
        tamanho = 1;
    }

    public boolean vazia(){
        return inicio == fim; 
    }

    public void inserir(E dado){
        Celula c = new Celula<>(dado);
        fim.setProximo(c);
        fim = c;
        if(vazia()){
            inicio = fim; 
        }
        fim.setProximo(null);
        tamanho++;
    }
}