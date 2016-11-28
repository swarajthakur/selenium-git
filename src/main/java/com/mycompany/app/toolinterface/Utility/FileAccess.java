package com.mycompany.app.toolinterface.Utility;

public class FileAccess {
	public static void loadBrowser(String URL) {
		{
			String url = URL;
			String os = System.getProperty("os.name").toLowerCase();
			Runtime rt = Runtime.getRuntime();

			try {
				/* If the OS is windows */
				if (os.indexOf( "win" ) >= 0) {
					/* This method will not open URLs of the form "page.html#nameLink" */ 
					rt.exec( "rundll32 url.dll,FileProtocolHandler " + url);
					/* If the OS is a mac */
				} else if (os.indexOf( "mac" ) >= 0) {
					rt.exec( "open " + url);
					/* If the OS is unix based */
				} else if (os.indexOf( "nix") >=0 || os.indexOf( "nux") >=0) {
					/* Try a combination of browsers until one succeeds */
					String[] browsers = {"epiphany", 
							"firefox", 
							"mozilla", 
							"konqueror",
							"netscape",
							"opera",
							"links",
					"lynx"};
					/* Construct a command string which looks like "browser1 "url" || browser2 "url" || etc.." */
					StringBuffer cmd = new StringBuffer();
					for (int i=0; i<browsers.length; i++) {
						cmd.append( (i==0  ? "" : " || " ) + browsers[i] +" \"" + url + "\" ");
					}
					rt.exec(new String[] { "sh", "-c", cmd.toString() });
				} else {
					return;
				}
			} catch (Exception e){
				return;
			}
			return;	
		}
	}
}
