Spring Data Graph Sample
========================

A simple Spring Data Neo4j example that demonstrates how to create a persist nodes and relationships. It also shows how
to fetch nodes using the index. 


Fetching the relationship was breaking, as there was a problem in the way the 
relationships were being initialized by Spring Data.
The work around (as recommended by Oliver Gierke) for now was to 
initialize relationships for @RelatedToVia manually. 

Was not able to figure out the bug, hence posted this on the spring data forum.

http://forum.springsource.org/showthread.php?128807-Not-able-to-fetch-relationships-of-node-using-Spring-Data-Neo4J

Build and Run
-------------

`mvn clean package exec:java`
