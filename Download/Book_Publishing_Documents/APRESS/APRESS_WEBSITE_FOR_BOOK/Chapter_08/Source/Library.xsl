<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    version="1.0"
    xmlns:xalan="http://xml.apache.org/xslt">
    <xsl:template match="Book">
      <xsl:apply-templates/>
    </xsl:template>
    <xsl:template match="BookTitle">
        <P></P> 
       <xsl:value-of select="."/>
       <BR></BR> 
    </xsl:template>
    <xsl:template match="Author">
       <xsl:value-of select="."/>
    </xsl:template>
 </xsl:stylesheet>
