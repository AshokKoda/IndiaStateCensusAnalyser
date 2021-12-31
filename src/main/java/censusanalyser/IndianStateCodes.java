package censusanalyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class IndianStateCodes {

public int loadIndiaStateCodes(String csvPath) throws CensusAnalyserException {
		
		try {
			Reader reader = Files.newBufferedReader(Paths.get(csvPath));
			CsvToBeanBuilder<StateCodes> csvToBeanBuilder = new CsvToBeanBuilder<StateCodes>(reader);
			csvToBeanBuilder.withType(StateCodes.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<StateCodes> csvToBean = csvToBeanBuilder.build();
			Iterator<StateCodes> censusCsvIterator = csvToBean.iterator();
			
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
}
