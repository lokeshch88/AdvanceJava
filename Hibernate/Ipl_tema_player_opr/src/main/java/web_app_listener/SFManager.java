package web_app_listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.hibernate.Hibernate;

import utils.HibernateUtils;

/**
 * Application Lifecycle Listener implementation class SFManager
 *
 */
@WebListener
public class SFManager implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public SFManager() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
        System.out.println("in conrtext init");
        //create singleton SF
        HibernateUtils.getFactory();
        
    }
	
}
