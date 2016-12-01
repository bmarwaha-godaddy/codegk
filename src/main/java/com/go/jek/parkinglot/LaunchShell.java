/**
 * 
 */
package com.go.jek.parkinglot;

import java.io.IOException;

/**
 * @author marwb
 *
 */
public class LaunchShell {

	/**
	 * 
	 */
	public LaunchShell() {
		// TODO Auto-generated constructor stub
	}

	
	public static String launchShell(String cmd) throws IOException{
		
		
		Process proc = Runtime.getRuntime().exec(cmd);
        java.io.InputStream is = proc.getInputStream();
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        String val = "";
        if (s.hasNext()) {
            val = s.next();
        }
        else {
            val = "";
        }
        return val;
		
	}
}
