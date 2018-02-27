/**
 * Copyright (c) 2018 MetaMagic Global Inc, NJ, USA

 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.

 * This program and the accompanying materials are dual-licensed under
 * either the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation
 
 *   or (per the licensee's choosing)
 
 * under the terms of the Apache 2 License version 2.0
 * as published by the Apache Software Foundation.
*/
package org.amexio.colors.themes;

import org.amexio.colors.core.Color;

/**
 * Amexio Theme Builder
 * 
 * Builds an Amexio Theme based on Multiple Color Choices
 * 
 * Following the Are the Color Choice available
 * 
 * Build Themes on 
 * 1. ColorDuo (Two Colors)
 * 2. ColorTriadic (Three Colors)
 * 3. 
 * 
 * 
 * @author Araf Karsh Hamid
 * @version 1.0
 * @date February 25, 2018
 */
public final class AmexioThemeBuilder {

	public static final String NL = System.getProperty("line.separator");
	
	private AmexioThemeColors themeColor;
	private AmexioAppColors appColor;
	private AmexioComponentColors compColor;
	
	/**
	 * Default Theme Builder with the Following Colors
	 * Maroon, FireBrick, WhiteSmoke and Snow.
	 */
	
	public AmexioThemeBuilder() {
		this(null, null, null, null, null, null, null);	
	}

	/**
	 * Theme with a Single Color Pallette
	 * 
	 * @param Color _color1
	 */
	public AmexioThemeBuilder(Color _color1) {
		this(_color1, null, null, null, null, null, null);
	}
	
	/**
	 * Theme with Two Color Pallette 
	 * 
	 * @param Color _color1
	 * @param Color _color2
	 */
	public AmexioThemeBuilder(Color _color1, Color _color2) {
		this(_color1, _color2, null, null, null, null, null);
	}
	
	/**
	 * Theme with Three Color Pallette
	 * 
	 * @param Color _color1
	 * @param Color _color2
	 * @param Color _color3
	 */
	public AmexioThemeBuilder(Color _color1, Color _color2, Color _color3) {
		this(_color1, _color2, _color3, null, null, null, null);
	}
	
	/**
	 * 
	 * @param _color1
	 * @param _color2
	 * @param _color3
	 * @param _color4
	 * @param _color5
	 * @param _color6
	 * @param _fontFamily
	 */
	public AmexioThemeBuilder(Color _color1, Color _color2, Color _color3, 
			Color _color4, Color _color5, Color _color6, String _fontFamily) {
		
		themeColor 	= new AmexioThemeColors(_color1, _color2, _color3, 
				_color4, _color5, _color6, _fontFamily);
		appColor 	= new AmexioAppColors(themeColor.theme5thColor, 
										themeColor.theme1stColor);
		compColor	= new AmexioComponentColors(themeColor.theme6thColor,
										themeColor.theme2ndColor);
		
	}
			
	/**
	 * Create the entire CSS Theme File
	 * @return
	 */
	public String printSCSS() {
		StringBuilder sb = new StringBuilder();
		sb.append(AmexioLicense.copyright);
		// sb.append("$isAmexio: false;").append(NL);
		sb.append("$appTransparency : rgba(0,0,0,0.87);").append(NL);
		sb.append(themeColor.printSCSS());
		sb.append(appColor.printSCSS());
		sb.append(compColor.printSCSS());
		return sb.toString();
	}
	
	
	public static void main(String[] args) {

	}

}
