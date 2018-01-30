package builders;

import java.sql.Date;

import entities.DuePayment;
import entities.Member;

public class DuePaymentBuilder {

	private DuePayment dp;
	
	public DuePaymentBuilder() {
		dp = new DuePayment();
	}
	
	public DuePaymentBuilder id(int id) {
		dp.setId(id);
		return this;
	}
	
	public DuePaymentBuilder paymentDate(Date paymentDate) {
		dp.setPaymentDate(paymentDate);
		return this;
	}
	
	public DuePaymentBuilder year(int year) {
		dp.setYear(year);
		return this;
	}
	
	public DuePaymentBuilder vouch(int vouch) {
		dp.setVouch(vouch);
		return this;
	}
	
	public DuePaymentBuilder member(Member member) {
		dp.setMember(member);
		return this;
	}
	
	public DuePayment build() {
		return dp;
	}
}
