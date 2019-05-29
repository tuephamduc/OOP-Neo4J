package controller;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.Transaction;

import data.Config;


public class Connection {
	
	public final Driver driver;
	
	public final static Connection connection = new Connection(Config.host,Config.username,Config.password);
	
   
	public Connection( String uri, String user, String password ){
        driver = GraphDatabase.driver( uri, AuthTokens.basic( user, password ) );
    }
    
    public void close() throws Exception{
        driver.close();
    }
	
    public void execute (String s) {
    	  try (Session session = driver.session()){
              try (Transaction tx = session.beginTransaction()){
                  tx.run(s);
                  tx.success();
              }
          }
    }
    
	public void removeData(){
		try {
			connection.execute("match (n) detach delete n");
			} catch (Exception e) {
				System.out.println(e.getMessage());
		}
	};
}