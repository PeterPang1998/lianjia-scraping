package org.pxy.interf;


import org.jsoup.select.Elements;
import org.pxy.pojo.Apartment;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public interface Utils {
    public Elements getUrlContent(String url) throws IOException;

    public ArrayList<Apartment> phraseUrl(Elements elements);

    public int pageCounter(String url) throws IOException;
}
