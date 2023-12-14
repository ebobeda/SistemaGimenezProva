/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.CartaoEbg;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author user
 */
public class Cartao_DAO extends DAO_Abstract{
    
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
        Criteria criteria = session.createCriteria(CartaoEbg.class); //importar do bean e do hibernate; criteria é pra fazer select * from na O.O
        criteria.add(Restrictions.eq("idcartao", id)); //é um método estático; id é o parametro da linha 46
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista; //registros no java sao transformados em bean; nao precisa do array pq mudou na linha 50 só pra list
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CartaoEbg.class); //importar do bean e do hibernate; criteria é pra fazer select * from na O.O
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista; //registros no java sao transformados em bean; nao precisa do array pq mudou na linha 50 só pra list
    }
    
    public List listNomecompleto(String nomecompletoEbg){
    session.beginTransaction();
    Criteria criteria = session.createCriteria(CartaoEbg.class);
    criteria.add(Restrictions.like("nomecompletoEbg","%"+nomecompletoEbg+"%"));
    List lista = criteria.list();
    session.getTransaction().commit();
    return lista;
    }
    
    public List listCsc(int cscEbg){
    session.beginTransaction();
    Criteria criteria = session.createCriteria(CartaoEbg.class);
    criteria.add(Restrictions.ge("cscEbg",cscEbg));
    List lista = criteria.list();
    session.getTransaction().commit();
    return lista;
    }
    
    public List listNomecompletoCsc(String nomecompletoEbg, int cscEbg){
    session.beginTransaction();
    Criteria criteria = session.createCriteria(CartaoEbg.class);
    criteria.add(Restrictions.like("nomecompletoEbg","%"+nomecompletoEbg+"%"));
    criteria.add(Restrictions.ge("cpfEbg",cscEbg));
    List lista = criteria.list();
    session.getTransaction().commit();
    return lista;
    }
    
    public static void main(String[] args){
        Cartao_DAO cartao_DAO = new Cartao_DAO();
        List lista = cartao_DAO.listAll();
        for (Object cartaoEbg : lista) {
            System.out.println(((CartaoEbg)cartaoEbg).getNomecompletoEbg());
        }
    }
}
