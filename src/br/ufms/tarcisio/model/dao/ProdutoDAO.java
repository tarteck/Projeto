/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.tarcisio.model.dao;

import br.ufms.tarcisio.model.Produto;
import br.ufms.tarcisio.util.JPAUtil;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author tarci
 */
public class ProdutoDAO {
    EntityManager maneger;

    public ProdutoDAO() {
        this.maneger = new JPAUtil().getEntityManager();
    }
    public void addProduto(Produto p){
        maneger.getTransaction().begin();
        maneger.persist(p);
        
        maneger.getTransaction().commit();
        
        maneger.close();
    
}
    public List<Produto> getProduto(){
		//manager.getTransaction().begin();
		Query query = maneger.createQuery("select p from Produto p");
		
		List<Produto> produto = query.getResultList();
		maneger.close(); // fechando EntityManager
		return produto;

	}
    
    public Produto getUsuarioById(int id){
		maneger.getTransaction().begin();
		Produto p = maneger.find(Produto.class, id);
		
		return p;
}
    public void updateUser(Produto p){		
		maneger.merge(p);
		maneger.getTransaction().commit();

		maneger.close();
	}
	
	public void delProduto(Produto p){		
		Query q = maneger.createQuery("delete Produto where codigo = ?0");		
		q.setParameter(0, p.getcodigo());
		q.executeUpdate();
		
		maneger.getTransaction().commit();

		maneger.close();		
	}	
}