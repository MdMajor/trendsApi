package com.crashtech.trendspisrv.controller;

import com.crashtech.trendspisrv.repository.TrendsRepository;
import com.crashtech.trendspisrv.models.Trend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Validated
public class TrendsController {

    private final TrendsRepository trendsRepository;
    private final MessageSource messageSource;

    @Autowired
    public TrendsController(TrendsRepository trendsRepository, MessageSource messageSource) {
        this.trendsRepository = trendsRepository;
        this.messageSource = messageSource;
    }


    @GetMapping("/getTrends")
    public List<Trend> getTrends(){
        return trendsRepository.findAll();
    }

    @GetMapping(path = "/getTrends/{trendId}")
    public Optional<Trend> getTrendById(@PathVariable("trendId") String trendId){

        return trendsRepository.findById(trendId);
    }

    @PostMapping("/addTrend")
    public void addNewTrend(@RequestBody Trend trend){
        trendsRepository.save(trend);
    }

    @PostMapping("/addTrends")
    public void addNewTrend(@RequestBody List<Trend> trends){
        trendsRepository.saveAll(trends);
    }

    @DeleteMapping(path = "/{trendId}")
    public void deleteTrend(@PathVariable("trendId") String trendId ){
        boolean exist = trendsRepository.existsById(trendId);
        if(!exist){
            throw new IllegalStateException("Trend with id : " + trendId + "doesn't exist");
        }

        trendsRepository.deleteById(trendId);
    }

    @DeleteMapping("/delete")
    public void deleteMultipleTrends(@RequestBody List<String> trendsId){
        for (String trend:trendsId
             ) {
            trendsRepository.deleteById(trend);
        }
    }

    @PutMapping(path = "/{trendId}")
    public Trend updateTrend(@PathVariable("trendId") String trendId,@RequestBody Trend trend){
        trend.setId(trendId);
        trendsRepository.save(trend);
        return trend;
    }

    @GetMapping("/greet")
    public String sayHello(){
       return messageSource.getMessage("common.hello",null, LocaleContextHolder.getLocale());
    }

    @GetMapping("/greetings")
    public String sayHelloWithHeader(@RequestHeader(name="Accept-Language",required = false) @RequestParam(required = false) String lang, Locale locale){
        return messageSource.getMessage("common.hello",null, Locale.of(lang));
    }
}
