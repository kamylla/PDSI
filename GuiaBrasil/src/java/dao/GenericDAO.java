package dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Kamylla
 * Exemplo de uso:
 * public class RetornoNisDAOImpl extends BasicDAO<TbRetornoNis> implements RetornoNisDAO {
    
    public RetornoNisDAOImpl(){
        super(HibernateUtil.getSessionFactory().openSession(),TbRetornoNis.class);
    }

}
 */
public class GenericDAO<Obj> {

    Session sessao = null;
    Class classe= null;
    
    public GenericDAO(Session session,Class classePersistida){
        this.sessao=session;
        this.classe=classePersistida;
    }

    public List<Obj> pesquisarTodos() {
        Transaction t = this.getSessao().beginTransaction();
        List lista = this.getSessao().createQuery("from "+this.getClasse().getName()).list();
        t.commit();
        this.getSessao().close();
        return lista;
    }

    public Obj inserir(Obj objeto) {
        Transaction t = this.getSessao().beginTransaction();
        this.getSessao().save(objeto);
        t.commit();
        this.getSessao().close();
        return (Obj) objeto;
    }

    public Obj atualizar(Obj objeto) {
        Transaction t = this.getSessao().beginTransaction();
        this.getSessao().update(objeto);
        t.commit();
        this.getSessao().close();
        return (Obj) objeto;
    }

    public boolean apagar(Obj objeto) {
        Transaction t = this.getSessao().beginTransaction();
        this.getSessao().delete(objeto);
        t.commit();
        this.getSessao().close();
        return true;
    }

    public Obj pesquisarPorID(int id) {
        Transaction t = this.getSessao().beginTransaction();
        Obj retorno = (Obj)this.getSessao().load(this.getClasse() ,id);
        try{
            if(retorno!=null)retorno.toString();
        }catch(Exception ex){}
        
        t.commit();
        this.getSessao().close();
        return retorno ;
    }

    public Obj pesquisarPorIDLong(long id) {
        Transaction t = this.getSessao().beginTransaction();
        Obj retorno = (Obj)this.getSessao().load(this.getClasse() ,id);
        try{
            if(retorno!=null)retorno.toString();
        }catch(ObjectNotFoundException ex){
            retorno=null;
        }
        t.commit();
        this.getSessao().close();
        return retorno ;
    }

    public List<Obj> pesquisarTodosOrdenado(String[] atributoOrdenar) {
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        for(String atual : atributoOrdenar){
            criteria.addOrder(Order.asc(atual).ignoreCase());
        }
        Transaction t = this.getSessao().beginTransaction();
        List lista = criteria.list();
        t.commit();
        this.getSessao().close();
        return (List<Obj>) lista;
    }

    public Session getSessao() {
        return sessao;
    }

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public Class getClasse() {
        return classe;
    }

    public void setClasse(Class classe) {
        this.classe = classe;
    }
    
    public List<Obj> pesquisarComFiltro(Obj objeto,String atributoOrdenar) {
        
        Criteria criteria = this.getSessao().createCriteria(this.getClasse());
        if(atributoOrdenar!=null && (!atributoOrdenar.equalsIgnoreCase(""))){
            criteria.addOrder(Order.asc(atributoOrdenar).ignoreCase());
        }
        
        Method met[] = objeto.getClass().getDeclaredMethods();
        for(int k=0;k<met.length;k++){
            if(met[k].getName().startsWith("get")){
                Object valor=null;
                Object lista[] = null;
                try {
                    valor = met[k].invoke(met[k], lista);
                    if(valor!=null){
                        String nomeCampo = met[k].getName().substring(met[k].getName().indexOf("get"));
                        if(met[k].getName().contains("nm")){ //Ifs separados para o caso de fazer alguma operaÃ§Ã£o especÃ­fica para cada tipo de dado, como conversÃ£o, por exemplo.
                            criteria.add(Restrictions.eq(nomeCampo, valor));
                        }else if(met[k].getName().contains("getId")){
                            criteria.add(Restrictions.eq(nomeCampo, valor));
                        }else if(met[k].getName().contains("getNr")){
                            criteria.add(Restrictions.eq(nomeCampo, valor));
                        }else if(met[k].getName().contains("getDs")){
                            criteria.add(Restrictions.eq(nomeCampo, valor));
                        }else if(met[k].getName().contains("getCd")){
                            criteria.add(Restrictions.eq(nomeCampo, valor));
                        }else if(met[k].getName().contains("getDt")){
                            criteria.add(Restrictions.eq(nomeCampo, valor));
                        }
                    }                
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        Transaction t = this.getSessao().beginTransaction();
        List lista = criteria.list();
        t.commit();
        this.getSessao().close();
        return (List<Obj>) lista;
    }
    

    
}




