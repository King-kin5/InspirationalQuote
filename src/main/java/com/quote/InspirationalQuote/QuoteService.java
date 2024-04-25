package com.quote.InspirationalQuote;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class QuoteService {
    private final QuoteRepository quoteRepository;

   // @Transactional
    //public void scrapeAndSaveQuotes() {
      //  List<Quote> quotes = new ArrayList<>();

      //  try {
        //    int timeoutMillis = 20000;

          //  for (int i = 1; i <= 5; i++) {
            //    String url = "https://www.goodreads.com/quotes?page=" + i;
             //   Document doc = Jsoup.connect(url).timeout(timeoutMillis).get();
              //  Elements quoteElements = doc.select(".quoteText");

              //  for (Element element : quoteElements) {
                    //String quoteText = element.text();
                    //Quote quote = new Quote();
                   // quote.setText(quoteText);
                   // quotes.add(quote);
                //}
         //   }

           // quoteRepository.saveAll(quotes);
            //System.out.println("Quotes scraped and saved successfully.");
       // } catch (IOException e) {
          //  e.printStackTrace();
        //    System.err.println("Error while scraping quotes: " + e.getMessage());
       // }

//}



    public String getRandomQuote() {
        List<Quote> allQuotes = quoteRepository.findAll();
        if (allQuotes.isEmpty()) {
            return "No quotes available";
        }
        Random random = new Random();
        int randomIndex = random.nextInt(allQuotes.size());
        Quote randomQuote = allQuotes.get(randomIndex);
        return randomQuote.getText();
    }
}
