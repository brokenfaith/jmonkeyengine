/**
 * fx_surface_type_enum.java
 *
 * This file was generated by XMLSpy 2007sp2 Enterprise Edition.
 *
 * YOU SHOULD NOT MODIFY THIS FILE, BECAUSE IT WILL BE
 * OVERWRITTEN WHEN YOU RE-RUN CODE GENERATION.
 *
 * Refer to the XMLSpy Documentation for further details.
 * http://www.altova.com/xmlspy
 */


package com.jmex.model.collada.schema;

import com.jmex.xml.types.SchemaString;

public class fx_surface_type_enum extends SchemaString {
	public static final int EUNTYPED = 0; /* UNTYPED */
	public static final int E1D = 1; /* 1D */
	public static final int E2D = 2; /* 2D */
	public static final int E3D = 3; /* 3D */
	public static final int ERECT = 4; /* RECT */
	public static final int ECUBE = 5; /* CUBE */
	public static final int EDEPTH = 6; /* DEPTH */

	public static String[] sEnumValues = {
		"UNTYPED",
		"1D",
		"2D",
		"3D",
		"RECT",
		"CUBE",
		"DEPTH",
	};

	public fx_surface_type_enum() {
		super();
	}

	public fx_surface_type_enum(String newValue) {
		super(newValue);
		validate();
	}

	public fx_surface_type_enum(SchemaString newValue) {
		super(newValue);
		validate();
	}

	public static int getEnumerationCount() {
		return sEnumValues.length;
	}

	public static String getEnumerationValue(int index) {
		return sEnumValues[index];
	}

	public static boolean isValidEnumerationValue(String val) {
		for (int i = 0; i < sEnumValues.length; i++) {
			if (val.equals(sEnumValues[i]))
				return true;
		}
		return false;
	}

	public void validate() {

		if (!isValidEnumerationValue(toString()))
			throw new com.jmex.xml.xml.XmlException("Value of fx_surface_type_enum is invalid.");
	}
}
