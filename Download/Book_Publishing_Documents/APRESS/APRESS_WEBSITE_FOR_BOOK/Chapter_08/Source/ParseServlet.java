package apress.wsad.techlib;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//  JAXP
import javax.xml.parsers.*;

//  DOM
import org.w3c.dom.*;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;


/**
 * @version 	1.0
 * @author
 */
public class ParseServlet extends HttpServlet
{

    // Variable to keep the initialization parameter
    protected String parserType;
    
    protected String filename = "workspace/XMLSamplesProject/Library.xml"; 
    
	
	public void doDelete(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException
	{
      
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException
	{
      //ServletConfig config = req.getServletConfig();
      
      if (parserType.equalsIgnoreCase("SAX"))
       {
        ParseUsingDOM();
       }
	  else
	   {
	   	ParseUsingSAX();
	   }	
	}

	/**
	* @see javax.servlet.http.HttpServlet#void (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	*/
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException
	{
         
	}

	/**
	* @see javax.servlet.GenericServlet#void ()
	*/
	public void init(ServletConfig config)  throws ServletException
	{
	 super.init(config);
	 
	 parserType = config.getInitParameter("Parser");
	 
	}


    public void ParseUsingDOM()
		throws ServletException, IOException
	{
	 try
	  {	
       
      
       // File xmlFile = new File(filename);
       
       // Get Document Builder Factory
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

       // Turn on validation. The file has been already validated 
       //factory.setValidating(true); 
       
       // Turn on namespaces
       factory.setNamespaceAware(true);
      
       DocumentBuilder builder = factory.newDocumentBuilder();
       
       // Setting Error Handling as anonymous inner class
       builder.setErrorHandler(
         new org.xml.sax.ErrorHandler()
         {
           // Ignore fatal errors because an exeption is guaranteed to be thrown.
           public void fatalError(SAXParseException fx)
             throws SAXParseException
             {
             
             }
        
           // Treat validation errors as fatal
           public void error(SAXParseException ex)
             throws SAXParseException
             {
              throw ex;
             }
        
           // Dump warning also
           public void warning(SAXParseException wx)
             throws SAXParseException
             {
              System.out.println("Warning, " + "line " + wx.getLineNumber() +
                ", uri " + wx.getSystemId());
                
              System.out.println(" " + wx.getMessage());  
              
             }          
         
         } // End of new
              
          ); //End of parameters
         
                   
              
       
       //Document document = builder.parse(xmlFile);
   
       Document document = builder.parse(filename);
   
       System.out.println("Parsed results: ");
				
	   domWriter(document.getDocumentElement());


	  } 
     catch(Exception e)
      {
	   System.err.println("XML exception has occured:" + e.getMessage());
	   e.printStackTrace(System.err);
	  } 

	}
    
   
    public String domWriter(Node node)
    {
  	 String workName = null; 	
  	
	 if ( node == null ) 
	   return "";

	 int type = node.getNodeType();
			
	 workName = node.getNodeName();
		
	 switch( type )
	  {
	
	   case Node.DOCUMENT_NODE: 
	    {
	  
	     domWriter(((org.w3c.dom.Document)node).
	             getDocumentElement());
	     break;
	    }
	   
	 	   
       case Node.ELEMENT_NODE: 
	    {
	     if (workName.equals("bk:Library")) 
	      {
	        System.out.println(workName + " ");	
	      } 
	    
	    
	     if (workName.equals("bk:Book")) 
	      {
	        System.out.println(workName + " "); 	
	      } 
	  
	    	   
	     if (workName.equals("BookTitle")) 
	      {
	        System.out.print(workName + " "); 	
	      } 
		  
	     if (workName.equals("Author")) 
	      {
	        System.out.println(workName + " "); 	
	      } 
	     	
	     if (workName.equals("FirstName")) 
	      {
	        System.out.print(workName + " "); 	
	      }  
	    
	     if (workName.equals("MiddleName")) 
	      {
	        System.out.print(workName + " "); 	
	      }   
	    
	  
	     if (workName.equals("LastName")) 
	      {
	       System.out.print(workName + " "); 	
	      
	      }  
	   	   
	   	   
	     NamedNodeMap attrs = node.getAttributes();
	
         int length = (attrs != null) ? attrs.getLength() : 0;
	 
	     for(int i = 0; i < length; i++)
	      {
	       Attr attr = (org.w3c.dom.Attr) attrs.item(i);
	       System.out.println(attr.getNodeName() + "=" + attr.getNodeValue());
	    	    
	      }
	
	  
	     NodeList children = node.getChildNodes();
	  
	     if( children != null) 
	      {
		   int len = children.getLength();
		 
		   for( int i = 0; i < len; i++)
		    {									
			 domWriter(children.item(i));
	        }
          }
	    	 
	     break;
	     
	 } // End of case 
	   
	case Node.CDATA_SECTION_NODE: 
	 {
	  System.out.println(node.getNodeValue());	
	  break;
	 }
	
    case Node.TEXT_NODE:
	 {
	  String nodeValue = node.getNodeValue();
	  if (nodeValue.trim().length() > 0)
	   { 	
	    System.out.println(nodeValue);	
	   }
	   	    
	  break;
	 }
  
   } // End of the switch
   
   return "";
   	
  }

 // === SAX Parser ===
 
 public void ParseUsingSAX()
		throws ServletException, IOException
  {
	 
     try
      {  
       // Get SAX Parser Factory
       SAXParserFactory factory = SAXParserFactory.newInstance();
   
       // Turn on validation, and turn off namespaces
       factory.setValidating(true);
       factory.setNamespaceAware(true);
   
       SAXParser parser = factory.newSAXParser();
       parser.parse(new File(filename), new eventHandler());
      }
     catch (ParserConfigurationException e)
      {
       System.out.println(
          "Parser error " + e.getMessage());
      }
     catch (FactoryConfigurationError e)
      {
       System.out.println("SAX Factoty Configuration Error " +
                                                e.getMessage());
      }
      
      catch (SAXException se)
      {
       System.out.println("SAX Execption " +
                                                se.getMessage());
      }
      
     catch (Exception e)
      {
       System.out.println("SAX Paser Error" + e.getMessage()); 
      }
 }
}

 
 
 // Content Handler Implementation
 class eventHandler extends DefaultHandler
 {
  private Writer out;
 
  public eventHandler() throws SAXException
   {
    try
     {
      out = new OutputStreamWriter(System.out, "UTF8");
     }
    catch (IOException e)
    {
     throw new SAXException("Error getting output handle");                                           
    }
  }
 
  // *** Event handling methods *** 
  
  public void startDocument() throws SAXException
  {
   System.out.println("SAX Parsing Results");
  }

  public void startElement(String namespaceURI, String localName,
                          String qName, org.xml.sax.Attributes attrs)
     throws SAXException
  {
  
   String workName;
  
   if (namespaceURI.equals(""))
    {
   	 workName = qName;
    }		
   else
    {
     workName = localName;	
    }	
 
   if (workName.equals("FirstName") || 
       workName.equals("MiddleName") || 
       workName.equals("LastName"))
    {
    	System.out.print(workName + " ");
    }		
   else
    {
     System.out.println(workName);	
    }	
   
     
   if (attrs != null)
    {
     for (int i = 0, len = attrs.getLength(); i < len; i++)
      {
       String workURI = attrs.getURI(i);
      
       if (workURI == null)
        {
   	     System.out.println(attrs.getQName(i) + attrs.getValue(i));
        }		
       else
        {
         System.out.println(attrs.getLocalName(i) + attrs.getValue(i));	
        }	
           
      }
    }
 
  }

 public void endElement(String namespaceURI, String localName,
                        String qName, org.xml.sax.Attributes attrs) 
                           throws SAXException
  {
   
  }
 
 //public void ignorableWhiteSpace(char[] ch, int start, int len) 
 //                        throws SAXException
 // {
 //  
 // }
 
  public void characters(char[] ch, int start, int len) 
                         throws SAXException
  {
   String workString = new String(ch, start, len);
  
   if (workString.trim().length() > 0)
    { 	
	 System.out.println(workString);	
    }	
  
 }
 
 	
		
}

