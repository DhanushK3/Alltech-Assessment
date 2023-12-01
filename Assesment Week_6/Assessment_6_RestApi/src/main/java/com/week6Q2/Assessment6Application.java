package com.week6Q2;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class Assessment6Application {
//
//	public static void main(String[] args) {
//		SpringApplication.run(Assessment6Application.class, args);
//	}
//	
//	
//
//}

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.*;

public class Assessment6Application {

    static class Article {
        String articleName;
        int numComments;

        Article(String articleName, int numComments) {
            this.articleName = articleName;
            this.numComments = numComments;
        }
    }

    public static String[] topArticles(int limit) {
    	
    	//http request
        CloseableHttpClient httpClient = HttpClients.createDefault();
        List<Article> articles = new ArrayList<>();

        int currentPage = 1;
        int totalPages;

        try {
            do {
            	//http request to api
                HttpGet request = new HttpGet("https://jsonmock.hackerrank.com/api/articles?page=" + currentPage);
                CloseableHttpResponse response = httpClient.execute(request);

                //reading json response
                JsonNode jsonNode = new ObjectMapper()
                						.readTree(response.getEntity().getContent());

                //extracting total pages as int
                totalPages = jsonNode.get("total_pages").asInt();

                //adding artical to list
                for (JsonNode articleNode : jsonNode.get("data")) {
                	
                	//extract details from json
                    String title = articleNode.get("title").asText();
                    String storyTitle = articleNode.get("story_title").asText();
                    int numComments = articleNode.get("num_comments").asInt();

                    // determine article conditions
                    String articleName = (title != null) ? title : storyTitle;
                    
                    //add to list
                    articles.add(new Article(articleName, numComments));
                }

                //nextpage
                currentPage++;
                
            } while (currentPage <= totalPages);
            
        } catch (IOException e) {
            // print an error message
            e.printStackTrace();
        }

        //sorting
        articles.sort(Comparator.comparingInt((Article a) -> a.numComments).reversed());
               // .thenComparing((Article a) -> a.articleName));

        //extracting
        return articles.stream()
                .limit(limit)
                .map(article -> article.articleName)
                .toArray(String[]::new);
    }

    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the limit value: ");       
        int limit = scanner.nextInt();
        
        String[] topArticles = topArticles(limit);
        System.out.println(Arrays.toString(topArticles));
        
        scanner.close();
    }
}



