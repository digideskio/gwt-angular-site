package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.$;

public interface Wrapper<T extends $> {
	$ get$();
	void set$(T delegate);
}