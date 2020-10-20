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

	int Tensuu;               //ŽÀ?Û‚ÉŽg‚¤“_‚Ì‘??”
	int Bousuu;               //ŽÀ?Û‚ÉŽg‚¤–_‚Ì‘??”
	int Mensuu;               //ŽÀ?Û‚ÉŽg‚¤–Ê‚Ì‘??”
	Ten_p[] t;//“_‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»
	Bou[] b;//–_‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»
	int[] Bou_moti_Menid_min;
	int[] Bou_moti_Menid_max;

	Men[] m;//–Ê‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»

	double[] Bou_x_max;
	double[] Bou_x_min;
	double[] Bou_y_max;
	double[] Bou_y_min;

	double[] Men_x_max;
	double[] Men_x_min;
	double[] Men_y_max;
	double[] Men_y_min;

	OritaCalc oc = new OritaCalc();          //ŠeŽíŒvŽZ—p‚ÌŠÖ?”‚ðŽg‚¤‚½‚ß‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»
	ArrayList[] T_renketu;//t_renketu[i][j]‚Ít[i]‚É˜AŒˆ‚µ‚Ä‚¢‚éTen‚Ì”Ô?†?Bt[0]‚É‚Í?ATem‚Ì?”‚ðŠi”[?B

	int[][] Men_tonari;//Men_tonari[i][j]‚Ím[i]‚Æm[j]‚Ì‹«ŠE‚ÌBou‚Ì”Ô?†?Bm[i]‚Æm[j]‚ª—×‚è?‡‚í‚È‚¢‚Æ‚«‚Í0‚ðŠi”[?B

	public Tensyuugou() {
		reset();
	} //ƒRƒ“ƒXƒgƒ‰ƒNƒ^

	//---------------------------------------
	public void reset() {
		Tensuu = 0;
		Bousuu = 0;
		Mensuu = 0;
	}

	//---------------------------------------
	public void settei(int Tsuu, int Bsuu, int Msuu) { //?Å?‰‚âƒŠƒZƒbƒg‚ÌŒã‚É‚Í•K‚¸’Ê‚é‚æ‚¤‚É‚·‚é?B

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
		}//‚±‚Ì•¶‚ª‚È‚¢‚Æ‚¤‚Ü‚­?s‚©‚È‚¢?B‚È‚º‚±‚Ì•¶‚Å‚È‚¢‚Æ‚¢‚¯‚È‚¢‚©‚Æ‚¢‚¤—?—R‚ª?³Šm‚É‚Í‚í‚©‚ç‚È‚¢?B
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
        public void Iti_sitei(double x,double y){//‘STen‚Ì?d?S‚ÌˆÊ’u‚ðŽw’è‚³‚ê‚½?À•W‚É‚·‚é?B
            double xh,yh;
            xh= getHeikinZahyou_x();
            yh= getHeikinZahyou_y();
            heikou_idou(x-xh,y-yh)  ;
        }
    */
	//
	public void uragaesi() {//?d?S‚ÌˆÊ’u‚ð’†?S‚É?¶‰E‚É— •Ô‚·?B
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


	//public double menseki(int men_id) {return 1.0; }//   –Ê‚Ì–Ê?Ï‚ð•Ô‚·


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

	//“_‚ª–Ê‚Ì“à•”‚É‚ ‚é‚©‚Ç‚¤‚©‚ð”»’è‚·‚é?B0‚È‚ç“à•”‚É‚È‚¢?A1‚È‚ç‹«ŠE?ü?ã?A2‚È‚ç“à•”
	public int kantan_naibu(Ten p, int n) {      //0=ŠO•”?A?@1=‹«ŠE?A?@2=“à•”
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

	//“_‚ª–Ê‚Ì“à•”‚É‚ ‚é‚©‚Ç‚¤‚©‚ð”»’è‚·‚é?B
	public int naibu(Ten p, int n) {      //0=ŠO•”?A?@1=‹«ŠE?A?@2=“à•”
		return naibu(p, m[n]);
	}

	//“_‚ª–Ê‚Ì“à•”‚É‚ ‚é‚©‚Ç‚¤‚©‚ð”»’è‚·‚é?B0‚È‚ç“à•”‚É‚È‚¢?A1‚È‚ç‹«ŠE?ü?ã?A2‚È‚ç“à•”
	private int naibu(Ten p, Men mn) {      //0=ŠO•”?A?@1=‹«ŠE?A?@2=“à•”
		Takakukei tk;
		tk = makeTakakukei(mn);
		return tk.naibu(p);
	}

	//“_‚ª‚Ç‚Ì–Ê‚Ì“à•”‚É‚ ‚é‚©‚Ç‚¤‚©‚ð”»’è‚·‚é?B0‚È‚ç‚Ç‚Ì–Ê‚Ì“à•”‚É‚à‚È‚¢?Aƒ}ƒCƒiƒX‚È‚ç‹«ŠE?ü?ã?A?³‚Ì?”‚È‚ç“à•”?BŠY“–‚·‚é–Ê”Ô?†‚ª•¡?”‚ ‚é?ê?‡‚Í”Ô?†‚Ì?¬‚³‚¢‚Ù‚¤‚ª•Ô‚³‚ê‚é?B
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


	//Men ‚ð‘½ŠpŒ`‚É‚·‚é
	private Takakukei makeTakakukei(Men mn) {
		Takakukei tk = new Takakukei(mn.getTenidsuu());
		tk.setkakusuu(mn.getTenidsuu());
		for (int i = 0; i <= mn.getTenidsuu(); i++) {
			tk.set(i, t[mn.getTenid(i)]);
		}
		return tk;
	}

	//?ü•ªs0‚Ìˆê•”‚Å‚à“Ê‘½ŠpŒ`‚Ì–Ê‚Ì“à•”?i‹«ŠE?ü‚Í“à•”‚Æ‚Ý‚È‚³‚È‚¢?j‚É
	//‘¶?Ý‚·‚é‚Æ‚«1?A‚µ‚È‚¢‚È‚ç0‚ð•Ô‚·?B–Ê‚ª‰š‘½ŠpŒ`‚Ì?ê?‡‚ÍŒ‹‰Ê‚ª‚¨‚©‚µ‚­‚È‚é‚Ì‚ÅŽg‚í‚È‚¢‚±‚Æ
	public int kantan_totu_naibu(int ib, int im) {
		//ƒoƒO‚ª‚ ‚é‚æ‚¤‚¾‚Á‚½‚ª?C‘½•ªŽæ‚è?œ‚¯‚½
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


	//–_‚ð?ü•ª‚É‚·‚é
	private Senbun Bou2Senbun(Bou bu) {
		return new Senbun(t[bu.getmae()], t[bu.getato()]);
	}

	//2‚Â‚ÌBou‚ª•½?s‚Åˆê•”‚Ü‚½‚Í‘S•”‚Å?d‚È‚é‚Æ‚«‚Í1?A‚»‚¤‚Å‚È‚¯‚ê‚Î0‚ð‚©‚¦‚·?B1“_‚Å?d‚È‚é?ê?‡‚Í0‚ð•Ô‚·?B
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


	//–Ê‚Ì“à•”‚Ì“_‚ð‹?‚ß‚é
	public Ten naibuTen_motome(int n) {
		return naibuTen_motome(m[n]);
	}

	//–Ê‚Ì“à•”‚Ì“_‚ð‹?‚ß‚é
	private Ten naibuTen_motome(Men mn) {
		Takakukei tk;
		tk = makeTakakukei(mn);
		return tk.naibuTen_motome();
	}

	//–Ê?Ï‹?‚ß‚é
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
	}   //“_‚Ì‘??”‚ð“¾‚é

	public int getBousuu() {
		return Bousuu;
	}   //–_‚Ì‘??”‚ð“¾‚é

	public int getMensuu() {
		return Mensuu;
	}   //–Ê‚Ì‘??”‚ð“¾‚é

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
	}   //“_‚ð“¾‚é       <<<------------t‚Í?AƒX?[ƒp?[ƒNƒ‰ƒX‚ÌTen‚ÌƒTƒuƒNƒ‰ƒXTen_PƒNƒ‰ƒX‚ÌƒIƒuƒWƒFƒNƒg?BƒX?[ƒp?[ƒNƒ‰ƒX‚Ì•Ï?”‚ÉƒTƒuƒNƒ‰ƒX‚ÌƒIƒuƒWƒFƒNƒg‚ð‘ã“ü‰Â”\‚È‚Ì‚Å?A‚±‚Ì‚Ü‚ÜŽg‚¤?B

	private Bou getBou(int i) {
		return b[i];
	}   //–_‚ð“¾‚é

	public Ten get_maeTen_from_Bou_id(int i) {
		return t[getmae(i)];
	}    //–_‚Ìid‚©‚ç‘O“_‚ð“¾‚é              <<<------------?@?@“¯?ã

	public Ten get_atoTen_from_Bou_id(int i) {
		return t[getato(i)];
	}    //–_‚Ìid‚©‚çŒã“_‚ð“¾‚é              <<<------------?@?@“¯?ã


	public Senbun get_Senbun_from_Bou_id(int i) {
		return Bou2Senbun(getBou(i));
	}    //–_‚Ìid‚©‚çSenbun‚ð“¾‚é

	private Men getMen(int i) {
		return m[i];
	}   //–Ê‚ð“¾‚é

	public int getmae(int i) {
		return b[i].getmae();
	} //–_‚Ìid‚©‚ç‘O“_‚Ìid‚ð“¾‚é

	public int getato(int i) {
		return b[i].getato();
	} //–_‚Ìid‚©‚çŒã“_‚Ìid‚ð“¾‚é

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
	}   //“_‚ð‰Á‚¦‚é

	public void addBou(int i, int j, int icol) {
		Bousuu = Bousuu + 1;
		b[Bousuu].set(i, j, icol);
	}   //–_‚ð‰Á‚¦‚é

	//i”Ô–Ú‚Ì–_‚Ì?F‚ð“ü?o—Í‚·‚é
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

	//“_i‚Æ“_j‚ª–_‚Å˜AŒ‹‚µ‚Ä‚¢‚ê‚Î1?A‚µ‚Ä‚¢‚È‚¯‚ê‚Î0‚ð•Ô‚·?B
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

	//“_i‚©‚ç“_j‚É?i‚ñ‚Å?AŽŸ‚É?A“_j‚©‚ç“_i‚Ì‰E—×‚É?i‚ÞŽž‚Ì“_‚Ì”Ô?†‚ð‹?‚ß‚é?B
	private int getRTen(int i, int j) {
		int n = 0;
		double kakudo = 876.0;   //kakudo‚Í“K“–‚È‘å‚«‚¢?”‚É‚µ‚Ä‚¨‚­

		// if(renketu_hantei(i,j)==0){return 0;}//“_i‚Æ“_j‚ª˜AŒ‹‚µ‚Ä‚¢‚È‚¢Žž‚Í0‚ð•Ô‚·

		int iflg = 0;
		for (int k = 1; k <= get_T_renketu(i, 0); k++) {
			if (get_T_renketu(i, k) == j) {
				iflg = 1;
			}
		}

		if (iflg == 0) {
			return 0;
		}//“_i‚Æ“_j‚ª˜AŒ‹‚µ‚Ä‚¢‚È‚¢Žž‚Í0‚ð•Ô‚·

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
		return n; //“_j‚É˜AŒ‹‚µ‚Ä‚¢‚é“_‚ª“_i‚µ‚©‚È‚¢Žž‚Í0‚ð•Ô‚·
	}
	//--------------------------------    

	private Men Men_motome(int i, int j) {//i”Ô–Ú‚Ì“_?Aj”Ô–Ú‚Ì“_‚©‚ç?‰‚ß‚Ä‰E‘¤‚Ì–_‚ð‚½‚Ç‚Á‚Ä–Ê‚ð‹?‚ß‚é
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
			}//ƒGƒ‰?[Žž‚Ì‘Î‰ž
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
			//System.out.print("–Ê”­?¶?@???@"+i+"    ");System.out.println(Mensuu);

			//
			mtemp = Men_motome(b[i].getmae(), b[i].getato());
			flag1 = 0;   //?@0‚È‚ç–Ê‚ð’Ç‰Á‚·‚é?B1‚È‚ç?@–Ê‚ð’Ç‰Á‚µ‚È‚¢?B
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
			flag1 = 0;   //?@0‚È‚ç–Ê‚ð’Ç‰Á‚·‚é?B1‚È‚ç?@–Ê‚ð’Ç‰Á‚µ‚È‚¢?B
			for (int j = 1; j <= Mensuu; j++) {
				if (onaji_ka_hantei(mtemp, m[j]) == 1) {
					flag1 = 1;
					break;
				}
			}

			if (((flag1 == 0) && (mtemp.getTenidsuu() != 0)) && (menseki_motome(mtemp) > 0.0)) {
				//System.out.println("–Ê”­?¶ƒ‹?[ƒv“à?@003");
				addMen(mtemp);
				//System.out.println("–Ê”­?¶ƒ‹?[ƒv“à?@004");
			}

			//-----
			//	if(Mensuu%20==0){
			//		System.out.print("?¡‚Ü‚Å‚É”­?¶‚µ‚½–Ê?”?@???@");System.out.println(Mensuu);
			//	}
		}

		System.out.print("‘S–Ê?”?@???@");
		System.out.println(Mensuu);
		Men_tonari_sakusei();

		//Bou‚Ì—¼‘¤‚Ì–Ê‚Ì“o˜^
		for (int ib = 1; ib <= Bousuu; ib++) {

			Bou_moti_Menid_min[ib] = Bou_moti_Menid_min_sagasi(ib);
			Bou_moti_Menid_max[ib] = Bou_moti_Menid_max_sagasi(ib);
		}
	}

	//Bou‚âMen‚Ì?À•W‚Ì?Å‘å’l?A?Å?¬’l‚ð‹?‚ß‚é?Bkantan_totu_naibuŠÖ?”‚É‚Ì‚Ý—p‚¢‚é?Bkantan_totu_naibuŠÖ?”‚ðŽg‚¤‚È‚ç?Ü‚è?ô‚Ý?„’è–ˆ‚É‚â‚é•K—v‚ ‚è?B
	public void BouMenMaxMinZahyou() {
		//Bou‚Ì?À•W‚Ì?Å‘å?Å?¬‚ð‹?‚ß‚é?i‚±‚ê‚Í‚±‚±‚Å‚â‚é‚æ‚è?ABou‚ª‰Á‚¦‚ç‚ê‚½’¼Œã‚É‚â‚é‚Ù‚¤‚ª‚æ‚¢‚©‚à’m‚ê‚È‚¢?B?j
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
		//Men‚Ì?À•W‚Ì?Å‘å?Å?¬‚ð‹?‚ß‚é
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


	public Ten get_men_migiue_Ten(int im) {//im‚Í–Ê”Ô?†?@?Bmigiue	Žw’è‚³‚ê‚½”Ô?†‚Ì–Ê‚ðŠÜ‚Þ?Å?¬‚Ì’·•ûŒ`‚Ì‰E?ã‚Ì’¸“_‚ð•Ô‚·?B?@?Ü‚è?ã‚ª‚è?}‚Ì— •Ô?}‚ÌˆÊ’uŽw’è‚ÉŽg‚¤?B
		//Men‚Ì?À•W‚Ì?Å‘å?Å?¬‚ð‹?‚ß‚é

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
	//–_ib‚ð‹«ŠE‚Æ‚µ‚ÄŠÜ‚Þ–Ê(?Å‘å‚Å2–Ê‚ ‚é)‚Ì‚¤‚¿‚ÅMenid‚Ì?¬‚³‚¢‚Ù‚¤‚ÌMenid‚ð•Ô‚·?B–_‚ð‹«ŠE‚Æ‚µ‚ÄŠÜ‚Þ–Ê‚ª–³‚¢?ê?‡‚Í0‚ð•Ô‚·
	private int Bou_moti_Menid_min_sagasi(int ib) {
		for (int im = 1; im <= Mensuu; im++) {
			if (Bou_moti_hantei(im, ib) == 1) {
				return im;
			}
		}
		return 0;
	}

	//–_ib‚ð‹«ŠE‚Æ‚µ‚ÄŠÜ‚Þ–Ê(?Å‘å‚Å2–Ê‚ ‚é)‚Ì‚¤‚¿‚ÅMenid‚Ì‘å‚«‚¢‚Ù‚¤‚ÌMenid‚ð•Ô‚·?B–_‚ð‹«ŠE‚Æ‚µ‚ÄŠÜ‚Þ–Ê‚ª–³‚¢?ê?‡‚Í0‚ð•Ô‚·
	private int Bou_moti_Menid_max_sagasi(int ib) {
		for (int im = Mensuu; im >= 1; im--) {
			if (Bou_moti_hantei(im, ib) == 1) {
				return im;
			}
		}
		return 0;
	}

	//---------------

	//–_ib‚ð‹«ŠE‚Æ‚µ‚ÄŠÜ‚Þ–Ê(?Å‘å‚Å2–Ê‚ ‚é)‚Ì‚¤‚¿‚ÅMenid‚Ì?¬‚³‚¢‚Ù‚¤‚ÌMenid‚ð•Ô‚·?B–_‚ð‹«ŠE‚Æ‚µ‚ÄŠÜ‚Þ–Ê‚ª–³‚¢?ê?‡‚Í0‚ð•Ô‚·
	public int Bou_moti_Menid_min_motome(int ib) {
		return Bou_moti_Menid_min[ib];
	}

	//–_ib‚ð‹«ŠE‚Æ‚µ‚ÄŠÜ‚Þ–Ê(?Å‘å‚Å2–Ê‚ ‚é)‚Ì‚¤‚¿‚ÅMenid‚Ì‘å‚«‚¢‚Ù‚¤‚ÌMenid‚ð•Ô‚·?B–_‚ð‹«ŠE‚Æ‚µ‚ÄŠÜ‚Þ–Ê‚ª–³‚¢?ê?‡‚Í0‚ð•Ô‚·
	public int Bou_moti_Menid_max_motome(int ib) {
		return Bou_moti_Menid_max[ib];
	}

	//---------------
	private int onaji_ka_hantei(Men m, Men n) { //“¯‚¶‚È‚ç1?Aˆá‚¤‚È‚ç0‚ð•Ô‚·

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

	//Men[im]‚Ì‹«ŠE‚ÉTen[it]‚ªŠÜ‚Ü‚ê‚é‚È‚ç1?AŠÜ‚Ü‚ê‚È‚¢‚È‚ç0‚ð•Ô‚·
	public int Ten_moti_hantei(int im, int it) {
		for (int i = 1; i <= m[im].getTenidsuu(); i++) {
			if (it == m[im].getTenid(i)) {
				return 1;
			}
		}
		return 0;
	}

	//Men[im]‚Ì‹«ŠE‚ÉBou[ib]‚ªŠÜ‚Ü‚ê‚é‚È‚ç1?AŠÜ‚Ü‚ê‚È‚¢‚È‚ç0‚ð•Ô‚·
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
		System.out.println("–Ê‚Æ‚È‚è?ì?¬?@ŠJŽn");
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
		System.out.println("–Ê‚Æ‚È‚è?ì?¬?@?I—¹");
	}

	//“_t1‚Æt2‚ðŠÜ‚ÞBou‚Ì”Ô?†‚ð•Ô‚·
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

	//Men[im]‚ÆMen[ib]‚ª—×?Ú‚·‚é‚È‚ç‚»‚Ì‹«ŠE‚É‚ ‚é–_‚Ìid”Ô?†‚ð•Ô‚·?B—×?Ú‚µ‚È‚¢‚È‚ç0‚ð•Ô‚·
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
//System.out.println("“_?W?‡?FaddMen 1   Mensuu = "+Mensuu+"  Msuu = "+Msuu_temp );

		m[Mensuu].reset();
		//for (int i=0; i<50; i++ ){m[Mensuu].setTenid(i,mtemp.getTenid(i));}
//System.out.println("“_?W?‡?FaddMen 2   Mensuu = "+  Mensuu    );
		for (int i = 1; i <= mtemp.getTenidsuu(); i++) {
			m[Mensuu].addTenid(mtemp.getTenid(i));
		}
//System.out.println("“_?W?‡?FaddMen 3   Mensuu = "+  Mensuu );
		m[Mensuu].setcolor(mtemp.getcolor());
		//m[Mensuu].setTenidsuu(mtemp.getTenidsuu());

	}

	//—^‚¦‚ç‚ê‚½?À•W‚Æˆê’è‚Ì‹——£‚æ‚è‹ß‚¢‹ß–T‚É‚ ‚Á‚Ä?A‚©‚Â?Å‚à‹ß‚¢“_‚Ì”Ô?†‚ð•Ô‚·?B‚à‚µ?Aˆê’è‚Ì‹——£ˆÈ“à‚ÉTen‚ª‚È‚¢‚È‚ç0‚ð•Ô‚·?B
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


	//—^‚¦‚ç‚ê‚½?À•W‚Æˆê’è‚Ì‹——£‚æ‚è‹ß‚¢‹ß–T‚É‚ ‚Á‚Ä?A‚©‚Â?Å‚à‹ß‚¢“_‚Ì‹——£‚ð•Ô‚·?B‚à‚µ?Aˆê’è‚Ì‹——£ˆÈ“à‚ÉTen‚ª‚È‚¢‚È‚ç1000000.0‚ð•Ô‚·?B
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


	//ˆê’è‚Ì‹——£‚æ‚è‹ß‚¢ˆÊ’uŠÖŒW‚É‚ ‚éTen“¯Žm‚ÌˆÊ’u‚ð?A‹¤‚É”Ô?†‚ÌŽá‚¢•û‚ÌˆÊ’u‚É‚·‚é?B
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

	//Ten‚ªˆê’è‚Ì‹——£‚æ‚èBou‚É‹ß‚¢ˆÊ’uŠÖŒW‚É‚ ‚é‚Æ‚«?ATen‚ÌˆÊ’u‚ð?Abou‚Ì?ã‚É‚Ì‚é‚æ‚¤‚É‚·‚é?B
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


	//?ü•ª?W?‡‚Ì‘S?ü•ª‚Ì?î•ñ‚ð Memo‚Æ‚µ‚Ä?o—Í‚·‚é?B //undo,redo‚Ì‹L˜^—p‚ÉŽg‚¤
	public Memo getMemo() {
		String str = "";//•¶Žš—ñ?ˆ—?—p‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»

		Memo memo1 = new Memo();
		memo1.reset();

		memo1.addGyou("<“_>");

		for (int i = 1; i <= Tensuu; i++) {
			memo1.addGyou("”Ô?†," + i);
			memo1.addGyou("?À•W," + str.valueOf(t[i].getx()) + "," + str.valueOf(t[i].gety()));
		}
		memo1.addGyou("</“_>");


		return memo1;
	}

	// -----------------------------------------------------
	public void setMemo(Memo memo1) {
		//?Å?‰‚É“_‚Ì‘??”‚ð‹?‚ß‚é

		int yomiflg = 0;//0‚È‚ç“Ç‚Ý?ž‚Ý‚ð?s‚í‚È‚¢?B1‚È‚ç“Ç‚Ý?ž‚Þ?B
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
			if (str.equals("<“_>")) {
				yomiflg = 1;
			} else if (str.equals("</“_>")) {
				yomiflg = 0;
			}
			if ((yomiflg == 1) && (str.equals("”Ô?†"))) {
				iten = iten + 1;
			}
		}
		//sousuu =isen;
		//?Å?‰‚É•â?•?ü•ª‚Ì‘??”‚ª‹?‚ß‚ç‚ê‚½

		for (int i = 1; i <= memo1.getGyousuu(); i++) {


			StringTokenizer tk = new StringTokenizer(memo1.getGyou(i), ",");
			//jtok=    tk.countTokens();
			str = tk.nextToken();
			//  	System.out.println("::::::::::"+ str+"<<<<<" );
			if (str.equals("<“_>")) {
				yomiflg = 1;
			}
			if ((yomiflg == 1) && (str.equals("”Ô?†"))) {
				str = tk.nextToken();
				ibangou = Integer.parseInt(str);
			}
			if ((yomiflg == 1) && (str.equals("?À•W"))) {
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
