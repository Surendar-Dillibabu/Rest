package it.sella.operationalrisksuite.exceptions;

/**
 * Description : This is a general custom exception which can be used for generalized exceptions
 * @author gbs04543
 *
 */
public class OperationalRiskSuiteException extends Exception {
    
  private static final long serialVersionUID = 1L;
	
  private Object param[];
	
  
  public OperationalRiskSuiteException(){
	super();
  }
	

  public OperationalRiskSuiteException(String exception){
	super(exception);
  }

  public OperationalRiskSuiteException(String exception, Object[] param){
	super(exception);
	this.param = param;
  }
	
  public OperationalRiskSuiteException(String exception, Object[] param,Throwable throwable){
	super(exception,throwable);
	this.param = param;
  }
	
  public OperationalRiskSuiteException(Throwable throwable){
	super(throwable);
  }
	
  public OperationalRiskSuiteException(String errorMessage, Throwable throwable){
	super( errorMessage, throwable);
  }
	
  public Object[] getParam() {
	return param;
  }

  public void setParam(Object[] param) {
	this.param = param;
  }
	
  public String toString() {
	return super.getMessage();
  }
  
}