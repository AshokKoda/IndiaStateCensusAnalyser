package censusanalysertest;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import censusanalyser.CensusAnalyserException;
import censusanalyser.IndianStateCodes;

public class IndianStateCodeTest {

	private static final String INDIANSTATECODES_PATH = "D:\\Eclipse Java Projects\\New-Workspace\\IndianStateCensusAnalyser\\src\\main\\resources\\IndiaStateCode.csv";
	
	@Test
	public void givenIndiaCensusCSVFile_WhenLoaded_ShouldReturnCorrectRecords() {
		IndianStateCodes stateCode = new IndianStateCodes();
		
		try {
			int numOfRecords = stateCode.loadIndiaStateCodes(INDIANSTATECODES_PATH);
			Assert.assertEquals(37, numOfRecords);
		} catch (CensusAnalyserException e) {
			
		}
	}
	
	@Test
	public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() throws IOException {
		IndianStateCodes stateCode = new IndianStateCodes();
		try {
			int numOfRecords = stateCode.loadIndiaStateCodes("D:\\Eclipse Java Projects\\New-Workspace\\IndianStateCensusAnalyser\\src\\main\\resources\\IndiaStateCode1.csv");
			Assert.assertEquals(37, numOfRecords);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals("NO SUCH FILE", e.getMessage());
		}
	}
	
	@Test
	public void givenIndiaCensusCSVFile_WhenLoadedWithWrongType_ShouldThrowException() {
		IndianStateCodes stateCode = new IndianStateCodes();
		try {
			int numOfRecords = stateCode.loadIndiaStateCodes("D:\\Eclipse Java Projects\\New-Workspace\\IndianStateCensusAnalyser\\src\\main\\resources\\IndiaStateCode.pdf");
			Assert.assertEquals(37, numOfRecords);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals("EXTENSION TYPE NOT FOUND", e.getMessage());
		}
	}
	
	@Test
	public void givenIndiaCensusCSVFile_WhenLoadedWithWrongDelimiter_ShouldThrowException() {
		IndianStateCodes stateCode = new IndianStateCodes();
		try {
			int numOfRecords = stateCode.loadIndiaStateCodes("D:\\Eclipse Java Projects\\New-Workspace\\IndianStateCensusAnalyser\\src\\main\\resources\\IndiaStateCode.csv");
			Assert.assertEquals(37, numOfRecords);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals("DELIMITER", e.getMessage());
		}
	}
	
	@Test
	public void givenIndiaCensusCSVFile_WhenLoadedWithWrongColumn_ShouldThrowException() {
		IndianStateCodes stateCode = new IndianStateCodes();
		try {
			int numOfRecords = stateCode.loadIndiaStateCodes("D:\\Eclipse Java Projects\\New-Workspace\\IndianStateCensusAnalyser\\src\\main\\resources\\IndiaStateCode.csv");
			Assert.assertEquals(37, numOfRecords);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals("INCORRECT COLUMN NAME", e.getMessage());
		}
	}
}
