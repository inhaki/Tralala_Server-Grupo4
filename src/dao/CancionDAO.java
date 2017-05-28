package dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import data.Cancion;

public class CancionDAO implements ICancionDAO {

	private PersistenceManagerFactory pmf;
	
	public CancionDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	public List<Cancion> getProducts() {
		PersistenceManager pm = pmf.getPersistenceManager();
		/* By default only 1 level is retrieved from the db
		 * so if we wish to fetch more than one level, we must indicate it
		 */
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		List<Cancion> products = new ArrayList<>();
		
		try {
			System.out.println("   * Retrieving an Extent for Products.");
			
			tx.begin();			
			Extent<Cancion> extent = pm.getExtent(Cancion.class, true);
			
			for (Cancion cancion : extent) {
				products.add(cancion);
			}

			tx.commit();			
		} catch (Exception ex) {
	    	System.out.println("   $ Error retrieving an extent: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}

    		pm.close();    		
	    }
	    				
		return products;
	}

	public List<Cancion> getBooks() {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		List<Cancion> books = new ArrayList<>();
		
		try {
			System.out.println("   * Retrieving an Extent for Books.");
			
			tx.begin();			
			Extent<Cancion> extent = pm.getExtent(Cancion.class, true);
			
			for (Cancion cancion : extent) {
				books.add(cancion);
			}
			
			tx.commit();
		} catch (Exception ex) {
	    	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
				
    		pm.close();
	    }
	    
		return books;
	}

	@Override
	public List<Cancion> getCanciones() {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		/* By default only 1 level is retrieved from the db
		 * so if we wish to fetch more than one level, we must indicate it
		 */
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		List<Cancion> canciones = new ArrayList<>();
		
		try {
			System.out.println("   * Retrieving an Extent for Products.");
			
			tx.begin();			
			Extent<Cancion> extent = pm.getExtent(Cancion.class, true);
			
			for (Cancion cancion : extent) {
				canciones.add(cancion);
			}

			tx.commit();			
		} catch (Exception ex) {
	    	System.out.println("   $ Error retrieving an extent: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}

    		pm.close();    		
	    }
	    				
		return canciones;
	}

	@Override
	public Cancion getCanciones(String name) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		Cancion product = null;
	    
		try {
			System.out.println ("   * Querying a Product: " + name);
			
	    	tx.begin();
	    	Query query = pm.newQuery("SELECT FROM " + Cancion.class.getName() + " WHERE name == '" + name + "'");
	    	query.setUnique(true);
	    	product = (Cancion)query.execute();	    
 	    	tx.commit();
   	    
	     } catch (Exception ex) {
		   	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		 }
				
	   		pm.close();
	     }

	    return product;
	}

}