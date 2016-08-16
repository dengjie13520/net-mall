package myListion;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class mysessionL
 *
 */
public class mysessionL implements HttpSessionListener, HttpSessionAttributeListener, HttpSessionActivationListener, HttpSessionBindingListener {

    public mysessionL() {
    	System.out.println("I am born");
    }


    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
    
    }

    public void attributeAdded(HttpSessionBindingEvent arg0)  { 
  
    }

    public void valueUnbound(HttpSessionBindingEvent arg0)  { 
       
    }

    public void sessionDidActivate(HttpSessionEvent arg0)  { 

    }

    public void sessionWillPassivate(HttpSessionEvent arg0)  { 

    }

    public void valueBound(HttpSessionBindingEvent arg0)  { 

    }

    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 

    }


    public void sessionCreated(HttpSessionEvent arg0)  { 
    	System.out.println(arg0.getSession().getId()+"is born,,,,,,,,,,,,,,,,");
    	System.out.println(arg0.getSession().getCreationTime()+"is born,,,,,,,,,,,,,,,,");
    	System.out.println(arg0.getSession().getMaxInactiveInterval()+"is born,,,,,,,,,,,,,,,,");
  
    }


    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	System.out.println(arg0.getSession().getId()+"is dead..................");
    }
	
}
