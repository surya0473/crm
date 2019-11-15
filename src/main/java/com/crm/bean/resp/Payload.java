package com.crm.bean.resp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class Payload {
	public ResponseEntity<ClientRespBean> buildRetunResp(ClientRespBean resp) {
		ResponseEntity<ClientRespBean> respEntity = new ResponseEntity<ClientRespBean>(resp, HttpStatus.OK);
		return respEntity;
	}
}
