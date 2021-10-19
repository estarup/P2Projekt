package net.codejava;

import org.json.JSONArray;
import org.json.JSONObject;

public class ComparePrices {
	public static String getPrices() throws Exception {
		JSONArray jsonRema = SqlCon.getPriceInfo(Shops.REMA);
		JSONArray jsonFoetex = SqlCon.getPriceInfo(Shops.FOETEX);
		JSONArray totalFoetex = new JSONArray();
		JSONArray totalRema = new JSONArray();
		JSONObject finalObj = new JSONObject();
		JSONObject priceObj = new JSONObject();
		JSONObject savingsObj = new JSONObject(); 
		JSONArray priceArray = new JSONArray();
		JSONArray savingsArray = new JSONArray();
		
		float[] remaPrices = new float[jsonRema.length()];
		float[] foetexPrices = new float[jsonFoetex.length()];
		float totalSavings = 0;
		float totalPrice = 0;
		
		if (jsonRema.length() != jsonFoetex.length()) {
			System.out.println("ERROR - Item count missmatch");
		}
		for (int i = 0; i < jsonRema.length(); i++) {
			remaPrices[i] = jsonRema.getJSONObject(i).getFloat("price");
			foetexPrices[i] = jsonFoetex.getJSONObject(i).getFloat("price");
			if (remaPrices[i] <= foetexPrices[i]) {
				float savings = foetexPrices[i] - remaPrices[i];
				totalSavings += savings; 
				jsonRema.getJSONObject(i).put("savings", savings);
				jsonRema.getJSONObject(i).put("butik", "Rema");
				totalRema.put(jsonRema.getJSONObject(i));
			}
			else {
				float savings = remaPrices[i] - foetexPrices[i];
				totalSavings += savings; 
				jsonFoetex.getJSONObject(i).put("savings", savings);
				jsonFoetex.getJSONObject(i).put("butik", "Foetex");
				totalFoetex.put(jsonFoetex.getJSONObject(i));
			}
		} 
		for (int j = 0; j < totalRema.length(); j++) {
			totalPrice += totalRema.getJSONObject(j).getFloat("price");
		}
		for (int j = 0; j < totalFoetex.length(); j++) {
			totalPrice += totalFoetex.getJSONObject(j).getFloat("price");
		}

		priceObj.put("TotalPrice", totalPrice);
		savingsObj.put("TotalSavings", totalSavings);
		priceArray.put(priceObj);
		savingsArray.put(savingsObj);
		finalObj.put("RemaButik", totalRema);
		finalObj.put("FoetexButik", totalFoetex);
		finalObj.put("TotalPrice", priceArray);
		finalObj.put("TotalSavings", savingsArray);
		System.out.println(finalObj);
		return finalObj.toString();
	}
}
