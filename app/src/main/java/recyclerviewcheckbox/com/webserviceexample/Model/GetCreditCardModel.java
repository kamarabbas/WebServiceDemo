package recyclerviewcheckbox.com.webserviceexample.Model;

import java.util.List;

/**
 * Created by ombharti on 28-Apr-18.
 */

public class GetCreditCardModel {


    /**
     * status : true
     * data : [{"GatewayPaymentProfileId":44,"ReferenceNumber":"x6423","NameOnCard":"Vshah","PaymentMethodName":"Visa","Expiry":"2017-07-31 06:30:00","ExpYear":2017,"ExpMonth":"07","Address1":"Streeet1","Province":"CA","City":"folsom","PostalCode":"94260"}]
     * message : success
     */

    private boolean status;
    private String message;
    private List<DataBean> data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * GatewayPaymentProfileId : 44
         * ReferenceNumber : x6423
         * NameOnCard : Vshah
         * PaymentMethodName : Visa
         * Expiry : 2017-07-31 06:30:00
         * ExpYear : 2017
         * ExpMonth : 07
         * Address1 : Streeet1
         * Province : CA
         * City : folsom
         * PostalCode : 94260
         */

        private int GatewayPaymentProfileId;
        private String ReferenceNumber;
        private String NameOnCard;
        private String PaymentMethodName;
        private String Expiry;
        private int ExpYear;
        private String ExpMonth;
        private String Address1;
        private String Province;
        private String City;
        private String PostalCode;

        public int getGatewayPaymentProfileId() {
            return GatewayPaymentProfileId;
        }

        public void setGatewayPaymentProfileId(int GatewayPaymentProfileId) {
            this.GatewayPaymentProfileId = GatewayPaymentProfileId;
        }

        public String getReferenceNumber() {
            return ReferenceNumber;
        }

        public void setReferenceNumber(String ReferenceNumber) {
            this.ReferenceNumber = ReferenceNumber;
        }

        public String getNameOnCard() {
            return NameOnCard;
        }

        public void setNameOnCard(String NameOnCard) {
            this.NameOnCard = NameOnCard;
        }

        public String getPaymentMethodName() {
            return PaymentMethodName;
        }

        public void setPaymentMethodName(String PaymentMethodName) {
            this.PaymentMethodName = PaymentMethodName;
        }

        public String getExpiry() {
            return Expiry;
        }

        public void setExpiry(String Expiry) {
            this.Expiry = Expiry;
        }

        public int getExpYear() {
            return ExpYear;
        }

        public void setExpYear(int ExpYear) {
            this.ExpYear = ExpYear;
        }

        public String getExpMonth() {
            return ExpMonth;
        }

        public void setExpMonth(String ExpMonth) {
            this.ExpMonth = ExpMonth;
        }

        public String getAddress1() {
            return Address1;
        }

        public void setAddress1(String Address1) {
            this.Address1 = Address1;
        }

        public String getProvince() {
            return Province;
        }

        public void setProvince(String Province) {
            this.Province = Province;
        }

        public String getCity() {
            return City;
        }

        public void setCity(String City) {
            this.City = City;
        }

        public String getPostalCode() {
            return PostalCode;
        }

        public void setPostalCode(String PostalCode) {
            this.PostalCode = PostalCode;
        }
    }
}
