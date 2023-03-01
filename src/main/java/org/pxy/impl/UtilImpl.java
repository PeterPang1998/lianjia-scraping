package org.pxy.impl;


import org.jsoup.select.Elements;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.pxy.interf.Utils;
import org.pxy.pojo.Apartment;

import java.io.IOException;
import java.util.ArrayList;

import org.json.*;

public class UtilImpl implements Utils {

    public Elements getUrlContent(String url) throws IOException {
        Document document = Jsoup.connect(url).get();
        Elements elements = document.getElementsByClass("sellListContent").select("li[class=clear]")
                .select("div[class=info clear]").select("div[class=address]>div");

        return elements;
    }

    @Override
    public ArrayList<Apartment> phraseUrl(Elements elements) {
        ArrayList<String> collection=new ArrayList<>();
        for (Element element: elements){
            collection.add(element.text());
        }
        //System.out.println("tracker:total "+collection.size()/5);

        int counter=0;
        ArrayList<Apartment> apartmentArrayList= new ArrayList<>();
        Apartment newApartment = new Apartment();

        for (String str:collection){
//            System.out.println(str);
            if(counter==0){
                newApartment.setName(str);
            }
            if(counter==1){
                newApartment.setHouseInfo(str);
            }
            if(counter==2){
                newApartment.setFollowAndUpdateInfo(str);
            }
            if(counter==3){
                newApartment.setTags(str);
            }
            if(counter==4){
                newApartment.setPrice(str);
            }
            counter+=1;
            if(counter==5){
                apartmentArrayList.add(newApartment);
                System.out.println(newApartment);
                System.gc();
                newApartment = new Apartment();
                counter=0;
            }

        }

        return apartmentArrayList;
    }

    @Override
    public int pageCounter(String url) throws IOException {
        Document document = Jsoup.connect(url).get();

        Elements elements= document.getElementsByClass("page-box fr")
                .select("div[class=page-box house-lst-page-box]");
        String pageInfo=elements.attr("page-data");
        JSONObject totalPageJson= new JSONObject(pageInfo);
        int totalPage= Integer.valueOf((Integer) totalPageJson.get("totalPage"));
        return totalPage;
    }
}
