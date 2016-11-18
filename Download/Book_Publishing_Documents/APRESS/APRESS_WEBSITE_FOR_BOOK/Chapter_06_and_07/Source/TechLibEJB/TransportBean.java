package apress.wsad.techlib;

import java.io.Serializable;
import java.lang.*;
import java.util.*;

public class TransportBean implements Serializable
{

	protected String catalogNumber;
	protected String author;
	protected String bookTitle;
	protected String location;
	protected String platform;

	protected String txnDate;
	protected String txnTime;
	protected String txnType;
	protected String bookCatNum;
	protected String companyName;

	/**
	 * Constructor for TransportBean.
	 */
	public TransportBean()
	{
		super();

		// Init all fields
		catalogNumber = "";
		author = "";
		bookTitle = "";
		location = "";
		platform = "";
		txnDate = "";
		txnTime = "";
		txnType = "";
		bookCatNum = "";
		companyName = "";

	}

	/**
	 * Returns the author.
	 * @return String
	 */
	public String getAuthor()
	{
		return author;
	}

	/**
	 * Returns the bookCatNum.
	 * @return String
	 */
	public String getBookCatNum()
	{
		return bookCatNum;
	}

	/**
	 * Returns the bookTitle.
	 * @return String
	 */
	public String getBookTitle()
	{
		return bookTitle;
	}

	/**
	 * Returns the catalogNumber.
	 * @return String
	 */
	public String getCatalogNumber()
	{
		return catalogNumber;
	}

	/**
	 * Returns the companyName.
	 * @return String
	 */
	public String getCompanyName()
	{
		return companyName;
	}

	/**
	 * Returns the location.
	 * @return String
	 */
	public String getLocation()
	{
		return location;
	}

	/**
	 * Returns the platform.
	 * @return String
	 */
	public String getPlatform()
	{
		return platform;
	}

	/**
	 * Returns the txnDate.
	 * @return String
	 */
	public String getTxnDate()
	{
		return txnDate;
	}

	/**
	 * Returns the txnTime.
	 * @return String
	 */
	public String getTxnTime()
	{
		return txnTime;
	}

	/**
	 * Returns the txnType.
	 * @return String
	 */
	public String getTxnType()
	{
		return txnType;
	}

	/**
	 * Sets the author.
	 * @param author The author to set
	 */
	public void setAuthor(String author)
	{
		this.author = author;
	}

	/**
	 * Sets the bookCatNum.
	 * @param bookCatNum The bookCatNum to set
	 */
	public void setBookCatNum(String bookCatNum)
	{
		this.bookCatNum = bookCatNum;
	}

	/**
	 * Sets the bookTitle.
	 * @param bookTitle The bookTitle to set
	 */
	public void setBookTitle(String bookTitle)
	{
		this.bookTitle = bookTitle;
	}

	/**
	 * Sets the catalogNumber.
	 * @param catalogNumber The catalogNumber to set
	 */
	public void setCatalogNumber(String catalogNumber)
	{
		this.catalogNumber = catalogNumber;
	}

	/**
	 * Sets the companyName.
	 * @param companyName The companyName to set
	 */
	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}

	/**
	 * Sets the location.
	 * @param location The location to set
	 */
	public void setLocation(String location)
	{
		this.location = location;
	}

	/**
	 * Sets the platform.
	 * @param platform The platform to set
	 */
	public void setPlatform(String platform)
	{
		this.platform = platform;
	}

	/**
	 * Sets the txnDate.
	 * @param txnDate The txnDate to set
	 */
	public void setTxnDate(String txnDate)
	{
		this.txnDate = txnDate;
	}

	/**
	 * Sets the txnTime.
	 * @param txnTime The txnTime to set
	 */
	public void setTxnTime(String txnTime)
	{
		this.txnTime = txnTime;
	}

	/**
	 * Sets the txnType.
	 * @param txnType The txnType to set
	 */
	public void setTxnType(String txnType)
	{
		this.txnType = txnType;
	}

}
