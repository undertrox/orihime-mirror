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

    ////b* �A�v���P?[�V�����p?B?擪��?^???^?^?^�Ŏn�܂�?s�ɂ͂��܂ꂽ�����͖��������?B
    FileDialog fd;
    double r = 3.0;                   //��{�}?\���̒�??�̗��[�̉~�̔��a?A�}�Ɗe��|�C���g�̋߂��̔����??
    Memo memo1 = new Memo();

    File_keisiki_henkan file_henkan = new File_keisiki_henkan();

    OritaCalc oc = new OritaCalc();

    SubThread sub;

    int i_SubThread = 0;//SubThread?i?�?�݌v�Z?j��?s���Ȃ�P?A��?s���Ă��Ȃ��Ȃ�O

    //�e�X�g�p  VVVVVVVVVVVVVVVVV
    //Jyuufuku_Jyunretu_hasseiki jjh = new Jyuufuku_Jyunretu_hasseiki();
    //AAAAAAAAAAAAAAAAAAAAAAAAAAA

    Egaki_Syokunin es1 = new Egaki_Syokunin(r, this);    //��{�}?E?l?B�}�E�X����̓��͂��󂯕t����?B

    public Oriagari_Zu temp_OZ = new Oriagari_Zu(this);    //?܂肠����?}
    public Oriagari_Zu OZ;    //?܂肠����?}

    ArrayList OAZ = new ArrayList(); //?܂�?オ��?}�̃C���X�^���X��

    public Senbunsyuugou Ss0;//?�?�ݗ\����?�?���?Ats1.Senbunsyuugou2Tensyuugou(Ss0)�Ƃ��Ďg��?B?@Ss0��?Aes1.get_for_oritatami()��es1.get_for_select_oritatami()�œ���?B

    int i_OAZ = 0;//OAZ�̉��Ԗڂ�Oriagari_Zu���{�^����??��ό`��??�̑�?ۂƂȂ邩���w��


    public Kousi kus = es1.kus;

    Moji_sousa ms = new Moji_sousa(); //������??�p�̊�?��??W�߂��N���X

    public Keijiban keijiban = new Keijiban(this);

    public Camera camera_of_orisen_nyuuryokuzu = new Camera();

    Haikei_camera h_cam = new Haikei_camera();

    Ten mouse_temp0 = new Ten();//�}�E�X�̓�??�Ή�����?A�ꎞ�I�Ɏg��Ten

    int icol;//��{�}?E?l�̎}��?F���w�肷��?B0��???A1��?�?A2��?�?B//icol=0 black	//icol=1 red	//icol=2 blue	//icol=3 cyan	//icol=4 orange	//icol=5 mazenta	//icol=6 green	//icol=7 yellow	//icol=8 new Color(210,0,255) //��
    int h_icol;//��????�̎}��?F���w�肷��?B

    int iro_sitei_ato_ni_jissisuru_sagyou_bangou = 1;//???�?�??��?F�w���Ɏ��{����??�Ƃ̔�??


    boolean w_image_jikkoutyuu = false;//?�?�݂܂Ƃߎ�?s��?B�P���̃C???[�W?���?o������?s���Ȃ�ture�ɂȂ�?B
    //boolean matome_write_image_jikkoutyuu = false;//matome_write_image����?s���Ȃ�ture�ɂȂ�?B�����?A��?���?܂肠����`�̗\����?���?o����������Ȃ��悤�Ɏg��?B20170613

    String fname_and_number;//�܂Ƃ�?���?o���Ɏg��?B


    public int i_anti_alias = 0;//�W�J?}�̃A���`�F�C���A�X�����邩���Ȃ���?B����=1?A���Ȃ�=0
    public double senhaba_for_anti_alias = 1.0;//�W�J?}�̃A���`�F�C���A�X������Ȃ�=1.2?A���Ȃ�=1.0

    public int ir_ten = 1;//�W�J?}�̓_�̌`?���w��

    public int i_orisen_hyougen = 1;//?�??�̕\��?A1???F?A2=?F�ƌ`???A3=?���1�_?�???A4=?���2�_?�??

    //�e���?��̒�`
    public String c = "";                //������????�p�̃N���X�̃C���X�^���X��
    //public String text_kekka=new String();                //���ʕ\���p������̃N���X�̃C���X�^���X��
    String frame_title_0 = "";//�t��?[���̃^�C�g����?��{����
    String frame_title = "";//�t��?[���̃^�C�g���̑S��

    //JDialog dialog = new JDialog(this , "����ɂ���" , true);//�_�C�A??�O�̃^�C�g��

    //int step;                             //��??�̎w��

    int i_orisen_hojyosen = 0;//=0��?�??����?@=1�͕�????���̓�?[�h


    //�A�v���b�g�ppublic void init()�܂���?A�A�v���P?[�V�����ppublic ap() �ȊO�̃N���X�ł��g�p�����p�l���̕��i��?錾�͂����ł��Ă���?B
    //�A�v���b�g�ppublic void init()�܂���?A�A�v���P?[�V�����ppublic ap() �̒������Ŏg�p�����p�l���̕��i��?錾�����X�̒��ł���?B
    //��{�I�ɕ��i�̌��������ω�������̂͂�����?錾����?B
    //Label lbel0 ;                         //��?�?��̎w��ɗp����
    //Label lbel1 ;                         //��?�?��̎w��ɗp����
    //Button	Button0 ;
    //Button	Button0a ;

    int kakudokei_input_id = 1;//�p�x�n�̓��͕��@�̎w��?@kakudokei_input_id=1��??���w��?A2��2�_�w��

    int id_kakudo_kei_a = 12;//�p�x�n��180�x������?��̊i�[_a
    int id_kakudo_kei_b = 8;//�p�x�n��180�x������?��̊i�[_b


    //int i_fold_type=0;//=0�͒�?��̓W�J?}�̑S?�??���?ۂƂ���?܂�?��??��?A=1��select���ꂽ?�??���?ۂƂ���?܂�?��??��?A
    //int i_fold_type=0;//=0�Ȃɂ����Ȃ�?A=1��?��̓W�J?}�̑S?�??���?ۂƂ���?܂�?��??��?A=2��select���ꂽ?�??���?ۂƂ���?܂�?��??��?A=3��?�?��?�Ԃ��?X

    JButton Button0b;                    //��?�?��̎w��ɗp����
    //Button Button1   ;                    //��??�̎w��ɗp����
    JButton Button3;                    //��??�̎w��ɗp����?i�ǉ�??������?j
    JButton Button_AS_matome;                    //��??�̎w��ɗp����?i�ǉ�??��100��?j
    JButton Button_bangou_sitei_suitei_hyouji;


    JButton Button_kitei;
    JButton Button_kitei2;
    //Button ButtonCol_gray   ;                    //?�??��?F�̎w��ɗp����
    JButton ButtonCol_black;                    //?�??��?F�̎w��ɗp����
    JButton ButtonCol_blue;                    //?�??��?F�̎w��ɗp����
    JButton ButtonCol_red;                    //?�??��?F�̎w��ɗp����
    JButton ButtonCol_cyan;                    //?�??(��????)��?F�̎w��ɗp����


    JButton Button_Col_orange;                    //��????1��?F�̎w��ɗp����
    JButton Button_Col_yellow;                    //��????2��?F�̎w��ɗp����


    JButton Button_haikei_Lock_on;//�w�i��??�b�N�I��
    JButton Button_haikei_kirikae;//�w�i��\�����邩�ǂ����̎w��

    //Button ButtonCol_green15   ;                    //?�??��?F�̎w��ɗp����
    //Button ButtonCol_green20  ;                    //?�??��?F�̎w��ɗp����
    //Button ButtonCol_green22p5   ;                    //?�??��?F�̎w��ɗp����

    JButton Button_kakudo_kei_a;            //�p�x�n��180������?����i�[_a
    JButton Button_kakudo_kei_b;            //�p�x�n��180������?����i�[_b

    JButton Button_M_nisuru;                    //�����ǂ�Ȏ�ނ�?�??�ł�?A�R?܂�ɂ���
    JButton Button_V_nisuru;                    //�����ǂ�Ȏ�ނ�?�??�ł�?A�J?܂�ɂ���
    JButton Button_E_nisuru;                    //�����ǂ�Ȏ�ނ�?�??�ł�?A���E??�������͎R�J��?ݒ�??�ɂ���
    JButton Button_HK_nisuru;                    //�����ǂ�Ȏ�ނ�?�??�ł�?A��?��???�ɂ���

    JButton Button_senbun_henkan2;//??����?F��?Ԃ���?�?A?���?Ԃɕϊ�


    public JButton Button_F_color;                    //?܂�?オ��?}�̕\��?F�̎w��ɗp����
    public JButton Button_B_color;                    //?܂�?オ��?}�̗���?F�̎w��ɗp����
    public JButton Button_L_color;                    //?܂�?オ��?}��??��?F�̎w��ɗp����

    public Color sen_tokutyuu_color = new Color(100, 200, 200);//��????��~��?F���??�I�ɕς���???��̎w��?F
    public JButton Button_sen_tokutyuu_color;                    //?܂�?オ��?}�̕\��?F�̎w��ɗp����


    public JTextField text1;
    public int nyuuryoku_kitei = 0;    //�i�q�̕���???@?@?@?@?i���͋K��̎w��?B0�Ȃ�K�薳��?A1�Ȃ�֕�����?B
    JTextField text2;
    int i_orisen_bunkatu_suu = 1;//free?�??���͂�?A?�??�̓���������Ă���??

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
    int i_undo_suu = 20;//text31��text10���Q?l�ɂ��Ă���
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
    int i_oritatami_bangou = 1;//?܂�?��??��̉��Ԗڂ�\�����邩�w��

    JTextField text27;
    double d_syukusyaku_keisuu = 1.0;//?k�ڌW??
    JTextField text28;
    double d_kaiten_hosei = 0.0;//��]�\���p�x�̕�?��p�x

    public JTextField text29;//double d_oriagarizu_syukusyaku_keisuu=1.0;//?܂�?オ��?}��?k�ڌW??
    public JTextField text30;
    double d_oriagarizu_kaiten_hosei = 0.0;//?܂�?オ��?}�̉�]�\���p�x�̕�?��p�x

    JTextField text31;
    int i_undo_suu_om = 5;//text31��text10���Q?l�ɂ��Ă���


    public JCheckBox ckbox_mouse_settei;//�}�E�X��?ݒ�?B�`�F�b�N�������?A�z�C?[���}�E�X�Ƃ��ē�???ݒ�
    public JCheckBox ckbox_ten_sagasi;//�_��T���͈�
    public JCheckBox ckbox_ten_hanasi;//�_�𗣂����ǂ���
    public JCheckBox ckbox_kou_mitudo_nyuuryoku;//?����x�p���͂����邩�ǂ���
    public JCheckBox ckbox_bun;//��?�
    public JCheckBox ckbox_cp;//?�??
    public JCheckBox ckbox_a0;//��?��???cyan
    public JCheckBox ckbox_a1;//��?��???

    public JCheckBox ckbox_check1;//check1
    public JCheckBox ckbox_check2;//check2
    public JCheckBox ckbox_check3;//check3
    public JCheckBox ckbox_check4;//check4

    public JCheckBox ckbox_mejirusi;//?\�����??�ʂȂǂ̖ڈ��??
    public JCheckBox ckbox_cp_ue;//�W�J?}��?܂�?オ��\�z?}��?�ɕ`��
    public JCheckBox ckbox_oritatami_keika;//?܂�?オ��\�z�̓r���o�߂�?���?o��


    public JCheckBox ckbox_cp_kaizen_oritatami;//cp��?�?�ݑO�Ɏ������P����?B
    public JCheckBox ckbox_select_nokosi;//select?�Ԃ𑼂̑�??�����Ă��Ȃ�ׂ��c��

    public JCheckBox ckbox_toukazu_color;//����?}���J��?[������?B

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


    Image img_haikei;       //�w�i�p�̉摜
    String img_haikei_fname;

    Image img_kaisetu;       //��?��p�̉摜
    String img_kaisetu_fname;

    // �o�b�t�@?[��ʗp?ݒ�VVVVVVVVVVVVVVVVVVVVVVVVVVVV
    Graphics bufferGraphics;

    int hx3 = 80;
    int hy3 = 80;//�W�J?}�̕`��_C
    int hx4 = 160;
    int hy4 = 160;//�W�J?}�̕`��_D

    // �o�b�t�@?[��ʗp?ݒ�͂����܂�AAAAAAAAAAAAAAAAAAA

    int i_Lock_on_ori = 0;//�w�i��??�b�N�I������??�P?A���Ȃ�??�O
    int i_Lock_on = 0;//�w�i��??�b�N�I������??�P?A���Ȃ�??�O

    Ten p_mouse_object_iti = new Ten();//�}�E�X�̃I�u�W�F�N�g?��W?�̈ʒu
    Ten p_mouse_TV_iti = new Ten();//�}�E�X��TV?��W?�̈ʒu

    // �A�v���b�g��??��?���
    Dimension dim;


    int ihaikeihyouji = 0;//0�Ȃ�w�i��\�����Ȃ�?B1�Ȃ�\������?B2�͖���?B
    int ikaisetuhyouji = 1;//0�Ȃ��?���\�����Ȃ�?B1�Ȃ�\������?B2�͖���?B
    public int iTenkaizuSenhaba = 1;//�W�J?}��??�̑���?B
    public int i_h_TenkaizuSenhaba = 3;//��?�????��??�̑���
    float fTenkaizuSenhaba = (float) iTenkaizuSenhaba;
    float f_h_TenkaizuSenhaba = (float) i_h_TenkaizuSenhaba;

    int nyuuryoku_houhou = 0;    //���͕��@�̎w��?B0�Ȃ��?��̕��@?A1�Ȃ瑽�p�`����?A�Q�Ȃ璼??���w�肵���_�Ɉ����񂹂�
    int kensa_houhou = 0;        //?}�̌�?����@�̎w��?B0�Ȃ猟?����Ȃ�?B1�Ȃ�??��?W?��̌�?�������?B

    public int i_mouse_modeA = 1;//�}�E�X�̓�??�ɑ΂��锽�����K�肷��?B1�Ȃ�??�����̓�?[�h?B2�Ȃ�W�J?}��?�(�ړ�)?B101�Ȃ�?܂�?オ��?}�̑�???B

    int i_mouseDragged_yuukou = 0;
    int i_mouseReleased_yuukou = 0;//0��?A�}�E�X��??�𖳎�?B1�̓}�E�X��??�L��?B�t�@�C���{�b�N�X��on-off�Ȃǂ�?A�\������mouseDragged��mouseReleased����?������Ƃ�?A�����?E��Ȃ��悤��0��?ݒ肷��?B������?A�}�E�X���N���b�N���ꂽ�Ƃ���?A1�L���w��ɂ���?B

    double sokutei_nagasa_1 = 0.0;
    double sokutei_nagasa_2 = 0.0;
    double sokutei_nagasa_3 = 0.0;
    double sokutei_kakudo_1 = 0.0;
    double sokutei_kakudo_2 = 0.0;
    double sokutei_kakudo_3 = 0.0;

    //int i_AS_matome =100;//?�?��??��̕ʉ����܂Ƃ߂�?o����??
    //int i_AS_matome_mode =0;//1=?�?��??��̕ʉ����܂Ƃ߂�?o��?B0=?�?��??��̕ʉ����܂Ƃ߂�?o����?[�h�ł͂Ȃ�?B���̕�?��̓T�u�X���b�h�̓�??��?X�ɂ�������?B20170611��Ve r3.008����ǉ�

    int i_sub_mode = 0;
    //i_sub_mode �T�u�X���b�h�̓�??�K��?B
    //0=?�????��5�̎�?s?B?�?��??��̕ʉ����܂Ƃ߂�?o����?[�h�ł͂Ȃ�?B
    //1=?�????��5�̎�?s?B?�?��??��̕ʉ����܂Ƃ߂�?o��?B
    //2=


    Thread myTh;                              //�X���b�h�N���X�̃C���X�^���X��
    //Runnable�C���^?[�t�F�C�X���������Ă���̂�?AmyTh�X���b�h�̎�?s���e��run??�\�b�h��?������
    //�A�v���b�g�ł̃X���b�h�̎g������?A?h?��̌�Java?h��P231�Q?�


    //�摜?o�͂��邽��20170107_old��?����ꂽ?s���R??���g�A�E�g��?A20170107_new��?s��L���ɂ���?B
    //�摜?o�͕s�v�Ō��ɂ��ǂ��Ȃ�?A20170107_old��?����ꂽ?s��L���ɂ�?A20170107_new��?s���R??���g�A�E�g�ɂ���΂悢?B?i���̕�?X��Orihime.java�̒�������2��?��?��?j
    // �I�t�X�N��?[��
    //Image offscreen;															//20170107_old
    //BufferedImage  offscreen = new BufferedImage(1, 1,  BufferedImage.TYPE_INT_BGR);							//20170107_new
    BufferedImage offscreen = null;//20181205new

    BufferedImage offsc_haikei = null;//20181205add

    int flg61 = 0;//�g?ݒ莞�ɂ���?@20180524

    int flg_wi = 0;//writeimage���ɂ���?@1�ɂ����paint�̊�?���?I������writeimage����悤�ɂ���?B�����?Apaint�̕�?X��?���?o�����C???[�W�ɔ��f����Ȃ����Ƃ�h�����߂�?H�v?B20180528
    String fname_wi;


    public int i_sel_mou_mode;//�Z���N�g���ă}�E�X��??������?ۂɂǂ̑�??�����邩�̎w��?B�Z���N�g��ɃZ���N�g?ς݂̓_��I���������I�ɃZ���N�g�O��̃}�E�X��??��?؂�ւ���Ƃ��Ɏg��?B
    //=1��move?A=2��move4p?A=3��copy?A=4��copy4p?A=5�͋��f��


    JButton Button_move;
    JButton Button_move_2p2p;
    JButton Button_copy_paste;
    JButton Button_copy_paste_2p2p;
    JButton Button_kyouei;

    //�E�B���h�E�������p�̃p��???[�^
    BufferedImage imageT;
    int i_toumeika = 0;//0�Ȃ瓧�������Ȃ�?B1�Ȃ瓧��������?B


    //?�?�[����?A?�?�ŕ`��p��ʂ̌�������E�ʒu�ւ̃x�N�g��
    int hidari_ue_ix = 115;
    int hidari_ue_iy = 64;

    //�E���[����?A�E���ŕ`��p��ʂ̌�������E�ʒu�ւ̃x�N�g��
    int migi_sita_ix = 115;
    int migi_sita_iy = 44;


    //�����܂ł���?����̒�`
// **************************************************************************************************************
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
            //  myTh�X���b�h�Ŏ�?s�����������e�͂�����?���?B
        }
    }

    ////b* �A�v���P?[�V�����p?B?擪��?^???^?^?^�Ŏn�܂�?s�ɂ͂��܂ꂽ�����͖��������?B
    public ap() {


        super("ORIHIME Ver.3.054");//�^�C�g�����w�肵�ăR���X�g���N�^���{
        frame_title_0 = getTitle();
        frame_title = frame_title_0;//�^�C�g�����?��Ɋi�[
        es1.set_title(frame_title);

        addWindowListener(new WindowAdapter() {//?I���{�^����L����
            public void windowClosing(WindowEvent evt) {
                //owari();//�E�B���h�E?�ӉE�[��X���������Ƃ���?s��??��
                System.exit(0);
            }

        });//?I���{�^����L���� �����܂�?B

        show();                 //�A�v���b�g�̎��͎g��Ȃ�?B�A�v���P?[�V�����̎��͎g��?B����
////b* �A�v���P?[�V�����p?B?擪��?^???^?^?^�Ŏn�܂�?s�ɂ͂��܂ꂽ�����͖��������?B

        //�o�b�t�@?[��ʂ�?ݒ� ------------------------------------------------------------------
        // ??��?����������˂�
        dim = getSize();
        System.out.println(" dim 001 :" + dim.width + " , " + dim.height);//����???��\

        //�摜?o�͂��邽��20170107_old��?����ꂽ?s���R??���g�A�E�g��?A20170107_new��?s��L���ɂ���?B
        //�摜?o�͕s�v�Ō��ɂ��ǂ��Ȃ�?A20170107_old��?����ꂽ?s��L���ɂ�?A20170107_new��?s���R??���g�A�E�g�ɂ���΂悢?B?i���̕�?X��Orihime.java�̒�������2��?��?��?j
        //offscreen = createImage(2000,1100)					;	bufferGraphics = offscreen.getGraphics();	//20170107_old
        offscreen = new BufferedImage(2000, 1100, BufferedImage.TYPE_INT_BGR);
        bufferGraphics = offscreen.createGraphics();    //20170107_new

        //�A�v���b�g�ł͈ȑO��dim = getSize()����?AcreateImage(dim.width,dim.height);�Ƃ�����?A?�?�����createImage(2000,1100); �̂ق���?A�E�B���h�g�厞��������?�����?B
        //������?A�A�v���b�g��?�?�����(2000,1100)���傫���E�B���h�\�����͒[��������?����Ȃ��Ȃ��Ă��܂��͂�?B
////b* �A�v���P?[�V�����p?B?擪��?^???^?^?^�Ŏn�܂�?s�ɂ͂��܂ꂽ�����͖��������?B
//		offscreen = createImage(2000,1100);
////b* �A�v���P?[�V�����p?B?擪��?^???^?^?^�Ŏn�܂�?s�ɂ͂��܂ꂽ�����͖��������


        //�o�b�t�@?[��ʂ�?ݒ�͂����܂�----------------------------------------------------


//	public Oriagari_Zu OZ = new Oriagari_Zu(this);    //?܂肠����?}
//	public Oriagari_Zu OZ;    //?܂肠����?}
//	ArrayList OAZ = new ArrayList(); //?܂�?オ��?}�̃C���X�^���X��


        //OAZ.clear();OAZ.add(new Oriagari_Zu(this));
        OAZ.clear();
        OAZ_add_new_Oriagari_Zu();
        OZ = (Oriagari_Zu) OAZ.get(0);//?܂肠����?}


        //�J??����?ݒ� ------------------------------------------------------------------
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
        //�J??����?ݒ�͂����܂�----------------------------------------------------


        //text_kekka="";

        addMouseListener(this);
        addMouseMotionListener(this);
        addMouseWheelListener(this);
        //addKeyListener(this);

        icol = -1;
        //step=1;
        myTh = null;
        // ?����\��
        //addEdge() ;
        setBackground(Color.white);

        // ���C�A�E�g��???����C�A�E�g��???��̕�����?h?��̌�Java?h��P179�����Q?�

        setLayout(new BorderLayout());//Frame�p
        //Container contentPane = getContentPane();//JFrame�p


//System.exit(0);

//setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//JFrame�p �_�C�A??�O�{�b�N�X��?u�L�����Z��?v���I�΂ꂽ����?A����?�Ԃ�ۂ悤�ɂ��邽�߂�?A�킴�ƃN???[�Y�{�^����������Ă�����?s��Ȃ��I�v�V������?ݒ肵��?B


        // *************************************************
        //?��?i�k��?j�p�l����?\�z*************************
        // *************************************************
        //?��?i�k��?j�p�l����???�
//pnln10��`?�
//pnln11��`?�
//pnln12��`?�
//pnln13��`?�
//pnln14��`?�
//pnln15����`
//pnln20����`
//pnln25����`
//pnln30����`


        //Panel pnln = new Panel();pnln.setBackground(new Color(0,100,0));//new Color(red,green,blue)
        Panel pnln = new Panel();
        pnln.setBackground(Color.PINK);//new Color(red,green,blue)
        pnln.setLayout(new FlowLayout(FlowLayout.LEFT));
        //?��?i�k��?j�p�l�������C�A�E�g�ɓ\��t��

        add("North", pnln); //Frame�p
        //contentPane.add(pnln, BorderLayout.NORTH);//JFrame�p


        //Button��??���ăp�l���ɂ͂����?B
////b* �A�v���P?[�V�����p?B?擪��?^???^?^?^�Ŏn�܂�?s�ɂ͂��܂ꂽ�����͖��������?B

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
// -------------�{�^���̒�`��?擪?@�t�@�C���ǂ�?���
// **********************************************************************************************************************************************************
// **********************************************************************************************************************************************************
// **********************************************************************************************************************************************************

//Icon icon = new ImageIcon("ppp/board.png");

// ******************************************************************************�f?[�^�ǂ�?���

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

                System.out.println("readFile2Memo() �J�n");
                memo_temp = readFile2Memo();
                System.out.println("readFile2Memo() ?I��");

                if (memo_temp.getGyousuu() > 0) {
                    //�W�J?}��?�����?@�J�n
                    //settei_syokika_cp();
                    tenkaizu_syokika();
                    //�W�J?}�p��???[�^��?�����
                    es1.reset();                                                //�`��?E?l��?�����

                    //nyuuryoku_kitei=8; es1.set_kousi_bunkatu_suu(nyuuryoku_kitei); //es1.reset_2();				//�i�q??�̎w��
                    es1.set_i_kitei_jyoutai(0);

                    icol = 1;
                    es1.setcolor(icol);                                        //?�?���?�??��?F���w�肷��?B0��???A1��?�?A2��?�?B
                    ButtonCol_irokesi();
                    ButtonCol_red.setForeground(Color.black);
                    ButtonCol_red.setBackground(Color.red);    //?�??�̃{�^����?F?ݒ�
                    //�W�J?}��?�����?@?I��


                    //?�?��\��?}�̂�?�����?@�J�n
                    OZ = temp_OZ;//20171223����?s�͕s�v��������Ȃ���?A��?u�ł�OZ������Oriagari_Zu���Ȃ��Ȃ邱�Ƃ��Ȃ��悤�ɔO�̂��߂ɓ���Ă���
                    OAZ.clear();
                    OAZ_add_new_Oriagari_Zu();
                    set_i_OAZ(0);
                    settei_syokika_yosoku();

                    Button_F_color.setBackground(OZ.oriagarizu_F_color);    //�{�^����?F?ݒ�
                    Button_B_color.setBackground(OZ.oriagarizu_B_color);    //�{�^����?F?ݒ�
                    Button_L_color.setBackground(OZ.oriagarizu_L_color);    //�{�^����?F?ݒ�
                    //?�?��\��?}�̂�?�����?@?I��

                    es1.setCamera(camera_of_orisen_nyuuryokuzu);//20170702���̂P?s�������?A�𓀂���jar�t�@�C���Ŏ�?s��?A?�?��Ƀf?[�^�ǂ�?��񂾒���̓z�C?[���ł̓W�J?}�g��?k?����ł��Ȃ��Ȃ�?Bjar�̂܂܂Ŏ�?s������???��͂��񂾂��Ȃ��悤��?B�����s��?B
                    es1.setMemo_for_yomikomi(memo_temp);
                    es1.kiroku();


// -----------------20180503�ǉ�
                    d_syukusyaku_keisuu = camera_of_orisen_nyuuryokuzu.get_camera_bairitsu_x();
                    text27.setText(String.valueOf(d_syukusyaku_keisuu)); //?k�ڌW??
                    text27.setCaretPosition(0);

                    d_kaiten_hosei = camera_of_orisen_nyuuryokuzu.get_camera_kakudo();
                    text28.setText(String.valueOf(d_kaiten_hosei));//��]�\���p�x�̕�?��W??
                    text28.setCaretPosition(0);


                    //	OZ.d_oriagarizu_syukusyaku_keisuu=1.0	;text29.setText(String.valueOf(OZ.d_oriagarizu_syukusyaku_keisuu));//?܂�?オ��?}��?k�ڌW??
                    //	OZ.d_oriagarizu_kaiten_hosei=0.0		;text30.setText(String.valueOf(OZ.d_oriagarizu_kaiten_hosei));//?܂�?オ��?}�̉�]�\���p�x�̕�?��p�x

// -----------------20180503�ǉ������܂�


                    //repaint();

                }
            }
        });

        //Button_yomi.setPreferredSize(new Dimension(25, 25));
        Button_yomi.setMargin(new Insets(0, 0, 0, 0));
        //Button_yomi.setIcon(icon);
        pnln1.add(Button_yomi);

        //?d�v??��?@�ǂ�?��݂�?���?o���Ńt�@�C���_�C�A??�O�̃{�b�N�X���J����?A������t��?[����?d�Ȃ�ʒu�ő�??����?????A�t�@�C���{�b�N�X��?������Ƃ���?A
        //�}�E�X�̃h���b�O�ƃ���?[�X����?�����?B���̂���?A�]�v�ȑ�??������Ă��܂��\?�������?B�Ȃ�?A���̂Ƃ��}�E�X�N���b�N�͔�?����Ȃ�?B
        // i_mouseDragged_yuukou=0;�� i_mouseReleased_yuukou=0;��?A���̗]�v�ȑ�??��h�����߂Ɏw�肵�Ă���?B


// ******************************************************************************�f?[�^?���?o��
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


// ******�k************************************************************************

        //Button	Button_senbun_nyuryoku	= new Button(	"L_draw"	);Button_senbun_nyuryoku.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
// -----61;�����`���I����?[�h?B
        JButton Button_tyouhoukei_select = new JButton("");
        Button_tyouhoukei_select.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/tyouhoukei_select.png";
                readImageFromFile3();
                i_orisen_hojyosen = 0;//=0��?�??����?@=1�͕�????���̓�?[�h
                es1.set_i_orisen_hojyosen(i_orisen_hojyosen);//���̃{�^���Ƌ@�\�͕�?��G??���ʂɎg���Ă���̂�i_orisen_hojyosen�̎w�肪����
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

// ------61;�����`���I����?[�h?B�����܂�


// *****************************************************************************�摜?���?o��

        JButton Button_writeImage = new JButton("Im_s");
        Button_writeImage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/writeImage.png";
                readImageFromFile3();
                if (i_mouse_modeA != 61) {
                    Button_kyoutuu_sagyou();
                    es1.set_i_egaki_dankai(0);
                }//�g?ݒ莞(==61)�ɂ�?A���̘g��?����Ȃ����߂�es1.set_i_egaki_dankai���O�ɂ��Ȃ��ł���?@20180524
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
//������
		JButton	Button_toumei		= new JButton(	"T"		);
			Button_toumei.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {

		img_kaisetu_fname="qqq/toumei.png";readImageFromFile3();
							//if(i_mouse_modeA!=61){Button_kyoutuu_sagyou();es1.set_i_egaki_dankai(0);}//�g?ݒ莞(==61)�ɂ�?A���̘g��?����Ȃ����߂�es1.set_i_egaki_dankai���O�ɂ��Ȃ��ł���?@20180524
							//i_mouseDragged_yuukou=0; i_mouseReleased_yuukou=0;
//System.out.println("0    i_toumeika="+i_toumeika);
 Robot robot;

        try {
            robot = new Robot();
        } catch (AWTException ex) {
            ex.printStackTrace();
            return;
        }

        // �͈͂��w�肵�ăL���v�`��

        Rectangle bounds = getBounds();
        Insets insets = getInsets();

        bounds = new Rectangle(bounds.x + insets.left,
                               bounds.y + insets.top,
                               bounds.width - insets.left - insets.right,
                               bounds.height - insets.top - insets.bottom);

        hide();
try{Thread.sleep(50);}catch (InterruptedException ie){}//30�����҂����邽�߂�?s?B����?s���Ȃ���?Ajar�t�@�C���Ŏ�?s�����Ƃ�?A�I���q??��?g���L���v�`�����邨���ꂠ��?BInterruptedException ie��ie��?�?���e������?B20181125
        imageT = robot.createScreenCapture(bounds);
try{Thread.sleep(50);}catch (InterruptedException ie){}////30�����҂����邽�߂�?s?B����?s���Ȃ���?Ajar�t�@�C���Ŏ�?s�����Ƃ�?A�I���q??��?g���L���v�`�����邨���ꂠ��?BInterruptedException ie��ie��?�?���e������?B20181125
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
////b* �A�v���P?[�V�����p?B?擪��?^???^?^?^�Ŏn�܂�?s�ɂ͂��܂ꂽ�����͖��������?B
// ******************************************************************************


// ******************************************************************************


        //------------------------------------------------
        Panel pnln2 = new Panel();
        pnln2.setBackground(Color.PINK);
        pnln2.setLayout(new GridLayout(1, 2));

        pnln.add(pnln2);
        //------------------------------------------------


// ******�k************************************************************************�\��������̂̑I��

//��������`�F�b�N�{�b�N�X�̘A��
        //------------------------------------------------
        Panel pnln13 = new Panel();
        pnln13.setBackground(Color.PINK);
        pnln13.setLayout(new GridLayout(1, 7));

        pnln.add(pnln13);
        //------------------------------------------------


//�}�E�X?ݒ�
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
//�_�T��
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
//�_����
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
//?����x����
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

//���\��
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
//?�??�\��
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
//��?��???�\��
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
//��?��???�\��
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
//?\�����??�ʂȂǂ̖ڈ��??
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
//?܂肠����?}���????�̎�O���ɂ��邩�ǂ���
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
//?܂�?�݌o�߂̕\��
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

// ******�k************************************************************************


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
// ******�k************************************************************************??�����̓�?[�h?B�䗦����
// -----1;??�����̓�?[�h?B�䗦����

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


// -------------------------------------------------------------------------------??�����̓�?[�h?B�䗦set

        //Button	Button_senbun_naibun_set
// -----1;??���䗦set
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

// ------1;??���䗦set?B�����܂�


// -------------------------------------------------------------------------------??�����̓�?[�h?B�䗦����

        //Button	Button_senbun_nyuryoku	= new Button(	"L_draw"	);Button_senbun_nyuryoku.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
// -----28;??�����̓�?[�h?B
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

// ------28;??�����̓�?[�h?B�����܂�


//-----------------------------------------------------------------------------------
        //------------------------------------------------
        Panel pnln7 = new Panel();
        pnln7.setBackground(Color.PINK);
        pnln7.setLayout(new GridLayout(1, 1));

        //pnln.add(pnln7);
        //------------------------------------------------

// ****�k**************************************************************************
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

// *****�k*************************************************************************


// ******�k************************************************************************


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


// *****�k*************************************************************************sssssssssssssss
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


//20180122�ǉ�
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
//20180122�ǉ�?@�����܂�


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


// ****�k**************************************************************************
        text27 = new JTextField("", 2);
        text27.setBounds(29, 4, 35, 24);
        text27.setHorizontalAlignment(JTextField.RIGHT);

        pnln8.add(text27);

// ****�k**************************************************************************
// -----?k�ڌW?�set
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

//20180225�ǉ�

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
//20180225�ǉ�?@�����܂�


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

// ------?k�ڌW?�set?B�����܂�


// ****�k**************************************************************************
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


//20180122�ǉ�
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
//20180122�ǉ�?@�����܂�


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


// ******�k************************************************************************

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


// *****�k*************�W�J�̉�]************************************************************
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

// ****�k**************************************************************************
//��]�p�x��?�
        text28 = new JTextField("", 2);
        text28.setBounds(34, 4, 35, 24);
        text28.setHorizontalAlignment(JTextField.RIGHT);
        pnln14.add(text28);

// ****�k**************************************************************************
// -----��]�p�x��?�set
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


// ------��]�p�x��?�set?B�����܂�


// *****�k*************************************************************************
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


// ******�k************************************************************************


// ******�k************************************************************************


//�w�i��PC��ʂ�w�i��Ƃ��ēǂ�?���
        JButton Button_toumei = new JButton("T");
        Button_toumei.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/toumei.png";
                readImageFromFile3();
                //if(i_mouse_modeA!=61){Button_kyoutuu_sagyou();es1.set_i_egaki_dankai(0);}//�g?ݒ莞(==61)�ɂ�?A���̘g��?����Ȃ����߂�es1.set_i_egaki_dankai���O�ɂ��Ȃ��ł���?@20180524
                //i_mouseDragged_yuukou=0; i_mouseReleased_yuukou=0;
//System.out.println("0    i_toumeika="+i_toumeika);
                Robot robot;

                try {
                    robot = new Robot();
                } catch (AWTException ex) {
                    ex.printStackTrace();
                    return;
                }

                // �͈͂��w�肵�ăL���v�`��

                Rectangle bounds = getBounds();
                Insets insets = getInsets();
                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println("bounds.x=" + bounds.x + "   :bounds.y=" + bounds.y + "    :bounds.width=" + bounds.width + "   :bounds.height=" + bounds.height);
                System.out.println("insets.top=" + insets.top + "   :insets.left=" + insets.left + "    :insets.right=" + insets.right + "   :insets.bottom=" + insets.bottom);


                //?�?�[����?A?�?�ŕ`��p��ʂ̌�������E�ʒu�ւ̃x�N�g��
                //int hidari_ue_ix=115;
                //int hidari_ue_iy=60;

                //�E���[����?A�E���ŕ`��p��ʂ̌�������E�ʒu�ւ̃x�N�g��
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
                }//100�����҂����邽�߂�?s?B����?s���Ȃ���?Ajar�t�@�C���Ŏ�?s�����Ƃ�?A�I���q??��?g���L���v�`�����邨���ꂠ��?BInterruptedException ie��ie��?�?���e������?B20181125
                imageT = robot.createScreenCapture(bounds);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ie) {
                }//100�����҂����邽�߂�?s?B����?s���Ȃ���?Ajar�t�@�C���Ŏ�?s�����Ƃ�?A�I���q??��?g���L���v�`�����邨���ꂠ��?BInterruptedException ie��ie��?�?���e������?B20181125
                show();

                img_haikei = imageT;
//oc.hyouji("���w�i�J??�����Z�b�g");
//h_cam.reset();
//oc.hyouji(" ");
                oc.hyouji("?V�w�i�J??���C���X�^���X��");
                h_cam = new Haikei_camera();//20181202

                double dvx = hidari_ue_ix;
                double dvy = hidari_ue_iy;

                haikei_set(new Ten(120.0, 120.0),
                        new Ten(120.0 + 10.0, 120.0),
                        new Ten(dvx, dvy),
                        new Ten(dvx + 10.0, dvy));


//�w�i�\���̊e?��?��?ݒ�
                ihaikeihyouji = 1;
                Button_haikei_kirikae.setBackground(Color.ORANGE);

                if (i_Lock_on == 1) {//20181202  ����if��������lock on �̂Ƃ��ɔw�i�����܂��\���ł��Ȃ�
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

// *******�k***********************************************************************

//Image img;
//img=(Image)imageT;
//g2_toumei.drawImage(img,h_cam.get_x0(),h_cam.get_y0(),h_cam.get_x1(),h_cam.get_y1(),null);//null���ƃR���p�C���ʂ邪this���ƃ_??20181125
//g2_toumei.drawImage(img,-100,-100,null);//null���ƃR���p�C���ʂ邪this���ƃ_??20181125

//drawImage
//  img - �`�悳���w��C???[�W?Bimg �� null ��???��ɂ͉���?s��Ȃ�
//  x - x ?��W
//  y - y ?��W
//  width - ��`��??
//  height - ��`��?���
//  observer - �C???[�W������ɕϊ�����邱�Ƃ��ʒm�����I�u�W�F�N�g

// *****�k*************************************************************************
        JButton Button_haikei_trim = new JButton("Tr");
        Button_haikei_trim.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/haikei_trim.png";
                readImageFromFile3();


                offsc_haikei = new BufferedImage(2000, 1100, BufferedImage.TYPE_INT_ARGB);
//offsc_haikei  = new BufferedImage(2000, 1100,  BufferedImage.TYPE_INT_BGR)	;//TYPE_INT_BGR���ƃg���������摜����]�����肷���?F��������20181206

                Graphics bufferGraphics_haikei;
                bufferGraphics_haikei = offsc_haikei.createGraphics();    //20170107_new
                Graphics2D g2_haikei = (Graphics2D) bufferGraphics_haikei;
                //�w�i�\��
                if ((img_haikei != null) && (ihaikeihyouji >= 1)) {
                    int iw = img_haikei.getWidth(null);//�C???[�W��??���擾
                    int ih = img_haikei.getHeight(null);//�C???[�W��?������擾

                    //System.out.println("paint????"+iw);
                    //System.out.println("paint?���??"+ih);
                    h_cam.set_haikei_haba(iw);
                    h_cam.set_haikei_takasa(ih);

                    //if(i_Lock_on==1){
                    haikei_byouga(g2_haikei, img_haikei);
                    //}

                }


//�g?ݒ莞�̔w�i��g���̂ݎc���ăg���� 20181204
                if ((i_mouse_modeA == 61) && (es1.get_i_egaki_dankai() == 4)) {//�g??���\������Ă���?��
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

                    if (i_Lock_on == 1) {//20181202  ����if��������lock on �̂Ƃ��ɔw�i�����܂��\���ł��Ȃ�
                        h_cam.set_i_Lock_on(i_Lock_on);
                        h_cam.setCamera(camera_of_orisen_nyuuryokuzu);
                        h_cam.h3_obj_and_h4_obj_keisan();
                    }


                }
            }
        });
        Button_haikei_trim.setMargin(new Insets(0, 0, 0, 0));
        pnln.add(Button_haikei_trim);

// *******�k***********************************************************************
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
// *******�k***********************************************************************

////b* �A�v���P?[�V�����p?B?擪��?^???^?^?^�Ŏn�܂�?s�ɂ͂��܂ꂽ�����͖��������?B

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
                if (i_Lock_on == 1) {//20181202  ����if��������lock on �̂Ƃ��ɔw�i�����܂��\���ł��Ȃ�
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

// ******�k************************************************************************
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


// ******�k************************************************************************?@??��?�����??��ϊ�

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
////b* �A�v���P?[�V�����p?B?擪��?^???^?^?^�Ŏn�܂�?s�ɂ͂��܂ꂽ�����͖��������?B
// ******************************************************************************


// *******�k*********************************************************************** ��??
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
        //?���?i?���?j�p�l����?\�z*************************
        // *************************************************
        //?���?i?���?j�p�l����???�


        Panel pnlw = new Panel();
        pnlw.setBackground(Color.PINK);
        pnlw.setLayout(new GridLayout(32, 1));


        //�p�l��pnlw�����C�A�E�g?���?i?���?j�ɓ\��t��
        add("West", pnlw); //Frame�p
        //contentPane.add(pnlw, BorderLayout.WEST);//JFrame�p
// ****?�**************************************************************************

        //------------------------------------------------
        Panel pnlw26 = new Panel();
        pnlw26.setBackground(Color.PINK);
        pnlw26.setLayout(new GridLayout(1, 3));

        pnlw.add(pnlw26);
        //------------------------------------------------

// *****?�******************* Un Do ******************************************************

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

// *****?�*************************************************************************


        text10 = new JTextField("", 1);
        text10.setHorizontalAlignment(JTextField.RIGHT);

        pnlw26.add(text10);
// *****?�*************************************************************************
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


// *****?�*********************** Re Do **************************************************

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

// ****?�*********************?@?????@����?@*****************************************************
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

// ****?�********************?@?????@?グ?@******************************************************

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


// ****?�********************************?@�_???@����?@******************************************�_??

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

// ****?�*******************************?@�_???@?グ?@*******************************************
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

// ******?�*************�W�J?}��??���A���`�G�C���A�X�\���ɂ���***********************************************************
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
// ********************************************************?�??�̕\�����@

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
// ******?�************************************************************************
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

// ******?�************************************************************************

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
// ******?�************************************************************************
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
// ******?�************************************************************************
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

// ******?�************************************************************************
        //------------------------------------------------
        Panel pnlw1 = new Panel();
        pnlw1.setBackground(Color.PINK);
        pnlw1.setLayout(new GridLayout(1, 3));
        pnlw.add(pnlw1);//�p�l��pnlw1��pnlw�ɓ\��t��


        //Button	Button_senbun_nyuryoku	= new Button(	"L_draw"	);Button_senbun_nyuryoku.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
// -----1;??�����̓�?[�h?B
        JButton Button_senbun_nyuryoku = new JButton("");
        Button_senbun_nyuryoku.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/senbun_nyuryoku.png";
                readImageFromFile3();
                i_orisen_hojyosen = 0;//=0��?�??����?@=1�͕�????���̓�?[�h
                es1.set_i_orisen_hojyosen(i_orisen_hojyosen);//���̃{�^���Ƌ@�\�͕�?��G??���ʂɎg���Ă���̂�i_orisen_hojyosen�̎w�肪����
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

// ------1;??�����̓�?[�h?B�����܂�


// -------------11;??�����̓�?[�h?B
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


// -------------11;??�����̓�?[�h?B�����܂�

// -----62 62 62 �{??�m�C?}?BVoronoi 20181020

        JButton Button_Voronoi = new JButton("");
        Button_Voronoi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/Voronoi.png";
                readImageFromFile3();
                i_orisen_hojyosen = 0;//=0��?�??����?@=1�͕�????���̓�?[�h
                es1.set_i_orisen_hojyosen(i_orisen_hojyosen);//���̃{�^���Ƌ@�\�͕�?��G??���ʂɎg���Ă���̂�i_orisen_hojyosen�̎w�肪����
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

// ------1;??�����̓�?[�h?B�����܂�
// *******?�***********************************************************************
// -------------38;?܂�?�݉\??����
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


// -------------38;?܂�?�݉\??����?B�����܂�

// *******?�***********************************************************************

        //------------------------------------------------
        Panel pnlw2 = new Panel();
        pnlw2.setBackground(Color.PINK);
        pnlw2.setLayout(new GridLayout(1, 4));
        pnlw.add(pnlw2);//�p�l��pnlw2��pnlw�ɓ\��t��

// ******************************************************************************
// -------------5;??��������?[�h?B
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

// -------------5;??��������?[�h?B�����܂�
// ******************************************************************************

// ******************************************************************************
// -------------5_2;??��������?[�h?B
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

// -------------5;??��������?[�h?B�����܂�
// ******************************************************************************


// -------------7;�p�񓙕�??��?[�h?B
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

// -------------7;�p�񓙕�??��?[�h?B�����܂�

// ******************************************************************************
// -------------8;��?S��?[�h?B
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

// -------------8;��?S��?[�h?B�����܂�


// *******?�***********************************************************************


        //------------------------------------------------
        Panel pnlw3 = new Panel();
        pnlw3.setBackground(Color.PINK);
        pnlw3.setLayout(new GridLayout(1, 3));
        pnlw.add(pnlw3);


// *******?�***********************************************************************
// -------------9;????���낵��?[�h?B
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


// -------------9;????���낵��?[�h?B�����܂�


// *******?�***********************************************************************
// -------------10;?܂�Ԃ���?[�h?B
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


// -------------10;?܂�Ԃ���?[�h?B�����܂�


// *******?�***********************************************************************
// -------------52;�A��?܂�Ԃ���?[�h?B
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


// -------------52;�A��?܂�Ԃ���?[�h?B�����܂�


// *******?�***********************************************************************
        //------------------------------------------------
        Panel pnlw4 = new Panel();
        pnlw4.setBackground(Color.PINK);
        pnlw4.setLayout(new GridLayout(1, 3));
        pnlw.add(pnlw4);


// *******?�***********************************************************************
// -------------40;��?s??���̓�?[�h?B
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
// -------------40;��?s??���̓�?[�h?B�����܂�

// -------------51;��?s???@??�w����̓�?[�h?B
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
// -------------51;��?s???@??�w����̓�?[�h?B�����܂�


// *******?�***********************************************************************
// -------------39;?܂�?�݉\??+�i�q�_�n����
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


// -------------39;?܂�?�݉\??+�i�q�_�n����?B�����܂�

        //------------------------------------------------
        Panel pnlw29 = new Panel();
        pnlw29.setBackground(Color.PINK);
        pnlw29.setLayout(new GridLayout(1, 2));
        pnlw.add(pnlw29);
        //------------------------------------------------


// ******?�**********�Skouho??��(??�����͎��̈ꎞ�I��??��)����?�??�ɕϊ���?[�h**************************************************************
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

// ********?�**********************************************************************
// -------------33;����?��??[�h?B

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


// -------------10;����?��??[�h?B�����܂�


// *******?�***********************************************************************
// -------------35;��?܂�Ԃ���?[�h?B
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


// -------------35;��?܂�Ԃ���?[�h?B�����܂�


// ********?�**********************************************************************


        //------------------------------------------------
        Panel pnlw15 = new Panel();
        pnlw15.setBackground(Color.PINK);
        pnlw15.setLayout(new GridLayout(1, 3));

        pnlw.add(pnlw15);
        //------------------------------------------------

// ******?�************************************************************************
// -----1;??�����̓�?[�h?B����?��?��
        text2 = new JTextField("", 2);
        text2.setHorizontalAlignment(JTextField.RIGHT);
        pnlw15.add(text2);


// -------------------------------------------------------------------------------

        //Button	Button_senbun_bunkatu_set
// -----1;??������?�set
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

// ------1;??������?�set?B�����܂�


// -------------------------------------------------------------------------------


// -----27;??���������̓�?[�h?B
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

// ------27;??�����̓�?[�h?B�����܂�


        //------------------------------------------------
        Panel pnlw6 = new Panel();
        pnlw6.setBackground(Color.PINK);
        pnlw6.setLayout(new GridLayout(1, 3));
        pnlw.add(pnlw6);
/*
// ******?�************************************************************************

		//Button	Button_senbun_nyuryoku	= new Button(	"L_draw"	);Button_senbun_nyuryoku.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
// -----61;�����`���I����?[�h?B
		JButton	Button_tyouhoukei_select	= new JButton(	""	);
			Button_tyouhoukei_select.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
	img_kaisetu_fname="qqq/tyouhoukei_select.png";readImageFromFile3();
						i_orisen_hojyosen=0;//=0��?�??����?@=1�͕�????���̓�?[�h
						es1.set_i_orisen_hojyosen(i_orisen_hojyosen);//���̃{�^���Ƌ@�\�͕�?��G??���ʂɎg���Ă���̂�i_orisen_hojyosen�̎w�肪����
						i_mouse_modeA=61;iro_sitei_ato_ni_jissisuru_sagyou_bangou=1;
						System.out.println("i_mouse_modeA = "+i_mouse_modeA);

						es1.unselect_all();Button_kyoutuu_sagyou();repaint();
	  }});
		pnlw6.add(Button_tyouhoukei_select);


		Button_tyouhoukei_select.setMargin(new Insets(0,0,0,0));
		Button_tyouhoukei_select.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
		  "ppp/tyouhoukei_select.png")));

// ------61;�����`���I����?[�h?B�����܂�
*/

// ******?�************************************************************************
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

// ******?�************************************************************************
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

// ****?�**************************************************************************

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

// *****?�*************************************************************************


        //------------------------------------------------
        Panel pnlw16 = new Panel();
        pnlw16.setBackground(Color.PINK);
        pnlw16.setLayout(new GridLayout(1, 2));
        pnlw.add(pnlw16);


// -------------21;�ړ���?[�h?B
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
// -------------21;�ړ���?[�h?B�����܂�


// -------------31;�ړ�2p2p��?[�h?B
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
// -------------31;�ړ�2p2p��?[�h?B�����܂�


// *********?�*********************************************************************


        //------------------------------------------------
        Panel pnlw17 = new Panel();
        pnlw17.setBackground(Color.PINK);
        pnlw17.setLayout(new GridLayout(1, 2));
        pnlw.add(pnlw17);


// -------------22;�R�s?[��?[�h?B
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
// -------------22;�R�s?[��?[�h?B�����܂�


// -------------32;�R�s?[2p2p��?[�h?B
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
// -------------32;�R�s?[2p2p��?[�h?B�����܂�


// ********?�**********************************************************************

        //------------------------------------------------
        Panel pnlw35 = new Panel();
        pnlw35.setBackground(Color.PINK);
        pnlw35.setLayout(new GridLayout(1, 2));
        pnlw.add(pnlw35);


// -------------12;���f��?[�h?B
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


// -------------12;���f��?[�h?B�����܂�


// *******?�***********************************************************************
// -------------;select����?�??��????
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


// -------------select����?�??��?????B�����܂�


        //JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        //separator.setPreferredSize(new Dimension(50 , 1));
//pnlw.add(separator);


        //------------------------------------------------
        Panel pnlw5 = new Panel();
        pnlw5.setBackground(Color.PINK);
        pnlw5.setLayout(new GridLayout(1, 2));
        pnlw.add(pnlw5);


// ******?�************************************************************************ ?����S��

// -------------;??��???��??[�h?B
        JButton Button_senbun_sakujyo = new JButton("");//JButton	Button_senbun_sakujyo	= new JButton(	"L_del"	);
        Button_senbun_sakujyo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/senbun_sakujyo.png";
                readImageFromFile3();
                i_mouse_modeA = 3;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);


                i_orisen_hojyosen = 0;//=0��?�??����?@=1�͕�????���̓�?[�h
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


// ******?�************************************************************************ ????�݂̂�?����S��

// -------------;????�݂̂�??��???��??[�h?B
        JButton Button_kuro_senbun_sakujyo = new JButton("");//JButton	Button_senbun_sakujyo	= new JButton(	"L_del"	);
        Button_kuro_senbun_sakujyo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/kuro_senbun_sakujyo.png";
                readImageFromFile3();
                i_mouse_modeA = 3;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);


                i_orisen_hojyosen = 2;//=2��?���?�?????��??[�h
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


// ******?�************************************************************************ ?����S��(��?��???�̂�)

// -------------;??��???��??[�h?B?����S��(��?��???�̂�)
        JButton Button_senbun3_sakujyo = new JButton("");//JButton	Button_senbun_sakujyo	= new JButton(	"L_del"	);
        Button_senbun3_sakujyo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/senbun3_sakujyo.png";
                readImageFromFile3();
                i_mouse_modeA = 3;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);


                i_orisen_hojyosen = 3;//=0��?�??����?@=1�͕�????���̓�?[�h =3�͕�?��???�̂ݑ�?�
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


// *********?�*********************************************************************
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

// ******?�************************************************************************


// *****?�*************************************************************************


        //------------------------------------------------
        Panel pnlw8 = new Panel();
        pnlw8.setBackground(Color.PINK);
        pnlw8.setLayout(new GridLayout(1, 4));
        //------------------------------------------------
        pnlw.add(pnlw8);

// *******?�***********************************************************************
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

        Button_HK_nisuru = new JButton(" ");//HK�Ƃ͕�?��???�̂���
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


// *****?�*************************************************************************
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
// ******?�************************************************************************??����?F��?Ԃ���?�?A?���?Ԃɕϊ�

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

// ******?�************************************************************************??����?F��???A?�?A?A?�?A?���?��ɕϊ�

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


// ******?�************************************************************************

        //------------------------------------------------
        Panel pnlw21 = new Panel();
        pnlw21.setBackground(Color.PINK);
        pnlw21.setLayout(new GridLayout(1, 3));
        //------------------------------------------------
        pnlw.add(pnlw21);

// ****************************************************************************** //??��?F�ϊ�

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
                    es1.setcolor(icol);                                        //?�?���?�??��?F���w�肷��?B0��???A1��?�?A2��?�?B
                    ButtonCol_irokesi();
                    ButtonCol_red.setForeground(Color.black);
                    ButtonCol_red.setBackground(Color.red);    //?�??�̃{�^����?F?ݒ�
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


// ****************************************************************************** //??X��?�?F�ϊ�

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
                    es1.setcolor(icol);                                        //?�?���?�??��?F���w�肷��?B0��???A1��?�?A2��?�?B
                    ButtonCol_irokesi();
                    ButtonCol_blue.setForeground(Color.black);
                    ButtonCol_blue.setBackground(Color.blue);    //?�??�̃{�^����?F?ݒ�
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


// *******?�***********************************************************************

        //------------------------------------------------
        Panel pnlw10 = new Panel();
        pnlw10.setBackground(Color.PINK);
        pnlw10.setLayout(new GridLayout(1, 4));

        pnlw.add(pnlw10);
        //------------------------------------------------
// -------------14;�_�ǉ���?[�h?B
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


// -------------14;�_�ǉ���?[�h?B�����܂�

// ******************************************************************************
// -------------15;�_???��??[�h?B
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


// -------------15;�_???��??[�h?B�����܂�


// -------------15;�_???��??[�h?i�J��?[�`�F���W?j?B
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


// -------------15;�_???��??[�h?B�����܂�

// ****?�**************************************************************************


        //------------------------------------------------
        Panel pnlw13 = new Panel();
        pnlw13.setBackground(Color.PINK);
        pnlw13.setLayout(new GridLayout(1, 3));

        //------------------------------------------------
        pnlw.add(pnlw13);


// ******************************************************************************
// ******?�**********�S�_???��??[�h?B*****(������?�??��?F���������̂Ɏ�?s)?B*********************************************************
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


// ******?�**********�S�_???��??[�h(������?�??��?F������Ă���?s)?B**************************************************************
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


// ****?�**************************************************************************


        //------------------------------------------------
        Panel pnlw32 = new Panel();
        pnlw32.setBackground(Color.PINK);
        pnlw32.setLayout(new GridLayout(1, 3));

        //------------------------------------------------
        pnlw.add(pnlw32);


// *********?�*********************************************************************

        //------------------------------------------------
        Panel pnlw9 = new Panel();
        pnlw9.setBounds(2, 2, 93, 20);
        pnlw9.setBackground(Color.PINK);
        pnlw9.setLayout(null);
        //pnlw9.setLayout(new GridLayout(1,5));
        //------------------------------------------------
        pnlw.add(pnlw9);


// *******?�***********************************************************************
//------------------------------------------------
        //�i�q�\��2
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

                //�{�^����?F�ς�
                if (nyuuryoku_kitei >= 1) {
                    Button_kitei.setForeground(Color.black);
                    Button_kitei.setBackground(Color.white);
                }
                if (nyuuryoku_kitei == 0) {
                    Button_kitei.setForeground(Color.black);
                    Button_kitei.setBackground(new Color(0, 200, 200));
                }
                //�{�^����?F�ς�(�����܂�)
                //�{�^����?F�ς�
                if (nyuuryoku_kitei >= 1) {
                    Button_kitei2.setForeground(Color.black);
                    Button_kitei2.setBackground(Color.white);
                }
                if (nyuuryoku_kitei == 0) {
                    Button_kitei2.setForeground(Color.black);
                    Button_kitei2.setBackground(new Color(0, 200, 200));
                }
                //�{�^����?F�ς�(�����܂�)

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


// *****?�*************************************************************************

        text1 = new JTextField("", 2);
        text1.setHorizontalAlignment(JTextField.RIGHT);
        text1.setBounds(20, 1, 35, 19);
        pnlw9.add(text1);

// *****?�*************************************************************************
        //JButton button_syutoku = new JButton("�擾");
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


//-------?�-----------------------------------------
        //�i�q�\��
        Button_kitei = new JButton("");// new JButton(	"Grid"	);

        Button_kitei.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/kitei.png";
                readImageFromFile3();

                nyuuryoku_kitei = nyuuryoku_kitei * 2;
                //if(nyuuryoku_kitei>20){nyuuryoku_kitei=20;}

                //�{�^����?F�ς�
                if (nyuuryoku_kitei >= 1) {
                    Button_kitei.setForeground(Color.black);
                    Button_kitei.setBackground(Color.white);
                }
                if (nyuuryoku_kitei == 0) {
                    Button_kitei.setForeground(Color.black);
                    Button_kitei.setBackground(new Color(0, 200, 200));
                }
                //�{�^����?F�ς�(�����܂�)
                //�{�^����?F�ς�
                if (nyuuryoku_kitei >= 1) {
                    Button_kitei2.setForeground(Color.black);
                    Button_kitei2.setBackground(Color.white);
                }
                if (nyuuryoku_kitei == 0) {
                    Button_kitei2.setForeground(Color.black);
                    Button_kitei2.setBackground(new Color(0, 200, 200));
                }
                //�{�^����?F�ς�(�����܂�)
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

// -------------�i�q??��?F�̑I��
        JButton Button_kousi_color = new JButton("C");
        Button_kousi_color.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/kousi_color.png";
                readImageFromFile3();
                //Button_kyoutuu_sagyou();
                i_mouseDragged_yuukou = 0;
                i_mouseReleased_yuukou = 0;

                //�ȉ��ɂ�肽�����Ƃ�?���
                JColorChooser colorchooser = new JColorChooser();
                Color color = JColorChooser.showDialog(null, "Col", new Color(230, 230, 230));
                if (color != null) {
                    kus.set_kousi_color(color);
                }
                //��?�ł�肽�����Ƃ�?���?I���

                repaint();
            }
        });
        Button_kousi_color.setBounds(94, 1, 15, 19);
        Button_kousi_color.setMargin(new Insets(0, 0, 0, 0));
        pnlw9.add(Button_kousi_color);

        //?d�v??��?@�ǂ�?��݂�?���?o���Ńt�@�C���_�C�A??�O�̃{�b�N�X���J����?A������t��?[����?d�Ȃ�ʒu�ő�??����?????A�t�@�C���{�b�N�X��?������Ƃ���?A
        //�}�E�X�̃h���b�O�ƃ���?[�X����?�����?B���̂���?A�]�v�ȑ�??������Ă��܂��\?�������?B�Ȃ�?A���̂Ƃ��}�E�X�N���b�N�͔�?����Ȃ�?B
        // i_mouseDragged_yuukou=0;�� i_mouseReleased_yuukou=0;��?A���̗]�v�ȑ�??��h�����߂Ɏw�肵�Ă���?B

// ********?�**********************************************************************
        //------------------------------------------------
        Panel pnlw34 = new Panel();
        pnlw34.setBounds(2, 2, 93, 20);
        pnlw34.setBackground(Color.PINK);
        pnlw34.setLayout(null);
        //------------------------------------------------
        pnlw.add(pnlw34);

// ****?�**************************************************************************
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

// ****?�**************************************************************************

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


        //���?i�i�q?j��?�   =0�͑S��Ŗ�������?A�i�q??�����͊����[�_�ւ̈����񂹔��a��?ݒ�Ɏg���̂ŗL��?A?�=1�͗p�����̂ݗL��?A?�=2�͑S�̈�ŗL��
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


// ****?�**************************************************************************

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

// *****?�*************************************************************************

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

// *****?�*************************************************************************


        text25 = new JTextField("", 1);
        text25.setHorizontalAlignment(JTextField.RIGHT);
        text25.setBounds(20, 1, 35, 19);
        pnlw33.add(text25);

// *****?�*************************************************************************
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

// *****?�*************************************************************************

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


// -------------�i�q��?���??��?F�̑I��
        JButton Button_kousi_memori_color = new JButton("C");
        Button_kousi_memori_color.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/kousi_memori_color.png";
                readImageFromFile3();
                //Button_kyoutuu_sagyou();
                i_mouseDragged_yuukou = 0;
                i_mouseReleased_yuukou = 0;


                //�ȉ��ɂ�肽�����Ƃ�?���
                JColorChooser colorchooser = new JColorChooser();
                //Color color = colorchooser.showDialog(null, "Col", Color.white    );
                Color color = JColorChooser.showDialog(null, "Col", new Color(180, 200, 180));
                if (color != null) {
                    kus.set_kousi_memori_color(color);
                }
                //��?�ł�肽�����Ƃ�?���?I���

                repaint();
            }
        });
        Button_kousi_memori_color.setBounds(94, 1, 15, 19);
        Button_kousi_memori_color.setMargin(new Insets(0, 0, 0, 0));
        pnlw33.add(Button_kousi_memori_color);


        //?d�v??��?@�ǂ�?��݂�?���?o���Ńt�@�C���_�C�A??�O�̃{�b�N�X���J����?A������t��?[����?d�Ȃ�ʒu�ő�??����?????A�t�@�C���{�b�N�X��?������Ƃ���?A
        //�}�E�X�̃h���b�O�ƃ���?[�X����?�����?B���̂���?A�]�v�ȑ�??������Ă��܂��\?�������?B�Ȃ�?A���̂Ƃ��}�E�X�N���b�N�͔�?����Ȃ�?B
        // i_mouseDragged_yuukou=0;�� i_mouseReleased_yuukou=0;��?A���̗]�v�ȑ�??��h�����߂Ɏw�肵�Ă���?B


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


// *****?�*************************************************************************
        //------------------------------------------------
        Panel pnlw14 = new Panel();
        pnlw14.setBackground(Color.PINK);
        pnlw14.setLayout(new GridLayout(1, 4));
        //pnlw9.setLayout(new FlowLayout(FlowLayout.LEFT));
        //pnlw9.setLayout(new FlowLayout(FlowLayout.LEFT));
        //------------------------------------------------

        pnlw.add(pnlw14);
// *****?�*************************************************************************

        text24 = new JTextField("", 2);
        text24.setHorizontalAlignment(JTextField.RIGHT);
        pnlw14.add(text24);

// *****?�*************************************************************************
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


// *****?�*************************************************************************xxxxxxxxxxxxxx


//------------------------------------------------qqqqqq
// ***��***************************************************************************

        // *************************************************
        //�E��?i����?j�p�l����?\�z*************************
        // *************************************************
        //�E��?i����?j�p�l����???�
        Panel pnle = new Panel();
        pnle.setBackground(Color.PINK);
        pnle.setLayout(new GridLayout(28, 1));

        //�E��?i����?j�p�l�������C�A�E�g�ɓ\��t��
        add("East", pnle); //Frame�p
        //contentPane.add(pnle, BorderLayout.EAST);//JFrame�p
//------------------------------------------------


        //------------------------------------------------
        Panel pnle20 = new Panel();
        pnle20.setBackground(Color.PINK);
        pnle20.setLayout(new GridLayout(1, 2));
        pnle.add(pnle20);
        //------------------------------------------------
// ***��***�`�F�b�N�n************************************************************************


        ckbox_check1 = new JCheckBox("ckO");
        ckbox_check1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/check1.png";
                readImageFromFile3();
                es1.unselect_all();

                if (ckbox_check1.isSelected()) {
                    es1.check1(0.001, 0.5);//r_hitosii��r_heikouhantei��?Ahitosii��heikou_hantei�̂���̋��e���x
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


// ***��***�`�F�b�N�n************************************************************************

        ckbox_check2 = new JCheckBox("ckT");
        ckbox_check2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/check2.png";
                readImageFromFile3();
                es1.unselect_all();

                if (ckbox_check2.isSelected()) {
                    es1.check2(0.01, 0.5);//r_hitosii��r_heikouhantei��?Ahitosii��heikou_hantei�̂���̋��e���x
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


// ***��****�`�F�b�N�n***********************************************************************
        //------------------------------------------------
        Panel pnle22 = new Panel();
        pnle22.setBackground(Color.PINK);
        pnle22.setLayout(new GridLayout(1, 2));
        //pnle.add(pnle22);
        //------------------------------------------------

//---�`�F�b�N�n---------------------------------------20170717 �܂�ckbox_check3�͎������Ă��Ȃ�?B

        ckbox_check3 = new JCheckBox("check A");
        ckbox_check3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/check3.png";
                readImageFromFile3();
                es1.unselect_all();

                if (ckbox_check3.isSelected()) {
                    es1.check3(0.0001);//r_hitosii��r_heikouhantei��?Ahitosii��heikou_hantei�̂���̋��e���x
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


//---------------���_�̃`�F�b�N---------------------------
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
                    es1.check4(0.0001);//r_hitosii��r_heikouhantei��?Ahitosii��heikou_hantei�̂���̋��e���x
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

// ****��**************************************************************************
        //------------------------------------------------
        Panel pnle29 = new Panel();
        pnle29.setBackground(Color.PINK);
        pnle29.setLayout(new GridLayout(1, 2));
        pnle23.add(pnle29);
        //------------------------------------------------


// ****��***���_�`�F�b�N���ʕ\���~��?F�̔Z����?�?@����***********************************************************************

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

// ****��***���_�`�F�b�N���ʕ\���~��?F�̔Z����?�?@?グ***********************************************************************

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

// ��***?@�p�x�n����?@***************************************************************************

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
// ***?@�p�x�n����?@***************************************************************************


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


// *��**?@�p�x�n����?@***************************************************************************


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

//��******************************************************************************


        //------------------------------------------------
        Panel pnle7 = new Panel();
        pnle7.setBackground(Color.PINK);
        //pnle6.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnle7.setLayout(null);
        //------------------------------------------------
        pnle.add(pnle7);

//��******?@�p�x�n����?@************************************************************************

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
// ��******************************************************************************


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


// ��******************************************************************************


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

//��******************************************************************************


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


// ��******************************************************************************


// *******��***********************************************************************

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


// *******��***********************************************************************

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


// -----���R�pset
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

// -----���R�pset?B�����܂�


// *******��***********************************************************************

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


// -----���R�pset
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

// -----���R�pset?B�����܂�


// *******��***********************************************************************


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


// -------------13;�p�x�n��?[�h?B
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
// -------------13;�p�x�n��?[�h?B�����܂�


// -----��--------17;�p�x�n��?[�h?B//2�_�w��
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
// ------��-------17;�p�x�n��?[�h?B�����܂�

// -------------37;�p�x�K�i��??�����̓�?[�h?B
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


// -------------37;�p�x�K�i��??�����̓�?[�h?B�����܂�


        //------------------------------------------------
        Panel pnle3 = new Panel();
        pnle3.setBackground(Color.PINK);
        pnle3.setLayout(new GridLayout(1, 2));

        //------------------------------------------------
        pnle.add(pnle3);
// ----��---------16;�p�x�n��?[�h?B
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
// -------------16;�p�x�n��?[�h?B�����܂�

// ----��---------18;�p�x�n��?[�h?B2�_�w��?A���R���[
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
// -------------18;�p�x�n��?[�h?B�����܂�


//��********��**********************************************************************


        //------------------------------------------------
        Panel pnle5 = new Panel();
        pnle5.setBackground(Color.PINK);
        pnle5.setLayout(new GridLayout(1, 3));

        pnle.add(pnle5);
        //------------------------------------------------

// ******��************************************************************************
// -----1;sei ?����p�`���̓�?[�h?B�p?��?��
        text9 = new JTextField("", 2);
        text9.setHorizontalAlignment(JTextField.RIGHT);
        pnle5.add(text9);


// -------------------------------------------------------------------------------

        //Button	Button_senbun_bunkatu_set
// -----1;	�p?�set
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

// ------1;�p?�set?B�����܂�


// ------------------------qqqqqqqq-------------------------------------------------------

// -----29;?����p�`���̓�?[�h?B
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

// ------29;?����p�`���̓�?[�h?B�����܂�

// ********��******************************

        //------------------------------------------------
        Panel pnle31 = new Panel();
        pnle31.setBackground(Color.PINK);
        pnle31.setLayout(new GridLayout(1, 2));
        pnle.add(pnle31);
        //------------------------------------------------


// *************** �~?@?�??�Ƃ͑���??�p�����????�Ƃ��ē��� *************************************

// ********��******************************
        //------------------------------------------------
        Panel pnle9 = new Panel();
        pnle9.setBackground(Color.PINK);
        pnle9.setLayout(new GridLayout(1, 2));
        //------------------------------------------------
        pnle.add(pnle9);

// -------------47;�~���̓�?[�h?B(�t��?[)
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


// -------------47;�~���̓�?[�h?B�����܂�


// -------------42;�~���̓�?[�h?B
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


// -------------42;�~���̓�?[�h?B�����܂�

// -------------44;�~?@�������̓�?[�h?B(��?S�Ɣ��a�Ƃ𗣂��Ďw�肷��)
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


// -------------44;�~?@�������̓�?[�h?B�����܂�

        //------------------------------------------------
        Panel pnle16 = new Panel();
        pnle16.setBackground(Color.PINK);
        pnle16.setLayout(new GridLayout(1, 3));

        pnle.add(pnle16);
        //------------------------------------------------


// -------------48;�~?@��?S�~�ǉ���?[�h?B(���~�̉~���Ɠ�?S�~�̉~���Ƃ�??��??���Ŏw�肷��)
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

// -------------48;�~?@��?S�~�ǉ���?[�h?B�����܂�

// -------------49;�~?@��?S�~�ǉ���?[�h?B(���~�̉~���Ɠ�?S�~�̉~���Ƃ�??�͑��̓�?S�~�̑g�Ŏw�肷��)
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

// -------------49;�~?@��?S�~�ǉ���?[�h?B�����܂�

// ******************************************************************************


        //------------------------------------------------
        Panel pnle17 = new Panel();
        pnle17.setBackground(Color.PINK);
        pnle17.setLayout(new GridLayout(1, 3));

        pnle.add(pnle17);
        //------------------------------------------------


// -------------50;2�~���w�肵?A���ꂼ��̉~�ɓ�?S�~��������?B���ꂼ��̓�?S�~�̑g�ɂł���ї̈��??���������Ȃ�悤�ɂ���?A������ꂽ��?S�~���m��?ڂ���悤�ɂ���?B
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

// -------------50;2�~�̋���?�??���̓�?[�h?B�����܂�


// -------------45;2�~�̋���?�??���̓�?[�h?B
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

// -------------45;2�~�̋���?�??���̓�?[�h?B�����܂�


// ********��******************************
        //------------------------------------------------
        Panel pnle10 = new Panel();
        pnle10.setBackground(Color.PINK);
        pnle10.setLayout(new GridLayout(1, 3));
        //------------------------------------------------
        pnle.add(pnle10);


// ******************************************************************************
// -------------43;3�_�~���̓�?[�h?B
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

// -------------43;3�_�~���̓�?[�h?B�����܂�


// ******************************************************************************
// -------------46;���]���̓�?[�h?B
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

// -------------46;���]���̓�?[�h?B�����܂�


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

// ---------��????��~��?F���??�ŕς��邳���̎w��?F�̎w��
        Button_sen_tokutyuu_color = new JButton("C_col ");
        Button_sen_tokutyuu_color.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/sen_tokutyuu_color.png";
                readImageFromFile3();
                Button_kyoutuu_sagyou();
                i_mouseDragged_yuukou = 0;
                i_mouseReleased_yuukou = 0;
                //�ȉ��ɂ�肽�����Ƃ�?���
                JColorChooser colorchooser = new JColorChooser();

                Color color = JColorChooser.showDialog(null, "color", new Color(100, 200, 200));
                if (color != null) {
                    sen_tokutyuu_color = color;
                }


                //��?�ł�肽�����Ƃ�?���?I���
                Button_sen_tokutyuu_color.setBackground(sen_tokutyuu_color);    //�{�^����?F?ݒ�

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

        //?d�v??��?@�ǂ�?��݂�?���?o���Ńt�@�C���_�C�A??�O�̃{�b�N�X���J����?A������t��?[����?d�Ȃ�ʒu�ő�??����?????A�t�@�C���{�b�N�X��?������Ƃ���?A
        //�}�E�X�̃h���b�O�ƃ���?[�X����?�����?B���̂���?A�]�v�ȑ�??������Ă��܂��\?�������?B�Ȃ�?A���̂Ƃ��}�E�X�N���b�N�͔�?����Ȃ�?B
        // i_mouseDragged_yuukou=0;�� i_mouseReleased_yuukou=0;��?A���̗]�v�ȑ�??��h�����߂Ɏw�肵�Ă���?B
// --------------------------------------

// -------------;??��?F��??��?X(��?��???�̂�)
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

// ********��******************************
        //------------------------------------------------
        Panel pnle15 = new Panel();
        pnle15.setBackground(Color.PINK);
        pnle15.setLayout(new GridLayout(1, 2));
        //------------------------------------------------
        //pnle.add(pnle15);


// *************** ��?????@?�??�Ƃ͑���??�p����?A�����̊G�Ƃ���?U���� *************************************


// ****��**************************************************************************

        //------------------------------------------------
        Panel pnle12 = new Panel();
        pnle12.setBackground(Color.PINK);
        pnle12.setLayout(new GridLayout(1, 3));

        pnle.add(pnle12);
        //------------------------------------------------

// *****��*************************************************************************

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


// *****��*************************************************************************


        text11 = new JTextField("", 1);
        text11.setHorizontalAlignment(JTextField.RIGHT);

        pnle12.add(text11);
// *****��*************************************************************************

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


// *****��*************************************************************************


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

// ********��******************************
        //------------------------------------------------
        Panel pnle11 = new Panel();
        pnle11.setBackground(Color.PINK);
        pnle11.setLayout(new GridLayout(1, 2));
        //------------------------------------------------
        pnle.add(pnle11);


// ********��******************************
        //------------------------------------------------
        Panel pnle14 = new Panel();
        pnle14.setBackground(Color.PINK);
        pnle14.setLayout(new GridLayout(1, 2));
        //------------------------------------------------
        pnle11.add(pnle14);

// ****��**************************************************************************��????��???�����
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

// ****��**************************************************************************��????��??�傫��

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
// ******��************************************************************************
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
// ******��************************************************************************
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
// ******��************************************************************************

        //------------------------------------------------
        Panel pnle13 = new Panel();
        pnle13.setBackground(Color.PINK);
        pnle13.setLayout(new GridLayout(1, 2));
        //------------------------------------------------
        pnle.add(pnle13);

// -------------h_1;��????���̓�?[�h?B
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
                i_orisen_hojyosen = 1;//=0��?�??����?@=1�͕�????���̓�?[�h
                es1.set_i_orisen_hojyosen(i_orisen_hojyosen);
            }
        });

        pnle13.add(Button_h_senbun_nyuryoku);

        Button_h_senbun_nyuryoku.setMargin(new Insets(0, 0, 0, 0));
        Button_h_senbun_nyuryoku.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/h_senbun_nyuryoku.png")));


// -------------h_1;��????���̓�?[�h?B�����܂�

// ******��************************************************************************ ?����S��
// -------------;h_??��???��??[�h?B

        JButton Button_h_senbun_sakujyo = new JButton("");//JButton	Button_senbun_sakujyo	= new JButton(	"L_del"	);
        Button_h_senbun_sakujyo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/h_senbun_sakujyo.png";
                readImageFromFile3();
                i_mouse_modeA = 3;
                System.out.println("i_mouse_modeA = " + i_mouse_modeA);


                i_orisen_hojyosen = 1;//=0��?�??����?@=1�͕�????���̓�?[�h
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

// ******��************************************************************************
        //------------------------------------------------
        Panel pnle30 = new Panel();
        pnle30.setBackground(Color.PINK);
        pnle30.setLayout(new GridLayout(1, 2));
        pnle.add(pnle30);
        //------------------------------------------------

// ******��************************************************************************
// ---------------------------------------------------------------------------------------------------------------
        EtchedBorder border = new EtchedBorder(EtchedBorder.RAISED, Color.white, Color.black);

        //------------------------------------------------
        Panel pnle24 = new Panel();
        pnle24.setBounds(2, 2, 93, 20);
        pnle24.setBackground(Color.PINK);
        pnle24.setLayout(null);
        //------------------------------------------------
        pnle.add(pnle24);

// -------------����1���胂?[�h?B
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
// -------------����1���胂?[�h?B�����܂�
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
// -------------����2���胂?[�h?B
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
// -------------����2���胂?[�h?B�����܂�
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
// -------------�p�x1���胂?[�h?B
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
// -------------�p�x1���胂?[�h?B�����܂�
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
// -------------�p�x2���胂?[�h?B
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
// -------------�p�x2���胂?[�h?B�����܂�
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
// -------------�p�x3���胂?[�h?B
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
// -------------�p�x3���胂?[�h?B�����܂�
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
// ***��***************************************************************************************************************************************************************************


        // *************************************************
        //����?i�쑤?j�p�l����?\�z*************************
        // *************************************************
        //����?i�쑤?j�p�l����???�
        //Panel pnls = new Panel();pnls.setBackground(new Color(0,70,0));
        Panel pnls = new Panel();
        pnls.setBackground(Color.PINK);
        pnls.setLayout(new FlowLayout(FlowLayout.LEFT));
        //����?i�쑤?j�p�l�������C�A�E�g�ɓ\��t��
        add("South", pnls); //Frame�p
        //contentPane.add(pnls, BorderLayout.SOUTH);//JFrame�p


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


// ***?�***************************************************************************�f?[�^�ǂ�?��ݒǉ�

        JButton Button_yomi_tuika = new JButton("Op");
        Button_yomi_tuika.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/yomi_tuika.png";
                readImageFromFile3();

                Button_kyoutuu_sagyou();

                i_mouseDragged_yuukou = 0;
                i_mouseReleased_yuukou = 0;
                Memo memo_temp = new Memo();

                System.out.println("readFile2Memo() �J�n");
                memo_temp = readFile2Memo();
                System.out.println("readFile2Memo() ?I��");

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
//cp��?�?�ݑO�Ɏ������P����
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
//select?�Ԃ𑼂̑�??�����Ă��Ȃ�ׂ��c��
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


// ***?�****************************************************************** �Q?F�W�J?}************************************************
        JButton Button_2syoku_tenkaizu = new JButton("");//new JButton(	"Del_F"	);
        Button_2syoku_tenkaizu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/2syoku_tenkaizu.png";
                readImageFromFile3();

                //	i_fold_type=1;
                Ss0 = es1.get_for_select_oritatami();

                if (es1.get_orisensuu_for_select_oritatami() == 0) {        //?܂�??�I�𖳂�
                    keikoku_sentaku_sareta_orisen_ga_nai();//�x???@�I�����ꂽ?�??���Ȃ�


                } else if (es1.get_orisensuu_for_select_oritatami() > 0) {
                    oritatami_jyunbi();//������OZ��OAZ(0)����OAZ(i)��?؂�ւ��
                    //OZ.ts1.Senbunsyuugou2Tensyuugou(es1.get_for_select_oritatami());
                    OZ.i_suitei_meirei = 5;

                    if (i_SubThread == 0) {
                        i_SubThread = 1;
                        i_sub_mode = 4;
                        mks();//?V�����X���b�h��??��
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


        // **********��***************************************************************

        JButton Button_suitei_01 = new JButton("CP_rcg");
        Button_suitei_01.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/suitei_01.png";
                readImageFromFile3();

                oritatame(get_i_fold_type(), 1);//��?��̈Ӗ���(i_fold_type , i_suitei_meirei);
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


        // *********��****************************************************************
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

        // **********��***************************************************************


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


// *******��******************************************************************


        JButton Button_suitei_02 = new JButton("");//new JButton(	"Wire_gr"	)
        Button_suitei_02.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/suitei_02.png";
                readImageFromFile3();


                oritatame(get_i_fold_type(), 2);//��?��̈Ӗ���(i_fold_type , i_suitei_meirei);
                if (ckbox_select_nokosi.isSelected()) {
                } else {
                    es1.unselect_all();
                }

                Button_kyoutuu_sagyou();
                //repaint();


            }
        });
        pnlw36.add(Button_suitei_02);

        Button_suitei_02.setBounds(0, 0, 20, 21);//20180210,4�Ԗڂ�21��23��?ゾ�ƃA�C�R���\�����������ĕ����I�ɂ����\������Ȃ�

        Button_suitei_02.setMargin(new Insets(0, 0, 0, 0));
        Button_suitei_02.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/suitei_02.png")));

// *******��******************************************************************


        //------------------------------------------------
        JPanel pnls4 = new JPanel();
        pnls4.setPreferredSize(new Dimension(76, 21));//pnls4.setPreferredSize(new Dimension(76, 30)
        pnls4.setBackground(Color.white);
        pnls4.setLayout(null);
        //pnls4.setBorder(new LineBorder(Color.black, 1));
        pnlw36.add(pnls4);
        pnls4.setBounds(30, 0, 76, 21);//20180210,4�Ԗڂ�21��23��?ゾ�ƃA�C�R���\�����������ĕ����I�ɂ����\������Ȃ�

        //------------------------------------------------

// *******��******************************************************************

        JButton Button_suitei_03 = new JButton("");//����?}�\��new JButton(	"Transparent_gr"	);
        Button_suitei_03.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/suitei_03.png";
                readImageFromFile3();

                oritatame(get_i_fold_type(), 3);//��?��̈Ӗ���(i_fold_type , i_suitei_meirei);

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


// ******��*******************************************************************ccccccccccccccc
//����?}���J��?[������?B

        ckbox_toukazu_color = new JCheckBox("");
        ckbox_toukazu_color.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname =
                        "qqq/ckbox_toukazu_color.png";
                readImageFromFile3();
                if (ckbox_toukazu_color.isSelected()) {
                    OZ.i_toukazu_color = 1;
                    System.out.println("ckbox_toukazu_color.isSelected()");
                }//�J��?[�̓���?}
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


// *******����?}��?F�̔Z����?�?@����***********************************************************************

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


// *******����?}��?F�̔Z����?�?@?グ***********************************************************************

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


// ********��*****************************************************************
        JButton Button_suitei_04 = new JButton("Fold");
        Button_suitei_04.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/suitei_04.png";
                readImageFromFile3();

                //i_fold_type=0;//=0�Ȃɂ����Ȃ�?A=1��?��̓W�J?}�̑S?�??���?ۂƂ���?܂�?��??��?A=2��select���ꂽ?�??���?ۂƂ���?܂�?��??��?A=3��?�?��?�Ԃ��?X

                System.out.println("20180220 get_i_fold_type() = " + get_i_fold_type());
                oritatame(get_i_fold_type(), 5);//��?��̈Ӗ���(i_fold_type , i_suitei_meirei);

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

// *******��******************************************************************


// *****��********************************************************************
        //-------------------------------------
        Button3 = new JButton("a_s");//Button3 = new JButton(	"Another sol"	);
        Button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/Button3.png";
                readImageFromFile3();

                //OZ.i_suitei_jissi_umu=0;//i_suitei_jissi_umu��?A?܂�?��??��̌v�Z�����{�������ǂ�����\��?Bint i_suitei_jissi_umu=0�Ȃ���{���Ȃ�?B1�Ȃ���{����?B
                OZ.i_suitei_meirei = 6;


                i_sub_mode = 0;//1=?�?��??��̕ʉ����܂Ƃ߂�?o��?B0=?�?��??��̕ʉ����܂Ƃ߂�?o����?[�h�ł͂Ȃ�?B���̕�?��̓T�u�X���b�h�̓�??��?X�ɂ���?B
                if (i_SubThread == 0) {
                    i_SubThread = 1;
                    mks();//?V�����X���b�h��??��
                    sub.start();
                }
            }
        });
        pnls.add(Button3);
        Button3.setMargin(new Insets(0, 0, 0, 0));


// *******��***************************************************** //System.out.println("���\");*************
        //------------------------------------------------------------------------------------------------------
        Button0b = new JButton("");//new JButton(	"Back"		);
        Button0b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/Button0b.png";
                readImageFromFile3();
                //ip4==0 �\?Aip4==1?@��?Aip4==2?Aip4==3?@�����Ɠ���
                OZ.ip4 = OZ.ip4 + 1;
                if (OZ.ip4 == 4) {
                    OZ.ip4 = 0;
                }
                if ((i_mouse_modeA == 101) && (OZ.ip4 == 2)) {
                    OZ.ip4 = 0;
                }//?܂�?オ��\�z?}�������̂Ƃ�?A�������ł��Ȃ��Ȃ郂?[�h������邽�߂ɒǉ�
                Button_kyoutuu_sagyou();
                repaint();
            }
        });
        pnls.add(Button0b);

        Button0b.setMargin(new Insets(0, 0, 0, 0));
        Button0b.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/Button0b.png")));


// *****��********************************************************************
        //-------------------------------------
        Button_AS_matome = new JButton("AS100");
        Button_AS_matome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

//i_AS_matome_mode =1;//1=?�?��??��̕ʉ����܂Ƃ߂�?o��?B0=?�?��??��̕ʉ����܂Ƃ߂�?o����?[�h�ł͂Ȃ�?B���̕�?��̓T�u�X���b�h�̓�??��?X�ɂ�������?B20170611��Ver3.008����ǉ�
                i_sub_mode = 1;
                img_kaisetu_fname =
                        "qqq/AS_matome.png";
                readImageFromFile3();
                if (OZ.betu_sagasi_flg == 1) {
                    //OZ.i_suitei_jissi_umu=0;//i_suitei_jissi_umu��?A?܂�?��??��̌v�Z�����{�������ǂ�����\��?Bint i_suitei_jissi_umu=0�Ȃ���{���Ȃ�?B1�Ȃ���{����?B
                    OZ.i_suitei_meirei = 6;

                    if (i_SubThread == 0) {
                        i_SubThread = 1;
                        mks();//?V�����X���b�h��??��
                        sub.start();

                    }
                }
            }
        });
        pnls.add(Button_AS_matome);
        Button_AS_matome.setMargin(new Insets(0, 0, 0, 0));


// **********��***************************************************************


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
// -----;	//?܂�?��??��̎w��Ԗڂ�\������
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
                    settei_syokika_yosoku();//?܂�?オ��\�z�̔p��
                    OZ.i_suitei_meirei = 51;    //i_suitei_meirei=51��oritatami_suitei��?�?���??��?}�p�J??����?ݒ�͑f�ʂ肷�邽�߂�?ݒ�?B??��?}�p�J??����?ݒ��f�ʂ肵����?Ai_suitei_meirei=5�ɕ�?X�����?B
                    //1��ڂ�?܂�?オ��\�z��i_suitei_meirei=5���w��?A2��ڈ�?~��?܂�?オ��\�z��i_suitei_meirei=6�Ŏ��{�����
                    //betu_sagasi_flg=1;
                }

                //OZ.i_suitei_jissi_umu=0;//i_suitei_jissi_umu��?A?܂�?��??��̌v�Z�����{�������ǂ�����\��?Bint i_suitei_jissi_umu=0�Ȃ���{���Ȃ�?B1�Ȃ���{����?B

                i_sub_mode = 2;
                if (i_SubThread == 0) {
                    i_SubThread = 1;
                    mks();//?V�����X���b�h��??��
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

// ------�����܂�


//?܂�?オ��?}	��redo��undo

// *****��*************************************************************************rrrrrrrrr

        JButton Button_undo_om = new JButton("");//_om��?܂�?オ��?}���f�B�t�@�C?i�ό`?j�̈Ӗ�
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

// *****��*************************************************************************


        text31 = new JTextField("", 1);
        text31.setHorizontalAlignment(JTextField.RIGHT);

        pnls.add(text31);
// *****��*************************************************************************
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


// *****��*************************************************************************

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


// ******��*******************************************************************
        JButton Button_oriagari_sousa = new JButton("");//?܂�?オ��?}��???@?j��?}(	"F_Modify"		)
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

// ******��*******************************************************************

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

// *******��******************************************************************
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

// *******��******************************************************************

        //------------------------------------------------
        JPanel pnls2 = new JPanel();
        pnls2.setPreferredSize(new Dimension(109, 30));
        pnls2.setBackground(Color.white);
        pnls2.setLayout(null);
        pnls2.setBorder(new LineBorder(Color.black, 1));
        pnls.add(pnls2);
        //------------------------------------------------


// ********��*****************************************************************
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


// *******��******************************************************************

        text29 = new JTextField("", 2);
        text29.setBounds(29, 4, 35, 24);
        text29.setHorizontalAlignment(JTextField.RIGHT);

        pnls2.add(text29);

// ****��**************************************************************************

// -----?k�ڌW?�set
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


// ------?k�ڌW?�set?B�����܂�


// ****��**************************************************************************


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


// *****��********************************************************************
        //------------------------------------------------
        JPanel pnls3 = new JPanel();
        pnls3.setPreferredSize(new Dimension(119, 30));
        pnls3.setBackground(Color.white);
        pnls3.setLayout(null);
        pnls3.setBorder(new LineBorder(Color.black, 1));
        pnls.add(pnls3);
        //------------------------------------------------

// *****��********************************************************************
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


// ****��**************************************************************************
//��]�p�x��?�
        text30 = new JTextField("", 2);
        text30.setBounds(34, 4, 35, 24);
        text30.setHorizontalAlignment(JTextField.RIGHT);
        pnls3.add(text30);

// ****��**************************************************************************

// -----��]�p�x��?�set
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


// ------��]�p�x��?�set?B�����܂�


// ******��*******************************************************************
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

// *******��******************************************************************


// ******************************************************** //?܂肠����?}��anti_alias�A���`�F�C���A�X�̕�?X

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
// ******************************************************** //?܂肠����?}�̉e�t��

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
// *********��****************************************************************
// -------------?܂�?オ��\��?}�\�ʂ�?F�̑I��

        Button_F_color = new JButton(" ");
        Button_F_color.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/F_color.png";
                readImageFromFile3();
                Button_kyoutuu_sagyou();
                i_mouseDragged_yuukou = 0;
                i_mouseReleased_yuukou = 0;
                //System.out.println("readFile2Memo() �J�n");

                //�ȉ��ɂ�肽�����Ƃ�?���
                JColorChooser colorchooser = new JColorChooser();
                //Color color = colorchooser.showDialog(null, "F_col", Color.white);
                //if(color != null){OZ.js.set_F_color(color);}

                OZ.oriagarizu_F_color = JColorChooser.showDialog(null, "F_col", Color.white);
                if (OZ.oriagarizu_F_color != null) {
                    OZ.js.set_F_color(OZ.oriagarizu_F_color);
                }


                //��?�ł�肽�����Ƃ�?���?I���

                Button_F_color.setBackground(OZ.oriagarizu_F_color);    //�{�^����?F?ݒ�

                repaint();
            }
        });
        //Button_F_color.setPreferredSize(new Dimension(25, 25));
        Button_F_color.setMargin(new Insets(0, 0, 0, 0));
        Button_F_color.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/F_color.png")));
        pnls.add(Button_F_color);


        //?d�v??��?@�ǂ�?��݂�?���?o���Ńt�@�C���_�C�A??�O�̃{�b�N�X���J����?A������t��?[����?d�Ȃ�ʒu�ő�??����?????A�t�@�C���{�b�N�X��?������Ƃ���?A
        //�}�E�X�̃h���b�O�ƃ���?[�X����?�����?B���̂���?A�]�v�ȑ�??������Ă��܂��\?�������?B�Ȃ�?A���̂Ƃ��}�E�X�N���b�N�͔�?����Ȃ�?B
        // i_mouseDragged_yuukou=0;�� i_mouseReleased_yuukou=0;��?A���̗]�v�ȑ�??��h�����߂Ɏw�肵�Ă���?B


// -------------?܂�?オ��\��?}���ʂ�?F�̑I��

        Button_B_color = new JButton(" ");
        Button_B_color.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/B_color.png";
                readImageFromFile3();
                Button_kyoutuu_sagyou();
                i_mouseDragged_yuukou = 0;
                i_mouseReleased_yuukou = 0;
                //System.out.println("readFile2Memo() �J�n");

                //�ȉ��ɂ�肽�����Ƃ�?���
                JColorChooser colorchooser = new JColorChooser();
                //Color color = colorchooser.showDialog(null, "B_col", Color.white);
                OZ.oriagarizu_B_color = JColorChooser.showDialog(null, "B_col", Color.white);

                if (OZ.oriagarizu_B_color != null) {
                    OZ.js.set_B_color(OZ.oriagarizu_B_color);
                }
                //��?�ł�肽�����Ƃ�?���?I���

                Button_B_color.setBackground(OZ.oriagarizu_B_color);    //�{�^����?F?ݒ�
                repaint();
            }
        });
        //Button_B_color.setPreferredSize(new Dimension(25, 25));
        Button_B_color.setMargin(new Insets(0, 0, 0, 0));
        Button_B_color.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/B_color.png")));
        pnls.add(Button_B_color);


        //?d�v??��?@�ǂ�?��݂�?���?o���Ńt�@�C���_�C�A??�O�̃{�b�N�X���J����?A������t��?[����?d�Ȃ�ʒu�ő�??����?????A�t�@�C���{�b�N�X��?������Ƃ���?A
        //�}�E�X�̃h���b�O�ƃ���?[�X����?�����?B���̂���?A�]�v�ȑ�??������Ă��܂��\?�������?B�Ȃ�?A���̂Ƃ��}�E�X�N���b�N�͔�?����Ȃ�?B
        // i_mouseDragged_yuukou=0;�� i_mouseReleased_yuukou=0;��?A���̗]�v�ȑ�??��h�����߂Ɏw�肵�Ă���?B


// -------------?܂�?オ��\��?}?@??��?F�̑I��

        Button_L_color = new JButton(" ");
        Button_L_color.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_kaisetu_fname = "qqq/L_color.png";
                readImageFromFile3();
                Button_kyoutuu_sagyou();
                i_mouseDragged_yuukou = 0;
                i_mouseReleased_yuukou = 0;
                //System.out.println("readFile2Memo() �J�n");

                //�ȉ��ɂ�肽�����Ƃ�?���
                JColorChooser colorchooser = new JColorChooser();
                //Color color = colorchooser.showDialog(null, "L_col", Color.white);
                //if(color != null){js.set_L_color(color);}

                OZ.oriagarizu_L_color = JColorChooser.showDialog(null, "L_col", Color.white);
                if (OZ.oriagarizu_L_color != null) {
                    OZ.js.set_L_color(OZ.oriagarizu_L_color);
                }


                //��?�ł�肽�����Ƃ�?���?I���

                Button_L_color.setBackground(OZ.oriagarizu_L_color);    //�{�^����?F?ݒ�
                repaint();
            }
        });
        //Button_L_color.setPreferredSize(new Dimension(25, 25));
        Button_L_color.setMargin(new Insets(0, 0, 0, 0));
        Button_L_color.setIcon(new ImageIcon(getClass().getClassLoader().getResource(
                "ppp/L_color.png")));
        pnls.add(Button_L_color);


        //?d�v??��?@�ǂ�?��݂�?���?o���Ńt�@�C���_�C�A??�O�̃{�b�N�X���J����?A������t��?[����?d�Ȃ�ʒu�ő�??����?????A�t�@�C���{�b�N�X��?������Ƃ���?A
        //�}�E�X�̃h���b�O�ƃ���?[�X����?�����?B���̂���?A�]�v�ȑ�??������Ă��܂��\?�������?B�Ȃ�?A���̂Ƃ��}�E�X�N���b�N�͔�?����Ȃ�?B
        // i_mouseDragged_yuukou=0;�� i_mouseReleased_yuukou=0;��?A���̗]�v�ȑ�??��h�����߂Ɏw�肵�Ă���?B


// *******��******************************************************************
        JButton Button_keisan_tyuusi = new JButton("");//?܂�?オ��\�z�̌v�Z�̒��~
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


// *******��****************************************************************** ?܂�?オ��\�z�̔p�� ************************************************
        JButton Button_settei_syokika = new JButton("");//new JButton(	"Del_F"	);
        Button_settei_syokika.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/settei_syokika.png";
                readImageFromFile3();


                if (i_OAZ == 0) {
                    return;
                }
                OZ = temp_OZ;//20171223����?s�͕s�v��������Ȃ���?A��?u�ł�OZ������Oriagari_Zu���Ȃ��Ȃ邱�Ƃ��Ȃ��悤�ɔO�̂��߂ɓ���Ă���
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

// *******��*************bbbbbbbbbb*****************************************************�S��??�p�� (�ToT)� ��:�'.::�  ****************************************************

        JButton Button_zen_syokika = new JButton("");//new JButton(	"Del_all"	);
        Button_zen_syokika.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                img_kaisetu_fname = "qqq/zen_syokika.png";
                readImageFromFile3();

                //�W�J?}��?�����?@�J�n
                //settei_syokika_cp();//�W�J?}�p��???[�^��?�����
                tenkaizu_syokika();
                //�W�J?}��?�����?@?I��
                //
                //?�?��\��?}�̂�?�����?@�J�n
                OZ = temp_OZ;//20171223����?s�͕s�v��������Ȃ���?A��?u�ł�OZ������Oriagari_Zu���Ȃ��Ȃ邱�Ƃ��Ȃ��悤�ɔO�̂��߂ɓ���Ă���
                OAZ.clear();
                OAZ_add_new_Oriagari_Zu();
                set_i_OAZ(0);
                settei_syokika_yosoku();
                //?�?��\��?}�̂�?�����?@?I��

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

// *******��*********�{�^���̒�`�͂����܂�*******************************************************************************************************************************

        //�W�J?}��?�����?@�J�n
        //settei_syokika_cp();//�W�J?}�p��???[�^��?�����
        tenkaizu_syokika();
        //�W�J?}��?�����?@?I��

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
        Button_sel_mou_wakukae();//�Z���N�g���ꂽ?�??������?�Ԃ�?A�Z���N�g����Ă���?�??�̒��_���N���b�N����???��̓�??��?[�h��?��??ݒ�

        //?�?��\��?}�̂�?�����?@�J�n
        settei_syokika_yosoku();
        //?�?��\��?}�̂�?�����?@?I��

        Button_kyoutuu_sagyou();

        repaint();

        img_kaisetu_fname = "qqq/a__hajimeni.png";
        readImageFromFile3();

        Button_sen_tokutyuu_color.setBackground(sen_tokutyuu_color);//��???F�̎w��?F�\��

        // ���蒷���Ɗp�x�̕\��

        es1.sokutei_hyouji();
        es1.setCamera(camera_of_orisen_nyuuryokuzu);

        //Ubox.test1();
        es1.kiroku();
        es1.h_kiroku();

        //?܂�?オ��?}��?F�w��
        //Color oriagarizu_F_color=new Color(255,255,50);//?܂�?オ��?}�̕\�ʂ�?F
        //Color oriagarizu_B_color=new Color(233,233,233);//?܂�?オ��?}�̗��ʂ�?F
        //Color oriagarizu_L_color=Color.black;//?܂�?オ��?}��??��?F


        OZ.js.set_F_color(OZ.oriagarizu_F_color); //?܂�?オ��?}�̕\�ʂ�?F
        Button_F_color.setBackground(OZ.oriagarizu_F_color);    //�{�^����?F?ݒ�

        OZ.js.set_B_color(OZ.oriagarizu_B_color);//?܂�?オ��?}�̗��ʂ�?F
        Button_B_color.setBackground(OZ.oriagarizu_B_color);//�{�^����?F?ݒ�

        OZ.js.set_L_color(OZ.oriagarizu_L_color);        //?܂�?オ��?}��??��?F
        Button_L_color.setBackground(OZ.oriagarizu_L_color);        //�{�^����?F?ݒ�


        //wwwwwwwwwwwwwwwwwwwwwww


    }//------------------------------------------�{�^���̒�`��?A�����܂ł��R���X�g���N�^�Ƃ��ċN�������?�?��Ɏ�?s�������e

// **************************************************************************************************************************
// **************************************************************************************************************************
// **************************************************************************************************************************

    private int get_i_fold_type() {

        int i_fold_type = 0;//=0�Ȃɂ����Ȃ�?A=1��?��̓W�J?}�̑S?�??���?ۂƂ���?܂�?��??��?A=2��select���ꂽ?�??���?ۂƂ���?܂�?��??��?A=3��?�?��?�Ԃ��?X
        System.out.println("OAZ.size() = " + OAZ.size() + "    : i_OAZ = " + i_OAZ + "    : es1.get_orisensuu_for_select_oritatami() = " + es1.get_orisensuu_for_select_oritatami());
        i_fold_type = 0;
        if (OAZ.size() == 1) {                        //?܂�?オ��n?}����
            if (i_OAZ == 0) {                            //�W�J?}�w��
                if (es1.get_orisensuu_for_select_oritatami() == 0) {        //?܂�??�I�𖳂�
                    i_fold_type = 1;//�S�W�J?}��?�?��
                } else if (es1.get_orisensuu_for_select_oritatami() > 0) {        //?܂�??�I��L��
                    i_fold_type = 2;//�I�����ꂽ�W�J?}��?�?��
                }
            } else if (i_OAZ > 0) {                        //?܂�?オ��n?}�w��
                i_fold_type = 0;//�L�蓾�Ȃ�
            }
        } else if (OAZ.size() > 1) {                        //?܂�?オ��n?}�L��
            if (i_OAZ == 0) {                            //�W�J?}�w��
                if (es1.get_orisensuu_for_select_oritatami() == 0) {        //?܂�??�I�𖳂�
                    System.out.println("get_i_fold_type() 20180108");
                    i_fold_type = 0;//�������Ȃ�
                    //i_fold_type=1;//�S�W�J?}��?�?��
                } else if (es1.get_orisensuu_for_select_oritatami() > 0) {        //?܂�??�I��L��
                    i_fold_type = 2;//�I�����ꂽ�W�J?}��?�?��
                }
            } else if (i_OAZ > 0) {                        //?܂�?オ��n?}�w��
                if (es1.get_orisensuu_for_select_oritatami() == 0) {        //?܂�??�I�𖳂�
                    i_fold_type = 3;//�w�肳�ꂽ?܂�?オ��n?}��?�?��
                } else if (es1.get_orisensuu_for_select_oritatami() > 0) {        //?܂�??�I��L��
                    i_fold_type = 2;//�I�����ꂽ�W�J?}��?�?��
                }
            }
        }


        return i_fold_type;
    }

    // ------------------------------------------------------------------------
    public Ten ten_of_kijyunmen_old = new Ten(); //ten_of_kijyunmen_old.set(OZ.ts1.get_ten_of_kijyunmen_tv());//20180222?܂�??�I��?�Ԃ�?܂�?��??�������?�?A�ȑO�Ɏw�肳��Ă�����??�ʂ������p�����߂ɒǉ�

    //
    private void oritatame(int i_fold_type, int i_suitei_meirei) {//��?��̈Ӗ���(i_fold_type , i_suitei_meirei)
        //i_fold_type��get_i_fold_type()��?��Ŏ擾����?B
        //i_fold_type=0�Ȃɂ����Ȃ�?A=1��?��̓W�J?}�̑S?�??���?ۂƂ���?܂�?��??��?A=2��select���ꂽ?�??���?ۂƂ���?܂�?��??��?A=3��?�?��?�Ԃ��?X
        if (i_fold_type == 0) {
            System.out.println(" oritatame 20180108");
        } else if ((i_fold_type == 1) || (i_fold_type == 2)) {
            if (i_fold_type == 1) {
                es1.select_all();
            }
            //
            if (ckbox_cp_kaizen_oritatami.isSelected()) {//�W�J?}�̂�������???i�}?��?܂�??��?j������?C?�����
                Egaki_Syokunin es2 = new Egaki_Syokunin(r, this);    //��{�}?E?l?B�}�E�X����̓��͂��󂯕t����?B
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
            ten_of_kijyunmen_old.set(OZ.ts1.get_ten_of_kijyunmen_tv());//20180222?܂�??�I��?�Ԃ�?܂�?��??�������?�?A�ȑO�Ɏw�肳��Ă�����??�ʂ������p�����߂ɒǉ�
            //������O��OZ�͌Â�OZ
            oritatami_jyunbi();//OAZ�̃A���C���X�g��?A?V����?܂�?オ��?}���ЂƂǉ���?A�����??��?ۂɎw�肵?AOAZ(0)���ʃp��???[�^�������p������?B
            //��������OZ��?V����OZ�ɕς��
            //OZ.ts1.set_kijyunmen_id(ten_of_kijyunmen_old);


            //OZ.i_suitei_jissi_umu=0;	//i_suitei_jissi_umu��?A?܂�?��??��̌v�Z�����{�������ǂ�����\��?Bint i_suitei_jissi_umu=0�Ȃ���{���Ȃ�?B1�Ȃ���{����?B
            OZ.i_suitei_meirei = i_suitei_meirei;

            if (i_SubThread == 0) {
                i_SubThread = 1;
                i_sub_mode = 0;//1=?�?��??��̕ʉ����܂Ƃ߂�?o��?B0=?�?��??��̕ʉ����܂Ƃ߂�?o����?[�h�ł͂Ȃ�?B���̕�?��̓T�u�X���b�h�̓�??��?X�ɂ�������?B20170611��Ver3.008����ǉ�
                mks();//?V�����X���b�h��??��
                sub.start();
            }


        } else if (i_fold_type == 3) {
            OZ.i_suitei_meirei = i_suitei_meirei;

            if (i_SubThread == 0) {
                i_SubThread = 1;
                i_sub_mode = 0;//1=?�?��??��̕ʉ����܂Ƃ߂�?o��?B0=?�?��??��̕ʉ����܂Ƃ߂�?o����?[�h�ł͂Ȃ�?B���̕�?��̓T�u�X���b�h�̓�??��?X�ɂ�������?B20170611��Ver3.008����ǉ�
                mks();//?V�����X���b�h��??��
                sub.start();
            }
        }
    }


// ------------------------------------------------------------------------


    void oritatami_jyunbi() {//OAZ�̃A���C���X�g��?A?V����?܂�?オ��?}���ЂƂǉ���?A�����??��?ۂɎw�肵?AOAZ(0)���ʃp��???[�^�������p������?B

        System.out.println(" oritatami_jyunbi 20180107");

        OAZ_add_new_Oriagari_Zu(); //OAZ�̃A���C���X�g��?A?V����?܂�?オ��?}���ЂƂǉ�����?B

        set_i_OAZ(OAZ.size() - 1);//i_OAZ=i;OZ = (Oriagari_Zu)OAZ.get(i_OAZ); OZ(�e��??�̑�?ۂƂȂ�?�?オ��?}?j��?A�A���C���X�g��?�?V�ɒǉ����ꂽ?�?オ��?}�����蓖�Ă�)

        Oriagari_Zu orz;
        orz = (Oriagari_Zu) OAZ.get(0);//OAZ(0)(���ʃp��???[�^���??����?�?オ��?}?j��orz�Ɋ���t����

        //�ȉ��ł�OAZ(0)�̋��ʃp��???[�^��?A��?ݑ�??��?ۂƂȂ��Ă���OZ�ɓn��
        OZ.oriagarizu_F_color = orz.js.get_F_color();//20171223?܂�?オ��?}�̕\�ʂ�?F�̕�?X��OZ.oriagarizu_F_color��OZ.js.set_F_color�̗������K�v����
        OZ.js.set_F_color(OZ.oriagarizu_F_color); //?܂�?オ��?}�̕\�ʂ�?F
        Button_F_color.setBackground(OZ.oriagarizu_F_color);    //�{�^����?F?ݒ�

        OZ.oriagarizu_B_color = orz.js.get_B_color();//20171223?܂�?オ��?}�̕\�ʂ�?F�̕�?X��OZ.oriagarizu_F_color��OZ.js.set_F_color�̗������K�v����
        OZ.js.set_B_color(OZ.oriagarizu_B_color); //?܂�?オ��?}�̕\�ʂ�?F
        Button_B_color.setBackground(OZ.oriagarizu_B_color);    //�{�^����?F?ݒ�

        OZ.oriagarizu_L_color = orz.js.get_L_color();//20171223?܂�?オ��?}�̕\�ʂ�?F�̕�?X��OZ.oriagarizu_F_color��OZ.js.set_F_color�̗������K�v����
        OZ.js.set_L_color(OZ.oriagarizu_L_color); //?܂�?オ��?}�̕\�ʂ�?F
        Button_L_color.setBackground(OZ.oriagarizu_L_color);    //�{�^����?F?ݒ�
        //��?��OAZ(0)�̋��ʃp��???[�^��?AOZ�ɓn��??�Ƃ�?I��

    }

    // ------------------------------------------------------------------------------
    public void OAZ_add_new_Oriagari_Zu() {

        OAZ.add(new Oriagari_Zu_01(this));

        //	OZ = (Oriagari_Zu)OAZ.get(OAZ.size()-1);//?܂肠����?}
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
            i_orisen_hojyosen = 0;//=0��?�??����?@=1�͕�????���̓�?[�h
            es1.set_i_orisen_hojyosen(i_orisen_hojyosen);//���̃{�^���Ƌ@�\�͕�?��G??���ʂɎg���Ă���̂�i_orisen_hojyosen�̎w�肪����
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
                "<html>�Q?F�h��킯�W�J?}��`�����߂ɂ�?A���炩���ߑ�?۔͈͂�I�����Ă�������?iselect�{�^�����g��?j?B<br>" +
                        "To get 2-Colored crease pattern, select the target range in advance (use the select button).<html>");
        //label.setForeground(Color.RED);
        JOptionPane.showMessageDialog(this, label);
    }

    // ----------------------------------------------------------

    public void keikoku_sentaku_sareta_orisen_ga_nai_2() {
        JLabel label = new JLabel(
                "<html>?V����?܂�?オ��?}��`�����߂ɂ�?A���炩���ߑ�?۔͈͂�I�����Ă�������?iselect�{�^�����g��?j?B<br>" +
                        "To calculate new folded shape, select the target clease lines range in advance (use the select button).<html>");
        //label.setForeground(Color.RED);
        JOptionPane.showMessageDialog(this, label);
    }
    // ----------------------------------------------------------


    public void keisan_tyuusi() {


        //int option = JOptionPane.showConfirmDialog(this, "�W�J?}�ۑ�����?H/Save CP?H");

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


        //int option = JOptionPane.showConfirmDialog(this, "�f?[�^��ۑ����܂���?H/Save CP?H");

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

    // --------�W�J?}��?�����-----------------------------
    void tenkaizu_syokika() {

//�S��
        //�`��?E?l��?�����
        es1.reset();
        es1.reset_2();    //�`��?E?l��?�����


        //camera_of_orisen_nyuuryokuzu	��?ݒ�;
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

        //?�??���͂���????���͂�
        i_orisen_hojyosen = 0;


//�k��

        ckbox_mouse_settei.setSelected(true);//�\�����邩�ǂ����̑I��
        ckbox_ten_sagasi.setSelected(false);//�\�����邩�ǂ����̑I��
        ckbox_ten_hanasi.setSelected(false);//es1.set_i_hanasi(0);          //�\�����邩�ǂ����̑I��
        ckbox_kou_mitudo_nyuuryoku.setSelected(false);
        es1.set_i_kou_mitudo_nyuuryoku(0);          //?����x���͂��邩�ǂ����̑I��
        ckbox_bun.setSelected(true);//����\�����邩�ǂ����̑I��
        ckbox_cp.setSelected(true);//?�??��\�����邩�ǂ����̑I��
        ckbox_a0.setSelected(true);//��?��???��\�����邩�ǂ����̑I��
        ckbox_a1.setSelected(true);//��?��???��\�����邩�ǂ����̑I��
        ckbox_mejirusi.setSelected(true);//?\�����??�ʂȂǂ̖ڈ��??
        ckbox_cp_ue.setSelected(false);//�W�J?}��?܂�?オ��\�z?}��?�ɕ`��
        ckbox_oritatami_keika.setSelected(false);//?܂�?オ��\�z�̓r���o�߂�?���?o��
        ckbox_cp_kaizen_oritatami.setSelected(false);//cp��?�?�ݑO�Ɏ������P����
        ckbox_select_nokosi.setSelected(false);//select?�Ԃ�?�?�ݑ�??�����Ă��Ȃ�ׂ��c��
        ckbox_toukazu_color.setSelected(false);//����?}���J��?[������?B


        //�������ꂽ?�??�̎w��
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
        text27.setText(String.valueOf(d_syukusyaku_keisuu)); //?k�ڌW??
        d_kaiten_hosei = 0.0;
        text28.setText(String.valueOf(d_kaiten_hosei));//��]�\���p�x�̕�?��W??

        OZ.d_oriagarizu_syukusyaku_keisuu = 1.0;
        text29.setText(String.valueOf(OZ.d_oriagarizu_syukusyaku_keisuu));//?܂�?オ��?}��?k�ڌW??
        OZ.d_oriagarizu_kaiten_hosei = 0.0;
        text30.setText(String.valueOf(OZ.d_oriagarizu_kaiten_hosei));//?܂�?オ��?}�̉�]�\���p�x�̕�?��p�x


        //�w�i�\��
        ihaikeihyouji = 1;
        Button_haikei_kirikae.setBackground(Color.ORANGE);

        //�w�i??�b�N�I��
        i_Lock_on = 0;
        i_Lock_on_ori = 0;
        Button_haikei_Lock_on.setBackground(Color.gray);

//?���


        //�W�J?}��??�̑���?B
        iTenkaizuSenhaba = 1;

        //���_�̂��邵��??
        ir_ten = 1;


        //��{�}?\���̒�??�̗��[�̉~�̔��a?A?i�ȑO�͎}�Ɗe��|�C���g�̋߂��̔����???j
        //double r=3.0;
        //es1.set_r(r);

        //?�??�\����?F�ŕ\��
        i_orisen_hyougen = 1;

        //�y����?F�̎w��
        icol = 1;
        es1.setcolor(icol);    //?�?���?�??��?F���w�肷��?B0��???A1��?�?A2��?�?B
        ButtonCol_irokesi();
        ButtonCol_red.setForeground(Color.black);
        ButtonCol_red.setBackground(Color.red);    //?�??�̃{�^����?F?ݒ�


        //?�??����??
        i_orisen_bunkatu_suu = 2;
        text2.setText(String.valueOf(i_orisen_bunkatu_suu));
        es1.set_i_orisen_bunkatu_suu(i_orisen_bunkatu_suu);//�t��?[?�??���͎��̕���??


        //�i�q����?��̎w��
        text1.setText("8");
        set_kousi_bunkatu_suu();

        //�i�q�̓K�p�͈͂̎w��
        es1.set_i_kitei_jyoutai(1);//�i�q��?�Ԃ�p�����K�p�ɂ���?B

        //�C�ӊi�q
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
//����
        //�p�x�n���͂�22.5�x�n�ɂ���?B
        es1.set_id_kakudo_kei(8);

        //���R�p�x
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

        //���p�`�̊p??
        i_sei_takakukei = 5;
        text9.setText(String.valueOf(i_sei_takakukei));

        //��?��???��?F
        h_icol = 4;
        es1.h_setcolor(h_icol);                                        //?�?��̕�????��?F���w�肷��?B4�̓I�����W?A7�͉�?B
        Button_h_Col_irokesi();
        Button_Col_orange.setForeground(Color.black);
        Button_Col_orange.setBackground(Color.ORANGE);    //��????�̃{�^����?F?ݒ�

        //ckbox_check1.setSelected(false);//check���邩�ǂ����̑I��
        //ckbox_check2.setSelected(false);//check���邩�ǂ����̑I��
        ckbox_check3.setSelected(false);//check���邩�ǂ����̑I��
        es1.set_i_check3(0);
        ckbox_check4.setSelected(false);//check���邩�ǂ����̑I��
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

    public void set_jiyuu_kaku_def() { //����def��?u��`?v�ƌ����Ӗ��ł͂Ȃ�?Ad��e��f�������Ƃ����Ӗ�
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


    //�{�^���������ꂽ�Ƃ���????----------------
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
        Button_HK_nisuru.setForeground(Color.black); //HK�Ƃ͕�?��???�̂���
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


    //�A�v���b�g��?�������?s����??----------------------------------------------------
    //public void start() {;}

    //�A�v���b�g�̌�????��?s����??----------------------------------------------------
    //public void stop() {;}

    //�A�v���b�g��?�?I????��?s����??----------------------------------------------------
    public void destroy() {
        removeMouseListener(this);
    }//removeMouseMotionListener��removeMouseWheelListener�͂ǂ��Ȃ�?H?@20170401


    void Button_kyoutuu_sagyou() {
        es1.set_i_egaki_dankai(0);
        es1.set_i_en_egaki_dankai(0);
        es1.set_s_step_iactive(3);//�v??��?@es1�ł�������s_step��set.(senbun)���ƃA�N�e�B���łȂ��̂ŕ\����?������Ȃ�20170507
        es1.ori_v.reset();
    }


    // *******************************************************************************************zzzzzzzzzzzz
    public void i_cp_or_oriagari_hantei(Ten p) {//�}�E�X�œ���ꂽTen��?A�W�J?}��?܂�?オ��?}�Ȃǂ̂ǂ���w���Ă���̂����肷���??
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


            int OZ_hyouji_mode = 0;//?܂�?オ��?}�\���Ȃ�
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
    void set_i_OAZ(int i) {//OZ��?؂�ւ��Ƃ���????
        System.out.println("i_OAZ = " + i_OAZ);
        i_OAZ = i;
        OZ = (Oriagari_Zu) OAZ.get(i_OAZ);
        if (OZ.i_toukazu_color == 0) {
            ckbox_toukazu_color.setSelected(false);//����?}�̓J��?[�����Ȃ�?B
        } else if (OZ.i_toukazu_color == 1) {
            ckbox_toukazu_color.setSelected(true);//����?}�̓J��?[��?B
        }
    }
// ---------------------------------------


    int i_mouse_right_button_on = 0;//�}�E�X�̉E�{�^����on�Ȃ�P?Aoff�Ȃ�0
    int i_mouse_undo_redo_mode = 0;//�}�E�X��undo?Aredo���郂?[�h�Ȃ�1


    int i_cp_or_oriagari = 0;//�}�E�X�z�C?[���̑�?ۂ�cp�W�J?}�Ȃ�0?A?܂�?オ��?}(�\)�Ȃ�1?A?܂�?オ��?}(��)�Ȃ�2?A����?}(�\)�Ȃ�3?A����?}(��)�Ȃ�4


    //=============================================================================
    //�}�E�X�̃z�C?[������]�������ɌĂ΂��??�\�b�h
    //=============================================================================

    public void mouseWheelMoved(MouseWheelEvent e) {
        //System.out.println("mouseWheelMoved   " +e.getWheelRotation());
        if (ckbox_mouse_settei.isSelected()) {
//System.out.println("�z�C?[��");
            //	�z�C?[����undo,redo
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

            //	�z�C?[���Ŋg��?k?�
            if ((!e.isShiftDown()) && (i_mouse_right_button_on == 0)) {

                double bairitsu;

                // ---------------------------------------------------------------------hhhhhhhhh

                Ten p = new Ten(e2p(e));
                i_cp_or_oriagari_hantei(p);
//System.out.println("�z�C?[���Ŋg��?k?�?@i_cp_or_oriagari=?@" +i_cp_or_oriagari);
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
    //�}�E�X��??(�ړ���{�^����??)��?s����??------------------------------
    //----------------------------------------------------------------------


    public Ten e2p(MouseEvent e) {

        double d_haba = 0.0;
        if (ckbox_ten_hanasi.isSelected()) {
            d_haba = camera_of_orisen_nyuuryokuzu.get_camera_bairitsu_x() * es1.get_d_hantei_haba();
        }
        return new Ten(e.getX() - (int) d_haba, e.getY() - (int) d_haba);
    }


//i_mouse_modeA;�}�E�X�̓�??�ɑ΂��锽�����K�肷��?B
// -------------1;??�����̓�?[�h?B
//2;�W�J?}��?�(�ړ�)?B
//3;"L_del"
//4;"L_chan"

// -------------5;??��������?[�h?B
// -------------6;2�_���瓙����??����?[�h?B
// -------------7;�p�񓙕�??��?[�h?B
// -------------8;��?S��?[�h?B
// -------------9;????���낵��?[�h?B
// -------------10;?܂�Ԃ���?[�h?B
// -------------11;??�����̓�?[�h?B
// -------------12;���f��?[�h?B
// -------------13;15�x���̓�?[�h?B


//101:?܂�?オ��?}�̑�???B
//102;F_move
//103;S_face

//10001;test1 ����??���Ƃ��ē_���R�w�肷��


    // �}�E�X��??(�}�E�X����������)��?s����??----------------------------------------------------
    public void mouseMoved(MouseEvent e) {
        //�������Ȃ�
        //  final Point mouseLocation = MouseInfo.getPointerInfo().getLocation();//����͑���J2SE 5.0?uTiger?v��?~��??������R?[�h

        Ten p = new Ten(e2p(e));
        mouse_object_iti(p);
        if (i_mouse_modeA == 0) {
        } else if (i_mouse_modeA == 1) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_01(p);
        }   //1 ??�����̓�?[�h?i�t��?[?j
        //else if(i_mouse_modeA==2)  {		}						       //2 �W�J?}�ړ�?B
        //else if(i_mouse_modeA==3)  { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_03(p);}//??��???��??[�h?B
        //else if(i_mouse_modeA==4)  { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_04(p);}//senbun_henkan ???�?�
        else if (i_mouse_modeA == 5) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_05(p);
        }//??��������?[�h?B
        //else if(i_mouse_modeA==6)  { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_06(p);}//2�_���瓙����??����?[�h?B
        else if (i_mouse_modeA == 7) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_07(p);
        }//�p�񓙕�??��?[�h?B
        else if (i_mouse_modeA == 8) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_08(p);
        }//��?S��?[�h?B
        else if (i_mouse_modeA == 9) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_09(p);
        }//????���낵��?[�h?B
        else if (i_mouse_modeA == 10) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_10(p);
        }//?܂�Ԃ���?[�h?B
        else if (i_mouse_modeA == 11) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_11(p);
        }//??�����̓�?[�h?B(?���)
        else if (i_mouse_modeA == 12) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_12(p);
        }//���f��?[�h?B
        //else if(i_mouse_modeA==13) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_13(p);}//�p�x�n��?[�h?i�P�Ԗ�?j?B//??���w��?A��_�܂�
        //else if(i_mouse_modeA==14) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_14(p);}//�_�ǉ���?[�h?B
        //else if(i_mouse_modeA==15) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_15(p);}//�_???��??[�h?B
        else if (i_mouse_modeA == 16) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_16(p);
        }//�p�x�n��?[�h?i�S�Ԗ�?j?B2�_�w�肵?A??���܂�
        else if (i_mouse_modeA == 17) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_17(p);
        }//�p�x�n��?[�h?i�Q�Ԗ�?j?B//2�_�w��?A��_�܂�
        else if (i_mouse_modeA == 18) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_18(p);
        }//�p�x�n��?[�h?i�T�Ԗ�?j?B2�_�w��?A���R���[
        //else if(i_mouse_modeA==19) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_19(p);}//select?@�Ɏg��
        //else if(i_mouse_modeA==20) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_20(p);}//unselect?@�Ɏg��
        else if (i_mouse_modeA == 21) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_21(p);
        }//move?@�Ɏg��
        else if (i_mouse_modeA == 22) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_22(p);
        }//copy_paste?@�Ɏg��
        //else if(i_mouse_modeA==23) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_23(p);}//--->M?@�Ɏg��
        //else if(i_mouse_modeA==24) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_24(p);}//--->V?@�Ɏg��
        //else if(i_mouse_modeA==25) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_25(p);}//--->E?@�Ɏg��
        //else if(i_mouse_modeA==26) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_26(p);}//�w�i�Z�b�g?@�Ɏg��
        else if (i_mouse_modeA == 27) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_27(p);
        }//??����������?@�Ɏg��
        else if (i_mouse_modeA == 28) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_28(p);
        }//??����������?@�Ɏg��
        else if (i_mouse_modeA == 29) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_29(p);
        }//?����p�`����?@�Ɏg��
        //else if(i_mouse_modeA==30) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_30(p);}//?���_??�ϊ�?@�Ɏg��
        else if (i_mouse_modeA == 31) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_31(p);
        }//move 2p2p?@�Ɏg��
        else if (i_mouse_modeA == 32) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_32(p);
        }//copy 2p2p?@?@�Ɏg��
        else if (i_mouse_modeA == 33) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_33(p);
        }//����???@�Ɏg��
        else if (i_mouse_modeA == 34) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_34(p);
        }//??���Ƃ��Ă����g��??����?d�����Ă���?�??��?��ɎR�J�ɂ����?@�Ɏg��
        else if (i_mouse_modeA == 35) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_35(p);
        }//��?܂�Ԃ�?@���͂���??����?�?G���Ă���?�??��?܂�Ԃ�?@�Ɏg��
        else if (i_mouse_modeA == 36) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_36(p);
        }//??���Ƃ��Ă����g��??����X��?����Ă���?�??��?��ɎR�J�ɂ����?@�Ɏg��
        else if (i_mouse_modeA == 37) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_37(p);
        }//�p�x�n��?[�h?i�R�Ԗ�?j?B�p�x�K�i��??�����̓�?[�h?B�p�x�K�i��?�??����?@�Ɏg��
        else if (i_mouse_modeA == 38) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_38(p);
        }//?܂�?�݉\??�ǉ�
        else if (i_mouse_modeA == 39) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_39(p);
        }//?܂�?�݉\??+�i�q�_�n����
        else if (i_mouse_modeA == 40) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_40(p);
        }//��?s??����
        //else if(i_mouse_modeA==41) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_41(p);}//�_?????i??�J��?[�`�F���W?j?@�Ɏg��
        //else if(i_mouse_modeA==42) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_42(p);}//�~����?@�Ɏg��
        //else if(i_mouse_modeA==43) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_43(p);}//�~��3�_����?@�Ɏg��
        //else if(i_mouse_modeA==44) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_44(p);}//�~?@��������?@�Ɏg��
        //else if(i_mouse_modeA==45) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_45(p);}//2�~��?�???@�Ɏg��
        //else if(i_mouse_modeA==46) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_46(p);}//���]?@�Ɏg��
        //else if(i_mouse_modeA==47) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_47(p);}//�~���̓�?[�h?B(�t��?[)
        //else if(i_mouse_modeA==48) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_48(p);}//�~?@��?S�~�ǉ���?[�h?B(���~�̉~���Ɠ�?S�~�̉~���Ƃ�??��??���Ŏw�肷��)
        //else if(i_mouse_modeA==49) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_49(p);}//�~?@��?S�~�ǉ���?[�h?B(���~�̉~���Ɠ�?S�~�̉~���Ƃ�??�͑��̓�?S�~�̑g�Ŏw�肷��)
        //else if(i_mouse_modeA==50) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_50(p);}//2�~���w�肵?A���ꂼ��̉~�ɓ�?S�~��������?B���ꂼ��̓�?S�~�̑g�ɂł���ї̈��??���������Ȃ�悤�ɂ���?A������ꂽ��?S�~���m��?ڂ���悤�ɂ���?B
        //else if(i_mouse_modeA==51) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_51(p);}//��?s???@??�w����̓�?[�h?B
        else if (i_mouse_modeA == 52) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_52(p);
        }//�A��?܂�Ԃ���?[�h?@�Ɏg��
        else if (i_mouse_modeA == 53) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_53(p);
        }//��������P?@�Ɏg��
        else if (i_mouse_modeA == 54) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_54(p);
        }//��������Q?@�Ɏg��
        else if (i_mouse_modeA == 55) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_55(p);
        }//�p�x����P?@�Ɏg��
        else if (i_mouse_modeA == 56) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_56(p);
        }//�p�x����Q?@�Ɏg��
        else if (i_mouse_modeA == 57) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_57(p);
        }//�p�x����R?@�Ɏg��
        //else if(i_mouse_modeA==58) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_58(p);}//senbun_henkan ?�?�
        //else if(i_mouse_modeA==59) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_59(p);}//��??�v??�p�e�B�w��
        //else if(i_mouse_modeA==60) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_60(p);}//--->HK?@�Ɏg��//HK�Ƃ͕�?��???�̂���

        else if (i_mouse_modeA == 61) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_61(p);
        }//�����`���I��?ipaint�̑I���Ɏ������I���@�\?j�Ɏg��
        else if (i_mouse_modeA == 62) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mMoved_A_62(p);
        }//�{??�m�C?}?@�Ɏg��
        //else if(i_mouse_modeA==63) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_63(p);}//unselect?@�Ɏg��
        //else if(i_mouse_modeA==64) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_64(p);}//unselect?@�Ɏg��
        //else if(i_mouse_modeA==65) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_65(p);}//unselect?@�Ɏg��
        //else if(i_mouse_modeA==66) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_66(p);}//unselect?@�Ɏg��
        //else if(i_mouse_modeA==67) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_67(p);}//unselect?@�Ɏg��
        //else if(i_mouse_modeA==68) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_68(p);}//unselect?@�Ɏg��
        //else if(i_mouse_modeA==69) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_69(p);}//unselect?@�Ɏg��
        //else if(i_mouse_modeA==70) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_70(p);}//unselect?@�Ɏg��


        //else if(i_mouse_modeA==10001)  { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_10001(p);}
        //else if(i_mouse_modeA==10002)  { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mMoved_A_10002(p);}

        //else if(i_mouse_modeA==101){		}	//?܂�?オ��?}��??
        //else if(i_mouse_modeA==102){		}	//?܂�?オ��?}�ړ�

        //else if(i_mouse_modeA==103){		}//��??�ʎw��
        //else if(i_mouse_modeA==7){;}
        //else if(i_mouse_modeA==8){;}
        else {
        }

        repaint();
    }


    int btn = 0;//?��E�����̂ǂ̃{�^���������ꂽ���i�[?B?@1=
    int i_ClickCount = 0;//���̕�?�����Ȃ��̂ł�?H21181208


    //�}�E�X��??(�{�^�����������Ƃ�)��?s����??----------------------------------------------------
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

            //---------�{�^���̎�ނɂ�铮??��?X-----------------------------------------


            if (btn == MouseEvent.BUTTON1) {
                //System.out.println("?��{�^���N���b�N");
                //System.out.println("?��{�^���N���b�N");


            } else if (btn == MouseEvent.BUTTON2) {
                System.out.println("���{�^���N���b�N");

                i_cp_or_oriagari_hantei(p);

                System.out.println("i_cp_or_oriagari = " + i_cp_or_oriagari);

                if (i_cp_or_oriagari == 0) {// �W�J?}�ړ�?B

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

            } else if (btn == MouseEvent.BUTTON3) {//�E�{�^���N���b�N
                //System.out.println("�E�{�^���N���b�N");
                if (i_mouse_modeA == 62) {//�{??�m�C?}���͎���?A���͓r���̃{??�m�C��_��?����Ȃ��悤��?A�E�N���b�N�ɔ��������Ȃ�?B20181208
                } else {
                    i_mouse_right_button_on = 1;

                    //??��???��??[�h?B
                    es1.setCamera(camera_of_orisen_nyuuryokuzu);
                    es1.mPressed_A_03(p);

                    i_orisen_hojyosen = 4;//=0��?�??����?@=1�͕�????���̓�?[�h?A�S�͗�����??�p
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
        }   //1 ??�����̓�?[�h?i�t��?[?j
        else if (i_mouse_modeA == 2) {                                       //2 �W�J?}�ړ�?B
            camera_of_orisen_nyuuryokuzu.camera_ichi_sitei_from_TV(p);
            mouse_temp0.set(p);
        } else if (i_mouse_modeA == 3) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_03(p);
        }//??��???��??[�h?B
        else if (i_mouse_modeA == 4) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_04(p);
        }//senbun_henkan ???�?�
        else if (i_mouse_modeA == 5) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_05(p);
        }//??��������?[�h?B
        else if (i_mouse_modeA == 6) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_06(p);
        }//2�_���瓙����??����?[�h?B
        else if (i_mouse_modeA == 7) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_07(p);
        }//�p�񓙕�??��?[�h?B
        else if (i_mouse_modeA == 8) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_08(p);
        }//��?S��?[�h?B
        else if (i_mouse_modeA == 9) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_09(p);
        }//????���낵��?[�h?B
        else if (i_mouse_modeA == 10) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_10(p);
        }//?܂�Ԃ���?[�h?B
        else if (i_mouse_modeA == 11) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_11(p);
        }//??�����̓�?[�h?B(?���)
        else if (i_mouse_modeA == 12) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_12(p);
        }//���f��?[�h?B
        else if (i_mouse_modeA == 13) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_13(p);
        }//�p�x�n��?[�h?i�P�Ԗ�?j?B//??���w��?A��_�܂�
        else if (i_mouse_modeA == 14) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_14(p);
        }//�_�ǉ���?[�h?B
        else if (i_mouse_modeA == 15) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_15(p);
        }//�_???��??[�h?B
        else if (i_mouse_modeA == 16) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_16(p);
        }//�p�x�n��?[�h?i�S�Ԗ�?j?B2�_�w�肵?A??���܂�
        else if (i_mouse_modeA == 17) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_17(p);
        }//�p�x�n��?[�h?i�Q�Ԗ�?j?B//2�_�w��?A��_�܂�
        else if (i_mouse_modeA == 18) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_18(p);
        }//�p�x�n��?[�h?i�T�Ԗ�?j?B2�_�w��?A���R���[
        else if (i_mouse_modeA == 19) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_19(p);
        }//select?@�Ɏg��
        else if (i_mouse_modeA == 20) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_20(p);
        }//unselect?@�Ɏg��
        else if (i_mouse_modeA == 21) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_21(p);
        }//move?@�Ɏg��
        else if (i_mouse_modeA == 22) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_22(p);
        }//copy_paste?@�Ɏg��
        else if (i_mouse_modeA == 23) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_23(p);
        }//--->M?@�Ɏg��
        else if (i_mouse_modeA == 24) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_24(p);
        }//--->V?@�Ɏg��
        else if (i_mouse_modeA == 25) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_25(p);
        }//--->E?@�Ɏg��
        else if (i_mouse_modeA == 26) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_26(p);
        }//�w�i�Z�b�g?@�Ɏg��
        else if (i_mouse_modeA == 27) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_27(p);
        }//??����������?@�Ɏg��
        else if (i_mouse_modeA == 28) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_28(p);
        }//??����������?@�Ɏg��
        else if (i_mouse_modeA == 29) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_29(p);
        }//?����p�`����?@�Ɏg��
        else if (i_mouse_modeA == 30) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_30(p);
        }//?���_??�ϊ�?@�Ɏg��
        else if (i_mouse_modeA == 31) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_31(p);
        }//move 2p2p?@�Ɏg��
        else if (i_mouse_modeA == 32) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_32(p);
        }//copy 2p2p?@?@�Ɏg��
        else if (i_mouse_modeA == 33) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_33(p);
        }//����???@�Ɏg��
        else if (i_mouse_modeA == 34) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_34(p);
        }//??���Ƃ��Ă����g��??����?d�����Ă���?�??��?��ɎR�J�ɂ����?@�Ɏg��
        else if (i_mouse_modeA == 35) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_35(p);
        }//��?܂�Ԃ�?@���͂���??����?�?G���Ă���?�??��?܂�Ԃ�?@�Ɏg��
        else if (i_mouse_modeA == 36) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_36(p);
        }//??���Ƃ��Ă����g��??����X��?����Ă���?�??��?��ɎR�J�ɂ����?@�Ɏg��
        else if (i_mouse_modeA == 37) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_37(p);
        }//�p�x�n��?[�h?i�R�Ԗ�?j?B�p�x�K�i��??�����̓�?[�h?B�p�x�K�i��?�??����?@�Ɏg��
        else if (i_mouse_modeA == 38) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_38(p);
        }//?܂�?�݉\??�ǉ�
        else if (i_mouse_modeA == 39) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_39(p);
        }//?܂�?�݉\??+�i�q�_�n����
        else if (i_mouse_modeA == 40) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_40(p);
        }//��?s??����
        else if (i_mouse_modeA == 41) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_41(p);
        }//�_?????i??�J��?[�`�F���W?j?@�Ɏg��
        else if (i_mouse_modeA == 42) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_42(p);
        }//�~����?@�Ɏg��
        else if (i_mouse_modeA == 43) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_43(p);
        }//�~��3�_����?@�Ɏg��
        else if (i_mouse_modeA == 44) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_44(p);
        }//�~?@��������?@�Ɏg��
        else if (i_mouse_modeA == 45) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_45(p);
        }//2�~��?�???@�Ɏg��
        else if (i_mouse_modeA == 46) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_46(p);
        }//���]?@�Ɏg��
        else if (i_mouse_modeA == 47) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_47(p);
        }//�~���̓�?[�h?B(�t��?[)
        else if (i_mouse_modeA == 48) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_48(p);
        }//�~?@��?S�~�ǉ���?[�h?B(���~�̉~���Ɠ�?S�~�̉~���Ƃ�??��??���Ŏw�肷��)
        else if (i_mouse_modeA == 49) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_49(p);
        }//�~?@��?S�~�ǉ���?[�h?B(���~�̉~���Ɠ�?S�~�̉~���Ƃ�??�͑��̓�?S�~�̑g�Ŏw�肷��)
        else if (i_mouse_modeA == 50) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_50(p);
        }//2�~���w�肵?A���ꂼ��̉~�ɓ�?S�~��������?B���ꂼ��̓�?S�~�̑g�ɂł���ї̈��??���������Ȃ�悤�ɂ���?A������ꂽ��?S�~���m��?ڂ���悤�ɂ���?B
        else if (i_mouse_modeA == 51) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_51(p);
        }//��?s???@??�w����̓�?[�h?B
        else if (i_mouse_modeA == 52) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_52(p);
        }//�A��?܂�Ԃ���?[�h�Ɏg��
        else if (i_mouse_modeA == 53) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_53(p);
        }//��������P?@�Ɏg��
        else if (i_mouse_modeA == 54) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_54(p);
        }//��������Q?@�Ɏg��
        else if (i_mouse_modeA == 55) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_55(p);
        }//�p�x����P?@�Ɏg��
        else if (i_mouse_modeA == 56) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_56(p);
        }//�p�x����Q?@�Ɏg��
        else if (i_mouse_modeA == 57) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_57(p);
        }//�p�x����R?@�Ɏg��
        else if (i_mouse_modeA == 58) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_58(p);
        }//senbun_henkan ?�?�
        else if (i_mouse_modeA == 59) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_59(p);
        }//��??�v??�p�e�B�w��
        else if (i_mouse_modeA == 60) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_60(p);
        }//--->HK?@�Ɏg��//HK�Ƃ͕�?��???�̂���

        else if (i_mouse_modeA == 61) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_61(p);
        }//�����`���I��?ipaint�̑I���Ɏ������I���@�\?j�Ɏg��
        else if (i_mouse_modeA == 62) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_62(p);
        }//�{??�m�C?}?@�Ɏg��
        //else if(i_mouse_modeA==63) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mPressed_A_63(p);}//unselect?@�Ɏg��
        //else if(i_mouse_modeA==64) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mPressed_A_64(p);}//unselect?@�Ɏg��
        //else if(i_mouse_modeA==65) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mPressed_A_65(p);}//unselect?@�Ɏg��
        //else if(i_mouse_modeA==66) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mPressed_A_66(p);}//unselect?@�Ɏg��
        //else if(i_mouse_modeA==67) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mPressed_A_67(p);}//unselect?@�Ɏg��
        //else if(i_mouse_modeA==68) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mPressed_A_68(p);}//unselect?@�Ɏg��
        //else if(i_mouse_modeA==69) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mPressed_A_69(p);}//unselect?@�Ɏg��
        //else if(i_mouse_modeA==70) { es1.setCamera(camera_of_orisen_nyuuryokuzu);es1.mPressed_A_70(p);}//unselect?@�Ɏg��


        else if (i_mouse_modeA == 10001) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_10001(p);
        } else if (i_mouse_modeA == 10002) {
            es1.setCamera(camera_of_orisen_nyuuryokuzu);
            es1.mPressed_A_10002(p);
        } else if (i_mouse_modeA == 101) {        //?܂�?オ��?}��??
            OZ.oriagari_sousa_mouse_on(p);
        } else if (i_mouse_modeA == 102) {//?܂�?オ��?}�ړ�
            OZ.camera_of_oriagarizu.camera_ichi_sitei_from_TV(p);
            OZ.camera_of_oriagari_omote.camera_ichi_sitei_from_TV(p);
            OZ.camera_of_oriagari_ura.camera_ichi_sitei_from_TV(p);

            OZ.camera_of_touka_omote.camera_ichi_sitei_from_TV(p);
            OZ.camera_of_touka_ura.camera_ichi_sitei_from_TV(p);

            mouse_temp0.set(p);
        } else if (i_mouse_modeA == 103) {
            //ts1.set_kijyunmen_id(p);
        }//��??�ʎw��
        else if (i_mouse_modeA == 7) {
        } else if (i_mouse_modeA == 8) {
        } else {
        }

        repaint();
    }

    //�}�E�X��??(�h���b�O�����Ƃ�)��?s����??---------- System.out.println("A");------------------------------------------
    public void mouseDragged(MouseEvent e) {

        if (i_mouseDragged_yuukou == 1) {

            //Ten p =new Ten(e.getX(),e.getY());
            Ten p = new Ten(e2p(e));
            mouse_object_iti(p);

            if (ckbox_mouse_settei.isSelected()) {
                //---------�{�^���̎�ނɂ�铮??��?X-----------------------------------------
                if (btn == MouseEvent.BUTTON1) {


                } else if (btn == MouseEvent.BUTTON2) {
                    //System.out.println("���{�^���N���b�N");
                    //if(ts2.naibu_hantei(p)==0){
                    //i_cp_or_oriagari=0;
                    //if(ts2.naibu_hantei_ura(p)>0){i_cp_or_oriagari=2;}
                    //if(ts2.naibu_hantei_omote(p)>0){i_cp_or_oriagari=1;}


                    if (i_cp_or_oriagari == 0) {// �W�J?}�ړ�?B
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
                    //System.out.println("�E�{�^���N���b�N");
                    if (i_mouse_modeA == 62) {//�{??�m�C?}���͎���?A���͓r���̃{??�m�C��_��?����Ȃ��悤��?A�E�N���b�N�ɔ��������Ȃ�?B20181208
                    } else {
                        if (i_mouse_undo_redo_mode == 1) {
                            return;
                        }//undo,redo��?[�h?B
                        es1.setCamera(camera_of_orisen_nyuuryokuzu);
                        es1.mDragged_A_03(p);//??��???��??[�h?B
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


//20180225�ǉ�
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
//20180225�ǉ�?@�����܂�


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
            }//senbun_henkan ?�?�
            else if (i_mouse_modeA == 59) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_59(p);
            } else if (i_mouse_modeA == 60) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_60(p);
            } else if (i_mouse_modeA == 61) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_61(p);
            }//�����`���I��?ipaint�̑I���Ɏ������I���@�\?j�Ɏg��
            else if (i_mouse_modeA == 62) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mDragged_A_62(p);
            }//�{??�m�C?}?@�Ɏg��
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
            }    //?܂�?オ��?}��??
            else if (i_mouse_modeA == 102) {
                OZ.camera_of_oriagarizu.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));
                OZ.camera_of_oriagari_omote.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));
                OZ.camera_of_oriagari_ura.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));

                OZ.camera_of_touka_omote.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));
                OZ.camera_of_touka_ura.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));

                mouse_temp0.set(p);//mouse_temp0�͈ꎞ�I�Ɏg��Ten?Amouse_temp0.tano_Ten_iti(p)��mouse_temp0���猩��p�̈ʒu

            } else if (i_mouse_modeA == 103) {
            }//��??�ʎw��
            else if (i_mouse_modeA == 7) {
            } else if (i_mouse_modeA == 8) {
            } else {
            }

            repaint();
        }
    }

    //�}�E�X��??(�{�^���𗣂����Ƃ�)��?s����??----------------------------------------------------
    public void mouseReleased(MouseEvent e) {
        if (i_mouseReleased_yuukou == 1) {
            //Ten p =new Ten(e.getX(),e.getY());
            Ten p = new Ten(e2p(e));


            if (ckbox_mouse_settei.isSelected()) {
                //---------�{�^���̎�ނɂ�铮??��?X-----------------------------------------
                if (btn == MouseEvent.BUTTON1) {
                    //

                } else if (btn == MouseEvent.BUTTON2) {
                    //System.out.println("���{�^���N���b�N");
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
                    //System.out.println("�E�{�^���N���b�N");
                    if (i_mouse_modeA == 62) {
                        repaint();//�{??�m�C?}���͎���?A���͓r���̃{??�m�C��_��?����Ȃ��悤��?A�E�N���b�N�ɔ��������Ȃ�?B20181208
                    } else {

                        i_mouse_right_button_on = 0;

                        //if(i_mouse_undo_redo_mode==1){i_mouse_undo_redo_mode=0;es1.unselect_all();Button_kyoutuu_sagyou();es1.modosi_i_orisen_hojyosen();return;}
                        if (i_mouse_undo_redo_mode == 1) {
                            i_mouse_undo_redo_mode = 0;
                            return;
                        } //undo,redo��?[�h?B
                        es1.setCamera(camera_of_orisen_nyuuryokuzu);
                        es1.mReleased_A_03(p);
                        repaint();//�Ȃ�ł�����repaint�����邩�������������悢����?B20181208
                        es1.modosi_i_orisen_hojyosen();
                        i_mouseDragged_yuukou = 0;
                        i_mouseReleased_yuukou = 0;
                        //??��???��??[�h?B
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


//20180225�ǉ�
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
//20180225�ǉ�?@�����܂�


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
            }//senbun_henkan ?�?�
            else if (i_mouse_modeA == 59) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_59(p);
            } else if (i_mouse_modeA == 60) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_60(p);
            } else if (i_mouse_modeA == 61) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_61(p);
            }//�����`���I��?ipaint�̑I���Ɏ������I���@�\?j�Ɏg��
            else if (i_mouse_modeA == 62) {
                es1.setCamera(camera_of_orisen_nyuuryokuzu);
                es1.mReleased_A_62(p);
            }//�{??�m�C?}?@�Ɏg��
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
            } else if (i_mouse_modeA == 101) {        //?܂�?オ��?}��??
                OZ.oriagari_sousa_mouse_off(p);
            } else if (i_mouse_modeA == 102) {
                OZ.camera_of_oriagarizu.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));
                OZ.camera_of_oriagari_omote.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));
                OZ.camera_of_oriagari_ura.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));

                OZ.camera_of_touka_omote.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));
                OZ.camera_of_touka_ura.hyouji_ichi_idou(mouse_temp0.tano_Ten_iti(p));

                mouse_temp0.set(p);

            } else if (i_mouse_modeA == 103) {//��??�ʎw��
                int new_kijyunmen_id;
                int old_kijyunmen_id;
                old_kijyunmen_id = OZ.ts1.get_kijyunmen_id();

                new_kijyunmen_id = OZ.ts1.set_kijyunmen_id(p);
                System.out.println("kijyunmen_id = " + new_kijyunmen_id);
                if (OZ.js.men_rating != null) {//20180227�ǉ�
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

    //�}�E�X��??(�{�^�����N���b�N�����Ƃ�)��?s����??----------------------------------------------------
    public void mouseClicked(MouseEvent e) {
        //�������Ȃ�


    }

    //�}�E�X��??(�J?[�\�����L���̈���ɓ������Ƃ�)��?s����??----------------------------------------------------
    public void mouseEntered(MouseEvent e) {
        //�������Ȃ�
    }

    //�}�E�X��??(�J?[�\�����L���̈�O��?o���Ƃ�)��?s����??----------------------------------------------------
    public void mouseExited(MouseEvent e) {
        //�������Ȃ�
    }


    // --------------------------------------------------


    public void mouse_object_iti(Ten p) {//���̊�?���mouseMoved���ƈ���ă}�E�X�C�x���g���N���Ă������ł͔F������Ȃ�
        p_mouse_TV_iti.set(p.getx(), p.gety());

        p_mouse_object_iti.set(camera_of_orisen_nyuuryokuzu.TV2object(p_mouse_TV_iti));
        //System.out.println("mouse=("+p_mouse_object_iti.getx()+","+p_mouse_object_iti.gety()+")"  );
    }


    // --------------------------------------------------

/*
public void keyTyped(KeyEvent e){
  char key = e.getKeyChar();
  if (key == 'a'){
    System.out.println("a�̃L?[�������ꂽ");
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
    public void haikei_byouga(Graphics2D g2h, Image imgh) {//��?��̓J??��?ݒ�?A?????A���X???A���y?���
        //�w�i���?A�摜��?�?�͂���?A�E�B���h�E��(0,0)��?������ĉ�]��g��Ȃ��ŕ\������???����????�ԂƂ���?B
        //�w�i��?�̓_h1��?S�Ƃ���a�{�g�傷��?B����?Ah1��W�J?}?�̓_h3��?d�Ȃ�悤�ɔw�i���?s�ړ�����?B
        //����?�Ԃ̓W�J?}��?Ah3��?S��b�x��]�����悤������悤��?��W����]�����ē\��t����?A���̌�?A?��W�̉�]�����ɖ߂��Ƃ�����???B
        //��?���?AGraphics2D g2h,Image imgh,Ten h1,Ten h2,Ten h3,Ten h4
        //h2,��h4��?d�Ȃ�悤�ɂ���
        //

        //?�?���

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

        //g2h.drawImage(imgh,kaisi_x,kaisi_y,this);//hx0,hy0,�͕`��J�n�ʒu

        at.rotate(-h_cam.get_kakudo() * Math.PI / 180.0, h_cam.get_cx(), h_cam.get_cy());
        g2h.setTransform(at);

    }

    // ------------------------------------------------------


    //----------------------------------------------------
    //�y�C���g��?s����??----------------------------------
    //----------------------------------------------------
    public void paint(Graphics g) {
        //?uf?v��t���邱�Ƃ�float�^��?��l�Ƃ��ċL?q���邱�Ƃ��ł���
        Graphics2D g2 = (Graphics2D) bufferGraphics;
        //Graphics2D g2d = (Graphics2D)g;
        //BasicStroke BStroke = new BasicStroke(1.0f);g2.setStroke(BStroke);//??�̑���

        //float fTenkaizuSenhaba=(float)iTenkaizuSenhaba;	float f_h_TenkaizuSenhaba=(float)i_h_TenkaizuSenhaba;
        fTenkaizuSenhaba = (float) iTenkaizuSenhaba;
        f_h_TenkaizuSenhaba = (float) i_h_TenkaizuSenhaba;

        if (i_anti_alias == 1) {
            fTenkaizuSenhaba = fTenkaizuSenhaba + 0.2f;
            f_h_TenkaizuSenhaba = f_h_TenkaizuSenhaba + 0.2f;
        }

        BasicStroke BStroke = new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
        g2.setStroke(BStroke);//??�̑�����??�̖��[�̌`??

        //BasicStroke BStroke = new BasicStroke(1.2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);g2.setStroke(BStroke);//??�̑�����??�̖��[�̌`??
        if (i_anti_alias == 1) {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//�A���`�G�C���A�X?@�I��
        }
        if (i_anti_alias == 0) {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);//�A���`�G�C���A�X?@�I�t
        }

        g2.setBackground(Color.WHITE);    //����?s��?A�摜���t�@�C����?���?o�����Ƃ���BufferedImage�N���X���g��?????A�f�t�H���g�Ŕw�i��?��ɂȂ�̂�?A���������邽�߂̈Ӗ�?@20170107
        //�摜���t�@�C����?���?o�������Ƃ͂�߂�?A?ABufferedImage�N���X���g�킸?AImage�N���X�����ł��ނȂ�s�v��?s

        //AffineTransform at = new AffineTransform();

        //String c=new String();                //������????�p�̃N���X�̃C���X�^���X��
        //OritaCalc oc =new OritaCalc();

        //�ʂ�?d�Ȃ肳����?@�̃{�^����?F�̎w��?B
        if (OZ.betu_sagasi_flg == 1) {
            Button3.setBackground(new Color(200, 200, 200));//���ꂪ�Ȃ���Foreground�������ɔ��f����Ȃ�?B�d�l�Ȃ̂�?H
            Button3.setForeground(Color.black);

            Button_AS_matome.setBackground(new Color(200, 200, 200));//���ꂪ�Ȃ���Foreground�������ɔ��f����Ȃ�?B�d�l�Ȃ̂�?H
            Button_AS_matome.setForeground(Color.black);

            Button_bangou_sitei_suitei_hyouji.setBackground(new Color(200, 200, 200));//���ꂪ�Ȃ���Foreground�������ɔ��f����Ȃ�?B�d�l�Ȃ̂�?H
            Button_bangou_sitei_suitei_hyouji.setForeground(Color.black);
        } else {
            Button3.setBackground(new Color(201, 201, 201));
            Button3.setForeground(Color.gray);

            Button_AS_matome.setBackground(new Color(201, 201, 201));
            Button_AS_matome.setForeground(Color.gray);

            Button_bangou_sitei_suitei_hyouji.setBackground(new Color(201, 201, 201));
            Button_bangou_sitei_suitei_hyouji.setForeground(Color.gray);
        }

        // �o�b�t�@?[��ʂ̃N���A
        dim = getSize();
        bufferGraphics.clearRect(0, 0, dim.width, dim.height);

        //System.out.println("��ʃT�C�Y=(" + dim.width + " , " + dim.height  + ")"  );


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
        //�`�悵�������e�͈ȉ���?�������VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV


        //�J??���̃Z�b�g

        es1.setCamera(camera_of_orisen_nyuuryokuzu);

        Oriagari_Zu OZi;
        for (int i = 1; i <= OAZ.size() - 1; i++) {
            OZi = (Oriagari_Zu) OAZ.get(i);
            OZi.ts1.setCamera(camera_of_orisen_nyuuryokuzu);
        }

//VVVVVVVVVVVVVVV�ȉ���ts2�ւ̃J??���Z�b�g��Oriagari_zu��oekaki�Ŏ��{���Ă���̂ňȉ���5?s�͂Ȃ��Ă������͂�?@20180225
        OZ.ts2.setCamera(OZ.camera_of_oriagarizu);
        OZ.ts2.setCam_omote(OZ.camera_of_oriagari_omote);
        OZ.ts2.setCam_ura(OZ.camera_of_oriagari_ura);
        OZ.ts2.setCam_touka_omote(OZ.camera_of_touka_omote);
        OZ.ts2.setCam_touka_ura(OZ.camera_of_touka_ura);
//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
/*
		//System.out.println("paint?@+++++++++++++++++++++?@���������{���̔w�i�\��");
		//���������{���̔w�i�\��

		if (i_toumeika==1) {
//g2.drawImage((Image)imageT,100,100,this);
//oc.hyouji("���������{���̔w�i�\��1");

img_haikei=(Image)imageT;
			int iw=img_haikei.getWidth(this);//�C???[�W��??���擾
			int ih=img_haikei.getHeight(this);//�C???[�W��?������擾

			//System.out.println("paint????"+iw);
			//System.out.println("paint?���??"+ih);
			h_cam.set_haikei_haba((double)iw);
			h_cam.set_haikei_takasa((double)ih);

			//if(i_Lock_on==1){
				haikei_byouga(g2,img_haikei);
			//}
		}
*/

        //System.out.println("paint?@+++++++++++++++++++++?@�w�i�\��");
        //�w�i�\��
        if ((img_haikei != null) && (ihaikeihyouji >= 1)) {
            int iw = img_haikei.getWidth(this);//�C???[�W��??���擾
            int ih = img_haikei.getHeight(this);//�C???[�W��?������擾

            //System.out.println("paint????"+iw);
            //System.out.println("paint?���??"+ih);
            h_cam.set_haikei_haba(iw);
            h_cam.set_haikei_takasa(ih);

            //if(i_Lock_on==1){
            haikei_byouga(g2, img_haikei);
            //}
        }

        //�i�q�\��
        //es1.kousi_oekaki_with_camera(bufferGraphics,i_bun_hyouji,i_cp_hyouji,i_a0_hyouji,i_a1_hyouji,fTenkaizuSenhaba,i_orisen_hyougen,f_h_TenkaizuSenhaba,dim.width,dim.height);//�n��?���̓J??��?ݒ�?A?????A���X???A���y?���


        //��?��\��
        //System.out.println("paint?@+++++++++++++++++++++?@��?��\��  " +ikaisetuhyouji );
        if ((img_kaisetu != null) && (ikaisetuhyouji >= 1)) {
            bufferGraphics.drawImage(img_kaisetu, 650, 100, this);//80,80,�͕`��J�n�ʒu

            //bufferGraphics.drawImage(img_kaisetu,600,150,this);//80,80,�͕`��J�n�ʒu
            //	System.out.println("paint????"+img_haikei.getWidth(this));
            //	System.out.println("paint?���??"+img_haikei.getHeight(this));
        }


        //��??�ʂ̕\��
        //System.out.println("paint?@+++++++++++++++++++++?@��??�ʂ̕\��");
        if (i_mejirusi_hyouji == 1) {
            if (OZ.hyouji_flg > 0) {
                //	ts1.setCamera(camera_of_orisen_nyuuryokuzu);
                OZ.ts1.oekaki_kijyunmen_id_with_camera(bufferGraphics);//ts1��?܂�?�݂�?s��?ۂ̊�??�ʂ�\������̂Ɏg��?B
            }
        }

        //System.out.println("20170201_1");


        double d_haba = camera_of_orisen_nyuuryokuzu.get_camera_bairitsu_x() * es1.get_d_hantei_haba();
        //�����d��?i�_��?j�T?��͈�
        if (i_ten_sagasi_hyouji == 1) {
            g2.setColor(new Color(255, 240, 0, 30));
            //g2.fill(new Ellipse2D.Double(p_mouse_TV_iti.getx()-d_haba, p_mouse_TV_iti.gety()-d_haba, 2.0*d_haba,2.0*d_haba));

            g2.setStroke(new BasicStroke(2.0f));
            g2.setColor(new Color(255, 240, 0, 230));
            g2.draw(new Ellipse2D.Double(p_mouse_TV_iti.getx() - d_haba, p_mouse_TV_iti.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
        }

        //�����d���̌�����
        if ((i_ten_sagasi_hyouji == 1) && (i_ten_hanasi_hyouji == 1)) {
            g2.setStroke(new BasicStroke(2.0f));
            g2.setColor(new Color(255, 240, 0, 170));
        }


        //�W�J?}�\��
        //System.out.println("paint?@+++++++++++++++++++++?@�W�J?}�\��(�W�J?}��������?S��?\�����܂�)");
        //if (ihaikeihyouji<=1) {
        //        es1.setCamera(camera_of_orisen_nyuuryokuzu);

        //if(i_mejirusi_hyouji==1){js.oekaki_jyuuji_with_camera(bufferGraphics);}
        es1.oekaki_with_camera(bufferGraphics, i_bun_hyouji, i_cp_hyouji, i_a0_hyouji, i_a1_hyouji, fTenkaizuSenhaba, i_orisen_hyougen, f_h_TenkaizuSenhaba, dim.width, dim.height, i_mejirusi_hyouji);//�n��?���̓J??��?ݒ�?A?????A���X???A���y?���,�W�J?}��������?S��?\���̖ڈ�̕\��
        //}
        //	bufferGraphics.drawString(c.valueOf(k.getsousuu()),30,50);
        //	bufferGraphics.drawString(c.valueOf(k.getsousuu()),30,70);

        if (i_bun_hyouji == 1) {
            //�W�J?}?���̕����\��
            bufferGraphics.setColor(Color.black);

            bufferGraphics.drawString("mouse= (   " + p_mouse_object_iti.getx() + "   ,   " + p_mouse_object_iti.gety() + "   )", 120, 75); //���̕\�����e��void kekka_syori�Ō��߂���?B

            bufferGraphics.drawString("L=" + es1.getsousuu(), 120, 90); //���̕\�����e��void kekka_syori�Ō��߂���?B

            //System.out.println("paint?@+++++++++++++++++++++?@���ʂ̕����\��");
            //���ʂ̕����\��
            bufferGraphics.drawString(OZ.text_kekka, 120, 105); //���̕\�����e��void kekka_syori�Ō��߂���?B

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
                bufferGraphics.drawString("(" + ix_ind + "," + iy_ind + ")", (int) p_mouse_TV_iti.getx() + 25, (int) p_mouse_TV_iti.gety() + 20); //���̕\�����e��void kekka_syori�Ō��߂���?B

                //---------wwwwww--------------------------------------------

            }

            //bufferGraphics.drawString("index=" ,p_mouse_TV_iti.getx(),p_mouse_TV_iti.gety());

            //System.out.println("mouse=("+p_mouse_object_iti.getx()+","+p_mouse_object_iti.gety()+")"  );

            //System.out.println("i_SubThread = "+i_SubThread);
            if (i_SubThread == 1) {
                bufferGraphics.setColor(Color.red);

                bufferGraphics.drawString("Under Calculation. If you want to cancel calculation, uncheck [check A + MV]on right side and press the brake button (bicycle brake icon) on lower side.", 120, 134); //���̕\�����e��void kekka_syori�Ō��߂���?B
                bufferGraphics.drawString("�v�Z��?B?@�Ȃ�?A�v�Z�����?�����???�Ԃɖ߂肽���Ȃ�?A�E�ӂ�[check A+MV]�̃`�F�b�N���͂���?A�u��?[�L�{�^��?i���ӂ�?A���]�Ԃ̃u��?[�L�̃A�C�R��?j������?B ", 120, 148); //���̕\�����e��void kekka_syori�Ō��߂���?B
                //bufferGraphics.setColor(Color.black);
            }

            //bufferGraphics.drawString("wwwwwwwwwwwwwwwwwwwwwwww",320,105);
            keijiban.keiji(bufferGraphics);//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        }


        //?܂�?オ��̊e�킨�G����
        //Oriagari_Zu OZi;
        for (int i = 1; i <= OAZ.size() - 1; i++) {
            OZi = (Oriagari_Zu) OAZ.get(i);
            OZi.oriagari_oekaki(bufferGraphics, i_mejirusi_hyouji);
        }
        //OZ = (Oriagari_Zu)OAZ.get(OAZ.size()-1);//?܂肠����?}

        //�W�J?}��?܂�?オ��?}��?�ɕ`�����߂�?A�W�J?}��?ĕ\������
        if (i_cp_ue_hyouji == 1) {
            es1.oekaki_with_camera(bufferGraphics, i_bun_hyouji, i_cp_hyouji, i_a0_hyouji, i_a1_hyouji, fTenkaizuSenhaba, i_orisen_hyougen, f_h_TenkaizuSenhaba, dim.width, dim.height, i_mejirusi_hyouji);//�n��?���̓J??��?ݒ�?A?????A���X???A���y?���
        }


        //System.out.println("20170201_5");

        //�A���`�F�C���A�X
        if (i_anti_alias == 1) {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//�A���`�F�C���A�X?@�I��
        }
        if (i_anti_alias == 0) {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);//�A���`�F�C���A�X?@�I�t
        }

        //	bufferGraphics.drawString(c.valueOf(oc.kakudo(new Ten(0.0,0.0),new Ten( 10.0, 0.0))), 30,170);
        //      bufferGraphics.drawString(c.valueOf(778),150,150);
        //test_oekaki();
        //System.out.println("paint?@+++++++++++++++++++++?@bufferGraphics�ւ̕`��?I��");


        //�����w��??
        if (i_ten_hanasi_hyouji == 1) {

            g2.setStroke(new BasicStroke(1.0f));
            //g2.setColor(new Color(0, 0, 0,255));
            g2.setColor(Color.black);
            g2.drawLine((int) (p_mouse_TV_iti.getx()), (int) (p_mouse_TV_iti.gety()),
                    (int) (p_mouse_TV_iti.getx() + d_haba), (int) (p_mouse_TV_iti.gety() + d_haba)); //��??

            //g2.drawLine( (int)(p_mouse_TV_iti.getx()+d_haba*0.5),  (int)(p_mouse_TV_iti.gety()+d_haba*0.5),
            //             (int)(p_mouse_TV_iti.getx()+d_haba),  (int)(p_mouse_TV_iti.gety()+d_haba*2.0)); //��??
        }


        //�`�悵�������e�͂����܂�AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA


        // �I�t�X�N��?[���C???[�W����?ۂɕ`�悷��?B�I�t�X�N��?[����??��?�?��� 0,0?B
        g.drawImage(offscreen, 0, 0, this);
        //System.out.println("paint?@+++++++++++++++++++++?@paint?I��");

        //System.out.println("20170201_6");System.exit(0);


/*
//20181204
//�g?ݒ莞�̔w�i��g���̂ݎc���ăg���� 20181204
		if((i_mouse_modeA==61)&&(es1.get_i_egaki_dankai()==4)){//�g??���\������Ă���?��
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

						if(i_Lock_on==1){//20181202  ����if��������lock on �̂Ƃ��ɔw�i�����܂��\���ł��Ȃ�
							h_cam.set_i_Lock_on(i_Lock_on);
							h_cam.setCamera(camera_of_orisen_nyuuryokuzu);
							h_cam.h3_obj_and_h4_obj_keisan();
						}



		}



*/


        if (OZ.matome_write_image_jikkoutyuu) {//�܂Ƃ�?���?o����?s���̈Ӗ�)
            writeImageFile(fname_and_number);

            w_image_jikkoutyuu = false;
        }


        if (flg_wi == 1) {//�g����?���?o������?���p20180525
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
    // update �� repaint() ���Ă�?o�����Ǝ����I�ɌĂ�?o�����?B
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

		//oriagari_camera_syokika();		//20170615 ��?s���Ȃ��悤�ɂ���?i?܂肠����?}�̕\��?󋵂�ς��Ȃ��悤�ɂ��邽��?j
		//ts2.setCamera(camera_of_oriagarizu);	//20170615 ��?s���Ȃ��悤�ɂ���?i?܂肠����?}�̕\��?󋵂�ς��Ȃ��悤�ɂ��邽��?j
		//js.setCamera(camera_of_oriagarizu);	//20170615 ��?s���Ȃ��悤�ɂ���?i?܂肠����?}�̕\��?󋵂�ς��Ȃ��悤�ɂ��邽��?j

		OZ.hyouji_flg=0;//?܂�?オ��?}�̕\���l���̎w��?B1�Ȃ�W�J?}?�???A2�Ȃ�?j��?}?B3�Ȃ瓧��?}?B5�Ȃ��?ۂ�?܂莆��?܂���???��Ɠ���?B
		OZ.i_suitei_meirei=0;//?܂�?��??����ǂ̒i�K�܂�?s�����̎w��
		OZ.i_suitei_dankai=0;//?܂�?��??�肪�ǂ̒i�K�܂łł������̕\��
		OZ.betu_sagasi_flg=0;

		OZ.matome_write_image_jikkoutyuu = false; //��?���?܂肠����`�̗\����?���?o��������?s���Ȃ�ture�ɂȂ�?B20170615


	}
*/
    //----------------------------------------------------------

    void settei_syokika_yosoku() {
        OZ.text_kekka = "";
        OZ.hyouji_flg = 0;//?܂�?オ��?}�̕\���l���̎w��?B�P�Ȃ��?ۂ�?܂莆��?܂���???��Ɠ���?B�Q�Ȃ瓧��?}
        OZ.hyouji_flg_backup = 0;//�\���l��hyouji_flg�̈ꎞ�I�o�b�N�A�b�v�p

        //�\���p�̒l���i�[�����??
        OZ.ip1 = -1;//?㉺�\?E?l��?��??ݒ莞��?A?܂�����̕\���������ʂ�
        //��?ڂ���Ƃ�����?������ꂪ0��?A�������1000���i�[�����???B
        //�����ł�?����l��(0��1000)�ȊO��?��Ȃ�Ȃ�ł�����?B
        OZ.ip2 = -1;//?㉺�\?E?l��?܂�?�݉\��?d�Ȃ����T����?ۂ�?A
        //�\��?d�Ȃ�����Ȃ����0��?A�\��?d�Ȃ���������1000���i�[�����???B
        //�����ł�?����l��(0��1000)�ȊO��?��Ȃ�Ȃ�ł�����?B
        OZ.ip3 = 1;//ts1��?܂�?�݂�?s��?ۂ̊�??�ʂ��w�肷��̂Ɏg��?B

        //ip4=0;//�����?Ats1��?�?��ɗ��Ԃ������邩�ǂ������w�肷��?B0�Ȃ炵�Ȃ�?B1�Ȃ痠�Ԃ�?B//20170615 ��?s���Ȃ��悤�ɂ���?i?܂肠����?}�̕\��?󋵂�ς��Ȃ��悤�ɂ��邽��?j

        OZ.ip5 = -1;    //?㉺�\?E?l����U?܂�?�݉\�Ȏ���?d�Ȃ�����������Ƃ�?A
        //����ɕʂ̎���?d�Ȃ������������?�?���js.susumu(Smensuu)�̌���?B
        //0�Ȃ�?V����susumu�]�n���Ȃ�����?B0�ȊO�Ȃ�ω�����Smen��id��?ł�?�������??
        OZ.ip6 = -1;    //?㉺�\?E?l����U?܂�?�݉\�Ȏ���?d�Ȃ�����������Ƃ�?A
        //����ɕʂ̎���?d�Ȃ������������ js.kanou_kasanari_sagasi()�̌���?B
        //0�Ȃ�\��?d�Ȃ肩���ƂȂ�?�Ԃ͑�?݂��Ȃ�?B
        //1000�Ȃ�ʂ�?d�Ȃ������������?B


        OZ.betu_sagasi_flg = 0;     //�����?u�ʂ�?d�Ȃ��T��?v���Ƃ��L����???��͂P?A������???��͂O���Ƃ�?B
        OZ.hakkenn_sita_kazu = 0;    //?܂�?d�Ȃ����?A���ʂ蔭�����������i�[����?B


        i_mouseDragged_yuukou = 0;
        int i_mouseReleased_yuukou = 0;//0��?A�}�E�X��??�𖳎�?B1�̓}�E�X��??�L��?B�t�@�C���{�b�N�X��on-off�Ȃǂ�?A�\������mouseDragged��mouseReleased����?������Ƃ�?A�����?E��Ȃ��悤��0��?ݒ肷��?B������?A�}�E�X���N���b�N���ꂽ�Ƃ���?A1�L���w��ɂ���?B

        OZ.suitei_syokika();
        keijiban.clear();

    }

    //----------------------
    //   void reset(){		settei_syokika_cp();		settei_syokika_yosoku();		repaint();	}


    ////b* �A�v���P?[�V�����p?B?擪��?^???^?^?^�Ŏn�܂�?s�ɂ͂��܂ꂽ�����͖��������?B
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
        //System.out.println("01?���??"+img_haikei.getHeight(this));

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
            repaint();//�΂̘g??��?���?o���Ȃ����߂ɕK�v
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
                memo1 = es1.getMemo_for_svg_kakidasi_with_camera(i_bun_hyouji, i_cp_hyouji, i_a0_hyouji, i_a1_hyouji, fTenkaizuSenhaba, i_orisen_hyougen, f_h_TenkaizuSenhaba, dim.width, dim.height, i_mejirusi_hyouji);//�n��?���̓J??��?ݒ�?A?????A���X???A���y?���,�W�J?}��������?S��?\���̖ڈ�̕\��

                Memo memo2 = new Memo();
                //memo2=OZ.getMemo_for_svg_kakidasi();//20180227?@�e?܂�?オ���memo��?d������??�ƂȂ̂�????

                //�e?܂�?オ���memo
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

            //	�t�@�C���ۑ�


            try {
                if (flg61 == 1) { //�g?ݒ莞�̘g���̂�?���?o�� 20180524
                    int xmin = (int) es1.p61_TV_hako.get_x_min();
                    int xmax = (int) es1.p61_TV_hako.get_x_max();
                    int ymin = (int) es1.p61_TV_hako.get_y_min();
                    int ymax = (int) es1.p61_TV_hako.get_y_max();
                    //	es1.set_i_egaki_dankai(0);repaint();//�΂̘g??��?���?o���Ȃ����߂ɕK�v
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

                } else {//�g������???��̑S��?���?o��

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

            System.out.println("?I���܂���");

        }

    }


// ------------------------------------------

    //---------------------------------------------------------
    void readImageFromFile2() {//����͎g���Ă��Ȃ��̂�?����Ă���
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
        System.out.println("02?���??" + img_haikei.getHeight(this));

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
        //	System.out.println("02?���??"+img_haikei.getHeight(this));

    }


    //-------------------
    Memo readFile2Memo() {
        String fname = "";
        Memo memo_temp = new Memo();

        int file_ok = 0;//�ǂ�?��݃t�@�C�����̊g���q���K?�?iorh?Aobj?Acp?j�Ȃ�1?A����ȊO�Ȃ�0

        FileDialog fd = new FileDialog(this, "�ǂ�?��݃t�@�C���̎w��", FileDialog.LOAD);
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

            if (fd.getFile() != null) {  //�L�����Z���ł͂Ȃ�?????B

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
            System.out.println("obj�t�@�C���ǂ݂���");
            return file_henkan.obj2orihime(memo_temp);
            //return obj2orihime(memo_temp);
        }  //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        if (fname.endsWith("cp")) {
            System.out.println("cp�t�@�C���ǂ݂���");
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
		FileDialog fd = new FileDialog(this,"?���?o���t�@�C���̎w��",FileDialog.SAVE);
		fd.setVisible(true);
		String fname = fd.getDirectory() + fd.getFile();
*/
        String fname = selectFileName("?���?o���t�@�C���̖��O");
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

        System.out.println("�t�@�C��?�������");
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

////b* �A�v���P?[�V�����p?B?擪��?^???^?^?^�Ŏn�܂�?s�ɂ͂��܂ꂽ�����͖��������

    //--------------------------------------------------------------------------
    public void oritatami_suitei() {
        OZ.oritatami_suitei(camera_of_orisen_nyuuryokuzu, Ss0);
    }

    //--------------------------------------------------------------------------
    void oritatami_suitei_2col() {//�Q?F�h��킯�W�J?}
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
            i_sub_mode = 3;//3=���_�����?�?�݉\?�����?A1=?�?��??��̕ʉ����܂Ƃ߂�?o��?B0=?�?��??��̕ʉ����܂Ƃ߂�?o����?[�h�ł͂Ȃ�?B���̕�?��̓T�u�X���b�h�̓�??��?X�ɂ�������?B20170611��Ver3.008����ǉ�

            i_SubThread = 1;
            mks();//?V�����X���b�h��??��
            sub.start();
            return;
        } else if (i_SubThread == 1) {
            if (i_sub_mode == 3) {
                sub.stop();
                mks();//?V�����X���b�h��??��
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
    //��?���?錾
    ap orihime_ap;

    //�X���b�h???����Ɏ�?s�����????
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
                orihime_ap.OZ.matome_write_image_jikkoutyuu = true;//�܂Ƃ�?���?o����?s���̈Ӗ�

                int mokuhyou = 100;

                for (int i = 1; i <= mokuhyou; i++) {
                    orihime_ap.oritatami_suitei();
                    orihime_ap.fname_and_number = fname + orihime_ap.OZ.hakkenn_sita_kazu;//�܂Ƃ�?���?o���Ɏg��?B

                    orihime_ap.w_image_jikkoutyuu = true;
                    orihime_ap.repaint();

                    while (orihime_ap.w_image_jikkoutyuu) {// ��������Ȃ���?A?���?o���摜�������邱�Ƃ�����?B

                        // 10�~���b�ҋ@����?B�Ȃ�?A10���K?؂��͕s��20170611
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
        } else if (orihime_ap.i_sub_mode == 4) {//��?F�h��킯�W�J?}
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
//�Q?lurl
//    http://homepage.mac.com/tuyano/JavaTutor/JavaTutor10.html