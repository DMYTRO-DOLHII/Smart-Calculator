package com.github.ddolgiy.expressionhandler.storage;

import java.util.ArrayList;

abstract public class Storage<Content> {

    private final ArrayList<Content> storage;

    public Storage(){
        storage = new ArrayList<>();
    }

    public void add(Content content){
        storage.add(content);
    }

    public Content remove(int i){
        return storage.remove(i);
    }

    public Content get(int i){
        return storage.get(i);
    }

    public int size(){
        return storage.size();
    }

    public ArrayList<Content> getStorage(){
        return storage;
    }
}
