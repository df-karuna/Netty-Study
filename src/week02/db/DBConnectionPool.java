package week02.db;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import week02.db.exception.ConnectionFailureException;
import week02.db.exception.ConnectionTimeOutException;

public class DBConnectionPool{
	private boolean refuseComplete = false;
	private boolean dataResourceFailure = false;
	private boolean passwordChanged = false;
	private String dbPath = "dbserver://study.netty.io:9569";
	
	@SuppressWarnings("finally")
	public DBConnectionPool(String dbPath, int port, String id, String password)
			throws ConnectionFailureException, ConnectionTimeOutException{
		if(port == 9568 && !refuseComplete){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				refuseComplete = true;
				throw new ConnectionTimeOutException();
			}
			
		} else if(port == 9569 && !passwordChanged ){
			passwordChanged = true;
			throw new ConnectionFailureException();
		}
		
		StringBuilder pathBuilder = new StringBuilder();
		
		pathBuilder.append(dbPath)
			.append(":")
			.append(port);
		
		if(!dbPath.equals(pathBuilder.toString())){
			throw new ConnectionFailureException();
		}
		
	}

	public int getDataResourcesCount(){
		return 10;
	}

	public List<Integer> getDataResources() {
		if(!dataResourceFailure)
			return null;
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++)
			arr.add(i);
		
		return arr;
	}
}
