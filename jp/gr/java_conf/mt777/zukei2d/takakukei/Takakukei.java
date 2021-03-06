package jp.gr.java_conf.mt777.zukei2d.takakukei;

import jp.gr.java_conf.mt777.zukei2d.oritacalc.OritaCalc;
import jp.gr.java_conf.mt777.zukei2d.senbun.Senbun;
import jp.gr.java_conf.mt777.zukei2d.ten.Ten;

import java.awt.*;

public class Takakukei {
    String c = "";
    int kakusuu;             //½p`©
    //ArrayList TenList = new ArrayList();

    Ten[] t;//¸_

    OritaCalc oc = new OritaCalc();          //eívZpÌÖ?ðg¤½ßÌNXÌCX^X»


    public Takakukei(int kaku) {  //RXgN^
        kakusuu = kaku;
        Ten[] t0 = new Ten[kaku + 1];   //¸_
        for (int i = 0; i <= kaku; i++) {
            t0[i] = new Ten();
        }
        // red=255;green=0;blue=0;
        t = t0;
    }

    //½p`Ìp?ðZbg·é
    public void setkakusuu(int kaku) {
        kakusuu = kaku;
    }

    public int getkakusuu() {
        return kakusuu;
    }

    //½p`ÌiÔÚÌ¸_ðZbg·é
    public void set(int i, Ten p) {
        t[i].set(p);
    }

    //½p`ÌiÔÚÌ¸_ðQbg·é
    public Ten get(int i) {
        return t[i];
    }

    //_p0ðî??É½p`ÌiÔÚÌ¸_ðZbg·é
    public void set(Ten p0, int i, Ten p) {
        t[i].set(p0.getx() + p.getx(), p0.gety() + p.gety());
    }

    //??ªª?A±Ì½p`ÌÓÆð?··é(true)©µÈ¢(false)©»è·éÖ??----------------------------------
    public boolean kousa(Senbun s0) {
        int itrue = 0;
        // Senbun s0 =new Senbun();
        // s0.set(sa);
        Senbun s = new Senbun();
        for (int i = 1; i <= kakusuu - 1; i++) {
            s.set(t[i], t[i + 1]); //??ª
            if (oc.senbun_kousa_hantei(s0, s) >= 1) {
                itrue = 1;
            }
        }

        s.set(t[kakusuu], t[1]); //??ª
        if (oc.senbun_kousa_hantei(s0, s) >= 1) {
            itrue = 1;
        }

        return itrue == 1;
    }

    //??ªs0ÌêÅàÊ½p`Ìà?i«E??ÍàÆÝÈ³È¢?jÉ
    //¶?Ý·éÆ«1?AµÈ¢Èç0ðÔ·
    public int totu_naibu(Senbun s0) {
        int iflag = 0;//
        int kh = 0; //oc.senbun_kousa_hantei(s0,s)ÌlÌi[p
        // Senbun s0 =new Senbun();
        // s0.set(sa);
        Senbun s = new Senbun();
        for (int i = 1; i <= kakusuu - 1; i++) {
            s.set(t[i], t[i + 1]); //??ª
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
            } //±±ÍÀ?ÛÉÍkhª20È??30¢ÌÆ«ÉÀ?s³êé?B
        }

        s.set(t[kakusuu], t[1]); //??ª
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
        } //±±ÍÀ?ÛÉÍkhª20È??30¢ÌÆ«ÉÀ?s³êé?B

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

        return 0;      //À?ÛÍ±±ÜÅ½Çè­æ¤È?óÔÍN«È¢Í¸
    }


    //??ªs0ÌêÅàÊ½p`Ìà?i«E??ààÆÝÈ·?jÉ
    //¶?Ý·éÆ«1?AµÈ¢Èç0ðÔ·
    public int totu_kyoukai_naibu(Senbun s0) {
        int iflag = 0;//
        int kh = 0; //oc.senbun_kousa_hantei(s0,s)ÌlÌi[p

        Senbun s = new Senbun();
        for (int i = 1; i <= kakusuu - 1; i++) {
            s.set(t[i], t[i + 1]); //??ª
            kh = oc.senbun_kousa_hantei(s0, s);
            if (kh != 0) {
                return 1;
            }
        }

        s.set(t[kakusuu], t[1]); //??ª
        kh = oc.senbun_kousa_hantei(s0, s);
        if (kh != 0) {
            return 1;
        }

        if (naibu(new Ten(0.5, s0.geta(), 0.5, s0.getb())) == 2) {
            return 1;
        }


        return 0;
    }


    //_ª?A±Ì½p`ÌàÉ é(true)©È¢(false)©»è·éÖ??----------------------------------
    public int naibu(Ten p) {      //0=O?A?@1=«E?A?@2=à
        Senbun s = new Senbun();
        Senbun sq = new Senbun();
        Ten q = new Ten();

        int kousakaisuu = 0;
        int jyuuji_kousakaisuu = 0;
        int tekisetu = 0;
        double rad = 0.0;//mÀÉOÉ é_ð??éÆ«Ég¤WA?B

        //Ü¸?A_pª½p`Ì«E???ãÉ é©»è·é?B
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

        //_pª½p`Ì«E???ãÉ³¢?????AàÉ é©OÉ é©»è·é

        while (tekisetu == 0) {   //ð?·ñ?ª0Ü½Í?A·×ÄÌð?·ª?\H^ÈçK?Ø?B
            kousakaisuu = 0;
            jyuuji_kousakaisuu = 0;

            //mÀÉOÉ é_qÆ?A_pÅ??ªð??é?B
            rad += 1.0;
            q.set((100000.0 * Math.cos(rad)), (100000.0 * Math.sin(rad))); //<<<<<<<<<<<<<<<<<<

            sq.set(p, q);

            for (int i = 1; i <= kakusuu - 1; i++) {
                s.set(t[i], t[i + 1]); //??ª
                if (oc.senbun_kousa_hantei(sq, s, 0.0, 0.0) >= 1) {
                    kousakaisuu++;
                }
                if (oc.senbun_kousa_hantei(sq, s, 0.0, 0.0) == 1) {
                    jyuuji_kousakaisuu++;
                }
            }

            s.set(t[kakusuu], t[1]); //??ª
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
        } //ð?·ñ?ªï?Èçà

        //if(jyuuji_kousakaisuu==1){return true; } //ð?·ñ?ªï?Èçà
        return 0;
    }

    //½p`Ì¸_?ÀWðvñèÉ?É?ix1,y1?j?C?ix2,y2?j?C...?C?ixn,yn?jÆµ½???ÌÊ?Ïð??ßé
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

    // é_Æ½p`Ì£?i é_Æ½p`Ì«E?ãÌ_Ì£Ì?Å?¬l?jð??ßé
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


    //½p`ÌàÌ_ð??ßé
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

    //`æ-----------------------------------------------------------------
    public void oekaki(Graphics g) {
		/*
		for (int i=1; i<=kakusuu-1; i++ ){
			g.drawLine( t[i].getx(),t[i].gety(),t[i+1].getx(),t[i+1].gety()); //¼??
		}
		g.drawLine( t[kakusuu].getx(),t[kakusuu].gety(),t[1].getx(),t[1].gety()); //¼??    
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
    }//½p`Ìx?ÀWÌ?Å?¬lð??ßé

    public double get_x_max() {
        double r;
        r = t[1].getx();
        for (int i = 2; i <= kakusuu; i++) {
            if (r < t[i].getx()) {
                r = t[i].getx();
            }
        }
        return r;
    }//½p`Ìx?ÀWÌ?Åålð??ßé

    public double get_y_min() {
        double r;
        r = t[1].gety();
        for (int i = 2; i <= kakusuu; i++) {
            if (r > t[i].gety()) {
                r = t[i].gety();
            }
        }
        return r;
    }//½p`Ìy?ÀWÌ?Å?¬lð??ßé

    public double get_y_max() {
        double r;
        r = t[1].gety();
        for (int i = 2; i <= kakusuu; i++) {
            if (r < t[i].gety()) {
                r = t[i].gety();
            }
        }
        return r;
    }//½p`Ìy?ÀWÌ?Åålð??ßé


}