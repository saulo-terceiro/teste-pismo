package main.com.example.demo.requestbody;

public class TransactionRequestBody {

    private Long account_id;
    private Long operation_type_id;
    private float amount;

    public TransactionRequestBody(Long idAccount, Long operationType, float amount) {
        this.setAccount_id(idAccount);
        this.setOperation_type_id(operationType);
        this.setAmount(amount);
    }

    public Long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }

    public Long getOperation_type_id() {
        return operation_type_id;
    }

    public void setOperation_type_id(Long operation_type_id) {
        this.operation_type_id = operation_type_id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
