package jp.gr.java_conf.mt777.seiretu.narabebako;

import java.util.ArrayList;

public class Narabebako_int_double {//デ?[タ?[をdoubleの?ｬさい?�に?ｮ列して収める
	ArrayList i_d_List = new ArrayList();
	//---------------------------------


	//コンストラクタ
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
	public int_double get_i_d(int i) {//並べ箱内の前からi番目のint_doubleを取り?oす
		int_double i_d_temp = new int_double();
		i_d_temp.set((int_double) i_d_List.get(i));
		return i_d_temp;
		//return (int_double)i_d_List.get(i);

	}

	//
	public int get_jyunjyo(int i_of_i_d) {//並べられた結果として?Aintの?�?�を返す?Bintに同じ値があると結果はおかしくなる
		for (int i = 1; i <= getsousuu(); i++) {

			if (i_of_i_d == get_int(i)) {
				return i;
			}


		}

		return 0;//?�番が0ということはありえないので?Aintの?�番を見つけられなかった?�?�は0を返す?B
	}


//-------------------------

	public int get_int(int i) {//並べられた結果?A?�?�がi番目になったintを返す
		int_double i_d_temp = new int_double();
		i_d_temp.set((int_double) i_d_List.get(i));
		return i_d_temp.get_i();
	}

	public int usirokara_get_int(int iu) {//後ろからi番目のintを返す
		int i = getsousuu() + 1 - iu;
		int_double i_d_temp = new int_double();
		i_d_temp.set((int_double) i_d_List.get(i));
		return i_d_temp.get_i();
	}

	public double get_double(int i) {//並べられた結果?A?�?�がi番目になったintとペアのdoubleを返す
		int_double i_d_temp = new int_double();
		i_d_temp.set((int_double) i_d_List.get(i));
		return i_d_temp.get_d();
	}

	public void add(int_double i_d_0) {//int_doubleを単に?ﾅ後尾に加える
		i_d_List.add(i_d_0);
	}


	public void add(int i, int_double i_d_0) {//int_doubleを単にi番目にに加える?i挿入する?j
		i_d_List.add(i, i_d_0);
	}


	public void ire_i_tiisaijyun(int_double i_d_0) {//この関?狽ﾌ名前の意味はiをdの?ｬさい?�に入れるという意味だがわかりにくいかも
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

	//int_doubleの1番目をgetsousuu番目にし?A2番目を1番目?A3番目を2番目?A?A?Agetsousuu番目をgetsousuu-1番目にする
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


