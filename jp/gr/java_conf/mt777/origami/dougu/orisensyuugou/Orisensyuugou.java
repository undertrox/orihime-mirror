package jp.gr.java_conf.mt777.origami.dougu.orisensyuugou;

import jp.gr.java_conf.mt777.kiroku.memo.Memo;
import jp.gr.java_conf.mt777.seiretu.narabebako.int_double;
import jp.gr.java_conf.mt777.zukei2d.oritacalc.OritaCalc;
import jp.gr.java_conf.mt777.zukei2d.senbun.Senbun;
import jp.gr.java_conf.mt777.zukei2d.takakukei.Takakukei;

import java.awt.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
public class Orisensyuugou {
    int sousuu;               //ŽÀ?Û‚ÉŽg‚¤?ü•ª‚Ì‘??”
    ArrayList Senb = new ArrayList(); //?Ü?ü‚Æ‚·‚é?ü•ª‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»
    OritaCalc oc = new OritaCalc();          //ŠeŽíŒvŽZ—p‚ÌŠÖ?”‚ðŽg‚¤‚½‚ß‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»

    ArrayList Check1Senb = new ArrayList(); //check?î•ñ‚ðŠi”[‚·‚é?ü•ª‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»
    ArrayList Check2Senb = new ArrayList(); //check?î•ñ‚ðŠi”[‚·‚é?ü•ª‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»
    ArrayList Check3Senb = new ArrayList(); //check?î•ñ‚ðŠi”[‚·‚é?ü•ª‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»
    ArrayList Check4Senb = new ArrayList(); //check?î•ñ‚ðŠi”[‚·‚é?ü•ª‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»
    ArrayList Check4Ten = new ArrayList(); //check‚·‚×‚«“_‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»


    ArrayList Cir = new ArrayList(); //‰~‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»

    public Orisensyuugou() {
        reset();
    } //ƒRƒ“ƒXƒgƒ‰ƒNƒ^

    public void reset() {
        sousuu = 0;
        Senb.clear();
        Senb.add(new Senbun());
        Check1Senb.clear();
        Check2Senb.clear();
        Check3Senb.clear();//Check3Senb.add(new Senbun());
        Check4Senb.clear();//Check4Senb.add(new Senbun());
        Check4Ten.clear();
        Cir.clear();
        Cir.add(new En());
    }

    public void hyouji(String s0) {

        System.out.println(s0 + "  sousuu = " + sousuu);
        for (int i = 1; i <= sousuu; i++) {

            Senbun s;
            s = sen(i);
            s.hyouji(" ");

            //System.out.println("  i=" +i +" ; ("+oc.d2s(getax(i))+" , "+oc.d2s(getay(i))+")---("+oc.d2s(getbx(i)+" , "+oc.d2s(getby(i)+")");


        }

    }


    public void set(Orisensyuugou ss) {
        sousuu = ss.getsousuu();
        for (int i = 0; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);
            s.set(ss.get(i));
        }
    }

    private Senbun sen(int i) {
        if (sousuu + 1 > Senb.size()) {
            while (sousuu + 1 > Senb.size()) {
                Senb.add(new Senbun());
            }
        }//‚±‚Ì•¶‚ª‚È‚¢‚Æ‚¤‚Ü‚­?s‚©‚È‚¢?B‚È‚º‚±‚Ì•¶‚Å‚È‚¢‚Æ‚¢‚¯‚È‚¢‚©‚Æ‚¢‚¤—?—R‚ª?³Šm‚É‚Í‚í‚©‚ç‚È‚¢?B
        return (Senbun) Senb.get(i);
    }

    //
    private void senset(int i, Senbun s) {
        if (sousuu + 1 > Senb.size()) {
            while (sousuu + 1 > Senb.size()) {
                Senb.add(new Senbun());
            }
        }//‚±‚Ì•¶‚ª‚È‚¢‚Æ‚¤‚Ü‚­?s‚©‚È‚¢?B‚È‚º‚±‚Ì•¶‚Å‚È‚¢‚Æ‚¢‚¯‚È‚¢‚©‚Æ‚¢‚¤—?—R‚ª?³Šm‚É‚Í‚í‚©‚ç‚È‚¢?B
        if (i + 1 <= Senb.size()) {
            Senb.set(i, s);
        } //‚È‚º‚©?A‚±‚Ìif‚ª‚È‚¢‚Æ‚¤‚Ü‚­?s‚©‚È‚¢
    }

    //?ü•ª‚Ì‘??”‚ð“¾‚é
    public int getsousuu() {
        return sousuu;
    }

    public void setsousuu(int i) {
        sousuu = i;
    }

    //?ü•ª‚ð“¾‚é
    public Senbun get(int i) {
        //Senbun s;s= sen(i);return s;
        return sen(i);
    }

    //i”Ô–Ú‚Ì?ü•ª‚Ì’[“_‚ð“¾‚é
    public Ten geta(int i) {
        Senbun s;
        s = sen(i);
        return s.geta();
    }

    public Ten getb(int i) {
        Senbun s;
        s = sen(i);
        return s.getb();
    }

    //i”Ô–Ú‚Ì?ü•ª‚Ì’[“_‚ð“¾‚é
    public double getax(int i) {
        Senbun s;
        s = sen(i);
        return s.getax();
    }

    public double getbx(int i) {
        Senbun s;
        s = sen(i);
        return s.getbx();
    }

    public double getay(int i) {
        Senbun s;
        s = sen(i);
        return s.getay();
    }

    public double getby(int i) {
        Senbun s;
        s = sen(i);
        return s.getby();
    }

    //i”Ô–Ú‚Ì?ü•ª‚Ì’[“_‚ÌˆÊ’u‚ðƒZƒbƒg‚·‚é
    public void seta(int i, Ten p) {
        Senbun s;
        s = sen(i);
        s.seta(p);
    }

    public void setb(int i, Ten p) {
        Senbun s;
        s = sen(i);
        s.setb(p);
    }


    //i”Ô–Ú‚Ì?ü•ª‚ðƒZƒbƒg‚·‚é
    //public void set(int i,Senbun s0){Senbun s;s= sen(i);s.set(s0);}

    //i”Ô–Ú‚Ì?ü•ª‚Ì’l‚ð“ü—Í‚·‚é
    public void set(int i, Ten p, Ten q) {
        Senbun s;
        s = sen(i);
        s.seta(p);
        s.setb(q);
    }

    //i”Ô–Ú‚Ì?ü•ª‚Ì’l‚ð“ü—Í‚·‚é
    public void set(int i, Ten p, Ten q, int ic, int ia) {
        Senbun s;
        s = sen(i);
        s.set(p, q, ic, ia);
    }

    //i”Ô–Ú‚Ì?ü•ª‚Ì?F‚ð“ü—Í‚·‚é
    public void setcolor(int i, int icol) {
        Senbun s;
        s = sen(i);
        s.setcolor(icol);
    }

    //i”Ô–Ú‚Ì?ü•ª‚Ì?F‚ð?o—Í‚·‚é
    public int getcolor(int i) {
        Senbun s;
        s = sen(i);
        return s.getcolor();
    }

    //
    public void set_tpp_sen(int i, int itpp) {
        Senbun s;
        s = sen(i);
        s.set_tpp(itpp);
    }

    public int get_tpp_sen(int i) {
        Senbun s;
        s = sen(i);
        return s.get_tpp();
    }

    public void set_tpp_sen_color(int i, Color c0) {
        Senbun s;
        s = sen(i);
        s.set_tpp_color(c0);
    }

    //public void set_tpp_sen_color(int iR,int iG,int iB){tpp_color=new Color(iR,iG,iB);}
    public Color get_tpp_sen_color(int i) {
        Senbun s;
        s = sen(i);
        return s.get_tpp_color();
    }

    //public Color get_tpp_sen_color(){return new Color(tpp_color.getRed(),tpp_color.getGreen(),tpp_color.getBlue());}
//
//pppppppppp
    public void set_tpp_en(int i, int itpp) {
        En e;
        e = cir_getEn(i);
        e.set_tpp(itpp);
    }

    public int get_tpp_en(int i) {
        En e;
        e = cir_getEn(i);
        return e.get_tpp();
    }

    public void set_tpp_en_color(int i, Color c0) {
        En e;
        e = cir_getEn(i);
        e.set_tpp_color(c0);
    }

    //public void set_tpp_en_color(int iR,int iG,int iB){tpp_color=new Color(iR,iG,iB);}
    public Color get_tpp_en_color(int i) {
        En e;
        e = cir_getEn(i);
        return e.get_tpp_color();
    }
    //public Color get_tpp_en_color(){return new Color(tpp_color.getRed(),tpp_color.getGreen(),tpp_color.getBlue());}


//

    //i”Ô–Ú‚Ì?ü•ª‚ÌŠˆ?«‚ð“ü—Í‚·‚é
    public void setiactive(int i, int iactive) {
        Senbun s;
        s = sen(i);
        s.setiactive(iactive);
    }


    //i”Ô–Ú‚Ì?ü•ª‚ÌŠˆ?«‚ð?o—Í‚·‚é
    public int getiactive(int i) {
        Senbun s;
        s = sen(i);
        return s.getiactive();
    }

    //-----------------------------
    //?ü•ª?W?‡‚Ì‘S?ü•ª‚Ì?î•ñ‚ð Memo‚Æ‚µ‚Ä?o—Í‚·‚é?B
    public Memo getMemo() {
        return getMemo("_");
    }

    //-----------------------------
    //?ü•ª?W?‡‚Ì‘S?ü•ª‚Ì?î•ñ‚ð Memo‚Æ‚µ‚Ä?o—Í‚·‚é?B //undo,redo‚Ì‹L˜^—p‚ÉŽg‚¤
    public Memo getMemo(String s_title) {
        String str = "";//•¶Žš—ñ?ˆ—?—p‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»

        Memo memo1 = new Memo();
        memo1.reset();


        memo1.addGyou("<ƒ^ƒCƒgƒ‹>");
        memo1.addGyou("ƒ^ƒCƒgƒ‹," + s_title);


        memo1.addGyou("<?ü•ª?W?‡>");

        for (int i = 1; i <= sousuu; i++) {
            memo1.addGyou("”Ô?†," + i);
            Senbun s;
            s = sen(i);
            memo1.addGyou("?F," + str.valueOf(s.getcolor()));

            memo1.addGyou("<tpp>" + str.valueOf(s.get_tpp()) + "</tpp>");                    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            memo1.addGyou("<tpp_color_R>" + str.valueOf(s.get_tpp_color().getRed()) + "</tpp_color_R>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            memo1.addGyou("<tpp_color_G>" + str.valueOf(s.get_tpp_color().getGreen()) + "</tpp_color_G>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            memo1.addGyou("<tpp_color_B>" + str.valueOf(s.get_tpp_color().getBlue()) + "</tpp_color_B>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

            memo1.addGyou("?À•W," + str.valueOf(s.getax()) + "," + str.valueOf(s.getay()) + "," + str.valueOf(s.getbx()) + "," + str.valueOf(s.getby()));
        }

        memo1.addGyou("<‰~?W?‡>");
        for (int i = 1; i <= cir_size(); i++) {
            memo1.addGyou("”Ô?†," + i);
            En e_temp = new En();
            e_temp.set(cir_getEn(i));
            memo1.addGyou("’†?S‚Æ”¼Œa‚Æ?F," + str.valueOf(e_temp.getx()) + "," + str.valueOf(e_temp.gety()) + "," + str.valueOf(e_temp.getr()) + "," + str.valueOf(e_temp.getcolor()));

            memo1.addGyou("<tpp>" + str.valueOf(e_temp.get_tpp()) + "</tpp>");                    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            memo1.addGyou("<tpp_color_R>" + str.valueOf(e_temp.get_tpp_color().getRed()) + "</tpp_color_R>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            memo1.addGyou("<tpp_color_G>" + str.valueOf(e_temp.get_tpp_color().getGreen()) + "</tpp_color_G>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            memo1.addGyou("<tpp_color_B>" + str.valueOf(e_temp.get_tpp_color().getBlue()) + "</tpp_color_B>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


        }


        return memo1;
    }


//-----------------------------


    //?ü•ª?W?‡‚Ì‘S?ü•ª‚Ì?î•ñ‚ð Memo‚Æ‚µ‚Ä?o—Í‚·‚é?B//iactive‚ªijyogai‚Ì?Ü?ü‚Íƒ?ƒ‚‚É?‘‚«?o‚³‚È‚¢
    public Memo getMemo_iactive_jyogai(int ijyogai) {
        String str = "";//•¶Žš—ñ?ˆ—?—p‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»

        Memo memo1 = new Memo();
        memo1.reset();
        memo1.addGyou("<?ü•ª?W?‡>");

        int ibangou = 0;
        for (int i = 1; i <= sousuu; i++) {
            if (getiactive(i) != ijyogai) {
                ibangou = ibangou + 1;
                memo1.addGyou("”Ô?†," + ibangou);
                Senbun s;
                s = sen(i);
                memo1.addGyou("?F," + str.valueOf(s.getcolor()));

                memo1.addGyou("<tpp>" + str.valueOf(s.get_tpp()) + "</tpp>");                    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                memo1.addGyou("<tpp_color_R>" + str.valueOf(s.get_tpp_color().getRed()) + "</tpp_color_R>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                memo1.addGyou("<tpp_color_G>" + str.valueOf(s.get_tpp_color().getGreen()) + "</tpp_color_G>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                memo1.addGyou("<tpp_color_B>" + str.valueOf(s.get_tpp_color().getBlue()) + "</tpp_color_B>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


                memo1.addGyou("‘I‘ð," + str.valueOf(s.get_i_select()));
                memo1.addGyou("?À•W," + str.valueOf(s.getax()) + "," + str.valueOf(s.getay()) + "," + str.valueOf(s.getbx()) + "," + str.valueOf(s.getby()));
            }
        }

        memo1.addGyou("<‰~?W?‡>");
        for (int i = 1; i <= cir_size(); i++) {
            memo1.addGyou("”Ô?†," + i);
            En e_temp = new En();
            e_temp.set(cir_getEn(i));
            //memo1.addGyou( "?F,"+str.valueOf(e_temp.getcolor()));
            memo1.addGyou("’†?S‚Æ”¼Œa‚Æ?F," + str.valueOf(e_temp.getx()) + "," + str.valueOf(e_temp.gety()) + "," + str.valueOf(e_temp.getr()) + "," + str.valueOf(e_temp.getcolor()));

            memo1.addGyou("<tpp>" + str.valueOf(e_temp.get_tpp()) + "</tpp>");                    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            memo1.addGyou("<tpp_color_R>" + str.valueOf(e_temp.get_tpp_color().getRed()) + "</tpp_color_R>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            memo1.addGyou("<tpp_color_G>" + str.valueOf(e_temp.get_tpp_color().getGreen()) + "</tpp_color_G>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            memo1.addGyou("<tpp_color_B>" + str.valueOf(e_temp.get_tpp_color().getBlue()) + "</tpp_color_B>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


        }


        return memo1;
    }


    //-----------------------------
    //•â?•‰æ?ü•ª?W?‡‚Ì‘S?ü•ª‚Ì?î•ñ‚ð Memo‚Æ‚µ‚Ä?o—Í‚·‚é?B
    public Memo h_getMemo() {
        String str = "";//•¶Žš—ñ?ˆ—?—p‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»

        Memo memo1 = new Memo();
        memo1.reset();
        memo1.addGyou("<•â?•?ü•ª?W?‡>");

        for (int i = 1; i <= sousuu; i++) {
            memo1.addGyou("•â?•”Ô?†," + i);
            Senbun s;
            s = sen(i);
            memo1.addGyou("•â?•?F," + str.valueOf(s.getcolor()));

            memo1.addGyou("<tpp>" + str.valueOf(s.get_tpp()) + "</tpp>");                    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            memo1.addGyou("<tpp_color_R>" + str.valueOf(s.get_tpp_color().getRed()) + "</tpp_color_R>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            memo1.addGyou("<tpp_color_G>" + str.valueOf(s.get_tpp_color().getGreen()) + "</tpp_color_G>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            memo1.addGyou("<tpp_color_B>" + str.valueOf(s.get_tpp_color().getBlue()) + "</tpp_color_B>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

            memo1.addGyou("•â?•?À•W," + str.valueOf(s.getax()) + "," + str.valueOf(s.getay()) + "," + str.valueOf(s.getbx()) + "," + str.valueOf(s.getby()));
        }
        return memo1;
    }

    //-----------------------------
    //?Ü?ô‚Ý?„’è—p‚É?ü•ª?W?‡‚Ì?î•ñ‚ð Memo‚Æ‚µ‚Ä?o—Í‚·‚é?B//icol‚ª3(cyan???…?F)ˆÈ?ã‚Ì•â?•?ü‚Íƒ?ƒ‚‚É?‘‚«?o‚³‚È‚¢
    public Memo getMemo_for_oritatami() {
        String str = "";//•¶Žš—ñ?ˆ—?—p‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»

        Memo memo1 = new Memo();
        memo1.reset();
        memo1.addGyou("<?ü•ª?W?‡>");

        int ibangou = 0;
        for (int i = 1; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);
            if (s.getcolor() < 3) {
                ibangou = ibangou + 1;
                memo1.addGyou("”Ô?†," + ibangou);

                memo1.addGyou("?F," + str.valueOf(s.getcolor()));

                memo1.addGyou("<tpp>" + str.valueOf(s.get_tpp()) + "</tpp>");                    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                memo1.addGyou("<tpp_color_R>" + str.valueOf(s.get_tpp_color().getRed()) + "</tpp_color_R>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                memo1.addGyou("<tpp_color_G>" + str.valueOf(s.get_tpp_color().getGreen()) + "</tpp_color_G>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                memo1.addGyou("<tpp_color_B>" + str.valueOf(s.get_tpp_color().getBlue()) + "</tpp_color_B>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


                memo1.addGyou("?À•W," + str.valueOf(s.getax()) + "," + str.valueOf(s.getay()) + "," + str.valueOf(s.getbx()) + "," + str.valueOf(s.getby()));
            }
        }
        return memo1;
    }

    //-----------------------------
    //?Ü?ô‚Ý?„’è—p‚Éselect‚³‚ê‚½?ü•ª?W?‡‚Ì?î•ñ‚ð Memo‚Æ‚µ‚Ä?o—Í‚·‚é?B//icol‚ª3(cyan???…?F)ˆÈ?ã‚Ì•â?•?ü‚Íƒ?ƒ‚‚É?‘‚«?o‚³‚È‚¢
    public Memo getMemo_for_select_oritatami() {
        String str = "";//•¶Žš—ñ?ˆ—?—p‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»
//ggggggggggggggg
        Memo memo1 = new Memo();
        memo1.reset();
        memo1.addGyou("<?ü•ª?W?‡>");

        int ibangou = 0;
        for (int i = 1; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);
            if ((s.getcolor() < 3) && (s.get_i_select() == 2)) {
                ibangou = ibangou + 1;
                memo1.addGyou("”Ô?†," + ibangou);

                memo1.addGyou("?F," + str.valueOf(s.getcolor()));

                memo1.addGyou("<tpp>" + str.valueOf(s.get_tpp()) + "</tpp>");                    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                memo1.addGyou("<tpp_color_R>" + str.valueOf(s.get_tpp_color().getRed()) + "</tpp_color_R>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                memo1.addGyou("<tpp_color_G>" + str.valueOf(s.get_tpp_color().getGreen()) + "</tpp_color_G>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                memo1.addGyou("<tpp_color_B>" + str.valueOf(s.get_tpp_color().getBlue()) + "</tpp_color_B>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


                memo1.addGyou("?À•W," + str.valueOf(s.getax()) + "," + str.valueOf(s.getay()) + "," + str.valueOf(s.getbx()) + "," + str.valueOf(s.getby()));
            }
        }
        return memo1;
    }

//-----------------------------

    //?Ü?ô‚Ý?„’è—p‚Éselect‚³‚ê‚½?ü•ª?W?‡‚Ì?Ü?ü?”‚ð int‚Æ‚µ‚Ä?o—Í‚·‚é?B//icol‚ª3(cyan???…?F)ˆÈ?ã‚Ì•â?•?ü‚ÍƒJƒEƒ“ƒg‚µ‚È‚¢
    public int get_orisensuu_for_select_oritatami() {
        String str = "";//•¶Žš—ñ?ˆ—?—p‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»
//ggggggggggggggg
        //Memo memo1 = new Memo();
        //memo1.reset();
        //memo1.addGyou("<?ü•ª?W?‡>");

        int ibangou = 0;
        for (int i = 1; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);
            if ((s.getcolor() < 3) && (s.get_i_select() == 2)) {
                ibangou = ibangou + 1;
                //memo1.addGyou("”Ô?†,"+str.valueOf(ibangou));

                //memo1.addGyou( "?F,"+str.valueOf(s.getcolor()));

                //memo1.addGyou( "<tpp>"+str.valueOf(s.get_tpp())+"</tpp>");					//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                //memo1.addGyou("<tpp_color_R>"+str.valueOf(s.get_tpp_color().getRed()	)+"</tpp_color_R>");	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                //memo1.addGyou("<tpp_color_G>"+str.valueOf(s.get_tpp_color().getGreen()	)+"</tpp_color_G>");	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                //memo1.addGyou("<tpp_color_B>"+str.valueOf(s.get_tpp_color().getBlue()	)+"</tpp_color_B>");	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


                //memo1.addGyou( "?À•W,"  +	str.valueOf(s.getax())+","+ str.valueOf(s.getay())+","+ str.valueOf(s.getbx())+","+ str.valueOf(s.getby()));
            }
        }
        return ibangou;
    }

//-----------------------------


    //“Á’?ƒvƒ?ƒpƒeƒB‚Ì“Ç‚Ý?ž‚Ý‚ÉŽg‚¤•Ï?”‚Ì?Ý’è
    String[] st_new;
    String[] s_new;
    int i_tpp = 0;
    int i_tpp_color_R = 0;
    int i_tpp_color_G = 0;
    int i_tpp_color_B = 0;

//-----------------------------


    public String setMemo(Memo memo1) {//–ß‚è’l‚Íundo,redo‚Ì‹L˜^—p‚ÉŽg‚¤ƒ^ƒCƒgƒ‹

        int yomiflg = 0;//0‚È‚ç“Ç‚Ý?ž‚Ý‚ð?s‚í‚È‚¢?B1‚È‚ç“Ç‚Ý?ž‚Þ?B
        int ibangou = 0;
        int ic = 0;
        int is = 0;


        String r_title = "";
        r_title = "_";
        String st = "";
        Double Dd = new Double(0.0);
        Integer Ii = new Integer(0);

        double ax, ay, bx, by;
        double dx, dy, dr;

        String str = "";
        //int jtok;


        reset();

        //ƒIƒŠƒqƒ?—pƒtƒ@ƒCƒ‹.orh‚ð“Ç‚Þ

        //?Å?‰‚É?ü•ª‚Ì‘??”‚ð‹?‚ß‚é
        int isen = 0;
        for (int i = 1; i <= memo1.getGyousuu(); i++) {

            StringTokenizer tk = new StringTokenizer(memo1.getGyou(i), ",");
            //jtok=    tk.countTokens();

            str = tk.nextToken();
            if (str.equals("<?ü•ª?W?‡>")) {
                yomiflg = 1;
            }
            if (str.equals("<‰~?W?‡>")) {
                yomiflg = 3;
            }
            if ((yomiflg == 1) && (str.equals("”Ô?†"))) {
                isen = isen + 1;
            }
        }
        sousuu = isen;
        //?Å?‰‚É?ü•ª‚Ì‘??”‚ª‹?‚ß‚ç‚ê‚½
        //


        En e_temp = new En();

        for (int i = 1; i <= memo1.getGyousuu(); i++) {
            String str_i = new String(memo1.getGyou(i));

            //‹ŒŽ®‚Ì“Ç‚Ý?ž‚Ý•û–@
            StringTokenizer tk = new StringTokenizer(str_i, ",");
            str = tk.nextToken();

            //?VŽ®‚Ì“Ç‚Ý?ž‚Ý•û–@
            str_i.trim();


            if (str.equals("<ƒ^ƒCƒgƒ‹>")) {
                yomiflg = 2;
            }
            if ((yomiflg == 2) && (str.equals("ƒ^ƒCƒgƒ‹"))) {
                str = tk.nextToken();
                r_title = str;
            }


            if (str.equals("<?ü•ª?W?‡>")) {
                yomiflg = 1;
            }
            if ((yomiflg == 1) && (str.equals("”Ô?†"))) {
                str = tk.nextToken();
                ibangou = Integer.parseInt(str);
            }
            if ((yomiflg == 1) && (str.equals("?F"))) {
                str = tk.nextToken();
                ic = Integer.parseInt(str);
                Senbun s;
                s = sen(ibangou);
                s.setcolor(ic);
            }

            if (yomiflg == 1) {
                st_new = str_i.split(">", 2);// <-----------------------------------‚Q‚Â‚É•ªŠ„‚·‚é‚Æ‚«‚Í2‚ðŽw’è
                if (st_new[0].equals("<tpp")) {
                    s_new = st_new[1].split("<", 2);
                    i_tpp = (Integer.parseInt(s_new[0]));
                    Senbun s;
                    s = sen(ibangou);
                    s.set_tpp(i_tpp);
                }
                //  System.out.println(Integer.parseInt(s[0])) ;

                if (st_new[0].equals("<tpp_color_R")) {
                    s_new = st_new[1].split("<", 2);
                    i_tpp_color_R = (Integer.parseInt(s_new[0]));
                    Senbun s;
                    s = sen(ibangou);
                    s.set_tpp_color(new Color(i_tpp_color_R, i_tpp_color_G, i_tpp_color_B));
                }        //  System.out.println(Integer.parseInt(s[0])) ;

                if (st_new[0].equals("<tpp_color_G")) {
                    s_new = st_new[1].split("<", 2);
                    i_tpp_color_G = (Integer.parseInt(s_new[0]));
                    Senbun s;
                    s = sen(ibangou);
                    s.set_tpp_color(new Color(i_tpp_color_R, i_tpp_color_G, i_tpp_color_B));
                }
                if (st_new[0].equals("<tpp_color_B")) {
                    s_new = st_new[1].split("<", 2);
                    i_tpp_color_B = (Integer.parseInt(s_new[0]));
                    Senbun s;
                    s = sen(ibangou);
                    s.set_tpp_color(new Color(i_tpp_color_R, i_tpp_color_G, i_tpp_color_B));
                }

            }


            if ((yomiflg == 1) && (str.equals("iactive"))) {//20181110’Ç‰Á
                str = tk.nextToken();
                is = Integer.parseInt(str);
                Senbun s;
                s = sen(ibangou);
                s.setiactive(is);
            }


            if ((yomiflg == 1) && (str.equals("‘I‘ð"))) {
                str = tk.nextToken();
                is = Integer.parseInt(str);
                Senbun s;
                s = sen(ibangou);
                s.set_i_select(is);
            }
            if ((yomiflg == 1) && (str.equals("?À•W"))) {
                str = tk.nextToken();
                ax = Double.parseDouble(str);
                str = tk.nextToken();
                ay = Double.parseDouble(str);
                str = tk.nextToken();
                bx = Double.parseDouble(str);
                str = tk.nextToken();
                by = Double.parseDouble(str);

                Senbun s;
                s = sen(ibangou);
                s.set(ax, ay, bx, by);
                //	System.out.println(ax );
            }


//pppppppppppppp


            if (str.equals("<‰~?W?‡>")) {
                yomiflg = 3;
            }

            if ((yomiflg == 3) && (str.equals("”Ô?†"))) {
                str = tk.nextToken();
                ibangou = Integer.parseInt(str);

                cir_setEn(ibangou, e_temp);
            }

            if ((yomiflg == 3) && (str.equals("’†?S‚Æ”¼Œa‚Æ?F"))) {

                str = tk.nextToken();
                dx = Double.parseDouble(str);
                str = tk.nextToken();
                dy = Double.parseDouble(str);
                str = tk.nextToken();
                dr = Double.parseDouble(str);

                str = tk.nextToken();
                ic = Integer.parseInt(str);


                cir_getEn(ibangou).set(dx, dy, dr, ic);
                //e_temp.set(dx,dy,dr,ic);

                //cir_setEn(ibangou,e_temp);
                //System.out.println("cir_setEn(ibangou,e_temp)  "+ ibangou+";" +dx+"," +dy+"," +dr+"," +ic);


                //En e;  e=cir_getEn(i);e.set_tpp_color(c0);

            }


            if (yomiflg == 3) {
                st_new = str_i.split(">", 2);// <-----------------------------------‚Q‚Â‚É•ªŠ„‚·‚é‚Æ‚«‚Í2‚ðŽw’è
                if (st_new[0].equals("<tpp")) {
                    s_new = st_new[1].split("<", 2);
                    i_tpp = (Integer.parseInt(s_new[0]));
                    cir_getEn(ibangou).set_tpp(i_tpp);
                }
                //  System.out.println(Integer.parseInt(s[0])) ;

                if (st_new[0].equals("<tpp_color_R")) {
                    s_new = st_new[1].split("<", 2);
                    i_tpp_color_R = (Integer.parseInt(s_new[0]));
                    cir_getEn(ibangou).set_tpp_color(new Color(i_tpp_color_R, i_tpp_color_G, i_tpp_color_B));
                }        //  System.out.println(Integer.parseInt(s[0])) ;

                if (st_new[0].equals("<tpp_color_G")) {
                    s_new = st_new[1].split("<", 2);
                    i_tpp_color_G = (Integer.parseInt(s_new[0]));
                    cir_getEn(ibangou).set_tpp_color(new Color(i_tpp_color_R, i_tpp_color_G, i_tpp_color_B));
                }
                if (st_new[0].equals("<tpp_color_B")) {
                    s_new = st_new[1].split("<", 2);
                    i_tpp_color_B = (Integer.parseInt(s_new[0]));
                    cir_getEn(ibangou).set_tpp_color(new Color(i_tpp_color_R, i_tpp_color_G, i_tpp_color_B));
                }

            }


        }
        return r_title;
    }


//-----------------------------

    public void h_setMemo(Memo memo1) {
        int yomiflg = 0;//0‚È‚ç“Ç‚Ý?ž‚Ý‚ð?s‚í‚È‚¢?B1‚È‚ç“Ç‚Ý?ž‚Þ?B
        int ibangou = 0;
        int ic = 0;
        int is = 0;

        String st = "";
        Double Dd = new Double(0.0);
        Integer Ii = new Integer(0);

        double ax, ay, bx, by;
        String str = "";
        //int jtok;

        //ƒIƒŠƒqƒ?—pƒtƒ@ƒCƒ‹.orh‚ð“Ç‚Þ

        //?Å?‰‚É?ü•ª‚Ì‘??”‚ð‹?‚ß‚é
        int isen = 0;
        for (int i = 1; i <= memo1.getGyousuu(); i++) {

            StringTokenizer tk = new StringTokenizer(memo1.getGyou(i), ",");
            //jtok=    tk.countTokens();

            str = tk.nextToken();
            if (str.equals("<•â?•?ü•ª?W?‡>")) {
                yomiflg = 1;
            }
            if ((yomiflg == 1) && (str.equals("•â?•”Ô?†"))) {
                isen = isen + 1;
            }
        }
        sousuu = isen;
        //?Å?‰‚É•â?•?ü•ª‚Ì‘??”‚ª‹?‚ß‚ç‚ê‚½
        //

        for (int i = 1; i <= memo1.getGyousuu(); i++) {


            StringTokenizer tk = new StringTokenizer(memo1.getGyou(i), ",");
            //jtok=    tk.countTokens();
            str = tk.nextToken();
            //  	System.out.println("::::::::::"+ str+"<<<<<" );
            if (str.equals("<•â?•?ü•ª?W?‡>")) {
                yomiflg = 1;
            }
            if ((yomiflg == 1) && (str.equals("•â?•”Ô?†"))) {
                str = tk.nextToken();
                ibangou = Integer.parseInt(str);
            }
            if ((yomiflg == 1) && (str.equals("•â?•?F"))) {
                str = tk.nextToken();
                ic = Integer.parseInt(str);
                Senbun s;
                s = sen(ibangou);
                s.setcolor(ic);
            }
            if ((yomiflg == 1) && (str.equals("•â?•‘I‘ð"))) {
                str = tk.nextToken();
                is = Integer.parseInt(str);
                Senbun s;
                s = sen(ibangou);
                s.set_i_select(is);
            }
            if ((yomiflg == 1) && (str.equals("•â?•?À•W"))) {
                str = tk.nextToken();
                ax = Double.parseDouble(str);
                str = tk.nextToken();
                ay = Double.parseDouble(str);
                str = tk.nextToken();
                bx = Double.parseDouble(str);
                str = tk.nextToken();
                by = Double.parseDouble(str);

                Senbun s;
                s = sen(ibangou);
                s.set(ax, ay, bx, by);
                //	System.out.println(ax );
            }
        }
    }


    //-----------------------------
    public void addMemo(Memo memo1) {
        int yomiflg = 0;//0‚È‚ç“Ç‚Ý?ž‚Ý‚ð?s‚í‚È‚¢?B1‚È‚ç“Ç‚Ý?ž‚Þ?B
        int ibangou = 0;
        int ic = 0;

        String st = "";
        Double Dd = new Double(0.0);
        Integer Ii = new Integer(0);

        double ax, ay, bx, by;
        double dx, dy, dr;

        String str = "";
        //int jtok;

        int sousuu_old = sousuu;

        //ƒIƒŠƒqƒ?—pƒtƒ@ƒCƒ‹.orh‚ð“Ç‚Þ

        //?Å?‰‚É?ü•ª‚Ì‘??”‚ð‹?‚ß‚é
        int isen = 0;
        for (int i = 1; i <= memo1.getGyousuu(); i++) {

            StringTokenizer tk = new StringTokenizer(memo1.getGyou(i), ",");
            //jtok=    tk.countTokens();

            str = tk.nextToken();
            if (str.equals("<?ü•ª?W?‡>")) {
                yomiflg = 1;
            }
            if ((yomiflg == 1) && (str.equals("”Ô?†"))) {
                isen = isen + 1;
            }
        }
        sousuu = sousuu_old + isen;


        //?Å?‰‚É?ü•ª‚Ì‘??”‚ª‹?‚ß‚ç‚ê‚½
        //

        for (int i = 1; i <= memo1.getGyousuu(); i++) {

            String str_i = new String(memo1.getGyou(i));

            //‹ŒŽ®‚Ì“Ç‚Ý?ž‚Ý•û–@
            StringTokenizer tk = new StringTokenizer(str_i, ",");
            str = tk.nextToken();

            //?VŽ®‚Ì“Ç‚Ý?ž‚Ý•û–@
            str_i.trim();


            //StringTokenizer tk = new StringTokenizer(memo1.getGyou(i),",");
            //jtok=    tk.countTokens();
            //str=tk.nextToken();
            //  	System.out.println("::::::::::"+ str+"<<<<<" );
            if (str.equals("<?ü•ª?W?‡>")) {
                yomiflg = 1;
            }
            if ((yomiflg == 1) && (str.equals("”Ô?†"))) {
                str = tk.nextToken();
                ibangou = sousuu_old + Integer.parseInt(str);
            }
            if ((yomiflg == 1) && (str.equals("?F"))) {
                str = tk.nextToken();
                ic = Integer.parseInt(str);
                Senbun s;
                s = sen(ibangou);
                s.setcolor(ic);
            }

            if (yomiflg == 1) {
                st_new = str_i.split(">", 2);// <-----------------------------------‚Q‚Â‚É•ªŠ„‚·‚é‚Æ‚«‚Í2‚ðŽw’è
                if (st_new[0].equals("<tpp")) {
                    s_new = st_new[1].split("<", 2);
                    i_tpp = (Integer.parseInt(s_new[0]));
                    Senbun s;
                    s = sen(ibangou);
                    s.set_tpp(i_tpp);
                }
                //  System.out.println(Integer.parseInt(s[0])) ;

                if (st_new[0].equals("<tpp_color_R")) {
                    s_new = st_new[1].split("<", 2);
                    i_tpp_color_R = (Integer.parseInt(s_new[0]));
                    Senbun s;
                    s = sen(ibangou);
                    s.set_tpp_color(new Color(i_tpp_color_R, i_tpp_color_G, i_tpp_color_B));
                }        //  System.out.println(Integer.parseInt(s[0])) ;

                if (st_new[0].equals("<tpp_color_G")) {
                    s_new = st_new[1].split("<", 2);
                    i_tpp_color_G = (Integer.parseInt(s_new[0]));
                    Senbun s;
                    s = sen(ibangou);
                    s.set_tpp_color(new Color(i_tpp_color_R, i_tpp_color_G, i_tpp_color_B));
                }
                if (st_new[0].equals("<tpp_color_B")) {
                    s_new = st_new[1].split("<", 2);
                    i_tpp_color_B = (Integer.parseInt(s_new[0]));
                    Senbun s;
                    s = sen(ibangou);
                    s.set_tpp_color(new Color(i_tpp_color_R, i_tpp_color_G, i_tpp_color_B));
                }

            }


            if ((yomiflg == 1) && (str.equals("?À•W"))) {
                str = tk.nextToken();
                ax = Double.parseDouble(str);
                str = tk.nextToken();
                ay = Double.parseDouble(str);
                str = tk.nextToken();
                bx = Double.parseDouble(str);
                str = tk.nextToken();
                by = Double.parseDouble(str);

                Senbun s;
                s = sen(ibangou);
                s.set(ax, ay, bx, by);
                //	System.out.println(ax );
            }


            //----------------------------------------------wwwwwwwwwww


            if (str.equals("<‰~?W?‡>")) {
                yomiflg = 3;
            }

            if ((yomiflg == 3) && (str.equals("”Ô?†"))) {
                str = tk.nextToken();//ibangou=Ii.parseInt(str);
                Cir.add(new En(0.0, 0.0, 1.0, 1));
                ibangou = cir_size();
            }

            if ((yomiflg == 3) && (str.equals("’†?S‚Æ”¼Œa‚Æ?F"))) {

                str = tk.nextToken();
                dx = Double.parseDouble(str);
                str = tk.nextToken();
                dy = Double.parseDouble(str);
                str = tk.nextToken();
                dr = Double.parseDouble(str);

                str = tk.nextToken();
                ic = Integer.parseInt(str);

                //En e_temp=new En(dx,dy,dr,ic);

                //Cir.add(e_temp);
                //System.out.println("cir_setEn(ibangou,e_temp)  "+ ibangou+";" +dx+"," +dy+"," +dr+"," +ic);


                cir_getEn(ibangou).set(dx, dy, dr, ic);


            }


            if (yomiflg == 3) {
                st_new = str_i.split(">", 2);// <-----------------------------------‚Q‚Â‚É•ªŠ„‚·‚é‚Æ‚«‚Í2‚ðŽw’è
                if (st_new[0].equals("<tpp")) {
                    s_new = st_new[1].split("<", 2);
                    i_tpp = (Integer.parseInt(s_new[0]));
                    cir_getEn(ibangou).set_tpp(i_tpp);
                }
                //  System.out.println(Integer.parseInt(s[0])) ;

                if (st_new[0].equals("<tpp_color_R")) {
                    s_new = st_new[1].split("<", 2);
                    i_tpp_color_R = (Integer.parseInt(s_new[0]));
                    cir_getEn(ibangou).set_tpp_color(new Color(i_tpp_color_R, i_tpp_color_G, i_tpp_color_B));
                }        //  System.out.println(Integer.parseInt(s[0])) ;

                if (st_new[0].equals("<tpp_color_G")) {
                    s_new = st_new[1].split("<", 2);
                    i_tpp_color_G = (Integer.parseInt(s_new[0]));
                    cir_getEn(ibangou).set_tpp_color(new Color(i_tpp_color_R, i_tpp_color_G, i_tpp_color_B));
                }
                if (st_new[0].equals("<tpp_color_B")) {
                    s_new = st_new[1].split("<", 2);
                    i_tpp_color_B = (Integer.parseInt(s_new[0]));
                    cir_getEn(ibangou).set_tpp_color(new Color(i_tpp_color_R, i_tpp_color_G, i_tpp_color_B));
                }

            }


        }
    }

//-----------------------------
    //“WŠJ?}“ü—ÍŽž‚Ì?ü•ª?W?‡‚Ì?®—?

    public void bunkatu_seiri() {//?Ü‚è?ô‚Ý?„’è‚È‚Ç‚Å“¾‚ç‚ê‚é?j‹à?}‚Ì?®—?
        System.out.println("•ªŠ„?®—??@‚P?A“_?í?œ");
        ten_sakujyo();          //”O‚Ì‚½‚ß?A“_?ó‚Ì?ü•ª‚ð?œ‚­
        System.out.println("•ªŠ„?®—??@‚Q?A?d•¡?ü•ª?í?œ");
        jyuufuku_senbun_sakujyo();//”O‚Ì‚½‚ß?A‘S‚­ˆê’v‚·‚é?ü•ª‚ª‚Q‚Â‚ ‚ê‚Î‚P‚Â‚ð?œ‚­
        System.out.println("•ªŠ„?®—??@‚R?AŒð?·•ªŠ„");
        kousabunkatu();
        System.out.println("•ªŠ„?®—??@‚S?A“_?í?œ");
        ten_sakujyo();             //?Ü‚è?ô‚Ý?„’è‚Ì?j‹à?}‚Ì?®—?‚Ì‚½‚ß?A“_?ó‚Ì?ü•ª‚ð?œ‚­
        System.out.println("•ªŠ„?®—??@‚T?A?d•¡?ü•ª?í?œ");
        jyuufuku_senbun_sakujyo(); //?Ü‚è?ô‚Ý?„’è‚Ì?j‹à?}‚Ì?®—?‚Ì‚½‚ß?A‘S‚­ˆê’v‚·‚é?ü•ª‚ª‚Q‚Â‚ ‚ê‚Î‚P‚Â‚ð?œ‚­
    }

    //‘S?ü•ª‚ÌŽR’J‚ð“ü‚ê‘Ö‚¦‚é?B‹«ŠE?ü“™‚ÌŽR’JˆÈŠO‚Ì?üŽí‚Í•Ï‰»‚È‚µ?B
    public void zen_yama_tani_henkan() {
        int ic_temp;

        for (int ic_id = 1; ic_id <= sousuu; ic_id++) {
            ic_temp = getcolor(ic_id);
            if (ic_temp == 1) {
                ic_temp = 2;
            } else if (ic_temp == 2) {
                ic_temp = 1;
            }
            setcolor(ic_id, ic_temp);
        }
    }

    //Smen‚ð”­?¶‚³‚¹‚é‚½‚ß‚Ì?ü•ª?W?‡‚Ì?®—?

    public void bunkatu_seiri_for_Smen_hassei() {//?Ü‚è?ô‚Ý?„’è‚È‚Ç‚Å“¾‚ç‚ê‚é?j‹à?}‚Ì?®—?
        System.out.println("?@?@Orisensyuugou‚Ì’†‚Å?ASmen‚ð”­?¶‚³‚¹‚é‚½‚ß‚Ì?ü•ª?W?‡‚Ì?®—?");
        System.out.println("•ªŠ„?®—??@‚P?A“_?í?œ‘O	getsousuu() = " + getsousuu());
        ten_sakujyo();          //”O‚Ì‚½‚ß?A“_?ó‚Ì?ü•ª‚ð?œ‚­
        System.out.println("•ªŠ„?®—??@‚Q?A?d•¡?ü•ª?í?œ‘O	getsousuu() = " + getsousuu());
        jyuufuku_senbun_sakujyo();//”O‚Ì‚½‚ß?A‘S‚­ˆê’v‚·‚é?ü•ª‚ª‚Q‚Â‚ ‚ê‚Î‚P‚Â‚ð?œ‚­
        System.out.println("•ªŠ„?®—??@‚R?AŒð?·•ªŠ„‘O	getsousuu() = " + getsousuu());
        kousabunkatu();
        System.out.println("•ªŠ„?®—??@‚S?A“_?í?œ‘O	getsousuu() = " + getsousuu());
        ten_sakujyo();             //?Ü‚è?ô‚Ý?„’è‚Ì?j‹à?}‚Ì?®—?‚Ì‚½‚ß?A“_?ó‚Ì?ü•ª‚ð?œ‚­
        System.out.println("•ªŠ„?®—??@‚T?A?d•¡?ü•ª?í?œ‘O	getsousuu() = " + getsousuu());
        jyuufuku_senbun_sakujyo(); //?Ü‚è?ô‚Ý?„’è‚Ì?j‹à?}‚Ì?®—?‚Ì‚½‚ß?A‘S‚­ˆê’v‚·‚é?ü•ª‚ª‚Q‚Â‚ ‚ê‚Î‚P‚Â‚ð?œ‚­
        System.out.println("•ªŠ„?®—??@‚T?A?d•¡?ü•ª?í?œŒã	getsousuu() = " + getsousuu());
    }

//--------------------------------------------------------------------------------------------------

    //?ü•ª?W?‡‚Ì‘S?ü•ª‚Ì?î•ñ‚ð Memo‚Æ‚µ‚Ä?o—Í‚·‚é?B//select‚ªijyogai‚Ì?Ü?ü‚Íƒ?ƒ‚‚É?‘‚«?o‚³‚È‚¢
    public Memo getMemo_select_jyogai(int ijyogai) {
        String str = "";//•¶Žš—ñ?ˆ—?—p‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»

        Memo memo1 = new Memo();
        memo1.reset();
        memo1.addGyou("<?ü•ª?W?‡>");

        int ibangou = 0;
        for (int i = 1; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);


            if (s.get_i_select() != ijyogai) {
                ibangou = ibangou + 1;
                memo1.addGyou("”Ô?†," + ibangou);
                //Senbun s;s= sen(i);
                memo1.addGyou("?F," + str.valueOf(s.getcolor()));

                memo1.addGyou("<tpp>" + str.valueOf(s.get_tpp()) + "</tpp>");                    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                memo1.addGyou("<tpp_color_R>" + str.valueOf(s.get_tpp_color().getRed()) + "</tpp_color_R>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                memo1.addGyou("<tpp_color_G>" + str.valueOf(s.get_tpp_color().getGreen()) + "</tpp_color_G>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                memo1.addGyou("<tpp_color_B>" + str.valueOf(s.get_tpp_color().getBlue()) + "</tpp_color_B>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

                memo1.addGyou("iactive," + str.valueOf(s.getiactive()));//20181110’Ç‰Á
                memo1.addGyou("?À•W," + str.valueOf(s.getax()) + "," + str.valueOf(s.getay()) + "," + str.valueOf(s.getbx()) + "," + str.valueOf(s.getby()));

            }

        }


        memo1.addGyou("<‰~?W?‡>");
        for (int i = 1; i <= cir_size(); i++) {
            memo1.addGyou("”Ô?†," + i);
            En e_temp = new En();
            e_temp.set(cir_getEn(i));
            //memo1.addGyou( "?F,"+str.valueOf(e_temp.getcolor()));
            memo1.addGyou("’†?S‚Æ”¼Œa‚Æ?F," + str.valueOf(e_temp.getx()) + "," + str.valueOf(e_temp.gety()) + "," + str.valueOf(e_temp.getr()) + "," + str.valueOf(e_temp.getcolor()));

            memo1.addGyou("<tpp>" + str.valueOf(e_temp.get_tpp()) + "</tpp>");                    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            memo1.addGyou("<tpp_color_R>" + str.valueOf(e_temp.get_tpp_color().getRed()) + "</tpp_color_R>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            memo1.addGyou("<tpp_color_G>" + str.valueOf(e_temp.get_tpp_color().getGreen()) + "</tpp_color_G>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            memo1.addGyou("<tpp_color_B>" + str.valueOf(e_temp.get_tpp_color().getBlue()) + "</tpp_color_B>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


        }


        return memo1;
    }
//-----------------------------

//--------------------------------------------------------------------------------------------------

    //?ü•ª?W?‡‚Ì‘S?ü•ª‚Ì?î•ñ‚ð Memo‚Æ‚µ‚Ä?o—Í‚·‚é?B//select‚ªisentaku‚Ì?Ü?ü‚ðƒ?ƒ‚‚É?‘‚«?o‚·
    public Memo getMemo_select_sentaku(int isentaku) {
        String str = "";//•¶Žš—ñ?ˆ—?—p‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»

        Memo memo1 = new Memo();
        memo1.reset();
        memo1.addGyou("<?ü•ª?W?‡>");

        int ibangou = 0;
        for (int i = 1; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);


            if (s.get_i_select() == isentaku) {
                ibangou = ibangou + 1;
                memo1.addGyou("”Ô?†," + ibangou);
                //Senbun s;s= sen(i);
                memo1.addGyou("?F," + str.valueOf(s.getcolor()));

                memo1.addGyou("<tpp>" + str.valueOf(s.get_tpp()) + "</tpp>");                    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                memo1.addGyou("<tpp_color_R>" + str.valueOf(s.get_tpp_color().getRed()) + "</tpp_color_R>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                memo1.addGyou("<tpp_color_G>" + str.valueOf(s.get_tpp_color().getGreen()) + "</tpp_color_G>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                memo1.addGyou("<tpp_color_B>" + str.valueOf(s.get_tpp_color().getBlue()) + "</tpp_color_B>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


                memo1.addGyou("?À•W," + str.valueOf(s.getax()) + "," + str.valueOf(s.getay()) + "," + str.valueOf(s.getbx()) + "," + str.valueOf(s.getby()));

            }

        }
        return memo1;
    }

    //-----------------------------
    public void select_all() {
        for (int i = 1; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);
            s.set_i_select(2);
        }
    }


    public void unselect_all() {
        for (int i = 1; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);
            s.set_i_select(0);
        }
    }


    public void select(int i) {
        Senbun s;
        s = sen(i);
        s.set_i_select(2);
    }

    public void select(Ten p1, Ten p2, Ten p3) {
        Takakukei sankaku = new Takakukei(3);
        sankaku.set(1, p1);
        sankaku.set(2, p2);
        sankaku.set(3, p3);


        for (int i = 1; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);
            if (sankaku.totu_kyoukai_naibu(s) == 1) {

                s.set_i_select(2);

            }
        }
    }

    public void select(Ten p1, Ten p2, Ten p3, Ten p4) {
        //Ten p1 = new Ten();   p1.set(si.geta());
        Takakukei sikaku = new Takakukei(4);
        sikaku.set(1, p1);
        sikaku.set(2, p2);
        sikaku.set(3, p3);
        sikaku.set(4, p4);

        for (int i = 1; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);
            if (sikaku.totu_kyoukai_naibu(s) == 1) {

                s.set_i_select(2);

            }
        }
    }


    public void unselect(Ten p1, Ten p2, Ten p3) {
        Takakukei sankaku = new Takakukei(3);
        sankaku.set(1, p1);
        sankaku.set(2, p2);
        sankaku.set(3, p3);


        for (int i = 1; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);
            if (sankaku.totu_kyoukai_naibu(s) == 1) {

                s.set_i_select(0);

            }
        }
    }

    public void unselect(Ten p1, Ten p2, Ten p3, Ten p4) {
        //Ten p1 = new Ten();   p1.set(si.geta());
        Takakukei sikaku = new Takakukei(4);
        sikaku.set(1, p1);
        sikaku.set(2, p2);
        sikaku.set(3, p3);
        sikaku.set(4, p4);

        for (int i = 1; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);
            if (sikaku.totu_kyoukai_naibu(s) == 1) {

                s.set_i_select(0);

            }
        }
    }

    //--------------------------------
    public int MV_change(Ten p1, Ten p2, Ten p3, Ten p4) {
        int i_r = 0;
        //Ten p1 = new Ten();   p1.set(si.geta());
        Takakukei sikaku = new Takakukei(4);
        sikaku.set(1, p1);
        sikaku.set(2, p2);
        sikaku.set(3, p3);
        sikaku.set(4, p4);

        for (int i = 1; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);
            if (sikaku.totu_kyoukai_naibu(s) == 1) {
                int ic_temp;
                ic_temp = getcolor(i);/**/
                if (ic_temp == 1) {
                    setcolor(i, 2);
                } else if (ic_temp == 2) {
                    setcolor(i, 1);
                }
                i_r = 1;
            }
        }
        return i_r;
    }
//--------------------------------


    //--------------------------------
    public int M_nisuru(Ten p1, Ten p2, Ten p3, Ten p4) {
        int i_r = 0;
        //Ten p1 = new Ten();   p1.set(si.geta());
        Takakukei sikaku = new Takakukei(4);
        sikaku.set(1, p1);
        sikaku.set(2, p2);
        sikaku.set(3, p3);
        sikaku.set(4, p4);

        for (int i = 1; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);
            if (sikaku.totu_kyoukai_naibu(s) == 1) {
                s.setcolor(1);
                i_r = 1;
            }
        }
        return i_r;
    }

    //--------------------------------
    public int V_nisuru(Ten p1, Ten p2, Ten p3, Ten p4) {
        int i_r = 0;
        //Ten p1 = new Ten();   p1.set(si.geta());
        Takakukei sikaku = new Takakukei(4);
        sikaku.set(1, p1);
        sikaku.set(2, p2);
        sikaku.set(3, p3);
        sikaku.set(4, p4);

        for (int i = 1; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);
            if (sikaku.totu_kyoukai_naibu(s) == 1) {
                s.setcolor(2);
                i_r = 1;
            }
        }
        return i_r;
    }

    //--------------------------------
    public int E_nisuru(Ten p1, Ten p2, Ten p3, Ten p4) {
        int i_r = 0;
        //Ten p1 = new Ten();   p1.set(si.geta());
        Takakukei sikaku = new Takakukei(4);
        sikaku.set(1, p1);
        sikaku.set(2, p2);
        sikaku.set(3, p3);
        sikaku.set(4, p4);

        for (int i = 1; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);
            if (sikaku.totu_kyoukai_naibu(s) == 1) {
                s.setcolor(0);
                i_r = 1;
            }
        }
        return i_r;

    }

    //--------------------------------
    public int HK_nisuru(Ten p1, Ten p2, Ten p3, Ten p4) {
        int i_r = 0;
        //Ten p1 = new Ten();   p1.set(si.geta());
        Takakukei sikaku = new Takakukei(4);
        sikaku.set(1, p1);
        sikaku.set(2, p2);
        sikaku.set(3, p3);
        sikaku.set(4, p4);


        int okikae_suu = 0;
        for (int i = 1; i <= sousuu; i++) {
            if (getcolor(i) < 3) {
                Senbun s;
                s = sen(i);
                if (sikaku.totu_kyoukai_naibu(s) == 1) {
                    okikae_suu = okikae_suu + 1;

                    Senbun add_sen = new Senbun();
                    add_sen.set(s);
                    add_sen.setcolor(3);

                    delsenbun(i);
                    addsenbun(add_sen);
                    i = i - 1;

                    //s.setcolor(3);
                    i_r = 1;
//kousabunkatu();


                }
            }
        }

        int kawatteinai_kazu = sousuu - okikae_suu;
        if (kawatteinai_kazu == 0) {
            kousabunkatu();
        }
        if (kawatteinai_kazu >= 1) {
            if (okikae_suu >= 1) {
                kousabunkatu(1, sousuu - okikae_suu, sousuu - okikae_suu + 1, sousuu);
            }
        }
//?ã‚Q?s‚Ì?ê?‡‚í‚¯‚ª•K—v‚È—?—R‚Í?Akousabunkatu()‚ð‚â‚Á‚Ä‚µ‚Ü‚¤‚Æ?Ü?ü‚Æ•â?•Šˆ?ü‚Æ‚ÌŒð“_‚Å?Ü?ü‚ª•ªŠ„‚³‚ê‚é‚©‚ç?Bkousabunkatu(1,sousuu-okikae_suu,sousuu-okikae_suu+1,sousuu)‚¾‚Æ?Ü?ü‚Í•ªŠ„‚³‚ê‚È‚¢?B


        return i_r;

    }

    //-----------------------wwwwwwwwwwwwwww---------
    public int D_nisuru(Ten p1, Ten p2, Ten p3, Ten p4) {
        int i_r = 0;
        //Ten p1 = new Ten();   p1.set(si.geta());
        Takakukei sikaku = new Takakukei(4);
        sikaku.set(1, p1);
        sikaku.set(2, p2);
        sikaku.set(3, p3);
        sikaku.set(4, p4);

        String str = "";//•¶Žš—ñ?ˆ—?—p‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»
        Memo memo1 = new Memo();
        memo1.reset();
        memo1.addGyou("<?ü•ª?W?‡>");
        int ibangou = 0;

        for (int i = 1; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);

            if (sikaku.totu_kyoukai_naibu(s) == 1) {
                i_r = 1;
            }
            if (sikaku.totu_kyoukai_naibu(s) != 1) {
                ibangou = ibangou + 1;
                memo1.addGyou("”Ô?†," + ibangou);
                //Senbun s;s= sen(i);
                memo1.addGyou("?F," + str.valueOf(s.getcolor()));
                memo1.addGyou("?À•W," + str.valueOf(s.getax()) + "," + str.valueOf(s.getay()) + "," + str.valueOf(s.getbx()) + "," + str.valueOf(s.getby()));
            }
        }

        Ten ec = new Ten();//‰~‚Ì’†?S?À•W‚ð“ü‚ê‚é•Ï?”
        double er;//‰~‚Ì’†?S?À•W‚ð“ü‚ê‚é•Ï?”

        Senbun s1 = new Senbun(p1, p2);
        Senbun s2 = new Senbun(p2, p3);
        Senbun s3 = new Senbun(p3, p4);
        Senbun s4 = new Senbun(p4, p1);

        memo1.addGyou("<‰~?W?‡>");
        int ii = 0;
        for (int i = 1; i <= cir_size(); i++) {
            int idel = 0;
            En e_temp = new En();
            e_temp.set(cir_getEn(i));
            ec.set(e_temp.get_tyuusin());
            er = e_temp.getr();

            if (oc.kyori_senbun(ec, s1) <= er) {
                if ((oc.kyori(s1.geta(), ec) >= er) || (oc.kyori(s1.geta(), ec) >= er)) {
                    idel = 1;
                }
            }
            if (oc.kyori_senbun(ec, s2) <= er) {
                if ((oc.kyori(s2.geta(), ec) >= er) || (oc.kyori(s2.geta(), ec) >= er)) {
                    idel = 1;
                }
            }
            if (oc.kyori_senbun(ec, s3) <= er) {
                if ((oc.kyori(s3.geta(), ec) >= er) || (oc.kyori(s3.geta(), ec) >= er)) {
                    idel = 1;
                }
            }
            if (oc.kyori_senbun(ec, s4) <= er) {
                if ((oc.kyori(s4.geta(), ec) >= er) || (oc.kyori(s4.geta(), ec) >= er)) {
                    idel = 1;
                }
            }

            if (sikaku.totu_kyoukai_naibu(new Senbun(e_temp.get_tyuusin(), e_temp.get_tyuusin())) == 1) {
                idel = 1;
            }

            if (idel == 1) {
                i_r = 1;
            }
            if (idel == 0) {
                ii = ii + 1;
                memo1.addGyou("”Ô?†," + ii);
                memo1.addGyou("’†?S‚Æ”¼Œa‚Æ?F," + str.valueOf(e_temp.getx()) + "," + str.valueOf(e_temp.gety()) + "," + str.valueOf(e_temp.getr()) + "," + str.valueOf(e_temp.getcolor()));
            }
        }


        reset();
        setMemo(memo1);


        return i_r;
    }


    //--------------------------------
    public int D_nisuru0(Ten p1, Ten p2, Ten p3, Ten p4) {//?Ü?ü‚Ì‚Ý?í?œ

        //System.out.println("(ori_s_1)zzzzz check4_size() = "+check4_size());
        int i_r = 0;
        //Ten p1 = new Ten();   p1.set(si.geta());
        Takakukei sikaku = new Takakukei(4);
        sikaku.set(1, p1);
        sikaku.set(2, p2);
        sikaku.set(3, p3);
        sikaku.set(4, p4);

        //System.out.println("(ori_s_2)zzzzz check4_size() = "+check4_size());

        String str = "";//•¶Žš—ñ?ˆ—?—p‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»
        Memo memo1 = new Memo();
        memo1.reset();
        memo1.addGyou("<?ü•ª?W?‡>");
        int ibangou = 0;

        for (int i = 1; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);

            if ((sikaku.totu_kyoukai_naibu(s) == 1) && (getcolor(i) < 3)) {
                i_r = 1;
            } else if ((sikaku.totu_kyoukai_naibu(s) != 1) || (getcolor(i) >= 3)) {
                ibangou = ibangou + 1;
                memo1.addGyou("”Ô?†," + ibangou);
                //Senbun s;s= sen(i);
                memo1.addGyou("?F," + str.valueOf(s.getcolor()));
                memo1.addGyou("?À•W," + str.valueOf(s.getax()) + "," + str.valueOf(s.getay()) + "," + str.valueOf(s.getbx()) + "," + str.valueOf(s.getby()));
            }
        }

        //System.out.println("(ori_s_3)zzzzz check4_size() = "+check4_size());

        //Ten ec=new Ten();//‰~‚Ì’†?S?À•W‚ð“ü‚ê‚é•Ï?”
        //double er;//‰~‚Ì’†?S?À•W‚ð“ü‚ê‚é•Ï?”


        //Senbun s1=new Senbun(p1,p2);
        //Senbun s2=new Senbun(p2,p3);
        //Senbun s3=new Senbun(p3,p4);
        //Senbun s4=new Senbun(p4,p1);


        memo1.addGyou("<‰~?W?‡>");
        int ii = 0;
        for (int i = 1; i <= cir_size(); i++) {
            //int idel=0;
            En e_temp = new En();
            e_temp.set(cir_getEn(i));//ec.set(e_temp.get_tyuusin());er=e_temp.getr();

            //if(oc.kyori_senbun(ec,s1)<= er){ if((oc.kyori(s1.geta(),ec)>= er)||(oc.kyori(s1.geta(),ec)>= er))  {idel=1;}}
            //if(oc.kyori_senbun(ec,s2)<= er){ if((oc.kyori(s2.geta(),ec)>= er)||(oc.kyori(s2.geta(),ec)>= er))  {idel=1;}}
            //if(oc.kyori_senbun(ec,s3)<= er){ if((oc.kyori(s3.geta(),ec)>= er)||(oc.kyori(s3.geta(),ec)>= er))  {idel=1;}}
            //if(oc.kyori_senbun(ec,s4)<= er){ if((oc.kyori(s4.geta(),ec)>= er)||(oc.kyori(s4.geta(),ec)>= er))  {idel=1;}}

            //if(sikaku.totu_kyoukai_naibu(new Senbun( e_temp.get_tyuusin(), e_temp.get_tyuusin()))==1){idel=1;}

            //if(idel==1){i_r=1;}
            //if(idel==0){
            ii = ii + 1;
            memo1.addGyou("”Ô?†," + ii);
            memo1.addGyou("’†?S‚Æ”¼Œa‚Æ?F," + str.valueOf(e_temp.getx()) + "," + str.valueOf(e_temp.gety()) + "," + str.valueOf(e_temp.getr()) + "," + str.valueOf(e_temp.getcolor()));
            //}
        }


        //System.out.println("(ori_s_4)zzzzz check4_size() = "+check4_size());


        reset();

        //System.out.println("(ori_s_5)zzzzzz check4_size() = "+check4_size());

        setMemo(memo1);

        //System.out.println("(ori_s_6)zzzzz check4_size() = "+check4_size());

        return i_r;
    }


    //--------------------------------
//--------------------------------
    public int D_nisuru2(Ten p1, Ten p2, Ten p3, Ten p4) {//?Ü?ü‚Ì‚Ý?í?œ
        int i_r = 0;
        Takakukei sikaku = new Takakukei(4);
        sikaku.set(1, p1);
        sikaku.set(2, p2);
        sikaku.set(3, p3);
        sikaku.set(4, p4);

        String str = "";//•¶Žš—ñ?ˆ—?—p‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»
        Memo memo1 = new Memo();
        memo1.reset();
        memo1.addGyou("<?ü•ª?W?‡>");
        int ibangou = 0;

        for (int i = 1; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);

            if ((sikaku.totu_kyoukai_naibu(s) == 1) && (getcolor(i) == 0)) {
                i_r = 1;
            } else if ((sikaku.totu_kyoukai_naibu(s) != 1) || (getcolor(i) >= 1)) {
                ibangou = ibangou + 1;
                memo1.addGyou("”Ô?†," + ibangou);
                memo1.addGyou("?F," + str.valueOf(s.getcolor()));
                memo1.addGyou("?À•W," + str.valueOf(s.getax()) + "," + str.valueOf(s.getay()) + "," + str.valueOf(s.getbx()) + "," + str.valueOf(s.getby()));
            }
        }

        memo1.addGyou("<‰~?W?‡>");
        int ii = 0;
        for (int i = 1; i <= cir_size(); i++) {
            En e_temp = new En();
            e_temp.set(cir_getEn(i));//ec.set(e_temp.get_tyuusin());er=e_temp.getr();
            ii = ii + 1;
            memo1.addGyou("”Ô?†," + ii);
            memo1.addGyou("’†?S‚Æ”¼Œa‚Æ?F," + str.valueOf(e_temp.getx()) + "," + str.valueOf(e_temp.gety()) + "," + str.valueOf(e_temp.getr()) + "," + str.valueOf(e_temp.getcolor()));
        }

        reset();
        setMemo(memo1);
        return i_r;
    }


    //--------------------------------
    public int D_nisuru3(Ten p1, Ten p2, Ten p3, Ten p4) {//•â?•Šˆ?ü‚Ì‚Ý?í?œ
        int i_r = 0;
        //Ten p1 = new Ten();   p1.set(si.geta());
        Takakukei sikaku = new Takakukei(4);
        sikaku.set(1, p1);
        sikaku.set(2, p2);
        sikaku.set(3, p3);
        sikaku.set(4, p4);

        String str = "";//•¶Žš—ñ?ˆ—?—p‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»
        Memo memo1 = new Memo();
        memo1.reset();
        memo1.addGyou("<?ü•ª?W?‡>");
        int ibangou = 0;

        for (int i = 1; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);

            if ((sikaku.totu_kyoukai_naibu(s) == 1) && (getcolor(i) == 3)) {
                i_r = 1;
            } else if ((sikaku.totu_kyoukai_naibu(s) != 1) || (getcolor(i) != 3)) {
                ibangou = ibangou + 1;
                memo1.addGyou("”Ô?†," + ibangou);
                //Senbun s;s= sen(i);
                memo1.addGyou("?F," + str.valueOf(s.getcolor()));
                memo1.addGyou("?À•W," + str.valueOf(s.getax()) + "," + str.valueOf(s.getay()) + "," + str.valueOf(s.getbx()) + "," + str.valueOf(s.getby()));
            }
        }


        Ten ec = new Ten();//‰~‚Ì’†?S?À•W‚ð“ü‚ê‚é•Ï?”
        double er;//‰~‚Ì’†?S?À•W‚ð“ü‚ê‚é•Ï?”


        Senbun s1 = new Senbun(p1, p2);
        Senbun s2 = new Senbun(p2, p3);
        Senbun s3 = new Senbun(p3, p4);
        Senbun s4 = new Senbun(p4, p1);


        memo1.addGyou("<‰~?W?‡>");
        int ii = 0;
        for (int i = 1; i <= cir_size(); i++) {
            int idel = 0;
            En e_temp = new En();
            e_temp.set(cir_getEn(i));
            ec.set(e_temp.get_tyuusin());
            er = e_temp.getr();

            if (oc.kyori_senbun(ec, s1) <= er) {
                if ((oc.kyori(s1.geta(), ec) >= er) || (oc.kyori(s1.geta(), ec) >= er)) {
                    idel = 1;
                }
            }
            if (oc.kyori_senbun(ec, s2) <= er) {
                if ((oc.kyori(s2.geta(), ec) >= er) || (oc.kyori(s2.geta(), ec) >= er)) {
                    idel = 1;
                }
            }
            if (oc.kyori_senbun(ec, s3) <= er) {
                if ((oc.kyori(s3.geta(), ec) >= er) || (oc.kyori(s3.geta(), ec) >= er)) {
                    idel = 1;
                }
            }
            if (oc.kyori_senbun(ec, s4) <= er) {
                if ((oc.kyori(s4.geta(), ec) >= er) || (oc.kyori(s4.geta(), ec) >= er)) {
                    idel = 1;
                }
            }

            if (sikaku.totu_kyoukai_naibu(new Senbun(e_temp.get_tyuusin(), e_temp.get_tyuusin())) == 1) {
                idel = 1;
            }

            if (idel == 1) {
                i_r = 1;
            }
            if (idel == 0) {
                ii = ii + 1;
                memo1.addGyou("”Ô?†," + ii);
                memo1.addGyou("’†?S‚Æ”¼Œa‚Æ?F," + str.valueOf(e_temp.getx()) + "," + str.valueOf(e_temp.gety()) + "," + str.valueOf(e_temp.getr()) + "," + str.valueOf(e_temp.getcolor()));
            }
        }


        reset();
        setMemo(memo1);


        return i_r;
    }


//--------------------------------

    //--------------------------------
    public int chenge_property_in_4kakukei(Ten p1, Ten p2, Ten p3, Ten p4, Color sen_tokutyuu_color) {//4ŠpŒ`‚Ì’†‚É‚ ‚é‰~‚â•â?•Šˆ?ü‚Ì?F‚È‚Ç‚Ìƒvƒ?ƒpƒeƒB‚ð•Ï‚¦‚é
        int i_r = 0;
        //Ten p1 = new Ten();   p1.set(si.geta());
        Takakukei sikaku = new Takakukei(4);
        sikaku.set(1, p1);
        sikaku.set(2, p2);
        sikaku.set(3, p3);
        sikaku.set(4, p4);

        for (int i = 1; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);

            if ((sikaku.totu_kyoukai_naibu(s) == 1) && (getcolor(i) == 3)) {
                i_r = 1;
                set_tpp_sen(i, 1);
                set_tpp_sen_color(i, sen_tokutyuu_color);
            }
        }

//wwwwwwww

        Ten ec = new Ten();//‰~‚Ì’†?S?À•W‚ð“ü‚ê‚é•Ï?”
        double er;//‰~‚Ì’†?S?À•W‚ð“ü‚ê‚é•Ï?”


        Senbun s1 = new Senbun(p1, p2);
        Senbun s2 = new Senbun(p2, p3);
        Senbun s3 = new Senbun(p3, p4);
        Senbun s4 = new Senbun(p4, p1);


        //("<‰~?W?‡>");
        for (int i = 1; i <= cir_size(); i++) {
            int i_change = 0;
            En e_temp = new En();
            e_temp.set(cir_getEn(i));
            ec.set(e_temp.get_tyuusin());
            er = e_temp.getr();

            if (oc.kyori_senbun(ec, s1) <= er) {
                if ((oc.kyori(s1.geta(), ec) >= er) || (oc.kyori(s1.geta(), ec) >= er)) {
                    i_change = 1;
                }
            }
            if (oc.kyori_senbun(ec, s2) <= er) {
                if ((oc.kyori(s2.geta(), ec) >= er) || (oc.kyori(s2.geta(), ec) >= er)) {
                    i_change = 1;
                }
            }
            if (oc.kyori_senbun(ec, s3) <= er) {
                if ((oc.kyori(s3.geta(), ec) >= er) || (oc.kyori(s3.geta(), ec) >= er)) {
                    i_change = 1;
                }
            }
            if (oc.kyori_senbun(ec, s4) <= er) {
                if ((oc.kyori(s4.geta(), ec) >= er) || (oc.kyori(s4.geta(), ec) >= er)) {
                    i_change = 1;
                }
            }

            if (sikaku.totu_kyoukai_naibu(new Senbun(e_temp.get_tyuusin(), e_temp.get_tyuusin())) == 1) {
                i_change = 1;
            }

            if (i_change == 1) {
                i_r = 1;
                set_tpp_en(i, 1);
                set_tpp_en_color(i, sen_tokutyuu_color);

            }
        }

        return i_r;
    }


//--------------------------------


    public void unselect(int i) {
        Senbun s;
        s = sen(i);
        s.set_i_select(0);
    }

    public int get_select(int i) {
        Senbun s;
        s = sen(i);
        return s.get_i_select();
    }

    public void set_select(int i, int isel) {
        Senbun s;
        s = sen(i);
        s.set_i_select(isel);
    }


    //----------------------------------------
    public void del_selected_senbun_hayai() {
        Memo memo_temp = new Memo();
        memo_temp.set(getMemo_select_jyogai(2));
        reset();
        setMemo(memo_temp);
    }

    //----------------------------------------
    public void del_selected_senbun() {
        int i_Flag = 1;
        while (i_Flag == 1) {
            //System.out.println("sousuu=" +sousuu);
            i_Flag = del_selected_senbun_symple_roop();
        }
    }

    //----------------------------------------
    public int del_selected_senbun_symple_roop() {//
        for (int i = 1; i <= sousuu; i++) {
            if (get_select(i) == 2) {
                delsenbun_vertex(i);
                return 1;
            }
        }
        return 0;
    }
//--------------------------------------------------------

    //“_?ó‚Ì?ü•ª‚ð?í?œ
    public void ten_sakujyo() {
        for (int i = 1; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);
            if (oc.hitosii(s.geta(), s.getb())) {
                delsenbun(i);
                i = i - 1;
            }
        }
    }

    public void ten_sakujyo(double r) {
        for (int i = 1; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);
            if (oc.hitosii(s.geta(), s.getb(), r)) {
                delsenbun(i);
                i = i - 1;
            }
        }
    }

    // ‘S‚­?d‚È‚é?ü•ª‚ª2–{‘¶?Ý‚·‚é‚Æ‚«‚É”Ô?†‚Ì’x‚¢‚Ù‚¤‚ð?í?œ‚·‚é?B
    public void jyuufuku_senbun_sakujyo(double r) {
        int[] sakujyo_flg = new int[sousuu + 1];
        Senbun[] snew = new Senbun[sousuu + 1];
        for (int i = 1; i <= sousuu; i++) {
            sakujyo_flg[i] = 0;
            snew[i] = new Senbun();
        }

        for (int i = 1; i <= sousuu - 1; i++) {
            Senbun si;
            si = sen(i);
            for (int j = i + 1; j <= sousuu; j++) {
                Senbun sj;
                sj = sen(j);
                if (r <= -9999.9) {
                    if (oc.senbun_kousa_hantei(si, sj) == 31) {
                        sakujyo_flg[j] = 1;
                    }
                } else {
                    if (oc.senbun_kousa_hantei(si, sj, r, r) == 31) {
                        sakujyo_flg[j] = 1;
                    }
                }
            }
        }

        int smax = 0;
        for (int i = 1; i <= sousuu; i++) {
            if (sakujyo_flg[i] == 0) {
                Senbun si;
                si = sen(i);
                smax = smax + 1;
                snew[smax].set(si);
            }
        }

        sousuu = smax;
        for (int i = 1; i <= sousuu; i++) {
            Senbun si;
            si = sen(i);
            si.set(snew[i]);
        }
    }

    //
    public void jyuufuku_senbun_sakujyo() {
        jyuufuku_senbun_sakujyo(-10000.0);
    }

    //
    public int jyuufuku_senbun_sakujyo(int i, int j) {    //?d•¡‚Ì?í?œ‚ð‚µ‚½‚ç1?A‚µ‚È‚¯‚ê‚Î0‚ð•Ô‚·
        if (i == j) {
            return 0;
        }
        Senbun si;
        si = sen(i);
        Senbun sj;
        sj = sen(j);
        if (oc.senbun_kousa_hantei(si, sj) == 31) {  //31‚Ísi‚Æsj‚ª‘S‚­“¯‚¶‚É?d‚È‚é‚±‚Æ‚ðŽ¦‚·
            delsenbun(j);
            return 1;
        }
        return 0;
    }


    //Œð?·‚µ‚Ä‚¢‚é‚Q‚Â‚Ì?ü•ª‚ÌŒð“_‚Å‚Q‚Â‚Ì?ü•ª‚ð•ªŠ„‚·‚é?B?@‚Ü‚Á‚½‚­?d‚È‚é?ü•ª‚ª‚Q‚Â‚ ‚Á‚½?ê?‡‚Í?A‚È‚ñ‚Ì?ˆ—?‚à‚È‚³‚ê‚È‚¢‚Ü‚Ü‚Q‚Â‚Æ‚àŽc‚é?B
    public void kousabunkatu_symple() {//System.out.println("1234567890   k_symple");
        int i_Flag = 1;
        while (i_Flag == 1) {
            System.out.println("sousuu=" + sousuu);
            i_Flag = kousabunkatu_symple_roop();
        }
    }


    public int kousabunkatu_symple_roop() {//1‰ñŒð?·•ªŠ„‚ª‚ ‚Á‚½‚ç?A’¼‚¿‚É1‚ðƒŠƒ^?[ƒ“‚·‚é?BŒð?·•ªŠ„‚ª‚Ü‚Á‚½‚­‚È‚¢‚È‚ç0‚ðƒŠƒ^?[ƒ“‚·‚é?B?A
//int jj=0;
        for (int i = 1; i <= sousuu - 1; i++) {

            //System.out.println("(i,j) = " +i+","+jj);
            for (int j = i + 1; j <= sousuu; j++) {
//jj=j;
                if (kousabunkatu(i, j) == 1) {
                    //System.out.println("(i,j) = " +i+","+j);
                    return 1;
                }


            }
        }
        return 0;
    }


    //------------------zzzzzzzzz-------------------------------------------------------------------
    //Œð?·‚µ‚Ä‚¢‚é‚Q‚Â‚Ì?ü•ª‚ÌŒð“_‚Å‚Q‚Â‚Ì?ü•ª‚ð•ªŠ„‚·‚é?B?@‚Ü‚Á‚½‚­?d‚È‚é?ü•ª‚ª‚Q‚Â‚ ‚Á‚½?ê?‡‚Í?A‚È‚ñ‚Ì?ˆ—?‚à‚È‚³‚ê‚È‚¢‚Ü‚Ü‚Q‚Â‚Æ‚àŽc‚é?B
    public void kousabunkatu(int i1, int i2, int i3, int i4) {//Œ³‚©‚ç‚ ‚Á‚½i1‚©‚çi2”Ô‚Ì?Ü?ü‚É?Ai3‚©‚çi4”Ô‚Ì?Ü?ü‚ð‰Á‚¦‚½‚Æ‚«‚ÌŒð?·•ªŠ„
        int ibunkatu = 1;//•ªŠ„‚ª‚ ‚ê‚Î1?A‚È‚¯‚ê‚Î0

        for (int i = 1; i <= sousuu; i++) {
            setiactive(i, 0);
        }//?í?œ‚·‚×‚«?ü‚Í iactive=100‚Æ‚·‚é
        //System.out.println("1234567890   kousabunkatu");
        ArrayList k_flg = new ArrayList();//Œð?·•ªŠ„‚Ì‰e‹¿‚ª‚ ‚é‚±‚Æ‚ðŽ¦‚·ƒtƒ‰ƒbƒO?B

        for (int i = 0; i <= sousuu + 100; i++) {
            k_flg.add(new Integer(0));
        }//0‚ÍŒð?·•ªŠ„‚Ì‘Î?ÛŠO?A‚P‚ÍŒ³‚©‚ç‚ ‚Á‚½?Ü?ü?A2‚Í‰Á‚¦‚é?Ü?ü‚Æ‚µ‚ÄŒð?·•ªŠ„‚³‚ê‚é?B3‚Í?í?œ‚·‚×‚«‚Æ”»’è‚³‚ê‚½?Ü?ü
        for (int i = i1; i <= i2; i++) {
            k_flg.set(i, new Integer(1));
        }//0‚ÍŒð?·•ªŠ„‚Ì‘Î?ÛŠO?A‚P‚ÍŒ³‚©‚ç‚ ‚Á‚½?Ü?ü?A2‚Í‰Á‚¦‚é?Ü?ü‚Æ‚µ‚ÄŒð?·•ªŠ„‚³‚ê‚é
        for (int i = i3; i <= i4; i++) {
            k_flg.set(i, new Integer(2));
        }//0‚ÍŒð?·•ªŠ„‚Ì‘Î?ÛŠO?A‚P‚ÍŒ³‚©‚ç‚ ‚Á‚½?Ü?ü?A2‚Í‰Á‚¦‚é?Ü?ü‚Æ‚µ‚ÄŒð?·•ªŠ„‚³‚ê‚é
        //int old_sousuu =sousuu;
        //while(ibunkatu!=0){ibunkatu=0;
        for (int i = 1; i <= sousuu; i++) {
            Integer I_k_flag = (Integer) k_flg.get(i);
            //System.out.println("sousuu="+sousuu +",i="+i+", I_k_flag="+I_k_flag ) ;
            if (I_k_flag.intValue() == 2) {//k_flg.set(i,new Integer(0));
                for (int j = 1; j <= sousuu; j++) {
                    if (i != j) {
                        Integer J_k_flag = (Integer) k_flg.get(j);
                        if (J_k_flag.intValue() == 1) {
                            int itemp = 0;
                            //int old_sousuu =sousuu;
                            itemp = kousabunkatu_hayai(i, j);//i‚Í‰Á‚¦‚é•û(2)?Aj‚ÍŒ³‚©‚ç‚ ‚é•û(1)
                            //System.out.println("itemp="+itemp);

                            //	if(old_sousuu<sousuu){
                            //		for (int is=old_sousuu+1;is<=sousuu;is++){
                            //			k_flg.add(new Integer(1));
                            //		}
                            //	}
                            //
                            if (itemp == 1) {
                                //ibunkatu=ibunkatu+1;
                                k_flg.add(new Integer(2));//‚È‚º‚©‚±‚ê‚¾‚Æ2‚Å‚È‚­‚Ä0‚Æ‚µ‚Ä’Ç‰Á‚³‚ê‚é?B20161130
                                k_flg.add(new Integer(1));
                                //System.out.println("sousuu="+sousuu +",i="+i+", I_k_flag="+I_k_flag ) ;
                                k_flg.set(sousuu - 1, new Integer(2));//
                                k_flg.set(sousuu, new Integer(1));
                            }
                            if (itemp == 2) {
                                //ibunkatu=ibunkatu+1;
                                k_flg.add(new Integer(2));//‚È‚º‚©‚±‚ê‚¾‚Æ2‚Å‚È‚­‚Ä0‚Æ‚µ‚Ä’Ç‰Á‚³‚ê‚é?B20161130
                                k_flg.set(sousuu, new Integer(2));
                            }
                            if (itemp == 3) {
                                //ibunkatu=ibunkatu+1;
                                k_flg.add(new Integer(1));//‚È‚º‚©‚±‚ê‚¾‚Æ2‚Å‚È‚­‚Ä0‚Æ‚µ‚Ä’Ç‰Á‚³‚ê‚é?B20161130
                                k_flg.set(sousuu, new Integer(1));
                            }


                            if (itemp == 121) {
                                //ibunkatu=ibunkatu+1;
                                //k_flg.add(new Integer(2));
                                k_flg.add(new Integer(1));
                                k_flg.set(sousuu, new Integer(1));

                            }
                            if (itemp == 122) {
                                //ibunkatu=ibunkatu+1;
                                //k_flg.add(new Integer(2));
                                k_flg.add(new Integer(1));
                                k_flg.set(sousuu, new Integer(1));
                            }
                            if (itemp == 211) {
                                //ibunkatu=ibunkatu+1;
                                k_flg.add(new Integer(2));
                                k_flg.set(sousuu, new Integer(2));

                            }
                            if (itemp == 221) {
                                //ibunkatu=ibunkatu+1;
                                k_flg.add(new Integer(2));
                                k_flg.set(sousuu, new Integer(2));
                            }
							/*
							if (itemp==321){
								k_flg.set(j,new Integer(0));//‰½‚à‚µ‚È‚­‚Ä‚à‚¢‚¢‚©‚à//ori_s_temp.senbun_bunkatu(s1.getb());//p1‚Æp3‚ªˆê’v?Asi‚Ésj‚ªŠÜ‚Ü‚ê‚é?B‰Á‚¦‚é?Ü?ü‚ðkousa_ten‚Å•ªŠ„‚·‚é‚±‚Æ

                                                		//k_flg.add(new Integer(2));
								//k_flg.set(sousuu,new Integer(2));

								}
							if (itemp==322){//‰½‚à‚µ‚È‚¢
							}
							*/
                            if (itemp == 361) {
                                k_flg.set(j, new Integer(0));//‰½‚à‚µ‚È‚­‚Ä‚à‚¢‚¢‚©‚à//ori_s_temp.senbun_bunkatu(s1.getb());//p1‚Æp3‚ªˆê’v?Asi‚Ésj‚ªŠÜ‚Ü‚ê‚é?B‰Á‚¦‚é?Ü?ü‚ðkousa_ten‚Å•ªŠ„‚·‚é‚±‚Æ
                                k_flg.add(new Integer(2));
                                k_flg.set(sousuu, new Integer(2));
                            }

                            if (itemp == 362) {
                                k_flg.set(j, new Integer(0));//‰½‚à‚µ‚È‚­‚Ä‚à‚¢‚¢‚©‚à//ori_s_temp.senbun_bunkatu(s1.getb());//p1‚Æp3‚ªˆê’v?Asi‚Ésj‚ªŠÜ‚Ü‚ê‚é?B‰Á‚¦‚é?Ü?ü‚ðkousa_ten‚Å•ªŠ„‚·‚é‚±‚Æ
                                k_flg.add(new Integer(2));
                                k_flg.set(sousuu, new Integer(2));
                            }
                            if (itemp == 363) {
                                //k_flg.set(j,new Integer(0));//‰½‚à‚µ‚È‚­‚Ä‚à‚¢‚¢‚©‚à//ori_s_temp.senbun_bunkatu(s1.getb());//p1‚Æp3‚ªˆê’v?Asi‚Ésj‚ªŠÜ‚Ü‚ê‚é?B‰Á‚¦‚é?Ü?ü‚ðkousa_ten‚Å•ªŠ„‚·‚é‚±‚Æ
                                k_flg.add(new Integer(1));
                                k_flg.set(sousuu, new Integer(1));
                            }
                            if (itemp == 364) {
                                //k_flg.set(j,new Integer(0));//‰½‚à‚µ‚È‚­‚Ä‚à‚¢‚¢‚©‚à//ori_s_temp.senbun_bunkatu(s1.getb());//p1‚Æp3‚ªˆê’v?Asi‚Ésj‚ªŠÜ‚Ü‚ê‚é?B‰Á‚¦‚é?Ü?ü‚ðkousa_ten‚Å•ªŠ„‚·‚é‚±‚Æ
                                k_flg.add(new Integer(1));
                                k_flg.set(sousuu, new Integer(1));
                            }
                            if (itemp == 371) {
                                //k_flg.set(j,new Integer(0));//‰½‚à‚µ‚È‚­‚Ä‚à‚¢‚¢‚©‚à//ori_s_temp.senbun_bunkatu(s1.getb());//p1‚Æp3‚ªˆê’v?Asi‚Ésj‚ªŠÜ‚Ü‚ê‚é?B‰Á‚¦‚é?Ü?ü‚ðkousa_ten‚Å•ªŠ„‚·‚é‚±‚Æ
                                k_flg.add(new Integer(0));
                                k_flg.set(sousuu, new Integer(0));
                            }
                            if (itemp == 372) {
                                //k_flg.set(j,new Integer(0));//‰½‚à‚µ‚È‚­‚Ä‚à‚¢‚¢‚©‚à//ori_s_temp.senbun_bunkatu(s1.getb());//p1‚Æp3‚ªˆê’v?Asi‚Ésj‚ªŠÜ‚Ü‚ê‚é?B‰Á‚¦‚é?Ü?ü‚ðkousa_ten‚Å•ªŠ„‚·‚é‚±‚Æ
                                k_flg.add(new Integer(0));
                                k_flg.set(sousuu, new Integer(0));
                            }
                            if (itemp == 373) {
                                //k_flg.set(j,new Integer(0));//‰½‚à‚µ‚È‚­‚Ä‚à‚¢‚¢‚©‚à//ori_s_temp.senbun_bunkatu(s1.getb());//p1‚Æp3‚ªˆê’v?Asi‚Ésj‚ªŠÜ‚Ü‚ê‚é?B‰Á‚¦‚é?Ü?ü‚ðkousa_ten‚Å•ªŠ„‚·‚é‚±‚Æ
                                k_flg.add(new Integer(0));
                                k_flg.set(sousuu, new Integer(0));
                            }
                            if (itemp == 374) {
                                //k_flg.set(j,new Integer(0));//‰½‚à‚µ‚È‚­‚Ä‚à‚¢‚¢‚©‚à//ori_s_temp.senbun_bunkatu(s1.getb());//p1‚Æp3‚ªˆê’v?Asi‚Ésj‚ªŠÜ‚Ü‚ê‚é?B‰Á‚¦‚é?Ü?ü‚ðkousa_ten‚Å•ªŠ„‚·‚é‚±‚Æ
                                k_flg.add(new Integer(0));
                                k_flg.set(sousuu, new Integer(0));
                            }
							/*if (itemp==3){
								Senbun si;si= sen(i);Senbun sj;sj= sen(j);
								int i_kousa_hantei=oc.senbun_kousa_hantei(si,sj,0.000001,0.000001);//i‚Í‰Á‚¦‚é•û(2)?Aj‚ÍŒ³‚©‚ç‚ ‚é•û(1)
								if(      i_kousa_hantei==321){k_flg.set(j,new Integer(3));//ori_s_temp.senbun_bunkatu(s1.getb());//p1‚Æp3‚ªˆê’v?Asi‚Ésj‚ªŠÜ‚Ü‚ê‚é?B‰Á‚¦‚é?Ü?ü‚ðkousa_ten‚Å•ªŠ„‚·‚é‚±‚Æ

								}else if(i_kousa_hantei==322){//ori_s.senbun_bunkatu(i , s0.getb());  //i”Ô–Ú‚Ì?ü•ª(’[“_a‚Æb)‚ð“_p‚Å•ªŠ„‚·‚é?Bi”Ô–Ú‚Ì?ü•ªab‚ðap‚É•Ï‚¦?A?ü•ªpb‚ð‰Á‚¦‚é?B
								}else if(i_kousa_hantei==331){//ori_s_temp.senbun_bunkatu(s1.geta());//‰Á‚¦‚é?Ü?ü‚ðkousa_ten‚Å•ªŠ„‚·‚é‚±‚Æ
								}else if(i_kousa_hantei==332){//ori_s.senbun_bunkatu(i , s0.getb());  //i”Ô–Ú‚Ì?ü•ª(’[“_a‚Æb)‚ð“_p‚Å•ªŠ„‚·‚é?Bi”Ô–Ú‚Ì?ü•ªab‚ðap‚É•Ï‚¦?A?ü•ªpb‚ð‰Á‚¦‚é?B
								}else if(i_kousa_hantei==341){//ori_s_temp.senbun_bunkatu(s1.getb());//‰Á‚¦‚é?Ü?ü‚ðkousa_ten‚Å•ªŠ„‚·‚é‚±‚Æ
								}else if(i_kousa_hantei==342){//ori_s.senbun_bunkatu(i , s0.geta());  //i”Ô–Ú‚Ì?ü•ª(’[“_a‚Æb)‚ð“_p‚Å•ªŠ„‚·‚é?Bi”Ô–Ú‚Ì?ü•ªab‚ðap‚É•Ï‚¦?A?ü•ªpb‚ð‰Á‚¦‚é?B
								}else if(i_kousa_hantei==351){//ori_s_temp.senbun_bunkatu(s1.geta());//‰Á‚¦‚é?Ü?ü‚ðkousa_ten‚Å•ªŠ„‚·‚é‚±‚Æ
								}else if(i_kousa_hantei==352){//ori_s.senbun_bunkatu(i , s0.geta());  //i”Ô–Ú‚Ì?ü•ª(’[“_a‚Æb)‚ð“_p‚Å•ªŠ„‚·‚é?Bi”Ô–Ú‚Ì?ü•ªab‚ðap‚É•Ï‚¦?A?ü•ªpb‚ð‰Á‚¦‚é?B

								}else if(i_kousa_hantei==361){//ori_s_temp.senbun_bunkatu(s1.geta()); ori_s_temp.senbun_bunkatu(s1.getb());   ori_s.setiactive(i,100);//imax=imax-1;
								}else if(i_kousa_hantei==362){//ori_s_temp.senbun_bunkatu(s1.geta()); ori_s_temp.senbun_bunkatu(s1.getb());   ori_s.setiactive(i,100);//imax=imax-1;
								}else if(i_kousa_hantei==363){//ori_s.addsenbun(s0.getb(),s1.getb(),s1.getcolor());ori_s.setb(i,s0.geta());
								}else if(i_kousa_hantei==364){//ori_s.addsenbun(s0.geta(),s1.getb(),s1.getcolor());ori_s.setb(i,s0.getb());

								}else if(i_kousa_hantei==371){//ori_s_temp.senbun_bunkatu(s1.geta());ori_s.seta(i,s0.getb());
								}else if(i_kousa_hantei==372){//ori_s_temp.senbun_bunkatu(s1.getb());ori_s.setb(i,s0.getb());
								}else if(i_kousa_hantei==373){//ori_s_temp.senbun_bunkatu(s1.getb());ori_s.setb(i,s0.geta());
								}else if(i_kousa_hantei==374){//ori_s_temp.senbun_bunkatu(s1.geta());ori_s.seta(i,s0.geta());


								}

			 				}*/
                        }
                    }
                }
            }
        }

        Memo memo_temp = new Memo();
        memo_temp.set(getMemo_iactive_jyogai(100));
        reset();
        setMemo(memo_temp);
    }

    //---------------------
    public int kousabunkatu_hayai(int i, int j) {//i‚Í‰Á‚¦‚é•û(2)?Aj‚ÍŒ³‚©‚ç‚ ‚é•û(1)//=0 Œð?·‚¹‚¸
        Senbun si;
        si = sen(i);
        Senbun sj;
        sj = sen(j);

        if (si.get_i_max_x() < sj.get_i_min_x()) {
            return 0;
        }
        if (sj.get_i_max_x() < si.get_i_min_x()) {
            return 0;
        }
        if (si.get_i_max_y() < sj.get_i_min_y()) {
            return 0;
        }
        if (sj.get_i_max_y() < si.get_i_min_y()) {
            return 0;
        }
        //		System.out.println("kousabunkatu_hayai 01");
        Ten kousa_ten = new Ten();
        int kousa_flg0, kousa_flg1;

//‚±‚±‚Å‚Ì?u2–{‚Ì?ü•ªA,B‚ª‚Ç‚Ì‚æ‚¤‚ÉŒð?·‚·‚é‚©?v‚Ì?l‚¦•û‚Æ‚µ‚Ä?i‚P?j?ü•ªA‚ð’¼?ü‚É‚µ‚Ä?A?ü•ªB‚Í‚»‚Ì‚Ü‚Ü?ü•ª‚Æ‚·‚é?i‚Q?j?ü•ªB‚Ì2‚Â‚Ì’[“_‚ª‹¤‚É‚»‚Ì’¼?ü‚Ì•Ð‘¤‚É‚ ‚é‚©?A•Ê?X‚É’¼?ü‚Ì—¼‘¤‚É‚ ‚é‚©‚Æ‚¢‚¤•—‚É?l‚¦‚é?B
//‚±‚ÌŠm”F‚ª‚¨‚í‚Á‚½‚ç?AŽŸ‚É?ü•ªB‚ð’¼?ü‚É‚µ‚Ä?A?ü•ªA‚Í‚»‚Ì‚Ü‚Ü?ü•ª‚Æ‚µ?A“¯—l‚ÉŠm”F‚·‚é?B?@ˆÈ?ã‚ð‘??‡‚µ‚Ä2–{‚Ì?ü•ªA,B‚ª‚Ç‚Ì‚æ‚¤‚ÉŒð?·‚·‚é‚©‚ð?l‚¦‚é?B


        Tyokusen tyoku0 = new Tyokusen(si.geta(), si.getb());
        kousa_flg0 = tyoku0.senbun_kousa_hantei_kuwasii(sj);//senbun_kousa_hantei(Senbun s0){//0=‚±‚Ì’¼?ü‚Í—^‚¦‚ç‚ê‚½?ü•ª‚ÆŒð?·‚µ‚È‚¢?A1=XŒ^‚ÅŒð?·‚·‚é?A2=TŒ^‚ÅŒð?·‚·‚é?A3=?ü•ª‚Í’¼?ü‚ÉŠÜ‚Ü‚ê‚é?B
        if (kousa_flg0 == 0) {
            return 0;
        }

        Tyokusen tyoku1 = new Tyokusen(sj.geta(), sj.getb());
        kousa_flg1 = tyoku1.senbun_kousa_hantei_kuwasii(si);
        if (kousa_flg0 == 0) {
            return 0;
        }

        // --------------------------------------
        //	XŒð?·
        // --------------------------------------
        if ((kousa_flg0 == 1) && (kousa_flg1 == 1)) {//(kousa_flg0==1)&&(kousa_flg1==1) ‰Á‚¦‚é?Ü?ü‚ÆŠù‘¶‚Ì?Ü?ü‚ÍXŒ^‚ÅŒð‚í‚é
            kousa_ten.set(oc.kouten_motome(tyoku0, tyoku1));
            //kousa_ten.set(oc.kouten_motome(tyoku0,tyoku1));
            //kousa_ten.set(oc.kouten_motome(tyoku0,tyoku1));

            if (((si.getcolor() != 3) && (sj.getcolor() != 3))
                    || ((si.getcolor() == 3) && (sj.getcolor() == 3))) {

                //addsenbun(kousa_ten,si.getb(),si.getcolor());
                addsenbun(kousa_ten, si.getb(), si);
                si.setb(kousa_ten);  //i”Ô–Ú‚Ì?ü•ª(’[“_a‚Æb)‚ð“_p‚Å•ªŠ„‚·‚é?Bi”Ô–Ú‚Ì?ü•ªab‚ðap‚É•Ï‚¦?A?ü•ªpb‚ð‰Á‚¦‚é?B

                //addsenbun(kousa_ten,sj.getb(),sj.getcolor());
                addsenbun(kousa_ten, sj.getb(), sj);

                sj.setb(kousa_ten);  //i”Ô–Ú‚Ì?ü•ª(’[“_a‚Æb)‚ð“_p‚Å•ªŠ„‚·‚é?Bi”Ô–Ú‚Ì?ü•ªab‚ðap‚É•Ï‚¦?A?ü•ªpb‚ð‰Á‚¦‚é?B

                return 1;
            }

            if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {//‰Á‚¦‚é‚Ù‚¤i‚ª?…?F?ü?i•â?•Šˆ?ü?j?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?Ü?ü

                //addsenbun(kousa_ten,si.getb(),si.getcolor());
                addsenbun(kousa_ten, si.getb(), si);

                si.setb(kousa_ten);  //i”Ô–Ú‚Ì?ü•ª(’[“_a‚Æb)‚ð“_p‚Å•ªŠ„‚·‚é?Bi”Ô–Ú‚Ì?ü•ªab‚ðap‚É•Ï‚¦?A?ü•ªpb‚ð‰Á‚¦‚é?B

                //addsenbun(kousa_ten,sj.getb(),sj.getcolor());
                //sj.setb(kousa_ten);  //j”Ô–Ú‚Ì?ü•ª(’[“_a‚Æb)‚ð“_p‚Å•ªŠ„‚·‚é?Bj”Ô–Ú‚Ì?ü•ªab‚ðap‚É•Ï‚¦?A?ü•ªpb‚ð‰Á‚¦‚é?B

                return 2;
            }

            if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {//‰Á‚¦‚é‚Ù‚¤i‚ª?Ü?ü?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?…?F?ü?i•â?•Šˆ?ü?j

                //addsenbun(kousa_ten,si.getb(),si.getcolor());
                //si.setb(kousa_ten);  //i”Ô–Ú‚Ì?ü•ª(’[“_a‚Æb)‚ð“_p‚Å•ªŠ„‚·‚é?Bi”Ô–Ú‚Ì?ü•ªab‚ðap‚É•Ï‚¦?A?ü•ªpb‚ð‰Á‚¦‚é?B

                //addsenbun(kousa_ten,sj.getb(),sj.getcolor());
                addsenbun(kousa_ten, sj.getb(), sj);

                sj.setb(kousa_ten);  //j”Ô–Ú‚Ì?ü•ª(’[“_a‚Æb)‚ð“_p‚Å•ªŠ„‚·‚é?Bj”Ô–Ú‚Ì?ü•ªab‚ðap‚É•Ï‚¦?A?ü•ªpb‚ð‰Á‚¦‚é?B

                return 3;
            }
        }


        // --------------------------------------
        //	TŒð?·(‰Á‚¦‚é?Ü?ü‚Ìa“_‚ÅŒð‚í‚é)
        // --------------------------------------
        if ((kousa_flg0 == 1) && (kousa_flg1 == 21)) {//‰Á‚¦‚é?Ü?ü‚ÆŠù‘¶‚Ì?Ü?ü‚ÍTŒ^(‰Á‚¦‚é?Ü?ü‚ª?c?AŠù‘¶‚Ì?Ü?ü‚ª‰¡)‚ÅŒð‚í‚é(?c‚Ìa“_‚ÅŒð‚í‚é)

            Ten pk = new Ten();
            pk.set(oc.kage_motome(oc.Senbun2Tyokusen(sj), si.geta()));//pk‚Í“_p‚Ì?i?ü•ª‚ðŠÜ‚Þ’¼?ü?ã‚Ì?j‰e
            kousa_ten.set(pk);//Œð?·“_‚Í?Ü?üi?ã‚Ìs0‚Ì’[“_‚Ì‰e 20161129
            //ori_s.senbun_bunkatu(i , kousa_ten);  //i”Ô–Ú‚Ì?ü•ª(’[“_a‚Æb)‚ð“_p‚Å•ªŠ„‚·‚é?Bi”Ô–Ú‚Ì?ü•ªab‚ðap‚É•Ï‚¦?A?ü•ªpb‚ð‰Á‚¦‚é?B
            //ˆÈ?ã‚Å‘€?ì?I—¹			kousa_ten.set(oc.kouten_motome(tyoku0,tyoku1));

            if (((si.getcolor() != 3) && (sj.getcolor() != 3))
                    || ((si.getcolor() == 3) && (sj.getcolor() == 3))) {
                //addsenbun(kousa_ten,sj.getb(),sj.getcolor());
                addsenbun(kousa_ten, sj.getb(), sj);

                sj.setb(kousa_ten);  //i”Ô–Ú‚Ì?ü•ª(’[“_a‚Æb)‚ð“_p‚Å•ªŠ„‚·‚é?Bi”Ô–Ú‚Ì?ü•ªab‚ðap‚É•Ï‚¦?A?ü•ªpb‚ð‰Á‚¦‚é?B
                return 121;
            }

            if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {//‰Á‚¦‚é‚Ù‚¤i‚ª?…?F?ü?i•â?•Šˆ?ü?j?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?Ü?ü
                return 0;//TŒð?·‚Í‚µ‚Ä‚é‚ª?A?c?ü‚ª•â?•Šˆ?ü‚È‚Ì‚Å‰½‚à‚µ‚È‚¢‚Ì‚Å?A0‚Åreturn‚·‚é?B
            }

            if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {//‰Á‚¦‚é‚Ù‚¤i‚ª?Ü?ü?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?…?F?ü?i•â?•Šˆ?ü?j
                //addsenbun(kousa_ten,sj.getb(),sj.getcolor());
                addsenbun(kousa_ten, sj.getb(), sj);

                sj.setb(kousa_ten);  //i”Ô–Ú‚Ì?ü•ª(’[“_a‚Æb)‚ð“_p‚Å•ªŠ„‚·‚é?Bi”Ô–Ú‚Ì?ü•ªab‚ðap‚É•Ï‚¦?A?ü•ªpb‚ð‰Á‚¦‚é?B
                return 121;
            }
        }

        // --------------------------------------
        //	TŒð?·(‰Á‚¦‚é?Ü?ü‚Ìb“_‚ÅŒð‚í‚é)
        // --------------------------------------
        if ((kousa_flg0 == 1) && (kousa_flg1 == 22)) {//‰Á‚¦‚é?Ü?ü‚ÆŠù‘¶‚Ì?Ü?ü‚ÍTŒ^(‰Á‚¦‚é?Ü?ü‚ª?c?AŠù‘¶‚Ì?Ü?ü‚ª‰¡)‚ÅŒð‚í‚é(?c‚Ìb“_‚ÅŒð‚í‚é)
            Ten pk = new Ten();
            pk.set(oc.kage_motome(oc.Senbun2Tyokusen(sj), si.getb()));//pk‚Í“_p‚Ì?i?ü•ª‚ðŠÜ‚Þ’¼?ü?ã‚Ì?j‰e
            kousa_ten.set(pk);//Œð?·“_‚Í?Ü?üi?ã‚Ìs0‚Ì’[“_‚Ì‰e 20161129
            //ori_s.senbun_bunkatu(i , kousa_ten);  //i”Ô–Ú‚Ì?ü•ª(’[“_a‚Æb)‚ð“_p‚Å•ªŠ„‚·‚é?Bi”Ô–Ú‚Ì?ü•ªab‚ðap‚É•Ï‚¦?A?ü•ªpb‚ð‰Á‚¦‚é?B
            //ˆÈ?ã‚Å‘€?ì?I—¹			kousa_ten.set(oc.kouten_motome(tyoku0,tyoku1));

            if (((si.getcolor() != 3) && (sj.getcolor() != 3))
                    || ((si.getcolor() == 3) && (sj.getcolor() == 3))) {
                //addsenbun(kousa_ten,sj.getb(),sj.getcolor());
                addsenbun(kousa_ten, sj.getb(), sj);

                sj.setb(kousa_ten);  //i”Ô–Ú‚Ì?ü•ª(’[“_a‚Æb)‚ð“_p‚Å•ªŠ„‚·‚é?Bi”Ô–Ú‚Ì?ü•ªab‚ðap‚É•Ï‚¦?A?ü•ªpb‚ð‰Á‚¦‚é?B
                return 122;
            }

            if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {//‰Á‚¦‚é‚Ù‚¤i‚ª?…?F?ü?i•â?•Šˆ?ü?j?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?Ü?ü
                return 0;//TŒð?·‚Í‚µ‚Ä‚é‚ª?A?c?ü‚ª•â?•Šˆ?ü‚È‚Ì‚Å‰½‚à‚µ‚È‚¢‚Ì‚Å?A0‚Åreturn‚·‚é?B
            }

            if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {//‰Á‚¦‚é‚Ù‚¤i‚ª?Ü?ü?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?…?F?ü?i•â?•Šˆ?ü?j
                //addsenbun(kousa_ten,sj.getb(),sj.getcolor());
                addsenbun(kousa_ten, sj.getb(), sj);

                sj.setb(kousa_ten);  //i”Ô–Ú‚Ì?ü•ª(’[“_a‚Æb)‚ð“_p‚Å•ªŠ„‚·‚é?Bi”Ô–Ú‚Ì?ü•ªab‚ðap‚É•Ï‚¦?A?ü•ªpb‚ð‰Á‚¦‚é?B
                return 122;
            }
        }

        // --------------------------------------
        //	TŒð?·(Œ³‚©‚ç‚ ‚Á‚½?Ü?ü‚Ìa“_‚ÅŒð‚í‚é)
        // --------------------------------------
        if ((kousa_flg0 == 21) && (kousa_flg1 == 1)) {//‰Á‚¦‚é?Ü?ü‚ÆŠù‘¶‚Ì?Ü?ü‚ÍTŒ^(‰Á‚¦‚é?Ü?ü‚ª‰¡?AŠù‘¶‚Ì?Ü?ü‚ª?c)‚ÅŒð‚í‚é(?c‚Ìa“_‚ÅŒð‚í‚é)
            Ten pk = new Ten();
            pk.set(oc.kage_motome(oc.Senbun2Tyokusen(si), sj.geta()));//pk‚Í“_p‚Ì?i?ü•ª‚ðŠÜ‚Þ’¼?ü?ã‚Ì?j‰e
            kousa_ten.set(pk);//Œð?·“_‚Í?Ü?üi?ã‚Ìs0‚Ì’[“_‚Ì‰e 20161129
            //ori_s.senbun_bunkatu(i , kousa_ten);  //i”Ô–Ú‚Ì?ü•ª(’[“_a‚Æb)‚ð“_p‚Å•ªŠ„‚·‚é?Bi”Ô–Ú‚Ì?ü•ªab‚ðap‚É•Ï‚¦?A?ü•ªpb‚ð‰Á‚¦‚é?B
            //ˆÈ?ã‚Å‘€?ì?I—¹			kousa_ten.set(oc.kouten_motome(tyoku0,tyoku1));

            if (((si.getcolor() != 3) && (sj.getcolor() != 3))
                    || ((si.getcolor() == 3) && (sj.getcolor() == 3))) {
                //addsenbun(kousa_ten,si.getb(),si.getcolor());
                addsenbun(kousa_ten, si.getb(), si);

                si.setb(kousa_ten);
                return 211;
            }

            if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {//‰Á‚¦‚é‚Ù‚¤i‚ª?…?F?ü?i•â?•Šˆ?ü?j?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?Ü?ü
                //addsenbun(kousa_ten,si.getb(),si.getcolor());
                addsenbun(kousa_ten, si.getb(), si);

                si.setb(kousa_ten);
                return 211;
            }

            if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {//‰Á‚¦‚é‚Ù‚¤i‚ª?Ü?ü?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?…?F?ü?i•â?•Šˆ?ü?j
                return 0;//TŒð?·‚Í‚µ‚Ä‚é‚ª?A?c?ü‚ª•â?•Šˆ?ü‚È‚Ì‚Å‰½‚à‚µ‚È‚¢‚Ì‚Å?A0‚Åreturn‚·‚é?B
            }
        }

        // --------------------------------------
        //	TŒð?·(Œ³‚©‚ç‚ ‚Á‚½?Ü?ü‚Ì?Ü?ü‚Ìb“_‚ÅŒð‚í‚é)
        // --------------------------------------
        if ((kousa_flg0 == 22) && (kousa_flg1 == 1)) {//‰Á‚¦‚é?Ü?ü‚ÆŠù‘¶‚Ì?Ü?ü‚ÍTŒ^(‰Á‚¦‚é?Ü?ü‚ª‰¡?AŠù‘¶‚Ì?Ü?ü‚ª?c)‚ÅŒð‚í‚é(?c‚Ìa“_‚ÅŒð‚í‚é)
            Ten pk = new Ten();
            pk.set(oc.kage_motome(oc.Senbun2Tyokusen(si), sj.getb()));//pk‚Í“_p‚Ì?i?ü•ª‚ðŠÜ‚Þ’¼?ü?ã‚Ì?j‰e
            kousa_ten.set(pk);//Œð?·“_‚Í?Ü?üi?ã‚Ìs0‚Ì’[“_‚Ì‰e 20161129
            //ori_s.senbun_bunkatu(i , kousa_ten);  //i”Ô–Ú‚Ì?ü•ª(’[“_a‚Æb)‚ð“_p‚Å•ªŠ„‚·‚é?Bi”Ô–Ú‚Ì?ü•ªab‚ðap‚É•Ï‚¦?A?ü•ªpb‚ð‰Á‚¦‚é?B
            //ˆÈ?ã‚Å‘€?ì?I—¹			kousa_ten.set(oc.kouten_motome(tyoku0,tyoku1));

            if (((si.getcolor() != 3) && (sj.getcolor() != 3))
                    || ((si.getcolor() == 3) && (sj.getcolor() == 3))) {
                //addsenbun(kousa_ten,si.getb(),si.getcolor());
                addsenbun(kousa_ten, si.getb(), si);

                si.setb(kousa_ten);
                return 221;
            }

            if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {//‰Á‚¦‚é‚Ù‚¤i‚ª?…?F?ü?i•â?•Šˆ?ü?j?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?Ü?ü
                //addsenbun(kousa_ten,si.getb(),si.getcolor());
                addsenbun(kousa_ten, si.getb(), si);

                si.setb(kousa_ten);
                return 221;
            }

            if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {//‰Á‚¦‚é‚Ù‚¤i‚ª?Ü?ü?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?…?F?ü?i•â?•Šˆ?ü?j
                return 0;//TŒð?·‚Í‚µ‚Ä‚é‚ª?A?c?ü‚ª•â?•Šˆ?ü‚È‚Ì‚Å‰½‚à‚µ‚È‚¢‚Ì‚Å?A0‚Åreturn‚·‚é?B
            }

        }


/*
			if(((si.getcolor()!=3)&&(sj.getcolor()!=3))
			|| ((si.getcolor()==3)&&(sj.getcolor()==3)) )	{


			}

			if((si.getcolor()==3)&&(sj.getcolor()!=3)){//‰Á‚¦‚é‚Ù‚¤i‚ª?…?F?ü?i•â?•Šˆ?ü?j?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?Ü?ü

			}

			if((si.getcolor()!=3)&&(sj.getcolor()==3)){//‰Á‚¦‚é‚Ù‚¤i‚ª?Ü?ü?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?…?F?ü?i•â?•Šˆ?ü?j

			}
*/


        // --------------------------------------
        //	‰Á‚¦‚é?Ü?ü‚ÆŠù‘¶‚Ì?Ü?ü‚Í•½?s
        // --------------------------------------
        if (kousa_flg0 == 3) {//‰Á‚¦‚é?Ü?ü‚ÆŠù‘¶‚Ì?Ü?ü‚Í“¯ˆê’¼?ü?ã‚É‚ ‚é
            Ten p1 = new Ten();
            p1.set(si.geta());
            Ten p2 = new Ten();
            p2.set(si.getb());
            Ten p3 = new Ten();
            p3.set(sj.geta());
            Ten p4 = new Ten();
            p4.set(sj.getb());

            //setiactive(j,100)‚Æ‚³‚ê‚½?Ü?ü‚Í?Akousabunkatu(int i1,int i2,int i3,int i4)‚Ì‘€?ì‚ª–ß‚Á‚½Œã‚Å?í?œ‚³‚ê‚é?B

            int i_kousa_hantei = oc.senbun_kousa_hantei(si, sj, 0.000001, 0.000001);//i‚Í‰Á‚¦‚é•û(2)?Aj‚ÍŒ³‚©‚ç‚ ‚é•û(1)


            if (i_kousa_hantei == 31) {// ‚Q‚Â‚Ì?ü•ª‚ª‘S‚­“¯‚¶
                if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {
                    return 0;
                } //‰Á‚¦‚é‚Ù‚¤i‚ª?…?F?ü?i•â?•Šˆ?ü?j?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?Ü?ü
                if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {
                    return 0;
                }//‰Á‚¦‚é‚Ù‚¤i‚ª?Ü?ü?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?…?F?ü?i•â?•Šˆ?ü?j

                setiactive(j, 100);
                //si.seta(sj.getb());
                return 31;

            } else if (i_kousa_hantei == 321) {//(p1=p3)_p4_p2?Asi‚Ésj‚ªŠÜ‚Ü‚ê‚é?B
                if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {
                    return 0;
                } //‰Á‚¦‚é‚Ù‚¤i‚ª?…?F?ü?i•â?•Šˆ?ü?j?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?Ü?ü
                if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {
                    return 0;
                }//‰Á‚¦‚é‚Ù‚¤i‚ª?Ü?ü?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?…?F?ü?i•â?•Šˆ?ü?j
                sj.setcolor(si.getcolor());
                si.seta(sj.getb());
                return 321;
            } else if (i_kousa_hantei == 322) {//(p1=p3)_p2_p4?Asi‚ªsj‚ÉŠÜ‚Ü‚ê‚é?B
                if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {
                    return 0;
                } //‰Á‚¦‚é‚Ù‚¤i‚ª?…?F?ü?i•â?•Šˆ?ü?j?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?Ü?ü
                if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {
                    return 0;
                }//‰Á‚¦‚é‚Ù‚¤i‚ª?Ü?ü?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?…?F?ü?i•â?•Šˆ?ü?j

                sj.seta(si.getb());
                return 322;
            } else if (i_kousa_hantei == 331) {//(p1=p4)_p3_p2?Asi‚Ésj‚ªŠÜ‚Ü‚ê‚é?B
                if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {
                    return 0;
                } //‰Á‚¦‚é‚Ù‚¤i‚ª?…?F?ü?i•â?•Šˆ?ü?j?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?Ü?ü
                if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {
                    return 0;
                }//‰Á‚¦‚é‚Ù‚¤i‚ª?Ü?ü?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?…?F?ü?i•â?•Šˆ?ü?j

                sj.setcolor(si.getcolor());
                si.seta(sj.geta());
                return 331;
            } else if (i_kousa_hantei == 332) {//(p1=p4)_p2_p3?Asi‚ªsj‚ÉŠÜ‚Ü‚ê‚é?B
                if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {
                    return 0;
                } //‰Á‚¦‚é‚Ù‚¤i‚ª?…?F?ü?i•â?•Šˆ?ü?j?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?Ü?ü
                if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {
                    return 0;
                }//‰Á‚¦‚é‚Ù‚¤i‚ª?Ü?ü?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?…?F?ü?i•â?•Šˆ?ü?j

                sj.setb(si.getb());
                return 332;


            } else if (i_kousa_hantei == 341) {//(p2=p3)_p4_p1?Asi‚Ésj‚ªŠÜ‚Ü‚ê‚é?B
                if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {
                    return 0;
                } //‰Á‚¦‚é‚Ù‚¤i‚ª?…?F?ü?i•â?•Šˆ?ü?j?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?Ü?ü
                if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {
                    return 0;
                }//‰Á‚¦‚é‚Ù‚¤i‚ª?Ü?ü?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?…?F?ü?i•â?•Šˆ?ü?j

                sj.setcolor(si.getcolor());
                si.setb(sj.getb());
                return 341;

            } else if (i_kousa_hantei == 342) {//(p2=p3)_p1_p4?Asi‚ªsj‚ÉŠÜ‚Ü‚ê‚é?B
                if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {
                    return 0;
                } //‰Á‚¦‚é‚Ù‚¤i‚ª?…?F?ü?i•â?•Šˆ?ü?j?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?Ü?ü
                if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {
                    return 0;
                }//‰Á‚¦‚é‚Ù‚¤i‚ª?Ü?ü?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?…?F?ü?i•â?•Šˆ?ü?j

                sj.seta(si.geta());
                return 342;


            } else if (i_kousa_hantei == 351) {//(p2=p4)_p3_p1?Asi‚Ésj‚ªŠÜ‚Ü‚ê‚é?B
                if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {
                    return 0;
                } //‰Á‚¦‚é‚Ù‚¤i‚ª?…?F?ü?i•â?•Šˆ?ü?j?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?Ü?ü
                if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {
                    return 0;
                }//‰Á‚¦‚é‚Ù‚¤i‚ª?Ü?ü?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?…?F?ü?i•â?•Šˆ?ü?j

                sj.setcolor(si.getcolor());
                si.setb(sj.geta());
                return 351;


            } else if (i_kousa_hantei == 352) {//(p2=p4)_p1_p3?Asi‚ªsj‚ÉŠÜ‚Ü‚ê‚é?B
                if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {
                    return 0;
                } //‰Á‚¦‚é‚Ù‚¤i‚ª?…?F?ü?i•â?•Šˆ?ü?j?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?Ü?ü
                if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {
                    return 0;
                }//‰Á‚¦‚é‚Ù‚¤i‚ª?Ü?ü?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?…?F?ü?i•â?•Šˆ?ü?j

                sj.setb(si.geta());
                return 352;


            } else if (i_kousa_hantei == 361) {//?ü•ª(p1,p2)‚É?ü•ª(p3,p4)‚ªŠÜ‚Ü‚ê‚é ori_s_temp.senbun_bunkatu(s1.geta()); ori_s_temp.senbun_bunkatu(s1.getb());   ori_s.setiactive(i,100);//imax=imax-1;
                if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {
                    return 0;
                } //‰Á‚¦‚é‚Ù‚¤i‚ª?…?F?ü?i•â?•Šˆ?ü?j?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?Ü?ü
                if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {
                    return 0;
                }//‰Á‚¦‚é‚Ù‚¤i‚ª?Ü?ü?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?…?F?ü?i•â?•Šˆ?ü?j

                sj.setcolor(si.getcolor());
                //addsenbun(sj.getb(),si.getb(),si.getcolor());
                addsenbun(sj.getb(), si.getb(), si);

                si.setb(sj.geta());
                return 361;
            } else if (i_kousa_hantei == 362) {//?ü•ª(p1,p2)‚É?ü•ª(p4,p3)‚ªŠÜ‚Ü‚ê‚é; ori_s_temp.senbun_bunkatu(s1.getb());   ori_s.setiactive(i,100);//imax=imax-1;
                if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {
                    return 0;
                } //‰Á‚¦‚é‚Ù‚¤i‚ª?…?F?ü?i•â?•Šˆ?ü?j?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?Ü?ü
                if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {
                    return 0;
                }//‰Á‚¦‚é‚Ù‚¤i‚ª?Ü?ü?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?…?F?ü?i•â?•Šˆ?ü?j

                sj.setcolor(si.getcolor());
                //addsenbun(sj.geta(),si.getb(),si.getcolor());
                addsenbun(sj.geta(), si.getb(), si);

                si.setb(sj.getb());
                return 362;
            } else if (i_kousa_hantei == 363) {//?ü•ª(p3,p4)‚É?ü•ª(p1,p2)‚ªŠÜ‚Ü‚ê‚é ori_s.addsenbun(s0.getb(),s1.getb(),s1.getcolor());ori_s.setb(i,s0.geta());
                if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {
                    return 0;
                } //‰Á‚¦‚é‚Ù‚¤i‚ª?…?F?ü?i•â?•Šˆ?ü?j?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?Ü?ü
                if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {
                    return 0;
                }//‰Á‚¦‚é‚Ù‚¤i‚ª?Ü?ü?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?…?F?ü?i•â?•Šˆ?ü?j

                //addsenbun(si.getb(),sj.getb(),sj.getcolor());
                addsenbun(si.getb(), sj.getb(), sj);

                sj.setb(si.geta());
                return 363;
            } else if (i_kousa_hantei == 364) {//?ü•ª(p3,p4)‚É?ü•ª(p2,p1)‚ªŠÜ‚Ü‚ê‚éori_s.addsenbun(s0.geta(),s1.getb(),s1.getcolor());ori_s.setb(i,s0.getb());
                if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {
                    return 0;
                } //‰Á‚¦‚é‚Ù‚¤i‚ª?…?F?ü?i•â?•Šˆ?ü?j?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?Ü?ü
                if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {
                    return 0;
                }//‰Á‚¦‚é‚Ù‚¤i‚ª?Ü?ü?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?…?F?ü?i•â?•Šˆ?ü?j

                //addsenbun(si.geta(),sj.getb(),sj.getcolor());
                addsenbun(si.geta(), sj.getb(), sj);

                sj.setb(si.getb());
                return 364;


            } else if (i_kousa_hantei == 371) {//?ü•ª(p1,p2)‚ÌP2‘¤‚Æ?ü•ª(p3,p4)‚ÌP3‘¤‚ª•”•ª“I‚É?d‚È‚é//ori_s_temp.senbun_bunkatu(s1.geta());ori_s.seta(i,s0.getb());
                if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {
                    return 0;
                } //‰Á‚¦‚é‚Ù‚¤i‚ª?…?F?ü?i•â?•Šˆ?ü?j?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?Ü?ü
                if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {
                    return 0;
                }//‰Á‚¦‚é‚Ù‚¤i‚ª?Ü?ü?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?…?F?ü?i•â?•Šˆ?ü?j

                //addsenbun(p3,p2,si.getcolor());
                addsenbun(p3, p2, si);

                si.setb(p3);
                sj.seta(p2);
                return 371;

            } else if (i_kousa_hantei == 372) {//?ü•ª(p1,p2)‚ÌP2‘¤‚Æ?ü•ª(p4,p3)‚ÌP4‘¤‚ª•”•ª“I‚É?d‚È‚é//ori_s_temp.senbun_bunkatu(s1.getb());ori_s.setb(i,s0.getb());
                if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {
                    return 0;
                } //‰Á‚¦‚é‚Ù‚¤i‚ª?…?F?ü?i•â?•Šˆ?ü?j?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?Ü?ü
                if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {
                    return 0;
                }//‰Á‚¦‚é‚Ù‚¤i‚ª?Ü?ü?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?…?F?ü?i•â?•Šˆ?ü?j

                //addsenbun(p4,p2,si.getcolor());
                addsenbun(p4, p2, si);

                si.setb(p4);
                sj.setb(p2);
                return 372;

            } else if (i_kousa_hantei == 373) {//?ü•ª(p3,p4)‚ÌP4‘¤‚Æ?ü•ª(p1,p2)‚ÌP1‘¤‚ª•”•ª“I‚É?d‚È‚é//ori_s_temp.senbun_bunkatu(s1.getb());ori_s.setb(i,s0.geta());
                if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {
                    return 0;
                } //‰Á‚¦‚é‚Ù‚¤i‚ª?…?F?ü?i•â?•Šˆ?ü?j?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?Ü?ü
                if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {
                    return 0;
                }//‰Á‚¦‚é‚Ù‚¤i‚ª?Ü?ü?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?…?F?ü?i•â?•Šˆ?ü?j

                //addsenbun(p1,p4,si.getcolor());
                addsenbun(p1, p4, si);

                si.seta(p4);
                sj.setb(p1);
                return 373;

            } else if (i_kousa_hantei == 374) {//?ü•ª(p4,p3)‚ÌP3‘¤‚Æ?ü•ª(p1,p2)‚ÌP1‘¤‚ª•”•ª“I‚É?d‚È‚é//ori_s_temp.senbun_bunkatu(s1.geta());ori_s.seta(i,s0.geta());
                if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {
                    return 0;
                } //‰Á‚¦‚é‚Ù‚¤i‚ª?…?F?ü?i•â?•Šˆ?ü?j?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?Ü?ü
                if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {
                    return 0;
                }//‰Á‚¦‚é‚Ù‚¤i‚ª?Ü?ü?AŒ³‚©‚ç‚ ‚é‚Ù‚¤j‚ª?…?F?ü?i•â?•Šˆ?ü?j

                //addsenbun(p1,p3,si.getcolor());
                addsenbun(p1, p3, si);

                si.seta(p3);
                sj.seta(p1);
                return 374;

            }


        }
        return 0;
    }

    //---------------------
    //Œð?·‚µ‚Ä‚¢‚é‚Q‚Â‚Ì?ü•ª‚ÌŒð“_‚Å‚Q‚Â‚Ì?ü•ª‚ð•ªŠ„‚·‚é?B?@‚Ü‚Á‚½‚­?d‚È‚é?ü•ª‚ª‚Q‚Â‚ ‚Á‚½?ê?‡‚Í?A‚È‚ñ‚Ì?ˆ—?‚à‚È‚³‚ê‚È‚¢‚Ü‚Ü‚Q‚Â‚Æ‚àŽc‚é?B
    public void kousabunkatu() {
        int ibunkatu = 1;//•ªŠ„‚ª‚ ‚ê‚Î1?A‚È‚¯‚ê‚Î0
//System.out.println("1234567890   kousabunkatu");
        ArrayList k_flg = new ArrayList();//Œð?·•ªŠ„‚Ì‰e‹¿‚ª‚ ‚é‚±‚Æ‚ðŽ¦‚·ƒtƒ‰ƒbƒO?B

        for (int i = 0; i <= sousuu + 1; i++) {
            k_flg.add(new Integer(1));
        }

        while (ibunkatu != 0) {
            ibunkatu = 0;
            for (int i = 1; i <= sousuu; i++) {
                Integer I_k_flag = (Integer) k_flg.get(i);
                if (I_k_flag.intValue() == 1) {
                    k_flg.set(i, new Integer(0));
                    for (int j = 1; j <= sousuu; j++) {
                        if (i != j) {
                            Integer J_k_flag = (Integer) k_flg.get(j);
                            if (J_k_flag.intValue() == 1) {
                                int itemp = 0;
                                int old_sousuu = sousuu;
                                itemp = kousabunkatu(i, j);
                                if (old_sousuu < sousuu) {
                                    for (int is = old_sousuu + 1; is <= sousuu; is++) {
                                        k_flg.add(new Integer(1));
                                    }
                                }
                                if (itemp == 1) {
                                    ibunkatu = ibunkatu + 1;
                                    k_flg.set(i, new Integer(1));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

//---------------------

    //Œð?·‚µ‚Ä‚¢‚é‚Q‚Â‚Ì?ü•ª‚ÌŒð“_‚Å‚Q‚Â‚Ì?ü•ª‚ð•ªŠ„‚·‚é?B•ªŠ„‚ð?s‚Á‚½‚ç1?B?s‚í‚È‚©‚Á‚½‚ç0‚ð•Ô‚·?BƒIƒŠƒqƒ?2.002‚©‚ç•ªŠ„Œã‚Ì?ü‚Ì?F‚à?§Œä‚·‚é‚æ‚¤‚É‚µ‚½(?d•¡•”‚ª‚ ‚é?ê?‡‚Íˆê–{‰»‚µ?A”Ô?†‚Ì’x‚¢‚Ù‚¤‚Ì?F‚É‚È‚é)?B
    public int kousabunkatu(int i, int j) {
        if (i == j) {
            return 0;
        }

        Senbun si;
        si = sen(i);
        Senbun sj;
        sj = sen(j);

        if (si.get_i_max_x() < sj.get_i_min_x()) {
            return 0;
        }//‚±‚ê‚ÍSenbun‚Éi_max_x‚ª‚¿‚á‚ñ‚Æ’è‹`‚³‚ê‚Ä‚¢‚é‚Æ‚«‚Å‚È‚¢‚Æ‚¤‚Ü‚­‚¢‚©‚È‚¢
        if (sj.get_i_max_x() < si.get_i_min_x()) {
            return 0;
        }//‚±‚ê‚ÍSenbun‚Éi_min_x‚ª‚¿‚á‚ñ‚Æ’è‹`‚³‚ê‚Ä‚¢‚é‚Æ‚«‚Å‚È‚¢‚Æ‚¤‚Ü‚­‚¢‚©‚È‚¢
        if (si.get_i_max_y() < sj.get_i_min_y()) {
            return 0;
        }//‚±‚ê‚ÍSenbun‚Éi_max_y‚ª‚¿‚á‚ñ‚Æ’è‹`‚³‚ê‚Ä‚¢‚é‚Æ‚«‚Å‚È‚¢‚Æ‚¤‚Ü‚­‚¢‚©‚È‚¢
        if (sj.get_i_max_y() < si.get_i_min_y()) {
            return 0;
        }//‚±‚ê‚ÍSenbun‚Éi_min_y‚ª‚¿‚á‚ñ‚Æ’è‹`‚³‚ê‚Ä‚¢‚é‚Æ‚«‚Å‚È‚¢‚Æ‚¤‚Ü‚­‚¢‚©‚È‚¢

        //           System.out.println("kousabunkatu("+i +","+j+")    (" 	+   si.getax() +","+   si.getay()  +")-("+  si.getbx()  +","+  si.getby()  +")---("
        //								+   sj.getax() +","+   sj.getay()  +")-("+  sj.getbx()  +","+  sj.getby()  +")    "    );
        Ten p1 = new Ten();
        p1.set(si.geta());
        Ten p2 = new Ten();
        p2.set(si.getb());
        Ten p3 = new Ten();
        p3.set(sj.geta());
        Ten p4 = new Ten();
        p4.set(sj.getb());
        Ten pk = new Ten();

        double ixmax;
        double ixmin;
        double iymax;
        double iymin;

        ixmax = si.getax();
        ixmin = si.getax();
        iymax = si.getay();
        iymin = si.getay();

        if (ixmax < si.getbx()) {
            ixmax = si.getbx();
        }
        if (ixmin > si.getbx()) {
            ixmin = si.getbx();
        }
        if (iymax < si.getby()) {
            iymax = si.getby();
        }
        if (iymin > si.getby()) {
            iymin = si.getby();
        }

        double jxmax;
        double jxmin;
        double jymax;
        double jymin;

        jxmax = sj.getax();
        jxmin = sj.getax();
        jymax = sj.getay();
        jymin = sj.getay();

        if (jxmax < sj.getbx()) {
            jxmax = sj.getbx();
        }
        if (jxmin > sj.getbx()) {
            jxmin = sj.getbx();
        }
        if (jymax < sj.getby()) {
            jymax = sj.getby();
        }
        if (jymin > sj.getby()) {
            jymin = sj.getby();
        }

        if (ixmax + 0.5 < jxmin) {
            return 0;
        }
        if (jxmax + 0.5 < ixmin) {
            return 0;
        }
        if (iymax + 0.5 < jymin) {
            return 0;
        }
        if (jymax + 0.5 < iymin) {
            return 0;
        }

        //  System.out.println("oc.senbun_kousa_hantei(si,sj)="+ oc.senbun_kousa_hantei(si,sj));


        if (oc.senbun_kousa_hantei(si, sj) == 1) {
            pk.set(oc.kouten_motome(si, sj));    //<<<<<<<<<<<<<<<<<<<<<<<
            si.seta(p1);
            si.setb(pk);
            sj.seta(p3);
            sj.setb(pk);
            addsenbun(p2, pk, si.getcolor());
            addsenbun(p4, pk, sj.getcolor());
            return 1;
        }

        //oc.senbun_kousa_hantei(si,sj)‚ª21‚©‚ç24‚Ü‚Å‚Í‚­‚ÌŽšŒ^‚ÌŒð?·‚Å?A‚È‚É‚à‚µ‚È‚¢?B

//		if(oc.senbun_kousa_hantei_amai(si,sj)==25){
        if (oc.senbun_kousa_hantei(si, sj) == 25) {
            pk.set(oc.kouten_motome(si, sj));    //<<<<<<<<<<<<<<<<<<<<<<<
            sj.seta(p3);
            sj.setb(pk);
            addsenbun(p4, pk, sj.getcolor());
            return 1;
        }

//		if(oc.senbun_kousa_hantei_amai(si,sj)==26){
        if (oc.senbun_kousa_hantei(si, sj) == 26) {
            pk.set(oc.kouten_motome(si, sj));    //<<<<<<<<<<<<<<<<<<<<<<<
            sj.seta(p3);
            sj.setb(pk);
            addsenbun(p4, pk, sj.getcolor());
            return 1;
        }

//		if(oc.senbun_kousa_hantei_amai(si,sj)==27){
        if (oc.senbun_kousa_hantei(si, sj) == 27) {
            pk.set(oc.kouten_motome(si, sj));    //<<<<<<<<<<<<<<<<<<<<<<<
            si.seta(p1);
            si.setb(pk);
            addsenbun(p2, pk, si.getcolor());
            return 1;
        }

//		if(oc.senbun_kousa_hantei_amai(si,sj)==28){
        if (oc.senbun_kousa_hantei(si, sj) == 28) {
            pk.set(oc.kouten_motome(si, sj));    //<<<<<<<<<<<<<<<<<<<<<<<
            si.seta(p1);
            si.setb(pk);
            addsenbun(p2, pk, si.getcolor());
            return 1;
        }

//-----------------

        if (oc.senbun_kousa_hantei(si, sj) == 0) {//‚±‚Ìif‚È‚¢‚Æ–{—ˆ‚±‚ÌŒã‚Å?ˆ—?‚³‚ê‚é‚×‚«?ðŒ?‚ª‚±‚±‚Å?ˆ—?‚³‚ê‚Ä‚µ‚Ü‚¤‚±‚Æ‚ ‚é

//System.out.println("      888888888888888888888888888");

            if (oc.kyori_senbun(si.geta(), sj) < 0.01) {
                if (oc.senbun_busyo_sagasi(si.geta(), sj, 0.01) == 3) { //20161107 ‚í‚¸‚©‚É“Í‚©‚È‚¢?ê?‡
                    pk.set(oc.kouten_motome(si, sj));    //<<<<<<<<<<<<<<<<<<<<<<<
                    sj.seta(p3);
                    sj.setb(pk);
                    addsenbun(p4, pk, sj.getcolor());
                    return 1;
                }
            }

            if (oc.kyori_senbun(si.getb(), sj) < 0.01) {
                if (oc.senbun_busyo_sagasi(si.getb(), sj, 0.01) == 3) { //20161107 ‚í‚¸‚©‚É“Í‚©‚È‚¢?ê?‡
                    pk.set(oc.kouten_motome(si, sj));    //<<<<<<<<<<<<<<<<<<<<<<<
                    sj.seta(p3);
                    sj.setb(pk);
                    addsenbun(p4, pk, sj.getcolor());
                    return 1;
                }
            }

            if (oc.kyori_senbun(sj.geta(), si) < 0.01) {
                if (oc.senbun_busyo_sagasi(sj.geta(), si, 0.01) == 3) { //20161107 ‚í‚¸‚©‚É“Í‚©‚È‚¢?ê?‡
                    pk.set(oc.kouten_motome(si, sj));    //<<<<<<<<<<<<<<<<<<<<<<<
                    si.seta(p1);
                    si.setb(pk);
                    addsenbun(p2, pk, si.getcolor());
                    return 1;
                }
            }

            if (oc.kyori_senbun(sj.getb(), si) < 0.01) {
                if (oc.senbun_busyo_sagasi(sj.getb(), si, 0.01) == 3) { //20161107 ‚í‚¸‚©‚É“Í‚©‚È‚¢?ê?‡
                    pk.set(oc.kouten_motome(si, sj));    //<<<<<<<<<<<<<<<<<<<<<<<
                    si.seta(p1);
                    si.setb(pk);
                    addsenbun(p2, pk, si.getcolor());
                    return 1;
                }
            }

        }


//-----------------

        //
        if (oc.senbun_kousa_hantei(si, sj) == 31) {//2‚Â‚Ì?ü•ª‚ª‚Ü‚Á‚½‚­“¯‚¶?ê?‡‚Í?A‰½‚à‚µ‚È‚¢?B
            return 0;
        }


        if (oc.senbun_kousa_hantei(si, sj) == 321) {//2‚Â‚Ì?ü•ª‚Ì’[“_‚Ç‚¤‚µ(p1‚Æp3)‚ª1“_‚Å?d‚È‚é?Bsi‚Ésj‚ªŠÜ‚Ü‚ê‚é
//System.out.println("                              321");
            si.seta(p2);
            si.setb(p4);

            int jyuufuku_col;
            jyuufuku_col = si.getcolor();
            if (i < j) {
                jyuufuku_col = sj.getcolor();
            }
            sj.setcolor(jyuufuku_col);

            return 1;


        }

        if (oc.senbun_kousa_hantei(si, sj) == 322) {//2‚Â‚Ì?ü•ª‚Ì’[“_‚Ç‚¤‚µ(p1‚Æp3)‚ª1“_‚Å?d‚È‚é?Bsj‚Ési‚ªŠÜ‚Ü‚ê‚é
//System.out.println("                              322");
            sj.seta(p2);
            sj.setb(p4);
            int jyuufuku_col;
            jyuufuku_col = si.getcolor();
            if (i < j) {
                jyuufuku_col = sj.getcolor();
            }
            si.setcolor(jyuufuku_col);

            return 1;
        }

        if (oc.senbun_kousa_hantei(si, sj) == 331) {//2‚Â‚Ì?ü•ª‚Ì’[“_‚Ç‚¤‚µ(p1‚Æp4)‚ª1“_‚Å?d‚È‚é?Bsi‚Ésj‚ªŠÜ‚Ü‚ê‚é
//System.out.println("                              331");
            si.seta(p2);
            si.setb(p3);

            int jyuufuku_col;
            jyuufuku_col = si.getcolor();
            if (i < j) {
                jyuufuku_col = sj.getcolor();
            }
            sj.setcolor(jyuufuku_col);

            return 1;
        }

        if (oc.senbun_kousa_hantei(si, sj) == 332) {//2‚Â‚Ì?ü•ª‚Ì’[“_‚Ç‚¤‚µ(p1‚Æp4)‚ª1“_‚Å?d‚È‚é?Bsj‚Ési‚ªŠÜ‚Ü‚ê‚é
//System.out.println("                              332");
            sj.seta(p2);
            sj.setb(p3);
            int jyuufuku_col;
            jyuufuku_col = si.getcolor();
            if (i < j) {
                jyuufuku_col = sj.getcolor();
            }
            si.setcolor(jyuufuku_col);
            return 1;
        }

        if (oc.senbun_kousa_hantei(si, sj) == 341) {//2‚Â‚Ì?ü•ª‚Ì’[“_‚Ç‚¤‚µ(p2‚Æp3)‚ª1“_‚Å?d‚È‚é?Bsi‚Ésj‚ªŠÜ‚Ü‚ê‚é
//System.out.println("                              341");
            si.seta(p1);
            si.setb(p4);
            int jyuufuku_col;
            jyuufuku_col = si.getcolor();
            if (i < j) {
                jyuufuku_col = sj.getcolor();
            }
            sj.setcolor(jyuufuku_col);

            return 1;
        }

        if (oc.senbun_kousa_hantei(si, sj) == 342) {//2‚Â‚Ì?ü•ª‚Ì’[“_‚Ç‚¤‚µ(p2‚Æp3)‚ª1“_‚Å?d‚È‚é?Bsj‚Ési‚ªŠÜ‚Ü‚ê‚é
//System.out.println("                              342");
            sj.seta(p1);
            sj.setb(p4);
            int jyuufuku_col;
            jyuufuku_col = si.getcolor();
            if (i < j) {
                jyuufuku_col = sj.getcolor();
            }
            si.setcolor(jyuufuku_col);


            return 1;
        }

        if (oc.senbun_kousa_hantei(si, sj) == 351) {//2‚Â‚Ì?ü•ª‚Ì’[“_‚Ç‚¤‚µ(p2‚Æp4)‚ª1“_‚Å?d‚È‚é?Bsi‚Ésj‚ªŠÜ‚Ü‚ê‚é
//System.out.println("                              351");

            si.seta(p1);
            si.setb(p3);

            int jyuufuku_col;
            jyuufuku_col = si.getcolor();
            if (i < j) {
                jyuufuku_col = sj.getcolor();
            }
            sj.setcolor(jyuufuku_col);

            return 1;
        }

        if (oc.senbun_kousa_hantei(si, sj) == 352) {//2‚Â‚Ì?ü•ª‚Ì’[“_‚Ç‚¤‚µ(p2‚Æp4)‚ª1“_‚Å?d‚È‚é?Bsj‚Ési‚ªŠÜ‚Ü‚ê‚é
//System.out.println("                              352");
            sj.seta(p1);
            sj.setb(p3);
            int jyuufuku_col;
            jyuufuku_col = si.getcolor();
            if (i < j) {
                jyuufuku_col = sj.getcolor();
            }
            si.setcolor(jyuufuku_col);

            return 1;
        }


        if (oc.senbun_kousa_hantei(si, sj) == 361) {//p1-p3-p4-p2‚Ì?‡
            si.seta(p1);
            si.setb(p3);

            addsenbun(p2, p4, si.getcolor());
            int jyuufuku_col;
            jyuufuku_col = si.getcolor();
            if (i < j) {
                jyuufuku_col = sj.getcolor();
            }
            sj.setcolor(jyuufuku_col);

            return 1;
        }

        if (oc.senbun_kousa_hantei(si, sj) == 362) {//p1-p4-p3-p2‚Ì?‡
            si.seta(p1);
            si.setb(p4);

            addsenbun(p2, p3, si.getcolor());

            int jyuufuku_col;
            jyuufuku_col = si.getcolor();
            if (i < j) {
                jyuufuku_col = sj.getcolor();
            }
            sj.setcolor(jyuufuku_col);

            return 1;
        }

        if (oc.senbun_kousa_hantei(si, sj) == 363) {//p3-p1-p2-p4‚Ì?‡
            sj.seta(p1);
            sj.setb(p3);

            addsenbun(p2, p4, sj.getcolor());

            int jyuufuku_col;
            jyuufuku_col = si.getcolor();
            if (i < j) {
                jyuufuku_col = sj.getcolor();
            }
            si.setcolor(jyuufuku_col);

            return 1;
        }

        if (oc.senbun_kousa_hantei(si, sj) == 364) {//p3-p2-p1-p4‚Ì?‡
            sj.seta(p1);
            sj.setb(p4);

            addsenbun(p2, p3, sj.getcolor());

            int jyuufuku_col;
            jyuufuku_col = si.getcolor();
            if (i < j) {
                jyuufuku_col = sj.getcolor();
            }
            si.setcolor(jyuufuku_col);

            return 1;
        }

        //
        if (oc.senbun_kousa_hantei(si, sj) == 371) {//p1-p3-p2-p4‚Ì?‡
            //System.out.println("371");
            si.seta(p1);
            si.setb(p3);

            sj.seta(p2);
            sj.setb(p4);

            int jyuufuku_col;
            jyuufuku_col = si.getcolor();
            if (i < j) {
                jyuufuku_col = sj.getcolor();
            }
            addsenbun(p2, p3, jyuufuku_col);
            return 1;
        }

        if (oc.senbun_kousa_hantei(si, sj) == 372) {//p1-p4-p2-p3‚Ì?‡
            //System.out.println("372");
            si.seta(p1);
            si.setb(p4);

            sj.seta(p3);
            sj.setb(p2);

            int jyuufuku_col;
            jyuufuku_col = si.getcolor();
            if (i < j) {
                jyuufuku_col = sj.getcolor();
            }
            addsenbun(p2, p4, jyuufuku_col);
            return 1;
        }

        if (oc.senbun_kousa_hantei(si, sj) == 373) {//p3-p1-p4-p2‚Ì?‡
            //System.out.println("373");
            sj.seta(p1);
            sj.setb(p3);
            si.seta(p2);
            si.setb(p4);
            int jyuufuku_col;
            jyuufuku_col = si.getcolor();
            if (i < j) {
                jyuufuku_col = sj.getcolor();
            }
            addsenbun(p1, p4, jyuufuku_col);
            return 1;
        }

        if (oc.senbun_kousa_hantei(si, sj) == 374) {//p4-p1-p3-p2‚Ì?‡
            //System.out.println("374");
            sj.seta(p1);
            sj.setb(p4);
            si.seta(p3);
            si.setb(p2);
            int jyuufuku_col;
            jyuufuku_col = si.getcolor();
            if (i < j) {
                jyuufuku_col = sj.getcolor();
            }
            addsenbun(p1, p3, jyuufuku_col);
            return 1;
        }

        return 0;
    }


    //‰~‚Ì’Ç‰Á-------------------------------


    public void add_en(double dx, double dy, double dr, int ic) {
        Cir.add(new En(dx, dy, dr, ic));

        //Senbun s;s= sen(sousuu);
        //s.set(pi,pj,i_c);
    }

    public void add_en(Ten t, double dr) {
        add_en(t.getx(), t.gety(), dr, 0);
    }


    //‰~‚Æ‰~‚ÌŒð“_‚É”¼Œa0‚Ì‰~‚ð”­?¶-------------------------------
    public void en_en_kouten(int imin, int imax, int jmin, int jmax) {
        for (int i = imin; i <= imax; i++) {
            En ei = new En();
            ei.set(cir_getEn(i));
            if (ei.getr() > 0.0000001) {//”¼Œa0‚Ì‰~‚Í‘Î?ÛŠO
                for (int j = jmin; j <= jmax; j++) {

                    En ej = new En();
                    ej.set(cir_getEn(j));
                    if (ej.getr() > 0.0000001) {//”¼Œa0‚Ì‰~‚Í‘Î?ÛŠO
                        if (oc.kyori(ei.get_tyuusin(), ej.get_tyuusin()) < 0.000001) {//2‚Â‚Ì‰~‚Í“¯?S‰~‚ÅŒð?·‚µ‚È‚¢
                        } else if (Math.abs(oc.kyori(ei.get_tyuusin(), ej.get_tyuusin()) - ei.getr() - ej.getr()) < 0.0001) {//2‚Â‚Ì‰~‚Í1“_‚ÅŒð?·
                            add_en(oc.naibun(ei.get_tyuusin(), ej.get_tyuusin(), ei.getr(), ej.getr()), 0.0);
                        } else if (oc.kyori(ei.get_tyuusin(), ej.get_tyuusin()) > ei.getr() + ej.getr()) {//2‚Â‚Ì‰~‚ÍŒð?·‚µ‚È‚¢

                        } else if (Math.abs(oc.kyori(ei.get_tyuusin(), ej.get_tyuusin()) - Math.abs(ei.getr() - ej.getr())) < 0.0001) {//2‚Â‚Ì‰~‚Í1“_‚ÅŒð?·
                            add_en(oc.naibun(ei.get_tyuusin(), ej.get_tyuusin(), -ei.getr(), ej.getr()), 0.0);
                        } else if (oc.kyori(ei.get_tyuusin(), ej.get_tyuusin()) < Math.abs(ei.getr() - ej.getr())) {//2‚Â‚Ì‰~‚ÍŒð?·‚µ‚È‚¢

                        } else {//2‚Â‚Ì‰~‚Í2“_‚ÅŒð?·
                            Senbun k_senb = new Senbun();
                            k_senb.set(oc.en_to_en_no_kouten_wo_musubu_senbun(ei, ej));

                            add_en(k_senb.geta(), 0.0);
                            add_en(k_senb.getb(), 0.0);
                        }
                    }
                }
            }
        }
    }


    //‰~‚Æ?Ü?ü‚ÌŒð“_‚É”¼Œa0‚Ì‰~‚ð”­?¶-------------------------------
    public void Senbun_en_kouten(int imin, int imax, int jmin, int jmax) {
        for (int i = imin; i <= imax; i++) {
            Senbun si;
            si = sen(i);

            Tyokusen ti = new Tyokusen();
            ti.set(oc.Senbun2Tyokusen(si));
            //if(ei.getr()>0.0000001){//”¼Œa0‚Ì‰~‚Í‘Î?ÛŠO
            for (int j = jmin; j <= jmax; j++) {

                En ej = new En();
                ej.set(cir_getEn(j));
                if (ej.getr() > 0.0000001) {//”¼Œa0‚Ì‰~‚Í‘Î?ÛŠO
                    double tc_kyori = ti.kyorikeisan(ej.get_tyuusin()); //’¼?ü‚Æ‰~‚Ì’†?S‚Ì‹——£


                    if (Math.abs(tc_kyori - ej.getr()) < 0.000001) {//‰~‚Æ’¼?ü‚Í1“_‚ÅŒð?·
                        if (
                                Math.abs(
                                        oc.kyori_senbun(ej.get_tyuusin(), si) - ej.getr()
                                ) < 0.000001
                        ) {
                            add_en(oc.kage_motome(ti, ej.get_tyuusin()), 0.0);
                        }
                    } else if (tc_kyori > ej.getr()) {//‰~‚Æ’¼?ü‚ÍŒð?·‚µ‚È‚¢
                    } else {//‰~‚Æ’¼?ü‚Í2“_‚ÅŒð?·
                        Senbun k_senb = new Senbun();
                        k_senb.set(oc.en_to_tyokusen_no_kouten_wo_musubu_senbun(ej, ti));

                        if (oc.kyori_senbun(k_senb.geta(), si) < 0.00001) {
                            add_en(k_senb.geta(), 0.0);
                        }
                        if (oc.kyori_senbun(k_senb.getb(), si) < 0.00001) {
                            add_en(k_senb.getb(), 0.0);
                        }
                    }

                }
            }
            //}
        }
    }


    //‰~‚Ì?í?œ-----------------------------------------
    public void delen(int j) {   //j”Ô–Ú‚Ì‰~‚ð?í?œ‚·‚é
        Cir.remove(j);
    }

    //‰~‚Ì?®—?-----------------------------------------
    public int en_seiri(int i0) {//j”Ô–Ú‚Ì‰~‚ð?®—?‚·‚é?B?®—?‚Å?í?œ‚µ‚½‚ç1 ?A?í?œ‚µ‚È‚¢‚È‚ç0‚ð•Ô‚·?B
        int ies3 = en_jyoutai(i0, 3);
        int ies4 = en_jyoutai(i0, 4);
        int ies5 = en_jyoutai(i0, 5);

        if (ies3 == 100000) {
            return 0;
        }
        if (ies3 == 2) {
            return 0;
        }
        if ((ies3 == 1) && (ies4 >= 1)) {
            return 0;
        }
        if ((ies3 == 1) && (ies5 >= 1)) {
            return 0;
        }

        Cir.remove(i0);
        return 1;

    }

    //‰~‚Ì?®—?-----------------------------------------
    public void en_seiri() {//‘S‚Ä‚Ì‰~‚ð‘Î?Û‚É?®—?‚ð‚·‚é?B
        for (int i = cir_size(); i >= 1; i--) {
            en_seiri(i);
        }
    }


    //‰~‚Ì?ó‘Ô•\Ž¦-----------------------------------------
    public int en_jyoutai(int i0, int i_mode) {   //i”Ô–Ú‚Ì‰~‚Ì?ó‘Ô‚ðŽ¦‚·?B
        //=100000?@i”Ô–Ú‚Ì‰~‚Ì”¼Œa‚ª0‚Å‚È‚¢
        //=     0?@i”Ô–Ú‚Ì‰~‚Ì”¼Œa‚ª0?B‘¼‚Ì‰~‚Ì‰~Žü‚Æ—£‚ê‚Ä‚¢‚é?B‘¼‚Ì‰~‚Ì’†?S‚Æ—£‚ê‚Ä‚¢‚é?B?@
        //=     1?@1Œ…–Ú‚Ì?”Žš?Bi”Ô–Ú‚Ì‰~‚Ì”¼Œa‚ª0‚Å?A‘¼‚Ì”¼Œa‚ª0‚Ì‰~‚Ì’†?S‚Æ?d‚È‚Á‚Ä‚¢‚é?”?B2ŒÂˆÈ?ã‚Æ?d‚È‚Á‚Ä‚¢‚é‚Æ‚«‚Í2‚Æ•\Ž¦‚³‚ê‚é?B
        //=    10?@2Œ…–Ú‚Ì?”Žš?Bi”Ô–Ú‚Ì‰~‚Ì”¼Œa‚ª0‚Å?A‘¼‚Ì”¼Œa‚ª0‚Å‚È‚¢‰~‚Ì’†?S‚Æ?d‚È‚Á‚Ä‚¢‚é?”?B2ŒÂˆÈ?ã‚Æ?d‚È‚Á‚Ä‚¢‚é‚Æ‚«‚Í2‚Æ•\Ž¦‚³‚ê‚é?B
        //=   100?@3Œ…–Ú‚Ì?”Žš?Bi”Ô–Ú‚Ì‰~‚Ì”¼Œa‚ª0‚Å?A‘¼‚Ì”¼Œa‚ª0‚Å‚È‚¢‰~‚Ì‰~Žü‚Æ?d‚È‚Á‚Ä‚¢‚é?”?B2ŒÂˆÈ?ã‚Æ?d‚È‚Á‚Ä‚¢‚é‚Æ‚«‚Í2‚Æ•\Ž¦‚³‚ê‚é?B
        //=  1000?@4Œ…–Ú‚Ì?”Žš?Bi”Ô–Ú‚Ì‰~‚Ì”¼Œa‚ª0‚Å?A‘¼‚Ì?Ü?ü‚Æ?d‚È‚Á‚Ä‚¢‚é?”?B2ŒÂˆÈ?ã‚Æ?d‚È‚Á‚Ä‚¢‚é‚Æ‚«‚Í2‚Æ•\Ž¦‚³‚ê‚é?B
        //= 10000?@5Œ…–Ú‚Ì?”Žš?Bi”Ô–Ú‚Ì‰~‚Ì”¼Œa‚ª0‚Å?A‘¼‚Ì•â?•Šˆ?ü‚Æ?d‚È‚Á‚Ä‚¢‚é?”?B2ŒÂˆÈ?ã‚Æ?d‚È‚Á‚Ä‚¢‚é‚Æ‚«‚Í2‚Æ•\Ž¦‚³‚ê‚é?B
        En e_temp = new En();
        e_temp.set(cir_getEn(i0));
        double er_0 = e_temp.getr();
        Ten ec_0 = new Ten();
        ec_0.set(e_temp.get_tyuusin());

        double er_1;
        Ten ec_1 = new Ten();

        int ir1 = 0;
        int ir2 = 0;
        int ir3 = 0;
        int ir4 = 0;
        int ir5 = 0;


        if (er_0 < 0.0000001) {
            for (int i = 1; i <= cir_size(); i++) {
                if (i != i0) {
                    e_temp.set(cir_getEn(i));
                    er_1 = e_temp.getr();
                    ec_1.set(e_temp.get_tyuusin());
                    if (er_1 < 0.0000001) {//‘¼‚Ì‰~‚Ì”¼Œa‚ª0
                        if (ec_0.kyori(ec_1) < 0.0000001) {
                            ir1 = ir1 + 1;
                        }
                    } else {//‘¼‚Ì‰~‚Ì”¼Œa‚ª0‚Å‚È‚¢
                        if (ec_0.kyori(ec_1) < 0.0000001) {
                            ir2 = ir2 + 1;
                        } else if (Math.abs(ec_0.kyori(ec_1) - er_1) < 0.0000001) {
                            ir3 = ir3 + 1;
                        }
                    }
                }
            }

            for (int i = 1; i <= sousuu; i++) {
                Senbun si;
                si = sen(i);
                if (oc.kyori_senbun(ec_0, si) < 0.000001) {

                    if (si.getcolor() <= 2) {
                        ir4 = ir4 + 1;
                    } else if (si.getcolor() == 3) {
                        ir5 = ir5 + 1;
                    }

                }
            }


            if (ir1 > 2) {
                ir1 = 2;
            }
            if (ir2 > 2) {
                ir2 = 2;
            }
            if (ir3 > 2) {
                ir3 = 2;
            }
            if (ir4 > 2) {
                ir4 = 2;
            }
            if (ir5 > 2) {
                ir5 = 2;
            }


            if (i_mode == 0) {
                return ir1 + ir2 * 10 + ir3 * 100 + ir4 * 1000 + ir5 * 10000;
            }
            if (i_mode == 1) {
                return ir1;
            }
            if (i_mode == 2) {
                return ir2;
            }
            if (i_mode == 3) {
                return ir3;
            }
            if (i_mode == 4) {
                return ir4;
            }
            if (i_mode == 5) {
                return ir5;
            }

        }

        return 100000;
    }


    //?ü•ª‚Ì’Ç‰Á-------------------------------
    public void addsenbun(Ten pi, Ten pj, int i_c) {
        sousuu++;

        Senbun s;
        s = sen(sousuu);
        s.set(pi, pj, i_c);
    }

    //?ü•ª‚Ì’Ç‰Á-------------------------------wwwwwwwwww
    public void addsenbun(Ten pi, Ten pj, Senbun s0) {//Ten pi‚©‚çTen pj‚Ü‚Å‚Ì?ü•ª‚ð’Ç‰Á?B‚±‚Ì’Ç‰Á‚·‚é?ü•ª‚Ì‚»‚Ì‘¼‚Ìƒpƒ‰ƒ??[ƒ^‚Ís0‚Æ“¯‚¶
        sousuu++;

        Senbun s;
        s = sen(sousuu);
        //s.set(pi,pj,s0.getcolor());
        s.set(s0);
        s.set(pi, pj);

    }

    //?ü•ª‚Ì’Ç‰Á-------------------------------
    public void addsenbun(Ten pi, Ten pj, int i_c, int i_a) {
        sousuu++;

        Senbun s;
        s = sen(sousuu);
        s.set(pi, pj, i_c, i_a);
    }

    //?ü•ª‚Ì’Ç‰Á-------------------------------
    public void addsenbun(double ax, double ay, double bx, double by, int ic) {
        sousuu++;

        Senbun s;
        s = sen(sousuu);
        s.set(ax, ay, bx, by, ic);
    }

    //?ü•ª‚Ì’Ç‰Á-------------------------------
    public void addsenbun(Ten pi, Ten pj) {
        sousuu++;

        Senbun s;
        s = sen(sousuu);

        s.seta(pi);
        s.setb(pj);
    }

    //?ü•ª‚Ì’Ç‰Á-------------------------------
    public void addsenbun(Senbun s0) {
        //addsenbun(s0.geta(),s0.getb(),s0.getcolor());//20181110ƒRƒ?ƒ“ƒgƒAƒEƒg
        addsenbun(s0.geta(), s0.getb(), s0.getcolor(), s0.getiactive());//20181110’Ç‰Á
    }

    //?ü•ª‚Ì?í?œ-----------------------------------------
    public void delsenbun(int j) {   //j”Ô–Ú‚Ì?ü•ª‚ð?í?œ‚·‚é  ‚±‚Ìsi= sen(i)‚Í‘å?ä•v‚È‚Ì‚¾‚ë‚¤‚©????????si= sen(i)?@20161106
        for (int i = j; i <= sousuu - 1; i++) {
            Senbun si;
            si = sen(i);
            Senbun si1;
            si1 = sen(i + 1);
            si.set(si1);

        }
        sousuu--;
    }


    //?ü•ª‚Ì•ªŠ„-----------------qqqqq------------------------
    public void senbun_bunkatu(int i, Ten p) {   //i”Ô–Ú‚Ì?ü•ª(’[“_a‚Æb)‚ð“_p‚Å•ªŠ„‚·‚é?Bi”Ô–Ú‚Ì?ü•ªab‚ðap‚É•Ï‚¦?A?ü•ªpb‚ð‰Á‚¦‚é?B

        Senbun s1 = new Senbun(p, getb(i));//i”Ô–Ú‚Ì?ü•ªab‚ðap‚É•Ï‚¦‚é‘O‚É?ì‚Á‚Ä‚¨‚­
        int i_c;
        i_c = getcolor(i);

        setb(i, p);//i”Ô–Ú‚Ì?ü•ªab‚ðap‚É•Ï‚¦‚é

        addsenbun(s1);
        setcolor(getsousuu(), i_c);
    }

/*
	public void senbun_binkatu(int i,Ten p){   //p‚Æi”Ô–Ú‚Ì?ü•ª‚Ì’[“_a‚Æ‚Ì?ü•ª‚ð‰Á‚¦?Ap‚Æi”Ô–Ú‚Ì?ü•ª‚Ì’[“_b‚Æ‚Ì?ü•ª‚ð‰Á‚¦?Ai”Ô–Ú‚Ì?ü•ª‚ð?í?œ‚·‚é
		int i_c;i_c=getcolor(i);
		Senbun s1 =new Senbun(geta(i),p);
		Senbun s2 =new Senbun(getb(i),p);
		delsenbun(i);
		addsenbun(s1);setcolor(getsousuu(),i_c);
		addsenbun(s2);setcolor(getsousuu(),i_c);
	}
*/

    //i”Ô–Ú‚Ì?ü•ª‚Ì’·‚³‚ð“¾‚é---------------------------
    public double getnagasa(int i) {
        Senbun s;
        s = sen(i);
        return s.getnagasa();
    }

    //•Â‘½ŠpŒ`‚ðŒ`?¬‚¹‚¸?AŽ}?ó‚É‚È‚Á‚Ä‚¢‚é?ü•ª‚ð?í?œ‚·‚é?B
    public void eda_kesi(double r) {
        int iflga = 0;
        int iflgb = 0;
        for (int i = 1; i <= sousuu; i++) {
            iflga = 0;
            iflgb = 0;
            Senbun si;
            si = sen(i);
            for (int j = 1; j <= sousuu; j++) {
                if (i != j) {
                    Senbun sj;
                    sj = sen(j);
                    if (oc.kyori(si.geta(), sj.geta()) < r) {
                        iflga = 1;
                    }
                    if (oc.kyori(si.geta(), sj.getb()) < r) {
                        iflga = 1;
                    }
                    if (oc.kyori(si.getb(), sj.geta()) < r) {
                        iflgb = 1;
                    }
                    if (oc.kyori(si.getb(), sj.getb()) < r) {
                        iflgb = 1;
                    }
                }
            }

            if ((iflga == 0) || (iflgb == 0)) {
                delsenbun_vertex(i);
                i = 1;
            }
        }
    }

    //-----------------------------------------------
    public void delsenbun_vertex(int i) {//i”Ô–Ú‚Ì?Ü?ü‚ð?Á‚·‚Æ‚«?A‚»‚Ì?Ü?ü‚Ì’[“_‚à?Á‚¹‚é?ê?‡‚Í?Á‚·
        Ten pa = new Ten();
        pa.set(geta(i));
        Ten pb = new Ten();
        pb.set(getb(i));
        delsenbun(i);

        del_V(pa, 0.000001, 0.000001);
        del_V(pb, 0.000001, 0.000001);
    }

//----------------------------------------------------


    //ˆê–{‚¾‚¯‚Ì—£‚ê‚Ä‚ ‚é?ü•ª‚ð?í?œ‚·‚é?B
    public void tanSenbun_sakujyo(double r) {
        int iflg = 0;
        for (int i = 1; i <= sousuu; i++) {
            iflg = 0;
            Senbun si;
            si = sen(i);
            for (int j = 1; j <= sousuu; j++) {
                if (i != j) {
                    Senbun sj;
                    sj = sen(j);
                    if (oc.kyori(si.geta(), sj.geta()) < r) {
                        iflg = 1;
                    }
                    if (oc.kyori(si.getb(), sj.getb()) < r) {
                        iflg = 1;
                    }
                    if (oc.kyori(si.geta(), sj.getb()) < r) {
                        iflg = 1;
                    }
                    if (oc.kyori(si.getb(), sj.geta()) < r) {
                        iflg = 1;
                    }
                }
            }

            if (iflg == 0) {
                delsenbun(i);
                i = 1;
            }
        }
    }


    //“_p‚É‹ß‚¢(rˆÈ“à)?ü•ª‚ð‚³‚ª‚µ?A‚»‚Ì”Ô?†‚ð•Ô‚·ŠÖ?”(‚½‚¾‚µ?Aj”Ô–Ú‚Ì?ü•ª‚Í‘Î?ÛŠO)?B‹ß‚¢?ü•ª‚ª‚È‚¯‚ê‚Î?A0‚ð•Ô‚·---------------------------------
    //‚à‚µ‘Î?ÛŠO‚É‚·‚é?ü•ª‚ª–³‚¢?ê?‡‚Í?Aj‚ð0‚Æ‚©•‰‚Ì?®?”‚Æ‚©‚É‚·‚é?B
    //070317?@’Ç‰Á‹@”\?@j?@‚ª?@-10?@‚ÌŽž‚Í?@Šˆ?«‰»‚µ‚Ä‚¢‚È‚¢Ž}?igetiactive(i)‚ª0?j‚ð‘Î?Û‚É‚·‚é?B

    public int senbun_sagasi(Ten p, double r, int j) {
        if (j == -10) {
            for (int i = 1; i <= sousuu; i++) {
                if (((senbun_busyo_sagasi(i, p, r) == 1) && (i != j)) && (getiactive(i) == 0)) {
                    return i;
                }
            }
            for (int i = 1; i <= sousuu; i++) {
                if (((senbun_busyo_sagasi(i, p, r) == 2) && (i != j)) && (getiactive(i) == 0)) {
                    return i;
                }
            }
            for (int i = 1; i <= sousuu; i++) {
                if (((senbun_busyo_sagasi(i, p, r) == 3) && (i != j)) && (getiactive(i) == 0)) {
                    return i;
                }
            }
            return 0;
        }

        for (int i = 1; i <= sousuu; i++) {
            if ((senbun_busyo_sagasi(i, p, r) == 1) && (i != j)) {
                return i;
            }
        }
        for (int i = 1; i <= sousuu; i++) {
            if ((senbun_busyo_sagasi(i, p, r) == 2) && (i != j)) {
                return i;
            }
        }
        for (int i = 1; i <= sousuu; i++) {
            if ((senbun_busyo_sagasi(i, p, r) == 3) && (i != j)) {
                return i;
            }
        }
        return 0;
    }

    //“_p‚ªŽw’è‚³‚ê‚½?ü•ª‚Æ‚Ç‚Ì•”?Š‚Å‹ß‚¢(rˆÈ“à)‚©‚Ç‚¤‚©‚ð”»’è‚·‚éŠÖ?”?@---------------------------------
    //0=‹ß‚­‚È‚¢?A1=a“_‚É‹ß‚¢?A2=b“_‚É‹ß‚¢?A3=•¿‚Ì•”•ª‚É‹ß‚¢
    public int senbun_busyo_sagasi(int i, Ten p, double r) {
        if (r > oc.kyori(p, geta(i))) {
            return 1;
        }//a“_‚É‹ß‚¢‚©‚Ç‚¤‚©
        if (r > oc.kyori(p, getb(i))) {
            return 2;
        }//b“_‚É‹ß‚¢‚©‚Ç‚¤‚©
        if (r > oc.kyori_senbun(p, get(i))) {
            return 3;
        }//•¿‚Ì•”•ª‚É‹ß‚¢‚©‚Ç‚¤‚©
        return 0;
    }


    //“_p‚É?Å‚à‹ß‚¢‰~?i‰~Žü‚Æ’†?S‚Ì—¼•û‚ð?l—¶‚·‚é?j‚Ì”Ô?†‚ð•Ô‚·
    public int mottomo_tikai_en_sagasi(Ten p) {


        int minrid = 0;
        double minr = 100000;
        double rtemp;
        Ten p_temp = new Ten();
        for (int i = 1; i <= cir_size(); i++) {
            En e_temp = new En();
            e_temp.set(cir_getEn(i));


            rtemp = p.kyori(e_temp.get_tyuusin());
            if (minr > rtemp) {
                minr = rtemp;
                minrid = i;
            }

            rtemp = Math.abs(p.kyori(e_temp.get_tyuusin()) - e_temp.getr());
            if (minr > rtemp) {
                minr = rtemp;
                minrid = i;
            }

        }

        return minrid;

    }


    //“_p‚É?Å‚à‹ß‚¢‰~‚Ì”Ô?†‚ð‹t?‡‚Å?i”Ô?†‚Ì‘å‚«‚¢‚Ù‚¤‚ª—D?æ‚Æ‚¢‚¤ˆÓ–¡?j’T‚µ‚Ä•Ô‚·
    public int mottomo_tikai_en_sagasi_gyakujyun(Ten p) {
        int minrid = 0;
        double minr = 100000;
        double rtemp;
        Ten p_temp = new Ten();
        for (int i = 1; i <= cir_size(); i++) {
            En e_temp = new En();
            e_temp.set(cir_getEn(i));


            rtemp = p.kyori(e_temp.get_tyuusin());
            if (minr >= rtemp) {
                minr = rtemp;
                minrid = i;
            }

            rtemp = Math.abs(p.kyori(e_temp.get_tyuusin()) - e_temp.getr());
            if (minr >= rtemp) {
                minr = rtemp;
                minrid = i;
            }

        }

        return minrid;

    }


    //“_p‚É?Å‚à‹ß‚¢‰~‚Ì”Ô?†‚Å‚Ì?A‚»‚Ì‹——£‚ð•Ô‚·
    public double mottomo_tikai_en_kyori(Ten p) {
        int minrid = 0;
        double minr = 100000;
        double rtemp;
        Ten p_temp = new Ten();
        for (int i = 1; i <= cir_size(); i++) {
            En e_temp = new En();
            e_temp.set(cir_getEn(i));


            rtemp = p.kyori(e_temp.get_tyuusin());
            if (minr > rtemp) {
                minr = rtemp;
                minrid = i;
            }

            rtemp = Math.abs(p.kyori(e_temp.get_tyuusin()) - e_temp.getr());
            if (minr > rtemp) {
                minr = rtemp;
                minrid = i;
            }

        }

        return minr;
    }


    //“_p‚É?Å‚à‹ß‚¢?ü•ª‚Ì”Ô?†‚ð•Ô‚·
    public int mottomo_tikai_senbun_sagasi(Ten p) {
        int minrid = 0;
        double minr = 100000;
        for (int i = 1; i <= sousuu; i++) {
            double sk = oc.kyori_senbun(p, get(i));
            if (minr > sk) {
                minr = sk;
                minrid = i;
            }//•¿‚Ì•”•ª‚É‹ß‚¢‚©‚Ç‚¤‚©

        }
        return minrid;
    }


    //“_p‚É?Å‚à‹ß‚¢?ü•ª‚Ì”Ô?†‚ð‹t‚©‚ç?i”Ô?†‚Ì‘å‚«‚¢‚Ù‚¤‚©‚ç?¬‚³‚¢‚Ù‚¤‚Ö‚Æ‚¢‚¤ˆÓ–¡?j’T‚µ‚Ä•Ô‚·
    public int mottomo_tikai_senbun_sagasi_gyakujyun(Ten p) {
        int minrid = 0;
        double minr = 100000;
        for (int i = sousuu; i >= 1; i--) {
            double sk = oc.kyori_senbun(p, get(i));
            if (minr > sk) {
                minr = sk;
                minrid = i;
            }//•¿‚Ì•”•ª‚É‹ß‚¢‚©‚Ç‚¤‚©

        }
        return minrid;
    }


    //“_p‚É?Å‚à‹ß‚¢?ü•ª‚Ì”Ô?†‚Å‚Ì?A‚»‚Ì‹——£‚ð•Ô‚·
    public double mottomo_tikai_senbun_kyori(Ten p) {
        int minrid = 0;
        double minr = 100000.0;
        for (int i = 1; i <= sousuu; i++) {
            double sk = oc.kyori_senbun(p, get(i));
            if (minr > sk) {
                minr = sk;
                minrid = i;
            }//•¿‚Ì•”•ª‚É‹ß‚¢‚©‚Ç‚¤‚©

        }
        return minr;
    }


    //“_p‚É?Å‚à‹ß‚¢?ü•ª‚Ì”Ô?†‚Å‚Ì?A‚»‚Ì‹——£‚ð•Ô‚·?B‚½‚¾‚µ?ü•ªs0‚Æ•½?s‚È?Ü?ü‚ª’²?¸‚Ì‘Î?ÛŠO?B‚Â‚Ü‚è?A•½?s‚È?Ü?ü‚ª?d‚È‚Á‚Ä‚¢‚Ä‚à‹ß‚¢‹——£‚É‚ ‚é‚Æ‚Í‚Ý‚È‚³‚ê‚È‚¢?B
    public double mottomo_tikai_senbun_kyori_heikou_jyogai(Ten p, Senbun s0) {
        double minr = 100000.0;
        for (int i = 1; i <= sousuu; i++) {
            if (oc.heikou_hantei(get(i), s0, 0.0001) == 0) {

                double sk = oc.kyori_senbun(p, get(i));
                if (minr > sk) {
                    minr = sk;
                }
            }
        }
        return minr;
    }


    public En mottomo_tikai_ensyuu(Ten p) {
        int minrid = 0;
        double minr = 100000.0;
        En e1 = new En(100000.0, 100000.0, 1.0, 0);
        for (int i = 1; i <= cir_size(); i++) {
            double ek = oc.kyori_ensyuu(p, cir_getEn(i));
            if (minr > ek) {
                minr = ek;
                minrid = i;
            }//‰~Žü‚Ì•”•ª‚É‹ß‚¢‚©‚Ç‚¤‚©
        }

        if (minrid == 0) {
            return e1;
        }

        return cir_getEn(minrid);
    }


    public Senbun mottomo_tikai_Senbun(Ten p) {
        int minrid = 0;
        double minr = 100000.0;
        Senbun s1 = new Senbun(100000.0, 100000.0, 100000.0, 100000.1);
        for (int i = 1; i <= sousuu; i++) {
            double sk = oc.kyori_senbun(p, get(i));
            if (minr > sk) {
                minr = sk;
                minrid = i;
            }//•¿‚Ì•”•ª‚É‹ß‚¢‚©‚Ç‚¤‚©

        }

        if (minrid == 0) {
            return s1;
        }

        return get(minrid);
    }


    //“_p‚É?Å‚à‹ß‚¢?A?u?ü•ª‚Ì’[“_?v‚ð•Ô‚·
    //public Ten mottomo_tikai_Ten_sagasi(Ten p) {
    public Ten mottomo_tikai_Ten(Ten p) {
        Ten p_return = new Ten();
        p_return.set(100000.0, 100000.0);
        Ten p_temp = new Ten();
        for (int i = 1; i <= sousuu; i++) {
            //p_temp.set(geta(i));if(p.kyori(p_temp)<p.kyori(p_return) ) {p_return.set(p_temp.etx(),p_temp.gety()); }
            //p_temp.set(getb(i));if(p.kyori(p_temp)<p.kyori(p_return) ) {p_return.set(p_temp.getx(),p_temp.gety()); }
            p_temp.set(geta(i));
            if (p.kyori2jyou(p_temp) < p.kyori2jyou(p_return)) {
                p_return.set(p_temp.getx(), p_temp.gety());
            }
            p_temp.set(getb(i));
            if (p.kyori2jyou(p_temp) < p.kyori2jyou(p_return)) {
                p_return.set(p_temp.getx(), p_temp.gety());
            }

        }
        return p_return;
    }

    //“_p‚É?Å‚à‹ß‚¢?A?u‰~‚Ì’†?S“_?v‚ð•Ô‚·
    //public Ten mottomo_tikai_Tyuusin(Ten p) {   //qqqqqqqqqqqq
    public Ten mottomo_tikai_Tyuusin(Ten p) {
        Ten p_return = new Ten();
        p_return.set(100000.0, 100000.0);
        Ten p_temp = new Ten();
        for (int i = 1; i <= cir_size(); i++) {
            En e_temp = new En();
            e_temp.set(cir_getEn(i));
            p_temp.set(e_temp.get_tyuusin());
            if (p.kyori2jyou(p_temp) < p.kyori2jyou(p_return)) {
                p_return.set(p_temp.getx(), p_temp.gety());
            }
        }
        return p_return;
    }

    //“_p‚É?Å‚à‹ß‚¢?A?u?ü•ª‚Ì’[“_?v‚ð•Ô‚·?B‚½‚¾‚µ?A•â?•Šˆ?ü‚Í‘Î?ÛŠO
    public Ten mottomo_tikai_Ten_with_icol_0_1_2(Ten p) {
        Ten p_return = new Ten();
        p_return.set(100000.0, 100000.0);
        Ten p_temp = new Ten();
        for (int i = 1; i <= sousuu; i++) {
            if ((0 <= getcolor(i)) && (getcolor(i) <= 2)) {
                p_temp.set(geta(i));
                if (p.kyori2jyou(p_temp) < p.kyori2jyou(p_return)) {
                    p_return.set(p_temp.getx(), p_temp.gety());
                }
                p_temp.set(getb(i));
                if (p.kyori2jyou(p_temp) < p.kyori2jyou(p_return)) {
                    p_return.set(p_temp.getx(), p_temp.gety());
                }

            }
        }
        return p_return;
    }

    // ---------------------------
    public void del_V(int i, int j) {//2–{‚Ì?Ü?ü‚ª“¯‚¶?F‚Å?A‘¼‚Ì?Ü?ü‚Ì’[“_‚ª‚È‚¢?ê?‡‚É“_?Á‚µ‚ð‚·‚é
        //if(getcolor(i)!=getcolor(j)){return;}//2–{‚ª“¯‚¶?F‚Å‚È‚¢‚È‚çŽÀŽ{‚¹‚¸

        int i_senbun_kousa_hantei;
        i_senbun_kousa_hantei = oc.senbun_kousa_hantei(get(i), get(j), 0.00001, 0.00001);

        Senbun addsen = new Senbun();
        int i_ten = 0;
        if (i_senbun_kousa_hantei == 323) {
            addsen.set(getb(i), getb(j));
            i_ten = tyouten_syuui_sensuu(geta(i), 0.00001);
        }
        if (i_senbun_kousa_hantei == 333) {
            addsen.set(getb(i), geta(j));
            i_ten = tyouten_syuui_sensuu(geta(i), 0.00001);
        }
        if (i_senbun_kousa_hantei == 343) {
            addsen.set(geta(i), getb(j));
            i_ten = tyouten_syuui_sensuu(getb(i), 0.00001);
        }
        if (i_senbun_kousa_hantei == 353) {
            addsen.set(geta(i), geta(j));
            i_ten = tyouten_syuui_sensuu(getb(i), 0.00001);
        }

        //System.out.println("i_senbun_kousa_hantei="+ i_senbun_kousa_hantei+"---i_ten_"+i_ten);
        if (i_ten == 2) {

            int i_c = 0;
            if ((getcolor(i) == 0) && (getcolor(j) == 0)) {
                i_c = 0;
            }
            if ((getcolor(i) == 0) && (getcolor(j) == 1)) {
                i_c = 1;
            }
            if ((getcolor(i) == 0) && (getcolor(j) == 2)) {
                i_c = 2;
            }
            if ((getcolor(i) == 0) && (getcolor(j) == 3)) {
                return;
            }

            if ((getcolor(i) == 1) && (getcolor(j) == 0)) {
                i_c = 1;
            }
            if ((getcolor(i) == 1) && (getcolor(j) == 1)) {
                i_c = 1;
            }
            if ((getcolor(i) == 1) && (getcolor(j) == 2)) {
                i_c = 0;
            }
            if ((getcolor(i) == 1) && (getcolor(j) == 3)) {
                return;
            }

            if ((getcolor(i) == 2) && (getcolor(j) == 0)) {
                i_c = 2;
            }
            if ((getcolor(i) == 2) && (getcolor(j) == 1)) {
                i_c = 0;
            }
            if ((getcolor(i) == 2) && (getcolor(j) == 2)) {
                i_c = 2;
            }
            if ((getcolor(i) == 2) && (getcolor(j) == 3)) {
                return;
            }

            if ((getcolor(i) == 3) && (getcolor(j) == 0)) {
                return;
            }
            if ((getcolor(i) == 3) && (getcolor(j) == 1)) {
                return;
            }
            if ((getcolor(i) == 3) && (getcolor(j) == 2)) {
                return;
            }
            //if((getcolor(i)==3) && (getcolor(j)==3) ){i_c=3;}
            if ((getcolor(i) == 3) && (getcolor(j) == 3)) {
                return;
            }

            delsenbun(j);
            delsenbun(i);
            addsenbun(addsen);
            setcolor(getsousuu(), i_c);
        }//p2,p1,p4 ixb_ixa,iya_iyb

    }

// ---------------------------


    public void del_V_all() {

        int sousuu_old = sousuu + 1;
        while (sousuu < sousuu_old) {
            sousuu_old = sousuu;
            for (int i = 1; i <= sousuu - 1; i++) {
                for (int j = i + 1; j <= sousuu; j++) {
                    if (getcolor(i) == getcolor(j)) {//2–{‚ª“¯‚¶?F‚È‚çŽÀŽ{
                        if (getcolor(i) != 3) {//•â?•Šˆ?ü‚Í‘Î?ÛŠO
                            del_V(i, j);
                        }
                    }
                }
            }

        }

    }

    public void del_V_all_cc() {
        int sousuu_old = sousuu + 1;
        while (sousuu < sousuu_old) {
            sousuu_old = sousuu;
            for (int i = 1; i <= sousuu - 1; i++) {
                for (int j = i + 1; j <= sousuu; j++) {
                    del_V(i, j);
                }
            }

        }
    }


    //“_Q‚ðŽw’è‚µ?A?ü•ªAQ‚ÆQC‚ð?í?œ‚µ?ü•ªAC‚ð’Ç‰Á?i‚½‚¾‚µQ‚ð’[“_‚Æ‚·‚é‚Ì‚Í2–{‚Ì?ü•ª‚Ì‚Ý?j//ŽÀŽ{‚µ‚½‚Æ‚«‚Í1?A‰½‚à‚µ‚È‚©‚Á‚½‚Æ‚«‚Í0‚ð•Ô‚·?B
//Žè?‡‚Í?i‚P?jƒ}ƒEƒXƒNƒŠƒbƒN‚Å“_p‚ªŒˆ‚Ü‚é?B
//?i‚Q?j“_p?Å‚à‹ß‚¢“WŠJ?}‚ÉŠÜ‚Ü‚ê‚é’[“_q‚ªŒˆ‚Ü‚é?B
//?i‚R?j“WŠJ?}’†‚Ì?Ü?ü‚Å‚»‚Ì’[“_‚Ì‚¤‚¿?Aq‚É‹ß‚¢‚Ù‚¤‚Æ?Aq‚Æ‚Ì‹——£‚ªrˆÈ‰º‚Ì?ê?‡?A‚»‚Ì?Ü?ü‚Í“_q‚Æ˜AŒ‹‚µ‚Ä‚¢‚é‚Æ‚µ‚Ä
//
//
//
//
//
//
//
//
    int[] i_s = new int[2];//‚±‚Ì•Ï?”‚Ídel_V‚Ætyouten_syuui_sensuu‚Æ‚Å‹¤’Ê‚ÉŽg‚¤?Btyouten_syuui_sensuu‚Å?A’¸“_‰ñ‚è‚Ì?Ü?ü?”‚ª2‚Ì‚Æ‚«‚É‚»‚Ì2?Ü?ü‚Ì”Ô?†‚ð“ü‚ê‚é•Ï?”?B‚È‚¨?A?Ü?ü?”‚ª3ˆÈ?ã‚Ì‚Æ‚«‚ÍˆÓ–¡‚ð?¬‚³‚È‚¢?B//q‚ð’[“_‚Æ‚·‚é2–{‚Ì?ü•ª‚Ì”Ô?†

    public int del_V(Ten p, double hikiyose_hankei, double r) {
        int i_return;
        i_return = 0;

        Ten q = new Ten();
        q.set(mottomo_tikai_Ten(p));//q‚Í“_p‚É‹ß‚¢•û‚Ì’[“_
        if (q.kyori2jyou(p) > hikiyose_hankei * hikiyose_hankei) {
            return 0;
        }
        Ten p_temp = new Ten();

        if (tyouten_syuui_sensuu_for_del_V(q, r) == 2) {
            //int i_s[] = new int[2];//q‚ð’[“_‚Æ‚·‚é2–{‚Ì?ü•ª‚Ì”Ô?†
/*
			i_s[0]=0;i_s[1]=0;
			int i_temp;i_temp=0;
			for(int i=1;i<=sousuu;i++){
				p_temp.set(geta(i));if(q.kyori(getb(i))<q.kyori(geta(i)) ) {p_temp.set(getb(i)); }
				if(q.kyori(p_temp)<r) {
					if(i_temp==2){return 0;}//‚±‚±‚Ì?ê?‡i_temp==2‚Æ‚Í?A‚·‚Å‚É2–{‚Ì?Ü?ü‚ªŒ©‚Â‚©‚Á‚Ä‚¢‚é‚Æ‚±‚ë‚É3–{–Ú‚àŒ©‚Â‚©‚Á‚½‚Æ‚¢‚¤‚±‚Æ‚É‚È‚Á‚Ä‚¢‚é?B
					i_s[i_temp]=i; i_temp=i_temp+1;
				}
			}
			if(i_temp!=2){return 0;}//‚±‚±‚Ì?ê?‡i_temp==2‚Æ‚Í?A?Ü?ü‚ª2–{‚¾‚¯Œ©‚Â‚©‚Á‚½‚Æ‚¢‚¤‚±‚Æ‚Å?A–]‚Ü‚µ‚¢Œ‹‰Ê
*/
            int ix, iy;
            ix = i_s[0];
            iy = i_s[1];
            int i_hantei;
            i_hantei = 0;//i_hantei‚Í‚P‚È‚ç2?ü•ª‚Í?d‚È‚ç‚¸?A’¼?ü?ó‚ÉŒq‚ª‚Á‚Ä‚¢‚é
            int i_senbun_kousa_hantei;
            i_senbun_kousa_hantei = oc.senbun_kousa_hantei(get(ix), get(iy), 0.000001, 0.000001);

            if (i_senbun_kousa_hantei == 323) {
                i_hantei = 1;
            }
            if (i_senbun_kousa_hantei == 333) {
                i_hantei = 1;
            }
            if (i_senbun_kousa_hantei == 343) {
                i_hantei = 1;
            }
            if (i_senbun_kousa_hantei == 353) {
                i_hantei = 1;
            }


            System.out.println("i_senbun_kousa_hantei=" + i_senbun_kousa_hantei + "---tyouten_syuui_sensuu_for_del_V(q,r)_" + tyouten_syuui_sensuu_for_del_V(q, r));
            if (i_hantei == 0) {
                return 0;
            }


            if (getcolor(ix) != getcolor(iy)) {
                return 0;
            }//2–{‚ª“¯‚¶?F‚Å‚È‚¢‚È‚çŽÀŽ{‚¹‚¸

            int i_c;
            i_c = getcolor(ix);

            Senbun s_ixb_iyb = new Senbun(getb(ix), getb(iy));
            Senbun s_ixb_iya = new Senbun(getb(ix), geta(iy));
            Senbun s_ixa_iyb = new Senbun(geta(ix), getb(iy));
            Senbun s_ixa_iya = new Senbun(geta(ix), geta(iy));


            if (i_senbun_kousa_hantei == 323) {
                delsenbun(iy);
                delsenbun(ix);
                addsenbun(s_ixb_iyb);
                setcolor(getsousuu(), i_c);
            }//p2,p1,p4 ixb_ixa,iya_iyb
            if (i_senbun_kousa_hantei == 333) {
                delsenbun(iy);
                delsenbun(ix);
                addsenbun(s_ixb_iya);
                setcolor(getsousuu(), i_c);
            }//p2,p1,p3 ixb_ixa,iyb_iya
            if (i_senbun_kousa_hantei == 343) {
                delsenbun(iy);
                delsenbun(ix);
                addsenbun(s_ixa_iyb);
                setcolor(getsousuu(), i_c);
            }//p1,p2,p4 ixa_ixb,iya_iyb
            if (i_senbun_kousa_hantei == 353) {
                delsenbun(iy);
                delsenbun(ix);
                addsenbun(s_ixa_iya);
                setcolor(getsousuu(), i_c);
            }//p1,p2,p3 ixa_ixb,iyb_iya
            //
            //	addsenbun(s1);setcolor(getsousuu(),i_c);
            //	addsenbun(s2);setcolor(getsousuu(),i_c);


        }


        return 0;
    }


// -------------------------------------------------------------------------------------------------------------

    public int del_V_cc(Ten p, double hikiyose_hankei, double r) {//2‚Â‚Ì?Ü?ü‚Ì?F‚ªˆá‚Á‚½?ê?‡ƒJƒ‰?[ƒ`ƒFƒ“ƒW‚µ‚Ä?A“_?í?œ‚·‚é?B?•?Ô‚Í?Ô?Ô?A?•?Â‚Í?Â?Â?A?Â?Ô‚Í?•‚É‚·‚é
        int i_return;
        i_return = 0;

        Ten q = new Ten();
        q.set(mottomo_tikai_Ten(p));//q‚Í“_p‚É‹ß‚¢•û‚Ì’[“_
        if (q.kyori2jyou(p) > hikiyose_hankei * hikiyose_hankei) {
            return 0;
        }
        Ten p_temp = new Ten();

        if (tyouten_syuui_sensuu_for_del_V(q, r) == 2) {


            int ix, iy;
            ix = i_s[0];
            iy = i_s[1];
            int i_hantei;
            i_hantei = 0;//i_hantei‚Í‚P‚È‚ç2?ü•ª‚Í?d‚È‚ç‚¸?A’¼?ü?ó‚ÉŒq‚ª‚Á‚Ä‚¢‚é
            int i_senbun_kousa_hantei;
            i_senbun_kousa_hantei = oc.senbun_kousa_hantei(get(ix), get(iy), 0.000001, 0.000001);

            if (i_senbun_kousa_hantei == 323) {
                i_hantei = 1;
            }
            if (i_senbun_kousa_hantei == 333) {
                i_hantei = 1;
            }
            if (i_senbun_kousa_hantei == 343) {
                i_hantei = 1;
            }
            if (i_senbun_kousa_hantei == 353) {
                i_hantei = 1;
            }
            if (i_hantei == 0) {
                return 0;
            }

            //if(getcolor(ix)!=getcolor(iy)){return 0;}//2–{‚ª“¯‚¶?F‚Å‚È‚¢‚È‚çŽÀŽ{‚¹‚¸

            if ((getcolor(ix) == 0) && (getcolor(iy) == 0)) {
                setcolor(ix, 0);
                setcolor(iy, 0);
            }
            if ((getcolor(ix) == 0) && (getcolor(iy) == 1)) {
                setcolor(ix, 1);
                setcolor(iy, 1);
            }
            if ((getcolor(ix) == 0) && (getcolor(iy) == 2)) {
                setcolor(ix, 2);
                setcolor(iy, 2);
            }
            if ((getcolor(ix) == 0) && (getcolor(iy) == 3)) {
                return 0;
            }

            if ((getcolor(ix) == 1) && (getcolor(iy) == 0)) {
                setcolor(ix, 1);
                setcolor(iy, 1);
            }
            if ((getcolor(ix) == 1) && (getcolor(iy) == 1)) {
                setcolor(ix, 1);
                setcolor(iy, 1);
            }
            if ((getcolor(ix) == 1) && (getcolor(iy) == 2)) {
                setcolor(ix, 0);
                setcolor(iy, 0);
            }
            if ((getcolor(ix) == 1) && (getcolor(iy) == 3)) {
                return 0;
            }

            if ((getcolor(ix) == 2) && (getcolor(iy) == 0)) {
                setcolor(ix, 2);
                setcolor(iy, 2);
            }
            if ((getcolor(ix) == 2) && (getcolor(iy) == 1)) {
                setcolor(ix, 0);
                setcolor(iy, 0);
            }
            if ((getcolor(ix) == 2) && (getcolor(iy) == 2)) {
                setcolor(ix, 2);
                setcolor(iy, 2);
            }
            if ((getcolor(ix) == 2) && (getcolor(iy) == 3)) {
                return 0;
            }

            if ((getcolor(ix) == 3) && (getcolor(iy) == 0)) {
                return 0;
            }
            if ((getcolor(ix) == 3) && (getcolor(iy) == 1)) {
                return 0;
            }
            if ((getcolor(ix) == 3) && (getcolor(iy) == 2)) {
                return 0;
            }
            if ((getcolor(ix) == 3) && (getcolor(iy) == 3)) {
                setcolor(ix, 3);
                setcolor(iy, 3);
            }


            int i_c;
            i_c = getcolor(ix);

            Senbun s_ixb_iyb = new Senbun(getb(ix), getb(iy));
            Senbun s_ixb_iya = new Senbun(getb(ix), geta(iy));
            Senbun s_ixa_iyb = new Senbun(geta(ix), getb(iy));
            Senbun s_ixa_iya = new Senbun(geta(ix), geta(iy));


            if (i_senbun_kousa_hantei == 323) {
                delsenbun(iy);
                delsenbun(ix);
                addsenbun(s_ixb_iyb);
                setcolor(getsousuu(), i_c);
            }//p2,p1,p4 ixb_ixa,iya_iyb
            if (i_senbun_kousa_hantei == 333) {
                delsenbun(iy);
                delsenbun(ix);
                addsenbun(s_ixb_iya);
                setcolor(getsousuu(), i_c);
            }//p2,p1,p3 ixb_ixa,iyb_iya
            if (i_senbun_kousa_hantei == 343) {
                delsenbun(iy);
                delsenbun(ix);
                addsenbun(s_ixa_iyb);
                setcolor(getsousuu(), i_c);
            }//p1,p2,p4 ixa_ixb,iya_iyb
            if (i_senbun_kousa_hantei == 353) {
                delsenbun(iy);
                delsenbun(ix);
                addsenbun(s_ixa_iya);
                setcolor(getsousuu(), i_c);
            }//p1,p2,p3 ixa_ixb,iyb_iya

        }


        return 0;
    }


    //“_p‚É?Å‚à‹ß‚¢?ü•ª‚Ì?A“_p‚É‹ß‚¢•û‚Ì’[“_‚ð?A’¸“_‚Æ‚µ‚½?ê?‡?A‰½–{‚Ì?ü•ª‚ª?o‚Ä‚¢‚é‚©?i’¸“_‚ÆrˆÈ“à‚É’[“_‚ª‚ ‚é?ü•ª‚Ì?”?j//del_V—p‚ÌŠÖ?”
    public int tyouten_syuui_sensuu_for_del_V(Ten p, double r) {//del_V—p‚ÌŠÖ?”

        Ten q = new Ten();
        q.set(mottomo_tikai_Ten(p));//q‚Í“_p‚É‹ß‚¢•û‚Ì’[“_
        Ten p_temp = new Ten();


        int i_return;
        i_return = 0;
        int i_temp;
        i_temp = 1;//‚±‚±‚Ìi_temp‚Íi_temp=1-i_temp‚ÌŒ`‚Å‚Â‚©‚¤‚Ì‚Å?A0,1,0,1,0,1,,,‚Æ‚¢‚¤•—‚É•Ï‰»‚µ‚Ä‚¢‚­
        for (int i = 1; i <= sousuu; i++) {
            p_temp.set(geta(i));
            if (q.kyori2jyou(getb(i)) < q.kyori2jyou(geta(i))) {
                p_temp.set(getb(i));
            }
            if (q.kyori2jyou(p_temp) < r * r) {
                i_temp = 1 - i_temp;
                i_s[i_temp] = i;
                i_return = i_return + 1;
            }

        }

        return i_return;
    }
//--------------------------------------------


//--------------------------------------------


    //“_p‚É?Å‚à‹ß‚¢?ü•ª‚Ì?A“_p‚É‹ß‚¢•û‚Ì’[“_‚ð?A’¸“_‚Æ‚µ‚½?ê?‡?A‰½–{‚Ì?ü•ª‚ª?o‚Ä‚¢‚é‚©?i’¸“_‚ÆrˆÈ“à‚É’[“_‚ª‚ ‚é?ü•ª‚Ì?”?j
    public int tyouten_syuui_sensuu(Ten p, double r) {

        Ten q = new Ten();
        q.set(mottomo_tikai_Ten(p));//q‚Í“_p‚É‹ß‚¢•û‚Ì’[“_
        Ten p_temp = new Ten();


        int i_return;
        i_return = 0;

        for (int i = 1; i <= sousuu; i++) {
            p_temp.set(geta(i));
            if (q.kyori2jyou(getb(i)) < q.kyori2jyou(geta(i))) {
                p_temp.set(getb(i));
            }


            if (q.kyori2jyou(p_temp) < r * r) {
                i_return = i_return + 1;
            }


        }

        return i_return;
    }
//--------------------------------------------


    //“_p‚É?Å‚à‹ß‚¢?ü•ª‚Ì?A“_p‚É‹ß‚¢•û‚Ì’[“_‚ð?A’¸“_‚Æ‚µ‚½?ê?‡?A‰½–{‚Ì?Ô‚¢?ü•ª‚ª?o‚Ä‚¢‚é‚©?i’¸“_‚ÆrˆÈ“à‚É’[“_‚ª‚ ‚é?ü•ª‚Ì?”?j
    public int tyouten_syuui_sensuu_red(Ten p, double r) {

        Ten q = new Ten();
        q.set(mottomo_tikai_Ten(p));//q‚Í“_p‚É‹ß‚¢•û‚Ì’[“_
        Ten p_temp = new Ten();


        int i_return;
        i_return = 0;

        for (int i = 1; i <= sousuu; i++) {
            p_temp.set(geta(i));
            if (q.kyori2jyou(getb(i)) < q.kyori2jyou(geta(i))) {
                p_temp.set(getb(i));
            }
            if (q.kyori2jyou(p_temp) < r * r) {
                if (getcolor(i) == 1) {
                    i_return = i_return + 1;
                }
            }

        }

        return i_return;
    }

    //--------------------------------------------
    //“_p‚É?Å‚à‹ß‚¢?ü•ª‚Ì?A“_p‚É‹ß‚¢•û‚Ì’[“_‚ð?A’¸“_‚Æ‚µ‚½?ê?‡?A‰½–{‚Ì?Â‚¢?ü•ª‚ª?o‚Ä‚¢‚é‚©?i’¸“_‚ÆrˆÈ“à‚É’[“_‚ª‚ ‚é?ü•ª‚Ì?”?j
    public int tyouten_syuui_sensuu_blue(Ten p, double r) {

        Ten q = new Ten();
        q.set(mottomo_tikai_Ten(p));//q‚Í“_p‚É‹ß‚¢•û‚Ì’[“_
        Ten p_temp = new Ten();


        int i_return;
        i_return = 0;

        for (int i = 1; i <= sousuu; i++) {
            p_temp.set(geta(i));
            if (q.kyori2jyou(getb(i)) < q.kyori2jyou(geta(i))) {
                p_temp.set(getb(i));
            }
            if (q.kyori2jyou(p_temp) < r * r) {
                if (getcolor(i) == 2) {
                    i_return = i_return + 1;
                }
            }

        }

        return i_return;
    }

    //--------------------------------------------
    //“_p‚É?Å‚à‹ß‚¢?ü•ª‚Ì?A“_p‚É‹ß‚¢•û‚Ì’[“_‚ð?A’¸“_‚Æ‚µ‚½?ê?‡?A‰½–{‚Ì?•‚¢?ü•ª‚ª?o‚Ä‚¢‚é‚©?i’¸“_‚ÆrˆÈ“à‚É’[“_‚ª‚ ‚é?ü•ª‚Ì?”?j
    public int tyouten_syuui_sensuu_black(Ten p, double r) {

        Ten q = new Ten();
        q.set(mottomo_tikai_Ten(p));//q‚Í“_p‚É‹ß‚¢•û‚Ì’[“_
        Ten p_temp = new Ten();


        int i_return;
        i_return = 0;

        for (int i = 1; i <= sousuu; i++) {
            p_temp.set(geta(i));
            if (q.kyori2jyou(getb(i)) < q.kyori2jyou(geta(i))) {
                p_temp.set(getb(i));
            }
            if (q.kyori2jyou(p_temp) < r * r) {
                if (getcolor(i) == 0) {
                    i_return = i_return + 1;
                }
            }

        }

        return i_return;
    }

    //--------------------------------------------
    //“_p‚É?Å‚à‹ß‚¢?ü•ª‚Ì?A“_p‚É‹ß‚¢•û‚Ì’[“_‚ð?A’¸“_‚Æ‚µ‚½?ê?‡?A‰½–{‚Ì•â?•Šˆ?ü‚ª?o‚Ä‚¢‚é‚©?i’¸“_‚ÆrˆÈ“à‚É’[“_‚ª‚ ‚é?ü•ª‚Ì?”?j
    public int tyouten_syuui_sensuu_hojyo_kassen(Ten p, double r) {

        Ten q = new Ten();
        q.set(mottomo_tikai_Ten(p));//q‚Í“_p‚É‹ß‚¢•û‚Ì’[“_
        Ten p_temp = new Ten();


        int i_return;
        i_return = 0;

        for (int i = 1; i <= sousuu; i++) {
            p_temp.set(geta(i));
            if (q.kyori2jyou(getb(i)) < q.kyori2jyou(geta(i))) {
                p_temp.set(getb(i));
            }
            if (q.kyori2jyou(p_temp) < r * r) {
                if (getcolor(i) >= 3) {
                    i_return = i_return + 1;
                }
            }

        }

        return i_return;
    }


    //--------------------------------------------
    //“_p‚É?Å‚à‹ß‚¢?ü•ª‚Ì?A“_p‚É‹ß‚¢•û‚Ì’[“_‚ð?A’¸“_‚Æ‚µ‚½?ê?‡?A‰½–{‚Ì‘I‘ð‚³‚ê‚½?ü•ª‚ª?o‚Ä‚¢‚é‚©?B?@20180918’Ç‰Á?i’¸“_‚ÆrˆÈ“à‚É’[“_‚ª‚ ‚é?ü•ª‚Ì?”?j
    public int tyouten_syuui_sensuu_select(Ten p, double r) {//r‚Ì’l‚Í0.0001ˆÊ‚Å’¸“_Žü‚è‚Ì?Ü‚è?ô‚Ý”»’è‚Æ‚©‚Í‚¤‚Ü‚­“®‚¢‚Ä‚¢‚é

        Ten q = new Ten();
        q.set(mottomo_tikai_Ten(p));//q‚Í“_p‚É‹ß‚¢•û‚Ì’[“_
        Ten p_temp = new Ten();


        int i_return;
        i_return = 0;

        for (int i = 1; i <= sousuu; i++) {
            p_temp.set(geta(i));
            if (q.kyori2jyou(getb(i)) < q.kyori2jyou(geta(i))) {
                p_temp.set(getb(i));
            }
            if (q.kyori2jyou(p_temp) < r * r) {
                if (get_select(i) == 2) {
                    i_return = i_return + 1;
                }
            }

        }

        return i_return;
    }

//--------------------------------------------


    //“_p‚Ì‹ß‚­‚Ì?ü•ª‚ÌŠˆ?«‰»
    public void kasseika(Ten p, double r) {
        for (int i = 1; i <= sousuu; i++) {
            Senbun si;
            si = sen(i);
            si.kasseika(p, r);
        }
    }

    //‘S?ü•ª‚Ì”ñŠˆ?«‰»
    public void hikasseika() {
        for (int i = 1; i <= sousuu; i++) {
            Senbun si;
            si = sen(i);
            si.hikasseika();
        }
    }


    //?ü•ª‚ÌŠˆ?«‰»‚³‚ê‚½‚à‚Ì‚ð“_p‚Ì?À•W‚É‚·‚é
    public void set(Ten p) {
        for (int i = 1; i <= sousuu; i++) {
            Senbun si;
            si = sen(i);
            si.set(p);
        }

    }

    //?ü•ª?W?‡‚Ì’†‚Ì?ü•ªi0‚Æ?Ai0ˆÈŠO‚Å?A‘S‚­?d‚È‚é?ü•ª‚ª‚ ‚ê‚Î?A‚»‚Ì”Ô?†‚ð•Ô‚·?B‚È‚¯‚ê‚Î-10‚ð•Ô‚·?B
    public int kasanari_senbun_sagasi(int i0) {
        //int minrid=0;double minr=100000;
        for (int i = 1; i <= sousuu; i++) {
            if (i != i0) {
                if (oc.senbun_kousa_hantei(get(i), get(i0)) == 31) {
                    return i;
                }
            }
        }
        return -10;


    }


    //?ü•ªs0‚Æ‘S‚­?d‚È‚é?ü•ª‚ª?ü•ª?W?‡‚Ì’†‚Ì?ü•ª‚É‚ ‚ê‚Î?A‚»‚Ì”Ô?†‚ð•Ô‚·?B‚È‚¯‚ê‚Î-10‚ð•Ô‚·?B
    public int kasanari_senbun_sagasi(Senbun s0) {

        for (int i = 1; i <= sousuu; i++) {
            if (oc.senbun_kousa_hantei(get(i), s0) == 31) {
                return i;
            }
        }
        return -10;


    }

    //?ü•ªs0‚Æ•”•ª“I‚É?d‚È‚é?ü•ª‚ª?ü•ª?W?‡‚Ì’†‚Ì?ü•ª‚É‚ ‚ê‚Î?A?Å?‰‚ÉŒ©‚Â‚©‚Á‚½?ü•ª‚Ì”Ô?†‚ð•Ô‚·?B‚È‚¯‚ê‚Î-10‚ð•Ô‚·?B
    public int bubun_kasanari_senbun_sagasi(Senbun s0) {

        for (int i = 1; i <= sousuu; i++) {
            if (oc.senbun_kousa_hantei(get(i), s0) == 321) {
                return i;
            }
            if (oc.senbun_kousa_hantei(get(i), s0) == 322) {
                return i;
            }
            if (oc.senbun_kousa_hantei(get(i), s0) == 331) {
                return i;
            }
            if (oc.senbun_kousa_hantei(get(i), s0) == 332) {
                return i;
            }
            if (oc.senbun_kousa_hantei(get(i), s0) == 341) {
                return i;
            }
            if (oc.senbun_kousa_hantei(get(i), s0) == 342) {
                return i;
            }
            if (oc.senbun_kousa_hantei(get(i), s0) == 351) {
                return i;
            }
            if (oc.senbun_kousa_hantei(get(i), s0) == 352) {
                return i;
            }

            if (oc.senbun_kousa_hantei(get(i), s0) == 361) {
                return i;
            }
            if (oc.senbun_kousa_hantei(get(i), s0) == 362) {
                return i;
            }
            if (oc.senbun_kousa_hantei(get(i), s0) == 363) {
                return i;
            }
            if (oc.senbun_kousa_hantei(get(i), s0) == 364) {
                return i;
            }
            if (oc.senbun_kousa_hantei(get(i), s0) == 371) {
                return i;
            }
            if (oc.senbun_kousa_hantei(get(i), s0) == 372) {
                return i;
            }
            if (oc.senbun_kousa_hantei(get(i), s0) == 373) {
                return i;
            }
            if (oc.senbun_kousa_hantei(get(i), s0) == 374) {
                return i;
            }


        }
        return -10;


    }


    //“_p‚É‚à‚Á‚Æ‚à‹ß‚¢?Ü?ü‚ð‚»‚Ì“_p‚Ì‰e‚Å•ªŠ„‚·‚é?B‚½‚¾‚µ?A“_p‚Ì‰e‚ª‚Ç‚ê‚©?Ü?ü‚Ì’[“_‚Æ“¯‚¶‚Æ‚Ý‚È‚³‚ê‚é?ê?‡‚Í‰½‚à‚µ‚È‚¢?B
    public void senbun_bunkatu(Ten p) {//“_p‚ª?Ü?ü‚Ì’[“_‚Æˆê’v‚µ‚Ä‚¢‚È‚¢‚±‚Æ‚ª‘O’ñ


        int mts_id;
        mts_id = mottomo_tikai_senbun_sagasi(p);//mts_id‚Í“_p‚É?Å‚à‹ß‚¢?ü•ª‚Ì”Ô?†	public int ori_s.mottomo_tikai_senbun_sagasi(Ten p)
        Senbun mts = new Senbun(geta(mts_id), getb(mts_id));//mts‚Í“_p‚É?Å‚à‹ß‚¢?ü•ª

        //’¼?üt?ã‚Ì“_p‚Ì‰e‚ÌˆÊ’u?i“_p‚Æ?Å‚à‹ß‚¢’¼?üt?ã‚ÌˆÊ’u?j‚ð‹?‚ß‚é?Bpublic Ten oc.kage_motome(Tyokusen t,Ten p){}
        //?ü•ª‚ðŠÜ‚Þ’¼?ü‚ð“¾‚é public Tyokusen oc.Senbun2Tyokusen(Senbun s){}
        Ten pk = new Ten();
        pk.set(oc.kage_motome(oc.Senbun2Tyokusen(mts), p));//pk‚Í“_p‚Ì?i?ü•ª‚ðŠÜ‚Þ’¼?ü?ã‚Ì?j‰e
        if (pk.kyori(mottomo_tikai_Ten(pk)) < 0.000001) {
            return;
        }//‚±‚Ì?s‚Í?A“_p‚ª?Ü?ü‚Ì’[“_‚Æˆê’v‚µ‚Ä‚¢‚È‚¢‚±‚Æ‚ª‘O’ñ
        //?ü•ª‚Ì•ªŠ„-----------------------------------------
        senbun_bunkatu(mts_id, pk);  //i”Ô–Ú‚Ì?ü•ª(’[“_a‚Æb)‚ð“_p‚Å•ªŠ„‚·‚é?Bi”Ô–Ú‚Ì?ü•ªab‚ðap‚É•Ï‚¦?A?ü•ªpb‚ð‰Á‚¦‚é?B
    }


    //?Ü?üi‚ð‚»‚Ì“_p‚Ì‰e‚Å•ªŠ„‚·‚é?B‚½‚¾‚µ?A“_p‚Ì‰e‚ª‚Ç‚ê‚©?Ü?ü‚Ì’[“_‚Æ“¯‚¶‚Æ‚Ý‚È‚³‚ê‚é?ê?‡‚Í‰½‚à‚µ‚È‚¢?B
    public int senbun_bunkatu(Ten p, int i) {//‰½‚à‚µ‚È‚¢=0,•ªŠ„‚µ‚½=1

        int mts_id;
        mts_id = i;
        Senbun mts = new Senbun(geta(mts_id), getb(mts_id));//mts‚Í“_p‚É?Å‚à‹ß‚¢?ü•ª

        //’¼?üt?ã‚Ì“_p‚Ì‰e‚ÌˆÊ’u?i“_p‚Æ?Å‚à‹ß‚¢’¼?üt?ã‚ÌˆÊ’u?j‚ð‹?‚ß‚é?Bpublic Ten oc.kage_motome(Tyokusen t,Ten p){}
        //?ü•ª‚ðŠÜ‚Þ’¼?ü‚ð“¾‚é public Tyokusen oc.Senbun2Tyokusen(Senbun s){}
        Ten pk = new Ten();
        pk.set(oc.kage_motome(oc.Senbun2Tyokusen(mts), p));//pk‚Í“_p‚Ì?i?ü•ª‚ðŠÜ‚Þ’¼?ü?ã‚Ì?j‰e
        //if(pk.kyori(mottomo_tikai_Ten(pk))<0.000001) {return 0;}
        //?ü•ª‚Ì•ªŠ„-----------------------------------------
        senbun_bunkatu(mts_id, pk);  //i”Ô–Ú‚Ì?ü•ª(’[“_a‚Æb)‚ð“_p‚Å•ªŠ„‚·‚é?Bi”Ô–Ú‚Ì?ü•ªab‚ðap‚É•Ï‚¦?A?ü•ªpb‚ð‰Á‚¦‚é?B
        return 1;

    }


    public void add_sonomama(Orisensyuugou o_temp) {//•Ê‚Ì?Ü?ü?W?‡‚Ì?Ü?ü‚ð’Ç‰Á‚·‚é?B’P‚É’Ç‰Á‚·‚é‚¾‚¯‚Å?A‘¼‚Ì?ˆ—?‚Íˆê?Ø‚µ‚È‚¢?B
        for (int i = 1; i <= o_temp.getsousuu(); i++) {
            addsenbun(o_temp.geta(i), o_temp.getb(i), o_temp.getcolor(i));

        }
    }

    // --------------ccccccccc
    public void move(double dx, double dy) {//?Ü?ü?W?‡‘S‘Ì‚ÌˆÊ’u‚ðˆÚ“®‚·‚é?B
        Ten temp_a = new Ten();
        Ten temp_b = new Ten();
        for (int i = 1; i <= getsousuu(); i++) {
            temp_a.set(geta(i));
            temp_b.set(getb(i));
            temp_a.setx(temp_a.getx() + dx);
            temp_a.sety(temp_a.gety() + dy);
            temp_b.setx(temp_b.getx() + dx);
            temp_b.sety(temp_b.gety() + dy);
            seta(i, temp_a);
            setb(i, temp_b);
        }

        for (int i = 1; i <= cir_size(); i++) {

            En e_temp = new En();
            e_temp.set(cir_getEn(i));

            e_temp.setx(e_temp.getx() + dx);
            e_temp.sety(e_temp.gety() + dy);
            cir_setEn(i, e_temp);
        }


    }


    public void move(Ten ta, Ten tb, Ten tc, Ten td) {//?Ü?ü?W?‡‘S‘Ì‚ÌˆÊ’u‚ðˆÚ“®‚·‚é?B
        double d;
        d = oc.kakudo(ta, tb, tc, td);
        double r;
        r = tc.kyori(td) / ta.kyori(tb);

        double dx;
        dx = tc.getx() - ta.getx();
        double dy;
        dy = tc.gety() - ta.gety();

        //oc.ten_kaiten(Ten a,Ten b,double d,double r)//“_a‚ð’†?S‚É“_b‚ðd“x‰ñ“]‚µab‚Ì‹——£‚ªr”{‚Ì“_‚ð•Ô‚·ŠÖ?”?iŒ³‚Ì“_‚Í•Ï‚¦‚¸‚É?V‚µ‚¢“_‚ð•Ô‚·?j

        Ten temp_a = new Ten();
        Ten temp_b = new Ten();
        for (int i = 1; i <= getsousuu(); i++) {
            temp_a.set(oc.ten_kaiten(ta, geta(i), d, r));
            temp_b.set(oc.ten_kaiten(ta, getb(i), d, r));
            temp_a.setx(temp_a.getx() + dx);
            temp_a.sety(temp_a.gety() + dy);
            temp_b.setx(temp_b.getx() + dx);
            temp_b.sety(temp_b.gety() + dy);
            seta(i, temp_a);
            setb(i, temp_b);
        }
    }


    public void check1(double r_hitosii, double heikou_hantei) {
        Check1Senb.clear();
        unselect_all();
        for (int i = 1; i <= sousuu - 1; i++) {
            if (getcolor(i) != 3) {

                Senbun si;
                si = sen(i);

                for (int j = i + 1; j <= sousuu; j++) {
                    if (getcolor(j) != 3) {
                        Senbun sj;
                        sj = sen(j);//r_hitosii‚Ær_heikouhantei‚Í?Ahitosii‚Æheikou_hantei‚Ì‚¸‚ê‚Ì‹–—e’ö“x

                        Senbun si1 = new Senbun();
                        si1.set(si);
                        Senbun sj1 = new Senbun();
                        sj1.set(sj);

                        if (oc.senbun_kousa_hantei(si, sj, r_hitosii, heikou_hantei) == 31) {
                            Check1Senb.add(si1);
                            Check1Senb.add(sj1);   /* set_select(i,2);set_select(j,2); */
                        }
                        if (oc.senbun_kousa_hantei(si, sj, r_hitosii, heikou_hantei) == 321) {
                            Check1Senb.add(si1);
                            Check1Senb.add(sj1);   /* set_select(i,2);set_select(j,2); */
                        }
                        if (oc.senbun_kousa_hantei(si, sj, r_hitosii, heikou_hantei) == 322) {
                            Check1Senb.add(si1);
                            Check1Senb.add(sj1);   /* set_select(i,2);set_select(j,2); */
                        }
                        if (oc.senbun_kousa_hantei(si, sj, r_hitosii, heikou_hantei) == 331) {
                            Check1Senb.add(si1);
                            Check1Senb.add(sj1);   /* set_select(i,2);set_select(j,2); */
                        }
                        if (oc.senbun_kousa_hantei(si, sj, r_hitosii, heikou_hantei) == 332) {
                            Check1Senb.add(si1);
                            Check1Senb.add(sj1);   /* set_select(i,2);set_select(j,2); */
                        }
                        if (oc.senbun_kousa_hantei(si, sj, r_hitosii, heikou_hantei) == 341) {
                            Check1Senb.add(si1);
                            Check1Senb.add(sj1);   /* set_select(i,2);set_select(j,2); */
                        }
                        if (oc.senbun_kousa_hantei(si, sj, r_hitosii, heikou_hantei) == 342) {
                            Check1Senb.add(si1);
                            Check1Senb.add(sj1);   /* set_select(i,2);set_select(j,2); */
                        }
                        if (oc.senbun_kousa_hantei(si, sj, r_hitosii, heikou_hantei) == 351) {
                            Check1Senb.add(si1);
                            Check1Senb.add(sj1);   /* set_select(i,2);set_select(j,2); */
                        }
                        if (oc.senbun_kousa_hantei(si, sj, r_hitosii, heikou_hantei) == 352) {
                            Check1Senb.add(si1);
                            Check1Senb.add(sj1);   /* set_select(i,2);set_select(j,2); */
                        }
                        if (oc.senbun_kousa_hantei(si, sj, r_hitosii, heikou_hantei) >= 360) {
                            Check1Senb.add(si1);
                            Check1Senb.add(sj1);   /* set_select(i,2);set_select(j,2); */
                        }

                    }
                }
            }
        }
    }


    public int fix1(double r_hitosii, double heikou_hantei) {//‰½‚à‚µ‚È‚©‚Á‚½‚ç0?A‰½‚©?C?³‚µ‚½‚ç1‚ð•Ô‚·?B
        unselect_all();
        for (int i = 1; i <= sousuu - 1; i++) {
            if (getcolor(i) != 3) {

                Senbun si;
                si = sen(i);
                for (int j = i + 1; j <= sousuu; j++) {
                    if (getcolor(j) != 3) {
                        Senbun sj;
                        sj = sen(j);//r_hitosii‚Ær_heikouhantei‚Í?Ahitosii‚Æheikou_hantei‚Ì‚¸‚ê‚Ì‹–—e’ö“x
                        //TŽšŒ^Œð?·
                        if (oc.senbun_kousa_hantei(si, sj, r_hitosii, heikou_hantei) == 31) {
                            setcolor(i, getcolor(j));
                            delsenbun(j);
                            return 1;
                        }
                        if (oc.senbun_kousa_hantei(si, sj, r_hitosii, heikou_hantei) == 321) {
                            set_select(i, 2);
                            set_select(j, 2);
                        }
                        if (oc.senbun_kousa_hantei(si, sj, r_hitosii, heikou_hantei) == 322) {
                            set_select(i, 2);
                            set_select(j, 2);
                        }
                        if (oc.senbun_kousa_hantei(si, sj, r_hitosii, heikou_hantei) == 331) {
                            set_select(i, 2);
                            set_select(j, 2);
                        }
                        if (oc.senbun_kousa_hantei(si, sj, r_hitosii, heikou_hantei) == 332) {
                            set_select(i, 2);
                            set_select(j, 2);
                        }
                        if (oc.senbun_kousa_hantei(si, sj, r_hitosii, heikou_hantei) == 341) {
                            set_select(i, 2);
                            set_select(j, 2);
                        }
                        if (oc.senbun_kousa_hantei(si, sj, r_hitosii, heikou_hantei) == 342) {
                            set_select(i, 2);
                            set_select(j, 2);
                        }
                        if (oc.senbun_kousa_hantei(si, sj, r_hitosii, heikou_hantei) == 351) {
                            set_select(i, 2);
                            set_select(j, 2);
                        }
                        if (oc.senbun_kousa_hantei(si, sj, r_hitosii, heikou_hantei) == 352) {
                            set_select(i, 2);
                            set_select(j, 2);
                        }
                        if (oc.senbun_kousa_hantei(si, sj, r_hitosii, heikou_hantei) >= 360) {
                            set_select(i, 2);
                            set_select(j, 2);
                        }
                    }
                }

            }
        }
        return 0;
    }

// ***********************************

    public void check2(double r_hitosii, double heikou_hantei) {
        Check2Senb.clear();

        unselect_all();
        for (int i = 1; i <= sousuu - 1; i++) {
            if (getcolor(i) != 3) {

                Senbun si;
                si = sen(i);
                for (int j = i + 1; j <= sousuu; j++) {
                    if (getcolor(j) != 3) {
                        Senbun sj;
                        sj = sen(j);//r_hitosii‚Ær_heikouhantei‚Í?Ahitosii‚Æheikou_hantei‚Ì‚¸‚ê‚Ì‹–—e’ö“x

                        Senbun si1 = new Senbun();
                        si1.set(si);
                        Senbun sj1 = new Senbun();
                        sj1.set(sj);

                        //TŽšŒ^Œð?·
                        if (oc.senbun_kousa_hantei_amai(si, sj, r_hitosii, heikou_hantei) == 25) {
                            Check2Senb.add(si1);
                            Check2Senb.add(sj1);   /* set_select(i,2);set_select(j,2); */
                        }
                        if (oc.senbun_kousa_hantei_amai(si, sj, r_hitosii, heikou_hantei) == 26) {
                            Check2Senb.add(si1);
                            Check2Senb.add(sj1);   /* set_select(i,2);set_select(j,2); */
                        }
                        if (oc.senbun_kousa_hantei_amai(si, sj, r_hitosii, heikou_hantei) == 27) {
                            Check2Senb.add(si1);
                            Check2Senb.add(sj1);   /* set_select(i,2);set_select(j,2); */
                        }
                        if (oc.senbun_kousa_hantei_amai(si, sj, r_hitosii, heikou_hantei) == 28) {
                            Check2Senb.add(si1);
                            Check2Senb.add(sj1);   /* set_select(i,2);set_select(j,2); */
                        }
                    }
                }
            }
        }
    }


    public int fix2(double r_hitosii, double heikou_hantei) {//‰½‚à‚µ‚È‚©‚Á‚½‚ç0?A‰½‚©?C?³‚µ‚½‚ç1‚ð•Ô‚·?B
        unselect_all();
        for (int i = 1; i <= sousuu - 1; i++) {
            if (getcolor(i) != 3) {

                Senbun si;
                si = sen(i);
                for (int j = i + 1; j <= sousuu; j++) {
                    if (getcolor(j) != 3) {
                        Senbun sj;
                        sj = sen(j);//r_hitosii‚Ær_heikouhantei‚Í?Ahitosii‚Æheikou_hantei‚Ì‚¸‚ê‚Ì‹–—e’ö“x
                        //TŽšŒ^Œð?·
                        //?Ü?üi‚ð‚»‚Ì“_p‚Ì‰e‚Å•ªŠ„‚·‚é?B‚½‚¾‚µ?A“_p‚Ì‰e‚ª‚Ç‚ê‚©?Ü?ü‚Ì’[“_‚Æ“¯‚¶‚Æ‚Ý‚È‚³‚ê‚é?ê?‡‚Í‰½‚à‚µ‚È‚¢?B
                        //	public void senbun_bunkatu(Ten p,int i){
                        if (oc.senbun_kousa_hantei_amai(si, sj, r_hitosii, heikou_hantei) == 25) {
                            if (senbun_bunkatu(geta(i), j) == 1) {
                                return 1;
                            }
                        }
                        if (oc.senbun_kousa_hantei_amai(si, sj, r_hitosii, heikou_hantei) == 26) {
                            if (senbun_bunkatu(getb(i), j) == 1) {
                                return 1;
                            }
                        }
                        if (oc.senbun_kousa_hantei_amai(si, sj, r_hitosii, heikou_hantei) == 27) {
                            if (senbun_bunkatu(geta(j), i) == 1) {
                                return 1;
                            }
                        }
                        if (oc.senbun_kousa_hantei_amai(si, sj, r_hitosii, heikou_hantei) == 28) {
                            if (senbun_bunkatu(getb(j), i) == 1) {
                                return 1;
                            }
                        }
                    }
                }

            }
        }
        return 0;
    }


    // ***********************************ppppppppppppqqqqqq
//Cir‚É‚Í1”Ô–Ú‚©‚çcir_size()”Ô–Ú‚Ü‚Åƒf?[ƒ^‚ª“ü‚Á‚Ä‚¢‚é
    public int cir_size() {
        return Cir.size() - 1;
    }

    public En cir_getEn(int i) {

        //if(sousuu+1> Senb.size()){while(sousuu+1> Senb.size()){Senb.add(new Senbun());}}//‚±‚Ì•¶‚ª‚È‚¢‚Æ‚¤‚Ü‚­?s‚©‚È‚¢?B‚È‚º‚±‚Ì•¶‚Å‚È‚¢‚Æ‚¢‚¯‚È‚¢‚©‚Æ‚¢‚¤—?—R‚ª?³Šm‚É‚Í‚í‚©‚ç‚È‚¢?B
        //return (Senbun)Senb.get(i);
        return (En) Cir.get(i);

    }

    public void cir_setEn(int i, En e0) {
        //i‚ÌŽw’è‚ª‚ ‚Á‚½‚Æ‚«?AEn‚ÍCir‚Ìi-1”Ô–Ú‚ÉŠi”[‚³‚ê‚é?@
        //i>cir_size()‚Ì‚Æ‚«‚Í?ACir‚Ìi-1”Ô–Ú‚Ì‰~‚Í‚Ü‚¾’è‹`‚³‚ê‚Ä‚¢‚È‚¢‚Ì‚Å?A‚Æ‚è‚ ‚¦‚¸i-1”Ô–Ú‚Ü‚Å‰~‚ð‘¶?Ý‚³‚¹‚é•K—v‚ª‚ ‚é


//for(int j=1;j<=i-1;j++) {
//	System.out.println("(2)cir_setEn(i,e_temp)  "+ j+";" +cir_getEn(j).getx()+"," +cir_getEn(j).gety()+"," +cir_getEn(j).getr());
//}
//	System.out.println("(2)cir_setEn(i,e_temp)  "+ i+";" +e0.getx()+"," +e0.gety()+"," +e0.getr());

        if (i > cir_size()) {
            while (i > cir_size()) {
                Cir.add(new En());
            }
        }

        En etemp = new En();
        etemp.set(e0);
//System.out.println("etemp "+ etemp.getcolor()  );

        //Cir.set(i,e0) ; //e0‚ð’¼?ÚCir‚Ìset‚·‚é‚Æ?ACir‚ÌEn‚Íi‚ªˆá‚Á‚Ä‚à‘S•”e0‚Å“¯‚¶‚É‚È‚é‚Ì‚Å?A“r’†‚Éetemp‚ð?V‚µ‚­‚Â‚­‚Á‚Ä?Ae0‚Ì’l‚ðƒRƒs?[‚µ‚ÄCir‚Éset‚³‚¹‚é?B
        Cir.set(i, etemp);
//for(int j=1;j<=i;j++) {
//	System.out.println("(3)cir_setEn(i,e_temp)  "+ j+";" +cir_getEn(j).getx()+"," +cir_getEn(j).gety()+"," +cir_getEn(j).getr());
//}
    }


    public int check1_size() {
        return Check1Senb.size();
    }

    public int check2_size() {
        return Check2Senb.size();
    }

    public int check3_size() {
        return Check3Senb.size();
    }//Check3Senb‚É‚Í0”Ô–Ú‚©‚çsize()-1”Ô–Ú‚Ü‚Åƒf?[ƒ^‚ª“ü‚Á‚Ä‚¢‚é

    public int check4_size() {
        return Check4Senb.size();
    }//Check4Senb‚É‚Í0”Ô–Ú‚©‚çsize()-1”Ô–Ú‚Ü‚Åƒf?[ƒ^‚ª“ü‚Á‚Ä‚¢‚é

    public int check4_T_size() {
        return Check4Ten.size();
    }//Check4Ten‚É‚Í0”Ô–Ú‚©‚çsize()-1”Ô–Ú‚Ü‚Åƒf?[ƒ^‚ª“ü‚Á‚Ä‚¢‚é

    public Senbun check1_getSenbun(int i) {
        return (Senbun) Check1Senb.get(i);
    }

    public Senbun check2_getSenbun(int i) {
        return (Senbun) Check2Senb.get(i);
    }

    public Senbun check3_getSenbun(int i) {
        return (Senbun) Check3Senb.get(i);
    }

    public Senbun check4_getSenbun(int i) {
        return (Senbun) Check4Senb.get(i);
    }

    public Ten check4_getTen(int i) {
        return (Ten) Check4Ten.get(i);
    }

    public void check3(double r) {//’¸“_ŽüˆÍ‚Ì?ü?”ƒ`ƒFƒbƒN
        Check3Senb.clear();
        unselect_all();
        for (int i = 1; i <= sousuu; i++) {
            if (getcolor(i) != 3) {
                Senbun si;
                si = sen(i);
                Ten p = new Ten();
                int tss;    //’¸“_‚ÌŽü‚è‚Ì?Ü?ü‚Ì?”?B?@tss%2==0 ‹ô?”?A==1 Šï?”
                int tss_red;    //’¸“_‚ÌŽü‚è‚ÌŽR?Ü?ü‚Ì?”?B
                int tss_blue;    //’¸“_‚ÌŽü‚è‚Ì’J?Ü?ü‚Ì?”?B
                int tss_black;    //’¸“_‚ÌŽü‚è‚Ì‹«ŠE?ü‚Ì?”?B
                int tss_hojyo_kassen;    //’¸“_‚ÌŽü‚è‚Ì•â?•Šˆ?ü‚Ì?”?B

                //-----------------
                p.set(si.geta());
                tss = tyouten_syuui_sensuu(p, r);
                tss_red = tyouten_syuui_sensuu_red(p, r);
                tss_blue = tyouten_syuui_sensuu_blue(p, r);
                tss_black = tyouten_syuui_sensuu_black(p, r);
                tss_hojyo_kassen = tyouten_syuui_sensuu_hojyo_kassen(p, r);
                //System.out.println("senbun("+i+") a : tss="+tss+", tss_red="+tss_red+", tss_blue="+tss_blue+", tss_black="+tss_black+", tss_hojyo_kassen="+tss_hojyo_kassen);
                //-----------------

                if ((tss_black != 0) && (tss_black != 2)) {//?•?ü‚ª‚È‚¢‚©2–{ˆÈŠO‚Ì?ê?‡‚Í‚¨‚©‚µ‚¢?B
                    //System.out.println("20170216_1");
                    Check3Senb.add(new Senbun(p, p));//set_select(i,2);

                }


                if (tss_black == 0) {//?•?ü‚ª‚È‚¢?ê?‡
                    if (tss - tss_hojyo_kassen == tss_red + tss_blue) {//?i‘O’ñ‚Æ‚µ‚Ä‹«ŠE‚Í?•‚Å?AŽR’J–¢?Ý’è?Ü?ü‚Í‚È‚¢‚±‚Æ?B?j’¸“_ŽüˆÍ‚É?Ô‚©?Â‚µ‚©‚È‚¢?B‚Â‚Ü‚è?A—pŽ†“à•”‚Ì“_

                        if (Math.abs(tss_red - tss_blue) != 2) {//—pŽ†“à•”‚Ì“_‚Å‘O?ì’è—?‚ð–ž‚½‚³‚È‚¢‚Ì‚Íƒ_ƒ?
                            //System.out.println("20170216_2");
                            Check3Senb.add(new Senbun(p, p));//set_select(i,2);
                        }
                    }
                    if (kakutyou_fushimi_hantei_naibu(p) == 0) {
                        //System.out.println("20170216_3");
                        Check3Senb.add(new Senbun(p, p));//set_select(i,2);
                    }


                }

                if (tss_black == 2) {//?•?ü‚ª2–{‚Ì?ê?‡
                    if (kakutyou_fushimi_hantei_henbu(p) == 0) {
                        //System.out.println("20170216_3");
                        Check3Senb.add(new Senbun(p, p));//set_select(i,2);
                    }
                }


                //-----------------


                //-----------------
                p.set(si.getb());
                tss = tyouten_syuui_sensuu(p, r);
                tss_red = tyouten_syuui_sensuu_red(p, r);
                tss_blue = tyouten_syuui_sensuu_blue(p, r);
                tss_black = tyouten_syuui_sensuu_black(p, r);
                tss_hojyo_kassen = tyouten_syuui_sensuu_hojyo_kassen(p, r);
                //System.out.println("senbun("+i+")  b : tss="+tss+", tss_red="+tss_red+", tss_blue="+tss_blue+", tss_black="+tss_black+", tss_hojyo_kassen="+tss_hojyo_kassen);

                //-----------------
                if ((tss_black != 0) && (tss_black != 2)) {//?•?ü‚ª‚È‚¢‚©2–{ˆÈŠO‚Ì?ê?‡‚Í‚¨‚©‚µ‚¢?B
                    //System.out.println("20170216_4");
                    Check3Senb.add(new Senbun(p, p));//set_select(i,2);
                }

                if (tss_black == 0) {//?•?ü‚ª‚È‚¢?ê?‡
                    if (tss - tss_hojyo_kassen == tss_red + tss_blue) {//?i‘O’ñ‚Æ‚µ‚Ä‹«ŠE‚Í?•‚Å?AŽR’J–¢?Ý’è?Ü?ü‚Í‚È‚¢‚±‚Æ?B?j’¸“_ŽüˆÍ‚É?Ô‚©?Â‚µ‚©‚È‚¢?B‚Â‚Ü‚è?A—pŽ†“à•”‚Ì“_
                        if (Math.abs(tss_red - tss_blue) != 2) {//—pŽ†“à•”‚Ì“_‚Å‘O?ì’è—?‚ð–ž‚½‚³‚È‚¢‚Ì‚Íƒ_ƒ?
                            //System.out.println("20170216_5");
                            Check3Senb.add(new Senbun(p, p));//set_select(i,2);
                        }
                    }
                    if (kakutyou_fushimi_hantei_naibu(p) == 0) {
                        //System.out.println("20170216_6");
                        Check3Senb.add(new Senbun(p, p));//set_select(i,2);
                    }


                }


                if (tss_black == 2) {//?•?ü‚ª2–{‚Ì?ê?‡
                    if (kakutyou_fushimi_hantei_henbu(p) == 0) {
                        //System.out.println("20170216_3");
                        Check3Senb.add(new Senbun(p, p));//set_select(i,2);
                    }
                }


                //-----------------
            }
        }


    }


    // -----------------------------------------------------
    public int Check4Ten_jyuufuku_check(Ten p0) {
        for (int i = 0; i < check4_T_size(); i++) {
            Ten p = new Ten();
            p.set(check4_getTen(i));
            if ((-0.00000001 < p0.getx() - p.getx()) && (p0.getx() - p.getx() < 0.00000001)) {
                if ((-0.00000001 < p0.gety() - p.gety()) && (p0.gety() - p.gety() < 0.00000001)) {
                    return 1;
                }
            }
        }
        return 0;
    }

    // -----------------------------------------------------
    public void check4(double r) {//’¸“_ŽüˆÍ‚Ì?ü?”ƒ`ƒFƒbƒN
        Check4Senb.clear();
        Check4Ten.clear();

        unselect_all();

        //ƒ`ƒFƒbƒN‚·‚×‚«?ê?Š‚Ì?”‚¦?ã‚°
        for (int i = 1; i <= sousuu; i++) {
            if (getcolor(i) != 3) {

                Senbun si;
                si = sen(i);

                //System.out.println("sen("+i+")=si  : ax="+si.geta().getx()+", ay="+si.geta().gety()+", bx="+si.getb().getx()+", by="+si.getb().gety());

                Ten pa = new Ten();
                pa.set(si.geta());
                if (Check4Ten_jyuufuku_check(pa) == 0) {
                    Check4Ten.add(pa);
                }

                Ten pb = new Ten();
                pb.set(si.getb());
                if (Check4Ten_jyuufuku_check(pb) == 0) {
                    Check4Ten.add(pb);
                }

                //20170828
                //‚È‚º‚©
                //Ten p=new Ten();
                //p.set(si.geta());
                //Check4Ten_jyuufuku_check(p)
                //p.set(si.getb());
                //Check4Ten_jyuufuku_check(p)
                //‚Æ‚·‚é‚Æ‘O‚Ì2?s‚àp.set(si.getb());‚Ì?ê?‡‚ÌŒ‹‰Ê‚É‚È‚Á‚Ä‚µ‚Ü‚¤?B
            }
        }

        System.out.println("check4_T_size() = " + check4_T_size());

        //ƒ`ƒFƒbƒN‚·‚×‚«?ê?Š‚ª•½‚ç‚É?Ü‚è‚½‚½‚Ý‰Â”\‚©‚Ì‘I•Ê
        for (int i = 0; i < check4_T_size(); i++) {
            //System.out.println("i = "+i+"/"+check4_T_size());
            Ten p = new Ten();
            p.set(check4_getTen(i));

            //tyouten_syuui_sensuu_all(p,r);
            //-----------------
            if (i_taira_ok(p, r) == 0) {
                Check4Senb.add(new Senbun(p, p));
            }
        }
    }

    // -------------------------------------------------------------------
    public int i_taira_ok(Ten p, double r) {//•½‚ç‚É?Ü‚è‚½‚½‚Ý‰Â”\=1
        double hantei_kyori = 0.00001;
        //“_p‚É?Å‚à‹ß‚¢?ü•ª‚Ì?A“_p‚É‹ß‚¢•û‚Ì’[“_‚ð?A’¸“_‚Æ‚µ‚½?ê?‡?A‰½–{‚Ì?ü•ª‚ª?o‚Ä‚¢‚é‚©?i’¸“_‚ÆrˆÈ“à‚É’[“_‚ª‚ ‚é?ü•ª‚Ì?”?j
        int i_tss = 0;    //i_tss%2==0 ‹ô?”?A==1 Šï?”
        int i_tss_red = 0;
        int i_tss_blue = 0;
        int i_tss_black = 0;
        int i_tss_cyan = 0;

        Narabebako_int_double nbox = new Narabebako_int_double();

        for (int i = 1; i <= getsousuu(); i++) {
            if ((p.kyori2jyou(geta(i)) < r * r) || (p.kyori2jyou(getb(i)) < r * r)) {
                i_tss = i_tss + 1;
                if (getcolor(i) == 1) {
                    i_tss_red = i_tss_red + 1;
                } else if (getcolor(i) == 2) {
                    i_tss_blue = i_tss_blue + 1;
                } else if (getcolor(i) == 0) {
                    i_tss_black = i_tss_black + 1;
                } else if (getcolor(i) >= 3) {
                    i_tss_cyan = i_tss_cyan + 1;
                }
            }
            //System.out.println("q.kyori2jyou(p_temp)="+q.kyori2jyou(p_temp)+", r*r="+r*r);


            //	}


            //	for (int i=1; i<=getsousuu(); i++ ){

            //p‚ð’[“_‚Æ‚·‚é?Ü?ü‚ðNarabebako‚É“ü‚ê‚é
            if ((0 <= getcolor(i)) && (getcolor(i) <= 2)) { //‚±‚Ì’iŠK‚Å•â?•Šˆ?ü‚Í?œ‚­
                if (p.kyori(geta(i)) < hantei_kyori) {
                    nbox.ire_i_tiisaijyun(new int_double(i, oc.kakudo(geta(i), getb(i))));
                } else if (p.kyori(getb(i)) < hantei_kyori) {
                    nbox.ire_i_tiisaijyun(new int_double(i, oc.kakudo(getb(i), geta(i))));
                }
            }
        }


        // ”»’èŠJŽn-------------------------------------------

        if ((i_tss_black != 0) && (i_tss_black != 2)) {//?•?ü‚ª‚È‚¢‚©2–{ˆÈŠO‚Ì?ê?‡‚Í‚¨‚©‚µ‚¢?B
            return 0;
        }

        if (i_tss_black == 0) {//?•?ü‚ª‚È‚¢?ê?‡
            if (Math.abs(i_tss_red - i_tss_blue) != 2) {//—pŽ†“à•”‚Ì“_‚Å‘O?ì’è—?‚ð–ž‚½‚³‚È‚¢‚Ì‚Íƒ_ƒ?
                return 0;
            }
// --------------------------


/*

		//p‚ð’[“_‚Æ‚·‚é?Ü?ü‚ðNarabebako‚É“ü‚ê‚é
		Narabebako_int_double nbox =new Narabebako_int_double();
		for (int i=1; i<=getsousuu(); i++ ){ if((0<=getcolor(i))&&(getcolor(i)<=2)){ //‚±‚Ì’iŠK‚Å•â?•Šˆ?ü‚Í?œ‚­
			if(      p.kyori(geta(i))<hantei_kyori){
				nbox.ire_i_tiisaijyun(new int_double( i  , oc.kakudo(geta(i),getb(i)) ));
			}else if(p.kyori(getb(i))<hantei_kyori){
				nbox.ire_i_tiisaijyun(new int_double( i  , oc.kakudo(getb(i),geta(i)) ));
			}
		}}

*/

// --------------------------
            return kakutyou_fushimi_hantei_naibu(p, nbox);


            //return kakutyou_fushimi_hantei_naibu(p);
        }

        if (i_tss_black == 2) {//?•?ü‚ª2–{‚Ì?ê?‡


// ------------------

            //double hantei_kyori=0.00001;

/*
		//p‚ð’[“_‚Æ‚·‚é?Ü?ü‚ðNarabebako‚É“ü‚ê‚é
		Narabebako_int_double nbox =new Narabebako_int_double();
		for (int i=1; i<=getsousuu(); i++ ){ if((0<=getcolor(i))&&(getcolor(i)<=2)){ //‚±‚Ì’iŠK‚Å•â?•Šˆ?ü‚Í?œ‚­
			if(      p.kyori(geta(i))<hantei_kyori){
				nbox.ire_i_tiisaijyun(new int_double( i  , oc.kakudo(geta(i),getb(i)) ));
			}else if(p.kyori(getb(i))<hantei_kyori){
				nbox.ire_i_tiisaijyun(new int_double( i  , oc.kakudo(getb(i),geta(i)) ));
			}
		}}
*/
// ------------------
            return kakutyou_fushimi_hantei_henbu(p, nbox);


            //return kakutyou_fushimi_hantei_henbu(p);
        }
        return 1;
    }


    // -----------------------------------------------------
    public void check4_old(double r) {
        //_old‚ð‚Æ‚ê‚ÎƒIƒŠƒWƒiƒ‹‚Ìcheck4(double r)ŠÖ?”‚Æ‚µ‚Ä?ì“®‚·‚é
        //’¸“_ŽüˆÍ‚Ì?ü?”ƒ`ƒFƒbƒN
        Check4Senb.clear();
        unselect_all();
        for (int i = 1; i <= sousuu; i++) {
            if (getcolor(i) != 3) {
                Senbun si;
                si = sen(i);
                Ten p = new Ten();
                int tss;    //tss%2==0 ‹ô?”?A==1 Šï?”
                int tss_red;
                int tss_blue;
                int tss_black;
                int tss_cyan;

                //-----------------
                p.set(si.geta());
                tss = tyouten_syuui_sensuu(p, r);
                tss_red = tyouten_syuui_sensuu_red(p, r);
                tss_blue = tyouten_syuui_sensuu_blue(p, r);
                tss_black = tyouten_syuui_sensuu_black(p, r);
                tss_cyan = tyouten_syuui_sensuu_hojyo_kassen(p, r);
                //System.out.println("senbun("+i+") a : tss="+tss+", tss_red="+tss_red+", tss_blue="+tss_blue+", tss_black="+tss_black+", tss_cyan="+tss_cyan);
                //-----------------

                if ((tss_black != 0) && (tss_black != 2)) {//?•?ü‚ª‚È‚¢‚©2–{ˆÈŠO‚Ì?ê?‡‚Í‚¨‚©‚µ‚¢?B
                    //System.out.println("20170216_1");
                    Check4Senb.add(new Senbun(p, p));//set_select(i,2);

                }


                if (tss_black == 0) {//?•?ü‚ª‚È‚¢?ê?‡
                    if (tss - tss_cyan == tss_red + tss_blue) {//?i‘O’ñ‚Æ‚µ‚Ä‹«ŠE‚Í?•‚Å?AŽR’J–¢?Ý’è?Ü?ü‚Í‚È‚¢‚±‚Æ?B?j’¸“_ŽüˆÍ‚É?Ô‚©?Â‚µ‚©‚È‚¢?B‚Â‚Ü‚è?A—pŽ†“à•”‚Ì“_

                        if (Math.abs(tss_red - tss_blue) != 2) {//—pŽ†“à•”‚Ì“_‚Å‘O?ì’è—?‚ð–ž‚½‚³‚È‚¢‚Ì‚Íƒ_ƒ?
                            //System.out.println("20170216_2");
                            Check4Senb.add(new Senbun(p, p));//set_select(i,2);
                        }
                    }
                    if (kakutyou_fushimi_hantei_naibu(p) == 0) {
                        //System.out.println("20170216_3");
                        Check4Senb.add(new Senbun(p, p));//set_select(i,2);
                    }


                }

                if (tss_black == 2) {//?•?ü‚ª2–{‚Ì?ê?‡
                    if (kakutyou_fushimi_hantei_henbu(p) == 0) {
                        //System.out.println("20170216_3");
                        Check4Senb.add(new Senbun(p, p));//set_select(i,2);
                    }
                }


                //-----------------


                //-----------------
                p.set(si.getb());
                tss = tyouten_syuui_sensuu(p, r);
                tss_red = tyouten_syuui_sensuu_red(p, r);
                tss_blue = tyouten_syuui_sensuu_blue(p, r);
                tss_black = tyouten_syuui_sensuu_black(p, r);
                tss_cyan = tyouten_syuui_sensuu_hojyo_kassen(p, r);
                //System.out.println("senbun("+i+")  b : tss="+tss+", tss_red="+tss_red+", tss_blue="+tss_blue+", tss_black="+tss_black+", tss_cyan="+tss_cyan);

                //-----------------
                if ((tss_black != 0) && (tss_black != 2)) {//?•?ü‚ª‚È‚¢‚©2–{ˆÈŠO‚Ì?ê?‡‚Í‚¨‚©‚µ‚¢?B
                    //System.out.println("20170216_4");
                    Check4Senb.add(new Senbun(p, p));//set_select(i,2);
                }

                if (tss_black == 0) {//?•?ü‚ª‚È‚¢?ê?‡
                    if (tss - tss_cyan == tss_red + tss_blue) {//?i‘O’ñ‚Æ‚µ‚Ä‹«ŠE‚Í?•‚Å?AŽR’J–¢?Ý’è?Ü?ü‚Í‚È‚¢‚±‚Æ?B?j’¸“_ŽüˆÍ‚É?Ô‚©?Â‚µ‚©‚È‚¢?B‚Â‚Ü‚è?A—pŽ†“à•”‚Ì“_
                        if (Math.abs(tss_red - tss_blue) != 2) {//—pŽ†“à•”‚Ì“_‚Å‘O?ì’è—?‚ð–ž‚½‚³‚È‚¢‚Ì‚Íƒ_ƒ?
                            //System.out.println("20170216_5");
                            Check4Senb.add(new Senbun(p, p));//set_select(i,2);
                        }
                    }
                    if (kakutyou_fushimi_hantei_naibu(p) == 0) {
                        //System.out.println("20170216_6");
                        Check4Senb.add(new Senbun(p, p));//set_select(i,2);
                    }


                }


                if (tss_black == 2) {//?•?ü‚ª2–{‚Ì?ê?‡
                    if (kakutyou_fushimi_hantei_henbu(p) == 0) {
                        //System.out.println("20170216_3");
                        Check4Senb.add(new Senbun(p, p));//set_select(i,2);
                    }
                }


                //-----------------
            }
        }


    }


// **************************************

    //Ten p ‚É?Å‚à‹ß‚¢—pŽ†•Ó•”‚Ì’[“_‚ªŠg’£•šŒ©’è—?‚ð–ž‚½‚·‚©”»’è
    public int kakutyou_fushimi_hantei_henbu(Ten p) {//return?@0=–ž‚½‚³‚È‚¢?A?@1=–ž‚½‚·?B?@
        double hantei_kyori = 0.00001;

        Ten t1 = new Ten();
        t1.set(mottomo_tikai_Ten_with_icol_0_1_2(p));//“_p‚É?Å‚à‹ß‚¢?A?u?ü•ª‚Ì’[“_?v‚ð•Ô‚·ori_s.mottomo_tikai_Ten‚Í‹ß‚¢“_‚ª‚È‚¢‚Æ p_return.set(100000.0,100000.0)‚Æ•Ô‚µ‚Ä‚­‚é

        //t1‚ð’[“_‚Æ‚·‚é?Ü?ü‚ðNarabebako‚É“ü‚ê‚é
        Narabebako_int_double nbox = new Narabebako_int_double();
        for (int i = 1; i <= getsousuu(); i++) {
            if ((0 <= getcolor(i)) && (getcolor(i) <= 2)) { //‚±‚Ì’iŠK‚Å•â?•Šˆ?ü‚Í?œ‚­
                if (t1.kyori(geta(i)) < hantei_kyori) {
                    nbox.ire_i_tiisaijyun(new int_double(i, oc.kakudo(geta(i), getb(i))));
                } else if (t1.kyori(getb(i)) < hantei_kyori) {
                    nbox.ire_i_tiisaijyun(new int_double(i, oc.kakudo(getb(i), geta(i))));
                }
            }
        }

        return kakutyou_fushimi_hantei_henbu(p, nbox);
    }

    // ---------------------------------
    public int kakutyou_fushimi_hantei_henbu(Ten p, Narabebako_int_double nbox) {//return?@0=–ž‚½‚³‚È‚¢?A?@1=–ž‚½‚·?B?@
        double hantei_kyori = 0.00001;

        int tikai_orisen_jyunban;
        int tooi_orisen_jyunban;
        if (nbox.getsousuu() == 2) {//t1‚ð’[“_‚Æ‚·‚é?Ü?ü‚Ì?”‚ª2‚Ì‚Æ‚«
            if (getcolor(nbox.get_int(1)) != 0) {//1–{–Ú‚ª?•‚Å‚È‚¢‚È‚çƒ_ƒ?
                return 0;
            }
            if (getcolor(nbox.get_int(2)) != 0) {//2–{–Ú‚ª?•‚Å‚È‚¢‚È‚çƒ_ƒ?
                return 0;
            }

            //2–{‚Ì?üŽí‚ª?•?•
            return 1;
        }


        //ˆÈ‰º‚Ít1‚ð’[“_‚Æ‚·‚é?Ü?ü‚Ì?”‚ª3ˆÈ?ã‚Ì‹ô?”‚Ì‚Æ‚«

        //fushimi_hantei_kakudo_goukei=360.0;


        //•Ó‚Ì?Ü?ü‚ª,‚È‚ç‚×‚Î‚±nbox,‚Ìˆê”Ô–Ú‚Æ?ÅŒã‚Ì?‡”Ô‚É‚È‚é‚æ‚¤‚É‚·‚é?B

        int saisyo_ni_suru = -10;
        for (int i = 1; i <= nbox.getsousuu() - 1; i++) {
            if ((getcolor(nbox.get_int(i)) == 0) &&
                    (getcolor(nbox.get_int(i + 1)) == 0)) {
                saisyo_ni_suru = i + 1;
            }
        }

        if ((getcolor(nbox.get_int(nbox.getsousuu())) == 0) &&
                (getcolor(nbox.get_int(1)) == 0)) {
            saisyo_ni_suru = 1;
        }

        if (saisyo_ni_suru < 0) {
            return 0;
        }//

        for (int i = 1; i <= saisyo_ni_suru - 1; i++) {
            nbox.jyunkai2wo1nisuru();
        }


        //System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
        //nbox.hyouji();

        //‚È‚ç‚×‚Î‚±nbox,‚Ìˆê”Ô–Ú‚Ì?Ü?ü‚ªxŽ²‚Æ‚È‚·Šp“x‚ª0‚É‚È‚é‚æ‚¤‚É‚·‚é?B
        Narabebako_int_double nbox1 = new Narabebako_int_double();

        double sasihiku_kakudo = nbox.get_double(1);
//System.out.println("sasihiku_kakudo="+sasihiku_kakudo);

        for (int i = 1; i <= nbox.getsousuu(); i++) {
            int_double i_d_0 = new int_double();
            i_d_0.set(nbox.get_i_d(i));
//System.out.println("i_d_0.get_d()="+i_d_0.get_d());


            i_d_0.set_d(
                    oc.kakudo_osame_0_360(i_d_0.get_d() - sasihiku_kakudo)
            );
            nbox1.add(i_d_0);
        }

        nbox.set(nbox1);

        //nbox.hyouji();


        while (nbox.getsousuu() > 2) {//“_‚©‚ç?o‚é?Ü?ü‚Ì?”‚ª2‚É‚È‚é‚Ü‚ÅŽÀ?s‚·‚é
            nbox1.set(kakutyou_fushimi_hantei_henbu_tejyun(nbox));
            //System.out.println("nbox1.getsousuu()="+nbox1.getsousuu()+",nbox.getsousuu()="+nbox.getsousuu());
            if (nbox1.getsousuu() == nbox.getsousuu()) {
                //System.out.println("20170216_14");
                return 0;
            }
            nbox.set(nbox1);
        }

        return 1;
    }


// -------------------------------------------------------

    public Narabebako_int_double kakutyou_fushimi_hantei_henbu_tejyun(Narabebako_int_double nbox0) {//Šg’£•šŒ©’è—?‚Ì‚æ‚¤‚É‚µ‚Ä•Ó•”‚Ì“_‚Å—×?Ú‚·‚é‚RŠp“x‚ð1‚Â‚ÌŠp“x‚É‚·‚é‚©•Ó•”‚ÌŠp‚ð?í‚é‘€?ì
        Narabebako_int_double nboxtemp = new Narabebako_int_double();
        Narabebako_int_double nbox1 = new Narabebako_int_double();
        int tikai_orisen_jyunban = 1;
        int tooi_orisen_jyunban = 2;

        double kakudo_min = 10000.0;
        double temp_kakudo;


        //Šp“x‚Ì?Å?¬’lkakudo_min‚ð‹?‚ß‚é
        for (int k = 1; k <= nbox0.getsousuu() - 1; k++) {//k‚ÍŠp“x‚Ì?‡”Ô
            temp_kakudo = nbox0.get_double(k + 1) - nbox0.get_double(k);
            if (temp_kakudo < kakudo_min) {
                kakudo_min = temp_kakudo;
            }
        }


        //k=1
        temp_kakudo = nbox0.get_double(2) - nbox0.get_double(1);
        if (Math.abs(temp_kakudo - kakudo_min) < 0.00001) {// ?Ü?ü‚ð1‚ÂŒ¸‚ç‚¹‚é?ðŒ?‚É“K?‡‚µ‚½‚Ì‚Å?A?V‚½‚Énbox1‚ð?ì‚Á‚ÄƒŠƒ^?[ƒ“‚·‚é?B
            for (int i = 2; i <= nbox0.getsousuu(); i++) {
                int_double i_d_0 = new int_double();
                i_d_0.set(nbox0.get_i_d(i));
                nbox1.add(i_d_0);
            }
            return nbox1;
        }

        //k=nbox0.getsousuu()-1
        temp_kakudo = nbox0.get_double(nbox0.getsousuu()) - nbox0.get_double(nbox0.getsousuu() - 1);
        if (Math.abs(temp_kakudo - kakudo_min) < 0.00001) {// ?Ü?ü‚ð1‚ÂŒ¸‚ç‚¹‚é?ðŒ?‚É“K?‡‚µ‚½‚Ì‚Å?A?V‚½‚Énbox1‚ð?ì‚Á‚ÄƒŠƒ^?[ƒ“‚·‚é?B
            for (int i = 1; i <= nbox0.getsousuu() - 1; i++) {
                int_double i_d_0 = new int_double();
                i_d_0.set(nbox0.get_i_d(i));
                nbox1.add(i_d_0);
            }
            return nbox1;
        }

        for (int k = 2; k <= nbox0.getsousuu() - 2; k++) {//k‚ÍŠp“x‚Ì?‡”Ô
            temp_kakudo = nbox0.get_double(k + 1) - nbox0.get_double(k);
            if (Math.abs(temp_kakudo - kakudo_min) < 0.00001) {
                if (getcolor(nbox0.get_int(k)) != getcolor(nbox0.get_int(k + 1))) {//‚±‚Ì?ê?‡‚É—×?Ú‚·‚é‚RŠp“x‚ð1‚Â‚ÌŠp“x‚É‚·‚é
                    // ?Ü?ü‚ð2‚ÂŒ¸‚ç‚¹‚é?ðŒ?‚É“K?‡‚µ‚½‚Ì‚Å?A?V‚½‚Énbox1‚ð?ì‚Á‚ÄƒŠƒ^?[ƒ“‚·‚é?B


                    double kijyun_kakudo = nbox0.get_double(3);
                    //System.out.println("?Ü?ü‚ð2‚ÂŒ¸‚ç‚¹‚é?ðŒ?‚É“K?‡‚µ‚½‚Ì‚Å?A?V‚½‚Énbox1‚ð?ì‚Á‚ÄƒŠƒ^?[ƒ“‚·‚é?B kijyun_kakudo="+kijyun_kakudo);


                    for (int i = 1; i <= k - 1; i++) {
                        int_double i_d_0 = new int_double();
                        i_d_0.set(nbox0.get_i_d(i));
                        nbox1.add(i_d_0);
                    }

                    for (int i = k + 2; i <= nbox0.getsousuu(); i++) {
                        int_double i_d_0 = new int_double();
                        i_d_0.set(nbox0.get_i_d(i));
                        i_d_0.set_d(
                                i_d_0.get_d() - 2.0 * kakudo_min
                        );
                        nbox1.add(i_d_0);
                    }

                    return nbox1;
                }
            }
        }

        // ?Ü?ü‚ðŒ¸‚ç‚¹‚é?ðŒ?‚É“K?‡‚µ‚½Šp‚ª‚È‚©‚Á‚½?ê?‡nbox0‚Æ‚¨‚È‚¶nbox1‚ð?ì‚Á‚ÄƒŠƒ^?[ƒ“‚·‚é?B
        for (int i = 1; i <= nbox0.getsousuu(); i++) {
            nbox1.add(nbox0.get_i_d(i));
        }
        return nbox1;
    }


// ***************************************************************

    double fushimi_hantei_kakudo_goukei = 360.0;
// ***************************************************************


    //Ten p ‚É?Å‚à‹ß‚¢—pŽ†“à•”‚Ì’[“_‚ªŠg’£•šŒ©’è—?‚ð–ž‚½‚·‚©”»’è
    public int kakutyou_fushimi_hantei_naibu(Ten p) {//return?@0=–ž‚½‚³‚È‚¢?A?@1=–ž‚½‚·?B?@
        double hantei_kyori = 0.00001;

        Ten t1 = new Ten();
        t1.set(mottomo_tikai_Ten_with_icol_0_1_2(p));//“_p‚É?Å‚à‹ß‚¢?A?u?ü•ª‚Ì’[“_?v‚ð•Ô‚·ori_s.mottomo_tikai_Ten‚Í‹ß‚¢“_‚ª‚È‚¢‚Æ p_return.set(100000.0,100000.0)‚Æ•Ô‚µ‚Ä‚­‚é

        //t1‚ð’[“_‚Æ‚·‚é?Ü?ü‚ðNarabebako‚É“ü‚ê‚é
        Narabebako_int_double nbox = new Narabebako_int_double();
        for (int i = 1; i <= getsousuu(); i++) {
            if ((0 <= getcolor(i)) && (getcolor(i) <= 2)) { //‚±‚Ì’iŠK‚Å•â?•Šˆ?ü‚Í?œ‚­
                if (t1.kyori(geta(i)) < hantei_kyori) {
                    nbox.ire_i_tiisaijyun(new int_double(i, oc.kakudo(geta(i), getb(i))));
                } else if (t1.kyori(getb(i)) < hantei_kyori) {
                    nbox.ire_i_tiisaijyun(new int_double(i, oc.kakudo(getb(i), geta(i))));
                }
            }
        }

        return kakutyou_fushimi_hantei_naibu(p, nbox);

    }

    public int kakutyou_fushimi_hantei_naibu(Ten p, Narabebako_int_double nbox) {//return?@0=–ž‚½‚³‚È‚¢?A?@1=–ž‚½‚·?B?@
        double hantei_kyori = 0.00001;

        if (nbox.getsousuu() % 2 == 1) {//t1‚ð’[“_‚Æ‚·‚é?Ü?ü‚Ì?”‚ªŠï?”‚Ì‚Æ‚«
            return 0;
        }


        int tikai_orisen_jyunban;
        int tooi_orisen_jyunban;
        if (nbox.getsousuu() == 2) {//t1‚ð’[“_‚Æ‚·‚é?Ü?ü‚Ì?”‚ª2‚Ì‚Æ‚«
            if (getcolor(nbox.get_int(1)) != getcolor(nbox.get_int(2))) {//2–{‚Ì?üŽí‚ªˆá‚¤‚È‚çŠp“xŠÖŒW‚È‚µ‚Éƒ_ƒ?
                //System.out.println("20170216_12");
                return 0;
            }

            //ˆÈ‰º‚Í2–{‚Ì?üŽí‚ª?Â?Â?A‚Ü‚½‚Í?Ô?Ô‚Ì?ê?‡
            int i_senbun_kousa_hantei;
            i_senbun_kousa_hantei = oc.senbun_kousa_hantei(get(nbox.get_int(1)), get(nbox.get_int(2)), 0.00001, 0.00001);
            if (i_senbun_kousa_hantei == 323) {
                return 1;
            }
            if (i_senbun_kousa_hantei == 333) {
                return 1;
            }
            if (i_senbun_kousa_hantei == 343) {
                return 1;
            }
            if (i_senbun_kousa_hantei == 353) {
                return 1;
            }

            //System.out.println("20170216_13");
            return 0;
        }

        //ˆÈ‰º‚Ít1‚ð’[“_‚Æ‚·‚é?Ü?ü‚Ì?”‚ª4ˆÈ?ã‚Ì‹ô?”‚Ì‚Æ‚«

        fushimi_hantei_kakudo_goukei = 360.0;

        Narabebako_int_double nbox1 = new Narabebako_int_double();

        while (nbox.getsousuu() > 2) {//“_‚©‚ç?o‚é?Ü?ü‚Ì?”‚ª2‚É‚È‚é‚Ü‚ÅŽÀ?s‚·‚é
            nbox1.set(kakutyou_fushimi_hantei_naibu_tejyun(nbox));
            //System.out.println("nbox1.getsousuu()="+nbox1.getsousuu()+",nbox.getsousuu()="+nbox.getsousuu());
            if (nbox1.getsousuu() == nbox.getsousuu()) {
                //System.out.println("20170216_14");
                return 0;
            }
            nbox.set(nbox1);
        }

        double temp_kakudo = oc.kakudo_osame_0_kmax(
                oc.kakudo_osame_0_kmax(nbox.get_double(1), fushimi_hantei_kakudo_goukei)
                        -
                        oc.kakudo_osame_0_kmax(nbox.get_double(2), fushimi_hantei_kakudo_goukei)
                , fushimi_hantei_kakudo_goukei
        );

        if (Math.abs(fushimi_hantei_kakudo_goukei - temp_kakudo * 2.0) < hantei_kyori) {
            return 1;
        }

        return 0;//‚±‚Ì0‚¾‚¯?AŠp“x‚ª‚¨‚©‚µ‚¢‚Æ‚¢‚¤ˆÓ–¡
    }


// ------------------------------------------------------------------------------------------------------------------------------------

    public Narabebako_int_double kakutyou_fushimi_hantei_naibu_tejyun(Narabebako_int_double nbox0) {//Šg’£•šŒ©’è—?‚Å—×?Ú‚·‚é‚RŠp“x‚ð1‚Â‚ÌŠp“x‚É‚·‚é‘€?ì
        Narabebako_int_double nboxtemp = new Narabebako_int_double();
        Narabebako_int_double nbox1 = new Narabebako_int_double();
        int tikai_orisen_jyunban = 1;
        int tooi_orisen_jyunban = 2;

        double kakudo_min = 10000.0;


        //System.out.println("•šŒ©”»’è?@’¸“_Žü‚è‚ÌŠp“x?‡Œv = "+fushimi_hantei_kakudo_goukei);
        //Šp“x‚Ì?Å?¬’lkakudo_min‚ð‹?‚ß‚é
        for (int k = 1; k <= nbox0.getsousuu(); k++) {//k‚ÍŠp“x‚Ì?‡”Ô
            tikai_orisen_jyunban = k;
            if (tikai_orisen_jyunban > nbox0.getsousuu()) {
                tikai_orisen_jyunban = tikai_orisen_jyunban - nbox0.getsousuu();
            }
            tooi_orisen_jyunban = k + 1;
            if (tooi_orisen_jyunban > nbox0.getsousuu()) {
                tooi_orisen_jyunban = tooi_orisen_jyunban - nbox0.getsousuu();
            }

            double temp_kakudo = oc.kakudo_osame_0_kmax(
                    oc.kakudo_osame_0_kmax(nbox0.get_double(tooi_orisen_jyunban), fushimi_hantei_kakudo_goukei)
                            -
                            oc.kakudo_osame_0_kmax(nbox0.get_double(tikai_orisen_jyunban), fushimi_hantei_kakudo_goukei)

                    , fushimi_hantei_kakudo_goukei
            );


            //System.out.println("Šp“x‚Ì–Ô—…?@"+k+"”Ô–Ú:  "+
            //nbox0.get_double(tooi_orisen_jyunban)+" - "+
            //nbox0.get_double(tikai_orisen_jyunban)+" = "+
            //temp_kakudo);


            if (temp_kakudo < kakudo_min) {
                kakudo_min = temp_kakudo;
            }
        }

        //System.out.println("kakudo_min="+kakudo_min);

        for (int k = 1; k <= nbox0.getsousuu(); k++) {//k‚ÍŠp“x‚Ì?‡”Ô
            double temp_kakudo = oc.kakudo_osame_0_kmax(nbox0.get_double(2) - nbox0.get_double(1), fushimi_hantei_kakudo_goukei);

            //System.out.println("k="+k+",temp_kakudo="+temp_kakudo);

            if (Math.abs(temp_kakudo - kakudo_min) < 0.00001) {
                //if(Math.abs(temp_kakudo-kakudo_min)<0.001){


                //System.out.println("   getcolor(nbox0.get_int(1))="+getcolor(nbox0.get_int(1))+",getcolor(nbox0.get_int(2))="+getcolor(nbox0.get_int(2)));
                if (getcolor(nbox0.get_int(1)) != getcolor(nbox0.get_int(2))) {//‚±‚Ì?ê?‡‚É—×?Ú‚·‚é‚RŠp“x‚ð1‚Â‚ÌŠp“x‚É‚·‚é
                    // ?Ü?ü‚ð2‚ÂŒ¸‚ç‚¹‚é?ðŒ?‚É“K?‡‚µ‚½‚Ì‚Å?A?V‚½‚Énbox1‚ð?ì‚Á‚ÄƒŠƒ^?[ƒ“‚·‚é?B


                    double kijyun_kakudo = nbox0.get_double(3);
                    //System.out.println("?Ü?ü‚ð2‚ÂŒ¸‚ç‚¹‚é?ðŒ?‚É“K?‡‚µ‚½‚Ì‚Å?A?V‚½‚Énbox1‚ð?ì‚Á‚ÄƒŠƒ^?[ƒ“‚·‚é?B kijyun_kakudo="+kijyun_kakudo);


                    for (int i = 1; i <= nbox0.getsousuu(); i++) {
                        int_double i_d_0 = new int_double();
                        i_d_0.set(nbox0.get_i_d(i));
                        //i_d_0.set_d(i_d_0.get_d ()- kijyun_kakudo );

                        i_d_0.set_d(
                                oc.kakudo_osame_0_kmax(i_d_0.get_d() - kijyun_kakudo, fushimi_hantei_kakudo_goukei)
                        );

                        //nbox1.add(nbox0.get_i_d(i));
                        nboxtemp.add(i_d_0);

                    }


                    for (int i = 3; i <= nboxtemp.getsousuu(); i++) {
                        int_double i_d_0 = new int_double();
                        i_d_0.set(nboxtemp.get_i_d(i));
                        //i_d_0.set_d(i_d_0.get_d ()- kijyun_kakudo );

                        //nbox1.add(nbox0.get_i_d(i));
                        nbox1.add(i_d_0);

                    }

                    fushimi_hantei_kakudo_goukei = fushimi_hantei_kakudo_goukei - 2.0 * kakudo_min;
                    return nbox1;
                }
            }
            nbox0.jyunkai2wo1nisuru();

        }

        // ?Ü?ü‚ð2‚ÂŒ¸‚ç‚¹‚é?ðŒ?‚É“K?‡‚µ‚½Šp‚ª‚È‚©‚Á‚½?ê?‡nbox0‚Æ‚¨‚È‚¶nbox1‚ð?ì‚Á‚ÄƒŠƒ^?[ƒ“‚·‚é?B
        for (int i = 1; i <= nbox0.getsousuu(); i++) {
            nbox1.add(nbox0.get_i_d(i));
        }
        return nbox1;
    }


    // ---------------------------
    public int X_koisa_ari_nasi(Senbun s0) {//s0‚ÆXŽš‚ÅŒð?·‚·‚é?Ü?ü‚ª‚ ‚ê‚Î1?A‚È‚¯‚ê‚Î0‚ð•Ô‚·
        for (int i = 1; i <= sousuu; i++) {
            if (oc.senbun_kousa_hantei(get(i), s0, 0.00001, 0.00001) == 1) {
                return 1;
            }
        }
        return 0;
    }


    // ---------------------------
    public double get_x_max() {//sousuu=0‚Ì‚Æ‚«‚Í0.0‚ð•Ô‚·
        if (sousuu == 0) {
            return 0.0;
        }
        double dm = getax(1);
        for (int i = 1; i <= sousuu; i++) {
            if (dm < getax(i)) {
                dm = getax(i);
            }
            if (dm < getbx(i)) {
                dm = getbx(i);
            }
        }
        return dm;
    }

    // ---------------------------
    public double get_x_min() {//sousuu=0‚Ì‚Æ‚«‚Í0.0‚ð•Ô‚·
        if (sousuu == 0) {
            return 0.0;
        }
        double dm = getax(1);
        for (int i = 1; i <= sousuu; i++) {
            if (dm > getax(i)) {
                dm = getax(i);
            }
            if (dm > getbx(i)) {
                dm = getbx(i);
            }
        }
        return dm;
    }

    // ---------------------------
// ---------------------------
    public double get_y_max() {//sousuu=0‚Ì‚Æ‚«‚Í0.0‚ð•Ô‚·
        if (sousuu == 0) {
            return 0.0;
        }
        double dm = getay(1);
        for (int i = 1; i <= sousuu; i++) {
            if (dm < getay(i)) {
                dm = getay(i);
            }
            if (dm < getby(i)) {
                dm = getby(i);
            }
        }
        return dm;
    }

    // ---------------------------
    public double get_y_min() {//sousuu=0‚Ì‚Æ‚«‚Í0.0‚ð•Ô‚·
        if (sousuu == 0) {
            return 0.0;
        }
        double dm = getay(1);
        for (int i = 1; i <= sousuu; i++) {
            if (dm > getay(i)) {
                dm = getay(i);
            }
            if (dm > getby(i)) {
                dm = getby(i);
            }
        }
        return dm;
    }
// ---------------------------


    // ---------------------------
    public int TL_koisa_ari_nasi(Senbun s0) {//s0‚ÆTŽš‚Ü‚½‚ÍLŽš‚ÅŒð?·‚·‚é?Ü?ü‚ª‚ ‚ê‚Î1?A‚È‚¯‚ê‚Î0‚ð•Ô‚·
        for (int i = 1; i <= sousuu; i++) {
            int i_senbun_kousa_hantei = oc.senbun_kousa_hantei(get(i), s0, 0.00001, 0.00001);
            if (i_senbun_kousa_hantei == 21) {
                return 1;
            }
            if (i_senbun_kousa_hantei == 22) {
                return 1;
            }
            if (i_senbun_kousa_hantei == 23) {
                return 1;
            }
            if (i_senbun_kousa_hantei == 24) {
                return 1;
            }
            if (i_senbun_kousa_hantei == 25) {
                return 1;
            }
            if (i_senbun_kousa_hantei == 26) {
                return 1;
            }
            if (i_senbun_kousa_hantei == 27) {
                return 1;
            }
            if (i_senbun_kousa_hantei == 28) {
                return 1;
            }
        }
        return 0;
    }


}