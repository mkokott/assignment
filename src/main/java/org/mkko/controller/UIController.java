package org.mkko.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * controller that serves static content of the web UI
 * 
 * @author mkokott
 * 
 */
@Controller
public class UIController {

	private static final Logger logger = LogManager.getLogger(UIController.class);

	/**
	 * @return the index.html
	 */
	@RequestMapping("/")
	public String index() {

		logger.info("index.html requested");
		return "index";
	}
}
