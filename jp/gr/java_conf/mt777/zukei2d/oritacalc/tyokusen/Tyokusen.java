package jp.gr.java_conf.mt777.zukei2d.oritacalc.tyokusen;

import jp.gr.java_conf.mt777.zukei2d.senbun.Senbun;

public class Tyokusen {
	//�?��?Ip1=p2��?�?��͌��ʂ����������Ȃ邪���̊�?��Ƀ`�F�b�N�@?\���Ȃ��̂�?A�C�Â��ɂ�������?B
	//a��0��?�?B����a??0�Ȃ�?Ab��0��?�ɂȂ�悤�ɂ��邱��?B�������Ȃ���?A��?��Ƃ̋����̕�?������������Ȃ�?B
	double a, b, c;//a*x+b*y+c=0,  a,b,c,x,y,��?�?��Ƃ��Ĉ���(20181115���̃R�?���g���������̂ł�?H)

	public Tyokusen() {  //�R���X�g���N�^
		double x1 = 0.0;
		double y1 = 0.0;
		double x2 = 1.0;
		double y2 = 1.0;

		a = y2 - y1;
		b = x1 - x2;
		c = y1 * x2 - x1 * y2;
		keisuu_totonoe();
	}

	public Tyokusen(double a0, double b0, double c0) {  //�R���X�g���N�^
		a = a0;
		b = b0;
		c = c0;
		keisuu_totonoe();
	}


	public Tyokusen(Ten p1, Ten p2) {  //�R���X�g���N�^
		//��_���w�肵�Ē�?���a,b,c���?�߂�
		double x1 = p1.getx(), y1 = p1.gety();
		double x2 = p2.getx(), y2 = p2.gety();
		a = y2 - y1;
		b = x1 - x2;
		c = y1 * x2 - x1 * y2;
		keisuu_totonoe();
	}


	public Tyokusen(Senbun s0) {  //�R���X�g���N�^
		//Senbun���w�肵�Ē�?���a,b,c���?�߂�
		double x1 = s0.getax(), y1 = s0.getay();
		double x2 = s0.getbx(), y2 = s0.getby();
		a = y2 - y1;
		b = x1 - x2;
		c = y1 * x2 - x1 * y2;
		keisuu_totonoe();
	}


	public Tyokusen(double x1, double y1, double x2, double y2) {  //�R���X�g���N�^
		//��_���w�肵�Ē�?���a,b,c���?�߂�

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


	//��?s�ړ�
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

	public double kyorikeisan(Ten p) {//��?��Ɠ_p�Ƃ̋���
		double x = p.getx();
		double y = p.gety();
		//return Math.abs((double) ((float)(a*x+b*y+c)/Math.sqrt((float)(a*a+b*b))));
		return Math.abs((a * x + b * y + c) / Math.sqrt(a * a + b * b));
	}


	public double kyori_2jyou_keisan(Ten p) {//��?��Ɠ_p�Ƃ̋����̓�?�
		double x = p.getx();
		double y = p.gety();
		//return Math.abs((double) ((float)(a*x+b*y+c)/Math.sqrt((float)(a*a+b*b))));
		return (a * x + b * y + c) * (a * x + b * y + c) / (a * a + b * b);
	}


	public void tyokkouka(Ten p) { //�_?ix,y)��ʂ��� ax+by+c=0�ɒ������钼?� (bx-ay+d=0)�ɕϊ�
		double e;
		double x = p.getx();
		double y = p.gety();
		c = -b * x + a * y;
		e = a;
		a = b;
		b = -e;

		keisuu_totonoe();
	}


	public int onajigawa(Ten p1, Ten p2) {//2�_����?��̓������Ȃ�P?A�ʂ̑��Ȃ�-1?A��?�?�̓_������Ȃ�O��Ԃ�
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
	}  //a*x+b*y+c��x,y���������l��Ԃ�

	/*
        public int senbun_kousa_hantei(Senbun s0){//0=���̒�?��͗^����ꂽ?����ƌ�?����Ȃ�?A1=X�^�Ō�?�����?A2=T�^�Ō�?�����?A3=?����͒�?��Ɋ܂܂��?B
            double d_a=dainyuukeisan(s0.geta());
            double d_b=dainyuukeisan(s0.getb());

            if(d_a*d_b>0.0){return 0;}
            if(d_a*d_b<0.0){return 1;}
            if(d_a==0.0&&d_b!=0){return 2;}
            if(d_a!=0.0&&d_b==0){return 2;}

            return 3;

        }
    */
	public int senbun_kousa_hantei_kuwasii(Senbun s0) {//0=���̒�?��͗^����ꂽ?����ƌ�?����Ȃ�?A1=X�^�Ō�?�����?A21=?�����a�_��T�^�Ō�?�����?A22=?�����b�_��T�^�Ō�?�����?A3=?����͒�?��Ɋ܂܂��?B


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


		//�ȉ���?�����a�_��b�_����?�?�ɂ͂Ȃ��Ɣ��f�����?�?�

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


	//���̒�?��Ƃ̌�_���?�߂��?�?@20170312�ǉ�
	public Ten kouten_motome(Tyokusen t2) {
		double a1 = a, b1 = b, c1 = c;//��?�t1, a1*x+b1*y+c1=0�̊e�W?����?�߂�?B
		double a2 = t2.geta(), b2 = t2.getb(), c2 = t2.getc();//��?�t2, a2*x+b2*y+c2=0�̊e�W?����?�߂�?B

		return new Ten((b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1), (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1));
	}


	//��?�?�̓_p�̉e�̈ʒu?i�_p��?ł��߂���?�?�̈ʒu?j���?�߂�?B?@20170312�ǉ�
	public Ten kage_motome(Ten p) {
		Tyokusen t1 = new Tyokusen(a, b, c);
		t1.tyokkouka(p);//�_p1��ʂ��� t�ɒ�?s���钼?����?�߂�?B
		return kouten_motome(t1);
	}


}

















