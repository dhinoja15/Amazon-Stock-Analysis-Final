package stockdata;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;

public class Mainapp {

	public static void main(String[] args) throws FileNotFoundException, ParseException {
		// TODO Auto-generated method stub
		//Check for if file is already exist
		File cph = new File("ClosingPriceHigher.csv");
		if (cph.exists()) {
			cph.delete();
		}
		File oph = new File("OpeningPriceHigher.csv");
		if (oph.exists()) {
			oph.delete();
		}
		File mav = new File("MonthlyAverage.csv");
		if (mav.exists()) {
			mav.delete();
		}
		
		StockClass sd = new StockClass();
		sd.fileread("HistoricalQuotes.csv");
		sd.printMonthlyVolume();
		
	}

}
