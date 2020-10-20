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

import java.awt.*;


// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------

//public class Oriagari_Zu extends Oriagari_Zu_00 {//Oriagari_Zu‚ªŠî–{‚Æ‚È‚é?Ü?ã‚ª‚è—\‘ªƒAƒ‹ƒSƒŠƒYƒ€

public class Oriagari_Zu {

    ap orihime_ap;

    OritaCalc oc = new OritaCalc();
    Moji_sousa ms = new Moji_sousa(); //•¶Žš—ñ‘€?ì—p‚ÌŠÖ?”‚ð?W‚ß‚½ƒNƒ‰ƒX

    double r = 3.0;                   //Šî–{Ž}?\‘¢‚Ì’¼?ü‚Ì—¼’[‚Ì‰~‚Ì”¼Œa?AŽ}‚ÆŠeŽíƒ|ƒCƒ“ƒg‚Ì‹ß‚³‚Ì”»’èŠî?€


    public double d_oriagarizu_syukusyaku_keisuu = 1.0;//?Ü‚è?ã‚ª‚è?}‚Ì?kŽÚŒW?”
    public double d_oriagarizu_kaiten_hosei = 0.0;//?Ü‚è?ã‚ª‚è?}‚Ì‰ñ“]•\Ž¦Šp“x‚Ì•â?³Šp“x

    public Kihonshi_Syokunin ks2 = new Kihonshi_Syokunin(r);    //Šî–{Ž}?E?l?Bts2‚ÌŽ?‚Â“_?W?‡‚ðts3‚É“n‚·‘O‚É?A
    //ts2‚ÌŽ?‚Â“_?W?‡‚Í–_‚ª?d‚È‚Á‚Ä‚¢‚½‚è‚·‚é‚©‚à‚µ‚ê‚È‚¢‚Ì‚Å?A
    //‚¢‚Á‚½‚ñks2‚É“n‚µ‚Ä?ü•ª?W?‡‚Æ‚µ‚Ä?®—?‚·‚é?B

    public Tenkaizu_Syokunin ts1 = new Tenkaizu_Syokunin(r);    //“WŠJ?}?E?l?B“ü—Í‚³‚ê‚½?ü•ª?W?‡‚ð?Å?‰‚É?Ü‚Á‚Ä?j‹à?ó‚Ì“_?W?‡‚Ì?Ü‚è?ã‚ª‚è?}‚ð?ì‚é
    public Tenkaizu_Syokunin ts2 = new Tenkaizu_Syokunin(r);    //“WŠJ?}?E?l?Bts1‚Ì?ì‚Á‚½?j‹à?ó‚Ì“_?W?‡‚Ì?Ü‚è?ã‚ª‚è?}‚ð•ÛŽ?‚µ?A?ü•ª?W?‡‚É‚·‚é‚È‚Ç‚Ì“­‚«‚ð‚·‚é?B
    public Tenkaizu_Syokunin ts3 = new Tenkaizu_Syokunin(r);    //“WŠJ?}?E?l?Bts1‚Ì?ì‚Á‚½?j‹à?ó‚Ì“_?W?‡‚ð?®—?‚µ?B?V‚½‚É–Ê‚ð”FŽ¯‚·‚é‚È‚Ç‚Ì“­‚«‚ðŽ?‚Â?B

    public Jyougehyou_Syokunin js;
    //public Jyougehyou_Syokunin js      = new Jyougehyou_Syokunin();
    //public Jyougehyou_Syokunin(ap ap0){ orihime_ap=ap0;    reset();	}    //ƒRƒ“ƒXƒgƒ‰ƒNƒ^

    public Camera camera_of_oriagarizu = new Camera();
    public Camera camera_of_oriagari_omote = new Camera();
    public Camera camera_of_oriagari_ura = new Camera();
    public Camera camera_of_touka_omote = new Camera();
    public Camera camera_of_touka_ura = new Camera();

    public Color oriagarizu_F_color = new Color(255, 255, 50);//?Ü‚è?ã‚ª‚è?}‚Ì•\–Ê‚Ì?F
    public Color oriagarizu_B_color = new Color(233, 233, 233);//?Ü‚è?ã‚ª‚è?}‚Ì— –Ê‚Ì?F
    public Color oriagarizu_L_color = Color.black;//?Ü‚è?ã‚ª‚è?}‚Ì?ü‚Ì?F

    public int hyouji_flg_backup = 4;//•\Ž¦—lŽ®hyouji_flg‚ÌˆêŽž“IƒoƒbƒNƒAƒbƒv—p
    //int hyouji_flg_backup=4;//•\Ž¦—lŽ®hyouji_flg‚ÌˆêŽž“IƒoƒbƒNƒAƒbƒv—p
    public int hyouji_flg = 0;//?Ü‚è?ã‚ª‚è?}‚Ì•\Ž¦—lŽ®‚ÌŽw’è?B1‚È‚ç“WŠJ?}?®—??A2‚È‚ç?j‹à?}?B3‚È‚ç“§‰ß?}?B4‚È‚çŽÀ?Û‚É?Ü‚èŽ†‚ð?Ü‚Á‚½?ê?‡‚Æ“¯‚¶?B
    public int i_suitei_meirei = 0;//?Ü‚è?ô‚Ý?„’è‚ð‚Ç‚Ì’iŠK‚Ü‚Å?s‚¤‚©‚ÌŽwŽ¦
    public int i_suitei_dankai = 0;//?Ü‚è?ô‚Ý?„’è‚ª‚Ç‚Ì’iŠK‚Ü‚Å‚Å‚«‚½‚©‚Ì•\Ž¦
    //public int i_suitei_jissi_umu=0;//int i_suitei_jissi_umu‚Í?A?Ü‚è?ô‚Ý?„’è‚ÌŒvŽZ‚ðŽÀŽ{‚µ‚½‚©‚Ç‚¤‚©‚ð•\‚·?Bint i_suitei_jissi_umu=0‚È‚çŽÀŽ{‚µ‚È‚¢?B1‚È‚çŽÀŽ{‚µ‚½?B


    //•\Ž¦—p‚Ì’l‚ðŠi”[‚·‚é•Ï?”
    public int ip1 = -1;//?ã‰º•\?E?l‚Ì?‰Šú?Ý’èŽž‚É?A?Ü‚Á‚½Œã‚Ì•\— ‚ª“¯‚¶–Ê‚ª
    //—×?Ú‚·‚é‚Æ‚¢‚¤Œë?·‚ª‚ ‚ê‚ª0‚ð?A–³‚¯‚ê‚Î1000‚ðŠi”[‚·‚é•Ï?”?B
    //‚±‚±‚Å‚Ì?‰Šú’l‚Í(0‚©1000)ˆÈŠO‚Ì?”‚È‚ç‚È‚ñ‚Å‚à‚¢‚¢?B
    public int ip2 = -1;//?ã‰º•\?E?l‚ª?Ü‚è?ô‚Ý‰Â”\‚È?d‚È‚è•û‚ð’T‚µ‚½?Û‚É?A
    //‰Â”\‚È?d‚È‚è•û‚ª‚È‚¯‚ê‚Î0‚ð?A‰Â”\‚È?d‚È‚è•û‚ª‚ ‚ê‚Î1000‚ðŠi”[‚·‚é•Ï?”?B
    //‚±‚±‚Å‚Ì?‰Šú’l‚Í(0‚©1000)ˆÈŠO‚Ì?”‚È‚ç‚È‚ñ‚Å‚à‚¢‚¢?B
    //int ip3a=1;
    public int ip3 = 1;//ts1‚ª?Ü‚è?ô‚Ý‚ð?s‚¤?Û‚ÌŠî?€–Ê‚ðŽw’è‚·‚é‚Ì‚ÉŽg‚¤?B

    public int ip4 = 0;//‚±‚ê‚Í?Ats1‚Ì?Å?‰‚É— •Ô‚µ‚ð‚·‚é‚©‚Ç‚¤‚©‚ðŽw’è‚·‚é?B0‚È‚ç‚µ‚È‚¢?B1‚È‚ç— •Ô‚·?B

    public int ip5 = -1;    //?ã‰º•\?E?l‚ªˆê’U?Ü‚è?ô‚Ý‰Â”\‚ÈŽ†‚Ì?d‚È‚è‚ðŽ¦‚µ‚½‚ ‚Æ‚Å?A
    //‚³‚ç‚É•Ê‚ÌŽ†‚Ì?d‚È‚è‚ð‚³‚ª‚·Žž‚Ì?Å?‰‚Ìjs.susumu(Smensuu)‚ÌŒ‹‰Ê?B
    //0‚È‚ç?V‚½‚Ésusumu—]’n‚ª‚È‚©‚Á‚½?B0ˆÈŠO‚È‚ç•Ï‰»‚µ‚½Smen‚Ìid‚Ì?Å‚à?¬‚³‚¢”Ô?†

    public int ip6 = -1;    //?ã‰º•\?E?l‚ªˆê’U?Ü‚è?ô‚Ý‰Â”\‚ÈŽ†‚Ì?d‚È‚è‚ðŽ¦‚µ‚½‚ ‚Æ‚Å?A
    //‚³‚ç‚É•Ê‚ÌŽ†‚Ì?d‚È‚è‚ð‚³‚ª‚·Žž‚Ì js.kanou_kasanari_sagasi()‚ÌŒ‹‰Ê?B
    //0‚È‚ç‰Â”\‚È?d‚È‚è‚©‚½‚Æ‚È‚é?ó‘Ô‚Í‘¶?Ý‚µ‚È‚¢?B
    //1000‚È‚ç•Ê‚Ì?d‚È‚è•û‚ªŒ©‚Â‚©‚Á‚½?B

    public int betu_sagasi_flg = 0;     //‚±‚ê‚Í?u•Ê‚Ì?d‚È‚è‚ð’T‚·?v‚±‚Æ‚ª—LŒø‚Ì?ê?‡‚Í‚P?A–³Œø‚Ì?ê?‡‚Í‚O‚ð‚Æ‚é?B
    public int hakkenn_sita_kazu = 0;    //?Ü‚è?d‚È‚è•û‚Å?A‰½’Ê‚è”­Œ©‚µ‚½‚©‚ðŠi”[‚·‚é?B


    //public int i_AS_matome =100;//?Ü?ô‚Ý?„’è‚Ì•Ê‰ð‚ð‚Ü‚Æ‚ß‚Ä?o‚·ŒÂ?”//20171217 ver3.030‚Å‚ÍŽg‚í‚ê‚Ä‚¢‚È‚¢?B


    public int toukazu_toukado = 16;//“§‰ß?}‚ðƒJƒ‰?[•`‰æ‚·‚é?Û‚Ì“§‰ß“x


    public int i_oriagari_sousa_mode = 1;//1=•ÏŒ`Žž‚Í?j‹à?}‚É‚È‚è?A•ÏŒ`Œã‚É?ã‰º•\‚ð?ÄŒvŽZ‚·‚é?A‹Œ—ˆ‚©‚ç‚Ìƒ‚?[ƒh?A2=•ÏŒ`Žž‚à?Ü‚è?ã‚ª‚è?}‚Ì‚Ü‚Ü‚Å?AŠî–{“I‚É•ÏŒ`Œã‚É?ã‰º•\‚Í?ÄŒvŽZ‚µ‚È‚¢ƒ‚?[ƒh


    //public Keijiban keijiban =new Keijiban(this);
    public Keijiban keijiban;


    public boolean w_image_jikkoutyuu = false;//?Ü?ô‚Ý‚Ü‚Æ‚ßŽÀ?s‚Ì?B’Pˆê‰ñ‚ÌƒCƒ??[ƒW?‘‚«?o‚µ‚ªŽÀ?s’†‚È‚çture‚É‚È‚é?B
    public boolean matome_write_image_jikkoutyuu = false;//matome_write_image‚ªŽÀ?s’†‚È‚çture‚É‚È‚é?B‚±‚ê‚Í?A•¡?”‚Ì?Ü‚è‚ ‚ª‚èŒ`‚Ì—\‘ª‚Ì?‘‚«?o‚µ‚ª‚©‚·‚ê‚È‚¢‚æ‚¤‚ÉŽg‚¤?B20170613

    String fname_and_number;//‚Ü‚Æ‚ß?‘‚«?o‚µ‚ÉŽg‚¤?B


    //ŠeŽí•Ï?”‚Ì’è‹`
    String c = "";                //•¶Žš—ñ?ˆ—?—p‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»
    public String text_kekka = "";                //Œ‹‰Ê•\Ž¦—p•¶Žš—ñ‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»


    int i_fold_type = 0;//=0‚Í’Ê?í‚Ì“WŠJ?}‚Ì‘S?Ü?ü‚ð‘Î?Û‚Æ‚µ‚½?Ü‚è?ô‚Ý?„’è?A=1‚Íselect‚³‚ê‚½?Ü?ü‚ð‘Î?Û‚Æ‚µ‚½?Ü‚è?ô‚Ý?„’è?A


    public int i_toukazu_color = 0;//“§‰ß?}‚ðƒJƒ‰?[‚É‚·‚é‚È‚ç‚P?A‚µ‚È‚¢‚È‚ç‚O


    // **************************************************
//ƒRƒ“ƒXƒgƒ‰ƒNƒ^
    public Oriagari_Zu(ap ap0) {

        orihime_ap = ap0;

        js = new Jyougehyou_Syokunin(ap0);
        keijiban = new Keijiban(ap0);

        //ƒJƒ?ƒ‰‚Ì?Ý’è ------------------------------------------------------------------
        oriagari_camera_syokika();
        //ƒJƒ?ƒ‰‚Ì?Ý’è‚Í‚±‚±‚Ü‚Å----------------------------------------------------


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

        //oriagari_camera_syokika();		//20170615 ŽÀ?s‚µ‚È‚¢‚æ‚¤‚É‚µ‚½?i?Ü‚è‚ ‚ª‚è?}‚Ì•\Ž¦?ó‹µ‚ð•Ï‚¦‚È‚¢‚æ‚¤‚É‚·‚é‚½‚ß?j
        //ts2.setCamera(camera_of_oriagarizu);	//20170615 ŽÀ?s‚µ‚È‚¢‚æ‚¤‚É‚µ‚½?i?Ü‚è‚ ‚ª‚è?}‚Ì•\Ž¦?ó‹µ‚ð•Ï‚¦‚È‚¢‚æ‚¤‚É‚·‚é‚½‚ß?j
        //js.setCamera(camera_of_oriagarizu);	//20170615 ŽÀ?s‚µ‚È‚¢‚æ‚¤‚É‚µ‚½?i?Ü‚è‚ ‚ª‚è?}‚Ì•\Ž¦?ó‹µ‚ð•Ï‚¦‚È‚¢‚æ‚¤‚É‚·‚é‚½‚ß?j

        hyouji_flg = 0;//?Ü‚è?ã‚ª‚è?}‚Ì•\Ž¦—lŽ®‚ÌŽw’è?B1‚È‚ç“WŠJ?}?®—??A2‚È‚ç?j‹à?}?B3‚È‚ç“§‰ß?}?B5‚È‚çŽÀ?Û‚É?Ü‚èŽ†‚ð?Ü‚Á‚½?ê?‡‚Æ“¯‚¶?B
        i_suitei_meirei = 0;//?Ü‚è?ô‚Ý?„’è‚ð‚Ç‚Ì’iŠK‚Ü‚Å?s‚¤‚©‚ÌŽwŽ¦
        i_suitei_dankai = 0;//?Ü‚è?ô‚Ý?„’è‚ª‚Ç‚Ì’iŠK‚Ü‚Å‚Å‚«‚½‚©‚Ì•\Ž¦
        betu_sagasi_flg = 0;

        matome_write_image_jikkoutyuu = false; //•¡?”‚Ì?Ü‚è‚ ‚ª‚èŒ`‚Ì—\‘ª‚Ì?‘‚«?o‚µ‚ª‚ªŽÀ?s’†‚È‚çture‚É‚È‚é?B20170615


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


        //?Ü‚è?ã‚ª‚è?}‚Ì•\Ž¦‚Íjs‚ª?s‚¤‚Ì‚Å•\Ž¦Ž©‘Ì‚Íts2‚ÉƒJƒ?ƒ‰‚ðƒZƒbƒg‚·‚é•K—v‚Í‚È‚¢‚ª?A‚»‚ÌŒã?A‰æ–ÊƒNƒŠƒbƒN‚ðts2‚ª”»’è‚µ‚½‚è‚·‚é‚Ì‚Åts2‚ÌƒJƒ?ƒ‰?X?V‚Í•\Ž¦‚Æ“¯Šú‚µ‚Ä?s‚¤•K—v‚ª‚ ‚é?B
        ts2.setCamera(camera_of_oriagarizu);
        ts2.setCam_omote(camera_of_oriagari_omote);
        ts2.setCam_ura(camera_of_oriagari_ura);
        ts2.setCam_touka_omote(camera_of_touka_omote);
        ts2.setCam_touka_ura(camera_of_touka_ura);


        //?j‹à?}‚Ì•\Ž¦
        //System.out.println("paint?@+++++++++++++++++++++?@?j‹à?}‚Ì•\Ž¦");
        if (hyouji_flg == 2) {
            ts2.oekaki_with_camera(bufferGraphics, ip4);//?Ü‚è?ã‚ª‚è?}‚Ì‘€?ì‚Í‚±‚Ìts2‚Ì?j‹à?}‚ð“®‚©‚·?B
        }

        //?Ü‚è‚ ‚ª‚è?}?i•\?j‚Ì•\Ž¦
        if (((ip4 == 0) || (ip4 == 2)) || (ip4 == 3)) {
            js.setCamera(camera_of_oriagari_omote);

            //“§‰ß?}‚Ì•\Ž¦
            //System.out.println("paint?@+++++++++++++++++++++?@“§‰ß?}‚Ì•\Ž¦");
            if (hyouji_flg == 3) {        // hyouji_flg;?Ü‚è?ã‚ª‚è?}‚Ì•\Ž¦—lŽ®‚ÌŽw’è?B‚P‚È‚çŽÀ?Û‚É?Ü‚èŽ†‚ð?Ü‚Á‚½?ê?‡‚Æ“¯‚¶?B‚Q‚È‚ç“§‰ß?}?B3‚È‚ç?j‹à?}?B
                js.oekaki_toukazu_with_camera(bufferGraphics, ts1, ts2.get(), ts3.get(), i_toukazu_color, toukazu_toukado);
            }

            //?Ü‚è?ã‚ª‚è?}‚Ì•\Ž¦************* //System.out.println("paint?@+++++++++++++++++++++?@?Ü‚è?ã‚ª‚è?}‚Ì•\Ž¦");
            if (hyouji_flg == 5) {
                js.oekaki_oriagarizu_with_camera(bufferGraphics, ts1, ts2.get(), ts3.get());// hyouji_flg;?Ü‚è?ã‚ª‚è?}‚Ì•\Ž¦—lŽ®‚ÌŽw’è?B5‚È‚çŽÀ?Û‚É?Ü‚èŽ†‚ð?Ü‚Á‚½?ê?‡‚Æ“¯‚¶?B3‚È‚ç“§‰ß?}?B2‚È‚ç?j‹à?}?B
            }

            //?Ü‚è?ã‚ª‚è?}‚Ì“®‚©‚µ’†?S‚Ì?\Žš•\Ž¦
            //System.out.println("paint?@+++++++++++++++++++++?@?Ü‚è?ã‚ª‚è?}‚Ì“®‚©‚µ’†?S‚Ì?\Žš•\Ž¦)");
            if (i_mejirusi_hyouji == 1) {
                js.oekaki_jyuuji_with_camera(bufferGraphics);
            }
        }

        //?Ü‚è‚ ‚ª‚è?}?i— ?j‚Ì•\Ž¦
        if (((ip4 == 1) || (ip4 == 2)) || (ip4 == 3)) {
            camera_of_oriagari_ura.hyouji();
            js.setCamera(camera_of_oriagari_ura);

            //“§‰ß?}‚Ì•\Ž¦
            //System.out.println("paint?@+++++++++++++++++++++?@“§‰ß?}‚Ì•\Ž¦");
            if (hyouji_flg == 3) {        // hyouji_flg;?Ü‚è?ã‚ª‚è?}‚Ì•\Ž¦—lŽ®‚ÌŽw’è?B‚P‚È‚çŽÀ?Û‚É?Ü‚èŽ†‚ð?Ü‚Á‚½?ê?‡‚Æ“¯‚¶?B‚Q‚È‚ç“§‰ß?}?B3‚È‚ç?j‹à?}?B
                js.oekaki_toukazu_with_camera(bufferGraphics, ts1, ts2.get(), ts3.get(), i_toukazu_color, toukazu_toukado);
            }

            //?Ü‚è?ã‚ª‚è?}‚Ì•\Ž¦************* //System.out.println("paint?@+++++++++++++++++++++?@?Ü‚è?ã‚ª‚è?}‚Ì•\Ž¦");
            if (hyouji_flg == 5) {
                js.oekaki_oriagarizu_with_camera(bufferGraphics, ts1, ts2.get(), ts3.get());// hyouji_flg;?Ü‚è?ã‚ª‚è?}‚Ì•\Ž¦—lŽ®‚ÌŽw’è?B5‚È‚çŽÀ?Û‚É?Ü‚èŽ†‚ð?Ü‚Á‚½?ê?‡‚Æ“¯‚¶?B3‚È‚ç“§‰ß?}?B2‚È‚ç?j‹à?}?B
            }

            //?Ü‚è?ã‚ª‚è?}‚Ì“®‚©‚µ’†?S‚Ì?\Žš•\Ž¦
            //System.out.println("paint?@+++++++++++++++++++++?@?Ü‚è?ã‚ª‚è?}‚Ì“®‚©‚µ’†?S‚Ì?\Žš•\Ž¦)");
            if (i_mejirusi_hyouji == 1) {
                js.oekaki_jyuuji_with_camera(bufferGraphics);
            }
        }

        //“§‰ß?}?i?Ü‚è‚ ‚ª‚è?}•\Ž¦Žž‚É’Ç‰Á‚·‚é•ª?j
        if ((ip4 == 3) && (hyouji_flg == 5)) {
            // ---------------------------------------------------------------------------------
            js.setCamera(camera_of_touka_omote);
            //“§‰ß?}‚Ì•\Ž¦
            //System.out.println("paint?@+++++++++++++++++++++?@“§‰ß?}‚Ì•\Ž¦");
            js.oekaki_toukazu_with_camera(bufferGraphics, ts1, ts2.get(), ts3.get(), i_toukazu_color, toukazu_toukado);

            //?Ü‚è?ã‚ª‚è?}‚Ì“®‚©‚µ’†?S‚Ì?\Žš•\Ž¦
            //System.out.println("paint?@+++++++++++++++++++++?@?Ü‚è?ã‚ª‚è?}‚Ì“®‚©‚µ’†?S‚Ì?\Žš•\Ž¦)");
            if (i_mejirusi_hyouji == 1) {
                js.oekaki_jyuuji_with_camera(bufferGraphics);
            }

            // ---------------------------------------------------------------------------------
            js.setCamera(camera_of_touka_ura);

            //“§‰ß?}‚Ì•\Ž¦
            //System.out.println("paint?@+++++++++++++++++++++?@“§‰ß?}‚Ì•\Ž¦");
            js.oekaki_toukazu_with_camera(bufferGraphics, ts1, ts2.get(), ts3.get(), i_toukazu_color, toukazu_toukado);

            //?Ü‚è?ã‚ª‚è?}‚Ì“®‚©‚µ’†?S‚Ì?\Žš•\Ž¦
            //System.out.println("paint?@+++++++++++++++++++++?@?Ü‚è?ã‚ª‚è?}‚Ì“®‚©‚µ’†?S‚Ì?\Žš•\Ž¦)");
            if (i_mejirusi_hyouji == 1) {
                js.oekaki_jyuuji_with_camera(bufferGraphics);
            }
            // ---------------------------------------------------------------------------------
        }


        //?Ü‚è?ã‚ª‚è?}“®‚©‚µŽž‚Ì?j‹à?}‚Æ“WŠJ?}?ã‚Ì‘Î‰ž“_‚Ì•\Ž¦


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
    }//?Ü‚è?ã‚ª‚è?}‚Ì?kŽÚŒW?”

    public double get_syukusyaku() {
        return d_oriagarizu_syukusyaku_keisuu;
    }//?Ü‚è?ã‚ª‚è?}‚Ì?kŽÚŒW?”

    public void set_kaiten(double d0) {
        d_oriagarizu_kaiten_hosei = d0;
    }//?Ü‚è?ã‚ª‚è?}‚Ì‰ñ“]•\Ž¦Šp“x‚Ì•â?³Šp“x

    public double get_kaiten() {
        return d_oriagarizu_kaiten_hosei;
    }//?Ü‚è?ã‚ª‚è?}‚Ì‰ñ“]•\Ž¦Šp“x‚Ì•â?³Šp“x

//mmmmmmm

    //---------------------------------------------------------

    //public Memo getMemo_for_svg_kakidasi(){
    //	return js.getMemo_for_svg_kakidasi() ;
    //}

    public Memo getMemo_for_svg_kakidasi() {

        Memo memo_temp = new Memo();

        //?j‹à?}‚Ìsvg
        //System.out.println("paint?@+++++++++++++++++++++?@?j‹à?}‚Ì•\Ž¦");
        if (hyouji_flg == 2) {
            //ts2.oekaki_with_camera(bufferGraphics,ip4);//?Ü‚è?ã‚ª‚è?}‚Ì‘€?ì‚Í‚±‚Ìts2‚Ì?j‹à?}‚ð“®‚©‚·?B

//System.out.println("getMemo_hariganezu_for_svg_kakidasi?@?j‹à?}‚Ìsvg");
            memo_temp.addMemo(js.getMemo_hariganezu_for_svg_kakidasi(ts1, ts2.get(), ts3.get(), 0));//‚S”Ô–Ú‚Ì?®?”‚Í‚O‚È‚ç–Ê‚Ì˜g‚Ì‚Ý?A‚P‚È‚ç–Ê‚ð“h‚é


        }

        //?Ü‚è‚ ‚ª‚è?}?i•\?j‚Ìsvg
        if (((ip4 == 0) || (ip4 == 2)) || (ip4 == 3)) {
            js.setCamera(camera_of_oriagari_omote);

            //“§‰ß?}‚Ìsvg
            //System.out.println("paint?@+++++++++++++++++++++?@“§‰ß?}‚Ì•\Ž¦");
            if (hyouji_flg == 3) {        // hyouji_flg;?Ü‚è?ã‚ª‚è?}‚Ì•\Ž¦—lŽ®‚ÌŽw’è?B‚P‚È‚çŽÀ?Û‚É?Ü‚èŽ†‚ð?Ü‚Á‚½?ê?‡‚Æ“¯‚¶?B‚Q‚È‚ç“§‰ß?}?B3‚È‚ç?j‹à?}?B
                memo_temp.addMemo(js.getMemo_hariganezu_for_svg_kakidasi(ts1, ts2.get(), ts3.get(), 1));
            }

            //?Ü‚è?ã‚ª‚è?}‚Ìsvg************* //System.out.println("paint?@+++++++++++++++++++++?@?Ü‚è?ã‚ª‚è?}‚Ì•\Ž¦");
            if (hyouji_flg == 5) {
                //js.oekaki_oriagarizu_with_camera(bufferGraphics,ts1,ts2.get(),ts3.get());// hyouji_flg;?Ü‚è?ã‚ª‚è?}‚Ì•\Ž¦—lŽ®‚ÌŽw’è?B5‚È‚çŽÀ?Û‚É?Ü‚èŽ†‚ð?Ü‚Á‚½?ê?‡‚Æ“¯‚¶?B3‚È‚ç“§‰ß?}?B2‚È‚ç?j‹à?}?B
                memo_temp.addMemo(js.getMemo_for_svg_with_camera(ts1, ts2.get(), ts3.get()));// hyouji_flg;?Ü‚è?ã‚ª‚è?}‚Ì•\Ž¦—lŽ®‚ÌŽw’è?B5‚È‚çŽÀ?Û‚É?Ü‚èŽ†‚ð?Ü‚Á‚½?ê?‡‚Æ“¯‚¶?B3‚È‚ç“§‰ß?}?B2‚È‚ç?j‹à?}?B

            }
        }

        //?Ü‚è‚ ‚ª‚è?}?i— ?j‚Ìsvg
        if (((ip4 == 1) || (ip4 == 2)) || (ip4 == 3)) {

            js.setCamera(camera_of_oriagari_ura);

            //“§‰ß?}‚Ìsvg
            //System.out.println("paint?@+++++++++++++++++++++?@“§‰ß?}‚Ì•\Ž¦");
            if (hyouji_flg == 3) {        // hyouji_flg;?Ü‚è?ã‚ª‚è?}‚Ì•\Ž¦—lŽ®‚ÌŽw’è?B‚P‚È‚çŽÀ?Û‚É?Ü‚èŽ†‚ð?Ü‚Á‚½?ê?‡‚Æ“¯‚¶?B‚Q‚È‚ç“§‰ß?}?B3‚È‚ç?j‹à?}?B
                memo_temp.addMemo(js.getMemo_hariganezu_for_svg_kakidasi(ts1, ts2.get(), ts3.get(), 1));
            }

            //?Ü‚è?ã‚ª‚è?}‚Ìsvg************* //System.out.println("paint?@+++++++++++++++++++++?@?Ü‚è?ã‚ª‚è?}‚Ì•\Ž¦");
            if (hyouji_flg == 5) {
                //js.oekaki_oriagarizu_with_camera(bufferGraphics,ts1,ts2.get(),ts3.get());// hyouji_flg;?Ü‚è?ã‚ª‚è?}‚Ì•\Ž¦—lŽ®‚ÌŽw’è?B5‚È‚çŽÀ?Û‚É?Ü‚èŽ†‚ð?Ü‚Á‚½?ê?‡‚Æ“¯‚¶?B3‚È‚ç“§‰ß?}?B2‚È‚ç?j‹à?}?B
                memo_temp.addMemo(js.getMemo_for_svg_with_camera(ts1, ts2.get(), ts3.get()));// hyouji_flg;?Ü‚è?ã‚ª‚è?}‚Ì•\Ž¦—lŽ®‚ÌŽw’è?B5‚È‚çŽÀ?Û‚É?Ü‚èŽ†‚ð?Ü‚Á‚½?ê?‡‚Æ“¯‚¶?B3‚È‚ç“§‰ß?}?B2‚È‚ç?j‹à?}?B

            }


        }

        //“§‰ß?}?i?Ü‚è‚ ‚ª‚è?}•\Ž¦Žž‚É’Ç‰Á‚·‚é•ª?j
        if ((ip4 == 3) && (hyouji_flg == 5)) {
            // ---------------------------------------------------------------------------------
            js.setCamera(camera_of_touka_omote);
            //“§‰ß?}‚Ìsvg
            //System.out.println("paint?@+++++++++++++++++++++?@“§‰ß?}‚Ì•\Ž¦");

            //js.oekaki_toukazu_with_camera(bufferGraphics,ts1,ts2.get(),ts3.get());
            //js.getMemo_toukazu_with_camera(bufferGraphics,ts1,ts2.get(),ts3.get());


            // ---------------------------------------------------------------------------------
            js.setCamera(camera_of_touka_ura);

            //“§‰ß?}‚Ìsvg
            //System.out.println("paint?@+++++++++++++++++++++?@“§‰ß?}‚Ì•\Ž¦");

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
    public void oritatami_suitei(Camera camera_of_orisen_nyuuryokuzu, Senbunsyuugou Ss0) {//?Ü?ô‚Ý—\‘ª‚Ì?Å?‰‚É?Ats1.Senbunsyuugou2Tensyuugou(Ss0)‚Æ‚µ‚ÄŽg‚¤?B?@Ss0‚Í?Aes1.get_for_oritatami()‚©es1.get_for_select_oritatami()‚Å“¾‚é?B


        int i_camera_settei = 0;


        //-------------------------------?Ü‚è?ã‚ª‚è?}•\Ž¦—pƒJƒ?ƒ‰‚Ì?Ý’è

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
    public void oritatami_suitei_2col(Camera camera_of_orisen_nyuuryokuzu, Senbunsyuugou Ss0) {//‚Q?F“h‚è‚í‚¯“WŠJ?}

        //-------------------------------?Ü‚è?ã‚ª‚è?}•\Ž¦—pƒJƒ?ƒ‰‚Ì?Ý’è

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
        System.out.println("?ƒ?ƒ?ƒ?ƒ?ƒoritatami_suitei_01;ŠJŽn");
        keijiban.tuiki("<<<<oritatami_suitei_01;  start");
        //ƒ}ƒEƒX‚Ì“ü—Í‚Åes1‚Ì’†‚É?ì‚Á‚½?ü•ª?W?‡‚ðts1‚É“n‚µ?A“_?W?‡(“WŠJ?}‚É‘Š“–)‚É‚·‚é
        ts1.Senbunsyuugou2Tensyuugou(Ss1);
        ip3 = ts1.set_kijyunmen_id(ip3);
        ip3 = ts1.set_kijyunmen_id(orihime_ap.ten_of_kijyunmen_old);//20180222?Ü‚è?ü‘I‘ð?ó‘Ô‚Å?Ü‚è?ô‚Ý?„’è‚ð‚·‚é?Û?AˆÈ‘O‚ÉŽw’è‚³‚ê‚Ä‚¢‚½Šî?€–Ê‚ðˆø‚«Œp‚®‚½‚ß‚É’Ç‰Á

        return 1000;
    }


    //-----------------------------------
    public int oritatami_suitei_02() {
        System.out.println("?ƒ?ƒ?ƒ?ƒ?ƒoritatami_suitei_02;ŠJŽn");
        keijiban.tuiki("<<<<oritatami_suitei_02;  start");
        //ts1‚ª?Ü‚è‚½‚½‚Ý‚ð?s‚¢?A‚Å‚«‚½?j‹à?}‚ðts2‚É“n‚·?B
        //ts2‚ª?Ü‚è‚ ‚ª‚Á‚½Œ`‚ð?­‚µ‚¾‚¯•ÏŒ`‚µ‚½‚¢‚æ‚¤‚È?ê?‡‚É“­‚­?B
        ts2.set(ts1.oritatami());
        orihime_ap.keijiban.tuiki("<<<<oritatami_suitei_02; end");

        //ts2.Iti_sitei(0.0 , 0.0);“_?W?‡‚Ì•½‹ÏˆÊ’u‚ð‘S“_‚Ì?d?S‚É‚·‚é?B
        //  if(ip4==1){ ts2.uragaesi();}
        // ts2.set( ts2.oritatami())  ;//?Ü‚è?ô‚ñ‚¾?j‹à?}‚ð?A?Ü‚èŠJ‚«‚½‚¢?ê?‡‚Ì‘€?ì
        //‚±‚±‚Ü‚Å‚Å?j‹à?}‚Í‚Å‚«‚Ä‚¢‚Ä?Ats2‚ªŽ?‚Á‚Ä‚¢‚é?B‚±‚ê‚Í?Aƒ}ƒEƒX‚Å‘€?ì?A•ÏŒ`‚Å‚«‚é?B
        return 1000;
    }

    //-----------------------------------
    public int oritatami_suitei_02col() {//20171225?@‚Q?F“h‚è‚í‚¯‚ð‚·‚é‚½‚ß‚Ì“Á•Ê?„’è?i?Ü‚è?ô‚ÝˆÊ’u‚ð?„’è‚µ‚È‚¢?j
        System.out.println("?ƒ?ƒ?ƒ?ƒ?ƒoritatami_suitei_02;ŠJŽn");
        keijiban.tuiki("<<<<oritatami_suitei_02;  start");
        ts2.set(ts1.men_iti_motome());
        orihime_ap.keijiban.tuiki("<<<<oritatami_suitei_02; end");
        return 1000;
    }

    //-----------------------------------
    public int oritatami_suitei_03() {
        System.out.println("?ƒ?ƒ?ƒ?ƒ?ƒoritatami_suitei_03;ŠJŽn");
        keijiban.tuiki("<<<<oritatami_suitei_03;  start");
        //ts2‚Í?Ü‚é‘O‚Ì“WŠJ?}‚Ì–Ê‚ð•ÛŽ?‚µ‚½“_?W?‡‚ðŽ?‚Á‚Ä‚¢‚é?B
        //?Ü‚è‚½‚½‚ñ‚¾?ê?‡‚Ì–Ê‚Ì?ã‰ºŠÖŒW‚ð?„’è‚·‚é‚É‚Íts2‚ÌŽ?‚Â?j‹à?}‚É‰ž‚¶‚Ä–Ê‚ð
        //?×•ª‚µ‚½?i?×•ª‚µ‚½–Ê‚ðSmen‚ÆŒ¾‚¤‚±‚Æ‚É‚·‚é?j“_?W?‡‚ðŽg‚¤?B
        //‚±‚ÌSmen–Ê‚É•ªŠ„‚µ‚½“_?W?‡‚Íts3‚ªŽ?‚Â‚æ‚¤‚É‚·‚é?B
        //ts2‚ÌŽ?‚Â“_?W?‡‚ðts3‚É“n‚·‘O‚É?Ats2‚ÌŽ?‚Â“_?W?‡‚Í–_‚ª?d‚È‚Á‚Ä‚¢‚½‚è‚·‚é‚©‚à‚µ‚ê‚È‚¢‚Ì‚Å?A
        //‚¢‚Á‚½‚ñks2‚É“n‚µ‚Ä?ü•ª?W?‡‚Æ‚µ‚Ä?®—?‚·‚é?B
        System.out.println("?ƒ?ƒ?ƒ?ƒ?ƒoritatami_suitei_03()_____Šî–{Ž}?E?lks2‚Íts2‚©‚ç?ü•ª?W?‡?i?j‹à?}‚©‚ç‚Å‚«‚½‚à‚Ì?j‚ðŽó‚¯Žæ‚è?A?®—?‚·‚é?B");
        ks2.set(ts2.getSenbunsyuugou());
        System.out.println("?ƒ?ƒ?ƒ?ƒ?ƒoritatami_suitei_03()_____Šî–{Ž}?E?lks2‚ªks2.bunkatu_seiri_for_Smen_hassei;ŽÀŽ{?B");
        ks2.bunkatu_seiri_for_Smen_hassei();//?d‚È‚Á‚½?ü•ª‚âŒð?·‚·‚é?ü•ª?Ü‚è?ô‚Ý?„’è‚È‚Ç‚Å“¾‚ç‚ê‚é?j‹à?}‚Ì?®—?
        //“WŠJ?}?E?lts3‚Íks2‚©‚ç“_?W?‡?its2‚ÌŽ?‚Â?j‹à?}‚ð?®—?‚µ‚½‚à‚Ì?j‚ðŽó‚¯Žæ‚è?ASmen‚É•ªŠ„‚·‚é?B
        System.out.println("?ƒ?ƒ?ƒ?ƒ?ƒoritatami_suitei_03()_____“WŠJ?}?E?lts3‚Íks2‚©‚ç?®—?‚³‚ê‚½?ü•ª?W?‡‚ðŽó‚¯Žæ‚è?ASmen‚É•ªŠ„‚·‚é?B");
        System.out.println("?@?@?@oritatami_suitei_03()‚Ìts3.Senbunsyuugou2Tensyuugou(ks2.get());ŽÀŽ{");
        ts3.Senbunsyuugou2Tensyuugou(ks2.get());

        System.out.println("?ƒ?ƒ?ƒ?ƒ?ƒoritatami_suitei_03()_____?ã‰º•\?E?ljs‚Í?A“WŠJ?}?E?lts3‚©‚ç“_?W?‡‚ðŽó‚¯Žæ‚è?ASmen‚ð?Ý’è‚·‚é?B");
        js.Smen_settei(ts1, ts2.get(), ts3.get());
        //‚±‚±‚Ü‚Å‚Å“§‰ß?}‚Â‚­‚ë‚¤‚ÆŽv‚¦‚Î?ì‚ê‚é?B“§‰ß?}‚ÍSmen?}‚É”Z“x‚ð‚Â‚¯‚½‚à‚Ì?B
        return 1000;
    }

    //-----------------------------------
    public int oritatami_suitei_04() {
        System.out.println("?ƒ?ƒ?ƒ?ƒ?ƒoritatami_suitei_04;ŠJŽn");
        keijiban.tuiki("<<<<oritatami_suitei_04;  start");
        //–Ê(?Ü‚è‚½‚½‚Þ‘O‚Ì“WŠJ?}‚Ì–Ê‚Ì‚±‚Æ)‚Ì?ã‰º•\‚ð?ì‚é?B
        //‚±‚ê‚É‚Íts2‚ÌŽ?‚Â“_?W?‡?i?Ü‚è‚½‚½‚ñ‚¾‚ ‚Æ‚Ì–Ê‚ÌˆÊ’uŠÖŒW‚Ì?î•ñ‚ðŽ?‚Â?j‚Æ
        //ts3‚ÌŽ?‚Â“_?W?‡?i?j‹à?}‚Å–Ê‚ð?×•ªŠ„‚µ‚½Smen‚Ì?î•ñ‚ðŽ?‚Â?j‚ðŽg‚¤?B
        //‚Ü‚½?Ats1‚ÌŽ?‚Â?A?Ü‚Á‚½‚Æ‚«‚Ì–Ê‚ÌˆÊ’uŠÖŒW‚Ì?î•ñ‚àŽg‚¤?B
        System.out.println("?ƒ?ƒ?ƒ?ƒ?ƒoritatami_suitei_04()_____?ã‰º•\?E?ljs‚ª–Ê(?Ü‚è‚½‚½‚Þ‘O‚Ì“WŠJ?}‚Ì–Ê‚Ì‚±‚Æ)‚Ì?ã‰º•\‚ð?ì‚é?B");

        ip1 = 0;
        betu_sagasi_flg = 0;
        ip1 = js.Jyougehyou_settei(ts1, ts2.get(), ts3.get());   //ip1=?Ü‚Á‚½Œã‚Ì•\— ‚ª“¯‚¶–Ê‚ª—×?Ú‚·‚é‚Æ‚¢‚¤Œë‚è‚ª‚ ‚ê‚Î0‚ð?A–³‚¯‚ê‚Î1000‚ðŠi”[‚·‚é•Ï?”?B
        if (ip1 == 1000) {
            ip1 = 1000;
            betu_sagasi_flg = 1;
        }
        hakkenn_sita_kazu = 0;
        System.out.println("?ƒ?ƒ?ƒ?ƒ?ƒoritatami_suitei_04()____?I—¹");
        return 1000;
    }


    //-----------------------------------
    public int oritatami_suitei_05() {
        System.out.println("?ƒ?ƒ?ƒ?ƒ?ƒoritatami_suitei_05()_____?ã‰º•\?E?ljs‚ªjs.kanou_kasanari_sagasi()ŽÀŽ{?B");
        orihime_ap.keijiban.tuiki("<<<<oritatami_suitei_05()  ___js.kanou_kasanari_sagasi()  start");

        if ((i_suitei_dankai == 4) || (i_suitei_dankai == 5)) {
            if (betu_sagasi_flg == 1) {

                ip2 = js.kanou_kasanari_sagasi();//ip2=?ã‰º•\?E?l‚ª?Ü‚è?ô‚Ý‰Â”\‚È?d‚È‚è•û‚ð’T‚µ‚½?Û‚É?A‰Â”\‚È?d‚È‚è•û‚ª‚È‚¯‚ê‚Î0‚ð?A‰Â”\‚È?d‚È‚è•û‚ª‚ ‚ê‚Î1000‚ðŠi”[‚·‚é•Ï?”?B

                if (ip2 == 1000) {
                    hakkenn_sita_kazu = hakkenn_sita_kazu + 1;
                }

                ip5 = js.susumu(js.getSmen_yuukou_suu());//ŽŸ‚Ì?d‚È‚è’T‚µ‚Ì?€”õ//ip5=0‚È‚ç?V‚½‚Ésusumu—]’n‚ª‚È‚©‚Á‚½?B0ˆÈŠO‚È‚ç•Ï‰»‚µ‚½Smen‚Ìid‚Ì?Å‚à?¬‚³‚¢”Ô?†
            }
        }
        orihime_ap.keijiban.clear();

        text_kekka = "Number of found solutions = " + orihime_ap.c.valueOf(hakkenn_sita_kazu) + "  ";

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
    }    //20180819ƒoƒO?C?³?@“§‰ß“x‚Ì?Å‘å’l‚ª‚±‚ê‚Ü‚Å128‚Å?Aƒvƒ?ƒOƒ‰ƒ€‚Å?ü‚Ì•`‰æŽž‚É‚Q”{‚·‚é‚Æ‚­?A256‚Æ‚È‚è?A“§‰ß“x‚Ì?ãŒÀ255ƒI?[ƒo?[‚Å?AƒIƒŠƒqƒ?Ž©‘Ì‚ª
    //ƒtƒŠ?[ƒY‚µ‚½?B‚±‚ê‚Í?A128‚ð127‚Ì•Ï‚¦‚é‚±‚Æ‚Å‚àƒtƒŠ?[ƒY‚Í‚È‚­‚È‚é‚ª?A“§‰ß“x‚Í‚Q‚Ì”{?”‚É‚µ‚Ä‚¨‚©‚È‚¢‚Æ?A2•ª‚Ìˆê‚É‚µ‚½‚Æ‚«’l‚ª‚¸‚ê‚é‚©‚à‚µ‚ê‚È‚¢‚Ì‚Å?A“§‰ß“x‚Ì?Å‘å’l‚Í64‚Æ‚µ‚Ä‚¨‚­‚±‚Æ‚É‚·‚é?B


    private final Ten p_m_left_on = new Ten();//ƒ}ƒEƒX‚Ì?¶ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«‚Ì?À•W
    private int i_nanini_tikai = 0;//Ten p‚ª“WŠJ?}‚Ì“_‚É‹ß‚¢=1?A?Ü‚è?ã‚ª‚è?}‚Ì“_‚É‹ß‚¢=2?A‚Ç‚¿‚ç‚É‚à‹ß‚­‚È‚¢=0
    private int i_mottomo_tikai_Tenid;
    private int i_ten_sentaku = 0;//ts1?Ats2‚Æ‚à‚É–¢‘I‘ð?i?ó‹µ?@i_ten_sentaku=0?j,ts1‘I‘ð?Ï‚Åts2–¢‘I‘ð?i?ó‹µ?@i_ten_sentaku=1?j,‚»‚Ì’¸“_‚ªts2‘I‘ð?Ï?i?ó‹µ?@i_ten_sentaku=2?j
    private final Ten ugokasu_maeno_sentaku_ten = new Ten();//“®‚©‚·‘O‚Ì‘I‘ð‚µ‚½“_‚Ì?À•W


    //-----------------------------------------------------------------------------------------------------uuuuuuu--
    public void oriagari_sousa_mouse_on(Ten p) {//?Ü‚è?ã‚ª‚è?}‘€?ì‚Åƒ}ƒEƒX‚Ì?¶ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«‚Ì?ì‹Æ
        if (i_oriagari_sousa_mode == 1) {
            oriagari_sousa_mouse_on_1(p);
        }
        if (i_oriagari_sousa_mode == 2) {
            oriagari_sousa_mouse_on_2(p);
        }
    }

    public void oriagari_sousa_mouse_drag(Ten p) {//?Ü‚è?ã‚ª‚è?}‘€?ì‚Åƒ}ƒEƒX‚Ì?¶ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Ü‚Üƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«‚Ì?ì‹Æ
        if (i_oriagari_sousa_mode == 1) {
            oriagari_sousa_mouse_drag_1(p);
        }
        if (i_oriagari_sousa_mode == 2) {
            oriagari_sousa_mouse_drag_2(p);
        }
    }


    public void oriagari_sousa_mouse_off(Ten p) {//?Ü‚è?ã‚ª‚è?}‘€?ì‚Åƒ}ƒEƒX‚Ì?¶ƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«‚Ì?ì‹Æ
        if (i_oriagari_sousa_mode == 1) {
            oriagari_sousa_mouse_off_1(p);
        }
        if (i_oriagari_sousa_mode == 2) {
            oriagari_sousa_mouse_off_2(p);
        }
    }


    //  =================================================================================================================================
    //-----------------------------------------------------------------------------------------------------uuuuuuu--
    public void oriagari_sousa_mouse_on_1(Ten p) {//?Ü‚è?ã‚ª‚è?}‘€?ì‚Åƒ}ƒEƒX‚Ì?¶ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«‚Ì?ì‹Æ   ?Ü‚è‚¸‚ç‚µ‹@”\

        p_m_left_on.set(new Ten(p.getx(), p.gety()));

        ts2.setCamera(camera_of_oriagarizu);
        ts2.setCam_omote(camera_of_oriagari_omote);
        ts2.setCam_ura(camera_of_oriagari_ura);

        //i_mottomo_tikai_Tenid‚Ép‚É?Å‚à‹ß‚¢“_‚Ì”Ô?†‚ðŠi”[?B‹ß‚¢“_‚ª‚Ü‚Á‚½‚­‚È‚¢?ê?‡‚Íi_mottomo_tikai_Tenid=0
        i_nanini_tikai = 0;//“WŠJ?}‚Ì“_‚É‹ß‚¢=1?A?Ü‚è?ã‚ª‚è?}‚Ì“_‚É‹ß‚¢=2?A‚Ç‚¿‚ç‚É‚à‹ß‚­‚È‚¢=0
        i_mottomo_tikai_Tenid = ts1.mottomo_tikai_Tenid_with_camera(p);
        if (i_mottomo_tikai_Tenid != 0) {
            i_nanini_tikai = 1;
        }
        if (ts2.mottomo_tikai_Tenid_with_camera(p, ip4) != 0) {
            if (ts1.mottomo_tikai_Ten_kyori_with_camera(p) > ts2.mottomo_tikai_Ten_kyori_with_camera(p, ip4)) {
                i_mottomo_tikai_Tenid = ts2.mottomo_tikai_Tenid_with_camera(p, ip4);
                i_nanini_tikai = 2;
            }
        }//i_mottomo_tikai_Tenid‚Ép‚É?Å‚à‹ß‚¢“_‚Ì”Ô?†‚ðŠi”[ ‚±‚±‚Ü‚Å

        ugokasu_maeno_sentaku_ten.set(ts2.getTen(i_mottomo_tikai_Tenid));


        System.out.println("i_nanini_tikai = " + i_nanini_tikai);

        if (i_nanini_tikai == 1) {

            //i_ten_sentaku‚ðŒˆ‚ß‚é
            i_ten_sentaku = 0;
            if (ts1.get_ten_sentaku(i_mottomo_tikai_Tenid) == 1) {
                i_ten_sentaku = 1;
            }
            if (ts2.get_ten_sentaku(i_mottomo_tikai_Tenid) == 1) {
                i_ten_sentaku = 2;
            }
            //i_ten_sentaku‚ðŒˆ‚ß‚é  ‚±‚±‚Ü‚Å


            if (i_ten_sentaku == 0) {
                set_all_ten_sentaku_0();
                //?Ü‚è?ã‚ª‚è?}‚Åi_mottomo_tikai_Tenid‚Æ“¯‚¶ˆÊ’u‚Ì“_‚Ì”Ô?†‚ð‹?‚ß?Ats1‚Å‚»‚Ì”Ô?†‚Ì“_‚ð‘I‘ð?Ï‚Ý‚É‚·‚é
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

            //i_ten_sentaku‚ðŒˆ‚ß‚é
            i_ten_sentaku = 0;
            if (ts1.get_ten_sentaku(i_mottomo_tikai_Tenid) == 1) {
                i_ten_sentaku = 1;
                if (ts2.get_ten_sentakusuu() > 0) {
                    i_ten_sentaku = 2;
                }    //?Ü?}?ã‚ÅŽw’è‚µ‚½“_‚Å?A‚»‚±‚É?d‚È‚é‚¢‚¸‚ê‚©‚Ì“_‚ªts2‚Å‘I‘ð‚³‚ê‚Ä‚¢‚é?B—v‚·‚é‚É?Ü?}?ã‚Ì—Î•\Ž¦‚³‚ê‚Ä‚¢‚é“_‚ð‘I‚ñ‚¾?ó‘Ô
            }
            //i_ten_sentaku‚ðŒˆ‚ß‚é  ‚±‚±‚Ü‚Å
            System.out.println("i_ten_sentaku = " + i_ten_sentaku);

            if (i_ten_sentaku == 0) {
                set_all_ten_sentaku_0();

                //?Ü‚è?ã‚ª‚è?}‚Åi_mottomo_tikai_Tenid‚Æ“¯‚¶ˆÊ’u‚Ì“_‚Ì”Ô?†‚ð‹?‚ß?Ats1‚Å‚»‚Ì”Ô?†‚Ì“_‚ð‘I‘ð?Ï‚Ý‚É‚·‚é
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

                hyouji_flg_backup = hyouji_flg;   //20180216  //hyouji_flg‚Í?A?Ü‚è?ã‚ª‚è?}‚Ì•\Ž¦—lŽ®‚ÌŽw’è?B4‚È‚çŽÀ?Û‚É?Ü‚èŽ†‚ð?Ü‚Á‚½?ê?‡‚Æ“¯‚¶?B3‚È‚ç“§‰ß?}?B2‚È‚ç?j‹à?}?B
                hyouji_flg = 2;            //20180216
            }


        }


        System.out.println("ts1.get_ten_sentakusuu() = " + ts1.get_ten_sentakusuu());
        System.out.println("ts2.get_ten_sentakusuu() = " + ts2.get_ten_sentakusuu());


    }

    //-------------
    public void oriagari_sousa_mouse_drag_1(Ten p) {//?Ü‚è?ã‚ª‚è?}‘€?ì‚Åƒ}ƒEƒX‚Ì?¶ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Ü‚Üƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«‚Ì?ì‹Æ

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
    public void oriagari_sousa_mouse_off_1(Ten p) {//?Ü‚è?ã‚ª‚è?}‘€?ì‚Åƒ}ƒEƒX‚Ì?¶ƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«‚Ì?ì‹Æ
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
                }//ƒIƒŠƒWƒiƒ‹ 20180124 ‚±‚êˆÈŠO‚¾‚Æ?A•\Ž¦‚¢‚Á‚½‚ñ‚à‚Ç‚é‚æ‚¤‚Å‚¤‚´‚¢
            }


            ts1.set_all_ten_sentaku_0();
            //?Ü‚è?ã‚ª‚è?}‚Åi_mottomo_tikai_Tenid‚Æ“¯‚¶ˆÊ’u‚Ì“_‚Ì”Ô?†‚ð‹?‚ß?Ats1‚Å‚»‚Ì”Ô?†‚Ì“_‚ð‘I‘ð?Ï‚Ý‚É‚·‚é
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
//  ==========?Ü‚è?ã‚ª‚è?}‚Ì‚Ü‚Ü•ÏŒ`‘€?ì===========================================================================================================
    //-----------------------------------------------------------------------------------------------------uuuuuuu--
    public void oriagari_sousa_mouse_on_2(Ten p) {//?Ü‚è?ã‚ª‚è?}‘€?ì‚Åƒ}ƒEƒX‚Ì?¶ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Æ‚«‚Ì?ì‹Æ

        p_m_left_on.set(new Ten(p.getx(), p.gety()));

        ts2.setCamera(camera_of_oriagarizu);
        ts2.setCam_omote(camera_of_oriagari_omote);
        ts2.setCam_ura(camera_of_oriagari_ura);

        //i_mottomo_tikai_Tenid‚Ép‚É?Å‚à‹ß‚¢“_‚Ì”Ô?†‚ðŠi”[?B‹ß‚¢“_‚ª‚Ü‚Á‚½‚­‚È‚¢?ê?‡‚Íi_mottomo_tikai_Tenid=0
        i_nanini_tikai = 0;//“WŠJ?}‚Ì“_‚É‹ß‚¢=1?A?Ü‚è?ã‚ª‚è?}‚Ì“_‚É‹ß‚¢=2?A‚Ç‚¿‚ç‚É‚à‹ß‚­‚È‚¢=0
        i_mottomo_tikai_Tenid = ts1.mottomo_tikai_Tenid_with_camera(p);
        if (i_mottomo_tikai_Tenid != 0) {
            i_nanini_tikai = 1;
        }
        if (ts2.mottomo_tikai_Tenid_with_camera(p, ip4) != 0) {
            if (ts1.mottomo_tikai_Ten_kyori_with_camera(p) > ts2.mottomo_tikai_Ten_kyori_with_camera(p, ip4)) {
                i_mottomo_tikai_Tenid = ts2.mottomo_tikai_Tenid_with_camera(p, ip4);
                i_nanini_tikai = 2;
            }
        }//i_mottomo_tikai_Tenid‚Ép‚É?Å‚à‹ß‚¢“_‚Ì”Ô?†‚ðŠi”[ ‚±‚±‚Ü‚Å

        ugokasu_maeno_sentaku_ten.set(ts2.getTen(i_mottomo_tikai_Tenid));


        System.out.println("i_nanini_tikai = " + i_nanini_tikai);

        if (i_nanini_tikai == 1) {

            //i_ten_sentaku‚ðŒˆ‚ß‚é
            i_ten_sentaku = 0;
            if (ts1.get_ten_sentaku(i_mottomo_tikai_Tenid) == 1) {
                i_ten_sentaku = 1;
            }
            if (ts2.get_ten_sentaku(i_mottomo_tikai_Tenid) == 1) {
                i_ten_sentaku = 2;
            }
            //i_ten_sentaku‚ðŒˆ‚ß‚é  ‚±‚±‚Ü‚Å


            if (i_ten_sentaku == 0) {
                set_all_ten_sentaku_0();
                //?Ü‚è?ã‚ª‚è?}‚Åi_mottomo_tikai_Tenid‚Æ“¯‚¶ˆÊ’u‚Ì“_‚Ì”Ô?†‚ð‹?‚ß?Ats1‚Å‚»‚Ì”Ô?†‚Ì“_‚ð‘I‘ð?Ï‚Ý‚É‚·‚é
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

            //i_ten_sentaku‚ðŒˆ‚ß‚é
            i_ten_sentaku = 0;
            if (ts1.get_ten_sentaku(i_mottomo_tikai_Tenid) == 1) {
                i_ten_sentaku = 1;
                if (ts2.get_ten_sentakusuu() > 0) {
                    i_ten_sentaku = 2;
                }    //?Ü?}?ã‚ÅŽw’è‚µ‚½“_‚Å?A‚»‚±‚É?d‚È‚é‚¢‚¸‚ê‚©‚Ì“_‚ªts2‚Å‘I‘ð‚³‚ê‚Ä‚¢‚é?B—v‚·‚é‚É?Ü?}?ã‚Ì—Î•\Ž¦‚³‚ê‚Ä‚¢‚é“_‚ð‘I‚ñ‚¾?ó‘Ô
            }
            //i_ten_sentaku‚ðŒˆ‚ß‚é  ‚±‚±‚Ü‚Å
            System.out.println("i_ten_sentaku = " + i_ten_sentaku);

            if (i_ten_sentaku == 0) {
                set_all_ten_sentaku_0();

                //?Ü‚è?ã‚ª‚è?}‚Åi_mottomo_tikai_Tenid‚Æ“¯‚¶ˆÊ’u‚Ì“_‚Ì”Ô?†‚ð‹?‚ß?Ats1‚Å‚»‚Ì”Ô?†‚Ì“_‚ð‘I‘ð?Ï‚Ý‚É‚·‚é
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

                hyouji_flg_backup = hyouji_flg;   //20180216  //hyouji_flg‚Í?A?Ü‚è?ã‚ª‚è?}‚Ì•\Ž¦—lŽ®‚ÌŽw’è?B4‚È‚çŽÀ?Û‚É?Ü‚èŽ†‚ð?Ü‚Á‚½?ê?‡‚Æ“¯‚¶?B3‚È‚ç“§‰ß?}?B2‚È‚ç?j‹à?}?B
                hyouji_flg = 2;            //20180216
            }


        }


        System.out.println("ts1.get_ten_sentakusuu() = " + ts1.get_ten_sentakusuu());
        System.out.println("ts2.get_ten_sentakusuu() = " + ts2.get_ten_sentakusuu());


    }

    //-------------
    public void oriagari_sousa_mouse_drag_2(Ten p) {//?Ü‚è?ã‚ª‚è?}‘€?ì‚Åƒ}ƒEƒX‚Ì?¶ƒ{ƒ^ƒ“‚ð‰Ÿ‚µ‚½‚Ü‚Üƒhƒ‰ƒbƒO‚µ‚½‚Æ‚«‚Ì?ì‹Æ

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
    public void oriagari_sousa_mouse_off_2(Ten p) {//?Ü‚è?ã‚ª‚è?}‘€?ì‚Åƒ}ƒEƒX‚Ì?¶ƒ{ƒ^ƒ“‚ð—£‚µ‚½‚Æ‚«‚Ì?ì‹Æ
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
                //if(hyouji_flg==5){i_suitei_meirei=5;orihime_ap.oritatami_suitei();}//ƒIƒŠƒWƒiƒ‹ 20180124 ‚±‚êˆÈŠO‚¾‚Æ?A•\Ž¦‚¢‚Á‚½‚ñ‚à‚Ç‚é‚æ‚¤‚Å‚¤‚´‚¢
//}
//if(i_oriagari_sousa_mode==2){
                oritatami_suitei_03();//20180216
//}


            }
            //ts2. set_all_ten_sentaku_0();

            //}
            ts1.set_all_ten_sentaku_0();
            //?Ü‚è?ã‚ª‚è?}‚Åi_mottomo_tikai_Tenid‚Æ“¯‚¶ˆÊ’u‚Ì“_‚Ì”Ô?†‚ð‹?‚ß?Ats1‚Å‚»‚Ì”Ô?†‚Ì“_‚ð‘I‘ð?Ï‚Ý‚É‚·‚é
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

