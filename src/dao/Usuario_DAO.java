/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.UsuarioEbg;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author u08004655122
 */
public class Usuario_DAO extends DAO_Abstract{
    
    public UsuarioEbg LoginApelidoESenha(String apelido, String senha) {
        session.beginTransaction();

        Query query = session.createQuery("FROM UsuarioEbg WHERE apelido_ebg = :apelido_ebg AND senha_ebg = :senha_ebg"); //consulta no hibernate do usuario e da senha
        query.setParameter("apelido_ebg", apelido); //apelido_ebg é o parametro da consulta :apelido_ebg, setParameter atribui valor ao parametro antes de executar a consulta pra ver se os apelidos batem
        query.setParameter("senha_ema", senha);

        UsuarioEbg usuarioEbg = (UsuarioEbg) query.uniqueResult();//procura apenas um resultado

        session.getTransaction().commit(); //todas as operacoes com banco de dados precisam de transacao com hibernate


        return usuarioEbg;
    }

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
        Criteria criteria = session.createCriteria(UsuarioEbg.class); //importar do bean e do hibernate; criteria é pra fazer select * from na O.O
        criteria.add(Restrictions.eq("idusuario", id)); //é um método estático; id é o parametro da linha 46
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista; //registros no java sao transformados em bean; nao precisa do array pq mudou na linha 50 só pra list
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(UsuarioEbg.class); //importar do bean e do hibernate; criteria é pra fazer select * from na O.O
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista; //registros no java sao transformados em bean; nao precisa do array pq mudou na linha 50 só pra list
    }
    
    public List listNome(String nomeEbg){
    session.beginTransaction();
    Criteria criteria = session.createCriteria(UsuarioEbg.class);
    criteria.add(Restrictions.like("nomeEbg","%"+nomeEbg+"%"));
    List lista = criteria.list();
    session.getTransaction().commit();
    return lista;
    }
    
    public List listCpf(String cpfEbg){
    session.beginTransaction();
    Criteria criteria = session.createCriteria(UsuarioEbg.class);
    criteria.add(Restrictions.like("cpfEbg","%"+cpfEbg+"%"));
    List lista = criteria.list();
    session.getTransaction().commit();
    return lista;
    }
    
    public List listNomeCpf(String nomeEbg, String cpfEbg){
    session.beginTransaction();
    Criteria criteria = session.createCriteria(UsuarioEbg.class);
    criteria.add(Restrictions.like("nomeEbg","%"+nomeEbg+"%"));
    criteria.add(Restrictions.like("cpfEbg","%"+cpfEbg+"%"));
    List lista = criteria.list();
    session.getTransaction().commit();
    return lista;
    }
    
    public static void main(String[] args){
        Usuario_DAO usuario_DAO = new Usuario_DAO();
        List lista = usuario_DAO.listAll();
        for (Object usuarioEbg : lista) {
            System.out.println(((UsuarioEbg)usuarioEbg).getNomeEbg());
        }
    }
}