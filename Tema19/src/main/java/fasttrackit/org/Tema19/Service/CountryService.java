package fasttrackit.org.Tema19.Service;

import fasttrackit.org.Tema19.Domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {
    private List<Country> countries;

    @Autowired
    public CountryService() throws FileNotFoundException {
        CountryReader countryReader = new CountryReader();
        this.countries = countryReader.readFileFromTXT("C:\\Users\\loren\\IdeaProjects\\Spring projects\\Tema19\\Tema19\\src\\main\\java\\fasttrackit\\org\\Tema19\\countries2.txt");
    }


    public List<Country> getCountries(){
        return this.countries;
    }

    public List<String> getAllCountriesNames(){
        List<String> names = new ArrayList<>();
        for(Country currentCountry : this.countries){
            names.add(currentCountry.getName());
        }
        return names;
    }

    public String getCapitalOfCountry(int countryId) {
        return this.countries.get(countryId - 1).getCapital();
    }

    public long getPopulation(int countryId){
        return this.countries.get(countryId - 1).getPopulation();
    }

//    public List<Country> getCountriesInContinent(String continentName){
//        return this.countries.stream()
//                .filter(country -> continentName.equals(country.getContinent()))
//                .collect(Collectors.toList());
//    }

    public List<String> getNeighbours(int conuntryId){
        List <String> neighbours = List.of(this.countries.get(conuntryId - 1).getNeighbour().split("~"));
        return neighbours;
    }

    public List<Country> getPopulationLargerThan(String continentName, long minPopulation){
        List<Country> largerThan = new ArrayList<>();
        for (Country country : this.countries){
            if (country.getPopulation() > minPopulation && country.getContinent().equals(continentName)){
                largerThan.add(country);
            }
        }
        return largerThan;
    }
}
