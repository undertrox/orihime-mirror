package jp.gr.java_conf.mt777.origami.orihime;

//import java.awt.MouseInfo;
//import java.awt.PointerInfo;

import jp.gr.java_conf.mt777.kiroku.memo.Memo;
import jp.gr.java_conf.mt777.kiroku.moji_sousa.Moji_sousa;
import jp.gr.java_conf.mt777.origami.dougu.camera.Camera;
import jp.gr.java_conf.mt777.origami.dougu.haikei_camera.Haikei_camera;
import jp.gr.java_conf.mt777.origami.dougu.keijiban.Keijiban;
import jp.gr.java_conf.mt777.origami.dougu.senbunsyuugou.Senbunsyuugou;
import jp.gr.java_conf.mt777.origami.orihime.egaki_syokunin.Egaki_Syokunin;
import jp.gr.java_conf.mt777.origami.orihime.oriagari_zu.Oriagari_Zu;
import jp.gr.java_conf.mt777.origami.orihime.oriagari_zu.Oriagari_Zu_01;
import jp.gr.java_conf.mt777.zukei2d.kousi.Kousi;
import jp.gr.java_conf.mt777.zukei2d.oritacalc.OritaCalc;
import jp.gr.java_conf.mt777.zukei2d.senbun.Senbun;
import jp.gr.java_conf.mt777.zukei2d.ten.Ten;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;

// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------

//public class ap extends Frame implements ActionListener,MouseListener, MouseMotionListener,MouseWheelListener,KeyListener{                                                                  
public class ap extends Frame implements ActionListener, MouseListener, MouseMotionListener, MouseWheelListener {

    ////b* アプリケ?[ション用?B?謫ｪが?^???^?^?^で始まる?sにはさまれた部分は無視される?B
    FileDialog fd;
    double r = 3.0;                   //基本枝?\造の直??の両端の円の半径?A枝と各種ポイントの近さの判定基??
    Memo memo1 = new Memo();

    File_keisiki_henkan file_henkan = new File_keisiki_henkan();

    OritaCalc oc = new OritaCalc();

    SubThread sub;

    int i_SubThread = 0;//SubThread?i?ﾜ?ﾝ計算?j実?s中なら１?A実?sしていないなら０

    //テスト用  VVVVVVVVVVVVVVVVV
    //Jyuufuku_Jyunretu_hasseiki jjh = new Jyuufuku_Jyunretu_hasseiki();
    //AAAAAAAAAAAAAAAAAAAAAAAAAAA

    Egaki_Syokunin es1 = new Egaki_Syokunin(r, this);    //基本枝?E?l?Bマウスからの入力を受け付ける?B

    public Oriagari_Zu temp_OZ = new Oriagari_Zu(this);    //?ﾜりあがり?}
    public Oriagari_Zu OZ;    //?ﾜりあがり?}

    ArrayList OAZ = new ArrayList(); //?ﾜり?繧ｪり?}のインスタンス化

    public Senbunsyuugou Ss0;//?ﾜ?ﾝ予測の?ﾅ?奄ﾉ?Ats1.Senbunsyuugou2Tensyuugou(Ss0)として使う?B?@Ss0は?Aes1.get_for_oritatami()かes1.get_for_select_oritatami()で得る?B

    int i_OAZ = 0;//OAZの何番目のOriagari_Zuがボタン操??や変形操??の対?ﾛとなるかを指定


    public Kousi kus = es1.kus;

    Moji_sousa ms = new Moji_sousa(); //文字列操??用の関?狽??Wめたクラス

    public Keijiban keijiban = new Keijiban(this);

    public Camera camera_of_orisen_nyuuryokuzu = new Camera();

    Haikei_camera h_cam = new Haikei_camera();

    Ten mouse_temp0 = new Ten();//マウスの動??対応時に?A一時的に使うTen

    int icol;//基本枝?E?lの枝の?Fを指定する?B0は???A1は?ﾔ?A2は?ﾔ?B//icol=0 black	//icol=1 red	//icol=2 blue	//icol=3 cyan	//icol=4 orange	//icol=5 mazenta	//icol=6 green	//icol=7 yellow	//icol=8 new Color(210,0,255) //紫
    int h_icol;//補????の枝の?Fを指定する?B

    int iro_sitei_ato_ni_jissisuru_sagyou_bangou = 1;//???ﾔ?ﾂ??の?F指定後に実施する??業の番??


    boolean w_image_jikkoutyuu = false;//?ﾜ?ﾝまとめ実?sの?B単一回のイ???[ジ?曹ｫ?oしが実?s中ならtureになる?B
    //boolean matome_write_image_jikkoutyuu = false;//matome_write_imageが実?s中ならtureになる?Bこれは?A複?狽ﾌ?ﾜりあがり形の予測の?曹ｫ?oしがかすれないように使う?B20170613

    String fname_and_number;//まとめ?曹ｫ?oしに使う?B


    public int i_anti_alias = 0;//展開?}のアンチェイリアスをするかしないか?Bする=1?Aしない=0
    public double senhaba_for_anti_alias = 1.0;//展開?}のアンチェイリアスをするなら=1.2?Aしない=1.0

    public int ir_ten = 1;//展開?}の点の形?w定

    public int i_orisen_hyougen = 1;//?ﾜ??の表現?A1???F?A2=?Fと形???A3=?浮ﾅ1点?ｽ???A4=?浮ﾅ2点?ｽ??

    //各種変?狽ﾌ定義
    public String c = "";                //文字列????用のクラスのインスタンス化
    //public String text_kekka=new String();                //結果表示用文字列のクラスのインスタンス化
    String frame_title_0 = "";//フレ?[ムのタイトルの?ｪ本部分
    String frame_title = "";//フレ?[ムのタイトルの全体

    //JDialog dialog = new JDialog(this , "こんにちは" , true);//ダイア??グのタイトル

    //int step;                             //操??の指定

    int i_orisen_hojyosen = 0;//=0は?ﾜ??入力?@=1は補????入力モ?[ド


    //アプレット用public void init()または?Aアプリケ?[ション用public ap() 以外のクラスでも使用されるパネルの部品の?骭ｾはここでしておく?B
    //アプレット用public void init()または?Aアプリケ?[ション用public ap() の中だけで使用されるパネルの部品の?骭ｾぅラスの中でする?B
    //基本的に部品の見かけが変化するものはここで?骭ｾする?B
    //Label lbel0 ;                         //対?ﾌ?ｫの指定に用いる
    //Label lbel1 ;                         //対?ﾌ?ｫの指定に用いる
    //Button	Button0 ;
    //Button	Button0a ;

    int kakudokei_input_id = 1;//角度系の入力方法の指定?@kakudokei_input_id=1は??分指定?A2は2点指定

    int id_kakudo_kei_a = 12;//角度系の180度を割る?狽ﾌ格納_a
    int id_kakudo_kei_b = 8;//角度系の180度を割る?狽ﾌ格納_b


    //int i_fold_type=0;//=0は通?墲ﾌ展開?}の全?ﾜ??を対?ﾛとした?ﾜり?ﾝ??定?A=1はselectされた?ﾜ??を対?ﾛとした?ﾜり?ﾝ??定?A
    //int i_fold_type=0;//=0なにもしない?A=1通?墲ﾌ展開?}の全?ﾜ??を対?ﾛとした?ﾜり?ﾝ??定?A=2はselectされた?ﾜ??を対?ﾛとした?ﾜり?ﾝ??定?A=3は?ﾜ?ﾝ?ﾔを変?X

    JButton Button0b;                    //対?ﾌ?ｫの指定に用いる
    //Button Button1   ;                    //操??の指定に用いる
    JButton Button3;                    //操??の指定に用いる?i追加??定一個だけ?j
    JButton Button_AS_matome;                    //操??の指定に用いる?i追加??定100個?j
    JButton Button_bangou_sitei_suitei_hyouji;


    JButton Button_kitei;
    JButton Button_kitei2;
    //Button ButtonCol_gray   ;                    //?ﾜ??の?Fの指定に用いる
    JButton ButtonCol_black;                    //?ﾜ??の?Fの指定に用いる
    JButton ButtonCol_blue;                    //?ﾜ??の?Fの指定に用いる
    JButton ButtonCol_red;                    //?ﾜ??の?Fの指定に用いる
    JButton ButtonCol_cyan;                    //?ﾜ??(補????)の?Fの指定に用いる


    JButton Button_Col_orange;                    //補????1の?Fの指定に用いる
    JButton Button_Col_yellow;                    //補????2の?Fの指定に用いる


    JButton Button_haikei_Lock_on;//背景の??ックオン
    JButton Button_haikei_kirikae;//背景を表示するかどうかの指定

    //Button ButtonCol_green15   ;                    //?ﾜ??の?Fの指定に用いる
    //Button ButtonCol_green20  ;                    //?ﾜ??の?Fの指定に用いる
    //Button ButtonCol_green22p5   ;                    //?ﾜ??の?Fの指定に用いる

    JButton Button_kakudo_kei_a;            //角度系で180を割る?狽i納_a
    JButton Button_kakudo_kei_b;            //角度系で180を割る?狽i納_b

    JButton Button_M_nisuru;                    //元がどんな種類の?ﾜ??でも?A山?ﾜりにする
    JButton Button_V_nisuru;                    //元がどんな種類の?ﾜ??でも?A谷?ﾜりにする
    JButton Button_E_nisuru;                    //元がどんな種類の?ﾜ??でも?A境界??もしくは山谷未?ﾝ定??にする
    JButton Button_HK_nisuru;                    //元がどんな種類の?ﾜ??でも?A補?賦???にする

    JButton Button_senbun_henkan2;//??分の?Fを?ﾔから?ﾂ?A?ﾂから?ﾔに変換


    public JButton Button_F_color;                    //?ﾜり?繧ｪり?}の表の?Fの指定に用いる
    public JButton Button_B_color;                    //?ﾜり?繧ｪり?}の裏の?Fの指定に用いる
    public JButton Button_L_color;                    //?ﾜり?繧ｪり?}の??の?Fの指定に用いる

    public Color sen_tokutyuu_color = new Color(100, 200, 200);//補????や円の?Fを特??的に変える???№ﾌ指定?F
    public JButton Button_sen_tokutyuu_color;                    //?ﾜり?繧ｪり?}の表の?Fの指定に用いる


    public JTextField text1;
    public int nyuuryoku_kitei = 0;    //格子の分割???@?@?@?@?i入力規定の指定?B0なら規定無し?A1なら蛇腹入力?B
    JTextField text2;
    int i_orisen_bunkatu_suu = 1;//free?ﾜ??入力で?A?ﾜ??の等分割されている??

    JTextField text3;
    double d_orisen_naibun_a = 1.0;
    JTextField text4;
    double d_orisen_naibun_b = 0.0;
    JTextField text5;
    double d_orisen_naibun_c = 0.0;
    JTextField text6;
    double d_orisen_naibun_d = 0.0;
    JTextField text7;
    double d_orisen_naibun_e = 1.0;
    JTextField text8;
    double d_orisen_naibun_f = 2.0;

    JTextField text9;
    int i_sei_takakukei = 5;

    JTextField text10;
    int i_undo_suu = 20;//text31はtext10を参?lにしている
    JTextField text11;
    int i_h_undo_suu = 20;

    JTextField text12;
    double d_jiyuu_kaku_a = 40.0;
    JTextField text13;
    double d_jiyuu_kaku_b = 60.0;
    JTextField text14;
    double d_jiyuu_kaku_c = 80.0;

    JTextField text15;
    double d_jiyuu_kaku_d = 30.0;
    JTextField text16;
    double d_jiyuu_kaku_e = 50.0;
    JTextField text17;
    double d_jiyuu_kaku_f = 100.0;

    public JTextField text18;
    public double d_kousi_x_a = 1.0;
    public JTextField text19;
    public double d_kousi_x_b = 0.0;
    public JTextField text20;
    public double d_kousi_x_c = 0.0;

    public JTextField text21;
    public double d_kousi_y_a = 1.0;
    public JTextField text22;
    public double d_kousi_y_b = 0.0;
    public JTextField text23;
    public double d_kousi_y_c = 0.0;

    public JTextField text24;
    public double d_kousi_kakudo = 90.0;

    public JTextField text25;
    public int memori_kankaku = 5;

    JTextField text26;
    int i_oritatami_bangou = 1;//?ﾜり?ﾝ??定の何番目を表示するか指定

    JTextField text27;
    double d_syukusyaku_keisuu = 1.0;//?k尺係??
    JTextField text28;
    double d_kaiten_hosei = 0.0;//回転表示角度の補?ｳ角度

    public JTextField text29;//double d_oriagarizu_syukusyaku_keisuu=1.0;//?ﾜり?繧ｪり?}の?k尺係??
    public JTextField text30;
    double d_oriagarizu_kaiten_hosei = 0.0;//?ﾜり?繧ｪり?}の回転表示角度の補?ｳ角度

    JTextField text31;
    int i_undo_suu_om = 5;//text31はtext10を参?lにしている


    public JCheckBox ckbox_mouse_settei;//マウスの?ﾝ定?Bチェックがあると?Aホイ?[ルマウスとして動???ﾝ定
    public JCheckBox ckbox_ten_sagasi;//点を探す範囲
    public JCheckBox ckbox_ten_hanasi;//点を離すかどうか
    public JCheckBox ckbox_kou_mitudo_nyuuryoku;//?ｖｧ度用入力をするかどうか
    public JCheckBox ckbox_bun;//文?ﾍ
    public JCheckBox ckbox_cp;//?ﾜ??
    public JCheckBox ckbox_a0;//補?賦???cyan
    public JCheckBox ckbox_a1;//補?負???

    public JCheckBox ckbox_check1;//check1
    public JCheckBox ckbox_check2;//check2
    public JCheckBox ckbox_check3;//check3
    public JCheckBox ckbox_check4;//check4

    public JCheckBox ckbox_mejirusi;//?\字や基??面などの目印画??
    public JCheckBox ckbox_cp_ue;//展開?}を?ﾜり?繧ｪり予想?}の?繧ﾉ描く
    public JCheckBox ckbox_oritatami_keika;//?ﾜり?繧ｪり予想の途中経過の?曹ｫ?oし


    public JCheckBox ckbox_cp_kaizen_oritatami;//cpを?ﾜ?ﾝ前に自動改善する?B
    public JCheckBox ckbox_select_nokosi;//select?ﾔを他の操??をしてもなるべく残す

    public JCheckBox ckbox_toukazu_color;//透過?}をカラ?[化する?B

    int i_ten_sagasi_hyouji, i_ten_hanasi_hyouji, i_kou_mitudo_nyuuryoku_hyouji, i_bun_hyouji, i_cp_hyouji, i_a0_hyouji, i_a1_hyouji;
    int i_mejirusi_hyouji, i_cp_ue_hyouji, i_oritatami_keika_hyouji;


    //JLabel label;
    // text1 = new JTextField("a1", 5);
    //text2 = new JTextField("a2", 5);
    // label = new JLabel();

    JLabel label_nagasa_sokutei_1 = new JLabel("");
    JLabel label_nagasa_sokutei_2 = new JLabel("");
    JLabel label_kakudo_sokutei_1 = new JLabel("");
    JLabel label_kakudo_sokutei_2 = new JLabel("");
    JLabel label_kakudo_sokutei_3 = new JLabel("");


    Image img_haikei;       //背景用の画像
    String img_haikei_fname;

    Image img_kaisetu;       //解?燉pの画像
    String img_kaisetu_fname;

    // バッファ?[画面用?ﾝ定VVVVVVVVVVVVVVVVVVVVVVVVVVVV
    Graphics bufferGraphics;

    int hx3 = 80;
    int hy3 = 80;//展開?}の描画点C
    int hx4 = 160;
    int hy4 = 160;//展開?}の描画点D

    // バッファ?[画面用?ﾝ定はここまでAAAAAAAAAAAAAAAAAAA

    int i_Lock_on_ori = 0;//背景を??ックオンする??１?Aしない??０
    int i_Lock_on = 0;//背景を??ックオンする??１?Aしない??０

    Ten p_mouse_object_iti = new Ten();//マウスのオブジェクト?ﾀ標?繧ﾌ位置
    Ten p_mouse_TV_iti = new Ten();//マウスのTV?ﾀ標?繧ﾌ位置

    // アプレットの??と?ｂｳ
    Dimension dim;


    int ihaikeihyouji = 0;//0なら背景を表示しない?B1なら表示する?B2は無い?B
    int ikaisetuhyouji = 1;//0なら解?烽\示しない?B1なら表示する?B2は無い?B
    public int iTenkaizuSenhaba = 1;//展開?}の??の太さ?B
    public int i_h_TenkaizuSenhaba = 3;//非干?ﾂ補????の??の太さ
    float fTenkaizuSenhaba = (float) iTenkaizuSenhaba;
    float f_h_TenkaizuSenhaba = (float) i_h_TenkaizuSenhaba;

    int nyuuryoku_houhou = 0;    //入力方法の指定?B0なら通?墲ﾌ方法?A1なら多角形入力?A２なら直??を指定した点に引き寄せる
    int kensa_houhou = 0;        //?}の検?ｸ方法の指定?B0なら検?ｸしない?B1なら??分?W?№ﾌ検?ｸをする?B

    public int i_mouse_modeA = 1;//マウスの動??に対する反応を規定する?B1なら??分入力モ?[ド?B2なら展開?}調?ｮ(移動)?B101なら?ﾜり?繧ｪり?}の操???B

    int i_mouseDragged_yuukou = 0;
    int i_mouseReleased_yuukou = 0;//0は?Aマウス操??を無視?B1はマウス操??有効?Bファイルボックスのon-offなどで?A予期せぬmouseDraggedやmouseReleasedが発?ｶしたとき?Aそれを?Eわないように0に?ﾝ定する?Bこれらは?Aマウスがクリックされたときに?A1有効指定にする?B

    double sokutei_nagasa_1 = 0.0;
    double sokutei_nagasa_2 = 0.0;
    double sokutei_nagasa_3 = 0.0;
    double sokutei_kakudo_1 = 0.0;
    double sokutei_kakudo_2 = 0.0;
    double sokutei_kakudo_3 = 0.0;

    //int i_AS_matome =100;//?ﾜ?ﾝ??定の別解をまとめて?oす個??
    //int i_AS_matome_mode =0;//1=?ﾜ?ﾝ??定の別解をまとめて?oす?B0=?ﾜ?ﾝ??定の別解をまとめて?oすモ?[ドではない?Bこの変?狽ﾍサブスレッドの動??変?Xにつかうだけ?B20170611にVe r3.008から追加

    int i_sub_mode = 0;
    //i_sub_mode サブスレッドの動??規定?B
    //0=?ﾜ????定5の実?s?B?ﾜ?ﾝ??定の別解をまとめて?oすモ?[ドではない?B
    //1=?ﾜ????定5の実?s?B?ﾜ?ﾝ??定の別解をまとめて?oす?B
    //2=


    Thread myTh;                              //スレッドクラスのインスタンス化
    //Runnableインタ?[フェイスを実装しているので?AmyThスレッドの実?s内容はrun??ソッドに?曹ｩれる
    //アプレットでのスレッドの使い方は?A?h?苑ﾌ験Java?hのP231参?ﾆ


    //画像?o力するため20170107_oldと?曹ｩれた?sをコ??ントアウトし?A20170107_newの?sを有効にした?B
    //画像?o力不要で元にもどすなら?A20170107_oldと?曹ｩれた?sを有効にし?A20170107_newの?sをコ??ントアウトにすればよい?B?iこの変?XはOrihime.javaの中だけに2箇?鰍?る?j
    // オフスクリ?[ン
    //Image offscreen;															//20170107_old
    //BufferedImage  offscreen = new BufferedImage(1, 1,  BufferedImage.TYPE_INT_BGR);							//20170107_new
    BufferedImage offscreen = null;//20181205new

    BufferedImage offsc_haikei = null;//20181205add

    int flg61 = 0;//枠?ﾝ定時につかう?@20180524

    int flg_wi = 0;//writeimage時につかう?@1にするとpaintの関?狽ﾌ?I了部にwriteimageするようにする?Bこれは?Apaintの変?Xが?曹ｫ?oされるイ???[ジに反映されないことを防ぐための?H夫?B20180528
    String fname_wi;


    public int i_sel_mou_mode;//セレクトしてマウス操??をする?ﾛにどの操??をするかの指定?Bセレクト後にセレクト?ﾏみの点を選択し自動的にセレクト前提のマウス操??に?ﾘり替えるときに使う?B
    //=1はmove?A=2はmove4p?A=3はcopy?A=4はcopy4p?A=5は鏡映像


    JButton Button_move;
    JButton Button_move_2p2p;
    JButton Button_copy_paste;
    JButton Button_copy_paste_2p2p;
    JButton Button_kyouei;

    //ウィンドウ透明化用のパラ???[タ
    BufferedImage imageT;
    int i_toumeika = 0;//0なら透明化しない?B1なら透明化する?B


    //?ｶ?纈[から?A?ｶ?繧ﾅ描画用画面の見える限界位置へのベクトル
    int hidari_ue_ix = 115;
    int hidari_ue_iy = 64;

    //右下端から?A右下で描画用画面の見える限界位置へのベクトル
    int migi_sita_ix = 115;
    int migi_sita_iy = 44;


    //ここまでが変?箔凾ﾌ定義
// **************************************************************************************************************
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
            //  myThスレッドで実?sさせたい内容はここに?曹ｭ?B
        }
    }

    ////b* アプリケ?[ション用?B?謫ｪが?^???^?^?^で始まる?sにはさまれた部分は無視される?B
    public ap() {


        super("ORIHIME Ver.3.054");//タイトルを指定してコンストラクタ実施
        frame_title_0 = getTitle();
        frame_title = frame_title_0;//タイトルを変?狽ﾉ格納
        es1.set_title(frame_title);

        addWindowListener(new WindowAdapter() {//?I了ボタンを有効化
            public void windowClosing(WindowEvent evt) {
                //owari();//ウィンドウ?纒ﾓ右端のXを押したときに?sう??業
                System.exit(0);
            }

        });//?I了ボタンを有効化 ここまで?B

        show();                 //アプレットの時は使わない?Bアプリケ?[ションの時は使う?Bかな
////b* アプリケ?[ション用?B?謫ｪが?^???^?^?^で始まる?sにはさまれた部分は無視される?B

        //バッファ?[画面の?ﾝ定 ------------------------------------------------------------------
        // ??と?ｂｳをたずねる
        dim = getSize();
        System.out.println(" dim 001 :" + dim.width + " , " + dim.height);//多分???怏ﾂ能

        //画像?o力するため20170107_oldと?曹ｩれた?sをコ??ントアウトし?A20170107_newの?sを有効にした?B
        //画像?o力不要で元にもどすなら?A20170107_oldと?曹ｩれた?sを有効にし?A20170107_newの?sをコ??ントアウトにすればよい?B?iこの変?XはOrihime.javaの中だけに2箇?鰍?る?j
        //offscreen = createImage(2000,1100)					;	bufferGraphics = offscreen.getGraphics();	//20170107_old
        offscreen = new BufferedImage(2000, 1100, BufferedImage.TYPE_INT_BGR);
        bufferGraphics = offscreen.createGraphics();    //20170107_new

        //アプレットでは以前はdim = getSize()して?AcreateImage(dim.width,dim.height);としたが?A?ﾅ?奄ｩらcreateImage(2000,1100); のほうが?Aウィンド拡大時もちゃんと?曹ｯる?B
        //ただし?Aアプレットで?ﾅ?奄ｩら(2000,1100)より大きいウィンド表示時は端がちゃんと?曹ｯなくなってしまうはず?B
////b* アプリケ?[ション用?B?謫ｪが?^???^?^?^で始まる?sにはさまれた部分は無視される?B
//		offscreen = createImage(2000,1100);
////b* アプリケ?[ション用?B?謫ｪが?^???^?^?^で始まる?sにはさまれた部分は無視される


        //バッファ?[画面の?ﾝ定はここまで----------------------------------------------------


//	public Oriagari_Zu OZ = new Oriagari_Zu(this);    //?ﾜりあがり?}
//	public Oriagari_Zu OZ;    //?ﾜりあがり?}
//	ArrayList OAZ = new ArrayList(); //?ﾜり?繧ｪり?}のインスタンス化


        //OAZ.clear();OAZ.add(new Oriagari_Zu(this));
        OAZ.clear();
        OAZ_add_new_Oriagari_Zu();
        OZ = (Oriagari_Zu) OAZ.get(0);//?ﾜりあがり?}


        //カ??ラの?ﾝ定 ------------------------------------------------------------------
        //camera_of_orisen_nyuuryokuzu	;
        camera_of_orisen_nyuuryokuzu.set_camera_ichi_x(0.0);
        camera_of_orisen_nyuuryokuzu.set_camera_ichi_y(0.0);
        camera_of_orisen_nyuuryokuzu.set_camera_kakudo(0.0);
        camera_of_orisen_nyuuryokuzu.set_camera_kagami(1.0);
        camera_of_orisen_nyuuryokuzu.set_camera_bairitsu_x(1.0);
        camera_of_orisen_nyuuryokuzu.set_camera_bairitsu_y(1.0);
        camera_of_orisen_nyuuryokuzu.set_hyouji_ichi_x(350.0);
        camera_of_orisen_nyuuryokuzu.set_hyouji_ichi_y(350.0);

        OZ.oriagari_camera_syokika();


        //camera_haikei	;
        //カ??ラの?ﾝ定はここまで----------------------------------------------------


        //text_kekka="";

        addMouseListener(this);
        addMouseMotionListener(this);
        addMouseWheelListener(this);
        //addKeyListener(this);

        icol = -1;
        //step=1;
        myTh = null;
        // ?炎喆\示
        //addEdge() ;
        setBackground(Color.white);

        // レイアウトの???ｬレイアウトの???ｬの部分は?h?苑ﾌ験Java?hのP179等を参?ﾆ

        setLayout(new BorderLayout());//Frame用
        //Container contentPane = getContentPane();//JFrame用


//System.exit(0);

//setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//JFrame用 ダイア??グボックスで?uキャンセル?vが選ばれた時に?A元の?ﾔを保つようにするために?Aわざとク???[ズボタンが押されても何も?sわないオプションを?ﾝ定した?B


        // *************************************************
        //?纒ﾓ?i北側?jパネルの?\築*************************
        // *************************************************
        //?纒ﾓ?i北側?jパネルの???ｬ
//pnln10定義?ﾏ
//pnln11定義?ﾏ
//pnln12定義?ﾏ
//pnln13定義?ﾏ
//pnln14定義?ﾏ
//pnln15未定義
//pnln20未定義
//pnln25未定義
//pnln30未定義


        //Panel pnln = new Panel();pnln.setBackground(new Color(0,100,0));//new Color(red,green,blue)
        Panel pnln = new Panel();
        pnln.setBackground(Color.PINK);//new Color(red,green,blue)
        pnln.setLayout(new FlowLayout(FlowLayout.LEFT));
        //?纒ﾓ?i北側?jパネルをレイアウトに貼り付け

        add("North", pnln); //Frame用
        //contentPane.add(pnln, BorderLayout.NORTH);//JFrame用


        //Buttonを??ってパネルにはりつける?B
////b* アプリケ?[ション用?B?謫ｪが?^???^?^?^で始まる?sにはさまれた部分は無視される?B

// ****************************************************************************************************************************

        //------------------------------------------------
        Panel pnln1 = new Panel();
        pnln1.setBackground(Color.PINK);
        pnln1.setLayout(new GridLayout(1, 2));

        pnln.add(pnln1);
        //------------------------------------------------


// **********************************************************************************************************************************************************
// **********************************************************************************************************************************************************
// **********************************************************************************************************************************************************
// -------------ボタンの定義の?謫ｪ?@ファイル読み?桙ﾝ
// **********************************************************************************************************************************************************
// **********************************************************************************************************************************************************
// **********************************************************************************************************************************************************

//Icon icon = new ImageIcon("ppp/board.png");

// ******************************************************************************デ?[タ読み?桙ﾝ

        //Button	Button_yomi 		= new Button(	"Open_data"	);Button_yomi.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
        JButton Button_yomi = new JButton("Open");
        Button_yomi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/yomi.png";
                readImageFromFile3();

                Button_kyoutuu_sagyou();

                i_mouseDragged_yuukou = 0;
                i_mouseReleased_yuukou = 0;
                Memo memo_temp = new Memo();

                System.out.println("readFile2Memo() 開始");
                memo_temp = readFile2Memo();
                System.out.println("readFile2Memo() ?I了");

                if (memo_temp.getGyousuu() > 0) {
                    //展開?}の?炎匀ｻ?@開始
                    //settei_syokika_cp();
                    tenkaizu_syokika();
                    //展開?}パラ???[タの?炎匀ｻ
                    es1.reset();                                                //描き?E?lの?炎匀ｻ

                    //nyuuryoku_kitei=8; es1.set_kousi_bunkatu_suu(nyuuryoku_kitei); //es1.reset_2();				//格子??の指定
                    es1.set_i_kitei_jyoutai(0);

                    icol = 1;
                    es1.setcolor(icol);                                        //?ﾅ?奄ﾌ?ﾜ??の?Fを指定する?B0は???A1は?ﾔ?A2は?ﾂ?B
                    ButtonCol_irokesi();
                    ButtonCol_red.setForeground(Color.black);
                    ButtonCol_red.setBackground(Color.red);    //?ﾜ??のボタンの?F?ﾝ定
                    //展開?}の?炎匀ｻ?@?I了


                    //?ﾜ?\測?}のの?炎匀ｻ?@開始
                    OZ = temp_OZ;//20171223この?sは不要かもしれないが?A一?uでもOZが示すOriagari_Zuがなくなることがないように念のために入れておく
                    OAZ.clear();
                    OAZ_add_new_Oriagari_Zu();
                    set_i_OAZ(0);
                    settei_syokika_yosoku();

                    Button_F_color.setBackground(OZ.oriagarizu_F_color);    //ボタンの?F?ﾝ定
                    Button_B_color.setBackground(OZ.oriagarizu_B_color);    //ボタンの?F?ﾝ定
                    Button_L_color.setBackground(OZ.oriagarizu_L_color);    //ボタンの?F?ﾝ定
                    //?ﾜ?\測?}のの?炎匀ｻ?@?I了

                    es1.setCamera(camera_of_orisen_nyuuryokuzu);//20170702この１?sを入れると?A解凍したjarファイルで実?sし?A?ﾅ?奄ﾉデ?[タ読み?桙ｾ直後はホイ?[ルでの展開?}拡大?k?ｬができなくなる?Bjarのままで実?sさせた???№ﾍもんだいないようだ?B原因不明?B
                    es1.setMemo_for_yomikomi(memo_temp);
                    es1.kiroku();


// -----------------20180503追加
                    d_syukusyaku_keisuu = camera_of_orisen_nyuuryokuzu.get_camera_bairitsu_x();
                    text27.setText(String.valueOf(d_syukusyaku_keisuu)); //?k尺係??
                    text27.setCaretPosition(0);

                    d_kaiten_hosei = camera_of_orisen_nyuuryokuzu.get_camera_kakudo();
                    text28.setText(String.valueOf(d_kaiten_hosei));//回転表示角度の補?ｳ係??
                    text28.setCaretPosition(0);


                    //	OZ.d_oriagarizu_syukusyaku_keisuu=1.0	;text29.setText(String.valueOf(OZ.d_oriagarizu_syukusyaku_keisuu));//?ﾜり?繧ｪり?}の?k尺係??
                    //	OZ.d_oriagarizu_kaiten_hosei=0.0		;text30.setText(String.valueOf(OZ.d_oriagarizu_kaiten_hosei));//?ﾜり?繧ｪり?}の回転表示角度の補?ｳ角度

// -----------------20180503追加ここまで


                    //repaint();

                }
            }
        });

        //Button_yomi.setPreferredSize(new Dimension(25, 25));
        Button_yomi.setMargin(new Insets(0, 0, 0, 0));
        //Button_yomi.setIcon(icon);
        pnln1.add(Button_yomi);

        //?d要??意?@読み?桙ﾝや?曹ｫ?oしでファイルダイア??グのボックスが開くと?Aそれをフレ?[ムに?dなる位置で操??した?????Aファイルボックスが?ﾁえたときに?A
        //マウスのドラッグとリリ?[スが発?ｶする?Bこのため?A余計な操??がされてしまう可能?ｫがある?Bなお?Aこのときマウスクリックは発?ｶしない?B
        // i_mouseDragged_yuukou=0;や i_mouseReleased_yuukou=0;は?Aこの余計な操??を防ぐために指定している?B


// ******************************************************************************デ?[タ?曹ｫ?oし
        //Button	Button_kaki		= new Button(	"Save_data"	);Button_kaki.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
        JButton Button_kaki = new JButton("Save");
        Button_kaki.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/kaki.png";
                readImageFromFile3();
                Button_kyoutuu_sagyou();
                i_mouseDragged_yuukou = 0;
                i_mouseReleased_yuukou = 0;
                writeMemo2File();
                es1.kiroku();
            }
        });
        Button_kaki.setMargin(new Insets(0, 0, 0, 0));
        pnln1.add(Button_kaki);//Button_kaki.setIcon(icon);//Button_kaki.setSize(2000,2000);


// ******北************************************************************************

        //Button	Button_senbun_nyuryoku	= new Button(	"L_draw"	);Button_senbun_nyuryoku.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
// -----61;長方形内選択モ?[ド?B
        JButton Button_tyouhoukei_select = new JButton("");
        Button_tyouhoukei_select.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/tyouhoukei_select.png";
                readImageFromFile3();
                i_orisen_hojyosen = 0;//=0は?ﾜ??入力?@=1は補????入力モ?[ド
                es1.set_i_orisen_hojyosen(i_orisen_hojyosen);//このボタンと機能は補?賦G??共通に使っているのでi_orisen_hojyosenの指定がいる
                i_mouse_modeA = 61;
                iro_sitei_ato_ni_jissisuru_sagyou_bangou = 1;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnln.add(Button_tyouhoukei_select);


        Button_tyouhoukei_select.setMargin(new Insets(0, 0, 0, 0));
        Button_tyouhoukei_select.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/tyouhoukei_select.png")));

// ------61;長方形内選択モ?[ド?Bここまで


// *****************************************************************************画像?曹ｫ?oし

        JButton Button_writeImage = new JButton("Im_s");
        Button_writeImage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/writeImage.png";
                readImageFromFile3();
                if (i_mouse_modeA != 61) {
                    Button_kyoutuu_sagyou();
                    es1.set_i_egaki_dankai(0);
                }//枠?ﾝ定時(==61)には?Aその枠を?ﾁさないためにes1.set_i_egaki_dankaiを０にしないでおく?@20180524
                i_mouseDragged_yuukou = 0;
                i_mouseReleased_yuukou = 0;


                writeImage();
                repaint();
            }
        });
        Button_writeImage.setMargin(new Insets(0, 0, 0, 0));
        //Button_writeImage.setBackground(Color.ORANGE);
        pnln.add(Button_writeImage);

// ******************************************************************************
/*
//透明化
		JButton	Button_toumei		= new JButton(	"T"		);
			Button_toumei.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {

		img_kaisetu_fname="qqq/toumei.png";readImageFromFile3();
							//if(i_mouse_modeA!=61){Button_kyoutuu_sagyou();es1.set_i_egaki_dankai(0);}//枠?ﾝ定時(==61)には?Aその枠を?ﾁさないためにes1.set_i_egaki_dankaiを０にしないでおく?@20180524
							//i_mouseDragged_yuukou=0; i_mouseReleased_yuukou=0;
//System.out.println("0    i_toumeika="+i_toumeika);
 Robot robot;

        try {
            robot = new Robot();
        } catch (AWTException ex) {
            ex.printStackTrace();
            return;
        }

        // 範囲を指定してキャプチャ

        Rectangle bounds = getBounds();
        Insets insets = getInsets();

        bounds = new Rectangle(bounds.x + insets.left,
                               bounds.y + insets.top,
                               bounds.width - insets.left - insets.right,
                               bounds.height - insets.top - insets.bottom);

        hide();
try{Thread.sleep(50);}catch (InterruptedException ie){}//30だけ待たせるための?s?Bこの?sがないと?Ajarファイルで実?sしたとき?Aオリヒ??自?gをキャプチャするおそれあり?BInterruptedException ieのieは?ﾅ?奄ﾍeだった?B20181125
        imageT = robot.createScreenCapture(bounds);
try{Thread.sleep(50);}catch (InterruptedException ie){}////30だけ待たせるための?s?Bこの?sがないと?Ajarファイルで実?sしたとき?Aオリヒ??自?gをキャプチャするおそれあり?BInterruptedException ieのieは?ﾅ?奄ﾍeだった?B20181125
        show();




	//
	i_toumeika=i_toumeika+1;if(i_toumeika==2){i_toumeika=0;}




//System.out.println("1      i_toumeika="+i_toumeika);

							//writeImage();
							//repaint();
		}});Button_toumei.setMargin(new Insets(0,0,0,0));
		//Button_writeImage.setBackground(Color.ORANGE);
		pnln.add(Button_toumei);


*/


// ******************************************************************************
////b* アプリケ?[ション用?B?謫ｪが?^???^?^?^で始まる?sにはさまれた部分は無視される?B
// ******************************************************************************


// ******************************************************************************


        //------------------------------------------------
        Panel pnln2 = new Panel();
        pnln2.setBackground(Color.PINK);
        pnln2.setLayout(new GridLayout(1, 2));

        pnln.add(pnln2);
        //------------------------------------------------


// ******北************************************************************************表示するものの選択

//ここからチェックボックスの連続
        //------------------------------------------------
        Panel pnln13 = new Panel();
        pnln13.setBackground(Color.PINK);
        pnln13.setLayout(new GridLayout(1, 7));

        pnln.add(pnln13);
        //------------------------------------------------


//マウス?ﾝ定
        ckbox_mouse_settei = new JCheckBox("");
        ckbox_mouse_settei.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname =
                        "qqq/ckbox_mouse_settei.png";
                readImageFromFile3();
                repaint();
            }
        });
        ckbox_mouse_settei.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/ckbox_mouse_settei_off.png")));
        ckbox_mouse_settei.setSelectedIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/ckbox_mouse_settei_on.png")));

        ckbox_mouse_settei.setMargin(new Insets(0, 0, 0, 0));
        pnln13.add(
                ckbox_mouse_settei);


// -------------------------------------------------------------------
//点探し
        ckbox_ten_sagasi = new JCheckBox("");
        ckbox_ten_sagasi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/ckbox_ten_sagasi.png";
                readImageFromFile3();
                repaint();
            }
        });
        ckbox_ten_sagasi.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ppp/ckbox_ten_sagasi_off.png")));
        ckbox_ten_sagasi.setSelectedIcon(new ImageIcon(getClass().getClassLoader().getResource("ppp/ckbox_ten_sagasi_on.png")));

        ckbox_ten_sagasi.setMargin(new Insets(0, 0, 0, 0));
        pnln13.add(ckbox_ten_sagasi);

// -------------------------------------------------------------------
//点離し
        ckbox_ten_hanasi = new JCheckBox("");
        ckbox_ten_hanasi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname =
                        "qqq/ckbox_ten_hanasi.png";
                readImageFromFile3();

                repaint();
            }
        });
        ckbox_ten_hanasi.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/ckbox_ten_hanasi_off.png")));
        ckbox_ten_hanasi.setSelectedIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/ckbox_ten_hanasi_on.png")));

        ckbox_ten_hanasi.setMargin(new Insets(0, 0, 0, 0));
        pnln13.add(
                ckbox_ten_hanasi);
// -------------------------------------------------------------------
//?ｖｧ度入力
        ckbox_kou_mitudo_nyuuryoku = new JCheckBox("");
        ckbox_kou_mitudo_nyuuryoku.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname =
                        "qqq/ckbox_kou_mitudo_nyuuryoku.png";
                readImageFromFile3();

                if (ckbox_kou_mitudo_nyuuryoku.isSelected()) {
                    System.out.println(" kou_mitudo_nyuuryoku on");
                    es1.set_i_kou_mitudo_nyuuryoku(1);
                } else {
                    System.out.println(" kou_mitudo_nyuuryoku off");
                    es1.set_i_kou_mitudo_nyuuryoku(0);
                }
                repaint();
            }
        });
        ckbox_kou_mitudo_nyuuryoku.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/ckbox_kou_mitudo_nyuuryoku_off.png")));
        ckbox_kou_mitudo_nyuuryoku.setSelectedIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/ckbox_kou_mitudo_nyuuryoku_on.png")));

        ckbox_kou_mitudo_nyuuryoku.setMargin(new Insets(0, 0, 0, 0));
        pnln13.add(ckbox_kou_mitudo_nyuuryoku);
// -------------------------------------------------------------------

//文表示
        ckbox_bun = new JCheckBox("");
        ckbox_bun.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/ckbox_bun.png";
                readImageFromFile3();
                repaint();
            }
        });
        ckbox_bun.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ppp/ckbox_bun_off.png")));
        ckbox_bun.setSelectedIcon(new ImageIcon(getClass().getClassLoader().getResource("ppp/ckbox_bun_on.png")));
        ckbox_bun.setMargin(new Insets(0, 0, 0, 0));
        pnln13.add(ckbox_bun);
// -------------------------------------------------------------------
//?ﾜ??表示
        ckbox_cp = new JCheckBox("");
        ckbox_cp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/ckbox_cp.png";
                readImageFromFile3();
                repaint();
            }
        });
        ckbox_cp.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ppp/ckbox_cp_off.png")));
        ckbox_cp.setSelectedIcon(new ImageIcon(getClass().getClassLoader().getResource("ppp/ckbox_cp_on.png")));
        ckbox_cp.setMargin(new Insets(0, 0, 0, 0));
        pnln13.add(ckbox_cp);
// -------------------------------------------------------------------
//補?賦???表示
        ckbox_a0 = new JCheckBox("");
        ckbox_a0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/ckbox_a0.png";
                readImageFromFile3();
                repaint();
            }
        });
        ckbox_a0.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ppp/ckbox_a0_off.png")));
        ckbox_a0.setSelectedIcon(new ImageIcon(getClass().getClassLoader().getResource("ppp/ckbox_a0_on.png")));


        //ckbox_a0.setBackground(Color.cyan);
        ckbox_a0.setMargin(new Insets(0, 0, 0, 0));
        pnln13.add(ckbox_a0);
// -------------------------------------------------------------------
//補?負???表示
        ckbox_a1 = new JCheckBox("");
        ckbox_a1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/ckbox_a1.png";
                readImageFromFile3();
                repaint();
            }
        });
        ckbox_a1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ppp/ckbox_a1_off.png")));
        ckbox_a1.setSelectedIcon(new ImageIcon(getClass().getClassLoader().getResource("ppp/ckbox_a1_on.png")));
        ckbox_a1.setMargin(new Insets(0, 0, 0, 0));
        pnln13.add(ckbox_a1);
// -------------------------------------------------------------------
//?\字や基??面などの目印画??
        ckbox_mejirusi = new JCheckBox("");
        ckbox_mejirusi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname =
                        "qqq/ckbox_mejirusi.png";
                readImageFromFile3();

                repaint();
            }
        });
        ckbox_mejirusi.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/ckbox_mejirusi_off.png")));
        ckbox_mejirusi.setSelectedIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/ckbox_mejirusi_on.png")));

        ckbox_mejirusi.setMargin(new Insets(0, 0, 0, 0));
        pnln13.add(
                ckbox_mejirusi);

// -------------------------------------------------------------------
//?ﾜりあがり?}を補????の手前側にするかどうか
        ckbox_cp_ue = new JCheckBox("");
        ckbox_cp_ue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname =
                        "qqq/ckbox_cp_ue.png";
                readImageFromFile3();

                repaint();
            }
        });
        ckbox_cp_ue.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/ckbox_cp_ue_off.png")));
        ckbox_cp_ue.setSelectedIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/ckbox_cp_ue_on.png")));

        ckbox_cp_ue.setMargin(new Insets(0, 0, 0, 0));
        pnln13.add(
                ckbox_cp_ue);

// -------------------------------------------------------------------
//?ﾜり?ﾝ経過の表示
        ckbox_oritatami_keika = new JCheckBox("");
        ckbox_oritatami_keika.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname =
                        "qqq/ckbox_oritatami_keika.png";
                readImageFromFile3();

                repaint();
            }
        });
        ckbox_oritatami_keika.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/ckbox_oritatami_keika_off.png")));
        ckbox_oritatami_keika.setSelectedIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/ckbox_oritatami_keika_on.png")));

        ckbox_oritatami_keika.setMargin(new Insets(0, 0, 0, 0));

// ******北************************************************************************


        //------------------------------------------------
        JPanel pnln10 = new JPanel();
        pnln10.setPreferredSize(new Dimension(247, 27));
        pnln10.setBackground(Color.PINK);
        //pnln10.setLayout(new GridLayout(1,4));
        //pnln10.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnln10.setLayout(null);
        pnln10.setBorder(new LineBorder(Color.black, 1));

        pnln.add(pnln10);
        //------------------------------------------------
// ******北************************************************************************??分入力モ?[ド?B比率入力
// -----1;??分入力モ?[ド?B比率入力

        //------------------------------------------------
        JPanel pnln11 = new JPanel();
        //pnln11.setPreferredSize(new Dimension(93, 23));
        pnln11.setBounds(2, 2, 93, 23);
        pnln11.setBackground(Color.white);
        pnln11.setLayout(null);
        //pnln11.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnln11.setBorder(new LineBorder(Color.black, 1));

        pnln10.add(pnln11);
        //------------------------------------------------


        text3 = new JTextField("", 2);
        text3.setBounds(2, 2, 25, 20);
        text3.setHorizontalAlignment(JTextField.RIGHT);
        pnln11.add(text3);

        JLabel Lb01;
        Lb01 = new JLabel();
        Lb01.setBounds(27, 2, 6, 20);
        //Lb01.setFont(new Font("Arial", Font.BOLD, 20));Lb01.setText("+");
        Lb01.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ppp/plus.png")));
        pnln11.add(Lb01);

        text4 = new JTextField("", 2);
        text4.setBounds(33, 2, 25, 20);
        text4.setHorizontalAlignment(JTextField.RIGHT);
        pnln11.add(text4);

        JLabel Lb02;
        Lb02 = new JLabel();
        Lb02.setBounds(58, 2, 9, 20);
        Lb02.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ppp/root.png")));
        pnln11.add(Lb02);

        text5 = new JTextField("", 2);
        text5.setBounds(67, 2, 25, 20);
        text5.setHorizontalAlignment(JTextField.RIGHT);
        pnln11.add(text5);

        JLabel Lb03;
        Lb03 = new JLabel();
        Lb03.setBounds(97, 2, 5, 23);
        //Lb03.setText(":");
        Lb03.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ppp/tenten.png")));
        pnln10.add(Lb03);


        //------------------------------------------------
        JPanel pnln12 = new JPanel();
        //pnln12.setPreferredSize(new Dimension(93, 23));
        pnln12.setBounds(103, 2, 93, 23);
        pnln12.setBackground(Color.white);
        //pnln12.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnln12.setLayout(null);
        pnln12.setBorder(new LineBorder(Color.black, 1));

        pnln10.add(pnln12);
        //------------------------------------------------


        text6 = new JTextField("", 2);
        text6.setBounds(2, 2, 25, 20);
        text6.setHorizontalAlignment(JTextField.RIGHT);
        pnln12.add(text6);

        JLabel Lb04;
        Lb04 = new JLabel();
        Lb04.setBounds(27, 2, 6, 20);
        //Lb04.setText("+");
        Lb04.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ppp/plus.png")));
        pnln12.add(Lb04);

        text7 = new JTextField("", 2);
        text7.setBounds(33, 2, 25, 20);
        text7.setHorizontalAlignment(JTextField.RIGHT);
        pnln12.add(text7);

        JLabel Lb05;
        Lb05 = new JLabel();
        Lb05.setBounds(58, 2, 9, 20);
        Lb05.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ppp/root.png")));
        pnln12.add(Lb05);

        text8 = new JTextField("", 2);
        text8.setBounds(67, 2, 25, 20);
        text8.setHorizontalAlignment(JTextField.RIGHT);
        pnln12.add(text8);


// -------------------------------------------------------------------------------??分入力モ?[ド?B比率set

        //Button	Button_senbun_naibun_set
// -----1;??分比率set
        JButton Button_senbun_naibun_set = new JButton("Set");
        Button_senbun_naibun_set.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                set_naibun();

                img_kaisetu_fname = "qqq/senbun_naibun_set.png";
                readImageFromFile3();
                i_mouse_modeA = 28;
                iro_sitei_ato_ni_jissisuru_sagyou_bangou = 28;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        Button_senbun_naibun_set.setBounds(197, 2, 25, 23);
        pnln10.add(Button_senbun_naibun_set);

        Button_senbun_naibun_set.setMargin(new Insets(0, 0, 0, 0));
        //Button_senbun_bunkatu_set.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
        //"ppp/senbun_bunkatu_set.png")));

// ------1;??分比率set?Bここまで


// -------------------------------------------------------------------------------??分入力モ?[ド?B比率分割

        //Button	Button_senbun_nyuryoku	= new Button(	"L_draw"	);Button_senbun_nyuryoku.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
// -----28;??分入力モ?[ド?B
        JButton Button_senbun_n_nyuryoku = new JButton("");
        Button_senbun_n_nyuryoku.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                set_naibun();

                img_kaisetu_fname = "qqq/senbun_n_nyuryoku.png";
                readImageFromFile3();
                i_mouse_modeA = 28;
                iro_sitei_ato_ni_jissisuru_sagyou_bangou = 28;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        Button_senbun_n_nyuryoku.setBounds(223, 2, 23, 23);
        pnln10.add(Button_senbun_n_nyuryoku);

        Button_senbun_n_nyuryoku.setMargin(new Insets(0, 0, 0, 0));
        Button_senbun_n_nyuryoku.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/senbun_n_nyuryoku.png")));

// ------28;??分入力モ?[ド?Bここまで


//-----------------------------------------------------------------------------------
        //------------------------------------------------
        Panel pnln7 = new Panel();
        pnln7.setBackground(Color.PINK);
        pnln7.setLayout(new GridLayout(1, 1));

        //pnln.add(pnln7);
        //------------------------------------------------

// ****北**************************************************************************
        JButton Button_tenkaizu_idiu = new JButton("");
        Button_tenkaizu_idiu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //JButton	Button_tenkaizu_idiu	= new JButton(	"CP_move"	);Button_tenkaizu_idiu.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/tenkaizu_idiu.png";
                readImageFromFile3();

                i_mouse_modeA = 2;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                repaint();
            }
        });
        pnln.add(Button_tenkaizu_idiu);

        Button_tenkaizu_idiu.setMargin(new Insets(0, 0, 0, 0));
        Button_tenkaizu_idiu.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/tenkaizu_idiu.png")));

// *****北*************************************************************************


// ******北************************************************************************


        //------------------------------------------------
        JPanel pnln8 = new JPanel();
        pnln8.setPreferredSize(new Dimension(109, 30));
        //pnln8.setBounds(2, 2, 109, 29);
        pnln8.setBackground(Color.white);
        //pnln8.setLayout(new GridLayout(1,5));
        pnln8.setLayout(null);
        pnln8.setBorder(new LineBorder(Color.black, 1));
        pnln.add(pnln8);
        //------------------------------------------------


// *****北*************************************************************************sssssssssssssss
        JButton Button_tenkaizu_syukusyou = new JButton("");
        Button_tenkaizu_syukusyou.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//		JButton	Button_tenkaizu_syukusyou	= new JButton(	"CP_z_out"	);Button_tenkaizu_syukusyou.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/tenkaizu_syukusyou.png";
                readImageFromFile3();


                double d_bairitu = 1.0 / Math.sqrt(Math.sqrt(Math.sqrt(2.0)));//  sqrt(sqrt(2))=1.1892
                d_syukusyaku_keisuu = d_syukusyaku_keisuu / Math.sqrt(Math.sqrt(Math.sqrt(2.0)));//  sqrt(sqrt(2))=1.1892
                //camera_of_orisen_nyuuryokuzu.set_camera_bairitsu_x(d_syukusyaku_keisuu);
                //camera_of_orisen_nyuuryokuzu.set_camera_bairitsu_y(d_syukusyaku_keisuu);
                camera_of_orisen_nyuuryokuzu.kakezan_camera_bairitsu_x(d_bairitu);
                camera_of_orisen_nyuuryokuzu.kakezan_camera_bairitsu_y(d_bairitu);


//20180122追加
                Oriagari_Zu OZi;
                for (int i_oz = 1; i_oz <= OAZ.size() - 1; i_oz++) {
                    OZi = (Oriagari_Zu) OAZ.get(i_oz);

                    Ten t_o2tv = new Ten();
                    t_o2tv = camera_of_orisen_nyuuryokuzu.object2TV(camera_of_orisen_nyuuryokuzu.get_camera_ichi());

                    OZi.d_oriagarizu_syukusyaku_keisuu = OZi.d_oriagarizu_syukusyaku_keisuu * d_bairitu;

                    OZi.camera_of_oriagarizu.camera_ichi_sitei_from_TV(t_o2tv);
                    OZi.camera_of_oriagarizu.kakezan_camera_bairitsu_x(d_bairitu);
                    OZi.camera_of_oriagarizu.kakezan_camera_bairitsu_y(d_bairitu);

                    OZi.camera_of_oriagari_omote.camera_ichi_sitei_from_TV(t_o2tv);
                    OZi.camera_of_oriagari_omote.kakezan_camera_bairitsu_x(d_bairitu);
                    OZi.camera_of_oriagari_omote.kakezan_camera_bairitsu_y(d_bairitu);

                    OZi.camera_of_oriagari_ura.camera_ichi_sitei_from_TV(t_o2tv);
                    OZi.camera_of_oriagari_ura.kakezan_camera_bairitsu_x(d_bairitu);
                    OZi.camera_of_oriagari_ura.kakezan_camera_bairitsu_y(d_bairitu);

                    OZi.camera_of_touka_omote.camera_ichi_sitei_from_TV(t_o2tv);
                    OZi.camera_of_touka_omote.kakezan_camera_bairitsu_x(d_bairitu);
                    OZi.camera_of_touka_omote.kakezan_camera_bairitsu_y(d_bairitu);

                    OZi.camera_of_touka_ura.camera_ichi_sitei_from_TV(t_o2tv);
                    OZi.camera_of_touka_ura.kakezan_camera_bairitsu_x(d_bairitu);
                    OZi.camera_of_touka_ura.kakezan_camera_bairitsu_y(d_bairitu);
                    text29.setText(String.valueOf(OZi.d_oriagarizu_syukusyaku_keisuu));
                    text29.setCaretPosition(0);
                }
//20180122追加?@ここまで


                text27.setText(String.valueOf(d_syukusyaku_keisuu));
                text27.setCaretPosition(0);
                repaint();
            }
        });
        pnln8.add(Button_tenkaizu_syukusyou);
        Button_tenkaizu_syukusyou.setBounds(1, 1, 28, 28);
        Button_tenkaizu_syukusyou.setMargin(new Insets(0, 0, 0, 0));
        Button_tenkaizu_syukusyou.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/tenkaizu_syukusyou.png")));


// ****北**************************************************************************
        text27 = new JTextField("", 2);
        text27.setBounds(29, 4, 35, 24);
        text27.setHorizontalAlignment(JTextField.RIGHT);

        pnln8.add(text27);

// ****北**************************************************************************
// -----?k尺係?敗et
        JButton Button_syukusyaku_keisuu_set = new JButton("S");
        Button_syukusyaku_keisuu_set.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //set_syukusyaku_keisuu();
                //public void set_syukusyaku_keisuu(){
                double d_syukusyaku_keisuu_old = d_syukusyaku_keisuu;
                d_syukusyaku_keisuu = String2double(text27.getText(), d_syukusyaku_keisuu_old);
                if (d_syukusyaku_keisuu <= 0.0) {
                    d_syukusyaku_keisuu = d_syukusyaku_keisuu_old;
                }
                text27.setText(String.valueOf(d_syukusyaku_keisuu));
                if (d_syukusyaku_keisuu != d_syukusyaku_keisuu_old) {
                    //double bairitsu;
                    //bairitsu=camera_of_orisen_nyuuryokuzu.get_camera_bairitsu_x();
                    //	 camera_of_orisen_nyuuryokuzu.set_camera_bairitsu_x( bairitsu*d_syukusyaku_keisuu/d_syukusyaku_keisuu_old );
                    //bairitsu=camera_of_orisen_nyuuryokuzu.get_camera_bairitsu_y();
                    //	 camera_of_orisen_nyuuryokuzu.set_camera_bairitsu_y( bairitsu*d_syukusyaku_keisuu/d_syukusyaku_keisuu_old );

                    camera_of_orisen_nyuuryokuzu.set_camera_bairitsu_x(d_syukusyaku_keisuu);
                    camera_of_orisen_nyuuryokuzu.set_camera_bairitsu_y(d_syukusyaku_keisuu);

//20180225追加

                    double d_bairitu = d_syukusyaku_keisuu / d_syukusyaku_keisuu_old;


                    Oriagari_Zu OZi;
                    for (int i_oz = 1; i_oz <= OAZ.size() - 1; i_oz++) {
                        OZi = (Oriagari_Zu) OAZ.get(i_oz);

                        Ten t_o2tv = new Ten();
                        t_o2tv = camera_of_orisen_nyuuryokuzu.object2TV(camera_of_orisen_nyuuryokuzu.get_camera_ichi());

                        OZi.d_oriagarizu_syukusyaku_keisuu = OZi.d_oriagarizu_syukusyaku_keisuu * d_bairitu;


                        OZi.camera_of_oriagarizu.camera_ichi_sitei_from_TV(t_o2tv);
                        OZi.camera_of_oriagarizu.kakezan_camera_bairitsu_x(d_bairitu);
                        OZi.camera_of_oriagarizu.kakezan_camera_bairitsu_y(d_bairitu);

                        OZi.camera_of_oriagari_omote.camera_ichi_sitei_from_TV(t_o2tv);
                        OZi.camera_of_oriagari_omote.kakezan_camera_bairitsu_x(d_bairitu);
                        OZi.camera_of_oriagari_omote.kakezan_camera_bairitsu_y(d_bairitu);

                        OZi.camera_of_oriagari_ura.camera_ichi_sitei_from_TV(t_o2tv);
                        OZi.camera_of_oriagari_ura.kakezan_camera_bairitsu_x(d_bairitu);
                        OZi.camera_of_oriagari_ura.kakezan_camera_bairitsu_y(d_bairitu);

                        OZi.camera_of_touka_omote.camera_ichi_sitei_from_TV(t_o2tv);
                        OZi.camera_of_touka_omote.kakezan_camera_bairitsu_x(d_bairitu);
                        OZi.camera_of_touka_omote.kakezan_camera_bairitsu_y(d_bairitu);

                        OZi.camera_of_touka_ura.camera_ichi_sitei_from_TV(t_o2tv);
                        OZi.camera_of_touka_ura.kakezan_camera_bairitsu_x(d_bairitu);
                        OZi.camera_of_touka_ura.kakezan_camera_bairitsu_y(d_bairitu);

                        text29.setText(String.valueOf(OZ.d_oriagarizu_syukusyaku_keisuu));
                        text29.setCaretPosition(0);
                    }
//20180225追加?@ここまで


                }
                text27.setText(String.valueOf(d_syukusyaku_keisuu));
                text27.setCaretPosition(0);
                repaint();

                //}
                img_kaisetu_fname = "qqq/syukusyaku_keisuu_set.png";
                readImageFromFile3();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        Button_syukusyaku_keisuu_set.setBounds(65, 4, 14, 24);
        pnln8.add(Button_syukusyaku_keisuu_set);

        Button_syukusyaku_keisuu_set.setMargin(new Insets(0, 0, 0, 0));
        //Button_syukusyaku_keisuu_set.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
        //"ppp/syukusyaku_keisuu_set.png")));

// ------?k尺係?敗et?Bここまで


// ****北**************************************************************************
        JButton Button_tenkaizu_kakudai = new JButton("");
        Button_tenkaizu_kakudai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//		Button	Button_tenkaizu_kakudai	= new Button(	"CP_z_in"	);Button_tenkaizu_kakudai.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/tenkaizu_kakudai.png";
                readImageFromFile3();
                //double bairitsu;
                //bairitsu=camera_of_orisen_nyuuryokuzu.get_camera_bairitsu_x();
                //	 camera_of_orisen_nyuuryokuzu.set_camera_bairitsu_x( bairitsu*Math.sqrt(Math.sqrt(2.0)) );//  sqrt(sqrt(2))=1.1892
                //bairitsu=camera_of_orisen_nyuuryokuzu.get_camera_bairitsu_y();
                //	 camera_of_orisen_nyuuryokuzu.set_camera_bairitsu_y( bairitsu*Math.sqrt(Math.sqrt(2.0)) );

                double d_bairitu = Math.sqrt(Math.sqrt(Math.sqrt(2.0)));//  sqrt(sqrt(2))=1.1892
                d_syukusyaku_keisuu = d_syukusyaku_keisuu * Math.sqrt(Math.sqrt(Math.sqrt(2.0)));//  sqrt(sqrt(2))=1.1892
                camera_of_orisen_nyuuryokuzu.kakezan_camera_bairitsu_x(d_bairitu);
                camera_of_orisen_nyuuryokuzu.kakezan_camera_bairitsu_y(d_bairitu);


//20180122追加
                Oriagari_Zu OZi;
                for (int i_oz = 1; i_oz <= OAZ.size() - 1; i_oz++) {
                    OZi = (Oriagari_Zu) OAZ.get(i_oz);

                    Ten t_o2tv = new Ten();
                    t_o2tv = camera_of_orisen_nyuuryokuzu.object2TV(camera_of_orisen_nyuuryokuzu.get_camera_ichi());

                    OZi.d_oriagarizu_syukusyaku_keisuu = OZi.d_oriagarizu_syukusyaku_keisuu * d_bairitu;


                    OZi.camera_of_oriagarizu.camera_ichi_sitei_from_TV(t_o2tv);
                    OZi.camera_of_oriagarizu.kakezan_camera_bairitsu_x(d_bairitu);
                    OZi.camera_of_oriagarizu.kakezan_camera_bairitsu_y(d_bairitu);

                    OZi.camera_of_oriagari_omote.camera_ichi_sitei_from_TV(t_o2tv);
                    OZi.camera_of_oriagari_omote.kakezan_camera_bairitsu_x(d_bairitu);
                    OZi.camera_of_oriagari_omote.kakezan_camera_bairitsu_y(d_bairitu);

                    OZi.camera_of_oriagari_ura.camera_ichi_sitei_from_TV(t_o2tv);
                    OZi.camera_of_oriagari_ura.kakezan_camera_bairitsu_x(d_bairitu);
                    OZi.camera_of_oriagari_ura.kakezan_camera_bairitsu_y(d_bairitu);

                    OZi.camera_of_touka_omote.camera_ichi_sitei_from_TV(t_o2tv);
                    OZi.camera_of_touka_omote.kakezan_camera_bairitsu_x(d_bairitu);
                    OZi.camera_of_touka_omote.kakezan_camera_bairitsu_y(d_bairitu);

                    OZi.camera_of_touka_ura.camera_ichi_sitei_from_TV(t_o2tv);
                    OZi.camera_of_touka_ura.kakezan_camera_bairitsu_x(d_bairitu);
                    OZi.camera_of_touka_ura.kakezan_camera_bairitsu_y(d_bairitu);

                    text29.setText(String.valueOf(OZ.d_oriagarizu_syukusyaku_keisuu));
                    text29.setCaretPosition(0);
                }
//20180122追加?@ここまで


                text27.setText(String.valueOf(d_syukusyaku_keisuu));
                text27.setCaretPosition(0);
                repaint();
            }
        });
        pnln8.add(Button_tenkaizu_kakudai);
        Button_tenkaizu_kakudai.setBounds(80, 1, 28, 28);
        Button_tenkaizu_kakudai.setMargin(new Insets(0, 0, 0, 0));
        Button_tenkaizu_kakudai.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/tenkaizu_kakudai.png")));


// ******北************************************************************************

        //------------------------------------------------
        JPanel pnln14 = new JPanel();
        pnln14.setPreferredSize(new Dimension(119, 30));
        //pnln14.setBounds(2, 2, 119, 29);
        //pnln14.setBounds(2, 2, 68, 29);
        pnln14.setBackground(Color.white);
        pnln14.setLayout(null);
        pnln14.setBorder(new LineBorder(Color.black, 1));
        pnln.add(pnln14);
        //------------------------------------------------


// *****北*************展開の回転************************************************************
        JButton Button_tenkaizu_p_kaiten = new JButton("");
        Button_tenkaizu_p_kaiten.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/tenkaizu_p_kaiten.png";
                readImageFromFile3();

                d_kaiten_hosei = oc.kakudo_osame_m180_180(d_kaiten_hosei + 11.25);
                camera_of_orisen_nyuuryokuzu.set_camera_kakudo(d_kaiten_hosei);
                text28.setText(String.valueOf(d_kaiten_hosei));
                text28.setCaretPosition(0);

                //Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnln14.add(Button_tenkaizu_p_kaiten);
        Button_tenkaizu_p_kaiten.setBounds(1, 1, 33, 28);

        Button_tenkaizu_p_kaiten.setMargin(new Insets(0, 0, 0, 0));
        Button_tenkaizu_p_kaiten.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/tenkaizu_p_kaiten.png")));

// ****北**************************************************************************
//回転角度補?ｳ
        text28 = new JTextField("", 2);
        text28.setBounds(34, 4, 35, 24);
        text28.setHorizontalAlignment(JTextField.RIGHT);
        pnln14.add(text28);

// ****北**************************************************************************
// -----回転角度補?ｳset
        JButton Button_kaiten_hosei_set = new JButton("S");
        Button_kaiten_hosei_set.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double d_kaiten_hosei_old = d_kaiten_hosei;
                d_kaiten_hosei = oc.kakudo_osame_m180_180(String2double(text28.getText(), d_kaiten_hosei_old));

                text28.setText(String.valueOf(d_kaiten_hosei));

                if (d_kaiten_hosei != d_kaiten_hosei_old) {
                    //double kakudo;
                    //kakudo= camera_of_orisen_nyuuryokuzu.get_camera_kakudo();
                    //camera_of_orisen_nyuuryokuzu.set_camera_kakudo(kakudo+d_kaiten_hosei-d_kaiten_hosei_old);

                    camera_of_orisen_nyuuryokuzu.set_camera_kakudo(d_kaiten_hosei);
                }

                text28.setText(String.valueOf(d_kaiten_hosei));
                text28.setCaretPosition(0);
                repaint();


                img_kaisetu_fname = "qqq/kaiten_hosei_set.png";
                readImageFromFile3();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        Button_kaiten_hosei_set.setBounds(70, 4, 14, 24);
        pnln14.add(Button_kaiten_hosei_set);

        Button_kaiten_hosei_set.setMargin(new Insets(0, 0, 0, 0));


// ------回転角度補?ｳset?Bここまで


// *****北*************************************************************************
        JButton Button_tenkaizu_m_kaiten = new JButton("");
        Button_tenkaizu_m_kaiten.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//		JButton	Button_tenkaizu_m_kaiten	= new JButton(	"CP-rot"	);Button_tenkaizu_m_kaiten.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/tenkaizu_m_kaiten.png";
                readImageFromFile3();
                d_kaiten_hosei = oc.kakudo_osame_m180_180(d_kaiten_hosei - 11.25);
                camera_of_orisen_nyuuryokuzu.set_camera_kakudo(d_kaiten_hosei);
                text28.setText(String.valueOf(d_kaiten_hosei));
                text28.setCaretPosition(0);
                repaint();
            }
        });
        pnln14.add(Button_tenkaizu_m_kaiten);

        Button_tenkaizu_m_kaiten.setBounds(85, 1, 33, 28);


        Button_tenkaizu_m_kaiten.setMargin(new Insets(0, 0, 0, 0));
        Button_tenkaizu_m_kaiten.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/tenkaizu_m_kaiten.png")));


// ******北************************************************************************


// ******北************************************************************************


//背景のPC画面を背景画として読み?桙ﾞ
        JButton Button_toumei = new JButton("T");
        Button_toumei.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/toumei.png";
                readImageFromFile3();
                //if(i_mouse_modeA!=61){Button_kyoutuu_sagyou();es1.set_i_egaki_dankai(0);}//枠?ﾝ定時(==61)には?Aその枠を?ﾁさないためにes1.set_i_egaki_dankaiを０にしないでおく?@20180524
                //i_mouseDragged_yuukou=0; i_mouseReleased_yuukou=0;
//System.out.println("0    i_toumeika="+i_toumeika);
                Robot robot;

                try {
                    robot = new Robot();
                } catch (AWTException ex) {
                    ex.printStackTrace();
                    return;
                }

                // 範囲を指定してキャプチャ

                Rectangle bounds = getBounds();
                Insets insets = getInsets();
                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println("bounds.x=" + bounds.x + "   :bounds.y=" + bounds.y + "    :bounds.width=" + bounds.width + "   :bounds.height=" + bounds.height);
                System.out.println("insets.top=" + insets.top + "   :insets.left=" + insets.left + "    :insets.right=" + insets.right + "   :insets.bottom=" + insets.bottom);


                //?ｶ?纈[から?A?ｶ?繧ﾅ描画用画面の見える限界位置へのベクトル
                //int hidari_ue_ix=115;
                //int hidari_ue_iy=60;

                //右下端から?A右下で描画用画面の見える限界位置へのベクトル
                //int migi_sita_ix=115;
                //int migi_sita_iy=40;

                //int i_dx=115;int i_dy=0;


                bounds = new Rectangle(bounds.x + hidari_ue_ix,
                        bounds.y + hidari_ue_iy,
                        bounds.width - hidari_ue_ix - migi_sita_ix,
                        bounds.height - hidari_ue_iy - migi_sita_iy);



/*
        bounds = new Rectangle(bounds.x + insets.left  +hidari_ue_ix ,
                               bounds.y + insets.top   +hidari_ue_iy ,
                               bounds.width - insets.left - insets.right  - hidari_ue_ix- migi_sita_ix,
                               bounds.height - insets.top - insets.bottom    - hidari_ue_iy -migi_sita_iy  )  ;
 */
                hide();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ie) {
                }//100だけ待たせるための?s?Bこの?sがないと?Ajarファイルで実?sしたとき?Aオリヒ??自?gをキャプチャするおそれあり?BInterruptedException ieのieは?ﾅ?奄ﾍeだった?B20181125
                imageT = robot.createScreenCapture(bounds);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ie) {
                }//100だけ待たせるための?s?Bこの?sがないと?Ajarファイルで実?sしたとき?Aオリヒ??自?gをキャプチャするおそれあり?BInterruptedException ieのieは?ﾅ?奄ﾍeだった?B20181125
                show();

                img_haikei = imageT;
//oc.hyouji("旧背景カ??ラリセット");
//h_cam.reset();
//oc.hyouji(" ");
                oc.hyouji("?V背景カ??ラインスタンス化");
                h_cam = new Haikei_camera();//20181202

                double dvx = hidari_ue_ix;
                double dvy = hidari_ue_iy;

                haikei_set(new Ten(120.0, 120.0),
                        new Ten(120.0 + 10.0, 120.0),
                        new Ten(dvx, dvy),
                        new Ten(dvx + 10.0, dvy));


//背景表示の各??を?ﾝ定
                ihaikeihyouji = 1;
                Button_haikei_kirikae.setBackground(Color.ORANGE);

                if (i_Lock_on == 1) {//20181202  このifが無いとlock on のときに背景がうまく表示できない
                    h_cam.set_i_Lock_on(i_Lock_on);
                    h_cam.setCamera(camera_of_orisen_nyuuryokuzu);
                    h_cam.h3_obj_and_h4_obj_keisan();
                }

                repaint();
            }
        });
        Button_toumei.setMargin(new Insets(0, 0, 0, 0));
        //Button_writeImage.setBackground(Color.ORANGE);
        pnln.add(Button_toumei);

// *******北***********************************************************************

//Image img;
//img=(Image)imageT;
//g2_toumei.drawImage(img,h_cam.get_x0(),h_cam.get_y0(),h_cam.get_x1(),h_cam.get_y1(),null);//nullだとコンパイル通るがthisだとダ??20181125
//g2_toumei.drawImage(img,-100,-100,null);//nullだとコンパイル通るがthisだとダ??20181125

//drawImage
//  img - 描画される指定イ???[ジ?Bimg が null の???№ﾉは何も?sわない
//  x - x ?ﾀ標
//  y - y ?ﾀ標
//  width - 矩形の??
//  height - 矩形の?ｂｳ
//  observer - イ???[ジがさらに変換されることが通知されるオブジェクト

// *****北*************************************************************************
        JButton Button_haikei_trim = new JButton("Tr");
        Button_haikei_trim.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/haikei_trim.png";
                readImageFromFile3();


                offsc_haikei = new BufferedImage(2000, 1100, BufferedImage.TYPE_INT_ARGB);
//offsc_haikei  = new BufferedImage(2000, 1100,  BufferedImage.TYPE_INT_BGR)	;//TYPE_INT_BGRだとトリムした画像を回転したりすると?Fが落ちる20181206

                Graphics bufferGraphics_haikei;
                bufferGraphics_haikei = offsc_haikei.createGraphics();    //20170107_new
                Graphics2D g2_haikei = (Graphics2D) bufferGraphics_haikei;
                //背景表示
                if ((img_haikei != null) && (ihaikeihyouji >= 1)) {
                    int iw = img_haikei.getWidth(null);//イ???[ジの??を取得
                    int ih = img_haikei.getHeight(null);//イ???[ジの?ｂｳを取得

                    //System.out.println("paint????"+iw);
                    //System.out.println("paint?ｂｳ??"+ih);
                    h_cam.set_haikei_haba(iw);
                    h_cam.set_haikei_takasa(ih);

                    //if(i_Lock_on==1){
                    haikei_byouga(g2_haikei, img_haikei);
                    //}

                }


//枠?ﾝ定時の背景を枠内のみ残してトリム 20181204
                if ((i_mouse_modeA == 61) && (es1.get_i_egaki_dankai() == 4)) {//枠??が表示されている?ﾔ
                    int xmin = (int) es1.p61_TV_hako.get_x_min();
                    int xmax = (int) es1.p61_TV_hako.get_x_max();
                    int ymin = (int) es1.p61_TV_hako.get_y_min();
                    int ymax = (int) es1.p61_TV_hako.get_y_max();

                    img_haikei = offsc_haikei.getSubimage(xmin, ymin, xmax - xmin, ymax - ymin);
//img_haikei=(Image)offsc_haikei;


                    h_cam = new Haikei_camera();

                    double dvx = xmin;
                    double dvy = ymin;

                    haikei_set(new Ten(120.0, 120.0),
                            new Ten(120.0 + 10.0, 120.0),
                            new Ten(dvx, dvy),
                            new Ten(dvx + 10.0, dvy));

                    if (i_Lock_on == 1) {//20181202  このifが無いとlock on のときに背景がうまく表示できない
                        h_cam.set_i_Lock_on(i_Lock_on);
                        h_cam.setCamera(camera_of_orisen_nyuuryokuzu);
                        h_cam.h3_obj_and_h4_obj_keisan();
                    }


                }
            }
        });
        Button_haikei_trim.setMargin(new Insets(0, 0, 0, 0));
        pnln.add(Button_haikei_trim);

// *******北***********************************************************************
/*
int width, height;
BufferedImage offsc_haikei2;
BufferedImage write;
width=img_haikei.getWidth(null);
height=img_haikei.getHeight(null);
write=new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

for(int w=0; w<width; w++){
for(int h=0; h<height; h++){
write.setRGB(w, h, offsc_haikei.getRGB(w,h));
}
}
*/
// *******北***********************************************************************

////b* アプリケ?[ション用?B?謫ｪが?^???^?^?^で始まる?sにはさまれた部分は無視される?B

        //------------------------------------------------
        Panel pnln9 = new Panel();
        pnln9.setBackground(Color.PINK);
        pnln9.setLayout(new GridLayout(1, 5));

        pnln.add(pnln9);
        //------------------------------------------------

        JButton Button_haikei = new JButton("BG");
        Button_haikei.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/haikei.png";
                readImageFromFile3();

                //i_Lock_on=0;
                //Button_kyoutuu_sagyou();
                i_mouseDragged_yuukou = 0;
                i_mouseReleased_yuukou = 0;


                readImageFromFile();


                //readImageFromFile2();
                ihaikeihyouji = 1;
                Button_haikei_kirikae.setBackground(Color.ORANGE);


                h_cam = new Haikei_camera();//20181202
                if (i_Lock_on == 1) {//20181202  このifが無いとlock on のときに背景がうまく表示できない
                    h_cam.set_i_Lock_on(i_Lock_on);
                    h_cam.setCamera(camera_of_orisen_nyuuryokuzu);
                    h_cam.h3_obj_and_h4_obj_keisan();
                }


                repaint();

            }
        });
        Button_haikei.setMargin(new Insets(0, 0, 0, 0));
        Button_haikei.setBackground(Color.ORANGE);
        pnln9.add(Button_haikei);
// ******************************************************************************
        //Button	Button_haikei_kirikae 	= new Button(	"on_off"	);Button_haikei_kirikae.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
        Button_haikei_kirikae = new JButton("off");
        Button_haikei_kirikae.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/haikei_kirikae.png";
                readImageFromFile3();
//Button_kyoutuu_sagyou();
                ihaikeihyouji = ihaikeihyouji + 1;
                if (ihaikeihyouji == 2) {
                    ihaikeihyouji = 0;
                }

                if (ihaikeihyouji == 0) {
                    Button_haikei_kirikae.setBackground(Color.gray);
                }

                if (ihaikeihyouji == 1) {
                    Button_haikei_kirikae.setBackground(Color.ORANGE);
                }

                repaint();
            }
        });
        Button_haikei_kirikae.setMargin(new Insets(0, 0, 0, 0));
        Button_haikei_kirikae.setBackground(Color.ORANGE);
        pnln9.add(Button_haikei_kirikae);


// ******************************************************************************
        JButton Button_set_BG = new JButton("S");
        Button_set_BG.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/set_BG.png";
                readImageFromFile3();

                i_mouse_modeA = 26;
                Button_kyoutuu_sagyou();
                repaint();
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

            }
        });
        Button_set_BG.setMargin(new Insets(0, 0, 0, 0));
        Button_set_BG.setBackground(Color.ORANGE);
        pnln9.add(Button_set_BG);

// ******北************************************************************************
        Button_haikei_Lock_on = new JButton("L");
        Button_haikei_Lock_on.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/haikei_Lock_on.png";
                readImageFromFile3();
                //Button_kyoutuu_sagyou();

                i_Lock_on_ori = i_Lock_on_ori + 1;
                if (i_Lock_on_ori >= 2) {
                    i_Lock_on_ori = 0;
                }
                i_Lock_on = i_Lock_on_ori;
                //System.out.println("i_Lock_on    ="+i_Lock_on);


                if (i_Lock_on == 1) {
                    Button_haikei_Lock_on.setBackground(Color.ORANGE);

                    h_cam.set_i_Lock_on(i_Lock_on);
                    h_cam.setCamera(camera_of_orisen_nyuuryokuzu);
                    h_cam.h3_obj_and_h4_obj_keisan();
                }


                if (i_Lock_on == 0) {
                    Button_haikei_Lock_on.setBackground(Color.gray);

                    h_cam.set_i_Lock_on(i_Lock_on);
                    //h_cam.setCamera(camera_of_orisen_nyuuryokuzu);
                    //h_cam.h3_obj_and_h4_obj_keisan();
                }


                //ihaikeihyouji=ihaikeihyouji+1 ;
                //if(ihaikeihyouji==2){ihaikeihyouji=0;}
                repaint();
            }
        });
        Button_haikei_Lock_on.setMargin(new Insets(0, 0, 0, 0));

        pnln9.add(Button_haikei_Lock_on);


// ******北************************************************************************?@??分?怩ｯて??種変換

        JButton Button_senbun_yoke_henkan = new JButton("");//new JButton(	"L_chan"	);
        Button_senbun_yoke_henkan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/senbun_yoke_henkan.png";
                readImageFromFile3();
                i_mouse_modeA = 30;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnln9.add(Button_senbun_yoke_henkan);

        Button_senbun_yoke_henkan.setMargin(new Insets(0, 0, 0, 0));
        Button_senbun_yoke_henkan.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/senbun_yoke_henkan.png")));


// ******************************************************************************
////b* アプリケ?[ション用?B?謫ｪが?^???^?^?^で始まる?sにはさまれた部分は無視される?B
// ******************************************************************************


// *******北*********************************************************************** 解??
        //JButton	Button_kaisetu		= new JButton(	"kaisetu"		);Button_kaisetu.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
        JButton Button_kaisetu = new JButton("Help");
        Button_kaisetu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //Button_kyoutuu_sagyou();

                ikaisetuhyouji = ikaisetuhyouji + 1;
                if (ikaisetuhyouji == 2) {
                    ikaisetuhyouji = 0;
                }
//System.out.println("ikaisetuhyouji="+ikaisetuhyouji);
                i_mouseDragged_yuukou = 0;
                i_mouseReleased_yuukou = 0;
//img_kaisetu_fname="kaisetu.png";readImageFromFile3();
                //readImageFromFile2();

                repaint();
            }
        });
        Button_kaisetu.setMargin(new Insets(0, 0, 0, 0));
        pnln.add(Button_kaisetu);

        Button_kaisetu.setMargin(new Insets(0, 0, 0, 0));
        Button_kaisetu.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/kaisetu.png")));

// ******************************************************************************


        // *************************************************
        //?ｶ辺?i?ｼ側?jパネルの?\築*************************
        // *************************************************
        //?ｶ辺?i?ｼ側?jパネルの???ｬ


        Panel pnlw = new Panel();
        pnlw.setBackground(Color.PINK);
        pnlw.setLayout(new GridLayout(32, 1));


        //パネルpnlwをレイアウト?ｶ辺?i?ｼ側?jに貼り付け
        add("West", pnlw); //Frame用
        //contentPane.add(pnlw, BorderLayout.WEST);//JFrame用
// ****?ｼ**************************************************************************

        //------------------------------------------------
        Panel pnlw26 = new Panel();
        pnlw26.setBackground(Color.PINK);
        pnlw26.setLayout(new GridLayout(1, 3));

        pnlw.add(pnlw26);
        //------------------------------------------------

// *****?ｼ******************* Un Do ******************************************************

        JButton Button_undo = new JButton("");
        Button_undo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/undo.png";
                readImageFromFile3();
                //es1.setMemo(Ubox.getMemo());
                setTitle(es1.undo());
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw26.add(Button_undo);
        Button_undo.setMargin(new Insets(0, 0, 0, 0));
        Button_undo.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/undo.png")));

// *****?ｼ*************************************************************************


        text10 = new JTextField("", 1);
        text10.setHorizontalAlignment(JTextField.RIGHT);

        pnlw26.add(text10);
// *****?ｼ*************************************************************************
        JButton Button_undo_syutoku = new JButton("S");
        Button_undo_syutoku.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                img_kaisetu_fname = "qqq/undo_syutoku.png";
                readImageFromFile3();
                int i_undo_suu_old = i_undo_suu;
                i_undo_suu = ms.String2int(text10.getText(), i_undo_suu_old);
                if (i_undo_suu < 0) {
                    i_undo_suu = 0;
                }
                text10.setText(String.valueOf(i_undo_suu));
                es1.set_Ubox_undo_suu(i_undo_suu);


            }
        });
        pnlw26.add(Button_undo_syutoku);

        Button_undo_syutoku.setMargin(new Insets(0, 0, 0, 0));


// *****?ｼ*********************** Re Do **************************************************

        JButton Button_redo = new JButton("");
        Button_redo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                img_kaisetu_fname = "qqq/redo.png";
                readImageFromFile3();

                setTitle(es1.redo());
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw26.add(Button_redo);
        Button_redo.setMargin(new Insets(0, 0, 0, 0));
        Button_redo.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/redo.png")));


// ********************************************************


// ********************************************************

        //------------------------------------------------
        Panel pnlw22 = new Panel();
        pnlw22.setBackground(Color.PINK);
        pnlw22.setLayout(new GridLayout(1, 3));

        pnlw.add(pnlw22);
        //------------------------------------------------

        //------------------------------------------------
        Panel pnlw23 = new Panel();
        pnlw23.setBackground(Color.PINK);
        pnlw23.setLayout(new GridLayout(1, 2));

        pnlw22.add(pnlw23);
        //------------------------------------------------

// ****?ｼ*********************?@?????@下げ?@*****************************************************
        JButton Button_senhaba_sage = new JButton("");
        Button_senhaba_sage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                iTenkaizuSenhaba = iTenkaizuSenhaba - 2;
                if (iTenkaizuSenhaba < 1) {
                    iTenkaizuSenhaba = 1;
                }
                //else{iTenkaizuSenhaba=1;}
                img_kaisetu_fname = "qqq/senhaba_sage.png";
                readImageFromFile3();
                //Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw23.add(Button_senhaba_sage);

        Button_senhaba_sage.setMargin(new Insets(0, 0, 0, 0));
        Button_senhaba_sage.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/senhaba_sage.png")));

// ****?ｼ********************?@?????@?繧ｰ?@******************************************************

        JButton Button_senhaba_age = new JButton("");
        Button_senhaba_age.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                iTenkaizuSenhaba = iTenkaizuSenhaba + 2;
                img_kaisetu_fname = "qqq/senhaba_age.png";
                readImageFromFile3();
                //Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw23.add(Button_senhaba_age);

        Button_senhaba_age.setMargin(new Insets(0, 0, 0, 0));
        Button_senhaba_age.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/senhaba_age.png")));


        //------------------------------------------------
        Panel pnlw24 = new Panel();
        pnlw24.setBackground(Color.PINK);
        pnlw24.setLayout(new GridLayout(1, 2));

        pnlw22.add(pnlw24);
        //------------------------------------------------


// ****?ｼ********************************?@点???@下げ?@******************************************点??

        JButton Button_tenhaba_sage = new JButton("");
        Button_tenhaba_sage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/tenhaba_sage.png";
                readImageFromFile3();

                ir_ten = ir_ten - 1;
                if (ir_ten < 0) {
                    ir_ten = 0;
                }
                es1.set_ir_ten(ir_ten);

                //Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw24.add(Button_tenhaba_sage);

        Button_tenhaba_sage.setMargin(new Insets(0, 0, 0, 0));
        Button_tenhaba_sage.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/tenhaba_sage.png")));

// ****?ｼ*******************************?@点???@?繧ｰ?@*******************************************
        JButton Button_tenhaba_age = new JButton("");
        Button_tenhaba_age.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/tenhaba_age.png";
                readImageFromFile3();

                ir_ten = ir_ten + 1;
                //if(ir_ten<0){ir_ten=0;}
                es1.set_ir_ten(ir_ten);

                //Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw24.add(Button_tenhaba_age);

        Button_tenhaba_age.setMargin(new Insets(0, 0, 0, 0));
        Button_tenhaba_age.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/tenhaba_age.png")));

// ******?ｼ*************展開?}の??をアンチエイリアス表示にする***********************************************************
        JButton Button_anti_alias = new JButton("a_a");
        Button_anti_alias.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Button_kyoutuu_sagyou();
                i_anti_alias = i_anti_alias + 1;
                if (i_anti_alias >= 2) {
                    i_anti_alias = 0;
                }

                if (i_anti_alias == 0) {
                    senhaba_for_anti_alias = 1.0;
                }
                if (i_anti_alias == 1) {
                    senhaba_for_anti_alias = 1.2;
                }
                img_kaisetu_fname = "qqq/anti_alias.png";
                readImageFromFile3();


                //js.set_i_anti_alias(i_anti_alias);
                repaint();
            }
        });
        pnlw22.add(Button_anti_alias);

        Button_anti_alias.setMargin(new Insets(0, 0, 0, 0));
        //Button_anti_alias.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
        //  "ppp/anti_alias.png")));


        //------------------------------------------------
        Panel pnlw27 = new Panel();
        pnlw27.setBackground(Color.PINK);
        pnlw27.setLayout(new GridLayout(1, 4));

        pnlw.add(pnlw27);
        //------------------------------------------------

        //------------------------------------------------
        Panel pnlw30 = new Panel();
        pnlw30.setBackground(Color.PINK);
        pnlw30.setLayout(new GridLayout(1, 4));

        pnlw27.add(pnlw30);
        //------------------------------------------------
// ********************************************************?ﾜ??の表現方法

        JButton Button_orisen_hyougen = new JButton("");
        Button_orisen_hyougen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Button_kyoutuu_sagyou();
                i_orisen_hyougen = i_orisen_hyougen + 1;
                if (i_orisen_hyougen >= 5) {
                    i_orisen_hyougen = 1;
                }

                img_kaisetu_fname = "qqq/orisen_hyougen.png";
                readImageFromFile3();

                repaint();
            }
        });
        pnlw27.add(Button_orisen_hyougen);

        Button_orisen_hyougen.setMargin(new Insets(0, 0, 0, 0));
        Button_orisen_hyougen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/orisen_hyougen.png")));


        //------------------------------------------------
        Panel pnlw31 = new Panel();
        pnlw31.setBackground(Color.PINK);
        pnlw31.setLayout(new GridLayout(1, 4));

        pnlw27.add(pnlw31);
        //------------------------------------------------
// ******?ｼ************************************************************************
        //------------------------------------------------
        Panel pnlw25 = new Panel();
        pnlw25.setBackground(Color.PINK);
        pnlw25.setLayout(new GridLayout(1, 4));

        pnlw.add(pnlw25);
        //------------------------------------------------


        //-------------------------------------------------------------
        ButtonCol_red = new JButton("M");
        ButtonCol_red.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/ButtonCol_red.png";
                readImageFromFile3();
                ButtonCol_irokesi();
                ButtonCol_red.setForeground(Color.black);
                ButtonCol_red.setBackground(Color.red);
                icol = 1;
                es1.setcolor(icol);
                // Button_kyoutuu_sagyou();

//iro_sitei_ato_ni_jissisuru_sagyou();

                repaint();
            }
        });
        pnlw25.add(ButtonCol_red);
        ButtonCol_red.setBackground(new Color(150, 150, 150));
        ButtonCol_red.setMargin(new Insets(0, 0, 0, 0));
//ButtonCol_red.setImage("board.png");

// ******?ｼ************************************************************************

        //-------------------------------------------------------------
        ButtonCol_blue = new JButton("V");
        ButtonCol_blue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

//sub = new SubThread(this);


                img_kaisetu_fname = "qqq/ButtonCol_blue.png";
                readImageFromFile3();
                ButtonCol_irokesi();
                ButtonCol_blue.setForeground(Color.black);
                ButtonCol_blue.setBackground(Color.blue);
                icol = 2;
                es1.setcolor(icol);
                // Button_kyoutuu_sagyou();

//iro_sitei_ato_ni_jissisuru_sagyou();

                repaint();
            }
        });
        pnlw25.add(ButtonCol_blue);
        ButtonCol_blue.setBackground(new Color(150, 150, 150));
        ButtonCol_blue.setMargin(new Insets(0, 0, 0, 0));
// ******?ｼ************************************************************************
        //-------------------------------------------------------------

        ButtonCol_black = new JButton("E");
        ButtonCol_black.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/ButtonCol_black.png";
                readImageFromFile3();
                //ButtonCol_black 	= new JButton(	"Edge"	);ButtonCol_black.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {

                ButtonCol_irokesi();
                ButtonCol_black.setForeground(Color.white);
                ButtonCol_black.setBackground(Color.black);
                icol = 0;
                es1.setcolor(icol);
                //  Button_kyoutuu_sagyou();

//iro_sitei_ato_ni_jissisuru_sagyou();

                repaint();
            }
        });
        pnlw25.add(ButtonCol_black);
        ButtonCol_black.setBackground(new Color(150, 150, 150));
        ButtonCol_black.setMargin(new Insets(0, 0, 0, 0));
// ******?ｼ************************************************************************
        //-------------------------------------------------------------

        ButtonCol_cyan = new JButton("A");
        ButtonCol_cyan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/ButtonCol_cyan.png";
                readImageFromFile3();

                ButtonCol_irokesi();
                ButtonCol_cyan.setForeground(Color.black);
                ButtonCol_cyan.setBackground(Color.cyan);
                icol = 3;
                es1.setcolor(icol);
                //  Button_kyoutuu_sagyou();

//iro_sitei_ato_ni_jissisuru_sagyou();

                repaint();
            }
        });
        pnlw25.add(ButtonCol_cyan);
        ButtonCol_cyan.setBackground(new Color(150, 150, 150));
        ButtonCol_cyan.setMargin(new Insets(0, 0, 0, 0));


//icol=3 cyan
//icol=4 orange
//icol=5 mazenta
//icol=6 green
//icol=7 yellow

// ******?ｼ************************************************************************
        //------------------------------------------------
        Panel pnlw1 = new Panel();
        pnlw1.setBackground(Color.PINK);
        pnlw1.setLayout(new GridLayout(1, 3));
        pnlw.add(pnlw1);//パネルpnlw1をpnlwに貼り付け


        //Button	Button_senbun_nyuryoku	= new Button(	"L_draw"	);Button_senbun_nyuryoku.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
// -----1;??分入力モ?[ド?B
        JButton Button_senbun_nyuryoku = new JButton("");
        Button_senbun_nyuryoku.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/senbun_nyuryoku.png";
                readImageFromFile3();
                i_orisen_hojyosen = 0;//=0は?ﾜ??入力?@=1は補????入力モ?[ド
                es1.set_i_orisen_hojyosen(i_orisen_hojyosen);//このボタンと機能は補?賦G??共通に使っているのでi_orisen_hojyosenの指定がいる
                i_mouse_modeA = 1;
                iro_sitei_ato_ni_jissisuru_sagyou_bangou = 1;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw1.add(Button_senbun_nyuryoku);


        Button_senbun_nyuryoku.setMargin(new Insets(0, 0, 0, 0));
        Button_senbun_nyuryoku.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/senbun_nyuryoku.png")));

// ------1;??分入力モ?[ド?Bここまで


// -------------11;??分入力モ?[ド?B
        JButton Button_senbun_nyuryoku11 = new JButton("");
        Button_senbun_nyuryoku11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Button	Button_senbun_nyuryoku11	= new Button(	"L_draw11"	);Button_senbun_nyuryoku11.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/senbun_nyuryoku11.png";
                readImageFromFile3();
                i_mouse_modeA = 11;
                iro_sitei_ato_ni_jissisuru_sagyou_bangou = 11;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });

        pnlw1.add(Button_senbun_nyuryoku11);

        Button_senbun_nyuryoku11.setMargin(new Insets(0, 0, 0, 0));
        Button_senbun_nyuryoku11.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/senbun_nyuryoku11.png")));


// -------------11;??分入力モ?[ド?Bここまで

// -----62 62 62 ボ??ノイ?}?BVoronoi 20181020

        JButton Button_Voronoi = new JButton("");
        Button_Voronoi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/Voronoi.png";
                readImageFromFile3();
                i_orisen_hojyosen = 0;//=0は?ﾜ??入力?@=1は補????入力モ?[ド
                es1.set_i_orisen_hojyosen(i_orisen_hojyosen);//このボタンと機能は補?賦G??共通に使っているのでi_orisen_hojyosenの指定がいる
                i_mouse_modeA = 62;
                iro_sitei_ato_ni_jissisuru_sagyou_bangou = 62;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw1.add(Button_Voronoi);


        Button_Voronoi.setMargin(new Insets(0, 0, 0, 0));
        Button_Voronoi.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/Voronoi.png")));

// ------1;??分入力モ?[ド?Bここまで
// *******?ｼ***********************************************************************
// -------------38;?ﾜり?ﾝ可能??入力
        JButton Button_oritatami_kanousen = new JButton("");
        Button_oritatami_kanousen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/oritatami_kanousen.png";
                readImageFromFile3();

                i_mouse_modeA = 38;
                iro_sitei_ato_ni_jissisuru_sagyou_bangou = 38;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw1.add(Button_oritatami_kanousen);

        Button_oritatami_kanousen.setMargin(new Insets(0, 0, 0, 0));
        Button_oritatami_kanousen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/oritatami_kanousen.png")));


// -------------38;?ﾜり?ﾝ可能??入力?Bここまで

// *******?ｼ***********************************************************************

        //------------------------------------------------
        Panel pnlw2 = new Panel();
        pnlw2.setBackground(Color.PINK);
        pnlw2.setLayout(new GridLayout(1, 4));
        pnlw.add(pnlw2);//パネルpnlw2をpnlwに貼り付け

// ******************************************************************************
// -------------5;??分延長モ?[ド?B
        JButton Button_senbun_entyou = new JButton("");//Button_senbun_entyou	= new JButton(	"L_en"	);
        Button_senbun_entyou.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/senbun_entyou.png";
                readImageFromFile3();

                i_mouse_modeA = 5;
                iro_sitei_ato_ni_jissisuru_sagyou_bangou = 5;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();


                es1.set_i_orikaesi(0);


            }
        });
        pnlw2.add(Button_senbun_entyou);

        Button_senbun_entyou.setMargin(new Insets(0, 0, 0, 0));
        Button_senbun_entyou.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/senbun_entyou.png")));

// -------------5;??分延長モ?[ド?Bここまで
// ******************************************************************************

// ******************************************************************************
// -------------5_2;??分延長モ?[ド?B
        JButton Button_senbun_entyou_2 = new JButton("");//Button_senbun_entyou	= new JButton(	"L_en"	);
        Button_senbun_entyou_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/senbun_entyou_2.png";
                readImageFromFile3();

                i_mouse_modeA = 5;
                iro_sitei_ato_ni_jissisuru_sagyou_bangou = 5;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();


                es1.set_i_orikaesi(1);


            }
        });
        pnlw2.add(Button_senbun_entyou_2);

        Button_senbun_entyou_2.setMargin(new Insets(0, 0, 0, 0));
        Button_senbun_entyou_2.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/senbun_entyou_2.png")));

// -------------5;??分延長モ?[ド?Bここまで
// ******************************************************************************


// -------------7;角二等分??モ?[ド?B
        JButton Button_kaku_toubun = new JButton("");//Button_kaku_toubun	= new JButton(	"kaku_toubun"	);
        Button_kaku_toubun.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/kaku_toubun.png";
                readImageFromFile3();

                i_mouse_modeA = 7;
                iro_sitei_ato_ni_jissisuru_sagyou_bangou = 7;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw2.add(Button_kaku_toubun);

        Button_kaku_toubun.setMargin(new Insets(0, 0, 0, 0));
        Button_kaku_toubun.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/kaku_toubun.png")));

// -------------7;角二等分??モ?[ド?Bここまで

// ******************************************************************************
// -------------8;内?Sモ?[ド?B
        JButton Button_naishin = new JButton("");//Button_naishin	= new JButton(	"naishin"	);
        Button_naishin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/naishin.png";
                readImageFromFile3();

                i_mouse_modeA = 8;
                iro_sitei_ato_ni_jissisuru_sagyou_bangou = 8;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw2.add(Button_naishin);

        Button_naishin.setMargin(new Insets(0, 0, 0, 0));
        Button_naishin.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/naishin.png")));

// -------------8;内?Sモ?[ド?Bここまで


// *******?ｼ***********************************************************************


        //------------------------------------------------
        Panel pnlw3 = new Panel();
        pnlw3.setBackground(Color.PINK);
        pnlw3.setLayout(new GridLayout(1, 3));
        pnlw.add(pnlw3);


// *******?ｼ***********************************************************************
// -------------9;????おろしモ?[ド?B
        JButton Button_suisen = new JButton("");//Button_suisen	= new JButton(	"suisen"	);
        Button_suisen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/suisen.png";
                readImageFromFile3();

                i_mouse_modeA = 9;
                iro_sitei_ato_ni_jissisuru_sagyou_bangou = 9;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw3.add(Button_suisen);

        Button_suisen.setMargin(new Insets(0, 0, 0, 0));
        Button_suisen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/suisen.png")));


// -------------9;????おろしモ?[ド?Bここまで


// *******?ｼ***********************************************************************
// -------------10;?ﾜり返しモ?[ド?B
        JButton Button_orikaesi = new JButton("");//Button_orikaesi	= new JButton(	"orikaesi"	);
        Button_orikaesi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/orikaesi.png";
                readImageFromFile3();

                i_mouse_modeA = 10;
                iro_sitei_ato_ni_jissisuru_sagyou_bangou = 10;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw3.add(Button_orikaesi);

        Button_orikaesi.setMargin(new Insets(0, 0, 0, 0));
        Button_orikaesi.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/orikaesi.png")));


// -------------10;?ﾜり返しモ?[ド?Bここまで


// *******?ｼ***********************************************************************
// -------------52;連続?ﾜり返しモ?[ド?B
        JButton Button_renzoku_orikaesi = new JButton("");
        Button_renzoku_orikaesi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/renzoku_orikaesi.png";
                readImageFromFile3();

                i_mouse_modeA = 52;
                iro_sitei_ato_ni_jissisuru_sagyou_bangou = 52;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw3.add(Button_renzoku_orikaesi);

        Button_renzoku_orikaesi.setMargin(new Insets(0, 0, 0, 0));
        Button_renzoku_orikaesi.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/renzoku_orikaesi.png")));


// -------------52;連続?ﾜり返しモ?[ド?Bここまで


// *******?ｼ***********************************************************************
        //------------------------------------------------
        Panel pnlw4 = new Panel();
        pnlw4.setBackground(Color.PINK);
        pnlw4.setLayout(new GridLayout(1, 3));
        pnlw.add(pnlw4);


// *******?ｼ***********************************************************************
// -------------40;平?s??入力モ?[ド?B
        JButton Button_heikousen = new JButton("");//Button_suisen	= new JButton(	"suisen"	);
        Button_heikousen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/heikousen.png";
                readImageFromFile3();
                i_mouse_modeA = 40;
                iro_sitei_ato_ni_jissisuru_sagyou_bangou = 40;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw4.add(Button_heikousen);
        Button_heikousen.setMargin(new Insets(0, 0, 0, 0));
        Button_heikousen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/heikousen.png")));
// -------------40;平?s??入力モ?[ド?Bここまで

// -------------51;平?s???@??指定入力モ?[ド?B
        JButton Button_heikousen_haba_sitei = new JButton("");
        Button_heikousen_haba_sitei.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/heikousen_haba_sitei.png";
                readImageFromFile3();
                i_mouse_modeA = 51;
                iro_sitei_ato_ni_jissisuru_sagyou_bangou = 51;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw4.add(Button_heikousen_haba_sitei);
        Button_heikousen_haba_sitei.setMargin(new Insets(0, 0, 0, 0));
        Button_heikousen_haba_sitei.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/heikousen_haba_sitei.png")));
// -------------51;平?s???@??指定入力モ?[ド?Bここまで


// *******?ｼ***********************************************************************
// -------------39;?ﾜり?ﾝ可能??+格子点系入力
        JButton Button_oritatami_kanousen_and_kousitenkei = new JButton("");
        Button_oritatami_kanousen_and_kousitenkei.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/oritatami_kanousen_and_kousitenkei.png";
                readImageFromFile3();

                i_mouse_modeA = 39;
                iro_sitei_ato_ni_jissisuru_sagyou_bangou = 39;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw4.add(Button_oritatami_kanousen_and_kousitenkei);

        Button_oritatami_kanousen_and_kousitenkei.setMargin(new Insets(0, 0, 0, 0));
        Button_oritatami_kanousen_and_kousitenkei.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/oritatami_kanousen_and_kousitenkei.png")));


// -------------39;?ﾜり?ﾝ可能??+格子点系入力?Bここまで

        //------------------------------------------------
        Panel pnlw29 = new Panel();
        pnlw29.setBackground(Color.PINK);
        pnlw29.setLayout(new GridLayout(1, 2));
        pnlw.add(pnlw29);
        //------------------------------------------------


// ******?ｼ**********全kouho??分(??分入力時の一時的な??分)を実?ﾜ??に変換モ?[ド**************************************************************
        JButton Button_all_s_step_to_orisen = new JButton("");//
        Button_all_s_step_to_orisen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("i_egaki_dankai = " + es1.i_egaki_dankai);
                System.out.println("i_kouho_dankai = " + es1.i_kouho_dankai);


                img_kaisetu_fname = "qqq/all_s_step_to_orisen.png";
                readImageFromFile3();
                //i_mouse_modeA=19;System.out.println("i_mouse_modeA = "+i_mouse_modeA);
                //es1.v_del_all_cc();
                es1.all_s_step_to_orisen();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw29.add(Button_all_s_step_to_orisen);
        Button_all_s_step_to_orisen.setMargin(new Insets(0, 0, 0, 0));
        Button_all_s_step_to_orisen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/all_s_step_to_orisen.png")));

        //Button_v_del_all.setBackground(Color.green);

// ********?ｼ**********************************************************************
// -------------33;魚の?怎??[ド?B

        JButton Button_sakananohone = new JButton("");
        Button_sakananohone.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/sakananohone.png";
                readImageFromFile3();

                i_mouse_modeA = 33;
                iro_sitei_ato_ni_jissisuru_sagyou_bangou = 33;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw29.add(Button_sakananohone);

        Button_sakananohone.setMargin(new Insets(0, 0, 0, 0));
        Button_sakananohone.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/sakananohone.png")));


// -------------10;魚の?怎??[ド?Bここまで


// *******?ｼ***********************************************************************
// -------------35;複?ﾜり返しモ?[ド?B
        JButton Button_fuku_orikaesi = new JButton("");//Button_orikaesi	= new JButton(	"orikaesi"	);
        Button_fuku_orikaesi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/fuku_orikaesi.png";
                readImageFromFile3();

                i_mouse_modeA = 35;
                iro_sitei_ato_ni_jissisuru_sagyou_bangou = 35;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw29.add(Button_fuku_orikaesi);

        Button_fuku_orikaesi.setMargin(new Insets(0, 0, 0, 0));
        Button_fuku_orikaesi.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/fuku_orikaesi.png")));


// -------------35;複?ﾜり返しモ?[ド?Bここまで


// ********?ｼ**********************************************************************


        //------------------------------------------------
        Panel pnlw15 = new Panel();
        pnlw15.setBackground(Color.PINK);
        pnlw15.setLayout(new GridLayout(1, 3));

        pnlw.add(pnlw15);
        //------------------------------------------------

// ******?ｼ************************************************************************
// -----1;??分入力モ?[ド?B分割?箔?力
        text2 = new JTextField("", 2);
        text2.setHorizontalAlignment(JTextField.RIGHT);
        pnlw15.add(text2);


// -------------------------------------------------------------------------------

        //Button	Button_senbun_bunkatu_set
// -----1;??分分割?敗et
        JButton Button_senbun_bunkatu_set = new JButton("Set");
        Button_senbun_bunkatu_set.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int i_orisen_bunkatu_suu_old = i_orisen_bunkatu_suu;
                i_orisen_bunkatu_suu = ms.String2int(text2.getText(), i_orisen_bunkatu_suu_old);
                if (i_orisen_bunkatu_suu < 1) {
                    i_orisen_bunkatu_suu = 1;
                }
                text2.setText(String.valueOf(i_orisen_bunkatu_suu));
                es1.set_i_orisen_bunkatu_suu(i_orisen_bunkatu_suu);

                img_kaisetu_fname = "qqq/senbun_bunkatu_set.png";
                readImageFromFile3();
                i_mouse_modeA = 27;
                iro_sitei_ato_ni_jissisuru_sagyou_bangou = 27;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw15.add(Button_senbun_bunkatu_set);

        Button_senbun_bunkatu_set.setMargin(new Insets(0, 0, 0, 0));
        //Button_senbun_bunkatu_set.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
        //"ppp/senbun_bunkatu_set.png")));

// ------1;??分分割?敗et?Bここまで


// -------------------------------------------------------------------------------


// -----27;??分分割入力モ?[ド?B
        JButton Button_senbun_b_nyuryoku = new JButton("");
        Button_senbun_b_nyuryoku.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int i_orisen_bunkatu_suu_old = i_orisen_bunkatu_suu;
                i_orisen_bunkatu_suu = ms.String2int(text2.getText(), i_orisen_bunkatu_suu_old);
                if (i_orisen_bunkatu_suu < 1) {
                    i_orisen_bunkatu_suu = 1;
                }
                text2.setText(String.valueOf(i_orisen_bunkatu_suu));
                es1.set_i_orisen_bunkatu_suu(i_orisen_bunkatu_suu);

                img_kaisetu_fname = "qqq/senbun_b_nyuryoku.png";
                readImageFromFile3();
                i_mouse_modeA = 27;
                iro_sitei_ato_ni_jissisuru_sagyou_bangou = 27;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw15.add(Button_senbun_b_nyuryoku);

        Button_senbun_b_nyuryoku.setMargin(new Insets(0, 0, 0, 0));
        Button_senbun_b_nyuryoku.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/senbun_b_nyuryoku.png")));

// ------27;??分入力モ?[ド?Bここまで


        //------------------------------------------------
        Panel pnlw6 = new Panel();
        pnlw6.setBackground(Color.PINK);
        pnlw6.setLayout(new GridLayout(1, 3));
        pnlw.add(pnlw6);
/*
// ******?ｼ************************************************************************

		//Button	Button_senbun_nyuryoku	= new Button(	"L_draw"	);Button_senbun_nyuryoku.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
// -----61;長方形内選択モ?[ド?B
		JButton	Button_tyouhoukei_select	= new JButton(	""	);
			Button_tyouhoukei_select.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
	img_kaisetu_fname="qqq/tyouhoukei_select.png";readImageFromFile3();
						i_orisen_hojyosen=0;//=0は?ﾜ??入力?@=1は補????入力モ?[ド
						es1.set_i_orisen_hojyosen(i_orisen_hojyosen);//このボタンと機能は補?賦G??共通に使っているのでi_orisen_hojyosenの指定がいる
						i_mouse_modeA=61;iro_sitei_ato_ni_jissisuru_sagyou_bangou=1;
						System.out.println("i_mouse_modeA = "+i_mouse_modeA);

						es1.unselect_all();Button_kyoutuu_sagyou();repaint();
	  }});
		pnlw6.add(Button_tyouhoukei_select);


		Button_tyouhoukei_select.setMargin(new Insets(0,0,0,0));
		Button_tyouhoukei_select.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
		  "ppp/tyouhoukei_select.png")));

// ------61;長方形内選択モ?[ド?Bここまで
*/

// ******?ｼ************************************************************************
//------------------------------------------------
        JButton Button_select =
                new JButton("sel");
        Button_select.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/Select.png";
                readImageFromFile3();

                i_mouse_modeA = 19;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw6.add(Button_select);

        //Button_select.setBorder(new LineBorder(Color.green, 4, true));
        Button_select.setBackground(Color.green);
        //Button_select.setBackground(Color.white);
        Button_select.setMargin(new Insets(0, 0, 0, 0));


//------------------------------------------------

// ******?ｼ************************************************************************
        JButton Button_select_all = new JButton("s_al");//
        Button_select_all.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/select_all.png";
                readImageFromFile3();
                //i_mouse_modeA=19;
                es1.select_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw6.add(Button_select_all);
        //Button_select_all.setMargin(new Insets(0,0,0,0));
        //Button_select_all.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
        //"ppp/select_all.png")));
        //Button_select_all.setBorder(new LineBorder(Color.green, 4, true));
        Button_select_all.setBackground(Color.green);
        Button_select_all.setMargin(new Insets(0, 0, 0, 0));

// ****?ｼ**************************************************************************

        //------------------------------------------------
        Panel pnlw7 = new Panel();
        pnlw7.setBackground(Color.PINK);
        pnlw7.setLayout(new GridLayout(1, 2));
        pnlw.add(pnlw7);


//------------------------------------------------
        JButton Button_unselect =
                new JButton("unsel");
        Button_unselect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/unselect.png";
                readImageFromFile3();

                i_mouse_modeA = 20;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw7.add(Button_unselect);
        // Button_unselect.setBackground(new Color(200,150,150));
        //Button_unselect.setBorder(new LineBorder(Color.green, 4, true));
        Button_unselect.setBackground(Color.green);
        Button_unselect.setMargin(new Insets(0, 0, 0, 0));


//------------------------------------------------

        JButton Button_unselect_all = new JButton("uns_al");//
        Button_unselect_all.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/unselect_all.png";
                readImageFromFile3();
                //i_mouse_modeA=19;
                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw7.add(Button_unselect_all);
        //Button_unselect_all.setMargin(new Insets(0,0,0,0));
        //Button_unselect_all.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
        //"ppp/unselect_all.png")));
        //Button_unselect_all.setBorder(new LineBorder(Color.green, 4, true));
        Button_unselect_all.setBackground(Color.green);
        Button_unselect_all.setMargin(new Insets(0, 0, 0, 0));
// ******************************************************************************

// *****?ｼ*************************************************************************


        //------------------------------------------------
        Panel pnlw16 = new Panel();
        pnlw16.setBackground(Color.PINK);
        pnlw16.setLayout(new GridLayout(1, 2));
        pnlw.add(pnlw16);


// -------------21;移動モ?[ド?B
        Button_move = new JButton("move");
        Button_move.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/move.png";
                readImageFromFile3();
                i_sel_mou_mode = 1;
                Button_sel_mou_wakukae();


                i_mouse_modeA = 21;
                Button_kyoutuu_sagyou();
                repaint();
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);


            }
        });
        pnlw16.add(Button_move);
        Button_move.setBackground(new Color(170, 220, 170));
        Button_move.setMargin(new Insets(0, 0, 0, 0));
        //Button_move.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
        //  "ppp/move.png")));
// -------------21;移動モ?[ド?Bここまで


// -------------31;移動2p2pモ?[ド?B
        Button_move_2p2p = new JButton("mv_4p");
        Button_move_2p2p.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/move_2p2p.png";
                readImageFromFile3();
                i_sel_mou_mode = 2;
                Button_sel_mou_wakukae();


                i_mouse_modeA = 31;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw16.add(Button_move_2p2p);
        Button_move_2p2p.setBackground(new Color(170, 220, 170));
        Button_move_2p2p.setMargin(new Insets(0, 0, 0, 0));
        //Button_move_2p2p.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
        //  "ppp/move_2p2p.png")));
// -------------31;移動2p2pモ?[ド?Bここまで


// *********?ｼ*********************************************************************


        //------------------------------------------------
        Panel pnlw17 = new Panel();
        pnlw17.setBackground(Color.PINK);
        pnlw17.setLayout(new GridLayout(1, 2));
        pnlw.add(pnlw17);


// -------------22;コピ?[モ?[ド?B
        Button_copy_paste = new JButton("copy");
        Button_copy_paste.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/copy_paste.png";
                readImageFromFile3();
                i_sel_mou_mode = 3;
                Button_sel_mou_wakukae();


                i_mouse_modeA = 22;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw17.add(Button_copy_paste);
        Button_copy_paste.setBackground(new Color(170, 220, 170));
        Button_copy_paste.setMargin(new Insets(0, 0, 0, 0));
        //Button_copy_paste.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
        //  "ppp/copy_paste.png")));
// -------------22;コピ?[モ?[ド?Bここまで


// -------------32;コピ?[2p2pモ?[ド?B
        Button_copy_paste_2p2p = new JButton("cp_4p");
        Button_copy_paste_2p2p.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/copy_paste_2p2p.png";
                readImageFromFile3();
                i_sel_mou_mode = 4;
                Button_sel_mou_wakukae();


                i_mouse_modeA = 32;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw17.add(Button_copy_paste_2p2p);
        Button_copy_paste_2p2p.setBackground(new Color(170, 220, 170));
        Button_copy_paste_2p2p.setMargin(new Insets(0, 0, 0, 0));
        //Button_copy_paste_2p2p.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
        //  "ppp/copy_paste_2p2p.png")));
// -------------32;コピ?[2p2pモ?[ド?Bここまで


// ********?ｼ**********************************************************************

        //------------------------------------------------
        Panel pnlw35 = new Panel();
        pnlw35.setBackground(Color.PINK);
        pnlw35.setLayout(new GridLayout(1, 2));
        pnlw.add(pnlw35);


// -------------12;鏡映モ?[ド?B
        Button_kyouei = new JButton("");//new JButton(	"kyouei"	);
        Button_kyouei.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/kyouei.png";
                readImageFromFile3();
                i_sel_mou_mode = 5;
                Button_sel_mou_wakukae();

                i_mouse_modeA = 12;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw35.add(Button_kyouei);
        Button_kyouei.setBackground(new Color(170, 220, 170));
        Button_kyouei.setMargin(new Insets(0, 0, 0, 0));
        Button_kyouei.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/kyouei.png")));


// -------------12;鏡映モ?[ド?Bここまで


// *******?ｼ***********************************************************************
// -------------;selectした?ﾜ??の????
        JButton Button_del_selected_senbun = new JButton("d_s_L");//new JButton(	"del_sel_L"	);
        Button_del_selected_senbun.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/del_selected_senbun.png";
                readImageFromFile3();
                es1.del_selected_senbun();
                es1.kiroku();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw35.add(Button_del_selected_senbun);
        Button_del_selected_senbun.setMargin(new Insets(0, 0, 0, 0));
        //Button_del_selected_senbun.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
        // "ppp/del_selected_senbun.png")));


// -------------selectした?ﾜ??の?????Bここまで


        //JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        //separator.setPreferredSize(new Dimension(50 , 1));
//pnlw.add(separator);


        //------------------------------------------------
        Panel pnlw5 = new Panel();
        pnlw5.setBackground(Color.PINK);
        pnlw5.setLayout(new GridLayout(1, 2));
        pnlw.add(pnlw5);


// ******?ｼ************************************************************************ ?ﾁしゴム

// -------------;??分???怎??[ド?B
        JButton Button_senbun_sakujyo = new JButton("");//JButton	Button_senbun_sakujyo	= new JButton(	"L_del"	);
        Button_senbun_sakujyo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/senbun_sakujyo.png";
                readImageFromFile3();
                i_mouse_modeA = 3;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);


                i_orisen_hojyosen = 0;//=0は?ﾜ??入力?@=1は補????入力モ?[ド
                es1.set_i_orisen_hojyosen(i_orisen_hojyosen);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw5.add(Button_senbun_sakujyo);

        Button_senbun_sakujyo.setMargin(new Insets(0, 0, 0, 0));
        Button_senbun_sakujyo.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/senbun_sakujyo.png")));


// ******?ｼ************************************************************************ ????のみの?ﾁしゴム

// -------------;????のみの??分???怎??[ド?B
        JButton Button_kuro_senbun_sakujyo = new JButton("");//JButton	Button_senbun_sakujyo	= new JButton(	"L_del"	);
        Button_kuro_senbun_sakujyo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/kuro_senbun_sakujyo.png";
                readImageFromFile3();
                i_mouse_modeA = 3;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);


                i_orisen_hojyosen = 2;//=2は?浮ﾌ?ﾜ?????怎??[ド
                es1.set_i_orisen_hojyosen(i_orisen_hojyosen);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw5.add(Button_kuro_senbun_sakujyo);

        Button_kuro_senbun_sakujyo.setMargin(new Insets(0, 0, 0, 0));
        Button_kuro_senbun_sakujyo.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/kuro_senbun_sakujyo.png")));


// ******?ｼ************************************************************************ ?ﾁしゴム(補?賦???のみ)

// -------------;??分???怎??[ド?B?ﾁしゴム(補?賦???のみ)
        JButton Button_senbun3_sakujyo = new JButton("");//JButton	Button_senbun_sakujyo	= new JButton(	"L_del"	);
        Button_senbun3_sakujyo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/senbun3_sakujyo.png";
                readImageFromFile3();
                i_mouse_modeA = 3;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);


                i_orisen_hojyosen = 3;//=0は?ﾜ??入力?@=1は補????入力モ?[ド =3は補?賦???のみ対?ﾛ
                es1.set_i_orisen_hojyosen(i_orisen_hojyosen);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw5.add(Button_senbun3_sakujyo);

        Button_senbun3_sakujyo.setMargin(new Insets(0, 0, 0, 0));
        Button_senbun3_sakujyo.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/senbun3_sakujyo.png")));


// *********?ｼ*********************************************************************
// -------------;
        JButton Button_eda_kesi = new JButton("");//JButton	Button_eda_kesi		= new JButton(	"Trim"	);
        Button_eda_kesi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/eda_kesi.png";
                readImageFromFile3();
                es1.ten_sakujyo();
                es1.jyuufuku_senbun_sakujyo();
                es1.eda_kesi(0.000001);
                es1.en_seiri();
                es1.kiroku();
                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw5.add(Button_eda_kesi);


        Button_eda_kesi.setMargin(new Insets(0, 0, 0, 0));
        Button_eda_kesi.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/eda_kesi.png")));

// ******?ｼ************************************************************************


// *****?ｼ*************************************************************************


        //------------------------------------------------
        Panel pnlw8 = new Panel();
        pnlw8.setBackground(Color.PINK);
        pnlw8.setLayout(new GridLayout(1, 4));
        //------------------------------------------------
        pnlw.add(pnlw8);

// *******?ｼ***********************************************************************
        Button_M_nisuru = new JButton(" ");
        Button_M_nisuru.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/M_nisuru.png";
                readImageFromFile3();
                Button_irokesi();
                Button_M_nisuru.setForeground(Color.black);
                Button_M_nisuru.setBackground(Color.red);
                //icol=1;es1.setcolor(icol);
                i_mouse_modeA = 23;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();


            }
        });
        pnlw8.add(Button_M_nisuru);
        Button_M_nisuru.setBackground(Color.white);
        Button_M_nisuru.setMargin(new Insets(0, 0, 0, 0));

        Button_M_nisuru.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/M_nisuru.png")));

//Button_M_nisuru.setHorizontalTextPosition(JButton.RIGHT);


// ******************************************************************************
        Button_V_nisuru = new JButton(" ");
        Button_V_nisuru.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/V_nisuru.png";
                readImageFromFile3();
                Button_irokesi();
                Button_V_nisuru.setForeground(Color.black);
                Button_V_nisuru.setBackground(Color.blue);
                //icol=1;es1.setcolor(icol);
                i_mouse_modeA = 24;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw8.add(Button_V_nisuru);
        Button_V_nisuru.setBackground(Color.white);
        Button_V_nisuru.setMargin(new Insets(0, 0, 0, 0));

        Button_V_nisuru.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/V_nisuru.png")));
// ******************************************************************************
        Button_E_nisuru = new JButton(" ");
        Button_E_nisuru.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/E_nisuru.png";
                readImageFromFile3();
                Button_irokesi();
                Button_E_nisuru.setForeground(Color.white);
                Button_E_nisuru.setBackground(Color.black);
                //icol=1;es1.setcolor(icol);
                i_mouse_modeA = 25;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw8.add(Button_E_nisuru);
        Button_E_nisuru.setBackground(Color.white);
        Button_E_nisuru.setMargin(new Insets(0, 0, 0, 0));

        Button_E_nisuru.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/E_nisuru.png")));


// ******************************************************************************

        Button_HK_nisuru = new JButton(" ");//HKとは補?賦???のこと
        Button_HK_nisuru.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/HK_nisuru.png";
                readImageFromFile3();
                Button_irokesi();
                Button_HK_nisuru.setForeground(Color.white);
                Button_HK_nisuru.setBackground(new Color(100, 200, 200));
                //icol=1;es1.setcolor(icol);
                i_mouse_modeA = 60;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw8.add(Button_HK_nisuru);
        Button_HK_nisuru.setBackground(Color.white);
        Button_HK_nisuru.setMargin(new Insets(0, 0, 0, 0));

        Button_HK_nisuru.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/HK_nisuru.png")));


// ******************************************************************************

        //------------------------------------------------
        Panel pnlw28 = new Panel();
        pnlw28.setBackground(Color.PINK);
        pnlw28.setLayout(new GridLayout(1, 2));

        //------------------------------------------------
        pnlw.add(pnlw28);


// *****?ｼ*************************************************************************
        JButton Button_zen_yama_tani_henkan = new JButton("AC");
        Button_zen_yama_tani_henkan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/zen_yama_tani_henkan.png";
                readImageFromFile3();
                es1.zen_yama_tani_henkan();
                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw28.add(Button_zen_yama_tani_henkan);
        Button_zen_yama_tani_henkan.setMargin(new Insets(0, 0, 0, 0));
// ******?ｼ************************************************************************??分の?Fを?ﾔから?ﾂ?A?ﾂから?ﾔに変換

        //JButton	Button_senbun_henkan2	= new JButton(	""	);//new JButton(	"L_chan"	);
        Button_senbun_henkan2 = new JButton("");//new JButton(	"L_chan"	);
        Button_senbun_henkan2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/senbun_henkan2.png";
                readImageFromFile3();
                Button_irokesi();
                //Button_senbun_henkan2.setForeground(Color.black);
                Button_senbun_henkan2.setBackground(new Color(138, 43, 226));


                i_mouse_modeA = 58;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw28.add(Button_senbun_henkan2);

        Button_senbun_henkan2.setBackground(Color.white);
        Button_senbun_henkan2.setMargin(new Insets(0, 0, 0, 0));
        Button_senbun_henkan2.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/senbun_henkan2.png")));

// ******?ｼ************************************************************************??分の?Fを???A?ﾔ?A?A?ﾂ?A?浮ﾌ?№ﾉ変換

        JButton Button_senbun_henkan = new JButton("");//new JButton(	"L_chan"	);
        Button_senbun_henkan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/senbun_henkan.png";
                readImageFromFile3();
                Button_irokesi();

                i_mouse_modeA = 4;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw28.add(Button_senbun_henkan);

        Button_senbun_henkan.setMargin(new Insets(0, 0, 0, 0));
        Button_senbun_henkan.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/senbun_henkan.png")));


// ******?ｼ************************************************************************

        //------------------------------------------------
        Panel pnlw21 = new Panel();
        pnlw21.setBackground(Color.PINK);
        pnlw21.setLayout(new GridLayout(1, 3));
        //------------------------------------------------
        pnlw.add(pnlw21);

// ****************************************************************************** //??内?F変換

        JButton Button_in_L_col_change = new JButton("");//new JButton(	"in_L_col_change"	);
        Button_in_L_col_change.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/in_L_col_change.png";
                readImageFromFile3();

                i_mouse_modeA = 34;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                iro_sitei_ato_ni_jissisuru_sagyou_bangou = 34;


                if (icol == 0) {
                    icol = 1;
                    es1.setcolor(icol);                                        //?ﾅ?奄ﾌ?ﾜ??の?Fを指定する?B0は???A1は?ﾔ?A2は?ﾂ?B
                    ButtonCol_irokesi();
                    ButtonCol_red.setForeground(Color.black);
                    ButtonCol_red.setBackground(Color.red);    //?ﾜ??のボタンの?F?ﾝ定
                }


                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw21.add(Button_in_L_col_change);

        Button_in_L_col_change.setMargin(new Insets(0, 0, 0, 0));
        Button_in_L_col_change.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/in_L_col_change.png")));


// ****************************************************************************** //??X交?ｷ?F変換

        JButton Button_on_L_col_change = new JButton("");//new JButton(	"on_L_col_change"	);
        Button_on_L_col_change.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/on_L_col_change.png";
                readImageFromFile3();
                i_mouse_modeA = 36;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                iro_sitei_ato_ni_jissisuru_sagyou_bangou = 36;


                if (icol == 0) {
                    icol = 2;
                    es1.setcolor(icol);                                        //?ﾅ?奄ﾌ?ﾜ??の?Fを指定する?B0は???A1は?ﾔ?A2は?ﾂ?B
                    ButtonCol_irokesi();
                    ButtonCol_blue.setForeground(Color.black);
                    ButtonCol_blue.setBackground(Color.blue);    //?ﾜ??のボタンの?F?ﾝ定
                }


                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw21.add(Button_on_L_col_change);

        Button_on_L_col_change.setMargin(new Insets(0, 0, 0, 0));
        Button_on_L_col_change.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/on_L_col_change.png")));


// *******?ｼ***********************************************************************

        //------------------------------------------------
        Panel pnlw10 = new Panel();
        pnlw10.setBackground(Color.PINK);
        pnlw10.setLayout(new GridLayout(1, 4));

        pnlw.add(pnlw10);
        //------------------------------------------------
// -------------14;点追加モ?[ド?B
        JButton Button_v_add = new JButton("");// new JButton(	"V_add"	);
        Button_v_add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/v_add.png";
                readImageFromFile3();
                i_mouse_modeA = 14;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw10.add(Button_v_add);

        Button_v_add.setMargin(new Insets(0, 0, 0, 0));
        Button_v_add.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/v_add.png")));


// -------------14;点追加モ?[ド?Bここまで

// ******************************************************************************
// -------------15;点???怎??[ド?B
        JButton Button_v_del = new JButton("");//new JButton(	"V_del"	);
        Button_v_del.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/v_del.png";
                readImageFromFile3();

                i_mouse_modeA = 15;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw10.add(Button_v_del);

        Button_v_del.setMargin(new Insets(0, 0, 0, 0));
        Button_v_del.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/v_del.png")));


// -------------15;点???怎??[ド?Bここまで


// -------------15;点???怎??[ド?iカラ?[チェンジ?j?B
        JButton Button_v_del_cc = new JButton("");//new JButton(	"V_del"	);
        Button_v_del_cc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/v_del_cc.png";
                readImageFromFile3();

                i_mouse_modeA = 41;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw10.add(Button_v_del_cc);

        Button_v_del_cc.setMargin(new Insets(0, 0, 0, 0));
        Button_v_del_cc.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/v_del_cc.png")));


// -------------15;点???怎??[ド?Bここまで

// ****?ｼ**************************************************************************


        //------------------------------------------------
        Panel pnlw13 = new Panel();
        pnlw13.setBackground(Color.PINK);
        pnlw13.setLayout(new GridLayout(1, 3));

        //------------------------------------------------
        pnlw.add(pnlw13);


// ******************************************************************************
// ******?ｼ**********全点???怎??[ド?B*****(両側の?ﾜ??の?Fが同じものに実?s)?B*********************************************************
        JButton Button_v_del_all = new JButton("");//
        Button_v_del_all.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/v_del_all.png";
                readImageFromFile3();
                //i_mouse_modeA=19;
                es1.v_del_all();
                System.out.println("es1.v_del_all()");
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw13.add(Button_v_del_all);
        Button_v_del_all.setMargin(new Insets(0, 0, 0, 0));
        Button_v_del_all.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/v_del_all.png")));

        //Button_v_del_all.setBackground(Color.green);


// ******?ｼ**********全点???怎??[ド(両側の?ﾜ??の?Fが違っても実?s)?B**************************************************************
        JButton Button_v_del_all_cc = new JButton("");//
        Button_v_del_all_cc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/v_del_all_cc.png";
                readImageFromFile3();
                //i_mouse_modeA=19;
                es1.v_del_all_cc();
                System.out.println("es1.v_del_all_cc()");
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw13.add(Button_v_del_all_cc);
        Button_v_del_all_cc.setMargin(new Insets(0, 0, 0, 0));
        Button_v_del_all_cc.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/v_del_all_cc.png")));

        //Button_v_del_all.setBackground(Color.green);


// ****?ｼ**************************************************************************


        //------------------------------------------------
        Panel pnlw32 = new Panel();
        pnlw32.setBackground(Color.PINK);
        pnlw32.setLayout(new GridLayout(1, 3));

        //------------------------------------------------
        pnlw.add(pnlw32);


// *********?ｼ*********************************************************************

        //------------------------------------------------
        Panel pnlw9 = new Panel();
        pnlw9.setBounds(2, 2, 93, 20);
        pnlw9.setBackground(Color.PINK);
        pnlw9.setLayout(null);
        //pnlw9.setLayout(new GridLayout(1,5));
        //------------------------------------------------
        pnlw.add(pnlw9);


// *******?ｼ***********************************************************************
//------------------------------------------------
        //格子表示2
        Button_kitei2 = new JButton("");//new JButton(	"Grid2"	);
        Button_kitei2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/kitei2.png";
                readImageFromFile3();

                nyuuryoku_kitei = nyuuryoku_kitei / 2;
                if (nyuuryoku_kitei < 1) {
                    nyuuryoku_kitei = 1;
                }

                if (nyuuryoku_kitei < -0) {
                    nyuuryoku_kitei = -1;
                }

                //ボタンの?F変え
                if (nyuuryoku_kitei >= 1) {
                    Button_kitei.setForeground(Color.black);
                    Button_kitei.setBackground(Color.white);
                }
                if (nyuuryoku_kitei == 0) {
                    Button_kitei.setForeground(Color.black);
                    Button_kitei.setBackground(new Color(0, 200, 200));
                }
                //ボタンの?F変え(ここまで)
                //ボタンの?F変え
                if (nyuuryoku_kitei >= 1) {
                    Button_kitei2.setForeground(Color.black);
                    Button_kitei2.setBackground(Color.white);
                }
                if (nyuuryoku_kitei == 0) {
                    Button_kitei2.setForeground(Color.black);
                    Button_kitei2.setBackground(new Color(0, 200, 200));
                }
                //ボタンの?F変え(ここまで)

                text1.setText(String.valueOf(nyuuryoku_kitei));
                es1.set_kousi_bunkatu_suu(nyuuryoku_kitei);
                //Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw9.add(Button_kitei2);
        Button_kitei2.setBounds(0, 1, 20, 19);

        Button_kitei2.setMargin(new Insets(0, 0, 0, 0));
        Button_kitei2.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/kitei2.png")));


// *****?ｼ*************************************************************************

        text1 = new JTextField("", 2);
        text1.setHorizontalAlignment(JTextField.RIGHT);
        text1.setBounds(20, 1, 35, 19);
        pnlw9.add(text1);

// *****?ｼ*************************************************************************
        //JButton button_syutoku = new JButton("取得");
        JButton Button_syutoku = new JButton("S");
        Button_syutoku.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                img_kaisetu_fname = "qqq/syutoku.png";
                readImageFromFile3();
                set_kousi_bunkatu_suu();


            }
        });
        pnlw9.add(Button_syutoku);
        Button_syutoku.setBounds(55, 1, 15, 19);
        Button_syutoku.setMargin(new Insets(0, 0, 0, 0));
        //Button_syutoku.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
        //  "ppp/syutoku.png")));


//-------?ｼ-----------------------------------------
        //格子表示
        Button_kitei = new JButton("");// new JButton(	"Grid"	);

        Button_kitei.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/kitei.png";
                readImageFromFile3();

                nyuuryoku_kitei = nyuuryoku_kitei * 2;
                //if(nyuuryoku_kitei>20){nyuuryoku_kitei=20;}

                //ボタンの?F変え
                if (nyuuryoku_kitei >= 1) {
                    Button_kitei.setForeground(Color.black);
                    Button_kitei.setBackground(Color.white);
                }
                if (nyuuryoku_kitei == 0) {
                    Button_kitei.setForeground(Color.black);
                    Button_kitei.setBackground(new Color(0, 200, 200));
                }
                //ボタンの?F変え(ここまで)
                //ボタンの?F変え
                if (nyuuryoku_kitei >= 1) {
                    Button_kitei2.setForeground(Color.black);
                    Button_kitei2.setBackground(Color.white);
                }
                if (nyuuryoku_kitei == 0) {
                    Button_kitei2.setForeground(Color.black);
                    Button_kitei2.setBackground(new Color(0, 200, 200));
                }
                //ボタンの?F変え(ここまで)
                text1.setText(String.valueOf(nyuuryoku_kitei));
                es1.set_kousi_bunkatu_suu(nyuuryoku_kitei);
                //Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw9.add(Button_kitei);

        Button_kitei.setBounds(70, 1, 20, 19);
        Button_kitei.setMargin(new Insets(0, 0, 0, 0));
        Button_kitei.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/kitei.png")));

//------------------------------------//System.out.println("__");----

// -------------格子??の?Fの選択
        JButton Button_kousi_color = new JButton("C");
        Button_kousi_color.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/kousi_color.png";
                readImageFromFile3();
                //Button_kyoutuu_sagyou();
                i_mouseDragged_yuukou = 0;
                i_mouseReleased_yuukou = 0;

                //以下にやりたいことを?曹ｭ
                JColorChooser colorchooser = new JColorChooser();
                Color color = JColorChooser.showDialog(null, "Col", new Color(230, 230, 230));
                if (color != null) {
                    kus.set_kousi_color(color);
                }
                //以?繧ﾅやりたいことは?曹ｫ?Iわり

                repaint();
            }
        });
        Button_kousi_color.setBounds(94, 1, 15, 19);
        Button_kousi_color.setMargin(new Insets(0, 0, 0, 0));
        pnlw9.add(Button_kousi_color);

        //?d要??意?@読み?桙ﾝや?曹ｫ?oしでファイルダイア??グのボックスが開くと?Aそれをフレ?[ムに?dなる位置で操??した?????Aファイルボックスが?ﾁえたときに?A
        //マウスのドラッグとリリ?[スが発?ｶする?Bこのため?A余計な操??がされてしまう可能?ｫがある?Bなお?Aこのときマウスクリックは発?ｶしない?B
        // i_mouseDragged_yuukou=0;や i_mouseReleased_yuukou=0;は?Aこの余計な操??を防ぐために指定している?B

// ********?ｼ**********************************************************************
        //------------------------------------------------
        Panel pnlw34 = new Panel();
        pnlw34.setBounds(2, 2, 93, 20);
        pnlw34.setBackground(Color.PINK);
        pnlw34.setLayout(null);
        //------------------------------------------------
        pnlw.add(pnlw34);

// ****?ｼ**************************************************************************
        JButton Button_kousi_senhaba_sage = new JButton("");
        Button_kousi_senhaba_sage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                kus.kousi_senhaba_sage();
                img_kaisetu_fname = "qqq/kousi_senhaba_sage.png";
                readImageFromFile3();
                //Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw34.add(Button_kousi_senhaba_sage);
        Button_kousi_senhaba_sage.setBounds(0, 1, 20, 19);
        Button_kousi_senhaba_sage.setMargin(new Insets(0, 0, 0, 0));
        Button_kousi_senhaba_sage.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/kousi_senhaba_sage.png")));

// ****?ｼ**************************************************************************

        JButton Button_kousi_senhaba_age = new JButton("");
        Button_kousi_senhaba_age.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                kus.kousi_senhaba_age();
                img_kaisetu_fname = "qqq/kousi_senhaba_age.png";
                readImageFromFile3();
                //Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw34.add(Button_kousi_senhaba_age);
        Button_kousi_senhaba_age.setBounds(20, 1, 20, 19);
        Button_kousi_senhaba_age.setMargin(new Insets(0, 0, 0, 0));
        Button_kousi_senhaba_age.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/kousi_senhaba_age.png")));

// ---------------------------------------------------


        //基底?i格子?jの?ｵ   =0は全域で無効だが?A格子??だけは既存端点への引き寄せ半径の?ﾝ定に使うので有効?A?ｵ=1は用紙内のみ有効?A?ｵ=2は全領域で有効
        JButton Button_i_kitei_jyoutai = new JButton("");
        Button_i_kitei_jyoutai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                img_kaisetu_fname = "qqq/i_kitei_jyoutai.png";
                readImageFromFile3();

                es1.set_i_kitei_jyoutai(es1.get_i_kitei_jyoutai() + 1);
                //Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw34.add(Button_i_kitei_jyoutai);
        Button_i_kitei_jyoutai.setBounds(40, 1, 69, 19);
        Button_i_kitei_jyoutai.setMargin(new Insets(0, 0, 0, 0));
        Button_i_kitei_jyoutai.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/i_kitei_jyoutai.png")));

//------------------------------------------


// ****?ｼ**************************************************************************

        //------------------------------------------------
        //Panel   pnlw33 = new Panel();
        //	pnlw33.setBackground(Color.PINK);
        //	pnlw33.setLayout(new GridLayout(1,3));
        //pnlw.add(pnlw33);
        //------------------------------------------------
        //------------------------------------------------
        Panel pnlw33 = new Panel();
        pnlw33.setBounds(2, 2, 93, 20);
        pnlw33.setBackground(Color.PINK);
        pnlw33.setLayout(null);
        //------------------------------------------------
        pnlw.add(pnlw33);

// *****?ｼ*************************************************************************

        JButton Button_memori_tate_idou = new JButton("");
        Button_memori_tate_idou.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/memori_tate_idou.png";
                readImageFromFile3();
                es1.a_to_heikouna_memori_iti_idou();

                //Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw33.add(Button_memori_tate_idou);
        Button_memori_tate_idou.setBounds(0, 1, 20, 19);
        Button_memori_tate_idou.setMargin(new Insets(0, 0, 0, 0));
        Button_memori_tate_idou.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/memori_tate_idou.png")));

// *****?ｼ*************************************************************************


        text25 = new JTextField("", 1);
        text25.setHorizontalAlignment(JTextField.RIGHT);
        text25.setBounds(20, 1, 35, 19);
        pnlw33.add(text25);

// *****?ｼ*************************************************************************
        JButton Button_memori_kankaku_syutoku = new JButton("S");
        Button_memori_kankaku_syutoku.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                img_kaisetu_fname = "qqq/memori_kankaku_syutoku.png";
                readImageFromFile3();
                int memori_kankaku_old = memori_kankaku;
                memori_kankaku = ms.String2int(text25.getText(), memori_kankaku_old);
                if (memori_kankaku < 0) {
                    memori_kankaku = 1;
                }
                text25.setText(String.valueOf(memori_kankaku));
                //es1.set_Ubox_undo_suu(i_undo_suu);
                es1.set_a_to_heikouna_memori_kannkaku(memori_kankaku);
                es1.set_b_to_heikouna_memori_kannkaku(memori_kankaku);

            }
        });
        pnlw33.add(Button_memori_kankaku_syutoku);
        Button_memori_kankaku_syutoku.setBounds(55, 1, 15, 19);
        Button_memori_kankaku_syutoku.setMargin(new Insets(0, 0, 0, 0));

// *****?ｼ*************************************************************************

        JButton Button_memori_yoko_idou = new JButton("");
        Button_memori_yoko_idou.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/memori_yoko_idou.png";
                readImageFromFile3();

                es1.b_to_heikouna_memori_iti_idou();
                //Button_kyoutuu_sagyou();repaint();
            }
        });
        pnlw33.add(Button_memori_yoko_idou);
        Button_memori_yoko_idou.setBounds(70, 1, 20, 19);

        Button_memori_yoko_idou.setMargin(new Insets(0, 0, 0, 0));
        Button_memori_yoko_idou.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/memori_yoko_idou.png")));


// -------------格子目?ｷり??の?Fの選択
        JButton Button_kousi_memori_color = new JButton("C");
        Button_kousi_memori_color.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/kousi_memori_color.png";
                readImageFromFile3();
                //Button_kyoutuu_sagyou();
                i_mouseDragged_yuukou = 0;
                i_mouseReleased_yuukou = 0;


                //以下にやりたいことを?曹ｭ
                JColorChooser colorchooser = new JColorChooser();
                //Color color = colorchooser.showDialog(null, "Col", Color.white    );
                Color color = JColorChooser.showDialog(null, "Col", new Color(180, 200, 180));
                if (color != null) {
                    kus.set_kousi_memori_color(color);
                }
                //以?繧ﾅやりたいことは?曹ｫ?Iわり

                repaint();
            }
        });
        Button_kousi_memori_color.setBounds(94, 1, 15, 19);
        Button_kousi_memori_color.setMargin(new Insets(0, 0, 0, 0));
        pnlw33.add(Button_kousi_memori_color);


        //?d要??意?@読み?桙ﾝや?曹ｫ?oしでファイルダイア??グのボックスが開くと?Aそれをフレ?[ムに?dなる位置で操??した?????Aファイルボックスが?ﾁえたときに?A
        //マウスのドラッグとリリ?[スが発?ｶする?Bこのため?A余計な操??がされてしまう可能?ｫがある?Bなお?Aこのときマウスクリックは発?ｶしない?B
        // i_mouseDragged_yuukou=0;や i_mouseReleased_yuukou=0;は?Aこの余計な操??を防ぐために指定している?B


// ********************************************************


        //------------------------------------------------
        JPanel pnlw19 = new JPanel();
        //pnlw19.setBounds(103, 2, 93, 20);
        pnlw19.setBounds(2, 2, 93, 20);
        pnlw19.setBackground(Color.PINK);
        pnlw19.setLayout(null);
        //pnlw19.setBorder(new LineBorder(Color.black, 1));

        pnlw.add(pnlw19);
        //------------------------------------------------

        text21 = new JTextField("", 2);


        text21.setBounds(2, 2, 30, 17);
        text21.setHorizontalAlignment(JTextField.RIGHT);
        pnlw19.add(text21);

        JLabel Lb08;
        Lb08 = new JLabel();
        Lb08.setBounds(32, 2, 8, 17);
        Lb08.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ppp/plus_min.png")));
        pnlw19.add(Lb08);

        text22 = new JTextField("", 2);
        text22.setBounds(40, 2, 30, 17);
        text22.setHorizontalAlignment(JTextField.RIGHT);
        pnlw19.add(text22);

        JLabel Lb09;
        Lb09 = new JLabel();
        Lb09.setBounds(70, 2, 9, 17);
        Lb09.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ppp/root_min.png")));
        pnlw19.add(Lb09);

        text23 = new JTextField("", 2);
        text23.setBounds(79, 2, 30, 17);
        text23.setHorizontalAlignment(JTextField.RIGHT);
        pnlw19.add(text23);

        //------------------------------------------------
        JPanel pnlw18 = new JPanel();

        pnlw18.setBounds(2, 2, 70, 20);
        pnlw18.setBackground(Color.PINK);
        pnlw18.setLayout(null);
        //pnlw18.setBorder(new LineBorder(Color.black, 1));

        pnlw.add(pnlw18);
        //------------------------------------------------

        text18 = new JTextField("", 2);
        text18.setBounds(2, 2, 30, 17);
        text18.setHorizontalAlignment(JTextField.RIGHT);
        pnlw18.add(text18);

        JLabel Lb06;
        Lb06 = new JLabel();
        Lb06.setBounds(32, 2, 8, 17);
        Lb06.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ppp/plus_min.png")));
        pnlw18.add(Lb06);

        text19 = new JTextField("", 2);
        text19.setBounds(40, 2, 30, 17);
        text19.setHorizontalAlignment(JTextField.RIGHT);
        pnlw18.add(text19);

        JLabel Lb07;
        Lb07 = new JLabel();
        Lb07.setBounds(70, 2, 9, 17);
        Lb07.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ppp/root_min.png")));
        pnlw18.add(Lb07);

        text20 = new JTextField("", 2);
        text20.setBounds(79, 2, 30, 17);
        text20.setHorizontalAlignment(JTextField.RIGHT);
        pnlw18.add(text20);


// *****?ｼ*************************************************************************
        //------------------------------------------------
        Panel pnlw14 = new Panel();
        pnlw14.setBackground(Color.PINK);
        pnlw14.setLayout(new GridLayout(1, 4));
        //pnlw9.setLayout(new FlowLayout(FlowLayout.LEFT));
        //pnlw9.setLayout(new FlowLayout(FlowLayout.LEFT));
        //------------------------------------------------

        pnlw.add(pnlw14);
// *****?ｼ*************************************************************************

        text24 = new JTextField("", 2);
        text24.setHorizontalAlignment(JTextField.RIGHT);
        pnlw14.add(text24);

// *****?ｼ*************************************************************************
        JButton Button_kousi_syutoku = new JButton("Set");
        Button_kousi_syutoku.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/kousi_syutoku.png";
                readImageFromFile3();
                set_kousi();
                //Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnlw14.add(Button_kousi_syutoku);

        Button_kousi_syutoku.setMargin(new Insets(0, 0, 0, 0));
        //Button_kousi_syutoku.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
        //  "ppp/kousi_syutoku.png")));


// *****?ｼ*************************************************************************xxxxxxxxxxxxxx


//------------------------------------------------qqqqqq
// ***東***************************************************************************

        // *************************************************
        //右辺?i東側?jパネルの?\築*************************
        // *************************************************
        //右辺?i東側?jパネルの???ｬ
        Panel pnle = new Panel();
        pnle.setBackground(Color.PINK);
        pnle.setLayout(new GridLayout(28, 1));

        //右辺?i東側?jパネルをレイアウトに貼り付け
        add("East", pnle); //Frame用
        //contentPane.add(pnle, BorderLayout.EAST);//JFrame用
//------------------------------------------------


        //------------------------------------------------
        Panel pnle20 = new Panel();
        pnle20.setBackground(Color.PINK);
        pnle20.setLayout(new GridLayout(1, 2));
        pnle.add(pnle20);
        //------------------------------------------------
// ***東***チェック系************************************************************************


        ckbox_check1 = new JCheckBox("ckO");
        ckbox_check1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/check1.png";
                readImageFromFile3();
                es1.unselect_all();

                if (ckbox_check1.isSelected()) {
                    es1.check1(0.001, 0.5);//r_hitosiiとr_heikouhanteiは?Ahitosiiとheikou_hanteiのずれの許容程度
                    es1.set_i_check1(1);
                } else {
                    es1.set_i_check1(0);
                }
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        ckbox_check1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ppp/ckbox_check1_off.png")));
        ckbox_check1.setSelectedIcon(new ImageIcon(getClass().getClassLoader().getResource("ppp/ckbox_check1_on.png")));
        ckbox_check1.setBorderPainted(true);
        ckbox_check1.setMargin(new Insets(0, 0, 0, 0));
        pnle20.add(ckbox_check1);


//------------------------------------------


        JButton Button_fix1 = new JButton("fxO");
        Button_fix1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                img_kaisetu_fname = "qqq/fix1.png";
                readImageFromFile3();
                es1.unselect_all();
                es1.fix1(0.001, 0.5);
                es1.check1(0.001, 0.5);
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnle20.add(Button_fix1);

        Button_fix1.setMargin(new Insets(0, 0, 0, 0));
        //Button_check.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
        //"ppp/check.png")));


//------------------------------------------
        //------------------------------------------------
        Panel pnle21 = new Panel();
        pnle21.setBackground(Color.PINK);
        pnle21.setLayout(new GridLayout(1, 2));
        pnle.add(pnle21);
        //------------------------------------------------


// ***東***チェック系************************************************************************

        ckbox_check2 = new JCheckBox("ckT");
        ckbox_check2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/check2.png";
                readImageFromFile3();
                es1.unselect_all();

                if (ckbox_check2.isSelected()) {
                    es1.check2(0.01, 0.5);//r_hitosiiとr_heikouhanteiは?Ahitosiiとheikou_hanteiのずれの許容程度
                    es1.set_i_check2(1);
                } else {
                    es1.set_i_check2(0);
                }
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        ckbox_check2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ppp/ckbox_check2_off.png")));
        ckbox_check2.setSelectedIcon(new ImageIcon(getClass().getClassLoader().getResource("ppp/ckbox_check2_on.png")));
        ckbox_check2.setBorderPainted(true);
        ckbox_check2.setMargin(new Insets(0, 0, 0, 0));
        pnle21.add(ckbox_check2);


//------------------------------------------


        JButton Button_fix2 = new JButton("fxT");
        Button_fix2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                img_kaisetu_fname = "qqq/fix2.png";
                readImageFromFile3();
                es1.unselect_all();
                es1.fix2(0.001, 0.5);
                es1.check2(0.001, 0.5);
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnle21.add(Button_fix2);

        Button_fix2.setMargin(new Insets(0, 0, 0, 0));
        //Button_check.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
        //"ppp/check.png")));

//------------------------------------------


// ***東****チェック系***********************************************************************
        //------------------------------------------------
        Panel pnle22 = new Panel();
        pnle22.setBackground(Color.PINK);
        pnle22.setLayout(new GridLayout(1, 2));
        //pnle.add(pnle22);
        //------------------------------------------------

//---チェック系---------------------------------------20170717 まだckbox_check3は実装していない?B

        ckbox_check3 = new JCheckBox("check A");
        ckbox_check3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/check3.png";
                readImageFromFile3();
                es1.unselect_all();

                if (ckbox_check3.isSelected()) {
                    es1.check3(0.0001);//r_hitosiiとr_heikouhanteiは?Ahitosiiとheikou_hanteiのずれの許容程度
                    es1.set_i_check3(1);
                } else {
                    es1.set_i_check3(0);
                }
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        ckbox_check3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ppp/ckbox_check3_off.png")));
        ckbox_check3.setSelectedIcon(new ImageIcon(getClass().getClassLoader().getResource("ppp/ckbox_check3_on.png")));
        ckbox_check3.setBorderPainted(true);
        ckbox_check3.setMargin(new Insets(0, 0, 0, 0));
        pnle22.add(ckbox_check3);

//------------------------------------------


//---------------頂点のチェック---------------------------
        //------------------------------------------------
        Panel pnle23 = new Panel();
        pnle23.setBackground(Color.PINK);
        pnle23.setLayout(new GridLayout(1, 2));
        pnle.add(pnle23);
        //------------------------------------------------


        ckbox_check4 = new JCheckBox("cAMV");
        ckbox_check4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/check4.png";
                readImageFromFile3();
                es1.unselect_all();

                if (ckbox_check4.isSelected()) {
                    es1.check4(0.0001);//r_hitosiiとr_heikouhanteiは?Ahitosiiとheikou_hanteiのずれの許容程度
                    es1.set_i_check4(1);
                } else {
                    es1.set_i_check4(0);
                }
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        ckbox_check4.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ppp/ckbox_check4_off.png")));
        ckbox_check4.setSelectedIcon(new ImageIcon(getClass().getClassLoader().getResource("ppp/ckbox_check4_on.png")));
        ckbox_check4.setBorderPainted(true);
        ckbox_check4.setMargin(new Insets(0, 0, 0, 0));
        pnle23.add(ckbox_check4);

// ****東**************************************************************************
        //------------------------------------------------
        Panel pnle29 = new Panel();
        pnle29.setBackground(Color.PINK);
        pnle29.setLayout(new GridLayout(1, 2));
        pnle23.add(pnle29);
        //------------------------------------------------


// ****東***頂点チェック結果表示円の?Fの濃さ調?ｮ?@下げ***********************************************************************

        JButton Button_ck4_color_sage = new JButton("");
        Button_ck4_color_sage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                es1.ck4_color_sage();
                img_kaisetu_fname = "qqq/ck4_color_sage.png";
                readImageFromFile3();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnle29.add(Button_ck4_color_sage);

        Button_ck4_color_sage.setMargin(new Insets(0, 0, 0, 0));
        Button_ck4_color_sage.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/ck4_color_sage.png")));

// ****東***頂点チェック結果表示円の?Fの濃さ調?ｮ?@?繧ｰ***********************************************************************

        JButton Button_ck4_color_age = new JButton("");
        Button_ck4_color_age.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                es1.ck4_color_age();
                img_kaisetu_fname = "qqq/ck4_color_age.png";
                readImageFromFile3();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnle29.add(Button_ck4_color_age);

        Button_ck4_color_age.setMargin(new Insets(0, 0, 0, 0));
        Button_ck4_color_age.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/ck4_color_age.png")));


//------------------------------------------


        //------------------------------------------------
        Panel pnle4 = new Panel();
        pnle4.setBackground(Color.PINK);
        pnle4.setLayout(new GridLayout(1, 3));

        pnle.add(pnle4);
        //------------------------------------------------


        //------------------------------------------------
        Panel pnle6 = new Panel();
        pnle6.setBackground(Color.PINK);
        //pnle6.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnle6.setLayout(null);
        //------------------------------------------------
        pnle.add(pnle6);

// 東***?@角度系入力?@***************************************************************************

        JButton Button_kakudo_kei_a_tiisaku = new JButton("");
        Button_kakudo_kei_a_tiisaku.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/kakudo_kei_a_tiisaku.png";
                readImageFromFile3();

                if (kakudokei_input_id == 1) {
                    i_mouse_modeA = 13;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 2) {
                    i_mouse_modeA = 16;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 3) {
                    i_mouse_modeA = 17;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 4) {
                    i_mouse_modeA = 18;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 5) {
                    i_mouse_modeA = 37;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }

                id_kakudo_kei_a = id_kakudo_kei_a + 1;//if(id_kakudo_kei_a<2){id_kakudo_kei_a=2;}
                Button_kakudo_kei_a.setText("180/" + new Integer(id_kakudo_kei_a).toString() + "=" + new Double((double) (Math.round((180.0 / ((double) id_kakudo_kei_a)) * 1000)) / 1000.0).toString());

                es1.set_id_kakudo_kei(id_kakudo_kei_a);
                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnle6.add(Button_kakudo_kei_a_tiisaku);
        Button_kakudo_kei_a_tiisaku.setMargin(new Insets(0, 0, 0, 0));
        Button_kakudo_kei_a_tiisaku.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/tiisaku.png")));
        Button_kakudo_kei_a_tiisaku.setBounds(2, 2, 10, 20);


        //Button_id_kakudo_kei_18.setHorizontalAlignment(JButton.LEFT);
// ***?@角度系入力?@***************************************************************************


        //-------------------------------------------------------------
        Button_kakudo_kei_a = new JButton("180/" + new Integer(id_kakudo_kei_a).toString() + "=" + new Double((double) (Math.round((180.0 / ((double) id_kakudo_kei_a)) * 1000)) / 1000.0).toString());
        Button_kakudo_kei_a.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/kakudo_kei_a.png";
                readImageFromFile3();

                if (kakudokei_input_id == 1) {
                    i_mouse_modeA = 13;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 2) {
                    i_mouse_modeA = 16;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 3) {
                    i_mouse_modeA = 17;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 4) {
                    i_mouse_modeA = 18;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 5) {
                    i_mouse_modeA = 37;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }

                Button_kakudo_kei_a.setText("180/" + new Integer(id_kakudo_kei_a).toString() + "=" + new Double((double) (Math.round((180.0 / ((double) id_kakudo_kei_a)) * 1000)) / 1000.0).toString());

                es1.set_id_kakudo_kei(id_kakudo_kei_a);
                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnle6.add(Button_kakudo_kei_a);
//ButtonCol_red.setBackground(new Color(150,150,150));
        Button_kakudo_kei_a.setMargin(new Insets(0, 0, 0, 0));
//ButtonCol_red.setImage("board.png");

        Button_kakudo_kei_a.setBounds(10, 2, 90, 20);


// *東**?@角度系入力?@***************************************************************************


        JButton Button_kakudo_kei_a_ookiku = new JButton("");
        Button_kakudo_kei_a_ookiku.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/kakudo_kei_a_ookiku.png";
                readImageFromFile3();

                if (kakudokei_input_id == 1) {
                    i_mouse_modeA = 13;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 2) {
                    i_mouse_modeA = 16;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 3) {
                    i_mouse_modeA = 17;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 4) {
                    i_mouse_modeA = 18;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 5) {
                    i_mouse_modeA = 37;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }

                id_kakudo_kei_a = id_kakudo_kei_a - 1;
                if (id_kakudo_kei_a < 2) {
                    id_kakudo_kei_a = 2;
                }
                Button_kakudo_kei_a.setText("180/" + new Integer(id_kakudo_kei_a).toString() + "=" + new Double((double) (Math.round((180.0 / ((double) id_kakudo_kei_a)) * 1000)) / 1000.0).toString());

                es1.set_id_kakudo_kei(id_kakudo_kei_a);
                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnle6.add(Button_kakudo_kei_a_ookiku);
        Button_kakudo_kei_a_ookiku.setMargin(new Insets(0, 0, 0, 0));
        Button_kakudo_kei_a_ookiku.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/ookiku.png")));

        Button_kakudo_kei_a_ookiku.setBounds(100, 2, 10, 20);

//東******************************************************************************


        //------------------------------------------------
        Panel pnle7 = new Panel();
        pnle7.setBackground(Color.PINK);
        //pnle6.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnle7.setLayout(null);
        //------------------------------------------------
        pnle.add(pnle7);

//東******?@角度系入力?@************************************************************************

        JButton Button_kakudo_kei_b_tiisaku = new JButton("");
        Button_kakudo_kei_b_tiisaku.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/kakudo_kei_b_tiisaku.png";
                readImageFromFile3();

                if (kakudokei_input_id == 1) {
                    i_mouse_modeA = 13;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 2) {
                    i_mouse_modeA = 16;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 3) {
                    i_mouse_modeA = 17;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 4) {
                    i_mouse_modeA = 18;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 5) {
                    i_mouse_modeA = 37;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }

                id_kakudo_kei_b = id_kakudo_kei_b + 1;//if(id_kakudo_kei_b<2){id_kakudo_kei_b=2;}
                Button_kakudo_kei_b.setText("180/" + new Integer(id_kakudo_kei_b).toString() + "=" + new Double((double) (Math.round((180.0 / ((double) id_kakudo_kei_b)) * 1000)) / 1000.0).toString());

                es1.set_id_kakudo_kei(id_kakudo_kei_b);
                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnle7.add(Button_kakudo_kei_b_tiisaku);
        Button_kakudo_kei_b_tiisaku.setMargin(new Insets(0, 0, 0, 0));
        Button_kakudo_kei_b_tiisaku.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/tiisaku.png")));
        Button_kakudo_kei_b_tiisaku.setBounds(2, 2, 10, 20);


        //Button_id_kakudo_kei_18.setHorizontalAlignment(JButton.LEFT);
// 東******************************************************************************


        //-------------------------------------------------------------
        Button_kakudo_kei_b = new JButton("180/" + new Integer(id_kakudo_kei_b).toString() + "=" + new Double((double) (Math.round((180.0 / ((double) id_kakudo_kei_b)) * 1000)) / 1000.0).toString());
        Button_kakudo_kei_b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/kakudo_kei_b.png";
                readImageFromFile3();

                if (kakudokei_input_id == 1) {
                    i_mouse_modeA = 13;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 2) {
                    i_mouse_modeA = 16;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 3) {
                    i_mouse_modeA = 17;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 4) {
                    i_mouse_modeA = 18;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 5) {
                    i_mouse_modeA = 37;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }

                Button_kakudo_kei_b.setText("180/" + new Integer(id_kakudo_kei_b).toString() + "=" + new Double((double) (Math.round((180.0 / ((double) id_kakudo_kei_b)) * 1000)) / 1000.0).toString());

                es1.set_id_kakudo_kei(id_kakudo_kei_b);
                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnle7.add(Button_kakudo_kei_b);
//ButtonCol_red.setBackground(new Color(150,150,150));
        Button_kakudo_kei_b.setMargin(new Insets(0, 0, 0, 0));
//ButtonCol_red.setImage("board.png");

        Button_kakudo_kei_b.setBounds(10, 2, 90, 20);


// 東******************************************************************************


        JButton Button_kakudo_kei_b_ookiku = new JButton("");
        Button_kakudo_kei_b_ookiku.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/kakudo_kei_b_ookiku.png";
                readImageFromFile3();

                if (kakudokei_input_id == 1) {
                    i_mouse_modeA = 13;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 2) {
                    i_mouse_modeA = 16;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 3) {
                    i_mouse_modeA = 17;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 4) {
                    i_mouse_modeA = 18;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 5) {
                    i_mouse_modeA = 37;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }

                id_kakudo_kei_b = id_kakudo_kei_b - 1;
                if (id_kakudo_kei_b < 2) {
                    id_kakudo_kei_b = 2;
                }
                Button_kakudo_kei_b.setText("180/" + new Integer(id_kakudo_kei_b).toString() + "=" + new Double((double) (Math.round((180.0 / ((double) id_kakudo_kei_b)) * 1000)) / 1000.0).toString());

                es1.set_id_kakudo_kei(id_kakudo_kei_b);
                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnle7.add(Button_kakudo_kei_b_ookiku);
        Button_kakudo_kei_b_ookiku.setMargin(new Insets(0, 0, 0, 0));
        Button_kakudo_kei_b_ookiku.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/ookiku.png")));

        Button_kakudo_kei_b_ookiku.setBounds(100, 2, 10, 20);

//東******************************************************************************


// ******************************************************************************
        JButton Button_id_kakudo_kei_12 = new JButton("180/12= 15");
        Button_id_kakudo_kei_12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/id_kakudo_kei_12.png";
                readImageFromFile3();

                if (kakudokei_input_id == 1) {
                    i_mouse_modeA = 13;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 2) {
                    i_mouse_modeA = 16;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 3) {
                    i_mouse_modeA = 17;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 4) {
                    i_mouse_modeA = 18;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 5) {
                    i_mouse_modeA = 37;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }

                es1.set_id_kakudo_kei(12);
                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        //      pnle.add(Button_id_kakudo_kei_12);


// 東******************************************************************************


// *******東***********************************************************************

        JButton Button_id_kakudo_kei_08 = new JButton("180/8= 22.5");
        Button_id_kakudo_kei_08.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/id_kakudo_kei_08.png";
                readImageFromFile3();

                if (kakudokei_input_id == 1) {
                    i_mouse_modeA = 13;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 2) {
                    i_mouse_modeA = 16;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 3) {
                    i_mouse_modeA = 17;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 4) {
                    i_mouse_modeA = 18;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 5) {
                    i_mouse_modeA = 37;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }

                es1.set_id_kakudo_kei(8);
                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        // pnle.add(Button_id_kakudo_kei_08);


// *******東***********************************************************************

        JPanel pnle18 = new JPanel();
        //pnlw33.setPreferredSize(new Dimension(93, 23));
        pnle18.setBounds(2, 2, 102, 21);
        pnle18.setBackground(Color.pink);
        //pnln12.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnle18.setLayout(null);
        //pnle18.setBorder(new LineBorder(Color.black, 1));

        pnle.add(pnle18);
        //------------------------------------------------

        text12 = new JTextField("", 2);
        text12.setBounds(2, 2, 33, 19);
        text12.setHorizontalAlignment(JTextField.RIGHT);
        pnle18.add(text12);

        text13 = new JTextField("", 2);
        text13.setBounds(35, 2, 33, 19);
        text13.setHorizontalAlignment(JTextField.RIGHT);
        pnle18.add(text13);

        text14 = new JTextField("", 2);
        text14.setBounds(68, 2, 33, 19);
        text14.setHorizontalAlignment(JTextField.RIGHT);
        pnle18.add(text14);


// -----自由角set
        JButton Button_jiyuu_kaku_set_a = new JButton("");
        Button_jiyuu_kaku_set_a.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                set_jiyuu_kaku_abc();
                img_kaisetu_fname = "qqq/jiyuu_kaku_set_a.png";
                readImageFromFile3();

                if (kakudokei_input_id == 1) {
                    i_mouse_modeA = 13;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 2) {
                    i_mouse_modeA = 16;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 3) {
                    i_mouse_modeA = 17;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 4) {
                    i_mouse_modeA = 18;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 5) {
                    i_mouse_modeA = 37;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }

                es1.set_id_kakudo_kei(0);
                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        Button_jiyuu_kaku_set_a.setBounds(101, 2, 10, 19);
        pnle18.add(Button_jiyuu_kaku_set_a);

        Button_jiyuu_kaku_set_a.setMargin(new Insets(0, 0, 0, 0));
        Button_jiyuu_kaku_set_a.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/jiyuu_kaku_set_a.png")));

// -----自由角set?Bここまで


// *******東***********************************************************************

        JPanel pnle19 = new JPanel();
        pnle19.setBounds(2, 2, 102, 21);
        pnle19.setBackground(Color.pink);
        pnle19.setLayout(null);
        //pnle19.setBorder(new LineBorder(Color.black, 1));

        pnle.add(pnle19);
        //------------------------------------------------

        text15 = new JTextField("", 2);
        text15.setBounds(2, 2, 33, 19);
        text15.setHorizontalAlignment(JTextField.RIGHT);
        pnle19.add(text15);

        text16 = new JTextField("", 2);
        text16.setBounds(35, 2, 33, 19);
        text16.setHorizontalAlignment(JTextField.RIGHT);
        pnle19.add(text16);

        text17 = new JTextField("", 2);
        text17.setBounds(68, 2, 33, 19);
        text17.setHorizontalAlignment(JTextField.RIGHT);
        pnle19.add(text17);


// -----自由角set
        JButton Button_jiyuu_kaku_set_b = new JButton("");
        Button_jiyuu_kaku_set_b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//set_naibun();
                set_jiyuu_kaku_def();
                img_kaisetu_fname = "qqq/jiyuu_kaku_set_b.png";
                readImageFromFile3();

                if (kakudokei_input_id == 1) {
                    i_mouse_modeA = 13;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 2) {
                    i_mouse_modeA = 16;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 3) {
                    i_mouse_modeA = 17;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 4) {
                    i_mouse_modeA = 18;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                if (kakudokei_input_id == 5) {
                    i_mouse_modeA = 37;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }

                es1.set_id_kakudo_kei(0);
                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        Button_jiyuu_kaku_set_b.setBounds(101, 2, 10, 19);
        pnle19.add(Button_jiyuu_kaku_set_b);

        Button_jiyuu_kaku_set_b.setMargin(new Insets(0, 0, 0, 0));
        Button_jiyuu_kaku_set_b.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/jiyuu_kaku_set_b.png")));

// -----自由角set?Bここまで


// *******東***********************************************************************


        //Button_id_kakudo_kei_17.setHorizontalAlignment(JButton.LEFT);


        //------------------------------------------------
        Panel pnle1 = new Panel();
        pnle1.setBackground(Color.PINK);
        pnle1.setLayout(new GridLayout(1, 3));

        //------------------------------------------------
        //	pnle.add(pnle1);


        //------------------------------------------------
        Panel pnle2 = new Panel();
        pnle2.setBackground(Color.PINK);
        pnle2.setLayout(new GridLayout(1, 3));

        //------------------------------------------------
        pnle.add(pnle2);


// -------------13;角度系モ?[ド?B
        JButton Button_deg = new JButton("");//new JButton(	"kakudokei"	);
        Button_deg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/deg.png";
                readImageFromFile3();

                kakudokei_input_id = 1;
                i_mouse_modeA = 13;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);


                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnle2.add(Button_deg);

        Button_deg.setMargin(new Insets(0, 0, 0, 0));
        Button_deg.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/deg.png")));
// -------------13;角度系モ?[ド?Bここまで


// -----東--------17;角度系モ?[ド?B//2点指定
        JButton Button_deg3 = new JButton("");//new JButton(	"kakudokei_3"	);
        Button_deg3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/deg3.png";
                readImageFromFile3();

                kakudokei_input_id = 3;
                i_mouse_modeA = 17;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);


                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnle2.add(Button_deg3);

        Button_deg3.setMargin(new Insets(0, 0, 0, 0));
        Button_deg3.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/deg3.png")));
// ------東-------17;角度系モ?[ド?Bここまで

// -------------37;角度規格化??分入力モ?[ド?B
        JButton Button_senbun_nyuryoku37 = new JButton("");
        Button_senbun_nyuryoku37.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Button	Button_senbun_nyuryoku37	= new Button(	"L_draw11"	);Button_senbun_nyuryoku11.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/senbun_nyuryoku37.png";
                readImageFromFile3();
                kakudokei_input_id = 5;
                i_mouse_modeA = 37;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();

//System.out.println("AAAAA_1a");
            }
        });

        pnle2.add(Button_senbun_nyuryoku37);

        Button_senbun_nyuryoku37.setMargin(new Insets(0, 0, 0, 0));
        Button_senbun_nyuryoku37.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/senbun_nyuryoku37.png")));


// -------------37;角度規格化??分入力モ?[ド?Bここまで


        //------------------------------------------------
        Panel pnle3 = new Panel();
        pnle3.setBackground(Color.PINK);
        pnle3.setLayout(new GridLayout(1, 2));

        //------------------------------------------------
        pnle.add(pnle3);
// ----東---------16;角度系モ?[ド?B
        JButton Button_deg2 = new JButton("");//new JButton(	"kakudokei_2"	);
        Button_deg2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/deg2.png";
                readImageFromFile3();
                kakudokei_input_id = 2;
                i_mouse_modeA = 16;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnle3.add(Button_deg2);

        Button_deg2.setMargin(new Insets(0, 0, 0, 0));
        Button_deg2.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/deg2.png")));
// -------------16;角度系モ?[ド?Bここまで

// ----東---------18;角度系モ?[ド?B2点指定?A自由末端
        JButton Button_deg4 = new JButton("");//new JButton(	"kakudokei_4"	);
        Button_deg4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/deg4.png";
                readImageFromFile3();
                kakudokei_input_id = 4;
                i_mouse_modeA = 18;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnle3.add(Button_deg4);

        Button_deg4.setMargin(new Insets(0, 0, 0, 0));
        Button_deg4.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/deg4.png")));
// -------------18;角度系モ?[ド?Bここまで


//東********東**********************************************************************


        //------------------------------------------------
        Panel pnle5 = new Panel();
        pnle5.setBackground(Color.PINK);
        pnle5.setLayout(new GridLayout(1, 3));

        pnle.add(pnle5);
        //------------------------------------------------

// ******東************************************************************************
// -----1;sei ?ｳ多角形入力モ?[ド?B角?箔?力
        text9 = new JTextField("", 2);
        text9.setHorizontalAlignment(JTextField.RIGHT);
        pnle5.add(text9);


// -------------------------------------------------------------------------------

        //Button	Button_senbun_bunkatu_set
// -----1;	角?敗et
        JButton Button_kakusuu_set = new JButton("Set");
        Button_kakusuu_set.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int i_sei_takakukei_old = i_sei_takakukei;
                i_sei_takakukei = ms.String2int(text9.getText(), i_sei_takakukei_old);
                if (i_sei_takakukei < 3) {
                    i_sei_takakukei = 3;
                }
                if (i_sei_takakukei > 100) {
                    i_sei_takakukei = 100;
                }
                text9.setText(String.valueOf(i_sei_takakukei));
                es1.set_i_sei_takakukei(i_sei_takakukei);

                img_kaisetu_fname = "qqq/kakusuu_set.png";
                readImageFromFile3();
                i_mouse_modeA = 29;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnle5.add(Button_kakusuu_set);

        Button_kakusuu_set.setMargin(new Insets(0, 0, 0, 0));
        //Button_senbun_bunkatu_set.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
        //"ppp/senbun_bunkatu_set.png")));

// ------1;角?敗et?Bここまで


// ------------------------qqqqqqqq-------------------------------------------------------

// -----29;?ｳ多角形入力モ?[ド?B
        JButton Button_sei_takakukei = new JButton("");
        Button_sei_takakukei.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int i_sei_takakukei_old = i_sei_takakukei;
                i_sei_takakukei = ms.String2int(text9.getText(), i_sei_takakukei_old);
                if (i_sei_takakukei < 3) {
                    i_sei_takakukei = 3;
                }
                text9.setText(String.valueOf(i_sei_takakukei));
                es1.set_i_sei_takakukei(i_sei_takakukei);

                img_kaisetu_fname = "qqq/sei_takakukei.png";
                readImageFromFile3();
                i_mouse_modeA = 29;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                iro_sitei_ato_ni_jissisuru_sagyou_bangou = 29;
                Button_kyoutuu_sagyou();
                repaint();
                es1.unselect_all();
            }
        });
        pnle5.add(Button_sei_takakukei);

        Button_sei_takakukei.setMargin(new Insets(0, 0, 0, 0));
        Button_sei_takakukei.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/sei_takakukei.png")));

// ------29;?ｳ多角形入力モ?[ド?Bここまで

// ********東******************************

        //------------------------------------------------
        Panel pnle31 = new Panel();
        pnle31.setBackground(Color.PINK);
        pnle31.setLayout(new GridLayout(1, 2));
        pnle.add(pnle31);
        //------------------------------------------------


// *************** 円?@?ﾜ??とは相互??用する補????として働く *************************************

// ********東******************************
        //------------------------------------------------
        Panel pnle9 = new Panel();
        pnle9.setBackground(Color.PINK);
        pnle9.setLayout(new GridLayout(1, 2));
        //------------------------------------------------
        pnle.add(pnle9);

// -------------47;円入力モ?[ド?B(フリ?[)
        JButton Button_en_nyuryoku_free = new JButton("");
        Button_en_nyuryoku_free.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/en_nyuryoku_free.png";
                readImageFromFile3();
                i_mouse_modeA = 47;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });

        pnle9.add(Button_en_nyuryoku_free);

        Button_en_nyuryoku_free.setMargin(new Insets(0, 0, 0, 0));
        Button_en_nyuryoku_free.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/en_nyuryoku_free.png")));


// -------------47;円入力モ?[ド?Bここまで


// -------------42;円入力モ?[ド?B
        JButton Button_en_nyuryoku = new JButton("");
        Button_en_nyuryoku.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/en_nyuryoku.png";
                readImageFromFile3();
                i_mouse_modeA = 42;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });

        pnle9.add(Button_en_nyuryoku);

        Button_en_nyuryoku.setMargin(new Insets(0, 0, 0, 0));
        Button_en_nyuryoku.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/en_nyuryoku.png")));


// -------------42;円入力モ?[ド?Bここまで

// -------------44;円?@分離入力モ?[ド?B(中?Sと半径とを離して指定する)
        JButton Button_en_bunri_nyuryoku = new JButton("");
        Button_en_bunri_nyuryoku.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/en_bunri_nyuryoku.png";
                readImageFromFile3();
                i_mouse_modeA = 44;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });

        pnle9.add(Button_en_bunri_nyuryoku);

        Button_en_bunri_nyuryoku.setMargin(new Insets(0, 0, 0, 0));
        Button_en_bunri_nyuryoku.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/en_bunri_nyuryoku.png")));


// -------------44;円?@分離入力モ?[ド?Bここまで

        //------------------------------------------------
        Panel pnle16 = new Panel();
        pnle16.setBackground(Color.PINK);
        pnle16.setLayout(new GridLayout(1, 3));

        pnle.add(pnle16);
        //------------------------------------------------


// -------------48;円?@同?S円追加モ?[ド?B(元円の円周と同?S円の円周との??は??分で指定する)
        JButton Button_dousin_en_tuika_s = new JButton("");
        Button_dousin_en_tuika_s.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/dousin_en_tuika_s.png";
                readImageFromFile3();
                i_mouse_modeA = 48;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });

        pnle16.add(Button_dousin_en_tuika_s);

        Button_dousin_en_tuika_s.setMargin(new Insets(0, 0, 0, 0));
        Button_dousin_en_tuika_s.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/dousin_en_tuika_s.png")));

// -------------48;円?@同?S円追加モ?[ド?Bここまで

// -------------49;円?@同?S円追加モ?[ド?B(元円の円周と同?S円の円周との??は他の同?S円の組で指定する)
        JButton Button_dousin_en_tuika_d = new JButton("");
        Button_dousin_en_tuika_d.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/dousin_en_tuika_d.png";
                readImageFromFile3();
                i_mouse_modeA = 49;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });

        pnle16.add(Button_dousin_en_tuika_d);

        Button_dousin_en_tuika_d.setMargin(new Insets(0, 0, 0, 0));
        Button_dousin_en_tuika_d.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/dousin_en_tuika_d.png")));

// -------------49;円?@同?S円追加モ?[ド?Bここまで

// ******************************************************************************


        //------------------------------------------------
        Panel pnle17 = new Panel();
        pnle17.setBackground(Color.PINK);
        pnle17.setLayout(new GridLayout(1, 3));

        pnle.add(pnle17);
        //------------------------------------------------


// -------------50;2円を指定し?Aそれぞれの円に同?S円を加える?Bそれぞれの同?S円の組にできる帯領域の??が等しくなるようにして?A加えられた同?S円同士が?ﾚするようにする?B
        JButton Button_en_en_dousin_en = new JButton("");
        Button_en_en_dousin_en.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/en_en_dousin_en.png";
                readImageFromFile3();

                i_mouse_modeA = 50;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnle17.add(Button_en_en_dousin_en);

        Button_en_en_dousin_en.setMargin(new Insets(0, 0, 0, 0));
        Button_en_en_dousin_en.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/en_en_dousin_en.png")));

// -------------50;2円の共通?ﾚ??入力モ?[ド?Bここまで


// -------------45;2円の共通?ﾚ??入力モ?[ド?B
        JButton Button_en_en_sessen = new JButton("");
        Button_en_en_sessen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/en_en_sessen.png";
                readImageFromFile3();

                i_mouse_modeA = 45;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnle17.add(Button_en_en_sessen);

        Button_en_en_sessen.setMargin(new Insets(0, 0, 0, 0));
        Button_en_en_sessen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/en_en_sessen.png")));

// -------------45;2円の共通?ﾚ??入力モ?[ド?Bここまで


// ********東******************************
        //------------------------------------------------
        Panel pnle10 = new Panel();
        pnle10.setBackground(Color.PINK);
        pnle10.setLayout(new GridLayout(1, 3));
        //------------------------------------------------
        pnle.add(pnle10);


// ******************************************************************************
// -------------43;3点円入力モ?[ド?B
        JButton Button_en_3ten_nyuryoku = new JButton("");
        Button_en_3ten_nyuryoku.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/en_3ten_nyuryoku.png";
                readImageFromFile3();

                i_mouse_modeA = 43;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnle10.add(Button_en_3ten_nyuryoku);

        Button_en_3ten_nyuryoku.setMargin(new Insets(0, 0, 0, 0));
        Button_en_3ten_nyuryoku.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/en_3ten_nyuryoku.png")));

// -------------43;3点円入力モ?[ド?Bここまで


// ******************************************************************************
// -------------46;反転入力モ?[ド?B
        JButton Button_hanten = new JButton("");
        Button_hanten.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/hanten.png";
                readImageFromFile3();

                i_mouse_modeA = 46;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnle10.add(Button_hanten);

        Button_hanten.setMargin(new Insets(0, 0, 0, 0));
        Button_hanten.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/hanten.png")));

// -------------46;反転入力モ?[ド?Bここまで


        //------------------------------------------------
        Panel pnle32 = new Panel();
        pnle32.setBackground(Color.PINK);
        pnle32.setLayout(new GridLayout(1, 2));
        pnle.add(pnle32);
        //------------------------------------------------


        //------------------------------------------------
        Panel pnle8 = new Panel();
        pnle8.setBackground(Color.white);
        pnle8.setLayout(new GridLayout(1, 2));
        //------------------------------------------------
        pnle.add(pnle8);

// ---------補????や円の?Fを特??で変えるさいの指定?Fの指定
        Button_sen_tokutyuu_color = new JButton("C_col ");
        Button_sen_tokutyuu_color.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/sen_tokutyuu_color.png";
                readImageFromFile3();
                Button_kyoutuu_sagyou();
                i_mouseDragged_yuukou = 0;
                i_mouseReleased_yuukou = 0;
                //以下にやりたいことを?曹ｭ
                JColorChooser colorchooser = new JColorChooser();

                Color color = JColorChooser.showDialog(null, "color", new Color(100, 200, 200));
                if (color != null) {
                    sen_tokutyuu_color = color;
                }


                //以?繧ﾅやりたいことは?曹ｫ?Iわり
                Button_sen_tokutyuu_color.setBackground(sen_tokutyuu_color);    //ボタンの?F?ﾝ定

                i_mouse_modeA = 59;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                es1.set_sen_tokutyuu_color(sen_tokutyuu_color);

                repaint();
            }
        });
        //Button_sen_tokutyuu_color.setPreferredSize(new Dimension(25, 25));
        Button_sen_tokutyuu_color.setMargin(new Insets(0, 0, 0, 0));
        //Button_sen_tokutyuu_color.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
        //  "ppp/sen_tokutyuu_color.png")));
        pnle8.add(Button_sen_tokutyuu_color);

        //?d要??意?@読み?桙ﾝや?曹ｫ?oしでファイルダイア??グのボックスが開くと?Aそれをフレ?[ムに?dなる位置で操??した?????Aファイルボックスが?ﾁえたときに?A
        //マウスのドラッグとリリ?[スが発?ｶする?Bこのため?A余計な操??がされてしまう可能?ｫがある?Bなお?Aこのときマウスクリックは発?ｶしない?B
        // i_mouseDragged_yuukou=0;や i_mouseReleased_yuukou=0;は?Aこの余計な操??を防ぐために指定している?B
// --------------------------------------

// -------------;??分?F特??変?X(補?賦???のみ)
        JButton Button_sen_tokutyuu_color_henkou = new JButton("");//JButton	Button_senbun_sakujyo	= new JButton(	"L_del"	);
        Button_sen_tokutyuu_color_henkou.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/sen_tokutyuu_color_henkou.png";
                readImageFromFile3();
                //	if(sen_tokutyuu_color != null){
                i_mouse_modeA = 59;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                es1.set_sen_tokutyuu_color(sen_tokutyuu_color);
                //	}
                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnle8.add(Button_sen_tokutyuu_color_henkou);

        Button_sen_tokutyuu_color_henkou.setMargin(new Insets(0, 0, 0, 0));
        Button_sen_tokutyuu_color_henkou.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/sen_tokutyuu_color_henkou.png")));

// ********東******************************
        //------------------------------------------------
        Panel pnle15 = new Panel();
        pnle15.setBackground(Color.PINK);
        pnle15.setLayout(new GridLayout(1, 2));
        //------------------------------------------------
        //pnle.add(pnle15);


// *************** 補?????@?ﾜ??とは相互??用せず?Aただの絵として?U舞う *************************************


// ****東**************************************************************************

        //------------------------------------------------
        Panel pnle12 = new Panel();
        pnle12.setBackground(Color.PINK);
        pnle12.setLayout(new GridLayout(1, 3));

        pnle.add(pnle12);
        //------------------------------------------------

// *****東*************************************************************************

        JButton Button_h_undo = new JButton("");
        Button_h_undo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/undo.png";
                readImageFromFile3();

                es1.h_undo();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnle12.add(Button_h_undo);
        Button_h_undo.setMargin(new Insets(0, 0, 0, 0));
        Button_h_undo.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/h_undo.png")));


// *****東*************************************************************************


        text11 = new JTextField("", 1);
        text11.setHorizontalAlignment(JTextField.RIGHT);

        pnle12.add(text11);
// *****東*************************************************************************

        JButton Button_h_undo_syutoku = new JButton("S");
        Button_h_undo_syutoku.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                img_kaisetu_fname = "qqq/h_undo_syutoku.png";
                readImageFromFile3();
                int i_h_undo_suu_old = i_undo_suu;
                i_h_undo_suu = ms.String2int(text11.getText(), i_h_undo_suu_old);
                if (i_h_undo_suu < 0) {
                    i_h_undo_suu = 0;
                }
                text11.setText(String.valueOf(i_h_undo_suu));
                es1.set_h_Ubox_undo_suu(i_h_undo_suu);


            }
        });
        pnle12.add(Button_h_undo_syutoku);

        Button_h_undo_syutoku.setMargin(new Insets(0, 0, 0, 0));


// *****東*************************************************************************


        JButton Button_h_redo = new JButton("");
        Button_h_redo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                img_kaisetu_fname = "qqq/h_redo.png";
                readImageFromFile3();

                es1.h_redo();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnle12.add(Button_h_redo);
        Button_h_redo.setMargin(new Insets(0, 0, 0, 0));
        Button_h_redo.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/h_redo.png")));


// ********************************************************

// ********東******************************
        //------------------------------------------------
        Panel pnle11 = new Panel();
        pnle11.setBackground(Color.PINK);
        pnle11.setLayout(new GridLayout(1, 2));
        //------------------------------------------------
        pnle.add(pnle11);


// ********東******************************
        //------------------------------------------------
        Panel pnle14 = new Panel();
        pnle14.setBackground(Color.PINK);
        pnle14.setLayout(new GridLayout(1, 2));
        //------------------------------------------------
        pnle11.add(pnle14);

// ****東**************************************************************************補????の???ｬさく
        JButton Button_h_senhaba_sage = new JButton("");
        Button_h_senhaba_sage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                i_h_TenkaizuSenhaba = i_h_TenkaizuSenhaba - 2;
                if (i_h_TenkaizuSenhaba < 3) {
                    i_h_TenkaizuSenhaba = 3;
                }

                img_kaisetu_fname = "qqq/h_senhaba_sage.png";
                readImageFromFile3();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnle14.add(Button_h_senhaba_sage);

        Button_h_senhaba_sage.setMargin(new Insets(0, 0, 0, 0));
        Button_h_senhaba_sage.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/h_senhaba_sage.png")));

// ****東**************************************************************************補????の??大きく

        JButton Button_h_senhaba_age = new JButton("");
        Button_h_senhaba_age.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                i_h_TenkaizuSenhaba = i_h_TenkaizuSenhaba + 2;
                img_kaisetu_fname = "qqq/h_senhaba_age.png";
                readImageFromFile3();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnle14.add(Button_h_senhaba_age);

        Button_h_senhaba_age.setMargin(new Insets(0, 0, 0, 0));
        Button_h_senhaba_age.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/h_senhaba_age.png")));
//icol=3 cyan
//icol=4 orange
//icol=5 mazenta
//icol=6 green
//icol=7 yellow
// ******東************************************************************************
        Button_Col_orange = new JButton("a1");
        Button_Col_orange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/Button_Col_orange.png";
                readImageFromFile3();
                Button_h_Col_irokesi();
                Button_Col_orange.setBackground(Color.ORANGE);
                h_icol = 4;
                es1.h_setcolor(h_icol);
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnle11.add(Button_Col_orange);
        Button_Col_orange.setBackground(new Color(150, 150, 150));
        Button_Col_orange.setMargin(new Insets(0, 0, 0, 0));
// ******東************************************************************************
        Button_Col_yellow = new JButton("a2");
        Button_Col_yellow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/Button_Col_yellow.png";
                readImageFromFile3();
                Button_h_Col_irokesi();
                Button_Col_yellow.setBackground(Color.yellow);
                h_icol = 7;
                es1.h_setcolor(h_icol);
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnle11.add(Button_Col_yellow);
        Button_Col_yellow.setBackground(new Color(150, 150, 150));
        Button_Col_yellow.setMargin(new Insets(0, 0, 0, 0));
// ******東************************************************************************

        //------------------------------------------------
        Panel pnle13 = new Panel();
        pnle13.setBackground(Color.PINK);
        pnle13.setLayout(new GridLayout(1, 2));
        //------------------------------------------------
        pnle.add(pnle13);

// -------------h_1;補????入力モ?[ド?B
        JButton Button_h_senbun_nyuryoku = new JButton("");
        Button_h_senbun_nyuryoku.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/h_senbun_nyuryoku.png";
                readImageFromFile3();
                i_mouse_modeA = 1;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
                i_orisen_hojyosen = 1;//=0は?ﾜ??入力?@=1は補????入力モ?[ド
                es1.set_i_orisen_hojyosen(i_orisen_hojyosen);
            }
        });

        pnle13.add(Button_h_senbun_nyuryoku);

        Button_h_senbun_nyuryoku.setMargin(new Insets(0, 0, 0, 0));
        Button_h_senbun_nyuryoku.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/h_senbun_nyuryoku.png")));


// -------------h_1;補????入力モ?[ド?Bここまで

// ******東************************************************************************ ?ﾁしゴム
// -------------;h_??分???怎??[ド?B

        JButton Button_h_senbun_sakujyo = new JButton("");//JButton	Button_senbun_sakujyo	= new JButton(	"L_del"	);
        Button_h_senbun_sakujyo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/h_senbun_sakujyo.png";
                readImageFromFile3();
                i_mouse_modeA = 3;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);


                i_orisen_hojyosen = 1;//=0は?ﾜ??入力?@=1は補????入力モ?[ド
                es1.set_i_orisen_hojyosen(i_orisen_hojyosen);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnle13.add(Button_h_senbun_sakujyo);

        Button_h_senbun_sakujyo.setMargin(new Insets(0, 0, 0, 0));
        Button_h_senbun_sakujyo.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/h_senbun_sakujyo.png")));

// ******東************************************************************************
        //------------------------------------------------
        Panel pnle30 = new Panel();
        pnle30.setBackground(Color.PINK);
        pnle30.setLayout(new GridLayout(1, 2));
        pnle.add(pnle30);
        //------------------------------------------------

// ******東************************************************************************
// ---------------------------------------------------------------------------------------------------------------
        EtchedBorder border = new EtchedBorder(EtchedBorder.RAISED, Color.white, Color.black);

        //------------------------------------------------
        Panel pnle24 = new Panel();
        pnle24.setBounds(2, 2, 93, 20);
        pnle24.setBackground(Color.PINK);
        pnle24.setLayout(null);
        //------------------------------------------------
        pnle.add(pnle24);

// -------------長さ1測定モ?[ド?B
        JButton Button_nagasa_sokutei_1 = new JButton("L1=");
        Button_nagasa_sokutei_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/nagasa_sokutei_1.png";
                readImageFromFile3();
                i_mouse_modeA = 53;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        Button_nagasa_sokutei_1.setBounds(2, 2, 30, 20);
        pnle24.add(Button_nagasa_sokutei_1);
        Button_nagasa_sokutei_1.setBorder(border);
        Button_nagasa_sokutei_1.setMargin(new Insets(0, 0, 0, 0));
// -------------長さ1測定モ?[ド?Bここまで
        label_nagasa_sokutei_1.setOpaque(true);
        label_nagasa_sokutei_1.setBackground(Color.white);
        label_nagasa_sokutei_1.setText("");
        label_nagasa_sokutei_1.setBorder(border);
        label_nagasa_sokutei_1.setBounds(30, 2, 80, 20);
        pnle24.add(label_nagasa_sokutei_1);
// -------------


        //------------------------------------------------
        Panel pnle25 = new Panel();
        pnle25.setBounds(2, 2, 93, 20);
        pnle25.setBackground(Color.PINK);
        pnle25.setLayout(null);
        //------------------------------------------------
        pnle.add(pnle25);
// -------------長さ2測定モ?[ド?B
        JButton Button_nagasa_sokutei_2 = new JButton("L2=");
        Button_nagasa_sokutei_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/nagasa_sokutei_2.png";
                readImageFromFile3();
                i_mouse_modeA = 54;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        Button_nagasa_sokutei_2.setBounds(2, 2, 30, 20);
        pnle25.add(Button_nagasa_sokutei_2);
        Button_nagasa_sokutei_2.setBorder(border);
        Button_nagasa_sokutei_2.setMargin(new Insets(0, 0, 0, 0));
// -------------長さ2測定モ?[ド?Bここまで
        label_nagasa_sokutei_2.setOpaque(true);
        label_nagasa_sokutei_2.setBackground(Color.white);
        label_nagasa_sokutei_2.setText("");
        label_nagasa_sokutei_2.setBorder(border);
        label_nagasa_sokutei_2.setBounds(30, 2, 80, 20);
        pnle25.add(label_nagasa_sokutei_2);
// -------------


        //------------------------------------------------
        Panel pnle26 = new Panel();
        pnle26.setBounds(2, 2, 93, 20);
        pnle26.setBackground(Color.PINK);
        pnle26.setLayout(null);
        //------------------------------------------------
        pnle.add(pnle26);
// -------------角度1測定モ?[ド?B
        JButton Button_kakudo_sokutei_1 = new JButton("A1=");
        Button_kakudo_sokutei_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/kakudo_sokutei_1.png";
                readImageFromFile3();
                i_mouse_modeA = 55;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        Button_kakudo_sokutei_1.setBounds(2, 2, 30, 20);
        pnle26.add(Button_kakudo_sokutei_1);
        Button_kakudo_sokutei_1.setBorder(border);
        Button_kakudo_sokutei_1.setMargin(new Insets(0, 0, 0, 0));
// -------------角度1測定モ?[ド?Bここまで
        label_kakudo_sokutei_1.setOpaque(true);
        label_kakudo_sokutei_1.setBackground(Color.white);
        label_kakudo_sokutei_1.setText("");
        label_kakudo_sokutei_1.setBorder(border);
        label_kakudo_sokutei_1.setBounds(30, 2, 80, 20);
        pnle26.add(label_kakudo_sokutei_1);


        //------------------------------------------------
        Panel pnle27 = new Panel();
        pnle27.setBounds(2, 2, 93, 20);
        pnle27.setBackground(Color.PINK);
        pnle27.setLayout(null);
        //------------------------------------------------
        pnle.add(pnle27);
// -------------角度2測定モ?[ド?B
        JButton Button_kakudo_sokutei_2 = new JButton("A2=");
        Button_kakudo_sokutei_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/kakudo_sokutei_2.png";
                readImageFromFile3();
                i_mouse_modeA = 56;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        Button_kakudo_sokutei_2.setBounds(2, 2, 30, 20);
        pnle27.add(Button_kakudo_sokutei_2);
        Button_kakudo_sokutei_2.setBorder(border);
        Button_kakudo_sokutei_2.setMargin(new Insets(0, 0, 0, 0));
// -------------角度2測定モ?[ド?Bここまで
        label_kakudo_sokutei_2.setOpaque(true);
        label_kakudo_sokutei_2.setBackground(Color.white);
        label_kakudo_sokutei_2.setText("");
        label_kakudo_sokutei_2.setBorder(border);
        label_kakudo_sokutei_2.setBounds(30, 2, 80, 20);
        pnle27.add(label_kakudo_sokutei_2);


        //------------------------------------------------
        Panel pnle28 = new Panel();
        pnle28.setBounds(2, 2, 93, 20);
        pnle28.setBackground(Color.PINK);
        pnle28.setLayout(null);
        //------------------------------------------------
        pnle.add(pnle28);
// -------------角度3測定モ?[ド?B
        JButton Button_kakudo_sokutei_3 = new JButton("A3=");
        Button_kakudo_sokutei_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/kakudo_sokutei_3.png";
                readImageFromFile3();
                i_mouse_modeA = 57;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.unselect_all();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        Button_kakudo_sokutei_3.setBounds(2, 2, 30, 20);
        pnle28.add(Button_kakudo_sokutei_3);
        Button_kakudo_sokutei_3.setBorder(border);
        Button_kakudo_sokutei_3.setMargin(new Insets(0, 0, 0, 0));
// -------------角度3測定モ?[ド?Bここまで
        label_kakudo_sokutei_3.setOpaque(true);
        label_kakudo_sokutei_3.setBackground(Color.white);
        label_kakudo_sokutei_3.setText("");
        label_kakudo_sokutei_3.setBorder(border);
        label_kakudo_sokutei_3.setBounds(30, 2, 80, 20);
        pnle28.add(label_kakudo_sokutei_3);


// ******************************************************************************************************************************************************************************

        //------------------------------------------------
        Panel pnle33 = new Panel();
        pnle33.setBackground(Color.PINK);
        pnle33.setLayout(new GridLayout(1, 2));
        pnle.add(pnle33);
        //------------------------------------------------
// ***東***************************************************************************************************************************************************************************


        // *************************************************
        //下辺?i南側?jパネルの?\築*************************
        // *************************************************
        //下辺?i南側?jパネルの???ｬ
        //Panel pnls = new Panel();pnls.setBackground(new Color(0,70,0));
        Panel pnls = new Panel();
        pnls.setBackground(Color.PINK);
        pnls.setLayout(new FlowLayout(FlowLayout.LEFT));
        //下辺?i南側?jパネルをレイアウトに貼り付け
        add("South", pnls); //Frame用
        //contentPane.add(pnls, BorderLayout.SOUTH);//JFrame用


        //------------------------------------------------
        Panel pnlw11 = new Panel();
        pnlw11.setBackground(Color.PINK);
        pnlw11.setLayout(new GridLayout(1, 3));

        //------------------------------------------------
        pnlw.add(pnlw11);
/*
		//------------------------------------------------
		Panel   pnlw12 = new Panel();
			pnlw12.setBackground(Color.PINK);
			pnlw12.setLayout(new GridLayout(1,4));

		//------------------------------------------------
		pnlw.add(pnlw12);
*/

        //------------------------------------------------
        JPanel pnlw12 = new JPanel();
        pnlw12.setPreferredSize(new Dimension(76, 30));
        pnlw12.setBackground(Color.PINK);
        pnlw12.setLayout(null);
        //pnlw12.setBorder(new LineBorder(Color.black, 1));
        pnlw.add(pnlw12);
        //------------------------------------------------


// ***?ｼ***************************************************************************デ?[タ読み?桙ﾝ追加

        JButton Button_yomi_tuika = new JButton("Op");
        Button_yomi_tuika.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/yomi_tuika.png";
                readImageFromFile3();

                Button_kyoutuu_sagyou();

                i_mouseDragged_yuukou = 0;
                i_mouseReleased_yuukou = 0;
                Memo memo_temp = new Memo();

                System.out.println("readFile2Memo() 開始");
                memo_temp = readFile2Memo();
                System.out.println("readFile2Memo() ?I了");

                if (memo_temp.getGyousuu() > 0) {
                    es1.setMemo_for_yomikomi_tuika(memo_temp);
                    es1.kiroku();
                    repaint();
                }
            }
        });
        Button_yomi_tuika.setBounds(0, 0, 30, 21);
        //Button_yomi.setPreferredSize(new Dimension(25, 25));
        Button_yomi_tuika.setMargin(new Insets(0, 0, 0, 0));
        //Button_yomi.setIcon(icon);
        pnlw12.add(Button_yomi_tuika);


// -------------------------------------------------------------------
//cpを?ﾜ?ﾝ前に自動改善する
        ckbox_cp_kaizen_oritatami = new JCheckBox("");
        ckbox_cp_kaizen_oritatami.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname =
                        "qqq/ckbox_cp_kaizen_oritatami.png";
                readImageFromFile3();

                repaint();
            }
        });
        ckbox_cp_kaizen_oritatami.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/ckbox_cp_kaizen_oritatami_off.png")));
        ckbox_cp_kaizen_oritatami.setSelectedIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/ckbox_cp_kaizen_oritatami_on.png")));
        ckbox_cp_kaizen_oritatami.setMargin(new Insets(0, 0, 0, 0));
        pnlw12.add(
                ckbox_cp_kaizen_oritatami);
        ckbox_cp_kaizen_oritatami.setBounds(31, 0, 20, 21);
// -------------------------------------------------------------------
//select?ﾔを他の操??をしてもなるべく残す
        ckbox_select_nokosi = new JCheckBox("");
        ckbox_select_nokosi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname =
                        "qqq/ckbox_select_nokosi.png";
                readImageFromFile3();

                repaint();
            }
        });
        ckbox_select_nokosi.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/ckbox_select_nokosi_off.png")));
        ckbox_select_nokosi.setSelectedIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/ckbox_select_nokosi_on.png")));
        //ckbox_select_nokosi.setMargin(new Insets(0,0,0,0));
        pnlw12.add(
                ckbox_select_nokosi);
        ckbox_select_nokosi.setBounds(51, 0, 30, 21);


// ***?ｼ****************************************************************** ２?F展開?}************************************************
        JButton Button_2syoku_tenkaizu = new JButton("");//new JButton(	"Del_F"	);
        Button_2syoku_tenkaizu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/2syoku_tenkaizu.png";
                readImageFromFile3();

                //	i_fold_type=1;
                Ss0 = es1.get_for_select_oritatami();

                if (es1.get_orisensuu_for_select_oritatami() == 0) {        //?ﾜり??選択無し
                    keikoku_sentaku_sareta_orisen_ga_nai();//警???@選択された?ﾜ??がない


                } else if (es1.get_orisensuu_for_select_oritatami() > 0) {
                    oritatami_jyunbi();//ここでOZがOAZ(0)からOAZ(i)に?ﾘり替わる
                    //OZ.ts1.Senbunsyuugou2Tensyuugou(es1.get_for_select_oritatami());
                    OZ.i_suitei_meirei = 5;

                    if (i_SubThread == 0) {
                        i_SubThread = 1;
                        i_sub_mode = 4;
                        mks();//?Vしいスレッドを??る
                        sub.start();
                    }
                }

                es1.unselect_all();
                Button_kyoutuu_sagyou();

            }
        });
        pnlw12.add(Button_2syoku_tenkaizu);
        Button_2syoku_tenkaizu.setBounds(81, 0, 30, 21);
        Button_2syoku_tenkaizu.setMargin(new Insets(0, 0, 0, 0));
        Button_2syoku_tenkaizu.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/2syoku_tenkaizu.png")));

// -----------------------------------------------------------------------------------


        //------------------------------------------------
        JPanel pnlw20 = new JPanel();
        pnlw20.setBackground(Color.PINK);
        pnlw20.setLayout(new GridLayout(1, 2));
        //pnlw20.setBorder(new LineBorder(Color.black, 1));
        pnlw.add(pnlw20);
        //------------------------------------------------


        // **********南***************************************************************

        JButton Button_suitei_01 = new JButton("CP_rcg");
        Button_suitei_01.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/suitei_01.png";
                readImageFromFile3();

                oritatame(get_i_fold_type(), 1);//引?狽ﾌ意味は(i_fold_type , i_suitei_meirei);
                if (ckbox_select_nokosi.isSelected()) {
                } else {
                    es1.unselect_all();
                }
                //OZ.i_suitei_dankai=1;

                Button_kyoutuu_sagyou();//repaint();
            }
        });
        pnlw20.add(Button_suitei_01);
        Button_suitei_01.setMargin(new Insets(0, 0, 0, 0));


        // *********南****************************************************************
        JButton Button_koteimen_sitei = new JButton("S_face");
        Button_koteimen_sitei.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/koteimen_sitei.png";
                readImageFromFile3();
                if (OZ.hyouji_flg > 0) {
                    i_mouse_modeA = 103;
                    System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                }
                Button_kyoutuu_sagyou();
                //OZ.i_suitei_dankai=1;


            }
        });
        pnlw20.add(Button_koteimen_sitei);

        Button_koteimen_sitei.setMargin(new Insets(0, 0, 0, 0));

        // **********南***************************************************************


        //------------------------------------------------
        JPanel pnlw36 = new JPanel();
        pnlw36.setPreferredSize(new Dimension(76, 21));
        pnlw36.setBackground(Color.PINK);
        pnlw36.setLayout(null);
        //pnlw36.setBorder(new LineBorder(Color.black, 1));
        pnlw.add(pnlw36);
        //------------------------------------------------

		/* ------------------------------------------------
		Panel   pnlw36 = new Panel();
			pnlw36.setBackground(Color.PINK);
			pnlw36.setLayout(new GridLayout(1,2));
		pnlw.add(pnlw36);
		------------------------------------------------
		*/


// *******南******************************************************************


        JButton Button_suitei_02 = new JButton("");//new JButton(	"Wire_gr"	)
        Button_suitei_02.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/suitei_02.png";
                readImageFromFile3();


                oritatame(get_i_fold_type(), 2);//引?狽ﾌ意味は(i_fold_type , i_suitei_meirei);
                if (ckbox_select_nokosi.isSelected()) {
                } else {
                    es1.unselect_all();
                }

                Button_kyoutuu_sagyou();
                //repaint();


            }
        });
        pnlw36.add(Button_suitei_02);

        Button_suitei_02.setBounds(0, 0, 20, 21);//20180210,4番目の21が23以?繧ｾとアイコン表示がかえって部分的にしか表示されない

        Button_suitei_02.setMargin(new Insets(0, 0, 0, 0));
        Button_suitei_02.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/suitei_02.png")));

// *******南******************************************************************


        //------------------------------------------------
        JPanel pnls4 = new JPanel();
        pnls4.setPreferredSize(new Dimension(76, 21));//pnls4.setPreferredSize(new Dimension(76, 30)
        pnls4.setBackground(Color.white);
        pnls4.setLayout(null);
        //pnls4.setBorder(new LineBorder(Color.black, 1));
        pnlw36.add(pnls4);
        pnls4.setBounds(30, 0, 76, 21);//20180210,4番目の21が23以?繧ｾとアイコン表示がかえって部分的にしか表示されない

        //------------------------------------------------

// *******南******************************************************************

        JButton Button_suitei_03 = new JButton("");//透過?}表示new JButton(	"Transparent_gr"	);
        Button_suitei_03.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/suitei_03.png";
                readImageFromFile3();

                oritatame(get_i_fold_type(), 3);//引?狽ﾌ意味は(i_fold_type , i_suitei_meirei);

                if (ckbox_select_nokosi.isSelected()) {
                } else {
                    es1.unselect_all();
                }
                Button_kyoutuu_sagyou();
                //repaint();

            }
        });
        pnls4.add(Button_suitei_03);
        Button_suitei_03.setBounds(1, 0, 20, 21);//Button_suitei_03.setBounds(1, 1, 20, 28);


        Button_suitei_03.setMargin(new Insets(0, 0, 0, 0));
        Button_suitei_03.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/suitei_03.png")));


// ******南*******************************************************************ccccccccccccccc
//透過?}をカラ?[化する?B

        ckbox_toukazu_color = new JCheckBox("");
        ckbox_toukazu_color.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname =
                        "qqq/ckbox_toukazu_color.png";
                readImageFromFile3();
                if (ckbox_toukazu_color.isSelected()) {
                    OZ.i_toukazu_color = 1;
                    System.out.println("ckbox_toukazu_color.isSelected()");
                }//カラ?[の透過?}
                else {
                    OZ.i_toukazu_color = 0;
                    System.out.println("ckbox_toukazu_color.is not Selected()");
                }
                repaint();
            }
        });
        ckbox_toukazu_color.setBounds(21, 0, 18, 21);

        ckbox_toukazu_color.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/ckbox_toukazu_color_off.png")));
        ckbox_toukazu_color.setSelectedIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/ckbox_toukazu_color_on.png")));
        ckbox_toukazu_color.setMargin(new Insets(0, 0, 0, 0));
        pnls4.add(
                ckbox_toukazu_color);


// *******透過?}の?Fの濃さ調?ｮ?@下げ***********************************************************************

        JButton Button_toukazu_color_sage = new JButton("");
        Button_toukazu_color_sage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OZ.toukazu_color_sage();
                img_kaisetu_fname = "qqq/toukazu_color_sage.png";
                readImageFromFile3();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnls4.add(Button_toukazu_color_sage);
        Button_toukazu_color_sage.setBounds(39, 0, 18, 21);
        Button_toukazu_color_sage.setMargin(new Insets(0, 0, 0, 0));
        Button_toukazu_color_sage.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/ck4_color_sage.png")));


// *******透過?}の?Fの濃さ調?ｮ?@?繧ｰ***********************************************************************

        JButton Button_toukazu_color_age = new JButton("");
        Button_toukazu_color_age.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OZ.toukazu_color_age();
                img_kaisetu_fname = "qqq/toukazu_color_age.png";
                readImageFromFile3();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnls4.add(Button_toukazu_color_age);
        Button_toukazu_color_age.setBounds(57, 0, 18, 21);
        Button_toukazu_color_age.setMargin(new Insets(0, 0, 0, 0));
        Button_toukazu_color_age.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/ck4_color_age.png")));


// ********南*****************************************************************
        JButton Button_suitei_04 = new JButton("Fold");
        Button_suitei_04.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/suitei_04.png";
                readImageFromFile3();

                //i_fold_type=0;//=0なにもしない?A=1通?墲ﾌ展開?}の全?ﾜ??を対?ﾛとした?ﾜり?ﾝ??定?A=2はselectされた?ﾜ??を対?ﾛとした?ﾜり?ﾝ??定?A=3は?ﾜ?ﾝ?ﾔを変?X

                System.out.println("20180220 get_i_fold_type() = " + get_i_fold_type());
                oritatame(get_i_fold_type(), 5);//引?狽ﾌ意味は(i_fold_type , i_suitei_meirei);

                if (ckbox_select_nokosi.isSelected()) {
                } else {
                    es1.unselect_all();
                }

                Button_kyoutuu_sagyou();

            }
        });
        pnls.add(Button_suitei_04);

        Button_suitei_04.setMargin(new Insets(0, 0, 0, 0));
        Button_suitei_04.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/suitei_04.png")));

// *******南******************************************************************


// *****南********************************************************************
        //-------------------------------------
        Button3 = new JButton("a_s");//Button3 = new JButton(	"Another sol"	);
        Button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/Button3.png";
                readImageFromFile3();

                //OZ.i_suitei_jissi_umu=0;//i_suitei_jissi_umuは?A?ﾜり?ﾝ??定の計算を実施したかどうかを表す?Bint i_suitei_jissi_umu=0なら実施しない?B1なら実施した?B
                OZ.i_suitei_meirei = 6;


                i_sub_mode = 0;//1=?ﾜ?ﾝ??定の別解をまとめて?oす?B0=?ﾜ?ﾝ??定の別解をまとめて?oすモ?[ドではない?Bこの変?狽ﾍサブスレッドの動??変?Xにつかう?B
                if (i_SubThread == 0) {
                    i_SubThread = 1;
                    mks();//?Vしいスレッドを??る
                    sub.start();
                }
            }
        });
        pnls.add(Button3);
        Button3.setMargin(new Insets(0, 0, 0, 0));


// *******南***************************************************** //System.out.println("裏表");*************
        //------------------------------------------------------------------------------------------------------
        Button0b = new JButton("");//new JButton(	"Back"		);
        Button0b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/Button0b.png";
                readImageFromFile3();
                //ip4==0 表?Aip4==1?@裏?Aip4==2?Aip4==3?@両方と透過
                OZ.ip4 = OZ.ip4 + 1;
                if (OZ.ip4 == 4) {
                    OZ.ip4 = 0;
                }
                if ((i_mouse_modeA == 101) && (OZ.ip4 == 2)) {
                    OZ.ip4 = 0;
                }//?ﾜり?繧ｪり予想?}動かしのとき?A動かしできなくなるモ?[ドを避けるために追加
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnls.add(Button0b);

        Button0b.setMargin(new Insets(0, 0, 0, 0));
        Button0b.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/Button0b.png")));


// *****南********************************************************************
        //-------------------------------------
        Button_AS_matome = new JButton("AS100");
        Button_AS_matome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

//i_AS_matome_mode =1;//1=?ﾜ?ﾝ??定の別解をまとめて?oす?B0=?ﾜ?ﾝ??定の別解をまとめて?oすモ?[ドではない?Bこの変?狽ﾍサブスレッドの動??変?Xにつかうだけ?B20170611にVer3.008から追加
                i_sub_mode = 1;
                img_kaisetu_fname =
                        "qqq/AS_matome.png";
                readImageFromFile3();
                if (OZ.betu_sagasi_flg == 1) {
                    //OZ.i_suitei_jissi_umu=0;//i_suitei_jissi_umuは?A?ﾜり?ﾝ??定の計算を実施したかどうかを表す?Bint i_suitei_jissi_umu=0なら実施しない?B1なら実施した?B
                    OZ.i_suitei_meirei = 6;

                    if (i_SubThread == 0) {
                        i_SubThread = 1;
                        mks();//?Vしいスレッドを??る
                        sub.start();

                    }
                }
            }
        });
        pnls.add(Button_AS_matome);
        Button_AS_matome.setMargin(new Insets(0, 0, 0, 0));


// **********南***************************************************************


        //------------------------------------------------
        Panel pnls1 = new Panel();
        pnls1.setBackground(Color.PINK);
        pnls1.setLayout(new GridLayout(1, 2));

        pnls.add(pnls1);
        //------------------------------------------------

// -----
        text26 = new JTextField("", 2);
        text26.setHorizontalAlignment(JTextField.RIGHT);
        pnls1.add(text26);
// -------------------------------------------------------------------------------
// -----;	//?ﾜり?ﾝ??定の指定番目を表示する
        Button_bangou_sitei_suitei_hyouji = new JButton("Go");
        Button_bangou_sitei_suitei_hyouji.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int i_oritatami_bangou_old = i_oritatami_bangou;
                i_oritatami_bangou = ms.String2int(text26.getText(), i_oritatami_bangou_old);
                if (i_oritatami_bangou < 1) {
                    i_oritatami_bangou = 1;
                }

                text26.setText(String.valueOf(i_oritatami_bangou));

                OZ.i_suitei_meirei = 6;

                if (i_oritatami_bangou < OZ.hakkenn_sita_kazu) {
                    settei_syokika_yosoku();//?ﾜり?繧ｪり予想の廃棄
                    OZ.i_suitei_meirei = 51;    //i_suitei_meirei=51はoritatami_suiteiの?ﾅ?奄ﾌ??定?}用カ??ラの?ﾝ定は素通りするための?ﾝ定?B??定?}用カ??ラの?ﾝ定を素通りしたら?Ai_suitei_meirei=5に変?Xされる?B
                    //1例目の?ﾜり?繧ｪり予想はi_suitei_meirei=5を指定?A2例目以?~の?ﾜり?繧ｪり予想はi_suitei_meirei=6で実施される
                    //betu_sagasi_flg=1;
                }

                //OZ.i_suitei_jissi_umu=0;//i_suitei_jissi_umuは?A?ﾜり?ﾝ??定の計算を実施したかどうかを表す?Bint i_suitei_jissi_umu=0なら実施しない?B1なら実施した?B

                i_sub_mode = 2;
                if (i_SubThread == 0) {
                    i_SubThread = 1;
                    mks();//?Vしいスレッドを??る
                    sub.start();
                }


                img_kaisetu_fname = "qqq/bangou_sitei_suitei_hyouji.png";
                readImageFromFile3();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnls1.add(Button_bangou_sitei_suitei_hyouji);

        Button_bangou_sitei_suitei_hyouji.setMargin(new Insets(0, 0, 0, 0));
        //Button_senbun_bunkatu_set.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
        //"ppp/senbun_bunkatu_set.png")));

// ------ここまで


//?ﾜり?繧ｪり?}	のredoとundo

// *****南*************************************************************************rrrrrrrrr

        JButton Button_undo_om = new JButton("");//_omは?ﾜり?繧ｪり?}モディファイ?i変形?jの意味
        Button_undo_om.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/undo.png";
                readImageFromFile3();

                OZ.undo();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnls.add(Button_undo_om);
        Button_undo_om.setMargin(new Insets(0, 0, 0, 0));
        Button_undo_om.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/undo.png")));

// *****南*************************************************************************


        text31 = new JTextField("", 1);
        text31.setHorizontalAlignment(JTextField.RIGHT);

        pnls.add(text31);
// *****南*************************************************************************
        JButton Button_undo_syutoku_om = new JButton("S");
        Button_undo_syutoku_om.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                img_kaisetu_fname = "qqq/undo_syutoku.png";
                readImageFromFile3();
                int i_undo_suu_om_old = i_undo_suu_om;
                i_undo_suu_om = ms.String2int(text31.getText(), i_undo_suu_om_old);
                if (i_undo_suu < 0) {
                    i_undo_suu_om = 0;
                }
                text31.setText(String.valueOf(i_undo_suu_om));
                OZ.ts2.set_Ubox_undo_suu(i_undo_suu_om);                  //  <<<------------


            }
        });
        pnls.add(Button_undo_syutoku_om);

        Button_undo_syutoku_om.setMargin(new Insets(0, 0, 0, 0));


// *****南*************************************************************************

        JButton Button_redo_om = new JButton("");
        Button_redo_om.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                img_kaisetu_fname = "qqq/redo.png";
                readImageFromFile3();

                OZ.redo();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnls.add(Button_redo_om);
        Button_redo_om.setMargin(new Insets(0, 0, 0, 0));
        Button_redo_om.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/redo.png")));


// ********************************************************


// ******南*******************************************************************
        JButton Button_oriagari_sousa = new JButton("");//?ﾜり?繧ｪり?}操???@?j金?}(	"F_Modify"		)
        Button_oriagari_sousa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/oriagari_sousa.png";
                readImageFromFile3();
                OZ.i_oriagari_sousa_mode = 1;
                OZ.set_all_ten_sentaku_0();
                OZ.kiroku();
                i_mouse_modeA = 101;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                Button_kyoutuu_sagyou();
                //repaint();
            }
        });
        pnls.add(Button_oriagari_sousa);
        Button_oriagari_sousa.setMargin(new Insets(0, 0, 0, 0));
        Button_oriagari_sousa.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/oriagari_sousa.png")));

// ******南*******************************************************************

        JButton Button_oriagari_sousa_2 = new JButton("");//new JButton(	"F_Modify"		)
        Button_oriagari_sousa_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/oriagari_sousa_2.png";
                readImageFromFile3();
                OZ.i_oriagari_sousa_mode = 2;
                OZ.set_all_ten_sentaku_0();
                OZ.kiroku();
                i_mouse_modeA = 101;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);


                Button_kyoutuu_sagyou();
                //repaint();
            }
        });
        pnls.add(Button_oriagari_sousa_2);


        Button_oriagari_sousa_2.setMargin(new Insets(0, 0, 0, 0));
        Button_oriagari_sousa_2.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/oriagari_sousa_2.png")));

// *******南******************************************************************
        JButton Button_oriagari_idiu = new JButton("");// new JButton(	"F_move"	);
        Button_oriagari_idiu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/oriagari_idiu.png";
                readImageFromFile3();

                i_mouse_modeA = 102;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);
                Button_kyoutuu_sagyou();
                //repaint();
            }
        });
        pnls.add(Button_oriagari_idiu);


        Button_oriagari_idiu.setMargin(new Insets(0, 0, 0, 0));
        Button_oriagari_idiu.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/oriagari_idiu.png")));

// *******南******************************************************************

        //------------------------------------------------
        JPanel pnls2 = new JPanel();
        pnls2.setPreferredSize(new Dimension(109, 30));
        pnls2.setBackground(Color.white);
        pnls2.setLayout(null);
        pnls2.setBorder(new LineBorder(Color.black, 1));
        pnls.add(pnls2);
        //------------------------------------------------


// ********南*****************************************************************
        JButton Button_oriagari_syukusyou = new JButton("");// new JButton(	"F_z_out"	);
        Button_oriagari_syukusyou.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/oriagari_syukusyou.png";
                readImageFromFile3();


                OZ.d_oriagarizu_syukusyaku_keisuu = OZ.d_oriagarizu_syukusyaku_keisuu / Math.sqrt(Math.sqrt(Math.sqrt(2.0)));
                OZ.camera_of_oriagarizu.set_camera_bairitsu_x(OZ.d_oriagarizu_syukusyaku_keisuu);
                OZ.camera_of_oriagarizu.set_camera_bairitsu_y(OZ.d_oriagarizu_syukusyaku_keisuu);

                OZ.camera_of_oriagari_omote.set_camera_bairitsu_x(OZ.d_oriagarizu_syukusyaku_keisuu);
                OZ.camera_of_oriagari_omote.set_camera_bairitsu_y(OZ.d_oriagarizu_syukusyaku_keisuu);

                OZ.camera_of_oriagari_ura.set_camera_bairitsu_x(OZ.d_oriagarizu_syukusyaku_keisuu);
                OZ.camera_of_oriagari_ura.set_camera_bairitsu_y(OZ.d_oriagarizu_syukusyaku_keisuu);

                OZ.camera_of_touka_omote.set_camera_bairitsu_x(OZ.d_oriagarizu_syukusyaku_keisuu);
                OZ.camera_of_touka_omote.set_camera_bairitsu_y(OZ.d_oriagarizu_syukusyaku_keisuu);

                OZ.camera_of_touka_ura.set_camera_bairitsu_x(OZ.d_oriagarizu_syukusyaku_keisuu);
                OZ.camera_of_touka_ura.set_camera_bairitsu_y(OZ.d_oriagarizu_syukusyaku_keisuu);

                text29.setText(String.valueOf(OZ.d_oriagarizu_syukusyaku_keisuu));
                text29.setCaretPosition(0);

                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnls2.add(Button_oriagari_syukusyou);
        Button_oriagari_syukusyou.setBounds(1, 1, 28, 28);
        Button_oriagari_syukusyou.setMargin(new Insets(0, 0, 0, 0));
        Button_oriagari_syukusyou.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/oriagari_syukusyou.png")));


// *******南******************************************************************

        text29 = new JTextField("", 2);
        text29.setBounds(29, 4, 35, 24);
        text29.setHorizontalAlignment(JTextField.RIGHT);

        pnls2.add(text29);

// ****南**************************************************************************

// -----?k尺係?敗et
        JButton Button_oriagarizu_syukusyaku_keisuu_set = new JButton("S");
        Button_oriagarizu_syukusyaku_keisuu_set.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //set_syukusyaku_keisuu();
                //public void set_syukusyaku_keisuu(){
                double d_oriagarizu_syukusyaku_keisuu_old = OZ.d_oriagarizu_syukusyaku_keisuu;
                OZ.d_oriagarizu_syukusyaku_keisuu = String2double(text29.getText(), d_oriagarizu_syukusyaku_keisuu_old);
                if (OZ.d_oriagarizu_syukusyaku_keisuu <= 0.0) {
                    OZ.d_oriagarizu_syukusyaku_keisuu = d_oriagarizu_syukusyaku_keisuu_old;
                }
                text29.setText(String.valueOf(OZ.d_oriagarizu_syukusyaku_keisuu));
                if (OZ.d_oriagarizu_syukusyaku_keisuu != d_oriagarizu_syukusyaku_keisuu_old) {
                    OZ.camera_of_oriagarizu.set_camera_bairitsu_x(OZ.d_oriagarizu_syukusyaku_keisuu);
                    OZ.camera_of_oriagarizu.set_camera_bairitsu_y(OZ.d_oriagarizu_syukusyaku_keisuu);

                    OZ.camera_of_oriagari_omote.set_camera_bairitsu_x(OZ.d_oriagarizu_syukusyaku_keisuu);
                    OZ.camera_of_oriagari_omote.set_camera_bairitsu_y(OZ.d_oriagarizu_syukusyaku_keisuu);

                    OZ.camera_of_oriagari_ura.set_camera_bairitsu_x(OZ.d_oriagarizu_syukusyaku_keisuu);
                    OZ.camera_of_oriagari_ura.set_camera_bairitsu_y(OZ.d_oriagarizu_syukusyaku_keisuu);

                    OZ.camera_of_touka_omote.set_camera_bairitsu_x(OZ.d_oriagarizu_syukusyaku_keisuu);
                    OZ.camera_of_touka_omote.set_camera_bairitsu_y(OZ.d_oriagarizu_syukusyaku_keisuu);

                    OZ.camera_of_touka_ura.set_camera_bairitsu_x(OZ.d_oriagarizu_syukusyaku_keisuu);
                    OZ.camera_of_touka_ura.set_camera_bairitsu_y(OZ.d_oriagarizu_syukusyaku_keisuu);
                }
                text29.setText(String.valueOf(OZ.d_oriagarizu_syukusyaku_keisuu));
                text29.setCaretPosition(0);
                repaint();

                //}
                img_kaisetu_fname = "qqq/oriagarizu_syukusyaku_keisuu_set.png";
                readImageFromFile3();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        Button_oriagarizu_syukusyaku_keisuu_set.setBounds(65, 4, 14, 24);
        pnls2.add(Button_oriagarizu_syukusyaku_keisuu_set);

        Button_oriagarizu_syukusyaku_keisuu_set.setMargin(new Insets(0, 0, 0, 0));


// ------?k尺係?敗et?Bここまで


// ****南**************************************************************************


        JButton Button_oriagari_kakudai = new JButton("");//new JButton(	"F_z_in"	);
        Button_oriagari_kakudai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/oriagari_kakudai.png";
                readImageFromFile3();

                OZ.d_oriagarizu_syukusyaku_keisuu = OZ.d_oriagarizu_syukusyaku_keisuu * Math.sqrt(Math.sqrt(Math.sqrt(2.0)));
                OZ.camera_of_oriagarizu.set_camera_bairitsu_x(OZ.d_oriagarizu_syukusyaku_keisuu);
                OZ.camera_of_oriagarizu.set_camera_bairitsu_y(OZ.d_oriagarizu_syukusyaku_keisuu);

                OZ.camera_of_oriagari_omote.set_camera_bairitsu_x(OZ.d_oriagarizu_syukusyaku_keisuu);
                OZ.camera_of_oriagari_omote.set_camera_bairitsu_y(OZ.d_oriagarizu_syukusyaku_keisuu);

                OZ.camera_of_oriagari_ura.set_camera_bairitsu_x(OZ.d_oriagarizu_syukusyaku_keisuu);
                OZ.camera_of_oriagari_ura.set_camera_bairitsu_y(OZ.d_oriagarizu_syukusyaku_keisuu);

                OZ.camera_of_touka_omote.set_camera_bairitsu_x(OZ.d_oriagarizu_syukusyaku_keisuu);
                OZ.camera_of_touka_omote.set_camera_bairitsu_y(OZ.d_oriagarizu_syukusyaku_keisuu);

                OZ.camera_of_touka_ura.set_camera_bairitsu_x(OZ.d_oriagarizu_syukusyaku_keisuu);
                OZ.camera_of_touka_ura.set_camera_bairitsu_y(OZ.d_oriagarizu_syukusyaku_keisuu);

                text29.setText(String.valueOf(OZ.d_oriagarizu_syukusyaku_keisuu));
                text29.setCaretPosition(0);

                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnls2.add(Button_oriagari_kakudai);
        Button_oriagari_kakudai.setBounds(80, 1, 28, 28);
        Button_oriagari_kakudai.setMargin(new Insets(0, 0, 0, 0));
        Button_oriagari_kakudai.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/oriagari_kakudai.png")));


// *****南********************************************************************
        //------------------------------------------------
        JPanel pnls3 = new JPanel();
        pnls3.setPreferredSize(new Dimension(119, 30));
        pnls3.setBackground(Color.white);
        pnls3.setLayout(null);
        pnls3.setBorder(new LineBorder(Color.black, 1));
        pnls.add(pnls3);
        //------------------------------------------------

// *****南********************************************************************
        JButton Button_oriagari_p_kaiten = new JButton("");//new JButton(	"F+rot"	);
        Button_oriagari_p_kaiten.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/oriagari_p_kaiten.png";
                readImageFromFile3();

                OZ.d_oriagarizu_kaiten_hosei = oc.kakudo_osame_m180_180(OZ.d_oriagarizu_kaiten_hosei + 11.25);
                OZ.camera_of_oriagarizu.set_camera_kakudo(OZ.d_oriagarizu_kaiten_hosei);
                OZ.camera_of_oriagari_omote.set_camera_kakudo(OZ.d_oriagarizu_kaiten_hosei);
                OZ.camera_of_oriagari_ura.set_camera_kakudo(OZ.d_oriagarizu_kaiten_hosei);
                OZ.camera_of_touka_omote.set_camera_kakudo(OZ.d_oriagarizu_kaiten_hosei);
                OZ.camera_of_touka_ura.set_camera_kakudo(OZ.d_oriagarizu_kaiten_hosei);

                text30.setText(String.valueOf(OZ.d_oriagarizu_kaiten_hosei));
                text30.setCaretPosition(0);

                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnls3.add(Button_oriagari_p_kaiten);
        Button_oriagari_p_kaiten.setBounds(1, 1, 33, 28);
        Button_oriagari_p_kaiten.setMargin(new Insets(0, 0, 0, 0));
        Button_oriagari_p_kaiten.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/oriagari_p_kaiten.png")));


// ****南**************************************************************************
//回転角度補?ｳ
        text30 = new JTextField("", 2);
        text30.setBounds(34, 4, 35, 24);
        text30.setHorizontalAlignment(JTextField.RIGHT);
        pnls3.add(text30);

// ****南**************************************************************************

// -----回転角度補?ｳset
        JButton Button_oriagarizu_kaiten_hosei_set = new JButton("S");
        Button_oriagarizu_kaiten_hosei_set.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double d_oriagarizu_kaiten_hosei_old = OZ.d_oriagarizu_kaiten_hosei;
                OZ.d_oriagarizu_kaiten_hosei = oc.kakudo_osame_m180_180(String2double(text30.getText(), d_oriagarizu_kaiten_hosei_old));

                text30.setText(String.valueOf(OZ.d_oriagarizu_kaiten_hosei));

                if (OZ.d_oriagarizu_kaiten_hosei != d_oriagarizu_kaiten_hosei_old) {

                    OZ.camera_of_oriagarizu.set_camera_kakudo(OZ.d_oriagarizu_kaiten_hosei);
                    OZ.camera_of_oriagari_omote.set_camera_kakudo(OZ.d_oriagarizu_kaiten_hosei);
                    OZ.camera_of_oriagari_ura.set_camera_kakudo(OZ.d_oriagarizu_kaiten_hosei);
                    OZ.camera_of_touka_omote.set_camera_kakudo(OZ.d_oriagarizu_kaiten_hosei);
                    OZ.camera_of_touka_ura.set_camera_kakudo(OZ.d_oriagarizu_kaiten_hosei);
                }
                text30.setText(String.valueOf(OZ.d_oriagarizu_kaiten_hosei));
                text30.setCaretPosition(0);
                repaint();


                img_kaisetu_fname = "qqq/oriagarizu_kaiten_hosei_set.png";
                readImageFromFile3();
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        Button_oriagarizu_kaiten_hosei_set.setBounds(70, 4, 14, 24);
        pnls3.add(Button_oriagarizu_kaiten_hosei_set);

        Button_oriagarizu_kaiten_hosei_set.setMargin(new Insets(0, 0, 0, 0));


// ------回転角度補?ｳset?Bここまで


// ******南*******************************************************************
        JButton Button_oriagari_m_kaiten = new JButton("");//new JButton(	"F-rot"	);
        Button_oriagari_m_kaiten.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/oriagari_m_kaiten.png";
                readImageFromFile3();
                OZ.d_oriagarizu_kaiten_hosei = oc.kakudo_osame_m180_180(OZ.d_oriagarizu_kaiten_hosei - 11.25);
                OZ.camera_of_oriagarizu.set_camera_kakudo(OZ.d_oriagarizu_kaiten_hosei);
                OZ.camera_of_oriagari_omote.set_camera_kakudo(OZ.d_oriagarizu_kaiten_hosei);
                OZ.camera_of_oriagari_ura.set_camera_kakudo(OZ.d_oriagarizu_kaiten_hosei);
                OZ.camera_of_touka_omote.set_camera_kakudo(OZ.d_oriagarizu_kaiten_hosei);
                OZ.camera_of_touka_ura.set_camera_kakudo(OZ.d_oriagarizu_kaiten_hosei);

                text30.setText(String.valueOf(OZ.d_oriagarizu_kaiten_hosei));
                text30.setCaretPosition(0);


                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnls3.add(Button_oriagari_m_kaiten);
        Button_oriagari_m_kaiten.setBounds(85, 1, 33, 28);
        Button_oriagari_m_kaiten.setMargin(new Insets(0, 0, 0, 0));
        Button_oriagari_m_kaiten.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/oriagari_m_kaiten.png")));

// *******南******************************************************************


// ******************************************************** //?ﾜりあがり?}のanti_aliasアンチェイリアスの変?X

        JButton Button_a_a = new JButton("a_a");
        Button_a_a.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Button_kyoutuu_sagyou();
                img_kaisetu_fname = "qqq/a_a.png";
                readImageFromFile3();

                //i_anti_alias=i_anti_alias+1;
                //if(i_anti_alias>=2){i_anti_alias=0;}
                OZ.js.change_i_anti_alias();
                repaint();
            }
        });
        pnls.add(Button_a_a);

        Button_a_a.setMargin(new Insets(0, 0, 0, 0));
        //Button_a_a.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
        //  "ppp/a_a.png")));
// ******************************************************** //?ﾜりあがり?}の影付け

        JButton Button_kage = new JButton("S");
        Button_kage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Button_kyoutuu_sagyou();
                img_kaisetu_fname = "qqq/kage.png";
                readImageFromFile3();
                OZ.js.change_i_kage();
                repaint();
            }
        });
        pnls.add(Button_kage);

        Button_kage.setMargin(new Insets(0, 0, 0, 0));
        //Button_kage.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
        //  "ppp/kage.png")));
// *********南****************************************************************
// -------------?ﾜり?繧ｪり予測?}表面の?Fの選択

        Button_F_color = new JButton(" ");
        Button_F_color.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/F_color.png";
                readImageFromFile3();
                Button_kyoutuu_sagyou();
                i_mouseDragged_yuukou = 0;
                i_mouseReleased_yuukou = 0;
                //System.out.println("readFile2Memo() 開始");

                //以下にやりたいことを?曹ｭ
                JColorChooser colorchooser = new JColorChooser();
                //Color color = colorchooser.showDialog(null, "F_col", Color.white);
                //if(color != null){OZ.js.set_F_color(color);}

                OZ.oriagarizu_F_color = JColorChooser.showDialog(null, "F_col", Color.white);
                if (OZ.oriagarizu_F_color != null) {
                    OZ.js.set_F_color(OZ.oriagarizu_F_color);
                }


                //以?繧ﾅやりたいことは?曹ｫ?Iわり

                Button_F_color.setBackground(OZ.oriagarizu_F_color);    //ボタンの?F?ﾝ定

                repaint();
            }
        });
        //Button_F_color.setPreferredSize(new Dimension(25, 25));
        Button_F_color.setMargin(new Insets(0, 0, 0, 0));
        Button_F_color.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/F_color.png")));
        pnls.add(Button_F_color);


        //?d要??意?@読み?桙ﾝや?曹ｫ?oしでファイルダイア??グのボックスが開くと?Aそれをフレ?[ムに?dなる位置で操??した?????Aファイルボックスが?ﾁえたときに?A
        //マウスのドラッグとリリ?[スが発?ｶする?Bこのため?A余計な操??がされてしまう可能?ｫがある?Bなお?Aこのときマウスクリックは発?ｶしない?B
        // i_mouseDragged_yuukou=0;や i_mouseReleased_yuukou=0;は?Aこの余計な操??を防ぐために指定している?B


// -------------?ﾜり?繧ｪり予測?}裏面の?Fの選択

        Button_B_color = new JButton(" ");
        Button_B_color.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/B_color.png";
                readImageFromFile3();
                Button_kyoutuu_sagyou();
                i_mouseDragged_yuukou = 0;
                i_mouseReleased_yuukou = 0;
                //System.out.println("readFile2Memo() 開始");

                //以下にやりたいことを?曹ｭ
                JColorChooser colorchooser = new JColorChooser();
                //Color color = colorchooser.showDialog(null, "B_col", Color.white);
                OZ.oriagarizu_B_color = JColorChooser.showDialog(null, "B_col", Color.white);

                if (OZ.oriagarizu_B_color != null) {
                    OZ.js.set_B_color(OZ.oriagarizu_B_color);
                }
                //以?繧ﾅやりたいことは?曹ｫ?Iわり

                Button_B_color.setBackground(OZ.oriagarizu_B_color);    //ボタンの?F?ﾝ定
                repaint();
            }
        });
        //Button_B_color.setPreferredSize(new Dimension(25, 25));
        Button_B_color.setMargin(new Insets(0, 0, 0, 0));
        Button_B_color.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/B_color.png")));
        pnls.add(Button_B_color);


        //?d要??意?@読み?桙ﾝや?曹ｫ?oしでファイルダイア??グのボックスが開くと?Aそれをフレ?[ムに?dなる位置で操??した?????Aファイルボックスが?ﾁえたときに?A
        //マウスのドラッグとリリ?[スが発?ｶする?Bこのため?A余計な操??がされてしまう可能?ｫがある?Bなお?Aこのときマウスクリックは発?ｶしない?B
        // i_mouseDragged_yuukou=0;や i_mouseReleased_yuukou=0;は?Aこの余計な操??を防ぐために指定している?B


// -------------?ﾜり?繧ｪり予測?}?@??の?Fの選択

        Button_L_color = new JButton(" ");
        Button_L_color.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/L_color.png";
                readImageFromFile3();
                Button_kyoutuu_sagyou();
                i_mouseDragged_yuukou = 0;
                i_mouseReleased_yuukou = 0;
                //System.out.println("readFile2Memo() 開始");

                //以下にやりたいことを?曹ｭ
                JColorChooser colorchooser = new JColorChooser();
                //Color color = colorchooser.showDialog(null, "L_col", Color.white);
                //if(color != null){js.set_L_color(color);}

                OZ.oriagarizu_L_color = JColorChooser.showDialog(null, "L_col", Color.white);
                if (OZ.oriagarizu_L_color != null) {
                    OZ.js.set_L_color(OZ.oriagarizu_L_color);
                }


                //以?繧ﾅやりたいことは?曹ｫ?Iわり

                Button_L_color.setBackground(OZ.oriagarizu_L_color);    //ボタンの?F?ﾝ定
                repaint();
            }
        });
        //Button_L_color.setPreferredSize(new Dimension(25, 25));
        Button_L_color.setMargin(new Insets(0, 0, 0, 0));
        Button_L_color.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/L_color.png")));
        pnls.add(Button_L_color);


        //?d要??意?@読み?桙ﾝや?曹ｫ?oしでファイルダイア??グのボックスが開くと?Aそれをフレ?[ムに?dなる位置で操??した?????Aファイルボックスが?ﾁえたときに?A
        //マウスのドラッグとリリ?[スが発?ｶする?Bこのため?A余計な操??がされてしまう可能?ｫがある?Bなお?Aこのときマウスクリックは発?ｶしない?B
        // i_mouseDragged_yuukou=0;や i_mouseReleased_yuukou=0;は?Aこの余計な操??を防ぐために指定している?B


// *******南******************************************************************
        JButton Button_keisan_tyuusi = new JButton("");//?ﾜり?繧ｪり予想の計算の中止
        Button_keisan_tyuusi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/keisan_tyuusi.png";
                readImageFromFile3();

                if (i_SubThread == 1) {
                    keisan_tyuusi();
                    //sub.stop();i_SubThread=0;
                }

                Button_kyoutuu_sagyou();
                //repaint();
            }
        });
        pnls.add(Button_keisan_tyuusi);

        Button_keisan_tyuusi.setMargin(new Insets(0, 0, 0, 0));
        Button_keisan_tyuusi.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/keisan_tyuusi.png")));


// *******南****************************************************************** ?ﾜり?繧ｪり予想の廃棄 ************************************************
        JButton Button_settei_syokika = new JButton("");//new JButton(	"Del_F"	);
        Button_settei_syokika.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/settei_syokika.png";
                readImageFromFile3();


                if (i_OAZ == 0) {
                    return;
                }
                OZ = temp_OZ;//20171223この?sは不要かもしれないが?A一?uでもOZが示すOriagari_Zuがなくなることがないように念のために入れておく
                if (i_OAZ == OAZ.size() - 1) {
                    OAZ.remove(i_OAZ);
                    set_i_OAZ(OAZ.size() - 1);
                }
                if (i_OAZ < OAZ.size() - 1) {
                    OAZ.remove(i_OAZ);
                    set_i_OAZ(i_OAZ);
                }
                //settei_syokika_yosoku();

                Button_kyoutuu_sagyou();
                repaint();

            }
        });
        pnls.add(Button_settei_syokika);

        Button_settei_syokika.setMargin(new Insets(0, 0, 0, 0));
        Button_settei_syokika.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/settei_syokika.png")));

// *******南*************bbbbbbbbbb*****************************************************全操??廃棄 (ﾉToT)ﾉ ┫:･'.::･  ****************************************************

        JButton Button_zen_syokika = new JButton("");//new JButton(	"Del_all"	);
        Button_zen_syokika.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/zen_syokika.png";
                readImageFromFile3();

                //展開?}の?炎匀ｻ?@開始
                //settei_syokika_cp();//展開?}パラ???[タの?炎匀ｻ
                tenkaizu_syokika();
                //展開?}の?炎匀ｻ?@?I了
                //
                //?ﾜ?\測?}のの?炎匀ｻ?@開始
                OZ = temp_OZ;//20171223この?sは不要かもしれないが?A一?uでもOZが示すOriagari_Zuがなくなることがないように念のために入れておく
                OAZ.clear();
                OAZ_add_new_Oriagari_Zu();
                set_i_OAZ(0);
                settei_syokika_yosoku();
                //?ﾜ?\測?}のの?炎匀ｻ?@?I了

                Button_kyoutuu_sagyou();
                repaint();
                i_mouse_modeA = 1;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);

                es1.kiroku();
                es1.h_kiroku();
            }
        });
        pnls.add(Button_zen_syokika);

        Button_zen_syokika.setMargin(new Insets(0, 0, 0, 0));
        Button_zen_syokika.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/zen_syokika.png")));

// *******南*********ボタンの定義はここまで*******************************************************************************************************************************

        //展開?}の?炎匀ｻ?@開始
        //settei_syokika_cp();//展開?}パラ???[タの?炎匀ｻ
        tenkaizu_syokika();
        //展開?}の?炎匀ｻ?@?I了

        i_undo_suu = 20;
        text10.setText(String.valueOf(i_undo_suu));
        i_undo_suu_om = 5;
        text31.setText(String.valueOf(i_undo_suu_om));
        i_h_undo_suu = 20;
        text11.setText(String.valueOf(i_h_undo_suu));
        memori_kankaku = 5;
        text25.setText(String.valueOf(memori_kankaku));
        es1.set_a_to_heikouna_memori_kannkaku(memori_kankaku);
        es1.set_b_to_heikouna_memori_kannkaku(memori_kankaku);

        i_sel_mou_mode = 1;
        Button_sel_mou_wakukae();//セレクトされた?ﾜ??がある?ﾔで?Aセレクトされている?ﾜ??の頂点をクリックした???№ﾌ動??モ?[ドの?炎??ﾝ定

        //?ﾜ?\測?}のの?炎匀ｻ?@開始
        settei_syokika_yosoku();
        //?ﾜ?\測?}のの?炎匀ｻ?@?I了

        Button_kyoutuu_sagyou();

        repaint();

        img_kaisetu_fname = "qqq/a__hajimeni.png";
        readImageFromFile3();

        Button_sen_tokutyuu_color.setBackground(sen_tokutyuu_color);//特???Fの指定?F表示

        // 測定長さと角度の表示

        es1.sokutei_hyouji();
        es1.setCamera(camera_of_orisen_nyuuryokuzu);

        //Ubox.test1();
        es1.kiroku();
        es1.h_kiroku();

        //?ﾜり?繧ｪり?}の?F指定
        //Color oriagarizu_F_color=new Color(255,255,50);//?ﾜり?繧ｪり?}の表面の?F
        //Color oriagarizu_B_color=new Color(233,233,233);//?ﾜり?繧ｪり?}の裏面の?F
        //Color oriagarizu_L_color=Color.black;//?ﾜり?繧ｪり?}の??の?F


        OZ.js.set_F_color(OZ.oriagarizu_F_color); //?ﾜり?繧ｪり?}の表面の?F
        Button_F_color.setBackground(OZ.oriagarizu_F_color);    //ボタンの?F?ﾝ定

        OZ.js.set_B_color(OZ.oriagarizu_B_color);//?ﾜり?繧ｪり?}の裏面の?F
        Button_B_color.setBackground(OZ.oriagarizu_B_color);//ボタンの?F?ﾝ定

        OZ.js.set_L_color(OZ.oriagarizu_L_color);        //?ﾜり?繧ｪり?}の??の?F
        Button_L_color.setBackground(OZ.oriagarizu_L_color);        //ボタンの?F?ﾝ定


        //wwwwwwwwwwwwwwwwwwwwwww


    }//------------------------------------------ボタンの定義等?Aここまでがコンストラクタとして起動直後に?ﾅ?奄ﾉ実?sされる内容

// **************************************************************************************************************************
// **************************************************************************************************************************
// **************************************************************************************************************************

    private int get_i_fold_type() {

        int i_fold_type = 0;//=0なにもしない?A=1通?墲ﾌ展開?}の全?ﾜ??を対?ﾛとした?ﾜり?ﾝ??定?A=2はselectされた?ﾜ??を対?ﾛとした?ﾜり?ﾝ??定?A=3は?ﾜ?ﾝ?ﾔを変?X
        System.out.println("OAZ.size() = " + OAZ.size() + "    : i_OAZ = " + i_OAZ + "    : es1.get_orisensuu_for_select_oritatami() = " + es1.get_orisensuu_for_select_oritatami());
        i_fold_type = 0;
        if (OAZ.size() == 1) {                        //?ﾜり?繧ｪり系?}無し
            if (i_OAZ == 0) {                            //展開?}指定
                if (es1.get_orisensuu_for_select_oritatami() == 0) {        //?ﾜり??選択無し
                    i_fold_type = 1;//全展開?}で?ﾜ?ﾝ
                } else if (es1.get_orisensuu_for_select_oritatami() > 0) {        //?ﾜり??選択有り
                    i_fold_type = 2;//選択された展開?}で?ﾜ?ﾝ
                }
            } else if (i_OAZ > 0) {                        //?ﾜり?繧ｪり系?}指定
                i_fold_type = 0;//有り得ない
            }
        } else if (OAZ.size() > 1) {                        //?ﾜり?繧ｪり系?}有り
            if (i_OAZ == 0) {                            //展開?}指定
                if (es1.get_orisensuu_for_select_oritatami() == 0) {        //?ﾜり??選択無し
                    System.out.println("get_i_fold_type() 20180108");
                    i_fold_type = 0;//何もしない
                    //i_fold_type=1;//全展開?}で?ﾜ?ﾝ
                } else if (es1.get_orisensuu_for_select_oritatami() > 0) {        //?ﾜり??選択有り
                    i_fold_type = 2;//選択された展開?}で?ﾜ?ﾝ
                }
            } else if (i_OAZ > 0) {                        //?ﾜり?繧ｪり系?}指定
                if (es1.get_orisensuu_for_select_oritatami() == 0) {        //?ﾜり??選択無し
                    i_fold_type = 3;//指定された?ﾜり?繧ｪり系?}で?ﾜ?ﾝ
                } else if (es1.get_orisensuu_for_select_oritatami() > 0) {        //?ﾜり??選択有り
                    i_fold_type = 2;//選択された展開?}で?ﾜ?ﾝ
                }
            }
        }


        return i_fold_type;
    }

    // ------------------------------------------------------------------------
    public Ten ten_of_kijyunmen_old = new Ten(); //ten_of_kijyunmen_old.set(OZ.ts1.get_ten_of_kijyunmen_tv());//20180222?ﾜり??選択?ﾔで?ﾜり?ﾝ??定をする?ﾛ?A以前に指定されていた基??面を引き継ぐために追加

    //
    private void oritatame(int i_fold_type, int i_suitei_meirei) {//引?狽ﾌ意味は(i_fold_type , i_suitei_meirei)
        //i_fold_typeはget_i_fold_type()関?狽ﾅ取得する?B
        //i_fold_type=0なにもしない?A=1通?墲ﾌ展開?}の全?ﾜ??を対?ﾛとした?ﾜり?ﾝ??定?A=2はselectされた?ﾜ??を対?ﾛとした?ﾜり?ﾝ??定?A=3は?ﾜ?ﾝ?ﾔを変?X
        if (i_fold_type == 0) {
            System.out.println(" oritatame 20180108");
        } else if ((i_fold_type == 1) || (i_fold_type == 2)) {
            if (i_fold_type == 1) {
                es1.select_all();
            }
            //
            if (ckbox_cp_kaizen_oritatami.isSelected()) {//展開?}のおかしい???i枝?ﾌ?ﾜり??等?jを自動?C?ｳする
                Egaki_Syokunin es2 = new Egaki_Syokunin(r, this);    //基本枝?E?l?Bマウスからの入力を受け付ける?B
                es2.setMemo_for_yomikomi(es1.ori_s.getMemo_for_select_oritatami());
                es2.ten_sakujyo();
                es2.jyuufuku_senbun_sakujyo();
                es2.eda_kesi(0.000001);
                es2.en_seiri();
                Ss0 = es2.get_for_oritatami();
            } else {
                Ss0 = es1.get_for_select_oritatami();
            }


//bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb

            //
            //Ten ten_of_kijyunmen_old =new Ten(); ten_of_kijyunmen_old.set(OZ.ts1.get_ten_of_kijyunmen_tv());
            ten_of_kijyunmen_old.set(OZ.ts1.get_ten_of_kijyunmen_tv());//20180222?ﾜり??選択?ﾔで?ﾜり?ﾝ??定をする?ﾛ?A以前に指定されていた基??面を引き継ぐために追加
            //これより前のOZは古いOZ
            oritatami_jyunbi();//OAZのアレイリストに?A?Vしく?ﾜり?繧ｪり?}をひとつ追加し?Aそれを操??対?ﾛに指定し?AOAZ(0)共通パラ???[タを引き継がせる?B
            //これより後のOZは?VしいOZに変わる
            //OZ.ts1.set_kijyunmen_id(ten_of_kijyunmen_old);


            //OZ.i_suitei_jissi_umu=0;	//i_suitei_jissi_umuは?A?ﾜり?ﾝ??定の計算を実施したかどうかを表す?Bint i_suitei_jissi_umu=0なら実施しない?B1なら実施した?B
            OZ.i_suitei_meirei = i_suitei_meirei;

            if (i_SubThread == 0) {
                i_SubThread = 1;
                i_sub_mode = 0;//1=?ﾜ?ﾝ??定の別解をまとめて?oす?B0=?ﾜ?ﾝ??定の別解をまとめて?oすモ?[ドではない?Bこの変?狽ﾍサブスレッドの動??変?Xにつかうだけ?B20170611にVer3.008から追加
                mks();//?Vしいスレッドを??る
                sub.start();
            }


        } else if (i_fold_type == 3) {
            OZ.i_suitei_meirei = i_suitei_meirei;

            if (i_SubThread == 0) {
                i_SubThread = 1;
                i_sub_mode = 0;//1=?ﾜ?ﾝ??定の別解をまとめて?oす?B0=?ﾜ?ﾝ??定の別解をまとめて?oすモ?[ドではない?Bこの変?狽ﾍサブスレッドの動??変?Xにつかうだけ?B20170611にVer3.008から追加
                mks();//?Vしいスレッドを??る
                sub.start();
            }
        }
    }


// ------------------------------------------------------------------------


    void oritatami_jyunbi() {//OAZのアレイリストに?A?Vしく?ﾜり?繧ｪり?}をひとつ追加し?Aそれを操??対?ﾛに指定し?AOAZ(0)共通パラ???[タを引き継がせる?B

        System.out.println(" oritatami_jyunbi 20180107");

        OAZ_add_new_Oriagari_Zu(); //OAZのアレイリストに?A?Vしく?ﾜり?繧ｪり?}をひとつ追加する?B

        set_i_OAZ(OAZ.size() - 1);//i_OAZ=i;OZ = (Oriagari_Zu)OAZ.get(i_OAZ); OZ(各操??の対?ﾛとなる?ﾜ?繧ｪり?}?jに?Aアレイリストに?ﾅ?Vに追加された?ﾜ?繧ｪり?}を割り当てる)

        Oriagari_Zu orz;
        orz = (Oriagari_Zu) OAZ.get(0);//OAZ(0)(共通パラ???[タを保??する?ﾜ?繧ｪり?}?jをorzに割り付ける

        //以下ではOAZ(0)の共通パラ???[タを?A現?ﾝ操??対?ﾛとなっているOZに渡す
        OZ.oriagarizu_F_color = orz.js.get_F_color();//20171223?ﾜり?繧ｪり?}の表面の?Fの変?XはOZ.oriagarizu_F_colorとOZ.js.set_F_colorの両方やる必要あり
        OZ.js.set_F_color(OZ.oriagarizu_F_color); //?ﾜり?繧ｪり?}の表面の?F
        Button_F_color.setBackground(OZ.oriagarizu_F_color);    //ボタンの?F?ﾝ定

        OZ.oriagarizu_B_color = orz.js.get_B_color();//20171223?ﾜり?繧ｪり?}の表面の?Fの変?XはOZ.oriagarizu_F_colorとOZ.js.set_F_colorの両方やる必要あり
        OZ.js.set_B_color(OZ.oriagarizu_B_color); //?ﾜり?繧ｪり?}の表面の?F
        Button_B_color.setBackground(OZ.oriagarizu_B_color);    //ボタンの?F?ﾝ定

        OZ.oriagarizu_L_color = orz.js.get_L_color();//20171223?ﾜり?繧ｪり?}の表面の?Fの変?XはOZ.oriagarizu_F_colorとOZ.js.set_F_colorの両方やる必要あり
        OZ.js.set_L_color(OZ.oriagarizu_L_color); //?ﾜり?繧ｪり?}の表面の?F
        Button_L_color.setBackground(OZ.oriagarizu_L_color);    //ボタンの?F?ﾝ定
        //以?繧ﾅOAZ(0)の共通パラ???[タを?AOZに渡す??業は?I了

    }

    // ------------------------------------------------------------------------------
    public void OAZ_add_new_Oriagari_Zu() {

        OAZ.add(new Oriagari_Zu_01(this));

        //	OZ = (Oriagari_Zu)OAZ.get(OAZ.size()-1);//?ﾜりあがり?}
    }


    public void sokutei_nagasa_1_hyouji(double d0) {
        label_nagasa_sokutei_1.setText(String.valueOf(d0));
    }

    public void sokutei_nagasa_2_hyouji(double d0) {
        label_nagasa_sokutei_2.setText(String.valueOf(d0));
    }

    public void sokutei_kakudo_1_hyouji(double d0) {
        label_kakudo_sokutei_1.setText(String.valueOf(d0));
    }

    public void sokutei_kakudo_2_hyouji(double d0) {
        label_kakudo_sokutei_2.setText(String.valueOf(d0));
    }

    public void sokutei_kakudo_3_hyouji(double d0) {
        label_kakudo_sokutei_3.setText(String.valueOf(d0));
    }

// ----------------------------------

    public void iro_sitei_ato_ni_jissisuru_sagyou() {
        if (iro_sitei_ato_ni_jissisuru_sagyou_bangou == 1) {
            i_orisen_hojyosen = 0;//=0は?ﾜ??入力?@=1は補????入力モ?[ド
            es1.set_i_orisen_hojyosen(i_orisen_hojyosen);//このボタンと機能は補?賦G??共通に使っているのでi_orisen_hojyosenの指定がいる
            i_mouse_modeA = 1;
            System.out.println("i_mouse_modeA = " + i_mouse_modeA);

        } else if (iro_sitei_ato_ni_jissisuru_sagyou_bangou == 11) {
            i_mouse_modeA = 11;
            System.out.println("i_mouse_modeA = " + i_mouse_modeA);

        }


    }


    //public int get_i_AS_matome_mode(){return i_AS_matome_mode; } //

    public void set_kousi_bunkatu_suu() {
        int nyuuryoku_kitei_old = nyuuryoku_kitei;
        nyuuryoku_kitei = ms.String2int(text1.getText(), nyuuryoku_kitei_old);
        if (nyuuryoku_kitei < 1) {
            nyuuryoku_kitei = 1;
        }
        text1.setText(String.valueOf(nyuuryoku_kitei));
        es1.set_kousi_bunkatu_suu(nyuuryoku_kitei);
    }
    // ----------------------------------------------------------

    public void keikoku_sentaku_sareta_orisen_ga_nai() {
        JLabel label = new JLabel(
                "<html>２?F塗りわけ展開?}を描くためには?Aあらかじめ対?ﾛ範囲を選択してください?iselectボタンを使う?j?B<br>" +
                        "To get 2-Colored crease pattern, select the target range in advance (use the select button).<html>");
        //label.setForeground(Color.RED);
        JOptionPane.showMessageDialog(this, label);
    }

    // ----------------------------------------------------------

    public void keikoku_sentaku_sareta_orisen_ga_nai_2() {
        JLabel label = new JLabel(
                "<html>?Vたに?ﾜり?繧ｪり?}を描くためには?Aあらかじめ対?ﾛ範囲を選択してください?iselectボタンを使う?j?B<br>" +
                        "To calculate new folded shape, select the target clease lines range in advance (use the select button).<html>");
        //label.setForeground(Color.RED);
        JOptionPane.showMessageDialog(this, label);
    }
    // ----------------------------------------------------------


    public void keisan_tyuusi() {


        //int option = JOptionPane.showConfirmDialog(this, "展開?}保存する?H/Save CP?H");

        int option = JOptionPane.showConfirmDialog(this, new ImageIcon(getClass().getClassLoader().getResource("ppp/keisan_tyuusi_DLog.png")));

        if (option == JOptionPane.YES_OPTION) {
            i_mouseDragged_yuukou = 0;
            i_mouseReleased_yuukou = 0;
            writeMemo2File();
            es1.kiroku();
        } else if (option == JOptionPane.NO_OPTION) {
        } else if (option == JOptionPane.CANCEL_OPTION) {
            return;
        }


        sub.stop();
        i_SubThread = 0;

        settei_syokika_yosoku();

    }

    // ----------------------------------------------------------

    public void owari() {


        //int option = JOptionPane.showConfirmDialog(this, "デ?[タを保存しますか?H/Save CP?H");

        int option = JOptionPane.showConfirmDialog(this, new ImageIcon(getClass().getClassLoader().getResource("ppp/owari.png")));

        if (option == JOptionPane.YES_OPTION) {
            i_mouseDragged_yuukou = 0;
            i_mouseReleased_yuukou = 0;
            writeMemo2File();
            if (i_SubThread == 1) {
                sub.stop();
            }
            System.exit(0);
        } else if (option == JOptionPane.NO_OPTION) {
            if (i_SubThread == 1) {
                sub.stop();
            }
            System.exit(0);
        } else if (option == JOptionPane.CANCEL_OPTION) {
            return;
        }


    }


// *******************************************************************************************************


    //  void settei_syokika_cp(){	}


    //----------------------------------------------------------

    // --------展開?}の?炎匀ｻ-----------------------------
    void tenkaizu_syokika() {

//全体
        //描き?E?lの?炎匀ｻ
        es1.reset();
        es1.reset_2();    //描き?E?lの?炎匀ｻ


        //camera_of_orisen_nyuuryokuzu	の?ﾝ定;
        camera_of_orisen_nyuuryokuzu.set_camera_ichi_x(0.0);
        camera_of_orisen_nyuuryokuzu.set_camera_ichi_y(0.0);
        camera_of_orisen_nyuuryokuzu.set_camera_kakudo(0.0);
        camera_of_orisen_nyuuryokuzu.set_camera_kagami(1.0);
        camera_of_orisen_nyuuryokuzu.set_camera_bairitsu_x(1.0);
        camera_of_orisen_nyuuryokuzu.set_camera_bairitsu_y(1.0);
        camera_of_orisen_nyuuryokuzu.set_hyouji_ichi_x(350.0);
        camera_of_orisen_nyuuryokuzu.set_hyouji_ichi_y(350.0);

        //camera_haikei	;

        es1.setCamera(camera_of_orisen_nyuuryokuzu);
        OZ.ts1.setCamera(camera_of_orisen_nyuuryokuzu);

        //?ﾜ??入力か補????入力か
        i_orisen_hojyosen = 0;


//北辺

        ckbox_mouse_settei.setSelected(true);//表示するかどうかの選択
        ckbox_ten_sagasi.setSelected(false);//表示するかどうかの選択
        ckbox_ten_hanasi.setSelected(false);//es1.set_i_hanasi(0);          //表示するかどうかの選択
        ckbox_kou_mitudo_nyuuryoku.setSelected(false);
        es1.set_i_kou_mitudo_nyuuryoku(0);          //?ｖｧ度入力するかどうかの選択
        ckbox_bun.setSelected(true);//文を表示するかどうかの選択
        ckbox_cp.setSelected(true);//?ﾜ??を表示するかどうかの選択
        ckbox_a0.setSelected(true);//補?賦???を表示するかどうかの選択
        ckbox_a1.setSelected(true);//補?負???を表示するかどうかの選択
        ckbox_mejirusi.setSelected(true);//?\字や基??面などの目印画??
        ckbox_cp_ue.setSelected(false);//展開?}を?ﾜり?繧ｪり予想?}の?繧ﾉ描く
        ckbox_oritatami_keika.setSelected(false);//?ﾜり?繧ｪり予想の途中経過の?曹ｫ?oし
        ckbox_cp_kaizen_oritatami.setSelected(false);//cpを?ﾜ?ﾝ前に自動改善する
        ckbox_select_nokosi.setSelected(false);//select?ﾔを?ﾜ?ﾝ操??をしてもなるべく残す
        ckbox_toukazu_color.setSelected(false);//透過?}をカラ?[化する?B


        //内分された?ﾜ??の指定
        d_orisen_naibun_a = 1.0;
        text3.setText(String.valueOf(d_orisen_naibun_a));
        d_orisen_naibun_b = 0.0;
        text4.setText(String.valueOf(d_orisen_naibun_b));
        d_orisen_naibun_c = 0.0;
        text5.setText(String.valueOf(d_orisen_naibun_c));
        d_orisen_naibun_d = 0.0;
        text6.setText(String.valueOf(d_orisen_naibun_d));
        d_orisen_naibun_e = 1.0;
        text7.setText(String.valueOf(d_orisen_naibun_e));
        d_orisen_naibun_f = 2.0;
        text8.setText(String.valueOf(d_orisen_naibun_f));

        //
        d_syukusyaku_keisuu = 1.0;
        text27.setText(String.valueOf(d_syukusyaku_keisuu)); //?k尺係??
        d_kaiten_hosei = 0.0;
        text28.setText(String.valueOf(d_kaiten_hosei));//回転表示角度の補?ｳ係??

        OZ.d_oriagarizu_syukusyaku_keisuu = 1.0;
        text29.setText(String.valueOf(OZ.d_oriagarizu_syukusyaku_keisuu));//?ﾜり?繧ｪり?}の?k尺係??
        OZ.d_oriagarizu_kaiten_hosei = 0.0;
        text30.setText(String.valueOf(OZ.d_oriagarizu_kaiten_hosei));//?ﾜり?繧ｪり?}の回転表示角度の補?ｳ角度


        //背景表示
        ihaikeihyouji = 1;
        Button_haikei_kirikae.setBackground(Color.ORANGE);

        //背景??ックオン
        i_Lock_on = 0;
        i_Lock_on_ori = 0;
        Button_haikei_Lock_on.setBackground(Color.gray);

//?ｼ辺


        //展開?}の??の太さ?B
        iTenkaizuSenhaba = 1;

        //頂点のしるしの??
        ir_ten = 1;


        //基本枝?\造の直??の両端の円の半径?A?i以前は枝と各種ポイントの近さの判定基???j
        //double r=3.0;
        //es1.set_r(r);

        //?ﾜ??表現を?Fで表す
        i_orisen_hyougen = 1;

        //ペンの?Fの指定
        icol = 1;
        es1.setcolor(icol);    //?ﾅ?奄ﾌ?ﾜ??の?Fを指定する?B0は???A1は?ﾔ?A2は?ﾂ?B
        ButtonCol_irokesi();
        ButtonCol_red.setForeground(Color.black);
        ButtonCol_red.setBackground(Color.red);    //?ﾜ??のボタンの?F?ﾝ定


        //?ﾜ??分割??
        i_orisen_bunkatu_suu = 2;
        text2.setText(String.valueOf(i_orisen_bunkatu_suu));
        es1.set_i_orisen_bunkatu_suu(i_orisen_bunkatu_suu);//フリ?[?ﾜ??入力時の分割??


        //格子分割?狽ﾌ指定
        text1.setText("8");
        set_kousi_bunkatu_suu();

        //格子の適用範囲の指定
        es1.set_i_kitei_jyoutai(1);//格子の?ﾔを用紙内適用にする?B

        //任意格子
        d_kousi_x_a = 0.0;
        text18.setText(String.valueOf(d_kousi_x_a));
        d_kousi_x_b = 1.0;
        text19.setText(String.valueOf(d_kousi_x_b));
        d_kousi_x_c = 1.0;
        text20.setText(String.valueOf(d_kousi_x_c));

        d_kousi_y_a = 0.0;
        text21.setText(String.valueOf(d_kousi_y_a));
        d_kousi_y_b = 1.0;
        text22.setText(String.valueOf(d_kousi_y_b));
        d_kousi_y_c = 1.0;
        text23.setText(String.valueOf(d_kousi_y_c));

        d_kousi_kakudo = 90.0;
        text24.setText(String.valueOf(d_kousi_kakudo));

        set_kousi();
//--------------------------------------------
//東辺
        //角度系入力を22.5度系にする?B
        es1.set_id_kakudo_kei(8);

        //自由角度
        d_jiyuu_kaku_a = 40.0;
        text12.setText(String.valueOf(d_jiyuu_kaku_a));
        d_jiyuu_kaku_b = 60.0;
        text13.setText(String.valueOf(d_jiyuu_kaku_b));
        d_jiyuu_kaku_c = 80.0;
        text14.setText(String.valueOf(d_jiyuu_kaku_c));

        d_jiyuu_kaku_a = 30.0;
        text15.setText(String.valueOf(d_jiyuu_kaku_d));
        d_jiyuu_kaku_b = 50.0;
        text16.setText(String.valueOf(d_jiyuu_kaku_e));
        d_jiyuu_kaku_c = 100.0;
        text17.setText(String.valueOf(d_jiyuu_kaku_f));

        //多角形の角??
        i_sei_takakukei = 5;
        text9.setText(String.valueOf(i_sei_takakukei));

        //補?負???の?F
        h_icol = 4;
        es1.h_setcolor(h_icol);                                        //?ﾅ?奄ﾌ補????の?Fを指定する?B4はオレンジ?A7は黄?B
        Button_h_Col_irokesi();
        Button_Col_orange.setForeground(Color.black);
        Button_Col_orange.setBackground(Color.ORANGE);    //補????のボタンの?F?ﾝ定

        //ckbox_check1.setSelected(false);//checkするかどうかの選択
        //ckbox_check2.setSelected(false);//checkするかどうかの選択
        ckbox_check3.setSelected(false);//checkするかどうかの選択
        es1.set_i_check3(0);
        ckbox_check4.setSelected(false);//checkするかどうかの選択
        es1.set_i_check4(0);
    }


    // *******************************************************************************************************
    public double d_kousi_x_nagasa;
    public double d_kousi_y_nagasa;

    public void set_kousi() {
        double d_kousi_x_a_old = d_kousi_x_a;
        double d_kousi_x_b_old = d_kousi_x_b;
        double d_kousi_x_c_old = d_kousi_x_c;
        double d_kousi_y_a_old = d_kousi_y_a;
        double d_kousi_y_b_old = d_kousi_y_b;
        double d_kousi_y_c_old = d_kousi_y_c;

        double d_kousi_kakudo_old = d_kousi_kakudo;

        d_kousi_x_a = String2double(text18.getText(), d_kousi_x_a_old);
        d_kousi_x_b = String2double(text19.getText(), d_kousi_x_b_old);
        d_kousi_x_c = String2double(text20.getText(), d_kousi_x_c_old);
        if (d_kousi_x_c < 0.0) {
            d_kousi_x_c = 0.0;
        }
        d_kousi_y_a = String2double(text21.getText(), d_kousi_y_a_old);
        d_kousi_y_b = String2double(text22.getText(), d_kousi_y_b_old);
        d_kousi_y_c = String2double(text23.getText(), d_kousi_y_c_old);
        if (d_kousi_y_c < 0.0) {
            d_kousi_y_c = 0.0;
        }

        d_kousi_kakudo = String2double(text24.getText(), d_kousi_kakudo_old);
        if (Math.abs(oc.kakudo_osame_0_360(d_kousi_kakudo)) < 0.1) {
            d_kousi_kakudo = 90.0;
        }
        if (Math.abs(oc.kakudo_osame_0_360(d_kousi_kakudo - 180.0)) < 0.1) {
            d_kousi_kakudo = 90.0;
        }
        if (Math.abs(oc.kakudo_osame_0_360(d_kousi_kakudo - 360.0)) < 0.1) {
            d_kousi_kakudo = 90.0;
        }


        d_kousi_x_nagasa = d_kousi_x_a + d_kousi_x_b * Math.sqrt(d_kousi_x_c);
        if (d_kousi_x_nagasa < 0.0) {
            d_kousi_x_a = 1.0;
            d_kousi_x_b = 0.0;
            d_kousi_x_c = 0.0;
        }
        d_kousi_y_nagasa = d_kousi_y_a + d_kousi_y_b * Math.sqrt(d_kousi_y_c);
        if (d_kousi_y_nagasa < 0.0) {
            d_kousi_y_a = 1.0;
            d_kousi_y_b = 0.0;
            d_kousi_y_c = 0.0;
        }
        if (Math.abs(d_kousi_x_nagasa) < 0.0001) {
            d_kousi_x_a = 1.0;
            d_kousi_x_b = 0.0;
            d_kousi_x_c = 0.0;
            d_kousi_x_nagasa = d_kousi_x_a + d_kousi_x_b * Math.sqrt(d_kousi_x_c);
        }
        if (Math.abs(d_kousi_y_nagasa) < 0.0001) {
            d_kousi_y_a = 1.0;
            d_kousi_y_b = 0.0;
            d_kousi_y_c = 0.0;
            d_kousi_y_nagasa = d_kousi_y_a + d_kousi_y_b * Math.sqrt(d_kousi_y_c);
        }


        text18.setText(String.valueOf(d_kousi_x_a));
        text19.setText(String.valueOf(d_kousi_x_b));
        text20.setText(String.valueOf(d_kousi_x_c));
        text21.setText(String.valueOf(d_kousi_y_a));
        text22.setText(String.valueOf(d_kousi_y_b));
        text23.setText(String.valueOf(d_kousi_y_c));

        text24.setText(String.valueOf(d_kousi_kakudo));

        //System.out.println(" d_kousi_x_nagasa :"+d_kousi_x_nagasa );
        //System.out.println(" d_kousi_y_nagasa :"+d_kousi_y_nagasa );
        //System.out.println(" d_kousi_kakudo   :"+d_kousi_kakudo );

        es1.set_d_kousi(d_kousi_x_nagasa, d_kousi_y_nagasa, d_kousi_kakudo);
    }


// *******************************************************************************************************

    public void set_naibun() {
        double d_orisen_naibun_a_old = d_orisen_naibun_a;
        double d_orisen_naibun_b_old = d_orisen_naibun_b;
        double d_orisen_naibun_c_old = d_orisen_naibun_c;
        double d_orisen_naibun_d_old = d_orisen_naibun_d;
        double d_orisen_naibun_e_old = d_orisen_naibun_e;
        double d_orisen_naibun_f_old = d_orisen_naibun_f;

        d_orisen_naibun_a = String2double(text3.getText(), d_orisen_naibun_a_old);
        d_orisen_naibun_b = String2double(text4.getText(), d_orisen_naibun_b_old);
        d_orisen_naibun_c = String2double(text5.getText(), d_orisen_naibun_c_old);
        if (d_orisen_naibun_c < 0.0) {
            d_orisen_naibun_c = 0.0;
        }
        d_orisen_naibun_d = String2double(text6.getText(), d_orisen_naibun_d_old);
        d_orisen_naibun_e = String2double(text7.getText(), d_orisen_naibun_e_old);
        d_orisen_naibun_f = String2double(text8.getText(), d_orisen_naibun_f_old);
        if (d_orisen_naibun_f < 0.0) {
            d_orisen_naibun_f = 0.0;
        }

        double d_naibun_s;
        d_naibun_s = d_orisen_naibun_a + d_orisen_naibun_b * Math.sqrt(d_orisen_naibun_c);
        if (d_naibun_s < 0.0) {
            d_orisen_naibun_b = 0.0;
        }
        double d_naibun_t;
        d_naibun_t = d_orisen_naibun_d + d_orisen_naibun_e * Math.sqrt(d_orisen_naibun_f);
        if (d_naibun_t < 0.0) {
            d_orisen_naibun_e = 0.0;
        }

        text3.setText(String.valueOf(d_orisen_naibun_a));
        text4.setText(String.valueOf(d_orisen_naibun_b));
        text5.setText(String.valueOf(d_orisen_naibun_c));
        text6.setText(String.valueOf(d_orisen_naibun_d));
        text7.setText(String.valueOf(d_orisen_naibun_e));
        text8.setText(String.valueOf(d_orisen_naibun_f));

        es1.set_d_naibun_st(d_naibun_s, d_naibun_t);

        //if(i_orisen_bunkatu_suu<1){i_orisen_bunkatu_suu=1;}
        //text2.setText(String.valueOf(i_orisen_bunkatu_suu));


    }


// *******************************************************************************************************

    public void set_jiyuu_kaku_abc() {
        double d_jiyuu_kaku_a_old = d_jiyuu_kaku_a;
        double d_jiyuu_kaku_b_old = d_jiyuu_kaku_b;
        double d_jiyuu_kaku_c_old = d_jiyuu_kaku_c;

//System.out.println(" d_jiyuu_kaku_a 1 :"+d_jiyuu_kaku_a );
        d_jiyuu_kaku_a = String2double(text12.getText(), d_jiyuu_kaku_a_old);
        d_jiyuu_kaku_b = String2double(text13.getText(), d_jiyuu_kaku_b_old);
        d_jiyuu_kaku_c = String2double(text14.getText(), d_jiyuu_kaku_c_old);
//System.out.println(" d_jiyuu_kaku_a 2:"+d_jiyuu_kaku_a );

        text12.setText(String.valueOf(d_jiyuu_kaku_a));
        text13.setText(String.valueOf(d_jiyuu_kaku_b));
        text14.setText(String.valueOf(d_jiyuu_kaku_c));

        es1.set_d_jiyuu_kaku(d_jiyuu_kaku_a, d_jiyuu_kaku_b, d_jiyuu_kaku_c);
    }

// ------------------------------------------------------

    public void set_jiyuu_kaku_def() { //このdefは?u定義?vと言う意味ではなく?Adとeとfを扱うという意味
        double d_jiyuu_kaku_d_old = d_jiyuu_kaku_d;
        double d_jiyuu_kaku_e_old = d_jiyuu_kaku_e;
        double d_jiyuu_kaku_f_old = d_jiyuu_kaku_f;

//System.out.println(" d_jiyuu_kaku_a 1 :"+d_jiyuu_kaku_a );
        d_jiyuu_kaku_d = String2double(text15.getText(), d_jiyuu_kaku_d_old);
        d_jiyuu_kaku_e = String2double(text16.getText(), d_jiyuu_kaku_e_old);
        d_jiyuu_kaku_f = String2double(text17.getText(), d_jiyuu_kaku_f_old);
//System.out.println(" d_jiyuu_kaku_a 2:"+d_jiyuu_kaku_a );

        text15.setText(String.valueOf(d_jiyuu_kaku_d));
        text16.setText(String.valueOf(d_jiyuu_kaku_e));
        text17.setText(String.valueOf(d_jiyuu_kaku_f));

        es1.set_d_jiyuu_kaku(d_jiyuu_kaku_d, d_jiyuu_kaku_e, d_jiyuu_kaku_f);
    }


// *******************************************************************************************************


    //ボタンを押されたときの????----------------
    public void actionPerformed(ActionEvent e) {

    }


    //--------------------------------------------------------
    void Button_sel_mou_wakukae() {

        Button_move.setBorder(new LineBorder(new Color(150, 150, 150), 1, false));
        Button_move_2p2p.setBorder(new LineBorder(new Color(150, 150, 150), 1, false));
        Button_copy_paste.setBorder(new LineBorder(new Color(150, 150, 150), 1, false));
        Button_copy_paste_2p2p.setBorder(new LineBorder(new Color(150, 150, 150), 1, false));
        Button_kyouei.setBorder(new LineBorder(new Color(150, 150, 150), 1, false));


        if (i_sel_mou_mode == 1) {
            Button_move.setBorder(new LineBorder(Color.green, 3, false));
        } else if (i_sel_mou_mode == 2) {
            Button_move_2p2p.setBorder(new LineBorder(Color.green, 3, false));
        } else if (i_sel_mou_mode == 3) {
            Button_copy_paste.setBorder(new LineBorder(Color.green, 3, false));
        } else if (i_sel_mou_mode == 4) {
            Button_copy_paste_2p2p.setBorder(new LineBorder(Color.green, 3, false));
        } else if (i_sel_mou_mode == 5) {
            Button_kyouei.setBorder(new LineBorder(Color.green, 3, false));
        }

    }


    //--------------------------------------------------------
    void Button_irokesi() {
        Button_M_nisuru.setForeground(Color.black);
        Button_V_nisuru.setForeground(Color.black);
        Button_E_nisuru.setForeground(Color.black);
        Button_HK_nisuru.setForeground(Color.black); //HKとは補?賦???のこと
        Button_senbun_henkan2.setForeground(Color.black);

        //Button_M_nisuru.setBackground(new Color(150,150,150));
        //Button_V_nisuru.setBackground(new Color(150,150,150));
        //Button_E_nisuru.setBackground(new Color(150,150,150));
        //Button_HK_nisuru.setBackground(new Color(150,150,150));

        Button_M_nisuru.setBackground(Color.white);
        Button_V_nisuru.setBackground(Color.white);
        Button_E_nisuru.setBackground(Color.white);
        Button_HK_nisuru.setBackground(Color.white);
        Button_senbun_henkan2.setBackground(Color.white);
    }

    //--------------------------------------------------------
    void ButtonCol_irokesi() {

        ButtonCol_black.setForeground(Color.black);
        ButtonCol_blue.setForeground(Color.black);
        ButtonCol_red.setForeground(Color.black);
        ButtonCol_cyan.setForeground(Color.black);

        ButtonCol_black.setBackground(new Color(150, 150, 150));
        ButtonCol_blue.setBackground(new Color(150, 150, 150));
        ButtonCol_red.setBackground(new Color(150, 150, 150));
        ButtonCol_cyan.setBackground(new Color(150, 150, 150));
    }


    //--------------------------------------------------------
    void Button_h_Col_irokesi() {
        Button_Col_orange.setBackground(new Color(150, 150, 150));
        Button_Col_yellow.setBackground(new Color(150, 150, 150));
    }


    //アプレットの?炎匀ｻを?sう関??----------------------------------------------------
    //public void start() {;}

    //アプレットの後????を?sう関??----------------------------------------------------
    //public void stop() {;}

    //アプレットの?ﾅ?I????を?sう関??----------------------------------------------------
    public void destroy() {
        removeMouseListener(this);
    }//removeMouseMotionListenerやremoveMouseWheelListenerはどうなる?H?@20170401


    void Button_kyoutuu_sagyou() {
        es1.set_i_egaki_dankai(0);
        es1.set_i_en_egaki_dankai(0);
        es1.set_s_step_iactive(3);//要??意?@es1でうっかりs_stepにset.(senbun)やるとアクティヴでないので表示が?ｬさくなる20170507
        es1.ori_v.reset();
    }


    // *******************************************************************************************zzzzzzzzzzzz
    public void i_cp_or_oriagari_hantei(Ten p) {//マウスで得られたTenが?A展開?}や?ﾜり?繧ｪり?}などのどれを指しているのか判定する関??
        //20171216
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

        //OZ_hyouji_mode=0;  nun
        //OZ_hyouji_mode=1;  omote
        //OZ_hyouji_mode=2;  ura
        //OZ_hyouji_mode=3;  omote & ura
        //OZ_hyouji_mode=4;  omote & ura & omote2 & ura2

        int temp_i_OAZ = 0;
        int temp_i_cp_or_oriagari = 0;
        Oriagari_Zu OZi;
        for (int i = 1; i <= OAZ.size() - 1; i++) {
            OZi = (Oriagari_Zu) OAZ.get(i);


            int OZ_hyouji_mode = 0;//?ﾜり?繧ｪり?}表示なし
            if ((OZi.hyouji_flg == 2) && (OZi.ip4 == 0)) {
                OZ_hyouji_mode = 1;
            }//	omote
            if ((OZi.hyouji_flg == 2) && (OZi.ip4 == 1)) {
                OZ_hyouji_mode = 2;
            }//	ura
            if ((OZi.hyouji_flg == 2) && (OZi.ip4 == 2)) {
                OZ_hyouji_mode = 3;
            }//	omote & ura
            if ((OZi.hyouji_flg == 2) && (OZi.ip4 == 3)) {
                OZ_hyouji_mode = 3;
            }//	omote & ura

            if ((OZi.hyouji_flg == 3) && (OZi.ip4 == 0)) {
                OZ_hyouji_mode = 1;
            }//	omote
            if ((OZi.hyouji_flg == 3) && (OZi.ip4 == 1)) {
                OZ_hyouji_mode = 2;
            }//	ura
            if ((OZi.hyouji_flg == 3) && (OZi.ip4 == 2)) {
                OZ_hyouji_mode = 3;
            }//	omote & ura
            if ((OZi.hyouji_flg == 3) && (OZi.ip4 == 3)) {
                OZ_hyouji_mode = 3;
            }//	omote & ura

            if ((OZi.hyouji_flg == 5) && (OZi.ip4 == 0)) {
                OZ_hyouji_mode = 1;
            }//	omote
            if ((OZi.hyouji_flg == 5) && (OZi.ip4 == 1)) {
                OZ_hyouji_mode = 2;
            }//	ura
            if ((OZi.hyouji_flg == 5) && (OZi.ip4 == 2)) {
                OZ_hyouji_mode = 3;
            }//	omote & ura
            if ((OZi.hyouji_flg == 5) && (OZi.ip4 == 3)) {
                OZ_hyouji_mode = 4;
            }//	omote & ura & omote2 & ura2

            //temp_i_cp_or_oriagari=0;

            if (OZi.ts2.naibu_hantei_omote(p) > 0) {
                if (((OZ_hyouji_mode == 1) || (OZ_hyouji_mode == 3)) || (OZ_hyouji_mode == 4)) {
                    temp_i_cp_or_oriagari = 1;
                    temp_i_OAZ = i;
                }
            }

            if (OZi.ts2.naibu_hantei_ura(p) > 0) {
                if (((OZ_hyouji_mode == 2) || (OZ_hyouji_mode == 3)) || (OZ_hyouji_mode == 4)) {
                    temp_i_cp_or_oriagari = 2;
                    temp_i_OAZ = i;
                }
            }

            if (OZi.ts2.naibu_hantei_touka_omote(p) > 0) {
                if (OZ_hyouji_mode == 4) {
                    temp_i_cp_or_oriagari = 3;
                    temp_i_OAZ = i;
                }
            }

            if (OZi.ts2.naibu_hantei_touka_ura(p) > 0) {
                if (OZ_hyouji_mode == 4) {
                    temp_i_cp_or_oriagari = 4;
                    temp_i_OAZ = i;
                }
            }
        }
        i_cp_or_oriagari = temp_i_cp_or_oriagari;
//if(temp_i_OAZ!=0){set_i_OAZ(temp_i_OAZ);}
        set_i_OAZ(temp_i_OAZ);
    }

    // *******************************************************************************************cccccccccc
    void set_i_OAZ(int i) {//OZが?ﾘり替わるときの????
        System.out.println("i_OAZ = " + i_OAZ);
        i_OAZ = i;
        OZ = (Oriagari_Zu) OAZ.get(i_OAZ);
        if (OZ.i_toukazu_color == 0) {
            ckbox_toukazu_color.setSelected(false);//透過?}はカラ?[化しない?B
        } else if (OZ.i_toukazu_color == 1) {
            ckbox_toukazu_color.setSelected(true);//透過?}はカラ?[化?B
        }
    }
// ---------------------------------------


    int i_mouse_right_button_on = 0;//マウスの右ボタンがonなら１?Aoffなら0
    int i_mouse_undo_redo_mode = 0;//マウスでundo?Aredoするモ?[ドなら1


    int i_cp_or_oriagari = 0;//マウスホイ?[ルの対?ﾛがcp展開?}なら0?A?ﾜり?繧ｪり?}(表)なら1?A?ﾜり?繧ｪり?}(裏)なら2?A透過?}(表)なら3?A透過?}(裏)なら4


    //=============================================================================
    //マウスのホイ?[ルが回転した時に呼ばれる??ソッド
    //=============================================================================

    public void mouseWheelMoved(MouseWheelEvent e) {
        //System.out.println("mouseWheelMoved   " +e.getWheelRotation());
        if (ckbox_mouse_settei.isSelected()) {
//System.out.println("ホイ?[ル");
            //	ホイ?[ルでundo,redo
            if ((e.isShiftDown()) || (i_mouse_right_button_on == 1)) {
                i_mouse_undo_redo_mode = 1;
                es1.unselect_all();
                Button_kyoutuu_sagyou();
                es1.modosi_i_orisen_hojyosen();
                if (e.getWheelRotation() == -1) {

                    setTitle(es1.redo());
                    //Button_kyoutuu_sagyou();
                    repaint();
                } else {

                    setTitle(es1.undo());
                    //Button_kyoutuu_sagyou();
                    repaint();

                }

            }

            //	ホイ?[ルで拡大?k?ｬ
            if ((!e.isShiftDown()) && (i_mouse_right_button_on == 0)) {

                double bairitsu;

                // ---------------------------------------------------------------------hhhhhhhhh

                Ten p = new Ten(e2p(e));
                i_cp_or_oriagari_hantei(p);
//System.out.println("ホイ?[ルで拡大?k?ｬ?@i_cp_or_oriagari=?@" +i_cp_or_oriagari);
                if (i_cp_or_oriagari == 0) {
                    if (e.getWheelRotation() == -1) {
                        d_syukusyaku_keisuu = d_syukusyaku_keisuu * Math.sqrt(Math.sqrt(Math.sqrt(2.0)));//  sqrt(sqrt(2))=1.1892
                        camera_of_orisen_nyuuryokuzu.set_camera_bairitsu_x(d_syukusyaku_keisuu);
                        camera_of_orisen_nyuuryokuzu.set_camera_bairitsu_y(d_syukusyaku_keisuu);
                        text27.setText(String.valueOf(d_syukusyaku_keisuu));
                        text27.setCaretPosition(0);
                    } else {
                        d_syukusyaku_keisuu = d_syukusyaku_keisuu / Math.sqrt(Math.sqrt(Math.sqrt(2.0)));//  sqrt(sqrt(2))=1.1892
                        camera_of_orisen_nyuuryokuzu.set_camera_bairitsu_x(d_syukusyaku_keisuu);
                        camera_of_orisen_nyuuryokuzu.set_camera_bairitsu_y(d_syukusyaku_keisuu);
                        text27.setText(String.valueOf(d_syukusyaku_keisuu));
                        text27.setCaretPosition(0);
                    }


//for (int i=1;i<=OAZ.size()-1;i++){set_i_OAZ(i);}


                    // ---------------------------------------------------------------------
                } else {
                    if (e.getWheelRotation() == -1) {


                        OZ.d_oriagarizu_syukusyaku_keisuu = OZ.d_oriagarizu_syukusyaku_keisuu * Math.sqrt(Math.sqrt(Math.sqrt(2.0)));
                        OZ.camera_of_oriagarizu.set_camera_bairitsu_x(OZ.d_oriagarizu_syukusyaku_keisuu);
                        OZ.camera_of_oriagarizu.set_camera_bairitsu_y(OZ.d_oriagarizu_syukusyaku_keisuu);

                        OZ.camera_of_oriagari_omote.set_camera_bairitsu_x(OZ.d_oriagarizu_syukusyaku_keisuu);
                        OZ.camera_of_oriagari_omote.set_camera_bairitsu_y(OZ.d_oriagarizu_syukusyaku_keisuu);

                        OZ.camera_of_oriagari_ura.set_camera_bairitsu_x(OZ.d_oriagarizu_syukusyaku_keisuu);
                        OZ.camera_of_oriagari_ura.set_camera_bairitsu_y(OZ.d_oriagarizu_syukusyaku_keisuu);

                        OZ.camera_of_touka_omote.set_camera_bairitsu_x(OZ.d_oriagarizu_syukusyaku_keisuu);
                        OZ.camera_of_touka_omote.set_camera_bairitsu_y(OZ.d_oriagarizu_syukusyaku_keisuu);

                        OZ.camera_of_touka_ura.set_camera_bairitsu_x(OZ.d_oriagarizu_syukusyaku_keisuu);
                        OZ.camera_of_touka_ura.set_camera_bairitsu_y(OZ.d_oriagarizu_syukusyaku_keisuu);

                        text29.setText(String.valueOf(OZ.d_oriagarizu_syukusyaku_keisuu));
                        text29.setCaretPosition(0);


                    } else {

                        OZ.d_oriagarizu_syukusyaku_keisuu = OZ.d_oriagarizu_syukusyaku_keisuu / Math.sqrt(Math.sqrt(Math.sqrt(2.0)));
                        OZ.camera_of_oriagarizu.set_camera_bairitsu_x(OZ.d_oriagarizu_syukusyaku_keisuu);
                        OZ.camera_of_oriagarizu.set_camera_bairitsu_y(OZ.d_oriagarizu_syukusyaku_keisuu);

                        OZ.camera_of_oriagari_omote.set_camera_bairitsu_x(OZ.d_oriagarizu_syukusyaku_keisuu);
                        OZ.camera_of_oriagari_omote.set_camera_bairitsu_y(OZ.d_oriagarizu_syukusyaku_keisuu);

                        OZ.camera_of_oriagari_ura.set_camera_bairitsu_x(OZ.d_oriagarizu_syukusyaku_keisuu);
                        OZ.camera_of_oriagari_ura.set_camera_bairitsu_y(OZ.d_oriagarizu_syukusyaku_keisuu);

                        OZ.camera_of_touka_omote.set_camera_bairitsu_x(OZ.d_oriagarizu_syukusyaku_keisuu);
                        OZ.camera_of_touka_omote.set_camera_bairitsu_y(OZ.d_oriagarizu_syukusyaku_keisuu);

                        OZ.camera_of_touka_ura.set_camera_bairitsu_x(OZ.d_oriagarizu_syukusyaku_keisuu);
                        OZ.camera_of_touka_ura.set_camera_bairitsu_y(OZ.d_oriagarizu_syukusyaku_keisuu);

                        text29.setText(String.valueOf(OZ.d_oriagarizu_syukusyaku_keisuu));
                        text29.setCaretPosition(0);


                    }
                }
                // ---------------------------------------------------------------------

                mouse_object_iti(p_mouse_TV_iti);
                repaint();

            }

        }

    }


    //----------------------------------------------------------------------
    //マウス操??(移動やボタン操??)を?sう関??------------------------------
    //----------------------------------------------------------------------


    public Ten e2p(MouseEvent e) {

        double d_haba = 0.0;
        if (ckbox_ten_hanasi.isSelected()) {
            d_haba = camera_of_orisen_nyuuryokuzu.get_camera_bairitsu_x() * es1.get_d_hantei_haba();
        }
        return new Ten(e.getX() - (int) d_haba, e.getY() - (int) d_haba);
    }


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
// -------------13;15度入力モ?[ド?B


//101:?ﾜり?繧ｪり?}の操???B
//102;F_move
//103;S_face

//10001;test1 入力??備として点を３つ指定する


    // マウス操??(マウスが動いた時)を?sう関??----------------------------------------------------
    public void mouseMoved(MouseEvent e) {
        //何もしない
        //  final Point mouseLocation = MouseInfo.getPointerInfo().getLocation();//これは多分J2SE 5.0?uTiger?v以?~で??動するコ?[ド

        Ten p = new Ten(e2p(e));
        mouse_object_iti(p);
        if (i_mouse_modeA == 0) {
        } else if (i_mouse_modeA == 1) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_01(p);
        }   //1 ??分入力モ?[ド?iフリ?[?j
        //else if(i_mouse_modeA==2)  {		}						       //2 展開?}移動?B
        //else if(i_mouse_modeA==3)  { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_03(p);}//??分???怎??[ド?B
        //else if(i_mouse_modeA==4)  { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_04(p);}//senbun_henkan ???ﾔ?ﾂ
        else if (i_mouse_modeA == 5) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_05(p);
        }//??分延長モ?[ド?B
        //else if(i_mouse_modeA==6)  { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_06(p);}//2点から等距離??分モ?[ド?B
        else if (i_mouse_modeA == 7) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_07(p);
        }//角二等分??モ?[ド?B
        else if (i_mouse_modeA == 8) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_08(p);
        }//内?Sモ?[ド?B
        else if (i_mouse_modeA == 9) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_09(p);
        }//????おろしモ?[ド?B
        else if (i_mouse_modeA == 10) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_10(p);
        }//?ﾜり返しモ?[ド?B
        else if (i_mouse_modeA == 11) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_11(p);
        }//??分入力モ?[ド?B(?ｧ限)
        else if (i_mouse_modeA == 12) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_12(p);
        }//鏡映モ?[ド?B
        //else if(i_mouse_modeA==13) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_13(p);}//角度系モ?[ド?i１番目?j?B//??分指定?A交点まで
        //else if(i_mouse_modeA==14) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_14(p);}//点追加モ?[ド?B
        //else if(i_mouse_modeA==15) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_15(p);}//点???怎??[ド?B
        else if (i_mouse_modeA == 16) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_16(p);
        }//角度系モ?[ド?i４番目?j?B2点指定し?A??分まで
        else if (i_mouse_modeA == 17) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_17(p);
        }//角度系モ?[ド?i２番目?j?B//2点指定?A交点まで
        else if (i_mouse_modeA == 18) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_18(p);
        }//角度系モ?[ド?i５番目?j?B2点指定?A自由末端
        //else if(i_mouse_modeA==19) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_19(p);}//select?@に使う
        //else if(i_mouse_modeA==20) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_20(p);}//unselect?@に使う
        else if (i_mouse_modeA == 21) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_21(p);
        }//move?@に使う
        else if (i_mouse_modeA == 22) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_22(p);
        }//copy_paste?@に使う
        //else if(i_mouse_modeA==23) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_23(p);}//--->M?@に使う
        //else if(i_mouse_modeA==24) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_24(p);}//--->V?@に使う
        //else if(i_mouse_modeA==25) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_25(p);}//--->E?@に使う
        //else if(i_mouse_modeA==26) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_26(p);}//背景セット?@に使う
        else if (i_mouse_modeA == 27) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_27(p);
        }//??分分割入力?@に使う
        else if (i_mouse_modeA == 28) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_28(p);
        }//??分内分入力?@に使う
        else if (i_mouse_modeA == 29) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_29(p);
        }//?ｳ多角形入力?@に使う
        //else if(i_mouse_modeA==30) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_30(p);}//?怩ｯ_??変換?@に使う
        else if (i_mouse_modeA == 31) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_31(p);
        }//move 2p2p?@に使う
        else if (i_mouse_modeA == 32) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_32(p);
        }//copy 2p2p?@?@に使う
        else if (i_mouse_modeA == 33) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_33(p);
        }//魚の???@に使う
        else if (i_mouse_modeA == 34) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_34(p);
        }//??備としてだけ使う??分に?d複している?ﾜ??を?№ﾉ山谷にするの?@に使う
        else if (i_mouse_modeA == 35) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_35(p);
        }//複?ﾜり返し?@入力した??分に?ﾚ?Gしている?ﾜ??を?ﾜり返し?@に使う
        else if (i_mouse_modeA == 36) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_36(p);
        }//??備としてだけ使う??分にX交?ｷしている?ﾜ??を?№ﾉ山谷にするの?@に使う
        else if (i_mouse_modeA == 37) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_37(p);
        }//角度系モ?[ド?i３番目?j?B角度規格化??分入力モ?[ド?B角度規格化?ﾜ??入力?@に使う
        else if (i_mouse_modeA == 38) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_38(p);
        }//?ﾜり?ﾝ可能??追加
        else if (i_mouse_modeA == 39) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_39(p);
        }//?ﾜり?ﾝ可能??+格子点系入力
        else if (i_mouse_modeA == 40) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_40(p);
        }//平?s??入力
        //else if(i_mouse_modeA==41) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_41(p);}//点?????i??カラ?[チェンジ?j?@に使う
        //else if(i_mouse_modeA==42) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_42(p);}//円入力?@に使う
        //else if(i_mouse_modeA==43) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_43(p);}//円の3点入力?@に使う
        //else if(i_mouse_modeA==44) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_44(p);}//円?@分離入力?@に使う
        //else if(i_mouse_modeA==45) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_45(p);}//2円の?ﾚ???@に使う
        //else if(i_mouse_modeA==46) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_46(p);}//反転?@に使う
        //else if(i_mouse_modeA==47) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_47(p);}//円入力モ?[ド?B(フリ?[)
        //else if(i_mouse_modeA==48) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_48(p);}//円?@同?S円追加モ?[ド?B(元円の円周と同?S円の円周との??は??分で指定する)
        //else if(i_mouse_modeA==49) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_49(p);}//円?@同?S円追加モ?[ド?B(元円の円周と同?S円の円周との??は他の同?S円の組で指定する)
        //else if(i_mouse_modeA==50) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_50(p);}//2円を指定し?Aそれぞれの円に同?S円を加える?Bそれぞれの同?S円の組にできる帯領域の??が等しくなるようにして?A加えられた同?S円同士が?ﾚするようにする?B
        //else if(i_mouse_modeA==51) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_51(p);}//平?s???@??指定入力モ?[ド?B
        else if (i_mouse_modeA == 52) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_52(p);
        }//連続?ﾜり返しモ?[ド?@に使う
        else if (i_mouse_modeA == 53) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_53(p);
        }//長さ測定１?@に使う
        else if (i_mouse_modeA == 54) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_54(p);
        }//長さ測定２?@に使う
        else if (i_mouse_modeA == 55) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_55(p);
        }//角度測定１?@に使う
        else if (i_mouse_modeA == 56) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_56(p);
        }//角度測定２?@に使う
        else if (i_mouse_modeA == 57) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_57(p);
        }//角度測定３?@に使う
        //else if(i_mouse_modeA==58) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_58(p);}//senbun_henkan ?ﾔ?ﾂ
        //else if(i_mouse_modeA==59) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_59(p);}//特??プ??パティ指定
        //else if(i_mouse_modeA==60) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_60(p);}//--->HK?@に使う//HKとは補?賦???のこと

        else if (i_mouse_modeA == 61) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_61(p);
        }//長方形内選択?ipaintの選択に似せた選択機能?jに使う
        else if (i_mouse_modeA == 62) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_62(p);
        }//ボ??ノイ?}?@に使う
        //else if(i_mouse_modeA==63) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_63(p);}//unselect?@に使う
        //else if(i_mouse_modeA==64) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_64(p);}//unselect?@に使う
        //else if(i_mouse_modeA==65) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_65(p);}//unselect?@に使う
        //else if(i_mouse_modeA==66) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_66(p);}//unselect?@に使う
        //else if(i_mouse_modeA==67) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_67(p);}//unselect?@に使う
        //else if(i_mouse_modeA==68) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_68(p);}//unselect?@に使う
        //else if(i_mouse_modeA==69) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_69(p);}//unselect?@に使う
        //else if(i_mouse_modeA==70) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_70(p);}//unselect?@に使う


        //else if(i_mouse_modeA==10001)  { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_10001(p);}
        //else if(i_mouse_modeA==10002)  { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_10002(p);}

        //else if(i_mouse_modeA==101){		}	//?ﾜり?繧ｪり?}操??
        //else if(i_mouse_modeA==102){		}	//?ﾜり?繧ｪり?}移動

        //else if(i_mouse_modeA==103){		}//基??面指定
        //else if(i_mouse_modeA==7){;}
        //else if(i_mouse_modeA==8){;}
        else {
        }

        repaint();
    }


    int btn = 0;//?ｶ右中央のどのボタンが押されたか格納?B?@1=
    int i_ClickCount = 0;//この変?狽｢らないのでは?H21181208


    //マウス操??(ボタンを押したとき)を?sう関??----------------------------------------------------
    public void mousePressed(MouseEvent e) {

        //Ten p =new Ten(e.getX(),e.getY());
        Ten p = new Ten(e2p(e));


//wwwwwwwwwwww
        //PointerInfo pointerInfo = MouseInfo.getPointerInfo();
        //MouseInfo.getPointerInfo();

        i_mouseDragged_yuukou = 1;
        i_mouseReleased_yuukou = 1;


        if (ckbox_mouse_settei.isSelected()) {
            btn = e.getButton();
            i_ClickCount = e.getClickCount();

            //---------ボタンの種類による動??変?X-----------------------------------------


            if (btn == MouseEvent.BUTTON1) {
                //System.out.println("?ｶボタンクリック");
                //System.out.println("?ｶボタンクリック");


            } else if (btn == MouseEvent.BUTTON2) {
                System.out.println("中ボタンクリック");

                i_cp_or_oriagari_hantei(p);

                System.out.println("i_cp_or_oriagari = " + i_cp_or_oriagari);

                if (i_cp_or_oriagari == 0) {// 展開?}移動?B

                    //i_cp_or_oriagari=0;
                    camera_of_orisen_nyuuryokuzu.camera_ichi_sitei_from_TV(p);


                } else if (i_cp_or_oriagari == 1) {
                    OZ.camera_of_oriagari_omote.camera_ichi_sitei_from_TV(p);
                } else if (i_cp_or_oriagari == 2) {
                    OZ.camera_of_oriagari_ura.camera_ichi_sitei_from_TV(p);
                } else if (i_cp_or_oriagari == 3) {
                    OZ.camera_of_touka_omote.camera_ichi_sitei_from_TV(p);
                } else if (i_cp_or_oriagari == 4) {
                    OZ.camera_of_touka_ura.camera_ichi_sitei_from_TV(p);

                }


                mouse_temp0.set(p);
                repaint();
                return;

            } else if (btn == MouseEvent.BUTTON3) {//右ボタンクリック
                //System.out.println("右ボタンクリック");
                if (i_mouse_modeA == 62) {//ボ??ノイ?}入力時は?A入力途中のボ??ノイ母点が?ﾁえないように?A右クリックに反応させない?B20181208
                } else {
                    i_mouse_right_button_on = 1;

                    //??分???怎??[ド?B
                    es1.setCamera(camera_of_orisen_nyuuryokuzu);
                    es1.mPressed_A_03(p);

                    i_orisen_hojyosen = 4;//=0は?ﾜ??入力?@=1は補????入力モ?[ド?A４は両方に??用
                    es1.set_i_orisen_hojyosen(i_orisen_hojyosen);

                }
                repaint();

                return;
            }
            //-----------------------------System.out.println("a");----------------------
        }


        if (i_mouse_modeA == 0) {
        } else if (i_mouse_modeA == 1) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_01(p);
        }   //1 ??分入力モ?[ド?iフリ?[?j
        else if (i_mouse_modeA == 2) {                                       //2 展開?}移動?B
            camera_of_orisen_nyuuryokuzu.camera_ichi_sitei_from_TV(p);
            mouse_temp0.set(p);
        } else if (i_mouse_modeA == 3) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_03(p);
        }//??分???怎??[ド?B
        else if (i_mouse_modeA == 4) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_04(p);
        }//senbun_henkan ???ﾔ?ﾂ
        else if (i_mouse_modeA == 5) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_05(p);
        }//??分延長モ?[ド?B
        else if (i_mouse_modeA == 6) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_06(p);
        }//2点から等距離??分モ?[ド?B
        else if (i_mouse_modeA == 7) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_07(p);
        }//角二等分??モ?[ド?B
        else if (i_mouse_modeA == 8) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_08(p);
        }//内?Sモ?[ド?B
        else if (i_mouse_modeA == 9) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_09(p);
        }//????おろしモ?[ド?B
        else if (i_mouse_modeA == 10) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_10(p);
        }//?ﾜり返しモ?[ド?B
        else if (i_mouse_modeA == 11) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_11(p);
        }//??分入力モ?[ド?B(?ｧ限)
        else if (i_mouse_modeA == 12) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_12(p);
        }//鏡映モ?[ド?B
        else if (i_mouse_modeA == 13) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_13(p);
        }//角度系モ?[ド?i１番目?j?B//??分指定?A交点まで
        else if (i_mouse_modeA == 14) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_14(p);
        }//点追加モ?[ド?B
        else if (i_mouse_modeA == 15) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_15(p);
        }//点???怎??[ド?B
        else if (i_mouse_modeA == 16) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_16(p);
        }//角度系モ?[ド?i４番目?j?B2点指定し?A??分まで
        else if (i_mouse_modeA == 17) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_17(p);
        }//角度系モ?[ド?i２番目?j?B//2点指定?A交点まで
        else if (i_mouse_modeA == 18) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_18(p);
        }//角度系モ?[ド?i５番目?j?B2点指定?A自由末端
        else if (i_mouse_modeA == 19) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_19(p);
        }//select?@に使う
        else if (i_mouse_modeA == 20) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_20(p);
        }//unselect?@に使う
        else if (i_mouse_modeA == 21) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_21(p);
        }//move?@に使う
        else if (i_mouse_modeA == 22) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_22(p);
        }//copy_paste?@に使う
        else if (i_mouse_modeA == 23) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_23(p);
        }//--->M?@に使う
        else if (i_mouse_modeA == 24) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_24(p);
        }//--->V?@に使う
        else if (i_mouse_modeA == 25) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_25(p);
        }//--->E?@に使う
        else if (i_mouse_modeA == 26) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_26(p);
        }//背景セット?@に使う
        else if (i_mouse_modeA == 27) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_27(p);
        }//??分分割入力?@に使う
        else if (i_mouse_modeA == 28) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_28(p);
        }//??分内分入力?@に使う
        else if (i_mouse_modeA == 29) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_29(p);
        }//?ｳ多角形入力?@に使う
        else if (i_mouse_modeA == 30) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_30(p);
        }//?怩ｯ_??変換?@に使う
        else if (i_mouse_modeA == 31) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_31(p);
        }//move 2p2p?@に使う
        else if (i_mouse_modeA == 32) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_32(p);
        }//copy 2p2p?@?@に使う
        else if (i_mouse_modeA == 33) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_33(p);
        }//魚の???@に使う
        else if (i_mouse_modeA == 34) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_34(p);
        }//??備としてだけ使う??分に?d複している?ﾜ??を?№ﾉ山谷にするの?@に使う
        else if (i_mouse_modeA == 35) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_35(p);
        }//複?ﾜり返し?@入力した??分に?ﾚ?Gしている?ﾜ??を?ﾜり返し?@に使う
        else if (i_mouse_modeA == 36) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_36(p);
        }//??備としてだけ使う??分にX交?ｷしている?ﾜ??を?№ﾉ山谷にするの?@に使う
        else if (i_mouse_modeA == 37) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_37(p);
        }//角度系モ?[ド?i３番目?j?B角度規格化??分入力モ?[ド?B角度規格化?ﾜ??入力?@に使う
        else if (i_mouse_modeA == 38) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_38(p);
        }//?ﾜり?ﾝ可能??追加
        else if (i_mouse_modeA == 39) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_39(p);
        }//?ﾜり?ﾝ可能??+格子点系入力
        else if (i_mouse_modeA == 40) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_40(p);
        }//平?s??入力
        else if (i_mouse_modeA == 41) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_41(p);
        }//点?????i??カラ?[チェンジ?j?@に使う
        else if (i_mouse_modeA == 42) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_42(p);
        }//円入力?@に使う
        else if (i_mouse_modeA == 43) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_43(p);
        }//円の3点入力?@に使う
        else if (i_mouse_modeA == 44) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_44(p);
        }//円?@分離入力?@に使う
        else if (i_mouse_modeA == 45) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_45(p);
        }//2円の?ﾚ???@に使う
        else if (i_mouse_modeA == 46) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_46(p);
        }//反転?@に使う
        else if (i_mouse_modeA == 47) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_47(p);
        }//円入力モ?[ド?B(フリ?[)
        else if (i_mouse_modeA == 48) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_48(p);
        }//円?@同?S円追加モ?[ド?B(元円の円周と同?S円の円周との??は??分で指定する)
        else if (i_mouse_modeA == 49) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_49(p);
        }//円?@同?S円追加モ?[ド?B(元円の円周と同?S円の円周との??は他の同?S円の組で指定する)
        else if (i_mouse_modeA == 50) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_50(p);
        }//2円を指定し?Aそれぞれの円に同?S円を加える?Bそれぞれの同?S円の組にできる帯領域の??が等しくなるようにして?A加えられた同?S円同士が?ﾚするようにする?B
        else if (i_mouse_modeA == 51) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_51(p);
        }//平?s???@??指定入力モ?[ド?B
        else if (i_mouse_modeA == 52) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_52(p);
        }//連続?ﾜり返しモ?[ドに使う
        else if (i_mouse_modeA == 53) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_53(p);
        }//長さ測定１?@に使う
        else if (i_mouse_modeA == 54) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_54(p);
        }//長さ測定２?@に使う
        else if (i_mouse_modeA == 55) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_55(p);
        }//角度測定１?@に使う
        else if (i_mouse_modeA == 56) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_56(p);
        }//角度測定２?@に使う
        else if (i_mouse_modeA == 57) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_57(p);
        }//角度測定３?@に使う
        else if (i_mouse_modeA == 58) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_58(p);
        }//senbun_henkan ?ﾔ?ﾂ
        else if (i_mouse_modeA == 59) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_59(p);
        }//特??プ??パティ指定
        else if (i_mouse_modeA == 60) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_60(p);
        }//--->HK?@に使う//HKとは補?賦???のこと

        else if (i_mouse_modeA == 61) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_61(p);
        }//長方形内選択?ipaintの選択に似せた選択機能?jに使う
        else if (i_mouse_modeA == 62) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_62(p);
        }//ボ??ノイ?}?@に使う
        //else if(i_mouse_modeA==63) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mPressed_A_63(p);}//unselect?@に使う
        //else if(i_mouse_modeA==64) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mPressed_A_64(p);}//unselect?@に使う
        //else if(i_mouse_modeA==65) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mPressed_A_65(p);}//unselect?@に使う
        //else if(i_mouse_modeA==66) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mPressed_A_66(p);}//unselect?@に使う
        //else if(i_mouse_modeA==67) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mPressed_A_67(p);}//unselect?@に使う
        //else if(i_mouse_modeA==68) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mPressed_A_68(p);}//unselect?@に使う
        //else if(i_mouse_modeA==69) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mPressed_A_69(p);}//unselect?@に使う
        //else if(i_mouse_modeA==70) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mPressed_A_70(p);}//unselect?@に使う


        else if (i_mouse_modeA == 10001) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_10001(p);
        } else if (i_mouse_modeA == 10002) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_10002(p);
        } else if (i_mouse_modeA == 101) {        //?ﾜり?繧ｪり?}操??
            OZ.oriagari_sousa_mouse_on(p);
        } else if (i_mouse_modeA == 102) {//?ﾜり?繧ｪり?}移動
            OZ.camera_of_oriagarizu.camera_ichi_sitei_from_TV(p);
            OZ.camera_of_oriagari_omote.camera_ichi_sitei_from_TV(p);
            OZ.camera_of_oriagari_ura.camera_ichi_sitei_from_TV(p);

            OZ.camera_of_touka_omote.camera_ichi_sitei_from_TV(p);
            OZ.camera_of_touka_ura.camera_ichi_sitei_from_TV(p);

            mouse_temp0.set(p);
        } else if (i_mouse_modeA == 103) {
            //ts1.set_kijyunmen_id(p);
        }//基??面指定
        else if (i_mouse_modeA == 7) {
        } else if (i_mouse_modeA == 8) {
        } else {
        }

        repaint();
    }

    //マウス操??(ドラッグしたとき)を?sう関??---------- System.out.println("A");------------------------------------------
    public void mouseDragged(MouseEvent e) {

        if (i_mouseDragged_yuukou == 1) {

            //Ten p =new Ten(e.getX(),e.getY());
            Ten p = new Ten(e2p(e));
            mouse_object_iti(p);

            if (ckbox_mouse_settei.isSelected()) {
                //---------ボタンの種類による動??変?X-----------------------------------------
                if (btn == MouseEvent.BUTTON1) {


                } else if (btn == MouseEvent.BUTTON2) {
                    //System.out.println("中ボタンクリック");
                    //if(ts2.naibu_hantei(p)==0){
                    //i_cp_or_oriagari=0;
                    //if(ts2.naibu_hantei_ura(p)>0){i_cp_or_oriagari=2;}
                    //if(ts2.naibu_hantei_omote(p)>0){i_cp_or_oriagari=1;}


                    if (i_cp_or_oriagari == 0) {// 展開?}移動?B
                        camera_of_orisen_nyuuryokuzu.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));
                        es1.setCamera(camera_of_orisen_nyuuryokuzu);
                    } else if (i_cp_or_oriagari == 1) {
                        OZ.camera_of_oriagari_omote.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));
                    } else if (i_cp_or_oriagari == 2) {
                        OZ.camera_of_oriagari_ura.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));
                    } else if (i_cp_or_oriagari == 3) {
                        OZ.camera_of_touka_omote.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));
                    } else if (i_cp_or_oriagari == 4) {
                        OZ.camera_of_touka_ura.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));
                    }

                    mouse_temp0.set(p);
                    repaint();
                    return;

                } else if (btn == MouseEvent.BUTTON3) {
                    //System.out.println("右ボタンクリック");
                    if (i_mouse_modeA == 62) {//ボ??ノイ?}入力時は?A入力途中のボ??ノイ母点が?ﾁえないように?A右クリックに反応させない?B20181208
                    } else {
                        if (i_mouse_undo_redo_mode == 1) {
                            return;
                        }//undo,redoモ?[ド?B
                        es1.setCamera(camera_of_orisen_nyuuryokuzu);
                        es1.mDragged_A_03(p);//??分???怎??[ド?B
                    }
                    repaint();
                    return;
                }
                //-----------------------------System.out.println("a");----------------------
            }


            if (i_mouse_modeA == 0) {
            } else if (i_mouse_modeA == 1) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_01(p);
            } else if (i_mouse_modeA == 2) {
                camera_of_orisen_nyuuryokuzu.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));
                es1.setCamera(camera_of_orisen_nyuuryokuzu);


//20180225追加
                Oriagari_Zu OZi;
                for (int i_oz = 1; i_oz <= OAZ.size() - 1; i_oz++) {
                    OZi = (Oriagari_Zu) OAZ.get(i_oz);

                    //Ten t_o2tv =new Ten();
                    //t_o2tv =camera_of_orisen_nyuuryokuzu.object2TV(camera_of_orisen_nyuuryokuzu.get_camera_ichi());

//OZi.d_oriagarizu_syukusyaku_keisuu=OZi.d_oriagarizu_syukusyaku_keisuu*d_bairitu;


                    OZi.camera_of_oriagarizu.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));
                    //OZi.camera_of_oriagarizu.kakezan_camera_bairitsu_x(d_bairitu);
                    //OZi.camera_of_oriagarizu.kakezan_camera_bairitsu_y(d_bairitu);

                    OZi.camera_of_oriagari_omote.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));
                    //OZi.camera_of_oriagari_omote.kakezan_camera_bairitsu_x(d_bairitu);
                    //OZi.camera_of_oriagari_omote.kakezan_camera_bairitsu_y(d_bairitu);

                    OZi.camera_of_oriagari_ura.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));
                    //OZi.camera_of_oriagari_ura.kakezan_camera_bairitsu_x(d_bairitu);
                    //OZi.camera_of_oriagari_ura.kakezan_camera_bairitsu_y(d_bairitu);

                    OZi.camera_of_touka_omote.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));
                    //OZi.camera_of_touka_omote.kakezan_camera_bairitsu_x(d_bairitu);
                    //OZi.camera_of_touka_omote.kakezan_camera_bairitsu_y(d_bairitu);

                    OZi.camera_of_touka_ura.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));
                    //OZi.camera_of_touka_ura.kakezan_camera_bairitsu_x(d_bairitu);
                    //OZi.camera_of_touka_ura.kakezan_camera_bairitsu_y(d_bairitu);

                    //text29.setText(String.valueOf(OZ.d_oriagarizu_syukusyaku_keisuu));
                    //text29.setCaretPosition(0);
                }
//20180225追加?@ここまで


                mouse_temp0.set(p);


            } else if (i_mouse_modeA == 3) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_03(p);
            } else if (i_mouse_modeA == 4) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_04(p);
            } else if (i_mouse_modeA == 5) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_05(p);
            } else if (i_mouse_modeA == 6) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_06(p);
            } else if (i_mouse_modeA == 7) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_07(p);
            } else if (i_mouse_modeA == 8) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_08(p);
            } else if (i_mouse_modeA == 9) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_09(p);
            } else if (i_mouse_modeA == 10) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_10(p);
            } else if (i_mouse_modeA == 11) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_11(p);
            } else if (i_mouse_modeA == 12) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_12(p);
            } else if (i_mouse_modeA == 13) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_13(p);
            } else if (i_mouse_modeA == 14) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_14(p);
            } else if (i_mouse_modeA == 15) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_15(p);
            } else if (i_mouse_modeA == 16) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_16(p);
            } else if (i_mouse_modeA == 17) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_17(p);
            } else if (i_mouse_modeA == 18) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_18(p);
            } else if (i_mouse_modeA == 19) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_19(p);
            } else if (i_mouse_modeA == 20) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_20(p);
            } else if (i_mouse_modeA == 21) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_21(p);
            } else if (i_mouse_modeA == 22) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_22(p);
            } else if (i_mouse_modeA == 23) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_23(p);
            } else if (i_mouse_modeA == 24) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_24(p);
            } else if (i_mouse_modeA == 25) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_25(p);
            } else if (i_mouse_modeA == 26) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_26(p);
            } else if (i_mouse_modeA == 27) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_27(p);
            } else if (i_mouse_modeA == 28) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_28(p);
            } else if (i_mouse_modeA == 29) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_29(p);
            } else if (i_mouse_modeA == 30) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_30(p);
            } else if (i_mouse_modeA == 31) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_31(p);
            } else if (i_mouse_modeA == 32) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_32(p);
            } else if (i_mouse_modeA == 33) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_33(p);
            } else if (i_mouse_modeA == 34) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_34(p);
            } else if (i_mouse_modeA == 35) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_35(p);
            } else if (i_mouse_modeA == 36) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_36(p);
            } else if (i_mouse_modeA == 37) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_37(p);
            } else if (i_mouse_modeA == 38) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_38(p);
            } else if (i_mouse_modeA == 39) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_39(p);
            } else if (i_mouse_modeA == 40) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_40(p);
            } else if (i_mouse_modeA == 41) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_41(p);
            } else if (i_mouse_modeA == 42) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_42(p);
            } else if (i_mouse_modeA == 43) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_43(p);
            } else if (i_mouse_modeA == 44) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_44(p);
            } else if (i_mouse_modeA == 45) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_45(p);
            } else if (i_mouse_modeA == 46) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_46(p);
            } else if (i_mouse_modeA == 47) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_47(p);
            } else if (i_mouse_modeA == 48) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_48(p);
            } else if (i_mouse_modeA == 49) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_49(p);
            } else if (i_mouse_modeA == 50) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_50(p);
            } else if (i_mouse_modeA == 51) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_51(p);
            } else if (i_mouse_modeA == 52) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_52(p);
            } else if (i_mouse_modeA == 53) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_53(p);
            } else if (i_mouse_modeA == 54) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_54(p);
            } else if (i_mouse_modeA == 55) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_55(p);
            } else if (i_mouse_modeA == 56) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_56(p);
            } else if (i_mouse_modeA == 57) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_57(p);
            } else if (i_mouse_modeA == 58) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_58(p);
            }//senbun_henkan ?ﾔ?ﾂ
            else if (i_mouse_modeA == 59) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_59(p);
            } else if (i_mouse_modeA == 60) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_60(p);
            } else if (i_mouse_modeA == 61) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_61(p);
            }//長方形内選択?ipaintの選択に似せた選択機能?jに使う
            else if (i_mouse_modeA == 62) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_62(p);
            }//ボ??ノイ?}?@に使う
            //else if(i_mouse_modeA==63) {es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mDragged_A_63(p);}
            //else if(i_mouse_modeA==64) {es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mDragged_A_64(p);}
            //else if(i_mouse_modeA==65) {es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mDragged_A_65(p);}
            //else if(i_mouse_modeA==66) {es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mDragged_A_66(p);}
            //else if(i_mouse_modeA==67) {es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mDragged_A_67(p);}
            //else if(i_mouse_modeA==68) {es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mDragged_A_68(p);}
            //else if(i_mouse_modeA==69) {es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mDragged_A_69(p);}
            //else if(i_mouse_modeA==70) {es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mDragged_A_70(p);}


            else if (i_mouse_modeA == 10001) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_10001(p);
            } else if (i_mouse_modeA == 10002) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_10002(p);
            } else if (i_mouse_modeA == 101) {
                OZ.oriagari_sousa_mouse_drag(p);
            }    //?ﾜり?繧ｪり?}操??
            else if (i_mouse_modeA == 102) {
                OZ.camera_of_oriagarizu.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));
                OZ.camera_of_oriagari_omote.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));
                OZ.camera_of_oriagari_ura.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));

                OZ.camera_of_touka_omote.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));
                OZ.camera_of_touka_ura.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));

                mouse_temp0.set(p);//mouse_temp0は一時的に使うTen?Amouse_temp0.tano_Ten_iti(p)はmouse_temp0から見たpの位置

            } else if (i_mouse_modeA == 103) {
            }//基??面指定
            else if (i_mouse_modeA == 7) {
            } else if (i_mouse_modeA == 8) {
            } else {
            }

            repaint();
        }
    }

    //マウス操??(ボタンを離したとき)を?sう関??----------------------------------------------------
    public void mouseReleased(MouseEvent e) {
        if (i_mouseReleased_yuukou == 1) {
            //Ten p =new Ten(e.getX(),e.getY());
            Ten p = new Ten(e2p(e));


            if (ckbox_mouse_settei.isSelected()) {
                //---------ボタンの種類による動??変?X-----------------------------------------
                if (btn == MouseEvent.BUTTON1) {
                    //

                } else if (btn == MouseEvent.BUTTON2) {
                    //System.out.println("中ボタンクリック");
                    //if(ts2.naibu_hantei(p)==0){
                    if (i_cp_or_oriagari == 0) {

                        camera_of_orisen_nyuuryokuzu.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));
                        es1.setCamera(camera_of_orisen_nyuuryokuzu);
                    } else if (i_cp_or_oriagari == 1) {
                        OZ.camera_of_oriagari_omote.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));
                    } else if (i_cp_or_oriagari == 2) {
                        OZ.camera_of_oriagari_ura.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));

                    } else if (i_cp_or_oriagari == 3) {
                        OZ.camera_of_touka_omote.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));
                    } else if (i_cp_or_oriagari == 4) {
                        OZ.camera_of_touka_ura.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));
                    }

                    mouse_temp0.set(p);
                    repaint();
                    i_mouseDragged_yuukou = 0;
                    i_mouseReleased_yuukou = 0;
                    return;//

                } else if (btn == MouseEvent.BUTTON3) {
                    //System.out.println("右ボタンクリック");
                    if (i_mouse_modeA == 62) {
                        repaint();//ボ??ノイ?}入力時は?A入力途中のボ??ノイ母点が?ﾁえないように?A右クリックに反応させない?B20181208
                    } else {

                        i_mouse_right_button_on = 0;

                        //if(i_mouse_undo_redo_mode==1){i_mouse_undo_redo_mode=0;es1.unselect_all();Button_kyoutuu_sagyou();es1.modosi_i_orisen_hojyosen();return;}
                        if (i_mouse_undo_redo_mode == 1) {
                            i_mouse_undo_redo_mode = 0;
                            return;
                        } //undo,redoモ?[ド?B
                        es1.setCamera(camera_of_orisen_nyuuryokuzu);
                        es1.mReleased_A_03(p);
                        repaint();//なんでここにrepaintがあるか検討した方がよいかも?B20181208
                        es1.modosi_i_orisen_hojyosen();
                        i_mouseDragged_yuukou = 0;
                        i_mouseReleased_yuukou = 0;
                        //??分???怎??[ド?B
                    }
                    return;
                }
                //----------------------------System.out.println("a");-----------------------
            }


            if (i_mouse_modeA == 0) {
            } else if (i_mouse_modeA == 1) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_01(p);
            } else if (i_mouse_modeA == 2) {
                camera_of_orisen_nyuuryokuzu.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));
                es1.setCamera(camera_of_orisen_nyuuryokuzu);


//20180225追加
                Oriagari_Zu OZi;
                for (int i_oz = 1; i_oz <= OAZ.size() - 1; i_oz++) {
                    OZi = (Oriagari_Zu) OAZ.get(i_oz);

                    //Ten t_o2tv =new Ten();
                    //t_o2tv =camera_of_orisen_nyuuryokuzu.object2TV(camera_of_orisen_nyuuryokuzu.get_camera_ichi());

//OZi.d_oriagarizu_syukusyaku_keisuu=OZi.d_oriagarizu_syukusyaku_keisuu*d_bairitu;


                    OZi.camera_of_oriagarizu.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));
                    //OZi.camera_of_oriagarizu.kakezan_camera_bairitsu_x(d_bairitu);
                    //OZi.camera_of_oriagarizu.kakezan_camera_bairitsu_y(d_bairitu);

                    OZi.camera_of_oriagari_omote.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));
                    //OZi.camera_of_oriagari_omote.kakezan_camera_bairitsu_x(d_bairitu);
                    //OZi.camera_of_oriagari_omote.kakezan_camera_bairitsu_y(d_bairitu);

                    OZi.camera_of_oriagari_ura.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));
                    //OZi.camera_of_oriagari_ura.kakezan_camera_bairitsu_x(d_bairitu);
                    //OZi.camera_of_oriagari_ura.kakezan_camera_bairitsu_y(d_bairitu);

                    OZi.camera_of_touka_omote.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));
                    //OZi.camera_of_touka_omote.kakezan_camera_bairitsu_x(d_bairitu);
                    //OZi.camera_of_touka_omote.kakezan_camera_bairitsu_y(d_bairitu);

                    OZi.camera_of_touka_ura.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));
                    //OZi.camera_of_touka_ura.kakezan_camera_bairitsu_x(d_bairitu);
                    //OZi.camera_of_touka_ura.kakezan_camera_bairitsu_y(d_bairitu);

                    //text29.setText(String.valueOf(OZ.d_oriagarizu_syukusyaku_keisuu));
                    //text29.setCaretPosition(0);
                }
//20180225追加?@ここまで


                mouse_temp0.set(p);


            } else if (i_mouse_modeA == 3) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_03(p);
            } else if (i_mouse_modeA == 4) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_04(p);
            } else if (i_mouse_modeA == 5) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_05(p);
            } else if (i_mouse_modeA == 6) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_06(p);
            } else if (i_mouse_modeA == 7) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_07(p);
            } else if (i_mouse_modeA == 8) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_08(p);
            } else if (i_mouse_modeA == 9) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_09(p);
            } else if (i_mouse_modeA == 10) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_10(p);
            } else if (i_mouse_modeA == 11) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_11(p);
            } else if (i_mouse_modeA == 12) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_12(p);
            } else if (i_mouse_modeA == 13) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_13(p);
            } else if (i_mouse_modeA == 14) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_14(p);
            } else if (i_mouse_modeA == 15) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_15(p);
            } else if (i_mouse_modeA == 16) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_16(p);
            } else if (i_mouse_modeA == 17) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_17(p);
            } else if (i_mouse_modeA == 18) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_18(p);
            } else if (i_mouse_modeA == 19) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_19(p);
            } else if (i_mouse_modeA == 20) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_20(p);
            } else if (i_mouse_modeA == 21) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_21(p);
            } else if (i_mouse_modeA == 22) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_22(p);
            } else if (i_mouse_modeA == 23) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_23(p);
            } else if (i_mouse_modeA == 24) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_24(p);
            } else if (i_mouse_modeA == 25) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_25(p);
            } else if (i_mouse_modeA == 26) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);

                if (es1.mReleased_A_26(p) == 4) {
                    //i_Lock_on_ori=1;
                    Button_kyoutuu_sagyou();
                    //System.out.println("i_mouse_modeA==4");
                    Senbun s_1 = new Senbun();
                    s_1.set(es1.get_s_step(1));
                    Senbun s_2 = new Senbun();
                    s_2.set(es1.get_s_step(2));
                    Senbun s_3 = new Senbun();
                    s_3.set(es1.get_s_step(3));
                    Senbun s_4 = new Senbun();
                    s_4.set(es1.get_s_step(4));

                    //int i_Lock_on_old=i_Lock_on;
                    i_Lock_on = 0;
                    Button_haikei_Lock_on.setBackground(Color.gray);

                    haikei_set(camera_of_orisen_nyuuryokuzu.object2TV(s_1.geta()),
                            camera_of_orisen_nyuuryokuzu.object2TV(s_2.geta()),
                            camera_of_orisen_nyuuryokuzu.object2TV(s_3.geta()),
                            camera_of_orisen_nyuuryokuzu.object2TV(s_4.geta()));

                    //	i_Lock_on=i_Lock_on_old;


                }
            } else if (i_mouse_modeA == 27) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_27(p);
            } else if (i_mouse_modeA == 28) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_28(p);
            } else if (i_mouse_modeA == 29) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_29(p);
            } else if (i_mouse_modeA == 30) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_30(p);
            } else if (i_mouse_modeA == 31) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_31(p);
            } else if (i_mouse_modeA == 32) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_32(p);
            } else if (i_mouse_modeA == 33) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_33(p);
            } else if (i_mouse_modeA == 34) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_34(p);
            } else if (i_mouse_modeA == 35) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_35(p);
            } else if (i_mouse_modeA == 36) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_36(p);
            } else if (i_mouse_modeA == 37) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_37(p);
            } else if (i_mouse_modeA == 38) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_38(p);
            } else if (i_mouse_modeA == 39) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_39(p);
            } else if (i_mouse_modeA == 40) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_40(p);
            } else if (i_mouse_modeA == 41) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_41(p);
            } else if (i_mouse_modeA == 42) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_42(p);
            } else if (i_mouse_modeA == 43) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_43(p);
            } else if (i_mouse_modeA == 44) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_44(p);
            } else if (i_mouse_modeA == 45) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_45(p);
            } else if (i_mouse_modeA == 46) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_46(p);
            } else if (i_mouse_modeA == 47) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_47(p);
            } else if (i_mouse_modeA == 48) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_48(p);
            } else if (i_mouse_modeA == 49) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_49(p);
            } else if (i_mouse_modeA == 50) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_50(p);
            } else if (i_mouse_modeA == 51) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_51(p);
            } else if (i_mouse_modeA == 52) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_52(p);
            } else if (i_mouse_modeA == 53) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_53(p);
            } else if (i_mouse_modeA == 54) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_54(p);
            } else if (i_mouse_modeA == 55) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_55(p);
            } else if (i_mouse_modeA == 56) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_56(p);
            } else if (i_mouse_modeA == 57) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_57(p);
            } else if (i_mouse_modeA == 58) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_58(p);
            }//senbun_henkan ?ﾔ?ﾂ
            else if (i_mouse_modeA == 59) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_59(p);
            } else if (i_mouse_modeA == 60) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_60(p);
            } else if (i_mouse_modeA == 61) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_61(p);
            }//長方形内選択?ipaintの選択に似せた選択機能?jに使う
            else if (i_mouse_modeA == 62) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_62(p);
            }//ボ??ノイ?}?@に使う
            //else if(i_mouse_modeA==63){es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mReleased_A_63(p);}
            //else if(i_mouse_modeA==64){es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mReleased_A_64(p);}
            //else if(i_mouse_modeA==65){es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mReleased_A_65(p);}
            //else if(i_mouse_modeA==66){es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mReleased_A_66(p);}
            //else if(i_mouse_modeA==67){es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mReleased_A_67(p);}
            //else if(i_mouse_modeA==68){es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mReleased_A_68(p);}
            //else if(i_mouse_modeA==69){es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mReleased_A_69(p);}
            //else if(i_mouse_modeA==70){es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mReleased_A_70(p);}


            else if (i_mouse_modeA == 10001) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_10001(p);
            } else if (i_mouse_modeA == 10002) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_10002(p);
            } else if (i_mouse_modeA == 101) {        //?ﾜり?繧ｪり?}操??
                OZ.oriagari_sousa_mouse_off(p);
            } else if (i_mouse_modeA == 102) {
                OZ.camera_of_oriagarizu.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));
                OZ.camera_of_oriagari_omote.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));
                OZ.camera_of_oriagari_ura.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));

                OZ.camera_of_touka_omote.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));
                OZ.camera_of_touka_ura.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));

                mouse_temp0.set(p);

            } else if (i_mouse_modeA == 103) {//基??面指定
                int new_kijyunmen_id;
                int old_kijyunmen_id;
                old_kijyunmen_id = OZ.ts1.get_kijyunmen_id();

                new_kijyunmen_id = OZ.ts1.set_kijyunmen_id(p);
                System.out.println("kijyunmen_id = " + new_kijyunmen_id);
                if (OZ.js.men_rating != null) {//20180227追加
                    //System.out.println("OZ.js.men_rating.length = "+OZ.js.men_rating.length);
                    //System.out.println("OZ.js.nbox.getsousuu() = "+OZ.js.nbox.getsousuu());

                    System.out.println(
                            "OZ.js.nbox.get_jyunjyo = " + OZ.js.nbox.get_jyunjyo(new_kijyunmen_id) + " , rating = " +
                                    OZ.js.nbox.get_double(OZ.js.nbox.get_jyunjyo(new_kijyunmen_id))

                    );

                }
                if ((new_kijyunmen_id != old_kijyunmen_id) && (OZ.i_suitei_dankai > 1)) {
                    OZ.i_suitei_dankai = 1;
                }

            } else if (i_mouse_modeA == 7) {
            } else if (i_mouse_modeA == 8) {
            } else {
            }

            repaint();
//i_Lock_on_ori=0;

        }

        i_mouseDragged_yuukou = 0;
        i_mouseReleased_yuukou = 0;

    }

    //マウス操??(ボタンをクリックしたとき)を?sう関??----------------------------------------------------
    public void mouseClicked(MouseEvent e) {
        //何もしない


    }

    //マウス操??(カ?[ソルが有効領域内に入ったとき)を?sう関??----------------------------------------------------
    public void mouseEntered(MouseEvent e) {
        //何もしない
    }

    //マウス操??(カ?[ソルが有効領域外に?oたとき)を?sう関??----------------------------------------------------
    public void mouseExited(MouseEvent e) {
        //何もしない
    }


    // --------------------------------------------------


    public void mouse_object_iti(Ten p) {//この関?狽ﾍmouseMoved等と違ってマウスイベントが起きても自動では認識されない
        p_mouse_TV_iti.set(p.getx(), p.gety());

        p_mouse_object_iti.set(camera_of_orisen_nyuuryokuzu.TV2object(p_mouse_TV_iti));
        //System.out.println("mouse=("+p_mouse_object_iti.getx()+","+p_mouse_object_iti.gety()+")"  );
    }


    // --------------------------------------------------

/*
public void keyTyped(KeyEvent e){
  char key = e.getKeyChar();
  if (key == 'a'){
    System.out.println("aのキ?[が押された");
  }
}


*/


    // ------------------------------------------------------
    public void haikei_set(Ten t1, Ten t2, Ten t3, Ten t4) {
        h_cam.set_h1(t1);
        h_cam.set_h2(t2);
        h_cam.set_h3(t3);
        h_cam.set_h4(t4);

        h_cam.parameter_keisan();
    }

    // ------------------------------------------------------
    public void haikei_byouga(Graphics2D g2h, Image imgh) {//引?狽ﾍカ??ラ?ﾝ定?A?????A画面X???A画面y?ｂｳ
        //背景画を?A画像の?ｶ?繧ﾍしを?Aウィンドウの(0,0)に?№墲ｹて回転や拡大なしで表示した???№????ﾔとする?B
        //背景画?繧ﾌ点h1を中?Sとしてa倍拡大する?B次に?Ah1を展開?}?繧ﾌ点h3と?dなるように背景画を平?s移動する?B
        //この?ﾔの展開?}を?Ah3を中?Sにb度回転したよう見えるように?ﾀ標を回転させて貼り付けて?Aその後?A?ﾀ標の回転を元に戻すという関???B
        //引?狽ﾍ?AGraphics2D g2h,Image imgh,Ten h1,Ten h2,Ten h3,Ten h4
        //h2,とh4も?dなるようにする
        //

        //?ﾅ?奄ﾉ

        //if(i_Lock_on>=10){i_Lock_on=i_Lock_on-10;}
        if (i_Lock_on == 1) {
            h_cam.setCamera(camera_of_orisen_nyuuryokuzu);
            h_cam.h3_and_h4_keisan();
            h_cam.parameter_keisan();
        }

        AffineTransform at = new AffineTransform();
        at.rotate(h_cam.get_kakudo() * Math.PI / 180.0, h_cam.get_cx(), h_cam.get_cy());
        g2h.setTransform(at);


        g2h.drawImage(imgh, h_cam.get_x0(), h_cam.get_y0(), h_cam.get_x1(), h_cam.get_y1(), this);

        //g2h.drawImage(imgh,kaisi_x,kaisi_y,this);//hx0,hy0,は描画開始位置

        at.rotate(-h_cam.get_kakudo() * Math.PI / 180.0, h_cam.get_cx(), h_cam.get_cy());
        g2h.setTransform(at);

    }

    // ------------------------------------------------------


    //----------------------------------------------------
    //ペイントを?sう関??----------------------------------
    //----------------------------------------------------
    public void paint(Graphics g) {
        //?uf?vを付けることでfloat型の?白lとして記?qすることができる
        Graphics2D g2 = (Graphics2D) bufferGraphics;
        //Graphics2D g2d = (Graphics2D)g;
        //BasicStroke BStroke = new BasicStroke(1.0f);g2.setStroke(BStroke);//??の太さ

        //float fTenkaizuSenhaba=(float)iTenkaizuSenhaba;	float f_h_TenkaizuSenhaba=(float)i_h_TenkaizuSenhaba;
        fTenkaizuSenhaba = (float) iTenkaizuSenhaba;
        f_h_TenkaizuSenhaba = (float) i_h_TenkaizuSenhaba;

        if (i_anti_alias == 1) {
            fTenkaizuSenhaba = fTenkaizuSenhaba + 0.2f;
            f_h_TenkaizuSenhaba = f_h_TenkaizuSenhaba + 0.2f;
        }

        BasicStroke BStroke = new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
        g2.setStroke(BStroke);//??の太さや??の末端の形??

        //BasicStroke BStroke = new BasicStroke(1.2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);g2.setStroke(BStroke);//??の太さや??の末端の形??
        if (i_anti_alias == 1) {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//アンチエイリアス?@オン
        }
        if (i_anti_alias == 0) {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);//アンチエイリアス?@オフ
        }

        g2.setBackground(Color.WHITE);    //この?sは?A画像をファイルに?曹ｫ?oそうとしてBufferedImageクラスを使う?????Aデフォルトで背景が?浮ﾉなるので?Aそれを避けるための意味?@20170107
        //画像をファイルに?曹ｫ?oさすことはやめて?A?ABufferedImageクラスを使わず?AImageクラスだけですむなら不要の?s

        //AffineTransform at = new AffineTransform();

        //String c=new String();                //文字列????用のクラスのインスタンス化
        //OritaCalc oc =new OritaCalc();

        //別の?dなりさがし?@のボタンの?Fの指定?B
        if (OZ.betu_sagasi_flg == 1) {
            Button3.setBackground(new Color(200, 200, 200));//これがないとForegroundが直ぐに反映されない?B仕様なのか?H
            Button3.setForeground(Color.black);

            Button_AS_matome.setBackground(new Color(200, 200, 200));//これがないとForegroundが直ぐに反映されない?B仕様なのか?H
            Button_AS_matome.setForeground(Color.black);

            Button_bangou_sitei_suitei_hyouji.setBackground(new Color(200, 200, 200));//これがないとForegroundが直ぐに反映されない?B仕様なのか?H
            Button_bangou_sitei_suitei_hyouji.setForeground(Color.black);
        } else {
            Button3.setBackground(new Color(201, 201, 201));
            Button3.setForeground(Color.gray);

            Button_AS_matome.setBackground(new Color(201, 201, 201));
            Button_AS_matome.setForeground(Color.gray);

            Button_bangou_sitei_suitei_hyouji.setBackground(new Color(201, 201, 201));
            Button_bangou_sitei_suitei_hyouji.setForeground(Color.gray);
        }

        // バッファ?[画面のクリア
        dim = getSize();
        bufferGraphics.clearRect(0, 0, dim.width, dim.height);

        //System.out.println("画面サイズ=(" + dim.width + " , " + dim.height  + ")"  );


        //int   i_ten_sagasi_hyouji, i_ten_hanasi_hyouji,i_kou_mitudo_nyuuryoku_hyouji,i_bun_hyouji,i_cp_hyouji,i_a0_hyouji,i_a1_hyouji;
        //int   i_mejirusi_hyouji,i_cp_ue_hyouji,i_oritatami_keika_hyouji;

        if (ckbox_ten_sagasi.isSelected()) {
            i_ten_sagasi_hyouji = 1;
        } else {
            i_ten_sagasi_hyouji = 0;
        }
        if (ckbox_ten_hanasi.isSelected()) {
            i_ten_hanasi_hyouji = 1;
        } else {
            i_ten_hanasi_hyouji = 0;
        }
        if (ckbox_kou_mitudo_nyuuryoku.isSelected()) {
            i_kou_mitudo_nyuuryoku_hyouji = 1;
        } else {
            i_kou_mitudo_nyuuryoku_hyouji = 0;
        }
        if (ckbox_bun.isSelected()) {
            i_bun_hyouji = 1;
        } else {
            i_bun_hyouji = 0;
        }
        if (ckbox_cp.isSelected()) {
            i_cp_hyouji = 1;
        } else {
            i_cp_hyouji = 0;
        }
        if (ckbox_a0.isSelected()) {
            i_a0_hyouji = 1;
        } else {
            i_a0_hyouji = 0;
        }
        if (ckbox_a1.isSelected()) {
            i_a1_hyouji = 1;
        } else {
            i_a1_hyouji = 0;
        }

        if (ckbox_mejirusi.isSelected()) {
            i_mejirusi_hyouji = 1;
        } else {
            i_mejirusi_hyouji = 0;
        }
        if (ckbox_cp_ue.isSelected()) {
            i_cp_ue_hyouji = 1;
        } else {
            i_cp_ue_hyouji = 0;
        }
        if (ckbox_oritatami_keika.isSelected()) {
            i_oritatami_keika_hyouji = 1;
        } else {
            i_oritatami_keika_hyouji = 0;
        }


        bufferGraphics.setColor(Color.red);
        //描画したい内容は以下に?曹ｭことVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV


        //カ??ラのセット

        es1.setCamera(camera_of_orisen_nyuuryokuzu);

        Oriagari_Zu OZi;
        for (int i = 1; i <= OAZ.size() - 1; i++) {
            OZi = (Oriagari_Zu) OAZ.get(i);
            OZi.ts1.setCamera(camera_of_orisen_nyuuryokuzu);
        }

//VVVVVVVVVVVVVVV以下のts2へのカ??ラセットはOriagari_zuのoekakiで実施しているので以下の5?sはなくてもいいはず?@20180225
        OZ.ts2.setCamera(OZ.camera_of_oriagarizu);
        OZ.ts2.setCam_omote(OZ.camera_of_oriagari_omote);
        OZ.ts2.setCam_ura(OZ.camera_of_oriagari_ura);
        OZ.ts2.setCam_touka_omote(OZ.camera_of_touka_omote);
        OZ.ts2.setCam_touka_ura(OZ.camera_of_touka_ura);
//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
/*
		//System.out.println("paint?@+++++++++++++++++++++?@透明化実施時の背景表示");
		//透明化実施時の背景表示

		if (i_toumeika==1) {
//g2.drawImage((Image)imageT,100,100,this);
//oc.hyouji("透明化実施時の背景表示1");

img_haikei=(Image)imageT;
			int iw=img_haikei.getWidth(this);//イ???[ジの??を取得
			int ih=img_haikei.getHeight(this);//イ???[ジの?ｂｳを取得

			//System.out.println("paint????"+iw);
			//System.out.println("paint?ｂｳ??"+ih);
			h_cam.set_haikei_haba((double)iw);
			h_cam.set_haikei_takasa((double)ih);

			//if(i_Lock_on==1){
				haikei_byouga(g2,img_haikei);
			//}
		}
*/

        //System.out.println("paint?@+++++++++++++++++++++?@背景表示");
        //背景表示
        if ((img_haikei != null) && (ihaikeihyouji >= 1)) {
            int iw = img_haikei.getWidth(this);//イ???[ジの??を取得
            int ih = img_haikei.getHeight(this);//イ???[ジの?ｂｳを取得

            //System.out.println("paint????"+iw);
            //System.out.println("paint?ｂｳ??"+ih);
            h_cam.set_haikei_haba(iw);
            h_cam.set_haikei_takasa(ih);

            //if(i_Lock_on==1){
            haikei_byouga(g2, img_haikei);
            //}
        }

        //格子表示
        //es1.kousi_oekaki_with_camera(bufferGraphics,i_bun_hyouji,i_cp_hyouji,i_a0_hyouji,i_a1_hyouji,fTenkaizuSenhaba,i_orisen_hyougen,f_h_TenkaizuSenhaba,dim.width,dim.height);//渡す?﨣ﾍカ??ラ?ﾝ定?A?????A画面X???A画面y?ｂｳ


        //解?熾\示
        //System.out.println("paint?@+++++++++++++++++++++?@解?熾\示  " +ikaisetuhyouji );
        if ((img_kaisetu != null) && (ikaisetuhyouji >= 1)) {
            bufferGraphics.drawImage(img_kaisetu, 650, 100, this);//80,80,は描画開始位置

            //bufferGraphics.drawImage(img_kaisetu,600,150,this);//80,80,は描画開始位置
            //	System.out.println("paint????"+img_haikei.getWidth(this));
            //	System.out.println("paint?ｂｳ??"+img_haikei.getHeight(this));
        }


        //基??面の表示
        //System.out.println("paint?@+++++++++++++++++++++?@基??面の表示");
        if (i_mejirusi_hyouji == 1) {
            if (OZ.hyouji_flg > 0) {
                //	ts1.setCamera(camera_of_orisen_nyuuryokuzu);
                OZ.ts1.oekaki_kijyunmen_id_with_camera(bufferGraphics);//ts1が?ﾜり?ﾝを?sう?ﾛの基??面を表示するのに使う?B
            }
        }

        //System.out.println("20170201_1");


        double d_haba = camera_of_orisen_nyuuryokuzu.get_camera_bairitsu_x() * es1.get_d_hantei_haba();
        //懐中電灯?i点の?j探?ﾍ囲
        if (i_ten_sagasi_hyouji == 1) {
            g2.setColor(new Color(255, 240, 0, 30));
            //g2.fill(new Ellipse2D.Double(p_mouse_TV_iti.getx()-d_haba, p_mouse_TV_iti.gety()-d_haba, 2.0*d_haba,2.0*d_haba));

            g2.setStroke(new BasicStroke(2.0f));
            g2.setColor(new Color(255, 240, 0, 230));
            g2.draw(new Ellipse2D.Double(p_mouse_TV_iti.getx() - d_haba, p_mouse_TV_iti.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
        }

        //懐中電灯の光束等
        if ((i_ten_sagasi_hyouji == 1) && (i_ten_hanasi_hyouji == 1)) {
            g2.setStroke(new BasicStroke(2.0f));
            g2.setColor(new Color(255, 240, 0, 170));
        }


        //展開?}表示
        //System.out.println("paint?@+++++++++++++++++++++?@展開?}表示(展開?}動かし中?Sの?\字を含む)");
        //if (ihaikeihyouji<=1) {
        //        es1.setCamera(camera_of_orisen_nyuuryokuzu);

        //if(i_mejirusi_hyouji==1){js.oekaki_jyuuji_with_camera(bufferGraphics);}
        es1.oekaki_with_camera(bufferGraphics, i_bun_hyouji, i_cp_hyouji, i_a0_hyouji, i_a1_hyouji, fTenkaizuSenhaba, i_orisen_hyougen, f_h_TenkaizuSenhaba, dim.width, dim.height, i_mejirusi_hyouji);//渡す?﨣ﾍカ??ラ?ﾝ定?A?????A画面X???A画面y?ｂｳ,展開?}動かし中?Sの?\字の目印の表示
        //}
        //	bufferGraphics.drawString(c.valueOf(k.getsousuu()),30,50);
        //	bufferGraphics.drawString(c.valueOf(k.getsousuu()),30,70);

        if (i_bun_hyouji == 1) {
            //展開?}?﨣ﾌ文字表示
            bufferGraphics.setColor(Color.black);

            bufferGraphics.drawString("mouse= (   " + p_mouse_object_iti.getx() + "   ,   " + p_mouse_object_iti.gety() + "   )", 120, 75); //この表示内容はvoid kekka_syoriで決められる?B

            bufferGraphics.drawString("L=" + es1.getsousuu(), 120, 90); //この表示内容はvoid kekka_syoriで決められる?B

            //System.out.println("paint?@+++++++++++++++++++++?@結果の文字表示");
            //結果の文字表示
            bufferGraphics.drawString(OZ.text_kekka, 120, 105); //この表示内容はvoid kekka_syoriで決められる?B

            if (i_kou_mitudo_nyuuryoku_hyouji == 1) {
                Ten kus_sisuu = new Ten(es1.get_moyori_ten_sisuu(p_mouse_TV_iti));

                double dx_ind;
                dx_ind = kus_sisuu.getx();
                double dy_ind;
                dy_ind = kus_sisuu.gety();
                int ix_ind;
                ix_ind = (int) Math.round(dx_ind);
                int iy_ind;
                iy_ind = (int) Math.round(dy_ind);
                bufferGraphics.drawString("(" + ix_ind + "," + iy_ind + ")", (int) p_mouse_TV_iti.getx() + 25, (int) p_mouse_TV_iti.gety() + 20); //この表示内容はvoid kekka_syoriで決められる?B

                //---------wwwwww--------------------------------------------

            }

            //bufferGraphics.drawString("index=" ,p_mouse_TV_iti.getx(),p_mouse_TV_iti.gety());

            //System.out.println("mouse=("+p_mouse_object_iti.getx()+","+p_mouse_object_iti.gety()+")"  );

            //System.out.println("i_SubThread = "+i_SubThread);
            if (i_SubThread == 1) {
                bufferGraphics.setColor(Color.red);

                bufferGraphics.drawString("Under Calculation. If you want to cancel calculation, uncheck [check A + MV]on right side and press the brake button (bicycle brake icon) on lower side.", 120, 134); //この表示内容はvoid kekka_syoriで決められる?B
                bufferGraphics.drawString("計算中?B?@なお?A計算を取り?ﾁし通???ﾔに戻りたいなら?A右辺の[check A+MV]のチェックをはずし?Aブレ?[キボタン?i下辺の?A自転車のブレ?[キのアイコン?jを押す?B ", 120, 148); //この表示内容はvoid kekka_syoriで決められる?B
                //bufferGraphics.setColor(Color.black);
            }

            //bufferGraphics.drawString("wwwwwwwwwwwwwwwwwwwwwwww",320,105);
            keijiban.keiji(bufferGraphics);//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        }


        //?ﾜり?繧ｪりの各種お絵かき
        //Oriagari_Zu OZi;
        for (int i = 1; i <= OAZ.size() - 1; i++) {
            OZi = (Oriagari_Zu) OAZ.get(i);
            OZi.oriagari_oekaki(bufferGraphics, i_mejirusi_hyouji);
        }
        //OZ = (Oriagari_Zu)OAZ.get(OAZ.size()-1);//?ﾜりあがり?}

        //展開?}を?ﾜり?繧ｪり?}の?繧ﾉ描くために?A展開?}を?ﾄ表示する
        if (i_cp_ue_hyouji == 1) {
            es1.oekaki_with_camera(bufferGraphics, i_bun_hyouji, i_cp_hyouji, i_a0_hyouji, i_a1_hyouji, fTenkaizuSenhaba, i_orisen_hyougen, f_h_TenkaizuSenhaba, dim.width, dim.height, i_mejirusi_hyouji);//渡す?﨣ﾍカ??ラ?ﾝ定?A?????A画面X???A画面y?ｂｳ
        }


        //System.out.println("20170201_5");

        //アンチェイリアス
        if (i_anti_alias == 1) {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//アンチェイリアス?@オン
        }
        if (i_anti_alias == 0) {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);//アンチェイリアス?@オフ
        }

        //	bufferGraphics.drawString(c.valueOf(oc.kakudo(new Ten(0.0,0.0),new Ten( 10.0, 0.0))), 30,170);
        //      bufferGraphics.drawString(c.valueOf(778),150,150);
        //test_oekaki();
        //System.out.println("paint?@+++++++++++++++++++++?@bufferGraphicsへの描画?I了");


        //中央指示??
        if (i_ten_hanasi_hyouji == 1) {

            g2.setStroke(new BasicStroke(1.0f));
            //g2.setColor(new Color(0, 0, 0,255));
            g2.setColor(Color.black);
            g2.drawLine((int) (p_mouse_TV_iti.getx()), (int) (p_mouse_TV_iti.gety()),
                    (int) (p_mouse_TV_iti.getx() + d_haba), (int) (p_mouse_TV_iti.gety() + d_haba)); //直??

            //g2.drawLine( (int)(p_mouse_TV_iti.getx()+d_haba*0.5),  (int)(p_mouse_TV_iti.gety()+d_haba*0.5),
            //             (int)(p_mouse_TV_iti.getx()+d_haba),  (int)(p_mouse_TV_iti.gety()+d_haba*2.0)); //直??
        }


        //描画したい内容はここまでAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA


        // オフスクリ?[ンイ???[ジを実?ﾛに描画する?Bオフスクリ?[ンの??は?ﾅ?奄ﾍ 0,0?B
        g.drawImage(offscreen, 0, 0, this);
        //System.out.println("paint?@+++++++++++++++++++++?@paint?I了");

        //System.out.println("20170201_6");System.exit(0);


/*
//20181204
//枠?ﾝ定時の背景を枠内のみ残してトリム 20181204
		if((i_mouse_modeA==61)&&(es1.get_i_egaki_dankai()==4)){//枠??が表示されている?ﾔ
					int xmin=(int)es1.p61_TV_hako.get_x_min();
					int xmax=(int)es1.p61_TV_hako.get_x_max();
					int ymin=(int)es1.p61_TV_hako.get_y_min();
					int ymax=(int)es1.p61_TV_hako.get_y_max();

img_haikei=(Image)offscreen.getSubimage(xmin,ymin,xmax-xmin+1,ymax-ymin+1);
//img_haikei=(Image)imageT.getSubimage(xmin,ymin,xmax-xmin+1,ymax-ymin+1);
h_cam= new Haikei_camera();

double dvx=(double)xmin;
double dvy=(double)ymin;

				haikei_set(	new Ten(120.0,120.0),
						new Ten(120.0+10.0,120.0),
						new Ten(dvx,dvy),
						new Ten(dvx+10.0,dvy)   );

						if(i_Lock_on==1){//20181202  このifが無いとlock on のときに背景がうまく表示できない
							h_cam.set_i_Lock_on(i_Lock_on);
							h_cam.setCamera(camera_of_orisen_nyuuryokuzu);
							h_cam.h3_obj_and_h4_obj_keisan();
						}



		}



*/


        if (OZ.matome_write_image_jikkoutyuu) {//まとめ?曹ｫ?oし実?s中の意味)
            writeImageFile(fname_and_number);

            w_image_jikkoutyuu = false;
        }


        if (flg_wi == 1) {//枠あり?曹ｫ?oし時の?ｧ御用20180525
            flg_wi = 0;
            writeImageFile(fname_wi);
        }
        if (flg61 == 1) {
            flg61 = 0;
            es1.set_i_egaki_dankai(4);
        }

        //paint_jikkoutyuu=false;
    }


    //----------------------------------------------------------
    // update は repaint() が呼び?oされると自動的に呼び?oされる?B
    public void update(Graphics g) {
        paint(g);
    }


    //----------------------------------------------------------
/*        void suitei_syokika(){
		OZ.text_kekka="";
		OZ.ks2.reset();
		OZ.ts1.reset();
		OZ.ts2.reset();
		OZ.ts3.reset();
		OZ.js.reset();

		//oriagari_camera_syokika();		//20170615 実?sしないようにした?i?ﾜりあがり?}の表示?ｵを変えないようにするため?j
		//ts2.setCamera(camera_of_oriagarizu);	//20170615 実?sしないようにした?i?ﾜりあがり?}の表示?ｵを変えないようにするため?j
		//js.setCamera(camera_of_oriagarizu);	//20170615 実?sしないようにした?i?ﾜりあがり?}の表示?ｵを変えないようにするため?j

		OZ.hyouji_flg=0;//?ﾜり?繧ｪり?}の表示様式の指定?B1なら展開?}?ｮ???A2なら?j金?}?B3なら透過?}?B5なら実?ﾛに?ﾜり紙を?ﾜった???№ﾆ同じ?B
		OZ.i_suitei_meirei=0;//?ﾜり?ﾝ??定をどの段階まで?sうかの指示
		OZ.i_suitei_dankai=0;//?ﾜり?ﾝ??定がどの段階までできたかの表示
		OZ.betu_sagasi_flg=0;

		OZ.matome_write_image_jikkoutyuu = false; //複?狽ﾌ?ﾜりあがり形の予測の?曹ｫ?oしがが実?s中ならtureになる?B20170615


	}
*/
    //----------------------------------------------------------

    void settei_syokika_yosoku() {
        OZ.text_kekka = "";
        OZ.hyouji_flg = 0;//?ﾜり?繧ｪり?}の表示様式の指定?B１なら実?ﾛに?ﾜり紙を?ﾜった???№ﾆ同じ?B２なら透過?}
        OZ.hyouji_flg_backup = 0;//表示様式hyouji_flgの一時的バックアップ用

        //表示用の値を格納する変??
        OZ.ip1 = -1;//?繪ｺ表?E?lの?炎??ﾝ定時に?A?ﾜった後の表裏が同じ面が
        //隣?ﾚするという誤?ｷがあれが0を?A無ければ1000を格納する変???B
        //ここでの?炎咊lは(0か1000)以外の?狽ﾈらなんでもいい?B
        OZ.ip2 = -1;//?繪ｺ表?E?lが?ﾜり?ﾝ可能な?dなり方を探した?ﾛに?A
        //可能な?dなり方がなければ0を?A可能な?dなり方があれば1000を格納する変???B
        //ここでの?炎咊lは(0か1000)以外の?狽ﾈらなんでもいい?B
        OZ.ip3 = 1;//ts1が?ﾜり?ﾝを?sう?ﾛの基??面を指定するのに使う?B

        //ip4=0;//これは?Ats1の?ﾅ?奄ﾉ裏返しをするかどうかを指定する?B0ならしない?B1なら裏返す?B//20170615 実?sしないようにした?i?ﾜりあがり?}の表示?ｵを変えないようにするため?j

        OZ.ip5 = -1;    //?繪ｺ表?E?lが一旦?ﾜり?ﾝ可能な紙の?dなりを示したあとで?A
        //さらに別の紙の?dなりをさがす時の?ﾅ?奄ﾌjs.susumu(Smensuu)の結果?B
        //0なら?Vたにsusumu余地がなかった?B0以外なら変化したSmenのidの?ﾅも?ｬさい番??
        OZ.ip6 = -1;    //?繪ｺ表?E?lが一旦?ﾜり?ﾝ可能な紙の?dなりを示したあとで?A
        //さらに別の紙の?dなりをさがす時の js.kanou_kasanari_sagasi()の結果?B
        //0なら可能な?dなりかたとなる?ﾔは存?ﾝしない?B
        //1000なら別の?dなり方が見つかった?B


        OZ.betu_sagasi_flg = 0;     //これは?u別の?dなりを探す?vことが有効の???№ﾍ１?A無効の???№ﾍ０をとる?B
        OZ.hakkenn_sita_kazu = 0;    //?ﾜり?dなり方で?A何通り発見したかを格納する?B


        i_mouseDragged_yuukou = 0;
        int i_mouseReleased_yuukou = 0;//0は?Aマウス操??を無視?B1はマウス操??有効?Bファイルボックスのon-offなどで?A予期せぬmouseDraggedやmouseReleasedが発?ｶしたとき?Aそれを?Eわないように0に?ﾝ定する?Bこれらは?Aマウスがクリックされたときに?A1有効指定にする?B

        OZ.suitei_syokika();
        keijiban.clear();

    }

    //----------------------
    //   void reset(){		settei_syokika_cp();		settei_syokika_yosoku();		repaint();	}


    ////b* アプリケ?[ション用?B?謫ｪが?^???^?^?^で始まる?sにはさまれた部分は無視される?B
    //---------------------------------------------------------
    void readImageFromFile() {

        FileDialog fd = new FileDialog(this, "Select Image File.", FileDialog.LOAD);
        fd.setVisible(true);
        img_haikei_fname = fd.getDirectory() + fd.getFile();
        int ihaikeihyouji_old;
        ihaikeihyouji_old = ihaikeihyouji;
        try {


            if (fd.getFile() != null) {

                Toolkit tk = Toolkit.getDefaultToolkit();
                img_haikei = tk.getImage(img_haikei_fname);
                //img_haikei = tk.getImage(img_haikei_fname);

                if (img_haikei != null) {
                    ihaikeihyouji = 1;
                    Button_haikei_kirikae.setBackground(Color.ORANGE);
                    i_Lock_on = 0;
                    i_Lock_on_ori = 0;
                    Button_haikei_Lock_on.setBackground(Color.gray);
                }

                //c1.repaint();
            }

        } catch (Exception e) {
            //System.out.println(e);
            ihaikeihyouji = ihaikeihyouji_old;
            if (ihaikeihyouji == 0) {
                Button_haikei_kirikae.setBackground(Color.gray);
            }
        }
//repaint();
        //System.out.println("01????"+img_haikei.getWidth(this));
        //System.out.println("01?ｂｳ??"+img_haikei.getHeight(this));

    }


    //---------------------------------------------------------
    void writeImage() {

        //String String fname_wi
        fname_wi = selectFileName("file name for Img save");
        flg61 = 0;
        if ((i_mouse_modeA == 61) && (es1.get_i_egaki_dankai() == 4)) {
            flg61 = 1;
            es1.set_i_egaki_dankai(0);


            //while(flg61==2)  {
            //	try{
            //		Thread.sleep(30);
            //	}catch (InterruptedException e){
            //	}
            //}
        }

        //if(flg61==2){flg61=1;}

        if (fname_wi != null) {
            flg_wi = 1;
            repaint();//緑の枠??を?曹ｫ?oさないために必要
            //writeImageFile(fname);
        }
        //if(flg61==1){flg61=0;es1.set_i_egaki_dankai(4);repaint();}


    }

    //---------------------------------------------------------

    //---------------------------------------------------------
    String selectFileName(String coment0) {
        FileDialog fd = new FileDialog(this, coment0, FileDialog.SAVE);
        fd.setVisible(true);
        String fname = null;
        if (fd.getFile() != null) {
            fname = fd.getDirectory() + fd.getFile();
        }
        return fname;
    }


    // -----------------------------------mmmmmmmmmmmmmm-------
    void writeImageFile(String fname) {//i=1?@png, 2=jpg


        if (fname != null) {
            int i = 1;

            if (fname.endsWith("svg")) {
                //	Memo memo1; memo1=es1.getMemo_for_kakidasi();
                Memo memo1;
                memo1 = es1.getMemo_for_svg_kakidasi_with_camera(i_bun_hyouji, i_cp_hyouji, i_a0_hyouji, i_a1_hyouji, fTenkaizuSenhaba, i_orisen_hyougen, f_h_TenkaizuSenhaba, dim.width, dim.height, i_mejirusi_hyouji);//渡す?﨣ﾍカ??ラ?ﾝ定?A?????A画面X???A画面y?ｂｳ,展開?}動かし中?Sの?\字の目印の表示

                Memo memo2 = new Memo();
                //memo2=OZ.getMemo_for_svg_kakidasi();//20180227?@各?ﾜり?繧ｪりのmemoと?d複する??業なので????

                //各?ﾜり?繧ｪりのmemo
                Oriagari_Zu OZi;
                for (int i_oz = 1; i_oz <= OAZ.size() - 1; i_oz++) {
                    OZi = (Oriagari_Zu) OAZ.get(i_oz);

                    memo2.addMemo(OZi.getMemo_for_svg_kakidasi());


                }


                memoAndName2File(file_henkan.orihime2svg(memo1, memo2), fname);
                return;
            } else if (fname.endsWith("png")) {
                i = 1;
            } else if (fname.endsWith("jpg")) {
                i = 2;
            } else {
                fname = fname + ".png";
                i = 1;
            }


            //
            dim = getSize();

            //	ファイル保存


            try {
                if (flg61 == 1) { //枠?ﾝ定時の枠内のみ?曹ｫ?oし 20180524
                    int xmin = (int) es1.p61_TV_hako.get_x_min();
                    int xmax = (int) es1.p61_TV_hako.get_x_max();
                    int ymin = (int) es1.p61_TV_hako.get_y_min();
                    int ymax = (int) es1.p61_TV_hako.get_y_max();
                    //	es1.set_i_egaki_dankai(0);repaint();//緑の枠??を?曹ｫ?oさないために必要
                    //try{
                    //	Thread.sleep(1000);
                    //}catch (InterruptedException e){
                    //}


                    if (i == 1) {
                        ImageIO.write(offscreen.getSubimage(xmin, ymin, xmax - xmin + 1, ymax - ymin + 1), "png", new File(fname));
                    }
                    if (i == 2) {
                        ImageIO.write(offscreen.getSubimage(xmin, ymin, xmax - xmin + 1, ymax - ymin + 1), "jpg", new File(fname));
                    }

                } else {//枠無しの???№ﾌ全体?曹ｫ?oし

                    System.out.println("2018-529_");
                    if (i == 1) {
                        ImageIO.write(offscreen.getSubimage(hidari_ue_ix, hidari_ue_iy, dim.width - migi_sita_ix - hidari_ue_ix, dim.height - migi_sita_iy - hidari_ue_iy), "png", new File(fname));
                    }
                    if (i == 2) {
                        ImageIO.write(offscreen.getSubimage(hidari_ue_ix, hidari_ue_iy, dim.width - migi_sita_ix - hidari_ue_ix, dim.height - migi_sita_iy - hidari_ue_iy), "jpg", new File(fname));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("?Iわりました");

        }

    }


// ------------------------------------------

    //---------------------------------------------------------
    void readImageFromFile2() {//これは使っていないので?ﾁしていい
        try {
            Toolkit tk = Toolkit.getDefaultToolkit();
            img_haikei = tk.getImage(img_haikei_fname);

            if (img_haikei != null) {
                ihaikeihyouji = 1;
                Button_haikei_kirikae.setBackground(Color.ORANGE);
            }

            //c1.repaint();
        } catch (Exception e) {
            System.out.println(e);
        }
        repaint();
        System.out.println("02????" + img_haikei.getWidth(this));
        System.out.println("02?ｂｳ??" + img_haikei.getHeight(this));

    }


    void readImageFromFile3() {
        URL url = getClass().getClassLoader().getResource(img_kaisetu_fname);
//URL url = getClass().getClassLoader().getResource("qqq/hajimeni.png");

        try {
            Toolkit tk = Toolkit.getDefaultToolkit();
            //img_kaisetu = tk.getImage(img_kaisetu_fname);
            img_kaisetu = tk.getImage(url);
            //if (img_kaisetu != null) {ikaisetuhyouji=1; }

            //c1.repaint();
        } catch (Exception e) {
            System.out.println(e);
        }
        repaint();
        //	System.out.println("02????"+img_haikei.getWidth(this));
        //	System.out.println("02?ｂｳ??"+img_haikei.getHeight(this));

    }


    //-------------------
    Memo readFile2Memo() {
        String fname = "";
        Memo memo_temp = new Memo();

        int file_ok = 0;//読み?桙ﾝファイル名の拡張子が適?ﾘ?iorh?Aobj?Acp?jなら1?Aそれ以外なら0

        FileDialog fd = new FileDialog(this, "読み?桙ﾝファイルの指定", FileDialog.LOAD);
        fd.setVisible(true);
        fname = fd.getDirectory() + fd.getFile();

        if (fname.endsWith("orh")) {
            file_ok = 1;
        }
        if (fname.endsWith("obj")) {
            file_ok = 1;
        }
        if (fname.endsWith("cp")) {
            file_ok = 1;
        }

        if (file_ok == 0) {
            //frame_title=frame_title_0+"        "+"XXX";
            //setTitle(frame_title);es1.set_title(frame_title);
            return memo_temp;
        }

        frame_title = frame_title_0 + "        " + fd.getFile();
        setTitle(frame_title);
        es1.set_title(frame_title);

        try {

            if (fd.getFile() != null) {  //キャンセルではない?????B

                BufferedReader br = new BufferedReader(new FileReader(fname));

                String rdata;

                memo1.reset();
                while ((rdata = br.readLine()) != null) {
                    memo_temp.addGyou(rdata);
                }
                br.close();
            }
        } catch (Exception e) {
            System.out.println(e);
            frame_title = frame_title_0 + "        " + "X";
            setTitle(frame_title);
            es1.set_title(frame_title);


        }
        //System.out.println("::::::::::" );
        //System.out.println(memo_temp.getGyousuu() );
        if (fname.endsWith("obj")) {
            System.out.println("objファイル読みこみ");
            return file_henkan.obj2orihime(memo_temp);
            //return obj2orihime(memo_temp);
        }  //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        if (fname.endsWith("cp")) {
            System.out.println("cpファイル読みこみ");
            return file_henkan.cp2orihime(memo_temp);
            //return cp2orihime(memo_temp);
        }  //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        return memo_temp;
    }

    //-----------------------------------------------------------------------------------------------------
    void writeMemo2File() {
        Memo memo1;
        memo1 = es1.getMemo_for_kakidasi();
/*
		FileDialog fd = new FileDialog(this,"?曹ｫ?oしファイルの指定",FileDialog.SAVE);
		fd.setVisible(true);
		String fname = fd.getDirectory() + fd.getFile();
*/
        String fname = selectFileName("?曹ｫ?oしファイルの名前");
        //if(fd.getFile()!=  null){


        if (fname != null) {
            if (fname.endsWith("cp")) {
                memoAndName2File(file_henkan.orihime2cp(memo1), fname);

                frame_title = frame_title_0 + "        " + fd.getFile();
                setTitle(frame_title);
                es1.set_title(frame_title);


            } else if (fname.endsWith("orh")) {
                memoAndName2File(memo1, fname);

                frame_title = frame_title_0 + "        " + fd.getFile();
                setTitle(frame_title);
                es1.set_title(frame_title);

            } else {
                fname = fname + ".orh";
                memoAndName2File(memo1, fname);

                frame_title = frame_title_0 + "        " + fd.getFile() + ".orh";
                setTitle(frame_title);
                es1.set_title(frame_title);


            }


        }

        //	FileWriter fw = new FileWriter(fname);
        //	BufferedWriter bw = new BufferedWriter(fw);
        //	PrintWriter pw = new PrintWriter(bw);
    }

    //----------------
    void memoAndName2File(Memo memo1, String fname) {

        System.out.println("ファイル?曹ｫこみ");
        try {


            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fname)));
            for (int i = 1; i <= memo1.getGyousuu(); i++) {
                pw.println(memo1.getGyou(i));
            }
            pw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

////b* アプリケ?[ション用?B?謫ｪが?^???^?^?^で始まる?sにはさまれた部分は無視される

    //--------------------------------------------------------------------------
    public void oritatami_suitei() {
        OZ.oritatami_suitei(camera_of_orisen_nyuuryokuzu, Ss0);
    }

    //--------------------------------------------------------------------------
    void oritatami_suitei_2col() {//２?F塗りわけ展開?}
        OZ.oritatami_suitei_2col(camera_of_orisen_nyuuryokuzu, Ss0);
    }


    //-------------------------------------
    void mks() {
        sub = new SubThread(this);
    }


    public double String2double(String str0, double henkan_error_modoriti) {

        String new_str0 = str0.trim();
        if (new_str0.equals("L1")) {
            str0 = String.valueOf(es1.get_L1());
        }
        if (new_str0.equals("L2")) {
            str0 = String.valueOf(es1.get_L2());
        }
        if (new_str0.equals("A1")) {
            str0 = String.valueOf(es1.get_A1());
        }
        if (new_str0.equals("A2")) {
            str0 = String.valueOf(es1.get_A2());
        }
        if (new_str0.equals("A3")) {
            str0 = String.valueOf(es1.get_A3());
        }


        return ms.String2double(str0, henkan_error_modoriti);


    }


    double d_ap_check4 = 0.0;

    public void check4(double r) {
        d_ap_check4 = r;
        //es1.ap_check4(r);
        if (i_SubThread == 0) {
            i_sub_mode = 3;//3=頂点周りの?ﾜ?ﾝ可能?ｫ判定?A1=?ﾜ?ﾝ??定の別解をまとめて?oす?B0=?ﾜ?ﾝ??定の別解をまとめて?oすモ?[ドではない?Bこの変?狽ﾍサブスレッドの動??変?Xにつかうだけ?B20170611にVer3.008から追加

            i_SubThread = 1;
            mks();//?Vしいスレッドを??る
            sub.start();
            return;
        } else if (i_SubThread == 1) {
            if (i_sub_mode == 3) {
                sub.stop();
                mks();//?Vしいスレッドを??る
                sub.start();
            }

            return;
        }
    }

}

// ****************************************************************************************************
// ****************************************************************************************************
// ****************************************************************************************************

class SubThread extends Thread {
    //変?狽ﾌ?骭ｾ
    ap orihime_ap;

    //スレッド???ｬ時に実?sされる????
    public SubThread(ap ap0) {
        orihime_ap = ap0;
    }

    public void run() {
        long start = System.currentTimeMillis();

        // -----------------------------------------------------------------
        if (orihime_ap.i_sub_mode == 0) {

            orihime_ap.oritatami_suitei();
            orihime_ap.repaint();
            // -----------------------------------------------------------------
        } else if (orihime_ap.i_sub_mode == 1) {

            String fname = orihime_ap.selectFileName("file name for Img save");
            if (fname != null) {
                orihime_ap.OZ.matome_write_image_jikkoutyuu = true;//まとめ?曹ｫ?oし実?s中の意味

                int mokuhyou = 100;

                for (int i = 1; i <= mokuhyou; i++) {
                    orihime_ap.oritatami_suitei();
                    orihime_ap.fname_and_number = fname + orihime_ap.OZ.hakkenn_sita_kazu;//まとめ?曹ｫ?oしに使う?B

                    orihime_ap.w_image_jikkoutyuu = true;
                    orihime_ap.repaint();

                    while (orihime_ap.w_image_jikkoutyuu) {// これを入れないと?A?曹ｫ?oし画像が抜けることがある?B

                        // 10ミリ秒待機する?Bなお?A10が適?ﾘかは不明20170611
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                        }
                    }
                    if (orihime_ap.OZ.betu_sagasi_flg == 0) {
                        mokuhyou = orihime_ap.OZ.hakkenn_sita_kazu;
                    }


                }
                orihime_ap.OZ.matome_write_image_jikkoutyuu = false;
            }
            // -----------------------------------------------------------------
        } else if (orihime_ap.i_sub_mode == 2) {
            if (orihime_ap.i_oritatami_bangou == orihime_ap.OZ.hakkenn_sita_kazu) {
                orihime_ap.OZ.text_kekka = "Number of found solutions = " + orihime_ap.OZ.hakkenn_sita_kazu + "  ";
            }

            int mokuhyou = orihime_ap.i_oritatami_bangou;

            while (mokuhyou > orihime_ap.OZ.hakkenn_sita_kazu) {
                orihime_ap.oritatami_suitei();
                orihime_ap.repaint();

                orihime_ap.OZ.i_suitei_meirei = 6;
                if (orihime_ap.OZ.betu_sagasi_flg == 0) {
                    mokuhyou = orihime_ap.OZ.hakkenn_sita_kazu;
                }

            }

            //orihime_ap.OZ.i_suitei_jissi_umu=1;
            // -----------------------------------------------------------------
        } else if (orihime_ap.i_sub_mode == 3) {
            orihime_ap.es1.ap_check4(orihime_ap.d_ap_check4);
            // -----------------------------------------------------------------
        } else if (orihime_ap.i_sub_mode == 4) {//二?F塗りわけ展開?}
            orihime_ap.oritatami_suitei_2col();
        }
        // -----------------------------------------------------------------

        long stop = System.currentTimeMillis();
        Long L = new Long(stop - start);
        //if(orihime_ap.OZ.i_suitei_jissi_umu==1){orihime_ap.OZ.text_kekka=orihime_ap.OZ.text_kekka+"     Computation time " +L.toString() + " msec.";}
        orihime_ap.OZ.text_kekka = orihime_ap.OZ.text_kekka + "     Computation time " + L.toString() + " msec.";

        orihime_ap.i_SubThread = 0;
        orihime_ap.repaint();
    }
}


//
//参?lurl
//    http://homepage.mac.com/tuyano/JavaTutor/JavaTutor10.html