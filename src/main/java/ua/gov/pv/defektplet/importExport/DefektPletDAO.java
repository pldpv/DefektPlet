/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.importExport;

import java.util.LinkedList;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author ПГМ
 */
public class DefektPletDAO extends BaseDAO {

    public void saveList(List list) {
        if (list != null) {
            try {
                for (Object obj : list) {
                    getSession().save(obj);
                }
            } catch (HibernateException ex) {
                getSession().getTransaction().rollback();
            }finally{
               getSession().close();
            }
        }
    }

    public void deleteAll(Class clazz) {
        List list;
        list = getSession().createCriteria(clazz).list();
        try {
            for (Object obj : list) {
                getSession().delete(obj);
            }
        } catch (HibernateException ex) {
            getSession().getTransaction().rollback();
        }finally{
            getSession().close();
        }
    }
}
