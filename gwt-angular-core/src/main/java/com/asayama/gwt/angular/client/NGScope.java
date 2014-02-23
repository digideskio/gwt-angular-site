package com.asayama.gwt.angular.client;

import com.asayama.gwt.angular.client.annotations.Bind;

@Bind("$scope")
public class NGScope extends NGObject {

    protected NGScope() {
    }

    public final native void digest() /*-{
        if(!this.$$phase) {
          this.$digest();
        }
   }-*/;

}
