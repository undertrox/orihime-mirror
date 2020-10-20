package jp.gr.java_conf.mt777.origami.dougu.tensyuugou;

import jp.gr.java_conf.mt777.kiroku.memo.Memo;
import jp.gr.java_conf.mt777.origami.dougu.men.Men;
import jp.gr.java_conf.mt777.zukei2d.oritacalc.OritaCalc;
import jp.gr.java_conf.mt777.zukei2d.senbun.Senbun;
import jp.gr.java_conf.mt777.zukei2d.takakukei.Takakukei;

import java.util.ArrayList;
import java.util.StringTokenizer;

// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------

public class Tensyuugou {

	int Msuu_temp;

//Ten_p tp=new Ten_p();

	int Tensuu;               //��?ۂɎg���_�̑??�
	int Bousuu;               //��?ۂɎg���_�̑??�
	int Mensuu;               //��?ۂɎg���ʂ̑??�
	Ten_p[] t;//�_�̃C���X�^���X��
	Bou[] b;//�_�̃C���X�^���X��
	int[] Bou_moti_Menid_min;
	int[] Bou_moti_Menid_max;

	Men[] m;//�ʂ̃C���X�^���X��

	double[] Bou_x_max;
	double[] Bou_x_min;
	double[] Bou_y_max;
	double[] Bou_y_min;

	double[] Men_x_max;
	double[] Men_x_min;
	double[] Men_y_max;
	double[] Men_y_min;

	OritaCalc oc = new OritaCalc();          //�e��v�Z�p�̊�?����g�����߂̃N���X�̃C���X�^���X��
	ArrayList[] T_renketu;//t_renketu[i][j]��t[i]�ɘA�����Ă���Ten�̔�?�?Bt[0]�ɂ�?ATem��?����i�[?B

	int[][] Men_tonari;//Men_tonari[i][j]��m[i]��m[j]�̋��E��Bou�̔�?�?Bm[i]��m[j]���ׂ�?���Ȃ��Ƃ���0���i�[?B

	public Tensyuugou() {
		reset();
	} //�R���X�g���N�^

	//---------------------------------------
	public void reset() {
		Tensuu = 0;
		Bousuu = 0;
		Mensuu = 0;
	}

	//---------------------------------------
	public void settei(int Tsuu, int Bsuu, int Msuu) { //?�?��⃊�Z�b�g�̌�ɂ͕K���ʂ�悤�ɂ���?B

		Msuu_temp = Msuu;

		Ten_p[] t0 = new Ten_p[Tsuu + 1];
		t = t0;
		ArrayList[] Trenketu = new ArrayList[Tsuu + 1];
		T_renketu = Trenketu;

		T_renketu[0] = new ArrayList();
		for (int i = 0; i <= Tsuu; i++) {
			T_renketu[i] = new ArrayList();
			T_renketu[i].add(new Integer(0));
		}

		for (int i = 0; i <= Tsuu; i++) {
			t[i] = new Ten_p();
			set_T_renketu(i, 0, 0);
		}

		Bou[] b0 = new Bou[Bsuu + 1];
		b = b0;
		int[] BMmin = new int[Bsuu + 1];
		int[] BMmax = new int[Bsuu + 1];
		Bou_moti_Menid_min = BMmin;
		Bou_moti_Menid_max = BMmax;
		for (int i = 0; i <= Bsuu; i++) {
			b[i] = new Bou();
			Bou_moti_Menid_min[i] = 0;
			Bou_moti_Menid_max[i] = 0;
		}

		Men[] m0 = new Men[Msuu + 1];
		m = m0;

		int[][] Mtonari = new int[Msuu + 1][Msuu + 1];

		Men_tonari = Mtonari;

		for (int i = 0; i <= Msuu; i++) {
			//for(int i=0;i<=Msuu+1;i++){
			m[i] = new Men();
			for (int j = 0; j <= Msuu; j++) {
				//for(int j=0;j<=Msuu+1;j++){

				Men_tonari[i][j] = 0;
			}

		}

		double[] Bxmax = new double[Bsuu + 1];
		double[] Bxmin = new double[Bsuu + 1];
		double[] Bymax = new double[Bsuu + 1];
		double[] Bymin = new double[Bsuu + 1];

		double[] Mxmax = new double[Msuu + 1];
		double[] Mxmin = new double[Msuu + 1];
		double[] Mymax = new double[Msuu + 1];
		double[] Mymin = new double[Msuu + 1];

		Bou_x_max = Bxmax;
		Bou_x_min = Bxmin;
		Bou_y_max = Bymax;
		Bou_y_min = Bymin;

		Men_x_max = Mxmax;
		Men_x_min = Mxmin;
		Men_y_max = Mymax;
		Men_y_min = Mymin;
	}

	//---------------
	private int get_T_renketu(int i, int j) {
		Integer Tr = (Integer) T_renketu[i].get(j);
		return Tr.intValue();
	}

	private void set_T_renketu(int i, int j, int tid) {
		if (j + 1 > T_renketu[i].size()) {
			while (j + 1 > T_renketu[i].size()) {
				T_renketu[i].add(new Integer(0));
			}
		}//���̕����Ȃ��Ƃ��܂�?s���Ȃ�?B�Ȃ����̕��łȂ��Ƃ����Ȃ����Ƃ����?�R��?��m�ɂ͂킩��Ȃ�?B
		T_renketu[i].set(j, new Integer(tid));
	}

	//------------------------------
	private double getHeikinZahyou_x() {
		double x = 0.0;
		for (int i = 1; i <= Tensuu; i++) {
			x = x + t[i].getx();
		}
		return x / ((double) Tensuu);
	}

	private double getHeikinZahyou_y() {
		double y = 0.0;
		for (int i = 1; i <= Tensuu; i++) {
			y = y + t[i].gety();
		}
		return y / ((double) Tensuu);
	}

	/*
        public void Iti_sitei(double x,double y){//�STen��?d?S�̈ʒu���w�肳�ꂽ?��W�ɂ���?B
            double xh,yh;
            xh= getHeikinZahyou_x();
            yh= getHeikinZahyou_y();
            heikou_idou(x-xh,y-yh)  ;
        }
    */
	//
	public void uragaesi() {//?d?S�̈ʒu��?S��?��E�ɗ��Ԃ�?B
		double xh;
		int icol;
		xh = getHeikinZahyou_x();
		for (int i = 1; i <= Tensuu; i++) {
			t[i].setx(2.0 * xh - t[i].getx());
		}
		for (int i = 1; i <= Bousuu; i++) {
			icol = b[i].getcolor();
			if (icol == 1) {
				b[i].setcolor(2);
			}
			if (icol == 2) {
				b[i].setcolor(1);
			}
		}

	}


	//public double menseki(int men_id) {return 1.0; }//   �ʂ̖�?ς�Ԃ�


	public void heikou_idou(double x, double y) {
		for (int i = 0; i <= Tensuu; i++) {
			t[i].heikou_idou(x, y);
		}
	}

	public void set(Tensyuugou ts) {
		Tensuu = ts.getTensuu();
		Bousuu = ts.getBousuu();
		Mensuu = ts.getMensuu();
		for (int i = 0; i <= Tensuu; i++) {
			t[i].set(ts.getTen(i));                                                         //  <<<-------
			for (int j = 1; j <= ts.get_T_renketu(i, 0); j++) {
				set_T_renketu(i, j, ts.get_T_renketu(i, j));
			}
		}
		for (int i = 0; i <= Bousuu; i++) {
			b[i].set(ts.getBou(i));
			Bou_moti_Menid_min[i] = ts.get_Bou_moti_Menid_min(i);
			Bou_moti_Menid_max[i] = ts.get_Bou_moti_Menid_max(i);
		}
		for (int i = 0; i <= Mensuu; i++) {
			m[i] = new Men(ts.getMen(i));
			for (int j = 0; j <= Mensuu; j++) {
				Men_tonari[i][j] = ts.get_Men_tonari(i, j);
			}
		}
	}

	public void set(int i, Ten tn) {
		t[i].set(tn);
	}                                               //  <<<-------

	private int get_Men_tonari(int i, int j) {
		return Men_tonari[i][j];
	}

	//
	private int get_Bou_moti_Menid_min(int i) {
		return Bou_moti_Menid_min[i];
	}

	//
	private int get_Bou_moti_Menid_max(int i) {
		return Bou_moti_Menid_max[i];
	}

	//
	private double get_Bou_x_max(int i) {
		return Bou_x_max[i];
	}

	//
	private double get_Bou_x_min(int i) {
		return Bou_x_min[i];
	}

	//
	private double get_Bou_y_max(int i) {
		return Bou_y_max[i];
	}

	//
	private double get_Bou_y_min(int i) {
		return Bou_y_min[i];
	}

	//
	private double get_Men_x_max(int i) {
		return Men_x_max[i];
	}

	//
	private double get_Men_x_min(int i) {
		return Men_x_min[i];
	}

	//
	private double get_Men_y_max(int i) {
		return Men_y_max[i];
	}

	//
	private double get_Men_y_min(int i) {
		return Men_y_min[i];
	}

	//�_���ʂ̓����ɂ��邩�ǂ����𔻒肷��?B0�Ȃ�����ɂȂ�?A1�Ȃ狫�E?�?�?A2�Ȃ����
	public int kantan_naibu(Ten p, int n) {      //0=�O��?A?@1=���E?A?@2=����
		//System.out.println("2016");
		if (p.getx() + 0.5 < Men_x_min[n]) {
			return 0;
		}
		if (p.getx() - 0.5 > Men_x_max[n]) {
			return 0;
		}
		if (p.gety() + 0.5 < Men_y_min[n]) {
			return 0;
		}
		if (p.gety() - 0.5 > Men_y_max[n]) {
			return 0;
		}
		//System.out.println("2017");
		return naibu(p, m[n]);
	}

	//�_���ʂ̓����ɂ��邩�ǂ����𔻒肷��?B
	public int naibu(Ten p, int n) {      //0=�O��?A?@1=���E?A?@2=����
		return naibu(p, m[n]);
	}

	//�_���ʂ̓����ɂ��邩�ǂ����𔻒肷��?B0�Ȃ�����ɂȂ�?A1�Ȃ狫�E?�?�?A2�Ȃ����
	private int naibu(Ten p, Men mn) {      //0=�O��?A?@1=���E?A?@2=����
		Takakukei tk;
		tk = makeTakakukei(mn);
		return tk.naibu(p);
	}

	//�_���ǂ̖ʂ̓����ɂ��邩�ǂ����𔻒肷��?B0�Ȃ�ǂ̖ʂ̓����ɂ��Ȃ�?A�}�C�i�X�Ȃ狫�E?�?�?A?���?��Ȃ����?B�Y������ʔ�?�����?�����?�?��͔�?���?������ق����Ԃ����?B
	public int naibu(Ten p) {
		for (int i = 1; i <= getMensuu(); i++) {
			if (naibu(p, i) == 2) {
				return i;
			}
			if (naibu(p, i) == 1) {
				return -i;
			}
		}
		return 0;
	}


	//Men �𑽊p�`�ɂ���
	private Takakukei makeTakakukei(Men mn) {
		Takakukei tk = new Takakukei(mn.getTenidsuu());
		tk.setkakusuu(mn.getTenidsuu());
		for (int i = 0; i <= mn.getTenidsuu(); i++) {
			tk.set(i, t[mn.getTenid(i)]);
		}
		return tk;
	}

	//?���s0�̈ꕔ�ł��ʑ��p�`�̖ʂ̓���?i���E?��͓����Ƃ݂Ȃ��Ȃ�?j��
	//��?݂���Ƃ�1?A���Ȃ��Ȃ�0��Ԃ�?B�ʂ������p�`��?�?��͌��ʂ����������Ȃ�̂Ŏg��Ȃ�����
	public int kantan_totu_naibu(int ib, int im) {
		//�o�O������悤��������?C�������?�����
		if (Bou_x_max[ib] + 0.5 < Men_x_min[im]) {
			return 0;
		}
		if (Bou_x_min[ib] - 0.5 > Men_x_max[im]) {
			return 0;
		}
		if (Bou_y_max[ib] + 0.5 < Men_y_min[im]) {
			return 0;
		}
		if (Bou_y_min[ib] - 0.5 > Men_y_max[im]) {
			return 0;
		}

		return totu_naibu(new Senbun(t[b[ib].getmae()], t[b[ib].getato()]), m[im]);
	}

	private int totu_naibu(Senbun s0, Men mn) {
		Takakukei tk;//=new Takakukei();
		tk = makeTakakukei(mn);
		return tk.totu_naibu(s0);
	}

	private int totu_naibu(int ib, int im) {
		return totu_naibu(new Senbun(t[b[ib].getmae()], t[b[ib].getato()]), m[im]);
	}

	public int totu_naibu(double d, int ib, int im) {
		Senbun sn = new Senbun(t[b[ib].getmae()], t[b[ib].getato()]);
		return totu_naibu(oc.mayoko_idou(sn, d), m[im]);
	}

	private int kantan_totu_naibu(double d, int ib, int im) {
		Senbun sn = new Senbun(t[b[ib].getmae()], t[b[ib].getato()]);
		Senbun snm = oc.mayoko_idou(sn, d);
		double s_x_max = snm.getax();
		double s_x_min = snm.getax();
		double s_y_max = snm.getay();
		double s_y_min = snm.getay();
		if (s_x_max < snm.getbx()) {
			s_x_max = snm.getbx();
		}
		if (s_x_min > snm.getbx()) {
			s_x_min = snm.getbx();
		}
		if (s_y_max < snm.getby()) {
			s_y_max = snm.getby();
		}
		if (s_y_min > snm.getby()) {
			s_y_min = snm.getby();
		}

		if (s_x_max + 0.5 < Men_x_min[im]) {
			return 0;
		}
		if (s_x_min - 0.5 > Men_x_max[im]) {
			return 0;
		}
		if (s_y_max + 0.5 < Men_y_min[im]) {
			return 0;
		}
		if (s_y_min - 0.5 > Men_y_max[im]) {
			return 0;
		}

		return totu_naibu(snm, m[im]);
	}


	//�_��?����ɂ���
	private Senbun Bou2Senbun(Bou bu) {
		return new Senbun(t[bu.getmae()], t[bu.getato()]);
	}

	//2��Bou����?s�ňꕔ�܂��͑S����?d�Ȃ�Ƃ���1?A�����łȂ����0��������?B1�_��?d�Ȃ�?�?���0��Ԃ�?B
	public int heikou_kasanai(int ib1, int ib2) {
		int skh;
		skh = oc.senbun_kousa_hantei(Bou2Senbun(b[ib1]), Bou2Senbun(b[ib2]));
		if (skh == 31) {
			return 1;
		}
		if (skh == 321) {
			return 1;
		}
		if (skh == 322) {
			return 1;
		}
		if (skh == 331) {
			return 1;
		}
		if (skh == 332) {
			return 1;
		}
		if (skh == 341) {
			return 1;
		}
		if (skh == 342) {
			return 1;
		}
		if (skh == 351) {
			return 1;
		}
		if (skh == 352) {
			return 1;
		}

		if (skh == 361) {
			return 1;
		}
		if (skh == 362) {
			return 1;
		}
		if (skh == 363) {
			return 1;
		}
		if (skh == 364) {
			return 1;
		}

		if (skh == 371) {
			return 1;
		}
		if (skh == 372) {
			return 1;
		}
		if (skh == 373) {
			return 1;
		}
		if (skh == 374) {
			return 1;
		}

		return 0;
	}


	//�ʂ̓����̓_���?�߂�
	public Ten naibuTen_motome(int n) {
		return naibuTen_motome(m[n]);
	}

	//�ʂ̓����̓_���?�߂�
	private Ten naibuTen_motome(Men mn) {
		Takakukei tk;
		tk = makeTakakukei(mn);
		return tk.naibuTen_motome();
	}

	//��?ϋ?�߂�
	public double menseki_motome(int n) {
		return menseki_motome(m[n]);
	}


	private double menseki_motome(Men mn) {
		Takakukei tk;
		tk = makeTakakukei(mn);
		return tk.menseki_motome();
	}

	public int getTensuu() {
		return Tensuu;
	}   //�_�̑??��𓾂�

	public int getBousuu() {
		return Bousuu;
	}   //�_�̑??��𓾂�

	public int getMensuu() {
		return Mensuu;
	}   //�ʂ̑??��𓾂�

	public int getTenid(int i, int j) {
		return m[i].getTenid(j);
	}  // void setTensuu(int i){Tensuu=i;}

	// void setBousuu(int i){Bousuu=i;}       
	public double getTenx(int i) {
		return t[i].getx();
	}

	public double getTeny(int i) {
		return t[i].gety();
	}

	public Ten getTen(int i) {
		return t[i];
	}   //�_�𓾂�       <<<------------t��?A�X?[�p?[�N���X��Ten�̃T�u�N���XTen_P�N���X�̃I�u�W�F�N�g?B�X?[�p?[�N���X�̕�?��ɃT�u�N���X�̃I�u�W�F�N�g�����\�Ȃ̂�?A���̂܂܎g��?B

	private Bou getBou(int i) {
		return b[i];
	}   //�_�𓾂�

	public Ten get_maeTen_from_Bou_id(int i) {
		return t[getmae(i)];
	}    //�_��id����O�_�𓾂�              <<<------------?@?@��?�

	public Ten get_atoTen_from_Bou_id(int i) {
		return t[getato(i)];
	}    //�_��id�����_�𓾂�              <<<------------?@?@��?�


	public Senbun get_Senbun_from_Bou_id(int i) {
		return Bou2Senbun(getBou(i));
	}    //�_��id����Senbun�𓾂�

	private Men getMen(int i) {
		return m[i];
	}   //�ʂ𓾂�

	public int getmae(int i) {
		return b[i].getmae();
	} //�_��id����O�_��id�𓾂�

	public int getato(int i) {
		return b[i].getato();
	} //�_��id�����_��id�𓾂�

	public double getmaex(int i) {
		return t[b[i].getmae()].getx();
	}

	public double getmaey(int i) {
		return t[b[i].getmae()].gety();
	}

	public double getatox(int i) {
		return t[b[i].getato()].getx();
	}

	public double getatoy(int i) {
		return t[b[i].getato()].gety();
	}

	public int getTenidsuu(int i) {
		return m[i].getTenidsuu();
	}

	public void setTen(int i, Ten tn) {
		t[i].set(tn);
	}                                                        //   <<<------------

	private void setTen(int i, double x, double y) {
		t[i].set(x, y);
	}

	public void addTen(double x, double y) {
		Tensuu = Tensuu + 1;
		t[Tensuu].set(x, y);
	}   //�_��������

	public void addBou(int i, int j, int icol) {
		Bousuu = Bousuu + 1;
		b[Bousuu].set(i, j, icol);
	}   //�_��������

	//i�Ԗڂ̖_��?F���?o�͂���
	private void setcolor(int i, int icol) {
		b[i].setcolor(icol);
	}

	public int getcolor(int i) {
		return b[i].getcolor();
	}

	private void t_renketu_sakusei() {
		for (int k = 1; k <= Bousuu; k++) {
			set_T_renketu(b[k].getmae(), 0, get_T_renketu(b[k].getmae(), 0) + 1);
			set_T_renketu(b[k].getmae(), get_T_renketu(b[k].getmae(), 0), b[k].getato());
			set_T_renketu(b[k].getato(), 0, get_T_renketu(b[k].getato(), 0) + 1);
			set_T_renketu(b[k].getato(), get_T_renketu(b[k].getato(), 0), b[k].getmae());
		}
	}

	//�_i�Ɠ_j���_�ŘA�����Ă����1?A���Ă��Ȃ����0��Ԃ�?B
	private int renketu_hantei(int i, int j) {
		for (int k = 1; k <= Bousuu; k++) {
			if (
					((b[k].getmae() == i) && (b[k].getato() == j))
							||
							((b[k].getmae() == j) && (b[k].getato() == i))
			) {
				return 1;
			}
		}
		return 0;
	}

	//�_i����_j��?i���?A����?A�_j����_i�̉E�ׂ�?i�ގ��̓_�̔�?����?�߂�?B
	private int getRTen(int i, int j) {
		int n = 0;
		double kakudo = 876.0;   //kakudo�͓K���ȑ傫��?��ɂ��Ă���

		// if(renketu_hantei(i,j)==0){return 0;}//�_i�Ɠ_j���A�����Ă��Ȃ�����0��Ԃ�

		int iflg = 0;
		for (int k = 1; k <= get_T_renketu(i, 0); k++) {
			if (get_T_renketu(i, k) == j) {
				iflg = 1;
			}
		}

		if (iflg == 0) {
			return 0;
		}//�_i�Ɠ_j���A�����Ă��Ȃ�����0��Ԃ�

		for (int ik = 1; ik <= get_T_renketu(j, 0); ik++) {
			int k;
			k = get_T_renketu(j, ik);
			if (k != i) {
				if (oc.kakudo(t[j], t[i], t[j], t[k]) <= kakudo) {
					n = k;
					kakudo = oc.kakudo(t[j], t[i], t[j], t[k]);
				}
			}
		}
		return n; //�_j�ɘA�����Ă���_���_i�����Ȃ�����0��Ԃ�
	}
	//--------------------------------    

	private Men Men_motome(int i, int j) {//i�Ԗڂ̓_?Aj�Ԗڂ̓_����?��߂ĉE���̖_�����ǂ��Ėʂ��?�߂�
		Men mtemp = new Men();
		//mtemp.reset();       
		mtemp.addTenid(i);
		mtemp.addTenid(j);
		int nextT = 0;

		nextT = getRTen(mtemp.getTenid(1), mtemp.getTenid(2));
		while (nextT != mtemp.getTenid(1)) {
			if (nextT == 0) {
				mtemp.reset();
				return mtemp;
			}//�G��?[���̑Ή�
			mtemp.addTenid(nextT);
			nextT = getRTen(mtemp.getTenid(mtemp.getTenidsuu() - 1), mtemp.getTenid(mtemp.getTenidsuu()));
		}
		mtemp.seiretu();
		return mtemp;
	}

	//-------------------------------------
	public void Menhassei() {
		int flag1;
		Men mtemp = new Men();
		Mensuu = 0;
		t_renketu_sakusei();

		for (int i = 1; i <= Bousuu; i++) {
			//System.out.print("�ʔ�?�?@???@"+i+"    ");System.out.println(Mensuu);

			//
			mtemp = Men_motome(b[i].getmae(), b[i].getato());
			flag1 = 0;   //?@0�Ȃ�ʂ�ǉ�����?B1�Ȃ�?@�ʂ�ǉ����Ȃ�?B
			for (int j = 1; j <= Mensuu; j++) {
				if (onaji_ka_hantei(mtemp, m[j]) == 1) {
					flag1 = 1;
					break;
				}
			}

			if (((flag1 == 0) && (mtemp.getTenidsuu() != 0)) &&
					(menseki_motome(mtemp) > 0.0)) {
				addMen(mtemp);
			}
			//

			mtemp = Men_motome(b[i].getato(), b[i].getmae());
			flag1 = 0;   //?@0�Ȃ�ʂ�ǉ�����?B1�Ȃ�?@�ʂ�ǉ����Ȃ�?B
			for (int j = 1; j <= Mensuu; j++) {
				if (onaji_ka_hantei(mtemp, m[j]) == 1) {
					flag1 = 1;
					break;
				}
			}

			if (((flag1 == 0) && (mtemp.getTenidsuu() != 0)) && (menseki_motome(mtemp) > 0.0)) {
				//System.out.println("�ʔ�?���?[�v��?@003");
				addMen(mtemp);
				//System.out.println("�ʔ�?���?[�v��?@004");
			}

			//-----
			//	if(Mensuu%20==0){
			//		System.out.print("?��܂łɔ�?�������?�?@???@");System.out.println(Mensuu);
			//	}
		}

		System.out.print("�S��?�?@???@");
		System.out.println(Mensuu);
		Men_tonari_sakusei();

		//Bou�̗����̖ʂ̓o�^
		for (int ib = 1; ib <= Bousuu; ib++) {

			Bou_moti_Menid_min[ib] = Bou_moti_Menid_min_sagasi(ib);
			Bou_moti_Menid_max[ib] = Bou_moti_Menid_max_sagasi(ib);
		}
	}

	//Bou��Men��?��W��?ő�l?A?�?��l���?�߂�?Bkantan_totu_naibu��?��ɂ̂ݗp����?Bkantan_totu_naibu��?����g���Ȃ�?܂�?��?��薈�ɂ��K�v����?B
	public void BouMenMaxMinZahyou() {
		//Bou��?��W��?ő�?�?����?�߂�?i����͂����ł����?ABou��������ꂽ����ɂ��ق����悢�����m��Ȃ�?B?j
		for (int ib = 1; ib <= Bousuu; ib++) {

			Bou_x_max[ib] = t[b[ib].getmae()].getx();
			Bou_x_min[ib] = t[b[ib].getmae()].getx();
			Bou_y_max[ib] = t[b[ib].getmae()].gety();
			Bou_y_min[ib] = t[b[ib].getmae()].gety();

			if (Bou_x_max[ib] < t[b[ib].getato()].getx()) {
				Bou_x_max[ib] = t[b[ib].getato()].getx();
			}
			if (Bou_x_min[ib] > t[b[ib].getato()].getx()) {
				Bou_x_min[ib] = t[b[ib].getato()].getx();
			}
			if (Bou_y_max[ib] < t[b[ib].getato()].gety()) {
				Bou_y_max[ib] = t[b[ib].getato()].gety();
			}
			if (Bou_y_min[ib] > t[b[ib].getato()].gety()) {
				Bou_y_min[ib] = t[b[ib].getato()].gety();
			}
			MenMaxMinZahyou();
		}
	}

	private void MenMaxMinZahyou() {
		//Men��?��W��?ő�?�?����?�߂�
		for (int im = 1; im <= Mensuu; im++) {
			Men_x_max[im] = t[m[im].getTenid(1)].getx();
			Men_x_min[im] = t[m[im].getTenid(1)].getx();
			Men_y_max[im] = t[m[im].getTenid(1)].gety();
			Men_y_min[im] = t[m[im].getTenid(1)].gety();
			for (int i = 2; i <= m[im].getTenidsuu(); i++) {
				if (Men_x_max[im] < t[m[im].getTenid(i)].getx()) {
					Men_x_max[im] = t[m[im].getTenid(i)].getx();
				}
				if (Men_x_min[im] > t[m[im].getTenid(i)].getx()) {
					Men_x_min[im] = t[m[im].getTenid(i)].getx();
				}
				if (Men_y_max[im] < t[m[im].getTenid(i)].gety()) {
					Men_y_max[im] = t[m[im].getTenid(i)].gety();
				}
				if (Men_y_min[im] > t[m[im].getTenid(i)].gety()) {
					Men_y_min[im] = t[m[im].getTenid(i)].gety();
				}
			}
		}
	}


	public Ten get_men_migiue_Ten(int im) {//im�͖ʔ�?�?@?Bmigiue	�w�肳�ꂽ��?��̖ʂ��܂�?�?��̒����`�̉E?�̒��_��Ԃ�?B?@?܂�?オ��?}�̗���?}�̈ʒu�w��Ɏg��?B
		//Men��?��W��?ő�?�?����?�߂�

		double x_max = t[m[im].getTenid(1)].getx();
		double x_min = t[m[im].getTenid(1)].getx();
		double y_max = t[m[im].getTenid(1)].gety();
		double y_min = t[m[im].getTenid(1)].gety();
		for (int i = 2; i <= m[im].getTenidsuu(); i++) {
			if (x_max < t[m[im].getTenid(i)].getx()) {
				x_max = t[m[im].getTenid(i)].getx();
			}
			if (x_min > t[m[im].getTenid(i)].getx()) {
				x_min = t[m[im].getTenid(i)].getx();
			}
			if (y_max < t[m[im].getTenid(i)].gety()) {
				y_max = t[m[im].getTenid(i)].gety();
			}
			if (y_min > t[m[im].getTenid(i)].gety()) {
				y_min = t[m[im].getTenid(i)].gety();
			}
		}

		return new Ten(x_max, y_min);

	}


	//--------------
	//�_ib�����E�Ƃ��Ċ܂ޖ�(?ő��2�ʂ���)�̂�����Menid��?������ق���Menid��Ԃ�?B�_�����E�Ƃ��Ċ܂ޖʂ�����?�?���0��Ԃ�
	private int Bou_moti_Menid_min_sagasi(int ib) {
		for (int im = 1; im <= Mensuu; im++) {
			if (Bou_moti_hantei(im, ib) == 1) {
				return im;
			}
		}
		return 0;
	}

	//�_ib�����E�Ƃ��Ċ܂ޖ�(?ő��2�ʂ���)�̂�����Menid�̑傫���ق���Menid��Ԃ�?B�_�����E�Ƃ��Ċ܂ޖʂ�����?�?���0��Ԃ�
	private int Bou_moti_Menid_max_sagasi(int ib) {
		for (int im = Mensuu; im >= 1; im--) {
			if (Bou_moti_hantei(im, ib) == 1) {
				return im;
			}
		}
		return 0;
	}

	//---------------

	//�_ib�����E�Ƃ��Ċ܂ޖ�(?ő��2�ʂ���)�̂�����Menid��?������ق���Menid��Ԃ�?B�_�����E�Ƃ��Ċ܂ޖʂ�����?�?���0��Ԃ�
	public int Bou_moti_Menid_min_motome(int ib) {
		return Bou_moti_Menid_min[ib];
	}

	//�_ib�����E�Ƃ��Ċ܂ޖ�(?ő��2�ʂ���)�̂�����Menid�̑傫���ق���Menid��Ԃ�?B�_�����E�Ƃ��Ċ܂ޖʂ�����?�?���0��Ԃ�
	public int Bou_moti_Menid_max_motome(int ib) {
		return Bou_moti_Menid_max[ib];
	}

	//---------------
	private int onaji_ka_hantei(Men m, Men n) { //�����Ȃ�1?A�Ⴄ�Ȃ�0��Ԃ�

		if (m.getTenidsuu() != n.getTenidsuu()) {
			return 0;
		}

		for (int i = 1; i <= m.getTenidsuu(); i++) {
			if (m.getTenid(i) != n.getTenid(i)) {
				return 0;
			}
		}

		return 1;

	}

	//Men[im]�̋��E��Ten[it]���܂܂��Ȃ�1?A�܂܂�Ȃ��Ȃ�0��Ԃ�
	public int Ten_moti_hantei(int im, int it) {
		for (int i = 1; i <= m[im].getTenidsuu(); i++) {
			if (it == m[im].getTenid(i)) {
				return 1;
			}
		}
		return 0;
	}

	//Men[im]�̋��E��Bou[ib]���܂܂��Ȃ�1?A�܂܂�Ȃ��Ȃ�0��Ԃ�
	private int Bou_moti_hantei(int im, int ib) {
		for (int i = 1; i <= m[im].getTenidsuu() - 1; i++) {
			if ((b[ib].getmae() == m[im].getTenid(i)) && (b[ib].getato() == m[im].getTenid(i + 1))) {
				return 1;
			}
			if ((b[ib].getato() == m[im].getTenid(i)) && (b[ib].getmae() == m[im].getTenid(i + 1))) {
				return 1;
			}
		}
		if ((b[ib].getmae() == m[im].getTenid(m[im].getTenidsuu())) && (b[ib].getato() == m[im].getTenid(1))) {
			return 1;
		}
		if ((b[ib].getato() == m[im].getTenid(m[im].getTenidsuu())) && (b[ib].getmae() == m[im].getTenid(1))) {
			return 1;
		}

		return 0;
	}

	//------------------------------------------------------
	private void Men_tonari_sakusei() {
		System.out.println("�ʂƂȂ�?�?�?@�J�n");
		for (int im = 1; im <= Mensuu - 1; im++) {
			for (int in = im + 1; in <= Mensuu; in++) {
				Men_tonari[im][in] = 0;
				Men_tonari[in][im] = 0;
				int ima, imb, ina, inb;
				for (int iim = 1; iim <= m[im].getTenidsuu(); iim++) {
					ima = m[im].getTenid(iim);
					if (iim == m[im].getTenidsuu()) {
						imb = m[im].getTenid(1);
					} else {
						imb = m[im].getTenid(iim + 1);
					}
					//imb=m[im].getTenid((iim+1)%m[im].getTenidsuu());

					for (int iin = 1; iin <= m[in].getTenidsuu(); iin++) {
						ina = m[in].getTenid(iin);

						if (iin == m[in].getTenidsuu()) {
							inb = m[in].getTenid(1);
						} else {
							inb = m[in].getTenid(iin + 1);
						}


						//inb=m[in].getTenid((iin+1)%m[in].getTenidsuu());
						if (((ima == ina) && (imb == inb)) || ((ima == inb) && (imb == ina))) {
							int ib;
							ib = Bou_sagasi(ima, imb);
							Men_tonari[im][in] = ib;
							Men_tonari[in][im] = ib;
						}
					}
				}

			}
		}
		System.out.println("�ʂƂȂ�?�?�?@?I��");
	}

	//�_t1��t2���܂�Bou�̔�?���Ԃ�
	private int Bou_sagasi(int t1, int t2) {
		for (int i = 1; i <= Bousuu; i++) {
			if ((b[i].getmae() == t1) && (b[i].getato() == t2)) {
				return i;
			}
			if ((b[i].getmae() == t2) && (b[i].getato() == t1)) {
				return i;
			}
		}
		return 0;
	}

	//Men[im]��Men[ib]����?ڂ���Ȃ炻�̋��E�ɂ���_��id��?���Ԃ�?B��?ڂ��Ȃ��Ȃ�0��Ԃ�
	public int Men_tonari_hantei(int im, int in) {
		/*
		for(int i=1;i<=Bousuu;i++){
       	        	if(( Bou_moti_hantei( im,i)==1)&&( Bou_moti_hantei( in,i)==1)){return i;}
		}
		return 0;
		*/
		return Men_tonari[im][in];
	}

	//
	private void addMen(Men mtemp) {
		Mensuu = Mensuu + 1;
//System.out.println("�_?W?�?FaddMen 1   Mensuu = "+Mensuu+"  Msuu = "+Msuu_temp );

		m[Mensuu].reset();
		//for (int i=0; i<50; i++ ){m[Mensuu].setTenid(i,mtemp.getTenid(i));}
//System.out.println("�_?W?�?FaddMen 2   Mensuu = "+  Mensuu    );
		for (int i = 1; i <= mtemp.getTenidsuu(); i++) {
			m[Mensuu].addTenid(mtemp.getTenid(i));
		}
//System.out.println("�_?W?�?FaddMen 3   Mensuu = "+  Mensuu );
		m[Mensuu].setcolor(mtemp.getcolor());
		//m[Mensuu].setTenidsuu(mtemp.getTenidsuu());

	}

	//�^����ꂽ?��W�ƈ��̋������߂��ߖT�ɂ�����?A����?ł��߂��_�̔�?���Ԃ�?B����?A���̋����ȓ���Ten���Ȃ��Ȃ�0��Ԃ�?B
	public int mottomo_tikai_Tenid(Ten p, double r) {
		int ireturn = 0;
		double rmin = 1000000.0;
		double rtemp;
		for (int i = 1; i <= Tensuu; i++) {
			rtemp = oc.kyori(p, t[i]);
			if (rtemp < r) {
				if (rtemp < rmin) {
					rmin = rtemp;
					ireturn = i;
				}
			}
		}
		return ireturn;
	}


	//�^����ꂽ?��W�ƈ��̋������߂��ߖT�ɂ�����?A����?ł��߂��_�̋�����Ԃ�?B����?A���̋����ȓ���Ten���Ȃ��Ȃ�1000000.0��Ԃ�?B
	public double mottomo_tikai_Ten_kyori(Ten p, double r) {
		int ireturn = 0;
		double rmin = 1000000.0;
		double rtemp;
		for (int i = 1; i <= Tensuu; i++) {
			rtemp = oc.kyori(p, t[i]);
			if (rtemp < r) {
				if (rtemp < rmin) {
					rmin = rtemp;
					ireturn = i;
				}
			}
		}
		return rmin;
	}


	//���̋������߂��ʒu�֌W�ɂ���Ten���m�̈ʒu��?A���ɔ�?��̎Ⴂ���̈ʒu�ɂ���?B
	public void Ten_awase(double r) {
		//int ireturn=0;double rmin=10000.0; double rtemp;
		//System.out.println(" Ten_awase  Tensuu="+Tensuu );


		for (int i = 1; i <= Tensuu - 1; i++) {
			for (int j = i + 1; j <= Tensuu; j++) {
				if (oc.kyori(t[i], t[j]) < r) {
					t[j].set(t[i]);
				}
				//System.out.println(" Ten_awase  r="+r+" , i="+i+" , j="+j+" , kyori="+oc.kyori(t[i],t[j]) );


			}
		}
		//  return ireturn;
	}

	//Ten�����̋������Bou�ɋ߂��ʒu�֌W�ɂ���Ƃ�?ATen�̈ʒu��?Abou��?�ɂ̂�悤�ɂ���?B
	public void Ten_Bou_awase(double r) {
		//int ireturn=0;double rmin=10000.0; double rtemp;
		for (int ib = 1; ib <= Bousuu; ib++) {
			//   Senbun s =new Senbun();
			//     s.set( Bou2Senbun(b[ib])) ;
			for (int i = 1; i <= Tensuu - 1; i++) {
				if (oc.kyori_senbun(t[i], t[b[ib].getmae()], t[b[ib].getato()]) < r) {
					//Tyokusen ty =new Tyokusen(t[b[ib].getmae()],t[b[ib].getato()]);
					//t[i].set( oc.kage_motome(ty,t[i]));
					t[i].set(oc.kage_motome(t[b[ib].getmae()], t[b[ib].getato()], t[i]));
				}
			}
		}
		//  return ireturn;
	}

	//--------------------
	public int get_ten_sentakusuu() {
		int r_int = 0;
		for (int i = 1; i <= Tensuu; i++) {

			if (t[i].get_ten_sentaku() == 1) {
				r_int = r_int + 1;
			}

		}
		return r_int;
	}

	//--------------------
	public void set_ten_sentaku_1(int i) {
		t[i].set_ten_sentaku_1();
	}

	//--------------------
	public void set_ten_sentaku_0(int i) {
		t[i].set_ten_sentaku_0();
	}

	//--------------------
	public void set_all_ten_sentaku_0() {
		for (int i = 1; i <= Tensuu; i++) {
			t[i].set_ten_sentaku_0();
		}
	}


	//--------------------
	public void change_ten_sentaku(int i) {
		if (t[i].get_ten_sentaku() == 1) {
			t[i].set_ten_sentaku_0();
		} else if (t[i].get_ten_sentaku() == 0) {
			t[i].set_ten_sentaku_1();
		}
	}

	//--------------------
	public byte get_ten_sentaku(int i) {
		return t[i].get_ten_sentaku();
	}


	//--------------------
	public void sentaku_ten_move(Ten p) {
		for (int i = 1; i <= Tensuu; i++) {

			if (t[i].get_ten_sentaku() == 1) {
				set(i, p);
			}

		}

	}

	//--------------------
	public void sentaku_ten_move(Ten ugokasu_maeno_sentaku_ten, Ten pa, Ten pb) {
		Ten p_u = new Ten();
		p_u.set(ugokasu_maeno_sentaku_ten.getx(), ugokasu_maeno_sentaku_ten.gety());
		p_u.idou(pa.tano_Ten_iti(pb));

		for (int i = 1; i <= Tensuu; i++) {
			if (t[i].get_ten_sentaku() == 1) {
				set(i, p_u);
			}
		}
	}

	//--------------------


/*

		for(int i=1;i<=Tensuu;i++){
			if(t[i].get_ten_sentaku()==1){
				set(i,p_u);
			}
		}
*/


	//?���?W?��̑S?�����?��� Memo�Ƃ���?o�͂���?B //undo,redo�̋L�^�p�Ɏg��
	public Memo getMemo() {
		String str = "";//������?��?�p�̃N���X�̃C���X�^���X��

		Memo memo1 = new Memo();
		memo1.reset();

		memo1.addGyou("<�_>");

		for (int i = 1; i <= Tensuu; i++) {
			memo1.addGyou("��?�," + i);
			memo1.addGyou("?��W," + str.valueOf(t[i].getx()) + "," + str.valueOf(t[i].gety()));
		}
		memo1.addGyou("</�_>");


		return memo1;
	}

	// -----------------------------------------------------
	public void setMemo(Memo memo1) {
		//?�?��ɓ_�̑??����?�߂�

		int yomiflg = 0;//0�Ȃ�ǂ�?��݂�?s��Ȃ�?B1�Ȃ�ǂ�?���?B
		int ibangou = 0;
		Double Dd = new Double(0.0);
		Integer Ii = new Integer(0);

		int iten = 0;

		String str = "";
		double ax, ay;

		for (int i = 1; i <= memo1.getGyousuu(); i++) {

			StringTokenizer tk = new StringTokenizer(memo1.getGyou(i), ",");
			//jtok=    tk.countTokens();

			str = tk.nextToken();
			if (str.equals("<�_>")) {
				yomiflg = 1;
			} else if (str.equals("</�_>")) {
				yomiflg = 0;
			}
			if ((yomiflg == 1) && (str.equals("��?�"))) {
				iten = iten + 1;
			}
		}
		//sousuu =isen;
		//?�?��ɕ�?�?����̑??����?�߂�ꂽ

		for (int i = 1; i <= memo1.getGyousuu(); i++) {


			StringTokenizer tk = new StringTokenizer(memo1.getGyou(i), ",");
			//jtok=    tk.countTokens();
			str = tk.nextToken();
			//  	System.out.println("::::::::::"+ str+"<<<<<" );
			if (str.equals("<�_>")) {
				yomiflg = 1;
			}
			if ((yomiflg == 1) && (str.equals("��?�"))) {
				str = tk.nextToken();
				ibangou = Integer.parseInt(str);
			}
			if ((yomiflg == 1) && (str.equals("?��W"))) {
				str = tk.nextToken();
				ax = Double.parseDouble(str);
				str = tk.nextToken();
				ay = Double.parseDouble(str);
				t[ibangou].set(ax, ay);
			}


		}


	}


//-----------------------------


}
