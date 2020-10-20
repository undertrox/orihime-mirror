package jp.gr.java_conf.mt777.zukei2d.en;

import jp.gr.java_conf.mt777.zukei2d.oritacalc.tyokusen.Tyokusen;
import jp.gr.java_conf.mt777.zukei2d.senbun.Senbun;
import jp.gr.java_conf.mt777.zukei2d.ten.Ten;

import java.awt.*;


//import java.util.*;

public class En {//�_��?��W������x�N�g���Ȃǂ�����킷�Ƃ��ɗp����

    double x, y, r;//��?S��?��W�Ɣ��a

    int icol;//?F�̎w��?@0=black,1=blue,2=red.
    int tpp = 0;//��??�v??�p�e�B�p��???[�^?[
    //Color tpp_color =new Color(100, 200, 200);//��??����???���?F
    Color tpp_color = new Color(100, 200, 200);//��??����???���?F

    public En() {
        x = 0.0;
        y = 0.0;
        r = 0.0;
        icol = 0;
    }//�R���X�g���N�^

    public En(double i, double j, double k, int m) {
        x = i;
        y = j;
        r = k;
        icol = m;
    } //�R���X�g���N�^

    //public En(double a,Ten p,double b,Ten q){x=a*p.getx()+b*q.getx();y=a*p.gety()+b*q.gety();} //�R���X�g���N�^
    public En(Ten tc, double k, int m) {
        x = tc.getx();
        y = tc.gety();
        r = k;
        icol = m;
    } //�R���X�g���N�^

    public En(Senbun s0, int m) {//�R���X�g���N�^ ??���𒼌a�Ƃ���~
        x = (s0.getax() + s0.getbx()) / 2.0;
        y = (s0.getay() + s0.getby()) / 2.0;
        r = s0.getnagasa() / 2.0;
        icol = m;
    }


    public void set(En e) {
        x = e.getx();
        y = e.gety();
        r = e.getr();
        icol = e.getcolor();
        tpp = e.get_tpp();
        tpp_color = e.get_tpp_color();
    }

    public void set(double i, double j, double k, int m) {
        x = i;
        y = j;
        r = k;
        icol = m;
    }

    public void set(Ten tc, double k, int m) {
        x = tc.getx();
        y = tc.gety();
        r = k;
        icol = m;
    }

    public void set(double i, double j, double k) {
        x = i;
        y = j;
        r = k;
    }

    public void set(Senbun s0, int m) {
        x = (s0.getax() + s0.getbx()) / 2.0;
        y = (s0.getay() + s0.getby()) / 2.0;
        r = s0.getnagasa() / 2.0;
        icol = m;
    }

    public void setx(double xx) {
        x = xx;
    }

    public void sety(double yy) {
        y = yy;
    }

    public void setr(double rr) {
        r = rr;
    }

    public double getx() {
        return x;
    }

    public double gety() {
        return y;
    }

    public double getr() {
        return r;
    }

    public void reset() {
        x = 0.0;
        y = 0.0;
        r = 0.0;
        icol = 0;
    }

    public void setcolor(int i) {
        icol = i;
    }

    public int getcolor() {
        return icol;
    }


    public void set_tpp(int i) {
        tpp = i;
    }

    public int get_tpp() {
        return tpp;
    }


    public void set_tpp_color(Color c0) {
        tpp_color = c0;
    }

    //public void set_tpp_color(int iR,int iG,int iB){tpp_color=new Color(iR,iG,iB);}
    public Color get_tpp_color() {
        return tpp_color;
    }
    //public Color get_tpp_color(){return new Color(tpp_color.getRed(),tpp_color.getGreen(),tpp_color.getBlue());}

// int getix(){return (int)x;}
// int getiy(){return (int)y;}

    public void heikou_idou(double x1, double y1) {
        x = x + x1;
        y = y + y1;
    }

    public Ten get_tyuusin() {
        Ten rten = new Ten(getx(), gety());
        return rten;
    }

/*
	//���̓_�Ƃ̋���?idouble?j��??�߂��??----------------------------------------------------
	public double kyori(Ten p){
		//double x1=p.getx(),y1=p.gety();
		//return Math.sqrt((x1-x)*(x1-x)+(y1-y)*(y1-y));

		double x1=p.getx()-x,y1=p.gety()-y;
		return Math.sqrt(x1*x1+y1*y1);

	}



	//���̓_�Ƃ̋�����2???idouble?j��??�߂��??----------------------------------------------------
	public double kyori2jyou(Ten p){
		double x1=p.getx()-x,y1=p.gety()-y;
		return x1*x1+y1*y1;
	}



        //��Ten����??�Ƃ��Ă݂��Ƃ�?A���̓_�̈ʒu��Ten�ŕԂ�?B
	public Ten tano_Ten_iti(Ten taten){
		Ten rten =new Ten();
		rten.setx(taten.getx()-x);
		rten.sety(taten.gety()-y);
		return rten;
	}

	public void idou(Ten addten){
		x=x+addten.getx();
		y=y+addten.gety();
	}
*/

    //���̓_�𔽓]�����??----------------------------------------------------
    public Ten hanten(Ten t0) {//t0��(x,y)�������ʒu�̂Ƃ��̓G��?[�ƂȂ�?B
        double x1 = t0.getx() - x, y1 = t0.gety() - y;
        double d1 = Math.sqrt(x1 * x1 + y1 * y1);
        double d2, x2, y2, x3, y3;


        if (Math.abs(d1 - r) < 0.0000001) {
            return t0;
        }
        d2 = r * r / d1;
        x2 = d2 * x1 / d1;
        y2 = d2 * y1 / d1;
        x3 = x2 + x;
        y3 = y2 + y;
        return new Ten(x3, y3);
    }

    //���̉~���~�ɔ��]�����??----------------------------------------------------
    public En hanten(En e0) {//e0�̉~����(x,y)��ʂ�Ȃ��Ƃ��p?@//e0�̉~����(x,y)��ʂ�Ƃ��̓G��?[�ƂȂ�?B�܂�e0�̉~���̓�����(x,y)������Ƃ����������Ȍ��ʂɂȂ���ۂ�?B
        double x1 = e0.getx() - x, y1 = e0.gety() - y;
        double d1 = Math.sqrt(x1 * x1 + y1 * y1);
        double da1 = d1 - e0.getr();
        double db1 = d1 + e0.getr();

        double xa1, ya1;
        double xa0, ya0;
        double xb1, yb1;
        double xb0, yb0;

        if (d1 < 0.000001) {
            xa1 = da1;
            ya1 = 0.0;
            xa0 = xa1 + x;
            ya0 = ya1 + y;
            xb1 = db1;
            yb1 = 0.0;
            xb0 = xb1 + x;
            yb0 = yb1 + y;
        } else {
            xa1 = da1 * x1 / d1;
            ya1 = da1 * y1 / d1;
            xa0 = xa1 + x;
            ya0 = ya1 + y;
            xb1 = db1 * x1 / d1;
            yb1 = db1 * y1 / d1;
            xb0 = xb1 + x;
            yb0 = yb1 + y;
        }

        int ic = 5;//if(e0.getcolor()==5){ic=3;}

        return new En(new Senbun(hanten(new Ten(xa0, ya0)), hanten(new Ten(xb0, yb0))), ic);
    }

    //(x,y)��ʂ鑼�̉~��??���ɔ��]�����??----------------------------------------------------
    public Senbun hanten_En2Senbun(En e0) {//e0�̉~����(x,y)��ʂ�Ƃ��p?@//e0�̉~����(x,y)��ʂ�Ȃ��Ƃ��͂������Ȍ��ʂɂȂ�?B
        double x1 = e0.getx() - x, y1 = e0.gety() - y;
        Ten th = new Ten();
        th.set(hanten(new Ten(x1 * 2.0 + x, y1 * 2.0 + y)));
        Ten t1 = new Ten();
        t1.set(th.getx() - x, th.gety() - y);
        Ten tha = new Ten();
        tha.set(th.getx() + 3.0 * y1, th.gety() - 3.0 * x1);
        Ten thb = new Ten();
        thb.set(th.getx() - 3.0 * y1, th.gety() + 3.0 * x1);
        return new Senbun(tha, thb, 3);
    }


    //(x,y)��ʂ�Ȃ�??���𑼂̉~�ɔ��]�����??----------------------------------------------------
    public En hanten_Senbun2En(Senbun s0) {//s0��(x,y)��ʂ�Ƃ��͂������Ȍ��ʂɂȂ�?B
        Tyokusen ty = new Tyokusen(s0);
        Ten t0 = new Ten();
        t0.set(ty.kage_motome(get_tyuusin()));
        return new En(new Senbun(hanten(t0), get_tyuusin()), 5);
    }


}