/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.DAO;

import co.com.lk.Entity.Master.TbUiUsuario;
import co.com.lk.connection.NewHibernateUtil;
import co.com.lk.helper.Sha1;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Likas
 */

public class UsuariosDAO  {
 
   

    public UsuariosDAO() {
    }
    
    public TbUiUsuario findByIdLogin(TbUiUsuario usuario) throws Exception{
        TbUiUsuario resultado = new TbUiUsuario();
         Session session = null;
         
           
        try{
           session= NewHibernateUtil.getSessionFactory().openSession();
       
            Query sqlHQL = session.getNamedQuery(TbUiUsuario.LOGIN_USER);
            sqlHQL.setParameter(0, usuario.getUsuario());
            sqlHQL.setParameter(1, Sha1.crypt(usuario.getPassword()));
            resultado = (TbUiUsuario) sqlHQL.uniqueResult();
            
            return resultado;
        }catch(Exception e){
            e.printStackTrace();
            throw   new Exception("Error listando los usuarios, "+e.getMessage());
        }
        finally{       
            if(session != null){
                session.close();
            }
        }
       
                
    }


    
}
