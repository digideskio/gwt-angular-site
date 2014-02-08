package com.asayama.demo.client;

import java.util.ArrayList;
import java.util.List;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.Scope;
import com.asayama.gwt.angular.client.http.Http;
import com.asayama.gwt.angular.client.http.HttpCallback;
import com.asayama.gwt.angular.client.location.HashParam;
import com.asayama.gwt.angular.client.location.Location;
import com.asayama.gwt.angular.client.q.Q;
import com.asayama.gwt.angular.route.client.RouteParams;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.i18n.client.Constants;
import com.google.gwt.user.client.Event;

public class MyController implements Controller {

	// Public final fields are directly bound to AngularJS's $scope
	public static final String GREETING = MyControllerConstants.INSTANCE.greeting();
	public static final String STRANGER = MyControllerConstants.INSTANCE.stranger();
	
	protected Scope scope;
	protected RouteParams routeParams;
	protected Location location;
	protected Q q;
	protected Http http;

	String clickable;
	String name;
	Customers customers;
	
	@Override
	public void onControllerLoad() {

		GWT.log("entering MyController.onControllerLoad");
		
		String name = routeParams.getString("name");
		setName(name);

		setClickable("Click me");

		String url = GWT.getModuleBaseForStaticFiles() + "api/customer";

		try {
			http.setQ(q);
			http.get(url, new HttpCallback() {
				@Override
				public void onSuccess(Request request, Response response) {
					Customers customers = Customers.parse(response.getText());
					setCustomers(customers);
				}
				@Override
				public void onError(Request request, Exception exception) {
					GWT.log("onError", exception);
				}
			});

		} catch (RequestException e) {
			GWT.log("Exception while calling " + url, e);
		}
		
	}

	// Public event handler are automatically wired to AngularJS's $scope.
	
	public void onClickClickable(Event event) {
		List<HashParam> params = new ArrayList<HashParam>();
		params.add(new HashParam("name", "You Clicked Me!"));
		location.setHashParam(params);
	}
	
	// Public getters and setters are automatically wired to AngularJS's $scope.
	
	public Customers getCustomers() {
		return customers;
	}
	public void setCustomers(Customers customers) {
		this.customers = customers;
	}
	public String getClickable() {
		return clickable;
	}
	public void setClickable(String clickable) {
		this.clickable = clickable;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
interface MyControllerConstants extends Constants {
	
	static final MyControllerConstants INSTANCE = GWT.create(MyControllerConstants.class);
	
	@DefaultStringValue("Hello")
	String greeting();
	
	@DefaultStringValue("Stranger")
	String stranger();
}