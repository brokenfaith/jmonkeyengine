/**
 * assetType.java
 *
 * This file was generated by XMLSpy 2006sp2 Enterprise Edition.
 *
 * YOU SHOULD NOT MODIFY THIS FILE, BECAUSE IT WILL BE
 * OVERWRITTEN WHEN YOU RE-RUN CODE GENERATION.
 *
 * Refer to the XMLSpy Documentation for further details.
 * http://www.altova.com/xmlspy
 */


package com.jmex.model.collada.schema;

import com.jmex.model.collada.types.SchemaDateTime;
import com.jmex.model.collada.types.SchemaString;

public class assetType extends com.jmex.model.collada.xml.Node {

    private static final long serialVersionUID = 1L;

	public assetType(assetType node) {
		super(node);
	}

	public assetType(org.w3c.dom.Node node) {
		super(node);
	}

	public assetType(org.w3c.dom.Document doc) {
		super(doc);
	}

	public assetType(com.jmex.model.collada.xml.Document doc, String namespaceURI, String prefix, String name) {
		super(doc, namespaceURI, prefix, name);
	}
	
	public void adjustPrefix() {
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "contributor" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "contributor", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
			new contributorType(tmpNode).adjustPrefix();
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "created" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "created", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "keywords" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "keywords", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "modified" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "modified", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "revision" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "revision", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "subject" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "subject", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "title" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "title", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "unit" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "unit", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
			new unitType(tmpNode).adjustPrefix();
		}
		for (	org.w3c.dom.Node tmpNode = getDomFirstChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "up_axis" );
				tmpNode != null;
				tmpNode = getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "up_axis", tmpNode )
			) {
			internalAdjustPrefix(tmpNode, true);
		}
	}

	public static int getcontributorMinCount() {
		return 0;
	}

	public static int getcontributorMaxCount() {
		return Integer.MAX_VALUE;
	}

	public int getcontributorCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "contributor");
	}

	public boolean hascontributor() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "contributor");
	}

	public contributorType newcontributor() {
		return new contributorType(domNode.getOwnerDocument().createElementNS("http://www.collada.org/2005/11/COLLADASchema", "contributor"));
	}

	public contributorType getcontributorAt(int index) throws Exception {
		return new contributorType(dereference(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "contributor", index)));
	}

	public org.w3c.dom.Node getStartingcontributorCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "contributor" );
	}

	public org.w3c.dom.Node getAdvancedcontributorCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "contributor", curNode );
	}

	public contributorType getcontributorValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.model.collada.xml.XmlException("Out of range");
		else
			return new contributorType( dereference(curNode) );
	}

	public contributorType getcontributor() throws Exception 
 {
		return getcontributorAt(0);
	}

	public void removecontributorAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "contributor", index);
	}

	public void removecontributor() {
		while (hascontributor())
			removecontributorAt(0);
	}

	public void addcontributor(contributorType value) {
		appendDomElement("http://www.collada.org/2005/11/COLLADASchema", "contributor", value);	
	}

	public void insertcontributorAt(contributorType value, int index) {
		insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "contributor", index, value);
	}

	public void replacecontributorAt(contributorType value, int index) {
		replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "contributor", index, value);
	}

	public static int getcreatedMinCount() {
		return 1;
	}

	public static int getcreatedMaxCount() {
		return 1;
	}

	public int getcreatedCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "created");
	}

	public boolean hascreated() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "created");
	}

	public SchemaDateTime newcreated() {
		return new SchemaDateTime();
	}

	public SchemaDateTime getcreatedAt(int index) throws Exception {
		return new SchemaDateTime(getDomNodeValue(dereference(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "created", index))));
	}

	public org.w3c.dom.Node getStartingcreatedCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "created" );
	}

	public org.w3c.dom.Node getAdvancedcreatedCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "created", curNode );
	}

	public SchemaDateTime getcreatedValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.model.collada.xml.XmlException("Out of range");
		else
			return new SchemaDateTime(getDomNodeValue( dereference(curNode) ) );
	}

	public SchemaDateTime getcreated() throws Exception 
 {
		return getcreatedAt(0);
	}

	public void removecreatedAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "created", index);
	}

	public void removecreated() {
		while (hascreated())
			removecreatedAt(0);
	}

	public void addcreated(SchemaDateTime value) {
		if( value.isNull() == false )
		{
			appendDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "created", value.toString());
		}
	}

	public void addcreated(String value) throws Exception {
		addcreated(new SchemaDateTime(value));
	}

	public void insertcreatedAt(SchemaDateTime value, int index) {
		insertDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "created", index, value.toString());
	}

	public void insertcreatedAt(String value, int index) throws Exception {
		insertcreatedAt(new SchemaDateTime(value), index);
	}

	public void replacecreatedAt(SchemaDateTime value, int index) {
		replaceDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "created", index, value.toString());
	}

	public void replacecreatedAt(String value, int index) throws Exception {
		replacecreatedAt(new SchemaDateTime(value), index);
	}

	public static int getkeywordsMinCount() {
		return 0;
	}

	public static int getkeywordsMaxCount() {
		return 1;
	}

	public int getkeywordsCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "keywords");
	}

	public boolean haskeywords() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "keywords");
	}

	public SchemaString newkeywords() {
		return new SchemaString();
	}

	public SchemaString getkeywordsAt(int index) throws Exception {
		return new SchemaString(getDomNodeValue(dereference(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "keywords", index))));
	}

	public org.w3c.dom.Node getStartingkeywordsCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "keywords" );
	}

	public org.w3c.dom.Node getAdvancedkeywordsCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "keywords", curNode );
	}

	public SchemaString getkeywordsValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.model.collada.xml.XmlException("Out of range");
		else
			return new SchemaString(getDomNodeValue( dereference(curNode) ) );
	}

	public SchemaString getkeywords() throws Exception 
 {
		return getkeywordsAt(0);
	}

	public void removekeywordsAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "keywords", index);
	}

	public void removekeywords() {
		while (haskeywords())
			removekeywordsAt(0);
	}

	public void addkeywords(SchemaString value) {
		if( value.isNull() == false )
		{
			appendDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "keywords", value.toString());
		}
	}

	public void addkeywords(String value) throws Exception {
		addkeywords(new SchemaString(value));
	}

	public void insertkeywordsAt(SchemaString value, int index) {
		insertDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "keywords", index, value.toString());
	}

	public void insertkeywordsAt(String value, int index) throws Exception {
		insertkeywordsAt(new SchemaString(value), index);
	}

	public void replacekeywordsAt(SchemaString value, int index) {
		replaceDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "keywords", index, value.toString());
	}

	public void replacekeywordsAt(String value, int index) throws Exception {
		replacekeywordsAt(new SchemaString(value), index);
	}

	public static int getmodifiedMinCount() {
		return 1;
	}

	public static int getmodifiedMaxCount() {
		return 1;
	}

	public int getmodifiedCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "modified");
	}

	public boolean hasmodified() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "modified");
	}

	public SchemaDateTime newmodified() {
		return new SchemaDateTime();
	}

	public SchemaDateTime getmodifiedAt(int index) throws Exception {
		return new SchemaDateTime(getDomNodeValue(dereference(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "modified", index))));
	}

	public org.w3c.dom.Node getStartingmodifiedCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "modified" );
	}

	public org.w3c.dom.Node getAdvancedmodifiedCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "modified", curNode );
	}

	public SchemaDateTime getmodifiedValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.model.collada.xml.XmlException("Out of range");
		else
			return new SchemaDateTime(getDomNodeValue( dereference(curNode) ) );
	}

	public SchemaDateTime getmodified() throws Exception 
 {
		return getmodifiedAt(0);
	}

	public void removemodifiedAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "modified", index);
	}

	public void removemodified() {
		while (hasmodified())
			removemodifiedAt(0);
	}

	public void addmodified(SchemaDateTime value) {
		if( value.isNull() == false )
		{
			appendDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "modified", value.toString());
		}
	}

	public void addmodified(String value) throws Exception {
		addmodified(new SchemaDateTime(value));
	}

	public void insertmodifiedAt(SchemaDateTime value, int index) {
		insertDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "modified", index, value.toString());
	}

	public void insertmodifiedAt(String value, int index) throws Exception {
		insertmodifiedAt(new SchemaDateTime(value), index);
	}

	public void replacemodifiedAt(SchemaDateTime value, int index) {
		replaceDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "modified", index, value.toString());
	}

	public void replacemodifiedAt(String value, int index) throws Exception {
		replacemodifiedAt(new SchemaDateTime(value), index);
	}

	public static int getrevisionMinCount() {
		return 0;
	}

	public static int getrevisionMaxCount() {
		return 1;
	}

	public int getrevisionCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "revision");
	}

	public boolean hasrevision() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "revision");
	}

	public SchemaString newrevision() {
		return new SchemaString();
	}

	public SchemaString getrevisionAt(int index) throws Exception {
		return new SchemaString(getDomNodeValue(dereference(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "revision", index))));
	}

	public org.w3c.dom.Node getStartingrevisionCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "revision" );
	}

	public org.w3c.dom.Node getAdvancedrevisionCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "revision", curNode );
	}

	public SchemaString getrevisionValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.model.collada.xml.XmlException("Out of range");
		else
			return new SchemaString(getDomNodeValue( dereference(curNode) ) );
	}

	public SchemaString getrevision() throws Exception 
 {
		return getrevisionAt(0);
	}

	public void removerevisionAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "revision", index);
	}

	public void removerevision() {
		while (hasrevision())
			removerevisionAt(0);
	}

	public void addrevision(SchemaString value) {
		if( value.isNull() == false )
		{
			appendDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "revision", value.toString());
		}
	}

	public void addrevision(String value) throws Exception {
		addrevision(new SchemaString(value));
	}

	public void insertrevisionAt(SchemaString value, int index) {
		insertDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "revision", index, value.toString());
	}

	public void insertrevisionAt(String value, int index) throws Exception {
		insertrevisionAt(new SchemaString(value), index);
	}

	public void replacerevisionAt(SchemaString value, int index) {
		replaceDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "revision", index, value.toString());
	}

	public void replacerevisionAt(String value, int index) throws Exception {
		replacerevisionAt(new SchemaString(value), index);
	}

	public static int getsubjectMinCount() {
		return 0;
	}

	public static int getsubjectMaxCount() {
		return 1;
	}

	public int getsubjectCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "subject");
	}

	public boolean hassubject() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "subject");
	}

	public SchemaString newsubject() {
		return new SchemaString();
	}

	public SchemaString getsubjectAt(int index) throws Exception {
		return new SchemaString(getDomNodeValue(dereference(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "subject", index))));
	}

	public org.w3c.dom.Node getStartingsubjectCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "subject" );
	}

	public org.w3c.dom.Node getAdvancedsubjectCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "subject", curNode );
	}

	public SchemaString getsubjectValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.model.collada.xml.XmlException("Out of range");
		else
			return new SchemaString(getDomNodeValue( dereference(curNode) ) );
	}

	public SchemaString getsubject() throws Exception 
 {
		return getsubjectAt(0);
	}

	public void removesubjectAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "subject", index);
	}

	public void removesubject() {
		while (hassubject())
			removesubjectAt(0);
	}

	public void addsubject(SchemaString value) {
		if( value.isNull() == false )
		{
			appendDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "subject", value.toString());
		}
	}

	public void addsubject(String value) throws Exception {
		addsubject(new SchemaString(value));
	}

	public void insertsubjectAt(SchemaString value, int index) {
		insertDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "subject", index, value.toString());
	}

	public void insertsubjectAt(String value, int index) throws Exception {
		insertsubjectAt(new SchemaString(value), index);
	}

	public void replacesubjectAt(SchemaString value, int index) {
		replaceDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "subject", index, value.toString());
	}

	public void replacesubjectAt(String value, int index) throws Exception {
		replacesubjectAt(new SchemaString(value), index);
	}

	public static int gettitleMinCount() {
		return 0;
	}

	public static int gettitleMaxCount() {
		return 1;
	}

	public int gettitleCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "title");
	}

	public boolean hastitle() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "title");
	}

	public SchemaString newtitle() {
		return new SchemaString();
	}

	public SchemaString gettitleAt(int index) throws Exception {
		return new SchemaString(getDomNodeValue(dereference(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "title", index))));
	}

	public org.w3c.dom.Node getStartingtitleCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "title" );
	}

	public org.w3c.dom.Node getAdvancedtitleCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "title", curNode );
	}

	public SchemaString gettitleValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.model.collada.xml.XmlException("Out of range");
		else
			return new SchemaString(getDomNodeValue( dereference(curNode) ) );
	}

	public SchemaString gettitle() throws Exception 
 {
		return gettitleAt(0);
	}

	public void removetitleAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "title", index);
	}

	public void removetitle() {
		while (hastitle())
			removetitleAt(0);
	}

	public void addtitle(SchemaString value) {
		if( value.isNull() == false )
		{
			appendDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "title", value.toString());
		}
	}

	public void addtitle(String value) throws Exception {
		addtitle(new SchemaString(value));
	}

	public void inserttitleAt(SchemaString value, int index) {
		insertDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "title", index, value.toString());
	}

	public void inserttitleAt(String value, int index) throws Exception {
		inserttitleAt(new SchemaString(value), index);
	}

	public void replacetitleAt(SchemaString value, int index) {
		replaceDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "title", index, value.toString());
	}

	public void replacetitleAt(String value, int index) throws Exception {
		replacetitleAt(new SchemaString(value), index);
	}

	public static int getunitMinCount() {
		return 0;
	}

	public static int getunitMaxCount() {
		return 1;
	}

	public int getunitCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "unit");
	}

	public boolean hasunit() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "unit");
	}

	public unitType newunit() {
		return new unitType(domNode.getOwnerDocument().createElementNS("http://www.collada.org/2005/11/COLLADASchema", "unit"));
	}

	public unitType getunitAt(int index) throws Exception {
		return new unitType(dereference(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "unit", index)));
	}

	public org.w3c.dom.Node getStartingunitCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "unit" );
	}

	public org.w3c.dom.Node getAdvancedunitCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "unit", curNode );
	}

	public unitType getunitValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.model.collada.xml.XmlException("Out of range");
		else
			return new unitType( dereference(curNode) );
	}

	public unitType getunit() throws Exception 
 {
		return getunitAt(0);
	}

	public void removeunitAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "unit", index);
	}

	public void removeunit() {
		while (hasunit())
			removeunitAt(0);
	}

	public void addunit(unitType value) {
		appendDomElement("http://www.collada.org/2005/11/COLLADASchema", "unit", value);	
	}

	public void insertunitAt(unitType value, int index) {
		insertDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "unit", index, value);
	}

	public void replaceunitAt(unitType value, int index) {
		replaceDomElementAt("http://www.collada.org/2005/11/COLLADASchema", "unit", index, value);
	}

	public static int getup_axisMinCount() {
		return 0;
	}

	public static int getup_axisMaxCount() {
		return 1;
	}

	public int getup_axisCount() {
		return getDomChildCount(Element, "http://www.collada.org/2005/11/COLLADASchema", "up_axis");
	}

	public boolean hasup_axis() {
		return hasDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "up_axis");
	}

	public UpAxisType newup_axis() {
		return new UpAxisType();
	}

	public UpAxisType getup_axisAt(int index) throws Exception {
		return new UpAxisType(getDomNodeValue(dereference(getDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "up_axis", index))));
	}

	public org.w3c.dom.Node getStartingup_axisCursor() throws Exception {
		return getDomFirstChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "up_axis" );
	}

	public org.w3c.dom.Node getAdvancedup_axisCursor( org.w3c.dom.Node curNode ) throws Exception {
		return getDomNextChild( Element, "http://www.collada.org/2005/11/COLLADASchema", "up_axis", curNode );
	}

	public UpAxisType getup_axisValueAtCursor( org.w3c.dom.Node curNode ) throws Exception {
		if( curNode == null )
			throw new com.jmex.model.collada.xml.XmlException("Out of range");
		else
			return new UpAxisType(getDomNodeValue( dereference(curNode) ) );
	}

	public UpAxisType getup_axis() throws Exception 
 {
		return getup_axisAt(0);
	}

	public void removeup_axisAt(int index) {
		removeDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "up_axis", index);
	}

	public void removeup_axis() {
		while (hasup_axis())
			removeup_axisAt(0);
	}

	public void addup_axis(UpAxisType value) {
		if( value.isNull() == false )
		{
			appendDomChild(Element, "http://www.collada.org/2005/11/COLLADASchema", "up_axis", value.toString());
		}
	}

	public void addup_axis(String value) throws Exception {
		addup_axis(new UpAxisType(value));
	}

	public void insertup_axisAt(UpAxisType value, int index) {
		insertDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "up_axis", index, value.toString());
	}

	public void insertup_axisAt(String value, int index) throws Exception {
		insertup_axisAt(new UpAxisType(value), index);
	}

	public void replaceup_axisAt(UpAxisType value, int index) {
		replaceDomChildAt(Element, "http://www.collada.org/2005/11/COLLADASchema", "up_axis", index, value.toString());
	}

	public void replaceup_axisAt(String value, int index) throws Exception {
		replaceup_axisAt(new UpAxisType(value), index);
	}

	private org.w3c.dom.Node dereference(org.w3c.dom.Node node) {
		return node;
	}
}