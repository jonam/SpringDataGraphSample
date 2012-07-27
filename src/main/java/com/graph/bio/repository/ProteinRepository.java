package com.graph.bio.repository;

import com.graph.bio.domain.Protein;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * @author Manoj Joshi
 */
public interface ProteinRepository extends GraphRepository<Protein> {
}
