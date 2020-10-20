package jp.gr.java_conf.mt777.origami.orihime.egaki_syokunin;

import jp.gr.java_conf.mt777.kiroku.memo.Memo;
import jp.gr.java_conf.mt777.origami.dougu.camera.Camera;
import jp.gr.java_conf.mt777.origami.dougu.orisensyuugou.Orisensyuugou;
import jp.gr.java_conf.mt777.origami.dougu.senbunsyuugou.Senbunsyuugou;
import jp.gr.java_conf.mt777.origami.orihime.ap;
import jp.gr.java_conf.mt777.origami.orihime.egaki_syokunin.egaki_syokunin_dougubako.Egaki_Syokunin_Dougubako;
import jp.gr.java_conf.mt777.origami.orihime.undo_box.Undo_Box;
import jp.gr.java_conf.mt777.seiretu.narabebako.Narabebako_int_double;
import jp.gr.java_conf.mt777.seiretu.narabebako.int_double;
import jp.gr.java_conf.mt777.zukei2d.en.En;
import jp.gr.java_conf.mt777.zukei2d.kousi.Kousi;
import jp.gr.java_conf.mt777.zukei2d.oritacalc.OritaCalc;
import jp.gr.java_conf.mt777.zukei2d.oritacalc.tyokusen.Tyokusen;
import jp.gr.java_conf.mt777.zukei2d.oritaoekaki.OritaOekaki;
import jp.gr.java_conf.mt777.zukei2d.senbun.Senbun;
import jp.gr.java_conf.mt777.zukei2d.takakukei.Takakukei;
import jp.gr.java_conf.mt777.zukei2d.ten.Ten;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.math.BigDecimal;
import java.util.ArrayList;


// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
public class Egaki_Syokunin {
    OritaCalc oc = new OritaCalc(); //各種計算用の関?狽gうためのクラスのインスタンス化
    //double r_ten=3.0;                   //基本枝?\造の直??の両端の円の半径?A枝と各種ポイントの近さの判定基??
    int ir_ten = 1;

    int icol;//??分の?F
    int h_icol = 4;//補????の?F

    //int taisyousei;

    int i_hanasi = 0;//マウス位置と入力点の?ﾀ標を離すなら１?A離さないなら０
    int i_kou_mitudo_nyuuryoku = 0;//格子表示が?ﾗかい???∠pの入力補?赴@能を使うなら１?A使わないなら０

    Ten pa = new Ten(); //マウスボタンが押された位置からa点までのベクトル
    Ten pb = new Ten(); //マウスボタンが押された位置からb点までのベクトル

    Color sen_tokutyuu_color;//円や補?賦???の特???Fを格納


    Undo_Box Ubox = new Undo_Box();
    Undo_Box h_Ubox = new Undo_Box();

    Ten moyori_ten = new Ten(100000.0, 100000.0); //マウス?ﾅ寄の点?Bget_moyori_ten(Ten p)で??める?B
    Senbun moyori_senbun = new Senbun(100000.0, 100000.0, 100000.0, 100000.1); //マウス?ﾅ寄の??分
    Senbun moyori_step_senbun = new Senbun(100000.0, 100000.0, 100000.0, 100000.1); //マウス?ﾅ寄のstep??分(??分追加のための??備をするための??分)?Bなお?Aここで?骭ｾする必要はないので?Aどこで?骭ｾすべきか要検討20161113
    En moyori_ensyuu = new En(100000.0, 100000.0, 10.0, 8); //マウス?ﾅ寄の円周を??つ円
    En moyori_step_ensyuu = new En(100000.0, 100000.0, 10.0, 8); //マウス?ﾅ寄の円周を??つstep円

    int i_orisen_hojyosen = 0;//=0は?ﾜ??入力?@=1は補????入力モ?[ド(??分入力時はこの２つ)?B??分???恷桙ﾍ?Xに値が以下の様になる?B=0は?ﾜ??の?????A=1は補?賦G???????A=2は?????????A=3は補?賦????????A=4は?ﾜ??と補?賦???と補?賦G??

    int ugokasi_mode = 0;    //枝を動かす動??モ?[ド?B0=なにもしない?A1=a点を動かす?A2=b点を動かす?A3=枝を平?s移動 ?A4=?V規追加
    int ieda;              //アクティブな枝の番??

    //  int i_saigo_no_senbun_no_maru_kaku=1;	//1描く?A0描かない

    public Orisensyuugou ori_s = new Orisensyuugou();    //?ﾜ??を格納する
    Orisensyuugou hoj_s = new Orisensyuugou();    //補????を格納する


    public Orisensyuugou ori_v = new Orisensyuugou();    //ボ??ノイ?}の??を格納する

    Egaki_Syokunin_Dougubako e_s_dougubako = new Egaki_Syokunin_Dougubako(ori_s);

    private final Senbunsyuugou sen_s = new Senbunsyuugou();    //基本枝?\造のインスタンス化
    //private Senbunsyuugou sen_s;    //基本枝?\造のインスタンス化

    Takakukei gomibako = new Takakukei(4);    //ゴミ箱のインスタンス化
    Takakukei tyuuoutai = new Takakukei(4);    //中央帯のインスタンス化
    double tyuuoutai_xmin = 180.0;
    double tyuuoutai_xmax = 206.0;
    double tyuuoutai_ymin = 50.0;
    double tyuuoutai_ymax = 300.0;

    double kijyun_kakudo = 22.5; //<<<<<<<<<<<<<<<<<<<<<<<基??角度<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    //int i_kakudo_kei=36;
    int id_kakudo_kei = 8;//  180/id_kakudo_keiが角度系を表す?Bたとえば?Aid_kakudo_kei=3なら180/3??60度系?Aid_kakudo_kei=5なら180/5??36度系
    //360/i_kakudo_kei-1 = id_kakudo_kei*2-1

    double d_kakudo_kei;//d_kakudo_kei=180.0/(double)id_kakudo_kei
    double kakudo;

    //入力方法用のパラ???[タ
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

    double d_hantei_haba = 50.0;//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<入力点が既存の点や??分と近いかどうかを判定する時の値


    public int i_egaki_dankai;//?ﾜ??を描く手?№ﾌどの段階にいるかの?﨣i納
    int i_en_egaki_dankai;//円を描く手?№ﾌどの段階にいるかの?﨣i納
    Senbun[] s_step = new Senbun[1024];//描画時の一時表示用に使う?Bs_step[0] は実?ﾛは使わず?As_step[1]から使う?B
    En[] e_step = new En[1024];//描画時の一時表示用に使う?Be_step[0] は実?ﾛは使わず?Ae_step[1]から使う?B


    public int i_kouho_dankai;//?ﾜ??を描く手?№ﾌどの候補かの?﨣i納
    int i_en_kouho_dankai;//円を描く手?№ﾌどの候補かの?﨣i納
    Senbun[] s_kouho = new Senbun[16];//描画時の選択候補表示用に使う?Bs_kouho[0] は実?ﾛは使わず?As_kouho[1]から使う?B
    En[] e_kouho = new En[16];//描画時の選択候補表示用に使う?Be_kouho[0] は実?ﾛは使わず?Ae_kouho[1]から使う?B


    double sokutei_nagasa_1 = 0.0;
    double sokutei_nagasa_2 = 0.0;
    double sokutei_nagasa_3 = 0.0;
    double sokutei_kakudo_1 = 0.0;
    double sokutei_kakudo_2 = 0.0;
    double sokutei_kakudo_3 = 0.0;


    String text_cp_setumei = "";
    String text_cp_setumei2 = "";

    String s_title = ""; //フレ?[ムの?ﾅ?纈[に?oてくるタイトルを保??するために使用

    Camera camera = new Camera();

    int i_check1 = 0;//=0 check1を実施しない?A1=実施する?@?@
    int i_check2 = 0;//=0 check2を実施しない?A1=実施する?@
    int i_check3 = 0;//=0 check3を実施しない?A1=実施する?@
    int i_check4 = 0;//=0 check4を実施しない?A1=実施する?@
    //---------------------------------
    int i_ck4_color_toukado = 100;

    ap orihime_ap;


    int icol_temp = 0;//?F指定の一時的な記憶に使う

    int i_orikaesi = 0;//?ﾜり返し( 5)の動??モ?[ド指定に使う?B0は?]来タイプ?iver3.041以前のもの?j?A１は強化タイプ?B

    //i_mouse_modeA==61//長方形内選択?ipaintの選択に似せた選択機能?jの時に使う
    Ten p61_1 = new Ten();//TV?ﾀ標
    Ten p61_2 = new Ten();//TV?ﾀ標
    Ten p61_3 = new Ten();//TV?ﾀ標
    Ten p61_4 = new Ten();//TV?ﾀ標
    public Takakukei p61_TV_hako = new Takakukei(4);    //選択箱(TV?ﾀ標)のインスタンス化
    int p61_mode = 0;//=1 ?Vたに選択箱を??る?B=2?@点を移動?B３?@辺を移動?B４?@選択箱を移動?B


    Ten p = new Ten();


// ****************************************************************************************************************************************
// **************?@ここまで変?狽ﾌ定義?@****************************************************************************************************
// ****************************************************************************************************************************************

    public Egaki_Syokunin(double r0, ap ap0) {  //コンストラクタ

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
        //用紙の?ｳ方形を入力?i開始?j
        ori_s.addsenbun(-200.0, -200.0, -200.0, 200.0, 0);
        ori_s.addsenbun(-200.0, -200.0, 200.0, -200.0, 0);
        ori_s.addsenbun(200.0, 200.0, -200.0, 200.0, 0);
        ori_s.addsenbun(200.0, 200.0, 200.0, -200.0, 0);
        //用紙の?ｳ方形を入力?i?I了?j


    }


    // -------------------------------------------
    public void set_i_orikaesi(int i) {//?ﾜり返し( 5)の動??モ?[ド指定に使う?B0は?]来タイプ?iver3.041以前のもの?j?A１は強化タイプ?B
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

        // 展開?}用カ??ラ?ﾝ定の読み?桙ﾝ
        i_yomi = 0;
        for (int i = 1; i <= memo1.getGyousuu(); i++) {
            String str = memo1.getGyou(i);
            str.trim();

            if (str.equals("<camera_of_orisen_nyuuryokuzu>")) {
                i_yomi = 1;
            } else if (str.equals("</camera_of_orisen_nyuuryokuzu>")) {
                i_yomi = 0;
            } else {
                if (i_yomi == 1) {
                    st = str.split(">", 2);// <-----------------------------------２つに分割するときは2を指定
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


        // ----------------------------------------- チェックボックス等の?ﾝ定の読み?桙ﾝ
        i_yomi = 0;
        for (int i = 1; i <= memo1.getGyousuu(); i++) {
            String str = memo1.getGyou(i);
            str.trim();

            if (str.equals("<settei>")) {
                i_yomi = 1;
            } else if (str.equals("</settei>")) {
                i_yomi = 0;
            } else {
                if (i_yomi == 1) {
                    st = str.split(">", 2);// <-----------------------------------２つに分割するときは2を指定


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


        // ----------------------------------------- 格子?ﾝ定の読み?桙ﾝ


        i_yomi = 0;
        for (int i = 1; i <= memo1.getGyousuu(); i++) {
            String str = memo1.getGyou(i);
            str.trim();

            if (str.equals("<Kousi>")) {
                i_yomi = 1;
            } else if (str.equals("</Kousi>")) {
                i_yomi = 0;
            } else {
                if (i_yomi == 1) {
                    st = str.split(">", 2);// <-----------------------------------２つに分割するときは2を指定

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


        // ----------------------------------------- 格子?F?ﾝ定の読み?桙ﾝ
        int i_kousi_color_R = 0;
        int i_kousi_color_G = 0;
        int i_kousi_color_B = 0;
        int i_kousi_memori_color_R = 0;
        int i_kousi_memori_color_G = 0;
        int i_kousi_memori_color_B = 0;

        int i_Kousi_iro_yomikomi = 0;//Kousi_iroの読み?桙ﾝがあったら1?Aなければ0
        i_yomi = 0;
        for (int i = 1; i <= memo1.getGyousuu(); i++) {
            String str = memo1.getGyou(i);
            str.trim();

            if (str.equals("<Kousi_iro>")) {
                i_yomi = 1;
                i_Kousi_iro_yomikomi = 1;
            } else if (str.equals("</Kousi_iro>")) {
                i_yomi = 0;
            } else {
                if (i_yomi == 1) {
                    st = str.split(">", 2);// <-----------------------------------２つに分割するときは2を指定


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

        if (i_Kousi_iro_yomikomi == 1) {//Kousi_iroの読み?桙ﾝがあったら1?Aなければ0
            kus.set_kousi_color(new Color(i_kousi_color_R, i_kousi_color_G, i_kousi_color_B)); //kousiの?F

            System.out.println("i_kousi_memori_color_R= " + i_kousi_memori_color_R);
            System.out.println("i_kousi_memori_color_G= " + i_kousi_memori_color_G);
            System.out.println("i_kousi_memori_color_B= " + i_kousi_memori_color_B);
            orihime_ap.kus.set_kousi_memori_color(new Color(i_kousi_memori_color_R, i_kousi_memori_color_G, i_kousi_memori_color_B)); //kousi_memoriの?F

        }


        // ?ﾜり?繧ｪり?}?ﾝ定の読み?桙ﾝ -------------------------------------------------------------------------

        int i_oriagarizu_F_color_R = 0;
        int i_oriagarizu_F_color_G = 0;
        int i_oriagarizu_F_color_B = 0;

        int i_oriagarizu_B_color_R = 0;
        int i_oriagarizu_B_color_G = 0;
        int i_oriagarizu_B_color_B = 0;

        int i_oriagarizu_L_color_R = 0;
        int i_oriagarizu_L_color_G = 0;
        int i_oriagarizu_L_color_B = 0;


        int i_oriagarizu_yomikomi = 0;//oriagarizuの読み?桙ﾝがあったら1?Aなければ0
        i_yomi = 0;
        for (int i = 1; i <= memo1.getGyousuu(); i++) {
            String str = memo1.getGyou(i);
            str.trim();

            if (str.equals("<oriagarizu>")) {
                i_yomi = 1;
                i_oriagarizu_yomikomi = 1;
            } else if (str.equals("</oriagarizu>")) {
                i_yomi = 0;
            } else {
                if (i_yomi == 1) {
                    st = str.split(">", 2);// <-----------------------------------２つに分割するときは2を指定

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
            orihime_ap.OZ.js.set_F_color(new Color(i_oriagarizu_F_color_R, i_oriagarizu_F_color_G, i_oriagarizu_F_color_B)); //表面の?F
            orihime_ap.Button_F_color.setBackground(new Color(i_oriagarizu_F_color_R, i_oriagarizu_F_color_G, i_oriagarizu_F_color_B));    //ボタンの?F?ﾝ定

            orihime_ap.OZ.js.set_B_color(new Color(i_oriagarizu_B_color_R, i_oriagarizu_B_color_G, i_oriagarizu_B_color_B));//裏面の?F
            orihime_ap.Button_B_color.setBackground(new Color(i_oriagarizu_B_color_R, i_oriagarizu_B_color_G, i_oriagarizu_B_color_B));//ボタンの?F?ﾝ定

            orihime_ap.OZ.js.set_L_color(new Color(i_oriagarizu_L_color_R, i_oriagarizu_L_color_G, i_oriagarizu_L_color_B));        //??の?F
            orihime_ap.Button_L_color.setBackground(new Color(i_oriagarizu_L_color_R, i_oriagarizu_L_color_G, i_oriagarizu_L_color_B));        //ボタンの?F?ﾝ定
        }
    }

    //-----------------------------
    public String setMemo_for_redo_undo(Memo memo1) {//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<undo,redoでのkiroku復元用

        //Memo_jyouhou_toridasi(memo1);
        return ori_s.setMemo(memo1);
    }


    //-----------------------------
    public void setMemo_for_yomikomi(Memo memo1) {//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<デ?[タ読み?桙ﾝ用
        Memo_jyouhou_toridasi(memo1);
        ori_s.setMemo(memo1);
        hoj_s.h_setMemo(memo1);
    }

    //-----------------------------
    public void setMemo_for_yomikomi_tuika(Memo memo1) {//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<デ?[タ読み?桙ﾝ用
        //Memo_jyouhou_toridasi(memo1);
        //ori_s.setMemo(memo1); hoj_s.h_setMemo(memo1);

        double addx, addy;


        Orisensyuugou ori_s_temp = new Orisensyuugou();    //追加された?ﾜ??だけ取り?oすために使う
        ori_s_temp.setMemo(memo1);//追加された?ﾜ??だけ取り?oしてori_s_tempを??る
        //ori_s.del_selected_senbun_hayai();//セレクトされた?ﾜ??を???怩ｷる?B
        addx = ori_s.get_x_max() + 100.0 - ori_s_temp.get_x_min();
        addy = ori_s.get_y_max() - ori_s_temp.get_y_max();


        ori_s_temp.move(addx, addy);//全体を移動する

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


    //?ﾜ?ﾝ??定用にselectされた??分?W?№ﾌ?ﾜ???狽? intとして?o力する?B//icolが3(cyan?????F)以?繧ﾌ補????はカウントしない
    public int get_orisensuu_for_select_oritatami() {
        return ori_s.get_orisensuu_for_select_oritatami();
    }

    public Senbunsyuugou get_for_select_oritatami() {//selectした?ﾜ??で?ﾜり?ﾝ??定をする?B
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
    } //<<<<<<<<<<<<<<<<<<<<<<<基??角度<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


    //------------------------
    public Memo getMemo() {
        return ori_s.getMemo();
    }


    //getMemo(String s_title)はundo,redoのkiroku用
    public Memo getMemo(String s_title) {//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<undo,redoのkiroku用
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
    public Memo getMemo_for_kakidasi() {//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<デ?[タ?曹ｫ?oし

        Memo memo_temp = new Memo();
        memo_temp.set(ori_s.getMemo());
        memo_temp.addMemo(hoj_s.h_getMemo());
        Memo_jyouhou_tuika(memo_temp);
        return memo_temp;
    }

    //------------------------svgデ?[タ?曹ｫ?oし
    public Memo getMemo_for_svg_kakidasi_with_camera(int i_bun_hyouji, int i_cp_hyouji, int i_a0_hyouji, int i_a1_hyouji, float fTenkaizuSenhaba, int i_orisen_hyougen, float f_h_TenkaizuSenhaba, int p0x_max, int p0y_max, int i_mejirusi_hyouji) {//引?狽ﾍカ??ラ?ﾝ定?A?????A画面X???A画面y?ｂｳ
        Memo memo_temp = new Memo();

        //String text=new String();//文字列????用のクラスのインスタンス化
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


        //展開?}の描画  補?賦???以外の?ﾜ??
        if (i_cp_hyouji == 1) {

            //float dash_M1[] = {10.0f, 3.0f, 3.0f, 3.0f};//一点?ｽ??
            //float dash_M2[] = {10.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f};//二点?ｽ??
            //float dash_V[]  = {8.0f, 8.0f};//破??

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
                        //g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//基本指定A?@?@??の太さや??の末端の形??
                    }

                    if (i_orisen_hyougen == 2) {
                        //g_setColor(g,ori_s.getcolor(i));
                        if (ori_s.getcolor(i) == 0) {
                        }//基本指定A?@?@??の太さや??の末端の形??
                        if (ori_s.getcolor(i) == 1) {
                            str_stroke_dasharray = "stroke-dasharray=\"10 3 3 3\"";
                        }//dash_M1,一点?ｽ??
                        if (ori_s.getcolor(i) == 2) {
                            str_stroke_dasharray = "stroke-dasharray=\"8 8\"";
                        }//dash_V ,破??
                    }


                    if (i_orisen_hyougen == 3) {
                        str_stroke = "black";
                        if (ori_s.getcolor(i) == 0) {
                        }//基本指定A?@?@??の太さや??の末端の形??
                        if (ori_s.getcolor(i) == 1) {
                            str_stroke_dasharray = "stroke-dasharray=\"10 3 3 3\"";
                        }//dash_M1,一点?ｽ??
                        if (ori_s.getcolor(i) == 2) {
                            str_stroke_dasharray = "stroke-dasharray=\"8 8\"";
                        }//dash_V ,破??
                    }

                    if (i_orisen_hyougen == 4) {
                        str_stroke = "black";
                        if (ori_s.getcolor(i) == 0) {
                        }//基本指定A?@?@??の太さや??の末端の形??
                        if (ori_s.getcolor(i) == 1) {
                            str_stroke_dasharray = "stroke-dasharray=\"10 3 3 3 3 3\"";
                        }//dash_M2,二点?ｽ??
                        if (ori_s.getcolor(i) == 2) {
                            str_stroke_dasharray = "stroke-dasharray=\"8 8\"";
                        }//dash_V ,破??
                    }


/*
					if(i_orisen_hyougen==1){
						g_setColor(g,ori_s.getcolor(i));
						g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//基本指定A?@?@??の太さや??の末端の形??
					}

					if(i_orisen_hyougen==2){
						g_setColor(g,ori_s.getcolor(i));
						if(ori_s.getcolor(i)==0){g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER				));}//基本指定A?@?@??の太さや??の末端の形??
						if(ori_s.getcolor(i)==1){g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,10.0f, dash_M1, 0.0f	));}//一点?ｽ??//??の太さや??の末端の形??
						if(ori_s.getcolor(i)==2){g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,10.0f, dash_V , 0.0f	));}//破??//??の太さや??の末端の形??
					}

					if(i_orisen_hyougen==3){
						if(ori_s.getcolor(i)==0){g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER				));}//基本指定A?@?@??の太さや??の末端の形??
						if(ori_s.getcolor(i)==1){g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,10.0f, dash_M1, 0.0f	));}//一点?ｽ??//??の太さや??の末端の形??
						if(ori_s.getcolor(i)==2){g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,10.0f, dash_V , 0.0f	));}//破??//??の太さや??の末端の形??
					}

					if(i_orisen_hyougen==4){
						if(ori_s.getcolor(i)==0){g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));}//基本指定A?@?@??の太さや??の末端の形??
						if(ori_s.getcolor(i)==1){g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,10.0f, dash_M2, 0.0f));}//二点?ｽ??//??の太さや??の末端の形??
						if(ori_s.getcolor(i)==2){g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,10.0f, dash_V , 0.0f));}//破??//??の太さや??の末端の形??
					}

*/


                    s_tv.set(camera.object2TV(ori_s.get(i)));
                    a.set(s_tv.geta());
                    b.set(s_tv.getb());//a.set(s_tv.getax()+0.000001,s_tv.getay()+0.000001); b.set(s_tv.getbx()+0.000001,s_tv.getby()+0.000001);//なぜ0.000001を足すかというと,ディスプレイに描画するとき元の?ﾜ??が?Vしい?ﾜ??に影響されて動いてしまうのを防ぐため


//					g.drawLine( (int)a.getx(),(int)a.gety(),(int)b.getx(),(int)b.gety()); //直??

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
                        if (fTenkaizuSenhaba < 2.0f) {//頂点の?浮｢?ｳ方形を描く
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

                            //g.fillRect( (int)a.getx()-i_haba,(int)a.gety()-i_haba,2*i_haba+1,2*i_haba+1); //?ｳ方形を描く//g.fillRect(10, 10, 100, 50);長方形を描く
                            //g.fillRect( (int)b.getx()-i_haba,(int)b.gety()-i_haba,2*i_haba+1,2*i_haba+1); //?ｳ方形を描く
                        }
                    }

                    if (fTenkaizuSenhaba >= 2.0f) {//  太??
                        //g2.setStroke(new BasicStroke(1.0f+fTenkaizuSenhaba%1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//??の太さや??の末端の形???Aここでは?ﾜ??の端点の??の形?ﾌ指定
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
							//g.fillOval( (int)a.getx()-i_haba/2,(int)a.gety()-i_haba/2,i_haba,i_haba); //円


							g.setColor(Color.black);
							g2.draw(new Ellipse2D.Double(a.getx()-d_haba, a.gety()-d_haba, 2.0*d_haba,2.0*d_haba));
							//g.drawOval( (int)a.getx()-i_haba/2,(int)a.gety()-i_haba/2,i_haba,i_haba); //円

							g.setColor(Color.white);
							g2.fill(new Ellipse2D.Double(b.getx()-d_haba, b.gety()-d_haba, 2.0*d_haba,2.0*d_haba));
							//g.fillOval( (int)b.getx()-i_haba/2,(int)b.gety()-i_haba/2,i_haba,i_haba); //円

							g.setColor(Color.black);
							g2.draw(new Ellipse2D.Double(b.getx()-d_haba, b.gety()-d_haba, 2.0*d_haba,2.0*d_haba));
						*/    //g.drawOval( (int)b.getx()-i_haba/2,(int)b.gety()-i_haba/2,i_haba,i_haba); //円
                        }
                    }


                }
            }
        }


        return memo_temp;
    }


    //---------------------------------------------------------------------------------------------------------------------------------
    public void Memo_jyouhou_tuika(Memo memo1) {
        //String str=new String();//文字列????用のクラスのインスタンス化
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


        //展開?}の??の太さ?B
        memo1.addGyou("<iTenkaizuSenhaba>" +
                orihime_ap.iTenkaizuSenhaba +
                "</iTenkaizuSenhaba>");

        //頂点のしるしの??
        memo1.addGyou("<ir_ten>" +
                orihime_ap.ir_ten +
                "</ir_ten>");

        //?ﾜ??表現を?Fで表す
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
    //対?ﾌ?ｫの指定
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

    //不要な??分を?ﾁ去する-----------------------------------------------
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
  //枝を動かした後の????を?sう関??----------------------------------------------------
	public void eda_atosyori_01() {//枝の長さを変えずに?A枝全体を平?s移動して微調?ｮする?B
    //アクティブな帯の位置を微調?ｮする
    Ten ab = new Ten(1,ori_s.getb(ieda),-1,ori_s.geta(ieda));//アクティブな枝の?A点aから点bへ向かうベクトル
    Ten ba = new Ten(1,ori_s.geta(ieda),-1,ori_s.getb(ieda));//アクティブな枝の?A点aから点bへ向かうベクトル

    int jeda;   //アクティブな枝と近い別の枝
    int jbasyo; //アクティブな枝と近い別の枝のどこが近いのかを示すための番??

    //?@アクティブな枝のa点?@と?@別の枝?@との距離が?@ｒ?@より近い????

    jeda=ori_s.senbun_sagasi(ori_s.geta(ieda),2*r_ten,ieda);//アクティブな枝のa点と近い別の枝を??める?B
    jbasyo= ori_s.senbun_busyo_sagasi(jeda,ori_s.geta(ieda),2*r_ten);//別の枝のどの部?鰍ｪ近いかを??める?B
    if( (jeda!=0) && (jbasyo==1)){ //アクティブな枝のa点と?A別の枝のa点が近い????
      ori_s.seta(ieda,ori_s.geta(jeda));
      ori_s.setb(ieda,new Ten(1,ori_s.geta(ieda),1,ab));//こう?曹｢てもちゃんと動く様なので?Aこのまま使う?B
    }
    if( (jeda!=0) && (jbasyo==2)){ //アクティブな枝のa点と?A別の枝のb点が近い????
      ori_s.seta(ieda,ori_s.getb(jeda));
      ori_s.setb(ieda,new Ten(1,ori_s.geta(ieda),1,ab));
    }

    //?@アクティブな枝のb点?@と?@別の枝?@との距離が?@ｒ?@より近い????
    jeda=ori_s.senbun_sagasi(ori_s.getb(ieda),2*r_ten,ieda);//アクティブな枝のb点と近い別の枝を??める?B
    jbasyo= ori_s.senbun_busyo_sagasi(jeda,ori_s.getb(ieda),2*r_ten);//別の枝のどの部?鰍ｪ近いかを??める?B
    if( (jeda!=0) && (jbasyo==1)){ //アクティブな枝のb点と?A別の枝のa点が近い????
      ori_s.setb(ieda,ori_s.geta(jeda));
      ori_s.seta(ieda,new Ten(1,ori_s.getb(ieda),1,ba));
    }
    if( (jeda!=0) && (jbasyo==2)){ //アクティブな枝のb点と?A別の枝のb点が近い????
        ori_s.setb(ieda,ori_s.getb(jeda));
	ori_s.seta(ieda,new Ten(1,ori_s.getb(ieda),1,ba));
    }
  }
*/
/*
  //枝を動かした後の????を?sう関??----------------------------------------------------
	public void eda_atosyori_02() {//一端の点だけを移動して反対の端の点は動かさないで微調?ｮする?B
    //アクティブな帯の位置を微調?ｮする

    int jeda;   //アクティブな枝と近い別の枝
    int jbasyo; //アクティブな枝と近い別の枝のどこが近いのかを示すための番??
	if(ori_s.getnagasa(ieda)>=r_ten){
    //?@アクティブな枝のa点?@と?@別の枝との距離が?@ｒ?@より近い????
    jeda=ori_s.senbun_sagasi(ori_s.geta(ieda),r_ten,ieda);//アクティブな枝のa点と近い別の枝を??める?B
    jbasyo= ori_s.senbun_busyo_sagasi(jeda,ori_s.geta(ieda),r_ten);//別の枝のどの部?鰍ｪ近いかを??める?B
    if( (jeda!=0) && (jbasyo==1)){ori_s.seta(ieda,ori_s.geta(jeda));}//アクティブな枝のa点と?A別の枝のa点が近い????
    if( (jeda!=0) && (jbasyo==2)){ori_s.seta(ieda,ori_s.getb(jeda));}//アクティブな枝のa点と?A別の枝のb点が近い????

    //?@アクティブな枝(ieda)のb点?@と?@別の枝(jeda)との距離が?@ｒ?@より近い????
    jeda=ori_s.senbun_sagasi(ori_s.getb(ieda),r_ten,ieda);//アクティブな枝のb点と近い別の枝を??める?B
    jbasyo= ori_s.senbun_busyo_sagasi(jeda,ori_s.getb(ieda),r_ten);//別の枝のどの部?鰍ｪ近いかを??める?B
    if((jeda!=0) && (jbasyo==1)){ori_s.setb(ieda,ori_s.geta(jeda));}//アクティブな枝のb点と?A別の枝のa点が近い????
    if((jeda!=0) && (jbasyo==2)){ori_s.setb(ieda,ori_s.getb(jeda));}//アクティブな枝のb点と?A別の枝のb点が近い????

 //以下は070317に追加 複?狽ﾌ??分が?Wまった頂点を別の頂点近くに??っていったときの後????用
//150312?@?@2*r?@を?@r?@に?C?ｳ


    //?@アクティブな枝のa点?@と?@別の枝との距離が?@ｒ?@より近い????
    jeda=ori_s.senbun_sagasi(ori_s.geta(ieda),r_ten,-10);//アクティブなieda枝のa点と近い別の枝を??める?B
    jbasyo= ori_s.senbun_busyo_sagasi(jeda,ori_s.geta(ieda),r_ten);//別の枝のどの部?鰍ｪ近いかを??める?B

    if((jeda!=0) && (jbasyo==1)){ori_s.kasseika(ori_s.geta(jeda),r_ten); ori_s.set(ori_s.geta(jeda));}//アクティブなieda枝のa点と?A別の枝のa点が近い????
    if((jeda!=0) && (jbasyo==2)){ori_s.kasseika(ori_s.getb(jeda),r_ten); ori_s.set(ori_s.getb(jeda));}//アクティブなieda枝のa点と?A別の枝のb点が近い????

    //?@アクティブな枝(ieda)のb点?@と?@別の枝(jeda)との距離が?@ｒ?@より近い????
    jeda=ori_s.senbun_sagasi(ori_s.getb(ieda),r_ten,-10);//アクティブなieda枝のb点と近い別の枝を??める?B
    jbasyo= ori_s.senbun_busyo_sagasi(jeda,ori_s.getb(ieda),r_ten);//別の枝のどの部?鰍ｪ近いかを??める?B

    if((jeda!=0) && (jbasyo==1)){ori_s.kasseika(ori_s.geta(jeda),r_ten); ori_s.set(ori_s.geta(jeda));}//アクティブなieda枝のb点と?A別の枝のa点が近い????
    if((jeda!=0) && (jbasyo==2)){ori_s.kasseika(ori_s.getb(jeda),r_ten); ori_s.set(ori_s.getb(jeda));}//アクティブなieda枝のb点と?A別の枝のb点が近い????
 	}

 }
*/
    public void bunkatu_seiri() {
        ori_s.bunkatu_seiri();
    }

    //public void  bunkatu_seiri_for_Smen_hassei(){ori_s.bunkatu_seiri_for_Smen_hassei();}//ori_sとは??分?W?№ﾌこと?ASenbunsyuugou ori_s =new Senbunsyuugou();

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
        //ori_s.addsenbun  delsenbunを実施しているところでcheckを実施
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

        //ori_s.addsenbun  delsenbunを実施しているところでcheckを実施
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
        //ori_s.addsenbun  delsenbunを実施しているところでcheckを実施
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


    public void kousi_oekaki_with_camera(Graphics g, int i_bun_hyouji, int i_cp_hyouji, int i_a0_hyouji, int i_a1_hyouji, float fTenkaizuSenhaba, int i_orisen_hyougen, float f_h_TenkaizuSenhaba, int p0x_max, int p0y_max) {//引?狽ﾍカ??ラ?ﾝ定?A?????A画面X???A画面y?ｂｳ
        //System.out.println(" E 20170201_1");
        Graphics2D g2 = (Graphics2D) g;

        String text = "";//文字列????用のクラスのインスタンス化
        double d;
        OritaOekaki OO = new OritaOekaki();

        Senbun s_tv = new Senbun();
        Ten a = new Ten();
        Ten b = new Ten();

        Senbun s_ob = new Senbun();


        // ------------------------------------------------------

        //格子??の描画
        if (i_kou_mitudo_nyuuryoku == 0) {
            kus.oekaki(g, camera, p0x_max, p0y_max, 0);
        }
        if (i_kou_mitudo_nyuuryoku == 1) {
            kus.oekaki(g, camera, p0x_max, p0y_max, 1);
        }
    }


    //------------------------------------------------------------------------------
//基本枝の描画111111111111111111111111111111111111111111111111111111111111111111		//System.out.println("_");
//------------------------------------------------------------------------------
    public void oekaki_with_camera(Graphics g, int i_bun_hyouji, int i_cp_hyouji, int i_a0_hyouji, int i_a1_hyouji, float fTenkaizuSenhaba, int i_orisen_hyougen, float f_h_TenkaizuSenhaba, int p0x_max, int p0y_max, int i_mejirusi_hyouji) {//引?狽ﾍカ??ラ?ﾝ定?A?????A画面X???A画面y?ｂｳ
        //System.out.println(" E 20170201_1");
        Graphics2D g2 = (Graphics2D) g;

        String text = "";//文字列????用のクラスのインスタンス化
        double d;
        OritaOekaki OO = new OritaOekaki();

        Senbun s_tv = new Senbun();
        Ten a = new Ten();
        Ten b = new Ten();

        Senbun s_ob = new Senbun();


        // ------------------------------------------------------

        //格子??の描画
        if (i_kou_mitudo_nyuuryoku == 0) {
            kus.oekaki(g, camera, p0x_max, p0y_max, 0);
        }
        if (i_kou_mitudo_nyuuryoku == 1) {
            kus.oekaki(g, camera, p0x_max, p0y_max, 1);
        }


        BasicStroke BStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
        g2.setStroke(BStroke);//??の太さや??の末端の形??

        //補?負????i?ﾜ??と非干?ﾂ?jの描画
        if (i_a1_hyouji == 1) {
            g2.setStroke(new BasicStroke(f_h_TenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//??の太さや??の末端の形??
            for (int i = 1; i <= hoj_s.getsousuu(); i++) {

                //if(hoj_s.getcolor(i)==4){g.setColor(Color.orange);System.out.println("hoj_s.getcolor(i)==4");}
                //if(hoj_s.getcolor(i)==7){g.setColor(Color.yellow);System.out.println("hoj_s.getcolor(i)==7");}
                g_setColor(g, hoj_s.getcolor(i));

                s_tv.set(camera.object2TV(hoj_s.get(i)));
                //a.set(s_tv.geta()); b.set(s_tv.getb());
                a.set(s_tv.getax() + 0.000001, s_tv.getay() + 0.000001);
                b.set(s_tv.getbx() + 0.000001, s_tv.getby() + 0.000001);//なぜ0.000001を足すかというと,ディスプレイに描画するとき元の?ﾜ??が?Vしい?ﾜ??に影響されて動いてしまうのを防ぐため

                g.drawLine((int) a.getx(), (int) a.gety(), (int) b.getx(), (int) b.gety()); //直??

                if (fTenkaizuSenhaba < 2.0f) {//頂点の?ｳ方形を描く
                    g.setColor(Color.black);
                    //int i_haba=1;
                    int i_haba = ir_ten;
                    g.fillRect((int) a.getx() - i_haba, (int) a.gety() - i_haba, 2 * i_haba + 1, 2 * i_haba + 1); //?ｳ方形を描く//g.fillRect(10, 10, 100, 50);長方形を描く
                    g.fillRect((int) b.getx() - i_haba, (int) b.gety() - i_haba, 2 * i_haba + 1, 2 * i_haba + 1); //?ｳ方形を描く
                }

                if (fTenkaizuSenhaba >= 2.0f) {//  太??
                    //	OO.habaLine( g,s_tv,iTenkaizuSenhaba,hoj_s.getcolor(i));
                    g2.setStroke(new BasicStroke(1.0f + f_h_TenkaizuSenhaba % 1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//??の太さや??の末端の形??
                    //OO.habaLine( g,s_tv,iTenkaizuSenhaba,k.getcolor(i));

                    //int i_haba=iTenkaizuSenhaba;
                    //g.fillOval( (int)a.getx()-i_haba,(int)a.gety()-i_haba,2*i_haba,2*i_haba); //円
                    //g.fillOval( (int)b.getx()-i_haba,(int)b.gety()-i_haba,2*i_haba,2*i_haba); //円

                    if (ir_ten != 0) {

                        int i_haba = (int) fTenkaizuSenhaba + ir_ten;//int i_haba=2;
                        double d_haba = (double) fTenkaizuSenhaba / 2.0 + (double) ir_ten;//int i_haba=2;

                        g.setColor(Color.white);
                        g2.fill(new Ellipse2D.Double(a.getx() - d_haba, a.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                        //g.fillOval( (int)a.getx()-i_haba/2,(int)a.gety()-i_haba/2,i_haba,i_haba); //円

                        g.setColor(Color.black);
                        g2.draw(new Ellipse2D.Double(a.getx() - d_haba, a.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                        //g.drawOval( (int)a.getx()-i_haba/2,(int)a.gety()-i_haba/2,i_haba,i_haba); //円

                        g.setColor(Color.white);
                        g2.fill(new Ellipse2D.Double(b.getx() - d_haba, b.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                        //g.fillOval( (int)b.getx()-i_haba/2,(int)b.gety()-i_haba/2,i_haba,i_haba); //円

                        g.setColor(Color.black);
                        g2.draw(new Ellipse2D.Double(b.getx() - d_haba, b.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                        //g.drawOval( (int)b.getx()-i_haba/2,(int)b.gety()-i_haba/2,i_haba,i_haba); //円
                    }

                    g2.setStroke(new BasicStroke(f_h_TenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//??の太さや??の末端の形??

                }
            }
        }
        //System.out.println(" E 20170201_2");

        // ----------------------------------------------------------------

        //check結果の表示

        g2.setStroke(new BasicStroke(15.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));//??の太さや??の末端の形???Aここでは?ﾜ??の端点の??の形?ﾌ指定


        //Check1Senbには0番目からsize()-1番目までデ?[タが入っている
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

        g2.setStroke(new BasicStroke(25.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));//??の太さや??の末端の形???Aここでは?ﾜ??の端点の??の形?ﾌ指定


        //Check4Senbには0番目からsize()-1番目までデ?[タが入っている
        //System.out.println("ori_s.check4_size() = "+ori_s.check4_size());
        if (i_check4 == 1) {
            for (int i = 0; i < ori_s.check4_size(); i++) {
                Senbun s_temp = new Senbun();
                s_temp.set(ori_s.check4_getSenbun(i));
                OO.yubisasi4(g, camera.object2TV(s_temp), i_ck4_color_toukado);
            }
        }


        //Check3Senbには0番目からsize()-1番目までデ?[タが入っている
        if (i_check3 == 1) {
            for (int i = 0; i < ori_s.check3_size(); i++) {
                Senbun s_temp = new Senbun();
                s_temp.set(ori_s.check3_getSenbun(i));
                //OO.jyuuji(g,camera.object2TV(s_temp.geta()), 7.0 , 3.0 , 1);
                OO.yubisasi3(g, camera.object2TV(s_temp), 7.0, 3.0, 1);
            }
        }


        //System.out.println(" E 20170201_4");

        //camera中?Sを?\字で描く
        if (i_mejirusi_hyouji == 1) {
            OO.jyuuji(g, camera.object2TV(camera.get_camera_ichi()), 5.0, 2.0, 3);
        }


        //System.out.println(" E 20170201_5");


        //円を描く?@
        //System.out.println(" 円を描く ori_s.cir_size()="+ori_s.cir_size());
        if (i_a0_hyouji == 1) {
            for (int i = 1; i <= ori_s.cir_size(); i++) {

                double d_haba;
                En e_temp = new En();
                e_temp.set(ori_s.cir_getEn(i));

                a.set(camera.object2TV(e_temp.get_tyuusin()));//この???№ﾌaは描画?ﾀ標系での円の中?Sの位置
                //a.set(a.getx()+0.000001,a.gety()+0.000001);//なぜ0.000001を足すかというと,ディスプレイに描画するとき元の?ﾜ??が?Vしい?ﾜ??に影響されて動いてしまうのを防ぐため

                g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//基本指定A?@?@??の太さや??の末端の形??
                //g.setColor(Color.cyan);


//System.out.println("get_tpp_en("+i+") = "+ori_s.get_tpp_en(i));
                if (e_temp.get_tpp() == 0) {
                    g_setColor(g, e_temp.getcolor());
                } else if (e_temp.get_tpp() == 1) {
                    g.setColor(e_temp.get_tpp_color());
                }


                //円周の描画
                d_haba = e_temp.getr() * camera.get_camera_bairitsu_x();//d_habaは描画時の円の半径?Bなお?Acamera.get_camera_bairitsu_x()??camera.get_camera_bairitsu_y()を前提としている?B
                g2.draw(new Ellipse2D.Double(a.getx() - d_haba, a.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));


                // 点t_oをお絵かきするのに必要な手??
                //Ten t_o =new Ten(100.0,100.0);//t_oを定義
                //Ten t_T =new Ten();t_T.set(camera.object2TV(t_o));//t_Tを定義し?At_oを描画用?ﾀ標用にに変換下ものをsetする?B
                //g.fillRect( (int)t_T.getx()-1,(int)t_T.gety()-1,3,3); //?ｳ方形を描く//g.fillRect(10, 10, 100, 50);長方形を描く

/*
				Ten t_o =new Ten();Ten t_T =new Ten();
				for(int h=1;h<360;h++ ){
					t_o.set(e_temp.get_tyuusin().getx()+e_temp.getr()*Math.cos((double)h),
						e_temp.get_tyuusin().gety()+e_temp.getr()*Math.sin((double)h));

					t_T.set(camera.object2TV(t_o));
					g.fillRect( (int)t_T.getx()-1,(int)t_T.gety()-1,3,3); //?ｳ方形を描く//g.fillRect(10, 10, 100, 50);長方形を描く
				}
*/
            }
        }


        //円の中?Sの描画
        if (i_a0_hyouji == 1) {
            for (int i = 1; i <= ori_s.cir_size(); i++) {
                //if(ori_s.getcolor(i)==3){
                double d_haba;
                En e_temp = new En();
                e_temp.set(ori_s.cir_getEn(i));
                //System.out.println("Es1 お絵かき  "+ i+";" +e_temp.getx()+"," +e_temp.gety()+"," +e_temp.getr());

                a.set(camera.object2TV(e_temp.get_tyuusin()));//この???№ﾌaは描画?ﾀ標系での円の中?Sの位置
                //a.set(a.getx()+0.000001,a.gety()+0.000001);//なぜ0.000001を足すかというと,ディスプレイに描画するとき元の?ﾜ??が?Vしい?ﾜ??に影響されて動いてしまうのを防ぐため

                g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//基本指定A?@?@??の太さや??の末端の形??
                //g.setColor(Color.cyan);
                g.setColor(new Color(0, 255, 255, 255));

                //円の中?Sの描画
                if (fTenkaizuSenhaba < 2.0f) {//中?Sの?浮｢?ｳ方形を描く
                    g.setColor(Color.black);
                    //int i_haba=1;
                    int i_haba = ir_ten;
                    g.fillRect((int) a.getx() - i_haba, (int) a.gety() - i_haba, 2 * i_haba + 1, 2 * i_haba + 1); //?ｳ方形を描く//g.fillRect(10, 10, 100, 50);長方形を描く
                    //g.fillRect( (int)b.getx()-i_haba,(int)b.gety()-i_haba,2*i_haba+1,2*i_haba+1); //?ｳ方形を描く
                }

                if (fTenkaizuSenhaba >= 2.0f) {//  太??指定時の中?Sを示す?浮｢?ｬ円を描く
                    g2.setStroke(new BasicStroke(1.0f + fTenkaizuSenhaba % 1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//??の太さや??の末端の形???Aここでは?ﾜ??の端点の??の形?ﾌ指定
                    if (ir_ten != 0) {
                        int i_haba = (int) fTenkaizuSenhaba + ir_ten;//int i_haba=2;
                        d_haba = (double) fTenkaizuSenhaba / 2.0 + (double) ir_ten;//int i_haba=2;


                        g.setColor(Color.white);
                        g2.fill(new Ellipse2D.Double(a.getx() - d_haba, a.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                        //g.fillOval( (int)a.getx()-i_haba/2,(int)a.gety()-i_haba/2,i_haba,i_haba); //円


                        g.setColor(Color.black);
                        g2.draw(new Ellipse2D.Double(a.getx() - d_haba, a.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                        //g.drawOval( (int)a.getx()-i_haba/2,(int)a.gety()-i_haba/2,i_haba,i_haba); //円

                    }
                }
                //}
            }

        }


        //selectの描画
        g2.setStroke(new BasicStroke(fTenkaizuSenhaba * 2.0f + 2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//基本指定A?@?@??の太さや??の末端の形??
        for (int i = 1; i <= ori_s.getsousuu(); i++) {
            if (ori_s.get_select(i) == 2) {
                g.setColor(Color.green);

                s_tv.set(camera.object2TV(ori_s.get(i)));

                a.set(s_tv.getax() + 0.000001, s_tv.getay() + 0.000001);
                b.set(s_tv.getbx() + 0.000001, s_tv.getby() + 0.000001);//なぜ0.000001を足すかというと,ディスプレイに描画するとき元の?ﾜ??が?Vしい?ﾜ??に影響されて動いてしまうのを防ぐため

                g.drawLine((int) a.getx(), (int) a.gety(), (int) b.getx(), (int) b.gety()); //直??

            }
        }


        //展開?}の描画 補?賦???のみ
        if (i_a0_hyouji == 1) {
            for (int i = 1; i <= ori_s.getsousuu(); i++) {
                if (ori_s.getcolor(i) == 3) {

                    g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//基本指定A?@?@??の太さや??の末端の形??
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
                    b.set(s_tv.getbx() + 0.000001, s_tv.getby() + 0.000001);//なぜ0.000001を足すかというと,ディスプレイに描画するとき元の?ﾜ??が?Vしい?ﾜ??に影響されて動いてしまうのを防ぐため

                    g.drawLine((int) a.getx(), (int) a.gety(), (int) b.getx(), (int) b.gety()); //直??

                    if (fTenkaizuSenhaba < 2.0f) {//頂点の?浮｢?ｳ方形を描く
                        g.setColor(Color.black);
                        //int i_haba=1;
                        int i_haba = ir_ten;
                        g.fillRect((int) a.getx() - i_haba, (int) a.gety() - i_haba, 2 * i_haba + 1, 2 * i_haba + 1); //?ｳ方形を描く//g.fillRect(10, 10, 100, 50);長方形を描く
                        g.fillRect((int) b.getx() - i_haba, (int) b.gety() - i_haba, 2 * i_haba + 1, 2 * i_haba + 1); //?ｳ方形を描く
                    }

                    if (fTenkaizuSenhaba >= 2.0f) {//  太??
                        g2.setStroke(new BasicStroke(1.0f + fTenkaizuSenhaba % 1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//??の太さや??の末端の形???Aここでは?ﾜ??の端点の??の形?ﾌ指定
                        if (ir_ten != 0) {
                            int i_haba = (int) fTenkaizuSenhaba + ir_ten;//int i_haba=2;
                            double d_haba = (double) fTenkaizuSenhaba / 2.0 + (double) ir_ten;//int i_haba=2;


                            g.setColor(Color.white);
                            g2.fill(new Ellipse2D.Double(a.getx() - d_haba, a.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                            //g.fillOval( (int)a.getx()-i_haba/2,(int)a.gety()-i_haba/2,i_haba,i_haba); //円


                            g.setColor(Color.black);
                            g2.draw(new Ellipse2D.Double(a.getx() - d_haba, a.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                            //g.drawOval( (int)a.getx()-i_haba/2,(int)a.gety()-i_haba/2,i_haba,i_haba); //円

                            g.setColor(Color.white);
                            g2.fill(new Ellipse2D.Double(b.getx() - d_haba, b.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                            //g.fillOval( (int)b.getx()-i_haba/2,(int)b.gety()-i_haba/2,i_haba,i_haba); //円

                            g.setColor(Color.black);
                            g2.draw(new Ellipse2D.Double(b.getx() - d_haba, b.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                            //g.drawOval( (int)b.getx()-i_haba/2,(int)b.gety()-i_haba/2,i_haba,i_haba); //円
                        }
                    }
                }
            }

        }

        //System.out.println(" E 20170201_6");

        //展開?}の描画  補?賦???以外の?ﾜ??
        if (i_cp_hyouji == 1) {

            g.setColor(Color.black);

            float[] dash_M1 = {10.0f, 3.0f, 3.0f, 3.0f};//一点?ｽ??
            float[] dash_M2 = {10.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f};//二点?ｽ??
            float[] dash_V = {8.0f, 8.0f};//破??

            g.setColor(Color.black);
            for (int i = 1; i <= ori_s.getsousuu(); i++) {
                if (ori_s.getcolor(i) != 3) {
                    if (i_orisen_hyougen == 1) {
                        g_setColor(g, ori_s.getcolor(i));
                        g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//基本指定A?@?@??の太さや??の末端の形??
                    }

                    if (i_orisen_hyougen == 2) {
                        g_setColor(g, ori_s.getcolor(i));
                        if (ori_s.getcolor(i) == 0) {
                            g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
                        }//基本指定A?@?@??の太さや??の末端の形??
                        if (ori_s.getcolor(i) == 1) {
                            g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash_M1, 0.0f));
                        }//一点?ｽ??//??の太さや??の末端の形??
                        if (ori_s.getcolor(i) == 2) {
                            g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash_V, 0.0f));
                        }//破??//??の太さや??の末端の形??
                    }

                    if (i_orisen_hyougen == 3) {
                        if (ori_s.getcolor(i) == 0) {
                            g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
                        }//基本指定A?@?@??の太さや??の末端の形??
                        if (ori_s.getcolor(i) == 1) {
                            g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash_M1, 0.0f));
                        }//一点?ｽ??//??の太さや??の末端の形??
                        if (ori_s.getcolor(i) == 2) {
                            g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash_V, 0.0f));
                        }//破??//??の太さや??の末端の形??
                    }

                    if (i_orisen_hyougen == 4) {
                        if (ori_s.getcolor(i) == 0) {
                            g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
                        }//基本指定A?@?@??の太さや??の末端の形??
                        if (ori_s.getcolor(i) == 1) {
                            g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash_M2, 0.0f));
                        }//二点?ｽ??//??の太さや??の末端の形??
                        if (ori_s.getcolor(i) == 2) {
                            g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash_V, 0.0f));
                        }//破??//??の太さや??の末端の形??
                    }


                    s_tv.set(camera.object2TV(ori_s.get(i)));
                    //a.set(s_tv.geta()); b.set(s_tv.getb());
                    a.set(s_tv.getax() + 0.000001, s_tv.getay() + 0.000001);
                    b.set(s_tv.getbx() + 0.000001, s_tv.getby() + 0.000001);//なぜ0.000001を足すかというと,ディスプレイに描画するとき元の?ﾜ??が?Vしい?ﾜ??に影響されて動いてしまうのを防ぐため


                    g.drawLine((int) a.getx(), (int) a.gety(), (int) b.getx(), (int) b.gety()); //直??


                    if (fTenkaizuSenhaba < 2.0f) {//頂点の?浮｢?ｳ方形を描く
                        g.setColor(Color.black);
                        //int i_haba=1;
                        int i_haba = ir_ten;
                        g.fillRect((int) a.getx() - i_haba, (int) a.gety() - i_haba, 2 * i_haba + 1, 2 * i_haba + 1); //?ｳ方形を描く//g.fillRect(10, 10, 100, 50);長方形を描く
                        g.fillRect((int) b.getx() - i_haba, (int) b.gety() - i_haba, 2 * i_haba + 1, 2 * i_haba + 1); //?ｳ方形を描く
                    }


                    if (fTenkaizuSenhaba >= 2.0f) {//  太??
                        g2.setStroke(new BasicStroke(1.0f + fTenkaizuSenhaba % 1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//??の太さや??の末端の形???Aここでは?ﾜ??の端点の??の形?ﾌ指定
                        if (ir_ten != 0) {
                            int i_haba = (int) fTenkaizuSenhaba + ir_ten;//int i_haba=2;
                            double d_haba = (double) fTenkaizuSenhaba / 2.0 + (double) ir_ten;//int i_haba=2;


                            g.setColor(Color.white);
                            g2.fill(new Ellipse2D.Double(a.getx() - d_haba, a.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                            //g.fillOval( (int)a.getx()-i_haba/2,(int)a.gety()-i_haba/2,i_haba,i_haba); //円


                            g.setColor(Color.black);
                            g2.draw(new Ellipse2D.Double(a.getx() - d_haba, a.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                            //g.drawOval( (int)a.getx()-i_haba/2,(int)a.gety()-i_haba/2,i_haba,i_haba); //円

                            g.setColor(Color.white);
                            g2.fill(new Ellipse2D.Double(b.getx() - d_haba, b.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                            //g.fillOval( (int)b.getx()-i_haba/2,(int)b.gety()-i_haba/2,i_haba,i_haba); //円

                            g.setColor(Color.black);
                            g2.draw(new Ellipse2D.Double(b.getx() - d_haba, b.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                            //g.drawOval( (int)b.getx()-i_haba/2,(int)b.gety()-i_haba/2,i_haba,i_haba); //円
                        }

                    }
                }
            }
        }

        //i_mouse_modeA==61//長方形内選択?ipaintの選択に似せた選択機能?jの時に使う
        if (orihime_ap.i_mouse_modeA == 61) {
            Ten p1 = new Ten();
            p1.set(camera.TV2object(p61_1));
            Ten p2 = new Ten();
            p2.set(camera.TV2object(p61_2));
            Ten p3 = new Ten();
            p3.set(camera.TV2object(p61_3));
            Ten p4 = new Ten();
            p4.set(camera.TV2object(p61_4));

            s_step[1].set(p1, p2); //?c??
            s_step[2].set(p2, p3); //横??
            s_step[3].set(p3, p4); //?c??
            s_step[4].set(p4, p1); //横??

            s_step[1].setcolor(6);
            s_step[2].setcolor(6);
            s_step[3].setcolor(6);
            s_step[4].setcolor(6);
        }

        //??分入力時の一時的なs_step??分を描く?@

        if ((orihime_ap.i_mouse_modeA == 61) && (i_egaki_dankai != 4)) {
        } else {
            for (int i = 1; i <= i_egaki_dankai; i++) {
                g_setColor(g, s_step[i].getcolor());
                g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//基本指定A?@?@??の太さや??の末端の形??

                s_tv.set(camera.object2TV(s_step[i]));
                //a.set(s_tv.geta()); b.set(s_tv.getb());
                a.set(s_tv.getax() + 0.000001, s_tv.getay() + 0.000001);
                b.set(s_tv.getbx() + 0.000001, s_tv.getby() + 0.000001);//なぜ0.000001を足すかというと,ディスプレイに描画するとき元の?ﾜ??が?Vしい?ﾜ??に影響されて動いてしまうのを防ぐため


                g.drawLine((int) a.getx(), (int) a.gety(), (int) b.getx(), (int) b.gety()); //直??
                int i_haba_nyuiiryokuji = 3;
                if (i_kou_mitudo_nyuuryoku == 1) {
                    i_haba_nyuiiryokuji = 2;
                }

                if (s_step[i].getiactive() == 1) {
                    g.fillOval((int) a.getx() - i_haba_nyuiiryokuji, (int) a.gety() - i_haba_nyuiiryokuji, 2 * i_haba_nyuiiryokuji, 2 * i_haba_nyuiiryokuji); //円
                    //g.fillOval( (int)b.getx()-i_haba_nyuiiryokuji,(int)b.gety()-i_haba_nyuiiryokuji,2*i_haba_nyuiiryokuji,2*i_haba_nyuiiryokuji); //円
                }
                if (s_step[i].getiactive() == 2) {
                    //g.fillOval( (int)a.getx()-i_haba_nyuiiryokuji,(int)a.gety()-i_haba_nyuiiryokuji,2*i_haba_nyuiiryokuji,2*i_haba_nyuiiryokuji); //円
                    g.fillOval((int) b.getx() - i_haba_nyuiiryokuji, (int) b.gety() - i_haba_nyuiiryokuji, 2 * i_haba_nyuiiryokuji, 2 * i_haba_nyuiiryokuji); //円
                }
                if (s_step[i].getiactive() == 3) {
                    g.fillOval((int) a.getx() - i_haba_nyuiiryokuji, (int) a.gety() - i_haba_nyuiiryokuji, 2 * i_haba_nyuiiryokuji, 2 * i_haba_nyuiiryokuji); //円
                    g.fillOval((int) b.getx() - i_haba_nyuiiryokuji, (int) b.gety() - i_haba_nyuiiryokuji, 2 * i_haba_nyuiiryokuji, 2 * i_haba_nyuiiryokuji); //円
                }


                //g.fillOval( (int)b.getx()-i_haba,(int)b.gety()-i_haba,2*i_haba,2*i_haba); //円
            }
        }
        //候補入力時の候補を描く//System.out.println("_");
        //g2.setStroke(new BasicStroke(fTenkaizuSenhaba+1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//基本指定A
        g2.setStroke(new BasicStroke(fTenkaizuSenhaba + 0.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//基本指定A


        for (int i = 1; i <= i_kouho_dankai; i++) {
            g_setColor(g, s_kouho[i].getcolor());

            s_tv.set(camera.object2TV(s_kouho[i]));
            //a.set(s_tv.geta()); b.set(s_tv.getb());
            a.set(s_tv.getax() + 0.000001, s_tv.getay() + 0.000001);
            b.set(s_tv.getbx() + 0.000001, s_tv.getby() + 0.000001);//なぜ0.000001を足すかというと,ディスプレイに描画するとき元の?ﾜ??が?Vしい?ﾜ??に影響されて動いてしまうのを防ぐため

            g.drawLine((int) a.getx(), (int) a.gety(), (int) b.getx(), (int) b.gety()); //直??
            //int i_haba=ir_ten   +1;
            int i_haba = ir_ten + 5;
            //g.fillRect( (int)a.getx()-i_haba,(int)a.gety()-i_haba,2*i_haba+1,2*i_haba+1); //?ｳ方形を描く//g.fillRect(10, 10, 100, 50);長方形を描く
            //g.fillRect( (int)b.getx()-i_haba,(int)b.gety()-i_haba,2*i_haba+1,2*i_haba+1); //?ｳ方形を描く

            if (s_kouho[i].getiactive() == 1) {
                //g.fillRect( (int)a.getx()-i_haba,(int)a.gety()-i_haba,2*i_haba+1,2*i_haba+1); //?ｳ方形を描く//g.fillRect(10, 10, 100, 50);長方形を描く
                g.drawLine((int) a.getx() - i_haba, (int) a.gety(), (int) a.getx() + i_haba, (int) a.gety()); //直??
                g.drawLine((int) a.getx(), (int) a.gety() - i_haba, (int) a.getx(), (int) a.gety() + i_haba); //直??

            }
            if (s_kouho[i].getiactive() == 2) {
                //g.fillRect( (int)b.getx()-i_haba,(int)b.gety()-i_haba,2*i_haba+1,2*i_haba+1); //?ｳ方形を描く
                g.drawLine((int) b.getx() - i_haba, (int) b.gety(), (int) b.getx() + i_haba, (int) b.gety()); //直??
                g.drawLine((int) b.getx(), (int) b.gety() - i_haba, (int) b.getx(), (int) b.gety() + i_haba); //直??


            }
            if (s_kouho[i].getiactive() == 3) {
                //g.fillRect( (int)a.getx()-i_haba,(int)a.gety()-i_haba,2*i_haba+1,2*i_haba+1); //?ｳ方形を描く//g.fillRect(10, 10, 100, 50);長方形を描く
                //g.fillRect( (int)b.getx()-i_haba,(int)b.gety()-i_haba,2*i_haba+1,2*i_haba+1); //?ｳ方形を描く
                g.drawLine((int) a.getx() - i_haba, (int) a.gety(), (int) a.getx() + i_haba, (int) a.gety()); //直??
                g.drawLine((int) a.getx(), (int) a.gety() - i_haba, (int) a.getx(), (int) a.gety() + i_haba); //直??
                g.drawLine((int) b.getx() - i_haba, (int) b.gety(), (int) b.getx() + i_haba, (int) b.gety()); //直??
                g.drawLine((int) b.getx(), (int) b.gety() - i_haba, (int) b.getx(), (int) b.gety() + i_haba); //直??


            }
        }

        g.setColor(Color.black);

        //円入力時の一時的な??分を描く?@
        //g.setColor(Color.cyan);
        for (int i = 1; i <= i_en_egaki_dankai; i++) {
            g_setColor(g, e_step[i].getcolor());
            a.set(camera.object2TV(e_step[i].get_tyuusin()));//この???№ﾌs_tvは描画?ﾀ標系での円の中?Sの位置
            //a.set(s_tv.geta()); b.set(s_tv.getb());
            a.set(a.getx() + 0.000001, a.gety() + 0.000001);//なぜ0.000001を足すかというと,ディスプレイに描画するとき元の?ﾜ??が?Vしい?ﾜ??に影響されて動いてしまうのを防ぐため

            //g.drawLine( (int)a.getx(),(int)a.gety(),(int)b.getx(),(int)b.gety()); //直??
            double d_haba = e_step[i].getr() * camera.get_camera_bairitsu_x();//d_habaは描画時の円の半径?Bなお?Acamera.get_camera_bairitsu_x()??camera.get_camera_bairitsu_y()を前提としている?B

            //g2.fill(new Ellipse2D.Double(a.getx()-d_haba, a.gety()-d_haba, 2.0*d_haba,2.0*d_haba));
            g2.draw(new Ellipse2D.Double(a.getx() - d_haba, a.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
            //g.drawOval( (int)a.getx()-i_haba/2,(int)a.gety()-i_haba/2,i_haba,i_haba); //円
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

		Color.black       ?浮\します
		Color.blue        ?ﾂを表します
		Color.cyan        シアンを表します
		Color.darkGray    ダ?[クグレイを表します
		Color.gray        グレイを表します
		Color.green       緑を表します
		Color.lightGray   ライトグレイを表します
		Color.magenta     マゼンタを表します
		Color.orange      オレンジを表します
		Color.pink        ピンクを表します
		Color.red         ?ﾔを表します
		Color.white       白を表します
		Color.yellow      黄を表します
*/

        //icol=0 black
        //icol=1 red
        //icol=2 blue
        //icol=3 cyan
        //icol=4 orange
        //icol=5 mazenta
        //icol=6 green
        //icol=7 yellow
        //icol=8 new Color(210,0,255) //紫

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
        //g.setColor(new Color(100, 200,200));この?Fは補????用に使った方がいいかも
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
    public int addsenbun(Senbun s0) {//0=変?Xなし?A1=?Fの変化のみ?A2=??分追加

        ori_s.addsenbun(s0);//ori_sのsenbunの?ﾅ後にs0の?﨣ﾁえるだけ
        int sousuu_old = ori_s.getsousuu();
        ori_s.Senbun_en_kouten(ori_s.getsousuu(), ori_s.getsousuu(), 1, ori_s.cir_size());

        ori_s.kousabunkatu(1, sousuu_old - 1, sousuu_old, sousuu_old);

        return 1;
    }

    //------------------------------------------------------
    public Ten get_moyori_ten_orisen_en(Ten t0) {//
        //用紙1/1分割時 		?ﾜ??の端点のみが基??点?B格子点が基??点になることはない?B
        //用紙1/2から1/512分割時	?ﾜ??の端点と用紙枠内?i-200.0,-200.0 _ 200.0,200.0)?jの格子点とが基??点
        Ten t1 = new Ten(); //?ﾜ??の端点

        Ten t3 = new Ten(); //円の中?S

        t1.set(ori_s.mottomo_tikai_Ten(t0));//ori_s.mottomo_tikai_Ten_sagasiは近い点がないと p_return.set(100000.0,100000.0)と返してくる

        t3.set(ori_s.mottomo_tikai_Tyuusin(t0));//ori_s.mottomo_tikai_Ten_sagasiは近い点がないと p_return.set(100000.0,100000.0)と返してくる
        if (t0.kyori2jyou(t1) > t0.kyori2jyou(t3)) {
            t1.set(t3);
        }


        //if(kus.jyoutai()==0){return t1;}


        //if( t0.kyori2jyou(t1)>  t0.kyori2jyou(kus.moyori_kousi_ten(t0)) ){return kus.moyori_kousi_ten(t0);}
        return t1;
    }

//------------------------------


    public Ten get_moyori_ten(Ten t0) {
        //用紙1/1分割時 		?ﾜ??の端点のみが基??点?B格子点が基??点になることはない?B
        //用紙1/2から1/512分割時	?ﾜ??の端点と用紙枠内?i-200.0,-200.0 _ 200.0,200.0)?jの格子点とが基??点
        Ten t1 = new Ten(); //?ﾜ??の端点

        Ten t3 = new Ten(); //円の中?S

        t1.set(ori_s.mottomo_tikai_Ten(t0));//ori_s.mottomo_tikai_Ten_sagasiは近い点がないと p_return.set(100000.0,100000.0)と返してくる

        t3.set(ori_s.mottomo_tikai_Tyuusin(t0));//ori_s.mottomo_tikai_Ten_sagasiは近い点がないと p_return.set(100000.0,100000.0)と返してくる
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
            }//柄の部分に近いかどうか

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
            }//円周に近いかどうか
        }
        return e_step[minrid];
    }


    public void set_s_step_iactive(int ia) {

        for (int i = 0; i < 1024; i++) {
            s_step[i].setiactive(ia);
        }


    }

//--------------------------------------------------------------------------------------
//マウス操??----------------------------------------------------------------------------
//--------------------------------------------------------------------------------------
//	Ten p =new Ten();

    //動??モデル001--------------------------------------------------------------------------------------------------------
    //マウス操??(マウスを動かしたとき)を?sう関??
    public void mMoved_m_001(Ten p0, int i_c) {//マウスで選択できる候補点を表示する?B近くに既?ｬの点があるときはその点が候補点となる?B近くに既?ｬの点が無いときは候補点無しなので候補点の表示も無し?B
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


    //動??モデル002--------------------------------------------------------------------------------------------------------
    //マウス操??(マウスを動かしたとき)を?sう関??
    public void mMoved_m_002(Ten p0, int i_c) {//マウスで選択できる候補点を表示する?B近くに既?ｬの点があるときはその点?A無いときはマウスの位置自?gが候補点となる?B
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


    //動??モデル00a--------------------------------------------------------------------------------------------------------
    //マウスクリック?iマウスの近くの既?ｬ点を選択?j?Aマウスドラッグ?i選択した点とマウス間の??が表示される?j?Aマウスリリ?[ス?iマウスの近くの既?ｬ点を選択?jしてから目的の????をする?洛`セット

    //マウスを動かしたとき----------------------------------------------
    public void mMoved_m_00a(Ten p0, int i_c) {
        mMoved_m_001(p0, i_c);
    }//近い既存点のみ表示

    //マウスクリック----------------------------------------------------
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

    //マウスドラッグ---------------------------------------------------
    public void mDragged_m_00a(Ten p0, int i_c) {  //近い既存点のみ表示

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

    //マウスリリ?[ス--------------------------------------------------
    public void mReleased_m_00a(Ten p0) {
        if (i_egaki_dankai == 1) {
            i_egaki_dankai = 0;

            p.set(camera.TV2object(p0));
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) <= d_hantei_haba) {
                s_step[1].seta(moyori_ten);
                if (s_step[1].getnagasa() > 0.00000001) {
                    //やりたい動??はここに?曹ｭ
                    //addsenbun(s_step[1]);
                    //kiroku();
                }
            }
        }
    }


    //動??モデル00b--------------------------------------------------------------------------------------------------------
    //マウスクリック?i近くの既?ｬ点かマウス位置を選択?j?Aマウスドラッグ?i選択した点とマウス間の??が表示される?j?Aマウスリリ?[ス?i近くの既?ｬ点かマウス位置を選択?jしてから目的の????をする?洛`セット

    //マウスを動かしたとき----------------------------------------------
    public void mMoved_m_00b(Ten p0, int i_c) {
        mMoved_m_002(p0, i_c);
    }//近くの既?ｬ点かマウス位置表示

    //マウスクリック----------------------------------------------------
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

    //マウスドラッグ---------------------------------------------------
    public void mDragged_m_00b(Ten p0, int i_c) {  //近くの既?ｬ点かマウス位置表示

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

    //マウスリリ?[ス--------------------------------------------------
    public void mReleased_m_00b(Ten p0) {
        i_egaki_dankai = 0;
        p.set(camera.TV2object(p0));
        s_step[1].seta(p);
        moyori_ten.set(get_moyori_ten(p));
        if (p.kyori(moyori_ten) <= d_hantei_haba) {
            s_step[1].seta(moyori_ten);
        }
        if (s_step[1].getnagasa() > 0.00000001) {
            //やりたい動??はここに?曹ｭ

        }
    }


//--------------------------------------------
//28 28 28 28 28 28 28 28  i_mouse_modeA==28??分内分入力
    //動??概要
    //i_mouse_modeA==1と??分内分以外は同じ

    //マウス操??(マウスを動かしたとき)を?sう関??
    public void mMoved_A_28(Ten p0) {
        mMoved_m_00a(p0, icol);//マウスで選択できる候補点を表示する?B近くに既?ｬの点があるときはその点?A無いときはマウスの位置自?gが候補点となる?B

    }

    //マウス操??(i_mouse_modeA==28??分内分入力 でボタンを押したとき)時の??業----------------------------------------------------
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

    //マウス操??(i_mouse_modeA==28??分入力 でドラッグしたとき)を?sう関??----------------------------------------------------
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

    //マウス操??(i_mouse_modeA==28??分入力?@でボタンを離したとき)を?sう関??----------------------------------------------------
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


//1 1 1 1 1 1 01 01 01 01 01 11111111111 i_mouse_modeA==1??分入力 111111111111111111111111111111111
    //動??概要?@
    //マウスボタン押されたとき?@
    //用紙1/1分割時 		?ﾜ??の端点のみが基??点?B格子点が基??点になることはない?B
    //用紙1/2から1/512分割時	?ﾜ??の端点と用紙枠内?i-200.0,-200.0 _ 200.0,200.0)?jの格子点とが基??点
    //入力点Pが基??点から格子??kus.d_haba()の1/4より遠いときは?ﾜ???W?№ﾖの入力なし
    //??分が長さがなく1点?ﾌときは?ﾜ???W?№ﾖの入力なし

    //マウス操??(マウスを動かしたとき)を?sう関??
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

    //マウス操??(i_mouse_modeA==1??分入力?@でボタンを押したとき)時の??業----------------------------------------------------
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

    //マウス操??(i_mouse_modeA==1??分入力?@でドラッグしたとき)を?sう関??----------------------------------------------------
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


    //マウス操??(i_mouse_modeA==1??分入力?@でボタンを離したとき)を?sう関??----------------------------------------------------
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
    //マウス操??(マウスを動かしたとき)を?sう関??
    public void mMoved_A_11(Ten p0) {
        mMoved_m_00a(p0, icol);
    }//近い既存点のみ表示

    //マウス操??(i_mouse_modeA==11??分入力?@でボタンを押したとき)時の??業----------------------------------------------------
    public void mPressed_A_11(Ten p0) {
        mPressed_m_00a(p0, icol);
    }

    //マウス操??(i_mouse_modeA==11??分入力?@でドラッグしたとき)を?sう関??----------------------------------------------------
    public void mDragged_A_11(Ten p0) {
        mDragged_m_00a(p0, icol);
    }//近い既存点のみ表示

    //マウス操??(i_mouse_modeA==11??分入力?@でボタンを離したとき)を?sう関??----------------------------------------------------
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


//62 62 62 62 62 i_mouse_modeA==62 ボ??ノイ?@ Voronoi 111111111111111111111111111111111


    ArrayList Senb_boro_1p = new ArrayList(); //ボ??ノイ?}の一点の周りの??分

// ------------------------------------------


    //マウス操??(i_mouse_modeA==62ボ??ノイ?@マウスを動かしたとき)を?sう関??
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


//int s_step_no_saisyo_no_sen_no_bangou() {//s_step[i]で?ﾅ?奄ﾉ???i長さが０でない?jがでてくる番??を返す?B???i長さが０でない?jがない???№ﾍ0を返す
//		for (int i=1; i<=i_egaki_dankai; i++ ){if(s_step[i].getnagasa()>0.00000001){return i;}
//return 0;
//}


    // ------------------------------------------------------------------------------------------------------------
    int s_step_no_1_kara_rennzoku_no_ten_no_bangou() {//s_step[i]で?ﾅ?奄ｩら連続でTen?i長さが０?jが何番目まででてくるか番??を返す?B点がない???№ﾍ0を返す
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
    int i_mouse_modeA_62_ten_kasanari;//?Vたに加えたpが?｡までに加えたTenと?dなっていない=0?A?dなっている=1

    //マウス操??(i_mouse_modeA==62ボ??ノイ?@でボタンを押したとき)時の??業----------------------------------------------------
    public void mPressed_A_62(Ten p0) {
        p.set(camera.TV2object(p0));

        //i_egaki_dankaiが?]来のボ??ノイ母点だけになるように?ｮ??(まだ?A点pをs_stepとしてボ??ノイ母点に加えるかどうかは決めていない)
        i_egaki_dankai = s_step_no_1_kara_rennzoku_no_ten_no_bangou();//Tenの??


        //両端が?Vたに加えたpの?ﾅ寄点からなる点?ﾌ??分s_tempを??める?i?ﾅ寄点がない???№ﾍs_tempの両端はp?j
        Senbun s_temp = new Senbun();
        moyori_ten.set(get_moyori_ten(p));
        if (p.kyori(moyori_ten) < d_hantei_haba) {
            s_temp.set(moyori_ten, moyori_ten);
            s_temp.setcolor(5);
        } else {
            s_temp.set(p, p);
            s_temp.setcolor(5);
        }


        //?Vたに加えたpが?｡までに加えたTenと?dなっていないことを確認
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


        //?Vたに加えたpが?｡までに加えたTenと?dなっていないことを確認 ここまで

        if (i_mouse_modeA_62_ten_kasanari == 0) {
            //oc.hyouji("?@");
            //oc.hyouji("?Vしいボ??ノイ母点を加える?@開始?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[");

            //１個の?Vしいボ??ノイ母点を加える(ここでやっと?A点pをs_stepとしてボ??ノイ母点に加えると決まった)
            i_egaki_dankai = i_egaki_dankai + 1;
            s_step[i_egaki_dankai].set(s_temp);
            s_step[i_egaki_dankai].setiactive(3);//iactive=3の??は両端に円が描かれる?Biactive=1の??はa端のみに円が描かれる?Biactive=2の??はb端のみに円が描かれる

            //?｡までのボ??ノイ?}を元に?A１個の?Vしいボ??ノイ母点を加えたボ??ノイ?}を??る--------------------------------------
            //System.out.println("---------------------------");
            //System.out.println("voronoi_() start");

            //voronoi_01();//低速?Aエラ?[はほとんどないはず
            voronoi_02();//?ｑｬ?Aもしかしてエラ?[残っているかも

            //System.out.println("voronoi_() stop");


        } else if (i_mouse_modeA_62_ten_kasanari != 0) {//?∑ﾔがi_mouse_modeA_62_ten_kasanariのボ??ノイ母点を????
            //oc.hyouji("?@");
            //oc.hyouji("ボ??ノイ母点を?????@開始?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[");

            //?∑ﾔがi_mouse_modeA_62_ten_kasanariのボ??ノイ母点と?∑ﾔが?ﾅ後(=i_egaki_dankai)のボ??ノイ母点を入れ替える
            //s_step[i]の入れ替え
            Senbun S_irekae = new Senbun();
            S_irekae.set(s_step[i_mouse_modeA_62_ten_kasanari]);
            s_step[i_mouse_modeA_62_ten_kasanari].set(s_step[i_egaki_dankai]);
            s_step[i_egaki_dankai].set(S_irekae);


            for (int j = 1; j <= ori_v.getsousuu(); j++) {
                //ori_v内の??分のiactiveの入れ替え
                if (ori_v.getiactive(j) == i_mouse_modeA_62_ten_kasanari) {
                    ori_v.setiactive(j, i_egaki_dankai);
                } else if (ori_v.getiactive(j) == i_egaki_dankai) {
                    ori_v.setiactive(j, i_mouse_modeA_62_ten_kasanari);
                }

                //ori_v内の??分のicolの入れ替え
                if (ori_v.getcolor(j) == i_mouse_modeA_62_ten_kasanari) {
                    ori_v.setcolor(j, i_egaki_dankai);
                } else if (ori_v.getcolor(j) == i_egaki_dankai) {
                    ori_v.setcolor(j, i_mouse_modeA_62_ten_kasanari);
                }
            }


            //?∑ﾔが?ﾅ後(=i_egaki_dankai)ののボ??ノイ母点を????

            i_egaki_dankai = i_egaki_dankai - 1;

            Orisensyuugou ori_v_temp = new Orisensyuugou();    //?C?ｳ用のボ??ノイ?}の??を格納する

            //ori_vの??分を?ﾅ?奄ﾉ全て非選択にする
            ori_v.unselect_all();

            //i_egaki_dankai+1のボ??ノイ母点からのボ??ノイ??分を選択?ﾔにする
            Senbun s_tem = new Senbun();
            Senbun s_tem2 = new Senbun();
            for (int j = 1; j <= ori_v.getsousuu(); j++) {
                s_tem.set(ori_v.get(j));//s_temとしてボ??ノイ母点からのボ??ノイ??分か判定
                if (s_tem.getiactive() == i_egaki_dankai + 1) {//ボ??ノイ??分の2つのボ??ノイ頂点はiactiveとcolorに記録されている
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


                    //???怩ｳれるi_egaki_dankai+1番目のボ??ノイ母点と組になる?Aもう一つのボ??ノイ母点を取り囲むボ??ノイ??分のアレイリストを得る?B
                    Senb_boro_1p_motome(s_tem.getcolor());

                    for (int i = 0; i < Senb_boro_1p.size(); i++) {
                        Senbun add_S = new Senbun();
                        add_S.set((Senbun) Senb_boro_1p.get(i));
                        Senbun add_S2 = new Senbun();


                        //ori_v_tempにadd_Sを追加するかどうかの事前チェック
                        int i_tuika = 1;//1なら追加する?B0なら追加しない?B
                        for (int h = 1; h <= ori_v_temp.getsousuu(); h++) {
                            add_S2.set(ori_v_temp.get(h));
                            if ((add_S.getcolor() == add_S2.getcolor()) && (add_S.getiactive() == add_S2.getiactive())) {
                                i_tuika = 0;
                            }
                            if ((add_S.getcolor() == add_S2.getiactive()) && (add_S.getiactive() == add_S2.getcolor())) {
                                i_tuika = 0;
                            }
                        }
                        //ori_v_tempにadd_Sを追加するかどうかの事前チェックはここまで

                        if (i_tuika == 1) {
                            ori_v_temp.addsenbun((Senbun) Senb_boro_1p.get(i));
                        }
                    }
                } else if (s_tem.getcolor() == i_egaki_dankai + 1) {//ボ??ノイ??分の2つのボ??ノイ頂点はiactiveとcolorに記録されている
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

                    //???怩ｳれるi_egaki_dankai+1番目のボ??ノイ母点と組になる?Aもう一つのボ??ノイ母点を取り囲むボ??ノイ??分のアレイリストを得る?B
                    Senb_boro_1p_motome(s_tem.getiactive());

                    for (int i = 0; i < Senb_boro_1p.size(); i++) {
                        Senbun add_S = new Senbun();
                        add_S.set((Senbun) Senb_boro_1p.get(i));
                        Senbun add_S2 = new Senbun();

                        //ori_v_tempにadd_Sを追加するかどうかの事前チェック
                        int i_tuika = 1;//1なら追加する?B0なら追加しない?B
                        for (int h = 1; h <= ori_v_temp.getsousuu(); h++) {
                            add_S2.set(ori_v_temp.get(h));
                            if ((add_S.getcolor() == add_S2.getcolor()) && (add_S.getiactive() == add_S2.getiactive())) {
                                i_tuika = 0;
                            }
                            if ((add_S.getcolor() == add_S2.getiactive()) && (add_S.getiactive() == add_S2.getcolor())) {
                                i_tuika = 0;
                            }
                        }
                        //ori_v_tempにadd_Sを追加するかどうかの事前チェックはここまで

                        if (i_tuika == 1) {
                            ori_v_temp.addsenbun((Senbun) Senb_boro_1p.get(i));
                        }
                    }


                }

            }
            //選択?ﾔのものを????
            ori_v.del_selected_senbun_hayai();
            ori_v.del_V_all(); //この?sはいらないかも

            //ori_v_tempのボ??ノイ??分をボ??ノイ母点に加える
            //ori_v_temp.hyouji("ori_v_temp---------------------");
            for (int j = 1; j <= ori_v_temp.getsousuu(); j++) {
                Senbun s_t = new Senbun();
                s_t.set(ori_v_temp.get(j));
                //s_t.hyouji("  s_t  ");
                //addsenbun_voronoi(s_t);//addsenbun_voronoiは交?ｷ分割をしている?B交?ｷ分割でiactiveを使うので?Aiactiveを別途何かに転用したル?[チンでは交?ｷ分割を使用できないのでaddsenbun_voronoiも使用できない
                ori_v.addsenbun(s_t);
            }


            ori_v.del_V_all();

        }


        //ボ??ノイ?}も表示するようにs_stepの後にボ??ノイ?}の??を入れる

        int imax = ori_v.getsousuu();
        if (imax > 1020) {
            imax = 1020;
        }

        //System.out.println("ボ??ノイ?}も表示するようにs_stepの後にボ??ノイ?}の??を入れる前");
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
    public int addsenbun_voronoi(Senbun s0) {//0=変?Xなし?A1=?Fの変化のみ?A2=??分追加

        ori_v.addsenbun(s0);//ori_vのsenbunの?ﾅ後にs0の?﨣ﾁえるだけ
        int sousuu_old = ori_v.getsousuu();
        ori_v.Senbun_en_kouten(ori_v.getsousuu(), ori_v.getsousuu(), 1, ori_v.cir_size());

        ori_v.kousabunkatu(1, sousuu_old - 1, sousuu_old, sousuu_old);

        return 1;
    }


    // -----------------------------------------------------------------------------
    //マウス操??(i_mouse_modeA==62ボ??ノイ?@でドラッグしたとき)を?sう関??----------------------------------------------------
    public void mDragged_A_62(Ten p0) {
    }

    // -----------------------------------------------------------------------------
    //マウス操??(i_mouse_modeA==62ボ??ノイ?@でボタンを離したとき)を?sう関??----------------------------------------------------
    public void mReleased_A_62(Ten p0) {
    }

    // ------------------------------------------
    public void voronoi_01() {//i=1からi_egaki_dankaiまでのs_step[i]と?Ai_egaki_dankai-1までのボ??ノイ?}からi_egaki_dankaiのボ??ノイ?}を???ｬ

        //i_egaki_dankai番目のボ??ノイ頂点とそれ以前のボ??ノイ頂点間の2等分??をori_vに追加

        for (int i_e_d = 1; i_e_d <= i_egaki_dankai - 1; i_e_d++) {
            addsenbun_voronoi(oc.nitoubunsen(s_step[i_e_d].geta(), s_step[i_egaki_dankai].geta(), 1000.0)); //kiroku();
        }

        //ボ??ノイに適?№ｷるか判定
        //ori_vの??分を?ﾅ?奄ﾉ全て非選択にする
        ori_v.unselect_all();


        //ボ??ノイに適?№ｵないものを選択?ﾔにする
        Senbun s_tem = new Senbun();
        for (int j = 1; j <= ori_v.getsousuu(); j++) {

            //System.out.println("ボ??ノイ j= "+j);
            s_tem.set(ori_v.get(j));//s_temとしてボ??ノイに適?№ｷるか判定

            //s_tenのa端とボ??ノイの各頂点との距離の?ﾅ短値v_min_aを??める
            double v_min_a = 1000000.0;
            for (int i = 1; i <= i_egaki_dankai; i++) {
                if (oc.kyori(s_step[i].geta(), s_tem.geta()) < v_min_a) {
                    v_min_a = oc.kyori(s_step[i].geta(), s_tem.geta());
                }
            }
            //System.out.println("v_min_a= "+v_min_a);
            //s_tenのb端とボ??ノイの各頂点との距離の?ﾅ短値v_min_bを??める
            double v_min_b = 1000000.0;
            for (int i = 1; i <= i_egaki_dankai; i++) {
                if (oc.kyori(s_step[i].geta(), s_tem.getb()) < v_min_b) {
                    v_min_b = oc.kyori(s_step[i].geta(), s_tem.getb());
                }
            }
            //System.out.println("v_min_b= "+v_min_b);


            int a_tomo_b_tomo_mottomo_tikai_voronoi_tyouten_no_kazu = 0;//aともbとも?ﾅも近いボ??ノイ頂点の???@これが２なら対?ﾛ??分はボ??ノイ?}として残す
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


        //選択?ﾔのものを????
        ori_v.del_selected_senbun_hayai();

        ori_v.del_V_all(); //この?sはいらないかも


    }


//------------------------------

    public void voronoi_02_01(int tyuusinn_ten_bangou, Senbun add_senbun) {
        //i_egaki_dankai番目のボ??ノイ頂点は?@?@s_step[i_egaki_dankai].geta()?@?@?@

        //System.out.println("(0a)_add_senbun.getiactive()   = "+add_senbun.getiactive());
        //加える??分について?ｮ??
        //Senbun add_senbun =new Senbun();
        //add_senbun.set(oc.nitoubunsen(s_step[i_e_d].geta(),s_step[i_egaki_dankai].geta(),1000.0));
        Tyokusen add_tyokusen = new Tyokusen(add_senbun);


        int i_saisyo = Senb_boro_1p.size() - 1;
        for (int i = i_saisyo; i >= 0; i--) {
            //既存の??分について?ｮ??
            Senbun kizon_senbun = new Senbun();
            kizon_senbun.set((Senbun) Senb_boro_1p.get(i));
            Tyokusen kizon_tyokusen = new Tyokusen(kizon_senbun);


            //加える??分と既存の??分を?墲墲ｹる

//add_tyokusen.hyouji("     途中?@add_tyokusen :");
//kizon_tyokusen.hyouji("     途中?@kizon_tyokusen :");

            int i_heikou = oc.heikou_hantei(add_tyokusen, kizon_tyokusen, 0.0001);//0=平?sでない?A1=平?sで２直??が一致しない?A2=平?sで２直??が一致する


            if (i_heikou == 0) {//加える??分と既存の??分が非平?sの????
//System.out.println("     途中_加える??分と既存の??分が非平?s");
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


            } else if (i_heikou == 1) {//加える??分と既存の??分が平?sで２直??が一致しない????
//System.out.println("     途中_加える??分と既存の??分が平?sで２直??が一致しない");
                if (add_tyokusen.onajigawa(s_step[tyuusinn_ten_bangou].geta(), kizon_senbun.geta()) == -1) {
                    Senb_boro_1p.remove(i);
                } else if (kizon_tyokusen.onajigawa(s_step[tyuusinn_ten_bangou].geta(), add_senbun.geta()) == -1) {
                    return;
                }


            } else if (i_heikou == 2) {//加える??分と既存の??分が平?sで２直??が一致する????
//System.out.println("     途中_加える??分と既存の??分が平?sで２直??が一致する");
                return;
            }


            //if(add_tyokusen.senbun_kousa_hantei_kuwasii(senbun_b1p)==0){
            //if(add_tyokusen.senbun_kousa_hantei_kuwasii(new Senbun(s_step[i_egaki_dankai].geta(),senbun_b1p.geta()))==1){
            //	Senb_boro_1p.remove(i);
            //}
            //}


        }
        //System.out.println("  i_e_d="+i_e_d);
        //add_senbun.hyouji("voronoi_02_01_  add_senbun _?ﾅ?I");
        //System.out.println("(0b)_add_senbun.getiactive()   = "+add_senbun.getiactive());
        Senb_boro_1p.add(add_senbun);


    }


    // -----------------------------------------------

    public void Senb_boro_1p_motome(int tyuusinn_ten_bangou) {//s_stepがボ??ノイ母点だけを含む???№ﾉ使える?Btyuusinn_ten_bangouの周りのボ??ノイ??分の?W?№ﾆしてSenb_boro_1pを得る
        //i_egaki_dankai番目のボ??ノイ頂点を取り囲むボ??ノイ??分のアレイリストを得る?B//i_egaki_dankai番目のボ??ノイ頂点は?@?@s_step[i_egaki_dankai].geta()?@?@?@
        Senb_boro_1p.clear();

        //System.out.println("i_egaki_dankai="+i_egaki_dankai);

        for (int i_e_d = 1; i_e_d <= i_egaki_dankai; i_e_d++) {
            if (i_e_d != tyuusinn_ten_bangou) {

                //加える??分を??める
                Senbun add_senbun = new Senbun();

                add_senbun.set(oc.nitoubunsen(s_step[i_e_d].geta(), s_step[tyuusinn_ten_bangou].geta(), 1000.0));

                if (i_e_d < tyuusinn_ten_bangou) {
                    add_senbun.setiactive(i_e_d);
                    add_senbun.setcolor(tyuusinn_ten_bangou);//ボ??ノイ??分の2つのボ??ノイ頂点はiactiveとcolorに記録する
                } else {
                    add_senbun.setiactive(tyuusinn_ten_bangou);
                    add_senbun.setcolor(i_e_d);//ボ??ノイ??分の2つのボ??ノイ頂点はiactiveとcolorに記録する
                }
                voronoi_02_01(tyuusinn_ten_bangou, add_senbun);

            }
        }


/*
		//できたSenb_boro_1pの表示
		oc.hyouji("-----できたSenb_boro_1pの表示-----");
		for (int i=0; i<Senb_boro_1p.size(); i++ ){
			Senbun tempS=new Senbun();tempS.set((Senbun)Senb_boro_1p.get(i));
			tempS.hyouji("   ");
		}
*/


    }

    // --------------------------------------------

    public void voronoi_02() {//i=1からi_egaki_dankaiまでのs_step[i]と?Ai_egaki_dankai-1までのボ??ノイ?}からi_egaki_dankaiのボ??ノイ?}を???ｬ

        //i_egaki_dankai番目のボ??ノイ頂点を取り囲むボ??ノイ??分のアレイリストを得る?B
        Senb_boro_1p_motome(i_egaki_dankai);

        //20181109ここでori_v.の既存のボ??ノイ??分の?ｮ??が必要

        //ori_vの??分を?ﾅ?奄ﾉ全て非選択にする
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

                int i_mae = s_mae.getiactive();//この???㌍activeには?Aそのボ??ノイ??分を加えたときの既存側のボ??ノイ母点の番??が入っている?B
                int i_ato = s_ato.getiactive();//この???㌍activeには?Aそのボ??ノイ??分を加えたときの既存側のボ??ノイ母点の番??が入っている?B


                if (i_mae > i_ato) {
                    int i_temp = i_mae;
                    i_mae = i_ato;
                    i_ato = i_temp;
                }

                //System.out.println("(1) i_mae=" +i_mae +" :  i_ato=" +i_ato);

                //?Vしいボ??ノイ母点を加えることでできる周囲のボ??ノイ??分が??まっている?Bこのボ??ノイ??分の多角形を?Vセルということにする?B
                //?Vセルをori_vに加える前に?A?Vセルの内部に入り?桙ﾅいるori_vの既存??分がないように????をする?B

                //20181109ここでori_v.の既存のボ??ノイ??分(iactive()が必ずicolorより?ｬさくなっている)を探す
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


//20181110ここポイント
//
//	-1		0		1
//-1 	何もせず	何もせず	交点まで?k?ｬ
// 0	何もせず	有り得ない	????
// 1	交点まで?k?ｬ	????		????
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
        //選択?ﾔのものを????
        ori_v.del_selected_senbun_hayai();

        ori_v.del_V_all(); //この?sはいらないかも
        //for (int i=1; i<=ori_v.getsousuu(); i++ ){System.out.println("    (2)  i= " + i +  ":  ori_v.get(i).getiactive()=  " +  ori_v.get(i).getiactive());}
        //


        //ori_vのsenbunの?ﾅ後にSenb_boro_1pの??分ををを加える
        for (int i = 0; i < Senb_boro_1p.size(); i++) {
            Senbun add_S = new Senbun();
            add_S.set((Senbun) Senb_boro_1p.get(i));
            //System.out.println("  add_S.getiactive()=" +add_S.getiactive());
            ori_v.addsenbun((Senbun) Senb_boro_1p.get(i));
            //System.out.println("  ori_v.get(ori_v.getsousuu()).getiactive()=" +ori_v.get(ori_v.getsousuu()).getiactive());

        }


        //for (int i=1; i<=ori_v.getsousuu(); i++ ){System.out.println("    (3)  i= " + i +  ":  ori_v.get(i).getiactive()=  " +  ori_v.get(i).getiactive());}


    }


    //-----------------------------------------------62ここまで?@//20181121?@iactiveをtppに置き換える


//5555555555555555555555    i_mouse_modeA==5?@;??分延長モ?[ド

    //マウス操??(マウスを動かしたとき)を?sう関??    //System.out.println("_");
    public void mMoved_A_05(Ten p0) {
        if (i_kou_mitudo_nyuuryoku == 10) {// ==10ということは実?sしないということ
            s_kouho[1].setiactive(3);

            i_kouho_dankai = 0;
            //Ten p =new Ten();
            p.set(camera.TV2object(p0));

            moyori_senbun.set(get_moyori_senbun(p));
            if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {//?ﾅ寄の既存?ﾜ??が近い????
                i_kouho_dankai = 1;
                s_kouho[1].set(moyori_senbun);
                //s_kouho[1].setcolor(8);

                return;
            }


        }
    }


    //マウス操??(ボタンを押したとき)時の??業
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

                if ((oc.heikou_hantei(s_step[1], moyori_senbun, 0.000001) == 0) ||  //２つの??分が平?sかどうかを判定する関???Boc.heikou_hantei(Tyokusen t1,Tyokusen t2)//0=平?sでない
                        ((oc.senbun_kousa_hantei(s_step[1], moyori_senbun, 0.000001, 0.000001) == 31) && (i_orikaesi == 1))) {  //?ﾅ?奄ﾉ選んだ??分と2番目に選んだ??分が同じならoc.senbun_kousa_hantei==31
                    i_egaki_dankai = i_egaki_dankai + 1;
                    s_step[i_egaki_dankai].set(moyori_senbun);//s_step[i_egaki_dankai].setcolor(i_egaki_dankai);
                    s_step[i_egaki_dankai].setcolor(6);
                    return;
                }
            }
        }

    }


    //マウス操??(ドラッグしたとき)を?sう関??
    public void mDragged_A_05(Ten p0) {
    }

    //マウス操??(ボタンを離したとき)を?sう関??
    public void mReleased_A_05(Ten p0) {
        if (i_egaki_dankai == 2) {

            i_egaki_dankai = 0;

            Senbun add_sen = new Senbun();

            if (oc.heikou_hantei(s_step[1], moyori_senbun, 0.000001) == 0) { //２つの??分が平?sかどうかを判定する関???Boc.heikou_hantei(Tyokusen t1,Tyokusen t2)//0=平?sでない
                //s_step[1]とs_step[2]の交点はoc.kouten_motome(Senbun s1,Senbun s2)で??める//２つの??分を直??とみなして交点を??める関???B??分としては交?ｷしなくても?A直??として交?ｷしている???№ﾌ交点を返す
                Ten kousa_ten = new Ten();
                kousa_ten.set(oc.kouten_motome(s_step[1], s_step[2]));
                //Senbun.get_tikai_hasi(Ten p){//点Pと近いほうの端点を返す
                //s_step[1].get_tikai_hasi(kousa_ten);

                add_sen = new Senbun(kousa_ten, s_step[1].get_tikai_hasi(kousa_ten));
            }

            if ((oc.senbun_kousa_hantei(s_step[1], moyori_senbun, 0.000001, 0.000001) == 31) && (i_orikaesi == 1)) {  //?ﾅ?奄ﾉ選んだ??分と2番目に選んだ??分が同じならoc.senbun_kousa_hantei==31
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


//7777777777777777777    i_mouse_modeA==7;角二等分??モ?[ド?@

    //マウス操??(マウスを動かしたとき)を?sう関??
    public void mMoved_A_07(Ten p0) {
        if ((i_egaki_dankai >= 0) && (i_egaki_dankai <= 2)) {
            mMoved_A_29(p0);//近い既存点のみ表示
        }

    }

    //マウス操??(ボタンを押したとき)時の??業
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

    //マウス操??(ドラッグしたとき)を?sう関??
    public void mDragged_A_07(Ten p0) {
    }

    //マウス操??(ボタンを離したとき)を?sう関??
    public void mReleased_A_07(Ten p0) {
        if (i_egaki_dankai == 4) {
            i_egaki_dankai = 0;

            i_egaki_dankai = 0;

            //三角形の内?Sを??める	public Ten oc.naisin(Ten ta,Ten tb,Ten tc)
            Ten naisin = new Ten();
            naisin.set(oc.naisin(s_step[1].geta(), s_step[2].geta(), s_step[3].geta()));


            Senbun add_sen2 = new Senbun(s_step[2].geta(), naisin);


            //add_sen2とs_step[4]の交点はoc.kouten_motome(Senbun s1,Senbun s2)で??める//２つの??分を直??とみなして交点を??める関???B??分としては交?ｷしなくても?A直??として交?ｷしている???№ﾌ交点を返す
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


//88888888888888888888888    i_mouse_modeA==8?@;内?Sモ?[ド?B

    //マウス操??(マウスを動かしたとき)を?sう関??
    public void mMoved_A_08(Ten p0) {
        mMoved_A_29(p0);
    }//近い既存点のみ表示

    //マウス操??(ボタンを押したとき)時の??業
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

    //マウス操??(ドラッグしたとき)を?sう関??
    public void mDragged_A_08(Ten p0) {
    }

    //マウス操??(ボタンを離したとき)を?sう関??
    public void mReleased_A_08(Ten p0) {
        if (i_egaki_dankai == 3) {
            i_egaki_dankai = 0;

            //三角形の内?Sを??める	public Ten oc.naisin(Ten ta,Ten tb,Ten tc)
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


    //53 53 53 53 53 53 53 53 53    i_mouse_modeA==53?@;長さ測定１モ?[ド?B
    //マウス操??(マウスを動かしたとき)を?sう関??
    public void mMoved_A_53(Ten p0) {
        mMoved_A_29(p0);
    }//近い既存点のみ表示

    //マウス操??(ボタンを押したとき)時の??業
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

    //マウス操??(ドラッグしたとき)を?sう関??
    public void mDragged_A_53(Ten p0) {
    }

    //マウス操??(ボタンを離したとき)を?sう関??
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
//54 54 54 54 54 54 54 54 54    i_mouse_modeA==54?@;長さ測定2モ?[ド?B
    //マウス操??(マウスを動かしたとき)を?sう関??
    public void mMoved_A_54(Ten p0) {
        mMoved_A_29(p0);
    }//近い既存点のみ表示

    //マウス操??(ボタンを押したとき)時の??業
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

    //マウス操??(ドラッグしたとき)を?sう関??
    public void mDragged_A_54(Ten p0) {
    }

    //マウス操??(ボタンを離したとき)を?sう関??
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
//55 55 55 55 55 55 55 55 55    i_mouse_modeA==55?@;角度測定1モ?[ド?B
    //マウス操??(マウスを動かしたとき)を?sう関??
    public void mMoved_A_55(Ten p0) {
        mMoved_A_29(p0);
    }//近い既存点のみ表示

    //マウス操??(ボタンを押したとき)時の??業
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

    //マウス操??(ドラッグしたとき)を?sう関??
    public void mDragged_A_55(Ten p0) {
    }

    //マウス操??(ボタンを離したとき)を?sう関??
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
//56 56 56 56 56 56 56 56 56    i_mouse_modeA==56?@;角度測定2モ?[ド?B
    //マウス操??(マウスを動かしたとき)を?sう関??
    public void mMoved_A_56(Ten p0) {
        mMoved_A_29(p0);
    }//近い既存点のみ表示

    //マウス操??(ボタンを押したとき)時の??業
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

    //マウス操??(ドラッグしたとき)を?sう関??
    public void mDragged_A_56(Ten p0) {
    }

    //マウス操??(ボタンを離したとき)を?sう関??
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
//57 57 57 57 57 57 57 57 57    i_mouse_modeA==57?@;角度測定3モ?[ド?B
    //マウス操??(マウスを動かしたとき)を?sう関??
    public void mMoved_A_57(Ten p0) {
        mMoved_A_29(p0);
    }//近い既存点のみ表示

    //マウス操??(ボタンを押したとき)時の??業
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

    //マウス操??(ドラッグしたとき)を?sう関??
    public void mDragged_A_57(Ten p0) {
    }

    //マウス操??(ボタンを離したとき)を?sう関??
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


//999999999999999999    i_mouse_modeA==9?@;????おろしモ?[ド

    //マウス操??(マウスを動かしたとき)を?sう関??
    public void mMoved_A_09(Ten p0) {
        if (i_egaki_dankai == 0) {
            mMoved_A_29(p0);//近い既存点のみ表示
        }

    }


    //マウス操??(ボタンを押したとき)時の??業
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

    //マウス操??(ドラッグしたとき)を?sう関??
    public void mDragged_A_09(Ten p0) {
    }

    //マウス操??(ボタンを離したとき)を?sう関??
    public void mReleased_A_09(Ten p0) {
        if (i_egaki_dankai == 2) {
            i_egaki_dankai = 0;
            //直??t?繧ﾌ点pの影の位置?i点pと?ﾅも近い直??t?繧ﾌ位置?jを??める?Bpublic Ten oc.kage_motome(Tyokusen t,Ten p){
            //oc.Senbun2Tyokusen(Senbun s)//??分を含む直??を得る

            Senbun add_sen = new Senbun(s_step[1].geta(), oc.kage_motome(oc.Senbun2Tyokusen(s_step[2]), s_step[1].geta()), icol);
            if (add_sen.getnagasa() > 0.00000001) {
                addsenbun(add_sen);
                kiroku();
            }


        }
    }
//------
//------
//40 40 40 40 40 40     i_mouse_modeA==40?@;平?s??入力モ?[ド

    //マウス操??(マウスを動かしたとき)を?sう関??
    public void mMoved_A_40(Ten p0) {
        if (i_egaki_dankai == 0) {
            mMoved_A_29(p0);//近い既存点のみ表示
        }

    }


    //マウス操??(ボタンを押したとき)時の??業
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

    //マウス操??(ドラッグしたとき)を?sう関??
    public void mDragged_A_40(Ten p0) {
    }

    //マウス操??(ボタンを離したとき)を?sう関??
    public void mReleased_A_40(Ten p0) {
        if (i_egaki_dankai == 3) {
            i_egaki_dankai = 0;
            //s_step[1]を点?ｩら?As_step[2]に平?sな??分にする?B
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
    //i_egaki_dankaiがi_e_dのときに?A??分s_oをTen aはそのままで?ATen b側をs_kの交点までのばした一時?ﾜ??s_step[i_e_d+1](?Fはicolo)を追加?B?ｬ功した???№ﾍ1?Aなんらかの不都?№ﾅ追加できなかった???№ﾍ-500を返す?B
    public int s_step_tuika_koutenmade(int i_e_d, Senbun s_o, Senbun s_k, int icolo) {

        Ten kousa_ten = new Ten();

        if (oc.heikou_hantei(s_o, s_k, 0.0000001) == 1) {//0=平?sでない?A1=平?sで２直??が一致しない?A2=平?sで２直??が一致する
            return -500;
        }

        if (oc.heikou_hantei(s_o, s_k, 0.0000001) == 2) {//0=平?sでない?A1=平?sで２直??が一致しない?A2=平?sで２直??が一致する
            kousa_ten.set(s_k.geta());
            if (oc.kyori(s_o.geta(), s_k.geta()) > oc.kyori(s_o.geta(), s_k.getb())) {
                kousa_ten.set(s_k.getb());
            }


        }

        if (oc.heikou_hantei(s_o, s_k, 0.0000001) == 0) {//0=平?sでない?A1=平?sで２直??が一致しない?A2=平?sで２直??が一致する
            kousa_ten.set(oc.kouten_motome(s_o, s_k));
        }


        Senbun add_sen = new Senbun(kousa_ten, s_o.geta(), icolo);

        if (add_sen.getnagasa() > 0.00000001) {
            s_step[i_e_d + 1].set(add_sen);
            return 1;
        }
        return -500;
    }


//10 10 10 10 10    i_mouse_modeA==10?@;?ﾜり返しモ?[ド

    //マウス操??(マウスを動かしたとき)を?sう関??
    public void mMoved_A_10(Ten p0) {
        mMoved_A_29(p0);
    }//近い既存点のみ表示

    //マウス操??(ボタンを押したとき)時の??業
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

    //マウス操??(ドラッグしたとき)を?sう関??
    public void mDragged_A_10(Ten p0) {
    }

    //マウス操??(ボタンを離したとき)を?sう関??
    public void mReleased_A_10(Ten p0) {
        if (i_egaki_dankai == 3) {
            i_egaki_dankai = 0;

            //２つの点t1,t2を通る直??に関して?A点pの対?ﾆ位置にある点を??める public Ten oc.sentaisyou_ten_motome(Ten t1,Ten t2,Ten p){
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


//52 52 52 52 52    i_mouse_modeA==52?@;連続?ﾜり返しモ?[ド ****************************************

    //マウス操??(マウスを動かしたとき)を?sう関??
    public void mMoved_A_52(Ten p0) {
        mMoved_A_29(p0);
    }//近い既存点のみ表示

    //マウス操??(ボタンを押したとき)時の??業
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

    //マウス操??(ドラッグしたとき)を?sう関??
    public void mDragged_A_52(Ten p0) {
    }

    //マウス操??(ボタンを離したとき)を?sう関??
    public void mReleased_A_52(Ten p0) {
        if (i_egaki_dankai == 2) {
            i_egaki_dankai = 0;

            //２つの点t1,t2を通る直??に関して?A点pの対?ﾆ位置にある点を??める public Ten oc.sentaisyou_ten_motome(Ten t1,Ten t2,Ten p){
            Ten t_taisyou = new Ten();
            t_taisyou.set(oc.sentaisyou_ten_motome(s_step[2].geta(), s_step[3].geta(), s_step[1].geta()));
            Senbun add_senbun = new Senbun();
            renzoku_orikaesi(s_step[1].geta(), s_step[2].geta());
            for (int i = 1; i <= i_egaki_dankai; i++) {

                if (s_step[i].getnagasa() > 0.00000001) {

                    add_senbun.set(s_step[i].geta(), s_step[i].getb());//要??意?@s_stepは表示?繧ﾌ都?№ﾅアクティヴが0以外に?ﾝ定されているのでadd_senbunにうつしかえてる20170507
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

        //与えられたベクトルabを延長して?Aそれと?dならない?ﾜ??との?A?ﾅも近い交点までs_stepとする
        if (e_s_dougubako.get_kousaten_made_nobasi_flg(a, b) == 0) {
            return;
        }
        //if(e_s_dougubako.get_kousaten_made_nobasi_orisen_fukumu_flg(a,b)==3){return;}

        i_egaki_dankai = i_egaki_dankai + 1;
        if (i_egaki_dankai > 100) {
            return;
        }//念のためにs_stepの?繻ﾀを100に?ﾝ定した

        s_step[i_egaki_dankai].set(e_s_dougubako.get_kousaten_made_nobasi_senbun(a, b));//要??意?@es1でうっかりs_stepにset.(senbun)やるとアクティヴでないので表示が?ｬさくなる20170507
        s_step[i_egaki_dankai].setiactive(3);

        //??めた交点で?A次のベクトルを発?ｶする?B

        if (e_s_dougubako.get_kousaten_made_nobasi_flg(a, b) == 1) {
            Senbun kousaten_made_nobasi_saisyono_senbun = new Senbun();
            kousaten_made_nobasi_saisyono_senbun.set(e_s_dougubako.get_kousaten_made_nobasi_saisyono_senbun(a, b));

            Ten new_a = new Ten();
            new_a.set(e_s_dougubako.get_kousaten_made_nobasi_ten(a, b));
            Ten new_b = new Ten();
            new_b.set(oc.sentaisyou_ten_motome(kousaten_made_nobasi_saisyono_senbun.geta(), kousaten_made_nobasi_saisyono_senbun.getb(), a));//２つの点t1,t2を通る直??に関して?A点pの対?ﾆ位置にある点を??める public Ten oc.sentaisyou_ten_motome(Ten t1,Ten t2,Ten p){

            renzoku_orikaesi(new_a, new_b);
            return;
        }

        return;
    }
// ------------------------------------------------------------


//--------------------------------------------
//27 27 27 27 27 27 27 27  i_mouse_modeA==27??分分割	入力 27 27 27 27 27 27 27 27
    //動??概要?@
    //i_mouse_modeA==1と??分分割以外は同じ?@
    //

    //マウス操??(マウスを動かしたとき)を?sう関??
    public void mMoved_A_27(Ten p0) {
        mMoved_m_00a(p0, icol);//マウスで選択できる候補点を表示する?B近くに既?ｬの点があるときはその点?A無いときはマウスの位置自?gが候補点となる?B
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

    //マウス操??(i_mouse_modeA==27??分入力?@でボタンを押したとき)時の??業----------------------------------------------------
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

    //マウス操??(i_mouse_modeA==27??分入力?@でドラッグしたとき)を?sう関??----------------------------------------------------
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

    //マウス操??(i_mouse_modeA==27??分入力?@でボタンを離したとき)を?sう関??----------------------------------------------------
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
//29 29 29 29 29 29 29 29  i_mouse_modeA==29?ｳ多角形入力	入力 29 29 29 29 29 29 29 29
    //動??概要?@
    //i_mouse_modeA==1と??分分割以外は同じ?@
    //

    //マウス操??(マウスを動かしたとき)を?sう関??
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

    //マウス操??(i_mouse_modeA==29?ｳ多角形入力?@でボタンを押したとき)時の??業----------------------------------------------------
    public void mPressed_A_29(Ten p0) {
        s_step[1].setiactive(3);

        p.set(camera.TV2object(p0));

        if (i_egaki_dankai == 0) {    //第1段階として?A点を選択
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(5);
            }
            return;
        }

        if (i_egaki_dankai == 1) {    //第2段階として?A点を選択
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

    //マウス操??(i_mouse_modeA==29?ｳ多角形入力?@でドラッグしたとき)を?sう関??----------------------------------------------------
    public void mDragged_A_29(Ten p0) {
    }

    //マウス操??(i_mouse_modeA==29?ｳ多角形入力?@でボタンを離したとき)を?sう関??----------------------------------------------------
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


    //37 37 37 37 37 37 37 37 37 37 37;角度規格化
    //マウス操??(マウスを動かしたとき)を?sう関??
    public void mMoved_A_37(Ten p0) {
        mMoved_A_29(p0);
    }//近い既存点のみ表示

    //マウス操??(i_mouse_modeA==37?@でボタンを押したとき)時の??業-------//System.out.println("A");---------------------------------------------
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

        s_step[2].set(s_step[1]);//ここではs_step[2]は表示されない?A計算用の??分
    }

    //マウス操??(i_mouse_modeA==37?@でドラッグしたとき)を?sう関??--------------//System.out.println("A");--------------------------------------
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


    //マウス操??(i_mouse_modeA==37?@でボタンを離したとき)を?sう関??----------------------------------------------------
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
            jk[0] = oc.kakudo(s_step[2]);//マウスで入力した??分がX軸となす角度
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
        if ((zure_flg == 0) && (syuusei_ten.kyori(moyori_ten) <= d_hantei_haba)) {//?ﾅ寄点が角度系にのっていて?A?C?ｳ点とも近い????
            return moyori_ten;
        }
        return syuusei_ten;
    }


// 19 19 19 19 19 19 19 19 19 select 選択

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

        i_egaki_dankai = 4;//s_step[4]まで描画するために?Aこの?sが必要

    }


//------------------------------------------------------------
// 19 19 19 19 19 19 19 19 19 select 選択


    int i_select_mode = 0;//=0は通?墲ﾌセレクト操??

    //マウス操??(i_mouse_modeA==19  select?@でボタンを押したとき)時の??業----------------------------------------------------
    public void mPressed_A_19(Ten p0) {
        System.out.println("19  select_");
        System.out.println("i_egaki_dankai=" + i_egaki_dankai);

        if (i_egaki_dankai == 0) {//i_select_modeを決める
            //Ten p =new Ten();
            p.set(camera.TV2object(p0));
            moyori_ten.set(get_moyori_ten_orisen_en(p));//この?ﾅ寄点は格子点は対?ﾛとしない
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                i_select_mode = 0;
                if (ori_s.tyouten_syuui_sensuu_select(p, 0.0001) > 0) {
                    i_select_mode = orihime_ap.i_sel_mou_mode;//=1はmove?A=2はmove4p?A=3はcopy?A=4はcopy4p?A=5は鏡映像
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
            mPressed_A_12(p0);//鏡映
        }
    }


    //マウス操??(i_mouse_modeA==19 select?@でドラッグしたとき)を?sう関??----------------------------------------------------
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
            mDragged_A_12(p0);//鏡映
        }


    }


    //マウス操??(i_mouse_modeA==19 select?@でボタンを離したとき)を?sう関??----------------------------------------------------
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
            mReleased_A_12(p0);//鏡映
        }


    }


//------------------------------------------------------------


    public void mReleased_A_box_select(Ten p0) {
        i_egaki_dankai = 0;

        select(p19_1, p0);
        if (p19_1.kyori(p0) <= 0.000001) {
            p.set(camera.TV2object(p0));
            if (ori_s.mottomo_tikai_senbun_kyori(p) < d_hantei_haba) {//点pに?ﾅも近い??分の番??での?Aその距離を返す	public double mottomo_tikai_senbun_kyori(Ten p)
                ori_s.select(ori_s.mottomo_tikai_senbun_sagasi(p));
            }
        }

    }

//20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20


    //マウス操??(i_mouse_modeA==19  select?@でボタンを押したとき)時の??業----------------------------------------------------
    public void mPressed_A_20(Ten p0) {
        mPressed_A_box_select(p0);
    }


    //マウス操??(i_mouse_modeA==19 select?@でドラッグしたとき)を?sう関??----------------------------------------------------
    public void mDragged_A_20(Ten p0) {
        mDragged_A_box_select(p0);
    }

    //マウス操??(i_mouse_modeA==20 select?@でボタンを離したとき)を?sう関??----------------------------------------------------
    public void mReleased_A_20(Ten p0) {

        i_egaki_dankai = 0;
        unselect(p19_1, p0);

        if (p19_1.kyori(p0) <= 0.000001) {
            //Ten p =new Ten();
            p.set(camera.TV2object(p0));
            if (ori_s.mottomo_tikai_senbun_kyori(p) < d_hantei_haba) {//点pに?ﾅも近い??分の番??での?Aその距離を返す	public double mottomo_tikai_senbun_kyori(Ten p)
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


//61 61 61 61 61 61 61 61 61 61 61 61 i_mouse_modeA==61//長方形内選択?ipaintの選択に似せた選択機能?jに使う
    //動??概要?@
    //マウスボタン押されたとき?@
    //用紙1/1分割時 		?ﾜ??の端点のみが基??点?B格子点が基??点になることはない?B
    //用紙1/2から1/512分割時	?ﾜ??の端点と用紙枠内?i-200.0,-200.0 _ 200.0,200.0)?jの格子点とが基??点
    //入力点Pが基??点から格子??kus.d_haba()の1/4より遠いときは?ﾜ???W?№ﾖの入力なし
    //??分が長さがなく1点?ﾌときは?ﾜ???W?№ﾖの入力なし

    //マウス操??(マウスを動かしたとき)を?sう関??
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


    //マウス操??(i_mouse_modeA==61?@長方形内選択でボタンを押したとき)時の??業----------------------------------------------------
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

    //マウス操??(i_mouse_modeA==61?@長方形内選択でドラッグしたとき)を?sう関??----------------------------------------------------
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

			s_step[1].set(p2,p3); //s_step[1]のb点は?ﾅ?奄ﾌ地点として変?Xできないので?A.set(p2,p3);とする必要がある?B
			s_step[2].set(p3,p4);
			s_step[3].set(p4,p1);
			s_step[4].set(p1,p2);

			s_step[1].setcolor(6);
			s_step[2].setcolor(6);
			s_step[3].setcolor(6);
			s_step[4].setcolor(6);
*/

    }


    //マウス操??(i_mouse_modeA==61 長方形内選択?@でボタンを離したとき)を?sう関??----------------------------------------------------
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

			s_step[1].set(p2,p3); //s_step[1]のb点は?ﾅ?奄ﾌ地点として変?Xできないので?A.set(p2,p3);とする必要がある?B
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


//22222222222222222222222222222222222222222222222222222222222222 展開?}移動


    //public void mPressed_A_02(Ten p0) {	}//マウス操??(i_mouse_modeA==2?@展開?}移動でボタンを押したとき)時の??業
    //public void mDragged_A_02(Ten p0) {	}//マウス操??(i_mouse_modeA==2?@展開?}移動でドラッグしたとき)を?sう関??
    //public void mReleased_A_02(Ten p0){	}//マウス操??(i_mouse_modeA==2?@展開?}移動でボタンを離したとき)を?sう関??

    //3 3 3 3 3 33333333333333333333333333333333333333333333333333333333
    //マウス操??(i_mouse_modeA==3,23 "??分????" でボタンを押したとき)時の??業----------------------------------------------------
    public void mPressed_A_03(Ten p0) {
        //System.out.println("(1)zzzzz ori_s.check4_size() = "+ori_s.check4_size());
        if (i_orisen_hojyosen == 0) {
            mPressed_A_box_select(p0);
        }//?ﾜ??の????
        if (i_orisen_hojyosen == 2) {
            mPressed_A_box_select(p0);
        }//?浮ﾌ?ﾜ??
        if (i_orisen_hojyosen == 3) {
            mPressed_A_box_select(p0);
        }//補?賦???

        if (i_orisen_hojyosen == 1) {
            mPressed_A_box_select(p0);
        }//補?賦G??

        if (i_orisen_hojyosen == 4) {
            mPressed_A_box_select(p0);
        }//?ﾜ??と補?賦???と補?賦G??
    }

    //マウス操??(i_mouse_modeA==3,23でドラッグしたとき)を?sう関??----------------------------------------------------
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

    //マウス操??(i_mouse_modeA==3,23 でボタンを離したとき)を?sう関??----------------------------------------------------
    public void mReleased_A_03(Ten p0) {//?ﾜ??と補?賦???と円
        //System.out.println("(3_1)zzzzz ori_s.check4_size() = "+ori_s.check4_size());
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        i_egaki_dankai = 0;

        //?ﾅ寄の一つを????
        if (p19_1.kyori(p0) <= 0.000001) {//?ﾅ寄の一つを????
            int i_sakujyo_mode = 10;//i_sakujyo_modeはここで定義?E?骭ｾしている
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
                rs_min = ori_s.mottomo_tikai_senbun_kyori(p);//点pに?ﾅも近い??分(?ﾜ??と補?賦???)の番??での?Aその距離を返す	public double mottomo_tikai_senbun_kyori(Ten p)

                double re_min;
                re_min = ori_s.mottomo_tikai_en_kyori(p);//点pに?ﾅも近い円の番??での?Aその距離を返す	public double mottomo_tikai_en_kyori(Ten p)

                double hoj_rs_min;
                hoj_rs_min = hoj_s.mottomo_tikai_senbun_kyori(p);//点pに?ﾅも近い補?賦G??の番??での?Aその距離を返す	public double mottomo_tikai_senbun_kyori(Ten p)

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


            if (i_sakujyo_mode == 0) { //?ﾜ??の????

                //Ten p =new Ten(); p.set(camera.TV2object(p0));
                double rs_min;
                rs_min = ori_s.mottomo_tikai_senbun_kyori(p);//点pに?ﾅも近い??分(?ﾜ??と補?賦???)の番??での?Aその距離を返す	public double mottomo_tikai_senbun_kyori(Ten p)
                if (rs_min < d_hantei_haba) {
                    if (ori_s.getcolor(ori_s.mottomo_tikai_senbun_sagasi_gyakujyun(p)) < 3) {
                        ori_s.delsenbun_vertex(ori_s.mottomo_tikai_senbun_sagasi_gyakujyun(p));
                        en_seiri();
                        kiroku();
                    }
                }

            }


            if (i_sakujyo_mode == 2) { //?浮ﾌ?ﾜ??の????

                //Ten p =new Ten(); p.set(camera.TV2object(p0));
                double rs_min;
                rs_min = ori_s.mottomo_tikai_senbun_kyori(p);//点pに?ﾅも近い??分(?ﾜ??と補?賦???)の番??での?Aその距離を返す	public double mottomo_tikai_senbun_kyori(Ten p)
                if (rs_min < d_hantei_haba) {
                    if (ori_s.getcolor(ori_s.mottomo_tikai_senbun_sagasi_gyakujyun(p)) == 0) {
                        ori_s.delsenbun_vertex(ori_s.mottomo_tikai_senbun_sagasi_gyakujyun(p));
                        en_seiri();
                        kiroku();
                    }
                }

            }

            if (i_sakujyo_mode == 3) {  //補?賦???
                //Ten p =new Ten(); p.set(camera.TV2object(p0));
                double rs_min;
                rs_min = ori_s.mottomo_tikai_senbun_kyori(p);//点pに?ﾅも近い??分(?ﾜ??と補?賦???)の番??での?Aその距離を返す
                double re_min;
                re_min = ori_s.mottomo_tikai_en_kyori(p);//点pに?ﾅも近い円の番??での?Aその距離を返す	public double mottomo_tikai_en_kyori(Ten p)


                if (rs_min <= re_min) {
                    if (rs_min < d_hantei_haba) {//点pに?ﾅも近い??分の番??での?Aその距離を返す	public double mottomo_tikai_senbun_kyori(Ten p)
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

            if (i_sakujyo_mode == 1) { //補?賦G??

                //Ten p =new Ten(); p.set(camera.TV2object(p0));
                double rs_min;
                rs_min = hoj_s.mottomo_tikai_senbun_kyori(p);//点pに?ﾅも近い補?賦G??の番??での?Aその距離を返す	public double mottomo_tikai_senbun_kyori(Ten p)

                if (rs_min < d_hantei_haba) {
                    hoj_s.delsenbun_vertex(hoj_s.mottomo_tikai_senbun_sagasi_gyakujyun(p));
                    //en_seiri();
                    kiroku();
                }

            }


        }


        //四角枠内の???? //p19_1はselectの?ﾅ?奄ﾌTen?Bこの??は?ﾅ?奄ﾌTenと?ﾅ後の点が遠いので?A四角を発?ｶさせるということ?B
        if (p19_1.kyori(p0) > 0.000001) {
            if ((i_orisen_hojyosen == 0) || (i_orisen_hojyosen == 4)) { //?ﾜ??の????	//D_nisuru(p19_1,p0)で?ﾜ??だけが???怩ｳれる?B
                if (D_nisuru0(p19_1, p0) != 0) {
                    en_seiri();
                    kiroku();
                }
            }


            if (i_orisen_hojyosen == 2) {  //?浮ﾌ?ﾜ??のみ????
                if (D_nisuru2(p19_1, p0) != 0) {
                    en_seiri();
                    kiroku();
                }
            }


            if ((i_orisen_hojyosen == 3) || (i_orisen_hojyosen == 4)) {  //補?賦???  //現?ﾅは???怩ｵないときもUNDO用に記録されてしまう20161218
                if (D_nisuru3(p19_1, p0) != 0) {
                    en_seiri();
                    kiroku();
                }
            }

            if ((i_orisen_hojyosen == 1) || (i_orisen_hojyosen == 4)) { //補?賦G??	//現?ﾅは???怩ｵないときもUNDO用に記録されてしまう20161218
                if (D_nisuru1(p19_1, p0) != 0) {
                    kiroku();
                }
            }

        }

//qqqqqqqqqqqqqqqqqqqqqqqqqqqqq//System.out.println("= ");qqqqq
//check4(0.0001);//D_nisuru0をすると?Aori_s.D_nisuru0内でresetが実?sされるため?Acheck4のやり直しが必要?B
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
    //マウス操??(i_mouse_modeA==59 "特??プ??パティ指定" でボタンを押したとき)時の??業----------------------------------------------------
    public void mPressed_A_59(Ten p0) {
        mPressed_A_box_select(p0);   //?ﾜ??と補?賦???と補?賦G??
    }

    //マウス操??(i_mouse_modeA==59 "特??プ??パティ指定"でドラッグしたとき)を?sう関??----------------------------------------------------
    public void mDragged_A_59(Ten p0) {
        mDragged_A_box_select(p0);
    }

    //マウス操??(i_mouse_modeA==59 "特??プ??パティ指定" でボタンを離したとき)を?sう関??----------------------------------------------------
    public void mReleased_A_59(Ten p0) {//補?賦???と円
        i_egaki_dankai = 0;
        if (p19_1.kyori(p0) > 0.000001) {//現?ﾅは???怩ｵないときもUNDO用に記録されてしまう20161218

            //if(D_nisuru3(p19_1,p0)!=0){en_seiri();kiroku();}
            if (chenge_property_in_4kakukei(p19_1, p0) != 0) {
                //kiroku();
            }

        }

        if (p19_1.kyori(p0) <= 0.000001) {
            //Ten p =new Ten();
            p.set(camera.TV2object(p0));
            double rs_min;
            rs_min = ori_s.mottomo_tikai_senbun_kyori(p);//点pに?ﾅも近い補?賦???の番??での?Aその距離を返す
            double re_min;
            re_min = ori_s.mottomo_tikai_en_kyori(p);//点pに?ﾅも近い円の番??での?Aその距離を返す	public double mottomo_tikai_en_kyori(Ten p)


            if (rs_min <= re_min) {
                if (rs_min < d_hantei_haba) {//点pに?ﾅも近い??分の番??での?Aその距離を返す	public double mottomo_tikai_senbun_kyori(Ten p)
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
    }//マウス操??(i_mouse_modeA==4??_変換?@でボタンを押したとき)時の??業

    public void mDragged_A_04(Ten p0) {
    }//マウス操??(i_mouse_modeA==4??_変換?@でドラッグしたとき)を?sう関??

    //マウス操??(i_mouse_modeA==4??_変換?@でボタンを離したとき)を?sう関??
    public void mReleased_A_04(Ten p0) {
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));


        if (ori_s.mottomo_tikai_senbun_kyori(p) < d_hantei_haba) {//点pに?ﾅも近い??分の番??での?Aその距離を返す	public double mottomo_tikai_senbun_kyori(Ten p)
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
    }//マウス操??(i_mouse_modeA==58??_変換?@でボタンを押したとき)時の??業

    public void mDragged_A_58(Ten p0) {
        mDragged_A_box_select(p0);
    }//マウス操??(i_mouse_modeA==58??_変換?@でドラッグしたとき)を?sう関??

    //マウス操??(i_mouse_modeA==58??_変換?@でボタンを離したとき)を?sう関??
    public void mReleased_A_58(Ten p0) {//ここの????の?Iわりに fix2(0.001,0.5);?@をするのは?A元から?ﾜ??だったものと?A補????から変換した?ﾜ??との組?№ｹで頻発するT字型不?ﾚ続を?C?ｳするため
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
            if (ori_s.mottomo_tikai_senbun_kyori(p) < d_hantei_haba) {//点pに?ﾅも近い??分の番??での?Aその距離を返す	public double mottomo_tikai_senbun_kyori(Ten p)
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


    //30 30 30 30 30 30 30 30 30 30 30 30 ?怩ｯ_??_変換
    int minrid_30;

    public void mPressed_A_30(Ten p0) {    //マウス操??(i_mouse_modeA==4??_変換?@でボタンを押したとき)時の??業
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        minrid_30 = -1;
        if (ori_s.mottomo_tikai_senbun_kyori(p) < d_hantei_haba) {//点pに?ﾅも近い??分の番??での?Aその距離を返す	public double mottomo_tikai_senbun_kyori(Ten p)
            minrid_30 = ori_s.mottomo_tikai_senbun_sagasi(p);
            Senbun s01 = new Senbun();
            s01.set(oc.Senbun_bai(ori_s.get(minrid_30), 0.01));
            ori_s.setb(minrid_30, s01.getb());
        }
    }

    public void mDragged_A_30(Ten p0) {//マウス操??(i_mouse_modeA==4??_変換?@でドラッグしたとき)を?sう関??
        if (minrid_30 > 0) {

            Senbun s01 = new Senbun();
            s01.set(oc.Senbun_bai(ori_s.get(minrid_30), 100.0));
            ori_s.setb(minrid_30, s01.getb());
            minrid_30 = -1;
        }

    }


    //マウス操??(i_mouse_modeA==30 ?怩ｯ_??_変換?@でボタンを離したとき)を?sう関???i背景に展開?}がある???∠p?j
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


//i_mouse_modeA;マウスの動??に対する反応を規定する?B
// -------------1;??分入力モ?[ド?B
//2;展開?}調?ｮ(移動)?B
//3;"L_del"
//4;"L_chan"

// -------------5;??分延長モ?[ド?B
// -------------6;2点から等距離??分モ?[ド?B
// -------------7;角二等分??モ?[ド?B
// -------------8;内?Sモ?[ド?B
// -------------9;????おろしモ?[ド?B
// -------------10;?ﾜり返しモ?[ド?B
// -------------11;??分入力モ?[ド?B
// -------------12;鏡映モ?[ド?B

//101:?ﾜり?繧ｪり?}の操???B
//102;F_move
//103;S_face

//10001;test1 入力??備として点を３つ指定する


//66666666666666666666    i_mouse_modeA==6?@;2点から等距離??分モ?[ド

    //マウス操??(ボタンを押したとき)時の??業
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

    //マウス操??(ドラッグしたとき)を?sう関??
    public void mDragged_A_06(Ten p0) {
    }

    //マウス操??(ボタンを離したとき)を?sう関??
    public void mReleased_A_06(Ten p0) {
        if (i_egaki_dankai == 3) {
            i_egaki_dankai = 0;
        }


    }

//------


//------?ﾜり?ﾝ可能??入力


//38 38 38 38 38 38 38    i_mouse_modeA==38?@;?ﾜり?ﾝ可能??入力  qqqqqqqqq


    int i_step_for38 = 0;

    //マウス操??(マウスを動かしたとき)を?sう関??    //System.out.println("_");
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
                if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {//?ﾅ寄の既存?ﾜ??が近い????
                    i_kouho_dankai = 1;
                    s_kouho[1].set(moyori_senbun);
                    //s_kouho[1].setcolor(2);
                    return;
                }

            }
        }
    }


    //Ten t1 =new Ten();
//マウス操??(ボタンを押したとき)時の??業
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
            t1.set(ori_s.mottomo_tikai_Ten_with_icol_0_1_2(p));//点pに?ﾅも近い?A?u??分の端点?vを返すori_s.mottomo_tikai_Tenは近い点がないと p_return.set(100000.0,100000.0)と返してくる

            if (p.kyori(t1) < d_hantei_haba) {
                //i_egaki_dankai=i_egaki_dankai+1;
                //s_step[i_egaki_dankai].set(moyori_ten,moyori_ten);s_step[i_egaki_dankai].setcolor(i_egaki_dankai);

                //t1を端点とする?ﾜ??をNarabebakoに入れる
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

                if (nbox.getsousuu() % 2 == 1) {//t1を端点とする?ﾜ??の?狽ｪ奇?狽ﾌときだけif{}内の????をする
                    icol_temp = icol;
                    if (nbox.getsousuu() == 1) {
                        icol_temp = ori_s.get(nbox.get_int(1)).getcolor();
                    }//20180503この?s追加?Bこれは?A?ﾜ??が1本だけの頂点から?ﾜり?ﾝ可能??追加機能で?Aその?ﾜ??の延長を?sった???№ﾉ?A??の?Fを延長前の?ﾜ??と?№墲ｹるため

                    //int i_kouho_suu=0;
                    for (int i = 1; i <= nbox.getsousuu(); i++) {//iは角加減値を??める?ﾅ?奄ﾌ?ﾜ??のid
                        //?ﾜ??が奇?狽ﾌ頂点周りの角加減値を2.0で割ると角加減値の?ﾅ???ﾜ??と?A?ﾜり?ﾝ可能にするための追加の?ﾜ??との角度になる?B
                        double kakukagenti = 0.0;
                        //System.out.println("nbox.getsousuu()="+nbox.getsousuu());
                        int tikai_orisen_jyunban;
                        int tooi_orisen_jyunban;
                        for (int k = 1; k <= nbox.getsousuu(); k++) {//kは角加減値を??める角度の?∑ﾔ
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
                        //チェック用に角加減値の?ﾅ?奄ﾌ角度の中にkakukagenti/2.0があるかを確認する
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

                            //??分abをaを中?Sにd度回転した??分を返す関???i元の??分は変えずに?Vしい??分を返す?jpublic oc.Senbun_kaiten(Senbun s0,double d)
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
            if (oc.kyori_senbun(p, moyori_senbun) >= d_hantei_haba) {//?ﾅ寄の既存?ﾜ??が遠くて選択無効の????
                //moyori_senbun.set(get_moyori_step_senbun(p,1,i_egaki_dankai));
                if (oc.kyori_senbun(p, moyori_step_senbun) < d_hantei_haba) {//?ﾅ寄のstep_senbunが近い????
//System.out.println("20170129_1");
                    return;
                }

                //?ﾅ寄のstep_senbunが遠い????
//System.out.println("20170129_2");

                i_egaki_dankai = 0;
                return;
            }

            if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {//?ﾅ寄の既存?ﾜ??が近い????

                s_step[2].set(moyori_senbun);
                s_step[2].setcolor(6);

//System.out.println("20170129_3");
                Ten kousa_ten = new Ten();
                kousa_ten.set(oc.kouten_motome(s_step[1], s_step[2]));
                Senbun add_sen = new Senbun(kousa_ten, s_step[1].geta(), icol_temp);//20180503変?X
                if (add_sen.getnagasa() > 0.00000001) {//?ﾅ寄の既存?ﾜ??が有効の????
                    addsenbun(add_sen);
                    kiroku();
                    i_egaki_dankai = 0;
                    return;

                }

                //?ﾅ寄の既存?ﾜ??が無効の????

                //?ﾅ寄のstep_senbunが近い????
                if (oc.kyori_senbun(p, moyori_step_senbun) < d_hantei_haba) {
                    return;
                }

                //?ﾅ寄のstep_senbunが遠い????
                i_egaki_dankai = 0;
                return;

            }
        }


    }

    //マウス操??(ドラッグしたとき)を?sう関??
    public void mDragged_A_38(Ten p0) {
    }

    //マウス操??(ボタンを離したとき)を?sう関??
    public void mReleased_A_38(Ten p0) {

    }


//------?ﾜり?ﾝ可能??+格子点系入力


    //39 39 39 39 39 39 39    i_mouse_modeA==39?@;?ﾜり?ﾝ可能??入力  qqqqqqqqq
    int i_step_for39 = 0;//i_step_for39=2の???№ﾍ?Astep??が1本だけになっていて?A次の操??で入力?ﾜ??が確定する?ﾔ
//
//課題?@step??と既存?ﾜ??が平?sの時エラ?[方向に??を引くことを改善すること20170407
//
//動??仕様
//?i１?j点を選択?i既存点選択規?ｧ?j
//?i２a?j選択点が3以?繧ﾌ奇???ﾜ??の頂点の????
//?i３?j
//
//
//?i２b?j２a以外の????
//
//Ten t1 =new Ten();


    //マウス操??(マウスを動かしたとき)を?sう関??    //System.out.println("_");
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
				//任意の点が与えられたとき?A端点もしくは格子点で?ﾅも近い点を得る
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


            if (i_step_for39 == 2) {//i_step_for39==2であれば?A以下でs_step[1]を入力?ﾜ??を確定する
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
                if (oc.kyori_senbun(p, moyori_senbun) >= d_hantei_haba) {//?ﾅ寄の既存?ﾜ??が遠い????
                    if (oc.kyori_senbun(p, moyori_step_senbun) < d_hantei_haba) {//?ﾅ寄のstep_senbunが近い????
                        return;
                    }
                    //?ﾅ寄のstep_senbunが遠い????
                    System.out.println("i_step_for39_2_   4");

                    return;
                }

                if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {//?ﾅ寄の既存?ﾜ??が近い????
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


    //マウス操??(ボタンを押したとき)時の??業--------------
    public void mPressed_A_39(Ten p0) {
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));

        if (i_egaki_dankai == 0) {
            i_step_for39 = 0;
        }


        //if(i_egaki_dankai==0){i_step_for39=0;}

        if (i_step_for39 == 0) {
            double hantei_kyori = 0.000001;

            //任意の点が与えられたとき?A端点もしくは格子点で?ﾅも近い点を得る
            moyori_ten.set(get_moyori_ten(p));

            if (p.kyori(moyori_ten) < d_hantei_haba) {
                //i_egaki_dankai=i_egaki_dankai+1;
                //s_step[i_egaki_dankai].set(moyori_ten,moyori_ten);s_step[i_egaki_dankai].setcolor(i_egaki_dankai);

                //moyori_tenを端点とする?ﾜ??をNarabebakoに入れる
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
                if (nbox.getsousuu() % 2 == 1) {//moyori_tenを端点とする?ﾜ??の?狽ｪ奇?狽ﾌときだけif{}内の????をする
                    //System.out.println("20170130_3");

                    //int i_kouho_suu=0;
                    for (int i = 1; i <= nbox.getsousuu(); i++) {//iは角加減値を??める?ﾅ?奄ﾌ?ﾜ??のid
                        //?ﾜ??が奇?狽ﾌ頂点周りの角加減値を2.0で割ると角加減値の?ﾅ???ﾜ??と?A?ﾜり?ﾝ可能にするための追加の?ﾜ??との角度になる?B
                        double kakukagenti = 0.0;
                        //System.out.println("nbox.getsousuu()="+nbox.getsousuu());
                        int tikai_orisen_jyunban;
                        int tooi_orisen_jyunban;
                        for (int k = 1; k <= nbox.getsousuu(); k++) {//kは角加減値を??める角度の?∑ﾔ
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
                        //チェック用に角加減値の?ﾅ?奄ﾌ角度の中にkakukagenti/2.0があるかを確認する
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

                            //??分abをaを中?Sにd度回転した??分を返す関???i元の??分は変えずに?Vしい??分を返す?jpublic oc.Senbun_kaiten(Senbun s0,double d)
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

                if (i_egaki_dankai == 0) {//?ﾜ?ﾝ可能化??がない????//System.out.println("_");
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


        if (i_step_for39 == 2) {//i_step_for39==2であれば?A以下でs_step[1]を入力?ﾜ??を確定する
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
            if (oc.kyori_senbun(p, moyori_senbun) >= d_hantei_haba) {//?ﾅ寄の既存?ﾜ??が遠い????
                //moyori_senbun.set(get_moyori_step_senbun(p,1,i_egaki_dankai));


                //moyori_ten.set(get_moyori_ten(p));if(p.kyori(moyori_ten)<d_hantei_haba){s_step[1].setb(moyori_ten);return;}
                //moyori_ten.set(ori_s.mottomo_tikai_Ten(p));if(p.kyori(moyori_ten)<d_hantei_haba){s_step[1].setb(moyori_ten);return;}


                if (oc.kyori_senbun(p, moyori_step_senbun) < d_hantei_haba) {//?ﾅ寄のstep_senbunが近い????

                    //moyori_ten.set(get_moyori_ten(p));if(p.kyori(moyori_ten)<d_hantei_haba){s_step[1].setb(moyori_ten);return;}


                    return;
                }
                //?ﾅ寄のstep_senbunが遠い????

                //moyori_ten.set(get_moyori_ten(p));if(p.kyori(moyori_ten)<d_hantei_haba){s_step[1].setb(moyori_ten);return;}
                i_egaki_dankai = 0;
                i_kouho_dankai = 0;
                return;
            }

            if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {//?ﾅ寄の既存?ﾜ??が近い????
                //moyori_ten.set(ori_s.mottomo_tikai_Ten(p));if(p.kyori(moyori_ten)<d_hantei_haba){s_step[1].setb(moyori_ten);return;}
                s_step[2].set(moyori_senbun);
                s_step[2].setcolor(6);
                //System.out.println("20170129_3");
                Ten kousa_ten = new Ten();
                kousa_ten.set(oc.kouten_motome(s_step[1], s_step[2]));
                Senbun add_sen = new Senbun(kousa_ten, s_step[1].geta(), icol);
                if (add_sen.getnagasa() > 0.00000001) {//?ﾅ寄の既存?ﾜ??が有効の????
                    addsenbun(add_sen);
                    kiroku();
                    i_egaki_dankai = 0;
                    i_kouho_dankai = 0;
                    return;
                }
                //?ﾅ寄の既存?ﾜ??が無効の????
                moyori_ten.set(get_moyori_ten(p));
                if (p.kyori(moyori_ten) < d_hantei_haba) {
                    s_step[1].setb(moyori_ten);
                    return;
                }
                //?ﾅ寄のstep_senbunが近い????
                if (oc.kyori_senbun(p, moyori_step_senbun) < d_hantei_haba) {
                    return;
                }
                //?ﾅ寄のstep_senbunが遠い????
                i_egaki_dankai = 0;
                i_kouho_dankai = 0;
                return;

            }
            return;
        }


    }

    //マウス操??(ドラッグしたとき)を?sう関??
    public void mDragged_A_39(Ten p0) {
    }

    //マウス操??(ボタンを離したとき)を?sう関??
    public void mReleased_A_39(Ten p0) {

    }


//33 33 33 33 33 33 33 33 33 33 33魚の??


    //マウス操??(マウスを動かしたとき)を?sう関??
    public void mMoved_A_33(Ten p0) {
        mMoved_A_11(p0);
    }//近い既存点のみ表示


    //マウス操??(i_mouse_modeA==33魚の???@でボタンを押したとき)時の??業----------------------------------------------------
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

    //マウス操??(i_mouse_modeA==33魚の???@でドラッグしたとき)を?sう関??----------------------------------------------------
    public void mDragged_A_33(Ten p0) {
        mDragged_A_11(p0);
    }

    //マウス操??(i_mouse_modeA==33魚の???@でボタンを離したとき)を?sう関??----------------------------------------------------
    public void mReleased_A_33(Ten p0) {
        if (i_egaki_dankai == 1) {
            i_egaki_dankai = 0;

            //s_step[1]を確定する
            //Ten p =new Ten();
            p.set(camera.TV2object(p0));
            moyori_ten.set(get_moyori_ten(p));
            s_step[1].seta(moyori_ten);
            //s_step[1]を確定?I了


            if (p.kyori(moyori_ten) <= d_hantei_haba) {  //マウスで指定した点が?A?ﾅ寄点と近かったときに実施
                if (s_step[1].getnagasa() > 0.00000001) {  //s_step[1]が?A??の時?i=点?ﾅはない時?jに実施
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

                }  //s_step[1]が?A??の時?i=点?ﾅはない時?jに実施は?Aここまで
            }  //マウスで指定した点が?A?ﾅ寄点と近かったときに実施は?Aここまで
        }
    }


//35 35 35 35 35 35 35 35 35 35 35複?ﾜり返し   入力した??分に?ﾚ?Gしている?ﾜ??を?ﾜり返し?@に使う

    //マウス操??(マウスを動かしたとき)を?sう関??
    public void mMoved_A_35(Ten p0) {
        mMoved_A_11(p0);
    }//近い既存点のみ表示


    //マウス操??(i_mouse_modeA==35?@でボタンを押したとき)時の??業----------------------------------------------------
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

    //マウス操??(i_mouse_modeA==35?@でドラッグしたとき)を?sう関??----------------------------------------------------

    public void mDragged_A_35(Ten p0) {
        mDragged_A_11(p0);
    }

/*	public void mDragged_A_35(Ten p0) {

		Ten p =new Ten(); p.set(camera.TV2object(p0));
		s_step[1].seta(p);

		//k.seta(ieda, p);
	}
*/

    //マウス操??(i_mouse_modeA==35?@でボタンを離したとき)を?sう関??----------------------------------------------------
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


                            //２つの点t1,t2を通る直??に関して?A点pの対?ﾆ位置にある点を??める public Ten oc.sentaisyou_ten_motome(Ten t1,Ten t2,Ten p){
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

    public Senbun kousatenmade(Senbun s0) {//s0を点aからb方向に?A他の?ﾜ??と交?ｷするところまで延長する?B?Vしい??分を返す//他の?ﾜ??と交?ｷしないなら?A同じ??分を返す
        Senbun add_sen = new Senbun();
        add_sen.set(s0);
        Ten kousa_ten = new Ten(1000000.0, 1000000.0); //この方法だと?Aエラ?[の原因になりうる?B本当なら全??分のx_max?Ay_max以?繧ﾌ点を取ればいい?B?｡後?C?ｳ予定20161120
        double kousa_ten_kyori = kousa_ten.kyori(add_sen.geta());


        Tyokusen tyoku1 = new Tyokusen(add_sen.geta(), add_sen.getb());
        int i_kousa_flg;
        for (int i = 1; i <= ori_s.getsousuu(); i++) {
            i_kousa_flg = tyoku1.senbun_kousa_hantei_kuwasii(ori_s.get(i));//0=この直??は与えられた??分と交?ｷしない?A1=X型で交?ｷする?A2=T型で交?ｷする?A3=??分は直??に含まれる?B

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

    public Senbun kousatenmade_2(Senbun s0) {//s0を点aからb方向に?A他の?ﾜ??と交?ｷするところまで延長する?B?Vしい??分を返す//他の?ﾜ??と交?ｷしないなら?A同じ??分を返す
        Senbun add_sen = new Senbun();
        add_sen.set(s0);
        //Senbun add_sen;add_sen=s0;


        Ten kousa_ten = new Ten(1000000.0, 1000000.0); //この方法だと?Aエラ?[の原因になりうる?B本当なら全??分のx_max?Ay_max以?繧ﾌ点を取ればいい?B?｡後?C?ｳ予定20161120
        double kousa_ten_kyori = kousa_ten.kyori(add_sen.geta());

        Tyokusen tyoku1 = new Tyokusen(add_sen.geta(), add_sen.getb());
        int i_kousa_flg;//元の??分を直??としたものと?A他の??分の交?ｷ?ﾔ
        int i_senbun_kousa_flg;//元の??分と?A他の??分の交?ｷ?ﾔ

        System.out.println("AAAAA_");
        for (int i = 1; i <= ori_s.getsousuu(); i++) {
            i_kousa_flg = tyoku1.senbun_kousa_hantei_kuwasii(ori_s.get(i));//0=この直??は与えられた??分と交?ｷしない?A1=X型で交?ｷする?A2=T型で交?ｷする?A3=??分は直??に含まれる?B

            //i_senbun_kousa_flg=oc.senbun_kousa_hantei_amai( add_sen,ori_s.get(i),0.00001,0.00001);//20180408なぜかこの?sの様にadd_senを使うと?Ai_senbun_kousa_flgがおかしくなる
            i_senbun_kousa_flg = oc.senbun_kousa_hantei_amai(s0, ori_s.get(i), 0.00001, 0.00001);//20180408なぜかこの?sの様にs0のままだと?Ai_senbun_kousa_flgがおかしくならない?B
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

    public int kouten_ari_nasi(Senbun s0) {//s0を点aからb方向に延長したら?A他の?ﾜ??と交?ｷするなら?A１しないなら０を返す?Ba店での交?ｷする??分は?Aこの関?狽ﾅは交?ｷなしになる?B
        Senbun add_sen = new Senbun();
        add_sen.set(s0);
        Ten kousa_ten = new Ten(1000000.0, 1000000.0); //この方法だと?Aエラ?[の原因になりうる?B本当なら全??分のx_max?Ay_max以?繧ﾌ点を取ればいい?B?｡後?C?ｳ予定20161120
        double kousa_ten_kyori = kousa_ten.kyori(add_sen.geta());


        Tyokusen tyoku1 = new Tyokusen(add_sen.geta(), add_sen.getb());
        int i_kousa_flg;
        for (int i = 1; i <= ori_s.getsousuu(); i++) {
            i_kousa_flg = tyoku1.senbun_kousa_hantei_kuwasii(ori_s.get(i));//0=この直??は与えられた??分と交?ｷしない?A1=X型で交?ｷする?A2=T型で交?ｷする?A3=??分は直??に含まれる?B

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


//21 21 21 21 21    i_mouse_modeA==21?@;移動モ?[ド

    //マウスを動かしたとき
    public void mMoved_A_21(Ten p0) {
        mMoved_m_00b(p0, 5);
    }//マウスで選択できる候補点を表示する?B近くに既?ｬの点があるときはその点?A無いときはマウスの位置自?gが候補点となる?B

    //マウスクリック----------------------------------------------------
    public void mPressed_A_21(Ten p0) {
        mPressed_m_00b(p0, 5);
    }

    //マウスドラッグ----------------------------------------------------
    public void mDragged_A_21(Ten p0) {
        mDragged_m_00b(p0, 5);
    }

    //マウスリリ?[ス----------------------------------------------------
    public void mReleased_A_21(Ten p0) {

        i_select_mode = 0;//  <-------20180919この?sはセレクトした??の端点を選ぶと?A移動とかコピ?[等をさせると判断するが?Aその操??が?Iわったときに必要だから追加した?B
/*
		i_egaki_dankai=0;
		p.set(camera.TV2object(p0));
		moyori_ten.set(get_moyori_ten(p));

		if(p.kyori(moyori_ten)<=d_hantei_haba){
			s_step[1].seta(moyori_ten);
			if(s_step[1].getnagasa()>0.00000001){
				//やりたい動??はここに?曹ｭ

				double addx,addy;
				addx=-s_step[1].getbx()+s_step[1].getax();
				addy=-s_step[1].getby()+s_step[1].getay();

				Orisensyuugou ori_s_temp =new Orisensyuugou();    //セレクトされた?ﾜ??だけ取り?oすために使う
				ori_s_temp.setMemo(ori_s.getMemo_select_sentaku(2));//セレクトされた?ﾜ??だけ取り?oしてori_s_tempを??る
				ori_s.del_selected_senbun_hayai();//セレクトされた?ﾜ??を???怩ｷる?B
				ori_s_temp.move(addx,addy);//全体を移動する

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
            //やりたい動??はここに?曹ｭ

            double addx, addy;
            addx = -s_step[1].getbx() + s_step[1].getax();
            addy = -s_step[1].getby() + s_step[1].getay();

            Orisensyuugou ori_s_temp = new Orisensyuugou();    //セレクトされた?ﾜ??だけ取り?oすために使う
            ori_s_temp.setMemo(ori_s.getMemo_select_sentaku(2));//セレクトされた?ﾜ??だけ取り?oしてori_s_tempを??る
            ori_s.del_selected_senbun_hayai();//セレクトされた?ﾜ??を???怩ｷる?B
            ori_s_temp.move(addx, addy);//全体を移動する

            int sousuu_old = ori_s.getsousuu();
            ori_s.addMemo(ori_s_temp.getMemo());
            int sousuu_new = ori_s.getsousuu();
            ori_s.kousabunkatu(1, sousuu_old, sousuu_old + 1, sousuu_new);

            ori_s.unselect_all();
            kiroku();
        }


    }


//-------------------------

//22 22 22 22 22    i_mouse_modeA==22?@;コピペモ?[ド

    //マウスを動かしたとき
    public void mMoved_A_22(Ten p0) {
        mMoved_m_00b(p0, 5);
    }//マウスで選択できる候補点を表示する?B近くに既?ｬの点があるときはその点?A無いときはマウスの位置自?gが候補点となる?B

    //マウスクリック----------------------------------------------------
    public void mPressed_A_22(Ten p0) {
        mPressed_m_00b(p0, 5);
    }

    //マウスドラッグ----------------------------------------------------
    public void mDragged_A_22(Ten p0) {
        mDragged_m_00b(p0, 5);
    }

    //マウスリリ?[ス----------------------------------------------------
    public void mReleased_A_22(Ten p0) {

        i_select_mode = 0;//  <-------20180919この?sはセレクトした??の端点を選ぶと?A移動とかコピ?[等をさせると判断するが?Aその操??が?Iわったときに必要だから追加した?B
/*
		i_egaki_dankai=0;
		p.set(camera.TV2object(p0));
		moyori_ten.set(get_moyori_ten(p));

		if(p.kyori(moyori_ten)<=d_hantei_haba){
			s_step[1].seta(moyori_ten);
			if(s_step[1].getnagasa()>0.00000001){
				//やりたい動??はここに?曹ｭ

				double addx,addy;
				addx=-s_step[1].getbx()+s_step[1].getax();
				addy=-s_step[1].getby()+s_step[1].getay();

				Orisensyuugou ori_s_temp =new Orisensyuugou();    //セレクトされた?ﾜ??だけ取り?oすために使う
				ori_s_temp.setMemo(ori_s.getMemo_select_sentaku(2));//セレクトされた?ﾜ??だけ取り?oしてori_s_tempを??る
				//ori_s.del_selected_senbun_hayai();//セレクトされた?ﾜ??を???怩ｷる?Bmoveと?@copyの違いはこの?sが有効かどうかの違い
				ori_s_temp.move(addx,addy);//全体を移動する

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
            //やりたい動??はここに?曹ｭ

            double addx, addy;
            addx = -s_step[1].getbx() + s_step[1].getax();
            addy = -s_step[1].getby() + s_step[1].getay();

            Orisensyuugou ori_s_temp = new Orisensyuugou();    //セレクトされた?ﾜ??だけ取り?oすために使う
            ori_s_temp.setMemo(ori_s.getMemo_select_sentaku(2));//セレクトされた?ﾜ??だけ取り?oしてori_s_tempを??る
            //ori_s.del_selected_senbun_hayai();//セレクトされた?ﾜ??を???怩ｷる?Bmoveと?@copyの違いはこの?sが有効かどうかの違い
            ori_s_temp.move(addx, addy);//全体を移動する

            int sousuu_old = ori_s.getsousuu();
            ori_s.addMemo(ori_s_temp.getMemo());
            int sousuu_new = ori_s.getsousuu();
            ori_s.kousabunkatu(1, sousuu_old, sousuu_old + 1, sousuu_new);

            ori_s.unselect_all();
            kiroku();
        }

    }


//--------------------------------------------
//31 31 31 31 31 31 31 31  i_mouse_modeA==31move2p2p	入力 31 31 31 31 31 31 31 31

//動??概要?@
//i_mouse_modeA==1と??分分割以外は同じ?@
//

    //マウス操??(マウスを動かしたとき)を?sう関??
    public void mMoved_A_31(Ten p0) {
        mMoved_A_11(p0);
    }//近い既存点のみ表示

    //マウス操??(i_mouse_modeA==31move2p2p?@でボタンを押したとき)時の??業----------------------------------------------------
    public void mPressed_A_31(Ten p0) {
        p.set(camera.TV2object(p0));

        if (i_egaki_dankai == 0) {    //第1段階として?A点を選択
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(5);
            }
            return;
        }

        if (i_egaki_dankai == 1) {    //第2段階として?A点を選択
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) >= d_hantei_haba) {
                i_egaki_dankai = 0;
                i_select_mode = 0;//  <-------20180919この?sはセレクトした??の端点を選ぶと?A移動とかコピ?[等をさせると判断するが?Aその操??が?Iわったときに必要だから追加した?B
                //点の選択が失敗した???№瀛_select_mode=0にしないと?Aセレクトのつもりが動??モ?[ドがmove2p2pになったままになる
                return;
            }
            if (p.kyori(moyori_ten) < d_hantei_haba) {

                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(i_egaki_dankai);

            }
            if (oc.kyori(s_step[1].geta(), s_step[2].geta()) < 0.00000001) {
                i_egaki_dankai = 0;
                i_select_mode = 0;//  <-------20180919この?sはセレクトした??の端点を選ぶと?A移動とかコピ?[等をさせると判断するが?Aその操??が?Iわったときに必要だから追加した?B

            }
            return;
        }


        if (i_egaki_dankai == 2) {    //第3段階として?A点を選択
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) >= d_hantei_haba) {
                i_egaki_dankai = 0;
                i_select_mode = 0;//  <-------20180919この?sはセレクトした??の端点を選ぶと?A移動とかコピ?[等をさせると判断するが?Aその操??が?Iわったときに必要だから追加した?B

                return;

            }
            if (p.kyori(moyori_ten) < d_hantei_haba) {

                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(i_egaki_dankai);

            }
            return;
        }


        if (i_egaki_dankai == 3) {    //第4段階として?A点を選択
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) >= d_hantei_haba) {
                i_egaki_dankai = 0;
                i_select_mode = 0;//  <-------20180919この?sはセレクトした??の端点を選ぶと?A移動とかコピ?[等をさせると判断するが?Aその操??が?Iわったときに必要だから追加した?B
                return;
            }
            if (p.kyori(moyori_ten) < d_hantei_haba) {

                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(i_egaki_dankai);

            }
            if (oc.kyori(s_step[3].geta(), s_step[4].geta()) < 0.00000001) {
                i_egaki_dankai = 0;
                i_select_mode = 0;//  <-------20180919この?sはセレクトした??の端点を選ぶと?A移動とかコピ?[等をさせると判断するが?Aその操??が?Iわったときに必要だから追加した?B

            }
            return;
        }


    }

    //マウス操??(i_mouse_modeA==31move2p2p?@でドラッグしたとき)を?sう関??----------------------------------------------------
    public void mDragged_A_31(Ten p0) {
    }

    //マウス操??(i_mouse_modeA==31move2p2p?@でボタンを離したとき)を?sう関??----------------------------------------------------
    public void mReleased_A_31(Ten p0) {
        if (i_egaki_dankai == 4) {
            i_egaki_dankai = 0;
            i_select_mode = 0;//  <-------20180919この?sはセレクトした??の端点を選ぶと?A移動とかコピ?[等をさせると判断するが?Aその操??が?Iわったときに必要だから追加した?B

            //double addx,addy;
            //addx=s_step[1].getbx()-s_step[1].getax();
            //addy=s_step[1].getby()-s_step[1].getay();


            Orisensyuugou ori_s_temp = new Orisensyuugou();    //セレクトされた?ﾜ??だけ取り?oすために使う
            ori_s_temp.setMemo(ori_s.getMemo_select_sentaku(2));//セレクトされた?ﾜ??だけ取り?oしてori_s_tempを??る
            ori_s.del_selected_senbun_hayai();//セレクトされた?ﾜ??を???怩ｷる?B
            ori_s_temp.move(s_step[1].geta(), s_step[2].geta(), s_step[3].geta(), s_step[4].geta());//全体を移動する

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
//32 32 32 32 32 32 32 32  i_mouse_modeA==32copy2p2p	入力 32 32 32 32 32 32 32 32

//動??概要?@
//i_mouse_modeA==1と??分分割以外は同じ?@
//

    //マウス操??(マウスを動かしたとき)を?sう関??
    public void mMoved_A_32(Ten p0) {
        mMoved_A_11(p0);
    }//近い既存点のみ表示

    //マウス操??(i_mouse_modeA==32copy2p2p2p2p?@でボタンを押したとき)時の??業----------------------------------------------------
    public void mPressed_A_32(Ten p0) {
        p.set(camera.TV2object(p0));

        if (i_egaki_dankai == 0) {    //第1段階として?A点を選択
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(5);
            }
            return;
        }

        if (i_egaki_dankai == 1) {    //第2段階として?A点を選択
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) >= d_hantei_haba) {
                i_egaki_dankai = 0;
                i_select_mode = 0;//  <-------20180919この?sはセレクトした??の端点を選ぶと?A移動とかコピ?[等をさせると判断するが?Aその操??が?Iわったときに必要だから追加した?B
                return;
            }
            if (p.kyori(moyori_ten) < d_hantei_haba) {

                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(i_egaki_dankai);

            }
            if (oc.kyori(s_step[1].geta(), s_step[2].geta()) < 0.00000001) {
                i_egaki_dankai = 0;
                i_select_mode = 0;//  <-------20180919この?sはセレクトした??の端点を選ぶと?A移動とかコピ?[等をさせると判断するが?Aその操??が?Iわったときに必要だから追加した?B
            }
            return;
        }


        if (i_egaki_dankai == 2) {    //第3段階として?A点を選択
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) >= d_hantei_haba) {
                i_egaki_dankai = 0;
                i_select_mode = 0;//  <-------20180919この?sはセレクトした??の端点を選ぶと?A移動とかコピ?[等をさせると判断するが?Aその操??が?Iわったときに必要だから追加した?B
                return;
            }
            if (p.kyori(moyori_ten) < d_hantei_haba) {

                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(i_egaki_dankai);

            }
            return;
        }


        if (i_egaki_dankai == 3) {    //第4段階として?A点を選択
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) >= d_hantei_haba) {
                i_egaki_dankai = 0;
                i_select_mode = 0;//  <-------20180919この?sはセレクトした??の端点を選ぶと?A移動とかコピ?[等をさせると判断するが?Aその操??が?Iわったときに必要だから追加した?B
                return;
            }
            if (p.kyori(moyori_ten) < d_hantei_haba) {

                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(i_egaki_dankai);

            }
            if (oc.kyori(s_step[3].geta(), s_step[4].geta()) < 0.00000001) {
                i_egaki_dankai = 0;
                i_select_mode = 0;//  <-------20180919この?sはセレクトした??の端点を選ぶと?A移動とかコピ?[等をさせると判断するが?Aその操??が?Iわったときに必要だから追加した?B
            }
            return;
        }


    }

    //マウス操??(i_mouse_modeA==32copy2p2p?@でドラッグしたとき)を?sう関??----------------------------------------------------
    public void mDragged_A_32(Ten p0) {
    }

    //マウス操??(i_mouse_modeA==32copy2p2pp?@でボタンを離したとき)を?sう関??----------------------------------------------------
    public void mReleased_A_32(Ten p0) {
        if (i_egaki_dankai == 4) {
            i_egaki_dankai = 0;
            i_select_mode = 0;//  <-------20180919この?sはセレクトした??の端点を選ぶと?A移動とかコピ?[等をさせると判断するが?Aその操??が?Iわったときに必要だから追加した?B
            //double addx,addy;
            //addx=s_step[1].getbx()-s_step[1].getax();
            //addy=s_step[1].getby()-s_step[1].getay();


            Orisensyuugou ori_s_temp = new Orisensyuugou();    //セレクトされた?ﾜ??だけ取り?oすために使う
            ori_s_temp.setMemo(ori_s.getMemo_select_sentaku(2));//セレクトされた?ﾜ??だけ取り?oしてori_s_tempを??る
            //ori_s.del_selected_senbun_hayai();//セレクトされた?ﾜ??を???怩ｷる?B
            ori_s_temp.move(s_step[1].geta(), s_step[2].geta(), s_step[3].geta(), s_step[4].geta());//全体を移動する

            int sousuu_old = ori_s.getsousuu();
            ori_s.addMemo(ori_s_temp.getMemo());
            int sousuu_new = ori_s.getsousuu();
            ori_s.kousabunkatu(1, sousuu_old, sousuu_old + 1, sousuu_new);

            //ori_s.unselect_all();
            kiroku();
        }
    }

//  ********************************************

    //12 12 12 12 12    i_mouse_modeA==12?@;鏡映モ?[ド
    //マウス操??(マウスを動かしたとき)を?sう関??
    public void mMoved_A_12(Ten p0) {
        mMoved_A_11(p0);
    }//近い既存点のみ表示

    //マウス操??(i_mouse_modeA==12鏡映モ?[ド?@でボタンを押したとき)時の??業----------------------------------------------------
    public void mPressed_A_12(Ten p0) {

        p.set(camera.TV2object(p0));


        if (i_egaki_dankai == 0) {    //第1段階として?A点を選択


            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(5);

                //s_step[i_egaki_dankai].set(moyori_senbun);        s_step[i_egaki_dankai].setcolor(5);

            }
            return;
        }

        if (i_egaki_dankai == 1) {    //第2段階として?A点を選択
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) >= d_hantei_haba) {
                i_egaki_dankai = 0;
                i_select_mode = 0;//  <-------20180919この?sはセレクトした??の端点を選ぶと?A移動とかコピ?[等をさせると判断するが?Aその操??が?Iわったときに必要だから追加した?B
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
                i_select_mode = 0;//  <-------20180919この?sはセレクトした??の端点を選ぶと?A移動とかコピ?[等をさせると判断するが?Aその操??が?Iわったときに必要だから追加した?B
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

    //マウス操??(i_mouse_modeA==12鏡映モ?[ド?@でドラッグしたとき)を?sう関??----------------------------------------------------
    public void mDragged_A_12(Ten p0) {

        //Ten p =new Ten(); p.set(camera.TV2object(p0));
        //s_step[1].seta(p);

        //k.seta(ieda, p);
    }

    //マウス操??(i_mouse_modeA==12鏡映モ?[ド?@でボタンを離したとき)を?sう関??----------------------------------------------------
    public void mReleased_A_12(Ten p0) {
        Senbun adds = new Senbun();
        //Orisensyuugou ori_s_temp =new Orisensyuugou();
        if (i_egaki_dankai == 2) {
            i_egaki_dankai = 0;
            i_select_mode = 0;//  <-------20180919この?sはセレクトした??の端点を選ぶと?A移動とかコピ?[等をさせると判断するが?Aその操??が?Iわったときに必要だから追加した?B
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


//34 34 34 34 34 34 34 34 34 34 34入力した??分に?d複している?ﾜ??を?№ﾉ山谷にする


    public void mMoved_A_34(Ten p0) {
        mMoved_A_11(p0);
    }//近い既存点のみ表示

    //マウス操??(i_mouse_modeA==34?@でボタンを押したとき)時の??業----------------------------------------------------
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

    //マウス操??(i_mouse_modeA==34?@でドラッグしたとき)を?sう関??----------------------------------------------------
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

    //マウス操??(i_mouse_modeA==34?@でボタンを離したとき)を?sう関??----------------------------------------------------
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


//36 36 36 36 36 36 36 36 36 36 36入力した??分にX交?ｷしている?ﾜ??を?№ﾉ山谷にする


    //マウス操??(マウスを動かしたとき)を?sう関??
    public void mMoved_A_36(Ten p0) {
        mMoved_A_28(p0);
    }//近い既存点のみ表示


    //マウス操??(i_mouse_modeA==36?@でボタンを押したとき)時の??業----------------------------------------------------
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

    //マウス操??(i_mouse_modeA==36?@でドラッグしたとき)を?sう関??----------------------------------------------------

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

    //マウス操??(i_mouse_modeA==36?@でボタンを離したとき)を?sう関??----------------------------------------------------
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
//13 13 13 13 13 13    i_mouse_modeA==13?@;角度系モ?[ド//??分指定?A交点まで

    //マウス操??(ボタンを押したとき)時の??業
    public void mPressed_A_13(Ten p0) {

        int honsuu = 0;//1つの端点周りに描く??の本??
        if (id_kakudo_kei != 0) {
            honsuu = id_kakudo_kei * 2 - 1;
        } else if (id_kakudo_kei == 0) {
            honsuu = 6;
        }

        int i_jyunnbi_step_suu = 1;//動??の??備として?l間が選択するステップ??

        //Ten p =new Ten();
        p.set(camera.TV2object(p0));

        if (i_egaki_dankai == 0) {    //第１段階として?A??分を選択
            moyori_senbun.set(get_moyori_senbun(p));
            if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {
                i_egaki_dankai = 1;
                s_step[1].set(moyori_senbun);
                s_step[1].setcolor(5);
            }
        }

        if (i_egaki_dankai == i_jyunnbi_step_suu) {    //if(i_egaki_dankai==1){        //動??の??備として?l間が選択するステップ?狽ｪ?Iわった?ﾔで実?s
            int i_jyun;//i_jyunは??を描くとき?∑ﾔに?Fを変えたいとき使う
            //??分abをaを中?Sにd度回転した??分を返す関???i元の??分は変えずに?Vしい??分を返す?jpublic oc.Senbun_kaiten(Senbun s0,double d) //    double d_kakudo_kei;double kakudo;

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


        if (i_egaki_dankai == i_jyunnbi_step_suu + (honsuu) + (honsuu)) {//19     //動??の??備としてソフトが返答するステップ?狽ｪ?Iわった?ﾔで実?s

            int i_tikai_s_step_suu = 0;

            //s_step[2から10]までとs_step[11から19]まで
            moyori_senbun.set(get_moyori_step_senbun(p, 2, 1 + (honsuu)));
            if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                i_tikai_s_step_suu = i_tikai_s_step_suu + 1;
                s_step[i_egaki_dankai].set(moyori_senbun);    //s_step[i_egaki_dankai].setcolor(2);//s_step[20]にinput
            }

            //s_step[2から10]までとs_step[11から19]まで
            moyori_senbun.set(get_moyori_step_senbun(p, 1 + (honsuu) + 1, 1 + (honsuu) + (honsuu)));
            if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                i_tikai_s_step_suu = i_tikai_s_step_suu + 1;
                s_step[i_egaki_dankai].set(moyori_senbun);    //s_step[i_egaki_dankai].setcolor(icol);
            }

            if (i_tikai_s_step_suu == 2) { //この段階でs_stepが[21]までうまってたら?As_step[20]とs_step[21]は共に加える?ﾜ??なので?Aここで????を?Iえてしまう?B
                //=     1+ (honsuu) +(honsuu) +  2 ){i_egaki_dankai=0; //この段階でs_stepが[21]までうまってたら?As_step[20]とs_step[21]は共に加える?ﾜ??なので?Aここで????を?Iえてしまう?B
                //例外????としてs_step[20]とs_step[21]が平?sの?????Aより近いほうをs_stepが[20]とし?As_stepを[20]としてリタ?[ン?iこの???№ﾍまだ????は?Iわれない?j?B
                //２つの??分が平?sかどうかを判定する関???Boc.heikou_hantei(Tyokusen t1,Tyokusen t2)//0=平?sでない?A1=平?sで２直??が一致しない?A2=平?sで２直??が一致する
                //0=平?sでない?A1=平?sで２直??が一致しない?A2=平?sで２直??が一致する

                if (oc.heikou_hantei(s_step[i_egaki_dankai - 1], s_step[i_egaki_dankai], 0.1) != 0) {//ここは安全を見て閾値を0.1と大目にとっておこのがよさそう

                    //s_step[20]とs_step[21]と点pの距離  //public double kyori_senbun(Ten p0,Senbun s)
                    //if(oc.kyori_senbun(p, s_step[1+     (honsuu) +(honsuu)   +1]) >  oc.kyori_senbun(p, s_step[1+     (honsuu) +(honsuu)   +1+1])          ){
                    //     s_step[1+     (honsuu) +(honsuu)   +1].set(  s_step[1+     (honsuu) +(honsuu)   +1+1]                   )    ;
                    //}

                    //i_egaki_dankai=i_egaki_dankai-1;
                    //i_egaki_dankai=i_egaki_dankai-2;
                    i_egaki_dankai = 0;
                    return;
                }


                i_egaki_dankai = 0;

                //s_step[20]とs_step[21]の交点はoc.kouten_motome(Senbun s1,Senbun s2)で??める//２つの??分を直??とみなして交点を??める関???B??分としては交?ｷしなくても?A直??として交?ｷしている???№ﾌ交点を返す
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

    //マウス操??(ドラッグしたとき)を?sう関??
    public void mDragged_A_13(Ten p0) {
    }

    //マウス操??(ボタンを離したとき)を?sう関??
    public void mReleased_A_13(Ten p0) {
    }

//------


//--------------------------------------------------------------------------------
//17 17 17 17 17 17    i_mouse_modeA==17?@;角度系モ?[ド

    //マウス操??(マウスを動かしたとき)を?sう関??
    public void mMoved_A_17(Ten p0) {
        if (i_egaki_dankai <= 1) {
            mMoved_A_11(p0);//近い既存点のみ表示
        }
    }


    //マウス操??(ボタンを押したとき)時の??業
    public void mPressed_A_17(Ten p0) {

        int honsuu = 0;//1つの端点周りに描く??の本??
        if (id_kakudo_kei != 0) {
            honsuu = id_kakudo_kei * 2 - 1;
        } else if (id_kakudo_kei == 0) {
            honsuu = 6;
        }

        int i_jyunnbi_step_suu = 2;//動??の??備として?l間が選択するステップ??

        //Ten p =new Ten();
        p.set(camera.TV2object(p0));

        if (i_egaki_dankai == 0) {    //第1段階として?A点を選択
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(5);

                //s_step[i_egaki_dankai].set(moyori_senbun);        s_step[i_egaki_dankai].setcolor(5);

            }
            return;
        }

        if (i_egaki_dankai == 1) {    //第2段階として?A点を選択
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

        if (i_egaki_dankai == i_jyunnbi_step_suu) {    //if(i_egaki_dankai==1){        //動??の??備として?l間が選択するステップ?狽ｪ?Iわった?ﾔで実?s
            int i_jyun;//i_jyunは??を描くとき?∑ﾔに?Fを変えたいとき使う
            //??分abをaを中?Sにd度回転した??分を返す関???i元の??分は変えずに?Vしい??分を返す?jpublic oc.Senbun_kaiten(Senbun s0,double d) //    double d_kakudo_kei;double kakudo;

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


        if (i_egaki_dankai == i_jyunnbi_step_suu + (honsuu) + (honsuu)) {//19     //動??の??備としてソフトが返答するステップ?狽ｪ?Iわった?ﾔで実?s

            int i_tikai_s_step_suu = 0;

            //s_step[2から10]までとs_step[11から19]まで
            moyori_senbun.set(get_moyori_step_senbun(p, 3, 2 + (honsuu)));
            if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                i_tikai_s_step_suu = i_tikai_s_step_suu + 1;
                s_step[i_egaki_dankai].set(moyori_senbun);    //s_step[i_egaki_dankai].setcolor(2);//s_step[20]にinput
            }

            //s_step[2から10]までとs_step[11から19]まで
            moyori_senbun.set(get_moyori_step_senbun(p, 2 + (honsuu) + 1, 2 + (honsuu) + (honsuu)));
            if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                i_tikai_s_step_suu = i_tikai_s_step_suu + 1;
                s_step[i_egaki_dankai].set(moyori_senbun);    //s_step[i_egaki_dankai].setcolor(icol);
            }

            if (i_tikai_s_step_suu == 2) { //この段階でs_stepが[21]までうまってたら?As_step[20]とs_step[21]は共に加える?ﾜ??なので?Aここで????を?Iえてしまう?B
                //=     1+ (honsuu) +(honsuu) +  2 ){i_egaki_dankai=0; //この段階でs_stepが[21]までうまってたら?As_step[20]とs_step[21]は共に加える?ﾜ??なので?Aここで????を?Iえてしまう?B
                //例外????としてs_step[20]とs_step[21]が平?sの?????Aより近いほうをs_stepが[20]とし?As_stepを[20]としてリタ?[ン?iこの???№ﾍまだ????は?Iわれない?j?B
                //２つの??分が平?sかどうかを判定する関???Boc.heikou_hantei(Tyokusen t1,Tyokusen t2)//0=平?sでない?A1=平?sで２直??が一致しない?A2=平?sで２直??が一致する
                //0=平?sでない?A1=平?sで２直??が一致しない?A2=平?sで２直??が一致する

                if (oc.heikou_hantei(s_step[i_egaki_dankai - 1], s_step[i_egaki_dankai], 0.1) != 0) {//ここは安全を見て閾値を0.1と大目にとっておこのがよさそう

                    //s_step[20]とs_step[21]と点pの距離  //public double kyori_senbun(Ten p0,Senbun s)
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

                //s_step[20]とs_step[21]の交点はoc.kouten_motome(Senbun s1,Senbun s2)で??める//２つの??分を直??とみなして交点を??める関???B??分としては交?ｷしなくても?A直??として交?ｷしている???№ﾌ交点を返す
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

    //マウス操??(ドラッグしたとき)を?sう関??
    public void mDragged_A_17(Ten p0) {
    }

    //マウス操??(ボタンを離したとき)を?sう関??
    public void mReleased_A_17(Ten p0) {
    }

//------


//VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV

//16 16 16 16 16 16    i_mouse_modeA==16?@;角度系モ?[ド

    //マウス操??(マウスを動かしたとき)を?sう関??
    public void mMoved_A_16(Ten p0) {
        mMoved_A_17(p0);
    }


    //マウス操??(ボタンを押したとき)時の??業
    public void mPressed_A_16(Ten p0) {

        int honsuu = 0;//1つの端点周りに描く??の本??
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
            //??分abをaを中?Sにd度回転した??分を返す関???i元の??分は変えずに?Vしい??分を返す?jpublic oc.Senbun_kaiten(Senbun s0,double d)


            if (id_kakudo_kei != 0) {
                d_kakudo_kei = 180.0 / (double) id_kakudo_kei;
            } else if (id_kakudo_kei == 0) {
                d_kakudo_kei = 180.0 / 4.0;
            }

            if (id_kakudo_kei != 0) {


                Senbun s_kiso = new Senbun(s_step[2].geta(), s_step[1].geta());
                kakudo = 0.0;

                int i_jyun;
                i_jyun = 0;//i_jyunは??を描くとき?∑ﾔに?Fを変えたいとき使う
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
            if (oc.kyori_senbun(p, moyori_senbun) >= d_hantei_haba) {//?ﾅ寄?ﾜ??が遠かった????
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

            //s_step[12]とs_step[13]の交点はoc.kouten_motome(Senbun s1,Senbun s2)で??める//２つの??分を直??とみなして交点を??める関???B??分としては交?ｷしなくても?A直??として交?ｷしている???№ﾌ交点を返す
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

    //マウス操??(ドラッグしたとき)を?sう関??
    public void mDragged_A_16(Ten p0) {
    }

    //マウス操??(ボタンを離したとき)を?sう関??
    public void mReleased_A_16(Ten p0) {
    }

//------


//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA

//VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV

//18 18 18 18 18 18    i_mouse_modeA==18?@;角度系モ?[ド

    //マウス操??(マウスを動かしたとき)を?sう関??
    public void mMoved_A_18(Ten p0) {
        mMoved_A_17(p0);
    }

    //マウス操??(ボタンを押したとき)時の??業
    public void mPressed_A_18(Ten p0) {

        int honsuu = 0;//1つの端点周りに描く??の本??
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
            //??分abをaを中?Sにd度回転した??分を返す関???i元の??分は変えずに?Vしい??分を返す?jpublic oc.Senbun_kaiten(Senbun s0,double d)

            if (id_kakudo_kei != 0) {
                d_kakudo_kei = 180.0 / (double) id_kakudo_kei;
            } else if (id_kakudo_kei == 0) {
                d_kakudo_kei = 180.0 / 4.0;
            }


            if (id_kakudo_kei != 0) {
                Senbun s_kiso = new Senbun(s_step[2].geta(), s_step[1].geta());
                kakudo = 0.0;

                int i_jyun;
                i_jyun = 0;//i_jyunは??を描くとき?∑ﾔに?Fを変えたいとき使う
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
                if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {//?ﾅ寄?ﾜ??が近い????
                    if (oc.heikou_hantei(moyori_step_senbun, moyori_senbun, 0.000001) == 0) {//?ﾅ寄?ﾜ??が?ﾅ寄step?ﾜ??と平?sの???№ﾍ?怺O
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

			//s_step[12]とs_step[13]の交点はoc.kouten_motome(Senbun s1,Senbun s2)で??める//２つの??分を直??とみなして交点を??める関???B??分としては交?ｷしなくても?A直??として交?ｷしている???№ﾌ交点を返す
//			Ten kousa_ten =new Ten(); kousa_ten.set(oc.kouten_motome(s_step[12],s_step[13]));
			Ten kousa_ten =new Ten(); kousa_ten.set(oc.kouten_motome(s_step[2+ (honsuu)  +1 ],s_step[2+ (honsuu)  +1  +1]));
			Senbun add_sen =new Senbun(kousa_ten,s_step[2].geta());
			if(add_sen.getnagasa()>0.00000001){addsenbun(add_sen);kiroku();}
			return;
	*/
        }


    }

    //マウス操??(ドラッグしたとき)を?sう関??
    public void mDragged_A_18(Ten p0) {
    }

    //マウス操??(ボタンを離したとき)を?sう関??
    public void mReleased_A_18(Ten p0) {
    }

//------


//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA


//14 14 14 14 14 14 14 14 14    i_mouse_modeA==14?@;V追加モ?[ド

    //マウス操??(ボタンを押したとき)時の??業
    public void mPressed_A_14(Ten p0) {
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        int mts_id;
        mts_id = ori_s.mottomo_tikai_senbun_sagasi(p);//mts_idは点pに?ﾅも近い??分の番??	public int ori_s.mottomo_tikai_senbun_sagasi(Ten p)
        Senbun mts = new Senbun(ori_s.geta(mts_id), ori_s.getb(mts_id));//mtsは点pに?ﾅも近い??分

        if (oc.kyori_senbun(p, mts) < d_hantei_haba) {
            //直??t?繧ﾌ点pの影の位置?i点pと?ﾅも近い直??t?繧ﾌ位置?jを??める?Bpublic Ten oc.kage_motome(Tyokusen t,Ten p){}
            //??分を含む直??を得る public Tyokusen oc.Senbun2Tyokusen(Senbun s){}
            Ten pk = new Ten();
            pk.set(oc.kage_motome(oc.Senbun2Tyokusen(mts), p));//pkは点pの?i??分を含む直???繧ﾌ?j影

            //点paが?A二点p1,p2を端点とする??分に点p1と点p2で直?sする?A2つの??分を含む長方形内にある???№ﾍ2を返す関??	public int oc.hakononaka(Ten p1,Ten pa,Ten p2){}

            if (oc.hakononaka(mts.geta(), pk, mts.getb()) == 2) {
                //??分の分割-----------------------------------------
                ori_s.senbun_bunkatu(mts_id, pk);  //i番目の??分(端点aとb)を点pで分割する?Bi番目の??分abをapに変え?A??分pbを加える?B
                kiroku();
            }

        }
        return;

    }

    //マウス操??(ドラッグしたとき)を?sう関??
    public void mDragged_A_14(Ten p0) {
    }

    //マウス操??(ボタンを離したとき)を?sう関??
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

//15 15 15 15 15 15 15 15 15    i_mouse_modeA==15?@;V???怎??[ド

    //マウス操??(ボタンを押したとき)時の??業
    public void mPressed_A_15(Ten p0) {


        //Ten p =new Ten();
        p.set(camera.TV2object(p0));

        //点pに?ﾅも近い??分の?A点pに近い方の端点を?A頂点とした?????A何本の??分が?oているか?i頂点とr以内に端点がある??分の???j	public int tyouten_syuui_sennsuu(Ten p) {

        ori_s.del_V(p, d_hantei_haba, 0.000001);
        kiroku();


    }

    //マウス操??(ドラッグしたとき)を?sう関??
    public void mDragged_A_15(Ten p0) {
    }

    //マウス操??(ボタンを離したとき)を?sう関??
    public void mReleased_A_15(Ten p0) {
    }


//------

//41 41 41 41 41 41 41 41    i_mouse_modeA==41?@;V???怎??[ド(2つの?ﾜ??の?Fが違った???㏍Jラ?[チェンジして?A点???怩ｷる?B???ﾔは?ﾔ?ﾔ?A???ﾂは?ﾂ?ﾂ?A?ﾂ?ﾔは?浮ﾉする)

    //マウス操??(ボタンを押したとき)時の??業
    public void mPressed_A_41(Ten p0) {


        //Ten p =new Ten();
        p.set(camera.TV2object(p0));

        //点pに?ﾅも近い??分の?A点pに近い方の端点を?A頂点とした?????A何本の??分が?oているか?i頂点とr以内に端点がある??分の???j	public int tyouten_syuui_sennsuu(Ten p) {

        ori_s.del_V_cc(p, d_hantei_haba, 0.000001);


        kiroku();


    }

    //マウス操??(ドラッグしたとき)を?sう関??
    public void mDragged_A_41(Ten p0) {
    }

    //マウス操??(ボタンを離したとき)を?sう関??
    public void mReleased_A_41(Ten p0) {
    }


//------


    //-------------------------
//23 23 23 23 23
    //マウス操??(i_mouse_modeA==23 "->M" でボタンを押したとき)時の??業----------------------------------------------------
    public void mPressed_A_23(Ten p0) {
        mPressed_A_box_select(p0);
    }

    //マウス操??(i_mouse_modeA==23でドラッグしたとき)を?sう関??----------------------------------------------------
    public void mDragged_A_23(Ten p0) {
        mDragged_A_box_select(p0);
    }

    //マウス操??(i_mouse_modeA==23 でボタンを離したとき)を?sう関??----------------------------------------------------
    public void mReleased_A_23(Ten p0) {//ここの????の?Iわりに fix2(0.001,0.5);?@をするのは?A元から?ﾜ??だったものと?A補????から変換した?ﾜ??との組?№ｹで頻発するT字型不?ﾚ続を?C?ｳするため
        i_egaki_dankai = 0;

        if (p19_1.kyori(p0) > 0.000001) {//現?ﾅは?ﾔを?ﾔに変えたときもUNDO用に記録されてしまう20161218
            if (M_nisuru(p19_1, p0) != 0) {
                fix2(0.001, 0.5);
                kiroku();
            }
        }
        if (p19_1.kyori(p0) <= 0.000001) {//現?ﾅは?ﾔを?ﾔに変えたときもUNDO用に記録されてしまう20161218
            //Ten p =new Ten();
            p.set(camera.TV2object(p0));
            if (ori_s.mottomo_tikai_senbun_kyori(p) < d_hantei_haba) {//点pに?ﾅも近い??分の番??での?Aその距離を返す	public double mottomo_tikai_senbun_kyori(Ten p)
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
    //マウス操??(i_mouse_modeA==24 "->V" でボタンを押したとき)時の??業----------------------------------------------------
    public void mPressed_A_24(Ten p0) {
        mPressed_A_box_select(p0);
    }

    //マウス操??(i_mouse_modeA==24でドラッグしたとき)を?sう関??----------------------------------------------------
    public void mDragged_A_24(Ten p0) {
        mDragged_A_box_select(p0);
    }

    //マウス操??(i_mouse_modeA==24 でボタンを離したとき)を?sう関??----------------------------------------------------
    public void mReleased_A_24(Ten p0) {//ここの????の?Iわりに fix2(0.001,0.5);?@をするのは?A元から?ﾜ??だったものと?A補????から変換した?ﾜ??との組?№ｹで頻発するT字型不?ﾚ続を?C?ｳするため
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
            if (ori_s.mottomo_tikai_senbun_kyori(p) < d_hantei_haba) {//点pに?ﾅも近い??分の番??での?Aその距離を返す	public double mottomo_tikai_senbun_kyori(Ten p)
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
    //マウス操??(i_mouse_modeA==25 "->E" でボタンを押したとき)時の??業----------------------------------------------------
    public void mPressed_A_25(Ten p0) {
        mPressed_A_box_select(p0);
    }

    //マウス操??(i_mouse_modeA==25でドラッグしたとき)を?sう関??----------------------------------------------------
    public void mDragged_A_25(Ten p0) {
        mDragged_A_box_select(p0);
    }

    //マウス操??(i_mouse_modeA==25 でボタンを離したとき)を?sう関??----------------------------------------------------
    public void mReleased_A_25(Ten p0) {//ここの????の?Iわりに fix2(0.001,0.5);?@をするのは?A元から?ﾜ??だったものと?A補????から変換した?ﾜ??との組?№ｹで頻発するT字型不?ﾚ続を?C?ｳするため
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
            if (ori_s.mottomo_tikai_senbun_kyori(p) < d_hantei_haba) {//点pに?ﾅも近い??分の番??での?Aその距離を返す	public double mottomo_tikai_senbun_kyori(Ten p)
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
    //マウス操??(i_mouse_modeA==60 "->HK" でボタンを押したとき)時の??業----------------------------------------------------
    public void mPressed_A_60(Ten p0) {
        mPressed_A_box_select(p0);
    }

    //マウス操??(i_mouse_modeA==60でドラッグしたとき)を?sう関??----------------------------------------------------
    public void mDragged_A_60(Ten p0) {
        mDragged_A_box_select(p0);
    }

    //マウス操??(i_mouse_modeA==60 でボタンを離したとき)を?sう関??----------------------------------------------------
    public void mReleased_A_60(Ten p0) {
        i_egaki_dankai = 0;

        if (p19_1.kyori(p0) > 0.000001) {
            if (HK_nisuru(p19_1, p0) != 0) {
                kiroku();
            }//この関?狽ﾍ不完全なのでまだ未公開20171126
        }

        if (p19_1.kyori(p0) <= 0.000001) {
            //Ten p =new Ten();
            p.set(camera.TV2object(p0));
            if (ori_s.mottomo_tikai_senbun_kyori(p) < d_hantei_haba) {//点pに?ﾅも近い??分の番??での?Aその距離を返す	public double mottomo_tikai_senbun_kyori(Ten p)
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


//26 26 26 26    i_mouse_modeA==26?@;背景setモ?[ド?B

    //マウス操??(ボタンを押したとき)時の??業
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

    //マウス操??(ドラッグしたとき)を?sう関??
    public void mDragged_A_26(Ten p0) {
    }

    //マウス操??(ボタンを離したとき)を?sう関??
    public int mReleased_A_26(Ten p0) {
        return i_egaki_dankai;
    }

//------


//42 42 42 42 42 42 42 42 42 42 42 42 42 42 42?@ここから

    //マウス操??(i_mouse_modeA==42 円入力?@でボタンを押したとき)時の??業----------------------------------------------------
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

    //マウス操??(i_mouse_modeA==42 円入力?@でドラッグしたとき)を?sう関??----------------------------------------------------
    public void mDragged_A_42(Ten p0) {

        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        s_step[1].seta(p);
        e_step[1].setr(oc.kyori(s_step[1].geta(), s_step[1].getb()));

        //k.seta(ieda, p);
    }

    //マウス操??(i_mouse_modeA==42 円入力?@でボタンを離したとき)を?sう関??----------------------------------------------------
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

//42 42 42 42 42 42 42 42 42 42 42 42 42 42 42  ここまで


//47 47 47 47 47 47 47 47 47 47 47 47 47 47 47?@ここから

    //マウス操??(i_mouse_modeA==47 円入力(フリ?[?@)?@でボタンを押したとき)時の??業----------------------------------------------------
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

    //マウス操??(i_mouse_modeA==47 円入力?@でドラッグしたとき)を?sう関??----------------------------------------------------
    public void mDragged_A_47(Ten p0) {
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        s_step[1].seta(p);
        e_step[1].setr(oc.kyori(s_step[1].geta(), s_step[1].getb()));
    }

    //マウス操??(i_mouse_modeA==47 円入力?@でボタンを離したとき)を?sう関??----------------------------------------------------
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

//47 47 47 47 47 47 47 47 47 47 47 47 47 47 47  ここまで


//44 44 44 44 44 44 44 44 44 44 44 44 44 44 44?@ここから

    //マウス操??(i_mouse_modeA==44 円 分離入力?@でボタンを押したとき)時の??業----------------------------------------------------
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

    //マウス操??(i_mouse_modeA==44 円 分離入力?@でドラッグしたとき)を?sう関??----------------------------------------------------
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

    //マウス操??(i_mouse_modeA==44 円 分離入力?@でボタンを離したとき)を?sう関??----------------------------------------------------
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

//44 44 44 44 44 44 44 44 44 44 44 44 44 44 44  ここまで


//48 48 48 48 48 48 48 48 48 48 48 48 48 48 48?@ここから

    //マウス操??(i_mouse_modeA==48 同?S円?@??分入力?@でボタンを押したとき)時の??業----------------------------------------------------
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

    //マウス操??(i_mouse_modeA==48 同?S円?@??分入力?@でドラッグしたとき)を?sう関??----------------------------------------------------
    public void mDragged_A_48(Ten p0) {
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        if ((i_egaki_dankai == 1) && (i_en_egaki_dankai == 2)) {
            s_step[1].seta(p);
            e_step[2].setr(e_step[1].getr() + s_step[1].getnagasa());
        }
    }

    //マウス操??(i_mouse_modeA==48 同?S円?@??分入力?@でボタンを離したとき)を?sう関??----------------------------------------------------
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

//48 48 48 48 48 48 48 48 48 48 48 48 48 48 48  ここまで

//49 49 49 49 49 49 49 49 49 49 49 49 49 49 49?@ここから

    //マウス操??(i_mouse_modeA==49 同?S円?@同?S円入力?@でボタンを押したとき)時の??業----------------------------------------------------
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

    //マウス操??(i_mouse_modeA==49 同?S円?@同?S円入力?@でドラッグしたとき)を?sう関??----------------------------------------------------
    public void mDragged_A_49(Ten p0) {

    }

    //マウス操??(i_mouse_modeA==49 同?S円?@同?S円入力?@でボタンを離したとき)を?sう関??----------------------------------------------------
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

//49 49 49 49 49 49 49 49 49 49 49 49 49 49 49  ここまで

//51 51 51 51 51 51 51 51 51 51 51 51 51 51 51?@ここから

    //マウス操??(i_mouse_modeA==51 平?s???@??指定入力モ?[ド?@でボタンを押したとき)時の??業----------------------------------------------------
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

    //マウス操??(i_mouse_modeA==51 平?s???@??指定入力モ?[ド?@でドラッグしたとき)を?sう関??----------------------------------------------------
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

    //マウス操??(i_mouse_modeA==51 平?s???@??指定入力モ?[ド?@でボタンを離したとき)を?sう関??----------------------------------------------------
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

//51 51 51 51 51 51 51 51 51 51 51 51 51 51 51  ここまで

//45 45 45 45 45 45 45 45 45   i_mouse_modeA==45?@;2円の共通?ﾚ??入力モ?[ド?B

    //マウス操??(ボタンを押したとき)時の??業
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

    //マウス操??(ドラッグしたとき)を?sう関??
    public void mDragged_A_45(Ten p0) {
    }

    //マウス操??(ボタンを離したとき)を?sう関??
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
            }//?ﾚ??0本の????

            if ((xp * xp + yp * yp) < (r1 - r2) * (r1 - r2)) {
                i_egaki_dankai = 0;
                i_en_egaki_dankai = 0;
                return;
            }//?ﾚ??0本の????

            if (Math.abs((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2)) < 0.0000001) {//外?ﾚ??1本の????
                Ten kouten = new Ten();
                kouten.set(oc.naibun(c1, c2, -r1, r2));
                Tyokusen ty = new Tyokusen(c1, kouten);
                ty.tyokkouka(kouten);
                s_step[1].set(oc.en_to_tyokusen_no_kouten_wo_musubu_senbun(new En(kouten, (r1 + r2) / 2.0, 0), ty));

                i_egaki_dankai = 1;
                i_en_egaki_dankai = 2;
            }

            if (((r1 - r2) * (r1 - r2) < (xp * xp + yp * yp)) && ((xp * xp + yp * yp) < (r1 + r2) * (r1 + r2))) {//外?ﾚ??2本の????
                double xq1 = r1 * (xp * (r1 - r2) + yp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//共通外?ﾚ??
                double yq1 = r1 * (yp * (r1 - r2) - xp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//共通外?ﾚ??
                double xq2 = r1 * (xp * (r1 - r2) - yp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//共通外?ﾚ??
                double yq2 = r1 * (yp * (r1 - r2) + xp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//共通外?ﾚ??

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

            if (Math.abs((xp * xp + yp * yp) - (r1 + r2) * (r1 + r2)) < 0.0000001) {//外?ﾚ??2本と内?ﾚ??1本の????
                double xq1 = r1 * (xp * (r1 - r2) + yp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//共通外?ﾚ??
                double yq1 = r1 * (yp * (r1 - r2) - xp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//共通外?ﾚ??
                double xq2 = r1 * (xp * (r1 - r2) - yp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//共通外?ﾚ??
                double yq2 = r1 * (yp * (r1 - r2) + xp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//共通外?ﾚ??

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

            if ((r1 + r2) * (r1 + r2) < (xp * xp + yp * yp)) {//外?ﾚ??2本と内?ﾚ??2本の????
                //             ---------------------------------------------------------------
                //                                     -------------------------------------
                //                 -------               -------------   -------   -------       -------------
                double xq1 = r1 * (xp * (r1 - r2) + yp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//共通外?ﾚ??
                double yq1 = r1 * (yp * (r1 - r2) - xp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//共通外?ﾚ??
                double xq2 = r1 * (xp * (r1 - r2) - yp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//共通外?ﾚ??
                double yq2 = r1 * (yp * (r1 - r2) + xp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//共通外?ﾚ??
                double xq3 = r1 * (xp * (r1 + r2) + yp * Math.sqrt((xp * xp + yp * yp) - (r1 + r2) * (r1 + r2))) / (xp * xp + yp * yp);//共通内?ﾚ??
                double yq3 = r1 * (yp * (r1 + r2) - xp * Math.sqrt((xp * xp + yp * yp) - (r1 + r2) * (r1 + r2))) / (xp * xp + yp * yp);//共通内?ﾚ??
                double xq4 = r1 * (xp * (r1 + r2) - yp * Math.sqrt((xp * xp + yp * yp) - (r1 + r2) * (r1 + r2))) / (xp * xp + yp * yp);//共通内?ﾚ??
                double yq4 = r1 * (yp * (r1 + r2) + xp * Math.sqrt((xp * xp + yp * yp) - (r1 + r2) * (r1 + r2))) / (xp * xp + yp * yp);//共通内?ﾚ??


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

//45 45 45 45 45 45 45 45 45  ここまで  ------


//50 50 50 50 50 50 50 50 50   i_mouse_modeA==50?@;2円に??同じで?ﾚする同?S円を加える?B

    //マウス操??(ボタンを押したとき)時の??業
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

    //マウス操??(ドラッグしたとき)を?sう関??
    public void mDragged_A_50(Ten p0) {
    }

    //マウス操??(ボタンを離したとき)を?sう関??
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

//50 50 50 50 50 50 50 50 50  ここまで  ------


//46 46 46 46 46 46 46 46 46   i_mouse_modeA==46?@;反転入力モ?[ド?B

    //マウス操??(ボタンを押したとき)時の??業
    public void mPressed_A_46(Ten p0) {
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));

        moyori_ensyuu.set(get_moyori_ensyuu(p));

        if (i_egaki_dankai + i_en_egaki_dankai == 0) {
            moyori_senbun.set(get_moyori_senbun(p));


            if (oc.kyori_senbun(p, moyori_senbun) < oc.kyori_ensyuu(p, moyori_ensyuu)) {//??分の方が円周より近い
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

    //マウス操??(ドラッグしたとき)を?sう関??
    public void mDragged_A_46(Ten p0) {
    }

    //マウス操??(ボタンを離したとき)を?sう関??
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

//46 46 46 46 46 46 46 46 46  ここまで  ------


//43 43 43 43 43 43 43 43 43   i_mouse_modeA==43?@;円3点入力モ?[ド?B

    //マウス操??(ボタンを押したとき)時の??業
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

    //マウス操??(ドラッグしたとき)を?sう関??
    public void mDragged_A_43(Ten p0) {
    }

    //マウス操??(ボタンを離したとき)を?sう関??
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

//43 43 43 43 43 43 43 43 43  ここまで  ------





















/*

//5555555555555555555555    i_mouse_modeA==5?@

//マウス操??(ボタンを押したとき)時の??業
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

//マウス操??(ドラッグしたとき)を?sう関??
	public void mDragged_A_05(Ten p0) {	}

//マウス操??(ボタンを離したとき)を?sう関??
	public void mReleased_A_05(Ten p0){			if(i_egaki_dankai==3){i_egaki_dankai=0;}}

//------

//66666666666666666666    i_mouse_modeA==6?@

//マウス操??(ボタンを押したとき)時の??業
	public void mPressed_A_06(Ten p0) {


		//Ten p =new Ten();
		p.set(camera.TV2object(p0));
		moyori_ten.set(get_moyori_ten(p));
		if(p.kyori(moyori_ten)<d_hantei_haba){
			i_egaki_dankai=i_egaki_dankai+1;
			s_step[i_egaki_dankai].set(moyori_ten,moyori_ten);s_step[i_egaki_dankai].setcolor(i_egaki_dankai);
		}


	}

//マウス操??(ドラッグしたとき)を?sう関??
	public void mDragged_A_06(Ten p0) {	}

//マウス操??(ボタンを離したとき)を?sう関??
	public void mReleased_A_06(Ten p0){
		if(i_egaki_dankai==3){i_egaki_dankai=0;}



	}

//------



*/


//10001

    //マウス操??(i_mouse_modeA==10001?@でボタンを押したとき)時の??業
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

    //マウス操??(i_mouse_modeA==10001?@でドラッグしたとき)を?sう関??
    public void mDragged_A_10001(Ten p0) {
    }

    //マウス操??(i_mouse_modeA==10001?@でボタンを離したとき)を?sう関??
    public void mReleased_A_10001(Ten p0) {
        if (i_egaki_dankai == 3) {
            i_egaki_dankai = 0;
        }


    }

//------
//10002

    //マウス操??(i_mouse_modeA==10002?@でボタンを押したとき)時の??業
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

    //マウス操??(i_mouse_modeA==10002?@でドラッグしたとき)を?sう関??
    public void mDragged_A_10002(Ten p0) {
    }

    //マウス操??(i_mouse_modeA==10002?@でボタンを離したとき)を?sう関??
    public void mReleased_A_10002(Ten p0) {
        if (i_egaki_dankai == 3) {
            i_egaki_dankai = 0;
        }
    }

//------
//------
//10003

    //マウス操??(i_mouse_modeA==10003?@でボタンを押したとき)時の??業
    public void mPressed_A_10003(Ten p0) {
    }

    //マウス操??(i_mouse_modeA==10003?@でドラッグしたとき)を?sう関??
    public void mDragged_A_10003(Ten p0) {
    }

    //マウス操??(i_mouse_modeA==10003?@でボタンを離したとき)を?sう関??
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
    }//ori_sにおいて?Aチェックしておかしい?ﾜ??をセレクト?ﾔにする?B

    public void fix1(double r_hitosii, double heikou_hantei) {
        while (ori_s.fix1(r_hitosii, heikou_hantei) == 1) {
        }
        //ori_s.addsenbun  delsenbunを実施しているところでcheckを実施
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
        //ori_s.addsenbun  delsenbunを実施しているところでcheckを実施
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

    public void en_seiri() {//全ての円を対?ﾛに?ｮ??をする?B
        ori_s.en_seiri();
    }


    // ---------------------------
    public void add_hanten(En e0, En eh) {


        //e0の円周が(x,y)を通るとき
        if (Math.abs(oc.kyori(e0.get_tyuusin(), eh.get_tyuusin()) - e0.getr()) < 0.0000001) {
            Senbun s_add = new Senbun();
            s_add.set(eh.hanten_En2Senbun(e0));
            //s_add.setcolor(3);
            addsenbun(s_add);
            kiroku();
            return;
        }


        //e0の円周の内部に(x,y)がくるとき
        //if(oc.kyori(e0.get_tyuusin(),eh.get_tyuusin())<e0.getr()){
        //	return;
        //}

//System.out.println("20170315  ********************3");
        //e0の円周が(x,y)を通らないとき?Be0の円周の外部に(x,y)がくるとき//e0の円周の内部に(x,y)がくるとき
        En e_add = new En();
        e_add.set(eh.hanten(e0));
        add_en(e_add);
        kiroku();
    }

    // ---------------------------
    public void add_hanten(Senbun s0, En eh) {
        Tyokusen ty = new Tyokusen(s0);
        //s0?繧ﾉ(x,y)がくるとき
        if (ty.kyorikeisan(eh.get_tyuusin()) < 0.0000001) {
            return;
        }

        //s0が(x,y)を通らないとき?B
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
一値分解する関?琶tti_bunkai();

public void itti_bunkai(){//?i１?j2点a,bを指定







}

?i１?j2点a,bを指定
?i２?jaを基点とするベクトルabが?ﾅ?奄ﾉぶつかる?ﾜ??との交点cを??める?Babと?dなる?ﾜ??は無視
?i３?j
cが既存の?ﾜ??の柄の部分だった?????Aその??で鏡映し?Acをaとし?Abを鏡映??の?謔ﾌ点として?ﾄ帰的に?B
cが点だった?????Aすでに通過していた点なら?Areturn;


cからベクトルacと一値?ｫを??つベクトルを??める?A






*/

    //--------------------------------------------
    public void test1() {//デバック等のテスト用

        System.out.println("ori_s.getsousuu()  " + ori_s.getsousuu());

    }

    //--------------------------------------------

    //??モ
    //icol=0 black
    //icol=1 red
    //icol=2 blue
    //icol=3 cyan
    //icol=4 orange
    //icol=5 mazenta
    //icol=6 green
    //icol=7 yellow
    //icol=8 new Color(210,0,255) //紫


}