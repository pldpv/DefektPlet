/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.helper;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import ua.gov.pv.defektplet.entity.Deviation;
import ua.gov.pv.defektplet.entity.Direction;
import ua.gov.pv.defektplet.entity.GovernedVelocity;
import ua.gov.pv.defektplet.entity.RailsDefect;
import ua.gov.pv.defektplet.entity.RailsStrings;
import ua.gov.pv.defektplet.entity.TemporaryRecovery;
import ua.gov.pv.defektplet.util.HibernateUtil;

/**
 *
 * @author ПГМ
 */
public class DefectStringsDataSource {

    Session session = null;
    private IntervalInformation ii;
    public DefectStringsDataSource(IntervalInformation ii) {
    this.ii=ii;
    }

    public List<RailsStrings> getRailsStrings() {
        List<RailsStrings> list = null;
        session = HibernateUtil.getSessionFactory().openSession();
        Criterion cr1 = Restrictions.le("startCoordinate", ii.getKmE() * 1000 + ii.getmE());
        Criterion cr2 = Restrictions.ge("endCoordinate", ii.getKmS() * 1000 + ii.getmS());
        list = session.createCriteria(RailsStrings.class)
                .add(Restrictions.eq("direction", ii.getDirection()))
                .add(Restrictions.eq("line", ii.getLine()))
                .add(Restrictions.eq("railThread", ii.getRailThread()))
                .add(Restrictions.and(cr1, cr2))
                .list();
        session.close();
        return list;
    }

    public List<TemporaryRecovery> getTemporaryRecovery() {
        List<TemporaryRecovery> list = new ArrayList<TemporaryRecovery>();
        session = HibernateUtil.getSessionFactory().openSession();
        list = session.createCriteria(TemporaryRecovery.class)
                .add(Restrictions.eq("direction", ii.getDirection()))
                .add(Restrictions.eq("line", ii.getLine()))
                .add(Restrictions.eq("railThread", ii.getRailThread()))
                .add(Restrictions.between("coordinate",
                                ii.getKmS() * 1000 + ii.getmS(), ii.getKmE() * 1000 + ii.getmE()))
                .list();
        session.close();
        return list;
    }

    public List<RailsDefect> getRailsDefectList() {
        List<RailsDefect> list = null;
        session = HibernateUtil.getSessionFactory().openSession();
        list = session.createCriteria(RailsDefect.class)
                .add(Restrictions.eq("direction", ii.getDirection()))
                .add(Restrictions.eq("line", ii.getLine()))
                .add(Restrictions.eq("railThread", ii.getRailThread()))
                .add(Restrictions.between("coordinate",
                                ii.getKmS() * 1000 + ii.getmS(), ii.getKmE() * 1000 + ii.getmE()))
                .list();
        session.close();
        return list;
    }

    public List<Deviation> getDeviations(String devType) {
        List<Deviation> list;
        session = HibernateUtil.getSessionFactory().openSession();
        list = session.createCriteria(Deviation.class)
                .add(Restrictions.eq("direction", ii.getDirection()))
                .add(Restrictions.eq("line", ii.getLine()))
                .add(Restrictions.between("coordinate",
                                ii.getKmS() * 1000 + ii.getmS(), ii.getKmE() * 1000 + ii.getmE()))
                .add(Restrictions.eq("deviation", devType))
                .list();
        session.close();
        return list;
    }

    public List<GovernedVelocity> getGovernedVelocity() {
        List<GovernedVelocity> list;
        session = HibernateUtil.getSessionFactory().openSession();
        Criterion cr1 = Restrictions.le("startCoordinate", ii.getKmE() * 1000 + ii.getmE());
        Criterion cr2 = Restrictions.ge("endCoordinate", ii.getKmS() * 1000 + ii.getmS());
        list = session.createCriteria(GovernedVelocity.class)
                .add(Restrictions.eq("direction", ii.getDirection()))
                .add(Restrictions.eq("line", ii.getLine()))
                .add(Restrictions.and(cr1, cr2))
                .list();
        session.close();
        return list;
    }

    public Direction getDirectionByNameLine() {
        session = HibernateUtil.getSessionFactory().openSession();
        Direction dir;
        dir = (Direction) session.createCriteria(Direction.class)
                .add(Restrictions.eq("direction", ii.getDirection()))
                .add(Restrictions.eq("line", ii.getLine())).uniqueResult();
        session.close();
        return dir;
    }
}
