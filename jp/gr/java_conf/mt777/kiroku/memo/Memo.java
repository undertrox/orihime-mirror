package jp.gr.java_conf.mt777.kiroku.memo;

import java.util.ArrayList;

public class Memo {//�f?[�^�i�[�p�̃?����
	ArrayList Gyou = new ArrayList();
	//---------------------------------

	//�R���X�g���N�^
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
		}//m0�͂܂�m1�ɕ�?�����?Am1��set�����?B��������̂�?A������?g��set����?�?�riset()�ɂ���Ē�?g��?����Ă��܂����Ƃ�h������

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


