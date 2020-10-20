package jp.gr.java_conf.mt777.kiroku.memo;

import java.util.ArrayList;

public class Memo {//ƒf?[ƒ^Ši”[—p‚Ìƒ?ƒ‚’ 
	ArrayList Gyou = new ArrayList();
	//---------------------------------

	//ƒRƒ“ƒXƒgƒ‰ƒNƒ^
	public Memo() {
		Gyou.add("");
	}

	//
	public void reset() {
		Gyou.clear();
		Gyou.add("");
	}

	//
	public int getGyousuu() {
		return Gyou.size() - 1;
	}

	//
	public String getGyou(int i) {
		return (String) Gyou.get(i);
	}

	//
	public void addGyou(String s) {
		Gyou.add(s);
	}


	public void set(Memo m0) {
		Memo m1 = new Memo();
		for (int i = 1; i <= m0.getGyousuu(); i++) {
			m1.addGyou(m0.getGyou(i));
		}//m0‚Í‚Ü‚¸m1‚É•¡?»‚³‚ê?Am1‚ªset‚³‚ê‚é?B‚±‚¤‚·‚é‚Ì‚Í?AŽ©•ªŽ©?g‚ðset‚·‚é?ê?‡riset()‚É‚æ‚Á‚Ä’†?g‚ª?Á‚¦‚Ä‚µ‚Ü‚¤‚±‚Æ‚ð–h‚®‚½‚ß

		reset();
		for (int i = 1; i <= m1.getGyousuu(); i++) {
			addGyou(m1.getGyou(i));
		}
	}

	public void set_old(Memo m0) {
		reset();
		for (int i = 1; i <= m0.getGyousuu(); i++) {
			addGyou(m0.getGyou(i));
		}
	}


	public void addMemo(Memo m0) {
		for (int i = 1; i <= m0.getGyousuu(); i++) {
			addGyou(m0.getGyou(i));
		}
	}


	public void systemout() {
		System.out.println("memo naiyou kokokara  VVVVVVVVVVVVVVVVVVVVVVVVVVVVVV");
		for (int i = 1; i <= getGyousuu(); i++) {
			System.out.println(getGyou(i));
		}
		System.out.println("memo naiyou kokomade  AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}

}


