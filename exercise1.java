package stock;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.json.JSONArray;
import org.json.JSONObject;

public class exercise1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		URL url = new URL("https://www.esunbank.com.tw/bank/personal/deposit/rate/forex/foreign-exchange-rates");
		
//		String json = Jsoup.connect("https://www.esunbank.com.tw/bank/personal/deposit/rate/forex/exchange-rate-chart?Currency=USD/TWD").ignoreContentType(true).execute().body();
//		System.out.println(json);
		Document doc = Jsoup.parse(url, 3000);

		Elements table = doc.select("#inteTable1");

		// store the exchange rate of buy and sell
		String[] country = new String[5];
		String[] exbuy = new String[5];
		String[] exsell = new String[5];
		for (int i = 3; i < 8; i++) {
			Elements city = table.select("tr:nth-child(" + i + ") > td.itemTtitle > a");
			Elements buy = table.select("tr:nth-child(" + i + ") > td:nth-child(2)");
			Elements sell = table.select("tr:nth-child(" + i + ") > td:nth-child(3)");
//			System.out.println(city.text());
//			System.out.println(buy.text());
//			System.out.println(sell.text());
			country[i - 3] = city.text();
			exbuy[i - 3] = buy.text();
			exsell[i - 3] = sell.text();
		}
		
		exchangerate exrate = new exchangerate();
		for(int i = 0 ; i< 5; i++){
			exrate.setcountry(country[i]);
			exrate.setbuyrate(exbuy[i]);
			exrate.setsellrate(exsell[i]);
			JSONArray array = new JSONArray(exrate.toString());
			System.out.println(array);
		}
	}
}
