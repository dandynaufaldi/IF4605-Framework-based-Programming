package io.github.dandynaufaldi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;

public class Main {
	private final static String appID = "<ADD_APP_ID>";
	private final static String appKey = "<ADD_APP_KEY>";

	private static String encodeURI(String s) {
		String result;
		s = s.toLowerCase();
		try {
			result = URLEncoder.encode(s, "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!")
					.replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", ")")
					.replaceAll("\\%7E", "~");
		} catch (UnsupportedEncodingException e) {
			result = s;
		}

		return result;
	}

	private static String requestGet(String word) {
		String url = "https://od-api.oxforddictionaries.com/api/v1/entries/en/" + encodeURI(word) + "/antonyms";
		String response;
		try {
			URL obj = new URL(url);
			HttpsURLConnection conn;
			try {
				conn = (HttpsURLConnection) obj.openConnection();
				conn.addRequestProperty("app_id", appID);
				conn.addRequestProperty("app_key", appKey);

				int responseCode = conn.getResponseCode();

				if (responseCode == 200) {
					BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					String inputLine;
					StringBuffer responseBuffer = new StringBuffer();

					while ((inputLine = in.readLine()) != null) {
						responseBuffer.append(inputLine);
					}

					in.close();

					response = responseBuffer.toString();
				} else {
					System.out.println("Request Error");
					response = "";
				}

			} catch (IOException e) {
				System.out.println("Failed to make connection");
				response = "";
			}

		} catch (MalformedURLException e) {
			System.out.println("Fail to parse URL");
			response = "";
		}

		return response;
	}

	public static void main(String[] args) {
		System.out.println("Input the English word to get the antonyms >");
		Scanner scanner = new Scanner(System.in);
		String word = scanner.nextLine();
		scanner.close();

		String res = requestGet(word);
		// String res = "{ \"metadata\": { \"provider\": \"Oxford University Press\" },
		// \"results\": [ { \"id\": \"pretty\", \"language\": \"en\",
		// \"lexicalEntries\": [ { \"entries\": [ { \"homographNumber\": \"000\",
		// \"senses\": [ { \"antonyms\": [ { \"id\": \"plain\", \"language\": \"en\",
		// \"text\": \"plain\" }, { \"id\": \"ugly\", \"language\": \"en\", \"text\":
		// \"ugly\" } ], \"examples\": [ { \"text\": \"a pretty child\" } ], \"id\":
		// \"t_en_gb0011544.001\", \"subsenses\": [ { \"id\":
		// \"id2d290668-1527-4002-a5dd-5759268d8909\" }, { \"id\":
		// \"idfc3cface-2dc4-4a05-8f8c-663a718a4e92\" }, { \"id\":
		// \"id79d26f80-adec-4e12-9c33-38bfefb596c2\" }, { \"id\":
		// \"idf22e2a18-1ed2-4a91-883a-d2e73e0656af\" }, { \"id\":
		// \"idadc395a9-c4d0-42aa-ace8-fd4d89bf96f6\", \"regions\": [ \"Scottish\",
		// \"Northern English\" ] }, { \"id\":
		// \"idc4e41e3e-887c-473e-8330-e6db6cbf79ef\", \"registers\": [ \"informal\" ]
		// }, { \"id\": \"idef35adaf-468c-4042-a6ea-3380a46b2a18\", \"registers\": [
		// \"literary\" ] }, { \"id\": \"id5b48fc36-0490-4539-8e70-c107f6165e1a\",
		// \"registers\": [ \"archaic\" ] } ] } ] } ], \"language\": \"en\",
		// \"lexicalCategory\": \"Adjective\", \"text\": \"pretty\" } ], \"type\":
		// \"headword\", \"word\": \"pretty\" } ] }";
		// System.out.println(res);

		if (res != "") {
			Gson gson = new Gson();
			APIResponse response = gson.fromJson(res, APIResponse.class);
			System.out.println(response);
		} else {
			System.out.println("Can't find antonym");
		}

	}

}
