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
public interface beanImp<T>  {
           

void save(T obj,List<String> updateObjecView) throws Exception;
void save(T obj) throws Exception;
void saveList(List<T> obj) throws Exception;
void newObejc(T obj) throws Exception;
void update(T obj) throws Exception;
void selectObjec(T obj) throws Exception;
void delete(T obj) throws Exception;
T findObject(Integer id) throws Exception;
T findById(Integer id) throws Exception;
List<T> findList() throws Exception;
List<T> findListObject(List<T> list) throws Exception;
List<T> findLikeParameter(String nameClass,String staticVar,Object... parameters) throws Exception;
T findIdLikeParameter(String nameClass,String staticVar,Object... parameters) throws Exception;



} 