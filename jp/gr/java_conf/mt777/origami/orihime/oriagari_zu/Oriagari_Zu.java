package jp.gr.java_conf.mt777.origami.orihime.oriagari_zu;

//import java.awt.MouseInfo;
//import java.awt.PointerInfo;

import jp.gr.java_conf.mt777.kiroku.memo.Memo;
import jp.gr.java_conf.mt777.kiroku.moji_sousa.Moji_sousa;
import jp.gr.java_conf.mt777.origami.dougu.camera.Camera;
import jp.gr.java_conf.mt777.origami.dougu.keijiban.Keijiban;
import jp.gr.java_conf.mt777.origami.dougu.senbunsyuugou.Senbunsyuugou;
import jp.gr.java_conf.mt777.origami.orihime.ap;
import jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin.Jyougehyou_Syokunin;
import jp.gr.java_conf.mt777.origami.orihime.kihonshi_syokunin.Kihonshi_Syokunin;
import jp.gr.java_conf.mt777.origami.orihime.tenkaizu_syokunin.Tenkaizu_Syokunin;
import jp.gr.java_conf.mt777.zukei2d.oritacalc.OritaCalc;
import jp.gr.java_conf.mt777.zukei2d.ten.Ten;

import java.awt.*;


// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------

//public class Oriagari_Zu extends Oriagari_Zu_00 {//Oriagari_Zuが基本となる?ﾜ?繧ｪり予測アルゴリズム

public class Oriagari_Zu {

    ap orihime_ap;

    OritaCalc oc = new OritaCalc();
    Moji_sousa ms = new Moji_sousa(); //文字列操??用の関?狽??Wめたクラス

    double r = 3.0;                   //基本枝?\造の直??の両端の円の半径?A枝と各種ポイントの近さの判定基??


    public double d_oriagarizu_syukusyaku_keisuu = 1.0;//?ﾜり?繧ｪり?}の?k尺係??
    public double d_oriagarizu_kaiten_hosei = 0.0;//?ﾜり?繧ｪり?}の回転表示角度の補?ｳ角度

    public Kihonshi_Syokunin ks2 = new Kihonshi_Syokunin(r);    //基本枝?E?l?Bts2の??つ点?W?№s3に渡す前に?A
    //ts2の??つ点?W?№ﾍ棒が?dなっていたりするかもしれないので?A
    //いったんks2に渡して??分?W?№ﾆして?ｮ??する?B

    public Tenkaizu_Syokunin ts1 = new Tenkaizu_Syokunin(r);    //展開?}?E?l?B入力された??分?W?№??ﾅ?奄ﾉ?ﾜって?j金?ﾌ点?W?№ﾌ?ﾜり?繧ｪり?}を??る
    public Tenkaizu_Syokunin ts2 = new Tenkaizu_Syokunin(r);    //展開?}?E?l?Bts1の??った?j金?ﾌ点?W?№ﾌ?ﾜり?繧ｪり?}を保??し?A??分?W?№ﾉするなどの働きをする?B
    public Tenkaizu_Syokunin ts3 = new Tenkaizu_Syokunin(r);    //展開?}?E?l?Bts1の??った?j金?ﾌ点?W?№??ｮ??し?B?Vたに面を認識するなどの働きを??つ?B

    public Jyougehyou_Syokunin js;
    //public Jyougehyou_Syokunin js      = new Jyougehyou_Syokunin();
    //public Jyougehyou_Syokunin(ap ap0){ orihime_ap=ap0;    reset();	}    //コンストラクタ

    public Camera camera_of_oriagarizu = new Camera();
    public Camera camera_of_oriagari_omote = new Camera();
    public Camera camera_of_oriagari_ura = new Camera();
    public Camera camera_of_touka_omote = new Camera();
    public Camera camera_of_touka_ura = new Camera();

    public Color oriagarizu_F_color = new Color(255, 255, 50);//?ﾜり?繧ｪり?}の表面の?F
    public Color oriagarizu_B_color = new Color(233, 233, 233);//?ﾜり?繧ｪり?}の裏面の?F
    public Color oriagarizu_L_color = Color.black;//?ﾜり?繧ｪり?}の??の?F

    public int hyouji_flg_backup = 4;//表示様式hyouji_flgの一時的バックアップ用
    //int hyouji_flg_backup=4;//表示様式hyouji_flgの一時的バックアップ用
    public int hyouji_flg = 0;//?ﾜり?繧ｪり?}の表示様式の指定?B1なら展開?}?ｮ???A2なら?j金?}?B3なら透過?}?B4なら実?ﾛに?ﾜり紙を?ﾜった???№ﾆ同じ?B
    public int i_suitei_meirei = 0;//?ﾜり?ﾝ??定をどの段階まで?sうかの指示
    public int i_suitei_dankai = 0;//?ﾜり?ﾝ??定がどの段階までできたかの表示
    //public int i_suitei_jissi_umu=0;//int i_suitei_jissi_umuは?A?ﾜり?ﾝ??定の計算を実施したかどうかを表す?Bint i_suitei_jissi_umu=0なら実施しない?B1なら実施した?B


    //表示用の値を格納する変??
    public int ip1 = -1;//?繪ｺ表?E?lの?炎??ﾝ定時に?A?ﾜった後の表裏が同じ面が
    //隣?ﾚするという誤?ｷがあれが0を?A無ければ1000を格納する変???B
    //ここでの?炎咊lは(0か1000)以外の?狽ﾈらなんでもいい?B
    public int ip2 = -1;//?繪ｺ表?E?lが?ﾜり?ﾝ可能な?dなり方を探した?ﾛに?A
    //可能な?dなり方がなければ0を?A可能な?dなり方があれば1000を格納する変???B
    //ここでの?炎咊lは(0か1000)以外の?狽ﾈらなんでもいい?B
    //int ip3a=1;
    public int ip3 = 1;//ts1が?ﾜり?ﾝを?sう?ﾛの基??面を指定するのに使う?B

    public int ip4 = 0;//これは?Ats1の?ﾅ?奄ﾉ裏返しをするかどうかを指定する?B0ならしない?B1なら裏返す?B

    public int ip5 = -1;    //?繪ｺ表?E?lが一旦?ﾜり?ﾝ可能な紙の?dなりを示したあとで?A
    //さらに別の紙の?dなりをさがす時の?ﾅ?奄ﾌjs.susumu(Smensuu)の結果?B
    //0なら?Vたにsusumu余地がなかった?B0以外なら変化したSmenのidの?ﾅも?ｬさい番??

    public int ip6 = -1;    //?繪ｺ表?E?lが一旦?ﾜり?ﾝ可能な紙の?dなりを示したあとで?A
    //さらに別の紙の?dなりをさがす時の js.kanou_kasanari_sagasi()の結果?B
    //0なら可能な?dなりかたとなる?ﾔは存?ﾝしない?B
    //1000なら別の?dなり方が見つかった?B

    public int betu_sagasi_flg = 0;     //これは?u別の?dなりを探す?vことが有効の???№ﾍ１?A無効の???№ﾍ０をとる?B
    public int hakkenn_sita_kazu = 0;    //?ﾜり?dなり方で?A何通り発見したかを格納する?B


    //public int i_AS_matome =100;//?ﾜ?ﾝ??定の別解をまとめて?oす個??//20171217 ver3.030では使われていない?B


    public int toukazu_toukado = 16;//透過?}をカラ?[描画する?ﾛの透過度


    public int i_oriagari_sousa_mode = 1;//1=変形時は?j金?}になり?A変形後に?繪ｺ表を?ﾄ計算する?A旧来からのモ?[ド?A2=変形時も?ﾜり?繧ｪり?}のままで?A基本的に変形後に?繪ｺ表は?ﾄ計算しないモ?[ド


    //public Keijiban keijiban =new Keijiban(this);
    public Keijiban keijiban;


    public boolean w_image_jikkoutyuu = false;//?ﾜ?ﾝまとめ実?sの?B単一回のイ???[ジ?曹ｫ?oしが実?s中ならtureになる?B
    public boolean matome_write_image_jikkoutyuu = false;//matome_write_imageが実?s中ならtureになる?Bこれは?A複?狽ﾌ?ﾜりあがり形の予測の?曹ｫ?oしがかすれないように使う?B20170613

    String fname_and_number;//まとめ?曹ｫ?oしに使う?B


    //各種変?狽ﾌ定義
    String c = "";                //文字列????用のクラスのインスタンス化
    public String text_kekka = "";                //結果表示用文字列のクラスのインスタンス化


    int i_fold_type = 0;//=0は通?墲ﾌ展開?}の全?ﾜ??を対?ﾛとした?ﾜり?ﾝ??定?A=1はselectされた?ﾜ??を対?ﾛとした?ﾜり?ﾝ??定?A


    public int i_toukazu_color = 0;//透過?}をカラ?[にするなら１?Aしないなら０


    // **************************************************
//コンストラクタ
    public Oriagari_Zu(ap ap0) {

        orihime_ap = ap0;

        js = new Jyougehyou_Syokunin(ap0);
        keijiban = new Keijiban(ap0);

        //カ??ラの?ﾝ定 ------------------------------------------------------------------
        oriagari_camera_syokika();
        //カ??ラの?ﾝ定はここまで----------------------------------------------------


        text_kekka = "";


    }

    //----------------------------------------------------------
    public void suitei_syokika() {
        text_kekka = "";
        ks2.reset();
        ts1.reset();
        ts2.reset();
        ts3.reset();
        js.reset();

        //oriagari_camera_syokika();		//20170615 実?sしないようにした?i?ﾜりあがり?}の表示?ｵを変えないようにするため?j
        //ts2.setCamera(camera_of_oriagarizu);	//20170615 実?sしないようにした?i?ﾜりあがり?}の表示?ｵを変えないようにするため?j
        //js.setCamera(camera_of_oriagarizu);	//20170615 実?sしないようにした?i?ﾜりあがり?}の表示?ｵを変えないようにするため?j

        hyouji_flg = 0;//?ﾜり?繧ｪり?}の表示様式の指定?B1なら展開?}?ｮ???A2なら?j金?}?B3なら透過?}?B5なら実?ﾛに?ﾜり紙を?ﾜった???№ﾆ同じ?B
        i_suitei_meirei = 0;//?ﾜり?ﾝ??定をどの段階まで?sうかの指示
        i_suitei_dankai = 0;//?ﾜり?ﾝ??定がどの段階までできたかの表示
        betu_sagasi_flg = 0;

        matome_write_image_jikkoutyuu = false; //複?狽ﾌ?ﾜりあがり形の予測の?曹ｫ?oしがが実?s中ならtureになる?B20170615


    }


    //----------------------------------------------------------
    public void oriagari_camera_syokika() {


        //camera_of_oriagarizu	;
        camera_of_oriagarizu.set_camera_ichi_x(0.0);
        camera_of_oriagarizu.set_camera_ichi_y(0.0);
        camera_of_oriagarizu.set_camera_kakudo(0.0);
        camera_of_oriagarizu.set_camera_kagami(1.0);
        camera_of_oriagarizu.set_camera_bairitsu_x(1.0);
        camera_of_oriagarizu.set_camera_bairitsu_y(1.0);
        camera_of_oriagarizu.set_hyouji_ichi_x(350.0);
        camera_of_oriagarizu.set_hyouji_ichi_y(350.0);


        //camera_of_oriagari_omote	;
        camera_of_oriagari_omote.set_camera_ichi_x(0.0);
        camera_of_oriagari_omote.set_camera_ichi_y(0.0);
        camera_of_oriagari_omote.set_camera_kakudo(0.0);
        camera_of_oriagari_omote.set_camera_kagami(1.0);
        camera_of_oriagari_omote.set_camera_bairitsu_x(1.0);
        camera_of_oriagari_omote.set_camera_bairitsu_y(1.0);
        camera_of_oriagari_omote.set_hyouji_ichi_x(350.0);
        camera_of_oriagari_omote.set_hyouji_ichi_y(350.0);

        //camera_of_oriagari_ura	;
        camera_of_oriagari_ura.set_camera_ichi_x(0.0);
        camera_of_oriagari_ura.set_camera_ichi_y(0.0);
        camera_of_oriagari_ura.set_camera_kakudo(0.0);
        camera_of_oriagari_ura.set_camera_kagami(-1.0);
        camera_of_oriagari_ura.set_camera_bairitsu_x(1.0);
        camera_of_oriagari_ura.set_camera_bairitsu_y(1.0);
        camera_of_oriagari_ura.set_hyouji_ichi_x(350.0);
        camera_of_oriagari_ura.set_hyouji_ichi_y(350.0);


        //camera_of_touka_omote	;
        camera_of_touka_omote.set_camera_ichi_x(0.0);
        camera_of_touka_omote.set_camera_ichi_y(0.0);
        camera_of_touka_omote.set_camera_kakudo(0.0);
        camera_of_touka_omote.set_camera_kagami(1.0);
        camera_of_touka_omote.set_camera_bairitsu_x(1.0);
        camera_of_touka_omote.set_camera_bairitsu_y(1.0);
        camera_of_touka_omote.set_hyouji_ichi_x(350.0);
        camera_of_touka_omote.set_hyouji_ichi_y(350.0);

        //camera_of_touka_ura	;
        camera_of_touka_ura.set_camera_ichi_x(0.0);
        camera_of_touka_ura.set_camera_ichi_y(0.0);
        camera_of_touka_ura.set_camera_kakudo(0.0);
        camera_of_touka_ura.set_camera_kagami(-1.0);
        camera_of_touka_ura.set_camera_bairitsu_x(1.0);
        camera_of_touka_ura.set_camera_bairitsu_y(1.0);
        camera_of_touka_ura.set_hyouji_ichi_x(350.0);
        camera_of_touka_ura.set_hyouji_ichi_y(350.0);


    }

    // ------------------------------------------------------------------------------------------
    public void oriagari_oekaki(Graphics bufferGraphics, int i_mejirusi_hyouji) {

        //hyouji_flg==2,ip4==0  omote
        //hyouji_flg==2,ip4==1	ura
        //hyouji_flg==2,ip4==2	omote & ura
        //hyouji_flg==2,ip4==3	omote & ura

        //hyouji_flg==3,ip4==0  omote
        //hyouji_flg==3,ip4==1	ura
        //hyouji_flg==3,ip4==2	omote & ura
        //hyouji_flg==3,ip4==3	omote & ura

        //hyouji_flg==5,ip4==0  omote
        //hyouji_flg==5,ip4==1	ura
        //hyouji_flg==5,ip4==2	omote & ura
        //hyouji_flg==5,ip4==3	omote & ura & omote2 & ura2


        //?ﾜり?繧ｪり?}の表示はjsが?sうので表示自体はts2にカ??ラをセットする必要はないが?Aその後?A画面クリックをts2が判定したりするのでts2のカ??ラ?X?Vは表示と同期して?sう必要がある?B
        ts2.setCamera(camera_of_oriagarizu);
        ts2.setCam_omote(camera_of_oriagari_omote);
        ts2.setCam_ura(camera_of_oriagari_ura);
        ts2.setCam_touka_omote(camera_of_touka_omote);
        ts2.setCam_touka_ura(camera_of_touka_ura);


        //?j金?}の表示
        //System.out.println("paint?@+++++++++++++++++++++?@?j金?}の表示");
        if (hyouji_flg == 2) {
            ts2.oekaki_with_camera(bufferGraphics, ip4);//?ﾜり?繧ｪり?}の操??はこのts2の?j金?}を動かす?B
        }

        //?ﾜりあがり?}?i表?jの表示
        if (((ip4 == 0) || (ip4 == 2)) || (ip4 == 3)) {
            js.setCamera(camera_of_oriagari_omote);

            //透過?}の表示
            //System.out.println("paint?@+++++++++++++++++++++?@透過?}の表示");
            if (hyouji_flg == 3) {        // hyouji_flg;?ﾜり?繧ｪり?}の表示様式の指定?B１なら実?ﾛに?ﾜり紙を?ﾜった???№ﾆ同じ?B２なら透過?}?B3なら?j金?}?B
                js.oekaki_toukazu_with_camera(bufferGraphics, ts1, ts2.get(), ts3.get(), i_toukazu_color, toukazu_toukado);
            }

            //?ﾜり?繧ｪり?}の表示************* //System.out.println("paint?@+++++++++++++++++++++?@?ﾜり?繧ｪり?}の表示");
            if (hyouji_flg == 5) {
                js.oekaki_oriagarizu_with_camera(bufferGraphics, ts1, ts2.get(), ts3.get());// hyouji_flg;?ﾜり?繧ｪり?}の表示様式の指定?B5なら実?ﾛに?ﾜり紙を?ﾜった???№ﾆ同じ?B3なら透過?}?B2なら?j金?}?B
            }

            //?ﾜり?繧ｪり?}の動かし中?Sの?\字表示
            //System.out.println("paint?@+++++++++++++++++++++?@?ﾜり?繧ｪり?}の動かし中?Sの?\字表示)");
            if (i_mejirusi_hyouji == 1) {
                js.oekaki_jyuuji_with_camera(bufferGraphics);
            }
        }

        //?ﾜりあがり?}?i裏?jの表示
        if (((ip4 == 1) || (ip4 == 2)) || (ip4 == 3)) {
            camera_of_oriagari_ura.hyouji();
            js.setCamera(camera_of_oriagari_ura);

            //透過?}の表示
            //System.out.println("paint?@+++++++++++++++++++++?@透過?}の表示");
            if (hyouji_flg == 3) {        // hyouji_flg;?ﾜり?繧ｪり?}の表示様式の指定?B１なら実?ﾛに?ﾜり紙を?ﾜった???№ﾆ同じ?B２なら透過?}?B3なら?j金?}?B
                js.oekaki_toukazu_with_camera(bufferGraphics, ts1, ts2.get(), ts3.get(), i_toukazu_color, toukazu_toukado);
            }

            //?ﾜり?繧ｪり?}の表示************* //System.out.println("paint?@+++++++++++++++++++++?@?ﾜり?繧ｪり?}の表示");
            if (hyouji_flg == 5) {
                js.oekaki_oriagarizu_with_camera(bufferGraphics, ts1, ts2.get(), ts3.get());// hyouji_flg;?ﾜり?繧ｪり?}の表示様式の指定?B5なら実?ﾛに?ﾜり紙を?ﾜった???№ﾆ同じ?B3なら透過?}?B2なら?j金?}?B
            }

            //?ﾜり?繧ｪり?}の動かし中?Sの?\字表示
            //System.out.println("paint?@+++++++++++++++++++++?@?ﾜり?繧ｪり?}の動かし中?Sの?\字表示)");
            if (i_mejirusi_hyouji == 1) {
                js.oekaki_jyuuji_with_camera(bufferGraphics);
            }
        }

        //透過?}?i?ﾜりあがり?}表示時に追加する分?j
        if ((ip4 == 3) && (hyouji_flg == 5)) {
            // ---------------------------------------------------------------------------------
            js.setCamera(camera_of_touka_omote);
            //透過?}の表示
            //System.out.println("paint?@+++++++++++++++++++++?@透過?}の表示");
            js.oekaki_toukazu_with_camera(bufferGraphics, ts1, ts2.get(), ts3.get(), i_toukazu_color, toukazu_toukado);

            //?ﾜり?繧ｪり?}の動かし中?Sの?\字表示
            //System.out.println("paint?@+++++++++++++++++++++?@?ﾜり?繧ｪり?}の動かし中?Sの?\字表示)");
            if (i_mejirusi_hyouji == 1) {
                js.oekaki_jyuuji_with_camera(bufferGraphics);
            }

            // ---------------------------------------------------------------------------------
            js.setCamera(camera_of_touka_ura);

            //透過?}の表示
            //System.out.println("paint?@+++++++++++++++++++++?@透過?}の表示");
            js.oekaki_toukazu_with_camera(bufferGraphics, ts1, ts2.get(), ts3.get(), i_toukazu_color, toukazu_toukado);

            //?ﾜり?繧ｪり?}の動かし中?Sの?\字表示
            //System.out.println("paint?@+++++++++++++++++++++?@?ﾜり?繧ｪり?}の動かし中?Sの?\字表示)");
            if (i_mejirusi_hyouji == 1) {
                js.oekaki_jyuuji_with_camera(bufferGraphics);
            }
            // ---------------------------------------------------------------------------------
        }


        //?ﾜり?繧ｪり?}動かし時の?j金?}と展開?}?繧ﾌ対応点の表示


        for (int i = 1; i <= ts1.getTensuu(); i++) {
            if (ts1.get_ten_sentaku(i) == 1) {
                ts1.oekaki_Ten_id_with_camera(bufferGraphics, i);
                //	ts2.oekaki_Ten_id_with_camera(bufferGraphics,i,ip4);
            }
        }


        for (int i = 1; i <= ts2.getTensuu(); i++) {
            if (ts2.get_ten_sentaku(i) == 1) {
                ts1.oekaki_Ten_id_with_camera_green(bufferGraphics, i);
                ts2.oekaki_Ten_id_with_camera(bufferGraphics, i, ip4);
            }
        }


    }


    // -------------------------------------------------------
    public void set_syukusyaku(double d0) {
        d_oriagarizu_syukusyaku_keisuu = d0;
    }//?ﾜり?繧ｪり?}の?k尺係??

    public double get_syukusyaku() {
        return d_oriagarizu_syukusyaku_keisuu;
    }//?ﾜり?繧ｪり?}の?k尺係??

    public void set_kaiten(double d0) {
        d_oriagarizu_kaiten_hosei = d0;
    }//?ﾜり?繧ｪり?}の回転表示角度の補?ｳ角度

    public double get_kaiten() {
        return d_oriagarizu_kaiten_hosei;
    }//?ﾜり?繧ｪり?}の回転表示角度の補?ｳ角度

//mmmmmmm

    //---------------------------------------------------------

    //public Memo getMemo_for_svg_kakidasi(){
    //	return js.getMemo_for_svg_kakidasi() ;
    //}

    public Memo getMemo_for_svg_kakidasi() {

        Memo memo_temp = new Memo();

        //?j金?}のsvg
        //System.out.println("paint?@+++++++++++++++++++++?@?j金?}の表示");
        if (hyouji_flg == 2) {
            //ts2.oekaki_with_camera(bufferGraphics,ip4);//?ﾜり?繧ｪり?}の操??はこのts2の?j金?}を動かす?B

//System.out.println("getMemo_hariganezu_for_svg_kakidasi?@?j金?}のsvg");
            memo_temp.addMemo(js.getMemo_hariganezu_for_svg_kakidasi(ts1, ts2.get(), ts3.get(), 0));//４番目の?ｮ?狽ﾍ０なら面の枠のみ?A１なら面を塗る


        }

        //?ﾜりあがり?}?i表?jのsvg
        if (((ip4 == 0) || (ip4 == 2)) || (ip4 == 3)) {
            js.setCamera(camera_of_oriagari_omote);

            //透過?}のsvg
            //System.out.println("paint?@+++++++++++++++++++++?@透過?}の表示");
            if (hyouji_flg == 3) {        // hyouji_flg;?ﾜり?繧ｪり?}の表示様式の指定?B１なら実?ﾛに?ﾜり紙を?ﾜった???№ﾆ同じ?B２なら透過?}?B3なら?j金?}?B
                memo_temp.addMemo(js.getMemo_hariganezu_for_svg_kakidasi(ts1, ts2.get(), ts3.get(), 1));
            }

            //?ﾜり?繧ｪり?}のsvg************* //System.out.println("paint?@+++++++++++++++++++++?@?ﾜり?繧ｪり?}の表示");
            if (hyouji_flg == 5) {
                //js.oekaki_oriagarizu_with_camera(bufferGraphics,ts1,ts2.get(),ts3.get());// hyouji_flg;?ﾜり?繧ｪり?}の表示様式の指定?B5なら実?ﾛに?ﾜり紙を?ﾜった???№ﾆ同じ?B3なら透過?}?B2なら?j金?}?B
                memo_temp.addMemo(js.getMemo_for_svg_with_camera(ts1, ts2.get(), ts3.get()));// hyouji_flg;?ﾜり?繧ｪり?}の表示様式の指定?B5なら実?ﾛに?ﾜり紙を?ﾜった???№ﾆ同じ?B3なら透過?}?B2なら?j金?}?B

            }
        }

        //?ﾜりあがり?}?i裏?jのsvg
        if (((ip4 == 1) || (ip4 == 2)) || (ip4 == 3)) {

            js.setCamera(camera_of_oriagari_ura);

            //透過?}のsvg
            //System.out.println("paint?@+++++++++++++++++++++?@透過?}の表示");
            if (hyouji_flg == 3) {        // hyouji_flg;?ﾜり?繧ｪり?}の表示様式の指定?B１なら実?ﾛに?ﾜり紙を?ﾜった???№ﾆ同じ?B２なら透過?}?B3なら?j金?}?B
                memo_temp.addMemo(js.getMemo_hariganezu_for_svg_kakidasi(ts1, ts2.get(), ts3.get(), 1));
            }

            //?ﾜり?繧ｪり?}のsvg************* //System.out.println("paint?@+++++++++++++++++++++?@?ﾜり?繧ｪり?}の表示");
            if (hyouji_flg == 5) {
                //js.oekaki_oriagarizu_with_camera(bufferGraphics,ts1,ts2.get(),ts3.get());// hyouji_flg;?ﾜり?繧ｪり?}の表示様式の指定?B5なら実?ﾛに?ﾜり紙を?ﾜった???№ﾆ同じ?B3なら透過?}?B2なら?j金?}?B
                memo_temp.addMemo(js.getMemo_for_svg_with_camera(ts1, ts2.get(), ts3.get()));// hyouji_flg;?ﾜり?繧ｪり?}の表示様式の指定?B5なら実?ﾛに?ﾜり紙を?ﾜった???№ﾆ同じ?B3なら透過?}?B2なら?j金?}?B

            }


        }

        //透過?}?i?ﾜりあがり?}表示時に追加する分?j
        if ((ip4 == 3) && (hyouji_flg == 5)) {
            // ---------------------------------------------------------------------------------
            js.setCamera(camera_of_touka_omote);
            //透過?}のsvg
            //System.out.println("paint?@+++++++++++++++++++++?@透過?}の表示");

            //js.oekaki_toukazu_with_camera(bufferGraphics,ts1,ts2.get(),ts3.get());
            //js.getMemo_toukazu_with_camera(bufferGraphics,ts1,ts2.get(),ts3.get());


            // ---------------------------------------------------------------------------------
            js.setCamera(camera_of_touka_ura);

            //透過?}のsvg
            //System.out.println("paint?@+++++++++++++++++++++?@透過?}の表示");

            //js.oekaki_toukazu_with_camera(bufferGraphics,ts1,ts2.get(),ts3.get());
            //js.getMemo_toukazu_with_camera(bufferGraphics,ts1,ts2.get(),ts3.get());

            // ---------------------------------------------------------------------------------
        }
        return memo_temp;

    }


//-----------------------------------

    void oritatami_suitei_camera_settei(Camera camera_of_orisen_nyuuryokuzu, Senbunsyuugou Ss0) {


        d_oriagarizu_syukusyaku_keisuu = camera_of_orisen_nyuuryokuzu.get_camera_bairitsu_x();
        orihime_ap.text29.setText(String.valueOf(d_oriagarizu_syukusyaku_keisuu));
        orihime_ap.text29.setCaretPosition(0);

        d_oriagarizu_kaiten_hosei = camera_of_orisen_nyuuryokuzu.get_camera_kakudo();
        orihime_ap.text30.setText(String.valueOf(d_oriagarizu_kaiten_hosei));
        orihime_ap.text30.setCaretPosition(0);


        System.out.println("ts1.ten_of_kijyunmen_ob     " + ts1.ten_of_kijyunmen_ob.getx());
//Ten p =new Ten();p.set(ts1.ten_of_kijyunmen_ob);
//Ten p0 =new Ten();p0.set(camera_of_orisen_nyuuryokuzu.object2TV(p));

        Ten p0 = new Ten();
        Ten p = new Ten();


        p.set(ts1.ten_of_kijyunmen_ob);
        p0.set(camera_of_orisen_nyuuryokuzu.object2TV(p));


        double d_camera_ichi_x = p.getx();
        double d_camera_ichi_y = p.gety();
        double d_hyouji_ichi_x = p0.getx();
        double d_hyouji_ichi_y = p0.gety();
        //double d_hyouji_ichi_x=camera_of_orisen_nyuuryokuzu.get_hyouji_ichi_x();
        //double d_hyouji_ichi_y=camera_of_orisen_nyuuryokuzu.get_hyouji_ichi_y();


        camera_of_oriagarizu.set_camera(camera_of_orisen_nyuuryokuzu);
        camera_of_oriagarizu.set_camera_ichi_x(d_camera_ichi_x);
        camera_of_oriagarizu.set_camera_ichi_y(d_camera_ichi_y);
        camera_of_oriagarizu.set_hyouji_ichi_x(d_hyouji_ichi_x + 20.0);
        camera_of_oriagarizu.set_hyouji_ichi_y(d_hyouji_ichi_y + 20.0);

        camera_of_oriagari_omote.set_camera(camera_of_orisen_nyuuryokuzu);
        camera_of_oriagari_omote.set_camera_ichi_x(d_camera_ichi_x);
        camera_of_oriagari_omote.set_camera_ichi_y(d_camera_ichi_y);
        camera_of_oriagari_omote.set_hyouji_ichi_x(d_hyouji_ichi_x + 20.0);
        camera_of_oriagari_omote.set_hyouji_ichi_y(d_hyouji_ichi_y + 20.0);

        camera_of_oriagari_ura.set_camera(camera_of_orisen_nyuuryokuzu);
        camera_of_oriagari_ura.set_camera_ichi_x(d_camera_ichi_x);
        camera_of_oriagari_ura.set_camera_ichi_y(d_camera_ichi_y);
        camera_of_oriagari_ura.set_hyouji_ichi_x(d_hyouji_ichi_x + 40.0);
        camera_of_oriagari_ura.set_hyouji_ichi_y(d_hyouji_ichi_y + 20.0);

        camera_of_touka_omote.set_camera(camera_of_orisen_nyuuryokuzu);
        camera_of_touka_omote.set_camera_ichi_x(d_camera_ichi_x);
        camera_of_touka_omote.set_camera_ichi_y(d_camera_ichi_y);
        camera_of_touka_omote.set_hyouji_ichi_x(d_hyouji_ichi_x + 20.0);
        camera_of_touka_omote.set_hyouji_ichi_y(d_hyouji_ichi_y + 0.0);

        camera_of_touka_ura.set_camera(camera_of_orisen_nyuuryokuzu);
        camera_of_touka_ura.set_camera_ichi_x(d_camera_ichi_x);
        camera_of_touka_ura.set_camera_ichi_y(d_camera_ichi_y);
        camera_of_touka_ura.set_hyouji_ichi_x(d_hyouji_ichi_x + 40.0);
        camera_of_touka_ura.set_hyouji_ichi_y(d_hyouji_ichi_y + 0.0);

        double d_camera_kagami = camera_of_oriagari_ura.get_camera_kagami();
        camera_of_oriagari_ura.set_camera_kagami(d_camera_kagami * -1.0);
        camera_of_touka_ura.set_camera_kagami(d_camera_kagami * -1.0);


    }

    //-----------------------------------
    public void oritatami_suitei(Camera camera_of_orisen_nyuuryokuzu, Senbunsyuugou Ss0) {//?ﾜ?ﾝ予測の?ﾅ?奄ﾉ?Ats1.Senbunsyuugou2Tensyuugou(Ss0)として使う?B?@Ss0は?Aes1.get_for_oritatami()かes1.get_for_select_oritatami()で得る?B


        int i_camera_settei = 0;


        //-------------------------------?ﾜり?繧ｪり?}表示用カ??ラの?ﾝ定

        if ((i_suitei_dankai == 0) && (i_suitei_meirei <= 5)) {
            i_camera_settei = 1;


        }

        if (i_suitei_meirei == 51) {
            i_suitei_meirei = 5;
        }


        //-------------------------------

        if ((i_suitei_dankai == 0) && (i_suitei_meirei == 1)) {
            suitei_syokika();
            oritatami_suitei_01(Ss0);
            i_suitei_dankai = 1;
            hyouji_flg = 1;
        } else if ((i_suitei_dankai == 0) && (i_suitei_meirei == 2)) {
            suitei_syokika();
            oritatami_suitei_01(Ss0);
            i_suitei_dankai = 1;
            hyouji_flg = 1;
            oritatami_suitei_02();
            i_suitei_dankai = 2;
            hyouji_flg = 2;
        } else if ((i_suitei_dankai == 0) && (i_suitei_meirei == 3)) {
            suitei_syokika();
            oritatami_suitei_01(Ss0);
            i_suitei_dankai = 1;
            hyouji_flg = 1;
            oritatami_suitei_02();
            i_suitei_dankai = 2;
            hyouji_flg = 2;
            oritatami_suitei_03();
            i_suitei_dankai = 3;
            hyouji_flg = 3;
        } else if ((i_suitei_dankai == 0) && (i_suitei_meirei == 5)) {
            suitei_syokika();
            oritatami_suitei_01(Ss0);
            i_suitei_dankai = 1;
            hyouji_flg = 1;
            oritatami_suitei_02();
            i_suitei_dankai = 2;
            hyouji_flg = 2;
            oritatami_suitei_03();
            i_suitei_dankai = 3;
            hyouji_flg = 3;
            oritatami_suitei_04();
            i_suitei_dankai = 4;
            hyouji_flg = 4;
            oritatami_suitei_05();
            i_suitei_dankai = 5;
            hyouji_flg = 5;
            if ((hakkenn_sita_kazu == 0) && (betu_sagasi_flg == 0)) {
                i_suitei_dankai = 3;
                hyouji_flg = 3;
            }
        } else if ((i_suitei_dankai == 1) && (i_suitei_meirei == 1)) {
        } else if ((i_suitei_dankai == 1) && (i_suitei_meirei == 2)) {
            oritatami_suitei_02();
            i_suitei_dankai = 2;
            hyouji_flg = 2;
        } else if ((i_suitei_dankai == 1) && (i_suitei_meirei == 3)) {
            oritatami_suitei_02();
            i_suitei_dankai = 2;
            hyouji_flg = 2;
            oritatami_suitei_03();
            i_suitei_dankai = 3;
            hyouji_flg = 3;
        } else if ((i_suitei_dankai == 1) && (i_suitei_meirei == 5)) {
            oritatami_suitei_02();
            i_suitei_dankai = 2;
            hyouji_flg = 2;
            oritatami_suitei_03();
            i_suitei_dankai = 3;
            hyouji_flg = 3;
            oritatami_suitei_04();
            i_suitei_dankai = 4;
            hyouji_flg = 4;
            oritatami_suitei_05();
            i_suitei_dankai = 5;
            hyouji_flg = 5;
            if ((hakkenn_sita_kazu == 0) && (betu_sagasi_flg == 0)) {
                i_suitei_dankai = 3;
                hyouji_flg = 3;
            }
        } else if ((i_suitei_dankai == 2) && (i_suitei_meirei == 1)) {
        } else if ((i_suitei_dankai == 2) && (i_suitei_meirei == 2)) {
        } else if ((i_suitei_dankai == 2) && (i_suitei_meirei == 3)) {
            oritatami_suitei_03();
            i_suitei_dankai = 3;
            hyouji_flg = 3;
        } else if ((i_suitei_dankai == 2) && (i_suitei_meirei == 5)) {
            oritatami_suitei_03();
            i_suitei_dankai = 3;
            hyouji_flg = 3;
            oritatami_suitei_04();
            i_suitei_dankai = 4;
            hyouji_flg = 4;
            oritatami_suitei_05();
            i_suitei_dankai = 5;
            hyouji_flg = 5;
            if ((hakkenn_sita_kazu == 0) && (betu_sagasi_flg == 0)) {
                i_suitei_dankai = 3;
                hyouji_flg = 3;
            }
        } else if ((i_suitei_dankai == 3) && (i_suitei_meirei == 1)) {
        } else if ((i_suitei_dankai == 3) && (i_suitei_meirei == 2)) {
            hyouji_flg = 2;
        } else if ((i_suitei_dankai == 3) && (i_suitei_meirei == 3)) {
            hyouji_flg = 3;
        } else if ((i_suitei_dankai == 3) && (i_suitei_meirei == 5)) {
            oritatami_suitei_04();
            i_suitei_dankai = 4;
            hyouji_flg = 4;
            oritatami_suitei_05();
            i_suitei_dankai = 5;
            hyouji_flg = 5;
            if ((hakkenn_sita_kazu == 0) && (betu_sagasi_flg == 0)) {
                i_suitei_dankai = 3;
                hyouji_flg = 3;
            }
        } else if ((i_suitei_dankai == 5) && (i_suitei_meirei == 1)) {
        } else if ((i_suitei_dankai == 5) && (i_suitei_meirei == 2)) {
            hyouji_flg = 2;
        } else if ((i_suitei_dankai == 5) && (i_suitei_meirei == 3)) {
            hyouji_flg = 3;
        } else if ((i_suitei_dankai == 5) && (i_suitei_meirei == 5)) {
            hyouji_flg = 5;
        } else if ((i_suitei_dankai == 5) && (i_suitei_meirei == 6)) {
            oritatami_suitei_05();
            i_suitei_dankai = 5;
            hyouji_flg = 5;
        }


        if (i_camera_settei == 1) {
            oritatami_suitei_camera_settei(camera_of_orisen_nyuuryokuzu, Ss0);
        }


    }

    //--------------------------------------------------------------------------
    public void oritatami_suitei_2col(Camera camera_of_orisen_nyuuryokuzu, Senbunsyuugou Ss0) {//２?F塗りわけ展開?}

        //-------------------------------?ﾜり?繧ｪり?}表示用カ??ラの?ﾝ定

        //	if( (i_suitei_dankai==0)&&(i_suitei_meirei<=5) ){

        d_oriagarizu_syukusyaku_keisuu = camera_of_orisen_nyuuryokuzu.get_camera_bairitsu_x();
        orihime_ap.text29.setText(String.valueOf(d_oriagarizu_syukusyaku_keisuu));
        orihime_ap.text29.setCaretPosition(0);

        d_oriagarizu_kaiten_hosei = camera_of_orisen_nyuuryokuzu.get_camera_kakudo();
        orihime_ap.text30.setText(String.valueOf(d_oriagarizu_kaiten_hosei));
        orihime_ap.text30.setCaretPosition(0);

        double d_hyouji_ichi_x = camera_of_orisen_nyuuryokuzu.get_hyouji_ichi_x();
        double d_hyouji_ichi_y = camera_of_orisen_nyuuryokuzu.get_hyouji_ichi_y();

        camera_of_oriagarizu.set_camera(camera_of_orisen_nyuuryokuzu);
        camera_of_oriagarizu.set_hyouji_ichi_x(d_hyouji_ichi_x + 20.0);
        camera_of_oriagarizu.set_hyouji_ichi_y(d_hyouji_ichi_y + 20.0);

        camera_of_oriagari_omote.set_camera(camera_of_orisen_nyuuryokuzu);
        camera_of_oriagari_omote.set_hyouji_ichi_x(d_hyouji_ichi_x + 20.0);
        camera_of_oriagari_omote.set_hyouji_ichi_y(d_hyouji_ichi_y + 20.0);

        camera_of_oriagari_ura.set_camera(camera_of_orisen_nyuuryokuzu);
        camera_of_oriagari_ura.set_hyouji_ichi_x(d_hyouji_ichi_x + 40.0);
        camera_of_oriagari_ura.set_hyouji_ichi_y(d_hyouji_ichi_y + 20.0);

        camera_of_touka_omote.set_camera(camera_of_orisen_nyuuryokuzu);
        camera_of_touka_omote.set_hyouji_ichi_x(d_hyouji_ichi_x + 20.0);
        camera_of_touka_omote.set_hyouji_ichi_y(d_hyouji_ichi_y + 0.0);

        camera_of_touka_ura.set_camera(camera_of_orisen_nyuuryokuzu);
        camera_of_touka_ura.set_hyouji_ichi_x(d_hyouji_ichi_x + 40.0);
        camera_of_touka_ura.set_hyouji_ichi_y(d_hyouji_ichi_y + 0.0);

        double d_camera_kagami = camera_of_oriagari_ura.get_camera_kagami();
        camera_of_oriagari_ura.set_camera_kagami(d_camera_kagami * -1.0);
        camera_of_touka_ura.set_camera_kagami(d_camera_kagami * -1.0);
        //	}

        //-------------------------------
        suitei_syokika();
        oritatami_suitei_01(Ss0);
        i_suitei_dankai = 1;
        hyouji_flg = 1;
        oritatami_suitei_02col();
        i_suitei_dankai = 2;
        hyouji_flg = 2;
        oritatami_suitei_03();
        i_suitei_dankai = 3;
        hyouji_flg = 3;
        oritatami_suitei_04();
        i_suitei_dankai = 4;
        hyouji_flg = 4;
        oritatami_suitei_05();
        i_suitei_dankai = 5;
        hyouji_flg = 5;
        i_suitei_dankai = 10;
        //if((OZ.hakkenn_sita_kazu==0)&&(OZ.betu_sagasi_flg==0)){ OZ.i_suitei_dankai=3; OZ.hyouji_flg=3;}

        //return 1000;
    }
//-----------------------------------


    //-------------------------------bbbbbbb----
    public int oritatami_suitei_01(Senbunsyuugou Ss1) {
        System.out.println("?????????バritatami_suitei_01;開始");
        keijiban.tuiki("<<<<oritatami_suitei_01;  start");
        //マウスの入力でes1の中に??った??分?W?№s1に渡し?A点?W??(展開?}に相当)にする
        ts1.Senbunsyuugou2Tensyuugou(Ss1);
        ip3 = ts1.set_kijyunmen_id(ip3);
        ip3 = ts1.set_kijyunmen_id(orihime_ap.ten_of_kijyunmen_old);//20180222?ﾜり??選択?ﾔで?ﾜり?ﾝ??定をする?ﾛ?A以前に指定されていた基??面を引き継ぐために追加

        return 1000;
    }


    //-----------------------------------
    public int oritatami_suitei_02() {
        System.out.println("?????????バritatami_suitei_02;開始");
        keijiban.tuiki("<<<<oritatami_suitei_02;  start");
        //ts1が?ﾜりたたみを?sい?Aできた?j金?}をts2に渡す?B
        //ts2が?ﾜりあがった形を?ｭしだけ変形したいような???№ﾉ働く?B
        ts2.set(ts1.oritatami());
        orihime_ap.keijiban.tuiki("<<<<oritatami_suitei_02; end");

        //ts2.Iti_sitei(0.0 , 0.0);点?W?№ﾌ平均位置を全点の?d?Sにする?B
        //  if(ip4==1){ ts2.uragaesi();}
        // ts2.set( ts2.oritatami())  ;//?ﾜり?ｾ?j金?}を?A?ﾜり開きたい???№ﾌ操??
        //ここまでで?j金?}はできていて?Ats2が??っている?Bこれは?Aマウスで操???A変形できる?B
        return 1000;
    }

    //-----------------------------------
    public int oritatami_suitei_02col() {//20171225?@２?F塗りわけをするための特別??定?i?ﾜり?ﾝ位置を??定しない?j
        System.out.println("?????????バritatami_suitei_02;開始");
        keijiban.tuiki("<<<<oritatami_suitei_02;  start");
        ts2.set(ts1.men_iti_motome());
        orihime_ap.keijiban.tuiki("<<<<oritatami_suitei_02; end");
        return 1000;
    }

    //-----------------------------------
    public int oritatami_suitei_03() {
        System.out.println("?????????バritatami_suitei_03;開始");
        keijiban.tuiki("<<<<oritatami_suitei_03;  start");
        //ts2は?ﾜる前の展開?}の面を保??した点?W?№?っている?B
        //?ﾜりたたんだ???№ﾌ面の?繪ｺ関係を??定するにはts2の??つ?j金?}に応じて面を
        //?ﾗ分した?i?ﾗ分した面をSmenと言うことにする?j点?W?№gう?B
        //このSmen面に分割した点?W?№ﾍts3が??つようにする?B
        //ts2の??つ点?W?№s3に渡す前に?Ats2の??つ点?W?№ﾍ棒が?dなっていたりするかもしれないので?A
        //いったんks2に渡して??分?W?№ﾆして?ｮ??する?B
        System.out.println("?????????バritatami_suitei_03()_____基本枝?E?lks2はts2から??分?W???i?j金?}からできたもの?jを受け取り?A?ｮ??する?B");
        ks2.set(ts2.getSenbunsyuugou());
        System.out.println("?????????バritatami_suitei_03()_____基本枝?E?lks2がks2.bunkatu_seiri_for_Smen_hassei;実施?B");
        ks2.bunkatu_seiri_for_Smen_hassei();//?dなった??分や交?ｷする??分?ﾜり?ﾝ??定などで得られる?j金?}の?ｮ??
        //展開?}?E?lts3はks2から点?W???its2の??つ?j金?}を?ｮ??したもの?jを受け取り?ASmenに分割する?B
        System.out.println("?????????バritatami_suitei_03()_____展開?}?E?lts3はks2から?ｮ??された??分?W?№ｯ取り?ASmenに分割する?B");
        System.out.println("?@?@?@oritatami_suitei_03()のts3.Senbunsyuugou2Tensyuugou(ks2.get());実施");
        ts3.Senbunsyuugou2Tensyuugou(ks2.get());

        System.out.println("?????????バritatami_suitei_03()_____?繪ｺ表?E?ljsは?A展開?}?E?lts3から点?W?№ｯ取り?ASmenを?ﾝ定する?B");
        js.Smen_settei(ts1, ts2.get(), ts3.get());
        //ここまでで透過?}つくろうと思えば??れる?B透過?}はSmen?}に濃度をつけたもの?B
        return 1000;
    }

    //-----------------------------------
    public int oritatami_suitei_04() {
        System.out.println("?????????バritatami_suitei_04;開始");
        keijiban.tuiki("<<<<oritatami_suitei_04;  start");
        //面(?ﾜりたたむ前の展開?}の面のこと)の?繪ｺ表を??る?B
        //これにはts2の??つ点?W???i?ﾜりたたんだあとの面の位置関係の?﨣?つ?jと
        //ts3の??つ点?W???i?j金?}で面を?ﾗ分割したSmenの?﨣?つ?jを使う?B
        //また?Ats1の??つ?A?ﾜったときの面の位置関係の?﨣燻gう?B
        System.out.println("?????????バritatami_suitei_04()_____?繪ｺ表?E?ljsが面(?ﾜりたたむ前の展開?}の面のこと)の?繪ｺ表を??る?B");

        ip1 = 0;
        betu_sagasi_flg = 0;
        ip1 = js.Jyougehyou_settei(ts1, ts2.get(), ts3.get());   //ip1=?ﾜった後の表裏が同じ面が隣?ﾚするという誤りがあれば0を?A無ければ1000を格納する変???B
        if (ip1 == 1000) {
            ip1 = 1000;
            betu_sagasi_flg = 1;
        }
        hakkenn_sita_kazu = 0;
        System.out.println("?????????バritatami_suitei_04()____?I了");
        return 1000;
    }


    //-----------------------------------
    public int oritatami_suitei_05() {
        System.out.println("?????????バritatami_suitei_05()_____?繪ｺ表?E?ljsがjs.kanou_kasanari_sagasi()実施?B");
        orihime_ap.keijiban.tuiki("<<<<oritatami_suitei_05()  ___js.kanou_kasanari_sagasi()  start");

        if ((i_suitei_dankai == 4) || (i_suitei_dankai == 5)) {
            if (betu_sagasi_flg == 1) {

                ip2 = js.kanou_kasanari_sagasi();//ip2=?繪ｺ表?E?lが?ﾜり?ﾝ可能な?dなり方を探した?ﾛに?A可能な?dなり方がなければ0を?A可能な?dなり方があれば1000を格納する変???B

                if (ip2 == 1000) {
                    hakkenn_sita_kazu = hakkenn_sita_kazu + 1;
                }

                ip5 = js.susumu(js.getSmen_yuukou_suu());//次の?dなり探しの??備//ip5=0なら?Vたにsusumu余地がなかった?B0以外なら変化したSmenのidの?ﾅも?ｬさい番??
            }
        }
        orihime_ap.keijiban.clear();

        text_kekka = "Number of found solutions = " + hakkenn_sita_kazu + "  ";

        betu_sagasi_flg = 0;
        if ((ip2 == 1000) && (ip5 > 0)) {
            betu_sagasi_flg = 1;
        }

        if (betu_sagasi_flg == 0) {
            text_kekka = text_kekka + " There is no other solution. ";
        }

        return 1000;
    }

//int oritatami_suitei_06(){return 1000;}


    public void toukazu_color_sage() {
        toukazu_toukado = toukazu_toukado / 2;
        if (toukazu_toukado < 1) {
            toukazu_toukado = 1;
        }
    }


    public void toukazu_color_age() {
        toukazu_toukado = toukazu_toukado * 2;
        if (toukazu_toukado > 64) {
            toukazu_toukado = 64;
        }
    }    //20180819バグ?C?ｳ?@透過度の?ﾅ大値がこれまで128で?Aプ??グラムで??の描画時に２倍するとく?A256となり?A透過度の?繻ﾀ255オ?[バ?[で?Aオリヒ??自体が
    //フリ?[ズした?Bこれは?A128を127の変えることでもフリ?[ズはなくなるが?A透過度は２の倍?狽ﾉしておかないと?A2分の一にしたとき値がずれるかもしれないので?A透過度の?ﾅ大値は64としておくことにする?B


    private final Ten p_m_left_on = new Ten();//マウスの?ｶボタンを押したときの?ﾀ標
    private int i_nanini_tikai = 0;//Ten pが展開?}の点に近い=1?A?ﾜり?繧ｪり?}の点に近い=2?Aどちらにも近くない=0
    private int i_mottomo_tikai_Tenid;
    private int i_ten_sentaku = 0;//ts1?Ats2ともに未選択?i?ｵ?@i_ten_sentaku=0?j,ts1選択?ﾏでts2未選択?i?ｵ?@i_ten_sentaku=1?j,その頂点がts2選択?ﾏ?i?ｵ?@i_ten_sentaku=2?j
    private final Ten ugokasu_maeno_sentaku_ten = new Ten();//動かす前の選択した点の?ﾀ標


    //-----------------------------------------------------------------------------------------------------uuuuuuu--
    public void oriagari_sousa_mouse_on(Ten p) {//?ﾜり?繧ｪり?}操??でマウスの?ｶボタンを押したときの??業
        if (i_oriagari_sousa_mode == 1) {
            oriagari_sousa_mouse_on_1(p);
        }
        if (i_oriagari_sousa_mode == 2) {
            oriagari_sousa_mouse_on_2(p);
        }
    }

    public void oriagari_sousa_mouse_drag(Ten p) {//?ﾜり?繧ｪり?}操??でマウスの?ｶボタンを押したままドラッグしたときの??業
        if (i_oriagari_sousa_mode == 1) {
            oriagari_sousa_mouse_drag_1(p);
        }
        if (i_oriagari_sousa_mode == 2) {
            oriagari_sousa_mouse_drag_2(p);
        }
    }


    public void oriagari_sousa_mouse_off(Ten p) {//?ﾜり?繧ｪり?}操??でマウスの?ｶボタンを離したときの??業
        if (i_oriagari_sousa_mode == 1) {
            oriagari_sousa_mouse_off_1(p);
        }
        if (i_oriagari_sousa_mode == 2) {
            oriagari_sousa_mouse_off_2(p);
        }
    }


    //  =================================================================================================================================
    //-----------------------------------------------------------------------------------------------------uuuuuuu--
    public void oriagari_sousa_mouse_on_1(Ten p) {//?ﾜり?繧ｪり?}操??でマウスの?ｶボタンを押したときの??業   ?ﾜりずらし機能

        p_m_left_on.set(new Ten(p.getx(), p.gety()));

        ts2.setCamera(camera_of_oriagarizu);
        ts2.setCam_omote(camera_of_oriagari_omote);
        ts2.setCam_ura(camera_of_oriagari_ura);

        //i_mottomo_tikai_Tenidにpに?ﾅも近い点の番??を格納?B近い点がまったくない???№ﾍi_mottomo_tikai_Tenid=0
        i_nanini_tikai = 0;//展開?}の点に近い=1?A?ﾜり?繧ｪり?}の点に近い=2?Aどちらにも近くない=0
        i_mottomo_tikai_Tenid = ts1.mottomo_tikai_Tenid_with_camera(p);
        if (i_mottomo_tikai_Tenid != 0) {
            i_nanini_tikai = 1;
        }
        if (ts2.mottomo_tikai_Tenid_with_camera(p, ip4) != 0) {
            if (ts1.mottomo_tikai_Ten_kyori_with_camera(p) > ts2.mottomo_tikai_Ten_kyori_with_camera(p, ip4)) {
                i_mottomo_tikai_Tenid = ts2.mottomo_tikai_Tenid_with_camera(p, ip4);
                i_nanini_tikai = 2;
            }
        }//i_mottomo_tikai_Tenidにpに?ﾅも近い点の番??を格納 ここまで

        ugokasu_maeno_sentaku_ten.set(ts2.getTen(i_mottomo_tikai_Tenid));


        System.out.println("i_nanini_tikai = " + i_nanini_tikai);

        if (i_nanini_tikai == 1) {

            //i_ten_sentakuを決める
            i_ten_sentaku = 0;
            if (ts1.get_ten_sentaku(i_mottomo_tikai_Tenid) == 1) {
                i_ten_sentaku = 1;
            }
            if (ts2.get_ten_sentaku(i_mottomo_tikai_Tenid) == 1) {
                i_ten_sentaku = 2;
            }
            //i_ten_sentakuを決める  ここまで


            if (i_ten_sentaku == 0) {
                set_all_ten_sentaku_0();
                //?ﾜり?繧ｪり?}でi_mottomo_tikai_Tenidと同じ位置の点の番??を??め?Ats1でその番??の点を選択?ﾏみにする
                Ten ps = new Ten();
                ps.set(ts2.getTen(i_mottomo_tikai_Tenid));
                for (int i = 1; i <= ts2.getTensuu(); i++) {
                    if (ps.kyori(ts2.getTen(i)) < 0.0000001) {
                        ts1.set_ten_sentaku_1(i);
                    }
                }
                ts2.change_ten_sentaku(i_mottomo_tikai_Tenid);
            } else if (i_ten_sentaku == 1) {
                ts2.change_ten_sentaku(i_mottomo_tikai_Tenid);
            } else if (i_ten_sentaku == 2) {
                ts2.change_ten_sentaku(i_mottomo_tikai_Tenid);
            }


        }

        if (i_nanini_tikai == 2) {

            //i_ten_sentakuを決める
            i_ten_sentaku = 0;
            if (ts1.get_ten_sentaku(i_mottomo_tikai_Tenid) == 1) {
                i_ten_sentaku = 1;
                if (ts2.get_ten_sentakusuu() > 0) {
                    i_ten_sentaku = 2;
                }    //?ﾜ?}?繧ﾅ指定した点で?Aそこに?dなるいずれかの点がts2で選択されている?B要するに?ﾜ?}?繧ﾌ緑表示されている点を選んだ?ﾔ
            }
            //i_ten_sentakuを決める  ここまで
            System.out.println("i_ten_sentaku = " + i_ten_sentaku);

            if (i_ten_sentaku == 0) {
                set_all_ten_sentaku_0();

                //?ﾜり?繧ｪり?}でi_mottomo_tikai_Tenidと同じ位置の点の番??を??め?Ats1でその番??の点を選択?ﾏみにする
                Ten ps = new Ten();
                ps.set(ts2.getTen(i_mottomo_tikai_Tenid));
                for (int i = 1; i <= ts2.getTensuu(); i++) {
                    if (ps.kyori(ts2.getTen(i)) < 0.0000001) {
                        ts1.set_ten_sentaku_1(i);
                    }
                }
                ts2.change_ten_sentaku(i_mottomo_tikai_Tenid);
            } else if (i_ten_sentaku == 1) {
                ts2.change_ten_sentaku(i_mottomo_tikai_Tenid);
            } else if (i_ten_sentaku == 2) {
                //ts2.change_ten_sentaku(i_mottomo_tikai_Tenid);
            }


            if (i_oriagari_sousa_mode == 1) {

                hyouji_flg_backup = hyouji_flg;   //20180216  //hyouji_flgは?A?ﾜり?繧ｪり?}の表示様式の指定?B4なら実?ﾛに?ﾜり紙を?ﾜった???№ﾆ同じ?B3なら透過?}?B2なら?j金?}?B
                hyouji_flg = 2;            //20180216
            }


        }


        System.out.println("ts1.get_ten_sentakusuu() = " + ts1.get_ten_sentakusuu());
        System.out.println("ts2.get_ten_sentakusuu() = " + ts2.get_ten_sentakusuu());


    }

    //-------------
    public void oriagari_sousa_mouse_drag_1(Ten p) {//?ﾜり?繧ｪり?}操??でマウスの?ｶボタンを押したままドラッグしたときの??業

        ts2.setCamera(camera_of_oriagarizu);
        ts2.setCam_omote(camera_of_oriagari_omote);
        ts2.setCam_ura(camera_of_oriagari_ura);

        if (i_nanini_tikai == 1) {
        }

        if (i_nanini_tikai == 2) {
            ts2.mDragged_sentakuten_ugokasi_with_camera(ugokasu_maeno_sentaku_ten, p_m_left_on, p, ip4);


            if (i_oriagari_sousa_mode == 2) {
                oritatami_suitei_03();//20180216
            }
        }

    }

    //-------------
    public void oriagari_sousa_mouse_off_1(Ten p) {//?ﾜり?繧ｪり?}操??でマウスの?ｶボタンを離したときの??業
        ts2.setCamera(camera_of_oriagarizu);
        ts2.setCam_omote(camera_of_oriagari_omote);
        ts2.setCam_ura(camera_of_oriagari_ura);

        if (i_nanini_tikai == 1) {
        }

        if (i_nanini_tikai == 2) {

            hyouji_flg = hyouji_flg_backup;//20180216

            ts2.mReleased_sentakuten_ugokasi_with_camera(ugokasu_maeno_sentaku_ten, p_m_left_on, p, ip4);
            if (p_m_left_on.kyori(p) > 0.0000001) {
                kiroku();
                i_suitei_dankai = 2;

                if (hyouji_flg == 2) {
                }

                if (hyouji_flg == 5) {
                    i_suitei_meirei = 5;
                    orihime_ap.oritatami_suitei();
                }//オリジナル 20180124 これ以外だと?A表示いったんもどるようでうざい
            }


            ts1.set_all_ten_sentaku_0();
            //?ﾜり?繧ｪり?}でi_mottomo_tikai_Tenidと同じ位置の点の番??を??め?Ats1でその番??の点を選択?ﾏみにする
            Ten ps = new Ten();
            ps.set(ts2.getTen(i_mottomo_tikai_Tenid));
            for (int i = 1; i <= ts2.getTensuu(); i++) {
                if (ps.kyori(ts2.getTen(i)) < 0.0000001) {
                    ts1.set_ten_sentaku_1(i);
                }
            }
        }
    }

    //-------------------------------------------------------------------------------------------------------
//  =================================================================================================================================
//  ==========?ﾜり?繧ｪり?}のまま変形操??===========================================================================================================
    //-----------------------------------------------------------------------------------------------------uuuuuuu--
    public void oriagari_sousa_mouse_on_2(Ten p) {//?ﾜり?繧ｪり?}操??でマウスの?ｶボタンを押したときの??業

        p_m_left_on.set(new Ten(p.getx(), p.gety()));

        ts2.setCamera(camera_of_oriagarizu);
        ts2.setCam_omote(camera_of_oriagari_omote);
        ts2.setCam_ura(camera_of_oriagari_ura);

        //i_mottomo_tikai_Tenidにpに?ﾅも近い点の番??を格納?B近い点がまったくない???№ﾍi_mottomo_tikai_Tenid=0
        i_nanini_tikai = 0;//展開?}の点に近い=1?A?ﾜり?繧ｪり?}の点に近い=2?Aどちらにも近くない=0
        i_mottomo_tikai_Tenid = ts1.mottomo_tikai_Tenid_with_camera(p);
        if (i_mottomo_tikai_Tenid != 0) {
            i_nanini_tikai = 1;
        }
        if (ts2.mottomo_tikai_Tenid_with_camera(p, ip4) != 0) {
            if (ts1.mottomo_tikai_Ten_kyori_with_camera(p) > ts2.mottomo_tikai_Ten_kyori_with_camera(p, ip4)) {
                i_mottomo_tikai_Tenid = ts2.mottomo_tikai_Tenid_with_camera(p, ip4);
                i_nanini_tikai = 2;
            }
        }//i_mottomo_tikai_Tenidにpに?ﾅも近い点の番??を格納 ここまで

        ugokasu_maeno_sentaku_ten.set(ts2.getTen(i_mottomo_tikai_Tenid));


        System.out.println("i_nanini_tikai = " + i_nanini_tikai);

        if (i_nanini_tikai == 1) {

            //i_ten_sentakuを決める
            i_ten_sentaku = 0;
            if (ts1.get_ten_sentaku(i_mottomo_tikai_Tenid) == 1) {
                i_ten_sentaku = 1;
            }
            if (ts2.get_ten_sentaku(i_mottomo_tikai_Tenid) == 1) {
                i_ten_sentaku = 2;
            }
            //i_ten_sentakuを決める  ここまで


            if (i_ten_sentaku == 0) {
                set_all_ten_sentaku_0();
                //?ﾜり?繧ｪり?}でi_mottomo_tikai_Tenidと同じ位置の点の番??を??め?Ats1でその番??の点を選択?ﾏみにする
                Ten ps = new Ten();
                ps.set(ts2.getTen(i_mottomo_tikai_Tenid));
                for (int i = 1; i <= ts2.getTensuu(); i++) {
                    if (ps.kyori(ts2.getTen(i)) < 0.0000001) {
                        ts1.set_ten_sentaku_1(i);
                    }
                }
                ts2.change_ten_sentaku(i_mottomo_tikai_Tenid);
            } else if (i_ten_sentaku == 1) {
                ts2.change_ten_sentaku(i_mottomo_tikai_Tenid);
            } else if (i_ten_sentaku == 2) {
                ts2.change_ten_sentaku(i_mottomo_tikai_Tenid);
            }


        }

        if (i_nanini_tikai == 2) {

            //i_ten_sentakuを決める
            i_ten_sentaku = 0;
            if (ts1.get_ten_sentaku(i_mottomo_tikai_Tenid) == 1) {
                i_ten_sentaku = 1;
                if (ts2.get_ten_sentakusuu() > 0) {
                    i_ten_sentaku = 2;
                }    //?ﾜ?}?繧ﾅ指定した点で?Aそこに?dなるいずれかの点がts2で選択されている?B要するに?ﾜ?}?繧ﾌ緑表示されている点を選んだ?ﾔ
            }
            //i_ten_sentakuを決める  ここまで
            System.out.println("i_ten_sentaku = " + i_ten_sentaku);

            if (i_ten_sentaku == 0) {
                set_all_ten_sentaku_0();

                //?ﾜり?繧ｪり?}でi_mottomo_tikai_Tenidと同じ位置の点の番??を??め?Ats1でその番??の点を選択?ﾏみにする
                Ten ps = new Ten();
                ps.set(ts2.getTen(i_mottomo_tikai_Tenid));
                for (int i = 1; i <= ts2.getTensuu(); i++) {
                    if (ps.kyori(ts2.getTen(i)) < 0.0000001) {
                        ts1.set_ten_sentaku_1(i);
                    }
                }
                ts2.change_ten_sentaku(i_mottomo_tikai_Tenid);
            } else if (i_ten_sentaku == 1) {
                ts2.change_ten_sentaku(i_mottomo_tikai_Tenid);
            } else if (i_ten_sentaku == 2) {
                //ts2.change_ten_sentaku(i_mottomo_tikai_Tenid);
            }


            if (i_oriagari_sousa_mode == 1) {

                hyouji_flg_backup = hyouji_flg;   //20180216  //hyouji_flgは?A?ﾜり?繧ｪり?}の表示様式の指定?B4なら実?ﾛに?ﾜり紙を?ﾜった???№ﾆ同じ?B3なら透過?}?B2なら?j金?}?B
                hyouji_flg = 2;            //20180216
            }


        }


        System.out.println("ts1.get_ten_sentakusuu() = " + ts1.get_ten_sentakusuu());
        System.out.println("ts2.get_ten_sentakusuu() = " + ts2.get_ten_sentakusuu());


    }

    //-------------
    public void oriagari_sousa_mouse_drag_2(Ten p) {//?ﾜり?繧ｪり?}操??でマウスの?ｶボタンを押したままドラッグしたときの??業

        ts2.setCamera(camera_of_oriagarizu);
        ts2.setCam_omote(camera_of_oriagari_omote);
        ts2.setCam_ura(camera_of_oriagari_ura);

        if (i_nanini_tikai == 1) {
        }

        if (i_nanini_tikai == 2) {
            ts2.mDragged_sentakuten_ugokasi_with_camera(ugokasu_maeno_sentaku_ten, p_m_left_on, p, ip4);


            if (i_oriagari_sousa_mode == 2) {
                oritatami_suitei_03();//20180216
            }
        }

    }

    //-------------
    public void oriagari_sousa_mouse_off_2(Ten p) {//?ﾜり?繧ｪり?}操??でマウスの?ｶボタンを離したときの??業
        ts2.setCamera(camera_of_oriagarizu);
        ts2.setCam_omote(camera_of_oriagari_omote);
        ts2.setCam_ura(camera_of_oriagari_ura);

        if (i_nanini_tikai == 1) {
        }

        if (i_nanini_tikai == 2) {
            ts2.mReleased_sentakuten_ugokasi_with_camera(ugokasu_maeno_sentaku_ten, p_m_left_on, p, ip4);
            if (p_m_left_on.kyori(p) > 0.0000001) {
                kiroku();
                //if(ts2.get_ten_sentakusuu()!=0){
                i_suitei_dankai = 2;


                if (i_oriagari_sousa_mode == 1) {
                    hyouji_flg = hyouji_flg_backup;//20180216
                }
                if (hyouji_flg == 2) {
                }


//if(i_oriagari_sousa_mode==1){
                //if(hyouji_flg==5){i_suitei_meirei=5;orihime_ap.oritatami_suitei();}//オリジナル 20180124 これ以外だと?A表示いったんもどるようでうざい
//}
//if(i_oriagari_sousa_mode==2){
                oritatami_suitei_03();//20180216
//}


            }
            //ts2. set_all_ten_sentaku_0();

            //}
            ts1.set_all_ten_sentaku_0();
            //?ﾜり?繧ｪり?}でi_mottomo_tikai_Tenidと同じ位置の点の番??を??め?Ats1でその番??の点を選択?ﾏみにする
            Ten ps = new Ten();
            ps.set(ts2.getTen(i_mottomo_tikai_Tenid));
            for (int i = 1; i <= ts2.getTensuu(); i++) {
                if (ps.kyori(ts2.getTen(i)) < 0.0000001) {
                    ts1.set_ten_sentaku_1(i);
                }
            }


        }
    }


    //-------------------------------------------------------------------------------------------------------
//  =================================================================================================================================


    public void kiroku() {
        ts2.kiroku();
    }

    public void redo() {
        ts2.redo();
        oritatami_suitei_03();
    }


    public void undo() {
        ts2.undo();
        oritatami_suitei_03();
    }


    //--------------------
    public void set_all_ten_sentaku_0() {
        ts1.set_all_ten_sentaku_0();
        ts2.set_all_ten_sentaku_0();
    }


    //--------------------


}

