package stockdata;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class StockClass {
	private double closingPrice;
	private double openingPrice;
	private double volume;
	String data;
	String[] values;
	PrintWriter outputStream1;
	PrintWriter outputStream2;
	PrintWriter outputStream3;
	
	int cnt[]={0,0,0,0,0,0,0,0,0,0,0,0};
	int totVolume[]= {0,0,0,0,0,0,0,0,0,0,0,0};
	
	
	public void fileread (String fName) throws FileNotFoundException, ParseException {
		String fileName = fName;
		File file = new File(fileName);
		Scanner scan = new Scanner(file);
		scan.nextLine(); //ignore the first line
		
		FileOutputStream fos1 = new FileOutputStream("ClosingPriceHigher.csv",true);
		outputStream1 = new PrintWriter(fos1);
		
		FileOutputStream fos2 = new FileOutputStream("OpeningPriceHigher.csv",true);
		outputStream2 = new PrintWriter(fos2);
		
		FileOutputStream fos3 = new FileOutputStream("MonthlyAverage.csv",true);
		outputStream3 = new PrintWriter(fos3);
		
		
		
		while (scan.hasNext()) {
			data = scan.nextLine();
			values = data.split(",");
			closingPrice = Double.parseDouble(values[1].replace("$", "0"));
			openingPrice = Double.parseDouble(values[3].replace("$", "0"));
			volume = Double.parseDouble(values[2]);
			comparePrice();
			String sDate = values[0];
			monthlyAvgVolume(sDate);
			
			
			}
		scan.close();
		outputStream1.close();
		outputStream2.close();
		
	}
	
		public void comparePrice() throws FileNotFoundException{
			
			//a) print the record in file when stock closed price higher than open price.
			
			if (closingPrice>openingPrice) {
			outputStream1.println(data);
			}
			
			//b) print the record in file when stock closed price is less then open price
		
			else if(closingPrice<openingPrice) {
			outputStream2.println(data);
			
			
			}
		
		}
		
		//C) print monthly average volume traded for last 1 year
		
		public void monthlyAvgVolume(String sDate) throws ParseException {
			String[] sd = sDate.split("/");
		    int mm = Integer.parseInt(sd[0]);
		    
				switch(mm) {
				case 1 :
					totVolume[0] += volume;
					cnt[0]+=1;
					break;
				case 2 :
					totVolume[1] += volume;
					cnt[1]+=1;
					break;
				case 3 :
					totVolume[2] += volume;
					cnt[2]+=1;
					break;
				case 4 :
					totVolume[3] += volume;
					cnt[3]+=1;
					break;
				case 5 :
					totVolume[4] += volume;
					cnt[4]+=1;
					break;
				case 6 :
					totVolume[5] += volume;
					cnt[5]+=1;
					break;
				case 7 :
					totVolume[6] += volume;
					cnt[6]+=1;
					break;
				case 8 :
					totVolume[7] += volume;
					cnt[7]+=1;
					break;
				case 9 :
					totVolume[8] += volume;
					cnt[8]+=1;
					break;
				case 10 :
					totVolume[9] += volume;
					cnt[9]+=1;
					break;
				case 11 :
					totVolume[10] += volume;
					cnt[10]+=1;
					break;
				case 12 :
					totVolume[11] += volume;
					cnt[11]+=1;
					break;
				
				}
				
						
			}
		
	public void printMonthlyVolume() {
		//System.out.println(totVolume[0]);
		outputStream3.println("Monthly Average Volume of January  : "+totVolume[0]/cnt[0]);	
		outputStream3.println("Monthly Average Volume of February : "+totVolume[1]/cnt[1]);	
		outputStream3.println("Monthly Average Volume of March    : "+totVolume[2]/cnt[2]);	
		outputStream3.println("Monthly Average Volume of April    : "+totVolume[3]/cnt[3]);	
		outputStream3.println("Monthly Average Volume of May      : "+totVolume[4]/cnt[4]);	
		outputStream3.println("Monthly Average Volume of June     : "+totVolume[5]/cnt[5]);	
		outputStream3.println("Monthly Average Volume of July     : "+totVolume[6]/cnt[6]);	
		outputStream3.println("Monthly Average Volume of August   : "+totVolume[7]/cnt[7]);	
		outputStream3.println("Monthly Average Volume of September: "+totVolume[8]/cnt[8]);	
		outputStream3.println("Monthly Average Volume of October  : "+totVolume[9]/cnt[9]);	
		outputStream3.println("Monthly Average Volume of November : "+totVolume[10]/cnt[10]);	
		outputStream3.println("Monthly Average Volume of December : "+totVolume[11]/cnt[11]);	
		
		outputStream3.close();
	}
}
