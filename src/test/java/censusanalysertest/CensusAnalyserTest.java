package censusanalysertest;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import censusanalyser.CensusAnalyser;
import censusanalyser.CensusAnalyserException;

public class CensusAnalyserTest {

	private static final String INDIACENSUS_PATH = "D:\\Eclipse Java Projects\\New-Workspace\\IndianStateCensusAnalyser\\src\\main\\resources\\IndiaStateCensusData.csv";
	
	//States Census CSV file, Check to ensure the Number of Record matches.
	@Test
	public void getCorrectRecord_Of_IndiaCensusData() {
		CensusAnalyser censusAnalyser = new CensusAnalyser();
		
		try {
			int numOfRecords = censusAnalyser.loadCensusData(INDIACENSUS_PATH);
			Assert.assertEquals(29, numOfRecords);
		} catch (CensusAnalyserException e) {
			
		}
	}
	
	//State Census CSV file incorrect
	@Test
	public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() throws IOException {
		CensusAnalyser censusAnalyser = new CensusAnalyser();
		try {
			int numOfRecords = censusAnalyser.loadCensusData("D:\\Eclipse Java Projects\\New-Workspace\\IndianStateCensusAnalyser\\src\\main\\resources\\IndiaStateCensusData1.csv");
			Assert.assertEquals(29, numOfRecords);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals("NO SUCH FILE", e.getMessage());
		}
	}
	
	//State Census CSV file with incorrect type
	@Test
	public void givenIndiaCensusCSVFile_WhenLoadedWithWrongType_ShouldThrowException() {
		CensusAnalyser censusAnalyser = new CensusAnalyser();
		try {
			int numOfRecords = censusAnalyser.loadCensusData("D:\\Eclipse Java Projects\\New-Workspace\\IndianStateCensusAnalyser\\src\\main\\resources\\IndiaStateCensusData.pdf");
			Assert.assertEquals(29, numOfRecords);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals("EXTENSION TYPE NOT FOUND", e.getMessage());
		}
	}
	
	//State Census CSV file with incorrect Delimiter
	@Test
    public void givenIndiaCensusCSVFile_WhenLoadedWithWrongDelimiter_ShouldThrowException() {
		CensusAnalyser censusAnalyser = new CensusAnalyser();
		try {
			int numOfRecords = censusAnalyser.loadCensusData("D:\\Eclipse Java Projects\\New-Workspace\\IndianStateCensusAnalyser\\src\\main\\resources\\IndiaStateCensusData2.csv");
			Assert.assertEquals(29, numOfRecords);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals("Delimiter is missing", e.getMessage());
		}
	}
	
	//State Census CSV file with incorrect ColumnName
	@Test
    public void givenIndiaCensusCSVFile_WhenLoadedWithWrongColumn_ShouldThrowException() {
		CensusAnalyser censusAnalyser = new CensusAnalyser();
		try {
			int numOfRecords = censusAnalyser.loadCensusData("D:\\Eclipse Java Projects\\New-Workspace\\IndianStateCensusAnalyser\\src\\main\\resources\\IndiaStateCensusData2.csv");
			Assert.assertEquals(29, numOfRecords);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals("Wrong Column existed", e.getMessage());
		}
	}
}
