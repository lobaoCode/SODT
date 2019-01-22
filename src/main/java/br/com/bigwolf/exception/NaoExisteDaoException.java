package br.com.bigwolf.exception;

public class NaoExisteDaoException extends RuntimeException {
    public NaoExisteDaoException(String msg){
        super(msg);
    }
}
