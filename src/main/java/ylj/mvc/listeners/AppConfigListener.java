package ylj.mvc.listeners;

import java.security.Security;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.xml.DOMConfigurator;
//import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class AppConfigListener implements ServletContextListener{

	static Logger logger=LoggerFactory.getLogger(AppConfigListener.class);


	public void contextInitialized(ServletContextEvent sce) {
		
		System.out.println("AppConfigListener contextInitialized init ...");
	
		System.out.println("log4j init ...");
		DOMConfigurator.configure(AppConfigListener.class.getResource("/conf/log4j.xml"));

//		System.out.println("dbcp init ...");
//		ConnectionUtil.init(HouseController.class.getResourceAsStream("/conf/dbcp.properties"));			
		
//		System.out.println("JPA init ...");
//		EntityManagerHelper.init();

//		System.out.println("BouncyCastle init ...");	
//		Security.addProvider(new BouncyCastleProvider());

	}
	
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("AppConfigListener contextDestroyed init ...");

	}	
}
