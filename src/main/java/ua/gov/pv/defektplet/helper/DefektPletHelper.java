/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.helper;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import ua.gov.pv.defektplet.entity.Deviation;
import ua.gov.pv.defektplet.entity.GovernedVelocity;
import ua.gov.pv.defektplet.entity.RailsDefect;
import ua.gov.pv.defektplet.entity.RailsStrings;
import ua.gov.pv.defektplet.entity.TemporaryRecovery;
import ua.gov.pv.defektplet.util.HibernateUtil;

/**
 *
 * @author ПГМ
 */
public class DefektPletHelper {

    Session session = null;
    IntervalInformation ii;

    DefektPletHelper(IntervalInformation ii) {
        this.ii = ii;
    }

    public List<RailsStrings> getRailsStrings() {
        List<RailsStrings> list = null;
        session = HibernateUtil.getSessionFactory().openSession();
        Criterion cr1 = Restrictions.le("startCoordinate", ii.kmE * 1000 + ii.mE);
        Criterion cr2 = Restrictions.ge("endCoordinate", ii.kmS * 1000 + ii.mS);
        list = session.createCriteria(RailsStrings.class)
                .add(Restrictions.eq("direction", ii.direction))
                .add(Restrictions.eq("line", ii.line))
                .add(Restrictions.eq("railThread", ii.railThread))
                .add(Restrictions.and(cr1, cr2))
                .list();
        session.close();
        return list;
    }

    public List<TemporaryRecovery> getTemporaryRecovery() {
        List<TemporaryRecovery> list = new ArrayList<TemporaryRecovery>();
        session = HibernateUtil.getSessionFactory().openSession();
        list = session.createCriteria(TemporaryRecovery.class)
                .add(Restrictions.eq("direction", ii.direction))
                .add(Restrictions.eq("line", ii.line))
                .add(Restrictions.between("coordinate", ii.kmS * 1000 + ii.mS, ii.kmE * 1000 + ii.mE))
                .list();
        session.close();
        return list;
    }

    public List<RailsDefect> getRailsDefectList() {
        List<RailsDefect> list = null;
        session = HibernateUtil.getSessionFactory().openSession();
        list = session.createCriteria(RailsDefect.class)
                .add(Restrictions.eq("direction", ii.direction))
                .add(Restrictions.eq("line", ii.line))
                .add(Restrictions.between("coordinate", ii.kmS * 1000 + ii.mS, ii.kmE * 1000 + ii.mE))
                .list();
        session.close();
        return list;
    }

    public List<Deviation> getDeviations(String devType) {
        List<Deviation> list;
        session = HibernateUtil.getSessionFactory().openSession();
        list = session.createCriteria(Deviation.class)
                .add(Restrictions.eq("direction", ii.direction))
                .add(Restrictions.eq("line", ii.line))
                .add(Restrictions.between("coordinate", ii.kmS * 1000 + ii.mS, ii.kmE * 1000 + ii.mE))
                .add(Restrictions.eq("deviation", devType))
                .list();
        session.close();
        return list;
    }

    public List<GovernedVelocity> getGovernedVelocity() {
        List<GovernedVelocity> list;
        session = HibernateUtil.getSessionFactory().openSession();
        Criterion cr1 = Restrictions.le("startCoordinate", ii.kmE * 1000 + ii.mE);
        Criterion cr2 = Restrictions.ge("endCoordinate", ii.kmS * 1000 + ii.mS);
        list = session.createCriteria(GovernedVelocity.class)
                .add(Restrictions.eq("direction", ii.direction))
                .add(Restrictions.eq("line", ii.line))
                .add(Restrictions.and(cr1, cr2))
                .list();
        session.close();
        return list;
    }
}
