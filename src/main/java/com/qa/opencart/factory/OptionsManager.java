package com.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {

	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	private EdgeOptions eo;

	public OptionsManager(Properties prop) {
		this.prop = prop;
	}

	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();
//		co.addArguments("--remote-allow-origins=*");

		if (Boolean.parseBoolean(prop.getProperty("remote"))) {
			co.setBrowserVersion(prop.getProperty("browserversion"));
			co.setCapability("browsername", "chrome");
			co.setCapability("enableVNC", true);
			co.setCapability("name", prop.getProperty("testcasename"));
		}

		if (Boolean.parseBoolean(prop.getProperty("headless").trim())) {
			System.out.println("=========Running chrome in headless==========");
			co.addArguments("--headless");

		}
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim()))
			co.addArguments("--incognito");
		return co;
	}

	public FirefoxOptions getFirefoxOptions() {
		System.out.println("firefox options");
		fo = new FirefoxOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless").trim()))
			fo.addArguments("--headless");
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim()))
			fo.addArguments("--incognito");
		return fo;
	}

	public EdgeOptions getEdgeOptions() {
		eo = new EdgeOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless").trim()))
			eo.addArguments("--headless");
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim()))
			eo.addArguments("--incognito");
		return eo;
	}

}
