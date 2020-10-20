package jp.gr.java_conf.mt777.kiroku.moji_sousa;

import java.awt.*;

public class Moji_sousa {//�f?[�^�i�[�p�̃?����

	//�R���X�g���N�^
	public Moji_sousa() {
	}

	//
	public void reset() {
	}

	//
/*
	public int String2int(String str0, int henkan_error_modoriti) {
		try {
			return Integer.parseInt(str0);
		} catch ( NumberFormatException e ) {
			return henkan_error_modoriti;
		}
	}
*/

	public int String2int(String str0, int henkan_error_modoriti) {

		int s_hantei;
		s_hantei = String2suuti_hantei(str0);

		if (s_hantei == 1) {
			return Integer.parseInt(str0);
		}
		if (s_hantei == 2) {
			double d0;
			d0 = Double.parseDouble(str0);
			return (int) Math.round(d0);
		}

		return henkan_error_modoriti;
	}

	public double String2double(String str0, double henkan_error_modoriti) {

		int s_hantei;
		s_hantei = String2suuti_hantei(str0);

		if (s_hantei == 1) {
			return Integer.parseInt(str0);
		}
		if (s_hantei == 2) {
			return Double.parseDouble(str0);
		}

		return henkan_error_modoriti;
	}

	public int String2int_kakunin(String str0) {//string��int�ɕϊ��ł��邩�ǂ������m�F����?B�ł���=1?B�ł��Ȃ�=0
		try {
			Integer.parseInt(str0);
			return 1;
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public int String2double_kakunin(String str0) {//string��double�ɕϊ��ł��邩�ǂ������m�F����?B�ł���=1?B�ł��Ȃ�=0
		try {
			Double.parseDouble(str0);
			return 1;
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public int String2suuti_hantei(String str0) {//string��?��l�Ƃ��Ă݂�?�?��Ɍ^�𔻒肷��?Bdouble=2?Bint=1?B?��l�ł͂Ȃ�=0
		int i_r = 0;
		if (String2double_kakunin(str0) == 1) {
			i_r = 2;
		}
		if (String2int_kakunin(str0) == 1) {
			i_r = 1;
		}
		return i_r;
	}

	// ---------------------------------

	public String toHtmlColor(Color col) {
		// null�Ȃ甒��Ԃ�?B
		if (col == null) {
			return "#FFFFFF";
		}
		String str = "";
		String colCode = "";

		str = "#";


		// 16?i?���?�?������擾?A�Z�b�g
		colCode = Integer.toHexString(col.getRed());
		if (colCode.length() == 1) {
			colCode = "0" + colCode;
		}
		str = str + colCode;
		// 16?i?��ŗ�?������擾?A�Z�b�g
		colCode = Integer.toHexString(col.getGreen());
		if (colCode.length() == 1) {
			colCode = "0" + colCode;
		}
		str = str + colCode;

		// 16?i?���?�?������擾?A�Z�b�g
		colCode = Integer.toHexString(col.getBlue());
		if (colCode.length() == 1) {
			colCode = "0" + colCode;
		}
		str = str + colCode;

		return str;
	}


}



