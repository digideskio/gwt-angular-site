package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.angular.client.Wrapper;
import com.asayama.gwt.core.client.$;
import com.asayama.gwt.core.client.Closure;
import com.asayama.gwt.core.client.Invoker;
import com.google.gwt.core.shared.GWT;

public class Promise<T extends $> implements Wrapper<PromiseJSO> {

	public Promise<T> then(final PromiseCallback<T> callback) {
		delegate.then(new Invoker(new Closure<T>() {
			@Override
			public void closure(T jso) {
				GWT.log("Promise.then: onSuccess: " + (jso == null ? null : jso.getClass().getName()));
				callback.onSuccess(jso);
			}
		}), new Invoker(new Closure<T>() {
			@Override
			public void closure(T jso) {
				GWT.log("Promise.then: onError: " + (jso == null ? null : jso.getClass().getName()));
				callback.onError(jso);
			}
		}), new Invoker(new Closure<T>() {
			@Override
			public void closure(T jso) {
				GWT.log("Promise.then: onSignal: " + (jso == null ? null : jso.getClass().getName()));
				callback.onSignal(jso);
			}
		}));
		return this;
	}
	
	public Promise<T> success(SuccessCallback<T> callback) {
		then(callback);
		return this;
	}
	
	public Promise<T> error(ErrorCallback<T> callback) {
		then(callback);
		return this;
	}
	
	// Wrapper Interfaces
	
	PromiseJSO delegate = null;
	
	@Override
	public PromiseJSO getDelegate() {
		return this.delegate;
	}

	@Override
	public void setDelegate($ delegate) {
		this.delegate = delegate.cast();
	}

}
class PromiseJSO extends $ {

	protected PromiseJSO() {
	}

	final native void then(Invoker successCallback, Invoker errorCallback, Invoker signalCallback) /*-{
		this.then(
			function (jso) {
				successCallback.@com.asayama.gwt.core.client.Invoker::invoke(Lcom/asayama/gwt/core/client/$;)(jso);
			}, function (jso) {
				errorCallback.@com.asayama.gwt.core.client.Invoker::invoke(Lcom/asayama/gwt/core/client/$;)(jso);
			}, function (jso) {
				signalCallback.@com.asayama.gwt.core.client.Invoker::invoke(Lcom/asayama/gwt/core/client/$;)(jso);
			});
	}-*/;
	
}