package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.jsni.client.JSObject;



public class Deferred<T> extends JSObject {

    protected Deferred() {
    }

    public final native Promise<T> promise() /*-{
        return this.promise;
    }-*/;
    
    public final native void notify(T value) /*-{
        this.notify(value);
    }-*/;
    
    public final native void resolve(T value) /*-{
        this.resolve(value);
    }-*/;
    
    public final native void reject(T value) /*-{
        this.reject(value);
    }-*/;
}