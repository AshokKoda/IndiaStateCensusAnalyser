package censusanalyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CensusAnalyser {

	public int loadCensusData(String csvPath) throws CensusAnalyserException {
		
		try {
			Reader reader = Files.newBufferedReader(Paths.get(csvPath));
			CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<IndiaCensusCSV>(reader);
			csvToBeanBuilder.withType(IndiaCensusCSV.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<IndiaCensusCSV> csvToBean = csvToBeanBuilder.build();
			Iterator<IndiaCensusCSV> censusCsvIterator = csvToBean.iterator();
			
			int numOfEntires = 0;
			while(censusCsvIterator.hasNext()) {
				numOfEntires++;
				censusCsvIterator.next();
			}
			return numOfEntires;
			
		} catch (IOException e) {
			throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		}
	}
	
//	public int readData(String csvPath) throws CensusAnalyserException {
//
//		List<IndiaCensusCSV> list = new ArrayList<>();
//		
//		try {
//			Reader reader = Files.newBufferedReader(Paths.get(csvPath));
//			CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<IndiaCensusCSV>(reader);
//			csvToBeanBuilder.withType(IndiaCensusCSV.class);
//			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
//			CsvToBean<IndiaCensusCSV> csvToBean = csvToBeanBuilder.build();
//			Iterator<IndiaCensusCSV> censusCsvIterator = csvToBean.iterator();
//			
//			int count = 1;
//			while(censusCsvIterator.hasNext()) {
//				count++;
//				censusCsvIterator.next();
//			}
//			return count;
//		} catch (IOException e) {
//			if (csvPath.contains(".csv")) {
//                throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.NO_SUCH_FILE);
//            }
//		}
//		return 0;
//		
//	}

}
