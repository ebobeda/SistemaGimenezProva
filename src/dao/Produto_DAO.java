/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.ProdutoEbg;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author user
 */
public class Produto_DAO extends DAO_Abstract{
    
    @Override
    public void insert(Object object) {
       session.beginTransaction(); //nao precisa flush e clear pq está mandando uma informacao nova. ja no up e delt ta pegando uma informação ja existente
       session.save(object);
       session.getTransaction().commit(); //todas as operacoes com banco de dados precisam de transacao com hibernate
    }

    @Override
    public void update(Object object) {
       session.beginTransaction();
       session.flush(); //porque vai limpar o cash do hiberenate pra ele não gravar coisas erradas
       session.clear();
       session.update(object);
       session.getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
       session.beginTransaction();
       session.flush(); //porque vai limpar o cash do hiberenate pra ele não gravar coisas erradas
       session.clear();
       session.delete(object);
       session.getTransaction().commit();
    }

    @Override
    public Object list(int id) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ProdutoEbg.class); //importar do bean e do hibernate; criteria é pra fazer select * from na O.O
        criteria.add(Restrictions.eq("idproduto", id)); //é um método estático; id é o parametro da linha 46
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista; //registros no java sao transformados em bean; nao precisa do array pq mudou na linha 50 só pra list
    }

    @Override
        public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ProdutoEbg.class); //importar do bean e do hibernate; criteria é pra fazer select * from na O.O
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista; //registros no java sao transformados em bean; nao precisa do array pq mudou na linha 50 só pra list
    }
    
    public List listMassa(int massaEbg){
    session.beginTransaction();
    Criteria criteria = session.createCriteria(ProdutoEbg.class);
    criteria.add(Restrictions.ge("massaEbg",massaEbg));
    List lista = criteria.list();
    session.getTransaction().commit();
    return lista;
    }
    
    public List listTamanho(int tamanhoEbg){
    session.beginTransaction();
    Criteria criteria = session.createCriteria(ProdutoEbg.class);
    criteria.add(Restrictions.ge("tamanhoEbg",tamanhoEbg));
    List lista = criteria.list();
    session.getTransaction().commit();
    return lista;
    }
    
    public List listMassaTamanho(int massaEbg, int tamanhoEbg){
    session.beginTransaction();
    Criteria criteria = session.createCriteria(ProdutoEbg.class);
    criteria.add(Restrictions.ge("massaEbg",massaEbg));
    criteria.add(Restrictions.ge("tamanhoEbg",tamanhoEbg));
    List lista = criteria.list();
    session.getTransaction().commit();
    return lista;
    }
    
    public static void main(String[] args){
        Produto_DAO produto_DAO = new Produto_DAO();
        List lista = produto_DAO.listAll();
        for (Object produtoEbg : lista) {
            System.out.println(((ProdutoEbg)produtoEbg).getSaborEbg());
        }
    }
}

