/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graph.bio.domain;

/**
 *
 * @author redbasin
 */
import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

/**
 * @author Manoj Joshi
 */

@RelationshipEntity (type = "INTERACTS_WITH")
public class ProteinInteraction {
    @EndNode Protein endProtein;
    @StartNode Protein startProtein;
    
    @GraphId
    private Long id;

    String name;
    
    public Long getId() {
        return id;    
    }
    
    public ProteinInteraction() {
    }

    public ProteinInteraction(Protein startProtein, Protein endProtein) {
        this.startProtein = startProtein;
        this.endProtein = endProtein;  
    }
    
    /**
     * Example from Intact is "phosphorylation"
     * @return 
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Protein getStartProtein() {
        return startProtein;
    }

    public Protein getEndProtein() {
        return endProtein;
    }

    @Override
    public String toString() {
        return String.format("%s interacts %s in %s", startProtein, name, endProtein);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProteinInteraction proteinInteraction = (ProteinInteraction) o;
        if (id == null) return super.equals(o);
        return id.equals(proteinInteraction.id);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : super.hashCode();
    }
}