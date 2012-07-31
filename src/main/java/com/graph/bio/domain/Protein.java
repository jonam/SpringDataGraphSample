/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graph.bio.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.neo4j.graphdb.Direction;
import static org.neo4j.graphdb.Direction.BOTH;
import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.data.neo4j.annotation.*;
import org.springframework.data.neo4j.support.index.IndexType;

/**
 * 
 * @author redbasin
 */
@NodeEntity
public class Protein {
    	
    protected static Log log = LogFactory.getLog(new Object().getClass());
    
    @GraphId
    private Long id;
    
    @Indexed
    private String uniprot;
    
    @Indexed
    private String nodeType;
    
    @Indexed
    private String message;
    
    /**
     * When not known, this will be set to the uniprot.
     */
    @Indexed 
    private String interactorId;
    
    /**
     * When not know, this will be set to the uniprot.
     */
    @Indexed
    private String moleculeIdRef;
    
    /**
     * This is the species.
     */
    @Indexed
    private String ncbiTaxId;
    
    public Iterable<ProteinInteraction> getProteinInteractions() {
        log.info("length = " + proteinInteractions.size());
        //return proteinInteractions;
        return IteratorUtil.asCollection(proteinInteractions);
    }
    
    @Indexed (indexType=IndexType.FULLTEXT, indexName = "interactorTypeXref")
    private String interactorTypeXref;
    
   
    @Indexed
    private String intactId;
    
    @RelatedToVia(elementClass = ProteinInteraction.class, type = "INTERACTS_WITH", direction = Direction.BOTH)
    //@RelatedToVia(type = "INTERACTS_WITH", direction = BOTH)
    Set<ProteinInteraction> proteinInteractions = new HashSet<ProteinInteraction>(  );

    public Protein(String uniprot, String nodeType, String message, String moleculeIdRef) {
        this.uniprot = uniprot; 
        this.nodeType = nodeType;
        this.message = message;
        this.moleculeIdRef = moleculeIdRef;
    }
    
    public ProteinInteraction interactsWith(Protein protein, String name) {
        final ProteinInteraction proteinInteraction = new ProteinInteraction(this, protein);
        proteinInteraction.setName(name);
        if (proteinInteractions == null) {
            proteinInteractions = new LinkedHashSet<ProteinInteraction>();
        }
        proteinInteractions.add(proteinInteraction);
        return proteinInteraction;
    }
    
    public Protein() {}

    public Long getId() {
    	return id;
    }
    
    public String getNodeType() {
        return nodeType;
    }
    
    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getMoleculeIdRef() {
        return moleculeIdRef;
    }
    
    public void setMoleculeIdRef(String moleculeIdRef) {
        this.moleculeIdRef = moleculeIdRef;
    }    

	@Override
	public int hashCode() {
        return (id == null) ? 0 : id.hashCode();
	}


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Protein other = (Protein) obj;
        if ((this.uniprot == null) ? (other.uniprot != null) : !this.uniprot.equals(other.uniprot)) {
            return false;
        }
        if ((this.nodeType == null) ? (other.nodeType != null) : !this.nodeType.equals(other.nodeType)) {
            return false;
        }
        return true;
    }

    
    @Indexed (indexType=IndexType.FULLTEXT, indexName = "interactoralias")
    private String alias;
    
    /**
     
     */
    @Indexed (indexType=IndexType.FULLTEXT, indexName = "interactorxref")
    private String xref;
    
}
