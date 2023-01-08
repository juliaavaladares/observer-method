package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import main.*;

public class LojaTest {
    ArrayList<Produto> produtos = new ArrayList<Produto>();

    Produto celular = new Produto("001", "Iphone13", 4550);
    Produto maquinaDeLavar = new Produto("002", "Maquina Brastemp", 1500);
    Produto geladeira = new Produto("003", "Geladeira Samsung", 2000);

    @Test
    public void deveNotificarUmCliente() {
        Loja loja = new Loja("001", "Juiz de Fora", produtos);
        Cliente cliente = new Cliente("Cliente 1");

        cliente.cadastrarNaLoja(loja);
        loja.atualizarCatalogoDeProdutos(celular);

        assertEquals("Cliente 1, novo produto disponível na Loja{filialId=001, cidade=Juiz de Fora}",
                cliente.getUltimaNotificacao());
    }

    @Test
    public void deveNotificarClientes() {
        Loja loja = new Loja("001", "Juiz de Fora", produtos);
        Cliente cliente = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");

        cliente.cadastrarNaLoja(loja);
        cliente2.cadastrarNaLoja(loja);

        loja.atualizarCatalogoDeProdutos(geladeira);

        assertEquals("Cliente 1, novo produto disponível na Loja{filialId=001, cidade=Juiz de Fora}",
                cliente.getUltimaNotificacao());
        assertEquals("Cliente 2, novo produto disponível na Loja{filialId=001, cidade=Juiz de Fora}",
                cliente2.getUltimaNotificacao());
    }

    @Test
    public void naoDeveNotificarCliente() {
        Loja loja = new Loja("001", "Juiz de Fora", produtos);
        Cliente cliente = new Cliente("Cliente 1");

        loja.atualizarCatalogoDeProdutos(celular);

        assertEquals(null, cliente.getUltimaNotificacao());
    }

}
