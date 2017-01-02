/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.datamodel.impl;
 
import com.fasterxml.jackson.annotation.JsonProperty;
import se.nrm.dina.datamodel.BaseEntity;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;  
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient; 
import se.nrm.dina.json.converter.annotation.DinaField;
import se.nrm.dina.json.converter.annotation.DinaId;
import se.nrm.dina.json.converter.annotation.DinaIgnor;
import se.nrm.dina.json.converter.annotation.DinaResource; 

/**
 *
 * @author idali
 */
@Entity
@Table(name = "preptype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preptype.findAll", query = "SELECT p FROM Preptype p"),
    @NamedQuery(name = "Preptype.findByPrepTypeID", query = "SELECT p FROM Preptype p WHERE p.prepTypeID = :prepTypeID"), 
    @NamedQuery(name = "Preptype.findByIsLoanable", query = "SELECT p FROM Preptype p WHERE p.isLoanable = :isLoanable"),
    @NamedQuery(name = "Preptype.findByName", query = "SELECT p FROM Preptype p WHERE p.name = :name")})
@DinaResource(type = "prepType")
public class Preptype extends BaseEntity {
    
//    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PrepTypeID")
    @DinaField(name = "prep-type-id")
    @DinaId
    private Integer prepTypeID;
     
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsLoanable")
    @DinaIgnor
    private boolean isLoanable;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "Name")
    @DinaField(name = "name")
    private String name;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prepTypeID", fetch = FetchType.LAZY)
    @DinaIgnor
    private List<Preparation> preparationList;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    @DinaIgnor
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    @DinaIgnor
    private Agent createdByAgentID;
    
    @JoinColumn(name = "CollectionID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne(optional = false)
    @DinaIgnor
    private Collection collectionID;
    
    @OneToMany(mappedBy = "prepTypeID", fetch = FetchType.LAZY)
    @DinaIgnor
    private List<Attributedef> attributedefList;

    public Preptype() {
    }

    public Preptype(Integer prepTypeID) {
        this.prepTypeID = prepTypeID;
    }

    public Preptype(Integer prepTypeID, Date timestampCreated, boolean isLoanable, String name) {
        this.prepTypeID = prepTypeID;
        this.timestampCreated = timestampCreated;
        this.isLoanable = isLoanable;
        this.name = name;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return String.valueOf(prepTypeID);
    }
    
//    @XmlAttribute(name = "uuid") 
//    @Override
//    public String getUUID() {
//        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + prepTypeID;
//    }
    
    @Override
    @JsonProperty("entity-id")
    public int getEntityId() {
        return prepTypeID;
    }

    @JsonProperty("prep-type-id")
    public Integer getPrepTypeID() {
        return prepTypeID;
    }

    public void setPrepTypeID(Integer prepTypeID) {
        this.prepTypeID = prepTypeID;
    }
 
    @JsonProperty("is-loanable")
    public boolean getIsLoanable() {
        return isLoanable;
    }

    public void setIsLoanable(boolean isLoanable) {
        this.isLoanable = isLoanable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Preparation> getPreparationList() {
        return preparationList;
    }

    public void setPreparationList(List<Preparation> preparationList) {
        this.preparationList = preparationList;
    }

    @XmlIDREF
    @JsonProperty("modified-by-agent-id")
    public Agent getModifiedByAgentID() {
        return modifiedByAgentID;
    }

    public void setModifiedByAgentID(Agent modifiedByAgentID) {
        this.modifiedByAgentID = modifiedByAgentID;
    }

    @XmlIDREF
    @JsonProperty("created-by-agent-id")
    public Agent getCreatedByAgentID() {
        return createdByAgentID;
    }

    public void setCreatedByAgentID(Agent createdByAgentID) {
        this.createdByAgentID = createdByAgentID;
    }

    @XmlIDREF
    @JsonProperty("collection-id")
    public Collection getCollectionID() {
        return collectionID;
    }

    public void setCollectionID(Collection collectionID) {
        this.collectionID = collectionID;
    }

    @XmlTransient
    public List<Attributedef> getAttributedefList() {
        return attributedefList;
    }

    public void setAttributedefList(List<Attributedef> attributedefList) {
        this.attributedefList = attributedefList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prepTypeID != null ? prepTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preptype)) {
            return false;
        }
        Preptype other = (Preptype) object;
        return !((this.prepTypeID == null && other.prepTypeID != null) || (this.prepTypeID != null && !this.prepTypeID.equals(other.prepTypeID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Preptype[ prepTypeID=" + prepTypeID + " ]";
    } 
}
