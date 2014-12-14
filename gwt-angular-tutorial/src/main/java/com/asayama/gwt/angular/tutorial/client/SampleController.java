package com.asayama.gwt.angular.tutorial.client;

import com.asayama.gwt.angular.client.AbstractController;
import com.asayama.gwt.jsni.client.JSArray;
import com.asayama.gwt.jsni.client.JSON;
import com.google.gwt.user.client.Event;


public class SampleController extends AbstractController {

    private JSArray<Entry> entries = JSArray.create();
    private String quickEntryCaption = "";
    
    @Override
    public void onControllerLoad() {
    }
    
    public void onChangeQuickEntry(String quickEntryCaption) {
        setQuickEntryCaption(quickEntryCaption);
    }
    
    public String onKeyPressQuickEntry(Event event) {
        int keyCode = event.getKeyCode();
        if (keyCode == 13) {
            getEntries().add(Entry.create(quickEntryCaption));
            setQuickEntryCaption("");
        }
        return getQuickEntryCaption();
    }
    
    public void onClickClear() {
        entries.clear();
        setQuickEntryCaption("");
    }
    
    public JSArray<Entry> getEntries() {
        return entries;
    }
    
    public void setEntries(JSArray<Entry> entries) {
        this.entries = entries;
    }
    
    public String getQuickEntryCaption() {
        return quickEntryCaption;
    }
    
    public void setQuickEntryCaption(String quickEntryCaption) {
        this.quickEntryCaption = quickEntryCaption;
    }
}

class Entry extends JSON {

    public static Entry create(String caption) {
        Entry entry = JSON.create();
        entry.setCaption(caption);
        return entry;
    }
    
    protected Entry() {
    }
    
    public final void setCaption(String caption) {
        put("caption", caption);
    }
}