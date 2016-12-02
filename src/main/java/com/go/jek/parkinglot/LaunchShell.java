/**
 * 
 */
package com.go.jek.parkinglot;

import java.io.Console;
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
	
	public static String launchShell() throws IOException{
		
		
		Console c=System.console();
		if (c == null) {
            System.err.println("No console.");
            System.exit(1);
        }
		String line=c.readLine();
		System.out.println(line);
		
		/*Process proc = Runtime.getRuntime().exec(cmd);
        java.io.InputStream is = proc.getInputStream();
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        String val = "";
        if (s.hasNext()) {
            val = s.next();
        }
        else {
            val = "";
        }*/
        return null;
		
	}
}
