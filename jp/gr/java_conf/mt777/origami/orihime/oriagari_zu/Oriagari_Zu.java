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

//public class Oriagari_Zu extends Oriagari_Zu_00 {//Oriagari_Zu����{�ƂȂ�?�?オ��\���A���S���Y��

public class Oriagari_Zu {

    ap orihime_ap;

    OritaCalc oc = new OritaCalc();
    Moji_sousa ms = new Moji_sousa(); //������??�p�̊�?��??W�߂��N���X

    double r = 3.0;                   //��{�}?\���̒�??�̗��[�̉~�̔��a?A�}�Ɗe��|�C���g�̋߂��̔����??


    public double d_oriagarizu_syukusyaku_keisuu = 1.0;//?܂�?オ��?}��?k�ڌW??
    public double d_oriagarizu_kaiten_hosei = 0.0;//?܂�?オ��?}�̉�]�\���p�x�̕�?��p�x

    public Kihonshi_Syokunin ks2 = new Kihonshi_Syokunin(r);    //��{�}?E?l?Bts2��??�_?W?���ts3�ɓn���O��?A
    //ts2��??�_?W?��͖_��?d�Ȃ��Ă����肷�邩������Ȃ��̂�?A
    //��������ks2�ɓn����??��?W?��Ƃ���?�??����?B

    public Tenkaizu_Syokunin ts1 = new Tenkaizu_Syokunin(r);    //�W�J?}?E?l?B���͂��ꂽ??��?W?��??�?���?܂���?j��?�̓_?W?���?܂�?オ��?}��??��
    public Tenkaizu_Syokunin ts2 = new Tenkaizu_Syokunin(r);    //�W�J?}?E?l?Bts1��??����?j��?�̓_?W?���?܂�?オ��?}���??��?A??��?W?��ɂ���Ȃǂ̓���������?B
    public Tenkaizu_Syokunin ts3 = new Tenkaizu_Syokunin(r);    //�W�J?}?E?l?Bts1��??����?j��?�̓_?W?��??�??��?B?V���ɖʂ�F������Ȃǂ̓�����??��?B

    public Jyougehyou_Syokunin js;
    //public Jyougehyou_Syokunin js      = new Jyougehyou_Syokunin();
    //public Jyougehyou_Syokunin(ap ap0){ orihime_ap=ap0;    reset();	}    //�R���X�g���N�^

    public Camera camera_of_oriagarizu = new Camera();
    public Camera camera_of_oriagari_omote = new Camera();
    public Camera camera_of_oriagari_ura = new Camera();
    public Camera camera_of_touka_omote = new Camera();
    public Camera camera_of_touka_ura = new Camera();

    public Color oriagarizu_F_color = new Color(255, 255, 50);//?܂�?オ��?}�̕\�ʂ�?F
    public Color oriagarizu_B_color = new Color(233, 233, 233);//?܂�?オ��?}�̗��ʂ�?F
    public Color oriagarizu_L_color = Color.black;//?܂�?オ��?}��??��?F

    public int hyouji_flg_backup = 4;//�\���l��hyouji_flg�̈ꎞ�I�o�b�N�A�b�v�p
    //int hyouji_flg_backup=4;//�\���l��hyouji_flg�̈ꎞ�I�o�b�N�A�b�v�p
    public int hyouji_flg = 0;//?܂�?オ��?}�̕\���l���̎w��?B1�Ȃ�W�J?}?�???A2�Ȃ�?j��?}?B3�Ȃ瓧��?}?B4�Ȃ��?ۂ�?܂莆��?܂���???��Ɠ���?B
    public int i_suitei_meirei = 0;//?܂�?��??����ǂ̒i�K�܂�?s�����̎w��
    public int i_suitei_dankai = 0;//?܂�?��??�肪�ǂ̒i�K�܂łł������̕\��
    //public int i_suitei_jissi_umu=0;//int i_suitei_jissi_umu��?A?܂�?��??��̌v�Z�����{�������ǂ�����\��?Bint i_suitei_jissi_umu=0�Ȃ���{���Ȃ�?B1�Ȃ���{����?B


    //�\���p�̒l���i�[�����??
    public int ip1 = -1;//?㉺�\?E?l��?��??ݒ莞��?A?܂�����̕\���������ʂ�
    //��?ڂ���Ƃ�����?������ꂪ0��?A�������1000���i�[�����???B
    //�����ł�?����l��(0��1000)�ȊO��?��Ȃ�Ȃ�ł�����?B
    public int ip2 = -1;//?㉺�\?E?l��?܂�?�݉\��?d�Ȃ����T����?ۂ�?A
    //�\��?d�Ȃ�����Ȃ����0��?A�\��?d�Ȃ���������1000���i�[�����???B
    //�����ł�?����l��(0��1000)�ȊO��?��Ȃ�Ȃ�ł�����?B
    //int ip3a=1;
    public int ip3 = 1;//ts1��?܂�?�݂�?s��?ۂ̊�??�ʂ��w�肷��̂Ɏg��?B

    public int ip4 = 0;//�����?Ats1��?�?��ɗ��Ԃ������邩�ǂ������w�肷��?B0�Ȃ炵�Ȃ�?B1�Ȃ痠�Ԃ�?B

    public int ip5 = -1;    //?㉺�\?E?l����U?܂�?�݉\�Ȏ���?d�Ȃ�����������Ƃ�?A
    //����ɕʂ̎���?d�Ȃ������������?�?���js.susumu(Smensuu)�̌���?B
    //0�Ȃ�?V����susumu�]�n���Ȃ�����?B0�ȊO�Ȃ�ω�����Smen��id��?ł�?�������??

    public int ip6 = -1;    //?㉺�\?E?l����U?܂�?�݉\�Ȏ���?d�Ȃ�����������Ƃ�?A
    //����ɕʂ̎���?d�Ȃ������������ js.kanou_kasanari_sagasi()�̌���?B
    //0�Ȃ�\��?d�Ȃ肩���ƂȂ�?�Ԃ͑�?݂��Ȃ�?B
    //1000�Ȃ�ʂ�?d�Ȃ������������?B

    public int betu_sagasi_flg = 0;     //�����?u�ʂ�?d�Ȃ��T��?v���Ƃ��L����???��͂P?A������???��͂O���Ƃ�?B
    public int hakkenn_sita_kazu = 0;    //?܂�?d�Ȃ����?A���ʂ蔭�����������i�[����?B


    //public int i_AS_matome =100;//?�?��??��̕ʉ����܂Ƃ߂�?o����??//20171217 ver3.030�ł͎g���Ă��Ȃ�?B


    public int toukazu_toukado = 16;//����?}���J��?[�`�悷��?ۂ̓��ߓx


    public int i_oriagari_sousa_mode = 1;//1=�ό`����?j��?}�ɂȂ�?A�ό`���?㉺�\��?Čv�Z����?A��������̃�?[�h?A2=�ό`����?܂�?オ��?}�̂܂܂�?A��{�I�ɕό`���?㉺�\��?Čv�Z���Ȃ���?[�h


    //public Keijiban keijiban =new Keijiban(this);
    public Keijiban keijiban;


    public boolean w_image_jikkoutyuu = false;//?�?�݂܂Ƃߎ�?s��?B�P���̃C???[�W?���?o������?s���Ȃ�ture�ɂȂ�?B
    public boolean matome_write_image_jikkoutyuu = false;//matome_write_image����?s���Ȃ�ture�ɂȂ�?B�����?A��?���?܂肠����`�̗\����?���?o����������Ȃ��悤�Ɏg��?B20170613

    String fname_and_number;//�܂Ƃ�?���?o���Ɏg��?B


    //�e���?��̒�`
    String c = "";                //������????�p�̃N���X�̃C���X�^���X��
    public String text_kekka = "";                //���ʕ\���p������̃N���X�̃C���X�^���X��


    int i_fold_type = 0;//=0�͒�?��̓W�J?}�̑S?�??���?ۂƂ���?܂�?��??��?A=1��select���ꂽ?�??���?ۂƂ���?܂�?��??��?A


    public int i_toukazu_color = 0;//����?}���J��?[�ɂ���Ȃ�P?A���Ȃ��Ȃ�O


    // **************************************************
//�R���X�g���N�^
    public Oriagari_Zu(ap ap0) {

        orihime_ap = ap0;

        js = new Jyougehyou_Syokunin(ap0);
        keijiban = new Keijiban(ap0);

        //�J??����?ݒ� ------------------------------------------------------------------
        oriagari_camera_syokika();
        //�J??����?ݒ�͂����܂�----------------------------------------------------


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

        //oriagari_camera_syokika();		//20170615 ��?s���Ȃ��悤�ɂ���?i?܂肠����?}�̕\��?󋵂�ς��Ȃ��悤�ɂ��邽��?j
        //ts2.setCamera(camera_of_oriagarizu);	//20170615 ��?s���Ȃ��悤�ɂ���?i?܂肠����?}�̕\��?󋵂�ς��Ȃ��悤�ɂ��邽��?j
        //js.setCamera(camera_of_oriagarizu);	//20170615 ��?s���Ȃ��悤�ɂ���?i?܂肠����?}�̕\��?󋵂�ς��Ȃ��悤�ɂ��邽��?j

        hyouji_flg = 0;//?܂�?オ��?}�̕\���l���̎w��?B1�Ȃ�W�J?}?�???A2�Ȃ�?j��?}?B3�Ȃ瓧��?}?B5�Ȃ��?ۂ�?܂莆��?܂���???��Ɠ���?B
        i_suitei_meirei = 0;//?܂�?��??����ǂ̒i�K�܂�?s�����̎w��
        i_suitei_dankai = 0;//?܂�?��??�肪�ǂ̒i�K�܂łł������̕\��
        betu_sagasi_flg = 0;

        matome_write_image_jikkoutyuu = false; //��?���?܂肠����`�̗\����?���?o��������?s���Ȃ�ture�ɂȂ�?B20170615


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


        //?܂�?オ��?}�̕\����js��?s���̂ŕ\�����̂�ts2�ɃJ??�����Z�b�g����K�v�͂Ȃ���?A���̌�?A��ʃN���b�N��ts2�����肵���肷��̂�ts2�̃J??��?X?V�͕\���Ɠ�������?s���K�v������?B
        ts2.setCamera(camera_of_oriagarizu);
        ts2.setCam_omote(camera_of_oriagari_omote);
        ts2.setCam_ura(camera_of_oriagari_ura);
        ts2.setCam_touka_omote(camera_of_touka_omote);
        ts2.setCam_touka_ura(camera_of_touka_ura);


        //?j��?}�̕\��
        //System.out.println("paint?@+++++++++++++++++++++?@?j��?}�̕\��");
        if (hyouji_flg == 2) {
            ts2.oekaki_with_camera(bufferGraphics, ip4);//?܂�?オ��?}�̑�??�͂���ts2��?j��?}�𓮂���?B
        }

        //?܂肠����?}?i�\?j�̕\��
        if (((ip4 == 0) || (ip4 == 2)) || (ip4 == 3)) {
            js.setCamera(camera_of_oriagari_omote);

            //����?}�̕\��
            //System.out.println("paint?@+++++++++++++++++++++?@����?}�̕\��");
            if (hyouji_flg == 3) {        // hyouji_flg;?܂�?オ��?}�̕\���l���̎w��?B�P�Ȃ��?ۂ�?܂莆��?܂���???��Ɠ���?B�Q�Ȃ瓧��?}?B3�Ȃ�?j��?}?B
                js.oekaki_toukazu_with_camera(bufferGraphics, ts1, ts2.get(), ts3.get(), i_toukazu_color, toukazu_toukado);
            }

            //?܂�?オ��?}�̕\��************* //System.out.println("paint?@+++++++++++++++++++++?@?܂�?オ��?}�̕\��");
            if (hyouji_flg == 5) {
                js.oekaki_oriagarizu_with_camera(bufferGraphics, ts1, ts2.get(), ts3.get());// hyouji_flg;?܂�?オ��?}�̕\���l���̎w��?B5�Ȃ��?ۂ�?܂莆��?܂���???��Ɠ���?B3�Ȃ瓧��?}?B2�Ȃ�?j��?}?B
            }

            //?܂�?オ��?}�̓�������?S��?\���\��
            //System.out.println("paint?@+++++++++++++++++++++?@?܂�?オ��?}�̓�������?S��?\���\��)");
            if (i_mejirusi_hyouji == 1) {
                js.oekaki_jyuuji_with_camera(bufferGraphics);
            }
        }

        //?܂肠����?}?i��?j�̕\��
        if (((ip4 == 1) || (ip4 == 2)) || (ip4 == 3)) {
            camera_of_oriagari_ura.hyouji();
            js.setCamera(camera_of_oriagari_ura);

            //����?}�̕\��
            //System.out.println("paint?@+++++++++++++++++++++?@����?}�̕\��");
            if (hyouji_flg == 3) {        // hyouji_flg;?܂�?オ��?}�̕\���l���̎w��?B�P�Ȃ��?ۂ�?܂莆��?܂���???��Ɠ���?B�Q�Ȃ瓧��?}?B3�Ȃ�?j��?}?B
                js.oekaki_toukazu_with_camera(bufferGraphics, ts1, ts2.get(), ts3.get(), i_toukazu_color, toukazu_toukado);
            }

            //?܂�?オ��?}�̕\��************* //System.out.println("paint?@+++++++++++++++++++++?@?܂�?オ��?}�̕\��");
            if (hyouji_flg == 5) {
                js.oekaki_oriagarizu_with_camera(bufferGraphics, ts1, ts2.get(), ts3.get());// hyouji_flg;?܂�?オ��?}�̕\���l���̎w��?B5�Ȃ��?ۂ�?܂莆��?܂���???��Ɠ���?B3�Ȃ瓧��?}?B2�Ȃ�?j��?}?B
            }

            //?܂�?オ��?}�̓�������?S��?\���\��
            //System.out.println("paint?@+++++++++++++++++++++?@?܂�?オ��?}�̓�������?S��?\���\��)");
            if (i_mejirusi_hyouji == 1) {
                js.oekaki_jyuuji_with_camera(bufferGraphics);
            }
        }

        //����?}?i?܂肠����?}�\�����ɒǉ����镪?j
        if ((ip4 == 3) && (hyouji_flg == 5)) {
            // ---------------------------------------------------------------------------------
            js.setCamera(camera_of_touka_omote);
            //����?}�̕\��
            //System.out.println("paint?@+++++++++++++++++++++?@����?}�̕\��");
            js.oekaki_toukazu_with_camera(bufferGraphics, ts1, ts2.get(), ts3.get(), i_toukazu_color, toukazu_toukado);

            //?܂�?オ��?}�̓�������?S��?\���\��
            //System.out.println("paint?@+++++++++++++++++++++?@?܂�?オ��?}�̓�������?S��?\���\��)");
            if (i_mejirusi_hyouji == 1) {
                js.oekaki_jyuuji_with_camera(bufferGraphics);
            }

            // ---------------------------------------------------------------------------------
            js.setCamera(camera_of_touka_ura);

            //����?}�̕\��
            //System.out.println("paint?@+++++++++++++++++++++?@����?}�̕\��");
            js.oekaki_toukazu_with_camera(bufferGraphics, ts1, ts2.get(), ts3.get(), i_toukazu_color, toukazu_toukado);

            //?܂�?オ��?}�̓�������?S��?\���\��
            //System.out.println("paint?@+++++++++++++++++++++?@?܂�?オ��?}�̓�������?S��?\���\��)");
            if (i_mejirusi_hyouji == 1) {
                js.oekaki_jyuuji_with_camera(bufferGraphics);
            }
            // ---------------------------------------------------------------------------------
        }


        //?܂�?オ��?}����������?j��?}�ƓW�J?}?�̑Ή��_�̕\��


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
    }//?܂�?オ��?}��?k�ڌW??

    public double get_syukusyaku() {
        return d_oriagarizu_syukusyaku_keisuu;
    }//?܂�?オ��?}��?k�ڌW??

    public void set_kaiten(double d0) {
        d_oriagarizu_kaiten_hosei = d0;
    }//?܂�?オ��?}�̉�]�\���p�x�̕�?��p�x

    public double get_kaiten() {
        return d_oriagarizu_kaiten_hosei;
    }//?܂�?オ��?}�̉�]�\���p�x�̕�?��p�x

//mmmmmmm

    //---------------------------------------------------------

    //public Memo getMemo_for_svg_kakidasi(){
    //	return js.getMemo_for_svg_kakidasi() ;
    //}

    public Memo getMemo_for_svg_kakidasi() {

        Memo memo_temp = new Memo();

        //?j��?}��svg
        //System.out.println("paint?@+++++++++++++++++++++?@?j��?}�̕\��");
        if (hyouji_flg == 2) {
            //ts2.oekaki_with_camera(bufferGraphics,ip4);//?܂�?オ��?}�̑�??�͂���ts2��?j��?}�𓮂���?B

//System.out.println("getMemo_hariganezu_for_svg_kakidasi?@?j��?}��svg");
            memo_temp.addMemo(js.getMemo_hariganezu_for_svg_kakidasi(ts1, ts2.get(), ts3.get(), 0));//�S�Ԗڂ�?�?��͂O�Ȃ�ʂ̘g�̂�?A�P�Ȃ�ʂ�h��


        }

        //?܂肠����?}?i�\?j��svg
        if (((ip4 == 0) || (ip4 == 2)) || (ip4 == 3)) {
            js.setCamera(camera_of_oriagari_omote);

            //����?}��svg
            //System.out.println("paint?@+++++++++++++++++++++?@����?}�̕\��");
            if (hyouji_flg == 3) {        // hyouji_flg;?܂�?オ��?}�̕\���l���̎w��?B�P�Ȃ��?ۂ�?܂莆��?܂���???��Ɠ���?B�Q�Ȃ瓧��?}?B3�Ȃ�?j��?}?B
                memo_temp.addMemo(js.getMemo_hariganezu_for_svg_kakidasi(ts1, ts2.get(), ts3.get(), 1));
            }

            //?܂�?オ��?}��svg************* //System.out.println("paint?@+++++++++++++++++++++?@?܂�?オ��?}�̕\��");
            if (hyouji_flg == 5) {
                //js.oekaki_oriagarizu_with_camera(bufferGraphics,ts1,ts2.get(),ts3.get());// hyouji_flg;?܂�?オ��?}�̕\���l���̎w��?B5�Ȃ��?ۂ�?܂莆��?܂���???��Ɠ���?B3�Ȃ瓧��?}?B2�Ȃ�?j��?}?B
                memo_temp.addMemo(js.getMemo_for_svg_with_camera(ts1, ts2.get(), ts3.get()));// hyouji_flg;?܂�?オ��?}�̕\���l���̎w��?B5�Ȃ��?ۂ�?܂莆��?܂���???��Ɠ���?B3�Ȃ瓧��?}?B2�Ȃ�?j��?}?B

            }
        }

        //?܂肠����?}?i��?j��svg
        if (((ip4 == 1) || (ip4 == 2)) || (ip4 == 3)) {

            js.setCamera(camera_of_oriagari_ura);

            //����?}��svg
            //System.out.println("paint?@+++++++++++++++++++++?@����?}�̕\��");
            if (hyouji_flg == 3) {        // hyouji_flg;?܂�?オ��?}�̕\���l���̎w��?B�P�Ȃ��?ۂ�?܂莆��?܂���???��Ɠ���?B�Q�Ȃ瓧��?}?B3�Ȃ�?j��?}?B
                memo_temp.addMemo(js.getMemo_hariganezu_for_svg_kakidasi(ts1, ts2.get(), ts3.get(), 1));
            }

            //?܂�?オ��?}��svg************* //System.out.println("paint?@+++++++++++++++++++++?@?܂�?オ��?}�̕\��");
            if (hyouji_flg == 5) {
                //js.oekaki_oriagarizu_with_camera(bufferGraphics,ts1,ts2.get(),ts3.get());// hyouji_flg;?܂�?オ��?}�̕\���l���̎w��?B5�Ȃ��?ۂ�?܂莆��?܂���???��Ɠ���?B3�Ȃ瓧��?}?B2�Ȃ�?j��?}?B
                memo_temp.addMemo(js.getMemo_for_svg_with_camera(ts1, ts2.get(), ts3.get()));// hyouji_flg;?܂�?オ��?}�̕\���l���̎w��?B5�Ȃ��?ۂ�?܂莆��?܂���???��Ɠ���?B3�Ȃ瓧��?}?B2�Ȃ�?j��?}?B

            }


        }

        //����?}?i?܂肠����?}�\�����ɒǉ����镪?j
        if ((ip4 == 3) && (hyouji_flg == 5)) {
            // ---------------------------------------------------------------------------------
            js.setCamera(camera_of_touka_omote);
            //����?}��svg
            //System.out.println("paint?@+++++++++++++++++++++?@����?}�̕\��");

            //js.oekaki_toukazu_with_camera(bufferGraphics,ts1,ts2.get(),ts3.get());
            //js.getMemo_toukazu_with_camera(bufferGraphics,ts1,ts2.get(),ts3.get());


            // ---------------------------------------------------------------------------------
            js.setCamera(camera_of_touka_ura);

            //����?}��svg
            //System.out.println("paint?@+++++++++++++++++++++?@����?}�̕\��");

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
    public void oritatami_suitei(Camera camera_of_orisen_nyuuryokuzu, Senbunsyuugou Ss0) {//?�?�ݗ\����?�?���?Ats1.Senbunsyuugou2Tensyuugou(Ss0)�Ƃ��Ďg��?B?@Ss0��?Aes1.get_for_oritatami()��es1.get_for_select_oritatami()�œ���?B


        int i_camera_settei = 0;


        //-------------------------------?܂�?オ��?}�\���p�J??����?ݒ�

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
    public void oritatami_suitei_2col(Camera camera_of_orisen_nyuuryokuzu, Senbunsyuugou Ss0) {//�Q?F�h��킯�W�J?}

        //-------------------------------?܂�?オ��?}�\���p�J??����?ݒ�

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
        System.out.println("?????????�oritatami_suitei_01;�J�n");
        keijiban.tuiki("<<<<oritatami_suitei_01;  start");
        //�}�E�X�̓��͂�es1�̒���??����??��?W?���ts1�ɓn��?A�_?W??(�W�J?}�ɑ���)�ɂ���
        ts1.Senbunsyuugou2Tensyuugou(Ss1);
        ip3 = ts1.set_kijyunmen_id(ip3);
        ip3 = ts1.set_kijyunmen_id(orihime_ap.ten_of_kijyunmen_old);//20180222?܂�??�I��?�Ԃ�?܂�?��??�������?�?A�ȑO�Ɏw�肳��Ă�����??�ʂ������p�����߂ɒǉ�

        return 1000;
    }


    //-----------------------------------
    public int oritatami_suitei_02() {
        System.out.println("?????????�oritatami_suitei_02;�J�n");
        keijiban.tuiki("<<<<oritatami_suitei_02;  start");
        //ts1��?܂肽���݂�?s��?A�ł���?j��?}��ts2�ɓn��?B
        //ts2��?܂肠�������`��?��������ό`�������悤��???��ɓ���?B
        ts2.set(ts1.oritatami());
        orihime_ap.keijiban.tuiki("<<<<oritatami_suitei_02; end");

        //ts2.Iti_sitei(0.0 , 0.0);�_?W?��̕��ψʒu��S�_��?d?S�ɂ���?B
        //  if(ip4==1){ ts2.uragaesi();}
        // ts2.set( ts2.oritatami())  ;//?܂�?��?j��?}��?A?܂�J������???��̑�??
        //�����܂ł�?j��?}�͂ł��Ă���?Ats2��??���Ă���?B�����?A�}�E�X�ő�???A�ό`�ł���?B
        return 1000;
    }

    //-----------------------------------
    public int oritatami_suitei_02col() {//20171225?@�Q?F�h��킯�����邽�߂̓���??��?i?܂�?�݈ʒu��??�肵�Ȃ�?j
        System.out.println("?????????�oritatami_suitei_02;�J�n");
        keijiban.tuiki("<<<<oritatami_suitei_02;  start");
        ts2.set(ts1.men_iti_motome());
        orihime_ap.keijiban.tuiki("<<<<oritatami_suitei_02; end");
        return 1000;
    }

    //-----------------------------------
    public int oritatami_suitei_03() {
        System.out.println("?????????�oritatami_suitei_03;�J�n");
        keijiban.tuiki("<<<<oritatami_suitei_03;  start");
        //ts2��?܂�O�̓W�J?}�̖ʂ��??�����_?W?����?���Ă���?B
        //?܂肽����???��̖ʂ�?㉺�֌W��??�肷��ɂ�ts2��??��?j��?}�ɉ����Ėʂ�
        //?ו�����?i?ו������ʂ�Smen�ƌ������Ƃɂ���?j�_?W?����g��?B
        //����Smen�ʂɕ��������_?W?���ts3��??�悤�ɂ���?B
        //ts2��??�_?W?���ts3�ɓn���O��?Ats2��??�_?W?��͖_��?d�Ȃ��Ă����肷�邩������Ȃ��̂�?A
        //��������ks2�ɓn����??��?W?��Ƃ���?�??����?B
        System.out.println("?????????�oritatami_suitei_03()_____��{�}?E?lks2��ts2����??��?W???i?j��?}����ł�������?j���󂯎��?A?�??����?B");
        ks2.set(ts2.getSenbunsyuugou());
        System.out.println("?????????�oritatami_suitei_03()_____��{�}?E?lks2��ks2.bunkatu_seiri_for_Smen_hassei;���{?B");
        ks2.bunkatu_seiri_for_Smen_hassei();//?d�Ȃ���??�����?�����??��?܂�?��??��Ȃǂœ�����?j��?}��?�??
        //�W�J?}?E?lts3��ks2����_?W???its2��??��?j��?}��?�??��������?j���󂯎��?ASmen�ɕ�������?B
        System.out.println("?????????�oritatami_suitei_03()_____�W�J?}?E?lts3��ks2����?�??���ꂽ??��?W?����󂯎��?ASmen�ɕ�������?B");
        System.out.println("?@?@?@oritatami_suitei_03()��ts3.Senbunsyuugou2Tensyuugou(ks2.get());���{");
        ts3.Senbunsyuugou2Tensyuugou(ks2.get());

        System.out.println("?????????�oritatami_suitei_03()_____?㉺�\?E?ljs��?A�W�J?}?E?lts3����_?W?����󂯎��?ASmen��?ݒ肷��?B");
        js.Smen_settei(ts1, ts2.get(), ts3.get());
        //�����܂łœ���?}���낤�Ǝv����??���?B����?}��Smen?}�ɔZ�x����������?B
        return 1000;
    }

    //-----------------------------------
    public int oritatami_suitei_04() {
        System.out.println("?????????�oritatami_suitei_04;�J�n");
        keijiban.tuiki("<<<<oritatami_suitei_04;  start");
        //��(?܂肽���ޑO�̓W�J?}�̖ʂ̂���)��?㉺�\��??��?B
        //����ɂ�ts2��??�_?W???i?܂肽���񂾂��Ƃ̖ʂ̈ʒu�֌W��?�����?��?j��
        //ts3��??�_?W???i?j��?}�Ŗʂ�?ו�������Smen��?�����?��?j���g��?B
        //�܂�?Ats1��??��?A?܂����Ƃ��̖ʂ̈ʒu�֌W��?�����g��?B
        System.out.println("?????????�oritatami_suitei_04()_____?㉺�\?E?ljs����(?܂肽���ޑO�̓W�J?}�̖ʂ̂���)��?㉺�\��??��?B");

        ip1 = 0;
        betu_sagasi_flg = 0;
        ip1 = js.Jyougehyou_settei(ts1, ts2.get(), ts3.get());   //ip1=?܂�����̕\���������ʂ���?ڂ���Ƃ�����肪�����0��?A�������1000���i�[�����???B
        if (ip1 == 1000) {
            ip1 = 1000;
            betu_sagasi_flg = 1;
        }
        hakkenn_sita_kazu = 0;
        System.out.println("?????????�oritatami_suitei_04()____?I��");
        return 1000;
    }


    //-----------------------------------
    public int oritatami_suitei_05() {
        System.out.println("?????????�oritatami_suitei_05()_____?㉺�\?E?ljs��js.kanou_kasanari_sagasi()���{?B");
        orihime_ap.keijiban.tuiki("<<<<oritatami_suitei_05()  ___js.kanou_kasanari_sagasi()  start");

        if ((i_suitei_dankai == 4) || (i_suitei_dankai == 5)) {
            if (betu_sagasi_flg == 1) {

                ip2 = js.kanou_kasanari_sagasi();//ip2=?㉺�\?E?l��?܂�?�݉\��?d�Ȃ����T����?ۂ�?A�\��?d�Ȃ�����Ȃ����0��?A�\��?d�Ȃ���������1000���i�[�����???B

                if (ip2 == 1000) {
                    hakkenn_sita_kazu = hakkenn_sita_kazu + 1;
                }

                ip5 = js.susumu(js.getSmen_yuukou_suu());//����?d�Ȃ�T����??��//ip5=0�Ȃ�?V����susumu�]�n���Ȃ�����?B0�ȊO�Ȃ�ω�����Smen��id��?ł�?�������??
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
    }    //20180819�o�O?C?�?@���ߓx��?ő�l������܂�128��?A�v??�O������??�̕`�掞�ɂQ�{����Ƃ�?A256�ƂȂ�?A���ߓx��?��255�I?[�o?[��?A�I���q??���̂�
    //�t��?[�Y����?B�����?A128��127�̕ς��邱�Ƃł��t��?[�Y�͂Ȃ��Ȃ邪?A���ߓx�͂Q�̔{?��ɂ��Ă����Ȃ���?A2���̈�ɂ����Ƃ��l������邩������Ȃ��̂�?A���ߓx��?ő�l��64�Ƃ��Ă������Ƃɂ���?B


    private final Ten p_m_left_on = new Ten();//�}�E�X��?��{�^�����������Ƃ���?��W
    private int i_nanini_tikai = 0;//Ten p���W�J?}�̓_�ɋ߂�=1?A?܂�?オ��?}�̓_�ɋ߂�=2?A�ǂ���ɂ��߂��Ȃ�=0
    private int i_mottomo_tikai_Tenid;
    private int i_ten_sentaku = 0;//ts1?Ats2�Ƃ��ɖ��I��?i?�?@i_ten_sentaku=0?j,ts1�I��?ς�ts2���I��?i?�?@i_ten_sentaku=1?j,���̒��_��ts2�I��?�?i?�?@i_ten_sentaku=2?j
    private final Ten ugokasu_maeno_sentaku_ten = new Ten();//�������O�̑I�������_��?��W


    //-----------------------------------------------------------------------------------------------------uuuuuuu--
    public void oriagari_sousa_mouse_on(Ten p) {//?܂�?オ��?}��??�Ń}�E�X��?��{�^�����������Ƃ���??��
        if (i_oriagari_sousa_mode == 1) {
            oriagari_sousa_mouse_on_1(p);
        }
        if (i_oriagari_sousa_mode == 2) {
            oriagari_sousa_mouse_on_2(p);
        }
    }

    public void oriagari_sousa_mouse_drag(Ten p) {//?܂�?オ��?}��??�Ń}�E�X��?��{�^�����������܂܃h���b�O�����Ƃ���??��
        if (i_oriagari_sousa_mode == 1) {
            oriagari_sousa_mouse_drag_1(p);
        }
        if (i_oriagari_sousa_mode == 2) {
            oriagari_sousa_mouse_drag_2(p);
        }
    }


    public void oriagari_sousa_mouse_off(Ten p) {//?܂�?オ��?}��??�Ń}�E�X��?��{�^���𗣂����Ƃ���??��
        if (i_oriagari_sousa_mode == 1) {
            oriagari_sousa_mouse_off_1(p);
        }
        if (i_oriagari_sousa_mode == 2) {
            oriagari_sousa_mouse_off_2(p);
        }
    }


    //  =================================================================================================================================
    //-----------------------------------------------------------------------------------------------------uuuuuuu--
    public void oriagari_sousa_mouse_on_1(Ten p) {//?܂�?オ��?}��??�Ń}�E�X��?��{�^�����������Ƃ���??��   ?܂肸�炵�@�\

        p_m_left_on.set(new Ten(p.getx(), p.gety()));

        ts2.setCamera(camera_of_oriagarizu);
        ts2.setCam_omote(camera_of_oriagari_omote);
        ts2.setCam_ura(camera_of_oriagari_ura);

        //i_mottomo_tikai_Tenid��p��?ł��߂��_�̔�??���i�[?B�߂��_���܂������Ȃ�???���i_mottomo_tikai_Tenid=0
        i_nanini_tikai = 0;//�W�J?}�̓_�ɋ߂�=1?A?܂�?オ��?}�̓_�ɋ߂�=2?A�ǂ���ɂ��߂��Ȃ�=0
        i_mottomo_tikai_Tenid = ts1.mottomo_tikai_Tenid_with_camera(p);
        if (i_mottomo_tikai_Tenid != 0) {
            i_nanini_tikai = 1;
        }
        if (ts2.mottomo_tikai_Tenid_with_camera(p, ip4) != 0) {
            if (ts1.mottomo_tikai_Ten_kyori_with_camera(p) > ts2.mottomo_tikai_Ten_kyori_with_camera(p, ip4)) {
                i_mottomo_tikai_Tenid = ts2.mottomo_tikai_Tenid_with_camera(p, ip4);
                i_nanini_tikai = 2;
            }
        }//i_mottomo_tikai_Tenid��p��?ł��߂��_�̔�??���i�[ �����܂�

        ugokasu_maeno_sentaku_ten.set(ts2.getTen(i_mottomo_tikai_Tenid));


        System.out.println("i_nanini_tikai = " + i_nanini_tikai);

        if (i_nanini_tikai == 1) {

            //i_ten_sentaku�����߂�
            i_ten_sentaku = 0;
            if (ts1.get_ten_sentaku(i_mottomo_tikai_Tenid) == 1) {
                i_ten_sentaku = 1;
            }
            if (ts2.get_ten_sentaku(i_mottomo_tikai_Tenid) == 1) {
                i_ten_sentaku = 2;
            }
            //i_ten_sentaku�����߂�  �����܂�


            if (i_ten_sentaku == 0) {
                set_all_ten_sentaku_0();
                //?܂�?オ��?}��i_mottomo_tikai_Tenid�Ɠ����ʒu�̓_�̔�??��??��?Ats1�ł��̔�??�̓_��I��?ς݂ɂ���
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

            //i_ten_sentaku�����߂�
            i_ten_sentaku = 0;
            if (ts1.get_ten_sentaku(i_mottomo_tikai_Tenid) == 1) {
                i_ten_sentaku = 1;
                if (ts2.get_ten_sentakusuu() > 0) {
                    i_ten_sentaku = 2;
                }    //?�?}?�Ŏw�肵���_��?A������?d�Ȃ邢���ꂩ�̓_��ts2�őI������Ă���?B�v�����?�?}?�̗Ε\������Ă���_��I��?��
            }
            //i_ten_sentaku�����߂�  �����܂�
            System.out.println("i_ten_sentaku = " + i_ten_sentaku);

            if (i_ten_sentaku == 0) {
                set_all_ten_sentaku_0();

                //?܂�?オ��?}��i_mottomo_tikai_Tenid�Ɠ����ʒu�̓_�̔�??��??��?Ats1�ł��̔�??�̓_��I��?ς݂ɂ���
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

                hyouji_flg_backup = hyouji_flg;   //20180216  //hyouji_flg��?A?܂�?オ��?}�̕\���l���̎w��?B4�Ȃ��?ۂ�?܂莆��?܂���???��Ɠ���?B3�Ȃ瓧��?}?B2�Ȃ�?j��?}?B
                hyouji_flg = 2;            //20180216
            }


        }


        System.out.println("ts1.get_ten_sentakusuu() = " + ts1.get_ten_sentakusuu());
        System.out.println("ts2.get_ten_sentakusuu() = " + ts2.get_ten_sentakusuu());


    }

    //-------------
    public void oriagari_sousa_mouse_drag_1(Ten p) {//?܂�?オ��?}��??�Ń}�E�X��?��{�^�����������܂܃h���b�O�����Ƃ���??��

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
    public void oriagari_sousa_mouse_off_1(Ten p) {//?܂�?オ��?}��??�Ń}�E�X��?��{�^���𗣂����Ƃ���??��
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
                }//�I���W�i�� 20180124 ����ȊO����?A�\������������ǂ�悤�ł�����
            }


            ts1.set_all_ten_sentaku_0();
            //?܂�?オ��?}��i_mottomo_tikai_Tenid�Ɠ����ʒu�̓_�̔�??��??��?Ats1�ł��̔�??�̓_��I��?ς݂ɂ���
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
//  ==========?܂�?オ��?}�̂܂ܕό`��??===========================================================================================================
    //-----------------------------------------------------------------------------------------------------uuuuuuu--
    public void oriagari_sousa_mouse_on_2(Ten p) {//?܂�?オ��?}��??�Ń}�E�X��?��{�^�����������Ƃ���??��

        p_m_left_on.set(new Ten(p.getx(), p.gety()));

        ts2.setCamera(camera_of_oriagarizu);
        ts2.setCam_omote(camera_of_oriagari_omote);
        ts2.setCam_ura(camera_of_oriagari_ura);

        //i_mottomo_tikai_Tenid��p��?ł��߂��_�̔�??���i�[?B�߂��_���܂������Ȃ�???���i_mottomo_tikai_Tenid=0
        i_nanini_tikai = 0;//�W�J?}�̓_�ɋ߂�=1?A?܂�?オ��?}�̓_�ɋ߂�=2?A�ǂ���ɂ��߂��Ȃ�=0
        i_mottomo_tikai_Tenid = ts1.mottomo_tikai_Tenid_with_camera(p);
        if (i_mottomo_tikai_Tenid != 0) {
            i_nanini_tikai = 1;
        }
        if (ts2.mottomo_tikai_Tenid_with_camera(p, ip4) != 0) {
            if (ts1.mottomo_tikai_Ten_kyori_with_camera(p) > ts2.mottomo_tikai_Ten_kyori_with_camera(p, ip4)) {
                i_mottomo_tikai_Tenid = ts2.mottomo_tikai_Tenid_with_camera(p, ip4);
                i_nanini_tikai = 2;
            }
        }//i_mottomo_tikai_Tenid��p��?ł��߂��_�̔�??���i�[ �����܂�

        ugokasu_maeno_sentaku_ten.set(ts2.getTen(i_mottomo_tikai_Tenid));


        System.out.println("i_nanini_tikai = " + i_nanini_tikai);

        if (i_nanini_tikai == 1) {

            //i_ten_sentaku�����߂�
            i_ten_sentaku = 0;
            if (ts1.get_ten_sentaku(i_mottomo_tikai_Tenid) == 1) {
                i_ten_sentaku = 1;
            }
            if (ts2.get_ten_sentaku(i_mottomo_tikai_Tenid) == 1) {
                i_ten_sentaku = 2;
            }
            //i_ten_sentaku�����߂�  �����܂�


            if (i_ten_sentaku == 0) {
                set_all_ten_sentaku_0();
                //?܂�?オ��?}��i_mottomo_tikai_Tenid�Ɠ����ʒu�̓_�̔�??��??��?Ats1�ł��̔�??�̓_��I��?ς݂ɂ���
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

            //i_ten_sentaku�����߂�
            i_ten_sentaku = 0;
            if (ts1.get_ten_sentaku(i_mottomo_tikai_Tenid) == 1) {
                i_ten_sentaku = 1;
                if (ts2.get_ten_sentakusuu() > 0) {
                    i_ten_sentaku = 2;
                }    //?�?}?�Ŏw�肵���_��?A������?d�Ȃ邢���ꂩ�̓_��ts2�őI������Ă���?B�v�����?�?}?�̗Ε\������Ă���_��I��?��
            }
            //i_ten_sentaku�����߂�  �����܂�
            System.out.println("i_ten_sentaku = " + i_ten_sentaku);

            if (i_ten_sentaku == 0) {
                set_all_ten_sentaku_0();

                //?܂�?オ��?}��i_mottomo_tikai_Tenid�Ɠ����ʒu�̓_�̔�??��??��?Ats1�ł��̔�??�̓_��I��?ς݂ɂ���
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

                hyouji_flg_backup = hyouji_flg;   //20180216  //hyouji_flg��?A?܂�?オ��?}�̕\���l���̎w��?B4�Ȃ��?ۂ�?܂莆��?܂���???��Ɠ���?B3�Ȃ瓧��?}?B2�Ȃ�?j��?}?B
                hyouji_flg = 2;            //20180216
            }


        }


        System.out.println("ts1.get_ten_sentakusuu() = " + ts1.get_ten_sentakusuu());
        System.out.println("ts2.get_ten_sentakusuu() = " + ts2.get_ten_sentakusuu());


    }

    //-------------
    public void oriagari_sousa_mouse_drag_2(Ten p) {//?܂�?オ��?}��??�Ń}�E�X��?��{�^�����������܂܃h���b�O�����Ƃ���??��

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
    public void oriagari_sousa_mouse_off_2(Ten p) {//?܂�?オ��?}��??�Ń}�E�X��?��{�^���𗣂����Ƃ���??��
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
                //if(hyouji_flg==5){i_suitei_meirei=5;orihime_ap.oritatami_suitei();}//�I���W�i�� 20180124 ����ȊO����?A�\������������ǂ�悤�ł�����
//}
//if(i_oriagari_sousa_mode==2){
                oritatami_suitei_03();//20180216
//}


            }
            //ts2. set_all_ten_sentaku_0();

            //}
            ts1.set_all_ten_sentaku_0();
            //?܂�?オ��?}��i_mottomo_tikai_Tenid�Ɠ����ʒu�̓_�̔�??��??��?Ats1�ł��̔�??�̓_��I��?ς݂ɂ���
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

