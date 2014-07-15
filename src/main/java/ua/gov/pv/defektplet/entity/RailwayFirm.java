/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.entity;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.Formula;
import ua.gov.pv.defektplet.util.HibernateUtil;

/**
 *
 * @author 1
 */
@Entity(name = "firm")
public class RailwayFirm implements Serializable {

    @EmbeddedId
    private FirmId firmId;

    @Column
    private String fullName;
    private String director;
    

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * @return the firmId
     */
    public FirmId getFirmId() {
        return firmId;
    }

    /**
     * @param firmId the firmId to set
     */
    public void setFirmId(FirmId firmId) {
        this.firmId = firmId;
    }
    public static void main(String ... args){
        RailwayFirm r= new RailwayFirm();
        r.setDirector("Tertychniy");
        r.setFullName("Kharkiv");
        FirmId f=new FirmId();
        f.setNameFirm("PCH-3");
        Railway rail = new Railway();
        rail.setId(1);
        rail.setIdRailway(4);
        rail.setRailwayName("South");
        f.setRailway(rail);
        r.setFirmId(f);
        Session sess=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=sess.beginTransaction();
        sess.save(r);
        tx.commit();
        sess.close();
        
    }
}

class Test{
}
