package jp.gr.java_conf.mt777.zukei2d.senbun;

import jp.gr.java_conf.mt777.zukei2d.ten.Ten;

import java.awt.*;
import java.math.BigDecimal;

public class Senbun {
    //OritaCalc oc =new OritaCalc();//各種計算用の関?狽�使うためのクラスのインスタンス化
    private final Ten a = new Ten(); //枝のa点
    private final Ten b = new Ten(); //枝のb
    int iactive;//0は活?ｫなし?B1はaが活?ｫ?B2はbが活?ｫ?B3はaもbも活?ｫ?B
    int icol;//?Fの指定?@0=black,1=blue,2=red.

    int tpp = 0;//特??プ??パティパラ???[タ?[
    //Color tpp_color =new Color(100, 200, 200);//特??ある???�の?F
    Color tpp_color = new Color(100, 200, 200);//特??ある???�の?F


    int i_select;//0は選択されていない?B1以?繧ﾍ?齧ﾊに応じて適宜?ﾝ定
    int i_max_x;//端点のx?ﾀ標の?ﾘり?繧ｰ時の大きいほう
    int i_min_x;//端点のx?ﾀ標の?ﾘり捨て時の?ｬさいほう
    int i_max_y;//端点のy?ﾀ標の?ﾘり?繧ｰ時の大きいほう
    int i_min_y;//端点のy?ﾀ標の?ﾘり捨て時の?ｬさいほう

    //コンストラクタ
    public Senbun() {
        a.set(0.0, 0.0);
        b.set(0.0, 0.0);
        iactive = 0;
        icol = 0;
        i_select = 0;
        i_max_x = 0;
        i_min_x = 0;
        i_max_y = 0;
        i_min_y = 0;
    }

    public Senbun(Ten t1, Ten t2) {
        a.set(t1);
        b.set(t2);
        iactive = 0;
        icol = 0;
        i_select = 0;
        i_max_x = 0;
        i_min_x = 0;
        i_max_y = 0;
        i_min_y = 0;
    }

    public Senbun(Ten t1, Ten t2, int icollor) {
        a.set(t1);
        b.set(t2);
        iactive = 0;
        icol = icollor;
        i_select = 0;
        i_max_x = 0;
        i_min_x = 0;
        i_max_y = 0;
        i_min_y = 0;
    }

    public Senbun(double i1, double i2, double i3, double i4) {
        a.set(i1, i2);
        b.set(i3, i4);
        iactive = 0;
        icol = 0;
        i_select = 0;
        i_max_x = 0;
        i_min_x = 0;
        i_max_y = 0;
        i_min_y = 0;
    }


    public void reset() {
        a.set(0.0, 0.0);
        b.set(0.0, 0.0);
        iactive = 0;
        icol = 0;
        i_select = 0;
        i_max_x = 0;
        i_min_x = 0;
        i_max_y = 0;
        i_min_y = 0;
    }


    //d2s ダブルをストリングに変える?@?ｬ?箔_2桁目で四捨五入("");public void hyouji(String str0)にしか使っていない?B
    public String d2s(double d0) {
        BigDecimal bd = new BigDecimal(d0);

        //?ｬ?泊?2位で四捨五入
        BigDecimal bd1 = bd.setScale(1, BigDecimal.ROUND_HALF_UP);

        String sr = "";
        sr = bd1.toString();
        return sr;
    }

    public void hyouji(String str0) {
        System.out.println(str0 + " (" + d2s(a.getx()) + " , " + d2s(a.gety()) + "),(" + d2s(b.getx()) + " , " + d2s(b.gety()) + ") ,ia=" + iactive + ",ic=" + icol + ",is=" + i_select);
    }


    //-------------------------------------------
    public void set(Senbun s) {
        a.set(s.geta());
        b.set(s.getb());
        iactive = s.getiactive();
        icol = s.getcolor();
        i_select = s.get_i_select();
        i_max_x = s.get_i_max_x();
        i_min_x = s.get_i_min_x();
        i_max_y = s.get_i_max_y();
        i_min_y = s.get_i_min_y();
        set_tpp(s.get_tpp());
        set_tpp_color(s.get_tpp_color());


    }

    //----------
    public void set(double ax, double ay, double bx, double by) {
        a.set(ax, ay);
        b.set(bx, by);
        i_max_x = (int) Math.ceil(ax);
        i_min_x = (int) Math.floor(bx);
        if (ax < bx) {
            i_max_x = (int) Math.ceil(bx);
            i_min_x = (int) Math.floor(ax);
        }
        i_max_y = (int) Math.ceil(ay);
        i_min_y = (int) Math.floor(by);
        if (ay < by) {
            i_max_y = (int) Math.ceil(by);
            i_min_y = (int) Math.floor(ay);
        }
    }

    //----------
    public void set(double ax, double ay, double bx, double by, int ic) {
        set(ax, ay, bx, by);
        icol = ic;
    }

    //----------
    public void seta(Ten p) {
        set(p.getx(), p.gety(), b.getx(), b.gety());
    }

    public void setb(Ten p) {
        set(a.getx(), a.gety(), p.getx(), p.gety());
    }

    //public void seta(Ten p){a.set(p);}
    //public void setb(Ten p){b.set(p);}

    //----------
    //活?ｫ化された点の?ﾀ標をpにする   !!!!!!!!!!!!この関?狽ﾍ間違えたとき?A気づきにくいので危険?Aできれば別名に変える20170507
    public void set(Ten p) {
        if (iactive == 1) {
            seta(p);
        }
        if (iactive == 2) {
            setb(p);
        }
        //if (iactive==1){a.set(p.getx(),p.gety());}
        //if (iactive==2){b.set(p.getx(),p.gety());}
    }


    //---------
    public void set(Ten p, Ten q, int ic, int ia) {
        set(p, q);
        icol = ic;
        iactive = ia;
    }

    public void set(Ten p, Ten q, int ic) {
        set(p, q);
        icol = ic;
    }

    public void set(Ten p, Ten q) {
        set(p.getx(), p.gety(), q.getx(), q.gety());
    }
    //public void set(Ten p,Ten q              ){	a.set(p);  b.set(q);    			}
    //public void setb(Ten p){set(a.getx(),a.gety(),p.getx(),p.gety());}

    //-------------------------------------------
    public int get_i_max_x() {
        return i_max_x;
    }

    public int get_i_min_x() {
        return i_min_x;
    }

    public int get_i_max_y() {
        return i_max_y;
    }

    public int get_i_min_y() {
        return i_min_y;
    }


    public void setcolor(int i) {
        icol = i;
    }

    public int getcolor() {
        return icol;
    }

    public void setiactive(int i) {
        iactive = i;
    }

    public int getiactive() {
        return iactive;
    }


    public void set_i_select(int i) {
        i_select = i;
    }

    public int get_i_select() {
        return i_select;
    }

    //この??分が?Aある点と近いかどうかで活?ｫ化する?B
    public void kasseika(Ten p, double r) {
        iactive = 0;
        if (p.kyori2jyou(a) <= r * r) {
            iactive = 1;
        }
        if (p.kyori2jyou(b) <= r * r) {
            iactive = 2;
        }
        //if(oc.kyori(p,a)<=r){iactive=1;}
        //if(oc.kyori(p,b)<=r){iactive=2;}
    }

    //この??分を非活?ｫ化
    public void hikasseika() {
        iactive = 0;
    }


    //両端点a,bの?ﾀ標を交換
    public void a_b_koukan() {
        Ten t_temp = new Ten(a);
        a.set(b);
        b.set(t_temp);
    }


    public Ten geta() {
        return new Ten(a.getx(), a.gety());
    }

    public Ten getb() {
        return new Ten(b.getx(), b.gety());
    }


//	public Ten geta(){return a;}
//	public Ten getb(){return b;}

    public Ten get_tikai_hasi(Ten p) {//点Pと近いほうの端点を返す
        if (p.kyori2jyou(a) <= p.kyori2jyou(b)) {
            return a;
        }
        return b;
    }

    public Ten get_tooi_hasi(Ten p) {//点Pと遠いいほうの端点を返す
        if (p.kyori2jyou(a) >= p.kyori2jyou(b)) {
            return a;
        }
        return b;
    }


    public double getnagasa() {
        return a.kyori(b);
    }
    //public double getnagasa(){return oc.kyori(a,b);}

    public double getax() {
        return a.getx();
    }

    public double getay() {
        return a.gety();
    }

    public double getbx() {
        return b.getx();
    }

    public double getby() {
        return b.gety();
    }

    public void setax(double d) {
        a.setx(d);
    }

    public void setay(double d) {
        a.sety(d);
    }

    public void setbx(double d) {
        b.setx(d);
    }

    public void setby(double d) {
        b.sety(d);
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


}