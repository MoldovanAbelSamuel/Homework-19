package fasttrackit.org.Tema19.Service;

import fasttrackit.org.Tema19.Domain.Country;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class CountryReader {

    public CountryReader() {
    }

    public List<Country> readFileFromTXT(String filePath) throws FileNotFoundException {
        List<Country> textFromFile = new ArrayList<>();
        File countries = new File(filePath);
        Scanner scanner = new Scanner(countries);
        int contor = 1;
        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine();
            String[] values = currentLine.split("\\|");
            if(values.length == 6) {
                textFromFile.add(new Country(contor, values[0], values[1], Long.parseLong(values[2]), Integer.parseInt(values[3]),
                        values[4], values[5]));
            }
            else{
                textFromFile.add(new Country(contor, values[0], values[1], Long.parseLong(values[2]), Integer.parseInt(values[3]),
                        values[4], ""));
            }
            contor++;
        }
        return textFromFile;
    }
}
