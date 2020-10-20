package jp.gr.java_conf.mt777.zukei2d.oritacalc.tyokusen;

import jp.gr.java_conf.mt777.zukei2d.senbun.Senbun;

public class Tyokusen {
	//’?ˆÓ?Ip1=p2‚Ì?ê?‡‚ÍŒ‹‰Ê‚ª‚¨‚©‚µ‚­‚È‚é‚ª‚±‚ÌŠÖ?”‚Éƒ`ƒFƒbƒN‹@?\‚ª‚È‚¢‚Ì‚Å?A‹C‚Ã‚«‚É‚­‚¢‚©‚à?B
	//a‚Í0ˆÈ?ã?B‚à‚µa??0‚È‚ç?Ab‚ª0ˆÈ?ã‚É‚È‚é‚æ‚¤‚É‚·‚é‚±‚Æ?B‚±‚¤‚µ‚È‚¢‚Æ?A’¼?ü‚Æ‚Ì‹——£‚Ì•„?†‚ª‚¨‚©‚µ‚­‚È‚é?B
	double a, b, c;//a*x+b*y+c=0,  a,b,c,x,y,‚Í?®?”‚Æ‚µ‚Äˆµ‚¤(20181115‚±‚ÌƒRƒ?ƒ“ƒg‚¨‚©‚µ‚¢‚Ì‚Å‚Í?H)

	public Tyokusen() {  //ƒRƒ“ƒXƒgƒ‰ƒNƒ^
		double x1 = 0.0;
		double y1 = 0.0;
		double x2 = 1.0;
		double y2 = 1.0;

		a = y2 - y1;
		b = x1 - x2;
		c = y1 * x2 - x1 * y2;
		keisuu_totonoe();
	}

	public Tyokusen(double a0, double b0, double c0) {  //ƒRƒ“ƒXƒgƒ‰ƒNƒ^
		a = a0;
		b = b0;
		c = c0;
		keisuu_totonoe();
	}


	public Tyokusen(Ten p1, Ten p2) {  //ƒRƒ“ƒXƒgƒ‰ƒNƒ^
		//“ñ“_‚ðŽw’è‚µ‚Ä’¼?ü‚Ìa,b,c‚ð‹?‚ß‚é
		double x1 = p1.getx(), y1 = p1.gety();
		double x2 = p2.getx(), y2 = p2.gety();
		a = y2 - y1;
		b = x1 - x2;
		c = y1 * x2 - x1 * y2;
		keisuu_totonoe();
	}


	public Tyokusen(Senbun s0) {  //ƒRƒ“ƒXƒgƒ‰ƒNƒ^
		//Senbun‚ðŽw’è‚µ‚Ä’¼?ü‚Ìa,b,c‚ð‹?‚ß‚é
		double x1 = s0.getax(), y1 = s0.getay();
		double x2 = s0.getbx(), y2 = s0.getby();
		a = y2 - y1;
		b = x1 - x2;
		c = y1 * x2 - x1 * y2;
		keisuu_totonoe();
	}


	public Tyokusen(double x1, double y1, double x2, double y2) {  //ƒRƒ“ƒXƒgƒ‰ƒNƒ^
		//“ñ“_‚ðŽw’è‚µ‚Ä’¼?ü‚Ìa,b,c‚ð‹?‚ß‚é

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


	//•½?sˆÚ“®
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

	public double kyorikeisan(Ten p) {//’¼?ü‚Æ“_p‚Æ‚Ì‹——£
		double x = p.getx();
		double y = p.gety();
		//return Math.abs((double) ((float)(a*x+b*y+c)/Math.sqrt((float)(a*a+b*b))));
		return Math.abs((a * x + b * y + c) / Math.sqrt(a * a + b * b));
	}


	public double kyori_2jyou_keisan(Ten p) {//’¼?ü‚Æ“_p‚Æ‚Ì‹——£‚Ì“ñ?æ
		double x = p.getx();
		double y = p.gety();
		//return Math.abs((double) ((float)(a*x+b*y+c)/Math.sqrt((float)(a*a+b*b))));
		return (a * x + b * y + c) * (a * x + b * y + c) / (a * a + b * b);
	}


	public void tyokkouka(Ten p) { //“_?ix,y)‚ð’Ê‚Á‚Ä ax+by+c=0‚É’¼Œð‚·‚é’¼?ü (bx-ay+d=0)‚É•ÏŠ·
		double e;
		double x = p.getx();
		double y = p.gety();
		c = -b * x + a * y;
		e = a;
		a = b;
		b = -e;

		keisuu_totonoe();
	}


	public int onajigawa(Ten p1, Ten p2) {//2“_‚ª’¼?ü‚Ì“¯‚¶‘¤‚È‚ç‚P?A•Ê‚Ì‘¤‚È‚ç-1?A’¼?ü?ã‚Ì“_‚ª‚ ‚é‚È‚ç‚O‚ð•Ô‚·
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
	}  //a*x+b*y+c‚Éx,y‚ð‘ã“ü‚µ‚½’l‚ð•Ô‚·

	/*
        public int senbun_kousa_hantei(Senbun s0){//0=‚±‚Ì’¼?ü‚Í—^‚¦‚ç‚ê‚½?ü•ª‚ÆŒð?·‚µ‚È‚¢?A1=XŒ^‚ÅŒð?·‚·‚é?A2=TŒ^‚ÅŒð?·‚·‚é?A3=?ü•ª‚Í’¼?ü‚ÉŠÜ‚Ü‚ê‚é?B
            double d_a=dainyuukeisan(s0.geta());
            double d_b=dainyuukeisan(s0.getb());

            if(d_a*d_b>0.0){return 0;}
            if(d_a*d_b<0.0){return 1;}
            if(d_a==0.0&&d_b!=0){return 2;}
            if(d_a!=0.0&&d_b==0){return 2;}

            return 3;

        }
    */
	public int senbun_kousa_hantei_kuwasii(Senbun s0) {//0=‚±‚Ì’¼?ü‚Í—^‚¦‚ç‚ê‚½?ü•ª‚ÆŒð?·‚µ‚È‚¢?A1=XŒ^‚ÅŒð?·‚·‚é?A21=?ü•ª‚Ìa“_‚ÅTŒ^‚ÅŒð?·‚·‚é?A22=?ü•ª‚Ìb“_‚ÅTŒ^‚ÅŒð?·‚·‚é?A3=?ü•ª‚Í’¼?ü‚ÉŠÜ‚Ü‚ê‚é?B


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


		//ˆÈ‰º‚Í?ü•ª‚Ìa“_‚àb“_‚à’¼?ü?ã‚É‚Í‚È‚¢‚Æ”»’f‚³‚ê‚é?ê?‡

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


	//‘¼‚Ì’¼?ü‚Æ‚ÌŒð“_‚ð‹?‚ß‚éŠÖ?”?@20170312’Ç‰Á
	public Ten kouten_motome(Tyokusen t2) {
		double a1 = a, b1 = b, c1 = c;//’¼?üt1, a1*x+b1*y+c1=0‚ÌŠeŒW?”‚ð‹?‚ß‚é?B
		double a2 = t2.geta(), b2 = t2.getb(), c2 = t2.getc();//’¼?üt2, a2*x+b2*y+c2=0‚ÌŠeŒW?”‚ð‹?‚ß‚é?B

		return new Ten((b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1), (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1));
	}


	//’¼?ü?ã‚Ì“_p‚Ì‰e‚ÌˆÊ’u?i“_p‚Æ?Å‚à‹ß‚¢’¼?ü?ã‚ÌˆÊ’u?j‚ð‹?‚ß‚é?B?@20170312’Ç‰Á
	public Ten kage_motome(Ten p) {
		Tyokusen t1 = new Tyokusen(a, b, c);
		t1.tyokkouka(p);//“_p1‚ð’Ê‚Á‚Ä t‚É’¼?s‚·‚é’¼?ü‚ð‹?‚ß‚é?B
		return kouten_motome(t1);
	}


}

















