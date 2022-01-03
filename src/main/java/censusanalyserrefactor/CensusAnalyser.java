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

public class CensusAnalyser {

	public int loadCensusData(String csvPath) throws CensusAnalyserException {

		try (Reader reader = Files.newBufferedReader(Paths.get(csvPath))) {
			Iterator<IndiaCensusCSV> censusCsvIterator = getCSVIterator(reader, IndiaCensusCSV.class);
			return getCount(censusCsvIterator);
			

		} catch (IOException e) {
			throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		}
	}

	private <E> int getCount(Iterator<E> censusCsvIterator) {
		Iterable<E> csvIterator = () -> censusCsvIterator;
		int numOfEntires = (int) StreamSupport.stream(csvIterator.spliterator(), true).count();
		return numOfEntires;
	}

	private <E> Iterator getCSVIterator(Reader reader, Class csvClass) {
		CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
		csvToBeanBuilder.withType(csvClass);
		csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
		CsvToBean<E> csvToBean = csvToBeanBuilder.build();
		return csvToBean.iterator();
	}
}
