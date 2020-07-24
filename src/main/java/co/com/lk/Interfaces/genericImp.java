/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Interfaces;

import java.util.List;

/**
 *
 * @author Likas
 */
public interface genericImp<T>  {
           

T findById(Integer id, String nameClass) throws Exception;

List<T> findAll(String nameClass) throws Exception; 
List<T> findAllLimit(String nameClass, int limit) throws Exception; 
//List<T> findAll(Pagination paginacion); 
long countAll() throws Exception;

long save(T obj,Long rol) throws Exception;
void saveorUpdate(T obj,Long rol) throws Exception;
boolean delete(T obj,Long rol) throws Exception;

long update(T obj,Long rol) throws Exception;

List<T> findLikeParameter(String nameClass,String staticVar,Object... parameters) throws Exception; 

T findLikeid(String nameClass,String staticVar,Object... parameters) throws Exception; 

Object createSQLQuery(String sqlString) throws Exception;
List<T> createSQLQueryList(String sqlSquery,Class classs,Object... parameters) throws Exception;

int execSQLQUERYupdate(String nameClass, String staticVar,Object... parameters) throws Exception;;

boolean execNativeSQLQuery(String nameClass,String staticVar,Object... parameters) throws Exception;

} 