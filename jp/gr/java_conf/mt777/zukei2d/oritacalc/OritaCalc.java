package jp.gr.java_conf.mt777.zukei2d.oritacalc;

import jp.gr.java_conf.mt777.zukei2d.en.En;
import jp.gr.java_conf.mt777.zukei2d.oritacalc.tyokusen.Tyokusen;
import jp.gr.java_conf.mt777.zukei2d.senbun.Senbun;

import java.math.BigDecimal;

public class OritaCalc {


    //d2s ƒ_ƒuƒ‹‚ðƒXƒgƒŠƒ“ƒO‚É•Ï‚¦‚é?@?¬?”“_2Œ…–Ú‚ÅŽlŽÌŒÜ“ü("");‚„‚Q‚“
    public String d2s(double d0) {
        BigDecimal bd = new BigDecimal(d0);

        //?¬?”‘æ2ˆÊ‚ÅŽlŽÌŒÜ“ü
        BigDecimal bd1 = bd.setScale(1, BigDecimal.ROUND_HALF_UP);

        String sr = "";
        sr = bd1.toString();
        return sr;
    }


    //‚½‚¾‚ÌSystem.out.println("String");
    public void hyouji(String s0) {
        System.out.println(s0);
    }


    //’¼?üt?ã‚Ì“_p‚Ì‰e‚ÌˆÊ’u?i“_p‚Æ?Å‚à‹ß‚¢’¼?üt?ã‚ÌˆÊ’u?j‚ð‹?‚ß‚é?B
    public Ten kage_motome(Tyokusen t, Ten p) {

        Tyokusen t1 = new Tyokusen();
        t1.set(t);
        t1.tyokkouka(p);//“_p1‚ð’Ê‚Á‚Ä t‚É’¼?s‚·‚é’¼?üu1‚ð‹?‚ß‚é?B
        return kouten_motome(t, t1);
    }

    //“_P0‚ÆP1‚ð’Ê‚é’¼?üt?ã‚Ì“_p‚Ì‰e‚ÌˆÊ’u?i“_p‚Æ?Å‚à‹ß‚¢’¼?üt?ã‚ÌˆÊ’u?j‚ð‹?‚ß‚é?B
    public Ten kage_motome(Ten p0, Ten p1, Ten p) {
        Tyokusen t = new Tyokusen(p0, p1);
        return kage_motome(t, p);
    }

    //?ü•ªs0‚ðŠÜ‚Þ’¼?üt?ã‚Ì“_p‚Ì‰e‚ÌˆÊ’u?i“_p‚Æ?Å‚à‹ß‚¢’¼?üt?ã‚ÌˆÊ’u?j‚ð‹?‚ß‚é?B
    public Ten kage_motome(Senbun s0, Ten p) {
        return kage_motome(s0.geta(), s0.getb(), p);
    }


    //2‚Â‚Ì“_‚ª“¯‚¶ˆÊ’u(true)‚©ˆÙ‚È‚é(false)‚©”»’è‚·‚éŠÖ?”----------------------------------
    public boolean hitosii(Ten p1, Ten p2) {
        return hitosii(p1, p2, 0.1);//‚±‚±‚ÅŒë?·‚ª’è‹`‚³‚ê‚Ä‚¢‚é?B
    }

    public boolean hitosii(Ten p1, Ten p2, double r) {//r‚ÍŒë?·‚Ì‹–—e“x?Br‚ª•‰‚È‚çŒµ–§”»’è?B

        //Œµ–§‚É”»’è?B
        if (r <= 0.0) {
            if ((p1.getx() == p2.getx()) && (p1.gety() == p2.gety())) {
                return true;
            }
        }
        //Œë?·‚ð‹–—e?B
        if (r > 0) {
            return kyori(p1, p2) <= r;
        }
        return false;
    }

    //‚Q“_ŠÔ‚Ì‹——£?i?®?”?j‚ð‹?‚ß‚éŠÖ?”----------------------------------------------------
    public double kyori(Ten p0, Ten p1) {
        return p0.kyori(p1);
    }

    /*
	public double kyori(Ten p0,Ten p1){
		double x0=p0.getx(),y0=p0.gety();
		double x1=p1.getx(),y1=p1.gety();
		return Math.sqrt((x1-x0)*(x1-x0)+(y1-y0)*(y1-y0));
	}
*/
    //‚Q“_ŠÔa,b‚ðŽw’è‚µ‚Ä?AƒxƒNƒgƒ‹ab‚ÆxŽ²‚Ì‚È‚·Šp“x‚ð‹?‚ß‚éŠÖ?”?B‚à‚µa=b‚È‚ç-10000.0‚ð•Ô‚·----------------------------------------------------
    public double kakudo(Ten a, Ten b) {
        double ax, ay, bx, by, x, y, L, c, ret;
        ax = a.getx();
        ay = a.gety();
        bx = b.getx();
        by = b.gety();
        x = bx - ax;
        y = by - ay;
        L = Math.sqrt(x * x + y * y);
        if (L <= 0.0) {
            return -10000.0;
        }
        c = x / L;
        if (c > 1.0) {
            c = 1.0;
        }

        ret = Math.acos(c);
        if (y < 0.0) {
            ret = -ret;
        }
        ret = 180.0 * ret / Math.PI;
        if (ret < 0) {
            ret = ret + 360.0;
        }
        return ret;
    }


    //?ü•ª‚ðŽw’è‚µ‚Ä?AƒxƒNƒgƒ‹ab‚ÆxŽ²‚Ì‚È‚·Šp“x‚ð‹?‚ß‚éŠÖ?”?B‚à‚µa=b‚È‚ç-10000.0‚ð•Ô‚·----------------------------------------------------
    public double kakudo(Senbun s) {
        return kakudo(s.geta(), s.getb());
    }

    //?ü•ª‚ðŽw’è‚µ‚Ä?AƒxƒNƒgƒ‹ab‚ÆxŽ²‚Ì‚È‚·Šp“x‚ð‹?‚ß‚éŠÖ?”?B‚à‚µa=b‚È‚ç-10000.0‚ð•Ô‚·----------------------------------------------------
    public double kakudozure(Senbun s, double a) {
        double b;//ŽÀ?Û‚ÌŠp“x‚ða‚ÅŠ„‚Á‚½Žž‚Ì?è—]
        b = kakudo(s) % a;
        if (a - b < b) {
            b = a - b;
        }
        return b;
    }

    //“_pa‚ª?A“ñ“_p1,p2‚ð’[“_‚Æ‚·‚é?ü•ª‚É“_p1‚Æ“_p2‚Å’¼?s‚·‚é?A2‚Â‚Ì?ü•ª‚ðŠÜ‚Þ’·•ûŒ`“à‚É‚ ‚é?ê?‡‚Í2‚ð•Ô‚·ŠÖ?”
    public int hakononaka(Ten p1, Ten pa, Ten p2) {
        Tyokusen t = new Tyokusen(p1, p2);//p1,p2‚ð’Ê‚é’¼?üt‚ð‹?‚ß‚é?B
        Tyokusen u1 = new Tyokusen(p1, p2);
        u1.tyokkouka(p1);//“_p1‚ð’Ê‚Á‚Ä t‚É’¼?s‚·‚é’¼?üu1‚ð‹?‚ß‚é?B
        Tyokusen u2 = new Tyokusen(p1, p2);
        u2.tyokkouka(p2);//“_p2‚ð’Ê‚Á‚Ä t‚É’¼?s‚·‚é’¼?üu2‚ð‹?‚ß‚é?B

        if (u1.dainyuukeisan(pa) * u2.dainyuukeisan(pa) == 0.0) {
            return 1;
        }
        if (u1.dainyuukeisan(pa) * u2.dainyuukeisan(pa) < 0.0) {
            return 2;
        }
        return 0;//” ‚ÌŠO•”‚É‚ ‚é?ê?‡
    }


    //“_pa‚ª?A“ñ“_p1,p2‚ð’[“_‚Æ‚·‚é?ü•ª‚É“_p1‚Æ“_p2‚Å’¼?s‚·‚é?A2‚Â‚Ì?ü•ª‚ðŠÜ‚Þ’·•ûŒ`“à‚É‚ ‚é?ê?‡‚Í2‚ð•Ô‚·ŠÖ?”?B‚±‚ê‚Í ?­‚µ‚Í‚Ý?o‚µ‚Ä‚à’·•ûŒ`“à‚É‚ ‚é‚Æ‚Ý‚È‚·?B
    //‹ï‘Ì“I‚É‚Í?ü•ª‚Ì’†‚É“_‚ª‚ ‚é‚©‚Ì”»’è‚Ì?Û?A‚í‚¸‚©‚É“_‚ª?ü•ª‚ÌŠO‚É‚ ‚é?ê?‡‚Í?A?ü•ª‚Ì’†‚É‚ ‚é‚Æ?AŠÃ‚­”»’è‚·‚é?B•`‚«?E?l‚Å“WŠJ?}‚ð•`‚­‚Æ‚«‚Í?A‚±‚ÌŠÃ‚¢‚Ù‚¤‚ðŽg‚í‚È‚¢‚ÆTŽšŒ^‚Ì?ü•ª‚ÌŒð?·•ªŠ„‚ÉŽ¸”s‚·‚é
    //‚µ‚©‚µ?A‚È‚º‚©?A?Ü‚è?ô‚Ý?„’è‚É‚±‚ÌŠÃ‚¢‚Ù‚¤‚ðŽg‚¤‚Æ–³ŒÀƒ‹?[ƒv‚É‚È‚é‚æ‚¤‚Å?A‚¤‚Ü‚­‚¢‚©‚È‚¢?B‚±‚Ì?³Šm‚È‰ð–¾‚Í–¢‰ðŒˆ20161105
    public int hakononaka_amai(Ten p1, Ten pa, Ten p2) {
        Tyokusen t = new Tyokusen(p1, p2);//p1,p2‚ð’Ê‚é’¼?üt‚ð‹?‚ß‚é?B
        Tyokusen u1 = new Tyokusen(p1, p2);
        u1.tyokkouka(p1);//“_p1‚ð’Ê‚Á‚Ä t‚É’¼?s‚·‚é’¼?üu1‚ð‹?‚ß‚é?B
        Tyokusen u2 = new Tyokusen(p1, p2);
        u2.tyokkouka(p2);//“_p2‚ð’Ê‚Á‚Ä t‚É’¼?s‚·‚é’¼?üu2‚ð‹?‚ß‚é?B

        //if(u1.dainyuukeisan(pa)*u2.dainyuukeisan(pa) ==0.0){return 1;}

        if (u1.kyorikeisan(pa) < 0.00001) {
            return 1;
        }
        if (u2.kyorikeisan(pa) < 0.00001) {
            return 1;
        }

        if (u1.dainyuukeisan(pa) * u2.dainyuukeisan(pa) < 0.0) {
            return 2;
        }
        return 0;//” ‚ÌŠO•”‚É‚ ‚é?ê?‡
    }


    //“_p‚ªŽw’è‚³‚ê‚½?ü•ª‚Æ‚Ç‚Ì•”?Š‚Å‹ß‚¢(rˆÈ“à)‚©‚Ç‚¤‚©‚ð”»’è‚·‚éŠÖ?”?@---------------------------------
    //0=‹ß‚­‚È‚¢?A1=a“_‚É‹ß‚¢?A2=b“_‚É‹ß‚¢?A3=•¿‚Ì•”•ª‚É‹ß‚¢
    public int senbun_busyo_sagasi(Ten p, Senbun s0, double r) {
        if (r > kyori(p, s0.geta())) {
            return 1;
        }//a“_‚É‹ß‚¢‚©‚Ç‚¤‚©
        if (r > kyori(p, s0.getb())) {
            return 2;
        }//b“_‚É‹ß‚¢‚©‚Ç‚¤‚©
        if (r > kyori_senbun(p, s0)) {
            return 3;
        }//•¿‚Ì•”•ª‚É‹ß‚¢‚©‚Ç‚¤‚©
        return 0;
    }


    //“_p0‚Æ?A“ñ“_p1,p2‚ð—¼’[‚Æ‚·‚é?ü•ª‚Æ‚ÌŠÔ‚Ì‹——£‚ð‹?‚ß‚éŠÖ?”----------------------------------------------------
    public double kyori_senbun(Ten p0, Ten p1, Ten p2) {
        // Ten p1 = new Ten();   p1.set(s.geta());
        // Ten p2 = new Ten();   p2.set(s.getb());

        //p1‚Æp2‚ª“¯‚¶?ê?‡
        if (kyori(p1, p2) == 0.0) {
            return kyori(p0, p1);
        }

        //p1‚Æp2‚ªˆÙ‚È‚é?ê?‡
        Tyokusen t = new Tyokusen(p1, p2);//p1,p2‚ð’Ê‚é’¼?üt‚ð‹?‚ß‚é?B
        Tyokusen u = new Tyokusen(p1, p2);
        u.tyokkouka(p0);//“_p0‚ð’Ê‚Á‚Ä t‚É’¼?s‚·‚é’¼?üu‚ð‹?‚ß‚é?B

        if (hakononaka(p1, kouten_motome(t, u), p2) >= 1) {
            return t.kyorikeisan(p0);
        }//t‚Æu‚ÌŒð“_‚ªp1‚Æp2‚ÌŠÔ‚É‚ ‚é?ê?‡?B
        return Math.min(kyori(p0, p1), kyori(p0, p2));//t‚Æu‚ÌŒð“_‚ªp1‚Æp2‚ÌŠÔ‚É‚È‚¢?ê?‡?B
    }

    //“_p0‚Æ?A?ü•ªs‚Æ‚ÌŠÔ‚Ì‹——£‚ð‹?‚ß‚éŠÖ?”----------------------------------------------------
    public double kyori_senbun(Ten p0, Senbun s) {
        Ten p1 = new Ten();
        p1.set(s.geta());
        Ten p2 = new Ten();
        p2.set(s.getb());
        return kyori_senbun(p0, p1, p2);
    }

    //‚Q‚Â‚Ì?ü•ª‚ª?AŒð?·‚·‚é‚©‚Ç‚¤‚©‚ð”»’è‚·‚éŠÖ?”----------------------------------------------------
    // 0=Œð?·‚µ‚È‚¢?A?@
    // 1=‚Q‚Â‚Ì?ü•ª‚ª•½?s‚Å‚È‚­?Aˆê“_‚Å?\Žš˜HŒ^‚ÅŒð?·‚·‚é?A
    // 2”Ô‘ã=‚Q‚Â‚Ì?ü•ª‚ª•½?s‚Å‚È‚­?Aˆê“_‚Å‚sŽš˜HŒ^‚Ü‚½‚Í‚­‚ÌŽšŒ^‚ÅŒð?·‚·‚é
    // 3=‚Q‚Â‚Ì?ü•ª‚ª•½?s‚Å?AŒð?·‚·‚é
    // 4=?ü•ªs1‚Æ?ü•ªs2‚ª“_‚Å?AŒð?·‚·‚é
    // 5=?ü•ªs1‚ª“_‚Å?AŒð?·‚·‚é
    // 6=?ü•ªs2‚ª“_‚Å?AŒð?·‚·‚é
    //’?ˆÓ?Ip1‚Æp2‚ª“¯‚¶?A‚Ü‚½‚Íp3‚Æp4‚ª“¯‚¶?ê?‡‚ÍŒ‹‰Ê‚ª‚¨‚©‚µ‚­‚È‚é‚ª‚ª?A
    //‚±‚ÌŠÖ?”Ž©‘Ì‚É‚Íƒ`ƒFƒbƒN‹@?\‚ð‚Â‚¯‚Ä‚¢‚È‚¢‚Ì‚Å?A‹C‚Ã‚«‚É‚­‚¢‚±‚Æ‚ª‚ ‚é?B
    public int senbun_kousa_hantei(Senbun s1, Senbun s2) {
        //return senbun_kousa_hantei( s1,s2,0.001,0.001) ;
        return senbun_kousa_hantei(s1, s2, 0.01, 0.01);

        //return senbun_kousa_hantei( s1,s2,0.000001,0.000001) ;
    }


    public int senbun_kousa_hantei_amai(Senbun s1, Senbun s2) {
        //return senbun_kousa_hantei_amai( s1,s2,0.000001,0.000001) ;
        return senbun_kousa_hantei_amai(s1, s2, 0.01, 0.01);
    }


    public int senbun_kousa_hantei(Senbun s1, Senbun s2, double rhit, double rhei) {    //r_hitosii‚Ær_heikouhantei‚Í?Ahitosii‚Æheikou_hantei‚Ì‚¸‚ê‚Ì‹–—e’ö“x
        double x1max = s1.getax();
        double x1min = s1.getax();
        double y1max = s1.getay();
        double y1min = s1.getay();
        if (x1max < s1.getbx()) {
            x1max = s1.getbx();
        }
        if (x1min > s1.getbx()) {
            x1min = s1.getbx();
        }
        if (y1max < s1.getby()) {
            y1max = s1.getby();
        }
        if (y1min > s1.getby()) {
            y1min = s1.getby();
        }
        double x2max = s2.getax();
        double x2min = s2.getax();
        double y2max = s2.getay();
        double y2min = s2.getay();
        if (x2max < s2.getbx()) {
            x2max = s2.getbx();
        }
        if (x2min > s2.getbx()) {
            x2min = s2.getbx();
        }
        if (y2max < s2.getby()) {
            y2max = s2.getby();
        }
        if (y2min > s2.getby()) {
            y2min = s2.getby();
        }

        if (x1max + rhit + 0.1 < x2min) {
            return 0;
        }
        if (x1min - rhit - 0.1 > x2max) {
            return 0;
        }
        if (y1max + rhit + 0.1 < y2min) {
            return 0;
        }
        if (y1min - rhit - 0.1 > y2max) {
            return 0;
        }

        //System.out.println("###########");

        Ten p1 = new Ten();
        p1.set(s1.geta());
        Ten p2 = new Ten();
        p2.set(s1.getb());
        Ten p3 = new Ten();
        p3.set(s2.geta());
        Ten p4 = new Ten();
        p4.set(s2.getb());

        Tyokusen t1 = new Tyokusen(p1, p2);
        Tyokusen t2 = new Tyokusen(p3, p4);
        //System.out.print("?@?@?ü•ªŒð?·”»’è‚Å‚Ì•½?s”»’è‚ÌŒ‹‰Ê?@???@");
        //System.out.println (heikou_hantei(t1,t2,rhei));
        // heikou_hantei(t1,t2,rhei)

        //—áŠO?ˆ—??@?ü•ªs1‚Æ?ü•ªs2‚ª“_‚Ì?ê?‡
        if (((p1.getx() == p2.getx()) && (p1.gety() == p2.gety()))
                &&
                ((p3.getx() == p4.getx()) && (p3.gety() == p4.gety()))) {
            if ((p1.getx() == p3.getx()) && (p1.gety() == p3.gety())) {
                return 4;
            }
            return 0;
        }

        //—áŠO?ˆ—??@?ü•ªs1‚ª“_‚Ì?ê?‡
        if ((p1.getx() == p2.getx()) && (p1.gety() == p2.gety())) {
            if ((hakononaka(p3, p1, p4) >= 1) && (t2.dainyuukeisan(p1) == 0.0)) {
                return 5;
            }
            return 0;
        }

        //—áŠO?ˆ—??@?ü•ªs2‚ª“_‚Ì?ê?‡
        if ((p3.getx() == p4.getx()) && (p3.gety() == p4.gety())) {
            if ((hakononaka(p1, p3, p2) >= 1) && (t1.dainyuukeisan(p3) == 0.0)) {
                return 6;
            }
            return 0;
        }

        // System.out.println("AAAAAAAAAAAA");
        if (heikou_hantei(t1, t2, rhei) == 0) {    //‚Q‚Â‚Ì’¼?ü‚ª•½?s‚Å‚È‚¢
            Ten pk = new Ten();
            pk.set(kouten_motome(t1, t2));    //<<<<<<<<<<<<<<<<<<<<<<<
            if ((hakononaka(p1, pk, p2) >= 1)
                    && (hakononaka(p3, pk, p4) >= 1)) {
                if (hitosii(p1, p3, rhit)) {
                    return 21;
                }//LŽšŒ^
                if (hitosii(p1, p4, rhit)) {
                    return 22;
                }//LŽšŒ^
                if (hitosii(p2, p3, rhit)) {
                    return 23;
                }//LŽšŒ^
                if (hitosii(p2, p4, rhit)) {
                    return 24;
                }//LŽšŒ^
                if (hitosii(p1, pk, rhit)) {
                    return 25;
                }//TŽšŒ^ s1‚ª?c–_
                if (hitosii(p2, pk, rhit)) {
                    return 26;
                }//TŽšŒ^ s1‚ª?c–_
                if (hitosii(p3, pk, rhit)) {
                    return 27;
                }//TŽšŒ^ s2‚ª?c–_
                if (hitosii(p4, pk, rhit)) {
                    return 28;
                }//TŽšŒ^ s2‚ª?c–_
                return 1;                    // <<<<<<<<<<<<<<<<< return 1;
            }
            return 0;
        }

        if (heikou_hantei(t1, t2, rhei) == 1) { //‚Q‚Â‚Ì’¼?ü‚ª•½?s‚Å?Ay?Ø•Ð‚Íˆê’v‚µ‚È‚¢
            // System.out.println("BBBBBBBBBBB");
            return 0;
        }

        // ‚Q‚Â‚Ì?ü•ª‚ª‘S‚­“¯‚¶
        if (hitosii(p1, p3, rhit) && hitosii(p2, p4, rhit)) {
            return 31;
        }
        if (hitosii(p1, p4, rhit) && hitosii(p2, p3, rhit)) {
            return 31;
        }

        // System.out.println("###########");

        //‚Q‚Â‚Ì’¼?ü‚ª•½?s‚Å?Ay?Ø•Ð‚àˆê’v‚·‚é
        if (heikou_hantei(t1, t2, rhei) == 2) {
            if (hitosii(p1, p3, rhit)) { //2‚Â‚Ì?ü•ª‚Ì’[“_‚Ç‚¤‚µ‚ª1“_‚Å?d‚È‚é?ê?‡
                if (hakononaka(p1, p4, p2) == 2) {
                    return 321;
                }
                if (hakononaka(p3, p2, p4) == 2) {
                    return 322;
                }
                if (hakononaka(p2, p1, p4) == 2) {
                    return 323;
                }//2‚Â‚Ì?ü•ª‚Í1“_‚Å?d‚È‚é‚¾‚¯‚Å?A‚»‚êˆÈŠO‚Å‚Í?d‚È‚ç‚È‚¢
            }

            if (hitosii(p1, p4, rhit)) {
                if (hakononaka(p1, p3, p2) == 2) {
                    return 331;
                }
                if (hakononaka(p4, p2, p3) == 2) {
                    return 332;
                }
                if (hakononaka(p2, p1, p3) == 2) {
                    return 333;
                }//2‚Â‚Ì?ü•ª‚Í1“_‚Å?d‚È‚é‚¾‚¯‚Å?A‚»‚êˆÈŠO‚Å‚Í?d‚È‚ç‚È‚¢
            }

            if (hitosii(p2, p3, rhit)) {
                if (hakononaka(p2, p4, p1) == 2) {
                    return 341;
                }
                if (hakononaka(p3, p1, p4) == 2) {
                    return 342;
                }
                if (hakononaka(p1, p2, p4) == 2) {
                    return 343;
                }//2‚Â‚Ì?ü•ª‚Í1“_‚Å?d‚È‚é‚¾‚¯‚Å?A‚»‚êˆÈŠO‚Å‚Í?d‚È‚ç‚È‚¢
            }

            if (hitosii(p2, p4, rhit)) {
                if (hakononaka(p2, p3, p1) == 2) {
                    return 351;
                }
                if (hakononaka(p4, p1, p3) == 2) {
                    return 352;
                }
                if (hakononaka(p1, p2, p3) == 2) {
                    return 353;
                }//2‚Â‚Ì?ü•ª‚Í1“_‚Å?d‚È‚é‚¾‚¯‚Å?A‚»‚êˆÈŠO‚Å‚Í?d‚È‚ç‚È‚¢
            }

            //2‚Â‚Ì?ü•ª‚Ì’[“_‚Ç‚¤‚µ‚ª?d‚È‚ç‚È‚¢?ê?‡
            if ((hakononaka(p1, p3, p4) == 2) && (hakononaka(p3, p4, p2) == 2)) {
                return 361;
            }//?ü•ª(p1,p2)‚É?ü•ª(p3,p4)‚ªŠÜ‚Ü‚ê‚é
            if ((hakononaka(p1, p4, p3) == 2) && (hakononaka(p4, p3, p2) == 2)) {
                return 362;
            }//?ü•ª(p1,p2)‚É?ü•ª(p3,p4)‚ªŠÜ‚Ü‚ê‚é

            if ((hakononaka(p3, p1, p2) == 2) && (hakononaka(p1, p2, p4) == 2)) {
                return 363;
            }//?ü•ª(p3,p4)‚É?ü•ª(p1,p2)‚ªŠÜ‚Ü‚ê‚é
            if ((hakononaka(p3, p2, p1) == 2) && (hakononaka(p2, p1, p4) == 2)) {
                return 364;
            }//?ü•ª(p3,p4)‚É?ü•ª(p1,p2)‚ªŠÜ‚Ü‚ê‚é


            if ((hakononaka(p1, p3, p2) == 2) && (hakononaka(p3, p2, p4) == 2)) {
                return 371;
            }//?ü•ª(p1,p2)‚ÌP2‘¤‚Æ?ü•ª(p3,p4)‚ÌP3‘¤‚ª•”•ª“I‚É?d‚È‚é
            if ((hakononaka(p1, p4, p2) == 2) && (hakononaka(p4, p2, p3) == 2)) {
                return 372;
            }//?ü•ª(p1,p2)‚ÌP2‘¤‚Æ?ü•ª(p4,p3)‚ÌP4‘¤‚ª•”•ª“I‚É?d‚È‚é

            if ((hakononaka(p3, p1, p4) == 2) && (hakononaka(p1, p4, p2) == 2)) {
                return 373;
            }//?ü•ª(p3,p4)‚ÌP4‘¤‚Æ?ü•ª(p1,p2)‚ÌP1‘¤‚ª•”•ª“I‚É?d‚È‚é
            if ((hakononaka(p4, p1, p3) == 2) && (hakononaka(p1, p3, p2) == 2)) {
                return 374;
            }//?ü•ª(p4,p3)‚ÌP3‘¤‚Æ?ü•ª(p1,p2)‚ÌP1‘¤‚ª•”•ª“I‚É?d‚È‚é

            return 0;
        }
        return -1;//‚±‚±‚Í‰½‚ç‚©‚ÌƒGƒ‰?[‚ÌŽž‚É’Ê‚é?B

    }


    //senbun_kousa_hantei_amai‚ÌŠÃ‚¢‚Æ‚±‚ë‚Í?A‹ï‘Ì“I‚É‚Íreturn 21‚©‚çreturn 28‚Ü‚Å‚Ì‘O’ñ‚É‚È‚é	if( (hakononaka(p1,pk,p2)>=1)&& (hakononaka(p3,pk,p4)>=1) )‚Ì‚©‚í‚è‚É
    // (hakononaka_amai(p1,pk,p2)>=1)&& (hakononaka_amai(p3,pk,p4)‚ðŽg‚Á‚Ä‚¢‚é‚±‚Æ?Bhakononaka_amai‚Í
    //“_pa‚ª?A“ñ“_p1,p2‚ð’[“_‚Æ‚·‚é?ü•ª‚É“_p1‚Æ“_p2‚Å’¼?s‚·‚é?A2‚Â‚Ì?ü•ª‚ðŠÜ‚Þ’·•ûŒ`“à‚É‚ ‚é?ê?‡‚Í2‚ð•Ô‚·ŠÖ?”?B‚±‚ê‚Í ?­‚µ‚Í‚Ý?o‚µ‚Ä‚à’·•ûŒ`“à‚É‚ ‚é‚Æ‚Ý‚È‚·?B
    //‹ï‘Ì“I‚É‚Í?ü•ª‚Ì’†‚É“_‚ª‚ ‚é‚©‚Ì”»’è‚Ì?Û?A‚í‚¸‚©‚É“_‚ª?ü•ª‚ÌŠO‚É‚ ‚é?ê?‡‚Í?A?ü•ª‚Ì’†‚É‚ ‚é‚Æ?AŠÃ‚­”»’è‚·‚é?B•`‚«?E?l‚Å“WŠJ?}‚ð•`‚­‚Æ‚«‚Í?A‚±‚ÌŠÃ‚¢‚Ù‚¤‚ðŽg‚í‚È‚¢‚ÆTŽšŒ^‚Ì?ü•ª‚ÌŒð?·•ªŠ„‚ÉŽ¸”s‚·‚é
    //‚µ‚©‚µ?A‚È‚º‚©?A?Ü‚è?ô‚Ý?„’è‚É‚±‚ÌŠÃ‚¢‚Ù‚¤‚ðŽg‚¤‚Æ–³ŒÀƒ‹?[ƒv‚É‚È‚é‚æ‚¤‚Å?A‚¤‚Ü‚­‚¢‚©‚È‚¢?B‚±‚Ì?³Šm‚È‰ð–¾‚Í–¢‰ðŒˆ20161105

    public int senbun_kousa_hantei_amai(Senbun s1, Senbun s2, double rhit, double rhei) {    //r_hitosii‚Ær_heikouhantei‚Í?Ahitosii‚Æheikou_hantei‚Ì‚¸‚ê‚Ì‹–—e’ö“x
        double x1max = s1.getax();
        double x1min = s1.getax();
        double y1max = s1.getay();
        double y1min = s1.getay();
        if (x1max < s1.getbx()) {
            x1max = s1.getbx();
        }
        if (x1min > s1.getbx()) {
            x1min = s1.getbx();
        }
        if (y1max < s1.getby()) {
            y1max = s1.getby();
        }
        if (y1min > s1.getby()) {
            y1min = s1.getby();
        }
        double x2max = s2.getax();
        double x2min = s2.getax();
        double y2max = s2.getay();
        double y2min = s2.getay();
        if (x2max < s2.getbx()) {
            x2max = s2.getbx();
        }
        if (x2min > s2.getbx()) {
            x2min = s2.getbx();
        }
        if (y2max < s2.getby()) {
            y2max = s2.getby();
        }
        if (y2min > s2.getby()) {
            y2min = s2.getby();
        }

        if (x1max + rhit + 0.1 < x2min) {
            return 0;
        }
        if (x1min - rhit - 0.1 > x2max) {
            return 0;
        }
        if (y1max + rhit + 0.1 < y2min) {
            return 0;
        }
        if (y1min - rhit - 0.1 > y2max) {
            return 0;
        }

        //System.out.println("###########");

        Ten p1 = new Ten();
        p1.set(s1.geta());
        Ten p2 = new Ten();
        p2.set(s1.getb());
        Ten p3 = new Ten();
        p3.set(s2.geta());
        Ten p4 = new Ten();
        p4.set(s2.getb());

        Tyokusen t1 = new Tyokusen(p1, p2);
        Tyokusen t2 = new Tyokusen(p3, p4);
        //System.out.print("?@?@?ü•ªŒð?·”»’è‚Å‚Ì•½?s”»’è‚ÌŒ‹‰Ê?@???@");
        //System.out.println (heikou_hantei(t1,t2,rhei));
        // heikou_hantei(t1,t2,rhei)

        //—áŠO?ˆ—??@?ü•ªs1‚Æ?ü•ªs2‚ª“_‚Ì?ê?‡
        if (((p1.getx() == p2.getx()) && (p1.gety() == p2.gety()))
                &&
                ((p3.getx() == p4.getx()) && (p3.gety() == p4.gety()))) {
            if ((p1.getx() == p3.getx()) && (p1.gety() == p3.gety())) {
                return 4;
            }
            return 0;
        }

        //—áŠO?ˆ—??@?ü•ªs1‚ª“_‚Ì?ê?‡
        if ((p1.getx() == p2.getx()) && (p1.gety() == p2.gety())) {
            if ((hakononaka(p3, p1, p4) >= 1) && (t2.dainyuukeisan(p1) == 0.0)) {
                return 5;
            }
            return 0;
        }

        //—áŠO?ˆ—??@?ü•ªs2‚ª“_‚Ì?ê?‡
        if ((p3.getx() == p4.getx()) && (p3.gety() == p4.gety())) {
            if ((hakononaka(p1, p3, p2) >= 1) && (t1.dainyuukeisan(p3) == 0.0)) {
                return 6;
            }
            return 0;
        }

        // System.out.println("AAAAAAAAAAAA");
        if (heikou_hantei(t1, t2, rhei) == 0) {    //‚Q‚Â‚Ì’¼?ü‚ª•½?s‚Å‚È‚¢
            Ten pk = new Ten();
            pk.set(kouten_motome(t1, t2));    //<<<<<<<<<<<<<<<<<<<<<<<
            if ((hakononaka_amai(p1, pk, p2) >= 1)
                    && (hakononaka_amai(p3, pk, p4) >= 1)) {
                if (hitosii(p1, p3, rhit)) {
                    return 21;
                }
                if (hitosii(p1, p4, rhit)) {
                    return 22;
                }
                if (hitosii(p2, p3, rhit)) {
                    return 23;
                }
                if (hitosii(p2, p4, rhit)) {
                    return 24;
                }
                if (hitosii(p1, pk, rhit)) {
                    return 25;
                }
                if (hitosii(p2, pk, rhit)) {
                    return 26;
                }
                if (hitosii(p3, pk, rhit)) {
                    return 27;
                }
                if (hitosii(p4, pk, rhit)) {
                    return 28;
                }
                return 1;
            }
            return 0;
        }

        if (heikou_hantei(t1, t2, rhei) == 1) { //‚Q‚Â‚Ì’¼?ü‚ª•½?s‚Å?Ay?Ø•Ð‚Íˆê’v‚µ‚È‚¢
            // System.out.println("BBBBBBBBBBB");
            return 0;
        }

        // ‚Q‚Â‚Ì?ü•ª‚ª‘S‚­“¯‚¶
        if (hitosii(p1, p3, rhit) && hitosii(p2, p4, rhit)) {
            return 31;
        }
        if (hitosii(p1, p4, rhit) && hitosii(p2, p3, rhit)) {
            return 31;
        }

        // System.out.println("###########");

        //‚Q‚Â‚Ì’¼?ü‚ª•½?s‚Å?Ay?Ø•Ð‚àˆê’v‚·‚é
        if (heikou_hantei(t1, t2, rhei) == 2) {
            if (hitosii(p1, p3, rhit)) { //2‚Â‚Ì?ü•ª‚Ì’[“_‚Ç‚¤‚µ‚ª1“_‚Å?d‚È‚é?ê?‡
                if (hakononaka(p1, p4, p2) == 2) {
                    return 321;
                }//’·‚¢?ü•ª‚É’Z‚¢?ü•ª‚ªŠÜ‚Ü‚ê‚é
                if (hakononaka(p3, p2, p4) == 2) {
                    return 322;
                }//’·‚¢?ü•ª‚É’Z‚¢?ü•ª‚ªŠÜ‚Ü‚ê‚é
                if (hakononaka(p2, p1, p4) == 2) {
                    return 323;
                }//2‚Â‚Ì?ü•ª‚Í1“_‚Å?d‚È‚é‚¾‚¯‚Å?A‚»‚êˆÈŠO‚Å‚Í?d‚È‚ç‚È‚¢
            }

            if (hitosii(p1, p4, rhit)) {
                if (hakononaka(p1, p3, p2) == 2) {
                    return 331;
                }//’·‚¢?ü•ª‚É’Z‚¢?ü•ª‚ªŠÜ‚Ü‚ê‚é
                if (hakononaka(p4, p2, p3) == 2) {
                    return 332;
                }//’·‚¢?ü•ª‚É’Z‚¢?ü•ª‚ªŠÜ‚Ü‚ê‚é
                if (hakononaka(p2, p1, p3) == 2) {
                    return 333;
                }//2‚Â‚Ì?ü•ª‚Í1“_‚Å?d‚È‚é‚¾‚¯‚Å?A‚»‚êˆÈŠO‚Å‚Í?d‚È‚ç‚È‚¢
            }

            if (hitosii(p2, p3, rhit)) {
                if (hakononaka(p2, p4, p1) == 2) {
                    return 341;
                }//’·‚¢?ü•ª‚É’Z‚¢?ü•ª‚ªŠÜ‚Ü‚ê‚é
                if (hakononaka(p3, p1, p4) == 2) {
                    return 342;
                }//’·‚¢?ü•ª‚É’Z‚¢?ü•ª‚ªŠÜ‚Ü‚ê‚é
                if (hakononaka(p1, p2, p4) == 2) {
                    return 343;
                }//2‚Â‚Ì?ü•ª‚Í1“_‚Å?d‚È‚é‚¾‚¯‚Å?A‚»‚êˆÈŠO‚Å‚Í?d‚È‚ç‚È‚¢
            }

            if (hitosii(p2, p4, rhit)) {
                if (hakononaka(p2, p3, p1) == 2) {
                    return 351;
                }//’·‚¢?ü•ª‚É’Z‚¢?ü•ª‚ªŠÜ‚Ü‚ê‚é
                if (hakononaka(p4, p1, p3) == 2) {
                    return 352;
                }//’·‚¢?ü•ª‚É’Z‚¢?ü•ª‚ªŠÜ‚Ü‚ê‚é
                if (hakononaka(p1, p2, p3) == 2) {
                    return 353;
                }//2‚Â‚Ì?ü•ª‚Í1“_‚Å?d‚È‚é‚¾‚¯‚Å?A‚»‚êˆÈŠO‚Å‚Í?d‚È‚ç‚È‚¢
            }

            //2‚Â‚Ì?ü•ª‚Ì’[“_‚Ç‚¤‚µ‚ª?d‚È‚ç‚È‚¢?ê?‡
            if ((hakononaka(p1, p3, p4) == 2) && (hakononaka(p3, p4, p2) == 2)) {
                return 361;
            }//?ü•ª(p1,p2)‚É?ü•ª(p3,p4)‚ªŠÜ‚Ü‚ê‚é
            if ((hakononaka(p1, p4, p3) == 2) && (hakononaka(p4, p3, p2) == 2)) {
                return 362;
            }//?ü•ª(p1,p2)‚É?ü•ª(p3,p4)‚ªŠÜ‚Ü‚ê‚é

            if ((hakononaka(p3, p1, p2) == 2) && (hakononaka(p1, p2, p4) == 2)) {
                return 363;
            }//?ü•ª(p3,p4)‚É?ü•ª(p1,p2)‚ªŠÜ‚Ü‚ê‚é
            if ((hakononaka(p3, p2, p1) == 2) && (hakononaka(p2, p1, p4) == 2)) {
                return 364;
            }//?ü•ª(p3,p4)‚É?ü•ª(p1,p2)‚ªŠÜ‚Ü‚ê‚é

            if ((hakononaka(p1, p3, p2) == 2) && (hakononaka(p3, p2, p4) == 2)) {
                return 371;
            }
            if ((hakononaka(p1, p4, p2) == 2) && (hakononaka(p4, p2, p3) == 2)) {
                return 372;
            }
            if ((hakononaka(p3, p1, p4) == 2) && (hakononaka(p1, p4, p2) == 2)) {
                return 373;
            }
            if ((hakononaka(p4, p1, p3) == 2) && (hakononaka(p1, p3, p2) == 2)) {
                return 374;
            }

            return 0;
        }
        return -1;//‚±‚±‚Í‰½‚ç‚©‚ÌƒGƒ‰?[‚ÌŽž‚É’Ê‚é?B

    }


    //‚Q‚Â‚Ì’¼?ü‚ª•½?s‚©‚Ç‚¤‚©‚ð”»’è‚·‚éŠÖ?”?B
    public int heikou_hantei(Tyokusen t1, Tyokusen t2) {
        return heikou_hantei(t1, t2, 0.1);
    }

    //‚Q‚Â‚Ì?ü•ª‚ª•½?s‚©‚Ç‚¤‚©‚ð”»’è‚·‚éŠÖ?”?B
    public int heikou_hantei(Senbun s1, Senbun s2, double r) {
        return heikou_hantei(Senbun2Tyokusen(s1), Senbun2Tyokusen(s2), r);
    }


    public int heikou_hantei(Tyokusen t1, Tyokusen t2, double r) {//r‚ÍŒë?·‚Ì‹–—e“x?Br‚ª•‰‚È‚çŒµ–§”»’è?B
        //0=•½?s‚Å‚È‚¢?A1=•½?s‚Å‚Q’¼?ü‚ªˆê’v‚µ‚È‚¢?A2=•½?s‚Å‚Q’¼?ü‚ªˆê’v‚·‚é
        double a1 = t1.geta(), b1 = t1.getb(), c1 = t1.getc();//’¼?üt1, a1*x+b1*y+c1=0‚ÌŠeŒW?”‚ð‹?‚ß‚é?B
        double a2 = t2.geta(), b2 = t2.getb(), c2 = t2.getc();//’¼?üt2, a2*x+b2*y+c2=0‚ÌŠeŒW?”‚ð‹?‚ß‚é?B

        //System.out.print("•½?s”»’è‚Ìr?@???@");System.out.println(r);
        //Œµ–§‚É”»’è----------------------------------------
        if (r <= 0.0) {
            //‚Q’¼?ü‚ª•½?s‚Ì?ê?‡
            if (a1 * b2 - a2 * b1 == 0) {
                //‚Q’¼?ü‚Í“¯ˆê‚Ì?ê?‡
                if ((a1 * a1 + b1 * b1) * c2 * c2 == (a2 * a2 + b2 * b2) * c1 * c1) {
                    return 2;
                }//Œµ–§‚É”»’è?B
                //‚Q’¼?ü‚ªˆÙ‚È‚é?ê?‡
                else {
                    return 1;
                }
            }
        }

        //Œë?·‚ð‹–—e----------------------------------------
        if (r > 0) {
            //‚Q’¼?ü‚ª•½?s‚Ì?ê?‡
            if (Math.abs(a1 * b2 - a2 * b1) < r) {
                //‚Q’¼?ü‚Í“¯ˆê‚Ì?ê?‡


                //Œ´“_?i0?A0?j‚ÆŠe’¼?ü‚Æ‚Ì‹——£‚ð”äŠr
                //double kyoriT=Math.abs(c1/Math.sqrt(a1*a1+b1*b1)-c2/Math.sqrt(a2*a2+b2*b2));//20181027?Aver3.049‚Ü‚Å‚ÌƒoƒO‚ ‚è‚Ì?ˆ—?
                //double kyoriT=Math.abs(   Math.abs(  c1/Math.sqrt(a1*a1+b1*b1)  )  -   Math.abs(  c2/Math.sqrt(a2*a2+b2*b2)  )      );//20181027?Aver3.050ˆÈ?~‚ÌƒoƒO–³‚µ‚Ì?ˆ—?
                double kyoriT = t2.kyorikeisan(t1.kage_motome(new Ten(0.0, 0.0)));//t1?ã‚Ì“_‚Æt2‚Æ‚Ì‹——£//t1.kage_motome(new Ten(0.0,0.0))   ‚Í“_?i0,0?j‚Ìt1?ã‚Ì‰e‚ð‹?‚ß‚é?it1?ã‚Ì“_‚È‚ç‚È‚ñ‚Å‚à‚¢‚¢?j//20181115?C?³


                if (kyoriT < r) {//Œë?·‚ð‹–—e?B
                    return 2;
                }
                //‚Q’¼?ü‚ªˆÙ‚È‚é?ê?‡
                else {
                    return 1;
                }
            }
        }

        //‚Q’¼?ü‚ª”ñ•½?s‚Ì?ê?‡-------------------------------------------------
        return 0;
    }


    //‚Q‚Â‚Ì’¼?ü‚ÌŒð“_‚ð‹?‚ß‚éŠÖ?”
    public Ten kouten_motome(Tyokusen t1, Tyokusen t2) {
        double a1 = t1.geta(), b1 = t1.getb(), c1 = t1.getc();//’¼?üt1, a1*x+b1*y+c1=0‚ÌŠeŒW?”‚ð‹?‚ß‚é?B
        double a2 = t2.geta(), b2 = t2.getb(), c2 = t2.getc();//’¼?üt2, a2*x+b2*y+c2=0‚ÌŠeŒW?”‚ð‹?‚ß‚é?B

//System.out.println("   "+(b1*c2-b2*c1)/(a1*b2-a2*b1)+"::::::::"+(a2*c1-a1*c2)/(a1*b2-a2*b1));

        return new Ten((b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1), (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1));
    }


    //‚Q‚Â‚Ì’¼?ü‚ÌŒð“_‚ð‹?‚ß‚éŠÖ?”(•¡?»)
    public Ten kouten_motome_01(Tyokusen t1, Tyokusen t2) {
        double a1 = t1.geta(), b1 = t1.getb(), c1 = t1.getc();//’¼?üt1, a1*x+b1*y+c1=0‚ÌŠeŒW?”‚ð‹?‚ß‚é?B
        double a2 = t2.geta(), b2 = t2.getb(), c2 = t2.getc();//’¼?üt2, a2*x+b2*y+c2=0‚ÌŠeŒW?”‚ð‹?‚ß‚é?B
        return new Ten((b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1), (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1));
    }


    public Tyokusen Senbun2Tyokusen(Senbun s) {//?ü•ª‚ðŠÜ‚Þ’¼?ü‚ð“¾‚é
        Tyokusen t = new Tyokusen(s.geta(), s.getb());
        return t;
    }

    //‚Q‚Â‚Ì?ü•ª‚ð’¼?ü‚Æ‚Ý‚È‚µ‚ÄŒð“_‚ð‹?‚ß‚éŠÖ?”?B?ü•ª‚Æ‚µ‚Ä‚ÍŒð?·‚µ‚È‚­‚Ä‚à?A’¼?ü‚Æ‚µ‚ÄŒð?·‚µ‚Ä‚¢‚é?ê?‡‚ÌŒð“_‚ð•Ô‚·
    public Ten kouten_motome(Senbun s1, Senbun s2) {
        return kouten_motome(Senbun2Tyokusen(s1), Senbun2Tyokusen(s2));
    }

    //?ü•ª‚ð’¼?ü‚Æ‚Ý‚È‚µ‚Ä‘¼‚Ì’¼?ü‚Æ‚ÌŒð“_‚ð‹?‚ß‚éŠÖ?”?B?ü•ª‚Æ‚µ‚Ä‚ÍŒð?·‚µ‚È‚­‚Ä‚à?A’¼?ü‚Æ‚µ‚ÄŒð?·‚µ‚Ä‚¢‚é?ê?‡‚ÌŒð“_‚ð•Ô‚·
    public Ten kouten_motome(Tyokusen t1, Senbun s2) {
        return kouten_motome(t1, Senbun2Tyokusen(s2));
    }

    //?ü•ª‚ð’¼?ü‚Æ‚Ý‚È‚µ‚Ä‘¼‚Ì’¼?ü‚Æ‚ÌŒð“_‚ð‹?‚ß‚éŠÖ?”?B?ü•ª‚Æ‚µ‚Ä‚ÍŒð?·‚µ‚È‚­‚Ä‚à?A’¼?ü‚Æ‚µ‚ÄŒð?·‚µ‚Ä‚¢‚é?ê?‡‚ÌŒð“_‚ð•Ô‚·
    public Ten kouten_motome(Senbun s1, Tyokusen t2) {
        return kouten_motome(Senbun2Tyokusen(s1), t2);
    }


    //?ü•ª‚ð?^‰¡‚É•½?sˆÚ“®‚·‚éŠÖ?”?iŒ³‚Ì?ü•ª‚Í•Ï‚¦‚¸‚É?V‚µ‚¢?ü•ª‚ð•Ô‚·?j
    public Senbun mayoko_idou(Senbun s, double d) {
        Tyokusen t = new Tyokusen(s.geta(), s.getb());
        Tyokusen ta = new Tyokusen(s.geta(), s.getb());
        Tyokusen tb = new Tyokusen(s.geta(), s.getb());
        ta.tyokkouka(s.geta());
        tb.tyokkouka(s.getb());
        Tyokusen td = new Tyokusen(s.geta(), s.getb());
        td.heikouidou(d);

        Senbun sreturn = new Senbun(kouten_motome_01(ta, td), kouten_motome_01(tb, td));

        return sreturn;
    }

    //------------------------------------
    //“_a‚ð’†?S‚É“_b‚ðd“x‰ñ“]‚µ‚½“_‚ð•Ô‚·ŠÖ?”?iŒ³‚Ì“_‚Í•Ï‚¦‚¸‚É?V‚µ‚¢“_‚ð•Ô‚·?j
    public Ten ten_kaiten(Ten a, Ten b, double d) {

        double Mcd = Math.cos(d * Math.PI / 180.0);
        double Msd = Math.sin(d * Math.PI / 180.0);

        double bx1 = Mcd * (b.getx() - a.getx()) - Msd * (b.gety() - a.gety()) + a.getx();
        double by1 = Msd * (b.getx() - a.getx()) + Mcd * (b.gety() - a.gety()) + a.gety();

//double ax1=s0.getax();
//double ay1=s0.getay();
        Ten t_return = new Ten(bx1, by1);

        return t_return;
    }

    //------------------------------------
    //“_a‚ð’†?S‚É“_b‚ðd“x‰ñ“]‚µab‚Ì‹——£‚ªr”{‚Ì“_‚ð•Ô‚·ŠÖ?”?iŒ³‚Ì“_‚Í•Ï‚¦‚¸‚É?V‚µ‚¢“_‚ð•Ô‚·?j
    public Ten ten_kaiten(Ten a, Ten b, double d, double r) {

        double Mcd = Math.cos(d * Math.PI / 180.0);
        double Msd = Math.sin(d * Math.PI / 180.0);

        double bx1 = r * (Mcd * (b.getx() - a.getx()) - Msd * (b.gety() - a.gety())) + a.getx();
        double by1 = r * (Msd * (b.getx() - a.getx()) + Mcd * (b.gety() - a.gety())) + a.gety();

        Ten t_return = new Ten(bx1, by1);

        return t_return;
    }

    //------------------------------------
    //“_a‚ð’†?S‚É“_b‚ðŒ³‚É‚µ‚Äab‚Ì‹——£‚ªr”{‚Ì“_‚ð•Ô‚·ŠÖ?”?iŒ³‚Ì“_‚Í•Ï‚¦‚¸‚É?V‚µ‚¢“_‚ð•Ô‚·?j20161224 –¢ŒŸ?Ø
    public Ten ten_bai(Ten a, Ten b, double r) {
        double bx1 = r * (b.getx() - a.getx()) + a.getx();
        double by1 = r * (b.gety() - a.gety()) + a.gety();

        Ten t_return = new Ten(bx1, by1);

        return t_return;
    }


//------------------------------------

    //?ü•ªab‚ðc‚ð’†?S‚Ér”{‚µ‚Äd“x‰ñ“]‚µ‚½?ü•ª‚ð•Ô‚·ŠÖ?”?iŒ³‚Ì?ü•ª‚Í•Ï‚¦‚¸‚É?V‚µ‚¢?ü•ª‚ð•Ô‚·?j
    public Senbun Senbun_kaiten(Senbun s0, Ten c, double d, double r) {
        Senbun s_return = new Senbun(ten_kaiten(s0.geta(), c, d, r), ten_kaiten(s0.getb(), c, d, r));
        return s_return;
    }


// ------------------------------------

    //?ü•ªab‚ða‚ð’†?S‚Éd“x‰ñ“]‚µ‚½?ü•ª‚ð•Ô‚·ŠÖ?”?iŒ³‚Ì?ü•ª‚Í•Ï‚¦‚¸‚É?V‚µ‚¢?ü•ª‚ð•Ô‚·?j
    public Senbun Senbun_kaiten(Senbun s0, double d) {
//s0.getax(),s0.getay()

//(Math.cos(d*3.14159265/180.0),-Math.sin(d*3.14159265/180.0) )  (s0.getbx()-s0.getax()) + (s0.getax())
//(Math.sin(d*3.14159265/180.0), Math.cos(d*3.14159265/180.0) )  (s0.getby()-s0.getay())   (s0.getay())

//double Mcd=Math.cos(d*3.14159265/180.0);
//double Msd=Math.sin(d*3.14159265/180.0);
        double Mcd = Math.cos(d * Math.PI / 180.0);
        double Msd = Math.sin(d * Math.PI / 180.0);

        double bx1 = Mcd * (s0.getbx() - s0.getax()) - Msd * (s0.getby() - s0.getay()) + s0.getax();
        double by1 = Msd * (s0.getbx() - s0.getax()) + Mcd * (s0.getby() - s0.getay()) + s0.getay();

        double ax1 = s0.getax();
        double ay1 = s0.getay();
        Senbun s_return = new Senbun(ax1, ay1, bx1, by1);

        return s_return;
    }


    //?ü•ªab‚ða‚ð’†?S‚Ér”{‚µ‚Äd“x‰ñ“]‚µ‚½?ü•ª‚ð•Ô‚·ŠÖ?”?iŒ³‚Ì?ü•ª‚Í•Ï‚¦‚¸‚É?V‚µ‚¢?ü•ª‚ð•Ô‚·?j
    public Senbun Senbun_kaiten(Senbun s0, double d, double r) {
        //s0.getax(),s0.getay()

        //(Math.cos(d*3.14159265/180.0),-Math.sin(d*3.14159265/180.0) )  (s0.getbx()-s0.getax()) + (s0.getax())
        //(Math.sin(d*3.14159265/180.0), Math.cos(d*3.14159265/180.0) )  (s0.getby()-s0.getay())   (s0.getay())

        double Mcd = Math.cos(d * Math.PI / 180.0);
        double Msd = Math.sin(d * Math.PI / 180.0);

        double bx1 = r * (Mcd * (s0.getbx() - s0.getax()) - Msd * (s0.getby() - s0.getay())) + s0.getax();
        double by1 = r * (Msd * (s0.getbx() - s0.getax()) + Mcd * (s0.getby() - s0.getay())) + s0.getay();

        double ax1 = s0.getax();
        double ay1 = s0.getay();
        Senbun s_return = new Senbun(ax1, ay1, bx1, by1);

        return s_return;
    }


    //?ü•ªab‚ða‚ð’†?S‚Ér”{‚µ‚½?ü•ª‚ð•Ô‚·ŠÖ?”?iŒ³‚Ì?ü•ª‚Í•Ï‚¦‚¸‚É?V‚µ‚¢?ü•ª‚ð•Ô‚·?j
    public Senbun Senbun_bai(Senbun s0, double r) {

        double bx1 = r * (s0.getbx() - s0.getax()) + s0.getax();
        double by1 = r * (s0.getby() - s0.getay()) + s0.getay();

        double ax1 = s0.getax();
        double ay1 = s0.getay();
        Senbun s_return = new Senbun(ax1, ay1, bx1, by1);

        return s_return;
    }


    //?ü•ªA‚Ì?A?ü•ªJ‚ðŽ²‚Æ‚µ‚½‘Î?ÆˆÊ’u‚É‚ ‚é?ü•ªB‚ð‹?‚ß‚éŠÖ?”
    public Senbun sentaisyou_senbun_motome(Senbun s0, Senbun jiku) {
        Ten p_a = new Ten();
        p_a.set(s0.geta());
        Ten p_b = new Ten();
        p_b.set(s0.getb());
        Ten jiku_a = new Ten();
        jiku_a.set(jiku.geta());
        Ten jiku_b = new Ten();
        jiku_b.set(jiku.getb());

        Senbun s1 = new Senbun();
        s1.set(sentaisyou_ten_motome(jiku_a, jiku_b, p_a), sentaisyou_ten_motome(jiku_a, jiku_b, p_b));

        return s1;
    }


    //’¼?üt0‚ÉŠÖ‚µ‚Ä?A“_p‚Ì‘Î?ÆˆÊ’u‚É‚ ‚é“_‚ð‹?‚ß‚éŠÖ?”
    public Ten sentaisyou_ten_motome(Tyokusen t0, Ten p) {
        Ten p1 = new Ten();  // p1.set(s.geta());
        Ten p2 = new Ten();  // p2.set(s.getb());

        Tyokusen s1 = new Tyokusen();
        s1.set(t0);
        Tyokusen s2 = new Tyokusen();
        s2.set(t0);

        s2.tyokkouka(p);//“_p‚ð’Ê‚Á‚Ä s1‚É’¼?s‚·‚é’¼?üs2‚ð‹?‚ß‚é?B

        p1 = kouten_motome(s1, s2);
        p2.set(2.0 * p1.getx() - p.getx(), 2.0 * p1.gety() - p.gety());
        return p2;
    }

    //‚Q‚Â‚Ì“_t1,t2‚ð’Ê‚é’¼?ü‚ÉŠÖ‚µ‚Ä?A“_p‚Ì‘Î?ÆˆÊ’u‚É‚ ‚é“_‚ð‹?‚ß‚éŠÖ?”
    public Ten sentaisyou_ten_motome(Ten t1, Ten t2, Ten p) {
        Ten p1 = new Ten();  // p1.set(s.geta());
        Ten p2 = new Ten();  // p2.set(s.getb());

        Tyokusen s1 = new Tyokusen(t1, t2);
        Tyokusen s2 = new Tyokusen(t1, t2);

        s2.tyokkouka(p);//“_p‚ð’Ê‚Á‚Ä s1‚É’¼?s‚·‚é’¼?üs2‚ð‹?‚ß‚é?B

        p1 = kouten_motome(s1, s2);
        p2.set(2.0 * p1.getx() - p.getx(), 2.0 * p1.gety() - p.gety());
        return p2;
    }

    //Šp“x‚ð-180.0“x‚æ‚è‘å‚«‚­180.0“xˆÈ‰º‚É‰Ÿ‚³‚¦‚éŠÖ?”
    public double kakudo_osame_m180_180(double kakudo) {
        while (kakudo <= -180.0) {
            kakudo = kakudo + 360.0;
        }
        while (kakudo > 180.0) {
            kakudo = kakudo - 360.0;
        }
        return kakudo;
    }

    //Šp“x‚ð0.0“xˆÈ?ã360.0“x–¢–ž‚É‰Ÿ‚³‚¦‚éŠÖ?”
    public double kakudo_osame_0_360(double kakudo) {
        while (kakudo < 0.0) {
            kakudo = kakudo + 360.0;
        }
        while (kakudo >= 360.0) {
            kakudo = kakudo - 360.0;
        }
        return kakudo;
    }


    //Šp“x‚ð0.0“xˆÈ?ãkmax“x–¢–ž‚É‰Ÿ‚³‚¦‚éŠÖ?”(‰~??‚Ì’¸“_‚Ì•šŒ©’è—?‚È‚Ç‚ÅŽg‚¤)
    public double kakudo_osame_0_kmax(double kakudo, double kmax) {
        while (kakudo < 0.0) {
            kakudo = kakudo + kmax;
        }
        while (kakudo >= kmax) {
            kakudo = kakudo - kmax;
        }
        return kakudo;
    }


    //?ü•ªs1‚Æs2‚Ì‚È‚·Šp“x
    public double kakudo(Senbun s1, Senbun s2) {
        Ten a = new Ten();
        a.set(s1.geta());
        Ten b = new Ten();
        b.set(s1.getb());
        Ten c = new Ten();
        c.set(s2.geta());
        Ten d = new Ten();
        d.set(s2.getb());

        return kakudo_osame_0_360(kakudo(c, d) - kakudo(a, b));
    }


    //ƒxƒNƒgƒ‹ab‚Æcd‚Ì‚È‚·Šp“x
    public double kakudo(Ten a, Ten b, Ten c, Ten d) {
        return kakudo_osame_0_360(kakudo(c, d) - kakudo(a, b));
    }

    //ŽOŠpŒ`‚Ì“à?S‚ð‹?‚ß‚é
    public Ten naisin(Ten ta, Ten tb, Ten tc) {
        double A, B, C, XA, XB, XC, YA, YB, YC, XD, YD, XE, YE, G, H, K, L, P, Q, XN, YN;
        Ten tn = new Ten();
        XA = ta.getx();
        YA = ta.gety();
        XB = tb.getx();
        YB = tb.gety();
        XC = tc.getx();
        YC = tc.gety();

        A = Math.sqrt((XC - XB) * (XC - XB) + (YC - YB) * (YC - YB));
        B = Math.sqrt((XA - XC) * (XA - XC) + (YA - YC) * (YA - YC));
        C = Math.sqrt((XB - XA) * (XB - XA) + (YB - YA) * (YB - YA));
        XD = (C * XC + B * XB) / (B + C);
        YD = (C * YC + B * YB) / (B + C);
        XE = (C * XC + A * XA) / (A + C);
        YE = (C * YC + A * YA) / (A + C);
        G = XD - XA;
        H = YD - YA;
        K = XE - XB;
        L = YE - YB;
        P = G * YA - H * XA;
        Q = K * YB - L * XB;
        XN = (G * Q - K * P) / (H * K - G * L);
        YN = (L * P - H * Q) / (G * L - H * K);

        tn.set(XN, YN);

        return tn;
    }

    // -------------------------------
    //“à•ª“_‚ð‹?‚ß‚é?B
    public Ten naibun(Ten a, Ten b, double d_naibun_s, double d_naibun_t) {
        Ten r_ten = new Ten(-10000.0, -10000.0);
        if (kyori(a, b) < 0.000001) {
            return r_ten;
        }

        if ((d_naibun_s == 0.0) && (d_naibun_t == 0.0)) {
            return r_ten;
        }
        if ((d_naibun_s == 0.0) && (d_naibun_t != 0.0)) {
            return a;
        }
        if ((d_naibun_s != 0.0) && (d_naibun_t == 0.0)) {
            return b;
        }
        if ((d_naibun_s != 0.0) && (d_naibun_t != 0.0)) {
            Senbun s_ab = new Senbun(a, b);
            double nx = (d_naibun_t * s_ab.getax() + d_naibun_s * s_ab.getbx()) / (d_naibun_s + d_naibun_t);
            double ny = (d_naibun_t * s_ab.getay() + d_naibun_s * s_ab.getby()) / (d_naibun_s + d_naibun_t);
            r_ten.set(nx, ny);
            return r_ten;
        }
        return r_ten;
    }

    // -------------------------------
    public Tyokusen en_to_en_no_kouten_wo_tooru_tyokusen(En e1, En e2) {
        double x1 = e1.getx();
        double y1 = e1.gety();
        double r1 = e1.getr();
        double x2 = e2.getx();
        double y2 = e2.gety();
        double r2 = e2.getr();

        double a = 2.0 * x1 - 2.0 * x2;
        double b = 2.0 * y1 - 2.0 * y2;
        double c = x2 * x2 - x1 * x1 + y2 * y2 - y1 * y1 + r1 * r1 - r2 * r2;

        Tyokusen r_t = new Tyokusen(a, b, c);

        return r_t;
    }

    // -------------------------------
    public Senbun en_to_en_no_kouten_wo_musubu_senbun(En e1, En e2) {

//System.out.println(" 20170301  e1="+e1.getx() +",    "+ e1.gety() +",    "+e1.getr());
//System.out.println(" 20170301  e2="+e2.getx() +",    "+ e2.gety() +",    "+e2.getr());

        Tyokusen t0 = new Tyokusen();
        t0.set(en_to_en_no_kouten_wo_tooru_tyokusen(e1, e2));
        Tyokusen t1 = new Tyokusen(e1.get_tyuusin(), e2.get_tyuusin());
        Ten kouten_t0t1 = new Ten();
        kouten_t0t1.set(kouten_motome(t0, t1));
        double nagasa_a = t0.kyorikeisan(e1.get_tyuusin());  //t0‚Æt1‚ÌŒð“_‚©‚çe1‚Ì’†?S‚Ü‚Å‚Ì’·‚³

//double nagasa_a=kyori(kouten_t0t1,e1.get_tyuusin());  //t0‚Æt1‚ÌŒð“_‚©‚çe1‚Ì’†?S‚Ü‚Å‚Ì’·‚³
        double nagasa_b = Math.sqrt(e1.getr() * e1.getr() - nagasa_a * nagasa_a); //t0‚Æt1‚ÌŒð“_‚©‚çe1‚Æe2‚ÌŒð“_‚Ü‚Å‚Ì’·‚³
//t0‚Æ•½?s‚È•ûŒüƒxƒNƒgƒ‹‚Í(t0.getb() , -t0.geta())
//t0‚Æ•½?s‚È•ûŒüƒxƒNƒgƒ‹‚Å’·‚³‚ªnagasa_b‚Ì‚à‚Ì‚Í(t0.getb()*nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta() ) , -t0.geta()*nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta() ))

//Senbun r_s=new Senbun();

        Senbun r_s = new Senbun(
                kouten_t0t1.getx() + t0.getb() * nagasa_b / Math.sqrt(t0.getb() * t0.getb() + t0.geta() * t0.geta()),
                kouten_t0t1.gety() - t0.geta() * nagasa_b / Math.sqrt(t0.getb() * t0.getb() + t0.geta() * t0.geta()),
                kouten_t0t1.getx() - t0.getb() * nagasa_b / Math.sqrt(t0.getb() * t0.getb() + t0.geta() * t0.geta()),
                kouten_t0t1.gety() + t0.geta() * nagasa_b / Math.sqrt(t0.getb() * t0.getb() + t0.geta() * t0.geta())
        );
/*
double ax,ay,bx,by;
//System.out.println(" 20170301 nagasa_b "+nagasa_b);
//System.out.println(" 20170301  "+nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta()));


//ax=kouten_t0t1.getx()+t0.getb()*nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta() );
ax=kouten_t0t1.getx()+t0.getb()*  0.2;//  nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta() );
ay=kouten_t0t1.gety()-t0.geta()*  0.2;//  nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta() );
bx=kouten_t0t1.getx()-t0.getb()*  0.2;//  nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta() );
by=kouten_t0t1.gety()+t0.geta()*  0.2;//  nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta() );
Ten ta=new Ten(ax+1.0,ay);
Ten tb=new Ten(bx,by+2.0);
r_s.set(ax,ay,bx,by);
*/

        return r_s;
    }


    // --------qqqqqqqqqqqqqqq-----------------------
    public Senbun en_to_tyokusen_no_kouten_wo_musubu_senbun(En e1, Tyokusen t0) {

//System.out.println(" 20170301  e1="+e1.getx() +",    "+ e1.gety() +",    "+e1.getr());
//System.out.println(" 20170301  e2="+e2.getx() +",    "+ e2.gety() +",    "+e2.getr());

//En e2 = new En(sentaisyou_ten_motome(t0,e1.get_tyuusin()),e1.getr(),3);
//Tyokusen t1 = new Tyokusen(e1.get_tyuusin(),e2.get_tyuusin());
        Ten kouten_t0t1 = new Ten();
        kouten_t0t1.set(kage_motome(t0, e1.get_tyuusin()));
        double nagasa_a = t0.kyorikeisan(e1.get_tyuusin());  //t0‚Æt1‚ÌŒð“_‚©‚çe1‚Ì’†?S‚Ü‚Å‚Ì’·‚³

//double nagasa_a=kyori(kouten_t0t1,e1.get_tyuusin());  //t0‚Æt1‚ÌŒð“_‚©‚çe1‚Ì’†?S‚Ü‚Å‚Ì’·‚³
        double nagasa_b = Math.sqrt(e1.getr() * e1.getr() - nagasa_a * nagasa_a); //t0‚Æt1‚ÌŒð“_‚©‚çe1‚Æe2‚ÌŒð“_‚Ü‚Å‚Ì’·‚³
//t0‚Æ•½?s‚È•ûŒüƒxƒNƒgƒ‹‚Í(t0.getb() , -t0.geta())
//t0‚Æ•½?s‚È•ûŒüƒxƒNƒgƒ‹‚Å’·‚³‚ªnagasa_b‚Ì‚à‚Ì‚Í(t0.getb()*nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta() ) , -t0.geta()*nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta() ))

//Senbun r_s=new Senbun();

        Senbun r_s = new Senbun(
                kouten_t0t1.getx() + t0.getb() * nagasa_b / Math.sqrt(t0.getb() * t0.getb() + t0.geta() * t0.geta()),
                kouten_t0t1.gety() - t0.geta() * nagasa_b / Math.sqrt(t0.getb() * t0.getb() + t0.geta() * t0.geta()),
                kouten_t0t1.getx() - t0.getb() * nagasa_b / Math.sqrt(t0.getb() * t0.getb() + t0.geta() * t0.geta()),
                kouten_t0t1.gety() + t0.geta() * nagasa_b / Math.sqrt(t0.getb() * t0.getb() + t0.geta() * t0.geta())
        );
/*
double ax,ay,bx,by;
//System.out.println(" 20170301 nagasa_b "+nagasa_b);
//System.out.println(" 20170301  "+nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta()));


//ax=kouten_t0t1.getx()+t0.getb()*nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta() );
ax=kouten_t0t1.getx()+t0.getb()*  0.2;//  nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta() );
ay=kouten_t0t1.gety()-t0.geta()*  0.2;//  nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta() );
bx=kouten_t0t1.getx()-t0.getb()*  0.2;//  nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta() );
by=kouten_t0t1.gety()+t0.geta()*  0.2;//  nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta() );
Ten ta=new Ten(ax+1.0,ay);
Ten tb=new Ten(bx,by+2.0);
r_s.set(ax,ay,bx,by);
*/

        return r_s;
    }

    //“_p0‚Æ?A‰~e0‚Ì‰~Žü‚Æ‚ÌŠÔ‚Ì‹——£‚ð‹?‚ß‚éŠÖ?”----------------------------------------------------
    public double kyori_ensyuu(Ten p0, En e0) {


        return Math.abs(kyori(p0, e0.get_tyuusin()) - e0.getr());
    }

    //Min‚ð•Ô‚·ŠÖ?”
    public double min(double d1, double d2, double d3, double d4) {
        double min_d = d1;
        if (min_d > d2) {
            min_d = d2;
        }
        if (min_d > d3) {
            min_d = d3;
        }
        if (min_d > d4) {
            min_d = d4;
        }
        return min_d;
    }


    public Senbun nitoubunsen(Ten t1, Ten t2, double d0) {

//s_step[i].geta(),s_step[j].geta(),200.0
        //double bx1=   r* (s0.getbx()-s0.getax())  +  s0.getax();
        //double by1=   r* (s0.getby()-s0.getay())  +  s0.getay();

        //double ax1=s0.getax();
        //double ay1=s0.getay();


        Ten tm = new Ten((t1.getx() + t2.getx()) / 2.0, (t1.gety() + t2.gety()) / 2.0);

        double bai = d0 / kyori(t1, t2);

        Senbun s1 = new Senbun();
        s1.set(Senbun_kaiten(new Senbun(tm, t1), 90.0, bai));
        Senbun s2 = new Senbun();
        s2.set(Senbun_kaiten(new Senbun(tm, t2), 90.0, bai));

        Senbun s_return = new Senbun(s1.getb(), s2.getb());
//Senbun s_return =new Senbun(t1, t2);
        return s_return;
    }
}