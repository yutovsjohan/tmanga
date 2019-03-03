package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nxb", catalog = "tmanga")
public class nxb implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	int id;
	
	@Column(name = "TENNXB", length = 200)
	String tennxb;
	
	@Column(name = "TENKHONGDAU", length = 200)
	String tenkhongdau;
	
	@Column(name = "TRANGTHAI")
	byte trangthai;
	
	public nxb() {
		super();
		// TODO Auto-generated constructor stub
	}

	public nxb(String tennxb, String tenkhongdau, byte trangthai) {
		super();
		this.tennxb = tennxb;
		this.tenkhongdau = tenkhongdau;
		this.trangthai = trangthai;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTennxb() {
		return tennxb;
	}

	public void setTennxb(String tennxb) {
		this.tennxb = tennxb;
	}

	public String getTenkhongdau() {
		return tenkhongdau;
	}

	public void setTenkhongdau(String tenkhongdau) {
		this.tenkhongdau = tenkhongdau;
	}

	public byte getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(byte trangthai) {
		this.trangthai = trangthai;
	}

	@Override
	public String toString() {
		return "id: " + id + ", tentg: " + tennxb + ", tenkodau: " + tenkhongdau + ", trangthai: " + trangthai;
	}
	
}
