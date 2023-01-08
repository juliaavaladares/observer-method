package main;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {

    private String nomeCliente;
    private String ultimaNotificacao;

    public Cliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void cadastrarNaLoja(Loja loja) {
        loja.addObserver(this);
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    @Override
    public void update(Observable loja, Object agr1) {
        this.ultimaNotificacao = this.nomeCliente + ", novo produto disponível na " + loja.toString();
    }

}
