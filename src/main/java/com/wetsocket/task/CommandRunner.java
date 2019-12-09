package com.wetsocket.task;

import com.wetsocket.excel.ExcelUtils;
import com.wetsocket.service.IWebSocketService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;

/**
 * Created by PC-007 on 2019/11/12.
 */
@Component
@Log4j2
@Order(10)
public class CommandRunner implements CommandLineRunner {

	@Autowired
	private IWebSocketService webSocketService;


	/**
	 * Callback used to run the bean.
	 *
	 * @param args incoming application arguments
	 * @throws Exception on error
	 */
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		log.info("启动主动推送大屏视频任务");
//		webSocketService.pushBigVideo();
//	}

	/**
	 * Callback used to run the bean.
	 *
	 * @param args incoming main method arguments
	 * @throws Exception on error
	 */
	@Override
	public void run(String... args) throws Exception {
		log.info("启动主动推送大屏视频任务");

		webSocketService.pushBigVideo();
	}
}
