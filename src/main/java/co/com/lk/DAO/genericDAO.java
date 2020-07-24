/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.DAO;

import co.com.lk.Interfaces.genericImp;
import co.com.lk.connection.NewHibernateUtil;
import java.lang.reflect.Field;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Likas
 * @param <T>
 */
public  class genericDAO<T> implements genericImp<T>{
  
   
   
   
    public genericDAO() {
    }

    @Override
    public T findById(Integer id, String nameClass) throws Exception {
        
         T t= (T) Class.forName(nameClass).newInstance();
           
            
             Class c =  t.getClass();
            Field field = c.getDeclaredField("FINDID");
            field.setAccessible(true);
            Object value = field.get(c);
            String query =(String) value;
             Session session = null;
         
           
        try{
            session= NewHibernateUtil.getSessionFactory().openSession();
            Query sqlHQL = session.getNamedQuery(query);

            
            sqlHQL.setParameter(0, id);
             
            return  (T) sqlHQL.uniqueResult();
             
        }catch(Exception e){
            throw   new Exception("Error consultando el id:"+id+","+e.getMessage());
        }finally{
           if(session != null){
                session.close();
            }
        }
    
    }
    @Override
    public List<T> findAllLimit(String nameClass, int limit) throws Exception {
            T t= (T) Class.forName(nameClass).newInstance();
            
            Class c =  t.getClass();
            Field field = c.getDeclaredField("FINDALL");
            field.setAccessible(true);
            Object value = field.get(c);
            String query =(String) value;
            Session session = null;
         
           
        try{
            session= NewHibernateUtil.getSessionFactory().openSession();
            
            Query sqlnative =  session.getNamedQuery(query).setMaxResults(limit);
            //sqlnative.addEntity(t.getClass());
             List<Object> resultado= sqlnative.list();
             List<T> obj = (List<T>) resultado;
              return obj;
        }catch(Exception e){
            e.printStackTrace();
           throw   new Exception("Error listando los datos, "+e.getMessage());
        }finally{
           if(session != null){
               
                session.close();
            }
        }
       
          // 
          
    }
    
    
    
    @Override
    public List<T> findAll(String nameClass) throws Exception {
      
           
            T t= (T) Class.forName(nameClass).newInstance();
            
            Class c =  t.getClass();
            Field field = c.getDeclaredField("FINDALL");
            field.setAccessible(true);
            Object value = field.get(c);
            String query =(String) value;
           
            Session session = null;
         
           
        try{
            session= NewHibernateUtil.getSessionFactory().openSession();
            
            Query sqlnative =  session.getNamedQuery(query);
            //sqlnative.addEntity(t.getClass());
             List<Object> resultado= sqlnative.list();
             List<T> obj = (List<T>) resultado;
              return obj;
        }catch(Exception e){
            e.printStackTrace();
           throw   new Exception("Error listando los datos, "+e.getMessage());
        }finally{
           if(session != null){
               
                session.close();
            }
        }
       
          // 
          
    }

   @Override
    public long countAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long save(T obj,Long rol) throws Exception {
        if(rol<=2){
            long id;
            
              Session session = null;
         
           
        try{
           session= NewHibernateUtil.getSessionFactory().openSession();
            Transaction tr = session.getTransaction();
            
                    
                    tr.begin();
                     //session.clear();
                     System.out.println("elimiando 1");
                     id= (long) session.save(obj);  //guardamos el obj viejo
                     // limpia las asociaciones de las entidades.
                     System.out.println("elimiando 2");
                     
                     tr.commit();
                     System.out.println("elimiando 3");
                return id;
            }catch(org.hibernate.exception.ConstraintViolationException ex){
                ex.printStackTrace();
                session.getTransaction().rollback();
                throw  new Exception("valor duplicado, verifique los datos");
            }catch(Exception ex){
                session.getTransaction().rollback();
                throw  new Exception("Error guardando los datos, "+ex.getMessage());
            }finally{
               if(session != null){
                    session.close();
                }
            }
       }else{
             throw  new Exception("No tiene permisos para ejecutar esta acción");
       }
    }
    
    
    
    @Override
    public void saveorUpdate(T obj,Long rol) throws Exception {
       
            long id;
            
              Session session = null;
         
           
        try{
           session= NewHibernateUtil.getSessionFactory().openSession();
            Transaction tr = session.getTransaction();
            
                    
                    tr.begin();
                    session.saveOrUpdate(obj);  //guardamos el obj viejo
                     // limpia las asociaciones de las entidades.
                     // session.clear();
                    tr.commit();

            }catch(org.hibernate.exception.ConstraintViolationException ex){
                ex.printStackTrace();
                session.getTransaction().rollback();
                throw  new Exception("valor duplicado, verifique los datos");
            }catch(Exception ex){
                ex.printStackTrace();
                session.getTransaction().rollback();
                throw  new Exception("Error guardando o actualizando los datos, "+ex.getMessage());
            }finally{
               if(session != null){
                    session.close();
                }
            }
    }
    
    
    @Override
    public boolean delete(T obj,Long rol) throws Exception {
         if(rol<=1){
              Session session = null;
         
           
        try{
           session= NewHibernateUtil.getSessionFactory().openSession();
           Transaction tr = session.getTransaction();
                   
                    tr.begin();
                      session.delete(obj);  //guardamos el obj viejo
                     // limpia las asociaciones de las entidades.
                     // session.clear();
                      tr.commit();
                      

                    return true;  
                }catch(Exception ex){
                    session.getTransaction().rollback();
                    throw  new Exception("Error eliminando los datos "+ex.getMessage() );
                }finally{
                    if(session != null){
                        session.close();
                    }
                }
                //
         }else{
             throw  new Exception("No tiene permisos para ejecutar esta acción");
       }
     }
    
    @Override
    public long update(T obj,Long rol) throws Exception {
         if(rol<=2){
               Session session = null;
                try{
                   session= NewHibernateUtil.getSessionFactory().openSession();
                   Transaction tr = session.getTransaction();
                   tr.begin();
                   session.saveOrUpdate(obj);  //guardamos el obj viejo
                   // limpia las asociaciones de las entidades.
                   // session.clear();
                   tr.commit();
                   // session.clear();
                }catch(Exception ex){
                    session.getTransaction().rollback();
                    throw  new Exception("Error actualizando los datos");
                }finally{
                    if(session != null){
                        session.close();
                    }
                }
                return 0;
        }else{
             throw  new Exception("No tiene permisos para ejecutar esta acción");
       }
     }

     public final List<T> findLikeParameter(String nameClass, String staticVar,Object... parameters) throws Exception{
        
                  T t= (T) Class.forName(nameClass).newInstance();


                   Class c =  t.getClass();
                  Field field = c.getDeclaredField(staticVar);
                  field.setAccessible(true);
                  Object value = field.get(c);
                  String query =(String) value;
                 Session session = null;
         
           
                try{
                   session= NewHibernateUtil.getSessionFactory().openSession();
                  //Session session = ConnectionMysql.getSf().getCurrentSession();

                  Query sqlHQL =  session.getNamedQuery(query);

                  int i=0;
                  for(Object param:parameters){
                      sqlHQL.setParameter(i,param);
                      i++;
                  }         

                  List<T> resultado =  sqlHQL.list();

                  return resultado;
              }catch(Exception e){
                  e.printStackTrace();
                  throw   new Exception("Error listando los datos, "+e.getMessage());
              }finally{
                if(session != null){
                    session.close();
                }
              }
     }
     
     public final T findLikeid(String nameClass, String staticVar,Object... parameters) throws Exception{
        
                  T t= (T) Class.forName(nameClass).newInstance();
                  Class c =  t.getClass();
                  Field field = c.getDeclaredField(staticVar);
                  field.setAccessible(true);
                  Object value = field.get(c);
                  String query =(String) value;
                 Session session = null;
         
           
                try{
                   session= NewHibernateUtil.getSessionFactory().openSession();
                  //Session session = ConnectionMysql.getSf().getCurrentSession();

                  Query sqlHQL =  session.getNamedQuery(query);

                  int i=0;
                  for(Object param:parameters){
                      sqlHQL.setParameter(i, param);
                      i++;
                  }         

                 return  (T) sqlHQL.uniqueResult();

              }catch(Exception e){
            e.printStackTrace();
                  throw   new Exception("Error listando los datos, "+e.getMessage());
              }finally{
                if(session != null){
                    session.close();
                }
              }
     }

    @Override
    public Object createSQLQuery(String sqlString) throws Exception {
                
           
           
            
             Session session = null;
         
           
        try{
              session= NewHibernateUtil.getSessionFactory().openSession();
              //Session session = ConnectionMysql.getSf().getCurrentSession();
              String sql = sqlString;  
              Query   query = session.createQuery(sql);
              Object results = (Object) query.uniqueResult();



              return results;
              }catch(Exception e){
            e.printStackTrace();
                  throw   new Exception("Error listando los datos, "+e.getMessage());
              }finally{
                  if(session != null){
                    session.close();
                }
                  
              }

    }
    
    
     
    @Override
    public int execSQLQUERYupdate(String nameClass, String staticVar,Object... parameters) throws Exception{
                
                T t= (T) Class.forName(nameClass).newInstance();
                Class c =  t.getClass();
                Field field = c.getDeclaredField(staticVar);
                field.setAccessible(true);
                Object value = field.get(c);
                String query =(String) value;
                Session session = null;
                
                Transaction tx = null;
               
                try{
                   session= NewHibernateUtil.getSessionFactory().openSession();
                    tx = session.beginTransaction();
                   Query sqlHQL =  session.getNamedQuery(query);
                   int i=0;  
                   for(Object param:parameters){
                      sqlHQL.setParameter(i, param);
                      i++; 
                   }   
                   int totalafectado= sqlHQL.executeUpdate();
                   tx.commit();
                   
                   return totalafectado;
                }catch(Exception e){
                  e.printStackTrace();
                  throw   new Exception("Error listando los datos, "+e.getMessage());
                }finally{
                  if(session != null){
                      
                      session.close();
                  }
                }
    }
            
    @Override
    public List<T> createSQLQueryList(String sqlSquery,Class classs,Object... parameters) throws Exception {
        Session session = null;
        try{
            session= NewHibernateUtil.getSessionFactory().openSession();
            //Session session = ConnectionMysql.getSf().getCurrentSession();
            String sql = sqlSquery;  
            org.hibernate.Query   query = session.createSQLQuery(sql).addEntity(classs);
            
            int i=0;
            for(Object param:parameters){
                query.setParameter(i, param);
                i++;
            } 
            List<T> results = query.list();
            return results;
        }catch(Exception e){
            e.printStackTrace();
            throw   new Exception("Error listando los datos, "+e.getMessage());
        }finally{
            if(session != null){
              session.close();
          }

        }

    }     
    
    
    @Override
    public boolean execNativeSQLQuery(String nameClass,String staticVar,Object... parameters) throws Exception {               
           
        T t= (T) Class.forName(nameClass).newInstance();
        Class c =  t.getClass();
        Field field = c.getDeclaredField(staticVar);
        field.setAccessible(true);
        Object value = field.get(c);
        String query =(String) value;
        
        Session session = null;
        Transaction tx = null;   
        try{
           session= NewHibernateUtil.getSessionFactory().openSession();
           tx = session.beginTransaction();    
           String qn=session.getNamedQuery(query).getQueryString();
            System.err.println(qn);
           org.hibernate.Query   querys = session.createNativeQuery(qn);
           
           
           int i=1;
            for(Object param:parameters){
                querys.setParameter(i, param);
                i++;
            } 
                  
           querys.executeUpdate();

           tx.commit();
           return true;
        }catch(Exception e){
            e.printStackTrace();
            throw   new Exception("Error listando los datos, "+e.getMessage());
        }finally{
            if(session != null){
              session.close();
          }

        }

    }
}
