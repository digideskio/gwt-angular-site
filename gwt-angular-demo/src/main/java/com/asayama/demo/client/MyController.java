package com.asayama.demo.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.http.Http;
import com.asayama.gwt.angular.client.http.HttpCallback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.i18n.client.Constants;

public class MyController implements Controller {

	// The service objects are injected at runtime. The fields must be declared "protected".
	protected Http http; 
	
	// Other attributes of the controller can be used as reference to view model.
	String title;
	
	@Override
	public void onControllerLoad() {
		setTitle(MyControllerConstants.INSTANCE.title());
//		http.get("/data/hello.txt", new HttpCallback<JsArray<Customer>>() {
		http.get("/data/customer.json", new HttpCallback<JsArray<Customer>>() {
			@Override
			public void onSuccess(int status, JsArray<Customer> data) {
				setTitle("onSuccess: status=" + status);
			}
			@Override
			public void onError(int status, JsArray<Customer> data) {
				setTitle("onError: status=" + status);
			}
		});
	}

	// Public methods are bound to AngularJS's $scope automatically.
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
interface MyControllerConstants extends Constants {
	
	static final MyControllerConstants INSTANCE = GWT.create(MyControllerConstants.class);
	
	@DefaultStringValue("Hello, World!")
	String title();
}