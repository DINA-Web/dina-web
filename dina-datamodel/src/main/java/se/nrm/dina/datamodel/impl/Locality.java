/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.dina.datamodel.impl;
 
import com.fasterxml.jackson.annotation.JsonProperty;
import se.nrm.dina.datamodel.BaseEntity;
import java.math.BigDecimal;
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
import javax.persistence.Lob;
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
import se.nrm.dina.json.converter.annotation.DinaManyToOne;
import se.nrm.dina.json.converter.annotation.DinaResource; 

/**
 *
 * @author idali
 */
@Entity
@Table(name = "locality")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Locality.findAll", query = "SELECT l FROM Locality l"),
    @NamedQuery(name = "Locality.findByLocalityID", query = "SELECT l FROM Locality l WHERE l.localityID = :localityID"), 
    @NamedQuery(name = "Locality.findByDatum", query = "SELECT l FROM Locality l WHERE l.datum = :datum"),
    @NamedQuery(name = "Locality.findByElevationAccuracy", query = "SELECT l FROM Locality l WHERE l.elevationAccuracy = :elevationAccuracy"),
    @NamedQuery(name = "Locality.findByElevationMethod", query = "SELECT l FROM Locality l WHERE l.elevationMethod = :elevationMethod"),
    @NamedQuery(name = "Locality.findByGuid", query = "SELECT l FROM Locality l WHERE l.guid = :guid"), 
    @NamedQuery(name = "Locality.findByVerbatimLongitude", query = "SELECT l FROM Locality l WHERE l.verbatimLongitude = :verbatimLongitude")})
@DinaResource(type = "locality")
public class Locality extends BaseEntity {
    
//    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LocalityID")
    @DinaField(name = "locality-id")
    @DinaId
    private Integer localityID;
    
    @Size(max = 50)
    @Column(name = "Datum")
    @DinaIgnor
    private String datum;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ElevationAccuracy")
    @DinaIgnor
    private Double elevationAccuracy;
    
    @Size(max = 50)
    @Column(name = "ElevationMethod")
    @DinaIgnor
    private String elevationMethod;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "GML")
    @DinaIgnor
    private String gml;
    
    @Size(max = 128)
    @Column(name = "GUID")
    @DinaField(name = "guid")
    private String guid;
     
    @Size(max = 50)
    @Column(name = "Lat1Text")
    @DinaField(name = "lat1-text")
    private String lat1Text;
     
    @Size(max = 50)
    @Column(name = "Lat2Text")
    @DinaIgnor
    private String lat2Text;
    
    @Column(name = "LatLongAccuracy")
    @DinaIgnor
    private Double latLongAccuracy;
    
    @Size(max = 50)
    @Column(name = "LatLongMethod")
    @DinaIgnor
    private String latLongMethod;
    
    @Size(max = 50)
    @Column(name = "LatLongType")
    @DinaIgnor
    private String latLongType;
    
    @Column(name = "Latitude1")
    @DinaField(name = "latitude")
    private BigDecimal latitude1;
    
    @Column(name = "Latitude2")
    @DinaIgnor
    private BigDecimal latitude2;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255) 
    @Column(name = "LocalityName")
    @DinaField(name = "locality-name")
    private String localityName;
    
    @Size(max = 50)
    @Column(name = "Long1Text")
    @DinaField(name = "long1-text")
    private String long1Text;
    
    @Size(max = 50)
    @Column(name = "Long2Text")
    @DinaIgnor
    private String long2Text;
    
    @Column(name = "Longitude1")
    @DinaField(name = "longitude")
    private BigDecimal longitude1;
    
    @Column(name = "Longitude2")
    @DinaIgnor
    private BigDecimal longitude2;
    
    @Column(name = "MaxElevation")
    @DinaField(name = "max-elevation")
    private Double maxElevation;
    
    @Column(name = "MinElevation")
    @DinaField(name = "min-elevation")
    private Double minElevation;
    
    @Size(max = 255)
    @Column(name = "NamedPlace")
    @DinaField(name = "named-place")
    private String namedPlace;
    
    @Size(max = 50)
    @Column(name = "OriginalElevationUnit")
    @DinaIgnor
    private String originalElevationUnit;
    
    @Column(name = "OriginalLatLongUnit")
    @DinaIgnor
    private Integer originalLatLongUnit;
    
    @Size(max = 120)
    @Column(name = "RelationToNamedPlace")
    @DinaIgnor
    private String relationToNamedPlace;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Remarks")
    @DinaField(name = "remarks")
    private String remarks;
    
    @Size(max = 32)
    @Column(name = "ShortName")
    @DinaField(name = "short-name")
    private String shortName;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "SrcLatLongUnit")
    @DinaField(name = "src-lat-long-unit")
    private short srcLatLongUnit;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Text1")
    @DinaIgnor
    private String text1;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Text2")
    @DinaIgnor
    private String text2;
    
    @Size(max = 50)
    @Column(name = "VerbatimElevation")
    @DinaIgnor
    private String verbatimElevation;
    
    @Column(name = "Visibility")
    @DinaIgnor
    private Short visibility;
    
    @Column(name = "SGRStatus")
    @DinaIgnor
    private Short sGRStatus;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Text3")
    @DinaIgnor
    private String text3;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Text4")
    @DinaIgnor
    private String text4;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "Text5")
    @DinaIgnor
    private String text5;
    
    @Size(max = 50)
    @Column(name = "VerbatimLatitude")
    @DinaField(name = "verbatim-latitude")
    private String verbatimLatitude;
    
    @Size(max = 50)
    @Column(name = "VerbatimLongitude")
    @DinaField(name = "verbatim-longitude")
    private String verbatimLongitude;
    
    @OneToMany(mappedBy = "localityID", fetch = FetchType.LAZY)
    @DinaIgnor
    private List<Geocoorddetail> geocoorddetailList;
    
    @JoinColumn(name = "DisciplineID", referencedColumnName = "UserGroupScopeId")
    @ManyToOne(optional = false)
    @DinaManyToOne(name = "discipline", type = "discipline")
    private Discipline disciplineID;
    
    @JoinColumn(name = "ModifiedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    @DinaIgnor
    private Agent modifiedByAgentID;
    
    @JoinColumn(name = "CreatedByAgentID", referencedColumnName = "AgentID")
    @ManyToOne
    @DinaManyToOne(name = "created-by-agent", type = "agent")
    private Agent createdByAgentID;
    
    @JoinColumn(name = "VisibilitySetByID", referencedColumnName = "SpecifyUserID")
    @ManyToOne
    @DinaIgnor
    private Specifyuser visibilitySetByID;
    
    @JoinColumn(name = "PaleoContextID", referencedColumnName = "PaleoContextID")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @DinaManyToOne(name = "paleo-context", type = "paleoContext")
    private Paleocontext paleoContextID;
    
    @JoinColumn(name = "GeographyID", referencedColumnName = "GeographyID")
    @ManyToOne
    @DinaManyToOne(name = "geography", type = "geography")
    private Geography geographyID;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localityID", fetch = FetchType.LAZY)
    @DinaIgnor
    private List<Localitycitation> localitycitationList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localityID", fetch = FetchType.LAZY)
    @DinaIgnor
    private List<Localitynamealias> localitynamealiasList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localityID", fetch = FetchType.LAZY)
    @DinaIgnor
    private List<Localityattachment> localityattachmentList;
    
    @OneToMany(mappedBy = "localityID", fetch = FetchType.LAZY)
    @DinaIgnor
    private List<Localitydetail> localitydetailList;
    
    @OneToMany(mappedBy = "localityID", fetch = FetchType.LAZY, cascade={CascadeType.MERGE, CascadeType.PERSIST})
    @DinaIgnor
    private List<Collectingevent> collectingeventList;

    public Locality() {
    }

    public Locality(Integer localityID) {
        this.localityID = localityID;
    }

    public Locality(Integer localityID, Date timestampCreated, String localityName, short srcLatLongUnit) {
        this.localityID = localityID;
        this.timestampCreated = timestampCreated;
        this.localityName = localityName;
        this.srcLatLongUnit = srcLatLongUnit;
    }
    
    @XmlID
    @XmlAttribute(name = "id")
    @Override
    public String getIdentityString() {
        return String.valueOf(localityID);
    }
    
//    @XmlAttribute(name = "uuid") 
//    @Override
//    public String getUUID() {
//        return Util.getInstance().getURLLink(this.getClass().getSimpleName()) + localityID;
//    }
    
    @Override
    @JsonProperty("entity-id")
    public int getEntityId() {
        return localityID;
    }

    @JsonProperty("locality-id")
    public Integer getLocalityID() {
        return localityID;
    }

    public void setLocalityID(Integer localityID) {
        this.localityID = localityID;
    }
  
    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    @JsonProperty("elevation-accuracy")
    public Double getElevationAccuracy() {
        return elevationAccuracy;
    }

    public void setElevationAccuracy(Double elevationAccuracy) {
        this.elevationAccuracy = elevationAccuracy;
    }

    @JsonProperty("elevation-method")
    public String getElevationMethod() {
        return elevationMethod;
    }

    public void setElevationMethod(String elevationMethod) {
        this.elevationMethod = elevationMethod;
    }

    public String getGml() {
        return gml;
    }

    public void setGml(String gml) {
        this.gml = gml;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @JsonProperty("lat1-text")
    public String getLat1Text() {
        return lat1Text;
    }

    public void setLat1Text(String lat1Text) {
        this.lat1Text = lat1Text;
    }

    @JsonProperty("lat2-text")
    public String getLat2Text() {
        return lat2Text;
    }

    public void setLat2Text(String lat2Text) {
        this.lat2Text = lat2Text;
    }

    @JsonProperty("lat-long-accuracy")
    public Double getLatLongAccuracy() {
        return latLongAccuracy;
    }

    public void setLatLongAccuracy(Double latLongAccuracy) {
        this.latLongAccuracy = latLongAccuracy;
    }

    @JsonProperty("lat-long-method")
    public String getLatLongMethod() {
        return latLongMethod;
    }

    public void setLatLongMethod(String latLongMethod) {
        this.latLongMethod = latLongMethod;
    }

    @JsonProperty("lat-long-type")
    public String getLatLongType() {
        return latLongType;
    }

    public void setLatLongType(String latLongType) {
        this.latLongType = latLongType;
    }

    public BigDecimal getLatitude1() {
        return latitude1;
    }

    public void setLatitude1(BigDecimal latitude1) {
        this.latitude1 = latitude1;
    }

    public BigDecimal getLatitude2() {
        return latitude2;
    }

    public void setLatitude2(BigDecimal latitude2) {
        this.latitude2 = latitude2;
    }

    @JsonProperty("locality-name")
    public String getLocalityName() {
        return localityName;
    }

    public void setLocalityName(String localityName) {
        this.localityName = localityName;
    }

    @JsonProperty("long1-text")
    public String getLong1Text() {
        return long1Text;
    }

    public void setLong1Text(String long1Text) {
        this.long1Text = long1Text;
    }

    @JsonProperty("long2-text")
    public String getLong2Text() {
        return long2Text;
    }

    public void setLong2Text(String long2Text) {
        this.long2Text = long2Text;
    }

    public BigDecimal getLongitude1() {
        return longitude1;
    }

    public void setLongitude1(BigDecimal longitude1) {
        this.longitude1 = longitude1;
    }

    public BigDecimal getLongitude2() {
        return longitude2;
    }

    public void setLongitude2(BigDecimal longitude2) {
        this.longitude2 = longitude2;
    }

    @JsonProperty("max-elevation")
    public Double getMaxElevation() {
        return maxElevation;
    }

    public void setMaxElevation(Double maxElevation) {
        this.maxElevation = maxElevation;
    }

    @JsonProperty("min-elevation")
    public Double getMinElevation() {
        return minElevation;
    }

    public void setMinElevation(Double minElevation) {
        this.minElevation = minElevation;
    }

    @JsonProperty("named-place")
    public String getNamedPlace() {
        return namedPlace;
    }

    public void setNamedPlace(String namedPlace) {
        this.namedPlace = namedPlace;
    }

    @JsonProperty("original-elevation-unit")
    public String getOriginalElevationUnit() {
        return originalElevationUnit;
    }

    public void setOriginalElevationUnit(String originalElevationUnit) {
        this.originalElevationUnit = originalElevationUnit;
    }

    @JsonProperty("original-lat-long-unit")
    public Integer getOriginalLatLongUnit() {
        return originalLatLongUnit;
    }

    public void setOriginalLatLongUnit(Integer originalLatLongUnit) {
        this.originalLatLongUnit = originalLatLongUnit;
    }

    @JsonProperty("relation-to-named-place")
    public String getRelationToNamedPlace() {
        return relationToNamedPlace;
    }

    public void setRelationToNamedPlace(String relationToNamedPlace) {
        this.relationToNamedPlace = relationToNamedPlace;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @JsonProperty("short-name")
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @JsonProperty("src-lat-long-unit")
    public short getSrcLatLongUnit() {
        return srcLatLongUnit;
    }

    public void setSrcLatLongUnit(short srcLatLongUnit) {
        this.srcLatLongUnit = srcLatLongUnit;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    @JsonProperty("verbatim-elevation")
    public String getVerbatimElevation() {
        return verbatimElevation;
    }

    public void setVerbatimElevation(String verbatimElevation) {
        this.verbatimElevation = verbatimElevation;
    }

    public Short getVisibility() {
        return visibility;
    }

    public void setVisibility(Short visibility) {
        this.visibility = visibility;
    }

    @JsonProperty("s-gr-status")
    public Short getSGRStatus() {
        return sGRStatus;
    }

    public void setSGRStatus(Short sGRStatus) {
        this.sGRStatus = sGRStatus;
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

    @JsonProperty("verbatim-latitude")
    public String getVerbatimLatitude() {
        return verbatimLatitude;
    }

    public void setVerbatimLatitude(String verbatimLatitude) {
        this.verbatimLatitude = verbatimLatitude;
    }

    @JsonProperty("verbatim-longitude")
    public String getVerbatimLongitude() {
        return verbatimLongitude;
    }

    public void setVerbatimLongitude(String verbatimLongitude) {
        this.verbatimLongitude = verbatimLongitude;
    }

    @XmlTransient
    public List<Geocoorddetail> getGeocoorddetailList() {
        return geocoorddetailList;
    }

    public void setGeocoorddetailList(List<Geocoorddetail> geocoorddetailList) {
        this.geocoorddetailList = geocoorddetailList;
    }

    @XmlIDREF
    @JsonProperty("discipline-id")
    public Discipline getDisciplineID() {
        return disciplineID;
    }

    public void setDisciplineID(Discipline disciplineID) {
        this.disciplineID = disciplineID;
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
    @JsonProperty("visibility-set-by-id")
    public Specifyuser getVisibilitySetByID() {
        return visibilitySetByID;
    }

    public void setVisibilitySetByID(Specifyuser visibilitySetByID) {
        this.visibilitySetByID = visibilitySetByID;
    }

    @XmlIDREF
    @JsonProperty("paleo-context-id")
    public Paleocontext getPaleoContextID() {
        return paleoContextID;
    }

    public void setPaleoContextID(Paleocontext paleoContextID) {
        this.paleoContextID = paleoContextID;
    }

    @XmlIDREF
    @JsonProperty("geography-id")
    public Geography getGeographyID() {
        return geographyID;
    }

    public void setGeographyID(Geography geographyID) {
        this.geographyID = geographyID;
    }

    @XmlTransient
    public List<Localitycitation> getLocalitycitationList() {
        return localitycitationList;
    }

    public void setLocalitycitationList(List<Localitycitation> localitycitationList) {
        this.localitycitationList = localitycitationList;
    }

    @XmlTransient
    public List<Localitynamealias> getLocalitynamealiasList() {
        return localitynamealiasList;
    }

    public void setLocalitynamealiasList(List<Localitynamealias> localitynamealiasList) {
        this.localitynamealiasList = localitynamealiasList;
    }

    @XmlTransient
    public List<Localityattachment> getLocalityattachmentList() {
        return localityattachmentList;
    }

    public void setLocalityattachmentList(List<Localityattachment> localityattachmentList) {
        this.localityattachmentList = localityattachmentList;
    }

    @XmlTransient
    public List<Localitydetail> getLocalitydetailList() {
        return localitydetailList;
    }

    public void setLocalitydetailList(List<Localitydetail> localitydetailList) {
        this.localitydetailList = localitydetailList;
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
        hash += (localityID != null ? localityID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Locality)) {
            return false;
        }
        Locality other = (Locality) object;
        return !((this.localityID == null && other.localityID != null) || (this.localityID != null && !this.localityID.equals(other.localityID)));
    }

    @Override
    public String toString() {
        return "se.nrm.dina.datamodel.Locality[ localityID=" + localityID + " ]";
    } 
}
