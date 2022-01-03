package censusanalyserrefactor;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import censusanalyser.IndiaCensusCSV;
import censusanalyser.StateCodes;

public class IndianStateCodes {

	public int loadIndiaStateCodes(String csvPath) throws CensusAnalyserException {

		try (Reader reader = Files.newBufferedReader(Paths.get(csvPath))) {

			Iterator<StateCodes> censusCsvIterator = getCSVIterator(reader, StateCodes.class);
			Iterable<StateCodes> csvIterator = () -> censusCsvIterator;
			int numOfEntires = (int) StreamSupport.stream(csvIterator.spliterator(), true).count();
			return numOfEntires;

		} catch (IOException e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		}
	}
	
	private <E> Iterator getCSVIterator(Reader reader, Class csvClass) {
		CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
		csvToBeanBuilder.withType(csvClass);
		csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
		CsvToBean<E> csvToBean = csvToBeanBuilder.build();
		return csvToBean.iterator();
	}
}
