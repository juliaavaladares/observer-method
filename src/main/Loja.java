package main;

import java.util.ArrayList;
import java.util.Observable;

public class Loja extends Observable {

    private String filialId;
    private String cidadeFilial;
    private ArrayList<Produto> produtos = new ArrayList<Produto>();

    public Loja(String filialId, String cidadeFilial, ArrayList<Produto> produtos) {
        this.filialId = filialId;
        this.cidadeFilial = cidadeFilial;
        this.produtos = produtos;
    }

    public void atualizarCatalogoDeProdutos(Produto produto) {
        produtos.add(produto);
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Loja{" +
                "filialId=" + filialId +
                ", cidade=" + cidadeFilial +
                '}';
    }
}
