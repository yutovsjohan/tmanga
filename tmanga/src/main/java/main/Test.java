package main;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import dao.nxbDAO;
import dao.tacgiaDAO;
import entities.nxb;
import entities.tacgia;



public class Test {

	public static void main(String[] args) {
//		insertTacgia();
//		updateTacgia(2);
//		deleteTacgia();
		
//		insertNXB();
//		updateNXB(1);
	}

	public static void insertTacgia() {
		try {
			tacgiaDAO tacgiaDAO = new tacgiaDAO();
			String tentg = "Akira Toriyama";
			String str = changeTitle(tentg);
			tacgia tacgia = new tacgia(tentg, str, (byte) 1);
			tacgiaDAO.insert(tacgia);
			System.out.println("Insert object successful: " + tacgia.toString());
		} catch (Exception e) {
			System.out.println("Insert object failed: " + e.getMessage());
		}
	}
	
	public static void updateTacgia(int id) {
		try {
			tacgiaDAO tacgiaDAO = new tacgiaDAO();
			tacgia tacgia = tacgiaDAO.getId(id);
			tacgia.setTentacgia("Yoshito Usui");
			String str = changeTitle(tacgia.getTentacgia());
			tacgia.setTenkhongdau(str);
			tacgiaDAO.update(tacgia);
			System.out.println("Update object successful: " + tacgia.toString());
		} catch (Exception e) {
			System.out.println("Update object failed: " + e.getMessage());
		}
	}

	public static void deleteTacgia() {
		try {
			tacgiaDAO tacgiaDAO = new tacgiaDAO();
			tacgia tacgia = tacgiaDAO.getId(4);
			tacgiaDAO.delete(tacgia);
			System.out.println("Delete object successful: " + tacgia.toString());
		} catch (Exception e) {
			System.out.println("Delete object failed: " + e.getMessage());
		}
	}
	
	public static void insertNXB() {
		try {
			nxbDAO nxbDAO = new nxbDAO();
			String tennxb = "Kim Đồng";
			String str = changeTitle(tennxb);
			nxb nxb = new nxb(tennxb, str, (byte) 1);
			nxbDAO.insert(nxb);
			System.out.println("Insert object successful: " + nxb.toString());
		} catch (Exception e) {
			System.out.println("Insert object failed: " + e.getMessage());
		}
	}
	
	public static void updateNXB(int id) {
		try {
			nxbDAO nxbDAO = new nxbDAO();
			nxb nxb = nxbDAO.getId(id);
			nxb.setTennxb("Kim Đồng");
			String str = changeTitle(nxb.getTennxb());
			nxb.setTenkhongdau(str);
			nxbDAO.update(nxb);
			System.out.println("Update object successful: " + nxb.toString());
		} catch (Exception e) {
			System.out.println("Update object failed: " + e.getMessage());
		}
	}
	
	public static String removeAccent(String s) {
	  String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
	  Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	  return pattern.matcher(temp).replaceAll("").replace('đ','d').replace('Đ','D');
	}
		
	public static String changeTitle(String s) {
		s = removeAccent(s);		
		Pattern pattern = Pattern.compile("[\\W_]");
		s = pattern.matcher(s).replaceAll(" ");
		
		s = s.trim();
		while(s.contains("  ")) {
			s =	s.replaceAll("  ", " ");
		}
		
		s = s.replaceAll(" ", "-");
		s = s.toLowerCase();
		return s;
	}
}
