package jp.gr.java_conf.mt777.seiretu.narabebako;

import java.util.ArrayList;

public class Narabebako_int_double {//ƒf?[ƒ^?[‚ðdouble‚Ì?¬‚³‚¢?‡‚É?®—ñ‚µ‚ÄŽû‚ß‚é
	ArrayList i_d_List = new ArrayList();
	//---------------------------------


	//ƒRƒ“ƒXƒgƒ‰ƒNƒ^
	public Narabebako_int_double() {
		i_d_List.add(new int_double(0, -1.0));
	}

	//
	public void reset() {
		i_d_List.clear();
		i_d_List.add(new int_double());
	}

	//
	public int getsousuu() {
		return i_d_List.size() - 1;
	}

	//
	public int_double get_i_d(int i) {//•À‚×” “à‚Ì‘O‚©‚çi”Ô–Ú‚Ìint_double‚ðŽæ‚è?o‚·
		int_double i_d_temp = new int_double();
		i_d_temp.set((int_double) i_d_List.get(i));
		return i_d_temp;
		//return (int_double)i_d_List.get(i);

	}

	//
	public int get_jyunjyo(int i_of_i_d) {//•À‚×‚ç‚ê‚½Œ‹‰Ê‚Æ‚µ‚Ä?Aint‚Ì?‡?˜‚ð•Ô‚·?Bint‚É“¯‚¶’l‚ª‚ ‚é‚ÆŒ‹‰Ê‚Í‚¨‚©‚µ‚­‚È‚é
		for (int i = 1; i <= getsousuu(); i++) {

			if (i_of_i_d == get_int(i)) {
				return i;
			}


		}

		return 0;//?‡”Ô‚ª0‚Æ‚¢‚¤‚±‚Æ‚Í‚ ‚è‚¦‚È‚¢‚Ì‚Å?Aint‚Ì?‡”Ô‚ðŒ©‚Â‚¯‚ç‚ê‚È‚©‚Á‚½?ê?‡‚Í0‚ð•Ô‚·?B
	}


//-------------------------

	public int get_int(int i) {//•À‚×‚ç‚ê‚½Œ‹‰Ê?A?‡?˜‚ªi”Ô–Ú‚É‚È‚Á‚½int‚ð•Ô‚·
		int_double i_d_temp = new int_double();
		i_d_temp.set((int_double) i_d_List.get(i));
		return i_d_temp.get_i();
	}

	public int usirokara_get_int(int iu) {//Œã‚ë‚©‚çi”Ô–Ú‚Ìint‚ð•Ô‚·
		int i = getsousuu() + 1 - iu;
		int_double i_d_temp = new int_double();
		i_d_temp.set((int_double) i_d_List.get(i));
		return i_d_temp.get_i();
	}

	public double get_double(int i) {//•À‚×‚ç‚ê‚½Œ‹‰Ê?A?‡?˜‚ªi”Ô–Ú‚É‚È‚Á‚½int‚ÆƒyƒA‚Ìdouble‚ð•Ô‚·
		int_double i_d_temp = new int_double();
		i_d_temp.set((int_double) i_d_List.get(i));
		return i_d_temp.get_d();
	}

	public void add(int_double i_d_0) {//int_double‚ð’P‚É?ÅŒã”ö‚É‰Á‚¦‚é
		i_d_List.add(i_d_0);
	}


	public void add(int i, int_double i_d_0) {//int_double‚ð’P‚Éi”Ô–Ú‚É‚É‰Á‚¦‚é?i‘}“ü‚·‚é?j
		i_d_List.add(i, i_d_0);
	}


	public void ire_i_tiisaijyun(int_double i_d_0) {//‚±‚ÌŠÖ?”‚Ì–¼‘O‚ÌˆÓ–¡‚Íi‚ðd‚Ì?¬‚³‚¢?‡‚É“ü‚ê‚é‚Æ‚¢‚¤ˆÓ–¡‚¾‚ª‚í‚©‚è‚É‚­‚¢‚©‚à
		for (int i = 1; i <= getsousuu(); i++) {

			if (i_d_0.get_d() < get_double(i)) {
				i_d_List.add(i, i_d_0);
				return;
			}


		}

		i_d_List.add(i_d_0);

		//for(int i=1;i<=m0.getGyousuu();i++){
		//	addGyou(m0.getGyou(i));
		//}
	}


	public void set(Narabebako_int_double nbox) {
		reset();
		for (int i = 1; i <= nbox.getsousuu(); i++) {
			i_d_List.add(nbox.get_i_d(i));
		}
	}

//

	//int_double‚Ì1”Ô–Ú‚ðgetsousuu”Ô–Ú‚É‚µ?A2”Ô–Ú‚ð1”Ô–Ú?A3”Ô–Ú‚ð2”Ô–Ú?A?A?Agetsousuu”Ô–Ú‚ðgetsousuu-1”Ô–Ú‚É‚·‚é
	public void jyunkai2wo1nisuru() {
		Narabebako_int_double nbox = new Narabebako_int_double();
		for (int i = 2; i <= getsousuu(); i++) {
			nbox.add(get_i_d(i));
		}
		nbox.add(get_i_d(1));

		set(nbox);

	}


	public void hyouji() {
		System.out.println("--- narabebako.hyouji() ---");
		for (int k = 1; k <= getsousuu(); k++) {
			int_double i_d_temp = new int_double();
			i_d_temp.set((int_double) i_d_List.get(k));

			System.out.println("   Narabebako.hyouj " + k + " : " + i_d_temp.get_i() + "," + i_d_temp.get_d());
		}
	}


}


