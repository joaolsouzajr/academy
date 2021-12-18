package labs.academy;

import java.util.logging.*;
/**
 * Hello world!
 *
 */
public class App 
{
	private static Logger logger =  Logger.getLogger(App.class.getName());
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        logger.log(Level.INFO, "My info");
        logger.severe("Severe");
        logger.info("Another info");
        
        //java -Djava.util.logging.config.file=target/classes/logging.properties -jar target/certjava11-1.0-SNAPSHOT.jar
    }
}
