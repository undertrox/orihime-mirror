package jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin.jyougehyou;


import jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin.jyougehyou.touka_jyouken.Touka_jyouken;

import java.util.ArrayList;

public class Jyougehyou {//このクラスは?ﾜり?�んだ?ﾛの面の?繪ｺ関係を記録?A活用するのに使う?B
    int Mensuu;             //?ﾜりたたむ前の展開?}の面の??

    //  jg[][]は?ﾜる前の展開?}のすべての面同士の?繪ｺ関係を1つの表にまとめたものとして扱う
    //?@jg[i][j]が1なら面iは面jの?繿､?B0なら下側?B
    //  jg[i][j]が-50なら?A面iとjは?dなが?A?繪ｺ関係は決められていない?B
    //jg[i][j]が-100なら?A面iとjは?dなるところがない?B
    int[][] jg;
    int[][] jg_h;
    int Touka_jyoukensuu;   //２つの隣?ﾚする面の境界??を他の面が突き抜ける?�況が?ｶじうる組み?���椹?B
    Touka_jyouken tj = new Touka_jyouken();

    ArrayList tL = new ArrayList();

    int uTouka_jyoukensuu;

    ArrayList uL = new ArrayList();
    Touka_jyouken uj = new Touka_jyouken();//２つの隣?ﾚする面a,bの境界??と２つの隣?ﾚする面c,dの境界??が?A平?sかつ一部?dなっていて?A
    //さらにa,b,c,dがあるSmenで共存する???�の?A境界??で突き抜けが?ｶじうる組み?���椹


    public Jyougehyou() {//コンストラクタ
        reset();
    }

    //
    public void reset() {
        tL.clear();
        tL.add(new Touka_jyouken());
        uL.clear();
        uL.add(new Touka_jyouken());
        Touka_jyoukensuu = 0;
        uTouka_jyoukensuu = 0;
    }

    //
    public void jg_hozon() {
        for (int i = 1; i <= Mensuu; i++) {
            for (int j = 1; j <= Mensuu; j++) {
                jg_h[i][j] = jg[i][j];
            }
        }
    }

    //
    public void jg_fukugen() {
        for (int i = 1; i <= Mensuu; i++) {
            for (int j = 1; j <= Mensuu; j++) {
                jg[i][j] = jg_h[i][j];
            }
        }
    }

    //
    public void set(int i, int j, int jyoutai) {
        jg[i][j] = jyoutai;
        //	System.out.print(i);System.out.print(":?繪ｺ表:");System.out.println(j);
    }

    public int get(int i, int j) {
        return jg[i][j];
    }

    public void setMensuu(int iM) {
        Mensuu = iM;

        int[][] j_g = new int[Mensuu + 1][Mensuu + 1];
        int[][] j_g_h = new int[Mensuu + 1][Mensuu + 1];

        jg = j_g;
        jg_h = j_g_h;


        for (int i = 0; i <= Mensuu; i++) {
            for (int j = 0; j <= Mensuu; j++) {
                jg[i][j] = -100;
                jg_h[i][j] = -100;
            }
        }
    }


    public int getMensuu() {
        return Mensuu;
    }


    public int getTouka_jyoukensuu() {
        return Touka_jyoukensuu;
    }

    public Touka_jyouken getTouka_jyouken(int i) {
        return (Touka_jyouken) tL.get(i);
    }


    //等価?��?の追加?B棒ibの境界として隣?ﾚする2つの面im1,im2が有る?????A?ﾜり?�み??定した???�に
    //棒ibの一部と?dなる位置に有る面imは面im1と面im2に?繪ｺ方向で挟まれることはない?Bこのことから
    //gj[im1][im]=gj[im2][im]という等価?��?が?ｬり立つ?B
    public void addTouka_jyouken(int ai, int bi, int ci, int di) {
        Touka_jyoukensuu = Touka_jyoukensuu + 1;
        tL.add(new Touka_jyouken(ai, bi, ci, di));
    }

    public int get_uTouka_jyoukensuu() {
        return uTouka_jyoukensuu;
    }

    public Touka_jyouken get_uTouka_jyouken(int i) {
        return (Touka_jyouken) uL.get(i);
    }


    //等価?��?の追加?B棒ibの境界として隣?ﾚする2つの面im1,im2が有り?A
    //また棒jbの境界として隣?ﾚする2つの面im3,im4が有り?Aibとjbが平?sで?A一部?dなる?????A?ﾜり?�み??定した???�に
    //棒ibの面と面jbの面がi,j,i,j?@または?@j,i,j,i?@と並ぶことはない?Bもしこれがおきたら?A
    //?ﾅ?奄ｩら3番目で間違いが起きているので?Aこの3番目のところがSmenで何桁目かを??めて?Aこの桁を１?iめる?B

    public void add_uTouka_jyouken(int ai, int bi, int ci, int di) {
        uTouka_jyoukensuu = uTouka_jyoukensuu + 1;

        uL.add(new Touka_jyouken(ai, bi, ci, di));
    }


}