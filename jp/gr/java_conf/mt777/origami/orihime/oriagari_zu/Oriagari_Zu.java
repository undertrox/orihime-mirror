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

//public class Oriagari_Zu extends Oriagari_Zu_00 {//Oriagari_Zuªî{ÆÈé?Ü?ãªè\ªASY

public class Oriagari_Zu {

    ap orihime_ap;

    OritaCalc oc = new OritaCalc();
    Moji_sousa ms = new Moji_sousa(); //¶ñ??pÌÖ???Wß½NX

    double r = 3.0;                   //î{}?\¢Ì¼??Ì¼[Ì~Ì¼a?A}Æeí|CgÌß³Ì»èî??


    public double d_oriagarizu_syukusyaku_keisuu = 1.0;//?Üè?ãªè?}Ì?kÚW??
    public double d_oriagarizu_kaiten_hosei = 0.0;//?Üè?ãªè?}Ìñ]\¦pxÌâ?³px

    public Kihonshi_Syokunin ks2 = new Kihonshi_Syokunin(r);    //î{}?E?l?Bts2Ì??Â_?W?ðts3Én·OÉ?A
    //ts2Ì??Â_?W?Í_ª?dÈÁÄ¢½è·é©àµêÈ¢ÌÅ?A
    //¢Á½ñks2ÉnµÄ??ª?W?ÆµÄ?®??·é?B

    public Tenkaizu_Syokunin ts1 = new Tenkaizu_Syokunin(r);    //WJ?}?E?l?BüÍ³ê½??ª?W???Å?É?ÜÁÄ?jà?óÌ_?W?Ì?Üè?ãªè?}ð??é
    public Tenkaizu_Syokunin ts2 = new Tenkaizu_Syokunin(r);    //WJ?}?E?l?Bts1Ì??Á½?jà?óÌ_?W?Ì?Üè?ãªè?}ðÛ??µ?A??ª?W?É·éÈÇÌ­«ð·é?B
    public Tenkaizu_Syokunin ts3 = new Tenkaizu_Syokunin(r);    //WJ?}?E?l?Bts1Ì??Á½?jà?óÌ_?W???®??µ?B?V½ÉÊðF¯·éÈÇÌ­«ð??Â?B

    public Jyougehyou_Syokunin js;
    //public Jyougehyou_Syokunin js      = new Jyougehyou_Syokunin();
    //public Jyougehyou_Syokunin(ap ap0){ orihime_ap=ap0;    reset();	}    //RXgN^

    public Camera camera_of_oriagarizu = new Camera();
    public Camera camera_of_oriagari_omote = new Camera();
    public Camera camera_of_oriagari_ura = new Camera();
    public Camera camera_of_touka_omote = new Camera();
    public Camera camera_of_touka_ura = new Camera();

    public Color oriagarizu_F_color = new Color(255, 255, 50);//?Üè?ãªè?}Ì\ÊÌ?F
    public Color oriagarizu_B_color = new Color(233, 233, 233);//?Üè?ãªè?}Ì ÊÌ?F
    public Color oriagarizu_L_color = Color.black;//?Üè?ãªè?}Ì??Ì?F

    public int hyouji_flg_backup = 4;//\¦l®hyouji_flgÌêIobNAbvp
    //int hyouji_flg_backup=4;//\¦l®hyouji_flgÌêIobNAbvp
    public int hyouji_flg = 0;//?Üè?ãªè?}Ì\¦l®Ìwè?B1ÈçWJ?}?®???A2Èç?jà?}?B3Èç§ß?}?B4ÈçÀ?ÛÉ?Üèð?ÜÁ½???Æ¯¶?B
    public int i_suitei_meirei = 0;//?Üè?ôÝ??èðÇÌiKÜÅ?s¤©Ìw¦
    public int i_suitei_dankai = 0;//?Üè?ôÝ??èªÇÌiKÜÅÅ«½©Ì\¦
    //public int i_suitei_jissi_umu=0;//int i_suitei_jissi_umuÍ?A?Üè?ôÝ??èÌvZðÀ{µ½©Ç¤©ð\·?Bint i_suitei_jissi_umu=0ÈçÀ{µÈ¢?B1ÈçÀ{µ½?B


    //\¦pÌlði[·éÏ??
    public int ip1 = -1;//?ãº\?E?lÌ???ÝèÉ?A?ÜÁ½ãÌ\ ª¯¶Êª
    //×?Ú·éÆ¢¤ë?·ª êª0ð?A³¯êÎ1000ði[·éÏ???B
    //±±ÅÌ?úlÍ(0©1000)ÈOÌ?ÈçÈñÅà¢¢?B
    public int ip2 = -1;//?ãº\?E?lª?Üè?ôÝÂ\È?dÈèûðTµ½?ÛÉ?A
    //Â\È?dÈèûªÈ¯êÎ0ð?AÂ\È?dÈèûª êÎ1000ði[·éÏ???B
    //±±ÅÌ?úlÍ(0©1000)ÈOÌ?ÈçÈñÅà¢¢?B
    //int ip3a=1;
    public int ip3 = 1;//ts1ª?Üè?ôÝð?s¤?ÛÌî??Êðwè·éÌÉg¤?B

    public int ip4 = 0;//±êÍ?Ats1Ì?Å?É Ôµð·é©Ç¤©ðwè·é?B0ÈçµÈ¢?B1Èç Ô·?B

    public int ip5 = -1;    //?ãº\?E?lªêU?Üè?ôÝÂ\ÈÌ?dÈèð¦µ½ ÆÅ?A
    //³çÉÊÌÌ?dÈèð³ª·Ì?Å?Ìjs.susumu(Smensuu)ÌÊ?B
    //0Èç?V½Ésusumu]nªÈ©Á½?B0ÈOÈçÏ»µ½SmenÌidÌ?Åà?¬³¢Ô??

    public int ip6 = -1;    //?ãº\?E?lªêU?Üè?ôÝÂ\ÈÌ?dÈèð¦µ½ ÆÅ?A
    //³çÉÊÌÌ?dÈèð³ª·Ì js.kanou_kasanari_sagasi()ÌÊ?B
    //0ÈçÂ\È?dÈè©½ÆÈé?óÔÍ¶?ÝµÈ¢?B
    //1000ÈçÊÌ?dÈèûª©Â©Á½?B

    public int betu_sagasi_flg = 0;     //±êÍ?uÊÌ?dÈèðT·?v±ÆªLøÌ???ÍP?A³øÌ???ÍOðÆé?B
    public int hakkenn_sita_kazu = 0;    //?Üè?dÈèûÅ?A½Êè­©µ½©ði[·é?B


    //public int i_AS_matome =100;//?Ü?ôÝ??èÌÊððÜÆßÄ?o·Â??//20171217 ver3.030ÅÍgíêÄ¢È¢?B


    public int toukazu_toukado = 16;//§ß?}ðJ?[`æ·é?ÛÌ§ßx


    public int i_oriagari_sousa_mode = 1;//1=Ï`Í?jà?}ÉÈè?AÏ`ãÉ?ãº\ð?ÄvZ·é?A©çÌ?[h?A2=Ï`à?Üè?ãªè?}ÌÜÜÅ?Aî{IÉÏ`ãÉ?ãº\Í?ÄvZµÈ¢?[h


    //public Keijiban keijiban =new Keijiban(this);
    public Keijiban keijiban;


    public boolean w_image_jikkoutyuu = false;//?Ü?ôÝÜÆßÀ?sÌ?BPêñÌC???[W?«?oµªÀ?sÈçtureÉÈé?B
    public boolean matome_write_image_jikkoutyuu = false;//matome_write_imageªÀ?sÈçtureÉÈé?B±êÍ?A¡?Ì?Üè ªè`Ì\ªÌ?«?oµª©·êÈ¢æ¤Ég¤?B20170613

    String fname_and_number;//ÜÆß?«?oµÉg¤?B


    //eíÏ?Ìè`
    String c = "";                //¶ñ????pÌNXÌCX^X»
    public String text_kekka = "";                //Ê\¦p¶ñÌNXÌCX^X»


    int i_fold_type = 0;//=0ÍÊ?úÌWJ?}ÌS?Ü??ðÎ?ÛÆµ½?Üè?ôÝ??è?A=1Íselect³ê½?Ü??ðÎ?ÛÆµ½?Üè?ôÝ??è?A


    public int i_toukazu_color = 0;//§ß?}ðJ?[É·éÈçP?AµÈ¢ÈçO


    // **************************************************
//RXgN^
    public Oriagari_Zu(ap ap0) {

        orihime_ap = ap0;

        js = new Jyougehyou_Syokunin(ap0);
        keijiban = new Keijiban(ap0);

        //J??Ì?Ýè ------------------------------------------------------------------
        oriagari_camera_syokika();
        //J??Ì?ÝèÍ±±ÜÅ----------------------------------------------------


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

        //oriagari_camera_syokika();		//20170615 À?sµÈ¢æ¤Éµ½?i?Üè ªè?}Ì\¦?óµðÏ¦È¢æ¤É·é½ß?j
        //ts2.setCamera(camera_of_oriagarizu);	//20170615 À?sµÈ¢æ¤Éµ½?i?Üè ªè?}Ì\¦?óµðÏ¦È¢æ¤É·é½ß?j
        //js.setCamera(camera_of_oriagarizu);	//20170615 À?sµÈ¢æ¤Éµ½?i?Üè ªè?}Ì\¦?óµðÏ¦È¢æ¤É·é½ß?j

        hyouji_flg = 0;//?Üè?ãªè?}Ì\¦l®Ìwè?B1ÈçWJ?}?®???A2Èç?jà?}?B3Èç§ß?}?B5ÈçÀ?ÛÉ?Üèð?ÜÁ½???Æ¯¶?B
        i_suitei_meirei = 0;//?Üè?ôÝ??èðÇÌiKÜÅ?s¤©Ìw¦
        i_suitei_dankai = 0;//?Üè?ôÝ??èªÇÌiKÜÅÅ«½©Ì\¦
        betu_sagasi_flg = 0;

        matome_write_image_jikkoutyuu = false; //¡?Ì?Üè ªè`Ì\ªÌ?«?oµªªÀ?sÈçtureÉÈé?B20170615


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


        //?Üè?ãªè?}Ì\¦Íjsª?s¤ÌÅ\¦©ÌÍts2ÉJ??ðZbg·éKvÍÈ¢ª?A»Ìã?AæÊNbNðts2ª»èµ½è·éÌÅts2ÌJ???X?VÍ\¦Æ¯úµÄ?s¤Kvª é?B
        ts2.setCamera(camera_of_oriagarizu);
        ts2.setCam_omote(camera_of_oriagari_omote);
        ts2.setCam_ura(camera_of_oriagari_ura);
        ts2.setCam_touka_omote(camera_of_touka_omote);
        ts2.setCam_touka_ura(camera_of_touka_ura);


        //?jà?}Ì\¦
        //System.out.println("paint?@+++++++++++++++++++++?@?jà?}Ì\¦");
        if (hyouji_flg == 2) {
            ts2.oekaki_with_camera(bufferGraphics, ip4);//?Üè?ãªè?}Ì??Í±Ìts2Ì?jà?}ð®©·?B
        }

        //?Üè ªè?}?i\?jÌ\¦
        if (((ip4 == 0) || (ip4 == 2)) || (ip4 == 3)) {
            js.setCamera(camera_of_oriagari_omote);

            //§ß?}Ì\¦
            //System.out.println("paint?@+++++++++++++++++++++?@§ß?}Ì\¦");
            if (hyouji_flg == 3) {        // hyouji_flg;?Üè?ãªè?}Ì\¦l®Ìwè?BPÈçÀ?ÛÉ?Üèð?ÜÁ½???Æ¯¶?BQÈç§ß?}?B3Èç?jà?}?B
                js.oekaki_toukazu_with_camera(bufferGraphics, ts1, ts2.get(), ts3.get(), i_toukazu_color, toukazu_toukado);
            }

            //?Üè?ãªè?}Ì\¦************* //System.out.println("paint?@+++++++++++++++++++++?@?Üè?ãªè?}Ì\¦");
            if (hyouji_flg == 5) {
                js.oekaki_oriagarizu_with_camera(bufferGraphics, ts1, ts2.get(), ts3.get());// hyouji_flg;?Üè?ãªè?}Ì\¦l®Ìwè?B5ÈçÀ?ÛÉ?Üèð?ÜÁ½???Æ¯¶?B3Èç§ß?}?B2Èç?jà?}?B
            }

            //?Üè?ãªè?}Ì®©µ?SÌ?\\¦
            //System.out.println("paint?@+++++++++++++++++++++?@?Üè?ãªè?}Ì®©µ?SÌ?\\¦)");
            if (i_mejirusi_hyouji == 1) {
                js.oekaki_jyuuji_with_camera(bufferGraphics);
            }
        }

        //?Üè ªè?}?i ?jÌ\¦
        if (((ip4 == 1) || (ip4 == 2)) || (ip4 == 3)) {
            camera_of_oriagari_ura.hyouji();
            js.setCamera(camera_of_oriagari_ura);

            //§ß?}Ì\¦
            //System.out.println("paint?@+++++++++++++++++++++?@§ß?}Ì\¦");
            if (hyouji_flg == 3) {        // hyouji_flg;?Üè?ãªè?}Ì\¦l®Ìwè?BPÈçÀ?ÛÉ?Üèð?ÜÁ½???Æ¯¶?BQÈç§ß?}?B3Èç?jà?}?B
                js.oekaki_toukazu_with_camera(bufferGraphics, ts1, ts2.get(), ts3.get(), i_toukazu_color, toukazu_toukado);
            }

            //?Üè?ãªè?}Ì\¦************* //System.out.println("paint?@+++++++++++++++++++++?@?Üè?ãªè?}Ì\¦");
            if (hyouji_flg == 5) {
                js.oekaki_oriagarizu_with_camera(bufferGraphics, ts1, ts2.get(), ts3.get());// hyouji_flg;?Üè?ãªè?}Ì\¦l®Ìwè?B5ÈçÀ?ÛÉ?Üèð?ÜÁ½???Æ¯¶?B3Èç§ß?}?B2Èç?jà?}?B
            }

            //?Üè?ãªè?}Ì®©µ?SÌ?\\¦
            //System.out.println("paint?@+++++++++++++++++++++?@?Üè?ãªè?}Ì®©µ?SÌ?\\¦)");
            if (i_mejirusi_hyouji == 1) {
                js.oekaki_jyuuji_with_camera(bufferGraphics);
            }
        }

        //§ß?}?i?Üè ªè?}\¦ÉÇÁ·éª?j
        if ((ip4 == 3) && (hyouji_flg == 5)) {
            // ---------------------------------------------------------------------------------
            js.setCamera(camera_of_touka_omote);
            //§ß?}Ì\¦
            //System.out.println("paint?@+++++++++++++++++++++?@§ß?}Ì\¦");
            js.oekaki_toukazu_with_camera(bufferGraphics, ts1, ts2.get(), ts3.get(), i_toukazu_color, toukazu_toukado);

            //?Üè?ãªè?}Ì®©µ?SÌ?\\¦
            //System.out.println("paint?@+++++++++++++++++++++?@?Üè?ãªè?}Ì®©µ?SÌ?\\¦)");
            if (i_mejirusi_hyouji == 1) {
                js.oekaki_jyuuji_with_camera(bufferGraphics);
            }

            // ---------------------------------------------------------------------------------
            js.setCamera(camera_of_touka_ura);

            //§ß?}Ì\¦
            //System.out.println("paint?@+++++++++++++++++++++?@§ß?}Ì\¦");
            js.oekaki_toukazu_with_camera(bufferGraphics, ts1, ts2.get(), ts3.get(), i_toukazu_color, toukazu_toukado);

            //?Üè?ãªè?}Ì®©µ?SÌ?\\¦
            //System.out.println("paint?@+++++++++++++++++++++?@?Üè?ãªè?}Ì®©µ?SÌ?\\¦)");
            if (i_mejirusi_hyouji == 1) {
                js.oekaki_jyuuji_with_camera(bufferGraphics);
            }
            // ---------------------------------------------------------------------------------
        }


        //?Üè?ãªè?}®©µÌ?jà?}ÆWJ?}?ãÌÎ_Ì\¦


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
    }//?Üè?ãªè?}Ì?kÚW??

    public double get_syukusyaku() {
        return d_oriagarizu_syukusyaku_keisuu;
    }//?Üè?ãªè?}Ì?kÚW??

    public void set_kaiten(double d0) {
        d_oriagarizu_kaiten_hosei = d0;
    }//?Üè?ãªè?}Ìñ]\¦pxÌâ?³px

    public double get_kaiten() {
        return d_oriagarizu_kaiten_hosei;
    }//?Üè?ãªè?}Ìñ]\¦pxÌâ?³px

//mmmmmmm

    //---------------------------------------------------------

    //public Memo getMemo_for_svg_kakidasi(){
    //	return js.getMemo_for_svg_kakidasi() ;
    //}

    public Memo getMemo_for_svg_kakidasi() {

        Memo memo_temp = new Memo();

        //?jà?}Ìsvg
        //System.out.println("paint?@+++++++++++++++++++++?@?jà?}Ì\¦");
        if (hyouji_flg == 2) {
            //ts2.oekaki_with_camera(bufferGraphics,ip4);//?Üè?ãªè?}Ì??Í±Ìts2Ì?jà?}ð®©·?B

//System.out.println("getMemo_hariganezu_for_svg_kakidasi?@?jà?}Ìsvg");
            memo_temp.addMemo(js.getMemo_hariganezu_for_svg_kakidasi(ts1, ts2.get(), ts3.get(), 0));//SÔÚÌ?®?ÍOÈçÊÌgÌÝ?APÈçÊðhé


        }

        //?Üè ªè?}?i\?jÌsvg
        if (((ip4 == 0) || (ip4 == 2)) || (ip4 == 3)) {
            js.setCamera(camera_of_oriagari_omote);

            //§ß?}Ìsvg
            //System.out.println("paint?@+++++++++++++++++++++?@§ß?}Ì\¦");
            if (hyouji_flg == 3) {        // hyouji_flg;?Üè?ãªè?}Ì\¦l®Ìwè?BPÈçÀ?ÛÉ?Üèð?ÜÁ½???Æ¯¶?BQÈç§ß?}?B3Èç?jà?}?B
                memo_temp.addMemo(js.getMemo_hariganezu_for_svg_kakidasi(ts1, ts2.get(), ts3.get(), 1));
            }

            //?Üè?ãªè?}Ìsvg************* //System.out.println("paint?@+++++++++++++++++++++?@?Üè?ãªè?}Ì\¦");
            if (hyouji_flg == 5) {
                //js.oekaki_oriagarizu_with_camera(bufferGraphics,ts1,ts2.get(),ts3.get());// hyouji_flg;?Üè?ãªè?}Ì\¦l®Ìwè?B5ÈçÀ?ÛÉ?Üèð?ÜÁ½???Æ¯¶?B3Èç§ß?}?B2Èç?jà?}?B
                memo_temp.addMemo(js.getMemo_for_svg_with_camera(ts1, ts2.get(), ts3.get()));// hyouji_flg;?Üè?ãªè?}Ì\¦l®Ìwè?B5ÈçÀ?ÛÉ?Üèð?ÜÁ½???Æ¯¶?B3Èç§ß?}?B2Èç?jà?}?B

            }
        }

        //?Üè ªè?}?i ?jÌsvg
        if (((ip4 == 1) || (ip4 == 2)) || (ip4 == 3)) {

            js.setCamera(camera_of_oriagari_ura);

            //§ß?}Ìsvg
            //System.out.println("paint?@+++++++++++++++++++++?@§ß?}Ì\¦");
            if (hyouji_flg == 3) {        // hyouji_flg;?Üè?ãªè?}Ì\¦l®Ìwè?BPÈçÀ?ÛÉ?Üèð?ÜÁ½???Æ¯¶?BQÈç§ß?}?B3Èç?jà?}?B
                memo_temp.addMemo(js.getMemo_hariganezu_for_svg_kakidasi(ts1, ts2.get(), ts3.get(), 1));
            }

            //?Üè?ãªè?}Ìsvg************* //System.out.println("paint?@+++++++++++++++++++++?@?Üè?ãªè?}Ì\¦");
            if (hyouji_flg == 5) {
                //js.oekaki_oriagarizu_with_camera(bufferGraphics,ts1,ts2.get(),ts3.get());// hyouji_flg;?Üè?ãªè?}Ì\¦l®Ìwè?B5ÈçÀ?ÛÉ?Üèð?ÜÁ½???Æ¯¶?B3Èç§ß?}?B2Èç?jà?}?B
                memo_temp.addMemo(js.getMemo_for_svg_with_camera(ts1, ts2.get(), ts3.get()));// hyouji_flg;?Üè?ãªè?}Ì\¦l®Ìwè?B5ÈçÀ?ÛÉ?Üèð?ÜÁ½???Æ¯¶?B3Èç§ß?}?B2Èç?jà?}?B

            }


        }

        //§ß?}?i?Üè ªè?}\¦ÉÇÁ·éª?j
        if ((ip4 == 3) && (hyouji_flg == 5)) {
            // ---------------------------------------------------------------------------------
            js.setCamera(camera_of_touka_omote);
            //§ß?}Ìsvg
            //System.out.println("paint?@+++++++++++++++++++++?@§ß?}Ì\¦");

            //js.oekaki_toukazu_with_camera(bufferGraphics,ts1,ts2.get(),ts3.get());
            //js.getMemo_toukazu_with_camera(bufferGraphics,ts1,ts2.get(),ts3.get());


            // ---------------------------------------------------------------------------------
            js.setCamera(camera_of_touka_ura);

            //§ß?}Ìsvg
            //System.out.println("paint?@+++++++++++++++++++++?@§ß?}Ì\¦");

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
    public void oritatami_suitei(Camera camera_of_orisen_nyuuryokuzu, Senbunsyuugou Ss0) {//?Ü?ôÝ\ªÌ?Å?É?Ats1.Senbunsyuugou2Tensyuugou(Ss0)ÆµÄg¤?B?@Ss0Í?Aes1.get_for_oritatami()©es1.get_for_select_oritatami()Å¾é?B


        int i_camera_settei = 0;


        //-------------------------------?Üè?ãªè?}\¦pJ??Ì?Ýè

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
    public void oritatami_suitei_2col(Camera camera_of_orisen_nyuuryokuzu, Senbunsyuugou Ss0) {//Q?Fhèí¯WJ?}

        //-------------------------------?Üè?ãªè?}\¦pJ??Ì?Ýè

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
        System.out.println("?????????oritatami_suitei_01;Jn");
        keijiban.tuiki("<<<<oritatami_suitei_01;  start");
        //}EXÌüÍÅes1ÌÉ??Á½??ª?W?ðts1Énµ?A_?W??(WJ?}É)É·é
        ts1.Senbunsyuugou2Tensyuugou(Ss1);
        ip3 = ts1.set_kijyunmen_id(ip3);
        ip3 = ts1.set_kijyunmen_id(orihime_ap.ten_of_kijyunmen_old);//20180222?Üè??Ið?óÔÅ?Üè?ôÝ??èð·é?Û?AÈOÉwè³êÄ¢½î??Êðø«p®½ßÉÇÁ

        return 1000;
    }


    //-----------------------------------
    public int oritatami_suitei_02() {
        System.out.println("?????????oritatami_suitei_02;Jn");
        keijiban.tuiki("<<<<oritatami_suitei_02;  start");
        //ts1ª?Üè½½Ýð?s¢?AÅ«½?jà?}ðts2Én·?B
        //ts2ª?Üè ªÁ½`ð?­µ¾¯Ï`µ½¢æ¤È???É­­?B
        ts2.set(ts1.oritatami());
        orihime_ap.keijiban.tuiki("<<<<oritatami_suitei_02; end");

        //ts2.Iti_sitei(0.0 , 0.0);_?W?Ì½ÏÊuðS_Ì?d?SÉ·é?B
        //  if(ip4==1){ ts2.uragaesi();}
        // ts2.set( ts2.oritatami())  ;//?Üè?ôñ¾?jà?}ð?A?ÜèJ«½¢???Ì??
        //±±ÜÅÅ?jà?}ÍÅ«Ä¢Ä?Ats2ª??ÁÄ¢é?B±êÍ?A}EXÅ???AÏ`Å«é?B
        return 1000;
    }

    //-----------------------------------
    public int oritatami_suitei_02col() {//20171225?@Q?Fhèí¯ð·é½ßÌÁÊ??è?i?Üè?ôÝÊuð??èµÈ¢?j
        System.out.println("?????????oritatami_suitei_02;Jn");
        keijiban.tuiki("<<<<oritatami_suitei_02;  start");
        ts2.set(ts1.men_iti_motome());
        orihime_ap.keijiban.tuiki("<<<<oritatami_suitei_02; end");
        return 1000;
    }

    //-----------------------------------
    public int oritatami_suitei_03() {
        System.out.println("?????????oritatami_suitei_03;Jn");
        keijiban.tuiki("<<<<oritatami_suitei_03;  start");
        //ts2Í?ÜéOÌWJ?}ÌÊðÛ??µ½_?W?ð?ÁÄ¢é?B
        //?Üè½½ñ¾???ÌÊÌ?ãºÖWð??è·éÉÍts2Ì??Â?jà?}É¶ÄÊð
        //?×ªµ½?i?×ªµ½ÊðSmenÆ¾¤±ÆÉ·é?j_?W?ðg¤?B
        //±ÌSmenÊÉªµ½_?W?Íts3ª??Âæ¤É·é?B
        //ts2Ì??Â_?W?ðts3Én·OÉ?Ats2Ì??Â_?W?Í_ª?dÈÁÄ¢½è·é©àµêÈ¢ÌÅ?A
        //¢Á½ñks2ÉnµÄ??ª?W?ÆµÄ?®??·é?B
        System.out.println("?????????oritatami_suitei_03()_____î{}?E?lks2Íts2©ç??ª?W???i?jà?}©çÅ«½àÌ?jðó¯æè?A?®??·é?B");
        ks2.set(ts2.getSenbunsyuugou());
        System.out.println("?????????oritatami_suitei_03()_____î{}?E?lks2ªks2.bunkatu_seiri_for_Smen_hassei;À{?B");
        ks2.bunkatu_seiri_for_Smen_hassei();//?dÈÁ½??ªâð?··é??ª?Üè?ôÝ??èÈÇÅ¾çêé?jà?}Ì?®??
        //WJ?}?E?lts3Íks2©ç_?W???its2Ì??Â?jà?}ð?®??µ½àÌ?jðó¯æè?ASmenÉª·é?B
        System.out.println("?????????oritatami_suitei_03()_____WJ?}?E?lts3Íks2©ç?®??³ê½??ª?W?ðó¯æè?ASmenÉª·é?B");
        System.out.println("?@?@?@oritatami_suitei_03()Ìts3.Senbunsyuugou2Tensyuugou(ks2.get());À{");
        ts3.Senbunsyuugou2Tensyuugou(ks2.get());

        System.out.println("?????????oritatami_suitei_03()_____?ãº\?E?ljsÍ?AWJ?}?E?lts3©ç_?W?ðó¯æè?ASmenð?Ýè·é?B");
        js.Smen_settei(ts1, ts2.get(), ts3.get());
        //±±ÜÅÅ§ß?}Â­ë¤Æv¦Î??êé?B§ß?}ÍSmen?}ÉZxðÂ¯½àÌ?B
        return 1000;
    }

    //-----------------------------------
    public int oritatami_suitei_04() {
        System.out.println("?????????oritatami_suitei_04;Jn");
        keijiban.tuiki("<<<<oritatami_suitei_04;  start");
        //Ê(?Üè½½ÞOÌWJ?}ÌÊÌ±Æ)Ì?ãº\ð??é?B
        //±êÉÍts2Ì??Â_?W???i?Üè½½ñ¾ ÆÌÊÌÊuÖWÌ?û±ñð?Â?jÆ
        //ts3Ì??Â_?W???i?jà?}ÅÊð?×ªµ½SmenÌ?û±ñð?Â?jðg¤?B
        //Ü½?Ats1Ì??Â?A?ÜÁ½Æ«ÌÊÌÊuÖWÌ?û±ñàg¤?B
        System.out.println("?????????oritatami_suitei_04()_____?ãº\?E?ljsªÊ(?Üè½½ÞOÌWJ?}ÌÊÌ±Æ)Ì?ãº\ð??é?B");

        ip1 = 0;
        betu_sagasi_flg = 0;
        ip1 = js.Jyougehyou_settei(ts1, ts2.get(), ts3.get());   //ip1=?ÜÁ½ãÌ\ ª¯¶Êª×?Ú·éÆ¢¤ëèª êÎ0ð?A³¯êÎ1000ði[·éÏ???B
        if (ip1 == 1000) {
            ip1 = 1000;
            betu_sagasi_flg = 1;
        }
        hakkenn_sita_kazu = 0;
        System.out.println("?????????oritatami_suitei_04()____?I¹");
        return 1000;
    }


    //-----------------------------------
    public int oritatami_suitei_05() {
        System.out.println("?????????oritatami_suitei_05()_____?ãº\?E?ljsªjs.kanou_kasanari_sagasi()À{?B");
        orihime_ap.keijiban.tuiki("<<<<oritatami_suitei_05()  ___js.kanou_kasanari_sagasi()  start");

        if ((i_suitei_dankai == 4) || (i_suitei_dankai == 5)) {
            if (betu_sagasi_flg == 1) {

                ip2 = js.kanou_kasanari_sagasi();//ip2=?ãº\?E?lª?Üè?ôÝÂ\È?dÈèûðTµ½?ÛÉ?AÂ\È?dÈèûªÈ¯êÎ0ð?AÂ\È?dÈèûª êÎ1000ði[·éÏ???B

                if (ip2 == 1000) {
                    hakkenn_sita_kazu = hakkenn_sita_kazu + 1;
                }

                ip5 = js.susumu(js.getSmen_yuukou_suu());//Ì?dÈèTµÌ??õ//ip5=0Èç?V½Ésusumu]nªÈ©Á½?B0ÈOÈçÏ»µ½SmenÌidÌ?Åà?¬³¢Ô??
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
    }    //20180819oO?C?³?@§ßxÌ?Åålª±êÜÅ128Å?Av??OÅ??Ì`æÉQ{·éÆ­?A256ÆÈè?A§ßxÌ?ãÀ255I?[o?[Å?AIq??©Ìª
    //t?[Yµ½?B±êÍ?A128ð127ÌÏ¦é±ÆÅàt?[YÍÈ­Èéª?A§ßxÍQÌ{?ÉµÄ¨©È¢Æ?A2ªÌêÉµ½Æ«lª¸êé©àµêÈ¢ÌÅ?A§ßxÌ?ÅålÍ64ÆµÄ¨­±ÆÉ·é?B


    private final Ten p_m_left_on = new Ten();//}EXÌ?¶{^ðµ½Æ«Ì?ÀW
    private int i_nanini_tikai = 0;//Ten pªWJ?}Ì_Éß¢=1?A?Üè?ãªè?}Ì_Éß¢=2?AÇ¿çÉàß­È¢=0
    private int i_mottomo_tikai_Tenid;
    private int i_ten_sentaku = 0;//ts1?Ats2ÆàÉ¢Ið?i?óµ?@i_ten_sentaku=0?j,ts1Ið?ÏÅts2¢Ið?i?óµ?@i_ten_sentaku=1?j,»Ì¸_ªts2Ið?Ï?i?óµ?@i_ten_sentaku=2?j
    private final Ten ugokasu_maeno_sentaku_ten = new Ten();//®©·OÌIðµ½_Ì?ÀW


    //-----------------------------------------------------------------------------------------------------uuuuuuu--
    public void oriagari_sousa_mouse_on(Ten p) {//?Üè?ãªè?}??Å}EXÌ?¶{^ðµ½Æ«Ì??Æ
        if (i_oriagari_sousa_mode == 1) {
            oriagari_sousa_mouse_on_1(p);
        }
        if (i_oriagari_sousa_mode == 2) {
            oriagari_sousa_mouse_on_2(p);
        }
    }

    public void oriagari_sousa_mouse_drag(Ten p) {//?Üè?ãªè?}??Å}EXÌ?¶{^ðµ½ÜÜhbOµ½Æ«Ì??Æ
        if (i_oriagari_sousa_mode == 1) {
            oriagari_sousa_mouse_drag_1(p);
        }
        if (i_oriagari_sousa_mode == 2) {
            oriagari_sousa_mouse_drag_2(p);
        }
    }


    public void oriagari_sousa_mouse_off(Ten p) {//?Üè?ãªè?}??Å}EXÌ?¶{^ð£µ½Æ«Ì??Æ
        if (i_oriagari_sousa_mode == 1) {
            oriagari_sousa_mouse_off_1(p);
        }
        if (i_oriagari_sousa_mode == 2) {
            oriagari_sousa_mouse_off_2(p);
        }
    }


    //  =================================================================================================================================
    //-----------------------------------------------------------------------------------------------------uuuuuuu--
    public void oriagari_sousa_mouse_on_1(Ten p) {//?Üè?ãªè?}??Å}EXÌ?¶{^ðµ½Æ«Ì??Æ   ?Üè¸çµ@\

        p_m_left_on.set(new Ten(p.getx(), p.gety()));

        ts2.setCamera(camera_of_oriagarizu);
        ts2.setCam_omote(camera_of_oriagari_omote);
        ts2.setCam_ura(camera_of_oriagari_ura);

        //i_mottomo_tikai_TenidÉpÉ?Åàß¢_ÌÔ??ði[?Bß¢_ªÜÁ½­È¢???Íi_mottomo_tikai_Tenid=0
        i_nanini_tikai = 0;//WJ?}Ì_Éß¢=1?A?Üè?ãªè?}Ì_Éß¢=2?AÇ¿çÉàß­È¢=0
        i_mottomo_tikai_Tenid = ts1.mottomo_tikai_Tenid_with_camera(p);
        if (i_mottomo_tikai_Tenid != 0) {
            i_nanini_tikai = 1;
        }
        if (ts2.mottomo_tikai_Tenid_with_camera(p, ip4) != 0) {
            if (ts1.mottomo_tikai_Ten_kyori_with_camera(p) > ts2.mottomo_tikai_Ten_kyori_with_camera(p, ip4)) {
                i_mottomo_tikai_Tenid = ts2.mottomo_tikai_Tenid_with_camera(p, ip4);
                i_nanini_tikai = 2;
            }
        }//i_mottomo_tikai_TenidÉpÉ?Åàß¢_ÌÔ??ði[ ±±ÜÅ

        ugokasu_maeno_sentaku_ten.set(ts2.getTen(i_mottomo_tikai_Tenid));


        System.out.println("i_nanini_tikai = " + i_nanini_tikai);

        if (i_nanini_tikai == 1) {

            //i_ten_sentakuðßé
            i_ten_sentaku = 0;
            if (ts1.get_ten_sentaku(i_mottomo_tikai_Tenid) == 1) {
                i_ten_sentaku = 1;
            }
            if (ts2.get_ten_sentaku(i_mottomo_tikai_Tenid) == 1) {
                i_ten_sentaku = 2;
            }
            //i_ten_sentakuðßé  ±±ÜÅ


            if (i_ten_sentaku == 0) {
                set_all_ten_sentaku_0();
                //?Üè?ãªè?}Åi_mottomo_tikai_TenidÆ¯¶ÊuÌ_ÌÔ??ð??ß?Ats1Å»ÌÔ??Ì_ðIð?ÏÝÉ·é
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

            //i_ten_sentakuðßé
            i_ten_sentaku = 0;
            if (ts1.get_ten_sentaku(i_mottomo_tikai_Tenid) == 1) {
                i_ten_sentaku = 1;
                if (ts2.get_ten_sentakusuu() > 0) {
                    i_ten_sentaku = 2;
                }    //?Ü?}?ãÅwèµ½_Å?A»±É?dÈé¢¸ê©Ì_ªts2ÅIð³êÄ¢é?Bv·éÉ?Ü?}?ãÌÎ\¦³êÄ¢é_ðIñ¾?óÔ
            }
            //i_ten_sentakuðßé  ±±ÜÅ
            System.out.println("i_ten_sentaku = " + i_ten_sentaku);

            if (i_ten_sentaku == 0) {
                set_all_ten_sentaku_0();

                //?Üè?ãªè?}Åi_mottomo_tikai_TenidÆ¯¶ÊuÌ_ÌÔ??ð??ß?Ats1Å»ÌÔ??Ì_ðIð?ÏÝÉ·é
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

                hyouji_flg_backup = hyouji_flg;   //20180216  //hyouji_flgÍ?A?Üè?ãªè?}Ì\¦l®Ìwè?B4ÈçÀ?ÛÉ?Üèð?ÜÁ½???Æ¯¶?B3Èç§ß?}?B2Èç?jà?}?B
                hyouji_flg = 2;            //20180216
            }


        }


        System.out.println("ts1.get_ten_sentakusuu() = " + ts1.get_ten_sentakusuu());
        System.out.println("ts2.get_ten_sentakusuu() = " + ts2.get_ten_sentakusuu());


    }

    //-------------
    public void oriagari_sousa_mouse_drag_1(Ten p) {//?Üè?ãªè?}??Å}EXÌ?¶{^ðµ½ÜÜhbOµ½Æ«Ì??Æ

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
    public void oriagari_sousa_mouse_off_1(Ten p) {//?Üè?ãªè?}??Å}EXÌ?¶{^ð£µ½Æ«Ì??Æ
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
                }//IWi 20180124 ±êÈO¾Æ?A\¦¢Á½ñàÇéæ¤Å¤´¢
            }


            ts1.set_all_ten_sentaku_0();
            //?Üè?ãªè?}Åi_mottomo_tikai_TenidÆ¯¶ÊuÌ_ÌÔ??ð??ß?Ats1Å»ÌÔ??Ì_ðIð?ÏÝÉ·é
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
//  ==========?Üè?ãªè?}ÌÜÜÏ`??===========================================================================================================
    //-----------------------------------------------------------------------------------------------------uuuuuuu--
    public void oriagari_sousa_mouse_on_2(Ten p) {//?Üè?ãªè?}??Å}EXÌ?¶{^ðµ½Æ«Ì??Æ

        p_m_left_on.set(new Ten(p.getx(), p.gety()));

        ts2.setCamera(camera_of_oriagarizu);
        ts2.setCam_omote(camera_of_oriagari_omote);
        ts2.setCam_ura(camera_of_oriagari_ura);

        //i_mottomo_tikai_TenidÉpÉ?Åàß¢_ÌÔ??ði[?Bß¢_ªÜÁ½­È¢???Íi_mottomo_tikai_Tenid=0
        i_nanini_tikai = 0;//WJ?}Ì_Éß¢=1?A?Üè?ãªè?}Ì_Éß¢=2?AÇ¿çÉàß­È¢=0
        i_mottomo_tikai_Tenid = ts1.mottomo_tikai_Tenid_with_camera(p);
        if (i_mottomo_tikai_Tenid != 0) {
            i_nanini_tikai = 1;
        }
        if (ts2.mottomo_tikai_Tenid_with_camera(p, ip4) != 0) {
            if (ts1.mottomo_tikai_Ten_kyori_with_camera(p) > ts2.mottomo_tikai_Ten_kyori_with_camera(p, ip4)) {
                i_mottomo_tikai_Tenid = ts2.mottomo_tikai_Tenid_with_camera(p, ip4);
                i_nanini_tikai = 2;
            }
        }//i_mottomo_tikai_TenidÉpÉ?Åàß¢_ÌÔ??ði[ ±±ÜÅ

        ugokasu_maeno_sentaku_ten.set(ts2.getTen(i_mottomo_tikai_Tenid));


        System.out.println("i_nanini_tikai = " + i_nanini_tikai);

        if (i_nanini_tikai == 1) {

            //i_ten_sentakuðßé
            i_ten_sentaku = 0;
            if (ts1.get_ten_sentaku(i_mottomo_tikai_Tenid) == 1) {
                i_ten_sentaku = 1;
            }
            if (ts2.get_ten_sentaku(i_mottomo_tikai_Tenid) == 1) {
                i_ten_sentaku = 2;
            }
            //i_ten_sentakuðßé  ±±ÜÅ


            if (i_ten_sentaku == 0) {
                set_all_ten_sentaku_0();
                //?Üè?ãªè?}Åi_mottomo_tikai_TenidÆ¯¶ÊuÌ_ÌÔ??ð??ß?Ats1Å»ÌÔ??Ì_ðIð?ÏÝÉ·é
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

            //i_ten_sentakuðßé
            i_ten_sentaku = 0;
            if (ts1.get_ten_sentaku(i_mottomo_tikai_Tenid) == 1) {
                i_ten_sentaku = 1;
                if (ts2.get_ten_sentakusuu() > 0) {
                    i_ten_sentaku = 2;
                }    //?Ü?}?ãÅwèµ½_Å?A»±É?dÈé¢¸ê©Ì_ªts2ÅIð³êÄ¢é?Bv·éÉ?Ü?}?ãÌÎ\¦³êÄ¢é_ðIñ¾?óÔ
            }
            //i_ten_sentakuðßé  ±±ÜÅ
            System.out.println("i_ten_sentaku = " + i_ten_sentaku);

            if (i_ten_sentaku == 0) {
                set_all_ten_sentaku_0();

                //?Üè?ãªè?}Åi_mottomo_tikai_TenidÆ¯¶ÊuÌ_ÌÔ??ð??ß?Ats1Å»ÌÔ??Ì_ðIð?ÏÝÉ·é
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

                hyouji_flg_backup = hyouji_flg;   //20180216  //hyouji_flgÍ?A?Üè?ãªè?}Ì\¦l®Ìwè?B4ÈçÀ?ÛÉ?Üèð?ÜÁ½???Æ¯¶?B3Èç§ß?}?B2Èç?jà?}?B
                hyouji_flg = 2;            //20180216
            }


        }


        System.out.println("ts1.get_ten_sentakusuu() = " + ts1.get_ten_sentakusuu());
        System.out.println("ts2.get_ten_sentakusuu() = " + ts2.get_ten_sentakusuu());


    }

    //-------------
    public void oriagari_sousa_mouse_drag_2(Ten p) {//?Üè?ãªè?}??Å}EXÌ?¶{^ðµ½ÜÜhbOµ½Æ«Ì??Æ

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
    public void oriagari_sousa_mouse_off_2(Ten p) {//?Üè?ãªè?}??Å}EXÌ?¶{^ð£µ½Æ«Ì??Æ
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
                //if(hyouji_flg==5){i_suitei_meirei=5;orihime_ap.oritatami_suitei();}//IWi 20180124 ±êÈO¾Æ?A\¦¢Á½ñàÇéæ¤Å¤´¢
//}
//if(i_oriagari_sousa_mode==2){
                oritatami_suitei_03();//20180216
//}


            }
            //ts2. set_all_ten_sentaku_0();

            //}
            ts1.set_all_ten_sentaku_0();
            //?Üè?ãªè?}Åi_mottomo_tikai_TenidÆ¯¶ÊuÌ_ÌÔ??ð??ß?Ats1Å»ÌÔ??Ì_ðIð?ÏÝÉ·é
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

