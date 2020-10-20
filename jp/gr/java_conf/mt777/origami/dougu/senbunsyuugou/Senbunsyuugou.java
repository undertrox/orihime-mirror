package jp.gr.java_conf.mt777.origami.dougu.senbunsyuugou;

import jp.gr.java_conf.mt777.kiroku.memo.Memo;
import jp.gr.java_conf.mt777.zukei2d.oritacalc.OritaCalc;
import jp.gr.java_conf.mt777.zukei2d.senbun.Senbun;
import jp.gr.java_conf.mt777.zukei2d.ten.Ten;

import java.util.ArrayList;
import java.util.StringTokenizer;

// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
public class Senbunsyuugou {
    int sousuu;               //実?ﾛに使う??分の????
    ArrayList Senb = new ArrayList(); //??分のインスタンス化
    OritaCalc oc = new OritaCalc();          //各種計算用の関?狽gうためのクラスのインスタンス化

    public Senbunsyuugou() {
        reset();
    } //コンストラクタ

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
        }//この文がないとうまく?sかない?Bなぜこの文でないといけないかという??由が?ｳ確にはわからない?B
        return (Senbun) Senb.get(i);
    }

    //
    private void senset(int i, Senbun s) {
        if (sousuu + 1 > Senb.size()) {
            while (sousuu + 1 > Senb.size()) {
                Senb.add(new Senbun());
            }
        }//この文がないとうまく?sかない?Bなぜこの文でないといけないかという??由が?ｳ確にはわからない?B
        if (i + 1 <= Senb.size()) {
            Senb.set(i, s);
        } //なぜか?Aこのifがないとうまく?sかない
    }

    //??分の???狽ｾる
    public int getsousuu() {
        return sousuu;
    }

    public void setsousuu(int i) {
        sousuu = i;
    }

    //??分を得る
    public Senbun get(int i) {
        //Senbun s;s= sen(i);return s;
        return sen(i);
    }

    //i番目の??分の端点を得る
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

    //i番目の??分の端点を得る
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

    //i番目の??分の端点の位置をセットする
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

    //i番目の??分の値を入力する
    public void set(int i, Ten p, Ten q, int ic, int ia) {
        Senbun s;
        s = sen(i);
        s.set(p, q, ic, ia);
    }

    //i番目の??分の?Fを入力する
    public void setcolor(int i, int icol) {
        Senbun s;
        s = sen(i);
        s.setcolor(icol);
    }

    //i番目の??分の?Fを?o力する
    public int getcolor(int i) {
        Senbun s;
        s = sen(i);
        return s.getcolor();
    }

    //i番目の??分の活?ｫを?o力する
    public int getiactive(int i) {
        Senbun s;
        s = sen(i);
        return s.getiactive();
    }

    //??分?W?№ﾌ全??分の?﨣? Memoとして?o力する?B
    public Memo getMemo() {
        String str = "";//文字列????用のクラスのインスタンス化

        Memo memo1 = new Memo();
        memo1.reset();
        memo1.addGyou("<??分?W??>");

        for (int i = 1; i <= sousuu; i++) {
            memo1.addGyou("番??," + i);
            Senbun s;
            s = sen(i);
            memo1.addGyou("?F," + s.getcolor());
            memo1.addGyou("?ﾀ標," + s.getax() + "," + s.getay() + "," +
                    s.getbx() + "," + s.getby());


        }


        return memo1;
    }

    //-----------------------------
    public void setMemo(Memo memo1) {
        int yomiflg = 0;//0なら読み?桙ﾝを?sわない?B1なら読み?桙ﾞ?B
        int ibangou = 0;
        int ic = 0;

        String st = "";
        Double Dd = new Double(0.0);
        Integer Ii = new Integer(0);

        double ax, ay, bx, by;
        String str = "";
        //int jtok;

//オリヒ??用ファイル.orhを読む

//?ﾅ?奄ﾉ??分の???狽?める
        int isen = 0;
        for (int i = 1; i <= memo1.getGyousuu(); i++) {


            StringTokenizer tk = new StringTokenizer(memo1.getGyou(i), ",");
            //jtok=    tk.countTokens();


            str = tk.nextToken();
            if (str.equals("<??分?W??>")) {
                yomiflg = 1;
            }

            if ((yomiflg == 1) && (str.equals("番??"))) {
                isen = isen + 1;

            }
        }

        sousuu = isen;
//?ﾅ?奄ﾉ??分の???狽ｪ??められた
        //

        for (int i = 1; i <= memo1.getGyousuu(); i++) {


            StringTokenizer tk = new StringTokenizer(memo1.getGyou(i), ",");
            //jtok=    tk.countTokens();
            str = tk.nextToken();
            //  	System.out.println("::::::::::"+ str+"<<<<<" );

            if (str.equals("<??分?W??>")) {
                yomiflg = 1;
            }

            if ((yomiflg == 1) && (str.equals("番??"))) {
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
            if ((yomiflg == 1) && (str.equals("?ﾀ標"))) {
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

    //展開?}入力時の??分?W?№ﾌ?ｮ??

    public void bunkatu_seiri() {//?ﾜり?ﾝ??定などで得られる?j金?}の?ｮ??
        System.out.println("分割?ｮ???@１?A点????");
        ten_sakujyo();          //念のため?A点?ﾌ??分を?怩ｭ
        System.out.println("分割?ｮ???@２?A?d複??分????");
        jyuufuku_senbun_sakujyo();//念のため?A全く一致する??分が２つあれば１つを?怩ｭ
        System.out.println("分割?ｮ???@３?A交?ｷ分割");
        kousabunkatu();
        System.out.println("分割?ｮ???@４?A点????");
        ten_sakujyo();             //?ﾜり?ﾝ??定の?j金?}の?ｮ??のため?A点?ﾌ??分を?怩ｭ
        System.out.println("分割?ｮ???@５?A?d複??分????");
        jyuufuku_senbun_sakujyo(); //?ﾜり?ﾝ??定の?j金?}の?ｮ??のため?A全く一致する??分が２つあれば１つを?怩ｭ
    }


    //全??分の山谷を入れ替える?B境界??等の山谷以外の??種は変化なし?B
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


    //Smenを発?ｶさせるための??分?W?№ﾌ?ｮ??

    public void bunkatu_seiri_for_Smen_hassei() {//?ﾜり?ﾝ??定などで得られる?j金?}の?ｮ??
        System.out.println("?@?@Senbunsyuugouの中で?ASmenを発?ｶさせるための??分?W?№ﾌ?ｮ??");
        System.out.println("分割?ｮ???@１?A点???恆O	getsousuu() = " + getsousuu());
        ten_sakujyo();          //念のため?A点?ﾌ??分を?怩ｭ
        System.out.println("分割?ｮ???@２?A?d複??分???恆O	getsousuu() = " + getsousuu());
        jyuufuku_senbun_sakujyo();//念のため?A全く一致する??分が２つあれば１つを?怩ｭ
        System.out.println("分割?ｮ???@３?A交?ｷ分割前	getsousuu() = " + getsousuu());
        kousabunkatu();
        System.out.println("分割?ｮ???@４?A点???恆O	getsousuu() = " + getsousuu());
        ten_sakujyo();             //?ﾜり?ﾝ??定の?j金?}の?ｮ??のため?A点?ﾌ??分を?怩ｭ
        System.out.println("分割?ｮ???@５?A?d複??分???恆O	getsousuu() = " + getsousuu());
        jyuufuku_senbun_sakujyo(); //?ﾜり?ﾝ??定の?j金?}の?ｮ??のため?A全く一致する??分が２つあれば１つを?怩ｭ
        System.out.println("分割?ｮ???@５?A?d複??分???恁?	getsousuu() = " + getsousuu());
    }


    //点?ﾌ??分を????
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

    // 全く?dなる??分が2本存?ﾝするときに番??の遅いほうを???怩ｷる?B
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
    public int jyuufuku_senbun_sakujyo(int i, int j) {    //?d複の???怩ｵたら1?Aしなければ0を返す
        if (i == j) {
            return 0;
        }
        Senbun si;
        si = sen(i);
        Senbun sj;
        sj = sen(j);
        if (oc.senbun_kousa_hantei(si, sj) == 31) {  //31はsiとsjが全く同じに?dなることを示す
            delsenbun(j);
            return 1;
        }
        return 0;
    }

    //交?ｷしている２つの??分の交点で２つの??分を分割する?B?@まったく?dなる??分が２つあった???№ﾍ?Aなんの????もなされないまま２つとも残る?B
    public void kousabunkatu() {
        int ibunkatu = 1;//分割があれば1?Aなければ0

        ArrayList k_flg = new ArrayList();//交?ｷ分割の影響があることを示すフラッグ?B

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

    //交?ｷしている２つの??分の交点で２つの??分を分割する?B分割を?sったら1?B?sわなかったら0を返す?Bオリヒ??2.002から分割後の??の?Fも?ｧ御するようにした(?d複部がある???№ﾍ一本化し?A番??の遅いほうの?Fになる)?B
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

        //oc.senbun_kousa_hantei(si,sj)が21から24まではくの字型の交?ｷで?Aなにもしない?B

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
        if (oc.senbun_kousa_hantei(si, sj) == 31) {//2つの??分がまったく同じ???№ﾍ?A何もしない?B
            return 0;
        }


        if (oc.senbun_kousa_hantei(si, sj) == 321) {//2つの??分の端点どうし(p1とp3)が1点で?dなる?Bsiにsjが含まれる
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

        if (oc.senbun_kousa_hantei(si, sj) == 322) {//2つの??分の端点どうし(p1とp3)が1点で?dなる?Bsjにsiが含まれる
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

        if (oc.senbun_kousa_hantei(si, sj) == 331) {//2つの??分の端点どうし(p1とp4)が1点で?dなる?Bsiにsjが含まれる
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

        if (oc.senbun_kousa_hantei(si, sj) == 332) {//2つの??分の端点どうし(p1とp4)が1点で?dなる?Bsjにsiが含まれる
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

        if (oc.senbun_kousa_hantei(si, sj) == 341) {//2つの??分の端点どうし(p2とp3)が1点で?dなる?Bsiにsjが含まれる
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

        if (oc.senbun_kousa_hantei(si, sj) == 342) {//2つの??分の端点どうし(p2とp3)が1点で?dなる?Bsjにsiが含まれる
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

        if (oc.senbun_kousa_hantei(si, sj) == 351) {//2つの??分の端点どうし(p2とp4)が1点で?dなる?Bsiにsjが含まれる


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

        if (oc.senbun_kousa_hantei(si, sj) == 352) {//2つの??分の端点どうし(p2とp4)が1点で?dなる?Bsjにsiが含まれる
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


        if (oc.senbun_kousa_hantei(si, sj) == 361) {//p1-p3-p4-p2の??
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

        if (oc.senbun_kousa_hantei(si, sj) == 362) {//p1-p4-p3-p2の??
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

        if (oc.senbun_kousa_hantei(si, sj) == 363) {//p3-p1-p2-p4の??
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

        if (oc.senbun_kousa_hantei(si, sj) == 364) {//p3-p2-p1-p4の??
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
        if (oc.senbun_kousa_hantei(si, sj) == 371) {//p1-p3-p2-p4の??
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

        if (oc.senbun_kousa_hantei(si, sj) == 372) {//p1-p4-p2-p3の??
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

        if (oc.senbun_kousa_hantei(si, sj) == 373) {//p3-p1-p4-p2の??
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

        if (oc.senbun_kousa_hantei(si, sj) == 374) {//p4-p1-p3-p2の??
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


    //??分の追加-------------------------------
    public void addsenbun(Ten pi, Ten pj, int i_c) {
        sousuu++;

        Senbun s;
        s = sen(sousuu);
        s.set(pi, pj, i_c);
    }

    //??分の追加-------------------------------
    public void addsenbun(double ax, double ay, double bx, double by, int ic) {
        sousuu++;

        Senbun s;
        s = sen(sousuu);
        s.set(ax, ay, bx, by, ic);
    }

    //??分の追加-------------------------------
    public void addsenbun(Ten pi, Ten pj) {
        sousuu++;

        Senbun s;
        s = sen(sousuu);

        s.seta(pi);
        s.setb(pj);
    }

    //??分の????-----------------------------------------
    public void delsenbun(int j) {   //j番目の??分を???怩ｷる
        for (int i = j; i <= sousuu - 1; i++) {
            Senbun si;
            si = sen(i);
            Senbun si1;
            si1 = sen(i + 1);
            si.set(si1);

        }
        sousuu--;
    }

    //i番目の??分の長さを得る---------------------------
    public double getnagasa(int i) {
        Senbun s;
        s = sen(i);
        return s.getnagasa();
    }

    //閉多角形を形?ｬせず?A枝?ﾉなっている??分を???怩ｷる?B
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

    //一本だけの離れてある??分を???怩ｷる?B
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


    //点pに近い(r以内)??分をさがし?Aその番??を返す関??(ただし?Aj番目の??分は対?ﾛ外)?B近い??分がなければ?A0を返す---------------------------------
    //もし対?ﾛ外にする??分が無い???№ﾍ?Ajを0とか負の?ｮ?狽ﾆかにする?B
    //070317?@追加機能?@j?@が?@-10?@の時は?@活?ｫ化していない枝?igetiactive(i)が0?jを対?ﾛにする?B

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


    //点pが指定された??分とどの部?鰍ﾅ近い(r以内)かどうかを判定する関???@---------------------------------
    //0=近くない?A1=a点に近い?A2=b点に近い?A3=柄の部分に近い
    public int senbun_busyo_sagasi(int i, Ten p, double r) {
        if (r > oc.kyori(p, geta(i))) {
            return 1;
        }//a点に近いかどうか
        if (r > oc.kyori(p, getb(i))) {
            return 2;
        }//b点に近いかどうか
        if (r > oc.kyori_senbun(p, get(i))) {
            return 3;
        }//柄の部分に近いかどうか
        return 0;
    }


    //点pに?ﾅも近い??分の番??を返す
    public int mottomo_tikai_senbun_sagasi(Ten p) {
        int minrid = 0;
        double minr = 100000;
        for (int i = 1; i <= sousuu; i++) {
            double sk = oc.kyori_senbun(p, get(i));
            if (minr > sk) {
                minr = sk;
                minrid = i;
            }//柄の部分に近いかどうか

        }
        return minrid;
    }


    //点pに?ﾅも近い??分の端点を返す
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


    //点pの近くの??分の活?ｫ化
    public void kasseika(Ten p, double r) {
        for (int i = 1; i <= sousuu; i++) {
            Senbun si;
            si = sen(i);
            si.kasseika(p, r);
        }
    }

    //全??分の非活?ｫ化
    public void hikasseika() {
        for (int i = 1; i <= sousuu; i++) {
            Senbun si;
            si = sen(i);
            si.hikasseika();
        }
    }


    //??分の活?ｫ化されたものを点pの?ﾀ標にする
    public void set(Ten p) {
        for (int i = 1; i <= sousuu; i++) {
            Senbun si;
            si = sen(i);
            si.set(p);
        }

    }

    //??分?W?№ﾌ中の??分i0と?Ai0以外で?A全く?dなる??分があれば?Aその番??を返す?Bなければ-10を返す?B
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