package com.example.awmahn.helperbot;

import java.io.Serializable;
import java.nio.channels.SeekableByteChannel;
import java.util.UUID;
import java.util.jar.Attributes;
import java.io.Serializable;

/**
 * Created by Robert on 2/9/2017.
 */

public class questions implements Serializable {
    private UUID mId;
    private String searchType;
    private String name;
    private String traditionalSearch;
    private String exactlySearch;
    private String orSearch;
    private String notSearch;
    private boolean doMinNumberSearch;
    private boolean doMaxNumberSearch;
    private double minNumberSearch;
    private double maxNumberSearch;
    private String languadge;
    private String country;
    private String lastUpdated;
    private String domain;
    private String searchTermLocation;
    private String safeSearch;
    private String fileType;
    private String usageRights;

    public questions() {
        mId = UUID.randomUUID();
        searchType = "";
        name = "";
        traditionalSearch = "";
        exactlySearch = "";
        orSearch = "";
        notSearch = "";
        doMinNumberSearch = false;
        doMaxNumberSearch = false;
        minNumberSearch = 0;
        maxNumberSearch = 0;
        languadge = "";
        country = "";
        lastUpdated = "all";
        domain = "";
        searchTermLocation = "any";
        safeSearch = "images";
        fileType = "";
        usageRights = "";

    }

    public void setTraditionalSearch(String search) {

        traditionalSearch = search;
    }

    public String getTraditionalSearch() {
        return traditionalSearch;
    }


    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return mId;
    }

    public void setSearchType(String searchtype) {
        searchType = searchtype;
    }

    public String getSearchType() {
        return searchType;
    }

    public String generateSearchURL() {
        String URL = "https://www.google.com/search?";
        URL = URL + "as_q=" + traditionalSearch.replace(' ', '+');
        URL = URL + "&as_epq=" + exactlySearch.replace(' ', '+');
        URL = URL + "&as_oq=" + orSearch.replace(' ', '+');
        URL = URL + "&as_eq=" + notSearch.replace(' ', '+');
        if (doMinNumberSearch) {
            URL = URL + "&as_nlo=" + Double.toString(minNumberSearch);
        }
        if (doMaxNumberSearch) {
            URL = URL + "&as_nhi=" + Double.toString(maxNumberSearch);
        }
        URL = URL + "&lr=" + languadge;
        URL = URL + "&cr=" + country;
        URL = URL + "&as_qdr=" + lastUpdated;
        URL = URL + "&as_sitesearch=" + domain;
        URL = URL + "&as_occt=" + searchTermLocation;
        URL = URL + "&safe=" + safeSearch;
        URL = URL + "&as_filetype" + fileType;
        URL = URL + "&as_rights=" + usageRights;
        return URL;
    }



}
