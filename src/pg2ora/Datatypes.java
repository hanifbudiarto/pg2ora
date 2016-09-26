/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pg2ora;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Muhammad Hanif B
 */
@Entity
@Table(name = "datatypes", catalog = "", schema = "")
@NamedQueries({
    @NamedQuery(name = "Datatypes.findAll", query = "SELECT d FROM Datatypes d"),
    @NamedQuery(name = "Datatypes.findByNo", query = "SELECT d FROM Datatypes d WHERE d.no = :no"),
    @NamedQuery(name = "Datatypes.findByPostgres", query = "SELECT d FROM Datatypes d WHERE d.postgres = :postgres"),
    @NamedQuery(name = "Datatypes.findByOracle", query = "SELECT d FROM Datatypes d WHERE d.oracle = :oracle")})
public class Datatypes implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "no")
    private Integer no;
    @Column(name = "postgres")
    private String postgres;
    @Column(name = "oracle")
    private String oracle;

    public Datatypes() {
    }

    public Datatypes(Integer no) {
        this.no = no;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        Integer oldNo = this.no;
        this.no = no;
        changeSupport.firePropertyChange("no", oldNo, no);
    }

    public String getPostgres() {
        return postgres;
    }

    public void setPostgres(String postgres) {
        String oldPostgres = this.postgres;
        this.postgres = postgres;
        changeSupport.firePropertyChange("postgres", oldPostgres, postgres);
    }

    public String getOracle() {
        return oracle;
    }

    public void setOracle(String oracle) {
        String oldOracle = this.oracle;
        this.oracle = oracle;
        changeSupport.firePropertyChange("oracle", oldOracle, oracle);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (no != null ? no.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datatypes)) {
            return false;
        }
        Datatypes other = (Datatypes) object;
        if ((this.no == null && other.no != null) || (this.no != null && !this.no.equals(other.no))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pg2ora.Datatypes[ no=" + no + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
