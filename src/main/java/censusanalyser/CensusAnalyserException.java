package censusanalyser;

public class CensusAnalyserException extends Exception {

	ExceptionType type;
	private String message;
	
	public CensusAnalyserException(String message, ExceptionType type) {
		super();
		this.type = type;
		this.message = message;
	}
	
	enum ExceptionType {
		CENSUS_FILE_PROBLEM;
	}
	
	
}
