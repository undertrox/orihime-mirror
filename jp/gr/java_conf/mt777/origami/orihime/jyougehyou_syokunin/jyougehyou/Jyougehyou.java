package jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin.jyougehyou;


import jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin.jyougehyou.touka_jyouken.Touka_jyouken;

import java.util.ArrayList;

public class Jyougehyou {//‚±‚ÌƒNƒ‰ƒX‚Í?Ü‚è?ô‚ñ‚¾?Û‚Ì–Ê‚Ì?ã‰ºŠÖŒW‚ð‹L˜^?AŠˆ—p‚·‚é‚Ì‚ÉŽg‚¤?B
    int Mensuu;             //?Ü‚è‚½‚½‚Þ‘O‚Ì“WŠJ?}‚Ì–Ê‚Ì??

    //  jg[][]‚Í?Ü‚é‘O‚Ì“WŠJ?}‚Ì‚·‚×‚Ä‚Ì–Ê“¯Žm‚Ì?ã‰ºŠÖŒW‚ð1‚Â‚Ì•\‚É‚Ü‚Æ‚ß‚½‚à‚Ì‚Æ‚µ‚Äˆµ‚¤
    //?@jg[i][j]‚ª1‚È‚ç–Êi‚Í–Êj‚Ì?ã‘¤?B0‚È‚ç‰º‘¤?B
    //  jg[i][j]‚ª-50‚È‚ç?A–Êi‚Æj‚Í?d‚È‚ª?A?ã‰ºŠÖŒW‚ÍŒˆ‚ß‚ç‚ê‚Ä‚¢‚È‚¢?B
    //jg[i][j]‚ª-100‚È‚ç?A–Êi‚Æj‚Í?d‚È‚é‚Æ‚±‚ë‚ª‚È‚¢?B
    int[][] jg;
    int[][] jg_h;
    int Touka_jyoukensuu;   //‚Q‚Â‚Ì—×?Ú‚·‚é–Ê‚Ì‹«ŠE??‚ð‘¼‚Ì–Ê‚ª“Ë‚«”²‚¯‚é?ó‹µ‚ª?¶‚¶‚¤‚é‘g‚Ý?‡‚úž¹?B
    Touka_jyouken tj = new Touka_jyouken();

    ArrayList tL = new ArrayList();

    int uTouka_jyoukensuu;

    ArrayList uL = new ArrayList();
    Touka_jyouken uj = new Touka_jyouken();//‚Q‚Â‚Ì—×?Ú‚·‚é–Êa,b‚Ì‹«ŠE??‚Æ‚Q‚Â‚Ì—×?Ú‚·‚é–Êc,d‚Ì‹«ŠE??‚ª?A•½?s‚©‚Âˆê•”?d‚È‚Á‚Ä‚¢‚Ä?A
    //‚³‚ç‚Éa,b,c,d‚ª‚ ‚éSmen‚Å‹¤‘¶‚·‚é???‡‚Ì?A‹«ŠE??‚Å“Ë‚«”²‚¯‚ª?¶‚¶‚¤‚é‘g‚Ý?‡‚úž¹


    public Jyougehyou() {//ƒRƒ“ƒXƒgƒ‰ƒNƒ^
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
        //	System.out.print(i);System.out.print(":?ã‰º•\:");System.out.println(j);
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


    //“™‰¿?ðŒ?‚Ì’Ç‰Á?B–_ib‚Ì‹«ŠE‚Æ‚µ‚Ä—×?Ú‚·‚é2‚Â‚Ì–Êim1,im2‚ª—L‚é?????A?Ü‚è?ô‚Ý??’è‚µ‚½???‡‚É
    //–_ib‚Ìˆê•”‚Æ?d‚È‚éˆÊ’u‚É—L‚é–Êim‚Í–Êim1‚Æ–Êim2‚É?ã‰º•ûŒü‚Å‹²‚Ü‚ê‚é‚±‚Æ‚Í‚È‚¢?B‚±‚Ì‚±‚Æ‚©‚ç
    //gj[im1][im]=gj[im2][im]‚Æ‚¢‚¤“™‰¿?ðŒ?‚ª?¬‚è—§‚Â?B
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


    //“™‰¿?ðŒ?‚Ì’Ç‰Á?B–_ib‚Ì‹«ŠE‚Æ‚µ‚Ä—×?Ú‚·‚é2‚Â‚Ì–Êim1,im2‚ª—L‚è?A
    //‚Ü‚½–_jb‚Ì‹«ŠE‚Æ‚µ‚Ä—×?Ú‚·‚é2‚Â‚Ì–Êim3,im4‚ª—L‚è?Aib‚Æjb‚ª•½?s‚Å?Aˆê•”?d‚È‚é?????A?Ü‚è?ô‚Ý??’è‚µ‚½???‡‚É
    //–_ib‚Ì–Ê‚Æ–Êjb‚Ì–Ê‚ªi,j,i,j?@‚Ü‚½‚Í?@j,i,j,i?@‚Æ•À‚Ô‚±‚Æ‚Í‚È‚¢?B‚à‚µ‚±‚ê‚ª‚¨‚«‚½‚ç?A
    //?Å?‰‚©‚ç3”Ô–Ú‚ÅŠÔˆá‚¢‚ª‹N‚«‚Ä‚¢‚é‚Ì‚Å?A‚±‚Ì3”Ô–Ú‚Ì‚Æ‚±‚ë‚ªSmen‚Å‰½Œ…–Ú‚©‚ð??‚ß‚Ä?A‚±‚ÌŒ…‚ð‚P?i‚ß‚é?B

    public void add_uTouka_jyouken(int ai, int bi, int ci, int di) {
        uTouka_jyoukensuu = uTouka_jyoukensuu + 1;

        uL.add(new Touka_jyouken(ai, bi, ci, di));
    }


}