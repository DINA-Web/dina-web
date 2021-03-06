/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.datamodel.impl;
 
import se.nrm.dina.datamodel.BaseEntity;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;  
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient; 

/**
 *
 * @author idali
 */
@Entity
@Table(name = "collectingeventattribute")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Collectingeventattribute.findAll", query = "SELECT c FROM Collectingeventattribute c"),
    @NamedQuery(name = "Collectingeventattribute.findByCollectingEventAttributeID", query = "SELECT c FROM Collectingeventattribute c WHERE c.collectingEventAttributeID = :collectingEventAttributeID") })
public class Collectingeventattribute extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CollectingEventAttributeID")
    private Integer collectingEventAttributeID;
    
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Number1")
    private Float number1;
    
    @Column(name = "Number10")
    private Float number10;
    
    @Column(name = "Number11")
    private Float number11;
    
    @Column(name = "Number12")
    private Float number12;
    
    @Column(name = "Number13")
    private Float number13;
    
    @Column(name = "Number2")
    private Float number2;
    
    @Column(name = "Number3")
    private Float number3;
    
    @Column(name = "Number4")
    private Float number4;
    
    @Column(name = "Number5")
    private Float number5;
    
    @Column(name = "Number6")
    private Float number6;
    
    @Column(name = "Number7")
    private Float number7;
    
    @Column(name = "Number8")
    private Float number8;
    
    @Column(name = "Number9")
    private Float number9;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    private String remarks;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Text1")
    private String text1;
    
    @Size(max = 50)
    @Column(name = "Text10")
    private String text10;
    
    @Size(max = 50)
    @Column(name = "Text11")
    private String text11;
    
    @Size(max = 50)
    @Column(name = "Text12")
    private String text12;
    
    @Size(max = 50)
    @Column(name = "Text13")
    private String text13;
    
    @Size(max = 50)
    @Column(name = "Text14")
    private String text14;
    
    @Size(max = 50)
    @Column(name = "Text15")
    private String text15;
    
    @Size(max = 50)
    @Column(name = "Text16")
    private String text16;
    
    @Size(max = 50)
    @Column(name = "Text17")
    private String text17;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Text2")
    private String text2;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Text3")
    private String text3;
    
    @Size(max = 100)
    @Column(name = "Text4")
    private String text4;
    
    @Size(max = 100)
    @Column(name = "Text5")
    private String text5;
    
    @Size(max = 50)
    @Column(name = "Text6")
    private String text6;
    
    @Size(max = 50)
    @Column(name = "Text7")
    private String text7;
    
    @Size(max = 50)
    @Column(name = "Text8")
    private String text8;
    
    @Size(max = 50)
    @Column(name = "Text9")
    private String text9;
    
    @Column(name = "YesNo1")
    private Boolean yesNo1;
    
    @Column(name = "YesNo2")
    private Boolean yesNo2;
    
    @Column(name = "YesNo3")
    private Boolean yesNo3;
    
    @Column(name = "YesNo4")
    private Boolean yesNo4;
    
    @Column(name = "YesNo5")
    private Boolean yesNo5;
    
    @JoinColumn(name = "HostTaxonID", referencedColumnName = "TaxonID")
    @ManyToOne
    private Taxon hostTaxonID;
    
    @JoinColumn(name = "DisciplineID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne
    private Discipline disciplineID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    private Agent createdByAgentID;
    
    @OneToMany(mappedBy = "collectingEventAttributeID", fetch = FetchType.LAZY)
    private List<Collectingevent> collectingeventList;

    public Collectingeventattribute() {
    }

    public Collectingeventattribute(Integer collectingEventAttributeID) {
        this.collectingEventAttributeID = collectingEventAttributeID;
    }

    public Collectingeventattribute(Integer collectingEventAttributeID, Date timestampCreated) {
        this.collectingEventAttributeID = collectingEventAttributeID;
        this.timestampCreated = timestampCreated;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return String.valueOf(collectingEventAttributeID);
    }
    
//    @XmlAttribute(name = "uuid") 
//    @Override
//    public String getUUID() {
//        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + collectingEventAttributeID;
//    }

    @Override
    public int getEntityId() {
        return collectingEventAttributeID;
    }
    
    public Integer getCollectingEventAttributeID() {
        return collectingEventAttributeID;
    }

    public void setCollectingEventAttributeID(Integer collectingEventAttributeID) {
        this.collectingEventAttributeID = collectingEventAttributeID;
    }
 
    public Float getNumber1() {
        return number1;
    }

    public void setNumber1(Float number1) {
        this.number1 = number1;
    }

    public Float getNumber10() {
        return number10;
    }

    public void setNumber10(Float number10) {
        this.number10 = number10;
    }

    public Float getNumber11() {
        return number11;
    }

    public void setNumber11(Float number11) {
        this.number11 = number11;
    }

    public Float getNumber12() {
        return number12;
    }

    public void setNumber12(Float number12) {
        this.number12 = number12;
    }

    public Float getNumber13() {
        return number13;
    }

    public void setNumber13(Float number13) {
        this.number13 = number13;
    }

    public Float getNumber2() {
        return number2;
    }

    public void setNumber2(Float number2) {
        this.number2 = number2;
    }

    public Float getNumber3() {
        return number3;
    }

    public void setNumber3(Float number3) {
        this.number3 = number3;
    }

    public Float getNumber4() {
        return number4;
    }

    public void setNumber4(Float number4) {
        this.number4 = number4;
    }

    public Float getNumber5() {
        return number5;
    }

    public void setNumber5(Float number5) {
        this.number5 = number5;
    }

    public Float getNumber6() {
        return number6;
    }

    public void setNumber6(Float number6) {
        this.number6 = number6;
    }

    public Float getNumber7() {
        return number7;
    }

    public void setNumber7(Float number7) {
        this.number7 = number7;
    }

    public Float getNumber8() {
        return number8;
    }

    public void setNumber8(Float number8) {
        this.number8 = number8;
    }

    public Float getNumber9() {
        return number9;
    }

    public void setNumber9(Float number9) {
        this.number9 = number9;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText10() {
        return text10;
    }

    public void setText10(String text10) {
        this.text10 = text10;
    }

    public String getText11() {
        return text11;
    }

    public void setText11(String text11) {
        this.text11 = text11;
    }

    public String getText12() {
        return text12;
    }

    public void setText12(String text12) {
        this.text12 = text12;
    }

    public String getText13() {
        return text13;
    }

    public void setText13(String text13) {
        this.text13 = text13;
    }

    public String getText14() {
        return text14;
    }

    public void setText14(String text14) {
        this.text14 = text14;
    }

    public String getText15() {
        return text15;
    }

    public void setText15(String text15) {
        this.text15 = text15;
    }

    public String getText16() {
        return text16;
    }

    public void setText16(String text16) {
        this.text16 = text16;
    }

    public String getText17() {
        return text17;
    }

    public void setText17(String text17) {
        this.text17 = text17;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public String getText4() {
        return text4;
    }

    public void setText4(String text4) {
        this.text4 = text4;
    }

    public String getText5() {
        return text5;
    }

    public void setText5(String text5) {
        this.text5 = text5;
    }

    public String getText6() {
        return text6;
    }

    public void setText6(String text6) {
        this.text6 = text6;
    }

    public String getText7() {
        return text7;
    }

    public void setText7(String text7) {
        this.text7 = text7;
    }

    public String getText8() {
        return text8;
    }

    public void setText8(String text8) {
        this.text8 = text8;
    }

    public String getText9() {
        return text9;
    }

    public void setText9(String text9) {
        this.text9 = text9;
    }

    public Boolean getYesNo1() {
        return yesNo1;
    }

    public void setYesNo1(Boolean yesNo1) {
        this.yesNo1 = yesNo1;
    }

    public Boolean getYesNo2() {
        return yesNo2;
    }

    public void setYesNo2(Boolean yesNo2) {
        this.yesNo2 = yesNo2;
    }

    public Boolean getYesNo3() {
        return yesNo3;
    }

    public void setYesNo3(Boolean yesNo3) {
        this.yesNo3 = yesNo3;
    }

    public Boolean getYesNo4() {
        return yesNo4;
    }

    public void setYesNo4(Boolean yesNo4) {
        this.yesNo4 = yesNo4;
    }

    public Boolean getYesNo5() {
        return yesNo5;
    }

    public void setYesNo5(Boolean yesNo5) {
        this.yesNo5 = yesNo5;
    }

    @XmlIDREF
    public Taxon getHostTaxonID() {
        return hostTaxonID;
    }

    public void setHostTaxonID(Taxon hostTaxonID) {
        this.hostTaxonID = hostTaxonID;
    }

    @XmlIDREF
    public Discipline getDisciplineID() {
        return disciplineID;
    }

    public void setDisciplineID(Discipline disciplineID) {
        this.disciplineID = disciplineID;
    }

    @XmlIDREF
    public Agent getModifiedByAgentID() {
        return modifiedByAgentID;
    }

    public void setModifiedByAgentID(Agent modifiedByAgentID) {
        this.modifiedByAgentID = modifiedByAgentID;
    }

    @XmlIDREF
    public Agent getCreatedByAgentID() {
        return createdByAgentID;
    }

    public void setCreatedByAgentID(Agent createdByAgentID) {
        this.createdByAgentID = createdByAgentID;
    }

    @XmlTransient
    public List<Collectingevent> getCollectingeventList() {
        return collectingeventList;
    }

    public void setCollectingeventList(List<Collectingevent> collectingeventList) {
        this.collectingeventList = collectingeventList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (collectingEventAttributeID != null ? collectingEventAttributeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Collectingeventattribute)) {
            return false;
        }
        Collectingeventattribute other = (Collectingeventattribute) object;
        return !((this.collectingEventAttributeID == null && other.collectingEventAttributeID != null) || (this.collectingEventAttributeID != null && !this.collectingEventAttributeID.equals(other.collectingEventAttributeID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Collectingeventattribute[ collectingEventAttributeID=" + collectingEventAttributeID + " ]";
    } 
}
