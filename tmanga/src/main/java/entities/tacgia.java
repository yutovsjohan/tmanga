package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tacgia", catalog = "tmanga")
public class tacgia implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	int id;
	
	@Column(name = "TENTACGIA", length = 200)
	String tentacgia;
	
	@Column(name = "TENKHONGDAU", length = 200)
	String tenkhongdau;
	
	@Column(name = "TRANGTHAI")
	byte trangthai;
	
	public tacgia(String tentacgia, String tenkhongdau, byte trangthai) {
		super();
		this.tentacgia = tentacgia;
		this.tenkhongdau = tenkhongdau;
		this.trangthai = trangthai;
	}
	
	public tacgia() {
		super();
		this.tentacgia = "";
		this.tenkhongdau = "";
		this.trangthai = 1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTentacgia() {
		return tentacgia;
	}

	public void setTentacgia(String tentacgia) {
		this.tentacgia = tentacgia;
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
		return "id: " + id + ", tentg: " + tentacgia + ", tenkodau: " + tenkhongdau + ", trangthai: " + trangthai;
	}
	
}
