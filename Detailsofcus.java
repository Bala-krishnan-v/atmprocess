package atmmachine;

public class Detailsofcus {
	 private int AccNo;
	    private String AccH;
	    private int Pin;
	    private int AccB;

	    public Detailsofcus (int accNo, String accH, int pin, int accB) {
	        AccNo = accNo;
	        AccH = accH;
	        Pin = pin;
	        AccB = accB;
	    }

	    public int getAccNo() {
	        return AccNo;
	    }

	    public void setAccNo(int accNo) {
	        AccNo = accNo;
	    }

	    public String getAccH() {
	        return AccH;
	    }

	    public void setAccH(String accH) {
	        AccH = accH;
	    }

	    public int getPin() {
	        return Pin;
	    }

	    public void setPin(int pin) {
	        Pin = pin;
	    }

	    public int getAccB() {
	        return AccB;
	    }

	    public void setAccB(int accB) {
	        AccB = accB;
	    }

	    @Override
	    public String toString() {
	        return "CustomerDetails{" +
	                "AccNo=" + AccNo +
	                ", AccountHolder='" + AccH + '\'' +
	                ", Pin=" + Pin +
	                ", AccountBalance=" + AccB +
	                '}';
	    }
}
