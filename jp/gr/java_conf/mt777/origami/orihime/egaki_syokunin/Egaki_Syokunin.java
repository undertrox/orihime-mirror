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
    OritaCalc oc = new OritaCalc(); //�e��v�Z�p�̊�?����g�����߂̃N���X�̃C���X�^���X��
    //double r_ten=3.0;                   //��{�}?\���̒�??�̗��[�̉~�̔��a?A�}�Ɗe��|�C���g�̋߂��̔����??
    int ir_ten = 1;

    int icol;//??����?F
    int h_icol = 4;//��????��?F

    //int taisyousei;

    int i_hanasi = 0;//�}�E�X�ʒu�Ɠ��͓_��?��W�𗣂��Ȃ�P?A�����Ȃ��Ȃ�O
    int i_kou_mitudo_nyuuryoku = 0;//�i�q�\����?ׂ���???��p�̓��͕�?��@�\���g���Ȃ�P?A�g��Ȃ��Ȃ�O

    Ten pa = new Ten(); //�}�E�X�{�^���������ꂽ�ʒu����a�_�܂ł̃x�N�g��
    Ten pb = new Ten(); //�}�E�X�{�^���������ꂽ�ʒu����b�_�܂ł̃x�N�g��

    Color sen_tokutyuu_color;//�~���?��???�̓�???F���i�[


    Undo_Box Ubox = new Undo_Box();
    Undo_Box h_Ubox = new Undo_Box();

    Ten moyori_ten = new Ten(100000.0, 100000.0); //�}�E�X?Ŋ�̓_?Bget_moyori_ten(Ten p)��??�߂�?B
    Senbun moyori_senbun = new Senbun(100000.0, 100000.0, 100000.0, 100000.1); //�}�E�X?Ŋ��??��
    Senbun moyori_step_senbun = new Senbun(100000.0, 100000.0, 100000.0, 100000.1); //�}�E�X?Ŋ��step??��(??���ǉ��̂��߂�??�������邽�߂�??��)?B�Ȃ�?A������?錾����K�v�͂Ȃ��̂�?A�ǂ���?錾���ׂ����v����20161113
    En moyori_ensyuu = new En(100000.0, 100000.0, 10.0, 8); //�}�E�X?Ŋ�̉~����??�~
    En moyori_step_ensyuu = new En(100000.0, 100000.0, 10.0, 8); //�}�E�X?Ŋ�̉~����??��step�~

    int i_orisen_hojyosen = 0;//=0��?�??����?@=1�͕�????���̓�?[�h(??�����͎��͂��̂Q��)?B??��???�����?X�ɒl���ȉ��̗l�ɂȂ�?B=0��?�??��?????A=1�͕�?��G???????A=2��?????????A=3�͕�?��????????A=4��?�??�ƕ�?��???�ƕ�?��G??

    int ugokasi_mode = 0;    //�}�𓮂�����??��?[�h?B0=�Ȃɂ����Ȃ�?A1=a�_�𓮂���?A2=b�_�𓮂���?A3=�}��?s�ړ� ?A4=?V�K�ǉ�
    int ieda;              //�A�N�e�B�u�Ȏ}�̔�??

    //  int i_saigo_no_senbun_no_maru_kaku=1;	//1�`��?A0�`���Ȃ�

    public Orisensyuugou ori_s = new Orisensyuugou();    //?�??���i�[����
    Orisensyuugou hoj_s = new Orisensyuugou();    //��????���i�[����


    public Orisensyuugou ori_v = new Orisensyuugou();    //�{??�m�C?}��??���i�[����

    Egaki_Syokunin_Dougubako e_s_dougubako = new Egaki_Syokunin_Dougubako(ori_s);

    private final Senbunsyuugou sen_s = new Senbunsyuugou();    //��{�}?\���̃C���X�^���X��
    //private Senbunsyuugou sen_s;    //��{�}?\���̃C���X�^���X��

    Takakukei gomibako = new Takakukei(4);    //�S�~���̃C���X�^���X��
    Takakukei tyuuoutai = new Takakukei(4);    //�����т̃C���X�^���X��
    double tyuuoutai_xmin = 180.0;
    double tyuuoutai_xmax = 206.0;
    double tyuuoutai_ymin = 50.0;
    double tyuuoutai_ymax = 300.0;

    double kijyun_kakudo = 22.5; //<<<<<<<<<<<<<<<<<<<<<<<��??�p�x<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    //int i_kakudo_kei=36;
    int id_kakudo_kei = 8;//  180/id_kakudo_kei���p�x�n��\��?B���Ƃ���?Aid_kakudo_kei=3�Ȃ�180/3??60�x�n?Aid_kakudo_kei=5�Ȃ�180/5??36�x�n
    //360/i_kakudo_kei-1 = id_kakudo_kei*2-1

    double d_kakudo_kei;//d_kakudo_kei=180.0/(double)id_kakudo_kei
    double kakudo;

    //���͕��@�p�̃p��???[�^
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

    double d_hantei_haba = 50.0;//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<���͓_�������̓_��??���Ƌ߂����ǂ����𔻒肷�鎞�̒l


    public int i_egaki_dankai;//?�??��`����?��̂ǂ̒i�K�ɂ��邩��?�����i�[
    int i_en_egaki_dankai;//�~��`����?��̂ǂ̒i�K�ɂ��邩��?�����i�[
    Senbun[] s_step = new Senbun[1024];//�`�掞�̈ꎞ�\���p�Ɏg��?Bs_step[0] �͎�?ۂ͎g�킸?As_step[1]����g��?B
    En[] e_step = new En[1024];//�`�掞�̈ꎞ�\���p�Ɏg��?Be_step[0] �͎�?ۂ͎g�킸?Ae_step[1]����g��?B


    public int i_kouho_dankai;//?�??��`����?��̂ǂ̌�₩��?�����i�[
    int i_en_kouho_dankai;//�~��`����?��̂ǂ̌�₩��?�����i�[
    Senbun[] s_kouho = new Senbun[16];//�`�掞�̑I�����\���p�Ɏg��?Bs_kouho[0] �͎�?ۂ͎g�킸?As_kouho[1]����g��?B
    En[] e_kouho = new En[16];//�`�掞�̑I�����\���p�Ɏg��?Be_kouho[0] �͎�?ۂ͎g�킸?Ae_kouho[1]����g��?B


    double sokutei_nagasa_1 = 0.0;
    double sokutei_nagasa_2 = 0.0;
    double sokutei_nagasa_3 = 0.0;
    double sokutei_kakudo_1 = 0.0;
    double sokutei_kakudo_2 = 0.0;
    double sokutei_kakudo_3 = 0.0;


    String text_cp_setumei = "";
    String text_cp_setumei2 = "";

    String s_title = ""; //�t��?[����?�?�[��?o�Ă���^�C�g�����??���邽�߂Ɏg�p

    Camera camera = new Camera();

    int i_check1 = 0;//=0 check1�����{���Ȃ�?A1=���{����?@?@
    int i_check2 = 0;//=0 check2�����{���Ȃ�?A1=���{����?@
    int i_check3 = 0;//=0 check3�����{���Ȃ�?A1=���{����?@
    int i_check4 = 0;//=0 check4�����{���Ȃ�?A1=���{����?@
    //---------------------------------
    int i_ck4_color_toukado = 100;

    ap orihime_ap;


    int icol_temp = 0;//?F�w��̈ꎞ�I�ȋL���Ɏg��

    int i_orikaesi = 0;//?܂�Ԃ�( 5)�̓�??��?[�h�w��Ɏg��?B0��?]���^�C�v?iver3.041�ȑO�̂���?j?A�P�͋����^�C�v?B

    //i_mouse_modeA==61//�����`���I��?ipaint�̑I���Ɏ������I���@�\?j�̎��Ɏg��
    Ten p61_1 = new Ten();//TV?��W
    Ten p61_2 = new Ten();//TV?��W
    Ten p61_3 = new Ten();//TV?��W
    Ten p61_4 = new Ten();//TV?��W
    public Takakukei p61_TV_hako = new Takakukei(4);    //�I��(TV?��W)�̃C���X�^���X��
    int p61_mode = 0;//=1 ?V���ɑI�𔠂�??��?B=2?@�_���ړ�?B�R?@�ӂ��ړ�?B�S?@�I�𔠂��ړ�?B


    Ten p = new Ten();


// ****************************************************************************************************************************************
// **************?@�����܂ŕ�?��̒�`?@****************************************************************************************************
// ****************************************************************************************************************************************

    public Egaki_Syokunin(double r0, ap ap0) {  //�R���X�g���N�^

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
        //�p����?����`�����?i�J�n?j
        ori_s.addsenbun(-200.0, -200.0, -200.0, 200.0, 0);
        ori_s.addsenbun(-200.0, -200.0, 200.0, -200.0, 0);
        ori_s.addsenbun(200.0, 200.0, -200.0, 200.0, 0);
        ori_s.addsenbun(200.0, 200.0, 200.0, -200.0, 0);
        //�p����?����`�����?i?I��?j


    }


    // -------------------------------------------
    public void set_i_orikaesi(int i) {//?܂�Ԃ�( 5)�̓�??��?[�h�w��Ɏg��?B0��?]���^�C�v?iver3.041�ȑO�̂���?j?A�P�͋����^�C�v?B
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

        // �W�J?}�p�J??��?ݒ�̓ǂ�?���
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
                    st = str.split(">", 2);// <-----------------------------------�Q�ɕ�������Ƃ���2���w��
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


        // ----------------------------------------- �`�F�b�N�{�b�N�X����?ݒ�̓ǂ�?���
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
                    st = str.split(">", 2);// <-----------------------------------�Q�ɕ�������Ƃ���2���w��


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


        // ----------------------------------------- �i�q?ݒ�̓ǂ�?���


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
                    st = str.split(">", 2);// <-----------------------------------�Q�ɕ�������Ƃ���2���w��

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


        // ----------------------------------------- �i�q?F?ݒ�̓ǂ�?���
        int i_kousi_color_R = 0;
        int i_kousi_color_G = 0;
        int i_kousi_color_B = 0;
        int i_kousi_memori_color_R = 0;
        int i_kousi_memori_color_G = 0;
        int i_kousi_memori_color_B = 0;

        int i_Kousi_iro_yomikomi = 0;//Kousi_iro�̓ǂ�?��݂���������1?A�Ȃ����0
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
                    st = str.split(">", 2);// <-----------------------------------�Q�ɕ�������Ƃ���2���w��


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

        if (i_Kousi_iro_yomikomi == 1) {//Kousi_iro�̓ǂ�?��݂���������1?A�Ȃ����0
            kus.set_kousi_color(new Color(i_kousi_color_R, i_kousi_color_G, i_kousi_color_B)); //kousi��?F

            System.out.println("i_kousi_memori_color_R= " + i_kousi_memori_color_R);
            System.out.println("i_kousi_memori_color_G= " + i_kousi_memori_color_G);
            System.out.println("i_kousi_memori_color_B= " + i_kousi_memori_color_B);
            orihime_ap.kus.set_kousi_memori_color(new Color(i_kousi_memori_color_R, i_kousi_memori_color_G, i_kousi_memori_color_B)); //kousi_memori��?F

        }


        // ?܂�?オ��?}?ݒ�̓ǂ�?��� -------------------------------------------------------------------------

        int i_oriagarizu_F_color_R = 0;
        int i_oriagarizu_F_color_G = 0;
        int i_oriagarizu_F_color_B = 0;

        int i_oriagarizu_B_color_R = 0;
        int i_oriagarizu_B_color_G = 0;
        int i_oriagarizu_B_color_B = 0;

        int i_oriagarizu_L_color_R = 0;
        int i_oriagarizu_L_color_G = 0;
        int i_oriagarizu_L_color_B = 0;


        int i_oriagarizu_yomikomi = 0;//oriagarizu�̓ǂ�?��݂���������1?A�Ȃ����0
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
                    st = str.split(">", 2);// <-----------------------------------�Q�ɕ�������Ƃ���2���w��

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
            orihime_ap.OZ.js.set_F_color(new Color(i_oriagarizu_F_color_R, i_oriagarizu_F_color_G, i_oriagarizu_F_color_B)); //�\�ʂ�?F
            orihime_ap.Button_F_color.setBackground(new Color(i_oriagarizu_F_color_R, i_oriagarizu_F_color_G, i_oriagarizu_F_color_B));    //�{�^����?F?ݒ�

            orihime_ap.OZ.js.set_B_color(new Color(i_oriagarizu_B_color_R, i_oriagarizu_B_color_G, i_oriagarizu_B_color_B));//���ʂ�?F
            orihime_ap.Button_B_color.setBackground(new Color(i_oriagarizu_B_color_R, i_oriagarizu_B_color_G, i_oriagarizu_B_color_B));//�{�^����?F?ݒ�

            orihime_ap.OZ.js.set_L_color(new Color(i_oriagarizu_L_color_R, i_oriagarizu_L_color_G, i_oriagarizu_L_color_B));        //??��?F
            orihime_ap.Button_L_color.setBackground(new Color(i_oriagarizu_L_color_R, i_oriagarizu_L_color_G, i_oriagarizu_L_color_B));        //�{�^����?F?ݒ�
        }
    }

    //-----------------------------
    public String setMemo_for_redo_undo(Memo memo1) {//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<undo,redo�ł�kiroku�����p

        //Memo_jyouhou_toridasi(memo1);
        return ori_s.setMemo(memo1);
    }


    //-----------------------------
    public void setMemo_for_yomikomi(Memo memo1) {//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<�f?[�^�ǂ�?��ݗp
        Memo_jyouhou_toridasi(memo1);
        ori_s.setMemo(memo1);
        hoj_s.h_setMemo(memo1);
    }

    //-----------------------------
    public void setMemo_for_yomikomi_tuika(Memo memo1) {//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<�f?[�^�ǂ�?��ݗp
        //Memo_jyouhou_toridasi(memo1);
        //ori_s.setMemo(memo1); hoj_s.h_setMemo(memo1);

        double addx, addy;


        Orisensyuugou ori_s_temp = new Orisensyuugou();    //�ǉ����ꂽ?�??�������?o�����߂Ɏg��
        ori_s_temp.setMemo(memo1);//�ǉ����ꂽ?�??�������?o����ori_s_temp��??��
        //ori_s.del_selected_senbun_hayai();//�Z���N�g���ꂽ?�??��???�����?B
        addx = ori_s.get_x_max() + 100.0 - ori_s_temp.get_x_min();
        addy = ori_s.get_y_max() - ori_s_temp.get_y_max();


        ori_s_temp.move(addx, addy);//�S�̂��ړ�����

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


    //?�?��??��p��select���ꂽ??��?W?���?�???��? int�Ƃ���?o�͂���?B//icol��3(cyan?????F)��?�̕�????�̓J�E���g���Ȃ�
    public int get_orisensuu_for_select_oritatami() {
        return ori_s.get_orisensuu_for_select_oritatami();
    }

    public Senbunsyuugou get_for_select_oritatami() {//select����?�??��?܂�?��??�������?B
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
    } //<<<<<<<<<<<<<<<<<<<<<<<��??�p�x<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


    //------------------------
    public Memo getMemo() {
        return ori_s.getMemo();
    }


    //getMemo(String s_title)��undo,redo��kiroku�p
    public Memo getMemo(String s_title) {//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<undo,redo��kiroku�p
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
    public Memo getMemo_for_kakidasi() {//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<�f?[�^?���?o��

        Memo memo_temp = new Memo();
        memo_temp.set(ori_s.getMemo());
        memo_temp.addMemo(hoj_s.h_getMemo());
        Memo_jyouhou_tuika(memo_temp);
        return memo_temp;
    }

    //------------------------svg�f?[�^?���?o��
    public Memo getMemo_for_svg_kakidasi_with_camera(int i_bun_hyouji, int i_cp_hyouji, int i_a0_hyouji, int i_a1_hyouji, float fTenkaizuSenhaba, int i_orisen_hyougen, float f_h_TenkaizuSenhaba, int p0x_max, int p0y_max, int i_mejirusi_hyouji) {//��?��̓J??��?ݒ�?A?????A���X???A���y?���
        Memo memo_temp = new Memo();

        //String text=new String();//������????�p�̃N���X�̃C���X�^���X��
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


        //�W�J?}�̕`��  ��?��???�ȊO��?�??
        if (i_cp_hyouji == 1) {

            //float dash_M1[] = {10.0f, 3.0f, 3.0f, 3.0f};//��_?�??
            //float dash_M2[] = {10.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f};//��_?�??
            //float dash_V[]  = {8.0f, 8.0f};//�j??

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
                        //g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//��{�w��A?@?@??�̑�����??�̖��[�̌`??
                    }

                    if (i_orisen_hyougen == 2) {
                        //g_setColor(g,ori_s.getcolor(i));
                        if (ori_s.getcolor(i) == 0) {
                        }//��{�w��A?@?@??�̑�����??�̖��[�̌`??
                        if (ori_s.getcolor(i) == 1) {
                            str_stroke_dasharray = "stroke-dasharray=\"10 3 3 3\"";
                        }//dash_M1,��_?�??
                        if (ori_s.getcolor(i) == 2) {
                            str_stroke_dasharray = "stroke-dasharray=\"8 8\"";
                        }//dash_V ,�j??
                    }


                    if (i_orisen_hyougen == 3) {
                        str_stroke = "black";
                        if (ori_s.getcolor(i) == 0) {
                        }//��{�w��A?@?@??�̑�����??�̖��[�̌`??
                        if (ori_s.getcolor(i) == 1) {
                            str_stroke_dasharray = "stroke-dasharray=\"10 3 3 3\"";
                        }//dash_M1,��_?�??
                        if (ori_s.getcolor(i) == 2) {
                            str_stroke_dasharray = "stroke-dasharray=\"8 8\"";
                        }//dash_V ,�j??
                    }

                    if (i_orisen_hyougen == 4) {
                        str_stroke = "black";
                        if (ori_s.getcolor(i) == 0) {
                        }//��{�w��A?@?@??�̑�����??�̖��[�̌`??
                        if (ori_s.getcolor(i) == 1) {
                            str_stroke_dasharray = "stroke-dasharray=\"10 3 3 3 3 3\"";
                        }//dash_M2,��_?�??
                        if (ori_s.getcolor(i) == 2) {
                            str_stroke_dasharray = "stroke-dasharray=\"8 8\"";
                        }//dash_V ,�j??
                    }


/*
					if(i_orisen_hyougen==1){
						g_setColor(g,ori_s.getcolor(i));
						g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//��{�w��A?@?@??�̑�����??�̖��[�̌`??
					}

					if(i_orisen_hyougen==2){
						g_setColor(g,ori_s.getcolor(i));
						if(ori_s.getcolor(i)==0){g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER				));}//��{�w��A?@?@??�̑�����??�̖��[�̌`??
						if(ori_s.getcolor(i)==1){g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,10.0f, dash_M1, 0.0f	));}//��_?�??//??�̑�����??�̖��[�̌`??
						if(ori_s.getcolor(i)==2){g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,10.0f, dash_V , 0.0f	));}//�j??//??�̑�����??�̖��[�̌`??
					}

					if(i_orisen_hyougen==3){
						if(ori_s.getcolor(i)==0){g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER				));}//��{�w��A?@?@??�̑�����??�̖��[�̌`??
						if(ori_s.getcolor(i)==1){g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,10.0f, dash_M1, 0.0f	));}//��_?�??//??�̑�����??�̖��[�̌`??
						if(ori_s.getcolor(i)==2){g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,10.0f, dash_V , 0.0f	));}//�j??//??�̑�����??�̖��[�̌`??
					}

					if(i_orisen_hyougen==4){
						if(ori_s.getcolor(i)==0){g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));}//��{�w��A?@?@??�̑�����??�̖��[�̌`??
						if(ori_s.getcolor(i)==1){g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,10.0f, dash_M2, 0.0f));}//��_?�??//??�̑�����??�̖��[�̌`??
						if(ori_s.getcolor(i)==2){g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,10.0f, dash_V , 0.0f));}//�j??//??�̑�����??�̖��[�̌`??
					}

*/


                    s_tv.set(camera.object2TV(ori_s.get(i)));
                    a.set(s_tv.geta());
                    b.set(s_tv.getb());//a.set(s_tv.getax()+0.000001,s_tv.getay()+0.000001); b.set(s_tv.getbx()+0.000001,s_tv.getby()+0.000001);//�Ȃ�0.000001�𑫂����Ƃ�����,�f�B�X�v���C�ɕ`�悷��Ƃ�����?�??��?V����?�??�ɉe������ē����Ă��܂��̂�h������


//					g.drawLine( (int)a.getx(),(int)a.gety(),(int)b.getx(),(int)b.gety()); //��??

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
                        if (fTenkaizuSenhaba < 2.0f) {//���_��?���?����`��`��
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

                            //g.fillRect( (int)a.getx()-i_haba,(int)a.gety()-i_haba,2*i_haba+1,2*i_haba+1); //?����`��`��//g.fillRect(10, 10, 100, 50);�����`��`��
                            //g.fillRect( (int)b.getx()-i_haba,(int)b.gety()-i_haba,2*i_haba+1,2*i_haba+1); //?����`��`��
                        }
                    }

                    if (fTenkaizuSenhaba >= 2.0f) {//  ��??
                        //g2.setStroke(new BasicStroke(1.0f+fTenkaizuSenhaba%1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//??�̑�����??�̖��[�̌`???A�����ł�?�??�̒[�_��??�̌`?�̎w��
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
							//g.fillOval( (int)a.getx()-i_haba/2,(int)a.gety()-i_haba/2,i_haba,i_haba); //�~


							g.setColor(Color.black);
							g2.draw(new Ellipse2D.Double(a.getx()-d_haba, a.gety()-d_haba, 2.0*d_haba,2.0*d_haba));
							//g.drawOval( (int)a.getx()-i_haba/2,(int)a.gety()-i_haba/2,i_haba,i_haba); //�~

							g.setColor(Color.white);
							g2.fill(new Ellipse2D.Double(b.getx()-d_haba, b.gety()-d_haba, 2.0*d_haba,2.0*d_haba));
							//g.fillOval( (int)b.getx()-i_haba/2,(int)b.gety()-i_haba/2,i_haba,i_haba); //�~

							g.setColor(Color.black);
							g2.draw(new Ellipse2D.Double(b.getx()-d_haba, b.gety()-d_haba, 2.0*d_haba,2.0*d_haba));
						*/    //g.drawOval( (int)b.getx()-i_haba/2,(int)b.gety()-i_haba/2,i_haba,i_haba); //�~
                        }
                    }


                }
            }
        }


        return memo_temp;
    }


    //---------------------------------------------------------------------------------------------------------------------------------
    public void Memo_jyouhou_tuika(Memo memo1) {
        //String str=new String();//������????�p�̃N���X�̃C���X�^���X��
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


        //�W�J?}��??�̑���?B
        memo1.addGyou("<iTenkaizuSenhaba>" +
                orihime_ap.iTenkaizuSenhaba +
                "</iTenkaizuSenhaba>");

        //���_�̂��邵��??
        memo1.addGyou("<ir_ten>" +
                orihime_ap.ir_ten +
                "</ir_ten>");

        //?�??�\����?F�ŕ\��
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
    //��?�?��̎w��
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

    //�s�v��??����?�������-----------------------------------------------
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
  //�}�𓮂��������????��?s����??----------------------------------------------------
	public void eda_atosyori_01() {//�}�̒�����ς�����?A�}�S�̂�?s�ړ����Ĕ���?�����?B
    //�A�N�e�B�u�ȑт̈ʒu�����?�����
    Ten ab = new Ten(1,ori_s.getb(ieda),-1,ori_s.geta(ieda));//�A�N�e�B�u�Ȏ}��?A�_a����_b�֌������x�N�g��
    Ten ba = new Ten(1,ori_s.geta(ieda),-1,ori_s.getb(ieda));//�A�N�e�B�u�Ȏ}��?A�_a����_b�֌������x�N�g��

    int jeda;   //�A�N�e�B�u�Ȏ}�Ƌ߂��ʂ̎}
    int jbasyo; //�A�N�e�B�u�Ȏ}�Ƌ߂��ʂ̎}�̂ǂ����߂��̂����������߂̔�??

    //?@�A�N�e�B�u�Ȏ}��a�_?@��?@�ʂ̎}?@�Ƃ̋�����?@��?@���߂�????

    jeda=ori_s.senbun_sagasi(ori_s.geta(ieda),2*r_ten,ieda);//�A�N�e�B�u�Ȏ}��a�_�Ƌ߂��ʂ̎}��??�߂�?B
    jbasyo= ori_s.senbun_busyo_sagasi(jeda,ori_s.geta(ieda),2*r_ten);//�ʂ̎}�̂ǂ̕�?����߂�����??�߂�?B
    if( (jeda!=0) && (jbasyo==1)){ //�A�N�e�B�u�Ȏ}��a�_��?A�ʂ̎}��a�_���߂�????
      ori_s.seta(ieda,ori_s.geta(jeda));
      ori_s.setb(ieda,new Ten(1,ori_s.geta(ieda),1,ab));//����?����Ă������Ɠ����l�Ȃ̂�?A���̂܂܎g��?B
    }
    if( (jeda!=0) && (jbasyo==2)){ //�A�N�e�B�u�Ȏ}��a�_��?A�ʂ̎}��b�_���߂�????
      ori_s.seta(ieda,ori_s.getb(jeda));
      ori_s.setb(ieda,new Ten(1,ori_s.geta(ieda),1,ab));
    }

    //?@�A�N�e�B�u�Ȏ}��b�_?@��?@�ʂ̎}?@�Ƃ̋�����?@��?@���߂�????
    jeda=ori_s.senbun_sagasi(ori_s.getb(ieda),2*r_ten,ieda);//�A�N�e�B�u�Ȏ}��b�_�Ƌ߂��ʂ̎}��??�߂�?B
    jbasyo= ori_s.senbun_busyo_sagasi(jeda,ori_s.getb(ieda),2*r_ten);//�ʂ̎}�̂ǂ̕�?����߂�����??�߂�?B
    if( (jeda!=0) && (jbasyo==1)){ //�A�N�e�B�u�Ȏ}��b�_��?A�ʂ̎}��a�_���߂�????
      ori_s.setb(ieda,ori_s.geta(jeda));
      ori_s.seta(ieda,new Ten(1,ori_s.getb(ieda),1,ba));
    }
    if( (jeda!=0) && (jbasyo==2)){ //�A�N�e�B�u�Ȏ}��b�_��?A�ʂ̎}��b�_���߂�????
        ori_s.setb(ieda,ori_s.getb(jeda));
	ori_s.seta(ieda,new Ten(1,ori_s.getb(ieda),1,ba));
    }
  }
*/
/*
  //�}�𓮂��������????��?s����??----------------------------------------------------
	public void eda_atosyori_02() {//��[�̓_�������ړ����Ĕ��΂̒[�̓_�͓������Ȃ��Ŕ���?�����?B
    //�A�N�e�B�u�ȑт̈ʒu�����?�����

    int jeda;   //�A�N�e�B�u�Ȏ}�Ƌ߂��ʂ̎}
    int jbasyo; //�A�N�e�B�u�Ȏ}�Ƌ߂��ʂ̎}�̂ǂ����߂��̂����������߂̔�??
	if(ori_s.getnagasa(ieda)>=r_ten){
    //?@�A�N�e�B�u�Ȏ}��a�_?@��?@�ʂ̎}�Ƃ̋�����?@��?@���߂�????
    jeda=ori_s.senbun_sagasi(ori_s.geta(ieda),r_ten,ieda);//�A�N�e�B�u�Ȏ}��a�_�Ƌ߂��ʂ̎}��??�߂�?B
    jbasyo= ori_s.senbun_busyo_sagasi(jeda,ori_s.geta(ieda),r_ten);//�ʂ̎}�̂ǂ̕�?����߂�����??�߂�?B
    if( (jeda!=0) && (jbasyo==1)){ori_s.seta(ieda,ori_s.geta(jeda));}//�A�N�e�B�u�Ȏ}��a�_��?A�ʂ̎}��a�_���߂�????
    if( (jeda!=0) && (jbasyo==2)){ori_s.seta(ieda,ori_s.getb(jeda));}//�A�N�e�B�u�Ȏ}��a�_��?A�ʂ̎}��b�_���߂�????

    //?@�A�N�e�B�u�Ȏ}(ieda)��b�_?@��?@�ʂ̎}(jeda)�Ƃ̋�����?@��?@���߂�????
    jeda=ori_s.senbun_sagasi(ori_s.getb(ieda),r_ten,ieda);//�A�N�e�B�u�Ȏ}��b�_�Ƌ߂��ʂ̎}��??�߂�?B
    jbasyo= ori_s.senbun_busyo_sagasi(jeda,ori_s.getb(ieda),r_ten);//�ʂ̎}�̂ǂ̕�?����߂�����??�߂�?B
    if((jeda!=0) && (jbasyo==1)){ori_s.setb(ieda,ori_s.geta(jeda));}//�A�N�e�B�u�Ȏ}��b�_��?A�ʂ̎}��a�_���߂�????
    if((jeda!=0) && (jbasyo==2)){ori_s.setb(ieda,ori_s.getb(jeda));}//�A�N�e�B�u�Ȏ}��b�_��?A�ʂ̎}��b�_���߂�????

 //�ȉ���070317�ɒǉ� ��?���??����?W�܂������_��ʂ̒��_�߂���??���Ă������Ƃ��̌�????�p
//150312?@?@2*r?@��?@r?@��?C?�


    //?@�A�N�e�B�u�Ȏ}��a�_?@��?@�ʂ̎}�Ƃ̋�����?@��?@���߂�????
    jeda=ori_s.senbun_sagasi(ori_s.geta(ieda),r_ten,-10);//�A�N�e�B�u��ieda�}��a�_�Ƌ߂��ʂ̎}��??�߂�?B
    jbasyo= ori_s.senbun_busyo_sagasi(jeda,ori_s.geta(ieda),r_ten);//�ʂ̎}�̂ǂ̕�?����߂�����??�߂�?B

    if((jeda!=0) && (jbasyo==1)){ori_s.kasseika(ori_s.geta(jeda),r_ten); ori_s.set(ori_s.geta(jeda));}//�A�N�e�B�u��ieda�}��a�_��?A�ʂ̎}��a�_���߂�????
    if((jeda!=0) && (jbasyo==2)){ori_s.kasseika(ori_s.getb(jeda),r_ten); ori_s.set(ori_s.getb(jeda));}//�A�N�e�B�u��ieda�}��a�_��?A�ʂ̎}��b�_���߂�????

    //?@�A�N�e�B�u�Ȏ}(ieda)��b�_?@��?@�ʂ̎}(jeda)�Ƃ̋�����?@��?@���߂�????
    jeda=ori_s.senbun_sagasi(ori_s.getb(ieda),r_ten,-10);//�A�N�e�B�u��ieda�}��b�_�Ƌ߂��ʂ̎}��??�߂�?B
    jbasyo= ori_s.senbun_busyo_sagasi(jeda,ori_s.getb(ieda),r_ten);//�ʂ̎}�̂ǂ̕�?����߂�����??�߂�?B

    if((jeda!=0) && (jbasyo==1)){ori_s.kasseika(ori_s.geta(jeda),r_ten); ori_s.set(ori_s.geta(jeda));}//�A�N�e�B�u��ieda�}��b�_��?A�ʂ̎}��a�_���߂�????
    if((jeda!=0) && (jbasyo==2)){ori_s.kasseika(ori_s.getb(jeda),r_ten); ori_s.set(ori_s.getb(jeda));}//�A�N�e�B�u��ieda�}��b�_��?A�ʂ̎}��b�_���߂�????
 	}

 }
*/
    public void bunkatu_seiri() {
        ori_s.bunkatu_seiri();
    }

    //public void  bunkatu_seiri_for_Smen_hassei(){ori_s.bunkatu_seiri_for_Smen_hassei();}//ori_s�Ƃ�??��?W?��̂���?ASenbunsyuugou ori_s =new Senbunsyuugou();

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
        //ori_s.addsenbun  delsenbun�����{���Ă���Ƃ����check�����{
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

        //ori_s.addsenbun  delsenbun�����{���Ă���Ƃ����check�����{
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
        //ori_s.addsenbun  delsenbun�����{���Ă���Ƃ����check�����{
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


    public void kousi_oekaki_with_camera(Graphics g, int i_bun_hyouji, int i_cp_hyouji, int i_a0_hyouji, int i_a1_hyouji, float fTenkaizuSenhaba, int i_orisen_hyougen, float f_h_TenkaizuSenhaba, int p0x_max, int p0y_max) {//��?��̓J??��?ݒ�?A?????A���X???A���y?���
        //System.out.println(" E 20170201_1");
        Graphics2D g2 = (Graphics2D) g;

        String text = "";//������????�p�̃N���X�̃C���X�^���X��
        double d;
        OritaOekaki OO = new OritaOekaki();

        Senbun s_tv = new Senbun();
        Ten a = new Ten();
        Ten b = new Ten();

        Senbun s_ob = new Senbun();


        // ------------------------------------------------------

        //�i�q??�̕`��
        if (i_kou_mitudo_nyuuryoku == 0) {
            kus.oekaki(g, camera, p0x_max, p0y_max, 0);
        }
        if (i_kou_mitudo_nyuuryoku == 1) {
            kus.oekaki(g, camera, p0x_max, p0y_max, 1);
        }
    }


    //------------------------------------------------------------------------------
//��{�}�̕`��111111111111111111111111111111111111111111111111111111111111111111		//System.out.println("_");
//------------------------------------------------------------------------------
    public void oekaki_with_camera(Graphics g, int i_bun_hyouji, int i_cp_hyouji, int i_a0_hyouji, int i_a1_hyouji, float fTenkaizuSenhaba, int i_orisen_hyougen, float f_h_TenkaizuSenhaba, int p0x_max, int p0y_max, int i_mejirusi_hyouji) {//��?��̓J??��?ݒ�?A?????A���X???A���y?���
        //System.out.println(" E 20170201_1");
        Graphics2D g2 = (Graphics2D) g;

        String text = "";//������????�p�̃N���X�̃C���X�^���X��
        double d;
        OritaOekaki OO = new OritaOekaki();

        Senbun s_tv = new Senbun();
        Ten a = new Ten();
        Ten b = new Ten();

        Senbun s_ob = new Senbun();


        // ------------------------------------------------------

        //�i�q??�̕`��
        if (i_kou_mitudo_nyuuryoku == 0) {
            kus.oekaki(g, camera, p0x_max, p0y_max, 0);
        }
        if (i_kou_mitudo_nyuuryoku == 1) {
            kus.oekaki(g, camera, p0x_max, p0y_max, 1);
        }


        BasicStroke BStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
        g2.setStroke(BStroke);//??�̑�����??�̖��[�̌`??

        //��?��????i?�??�Ɣ�?�?j�̕`��
        if (i_a1_hyouji == 1) {
            g2.setStroke(new BasicStroke(f_h_TenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//??�̑�����??�̖��[�̌`??
            for (int i = 1; i <= hoj_s.getsousuu(); i++) {

                //if(hoj_s.getcolor(i)==4){g.setColor(Color.orange);System.out.println("hoj_s.getcolor(i)==4");}
                //if(hoj_s.getcolor(i)==7){g.setColor(Color.yellow);System.out.println("hoj_s.getcolor(i)==7");}
                g_setColor(g, hoj_s.getcolor(i));

                s_tv.set(camera.object2TV(hoj_s.get(i)));
                //a.set(s_tv.geta()); b.set(s_tv.getb());
                a.set(s_tv.getax() + 0.000001, s_tv.getay() + 0.000001);
                b.set(s_tv.getbx() + 0.000001, s_tv.getby() + 0.000001);//�Ȃ�0.000001�𑫂����Ƃ�����,�f�B�X�v���C�ɕ`�悷��Ƃ�����?�??��?V����?�??�ɉe������ē����Ă��܂��̂�h������

                g.drawLine((int) a.getx(), (int) a.gety(), (int) b.getx(), (int) b.gety()); //��??

                if (fTenkaizuSenhaba < 2.0f) {//���_��?����`��`��
                    g.setColor(Color.black);
                    //int i_haba=1;
                    int i_haba = ir_ten;
                    g.fillRect((int) a.getx() - i_haba, (int) a.gety() - i_haba, 2 * i_haba + 1, 2 * i_haba + 1); //?����`��`��//g.fillRect(10, 10, 100, 50);�����`��`��
                    g.fillRect((int) b.getx() - i_haba, (int) b.gety() - i_haba, 2 * i_haba + 1, 2 * i_haba + 1); //?����`��`��
                }

                if (fTenkaizuSenhaba >= 2.0f) {//  ��??
                    //	OO.habaLine( g,s_tv,iTenkaizuSenhaba,hoj_s.getcolor(i));
                    g2.setStroke(new BasicStroke(1.0f + f_h_TenkaizuSenhaba % 1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//??�̑�����??�̖��[�̌`??
                    //OO.habaLine( g,s_tv,iTenkaizuSenhaba,k.getcolor(i));

                    //int i_haba=iTenkaizuSenhaba;
                    //g.fillOval( (int)a.getx()-i_haba,(int)a.gety()-i_haba,2*i_haba,2*i_haba); //�~
                    //g.fillOval( (int)b.getx()-i_haba,(int)b.gety()-i_haba,2*i_haba,2*i_haba); //�~

                    if (ir_ten != 0) {

                        int i_haba = (int) fTenkaizuSenhaba + ir_ten;//int i_haba=2;
                        double d_haba = (double) fTenkaizuSenhaba / 2.0 + (double) ir_ten;//int i_haba=2;

                        g.setColor(Color.white);
                        g2.fill(new Ellipse2D.Double(a.getx() - d_haba, a.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                        //g.fillOval( (int)a.getx()-i_haba/2,(int)a.gety()-i_haba/2,i_haba,i_haba); //�~

                        g.setColor(Color.black);
                        g2.draw(new Ellipse2D.Double(a.getx() - d_haba, a.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                        //g.drawOval( (int)a.getx()-i_haba/2,(int)a.gety()-i_haba/2,i_haba,i_haba); //�~

                        g.setColor(Color.white);
                        g2.fill(new Ellipse2D.Double(b.getx() - d_haba, b.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                        //g.fillOval( (int)b.getx()-i_haba/2,(int)b.gety()-i_haba/2,i_haba,i_haba); //�~

                        g.setColor(Color.black);
                        g2.draw(new Ellipse2D.Double(b.getx() - d_haba, b.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                        //g.drawOval( (int)b.getx()-i_haba/2,(int)b.gety()-i_haba/2,i_haba,i_haba); //�~
                    }

                    g2.setStroke(new BasicStroke(f_h_TenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//??�̑�����??�̖��[�̌`??

                }
            }
        }
        //System.out.println(" E 20170201_2");

        // ----------------------------------------------------------------

        //check���ʂ̕\��

        g2.setStroke(new BasicStroke(15.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));//??�̑�����??�̖��[�̌`???A�����ł�?�??�̒[�_��??�̌`?�̎w��


        //Check1Senb�ɂ�0�Ԗڂ���size()-1�Ԗڂ܂Ńf?[�^�������Ă���
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

        g2.setStroke(new BasicStroke(25.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));//??�̑�����??�̖��[�̌`???A�����ł�?�??�̒[�_��??�̌`?�̎w��


        //Check4Senb�ɂ�0�Ԗڂ���size()-1�Ԗڂ܂Ńf?[�^�������Ă���
        //System.out.println("ori_s.check4_size() = "+ori_s.check4_size());
        if (i_check4 == 1) {
            for (int i = 0; i < ori_s.check4_size(); i++) {
                Senbun s_temp = new Senbun();
                s_temp.set(ori_s.check4_getSenbun(i));
                OO.yubisasi4(g, camera.object2TV(s_temp), i_ck4_color_toukado);
            }
        }


        //Check3Senb�ɂ�0�Ԗڂ���size()-1�Ԗڂ܂Ńf?[�^�������Ă���
        if (i_check3 == 1) {
            for (int i = 0; i < ori_s.check3_size(); i++) {
                Senbun s_temp = new Senbun();
                s_temp.set(ori_s.check3_getSenbun(i));
                //OO.jyuuji(g,camera.object2TV(s_temp.geta()), 7.0 , 3.0 , 1);
                OO.yubisasi3(g, camera.object2TV(s_temp), 7.0, 3.0, 1);
            }
        }


        //System.out.println(" E 20170201_4");

        //camera��?S��?\���ŕ`��
        if (i_mejirusi_hyouji == 1) {
            OO.jyuuji(g, camera.object2TV(camera.get_camera_ichi()), 5.0, 2.0, 3);
        }


        //System.out.println(" E 20170201_5");


        //�~��`��?@
        //System.out.println(" �~��`�� ori_s.cir_size()="+ori_s.cir_size());
        if (i_a0_hyouji == 1) {
            for (int i = 1; i <= ori_s.cir_size(); i++) {

                double d_haba;
                En e_temp = new En();
                e_temp.set(ori_s.cir_getEn(i));

                a.set(camera.object2TV(e_temp.get_tyuusin()));//����???���a�͕`��?��W�n�ł̉~�̒�?S�̈ʒu
                //a.set(a.getx()+0.000001,a.gety()+0.000001);//�Ȃ�0.000001�𑫂����Ƃ�����,�f�B�X�v���C�ɕ`�悷��Ƃ�����?�??��?V����?�??�ɉe������ē����Ă��܂��̂�h������

                g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//��{�w��A?@?@??�̑�����??�̖��[�̌`??
                //g.setColor(Color.cyan);


//System.out.println("get_tpp_en("+i+") = "+ori_s.get_tpp_en(i));
                if (e_temp.get_tpp() == 0) {
                    g_setColor(g, e_temp.getcolor());
                } else if (e_temp.get_tpp() == 1) {
                    g.setColor(e_temp.get_tpp_color());
                }


                //�~���̕`��
                d_haba = e_temp.getr() * camera.get_camera_bairitsu_x();//d_haba�͕`�掞�̉~�̔��a?B�Ȃ�?Acamera.get_camera_bairitsu_x()??camera.get_camera_bairitsu_y()��O��Ƃ��Ă���?B
                g2.draw(new Ellipse2D.Double(a.getx() - d_haba, a.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));


                // �_t_o�����G��������̂ɕK�v�Ȏ�??
                //Ten t_o =new Ten(100.0,100.0);//t_o���`
                //Ten t_T =new Ten();t_T.set(camera.object2TV(t_o));//t_T���`��?At_o��`��p?��W�p�ɂɕϊ������̂�set����?B
                //g.fillRect( (int)t_T.getx()-1,(int)t_T.gety()-1,3,3); //?����`��`��//g.fillRect(10, 10, 100, 50);�����`��`��

/*
				Ten t_o =new Ten();Ten t_T =new Ten();
				for(int h=1;h<360;h++ ){
					t_o.set(e_temp.get_tyuusin().getx()+e_temp.getr()*Math.cos((double)h),
						e_temp.get_tyuusin().gety()+e_temp.getr()*Math.sin((double)h));

					t_T.set(camera.object2TV(t_o));
					g.fillRect( (int)t_T.getx()-1,(int)t_T.gety()-1,3,3); //?����`��`��//g.fillRect(10, 10, 100, 50);�����`��`��
				}
*/
            }
        }


        //�~�̒�?S�̕`��
        if (i_a0_hyouji == 1) {
            for (int i = 1; i <= ori_s.cir_size(); i++) {
                //if(ori_s.getcolor(i)==3){
                double d_haba;
                En e_temp = new En();
                e_temp.set(ori_s.cir_getEn(i));
                //System.out.println("Es1 ���G����  "+ i+";" +e_temp.getx()+"," +e_temp.gety()+"," +e_temp.getr());

                a.set(camera.object2TV(e_temp.get_tyuusin()));//����???���a�͕`��?��W�n�ł̉~�̒�?S�̈ʒu
                //a.set(a.getx()+0.000001,a.gety()+0.000001);//�Ȃ�0.000001�𑫂����Ƃ�����,�f�B�X�v���C�ɕ`�悷��Ƃ�����?�??��?V����?�??�ɉe������ē����Ă��܂��̂�h������

                g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//��{�w��A?@?@??�̑�����??�̖��[�̌`??
                //g.setColor(Color.cyan);
                g.setColor(new Color(0, 255, 255, 255));

                //�~�̒�?S�̕`��
                if (fTenkaizuSenhaba < 2.0f) {//��?S��?���?����`��`��
                    g.setColor(Color.black);
                    //int i_haba=1;
                    int i_haba = ir_ten;
                    g.fillRect((int) a.getx() - i_haba, (int) a.gety() - i_haba, 2 * i_haba + 1, 2 * i_haba + 1); //?����`��`��//g.fillRect(10, 10, 100, 50);�����`��`��
                    //g.fillRect( (int)b.getx()-i_haba,(int)b.gety()-i_haba,2*i_haba+1,2*i_haba+1); //?����`��`��
                }

                if (fTenkaizuSenhaba >= 2.0f) {//  ��??�w�莞�̒�?S������?���?��~��`��
                    g2.setStroke(new BasicStroke(1.0f + fTenkaizuSenhaba % 1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//??�̑�����??�̖��[�̌`???A�����ł�?�??�̒[�_��??�̌`?�̎w��
                    if (ir_ten != 0) {
                        int i_haba = (int) fTenkaizuSenhaba + ir_ten;//int i_haba=2;
                        d_haba = (double) fTenkaizuSenhaba / 2.0 + (double) ir_ten;//int i_haba=2;


                        g.setColor(Color.white);
                        g2.fill(new Ellipse2D.Double(a.getx() - d_haba, a.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                        //g.fillOval( (int)a.getx()-i_haba/2,(int)a.gety()-i_haba/2,i_haba,i_haba); //�~


                        g.setColor(Color.black);
                        g2.draw(new Ellipse2D.Double(a.getx() - d_haba, a.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                        //g.drawOval( (int)a.getx()-i_haba/2,(int)a.gety()-i_haba/2,i_haba,i_haba); //�~

                    }
                }
                //}
            }

        }


        //select�̕`��
        g2.setStroke(new BasicStroke(fTenkaizuSenhaba * 2.0f + 2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//��{�w��A?@?@??�̑�����??�̖��[�̌`??
        for (int i = 1; i <= ori_s.getsousuu(); i++) {
            if (ori_s.get_select(i) == 2) {
                g.setColor(Color.green);

                s_tv.set(camera.object2TV(ori_s.get(i)));

                a.set(s_tv.getax() + 0.000001, s_tv.getay() + 0.000001);
                b.set(s_tv.getbx() + 0.000001, s_tv.getby() + 0.000001);//�Ȃ�0.000001�𑫂����Ƃ�����,�f�B�X�v���C�ɕ`�悷��Ƃ�����?�??��?V����?�??�ɉe������ē����Ă��܂��̂�h������

                g.drawLine((int) a.getx(), (int) a.gety(), (int) b.getx(), (int) b.gety()); //��??

            }
        }


        //�W�J?}�̕`�� ��?��???�̂�
        if (i_a0_hyouji == 1) {
            for (int i = 1; i <= ori_s.getsousuu(); i++) {
                if (ori_s.getcolor(i) == 3) {

                    g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//��{�w��A?@?@??�̑�����??�̖��[�̌`??
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
                    b.set(s_tv.getbx() + 0.000001, s_tv.getby() + 0.000001);//�Ȃ�0.000001�𑫂����Ƃ�����,�f�B�X�v���C�ɕ`�悷��Ƃ�����?�??��?V����?�??�ɉe������ē����Ă��܂��̂�h������

                    g.drawLine((int) a.getx(), (int) a.gety(), (int) b.getx(), (int) b.gety()); //��??

                    if (fTenkaizuSenhaba < 2.0f) {//���_��?���?����`��`��
                        g.setColor(Color.black);
                        //int i_haba=1;
                        int i_haba = ir_ten;
                        g.fillRect((int) a.getx() - i_haba, (int) a.gety() - i_haba, 2 * i_haba + 1, 2 * i_haba + 1); //?����`��`��//g.fillRect(10, 10, 100, 50);�����`��`��
                        g.fillRect((int) b.getx() - i_haba, (int) b.gety() - i_haba, 2 * i_haba + 1, 2 * i_haba + 1); //?����`��`��
                    }

                    if (fTenkaizuSenhaba >= 2.0f) {//  ��??
                        g2.setStroke(new BasicStroke(1.0f + fTenkaizuSenhaba % 1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//??�̑�����??�̖��[�̌`???A�����ł�?�??�̒[�_��??�̌`?�̎w��
                        if (ir_ten != 0) {
                            int i_haba = (int) fTenkaizuSenhaba + ir_ten;//int i_haba=2;
                            double d_haba = (double) fTenkaizuSenhaba / 2.0 + (double) ir_ten;//int i_haba=2;


                            g.setColor(Color.white);
                            g2.fill(new Ellipse2D.Double(a.getx() - d_haba, a.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                            //g.fillOval( (int)a.getx()-i_haba/2,(int)a.gety()-i_haba/2,i_haba,i_haba); //�~


                            g.setColor(Color.black);
                            g2.draw(new Ellipse2D.Double(a.getx() - d_haba, a.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                            //g.drawOval( (int)a.getx()-i_haba/2,(int)a.gety()-i_haba/2,i_haba,i_haba); //�~

                            g.setColor(Color.white);
                            g2.fill(new Ellipse2D.Double(b.getx() - d_haba, b.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                            //g.fillOval( (int)b.getx()-i_haba/2,(int)b.gety()-i_haba/2,i_haba,i_haba); //�~

                            g.setColor(Color.black);
                            g2.draw(new Ellipse2D.Double(b.getx() - d_haba, b.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                            //g.drawOval( (int)b.getx()-i_haba/2,(int)b.gety()-i_haba/2,i_haba,i_haba); //�~
                        }
                    }
                }
            }

        }

        //System.out.println(" E 20170201_6");

        //�W�J?}�̕`��  ��?��???�ȊO��?�??
        if (i_cp_hyouji == 1) {

            g.setColor(Color.black);

            float[] dash_M1 = {10.0f, 3.0f, 3.0f, 3.0f};//��_?�??
            float[] dash_M2 = {10.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f};//��_?�??
            float[] dash_V = {8.0f, 8.0f};//�j??

            g.setColor(Color.black);
            for (int i = 1; i <= ori_s.getsousuu(); i++) {
                if (ori_s.getcolor(i) != 3) {
                    if (i_orisen_hyougen == 1) {
                        g_setColor(g, ori_s.getcolor(i));
                        g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//��{�w��A?@?@??�̑�����??�̖��[�̌`??
                    }

                    if (i_orisen_hyougen == 2) {
                        g_setColor(g, ori_s.getcolor(i));
                        if (ori_s.getcolor(i) == 0) {
                            g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
                        }//��{�w��A?@?@??�̑�����??�̖��[�̌`??
                        if (ori_s.getcolor(i) == 1) {
                            g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash_M1, 0.0f));
                        }//��_?�??//??�̑�����??�̖��[�̌`??
                        if (ori_s.getcolor(i) == 2) {
                            g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash_V, 0.0f));
                        }//�j??//??�̑�����??�̖��[�̌`??
                    }

                    if (i_orisen_hyougen == 3) {
                        if (ori_s.getcolor(i) == 0) {
                            g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
                        }//��{�w��A?@?@??�̑�����??�̖��[�̌`??
                        if (ori_s.getcolor(i) == 1) {
                            g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash_M1, 0.0f));
                        }//��_?�??//??�̑�����??�̖��[�̌`??
                        if (ori_s.getcolor(i) == 2) {
                            g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash_V, 0.0f));
                        }//�j??//??�̑�����??�̖��[�̌`??
                    }

                    if (i_orisen_hyougen == 4) {
                        if (ori_s.getcolor(i) == 0) {
                            g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
                        }//��{�w��A?@?@??�̑�����??�̖��[�̌`??
                        if (ori_s.getcolor(i) == 1) {
                            g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash_M2, 0.0f));
                        }//��_?�??//??�̑�����??�̖��[�̌`??
                        if (ori_s.getcolor(i) == 2) {
                            g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash_V, 0.0f));
                        }//�j??//??�̑�����??�̖��[�̌`??
                    }


                    s_tv.set(camera.object2TV(ori_s.get(i)));
                    //a.set(s_tv.geta()); b.set(s_tv.getb());
                    a.set(s_tv.getax() + 0.000001, s_tv.getay() + 0.000001);
                    b.set(s_tv.getbx() + 0.000001, s_tv.getby() + 0.000001);//�Ȃ�0.000001�𑫂����Ƃ�����,�f�B�X�v���C�ɕ`�悷��Ƃ�����?�??��?V����?�??�ɉe������ē����Ă��܂��̂�h������


                    g.drawLine((int) a.getx(), (int) a.gety(), (int) b.getx(), (int) b.gety()); //��??


                    if (fTenkaizuSenhaba < 2.0f) {//���_��?���?����`��`��
                        g.setColor(Color.black);
                        //int i_haba=1;
                        int i_haba = ir_ten;
                        g.fillRect((int) a.getx() - i_haba, (int) a.gety() - i_haba, 2 * i_haba + 1, 2 * i_haba + 1); //?����`��`��//g.fillRect(10, 10, 100, 50);�����`��`��
                        g.fillRect((int) b.getx() - i_haba, (int) b.gety() - i_haba, 2 * i_haba + 1, 2 * i_haba + 1); //?����`��`��
                    }


                    if (fTenkaizuSenhaba >= 2.0f) {//  ��??
                        g2.setStroke(new BasicStroke(1.0f + fTenkaizuSenhaba % 1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//??�̑�����??�̖��[�̌`???A�����ł�?�??�̒[�_��??�̌`?�̎w��
                        if (ir_ten != 0) {
                            int i_haba = (int) fTenkaizuSenhaba + ir_ten;//int i_haba=2;
                            double d_haba = (double) fTenkaizuSenhaba / 2.0 + (double) ir_ten;//int i_haba=2;


                            g.setColor(Color.white);
                            g2.fill(new Ellipse2D.Double(a.getx() - d_haba, a.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                            //g.fillOval( (int)a.getx()-i_haba/2,(int)a.gety()-i_haba/2,i_haba,i_haba); //�~


                            g.setColor(Color.black);
                            g2.draw(new Ellipse2D.Double(a.getx() - d_haba, a.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                            //g.drawOval( (int)a.getx()-i_haba/2,(int)a.gety()-i_haba/2,i_haba,i_haba); //�~

                            g.setColor(Color.white);
                            g2.fill(new Ellipse2D.Double(b.getx() - d_haba, b.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                            //g.fillOval( (int)b.getx()-i_haba/2,(int)b.gety()-i_haba/2,i_haba,i_haba); //�~

                            g.setColor(Color.black);
                            g2.draw(new Ellipse2D.Double(b.getx() - d_haba, b.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
                            //g.drawOval( (int)b.getx()-i_haba/2,(int)b.gety()-i_haba/2,i_haba,i_haba); //�~
                        }

                    }
                }
            }
        }

        //i_mouse_modeA==61//�����`���I��?ipaint�̑I���Ɏ������I���@�\?j�̎��Ɏg��
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
            s_step[2].set(p2, p3); //��??
            s_step[3].set(p3, p4); //?c??
            s_step[4].set(p4, p1); //��??

            s_step[1].setcolor(6);
            s_step[2].setcolor(6);
            s_step[3].setcolor(6);
            s_step[4].setcolor(6);
        }

        //??�����͎��̈ꎞ�I��s_step??����`��?@

        if ((orihime_ap.i_mouse_modeA == 61) && (i_egaki_dankai != 4)) {
        } else {
            for (int i = 1; i <= i_egaki_dankai; i++) {
                g_setColor(g, s_step[i].getcolor());
                g2.setStroke(new BasicStroke(fTenkaizuSenhaba, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//��{�w��A?@?@??�̑�����??�̖��[�̌`??

                s_tv.set(camera.object2TV(s_step[i]));
                //a.set(s_tv.geta()); b.set(s_tv.getb());
                a.set(s_tv.getax() + 0.000001, s_tv.getay() + 0.000001);
                b.set(s_tv.getbx() + 0.000001, s_tv.getby() + 0.000001);//�Ȃ�0.000001�𑫂����Ƃ�����,�f�B�X�v���C�ɕ`�悷��Ƃ�����?�??��?V����?�??�ɉe������ē����Ă��܂��̂�h������


                g.drawLine((int) a.getx(), (int) a.gety(), (int) b.getx(), (int) b.gety()); //��??
                int i_haba_nyuiiryokuji = 3;
                if (i_kou_mitudo_nyuuryoku == 1) {
                    i_haba_nyuiiryokuji = 2;
                }

                if (s_step[i].getiactive() == 1) {
                    g.fillOval((int) a.getx() - i_haba_nyuiiryokuji, (int) a.gety() - i_haba_nyuiiryokuji, 2 * i_haba_nyuiiryokuji, 2 * i_haba_nyuiiryokuji); //�~
                    //g.fillOval( (int)b.getx()-i_haba_nyuiiryokuji,(int)b.gety()-i_haba_nyuiiryokuji,2*i_haba_nyuiiryokuji,2*i_haba_nyuiiryokuji); //�~
                }
                if (s_step[i].getiactive() == 2) {
                    //g.fillOval( (int)a.getx()-i_haba_nyuiiryokuji,(int)a.gety()-i_haba_nyuiiryokuji,2*i_haba_nyuiiryokuji,2*i_haba_nyuiiryokuji); //�~
                    g.fillOval((int) b.getx() - i_haba_nyuiiryokuji, (int) b.gety() - i_haba_nyuiiryokuji, 2 * i_haba_nyuiiryokuji, 2 * i_haba_nyuiiryokuji); //�~
                }
                if (s_step[i].getiactive() == 3) {
                    g.fillOval((int) a.getx() - i_haba_nyuiiryokuji, (int) a.gety() - i_haba_nyuiiryokuji, 2 * i_haba_nyuiiryokuji, 2 * i_haba_nyuiiryokuji); //�~
                    g.fillOval((int) b.getx() - i_haba_nyuiiryokuji, (int) b.gety() - i_haba_nyuiiryokuji, 2 * i_haba_nyuiiryokuji, 2 * i_haba_nyuiiryokuji); //�~
                }


                //g.fillOval( (int)b.getx()-i_haba,(int)b.gety()-i_haba,2*i_haba,2*i_haba); //�~
            }
        }
        //�����͎��̌���`��//System.out.println("_");
        //g2.setStroke(new BasicStroke(fTenkaizuSenhaba+1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//��{�w��A
        g2.setStroke(new BasicStroke(fTenkaizuSenhaba + 0.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));//��{�w��A


        for (int i = 1; i <= i_kouho_dankai; i++) {
            g_setColor(g, s_kouho[i].getcolor());

            s_tv.set(camera.object2TV(s_kouho[i]));
            //a.set(s_tv.geta()); b.set(s_tv.getb());
            a.set(s_tv.getax() + 0.000001, s_tv.getay() + 0.000001);
            b.set(s_tv.getbx() + 0.000001, s_tv.getby() + 0.000001);//�Ȃ�0.000001�𑫂����Ƃ�����,�f�B�X�v���C�ɕ`�悷��Ƃ�����?�??��?V����?�??�ɉe������ē����Ă��܂��̂�h������

            g.drawLine((int) a.getx(), (int) a.gety(), (int) b.getx(), (int) b.gety()); //��??
            //int i_haba=ir_ten   +1;
            int i_haba = ir_ten + 5;
            //g.fillRect( (int)a.getx()-i_haba,(int)a.gety()-i_haba,2*i_haba+1,2*i_haba+1); //?����`��`��//g.fillRect(10, 10, 100, 50);�����`��`��
            //g.fillRect( (int)b.getx()-i_haba,(int)b.gety()-i_haba,2*i_haba+1,2*i_haba+1); //?����`��`��

            if (s_kouho[i].getiactive() == 1) {
                //g.fillRect( (int)a.getx()-i_haba,(int)a.gety()-i_haba,2*i_haba+1,2*i_haba+1); //?����`��`��//g.fillRect(10, 10, 100, 50);�����`��`��
                g.drawLine((int) a.getx() - i_haba, (int) a.gety(), (int) a.getx() + i_haba, (int) a.gety()); //��??
                g.drawLine((int) a.getx(), (int) a.gety() - i_haba, (int) a.getx(), (int) a.gety() + i_haba); //��??

            }
            if (s_kouho[i].getiactive() == 2) {
                //g.fillRect( (int)b.getx()-i_haba,(int)b.gety()-i_haba,2*i_haba+1,2*i_haba+1); //?����`��`��
                g.drawLine((int) b.getx() - i_haba, (int) b.gety(), (int) b.getx() + i_haba, (int) b.gety()); //��??
                g.drawLine((int) b.getx(), (int) b.gety() - i_haba, (int) b.getx(), (int) b.gety() + i_haba); //��??


            }
            if (s_kouho[i].getiactive() == 3) {
                //g.fillRect( (int)a.getx()-i_haba,(int)a.gety()-i_haba,2*i_haba+1,2*i_haba+1); //?����`��`��//g.fillRect(10, 10, 100, 50);�����`��`��
                //g.fillRect( (int)b.getx()-i_haba,(int)b.gety()-i_haba,2*i_haba+1,2*i_haba+1); //?����`��`��
                g.drawLine((int) a.getx() - i_haba, (int) a.gety(), (int) a.getx() + i_haba, (int) a.gety()); //��??
                g.drawLine((int) a.getx(), (int) a.gety() - i_haba, (int) a.getx(), (int) a.gety() + i_haba); //��??
                g.drawLine((int) b.getx() - i_haba, (int) b.gety(), (int) b.getx() + i_haba, (int) b.gety()); //��??
                g.drawLine((int) b.getx(), (int) b.gety() - i_haba, (int) b.getx(), (int) b.gety() + i_haba); //��??


            }
        }

        g.setColor(Color.black);

        //�~���͎��̈ꎞ�I��??����`��?@
        //g.setColor(Color.cyan);
        for (int i = 1; i <= i_en_egaki_dankai; i++) {
            g_setColor(g, e_step[i].getcolor());
            a.set(camera.object2TV(e_step[i].get_tyuusin()));//����???���s_tv�͕`��?��W�n�ł̉~�̒�?S�̈ʒu
            //a.set(s_tv.geta()); b.set(s_tv.getb());
            a.set(a.getx() + 0.000001, a.gety() + 0.000001);//�Ȃ�0.000001�𑫂����Ƃ�����,�f�B�X�v���C�ɕ`�悷��Ƃ�����?�??��?V����?�??�ɉe������ē����Ă��܂��̂�h������

            //g.drawLine( (int)a.getx(),(int)a.gety(),(int)b.getx(),(int)b.gety()); //��??
            double d_haba = e_step[i].getr() * camera.get_camera_bairitsu_x();//d_haba�͕`�掞�̉~�̔��a?B�Ȃ�?Acamera.get_camera_bairitsu_x()??camera.get_camera_bairitsu_y()��O��Ƃ��Ă���?B

            //g2.fill(new Ellipse2D.Double(a.getx()-d_haba, a.gety()-d_haba, 2.0*d_haba,2.0*d_haba));
            g2.draw(new Ellipse2D.Double(a.getx() - d_haba, a.gety() - d_haba, 2.0 * d_haba, 2.0 * d_haba));
            //g.drawOval( (int)a.getx()-i_haba/2,(int)a.gety()-i_haba/2,i_haba,i_haba); //�~
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

		Color.black       ?���\���܂�
		Color.blue        ?�\���܂�
		Color.cyan        �V�A����\���܂�
		Color.darkGray    �_?[�N�O���C��\���܂�
		Color.gray        �O���C��\���܂�
		Color.green       �΂�\���܂�
		Color.lightGray   ���C�g�O���C��\���܂�
		Color.magenta     �}�[���^��\���܂�
		Color.orange      �I�����W��\���܂�
		Color.pink        �s���N��\���܂�
		Color.red         ?Ԃ�\���܂�
		Color.white       ����\���܂�
		Color.yellow      ����\���܂�
*/

        //icol=0 black
        //icol=1 red
        //icol=2 blue
        //icol=3 cyan
        //icol=4 orange
        //icol=5 mazenta
        //icol=6 green
        //icol=7 yellow
        //icol=8 new Color(210,0,255) //��

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
        //g.setColor(new Color(100, 200,200));����?F�͕�????�p�Ɏg����������������
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
    public int addsenbun(Senbun s0) {//0=��?X�Ȃ�?A1=?F�̕ω��̂�?A2=??���ǉ�

        ori_s.addsenbun(s0);//ori_s��senbun��?Ō��s0��?�����������邾��
        int sousuu_old = ori_s.getsousuu();
        ori_s.Senbun_en_kouten(ori_s.getsousuu(), ori_s.getsousuu(), 1, ori_s.cir_size());

        ori_s.kousabunkatu(1, sousuu_old - 1, sousuu_old, sousuu_old);

        return 1;
    }

    //------------------------------------------------------
    public Ten get_moyori_ten_orisen_en(Ten t0) {//
        //�p��1/1������ 		?�??�̒[�_�݂̂���??�_?B�i�q�_����??�_�ɂȂ邱�Ƃ͂Ȃ�?B
        //�p��1/2����1/512������	?�??�̒[�_�Ɨp���g��?i-200.0,-200.0 _ 200.0,200.0)?j�̊i�q�_�Ƃ���??�_
        Ten t1 = new Ten(); //?�??�̒[�_

        Ten t3 = new Ten(); //�~�̒�?S

        t1.set(ori_s.mottomo_tikai_Ten(t0));//ori_s.mottomo_tikai_Ten_sagasi�͋߂��_���Ȃ��� p_return.set(100000.0,100000.0)�ƕԂ��Ă���

        t3.set(ori_s.mottomo_tikai_Tyuusin(t0));//ori_s.mottomo_tikai_Ten_sagasi�͋߂��_���Ȃ��� p_return.set(100000.0,100000.0)�ƕԂ��Ă���
        if (t0.kyori2jyou(t1) > t0.kyori2jyou(t3)) {
            t1.set(t3);
        }


        //if(kus.jyoutai()==0){return t1;}


        //if( t0.kyori2jyou(t1)>  t0.kyori2jyou(kus.moyori_kousi_ten(t0)) ){return kus.moyori_kousi_ten(t0);}
        return t1;
    }

//------------------------------


    public Ten get_moyori_ten(Ten t0) {
        //�p��1/1������ 		?�??�̒[�_�݂̂���??�_?B�i�q�_����??�_�ɂȂ邱�Ƃ͂Ȃ�?B
        //�p��1/2����1/512������	?�??�̒[�_�Ɨp���g��?i-200.0,-200.0 _ 200.0,200.0)?j�̊i�q�_�Ƃ���??�_
        Ten t1 = new Ten(); //?�??�̒[�_

        Ten t3 = new Ten(); //�~�̒�?S

        t1.set(ori_s.mottomo_tikai_Ten(t0));//ori_s.mottomo_tikai_Ten_sagasi�͋߂��_���Ȃ��� p_return.set(100000.0,100000.0)�ƕԂ��Ă���

        t3.set(ori_s.mottomo_tikai_Tyuusin(t0));//ori_s.mottomo_tikai_Ten_sagasi�͋߂��_���Ȃ��� p_return.set(100000.0,100000.0)�ƕԂ��Ă���
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
            }//���̕����ɋ߂����ǂ���

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
            }//�~���ɋ߂����ǂ���
        }
        return e_step[minrid];
    }


    public void set_s_step_iactive(int ia) {

        for (int i = 0; i < 1024; i++) {
            s_step[i].setiactive(ia);
        }


    }

//--------------------------------------------------------------------------------------
//�}�E�X��??----------------------------------------------------------------------------
//--------------------------------------------------------------------------------------
//	Ten p =new Ten();

    //��??���f��001--------------------------------------------------------------------------------------------------------
    //�}�E�X��??(�}�E�X�𓮂������Ƃ�)��?s����??
    public void mMoved_m_001(Ten p0, int i_c) {//�}�E�X�őI���ł�����_��\������?B�߂��Ɋ�?��̓_������Ƃ��͂��̓_�����_�ƂȂ�?B�߂��Ɋ�?��̓_�������Ƃ��͌��_�����Ȃ̂Ō��_�̕\��������?B
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


    //��??���f��002--------------------------------------------------------------------------------------------------------
    //�}�E�X��??(�}�E�X�𓮂������Ƃ�)��?s����??
    public void mMoved_m_002(Ten p0, int i_c) {//�}�E�X�őI���ł�����_��\������?B�߂��Ɋ�?��̓_������Ƃ��͂��̓_?A�����Ƃ��̓}�E�X�̈ʒu��?g�����_�ƂȂ�?B
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


    //��??���f��00a--------------------------------------------------------------------------------------------------------
    //�}�E�X�N���b�N?i�}�E�X�̋߂��̊�?��_��I��?j?A�}�E�X�h���b�O?i�I�������_�ƃ}�E�X�Ԃ�??���\�������?j?A�}�E�X����?[�X?i�}�E�X�̋߂��̊�?��_��I��?j���Ă���ړI��????������?��`�Z�b�g

    //�}�E�X�𓮂������Ƃ�----------------------------------------------
    public void mMoved_m_00a(Ten p0, int i_c) {
        mMoved_m_001(p0, i_c);
    }//�߂������_�̂ݕ\��

    //�}�E�X�N���b�N----------------------------------------------------
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

    //�}�E�X�h���b�O---------------------------------------------------
    public void mDragged_m_00a(Ten p0, int i_c) {  //�߂������_�̂ݕ\��

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

    //�}�E�X����?[�X--------------------------------------------------
    public void mReleased_m_00a(Ten p0) {
        if (i_egaki_dankai == 1) {
            i_egaki_dankai = 0;

            p.set(camera.TV2object(p0));
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) <= d_hantei_haba) {
                s_step[1].seta(moyori_ten);
                if (s_step[1].getnagasa() > 0.00000001) {
                    //��肽����??�͂�����?���
                    //addsenbun(s_step[1]);
                    //kiroku();
                }
            }
        }
    }


    //��??���f��00b--------------------------------------------------------------------------------------------------------
    //�}�E�X�N���b�N?i�߂��̊�?��_���}�E�X�ʒu��I��?j?A�}�E�X�h���b�O?i�I�������_�ƃ}�E�X�Ԃ�??���\�������?j?A�}�E�X����?[�X?i�߂��̊�?��_���}�E�X�ʒu��I��?j���Ă���ړI��????������?��`�Z�b�g

    //�}�E�X�𓮂������Ƃ�----------------------------------------------
    public void mMoved_m_00b(Ten p0, int i_c) {
        mMoved_m_002(p0, i_c);
    }//�߂��̊�?��_���}�E�X�ʒu�\��

    //�}�E�X�N���b�N----------------------------------------------------
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

    //�}�E�X�h���b�O---------------------------------------------------
    public void mDragged_m_00b(Ten p0, int i_c) {  //�߂��̊�?��_���}�E�X�ʒu�\��

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

    //�}�E�X����?[�X--------------------------------------------------
    public void mReleased_m_00b(Ten p0) {
        i_egaki_dankai = 0;
        p.set(camera.TV2object(p0));
        s_step[1].seta(p);
        moyori_ten.set(get_moyori_ten(p));
        if (p.kyori(moyori_ten) <= d_hantei_haba) {
            s_step[1].seta(moyori_ten);
        }
        if (s_step[1].getnagasa() > 0.00000001) {
            //��肽����??�͂�����?���

        }
    }


//--------------------------------------------
//28 28 28 28 28 28 28 28  i_mouse_modeA==28??����������
    //��??�T�v
    //i_mouse_modeA==1��??�������ȊO�͓���

    //�}�E�X��??(�}�E�X�𓮂������Ƃ�)��?s����??
    public void mMoved_A_28(Ten p0) {
        mMoved_m_00a(p0, icol);//�}�E�X�őI���ł�����_��\������?B�߂��Ɋ�?��̓_������Ƃ��͂��̓_?A�����Ƃ��̓}�E�X�̈ʒu��?g�����_�ƂȂ�?B

    }

    //�}�E�X��??(i_mouse_modeA==28??���������� �Ń{�^�����������Ƃ�)����??��----------------------------------------------------
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

    //�}�E�X��??(i_mouse_modeA==28??������ �Ńh���b�O�����Ƃ�)��?s����??----------------------------------------------------
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

    //�}�E�X��??(i_mouse_modeA==28??������?@�Ń{�^���𗣂����Ƃ�)��?s����??----------------------------------------------------
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


//1 1 1 1 1 1 01 01 01 01 01 11111111111 i_mouse_modeA==1??������ 111111111111111111111111111111111
    //��??�T�v?@
    //�}�E�X�{�^�������ꂽ�Ƃ�?@
    //�p��1/1������ 		?�??�̒[�_�݂̂���??�_?B�i�q�_����??�_�ɂȂ邱�Ƃ͂Ȃ�?B
    //�p��1/2����1/512������	?�??�̒[�_�Ɨp���g��?i-200.0,-200.0 _ 200.0,200.0)?j�̊i�q�_�Ƃ���??�_
    //���͓_P����??�_����i�q??kus.d_haba()��1/4��艓���Ƃ���?�???W?��ւ̓��͂Ȃ�
    //??�����������Ȃ�1�_?�̂Ƃ���?�???W?��ւ̓��͂Ȃ�

    //�}�E�X��??(�}�E�X�𓮂������Ƃ�)��?s����??
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

    //�}�E�X��??(i_mouse_modeA==1??������?@�Ń{�^�����������Ƃ�)����??��----------------------------------------------------
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

    //�}�E�X��??(i_mouse_modeA==1??������?@�Ńh���b�O�����Ƃ�)��?s����??----------------------------------------------------
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


    //�}�E�X��??(i_mouse_modeA==1??������?@�Ń{�^���𗣂����Ƃ�)��?s����??----------------------------------------------------
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
    //�}�E�X��??(�}�E�X�𓮂������Ƃ�)��?s����??
    public void mMoved_A_11(Ten p0) {
        mMoved_m_00a(p0, icol);
    }//�߂������_�̂ݕ\��

    //�}�E�X��??(i_mouse_modeA==11??������?@�Ń{�^�����������Ƃ�)����??��----------------------------------------------------
    public void mPressed_A_11(Ten p0) {
        mPressed_m_00a(p0, icol);
    }

    //�}�E�X��??(i_mouse_modeA==11??������?@�Ńh���b�O�����Ƃ�)��?s����??----------------------------------------------------
    public void mDragged_A_11(Ten p0) {
        mDragged_m_00a(p0, icol);
    }//�߂������_�̂ݕ\��

    //�}�E�X��??(i_mouse_modeA==11??������?@�Ń{�^���𗣂����Ƃ�)��?s����??----------------------------------------------------
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


//62 62 62 62 62 i_mouse_modeA==62 �{??�m�C?@ Voronoi 111111111111111111111111111111111


    ArrayList Senb_boro_1p = new ArrayList(); //�{??�m�C?}�̈�_�̎����??��

// ------------------------------------------


    //�}�E�X��??(i_mouse_modeA==62�{??�m�C?@�}�E�X�𓮂������Ƃ�)��?s����??
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


//int s_step_no_saisyo_no_sen_no_bangou() {//s_step[i]��?�?���???i�������O�łȂ�?j���łĂ����??��Ԃ�?B???i�������O�łȂ�?j���Ȃ�???���0��Ԃ�
//		for (int i=1; i<=i_egaki_dankai; i++ ){if(s_step[i].getnagasa()>0.00000001){return i;}
//return 0;
//}


    // ------------------------------------------------------------------------------------------------------------
    int s_step_no_1_kara_rennzoku_no_ten_no_bangou() {//s_step[i]��?�?�����A����Ten?i�������O?j�����Ԗڂ܂łłĂ��邩��??��Ԃ�?B�_���Ȃ�???���0��Ԃ�
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
    int i_mouse_modeA_62_ten_kasanari;//?V���ɉ�����p��?��܂łɉ�����Ten��?d�Ȃ��Ă��Ȃ�=0?A?d�Ȃ��Ă���=1

    //�}�E�X��??(i_mouse_modeA==62�{??�m�C?@�Ń{�^�����������Ƃ�)����??��----------------------------------------------------
    public void mPressed_A_62(Ten p0) {
        p.set(camera.TV2object(p0));

        //i_egaki_dankai��?]���̃{??�m�C��_�����ɂȂ�悤��?�??(�܂�?A�_p��s_step�Ƃ��ă{??�m�C��_�ɉ����邩�ǂ����͌��߂Ă��Ȃ�)
        i_egaki_dankai = s_step_no_1_kara_rennzoku_no_ten_no_bangou();//Ten��??


        //���[��?V���ɉ�����p��?Ŋ�_����Ȃ�_?��??��s_temp��??�߂�?i?Ŋ�_���Ȃ�???���s_temp�̗��[��p?j
        Senbun s_temp = new Senbun();
        moyori_ten.set(get_moyori_ten(p));
        if (p.kyori(moyori_ten) < d_hantei_haba) {
            s_temp.set(moyori_ten, moyori_ten);
            s_temp.setcolor(5);
        } else {
            s_temp.set(p, p);
            s_temp.setcolor(5);
        }


        //?V���ɉ�����p��?��܂łɉ�����Ten��?d�Ȃ��Ă��Ȃ����Ƃ��m�F
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


        //?V���ɉ�����p��?��܂łɉ�����Ten��?d�Ȃ��Ă��Ȃ����Ƃ��m�F �����܂�

        if (i_mouse_modeA_62_ten_kasanari == 0) {
            //oc.hyouji("?@");
            //oc.hyouji("?V�����{??�m�C��_��������?@�J�n?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[");

            //�P��?V�����{??�m�C��_��������(�����ł����?A�_p��s_step�Ƃ��ă{??�m�C��_�ɉ�����ƌ��܂���)
            i_egaki_dankai = i_egaki_dankai + 1;
            s_step[i_egaki_dankai].set(s_temp);
            s_step[i_egaki_dankai].setiactive(3);//iactive=3��??�͗��[�ɉ~���`�����?Biactive=1��??��a�[�݂̂ɉ~���`�����?Biactive=2��??��b�[�݂̂ɉ~���`�����

            //?��܂ł̃{??�m�C?}������?A�P��?V�����{??�m�C��_���������{??�m�C?}��??��--------------------------------------
            //System.out.println("---------------------------");
            //System.out.println("voronoi_() start");

            //voronoi_01();//�ᑬ?A�G��?[�͂قƂ�ǂȂ��͂�
            voronoi_02();//?���?A���������ăG��?[�c���Ă��邩��

            //System.out.println("voronoi_() stop");


        } else if (i_mouse_modeA_62_ten_kasanari != 0) {//?��Ԃ�i_mouse_modeA_62_ten_kasanari�̃{??�m�C��_��????
            //oc.hyouji("?@");
            //oc.hyouji("�{??�m�C��_��?????@�J�n?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[?[");

            //?��Ԃ�i_mouse_modeA_62_ten_kasanari�̃{??�m�C��_��?��Ԃ�?Ō�(=i_egaki_dankai)�̃{??�m�C��_�����ւ���
            //s_step[i]�̓���ւ�
            Senbun S_irekae = new Senbun();
            S_irekae.set(s_step[i_mouse_modeA_62_ten_kasanari]);
            s_step[i_mouse_modeA_62_ten_kasanari].set(s_step[i_egaki_dankai]);
            s_step[i_egaki_dankai].set(S_irekae);


            for (int j = 1; j <= ori_v.getsousuu(); j++) {
                //ori_v����??����iactive�̓���ւ�
                if (ori_v.getiactive(j) == i_mouse_modeA_62_ten_kasanari) {
                    ori_v.setiactive(j, i_egaki_dankai);
                } else if (ori_v.getiactive(j) == i_egaki_dankai) {
                    ori_v.setiactive(j, i_mouse_modeA_62_ten_kasanari);
                }

                //ori_v����??����icol�̓���ւ�
                if (ori_v.getcolor(j) == i_mouse_modeA_62_ten_kasanari) {
                    ori_v.setcolor(j, i_egaki_dankai);
                } else if (ori_v.getcolor(j) == i_egaki_dankai) {
                    ori_v.setcolor(j, i_mouse_modeA_62_ten_kasanari);
                }
            }


            //?��Ԃ�?Ō�(=i_egaki_dankai)�̂̃{??�m�C��_��????

            i_egaki_dankai = i_egaki_dankai - 1;

            Orisensyuugou ori_v_temp = new Orisensyuugou();    //?C?��p�̃{??�m�C?}��??���i�[����

            //ori_v��??����?�?��ɑS�Ĕ�I���ɂ���
            ori_v.unselect_all();

            //i_egaki_dankai+1�̃{??�m�C��_����̃{??�m�C??����I��?�Ԃɂ���
            Senbun s_tem = new Senbun();
            Senbun s_tem2 = new Senbun();
            for (int j = 1; j <= ori_v.getsousuu(); j++) {
                s_tem.set(ori_v.get(j));//s_tem�Ƃ��ă{??�m�C��_����̃{??�m�C??��������
                if (s_tem.getiactive() == i_egaki_dankai + 1) {//�{??�m�C??����2�̃{??�m�C���_��iactive��color�ɋL�^����Ă���
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


                    //???������i_egaki_dankai+1�Ԗڂ̃{??�m�C��_�Ƒg�ɂȂ�?A������̃{??�m�C��_�����͂ރ{??�m�C??���̃A���C���X�g�𓾂�?B
                    Senb_boro_1p_motome(s_tem.getcolor());

                    for (int i = 0; i < Senb_boro_1p.size(); i++) {
                        Senbun add_S = new Senbun();
                        add_S.set((Senbun) Senb_boro_1p.get(i));
                        Senbun add_S2 = new Senbun();


                        //ori_v_temp��add_S��ǉ����邩�ǂ����̎��O�`�F�b�N
                        int i_tuika = 1;//1�Ȃ�ǉ�����?B0�Ȃ�ǉ����Ȃ�?B
                        for (int h = 1; h <= ori_v_temp.getsousuu(); h++) {
                            add_S2.set(ori_v_temp.get(h));
                            if ((add_S.getcolor() == add_S2.getcolor()) && (add_S.getiactive() == add_S2.getiactive())) {
                                i_tuika = 0;
                            }
                            if ((add_S.getcolor() == add_S2.getiactive()) && (add_S.getiactive() == add_S2.getcolor())) {
                                i_tuika = 0;
                            }
                        }
                        //ori_v_temp��add_S��ǉ����邩�ǂ����̎��O�`�F�b�N�͂����܂�

                        if (i_tuika == 1) {
                            ori_v_temp.addsenbun((Senbun) Senb_boro_1p.get(i));
                        }
                    }
                } else if (s_tem.getcolor() == i_egaki_dankai + 1) {//�{??�m�C??����2�̃{??�m�C���_��iactive��color�ɋL�^����Ă���
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

                    //???������i_egaki_dankai+1�Ԗڂ̃{??�m�C��_�Ƒg�ɂȂ�?A������̃{??�m�C��_�����͂ރ{??�m�C??���̃A���C���X�g�𓾂�?B
                    Senb_boro_1p_motome(s_tem.getiactive());

                    for (int i = 0; i < Senb_boro_1p.size(); i++) {
                        Senbun add_S = new Senbun();
                        add_S.set((Senbun) Senb_boro_1p.get(i));
                        Senbun add_S2 = new Senbun();

                        //ori_v_temp��add_S��ǉ����邩�ǂ����̎��O�`�F�b�N
                        int i_tuika = 1;//1�Ȃ�ǉ�����?B0�Ȃ�ǉ����Ȃ�?B
                        for (int h = 1; h <= ori_v_temp.getsousuu(); h++) {
                            add_S2.set(ori_v_temp.get(h));
                            if ((add_S.getcolor() == add_S2.getcolor()) && (add_S.getiactive() == add_S2.getiactive())) {
                                i_tuika = 0;
                            }
                            if ((add_S.getcolor() == add_S2.getiactive()) && (add_S.getiactive() == add_S2.getcolor())) {
                                i_tuika = 0;
                            }
                        }
                        //ori_v_temp��add_S��ǉ����邩�ǂ����̎��O�`�F�b�N�͂����܂�

                        if (i_tuika == 1) {
                            ori_v_temp.addsenbun((Senbun) Senb_boro_1p.get(i));
                        }
                    }


                }

            }
            //�I��?�Ԃ̂��̂�????
            ori_v.del_selected_senbun_hayai();
            ori_v.del_V_all(); //����?s�͂���Ȃ�����

            //ori_v_temp�̃{??�m�C??�����{??�m�C��_�ɉ�����
            //ori_v_temp.hyouji("ori_v_temp---------------------");
            for (int j = 1; j <= ori_v_temp.getsousuu(); j++) {
                Senbun s_t = new Senbun();
                s_t.set(ori_v_temp.get(j));
                //s_t.hyouji("  s_t  ");
                //addsenbun_voronoi(s_t);//addsenbun_voronoi�͌�?����������Ă���?B��?�������iactive���g���̂�?Aiactive��ʓr�����ɓ]�p������?[�`���ł͌�?��������g�p�ł��Ȃ��̂�addsenbun_voronoi���g�p�ł��Ȃ�
                ori_v.addsenbun(s_t);
            }


            ori_v.del_V_all();

        }


        //�{??�m�C?}���\������悤��s_step�̌�Ƀ{??�m�C?}��??������

        int imax = ori_v.getsousuu();
        if (imax > 1020) {
            imax = 1020;
        }

        //System.out.println("�{??�m�C?}���\������悤��s_step�̌�Ƀ{??�m�C?}��??������O");
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
    public int addsenbun_voronoi(Senbun s0) {//0=��?X�Ȃ�?A1=?F�̕ω��̂�?A2=??���ǉ�

        ori_v.addsenbun(s0);//ori_v��senbun��?Ō��s0��?�����������邾��
        int sousuu_old = ori_v.getsousuu();
        ori_v.Senbun_en_kouten(ori_v.getsousuu(), ori_v.getsousuu(), 1, ori_v.cir_size());

        ori_v.kousabunkatu(1, sousuu_old - 1, sousuu_old, sousuu_old);

        return 1;
    }


    // -----------------------------------------------------------------------------
    //�}�E�X��??(i_mouse_modeA==62�{??�m�C?@�Ńh���b�O�����Ƃ�)��?s����??----------------------------------------------------
    public void mDragged_A_62(Ten p0) {
    }

    // -----------------------------------------------------------------------------
    //�}�E�X��??(i_mouse_modeA==62�{??�m�C?@�Ń{�^���𗣂����Ƃ�)��?s����??----------------------------------------------------
    public void mReleased_A_62(Ten p0) {
    }

    // ------------------------------------------
    public void voronoi_01() {//i=1����i_egaki_dankai�܂ł�s_step[i]��?Ai_egaki_dankai-1�܂ł̃{??�m�C?}����i_egaki_dankai�̃{??�m�C?}��???�

        //i_egaki_dankai�Ԗڂ̃{??�m�C���_�Ƃ���ȑO�̃{??�m�C���_�Ԃ�2����??��ori_v�ɒǉ�

        for (int i_e_d = 1; i_e_d <= i_egaki_dankai - 1; i_e_d++) {
            addsenbun_voronoi(oc.nitoubunsen(s_step[i_e_d].geta(), s_step[i_egaki_dankai].geta(), 1000.0)); //kiroku();
        }

        //�{??�m�C�ɓK?����邩����
        //ori_v��??����?�?��ɑS�Ĕ�I���ɂ���
        ori_v.unselect_all();


        //�{??�m�C�ɓK?����Ȃ����̂�I��?�Ԃɂ���
        Senbun s_tem = new Senbun();
        for (int j = 1; j <= ori_v.getsousuu(); j++) {

            //System.out.println("�{??�m�C j= "+j);
            s_tem.set(ori_v.get(j));//s_tem�Ƃ��ă{??�m�C�ɓK?����邩����

            //s_ten��a�[�ƃ{??�m�C�̊e���_�Ƃ̋�����?ŒZ�lv_min_a��??�߂�
            double v_min_a = 1000000.0;
            for (int i = 1; i <= i_egaki_dankai; i++) {
                if (oc.kyori(s_step[i].geta(), s_tem.geta()) < v_min_a) {
                    v_min_a = oc.kyori(s_step[i].geta(), s_tem.geta());
                }
            }
            //System.out.println("v_min_a= "+v_min_a);
            //s_ten��b�[�ƃ{??�m�C�̊e���_�Ƃ̋�����?ŒZ�lv_min_b��??�߂�
            double v_min_b = 1000000.0;
            for (int i = 1; i <= i_egaki_dankai; i++) {
                if (oc.kyori(s_step[i].geta(), s_tem.getb()) < v_min_b) {
                    v_min_b = oc.kyori(s_step[i].geta(), s_tem.getb());
                }
            }
            //System.out.println("v_min_b= "+v_min_b);


            int a_tomo_b_tomo_mottomo_tikai_voronoi_tyouten_no_kazu = 0;//a�Ƃ�b�Ƃ�?ł��߂��{??�m�C���_��???@���ꂪ�Q�Ȃ��?�??���̓{??�m�C?}�Ƃ��Ďc��
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


        //�I��?�Ԃ̂��̂�????
        ori_v.del_selected_senbun_hayai();

        ori_v.del_V_all(); //����?s�͂���Ȃ�����


    }


//------------------------------

    public void voronoi_02_01(int tyuusinn_ten_bangou, Senbun add_senbun) {
        //i_egaki_dankai�Ԗڂ̃{??�m�C���_��?@?@s_step[i_egaki_dankai].geta()?@?@?@

        //System.out.println("(0a)_add_senbun.getiactive()   = "+add_senbun.getiactive());
        //������??���ɂ���?�??
        //Senbun add_senbun =new Senbun();
        //add_senbun.set(oc.nitoubunsen(s_step[i_e_d].geta(),s_step[i_egaki_dankai].geta(),1000.0));
        Tyokusen add_tyokusen = new Tyokusen(add_senbun);


        int i_saisyo = Senb_boro_1p.size() - 1;
        for (int i = i_saisyo; i >= 0; i--) {
            //������??���ɂ���?�??
            Senbun kizon_senbun = new Senbun();
            kizon_senbun.set((Senbun) Senb_boro_1p.get(i));
            Tyokusen kizon_tyokusen = new Tyokusen(kizon_senbun);


            //������??���Ɗ�����??����?�������

//add_tyokusen.hyouji("     �r��?@add_tyokusen :");
//kizon_tyokusen.hyouji("     �r��?@kizon_tyokusen :");

            int i_heikou = oc.heikou_hantei(add_tyokusen, kizon_tyokusen, 0.0001);//0=��?s�łȂ�?A1=��?s�łQ��??����v���Ȃ�?A2=��?s�łQ��??����v����


            if (i_heikou == 0) {//������??���Ɗ�����??������?s��????
//System.out.println("     �r��_������??���Ɗ�����??������?s");
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


            } else if (i_heikou == 1) {//������??���Ɗ�����??������?s�łQ��??����v���Ȃ�????
//System.out.println("     �r��_������??���Ɗ�����??������?s�łQ��??����v���Ȃ�");
                if (add_tyokusen.onajigawa(s_step[tyuusinn_ten_bangou].geta(), kizon_senbun.geta()) == -1) {
                    Senb_boro_1p.remove(i);
                } else if (kizon_tyokusen.onajigawa(s_step[tyuusinn_ten_bangou].geta(), add_senbun.geta()) == -1) {
                    return;
                }


            } else if (i_heikou == 2) {//������??���Ɗ�����??������?s�łQ��??����v����????
//System.out.println("     �r��_������??���Ɗ�����??������?s�łQ��??����v����");
                return;
            }


            //if(add_tyokusen.senbun_kousa_hantei_kuwasii(senbun_b1p)==0){
            //if(add_tyokusen.senbun_kousa_hantei_kuwasii(new Senbun(s_step[i_egaki_dankai].geta(),senbun_b1p.geta()))==1){
            //	Senb_boro_1p.remove(i);
            //}
            //}


        }
        //System.out.println("  i_e_d="+i_e_d);
        //add_senbun.hyouji("voronoi_02_01_  add_senbun _?�?I");
        //System.out.println("(0b)_add_senbun.getiactive()   = "+add_senbun.getiactive());
        Senb_boro_1p.add(add_senbun);


    }


    // -----------------------------------------------

    public void Senb_boro_1p_motome(int tyuusinn_ten_bangou) {//s_step���{??�m�C��_�������܂�???��Ɏg����?Btyuusinn_ten_bangou�̎���̃{??�m�C??����?W?��Ƃ���Senb_boro_1p�𓾂�
        //i_egaki_dankai�Ԗڂ̃{??�m�C���_�����͂ރ{??�m�C??���̃A���C���X�g�𓾂�?B//i_egaki_dankai�Ԗڂ̃{??�m�C���_��?@?@s_step[i_egaki_dankai].geta()?@?@?@
        Senb_boro_1p.clear();

        //System.out.println("i_egaki_dankai="+i_egaki_dankai);

        for (int i_e_d = 1; i_e_d <= i_egaki_dankai; i_e_d++) {
            if (i_e_d != tyuusinn_ten_bangou) {

                //������??����??�߂�
                Senbun add_senbun = new Senbun();

                add_senbun.set(oc.nitoubunsen(s_step[i_e_d].geta(), s_step[tyuusinn_ten_bangou].geta(), 1000.0));

                if (i_e_d < tyuusinn_ten_bangou) {
                    add_senbun.setiactive(i_e_d);
                    add_senbun.setcolor(tyuusinn_ten_bangou);//�{??�m�C??����2�̃{??�m�C���_��iactive��color�ɋL�^����
                } else {
                    add_senbun.setiactive(tyuusinn_ten_bangou);
                    add_senbun.setcolor(i_e_d);//�{??�m�C??����2�̃{??�m�C���_��iactive��color�ɋL�^����
                }
                voronoi_02_01(tyuusinn_ten_bangou, add_senbun);

            }
        }


/*
		//�ł���Senb_boro_1p�̕\��
		oc.hyouji("-----�ł���Senb_boro_1p�̕\��-----");
		for (int i=0; i<Senb_boro_1p.size(); i++ ){
			Senbun tempS=new Senbun();tempS.set((Senbun)Senb_boro_1p.get(i));
			tempS.hyouji("   ");
		}
*/


    }

    // --------------------------------------------

    public void voronoi_02() {//i=1����i_egaki_dankai�܂ł�s_step[i]��?Ai_egaki_dankai-1�܂ł̃{??�m�C?}����i_egaki_dankai�̃{??�m�C?}��???�

        //i_egaki_dankai�Ԗڂ̃{??�m�C���_�����͂ރ{??�m�C??���̃A���C���X�g�𓾂�?B
        Senb_boro_1p_motome(i_egaki_dankai);

        //20181109������ori_v.�̊����̃{??�m�C??����?�??���K�v

        //ori_v��??����?�?��ɑS�Ĕ�I���ɂ���
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

                int i_mae = s_mae.getiactive();//����???�iactive�ɂ�?A���̃{??�m�C??�����������Ƃ��̊������̃{??�m�C��_�̔�??�������Ă���?B
                int i_ato = s_ato.getiactive();//����???�iactive�ɂ�?A���̃{??�m�C??�����������Ƃ��̊������̃{??�m�C��_�̔�??�������Ă���?B


                if (i_mae > i_ato) {
                    int i_temp = i_mae;
                    i_mae = i_ato;
                    i_ato = i_temp;
                }

                //System.out.println("(1) i_mae=" +i_mae +" :  i_ato=" +i_ato);

                //?V�����{??�m�C��_�������邱�Ƃłł�����͂̃{??�m�C??����??�܂��Ă���?B���̃{??�m�C??���̑��p�`��?V�Z���Ƃ������Ƃɂ���?B
                //?V�Z����ori_v�ɉ�����O��?A?V�Z���̓����ɓ���?���ł���ori_v�̊���??�����Ȃ��悤��????������?B

                //20181109������ori_v.�̊����̃{??�m�C??��(iactive()���K��icolor���?������Ȃ��Ă���)��T��
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


//20181110�����|�C���g
//
//	-1		0		1
//-1 	��������	��������	��_�܂�?k?�
// 0	��������	�L�蓾�Ȃ�	????
// 1	��_�܂�?k?�	????		????
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
        //�I��?�Ԃ̂��̂�????
        ori_v.del_selected_senbun_hayai();

        ori_v.del_V_all(); //����?s�͂���Ȃ�����
        //for (int i=1; i<=ori_v.getsousuu(); i++ ){System.out.println("    (2)  i= " + i +  ":  ori_v.get(i).getiactive()=  " +  ori_v.get(i).getiactive());}
        //


        //ori_v��senbun��?Ō��Senb_boro_1p��??��������������
        for (int i = 0; i < Senb_boro_1p.size(); i++) {
            Senbun add_S = new Senbun();
            add_S.set((Senbun) Senb_boro_1p.get(i));
            //System.out.println("  add_S.getiactive()=" +add_S.getiactive());
            ori_v.addsenbun((Senbun) Senb_boro_1p.get(i));
            //System.out.println("  ori_v.get(ori_v.getsousuu()).getiactive()=" +ori_v.get(ori_v.getsousuu()).getiactive());

        }


        //for (int i=1; i<=ori_v.getsousuu(); i++ ){System.out.println("    (3)  i= " + i +  ":  ori_v.get(i).getiactive()=  " +  ori_v.get(i).getiactive());}


    }


    //-----------------------------------------------62�����܂�?@//20181121?@iactive��tpp�ɒu��������


//5555555555555555555555    i_mouse_modeA==5?@;??��������?[�h

    //�}�E�X��??(�}�E�X�𓮂������Ƃ�)��?s����??    //System.out.println("_");
    public void mMoved_A_05(Ten p0) {
        if (i_kou_mitudo_nyuuryoku == 10) {// ==10�Ƃ������Ƃ͎�?s���Ȃ��Ƃ�������
            s_kouho[1].setiactive(3);

            i_kouho_dankai = 0;
            //Ten p =new Ten();
            p.set(camera.TV2object(p0));

            moyori_senbun.set(get_moyori_senbun(p));
            if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {//?Ŋ�̊���?�??���߂�????
                i_kouho_dankai = 1;
                s_kouho[1].set(moyori_senbun);
                //s_kouho[1].setcolor(8);

                return;
            }


        }
    }


    //�}�E�X��??(�{�^�����������Ƃ�)����??��
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

                if ((oc.heikou_hantei(s_step[1], moyori_senbun, 0.000001) == 0) ||  //�Q��??������?s���ǂ����𔻒肷���???Boc.heikou_hantei(Tyokusen t1,Tyokusen t2)//0=��?s�łȂ�
                        ((oc.senbun_kousa_hantei(s_step[1], moyori_senbun, 0.000001, 0.000001) == 31) && (i_orikaesi == 1))) {  //?�?��ɑI��??����2�ԖڂɑI��??���������Ȃ�oc.senbun_kousa_hantei==31
                    i_egaki_dankai = i_egaki_dankai + 1;
                    s_step[i_egaki_dankai].set(moyori_senbun);//s_step[i_egaki_dankai].setcolor(i_egaki_dankai);
                    s_step[i_egaki_dankai].setcolor(6);
                    return;
                }
            }
        }

    }


    //�}�E�X��??(�h���b�O�����Ƃ�)��?s����??
    public void mDragged_A_05(Ten p0) {
    }

    //�}�E�X��??(�{�^���𗣂����Ƃ�)��?s����??
    public void mReleased_A_05(Ten p0) {
        if (i_egaki_dankai == 2) {

            i_egaki_dankai = 0;

            Senbun add_sen = new Senbun();

            if (oc.heikou_hantei(s_step[1], moyori_senbun, 0.000001) == 0) { //�Q��??������?s���ǂ����𔻒肷���???Boc.heikou_hantei(Tyokusen t1,Tyokusen t2)//0=��?s�łȂ�
                //s_step[1]��s_step[2]�̌�_��oc.kouten_motome(Senbun s1,Senbun s2)��??�߂�//�Q��??����??�Ƃ݂Ȃ��Č�_��??�߂��???B??���Ƃ��Ă͌�?����Ȃ��Ă�?A��??�Ƃ��Č�?����Ă���???��̌�_��Ԃ�
                Ten kousa_ten = new Ten();
                kousa_ten.set(oc.kouten_motome(s_step[1], s_step[2]));
                //Senbun.get_tikai_hasi(Ten p){//�_P�Ƌ߂��ق��̒[�_��Ԃ�
                //s_step[1].get_tikai_hasi(kousa_ten);

                add_sen = new Senbun(kousa_ten, s_step[1].get_tikai_hasi(kousa_ten));
            }

            if ((oc.senbun_kousa_hantei(s_step[1], moyori_senbun, 0.000001, 0.000001) == 31) && (i_orikaesi == 1)) {  //?�?��ɑI��??����2�ԖڂɑI��??���������Ȃ�oc.senbun_kousa_hantei==31
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


//7777777777777777777    i_mouse_modeA==7;�p�񓙕�??��?[�h?@

    //�}�E�X��??(�}�E�X�𓮂������Ƃ�)��?s����??
    public void mMoved_A_07(Ten p0) {
        if ((i_egaki_dankai >= 0) && (i_egaki_dankai <= 2)) {
            mMoved_A_29(p0);//�߂������_�̂ݕ\��
        }

    }

    //�}�E�X��??(�{�^�����������Ƃ�)����??��
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

    //�}�E�X��??(�h���b�O�����Ƃ�)��?s����??
    public void mDragged_A_07(Ten p0) {
    }

    //�}�E�X��??(�{�^���𗣂����Ƃ�)��?s����??
    public void mReleased_A_07(Ten p0) {
        if (i_egaki_dankai == 4) {
            i_egaki_dankai = 0;

            i_egaki_dankai = 0;

            //�O�p�`�̓�?S��??�߂�	public Ten oc.naisin(Ten ta,Ten tb,Ten tc)
            Ten naisin = new Ten();
            naisin.set(oc.naisin(s_step[1].geta(), s_step[2].geta(), s_step[3].geta()));


            Senbun add_sen2 = new Senbun(s_step[2].geta(), naisin);


            //add_sen2��s_step[4]�̌�_��oc.kouten_motome(Senbun s1,Senbun s2)��??�߂�//�Q��??����??�Ƃ݂Ȃ��Č�_��??�߂��???B??���Ƃ��Ă͌�?����Ȃ��Ă�?A��??�Ƃ��Č�?����Ă���???��̌�_��Ԃ�
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


//88888888888888888888888    i_mouse_modeA==8?@;��?S��?[�h?B

    //�}�E�X��??(�}�E�X�𓮂������Ƃ�)��?s����??
    public void mMoved_A_08(Ten p0) {
        mMoved_A_29(p0);
    }//�߂������_�̂ݕ\��

    //�}�E�X��??(�{�^�����������Ƃ�)����??��
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

    //�}�E�X��??(�h���b�O�����Ƃ�)��?s����??
    public void mDragged_A_08(Ten p0) {
    }

    //�}�E�X��??(�{�^���𗣂����Ƃ�)��?s����??
    public void mReleased_A_08(Ten p0) {
        if (i_egaki_dankai == 3) {
            i_egaki_dankai = 0;

            //�O�p�`�̓�?S��??�߂�	public Ten oc.naisin(Ten ta,Ten tb,Ten tc)
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


    //53 53 53 53 53 53 53 53 53    i_mouse_modeA==53?@;��������P��?[�h?B
    //�}�E�X��??(�}�E�X�𓮂������Ƃ�)��?s����??
    public void mMoved_A_53(Ten p0) {
        mMoved_A_29(p0);
    }//�߂������_�̂ݕ\��

    //�}�E�X��??(�{�^�����������Ƃ�)����??��
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

    //�}�E�X��??(�h���b�O�����Ƃ�)��?s����??
    public void mDragged_A_53(Ten p0) {
    }

    //�}�E�X��??(�{�^���𗣂����Ƃ�)��?s����??
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
//54 54 54 54 54 54 54 54 54    i_mouse_modeA==54?@;��������2��?[�h?B
    //�}�E�X��??(�}�E�X�𓮂������Ƃ�)��?s����??
    public void mMoved_A_54(Ten p0) {
        mMoved_A_29(p0);
    }//�߂������_�̂ݕ\��

    //�}�E�X��??(�{�^�����������Ƃ�)����??��
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

    //�}�E�X��??(�h���b�O�����Ƃ�)��?s����??
    public void mDragged_A_54(Ten p0) {
    }

    //�}�E�X��??(�{�^���𗣂����Ƃ�)��?s����??
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
//55 55 55 55 55 55 55 55 55    i_mouse_modeA==55?@;�p�x����1��?[�h?B
    //�}�E�X��??(�}�E�X�𓮂������Ƃ�)��?s����??
    public void mMoved_A_55(Ten p0) {
        mMoved_A_29(p0);
    }//�߂������_�̂ݕ\��

    //�}�E�X��??(�{�^�����������Ƃ�)����??��
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

    //�}�E�X��??(�h���b�O�����Ƃ�)��?s����??
    public void mDragged_A_55(Ten p0) {
    }

    //�}�E�X��??(�{�^���𗣂����Ƃ�)��?s����??
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
//56 56 56 56 56 56 56 56 56    i_mouse_modeA==56?@;�p�x����2��?[�h?B
    //�}�E�X��??(�}�E�X�𓮂������Ƃ�)��?s����??
    public void mMoved_A_56(Ten p0) {
        mMoved_A_29(p0);
    }//�߂������_�̂ݕ\��

    //�}�E�X��??(�{�^�����������Ƃ�)����??��
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

    //�}�E�X��??(�h���b�O�����Ƃ�)��?s����??
    public void mDragged_A_56(Ten p0) {
    }

    //�}�E�X��??(�{�^���𗣂����Ƃ�)��?s����??
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
//57 57 57 57 57 57 57 57 57    i_mouse_modeA==57?@;�p�x����3��?[�h?B
    //�}�E�X��??(�}�E�X�𓮂������Ƃ�)��?s����??
    public void mMoved_A_57(Ten p0) {
        mMoved_A_29(p0);
    }//�߂������_�̂ݕ\��

    //�}�E�X��??(�{�^�����������Ƃ�)����??��
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

    //�}�E�X��??(�h���b�O�����Ƃ�)��?s����??
    public void mDragged_A_57(Ten p0) {
    }

    //�}�E�X��??(�{�^���𗣂����Ƃ�)��?s����??
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


//999999999999999999    i_mouse_modeA==9?@;????���낵��?[�h

    //�}�E�X��??(�}�E�X�𓮂������Ƃ�)��?s����??
    public void mMoved_A_09(Ten p0) {
        if (i_egaki_dankai == 0) {
            mMoved_A_29(p0);//�߂������_�̂ݕ\��
        }

    }


    //�}�E�X��??(�{�^�����������Ƃ�)����??��
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

    //�}�E�X��??(�h���b�O�����Ƃ�)��?s����??
    public void mDragged_A_09(Ten p0) {
    }

    //�}�E�X��??(�{�^���𗣂����Ƃ�)��?s����??
    public void mReleased_A_09(Ten p0) {
        if (i_egaki_dankai == 2) {
            i_egaki_dankai = 0;
            //��??t?�̓_p�̉e�̈ʒu?i�_p��?ł��߂���??t?�̈ʒu?j��??�߂�?Bpublic Ten oc.kage_motome(Tyokusen t,Ten p){
            //oc.Senbun2Tyokusen(Senbun s)//??�����܂ޒ�??�𓾂�

            Senbun add_sen = new Senbun(s_step[1].geta(), oc.kage_motome(oc.Senbun2Tyokusen(s_step[2]), s_step[1].geta()), icol);
            if (add_sen.getnagasa() > 0.00000001) {
                addsenbun(add_sen);
                kiroku();
            }


        }
    }
//------
//------
//40 40 40 40 40 40     i_mouse_modeA==40?@;��?s??���̓�?[�h

    //�}�E�X��??(�}�E�X�𓮂������Ƃ�)��?s����??
    public void mMoved_A_40(Ten p0) {
        if (i_egaki_dankai == 0) {
            mMoved_A_29(p0);//�߂������_�̂ݕ\��
        }

    }


    //�}�E�X��??(�{�^�����������Ƃ�)����??��
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

    //�}�E�X��??(�h���b�O�����Ƃ�)��?s����??
    public void mDragged_A_40(Ten p0) {
    }

    //�}�E�X��??(�{�^���𗣂����Ƃ�)��?s����??
    public void mReleased_A_40(Ten p0) {
        if (i_egaki_dankai == 3) {
            i_egaki_dankai = 0;
            //s_step[1]��_?󂩂�?As_step[2]�ɕ�?s��??���ɂ���?B
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
    //i_egaki_dankai��i_e_d�̂Ƃ���?A??��s_o��Ten a�͂��̂܂܂�?ATen b����s_k�̌�_�܂ł̂΂����ꎞ?�??s_step[i_e_d+1](?F��icolo)��ǉ�?B?�������???���1?A�Ȃ�炩�̕s�s?��Œǉ��ł��Ȃ�����???���-500��Ԃ�?B
    public int s_step_tuika_koutenmade(int i_e_d, Senbun s_o, Senbun s_k, int icolo) {

        Ten kousa_ten = new Ten();

        if (oc.heikou_hantei(s_o, s_k, 0.0000001) == 1) {//0=��?s�łȂ�?A1=��?s�łQ��??����v���Ȃ�?A2=��?s�łQ��??����v����
            return -500;
        }

        if (oc.heikou_hantei(s_o, s_k, 0.0000001) == 2) {//0=��?s�łȂ�?A1=��?s�łQ��??����v���Ȃ�?A2=��?s�łQ��??����v����
            kousa_ten.set(s_k.geta());
            if (oc.kyori(s_o.geta(), s_k.geta()) > oc.kyori(s_o.geta(), s_k.getb())) {
                kousa_ten.set(s_k.getb());
            }


        }

        if (oc.heikou_hantei(s_o, s_k, 0.0000001) == 0) {//0=��?s�łȂ�?A1=��?s�łQ��??����v���Ȃ�?A2=��?s�łQ��??����v����
            kousa_ten.set(oc.kouten_motome(s_o, s_k));
        }


        Senbun add_sen = new Senbun(kousa_ten, s_o.geta(), icolo);

        if (add_sen.getnagasa() > 0.00000001) {
            s_step[i_e_d + 1].set(add_sen);
            return 1;
        }
        return -500;
    }


//10 10 10 10 10    i_mouse_modeA==10?@;?܂�Ԃ���?[�h

    //�}�E�X��??(�}�E�X�𓮂������Ƃ�)��?s����??
    public void mMoved_A_10(Ten p0) {
        mMoved_A_29(p0);
    }//�߂������_�̂ݕ\��

    //�}�E�X��??(�{�^�����������Ƃ�)����??��
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

    //�}�E�X��??(�h���b�O�����Ƃ�)��?s����??
    public void mDragged_A_10(Ten p0) {
    }

    //�}�E�X��??(�{�^���𗣂����Ƃ�)��?s����??
    public void mReleased_A_10(Ten p0) {
        if (i_egaki_dankai == 3) {
            i_egaki_dankai = 0;

            //�Q�̓_t1,t2��ʂ钼??�Ɋւ���?A�_p�̑�?ƈʒu�ɂ���_��??�߂� public Ten oc.sentaisyou_ten_motome(Ten t1,Ten t2,Ten p){
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


//52 52 52 52 52    i_mouse_modeA==52?@;�A��?܂�Ԃ���?[�h ****************************************

    //�}�E�X��??(�}�E�X�𓮂������Ƃ�)��?s����??
    public void mMoved_A_52(Ten p0) {
        mMoved_A_29(p0);
    }//�߂������_�̂ݕ\��

    //�}�E�X��??(�{�^�����������Ƃ�)����??��
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

    //�}�E�X��??(�h���b�O�����Ƃ�)��?s����??
    public void mDragged_A_52(Ten p0) {
    }

    //�}�E�X��??(�{�^���𗣂����Ƃ�)��?s����??
    public void mReleased_A_52(Ten p0) {
        if (i_egaki_dankai == 2) {
            i_egaki_dankai = 0;

            //�Q�̓_t1,t2��ʂ钼??�Ɋւ���?A�_p�̑�?ƈʒu�ɂ���_��??�߂� public Ten oc.sentaisyou_ten_motome(Ten t1,Ten t2,Ten p){
            Ten t_taisyou = new Ten();
            t_taisyou.set(oc.sentaisyou_ten_motome(s_step[2].geta(), s_step[3].geta(), s_step[1].geta()));
            Senbun add_senbun = new Senbun();
            renzoku_orikaesi(s_step[1].geta(), s_step[2].geta());
            for (int i = 1; i <= i_egaki_dankai; i++) {

                if (s_step[i].getnagasa() > 0.00000001) {

                    add_senbun.set(s_step[i].geta(), s_step[i].getb());//�v??��?@s_step�͕\��?�̓s?��ŃA�N�e�B����0�ȊO��?ݒ肳��Ă���̂�add_senbun�ɂ��������Ă�20170507
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

        //�^����ꂽ�x�N�g��ab����������?A�����?d�Ȃ�Ȃ�?�??�Ƃ�?A?ł��߂���_�܂�s_step�Ƃ���
        if (e_s_dougubako.get_kousaten_made_nobasi_flg(a, b) == 0) {
            return;
        }
        //if(e_s_dougubako.get_kousaten_made_nobasi_orisen_fukumu_flg(a,b)==3){return;}

        i_egaki_dankai = i_egaki_dankai + 1;
        if (i_egaki_dankai > 100) {
            return;
        }//�O�̂��߂�s_step��?����100��?ݒ肵��

        s_step[i_egaki_dankai].set(e_s_dougubako.get_kousaten_made_nobasi_senbun(a, b));//�v??��?@es1�ł�������s_step��set.(senbun)���ƃA�N�e�B���łȂ��̂ŕ\����?������Ȃ�20170507
        s_step[i_egaki_dankai].setiactive(3);

        //??�߂���_��?A���̃x�N�g����?�����?B

        if (e_s_dougubako.get_kousaten_made_nobasi_flg(a, b) == 1) {
            Senbun kousaten_made_nobasi_saisyono_senbun = new Senbun();
            kousaten_made_nobasi_saisyono_senbun.set(e_s_dougubako.get_kousaten_made_nobasi_saisyono_senbun(a, b));

            Ten new_a = new Ten();
            new_a.set(e_s_dougubako.get_kousaten_made_nobasi_ten(a, b));
            Ten new_b = new Ten();
            new_b.set(oc.sentaisyou_ten_motome(kousaten_made_nobasi_saisyono_senbun.geta(), kousaten_made_nobasi_saisyono_senbun.getb(), a));//�Q�̓_t1,t2��ʂ钼??�Ɋւ���?A�_p�̑�?ƈʒu�ɂ���_��??�߂� public Ten oc.sentaisyou_ten_motome(Ten t1,Ten t2,Ten p){

            renzoku_orikaesi(new_a, new_b);
            return;
        }

        return;
    }
// ------------------------------------------------------------


//--------------------------------------------
//27 27 27 27 27 27 27 27  i_mouse_modeA==27??������	���� 27 27 27 27 27 27 27 27
    //��??�T�v?@
    //i_mouse_modeA==1��??�������ȊO�͓���?@
    //

    //�}�E�X��??(�}�E�X�𓮂������Ƃ�)��?s����??
    public void mMoved_A_27(Ten p0) {
        mMoved_m_00a(p0, icol);//�}�E�X�őI���ł�����_��\������?B�߂��Ɋ�?��̓_������Ƃ��͂��̓_?A�����Ƃ��̓}�E�X�̈ʒu��?g�����_�ƂȂ�?B
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

    //�}�E�X��??(i_mouse_modeA==27??������?@�Ń{�^�����������Ƃ�)����??��----------------------------------------------------
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

    //�}�E�X��??(i_mouse_modeA==27??������?@�Ńh���b�O�����Ƃ�)��?s����??----------------------------------------------------
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

    //�}�E�X��??(i_mouse_modeA==27??������?@�Ń{�^���𗣂����Ƃ�)��?s����??----------------------------------------------------
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
//29 29 29 29 29 29 29 29  i_mouse_modeA==29?����p�`����	���� 29 29 29 29 29 29 29 29
    //��??�T�v?@
    //i_mouse_modeA==1��??�������ȊO�͓���?@
    //

    //�}�E�X��??(�}�E�X�𓮂������Ƃ�)��?s����??
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

    //�}�E�X��??(i_mouse_modeA==29?����p�`����?@�Ń{�^�����������Ƃ�)����??��----------------------------------------------------
    public void mPressed_A_29(Ten p0) {
        s_step[1].setiactive(3);

        p.set(camera.TV2object(p0));

        if (i_egaki_dankai == 0) {    //��1�i�K�Ƃ���?A�_��I��
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(5);
            }
            return;
        }

        if (i_egaki_dankai == 1) {    //��2�i�K�Ƃ���?A�_��I��
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

    //�}�E�X��??(i_mouse_modeA==29?����p�`����?@�Ńh���b�O�����Ƃ�)��?s����??----------------------------------------------------
    public void mDragged_A_29(Ten p0) {
    }

    //�}�E�X��??(i_mouse_modeA==29?����p�`����?@�Ń{�^���𗣂����Ƃ�)��?s����??----------------------------------------------------
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


    //37 37 37 37 37 37 37 37 37 37 37;�p�x�K�i��
    //�}�E�X��??(�}�E�X�𓮂������Ƃ�)��?s����??
    public void mMoved_A_37(Ten p0) {
        mMoved_A_29(p0);
    }//�߂������_�̂ݕ\��

    //�}�E�X��??(i_mouse_modeA==37?@�Ń{�^�����������Ƃ�)����??��-------//System.out.println("A");---------------------------------------------
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

        s_step[2].set(s_step[1]);//�����ł�s_step[2]�͕\������Ȃ�?A�v�Z�p��??��
    }

    //�}�E�X��??(i_mouse_modeA==37?@�Ńh���b�O�����Ƃ�)��?s����??--------------//System.out.println("A");--------------------------------------
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


    //�}�E�X��??(i_mouse_modeA==37?@�Ń{�^���𗣂����Ƃ�)��?s����??----------------------------------------------------
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
            jk[0] = oc.kakudo(s_step[2]);//�}�E�X�œ��͂���??����X���ƂȂ��p�x
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
        if ((zure_flg == 0) && (syuusei_ten.kyori(moyori_ten) <= d_hantei_haba)) {//?Ŋ�_���p�x�n�ɂ̂��Ă���?A?C?��_�Ƃ��߂�????
            return moyori_ten;
        }
        return syuusei_ten;
    }


// 19 19 19 19 19 19 19 19 19 select �I��

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

        i_egaki_dankai = 4;//s_step[4]�܂ŕ`�悷�邽�߂�?A����?s���K�v

    }


//------------------------------------------------------------
// 19 19 19 19 19 19 19 19 19 select �I��


    int i_select_mode = 0;//=0�͒�?��̃Z���N�g��??

    //�}�E�X��??(i_mouse_modeA==19  select?@�Ń{�^�����������Ƃ�)����??��----------------------------------------------------
    public void mPressed_A_19(Ten p0) {
        System.out.println("19  select_");
        System.out.println("i_egaki_dankai=" + i_egaki_dankai);

        if (i_egaki_dankai == 0) {//i_select_mode�����߂�
            //Ten p =new Ten();
            p.set(camera.TV2object(p0));
            moyori_ten.set(get_moyori_ten_orisen_en(p));//����?Ŋ�_�͊i�q�_�͑�?ۂƂ��Ȃ�
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                i_select_mode = 0;
                if (ori_s.tyouten_syuui_sensuu_select(p, 0.0001) > 0) {
                    i_select_mode = orihime_ap.i_sel_mou_mode;//=1��move?A=2��move4p?A=3��copy?A=4��copy4p?A=5�͋��f��
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
            mPressed_A_12(p0);//���f
        }
    }


    //�}�E�X��??(i_mouse_modeA==19 select?@�Ńh���b�O�����Ƃ�)��?s����??----------------------------------------------------
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
            mDragged_A_12(p0);//���f
        }


    }


    //�}�E�X��??(i_mouse_modeA==19 select?@�Ń{�^���𗣂����Ƃ�)��?s����??----------------------------------------------------
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
            mReleased_A_12(p0);//���f
        }


    }


//------------------------------------------------------------


    public void mReleased_A_box_select(Ten p0) {
        i_egaki_dankai = 0;

        select(p19_1, p0);
        if (p19_1.kyori(p0) <= 0.000001) {
            p.set(camera.TV2object(p0));
            if (ori_s.mottomo_tikai_senbun_kyori(p) < d_hantei_haba) {//�_p��?ł��߂�??���̔�??�ł�?A���̋�����Ԃ�	public double mottomo_tikai_senbun_kyori(Ten p)
                ori_s.select(ori_s.mottomo_tikai_senbun_sagasi(p));
            }
        }

    }

//20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20


    //�}�E�X��??(i_mouse_modeA==19  select?@�Ń{�^�����������Ƃ�)����??��----------------------------------------------------
    public void mPressed_A_20(Ten p0) {
        mPressed_A_box_select(p0);
    }


    //�}�E�X��??(i_mouse_modeA==19 select?@�Ńh���b�O�����Ƃ�)��?s����??----------------------------------------------------
    public void mDragged_A_20(Ten p0) {
        mDragged_A_box_select(p0);
    }

    //�}�E�X��??(i_mouse_modeA==20 select?@�Ń{�^���𗣂����Ƃ�)��?s����??----------------------------------------------------
    public void mReleased_A_20(Ten p0) {

        i_egaki_dankai = 0;
        unselect(p19_1, p0);

        if (p19_1.kyori(p0) <= 0.000001) {
            //Ten p =new Ten();
            p.set(camera.TV2object(p0));
            if (ori_s.mottomo_tikai_senbun_kyori(p) < d_hantei_haba) {//�_p��?ł��߂�??���̔�??�ł�?A���̋�����Ԃ�	public double mottomo_tikai_senbun_kyori(Ten p)
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


//61 61 61 61 61 61 61 61 61 61 61 61 i_mouse_modeA==61//�����`���I��?ipaint�̑I���Ɏ������I���@�\?j�Ɏg��
    //��??�T�v?@
    //�}�E�X�{�^�������ꂽ�Ƃ�?@
    //�p��1/1������ 		?�??�̒[�_�݂̂���??�_?B�i�q�_����??�_�ɂȂ邱�Ƃ͂Ȃ�?B
    //�p��1/2����1/512������	?�??�̒[�_�Ɨp���g��?i-200.0,-200.0 _ 200.0,200.0)?j�̊i�q�_�Ƃ���??�_
    //���͓_P����??�_����i�q??kus.d_haba()��1/4��艓���Ƃ���?�???W?��ւ̓��͂Ȃ�
    //??�����������Ȃ�1�_?�̂Ƃ���?�???W?��ւ̓��͂Ȃ�

    //�}�E�X��??(�}�E�X�𓮂������Ƃ�)��?s����??
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


    //�}�E�X��??(i_mouse_modeA==61?@�����`���I���Ń{�^�����������Ƃ�)����??��----------------------------------------------------
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

    //�}�E�X��??(i_mouse_modeA==61?@�����`���I���Ńh���b�O�����Ƃ�)��?s����??----------------------------------------------------
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

			s_step[1].set(p2,p3); //s_step[1]��b�_��?�?��̒n�_�Ƃ��ĕ�?X�ł��Ȃ��̂�?A.set(p2,p3);�Ƃ���K�v������?B
			s_step[2].set(p3,p4);
			s_step[3].set(p4,p1);
			s_step[4].set(p1,p2);

			s_step[1].setcolor(6);
			s_step[2].setcolor(6);
			s_step[3].setcolor(6);
			s_step[4].setcolor(6);
*/

    }


    //�}�E�X��??(i_mouse_modeA==61 �����`���I��?@�Ń{�^���𗣂����Ƃ�)��?s����??----------------------------------------------------
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

			s_step[1].set(p2,p3); //s_step[1]��b�_��?�?��̒n�_�Ƃ��ĕ�?X�ł��Ȃ��̂�?A.set(p2,p3);�Ƃ���K�v������?B
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


//22222222222222222222222222222222222222222222222222222222222222 �W�J?}�ړ�


    //public void mPressed_A_02(Ten p0) {	}//�}�E�X��??(i_mouse_modeA==2?@�W�J?}�ړ��Ń{�^�����������Ƃ�)����??��
    //public void mDragged_A_02(Ten p0) {	}//�}�E�X��??(i_mouse_modeA==2?@�W�J?}�ړ��Ńh���b�O�����Ƃ�)��?s����??
    //public void mReleased_A_02(Ten p0){	}//�}�E�X��??(i_mouse_modeA==2?@�W�J?}�ړ��Ń{�^���𗣂����Ƃ�)��?s����??

    //3 3 3 3 3 33333333333333333333333333333333333333333333333333333333
    //�}�E�X��??(i_mouse_modeA==3,23 "??��????" �Ń{�^�����������Ƃ�)����??��----------------------------------------------------
    public void mPressed_A_03(Ten p0) {
        //System.out.println("(1)zzzzz ori_s.check4_size() = "+ori_s.check4_size());
        if (i_orisen_hojyosen == 0) {
            mPressed_A_box_select(p0);
        }//?�??��????
        if (i_orisen_hojyosen == 2) {
            mPressed_A_box_select(p0);
        }//?���?�??
        if (i_orisen_hojyosen == 3) {
            mPressed_A_box_select(p0);
        }//��?��???

        if (i_orisen_hojyosen == 1) {
            mPressed_A_box_select(p0);
        }//��?��G??

        if (i_orisen_hojyosen == 4) {
            mPressed_A_box_select(p0);
        }//?�??�ƕ�?��???�ƕ�?��G??
    }

    //�}�E�X��??(i_mouse_modeA==3,23�Ńh���b�O�����Ƃ�)��?s����??----------------------------------------------------
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

    //�}�E�X��??(i_mouse_modeA==3,23 �Ń{�^���𗣂����Ƃ�)��?s����??----------------------------------------------------
    public void mReleased_A_03(Ten p0) {//?�??�ƕ�?��???�Ɖ~
        //System.out.println("(3_1)zzzzz ori_s.check4_size() = "+ori_s.check4_size());
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        i_egaki_dankai = 0;

        //?Ŋ�̈��????
        if (p19_1.kyori(p0) <= 0.000001) {//?Ŋ�̈��????
            int i_sakujyo_mode = 10;//i_sakujyo_mode�͂����Œ�`?E?錾���Ă���
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
                rs_min = ori_s.mottomo_tikai_senbun_kyori(p);//�_p��?ł��߂�??��(?�??�ƕ�?��???)�̔�??�ł�?A���̋�����Ԃ�	public double mottomo_tikai_senbun_kyori(Ten p)

                double re_min;
                re_min = ori_s.mottomo_tikai_en_kyori(p);//�_p��?ł��߂��~�̔�??�ł�?A���̋�����Ԃ�	public double mottomo_tikai_en_kyori(Ten p)

                double hoj_rs_min;
                hoj_rs_min = hoj_s.mottomo_tikai_senbun_kyori(p);//�_p��?ł��߂���?��G??�̔�??�ł�?A���̋�����Ԃ�	public double mottomo_tikai_senbun_kyori(Ten p)

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


            if (i_sakujyo_mode == 0) { //?�??��????

                //Ten p =new Ten(); p.set(camera.TV2object(p0));
                double rs_min;
                rs_min = ori_s.mottomo_tikai_senbun_kyori(p);//�_p��?ł��߂�??��(?�??�ƕ�?��???)�̔�??�ł�?A���̋�����Ԃ�	public double mottomo_tikai_senbun_kyori(Ten p)
                if (rs_min < d_hantei_haba) {
                    if (ori_s.getcolor(ori_s.mottomo_tikai_senbun_sagasi_gyakujyun(p)) < 3) {
                        ori_s.delsenbun_vertex(ori_s.mottomo_tikai_senbun_sagasi_gyakujyun(p));
                        en_seiri();
                        kiroku();
                    }
                }

            }


            if (i_sakujyo_mode == 2) { //?���?�??��????

                //Ten p =new Ten(); p.set(camera.TV2object(p0));
                double rs_min;
                rs_min = ori_s.mottomo_tikai_senbun_kyori(p);//�_p��?ł��߂�??��(?�??�ƕ�?��???)�̔�??�ł�?A���̋�����Ԃ�	public double mottomo_tikai_senbun_kyori(Ten p)
                if (rs_min < d_hantei_haba) {
                    if (ori_s.getcolor(ori_s.mottomo_tikai_senbun_sagasi_gyakujyun(p)) == 0) {
                        ori_s.delsenbun_vertex(ori_s.mottomo_tikai_senbun_sagasi_gyakujyun(p));
                        en_seiri();
                        kiroku();
                    }
                }

            }

            if (i_sakujyo_mode == 3) {  //��?��???
                //Ten p =new Ten(); p.set(camera.TV2object(p0));
                double rs_min;
                rs_min = ori_s.mottomo_tikai_senbun_kyori(p);//�_p��?ł��߂�??��(?�??�ƕ�?��???)�̔�??�ł�?A���̋�����Ԃ�
                double re_min;
                re_min = ori_s.mottomo_tikai_en_kyori(p);//�_p��?ł��߂��~�̔�??�ł�?A���̋�����Ԃ�	public double mottomo_tikai_en_kyori(Ten p)


                if (rs_min <= re_min) {
                    if (rs_min < d_hantei_haba) {//�_p��?ł��߂�??���̔�??�ł�?A���̋�����Ԃ�	public double mottomo_tikai_senbun_kyori(Ten p)
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

            if (i_sakujyo_mode == 1) { //��?��G??

                //Ten p =new Ten(); p.set(camera.TV2object(p0));
                double rs_min;
                rs_min = hoj_s.mottomo_tikai_senbun_kyori(p);//�_p��?ł��߂���?��G??�̔�??�ł�?A���̋�����Ԃ�	public double mottomo_tikai_senbun_kyori(Ten p)

                if (rs_min < d_hantei_haba) {
                    hoj_s.delsenbun_vertex(hoj_s.mottomo_tikai_senbun_sagasi_gyakujyun(p));
                    //en_seiri();
                    kiroku();
                }

            }


        }


        //�l�p�g����???? //p19_1��select��?�?���Ten?B����?��?��?�?���Ten��?Ō�̓_�������̂�?A�l�p��?�������Ƃ�������?B
        if (p19_1.kyori(p0) > 0.000001) {
            if ((i_orisen_hojyosen == 0) || (i_orisen_hojyosen == 4)) { //?�??��????	//D_nisuru(p19_1,p0)��?�??������???������?B
                if (D_nisuru0(p19_1, p0) != 0) {
                    en_seiri();
                    kiroku();
                }
            }


            if (i_orisen_hojyosen == 2) {  //?���?�??�̂�????
                if (D_nisuru2(p19_1, p0) != 0) {
                    en_seiri();
                    kiroku();
                }
            }


            if ((i_orisen_hojyosen == 3) || (i_orisen_hojyosen == 4)) {  //��?��???  //��?�ł�???����Ȃ��Ƃ���UNDO�p�ɋL�^����Ă��܂�20161218
                if (D_nisuru3(p19_1, p0) != 0) {
                    en_seiri();
                    kiroku();
                }
            }

            if ((i_orisen_hojyosen == 1) || (i_orisen_hojyosen == 4)) { //��?��G??	//��?�ł�???����Ȃ��Ƃ���UNDO�p�ɋL�^����Ă��܂�20161218
                if (D_nisuru1(p19_1, p0) != 0) {
                    kiroku();
                }
            }

        }

//qqqqqqqqqqqqqqqqqqqqqqqqqqqqq//System.out.println("= ");qqqqq
//check4(0.0001);//D_nisuru0�������?Aori_s.D_nisuru0����reset����?s����邽��?Acheck4�̂�蒼�����K�v?B
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
    //�}�E�X��??(i_mouse_modeA==59 "��??�v??�p�e�B�w��" �Ń{�^�����������Ƃ�)����??��----------------------------------------------------
    public void mPressed_A_59(Ten p0) {
        mPressed_A_box_select(p0);   //?�??�ƕ�?��???�ƕ�?��G??
    }

    //�}�E�X��??(i_mouse_modeA==59 "��??�v??�p�e�B�w��"�Ńh���b�O�����Ƃ�)��?s����??----------------------------------------------------
    public void mDragged_A_59(Ten p0) {
        mDragged_A_box_select(p0);
    }

    //�}�E�X��??(i_mouse_modeA==59 "��??�v??�p�e�B�w��" �Ń{�^���𗣂����Ƃ�)��?s����??----------------------------------------------------
    public void mReleased_A_59(Ten p0) {//��?��???�Ɖ~
        i_egaki_dankai = 0;
        if (p19_1.kyori(p0) > 0.000001) {//��?�ł�???����Ȃ��Ƃ���UNDO�p�ɋL�^����Ă��܂�20161218

            //if(D_nisuru3(p19_1,p0)!=0){en_seiri();kiroku();}
            if (chenge_property_in_4kakukei(p19_1, p0) != 0) {
                //kiroku();
            }

        }

        if (p19_1.kyori(p0) <= 0.000001) {
            //Ten p =new Ten();
            p.set(camera.TV2object(p0));
            double rs_min;
            rs_min = ori_s.mottomo_tikai_senbun_kyori(p);//�_p��?ł��߂���?��???�̔�??�ł�?A���̋�����Ԃ�
            double re_min;
            re_min = ori_s.mottomo_tikai_en_kyori(p);//�_p��?ł��߂��~�̔�??�ł�?A���̋�����Ԃ�	public double mottomo_tikai_en_kyori(Ten p)


            if (rs_min <= re_min) {
                if (rs_min < d_hantei_haba) {//�_p��?ł��߂�??���̔�??�ł�?A���̋�����Ԃ�	public double mottomo_tikai_senbun_kyori(Ten p)
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
    }//�}�E�X��??(i_mouse_modeA==4??_�ϊ�?@�Ń{�^�����������Ƃ�)����??��

    public void mDragged_A_04(Ten p0) {
    }//�}�E�X��??(i_mouse_modeA==4??_�ϊ�?@�Ńh���b�O�����Ƃ�)��?s����??

    //�}�E�X��??(i_mouse_modeA==4??_�ϊ�?@�Ń{�^���𗣂����Ƃ�)��?s����??
    public void mReleased_A_04(Ten p0) {
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));


        if (ori_s.mottomo_tikai_senbun_kyori(p) < d_hantei_haba) {//�_p��?ł��߂�??���̔�??�ł�?A���̋�����Ԃ�	public double mottomo_tikai_senbun_kyori(Ten p)
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
    }//�}�E�X��??(i_mouse_modeA==58??_�ϊ�?@�Ń{�^�����������Ƃ�)����??��

    public void mDragged_A_58(Ten p0) {
        mDragged_A_box_select(p0);
    }//�}�E�X��??(i_mouse_modeA==58??_�ϊ�?@�Ńh���b�O�����Ƃ�)��?s����??

    //�}�E�X��??(i_mouse_modeA==58??_�ϊ�?@�Ń{�^���𗣂����Ƃ�)��?s����??
    public void mReleased_A_58(Ten p0) {//������????��?I���� fix2(0.001,0.5);?@������̂�?A������?�??���������̂�?A��????����ϊ�����?�??�Ƃ̑g?����ŕp������T���^�s?ڑ���?C?����邽��
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
            if (ori_s.mottomo_tikai_senbun_kyori(p) < d_hantei_haba) {//�_p��?ł��߂�??���̔�??�ł�?A���̋�����Ԃ�	public double mottomo_tikai_senbun_kyori(Ten p)
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


    //30 30 30 30 30 30 30 30 30 30 30 30 ?���_??_�ϊ�
    int minrid_30;

    public void mPressed_A_30(Ten p0) {    //�}�E�X��??(i_mouse_modeA==4??_�ϊ�?@�Ń{�^�����������Ƃ�)����??��
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        minrid_30 = -1;
        if (ori_s.mottomo_tikai_senbun_kyori(p) < d_hantei_haba) {//�_p��?ł��߂�??���̔�??�ł�?A���̋�����Ԃ�	public double mottomo_tikai_senbun_kyori(Ten p)
            minrid_30 = ori_s.mottomo_tikai_senbun_sagasi(p);
            Senbun s01 = new Senbun();
            s01.set(oc.Senbun_bai(ori_s.get(minrid_30), 0.01));
            ori_s.setb(minrid_30, s01.getb());
        }
    }

    public void mDragged_A_30(Ten p0) {//�}�E�X��??(i_mouse_modeA==4??_�ϊ�?@�Ńh���b�O�����Ƃ�)��?s����??
        if (minrid_30 > 0) {

            Senbun s01 = new Senbun();
            s01.set(oc.Senbun_bai(ori_s.get(minrid_30), 100.0));
            ori_s.setb(minrid_30, s01.getb());
            minrid_30 = -1;
        }

    }


    //�}�E�X��??(i_mouse_modeA==30 ?���_??_�ϊ�?@�Ń{�^���𗣂����Ƃ�)��?s����???i�w�i�ɓW�J?}������???��p?j
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

//101:?܂�?オ��?}�̑�???B
//102;F_move
//103;S_face

//10001;test1 ����??���Ƃ��ē_���R�w�肷��


//66666666666666666666    i_mouse_modeA==6?@;2�_���瓙����??����?[�h

    //�}�E�X��??(�{�^�����������Ƃ�)����??��
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

    //�}�E�X��??(�h���b�O�����Ƃ�)��?s����??
    public void mDragged_A_06(Ten p0) {
    }

    //�}�E�X��??(�{�^���𗣂����Ƃ�)��?s����??
    public void mReleased_A_06(Ten p0) {
        if (i_egaki_dankai == 3) {
            i_egaki_dankai = 0;
        }


    }

//------


//------?܂�?�݉\??����


//38 38 38 38 38 38 38    i_mouse_modeA==38?@;?܂�?�݉\??����  qqqqqqqqq


    int i_step_for38 = 0;

    //�}�E�X��??(�}�E�X�𓮂������Ƃ�)��?s����??    //System.out.println("_");
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
                if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {//?Ŋ�̊���?�??���߂�????
                    i_kouho_dankai = 1;
                    s_kouho[1].set(moyori_senbun);
                    //s_kouho[1].setcolor(2);
                    return;
                }

            }
        }
    }


    //Ten t1 =new Ten();
//�}�E�X��??(�{�^�����������Ƃ�)����??��
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
            t1.set(ori_s.mottomo_tikai_Ten_with_icol_0_1_2(p));//�_p��?ł��߂�?A?u??���̒[�_?v��Ԃ�ori_s.mottomo_tikai_Ten�͋߂��_���Ȃ��� p_return.set(100000.0,100000.0)�ƕԂ��Ă���

            if (p.kyori(t1) < d_hantei_haba) {
                //i_egaki_dankai=i_egaki_dankai+1;
                //s_step[i_egaki_dankai].set(moyori_ten,moyori_ten);s_step[i_egaki_dankai].setcolor(i_egaki_dankai);

                //t1��[�_�Ƃ���?�??��Narabebako�ɓ����
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

                if (nbox.getsousuu() % 2 == 1) {//t1��[�_�Ƃ���?�??��?�����?��̂Ƃ�����if{}����????������
                    icol_temp = icol;
                    if (nbox.getsousuu() == 1) {
                        icol_temp = ori_s.get(nbox.get_int(1)).getcolor();
                    }//20180503����?s�ǉ�?B�����?A?�??��1�{�����̒��_����?܂�?�݉\??�ǉ��@�\��?A����?�??�̉�����?s����???���?A??��?F�������O��?�??��?������邽��

                    //int i_kouho_suu=0;
                    for (int i = 1; i <= nbox.getsousuu(); i++) {//i�͊p�����l��??�߂�?�?���?�??��id
                        //?�??����?��̒��_����̊p�����l��2.0�Ŋ���Ɗp�����l��?�???�??��?A?܂�?�݉\�ɂ��邽�߂̒ǉ���?�??�Ƃ̊p�x�ɂȂ�?B
                        double kakukagenti = 0.0;
                        //System.out.println("nbox.getsousuu()="+nbox.getsousuu());
                        int tikai_orisen_jyunban;
                        int tooi_orisen_jyunban;
                        for (int k = 1; k <= nbox.getsousuu(); k++) {//k�͊p�����l��??�߂�p�x��?���
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
                        //�`�F�b�N�p�Ɋp�����l��?�?��̊p�x�̒���kakukagenti/2.0�����邩���m�F����
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

                            //??��ab��a��?S��d�x��]����??����Ԃ���???i����??���͕ς�����?V����??����Ԃ�?jpublic oc.Senbun_kaiten(Senbun s0,double d)
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
            if (oc.kyori_senbun(p, moyori_senbun) >= d_hantei_haba) {//?Ŋ�̊���?�??�������đI�𖳌���????
                //moyori_senbun.set(get_moyori_step_senbun(p,1,i_egaki_dankai));
                if (oc.kyori_senbun(p, moyori_step_senbun) < d_hantei_haba) {//?Ŋ��step_senbun���߂�????
//System.out.println("20170129_1");
                    return;
                }

                //?Ŋ��step_senbun������????
//System.out.println("20170129_2");

                i_egaki_dankai = 0;
                return;
            }

            if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {//?Ŋ�̊���?�??���߂�????

                s_step[2].set(moyori_senbun);
                s_step[2].setcolor(6);

//System.out.println("20170129_3");
                Ten kousa_ten = new Ten();
                kousa_ten.set(oc.kouten_motome(s_step[1], s_step[2]));
                Senbun add_sen = new Senbun(kousa_ten, s_step[1].geta(), icol_temp);//20180503��?X
                if (add_sen.getnagasa() > 0.00000001) {//?Ŋ�̊���?�??���L����????
                    addsenbun(add_sen);
                    kiroku();
                    i_egaki_dankai = 0;
                    return;

                }

                //?Ŋ�̊���?�??��������????

                //?Ŋ��step_senbun���߂�????
                if (oc.kyori_senbun(p, moyori_step_senbun) < d_hantei_haba) {
                    return;
                }

                //?Ŋ��step_senbun������????
                i_egaki_dankai = 0;
                return;

            }
        }


    }

    //�}�E�X��??(�h���b�O�����Ƃ�)��?s����??
    public void mDragged_A_38(Ten p0) {
    }

    //�}�E�X��??(�{�^���𗣂����Ƃ�)��?s����??
    public void mReleased_A_38(Ten p0) {

    }


//------?܂�?�݉\??+�i�q�_�n����


    //39 39 39 39 39 39 39    i_mouse_modeA==39?@;?܂�?�݉\??����  qqqqqqqqq
    int i_step_for39 = 0;//i_step_for39=2��???���?Astep??��1�{�����ɂȂ��Ă���?A���̑�??�œ���?�??���m�肷��?��
//
//�ۑ�?@step??�Ɗ���?�??����?s�̎��G��?[������??���������Ƃ����P���邱��20170407
//
//��??�d�l
//?i�P?j�_��I��?i�����_�I���K?�?j
//?i�Qa?j�I��_��3��?�̊�???�??�̒��_��????
//?i�R?j
//
//
//?i�Qb?j�Qa�ȊO��????
//
//Ten t1 =new Ten();


    //�}�E�X��??(�}�E�X�𓮂������Ƃ�)��?s����??    //System.out.println("_");
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
				//�C�ӂ̓_���^����ꂽ�Ƃ�?A�[�_�������͊i�q�_��?ł��߂��_�𓾂�
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


            if (i_step_for39 == 2) {//i_step_for39==2�ł����?A�ȉ���s_step[1]�����?�??���m�肷��
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
                if (oc.kyori_senbun(p, moyori_senbun) >= d_hantei_haba) {//?Ŋ�̊���?�??������????
                    if (oc.kyori_senbun(p, moyori_step_senbun) < d_hantei_haba) {//?Ŋ��step_senbun���߂�????
                        return;
                    }
                    //?Ŋ��step_senbun������????
                    System.out.println("i_step_for39_2_   4");

                    return;
                }

                if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {//?Ŋ�̊���?�??���߂�????
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


    //�}�E�X��??(�{�^�����������Ƃ�)����??��--------------
    public void mPressed_A_39(Ten p0) {
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));

        if (i_egaki_dankai == 0) {
            i_step_for39 = 0;
        }


        //if(i_egaki_dankai==0){i_step_for39=0;}

        if (i_step_for39 == 0) {
            double hantei_kyori = 0.000001;

            //�C�ӂ̓_���^����ꂽ�Ƃ�?A�[�_�������͊i�q�_��?ł��߂��_�𓾂�
            moyori_ten.set(get_moyori_ten(p));

            if (p.kyori(moyori_ten) < d_hantei_haba) {
                //i_egaki_dankai=i_egaki_dankai+1;
                //s_step[i_egaki_dankai].set(moyori_ten,moyori_ten);s_step[i_egaki_dankai].setcolor(i_egaki_dankai);

                //moyori_ten��[�_�Ƃ���?�??��Narabebako�ɓ����
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
                if (nbox.getsousuu() % 2 == 1) {//moyori_ten��[�_�Ƃ���?�??��?�����?��̂Ƃ�����if{}����????������
                    //System.out.println("20170130_3");

                    //int i_kouho_suu=0;
                    for (int i = 1; i <= nbox.getsousuu(); i++) {//i�͊p�����l��??�߂�?�?���?�??��id
                        //?�??����?��̒��_����̊p�����l��2.0�Ŋ���Ɗp�����l��?�???�??��?A?܂�?�݉\�ɂ��邽�߂̒ǉ���?�??�Ƃ̊p�x�ɂȂ�?B
                        double kakukagenti = 0.0;
                        //System.out.println("nbox.getsousuu()="+nbox.getsousuu());
                        int tikai_orisen_jyunban;
                        int tooi_orisen_jyunban;
                        for (int k = 1; k <= nbox.getsousuu(); k++) {//k�͊p�����l��??�߂�p�x��?���
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
                        //�`�F�b�N�p�Ɋp�����l��?�?��̊p�x�̒���kakukagenti/2.0�����邩���m�F����
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

                            //??��ab��a��?S��d�x��]����??����Ԃ���???i����??���͕ς�����?V����??����Ԃ�?jpublic oc.Senbun_kaiten(Senbun s0,double d)
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

                if (i_egaki_dankai == 0) {//?�?�݉\��??���Ȃ�????//System.out.println("_");
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


        if (i_step_for39 == 2) {//i_step_for39==2�ł����?A�ȉ���s_step[1]�����?�??���m�肷��
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
            if (oc.kyori_senbun(p, moyori_senbun) >= d_hantei_haba) {//?Ŋ�̊���?�??������????
                //moyori_senbun.set(get_moyori_step_senbun(p,1,i_egaki_dankai));


                //moyori_ten.set(get_moyori_ten(p));if(p.kyori(moyori_ten)<d_hantei_haba){s_step[1].setb(moyori_ten);return;}
                //moyori_ten.set(ori_s.mottomo_tikai_Ten(p));if(p.kyori(moyori_ten)<d_hantei_haba){s_step[1].setb(moyori_ten);return;}


                if (oc.kyori_senbun(p, moyori_step_senbun) < d_hantei_haba) {//?Ŋ��step_senbun���߂�????

                    //moyori_ten.set(get_moyori_ten(p));if(p.kyori(moyori_ten)<d_hantei_haba){s_step[1].setb(moyori_ten);return;}


                    return;
                }
                //?Ŋ��step_senbun������????

                //moyori_ten.set(get_moyori_ten(p));if(p.kyori(moyori_ten)<d_hantei_haba){s_step[1].setb(moyori_ten);return;}
                i_egaki_dankai = 0;
                i_kouho_dankai = 0;
                return;
            }

            if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {//?Ŋ�̊���?�??���߂�????
                //moyori_ten.set(ori_s.mottomo_tikai_Ten(p));if(p.kyori(moyori_ten)<d_hantei_haba){s_step[1].setb(moyori_ten);return;}
                s_step[2].set(moyori_senbun);
                s_step[2].setcolor(6);
                //System.out.println("20170129_3");
                Ten kousa_ten = new Ten();
                kousa_ten.set(oc.kouten_motome(s_step[1], s_step[2]));
                Senbun add_sen = new Senbun(kousa_ten, s_step[1].geta(), icol);
                if (add_sen.getnagasa() > 0.00000001) {//?Ŋ�̊���?�??���L����????
                    addsenbun(add_sen);
                    kiroku();
                    i_egaki_dankai = 0;
                    i_kouho_dankai = 0;
                    return;
                }
                //?Ŋ�̊���?�??��������????
                moyori_ten.set(get_moyori_ten(p));
                if (p.kyori(moyori_ten) < d_hantei_haba) {
                    s_step[1].setb(moyori_ten);
                    return;
                }
                //?Ŋ��step_senbun���߂�????
                if (oc.kyori_senbun(p, moyori_step_senbun) < d_hantei_haba) {
                    return;
                }
                //?Ŋ��step_senbun������????
                i_egaki_dankai = 0;
                i_kouho_dankai = 0;
                return;

            }
            return;
        }


    }

    //�}�E�X��??(�h���b�O�����Ƃ�)��?s����??
    public void mDragged_A_39(Ten p0) {
    }

    //�}�E�X��??(�{�^���𗣂����Ƃ�)��?s����??
    public void mReleased_A_39(Ten p0) {

    }


//33 33 33 33 33 33 33 33 33 33 33����??


    //�}�E�X��??(�}�E�X�𓮂������Ƃ�)��?s����??
    public void mMoved_A_33(Ten p0) {
        mMoved_A_11(p0);
    }//�߂������_�̂ݕ\��


    //�}�E�X��??(i_mouse_modeA==33����???@�Ń{�^�����������Ƃ�)����??��----------------------------------------------------
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

    //�}�E�X��??(i_mouse_modeA==33����???@�Ńh���b�O�����Ƃ�)��?s����??----------------------------------------------------
    public void mDragged_A_33(Ten p0) {
        mDragged_A_11(p0);
    }

    //�}�E�X��??(i_mouse_modeA==33����???@�Ń{�^���𗣂����Ƃ�)��?s����??----------------------------------------------------
    public void mReleased_A_33(Ten p0) {
        if (i_egaki_dankai == 1) {
            i_egaki_dankai = 0;

            //s_step[1]���m�肷��
            //Ten p =new Ten();
            p.set(camera.TV2object(p0));
            moyori_ten.set(get_moyori_ten(p));
            s_step[1].seta(moyori_ten);
            //s_step[1]���m��?I��


            if (p.kyori(moyori_ten) <= d_hantei_haba) {  //�}�E�X�Ŏw�肵���_��?A?Ŋ�_�Ƌ߂������Ƃ��Ɏ��{
                if (s_step[1].getnagasa() > 0.00000001) {  //s_step[1]��?A??�̎�?i=�_?�ł͂Ȃ���?j�Ɏ��{
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

                }  //s_step[1]��?A??�̎�?i=�_?�ł͂Ȃ���?j�Ɏ��{��?A�����܂�
            }  //�}�E�X�Ŏw�肵���_��?A?Ŋ�_�Ƌ߂������Ƃ��Ɏ��{��?A�����܂�
        }
    }


//35 35 35 35 35 35 35 35 35 35 35��?܂�Ԃ�   ���͂���??����?�?G���Ă���?�??��?܂�Ԃ�?@�Ɏg��

    //�}�E�X��??(�}�E�X�𓮂������Ƃ�)��?s����??
    public void mMoved_A_35(Ten p0) {
        mMoved_A_11(p0);
    }//�߂������_�̂ݕ\��


    //�}�E�X��??(i_mouse_modeA==35?@�Ń{�^�����������Ƃ�)����??��----------------------------------------------------
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

    //�}�E�X��??(i_mouse_modeA==35?@�Ńh���b�O�����Ƃ�)��?s����??----------------------------------------------------

    public void mDragged_A_35(Ten p0) {
        mDragged_A_11(p0);
    }

/*	public void mDragged_A_35(Ten p0) {

		Ten p =new Ten(); p.set(camera.TV2object(p0));
		s_step[1].seta(p);

		//k.seta(ieda, p);
	}
*/

    //�}�E�X��??(i_mouse_modeA==35?@�Ń{�^���𗣂����Ƃ�)��?s����??----------------------------------------------------
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


                            //�Q�̓_t1,t2��ʂ钼??�Ɋւ���?A�_p�̑�?ƈʒu�ɂ���_��??�߂� public Ten oc.sentaisyou_ten_motome(Ten t1,Ten t2,Ten p){
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

    public Senbun kousatenmade(Senbun s0) {//s0��_a����b������?A����?�??�ƌ�?�����Ƃ���܂ŉ�������?B?V����??����Ԃ�//����?�??�ƌ�?����Ȃ��Ȃ�?A����??����Ԃ�
        Senbun add_sen = new Senbun();
        add_sen.set(s0);
        Ten kousa_ten = new Ten(1000000.0, 1000000.0); //���̕��@����?A�G��?[�̌����ɂȂ肤��?B�{���Ȃ�S??����x_max?Ay_max��?�̓_�����΂���?B?���?C?��\��20161120
        double kousa_ten_kyori = kousa_ten.kyori(add_sen.geta());


        Tyokusen tyoku1 = new Tyokusen(add_sen.geta(), add_sen.getb());
        int i_kousa_flg;
        for (int i = 1; i <= ori_s.getsousuu(); i++) {
            i_kousa_flg = tyoku1.senbun_kousa_hantei_kuwasii(ori_s.get(i));//0=���̒�??�͗^����ꂽ??���ƌ�?����Ȃ�?A1=X�^�Ō�?�����?A2=T�^�Ō�?�����?A3=??���͒�??�Ɋ܂܂��?B

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

    public Senbun kousatenmade_2(Senbun s0) {//s0��_a����b������?A����?�??�ƌ�?�����Ƃ���܂ŉ�������?B?V����??����Ԃ�//����?�??�ƌ�?����Ȃ��Ȃ�?A����??����Ԃ�
        Senbun add_sen = new Senbun();
        add_sen.set(s0);
        //Senbun add_sen;add_sen=s0;


        Ten kousa_ten = new Ten(1000000.0, 1000000.0); //���̕��@����?A�G��?[�̌����ɂȂ肤��?B�{���Ȃ�S??����x_max?Ay_max��?�̓_�����΂���?B?���?C?��\��20161120
        double kousa_ten_kyori = kousa_ten.kyori(add_sen.geta());

        Tyokusen tyoku1 = new Tyokusen(add_sen.geta(), add_sen.getb());
        int i_kousa_flg;//����??����??�Ƃ������̂�?A����??���̌�?�?��
        int i_senbun_kousa_flg;//����??����?A����??���̌�?�?��

        System.out.println("AAAAA_");
        for (int i = 1; i <= ori_s.getsousuu(); i++) {
            i_kousa_flg = tyoku1.senbun_kousa_hantei_kuwasii(ori_s.get(i));//0=���̒�??�͗^����ꂽ??���ƌ�?����Ȃ�?A1=X�^�Ō�?�����?A2=T�^�Ō�?�����?A3=??���͒�??�Ɋ܂܂��?B

            //i_senbun_kousa_flg=oc.senbun_kousa_hantei_amai( add_sen,ori_s.get(i),0.00001,0.00001);//20180408�Ȃ�������?s�̗l��add_sen���g����?Ai_senbun_kousa_flg�����������Ȃ�
            i_senbun_kousa_flg = oc.senbun_kousa_hantei_amai(s0, ori_s.get(i), 0.00001, 0.00001);//20180408�Ȃ�������?s�̗l��s0�̂܂܂���?Ai_senbun_kousa_flg�����������Ȃ�Ȃ�?B
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

    public int kouten_ari_nasi(Senbun s0) {//s0��_a����b�����ɉ���������?A����?�??�ƌ�?�����Ȃ�?A�P���Ȃ��Ȃ�O��Ԃ�?Ba�X�ł̌�?�����??����?A���̊�?��ł͌�?��Ȃ��ɂȂ�?B
        Senbun add_sen = new Senbun();
        add_sen.set(s0);
        Ten kousa_ten = new Ten(1000000.0, 1000000.0); //���̕��@����?A�G��?[�̌����ɂȂ肤��?B�{���Ȃ�S??����x_max?Ay_max��?�̓_�����΂���?B?���?C?��\��20161120
        double kousa_ten_kyori = kousa_ten.kyori(add_sen.geta());


        Tyokusen tyoku1 = new Tyokusen(add_sen.geta(), add_sen.getb());
        int i_kousa_flg;
        for (int i = 1; i <= ori_s.getsousuu(); i++) {
            i_kousa_flg = tyoku1.senbun_kousa_hantei_kuwasii(ori_s.get(i));//0=���̒�??�͗^����ꂽ??���ƌ�?����Ȃ�?A1=X�^�Ō�?�����?A2=T�^�Ō�?�����?A3=??���͒�??�Ɋ܂܂��?B

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


//21 21 21 21 21    i_mouse_modeA==21?@;�ړ���?[�h

    //�}�E�X�𓮂������Ƃ�
    public void mMoved_A_21(Ten p0) {
        mMoved_m_00b(p0, 5);
    }//�}�E�X�őI���ł�����_��\������?B�߂��Ɋ�?��̓_������Ƃ��͂��̓_?A�����Ƃ��̓}�E�X�̈ʒu��?g�����_�ƂȂ�?B

    //�}�E�X�N���b�N----------------------------------------------------
    public void mPressed_A_21(Ten p0) {
        mPressed_m_00b(p0, 5);
    }

    //�}�E�X�h���b�O----------------------------------------------------
    public void mDragged_A_21(Ten p0) {
        mDragged_m_00b(p0, 5);
    }

    //�}�E�X����?[�X----------------------------------------------------
    public void mReleased_A_21(Ten p0) {

        i_select_mode = 0;//  <-------20180919����?s�̓Z���N�g����??�̒[�_��I�Ԃ�?A�ړ��Ƃ��R�s?[����������Ɣ��f���邪?A���̑�??��?I������Ƃ��ɕK�v������ǉ�����?B
/*
		i_egaki_dankai=0;
		p.set(camera.TV2object(p0));
		moyori_ten.set(get_moyori_ten(p));

		if(p.kyori(moyori_ten)<=d_hantei_haba){
			s_step[1].seta(moyori_ten);
			if(s_step[1].getnagasa()>0.00000001){
				//��肽����??�͂�����?���

				double addx,addy;
				addx=-s_step[1].getbx()+s_step[1].getax();
				addy=-s_step[1].getby()+s_step[1].getay();

				Orisensyuugou ori_s_temp =new Orisensyuugou();    //�Z���N�g���ꂽ?�??�������?o�����߂Ɏg��
				ori_s_temp.setMemo(ori_s.getMemo_select_sentaku(2));//�Z���N�g���ꂽ?�??�������?o����ori_s_temp��??��
				ori_s.del_selected_senbun_hayai();//�Z���N�g���ꂽ?�??��???�����?B
				ori_s_temp.move(addx,addy);//�S�̂��ړ�����

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
            //��肽����??�͂�����?���

            double addx, addy;
            addx = -s_step[1].getbx() + s_step[1].getax();
            addy = -s_step[1].getby() + s_step[1].getay();

            Orisensyuugou ori_s_temp = new Orisensyuugou();    //�Z���N�g���ꂽ?�??�������?o�����߂Ɏg��
            ori_s_temp.setMemo(ori_s.getMemo_select_sentaku(2));//�Z���N�g���ꂽ?�??�������?o����ori_s_temp��??��
            ori_s.del_selected_senbun_hayai();//�Z���N�g���ꂽ?�??��???�����?B
            ori_s_temp.move(addx, addy);//�S�̂��ړ�����

            int sousuu_old = ori_s.getsousuu();
            ori_s.addMemo(ori_s_temp.getMemo());
            int sousuu_new = ori_s.getsousuu();
            ori_s.kousabunkatu(1, sousuu_old, sousuu_old + 1, sousuu_new);

            ori_s.unselect_all();
            kiroku();
        }


    }


//-------------------------

//22 22 22 22 22    i_mouse_modeA==22?@;�R�s�y��?[�h

    //�}�E�X�𓮂������Ƃ�
    public void mMoved_A_22(Ten p0) {
        mMoved_m_00b(p0, 5);
    }//�}�E�X�őI���ł�����_��\������?B�߂��Ɋ�?��̓_������Ƃ��͂��̓_?A�����Ƃ��̓}�E�X�̈ʒu��?g�����_�ƂȂ�?B

    //�}�E�X�N���b�N----------------------------------------------------
    public void mPressed_A_22(Ten p0) {
        mPressed_m_00b(p0, 5);
    }

    //�}�E�X�h���b�O----------------------------------------------------
    public void mDragged_A_22(Ten p0) {
        mDragged_m_00b(p0, 5);
    }

    //�}�E�X����?[�X----------------------------------------------------
    public void mReleased_A_22(Ten p0) {

        i_select_mode = 0;//  <-------20180919����?s�̓Z���N�g����??�̒[�_��I�Ԃ�?A�ړ��Ƃ��R�s?[����������Ɣ��f���邪?A���̑�??��?I������Ƃ��ɕK�v������ǉ�����?B
/*
		i_egaki_dankai=0;
		p.set(camera.TV2object(p0));
		moyori_ten.set(get_moyori_ten(p));

		if(p.kyori(moyori_ten)<=d_hantei_haba){
			s_step[1].seta(moyori_ten);
			if(s_step[1].getnagasa()>0.00000001){
				//��肽����??�͂�����?���

				double addx,addy;
				addx=-s_step[1].getbx()+s_step[1].getax();
				addy=-s_step[1].getby()+s_step[1].getay();

				Orisensyuugou ori_s_temp =new Orisensyuugou();    //�Z���N�g���ꂽ?�??�������?o�����߂Ɏg��
				ori_s_temp.setMemo(ori_s.getMemo_select_sentaku(2));//�Z���N�g���ꂽ?�??�������?o����ori_s_temp��??��
				//ori_s.del_selected_senbun_hayai();//�Z���N�g���ꂽ?�??��???�����?Bmove��?@copy�̈Ⴂ�͂���?s���L�����ǂ����̈Ⴂ
				ori_s_temp.move(addx,addy);//�S�̂��ړ�����

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
            //��肽����??�͂�����?���

            double addx, addy;
            addx = -s_step[1].getbx() + s_step[1].getax();
            addy = -s_step[1].getby() + s_step[1].getay();

            Orisensyuugou ori_s_temp = new Orisensyuugou();    //�Z���N�g���ꂽ?�??�������?o�����߂Ɏg��
            ori_s_temp.setMemo(ori_s.getMemo_select_sentaku(2));//�Z���N�g���ꂽ?�??�������?o����ori_s_temp��??��
            //ori_s.del_selected_senbun_hayai();//�Z���N�g���ꂽ?�??��???�����?Bmove��?@copy�̈Ⴂ�͂���?s���L�����ǂ����̈Ⴂ
            ori_s_temp.move(addx, addy);//�S�̂��ړ�����

            int sousuu_old = ori_s.getsousuu();
            ori_s.addMemo(ori_s_temp.getMemo());
            int sousuu_new = ori_s.getsousuu();
            ori_s.kousabunkatu(1, sousuu_old, sousuu_old + 1, sousuu_new);

            ori_s.unselect_all();
            kiroku();
        }

    }


//--------------------------------------------
//31 31 31 31 31 31 31 31  i_mouse_modeA==31move2p2p	���� 31 31 31 31 31 31 31 31

//��??�T�v?@
//i_mouse_modeA==1��??�������ȊO�͓���?@
//

    //�}�E�X��??(�}�E�X�𓮂������Ƃ�)��?s����??
    public void mMoved_A_31(Ten p0) {
        mMoved_A_11(p0);
    }//�߂������_�̂ݕ\��

    //�}�E�X��??(i_mouse_modeA==31move2p2p?@�Ń{�^�����������Ƃ�)����??��----------------------------------------------------
    public void mPressed_A_31(Ten p0) {
        p.set(camera.TV2object(p0));

        if (i_egaki_dankai == 0) {    //��1�i�K�Ƃ���?A�_��I��
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(5);
            }
            return;
        }

        if (i_egaki_dankai == 1) {    //��2�i�K�Ƃ���?A�_��I��
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) >= d_hantei_haba) {
                i_egaki_dankai = 0;
                i_select_mode = 0;//  <-------20180919����?s�̓Z���N�g����??�̒[�_��I�Ԃ�?A�ړ��Ƃ��R�s?[����������Ɣ��f���邪?A���̑�??��?I������Ƃ��ɕK�v������ǉ�����?B
                //�_�̑I�������s����???���i_select_mode=0�ɂ��Ȃ���?A�Z���N�g�̂��肪��??��?[�h��move2p2p�ɂȂ����܂܂ɂȂ�
                return;
            }
            if (p.kyori(moyori_ten) < d_hantei_haba) {

                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(i_egaki_dankai);

            }
            if (oc.kyori(s_step[1].geta(), s_step[2].geta()) < 0.00000001) {
                i_egaki_dankai = 0;
                i_select_mode = 0;//  <-------20180919����?s�̓Z���N�g����??�̒[�_��I�Ԃ�?A�ړ��Ƃ��R�s?[����������Ɣ��f���邪?A���̑�??��?I������Ƃ��ɕK�v������ǉ�����?B

            }
            return;
        }


        if (i_egaki_dankai == 2) {    //��3�i�K�Ƃ���?A�_��I��
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) >= d_hantei_haba) {
                i_egaki_dankai = 0;
                i_select_mode = 0;//  <-------20180919����?s�̓Z���N�g����??�̒[�_��I�Ԃ�?A�ړ��Ƃ��R�s?[����������Ɣ��f���邪?A���̑�??��?I������Ƃ��ɕK�v������ǉ�����?B

                return;

            }
            if (p.kyori(moyori_ten) < d_hantei_haba) {

                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(i_egaki_dankai);

            }
            return;
        }


        if (i_egaki_dankai == 3) {    //��4�i�K�Ƃ���?A�_��I��
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) >= d_hantei_haba) {
                i_egaki_dankai = 0;
                i_select_mode = 0;//  <-------20180919����?s�̓Z���N�g����??�̒[�_��I�Ԃ�?A�ړ��Ƃ��R�s?[����������Ɣ��f���邪?A���̑�??��?I������Ƃ��ɕK�v������ǉ�����?B
                return;
            }
            if (p.kyori(moyori_ten) < d_hantei_haba) {

                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(i_egaki_dankai);

            }
            if (oc.kyori(s_step[3].geta(), s_step[4].geta()) < 0.00000001) {
                i_egaki_dankai = 0;
                i_select_mode = 0;//  <-------20180919����?s�̓Z���N�g����??�̒[�_��I�Ԃ�?A�ړ��Ƃ��R�s?[����������Ɣ��f���邪?A���̑�??��?I������Ƃ��ɕK�v������ǉ�����?B

            }
            return;
        }


    }

    //�}�E�X��??(i_mouse_modeA==31move2p2p?@�Ńh���b�O�����Ƃ�)��?s����??----------------------------------------------------
    public void mDragged_A_31(Ten p0) {
    }

    //�}�E�X��??(i_mouse_modeA==31move2p2p?@�Ń{�^���𗣂����Ƃ�)��?s����??----------------------------------------------------
    public void mReleased_A_31(Ten p0) {
        if (i_egaki_dankai == 4) {
            i_egaki_dankai = 0;
            i_select_mode = 0;//  <-------20180919����?s�̓Z���N�g����??�̒[�_��I�Ԃ�?A�ړ��Ƃ��R�s?[����������Ɣ��f���邪?A���̑�??��?I������Ƃ��ɕK�v������ǉ�����?B

            //double addx,addy;
            //addx=s_step[1].getbx()-s_step[1].getax();
            //addy=s_step[1].getby()-s_step[1].getay();


            Orisensyuugou ori_s_temp = new Orisensyuugou();    //�Z���N�g���ꂽ?�??�������?o�����߂Ɏg��
            ori_s_temp.setMemo(ori_s.getMemo_select_sentaku(2));//�Z���N�g���ꂽ?�??�������?o����ori_s_temp��??��
            ori_s.del_selected_senbun_hayai();//�Z���N�g���ꂽ?�??��???�����?B
            ori_s_temp.move(s_step[1].geta(), s_step[2].geta(), s_step[3].geta(), s_step[4].geta());//�S�̂��ړ�����

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
//32 32 32 32 32 32 32 32  i_mouse_modeA==32copy2p2p	���� 32 32 32 32 32 32 32 32

//��??�T�v?@
//i_mouse_modeA==1��??�������ȊO�͓���?@
//

    //�}�E�X��??(�}�E�X�𓮂������Ƃ�)��?s����??
    public void mMoved_A_32(Ten p0) {
        mMoved_A_11(p0);
    }//�߂������_�̂ݕ\��

    //�}�E�X��??(i_mouse_modeA==32copy2p2p2p2p?@�Ń{�^�����������Ƃ�)����??��----------------------------------------------------
    public void mPressed_A_32(Ten p0) {
        p.set(camera.TV2object(p0));

        if (i_egaki_dankai == 0) {    //��1�i�K�Ƃ���?A�_��I��
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(5);
            }
            return;
        }

        if (i_egaki_dankai == 1) {    //��2�i�K�Ƃ���?A�_��I��
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) >= d_hantei_haba) {
                i_egaki_dankai = 0;
                i_select_mode = 0;//  <-------20180919����?s�̓Z���N�g����??�̒[�_��I�Ԃ�?A�ړ��Ƃ��R�s?[����������Ɣ��f���邪?A���̑�??��?I������Ƃ��ɕK�v������ǉ�����?B
                return;
            }
            if (p.kyori(moyori_ten) < d_hantei_haba) {

                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(i_egaki_dankai);

            }
            if (oc.kyori(s_step[1].geta(), s_step[2].geta()) < 0.00000001) {
                i_egaki_dankai = 0;
                i_select_mode = 0;//  <-------20180919����?s�̓Z���N�g����??�̒[�_��I�Ԃ�?A�ړ��Ƃ��R�s?[����������Ɣ��f���邪?A���̑�??��?I������Ƃ��ɕK�v������ǉ�����?B
            }
            return;
        }


        if (i_egaki_dankai == 2) {    //��3�i�K�Ƃ���?A�_��I��
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) >= d_hantei_haba) {
                i_egaki_dankai = 0;
                i_select_mode = 0;//  <-------20180919����?s�̓Z���N�g����??�̒[�_��I�Ԃ�?A�ړ��Ƃ��R�s?[����������Ɣ��f���邪?A���̑�??��?I������Ƃ��ɕK�v������ǉ�����?B
                return;
            }
            if (p.kyori(moyori_ten) < d_hantei_haba) {

                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(i_egaki_dankai);

            }
            return;
        }


        if (i_egaki_dankai == 3) {    //��4�i�K�Ƃ���?A�_��I��
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) >= d_hantei_haba) {
                i_egaki_dankai = 0;
                i_select_mode = 0;//  <-------20180919����?s�̓Z���N�g����??�̒[�_��I�Ԃ�?A�ړ��Ƃ��R�s?[����������Ɣ��f���邪?A���̑�??��?I������Ƃ��ɕK�v������ǉ�����?B
                return;
            }
            if (p.kyori(moyori_ten) < d_hantei_haba) {

                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(i_egaki_dankai);

            }
            if (oc.kyori(s_step[3].geta(), s_step[4].geta()) < 0.00000001) {
                i_egaki_dankai = 0;
                i_select_mode = 0;//  <-------20180919����?s�̓Z���N�g����??�̒[�_��I�Ԃ�?A�ړ��Ƃ��R�s?[����������Ɣ��f���邪?A���̑�??��?I������Ƃ��ɕK�v������ǉ�����?B
            }
            return;
        }


    }

    //�}�E�X��??(i_mouse_modeA==32copy2p2p?@�Ńh���b�O�����Ƃ�)��?s����??----------------------------------------------------
    public void mDragged_A_32(Ten p0) {
    }

    //�}�E�X��??(i_mouse_modeA==32copy2p2pp?@�Ń{�^���𗣂����Ƃ�)��?s����??----------------------------------------------------
    public void mReleased_A_32(Ten p0) {
        if (i_egaki_dankai == 4) {
            i_egaki_dankai = 0;
            i_select_mode = 0;//  <-------20180919����?s�̓Z���N�g����??�̒[�_��I�Ԃ�?A�ړ��Ƃ��R�s?[����������Ɣ��f���邪?A���̑�??��?I������Ƃ��ɕK�v������ǉ�����?B
            //double addx,addy;
            //addx=s_step[1].getbx()-s_step[1].getax();
            //addy=s_step[1].getby()-s_step[1].getay();


            Orisensyuugou ori_s_temp = new Orisensyuugou();    //�Z���N�g���ꂽ?�??�������?o�����߂Ɏg��
            ori_s_temp.setMemo(ori_s.getMemo_select_sentaku(2));//�Z���N�g���ꂽ?�??�������?o����ori_s_temp��??��
            //ori_s.del_selected_senbun_hayai();//�Z���N�g���ꂽ?�??��???�����?B
            ori_s_temp.move(s_step[1].geta(), s_step[2].geta(), s_step[3].geta(), s_step[4].geta());//�S�̂��ړ�����

            int sousuu_old = ori_s.getsousuu();
            ori_s.addMemo(ori_s_temp.getMemo());
            int sousuu_new = ori_s.getsousuu();
            ori_s.kousabunkatu(1, sousuu_old, sousuu_old + 1, sousuu_new);

            //ori_s.unselect_all();
            kiroku();
        }
    }

//  ********************************************

    //12 12 12 12 12    i_mouse_modeA==12?@;���f��?[�h
    //�}�E�X��??(�}�E�X�𓮂������Ƃ�)��?s����??
    public void mMoved_A_12(Ten p0) {
        mMoved_A_11(p0);
    }//�߂������_�̂ݕ\��

    //�}�E�X��??(i_mouse_modeA==12���f��?[�h?@�Ń{�^�����������Ƃ�)����??��----------------------------------------------------
    public void mPressed_A_12(Ten p0) {

        p.set(camera.TV2object(p0));


        if (i_egaki_dankai == 0) {    //��1�i�K�Ƃ���?A�_��I��


            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(5);

                //s_step[i_egaki_dankai].set(moyori_senbun);        s_step[i_egaki_dankai].setcolor(5);

            }
            return;
        }

        if (i_egaki_dankai == 1) {    //��2�i�K�Ƃ���?A�_��I��
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) >= d_hantei_haba) {
                i_egaki_dankai = 0;
                i_select_mode = 0;//  <-------20180919����?s�̓Z���N�g����??�̒[�_��I�Ԃ�?A�ړ��Ƃ��R�s?[����������Ɣ��f���邪?A���̑�??��?I������Ƃ��ɕK�v������ǉ�����?B
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
                i_select_mode = 0;//  <-------20180919����?s�̓Z���N�g����??�̒[�_��I�Ԃ�?A�ړ��Ƃ��R�s?[����������Ɣ��f���邪?A���̑�??��?I������Ƃ��ɕK�v������ǉ�����?B
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

    //�}�E�X��??(i_mouse_modeA==12���f��?[�h?@�Ńh���b�O�����Ƃ�)��?s����??----------------------------------------------------
    public void mDragged_A_12(Ten p0) {

        //Ten p =new Ten(); p.set(camera.TV2object(p0));
        //s_step[1].seta(p);

        //k.seta(ieda, p);
    }

    //�}�E�X��??(i_mouse_modeA==12���f��?[�h?@�Ń{�^���𗣂����Ƃ�)��?s����??----------------------------------------------------
    public void mReleased_A_12(Ten p0) {
        Senbun adds = new Senbun();
        //Orisensyuugou ori_s_temp =new Orisensyuugou();
        if (i_egaki_dankai == 2) {
            i_egaki_dankai = 0;
            i_select_mode = 0;//  <-------20180919����?s�̓Z���N�g����??�̒[�_��I�Ԃ�?A�ړ��Ƃ��R�s?[����������Ɣ��f���邪?A���̑�??��?I������Ƃ��ɕK�v������ǉ�����?B
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


//34 34 34 34 34 34 34 34 34 34 34���͂���??����?d�����Ă���?�??��?��ɎR�J�ɂ���


    public void mMoved_A_34(Ten p0) {
        mMoved_A_11(p0);
    }//�߂������_�̂ݕ\��

    //�}�E�X��??(i_mouse_modeA==34?@�Ń{�^�����������Ƃ�)����??��----------------------------------------------------
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

    //�}�E�X��??(i_mouse_modeA==34?@�Ńh���b�O�����Ƃ�)��?s����??----------------------------------------------------
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

    //�}�E�X��??(i_mouse_modeA==34?@�Ń{�^���𗣂����Ƃ�)��?s����??----------------------------------------------------
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


//36 36 36 36 36 36 36 36 36 36 36���͂���??����X��?����Ă���?�??��?��ɎR�J�ɂ���


    //�}�E�X��??(�}�E�X�𓮂������Ƃ�)��?s����??
    public void mMoved_A_36(Ten p0) {
        mMoved_A_28(p0);
    }//�߂������_�̂ݕ\��


    //�}�E�X��??(i_mouse_modeA==36?@�Ń{�^�����������Ƃ�)����??��----------------------------------------------------
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

    //�}�E�X��??(i_mouse_modeA==36?@�Ńh���b�O�����Ƃ�)��?s����??----------------------------------------------------

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

    //�}�E�X��??(i_mouse_modeA==36?@�Ń{�^���𗣂����Ƃ�)��?s����??----------------------------------------------------
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
//13 13 13 13 13 13    i_mouse_modeA==13?@;�p�x�n��?[�h//??���w��?A��_�܂�

    //�}�E�X��??(�{�^�����������Ƃ�)����??��
    public void mPressed_A_13(Ten p0) {

        int honsuu = 0;//1�̒[�_����ɕ`��??�̖{??
        if (id_kakudo_kei != 0) {
            honsuu = id_kakudo_kei * 2 - 1;
        } else if (id_kakudo_kei == 0) {
            honsuu = 6;
        }

        int i_jyunnbi_step_suu = 1;//��??��??���Ƃ���?l�Ԃ��I������X�e�b�v??

        //Ten p =new Ten();
        p.set(camera.TV2object(p0));

        if (i_egaki_dankai == 0) {    //��P�i�K�Ƃ���?A??����I��
            moyori_senbun.set(get_moyori_senbun(p));
            if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {
                i_egaki_dankai = 1;
                s_step[1].set(moyori_senbun);
                s_step[1].setcolor(5);
            }
        }

        if (i_egaki_dankai == i_jyunnbi_step_suu) {    //if(i_egaki_dankai==1){        //��??��??���Ƃ���?l�Ԃ��I������X�e�b�v?���?I�����?�ԂŎ�?s
            int i_jyun;//i_jyun��??��`���Ƃ�?��Ԃ�?F��ς������Ƃ��g��
            //??��ab��a��?S��d�x��]����??����Ԃ���???i����??���͕ς�����?V����??����Ԃ�?jpublic oc.Senbun_kaiten(Senbun s0,double d) //    double d_kakudo_kei;double kakudo;

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


        if (i_egaki_dankai == i_jyunnbi_step_suu + (honsuu) + (honsuu)) {//19     //��??��??���Ƃ��ă\�t�g���ԓ�����X�e�b�v?���?I�����?�ԂŎ�?s

            int i_tikai_s_step_suu = 0;

            //s_step[2����10]�܂ł�s_step[11����19]�܂�
            moyori_senbun.set(get_moyori_step_senbun(p, 2, 1 + (honsuu)));
            if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                i_tikai_s_step_suu = i_tikai_s_step_suu + 1;
                s_step[i_egaki_dankai].set(moyori_senbun);    //s_step[i_egaki_dankai].setcolor(2);//s_step[20]��input
            }

            //s_step[2����10]�܂ł�s_step[11����19]�܂�
            moyori_senbun.set(get_moyori_step_senbun(p, 1 + (honsuu) + 1, 1 + (honsuu) + (honsuu)));
            if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                i_tikai_s_step_suu = i_tikai_s_step_suu + 1;
                s_step[i_egaki_dankai].set(moyori_senbun);    //s_step[i_egaki_dankai].setcolor(icol);
            }

            if (i_tikai_s_step_suu == 2) { //���̒i�K��s_step��[21]�܂ł��܂��Ă���?As_step[20]��s_step[21]�͋��ɉ�����?�??�Ȃ̂�?A������????��?I���Ă��܂�?B
                //=     1+ (honsuu) +(honsuu) +  2 ){i_egaki_dankai=0; //���̒i�K��s_step��[21]�܂ł��܂��Ă���?As_step[20]��s_step[21]�͋��ɉ�����?�??�Ȃ̂�?A������????��?I���Ă��܂�?B
                //��O????�Ƃ���s_step[20]��s_step[21]����?s��?????A���߂��ق���s_step��[20]�Ƃ�?As_step��[20]�Ƃ��ă��^?[��?i����???��͂܂�????��?I���Ȃ�?j?B
                //�Q��??������?s���ǂ����𔻒肷���???Boc.heikou_hantei(Tyokusen t1,Tyokusen t2)//0=��?s�łȂ�?A1=��?s�łQ��??����v���Ȃ�?A2=��?s�łQ��??����v����
                //0=��?s�łȂ�?A1=��?s�łQ��??����v���Ȃ�?A2=��?s�łQ��??����v����

                if (oc.heikou_hantei(s_step[i_egaki_dankai - 1], s_step[i_egaki_dankai], 0.1) != 0) {//�����͈��S������臒l��0.1�Ƒ�ڂɂƂ��Ă����̂��悳����

                    //s_step[20]��s_step[21]�Ɠ_p�̋���  //public double kyori_senbun(Ten p0,Senbun s)
                    //if(oc.kyori_senbun(p, s_step[1+     (honsuu) +(honsuu)   +1]) >  oc.kyori_senbun(p, s_step[1+     (honsuu) +(honsuu)   +1+1])          ){
                    //     s_step[1+     (honsuu) +(honsuu)   +1].set(  s_step[1+     (honsuu) +(honsuu)   +1+1]                   )    ;
                    //}

                    //i_egaki_dankai=i_egaki_dankai-1;
                    //i_egaki_dankai=i_egaki_dankai-2;
                    i_egaki_dankai = 0;
                    return;
                }


                i_egaki_dankai = 0;

                //s_step[20]��s_step[21]�̌�_��oc.kouten_motome(Senbun s1,Senbun s2)��??�߂�//�Q��??����??�Ƃ݂Ȃ��Č�_��??�߂��???B??���Ƃ��Ă͌�?����Ȃ��Ă�?A��??�Ƃ��Č�?����Ă���???��̌�_��Ԃ�
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

    //�}�E�X��??(�h���b�O�����Ƃ�)��?s����??
    public void mDragged_A_13(Ten p0) {
    }

    //�}�E�X��??(�{�^���𗣂����Ƃ�)��?s����??
    public void mReleased_A_13(Ten p0) {
    }

//------


//--------------------------------------------------------------------------------
//17 17 17 17 17 17    i_mouse_modeA==17?@;�p�x�n��?[�h

    //�}�E�X��??(�}�E�X�𓮂������Ƃ�)��?s����??
    public void mMoved_A_17(Ten p0) {
        if (i_egaki_dankai <= 1) {
            mMoved_A_11(p0);//�߂������_�̂ݕ\��
        }
    }


    //�}�E�X��??(�{�^�����������Ƃ�)����??��
    public void mPressed_A_17(Ten p0) {

        int honsuu = 0;//1�̒[�_����ɕ`��??�̖{??
        if (id_kakudo_kei != 0) {
            honsuu = id_kakudo_kei * 2 - 1;
        } else if (id_kakudo_kei == 0) {
            honsuu = 6;
        }

        int i_jyunnbi_step_suu = 2;//��??��??���Ƃ���?l�Ԃ��I������X�e�b�v??

        //Ten p =new Ten();
        p.set(camera.TV2object(p0));

        if (i_egaki_dankai == 0) {    //��1�i�K�Ƃ���?A�_��I��
            moyori_ten.set(get_moyori_ten(p));
            if (p.kyori(moyori_ten) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                s_step[i_egaki_dankai].set(moyori_ten, moyori_ten);
                s_step[i_egaki_dankai].setcolor(5);

                //s_step[i_egaki_dankai].set(moyori_senbun);        s_step[i_egaki_dankai].setcolor(5);

            }
            return;
        }

        if (i_egaki_dankai == 1) {    //��2�i�K�Ƃ���?A�_��I��
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

        if (i_egaki_dankai == i_jyunnbi_step_suu) {    //if(i_egaki_dankai==1){        //��??��??���Ƃ���?l�Ԃ��I������X�e�b�v?���?I�����?�ԂŎ�?s
            int i_jyun;//i_jyun��??��`���Ƃ�?��Ԃ�?F��ς������Ƃ��g��
            //??��ab��a��?S��d�x��]����??����Ԃ���???i����??���͕ς�����?V����??����Ԃ�?jpublic oc.Senbun_kaiten(Senbun s0,double d) //    double d_kakudo_kei;double kakudo;

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


        if (i_egaki_dankai == i_jyunnbi_step_suu + (honsuu) + (honsuu)) {//19     //��??��??���Ƃ��ă\�t�g���ԓ�����X�e�b�v?���?I�����?�ԂŎ�?s

            int i_tikai_s_step_suu = 0;

            //s_step[2����10]�܂ł�s_step[11����19]�܂�
            moyori_senbun.set(get_moyori_step_senbun(p, 3, 2 + (honsuu)));
            if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                i_tikai_s_step_suu = i_tikai_s_step_suu + 1;
                s_step[i_egaki_dankai].set(moyori_senbun);    //s_step[i_egaki_dankai].setcolor(2);//s_step[20]��input
            }

            //s_step[2����10]�܂ł�s_step[11����19]�܂�
            moyori_senbun.set(get_moyori_step_senbun(p, 2 + (honsuu) + 1, 2 + (honsuu) + (honsuu)));
            if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {
                i_egaki_dankai = i_egaki_dankai + 1;
                i_tikai_s_step_suu = i_tikai_s_step_suu + 1;
                s_step[i_egaki_dankai].set(moyori_senbun);    //s_step[i_egaki_dankai].setcolor(icol);
            }

            if (i_tikai_s_step_suu == 2) { //���̒i�K��s_step��[21]�܂ł��܂��Ă���?As_step[20]��s_step[21]�͋��ɉ�����?�??�Ȃ̂�?A������????��?I���Ă��܂�?B
                //=     1+ (honsuu) +(honsuu) +  2 ){i_egaki_dankai=0; //���̒i�K��s_step��[21]�܂ł��܂��Ă���?As_step[20]��s_step[21]�͋��ɉ�����?�??�Ȃ̂�?A������????��?I���Ă��܂�?B
                //��O????�Ƃ���s_step[20]��s_step[21]����?s��?????A���߂��ق���s_step��[20]�Ƃ�?As_step��[20]�Ƃ��ă��^?[��?i����???��͂܂�????��?I���Ȃ�?j?B
                //�Q��??������?s���ǂ����𔻒肷���???Boc.heikou_hantei(Tyokusen t1,Tyokusen t2)//0=��?s�łȂ�?A1=��?s�łQ��??����v���Ȃ�?A2=��?s�łQ��??����v����
                //0=��?s�łȂ�?A1=��?s�łQ��??����v���Ȃ�?A2=��?s�łQ��??����v����

                if (oc.heikou_hantei(s_step[i_egaki_dankai - 1], s_step[i_egaki_dankai], 0.1) != 0) {//�����͈��S������臒l��0.1�Ƒ�ڂɂƂ��Ă����̂��悳����

                    //s_step[20]��s_step[21]�Ɠ_p�̋���  //public double kyori_senbun(Ten p0,Senbun s)
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

                //s_step[20]��s_step[21]�̌�_��oc.kouten_motome(Senbun s1,Senbun s2)��??�߂�//�Q��??����??�Ƃ݂Ȃ��Č�_��??�߂��???B??���Ƃ��Ă͌�?����Ȃ��Ă�?A��??�Ƃ��Č�?����Ă���???��̌�_��Ԃ�
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

    //�}�E�X��??(�h���b�O�����Ƃ�)��?s����??
    public void mDragged_A_17(Ten p0) {
    }

    //�}�E�X��??(�{�^���𗣂����Ƃ�)��?s����??
    public void mReleased_A_17(Ten p0) {
    }

//------


//VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV

//16 16 16 16 16 16    i_mouse_modeA==16?@;�p�x�n��?[�h

    //�}�E�X��??(�}�E�X�𓮂������Ƃ�)��?s����??
    public void mMoved_A_16(Ten p0) {
        mMoved_A_17(p0);
    }


    //�}�E�X��??(�{�^�����������Ƃ�)����??��
    public void mPressed_A_16(Ten p0) {

        int honsuu = 0;//1�̒[�_����ɕ`��??�̖{??
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
            //??��ab��a��?S��d�x��]����??����Ԃ���???i����??���͕ς�����?V����??����Ԃ�?jpublic oc.Senbun_kaiten(Senbun s0,double d)


            if (id_kakudo_kei != 0) {
                d_kakudo_kei = 180.0 / (double) id_kakudo_kei;
            } else if (id_kakudo_kei == 0) {
                d_kakudo_kei = 180.0 / 4.0;
            }

            if (id_kakudo_kei != 0) {


                Senbun s_kiso = new Senbun(s_step[2].geta(), s_step[1].geta());
                kakudo = 0.0;

                int i_jyun;
                i_jyun = 0;//i_jyun��??��`���Ƃ�?��Ԃ�?F��ς������Ƃ��g��
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
            if (oc.kyori_senbun(p, moyori_senbun) >= d_hantei_haba) {//?Ŋ�?�??����������????
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

            //s_step[12]��s_step[13]�̌�_��oc.kouten_motome(Senbun s1,Senbun s2)��??�߂�//�Q��??����??�Ƃ݂Ȃ��Č�_��??�߂��???B??���Ƃ��Ă͌�?����Ȃ��Ă�?A��??�Ƃ��Č�?����Ă���???��̌�_��Ԃ�
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

    //�}�E�X��??(�h���b�O�����Ƃ�)��?s����??
    public void mDragged_A_16(Ten p0) {
    }

    //�}�E�X��??(�{�^���𗣂����Ƃ�)��?s����??
    public void mReleased_A_16(Ten p0) {
    }

//------


//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA

//VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV

//18 18 18 18 18 18    i_mouse_modeA==18?@;�p�x�n��?[�h

    //�}�E�X��??(�}�E�X�𓮂������Ƃ�)��?s����??
    public void mMoved_A_18(Ten p0) {
        mMoved_A_17(p0);
    }

    //�}�E�X��??(�{�^�����������Ƃ�)����??��
    public void mPressed_A_18(Ten p0) {

        int honsuu = 0;//1�̒[�_����ɕ`��??�̖{??
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
            //??��ab��a��?S��d�x��]����??����Ԃ���???i����??���͕ς�����?V����??����Ԃ�?jpublic oc.Senbun_kaiten(Senbun s0,double d)

            if (id_kakudo_kei != 0) {
                d_kakudo_kei = 180.0 / (double) id_kakudo_kei;
            } else if (id_kakudo_kei == 0) {
                d_kakudo_kei = 180.0 / 4.0;
            }


            if (id_kakudo_kei != 0) {
                Senbun s_kiso = new Senbun(s_step[2].geta(), s_step[1].geta());
                kakudo = 0.0;

                int i_jyun;
                i_jyun = 0;//i_jyun��??��`���Ƃ�?��Ԃ�?F��ς������Ƃ��g��
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
                if (oc.kyori_senbun(p, moyori_senbun) < d_hantei_haba) {//?Ŋ�?�??���߂�????
                    if (oc.heikou_hantei(moyori_step_senbun, moyori_senbun, 0.000001) == 0) {//?Ŋ�?�??��?Ŋ�step?�??�ƕ�?s��???���?��O
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

			//s_step[12]��s_step[13]�̌�_��oc.kouten_motome(Senbun s1,Senbun s2)��??�߂�//�Q��??����??�Ƃ݂Ȃ��Č�_��??�߂��???B??���Ƃ��Ă͌�?����Ȃ��Ă�?A��??�Ƃ��Č�?����Ă���???��̌�_��Ԃ�
//			Ten kousa_ten =new Ten(); kousa_ten.set(oc.kouten_motome(s_step[12],s_step[13]));
			Ten kousa_ten =new Ten(); kousa_ten.set(oc.kouten_motome(s_step[2+ (honsuu)  +1 ],s_step[2+ (honsuu)  +1  +1]));
			Senbun add_sen =new Senbun(kousa_ten,s_step[2].geta());
			if(add_sen.getnagasa()>0.00000001){addsenbun(add_sen);kiroku();}
			return;
	*/
        }


    }

    //�}�E�X��??(�h���b�O�����Ƃ�)��?s����??
    public void mDragged_A_18(Ten p0) {
    }

    //�}�E�X��??(�{�^���𗣂����Ƃ�)��?s����??
    public void mReleased_A_18(Ten p0) {
    }

//------


//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA


//14 14 14 14 14 14 14 14 14    i_mouse_modeA==14?@;V�ǉ���?[�h

    //�}�E�X��??(�{�^�����������Ƃ�)����??��
    public void mPressed_A_14(Ten p0) {
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        int mts_id;
        mts_id = ori_s.mottomo_tikai_senbun_sagasi(p);//mts_id�͓_p��?ł��߂�??���̔�??	public int ori_s.mottomo_tikai_senbun_sagasi(Ten p)
        Senbun mts = new Senbun(ori_s.geta(mts_id), ori_s.getb(mts_id));//mts�͓_p��?ł��߂�??��

        if (oc.kyori_senbun(p, mts) < d_hantei_haba) {
            //��??t?�̓_p�̉e�̈ʒu?i�_p��?ł��߂���??t?�̈ʒu?j��??�߂�?Bpublic Ten oc.kage_motome(Tyokusen t,Ten p){}
            //??�����܂ޒ�??�𓾂� public Tyokusen oc.Senbun2Tyokusen(Senbun s){}
            Ten pk = new Ten();
            pk.set(oc.kage_motome(oc.Senbun2Tyokusen(mts), p));//pk�͓_p��?i??�����܂ޒ�???��?j�e

            //�_pa��?A��_p1,p2��[�_�Ƃ���??���ɓ_p1�Ɠ_p2�Œ�?s����?A2��??�����܂ޒ����`���ɂ���???���2��Ԃ���??	public int oc.hakononaka(Ten p1,Ten pa,Ten p2){}

            if (oc.hakononaka(mts.geta(), pk, mts.getb()) == 2) {
                //??���̕���-----------------------------------------
                ori_s.senbun_bunkatu(mts_id, pk);  //i�Ԗڂ�??��(�[�_a��b)��_p�ŕ�������?Bi�Ԗڂ�??��ab��ap�ɕς�?A??��pb��������?B
                kiroku();
            }

        }
        return;

    }

    //�}�E�X��??(�h���b�O�����Ƃ�)��?s����??
    public void mDragged_A_14(Ten p0) {
    }

    //�}�E�X��??(�{�^���𗣂����Ƃ�)��?s����??
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

//15 15 15 15 15 15 15 15 15    i_mouse_modeA==15?@;V???��??[�h

    //�}�E�X��??(�{�^�����������Ƃ�)����??��
    public void mPressed_A_15(Ten p0) {


        //Ten p =new Ten();
        p.set(camera.TV2object(p0));

        //�_p��?ł��߂�??����?A�_p�ɋ߂����̒[�_��?A���_�Ƃ���?????A���{��??����?o�Ă��邩?i���_��r�ȓ��ɒ[�_������??����???j	public int tyouten_syuui_sennsuu(Ten p) {

        ori_s.del_V(p, d_hantei_haba, 0.000001);
        kiroku();


    }

    //�}�E�X��??(�h���b�O�����Ƃ�)��?s����??
    public void mDragged_A_15(Ten p0) {
    }

    //�}�E�X��??(�{�^���𗣂����Ƃ�)��?s����??
    public void mReleased_A_15(Ten p0) {
    }


//------

//41 41 41 41 41 41 41 41    i_mouse_modeA==41?@;V???��??[�h(2��?�??��?F�������???��J��?[�`�F���W����?A�_???�����?B???Ԃ�?�?�?A???�?�?�?A?�?Ԃ�?��ɂ���)

    //�}�E�X��??(�{�^�����������Ƃ�)����??��
    public void mPressed_A_41(Ten p0) {


        //Ten p =new Ten();
        p.set(camera.TV2object(p0));

        //�_p��?ł��߂�??����?A�_p�ɋ߂����̒[�_��?A���_�Ƃ���?????A���{��??����?o�Ă��邩?i���_��r�ȓ��ɒ[�_������??����???j	public int tyouten_syuui_sennsuu(Ten p) {

        ori_s.del_V_cc(p, d_hantei_haba, 0.000001);


        kiroku();


    }

    //�}�E�X��??(�h���b�O�����Ƃ�)��?s����??
    public void mDragged_A_41(Ten p0) {
    }

    //�}�E�X��??(�{�^���𗣂����Ƃ�)��?s����??
    public void mReleased_A_41(Ten p0) {
    }


//------


    //-------------------------
//23 23 23 23 23
    //�}�E�X��??(i_mouse_modeA==23 "->M" �Ń{�^�����������Ƃ�)����??��----------------------------------------------------
    public void mPressed_A_23(Ten p0) {
        mPressed_A_box_select(p0);
    }

    //�}�E�X��??(i_mouse_modeA==23�Ńh���b�O�����Ƃ�)��?s����??----------------------------------------------------
    public void mDragged_A_23(Ten p0) {
        mDragged_A_box_select(p0);
    }

    //�}�E�X��??(i_mouse_modeA==23 �Ń{�^���𗣂����Ƃ�)��?s����??----------------------------------------------------
    public void mReleased_A_23(Ten p0) {//������????��?I���� fix2(0.001,0.5);?@������̂�?A������?�??���������̂�?A��????����ϊ�����?�??�Ƃ̑g?����ŕp������T���^�s?ڑ���?C?����邽��
        i_egaki_dankai = 0;

        if (p19_1.kyori(p0) > 0.000001) {//��?�ł�?Ԃ�?Ԃɕς����Ƃ���UNDO�p�ɋL�^����Ă��܂�20161218
            if (M_nisuru(p19_1, p0) != 0) {
                fix2(0.001, 0.5);
                kiroku();
            }
        }
        if (p19_1.kyori(p0) <= 0.000001) {//��?�ł�?Ԃ�?Ԃɕς����Ƃ���UNDO�p�ɋL�^����Ă��܂�20161218
            //Ten p =new Ten();
            p.set(camera.TV2object(p0));
            if (ori_s.mottomo_tikai_senbun_kyori(p) < d_hantei_haba) {//�_p��?ł��߂�??���̔�??�ł�?A���̋�����Ԃ�	public double mottomo_tikai_senbun_kyori(Ten p)
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
    //�}�E�X��??(i_mouse_modeA==24 "->V" �Ń{�^�����������Ƃ�)����??��----------------------------------------------------
    public void mPressed_A_24(Ten p0) {
        mPressed_A_box_select(p0);
    }

    //�}�E�X��??(i_mouse_modeA==24�Ńh���b�O�����Ƃ�)��?s����??----------------------------------------------------
    public void mDragged_A_24(Ten p0) {
        mDragged_A_box_select(p0);
    }

    //�}�E�X��??(i_mouse_modeA==24 �Ń{�^���𗣂����Ƃ�)��?s����??----------------------------------------------------
    public void mReleased_A_24(Ten p0) {//������????��?I���� fix2(0.001,0.5);?@������̂�?A������?�??���������̂�?A��????����ϊ�����?�??�Ƃ̑g?����ŕp������T���^�s?ڑ���?C?����邽��
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
            if (ori_s.mottomo_tikai_senbun_kyori(p) < d_hantei_haba) {//�_p��?ł��߂�??���̔�??�ł�?A���̋�����Ԃ�	public double mottomo_tikai_senbun_kyori(Ten p)
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
    //�}�E�X��??(i_mouse_modeA==25 "->E" �Ń{�^�����������Ƃ�)����??��----------------------------------------------------
    public void mPressed_A_25(Ten p0) {
        mPressed_A_box_select(p0);
    }

    //�}�E�X��??(i_mouse_modeA==25�Ńh���b�O�����Ƃ�)��?s����??----------------------------------------------------
    public void mDragged_A_25(Ten p0) {
        mDragged_A_box_select(p0);
    }

    //�}�E�X��??(i_mouse_modeA==25 �Ń{�^���𗣂����Ƃ�)��?s����??----------------------------------------------------
    public void mReleased_A_25(Ten p0) {//������????��?I���� fix2(0.001,0.5);?@������̂�?A������?�??���������̂�?A��????����ϊ�����?�??�Ƃ̑g?����ŕp������T���^�s?ڑ���?C?����邽��
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
            if (ori_s.mottomo_tikai_senbun_kyori(p) < d_hantei_haba) {//�_p��?ł��߂�??���̔�??�ł�?A���̋�����Ԃ�	public double mottomo_tikai_senbun_kyori(Ten p)
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
    //�}�E�X��??(i_mouse_modeA==60 "->HK" �Ń{�^�����������Ƃ�)����??��----------------------------------------------------
    public void mPressed_A_60(Ten p0) {
        mPressed_A_box_select(p0);
    }

    //�}�E�X��??(i_mouse_modeA==60�Ńh���b�O�����Ƃ�)��?s����??----------------------------------------------------
    public void mDragged_A_60(Ten p0) {
        mDragged_A_box_select(p0);
    }

    //�}�E�X��??(i_mouse_modeA==60 �Ń{�^���𗣂����Ƃ�)��?s����??----------------------------------------------------
    public void mReleased_A_60(Ten p0) {
        i_egaki_dankai = 0;

        if (p19_1.kyori(p0) > 0.000001) {
            if (HK_nisuru(p19_1, p0) != 0) {
                kiroku();
            }//���̊�?��͕s���S�Ȃ̂ł܂������J20171126
        }

        if (p19_1.kyori(p0) <= 0.000001) {
            //Ten p =new Ten();
            p.set(camera.TV2object(p0));
            if (ori_s.mottomo_tikai_senbun_kyori(p) < d_hantei_haba) {//�_p��?ł��߂�??���̔�??�ł�?A���̋�����Ԃ�	public double mottomo_tikai_senbun_kyori(Ten p)
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


//26 26 26 26    i_mouse_modeA==26?@;�w�iset��?[�h?B

    //�}�E�X��??(�{�^�����������Ƃ�)����??��
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

    //�}�E�X��??(�h���b�O�����Ƃ�)��?s����??
    public void mDragged_A_26(Ten p0) {
    }

    //�}�E�X��??(�{�^���𗣂����Ƃ�)��?s����??
    public int mReleased_A_26(Ten p0) {
        return i_egaki_dankai;
    }

//------


//42 42 42 42 42 42 42 42 42 42 42 42 42 42 42?@��������

    //�}�E�X��??(i_mouse_modeA==42 �~����?@�Ń{�^�����������Ƃ�)����??��----------------------------------------------------
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

    //�}�E�X��??(i_mouse_modeA==42 �~����?@�Ńh���b�O�����Ƃ�)��?s����??----------------------------------------------------
    public void mDragged_A_42(Ten p0) {

        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        s_step[1].seta(p);
        e_step[1].setr(oc.kyori(s_step[1].geta(), s_step[1].getb()));

        //k.seta(ieda, p);
    }

    //�}�E�X��??(i_mouse_modeA==42 �~����?@�Ń{�^���𗣂����Ƃ�)��?s����??----------------------------------------------------
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

//42 42 42 42 42 42 42 42 42 42 42 42 42 42 42  �����܂�


//47 47 47 47 47 47 47 47 47 47 47 47 47 47 47?@��������

    //�}�E�X��??(i_mouse_modeA==47 �~����(�t��?[?@)?@�Ń{�^�����������Ƃ�)����??��----------------------------------------------------
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

    //�}�E�X��??(i_mouse_modeA==47 �~����?@�Ńh���b�O�����Ƃ�)��?s����??----------------------------------------------------
    public void mDragged_A_47(Ten p0) {
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        s_step[1].seta(p);
        e_step[1].setr(oc.kyori(s_step[1].geta(), s_step[1].getb()));
    }

    //�}�E�X��??(i_mouse_modeA==47 �~����?@�Ń{�^���𗣂����Ƃ�)��?s����??----------------------------------------------------
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

//47 47 47 47 47 47 47 47 47 47 47 47 47 47 47  �����܂�


//44 44 44 44 44 44 44 44 44 44 44 44 44 44 44?@��������

    //�}�E�X��??(i_mouse_modeA==44 �~ ��������?@�Ń{�^�����������Ƃ�)����??��----------------------------------------------------
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

    //�}�E�X��??(i_mouse_modeA==44 �~ ��������?@�Ńh���b�O�����Ƃ�)��?s����??----------------------------------------------------
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

    //�}�E�X��??(i_mouse_modeA==44 �~ ��������?@�Ń{�^���𗣂����Ƃ�)��?s����??----------------------------------------------------
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

//44 44 44 44 44 44 44 44 44 44 44 44 44 44 44  �����܂�


//48 48 48 48 48 48 48 48 48 48 48 48 48 48 48?@��������

    //�}�E�X��??(i_mouse_modeA==48 ��?S�~?@??������?@�Ń{�^�����������Ƃ�)����??��----------------------------------------------------
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

    //�}�E�X��??(i_mouse_modeA==48 ��?S�~?@??������?@�Ńh���b�O�����Ƃ�)��?s����??----------------------------------------------------
    public void mDragged_A_48(Ten p0) {
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));
        if ((i_egaki_dankai == 1) && (i_en_egaki_dankai == 2)) {
            s_step[1].seta(p);
            e_step[2].setr(e_step[1].getr() + s_step[1].getnagasa());
        }
    }

    //�}�E�X��??(i_mouse_modeA==48 ��?S�~?@??������?@�Ń{�^���𗣂����Ƃ�)��?s����??----------------------------------------------------
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

//48 48 48 48 48 48 48 48 48 48 48 48 48 48 48  �����܂�

//49 49 49 49 49 49 49 49 49 49 49 49 49 49 49?@��������

    //�}�E�X��??(i_mouse_modeA==49 ��?S�~?@��?S�~����?@�Ń{�^�����������Ƃ�)����??��----------------------------------------------------
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

    //�}�E�X��??(i_mouse_modeA==49 ��?S�~?@��?S�~����?@�Ńh���b�O�����Ƃ�)��?s����??----------------------------------------------------
    public void mDragged_A_49(Ten p0) {

    }

    //�}�E�X��??(i_mouse_modeA==49 ��?S�~?@��?S�~����?@�Ń{�^���𗣂����Ƃ�)��?s����??----------------------------------------------------
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

//49 49 49 49 49 49 49 49 49 49 49 49 49 49 49  �����܂�

//51 51 51 51 51 51 51 51 51 51 51 51 51 51 51?@��������

    //�}�E�X��??(i_mouse_modeA==51 ��?s???@??�w����̓�?[�h?@�Ń{�^�����������Ƃ�)����??��----------------------------------------------------
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

    //�}�E�X��??(i_mouse_modeA==51 ��?s???@??�w����̓�?[�h?@�Ńh���b�O�����Ƃ�)��?s����??----------------------------------------------------
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

    //�}�E�X��??(i_mouse_modeA==51 ��?s???@??�w����̓�?[�h?@�Ń{�^���𗣂����Ƃ�)��?s����??----------------------------------------------------
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

//51 51 51 51 51 51 51 51 51 51 51 51 51 51 51  �����܂�

//45 45 45 45 45 45 45 45 45   i_mouse_modeA==45?@;2�~�̋���?�??���̓�?[�h?B

    //�}�E�X��??(�{�^�����������Ƃ�)����??��
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

    //�}�E�X��??(�h���b�O�����Ƃ�)��?s����??
    public void mDragged_A_45(Ten p0) {
    }

    //�}�E�X��??(�{�^���𗣂����Ƃ�)��?s����??
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
            }//?�??0�{��????

            if ((xp * xp + yp * yp) < (r1 - r2) * (r1 - r2)) {
                i_egaki_dankai = 0;
                i_en_egaki_dankai = 0;
                return;
            }//?�??0�{��????

            if (Math.abs((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2)) < 0.0000001) {//�O?�??1�{��????
                Ten kouten = new Ten();
                kouten.set(oc.naibun(c1, c2, -r1, r2));
                Tyokusen ty = new Tyokusen(c1, kouten);
                ty.tyokkouka(kouten);
                s_step[1].set(oc.en_to_tyokusen_no_kouten_wo_musubu_senbun(new En(kouten, (r1 + r2) / 2.0, 0), ty));

                i_egaki_dankai = 1;
                i_en_egaki_dankai = 2;
            }

            if (((r1 - r2) * (r1 - r2) < (xp * xp + yp * yp)) && ((xp * xp + yp * yp) < (r1 + r2) * (r1 + r2))) {//�O?�??2�{��????
                double xq1 = r1 * (xp * (r1 - r2) + yp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//���ʊO?�??
                double yq1 = r1 * (yp * (r1 - r2) - xp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//���ʊO?�??
                double xq2 = r1 * (xp * (r1 - r2) - yp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//���ʊO?�??
                double yq2 = r1 * (yp * (r1 - r2) + xp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//���ʊO?�??

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

            if (Math.abs((xp * xp + yp * yp) - (r1 + r2) * (r1 + r2)) < 0.0000001) {//�O?�??2�{�Ɠ�?�??1�{��????
                double xq1 = r1 * (xp * (r1 - r2) + yp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//���ʊO?�??
                double yq1 = r1 * (yp * (r1 - r2) - xp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//���ʊO?�??
                double xq2 = r1 * (xp * (r1 - r2) - yp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//���ʊO?�??
                double yq2 = r1 * (yp * (r1 - r2) + xp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//���ʊO?�??

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

            if ((r1 + r2) * (r1 + r2) < (xp * xp + yp * yp)) {//�O?�??2�{�Ɠ�?�??2�{��????
                //             ---------------------------------------------------------------
                //                                     -------------------------------------
                //                 -------               -------------   -------   -------       -------------
                double xq1 = r1 * (xp * (r1 - r2) + yp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//���ʊO?�??
                double yq1 = r1 * (yp * (r1 - r2) - xp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//���ʊO?�??
                double xq2 = r1 * (xp * (r1 - r2) - yp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//���ʊO?�??
                double yq2 = r1 * (yp * (r1 - r2) + xp * Math.sqrt((xp * xp + yp * yp) - (r1 - r2) * (r1 - r2))) / (xp * xp + yp * yp);//���ʊO?�??
                double xq3 = r1 * (xp * (r1 + r2) + yp * Math.sqrt((xp * xp + yp * yp) - (r1 + r2) * (r1 + r2))) / (xp * xp + yp * yp);//���ʓ�?�??
                double yq3 = r1 * (yp * (r1 + r2) - xp * Math.sqrt((xp * xp + yp * yp) - (r1 + r2) * (r1 + r2))) / (xp * xp + yp * yp);//���ʓ�?�??
                double xq4 = r1 * (xp * (r1 + r2) - yp * Math.sqrt((xp * xp + yp * yp) - (r1 + r2) * (r1 + r2))) / (xp * xp + yp * yp);//���ʓ�?�??
                double yq4 = r1 * (yp * (r1 + r2) + xp * Math.sqrt((xp * xp + yp * yp) - (r1 + r2) * (r1 + r2))) / (xp * xp + yp * yp);//���ʓ�?�??


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

//45 45 45 45 45 45 45 45 45  �����܂�  ------


//50 50 50 50 50 50 50 50 50   i_mouse_modeA==50?@;2�~��??������?ڂ��铯?S�~��������?B

    //�}�E�X��??(�{�^�����������Ƃ�)����??��
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

    //�}�E�X��??(�h���b�O�����Ƃ�)��?s����??
    public void mDragged_A_50(Ten p0) {
    }

    //�}�E�X��??(�{�^���𗣂����Ƃ�)��?s����??
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

//50 50 50 50 50 50 50 50 50  �����܂�  ------


//46 46 46 46 46 46 46 46 46   i_mouse_modeA==46?@;���]���̓�?[�h?B

    //�}�E�X��??(�{�^�����������Ƃ�)����??��
    public void mPressed_A_46(Ten p0) {
        //Ten p =new Ten();
        p.set(camera.TV2object(p0));

        moyori_ensyuu.set(get_moyori_ensyuu(p));

        if (i_egaki_dankai + i_en_egaki_dankai == 0) {
            moyori_senbun.set(get_moyori_senbun(p));


            if (oc.kyori_senbun(p, moyori_senbun) < oc.kyori_ensyuu(p, moyori_ensyuu)) {//??���̕����~�����߂�
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

    //�}�E�X��??(�h���b�O�����Ƃ�)��?s����??
    public void mDragged_A_46(Ten p0) {
    }

    //�}�E�X��??(�{�^���𗣂����Ƃ�)��?s����??
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

//46 46 46 46 46 46 46 46 46  �����܂�  ------


//43 43 43 43 43 43 43 43 43   i_mouse_modeA==43?@;�~3�_���̓�?[�h?B

    //�}�E�X��??(�{�^�����������Ƃ�)����??��
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

    //�}�E�X��??(�h���b�O�����Ƃ�)��?s����??
    public void mDragged_A_43(Ten p0) {
    }

    //�}�E�X��??(�{�^���𗣂����Ƃ�)��?s����??
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

//43 43 43 43 43 43 43 43 43  �����܂�  ------





















/*

//5555555555555555555555    i_mouse_modeA==5?@

//�}�E�X��??(�{�^�����������Ƃ�)����??��
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

//�}�E�X��??(�h���b�O�����Ƃ�)��?s����??
	public void mDragged_A_05(Ten p0) {	}

//�}�E�X��??(�{�^���𗣂����Ƃ�)��?s����??
	public void mReleased_A_05(Ten p0){			if(i_egaki_dankai==3){i_egaki_dankai=0;}}

//------

//66666666666666666666    i_mouse_modeA==6?@

//�}�E�X��??(�{�^�����������Ƃ�)����??��
	public void mPressed_A_06(Ten p0) {


		//Ten p =new Ten();
		p.set(camera.TV2object(p0));
		moyori_ten.set(get_moyori_ten(p));
		if(p.kyori(moyori_ten)<d_hantei_haba){
			i_egaki_dankai=i_egaki_dankai+1;
			s_step[i_egaki_dankai].set(moyori_ten,moyori_ten);s_step[i_egaki_dankai].setcolor(i_egaki_dankai);
		}


	}

//�}�E�X��??(�h���b�O�����Ƃ�)��?s����??
	public void mDragged_A_06(Ten p0) {	}

//�}�E�X��??(�{�^���𗣂����Ƃ�)��?s����??
	public void mReleased_A_06(Ten p0){
		if(i_egaki_dankai==3){i_egaki_dankai=0;}



	}

//------



*/


//10001

    //�}�E�X��??(i_mouse_modeA==10001?@�Ń{�^�����������Ƃ�)����??��
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

    //�}�E�X��??(i_mouse_modeA==10001?@�Ńh���b�O�����Ƃ�)��?s����??
    public void mDragged_A_10001(Ten p0) {
    }

    //�}�E�X��??(i_mouse_modeA==10001?@�Ń{�^���𗣂����Ƃ�)��?s����??
    public void mReleased_A_10001(Ten p0) {
        if (i_egaki_dankai == 3) {
            i_egaki_dankai = 0;
        }


    }

//------
//10002

    //�}�E�X��??(i_mouse_modeA==10002?@�Ń{�^�����������Ƃ�)����??��
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

    //�}�E�X��??(i_mouse_modeA==10002?@�Ńh���b�O�����Ƃ�)��?s����??
    public void mDragged_A_10002(Ten p0) {
    }

    //�}�E�X��??(i_mouse_modeA==10002?@�Ń{�^���𗣂����Ƃ�)��?s����??
    public void mReleased_A_10002(Ten p0) {
        if (i_egaki_dankai == 3) {
            i_egaki_dankai = 0;
        }
    }

//------
//------
//10003

    //�}�E�X��??(i_mouse_modeA==10003?@�Ń{�^�����������Ƃ�)����??��
    public void mPressed_A_10003(Ten p0) {
    }

    //�}�E�X��??(i_mouse_modeA==10003?@�Ńh���b�O�����Ƃ�)��?s����??
    public void mDragged_A_10003(Ten p0) {
    }

    //�}�E�X��??(i_mouse_modeA==10003?@�Ń{�^���𗣂����Ƃ�)��?s����??
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
    }//ori_s�ɂ�����?A�`�F�b�N���Ă�������?�??���Z���N�g?�Ԃɂ���?B

    public void fix1(double r_hitosii, double heikou_hantei) {
        while (ori_s.fix1(r_hitosii, heikou_hantei) == 1) {
        }
        //ori_s.addsenbun  delsenbun�����{���Ă���Ƃ����check�����{
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
        //ori_s.addsenbun  delsenbun�����{���Ă���Ƃ����check�����{
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

    public void en_seiri() {//�S�Ẳ~���?ۂ�?�??������?B
        ori_s.en_seiri();
    }


    // ---------------------------
    public void add_hanten(En e0, En eh) {


        //e0�̉~����(x,y)��ʂ�Ƃ�
        if (Math.abs(oc.kyori(e0.get_tyuusin(), eh.get_tyuusin()) - e0.getr()) < 0.0000001) {
            Senbun s_add = new Senbun();
            s_add.set(eh.hanten_En2Senbun(e0));
            //s_add.setcolor(3);
            addsenbun(s_add);
            kiroku();
            return;
        }


        //e0�̉~���̓�����(x,y)������Ƃ�
        //if(oc.kyori(e0.get_tyuusin(),eh.get_tyuusin())<e0.getr()){
        //	return;
        //}

//System.out.println("20170315  ********************3");
        //e0�̉~����(x,y)��ʂ�Ȃ��Ƃ�?Be0�̉~���̊O����(x,y)������Ƃ�//e0�̉~���̓�����(x,y)������Ƃ�
        En e_add = new En();
        e_add.set(eh.hanten(e0));
        add_en(e_add);
        kiroku();
    }

    // ---------------------------
    public void add_hanten(Senbun s0, En eh) {
        Tyokusen ty = new Tyokusen(s0);
        //s0?��(x,y)������Ƃ�
        if (ty.kyorikeisan(eh.get_tyuusin()) < 0.0000001) {
            return;
        }

        //s0��(x,y)��ʂ�Ȃ��Ƃ�?B
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
��l���������?�itti_bunkai();

public void itti_bunkai(){//?i�P?j2�_a,b���w��







}

?i�P?j2�_a,b���w��
?i�Q?ja����_�Ƃ���x�N�g��ab��?�?��ɂԂ���?�??�Ƃ̌�_c��??�߂�?Bab��?d�Ȃ�?�??�͖���
?i�R?j
c��������?�??�̕��̕���������?????A����??�ŋ��f��?Ac��a�Ƃ�?Ab�����f??��?�̓_�Ƃ���?ċA�I��?B
c���_������?????A���łɒʉ߂��Ă����_�Ȃ�?Areturn;


c����x�N�g��ac�ƈ�l?���??�x�N�g����??�߂�?A






*/

    //--------------------------------------------
    public void test1() {//�f�o�b�N���̃e�X�g�p

        System.out.println("ori_s.getsousuu()  " + ori_s.getsousuu());

    }

    //--------------------------------------------

    //??��
    //icol=0 black
    //icol=1 red
    //icol=2 blue
    //icol=3 cyan
    //icol=4 orange
    //icol=5 mazenta
    //icol=6 green
    //icol=7 yellow
    //icol=8 new Color(210,0,255) //��


}