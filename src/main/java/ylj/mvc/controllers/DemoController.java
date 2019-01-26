package ylj.mvc.controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.TreeMap;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller("DemoController")
public class DemoController {

	static Logger logger = LoggerFactory.getLogger(DemoController.class);

	TimeZone zone = null;
	SimpleDateFormat ISO_time_format = null;

	public DemoController() throws Exception {

		logger.info("DemoController created .");

		zone = TimeZone.getTimeZone("GMT+8"); // 时区
		//
		ISO_time_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
		ISO_time_format.setTimeZone(zone);

	}

	@SuppressWarnings("restriction")
	@PostConstruct
	public void init() {
		logger.info("DemoController init ...");

		// DOMConfigurator.configure(HouseController.class.getResource("/conf/log4j.xml"));

	}

	@SuppressWarnings("restriction")
	@PreDestroy
	void destroy() {
		logger.info("DemoController destroy ...");
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public void handleRequest(@RequestParam(value = "query", required = false) String query, HttpServletResponse response) {
		// 0model.addAttribute("propertyId",propertyId);
		// model.addAttribute("date", date);

		logger.info("      query:" + query);
		try {
			ServletOutputStream sos = response.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(sos, "utf-8");
			osw.append(" query:" + query + "\n");
			osw.append(" time:" + ISO_time_format.format(System.currentTimeMillis()) + "\n");
			osw.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return;
	}

}
