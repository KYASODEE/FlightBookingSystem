package com.cg.booking.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ReferenceNumber1")
public class DBReferenceNumber {
    @Id
    private String bookingid;
	private int refNo;

	public DBReferenceNumber() {
		super();
	}

	public DBReferenceNumber(String bookingid, int refNo) {
		super();
		this.bookingid = bookingid;
		this.refNo = refNo;
	}

	public String getBookingid() {
		return bookingid;
	}

	public void setBookingid(String bookingid) {
		this.bookingid = bookingid;
	}

	public int getRefNo() {
		return refNo;
	}

	public void setRefNo(int refNo) {
		this.refNo = refNo;
	}

	@Override
	public String toString() {
		return "DBReferenceNumber [bookingid=" + bookingid + ", refNo=" + refNo + "]";
	}

}