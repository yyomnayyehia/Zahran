import java.util.*;
public class Creditcard implements PaymentMethod {
private String cardholdername;
private String cardnumber;
private int cvv;
private Date expirydate;

    public Creditcard(String cardholdername, String cardnumber, int cvv, Date expirydate) {
        this.cardholdername = cardholdername;
        this.cardnumber = cardnumber;
        this.cvv = cvv;
        this.expirydate = expirydate;
    }

    public String getCardholdername() {
        return cardholdername;
    }

    public void setCardholdername(String cardholdername) {
        this.cardholdername = cardholdername;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public Date getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(Date expirydate) {
        this.expirydate = expirydate;
    }

    @Override
    public boolean isValid() {
        Date current = new Date();
        if (expirydate.after(current)){
            return true;
        }
        return false;
    }

    @Override
    public String pay(int amount) {
        if(isValid()){
            PayPal.getAccountbalance()-=amount;
            return "successful";
        }
        return "failed";
    }

}
