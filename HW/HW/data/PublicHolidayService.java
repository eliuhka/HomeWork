package HW.data;

import org.json.JSONArray;
import org.json.JSONObject;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;


public class PublicHolidayService {

    private static final String riigikood = "EE";
    private static final String URL = "https://date.nager.at/api/v1/PublicHolidays/";

    public List<ZonedDateTime> getPublicHolidays(String aasta) {
        List<ZonedDateTime> result = new ArrayList<>();
        String composedUrl = URL + aasta + "/" + riigikood;

        try {
            URL url = new URL(composedUrl);
            URLConnection yc = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine;
            String dateString;
            while ((inputLine = in.readLine()) != null) {
                JSONArray jsonArray = new JSONArray(inputLine);
                System.out.println(inputLine);
                for (int i = 0; i < jsonArray.length(); i++)
                {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    dateString = jsonObject.getString("kuupäev");
                    LocalDate date = LocalDate.parse(dateString);
                    ZonedDateTime zonedResult  = date.atStartOfDay(ZoneId.of("UTC"));
                    result.add(zonedResult);
                    System.out.println(zonedResult);
                    System.out.println(zonedResult.getDayOfWeek());
                }}}
        catch (Exception ex) { }
        return result; }}
