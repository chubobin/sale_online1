package com.chubobin.trade.util;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

public class MyClientCallback implements CallbackHandler{

	@Override
	public void handle(Callback[] arg0) throws IOException, UnsupportedCallbackException {
		WSPasswordCallback wspcb=(WSPasswordCallback) arg0[0];
		
		wspcb.setIdentifier("cxf");
		
		wspcb.setPassword(PasswordUtil.get_password("wss4j", "cxf"));
	}
	
	
}
