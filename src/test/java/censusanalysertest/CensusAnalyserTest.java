package censusanalysertest;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import censusanalyser.CensusAnalyser;
import censusanalyser.CensusAnalyserException;

public class CensusAnalyserTest {

	private static final String INDIACENSUS_PATH = "D:\\Eclipse Java Projects\\New-Workspace\\IndianStateCensusAnalyser\\src\\main\\resources\\IndiaStateCensusData.csv";
	
	@Test
	public void getCorrectRecord_Of_IndiaCensusData() {
		CensusAnalyser censusAnalyser = new CensusAnalyser();
		
		try {
			int numOfRecords = censusAnalyser.loadCensusData(INDIACENSUS_PATH);
			Assert.assertEquals(29, numOfRecords);
		} catch (CensusAnalyserException e) {
			
		}
	}
	
	@Test
	public void csvFileIncorrect() throws IOException {
		CensusAnalyser censusAnalyser = new CensusAnalyser();
		try {
			int numOfRecords = censusAnalyser.readData("D:\\Eclipse Java Projects\\New-Workspace\\IndianStateCensusAnalyser\\src\\main\\resources\\IndiaStateCensusData1.csv");
			Assert.assertEquals(29, numOfRecords);
		} catch (CensusAnalyserException e) {
			System.out.println(e.getMessage());
			Assert.assertEquals("NO SUCH FILE", e.getMessage());
		}
	}
}
