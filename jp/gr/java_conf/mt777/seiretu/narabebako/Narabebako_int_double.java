package jp.gr.java_conf.mt777.seiretu.narabebako;

import java.util.ArrayList;

public class Narabebako_int_double {//�f?[�^?[��double��?�����?���?��񂵂Ď��߂�
	ArrayList i_d_List = new ArrayList();
	//---------------------------------


	//�R���X�g���N�^
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
	public int_double get_i_d(int i) {//���ה����̑O����i�Ԗڂ�int_double�����?o��
		int_double i_d_temp = new int_double();
		i_d_temp.set((int_double) i_d_List.get(i));
		return i_d_temp;
		//return (int_double)i_d_List.get(i);

	}

	//
	public int get_jyunjyo(int i_of_i_d) {//���ׂ�ꂽ���ʂƂ���?Aint��?�?���Ԃ�?Bint�ɓ����l������ƌ��ʂ͂��������Ȃ�
		for (int i = 1; i <= getsousuu(); i++) {

			if (i_of_i_d == get_int(i)) {
				return i;
			}


		}

		return 0;//?��Ԃ�0�Ƃ������Ƃ͂��肦�Ȃ��̂�?Aint��?��Ԃ��������Ȃ�����?�?���0��Ԃ�?B
	}


//-------------------------

	public int get_int(int i) {//���ׂ�ꂽ����?A?�?���i�ԖڂɂȂ���int��Ԃ�
		int_double i_d_temp = new int_double();
		i_d_temp.set((int_double) i_d_List.get(i));
		return i_d_temp.get_i();
	}

	public int usirokara_get_int(int iu) {//��납��i�Ԗڂ�int��Ԃ�
		int i = getsousuu() + 1 - iu;
		int_double i_d_temp = new int_double();
		i_d_temp.set((int_double) i_d_List.get(i));
		return i_d_temp.get_i();
	}

	public double get_double(int i) {//���ׂ�ꂽ����?A?�?���i�ԖڂɂȂ���int�ƃy�A��double��Ԃ�
		int_double i_d_temp = new int_double();
		i_d_temp.set((int_double) i_d_List.get(i));
		return i_d_temp.get_d();
	}

	public void add(int_double i_d_0) {//int_double��P��?Ō���ɉ�����
		i_d_List.add(i_d_0);
	}


	public void add(int i, int_double i_d_0) {//int_double��P��i�Ԗڂɂɉ�����?i�}������?j
		i_d_List.add(i, i_d_0);
	}


	public void ire_i_tiisaijyun(int_double i_d_0) {//���̊�?��̖��O�̈Ӗ���i��d��?�����?��ɓ����Ƃ����Ӗ������킩��ɂ�������
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

	//int_double��1�Ԗڂ�getsousuu�Ԗڂɂ�?A2�Ԗڂ�1�Ԗ�?A3�Ԗڂ�2�Ԗ�?A?A?Agetsousuu�Ԗڂ�getsousuu-1�Ԗڂɂ���
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

