/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graph.bio.domain;

/**
 *
 * @author redbasin
 */
import org.neo4j.graphdb.RelationshipType;

public enum ProteinInteractions implements RelationshipType {
    INTERACTSWITH
}
