package com.jenkov.crawler.st.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.jenkov.crawler.util.SameWebsiteOnlyFilter;

/**
 * This class is an example of how to use the Crawler class. You should
 * not expect to use this class as it is. Use the Crawler class directly
 * from your own code.
 */
public class CrawlerMain {

    public static void main(String[] args) throws IOException {

        //String url ="http://tutorials.jenkov.com";
        //String url ="http://martinfowler.com";
        //String url ="http://www.vogella.com";
        System.out.println("Enter the URL: (e.g. https://)");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String url = br.readLine();

        Crawler crawler  = new Crawler();
        crawler.setUrlFilter(new SameWebsiteOnlyFilter(url));
        crawler.setPageProcessor(null); // set an IPageProcessor instance here.
        crawler.addUrl(url);

        crawler.crawl();
    }
}
