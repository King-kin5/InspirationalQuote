package com.quote.InspirationalQuote;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/v1")
public class QuoteController {
    private final QuoteService quoteService;
    private static final Logger logger = LoggerFactory.getLogger(QuoteController.class);
    @RequestMapping(method = RequestMethod.GET, value = "/Get")
    @ResponseBody
    public String getRandomQuote() {
        logger.info("Getting quote...");
        return quoteService.getRandomQuote();
    }
  
}
