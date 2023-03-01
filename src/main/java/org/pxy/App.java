package org.pxy;

import org.jsoup.select.Elements;
import org.pxy.impl.UtilImpl;
import org.pxy.pojo.Apartment;

import java.io.IOException;
import java.util.ArrayList;


public class App
{
    public static Integer demo(UtilImpl utilMethod,String url) throws IOException {

        ArrayList<Apartment> tempCache= new ArrayList<>();
        Elements elements= utilMethod.getUrlContent(url);
        utilMethod.phraseUrl(elements).forEach((e)->
                tempCache.add(e));
        tempCache.forEach((apartment -> System.out.println(apartment)));

        return tempCache.size();
    }

    public static void main( String[] args ) throws IOException {

        UtilImpl utilMethod = new UtilImpl();
        int total=0;

        //url 在ershoufang/ 后面加一个 pg%d，默认页码为1
        //其他可以自由更换
        String urlInit=String.format("https://gz.ke.com/ershoufang/pg%dsq527962658616463/",1);

        int totalPage=utilMethod.pageCounter(urlInit);
        System.out.println(totalPage);
        int counter=1,result=0;
        while(counter<=totalPage){
            String url=String.format("https://gz.ke.com/ershoufang/pg%dsq527962658616463/",counter++);
            result= demo(utilMethod,url);
            total=total+result;
        }

        System.out.println("total house:"+total);
    }


}


