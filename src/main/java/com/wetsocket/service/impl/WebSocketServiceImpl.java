package com.wetsocket.service.impl;

import com.wetsocket.common.Constants;
import com.wetsocket.response.Result;
import com.wetsocket.service.IWebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * Created by PC-007 on 2019/11/12.
 */
@Service
public class WebSocketServiceImpl implements IWebSocketService {

	@Autowired
	private SimpMessagingTemplate template;




	/**
	 * @Dasc: 推送大屏视频数据
	 */
	@Override
	@InitBinder
	public void pushBigVideo() {

		int i = 0;
		String message = "返回第%s条数据，请查收";
		while (true){
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(String.format(message, i));
			template.convertAndSend(Constants.PRODUCER_PATH, Result.data(String.format(message, i)));
			i ++;
		}
	}
}

