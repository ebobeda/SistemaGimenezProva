/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.VendedorEbg;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author user
 */
public class Vendedor_DAO extends DAO_Abstract{
    
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
        Criteria criteria = session.createCriteria(VendedorEbg.class); //importar do bean e do hibernate; criteria é pra fazer select * from na O.O
        criteria.add(Restrictions.eq("idvendedor", id)); //é um método estático; id é o parametro da linha 46
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista; //registros no java sao transformados em bean; nao precisa do array pq mudou na linha 50 só pra list
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(VendedorEbg.class); //importar do bean e do hibernate; criteria é pra fazer select * from na O.O
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista; //registros no java sao transformados em bean; nao precisa do array pq mudou na linha 50 só pra list
    }
    
    public List listNome(String nomeEbg){
    session.beginTransaction();
    Criteria criteria = session.createCriteria(VendedorEbg.class);
    criteria.add(Restrictions.like("nomeEbg","%"+nomeEbg+"%"));
    List lista = criteria.list();
    session.getTransaction().commit();
    return lista;
    }
    
    public List listCpf(String cpfEbg){
    session.beginTransaction();
    Criteria criteria = session.createCriteria(VendedorEbg.class);
    criteria.add(Restrictions.like("cpfEbg","%"+cpfEbg+"%"));
    List lista = criteria.list();
    session.getTransaction().commit();
    return lista;
    }
    
    public List listNomeCpf(String nomeEbg, String cpfEbg){
    session.beginTransaction();
    Criteria criteria = session.createCriteria(VendedorEbg.class);
    criteria.add(Restrictions.like("nomeEbg","%"+nomeEbg+"%"));
    criteria.add(Restrictions.like("cpfEbg","%"+cpfEbg+"%"));
    List lista = criteria.list();
    session.getTransaction().commit();
    return lista;
    }
    
    public static void main(String[] args){
        Vendedor_DAO vendedor_DAO = new Vendedor_DAO();
        List lista = vendedor_DAO.listAll();
        for (Object usuarioEbg : lista) {
            System.out.println(((VendedorEbg)usuarioEbg).getNomeEbg());
        }
    }
}

