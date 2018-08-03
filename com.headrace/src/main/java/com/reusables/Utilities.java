package com.reusables;

import org.openqa.selenium.JavascriptExecutor;

import com.initiator.Browser;

public class Utilities extends Browser{
	
	public JavascriptExecutor js;
	
	public Utilities(){
		js = (JavascriptExecutor)driver;
	}
	
	
	public boolean waitForPageLoad() throws Exception{
		for(int i = 1; i < 50; i++){
			Thread.sleep(1000);
				if(js.executeScript("return document.readyState").equals("complete"))
					return true;
			}
		System.out.println(" ============= page is not loaded with all objects, please check the server response ======");
		return false;
		}
	}

