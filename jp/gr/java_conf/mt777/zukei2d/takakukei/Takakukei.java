package jp.gr.java_conf.mt777.zukei2d.takakukei;

import jp.gr.java_conf.mt777.zukei2d.oritacalc.OritaCalc;
import jp.gr.java_conf.mt777.zukei2d.senbun.Senbun;
import jp.gr.java_conf.mt777.zukei2d.ten.Ten;

import java.awt.*;

public class Takakukei {
    String c = "";
    int kakusuu;             //何角形か
    //ArrayList TenList = new ArrayList();

    Ten[] t;//頂点

    OritaCalc oc = new OritaCalc();          //各種計算用の関?狽gうためのクラスのインスタンス化


    public Takakukei(int kaku) {  //コンストラクタ
        kakusuu = kaku;
        Ten[] t0 = new Ten[kaku + 1];   //頂点
        for (int i = 0; i <= kaku; i++) {
            t0[i] = new Ten();
        }
        // red=255;green=0;blue=0;
        t = t0;
    }

    //多角形の角?狽Zットする
    public void setkakusuu(int kaku) {
        kakusuu = kaku;
    }

    public int getkakusuu() {
        return kakusuu;
    }

    //多角形のi番目の頂点をセットする
    public void set(int i, Ten p) {
        t[i].set(p);
    }

    //多角形のi番目の頂点をゲットする
    public Ten get(int i) {
        return t[i];
    }

    //点p0を基??に多角形のi番目の頂点をセットする
    public void set(Ten p0, int i, Ten p) {
        t[i].set(p0.getx() + p.getx(), p0.gety() + p.gety());
    }

    //??分が?Aこの多角形の辺と交?ｷする(true)かしない(false)か判定する関??----------------------------------
    public boolean kousa(Senbun s0) {
        int itrue = 0;
        // Senbun s0 =new Senbun();
        // s0.set(sa);
        Senbun s = new Senbun();
        for (int i = 1; i <= kakusuu - 1; i++) {
            s.set(t[i], t[i + 1]); //??分
            if (oc.senbun_kousa_hantei(s0, s) >= 1) {
                itrue = 1;
            }
        }

        s.set(t[kakusuu], t[1]); //??分
        if (oc.senbun_kousa_hantei(s0, s) >= 1) {
            itrue = 1;
        }

        return itrue == 1;
    }

    //??分s0の一部でも凸多角形の内部?i境界??は内部とみなさない?jに
    //存?ﾝするとき1?Aしないなら0を返す
    public int totu_naibu(Senbun s0) {
        int iflag = 0;//
        int kh = 0; //oc.senbun_kousa_hantei(s0,s)の値の格納用
        // Senbun s0 =new Senbun();
        // s0.set(sa);
        Senbun s = new Senbun();
        for (int i = 1; i <= kakusuu - 1; i++) {
            s.set(t[i], t[i + 1]); //??分
            kh = oc.senbun_kousa_hantei(s0, s);
            if (kh == 1) {
                return 1;
            }
            if (kh == 4) {
                return 0;
            }
            if (kh == 5) {
                return 0;
            }
            if (kh == 6) {
                return 0;
            }
            if (kh >= 30) {
                return 0;
            }
            if (kh >= 20) {
                iflag = iflag + 1;
            } //ここは実?ﾛにはkhが20以??30未満のときに実?sされる?B
        }

        s.set(t[kakusuu], t[1]); //??分
        kh = oc.senbun_kousa_hantei(s0, s);
        if (kh == 1) {
            return 1;
        }
        if (kh == 4) {
            return 0;
        }
        if (kh == 5) {
            return 0;
        }
        if (kh == 6) {
            return 0;
        }
        if (kh >= 30) {
            return 0;
        }
        if (kh >= 20) {
            iflag = iflag + 1;
        } //ここは実?ﾛにはkhが20以??30未満のときに実?sされる?B

        if (iflag == 0) {
            if (naibu(new Ten(0.5, s0.geta(), 0.5, s0.getb())) == 2) {
                return 1;
            }
            return 0;
        }

        if (iflag == 1) {
            if (naibu(new Ten(0.5, s0.geta(), 0.5, s0.getb())) == 2) {
                return 1;
            }
            return 0;
        }

        if (iflag == 2) {
            if (naibu(new Ten(0.5, s0.geta(), 0.5, s0.getb())) == 2) {
                return 1;
            }
            if (naibu(s0.geta()) == 2) {
                return 1;
            }
            if (naibu(s0.getb()) == 2) {
                return 1;
            }
            return 0;
        }

        if (iflag == 3) {
            return 1;
        }
        if (iflag == 4) {
            return 1;
        }

        return 0;      //実?ﾛはここまでたどり着くような?ﾔは起きないはず
    }


    //??分s0の一部でも凸多角形の内部?i境界??も内部とみなす?jに
    //存?ﾝするとき1?Aしないなら0を返す
    public int totu_kyoukai_naibu(Senbun s0) {
        int iflag = 0;//
        int kh = 0; //oc.senbun_kousa_hantei(s0,s)の値の格納用

        Senbun s = new Senbun();
        for (int i = 1; i <= kakusuu - 1; i++) {
            s.set(t[i], t[i + 1]); //??分
            kh = oc.senbun_kousa_hantei(s0, s);
            if (kh != 0) {
                return 1;
            }
        }

        s.set(t[kakusuu], t[1]); //??分
        kh = oc.senbun_kousa_hantei(s0, s);
        if (kh != 0) {
            return 1;
        }

        if (naibu(new Ten(0.5, s0.geta(), 0.5, s0.getb())) == 2) {
            return 1;
        }


        return 0;
    }


    //点が?Aこの多角形の内部にある(true)かない(false)か判定する関??----------------------------------
    public int naibu(Ten p) {      //0=外部?A?@1=境界?A?@2=内部
        Senbun s = new Senbun();
        Senbun sq = new Senbun();
        Ten q = new Ten();

        int kousakaisuu = 0;
        int jyuuji_kousakaisuu = 0;
        int tekisetu = 0;
        double rad = 0.0;//確実に外部にある点を??るときに使うラジアン?B

        //まず?A点pが多角形の境界???繧ﾉあるか判定する?B
        for (int i = 1; i <= kakusuu - 1; i++) {
            s.set(t[i], t[i + 1]);
            if (oc.kyori_senbun(p, s) == 0) {
                return 1;
            }
        }
        s.set(t[kakusuu], t[1]);
        if (oc.kyori_senbun(p, s) == 0) {
            return 1;
        }

        //点pが多角形の境界???繧ﾉ無い?????A内部にあるか外部にあるか判定する

        while (tekisetu == 0) {   //交?ｷ回?狽ｪ0または?Aすべての交?ｷが?\字路型なら適?ﾘ?B
            kousakaisuu = 0;
            jyuuji_kousakaisuu = 0;

            //確実に外部にある点qと?A点pで??分を??る?B
            rad += 1.0;
            q.set((100000.0 * Math.cos(rad)), (100000.0 * Math.sin(rad))); //<<<<<<<<<<<<<<<<<<

            sq.set(p, q);

            for (int i = 1; i <= kakusuu - 1; i++) {
                s.set(t[i], t[i + 1]); //??分
                if (oc.senbun_kousa_hantei(sq, s, 0.0, 0.0) >= 1) {
                    kousakaisuu++;
                }
                if (oc.senbun_kousa_hantei(sq, s, 0.0, 0.0) == 1) {
                    jyuuji_kousakaisuu++;
                }
            }

            s.set(t[kakusuu], t[1]); //??分
            if (oc.senbun_kousa_hantei(sq, s, 0.0, 0.0) >= 1) {
                kousakaisuu++;
            }
            if (oc.senbun_kousa_hantei(sq, s, 0.0, 0.0) == 1) {
                jyuuji_kousakaisuu++;
            }

            if (kousakaisuu == jyuuji_kousakaisuu) {
                tekisetu = 1;
            }
        }

        if (kousakaisuu % 2 == 1) {
            return 2;
        } //交?ｷ回?狽ｪ奇?狽ﾈら内部

        //if(jyuuji_kousakaisuu==1){return true; } //交?ｷ回?狽ｪ奇?狽ﾈら内部
        return 0;
    }

    //多角形の頂点?ﾀ標を時計回りに?№ﾉ?ix1,y1?j?C?ix2,y2?j?C...?C?ixn,yn?jとした???№ﾌ面?ﾏを??める
    public double menseki_motome() {
        double menseki = 0.0;

        menseki = menseki + (t[kakusuu].getx() - t[2].getx()) * t[1].gety();
        for (int i = 2; i <= kakusuu - 1; i++) {
            menseki = menseki + (t[i - 1].getx() - t[i + 1].getx()) * t[i].gety();
        }
        menseki = menseki + (t[kakusuu - 1].getx() - t[1].getx()) * t[kakusuu].gety();
        menseki = -0.5 * menseki;

        return menseki;
    }

    //ある点と多角形の距離?iある点と多角形の境界?繧ﾌ点の距離の?ﾅ?ｬ値?jを??める
    public double kyori_motome(Ten tn) {
        double kyori;
        kyori = oc.kyori_senbun(tn, t[kakusuu], t[1]);
        for (int i = 1; i <= kakusuu - 1; i++) {
            if (oc.kyori_senbun(tn, t[i], t[i + 1]) < kyori) {
                kyori = oc.kyori_senbun(tn, t[i], t[i + 1]);
            }
        }

        return kyori;
    }


    //多角形の内部の点を??める
    public Ten naibuTen_motome() {
        Ten tn = new Ten();
        Ten tr = new Ten();
        double kyori;
        kyori = -10.0;

        for (int i = 2; i <= kakusuu - 1; i++) {
            tn.set(oc.naisin(t[i - 1], t[i], t[i + 1]));
            if ((kyori < kyori_motome(tn)) && (naibu(tn) == 2)) {
                kyori = kyori_motome(tn);
                tr.set(tn);
            }
        }
        //
        tn.set(oc.naisin(t[kakusuu - 1], t[kakusuu], t[1]));
        if ((kyori < kyori_motome(tn)) && (naibu(tn) == 2)) {
            kyori = kyori_motome(tn);
            tr.set(tn);
        }
        //
        tn.set(oc.naisin(t[kakusuu], t[1], t[2]));
        if ((kyori < kyori_motome(tn)) && (naibu(tn) == 2)) {
            kyori = kyori_motome(tn);
            tr.set(tn);
        }
        //
        return tr;
    }

    //描画-----------------------------------------------------------------
    public void oekaki(Graphics g) {
		/*
		for (int i=1; i<=kakusuu-1; i++ ){
			g.drawLine( t[i].getx(),t[i].gety(),t[i+1].getx(),t[i+1].gety()); //直??
		}
		g.drawLine( t[kakusuu].getx(),t[kakusuu].gety(),t[1].getx(),t[1].gety()); //直??    
		*/
        int[] x = new int[100];
        int[] y = new int[100];
        for (int i = 1; i <= kakusuu - 1; i++) {
            x[i] = (int) t[i].getx();
            y[i] = (int) t[i].gety();
        }
        x[0] = (int) t[kakusuu].getx();
        y[0] = (int) t[kakusuu].gety();
        //  g.setColor(new Color(red,green,blue));
        // g.setColor(Color.yellow);
        g.fillPolygon(x, y, kakusuu);
        // g.setColor(Color.black);
        //   g.drawString("gomi "+c.valueOf(f[1])+" : "+c.valueOf(f[2])+" : "
        //                       +c.valueOf(f[3])+" : "+c.valueOf(f[4]),10,80);
    }


    public double get_x_min() {
        double r;
        r = t[1].getx();
        for (int i = 2; i <= kakusuu; i++) {
            if (r > t[i].getx()) {
                r = t[i].getx();
            }
        }
        return r;
    }//多角形のx?ﾀ標の?ﾅ?ｬ値を??める

    public double get_x_max() {
        double r;
        r = t[1].getx();
        for (int i = 2; i <= kakusuu; i++) {
            if (r < t[i].getx()) {
                r = t[i].getx();
            }
        }
        return r;
    }//多角形のx?ﾀ標の?ﾅ大値を??める

    public double get_y_min() {
        double r;
        r = t[1].gety();
        for (int i = 2; i <= kakusuu; i++) {
            if (r > t[i].gety()) {
                r = t[i].gety();
            }
        }
        return r;
    }//多角形のy?ﾀ標の?ﾅ?ｬ値を??める

    public double get_y_max() {
        double r;
        r = t[1].gety();
        for (int i = 2; i <= kakusuu; i++) {
            if (r < t[i].gety()) {
                r = t[i].gety();
            }
        }
        return r;
    }//多角形のy?ﾀ標の?ﾅ大値を??める


}