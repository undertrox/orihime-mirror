package jp.gr.java_conf.mt777.origami.dougu.orisensyuugou;

import jp.gr.java_conf.mt777.kiroku.memo.Memo;
import jp.gr.java_conf.mt777.seiretu.narabebako.Narabebako_int_double;
import jp.gr.java_conf.mt777.seiretu.narabebako.int_double;
import jp.gr.java_conf.mt777.zukei2d.en.En;
import jp.gr.java_conf.mt777.zukei2d.oritacalc.OritaCalc;
import jp.gr.java_conf.mt777.zukei2d.oritacalc.tyokusen.Tyokusen;
import jp.gr.java_conf.mt777.zukei2d.senbun.Senbun;
import jp.gr.java_conf.mt777.zukei2d.takakukei.Takakukei;
import jp.gr.java_conf.mt777.zukei2d.ten.Ten;

import java.awt.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
public class Orisensyuugou {
    int sousuu;               //実?ﾛに使う??分の????
    ArrayList Senb = new ArrayList(); //?ﾜ??とする??分のインスタンス化
    OritaCalc oc = new OritaCalc();          //各種計算用の関?狽gうためのクラスのインスタンス化

    ArrayList Check1Senb = new ArrayList(); //check?﨣i納する??分のインスタンス化
    ArrayList Check2Senb = new ArrayList(); //check?﨣i納する??分のインスタンス化
    ArrayList Check3Senb = new ArrayList(); //check?﨣i納する??分のインスタンス化
    ArrayList Check4Senb = new ArrayList(); //check?﨣i納する??分のインスタンス化
    ArrayList Check4Ten = new ArrayList(); //checkすべき点のインスタンス化


    ArrayList Cir = new ArrayList(); //円のインスタンス化

    public Orisensyuugou() {
        reset();
    } //コンストラクタ

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


    //i番目の??分をセットする
    //public void set(int i,Senbun s0){Senbun s;s= sen(i);s.set(s0);}

    //i番目の??分の値を入力する
    public void set(int i, Ten p, Ten q) {
        Senbun s;
        s = sen(i);
        s.seta(p);
        s.setb(q);
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

    //i番目の??分の活?ｫを入力する
    public void setiactive(int i, int iactive) {
        Senbun s;
        s = sen(i);
        s.setiactive(iactive);
    }


    //i番目の??分の活?ｫを?o力する
    public int getiactive(int i) {
        Senbun s;
        s = sen(i);
        return s.getiactive();
    }

    //-----------------------------
    //??分?W?№ﾌ全??分の?﨣? Memoとして?o力する?B
    public Memo getMemo() {
        return getMemo("_");
    }

    //-----------------------------
    //??分?W?№ﾌ全??分の?﨣? Memoとして?o力する?B //undo,redoの記録用に使う
    public Memo getMemo(String s_title) {
        String str = "";//文字列????用のクラスのインスタンス化

        Memo memo1 = new Memo();
        memo1.reset();


        memo1.addGyou("<タイトル>");
        memo1.addGyou("タイトル," + s_title);


        memo1.addGyou("<??分?W??>");

        for (int i = 1; i <= sousuu; i++) {
            memo1.addGyou("番??," + i);
            Senbun s;
            s = sen(i);
            memo1.addGyou("?F," + str.valueOf(s.getcolor()));

            memo1.addGyou("<tpp>" + str.valueOf(s.get_tpp()) + "</tpp>");                    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            memo1.addGyou("<tpp_color_R>" + str.valueOf(s.get_tpp_color().getRed()) + "</tpp_color_R>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            memo1.addGyou("<tpp_color_G>" + str.valueOf(s.get_tpp_color().getGreen()) + "</tpp_color_G>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            memo1.addGyou("<tpp_color_B>" + str.valueOf(s.get_tpp_color().getBlue()) + "</tpp_color_B>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

            memo1.addGyou("?ﾀ標," + str.valueOf(s.getax()) + "," + str.valueOf(s.getay()) + "," + str.valueOf(s.getbx()) + "," + str.valueOf(s.getby()));
        }

        memo1.addGyou("<円?W??>");
        for (int i = 1; i <= cir_size(); i++) {
            memo1.addGyou("番??," + i);
            En e_temp = new En();
            e_temp.set(cir_getEn(i));
            memo1.addGyou("中?Sと半径と?F," + str.valueOf(e_temp.getx()) + "," + str.valueOf(e_temp.gety()) + "," + str.valueOf(e_temp.getr()) + "," + str.valueOf(e_temp.getcolor()));

            memo1.addGyou("<tpp>" + str.valueOf(e_temp.get_tpp()) + "</tpp>");                    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            memo1.addGyou("<tpp_color_R>" + str.valueOf(e_temp.get_tpp_color().getRed()) + "</tpp_color_R>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            memo1.addGyou("<tpp_color_G>" + str.valueOf(e_temp.get_tpp_color().getGreen()) + "</tpp_color_G>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            memo1.addGyou("<tpp_color_B>" + str.valueOf(e_temp.get_tpp_color().getBlue()) + "</tpp_color_B>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


        }


        return memo1;
    }


//-----------------------------


    //??分?W?№ﾌ全??分の?﨣? Memoとして?o力する?B//iactiveがijyogaiの?ﾜ??は??モに?曹ｫ?oさない
    public Memo getMemo_iactive_jyogai(int ijyogai) {
        String str = "";//文字列????用のクラスのインスタンス化

        Memo memo1 = new Memo();
        memo1.reset();
        memo1.addGyou("<??分?W??>");

        int ibangou = 0;
        for (int i = 1; i <= sousuu; i++) {
            if (getiactive(i) != ijyogai) {
                ibangou = ibangou + 1;
                memo1.addGyou("番??," + ibangou);
                Senbun s;
                s = sen(i);
                memo1.addGyou("?F," + str.valueOf(s.getcolor()));

                memo1.addGyou("<tpp>" + str.valueOf(s.get_tpp()) + "</tpp>");                    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                memo1.addGyou("<tpp_color_R>" + str.valueOf(s.get_tpp_color().getRed()) + "</tpp_color_R>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                memo1.addGyou("<tpp_color_G>" + str.valueOf(s.get_tpp_color().getGreen()) + "</tpp_color_G>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                memo1.addGyou("<tpp_color_B>" + str.valueOf(s.get_tpp_color().getBlue()) + "</tpp_color_B>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


                memo1.addGyou("選択," + str.valueOf(s.get_i_select()));
                memo1.addGyou("?ﾀ標," + str.valueOf(s.getax()) + "," + str.valueOf(s.getay()) + "," + str.valueOf(s.getbx()) + "," + str.valueOf(s.getby()));
            }
        }

        memo1.addGyou("<円?W??>");
        for (int i = 1; i <= cir_size(); i++) {
            memo1.addGyou("番??," + i);
            En e_temp = new En();
            e_temp.set(cir_getEn(i));
            //memo1.addGyou( "?F,"+str.valueOf(e_temp.getcolor()));
            memo1.addGyou("中?Sと半径と?F," + str.valueOf(e_temp.getx()) + "," + str.valueOf(e_temp.gety()) + "," + str.valueOf(e_temp.getr()) + "," + str.valueOf(e_temp.getcolor()));

            memo1.addGyou("<tpp>" + str.valueOf(e_temp.get_tpp()) + "</tpp>");                    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            memo1.addGyou("<tpp_color_R>" + str.valueOf(e_temp.get_tpp_color().getRed()) + "</tpp_color_R>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            memo1.addGyou("<tpp_color_G>" + str.valueOf(e_temp.get_tpp_color().getGreen()) + "</tpp_color_G>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            memo1.addGyou("<tpp_color_B>" + str.valueOf(e_temp.get_tpp_color().getBlue()) + "</tpp_color_B>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


        }


        return memo1;
    }


    //-----------------------------
    //補?負???分?W?№ﾌ全??分の?﨣? Memoとして?o力する?B
    public Memo h_getMemo() {
        String str = "";//文字列????用のクラスのインスタンス化

        Memo memo1 = new Memo();
        memo1.reset();
        memo1.addGyou("<補????分?W??>");

        for (int i = 1; i <= sousuu; i++) {
            memo1.addGyou("補?部ﾔ??," + i);
            Senbun s;
            s = sen(i);
            memo1.addGyou("補???F," + str.valueOf(s.getcolor()));

            memo1.addGyou("<tpp>" + str.valueOf(s.get_tpp()) + "</tpp>");                    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            memo1.addGyou("<tpp_color_R>" + str.valueOf(s.get_tpp_color().getRed()) + "</tpp_color_R>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            memo1.addGyou("<tpp_color_G>" + str.valueOf(s.get_tpp_color().getGreen()) + "</tpp_color_G>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            memo1.addGyou("<tpp_color_B>" + str.valueOf(s.get_tpp_color().getBlue()) + "</tpp_color_B>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

            memo1.addGyou("補???ﾀ標," + str.valueOf(s.getax()) + "," + str.valueOf(s.getay()) + "," + str.valueOf(s.getbx()) + "," + str.valueOf(s.getby()));
        }
        return memo1;
    }

    //-----------------------------
    //?ﾜ?ﾝ??定用に??分?W?№ﾌ?﨣? Memoとして?o力する?B//icolが3(cyan?????F)以?繧ﾌ補????は??モに?曹ｫ?oさない
    public Memo getMemo_for_oritatami() {
        String str = "";//文字列????用のクラスのインスタンス化

        Memo memo1 = new Memo();
        memo1.reset();
        memo1.addGyou("<??分?W??>");

        int ibangou = 0;
        for (int i = 1; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);
            if (s.getcolor() < 3) {
                ibangou = ibangou + 1;
                memo1.addGyou("番??," + ibangou);

                memo1.addGyou("?F," + str.valueOf(s.getcolor()));

                memo1.addGyou("<tpp>" + str.valueOf(s.get_tpp()) + "</tpp>");                    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                memo1.addGyou("<tpp_color_R>" + str.valueOf(s.get_tpp_color().getRed()) + "</tpp_color_R>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                memo1.addGyou("<tpp_color_G>" + str.valueOf(s.get_tpp_color().getGreen()) + "</tpp_color_G>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                memo1.addGyou("<tpp_color_B>" + str.valueOf(s.get_tpp_color().getBlue()) + "</tpp_color_B>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


                memo1.addGyou("?ﾀ標," + str.valueOf(s.getax()) + "," + str.valueOf(s.getay()) + "," + str.valueOf(s.getbx()) + "," + str.valueOf(s.getby()));
            }
        }
        return memo1;
    }

    //-----------------------------
    //?ﾜ?ﾝ??定用にselectされた??分?W?№ﾌ?﨣? Memoとして?o力する?B//icolが3(cyan?????F)以?繧ﾌ補????は??モに?曹ｫ?oさない
    public Memo getMemo_for_select_oritatami() {
        String str = "";//文字列????用のクラスのインスタンス化
//ggggggggggggggg
        Memo memo1 = new Memo();
        memo1.reset();
        memo1.addGyou("<??分?W??>");

        int ibangou = 0;
        for (int i = 1; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);
            if ((s.getcolor() < 3) && (s.get_i_select() == 2)) {
                ibangou = ibangou + 1;
                memo1.addGyou("番??," + ibangou);

                memo1.addGyou("?F," + str.valueOf(s.getcolor()));

                memo1.addGyou("<tpp>" + str.valueOf(s.get_tpp()) + "</tpp>");                    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                memo1.addGyou("<tpp_color_R>" + str.valueOf(s.get_tpp_color().getRed()) + "</tpp_color_R>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                memo1.addGyou("<tpp_color_G>" + str.valueOf(s.get_tpp_color().getGreen()) + "</tpp_color_G>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                memo1.addGyou("<tpp_color_B>" + str.valueOf(s.get_tpp_color().getBlue()) + "</tpp_color_B>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


                memo1.addGyou("?ﾀ標," + str.valueOf(s.getax()) + "," + str.valueOf(s.getay()) + "," + str.valueOf(s.getbx()) + "," + str.valueOf(s.getby()));
            }
        }
        return memo1;
    }

//-----------------------------

    //?ﾜ?ﾝ??定用にselectされた??分?W?№ﾌ?ﾜ???狽? intとして?o力する?B//icolが3(cyan?????F)以?繧ﾌ補????はカウントしない
    public int get_orisensuu_for_select_oritatami() {
        String str = "";//文字列????用のクラスのインスタンス化
//ggggggggggggggg
        //Memo memo1 = new Memo();
        //memo1.reset();
        //memo1.addGyou("<??分?W??>");

        int ibangou = 0;
        for (int i = 1; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);
            if ((s.getcolor() < 3) && (s.get_i_select() == 2)) {
                ibangou = ibangou + 1;
                //memo1.addGyou("番??,"+str.valueOf(ibangou));

                //memo1.addGyou( "?F,"+str.valueOf(s.getcolor()));

                //memo1.addGyou( "<tpp>"+str.valueOf(s.get_tpp())+"</tpp>");					//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                //memo1.addGyou("<tpp_color_R>"+str.valueOf(s.get_tpp_color().getRed()	)+"</tpp_color_R>");	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                //memo1.addGyou("<tpp_color_G>"+str.valueOf(s.get_tpp_color().getGreen()	)+"</tpp_color_G>");	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                //memo1.addGyou("<tpp_color_B>"+str.valueOf(s.get_tpp_color().getBlue()	)+"</tpp_color_B>");	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


                //memo1.addGyou( "?ﾀ標,"  +	str.valueOf(s.getax())+","+ str.valueOf(s.getay())+","+ str.valueOf(s.getbx())+","+ str.valueOf(s.getby()));
            }
        }
        return ibangou;
    }

//-----------------------------


    //特??プ??パティの読み?桙ﾝに使う変?狽ﾌ?ﾝ定
    String[] st_new;
    String[] s_new;
    int i_tpp = 0;
    int i_tpp_color_R = 0;
    int i_tpp_color_G = 0;
    int i_tpp_color_B = 0;

//-----------------------------


    public String setMemo(Memo memo1) {//戻り値はundo,redoの記録用に使うタイトル

        int yomiflg = 0;//0なら読み?桙ﾝを?sわない?B1なら読み?桙ﾞ?B
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
            if (str.equals("<円?W??>")) {
                yomiflg = 3;
            }
            if ((yomiflg == 1) && (str.equals("番??"))) {
                isen = isen + 1;
            }
        }
        sousuu = isen;
        //?ﾅ?奄ﾉ??分の???狽ｪ??められた
        //


        En e_temp = new En();

        for (int i = 1; i <= memo1.getGyousuu(); i++) {
            String str_i = new String(memo1.getGyou(i));

            //旧式の読み?桙ﾝ方法
            StringTokenizer tk = new StringTokenizer(str_i, ",");
            str = tk.nextToken();

            //?V式の読み?桙ﾝ方法
            str_i.trim();


            if (str.equals("<タイトル>")) {
                yomiflg = 2;
            }
            if ((yomiflg == 2) && (str.equals("タイトル"))) {
                str = tk.nextToken();
                r_title = str;
            }


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

            if (yomiflg == 1) {
                st_new = str_i.split(">", 2);// <-----------------------------------２つに分割するときは2を指定
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


            if ((yomiflg == 1) && (str.equals("iactive"))) {//20181110追加
                str = tk.nextToken();
                is = Integer.parseInt(str);
                Senbun s;
                s = sen(ibangou);
                s.setiactive(is);
            }


            if ((yomiflg == 1) && (str.equals("選択"))) {
                str = tk.nextToken();
                is = Integer.parseInt(str);
                Senbun s;
                s = sen(ibangou);
                s.set_i_select(is);
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


//pppppppppppppp


            if (str.equals("<円?W??>")) {
                yomiflg = 3;
            }

            if ((yomiflg == 3) && (str.equals("番??"))) {
                str = tk.nextToken();
                ibangou = Integer.parseInt(str);

                cir_setEn(ibangou, e_temp);
            }

            if ((yomiflg == 3) && (str.equals("中?Sと半径と?F"))) {

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
                st_new = str_i.split(">", 2);// <-----------------------------------２つに分割するときは2を指定
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
        int yomiflg = 0;//0なら読み?桙ﾝを?sわない?B1なら読み?桙ﾞ?B
        int ibangou = 0;
        int ic = 0;
        int is = 0;

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
            if (str.equals("<補????分?W??>")) {
                yomiflg = 1;
            }
            if ((yomiflg == 1) && (str.equals("補?部ﾔ??"))) {
                isen = isen + 1;
            }
        }
        sousuu = isen;
        //?ﾅ?奄ﾉ補????分の???狽ｪ??められた
        //

        for (int i = 1; i <= memo1.getGyousuu(); i++) {


            StringTokenizer tk = new StringTokenizer(memo1.getGyou(i), ",");
            //jtok=    tk.countTokens();
            str = tk.nextToken();
            //  	System.out.println("::::::::::"+ str+"<<<<<" );
            if (str.equals("<補????分?W??>")) {
                yomiflg = 1;
            }
            if ((yomiflg == 1) && (str.equals("補?部ﾔ??"))) {
                str = tk.nextToken();
                ibangou = Integer.parseInt(str);
            }
            if ((yomiflg == 1) && (str.equals("補???F"))) {
                str = tk.nextToken();
                ic = Integer.parseInt(str);
                Senbun s;
                s = sen(ibangou);
                s.setcolor(ic);
            }
            if ((yomiflg == 1) && (str.equals("補?舞I択"))) {
                str = tk.nextToken();
                is = Integer.parseInt(str);
                Senbun s;
                s = sen(ibangou);
                s.set_i_select(is);
            }
            if ((yomiflg == 1) && (str.equals("補???ﾀ標"))) {
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
        int yomiflg = 0;//0なら読み?桙ﾝを?sわない?B1なら読み?桙ﾞ?B
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
        sousuu = sousuu_old + isen;


        //?ﾅ?奄ﾉ??分の???狽ｪ??められた
        //

        for (int i = 1; i <= memo1.getGyousuu(); i++) {

            String str_i = new String(memo1.getGyou(i));

            //旧式の読み?桙ﾝ方法
            StringTokenizer tk = new StringTokenizer(str_i, ",");
            str = tk.nextToken();

            //?V式の読み?桙ﾝ方法
            str_i.trim();


            //StringTokenizer tk = new StringTokenizer(memo1.getGyou(i),",");
            //jtok=    tk.countTokens();
            //str=tk.nextToken();
            //  	System.out.println("::::::::::"+ str+"<<<<<" );
            if (str.equals("<??分?W??>")) {
                yomiflg = 1;
            }
            if ((yomiflg == 1) && (str.equals("番??"))) {
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
                st_new = str_i.split(">", 2);// <-----------------------------------２つに分割するときは2を指定
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


            //----------------------------------------------wwwwwwwwwww


            if (str.equals("<円?W??>")) {
                yomiflg = 3;
            }

            if ((yomiflg == 3) && (str.equals("番??"))) {
                str = tk.nextToken();//ibangou=Ii.parseInt(str);
                Cir.add(new En(0.0, 0.0, 1.0, 1));
                ibangou = cir_size();
            }

            if ((yomiflg == 3) && (str.equals("中?Sと半径と?F"))) {

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
                st_new = str_i.split(">", 2);// <-----------------------------------２つに分割するときは2を指定
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
        System.out.println("?@?@Orisensyuugouの中で?ASmenを発?ｶさせるための??分?W?№ﾌ?ｮ??");
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

//--------------------------------------------------------------------------------------------------

    //??分?W?№ﾌ全??分の?﨣? Memoとして?o力する?B//selectがijyogaiの?ﾜ??は??モに?曹ｫ?oさない
    public Memo getMemo_select_jyogai(int ijyogai) {
        String str = "";//文字列????用のクラスのインスタンス化

        Memo memo1 = new Memo();
        memo1.reset();
        memo1.addGyou("<??分?W??>");

        int ibangou = 0;
        for (int i = 1; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);


            if (s.get_i_select() != ijyogai) {
                ibangou = ibangou + 1;
                memo1.addGyou("番??," + ibangou);
                //Senbun s;s= sen(i);
                memo1.addGyou("?F," + str.valueOf(s.getcolor()));

                memo1.addGyou("<tpp>" + str.valueOf(s.get_tpp()) + "</tpp>");                    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                memo1.addGyou("<tpp_color_R>" + str.valueOf(s.get_tpp_color().getRed()) + "</tpp_color_R>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                memo1.addGyou("<tpp_color_G>" + str.valueOf(s.get_tpp_color().getGreen()) + "</tpp_color_G>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                memo1.addGyou("<tpp_color_B>" + str.valueOf(s.get_tpp_color().getBlue()) + "</tpp_color_B>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

                memo1.addGyou("iactive," + str.valueOf(s.getiactive()));//20181110追加
                memo1.addGyou("?ﾀ標," + str.valueOf(s.getax()) + "," + str.valueOf(s.getay()) + "," + str.valueOf(s.getbx()) + "," + str.valueOf(s.getby()));

            }

        }


        memo1.addGyou("<円?W??>");
        for (int i = 1; i <= cir_size(); i++) {
            memo1.addGyou("番??," + i);
            En e_temp = new En();
            e_temp.set(cir_getEn(i));
            //memo1.addGyou( "?F,"+str.valueOf(e_temp.getcolor()));
            memo1.addGyou("中?Sと半径と?F," + str.valueOf(e_temp.getx()) + "," + str.valueOf(e_temp.gety()) + "," + str.valueOf(e_temp.getr()) + "," + str.valueOf(e_temp.getcolor()));

            memo1.addGyou("<tpp>" + str.valueOf(e_temp.get_tpp()) + "</tpp>");                    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            memo1.addGyou("<tpp_color_R>" + str.valueOf(e_temp.get_tpp_color().getRed()) + "</tpp_color_R>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            memo1.addGyou("<tpp_color_G>" + str.valueOf(e_temp.get_tpp_color().getGreen()) + "</tpp_color_G>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            memo1.addGyou("<tpp_color_B>" + str.valueOf(e_temp.get_tpp_color().getBlue()) + "</tpp_color_B>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


        }


        return memo1;
    }
//-----------------------------

//--------------------------------------------------------------------------------------------------

    //??分?W?№ﾌ全??分の?﨣? Memoとして?o力する?B//selectがisentakuの?ﾜ??を??モに?曹ｫ?oす
    public Memo getMemo_select_sentaku(int isentaku) {
        String str = "";//文字列????用のクラスのインスタンス化

        Memo memo1 = new Memo();
        memo1.reset();
        memo1.addGyou("<??分?W??>");

        int ibangou = 0;
        for (int i = 1; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);


            if (s.get_i_select() == isentaku) {
                ibangou = ibangou + 1;
                memo1.addGyou("番??," + ibangou);
                //Senbun s;s= sen(i);
                memo1.addGyou("?F," + str.valueOf(s.getcolor()));

                memo1.addGyou("<tpp>" + str.valueOf(s.get_tpp()) + "</tpp>");                    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                memo1.addGyou("<tpp_color_R>" + str.valueOf(s.get_tpp_color().getRed()) + "</tpp_color_R>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                memo1.addGyou("<tpp_color_G>" + str.valueOf(s.get_tpp_color().getGreen()) + "</tpp_color_G>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                memo1.addGyou("<tpp_color_B>" + str.valueOf(s.get_tpp_color().getBlue()) + "</tpp_color_B>");    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


                memo1.addGyou("?ﾀ標," + str.valueOf(s.getax()) + "," + str.valueOf(s.getay()) + "," + str.valueOf(s.getbx()) + "," + str.valueOf(s.getby()));

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
//?繧Q?sの???№墲ｯが必要な??由は?Akousabunkatu()をやってしまうと?ﾜ??と補?賦???との交点で?ﾜ??が分割されるから?Bkousabunkatu(1,sousuu-okikae_suu,sousuu-okikae_suu+1,sousuu)だと?ﾜ??は分割されない?B


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

        String str = "";//文字列????用のクラスのインスタンス化
        Memo memo1 = new Memo();
        memo1.reset();
        memo1.addGyou("<??分?W??>");
        int ibangou = 0;

        for (int i = 1; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);

            if (sikaku.totu_kyoukai_naibu(s) == 1) {
                i_r = 1;
            }
            if (sikaku.totu_kyoukai_naibu(s) != 1) {
                ibangou = ibangou + 1;
                memo1.addGyou("番??," + ibangou);
                //Senbun s;s= sen(i);
                memo1.addGyou("?F," + str.valueOf(s.getcolor()));
                memo1.addGyou("?ﾀ標," + str.valueOf(s.getax()) + "," + str.valueOf(s.getay()) + "," + str.valueOf(s.getbx()) + "," + str.valueOf(s.getby()));
            }
        }

        Ten ec = new Ten();//円の中?S?ﾀ標を入れる変??
        double er;//円の中?S?ﾀ標を入れる変??

        Senbun s1 = new Senbun(p1, p2);
        Senbun s2 = new Senbun(p2, p3);
        Senbun s3 = new Senbun(p3, p4);
        Senbun s4 = new Senbun(p4, p1);

        memo1.addGyou("<円?W??>");
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
                memo1.addGyou("番??," + ii);
                memo1.addGyou("中?Sと半径と?F," + str.valueOf(e_temp.getx()) + "," + str.valueOf(e_temp.gety()) + "," + str.valueOf(e_temp.getr()) + "," + str.valueOf(e_temp.getcolor()));
            }
        }


        reset();
        setMemo(memo1);


        return i_r;
    }


    //--------------------------------
    public int D_nisuru0(Ten p1, Ten p2, Ten p3, Ten p4) {//?ﾜ??のみ????

        //System.out.println("(ori_s_1)zzzzz check4_size() = "+check4_size());
        int i_r = 0;
        //Ten p1 = new Ten();   p1.set(si.geta());
        Takakukei sikaku = new Takakukei(4);
        sikaku.set(1, p1);
        sikaku.set(2, p2);
        sikaku.set(3, p3);
        sikaku.set(4, p4);

        //System.out.println("(ori_s_2)zzzzz check4_size() = "+check4_size());

        String str = "";//文字列????用のクラスのインスタンス化
        Memo memo1 = new Memo();
        memo1.reset();
        memo1.addGyou("<??分?W??>");
        int ibangou = 0;

        for (int i = 1; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);

            if ((sikaku.totu_kyoukai_naibu(s) == 1) && (getcolor(i) < 3)) {
                i_r = 1;
            } else if ((sikaku.totu_kyoukai_naibu(s) != 1) || (getcolor(i) >= 3)) {
                ibangou = ibangou + 1;
                memo1.addGyou("番??," + ibangou);
                //Senbun s;s= sen(i);
                memo1.addGyou("?F," + str.valueOf(s.getcolor()));
                memo1.addGyou("?ﾀ標," + str.valueOf(s.getax()) + "," + str.valueOf(s.getay()) + "," + str.valueOf(s.getbx()) + "," + str.valueOf(s.getby()));
            }
        }

        //System.out.println("(ori_s_3)zzzzz check4_size() = "+check4_size());

        //Ten ec=new Ten();//円の中?S?ﾀ標を入れる変??
        //double er;//円の中?S?ﾀ標を入れる変??


        //Senbun s1=new Senbun(p1,p2);
        //Senbun s2=new Senbun(p2,p3);
        //Senbun s3=new Senbun(p3,p4);
        //Senbun s4=new Senbun(p4,p1);


        memo1.addGyou("<円?W??>");
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
            memo1.addGyou("番??," + ii);
            memo1.addGyou("中?Sと半径と?F," + str.valueOf(e_temp.getx()) + "," + str.valueOf(e_temp.gety()) + "," + str.valueOf(e_temp.getr()) + "," + str.valueOf(e_temp.getcolor()));
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
    public int D_nisuru2(Ten p1, Ten p2, Ten p3, Ten p4) {//?ﾜ??のみ????
        int i_r = 0;
        Takakukei sikaku = new Takakukei(4);
        sikaku.set(1, p1);
        sikaku.set(2, p2);
        sikaku.set(3, p3);
        sikaku.set(4, p4);

        String str = "";//文字列????用のクラスのインスタンス化
        Memo memo1 = new Memo();
        memo1.reset();
        memo1.addGyou("<??分?W??>");
        int ibangou = 0;

        for (int i = 1; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);

            if ((sikaku.totu_kyoukai_naibu(s) == 1) && (getcolor(i) == 0)) {
                i_r = 1;
            } else if ((sikaku.totu_kyoukai_naibu(s) != 1) || (getcolor(i) >= 1)) {
                ibangou = ibangou + 1;
                memo1.addGyou("番??," + ibangou);
                memo1.addGyou("?F," + str.valueOf(s.getcolor()));
                memo1.addGyou("?ﾀ標," + str.valueOf(s.getax()) + "," + str.valueOf(s.getay()) + "," + str.valueOf(s.getbx()) + "," + str.valueOf(s.getby()));
            }
        }

        memo1.addGyou("<円?W??>");
        int ii = 0;
        for (int i = 1; i <= cir_size(); i++) {
            En e_temp = new En();
            e_temp.set(cir_getEn(i));//ec.set(e_temp.get_tyuusin());er=e_temp.getr();
            ii = ii + 1;
            memo1.addGyou("番??," + ii);
            memo1.addGyou("中?Sと半径と?F," + str.valueOf(e_temp.getx()) + "," + str.valueOf(e_temp.gety()) + "," + str.valueOf(e_temp.getr()) + "," + str.valueOf(e_temp.getcolor()));
        }

        reset();
        setMemo(memo1);
        return i_r;
    }


    //--------------------------------
    public int D_nisuru3(Ten p1, Ten p2, Ten p3, Ten p4) {//補?賦???のみ????
        int i_r = 0;
        //Ten p1 = new Ten();   p1.set(si.geta());
        Takakukei sikaku = new Takakukei(4);
        sikaku.set(1, p1);
        sikaku.set(2, p2);
        sikaku.set(3, p3);
        sikaku.set(4, p4);

        String str = "";//文字列????用のクラスのインスタンス化
        Memo memo1 = new Memo();
        memo1.reset();
        memo1.addGyou("<??分?W??>");
        int ibangou = 0;

        for (int i = 1; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);

            if ((sikaku.totu_kyoukai_naibu(s) == 1) && (getcolor(i) == 3)) {
                i_r = 1;
            } else if ((sikaku.totu_kyoukai_naibu(s) != 1) || (getcolor(i) != 3)) {
                ibangou = ibangou + 1;
                memo1.addGyou("番??," + ibangou);
                //Senbun s;s= sen(i);
                memo1.addGyou("?F," + str.valueOf(s.getcolor()));
                memo1.addGyou("?ﾀ標," + str.valueOf(s.getax()) + "," + str.valueOf(s.getay()) + "," + String.valueOf(s.getbx()) + "," + s.getby());
            }
        }


        Ten ec = new Ten();//円の中?S?ﾀ標を入れる変??
        double er;//円の中?S?ﾀ標を入れる変??


        Senbun s1 = new Senbun(p1, p2);
        Senbun s2 = new Senbun(p2, p3);
        Senbun s3 = new Senbun(p3, p4);
        Senbun s4 = new Senbun(p4, p1);


        memo1.addGyou("<円?W??>");
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
                memo1.addGyou("番??," + ii);
                memo1.addGyou("中?Sと半径と?F," + e_temp.getx() + "," + e_temp.gety() + "," + e_temp.getr() + "," + e_temp.getcolor());
            }
        }


        reset();
        setMemo(memo1);


        return i_r;
    }


//--------------------------------

    //--------------------------------
    public int chenge_property_in_4kakukei(Ten p1, Ten p2, Ten p3, Ten p4, Color sen_tokutyuu_color) {//4角形の中にある円や補?賦???の?Fなどのプ??パティを変える
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

        Ten ec = new Ten();//円の中?S?ﾀ標を入れる変??
        double er;//円の中?S?ﾀ標を入れる変??


        Senbun s1 = new Senbun(p1, p2);
        Senbun s2 = new Senbun(p2, p3);
        Senbun s3 = new Senbun(p3, p4);
        Senbun s4 = new Senbun(p4, p1);


        //("<円?W??>");
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
    public void kousabunkatu_symple() {//System.out.println("1234567890   k_symple");
        int i_Flag = 1;
        while (i_Flag == 1) {
            System.out.println("sousuu=" + sousuu);
            i_Flag = kousabunkatu_symple_roop();
        }
    }


    public int kousabunkatu_symple_roop() {//1回交?ｷ分割があったら?A直ちに1をリタ?[ンする?B交?ｷ分割がまったくないなら0をリタ?[ンする?B?A
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
    //交?ｷしている２つの??分の交点で２つの??分を分割する?B?@まったく?dなる??分が２つあった???№ﾍ?Aなんの????もなされないまま２つとも残る?B
    public void kousabunkatu(int i1, int i2, int i3, int i4) {//元からあったi1からi2番の?ﾜ??に?Ai3からi4番の?ﾜ??を加えたときの交?ｷ分割
        int ibunkatu = 1;//分割があれば1?Aなければ0

        for (int i = 1; i <= sousuu; i++) {
            setiactive(i, 0);
        }//???怩ｷべき??は iactive=100とする
        //System.out.println("1234567890   kousabunkatu");
        ArrayList k_flg = new ArrayList();//交?ｷ分割の影響があることを示すフラッグ?B

        for (int i = 0; i <= sousuu + 100; i++) {
            k_flg.add(new Integer(0));
        }//0は交?ｷ分割の対?ﾛ外?A１は元からあった?ﾜ???A2は加える?ﾜ??として交?ｷ分割される?B3は???怩ｷべきと判定された?ﾜ??
        for (int i = i1; i <= i2; i++) {
            k_flg.set(i, new Integer(1));
        }//0は交?ｷ分割の対?ﾛ外?A１は元からあった?ﾜ???A2は加える?ﾜ??として交?ｷ分割される
        for (int i = i3; i <= i4; i++) {
            k_flg.set(i, new Integer(2));
        }//0は交?ｷ分割の対?ﾛ外?A１は元からあった?ﾜ???A2は加える?ﾜ??として交?ｷ分割される
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
                            itemp = kousabunkatu_hayai(i, j);//iは加える方(2)?Ajは元からある方(1)
                            //System.out.println("itemp="+itemp);

                            //	if(old_sousuu<sousuu){
                            //		for (int is=old_sousuu+1;is<=sousuu;is++){
                            //			k_flg.add(new Integer(1));
                            //		}
                            //	}
                            //
                            if (itemp == 1) {
                                //ibunkatu=ibunkatu+1;
                                k_flg.add(new Integer(2));//なぜかこれだと2でなくて0として追加される?B20161130
                                k_flg.add(new Integer(1));
                                //System.out.println("sousuu="+sousuu +",i="+i+", I_k_flag="+I_k_flag ) ;
                                k_flg.set(sousuu - 1, new Integer(2));//
                                k_flg.set(sousuu, new Integer(1));
                            }
                            if (itemp == 2) {
                                //ibunkatu=ibunkatu+1;
                                k_flg.add(new Integer(2));//なぜかこれだと2でなくて0として追加される?B20161130
                                k_flg.set(sousuu, new Integer(2));
                            }
                            if (itemp == 3) {
                                //ibunkatu=ibunkatu+1;
                                k_flg.add(new Integer(1));//なぜかこれだと2でなくて0として追加される?B20161130
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
								k_flg.set(j,new Integer(0));//何もしなくてもいいかも//ori_s_temp.senbun_bunkatu(s1.getb());//p1とp3が一致?Asiにsjが含まれる?B加える?ﾜ??をkousa_tenで分割すること

                                                		//k_flg.add(new Integer(2));
								//k_flg.set(sousuu,new Integer(2));

								}
							if (itemp==322){//何もしない
							}
							*/
                            if (itemp == 361) {
                                k_flg.set(j, new Integer(0));//何もしなくてもいいかも//ori_s_temp.senbun_bunkatu(s1.getb());//p1とp3が一致?Asiにsjが含まれる?B加える?ﾜ??をkousa_tenで分割すること
                                k_flg.add(new Integer(2));
                                k_flg.set(sousuu, new Integer(2));
                            }

                            if (itemp == 362) {
                                k_flg.set(j, new Integer(0));//何もしなくてもいいかも//ori_s_temp.senbun_bunkatu(s1.getb());//p1とp3が一致?Asiにsjが含まれる?B加える?ﾜ??をkousa_tenで分割すること
                                k_flg.add(new Integer(2));
                                k_flg.set(sousuu, new Integer(2));
                            }
                            if (itemp == 363) {
                                //k_flg.set(j,new Integer(0));//何もしなくてもいいかも//ori_s_temp.senbun_bunkatu(s1.getb());//p1とp3が一致?Asiにsjが含まれる?B加える?ﾜ??をkousa_tenで分割すること
                                k_flg.add(new Integer(1));
                                k_flg.set(sousuu, new Integer(1));
                            }
                            if (itemp == 364) {
                                //k_flg.set(j,new Integer(0));//何もしなくてもいいかも//ori_s_temp.senbun_bunkatu(s1.getb());//p1とp3が一致?Asiにsjが含まれる?B加える?ﾜ??をkousa_tenで分割すること
                                k_flg.add(new Integer(1));
                                k_flg.set(sousuu, new Integer(1));
                            }
                            if (itemp == 371) {
                                //k_flg.set(j,new Integer(0));//何もしなくてもいいかも//ori_s_temp.senbun_bunkatu(s1.getb());//p1とp3が一致?Asiにsjが含まれる?B加える?ﾜ??をkousa_tenで分割すること
                                k_flg.add(new Integer(0));
                                k_flg.set(sousuu, new Integer(0));
                            }
                            if (itemp == 372) {
                                //k_flg.set(j,new Integer(0));//何もしなくてもいいかも//ori_s_temp.senbun_bunkatu(s1.getb());//p1とp3が一致?Asiにsjが含まれる?B加える?ﾜ??をkousa_tenで分割すること
                                k_flg.add(new Integer(0));
                                k_flg.set(sousuu, new Integer(0));
                            }
                            if (itemp == 373) {
                                //k_flg.set(j,new Integer(0));//何もしなくてもいいかも//ori_s_temp.senbun_bunkatu(s1.getb());//p1とp3が一致?Asiにsjが含まれる?B加える?ﾜ??をkousa_tenで分割すること
                                k_flg.add(new Integer(0));
                                k_flg.set(sousuu, new Integer(0));
                            }
                            if (itemp == 374) {
                                //k_flg.set(j,new Integer(0));//何もしなくてもいいかも//ori_s_temp.senbun_bunkatu(s1.getb());//p1とp3が一致?Asiにsjが含まれる?B加える?ﾜ??をkousa_tenで分割すること
                                k_flg.add(new Integer(0));
                                k_flg.set(sousuu, new Integer(0));
                            }
							/*if (itemp==3){
								Senbun si;si= sen(i);Senbun sj;sj= sen(j);
								int i_kousa_hantei=oc.senbun_kousa_hantei(si,sj,0.000001,0.000001);//iは加える方(2)?Ajは元からある方(1)
								if(      i_kousa_hantei==321){k_flg.set(j,new Integer(3));//ori_s_temp.senbun_bunkatu(s1.getb());//p1とp3が一致?Asiにsjが含まれる?B加える?ﾜ??をkousa_tenで分割すること

								}else if(i_kousa_hantei==322){//ori_s.senbun_bunkatu(i , s0.getb());  //i番目の??分(端点aとb)を点pで分割する?Bi番目の??分abをapに変え?A??分pbを加える?B
								}else if(i_kousa_hantei==331){//ori_s_temp.senbun_bunkatu(s1.geta());//加える?ﾜ??をkousa_tenで分割すること
								}else if(i_kousa_hantei==332){//ori_s.senbun_bunkatu(i , s0.getb());  //i番目の??分(端点aとb)を点pで分割する?Bi番目の??分abをapに変え?A??分pbを加える?B
								}else if(i_kousa_hantei==341){//ori_s_temp.senbun_bunkatu(s1.getb());//加える?ﾜ??をkousa_tenで分割すること
								}else if(i_kousa_hantei==342){//ori_s.senbun_bunkatu(i , s0.geta());  //i番目の??分(端点aとb)を点pで分割する?Bi番目の??分abをapに変え?A??分pbを加える?B
								}else if(i_kousa_hantei==351){//ori_s_temp.senbun_bunkatu(s1.geta());//加える?ﾜ??をkousa_tenで分割すること
								}else if(i_kousa_hantei==352){//ori_s.senbun_bunkatu(i , s0.geta());  //i番目の??分(端点aとb)を点pで分割する?Bi番目の??分abをapに変え?A??分pbを加える?B

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
    public int kousabunkatu_hayai(int i, int j) {//iは加える方(2)?Ajは元からある方(1)//=0 交?ｷせず
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

//ここでの?u2本の??分A,Bがどのように交?ｷするか?vの?lえ方として?i１?j??分Aを直??にして?A??分Bはそのまま??分とする?i２?j??分Bの2つの端点が共にその直??の片側にあるか?A別?Xに直??の両側にあるかという風に?lえる?B
//この確認がおわったら?A次に??分Bを直??にして?A??分Aはそのまま??分とし?A同様に確認する?B?@以?繧??№ｵて2本の??分A,Bがどのように交?ｷするかを?lえる?B


        Tyokusen tyoku0 = new Tyokusen(si.geta(), si.getb());
        kousa_flg0 = tyoku0.senbun_kousa_hantei_kuwasii(sj);//senbun_kousa_hantei(Senbun s0){//0=この直??は与えられた??分と交?ｷしない?A1=X型で交?ｷする?A2=T型で交?ｷする?A3=??分は直??に含まれる?B
        if (kousa_flg0 == 0) {
            return 0;
        }

        Tyokusen tyoku1 = new Tyokusen(sj.geta(), sj.getb());
        kousa_flg1 = tyoku1.senbun_kousa_hantei_kuwasii(si);
        if (kousa_flg0 == 0) {
            return 0;
        }

        // --------------------------------------
        //	X交?ｷ
        // --------------------------------------
        if ((kousa_flg0 == 1) && (kousa_flg1 == 1)) {//(kousa_flg0==1)&&(kousa_flg1==1) 加える?ﾜ??と既存の?ﾜ??はX型で交わる
            kousa_ten.set(oc.kouten_motome(tyoku0, tyoku1));
            //kousa_ten.set(oc.kouten_motome(tyoku0,tyoku1));
            //kousa_ten.set(oc.kouten_motome(tyoku0,tyoku1));

            if (((si.getcolor() != 3) && (sj.getcolor() != 3))
                    || ((si.getcolor() == 3) && (sj.getcolor() == 3))) {

                //addsenbun(kousa_ten,si.getb(),si.getcolor());
                addsenbun(kousa_ten, si.getb(), si);
                si.setb(kousa_ten);  //i番目の??分(端点aとb)を点pで分割する?Bi番目の??分abをapに変え?A??分pbを加える?B

                //addsenbun(kousa_ten,sj.getb(),sj.getcolor());
                addsenbun(kousa_ten, sj.getb(), sj);

                sj.setb(kousa_ten);  //i番目の??分(端点aとb)を点pで分割する?Bi番目の??分abをapに変え?A??分pbを加える?B

                return 1;
            }

            if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {//加えるほうiが???F???i補?賦????j?A元からあるほうjが?ﾜ??

                //addsenbun(kousa_ten,si.getb(),si.getcolor());
                addsenbun(kousa_ten, si.getb(), si);

                si.setb(kousa_ten);  //i番目の??分(端点aとb)を点pで分割する?Bi番目の??分abをapに変え?A??分pbを加える?B

                //addsenbun(kousa_ten,sj.getb(),sj.getcolor());
                //sj.setb(kousa_ten);  //j番目の??分(端点aとb)を点pで分割する?Bj番目の??分abをapに変え?A??分pbを加える?B

                return 2;
            }

            if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {//加えるほうiが?ﾜ???A元からあるほうjが???F???i補?賦????j

                //addsenbun(kousa_ten,si.getb(),si.getcolor());
                //si.setb(kousa_ten);  //i番目の??分(端点aとb)を点pで分割する?Bi番目の??分abをapに変え?A??分pbを加える?B

                //addsenbun(kousa_ten,sj.getb(),sj.getcolor());
                addsenbun(kousa_ten, sj.getb(), sj);

                sj.setb(kousa_ten);  //j番目の??分(端点aとb)を点pで分割する?Bj番目の??分abをapに変え?A??分pbを加える?B

                return 3;
            }
        }


        // --------------------------------------
        //	T交?ｷ(加える?ﾜ??のa点で交わる)
        // --------------------------------------
        if ((kousa_flg0 == 1) && (kousa_flg1 == 21)) {//加える?ﾜ??と既存の?ﾜ??はT型(加える?ﾜ??が?c?A既存の?ﾜ??が横)で交わる(?cのa点で交わる)

            Ten pk = new Ten();
            pk.set(oc.kage_motome(oc.Senbun2Tyokusen(sj), si.geta()));//pkは点pの?i??分を含む直???繧ﾌ?j影
            kousa_ten.set(pk);//交?ｷ点は?ﾜ??i?繧ﾌs0の端点の影 20161129
            //ori_s.senbun_bunkatu(i , kousa_ten);  //i番目の??分(端点aとb)を点pで分割する?Bi番目の??分abをapに変え?A??分pbを加える?B
            //以?繧ﾅ操???I了			kousa_ten.set(oc.kouten_motome(tyoku0,tyoku1));

            if (((si.getcolor() != 3) && (sj.getcolor() != 3))
                    || ((si.getcolor() == 3) && (sj.getcolor() == 3))) {
                //addsenbun(kousa_ten,sj.getb(),sj.getcolor());
                addsenbun(kousa_ten, sj.getb(), sj);

                sj.setb(kousa_ten);  //i番目の??分(端点aとb)を点pで分割する?Bi番目の??分abをapに変え?A??分pbを加える?B
                return 121;
            }

            if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {//加えるほうiが???F???i補?賦????j?A元からあるほうjが?ﾜ??
                return 0;//T交?ｷはしてるが?A?c??が補?賦???なので何もしないので?A0でreturnする?B
            }

            if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {//加えるほうiが?ﾜ???A元からあるほうjが???F???i補?賦????j
                //addsenbun(kousa_ten,sj.getb(),sj.getcolor());
                addsenbun(kousa_ten, sj.getb(), sj);

                sj.setb(kousa_ten);  //i番目の??分(端点aとb)を点pで分割する?Bi番目の??分abをapに変え?A??分pbを加える?B
                return 121;
            }
        }

        // --------------------------------------
        //	T交?ｷ(加える?ﾜ??のb点で交わる)
        // --------------------------------------
        if ((kousa_flg0 == 1) && (kousa_flg1 == 22)) {//加える?ﾜ??と既存の?ﾜ??はT型(加える?ﾜ??が?c?A既存の?ﾜ??が横)で交わる(?cのb点で交わる)
            Ten pk = new Ten();
            pk.set(oc.kage_motome(oc.Senbun2Tyokusen(sj), si.getb()));//pkは点pの?i??分を含む直???繧ﾌ?j影
            kousa_ten.set(pk);//交?ｷ点は?ﾜ??i?繧ﾌs0の端点の影 20161129
            //ori_s.senbun_bunkatu(i , kousa_ten);  //i番目の??分(端点aとb)を点pで分割する?Bi番目の??分abをapに変え?A??分pbを加える?B
            //以?繧ﾅ操???I了			kousa_ten.set(oc.kouten_motome(tyoku0,tyoku1));

            if (((si.getcolor() != 3) && (sj.getcolor() != 3))
                    || ((si.getcolor() == 3) && (sj.getcolor() == 3))) {
                //addsenbun(kousa_ten,sj.getb(),sj.getcolor());
                addsenbun(kousa_ten, sj.getb(), sj);

                sj.setb(kousa_ten);  //i番目の??分(端点aとb)を点pで分割する?Bi番目の??分abをapに変え?A??分pbを加える?B
                return 122;
            }

            if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {//加えるほうiが???F???i補?賦????j?A元からあるほうjが?ﾜ??
                return 0;//T交?ｷはしてるが?A?c??が補?賦???なので何もしないので?A0でreturnする?B
            }

            if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {//加えるほうiが?ﾜ???A元からあるほうjが???F???i補?賦????j
                //addsenbun(kousa_ten,sj.getb(),sj.getcolor());
                addsenbun(kousa_ten, sj.getb(), sj);

                sj.setb(kousa_ten);  //i番目の??分(端点aとb)を点pで分割する?Bi番目の??分abをapに変え?A??分pbを加える?B
                return 122;
            }
        }

        // --------------------------------------
        //	T交?ｷ(元からあった?ﾜ??のa点で交わる)
        // --------------------------------------
        if ((kousa_flg0 == 21) && (kousa_flg1 == 1)) {//加える?ﾜ??と既存の?ﾜ??はT型(加える?ﾜ??が横?A既存の?ﾜ??が?c)で交わる(?cのa点で交わる)
            Ten pk = new Ten();
            pk.set(oc.kage_motome(oc.Senbun2Tyokusen(si), sj.geta()));//pkは点pの?i??分を含む直???繧ﾌ?j影
            kousa_ten.set(pk);//交?ｷ点は?ﾜ??i?繧ﾌs0の端点の影 20161129
            //ori_s.senbun_bunkatu(i , kousa_ten);  //i番目の??分(端点aとb)を点pで分割する?Bi番目の??分abをapに変え?A??分pbを加える?B
            //以?繧ﾅ操???I了			kousa_ten.set(oc.kouten_motome(tyoku0,tyoku1));

            if (((si.getcolor() != 3) && (sj.getcolor() != 3))
                    || ((si.getcolor() == 3) && (sj.getcolor() == 3))) {
                //addsenbun(kousa_ten,si.getb(),si.getcolor());
                addsenbun(kousa_ten, si.getb(), si);

                si.setb(kousa_ten);
                return 211;
            }

            if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {//加えるほうiが???F???i補?賦????j?A元からあるほうjが?ﾜ??
                //addsenbun(kousa_ten,si.getb(),si.getcolor());
                addsenbun(kousa_ten, si.getb(), si);

                si.setb(kousa_ten);
                return 211;
            }

            if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {//加えるほうiが?ﾜ???A元からあるほうjが???F???i補?賦????j
                return 0;//T交?ｷはしてるが?A?c??が補?賦???なので何もしないので?A0でreturnする?B
            }
        }

        // --------------------------------------
        //	T交?ｷ(元からあった?ﾜ??の?ﾜ??のb点で交わる)
        // --------------------------------------
        if ((kousa_flg0 == 22) && (kousa_flg1 == 1)) {//加える?ﾜ??と既存の?ﾜ??はT型(加える?ﾜ??が横?A既存の?ﾜ??が?c)で交わる(?cのa点で交わる)
            Ten pk = new Ten();
            pk.set(oc.kage_motome(oc.Senbun2Tyokusen(si), sj.getb()));//pkは点pの?i??分を含む直???繧ﾌ?j影
            kousa_ten.set(pk);//交?ｷ点は?ﾜ??i?繧ﾌs0の端点の影 20161129
            //ori_s.senbun_bunkatu(i , kousa_ten);  //i番目の??分(端点aとb)を点pで分割する?Bi番目の??分abをapに変え?A??分pbを加える?B
            //以?繧ﾅ操???I了			kousa_ten.set(oc.kouten_motome(tyoku0,tyoku1));

            if (((si.getcolor() != 3) && (sj.getcolor() != 3))
                    || ((si.getcolor() == 3) && (sj.getcolor() == 3))) {
                //addsenbun(kousa_ten,si.getb(),si.getcolor());
                addsenbun(kousa_ten, si.getb(), si);

                si.setb(kousa_ten);
                return 221;
            }

            if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {//加えるほうiが???F???i補?賦????j?A元からあるほうjが?ﾜ??
                //addsenbun(kousa_ten,si.getb(),si.getcolor());
                addsenbun(kousa_ten, si.getb(), si);

                si.setb(kousa_ten);
                return 221;
            }

            if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {//加えるほうiが?ﾜ???A元からあるほうjが???F???i補?賦????j
                return 0;//T交?ｷはしてるが?A?c??が補?賦???なので何もしないので?A0でreturnする?B
            }

        }


/*
			if(((si.getcolor()!=3)&&(sj.getcolor()!=3))
			|| ((si.getcolor()==3)&&(sj.getcolor()==3)) )	{


			}

			if((si.getcolor()==3)&&(sj.getcolor()!=3)){//加えるほうiが???F???i補?賦????j?A元からあるほうjが?ﾜ??

			}

			if((si.getcolor()!=3)&&(sj.getcolor()==3)){//加えるほうiが?ﾜ???A元からあるほうjが???F???i補?賦????j

			}
*/


        // --------------------------------------
        //	加える?ﾜ??と既存の?ﾜ??は平?s
        // --------------------------------------
        if (kousa_flg0 == 3) {//加える?ﾜ??と既存の?ﾜ??は同一直???繧ﾉある
            Ten p1 = new Ten();
            p1.set(si.geta());
            Ten p2 = new Ten();
            p2.set(si.getb());
            Ten p3 = new Ten();
            p3.set(sj.geta());
            Ten p4 = new Ten();
            p4.set(sj.getb());

            //setiactive(j,100)とされた?ﾜ??は?Akousabunkatu(int i1,int i2,int i3,int i4)の操??が戻った後で???怩ｳれる?B

            int i_kousa_hantei = oc.senbun_kousa_hantei(si, sj, 0.000001, 0.000001);//iは加える方(2)?Ajは元からある方(1)


            if (i_kousa_hantei == 31) {// ２つの??分が全く同じ
                if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {
                    return 0;
                } //加えるほうiが???F???i補?賦????j?A元からあるほうjが?ﾜ??
                if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {
                    return 0;
                }//加えるほうiが?ﾜ???A元からあるほうjが???F???i補?賦????j

                setiactive(j, 100);
                //si.seta(sj.getb());
                return 31;

            } else if (i_kousa_hantei == 321) {//(p1=p3)_p4_p2?Asiにsjが含まれる?B
                if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {
                    return 0;
                } //加えるほうiが???F???i補?賦????j?A元からあるほうjが?ﾜ??
                if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {
                    return 0;
                }//加えるほうiが?ﾜ???A元からあるほうjが???F???i補?賦????j
                sj.setcolor(si.getcolor());
                si.seta(sj.getb());
                return 321;
            } else if (i_kousa_hantei == 322) {//(p1=p3)_p2_p4?Asiがsjに含まれる?B
                if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {
                    return 0;
                } //加えるほうiが???F???i補?賦????j?A元からあるほうjが?ﾜ??
                if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {
                    return 0;
                }//加えるほうiが?ﾜ???A元からあるほうjが???F???i補?賦????j

                sj.seta(si.getb());
                return 322;
            } else if (i_kousa_hantei == 331) {//(p1=p4)_p3_p2?Asiにsjが含まれる?B
                if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {
                    return 0;
                } //加えるほうiが???F???i補?賦????j?A元からあるほうjが?ﾜ??
                if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {
                    return 0;
                }//加えるほうiが?ﾜ???A元からあるほうjが???F???i補?賦????j

                sj.setcolor(si.getcolor());
                si.seta(sj.geta());
                return 331;
            } else if (i_kousa_hantei == 332) {//(p1=p4)_p2_p3?Asiがsjに含まれる?B
                if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {
                    return 0;
                } //加えるほうiが???F???i補?賦????j?A元からあるほうjが?ﾜ??
                if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {
                    return 0;
                }//加えるほうiが?ﾜ???A元からあるほうjが???F???i補?賦????j

                sj.setb(si.getb());
                return 332;


            } else if (i_kousa_hantei == 341) {//(p2=p3)_p4_p1?Asiにsjが含まれる?B
                if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {
                    return 0;
                } //加えるほうiが???F???i補?賦????j?A元からあるほうjが?ﾜ??
                if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {
                    return 0;
                }//加えるほうiが?ﾜ???A元からあるほうjが???F???i補?賦????j

                sj.setcolor(si.getcolor());
                si.setb(sj.getb());
                return 341;

            } else if (i_kousa_hantei == 342) {//(p2=p3)_p1_p4?Asiがsjに含まれる?B
                if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {
                    return 0;
                } //加えるほうiが???F???i補?賦????j?A元からあるほうjが?ﾜ??
                if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {
                    return 0;
                }//加えるほうiが?ﾜ???A元からあるほうjが???F???i補?賦????j

                sj.seta(si.geta());
                return 342;


            } else if (i_kousa_hantei == 351) {//(p2=p4)_p3_p1?Asiにsjが含まれる?B
                if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {
                    return 0;
                } //加えるほうiが???F???i補?賦????j?A元からあるほうjが?ﾜ??
                if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {
                    return 0;
                }//加えるほうiが?ﾜ???A元からあるほうjが???F???i補?賦????j

                sj.setcolor(si.getcolor());
                si.setb(sj.geta());
                return 351;


            } else if (i_kousa_hantei == 352) {//(p2=p4)_p1_p3?Asiがsjに含まれる?B
                if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {
                    return 0;
                } //加えるほうiが???F???i補?賦????j?A元からあるほうjが?ﾜ??
                if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {
                    return 0;
                }//加えるほうiが?ﾜ???A元からあるほうjが???F???i補?賦????j

                sj.setb(si.geta());
                return 352;


            } else if (i_kousa_hantei == 361) {//??分(p1,p2)に??分(p3,p4)が含まれる ori_s_temp.senbun_bunkatu(s1.geta()); ori_s_temp.senbun_bunkatu(s1.getb());   ori_s.setiactive(i,100);//imax=imax-1;
                if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {
                    return 0;
                } //加えるほうiが???F???i補?賦????j?A元からあるほうjが?ﾜ??
                if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {
                    return 0;
                }//加えるほうiが?ﾜ???A元からあるほうjが???F???i補?賦????j

                sj.setcolor(si.getcolor());
                //addsenbun(sj.getb(),si.getb(),si.getcolor());
                addsenbun(sj.getb(), si.getb(), si);

                si.setb(sj.geta());
                return 361;
            } else if (i_kousa_hantei == 362) {//??分(p1,p2)に??分(p4,p3)が含まれる; ori_s_temp.senbun_bunkatu(s1.getb());   ori_s.setiactive(i,100);//imax=imax-1;
                if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {
                    return 0;
                } //加えるほうiが???F???i補?賦????j?A元からあるほうjが?ﾜ??
                if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {
                    return 0;
                }//加えるほうiが?ﾜ???A元からあるほうjが???F???i補?賦????j

                sj.setcolor(si.getcolor());
                //addsenbun(sj.geta(),si.getb(),si.getcolor());
                addsenbun(sj.geta(), si.getb(), si);

                si.setb(sj.getb());
                return 362;
            } else if (i_kousa_hantei == 363) {//??分(p3,p4)に??分(p1,p2)が含まれる ori_s.addsenbun(s0.getb(),s1.getb(),s1.getcolor());ori_s.setb(i,s0.geta());
                if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {
                    return 0;
                } //加えるほうiが???F???i補?賦????j?A元からあるほうjが?ﾜ??
                if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {
                    return 0;
                }//加えるほうiが?ﾜ???A元からあるほうjが???F???i補?賦????j

                //addsenbun(si.getb(),sj.getb(),sj.getcolor());
                addsenbun(si.getb(), sj.getb(), sj);

                sj.setb(si.geta());
                return 363;
            } else if (i_kousa_hantei == 364) {//??分(p3,p4)に??分(p2,p1)が含まれるori_s.addsenbun(s0.geta(),s1.getb(),s1.getcolor());ori_s.setb(i,s0.getb());
                if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {
                    return 0;
                } //加えるほうiが???F???i補?賦????j?A元からあるほうjが?ﾜ??
                if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {
                    return 0;
                }//加えるほうiが?ﾜ???A元からあるほうjが???F???i補?賦????j

                //addsenbun(si.geta(),sj.getb(),sj.getcolor());
                addsenbun(si.geta(), sj.getb(), sj);

                sj.setb(si.getb());
                return 364;


            } else if (i_kousa_hantei == 371) {//??分(p1,p2)のP2側と??分(p3,p4)のP3側が部分的に?dなる//ori_s_temp.senbun_bunkatu(s1.geta());ori_s.seta(i,s0.getb());
                if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {
                    return 0;
                } //加えるほうiが???F???i補?賦????j?A元からあるほうjが?ﾜ??
                if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {
                    return 0;
                }//加えるほうiが?ﾜ???A元からあるほうjが???F???i補?賦????j

                //addsenbun(p3,p2,si.getcolor());
                addsenbun(p3, p2, si);

                si.setb(p3);
                sj.seta(p2);
                return 371;

            } else if (i_kousa_hantei == 372) {//??分(p1,p2)のP2側と??分(p4,p3)のP4側が部分的に?dなる//ori_s_temp.senbun_bunkatu(s1.getb());ori_s.setb(i,s0.getb());
                if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {
                    return 0;
                } //加えるほうiが???F???i補?賦????j?A元からあるほうjが?ﾜ??
                if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {
                    return 0;
                }//加えるほうiが?ﾜ???A元からあるほうjが???F???i補?賦????j

                //addsenbun(p4,p2,si.getcolor());
                addsenbun(p4, p2, si);

                si.setb(p4);
                sj.setb(p2);
                return 372;

            } else if (i_kousa_hantei == 373) {//??分(p3,p4)のP4側と??分(p1,p2)のP1側が部分的に?dなる//ori_s_temp.senbun_bunkatu(s1.getb());ori_s.setb(i,s0.geta());
                if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {
                    return 0;
                } //加えるほうiが???F???i補?賦????j?A元からあるほうjが?ﾜ??
                if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {
                    return 0;
                }//加えるほうiが?ﾜ???A元からあるほうjが???F???i補?賦????j

                //addsenbun(p1,p4,si.getcolor());
                addsenbun(p1, p4, si);

                si.seta(p4);
                sj.setb(p1);
                return 373;

            } else if (i_kousa_hantei == 374) {//??分(p4,p3)のP3側と??分(p1,p2)のP1側が部分的に?dなる//ori_s_temp.senbun_bunkatu(s1.geta());ori_s.seta(i,s0.geta());
                if ((si.getcolor() == 3) && (sj.getcolor() != 3)) {
                    return 0;
                } //加えるほうiが???F???i補?賦????j?A元からあるほうjが?ﾜ??
                if ((si.getcolor() != 3) && (sj.getcolor() == 3)) {
                    return 0;
                }//加えるほうiが?ﾜ???A元からあるほうjが???F???i補?賦????j

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
    //交?ｷしている２つの??分の交点で２つの??分を分割する?B?@まったく?dなる??分が２つあった???№ﾍ?Aなんの????もなされないまま２つとも残る?B
    public void kousabunkatu() {
        int ibunkatu = 1;//分割があれば1?Aなければ0
//System.out.println("1234567890   kousabunkatu");
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

        if (si.get_i_max_x() < sj.get_i_min_x()) {
            return 0;
        }//これはSenbunにi_max_xがちゃんと定義されているときでないとうまくいかない
        if (sj.get_i_max_x() < si.get_i_min_x()) {
            return 0;
        }//これはSenbunにi_min_xがちゃんと定義されているときでないとうまくいかない
        if (si.get_i_max_y() < sj.get_i_min_y()) {
            return 0;
        }//これはSenbunにi_max_yがちゃんと定義されているときでないとうまくいかない
        if (sj.get_i_max_y() < si.get_i_min_y()) {
            return 0;
        }//これはSenbunにi_min_yがちゃんと定義されているときでないとうまくいかない

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

        //oc.senbun_kousa_hantei(si,sj)が21から24まではくの字型の交?ｷで?Aなにもしない?B

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

        if (oc.senbun_kousa_hantei(si, sj) == 0) {//このifないと本来この後で????されるべき??がここで????されてしまうことある

//System.out.println("      888888888888888888888888888");

            if (oc.kyori_senbun(si.geta(), sj) < 0.01) {
                if (oc.senbun_busyo_sagasi(si.geta(), sj, 0.01) == 3) { //20161107 わずかに届かない????
                    pk.set(oc.kouten_motome(si, sj));    //<<<<<<<<<<<<<<<<<<<<<<<
                    sj.seta(p3);
                    sj.setb(pk);
                    addsenbun(p4, pk, sj.getcolor());
                    return 1;
                }
            }

            if (oc.kyori_senbun(si.getb(), sj) < 0.01) {
                if (oc.senbun_busyo_sagasi(si.getb(), sj, 0.01) == 3) { //20161107 わずかに届かない????
                    pk.set(oc.kouten_motome(si, sj));    //<<<<<<<<<<<<<<<<<<<<<<<
                    sj.seta(p3);
                    sj.setb(pk);
                    addsenbun(p4, pk, sj.getcolor());
                    return 1;
                }
            }

            if (oc.kyori_senbun(sj.geta(), si) < 0.01) {
                if (oc.senbun_busyo_sagasi(sj.geta(), si, 0.01) == 3) { //20161107 わずかに届かない????
                    pk.set(oc.kouten_motome(si, sj));    //<<<<<<<<<<<<<<<<<<<<<<<
                    si.seta(p1);
                    si.setb(pk);
                    addsenbun(p2, pk, si.getcolor());
                    return 1;
                }
            }

            if (oc.kyori_senbun(sj.getb(), si) < 0.01) {
                if (oc.senbun_busyo_sagasi(sj.getb(), si, 0.01) == 3) { //20161107 わずかに届かない????
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
        if (oc.senbun_kousa_hantei(si, sj) == 31) {//2つの??分がまったく同じ???№ﾍ?A何もしない?B
            return 0;
        }


        if (oc.senbun_kousa_hantei(si, sj) == 321) {//2つの??分の端点どうし(p1とp3)が1点で?dなる?Bsiにsjが含まれる
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

        if (oc.senbun_kousa_hantei(si, sj) == 322) {//2つの??分の端点どうし(p1とp3)が1点で?dなる?Bsjにsiが含まれる
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

        if (oc.senbun_kousa_hantei(si, sj) == 331) {//2つの??分の端点どうし(p1とp4)が1点で?dなる?Bsiにsjが含まれる
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

        if (oc.senbun_kousa_hantei(si, sj) == 332) {//2つの??分の端点どうし(p1とp4)が1点で?dなる?Bsjにsiが含まれる
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

        if (oc.senbun_kousa_hantei(si, sj) == 341) {//2つの??分の端点どうし(p2とp3)が1点で?dなる?Bsiにsjが含まれる
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

        if (oc.senbun_kousa_hantei(si, sj) == 342) {//2つの??分の端点どうし(p2とp3)が1点で?dなる?Bsjにsiが含まれる
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

        if (oc.senbun_kousa_hantei(si, sj) == 351) {//2つの??分の端点どうし(p2とp4)が1点で?dなる?Bsiにsjが含まれる
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

        if (oc.senbun_kousa_hantei(si, sj) == 352) {//2つの??分の端点どうし(p2とp4)が1点で?dなる?Bsjにsiが含まれる
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


    //円の追加-------------------------------


    public void add_en(double dx, double dy, double dr, int ic) {
        Cir.add(new En(dx, dy, dr, ic));

        //Senbun s;s= sen(sousuu);
        //s.set(pi,pj,i_c);
    }

    public void add_en(Ten t, double dr) {
        add_en(t.getx(), t.gety(), dr, 0);
    }


    //円と円の交点に半径0の円を発?ｶ-------------------------------
    public void en_en_kouten(int imin, int imax, int jmin, int jmax) {
        for (int i = imin; i <= imax; i++) {
            En ei = new En();
            ei.set(cir_getEn(i));
            if (ei.getr() > 0.0000001) {//半径0の円は対?ﾛ外
                for (int j = jmin; j <= jmax; j++) {

                    En ej = new En();
                    ej.set(cir_getEn(j));
                    if (ej.getr() > 0.0000001) {//半径0の円は対?ﾛ外
                        if (oc.kyori(ei.get_tyuusin(), ej.get_tyuusin()) < 0.000001) {//2つの円は同?S円で交?ｷしない
                        } else if (Math.abs(oc.kyori(ei.get_tyuusin(), ej.get_tyuusin()) - ei.getr() - ej.getr()) < 0.0001) {//2つの円は1点で交?ｷ
                            add_en(oc.naibun(ei.get_tyuusin(), ej.get_tyuusin(), ei.getr(), ej.getr()), 0.0);
                        } else if (oc.kyori(ei.get_tyuusin(), ej.get_tyuusin()) > ei.getr() + ej.getr()) {//2つの円は交?ｷしない

                        } else if (Math.abs(oc.kyori(ei.get_tyuusin(), ej.get_tyuusin()) - Math.abs(ei.getr() - ej.getr())) < 0.0001) {//2つの円は1点で交?ｷ
                            add_en(oc.naibun(ei.get_tyuusin(), ej.get_tyuusin(), -ei.getr(), ej.getr()), 0.0);
                        } else if (oc.kyori(ei.get_tyuusin(), ej.get_tyuusin()) < Math.abs(ei.getr() - ej.getr())) {//2つの円は交?ｷしない

                        } else {//2つの円は2点で交?ｷ
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


    //円と?ﾜ??の交点に半径0の円を発?ｶ-------------------------------
    public void Senbun_en_kouten(int imin, int imax, int jmin, int jmax) {
        for (int i = imin; i <= imax; i++) {
            Senbun si;
            si = sen(i);

            Tyokusen ti = new Tyokusen();
            ti.set(oc.Senbun2Tyokusen(si));
            //if(ei.getr()>0.0000001){//半径0の円は対?ﾛ外
            for (int j = jmin; j <= jmax; j++) {

                En ej = new En();
                ej.set(cir_getEn(j));
                if (ej.getr() > 0.0000001) {//半径0の円は対?ﾛ外
                    double tc_kyori = ti.kyorikeisan(ej.get_tyuusin()); //直??と円の中?Sの距離


                    if (Math.abs(tc_kyori - ej.getr()) < 0.000001) {//円と直??は1点で交?ｷ
                        if (
                                Math.abs(
                                        oc.kyori_senbun(ej.get_tyuusin(), si) - ej.getr()
                                ) < 0.000001
                        ) {
                            add_en(oc.kage_motome(ti, ej.get_tyuusin()), 0.0);
                        }
                    } else if (tc_kyori > ej.getr()) {//円と直??は交?ｷしない
                    } else {//円と直??は2点で交?ｷ
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


    //円の????-----------------------------------------
    public void delen(int j) {   //j番目の円を???怩ｷる
        Cir.remove(j);
    }

    //円の?ｮ??-----------------------------------------
    public int en_seiri(int i0) {//j番目の円を?ｮ??する?B?ｮ??で???怩ｵたら1 ?A???怩ｵないなら0を返す?B
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

    //円の?ｮ??-----------------------------------------
    public void en_seiri() {//全ての円を対?ﾛに?ｮ??をする?B
        for (int i = cir_size(); i >= 1; i--) {
            en_seiri(i);
        }
    }


    //円の?ﾔ表示-----------------------------------------
    public int en_jyoutai(int i0, int i_mode) {   //i番目の円の?ﾔを示す?B
        //=100000?@i番目の円の半径が0でない
        //=     0?@i番目の円の半径が0?B他の円の円周と離れている?B他の円の中?Sと離れている?B?@
        //=     1?@1桁目の?博??Bi番目の円の半径が0で?A他の半径が0の円の中?Sと?dなっている???B2個以?繧ﾆ?dなっているときは2と表示される?B
        //=    10?@2桁目の?博??Bi番目の円の半径が0で?A他の半径が0でない円の中?Sと?dなっている???B2個以?繧ﾆ?dなっているときは2と表示される?B
        //=   100?@3桁目の?博??Bi番目の円の半径が0で?A他の半径が0でない円の円周と?dなっている???B2個以?繧ﾆ?dなっているときは2と表示される?B
        //=  1000?@4桁目の?博??Bi番目の円の半径が0で?A他の?ﾜ??と?dなっている???B2個以?繧ﾆ?dなっているときは2と表示される?B
        //= 10000?@5桁目の?博??Bi番目の円の半径が0で?A他の補?賦???と?dなっている???B2個以?繧ﾆ?dなっているときは2と表示される?B
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
                    if (er_1 < 0.0000001) {//他の円の半径が0
                        if (ec_0.kyori(ec_1) < 0.0000001) {
                            ir1 = ir1 + 1;
                        }
                    } else {//他の円の半径が0でない
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


    //??分の追加-------------------------------
    public void addsenbun(Ten pi, Ten pj, int i_c) {
        sousuu++;

        Senbun s;
        s = sen(sousuu);
        s.set(pi, pj, i_c);
    }

    //??分の追加-------------------------------wwwwwwwwww
    public void addsenbun(Ten pi, Ten pj, Senbun s0) {//Ten piからTen pjまでの??分を追加?Bこの追加する??分のその他のパラ???[タはs0と同じ
        sousuu++;

        Senbun s;
        s = sen(sousuu);
        //s.set(pi,pj,s0.getcolor());
        s.set(s0);
        s.set(pi, pj);

    }

    //??分の追加-------------------------------
    public void addsenbun(Ten pi, Ten pj, int i_c, int i_a) {
        sousuu++;

        Senbun s;
        s = sen(sousuu);
        s.set(pi, pj, i_c, i_a);
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

    //??分の追加-------------------------------
    public void addsenbun(Senbun s0) {
        //addsenbun(s0.geta(),s0.getb(),s0.getcolor());//20181110コ??ントアウト
        addsenbun(s0.geta(), s0.getb(), s0.getcolor(), s0.getiactive());//20181110追加
    }

    //??分の????-----------------------------------------
    public void delsenbun(int j) {   //j番目の??分を???怩ｷる  このsi= sen(i)は大?苺vなのだろうか????????si= sen(i)?@20161106
        for (int i = j; i <= sousuu - 1; i++) {
            Senbun si;
            si = sen(i);
            Senbun si1;
            si1 = sen(i + 1);
            si.set(si1);

        }
        sousuu--;
    }


    //??分の分割-----------------qqqqq------------------------
    public void senbun_bunkatu(int i, Ten p) {   //i番目の??分(端点aとb)を点pで分割する?Bi番目の??分abをapに変え?A??分pbを加える?B

        Senbun s1 = new Senbun(p, getb(i));//i番目の??分abをapに変える前に??っておく
        int i_c;
        i_c = getcolor(i);

        setb(i, p);//i番目の??分abをapに変える

        addsenbun(s1);
        setcolor(getsousuu(), i_c);
    }

/*
	public void senbun_binkatu(int i,Ten p){   //pとi番目の??分の端点aとの??分を加え?Apとi番目の??分の端点bとの??分を加え?Ai番目の??分を???怩ｷる
		int i_c;i_c=getcolor(i);
		Senbun s1 =new Senbun(geta(i),p);
		Senbun s2 =new Senbun(getb(i),p);
		delsenbun(i);
		addsenbun(s1);setcolor(getsousuu(),i_c);
		addsenbun(s2);setcolor(getsousuu(),i_c);
	}
*/

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
                delsenbun_vertex(i);
                i = 1;
            }
        }
    }

    //-----------------------------------------------
    public void delsenbun_vertex(int i) {//i番目の?ﾜ??を?ﾁすとき?Aその?ﾜ??の端点も?ﾁせる???№ﾍ?ﾁす
        Ten pa = new Ten();
        pa.set(geta(i));
        Ten pb = new Ten();
        pb.set(getb(i));
        delsenbun(i);

        del_V(pa, 0.000001, 0.000001);
        del_V(pb, 0.000001, 0.000001);
    }

//----------------------------------------------------


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


    //点pに?ﾅも近い円?i円周と中?Sの両方を?l慮する?jの番??を返す
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


    //点pに?ﾅも近い円の番??を逆?№ﾅ?i番??の大きいほうが優?謔ﾆいう意味?j探して返す
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


    //点pに?ﾅも近い円の番??での?Aその距離を返す
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


    //点pに?ﾅも近い??分の番??を逆から?i番??の大きいほうから?ｬさいほうへという意味?j探して返す
    public int mottomo_tikai_senbun_sagasi_gyakujyun(Ten p) {
        int minrid = 0;
        double minr = 100000;
        for (int i = sousuu; i >= 1; i--) {
            double sk = oc.kyori_senbun(p, get(i));
            if (minr > sk) {
                minr = sk;
                minrid = i;
            }//柄の部分に近いかどうか

        }
        return minrid;
    }


    //点pに?ﾅも近い??分の番??での?Aその距離を返す
    public double mottomo_tikai_senbun_kyori(Ten p) {
        int minrid = 0;
        double minr = 100000.0;
        for (int i = 1; i <= sousuu; i++) {
            double sk = oc.kyori_senbun(p, get(i));
            if (minr > sk) {
                minr = sk;
                minrid = i;
            }//柄の部分に近いかどうか

        }
        return minr;
    }


    //点pに?ﾅも近い??分の番??での?Aその距離を返す?Bただし??分s0と平?sな?ﾜ??が調?ｸの対?ﾛ外?Bつまり?A平?sな?ﾜ??が?dなっていても近い距離にあるとはみなされない?B
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
            }//円周の部分に近いかどうか
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
            }//柄の部分に近いかどうか

        }

        if (minrid == 0) {
            return s1;
        }

        return get(minrid);
    }


    //点pに?ﾅも近い?A?u??分の端点?vを返す
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

    //点pに?ﾅも近い?A?u円の中?S点?vを返す
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

    //点pに?ﾅも近い?A?u??分の端点?vを返す?Bただし?A補?賦???は対?ﾛ外
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
    public void del_V(int i, int j) {//2本の?ﾜ??が同じ?Fで?A他の?ﾜ??の端点がない???№ﾉ点?ﾁしをする
        //if(getcolor(i)!=getcolor(j)){return;}//2本が同じ?Fでないなら実施せず

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
                    if (getcolor(i) == getcolor(j)) {//2本が同じ?Fなら実施
                        if (getcolor(i) != 3) {//補?賦???は対?ﾛ外
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


    //点Qを指定し?A??分AQとQCを???怩ｵ??分ACを追加?iただしQを端点とするのは2本の??分のみ?j//実施したときは1?A何もしなかったときは0を返す?B
//手?№ﾍ?i１?jマウスクリックで点pが決まる?B
//?i２?j点p?ﾅも近い展開?}に含まれる端点qが決まる?B
//?i３?j展開?}中の?ﾜ??でその端点のうち?Aqに近いほうと?Aqとの距離がr以下の?????Aその?ﾜ??は点qと連結しているとして
//
//
//
//
//
//
//
//
    int[] i_s = new int[2];//この変?狽ﾍdel_Vとtyouten_syuui_sensuuとで共通に使う?Btyouten_syuui_sensuuで?A頂点回りの?ﾜ???狽ｪ2のときにその2?ﾜ??の番??を入れる変???Bなお?A?ﾜ???狽ｪ3以?繧ﾌときは意味を?ｬさない?B//qを端点とする2本の??分の番??

    public int del_V(Ten p, double hikiyose_hankei, double r) {
        int i_return;
        i_return = 0;

        Ten q = new Ten();
        q.set(mottomo_tikai_Ten(p));//qは点pに近い方の端点
        if (q.kyori2jyou(p) > hikiyose_hankei * hikiyose_hankei) {
            return 0;
        }
        Ten p_temp = new Ten();

        if (tyouten_syuui_sensuu_for_del_V(q, r) == 2) {
            //int i_s[] = new int[2];//qを端点とする2本の??分の番??
/*
			i_s[0]=0;i_s[1]=0;
			int i_temp;i_temp=0;
			for(int i=1;i<=sousuu;i++){
				p_temp.set(geta(i));if(q.kyori(getb(i))<q.kyori(geta(i)) ) {p_temp.set(getb(i)); }
				if(q.kyori(p_temp)<r) {
					if(i_temp==2){return 0;}//ここの???㌍_temp==2とは?Aすでに2本の?ﾜ??が見つかっているところに3本目も見つかったということになっている?B
					i_s[i_temp]=i; i_temp=i_temp+1;
				}
			}
			if(i_temp!=2){return 0;}//ここの???㌍_temp==2とは?A?ﾜ??が2本だけ見つかったということで?A望ましい結果
*/
            int ix, iy;
            ix = i_s[0];
            iy = i_s[1];
            int i_hantei;
            i_hantei = 0;//i_hanteiは１なら2??分は?dならず?A直???ﾉ繋がっている
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
            }//2本が同じ?Fでないなら実施せず

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

    public int del_V_cc(Ten p, double hikiyose_hankei, double r) {//2つの?ﾜ??の?Fが違った???㏍Jラ?[チェンジして?A点???怩ｷる?B???ﾔは?ﾔ?ﾔ?A???ﾂは?ﾂ?ﾂ?A?ﾂ?ﾔは?浮ﾉする
        int i_return;
        i_return = 0;

        Ten q = new Ten();
        q.set(mottomo_tikai_Ten(p));//qは点pに近い方の端点
        if (q.kyori2jyou(p) > hikiyose_hankei * hikiyose_hankei) {
            return 0;
        }
        Ten p_temp = new Ten();

        if (tyouten_syuui_sensuu_for_del_V(q, r) == 2) {


            int ix, iy;
            ix = i_s[0];
            iy = i_s[1];
            int i_hantei;
            i_hantei = 0;//i_hanteiは１なら2??分は?dならず?A直???ﾉ繋がっている
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

            //if(getcolor(ix)!=getcolor(iy)){return 0;}//2本が同じ?Fでないなら実施せず

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


    //点pに?ﾅも近い??分の?A点pに近い方の端点を?A頂点とした?????A何本の??分が?oているか?i頂点とr以内に端点がある??分の???j//del_V用の関??
    public int tyouten_syuui_sensuu_for_del_V(Ten p, double r) {//del_V用の関??

        Ten q = new Ten();
        q.set(mottomo_tikai_Ten(p));//qは点pに近い方の端点
        Ten p_temp = new Ten();


        int i_return;
        i_return = 0;
        int i_temp;
        i_temp = 1;//ここのi_tempはi_temp=1-i_tempの形でつかうので?A0,1,0,1,0,1,,,という風に変化していく
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


    //点pに?ﾅも近い??分の?A点pに近い方の端点を?A頂点とした?????A何本の??分が?oているか?i頂点とr以内に端点がある??分の???j
    public int tyouten_syuui_sensuu(Ten p, double r) {

        Ten q = new Ten();
        q.set(mottomo_tikai_Ten(p));//qは点pに近い方の端点
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


    //点pに?ﾅも近い??分の?A点pに近い方の端点を?A頂点とした?????A何本の?ﾔい??分が?oているか?i頂点とr以内に端点がある??分の???j
    public int tyouten_syuui_sensuu_red(Ten p, double r) {

        Ten q = new Ten();
        q.set(mottomo_tikai_Ten(p));//qは点pに近い方の端点
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
    //点pに?ﾅも近い??分の?A点pに近い方の端点を?A頂点とした?????A何本の?ﾂい??分が?oているか?i頂点とr以内に端点がある??分の???j
    public int tyouten_syuui_sensuu_blue(Ten p, double r) {

        Ten q = new Ten();
        q.set(mottomo_tikai_Ten(p));//qは点pに近い方の端点
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
    //点pに?ﾅも近い??分の?A点pに近い方の端点を?A頂点とした?????A何本の?浮｢??分が?oているか?i頂点とr以内に端点がある??分の???j
    public int tyouten_syuui_sensuu_black(Ten p, double r) {

        Ten q = new Ten();
        q.set(mottomo_tikai_Ten(p));//qは点pに近い方の端点
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
    //点pに?ﾅも近い??分の?A点pに近い方の端点を?A頂点とした?????A何本の補?賦???が?oているか?i頂点とr以内に端点がある??分の???j
    public int tyouten_syuui_sensuu_hojyo_kassen(Ten p, double r) {

        Ten q = new Ten();
        q.set(mottomo_tikai_Ten(p));//qは点pに近い方の端点
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
    //点pに?ﾅも近い??分の?A点pに近い方の端点を?A頂点とした?????A何本の選択された??分が?oているか?B?@20180918追加?i頂点とr以内に端点がある??分の???j
    public int tyouten_syuui_sensuu_select(Ten p, double r) {//rの値は0.0001位で頂点周りの?ﾜり?ﾝ判定とかはうまく動いている

        Ten q = new Ten();
        q.set(mottomo_tikai_Ten(p));//qは点pに近い方の端点
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


    //??分s0と全く?dなる??分が??分?W?№ﾌ中の??分にあれば?Aその番??を返す?Bなければ-10を返す?B
    public int kasanari_senbun_sagasi(Senbun s0) {

        for (int i = 1; i <= sousuu; i++) {
            if (oc.senbun_kousa_hantei(get(i), s0) == 31) {
                return i;
            }
        }
        return -10;


    }

    //??分s0と部分的に?dなる??分が??分?W?№ﾌ中の??分にあれば?A?ﾅ?奄ﾉ見つかった??分の番??を返す?Bなければ-10を返す?B
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


    //点pにもっとも近い?ﾜ??をその点pの影で分割する?Bただし?A点pの影がどれか?ﾜ??の端点と同じとみなされる???№ﾍ何もしない?B
    public void senbun_bunkatu(Ten p) {//点pが?ﾜ??の端点と一致していないことが前提


        int mts_id;
        mts_id = mottomo_tikai_senbun_sagasi(p);//mts_idは点pに?ﾅも近い??分の番??	public int ori_s.mottomo_tikai_senbun_sagasi(Ten p)
        Senbun mts = new Senbun(geta(mts_id), getb(mts_id));//mtsは点pに?ﾅも近い??分

        //直??t?繧ﾌ点pの影の位置?i点pと?ﾅも近い直??t?繧ﾌ位置?jを??める?Bpublic Ten oc.kage_motome(Tyokusen t,Ten p){}
        //??分を含む直??を得る public Tyokusen oc.Senbun2Tyokusen(Senbun s){}
        Ten pk = new Ten();
        pk.set(oc.kage_motome(oc.Senbun2Tyokusen(mts), p));//pkは点pの?i??分を含む直???繧ﾌ?j影
        if (pk.kyori(mottomo_tikai_Ten(pk)) < 0.000001) {
            return;
        }//この?sは?A点pが?ﾜ??の端点と一致していないことが前提
        //??分の分割-----------------------------------------
        senbun_bunkatu(mts_id, pk);  //i番目の??分(端点aとb)を点pで分割する?Bi番目の??分abをapに変え?A??分pbを加える?B
    }


    //?ﾜ??iをその点pの影で分割する?Bただし?A点pの影がどれか?ﾜ??の端点と同じとみなされる???№ﾍ何もしない?B
    public int senbun_bunkatu(Ten p, int i) {//何もしない=0,分割した=1

        int mts_id;
        mts_id = i;
        Senbun mts = new Senbun(geta(mts_id), getb(mts_id));//mtsは点pに?ﾅも近い??分

        //直??t?繧ﾌ点pの影の位置?i点pと?ﾅも近い直??t?繧ﾌ位置?jを??める?Bpublic Ten oc.kage_motome(Tyokusen t,Ten p){}
        //??分を含む直??を得る public Tyokusen oc.Senbun2Tyokusen(Senbun s){}
        Ten pk = new Ten();
        pk.set(oc.kage_motome(oc.Senbun2Tyokusen(mts), p));//pkは点pの?i??分を含む直???繧ﾌ?j影
        //if(pk.kyori(mottomo_tikai_Ten(pk))<0.000001) {return 0;}
        //??分の分割-----------------------------------------
        senbun_bunkatu(mts_id, pk);  //i番目の??分(端点aとb)を点pで分割する?Bi番目の??分abをapに変え?A??分pbを加える?B
        return 1;

    }


    public void add_sonomama(Orisensyuugou o_temp) {//別の?ﾜ???W?№ﾌ?ﾜ??を追加する?B単に追加するだけで?A他の????は一?ﾘしない?B
        for (int i = 1; i <= o_temp.getsousuu(); i++) {
            addsenbun(o_temp.geta(i), o_temp.getb(i), o_temp.getcolor(i));

        }
    }

    // --------------ccccccccc
    public void move(double dx, double dy) {//?ﾜ???W?≡S体の位置を移動する?B
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


    public void move(Ten ta, Ten tb, Ten tc, Ten td) {//?ﾜ???W?≡S体の位置を移動する?B
        double d;
        d = oc.kakudo(ta, tb, tc, td);
        double r;
        r = tc.kyori(td) / ta.kyori(tb);

        double dx;
        dx = tc.getx() - ta.getx();
        double dy;
        dy = tc.gety() - ta.gety();

        //oc.ten_kaiten(Ten a,Ten b,double d,double r)//点aを中?Sに点bをd度回転しabの距離がr倍の点を返す関???i元の点は変えずに?Vしい点を返す?j

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
                        sj = sen(j);//r_hitosiiとr_heikouhanteiは?Ahitosiiとheikou_hanteiのずれの許容程度

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


    public int fix1(double r_hitosii, double heikou_hantei) {//何もしなかったら0?A何か?C?ｳしたら1を返す?B
        unselect_all();
        for (int i = 1; i <= sousuu - 1; i++) {
            if (getcolor(i) != 3) {

                Senbun si;
                si = sen(i);
                for (int j = i + 1; j <= sousuu; j++) {
                    if (getcolor(j) != 3) {
                        Senbun sj;
                        sj = sen(j);//r_hitosiiとr_heikouhanteiは?Ahitosiiとheikou_hanteiのずれの許容程度
                        //T字型交?ｷ
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
                        sj = sen(j);//r_hitosiiとr_heikouhanteiは?Ahitosiiとheikou_hanteiのずれの許容程度

                        Senbun si1 = new Senbun();
                        si1.set(si);
                        Senbun sj1 = new Senbun();
                        sj1.set(sj);

                        //T字型交?ｷ
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


    public int fix2(double r_hitosii, double heikou_hantei) {//何もしなかったら0?A何か?C?ｳしたら1を返す?B
        unselect_all();
        for (int i = 1; i <= sousuu - 1; i++) {
            if (getcolor(i) != 3) {

                Senbun si;
                si = sen(i);
                for (int j = i + 1; j <= sousuu; j++) {
                    if (getcolor(j) != 3) {
                        Senbun sj;
                        sj = sen(j);//r_hitosiiとr_heikouhanteiは?Ahitosiiとheikou_hanteiのずれの許容程度
                        //T字型交?ｷ
                        //?ﾜ??iをその点pの影で分割する?Bただし?A点pの影がどれか?ﾜ??の端点と同じとみなされる???№ﾍ何もしない?B
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
//Cirには1番目からcir_size()番目までデ?[タが入っている
    public int cir_size() {
        return Cir.size() - 1;
    }

    public En cir_getEn(int i) {

        //if(sousuu+1> Senb.size()){while(sousuu+1> Senb.size()){Senb.add(new Senbun());}}//この文がないとうまく?sかない?Bなぜこの文でないといけないかという??由が?ｳ確にはわからない?B
        //return (Senbun)Senb.get(i);
        return (En) Cir.get(i);

    }

    public void cir_setEn(int i, En e0) {
        //iの指定があったとき?AEnはCirのi-1番目に格納される?@
        //i>cir_size()のときは?ACirのi-1番目の円はまだ定義されていないので?Aとりあえずi-1番目まで円を存?ﾝさせる必要がある


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

        //Cir.set(i,e0) ; //e0を直?ﾚCirのsetすると?ACirのEnはiが違っても全部e0で同じになるので?A途中にetempを?Vしくつくって?Ae0の値をコピ?[してCirにsetさせる?B
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
    }//Check3Senbには0番目からsize()-1番目までデ?[タが入っている

    public int check4_size() {
        return Check4Senb.size();
    }//Check4Senbには0番目からsize()-1番目までデ?[タが入っている

    public int check4_T_size() {
        return Check4Ten.size();
    }//Check4Tenには0番目からsize()-1番目までデ?[タが入っている

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

    public void check3(double r) {//頂点周囲の???買`ェック
        Check3Senb.clear();
        unselect_all();
        for (int i = 1; i <= sousuu; i++) {
            if (getcolor(i) != 3) {
                Senbun si;
                si = sen(i);
                Ten p = new Ten();
                int tss;    //頂点の周りの?ﾜ??の???B?@tss%2==0 偶???A==1 奇??
                int tss_red;    //頂点の周りの山?ﾜ??の???B
                int tss_blue;    //頂点の周りの谷?ﾜ??の???B
                int tss_black;    //頂点の周りの境界??の???B
                int tss_hojyo_kassen;    //頂点の周りの補?賦???の???B

                //-----------------
                p.set(si.geta());
                tss = tyouten_syuui_sensuu(p, r);
                tss_red = tyouten_syuui_sensuu_red(p, r);
                tss_blue = tyouten_syuui_sensuu_blue(p, r);
                tss_black = tyouten_syuui_sensuu_black(p, r);
                tss_hojyo_kassen = tyouten_syuui_sensuu_hojyo_kassen(p, r);
                //System.out.println("senbun("+i+") a : tss="+tss+", tss_red="+tss_red+", tss_blue="+tss_blue+", tss_black="+tss_black+", tss_hojyo_kassen="+tss_hojyo_kassen);
                //-----------------

                if ((tss_black != 0) && (tss_black != 2)) {//????がないか2本以外の???№ﾍおかしい?B
                    //System.out.println("20170216_1");
                    Check3Senb.add(new Senbun(p, p));//set_select(i,2);

                }


                if (tss_black == 0) {//????がない????
                    if (tss - tss_hojyo_kassen == tss_red + tss_blue) {//?i前提として境界は?浮ﾅ?A山谷未?ﾝ定?ﾜ??はないこと?B?j頂点周囲に?ﾔか?ﾂしかない?Bつまり?A用紙内部の点

                        if (Math.abs(tss_red - tss_blue) != 2) {//用紙内部の点で前??定??を満たさないのはダ??
                            //System.out.println("20170216_2");
                            Check3Senb.add(new Senbun(p, p));//set_select(i,2);
                        }
                    }
                    if (kakutyou_fushimi_hantei_naibu(p) == 0) {
                        //System.out.println("20170216_3");
                        Check3Senb.add(new Senbun(p, p));//set_select(i,2);
                    }


                }

                if (tss_black == 2) {//????が2本の????
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
                if ((tss_black != 0) && (tss_black != 2)) {//????がないか2本以外の???№ﾍおかしい?B
                    //System.out.println("20170216_4");
                    Check3Senb.add(new Senbun(p, p));//set_select(i,2);
                }

                if (tss_black == 0) {//????がない????
                    if (tss - tss_hojyo_kassen == tss_red + tss_blue) {//?i前提として境界は?浮ﾅ?A山谷未?ﾝ定?ﾜ??はないこと?B?j頂点周囲に?ﾔか?ﾂしかない?Bつまり?A用紙内部の点
                        if (Math.abs(tss_red - tss_blue) != 2) {//用紙内部の点で前??定??を満たさないのはダ??
                            //System.out.println("20170216_5");
                            Check3Senb.add(new Senbun(p, p));//set_select(i,2);
                        }
                    }
                    if (kakutyou_fushimi_hantei_naibu(p) == 0) {
                        //System.out.println("20170216_6");
                        Check3Senb.add(new Senbun(p, p));//set_select(i,2);
                    }


                }


                if (tss_black == 2) {//????が2本の????
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
    public void check4(double r) {//頂点周囲の???買`ェック
        Check4Senb.clear();
        Check4Ten.clear();

        unselect_all();

        //チェックすべき???鰍ﾌ?狽ｦ?繧ｰ
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
                //なぜか
                //Ten p=new Ten();
                //p.set(si.geta());
                //Check4Ten_jyuufuku_check(p)
                //p.set(si.getb());
                //Check4Ten_jyuufuku_check(p)
                //とすると前の2?sもp.set(si.getb());の???№ﾌ結果になってしまう?B
            }
        }

        System.out.println("check4_T_size() = " + check4_T_size());

        //チェックすべき???鰍ｪ平らに?ﾜりたたみ可能かの選別
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
    public int i_taira_ok(Ten p, double r) {//平らに?ﾜりたたみ可能=1
        double hantei_kyori = 0.00001;
        //点pに?ﾅも近い??分の?A点pに近い方の端点を?A頂点とした?????A何本の??分が?oているか?i頂点とr以内に端点がある??分の???j
        int i_tss = 0;    //i_tss%2==0 偶???A==1 奇??
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

            //pを端点とする?ﾜ??をNarabebakoに入れる
            if ((0 <= getcolor(i)) && (getcolor(i) <= 2)) { //この段階で補?賦???は?怩ｭ
                if (p.kyori(geta(i)) < hantei_kyori) {
                    nbox.ire_i_tiisaijyun(new int_double(i, oc.kakudo(geta(i), getb(i))));
                } else if (p.kyori(getb(i)) < hantei_kyori) {
                    nbox.ire_i_tiisaijyun(new int_double(i, oc.kakudo(getb(i), geta(i))));
                }
            }
        }


        // 判定開始-------------------------------------------

        if ((i_tss_black != 0) && (i_tss_black != 2)) {//????がないか2本以外の???№ﾍおかしい?B
            return 0;
        }

        if (i_tss_black == 0) {//????がない????
            if (Math.abs(i_tss_red - i_tss_blue) != 2) {//用紙内部の点で前??定??を満たさないのはダ??
                return 0;
            }
// --------------------------


/*

		//pを端点とする?ﾜ??をNarabebakoに入れる
		Narabebako_int_double nbox =new Narabebako_int_double();
		for (int i=1; i<=getsousuu(); i++ ){ if((0<=getcolor(i))&&(getcolor(i)<=2)){ //この段階で補?賦???は?怩ｭ
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

        if (i_tss_black == 2) {//????が2本の????


// ------------------

            //double hantei_kyori=0.00001;

/*
		//pを端点とする?ﾜ??をNarabebakoに入れる
		Narabebako_int_double nbox =new Narabebako_int_double();
		for (int i=1; i<=getsousuu(); i++ ){ if((0<=getcolor(i))&&(getcolor(i)<=2)){ //この段階で補?賦???は?怩ｭ
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
        //_oldをとればオリジナルのcheck4(double r)関?狽ﾆして??動する
        //頂点周囲の???買`ェック
        Check4Senb.clear();
        unselect_all();
        for (int i = 1; i <= sousuu; i++) {
            if (getcolor(i) != 3) {
                Senbun si;
                si = sen(i);
                Ten p = new Ten();
                int tss;    //tss%2==0 偶???A==1 奇??
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

                if ((tss_black != 0) && (tss_black != 2)) {//????がないか2本以外の???№ﾍおかしい?B
                    //System.out.println("20170216_1");
                    Check4Senb.add(new Senbun(p, p));//set_select(i,2);

                }


                if (tss_black == 0) {//????がない????
                    if (tss - tss_cyan == tss_red + tss_blue) {//?i前提として境界は?浮ﾅ?A山谷未?ﾝ定?ﾜ??はないこと?B?j頂点周囲に?ﾔか?ﾂしかない?Bつまり?A用紙内部の点

                        if (Math.abs(tss_red - tss_blue) != 2) {//用紙内部の点で前??定??を満たさないのはダ??
                            //System.out.println("20170216_2");
                            Check4Senb.add(new Senbun(p, p));//set_select(i,2);
                        }
                    }
                    if (kakutyou_fushimi_hantei_naibu(p) == 0) {
                        //System.out.println("20170216_3");
                        Check4Senb.add(new Senbun(p, p));//set_select(i,2);
                    }


                }

                if (tss_black == 2) {//????が2本の????
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
                if ((tss_black != 0) && (tss_black != 2)) {//????がないか2本以外の???№ﾍおかしい?B
                    //System.out.println("20170216_4");
                    Check4Senb.add(new Senbun(p, p));//set_select(i,2);
                }

                if (tss_black == 0) {//????がない????
                    if (tss - tss_cyan == tss_red + tss_blue) {//?i前提として境界は?浮ﾅ?A山谷未?ﾝ定?ﾜ??はないこと?B?j頂点周囲に?ﾔか?ﾂしかない?Bつまり?A用紙内部の点
                        if (Math.abs(tss_red - tss_blue) != 2) {//用紙内部の点で前??定??を満たさないのはダ??
                            //System.out.println("20170216_5");
                            Check4Senb.add(new Senbun(p, p));//set_select(i,2);
                        }
                    }
                    if (kakutyou_fushimi_hantei_naibu(p) == 0) {
                        //System.out.println("20170216_6");
                        Check4Senb.add(new Senbun(p, p));//set_select(i,2);
                    }


                }


                if (tss_black == 2) {//????が2本の????
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

    //Ten p に?ﾅも近い用紙辺部の端点が拡張伏見定??を満たすか判定
    public int kakutyou_fushimi_hantei_henbu(Ten p) {//return?@0=満たさない?A?@1=満たす?B?@
        double hantei_kyori = 0.00001;

        Ten t1 = new Ten();
        t1.set(mottomo_tikai_Ten_with_icol_0_1_2(p));//点pに?ﾅも近い?A?u??分の端点?vを返すori_s.mottomo_tikai_Tenは近い点がないと p_return.set(100000.0,100000.0)と返してくる

        //t1を端点とする?ﾜ??をNarabebakoに入れる
        Narabebako_int_double nbox = new Narabebako_int_double();
        for (int i = 1; i <= getsousuu(); i++) {
            if ((0 <= getcolor(i)) && (getcolor(i) <= 2)) { //この段階で補?賦???は?怩ｭ
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
    public int kakutyou_fushimi_hantei_henbu(Ten p, Narabebako_int_double nbox) {//return?@0=満たさない?A?@1=満たす?B?@
        double hantei_kyori = 0.00001;

        int tikai_orisen_jyunban;
        int tooi_orisen_jyunban;
        if (nbox.getsousuu() == 2) {//t1を端点とする?ﾜ??の?狽ｪ2のとき
            if (getcolor(nbox.get_int(1)) != 0) {//1本目が?浮ﾅないならダ??
                return 0;
            }
            if (getcolor(nbox.get_int(2)) != 0) {//2本目が?浮ﾅないならダ??
                return 0;
            }

            //2本の??種が????
            return 1;
        }


        //以下はt1を端点とする?ﾜ??の?狽ｪ3以?繧ﾌ偶?狽ﾌとき

        //fushimi_hantei_kakudo_goukei=360.0;


        //辺の?ﾜ??が,ならべばこnbox,の一番目と?ﾅ後の?∑ﾔになるようにする?B

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

        //ならべばこnbox,の一番目の?ﾜ??がx軸となす角度が0になるようにする?B
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


        while (nbox.getsousuu() > 2) {//点から?oる?ﾜ??の?狽ｪ2になるまで実?sする
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

    public Narabebako_int_double kakutyou_fushimi_hantei_henbu_tejyun(Narabebako_int_double nbox0) {//拡張伏見定??のようにして辺部の点で隣?ﾚする３角度を1つの角度にするか辺部の角を?墲髑???
        Narabebako_int_double nboxtemp = new Narabebako_int_double();
        Narabebako_int_double nbox1 = new Narabebako_int_double();
        int tikai_orisen_jyunban = 1;
        int tooi_orisen_jyunban = 2;

        double kakudo_min = 10000.0;
        double temp_kakudo;


        //角度の?ﾅ?ｬ値kakudo_minを??める
        for (int k = 1; k <= nbox0.getsousuu() - 1; k++) {//kは角度の?∑ﾔ
            temp_kakudo = nbox0.get_double(k + 1) - nbox0.get_double(k);
            if (temp_kakudo < kakudo_min) {
                kakudo_min = temp_kakudo;
            }
        }


        //k=1
        temp_kakudo = nbox0.get_double(2) - nbox0.get_double(1);
        if (Math.abs(temp_kakudo - kakudo_min) < 0.00001) {// ?ﾜ??を1つ減らせる??に適?№ｵたので?A?Vたにnbox1を??ってリタ?[ンする?B
            for (int i = 2; i <= nbox0.getsousuu(); i++) {
                int_double i_d_0 = new int_double();
                i_d_0.set(nbox0.get_i_d(i));
                nbox1.add(i_d_0);
            }
            return nbox1;
        }

        //k=nbox0.getsousuu()-1
        temp_kakudo = nbox0.get_double(nbox0.getsousuu()) - nbox0.get_double(nbox0.getsousuu() - 1);
        if (Math.abs(temp_kakudo - kakudo_min) < 0.00001) {// ?ﾜ??を1つ減らせる??に適?№ｵたので?A?Vたにnbox1を??ってリタ?[ンする?B
            for (int i = 1; i <= nbox0.getsousuu() - 1; i++) {
                int_double i_d_0 = new int_double();
                i_d_0.set(nbox0.get_i_d(i));
                nbox1.add(i_d_0);
            }
            return nbox1;
        }

        for (int k = 2; k <= nbox0.getsousuu() - 2; k++) {//kは角度の?∑ﾔ
            temp_kakudo = nbox0.get_double(k + 1) - nbox0.get_double(k);
            if (Math.abs(temp_kakudo - kakudo_min) < 0.00001) {
                if (getcolor(nbox0.get_int(k)) != getcolor(nbox0.get_int(k + 1))) {//この???№ﾉ隣?ﾚする３角度を1つの角度にする
                    // ?ﾜ??を2つ減らせる??に適?№ｵたので?A?Vたにnbox1を??ってリタ?[ンする?B


                    double kijyun_kakudo = nbox0.get_double(3);
                    //System.out.println("?ﾜ??を2つ減らせる??に適?№ｵたので?A?Vたにnbox1を??ってリタ?[ンする?B kijyun_kakudo="+kijyun_kakudo);


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

        // ?ﾜ??を減らせる??に適?№ｵた角がなかった???㌻box0とおなじnbox1を??ってリタ?[ンする?B
        for (int i = 1; i <= nbox0.getsousuu(); i++) {
            nbox1.add(nbox0.get_i_d(i));
        }
        return nbox1;
    }


// ***************************************************************

    double fushimi_hantei_kakudo_goukei = 360.0;
// ***************************************************************


    //Ten p に?ﾅも近い用紙内部の端点が拡張伏見定??を満たすか判定
    public int kakutyou_fushimi_hantei_naibu(Ten p) {//return?@0=満たさない?A?@1=満たす?B?@
        double hantei_kyori = 0.00001;

        Ten t1 = new Ten();
        t1.set(mottomo_tikai_Ten_with_icol_0_1_2(p));//点pに?ﾅも近い?A?u??分の端点?vを返すori_s.mottomo_tikai_Tenは近い点がないと p_return.set(100000.0,100000.0)と返してくる

        //t1を端点とする?ﾜ??をNarabebakoに入れる
        Narabebako_int_double nbox = new Narabebako_int_double();
        for (int i = 1; i <= getsousuu(); i++) {
            if ((0 <= getcolor(i)) && (getcolor(i) <= 2)) { //この段階で補?賦???は?怩ｭ
                if (t1.kyori(geta(i)) < hantei_kyori) {
                    nbox.ire_i_tiisaijyun(new int_double(i, oc.kakudo(geta(i), getb(i))));
                } else if (t1.kyori(getb(i)) < hantei_kyori) {
                    nbox.ire_i_tiisaijyun(new int_double(i, oc.kakudo(getb(i), geta(i))));
                }
            }
        }

        return kakutyou_fushimi_hantei_naibu(p, nbox);

    }

    public int kakutyou_fushimi_hantei_naibu(Ten p, Narabebako_int_double nbox) {//return?@0=満たさない?A?@1=満たす?B?@
        double hantei_kyori = 0.00001;

        if (nbox.getsousuu() % 2 == 1) {//t1を端点とする?ﾜ??の?狽ｪ奇?狽ﾌとき
            return 0;
        }


        int tikai_orisen_jyunban;
        int tooi_orisen_jyunban;
        if (nbox.getsousuu() == 2) {//t1を端点とする?ﾜ??の?狽ｪ2のとき
            if (getcolor(nbox.get_int(1)) != getcolor(nbox.get_int(2))) {//2本の??種が違うなら角度関係なしにダ??
                //System.out.println("20170216_12");
                return 0;
            }

            //以下は2本の??種が?ﾂ?ﾂ?Aまたは?ﾔ?ﾔの????
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

        //以下はt1を端点とする?ﾜ??の?狽ｪ4以?繧ﾌ偶?狽ﾌとき

        fushimi_hantei_kakudo_goukei = 360.0;

        Narabebako_int_double nbox1 = new Narabebako_int_double();

        while (nbox.getsousuu() > 2) {//点から?oる?ﾜ??の?狽ｪ2になるまで実?sする
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

        return 0;//この0だけ?A角度がおかしいという意味
    }


// ------------------------------------------------------------------------------------------------------------------------------------

    public Narabebako_int_double kakutyou_fushimi_hantei_naibu_tejyun(Narabebako_int_double nbox0) {//拡張伏見定??で隣?ﾚする３角度を1つの角度にする操??
        Narabebako_int_double nboxtemp = new Narabebako_int_double();
        Narabebako_int_double nbox1 = new Narabebako_int_double();
        int tikai_orisen_jyunban = 1;
        int tooi_orisen_jyunban = 2;

        double kakudo_min = 10000.0;


        //System.out.println("伏見判定?@頂点周りの角度?㈹v = "+fushimi_hantei_kakudo_goukei);
        //角度の?ﾅ?ｬ値kakudo_minを??める
        for (int k = 1; k <= nbox0.getsousuu(); k++) {//kは角度の?∑ﾔ
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


            //System.out.println("角度の網羅?@"+k+"番目:  "+
            //nbox0.get_double(tooi_orisen_jyunban)+" - "+
            //nbox0.get_double(tikai_orisen_jyunban)+" = "+
            //temp_kakudo);


            if (temp_kakudo < kakudo_min) {
                kakudo_min = temp_kakudo;
            }
        }

        //System.out.println("kakudo_min="+kakudo_min);

        for (int k = 1; k <= nbox0.getsousuu(); k++) {//kは角度の?∑ﾔ
            double temp_kakudo = oc.kakudo_osame_0_kmax(nbox0.get_double(2) - nbox0.get_double(1), fushimi_hantei_kakudo_goukei);

            //System.out.println("k="+k+",temp_kakudo="+temp_kakudo);

            if (Math.abs(temp_kakudo - kakudo_min) < 0.00001) {
                //if(Math.abs(temp_kakudo-kakudo_min)<0.001){


                //System.out.println("   getcolor(nbox0.get_int(1))="+getcolor(nbox0.get_int(1))+",getcolor(nbox0.get_int(2))="+getcolor(nbox0.get_int(2)));
                if (getcolor(nbox0.get_int(1)) != getcolor(nbox0.get_int(2))) {//この???№ﾉ隣?ﾚする３角度を1つの角度にする
                    // ?ﾜ??を2つ減らせる??に適?№ｵたので?A?Vたにnbox1を??ってリタ?[ンする?B


                    double kijyun_kakudo = nbox0.get_double(3);
                    //System.out.println("?ﾜ??を2つ減らせる??に適?№ｵたので?A?Vたにnbox1を??ってリタ?[ンする?B kijyun_kakudo="+kijyun_kakudo);


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

        // ?ﾜ??を2つ減らせる??に適?№ｵた角がなかった???㌻box0とおなじnbox1を??ってリタ?[ンする?B
        for (int i = 1; i <= nbox0.getsousuu(); i++) {
            nbox1.add(nbox0.get_i_d(i));
        }
        return nbox1;
    }


    // ---------------------------
    public int X_koisa_ari_nasi(Senbun s0) {//s0とX字で交?ｷする?ﾜ??があれば1?Aなければ0を返す
        for (int i = 1; i <= sousuu; i++) {
            if (oc.senbun_kousa_hantei(get(i), s0, 0.00001, 0.00001) == 1) {
                return 1;
            }
        }
        return 0;
    }


    // ---------------------------
    public double get_x_max() {//sousuu=0のときは0.0を返す
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
    public double get_x_min() {//sousuu=0のときは0.0を返す
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
    public double get_y_max() {//sousuu=0のときは0.0を返す
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
    public double get_y_min() {//sousuu=0のときは0.0を返す
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
    public int TL_koisa_ari_nasi(Senbun s0) {//s0とT字またはL字で交?ｷする?ﾜ??があれば1?Aなければ0を返す
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