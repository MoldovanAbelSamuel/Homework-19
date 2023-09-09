package fasttrackit.org.Tema19.Controller;

import fasttrackit.org.Tema19.Domain.Country;
import fasttrackit.org.Tema19.Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {
    private CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("countries")
    public List<Country> getCountries(){
        return this.countryService.getCountries();
    }

    @GetMapping("countries/names")
    public List<String> getAllCountriesNames(){
        return this.countryService.getAllCountriesNames();
    }

    @GetMapping("countries/{countryId}/capital")
    public String getCapitalOfCountry(@PathVariable("countryId") int countryId){
        return this.countryService.getCapitalOfCountry(countryId);
    }

    @GetMapping("countries/{countryId}/population")
    public long getPopulation(@PathVariable("countryId") int countryId){
        return this.countryService.getPopulation(countryId);
    }
//
//    @GetMapping("continents/{continentName}/countries")
//    public List<Country> getCountriesInContinent(@PathVariable("continentName") String continentName){
//        return this.countryService.getCountriesInContinent(continentName);
//    }

    @GetMapping("countries/{countryId}/neighbours")
    public List<String> getNeighbours(@PathVariable("countryId") int countryId){
        return this.countryService.getNeighbours(countryId);
    }

    @GetMapping("continents/{continentName}/countries")
    public List<Country> getPopulationLargerThan(@PathVariable("continentName") String continentName,
                                                 @RequestParam(name = "minPopulation", required = false, defaultValue = "0")
                                                 long minPopulation){
        return this.countryService.getPopulationLargerThan(continentName, minPopulation);
    }
}

