import static org.junit.Assert.assertEquals;

import org.junit.Test;

import net.codejava.ComparePrices;

public class ComparePricesTest {
	final private String expectedJSON = "{\"RemaButik\":[{\"price\":3.75,\"name\":\"Bananer\",\"butik\":\"Rema\",\"id\":1,\"savings\":4.25},{\"price\":20,\"name\":\"Græsk Yoghurt\",\"butik\":\"Rema\",\"id\":2,\"savings\":9.950001},{\"price\":39.95,\"name\":\"Kaffe\",\"butik\":\"Rema\",\"id\":4,\"savings\":2.0499992},{\"price\":5.5,\"name\":\"Iste\",\"butik\":\"Rema\",\"id\":5,\"savings\":0.5},{\"price\":6.5,\"name\":\"Æbler\",\"butik\":\"Rema\",\"id\":6,\"savings\":4.5}],\"FoetexButik\":[{\"price\":11.5,\"name\":\"Chokolade\",\"butik\":\"Foetex\",\"id\":3,\"savings\":1},{\"price\":12,\"name\":\"Kiks\",\"butik\":\"Foetex\",\"id\":7,\"savings\":0.5},{\"price\":6,\"name\":\"Mælk\",\"butik\":\"Foetex\",\"id\":8,\"savings\":3.9499998},{\"price\":22.5,\"name\":\"Køkkenrulle\",\"butik\":\"Foetex\",\"id\":9,\"savings\":2}],\"TotalSavings\":[{\"TotalSavings\":28.7}],\"TotalPrice\":[{\"TotalPrice\":127.7}]}";
	@Test
	public void testAllJSON() {
		String actualJSON = null;
		try {
			actualJSON = ComparePrices.getPrices();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(actualJSON, expectedJSON); 
	}
}