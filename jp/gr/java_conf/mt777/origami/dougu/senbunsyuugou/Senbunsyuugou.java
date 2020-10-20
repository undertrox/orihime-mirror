package jp.gr.java_conf.mt777.origami.dougu.senbunsyuugou;

import jp.gr.java_conf.mt777.kiroku.memo.Memo;
import jp.gr.java_conf.mt777.zukei2d.oritacalc.OritaCalc;
import jp.gr.java_conf.mt777.zukei2d.senbun.Senbun;

import java.util.ArrayList;
import java.util.StringTokenizer;

// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
public class Senbunsyuugou {
    int sousuu;               //ŽÀ?Û‚ÉŽg‚¤?ü•ª‚Ì‘??”
    ArrayList Senb = new ArrayList(); //?ü•ª‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»
    OritaCalc oc = new OritaCalc();          //ŠeŽíŒvŽZ—p‚ÌŠÖ?”‚ðŽg‚¤‚½‚ß‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»

    public Senbunsyuugou() {
        reset();
    } //ƒRƒ“ƒXƒgƒ‰ƒNƒ^

    public void reset() {
        sousuu = 0;
        Senb.clear();
        Senb.add(new Senbun());
    }

    public void set(Senbunsyuugou ss) {
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

    //i”Ô–Ú‚Ì?ü•ª‚ÌŠˆ?«‚ð?o—Í‚·‚é
    public int getiactive(int i) {
        Senbun s;
        s = sen(i);
        return s.getiactive();
    }

    //?ü•ª?W?‡‚Ì‘S?ü•ª‚Ì?î•ñ‚ð Memo‚Æ‚µ‚Ä?o—Í‚·‚é?B
    public Memo getMemo() {
        String str = "";//•¶Žš—ñ?ˆ—?—p‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»

        Memo memo1 = new Memo();
        memo1.reset();
        memo1.addGyou("<?ü•ª?W?‡>");

        for (int i = 1; i <= sousuu; i++) {
            memo1.addGyou("”Ô?†," + i);
            Senbun s;
            s = sen(i);
            memo1.addGyou("?F," + str.valueOf(s.getcolor()));
            memo1.addGyou("?À•W," + str.valueOf(s.getax()) + "," + str.valueOf(s.getay()) + "," +
                    str.valueOf(s.getbx()) + "," + str.valueOf(s.getby()));


        }


        return memo1;
    }

    //-----------------------------
    public void setMemo(Memo memo1) {
        int yomiflg = 0;//0‚È‚ç“Ç‚Ý?ž‚Ý‚ð?s‚í‚È‚¢?B1‚È‚ç“Ç‚Ý?ž‚Þ?B
        int ibangou = 0;
        int ic = 0;

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
            if (str.equals("<?ü•ª?W?‡>")) {
                yomiflg = 1;
            }

            if ((yomiflg == 1) && (str.equals("”Ô?†"))) {
                isen = isen + 1;

            }
        }

        sousuu = isen;
//?Å?‰‚É?ü•ª‚Ì‘??”‚ª‹?‚ß‚ç‚ê‚½
        //

        for (int i = 1; i <= memo1.getGyousuu(); i++) {


            StringTokenizer tk = new StringTokenizer(memo1.getGyou(i), ",");
            //jtok=    tk.countTokens();
            str = tk.nextToken();
            //  	System.out.println("::::::::::"+ str+"<<<<<" );

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
        }
    }

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
        System.out.println("?@?@Senbunsyuugou‚Ì’†‚Å?ASmen‚ð”­?¶‚³‚¹‚é‚½‚ß‚Ì?ü•ª?W?‡‚Ì?®—?");
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
    public void kousabunkatu() {
        int ibunkatu = 1;//•ªŠ„‚ª‚ ‚ê‚Î1?A‚È‚¯‚ê‚Î0

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

        if (oc.senbun_kousa_hantei(si, sj) == 25) {
            pk.set(oc.kouten_motome(si, sj));    //<<<<<<<<<<<<<<<<<<<<<<<
            sj.seta(p3);
            sj.setb(pk);
            addsenbun(p4, pk, sj.getcolor());
            return 1;
        }

        if (oc.senbun_kousa_hantei(si, sj) == 26) {
            pk.set(oc.kouten_motome(si, sj));    //<<<<<<<<<<<<<<<<<<<<<<<
            sj.seta(p3);
            sj.setb(pk);
            addsenbun(p4, pk, sj.getcolor());
            return 1;
        }

        if (oc.senbun_kousa_hantei(si, sj) == 27) {
            pk.set(oc.kouten_motome(si, sj));    //<<<<<<<<<<<<<<<<<<<<<<<
            si.seta(p1);
            si.setb(pk);
            addsenbun(p2, pk, si.getcolor());
            return 1;
        }

        if (oc.senbun_kousa_hantei(si, sj) == 28) {
            pk.set(oc.kouten_motome(si, sj));    //<<<<<<<<<<<<<<<<<<<<<<<
            si.seta(p1);
            si.setb(pk);
            addsenbun(p2, pk, si.getcolor());
            return 1;
        }
        //
        if (oc.senbun_kousa_hantei(si, sj) == 31) {//2‚Â‚Ì?ü•ª‚ª‚Ü‚Á‚½‚­“¯‚¶?ê?‡‚Í?A‰½‚à‚µ‚È‚¢?B
            return 0;
        }


        if (oc.senbun_kousa_hantei(si, sj) == 321) {//2‚Â‚Ì?ü•ª‚Ì’[“_‚Ç‚¤‚µ(p1‚Æp3)‚ª1“_‚Å?d‚È‚é?Bsi‚Ésj‚ªŠÜ‚Ü‚ê‚é
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


    //?ü•ª‚Ì’Ç‰Á-------------------------------
    public void addsenbun(Ten pi, Ten pj, int i_c) {
        sousuu++;

        Senbun s;
        s = sen(sousuu);
        s.set(pi, pj, i_c);
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

    //?ü•ª‚Ì?í?œ-----------------------------------------
    public void delsenbun(int j) {   //j”Ô–Ú‚Ì?ü•ª‚ð?í?œ‚·‚é
        for (int i = j; i <= sousuu - 1; i++) {
            Senbun si;
            si = sen(i);
            Senbun si1;
            si1 = sen(i + 1);
            si.set(si1);

        }
        sousuu--;
    }

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
                delsenbun(i);
                i = 1;
            }
        }
    }

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


    //“_p‚É?Å‚à‹ß‚¢?ü•ª‚Ì’[“_‚ð•Ô‚·
    public Ten mottomo_tikai_Ten_sagasi(Ten p) {

        Ten p_return = new Ten();
        p_return.set(100000.0, 100000.0);
        Ten p_temp = new Ten();
        for (int i = 1; i <= sousuu; i++) {
            p_temp.set(geta(i));
            if (p.kyori2jyou(p_temp) < p.kyori2jyou(p_return)) {
                p_return.set(p_temp.getx(), p_temp.gety());
            }
            p_temp.set(getb(i));
            if (p.kyori2jyou(p_temp) < p.kyori2jyou(p_return)) {
                p_return.set(p_temp.getx(), p_temp.gety());
            }
            //p_temp.set(geta(i));if(p.kyori(p_temp)<p.kyori(p_return) ) {p_return.set(p_temp.getx(),p_temp.gety()); }
            //p_temp.set(getb(i));if(p.kyori(p_temp)<p.kyori(p_return) ) {p_return.set(p_temp.getx(),p_temp.gety()); }

        }
        return p_return;
    }


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


}