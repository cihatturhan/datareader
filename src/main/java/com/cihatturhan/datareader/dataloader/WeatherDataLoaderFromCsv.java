package com.cihatturhan.datareader.dataloader;

import com.cihatturhan.datareader.dataloader.utils.CSVFileReader;
import com.cihatturhan.datareader.entities.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class WeatherDataLoaderFromCsv implements WeatherDataLoader {



    // read Datas from csv file and return Weather List
    @Override
    public List<Weather> getAllWeathers( String filePath, CSVFileReader csvFileReader) {
        List<Weather> weathers = new ArrayList<>();
        List<String> weathersInLines = csvFileReader.csvFileToStringList(filePath);

        weathersInLines.stream().forEach((line) -> {
            if (convertLineToWeather(line) != null)
                weathers.add(convertLineToWeather(line));
        });


        return weathers;
    }

    private Weather convertLineToWeather(String str) {
        Weather weather = new Weather();
        try {
            String[] line = str.split(",");
            weather.setDay(Integer.parseInt(line[0]));
            weather.setMxT(Integer.parseInt(line[1]));
            weather.setMnT(Integer.parseInt(line[2]));
            weather.setAvT(Integer.parseInt(line[3]));
            weather.setAvDP(Float.parseFloat(line[4]));
            weather.set_1HrP_TPcpn(Integer.parseInt(line[5]));
            weather.setDir(Integer.parseInt(line[6]));
            weather.setAvSp(Float.parseFloat(line[7]));
            weather.setDir(Integer.parseInt(line[8]));
            weather.setMxS(Integer.parseInt(line[9]));
            weather.setSkyC(Float.parseFloat(line[10]));
            weather.setMxR(Integer.parseInt(line[11]));
            weather.setMn(Integer.parseInt(line[12]));
            weather.setR_AvSLP(Float.parseFloat(line[13]));
        } catch (Exception e) {
            return null;
        }


        return weather;
    }
}
