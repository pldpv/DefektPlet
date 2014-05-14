/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.importExport;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import ua.gov.pv.defektplet.util.HibernateUtil;

/**
 *
 * @author ПГМ
 */
public class BaseDAO {

    private Session session;

    protected BaseDAO() {
    }
    public Session getSession() {
        session = (session != null)
                ? session : HibernateUtil.getSessionFactory().openSession();
        return session;
    }
}
