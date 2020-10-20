package jp.gr.java_conf.mt777.zukei2d.oritacalc.tyokusen;

import jp.gr.java_conf.mt777.zukei2d.senbun.Senbun;
import jp.gr.java_conf.mt777.zukei2d.ten.Ten;

public class Tyokusen {
	//??意?Ip1=p2の???№ﾍ結果がおかしくなるがこの関?狽ﾉチェック機?\がないので?A気づきにくいかも?B
	//aは0以???Bもしa??0なら?Abが0以?繧ﾉなるようにすること?Bこうしないと?A直??との距離の符??がおかしくなる?B
	double a, b, c;//a*x+b*y+c=0,  a,b,c,x,y,は?ｮ?狽ﾆして扱う(20181115このコ??ントおかしいのでは?H)

	public Tyokusen() {  //コンストラクタ
		double x1 = 0.0;
		double y1 = 0.0;
		double x2 = 1.0;
		double y2 = 1.0;

		a = y2 - y1;
		b = x1 - x2;
		c = y1 * x2 - x1 * y2;
		keisuu_totonoe();
	}

	public Tyokusen(double a0, double b0, double c0) {  //コンストラクタ
		a = a0;
		b = b0;
		c = c0;
		keisuu_totonoe();
	}


	public Tyokusen(Ten p1, Ten p2) {  //コンストラクタ
		//二点を指定して直??のa,b,cを??める
		double x1 = p1.getx(), y1 = p1.gety();
		double x2 = p2.getx(), y2 = p2.gety();
		a = y2 - y1;
		b = x1 - x2;
		c = y1 * x2 - x1 * y2;
		keisuu_totonoe();
	}


	public Tyokusen(Senbun s0) {  //コンストラクタ
		//Senbunを指定して直??のa,b,cを??める
		double x1 = s0.getax(), y1 = s0.getay();
		double x2 = s0.getbx(), y2 = s0.getby();
		a = y2 - y1;
		b = x1 - x2;
		c = y1 * x2 - x1 * y2;
		keisuu_totonoe();
	}


	public Tyokusen(double x1, double y1, double x2, double y2) {  //コンストラクタ
		//二点を指定して直??のa,b,cを??める

		a = y2 - y1;
		b = x1 - x2;
		c = y1 * x2 - x1 * y2;
		keisuu_totonoe();
	}

	//
	void keisuu_totonoe() {
		if ((a < 0.0)) {
			a = -a;
			b = -b;
			c = -c;
		}
		//	if((a==0.0)&&(b<0.0)){
		if ((-0.1 < a) && (a < 0.1)) {
			if (b < 0.0) {
				a = -a;
				b = -b;
				c = -c;
			}
		}
	}


	public void hyouji(String str0) {
		System.out.println(str0 + "   " + a + " x + " + b + " y + " + c + " = 0.0 ");
	}


	//平?s移動
	public void heikouidou(double d) {
		c = c + d * Math.sqrt(a * a + b * b);
	}

	//
	public void set(Tyokusen t) {
		a = t.geta();
		b = t.getb();
		c = t.getc();
		keisuu_totonoe();
	}

	//

	public void seta(double a0) {
		a = a0;
	}

	public void setb(double b0) {
		a = b0;
	}

	public void setc(double c0) {
		a = c0;
	}

	public double geta() {
		return a;
	}

	public double getb() {
		return b;
	}

	public double getc() {
		return c;
	}

	public double kyorikeisan(Ten p) {//直??と点pとの距離
		double x = p.getx();
		double y = p.gety();
		//return Math.abs((double) ((float)(a*x+b*y+c)/Math.sqrt((float)(a*a+b*b))));
		return Math.abs((a * x + b * y + c) / Math.sqrt(a * a + b * b));
	}


	public double kyori_2jyou_keisan(Ten p) {//直??と点pとの距離の二??
		double x = p.getx();
		double y = p.gety();
		//return Math.abs((double) ((float)(a*x+b*y+c)/Math.sqrt((float)(a*a+b*b))));
		return (a * x + b * y + c) * (a * x + b * y + c) / (a * a + b * b);
	}


	public void tyokkouka(Ten p) { //点?ix,y)を通って ax+by+c=0に直交する直?? (bx-ay+d=0)に変換
		double e;
		double x = p.getx();
		double y = p.gety();
		c = -b * x + a * y;
		e = a;
		a = b;
		b = -e;

		keisuu_totonoe();
	}


	public int onajigawa(Ten p1, Ten p2) {//2点が直??の同じ側なら１?A別の側なら-1?A直???繧ﾌ点があるなら０を返す
		double dd = dainyuukeisan(p1) * dainyuukeisan(p2);
		if (dd > 0.0) {
			return 1;
		}
		if (dd < 0.0) {
			return -1;
		}
		return 0;
	}


	public double dainyuukeisan(Ten p) {
		return a * p.getx() + b * p.gety() + c;
	}  //a*x+b*y+cにx,yを代入した値を返す

	/*
        public int senbun_kousa_hantei(Senbun s0){//0=この直??は与えられた??分と交?ｷしない?A1=X型で交?ｷする?A2=T型で交?ｷする?A3=??分は直??に含まれる?B
            double d_a=dainyuukeisan(s0.geta());
            double d_b=dainyuukeisan(s0.getb());

            if(d_a*d_b>0.0){return 0;}
            if(d_a*d_b<0.0){return 1;}
            if(d_a==0.0&&d_b!=0){return 2;}
            if(d_a!=0.0&&d_b==0){return 2;}

            return 3;

        }
    */
	public int senbun_kousa_hantei_kuwasii(Senbun s0) {//0=この直??は与えられた??分と交?ｷしない?A1=X型で交?ｷする?A21=??分のa点でT型で交?ｷする?A22=??分のb点でT型で交?ｷする?A3=??分は直??に含まれる?B


		double d_a2 = kyori_2jyou_keisan(s0.geta());
		double d_b2 = kyori_2jyou_keisan(s0.getb());

		if (d_a2 < 0.00000001 && d_b2 < 0.00000001) {
			return 3;
		}


		if (d_a2 < 0.00000001 && d_b2 >= 0.00000001) {
			return 21;
		}
		if (d_a2 >= 0.00000001 && d_b2 < 0.00000001) {
			return 22;
		}


		//以下は??分のa点もb点も直???繧ﾉはないと判断される????

		double d_a = dainyuukeisan(s0.geta());
		double d_b = dainyuukeisan(s0.getb());

		if (d_a * d_b > 0.0) {
			return 0;
		}
		if (d_a * d_b < 0.0) {
			return 1;
		}


		return 3;

	}


	//他の直??との交点を??める関???@20170312追加
	public Ten kouten_motome(Tyokusen t2) {
		double a1 = a, b1 = b, c1 = c;//直??t1, a1*x+b1*y+c1=0の各係?狽?める?B
		double a2 = t2.geta(), b2 = t2.getb(), c2 = t2.getc();//直??t2, a2*x+b2*y+c2=0の各係?狽?める?B

		return new Ten((b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1), (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1));
	}


	//直???繧ﾌ点pの影の位置?i点pと?ﾅも近い直???繧ﾌ位置?jを??める?B?@20170312追加
	public Ten kage_motome(Ten p) {
		Tyokusen t1 = new Tyokusen(a, b, c);
		t1.tyokkouka(p);//点p1を通って tに直?sする直??を??める?B
		return kouten_motome(t1);
	}


}

















