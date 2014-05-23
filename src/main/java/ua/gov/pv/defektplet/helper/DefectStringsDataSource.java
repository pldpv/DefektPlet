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

    public DefectStringsDataSource() {
    }

    public List<RailsStrings> getRailsStrings(String direction, int line,
            String railThread, int kmS, int mS, int kmE, int mE) {
        List<RailsStrings> list = null;
        session = HibernateUtil.getSessionFactory().openSession();
        Criterion cr1 = Restrictions.le("startCoordinate", kmE * 1000 + mE);
        Criterion cr2 = Restrictions.ge("endCoordinate", kmS * 1000 + mS);
        list = session.createCriteria(RailsStrings.class)
                .add(Restrictions.eq("direction", direction))
                .add(Restrictions.eq("line", line))
                .add(Restrictions.eq("railThread", railThread))
                .add(Restrictions.and(cr1, cr2))
                .list();
        session.close();
        return list;
    }

    public List<TemporaryRecovery> getTemporaryRecovery(String direction, int line,
            String railThread, int kmS, int mS, int kmE, int mE) {
        List<TemporaryRecovery> list = new ArrayList<TemporaryRecovery>();
        session = HibernateUtil.getSessionFactory().openSession();
        list = session.createCriteria(TemporaryRecovery.class)
                .add(Restrictions.eq("direction", direction))
                .add(Restrictions.eq("line", line))
                .add(Restrictions.eq("railThread", railThread))
                .add(Restrictions.between("coordinate",
                                kmS * 1000 + mS, kmE * 1000 + mE))
                .list();
        session.close();
        return list;
    }

    public List<RailsDefect> getRailsDefectList(String direction, int line,
            String railThread, int kmS, int mS, int kmE, int mE) {
        List<RailsDefect> list = null;
        session = HibernateUtil.getSessionFactory().openSession();
        list = session.createCriteria(RailsDefect.class)
                .add(Restrictions.eq("direction", direction))
                .add(Restrictions.eq("line", line))
                .add(Restrictions.eq("railThread", railThread))
                .add(Restrictions.between("coordinate",
                                kmS * 1000 + mS, kmE * 1000 + mE))
                .list();
        session.close();
        return list;
    }

    public List<Deviation> getDeviations(String devType, String direction,
            int line, int kmS, int mS, int kmE, int mE) {
        List<Deviation> list;
        session = HibernateUtil.getSessionFactory().openSession();
        list = session.createCriteria(Deviation.class)
                .add(Restrictions.eq("direction", direction))
                .add(Restrictions.eq("line", line))
                .add(Restrictions.between("coordinate",
                                kmS * 1000 + mS, kmE * 1000 + mE))
                .add(Restrictions.eq("deviation", devType))
                .list();
        session.close();
        return list;
    }

    public List<GovernedVelocity> getGovernedVelocity(String direction,
            int line, int kmS, int mS, int kmE, int mE) {
        List<GovernedVelocity> list;
        session = HibernateUtil.getSessionFactory().openSession();
        Criterion cr1 = Restrictions.le("startCoordinate", kmE * 1000 + mE);
        Criterion cr2 = Restrictions.ge("endCoordinate", kmS * 1000 + mS);
        list = session.createCriteria(GovernedVelocity.class)
                .add(Restrictions.eq("direction", direction))
                .add(Restrictions.eq("line", line))
                .add(Restrictions.and(cr1, cr2))
                .list();
        session.close();
        return list;
    }

    public Direction getDirectionByNameLine(String direction, int line) {
        session = HibernateUtil.getSessionFactory().openSession();
        Direction dir;
        dir = (Direction) session.createCriteria(Direction.class)
                .add(Restrictions.eq("direction", direction))
                .add(Restrictions.eq("line", line)).uniqueResult();
        session.close();
        return dir;
    }
}
