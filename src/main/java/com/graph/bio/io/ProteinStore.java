/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graph.bio.io;

import com.graph.bio.domain.Protein;
import com.graph.bio.repository.ProteinRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author redbasin
 */
//@ContextConfiguration({"classpath:/spring/intact-context.xml" })
@ContextConfiguration("intact-context.xml")
@TransactionConfiguration(transactionManager = "neo4jTransactionManager", defaultRollback = true)
@Transactional
public class ProteinStore {
    
    @Autowired
    ProteinRepository proteinRepository;
    
    @Autowired 
    Neo4jOperations template;
    
    protected static Log log = LogFactory.getLog(new Object().getClass());
    
    public void saveProtein(String uniprot, String nodeType, String message, String moleculeIdRef) {
        Protein protein = new Protein(uniprot, nodeType, message, moleculeIdRef);
        proteinRepository.save(protein);
    }
    
}
