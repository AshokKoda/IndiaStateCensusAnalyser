package censusanalysertest;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import censusanalyser.CensusAnalyser;
import censusanalyser.CensusAnalyserException;
import censusanalyser.IndianStateCodes;

public class IndianStateCodeTest {

	private static final String INDIANSTATECODES_PATH = "D:\\Eclipse Java Projects\\New-Workspace\\IndianStateCensusAnalyser\\src\\main\\resources\\IndiaStateCode.csv";
	
	@Test
	public void getCorrectRecord_Of_IndianStateCodes() {
		IndianStateCodes stateCode = new IndianStateCodes();
		
		try {
			int numOfRecords = stateCode.loadIndiaStateCodes(INDIANSTATECODES_PATH);
			Assert.assertEquals(37, numOfRecords);
		} catch (CensusAnalyserException e) {
			
		}
	}
	
	@Test
	public void incorrectCsvFilename() throws IOException {
		IndianStateCodes stateCode = new IndianStateCodes();
		try {
			int numOfRecords = stateCode.loadIndiaStateCodes("D:\\Eclipse Java Projects\\New-Workspace\\IndianStateCensusAnalyser\\src\\main\\resources\\IndiaStateCode1.csv");
			Assert.assertEquals(37, numOfRecords);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals("NO SUCH FILE", e.getMessage());
		}
	}
	
	@Test
	public void incorrectExtensionFile() {
		IndianStateCodes stateCode = new IndianStateCodes();
		try {
			int numOfRecords = stateCode.loadIndiaStateCodes("D:\\Eclipse Java Projects\\New-Workspace\\IndianStateCensusAnalyser\\src\\main\\resources\\IndiaStateCode.pdf");
			Assert.assertEquals(37, numOfRecords);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals("EXTENSION TYPE NOT FOUND", e.getMessage());
		}
	}
}
