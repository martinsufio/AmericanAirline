package com.example.americanairline;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;

@ParseClassName("Products")
public class Products extends ParseObject {
    public static final  String KEY_TITLE = "Name";
    public static final  String KEY_PRICE = "Price";
    public static final  String KEY_IMAGE = "Picture";
    public static final  String KEY_PRICE2 = "AAPrice";

    public String getTitle(){
        return getString(KEY_TITLE);
    }
    public String getDescription(){
        return getString(KEY_PRICE);
    }
    public String getAAPrice(){
        return getString(KEY_PRICE2);
    }
    public ParseFile getImage(){
        return getParseFile(KEY_IMAGE);
    }
}
