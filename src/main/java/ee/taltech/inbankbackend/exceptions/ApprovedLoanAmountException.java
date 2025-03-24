package ee.taltech.inbankbackend.exceptions;

/**
 * Thrown when the requested loan exceeds the credit limit, but an approved loan amount exists.
 */
public class ApprovedLoanAmountException extends Throwable {
    private final String message;
    private final Throwable cause;
    private final int outputLoanAmount;
    private final int approvedLoanPeriod;

    public ApprovedLoanAmountException(String message, int outputLoanAmount, int approvedLoanPeriod) {
        this(message, null, outputLoanAmount, approvedLoanPeriod);
    }

    public ApprovedLoanAmountException(String message, Throwable cause, int outputLoanAmount, int approvedLoanPeriod) {
        this.message = message;
        this.cause = cause;
        this.outputLoanAmount = outputLoanAmount;
        this.approvedLoanPeriod = approvedLoanPeriod;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }

    public int getApprovedLoanAmount() {
        return outputLoanAmount;
    }

    public int getApprovedLoanPeriod() {
        return approvedLoanPeriod;
    }
}