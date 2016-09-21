/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.tarcisio.teste;

import br.ufms.tarcisio.model.Produto;
import br.ufms.tarcisio.model.dao.ProdutoDAO;





/**
 *
 * @author tarci
 */
public class teste {
    public static void main (String args[] ){
        ProdutoDAO pDAO = new ProdutoDAO();
        Produto p = new Produto();
        
        p.setData("20/09/2016");
        p.setDescricao("Teclado");
        p.setPreco(3.5);
        
        pDAO.addProduto(p);
}
}
