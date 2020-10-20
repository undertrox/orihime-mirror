package jp.gr.java_conf.mt777.origami.orihime.egaki_syokunin;

import jp.gr.java_conf.mt777.kiroku.memo.Memo;
import jp.gr.java_conf.mt777.origami.dougu.camera.Camera;
import jp.gr.java_conf.mt777.origami.dougu.orisensyuugou.Orisensyuugou;
import jp.gr.java_conf.mt777.origami.dougu.senbunsyuugou.Senbunsyuugou;
import jp.gr.java_conf.mt777.origami.orihime.ap;
import jp.gr.java_conf.mt777.origami.orihime.egaki_syokunin.egaki_syokunin_dougubako.Egaki_Syokunin_Dougubako;
import jp.gr.java_conf.mt777.seiretu.narabebako.int_double;
import jp.gr.java_conf.mt777.zukei2d.oritacalc.OritaCalc;
import jp.gr.java_conf.mt777.zukei2d.oritaoekaki.OritaOekaki;
import jp.gr.java_conf.mt777.zukei2d.senbun.Senbun;
import jp.gr.java_conf.mt777.zukei2d.takakukei.Takakukei;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.math.BigDecimal;
import java.util.ArrayList;


// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
public class Egaki_Syokunin {
    OritaCalc oc = new OritaCalc(); //ŠeŽíŒvŽZ—p‚ÌŠÖ?”‚ðŽg‚¤‚½‚ß‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»
    //double r_ten=3.0;                   //Šî–{Ž}?\‘¢‚Ì’¼?ü‚Ì—¼’[‚Ì‰~‚Ì”¼Œa?AŽ}‚ÆŠeŽíƒ|ƒCƒ“ƒg‚Ì‹ß‚³‚Ì”»’èŠî?€
    int ir_ten = 1;

    int icol;//?ü•ª‚Ì?F
    int h_icol = 4;//•â?•?ü‚Ì?F

    //int taisyousei;

    int i_hanasi = 0;//ƒ}ƒEƒXˆÊ’u‚Æ“ü—Í“_‚Ì?À•W‚ð—£‚·‚È‚ç‚P?A—£‚³‚È‚¢‚È‚ç‚O
    int i_kou_mitudo_nyuuryoku = 0;//ŠiŽq•\Ž¦‚ª?×‚©‚¢?ê?‡—p‚Ì“ü—Í•â?•‹@”\‚ðŽg‚¤‚È‚ç‚P?AŽg‚í‚È‚¢‚È‚ç‚O

    Ten pa = new Ten(); //ƒ}ƒEƒXƒ{ƒ^ƒ“‚ª‰Ÿ‚³‚ê‚½ˆÊ’u‚©‚ça“_‚Ü‚Å‚ÌƒxƒNƒgƒ‹
    Ten pb = new Ten(); //ƒ}ƒEƒXƒ{ƒ^ƒ“‚ª‰Ÿ‚³‚ê‚½ˆÊ’u‚©‚çb“_‚Ü‚Å‚ÌƒxƒNƒgƒ‹

    Color sen_tokutyuu_color;//‰~‚â•â?•Šˆ?ü‚Ì“Á’??F‚ðŠi”[


    Undo_Box Ubox = new Undo_Box();
    Undo_Box h_Ubox = new Undo_Box();

    Ten moyori_ten = new Ten(100000.0, 100000.0); //ƒ}ƒEƒX?ÅŠñ‚Ì“_?Bget_moyori_ten(Ten p)‚Å‹?‚ß‚é?B
    Senbun moyori_senbun = new Senbun(100000.0, 100000.0, 100000.0, 100000.1); //ƒ}ƒEƒX?ÅŠñ‚Ì?ü•ª
    Senbun moyori_step_senbun = new Senbun(100000.0, 100000.0, 100000.0, 100000.1); //ƒ}ƒEƒX?ÅŠñ‚Ìstep?ü•ª(?ü•ª’Ç‰Á‚Ì‚½‚ß‚Ì?€”õ‚ð‚·‚é‚½‚ß‚Ì?ü•ª)?B‚È‚¨?A‚±‚±‚Å?éŒ¾‚·‚é•K—v‚Í‚È‚¢‚Ì‚Å?A‚Ç‚±‚Å?éŒ¾‚·‚×‚«‚©—vŒŸ“¢20161113
    En moyori_ensyuu = new En(100000.0, 100000.0, 10.0, 8); //ƒ}ƒEƒX?ÅŠñ‚Ì‰~Žü‚ðŽ?‚Â‰~
    En moyori_step_ensyuu = new En(100000.0, 100000.0, 10.0, 8); //ƒ}ƒEƒX?ÅŠñ‚Ì‰~Žü‚ðŽ?‚Âstep‰~

    int i_orisen_hojyosen = 0;//=0‚Í?Ü?ü“ü—Í?@=1‚Í•â?•?ü“ü—Íƒ‚?[ƒh(?ü•ª“ü—ÍŽž‚Í‚±‚Ì‚Q‚Â)?B?ü•ª?í?œŽž‚Í?X‚É’l‚ªˆÈ‰º‚Ì—l‚É‚È‚é?B=0‚Í?Ü?ü‚Ì?í?œ?A=1‚Í•â?•ŠG?ü?í?œ?A=2‚Í?•?ü?í?œ?A=3‚Í•â?•Šˆ?ü?í?œ?A=4‚Í?Ü?ü‚Æ•â?•Šˆ?ü‚Æ•â?•ŠG?ü

    int ugokasi_mode = 0;    //Ž}‚ð“®‚©‚·“®?ìƒ‚?[ƒh?B0=‚È‚É‚à‚µ‚È‚¢?A1=a“_‚ð“®‚©‚·?A2=b“_‚ð“®‚©‚·?A3=Ž}‚ð•½?sˆÚ“® ?A4=?V‹K’Ç‰Á
    int ieda;              //ƒAƒNƒeƒBƒu‚ÈŽ}‚Ì”Ô?†

    //  int i_saigo_no_senbun_no_maru_kaku=1;	//1•`‚­?A0•`‚©‚È‚¢

    public Orisensyuugou ori_s = new Orisensyuugou();    //?Ü?ü‚ðŠi”[‚·‚é
    Orisensyuugou hoj_s = new Orisensyuugou();    //•â?•?ü‚ðŠi”[‚·‚é


    public Orisensyuugou ori_v = new Orisensyuugou();    //ƒ{ƒ?ƒmƒC?}‚Ì?ü‚ðŠi”[‚·‚é

    Egaki_Syokunin_Dougubako e_s_dougubako = new Egaki_Syokunin_Dougubako(ori_s);

    private final Senbunsyuugou sen_s = new Senbunsyuugou();    //Šî–{Ž}?\‘¢‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»
    //private Senbunsyuugou sen_s;    //Šî–{Ž}?\‘¢‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»

    Takakukei gomibako = new Takakukei(4);    //ƒSƒ~” ‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»
    Takakukei tyuuoutai = new Takakukei(4);    //’†‰›‘Ñ‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»
    double tyuuoutai_xmin = 180.0;
    double tyuuoutai_xmax = 206.0;
    double tyuuoutai_ymin = 50.0;
    double tyuuoutai_ymax = 300.0;

    double kijyun_kakudo = 22.5; //<<<<<<<<<<<<<<<<<<<<<<<Šî?€Šp“x<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    //int i_kakudo_kei=36;
    int id_kakudo_kei = 8;//  180/id_kakudo_kei‚ªŠp“xŒn‚ð•\‚·?B‚½‚Æ‚¦‚Î?Aid_kakudo_kei=3‚È‚ç180/3??60“xŒn?Aid_kakudo_kei=5‚È‚ç180/5??36“xŒn
    //360/i_kakudo_kei-1 = id_kakudo_kei*2-1

    double d_kakudo_kei;//d_kakudo_kei=180.0/(double)id_kakudo_kei
    double kakudo;

    //“ü—Í•û–@—p‚Ìƒpƒ‰ƒ??[ƒ^
    int nyuuryoku_houhou = 0;
    //int nyuuryoku_kitei=0;

    int i_orisen_bunkatu_suu = 1;
    double d_naibun_s;
    double d_naibun_t;

    double d_jiyuu_kaku_1;
    double d_jiyuu_kaku_2;
    double d_jiyuu_kaku_3;

    int i_sei_takakukei = 5;

    int kensa_houhou = 0;
    int nhi = 0;


    Ten nhTen = new Ten();
    Ten nhTen1 = new Ten();

    public Kousi kus = new Kousi();

    double d_hantei_haba = 50.0;//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<“ü—Í“_‚ªŠù‘¶‚Ì“_‚â?ü•ª‚Æ‹ß‚¢‚©‚Ç‚¤‚©‚ð”»’è‚·‚éŽž‚Ì’l


    public int i_egaki_dankai;//?Ü?ü‚ð•`‚­Žè?‡‚Ì‚Ç‚Ì’iŠK‚É‚¢‚é‚©‚Ì?î•ñ‚ðŠi”[
    int i_en_egaki_dankai;//‰~‚ð•`‚­Žè?‡‚Ì‚Ç‚Ì’iŠK‚É‚¢‚é‚©‚Ì?î•ñ‚ðŠi”[
    Senbun[] s_step = new Senbun[1024];//•`‰æŽž‚ÌˆêŽž•\Ž¦—p‚ÉŽg‚¤?Bs_step[0] ‚ÍŽÀ?Û‚ÍŽg‚í‚¸?As_step[1]‚©‚çŽg‚¤?B
    En[] e_step = new En[1024];//•`‰æŽž‚ÌˆêŽž•\Ž¦—p‚ÉŽg‚¤?Be_step[0] ‚ÍŽÀ?Û‚ÍŽg‚í‚¸?Ae_step[1]‚©‚çŽg‚¤?B


    public int i_kouho_dankai;//?Ü?ü‚ð•`‚­Žè?‡‚Ì‚Ç‚ÌŒó•â‚©‚Ì?î•ñ‚ðŠi”[
    int i_en_kouho_dankai;//‰~‚ð•`‚­Žè?‡‚Ì‚Ç‚ÌŒó•â‚©‚Ì?î•ñ‚ðŠi”[
    Senbun[] s_kouho = new Senbun[16];//•`‰æŽž‚Ì‘I‘ðŒó•â•\Ž¦—p‚ÉŽg‚¤?Bs_kouho[0] ‚ÍŽÀ?Û‚ÍŽg‚í‚¸?As_kouho[1]‚©‚çŽg‚¤?B
    En[] e_kouho = new En[16];//•`‰æŽž‚Ì‘I‘ðŒó•â•\Ž¦—p‚ÉŽg‚¤?Be_kouho[0] ‚ÍŽÀ?Û‚ÍŽg‚í‚¸?Ae_kouho[1]‚©‚çŽg‚¤?B


    double sokutei_nagasa_1 = 0.0;
    double sokutei_nagasa_2 = 0.0;
    double sokutei_nagasa_3 = 0.0;
    double sokutei_kakudo_1 = 0.0;
    double sokutei_kakudo_2 = 0.0;
    double sokutei_kakudo_3 = 0.0;


    String text_cp_setumei = "";
    String text_cp_setumei2 = "";

    String s_title = ""; //ƒtƒŒ?[ƒ€‚Ì?Å?ã’[‚É?o‚Ä‚­‚éƒ^ƒCƒgƒ‹‚ð•ÛŽ?‚·‚é‚½‚ß‚ÉŽg—p

    Camera camera = new Camera();

    int i_check1 = 0;//=0 check1‚ðŽÀŽ{‚µ‚È‚¢?A1=ŽÀŽ{‚·‚é?@?@
    int i_check2 = 0;//=0 check2‚ðŽÀŽ{‚µ‚È‚¢?A1=ŽÀŽ{‚·‚é?@
    int i_check3 = 0;//=0 check3‚ðŽÀŽ{‚µ‚È‚¢?A1=ŽÀŽ{‚·‚é?@
    int i_check4 = 0;//=0 check4‚ðŽÀŽ{‚µ‚È‚¢?A1=ŽÀŽ{‚·‚é?@
    //---------------------------------
    int i_ck4_color_toukado = 100;

    ap orihime_ap;


    int icol_temp = 0;//?FŽw’è‚ÌˆêŽž“I‚È‹L‰¯‚ÉŽg‚¤

    int i_orikaesi = 0;//?Ü‚è•Ô‚µ( 5)‚Ì“®?ìƒ‚?[ƒhŽw’è‚ÉŽg‚¤?B0‚Í?]—ˆƒ^ƒCƒv?iver3.041ˆÈ‘O‚Ì‚à‚Ì?j?A‚P‚Í‹­‰»ƒ^ƒCƒv?B

    //i_mouse_modeA==61//’·•ûŒ`“à‘I‘ð?ipaint‚Ì‘I‘ð‚ÉŽ—‚¹‚½‘I‘ð‹@”\?j‚ÌŽž‚ÉŽg‚¤
    Ten p61_1 = new Ten();//TV?À•W
    Ten p61_2 = new Ten();//TV?À•W
    Ten p61_3 = new Ten();//TV?À•W
    Ten p61_4 = new Ten();//TV?À•W
    public Takakukei p61_TV_hako = new Takakukei(4);    //‘I‘ð” (TV?À•W)‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»
    int p61_mode = 0;//=1 ?V‚½‚É‘I‘ð” ‚ð?ì‚é?B=2?@“_‚ðˆÚ“®?B‚R?@•Ó‚ðˆÚ“®?B‚S?@‘I‘ð” ‚ðˆÚ“®?B


    Ten p = new Ten();


// ****************************************************************************************************************************************
// **************?@‚±‚±‚Ü‚Å•Ï?”‚Ì’è‹`?@****************************************************************************************************
// ****************************************************************************************************************************************

    public Egaki_Syokunin(double r0, ap ap0) {  //ƒRƒ“ƒXƒgƒ‰ƒNƒ^

        orihime_ap = ap0;

        //r_ten=r0;
        ugokasi_mode = 0;
        ieda = 0;
        icol = 0;
        gomibako.set(new Ten(10.0, 150.0), 1, new Ten(0.0, 0.0));
        gomibako.set(new Ten(10.0, 150.0), 2, new Ten(50.0, 0.0));
        gomibako.set(new Ten(10.0, 150.0), 3, new Ten(40.0, 50.0));
        gomibako.set(new Ten(10.0, 150.0), 4, new Ten(10.0, 50.0));

        tyuuoutai.set(1, new Ten(tyuuoutai_xmin, tyuuoutai_ymin));
        tyuuoutai.set(2, new Ten(tyuuoutai_xmax, tyuuoutai_ymin));
        tyuuoutai.set(3, new Ten(tyuuoutai_xmax, tyuuoutai_ymax));
        tyuuoutai.set(4, new Ten(tyuuoutai_xmin, tyuuoutai_ymax));

        //taisyousei=0;

        for (int i = 0; i <= 1024 - 1; i++) {
            s_step[i] = new Senbun();
        }
        for (int i = 0; i <= 1024 - 1; i++) {
            e_step[i] = new En();
        }

        for (int i = 0; i <= 16 - 1; i++) {
            s_kouho[i] = new Senbun();
        }
        for (int i = 0; i <= 16 - 1; i++) {
            e_kouho[i] = new En();
        }

        text_cp_setumei = "1/";
        text_cp_setumei2 = " ";
        s_title = "no title";

        reset();
        //reset_2();

    }


    //---------------------------------
    public void reset() {
        //r_ten=2.0;
        ir_ten = 1;
        ori_s.reset();
        hoj_s.reset();
        ugokasi_mode = 0;
        ieda = 0;
        //icol=0;
        //taisyousei=0;

        camera.reset();
        i_egaki_dankai = 0;
        i_en_egaki_dankai = 0;

    }

    public void reset_2() {
        //—pŽ†‚Ì?³•ûŒ`‚ð“ü—Í?iŠJŽn?j
        ori_s.addsenbun(-200.0, -200.0, -200.0, 200.0, 0);
        ori_s.addsenbun(-200.0, -200.0, 200.0, -200.0, 0);
        ori_s.addsenbun(200.0, 200.0, -200.0, 200.0, 0);
        ori_s.addsenbun(200.0, 200.0, 200.0, -200.0, 0);
        //—pŽ†‚Ì?³•ûŒ`‚ð“ü—Í?i?I—¹?j


    }


    // -------------------------------------------
    public void set_i_orikaesi(int i) {//?Ü‚è•Ô‚µ( 5)‚Ì“®?ìƒ‚?[ƒhŽw’è‚ÉŽg‚¤?B0‚Í?]—ˆƒ^ƒCƒv?iver3.041ˆÈ‘O‚Ì‚à‚Ì?j?A‚P‚Í‹­‰»ƒ^ƒCƒv?B
        i_orikaesi = i;
    }

    // -------------------------------------------
    public void sokutei_hyouji() {

        orihime_ap.sokutei_nagasa_1_hyouji(sokutei_nagasa_1);
        orihime_ap.sokutei_nagasa_2_hyouji(sokutei_nagasa_2);

        orihime_ap.sokutei_kakudo_1_hyouji(sokutei_kakudo_1);
        orihime_ap.sokutei_kakudo_2_hyouji(sokutei_kakudo_2);
        orihime_ap.sokutei_kakudo_3_hyouji(sokutei_kakudo_3);
    }


    //------------------------------------
    public void Memo_jyouhou_toridasi(Memo memo1) {

        int i_yomi = 0;
        String[] st;
        String[] s;

        // “WŠJ?}—pƒJƒ?ƒ‰?Ý’è‚Ì“Ç‚Ý?ž‚Ý
        i_yomi = 0;
        for (int i = 1; i <= memo1.getGyousuu(); i++) {
            String str = new String(memo1.getGyou(i));
            str.trim();

            if (str.equals("<camera_of_orisen_nyuuryokuzu>")) {
                i_yomi = 1;
            } else if (str.equals("</camera_of_orisen_nyuuryokuzu>")) {
                i_yomi = 0;
            } else {
                if (i_yomi == 1) {
                    st = str.split(">", 2);// <-----------------------------------‚Q‚Â‚É•ªŠ„‚·‚é‚Æ‚«‚Í2‚ðŽw’è
                    //System.out.println(st[0]+"[___________["+st[1]);
                    if (st[0].equals("<camera_ichi_x")) {
                        s = st[1].split("<", 2);
                        orihime_ap.camera_of_orisen_nyuuryokuzu.set_camera_ichi_x(Double.parseDouble(s[0]));
                    }        //  System.out.println(Integer.parseInt(s[0])) ;
                    if (st[0].equals("<camera_ichi_y")) {
                        s = st[1].split("<", 2);
                        orihime_ap.camera_of_orisen_nyuuryokuzu.set_camera_ichi_y(Double.parseDouble(s[0]));
                    }
                    if (st[0].equals("<camera_kakudo")) {
                        s = st[1].split("<", 2);
                        orihime_ap.camera_of_orisen_nyuuryokuzu.set_camera_kakudo(Double.parseDouble(s[0]));
                    }        //  System.out.println(Integer.parseInt(s[0])) ;
                    if (st[0].equals("<camera_kagami")) {
                        s = st[1].split("<", 2);
                        orihime_ap.camera_of_orisen_nyuuryokuzu.set_camera_kagami(Double.parseDouble(s[0]));
                    }

                    if (st[0].equals("<camera_bairitsu_x")) {
                        s = st[1].split("<", 2);
                        orihime_ap.camera_of_orisen_nyuuryokuzu.set_camera_bairitsu_x(Double.parseDouble(s[0]));
                    }        //  System.out.println(Integer.parseInt(s[0])) ;
                    if (st[0].equals("<camera_bairitsu_y")) {
                        s = st[1].split("<", 2);
                        orihime_ap.camera_of_orisen_nyuuryokuzu.set_camera_bairitsu_y(Double.parseDouble(s[0]));
                    }

                    if (st[0].equals("<hyouji_ichi_x")) {
                        s = st[1].split("<", 2);
                        orihime_ap.camera_of_orisen_nyuuryokuzu.set_hyouji_ichi_x(Double.parseDouble(s[0]));
                    }
                    if (st[0].equals("<hyouji_ichi_y")) {
                        s = st[1].split("<", 2);
                        orihime_ap.camera_of_orisen_nyuuryokuzu.set_hyouji_ichi_y(Double.parseDouble(s[0]));
                    }
                }
            }
        }


        // ----------------------------------------- ƒ`ƒFƒbƒNƒ{ƒbƒNƒX“™‚Ì?Ý’è‚Ì“Ç‚Ý?ž‚Ý
        i_yomi = 0;
        for (int i = 1; i <= memo1.getGyousuu(); i++) {
            String str = new String(memo1.getGyou(i));
            str.trim();

            if (str.equals("<settei>")) {
                i_yomi = 1;
            } else if (str.equals("</settei>")) {
                i_yomi = 0;
            } else {
                if (i_yomi == 1) {
                    st = str.split(">", 2);// <-----------------------------------‚Q‚Â‚É•ªŠ„‚·‚é‚Æ‚«‚Í2‚ðŽw’è


                    if (st[0].equals("<ckbox_mouse_settei")) {
                        s = st[1].split("<", 2);

                        if (s[0].trim().equals("true")) {
                            orihime_ap.ckbox_mouse_settei.setSelected(true);
                        }
                        if (s[0].trim().equals("false")) {
                            orihime_ap.ckbox_mouse_settei.setSelected(false);
                        }
                    }

                    if (st[0].equals("<ckbox_ten_sagasi")) {
                        s = st[1].split("<", 2);
                        s[0].trim();


                        if (s[0].trim().equals("true")) {
                            orihime_ap.ckbox_ten_sagasi.setSelected(true);
                        }
                        if (s[0].trim().equals("false")) {
                            orihime_ap.ckbox_ten_sagasi.setSelected(false);
                        }
                    }

                    if (st[0].equals("<ckbox_ten_hanasi")) {
                        s = st[1].split("<", 2);
                        s[0].trim();
                        if (s[0].trim().equals("true")) {
                            orihime_ap.ckbox_ten_hanasi.setSelected(true);
                        }
                        if (s[0].trim().equals("false")) {
                            orihime_ap.ckbox_ten_hanasi.setSelected(false);
                        }
                    }

                    if (st[0].equals("<ckbox_kou_mitudo_nyuuryoku")) {
                        s = st[1].split("<", 2);
                        s[0].trim();
                        if (s[0].trim().equals("true")) {
                            orihime_ap.ckbox_kou_mitudo_nyuuryoku.setSelected(true);
                            set_i_kou_mitudo_nyuuryoku(1);
                        }
                        if (s[0].trim().equals("false")) {
                            orihime_ap.ckbox_kou_mitudo_nyuuryoku.setSelected(false);
                            set_i_kou_mitudo_nyuuryoku(0);
                        }
                    }

                    if (st[0].equals("<ckbox_bun")) {
                        s = st[1].split("<", 2);
                        s[0].trim();
                        if (s[0].trim().equals("true")) {
                            orihime_ap.ckbox_bun.setSelected(true);
                        }
                        if (s[0].trim().equals("false")) {
                            orihime_ap.ckbox_bun.setSelected(false);
                        }
                    }

                    if (st[0].equals("<ckbox_cp")) {
                        s = st[1].split("<", 2);
                        s[0].trim();
                        if (s[0].trim().equals("true")) {
                            orihime_ap.ckbox_cp.setSelected(true);
                        }
                        if (s[0].trim().equals("false")) {
                            orihime_ap.ckbox_cp.setSelected(false);
                        }
                    }

                    if (st[0].equals("<ckbox_a0")) {
                        s = st[1].split("<", 2);
                        s[0].trim();
                        if (s[0].trim().equals("true")) {
                            orihime_ap.ckbox_a0.setSelected(true);
                        }
                        if (s[0].trim().equals("false")) {
                            orihime_ap.ckbox_a0.setSelected(false);
                        }
                    }

                    if (st[0].equals("<ckbox_a1")) {
                        s = st[1].split("<", 2);
                        s[0].trim();
                        if (s[0].trim().equals("true")) {
                            orihime_ap.ckbox_a1.setSelected(true);
                        }
                        if (s[0].trim().equals("false")) {
                            orihime_ap.ckbox_a1.setSelected(false);
                        }
                    }

                    if (st[0].equals("<ckbox_mejirusi")) {
                        s = st[1].split("<", 2);
                        s[0].trim();
                        if (s[0].trim().equals("true")) {
                            orihime_ap.ckbox_mejirusi.setSelected(true);
                        }
                        if (s[0].trim().equals("false")) {
                            orihime_ap.ckbox_mejirusi.setSelected(false);
                        }
                    }

                    if (st[0].equals("<ckbox_cp_ue")) {
                        s = st[1].split("<", 2);
                        s[0].trim();
                        if (s[0].trim().equals("true")) {
                            orihime_ap.ckbox_cp_ue.setSelected(true);
                        }
                        if (s[0].trim().equals("false")) {
                            orihime_ap.ckbox_cp_ue.setSelected(false);
                        }
                    }

                    if (st[0].equals("<ckbox_oritatami_keika")) {
                        s = st[1].split("<", 2);
                        s[0].trim();
                        if (s[0].trim().equals("true")) {
                            orihime_ap.ckbox_oritatami_keika.setSelected(true);
                        }
                        if (s[0].trim().equals("false")) {
                            orihime_ap.ckbox_oritatami_keika.setSelected(false);
                        }
                    }


                    if (st[0].equals("<iTenkaizuSenhaba")) {
                        s = st[1].split("<", 2);
                        s[0].trim();
                        orihime_ap.iTenkaizuSenhaba = (Integer.parseInt(s[0]));
                    }        //  System.out.println(Integer.parseInt(s[0])) ;


                    if (st[0].equals("<ir_ten")) {
                        s = st[1].split("<", 2);
                        s[0].trim();
                        orihime_ap.ir_ten = (Integer.parseInt(s[0]));
                        set_ir_ten(orihime_ap.ir_ten);
                    }        //  System.out.println(Integer.parseInt(s[0])) ;


                    if (st[0].equals("<i_orisen_hyougen")) {
                        s = st[1].split("<", 2);
                        s[0].trim();
                        orihime_ap.i_orisen_hyougen = (Integer.parseInt(s[0]));
                    }        //  System.out.println(Integer.parseInt(s[0])) ;


                    if (st[0].equals("<i_anti_alias")) {
                        s = st[1].split("<", 2);
                        s[0].trim();
                        orihime_ap.i_anti_alias = (Integer.parseInt(s[0]));
                    }        //  System.out.println(Integer.parseInt(s[0])) ;


                }
            }
        }


        // ----------------------------------------- ŠiŽq?Ý’è‚Ì“Ç‚Ý?ž‚Ý


        i_yomi = 0;
        for (int i = 1; i <= memo1.getGyousuu(); i++) {
            String str = new String(memo1.getGyou(i));
            str.trim();

            if (str.equals("<Kousi>")) {
                i_yomi = 1;
            } else if (str.equals("</Kousi>")) {
                i_yomi = 0;
            } else {
                if (i_yomi == 1) {
                    st = str.split(">", 2);// <-----------------------------------‚Q‚Â‚É•ªŠ„‚·‚é‚Æ‚«‚Í2‚ðŽw’è

                    if (st[0].equals("<i_kitei_jyoutai")) {
                        s = st[1].split("<", 2);
                        set_i_kitei_jyoutai(Integer.parseInt(s[0]));
                    }
                    //  System.out.println(Integer.parseInt(s[0])) ;

                    if (st[0].equals("<nyuuryoku_kitei")) {
                        s = st[1].split("<", 2);
                        orihime_ap.text1.setText(s[0]);
                        orihime_ap.set_kousi_bunkatu_suu();
                        //set_kousi_bunkatu_suu(Integer.parseInt(s[0]));

                    }
                    //  System.out.println(Integer.parseInt(s[0])) ;


                    if (st[0].equals("<memori_kankaku")) {
                        s = st[1].split("<", 2);
                        orihime_ap.memori_kankaku = Integer.parseInt(s[0]);
                        orihime_ap.text25.setText(s[0]);

                        set_a_to_heikouna_memori_kannkaku(orihime_ap.memori_kankaku);
                        set_b_to_heikouna_memori_kannkaku(orihime_ap.memori_kankaku);
                    }


                    if (st[0].equals("<a_to_heikouna_memori_iti")) {
                        s = st[1].split("<", 2);
                        kus.set_a_to_heikouna_memori_iti(Integer.parseInt(s[0]));
                    }
                    if (st[0].equals("<b_to_heikouna_memori_iti")) {
                        s = st[1].split("<", 2);
                        kus.set_b_to_heikouna_memori_iti(Integer.parseInt(s[0]));
                    }
                    if (st[0].equals("<kousi_senhaba")) {
                        s = st[1].split("<", 2);
                        kus.set_kousi_senhaba(Integer.parseInt(s[0]));
                    }


                    if (st[0].equals("<d_kousi_x_a")) {
                        s = st[1].split("<", 2);
                        orihime_ap.text18.setText(s[0]);
                    }
                    if (st[0].equals("<d_kousi_x_b")) {
                        s = st[1].split("<", 2);
                        orihime_ap.text19.setText(s[0]);
                    }
                    if (st[0].equals("<d_kousi_x_c")) {
                        s = st[1].split("<", 2);
                        orihime_ap.text20.setText(s[0]);
                    }

                    if (st[0].equals("<d_kousi_y_a")) {
                        s = st[1].split("<", 2);
                        orihime_ap.text21.setText(s[0]);
                    }
                    if (st[0].equals("<d_kousi_y_b")) {
                        s = st[1].split("<", 2);
                        orihime_ap.text22.setText(s[0]);
                    }
                    if (st[0].equals("<d_kousi_y_c")) {
                        s = st[1].split("<", 2);
                        orihime_ap.text23.setText(s[0]);
                    }

                    if (st[0].equals("<d_kousi_kakudo")) {
                        s = st[1].split("<", 2);
                        orihime_ap.text24.setText(s[0]);
                    }

                    orihime_ap.set_kousi();
/*
		memo1.addGyou("<d_kousi_x_a>"+orihime_ap.d_kousi_x_a+"</d_kousi_x_a>");
		memo1.addGyou("<d_kousi_x_b>"+orihime_ap.d_kousi_x_b+"</d_kousi_x_b>");
		memo1.addGyou("<d_kousi_x_c>"+orihime_ap.d_kousi_x_c+"</d_kousi_x_c>");
		memo1.addGyou("<d_kousi_y_a>"+orihime_ap.d_kousi_y_a+"</d_kousi_y_a>");
		memo1.addGyou("<d_kousi_y_b>"+orihime_ap.d_kousi_y_b+"</d_kousi_y_b>");
		memo1.addGyou("<d_kousi_y_c>"+orihime_ap.d_kousi_y_c+"</d_kousi_y_c>");
		memo1.addGyou("<d_kousi_kakudo>"+orihime_ap.d_kousi_kakudo+"</d_kousi_kakudo>");
		memo1.addGyou("<d_kousi_x_nagasa>"+orihime_ap.d_kousi_x_nagasa+"</d_kousi_x_nagasa>");
		memo1.addGyou("<d_kousi_y_nagasa>"+orihime_ap.d_kousi_y_nagasa+"</d_kousi_y_nagasa>");

*/

                }
            }
        }


        // ----------------------------------------- ŠiŽq?F?Ý’è‚Ì“Ç‚Ý?ž‚Ý
        int i_kousi_color_R = 0;
        int i_kousi_color_G = 0;
        int i_kousi_color_B = 0;
        int i_kousi_memori_color_R = 0;
        int i_kousi_memori_color_G = 0;
        int i_kousi_memori_color_B = 0;

        int i_Kousi_iro_yomikomi = 0;//Kousi_iro‚Ì“Ç‚Ý?ž‚Ý‚ª‚ ‚Á‚½‚ç1?A‚È‚¯‚ê‚Î0
        i_yomi = 0;
        for (int i = 1; i <= memo1.getGyousuu(); i++) {
            String str = new String(memo1.getGyou(i));
            str.trim();

            if (str.equals("<Kousi_iro>")) {
                i_yomi = 1;
                i_Kousi_iro_yomikomi = 1;
            } else if (str.equals("</Kousi_iro>")) {
                i_yomi = 0;
            } else {
                if (i_yomi == 1) {
                    st = str.split(">", 2);// <-----------------------------------‚Q‚Â‚É•ªŠ„‚·‚é‚Æ‚«‚Í2‚ðŽw’è


                    if (st[0].equals("<kousi_color_R")) {
                        s = st[1].split("<", 2);
                        i_kousi_color_R = (Integer.parseInt(s[0]));
                    }        //  System.out.println(Integer.parseInt(s[0])) ;
                    if (st[0].equals("<kousi_color_G")) {
                        s = st[1].split("<", 2);
                        i_kousi_color_G = (Integer.parseInt(s[0]));
                    }
                    if (st[0].equals("<kousi_color_B")) {
                        s = st[1].split("<", 2);
                        i_kousi_color_B = (Integer.parseInt(s[0]));
                    }

                    if (st[0].equals("<kousi_memori_color_R")) {
                        s = st[1].split("<", 2);
                        i_kousi_memori_color_R = (Integer.parseInt(s[0]));
                    }
                    if (st[0].equals("<kousi_memori_color_G")) {
                        s = st[1].split("<", 2);
                        i_kousi_memori_color_G = (Integer.parseInt(s[0]));
                    }
                    if (st[0].equals("<kousi_memori_color_B")) {
                        s = st[1].split("<", 2);
                        i_kousi_memori_color_B = (Integer.parseInt(s[0]));
                    }


                }
            }
        }

        if (i_Kousi_iro_yomikomi == 1) {//Kousi_iro‚Ì“Ç‚Ý?ž‚Ý‚ª‚ ‚Á‚½‚ç1?A‚È‚¯‚ê‚Î0
            kus.set_kousi_color(new Color(i_kousi_color_R, i_kousi_color_G, i_kousi_color_B)); //kousi‚Ì?F

            System.out.println("i_kousi_memori_color_R= " + i_kousi_memori_color_R);
            System.out.println("i_kousi_memori_color_G= " + i_kousi_memori_color_G);
            System.out.println("i_kousi_memori_color_B= " + i_kousi_memori_color_B);
            orihime_ap.kus.set_kousi_memori_color(new Color(i_kousi_memori_color_R, i_kousi_memori_color_G, i_kousi_memori_color_B)); //kousi_memori‚Ì?F

        }


        // ?Ü‚è?ã‚ª‚è?}?Ý’è‚Ì“Ç‚Ý?ž‚Ý -------------------------------------------------------------------------

        int i_oriagarizu_F_color_R = 0;
        int i_oriagarizu_F_color_G = 0;
        int i_oriagarizu_F_color_B = 0;

        int i_oriagarizu_B_color_R = 0;
        int i_oriagarizu_B_color_G = 0;
        int i_oriagarizu_B_color_B = 0;

        int i_oriagarizu_L_color_R = 0;
        int i_oriagarizu_L_color_G = 0;
        int i_oriagarizu_L_color_B = 0;


        int i_oriagarizu_yomikomi = 0;//oriagarizu‚Ì“Ç‚Ý?ž‚Ý‚ª‚ ‚Á‚½‚ç1?A‚È‚¯‚ê‚Î0
        i_yomi = 0;
        for (int i = 1; i <= memo1.getGyousuu(); i++) {
            String str = new String(memo1.getGyou(i));
            str.trim();

            if (str.equals("<oriagarizu>")) {
                i_yomi = 1;
                i_oriagarizu_yomikomi = 1;
            } else if (str.equals("</oriagarizu>")) {
                i_yomi = 0;
            } else {
                if (i_yomi == 1) {
                    st = str.split(">", 2);// <-----------------------------------‚Q‚Â‚É•ªŠ„‚·‚é‚Æ‚«‚Í2‚ðŽw’è

                    if (st[0].equals("<oriagarizu_F_color_R")) {
                        s = st[1].split("<", 2);
                        i_oriagarizu_F_color_R = (Integer.parseInt(s[0]));
                    }        //  System.out.println(Integer.parseInt(s[0])) ;
                    if (st[0].equals("<oriagarizu_F_color_G")) {
                        s = st[1].split("<", 2);
                        i_oriagarizu_F_color_G = (Integer.parseInt(s[0]));
                    }
                    if (st[0].equals("<oriagarizu_F_color_B")) {
                        s = st[1].split("<", 2);
                        i_oriagarizu_F_color_B = (Integer.parseInt(s[0]));
                    }

                    if (st[0].equals("<oriagarizu_B_color_R")) {
                        s = st[1].split("<", 2);
                        i_oriagarizu_B_color_R = (Integer.parseInt(s[0]));
                    }        //  System.out.println(Integer.parseInt(s[0])) ;
                    if (st[0].equals("<oriagarizu_B_color_G")) {
                        s = st[1].split("<", 2);
                        i_oriagarizu_B_color_G = (Integer.parseInt(s[0]));
                    }
                    if (st[0].equals("<oriagarizu_B_color_B")) {
                        s = st[1].split("<", 2);
                        i_oriagarizu_B_color_B = (Integer.parseInt(s[0]));
                    }

                    if (st[0].equals("<oriagarizu_L_color_R")) {
                        s = st[1].split("<", 2);
                        i_oriagarizu_L_color_R = (Integer.parseInt(s[0]));
                    }        //  System.out.println(Integer.parseInt(s[0])) ;
                    if (st[0].equals("<oriagarizu_L_color_G")) {
                        s = st[1].split("<", 2);
                        i_oriagarizu_L_color_G = (Integer.parseInt(s[0]));
                    }
                    if (st[0].equals("<oriagarizu_L_color_B")) {
                        s = st[1].split("<", 2);
                        i_oriagarizu_L_color_B = (Integer.parseInt(s[0]));
                    }

                    //  System.out.println(Integer.parseInt(s[0])) ;
                }
            }
        }

        if (i_oriagarizu_yomikomi == 1) {
            orihime_ap.OZ.js.set_F_color(new Color(i_oriagarizu_F_color_R, i_oriagarizu_F_color_G, i_oriagarizu_F_color_B)); //•\–Ê‚Ì?F
            orihime_ap.Button_F_color.setBackground(new Color(i_oriagarizu_F_color_R, i_oriagarizu_F_color_G, i_oriagarizu_F_color_B));    //ƒ{ƒ^ƒ“‚Ì?F?Ý’è

            orihime_ap.OZ.js.set_B_color(new Color(i_oriagarizu_B_color_R, i_oriagarizu_B_color_G, i_oriagarizu_B_color_B));//— –Ê‚Ì?F
            orihime_ap.Button_B_color.setBackground(new Color(i_oriagarizu_B_color_R, i_oriagarizu_B_color_G, i_oriagarizu_B_color_B));//ƒ{ƒ^ƒ“‚Ì?F?Ý’è

            orihime_ap.OZ.js.set_L_color(new Color(i_oriagarizu_L_color_R, i_oriagarizu_L_color_G, i_oriagarizu_L_color_B));        //?ü‚Ì?F
            orihime_ap.Button_L_color.setBackground(new Color(i_oriagarizu_L_color_R, i_oriagarizu_L_color_G, i_oriagarizu_L_color_B));        //ƒ{ƒ^ƒ“‚Ì?F?Ý’è
        }
    }

    //-----------------------------
    public String setMemo_for_redo_undo(Memo memo1) {//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<undo,redo‚Å‚Ìkiroku•œŒ³—p

        //Memo_jyouhou_toridasi(memo1);
        return ori_s.setMemo(memo1);
    }


    //-----------------------------
    public void setMemo_for_yomikomi(Memo memo1) {//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<ƒf?[ƒ^“Ç‚Ý?ž‚Ý—p
        Memo_jyouhou_toridasi(memo1);
        ori_s.setMemo(memo1);
        hoj_s.h_setMemo(memo1);
    }

    //-----------------------------
    public void setMemo_for_yomikomi_tuika(Memo memo1) {//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<ƒf?[ƒ^“Ç‚Ý?ž‚Ý—p
        //Memo_jyouhou_toridasi(memo1);
        //ori_s.setMemo(memo1); hoj_s.h_setMemo(memo1);

        double addx, addy;


        Orisensyuugou ori_s_temp = new Orisensyuugou();    //’Ç‰Á‚³‚ê‚½?Ü?ü‚¾‚¯Žæ‚è?o‚·‚½‚ß‚ÉŽg‚¤
        ori_s_temp.setMemo(memo1);//’Ç‰Á‚³‚ê‚½?Ü?ü‚¾‚¯Žæ‚è?o‚µ‚Äori_s_temp‚ð?ì‚é
        //ori_s.del_selected_senbun_hayai();//ƒZƒŒƒNƒg‚³‚ê‚½?Ü?ü‚ð?í?œ‚·‚é?B
        addx = ori_s.get_x_max() + 100.0 - ori_s_temp.get_x_min();
        addy = ori_s.get_y_max() - ori_s_temp.get_y_max();


        ori_s_temp.move(addx, addy);//‘S‘Ì‚ðˆÚ“®‚·‚é

        int sousuu_old = ori_s.getsousuu();
        ori_s.addMemo(ori_s_temp.getMemo());
        int sousuu_new = ori_s.getsousuu();
        ori_s.kousabunkatu(1, sousuu_old, sousuu_old + 1, sousuu_new);

        ori_s.unselect_all();
        kiroku();


    }

    //-----------------------------
    public void h_setMemo(Memo memo1) {
        hoj_s.h_setMemo(memo1);
    }


    //-----------------------------
    public void setCamera(Camera cam0) {


        //camera.set_camera_id(cam0.get_camera_id());
        camera.set_camera_kagami(cam0.get_camera_kagami());


        camera.set_camera_ichi_x(cam0.get_camera_ichi_x());
        camera.set_camera_ichi_y(cam0.get_camera_ichi_y());
        camera.set_camera_bairitsu_x(cam0.get_camera_bairitsu_x());
        camera.set_camera_bairitsu_y(cam0.get_camera_bairitsu_y());
        camera.set_camera_kakudo(cam0.get_camera_kakudo());
        camera.set_hyouji_ichi_x(cam0.get_hyouji_ichi_x());
        camera.set_hyouji_ichi_y(cam0.get_hyouji_ichi_y());

        calc_d_hantei_haba();
    }


    public void set_sen_tokutyuu_color(Color c0) {
        sen_tokutyuu_color = c0;
    }


    //-----------------------------
    public void zen_yama_tani_henkan() {
        ori_s.zen_yama_tani_henkan();
    }

    //----------------
    public void eda_kesi(double r) {
        ori_s.eda_kesi(r);
    }
    //--------------------------------------------
    //public void set(Senbunsyuugou ss){ori_s.set(ss);}

    //----------------------------------------------
    public Senbunsyuugou get() {
        sen_s.setMemo(ori_s.getMemo());
        return sen_s;


    }


    public Senbunsyuugou get_for_oritatami() {
        sen_s.setMemo(ori_s.getMemo_for_oritatami());
        return sen_s;
    }


    //?Ü?ô‚Ý?„’è—p‚Éselect‚³‚ê‚½?ü•ª?W?‡‚Ì?Ü?ü?”‚ð int‚Æ‚µ‚Ä?o—Í‚·‚é?B//icol‚ª3(cyan???…?F)ˆÈ?ã‚Ì•â?•?ü‚ÍƒJƒEƒ“ƒg‚µ‚È‚¢
    public int get_orisensuu_for_select_oritatami() {
        return ori_s.get_orisensuu_for_select_oritatami();
    }

    public Senbunsyuugou get_for_select_oritatami() {//select‚µ‚½?Ü?ü‚Å?Ü‚è?ô‚Ý?„’è‚ð‚·‚é?B
        sen_s.setMemo(ori_s.getMemo_for_select_oritatami());
        return sen_s;
    }


    //--------------------------------------------
    //public void set_r(double r0){r_ten=r0;}
    public void set_ir_ten(int i0) {
        ir_ten = i0;
    }

    //--------------------------------------------
    public void set_kousi_bunkatu_suu(int i) {
        kus.set_kousi_bunkatu_suu(i);
        text_cp_setumei = "1/" + kus.bunsuu();
        calc_d_hantei_haba();
    }

    public void calc_d_hantei_haba() {
        d_hantei_haba = kus.d_haba() / 4.0;
        if (camera.get_camera_bairitsu_x() * d_hantei_haba < 10.0) {
            d_hantei_haba = 10.0 / camera.get_camera_bairitsu_x();
        }
    }


    // ----------------------------------------
    public void set_d_kousi(double dkxn, double dkyn, double dkk) {
        kus.set_d_kousi(dkxn, dkyn, dkk);
    }


    //--------------------------------------------
    public void set_kensa_houhou(int i) {
        kensa_houhou = i;
    }

    //--------------------------------------------
    public int getsousuu() {
        return ori_s.getsousuu();
    }


    //-----------------------------
    public void set_kijyun_kakudo(double x) {
        kijyun_kakudo = x;
    } //<<<<<<<<<<<<<<<<<<<<<<<Šî?€Šp“x<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


    //------------------------
    public Memo getMemo() {
        return ori_s.getMemo();
    }


    //getMemo(String s_title)‚Íundo,redo‚Ìkiroku—p
    public Memo getMemo(String s_title) {//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<undo,redo‚Ìkiroku—p
        Memo memo_temp = new Memo();
        memo_temp.set(ori_s.getMemo(s_title));

        Memo_jyouhou_tuika(memo_temp);
        return memo_temp;
        //return ori_s.getMemo(s_title);
    }

    //------------------------
    public Memo h_getMemo() {
        return hoj_s.h_getMemo();
    }


    //------------------------
    public Memo getMemo_for_kakidasi() {//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<ƒf?[ƒ^?‘‚«?o‚µ

        Memo memo_temp = new Memo();
        memo_temp.set(ori_s.getMemo());
        memo_temp.addMemo(hoj_s.h_getMemo());
        Memo_jyouhou_tuika(memo_temp);
        return memo_temp;
    }

    //------------------------svgƒf?[ƒ^?‘‚«?o‚µ
    public Memo getMemo_for_svg_kakidasi_with_camera(int i_bun_hyouji, int i_cp_hyouji, int i_a0_hyouji, int i_a1_hyouji, float fTenkaizuSenhaba, int i_orisen_hyougen, float f_h_TenkaizuSenhaba, int p0x_max, int p0y_max, int i_mejirusi_hyouji) {//ˆø?”‚ÍƒJƒ?ƒ‰?Ý’è?A?ü•??A‰æ–ÊX•??A‰æ–Êy?‚‚³
        Memo memo_temp = new Memo();

        //String text=new String();//•¶Žš—ñ?ˆ—?—p‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»
        //double d;
        Senbun s_tv = new Senbun();
        Ten a = new Ten();
        Ten b = new Ten();

        //Senbun s_ob =new Senbun();
        // ------------------------------------------------------

        String str = "";
        String str_stroke = "";
        String str_strokewidth = "";
        str_strokewidth = Integer.toString(orihime_ap.iTenkaizuSenhaba);
        // ------------------------------------------------------


        //“WŠJ?}‚Ì•`‰æ  •â?•Šˆ?üˆÈŠO‚Ì?Ü?ü
        if (i_cp_hyouji == 1) {

            //float dash_M1[] = {10.0f, 3.0f, 3.0f, 3.0f};//ˆê“_?½?ü
            //float dash_M2[] = {10.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f};//“ñ“_?½?ü
            //float dash_V[]  = {8.0f, 8.0f};//”j?ü

            for (int i = 1; i <= ori_s.getsousuu(); i++) {
                if (ori_s.getcolor(i) <= 3) {


                    if (ori_s.getcolor(i) == 0) {
                        str_stroke = "black";
                    } else if (ori_s.getcolor(i) == 1) {
                        str_stroke = "red";
                    } else if (ori_s.getcolor(i) == 2) {
                        str_stroke = "blue";
                    }


                    String str_stroke_dasharray = "";
                    str_stroke_dasharray = "";

//stroke-dasharray="10 6 2 4 2 6"

                    if (i_orisen_hyougen == 1) {
                        //g_setColor(g,ori_s.getcolor(i));
                        //g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//Šî–{Žw’èA?@?@?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó
                    }

                    if (i_orisen_hyougen == 2) {
                        //g_setColor(g,ori_s.getcolor(i));
                        if (ori_s.getcolor(i) == 0) {
                        }//Šî–{Žw’èA?@?@?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó
                        if (ori_s.getcolor(i) == 1) {
                            str_stroke_dasharray = "stroke-dasharray=\"10 3 3 3\"";
                        }//dash_M1,ˆê“_?½?ü
                        if (ori_s.getcolor(i) == 2) {
                            str_stroke_dasharray = "stroke-dasharray=\"8 8\"";
                        }//dash_V ,”j?ü
                    }


                    if (i_orisen_hyougen == 3) {
                        str_stroke = "black";
                        if (ori_s.getcolor(i) == 0) {
                        }//Šî–{Žw’èA?@?@?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó
                        if (ori_s.getcolor(i) == 1) {
                            str_stroke_dasharray = "stroke-dasharray=\"10 3 3 3\"";
                        }//dash_M1,ˆê“_?½?ü
                        if (ori_s.getcolor(i) == 2) {
                            str_stroke_dasharray = "stroke-dasharray=\"8 8\"";
                        }//dash_V ,”j?ü
                    }

                    if (i_orisen_hyougen == 4) {
                        str_stroke = "black";
                        if (ori_s.getcolor(i) == 0) {
                        }//Šî–{Žw’èA?@?@?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó
                        if (ori_s.getcolor(i) == 1) {
                            str_stroke_dasharray = "stroke-dasharray=\"10 3 3 3 3 3\"";
                        }//dash_M2,“ñ“_?½?ü
                        if (ori_s.getcolor(i) == 2) {
                            str_stroke_dasharray = "stroke-dasharray=\"8 8\"";
                        }//dash_V ,”j?ü
                    }


/*
					if(i_orisen_hyougen==1){
						g_setColor(g,ori_s.getcolor(i));
						g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//Šî–{Žw’èA?@?@?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó
					}

					if(i_orisen_hyougen==2){
						g_setColor(g,ori_s.getcolor(i));
						if(ori_s.getcolor(i)==0){g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER				));}//Šî–{Žw’èA?@?@?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó
						if(ori_s.getcolor(i)==1){g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,10.0f, dash_M1, 0.0f	));}//ˆê“_?½?ü//?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó
						if(ori_s.getcolor(i)==2){g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,10.0f, dash_V , 0.0f	));}//”j?ü//?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó
					}

					if(i_orisen_hyougen==3){
						if(ori_s.getcolor(i)==0){g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER				));}//Šî–{Žw’èA?@?@?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó
						if(ori_s.getcolor(i)==1){g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,10.0f, dash_M1, 0.0f	));}//ˆê“_?½?ü//?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó
						if(ori_s.getcolor(i)==2){g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,10.0f, dash_V , 0.0f	));}//”j?ü//?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó
					}

					if(i_orisen_hyougen==4){
						if(ori_s.getcolor(i)==0){g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));}//Šî–{Žw’èA?@?@?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó
						if(ori_s.getcolor(i)==1){g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,10.0f, dash_M2, 0.0f));}//“ñ“_?½?ü//?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó
						if(ori_s.getcolor(i)==2){g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,10.0f, dash_V , 0.0f));}//”j?ü//?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó
					}

*/


                    s_tv.set(camera.object2TV(ori_s.get(i)));
                    a.set(s_tv.geta());
                    b.set(s_tv.getb());//a.set(s_tv.getax()+0.000001,s_tv.getay()+0.000001); b.set(s_tv.getbx()+0.000001,s_tv.getby()+0.000001);//‚È‚º0.000001‚ð‘«‚·‚©‚Æ‚¢‚¤‚Æ,ƒfƒBƒXƒvƒŒƒC‚É•`‰æ‚·‚é‚Æ‚«Œ³‚Ì?Ü?ü‚ª?V‚µ‚¢?Ü?ü‚É‰e‹¿‚³‚ê‚Ä“®‚¢‚Ä‚µ‚Ü‚¤‚Ì‚ð–h‚®‚½‚ß


//					g.drawLine( (int)a.getx(),(int)a.gety(),(int)b.getx(),(int)b.gety()); //’¼?ü

                    BigDecimal b_ax = new BigDecimal(String.valueOf(a.getx()));
                    double x1 = b_ax.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                    BigDecimal b_ay = new BigDecimal(String.valueOf(a.gety()));
                    double y1 = b_ay.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                    BigDecimal b_bx = new BigDecimal(String.valueOf(b.getx()));
                    double x2 = b_bx.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                    BigDecimal b_by = new BigDecimal(String.valueOf(b.gety()));
                    double y2 = b_by.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();


                    memo_temp.addGyou("<line x1=\"" + x1 + "\"" +
                            " y1=\"" + y1 + "\"" +
                            " x2=\"" + x2 + "\"" +
                            " y2=\"" + y2 + "\"" +
                            " " + str_stroke_dasharray + " " +
                            " stroke=\"" + str_stroke + "\"" +
                            " stroke-width=\"" + str_strokewidth + "\"" + " />");


/*


					memo_temp.addGyou(    "<line x1=\"" + str.valueOf( b_ax.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()) + "\"" +
							           " y1=\"" + str.valueOf( b_ay.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()) + "\"" +
							           " x2=\"" + str.valueOf( b_bx.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()) + "\"" +
							           " y2=\"" + str.valueOf( b_by.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()) + "\"" +
								" "+str_stroke_dasharray+" "+
							  " stroke=\"" + str_stroke	 + "\"" +
						    " stroke-width=\"" + str_strokewidth + "\"" +" />"
													);




					memo_temp.addGyou(    "<line x1=\"" + str.valueOf(a.getx()) + "\"" +
							      " y1=\"" + str.valueOf(a.gety()) + "\"" +
							      " x2=\"" + str.valueOf(b.getx()) + "\"" +
							      " y2=\"" + str.valueOf(b.gety()) + "\"" +
								" "+str_stroke_dasharray+" "+
							  " stroke=\"" + str_stroke	 + "\"" +
						    " stroke-width=\"" + str_strokewidth + "\"" +" />"
													);

*/


                    if (ir_ten != 0) {
                        if (fTenkaizuSenhaba < 2.0f) {//’¸“_‚Ì?•‚¢?³•ûŒ`‚ð•`‚­
                            //str_stroke="black";//g.setColor(Color.black);
                            //int i_haba=1;
                            //str_strokewidth = Integer.toString(ir_ten);
                            int i_haba = ir_ten;
                            //<rect style="fill:#000000;stroke:#000000;stroke-width:1"
                            //   width="49.892857"
                            //   height="46.869045"
                            //   x="0"
                            //   y="249.375" />
                            memo_temp.addGyou("<rect style=\"fill:#000000;stroke:#000000;stroke-width:1\"" +
                                    " width=\"" + (2.0 * (double) i_haba + 1.0) + "\"" +
                                    " height=\"" + (2.0 * (double) i_haba + 1.0) + "\"" +
                                    " x=\"" + (x1 - (double) i_haba) + "\"" +
                                    " y=\"" + (y1 - (double) i_haba) + "\"" +
                                    " />");

                            memo_temp.addGyou("<rect style=\"fill:#000000;stroke:#000000;stroke-width:1\"" +
                                    " width=\"" + (2.0 * (double) i_haba + 1.0) + "\"" +
                                    " height=\"" + (2.0 * (double) i_haba + 1.0) + "\"" +
                                    " x=\"" + (x2 - (double) i_haba) + "\"" +
                                    " y=\"" + (y2 - (double) i_haba) + "\"" +
                                    " />");

                            //g.fillRect( (int)a.getx()-i_haba,(int)a.gety()-i_haba,2*i_haba+1,2*i_haba+1); //?³•ûŒ`‚ð•`‚­//g.fillRect(10, 10, 100, 50);’·•ûŒ`‚ð•`‚­
                            //g.fillRect( (int)b.getx()-i_haba,(int)b.gety()-i_haba,2*i_haba+1,2*i_haba+1); //?³•ûŒ`‚ð•`‚­
                        }
                    }

                    if (fTenkaizuSenhaba >= 2.0f) {//  ‘¾?ü
                        //g2.setStroke(new BasicStroke(1.0f+fTenkaizuSenhaba%1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó?A‚±‚±‚Å‚Í?Ü?ü‚Ì’[“_‚Ì?ü‚ÌŒ`?ó‚ÌŽw’è
                        if (ir_ten != 0) {
                            //int i_haba=(int)fTenkaizuSenhaba+ir_ten;//int i_haba=2;
                            double d_haba = (double) fTenkaizuSenhaba / 2.0 + (double) ir_ten;//int i_haba=2;

                            memo_temp.addGyou("<circle style=\"fill:#ffffff;stroke:#000000;stroke-width:1\"" +
                                    " r=\"" + d_haba + "\"" +
                                    " cx=\"" + x1 + "\"" +
                                    " cy=\"" + y1 + "\"" +
                                    " />");


                            memo_temp.addGyou("<circle style=\"fill:#ffffff;stroke:#000000;stroke-width:1\"" +
                                    " r=\"" + d_haba + "\"" +
                                    " cx=\"" + x2 + "\"" +
                                    " cy=\"" + y2 + "\"" +
                                    " />");


/*
      <circle
         id="circle4747"
         r="100"
         cy="100"
         cx="100"
         style="opacity:0.2;fill:#ff0000" />



							g.setColor(Color.white);
							g2.fill(new Ellipse2D.Double(a.getx()-d_haba, a.gety()-d_haba, 2.0*d_haba,2.0*d_haba));
							//g.fillOval( (int)a.getx()-i_haba/2,(int)a.gety()-i_haba/2,i_haba,i_haba); //‰~


							g.setColor(Color.black);
							g2.draw(new Ellipse2D.Double(a.getx()-d_haba, a.gety()-d_haba, 2.0*d_haba,2.0*d_haba));
							//g.drawOval( (int)a.getx()-i_haba/2,(int)a.gety()-i_haba/2,i_haba,i_haba); //‰~

							g.setColor(Color.white);
							g2.fill(new Ellipse2D.Double(b.getx()-d_haba, b.gety()-d_haba, 2.0*d_haba,2.0*d_haba));
							//g.fillOval( (int)b.getx()-i_haba/2,(int)b.gety()-i_haba/2,i_haba,i_haba); //‰~

							g.setColor(Color.black);
							g2.draw(new Ellipse2D.Double(b.getx()-d_haba, b.gety()-d_haba, 2.0*d_haba,2.0*d_haba));
						*/    //g.drawOval( (int)b.getx()-i_haba/2,(int)b.gety()-i_haba/2,i_haba,i_haba); //‰~
                        }
                    }


                }
            }
        }


        return memo_temp;
    }


    //---------------------------------------------------------------------------------------------------------------------------------
    public void Memo_jyouhou_tuika(Memo memo1) {
        //String str=new String();//•¶Žš—ñ?ˆ—?—p‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»
        // ----------------------------------------------------------------------


        memo1.addGyou("<camera_of_orisen_nyuuryokuzu>");
        memo1.addGyou("<camera_ichi_x>" + camera.get_camera_ichi_x() + "</camera_ichi_x>");
        memo1.addGyou("<camera_ichi_y>" + camera.get_camera_ichi_y() + "</camera_ichi_y>");
        memo1.addGyou("<camera_kakudo>" + camera.get_camera_kakudo() + "</camera_kakudo>");
        memo1.addGyou("<camera_kagami>" + camera.get_camera_kagami() + "</camera_kagami>");
        memo1.addGyou("<camera_bairitsu_x>" + camera.get_camera_bairitsu_x() + "</camera_bairitsu_x>");
        memo1.addGyou("<camera_bairitsu_y>" + camera.get_camera_bairitsu_y() + "</camera_bairitsu_y>");
        memo1.addGyou("<hyouji_ichi_x>" + camera.get_hyouji_ichi_x() + "</hyouji_ichi_x>");
        memo1.addGyou("<hyouji_ichi_y>" + camera.get_hyouji_ichi_y() + "</hyouji_ichi_y>");
        memo1.addGyou("</camera_of_orisen_nyuuryokuzu>");


        // ----------------------------------------------------------------------
        memo1.addGyou("<settei>");
        if (orihime_ap.ckbox_mouse_settei.isSelected()) {
            memo1.addGyou("<ckbox_mouse_settei>true </ckbox_mouse_settei>");
        }
        if (!orihime_ap.ckbox_mouse_settei.isSelected()) {
            memo1.addGyou("<ckbox_mouse_settei>false</ckbox_mouse_settei>");
        }

        if (orihime_ap.ckbox_ten_sagasi.isSelected()) {
            memo1.addGyou("<ckbox_ten_sagasi>true </ckbox_ten_sagasi>");
        }
        if (!orihime_ap.ckbox_ten_sagasi.isSelected()) {
            memo1.addGyou("<ckbox_ten_sagasi>false</ckbox_ten_sagasi>");
        }

        if (orihime_ap.ckbox_ten_hanasi.isSelected()) {
            memo1.addGyou("<ckbox_ten_hanasi>true </ckbox_ten_hanasi>");
        }
        if (!orihime_ap.ckbox_ten_hanasi.isSelected()) {
            memo1.addGyou("<ckbox_ten_hanasi>false</ckbox_ten_hanasi>");
        }

        if (orihime_ap.ckbox_kou_mitudo_nyuuryoku.isSelected()) {
            memo1.addGyou("<ckbox_kou_mitudo_nyuuryoku>true </ckbox_kou_mitudo_nyuuryoku>");
        }
        if (!orihime_ap.ckbox_kou_mitudo_nyuuryoku.isSelected()) {
            memo1.addGyou("<ckbox_kou_mitudo_nyuuryoku>false</ckbox_kou_mitudo_nyuuryoku>");
        }

        if (orihime_ap.ckbox_bun.isSelected()) {
            memo1.addGyou("<ckbox_bun>true </ckbox_bun>");
        }
        if (!orihime_ap.ckbox_bun.isSelected()) {
            memo1.addGyou("<ckbox_bun>false</ckbox_bun>");
        }

        if (orihime_ap.ckbox_cp.isSelected()) {
            memo1.addGyou("<ckbox_cp>true </ckbox_cp>");
        }
        if (!orihime_ap.ckbox_cp.isSelected()) {
            memo1.addGyou("<ckbox_cp>false</ckbox_cp>");
        }

        if (orihime_ap.ckbox_a0.isSelected()) {
            memo1.addGyou("<ckbox_a0>true </ckbox_a0>");
        }
        if (!orihime_ap.ckbox_a0.isSelected()) {
            memo1.addGyou("<ckbox_a0>false</ckbox_a0>");
        }

        if (orihime_ap.ckbox_a1.isSelected()) {
            memo1.addGyou("<ckbox_a1>true </ckbox_a1>");
        }
        if (!orihime_ap.ckbox_a1.isSelected()) {
            memo1.addGyou("<ckbox_a1>false</ckbox_a1>");
        }

        if (orihime_ap.ckbox_mejirusi.isSelected()) {
            memo1.addGyou("<ckbox_mejirusi>true </ckbox_mejirusi>");
        }
        if (!orihime_ap.ckbox_mejirusi.isSelected()) {
            memo1.addGyou("<ckbox_mejirusi>false</ckbox_mejirusi>");
        }

        if (orihime_ap.ckbox_cp_ue.isSelected()) {
            memo1.addGyou("<ckbox_cp_ue>true </ckbox_cp_ue>");
        }
        if (!orihime_ap.ckbox_cp_ue.isSelected()) {
            memo1.addGyou("<ckbox_cp_ue>false</ckbox_cp_ue>");
        }

        if (orihime_ap.ckbox_oritatami_keika.isSelected()) {
            memo1.addGyou("<ckbox_oritatami_keika>true </ckbox_oritatami_keika>");
        }
        if (!orihime_ap.ckbox_oritatami_keika.isSelected()) {
            memo1.addGyou("<ckbox_oritatami_keika>false</ckbox_oritatami_keika>");
        }


        //“WŠJ?}‚Ì?ü‚Ì‘¾‚³?B
        memo1.addGyou("<iTenkaizuSenhaba>" +
                orihime_ap.iTenkaizuSenhaba +
                "</iTenkaizuSenhaba>");

        //’¸“_‚Ì‚µ‚é‚µ‚Ì•?
        memo1.addGyou("<ir_ten>" +
                orihime_ap.ir_ten +
                "</ir_ten>");

        //?Ü?ü•\Œ»‚ð?F‚Å•\‚·
        memo1.addGyou("<i_orisen_hyougen>" +
                orihime_ap.i_orisen_hyougen +
                "</i_orisen_hyougen>");

//A_A
        memo1.addGyou("<i_anti_alias>" +
                orihime_ap.i_anti_alias +
                "</i_anti_alias>");


        memo1.addGyou("</settei>");

        // ----------------------------------------------------------------------


        memo1.addGyou("<Kousi>");

        memo1.addGyou("<i_kitei_jyoutai>" + get_i_kitei_jyoutai() + "</i_kitei_jyoutai>");
        memo1.addGyou("<nyuuryoku_kitei>" + orihime_ap.nyuuryoku_kitei + "</nyuuryoku_kitei>");

        memo1.addGyou("<memori_kankaku>" + orihime_ap.memori_kankaku + "</memori_kankaku>");
        memo1.addGyou("<a_to_heikouna_memori_iti>" + kus.get_a_to_heikouna_memori_iti() + "</a_to_heikouna_memori_iti>");
        memo1.addGyou("<b_to_heikouna_memori_iti>" + kus.get_b_to_heikouna_memori_iti() + "</b_to_heikouna_memori_iti>");
        memo1.addGyou("<kousi_senhaba>" + kus.get_kousi_senhaba() + "</kousi_senhaba>");

        memo1.addGyou("<d_kousi_x_a>" + orihime_ap.d_kousi_x_a + "</d_kousi_x_a>");
        memo1.addGyou("<d_kousi_x_b>" + orihime_ap.d_kousi_x_b + "</d_kousi_x_b>");
        memo1.addGyou("<d_kousi_x_c>" + orihime_ap.d_kousi_x_c + "</d_kousi_x_c>");
        memo1.addGyou("<d_kousi_y_a>" + orihime_ap.d_kousi_y_a + "</d_kousi_y_a>");
        memo1.addGyou("<d_kousi_y_b>" + orihime_ap.d_kousi_y_b + "</d_kousi_y_b>");
        memo1.addGyou("<d_kousi_y_c>" + orihime_ap.d_kousi_y_c + "</d_kousi_y_c>");
        memo1.addGyou("<d_kousi_kakudo>" + orihime_ap.d_kousi_kakudo + "</d_kousi_kakudo>");
        //memo1.addGyou("<d_kousi_x_nagasa>"+orihime_ap.d_kousi_x_nagasa+"</d_kousi_x_nagasa>");
        //memo1.addGyou("<d_kousi_y_nagasa>"+orihime_ap.d_kousi_y_nagasa+"</d_kousi_y_nagasa>");


        memo1.addGyou("</Kousi>");
        // ----------------------------------------------------------------------

        memo1.addGyou("<Kousi_iro>");

        memo1.addGyou("<kousi_color_R>" + kus.get_kousi_color().getRed() + "</kousi_color_R>");
        memo1.addGyou("<kousi_color_G>" + kus.get_kousi_color().getGreen() + "</kousi_color_G>");
        memo1.addGyou("<kousi_color_B>" + kus.get_kousi_color().getBlue() + "</kousi_color_B>");

        memo1.addGyou("<kousi_memori_color_R>" + kus.get_kousi_memori_color().getRed() + "</kousi_memori_color_R>");
        memo1.addGyou("<kousi_memori_color_G>" + kus.get_kousi_memori_color().getGreen() + "</kousi_memori_color_G>");
        memo1.addGyou("<kousi_memori_color_B>" + kus.get_kousi_memori_color().getBlue() + "</kousi_memori_color_B>");

        memo1.addGyou("</Kousi_iro>");


        // ----------------------------------------------------------------------

        memo1.addGyou("<oriagarizu>");

        memo1.addGyou("<oriagarizu_F_color_R>" + orihime_ap.OZ.oriagarizu_F_color.getRed() + "</oriagarizu_F_color_R>");
        memo1.addGyou("<oriagarizu_F_color_G>" + orihime_ap.OZ.oriagarizu_F_color.getGreen() + "</oriagarizu_F_color_G>");
        memo1.addGyou("<oriagarizu_F_color_B>" + orihime_ap.OZ.oriagarizu_F_color.getBlue() + "</oriagarizu_F_color_B>");

        memo1.addGyou("<oriagarizu_B_color_R>" + orihime_ap.OZ.oriagarizu_B_color.getRed() + "</oriagarizu_B_color_R>");
        memo1.addGyou("<oriagarizu_B_color_G>" + orihime_ap.OZ.oriagarizu_B_color.getGreen() + "</oriagarizu_B_color_G>");
        memo1.addGyou("<oriagarizu_B_color_B>" + orihime_ap.OZ.oriagarizu_B_color.getBlue() + "</oriagarizu_B_color_B>");

        memo1.addGyou("<oriagarizu_L_color_R>" + orihime_ap.OZ.oriagarizu_L_color.getRed() + "</oriagarizu_L_color_R>");
        memo1.addGyou("<oriagarizu_L_color_G>" + orihime_ap.OZ.oriagarizu_L_color.getGreen() + "</oriagarizu_L_color_G>");
        memo1.addGyou("<oriagarizu_L_color_B>" + orihime_ap.OZ.oriagarizu_L_color.getBlue() + "</oriagarizu_L_color_B>");


        memo1.addGyou("</oriagarizu>");

    }

    //---------------------------------
    //‘Î?Ì?«‚ÌŽw’è
    //public void settaisyousei(int i){
    //taisyousei=i;
    //}
    //---------------------------------
    public void setcolor(int i) {
        icol = i;
    }

    //---------------------------------
    public int get_ieda() {
        return ieda;
    }

    //•s—v‚È?ü•ª‚ð?Á‹Ž‚·‚é-----------------------------------------------
    public void gomisute() {

        for (int i = 1; i <= ori_s.getsousuu(); i++) {
            int idel = 0;


            if (gomibako.totu_naibu(ori_s.get(i)) == 1) {
                idel = 1;
            }


            if (idel == 1) {
                ori_s.delsenbun(i);
                i = i - 1;
                ieda = ori_s.getsousuu() + 1;    //<<<<<<<<<<<<<<<<<<
            }
        }
    }


    /*
  //Ž}‚ð“®‚©‚µ‚½Œã‚Ì?ˆ—?‚ð?s‚¤ŠÖ?”----------------------------------------------------
	public void eda_atosyori_01() {//Ž}‚Ì’·‚³‚ð•Ï‚¦‚¸‚É?AŽ}‘S‘Ì‚ð•½?sˆÚ“®‚µ‚Ä”÷’²?®‚·‚é?B
    //ƒAƒNƒeƒBƒu‚È‘Ñ‚ÌˆÊ’u‚ð”÷’²?®‚·‚é
    Ten ab = new Ten(1,ori_s.getb(ieda),-1,ori_s.geta(ieda));//ƒAƒNƒeƒBƒu‚ÈŽ}‚Ì?A“_a‚©‚ç“_b‚ÖŒü‚©‚¤ƒxƒNƒgƒ‹
    Ten ba = new Ten(1,ori_s.geta(ieda),-1,ori_s.getb(ieda));//ƒAƒNƒeƒBƒu‚ÈŽ}‚Ì?A“_a‚©‚ç“_b‚ÖŒü‚©‚¤ƒxƒNƒgƒ‹

    int jeda;   //ƒAƒNƒeƒBƒu‚ÈŽ}‚Æ‹ß‚¢•Ê‚ÌŽ}
    int jbasyo; //ƒAƒNƒeƒBƒu‚ÈŽ}‚Æ‹ß‚¢•Ê‚ÌŽ}‚Ì‚Ç‚±‚ª‹ß‚¢‚Ì‚©‚ðŽ¦‚·‚½‚ß‚Ì”Ô?†

    //?@ƒAƒNƒeƒBƒu‚ÈŽ}‚Ìa“_?@‚Æ?@•Ê‚ÌŽ}?@‚Æ‚Ì‹——£‚ª?@‚’?@‚æ‚è‹ß‚¢?ê?‡

    jeda=ori_s.senbun_sagasi(ori_s.geta(ieda),2*r_ten,ieda);//ƒAƒNƒeƒBƒu‚ÈŽ}‚Ìa“_‚Æ‹ß‚¢•Ê‚ÌŽ}‚ð‹?‚ß‚é?B
    jbasyo= ori_s.senbun_busyo_sagasi(jeda,ori_s.geta(ieda),2*r_ten);//•Ê‚ÌŽ}‚Ì‚Ç‚Ì•”?Š‚ª‹ß‚¢‚©‚ð‹?‚ß‚é?B
    if( (jeda!=0) && (jbasyo==1)){ //ƒAƒNƒeƒBƒu‚ÈŽ}‚Ìa“_‚Æ?A•Ê‚ÌŽ}‚Ìa“_‚ª‹ß‚¢?ê?‡
      ori_s.seta(ieda,ori_s.geta(jeda));
      ori_s.setb(ieda,new Ten(1,ori_s.geta(ieda),1,ab));//‚±‚¤?‘‚¢‚Ä‚à‚¿‚á‚ñ‚Æ“®‚­—l‚È‚Ì‚Å?A‚±‚Ì‚Ü‚ÜŽg‚¤?B
    }
    if( (jeda!=0) && (jbasyo==2)){ //ƒAƒNƒeƒBƒu‚ÈŽ}‚Ìa“_‚Æ?A•Ê‚ÌŽ}‚Ìb“_‚ª‹ß‚¢?ê?‡
      ori_s.seta(ieda,ori_s.getb(jeda));
      ori_s.setb(ieda,new Ten(1,ori_s.geta(ieda),1,ab));
    }

    //?@ƒAƒNƒeƒBƒu‚ÈŽ}‚Ìb“_?@‚Æ?@•Ê‚ÌŽ}?@‚Æ‚Ì‹——£‚ª?@‚’?@‚æ‚è‹ß‚¢?ê?‡
    jeda=ori_s.senbun_sagasi(ori_s.getb(ieda),2*r_ten,ieda);//ƒAƒNƒeƒBƒu‚ÈŽ}‚Ìb“_‚Æ‹ß‚¢•Ê‚ÌŽ}‚ð‹?‚ß‚é?B
    jbasyo= ori_s.senbun_busyo_sagasi(jeda,ori_s.getb(ieda),2*r_ten);//•Ê‚ÌŽ}‚Ì‚Ç‚Ì•”?Š‚ª‹ß‚¢‚©‚ð‹?‚ß‚é?B
    if( (jeda!=0) && (jbasyo==1)){ //ƒAƒNƒeƒBƒu‚ÈŽ}‚Ìb“_‚Æ?A•Ê‚ÌŽ}‚Ìa“_‚ª‹ß‚¢?ê?‡
      ori_s.setb(ieda,ori_s.geta(jeda));
      ori_s.seta(ieda,new Ten(1,ori_s.getb(ieda),1,ba));
    }
    if( (jeda!=0) && (jbasyo==2)){ //ƒAƒNƒeƒBƒu‚ÈŽ}‚Ìb“_‚Æ?A•Ê‚ÌŽ}‚Ìb“_‚ª‹ß‚¢?ê?‡
        ori_s.setb(ieda,ori_s.getb(jeda));
	ori_s.seta(ieda,new Ten(1,ori_s.getb(ieda),1,ba));
    }
  }
*/
/*
  //Ž}‚ð“®‚©‚µ‚½Œã‚Ì?ˆ—?‚ð?s‚¤ŠÖ?”----------------------------------------------------
	public void eda_atosyori_02() {//ˆê’[‚Ì“_‚¾‚¯‚ðˆÚ“®‚µ‚Ä”½‘Î‚Ì’[‚Ì“_‚Í“®‚©‚³‚È‚¢‚Å”÷’²?®‚·‚é?B
    //ƒAƒNƒeƒBƒu‚È‘Ñ‚ÌˆÊ’u‚ð”÷’²?®‚·‚é

    int jeda;   //ƒAƒNƒeƒBƒu‚ÈŽ}‚Æ‹ß‚¢•Ê‚ÌŽ}
    int jbasyo; //ƒAƒNƒeƒBƒu‚ÈŽ}‚Æ‹ß‚¢•Ê‚ÌŽ}‚Ì‚Ç‚±‚ª‹ß‚¢‚Ì‚©‚ðŽ¦‚·‚½‚ß‚Ì”Ô?†
	if(ori_s.getnagasa(ieda)>=r_ten){
    //?@ƒAƒNƒeƒBƒu‚ÈŽ}‚Ìa“_?@‚Æ?@•Ê‚ÌŽ}‚Æ‚Ì‹——£‚ª?@‚’?@‚æ‚è‹ß‚¢?ê?‡
    jeda=ori_s.senbun_sagasi(ori_s.geta(ieda),r_ten,ieda);//ƒAƒNƒeƒBƒu‚ÈŽ}‚Ìa“_‚Æ‹ß‚¢•Ê‚ÌŽ}‚ð‹?‚ß‚é?B
    jbasyo= ori_s.senbun_busyo_sagasi(jeda,ori_s.geta(ieda),r_ten);//•Ê‚ÌŽ}‚Ì‚Ç‚Ì•”?Š‚ª‹ß‚¢‚©‚ð‹?‚ß‚é?B
    if( (jeda!=0) && (jbasyo==1)){ori_s.seta(ieda,ori_s.geta(jeda));}//ƒAƒNƒeƒBƒu‚ÈŽ}‚Ìa“_‚Æ?A•Ê‚ÌŽ}‚Ìa“_‚ª‹ß‚¢?ê?‡
    if( (jeda!=0) && (jbasyo==2)){ori_s.seta(ieda,ori_s.getb(jeda));}//ƒAƒNƒeƒBƒu‚ÈŽ}‚Ìa“_‚Æ?A•Ê‚ÌŽ}‚Ìb“_‚ª‹ß‚¢?ê?‡

    //?@ƒAƒNƒeƒBƒu‚ÈŽ}(ieda)‚Ìb“_?@‚Æ?@•Ê‚ÌŽ}(jeda)‚Æ‚Ì‹——£‚ª?@‚’?@‚æ‚è‹ß‚¢?ê?‡
    jeda=ori_s.senbun_sagasi(ori_s.getb(ieda),r_ten,ieda);//ƒAƒNƒeƒBƒu‚ÈŽ}‚Ìb“_‚Æ‹ß‚¢•Ê‚ÌŽ}‚ð‹?‚ß‚é?B
    jbasyo= ori_s.senbun_busyo_sagasi(jeda,ori_s.getb(ieda),r_ten);//•Ê‚ÌŽ}‚Ì‚Ç‚Ì•”?Š‚ª‹ß‚¢‚©‚ð‹?‚ß‚é?B
    if((jeda!=0) && (jbasyo==1)){ori_s.setb(ieda,ori_s.geta(jeda));}//ƒAƒNƒeƒBƒu‚ÈŽ}‚Ìb“_‚Æ?A•Ê‚ÌŽ}‚Ìa“_‚ª‹ß‚¢?ê?‡
    if((jeda!=0) && (jbasyo==2)){ori_s.setb(ieda,ori_s.getb(jeda));}//ƒAƒNƒeƒBƒu‚ÈŽ}‚Ìb“_‚Æ?A•Ê‚ÌŽ}‚Ìb“_‚ª‹ß‚¢?ê?‡

 //ˆÈ‰º‚Í070317‚É’Ç‰Á •¡?”‚Ì?ü•ª‚ª?W‚Ü‚Á‚½’¸“_‚ð•Ê‚Ì’¸“_‹ß‚­‚ÉŽ?‚Á‚Ä‚¢‚Á‚½‚Æ‚«‚ÌŒã?ˆ—?—p
//150312?@?@2*r?@‚ð?@r?@‚É?C?³


    //?@ƒAƒNƒeƒBƒu‚ÈŽ}‚Ìa“_?@‚Æ?@•Ê‚ÌŽ}‚Æ‚Ì‹——£‚ª?@‚’?@‚æ‚è‹ß‚¢?ê?‡
    jeda=ori_s.senbun_sagasi(ori_s.geta(ieda),r_ten,-10);//ƒAƒNƒeƒBƒu‚ÈiedaŽ}‚Ìa“_‚Æ‹ß‚¢•Ê‚ÌŽ}‚ð‹?‚ß‚é?B
    jbasyo= ori_s.senbun_busyo_sagasi(jeda,ori_s.geta(ieda),r_ten);//•Ê‚ÌŽ}‚Ì‚Ç‚Ì•”?Š‚ª‹ß‚¢‚©‚ð‹?‚ß‚é?B

    if((jeda!=0) && (jbasyo==1)){ori_s.kasseika(ori_s.geta(jeda),r_ten); ori_s.set(ori_s.geta(jeda));}//ƒAƒNƒeƒBƒu‚ÈiedaŽ}‚Ìa“_‚Æ?A•Ê‚ÌŽ}‚Ìa“_‚ª‹ß‚¢?ê?‡
    if((jeda!=0) && (jbasyo==2)){ori_s.kasseika(ori_s.getb(jeda),r_ten); ori_s.set(ori_s.getb(jeda));}//ƒAƒNƒeƒBƒu‚ÈiedaŽ}‚Ìa“_‚Æ?A•Ê‚ÌŽ}‚Ìb“_‚ª‹ß‚¢?ê?‡

    //?@ƒAƒNƒeƒBƒu‚ÈŽ}(ieda)‚Ìb“_?@‚Æ?@•Ê‚ÌŽ}(jeda)‚Æ‚Ì‹——£‚ª?@‚’?@‚æ‚è‹ß‚¢?ê?‡
    jeda=ori_s.senbun_sagasi(ori_s.getb(ieda),r_ten,-10);//ƒAƒNƒeƒBƒu‚ÈiedaŽ}‚Ìb“_‚Æ‹ß‚¢•Ê‚ÌŽ}‚ð‹?‚ß‚é?B
    jbasyo= ori_s.senbun_busyo_sagasi(jeda,ori_s.getb(ieda),r_ten);//•Ê‚ÌŽ}‚Ì‚Ç‚Ì•”?Š‚ª‹ß‚¢‚©‚ð‹?‚ß‚é?B

    if((jeda!=0) && (jbasyo==1)){ori_s.kasseika(ori_s.geta(jeda),r_ten); ori_s.set(ori_s.geta(jeda));}//ƒAƒNƒeƒBƒu‚ÈiedaŽ}‚Ìb“_‚Æ?A•Ê‚ÌŽ}‚Ìa“_‚ª‹ß‚¢?ê?‡
    if((jeda!=0) && (jbasyo==2)){ori_s.kasseika(ori_s.getb(jeda),r_ten); ori_s.set(ori_s.getb(jeda));}//ƒAƒNƒeƒBƒu‚ÈiedaŽ}‚Ìb“_‚Æ?A•Ê‚ÌŽ}‚Ìb“_‚ª‹ß‚¢?ê?‡
 	}

 }
*/
    public void bunkatu_seiri() {
        ori_s.bunkatu_seiri();
    }

    //public void  bunkatu_seiri_for_Smen_hassei(){ori_s.bunkatu_seiri_for_Smen_hassei();}//ori_s‚Æ‚Í?ü•ª?W?‡‚Ì‚±‚Æ?ASenbunsyuugou ori_s =new Senbunsyuugou();

    public void kousabunkatu() {
        ori_s.kousabunkatu();
    }

    public void ten_sakujyo() {
        ori_s.ten_sakujyo();
    }

    public void ten_sakujyo(double r) {
        ori_s.ten_sakujyo(r);
    }

    public void jyuufuku_senbun_sakujyo() {
        ori_s.jyuufuku_senbun_sakujyo();
    }

    public void jyuufuku_senbun_sakujyo(double r) {
        ori_s.jyuufuku_senbun_sakujyo(r);
    }


    public String undo() {
        //Ubox.setMemo(getMemo());
        s_title = setMemo_for_redo_undo(Ubox.undo());
        //ori_s.addsenbun  delsenbun‚ðŽÀŽ{‚µ‚Ä‚¢‚é‚Æ‚±‚ë‚Åcheck‚ðŽÀŽ{
        if (i_check1 == 1) {
            check1(0.001, 0.5);
        }
        if (i_check2 == 1) {
            check2(0.01, 0.5);
        }
        if (i_check3 == 1) {
            check3(0.0001);
        }
        if (i_check4 == 1) {
            check4(0.0001);
        }

        return s_title;
    }


    public String redo() {
        //Ubox.setMemo(getMemo());
        s_title = setMemo_for_redo_undo(Ubox.redo());

        //ori_s.addsenbun  delsenbun‚ðŽÀŽ{‚µ‚Ä‚¢‚é‚Æ‚±‚ë‚Åcheck‚ðŽÀŽ{
        if (i_check1 == 1) {
            check1(0.001, 0.5);
        }
        if (i_check2 == 1) {
            check2(0.01, 0.5);
        }
        if (i_check3 == 1) {
            check3(0.0001);
        }
        if (i_check4 == 1) {
            check4(0.0001);
        }

        return s_title;
    }

    public void set_title(String s_title0) {
        s_title = s_title0;
    }

    public void kiroku() {
        //ori_s.addsenbun  delsenbun‚ðŽÀŽ{‚µ‚Ä‚¢‚é‚Æ‚±‚ë‚Åcheck‚ðŽÀŽ{
        if (i_check1 == 1) {
            check1(0.001, 0.5);
        }
        if (i_check2 == 1) {
            check2(0.01, 0.5);
        }
        if (i_check3 == 1) {
            check3(0.0001);
        }
        if (i_check4 == 1) {
            check4(0.0001);
        }

        Ubox.kiroku(getMemo(s_title));
    }


    public void h_undo() {
        h_setMemo(h_Ubox.undo());
    }


    public void h_redo() {
        h_setMemo(h_Ubox.redo());
    }


    public void h_kiroku() {
        h_Ubox.kiroku(h_getMemo());
    }


    public void kousi_oekaki_with_camera(Graphics g, int i_bun_hyouji, int i_cp_hyouji, int i_a0_hyouji, int i_a1_hyouji, float fTenkaizuSenhaba, int i_orisen_hyougen, float f_h_TenkaizuSenhaba, int p0x_max, int p0y_max) {//ˆø?”‚ÍƒJƒ?ƒ‰?Ý’è?A?ü•??A‰æ–ÊX•??A‰æ–Êy?‚‚³
        //System.out.println(" E 20170201_1");
        Graphics2D g2 = (Graphics2D) g;

        String text = "";//•¶Žš—ñ?ˆ—?—p‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»
        double d;
        OritaOekaki OO = new OritaOekaki();

        Senbun s_tv = new Senbun();
        Ten a = new Ten();
        Ten b = new Ten();

        Senbun s_ob = new Senbun();


        // ------------------------------------------------------

        //ŠiŽq?ü‚Ì•`‰æ
        if (i_kou_mitudo_nyuuryoku == 0) {
            kus.oekaki(g, camera, p0x_max, p0y_max, 0);
        }
        if (i_kou_mitudo_nyuuryoku == 1) {
            kus.oekaki(g, camera, p0x_max, p0y_max, 1);
        }
    }


    //------------------------------------------------------------------------------
//Šî–{Ž}‚Ì•`‰æ111111111111111111111111111111111111111111111111111111111111111111		//System.out.println("_");
//------------------------------------------------------------------------------
    public void oekaki_with_camera(Graphics g, int i_bun_hyouji, int i_cp_hyouji, int i_a0_hyouji, int i_a1_hyouji, float fTenkaizuSenhaba, int i_orisen_hyougen, float f_h_TenkaizuSenhaba, int p0x_max, int p0y_max, int i_mejirusi_hyouji) {//ˆø?”‚ÍƒJƒ?ƒ‰?Ý’è?A?ü•??A‰æ–ÊX•??A‰æ–Êy?‚‚³
        //System.out.println(" E 20170201_1");
        Graphics2D g2 = (Graphics2D) g;

        String text = "";//•¶Žš—ñ?ˆ—?—p‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»
        double d;
        OritaOekaki OO = new OritaOekaki();

        Senbun s_tv = new Senbun();
        Ten a = new Ten();
        Ten b = new Ten();

        Senbun s_ob = new Senbun();


        // ------------------------------------------------------

        //ŠiŽq?ü‚Ì•`‰æ
        if (i_kou_mitudo_nyuuryoku == 0) {
            kus.oekaki(g, camera, p0x_max, p0y_max, 0);
        }
        if (i_kou_mitudo_nyuuryoku == 1) {
            kus.oekaki(g, camera, p0x_max, p0y_max, 1);
        }


        BasicStroke BStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
        g2.setStroke(BStroke);//?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó

        //•â?•‰æ?ü?i?Ü?ü‚Æ”ñŠ±?Â?j‚Ì•`‰æ
        if (i_a1_hyouji == 1) {
            g2.setStroke(new BasicStroke(f_h_TenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó
            for (int i = 1; i <= hoj_s.getsousuu(); i++) {

                //if(hoj_s.getcolor(i)==4){g.setColor(Color.orange);System.out.println("hoj_s.getcolor(i)==4");}
                //if(hoj_s.getcolor(i)==7){g.setColor(Color.yellow);System.out.println("hoj_s.getcolor(i)==7");}
                g_setColor(g, hoj_s.getcolor(i));

                s_tv.set(camera.object2TV(hoj_s.get(i)));
                //a.set(s_tv.geta()); b.set(s_tv.getb());
                a.set(s_tv.getax() + 0.000001, s_tv.getay() + 0.000001);
                b.set(s_tv.getbx() + 0.000001, s_tv.getby() + 0.000001);//‚È‚º0.000001‚ð‘«‚·‚©‚Æ‚¢‚¤‚Æ,ƒfƒBƒXƒvƒŒƒC‚É•`‰æ‚·‚é‚Æ‚«Œ³‚Ì?Ü?ü‚ª?V‚µ‚¢?Ü?ü‚É‰e‹¿‚³‚ê‚Ä“®‚¢‚Ä‚µ‚Ü‚¤‚Ì‚ð–h‚®‚½‚ß

                g.drawLine((int) a.getx(), (int) a.gety(), (int) b.getx(), (int) b.gety()); //’¼?ü

                if (fTenkaizuSenhaba < 2.0f) {//’¸“_‚Ì?³•ûŒ`‚ð•`‚­
                    g.setColor(Color.black);
                    //int i_haba=1;
                    int i_haba = ir_ten;
                    g.fillRect((int) a.getx() - i_haba, (int) a.gety() - i_haba, 2 * i_haba + 1, 2 * i_haba + 1); //?³•ûŒ`‚ð•`‚­//g.fillRect(10, 10, 100, 50);’·•ûŒ`‚ð•`‚­
                    g.fillRect((int) b.getx() - i_haba, (int) b.gety() - i_haba, 2 * i_haba + 1, 2 * i_haba + 1); //?³•ûŒ`‚ð•`‚­
                }

                if (fTenkaizuSenhaba >= 2.0f) {//  ‘¾?ü
                    //	OO.habaLine( g,s_tv,iTenkaizuSenhaba,hoj_s.getcolor(i));
                    g2.setStroke(new BasicStroke(1.0f + f_h_TenkaizuSenhaba % 1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó
                    //OO.habaLine( g,s_tv,iTenkaizuSenhaba,k.getcolor(i));

                    //int i_haba=iTenkaizuSenhaba;
                    //g.fillOval( (int)a.getx()-i_haba,(int)a.gety()-i_haba,2*i_haba,2*i_haba); //‰~
                    //g.fillOval( (int)b.getx()-i_haba,(int)b.gety()-i_haba,2*i_haba,2*i_haba); //‰~

                    if (ir_ten != 0) {

                        int i_haba = (int) fTenkaizuSenhaba + ir_ten;//int i_haba=2;
                        double d_haba = (double) fTenkaizuSenhaba / 2.0 + (double) ir_ten;//int i_haba=2;

                        g.setColor(Color.white);
                        g2.fill(new Ellipse2D.Double(a.getx() - d_haba, a.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                        //g.fillOval( (int)a.getx()-i_haba/2,(int)a.gety()-i_haba/2,i_haba,i_haba); //‰~

                        g.setColor(Color.black);
                        g2.draw(new Ellipse2D.Double(a.getx() - d_haba, a.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                        //g.drawOval( (int)a.getx()-i_haba/2,(int)a.gety()-i_haba/2,i_haba,i_haba); //‰~

                        g.setColor(Color.white);
                        g2.fill(new Ellipse2D.Double(b.getx() - d_haba, b.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                        //g.fillOval( (int)b.getx()-i_haba/2,(int)b.gety()-i_haba/2,i_haba,i_haba); //‰~

                        g.setColor(Color.black);
                        g2.draw(new Ellipse2D.Double(b.getx() - d_haba, b.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                        //g.drawOval( (int)b.getx()-i_haba/2,(int)b.gety()-i_haba/2,i_haba,i_haba); //‰~
                    }

                    g2.setStroke(new BasicStroke(f_h_TenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó

                }
            }
        }
        //System.out.println(" E 20170201_2");

        // ----------------------------------------------------------------

        //checkŒ‹‰Ê‚Ì•\Ž¦

        g2.setStroke(new BasicStroke(15.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));//?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó?A‚±‚±‚Å‚Í?Ü?ü‚Ì’[“_‚Ì?ü‚ÌŒ`?ó‚ÌŽw’è


        //Check1Senb‚É‚Í0”Ô–Ú‚©‚çsize()-1”Ô–Ú‚Ü‚Åƒf?[ƒ^‚ª“ü‚Á‚Ä‚¢‚é
        if (i_check1 == 1) {
            for (int i = 0; i < ori_s.check1_size(); i++) {
                Senbun s_temp = new Senbun();
                s_temp.set(ori_s.check1_getSenbun(i));
                OO.yubisasi1(g, camera.object2TV(s_temp), 7.0, 3.0, 1);
            }
        }

        if (i_check2 == 1) {
            for (int i = 0; i < ori_s.check2_size(); i++) {
                Senbun s_temp = new Senbun();
                s_temp.set(ori_s.check2_getSenbun(i));
                OO.yubisasi2(g, camera.object2TV(s_temp), 7.0, 3.0, 1);
            }
        }

        g2.setStroke(new BasicStroke(25.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));//?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó?A‚±‚±‚Å‚Í?Ü?ü‚Ì’[“_‚Ì?ü‚ÌŒ`?ó‚ÌŽw’è


        //Check4Senb‚É‚Í0”Ô–Ú‚©‚çsize()-1”Ô–Ú‚Ü‚Åƒf?[ƒ^‚ª“ü‚Á‚Ä‚¢‚é
        //System.out.println("ori_s.check4_size() = "+ori_s.check4_size());
        if (i_check4 == 1) {
            for (int i = 0; i < ori_s.check4_size(); i++) {
                Senbun s_temp = new Senbun();
                s_temp.set(ori_s.check4_getSenbun(i));
                OO.yubisasi4(g, camera.object2TV(s_temp), i_ck4_color_toukado);
            }
        }


        //Check3Senb‚É‚Í0”Ô–Ú‚©‚çsize()-1”Ô–Ú‚Ü‚Åƒf?[ƒ^‚ª“ü‚Á‚Ä‚¢‚é
        if (i_check3 == 1) {
            for (int i = 0; i < ori_s.check3_size(); i++) {
                Senbun s_temp = new Senbun();
                s_temp.set(ori_s.check3_getSenbun(i));
                //OO.jyuuji(g,camera.object2TV(s_temp.geta()), 7.0 , 3.0 , 1);
                OO.yubisasi3(g, camera.object2TV(s_temp), 7.0, 3.0, 1);
            }
        }


        //System.out.println(" E 20170201_4");

        //camera’†?S‚ð?\Žš‚Å•`‚­
        if (i_mejirusi_hyouji == 1) {
            OO.jyuuji(g, camera.object2TV(camera.get_camera_ichi()), 5.0, 2.0, 3);
        }


        //System.out.println(" E 20170201_5");


        //‰~‚ð•`‚­?@
        //System.out.println(" ‰~‚ð•`‚­ ori_s.cir_size()="+ori_s.cir_size());
        if (i_a0_hyouji == 1) {
            for (int i = 1; i <= ori_s.cir_size(); i++) {

                double d_haba;
                En e_temp = new En();
                e_temp.set(ori_s.cir_getEn(i));

                a.set(camera.object2TV(e_temp.get_tyuusin()));//‚±‚Ì?ê?‡‚Ìa‚Í•`‰æ?À•WŒn‚Å‚Ì‰~‚Ì’†?S‚ÌˆÊ’u
                //a.set(a.getx()+0.000001,a.gety()+0.000001);//‚È‚º0.000001‚ð‘«‚·‚©‚Æ‚¢‚¤‚Æ,ƒfƒBƒXƒvƒŒƒC‚É•`‰æ‚·‚é‚Æ‚«Œ³‚Ì?Ü?ü‚ª?V‚µ‚¢?Ü?ü‚É‰e‹¿‚³‚ê‚Ä“®‚¢‚Ä‚µ‚Ü‚¤‚Ì‚ð–h‚®‚½‚ß

                g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//Šî–{Žw’èA?@?@?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó
                //g.setColor(Color.cyan);


//System.out.println("get_tpp_en("+i+") = "+ori_s.get_tpp_en(i));
                if (e_temp.get_tpp() == 0) {
                    g_setColor(g, e_temp.getcolor());
                } else if (e_temp.get_tpp() == 1) {
                    g.setColor(e_temp.get_tpp_color());
                }


                //‰~Žü‚Ì•`‰æ
                d_haba = e_temp.getr() * camera.get_camera_bairitsu_x();//d_haba‚Í•`‰æŽž‚Ì‰~‚Ì”¼Œa?B‚È‚¨?Acamera.get_camera_bairitsu_x()??camera.get_camera_bairitsu_y()‚ð‘O’ñ‚Æ‚µ‚Ä‚¢‚é?B
                g2.draw(new Ellipse2D.Double(a.getx() - d_haba, a.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));


                // “_t_o‚ð‚¨ŠG‚©‚«‚·‚é‚Ì‚É•K—v‚ÈŽè?‡
                //Ten t_o =new Ten(100.0,100.0);//t_o‚ð’è‹`
                //Ten t_T =new Ten();t_T.set(camera.object2TV(t_o));//t_T‚ð’è‹`‚µ?At_o‚ð•`‰æ—p?À•W—p‚É‚É•ÏŠ·‰º‚à‚Ì‚ðset‚·‚é?B
                //g.fillRect( (int)t_T.getx()-1,(int)t_T.gety()-1,3,3); //?³•ûŒ`‚ð•`‚­//g.fillRect(10, 10, 100, 50);’·•ûŒ`‚ð•`‚­

/*
				Ten t_o =new Ten();Ten t_T =new Ten();
				for(int h=1;h<360;h++ ){
					t_o.set(e_temp.get_tyuusin().getx()+e_temp.getr()*Math.cos((double)h),
						e_temp.get_tyuusin().gety()+e_temp.getr()*Math.sin((double)h));

					t_T.set(camera.object2TV(t_o));
					g.fillRect( (int)t_T.getx()-1,(int)t_T.gety()-1,3,3); //?³•ûŒ`‚ð•`‚­//g.fillRect(10, 10, 100, 50);’·•ûŒ`‚ð•`‚­
				}
*/
            }
        }


        //‰~‚Ì’†?S‚Ì•`‰æ
        if (i_a0_hyouji == 1) {
            for (int i = 1; i <= ori_s.cir_size(); i++) {
                //if(ori_s.getcolor(i)==3){
                double d_haba;
                En e_temp = new En();
                e_temp.set(ori_s.cir_getEn(i));
                //System.out.println("Es1 ‚¨ŠG‚©‚«  "+ i+";" +e_temp.getx()+"," +e_temp.gety()+"," +e_temp.getr());

                a.set(camera.object2TV(e_temp.get_tyuusin()));//‚±‚Ì?ê?‡‚Ìa‚Í•`‰æ?À•WŒn‚Å‚Ì‰~‚Ì’†?S‚ÌˆÊ’u
                //a.set(a.getx()+0.000001,a.gety()+0.000001);//‚È‚º0.000001‚ð‘«‚·‚©‚Æ‚¢‚¤‚Æ,ƒfƒBƒXƒvƒŒƒC‚É•`‰æ‚·‚é‚Æ‚«Œ³‚Ì?Ü?ü‚ª?V‚µ‚¢?Ü?ü‚É‰e‹¿‚³‚ê‚Ä“®‚¢‚Ä‚µ‚Ü‚¤‚Ì‚ð–h‚®‚½‚ß

                g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//Šî–{Žw’èA?@?@?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó
                //g.setColor(Color.cyan);
                g.setColor(new Color(0, 255, 255, 255));

                //‰~‚Ì’†?S‚Ì•`‰æ
                if (fTenkaizuSenhaba < 2.0f) {//’†?S‚Ì?•‚¢?³•ûŒ`‚ð•`‚­
                    g.setColor(Color.black);
                    //int i_haba=1;
                    int i_haba = ir_ten;
                    g.fillRect((int) a.getx() - i_haba, (int) a.gety() - i_haba, 2 * i_haba + 1, 2 * i_haba + 1); //?³•ûŒ`‚ð•`‚­//g.fillRect(10, 10, 100, 50);’·•ûŒ`‚ð•`‚­
                    //g.fillRect( (int)b.getx()-i_haba,(int)b.gety()-i_haba,2*i_haba+1,2*i_haba+1); //?³•ûŒ`‚ð•`‚­
                }

                if (fTenkaizuSenhaba >= 2.0f) {//  ‘¾?üŽw’èŽž‚Ì’†?S‚ðŽ¦‚·?•‚¢?¬‰~‚ð•`‚­
                    g2.setStroke(new BasicStroke(1.0f + fTenkaizuSenhaba % 1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó?A‚±‚±‚Å‚Í?Ü?ü‚Ì’[“_‚Ì?ü‚ÌŒ`?ó‚ÌŽw’è
                    if (ir_ten != 0) {
                        int i_haba = (int) fTenkaizuSenhaba + ir_ten;//int i_haba=2;
                        d_haba = (double) fTenkaizuSenhaba / 2.0 + (double) ir_ten;//int i_haba=2;


                        g.setColor(Color.white);
                        g2.fill(new Ellipse2D.Double(a.getx() - d_haba, a.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                        //g.fillOval( (int)a.getx()-i_haba/2,(int)a.gety()-i_haba/2,i_haba,i_haba); //‰~


                        g.setColor(Color.black);
                        g2.draw(new Ellipse2D.Double(a.getx() - d_haba, a.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                        //g.drawOval( (int)a.getx()-i_haba/2,(int)a.gety()-i_haba/2,i_haba,i_haba); //‰~

                    }
                }
                //}
            }

        }


        //select‚Ì•`‰æ
        g2.setStroke(new BasicStroke(fTenkaizuSenhaba * 2.0f + 2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//Šî–{Žw’èA?@?@?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó
        for (int i = 1; i <= ori_s.getsousuu(); i++) {
            if (ori_s.get_select(i) == 2) {
                g.setColor(Color.green);

                s_tv.set(camera.object2TV(ori_s.get(i)));

                a.set(s_tv.getax() + 0.000001, s_tv.getay() + 0.000001);
                b.set(s_tv.getbx() + 0.000001, s_tv.getby() + 0.000001);//‚È‚º0.000001‚ð‘«‚·‚©‚Æ‚¢‚¤‚Æ,ƒfƒBƒXƒvƒŒƒC‚É•`‰æ‚·‚é‚Æ‚«Œ³‚Ì?Ü?ü‚ª?V‚µ‚¢?Ü?ü‚É‰e‹¿‚³‚ê‚Ä“®‚¢‚Ä‚µ‚Ü‚¤‚Ì‚ð–h‚®‚½‚ß

                g.drawLine((int) a.getx(), (int) a.gety(), (int) b.getx(), (int) b.gety()); //’¼?ü

            }
        }


        //“WŠJ?}‚Ì•`‰æ •â?•Šˆ?ü‚Ì‚Ý
        if (i_a0_hyouji == 1) {
            for (int i = 1; i <= ori_s.getsousuu(); i++) {
                if (ori_s.getcolor(i) == 3) {

                    g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//Šî–{Žw’èA?@?@?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó
                    //g.setColor(Color.cyan);


                    //g_setColor(g,ori_s.getcolor(i));
                    if (ori_s.get_tpp_sen(i) == 0) {
                        g_setColor(g, ori_s.getcolor(i));
                    } else if (ori_s.get_tpp_sen(i) == 1) {
                        g.setColor(ori_s.get_tpp_sen_color(i));
                    }


                    s_tv.set(camera.object2TV(ori_s.get(i)));
                    //a.set(s_tv.geta()); b.set(s_tv.getb());
                    a.set(s_tv.getax() + 0.000001, s_tv.getay() + 0.000001);
                    b.set(s_tv.getbx() + 0.000001, s_tv.getby() + 0.000001);//‚È‚º0.000001‚ð‘«‚·‚©‚Æ‚¢‚¤‚Æ,ƒfƒBƒXƒvƒŒƒC‚É•`‰æ‚·‚é‚Æ‚«Œ³‚Ì?Ü?ü‚ª?V‚µ‚¢?Ü?ü‚É‰e‹¿‚³‚ê‚Ä“®‚¢‚Ä‚µ‚Ü‚¤‚Ì‚ð–h‚®‚½‚ß

                    g.drawLine((int) a.getx(), (int) a.gety(), (int) b.getx(), (int) b.gety()); //’¼?ü

                    if (fTenkaizuSenhaba < 2.0f) {//’¸“_‚Ì?•‚¢?³•ûŒ`‚ð•`‚­
                        g.setColor(Color.black);
                        //int i_haba=1;
                        int i_haba = ir_ten;
                        g.fillRect((int) a.getx() - i_haba, (int) a.gety() - i_haba, 2 * i_haba + 1, 2 * i_haba + 1); //?³•ûŒ`‚ð•`‚­//g.fillRect(10, 10, 100, 50);’·•ûŒ`‚ð•`‚­
                        g.fillRect((int) b.getx() - i_haba, (int) b.gety() - i_haba, 2 * i_haba + 1, 2 * i_haba + 1); //?³•ûŒ`‚ð•`‚­
                    }

                    if (fTenkaizuSenhaba >= 2.0f) {//  ‘¾?ü
                        g2.setStroke(new BasicStroke(1.0f + fTenkaizuSenhaba % 1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó?A‚±‚±‚Å‚Í?Ü?ü‚Ì’[“_‚Ì?ü‚ÌŒ`?ó‚ÌŽw’è
                        if (ir_ten != 0) {
                            int i_haba = (int) fTenkaizuSenhaba + ir_ten;//int i_haba=2;
                            double d_haba = (double) fTenkaizuSenhaba / 2.0 + (double) ir_ten;//int i_haba=2;


                            g.setColor(Color.white);
                            g2.fill(new Ellipse2D.Double(a.getx() - d_haba, a.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                            //g.fillOval( (int)a.getx()-i_haba/2,(int)a.gety()-i_haba/2,i_haba,i_haba); //‰~


                            g.setColor(Color.black);
                            g2.draw(new Ellipse2D.Double(a.getx() - d_haba, a.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                            //g.drawOval( (int)a.getx()-i_haba/2,(int)a.gety()-i_haba/2,i_haba,i_haba); //‰~

                            g.setColor(Color.white);
                            g2.fill(new Ellipse2D.Double(b.getx() - d_haba, b.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                            //g.fillOval( (int)b.getx()-i_haba/2,(int)b.gety()-i_haba/2,i_haba,i_haba); //‰~

                            g.setColor(Color.black);
                            g2.draw(new Ellipse2D.Double(b.getx() - d_haba, b.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                            //g.drawOval( (int)b.getx()-i_haba/2,(int)b.gety()-i_haba/2,i_haba,i_haba); //‰~
                        }
                    }
                }
            }

        }

        //System.out.println(" E 20170201_6");

        //“WŠJ?}‚Ì•`‰æ  •â?•Šˆ?üˆÈŠO‚Ì?Ü?ü
        if (i_cp_hyouji == 1) {

            g.setColor(Color.black);

            float[] dash_M1 = {10.0f, 3.0f, 3.0f, 3.0f};//ˆê“_?½?ü
            float[] dash_M2 = {10.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f};//“ñ“_?½?ü
            float[] dash_V = {8.0f, 8.0f};//”j?ü

            g.setColor(Color.black);
            for (int i = 1; i <= ori_s.getsousuu(); i++) {
                if (ori_s.getcolor(i) != 3) {
                    if (i_orisen_hyougen == 1) {
                        g_setColor(g, ori_s.getcolor(i));
                        g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//Šî–{Žw’èA?@?@?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó
                    }

                    if (i_orisen_hyougen == 2) {
                        g_setColor(g, ori_s.getcolor(i));
                        if (ori_s.getcolor(i) == 0) {
                            g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
                        }//Šî–{Žw’èA?@?@?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó
                        if (ori_s.getcolor(i) == 1) {
                            g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash_M1, 0.0f));
                        }//ˆê“_?½?ü//?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó
                        if (ori_s.getcolor(i) == 2) {
                            g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash_V, 0.0f));
                        }//”j?ü//?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó
                    }

                    if (i_orisen_hyougen == 3) {
                        if (ori_s.getcolor(i) == 0) {
                            g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
                        }//Šî–{Žw’èA?@?@?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó
                        if (ori_s.getcolor(i) == 1) {
                            g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash_M1, 0.0f));
                        }//ˆê“_?½?ü//?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó
                        if (ori_s.getcolor(i) == 2) {
                            g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash_V, 0.0f));
                        }//”j?ü//?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó
                    }

                    if (i_orisen_hyougen == 4) {
                        if (ori_s.getcolor(i) == 0) {
                            g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
                        }//Šî–{Žw’èA?@?@?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó
                        if (ori_s.getcolor(i) == 1) {
                            g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash_M2, 0.0f));
                        }//“ñ“_?½?ü//?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó
                        if (ori_s.getcolor(i) == 2) {
                            g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash_V, 0.0f));
                        }//”j?ü//?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó
                    }


                    s_tv.set(camera.object2TV(ori_s.get(i)));
                    //a.set(s_tv.geta()); b.set(s_tv.getb());
                    a.set(s_tv.getax() + 0.000001, s_tv.getay() + 0.000001);
                    b.set(s_tv.getbx() + 0.000001, s_tv.getby() + 0.000001);//‚È‚º0.000001‚ð‘«‚·‚©‚Æ‚¢‚¤‚Æ,ƒfƒBƒXƒvƒŒƒC‚É•`‰æ‚·‚é‚Æ‚«Œ³‚Ì?Ü?ü‚ª?V‚µ‚¢?Ü?ü‚É‰e‹¿‚³‚ê‚Ä“®‚¢‚Ä‚µ‚Ü‚¤‚Ì‚ð–h‚®‚½‚ß


                    g.drawLine((int) a.getx(), (int) a.gety(), (int) b.getx(), (int) b.gety()); //’¼?ü


                    if (fTenkaizuSenhaba < 2.0f) {//’¸“_‚Ì?•‚¢?³•ûŒ`‚ð•`‚­
                        g.setColor(Color.black);
                        //int i_haba=1;
                        int i_haba = ir_ten;
                        g.fillRect((int) a.getx() - i_haba, (int) a.gety() - i_haba, 2 * i_haba + 1, 2 * i_haba + 1); //?³•ûŒ`‚ð•`‚­//g.fillRect(10, 10, 100, 50);’·•ûŒ`‚ð•`‚­
                        g.fillRect((int) b.getx() - i_haba, (int) b.gety() - i_haba, 2 * i_haba + 1, 2 * i_haba + 1); //?³•ûŒ`‚ð•`‚­
                    }


                    if (fTenkaizuSenhaba >= 2.0f) {//  ‘¾?ü
                        g2.setStroke(new BasicStroke(1.0f + fTenkaizuSenhaba % 1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó?A‚±‚±‚Å‚Í?Ü?ü‚Ì’[“_‚Ì?ü‚ÌŒ`?ó‚ÌŽw’è
                        if (ir_ten != 0) {
                            int i_haba = (int) fTenkaizuSenhaba + ir_ten;//int i_haba=2;
                            double d_haba = (double) fTenkaizuSenhaba / 2.0 + (double) ir_ten;//int i_haba=2;


                            g.setColor(Color.white);
                            g2.fill(new Ellipse2D.Double(a.getx() - d_haba, a.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                            //g.fillOval( (int)a.getx()-i_haba/2,(int)a.gety()-i_haba/2,i_haba,i_haba); //‰~


                            g.setColor(Color.black);
                            g2.draw(new Ellipse2D.Double(a.getx() - d_haba, a.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                            //g.drawOval( (int)a.getx()-i_haba/2,(int)a.gety()-i_haba/2,i_haba,i_haba); //‰~

                            g.setColor(Color.white);
                            g2.fill(new Ellipse2D.Double(b.getx() - d_haba, b.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                            //g.fillOval( (int)b.getx()-i_haba/2,(int)b.gety()-i_haba/2,i_haba,i_haba); //‰~

                            g.setColor(Color.black);
                            g2.draw(new Ellipse2D.Double(b.getx() - d_haba, b.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                            //g.drawOval( (int)b.getx()-i_haba/2,(int)b.gety()-i_haba/2,i_haba,i_haba); //‰~
                        }

                    }
                }
            }
        }

        //i_mouse_modeA==61//’·•ûŒ`“à‘I‘ð?ipaint‚Ì‘I‘ð‚ÉŽ—‚¹‚½‘I‘ð‹@”\?j‚ÌŽž‚ÉŽg‚¤
        if (orihime_ap.i_mouse_modeA == 61) {
            Ten p1 = new Ten();
            p1.set(camera.TV2object(p61_1));
            Ten p2 = new Ten();
            p2.set(camera.TV2object(p61_2));
            Ten p3 = new Ten();
            p3.set(camera.TV2object(p61_3));
            Ten p4 = new Ten();
            p4.set(camera.TV2object(p61_4));

            s_step[1].set(p1, p2); //?c?ü
            s_step[2].set(p2, p3); //‰¡?ü
            s_step[3].set(p3, p4); //?c?ü
            s_step[4].set(p4, p1); //‰¡?ü

            s_step[1].setcolor(6);
            s_step[2].setcolor(6);
            s_step[3].setcolor(6);
            s_step[4].setcolor(6);
        }

        //?ü•ª“ü—ÍŽž‚ÌˆêŽž“I‚Ès_step?ü•ª‚ð•`‚­?@

        if ((orihime_ap.i_mouse_modeA == 61) && (i_egaki_dankai != 4)) {
        } else {
            for (int i = 1; i <= i_egaki_dankai; i++) {
                g_setColor(g, s_step[i].getcolor());
                g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//Šî–{Žw’èA?@?@?ü‚Ì‘¾‚³‚â?ü‚Ì––’[‚ÌŒ`?ó

                s_tv.set(camera.object2TV(s_step[i]));
                //a.set(s_tv.geta()); b.set(s_tv.getb());
                a.set(s_tv.getax() + 0.000001, s_tv.getay() + 0.000001);
                b.set(s_tv.getbx() + 0.000001, s_tv.getby() + 0.000001);//‚È‚º0.000001‚ð‘«‚·‚©‚Æ‚¢‚¤‚Æ,ƒfƒBƒXƒvƒŒƒC‚É•`‰æ‚·‚é‚Æ‚«Œ³‚Ì?Ü?ü‚ª?V‚µ‚¢?Ü?ü‚É‰e‹¿‚³‚ê‚Ä“®‚¢‚Ä‚µ‚Ü‚¤‚Ì‚ð–h‚®‚½‚ß


                g.drawLine((int) a.getx(), (int) a.gety(), (int) b.getx(), (int) b.gety()); //’¼?ü
                int i_haba_nyuiiryokuji = 3;
                if (i_kou_mitudo_nyuuryoku == 1) {
                    i_haba_nyuiiryokuji = 2;
                }

                if (s_step[i].getiactive() == 1) {
                    g.fillOval((int) a.getx() - i_haba_nyuiiryokuji, (int) a.gety() - i_haba_nyuiiryokuji, 2 * i_haba_nyuiiryokuji, 2 * i_haba_nyuiiryokuji); //‰~
                    //g.fillOval( (int)b.getx()-i_haba_nyuiiryokuji,(int)b.gety()-i_haba_nyuiiryokuji,2*i_haba_nyuiiryokuji,2*i_haba_nyuiiryokuji); //‰~
                }
                if (s_step[i].getiactive() == 2) {
                    //g.fillOval( (int)a.getx()-i_haba_nyuiiryokuji,(int)a.gety()-i_haba_nyuiiryokuji,2*i_haba_nyuiiryokuji,2*i_haba_nyuiiryokuji); //‰~
                    g.fillOval((int) b.getx() - i_haba_nyuiiryokuji, (int) b.gety() - i_haba_nyuiiryokuji, 2 * i_haba_nyuiiryokuji, 2 * i_haba_nyuiiryokuji); //‰~
                }
                if (s_step[i].getiactive() == 3) {
                    g.fillOval((int) a.getx() - i_haba_nyuiiryokuji, (int) a.gety() - i_haba_nyuiiryokuji, 2 * i_haba_nyuiiryokuji, 2 * i_haba_nyuiiryokuji); //‰~
                    g.fillOval((int) b.getx() - i_haba_nyuiiryokuji, (int) b.gety() - i_haba_nyuiiryokuji, 2 * i_haba_nyuiiryokuji, 2 * i_haba_nyuiiryokuji); //‰~
                }


                //g.fillOval( (int)b.getx()-i_haba,(int)b.gety()-i_haba,2*i_haba,2*i_haba); //‰~
            }
        }
        //Œó•â“ü—ÍŽž‚ÌŒó•â‚ð•`‚­//System.out.println("_");
        //g2.setStroke(new BasicStroke(fTenkaizuSenhaba+1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//Šî–{Žw’èA
        g2.setStroke(new BasicStroke(fTenkaizuSenhaba + 0.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//Šî–{Žw’èA


        for (int i = 1; i <= i_kouho_dankai; i++) {
            g_setColor(g, s_kouho[i].getcolor());

            s_tv.set(camera.object2TV(s_kouho[i]));
            //a.set(s_tv.geta()); b.set(s_tv.getb());
            a.set(s_tv.getax() + 0.000001, s_tv.getay() + 0.000001);
            b.set(s_tv.getbx() + 0.000001, s_tv.getby() + 0.000001);//‚È‚º0.000001‚ð‘«‚·‚©‚Æ‚¢‚¤‚Æ,ƒfƒBƒXƒvƒŒƒC‚É•`‰æ‚·‚é‚Æ‚«Œ³‚Ì?Ü?ü‚ª?V‚µ‚¢?Ü?ü‚É‰e‹¿‚³‚ê‚Ä“®‚¢‚Ä‚µ‚Ü‚¤‚Ì‚ð–h‚®‚½‚ß

            g.drawLine((int) a.getx(), (int) a.gety(), (int) b.getx(), (int) b.gety()); //’¼?ü
            //int i_haba=ir_ten   +1;
            int i_haba = ir_ten + 5;
            //g.fillRect( (int)a.getx()-i_haba,(int)a.gety()-i_haba,2*i_haba+1,2*i_haba+1); //?³•ûŒ`‚ð•`‚­//g.fillRect(10, 10, 100, 50);’·•ûŒ`‚ð•`‚­
            //g.fillRect( (int)b.getx()-i_haba,(int)b.gety()-i_haba,2*i_haba+1,2*i_haba+1); //?³•ûŒ`‚ð•`‚­

            if (s_kouho[i].getiactive() == 1) {
                //g.fillRect( (int)a.getx()-i_haba,(int)a.gety()-i_haba,2*i_haba+1,2*i_haba+1); //?³•ûŒ`‚ð•`‚­//g.fillRect(10, 10, 100, 50);’·•ûŒ`‚ð•`‚­
                g.drawLine((int) a.getx() - i_haba, (int) a.gety(), (int) a.getx() + i_haba, (int) a.gety()); //’¼?ü
                g.drawLine((int) a.getx(), (int) a.gety() - i_haba, (int) a.getx(), (int) a.gety() + i_haba); //’¼?ü

            }
            if (s_kouho[i].getiactive() == 2) {
                //g.fillRect( (int)b.getx()-i_haba,(int)b.gety()-i_haba,2*i_haba+1,2*i_haba+1); //?³•ûŒ`‚ð•`‚­
                g.drawLine((int) b.getx() - i_haba, (int) b.gety(), (int) b.getx() + i_haba, (int) b.gety()); //’¼?ü
                g.drawLine((int) b.getx(), (int) b.gety() - i_haba, (int) b.getx(), (int) b.gety() + i_haba); //’¼?ü


            }
            if (s_kouho[i].getiactive() == 3) {
                //g.fillRect( (int)a.getx()-i_haba,(int)a.gety()-i_haba,2*i_haba+1,2*i_haba+1); //?³•ûŒ`‚ð•`‚­//g.fillRect(10, 10, 100, 50);’·•ûŒ`‚ð•`‚­
                //g.fillRect( (int)b.getx()-i_haba,(int)b.gety()-i_haba,2*i_haba+1,2*i_haba+1); //?³•ûŒ`‚ð•`‚­
                g.drawLine((int) a.getx() - i_haba, (int) a.gety(), (int) a.getx() + i_haba, (int) a.gety()); //’¼?ü
                g.drawLine((int) a.getx(), (int) a.gety() - i_haba, (int) a.getx(), (int) a.gety() + i_haba); //’¼?ü
                g.drawLine((int) b.getx() - i_haba, (int) b.gety(), (int) b.getx() + i_haba, (int) b.gety()); //’¼?ü
                g.drawLine((int) b.getx(), (int) b.gety() - i_haba, (int) b.getx(), (int) b.gety() + i_haba); //’¼?ü


            }
        }

        g.setColor(Color.black);

        //‰~“ü—ÍŽž‚ÌˆêŽž“I‚È?ü•ª‚ð•`‚­?@
        //g.setColor(Color.cyan);
        for (int i = 1; i <= i_en_egaki_dankai; i++) {
            g_setColor(g, e_step[i].getcolor());
            a.set(camera.object2TV(e_step[i].get_tyuusin()));//‚±‚Ì?ê?‡‚Ìs_tv‚Í•`‰æ?À•WŒn‚Å‚Ì‰~‚Ì’†?S‚ÌˆÊ’u
            //a.set(s_tv.geta()); b.set(s_tv.getb());
            a.set(a.getx() + 0.000001, a.gety() + 0.000001);//‚È‚º0.000001‚ð‘«‚·‚©‚Æ‚¢‚¤‚Æ,ƒfƒBƒXƒvƒŒƒC‚É•`‰æ‚·‚é‚Æ‚«Œ³‚Ì?Ü?ü‚ª?V‚µ‚¢?Ü?ü‚É‰e‹¿‚³‚ê‚Ä“®‚¢‚Ä‚µ‚Ü‚¤‚Ì‚ð–h‚®‚½‚ß

            //g.drawLine( (int)a.getx(),(int)a.gety(),(int)b.getx(),(int)b.gety()); //’¼?ü
            double d_haba = e_step[i].getr() * camera.get_camera_bairitsu_x();//d_haba‚Í•`‰æŽž‚Ì‰~‚Ì”¼Œa?B‚È‚¨?Acamera.get_camera_bairitsu_x()??camera.get_camera_bairitsu_y()‚ð‘O’ñ‚Æ‚µ‚Ä‚¢‚é?B

            //g2.fill(new Ellipse2D.Double(a.getx()-d_haba, a.gety()-d_haba, 2.0*d_haba,2.0*d_haba));
            g2.draw(new Ellipse2D.Double(a.getx() - d_haba, a.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
            //g.drawOval( (int)a.getx()-i_haba/2,(int)a.gety()-i_haba/2,i_haba,i_haba); //‰~
        }


        g.setColor(Color.black);


        //text_cp_setumei=text_cp_setumei+"aaaaaaaaaaaaaaaaa";
        if (i_bun_hyouji == 1) {
            g.drawString(text_cp_setumei, 120, 120);
        }
        //if(i_bun_hyouji==1){g.drawString(text_cp_setumei2,120,120); }

        //System.out.println(" E 20170201_8");
    }


    // -------------------------------------------------------------------------------------------------------------------------------
    public void g_setColor(Graphics g, int i) {
/*

		Color.black       ?•‚ð•\‚µ‚Ü‚·
		Color.blue        ?Â‚ð•\‚µ‚Ü‚·
		Color.cyan        ƒVƒAƒ“‚ð•\‚µ‚Ü‚·
		Color.darkGray    ƒ_?[ƒNƒOƒŒƒC‚ð•\‚µ‚Ü‚·
		Color.gray        ƒOƒŒƒC‚ð•\‚µ‚Ü‚·
		Color.green       —Î‚ð•\‚µ‚Ü‚·
		Color.lightGray   ƒ‰ƒCƒgƒOƒŒƒC‚ð•\‚µ‚Ü‚·
		Color.magenta     ƒ}ƒ[ƒ“ƒ^‚ð•\‚µ‚Ü‚·
		Color.orange      ƒIƒŒƒ“ƒW‚ð•\‚µ‚Ü‚·
		Color.pink        ƒsƒ“ƒN‚ð•\‚µ‚Ü‚·
		Color.red         ?Ô‚ð•\‚µ‚Ü‚·
		Color.white       ”’‚ð•\‚µ‚Ü‚·
		Color.yellow      ‰©‚ð•\‚µ‚Ü‚·
*/

        //icol=0 black
        //icol=1 red
        //icol=2 blue
        //icol=3 cyan
        //icol=4 orange
        //icol=5 mazenta
        //icol=6 green
        //icol=7 yellow
        //icol=8 new Color(210,0,255) //Ž‡

        if (i == 0) {
            g.setColor(Color.black);
            return;
        }
        if (i == 1) {
            g.setColor(Color.red);
            return;
        }
        if (i == 2) {
            g.setColor(Color.blue);
            return;
        }
        //g.setColor(new Color(100, 200,200));‚±‚Ì?F‚Í•â?•?ü—p‚ÉŽg‚Á‚½•û‚ª‚¢‚¢‚©‚à
        if (i == 3) {
            g.setColor(new Color(100, 200, 200));
            return;
        }
        //if(i==3){g.setColor(Color.cyan);return;}
        if (i == 4) {
            g.setColor(Color.orange);
            return;
        }
        if (i == 5) {
            g.setColor(Color.magenta);
            return;
        }
        if (i == 6) {
            g.setColor(Color.green);
            return;
        }
        if (i == 7) {
            g.setColor(Color.yellow);
            return;
        }
        if (i == 8) {
            g.setColor(new Color(210, 0, 255));
            return;
        }


    }


    public void set_i_egaki_dankai(int i) {
        i_egaki_dankai = i;
    }

    public void set_i_en_egaki_dankai(int i) {
        i_en_egaki_dankai = i;
    }


    public void set_id_kakudo_kei(int i) {
        id_kakudo_kei = i;
    }


// ------------------------------------

    //	public void set_i_hanasi(int i){i_hanasi=i;}
// ------------------------------------
    public void set_i_kou_mitudo_nyuuryoku(int i) {
        i_kou_mitudo_nyuuryoku = i;
    }

// ------------------------------------


    // *************************************************************************************
//--------------------------
    public void add_en(En e0) {
        add_en(e0.getx(), e0.gety(), e0.getr(), e0.getcolor());
    }

    //--------------------------
//--------------------------
    public void add_en(Ten t0, double dr, int ic) {
        add_en(t0.getx(), t0.gety(), dr, ic);
    }

    //--------------------------
    public void add_en(double dx, double dy, double dr, int ic) {
        ori_s.add_en(dx, dy, dr, ic);

        int imin = 1;
        int imax = ori_s.cir_size() - 1;
        int jmin = ori_s.cir_size();
        int jmax = ori_s.cir_size();

        ori_s.en_en_kouten(imin, imax, jmin, jmax);
        ori_s.Senbun_en_kouten(1, ori_s.getsousuu(), jmin, jmax);

    }


    //--------------------------
    public int addsenbun_hojyo(Senbun s0) {
        hoj_s.addsenbun(s0);

        return 1;
    }

    //--------------------------------------------
    public int addsenbun(Senbun s0) {//0=•Ï?X‚È‚µ?A1=?F‚Ì•Ï‰»‚Ì‚Ý?A2=?ü•ª’Ç‰Á

        ori_s.addsenbun(s0);//ori_s‚Ìsenbun‚Ì?ÅŒã‚És0‚Ì?î•ñ‚ð‚ð‰Á‚¦‚é‚¾‚¯
        int sousuu_old = ori_s.getsousuu();
        ori_s.Senbun_en_kouten(ori_s.getsousuu(), ori_s.getsousuu(), 1, ori_s.cir_size());

        ori_s.kousabunkatu(1, sousuu_old - 1, sousuu_old, sousuu_old);

        return 1;
    }

    //------------------------------------------------------
    public Ten get_moyori_ten_orisen_en(Ten t0) {//
        //—pŽ†1/1•ªŠ„Žž 		?Ü?ü‚Ì’[“_‚Ì‚Ý‚ªŠî?€“_?BŠiŽq“_‚ªŠî?€“_‚É‚È‚é‚±‚Æ‚Í‚È‚¢?B
        //—pŽ†1/2‚©‚ç1/512•ªŠ„Žž	?Ü?ü‚Ì’[“_‚Æ—pŽ†˜g“à?i-200.0,-200.0 _ 200.0,200.0)?j‚ÌŠiŽq“_‚Æ‚ªŠî?€“_
        Ten t1 = new Ten(); //?Ü?ü‚Ì’[“_

        Ten t3 = new Ten(); //‰~‚Ì’†?S

        t1.set(ori_s.mottomo_tikai_Ten(t0));//ori_s.mottomo_tikai_Ten_sagasi‚Í‹ß‚¢“_‚ª‚È‚¢‚Æ p_return.set(100000.0,100000.0)‚Æ•Ô‚µ‚Ä‚­‚é

        t3.set(ori_s.mottomo_tikai_Tyuusin(t0));//ori_s.mottomo_tikai_Ten_sagasi‚Í‹ß‚¢“_‚ª‚È‚¢‚Æ p_return.set(100000.0,100000.0)‚Æ•Ô‚µ‚Ä‚­‚é
        if (t0.kyori2jyou(t1) > t0.kyori2jyou(t3)) {
            t1.set(t3);
        }


        //if(kus.jyoutai()==0){return t1;}


        //if( t0.kyori2jyou(t1)>  t0.kyori2jyou(kus.moyori_kousi_ten(t0)) ){return kus.moyori_kousi_ten(t0);}
        return t1;
    }

//------------------------------


    public Ten get_moyori_ten(Ten t0) {
        //—pŽ†1/1•ªŠ„Žž 		?Ü?ü‚Ì’[“_‚Ì‚Ý‚ªŠî?€“_?BŠiŽq“_‚ªŠî?€“_‚É‚È‚é‚±‚Æ‚Í‚È‚¢?B
        //—pŽ†1/2‚©‚ç1/512•ªŠ„Žž	?Ü?ü‚Ì’[“_‚Æ—pŽ†˜g“à?i-200.0,-200.0 _ 200.0,200.0)?j‚ÌŠiŽq“_‚Æ‚ªŠî?€“_
        Ten t1 = new Ten(); //?Ü?ü‚Ì’[“_

        Ten t3 = new Ten(); //‰~‚Ì’†?S

        t1.set(ori_s.mottomo_tikai_Ten(t0));//ori_s.mottomo_tikai_Ten_sagasi‚Í‹ß‚¢“_‚ª‚È‚¢‚Æ p_return.set(100000.0,100000.0)‚Æ•Ô‚µ‚Ä‚­‚é

        t3.set(ori_s.mottomo_tikai_Tyuusin(t0));//ori_s.mottomo_tikai_Ten_sagasi‚Í‹ß‚¢“_‚ª‚È‚¢‚Æ p_return.set(100000.0,100000.0)‚Æ•Ô‚µ‚Ä‚­‚é
        if (t0.kyori2jyou(t1) > t0.kyori2jyou(t3)) {
            t1.set(t3);
        }


        if (kus.jyoutai() == 0) {
            return t1;
        }


        if (t0.kyori2jyou(t1) > t0.kyori2jyou(kus.moyori_kousi_ten(t0))) {
            return kus.moyori_kousi_ten(t0);
        }
        return t1;
    }

    //------------------------------
    public Senbun get_moyori_senbun(Ten t0) {
        return ori_s.mottomo_tikai_Senbun(t0);
    }

    //------------------------------------------------------
    public Senbun get_moyori_step_senbun(Ten t0, int imin, int imax) {
        int minrid = -100;
        double minr = 100000;//Senbun s1 =new Senbun(100000.0,100000.0,100000.0,100000.1);
        for (int i = imin; i <= imax; i++) {
            double sk = oc.kyori_senbun(t0, s_step[i]);
            if (minr > sk) {
                minr = sk;
                minrid = i;
            }//•¿‚Ì•”•ª‚É‹ß‚¢‚©‚Ç‚¤‚©

        }

        // if(minrid==0){return s1;}

        return s_step[minrid];
        //return ori_s.mottomo_tikai_Senbun(t0);
    }


    //------------------------------
    public En get_moyori_ensyuu(Ten t0) {
        return ori_s.mottomo_tikai_ensyuu(t0);
    }

    //------------------------------------------------------
    public En get_moyori_step_ensyuu(Ten t0, int imin, int imax) {
        int minrid = -100;
        double minr = 100000;
        for (int i = imin; i <= imax; i++) {
            double ek = oc.kyori_ensyuu(t0, e_step[i]);
            if (minr > ek) {
                minr = ek;
                minrid = i;
            }//‰~Žü‚É‹ß‚¢‚©‚Ç‚¤‚©
        }
        return e_step[minrid];
    }


    public void set_s_step_iactive(int ia) {

        for (int i = 0; i < 1024; i++) {
            s_step[i].setiactive(ia);
        }


    }

//--------------------------------------------------------------------------------------
//ƒ}ƒEƒX‘€?ì----------------------------------------------------------------------------
//--------------------------------------------------------------------------------------
//	Ten p =new Ten();

    //“®?ìƒ‚ƒfƒ‹001--------------------------------------------------------------------------------------------------------
    //ƒ}ƒEƒX‘€?ì(ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mMoved_m_001(Ten p0, int i_c) {//ƒ}ƒEƒX‚Å‘I‘ð‚Å‚«‚éŒó•â“_‚ð•\Ž¦‚·‚é?B‹ß‚­‚ÉŠù?¬‚Ì“_‚ª‚ ‚é‚Æ‚«‚Í‚»‚Ì“_‚ªŒó•â“_‚Æ‚È‚é?B‹ß‚­‚ÉŠù?¬‚Ì“_‚ª–³‚¢‚Æ‚«‚ÍŒó•â“_–³‚µ‚È‚Ì‚ÅŒó•â“_‚Ì•\Ž¦‚à–³‚µ?B
        if (i_kou_mitudo_nyuuryoku == 1) {
            s_kouho[1].setiactive(3);
            i_kouho_dankai = 0;
            p.set(camera.TV2object(p0));
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                i_kouho_dankai = 1;
                s_kouho[1].set(moyori_ten, moyori_ten);
                s_kouho[1].setcolor(i_c);
            }
        }
    }


    //“®?ìƒ‚ƒfƒ‹002--------------------------------------------------------------------------------------------------------
    //ƒ}ƒEƒX‘€?ì(ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mMoved_m_002(Ten p0, int i_c) {//ƒ}ƒEƒX‚Å‘I‘ð‚Å‚«‚éŒó•â“_‚ð•\Ž¦‚·‚é?B‹ß‚­‚ÉŠù?¬‚Ì“_‚ª‚ ‚é‚Æ‚«‚Í‚»‚Ì“_?A–³‚¢‚Æ‚«‚Íƒ}ƒEƒX‚ÌˆÊ’uŽ©?g‚ªŒó•â“_‚Æ‚È‚é?B
        if (i_kou_mitudo_nyuuryoku == 1) {
            s_kouho[1].setiactive(3);
            p.set(camera.TV2object(p0));
            i_kouho_dankai = 1;
            moyori_ten.set(get_moyori_ten(p));

            if (p.kyori(moyori_ten) < d_hantei_haba) {
                s_kouho[1].set(moyori_ten, moyori_ten);
            } else {
                s_kouho[1].set(p, p);
            }

            s_kouho[1].setcolor(i_c);
            return;
        }
    }


    //“®?ìƒ‚ƒfƒ‹00a--------------------------------------------------------------------------------------------------------
    //ƒ}ƒEƒXƒNƒŠƒbƒN?iƒ}ƒEƒX‚Ì‹ß‚­‚ÌŠù?¬“_‚ð‘I‘ð?j?Aƒ}ƒEƒXƒhƒ‰ƒbƒO?i‘I‘ð‚µ‚½“_‚Æƒ}ƒEƒXŠÔ‚Ì?ü‚ª•\Ž¦‚³‚ê‚é?j?Aƒ}ƒEƒXƒŠƒŠ?[ƒX?iƒ}ƒEƒX‚Ì‹ß‚­‚ÌŠù?¬“_‚ð‘I‘ð?j‚µ‚Ä‚©‚ç–Ú“I‚Ì?ˆ—?‚ð‚·‚é?—Œ`ƒZƒbƒg

    //ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«----------------------------------------------
    public void mMoved_m_00a(Ten p0, int i_c) {
        mMoved_m_001(p0, i_c);
    }//‹ß‚¢Šù‘¶“_‚Ì‚Ý•\Ž¦

    //ƒ}ƒEƒXƒNƒŠƒbƒN----------------------------------------------------
    public void mPressed_m_00a(Ten p0, int i_c) {
        i_egaki_dankai = 1;
        s_step[1].setiactive(2);
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        moyori_ten.set(get_moyori_ten(p));
        if (p.kyori(moyori_ten) > d_hantei_haba) {
            i_egaki_dankai = 0;
        }
        s_step[1].set(p, moyori_ten);
        s_step[1].setcolor(i_c);
    }

    //ƒ}ƒEƒXƒhƒ‰ƒbƒO---------------------------------------------------
    public void mDragged_m_00a(Ten p0, int i_c) {  //‹ß‚¢Šù‘¶“_‚Ì‚Ý•\Ž¦

        p.set(camera.TV2object(p0));
        s_step[1].seta(p);

        if (i_kou_mitudo_nyuuryoku == 1) {
            i_kouho_dankai = 0;
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                i_kouho_dankai = 1;
                s_kouho[1].set(moyori_ten, moyori_ten);
                s_kouho[1].setcolor(i_c);
                s_step[1].seta(s_kouho[1].geta());
            }
        }
    }

    //ƒ}ƒEƒXƒŠƒŠ?[ƒX--------------------------------------------------
    public void mReleased_m_00a(Ten p0) {
        if (i_egaki_dankai == 1) {
            i_egaki_dankai = 0;

            p.set(camera.TV2object(p0));
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) <= d_hantei_haba) {
                s_step[1].seta(moyori_ten);
                if (s_step[1].getnagasa() > 0.00000001) {
                    //‚â‚è‚½‚¢“®?ì‚Í‚±‚±‚É?‘‚­
                    //addsenbun(s_step[1]);
                    //kiroku();
                }
            }
        }
    }


    //“®?ìƒ‚ƒfƒ‹00b--------------------------------------------------------------------------------------------------------
    //ƒ}ƒEƒXƒNƒŠƒbƒN?i‹ß‚­‚ÌŠù?¬“_‚©ƒ}ƒEƒXˆÊ’u‚ð‘I‘ð?j?Aƒ}ƒEƒXƒhƒ‰ƒbƒO?i‘I‘ð‚µ‚½“_‚Æƒ}ƒEƒXŠÔ‚Ì?ü‚ª•\Ž¦‚³‚ê‚é?j?Aƒ}ƒEƒXƒŠƒŠ?[ƒX?i‹ß‚­‚ÌŠù?¬“_‚©ƒ}ƒEƒXˆÊ’u‚ð‘I‘ð?j‚µ‚Ä‚©‚ç–Ú“I‚Ì?ˆ—?‚ð‚·‚é?—Œ`ƒZƒbƒg

    //ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«----------------------------------------------
    public void mMoved_m_00b(Ten p0, int i_c) {
        mMoved_m_002(p0, i_c);
    }//‹ß‚­‚ÌŠù?¬“_‚©ƒ}ƒEƒXˆÊ’u•\Ž¦

    //ƒ}ƒEƒXƒNƒŠƒbƒN----------------------------------------------------
    public void mPressed_m_00b(Ten p0, int i_c) {
        i_egaki_dankai = 1;
        s_step[1].setiactive(2);
        p.set(camera.TV2object(p0));
        s_step[1].set(p, p);

        moyori_ten.set(get_moyori_ten(p));
        if (p.kyori(moyori_ten) < d_hantei_haba) {
            s_step[1].set(p, moyori_ten);
        }

        s_step[1].setcolor(i_c);
    }

    //ƒ}ƒEƒXƒhƒ‰ƒbƒO---------------------------------------------------
    public void mDragged_m_00b(Ten p0, int i_c) {  //‹ß‚­‚ÌŠù?¬“_‚©ƒ}ƒEƒXˆÊ’u•\Ž¦

        p.set(camera.TV2object(p0));
        s_step[1].seta(p);

        if (i_kou_mitudo_nyuuryoku == 1) {
            moyori_ten.set(get_moyori_ten(p));
            i_kouho_dankai = 1;
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                s_kouho[1].set(moyori_ten, moyori_ten);
            } else {
                s_kouho[1].set(p, p);
            }
            s_kouho[1].setcolor(i_c);
            s_step[1].seta(s_kouho[1].geta());
        }
    }

    //ƒ}ƒEƒXƒŠƒŠ?[ƒX--------------------------------------------------
    public void mReleased_m_00b(Ten p0) {
        i_egaki_dankai = 0;
        p.set(camera.TV2object(p0));
        s_step[1].seta(p);
        moyori_ten.set(get_moyori_ten(p));
        if (p.kyori(moyori_ten) <= d_hantei_haba) {
            s_step[1].seta(moyori_ten);
        }
        if (s_step[1].getnagasa() > 0.00000001) {
            //‚â‚è‚½‚¢“®?ì‚Í‚±‚±‚É?‘‚­

        }
    }


//--------------------------------------------
//28 28 28 28 28 28 28 28  i_mouse_modeA==28?ü•ª“à•ª“ü—Í
    //“®?ìŠT—v
    //i_mouse_modeA==1‚Æ?ü•ª“à•ªˆÈŠO‚Í“¯‚¶

    //ƒ}ƒEƒX‘€?ì(ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mMoved_A_28(Ten p0) {
        mMoved_m_00a(p0, icol);//ƒ}ƒEƒX‚Å‘I‘ð‚Å‚«‚éŒó•â“_‚ð•\Ž¦‚·‚é?B‹ß‚­‚ÉŠù?¬‚Ì“_‚ª‚ ‚é‚Æ‚«‚Í‚»‚Ì“_?A–³‚¢‚Æ‚«‚Íƒ}ƒEƒX‚ÌˆÊ’uŽ©?g‚ªŒó•â“_‚Æ‚È‚é?B

    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==28?ü•ª“à•ª“ü—Í ‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ----------------------------------------------------
    public void mPressed_A_28(Ten p0) {
        i_egaki_dankai = 1;
        s_step[1].setiactive(2);
        p.set(camera.TV2object(p0));
        moyori_ten.set(get_moyori_ten(p));
        if (p.kyori(moyori_ten) < d_hantei_haba) {
            s_step[1].set(p, moyori_ten);
            s_step[1].setcolor(icol);
            return;
        }
        s_step[1].set(p, p);
        s_step[1].setcolor(icol);
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==28?ü•ª“ü—Í ‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mDragged_A_28(Ten p0) {
        p.set(camera.TV2object(p0));
        s_step[1].seta(p);

        if (i_kou_mitudo_nyuuryoku == 1) {
            moyori_ten.set(get_moyori_ten(p));
            i_kouho_dankai = 1;
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                s_kouho[1].set(moyori_ten, moyori_ten);
            } else {
                s_kouho[1].set(p, p);
            }
            s_kouho[1].setcolor(icol);
            s_step[1].seta(s_kouho[1].geta());
        }
        return;
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==28?ü•ª“ü—Í?@‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mReleased_A_28(Ten p0) {
        i_egaki_dankai = 0;
        p.set(camera.TV2object(p0));

        s_step[1].seta(p);
        moyori_ten.set(get_moyori_ten(p));

        if (p.kyori(moyori_ten) <= d_hantei_haba) {
            s_step[1].seta(moyori_ten);
        }
        if (s_step[1].getnagasa() > 0.00000001) {
            if ((d_naibun_s == 0.0) && (d_naibun_t == 0.0)) {
            }
            if ((d_naibun_s == 0.0) && (d_naibun_t != 0.0)) {
                addsenbun(s_step[1]);
            }
            if ((d_naibun_s != 0.0) && (d_naibun_t == 0.0)) {
                addsenbun(s_step[1]);
            }
            if ((d_naibun_s != 0.0) && (d_naibun_t != 0.0)) {
                Senbun s_ad = new Senbun();
                s_ad.setcolor(icol);
                double nx = (d_naibun_t * s_step[1].getbx() + d_naibun_s * s_step[1].getax()) / (d_naibun_s + d_naibun_t);
                double ny = (d_naibun_t * s_step[1].getby() + d_naibun_s * s_step[1].getay()) / (d_naibun_s + d_naibun_t);
                s_ad.set(s_step[1].getax(), s_step[1].getay(), nx, ny);
                addsenbun(s_ad);
                s_ad.set(s_step[1].getbx(), s_step[1].getby(), nx, ny);
                addsenbun(s_ad);
            }
            kiroku();
        }
    }


//1 1 1 1 1 1 01 01 01 01 01 11111111111 i_mouse_modeA==1?ü•ª“ü—Í 111111111111111111111111111111111
    //“®?ìŠT—v?@
    //ƒ}ƒEƒXƒ{ƒ^ƒ“‰Ÿ‚³‚ê‚½‚Æ‚«?@
    //—pŽ†1/1•ªŠ„Žž 		?Ü?ü‚Ì’[“_‚Ì‚Ý‚ªŠî?€“_?BŠiŽq“_‚ªŠî?€“_‚É‚È‚é‚±‚Æ‚Í‚È‚¢?B
    //—pŽ†1/2‚©‚ç1/512•ªŠ„Žž	?Ü?ü‚Ì’[“_‚Æ—pŽ†˜g“à?i-200.0,-200.0 _ 200.0,200.0)?j‚ÌŠiŽq“_‚Æ‚ªŠî?€“_
    //“ü—Í“_P‚ªŠî?€“_‚©‚çŠiŽq•?kus.d_haba()‚Ì1/4‚æ‚è‰“‚¢‚Æ‚«‚Í?Ü?ü?W?‡‚Ö‚Ì“ü—Í‚È‚µ
    //?ü•ª‚ª’·‚³‚ª‚È‚­1“_?ó‚Ì‚Æ‚«‚Í?Ü?ü?W?‡‚Ö‚Ì“ü—Í‚È‚µ

    //ƒ}ƒEƒX‘€?ì(ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mMoved_A_01(Ten p0) {
        if (i_kou_mitudo_nyuuryoku == 1) {
            s_kouho[1].setiactive(3);

            p.set(camera.TV2object(p0));
            i_kouho_dankai = 1;
            moyori_ten.set(get_moyori_ten(p));

            if (p.kyori(moyori_ten) < d_hantei_haba) {
                s_kouho[1].set(moyori_ten, moyori_ten);
            } else {
                s_kouho[1].set(p, p);
            }

            //s_kouho[1].setcolor(icol);
            if (i_orisen_hojyosen == 0) {
                s_kouho[1].setcolor(icol);
            }
            if (i_orisen_hojyosen == 1) {
                s_kouho[1].setcolor(h_icol);
            }

            return;
        }
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==1?ü•ª“ü—Í?@‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ----------------------------------------------------
    public void mPressed_A_01(Ten p0) {
        i_egaki_dankai = 1;
        s_step[1].setiactive(2);
        p.set(camera.TV2object(p0));

        moyori_ten.set(get_moyori_ten(p));
        if (p.kyori(moyori_ten) < d_hantei_haba) {
            s_step[1].set(p, moyori_ten);
            if (i_orisen_hojyosen == 0) {
                s_step[1].setcolor(icol);
            }
            if (i_orisen_hojyosen == 1) {
                s_step[1].setcolor(h_icol);
            }
            return;
        }

        s_step[1].set(p, p);
        if (i_orisen_hojyosen == 0) {
            s_step[1].setcolor(icol);
        }
        if (i_orisen_hojyosen == 1) {
            s_step[1].setcolor(h_icol);
        }
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==1?ü•ª“ü—Í?@‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mDragged_A_01(Ten p0) {
        p.set(camera.TV2object(p0));

        if (i_kou_mitudo_nyuuryoku == 0) {
            s_step[1].seta(p);
        }

        if (i_kou_mitudo_nyuuryoku == 1) {
            moyori_ten.set(get_moyori_ten(p));
            i_kouho_dankai = 1;
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                s_kouho[1].set(moyori_ten, moyori_ten);
            } else {
                s_kouho[1].set(p, p);
            }
            //s_kouho[1].setcolor(icol);
            if (i_orisen_hojyosen == 0) {
                s_kouho[1].setcolor(icol);
            }
            if (i_orisen_hojyosen == 1) {
                s_kouho[1].setcolor(h_icol);
            }
            s_step[1].seta(s_kouho[1].geta());
        }
        return;
    }


    public Ten get_moyori_ten_sisuu(Ten p0) {
        p.set(camera.TV2object(p0));
        moyori_ten.set(get_moyori_ten(p));
        Ten kus_sisuu = new Ten(kus.get_sisuu(moyori_ten));
        return kus_sisuu;
        //text_cp_setumei2="sisuu="+(int)kus_sisuu.getx()+","+(int)kus_sisuu.gety();
//System.out.println("sisuu="+kus_sisuu.getx()+","+kus_sisuu.gety());
//System.out.println("sisuu="+(int)kus_sisuu.getx()+","+(int)kus_sisuu.gety());
    }


    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==1?ü•ª“ü—Í?@‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mReleased_A_01(Ten p0) {
        i_egaki_dankai = 0;
        p.set(camera.TV2object(p0));
        s_step[1].seta(p);
        moyori_ten.set(get_moyori_ten(p));
        if (p.kyori(moyori_ten) <= d_hantei_haba) {
            s_step[1].seta(moyori_ten);
        }
        if (s_step[1].getnagasa() > 0.00000001) {
            if (i_orisen_hojyosen == 0) {
                addsenbun(s_step[1]);
                kiroku();
            }
            if (i_orisen_hojyosen == 1) {
                addsenbun_hojyo(s_step[1]);
                h_kiroku();
            }
        }
        //text_cp_setumei="aaaaaa"+ori_s.getsousuu();
    }

    //11 11 11 11 11 11 11 11 11 11 11
    //ƒ}ƒEƒX‘€?ì(ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mMoved_A_11(Ten p0) {
        mMoved_m_00a(p0, icol);
    }//‹ß‚¢Šù‘¶“_‚Ì‚Ý•\Ž¦

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==11?ü•ª“ü—Í?@‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ----------------------------------------------------
    public void mPressed_A_11(Ten p0) {
        mPressed_m_00a(p0, icol);
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==11?ü•ª“ü—Í?@‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mDragged_A_11(Ten p0) {
        mDragged_m_00a(p0, icol);
    }//‹ß‚¢Šù‘¶“_‚Ì‚Ý•\Ž¦

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==11?ü•ª“ü—Í?@‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mReleased_A_11(Ten p0) {
        if (i_egaki_dankai == 1) {
            i_egaki_dankai = 0;

            p.set(camera.TV2object(p0));
            moyori_ten.set(get_moyori_ten(p));
            s_step[1].seta(moyori_ten);
            if (p.kyori(moyori_ten) <= d_hantei_haba) {
                if (s_step[1].getnagasa() > 0.00000001) {
                    addsenbun(s_step[1]);
                    kiroku();
                }
            }
        }
    }


//62 62 62 62 62 i_mouse_modeA==62 ƒ{ƒ?ƒmƒC?@ Voronoi 111111111111111111111111111111111


    ArrayList Senb_boro_1p = new ArrayList(); //ƒ{ƒ?ƒmƒC?}‚Ìˆê“_‚ÌŽü‚è‚Ì?ü•ª

// ------------------------------------------


    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==62ƒ{ƒ?ƒmƒC?@ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mMoved_A_62(Ten p0) {
        if (i_kou_mitudo_nyuuryoku == 1) {
            s_kouho[1].setiactive(3);

            p.set(camera.TV2object(p0));
            i_kouho_dankai = 1;
            moyori_ten.set(get_moyori_ten(p));

            if (p.kyori(moyori_ten) < d_hantei_haba) {
                s_kouho[1].set(moyori_ten, moyori_ten);
            } else {
                s_kouho[1].set(p, p);
            }

            //s_kouho[1].setcolor(icol);
            if (i_orisen_hojyosen == 0) {
                s_kouho[1].setcolor(icol);
            }
            if (i_orisen_hojyosen == 1) {
                s_kouho[1].setcolor(h_icol);
            }

            return;
        }
    }


//int s_step_no_saisyo_no_sen_no_bangou() {//s_step[i]‚Å?Å?‰‚É?ü?i’·‚³‚ª‚O‚Å‚È‚¢?j‚ª‚Å‚Ä‚­‚é”Ô?†‚ð•Ô‚·?B?ü?i’·‚³‚ª‚O‚Å‚È‚¢?j‚ª‚È‚¢?ê?‡‚Í0‚ð•Ô‚·
//		for (int i=1; i<=i_egaki_dankai; i++ ){if(s_step[i].getnagasa()>0.00000001){return i;}
//return 0;
//}


    // ------------------------------------------------------------------------------------------------------------
    int s_step_no_1_kara_rennzoku_no_ten_no_bangou() {//s_step[i]‚Å?Å?‰‚©‚ç˜A‘±‚ÅTen?i’·‚³‚ª‚O?j‚ª‰½”Ô–Ú‚Ü‚Å‚Å‚Ä‚­‚é‚©”Ô?†‚ð•Ô‚·?B“_‚ª‚È‚¢?ê?‡‚Í0‚ð•Ô‚·
        int r_i = 0;
        int i_add = 1;
        for (int i = 1; i <= i_egaki_dankai; i++) {
            if (s_step[i].getnagasa() > 0.00000001) {
                i_add = 0;
            }
            r_i = r_i + i_add;
        }
        return r_i;
    }

    // ------------------------------------------------------------------------------------------------------------
    int i_mouse_modeA_62_ten_kasanari;//?V‚½‚É‰Á‚¦‚½p‚ª?¡‚Ü‚Å‚É‰Á‚¦‚½Ten‚Æ?d‚È‚Á‚Ä‚¢‚È‚¢=0?A?d‚È‚Á‚Ä‚¢‚é=1

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==62ƒ{ƒ?ƒmƒC?@‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ----------------------------------------------------
    public void mPressed_A_62(Ten p0) {
        p.set(camera.TV2object(p0));

        //i_egaki_dankai‚ª?]—ˆ‚Ìƒ{ƒ?ƒmƒC•ê“_‚¾‚¯‚É‚È‚é‚æ‚¤‚É?®—?(‚Ü‚¾?A“_p‚ðs_step‚Æ‚µ‚Äƒ{ƒ?ƒmƒC•ê“_‚É‰Á‚¦‚é‚©‚Ç‚¤‚©‚ÍŒˆ‚ß‚Ä‚¢‚È‚¢)
        i_egaki_dankai = s_step_no_1_kara_rennzoku_no_ten_no_bangou();//Ten‚Ì?”


        //—¼’[‚ª?V‚½‚É‰Á‚¦‚½p‚Ì?ÅŠñ“_‚©‚ç‚È‚é“_?ó‚Ì?ü•ªs_temp‚ð‹?‚ß‚é?i?ÅŠñ“_‚ª‚È‚¢?ê?‡‚Ís_temp‚Ì—¼’[‚Íp?j
        Senbun s_temp = new Senbun();
        moyori_ten.set(get_moyori_ten(p));
        if (p.kyori(moyori_ten) < d_hantei_haba) {
            s_temp.set(moyori_ten, moyori_ten);
            s_temp.setcolor(5);
        } else {
            s_temp.set(p, p);
            s_temp.setcolor(5);
        }


        //?V‚½‚É‰Á‚¦‚½p‚ª?¡‚Ü‚Å‚É‰Á‚¦‚½Ten‚Æ?d‚È‚Á‚Ä‚¢‚È‚¢‚±‚Æ‚ðŠm”F
        i_mouse_modeA_62_ten_kasanari = 0;
/*
		for (int i=1; i<=i_egaki_dankai; i++ ){
			if(oc.kyori(s_step[i].geta(),s_temp.geta())<=0.00000001){
				i_mouse_modeA_62_ten_kasanari=i;
			}
		}
*/
        for (int i = 1; i <= i_egaki_dankai; i++) {
            if (oc.kyori(s_step[i].geta(), s_temp.geta()) <= d_hantei_haba) {
                i_mouse_modeA_62_ten_kasanari = i;
            }
        }


        //?V‚½‚É‰Á‚¦‚½p‚ª?¡‚Ü‚Å‚É‰Á‚¦‚½Ten‚Æ?d‚È‚Á‚Ä‚¢‚È‚¢‚±‚Æ‚ðŠm”F ‚±‚±‚Ü‚Å

        if (i_mouse_modeA_62_ten_kasanari == 0) {
            //oc.hyouji("?@");
            //oc.hyouji("?V‚µ‚¢ƒ{ƒ?ƒmƒC•ê“_‚ð‰Á‚¦‚é?@ŠJŽn?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[");

            //‚PŒÂ‚Ì?V‚µ‚¢ƒ{ƒ?ƒmƒC•ê“_‚ð‰Á‚¦‚é(‚±‚±‚Å‚â‚Á‚Æ?A“_p‚ðs_step‚Æ‚µ‚Äƒ{ƒ?ƒmƒC•ê“_‚É‰Á‚¦‚é‚ÆŒˆ‚Ü‚Á‚½)
            i_egaki_dankai = i_egaki_dankai + 1;
            s_step[i_egaki_dankai].set(s_temp);
            s_step[i_egaki_dankai].setiactive(3);//iactive=3‚Ì?ü‚Í—¼’[‚É‰~‚ª•`‚©‚ê‚é?Biactive=1‚Ì?ü‚Ía’[‚Ì‚Ý‚É‰~‚ª•`‚©‚ê‚é?Biactive=2‚Ì?ü‚Íb’[‚Ì‚Ý‚É‰~‚ª•`‚©‚ê‚é

            //?¡‚Ü‚Å‚Ìƒ{ƒ?ƒmƒC?}‚ðŒ³‚É?A‚PŒÂ‚Ì?V‚µ‚¢ƒ{ƒ?ƒmƒC•ê“_‚ð‰Á‚¦‚½ƒ{ƒ?ƒmƒC?}‚ð?ì‚é--------------------------------------
            //System.out.println("---------------------------");
            //System.out.println("voronoi_() start");

            //voronoi_01();//’á‘¬?AƒGƒ‰?[‚Í‚Ù‚Æ‚ñ‚Ç‚È‚¢‚Í‚¸
            voronoi_02();//?‚‘¬?A‚à‚µ‚©‚µ‚ÄƒGƒ‰?[Žc‚Á‚Ä‚¢‚é‚©‚à

            //System.out.println("voronoi_() stop");


        } else if (i_mouse_modeA_62_ten_kasanari != 0) {//?‡”Ô‚ªi_mouse_modeA_62_ten_kasanari‚Ìƒ{ƒ?ƒmƒC•ê“_‚ð?í?œ
            //oc.hyouji("?@");
            //oc.hyouji("ƒ{ƒ?ƒmƒC•ê“_‚ð?í?œ?@ŠJŽn?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[");

            //?‡”Ô‚ªi_mouse_modeA_62_ten_kasanari‚Ìƒ{ƒ?ƒmƒC•ê“_‚Æ?‡”Ô‚ª?ÅŒã(=i_egaki_dankai)‚Ìƒ{ƒ?ƒmƒC•ê“_‚ð“ü‚ê‘Ö‚¦‚é
            //s_step[i]‚Ì“ü‚ê‘Ö‚¦
            Senbun S_irekae = new Senbun();
            S_irekae.set(s_step[i_mouse_modeA_62_ten_kasanari]);
            s_step[i_mouse_modeA_62_ten_kasanari].set(s_step[i_egaki_dankai]);
            s_step[i_egaki_dankai].set(S_irekae);


            for (int j = 1; j <= ori_v.getsousuu(); j++) {
                //ori_v“à‚Ì?ü•ª‚Ìiactive‚Ì“ü‚ê‘Ö‚¦
                if (ori_v.getiactive(j) == i_mouse_modeA_62_ten_kasanari) {
                    ori_v.setiactive(j, i_egaki_dankai);
                } else if (ori_v.getiactive(j) == i_egaki_dankai) {
                    ori_v.setiactive(j, i_mouse_modeA_62_ten_kasanari);
                }

                //ori_v“à‚Ì?ü•ª‚Ìicol‚Ì“ü‚ê‘Ö‚¦
                if (ori_v.getcolor(j) == i_mouse_modeA_62_ten_kasanari) {
                    ori_v.setcolor(j, i_egaki_dankai);
                } else if (ori_v.getcolor(j) == i_egaki_dankai) {
                    ori_v.setcolor(j, i_mouse_modeA_62_ten_kasanari);
                }
            }


            //?‡”Ô‚ª?ÅŒã(=i_egaki_dankai)‚Ì‚Ìƒ{ƒ?ƒmƒC•ê“_‚ð?í?œ

            i_egaki_dankai = i_egaki_dankai - 1;

            Orisensyuugou ori_v_temp = new Orisensyuugou();    //?C?³—p‚Ìƒ{ƒ?ƒmƒC?}‚Ì?ü‚ðŠi”[‚·‚é

            //ori_v‚Ì?ü•ª‚ð?Å?‰‚É‘S‚Ä”ñ‘I‘ð‚É‚·‚é
            ori_v.unselect_all();

            //i_egaki_dankai+1‚Ìƒ{ƒ?ƒmƒC•ê“_‚©‚ç‚Ìƒ{ƒ?ƒmƒC?ü•ª‚ð‘I‘ð?ó‘Ô‚É‚·‚é
            Senbun s_tem = new Senbun();
            Senbun s_tem2 = new Senbun();
            for (int j = 1; j <= ori_v.getsousuu(); j++) {
                s_tem.set(ori_v.get(j));//s_tem‚Æ‚µ‚Äƒ{ƒ?ƒmƒC•ê“_‚©‚ç‚Ìƒ{ƒ?ƒmƒC?ü•ª‚©”»’è
                if (s_tem.getiactive() == i_egaki_dankai + 1) {//ƒ{ƒ?ƒmƒC?ü•ª‚Ì2‚Â‚Ìƒ{ƒ?ƒmƒC’¸“_‚Íiactive‚Æcolor‚É‹L˜^‚³‚ê‚Ä‚¢‚é
                    ori_v.select(j);
                    for (int h = 1; h <= ori_v.getsousuu(); h++) {
                        s_tem2.set(ori_v.get(h));
                        if (s_tem.getcolor() == s_tem2.getcolor()) {
                            ori_v.select(h);
                        }
                        if (s_tem.getcolor() == s_tem2.getiactive()) {
                            ori_v.select(h);
                        }
                    }


                    //?í?œ‚³‚ê‚éi_egaki_dankai+1”Ô–Ú‚Ìƒ{ƒ?ƒmƒC•ê“_‚Æ‘g‚É‚È‚é?A‚à‚¤ˆê‚Â‚Ìƒ{ƒ?ƒmƒC•ê“_‚ðŽæ‚èˆÍ‚Þƒ{ƒ?ƒmƒC?ü•ª‚ÌƒAƒŒƒCƒŠƒXƒg‚ð“¾‚é?B
                    Senb_boro_1p_motome(s_tem.getcolor());

                    for (int i = 0; i < Senb_boro_1p.size(); i++) {
                        Senbun add_S = new Senbun();
                        add_S.set((Senbun) Senb_boro_1p.get(i));
                        Senbun add_S2 = new Senbun();


                        //ori_v_temp‚Éadd_S‚ð’Ç‰Á‚·‚é‚©‚Ç‚¤‚©‚ÌŽ–‘Oƒ`ƒFƒbƒN
                        int i_tuika = 1;//1‚È‚ç’Ç‰Á‚·‚é?B0‚È‚ç’Ç‰Á‚µ‚È‚¢?B
                        for (int h = 1; h <= ori_v_temp.getsousuu(); h++) {
                            add_S2.set(ori_v_temp.get(h));
                            if ((add_S.getcolor() == add_S2.getcolor()) && (add_S.getiactive() == add_S2.getiactive())) {
                                i_tuika = 0;
                            }
                            if ((add_S.getcolor() == add_S2.getiactive()) && (add_S.getiactive() == add_S2.getcolor())) {
                                i_tuika = 0;
                            }
                        }
                        //ori_v_temp‚Éadd_S‚ð’Ç‰Á‚·‚é‚©‚Ç‚¤‚©‚ÌŽ–‘Oƒ`ƒFƒbƒN‚Í‚±‚±‚Ü‚Å

                        if (i_tuika == 1) {
                            ori_v_temp.addsenbun((Senbun) Senb_boro_1p.get(i));
                        }
                    }
                } else if (s_tem.getcolor() == i_egaki_dankai + 1) {//ƒ{ƒ?ƒmƒC?ü•ª‚Ì2‚Â‚Ìƒ{ƒ?ƒmƒC’¸“_‚Íiactive‚Æcolor‚É‹L˜^‚³‚ê‚Ä‚¢‚é
                    ori_v.select(j);
                    for (int h = 1; h <= ori_v.getsousuu(); h++) {
                        s_tem2.set(ori_v.get(h));
                        if (s_tem.getiactive() == s_tem2.getcolor()) {
                            ori_v.select(h);
                        }
                        if (s_tem.getiactive() == s_tem2.getiactive()) {
                            ori_v.select(h);
                        }
                    }

                    //?í?œ‚³‚ê‚éi_egaki_dankai+1”Ô–Ú‚Ìƒ{ƒ?ƒmƒC•ê“_‚Æ‘g‚É‚È‚é?A‚à‚¤ˆê‚Â‚Ìƒ{ƒ?ƒmƒC•ê“_‚ðŽæ‚èˆÍ‚Þƒ{ƒ?ƒmƒC?ü•ª‚ÌƒAƒŒƒCƒŠƒXƒg‚ð“¾‚é?B
                    Senb_boro_1p_motome(s_tem.getiactive());

                    for (int i = 0; i < Senb_boro_1p.size(); i++) {
                        Senbun add_S = new Senbun();
                        add_S.set((Senbun) Senb_boro_1p.get(i));
                        Senbun add_S2 = new Senbun();

                        //ori_v_temp‚Éadd_S‚ð’Ç‰Á‚·‚é‚©‚Ç‚¤‚©‚ÌŽ–‘Oƒ`ƒFƒbƒN
                        int i_tuika = 1;//1‚È‚ç’Ç‰Á‚·‚é?B0‚È‚ç’Ç‰Á‚µ‚È‚¢?B
                        for (int h = 1; h <= ori_v_temp.getsousuu(); h++) {
                            add_S2.set(ori_v_temp.get(h));
                            if ((add_S.getcolor() == add_S2.getcolor()) && (add_S.getiactive() == add_S2.getiactive())) {
                                i_tuika = 0;
                            }
                            if ((add_S.getcolor() == add_S2.getiactive()) && (add_S.getiactive() == add_S2.getcolor())) {
                                i_tuika = 0;
                            }
                        }
                        //ori_v_temp‚Éadd_S‚ð’Ç‰Á‚·‚é‚©‚Ç‚¤‚©‚ÌŽ–‘Oƒ`ƒFƒbƒN‚Í‚±‚±‚Ü‚Å

                        if (i_tuika == 1) {
                            ori_v_temp.addsenbun((Senbun) Senb_boro_1p.get(i));
                        }
                    }


                }

            }
            //‘I‘ð?ó‘Ô‚Ì‚à‚Ì‚ð?í?œ
            ori_v.del_selected_senbun_hayai();
            ori_v.del_V_all(); //‚±‚Ì?s‚Í‚¢‚ç‚È‚¢‚©‚à

            //ori_v_temp‚Ìƒ{ƒ?ƒmƒC?ü•ª‚ðƒ{ƒ?ƒmƒC•ê“_‚É‰Á‚¦‚é
            //ori_v_temp.hyouji("ori_v_temp---------------------");
            for (int j = 1; j <= ori_v_temp.getsousuu(); j++) {
                Senbun s_t = new Senbun();
                s_t.set(ori_v_temp.get(j));
                //s_t.hyouji("  s_t  ");
                //addsenbun_voronoi(s_t);//addsenbun_voronoi‚ÍŒð?·•ªŠ„‚ð‚µ‚Ä‚¢‚é?BŒð?·•ªŠ„‚Åiactive‚ðŽg‚¤‚Ì‚Å?Aiactive‚ð•Ê“r‰½‚©‚É“]—p‚µ‚½ƒ‹?[ƒ`ƒ“‚Å‚ÍŒð?·•ªŠ„‚ðŽg—p‚Å‚«‚È‚¢‚Ì‚Åaddsenbun_voronoi‚àŽg—p‚Å‚«‚È‚¢
                ori_v.addsenbun(s_t);
            }


            ori_v.del_V_all();

        }


        //ƒ{ƒ?ƒmƒC?}‚à•\Ž¦‚·‚é‚æ‚¤‚És_step‚ÌŒã‚Éƒ{ƒ?ƒmƒC?}‚Ì?ü‚ð“ü‚ê‚é

        int imax = ori_v.getsousuu();
        if (imax > 1020) {
            imax = 1020;
        }

        //System.out.println("ƒ{ƒ?ƒmƒC?}‚à•\Ž¦‚·‚é‚æ‚¤‚És_step‚ÌŒã‚Éƒ{ƒ?ƒmƒC?}‚Ì?ü‚ð“ü‚ê‚é‘O");
        //System.out.println("i_egaki_dankai="+i_egaki_dankai+" :  ori_v.getsousuu()= "+ori_v.getsousuu());

        for (int i = 1; i <= imax; i++) {
            i_egaki_dankai = i_egaki_dankai + 1;
            s_step[i_egaki_dankai].set(ori_v.get(i));
            //s_step[i_egaki_dankai].setiactive(3);
            s_step[i_egaki_dankai].setiactive(0);
            s_step[i_egaki_dankai].setcolor(5);
        }


    }


    //--------------------------------------------
    public int addsenbun_voronoi(Senbun s0) {//0=•Ï?X‚È‚µ?A1=?F‚Ì•Ï‰»‚Ì‚Ý?A2=?ü•ª’Ç‰Á

        ori_v.addsenbun(s0);//ori_v‚Ìsenbun‚Ì?ÅŒã‚És0‚Ì?î•ñ‚ð‚ð‰Á‚¦‚é‚¾‚¯
        int sousuu_old = ori_v.getsousuu();
        ori_v.Senbun_en_kouten(ori_v.getsousuu(), ori_v.getsousuu(), 1, ori_v.cir_size());

        ori_v.kousabunkatu(1, sousuu_old - 1, sousuu_old, sousuu_old);

        return 1;
    }


    // -----------------------------------------------------------------------------
    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==62ƒ{ƒ?ƒmƒC?@‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mDragged_A_62(Ten p0) {
    }

    // -----------------------------------------------------------------------------
    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==62ƒ{ƒ?ƒmƒC?@‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mReleased_A_62(Ten p0) {
    }

    // ------------------------------------------
    public void voronoi_01() {//i=1‚©‚çi_egaki_dankai‚Ü‚Å‚Ìs_step[i]‚Æ?Ai_egaki_dankai-1‚Ü‚Å‚Ìƒ{ƒ?ƒmƒC?}‚©‚çi_egaki_dankai‚Ìƒ{ƒ?ƒmƒC?}‚ð?ì?¬

        //i_egaki_dankai”Ô–Ú‚Ìƒ{ƒ?ƒmƒC’¸“_‚Æ‚»‚êˆÈ‘O‚Ìƒ{ƒ?ƒmƒC’¸“_ŠÔ‚Ì2“™•ª?ü‚ðori_v‚É’Ç‰Á

        for (int i_e_d = 1; i_e_d <= i_egaki_dankai - 1; i_e_d++) {
            addsenbun_voronoi(oc.nitoubunsen(s_step[i_e_d].geta(), s_step[i_egaki_dankai].geta(), 1000.0)); //kiroku();
        }

        //ƒ{ƒ?ƒmƒC‚É“K?‡‚·‚é‚©”»’è
        //ori_v‚Ì?ü•ª‚ð?Å?‰‚É‘S‚Ä”ñ‘I‘ð‚É‚·‚é
        ori_v.unselect_all();


        //ƒ{ƒ?ƒmƒC‚É“K?‡‚µ‚È‚¢‚à‚Ì‚ð‘I‘ð?ó‘Ô‚É‚·‚é
        Senbun s_tem = new Senbun();
        for (int j = 1; j <= ori_v.getsousuu(); j++) {

            //System.out.println("ƒ{ƒ?ƒmƒC j= "+j);
            s_tem.set(ori_v.get(j));//s_tem‚Æ‚µ‚Äƒ{ƒ?ƒmƒC‚É“K?‡‚·‚é‚©”»’è

            //s_ten‚Ìa’[‚Æƒ{ƒ?ƒmƒC‚ÌŠe’¸“_‚Æ‚Ì‹——£‚Ì?Å’Z’lv_min_a‚ð‹?‚ß‚é
            double v_min_a = 1000000.0;
            for (int i = 1; i <= i_egaki_dankai; i++) {
                if (oc.kyori(s_step[i].geta(), s_tem.geta()) < v_min_a) {
                    v_min_a = oc.kyori(s_step[i].geta(), s_tem.geta());
                }
            }
            //System.out.println("v_min_a= "+v_min_a);
            //s_ten‚Ìb’[‚Æƒ{ƒ?ƒmƒC‚ÌŠe’¸“_‚Æ‚Ì‹——£‚Ì?Å’Z’lv_min_b‚ð‹?‚ß‚é
            double v_min_b = 1000000.0;
            for (int i = 1; i <= i_egaki_dankai; i++) {
                if (oc.kyori(s_step[i].geta(), s_tem.getb()) < v_min_b) {
                    v_min_b = oc.kyori(s_step[i].geta(), s_tem.getb());
                }
            }
            //System.out.println("v_min_b= "+v_min_b);


            int a_tomo_b_tomo_mottomo_tikai_voronoi_tyouten_no_kazu = 0;//a‚Æ‚àb‚Æ‚à?Å‚à‹ß‚¢ƒ{ƒ?ƒmƒC’¸“_‚Ì?”?@‚±‚ê‚ª‚Q‚È‚ç‘Î?Û?ü•ª‚Íƒ{ƒ?ƒmƒC?}‚Æ‚µ‚ÄŽc‚·
            for (int i = 1; i <= i_egaki_dankai; i++) {
                if (Math.abs(oc.kyori(s_step[i].geta(), s_tem.geta()) - v_min_a) < 0.00001) {
                    if (Math.abs(oc.kyori(s_step[i].geta(), s_tem.getb()) - v_min_b) < 0.00001) {
                        a_tomo_b_tomo_mottomo_tikai_voronoi_tyouten_no_kazu = a_tomo_b_tomo_mottomo_tikai_voronoi_tyouten_no_kazu + 1;


                    }
                }
            }
            //System.out.println("a_tomo_b_tomo_mottomo_tikai_voronoi_tyouten_no_kazu= "+a_tomo_b_tomo_mottomo_tikai_voronoi_tyouten_no_kazu);

            if (a_tomo_b_tomo_mottomo_tikai_voronoi_tyouten_no_kazu != 2) {

                ori_v.select(j);
            }


        }


        //‘I‘ð?ó‘Ô‚Ì‚à‚Ì‚ð?í?œ
        ori_v.del_selected_senbun_hayai();

        ori_v.del_V_all(); //‚±‚Ì?s‚Í‚¢‚ç‚È‚¢‚©‚à


    }


//------------------------------

    public void voronoi_02_01(int tyuusinn_ten_bangou, Senbun add_senbun) {
        //i_egaki_dankai”Ô–Ú‚Ìƒ{ƒ?ƒmƒC’¸“_‚Í?@?@s_step[i_egaki_dankai].geta()?@?@?@

        //System.out.println("(0a)_add_senbun.getiactive()   = "+add_senbun.getiactive());
        //‰Á‚¦‚é?ü•ª‚É‚Â‚¢‚Ä?®—?
        //Senbun add_senbun =new Senbun();
        //add_senbun.set(oc.nitoubunsen(s_step[i_e_d].geta(),s_step[i_egaki_dankai].geta(),1000.0));
        Tyokusen add_tyokusen = new Tyokusen(add_senbun);


        int i_saisyo = Senb_boro_1p.size() - 1;
        for (int i = i_saisyo; i >= 0; i--) {
            //Šù‘¶‚Ì?ü•ª‚É‚Â‚¢‚Ä?®—?
            Senbun kizon_senbun = new Senbun();
            kizon_senbun.set((Senbun) Senb_boro_1p.get(i));
            Tyokusen kizon_tyokusen = new Tyokusen(kizon_senbun);


            //‰Á‚¦‚é?ü•ª‚ÆŠù‘¶‚Ì?ü•ª‚ð?í‚í‚¹‚é

//add_tyokusen.hyouji("     “r’†?@add_tyokusen :");
//kizon_tyokusen.hyouji("     “r’†?@kizon_tyokusen :");

            int i_heikou = oc.heikou_hantei(add_tyokusen, kizon_tyokusen, 0.0001);//0=•½?s‚Å‚È‚¢?A1=•½?s‚Å‚Q’¼?ü‚ªˆê’v‚µ‚È‚¢?A2=•½?s‚Å‚Q’¼?ü‚ªˆê’v‚·‚é


            if (i_heikou == 0) {//‰Á‚¦‚é?ü•ª‚ÆŠù‘¶‚Ì?ü•ª‚ª”ñ•½?s‚Ì?ê?‡
//System.out.println("     “r’†_‰Á‚¦‚é?ü•ª‚ÆŠù‘¶‚Ì?ü•ª‚ª”ñ•½?s");
                Ten kouten = new Ten();
                kouten.set(oc.kouten_motome(add_tyokusen, kizon_tyokusen));

                if ((add_tyokusen.onajigawa(s_step[tyuusinn_ten_bangou].geta(), kizon_senbun.geta()) <= 0) &&
                        (add_tyokusen.onajigawa(s_step[tyuusinn_ten_bangou].geta(), kizon_senbun.getb()) <= 0)) {
                    Senb_boro_1p.remove(i);
                } else if ((add_tyokusen.onajigawa(s_step[tyuusinn_ten_bangou].geta(), kizon_senbun.geta()) == 1) &&
                        (add_tyokusen.onajigawa(s_step[tyuusinn_ten_bangou].geta(), kizon_senbun.getb()) == -1)) {
                    kizon_senbun.set(kizon_senbun.geta(), kouten);
                    if (kizon_senbun.getnagasa() < 0.0000001) {
                        Senb_boro_1p.remove(i);
                    } else {
                        Senb_boro_1p.set(i, kizon_senbun);
                    }
                } else if ((add_tyokusen.onajigawa(s_step[tyuusinn_ten_bangou].geta(), kizon_senbun.geta()) == -1) &&
                        (add_tyokusen.onajigawa(s_step[tyuusinn_ten_bangou].geta(), kizon_senbun.getb()) == 1)) {
                    kizon_senbun.set(kouten, kizon_senbun.getb());
                    if (kizon_senbun.getnagasa() < 0.0000001) {
                        Senb_boro_1p.remove(i);
                    } else {
                        Senb_boro_1p.set(i, kizon_senbun);
                    }
                }

                //

                if ((kizon_tyokusen.onajigawa(s_step[tyuusinn_ten_bangou].geta(), add_senbun.geta()) <= 0) &&
                        (kizon_tyokusen.onajigawa(s_step[tyuusinn_ten_bangou].geta(), add_senbun.getb()) <= 0)) {
                    return;
                } else if ((kizon_tyokusen.onajigawa(s_step[tyuusinn_ten_bangou].geta(), add_senbun.geta()) == 1) &&
                        (kizon_tyokusen.onajigawa(s_step[tyuusinn_ten_bangou].geta(), add_senbun.getb()) == -1)) {
                    add_senbun.set(add_senbun.geta(), kouten);
                    if (add_senbun.getnagasa() < 0.0000001) {
                        return;
                    }
                } else if ((kizon_tyokusen.onajigawa(s_step[tyuusinn_ten_bangou].geta(), add_senbun.geta()) == -1) &&
                        (kizon_tyokusen.onajigawa(s_step[tyuusinn_ten_bangou].geta(), add_senbun.getb()) == 1)) {
                    add_senbun.set(kouten, add_senbun.getb());
                    if (add_senbun.getnagasa() < 0.0000001) {
                        return;
                    }
                }


            } else if (i_heikou == 1) {//‰Á‚¦‚é?ü•ª‚ÆŠù‘¶‚Ì?ü•ª‚ª•½?s‚Å‚Q’¼?ü‚ªˆê’v‚µ‚È‚¢?ê?‡
//System.out.println("     “r’†_‰Á‚¦‚é?ü•ª‚ÆŠù‘¶‚Ì?ü•ª‚ª•½?s‚Å‚Q’¼?ü‚ªˆê’v‚µ‚È‚¢");
                if (add_tyokusen.onajigawa(s_step[tyuusinn_ten_bangou].geta(), kizon_senbun.geta()) == -1) {
                    Senb_boro_1p.remove(i);
                } else if (kizon_tyokusen.onajigawa(s_step[tyuusinn_ten_bangou].geta(), add_senbun.geta()) == -1) {
                    return;
                }


            } else if (i_heikou == 2) {//‰Á‚¦‚é?ü•ª‚ÆŠù‘¶‚Ì?ü•ª‚ª•½?s‚Å‚Q’¼?ü‚ªˆê’v‚·‚é?ê?‡
//System.out.println("     “r’†_‰Á‚¦‚é?ü•ª‚ÆŠù‘¶‚Ì?ü•ª‚ª•½?s‚Å‚Q’¼?ü‚ªˆê’v‚·‚é");
                return;
            }


            //if(add_tyokusen.senbun_kousa_hantei_kuwasii(senbun_b1p)==0){
            //if(add_tyokusen.senbun_kousa_hantei_kuwasii(new Senbun(s_step[i_egaki_dankai].geta(),senbun_b1p.geta()))==1){
            //	Senb_boro_1p.remove(i);
            //}
            //}


        }
        //System.out.println("  i_e_d="+i_e_d);
        //add_senbun.hyouji("voronoi_02_01_  add_senbun _?Å?I");
        //System.out.println("(0b)_add_senbun.getiactive()   = "+add_senbun.getiactive());
        Senb_boro_1p.add(add_senbun);


    }


    // -----------------------------------------------

    public void Senb_boro_1p_motome(int tyuusinn_ten_bangou) {//s_step‚ªƒ{ƒ?ƒmƒC•ê“_‚¾‚¯‚ðŠÜ‚Þ?ê?‡‚ÉŽg‚¦‚é?Btyuusinn_ten_bangou‚ÌŽü‚è‚Ìƒ{ƒ?ƒmƒC?ü•ª‚Ì?W?‡‚Æ‚µ‚ÄSenb_boro_1p‚ð“¾‚é
        //i_egaki_dankai”Ô–Ú‚Ìƒ{ƒ?ƒmƒC’¸“_‚ðŽæ‚èˆÍ‚Þƒ{ƒ?ƒmƒC?ü•ª‚ÌƒAƒŒƒCƒŠƒXƒg‚ð“¾‚é?B//i_egaki_dankai”Ô–Ú‚Ìƒ{ƒ?ƒmƒC’¸“_‚Í?@?@s_step[i_egaki_dankai].geta()?@?@?@
        Senb_boro_1p.clear();

        //System.out.println("i_egaki_dankai="+i_egaki_dankai);

        for (int i_e_d = 1; i_e_d <= i_egaki_dankai; i_e_d++) {
            if (i_e_d != tyuusinn_ten_bangou) {

                //‰Á‚¦‚é?ü•ª‚ð‹?‚ß‚é
                Senbun add_senbun = new Senbun();

                add_senbun.set(oc.nitoubunsen(s_step[i_e_d].geta(), s_step[tyuusinn_ten_bangou].geta(), 1000.0));

                if (i_e_d < tyuusinn_ten_bangou) {
                    add_senbun.setiactive(i_e_d);
                    add_senbun.setcolor(tyuusinn_ten_bangou);//ƒ{ƒ?ƒmƒC?ü•ª‚Ì2‚Â‚Ìƒ{ƒ?ƒmƒC’¸“_‚Íiactive‚Æcolor‚É‹L˜^‚·‚é
                } else {
                    add_senbun.setiactive(tyuusinn_ten_bangou);
                    add_senbun.setcolor(i_e_d);//ƒ{ƒ?ƒmƒC?ü•ª‚Ì2‚Â‚Ìƒ{ƒ?ƒmƒC’¸“_‚Íiactive‚Æcolor‚É‹L˜^‚·‚é
                }
                voronoi_02_01(tyuusinn_ten_bangou, add_senbun);

            }
        }


/*
		//‚Å‚«‚½Senb_boro_1p‚Ì•\Ž¦
		oc.hyouji("-----‚Å‚«‚½Senb_boro_1p‚Ì•\Ž¦-----");
		for (int i=0; i<Senb_boro_1p.size(); i++ ){
			Senbun tempS=new Senbun();tempS.set((Senbun)Senb_boro_1p.get(i));
			tempS.hyouji("   ");
		}
*/


    }

    // --------------------------------------------

    public void voronoi_02() {//i=1‚©‚çi_egaki_dankai‚Ü‚Å‚Ìs_step[i]‚Æ?Ai_egaki_dankai-1‚Ü‚Å‚Ìƒ{ƒ?ƒmƒC?}‚©‚çi_egaki_dankai‚Ìƒ{ƒ?ƒmƒC?}‚ð?ì?¬

        //i_egaki_dankai”Ô–Ú‚Ìƒ{ƒ?ƒmƒC’¸“_‚ðŽæ‚èˆÍ‚Þƒ{ƒ?ƒmƒC?ü•ª‚ÌƒAƒŒƒCƒŠƒXƒg‚ð“¾‚é?B
        Senb_boro_1p_motome(i_egaki_dankai);

        //20181109‚±‚±‚Åori_v.‚ÌŠù‘¶‚Ìƒ{ƒ?ƒmƒC?ü•ª‚Ì?®—?‚ª•K—v

        //ori_v‚Ì?ü•ª‚ð?Å?‰‚É‘S‚Ä”ñ‘I‘ð‚É‚·‚é
        ori_v.unselect_all();

        //
        Senbun s_mae = new Senbun();
        Senbun s_ato = new Senbun();

        for (int ia = 0; ia < Senb_boro_1p.size() - 1; ia++) {
            for (int ib = ia + 1; ib < Senb_boro_1p.size(); ib++) {

                s_mae.set((Senbun) Senb_boro_1p.get(ia));
                s_ato.set((Senbun) Senb_boro_1p.get(ib));

                Tyokusen t_mae = new Tyokusen(s_mae);
                Tyokusen t_ato = new Tyokusen(s_ato);

                int i_mae = s_mae.getiactive();//‚±‚Ì?ê?‡iactive‚É‚Í?A‚»‚Ìƒ{ƒ?ƒmƒC?ü•ª‚ð‰Á‚¦‚½‚Æ‚«‚ÌŠù‘¶‘¤‚Ìƒ{ƒ?ƒmƒC•ê“_‚Ì”Ô?†‚ª“ü‚Á‚Ä‚¢‚é?B
                int i_ato = s_ato.getiactive();//‚±‚Ì?ê?‡iactive‚É‚Í?A‚»‚Ìƒ{ƒ?ƒmƒC?ü•ª‚ð‰Á‚¦‚½‚Æ‚«‚ÌŠù‘¶‘¤‚Ìƒ{ƒ?ƒmƒC•ê“_‚Ì”Ô?†‚ª“ü‚Á‚Ä‚¢‚é?B


                if (i_mae > i_ato) {
                    int i_temp = i_mae;
                    i_mae = i_ato;
                    i_ato = i_temp;
                }

                //System.out.println("(1) i_mae=" +i_mae +" :  i_ato=" +i_ato);

                //?V‚µ‚¢ƒ{ƒ?ƒmƒC•ê“_‚ð‰Á‚¦‚é‚±‚Æ‚Å‚Å‚«‚éŽüˆÍ‚Ìƒ{ƒ?ƒmƒC?ü•ª‚ª‹?‚Ü‚Á‚Ä‚¢‚é?B‚±‚Ìƒ{ƒ?ƒmƒC?ü•ª‚Ì‘½ŠpŒ`‚ð?VƒZƒ‹‚Æ‚¢‚¤‚±‚Æ‚É‚·‚é?B
                //?VƒZƒ‹‚ðori_v‚É‰Á‚¦‚é‘O‚É?A?VƒZƒ‹‚Ì“à•”‚É“ü‚è?ž‚ñ‚Å‚¢‚éori_v‚ÌŠù‘¶?ü•ª‚ª‚È‚¢‚æ‚¤‚É?ˆ—?‚ð‚·‚é?B

                //20181109‚±‚±‚Åori_v.‚ÌŠù‘¶‚Ìƒ{ƒ?ƒmƒC?ü•ª(iactive()‚ª•K‚¸icolor‚æ‚è?¬‚³‚­‚È‚Á‚Ä‚¢‚é)‚ð’T‚·
                for (int j = 1; j <= ori_v.getsousuu(); j++) {
                    Senbun s_kizon = new Senbun();
                    s_kizon.set(ori_v.get(j));
                    //System.out.println("  (2) s_kizon.getiactive()=" +s_kizon.getiactive() +" :  s_kizon.getcolor()=" +s_kizon.getcolor());

                    int i_kizon_syou = s_kizon.getiactive();
                    int i_kizon_dai = s_kizon.getcolor();

                    if (i_kizon_syou > i_kizon_dai) {
                        i_kizon_dai = s_kizon.getiactive();
                        i_kizon_syou = s_kizon.getcolor();
                    }


                    if (i_kizon_syou == i_mae) {
                        if (i_kizon_dai == i_ato) {
                            //System.out.println("i_mae=" +i_mae +" :  i_ato=" +i_ato);

                            //System.out.println("ori_v.get(j)_  j=" +j);


//20181110‚±‚±ƒ|ƒCƒ“ƒg
//
//	-1		0		1
//-1 	‰½‚à‚¹‚¸	‰½‚à‚¹‚¸	Œð“_‚Ü‚Å?k?¬
// 0	‰½‚à‚¹‚¸	—L‚è“¾‚È‚¢	?í?œ
// 1	Œð“_‚Ü‚Å?k?¬	?í?œ		?í?œ
//

                            //  if((ia+1==ib)||((ia==0)&&(ib==Senb_boro_1p.size()-1))){

                            Ten kouten = new Ten();
                            kouten.set(oc.kouten_motome(s_mae, s_kizon));

                            //System.out.println("kouten=" +kouten.getx()+" : "+kouten.gety());


                            if ((t_mae.onajigawa(s_step[i_egaki_dankai].geta(), s_kizon.geta()) >= 0) &&
                                    (t_mae.onajigawa(s_step[i_egaki_dankai].geta(), s_kizon.getb()) >= 0)) {
                                ori_v.select(j);
                            }

                            if ((t_mae.onajigawa(s_step[i_egaki_dankai].geta(), s_kizon.geta()) == -1) &&
                                    (t_mae.onajigawa(s_step[i_egaki_dankai].geta(), s_kizon.getb()) == 1)) {
                                //s_kizon.set(s_kizon.geta(),kouten);
                                ori_v.set(j, s_kizon.geta(), kouten);
                            }

                            if ((t_mae.onajigawa(s_step[i_egaki_dankai].geta(), s_kizon.geta()) == 1) &&
                                    (t_mae.onajigawa(s_step[i_egaki_dankai].geta(), s_kizon.getb()) == -1)) {
                                //s_kizon.set(kouten,s_kizon.getb());
                                ori_v.set(j, kouten, s_kizon.getb());
                            }

                            //  }else{
                            //		ori_v.select(j)	;
                            // }
                        }


                    }

                }


            }

        }

        //for (int i=1; i<=ori_v.getsousuu(); i++ ){System.out.println("    (1)  i= " + i +  ":  ori_v.get(i).getiactive()=  " +  ori_v.get(i).getiactive());}
        //‘I‘ð?ó‘Ô‚Ì‚à‚Ì‚ð?í?œ
        ori_v.del_selected_senbun_hayai();

        ori_v.del_V_all(); //‚±‚Ì?s‚Í‚¢‚ç‚È‚¢‚©‚à
        //for (int i=1; i<=ori_v.getsousuu(); i++ ){System.out.println("    (2)  i= " + i +  ":  ori_v.get(i).getiactive()=  " +  ori_v.get(i).getiactive());}
        //


        //ori_v‚Ìsenbun‚Ì?ÅŒã‚ÉSenb_boro_1p‚Ì?ü•ª‚ð‚ð‚ð‰Á‚¦‚é
        for (int i = 0; i < Senb_boro_1p.size(); i++) {
            Senbun add_S = new Senbun();
            add_S.set((Senbun) Senb_boro_1p.get(i));
            //System.out.println("  add_S.getiactive()=" +add_S.getiactive());
            ori_v.addsenbun((Senbun) Senb_boro_1p.get(i));
            //System.out.println("  ori_v.get(ori_v.getsousuu()).getiactive()=" +ori_v.get(ori_v.getsousuu()).getiactive());

        }


        //for (int i=1; i<=ori_v.getsousuu(); i++ ){System.out.println("    (3)  i= " + i +  ":  ori_v.get(i).getiactive()=  " +  ori_v.get(i).getiactive());}


    }


    //-----------------------------------------------62‚±‚±‚Ü‚Å?@//20181121?@iactive‚ðtpp‚É’u‚«Š·‚¦‚é


//5555555555555555555555    i_mouse_modeA==5?@;?ü•ª‰„’·ƒ‚?[ƒh

    //ƒ}ƒEƒX‘€?ì(ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”    //System.out.println("_");
    public void mMoved_A_05(Ten p0) {
        if (i_kou_mitudo_nyuuryoku == 10) {// ==10‚Æ‚¢‚¤‚±‚Æ‚ÍŽÀ?s‚µ‚È‚¢‚Æ‚¢‚¤‚±‚Æ
            s_kouho[1].setiactive(3);

            i_kouho_dankai = 0;
            //Ten p =new Ten();
            p.set(camera.TV2object(p0));

            moyori_senbun.set(get_moyori_senbun(p));
            if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {//?ÅŠñ‚ÌŠù‘¶?Ü?ü‚ª‹ß‚¢?ê?‡
                i_kouho_dankai = 1;
                s_kouho[1].set(moyori_senbun);
                //s_kouho[1].setcolor(8);

                return;
            }


        }
    }


    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ
    public void mPressed_A_05(Ten p0) {
        i_kouho_dankai = 0;
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        moyori_senbun.set(get_moyori_senbun(p));
        if (i_egaki_dankai == 0) {
            if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_senbun);//s_step[i_egaki_dankai].setcolor(i_egaki_dankai);
                icol_temp = s_step[i_egaki_dankai].getcolor();
                s_step[i_egaki_dankai].setcolor(6);
                return;
            }
        }

        if (i_egaki_dankai == 1) {

            if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {

                if ((oc.heikou_hantei(s_step[1], moyori_senbun, 0.000001) == 0) ||  //‚Q‚Â‚Ì?ü•ª‚ª•½?s‚©‚Ç‚¤‚©‚ð”»’è‚·‚éŠÖ?”?Boc.heikou_hantei(Tyokusen t1,Tyokusen t2)//0=•½?s‚Å‚È‚¢
                        ((oc.senbun_kousa_hantei(s_step[1], moyori_senbun, 0.000001, 0.000001) == 31) && (i_orikaesi == 1))) {  //?Å?‰‚É‘I‚ñ‚¾?ü•ª‚Æ2”Ô–Ú‚É‘I‚ñ‚¾?ü•ª‚ª“¯‚¶‚È‚çoc.senbun_kousa_hantei==31
                    i_egaki_dankai = i_egaki_dankai + 1;
                    s_step[i_egaki_dankai].set(moyori_senbun);//s_step[i_egaki_dankai].setcolor(i_egaki_dankai);
                    s_step[i_egaki_dankai].setcolor(6);
                    return;
                }
            }
        }

    }


    //ƒ}ƒEƒX‘€?ì(ƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mDragged_A_05(Ten p0) {
    }

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mReleased_A_05(Ten p0) {
        if (i_egaki_dankai == 2) {

            i_egaki_dankai = 0;

            Senbun add_sen = new Senbun();

            if (oc.heikou_hantei(s_step[1], moyori_senbun, 0.000001) == 0) { //‚Q‚Â‚Ì?ü•ª‚ª•½?s‚©‚Ç‚¤‚©‚ð”»’è‚·‚éŠÖ?”?Boc.heikou_hantei(Tyokusen t1,Tyokusen t2)//0=•½?s‚Å‚È‚¢
                //s_step[1]‚Æs_step[2]‚ÌŒð“_‚Íoc.kouten_motome(Senbun s1,Senbun s2)‚Å‹?‚ß‚é//‚Q‚Â‚Ì?ü•ª‚ð’¼?ü‚Æ‚Ý‚È‚µ‚ÄŒð“_‚ð‹?‚ß‚éŠÖ?”?B?ü•ª‚Æ‚µ‚Ä‚ÍŒð?·‚µ‚È‚­‚Ä‚à?A’¼?ü‚Æ‚µ‚ÄŒð?·‚µ‚Ä‚¢‚é?ê?‡‚ÌŒð“_‚ð•Ô‚·
                Ten kousa_ten = new Ten();
                kousa_ten.set(oc.kouten_motome(s_step[1], s_step[2]));
                //Senbun.get_tikai_hasi(Ten p){//“_P‚Æ‹ß‚¢‚Ù‚¤‚Ì’[“_‚ð•Ô‚·
                //s_step[1].get_tikai_hasi(kousa_ten);

                add_sen = new Senbun(kousa_ten, s_step[1].get_tikai_hasi(kousa_ten));
            }

            if ((oc.senbun_kousa_hantei(s_step[1], moyori_senbun, 0.000001, 0.000001) == 31) && (i_orikaesi == 1)) {  //?Å?‰‚É‘I‚ñ‚¾?ü•ª‚Æ2”Ô–Ú‚É‘I‚ñ‚¾?ü•ª‚ª“¯‚¶‚È‚çoc.senbun_kousa_hantei==31
                //Ten p =new Ten();
                p.set(camera.TV2object(p0));
                if (p.kyori(s_step[1].geta()) < p.kyori(s_step[1].getb())) {
                    s_step[1].a_b_koukan();
                }


                add_sen.set(kousatenmade_2(s_step[1]));


            }


            if (add_sen.getnagasa() > 0.00000001) {
                add_sen.setcolor(icol);
                if (i_orikaesi == 1) {
                    add_sen.setcolor(icol_temp);
                }
                addsenbun(add_sen);
                kiroku();
            }
        }
    }

//------


//7777777777777777777    i_mouse_modeA==7;Šp“ñ“™•ª?üƒ‚?[ƒh?@

    //ƒ}ƒEƒX‘€?ì(ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mMoved_A_07(Ten p0) {
        if ((i_egaki_dankai >= 0) && (i_egaki_dankai <= 2)) {
            mMoved_A_29(p0);//‹ß‚¢Šù‘¶“_‚Ì‚Ý•\Ž¦
        }

    }

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ
    public void mPressed_A_07(Ten p0) {


        Ten p = new Ten();
        p.set(camera.TV2object(p0));

        if ((i_egaki_dankai >= 0) && (i_egaki_dankai <= 2)) {
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(icol);
                return;
            }
        }

        if (i_egaki_dankai == 3) {
            moyori_senbun.set(get_moyori_senbun(p));
            if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_senbun);//s_step[i_egaki_dankai].setcolor(i_egaki_dankai);
                s_step[i_egaki_dankai].setcolor(6);
                return;
            }
        }
        return;

    }

    //ƒ}ƒEƒX‘€?ì(ƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mDragged_A_07(Ten p0) {
    }

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mReleased_A_07(Ten p0) {
        if (i_egaki_dankai == 4) {
            i_egaki_dankai = 0;

            i_egaki_dankai = 0;

            //ŽOŠpŒ`‚Ì“à?S‚ð‹?‚ß‚é	public Ten oc.naisin(Ten ta,Ten tb,Ten tc)
            Ten naisin = new Ten();
            naisin.set(oc.naisin(s_step[1].geta(), s_step[2].geta(), s_step[3].geta()));


            Senbun add_sen2 = new Senbun(s_step[2].geta(), naisin);


            //add_sen2‚Æs_step[4]‚ÌŒð“_‚Íoc.kouten_motome(Senbun s1,Senbun s2)‚Å‹?‚ß‚é//‚Q‚Â‚Ì?ü•ª‚ð’¼?ü‚Æ‚Ý‚È‚µ‚ÄŒð“_‚ð‹?‚ß‚éŠÖ?”?B?ü•ª‚Æ‚µ‚Ä‚ÍŒð?·‚µ‚È‚­‚Ä‚à?A’¼?ü‚Æ‚µ‚ÄŒð?·‚µ‚Ä‚¢‚é?ê?‡‚ÌŒð“_‚ð•Ô‚·
            Ten kousa_ten = new Ten();
            kousa_ten.set(oc.kouten_motome(add_sen2, s_step[4]));

            Senbun add_sen = new Senbun(kousa_ten, s_step[2].geta(), icol);
            if (add_sen.getnagasa() > 0.00000001) {
                addsenbun(add_sen);
                kiroku();
            }


        }


    }

//------


//88888888888888888888888    i_mouse_modeA==8?@;“à?Sƒ‚?[ƒh?B

    //ƒ}ƒEƒX‘€?ì(ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mMoved_A_08(Ten p0) {
        mMoved_A_29(p0);
    }//‹ß‚¢Šù‘¶“_‚Ì‚Ý•\Ž¦

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ
    public void mPressed_A_08(Ten p0) {


        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        moyori_ten.set(get_moyori_ten(p));
        if (p.kyori(moyori_ten) < d_hantei_haba) {
            i_egaki_dankai = i_egaki_dankai + 1;
            s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
            s_step[i_egaki_dankai].setcolor(icol);
        }


    }

    //ƒ}ƒEƒX‘€?ì(ƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mDragged_A_08(Ten p0) {
    }

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mReleased_A_08(Ten p0) {
        if (i_egaki_dankai == 3) {
            i_egaki_dankai = 0;

            //ŽOŠpŒ`‚Ì“à?S‚ð‹?‚ß‚é	public Ten oc.naisin(Ten ta,Ten tb,Ten tc)
            Ten naisin = new Ten();
            naisin.set(oc.naisin(s_step[1].geta(), s_step[2].geta(), s_step[3].geta()));

            Senbun add_sen1 = new Senbun(s_step[1].geta(), naisin, icol);
            if (add_sen1.getnagasa() > 0.00000001) {
                addsenbun(add_sen1);
            }
            Senbun add_sen2 = new Senbun(s_step[2].geta(), naisin, icol);
            if (add_sen2.getnagasa() > 0.00000001) {
                addsenbun(add_sen2);
            }
            Senbun add_sen3 = new Senbun(s_step[3].geta(), naisin, icol);
            if (add_sen3.getnagasa() > 0.00000001) {
                addsenbun(add_sen3);
            }
            kiroku();
        }


    }

    //------
    public double get_L1() {
        return sokutei_nagasa_1;
    }

    public double get_L2() {
        return sokutei_nagasa_2;
    }

    public double get_A1() {
        return sokutei_kakudo_1;
    }

    public double get_A2() {
        return sokutei_kakudo_2;
    }

    public double get_A3() {
        return sokutei_kakudo_3;
    }


    //53 53 53 53 53 53 53 53 53    i_mouse_modeA==53?@;’·‚³‘ª’è‚Pƒ‚?[ƒh?B
    //ƒ}ƒEƒX‘€?ì(ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mMoved_A_53(Ten p0) {
        mMoved_A_29(p0);
    }//‹ß‚¢Šù‘¶“_‚Ì‚Ý•\Ž¦

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ
    public void mPressed_A_53(Ten p0) {
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        moyori_ten.set(get_moyori_ten(p));
        if (p.kyori(moyori_ten) < d_hantei_haba) {
            i_egaki_dankai = i_egaki_dankai + 1;
            s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
            s_step[i_egaki_dankai].setcolor(icol);
        }
    }

    //ƒ}ƒEƒX‘€?ì(ƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mDragged_A_53(Ten p0) {
    }

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mReleased_A_53(Ten p0) {
        if (i_egaki_dankai == 2) {
            i_egaki_dankai = 0;
            sokutei_nagasa_1 = oc.kyori(s_step[1].geta(), s_step[2].geta()) * (double) kus.bunsuu() / 400.0;

            orihime_ap.sokutei_nagasa_1_hyouji(sokutei_nagasa_1);
            //kiroku();
        }


    }

//------


    //------
//54 54 54 54 54 54 54 54 54    i_mouse_modeA==54?@;’·‚³‘ª’è2ƒ‚?[ƒh?B
    //ƒ}ƒEƒX‘€?ì(ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mMoved_A_54(Ten p0) {
        mMoved_A_29(p0);
    }//‹ß‚¢Šù‘¶“_‚Ì‚Ý•\Ž¦

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ
    public void mPressed_A_54(Ten p0) {
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        moyori_ten.set(get_moyori_ten(p));
        if (p.kyori(moyori_ten) < d_hantei_haba) {
            i_egaki_dankai = i_egaki_dankai + 1;
            s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
            s_step[i_egaki_dankai].setcolor(icol);
        }
    }

    //ƒ}ƒEƒX‘€?ì(ƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mDragged_A_54(Ten p0) {
    }

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mReleased_A_54(Ten p0) {
        if (i_egaki_dankai == 2) {
            i_egaki_dankai = 0;
            sokutei_nagasa_2 = oc.kyori(s_step[1].geta(), s_step[2].geta()) * (double) kus.bunsuu() / 400.0;

            orihime_ap.sokutei_nagasa_2_hyouji(sokutei_nagasa_2);
            //kiroku();
        }


    }

//------


    //------
//55 55 55 55 55 55 55 55 55    i_mouse_modeA==55?@;Šp“x‘ª’è1ƒ‚?[ƒh?B
    //ƒ}ƒEƒX‘€?ì(ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mMoved_A_55(Ten p0) {
        mMoved_A_29(p0);
    }//‹ß‚¢Šù‘¶“_‚Ì‚Ý•\Ž¦

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ
    public void mPressed_A_55(Ten p0) {
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        moyori_ten.set(get_moyori_ten(p));
        if (p.kyori(moyori_ten) < d_hantei_haba) {
            i_egaki_dankai = i_egaki_dankai + 1;
            s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
            s_step[i_egaki_dankai].setcolor(icol);
        }
    }

    //ƒ}ƒEƒX‘€?ì(ƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mDragged_A_55(Ten p0) {
    }

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mReleased_A_55(Ten p0) {
        if (i_egaki_dankai == 3) {
            i_egaki_dankai = 0;
            sokutei_kakudo_1 = oc.kakudo(s_step[2].geta(), s_step[3].geta(), s_step[2].geta(), s_step[1].geta());
            if (sokutei_kakudo_1 > 180.0) {
                sokutei_kakudo_1 = sokutei_kakudo_1 - 360.0;
            }

            orihime_ap.sokutei_kakudo_1_hyouji(sokutei_kakudo_1);
            //kiroku();
        }
    }
//------


    //------
//56 56 56 56 56 56 56 56 56    i_mouse_modeA==56?@;Šp“x‘ª’è2ƒ‚?[ƒh?B
    //ƒ}ƒEƒX‘€?ì(ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mMoved_A_56(Ten p0) {
        mMoved_A_29(p0);
    }//‹ß‚¢Šù‘¶“_‚Ì‚Ý•\Ž¦

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ
    public void mPressed_A_56(Ten p0) {
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        moyori_ten.set(get_moyori_ten(p));
        if (p.kyori(moyori_ten) < d_hantei_haba) {
            i_egaki_dankai = i_egaki_dankai + 1;
            s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
            s_step[i_egaki_dankai].setcolor(icol);
        }
    }

    //ƒ}ƒEƒX‘€?ì(ƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mDragged_A_56(Ten p0) {
    }

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mReleased_A_56(Ten p0) {
        if (i_egaki_dankai == 3) {
            i_egaki_dankai = 0;
            sokutei_kakudo_2 = oc.kakudo(s_step[2].geta(), s_step[3].geta(), s_step[2].geta(), s_step[1].geta());
            if (sokutei_kakudo_2 > 180.0) {
                sokutei_kakudo_2 = sokutei_kakudo_2 - 360.0;
            }
            orihime_ap.sokutei_kakudo_2_hyouji(sokutei_kakudo_2);
            //kiroku();
        }
    }
//------

    //------
//57 57 57 57 57 57 57 57 57    i_mouse_modeA==57?@;Šp“x‘ª’è3ƒ‚?[ƒh?B
    //ƒ}ƒEƒX‘€?ì(ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mMoved_A_57(Ten p0) {
        mMoved_A_29(p0);
    }//‹ß‚¢Šù‘¶“_‚Ì‚Ý•\Ž¦

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ
    public void mPressed_A_57(Ten p0) {
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        moyori_ten.set(get_moyori_ten(p));
        if (p.kyori(moyori_ten) < d_hantei_haba) {
            i_egaki_dankai = i_egaki_dankai + 1;
            s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
            s_step[i_egaki_dankai].setcolor(icol);
        }
    }

    //ƒ}ƒEƒX‘€?ì(ƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mDragged_A_57(Ten p0) {
    }

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mReleased_A_57(Ten p0) {
        if (i_egaki_dankai == 3) {
            i_egaki_dankai = 0;
            sokutei_kakudo_3 = oc.kakudo(s_step[2].geta(), s_step[3].geta(), s_step[2].geta(), s_step[1].geta());
            if (sokutei_kakudo_3 > 180.0) {
                sokutei_kakudo_3 = sokutei_kakudo_3 - 360.0;
            }
            orihime_ap.sokutei_kakudo_3_hyouji(sokutei_kakudo_3);
            //kiroku();
        }
    }
//------


//999999999999999999    i_mouse_modeA==9?@;?‚?ü‚¨‚ë‚µƒ‚?[ƒh

    //ƒ}ƒEƒX‘€?ì(ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mMoved_A_09(Ten p0) {
        if (i_egaki_dankai == 0) {
            mMoved_A_29(p0);//‹ß‚¢Šù‘¶“_‚Ì‚Ý•\Ž¦
        }

    }


    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ
    public void mPressed_A_09(Ten p0) {


        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        if (i_egaki_dankai == 0) {
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(icol);
                return;
            }
        }

        if (i_egaki_dankai == 1) {
            moyori_senbun.set(get_moyori_senbun(p));
            if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_senbun);
                s_step[i_egaki_dankai].setcolor(6);
                return;
            }
            i_egaki_dankai = 0;
            return;


        }
        return;

    }

    //ƒ}ƒEƒX‘€?ì(ƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mDragged_A_09(Ten p0) {
    }

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mReleased_A_09(Ten p0) {
        if (i_egaki_dankai == 2) {
            i_egaki_dankai = 0;
            //’¼?üt?ã‚Ì“_p‚Ì‰e‚ÌˆÊ’u?i“_p‚Æ?Å‚à‹ß‚¢’¼?üt?ã‚ÌˆÊ’u?j‚ð‹?‚ß‚é?Bpublic Ten oc.kage_motome(Tyokusen t,Ten p){
            //oc.Senbun2Tyokusen(Senbun s)//?ü•ª‚ðŠÜ‚Þ’¼?ü‚ð“¾‚é

            Senbun add_sen = new Senbun(s_step[1].geta(), oc.kage_motome(oc.Senbun2Tyokusen(s_step[2]), s_step[1].geta()), icol);
            if (add_sen.getnagasa() > 0.00000001) {
                addsenbun(add_sen);
                kiroku();
            }


        }
    }
//------
//------
//40 40 40 40 40 40     i_mouse_modeA==40?@;•½?s?ü“ü—Íƒ‚?[ƒh

    //ƒ}ƒEƒX‘€?ì(ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mMoved_A_40(Ten p0) {
        if (i_egaki_dankai == 0) {
            mMoved_A_29(p0);//‹ß‚¢Šù‘¶“_‚Ì‚Ý•\Ž¦
        }

    }


    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ
    public void mPressed_A_40(Ten p0) {


        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        if (i_egaki_dankai == 0) {
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(icol);
                return;
            }
        }

        if (i_egaki_dankai == 1) {
            moyori_senbun.set(get_moyori_senbun(p));
            if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_senbun);//s_step[i_egaki_dankai].setcolor(i_egaki_dankai);
                s_step[i_egaki_dankai].setcolor(6);
                return;
            }
            //i_egaki_dankai=0;
            return;
        }


        if (i_egaki_dankai == 2) {
            moyori_senbun.set(get_moyori_senbun(p));
            if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_senbun);//s_step[i_egaki_dankai].setcolor(i_egaki_dankai);
                s_step[i_egaki_dankai].setcolor(6);
                return;
            }
            //i_egaki_dankai=0;
            return;
        }


        return;

    }

    //ƒ}ƒEƒX‘€?ì(ƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mDragged_A_40(Ten p0) {
    }

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mReleased_A_40(Ten p0) {
        if (i_egaki_dankai == 3) {
            i_egaki_dankai = 0;
            //s_step[1]‚ð“_?ó‚©‚ç?As_step[2]‚É•½?s‚È?ü•ª‚É‚·‚é?B
            s_step[1].setb(new Ten(s_step[1].getax() + s_step[2].getbx() - s_step[2].getax(), s_step[1].getay() + s_step[2].getby() - s_step[2].getay()));


            //Ten kousa_ten =new Ten(); kousa_ten.set(oc.kouten_motome(s_step[1],s_step[3]));

            //Senbun add_sen =new Senbun(kousa_ten,s_step[1].geta(),icol);

            if (s_step_tuika_koutenmade(3, s_step[1], s_step[3], icol) > 0) {
                addsenbun(s_step[4]);
                kiroku();
                i_egaki_dankai = 0;
                return;
            }


            //if(add_sen.getnagasa()>0.00000001){
            //	addsenbun(add_sen);
            //	kiroku();
            //	i_egaki_dankai=0;
            //	return;
            //}
        }
    }

    //------
    //i_egaki_dankai‚ªi_e_d‚Ì‚Æ‚«‚É?A?ü•ªs_o‚ðTen a‚Í‚»‚Ì‚Ü‚Ü‚Å?ATen b‘¤‚ðs_k‚ÌŒð“_‚Ü‚Å‚Ì‚Î‚µ‚½ˆêŽž?Ü?üs_step[i_e_d+1](?F‚Íicolo)‚ð’Ç‰Á?B?¬Œ÷‚µ‚½?ê?‡‚Í1?A‚È‚ñ‚ç‚©‚Ì•s“s?‡‚Å’Ç‰Á‚Å‚«‚È‚©‚Á‚½?ê?‡‚Í-500‚ð•Ô‚·?B
    public int s_step_tuika_koutenmade(int i_e_d, Senbun s_o, Senbun s_k, int icolo) {

        Ten kousa_ten = new Ten();

        if (oc.heikou_hantei(s_o, s_k, 0.0000001) == 1) {//0=•½?s‚Å‚È‚¢?A1=•½?s‚Å‚Q’¼?ü‚ªˆê’v‚µ‚È‚¢?A2=•½?s‚Å‚Q’¼?ü‚ªˆê’v‚·‚é
            return -500;
        }

        if (oc.heikou_hantei(s_o, s_k, 0.0000001) == 2) {//0=•½?s‚Å‚È‚¢?A1=•½?s‚Å‚Q’¼?ü‚ªˆê’v‚µ‚È‚¢?A2=•½?s‚Å‚Q’¼?ü‚ªˆê’v‚·‚é
            kousa_ten.set(s_k.geta());
            if (oc.kyori(s_o.geta(), s_k.geta()) > oc.kyori(s_o.geta(), s_k.getb())) {
                kousa_ten.set(s_k.getb());
            }


        }

        if (oc.heikou_hantei(s_o, s_k, 0.0000001) == 0) {//0=•½?s‚Å‚È‚¢?A1=•½?s‚Å‚Q’¼?ü‚ªˆê’v‚µ‚È‚¢?A2=•½?s‚Å‚Q’¼?ü‚ªˆê’v‚·‚é
            kousa_ten.set(oc.kouten_motome(s_o, s_k));
        }


        Senbun add_sen = new Senbun(kousa_ten, s_o.geta(), icolo);

        if (add_sen.getnagasa() > 0.00000001) {
            s_step[i_e_d + 1].set(add_sen);
            return 1;
        }
        return -500;
    }


//10 10 10 10 10    i_mouse_modeA==10?@;?Ü‚è•Ô‚µƒ‚?[ƒh

    //ƒ}ƒEƒX‘€?ì(ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mMoved_A_10(Ten p0) {
        mMoved_A_29(p0);
    }//‹ß‚¢Šù‘¶“_‚Ì‚Ý•\Ž¦

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ
    public void mPressed_A_10(Ten p0) {

        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        moyori_ten.set(get_moyori_ten(p));
        if (p.kyori(moyori_ten) < d_hantei_haba) {
            i_egaki_dankai = i_egaki_dankai + 1;
            s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
            s_step[i_egaki_dankai].setcolor(icol);
        }
    }

    //ƒ}ƒEƒX‘€?ì(ƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mDragged_A_10(Ten p0) {
    }

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mReleased_A_10(Ten p0) {
        if (i_egaki_dankai == 3) {
            i_egaki_dankai = 0;

            //‚Q‚Â‚Ì“_t1,t2‚ð’Ê‚é’¼?ü‚ÉŠÖ‚µ‚Ä?A“_p‚Ì‘Î?ÆˆÊ’u‚É‚ ‚é“_‚ð‹?‚ß‚é public Ten oc.sentaisyou_ten_motome(Ten t1,Ten t2,Ten p){
            Ten t_taisyou = new Ten();
            t_taisyou.set(oc.sentaisyou_ten_motome(s_step[2].geta(), s_step[3].geta(), s_step[1].geta()));

            Senbun add_sen = new Senbun(s_step[2].geta(), t_taisyou);

            add_sen.set(kousatenmade(add_sen));
            add_sen.setcolor(icol);
            if (add_sen.getnagasa() > 0.00000001) {
                addsenbun(add_sen);
                kiroku();
            }
        }
    }


//52 52 52 52 52    i_mouse_modeA==52?@;˜A‘±?Ü‚è•Ô‚µƒ‚?[ƒh ****************************************

    //ƒ}ƒEƒX‘€?ì(ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mMoved_A_52(Ten p0) {
        mMoved_A_29(p0);
    }//‹ß‚¢Šù‘¶“_‚Ì‚Ý•\Ž¦

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ
    public void mPressed_A_52(Ten p0) {
        System.out.println("i_egaki_dankai=" + i_egaki_dankai);
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        moyori_ten.set(get_moyori_ten(p));

        i_egaki_dankai = i_egaki_dankai + 1;
        if (p.kyori(moyori_ten) < d_hantei_haba) {
            s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
            s_step[i_egaki_dankai].setcolor(icol);
        } else {
            s_step[i_egaki_dankai].set(p, p);
            s_step[i_egaki_dankai].setcolor(icol);
        }


        System.out.println("i_egaki_dankai=" + i_egaki_dankai);
    }

    //ƒ}ƒEƒX‘€?ì(ƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mDragged_A_52(Ten p0) {
    }

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mReleased_A_52(Ten p0) {
        if (i_egaki_dankai == 2) {
            i_egaki_dankai = 0;

            //‚Q‚Â‚Ì“_t1,t2‚ð’Ê‚é’¼?ü‚ÉŠÖ‚µ‚Ä?A“_p‚Ì‘Î?ÆˆÊ’u‚É‚ ‚é“_‚ð‹?‚ß‚é public Ten oc.sentaisyou_ten_motome(Ten t1,Ten t2,Ten p){
            Ten t_taisyou = new Ten();
            t_taisyou.set(oc.sentaisyou_ten_motome(s_step[2].geta(), s_step[3].geta(), s_step[1].geta()));
            Senbun add_senbun = new Senbun();
            renzoku_orikaesi(s_step[1].geta(), s_step[2].geta());
            for (int i = 1; i <= i_egaki_dankai; i++) {

                if (s_step[i].getnagasa() > 0.00000001) {

                    add_senbun.set(s_step[i].geta(), s_step[i].getb());//—v’?ˆÓ?@s_step‚Í•\Ž¦?ã‚Ì“s?‡‚ÅƒAƒNƒeƒBƒ”‚ª0ˆÈŠO‚É?Ý’è‚³‚ê‚Ä‚¢‚é‚Ì‚Åadd_senbun‚É‚¤‚Â‚µ‚©‚¦‚Ä‚é20170507
                    add_senbun.setcolor(icol);
                    addsenbun(add_senbun);
                }
            }
            kiroku();

            i_egaki_dankai = 0;
        }
    }

// ------------------------------------------------------------

    public void renzoku_orikaesi(Ten a, Ten b) {

        //—^‚¦‚ç‚ê‚½ƒxƒNƒgƒ‹ab‚ð‰„’·‚µ‚Ä?A‚»‚ê‚Æ?d‚È‚ç‚È‚¢?Ü?ü‚Æ‚Ì?A?Å‚à‹ß‚¢Œð“_‚Ü‚Ås_step‚Æ‚·‚é
        if (e_s_dougubako.get_kousaten_made_nobasi_flg(a, b) == 0) {
            return;
        }
        //if(e_s_dougubako.get_kousaten_made_nobasi_orisen_fukumu_flg(a,b)==3){return;}

        i_egaki_dankai = i_egaki_dankai + 1;
        if (i_egaki_dankai > 100) {
            return;
        }//”O‚Ì‚½‚ß‚És_step‚Ì?ãŒÀ‚ð100‚É?Ý’è‚µ‚½

        s_step[i_egaki_dankai].set(e_s_dougubako.get_kousaten_made_nobasi_senbun(a, b));//—v’?ˆÓ?@es1‚Å‚¤‚Á‚©‚ès_step‚Éset.(senbun)‚â‚é‚ÆƒAƒNƒeƒBƒ”‚Å‚È‚¢‚Ì‚Å•\Ž¦‚ª?¬‚³‚­‚È‚é20170507
        s_step[i_egaki_dankai].setiactive(3);

        //‹?‚ß‚½Œð“_‚Å?AŽŸ‚ÌƒxƒNƒgƒ‹‚ð”­?¶‚·‚é?B

        if (e_s_dougubako.get_kousaten_made_nobasi_flg(a, b) == 1) {
            Senbun kousaten_made_nobasi_saisyono_senbun = new Senbun();
            kousaten_made_nobasi_saisyono_senbun.set(e_s_dougubako.get_kousaten_made_nobasi_saisyono_senbun(a, b));

            Ten new_a = new Ten();
            new_a.set(e_s_dougubako.get_kousaten_made_nobasi_ten(a, b));
            Ten new_b = new Ten();
            new_b.set(oc.sentaisyou_ten_motome(kousaten_made_nobasi_saisyono_senbun.geta(), kousaten_made_nobasi_saisyono_senbun.getb(), a));//‚Q‚Â‚Ì“_t1,t2‚ð’Ê‚é’¼?ü‚ÉŠÖ‚µ‚Ä?A“_p‚Ì‘Î?ÆˆÊ’u‚É‚ ‚é“_‚ð‹?‚ß‚é public Ten oc.sentaisyou_ten_motome(Ten t1,Ten t2,Ten p){

            renzoku_orikaesi(new_a, new_b);
            return;
        }

        return;
    }
// ------------------------------------------------------------


//--------------------------------------------
//27 27 27 27 27 27 27 27  i_mouse_modeA==27?ü•ª•ªŠ„	“ü—Í 27 27 27 27 27 27 27 27
    //“®?ìŠT—v?@
    //i_mouse_modeA==1‚Æ?ü•ª•ªŠ„ˆÈŠO‚Í“¯‚¶?@
    //

    //ƒ}ƒEƒX‘€?ì(ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mMoved_A_27(Ten p0) {
        mMoved_m_00a(p0, icol);//ƒ}ƒEƒX‚Å‘I‘ð‚Å‚«‚éŒó•â“_‚ð•\Ž¦‚·‚é?B‹ß‚­‚ÉŠù?¬‚Ì“_‚ª‚ ‚é‚Æ‚«‚Í‚»‚Ì“_?A–³‚¢‚Æ‚«‚Íƒ}ƒEƒX‚ÌˆÊ’uŽ©?g‚ªŒó•â“_‚Æ‚È‚é?B
/*
		if(i_kou_mitudo_nyuuryoku==1){s_kouho[1].setiactive(3);
			i_kouho_dankai=0;
			p.set(camera.TV2object(p0));
			moyori_ten.set(get_moyori_ten(p));
			if(p.kyori(moyori_ten)<d_hantei_haba     ){
				i_kouho_dankai=1;
				s_kouho[1].set(moyori_ten,moyori_ten);
				s_kouho[1].setcolor(icol);
				return;
			}
		}
*/
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==27?ü•ª“ü—Í?@‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ----------------------------------------------------
    public void mPressed_A_27(Ten p0) {
        i_egaki_dankai = 1;
        s_step[1].setiactive(2);
        p.set(camera.TV2object(p0));
        moyori_ten.set(get_moyori_ten(p));
        if (p.kyori(moyori_ten) < d_hantei_haba) {
            s_step[1].set(p, moyori_ten);
            s_step[1].setcolor(icol);
            return;
        }
        s_step[1].set(p, p);
        s_step[1].setcolor(icol);
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==27?ü•ª“ü—Í?@‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mDragged_A_27(Ten p0) {
        p.set(camera.TV2object(p0));
        s_step[1].seta(p);
        if (i_kou_mitudo_nyuuryoku == 1) {
            i_kouho_dankai = 0;
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                i_kouho_dankai = 1;
                s_kouho[1].set(moyori_ten, moyori_ten);
                s_kouho[1].setcolor(icol);
                s_step[1].seta(s_kouho[1].geta());
            }
        }


    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==27?ü•ª“ü—Í?@‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mReleased_A_27(Ten p0) {
        i_egaki_dankai = 0;
        p.set(camera.TV2object(p0));

        s_step[1].seta(p);
        moyori_ten.set(get_moyori_ten(p));

        if (p.kyori(moyori_ten) <= d_hantei_haba) {
            s_step[1].seta(moyori_ten);
        }
        if (s_step[1].getnagasa() > 0.00000001) {
            for (int i = 0; i <= i_orisen_bunkatu_suu - 1; i++) {
                double ax = ((double) (i_orisen_bunkatu_suu - i) * s_step[1].getax() + (double) i * s_step[1].getbx()) / ((double) i_orisen_bunkatu_suu);
                double ay = ((double) (i_orisen_bunkatu_suu - i) * s_step[1].getay() + (double) i * s_step[1].getby()) / ((double) i_orisen_bunkatu_suu);
                double bx = ((double) (i_orisen_bunkatu_suu - i - 1) * s_step[1].getax() + (double) (i + 1) * s_step[1].getbx()) / ((double) i_orisen_bunkatu_suu);
                double by = ((double) (i_orisen_bunkatu_suu - i - 1) * s_step[1].getay() + (double) (i + 1) * s_step[1].getby()) / ((double) i_orisen_bunkatu_suu);
                Senbun s_ad = new Senbun(ax, ay, bx, by);
                s_ad.setcolor(icol);
                addsenbun(s_ad);
            }
            kiroku();
        }

    }

//--------------------------------------------
//29 29 29 29 29 29 29 29  i_mouse_modeA==29?³‘½ŠpŒ`“ü—Í	“ü—Í 29 29 29 29 29 29 29 29
    //“®?ìŠT—v?@
    //i_mouse_modeA==1‚Æ?ü•ª•ªŠ„ˆÈŠO‚Í“¯‚¶?@
    //

    //ƒ}ƒEƒX‘€?ì(ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mMoved_A_29(Ten p0) {
        if (i_kou_mitudo_nyuuryoku == 1) {
            s_kouho[1].setiactive(3);
            i_kouho_dankai = 0;
            p.set(camera.TV2object(p0));
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                i_kouho_dankai = 1;
                s_kouho[1].set(moyori_ten, moyori_ten);
                s_kouho[1].setcolor(icol);
                return;
            }
        }
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==29?³‘½ŠpŒ`“ü—Í?@‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ----------------------------------------------------
    public void mPressed_A_29(Ten p0) {
        s_step[1].setiactive(3);

        p.set(camera.TV2object(p0));

        if (i_egaki_dankai == 0) {    //‘æ1’iŠK‚Æ‚µ‚Ä?A“_‚ð‘I‘ð
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(5);
            }
            return;
        }

        if (i_egaki_dankai == 1) {    //‘æ2’iŠK‚Æ‚µ‚Ä?A“_‚ð‘I‘ð
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) >= d_hantei_haba) {
                i_egaki_dankai = 0;
                return;
            }
            if (p.kyori(moyori_ten) < d_hantei_haba) {

                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(i_egaki_dankai);
                s_step[1].setb(s_step[2].getb());
            }
            if (s_step[1].getnagasa() < 0.00000001) {
                i_egaki_dankai = 0;
            }
        }


    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==29?³‘½ŠpŒ`“ü—Í?@‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mDragged_A_29(Ten p0) {
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==29?³‘½ŠpŒ`“ü—Í?@‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mReleased_A_29(Ten p0) {
        if (i_egaki_dankai == 2) {
            i_egaki_dankai = 0;
            Senbun s_tane = new Senbun();
            Senbun s_deki = new Senbun();


            s_tane.set(s_step[1]);
            s_tane.setcolor(icol);
            addsenbun(s_tane);
            for (int i = 2; i <= i_sei_takakukei; i++) {
                s_deki.set(oc.Senbun_kaiten(s_tane, (double) (i_sei_takakukei - 2) * 180.0 / (double) i_sei_takakukei));
                s_tane.set(s_deki.getb(), s_deki.geta());
                s_tane.setcolor(icol);
                addsenbun(s_tane);

            }
            ori_s.unselect_all();
            kiroku();
        }
    }


    //37 37 37 37 37 37 37 37 37 37 37;Šp“x‹KŠi‰»
    //ƒ}ƒEƒX‘€?ì(ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mMoved_A_37(Ten p0) {
        mMoved_A_29(p0);
    }//‹ß‚¢Šù‘¶“_‚Ì‚Ý•\Ž¦

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==37?@‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ-------//System.out.println("A");---------------------------------------------
    public void mPressed_A_37(Ten p0) {
        s_step[1].setiactive(2);
        i_egaki_dankai = 1;

        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        moyori_ten.set(get_moyori_ten(p));
        if (p.kyori(moyori_ten) > d_hantei_haba) {
            i_egaki_dankai = 0;
        }
        s_step[1].set(p, moyori_ten);
        s_step[1].setcolor(icol);

        s_step[2].set(s_step[1]);//‚±‚±‚Å‚Ís_step[2]‚Í•\Ž¦‚³‚ê‚È‚¢?AŒvŽZ—p‚Ì?ü•ª
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==37?@‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”--------------//System.out.println("A");--------------------------------------
    public void mDragged_A_37(Ten p0) {
        Ten syuusei_ten = new Ten(syuusei_ten_A_37(p0));
        s_step[1].seta(syuusei_ten);

        if (i_kou_mitudo_nyuuryoku == 1) {
            i_kouho_dankai = 1;
            s_kouho[1].set(kouho_ten_A_37(syuusei_ten), kouho_ten_A_37(syuusei_ten));
            s_kouho[1].setcolor(icol);
            s_step[1].seta(kouho_ten_A_37(syuusei_ten));
        }

    }


    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==37?@‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mReleased_A_37(Ten p0) {
        if (i_egaki_dankai == 1) {
            i_egaki_dankai = 0;
            Ten syuusei_ten = new Ten(syuusei_ten_A_37(p0));
            s_step[1].seta(kouho_ten_A_37(syuusei_ten));
            if (s_step[1].getnagasa() > 0.00000001) {
                addsenbun(s_step[1]);
                kiroku();
                return;
            }


        }

    }


    // ---
    public Ten syuusei_ten_A_37(Ten p0) {

        //Ten p =new Ten();
        p.set(camera.TV2object(p0));

        Ten syuusei_ten = new Ten();
        double d_rad = 0.0;
        s_step[2].seta(p);

        if (id_kakudo_kei != 0) {
            d_kakudo_kei = 180.0 / (double) id_kakudo_kei;
            d_rad = (Math.PI / 180) * d_kakudo_kei * Math.round(oc.kakudo(s_step[2]) / d_kakudo_kei);
        } else if (id_kakudo_kei == 0) {
            double[] jk = new double[7];
            jk[0] = oc.kakudo(s_step[2]);//ƒ}ƒEƒX‚Å“ü—Í‚µ‚½?ü•ª‚ªXŽ²‚Æ‚È‚·Šp“x
            jk[1] = d_jiyuu_kaku_1 - 180.0;
            jk[2] = d_jiyuu_kaku_2 - 180.0;
            jk[3] = d_jiyuu_kaku_3 - 180.0;
            jk[4] = 360.0 - d_jiyuu_kaku_1 - 180.0;
            jk[5] = 360.0 - d_jiyuu_kaku_2 - 180.0;
            jk[6] = 360.0 - d_jiyuu_kaku_3 - 180.0;

            double d_kakudo_sa_min = 1000.0;
            for (int i = 1; i <= 6; i++) {
                if (Math.min(oc.kakudo_osame_0_360(jk[i] - jk[0]), oc.kakudo_osame_0_360(jk[0] - jk[i])) < d_kakudo_sa_min) {
                    d_kakudo_sa_min = Math.min(oc.kakudo_osame_0_360(jk[i] - jk[0]), oc.kakudo_osame_0_360(jk[0] - jk[i]));
                    d_rad = (Math.PI / 180) * jk[i];
                }
            }
        }

        syuusei_ten.set(oc.kage_motome(s_step[2].getb(), new Ten(s_step[2].getbx() + Math.cos(d_rad), s_step[2].getby() + Math.sin(d_rad)), p));
        return syuusei_ten;
    }


    // ---
    public Ten kouho_ten_A_37(Ten syuusei_ten) {
        moyori_ten.set(get_moyori_ten(syuusei_ten));
        double zure_kakudo = oc.kakudo(s_step[2].getb(), syuusei_ten, s_step[2].getb(), moyori_ten);
        int zure_flg = 0;
        if ((0.00001 < zure_kakudo) && (zure_kakudo <= 359.99999)) {
            zure_flg = 1;
        }
        if ((zure_flg == 0) && (syuusei_ten.kyori(moyori_ten) <= d_hantei_haba)) {//?ÅŠñ“_‚ªŠp“xŒn‚É‚Ì‚Á‚Ä‚¢‚Ä?A?C?³“_‚Æ‚à‹ß‚¢?ê?‡
            return moyori_ten;
        }
        return syuusei_ten;
    }


// 19 19 19 19 19 19 19 19 19 select ‘I‘ð

    Ten p19_1 = new Ten();
    Ten p19_2 = new Ten();
    Ten p19_3 = new Ten();
    Ten p19_4 = new Ten();


    //------------------------------------------------------------
    public void mPressed_A_box_select(Ten p0) {
        p19_1.set(p0);

        i_egaki_dankai = 0;

        //Ten p =new Ten();
        p.set(camera.TV2object(p0));

        s_step[1].set(p, p);
        s_step[1].setcolor(5);
        s_step[2].set(p, p);
        s_step[2].setcolor(5);
        s_step[3].set(p, p);
        s_step[3].setcolor(5);
        s_step[4].set(p, p);
        s_step[4].setcolor(5);

    }
//------------------------------------------------------------

    Ten p19_a = new Ten();
    Ten p19_b = new Ten();
    Ten p19_c = new Ten();
    Ten p19_d = new Ten();


//------------------------------------------------------------

    public void mDragged_A_box_select(Ten p0) {
        p19_2.set(p19_1.getx(), p0.gety());
        p19_4.set(p0.getx(), p19_1.gety());

        p19_a.set(camera.TV2object(p19_1));
        p19_b.set(camera.TV2object(p19_2));
        p19_c.set(camera.TV2object(p0));
        p19_d.set(camera.TV2object(p19_4));

        s_step[1].set(p19_a, p19_b);
        s_step[2].set(p19_b, p19_c);
        s_step[3].set(p19_c, p19_d);
        s_step[4].set(p19_d, p19_a);

        i_egaki_dankai = 4;//s_step[4]‚Ü‚Å•`‰æ‚·‚é‚½‚ß‚É?A‚±‚Ì?s‚ª•K—v

    }


//------------------------------------------------------------
// 19 19 19 19 19 19 19 19 19 select ‘I‘ð


    int i_select_mode = 0;//=0‚Í’Ê?í‚ÌƒZƒŒƒNƒg‘€?ì

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==19  select?@‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ----------------------------------------------------
    public void mPressed_A_19(Ten p0) {
        System.out.println("19  select_");
        System.out.println("i_egaki_dankai=" + i_egaki_dankai);

        if (i_egaki_dankai == 0) {//i_select_mode‚ðŒˆ‚ß‚é
            //Ten p =new Ten();
            p.set(camera.TV2object(p0));
            moyori_ten.set(get_moyori_ten_orisen_en(p));//‚±‚Ì?ÅŠñ“_‚ÍŠiŽq“_‚Í‘Î?Û‚Æ‚µ‚È‚¢
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                i_select_mode = 0;
                if (ori_s.tyouten_syuui_sensuu_select(p, 0.0001) > 0) {
                    i_select_mode = orihime_ap.i_sel_mou_mode;//=1‚Ímove?A=2‚Ímove4p?A=3‚Ícopy?A=4‚Ícopy4p?A=5‚Í‹¾‰f‘œ
                }
            }
        }


        if (i_select_mode == 0) {
            mPressed_A_box_select(p0);
        } else if (i_select_mode == 1) {
            mPressed_A_21(p0);//move
        } else if (i_select_mode == 2) {
            mPressed_A_31(p0);//move 2p2p
        } else if (i_select_mode == 3) {
            mPressed_A_22(p0);//copy
        } else if (i_select_mode == 4) {
            mPressed_A_32(p0);//copy 2p2p
        } else if (i_select_mode == 5) {
            mPressed_A_12(p0);//‹¾‰f
        }
    }


    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==19 select?@‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mDragged_A_19(Ten p0) {
        //mDragged_A_box_select( p0);
        if (i_select_mode == 0) {
            mDragged_A_box_select(p0);
        } else if (i_select_mode == 1) {
            mDragged_A_21(p0);//move
        } else if (i_select_mode == 2) {
            mDragged_A_31(p0);//move 2p2p
        } else if (i_select_mode == 3) {
            mDragged_A_22(p0);//copy
        } else if (i_select_mode == 4) {
            mDragged_A_32(p0);//copy 2p2p
        } else if (i_select_mode == 5) {
            mDragged_A_12(p0);//‹¾‰f
        }


    }


    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==19 select?@‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mReleased_A_19(Ten p0) {
        //mReleased_A_box_select(p0);
        if (i_select_mode == 0) {
            mReleased_A_box_select(p0);
        } else if (i_select_mode == 1) {
            mReleased_A_21(p0);//move
        } else if (i_select_mode == 2) {
            mReleased_A_31(p0);//move 2p2p
        } else if (i_select_mode == 3) {
            mReleased_A_22(p0);//copy
        } else if (i_select_mode == 4) {
            mReleased_A_32(p0);//copy 2p2p
        } else if (i_select_mode == 5) {
            mReleased_A_12(p0);//‹¾‰f
        }


    }


//------------------------------------------------------------


    public void mReleased_A_box_select(Ten p0) {
        i_egaki_dankai = 0;

        select(p19_1, p0);
        if (p19_1.kyori(p0) <= 0.000001) {
            p.set(camera.TV2object(p0));
            if (ori_s.mottomo_tikai_senbun_kyori(p) < d_hantei_haba) {//“_p‚É?Å‚à‹ß‚¢?ü•ª‚Ì”Ô?†‚Å‚Ì?A‚»‚Ì‹——£‚ð•Ô‚·	public double mottomo_tikai_senbun_kyori(Ten p)
                ori_s.select(ori_s.mottomo_tikai_senbun_sagasi(p));
            }
        }

    }

//20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20


    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==19  select?@‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ----------------------------------------------------
    public void mPressed_A_20(Ten p0) {
        mPressed_A_box_select(p0);
    }


    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==19 select?@‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mDragged_A_20(Ten p0) {
        mDragged_A_box_select(p0);
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==20 select?@‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mReleased_A_20(Ten p0) {

        i_egaki_dankai = 0;
        unselect(p19_1, p0);

        if (p19_1.kyori(p0) <= 0.000001) {
            //Ten p =new Ten();
            p.set(camera.TV2object(p0));
            if (ori_s.mottomo_tikai_senbun_kyori(p) < d_hantei_haba) {//“_p‚É?Å‚à‹ß‚¢?ü•ª‚Ì”Ô?†‚Å‚Ì?A‚»‚Ì‹——£‚ð•Ô‚·	public double mottomo_tikai_senbun_kyori(Ten p)
                ori_s.unselect(ori_s.mottomo_tikai_senbun_sagasi(p));
            }
        }


    }

    //---------------------
    public int get_i_egaki_dankai() {
        return i_egaki_dankai;
    }

    //---------------------
    public void select_all() {
        ori_s.select_all();
    }

    public void unselect_all() {
        ori_s.unselect_all();
    }

    public void select(Ten p0a, Ten p0b) {
        Ten p0_a = new Ten();
        Ten p0_b = new Ten();
        Ten p0_c = new Ten();
        Ten p0_d = new Ten();


        Ten p_a = new Ten();
        Ten p_b = new Ten();
        Ten p_c = new Ten();
        Ten p_d = new Ten();


        p0_a.set(p0a.getx(), p0a.gety());
        p0_b.set(p0a.getx(), p0b.gety());
        p0_c.set(p0b.getx(), p0b.gety());
        p0_d.set(p0b.getx(), p0a.gety());


        p_a.set(camera.TV2object(p0_a));
        p_b.set(camera.TV2object(p0_b));
        p_c.set(camera.TV2object(p0_c));
        p_d.set(camera.TV2object(p0_d));


        ori_s.select(p_a, p_b, p_c, p_d);
    }

    //--------------------
    public void unselect(Ten p0a, Ten p0b) {
        Ten p0_a = new Ten();
        Ten p0_b = new Ten();
        Ten p0_c = new Ten();
        Ten p0_d = new Ten();
        Ten p_a = new Ten();
        Ten p_b = new Ten();
        Ten p_c = new Ten();
        Ten p_d = new Ten();
        p0_a.set(p0a.getx(), p0a.gety());
        p0_b.set(p0a.getx(), p0b.gety());
        p0_c.set(p0b.getx(), p0b.gety());
        p0_d.set(p0b.getx(), p0a.gety());
        p_a.set(camera.TV2object(p0_a));
        p_b.set(camera.TV2object(p0_b));
        p_c.set(camera.TV2object(p0_c));
        p_d.set(camera.TV2object(p0_d));
        ori_s.unselect(p_a, p_b, p_c, p_d);
    }


//61 61 61 61 61 61 61 61 61 61 61 61 i_mouse_modeA==61//’·•ûŒ`“à‘I‘ð?ipaint‚Ì‘I‘ð‚ÉŽ—‚¹‚½‘I‘ð‹@”\?j‚ÉŽg‚¤
    //“®?ìŠT—v?@
    //ƒ}ƒEƒXƒ{ƒ^ƒ“‰Ÿ‚³‚ê‚½‚Æ‚«?@
    //—pŽ†1/1•ªŠ„Žž 		?Ü?ü‚Ì’[“_‚Ì‚Ý‚ªŠî?€“_?BŠiŽq“_‚ªŠî?€“_‚É‚È‚é‚±‚Æ‚Í‚È‚¢?B
    //—pŽ†1/2‚©‚ç1/512•ªŠ„Žž	?Ü?ü‚Ì’[“_‚Æ—pŽ†˜g“à?i-200.0,-200.0 _ 200.0,200.0)?j‚ÌŠiŽq“_‚Æ‚ªŠî?€“_
    //“ü—Í“_P‚ªŠî?€“_‚©‚çŠiŽq•?kus.d_haba()‚Ì1/4‚æ‚è‰“‚¢‚Æ‚«‚Í?Ü?ü?W?‡‚Ö‚Ì“ü—Í‚È‚µ
    //?ü•ª‚ª’·‚³‚ª‚È‚­1“_?ó‚Ì‚Æ‚«‚Í?Ü?ü?W?‡‚Ö‚Ì“ü—Í‚È‚µ

    //ƒ}ƒEƒX‘€?ì(ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mMoved_A_61(Ten p0) {
        if (i_kou_mitudo_nyuuryoku == 1) {
            s_kouho[1].setiactive(3);

            p.set(camera.TV2object(p0));
            i_kouho_dankai = 1;
            moyori_ten.set(get_moyori_ten(p));

            if (p.kyori(moyori_ten) < d_hantei_haba) {
                s_kouho[1].set(moyori_ten, moyori_ten);
            } else {
                s_kouho[1].set(p, p);
            }

            //s_kouho[1].setcolor(icol);
            s_kouho[1].setcolor(6);

            return;
        }
    }


    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==61?@’·•ûŒ`“à‘I‘ð‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ----------------------------------------------------
    public void mPressed_A_61(Ten p0) {
        p.set(camera.TV2object(p0));
        Ten p_new = new Ten();
        Ten p_ob1 = new Ten();
        p_ob1.set(camera.TV2object(p61_1));
        Ten p_ob2 = new Ten();
        p_ob2.set(camera.TV2object(p61_2));
        Ten p_ob3 = new Ten();
        p_ob3.set(camera.TV2object(p61_3));
        Ten p_ob4 = new Ten();
        p_ob4.set(camera.TV2object(p61_4));

        double kyori_min = 100000.0;

        p61_mode = 0;
        if (i_egaki_dankai == 0) {
            p61_mode = 1;
        }
        if (i_egaki_dankai == 4) {
            if (p61_TV_hako.naibu(p0) == 0) {
                p61_mode = 1;
            }
            if (p61_TV_hako.naibu(p0) > 0) {
                p61_mode = 4;
            }


            kyori_min = oc.min(oc.kyori_senbun(p, p_ob1, p_ob2), oc.kyori_senbun(p, p_ob2, p_ob3), oc.kyori_senbun(p, p_ob3, p_ob4), oc.kyori_senbun(p, p_ob4, p_ob1));
            if (kyori_min < d_hantei_haba) {
                p61_mode = 3;
            }


            if (p.kyori(p_ob1) < d_hantei_haba) {
                p_new.set(p61_1);
                p61_1.set(p61_3);
                p61_3.set(p_new);
                p61_mode = 2;
            }
            if (p.kyori(p_ob2) < d_hantei_haba) {
                p_new.set(p61_2);
                p61_2.set(p61_1);
                p61_1.set(p61_4);
                p61_4.set(p61_3);
                p61_3.set(p_new);
                p61_mode = 2;
            }
            if (p.kyori(p_ob3) < d_hantei_haba) {
                p_new.set(p61_3);
                p61_1.set(p61_1);
                p61_3.set(p_new);
                p61_mode = 2;
            }
            if (p.kyori(p_ob4) < d_hantei_haba) {
                p_new.set(p61_4);
                p61_4.set(p61_1);
                p61_1.set(p61_2);
                p61_2.set(p61_3);
                p61_3.set(p_new);
                p61_mode = 2;
            }

        }


        if (p61_mode == 3) {
            while (oc.kyori_senbun(p, p_ob1, p_ob2) != kyori_min) {
                p_new.set(p61_1);
                p61_1.set(p61_2);
                p61_2.set(p61_3);
                p61_3.set(p61_4);
                p61_4.set(p_new);
                p_new.set(p_ob1);
                p_ob1.set(p_ob2);
                p_ob2.set(p_ob3);
                p_ob3.set(p_ob4);
                p_ob4.set(p_new);
            }

        }

        if (p61_mode == 1) {
            i_egaki_dankai = 4;
            //s_step[1].setiactive(2);


            p_new.set(p);

            moyori_ten.set(get_moyori_ten(p));

            if (p.kyori(moyori_ten) < d_hantei_haba) {
                p_new.set(moyori_ten);

            }

            p61_1.set(camera.object2TV(p_new));
            p61_2.set(camera.object2TV(p_new));
            p61_3.set(camera.object2TV(p_new));
            p61_4.set(camera.object2TV(p_new));

            return;

            //s_step[1].setcolor(6);
            //s_step[2].setcolor(6);
            //s_step[3].setcolor(6);
            //s_step[4].setcolor(6);
        }
/*
		if(i_egaki_dankai==4){
			i_egaki_dankai=4;
			s_step[1].setiactive(2);
			p.set(camera.TV2object(p0));

			moyori_ten.set(get_moyori_ten(p));

			s_step[1].setcolor(6);
			if(p.kyori(moyori_ten)<d_hantei_haba     ){
				s_step[1].set(p,moyori_ten);
				return;
			}

			s_step[1].set(p,p);
			s_step[2].set(p,p);
			s_step[3].set(p,p);
			s_step[4].set(p,p);

			s_step[1].setcolor(6);
			s_step[2].setcolor(6);
			s_step[3].setcolor(6);
			s_step[4].setcolor(6);

		}
*/
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==61?@’·•ûŒ`“à‘I‘ð‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mDragged_A_61(Ten p0) {

        p.set(camera.TV2object(p0));
        if (p61_mode == 2) {
            p61_mode = 1;
        }


        Ten p_new = new Ten();


        if (i_kou_mitudo_nyuuryoku == 0) {
            p_new.set(p);
        }

        if (i_kou_mitudo_nyuuryoku == 1) {
            moyori_ten.set(get_moyori_ten(p));
            i_kouho_dankai = 1;
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                s_kouho[1].set(moyori_ten, moyori_ten);
            } else {
                s_kouho[1].set(p, p);
            }
            s_kouho[1].setcolor(6);

            p_new.set(s_kouho[1].geta());
        }


        if (p61_mode == 3) {
            if (
                    (p61_1.getx() - p61_2.getx()) * (p61_1.getx() - p61_2.getx())
                            <
                            (p61_1.gety() - p61_2.gety()) * (p61_1.gety() - p61_2.gety())
            ) {
                p61_1.setx(camera.object2TV(p_new).getx());
                p61_2.setx(camera.object2TV(p_new).getx());
            }

            if (
                    (p61_1.getx() - p61_2.getx()) * (p61_1.getx() - p61_2.getx())
                            >
                            (p61_1.gety() - p61_2.gety()) * (p61_1.gety() - p61_2.gety())
            ) {
                p61_1.sety(camera.object2TV(p_new).gety());
                p61_2.sety(camera.object2TV(p_new).gety());
            }

        }


        if (p61_mode == 1) {
            p61_3.set(camera.object2TV(p_new));
            p61_2.set(p61_1.getx(), p61_3.gety());
            p61_4.set(p61_3.getx(), p61_1.gety());
        }
/*






			Ten p1= new Ten();p1.set(p_new);
			Ten p3= new Ten();p3.set(s_step[1].getb());

			Ten p2= new Ten();p2.set(p1.getx(),p3.gety());
			Ten p4= new Ten();p4.set(p3.getx(),p1.gety());

			s_step[1].set(p2,p3); //s_step[1]‚Ìb“_‚Í?Å?‰‚Ì’n“_‚Æ‚µ‚Ä•Ï?X‚Å‚«‚È‚¢‚Ì‚Å?A.set(p2,p3);‚Æ‚·‚é•K—v‚ª‚ ‚é?B
			s_step[2].set(p3,p4);
			s_step[3].set(p4,p1);
			s_step[4].set(p1,p2);

			s_step[1].setcolor(6);
			s_step[2].setcolor(6);
			s_step[3].setcolor(6);
			s_step[4].setcolor(6);
*/

    }


    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==61 ’·•ûŒ`“à‘I‘ð?@‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mReleased_A_61(Ten p0) {

        p.set(camera.TV2object(p0));

        Ten p_new = new Ten();
        p_new.set(p);
        //s_step[1].seta(p);

        moyori_ten.set(get_moyori_ten(p));
        if (p.kyori(moyori_ten) <= d_hantei_haba) {
            p_new.set(moyori_ten);/*s_step[1].seta(moyori_ten);*/
        }

        if (p61_mode == 3) {
            if (
                    (p61_1.getx() - p61_2.getx()) * (p61_1.getx() - p61_2.getx())
                            <
                            (p61_1.gety() - p61_2.gety()) * (p61_1.gety() - p61_2.gety())
            ) {
                p61_1.setx(camera.object2TV(p_new).getx());
                p61_2.setx(camera.object2TV(p_new).getx());
            }

            if (
                    (p61_1.getx() - p61_2.getx()) * (p61_1.getx() - p61_2.getx())
                            >
                            (p61_1.gety() - p61_2.gety()) * (p61_1.gety() - p61_2.gety())
            ) {
                p61_1.sety(camera.object2TV(p_new).gety());
                p61_2.sety(camera.object2TV(p_new).gety());
            }

        }


        if (p61_mode == 1) {
            p61_3.set(camera.object2TV(p_new));
            p61_2.set(p61_1.getx(), p61_3.gety());
            p61_4.set(p61_3.getx(), p61_1.gety());
        }


        p61_TV_hako.set(1, p61_1);
        p61_TV_hako.set(2, p61_2);
        p61_TV_hako.set(3, p61_3);
        p61_TV_hako.set(4, p61_4);


//System.out.println("aaaaaaaaa_"+p61_TV_hako.menseki_motome());

        if (p61_TV_hako.menseki_motome() * p61_TV_hako.menseki_motome() < 1.0) {
            i_egaki_dankai = 0;
        }








/*
			Ten p1= new Ten();p1.set(p_new);
			Ten p3= new Ten();p3.set(s_step[1].getb());

			Ten p2= new Ten();p2.set(p1.getx(),p3.gety());
			Ten p4= new Ten();p4.set(p3.getx(),p1.gety());

			s_step[1].set(p2,p3); //s_step[1]‚Ìb“_‚Í?Å?‰‚Ì’n“_‚Æ‚µ‚Ä•Ï?X‚Å‚«‚È‚¢‚Ì‚Å?A.set(p2,p3);‚Æ‚·‚é•K—v‚ª‚ ‚é?B
			s_step[2].set(p3,p4);
			s_step[3].set(p4,p1);
			s_step[4].set(p1,p2);

			s_step[1].setcolor(6);
			s_step[2].setcolor(6);
			s_step[3].setcolor(6);
			s_step[4].setcolor(6);



		if(s_step[1].getnagasa()>0.00000001){
			i_egaki_dankai=4;
		}
*/

        //text_cp_setumei="aaaaaa"+ori_s.getsousuu();
    }


//22222222222222222222222222222222222222222222222222222222222222 “WŠJ?}ˆÚ“®


    //public void mPressed_A_02(Ten p0) {	}//ƒ}ƒEƒX‘€?ì(i_mouse_modeA==2?@“WŠJ?}ˆÚ“®‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ
    //public void mDragged_A_02(Ten p0) {	}//ƒ}ƒEƒX‘€?ì(i_mouse_modeA==2?@“WŠJ?}ˆÚ“®‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    //public void mReleased_A_02(Ten p0){	}//ƒ}ƒEƒX‘€?ì(i_mouse_modeA==2?@“WŠJ?}ˆÚ“®‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”

    //3 3 3 3 3 33333333333333333333333333333333333333333333333333333333
    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==3,23 "?ü•ª?í?œ" ‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ----------------------------------------------------
    public void mPressed_A_03(Ten p0) {
        //System.out.println("(1)zzzzz ori_s.check4_size() = "+ori_s.check4_size());
        if (i_orisen_hojyosen == 0) {
            mPressed_A_box_select(p0);
        }//?Ü?ü‚Ì?í?œ
        if (i_orisen_hojyosen == 2) {
            mPressed_A_box_select(p0);
        }//?•‚Ì?Ü?ü
        if (i_orisen_hojyosen == 3) {
            mPressed_A_box_select(p0);
        }//•â?•Šˆ?ü

        if (i_orisen_hojyosen == 1) {
            mPressed_A_box_select(p0);
        }//•â?•ŠG?ü

        if (i_orisen_hojyosen == 4) {
            mPressed_A_box_select(p0);
        }//?Ü?ü‚Æ•â?•Šˆ?ü‚Æ•â?•ŠG?ü
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==3,23‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mDragged_A_03(Ten p0) {
        //System.out.println("(2)zzzzz ori_s.check4_size() = "+ori_s.check4_size());
        if (i_orisen_hojyosen == 0) {
            mDragged_A_box_select(p0);
        }
        if (i_orisen_hojyosen == 2) {
            mDragged_A_box_select(p0);
        }
        if (i_orisen_hojyosen == 3) {
            mDragged_A_box_select(p0);
        }

        if (i_orisen_hojyosen == 1) {
            mDragged_A_box_select(p0);
        }

        if (i_orisen_hojyosen == 4) {
            mDragged_A_box_select(p0);
        }


    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==3,23 ‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mReleased_A_03(Ten p0) {//?Ü?ü‚Æ•â?•Šˆ?ü‚Æ‰~
        //System.out.println("(3_1)zzzzz ori_s.check4_size() = "+ori_s.check4_size());
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        i_egaki_dankai = 0;

        //?ÅŠñ‚Ìˆê‚Â‚ð?í?œ
        if (p19_1.kyori(p0) <= 0.000001) {//?ÅŠñ‚Ìˆê‚Â‚ð?í?œ
            int i_sakujyo_mode = 10;//i_sakujyo_mode‚Í‚±‚±‚Å’è‹`?E?éŒ¾‚µ‚Ä‚¢‚é
            if (i_orisen_hojyosen == 0) {
                i_sakujyo_mode = 0;
            }
            if (i_orisen_hojyosen == 2) {
                i_sakujyo_mode = 2;
            }
            if (i_orisen_hojyosen == 3) {
                i_sakujyo_mode = 3;
            }
            if (i_orisen_hojyosen == 1) {
                i_sakujyo_mode = 1;
            }
            if (i_orisen_hojyosen == 4) {
                i_sakujyo_mode = 10;
                //Ten p =new Ten(); p.set(camera.TV2object(p0));
                double rs_min;
                rs_min = ori_s.mottomo_tikai_senbun_kyori(p);//“_p‚É?Å‚à‹ß‚¢?ü•ª(?Ü?ü‚Æ•â?•Šˆ?ü)‚Ì”Ô?†‚Å‚Ì?A‚»‚Ì‹——£‚ð•Ô‚·	public double mottomo_tikai_senbun_kyori(Ten p)

                double re_min;
                re_min = ori_s.mottomo_tikai_en_kyori(p);//“_p‚É?Å‚à‹ß‚¢‰~‚Ì”Ô?†‚Å‚Ì?A‚»‚Ì‹——£‚ð•Ô‚·	public double mottomo_tikai_en_kyori(Ten p)

                double hoj_rs_min;
                hoj_rs_min = hoj_s.mottomo_tikai_senbun_kyori(p);//“_p‚É?Å‚à‹ß‚¢•â?•ŠG?ü‚Ì”Ô?†‚Å‚Ì?A‚»‚Ì‹——£‚ð•Ô‚·	public double mottomo_tikai_senbun_kyori(Ten p)

                if ((rs_min <= re_min) && (rs_min <= hoj_rs_min)) {
                    if (ori_s.getcolor(ori_s.mottomo_tikai_senbun_sagasi_gyakujyun(p)) < 3) {
                        i_sakujyo_mode = 0;
                    } else {
                        i_sakujyo_mode = 3;
                    }
                }

                if ((re_min < rs_min) && (re_min <= hoj_rs_min)) {
                    i_sakujyo_mode = 3;
                }
                if ((hoj_rs_min < rs_min) && (hoj_rs_min < re_min)) {
                    i_sakujyo_mode = 1;
                }

            }


            if (i_sakujyo_mode == 0) { //?Ü?ü‚Ì?í?œ

                //Ten p =new Ten(); p.set(camera.TV2object(p0));
                double rs_min;
                rs_min = ori_s.mottomo_tikai_senbun_kyori(p);//“_p‚É?Å‚à‹ß‚¢?ü•ª(?Ü?ü‚Æ•â?•Šˆ?ü)‚Ì”Ô?†‚Å‚Ì?A‚»‚Ì‹——£‚ð•Ô‚·	public double mottomo_tikai_senbun_kyori(Ten p)
                if (rs_min < d_hantei_haba) {
                    if (ori_s.getcolor(ori_s.mottomo_tikai_senbun_sagasi_gyakujyun(p)) < 3) {
                        ori_s.delsenbun_vertex(ori_s.mottomo_tikai_senbun_sagasi_gyakujyun(p));
                        en_seiri();
                        kiroku();
                    }
                }

            }


            if (i_sakujyo_mode == 2) { //?•‚Ì?Ü?ü‚Ì?í?œ

                //Ten p =new Ten(); p.set(camera.TV2object(p0));
                double rs_min;
                rs_min = ori_s.mottomo_tikai_senbun_kyori(p);//“_p‚É?Å‚à‹ß‚¢?ü•ª(?Ü?ü‚Æ•â?•Šˆ?ü)‚Ì”Ô?†‚Å‚Ì?A‚»‚Ì‹——£‚ð•Ô‚·	public double mottomo_tikai_senbun_kyori(Ten p)
                if (rs_min < d_hantei_haba) {
                    if (ori_s.getcolor(ori_s.mottomo_tikai_senbun_sagasi_gyakujyun(p)) == 0) {
                        ori_s.delsenbun_vertex(ori_s.mottomo_tikai_senbun_sagasi_gyakujyun(p));
                        en_seiri();
                        kiroku();
                    }
                }

            }

            if (i_sakujyo_mode == 3) {  //•â?•Šˆ?ü
                //Ten p =new Ten(); p.set(camera.TV2object(p0));
                double rs_min;
                rs_min = ori_s.mottomo_tikai_senbun_kyori(p);//“_p‚É?Å‚à‹ß‚¢?ü•ª(?Ü?ü‚Æ•â?•Šˆ?ü)‚Ì”Ô?†‚Å‚Ì?A‚»‚Ì‹——£‚ð•Ô‚·
                double re_min;
                re_min = ori_s.mottomo_tikai_en_kyori(p);//“_p‚É?Å‚à‹ß‚¢‰~‚Ì”Ô?†‚Å‚Ì?A‚»‚Ì‹——£‚ð•Ô‚·	public double mottomo_tikai_en_kyori(Ten p)


                if (rs_min <= re_min) {
                    if (rs_min < d_hantei_haba) {//“_p‚É?Å‚à‹ß‚¢?ü•ª‚Ì”Ô?†‚Å‚Ì?A‚»‚Ì‹——£‚ð•Ô‚·	public double mottomo_tikai_senbun_kyori(Ten p)
                        if (ori_s.getcolor(ori_s.mottomo_tikai_senbun_sagasi_gyakujyun(p)) == 3) {
                            ori_s.delsenbun_vertex(ori_s.mottomo_tikai_senbun_sagasi_gyakujyun(p));
                            en_seiri();
                            kiroku();
                        }
                    }
                } else {
                    if (re_min < d_hantei_haba) {
                        ori_s.delen(ori_s.mottomo_tikai_en_sagasi_gyakujyun(p));
                        en_seiri();
                        kiroku();
                    }
                }


            }

            if (i_sakujyo_mode == 1) { //•â?•ŠG?ü

                //Ten p =new Ten(); p.set(camera.TV2object(p0));
                double rs_min;
                rs_min = hoj_s.mottomo_tikai_senbun_kyori(p);//“_p‚É?Å‚à‹ß‚¢•â?•ŠG?ü‚Ì”Ô?†‚Å‚Ì?A‚»‚Ì‹——£‚ð•Ô‚·	public double mottomo_tikai_senbun_kyori(Ten p)

                if (rs_min < d_hantei_haba) {
                    hoj_s.delsenbun_vertex(hoj_s.mottomo_tikai_senbun_sagasi_gyakujyun(p));
                    //en_seiri();
                    kiroku();
                }

            }


        }


        //ŽlŠp˜g“à‚Ì?í?œ //p19_1‚Íselect‚Ì?Å?‰‚ÌTen?B‚±‚Ì?ðŒ?‚Í?Å?‰‚ÌTen‚Æ?ÅŒã‚Ì“_‚ª‰“‚¢‚Ì‚Å?AŽlŠp‚ð”­?¶‚³‚¹‚é‚Æ‚¢‚¤‚±‚Æ?B
        if (p19_1.kyori(p0) > 0.000001) {
            if ((i_orisen_hojyosen == 0) || (i_orisen_hojyosen == 4)) { //?Ü?ü‚Ì?í?œ	//D_nisuru(p19_1,p0)‚Å?Ü?ü‚¾‚¯‚ª?í?œ‚³‚ê‚é?B
                if (D_nisuru0(p19_1, p0) != 0) {
                    en_seiri();
                    kiroku();
                }
            }


            if (i_orisen_hojyosen == 2) {  //?•‚Ì?Ü?ü‚Ì‚Ý?í?œ
                if (D_nisuru2(p19_1, p0) != 0) {
                    en_seiri();
                    kiroku();
                }
            }


            if ((i_orisen_hojyosen == 3) || (i_orisen_hojyosen == 4)) {  //•â?•Šˆ?ü  //Œ»?ó‚Å‚Í?í?œ‚µ‚È‚¢‚Æ‚«‚àUNDO—p‚É‹L˜^‚³‚ê‚Ä‚µ‚Ü‚¤20161218
                if (D_nisuru3(p19_1, p0) != 0) {
                    en_seiri();
                    kiroku();
                }
            }

            if ((i_orisen_hojyosen == 1) || (i_orisen_hojyosen == 4)) { //•â?•ŠG?ü	//Œ»?ó‚Å‚Í?í?œ‚µ‚È‚¢‚Æ‚«‚àUNDO—p‚É‹L˜^‚³‚ê‚Ä‚µ‚Ü‚¤20161218
                if (D_nisuru1(p19_1, p0) != 0) {
                    kiroku();
                }
            }

        }

//qqqqqqqqqqqqqqqqqqqqqqqqqqqqq//System.out.println("= ");qqqqq
//check4(0.0001);//D_nisuru0‚ð‚·‚é‚Æ?Aori_s.D_nisuru0“à‚Åreset‚ªŽÀ?s‚³‚ê‚é‚½‚ß?Acheck4‚Ì‚â‚è’¼‚µ‚ª•K—v?B
        if (i_check1 == 1) {
            check1(0.001, 0.5);
        }
        if (i_check2 == 1) {
            check2(0.01, 0.5);
        }
        if (i_check3 == 1) {
            check3(0.0001);
        }
        if (i_check4 == 1) {
            check4(0.0001);
        }

    }

//--------------------

    public int D_nisuru(Ten p0a, Ten p0b) {
        Ten p0_a = new Ten();
        Ten p0_b = new Ten();
        Ten p0_c = new Ten();
        Ten p0_d = new Ten();
        Ten p_a = new Ten();
        Ten p_b = new Ten();
        Ten p_c = new Ten();
        Ten p_d = new Ten();
        p0_a.set(p0a.getx(), p0a.gety());
        p0_b.set(p0a.getx(), p0b.gety());
        p0_c.set(p0b.getx(), p0b.gety());
        p0_d.set(p0b.getx(), p0a.gety());
        p_a.set(camera.TV2object(p0_a));
        p_b.set(camera.TV2object(p0_b));
        p_c.set(camera.TV2object(p0_c));
        p_d.set(camera.TV2object(p0_d));
        return ori_s.D_nisuru(p_a, p_b, p_c, p_d);
    }
//--------------------

    public int D_nisuru0(Ten p0a, Ten p0b) {
        Ten p0_a = new Ten();
        Ten p0_b = new Ten();
        Ten p0_c = new Ten();
        Ten p0_d = new Ten();
        Ten p_a = new Ten();
        Ten p_b = new Ten();
        Ten p_c = new Ten();
        Ten p_d = new Ten();
        p0_a.set(p0a.getx(), p0a.gety());
        p0_b.set(p0a.getx(), p0b.gety());
        p0_c.set(p0b.getx(), p0b.gety());
        p0_d.set(p0b.getx(), p0a.gety());
        p_a.set(camera.TV2object(p0_a));
        p_b.set(camera.TV2object(p0_b));
        p_c.set(camera.TV2object(p0_c));
        p_d.set(camera.TV2object(p0_d));
        //System.out.println("(3_2_1)zzzzz ori_s.check4_size() = "+ori_s.check4_size());
        return ori_s.D_nisuru0(p_a, p_b, p_c, p_d);
    }
//--------------------

    public int D_nisuru2(Ten p0a, Ten p0b) {
        Ten p0_a = new Ten();
        Ten p0_b = new Ten();
        Ten p0_c = new Ten();
        Ten p0_d = new Ten();
        Ten p_a = new Ten();
        Ten p_b = new Ten();
        Ten p_c = new Ten();
        Ten p_d = new Ten();
        p0_a.set(p0a.getx(), p0a.gety());
        p0_b.set(p0a.getx(), p0b.gety());
        p0_c.set(p0b.getx(), p0b.gety());
        p0_d.set(p0b.getx(), p0a.gety());
        p_a.set(camera.TV2object(p0_a));
        p_b.set(camera.TV2object(p0_b));
        p_c.set(camera.TV2object(p0_c));
        p_d.set(camera.TV2object(p0_d));
        return ori_s.D_nisuru2(p_a, p_b, p_c, p_d);
    }

    //--------------------
    public int D_nisuru3(Ten p0a, Ten p0b) {
        Ten p0_a = new Ten();
        Ten p0_b = new Ten();
        Ten p0_c = new Ten();
        Ten p0_d = new Ten();
        Ten p_a = new Ten();
        Ten p_b = new Ten();
        Ten p_c = new Ten();
        Ten p_d = new Ten();
        p0_a.set(p0a.getx(), p0a.gety());
        p0_b.set(p0a.getx(), p0b.gety());
        p0_c.set(p0b.getx(), p0b.gety());
        p0_d.set(p0b.getx(), p0a.gety());
        p_a.set(camera.TV2object(p0_a));
        p_b.set(camera.TV2object(p0_b));
        p_c.set(camera.TV2object(p0_c));
        p_d.set(camera.TV2object(p0_d));
        return ori_s.D_nisuru3(p_a, p_b, p_c, p_d);
    }


//--------------------


    public int chenge_property_in_4kakukei(Ten p0a, Ten p0b) {
        Ten p0_a = new Ten();
        Ten p0_b = new Ten();
        Ten p0_c = new Ten();
        Ten p0_d = new Ten();
        Ten p_a = new Ten();
        Ten p_b = new Ten();
        Ten p_c = new Ten();
        Ten p_d = new Ten();
        p0_a.set(p0a.getx(), p0a.gety());
        p0_b.set(p0a.getx(), p0b.gety());
        p0_c.set(p0b.getx(), p0b.gety());
        p0_d.set(p0b.getx(), p0a.gety());
        p_a.set(camera.TV2object(p0_a));
        p_b.set(camera.TV2object(p0_b));
        p_c.set(camera.TV2object(p0_c));
        p_d.set(camera.TV2object(p0_d));
        return ori_s.chenge_property_in_4kakukei(p_a, p_b, p_c, p_d, sen_tokutyuu_color);
    }


//--------------------

    public int D_nisuru1(Ten p0a, Ten p0b) {
        Ten p0_a = new Ten();
        Ten p0_b = new Ten();
        Ten p0_c = new Ten();
        Ten p0_d = new Ten();
        Ten p_a = new Ten();
        Ten p_b = new Ten();
        Ten p_c = new Ten();
        Ten p_d = new Ten();
        p0_a.set(p0a.getx(), p0a.gety());
        p0_b.set(p0a.getx(), p0b.gety());
        p0_c.set(p0b.getx(), p0b.gety());
        p0_d.set(p0b.getx(), p0a.gety());
        p_a.set(camera.TV2object(p0_a));
        p_b.set(camera.TV2object(p0_b));
        p_c.set(camera.TV2object(p0_c));
        p_d.set(camera.TV2object(p0_d));
        return hoj_s.D_nisuru(p_a, p_b, p_c, p_d);
    }


    //59 59 59 59 59 59 59 59 59 59
    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==59 "“Á’?ƒvƒ?ƒpƒeƒBŽw’è" ‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ----------------------------------------------------
    public void mPressed_A_59(Ten p0) {
        mPressed_A_box_select(p0);   //?Ü?ü‚Æ•â?•Šˆ?ü‚Æ•â?•ŠG?ü
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==59 "“Á’?ƒvƒ?ƒpƒeƒBŽw’è"‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mDragged_A_59(Ten p0) {
        mDragged_A_box_select(p0);
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==59 "“Á’?ƒvƒ?ƒpƒeƒBŽw’è" ‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mReleased_A_59(Ten p0) {//•â?•Šˆ?ü‚Æ‰~
        i_egaki_dankai = 0;
        if (p19_1.kyori(p0) > 0.000001) {//Œ»?ó‚Å‚Í?í?œ‚µ‚È‚¢‚Æ‚«‚àUNDO—p‚É‹L˜^‚³‚ê‚Ä‚µ‚Ü‚¤20161218

            //if(D_nisuru3(p19_1,p0)!=0){en_seiri();kiroku();}
            if (chenge_property_in_4kakukei(p19_1, p0) != 0) {
                //kiroku();
            }

        }

        if (p19_1.kyori(p0) <= 0.000001) {
            //Ten p =new Ten();
            p.set(camera.TV2object(p0));
            double rs_min;
            rs_min = ori_s.mottomo_tikai_senbun_kyori(p);//“_p‚É?Å‚à‹ß‚¢•â?•Šˆ?ü‚Ì”Ô?†‚Å‚Ì?A‚»‚Ì‹——£‚ð•Ô‚·
            double re_min;
            re_min = ori_s.mottomo_tikai_en_kyori(p);//“_p‚É?Å‚à‹ß‚¢‰~‚Ì”Ô?†‚Å‚Ì?A‚»‚Ì‹——£‚ð•Ô‚·	public double mottomo_tikai_en_kyori(Ten p)


            if (rs_min <= re_min) {
                if (rs_min < d_hantei_haba) {//“_p‚É?Å‚à‹ß‚¢?ü•ª‚Ì”Ô?†‚Å‚Ì?A‚»‚Ì‹——£‚ð•Ô‚·	public double mottomo_tikai_senbun_kyori(Ten p)
                    if (ori_s.getcolor(ori_s.mottomo_tikai_senbun_sagasi_gyakujyun(p)) == 3) {
                        ori_s.set_tpp_sen(ori_s.mottomo_tikai_senbun_sagasi_gyakujyun(p), 1);
                        ori_s.set_tpp_sen_color(ori_s.mottomo_tikai_senbun_sagasi_gyakujyun(p), sen_tokutyuu_color);
                        //en_seiri();kiroku();
                    }
                }
            } else {
                if (re_min < d_hantei_haba) {
                    ori_s.set_tpp_en(ori_s.mottomo_tikai_en_sagasi_gyakujyun(p), 1);
                    ori_s.set_tpp_en_color(ori_s.mottomo_tikai_en_sagasi_gyakujyun(p), sen_tokutyuu_color);

//System.out.println("get_tpp_en="+ori_s.get_tpp_en(ori_s.mottomo_tikai_en_sagasi_gyakujyun(p)));


                    //en_seiri();kiroku();
                }
            }
        }

//ppppppppppp


    }

//--------------------


    //4 4 4 4 4 444444444444444444444444444444444444444444444444444444444
    public void mPressed_A_04(Ten p0) {
    }//ƒ}ƒEƒX‘€?ì(i_mouse_modeA==4?ü_•ÏŠ·?@‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ

    public void mDragged_A_04(Ten p0) {
    }//ƒ}ƒEƒX‘€?ì(i_mouse_modeA==4?ü_•ÏŠ·?@‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==4?ü_•ÏŠ·?@‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mReleased_A_04(Ten p0) {
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));


        if (ori_s.mottomo_tikai_senbun_kyori(p) < d_hantei_haba) {//“_p‚É?Å‚à‹ß‚¢?ü•ª‚Ì”Ô?†‚Å‚Ì?A‚»‚Ì‹——£‚ð•Ô‚·	public double mottomo_tikai_senbun_kyori(Ten p)
            int minrid;
            minrid = ori_s.mottomo_tikai_senbun_sagasi(p);
            int ic_temp;
            ic_temp = ori_s.getcolor(minrid);
            if (ic_temp < 3) {
                ic_temp = ic_temp + 1;
                if (ic_temp == 3) {
                    ic_temp = 0;
                }
                ori_s.setcolor(minrid, ic_temp);
                kiroku();
            }

        }




/*
		int minrid;double minr;
		minrid=ori_s.mottomo_tikai_senbun_sagasi(p);
		if(ori_s.senbun_busyo_sagasi(minrid, p, r)!=0){
			int ic_temp;
			ic_temp=ori_s.getcolor(minrid);
			ic_temp=ic_temp+1;if(ic_temp==3){ic_temp=0;}
			ori_s.setcolor(minrid,ic_temp);
		}
*/

    }

    //------
//58 58 58 58 58 58 58 58 58 58
    public void mPressed_A_58(Ten p0) {
        mPressed_A_box_select(p0);
    }//ƒ}ƒEƒX‘€?ì(i_mouse_modeA==58?ü_•ÏŠ·?@‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ

    public void mDragged_A_58(Ten p0) {
        mDragged_A_box_select(p0);
    }//ƒ}ƒEƒX‘€?ì(i_mouse_modeA==58?ü_•ÏŠ·?@‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==58?ü_•ÏŠ·?@‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mReleased_A_58(Ten p0) {//‚±‚±‚Ì?ˆ—?‚Ì?I‚í‚è‚É fix2(0.001,0.5);?@‚ð‚·‚é‚Ì‚Í?AŒ³‚©‚ç?Ü?ü‚¾‚Á‚½‚à‚Ì‚Æ?A•â?•?ü‚©‚ç•ÏŠ·‚µ‚½?Ü?ü‚Æ‚Ì‘g?‡‚¹‚Å•p”­‚·‚éTŽšŒ^•s?Ú‘±‚ð?C?³‚·‚é‚½‚ß
        i_egaki_dankai = 0;

        if (p19_1.kyori(p0) > 0.000001) {//
            if (MV_change(p19_1, p0) != 0) {
                fix2(0.001, 0.5);
                kiroku();
            }
        }


        if (p19_1.kyori(p0) <= 0.000001) {//
            //Ten p =new Ten();
            p.set(camera.TV2object(p0));
            if (ori_s.mottomo_tikai_senbun_kyori(p) < d_hantei_haba) {//“_p‚É?Å‚à‹ß‚¢?ü•ª‚Ì”Ô?†‚Å‚Ì?A‚»‚Ì‹——£‚ð•Ô‚·	public double mottomo_tikai_senbun_kyori(Ten p)
                int minrid;
                minrid = ori_s.mottomo_tikai_senbun_sagasi(p);
                int ic_temp;
                ic_temp = ori_s.getcolor(minrid);
                if (ic_temp == 1) {
                    ori_s.setcolor(minrid, 2);
                } else if (ic_temp == 2) {
                    ori_s.setcolor(minrid, 1);
                }

                fix2(0.001, 0.5);
                kiroku();
            }

        }
    }

    //------
    public int MV_change(Ten p0a, Ten p0b) {
        Ten p0_a = new Ten();
        Ten p0_b = new Ten();
        Ten p0_c = new Ten();
        Ten p0_d = new Ten();
        Ten p_a = new Ten();
        Ten p_b = new Ten();
        Ten p_c = new Ten();
        Ten p_d = new Ten();
        p0_a.set(p0a.getx(), p0a.gety());
        p0_b.set(p0a.getx(), p0b.gety());
        p0_c.set(p0b.getx(), p0b.gety());
        p0_d.set(p0b.getx(), p0a.gety());
        p_a.set(camera.TV2object(p0_a));
        p_b.set(camera.TV2object(p0_b));
        p_c.set(camera.TV2object(p0_c));
        p_d.set(camera.TV2object(p0_d));
        return ori_s.MV_change(p_a, p_b, p_c, p_d);
    }
//--------------------


    //30 30 30 30 30 30 30 30 30 30 30 30 ?œ‚¯_?ü_•ÏŠ·
    int minrid_30;

    public void mPressed_A_30(Ten p0) {    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==4?ü_•ÏŠ·?@‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        minrid_30 = -1;
        if (ori_s.mottomo_tikai_senbun_kyori(p) < d_hantei_haba) {//“_p‚É?Å‚à‹ß‚¢?ü•ª‚Ì”Ô?†‚Å‚Ì?A‚»‚Ì‹——£‚ð•Ô‚·	public double mottomo_tikai_senbun_kyori(Ten p)
            minrid_30 = ori_s.mottomo_tikai_senbun_sagasi(p);
            Senbun s01 = new Senbun();
            s01.set(oc.Senbun_bai(ori_s.get(minrid_30), 0.01));
            ori_s.setb(minrid_30, s01.getb());
        }
    }

    public void mDragged_A_30(Ten p0) {//ƒ}ƒEƒX‘€?ì(i_mouse_modeA==4?ü_•ÏŠ·?@‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
        if (minrid_30 > 0) {

            Senbun s01 = new Senbun();
            s01.set(oc.Senbun_bai(ori_s.get(minrid_30), 100.0));
            ori_s.setb(minrid_30, s01.getb());
            minrid_30 = -1;
        }

    }


    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==30 ?œ‚¯_?ü_•ÏŠ·?@‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”?i”wŒi‚É“WŠJ?}‚ª‚ ‚é?ê?‡—p?j
    public void mReleased_A_30(Ten p0) {
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));

        if (minrid_30 > 0) {

            Senbun s01 = new Senbun();
            s01.set(oc.Senbun_bai(ori_s.get(minrid_30), 100.0));
            ori_s.setb(minrid_30, s01.getb());

            int ic_temp;
            ic_temp = ori_s.getcolor(minrid_30);
            int is_temp;
            is_temp = ori_s.get_select(minrid_30);

            if ((ic_temp == 0) && (is_temp == 0)) {
                ori_s.set_select(minrid_30, 2);
            } else if ((ic_temp == 0) && (is_temp == 2)) {
                ori_s.setcolor(minrid_30, 1);
                ori_s.set_select(minrid_30, 0);
            } else if ((ic_temp == 1) && (is_temp == 0)) {
                ori_s.setcolor(minrid_30, 2);
            } else if ((ic_temp == 2) && (is_temp == 0)) {
                ori_s.setcolor(minrid_30, 0);
            }

            kiroku();
        }


    }
//------


//i_mouse_modeA;ƒ}ƒEƒX‚Ì“®?ì‚É‘Î‚·‚é”½‰ž‚ð‹K’è‚·‚é?B
// -------------1;?ü•ª“ü—Íƒ‚?[ƒh?B
//2;“WŠJ?}’²?®(ˆÚ“®)?B
//3;"L_del"
//4;"L_chan"

// -------------5;?ü•ª‰„’·ƒ‚?[ƒh?B
// -------------6;2“_‚©‚ç“™‹——£?ü•ªƒ‚?[ƒh?B
// -------------7;Šp“ñ“™•ª?üƒ‚?[ƒh?B
// -------------8;“à?Sƒ‚?[ƒh?B
// -------------9;?‚?ü‚¨‚ë‚µƒ‚?[ƒh?B
// -------------10;?Ü‚è•Ô‚µƒ‚?[ƒh?B
// -------------11;?ü•ª“ü—Íƒ‚?[ƒh?B
// -------------12;‹¾‰fƒ‚?[ƒh?B

//101:?Ü‚è?ã‚ª‚è?}‚Ì‘€?ì?B
//102;F_move
//103;S_face

//10001;test1 “ü—Í?€”õ‚Æ‚µ‚Ä“_‚ð‚R‚ÂŽw’è‚·‚é


//66666666666666666666    i_mouse_modeA==6?@;2“_‚©‚ç“™‹——£?ü•ªƒ‚?[ƒh

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ
    public void mPressed_A_06(Ten p0) {


        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        moyori_ten.set(get_moyori_ten(p));
        if (p.kyori(moyori_ten) < d_hantei_haba) {
            i_egaki_dankai = i_egaki_dankai + 1;
            s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
            s_step[i_egaki_dankai].setcolor(i_egaki_dankai);
        }


    }

    //ƒ}ƒEƒX‘€?ì(ƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mDragged_A_06(Ten p0) {
    }

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mReleased_A_06(Ten p0) {
        if (i_egaki_dankai == 3) {
            i_egaki_dankai = 0;
        }


    }

//------


//------?Ü‚è?ô‚Ý‰Â”\?ü“ü—Í


//38 38 38 38 38 38 38    i_mouse_modeA==38?@;?Ü‚è?ô‚Ý‰Â”\?ü“ü—Í  qqqqqqqqq


    int i_step_for38 = 0;

    //ƒ}ƒEƒX‘€?ì(ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”    //System.out.println("_");
    public void mMoved_A_38(Ten p0) {
        if (i_kou_mitudo_nyuuryoku == 1) {
            if (i_egaki_dankai == 0) {
                i_step_for38 = 0;
            }

            if (i_step_for38 == 0) {
                mMoved_A_29(p0);
            }

            if (i_step_for38 == 1) {
                s_kouho[1].setiactive(3);
                i_kouho_dankai = 0;
                //Ten p =new Ten();
                p.set(camera.TV2object(p0));

                moyori_senbun.set(get_moyori_step_senbun(p, 1, i_egaki_dankai));
                if ((i_egaki_dankai >= 2) && (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba)) {

                    i_kouho_dankai = 1;
                    s_kouho[1].set(moyori_senbun);//s_kouho[1].setcolor(2);
                    return;
                }
            }

            if (i_step_for38 == 2) {
                i_kouho_dankai = 0;
                Ten p = new Ten();
                p.set(camera.TV2object(p0));

                moyori_senbun.set(get_moyori_senbun(p));
                if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {//?ÅŠñ‚ÌŠù‘¶?Ü?ü‚ª‹ß‚¢?ê?‡
                    i_kouho_dankai = 1;
                    s_kouho[1].set(moyori_senbun);
                    //s_kouho[1].setcolor(2);
                    return;
                }

            }
        }
    }


    //Ten t1 =new Ten();
//ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ
    public void mPressed_A_38(Ten p0) {
        i_kouho_dankai = 0;
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        if (i_egaki_dankai == 0) {
            i_step_for38 = 0;
        }

        if (i_step_for38 == 0) {
            double hantei_kyori = 0.000001;

            Ten t1 = new Ten();
            t1.set(ori_s.mottomo_tikai_Ten_with_icol_0_1_2(p));//“_p‚É?Å‚à‹ß‚¢?A?u?ü•ª‚Ì’[“_?v‚ð•Ô‚·ori_s.mottomo_tikai_Ten‚Í‹ß‚¢“_‚ª‚È‚¢‚Æ p_return.set(100000.0,100000.0)‚Æ•Ô‚µ‚Ä‚­‚é

            if (p.kyori(t1) < d_hantei_haba) {
                //i_egaki_dankai=i_egaki_dankai+1;
                //s_step[i_egaki_dankai].set(moyori_ten,moyori_ten);s_step[i_egaki_dankai].setcolor(i_egaki_dankai);

                //t1‚ð’[“_‚Æ‚·‚é?Ü?ü‚ðNarabebako‚É“ü‚ê‚é
                Narabebako_int_double nbox = new Narabebako_int_double();
                for (int i = 1; i <= ori_s.getsousuu(); i++) {
                    if ((0 <= ori_s.getcolor(i)) && (ori_s.getcolor(i) <= 2)) {
                        if (t1.kyori(ori_s.geta(i)) < hantei_kyori) {
                            nbox.ire_i_tiisaijyun(new int_double(i, oc.kakudo(ori_s.geta(i), ori_s.getb(i))));
                        } else if (t1.kyori(ori_s.getb(i)) < hantei_kyori) {
                            nbox.ire_i_tiisaijyun(new int_double(i, oc.kakudo(ori_s.getb(i), ori_s.geta(i))));
                        }
                    }
                }

                //System.out.println("20170126_4");

                if (nbox.getsousuu() % 2 == 1) {//t1‚ð’[“_‚Æ‚·‚é?Ü?ü‚Ì?”‚ªŠï?”‚Ì‚Æ‚«‚¾‚¯if{}“à‚Ì?ˆ—?‚ð‚·‚é
                    icol_temp = icol;
                    if (nbox.getsousuu() == 1) {
                        icol_temp = ori_s.get(nbox.get_int(1)).getcolor();
                    }//20180503‚±‚Ì?s’Ç‰Á?B‚±‚ê‚Í?A?Ü?ü‚ª1–{‚¾‚¯‚Ì’¸“_‚©‚ç?Ü‚è?ô‚Ý‰Â”\?ü’Ç‰Á‹@”\‚Å?A‚»‚Ì?Ü?ü‚Ì‰„’·‚ð?s‚Á‚½?ê?‡‚É?A?ü‚Ì?F‚ð‰„’·‘O‚Ì?Ü?ü‚Æ?‡‚í‚¹‚é‚½‚ß

                    //int i_kouho_suu=0;
                    for (int i = 1; i <= nbox.getsousuu(); i++) {//i‚ÍŠp‰ÁŒ¸’l‚ð‹?‚ß‚é?Å?‰‚Ì?Ü?ü‚Ìid
                        //?Ü?ü‚ªŠï?”‚Ì’¸“_Žü‚è‚ÌŠp‰ÁŒ¸’l‚ð2.0‚ÅŠ„‚é‚ÆŠp‰ÁŒ¸’l‚Ì?Å?‰?Ü?ü‚Æ?A?Ü‚è?ô‚Ý‰Â”\‚É‚·‚é‚½‚ß‚Ì’Ç‰Á‚Ì?Ü?ü‚Æ‚ÌŠp“x‚É‚È‚é?B
                        double kakukagenti = 0.0;
                        //System.out.println("nbox.getsousuu()="+nbox.getsousuu());
                        int tikai_orisen_jyunban;
                        int tooi_orisen_jyunban;
                        for (int k = 1; k <= nbox.getsousuu(); k++) {//k‚ÍŠp‰ÁŒ¸’l‚ð‹?‚ß‚éŠp“x‚Ì?‡”Ô
                            tikai_orisen_jyunban = i + k - 1;
                            if (tikai_orisen_jyunban > nbox.getsousuu()) {
                                tikai_orisen_jyunban = tikai_orisen_jyunban - nbox.getsousuu();
                            }
                            tooi_orisen_jyunban = i + k;
                            if (tooi_orisen_jyunban > nbox.getsousuu()) {
                                tooi_orisen_jyunban = tooi_orisen_jyunban - nbox.getsousuu();
                            }

                            double add_kakudo = oc.kakudo_osame_0_360(nbox.get_double(tooi_orisen_jyunban) - nbox.get_double(tikai_orisen_jyunban));
                            if (k % 2 == 1) {
                                kakukagenti = kakukagenti + add_kakudo;
                            } else if (k % 2 == 0) {
                                kakukagenti = kakukagenti - add_kakudo;
                            }
                            //System.out.println("i="+i+"   k="+k);


                        }


                        if (nbox.getsousuu() == 1) {
                            kakukagenti = 360.0;
                        }

                        //System.out.println("kakukagenti="+kakukagenti);
                        //ƒ`ƒFƒbƒN—p‚ÉŠp‰ÁŒ¸’l‚Ì?Å?‰‚ÌŠp“x‚Ì’†‚Ékakukagenti/2.0‚ª‚ ‚é‚©‚ðŠm”F‚·‚é
                        tikai_orisen_jyunban = i;
                        if (tikai_orisen_jyunban > nbox.getsousuu()) {
                            tikai_orisen_jyunban = tikai_orisen_jyunban - nbox.getsousuu();
                        }
                        tooi_orisen_jyunban = i + 1;
                        if (tooi_orisen_jyunban > nbox.getsousuu()) {
                            tooi_orisen_jyunban = tooi_orisen_jyunban - nbox.getsousuu();
                        }

                        double add_kakudo_1 = oc.kakudo_osame_0_360(nbox.get_double(tooi_orisen_jyunban) - nbox.get_double(tikai_orisen_jyunban));
                        if (nbox.getsousuu() == 1) {
                            add_kakudo_1 = 360.0;
                        }

                        if ((kakukagenti / 2.0 > 0.0 + 0.000001) && (kakukagenti / 2.0 < add_kakudo_1 - 0.000001)) {
                            //if((kakukagenti/2.0>0.0-0.000001)&&(kakukagenti/2.0<add_kakudo_1+0.000001)){

                            i_egaki_dankai = i_egaki_dankai + 1;

                            //?ü•ªab‚ða‚ð’†?S‚Éd“x‰ñ“]‚µ‚½?ü•ª‚ð•Ô‚·ŠÖ?”?iŒ³‚Ì?ü•ª‚Í•Ï‚¦‚¸‚É?V‚µ‚¢?ü•ª‚ð•Ô‚·?jpublic oc.Senbun_kaiten(Senbun s0,double d)
                            Senbun s_kiso = new Senbun();
                            if (t1.kyori(ori_s.geta(nbox.get_int(i))) < hantei_kyori) {
                                s_kiso.set(ori_s.geta(nbox.get_int(i)), ori_s.getb(nbox.get_int(i)));
                            } else if (t1.kyori(ori_s.getb(nbox.get_int(i))) < hantei_kyori) {
                                s_kiso.set(ori_s.getb(nbox.get_int(i)), ori_s.geta(nbox.get_int(i)));
                            }

                            double s_kiso_nagasa = s_kiso.getnagasa();

                            s_step[i_egaki_dankai].set(oc.Senbun_kaiten(s_kiso, kakukagenti / 2.0, kus.d_haba() / s_kiso_nagasa));
                            s_step[i_egaki_dankai].setcolor(8);
                            s_step[i_egaki_dankai].setiactive(0);
                        }
                    }
                    if (i_egaki_dankai == 1) {
                        i_step_for38 = 2;
                    }
                    if (i_egaki_dankai > 1) {
                        i_step_for38 = 1;
                    }
                }
            }
            return;
        }

        if (i_step_for38 == 1) {
            moyori_senbun.set(get_moyori_step_senbun(p, 1, i_egaki_dankai));
            if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {
                i_step_for38 = 2;
                i_egaki_dankai = 1;
                s_step[1].set(moyori_senbun);

                //i_egaki_dankai=i_egaki_dankai+1;
                //s_step[i_egaki_dankai].set(moyori_senbun);//s_step[i_egaki_dankai].setcolor(i_egaki_dankai);
                //s_step[i_egaki_dankai].setcolor(8);
                return;
            }
            if (oc.kyori_senbun(p, moyori_senbun) >= d_hantei_haba) {
                i_egaki_dankai = 0;
                return;
            }
        }

        if (i_step_for38 == 2) {
            moyori_senbun.set(get_moyori_senbun(p));
            //Senbun moyori_step_senbun =new Senbun(get_moyori_step_senbun(p,1,i_egaki_dankai));
            Senbun moyori_step_senbun = new Senbun();
            moyori_step_senbun.set(get_moyori_step_senbun(p, 1, i_egaki_dankai));
            if (oc.kyori_senbun(p, moyori_senbun) >= d_hantei_haba) {//?ÅŠñ‚ÌŠù‘¶?Ü?ü‚ª‰“‚­‚Ä‘I‘ð–³Œø‚Ì?ê?‡
                //moyori_senbun.set(get_moyori_step_senbun(p,1,i_egaki_dankai));
                if (oc.kyori_senbun(p, moyori_step_senbun) < d_hantei_haba) {//?ÅŠñ‚Ìstep_senbun‚ª‹ß‚¢?ê?‡
//System.out.println("20170129_1");
                    return;
                }

                //?ÅŠñ‚Ìstep_senbun‚ª‰“‚¢?ê?‡
//System.out.println("20170129_2");

                i_egaki_dankai = 0;
                return;
            }

            if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {//?ÅŠñ‚ÌŠù‘¶?Ü?ü‚ª‹ß‚¢?ê?‡

                s_step[2].set(moyori_senbun);
                s_step[2].setcolor(6);

//System.out.println("20170129_3");
                Ten kousa_ten = new Ten();
                kousa_ten.set(oc.kouten_motome(s_step[1], s_step[2]));
                Senbun add_sen = new Senbun(kousa_ten, s_step[1].geta(), icol_temp);//20180503•Ï?X
                if (add_sen.getnagasa() > 0.00000001) {//?ÅŠñ‚ÌŠù‘¶?Ü?ü‚ª—LŒø‚Ì?ê?‡
                    addsenbun(add_sen);
                    kiroku();
                    i_egaki_dankai = 0;
                    return;

                }

                //?ÅŠñ‚ÌŠù‘¶?Ü?ü‚ª–³Œø‚Ì?ê?‡

                //?ÅŠñ‚Ìstep_senbun‚ª‹ß‚¢?ê?‡
                if (oc.kyori_senbun(p, moyori_step_senbun) < d_hantei_haba) {
                    return;
                }

                //?ÅŠñ‚Ìstep_senbun‚ª‰“‚¢?ê?‡
                i_egaki_dankai = 0;
                return;

            }
        }


    }

    //ƒ}ƒEƒX‘€?ì(ƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mDragged_A_38(Ten p0) {
    }

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mReleased_A_38(Ten p0) {

    }


//------?Ü‚è?ô‚Ý‰Â”\?ü+ŠiŽq“_Œn“ü—Í


    //39 39 39 39 39 39 39    i_mouse_modeA==39?@;?Ü‚è?ô‚Ý‰Â”\?ü“ü—Í  qqqqqqqqq
    int i_step_for39 = 0;//i_step_for39=2‚Ì?ê?‡‚Í?Astep?ü‚ª1–{‚¾‚¯‚É‚È‚Á‚Ä‚¢‚Ä?AŽŸ‚Ì‘€?ì‚Å“ü—Í?Ü?ü‚ªŠm’è‚·‚é?ó‘Ô
//
//‰Û‘è?@step?ü‚ÆŠù‘¶?Ü?ü‚ª•½?s‚ÌŽžƒGƒ‰?[•ûŒü‚É?ü‚ðˆø‚­‚±‚Æ‚ð‰ü‘P‚·‚é‚±‚Æ20170407
//
//“®?ìŽd—l
//?i‚P?j“_‚ð‘I‘ð?iŠù‘¶“_‘I‘ð‹K?§?j
//?i‚Qa?j‘I‘ð“_‚ª3ˆÈ?ã‚ÌŠï?”?Ü?ü‚Ì’¸“_‚Ì?ê?‡
//?i‚R?j
//
//
//?i‚Qb?j‚QaˆÈŠO‚Ì?ê?‡
//
//Ten t1 =new Ten();


    //ƒ}ƒEƒX‘€?ì(ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”    //System.out.println("_");
    public void mMoved_A_39(Ten p0) {
        if (i_egaki_dankai == 0) {
            i_step_for39 = 0;
        }
        if (i_kou_mitudo_nyuuryoku == 1) {
            i_kouho_dankai = 0;
            //Ten p =new Ten();
            p.set(camera.TV2object(p0));

            if (i_egaki_dankai == 0) {
                i_step_for39 = 0;
            }
            System.out.println("i_egaki_dankai= " + i_egaki_dankai + "  ;   i_step_for39= " + i_step_for39);

            if (i_step_for39 == 0) {
                mMoved_A_29(p0);
			/*	double hantei_kyori=0.000001;
				//”CˆÓ‚Ì“_‚ª—^‚¦‚ç‚ê‚½‚Æ‚«?A’[“_‚à‚µ‚­‚ÍŠiŽq“_‚Å?Å‚à‹ß‚¢“_‚ð“¾‚é
				moyori_ten.set(get_moyori_ten(p));
				if(p.kyori(moyori_ten)<d_hantei_haba){
					i_kouho_dankai=1;
					s_kouho[1].set(moyori_ten,moyori_ten);
				 	s_kouho[1].setcolor(icol);
				}
				return;
			*/
            }

            if (i_step_for39 == 1) {
                moyori_senbun.set(get_moyori_step_senbun(p, 1, i_egaki_dankai));
                if ((i_egaki_dankai >= 2) && (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba)) {
                    //System.out.println("20170129_5");
                    i_kouho_dankai = 1;
                    s_kouho[1].set(moyori_senbun);//s_kouho[1].setcolor(2);
                    return;
                }

                moyori_ten.set(get_moyori_ten(p));
                if (p.kyori(moyori_ten) < d_hantei_haba) {
                    //s_kouho[1].setb(moyori_ten);s_kouho[1].setcolor(2);
                    s_kouho[1].set(moyori_ten, moyori_ten);
                    s_kouho[1].setcolor(icol);
                    i_kouho_dankai = 1;
                    return;
                }
                return;
            }


            if (i_step_for39 == 2) {//i_step_for39==2‚Å‚ ‚ê‚Î?AˆÈ‰º‚Ås_step[1]‚ð“ü—Í?Ü?ü‚ðŠm’è‚·‚é
                moyori_ten.set(get_moyori_ten(p));

                if (moyori_ten.kyori(s_step[1].geta()) < 0.00000001) {
                    i_kouho_dankai = 1;
                    s_kouho[1].set(moyori_ten, moyori_ten);
                    s_kouho[1].setcolor(icol);
                    System.out.println("i_step_for39_2_   1");

                    return;


                }


                if ((p.kyori(s_step[1].getb()) < d_hantei_haba) && (p.kyori(s_step[1].getb()) <= p.kyori(moyori_ten))) {
                    i_kouho_dankai = 1;
                    s_kouho[1].set(s_step[1].getb(), s_step[1].getb());
                    s_kouho[1].setcolor(icol);
                    System.out.println("i_step_for39_2_   2");

                    return;
                }


                if (p.kyori(moyori_ten) < d_hantei_haba) {
                    i_kouho_dankai = 1;
                    s_kouho[1].set(moyori_ten, moyori_ten);
                    s_kouho[1].setcolor(icol);
                    System.out.println("i_step_for39_2_   3");

                    return;
                }

                moyori_senbun.set(get_moyori_senbun(p));
                Senbun moyori_step_senbun = new Senbun();
                moyori_step_senbun.set(get_moyori_step_senbun(p, 1, i_egaki_dankai));
                if (oc.kyori_senbun(p, moyori_senbun) >= d_hantei_haba) {//?ÅŠñ‚ÌŠù‘¶?Ü?ü‚ª‰“‚¢?ê?‡
                    if (oc.kyori_senbun(p, moyori_step_senbun) < d_hantei_haba) {//?ÅŠñ‚Ìstep_senbun‚ª‹ß‚¢?ê?‡
                        return;
                    }
                    //?ÅŠñ‚Ìstep_senbun‚ª‰“‚¢?ê?‡
                    System.out.println("i_step_for39_2_   4");

                    return;
                }

                if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {//?ÅŠñ‚ÌŠù‘¶?Ü?ü‚ª‹ß‚¢?ê?‡
                    i_kouho_dankai = 1;
                    s_kouho[1].set(moyori_senbun);
                    s_kouho[1].setcolor(icol);

                    System.out.println("i_step_for39_2_   5");
                    return;
                }
                return;
            }

            return;
        }
    }


    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ--------------
    public void mPressed_A_39(Ten p0) {
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));

        if (i_egaki_dankai == 0) {
            i_step_for39 = 0;
        }


        //if(i_egaki_dankai==0){i_step_for39=0;}

        if (i_step_for39 == 0) {
            double hantei_kyori = 0.000001;

            //”CˆÓ‚Ì“_‚ª—^‚¦‚ç‚ê‚½‚Æ‚«?A’[“_‚à‚µ‚­‚ÍŠiŽq“_‚Å?Å‚à‹ß‚¢“_‚ð“¾‚é
            moyori_ten.set(get_moyori_ten(p));

            if (p.kyori(moyori_ten) < d_hantei_haba) {
                //i_egaki_dankai=i_egaki_dankai+1;
                //s_step[i_egaki_dankai].set(moyori_ten,moyori_ten);s_step[i_egaki_dankai].setcolor(i_egaki_dankai);

                //moyori_ten‚ð’[“_‚Æ‚·‚é?Ü?ü‚ðNarabebako‚É“ü‚ê‚é
                Narabebako_int_double nbox = new Narabebako_int_double();
                for (int i = 1; i <= ori_s.getsousuu(); i++) {
                    if ((0 <= ori_s.getcolor(i)) && (ori_s.getcolor(i) <= 2)) {
                        if (moyori_ten.kyori(ori_s.geta(i)) < hantei_kyori) {
                            nbox.ire_i_tiisaijyun(new int_double(i, oc.kakudo(ori_s.geta(i), ori_s.getb(i))));
                        } else if (moyori_ten.kyori(ori_s.getb(i)) < hantei_kyori) {
                            nbox.ire_i_tiisaijyun(new int_double(i, oc.kakudo(ori_s.getb(i), ori_s.geta(i))));
                        }
                    }
                }
                //System.out.println("nbox.getsousuu()="+nbox.getsousuu());
                if (nbox.getsousuu() % 2 == 1) {//moyori_ten‚ð’[“_‚Æ‚·‚é?Ü?ü‚Ì?”‚ªŠï?”‚Ì‚Æ‚«‚¾‚¯if{}“à‚Ì?ˆ—?‚ð‚·‚é
                    //System.out.println("20170130_3");

                    //int i_kouho_suu=0;
                    for (int i = 1; i <= nbox.getsousuu(); i++) {//i‚ÍŠp‰ÁŒ¸’l‚ð‹?‚ß‚é?Å?‰‚Ì?Ü?ü‚Ìid
                        //?Ü?ü‚ªŠï?”‚Ì’¸“_Žü‚è‚ÌŠp‰ÁŒ¸’l‚ð2.0‚ÅŠ„‚é‚ÆŠp‰ÁŒ¸’l‚Ì?Å?‰?Ü?ü‚Æ?A?Ü‚è?ô‚Ý‰Â”\‚É‚·‚é‚½‚ß‚Ì’Ç‰Á‚Ì?Ü?ü‚Æ‚ÌŠp“x‚É‚È‚é?B
                        double kakukagenti = 0.0;
                        //System.out.println("nbox.getsousuu()="+nbox.getsousuu());
                        int tikai_orisen_jyunban;
                        int tooi_orisen_jyunban;
                        for (int k = 1; k <= nbox.getsousuu(); k++) {//k‚ÍŠp‰ÁŒ¸’l‚ð‹?‚ß‚éŠp“x‚Ì?‡”Ô
                            tikai_orisen_jyunban = i + k - 1;
                            if (tikai_orisen_jyunban > nbox.getsousuu()) {
                                tikai_orisen_jyunban = tikai_orisen_jyunban - nbox.getsousuu();
                            }
                            tooi_orisen_jyunban = i + k;
                            if (tooi_orisen_jyunban > nbox.getsousuu()) {
                                tooi_orisen_jyunban = tooi_orisen_jyunban - nbox.getsousuu();
                            }

                            double add_kakudo = oc.kakudo_osame_0_360(nbox.get_double(tooi_orisen_jyunban) - nbox.get_double(tikai_orisen_jyunban));
                            if (k % 2 == 1) {
                                kakukagenti = kakukagenti + add_kakudo;
                            } else if (k % 2 == 0) {
                                kakukagenti = kakukagenti - add_kakudo;
                            }
                            //System.out.println("i="+i+"   k="+k);
                        }

                        if (nbox.getsousuu() == 1) {
                            kakukagenti = 360.0;
                        }
                        //System.out.println("kakukagenti="+kakukagenti);
                        //ƒ`ƒFƒbƒN—p‚ÉŠp‰ÁŒ¸’l‚Ì?Å?‰‚ÌŠp“x‚Ì’†‚Ékakukagenti/2.0‚ª‚ ‚é‚©‚ðŠm”F‚·‚é
                        tikai_orisen_jyunban = i;
                        if (tikai_orisen_jyunban > nbox.getsousuu()) {
                            tikai_orisen_jyunban = tikai_orisen_jyunban - nbox.getsousuu();
                        }
                        tooi_orisen_jyunban = i + 1;
                        if (tooi_orisen_jyunban > nbox.getsousuu()) {
                            tooi_orisen_jyunban = tooi_orisen_jyunban - nbox.getsousuu();
                        }

                        double add_kakudo_1 = oc.kakudo_osame_0_360(nbox.get_double(tooi_orisen_jyunban) - nbox.get_double(tikai_orisen_jyunban));
                        if (nbox.getsousuu() == 1) {
                            add_kakudo_1 = 360.0;
                        }

                        if ((kakukagenti / 2.0 > 0.0 + 0.000001) && (kakukagenti / 2.0 < add_kakudo_1 - 0.000001)) {
                            i_egaki_dankai = i_egaki_dankai + 1;

                            //?ü•ªab‚ða‚ð’†?S‚Éd“x‰ñ“]‚µ‚½?ü•ª‚ð•Ô‚·ŠÖ?”?iŒ³‚Ì?ü•ª‚Í•Ï‚¦‚¸‚É?V‚µ‚¢?ü•ª‚ð•Ô‚·?jpublic oc.Senbun_kaiten(Senbun s0,double d)
                            Senbun s_kiso = new Senbun();
                            if (moyori_ten.kyori(ori_s.geta(nbox.get_int(i))) < hantei_kyori) {
                                s_kiso.set(ori_s.geta(nbox.get_int(i)), ori_s.getb(nbox.get_int(i)));
                            } else if (moyori_ten.kyori(ori_s.getb(nbox.get_int(i))) < hantei_kyori) {
                                s_kiso.set(ori_s.getb(nbox.get_int(i)), ori_s.geta(nbox.get_int(i)));
                            }

                            double s_kiso_nagasa = s_kiso.getnagasa();

                            s_step[i_egaki_dankai].set(oc.Senbun_kaiten(s_kiso, kakukagenti / 2.0, kus.d_haba() / s_kiso_nagasa));
                            s_step[i_egaki_dankai].setcolor(8);
                            s_step[i_egaki_dankai].setiactive(1);

                        }

                    }
                    //if(i_kouho_suu==1){i_step_for39=2;}
                    //if(i_kouho_suu>1){i_step_for39=1;}

                    if (i_egaki_dankai == 1) {
                        i_step_for39 = 2;
                    }
                    if (i_egaki_dankai > 1) {
                        i_step_for39 = 1;
                    }
                }

                if (i_egaki_dankai == 0) {//?Ü?ô‚Ý‰Â”\‰»?ü‚ª‚È‚¢?ê?‡//System.out.println("_");
                    i_egaki_dankai = 1;
                    i_step_for39 = 1;
                    s_step[1].set(moyori_ten, moyori_ten);
                    s_step[1].setcolor(8);
                    s_step[1].setiactive(3);
                }

            }
            return;
        }


        if (i_step_for39 == 1) {
            moyori_senbun.set(get_moyori_step_senbun(p, 1, i_egaki_dankai));
            if ((i_egaki_dankai >= 2) && (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba)) {
                //if(oc.kyori_senbun( p,moyori_senbun)<d_hantei_haba){
                //System.out.println("20170129_5");
                i_step_for39 = 2;
                i_egaki_dankai = 1;
                s_step[1].set(moyori_senbun);
                return;
            }
            //if(oc.kyori_senbun( p,moyori_senbun)>=d_hantei_haba){
            //System.out.println("");
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                s_step[1].setb(moyori_ten);
                i_step_for39 = 2;
                i_egaki_dankai = 1;
                return;
            }
            //System.out.println("20170129_7");
            i_egaki_dankai = 0;
            i_kouho_dankai = 0;
            return;
            //}
            //return;
        }


        if (i_step_for39 == 2) {//i_step_for39==2‚Å‚ ‚ê‚Î?AˆÈ‰º‚Ås_step[1]‚ð“ü—Í?Ü?ü‚ðŠm’è‚·‚é
            moyori_ten.set(get_moyori_ten(p));

            //System.out.println("20170130_1");
            if (moyori_ten.kyori(s_step[1].geta()) < 0.00000001) {
                i_egaki_dankai = 0;
                i_kouho_dankai = 0;
                return;
            }
            //else if(p.kyori(s_step[1].getb())< kus.d_haba()/10.0 ){
            //else if(p.kyori(s_step[1].getb())< d_hantei_haba/2.5 ){
            //else if(p.kyori(s_step[1].getb())< d_hantei_haba ){

            if ((p.kyori(s_step[1].getb()) < d_hantei_haba) &&
                    (
                            p.kyori(s_step[1].getb()) <= p.kyori(moyori_ten)
                            //moyori_ten.kyori(s_step[1].getb())<0.00000001
                    )) {
                Senbun add_sen = new Senbun(s_step[1].geta(), s_step[1].getb(), icol);
                addsenbun(add_sen);
                kiroku();
                i_egaki_dankai = 0;
                i_kouho_dankai = 0;
                return;
            }

            //}


            //if(i_step_for39==2){

            //moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                s_step[1].setb(moyori_ten);
                return;
            }


            moyori_senbun.set(get_moyori_senbun(p));

            Senbun moyori_step_senbun = new Senbun();
            moyori_step_senbun.set(get_moyori_step_senbun(p, 1, i_egaki_dankai));
            if (oc.kyori_senbun(p, moyori_senbun) >= d_hantei_haba) {//?ÅŠñ‚ÌŠù‘¶?Ü?ü‚ª‰“‚¢?ê?‡
                //moyori_senbun.set(get_moyori_step_senbun(p,1,i_egaki_dankai));


                //moyori_ten.set(get_moyori_ten(p));if(p.kyori(moyori_ten)<d_hantei_haba){s_step[1].setb(moyori_ten);return;}
                //moyori_ten.set(ori_s.mottomo_tikai_Ten(p));if(p.kyori(moyori_ten)<d_hantei_haba){s_step[1].setb(moyori_ten);return;}


                if (oc.kyori_senbun(p, moyori_step_senbun) < d_hantei_haba) {//?ÅŠñ‚Ìstep_senbun‚ª‹ß‚¢?ê?‡

                    //moyori_ten.set(get_moyori_ten(p));if(p.kyori(moyori_ten)<d_hantei_haba){s_step[1].setb(moyori_ten);return;}


                    return;
                }
                //?ÅŠñ‚Ìstep_senbun‚ª‰“‚¢?ê?‡

                //moyori_ten.set(get_moyori_ten(p));if(p.kyori(moyori_ten)<d_hantei_haba){s_step[1].setb(moyori_ten);return;}
                i_egaki_dankai = 0;
                i_kouho_dankai = 0;
                return;
            }

            if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {//?ÅŠñ‚ÌŠù‘¶?Ü?ü‚ª‹ß‚¢?ê?‡
                //moyori_ten.set(ori_s.mottomo_tikai_Ten(p));if(p.kyori(moyori_ten)<d_hantei_haba){s_step[1].setb(moyori_ten);return;}
                s_step[2].set(moyori_senbun);
                s_step[2].setcolor(6);
                //System.out.println("20170129_3");
                Ten kousa_ten = new Ten();
                kousa_ten.set(oc.kouten_motome(s_step[1], s_step[2]));
                Senbun add_sen = new Senbun(kousa_ten, s_step[1].geta(), icol);
                if (add_sen.getnagasa() > 0.00000001) {//?ÅŠñ‚ÌŠù‘¶?Ü?ü‚ª—LŒø‚Ì?ê?‡
                    addsenbun(add_sen);
                    kiroku();
                    i_egaki_dankai = 0;
                    i_kouho_dankai = 0;
                    return;
                }
                //?ÅŠñ‚ÌŠù‘¶?Ü?ü‚ª–³Œø‚Ì?ê?‡
                moyori_ten.set(get_moyori_ten(p));
                if (p.kyori(moyori_ten) < d_hantei_haba) {
                    s_step[1].setb(moyori_ten);
                    return;
                }
                //?ÅŠñ‚Ìstep_senbun‚ª‹ß‚¢?ê?‡
                if (oc.kyori_senbun(p, moyori_step_senbun) < d_hantei_haba) {
                    return;
                }
                //?ÅŠñ‚Ìstep_senbun‚ª‰“‚¢?ê?‡
                i_egaki_dankai = 0;
                i_kouho_dankai = 0;
                return;

            }
            return;
        }


    }

    //ƒ}ƒEƒX‘€?ì(ƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mDragged_A_39(Ten p0) {
    }

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mReleased_A_39(Ten p0) {

    }


//33 33 33 33 33 33 33 33 33 33 33‹›‚Ì?œ


    //ƒ}ƒEƒX‘€?ì(ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mMoved_A_33(Ten p0) {
        mMoved_A_11(p0);
    }//‹ß‚¢Šù‘¶“_‚Ì‚Ý•\Ž¦


    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==33‹›‚Ì?œ?@‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ----------------------------------------------------
    public void mPressed_A_33(Ten p0) {
        i_egaki_dankai = 1;

        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        moyori_ten.set(get_moyori_ten(p));
        if (p.kyori(moyori_ten) > d_hantei_haba) {
            i_egaki_dankai = 0;
        }
        s_step[1].set(p, moyori_ten);
        s_step[1].setcolor(icol);
        //k.addsenbun(p,p);
        //ieda=k.getsousuu();
        //k.setcolor(ieda,icol);
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==33‹›‚Ì?œ?@‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mDragged_A_33(Ten p0) {
        mDragged_A_11(p0);
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==33‹›‚Ì?œ?@‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mReleased_A_33(Ten p0) {
        if (i_egaki_dankai == 1) {
            i_egaki_dankai = 0;

            //s_step[1]‚ðŠm’è‚·‚é
            //Ten p =new Ten();
            p.set(camera.TV2object(p0));
            moyori_ten.set(get_moyori_ten(p));
            s_step[1].seta(moyori_ten);
            //s_step[1]‚ðŠm’è?I—¹


            if (p.kyori(moyori_ten) <= d_hantei_haba) {  //ƒ}ƒEƒX‚ÅŽw’è‚µ‚½“_‚ª?A?ÅŠñ“_‚Æ‹ß‚©‚Á‚½‚Æ‚«‚ÉŽÀŽ{
                if (s_step[1].getnagasa() > 0.00000001) {  //s_step[1]‚ª?A?ü‚ÌŽž?i=“_?ó‚Å‚Í‚È‚¢Žž?j‚ÉŽÀŽ{
                    double dx = (s_step[1].getax() - s_step[1].getbx()) * kus.d_haba() / s_step[1].getnagasa();
                    double dy = (s_step[1].getay() - s_step[1].getby()) * kus.d_haba() / s_step[1].getnagasa();
                    int icol_temp = icol;
                    //int imax=;

                    Ten pxy = new Ten();
                    for (int i = 0; i <= (int) Math.floor(s_step[1].getnagasa() / kus.d_haba()); i++) {

                        //System.out.println("_"+i);
                        double px = s_step[1].getbx() + (double) i * dx;
                        double py = s_step[1].getby() + (double) i * dy;
                        pxy.set(px, py);


                        //if(pxy.kyori(ori_s.mottomo_tikai_Ten(pxy) )>0.001      )         {
                        if (ori_s.mottomo_tikai_senbun_kyori_heikou_jyogai(pxy, s_step[1]) > 0.001) {

                            int i_sen = 0;

                            Senbun adds = new Senbun(px, py, px - dy, py + dx);
                            if (kouten_ari_nasi(adds) == 1) {
                                adds.set(kousatenmade(adds));
                                adds.setcolor(icol_temp);

                                addsenbun(adds);
                                i_sen = i_sen + 1;
                            }


                            Senbun adds2 = new Senbun(px, py, px + dy, py - dx);
                            if (kouten_ari_nasi(adds2) == 1) {
                                adds2.set(kousatenmade(adds2));
                                adds2.setcolor(icol_temp);

                                addsenbun(adds2);
                                i_sen = i_sen + 1;
                            }

                            //ori_s.del_V(ori_s.getsousuu()-1,ori_s.getsousuu());
                            //System.out.println("i_sen_"+i_sen);

                            if (i_sen == 2) {
                                ori_s.del_V(pxy, d_hantei_haba, 0.000001);
                            }

                        }

                        if (icol_temp == 1) {
                            icol_temp = 2;
                        } else if (icol_temp == 2) {
                            icol_temp = 1;
                        }


                    }
                    kiroku();

                }  //s_step[1]‚ª?A?ü‚ÌŽž?i=“_?ó‚Å‚Í‚È‚¢Žž?j‚ÉŽÀŽ{‚Í?A‚±‚±‚Ü‚Å
            }  //ƒ}ƒEƒX‚ÅŽw’è‚µ‚½“_‚ª?A?ÅŠñ“_‚Æ‹ß‚©‚Á‚½‚Æ‚«‚ÉŽÀŽ{‚Í?A‚±‚±‚Ü‚Å
        }
    }


//35 35 35 35 35 35 35 35 35 35 35•¡?Ü‚è•Ô‚µ   “ü—Í‚µ‚½?ü•ª‚É?Ú?G‚µ‚Ä‚¢‚é?Ü?ü‚ð?Ü‚è•Ô‚µ?@‚ÉŽg‚¤

    //ƒ}ƒEƒX‘€?ì(ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mMoved_A_35(Ten p0) {
        mMoved_A_11(p0);
    }//‹ß‚¢Šù‘¶“_‚Ì‚Ý•\Ž¦


    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==35?@‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ----------------------------------------------------
    public void mPressed_A_35(Ten p0) {
        i_egaki_dankai = 1;

        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        moyori_ten.set(get_moyori_ten(p));
        if (p.kyori(moyori_ten) > d_hantei_haba) {
            i_egaki_dankai = 0;
        }
        s_step[1].set(p, moyori_ten);
        s_step[1].setcolor(icol);
        //k.addsenbun(p,p);
        //ieda=k.getsousuu();
        //k.setcolor(ieda,icol);
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==35?@‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------

    public void mDragged_A_35(Ten p0) {
        mDragged_A_11(p0);
    }

/*	public void mDragged_A_35(Ten p0) {

		Ten p =new Ten(); p.set(camera.TV2object(p0));
		s_step[1].seta(p);

		//k.seta(ieda, p);
	}
*/

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==35?@‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mReleased_A_35(Ten p0) {

        Narabebako_int_double nbox = new Narabebako_int_double();

        if (i_egaki_dankai == 1) {
            i_egaki_dankai = 0;
            //Ten p =new Ten();
            p.set(camera.TV2object(p0));
            moyori_ten.set(get_moyori_ten(p));
            s_step[1].seta(moyori_ten);
            if (p.kyori(moyori_ten) <= d_hantei_haba) {
                if (s_step[1].getnagasa() > 0.00000001) {
                    int imax = ori_s.getsousuu();
                    for (int i = 1; i <= imax; i++) {
                        int i_senbun_kousa_hantei = oc.senbun_kousa_hantei_amai(ori_s.get(i), s_step[1], 0.01, 0.01);
                        int i_jikkou = 0;
                        if (i_senbun_kousa_hantei == 21) {
                            i_jikkou = 1;
                        }
                        if (i_senbun_kousa_hantei == 22) {
                            i_jikkou = 1;
                        }
                        if (i_senbun_kousa_hantei == 23) {
                            i_jikkou = 1;
                        }
                        if (i_senbun_kousa_hantei == 24) {
                            i_jikkou = 1;
                        }
                        if (i_senbun_kousa_hantei == 25) {
                            i_jikkou = 1;
                        }
                        if (i_senbun_kousa_hantei == 26) {
                            i_jikkou = 1;
                        }

                        if (i_jikkou == 1) {
                            Ten t_moto = new Ten();
                            t_moto.set(ori_s.geta(i));
                            System.out.println("i_senbun_kousa_hantei_" + i_senbun_kousa_hantei);
                            if (oc.kyori_senbun(t_moto, s_step[1]) < oc.kyori_senbun(ori_s.getb(i), s_step[1])) {
                                t_moto.set(ori_s.getb(i));
                            }


                            //‚Q‚Â‚Ì“_t1,t2‚ð’Ê‚é’¼?ü‚ÉŠÖ‚µ‚Ä?A“_p‚Ì‘Î?ÆˆÊ’u‚É‚ ‚é“_‚ð‹?‚ß‚é public Ten oc.sentaisyou_ten_motome(Ten t1,Ten t2,Ten p){
                            Ten t_taisyou = new Ten();
                            t_taisyou.set(oc.sentaisyou_ten_motome(s_step[1].geta(), s_step[1].getb(), t_moto));

                            Senbun add_sen = new Senbun(oc.kouten_motome(ori_s.get(i), s_step[1]), t_taisyou);

                            add_sen.set(kousatenmade(add_sen));
                            add_sen.setcolor(ori_s.getcolor(i));
                            if (add_sen.getnagasa() > 0.00000001) {
                                addsenbun(add_sen);
                            }
                        }

                    }


                    kiroku();

                }
            }
        }

    }


//------

    public Senbun kousatenmade(Senbun s0) {//s0‚ð“_a‚©‚çb•ûŒü‚É?A‘¼‚Ì?Ü?ü‚ÆŒð?·‚·‚é‚Æ‚±‚ë‚Ü‚Å‰„’·‚·‚é?B?V‚µ‚¢?ü•ª‚ð•Ô‚·//‘¼‚Ì?Ü?ü‚ÆŒð?·‚µ‚È‚¢‚È‚ç?A“¯‚¶?ü•ª‚ð•Ô‚·
        Senbun add_sen = new Senbun();
        add_sen.set(s0);
        Ten kousa_ten = new Ten(1000000.0, 1000000.0); //‚±‚Ì•û–@‚¾‚Æ?AƒGƒ‰?[‚ÌŒ´ˆö‚É‚È‚è‚¤‚é?B–{“–‚È‚ç‘S?ü•ª‚Ìx_max?Ay_maxˆÈ?ã‚Ì“_‚ðŽæ‚ê‚Î‚¢‚¢?B?¡Œã?C?³—\’è20161120
        double kousa_ten_kyori = kousa_ten.kyori(add_sen.geta());


        Tyokusen tyoku1 = new Tyokusen(add_sen.geta(), add_sen.getb());
        int i_kousa_flg;
        for (int i = 1; i <= ori_s.getsousuu(); i++) {
            i_kousa_flg = tyoku1.senbun_kousa_hantei_kuwasii(ori_s.get(i));//0=‚±‚Ì’¼?ü‚Í—^‚¦‚ç‚ê‚½?ü•ª‚ÆŒð?·‚µ‚È‚¢?A1=XŒ^‚ÅŒð?·‚·‚é?A2=TŒ^‚ÅŒð?·‚·‚é?A3=?ü•ª‚Í’¼?ü‚ÉŠÜ‚Ü‚ê‚é?B

            if ((i_kousa_flg == 1 || i_kousa_flg == 21) || i_kousa_flg == 22) {
                kousa_ten.set(oc.kouten_motome(tyoku1, ori_s.get(i)));
                if (kousa_ten.kyori(add_sen.geta()) > 0.00001) {

                    if (kousa_ten.kyori(add_sen.geta()) < kousa_ten_kyori) {

                        double d_kakudo = oc.kakudo(add_sen.geta(), add_sen.getb(), add_sen.geta(), kousa_ten);
                        if (d_kakudo < 1.0 || d_kakudo > 359.0) {
                            //i_kouten_ari_nasi=1;
                            kousa_ten_kyori = kousa_ten.kyori(add_sen.geta());
                            add_sen.set(add_sen.geta(), kousa_ten);
                        }
                    }
                }
            }
        }
        return add_sen;
    }

//------


//------

    public Senbun kousatenmade_2(Senbun s0) {//s0‚ð“_a‚©‚çb•ûŒü‚É?A‘¼‚Ì?Ü?ü‚ÆŒð?·‚·‚é‚Æ‚±‚ë‚Ü‚Å‰„’·‚·‚é?B?V‚µ‚¢?ü•ª‚ð•Ô‚·//‘¼‚Ì?Ü?ü‚ÆŒð?·‚µ‚È‚¢‚È‚ç?A“¯‚¶?ü•ª‚ð•Ô‚·
        Senbun add_sen = new Senbun();
        add_sen.set(s0);
        //Senbun add_sen;add_sen=s0;


        Ten kousa_ten = new Ten(1000000.0, 1000000.0); //‚±‚Ì•û–@‚¾‚Æ?AƒGƒ‰?[‚ÌŒ´ˆö‚É‚È‚è‚¤‚é?B–{“–‚È‚ç‘S?ü•ª‚Ìx_max?Ay_maxˆÈ?ã‚Ì“_‚ðŽæ‚ê‚Î‚¢‚¢?B?¡Œã?C?³—\’è20161120
        double kousa_ten_kyori = kousa_ten.kyori(add_sen.geta());

        Tyokusen tyoku1 = new Tyokusen(add_sen.geta(), add_sen.getb());
        int i_kousa_flg;//Œ³‚Ì?ü•ª‚ð’¼?ü‚Æ‚µ‚½‚à‚Ì‚Æ?A‘¼‚Ì?ü•ª‚ÌŒð?·?ó‘Ô
        int i_senbun_kousa_flg;//Œ³‚Ì?ü•ª‚Æ?A‘¼‚Ì?ü•ª‚ÌŒð?·?ó‘Ô

        System.out.println("AAAAA_");
        for (int i = 1; i <= ori_s.getsousuu(); i++) {
            i_kousa_flg = tyoku1.senbun_kousa_hantei_kuwasii(ori_s.get(i));//0=‚±‚Ì’¼?ü‚Í—^‚¦‚ç‚ê‚½?ü•ª‚ÆŒð?·‚µ‚È‚¢?A1=XŒ^‚ÅŒð?·‚·‚é?A2=TŒ^‚ÅŒð?·‚·‚é?A3=?ü•ª‚Í’¼?ü‚ÉŠÜ‚Ü‚ê‚é?B

            //i_senbun_kousa_flg=oc.senbun_kousa_hantei_amai( add_sen,ori_s.get(i),0.00001,0.00001);//20180408‚È‚º‚©‚±‚Ì?s‚Ì—l‚Éadd_sen‚ðŽg‚¤‚Æ?Ai_senbun_kousa_flg‚ª‚¨‚©‚µ‚­‚È‚é
            i_senbun_kousa_flg = oc.senbun_kousa_hantei_amai(s0, ori_s.get(i), 0.00001, 0.00001);//20180408‚È‚º‚©‚±‚Ì?s‚Ì—l‚És0‚Ì‚Ü‚Ü‚¾‚Æ?Ai_senbun_kousa_flg‚ª‚¨‚©‚µ‚­‚È‚ç‚È‚¢?B
            if ((i_kousa_flg == 1 || i_kousa_flg == 21) || i_kousa_flg == 22) {
                if (i_senbun_kousa_flg < 21 || i_senbun_kousa_flg > 28) {
                    //System.out.println("i_kousa_flg = "+i_kousa_flg  +      " ; i_senbun_kousa_flg = "+i_senbun_kousa_flg);
                    kousa_ten.set(oc.kouten_motome(tyoku1, ori_s.get(i)));
                    if (kousa_ten.kyori(add_sen.geta()) > 0.00001) {
                        if (kousa_ten.kyori(add_sen.geta()) < kousa_ten_kyori) {
                            double d_kakudo = oc.kakudo(add_sen.geta(), add_sen.getb(), add_sen.geta(), kousa_ten);
                            if (d_kakudo < 1.0 || d_kakudo > 359.0) {
                                //i_kouten_ari_nasi=1;
                                kousa_ten_kyori = kousa_ten.kyori(add_sen.geta());
                                add_sen.set(add_sen.geta(), kousa_ten);
                            }
                        }
                    }


                }
            }

            if (i_kousa_flg == 3) {
                if (i_senbun_kousa_flg != 31) {


                    System.out.println("i_kousa_flg = " + i_kousa_flg + " ; i_senbun_kousa_flg = " + i_senbun_kousa_flg);


                    kousa_ten.set(ori_s.get(i).geta());
                    if (kousa_ten.kyori(add_sen.geta()) > 0.00001) {
                        if (kousa_ten.kyori(add_sen.geta()) < kousa_ten_kyori) {
                            double d_kakudo = oc.kakudo(add_sen.geta(), add_sen.getb(), add_sen.geta(), kousa_ten);
                            if (d_kakudo < 1.0 || d_kakudo > 359.0) {
                                //i_kouten_ari_nasi=1;
                                kousa_ten_kyori = kousa_ten.kyori(add_sen.geta());
                                add_sen.set(add_sen.geta(), kousa_ten);
                            }
                        }
                    }

                    kousa_ten.set(ori_s.get(i).getb());
                    if (kousa_ten.kyori(add_sen.geta()) > 0.00001) {
                        if (kousa_ten.kyori(add_sen.geta()) < kousa_ten_kyori) {
                            double d_kakudo = oc.kakudo(add_sen.geta(), add_sen.getb(), add_sen.geta(), kousa_ten);
                            if (d_kakudo < 1.0 || d_kakudo > 359.0) {
                                //i_kouten_ari_nasi=1;
                                kousa_ten_kyori = kousa_ten.kyori(add_sen.geta());
                                add_sen.set(add_sen.geta(), kousa_ten);
                            }
                        }
                    }


                }
            }


        }


        return add_sen;
    }

//------

    public int kouten_ari_nasi(Senbun s0) {//s0‚ð“_a‚©‚çb•ûŒü‚É‰„’·‚µ‚½‚ç?A‘¼‚Ì?Ü?ü‚ÆŒð?·‚·‚é‚È‚ç?A‚P‚µ‚È‚¢‚È‚ç‚O‚ð•Ô‚·?Ba“X‚Å‚ÌŒð?·‚·‚é?ü•ª‚Í?A‚±‚ÌŠÖ?”‚Å‚ÍŒð?·‚È‚µ‚É‚È‚é?B
        Senbun add_sen = new Senbun();
        add_sen.set(s0);
        Ten kousa_ten = new Ten(1000000.0, 1000000.0); //‚±‚Ì•û–@‚¾‚Æ?AƒGƒ‰?[‚ÌŒ´ˆö‚É‚È‚è‚¤‚é?B–{“–‚È‚ç‘S?ü•ª‚Ìx_max?Ay_maxˆÈ?ã‚Ì“_‚ðŽæ‚ê‚Î‚¢‚¢?B?¡Œã?C?³—\’è20161120
        double kousa_ten_kyori = kousa_ten.kyori(add_sen.geta());


        Tyokusen tyoku1 = new Tyokusen(add_sen.geta(), add_sen.getb());
        int i_kousa_flg;
        for (int i = 1; i <= ori_s.getsousuu(); i++) {
            i_kousa_flg = tyoku1.senbun_kousa_hantei_kuwasii(ori_s.get(i));//0=‚±‚Ì’¼?ü‚Í—^‚¦‚ç‚ê‚½?ü•ª‚ÆŒð?·‚µ‚È‚¢?A1=XŒ^‚ÅŒð?·‚·‚é?A2=TŒ^‚ÅŒð?·‚·‚é?A3=?ü•ª‚Í’¼?ü‚ÉŠÜ‚Ü‚ê‚é?B

            if ((i_kousa_flg == 1 || i_kousa_flg == 21) || i_kousa_flg == 22) {
                kousa_ten.set(oc.kouten_motome(tyoku1, ori_s.get(i)));
                if (kousa_ten.kyori(add_sen.geta()) > 0.00001) {


                    double d_kakudo = oc.kakudo(add_sen.geta(), add_sen.getb(), add_sen.geta(), kousa_ten);
                    if (d_kakudo < 1.0 || d_kakudo > 359.0) {
                        return 1;

                    }

                }
            }
        }
        return 0;
    }


//21 21 21 21 21    i_mouse_modeA==21?@;ˆÚ“®ƒ‚?[ƒh

    //ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«
    public void mMoved_A_21(Ten p0) {
        mMoved_m_00b(p0, 5);
    }//ƒ}ƒEƒX‚Å‘I‘ð‚Å‚«‚éŒó•â“_‚ð•\Ž¦‚·‚é?B‹ß‚­‚ÉŠù?¬‚Ì“_‚ª‚ ‚é‚Æ‚«‚Í‚»‚Ì“_?A–³‚¢‚Æ‚«‚Íƒ}ƒEƒX‚ÌˆÊ’uŽ©?g‚ªŒó•â“_‚Æ‚È‚é?B

    //ƒ}ƒEƒXƒNƒŠƒbƒN----------------------------------------------------
    public void mPressed_A_21(Ten p0) {
        mPressed_m_00b(p0, 5);
    }

    //ƒ}ƒEƒXƒhƒ‰ƒbƒO----------------------------------------------------
    public void mDragged_A_21(Ten p0) {
        mDragged_m_00b(p0, 5);
    }

    //ƒ}ƒEƒXƒŠƒŠ?[ƒX----------------------------------------------------
    public void mReleased_A_21(Ten p0) {

        i_select_mode = 0;//  <-------20180919‚±‚Ì?s‚ÍƒZƒŒƒNƒg‚µ‚½?ü‚Ì’[“_‚ð‘I‚Ô‚Æ?AˆÚ“®‚Æ‚©ƒRƒs?[“™‚ð‚³‚¹‚é‚Æ”»’f‚·‚é‚ª?A‚»‚Ì‘€?ì‚ª?I‚í‚Á‚½‚Æ‚«‚É•K—v‚¾‚©‚ç’Ç‰Á‚µ‚½?B
/*
		i_egaki_dankai=0;
		p.set(camera.TV2object(p0));
		moyori_ten.set(get_moyori_ten(p));

		if(p.kyori(moyori_ten)<=d_hantei_haba){
			s_step[1].seta(moyori_ten);
			if(s_step[1].getnagasa()>0.00000001){
				//‚â‚è‚½‚¢“®?ì‚Í‚±‚±‚É?‘‚­

				double addx,addy;
				addx=-s_step[1].getbx()+s_step[1].getax();
				addy=-s_step[1].getby()+s_step[1].getay();

				Orisensyuugou ori_s_temp =new Orisensyuugou();    //ƒZƒŒƒNƒg‚³‚ê‚½?Ü?ü‚¾‚¯Žæ‚è?o‚·‚½‚ß‚ÉŽg‚¤
				ori_s_temp.setMemo(ori_s.getMemo_select_sentaku(2));//ƒZƒŒƒNƒg‚³‚ê‚½?Ü?ü‚¾‚¯Žæ‚è?o‚µ‚Äori_s_temp‚ð?ì‚é
				ori_s.del_selected_senbun_hayai();//ƒZƒŒƒNƒg‚³‚ê‚½?Ü?ü‚ð?í?œ‚·‚é?B
				ori_s_temp.move(addx,addy);//‘S‘Ì‚ðˆÚ“®‚·‚é

				int sousuu_old=ori_s.getsousuu();
				ori_s.addMemo(ori_s_temp.getMemo());
				int sousuu_new=ori_s.getsousuu();
				ori_s.kousabunkatu(1,sousuu_old,sousuu_old+1,sousuu_new);

				ori_s.unselect_all();
				kiroku();
			}
		}
*/
        i_egaki_dankai = 0;
        p.set(camera.TV2object(p0));
        s_step[1].seta(p);
        moyori_ten.set(get_moyori_ten(p));
        if (p.kyori(moyori_ten) <= d_hantei_haba) {
            s_step[1].seta(moyori_ten);
        }
        if (s_step[1].getnagasa() > 0.00000001) {
            //‚â‚è‚½‚¢“®?ì‚Í‚±‚±‚É?‘‚­

            double addx, addy;
            addx = -s_step[1].getbx() + s_step[1].getax();
            addy = -s_step[1].getby() + s_step[1].getay();

            Orisensyuugou ori_s_temp = new Orisensyuugou();    //ƒZƒŒƒNƒg‚³‚ê‚½?Ü?ü‚¾‚¯Žæ‚è?o‚·‚½‚ß‚ÉŽg‚¤
            ori_s_temp.setMemo(ori_s.getMemo_select_sentaku(2));//ƒZƒŒƒNƒg‚³‚ê‚½?Ü?ü‚¾‚¯Žæ‚è?o‚µ‚Äori_s_temp‚ð?ì‚é
            ori_s.del_selected_senbun_hayai();//ƒZƒŒƒNƒg‚³‚ê‚½?Ü?ü‚ð?í?œ‚·‚é?B
            ori_s_temp.move(addx, addy);//‘S‘Ì‚ðˆÚ“®‚·‚é

            int sousuu_old = ori_s.getsousuu();
            ori_s.addMemo(ori_s_temp.getMemo());
            int sousuu_new = ori_s.getsousuu();
            ori_s.kousabunkatu(1, sousuu_old, sousuu_old + 1, sousuu_new);

            ori_s.unselect_all();
            kiroku();
        }


    }


//-------------------------

//22 22 22 22 22    i_mouse_modeA==22?@;ƒRƒsƒyƒ‚?[ƒh

    //ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«
    public void mMoved_A_22(Ten p0) {
        mMoved_m_00b(p0, 5);
    }//ƒ}ƒEƒX‚Å‘I‘ð‚Å‚«‚éŒó•â“_‚ð•\Ž¦‚·‚é?B‹ß‚­‚ÉŠù?¬‚Ì“_‚ª‚ ‚é‚Æ‚«‚Í‚»‚Ì“_?A–³‚¢‚Æ‚«‚Íƒ}ƒEƒX‚ÌˆÊ’uŽ©?g‚ªŒó•â“_‚Æ‚È‚é?B

    //ƒ}ƒEƒXƒNƒŠƒbƒN----------------------------------------------------
    public void mPressed_A_22(Ten p0) {
        mPressed_m_00b(p0, 5);
    }

    //ƒ}ƒEƒXƒhƒ‰ƒbƒO----------------------------------------------------
    public void mDragged_A_22(Ten p0) {
        mDragged_m_00b(p0, 5);
    }

    //ƒ}ƒEƒXƒŠƒŠ?[ƒX----------------------------------------------------
    public void mReleased_A_22(Ten p0) {

        i_select_mode = 0;//  <-------20180919‚±‚Ì?s‚ÍƒZƒŒƒNƒg‚µ‚½?ü‚Ì’[“_‚ð‘I‚Ô‚Æ?AˆÚ“®‚Æ‚©ƒRƒs?[“™‚ð‚³‚¹‚é‚Æ”»’f‚·‚é‚ª?A‚»‚Ì‘€?ì‚ª?I‚í‚Á‚½‚Æ‚«‚É•K—v‚¾‚©‚ç’Ç‰Á‚µ‚½?B
/*
		i_egaki_dankai=0;
		p.set(camera.TV2object(p0));
		moyori_ten.set(get_moyori_ten(p));

		if(p.kyori(moyori_ten)<=d_hantei_haba){
			s_step[1].seta(moyori_ten);
			if(s_step[1].getnagasa()>0.00000001){
				//‚â‚è‚½‚¢“®?ì‚Í‚±‚±‚É?‘‚­

				double addx,addy;
				addx=-s_step[1].getbx()+s_step[1].getax();
				addy=-s_step[1].getby()+s_step[1].getay();

				Orisensyuugou ori_s_temp =new Orisensyuugou();    //ƒZƒŒƒNƒg‚³‚ê‚½?Ü?ü‚¾‚¯Žæ‚è?o‚·‚½‚ß‚ÉŽg‚¤
				ori_s_temp.setMemo(ori_s.getMemo_select_sentaku(2));//ƒZƒŒƒNƒg‚³‚ê‚½?Ü?ü‚¾‚¯Žæ‚è?o‚µ‚Äori_s_temp‚ð?ì‚é
				//ori_s.del_selected_senbun_hayai();//ƒZƒŒƒNƒg‚³‚ê‚½?Ü?ü‚ð?í?œ‚·‚é?Bmove‚Æ?@copy‚Ìˆá‚¢‚Í‚±‚Ì?s‚ª—LŒø‚©‚Ç‚¤‚©‚Ìˆá‚¢
				ori_s_temp.move(addx,addy);//‘S‘Ì‚ðˆÚ“®‚·‚é

				int sousuu_old=ori_s.getsousuu();
				ori_s.addMemo(ori_s_temp.getMemo());
				int sousuu_new=ori_s.getsousuu();
				ori_s.kousabunkatu(1,sousuu_old,sousuu_old+1,sousuu_new);

				ori_s.unselect_all();
				kiroku();
			}
		}
*/
        i_egaki_dankai = 0;
        p.set(camera.TV2object(p0));
        s_step[1].seta(p);
        moyori_ten.set(get_moyori_ten(p));
        if (p.kyori(moyori_ten) <= d_hantei_haba) {
            s_step[1].seta(moyori_ten);
        }
        if (s_step[1].getnagasa() > 0.00000001) {
            //‚â‚è‚½‚¢“®?ì‚Í‚±‚±‚É?‘‚­

            double addx, addy;
            addx = -s_step[1].getbx() + s_step[1].getax();
            addy = -s_step[1].getby() + s_step[1].getay();

            Orisensyuugou ori_s_temp = new Orisensyuugou();    //ƒZƒŒƒNƒg‚³‚ê‚½?Ü?ü‚¾‚¯Žæ‚è?o‚·‚½‚ß‚ÉŽg‚¤
            ori_s_temp.setMemo(ori_s.getMemo_select_sentaku(2));//ƒZƒŒƒNƒg‚³‚ê‚½?Ü?ü‚¾‚¯Žæ‚è?o‚µ‚Äori_s_temp‚ð?ì‚é
            //ori_s.del_selected_senbun_hayai();//ƒZƒŒƒNƒg‚³‚ê‚½?Ü?ü‚ð?í?œ‚·‚é?Bmove‚Æ?@copy‚Ìˆá‚¢‚Í‚±‚Ì?s‚ª—LŒø‚©‚Ç‚¤‚©‚Ìˆá‚¢
            ori_s_temp.move(addx, addy);//‘S‘Ì‚ðˆÚ“®‚·‚é

            int sousuu_old = ori_s.getsousuu();
            ori_s.addMemo(ori_s_temp.getMemo());
            int sousuu_new = ori_s.getsousuu();
            ori_s.kousabunkatu(1, sousuu_old, sousuu_old + 1, sousuu_new);

            ori_s.unselect_all();
            kiroku();
        }

    }


//--------------------------------------------
//31 31 31 31 31 31 31 31  i_mouse_modeA==31move2p2p	“ü—Í 31 31 31 31 31 31 31 31

//“®?ìŠT—v?@
//i_mouse_modeA==1‚Æ?ü•ª•ªŠ„ˆÈŠO‚Í“¯‚¶?@
//

    //ƒ}ƒEƒX‘€?ì(ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mMoved_A_31(Ten p0) {
        mMoved_A_11(p0);
    }//‹ß‚¢Šù‘¶“_‚Ì‚Ý•\Ž¦

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==31move2p2p?@‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ----------------------------------------------------
    public void mPressed_A_31(Ten p0) {
        p.set(camera.TV2object(p0));

        if (i_egaki_dankai == 0) {    //‘æ1’iŠK‚Æ‚µ‚Ä?A“_‚ð‘I‘ð
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(5);
            }
            return;
        }

        if (i_egaki_dankai == 1) {    //‘æ2’iŠK‚Æ‚µ‚Ä?A“_‚ð‘I‘ð
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) >= d_hantei_haba) {
                i_egaki_dankai = 0;
                i_select_mode = 0;//  <-------20180919‚±‚Ì?s‚ÍƒZƒŒƒNƒg‚µ‚½?ü‚Ì’[“_‚ð‘I‚Ô‚Æ?AˆÚ“®‚Æ‚©ƒRƒs?[“™‚ð‚³‚¹‚é‚Æ”»’f‚·‚é‚ª?A‚»‚Ì‘€?ì‚ª?I‚í‚Á‚½‚Æ‚«‚É•K—v‚¾‚©‚ç’Ç‰Á‚µ‚½?B
                //“_‚Ì‘I‘ð‚ªŽ¸”s‚µ‚½?ê?‡‚ài_select_mode=0‚É‚µ‚È‚¢‚Æ?AƒZƒŒƒNƒg‚Ì‚Â‚à‚è‚ª“®?ìƒ‚?[ƒh‚ªmove2p2p‚É‚È‚Á‚½‚Ü‚Ü‚É‚È‚é
                return;
            }
            if (p.kyori(moyori_ten) < d_hantei_haba) {

                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(i_egaki_dankai);

            }
            if (oc.kyori(s_step[1].geta(), s_step[2].geta()) < 0.00000001) {
                i_egaki_dankai = 0;
                i_select_mode = 0;//  <-------20180919‚±‚Ì?s‚ÍƒZƒŒƒNƒg‚µ‚½?ü‚Ì’[“_‚ð‘I‚Ô‚Æ?AˆÚ“®‚Æ‚©ƒRƒs?[“™‚ð‚³‚¹‚é‚Æ”»’f‚·‚é‚ª?A‚»‚Ì‘€?ì‚ª?I‚í‚Á‚½‚Æ‚«‚É•K—v‚¾‚©‚ç’Ç‰Á‚µ‚½?B

            }
            return;
        }


        if (i_egaki_dankai == 2) {    //‘æ3’iŠK‚Æ‚µ‚Ä?A“_‚ð‘I‘ð
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) >= d_hantei_haba) {
                i_egaki_dankai = 0;
                i_select_mode = 0;//  <-------20180919‚±‚Ì?s‚ÍƒZƒŒƒNƒg‚µ‚½?ü‚Ì’[“_‚ð‘I‚Ô‚Æ?AˆÚ“®‚Æ‚©ƒRƒs?[“™‚ð‚³‚¹‚é‚Æ”»’f‚·‚é‚ª?A‚»‚Ì‘€?ì‚ª?I‚í‚Á‚½‚Æ‚«‚É•K—v‚¾‚©‚ç’Ç‰Á‚µ‚½?B

                return;

            }
            if (p.kyori(moyori_ten) < d_hantei_haba) {

                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(i_egaki_dankai);

            }
            return;
        }


        if (i_egaki_dankai == 3) {    //‘æ4’iŠK‚Æ‚µ‚Ä?A“_‚ð‘I‘ð
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) >= d_hantei_haba) {
                i_egaki_dankai = 0;
                i_select_mode = 0;//  <-------20180919‚±‚Ì?s‚ÍƒZƒŒƒNƒg‚µ‚½?ü‚Ì’[“_‚ð‘I‚Ô‚Æ?AˆÚ“®‚Æ‚©ƒRƒs?[“™‚ð‚³‚¹‚é‚Æ”»’f‚·‚é‚ª?A‚»‚Ì‘€?ì‚ª?I‚í‚Á‚½‚Æ‚«‚É•K—v‚¾‚©‚ç’Ç‰Á‚µ‚½?B
                return;
            }
            if (p.kyori(moyori_ten) < d_hantei_haba) {

                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(i_egaki_dankai);

            }
            if (oc.kyori(s_step[3].geta(), s_step[4].geta()) < 0.00000001) {
                i_egaki_dankai = 0;
                i_select_mode = 0;//  <-------20180919‚±‚Ì?s‚ÍƒZƒŒƒNƒg‚µ‚½?ü‚Ì’[“_‚ð‘I‚Ô‚Æ?AˆÚ“®‚Æ‚©ƒRƒs?[“™‚ð‚³‚¹‚é‚Æ”»’f‚·‚é‚ª?A‚»‚Ì‘€?ì‚ª?I‚í‚Á‚½‚Æ‚«‚É•K—v‚¾‚©‚ç’Ç‰Á‚µ‚½?B

            }
            return;
        }


    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==31move2p2p?@‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mDragged_A_31(Ten p0) {
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==31move2p2p?@‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mReleased_A_31(Ten p0) {
        if (i_egaki_dankai == 4) {
            i_egaki_dankai = 0;
            i_select_mode = 0;//  <-------20180919‚±‚Ì?s‚ÍƒZƒŒƒNƒg‚µ‚½?ü‚Ì’[“_‚ð‘I‚Ô‚Æ?AˆÚ“®‚Æ‚©ƒRƒs?[“™‚ð‚³‚¹‚é‚Æ”»’f‚·‚é‚ª?A‚»‚Ì‘€?ì‚ª?I‚í‚Á‚½‚Æ‚«‚É•K—v‚¾‚©‚ç’Ç‰Á‚µ‚½?B

            //double addx,addy;
            //addx=s_step[1].getbx()-s_step[1].getax();
            //addy=s_step[1].getby()-s_step[1].getay();


            Orisensyuugou ori_s_temp = new Orisensyuugou();    //ƒZƒŒƒNƒg‚³‚ê‚½?Ü?ü‚¾‚¯Žæ‚è?o‚·‚½‚ß‚ÉŽg‚¤
            ori_s_temp.setMemo(ori_s.getMemo_select_sentaku(2));//ƒZƒŒƒNƒg‚³‚ê‚½?Ü?ü‚¾‚¯Žæ‚è?o‚µ‚Äori_s_temp‚ð?ì‚é
            ori_s.del_selected_senbun_hayai();//ƒZƒŒƒNƒg‚³‚ê‚½?Ü?ü‚ð?í?œ‚·‚é?B
            ori_s_temp.move(s_step[1].geta(), s_step[2].geta(), s_step[3].geta(), s_step[4].geta());//‘S‘Ì‚ðˆÚ“®‚·‚é

            int sousuu_old = ori_s.getsousuu();
            ori_s.addMemo(ori_s_temp.getMemo());
            int sousuu_new = ori_s.getsousuu();
            ori_s.kousabunkatu(1, sousuu_old, sousuu_old + 1, sousuu_new);

            ori_s.unselect_all();
            kiroku();
        }
    }

//  ********************************************


//--------------------------------------------
//32 32 32 32 32 32 32 32  i_mouse_modeA==32copy2p2p	“ü—Í 32 32 32 32 32 32 32 32

//“®?ìŠT—v?@
//i_mouse_modeA==1‚Æ?ü•ª•ªŠ„ˆÈŠO‚Í“¯‚¶?@
//

    //ƒ}ƒEƒX‘€?ì(ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mMoved_A_32(Ten p0) {
        mMoved_A_11(p0);
    }//‹ß‚¢Šù‘¶“_‚Ì‚Ý•\Ž¦

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==32copy2p2p2p2p?@‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ----------------------------------------------------
    public void mPressed_A_32(Ten p0) {
        p.set(camera.TV2object(p0));

        if (i_egaki_dankai == 0) {    //‘æ1’iŠK‚Æ‚µ‚Ä?A“_‚ð‘I‘ð
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(5);
            }
            return;
        }

        if (i_egaki_dankai == 1) {    //‘æ2’iŠK‚Æ‚µ‚Ä?A“_‚ð‘I‘ð
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) >= d_hantei_haba) {
                i_egaki_dankai = 0;
                i_select_mode = 0;//  <-------20180919‚±‚Ì?s‚ÍƒZƒŒƒNƒg‚µ‚½?ü‚Ì’[“_‚ð‘I‚Ô‚Æ?AˆÚ“®‚Æ‚©ƒRƒs?[“™‚ð‚³‚¹‚é‚Æ”»’f‚·‚é‚ª?A‚»‚Ì‘€?ì‚ª?I‚í‚Á‚½‚Æ‚«‚É•K—v‚¾‚©‚ç’Ç‰Á‚µ‚½?B
                return;
            }
            if (p.kyori(moyori_ten) < d_hantei_haba) {

                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(i_egaki_dankai);

            }
            if (oc.kyori(s_step[1].geta(), s_step[2].geta()) < 0.00000001) {
                i_egaki_dankai = 0;
                i_select_mode = 0;//  <-------20180919‚±‚Ì?s‚ÍƒZƒŒƒNƒg‚µ‚½?ü‚Ì’[“_‚ð‘I‚Ô‚Æ?AˆÚ“®‚Æ‚©ƒRƒs?[“™‚ð‚³‚¹‚é‚Æ”»’f‚·‚é‚ª?A‚»‚Ì‘€?ì‚ª?I‚í‚Á‚½‚Æ‚«‚É•K—v‚¾‚©‚ç’Ç‰Á‚µ‚½?B
            }
            return;
        }


        if (i_egaki_dankai == 2) {    //‘æ3’iŠK‚Æ‚µ‚Ä?A“_‚ð‘I‘ð
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) >= d_hantei_haba) {
                i_egaki_dankai = 0;
                i_select_mode = 0;//  <-------20180919‚±‚Ì?s‚ÍƒZƒŒƒNƒg‚µ‚½?ü‚Ì’[“_‚ð‘I‚Ô‚Æ?AˆÚ“®‚Æ‚©ƒRƒs?[“™‚ð‚³‚¹‚é‚Æ”»’f‚·‚é‚ª?A‚»‚Ì‘€?ì‚ª?I‚í‚Á‚½‚Æ‚«‚É•K—v‚¾‚©‚ç’Ç‰Á‚µ‚½?B
                return;
            }
            if (p.kyori(moyori_ten) < d_hantei_haba) {

                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(i_egaki_dankai);

            }
            return;
        }


        if (i_egaki_dankai == 3) {    //‘æ4’iŠK‚Æ‚µ‚Ä?A“_‚ð‘I‘ð
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) >= d_hantei_haba) {
                i_egaki_dankai = 0;
                i_select_mode = 0;//  <-------20180919‚±‚Ì?s‚ÍƒZƒŒƒNƒg‚µ‚½?ü‚Ì’[“_‚ð‘I‚Ô‚Æ?AˆÚ“®‚Æ‚©ƒRƒs?[“™‚ð‚³‚¹‚é‚Æ”»’f‚·‚é‚ª?A‚»‚Ì‘€?ì‚ª?I‚í‚Á‚½‚Æ‚«‚É•K—v‚¾‚©‚ç’Ç‰Á‚µ‚½?B
                return;
            }
            if (p.kyori(moyori_ten) < d_hantei_haba) {

                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(i_egaki_dankai);

            }
            if (oc.kyori(s_step[3].geta(), s_step[4].geta()) < 0.00000001) {
                i_egaki_dankai = 0;
                i_select_mode = 0;//  <-------20180919‚±‚Ì?s‚ÍƒZƒŒƒNƒg‚µ‚½?ü‚Ì’[“_‚ð‘I‚Ô‚Æ?AˆÚ“®‚Æ‚©ƒRƒs?[“™‚ð‚³‚¹‚é‚Æ”»’f‚·‚é‚ª?A‚»‚Ì‘€?ì‚ª?I‚í‚Á‚½‚Æ‚«‚É•K—v‚¾‚©‚ç’Ç‰Á‚µ‚½?B
            }
            return;
        }


    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==32copy2p2p?@‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mDragged_A_32(Ten p0) {
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==32copy2p2pp?@‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mReleased_A_32(Ten p0) {
        if (i_egaki_dankai == 4) {
            i_egaki_dankai = 0;
            i_select_mode = 0;//  <-------20180919‚±‚Ì?s‚ÍƒZƒŒƒNƒg‚µ‚½?ü‚Ì’[“_‚ð‘I‚Ô‚Æ?AˆÚ“®‚Æ‚©ƒRƒs?[“™‚ð‚³‚¹‚é‚Æ”»’f‚·‚é‚ª?A‚»‚Ì‘€?ì‚ª?I‚í‚Á‚½‚Æ‚«‚É•K—v‚¾‚©‚ç’Ç‰Á‚µ‚½?B
            //double addx,addy;
            //addx=s_step[1].getbx()-s_step[1].getax();
            //addy=s_step[1].getby()-s_step[1].getay();


            Orisensyuugou ori_s_temp = new Orisensyuugou();    //ƒZƒŒƒNƒg‚³‚ê‚½?Ü?ü‚¾‚¯Žæ‚è?o‚·‚½‚ß‚ÉŽg‚¤
            ori_s_temp.setMemo(ori_s.getMemo_select_sentaku(2));//ƒZƒŒƒNƒg‚³‚ê‚½?Ü?ü‚¾‚¯Žæ‚è?o‚µ‚Äori_s_temp‚ð?ì‚é
            //ori_s.del_selected_senbun_hayai();//ƒZƒŒƒNƒg‚³‚ê‚½?Ü?ü‚ð?í?œ‚·‚é?B
            ori_s_temp.move(s_step[1].geta(), s_step[2].geta(), s_step[3].geta(), s_step[4].geta());//‘S‘Ì‚ðˆÚ“®‚·‚é

            int sousuu_old = ori_s.getsousuu();
            ori_s.addMemo(ori_s_temp.getMemo());
            int sousuu_new = ori_s.getsousuu();
            ori_s.kousabunkatu(1, sousuu_old, sousuu_old + 1, sousuu_new);

            //ori_s.unselect_all();
            kiroku();
        }
    }

//  ********************************************

    //12 12 12 12 12    i_mouse_modeA==12?@;‹¾‰fƒ‚?[ƒh
    //ƒ}ƒEƒX‘€?ì(ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mMoved_A_12(Ten p0) {
        mMoved_A_11(p0);
    }//‹ß‚¢Šù‘¶“_‚Ì‚Ý•\Ž¦

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==12‹¾‰fƒ‚?[ƒh?@‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ----------------------------------------------------
    public void mPressed_A_12(Ten p0) {

        p.set(camera.TV2object(p0));


        if (i_egaki_dankai == 0) {    //‘æ1’iŠK‚Æ‚µ‚Ä?A“_‚ð‘I‘ð


            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(5);

                //s_step[i_egaki_dankai].set(moyori_senbun);        s_step[i_egaki_dankai].setcolor(5);

            }
            return;
        }

        if (i_egaki_dankai == 1) {    //‘æ2’iŠK‚Æ‚µ‚Ä?A“_‚ð‘I‘ð
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) >= d_hantei_haba) {
                i_egaki_dankai = 0;
                i_select_mode = 0;//  <-------20180919‚±‚Ì?s‚ÍƒZƒŒƒNƒg‚µ‚½?ü‚Ì’[“_‚ð‘I‚Ô‚Æ?AˆÚ“®‚Æ‚©ƒRƒs?[“™‚ð‚³‚¹‚é‚Æ”»’f‚·‚é‚ª?A‚»‚Ì‘€?ì‚ª?I‚í‚Á‚½‚Æ‚«‚É•K—v‚¾‚©‚ç’Ç‰Á‚µ‚½?B
                return;
            }
            if (p.kyori(moyori_ten) < d_hantei_haba) {

                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(i_egaki_dankai);
                s_step[1].setb(s_step[2].getb());
            }
            if (s_step[1].getnagasa() < 0.00000001) {
                i_egaki_dankai = 0;
                i_select_mode = 0;//  <-------20180919‚±‚Ì?s‚ÍƒZƒŒƒNƒg‚µ‚½?ü‚Ì’[“_‚ð‘I‚Ô‚Æ?AˆÚ“®‚Æ‚©ƒRƒs?[“™‚ð‚³‚¹‚é‚Æ”»’f‚·‚é‚ª?A‚»‚Ì‘€?ì‚ª?I‚í‚Á‚½‚Æ‚«‚É•K—v‚¾‚©‚ç’Ç‰Á‚µ‚½?B
            }
        }

/*


		moyori_ten.set(get_moyori_ten(p));
		if(p.kyori(moyori_ten)>d_hantei_haba){i_egaki_dankai=0;}
		s_step[1].set(p,moyori_ten);s_step[1].setcolor(icol);
		//k.addsenbun(p,p);
		//ieda=k.getsousuu();
		//k.setcolor(ieda,icol);
*/
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==12‹¾‰fƒ‚?[ƒh?@‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mDragged_A_12(Ten p0) {

        //Ten p =new Ten(); p.set(camera.TV2object(p0));
        //s_step[1].seta(p);

        //k.seta(ieda, p);
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==12‹¾‰fƒ‚?[ƒh?@‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mReleased_A_12(Ten p0) {
        Senbun adds = new Senbun();
        //Orisensyuugou ori_s_temp =new Orisensyuugou();
        if (i_egaki_dankai == 2) {
            i_egaki_dankai = 0;
            i_select_mode = 0;//  <-------20180919‚±‚Ì?s‚ÍƒZƒŒƒNƒg‚µ‚½?ü‚Ì’[“_‚ð‘I‚Ô‚Æ?AˆÚ“®‚Æ‚©ƒRƒs?[“™‚ð‚³‚¹‚é‚Æ”»’f‚·‚é‚ª?A‚»‚Ì‘€?ì‚ª?I‚í‚Á‚½‚Æ‚«‚É•K—v‚¾‚©‚ç’Ç‰Á‚µ‚½?B
            int old_sousuu = ori_s.getsousuu();

            for (int i = 1; i <= ori_s.getsousuu(); i++) {
                if (ori_s.get_select(i) == 2) {
                    //Senbun adds =new Senbun();
                    adds.set(oc.sentaisyou_senbun_motome(ori_s.get(i), s_step[1]));
                    adds.setcolor(ori_s.getcolor(i));
                    //addsenbun(adds);

                    //ori_s_temp.addsenbun(adds);


                    //ori_s_temp.addsenbun(adds.geta(),adds.getb());
                    //ori_s_temp.setcolor(ori_s.getsousuu(),ori_s.getcolor(i));

                    ori_s.addsenbun(adds.geta(), adds.getb());
                    ori_s.setcolor(ori_s.getsousuu(), ori_s.getcolor(i));
                }
            }

            int new_sousuu = ori_s.getsousuu();

            ori_s.kousabunkatu(1, old_sousuu, old_sousuu + 1, new_sousuu);
/*

			for (int i=1; i<=ori_s_temp.getsousuu(); i++ ){
				adds.set(	ori_s_temp.get(i));
				adds.setcolor(	ori_s_temp.getcolor(i));
				addsenbun(adds);
			}


*/


            ori_s.unselect_all();
            kiroku();
        }
    }

    //Ten p =new Ten(); p.set(camera.TV2object(p0));
    //moyori_ten.set(get_moyori_ten(p));
    //s_step[1].seta(moyori_ten);
    //if(p.kyori(moyori_ten)<=d_hantei_haba){
    //	if(s_step[1].getnagasa()>0.00000001){

    //addsenbun(adds);
    //ieda=ori_s.getsousuu();
    //ori_s.setcolor(ieda,icol); qqqqqqqqq
    //ori_s.kousabunkatu_symple();
    //ori_s.kousabunkatu();ori_s.kousabunkatu_symple();


    //}
    //kiroku();
    //}


    //-------------------------
    public void del_selected_senbun() {
        //ori_s.del_selected_senbun();
        ori_s.del_selected_senbun_hayai();
        //Memo memo_temp = new Memo();memo_temp.set(ori_s.getMemo_select_jyogai(2));
        //ori_s.reset();
        //ori_s.setMemo(memo_temp);

    }


//34 34 34 34 34 34 34 34 34 34 34“ü—Í‚µ‚½?ü•ª‚É?d•¡‚µ‚Ä‚¢‚é?Ü?ü‚ð?‡‚ÉŽR’J‚É‚·‚é


    public void mMoved_A_34(Ten p0) {
        mMoved_A_11(p0);
    }//‹ß‚¢Šù‘¶“_‚Ì‚Ý•\Ž¦

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==34?@‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ----------------------------------------------------
    public void mPressed_A_34(Ten p0) {
        i_egaki_dankai = 1;

        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        moyori_ten.set(get_moyori_ten(p));
        if (p.kyori(moyori_ten) > d_hantei_haba) {
            i_egaki_dankai = 0;
        }
        s_step[1].set(p, moyori_ten);
        s_step[1].setcolor(icol);
        //k.addsenbun(p,p);
        //ieda=k.getsousuu();
        //k.setcolor(ieda,icol);
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==34?@‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mDragged_A_34(Ten p0) {
        mDragged_A_11(p0);
    }
/*
	public void mDragged_A_34(Ten p0) {

		Ten p =new Ten(); p.set(camera.TV2object(p0));
		s_step[1].seta(p);

		//k.seta(ieda, p);
	}
*/

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==34?@‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mReleased_A_34(Ten p0) {

        Narabebako_int_double nbox = new Narabebako_int_double();

        if (i_egaki_dankai == 1) {
            i_egaki_dankai = 0;
            //Ten p =new Ten();
            p.set(camera.TV2object(p0));
            moyori_ten.set(get_moyori_ten(p));
            s_step[1].seta(moyori_ten);
            if (p.kyori(moyori_ten) <= d_hantei_haba) {
                if (s_step[1].getnagasa() > 0.00000001) {
                    for (int i = 1; i <= ori_s.getsousuu(); i++) {
                        int i_senbun_kousa_hantei = oc.senbun_kousa_hantei(ori_s.get(i), s_step[1], 0.0001, 0.0001);
                        int i_jikkou = 0;
                        if (i_senbun_kousa_hantei == 31) {
                            i_jikkou = 1;
                        }
                        if (i_senbun_kousa_hantei == 321) {
                            i_jikkou = 1;
                        }
                        if (i_senbun_kousa_hantei == 322) {
                            i_jikkou = 1;
                        }
                        if (i_senbun_kousa_hantei == 331) {
                            i_jikkou = 1;
                        }
                        if (i_senbun_kousa_hantei == 332) {
                            i_jikkou = 1;
                        }
                        if (i_senbun_kousa_hantei == 341) {
                            i_jikkou = 1;
                        }
                        if (i_senbun_kousa_hantei == 342) {
                            i_jikkou = 1;
                        }
                        if (i_senbun_kousa_hantei == 351) {
                            i_jikkou = 1;
                        }
                        if (i_senbun_kousa_hantei == 352) {
                            i_jikkou = 1;
                        }

                        if (i_senbun_kousa_hantei == 361) {
                            i_jikkou = 1;
                        }
                        if (i_senbun_kousa_hantei == 362) {
                            i_jikkou = 1;
                        }
                        if (i_senbun_kousa_hantei == 363) {
                            i_jikkou = 1;
                        }
                        if (i_senbun_kousa_hantei == 364) {
                            i_jikkou = 1;
                        }
                        if (i_senbun_kousa_hantei == 371) {
                            i_jikkou = 1;
                        }
                        if (i_senbun_kousa_hantei == 372) {
                            i_jikkou = 1;
                        }
                        if (i_senbun_kousa_hantei == 373) {
                            i_jikkou = 1;
                        }
                        if (i_senbun_kousa_hantei == 374) {
                            i_jikkou = 1;
                        }

                        if (i_jikkou == 1) {
                            int_double i_d = new int_double(i, oc.kyori_senbun(s_step[1].getb(), ori_s.get(i)));
                            nbox.ire_i_tiisaijyun(i_d);
                        }

                    }

                    //System.out.println("i_d_sousuu"+nbox.getsousuu());

                    int icol_temp = icol;

                    for (int i = 1; i <= nbox.getsousuu(); i++) {

                        ori_s.setcolor(nbox.get_int(i), icol_temp);


                        if (icol_temp == 1) {
                            icol_temp = 2;
                        } else if (icol_temp == 2) {
                            icol_temp = 1;
                        }
                    }


                    kiroku();

                }
            }
        }

    }


//36 36 36 36 36 36 36 36 36 36 36“ü—Í‚µ‚½?ü•ª‚ÉXŒð?·‚µ‚Ä‚¢‚é?Ü?ü‚ð?‡‚ÉŽR’J‚É‚·‚é


    //ƒ}ƒEƒX‘€?ì(ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mMoved_A_36(Ten p0) {
        mMoved_A_28(p0);
    }//‹ß‚¢Šù‘¶“_‚Ì‚Ý•\Ž¦


    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==36?@‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ----------------------------------------------------
    public void mPressed_A_36(Ten p0) {
        i_egaki_dankai = 1;

        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        moyori_ten.set(get_moyori_ten(p));
        if (p.kyori(moyori_ten) > d_hantei_haba) {
            moyori_ten.set(p);
        }
        s_step[1].set(p, moyori_ten);
        s_step[1].setcolor(icol);
        //k.addsenbun(p,p);
        //ieda=k.getsousuu();
        //k.setcolor(ieda,icol);
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==36?@‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------

    public void mDragged_A_36(Ten p0) {
        mDragged_A_28(p0);
    }
/*
	public void mDragged_A_36(Ten p0) {

		Ten p =new Ten(); p.set(camera.TV2object(p0));
		s_step[1].seta(p);

		//k.seta(ieda, p);
	}
*/

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==36?@‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mReleased_A_36(Ten p0) {

        Narabebako_int_double nbox = new Narabebako_int_double();

        if (i_egaki_dankai == 1) {
            i_egaki_dankai = 0;
            //Ten p =new Ten();
            p.set(camera.TV2object(p0));
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) > d_hantei_haba) {
                moyori_ten.set(p);
            }
            s_step[1].seta(moyori_ten);
            //if(p.kyori(moyori_ten)<=d_hantei_haba){
            if (s_step[1].getnagasa() > 0.00000001) {
                for (int i = 1; i <= ori_s.getsousuu(); i++) {
                    int i_senbun_kousa_hantei = oc.senbun_kousa_hantei(ori_s.get(i), s_step[1], 0.0001, 0.0001);
                    int i_jikkou = 0;
                    if (i_senbun_kousa_hantei == 1) {
                        i_jikkou = 1;
                    }
                    if (i_senbun_kousa_hantei == 27) {
                        i_jikkou = 1;
                    }
                    if (i_senbun_kousa_hantei == 28) {
                        i_jikkou = 1;
                    }
                    //if(i_senbun_kousa_hantei== 31 ){ i_jikkou=1;}
                    //if(i_senbun_kousa_hantei== 321 ){ i_jikkou=1;}
                    //if(i_senbun_kousa_hantei== 322 ){ i_jikkou=1;}
                    //if(i_senbun_kousa_hantei== 331 ){ i_jikkou=1;}
                    //if(i_senbun_kousa_hantei== 332 ){ i_jikkou=1;}
                    //if(i_senbun_kousa_hantei== 341 ){ i_jikkou=1;}
                    //if(i_senbun_kousa_hantei== 342 ){ i_jikkou=1;}
                    //if(i_senbun_kousa_hantei== 351 ){ i_jikkou=1;}
                    //if(i_senbun_kousa_hantei== 352 ){ i_jikkou=1;}

                    //if(i_senbun_kousa_hantei== 361 ){ i_jikkou=1;}
                    //if(i_senbun_kousa_hantei== 362 ){ i_jikkou=1;}
                    //if(i_senbun_kousa_hantei== 363 ){ i_jikkou=1;}
                    //if(i_senbun_kousa_hantei== 364 ){ i_jikkou=1;}
                    //if(i_senbun_kousa_hantei== 371 ){ i_jikkou=1;}
                    //if(i_senbun_kousa_hantei== 372 ){ i_jikkou=1;}
                    //if(i_senbun_kousa_hantei== 373 ){ i_jikkou=1;}
                    //if(i_senbun_kousa_hantei== 374 ){ i_jikkou=1;}

                    if (i_jikkou == 1) {
                        int_double i_d = new int_double(i, oc.kyori(s_step[1].getb(), oc.kouten_motome(ori_s.get(i), s_step[1])));
                        nbox.ire_i_tiisaijyun(i_d);
                    }

                }

                System.out.println("i_d_sousuu" + nbox.getsousuu());

                int icol_temp = icol;

                for (int i = 1; i <= nbox.getsousuu(); i++) {

                    ori_s.setcolor(nbox.get_int(i), icol_temp);


                    if (icol_temp == 1) {
                        icol_temp = 2;
                    } else if (icol_temp == 2) {
                        icol_temp = 1;
                    }
                }


                kiroku();

            }
            //}
        }

    }


//--------------------------------------------------------------------------------
//13 13 13 13 13 13    i_mouse_modeA==13?@;Šp“xŒnƒ‚?[ƒh//?ü•ªŽw’è?AŒð“_‚Ü‚Å

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ
    public void mPressed_A_13(Ten p0) {

        int honsuu = 0;//1‚Â‚Ì’[“_Žü‚è‚É•`‚­?ü‚Ì–{?”
        if (id_kakudo_kei != 0) {
            honsuu = id_kakudo_kei * 2 - 1;
        } else if (id_kakudo_kei == 0) {
            honsuu = 6;
        }

        int i_jyunnbi_step_suu = 1;//“®?ì‚Ì?€”õ‚Æ‚µ‚Ä?lŠÔ‚ª‘I‘ð‚·‚éƒXƒeƒbƒv?”

        //Ten p =new Ten();
        p.set(camera.TV2object(p0));

        if (i_egaki_dankai == 0) {    //‘æ‚P’iŠK‚Æ‚µ‚Ä?A?ü•ª‚ð‘I‘ð
            moyori_senbun.set(get_moyori_senbun(p));
            if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {
                i_egaki_dankai = 1;
                s_step[1].set(moyori_senbun);
                s_step[1].setcolor(5);
            }
        }

        if (i_egaki_dankai == i_jyunnbi_step_suu) {    //if(i_egaki_dankai==1){        //“®?ì‚Ì?€”õ‚Æ‚µ‚Ä?lŠÔ‚ª‘I‘ð‚·‚éƒXƒeƒbƒv?”‚ª?I‚í‚Á‚½?ó‘Ô‚ÅŽÀ?s
            int i_jyun;//i_jyun‚Í?ü‚ð•`‚­‚Æ‚«?‡”Ô‚É?F‚ð•Ï‚¦‚½‚¢‚Æ‚«Žg‚¤
            //?ü•ªab‚ða‚ð’†?S‚Éd“x‰ñ“]‚µ‚½?ü•ª‚ð•Ô‚·ŠÖ?”?iŒ³‚Ì?ü•ª‚Í•Ï‚¦‚¸‚É?V‚µ‚¢?ü•ª‚ð•Ô‚·?jpublic oc.Senbun_kaiten(Senbun s0,double d) //    double d_kakudo_kei;double kakudo;

            if (id_kakudo_kei != 0) {
                d_kakudo_kei = 180.0 / (double) id_kakudo_kei;
            } else if (id_kakudo_kei == 0) {
                d_kakudo_kei = 180.0 / 4.0;
            }

            if (id_kakudo_kei != 0) {
                Senbun s_kiso = new Senbun(s_step[1].geta(), s_step[1].getb());
                kakudo = 0.0;
                i_jyun = 0;
                for (int i = 1; i <= honsuu; i++) {
                    i_jyun = i_jyun + 1;
                    if (i_jyun == 2) {
                        i_jyun = 0;
                    }
                    i_egaki_dankai = i_egaki_dankai + 1;
                    kakudo = kakudo + d_kakudo_kei;
                    s_step[i_egaki_dankai].set(oc.Senbun_kaiten(s_kiso, kakudo, 10.0));
                    if (i_jyun == 0) {
                        s_step[i_egaki_dankai].setcolor(6);
                    }
                    if (i_jyun == 1) {
                        s_step[i_egaki_dankai].setcolor(4);
                    }
                }

                s_kiso.set(s_step[1].getb(), s_step[1].geta());
                kakudo = 0.0;
                i_jyun = 0;
                for (int i = 1; i <= honsuu; i++) {
                    i_jyun = i_jyun + 1;
                    if (i_jyun == 2) {
                        i_jyun = 0;
                    }
                    i_egaki_dankai = i_egaki_dankai + 1;
                    kakudo = kakudo + d_kakudo_kei;
                    s_step[i_egaki_dankai].set(oc.Senbun_kaiten(s_kiso, kakudo, 10.0));
                    if (i_jyun == 0) {
                        s_step[i_egaki_dankai].setcolor(6);
                    }
                    if (i_jyun == 1) {
                        s_step[i_egaki_dankai].setcolor(4);
                    }
                }
            }
            if (id_kakudo_kei == 0) {
                double[] jk = new double[7];
                jk[0] = 0.0;
                jk[1] = d_jiyuu_kaku_2;
                jk[2] = d_jiyuu_kaku_1;
                jk[3] = d_jiyuu_kaku_3;
                jk[4] = 360.0 - d_jiyuu_kaku_2;
                jk[5] = 360.0 - d_jiyuu_kaku_1;
                jk[6] = 360.0 - d_jiyuu_kaku_3;

                Senbun s_kiso = new Senbun(s_step[1].geta(), s_step[1].getb());
                kakudo = 0.0;
                i_jyun = 0;
                for (int i = 1; i <= 6; i++) {
                    i_jyun = i_jyun + 1;
                    if (i_jyun == 2) {
                        i_jyun = 0;
                    }
                    i_egaki_dankai = i_egaki_dankai + 1;
                    kakudo = jk[i];
                    s_step[i_egaki_dankai].set(oc.Senbun_kaiten(s_kiso, kakudo, 10.0));
                    if (i == 1) {
                        s_step[i_egaki_dankai].setcolor(6);
                    }
                    if (i == 2) {
                        s_step[i_egaki_dankai].setcolor(8);
                    }
                    if (i == 3) {
                        s_step[i_egaki_dankai].setcolor(4);
                    }
                    if (i == 4) {
                        s_step[i_egaki_dankai].setcolor(4);
                    }
                    if (i == 5) {
                        s_step[i_egaki_dankai].setcolor(6);
                    }
                    if (i == 6) {
                        s_step[i_egaki_dankai].setcolor(8);
                    }
                }

                s_kiso.set(s_step[1].getb(), s_step[1].geta());
                kakudo = 0.0;
                i_jyun = 0;
                for (int i = 1; i <= 6; i++) {
                    i_jyun = i_jyun + 1;
                    if (i_jyun == 2) {
                        i_jyun = 0;
                    }
                    i_egaki_dankai = i_egaki_dankai + 1;
                    kakudo = jk[i];
                    s_step[i_egaki_dankai].set(oc.Senbun_kaiten(s_kiso, kakudo, 10.0));
                    if (i == 1) {
                        s_step[i_egaki_dankai].setcolor(6);
                    }
                    if (i == 2) {
                        s_step[i_egaki_dankai].setcolor(8);
                    }
                    if (i == 3) {
                        s_step[i_egaki_dankai].setcolor(4);
                    }
                    if (i == 4) {
                        s_step[i_egaki_dankai].setcolor(4);
                    }
                    if (i == 5) {
                        s_step[i_egaki_dankai].setcolor(6);
                    }
                    if (i == 6) {
                        s_step[i_egaki_dankai].setcolor(8);
                    }
                }
            }


            return;
        }


        if (i_egaki_dankai == i_jyunnbi_step_suu + (honsuu) + (honsuu)) {//19     //“®?ì‚Ì?€”õ‚Æ‚µ‚Äƒ\ƒtƒg‚ª•Ô“š‚·‚éƒXƒeƒbƒv?”‚ª?I‚í‚Á‚½?ó‘Ô‚ÅŽÀ?s

            int i_tikai_s_step_suu = 0;

            //s_step[2‚©‚ç10]‚Ü‚Å‚Æs_step[11‚©‚ç19]‚Ü‚Å
            moyori_senbun.set(get_moyori_step_senbun(p, 2, 1 + (honsuu)));
            if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                i_tikai_s_step_suu = i_tikai_s_step_suu + 1;
                s_step[i_egaki_dankai].set(moyori_senbun);    //s_step[i_egaki_dankai].setcolor(2);//s_step[20]‚Éinput
            }

            //s_step[2‚©‚ç10]‚Ü‚Å‚Æs_step[11‚©‚ç19]‚Ü‚Å
            moyori_senbun.set(get_moyori_step_senbun(p, 1 + (honsuu) + 1, 1 + (honsuu) + (honsuu)));
            if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                i_tikai_s_step_suu = i_tikai_s_step_suu + 1;
                s_step[i_egaki_dankai].set(moyori_senbun);    //s_step[i_egaki_dankai].setcolor(icol);
            }

            if (i_tikai_s_step_suu == 2) { //‚±‚Ì’iŠK‚Ås_step‚ª[21]‚Ü‚Å‚¤‚Ü‚Á‚Ä‚½‚ç?As_step[20]‚Æs_step[21]‚Í‹¤‚É‰Á‚¦‚é?Ü?ü‚È‚Ì‚Å?A‚±‚±‚Å?ˆ—?‚ð?I‚¦‚Ä‚µ‚Ü‚¤?B
                //=     1+ (honsuu) +(honsuu) +  2 ){i_egaki_dankai=0; //‚±‚Ì’iŠK‚Ås_step‚ª[21]‚Ü‚Å‚¤‚Ü‚Á‚Ä‚½‚ç?As_step[20]‚Æs_step[21]‚Í‹¤‚É‰Á‚¦‚é?Ü?ü‚È‚Ì‚Å?A‚±‚±‚Å?ˆ—?‚ð?I‚¦‚Ä‚µ‚Ü‚¤?B
                //—áŠO?ˆ—?‚Æ‚µ‚Äs_step[20]‚Æs_step[21]‚ª•½?s‚Ì?ê?‡?A‚æ‚è‹ß‚¢‚Ù‚¤‚ðs_step‚ª[20]‚Æ‚µ?As_step‚ð[20]‚Æ‚µ‚ÄƒŠƒ^?[ƒ“?i‚±‚Ì?ê?‡‚Í‚Ü‚¾?ˆ—?‚Í?I‚í‚ê‚È‚¢?j?B
                //‚Q‚Â‚Ì?ü•ª‚ª•½?s‚©‚Ç‚¤‚©‚ð”»’è‚·‚éŠÖ?”?Boc.heikou_hantei(Tyokusen t1,Tyokusen t2)//0=•½?s‚Å‚È‚¢?A1=•½?s‚Å‚Q’¼?ü‚ªˆê’v‚µ‚È‚¢?A2=•½?s‚Å‚Q’¼?ü‚ªˆê’v‚·‚é
                //0=•½?s‚Å‚È‚¢?A1=•½?s‚Å‚Q’¼?ü‚ªˆê’v‚µ‚È‚¢?A2=•½?s‚Å‚Q’¼?ü‚ªˆê’v‚·‚é

                if (oc.heikou_hantei(s_step[i_egaki_dankai - 1], s_step[i_egaki_dankai], 0.1) != 0) {//‚±‚±‚ÍˆÀ‘S‚ðŒ©‚Äè‡’l‚ð0.1‚Æ‘å–Ú‚É‚Æ‚Á‚Ä‚¨‚±‚Ì‚ª‚æ‚³‚»‚¤

                    //s_step[20]‚Æs_step[21]‚Æ“_p‚Ì‹——£  //public double kyori_senbun(Ten p0,Senbun s)
                    //if(oc.kyori_senbun(p, s_step[1+     (honsuu) +(honsuu)   +1]) >  oc.kyori_senbun(p, s_step[1+     (honsuu) +(honsuu)   +1+1])          ){
                    //     s_step[1+     (honsuu) +(honsuu)   +1].set(  s_step[1+     (honsuu) +(honsuu)   +1+1]                   )    ;
                    //}

                    //i_egaki_dankai=i_egaki_dankai-1;
                    //i_egaki_dankai=i_egaki_dankai-2;
                    i_egaki_dankai = 0;
                    return;
                }


                i_egaki_dankai = 0;

                //s_step[20]‚Æs_step[21]‚ÌŒð“_‚Íoc.kouten_motome(Senbun s1,Senbun s2)‚Å‹?‚ß‚é//‚Q‚Â‚Ì?ü•ª‚ð’¼?ü‚Æ‚Ý‚È‚µ‚ÄŒð“_‚ð‹?‚ß‚éŠÖ?”?B?ü•ª‚Æ‚µ‚Ä‚ÍŒð?·‚µ‚È‚­‚Ä‚à?A’¼?ü‚Æ‚µ‚ÄŒð?·‚µ‚Ä‚¢‚é?ê?‡‚ÌŒð“_‚ð•Ô‚·
                Ten kousa_ten = new Ten();
                kousa_ten.set(oc.kouten_motome(s_step[1 + (honsuu) + (honsuu) + 1], s_step[1 + (honsuu) + (honsuu) + 1 + 1]));

                Senbun add_sen = new Senbun(kousa_ten, s_step[1 + (honsuu) + (honsuu) + 1].geta());
                add_sen.setcolor(icol);
                if (add_sen.getnagasa() > 0.00000001) {
                    addsenbun(add_sen);
                }

                Senbun add_sen2 = new Senbun(kousa_ten, s_step[1 + (honsuu) + (honsuu) + 1 + 1].geta());
                add_sen2.setcolor(icol);
                if (add_sen.getnagasa() > 0.00000001) {
                    addsenbun(add_sen2);
                }
                kiroku();
            }

            i_egaki_dankai = 0;
            return;
        }
        return;
    }

    //ƒ}ƒEƒX‘€?ì(ƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mDragged_A_13(Ten p0) {
    }

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mReleased_A_13(Ten p0) {
    }

//------


//--------------------------------------------------------------------------------
//17 17 17 17 17 17    i_mouse_modeA==17?@;Šp“xŒnƒ‚?[ƒh

    //ƒ}ƒEƒX‘€?ì(ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mMoved_A_17(Ten p0) {
        if (i_egaki_dankai <= 1) {
            mMoved_A_11(p0);//‹ß‚¢Šù‘¶“_‚Ì‚Ý•\Ž¦
        }
    }


    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ
    public void mPressed_A_17(Ten p0) {

        int honsuu = 0;//1‚Â‚Ì’[“_Žü‚è‚É•`‚­?ü‚Ì–{?”
        if (id_kakudo_kei != 0) {
            honsuu = id_kakudo_kei * 2 - 1;
        } else if (id_kakudo_kei == 0) {
            honsuu = 6;
        }

        int i_jyunnbi_step_suu = 2;//“®?ì‚Ì?€”õ‚Æ‚µ‚Ä?lŠÔ‚ª‘I‘ð‚·‚éƒXƒeƒbƒv?”

        //Ten p =new Ten();
        p.set(camera.TV2object(p0));

        if (i_egaki_dankai == 0) {    //‘æ1’iŠK‚Æ‚µ‚Ä?A“_‚ð‘I‘ð
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(5);

                //s_step[i_egaki_dankai].set(moyori_senbun);        s_step[i_egaki_dankai].setcolor(5);

            }
            return;
        }

        if (i_egaki_dankai == 1) {    //‘æ2’iŠK‚Æ‚µ‚Ä?A“_‚ð‘I‘ð
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) >= d_hantei_haba) {
                i_egaki_dankai = 0;
                return;
            }
            if (p.kyori(moyori_ten) < d_hantei_haba) {

                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(i_egaki_dankai);
                s_step[1].setb(s_step[2].getb());


            }

        }
// ------------------------------------------

        if (i_egaki_dankai == i_jyunnbi_step_suu) {    //if(i_egaki_dankai==1){        //“®?ì‚Ì?€”õ‚Æ‚µ‚Ä?lŠÔ‚ª‘I‘ð‚·‚éƒXƒeƒbƒv?”‚ª?I‚í‚Á‚½?ó‘Ô‚ÅŽÀ?s
            int i_jyun;//i_jyun‚Í?ü‚ð•`‚­‚Æ‚«?‡”Ô‚É?F‚ð•Ï‚¦‚½‚¢‚Æ‚«Žg‚¤
            //?ü•ªab‚ða‚ð’†?S‚Éd“x‰ñ“]‚µ‚½?ü•ª‚ð•Ô‚·ŠÖ?”?iŒ³‚Ì?ü•ª‚Í•Ï‚¦‚¸‚É?V‚µ‚¢?ü•ª‚ð•Ô‚·?jpublic oc.Senbun_kaiten(Senbun s0,double d) //    double d_kakudo_kei;double kakudo;

            if (id_kakudo_kei != 0) {
                d_kakudo_kei = 180.0 / (double) id_kakudo_kei;
            } else if (id_kakudo_kei == 0) {
                d_kakudo_kei = 180.0 / 4.0;
            }

            if (id_kakudo_kei != 0) {

                Senbun s_kiso = new Senbun(s_step[1].geta(), s_step[1].getb());
                kakudo = 0.0;
                i_jyun = 0;
                for (int i = 1; i <= honsuu; i++) {
                    i_jyun = i_jyun + 1;
                    if (i_jyun == 2) {
                        i_jyun = 0;
                    }
                    i_egaki_dankai = i_egaki_dankai + 1;
                    kakudo = kakudo + d_kakudo_kei;
                    s_step[i_egaki_dankai].set(oc.Senbun_kaiten(s_kiso, kakudo, 10.0));
                    if (i_jyun == 0) {
                        s_step[i_egaki_dankai].setcolor(6);
                    }
                    if (i_jyun == 1) {
                        s_step[i_egaki_dankai].setcolor(4);
                    }
                }

                s_kiso.set(s_step[1].getb(), s_step[1].geta());
                kakudo = 0.0;
                i_jyun = 0;
                for (int i = 1; i <= honsuu; i++) {
                    i_jyun = i_jyun + 1;
                    if (i_jyun == 2) {
                        i_jyun = 0;
                    }
                    i_egaki_dankai = i_egaki_dankai + 1;
                    kakudo = kakudo + d_kakudo_kei;
                    s_step[i_egaki_dankai].set(oc.Senbun_kaiten(s_kiso, kakudo, 10.0));
                    if (i_jyun == 0) {
                        s_step[i_egaki_dankai].setcolor(6);
                    }
                    if (i_jyun == 1) {
                        s_step[i_egaki_dankai].setcolor(4);
                    }
                }
            }
            if (id_kakudo_kei == 0) {
                double[] jk = new double[7];
                jk[0] = 0.0;
                jk[1] = d_jiyuu_kaku_2;
                jk[2] = d_jiyuu_kaku_1;
                jk[3] = d_jiyuu_kaku_3;
                jk[4] = 360.0 - d_jiyuu_kaku_2;
                jk[5] = 360.0 - d_jiyuu_kaku_1;
                jk[6] = 360.0 - d_jiyuu_kaku_3;

                Senbun s_kiso = new Senbun(s_step[1].geta(), s_step[1].getb());
                kakudo = 0.0;
                i_jyun = 0;
                for (int i = 1; i <= 6; i++) {
                    i_jyun = i_jyun + 1;
                    if (i_jyun == 2) {
                        i_jyun = 0;
                    }
                    i_egaki_dankai = i_egaki_dankai + 1;
                    kakudo = jk[i];
                    s_step[i_egaki_dankai].set(oc.Senbun_kaiten(s_kiso, kakudo, 10.0));
                    if (i == 1) {
                        s_step[i_egaki_dankai].setcolor(6);
                    }
                    if (i == 2) {
                        s_step[i_egaki_dankai].setcolor(8);
                    }
                    if (i == 3) {
                        s_step[i_egaki_dankai].setcolor(4);
                    }
                    if (i == 4) {
                        s_step[i_egaki_dankai].setcolor(4);
                    }
                    if (i == 5) {
                        s_step[i_egaki_dankai].setcolor(6);
                    }
                    if (i == 6) {
                        s_step[i_egaki_dankai].setcolor(8);
                    }
                }

                s_kiso.set(s_step[1].getb(), s_step[1].geta());
                kakudo = 0.0;
                i_jyun = 0;
                for (int i = 1; i <= 6; i++) {
                    i_jyun = i_jyun + 1;
                    if (i_jyun == 2) {
                        i_jyun = 0;
                    }
                    i_egaki_dankai = i_egaki_dankai + 1;
                    kakudo = jk[i];
                    s_step[i_egaki_dankai].set(oc.Senbun_kaiten(s_kiso, kakudo, 10.0));
                    if (i == 1) {
                        s_step[i_egaki_dankai].setcolor(6);
                    }
                    if (i == 2) {
                        s_step[i_egaki_dankai].setcolor(8);
                    }
                    if (i == 3) {
                        s_step[i_egaki_dankai].setcolor(4);
                    }
                    if (i == 4) {
                        s_step[i_egaki_dankai].setcolor(4);
                    }
                    if (i == 5) {
                        s_step[i_egaki_dankai].setcolor(6);
                    }
                    if (i == 6) {
                        s_step[i_egaki_dankai].setcolor(8);
                    }
                }
            }


            return;
        }


        if (i_egaki_dankai == i_jyunnbi_step_suu + (honsuu) + (honsuu)) {//19     //“®?ì‚Ì?€”õ‚Æ‚µ‚Äƒ\ƒtƒg‚ª•Ô“š‚·‚éƒXƒeƒbƒv?”‚ª?I‚í‚Á‚½?ó‘Ô‚ÅŽÀ?s

            int i_tikai_s_step_suu = 0;

            //s_step[2‚©‚ç10]‚Ü‚Å‚Æs_step[11‚©‚ç19]‚Ü‚Å
            moyori_senbun.set(get_moyori_step_senbun(p, 3, 2 + (honsuu)));
            if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                i_tikai_s_step_suu = i_tikai_s_step_suu + 1;
                s_step[i_egaki_dankai].set(moyori_senbun);    //s_step[i_egaki_dankai].setcolor(2);//s_step[20]‚Éinput
            }

            //s_step[2‚©‚ç10]‚Ü‚Å‚Æs_step[11‚©‚ç19]‚Ü‚Å
            moyori_senbun.set(get_moyori_step_senbun(p, 2 + (honsuu) + 1, 2 + (honsuu) + (honsuu)));
            if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                i_tikai_s_step_suu = i_tikai_s_step_suu + 1;
                s_step[i_egaki_dankai].set(moyori_senbun);    //s_step[i_egaki_dankai].setcolor(icol);
            }

            if (i_tikai_s_step_suu == 2) { //‚±‚Ì’iŠK‚Ås_step‚ª[21]‚Ü‚Å‚¤‚Ü‚Á‚Ä‚½‚ç?As_step[20]‚Æs_step[21]‚Í‹¤‚É‰Á‚¦‚é?Ü?ü‚È‚Ì‚Å?A‚±‚±‚Å?ˆ—?‚ð?I‚¦‚Ä‚µ‚Ü‚¤?B
                //=     1+ (honsuu) +(honsuu) +  2 ){i_egaki_dankai=0; //‚±‚Ì’iŠK‚Ås_step‚ª[21]‚Ü‚Å‚¤‚Ü‚Á‚Ä‚½‚ç?As_step[20]‚Æs_step[21]‚Í‹¤‚É‰Á‚¦‚é?Ü?ü‚È‚Ì‚Å?A‚±‚±‚Å?ˆ—?‚ð?I‚¦‚Ä‚µ‚Ü‚¤?B
                //—áŠO?ˆ—?‚Æ‚µ‚Äs_step[20]‚Æs_step[21]‚ª•½?s‚Ì?ê?‡?A‚æ‚è‹ß‚¢‚Ù‚¤‚ðs_step‚ª[20]‚Æ‚µ?As_step‚ð[20]‚Æ‚µ‚ÄƒŠƒ^?[ƒ“?i‚±‚Ì?ê?‡‚Í‚Ü‚¾?ˆ—?‚Í?I‚í‚ê‚È‚¢?j?B
                //‚Q‚Â‚Ì?ü•ª‚ª•½?s‚©‚Ç‚¤‚©‚ð”»’è‚·‚éŠÖ?”?Boc.heikou_hantei(Tyokusen t1,Tyokusen t2)//0=•½?s‚Å‚È‚¢?A1=•½?s‚Å‚Q’¼?ü‚ªˆê’v‚µ‚È‚¢?A2=•½?s‚Å‚Q’¼?ü‚ªˆê’v‚·‚é
                //0=•½?s‚Å‚È‚¢?A1=•½?s‚Å‚Q’¼?ü‚ªˆê’v‚µ‚È‚¢?A2=•½?s‚Å‚Q’¼?ü‚ªˆê’v‚·‚é

                if (oc.heikou_hantei(s_step[i_egaki_dankai - 1], s_step[i_egaki_dankai], 0.1) != 0) {//‚±‚±‚ÍˆÀ‘S‚ðŒ©‚Äè‡’l‚ð0.1‚Æ‘å–Ú‚É‚Æ‚Á‚Ä‚¨‚±‚Ì‚ª‚æ‚³‚»‚¤

                    //s_step[20]‚Æs_step[21]‚Æ“_p‚Ì‹——£  //public double kyori_senbun(Ten p0,Senbun s)
                    //if(oc.kyori_senbun(p, s_step[1+     (honsuu) +(honsuu)   +1]) >  oc.kyori_senbun(p, s_step[1+     (honsuu) +(honsuu)   +1+1])          ){
                    //     s_step[1+     (honsuu) +(honsuu)   +1].set(  s_step[1+     (honsuu) +(honsuu)   +1+1]                   )    ;
                    //}

                    //i_egaki_dankai=i_egaki_dankai-1;
                    //i_egaki_dankai=i_egaki_dankai-2;
                    i_egaki_dankai = 0;
                    return;
                }

//System.out.println("aaaaaaaaaaaaaa");
//System.out.println("bbbbbbbbbbbbb");
//System.out.println("cccccccccccccc");


                i_egaki_dankai = 0;

                //s_step[20]‚Æs_step[21]‚ÌŒð“_‚Íoc.kouten_motome(Senbun s1,Senbun s2)‚Å‹?‚ß‚é//‚Q‚Â‚Ì?ü•ª‚ð’¼?ü‚Æ‚Ý‚È‚µ‚ÄŒð“_‚ð‹?‚ß‚éŠÖ?”?B?ü•ª‚Æ‚µ‚Ä‚ÍŒð?·‚µ‚È‚­‚Ä‚à?A’¼?ü‚Æ‚µ‚ÄŒð?·‚µ‚Ä‚¢‚é?ê?‡‚ÌŒð“_‚ð•Ô‚·
                Ten kousa_ten = new Ten();
                kousa_ten.set(oc.kouten_motome(s_step[2 + (honsuu) + (honsuu) + 1], s_step[2 + (honsuu) + (honsuu) + 1 + 1]));

                Senbun add_sen = new Senbun(kousa_ten, s_step[2 + (honsuu) + (honsuu) + 1].geta());
                add_sen.setcolor(icol);
                if (add_sen.getnagasa() > 0.00000001) {
                    addsenbun(add_sen);
                }

                Senbun add_sen2 = new Senbun(kousa_ten, s_step[2 + (honsuu) + (honsuu) + 2].geta());
                add_sen2.setcolor(icol);
                if (add_sen.getnagasa() > 0.00000001) {
                    addsenbun(add_sen2);
                }
                kiroku();
            }

            i_egaki_dankai = 0;
            return;

        }

        //i_egaki_dankai=               1+ (honsuu) +(honsuu) ;
        return;
    }

    //ƒ}ƒEƒX‘€?ì(ƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mDragged_A_17(Ten p0) {
    }

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mReleased_A_17(Ten p0) {
    }

//------


//VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV

//16 16 16 16 16 16    i_mouse_modeA==16?@;Šp“xŒnƒ‚?[ƒh

    //ƒ}ƒEƒX‘€?ì(ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mMoved_A_16(Ten p0) {
        mMoved_A_17(p0);
    }


    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ
    public void mPressed_A_16(Ten p0) {

        int honsuu = 0;//1‚Â‚Ì’[“_Žü‚è‚É•`‚­?ü‚Ì–{?”
        if (id_kakudo_kei != 0) {
            honsuu = id_kakudo_kei * 2 - 1;
        } else if (id_kakudo_kei == 0) {
            honsuu = 6;
        }


        double kakudo_kei = 36.0;
        double kakudo = 0.0;
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));

        if ((i_egaki_dankai == 0) || (i_egaki_dankai == 1)) {
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(i_egaki_dankai);
                if (i_egaki_dankai == 0) {
                    return;
                }
            }
        }


        if (i_egaki_dankai == 2) {
            //?ü•ªab‚ða‚ð’†?S‚Éd“x‰ñ“]‚µ‚½?ü•ª‚ð•Ô‚·ŠÖ?”?iŒ³‚Ì?ü•ª‚Í•Ï‚¦‚¸‚É?V‚µ‚¢?ü•ª‚ð•Ô‚·?jpublic oc.Senbun_kaiten(Senbun s0,double d)


            if (id_kakudo_kei != 0) {
                d_kakudo_kei = 180.0 / (double) id_kakudo_kei;
            } else if (id_kakudo_kei == 0) {
                d_kakudo_kei = 180.0 / 4.0;
            }

            if (id_kakudo_kei != 0) {


                Senbun s_kiso = new Senbun(s_step[2].geta(), s_step[1].geta());
                kakudo = 0.0;

                int i_jyun;
                i_jyun = 0;//i_jyun‚Í?ü‚ð•`‚­‚Æ‚«?‡”Ô‚É?F‚ð•Ï‚¦‚½‚¢‚Æ‚«Žg‚¤
                for (int i = 1; i <= honsuu; i++) {
                    i_jyun = i_jyun + 1;
                    if (i_jyun == 2) {
                        i_jyun = 0;
                    }

                    i_egaki_dankai = i_egaki_dankai + 1;
                    kakudo = kakudo + d_kakudo_kei;
                    s_step[i_egaki_dankai].set(oc.Senbun_kaiten(s_kiso, kakudo, 1.0));
                    if (i_jyun == 0) {
                        s_step[i_egaki_dankai].setcolor(6);
                    }
                    if (i_jyun == 1) {
                        s_step[i_egaki_dankai].setcolor(4);
                    }
                }

            }

            if (id_kakudo_kei == 0) {
                double[] jk = new double[7];
                jk[0] = 0.0;
                jk[1] = d_jiyuu_kaku_2;
                jk[2] = d_jiyuu_kaku_1;
                jk[3] = d_jiyuu_kaku_3;
                jk[4] = 360.0 - d_jiyuu_kaku_2;
                jk[5] = 360.0 - d_jiyuu_kaku_1;
                jk[6] = 360.0 - d_jiyuu_kaku_3;


                Senbun s_kiso = new Senbun(s_step[2].geta(), s_step[1].geta());
                kakudo = 0.0;


                for (int i = 1; i <= 6; i++) {

                    i_egaki_dankai = i_egaki_dankai + 1;
                    kakudo = jk[i];
                    s_step[i_egaki_dankai].set(oc.Senbun_kaiten(s_kiso, kakudo, 1.0));
                    if (i == 1) {
                        s_step[i_egaki_dankai].setcolor(4);
                    }
                    if (i == 2) {
                        s_step[i_egaki_dankai].setcolor(6);
                    }
                    if (i == 3) {
                        s_step[i_egaki_dankai].setcolor(8);
                    }
                    if (i == 4) {
                        s_step[i_egaki_dankai].setcolor(4);
                    }
                    if (i == 5) {
                        s_step[i_egaki_dankai].setcolor(6);
                    }
                    if (i == 6) {
                        s_step[i_egaki_dankai].setcolor(8);
                    }
                }


            }


            return;
        }


        if (i_egaki_dankai == 2 + (honsuu)) {
            moyori_senbun.set(get_moyori_step_senbun(p, 3, 2 + (honsuu)));
            if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_senbun);//s_step[i_egaki_dankai].setcolor(i_egaki_dankai);
                s_step[i_egaki_dankai].setcolor(2);
                return;
            }
            if (oc.kyori_senbun(p, moyori_senbun) >= d_hantei_haba) {
                i_egaki_dankai = 0;
                return;
            }
        }


        if (i_egaki_dankai == 2 + (honsuu) + 1) {

            moyori_senbun.set(get_moyori_senbun(p));
            if (oc.kyori_senbun(p, moyori_senbun) >= d_hantei_haba) {//?ÅŠñ?Ü?ü‚ª‰“‚©‚Á‚½?ê?‡
                i_egaki_dankai = 0;
                return;
            }

            if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_senbun);//s_step[i_egaki_dankai].setcolor(i_egaki_dankai);
                s_step[i_egaki_dankai].setcolor(6);
                //return;
            }
        }

//		if(i_egaki_dankai==13){
        if (i_egaki_dankai == 2 + (honsuu) + 1 + 1) {
            i_egaki_dankai = 0;

            //s_step[12]‚Æs_step[13]‚ÌŒð“_‚Íoc.kouten_motome(Senbun s1,Senbun s2)‚Å‹?‚ß‚é//‚Q‚Â‚Ì?ü•ª‚ð’¼?ü‚Æ‚Ý‚È‚µ‚ÄŒð“_‚ð‹?‚ß‚éŠÖ?”?B?ü•ª‚Æ‚µ‚Ä‚ÍŒð?·‚µ‚È‚­‚Ä‚à?A’¼?ü‚Æ‚µ‚ÄŒð?·‚µ‚Ä‚¢‚é?ê?‡‚ÌŒð“_‚ð•Ô‚·
//			Ten kousa_ten =new Ten(); kousa_ten.set(oc.kouten_motome(s_step[12],s_step[13]));
            Ten kousa_ten = new Ten();
            kousa_ten.set(oc.kouten_motome(s_step[2 + (honsuu) + 1], s_step[2 + (honsuu) + 1 + 1]));
            Senbun add_sen = new Senbun(kousa_ten, s_step[2].geta(), icol);
            if (add_sen.getnagasa() > 0.00000001) {
                addsenbun(add_sen);
                kiroku();
            }
            return;
        }
    }

    //ƒ}ƒEƒX‘€?ì(ƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mDragged_A_16(Ten p0) {
    }

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mReleased_A_16(Ten p0) {
    }

//------


//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA

//VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV

//18 18 18 18 18 18    i_mouse_modeA==18?@;Šp“xŒnƒ‚?[ƒh

    //ƒ}ƒEƒX‘€?ì(ƒ}ƒEƒX‚ð“®‚©‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mMoved_A_18(Ten p0) {
        mMoved_A_17(p0);
    }

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ
    public void mPressed_A_18(Ten p0) {

        int honsuu = 0;//1‚Â‚Ì’[“_Žü‚è‚É•`‚­?ü‚Ì–{?”
        if (id_kakudo_kei != 0) {
            honsuu = id_kakudo_kei * 2 - 1;
        } else if (id_kakudo_kei == 0) {
            honsuu = 6;
        }


        double kakudo_kei = 36.0;
        double kakudo = 0.0;
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));

        if ((i_egaki_dankai == 0) || (i_egaki_dankai == 1)) {
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(i_egaki_dankai);
                if (i_egaki_dankai == 0) {
                    return;
                }
            }
        }


        if (i_egaki_dankai == 2) {
            //?ü•ªab‚ða‚ð’†?S‚Éd“x‰ñ“]‚µ‚½?ü•ª‚ð•Ô‚·ŠÖ?”?iŒ³‚Ì?ü•ª‚Í•Ï‚¦‚¸‚É?V‚µ‚¢?ü•ª‚ð•Ô‚·?jpublic oc.Senbun_kaiten(Senbun s0,double d)

            if (id_kakudo_kei != 0) {
                d_kakudo_kei = 180.0 / (double) id_kakudo_kei;
            } else if (id_kakudo_kei == 0) {
                d_kakudo_kei = 180.0 / 4.0;
            }


            if (id_kakudo_kei != 0) {
                Senbun s_kiso = new Senbun(s_step[2].geta(), s_step[1].geta());
                kakudo = 0.0;

                int i_jyun;
                i_jyun = 0;//i_jyun‚Í?ü‚ð•`‚­‚Æ‚«?‡”Ô‚É?F‚ð•Ï‚¦‚½‚¢‚Æ‚«Žg‚¤
                for (int i = 1; i <= honsuu; i++) {
                    i_jyun = i_jyun + 1;
                    if (i_jyun == 2) {
                        i_jyun = 0;
                    }
                    i_egaki_dankai = i_egaki_dankai + 1;
                    kakudo = kakudo + d_kakudo_kei;
                    s_step[i_egaki_dankai].set(oc.Senbun_kaiten(s_kiso, kakudo, 100.0));
                    if (i_jyun == 0) {
                        s_step[i_egaki_dankai].setcolor(6);
                    }
                    if (i_jyun == 1) {
                        s_step[i_egaki_dankai].setcolor(4);
                    }
                }
            }


            if (id_kakudo_kei == 0) {
                double[] jk = new double[7];
                jk[0] = 0.0;
                jk[1] = d_jiyuu_kaku_2;
                jk[2] = d_jiyuu_kaku_1;
                jk[3] = d_jiyuu_kaku_3;
                jk[4] = 360.0 - d_jiyuu_kaku_2;
                jk[5] = 360.0 - d_jiyuu_kaku_1;
                jk[6] = 360.0 - d_jiyuu_kaku_3;

                Senbun s_kiso = new Senbun(s_step[2].geta(), s_step[1].geta());
                kakudo = 0.0;


                for (int i = 1; i <= 6; i++) {
                    //i_jyun=i_jyun+1;if(i_jyun==2){i_jyun=0;}

                    i_egaki_dankai = i_egaki_dankai + 1;
                    kakudo = jk[i];
                    s_step[i_egaki_dankai].set(oc.Senbun_kaiten(s_kiso, kakudo, 100.0));
                    if (i == 1) {
                        s_step[i_egaki_dankai].setcolor(4);
                    }
                    if (i == 2) {
                        s_step[i_egaki_dankai].setcolor(6);
                    }
                    if (i == 3) {
                        s_step[i_egaki_dankai].setcolor(8);
                    }
                    if (i == 4) {
                        s_step[i_egaki_dankai].setcolor(4);
                    }
                    if (i == 5) {
                        s_step[i_egaki_dankai].setcolor(6);
                    }
                    if (i == 6) {
                        s_step[i_egaki_dankai].setcolor(8);
                    }
                }
            }


            return;
        }


        //if(i_egaki_dankai==11){
        if (i_egaki_dankai == 2 + (honsuu)) {
            i_egaki_dankai = 0;
            moyori_step_senbun.set(get_moyori_step_senbun(p, 3, 2 + (honsuu)));
            if (oc.kyori_senbun(p, moyori_step_senbun) >= d_hantei_haba) {
                return;
            }

            if (oc.kyori_senbun(p, moyori_step_senbun) < d_hantei_haba) {
                Ten mokuhyou_ten = new Ten();
                mokuhyou_ten.set(oc.kage_motome(moyori_step_senbun, p));

                moyori_senbun.set(get_moyori_senbun(p));
                if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {//?ÅŠñ?Ü?ü‚ª‹ß‚¢?ê?‡
                    if (oc.heikou_hantei(moyori_step_senbun, moyori_senbun, 0.000001) == 0) {//?ÅŠñ?Ü?ü‚ª?ÅŠñstep?Ü?ü‚Æ•½?s‚Ì?ê?‡‚Í?œŠO
                        Ten mokuhyou_ten2 = new Ten();
                        mokuhyou_ten2.set(oc.kouten_motome(moyori_step_senbun, moyori_senbun));
                        if (p.kyori(mokuhyou_ten) * 2.0 > p.kyori(mokuhyou_ten2)) {
                            mokuhyou_ten.set(mokuhyou_ten2);
                        }

                    }

                }

                Senbun add_sen = new Senbun();
                add_sen.set(mokuhyou_ten, s_step[2].geta());
                add_sen.setcolor(icol);
                addsenbun(add_sen);
                kiroku();
            }


			/*
			  oc.kouten_motome(s_step[12],s_step[13]);


				(s_step[1].geta(),oc.kage_motome(oc.Senbun2Tyokusen(s_step[2]),s_step[1].geta()));



			if(add_sen.getnagasa()>0.00000001){addsenbun(add_sen);}

				i_egaki_dankai=i_egaki_dankai+1;
				s_step[i_egaki_dankai].set(moyori_step_senbun);//s_step[i_egaki_dankai].setcolor(i_egaki_dankai);
				s_step[i_egaki_dankai].setcolor(2);
				return;
			}

			}

//		if(i_egaki_dankai==12){
		if(i_egaki_dankai==2+ (honsuu)  +1 ){
			moyori_senbun.set(get_moyori_senbun(p));
			if(oc.kyori_senbun( p,moyori_senbun)<d_hantei_haba){
				i_egaki_dankai=i_egaki_dankai+1;
				s_step[i_egaki_dankai].set(moyori_senbun);//s_step[i_egaki_dankai].setcolor(i_egaki_dankai);

			//return;
			}
		}

//		if(i_egaki_dankai==13){
		if(i_egaki_dankai==2+ (honsuu)  +1  +1){
			i_egaki_dankai=0;

			//s_step[12]‚Æs_step[13]‚ÌŒð“_‚Íoc.kouten_motome(Senbun s1,Senbun s2)‚Å‹?‚ß‚é//‚Q‚Â‚Ì?ü•ª‚ð’¼?ü‚Æ‚Ý‚È‚µ‚ÄŒð“_‚ð‹?‚ß‚éŠÖ?”?B?ü•ª‚Æ‚µ‚Ä‚ÍŒð?·‚µ‚È‚­‚Ä‚à?A’¼?ü‚Æ‚µ‚ÄŒð?·‚µ‚Ä‚¢‚é?ê?‡‚ÌŒð“_‚ð•Ô‚·
//			Ten kousa_ten =new Ten(); kousa_ten.set(oc.kouten_motome(s_step[12],s_step[13]));
			Ten kousa_ten =new Ten(); kousa_ten.set(oc.kouten_motome(s_step[2+ (honsuu)  +1 ],s_step[2+ (honsuu)  +1  +1]));
			Senbun add_sen =new Senbun(kousa_ten,s_step[2].geta());
			if(add_sen.getnagasa()>0.00000001){addsenbun(add_sen);kiroku();}
			return;
	*/
        }


    }

    //ƒ}ƒEƒX‘€?ì(ƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mDragged_A_18(Ten p0) {
    }

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mReleased_A_18(Ten p0) {
    }

//------


//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA


//14 14 14 14 14 14 14 14 14    i_mouse_modeA==14?@;V’Ç‰Áƒ‚?[ƒh

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ
    public void mPressed_A_14(Ten p0) {
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        int mts_id;
        mts_id = ori_s.mottomo_tikai_senbun_sagasi(p);//mts_id‚Í“_p‚É?Å‚à‹ß‚¢?ü•ª‚Ì”Ô?†	public int ori_s.mottomo_tikai_senbun_sagasi(Ten p)
        Senbun mts = new Senbun(ori_s.geta(mts_id), ori_s.getb(mts_id));//mts‚Í“_p‚É?Å‚à‹ß‚¢?ü•ª

        if (oc.kyori_senbun(p, mts) < d_hantei_haba) {
            //’¼?üt?ã‚Ì“_p‚Ì‰e‚ÌˆÊ’u?i“_p‚Æ?Å‚à‹ß‚¢’¼?üt?ã‚ÌˆÊ’u?j‚ð‹?‚ß‚é?Bpublic Ten oc.kage_motome(Tyokusen t,Ten p){}
            //?ü•ª‚ðŠÜ‚Þ’¼?ü‚ð“¾‚é public Tyokusen oc.Senbun2Tyokusen(Senbun s){}
            Ten pk = new Ten();
            pk.set(oc.kage_motome(oc.Senbun2Tyokusen(mts), p));//pk‚Í“_p‚Ì?i?ü•ª‚ðŠÜ‚Þ’¼?ü?ã‚Ì?j‰e

            //“_pa‚ª?A“ñ“_p1,p2‚ð’[“_‚Æ‚·‚é?ü•ª‚É“_p1‚Æ“_p2‚Å’¼?s‚·‚é?A2‚Â‚Ì?ü•ª‚ðŠÜ‚Þ’·•ûŒ`“à‚É‚ ‚é?ê?‡‚Í2‚ð•Ô‚·ŠÖ?”	public int oc.hakononaka(Ten p1,Ten pa,Ten p2){}

            if (oc.hakononaka(mts.geta(), pk, mts.getb()) == 2) {
                //?ü•ª‚Ì•ªŠ„-----------------------------------------
                ori_s.senbun_bunkatu(mts_id, pk);  //i”Ô–Ú‚Ì?ü•ª(’[“_a‚Æb)‚ð“_p‚Å•ªŠ„‚·‚é?Bi”Ô–Ú‚Ì?ü•ªab‚ðap‚É•Ï‚¦?A?ü•ªpb‚ð‰Á‚¦‚é?B
                kiroku();
            }

        }
        return;

    }

    //ƒ}ƒEƒX‘€?ì(ƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mDragged_A_14(Ten p0) {
    }

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mReleased_A_14(Ten p0) {
    }

//------


    public void v_del_all() {
        int sousuu_old = ori_s.getsousuu();
        ori_s.del_V_all();
        if (sousuu_old != ori_s.getsousuu()) {
            kiroku();
        }
    }

    public void v_del_all_cc() {
        int sousuu_old = ori_s.getsousuu();
        ori_s.del_V_all_cc();
        if (sousuu_old != ori_s.getsousuu()) {
            kiroku();
        }
    }

    // ------------------------------------------------------------
    public void all_s_step_to_orisen() {//20181014

        Senbun add_sen = new Senbun();
        for (int i = 1; i <= i_egaki_dankai; i++) {

            if (s_step[i].getnagasa() > 0.00000001) {
                add_sen.set(s_step[i]);
                add_sen.setcolor(icol);
                addsenbun(add_sen);
            } else {

                add_en(s_step[i].getax(), s_step[i].getay(), 5.0, 3);
            }
        }
        kiroku();

        //i_kouho_dankai//int sousuu_old =ori_s.getsousuu();
        //ori_s.del_V_all_cc();
        //if(sousuu_old !=ori_s.getsousuu()){kiroku();}
    }

//15 15 15 15 15 15 15 15 15    i_mouse_modeA==15?@;V?í?œƒ‚?[ƒh

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ
    public void mPressed_A_15(Ten p0) {


        //Ten p =new Ten();
        p.set(camera.TV2object(p0));

        //“_p‚É?Å‚à‹ß‚¢?ü•ª‚Ì?A“_p‚É‹ß‚¢•û‚Ì’[“_‚ð?A’¸“_‚Æ‚µ‚½?ê?‡?A‰½–{‚Ì?ü•ª‚ª?o‚Ä‚¢‚é‚©?i’¸“_‚ÆrˆÈ“à‚É’[“_‚ª‚ ‚é?ü•ª‚Ì?”?j	public int tyouten_syuui_sennsuu(Ten p) {

        ori_s.del_V(p, d_hantei_haba, 0.000001);
        kiroku();


    }

    //ƒ}ƒEƒX‘€?ì(ƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mDragged_A_15(Ten p0) {
    }

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mReleased_A_15(Ten p0) {
    }


//------

//41 41 41 41 41 41 41 41    i_mouse_modeA==41?@;V?í?œƒ‚?[ƒh(2‚Â‚Ì?Ü?ü‚Ì?F‚ªˆá‚Á‚½?ê?‡ƒJƒ‰?[ƒ`ƒFƒ“ƒW‚µ‚Ä?A“_?í?œ‚·‚é?B?•?Ô‚Í?Ô?Ô?A?•?Â‚Í?Â?Â?A?Â?Ô‚Í?•‚É‚·‚é)

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ
    public void mPressed_A_41(Ten p0) {


        //Ten p =new Ten();
        p.set(camera.TV2object(p0));

        //“_p‚É?Å‚à‹ß‚¢?ü•ª‚Ì?A“_p‚É‹ß‚¢•û‚Ì’[“_‚ð?A’¸“_‚Æ‚µ‚½?ê?‡?A‰½–{‚Ì?ü•ª‚ª?o‚Ä‚¢‚é‚©?i’¸“_‚ÆrˆÈ“à‚É’[“_‚ª‚ ‚é?ü•ª‚Ì?”?j	public int tyouten_syuui_sennsuu(Ten p) {

        ori_s.del_V_cc(p, d_hantei_haba, 0.000001);


        kiroku();


    }

    //ƒ}ƒEƒX‘€?ì(ƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mDragged_A_41(Ten p0) {
    }

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mReleased_A_41(Ten p0) {
    }


//------


    //-------------------------
//23 23 23 23 23
    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==23 "->M" ‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ----------------------------------------------------
    public void mPressed_A_23(Ten p0) {
        mPressed_A_box_select(p0);
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==23‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mDragged_A_23(Ten p0) {
        mDragged_A_box_select(p0);
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==23 ‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mReleased_A_23(Ten p0) {//‚±‚±‚Ì?ˆ—?‚Ì?I‚í‚è‚É fix2(0.001,0.5);?@‚ð‚·‚é‚Ì‚Í?AŒ³‚©‚ç?Ü?ü‚¾‚Á‚½‚à‚Ì‚Æ?A•â?•?ü‚©‚ç•ÏŠ·‚µ‚½?Ü?ü‚Æ‚Ì‘g?‡‚¹‚Å•p”­‚·‚éTŽšŒ^•s?Ú‘±‚ð?C?³‚·‚é‚½‚ß
        i_egaki_dankai = 0;

        if (p19_1.kyori(p0) > 0.000001) {//Œ»?ó‚Å‚Í?Ô‚ð?Ô‚É•Ï‚¦‚½‚Æ‚«‚àUNDO—p‚É‹L˜^‚³‚ê‚Ä‚µ‚Ü‚¤20161218
            if (M_nisuru(p19_1, p0) != 0) {
                fix2(0.001, 0.5);
                kiroku();
            }
        }
        if (p19_1.kyori(p0) <= 0.000001) {//Œ»?ó‚Å‚Í?Ô‚ð?Ô‚É•Ï‚¦‚½‚Æ‚«‚àUNDO—p‚É‹L˜^‚³‚ê‚Ä‚µ‚Ü‚¤20161218
            //Ten p =new Ten();
            p.set(camera.TV2object(p0));
            if (ori_s.mottomo_tikai_senbun_kyori(p) < d_hantei_haba) {//“_p‚É?Å‚à‹ß‚¢?ü•ª‚Ì”Ô?†‚Å‚Ì?A‚»‚Ì‹——£‚ð•Ô‚·	public double mottomo_tikai_senbun_kyori(Ten p)
                ori_s.setcolor(ori_s.mottomo_tikai_senbun_sagasi(p), 1);
                fix2(0.001, 0.5);
                kiroku();
            }
        }

    }

    //--------------------
    public int M_nisuru(Ten p0a, Ten p0b) {
        Ten p0_a = new Ten();
        Ten p0_b = new Ten();
        Ten p0_c = new Ten();
        Ten p0_d = new Ten();
        Ten p_a = new Ten();
        Ten p_b = new Ten();
        Ten p_c = new Ten();
        Ten p_d = new Ten();
        p0_a.set(p0a.getx(), p0a.gety());
        p0_b.set(p0a.getx(), p0b.gety());
        p0_c.set(p0b.getx(), p0b.gety());
        p0_d.set(p0b.getx(), p0a.gety());
        p_a.set(camera.TV2object(p0_a));
        p_b.set(camera.TV2object(p0_b));
        p_c.set(camera.TV2object(p0_c));
        p_d.set(camera.TV2object(p0_d));
        return ori_s.M_nisuru(p_a, p_b, p_c, p_d);
    }


    //---------------------
//24 24 24 24 24
    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==24 "->V" ‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ----------------------------------------------------
    public void mPressed_A_24(Ten p0) {
        mPressed_A_box_select(p0);
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==24‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mDragged_A_24(Ten p0) {
        mDragged_A_box_select(p0);
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==24 ‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mReleased_A_24(Ten p0) {//‚±‚±‚Ì?ˆ—?‚Ì?I‚í‚è‚É fix2(0.001,0.5);?@‚ð‚·‚é‚Ì‚Í?AŒ³‚©‚ç?Ü?ü‚¾‚Á‚½‚à‚Ì‚Æ?A•â?•?ü‚©‚ç•ÏŠ·‚µ‚½?Ü?ü‚Æ‚Ì‘g?‡‚¹‚Å•p”­‚·‚éTŽšŒ^•s?Ú‘±‚ð?C?³‚·‚é‚½‚ß
        i_egaki_dankai = 0;

        if (p19_1.kyori(p0) > 0.000001) {
            //V_nisuru(p19_1,p0);
            if (V_nisuru(p19_1, p0) != 0) {
                fix2(0.001, 0.5);
                kiroku();
            }
        }
        if (p19_1.kyori(p0) <= 0.000001) {
            //Ten p =new Ten();
            p.set(camera.TV2object(p0));
            if (ori_s.mottomo_tikai_senbun_kyori(p) < d_hantei_haba) {//“_p‚É?Å‚à‹ß‚¢?ü•ª‚Ì”Ô?†‚Å‚Ì?A‚»‚Ì‹——£‚ð•Ô‚·	public double mottomo_tikai_senbun_kyori(Ten p)
                ori_s.setcolor(ori_s.mottomo_tikai_senbun_sagasi(p), 2);
                fix2(0.001, 0.5);
                kiroku();
            }
        }


    }

    //--------------------
    public int V_nisuru(Ten p0a, Ten p0b) {
        Ten p0_a = new Ten();
        Ten p0_b = new Ten();
        Ten p0_c = new Ten();
        Ten p0_d = new Ten();
        Ten p_a = new Ten();
        Ten p_b = new Ten();
        Ten p_c = new Ten();
        Ten p_d = new Ten();
        p0_a.set(p0a.getx(), p0a.gety());
        p0_b.set(p0a.getx(), p0b.gety());
        p0_c.set(p0b.getx(), p0b.gety());
        p0_d.set(p0b.getx(), p0a.gety());
        p_a.set(camera.TV2object(p0_a));
        p_b.set(camera.TV2object(p0_b));
        p_c.set(camera.TV2object(p0_c));
        p_d.set(camera.TV2object(p0_d));
        return ori_s.V_nisuru(p_a, p_b, p_c, p_d);
    }

    //---------------------
//25 25 25 25 25
    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==25 "->E" ‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ----------------------------------------------------
    public void mPressed_A_25(Ten p0) {
        mPressed_A_box_select(p0);
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==25‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mDragged_A_25(Ten p0) {
        mDragged_A_box_select(p0);
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==25 ‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mReleased_A_25(Ten p0) {//‚±‚±‚Ì?ˆ—?‚Ì?I‚í‚è‚É fix2(0.001,0.5);?@‚ð‚·‚é‚Ì‚Í?AŒ³‚©‚ç?Ü?ü‚¾‚Á‚½‚à‚Ì‚Æ?A•â?•?ü‚©‚ç•ÏŠ·‚µ‚½?Ü?ü‚Æ‚Ì‘g?‡‚¹‚Å•p”­‚·‚éTŽšŒ^•s?Ú‘±‚ð?C?³‚·‚é‚½‚ß
        i_egaki_dankai = 0;


        //E_nisuru(p19_1,p0);

        if (p19_1.kyori(p0) > 0.000001) {
            if (E_nisuru(p19_1, p0) != 0) {
                fix2(0.001, 0.5);
                kiroku();
            }
        }

        if (p19_1.kyori(p0) <= 0.000001) {
            //Ten p =new Ten();
            p.set(camera.TV2object(p0));
            if (ori_s.mottomo_tikai_senbun_kyori(p) < d_hantei_haba) {//“_p‚É?Å‚à‹ß‚¢?ü•ª‚Ì”Ô?†‚Å‚Ì?A‚»‚Ì‹——£‚ð•Ô‚·	public double mottomo_tikai_senbun_kyori(Ten p)
                ori_s.setcolor(ori_s.mottomo_tikai_senbun_sagasi(p), 0);
                fix2(0.001, 0.5);
                kiroku();
            }
        }


    }

    //--------------------
    public int E_nisuru(Ten p0a, Ten p0b) {
        Ten p0_a = new Ten();
        Ten p0_b = new Ten();
        Ten p0_c = new Ten();
        Ten p0_d = new Ten();
        Ten p_a = new Ten();
        Ten p_b = new Ten();
        Ten p_c = new Ten();
        Ten p_d = new Ten();
        p0_a.set(p0a.getx(), p0a.gety());
        p0_b.set(p0a.getx(), p0b.gety());
        p0_c.set(p0b.getx(), p0b.gety());
        p0_d.set(p0b.getx(), p0a.gety());
        p_a.set(camera.TV2object(p0_a));
        p_b.set(camera.TV2object(p0_b));
        p_c.set(camera.TV2object(p0_c));
        p_d.set(camera.TV2object(p0_d));
        return ori_s.E_nisuru(p_a, p_b, p_c, p_d);
    }

//---------------------

    //60 60 60 60 60
    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==60 "->HK" ‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ----------------------------------------------------
    public void mPressed_A_60(Ten p0) {
        mPressed_A_box_select(p0);
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==60‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mDragged_A_60(Ten p0) {
        mDragged_A_box_select(p0);
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==60 ‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mReleased_A_60(Ten p0) {
        i_egaki_dankai = 0;

        if (p19_1.kyori(p0) > 0.000001) {
            if (HK_nisuru(p19_1, p0) != 0) {
                kiroku();
            }//‚±‚ÌŠÖ?”‚Í•sŠ®‘S‚È‚Ì‚Å‚Ü‚¾–¢ŒöŠJ20171126
        }

        if (p19_1.kyori(p0) <= 0.000001) {
            //Ten p =new Ten();
            p.set(camera.TV2object(p0));
            if (ori_s.mottomo_tikai_senbun_kyori(p) < d_hantei_haba) {//“_p‚É?Å‚à‹ß‚¢?ü•ª‚Ì”Ô?†‚Å‚Ì?A‚»‚Ì‹——£‚ð•Ô‚·	public double mottomo_tikai_senbun_kyori(Ten p)
                //ori_s.setcolor(ori_s.mottomo_tikai_senbun_sagasi(p),3);
                if (ori_s.getcolor(ori_s.mottomo_tikai_senbun_sagasi_gyakujyun(p)) < 3) {

                    Senbun add_sen = new Senbun();
                    add_sen.set(ori_s.get(ori_s.mottomo_tikai_senbun_sagasi_gyakujyun(p)));
                    add_sen.setcolor(3);

                    ori_s.delsenbun_vertex(ori_s.mottomo_tikai_senbun_sagasi_gyakujyun(p));
                    addsenbun(add_sen);

                    en_seiri();
                    kiroku();
                }


                //kiroku();
            }
        }


    }

    //--------------------
    public int HK_nisuru(Ten p0a, Ten p0b) {
        Ten p0_a = new Ten();
        Ten p0_b = new Ten();
        Ten p0_c = new Ten();
        Ten p0_d = new Ten();
        Ten p_a = new Ten();
        Ten p_b = new Ten();
        Ten p_c = new Ten();
        Ten p_d = new Ten();
        p0_a.set(p0a.getx(), p0a.gety());
        p0_b.set(p0a.getx(), p0b.gety());
        p0_c.set(p0b.getx(), p0b.gety());
        p0_d.set(p0b.getx(), p0a.gety());
        p_a.set(camera.TV2object(p0_a));
        p_b.set(camera.TV2object(p0_b));
        p_c.set(camera.TV2object(p0_c));
        p_d.set(camera.TV2object(p0_d));
        return ori_s.HK_nisuru(p_a, p_b, p_c, p_d);
    }


//camera.object2TV

    public Senbun get_s_step(int i) {
        return s_step[i];
    }


//26 26 26 26    i_mouse_modeA==26?@;”wŒisetƒ‚?[ƒh?B

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ
    public void mPressed_A_26(Ten p0) {


        //Ten p =new Ten();
        p.set(camera.TV2object(p0));

        if (i_egaki_dankai == 3) {
            i_egaki_dankai = 4;
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                p.set(moyori_ten);
            }
            s_step[4].set(p, p);
            s_step[4].setcolor(i_egaki_dankai);
        }

        if (i_egaki_dankai == 2) {
            i_egaki_dankai = 3;
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                p.set(moyori_ten);
            }
            s_step[3].set(p, p);
            s_step[3].setcolor(i_egaki_dankai);
        }

        if (i_egaki_dankai == 1) {
            i_egaki_dankai = 2;
            s_step[2].set(p, p);
            s_step[2].setcolor(i_egaki_dankai);
        }

        if (i_egaki_dankai == 0) {
            i_egaki_dankai = 1;
            s_step[1].set(p, p);
            s_step[1].setcolor(i_egaki_dankai);
        }
    }

    //ƒ}ƒEƒX‘€?ì(ƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mDragged_A_26(Ten p0) {
    }

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public int mReleased_A_26(Ten p0) {
        return i_egaki_dankai;
    }

//------


//42 42 42 42 42 42 42 42 42 42 42 42 42 42 42?@‚±‚±‚©‚ç

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==42 ‰~“ü—Í?@‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ----------------------------------------------------
    public void mPressed_A_42(Ten p0) {
        i_egaki_dankai = 1;
        i_en_egaki_dankai = 1;

        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        moyori_ten.set(get_moyori_ten(p));
        if (p.kyori(moyori_ten) > d_hantei_haba) {
            i_egaki_dankai = 0;
            i_en_egaki_dankai = 0;
        }
        s_step[1].set(p, moyori_ten);
        s_step[1].setcolor(3);
        e_step[1].set(moyori_ten.getx(), moyori_ten.gety(), 0.0);
        e_step[1].setcolor(3);


//System.out.println("20170225  s_step[1].getax()"+s_step[1].getax());

//s_step[1].set(new Ten(200.0,200.0),new Ten(300.0,300.0));
        //k.addsenbun(p,p);
        //ieda=k.getsousuu();
        //k.setcolor(ieda,icol);
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==42 ‰~“ü—Í?@‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mDragged_A_42(Ten p0) {

        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        s_step[1].seta(p);
        e_step[1].setr(oc.kyori(s_step[1].geta(), s_step[1].getb()));

        //k.seta(ieda, p);
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==42 ‰~“ü—Í?@‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mReleased_A_42(Ten p0) {
        if (i_egaki_dankai == 1) {
            i_egaki_dankai = 0;
            i_en_egaki_dankai = 0;

            //Ten p =new Ten();
            p.set(camera.TV2object(p0));
            moyori_ten.set(get_moyori_ten(p));
            s_step[1].seta(moyori_ten);
            if (p.kyori(moyori_ten) <= d_hantei_haba) {
                if (s_step[1].getnagasa() > 0.00000001) {
                    //addsenbun(s_step[1]);
                    add_en(s_step[1].getbx(), s_step[1].getby(), s_step[1].getnagasa(), 3);
                    kiroku();
                }
            }

//System.out.println("20170227  ********************1");
//			Memo mtemp =new Memo();
//System.out.println("20170227  ********************2");
//			mtemp.set(getMemo());
//System.out.println("20170227  ********************3");
//			setMemo(mtemp);


        }

    }

//42 42 42 42 42 42 42 42 42 42 42 42 42 42 42  ‚±‚±‚Ü‚Å


//47 47 47 47 47 47 47 47 47 47 47 47 47 47 47?@‚±‚±‚©‚ç

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==47 ‰~“ü—Í(ƒtƒŠ?[?@)?@‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ----------------------------------------------------
    public void mPressed_A_47(Ten p0) {
        i_egaki_dankai = 1;
        i_en_egaki_dankai = 1;

        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        moyori_ten.set(get_moyori_ten(p));
        if (p.kyori(moyori_ten) > d_hantei_haba) {
            s_step[1].set(p, p);
            s_step[1].setcolor(3);
            e_step[1].set(p.getx(), p.gety(), 0.0);
            e_step[1].setcolor(3);
        } else {
            s_step[1].set(p, moyori_ten);
            s_step[1].setcolor(3);
            e_step[1].set(moyori_ten.getx(), moyori_ten.gety(), 0.0);
            e_step[1].setcolor(3);
        }
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==47 ‰~“ü—Í?@‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mDragged_A_47(Ten p0) {
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        s_step[1].seta(p);
        e_step[1].setr(oc.kyori(s_step[1].geta(), s_step[1].getb()));
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==47 ‰~“ü—Í?@‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mReleased_A_47(Ten p0) {
        if (i_egaki_dankai == 1) {
            i_egaki_dankai = 0;
            i_en_egaki_dankai = 0;

            //Ten p =new Ten();
            p.set(camera.TV2object(p0));
            moyori_ten.set(get_moyori_ten(p));

            if (p.kyori(moyori_ten) <= d_hantei_haba) {
                s_step[1].seta(moyori_ten);
            } else {
                s_step[1].seta(p);
            }

            if (s_step[1].getnagasa() > 0.00000001) {
                add_en(s_step[1].getbx(), s_step[1].getby(), s_step[1].getnagasa(), 3);
                kiroku();
            }
        }
    }

//47 47 47 47 47 47 47 47 47 47 47 47 47 47 47  ‚±‚±‚Ü‚Å


//44 44 44 44 44 44 44 44 44 44 44 44 44 44 44?@‚±‚±‚©‚ç

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==44 ‰~ •ª—£“ü—Í?@‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ----------------------------------------------------
    public void mPressed_A_44(Ten p0) {
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        moyori_ten.set(get_moyori_ten(p));

        if (i_egaki_dankai == 0) {
            i_egaki_dankai = 0;
            i_en_egaki_dankai = 0;
            if (p.kyori(moyori_ten) > d_hantei_haba) {
                return;
            }

            i_egaki_dankai = 1;
            i_en_egaki_dankai = 0;
            s_step[1].set(moyori_ten, moyori_ten);
            s_step[1].setcolor(3);
            return;
        }

        if (i_egaki_dankai == 1) {
            i_egaki_dankai = 1;
            i_en_egaki_dankai = 0;
            if (p.kyori(moyori_ten) > d_hantei_haba) {
                return;
            }

            i_egaki_dankai = 2;
            i_en_egaki_dankai = 1;
            s_step[2].set(p, moyori_ten);
            s_step[2].setcolor(3);
            e_step[1].set(s_step[1].geta(), 0.0, 3);
            return;
        }


    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==44 ‰~ •ª—£“ü—Í?@‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mDragged_A_44(Ten p0) {
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        if (i_egaki_dankai == 2) {
            i_egaki_dankai = 2;
            i_en_egaki_dankai = 1;
            s_step[2].seta(p);
            e_step[1].setr(s_step[2].getnagasa());
        }
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==44 ‰~ •ª—£“ü—Í?@‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mReleased_A_44(Ten p0) {
        if (i_egaki_dankai == 2) {
            i_egaki_dankai = 0;
            i_en_egaki_dankai = 0;

            //Ten p =new Ten();
            p.set(camera.TV2object(p0));
            moyori_ten.set(get_moyori_ten(p));
            s_step[2].seta(moyori_ten);
            if (p.kyori(moyori_ten) <= d_hantei_haba) {
                if (s_step[2].getnagasa() > 0.00000001) {
                    addsenbun(s_step[2]);
                    add_en(s_step[1].geta(), s_step[2].getnagasa(), 3);
                    kiroku();
                }
            }

//System.out.println("20170227  ********************1");
//			Memo mtemp =new Memo();
//System.out.println("20170227  ********************2");
//			mtemp.set(getMemo());
//System.out.println("20170227  ********************3");
//			setMemo(mtemp);


        }

    }

//44 44 44 44 44 44 44 44 44 44 44 44 44 44 44  ‚±‚±‚Ü‚Å


//48 48 48 48 48 48 48 48 48 48 48 48 48 48 48?@‚±‚±‚©‚ç

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==48 “¯?S‰~?@?ü•ª“ü—Í?@‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ----------------------------------------------------
    public void mPressed_A_48(Ten p0) {

        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        moyori_ensyuu.set(get_moyori_ensyuu(p));
        moyori_ten.set(get_moyori_ten(p));

        if ((i_egaki_dankai == 0) && (i_en_egaki_dankai == 0)) {
            if (oc.kyori_ensyuu(p, moyori_ensyuu) > d_hantei_haba) {
                return;
            }

            i_egaki_dankai = 0;
            i_en_egaki_dankai = 1;
            e_step[1].set(moyori_ensyuu);
            e_step[1].setcolor(6);
            return;
        }


        if ((i_egaki_dankai == 0) && (i_en_egaki_dankai == 1)) {
            if (p.kyori(moyori_ten) > d_hantei_haba) {
                return;
            }

            i_egaki_dankai = 1;
            i_en_egaki_dankai = 2;
            s_step[1].set(p, moyori_ten);
            s_step[1].setcolor(3);
            e_step[2].set(e_step[1]);
            e_step[2].setcolor(3);
            return;
        }
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==48 “¯?S‰~?@?ü•ª“ü—Í?@‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mDragged_A_48(Ten p0) {
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        if ((i_egaki_dankai == 1) && (i_en_egaki_dankai == 2)) {
            s_step[1].seta(p);
            e_step[2].setr(e_step[1].getr() + s_step[1].getnagasa());
        }
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==48 “¯?S‰~?@?ü•ª“ü—Í?@‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mReleased_A_48(Ten p0) {
        if ((i_egaki_dankai == 1) && (i_en_egaki_dankai == 2)) {
            i_egaki_dankai = 0;
            i_en_egaki_dankai = 0;

            //Ten p =new Ten();
            p.set(camera.TV2object(p0));
            moyori_ten.set(get_moyori_ten(p));
            s_step[1].seta(moyori_ten);
            if (p.kyori(moyori_ten) <= d_hantei_haba) {
                if (s_step[1].getnagasa() > 0.00000001) {
                    addsenbun(s_step[1]);
                    e_step[2].setr(e_step[1].getr() + s_step[1].getnagasa());
                    add_en(e_step[2]);
                    kiroku();
                }
            }
        }
    }

//48 48 48 48 48 48 48 48 48 48 48 48 48 48 48  ‚±‚±‚Ü‚Å

//49 49 49 49 49 49 49 49 49 49 49 49 49 49 49?@‚±‚±‚©‚ç

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==49 “¯?S‰~?@“¯?S‰~“ü—Í?@‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ----------------------------------------------------
    public void mPressed_A_49(Ten p0) {
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        moyori_ensyuu.set(get_moyori_ensyuu(p));
        moyori_ten.set(get_moyori_ten(p));

        if ((i_egaki_dankai == 0) && (i_en_egaki_dankai == 0)) {
            if (oc.kyori_ensyuu(p, moyori_ensyuu) > d_hantei_haba) {
                return;
            }

            i_egaki_dankai = 0;
            i_en_egaki_dankai = 1;
            e_step[1].set(moyori_ensyuu);
            e_step[1].setcolor(6);
            return;
        }

        if ((i_egaki_dankai == 0) && (i_en_egaki_dankai == 1)) {
            //if(p.kyori(moyori_ten)>d_hantei_haba){return;}
            if (oc.kyori_ensyuu(p, moyori_ensyuu) > d_hantei_haba) {
                return;
            }

            i_egaki_dankai = 0;
            i_en_egaki_dankai = 2;
            e_step[2].set(moyori_ensyuu);
            e_step[2].setcolor(8);
            return;
        }

        if ((i_egaki_dankai == 0) && (i_en_egaki_dankai == 2)) {
            //if(p.kyori(moyori_ten)>d_hantei_haba){return;}
            if (oc.kyori_ensyuu(p, moyori_ensyuu) > d_hantei_haba) {
                return;
            }

            i_egaki_dankai = 0;
            i_en_egaki_dankai = 3;
            e_step[3].set(moyori_ensyuu);
            e_step[3].setcolor(8);
            return;
        }
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==49 “¯?S‰~?@“¯?S‰~“ü—Í?@‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mDragged_A_49(Ten p0) {

    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==49 “¯?S‰~?@“¯?S‰~“ü—Í?@‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mReleased_A_49(Ten p0) {
        if ((i_egaki_dankai == 0) && (i_en_egaki_dankai == 3)) {
            i_egaki_dankai = 0;
            i_en_egaki_dankai = 0;
            double add_r = e_step[3].getr() - e_step[2].getr();
            if (Math.abs(add_r) > 0.00000001) {
                double new_r = add_r + e_step[1].getr();

                if (new_r > 0.00000001) {
                    e_step[1].setr(new_r);
                    e_step[1].setcolor(3);
                    add_en(e_step[1]);
                    kiroku();
                }
            }
        }
    }

//49 49 49 49 49 49 49 49 49 49 49 49 49 49 49  ‚±‚±‚Ü‚Å

//51 51 51 51 51 51 51 51 51 51 51 51 51 51 51?@‚±‚±‚©‚ç

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==51 •½?s?ü?@•?Žw’è“ü—Íƒ‚?[ƒh?@‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ----------------------------------------------------
    public void mPressed_A_51(Ten p0) {
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        moyori_ten.set(get_moyori_ten(p));

        if ((i_egaki_dankai == 0) && (i_en_egaki_dankai == 0)) {
            moyori_senbun.set(get_moyori_senbun(p));
            if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {
                i_egaki_dankai = 1;
                i_en_egaki_dankai = 0;
                s_step[1].set(moyori_senbun);
                s_step[1].setcolor(6);
            }
            return;
        }

        if ((i_egaki_dankai == 1) && (i_en_egaki_dankai == 0)) {
            if (p.kyori(moyori_ten) > d_hantei_haba) {
                return;
            }
            i_egaki_dankai = 4;
            i_en_egaki_dankai = 0;
            s_step[2].set(p, moyori_ten);
            s_step[2].setcolor(3);
            s_step[3].set(s_step[1]);
            s_step[3].setcolor(8);
            s_step[4].set(s_step[1]);
            s_step[4].setcolor(8);
            return;
        }


        if ((i_egaki_dankai == 4) && (i_en_egaki_dankai == 0)) {
            //if(p.kyori(moyori_ten)>d_hantei_haba){return;}

            i_egaki_dankai = 3;
            i_en_egaki_dankai = 0;
            moyori_step_senbun.set(get_moyori_step_senbun(p, 3, 4));

            //if(oc.kyori_senbun(p,moyori_step_senbun)>d_hantei_haba){return;}
            s_step[3].set(moyori_step_senbun);
            return;
        }


    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==51 •½?s?ü?@•?Žw’è“ü—Íƒ‚?[ƒh?@‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mDragged_A_51(Ten p0) {
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        if ((i_egaki_dankai == 4) && (i_en_egaki_dankai == 0)) {
            s_step[2].seta(p);
            s_step[3].set(oc.mayoko_idou(s_step[1], s_step[2].getnagasa()));
            s_step[3].setcolor(8);
            s_step[4].set(oc.mayoko_idou(s_step[1], -s_step[2].getnagasa()));
            s_step[4].setcolor(8);
        }
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==51 •½?s?ü?@•?Žw’è“ü—Íƒ‚?[ƒh?@‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”----------------------------------------------------
    public void mReleased_A_51(Ten p0) {
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        moyori_ten.set(get_moyori_ten(p));

        if ((i_egaki_dankai == 4) && (i_en_egaki_dankai == 0)) {
            if (p.kyori(moyori_ten) >= d_hantei_haba) {
                i_egaki_dankai = 1;
                i_en_egaki_dankai = 0;
                return;
            }

            s_step[2].seta(moyori_ten);

            if (s_step[2].getnagasa() < 0.00000001) {
                i_egaki_dankai = 1;
                i_en_egaki_dankai = 0;
                return;
            }
            s_step[3].set(oc.mayoko_idou(s_step[1], s_step[2].getnagasa()));
            s_step[3].setcolor(8);
            s_step[4].set(oc.mayoko_idou(s_step[1], -s_step[2].getnagasa()));
            s_step[4].setcolor(8);
        }


        if ((i_egaki_dankai == 3) && (i_en_egaki_dankai == 0)) {
            i_egaki_dankai = 0;
            i_en_egaki_dankai = 0;

            s_step[3].setcolor(icol);
            addsenbun(s_step[3]);
            kiroku();

            return;
        }


    }

//51 51 51 51 51 51 51 51 51 51 51 51 51 51 51  ‚±‚±‚Ü‚Å

//45 45 45 45 45 45 45 45 45   i_mouse_modeA==45?@;2‰~‚Ì‹¤’Ê?Ú?ü“ü—Íƒ‚?[ƒh?B

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ
    public void mPressed_A_45(Ten p0) {
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        moyori_ensyuu.set(get_moyori_ensyuu(p));

        if (i_en_egaki_dankai == 0) {
            i_egaki_dankai = 0;
            i_en_egaki_dankai = 0;
            if (oc.kyori_ensyuu(p, moyori_ensyuu) > d_hantei_haba) {
                return;
            }

            i_egaki_dankai = 0;
            i_en_egaki_dankai = 1;
            e_step[1].set(moyori_ensyuu);
            e_step[1].setcolor(6);
            return;
        }

        if (i_en_egaki_dankai == 1) {
            i_egaki_dankai = 0;
            i_en_egaki_dankai = 1;
            if (oc.kyori_ensyuu(p, moyori_ensyuu) > d_hantei_haba) {
                return;
            }

            i_egaki_dankai = 0;
            i_en_egaki_dankai = 2;
            e_step[2].set(moyori_ensyuu);
            e_step[2].setcolor(6);
            return;
        }

        if (i_egaki_dankai > 1) {//			i_egaki_dankai=0;i_en_egaki_dankai=1;
            moyori_step_senbun.set(get_moyori_step_senbun(p, 1, i_egaki_dankai));

            if (oc.kyori_senbun(p, moyori_step_senbun) > d_hantei_haba) {
                return;
            }
            s_step[1].set(moyori_step_senbun);
            i_egaki_dankai = 1;
            i_en_egaki_dankai = 2;

            return;
        }


    }

    //ƒ}ƒEƒX‘€?ì(ƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mDragged_A_45(Ten p0) {
    }

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mReleased_A_45(Ten p0) {
        if ((i_egaki_dankai == 0) && (i_en_egaki_dankai == 2)) {
            Ten c1 = new Ten();
            c1.set(e_step[1].get_tyuusin());
            Ten c2 = new Ten();
            c2.set(e_step[2].get_tyuusin());

            double x1 = e_step[1].getx();
            double y1 = e_step[1].gety();
            double r1 = e_step[1].getr();
            double x2 = e_step[2].getx();
            double y2 = e_step[2].gety();
            double r2 = e_step[2].getr();
            //0,0,r,        xp,yp,R
            double xp = x2 - x1;
            double yp = y2 - y1;

            if (c1.kyori(c2) < 0.000001) {
                i_egaki_dankai = 0;
                i_en_egaki_dankai = 0;
                return;
            }//?Ú?ü0–{‚Ì?ê?‡

            if ((xp * xp + yp * yp) < (r1 - r2) * (r1 - r2)) {
                i_egaki_dankai = 0;
                i_en_egaki_dankai = 0;
                return;
            }//?Ú?ü0–{‚Ì?ê?‡

            if (Math.abs((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2)) < 0.0000001) {//ŠO?Ú?ü1–{‚Ì?ê?‡
                Ten kouten = new Ten();
                kouten.set(oc.naibun(c1, c2, -r1, r2));
                Tyokusen ty = new Tyokusen(c1, kouten);
                ty.tyokkouka(kouten);
                s_step[1].set(oc.en_to_tyokusen_no_kouten_wo_musubu_senbun(new En(kouten, (r1 + r2) / 2.0, 0), ty));

                i_egaki_dankai = 1;
                i_en_egaki_dankai = 2;
            }

            if (((r1 - r2) * (r1 - r2) < (xp * xp + yp * yp)) && ((xp * xp + yp * yp) < (r1 + r2) * (r1 + r2))) {//ŠO?Ú?ü2–{‚Ì?ê?‡
                double xq1 = r1 * (xp * (r1 - r2) + yp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//‹¤’ÊŠO?Ú?ü
                double yq1 = r1 * (yp * (r1 - r2) - xp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//‹¤’ÊŠO?Ú?ü
                double xq2 = r1 * (xp * (r1 - r2) - yp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//‹¤’ÊŠO?Ú?ü
                double yq2 = r1 * (yp * (r1 - r2) + xp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//‹¤’ÊŠO?Ú?ü

                double xr1 = xq1 + x1;
                double yr1 = yq1 + y1;
                double xr2 = xq2 + x1;
                double yr2 = yq2 + y1;

                Tyokusen t1 = new Tyokusen(x1, y1, xr1, yr1);
                t1.tyokkouka(new Ten(xr1, yr1));
                Tyokusen t2 = new Tyokusen(x1, y1, xr2, yr2);
                t2.tyokkouka(new Ten(xr2, yr2));

                s_step[1].set(new Ten(xr1, yr1), oc.kage_motome(t1, new Ten(x2, y2)));
                s_step[1].setcolor(8);
                s_step[2].set(new Ten(xr2, yr2), oc.kage_motome(t2, new Ten(x2, y2)));
                s_step[2].setcolor(8);

                i_egaki_dankai = 2;
                i_en_egaki_dankai = 2;

            }

            if (Math.abs((xp * xp + yp * yp) - (r1 + r2) * (r1 + r2)) < 0.0000001) {//ŠO?Ú?ü2–{‚Æ“à?Ú?ü1–{‚Ì?ê?‡
                double xq1 = r1 * (xp * (r1 - r2) + yp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//‹¤’ÊŠO?Ú?ü
                double yq1 = r1 * (yp * (r1 - r2) - xp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//‹¤’ÊŠO?Ú?ü
                double xq2 = r1 * (xp * (r1 - r2) - yp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//‹¤’ÊŠO?Ú?ü
                double yq2 = r1 * (yp * (r1 - r2) + xp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//‹¤’ÊŠO?Ú?ü

                double xr1 = xq1 + x1;
                double yr1 = yq1 + y1;
                double xr2 = xq2 + x1;
                double yr2 = yq2 + y1;

                Tyokusen t1 = new Tyokusen(x1, y1, xr1, yr1);
                t1.tyokkouka(new Ten(xr1, yr1));
                Tyokusen t2 = new Tyokusen(x1, y1, xr2, yr2);
                t2.tyokkouka(new Ten(xr2, yr2));

                s_step[1].set(new Ten(xr1, yr1), oc.kage_motome(t1, new Ten(x2, y2)));
                s_step[1].setcolor(8);
                s_step[2].set(new Ten(xr2, yr2), oc.kage_motome(t2, new Ten(x2, y2)));
                s_step[2].setcolor(8);

                // -----------------------

                Ten kouten = new Ten();
                kouten.set(oc.naibun(c1, c2, r1, r2));
                Tyokusen ty = new Tyokusen(c1, kouten);
                ty.tyokkouka(kouten);
                s_step[3].set(oc.en_to_tyokusen_no_kouten_wo_musubu_senbun(new En(kouten, (r1 + r2) / 2.0, 0), ty));
                s_step[3].setcolor(8);
                // -----------------------

                i_egaki_dankai = 3;
                i_en_egaki_dankai = 2;
            }

            if ((r1 + r2) * (r1 + r2) < (xp * xp + yp * yp)) {//ŠO?Ú?ü2–{‚Æ“à?Ú?ü2–{‚Ì?ê?‡
                //             ---------------------------------------------------------------
                //                                     -------------------------------------
                //                 -------               -------------   -------   -------       -------------
                double xq1 = r1 * (xp * (r1 - r2) + yp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//‹¤’ÊŠO?Ú?ü
                double yq1 = r1 * (yp * (r1 - r2) - xp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//‹¤’ÊŠO?Ú?ü
                double xq2 = r1 * (xp * (r1 - r2) - yp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//‹¤’ÊŠO?Ú?ü
                double yq2 = r1 * (yp * (r1 - r2) + xp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//‹¤’ÊŠO?Ú?ü
                double xq3 = r1 * (xp * (r1 + r2) + yp * Math.sqrt((xp * xp + yp * yp) - (r1 + r2) * (r1 + r2))) / (xp * xp + yp * yp);//‹¤’Ê“à?Ú?ü
                double yq3 = r1 * (yp * (r1 + r2) - xp * Math.sqrt((xp * xp + yp * yp) - (r1 + r2) * (r1 + r2))) / (xp * xp + yp * yp);//‹¤’Ê“à?Ú?ü
                double xq4 = r1 * (xp * (r1 + r2) - yp * Math.sqrt((xp * xp + yp * yp) - (r1 + r2) * (r1 + r2))) / (xp * xp + yp * yp);//‹¤’Ê“à?Ú?ü
                double yq4 = r1 * (yp * (r1 + r2) + xp * Math.sqrt((xp * xp + yp * yp) - (r1 + r2) * (r1 + r2))) / (xp * xp + yp * yp);//‹¤’Ê“à?Ú?ü


                double xr1 = xq1 + x1;
                double yr1 = yq1 + y1;
                double xr2 = xq2 + x1;
                double yr2 = yq2 + y1;
                double xr3 = xq3 + x1;
                double yr3 = yq3 + y1;
                double xr4 = xq4 + x1;
                double yr4 = yq4 + y1;

                Tyokusen t1 = new Tyokusen(x1, y1, xr1, yr1);
                t1.tyokkouka(new Ten(xr1, yr1));
                Tyokusen t2 = new Tyokusen(x1, y1, xr2, yr2);
                t2.tyokkouka(new Ten(xr2, yr2));
                Tyokusen t3 = new Tyokusen(x1, y1, xr3, yr3);
                t3.tyokkouka(new Ten(xr3, yr3));
                Tyokusen t4 = new Tyokusen(x1, y1, xr4, yr4);
                t4.tyokkouka(new Ten(xr4, yr4));

                s_step[1].set(new Ten(xr1, yr1), oc.kage_motome(t1, new Ten(x2, y2)));
                s_step[1].setcolor(8);
                s_step[2].set(new Ten(xr2, yr2), oc.kage_motome(t2, new Ten(x2, y2)));
                s_step[2].setcolor(8);
                s_step[3].set(new Ten(xr3, yr3), oc.kage_motome(t3, new Ten(x2, y2)));
                s_step[3].setcolor(8);
                s_step[4].set(new Ten(xr4, yr4), oc.kage_motome(t4, new Ten(x2, y2)));
                s_step[4].setcolor(8);

                //e_step[1].setcolor(3);
                //e_step[2].setcolor(3);

                i_egaki_dankai = 4;
                i_en_egaki_dankai = 2;

            }
        }

        if (i_egaki_dankai == 1) {

            i_egaki_dankai = 0;
            i_en_egaki_dankai = 0;

            s_step[1].setcolor(icol);
            addsenbun(s_step[1]);
            kiroku();

            return;
        }


    }

//45 45 45 45 45 45 45 45 45  ‚±‚±‚Ü‚Å  ------


//50 50 50 50 50 50 50 50 50   i_mouse_modeA==50?@;2‰~‚É•?“¯‚¶‚Å?Ú‚·‚é“¯?S‰~‚ð‰Á‚¦‚é?B

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ
    public void mPressed_A_50(Ten p0) {
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        moyori_ensyuu.set(get_moyori_ensyuu(p));
        moyori_ten.set(get_moyori_ten(p));

        if ((i_egaki_dankai == 0) && (i_en_egaki_dankai == 0)) {
            if (oc.kyori_ensyuu(p, moyori_ensyuu) > d_hantei_haba) {
                return;
            }

            i_egaki_dankai = 0;
            i_en_egaki_dankai = 1;
            e_step[1].set(moyori_ensyuu);
            e_step[1].setcolor(6);
            return;
        }

        if ((i_egaki_dankai == 0) && (i_en_egaki_dankai == 1)) {
            //if(p.kyori(moyori_ten)>d_hantei_haba){return;}
            if (oc.kyori_ensyuu(p, moyori_ensyuu) > d_hantei_haba) {
                return;
            }

            i_egaki_dankai = 0;
            i_en_egaki_dankai = 2;
            e_step[2].set(moyori_ensyuu);
            e_step[2].setcolor(6);
            return;
        }


    }

    //ƒ}ƒEƒX‘€?ì(ƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mDragged_A_50(Ten p0) {
    }

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mReleased_A_50(Ten p0) {
        if ((i_egaki_dankai == 0) && (i_en_egaki_dankai == 2)) {
            i_egaki_dankai = 0;
            i_en_egaki_dankai = 0;
            double add_r = (oc.kyori(e_step[1].get_tyuusin(), e_step[2].get_tyuusin()) - e_step[1].getr() - e_step[2].getr()) * 0.5;


            if (Math.abs(add_r) > 0.00000001) {
                double new_r1 = add_r + e_step[1].getr();
                double new_r2 = add_r + e_step[2].getr();

                if ((new_r1 > 0.00000001) && (new_r2 > 0.00000001)) {
                    e_step[1].setr(new_r1);
                    e_step[1].setcolor(3);
                    add_en(e_step[1]);
                    e_step[2].setr(new_r2);
                    e_step[2].setcolor(3);
                    add_en(e_step[2]);
                    kiroku();
                }
            }
        }

    }

//50 50 50 50 50 50 50 50 50  ‚±‚±‚Ü‚Å  ------


//46 46 46 46 46 46 46 46 46   i_mouse_modeA==46?@;”½“]“ü—Íƒ‚?[ƒh?B

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ
    public void mPressed_A_46(Ten p0) {
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));

        moyori_ensyuu.set(get_moyori_ensyuu(p));

        if (i_egaki_dankai + i_en_egaki_dankai == 0) {
            moyori_senbun.set(get_moyori_senbun(p));


            if (oc.kyori_senbun(p, moyori_senbun) < oc.kyori_ensyuu(p, moyori_ensyuu)) {//?ü•ª‚Ì•û‚ª‰~Žü‚æ‚è‹ß‚¢
                i_egaki_dankai = 0;
                i_en_egaki_dankai = 0;
                if (oc.kyori_senbun(p, moyori_senbun) > d_hantei_haba) {
                    return;
                }
                i_egaki_dankai = 1;
                i_en_egaki_dankai = 0;
                s_step[1].set(moyori_senbun);
                s_step[1].setcolor(6);
                return;
            }


            i_egaki_dankai = 0;
            i_en_egaki_dankai = 0;
            if (oc.kyori_ensyuu(p, moyori_ensyuu) > d_hantei_haba) {
                return;
            }

            i_egaki_dankai = 0;
            i_en_egaki_dankai = 1;
            e_step[1].set(moyori_ensyuu);
            e_step[1].setcolor(6);
            return;
        }

        if (i_egaki_dankai + i_en_egaki_dankai == 1) {
            if (oc.kyori_ensyuu(p, moyori_ensyuu) > d_hantei_haba) {
                return;
            }
            i_en_egaki_dankai = i_en_egaki_dankai + 1;
            e_step[i_en_egaki_dankai].set(moyori_ensyuu);
            e_step[i_en_egaki_dankai].setcolor(1);
            return;
        }


    }

    //ƒ}ƒEƒX‘€?ì(ƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mDragged_A_46(Ten p0) {
    }

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mReleased_A_46(Ten p0) {
        if ((i_egaki_dankai == 1) && (i_en_egaki_dankai == 1)) {

            add_hanten(s_step[1], e_step[1]);
            i_egaki_dankai = 0;
            i_en_egaki_dankai = 0;

        }

        if ((i_egaki_dankai == 0) && (i_en_egaki_dankai == 2)) {
            add_hanten(e_step[1], e_step[2]);
            i_egaki_dankai = 0;
            i_en_egaki_dankai = 0;
        }

    }

//46 46 46 46 46 46 46 46 46  ‚±‚±‚Ü‚Å  ------


//43 43 43 43 43 43 43 43 43   i_mouse_modeA==43?@;‰~3“_“ü—Íƒ‚?[ƒh?B

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ
    public void mPressed_A_43(Ten p0) {


        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        moyori_ten.set(get_moyori_ten(p));
        if (p.kyori(moyori_ten) < d_hantei_haba) {
            i_egaki_dankai = i_egaki_dankai + 1;
            s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
            s_step[i_egaki_dankai].setcolor(i_egaki_dankai);
        }


    }

    //ƒ}ƒEƒX‘€?ì(ƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mDragged_A_43(Ten p0) {
    }

    //ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mReleased_A_43(Ten p0) {
        if (i_egaki_dankai == 3) {
            i_egaki_dankai = 0;

            Senbun sen1 = new Senbun(s_step[1].geta(), s_step[2].geta());
            if (sen1.getnagasa() < 0.00000001) {
                return;
            }
            Senbun sen2 = new Senbun(s_step[2].geta(), s_step[3].geta());
            if (sen2.getnagasa() < 0.00000001) {
                return;
            }
            Senbun sen3 = new Senbun(s_step[3].geta(), s_step[1].geta());
            if (sen3.getnagasa() < 0.00000001) {
                return;
            }

            if (Math.abs(oc.kakudo(sen1, sen2) - 0.0) < 0.000001) {
                return;
            }
            if (Math.abs(oc.kakudo(sen1, sen2) - 180.0) < 0.000001) {
                return;
            }
            if (Math.abs(oc.kakudo(sen1, sen2) - 360.0) < 0.000001) {
                return;
            }

            if (Math.abs(oc.kakudo(sen2, sen3) - 0.0) < 0.000001) {
                return;
            }
            if (Math.abs(oc.kakudo(sen2, sen3) - 180.0) < 0.000001) {
                return;
            }
            if (Math.abs(oc.kakudo(sen2, sen3) - 360.0) < 0.000001) {
                return;
            }

            if (Math.abs(oc.kakudo(sen3, sen1) - 0.0) < 0.000001) {
                return;
            }
            if (Math.abs(oc.kakudo(sen3, sen1) - 180.0) < 0.000001) {
                return;
            }
            if (Math.abs(oc.kakudo(sen3, sen1) - 360.0) < 0.000001) {
                return;
            }


            Tyokusen t1 = new Tyokusen(sen1);
            t1.tyokkouka(oc.naibun(sen1.geta(), sen1.getb(), 1.0, 1.0));
            Tyokusen t2 = new Tyokusen(sen2);
            t2.tyokkouka(oc.naibun(sen2.geta(), sen2.getb(), 1.0, 1.0));
            add_en(oc.kouten_motome(t1, t2), oc.kyori(s_step[1].geta(), oc.kouten_motome(t1, t2)), 3);
            kiroku();
        }
    }

//43 43 43 43 43 43 43 43 43  ‚±‚±‚Ü‚Å  ------





















/*

//5555555555555555555555    i_mouse_modeA==5?@

//ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ
	public void mPressed_A_05(Ten p0) {
		//Ten p =new Ten();
		p.set(camera.TV2object(p0));
		moyori_senbun.set(get_moyori_senbun(p));
		if(oc.kyori_senbun( p,moyori_senbun)<d_hantei_haba){
			i_egaki_dankai=i_egaki_dankai+1;
			s_step[i_egaki_dankai].set(moyori_senbun);//s_step[i_egaki_dankai].setcolor(i_egaki_dankai);
s_step[i_egaki_dankai].setcolor(6);
		}



	}

//ƒ}ƒEƒX‘€?ì(ƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
	public void mDragged_A_05(Ten p0) {	}

//ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
	public void mReleased_A_05(Ten p0){			if(i_egaki_dankai==3){i_egaki_dankai=0;}}

//------

//66666666666666666666    i_mouse_modeA==6?@

//ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ
	public void mPressed_A_06(Ten p0) {


		//Ten p =new Ten();
		p.set(camera.TV2object(p0));
		moyori_ten.set(get_moyori_ten(p));
		if(p.kyori(moyori_ten)<d_hantei_haba){
			i_egaki_dankai=i_egaki_dankai+1;
			s_step[i_egaki_dankai].set(moyori_ten,moyori_ten);s_step[i_egaki_dankai].setcolor(i_egaki_dankai);
		}


	}

//ƒ}ƒEƒX‘€?ì(ƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
	public void mDragged_A_06(Ten p0) {	}

//ƒ}ƒEƒX‘€?ì(ƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
	public void mReleased_A_06(Ten p0){
		if(i_egaki_dankai==3){i_egaki_dankai=0;}



	}

//------



*/


//10001

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==10001?@‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ
    public void mPressed_A_10001(Ten p0) {


        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        moyori_ten.set(get_moyori_ten(p));
        if (p.kyori(moyori_ten) < d_hantei_haba) {
            i_egaki_dankai = i_egaki_dankai + 1;
            s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
            s_step[i_egaki_dankai].setcolor(i_egaki_dankai);
        }


    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==10001?@‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mDragged_A_10001(Ten p0) {
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==10001?@‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mReleased_A_10001(Ten p0) {
        if (i_egaki_dankai == 3) {
            i_egaki_dankai = 0;
        }


    }

//------
//10002

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==10002?@‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ
    public void mPressed_A_10002(Ten p0) {
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        moyori_senbun.set(get_moyori_senbun(p));
        if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {
            i_egaki_dankai = i_egaki_dankai + 1;
            s_step[i_egaki_dankai].set(moyori_senbun);//s_step[i_egaki_dankai].setcolor(i_egaki_dankai);
            s_step[i_egaki_dankai].setcolor(6);
        }


    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==10002?@‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mDragged_A_10002(Ten p0) {
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==10002?@‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mReleased_A_10002(Ten p0) {
        if (i_egaki_dankai == 3) {
            i_egaki_dankai = 0;
        }
    }

//------
//------
//10003

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==10003?@‚Åƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«)Žž‚Ì?ì‹Æ
    public void mPressed_A_10003(Ten p0) {
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==10003?@‚Åƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mDragged_A_10003(Ten p0) {
    }

    //ƒ}ƒEƒX‘€?ì(i_mouse_modeA==10003?@‚Åƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«)‚ð?s‚¤ŠÖ?”
    public void mReleased_A_10003(Ten p0) {
    }

//------


    public void set_i_kitei_jyoutai(int i) {
        kus.set_i_kitei_jyoutai(i);
    }

    public int get_i_kitei_jyoutai() {
        return kus.jyoutai();
    }


//public int  getsousuu() {return ori_s.getsousuu();}


    public void set_i_orisen_bunkatu_suu(int i) {
        i_orisen_bunkatu_suu = i;
        if (i_orisen_bunkatu_suu < 1) {
            i_orisen_bunkatu_suu = 1;
        }
    }


    public void set_d_naibun_st(double ds, double dt) {
        d_naibun_s = ds;
        d_naibun_t = dt;
    }

    public void set_d_jiyuu_kaku(double d_1, double d_2, double d_3) {
        d_jiyuu_kaku_1 = d_1;
        d_jiyuu_kaku_2 = d_2;
        d_jiyuu_kaku_3 = d_3;
    }

    public void set_i_sei_takakukei(int i) {
        i_sei_takakukei = i;
        if (i_sei_takakukei < 3) {
            i_orisen_bunkatu_suu = 3;
        }
    }

    // ------------
    int i_orisen_hojyosen_old = 0;

    public void set_i_orisen_hojyosen(int i) {
        i_orisen_hojyosen_old = i_orisen_hojyosen;
        i_orisen_hojyosen = i;
    }

    public void modosi_i_orisen_hojyosen() {
        i_orisen_hojyosen = i_orisen_hojyosen_old;
    }
// ------------


    public void check1(double r_hitosii, double heikou_hantei) {
        ori_s.check1(r_hitosii, heikou_hantei);
    }//ori_s‚É‚¨‚¢‚Ä?Aƒ`ƒFƒbƒN‚µ‚Ä‚¨‚©‚µ‚¢?Ü?ü‚ðƒZƒŒƒNƒg?ó‘Ô‚É‚·‚é?B

    public void fix1(double r_hitosii, double heikou_hantei) {
        while (ori_s.fix1(r_hitosii, heikou_hantei) == 1) {
        }
        //ori_s.addsenbun  delsenbun‚ðŽÀŽ{‚µ‚Ä‚¢‚é‚Æ‚±‚ë‚Åcheck‚ðŽÀŽ{
        if (i_check1 == 1) {
            check1(0.001, 0.5);
        }
        if (i_check2 == 1) {
            check2(0.01, 0.5);
        }
        if (i_check3 == 1) {
            check3(0.0001);
        }
        if (i_check4 == 1) {
            check4(0.0001);
        }

    }

    public void set_i_check1(int i) {
        i_check1 = i;
    }

    public void check2(double r_hitosii, double heikou_hantei) {
        ori_s.check2(r_hitosii, heikou_hantei);
    }

    public void fix2(double r_hitosii, double heikou_hantei) {
        while (ori_s.fix2(r_hitosii, heikou_hantei) == 1) {
        }
        //ori_s.addsenbun  delsenbun‚ðŽÀŽ{‚µ‚Ä‚¢‚é‚Æ‚±‚ë‚Åcheck‚ðŽÀŽ{
        if (i_check1 == 1) {
            check1(0.001, 0.5);
        }
        if (i_check2 == 1) {
            check2(0.01, 0.5);
        }
        if (i_check3 == 1) {
            check3(0.0001);
        }
        if (i_check4 == 1) {
            check4(0.0001);
        }

    }

    public void set_i_check2(int i) {
        i_check2 = i;
    }

    public void check3(double r) {
        ori_s.check3(r);
    }

    //public void  check4(double r){ori_s.check4(r);}
    public void check4(double r) {
        orihime_ap.check4(r);
    }

    public void ap_check4(double r) {
        ori_s.check4(r);
    }


    public void set_i_check3(int i) {
        i_check3 = i;
    }

    public void set_i_check4(int i) {
        i_check4 = i;
    }


// *******************************************************************************************************

    int i_ck4_color_toukado_sabun = 10;

    public void ck4_color_sage() {
        i_ck4_color_toukado = i_ck4_color_toukado - i_ck4_color_toukado_sabun;
        if (i_ck4_color_toukado < 50) {
            i_ck4_color_toukado = i_ck4_color_toukado + i_ck4_color_toukado_sabun;
        }
    }

    public void ck4_color_age() {
        i_ck4_color_toukado = i_ck4_color_toukado + i_ck4_color_toukado_sabun;
        if (i_ck4_color_toukado > 250) {
            i_ck4_color_toukado = i_ck4_color_toukado - i_ck4_color_toukado_sabun;
        }
    }


    //public void  fix3(double r_hitosii,double heikou_hantei){while(ori_s.fix3(r_hitosii,heikou_hantei)==1){;}}

    public void h_setcolor(int i) {
        h_icol = i;
    }

    public void set_Ubox_undo_suu(int i) {
        Ubox.set_i_undo_suu(i);
    }

    public void set_h_Ubox_undo_suu(int i) {
        h_Ubox.set_i_undo_suu(i);
    }

    public void en_seiri() {//‘S‚Ä‚Ì‰~‚ð‘Î?Û‚É?®—?‚ð‚·‚é?B
        ori_s.en_seiri();
    }


    // ---------------------------
    public void add_hanten(En e0, En eh) {


        //e0‚Ì‰~Žü‚ª(x,y)‚ð’Ê‚é‚Æ‚«
        if (Math.abs(oc.kyori(e0.get_tyuusin(), eh.get_tyuusin()) - e0.getr()) < 0.0000001) {
            Senbun s_add = new Senbun();
            s_add.set(eh.hanten_En2Senbun(e0));
            //s_add.setcolor(3);
            addsenbun(s_add);
            kiroku();
            return;
        }


        //e0‚Ì‰~Žü‚Ì“à•”‚É(x,y)‚ª‚­‚é‚Æ‚«
        //if(oc.kyori(e0.get_tyuusin(),eh.get_tyuusin())<e0.getr()){
        //	return;
        //}

//System.out.println("20170315  ********************3");
        //e0‚Ì‰~Žü‚ª(x,y)‚ð’Ê‚ç‚È‚¢‚Æ‚«?Be0‚Ì‰~Žü‚ÌŠO•”‚É(x,y)‚ª‚­‚é‚Æ‚«//e0‚Ì‰~Žü‚Ì“à•”‚É(x,y)‚ª‚­‚é‚Æ‚«
        En e_add = new En();
        e_add.set(eh.hanten(e0));
        add_en(e_add);
        kiroku();
    }

    // ---------------------------
    public void add_hanten(Senbun s0, En eh) {
        Tyokusen ty = new Tyokusen(s0);
        //s0?ã‚É(x,y)‚ª‚­‚é‚Æ‚«
        if (ty.kyorikeisan(eh.get_tyuusin()) < 0.0000001) {
            return;
        }

        //s0‚ª(x,y)‚ð’Ê‚ç‚È‚¢‚Æ‚«?B
        En e_add = new En();
        e_add.set(eh.hanten_Senbun2En(s0));
        add_en(e_add);
        kiroku();
    }


    //public double get_kus.d_haba()(){return kus.d_haba();	}

    public double get_d_hantei_haba() {
        return d_hantei_haba;
    }


    public void set_a_to_heikouna_memori_kannkaku(int i) {
        kus.set_a_to_heikouna_memori_kannkaku(i);
    }

    public void set_b_to_heikouna_memori_kannkaku(int i) {
        kus.set_b_to_heikouna_memori_kannkaku(i);
    }

    public void a_to_heikouna_memori_iti_idou() {
        kus.a_to_heikouna_memori_iti_idou();
    }

    public void b_to_heikouna_memori_iti_idou() {
        kus.b_to_heikouna_memori_iti_idou();
    }



/*
ˆê’l•ª‰ð‚·‚éŠÖ?”itti_bunkai();

public void itti_bunkai(){//?i‚P?j2“_a,b‚ðŽw’è







}

?i‚P?j2“_a,b‚ðŽw’è
?i‚Q?ja‚ðŠî“_‚Æ‚·‚éƒxƒNƒgƒ‹ab‚ª?Å?‰‚É‚Ô‚Â‚©‚é?Ü?ü‚Æ‚ÌŒð“_c‚ð‹?‚ß‚é?Bab‚Æ?d‚È‚é?Ü?ü‚Í–³Ž‹
?i‚R?j
c‚ªŠù‘¶‚Ì?Ü?ü‚Ì•¿‚Ì•”•ª‚¾‚Á‚½?ê?‡?A‚»‚Ì?ü‚Å‹¾‰f‚µ?Ac‚ða‚Æ‚µ?Ab‚ð‹¾‰f?ü‚Ì?æ‚Ì“_‚Æ‚µ‚Ä?Ä‹A“I‚É?B
c‚ª“_‚¾‚Á‚½?ê?‡?A‚·‚Å‚É’Ê‰ß‚µ‚Ä‚¢‚½“_‚È‚ç?Areturn;


c‚©‚çƒxƒNƒgƒ‹ac‚Æˆê’l?«‚ðŽ?‚ÂƒxƒNƒgƒ‹‚ð‹?‚ß‚é?A






*/

    //--------------------------------------------
    public void test1() {//ƒfƒoƒbƒN“™‚ÌƒeƒXƒg—p

        System.out.println("ori_s.getsousuu()  " + ori_s.getsousuu());

    }

    //--------------------------------------------

    //ƒ?ƒ‚
    //icol=0 black
    //icol=1 red
    //icol=2 blue
    //icol=3 cyan
    //icol=4 orange
    //icol=5 mazenta
    //icol=6 green
    //icol=7 yellow
    //icol=8 new Color(210,0,255) //Ž‡


}