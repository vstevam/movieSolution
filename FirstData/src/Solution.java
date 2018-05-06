import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import com.google.gson.Gson;

public class Solution {
	/*
	 * Complete the function below.
	 */

	static String[] getMovieTitles(String substr) throws IOException {

		int pageNumber = 1;
		String[] resp = new String[13];

		StringBuffer response = getJsonbyURL(substr, pageNumber);

		System.out.println(response.toString());

		Movie movies = new Gson().fromJson(response.toString(), Movie.class);

		int totalPagesNum = Integer.parseInt(movies.getTotal_pages());
		Movie mov = null;
		Data[] datas = null;
		int count = 0;
		for (int i = 1; i <= totalPagesNum; i++) {
			response = getJsonbyURL(substr, i);
			mov = new Gson().fromJson(response.toString(), Movie.class);
			datas = mov.getData();

			for (int x = 0; x < datas.length; x++) {
				resp[count] = datas[x].getTitle();
				count++;
			}
		}

		Arrays.sort(resp);

		return resp;
	}

	private static StringBuffer getJsonbyURL(String substr, int pageNumber) throws IOException {
		URL url = null;
		try {
			url = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr + "&page=" + pageNumber);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		int responseCode = con.getResponseCode();
		System.out.println("Sending GET to URL: " + url);
		System.out.println("Response code: " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		return response;
	}

	public static void main(String[] args) throws IOException {

		String[] res;

		res = getMovieTitles("spiderman");
		for (int res_i = 0; res_i < res.length; res_i++) {
			System.out.println(String.valueOf(res[res_i]));
		}

	}

}
