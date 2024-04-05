package Exception;

import Exception.BMSExceptionEnum;
public class BMSException extends RuntimeException{
    private BMSExceptionEnum bmsExceptionEnum;

    public BMSException(String message, BMSExceptionEnum bmsExceptionEnum) {
        super(message);
        this.bmsExceptionEnum = bmsExceptionEnum;
    }
}
