package com.asayama.gwt.angular.resources.client.directive;

import com.asayama.gwt.angular.client.AbstractDirective;
import com.asayama.gwt.angular.client.NGScope;
import com.asayama.gwt.angular.client.q.Promise;
import com.asayama.gwt.angular.client.q.Q;
import com.asayama.gwt.angular.client.q.SuccessCallback;
import com.asayama.gwt.jquery.client.Element;
import com.asayama.gwt.jsni.client.JSON;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.http.client.Response;
import com.google.gwt.safehtml.shared.SafeUri;


public class GwtHtmlResource extends AbstractDirective {
    
    private Q q;

    @Override
    public void link(final NGScope scope, final Element element, JSON attrs) {
        HtmlResource resource = scope.get(getName());
        if (resource != null) {
            SafeUri safeUri = resource.getSafeUri();
            String url = safeUri.asString();
            Promise promise = HttpUtils.get(q, url);
            promise.success(new SuccessCallback() {
                @Override
                public void success(Object... args) {
                    Response response = (Response) args[1];
                    String text = response.getText();
                    element.append(text);
                    element.find(">:first").addClass("ng-transclude");
                }
            });
            return;
        }
    }

    @Override
    public boolean getTransclude() {
        //TODO https://github.com/kyoken74/gwt-angular/issues/62
        return true;
    }
}