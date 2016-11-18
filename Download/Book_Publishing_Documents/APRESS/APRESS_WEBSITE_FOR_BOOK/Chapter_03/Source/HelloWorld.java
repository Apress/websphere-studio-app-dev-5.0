package apress.wsad.sample;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author Igor Livshin
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class HelloWorld
{

	/**
	 * Constructor for HelloWorld.
	 */
	public HelloWorld()
	{
		super();
	}

	public static void main(String[] args)
	{
	 Date today; 	 
  	  SimpleDateFormat sFormat; 
      String currentDate = "";	
 	
      HelloWorld hwInstance = new HelloWorld();
  
      today = new Date(); 
  
      sFormat = new SimpleDateFormat("MM-dd-yyyy"); 
  	  currentDate = sFormat.format(today);
    
  	  System.out.println("Date: " + currentDate);
  	  System.out.println("Hello World!"); 
	}
}
