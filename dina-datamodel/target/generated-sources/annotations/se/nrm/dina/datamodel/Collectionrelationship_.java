package se.nrm.dina.datamodel;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import se.nrm.dina.datamodel.Agent;
import se.nrm.dina.datamodel.Collectionobject;
import se.nrm.dina.datamodel.Collectionreltype;

@Generated(value="EclipseLink-2.7.0.v20160211-rNA", date="2016-02-15T16:21:31")
@StaticMetamodel(Collectionrelationship.class)
public class Collectionrelationship_ extends BaseEntity_ {

    public static volatile SingularAttribute<Collectionrelationship, Collectionobject> leftSideCollectionID;
    public static volatile SingularAttribute<Collectionrelationship, String> text1;
    public static volatile SingularAttribute<Collectionrelationship, String> text2;
    public static volatile SingularAttribute<Collectionrelationship, Collectionreltype> collectionRelTypeID;
    public static volatile SingularAttribute<Collectionrelationship, Collectionobject> rightSideCollectionID;
    public static volatile SingularAttribute<Collectionrelationship, Agent> modifiedByAgentID;
    public static volatile SingularAttribute<Collectionrelationship, Agent> createdByAgentID;
    public static volatile SingularAttribute<Collectionrelationship, Integer> collectionRelationshipID;

}