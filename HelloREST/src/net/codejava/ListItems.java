package net.codejava;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ListItems")
public class ListItems {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static String main() throws Exception {
		String totalFinal = ComparePrices.getPrices();
		return totalFinal.toString();
	}
}
