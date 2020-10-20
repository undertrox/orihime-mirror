package jp.gr.java_conf.mt777.origami.orihime.tenkaizu_syokunin;

import jp.gr.java_conf.mt777.kiroku.memo.Memo;
import jp.gr.java_conf.mt777.origami.dougu.camera.Camera;
import jp.gr.java_conf.mt777.origami.dougu.senbunsyuugou.Senbunsyuugou;
import jp.gr.java_conf.mt777.origami.dougu.tensyuugou.Tensyuugou;
import jp.gr.java_conf.mt777.zukei2d.oritacalc.OritaCalc;
import jp.gr.java_conf.mt777.zukei2d.senbun.Senbun;

import java.awt.*;
// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------

public class Tenkaizu_Syokunin {//���̓W�J?}?E?l�N���X�͓W�J?}�Ƃ��Ă�Tensyuugou c���P��������?B
    //?܂�?�ݓ�����������ʓ�����Tensyuugou�͊O���ɕԂ��悤�ɂ���?A������?g�ł͕ێ?���Ȃ�?B
    OritaCalc oc = new OritaCalc(); //�e��v�Z�p�̊�?����g�����߂̃N���X�̃C���X�^���X��
    double r = 3.0;                   //��{�}?\���̒�?��̗��[�̉~�̔��a?A�}�Ɗe��|�C���g�̋߂��̔����?�

    Tensyuugou c = new Tensyuugou();    //�W�J?}

    Undo_Box Ubox = new Undo_Box();

    //VVVVVVVVVVVV oritatami?@��?@oekaki �Ŏg����?�?@�̒�`?@VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV
    int[] iMeniti;//����ʂ���?��ʂƉ��ʗ���Ă��邩������?B��?��ʂł�1?A��?��ʂׂ̗ł�2?A���ׂ̗ł�3�Ƃ����l�ɒl������
    int kijyunmen_id;
    int[] tonariMenid;//����ʂׂ̗̖�?i��?��ʑ�?j��id
    int[] kyoukaiBouid;//����ʂƗׂ̖�?i��?��ʑ�?j�̊Ԃ̖_��id

    HeikinZahyou[] tnew;//?܂������̓_�̈ʒu���i�[

    //  Ten naibuTen [] = new Ten[888];         //�ʂ̓����̓_���i�[

    //�}�E�X��Ten��I������?�?���Ten�̔�?����i�[
    public int i_ugokasuTen = 0;

    Camera camera = new Camera();
    Camera cam_omote = new Camera();
    Camera cam_ura = new Camera();

    Camera cam_touka_omote = new Camera();
    Camera cam_touka_ura = new Camera();


    public Ten ten_of_kijyunmen_ob = new Ten();

    //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA

    public Tenkaizu_Syokunin(double r0) {  //�R���X�g���N�^
        //	 reset();
        r = r0;
    }

    public void reset() {
        r = 3.0;
        c.reset();
        //for(int i=0;i<=c.getTensuu();i++){tnew[i].reset();}

        camera.reset();
        cam_omote.reset();
        cam_ura.reset();


        cam_touka_omote.reset();
        cam_touka_ura.reset();

    }

    private void settei(int Tsuu, int Bsuu, int Msuu) {
        HeikinZahyou[] t_new = new HeikinZahyou[Tsuu + 1];
        tnew = t_new;
        for (int i = 0; i <= Tsuu; i++) {
            tnew[i] = new HeikinZahyou();
        }
        int[] i_Meniti = new int[Msuu + 1];
        iMeniti = i_Meniti;
        int[] tonari_Menid = new int[Msuu + 1];
        tonariMenid = tonari_Menid;         //����ʂׂ̗̖�?i��?��ʑ�?j��id
        int[] kyoukai_Bouid = new int[Msuu + 1];
        kyoukaiBouid = kyoukai_Bouid;         //����ʂƗׂ̖�?i��?��ʑ�?j�̊Ԃ̖_��id
    }

    //---------------
    //public void Iti_sitei(double x, double y){c.Iti_sitei(x ,y);}

    //-----------
    public void add_kijyunmen_id() {
        kijyunmen_id = kijyunmen_id + 1;
        if (kijyunmen_id > c.getMensuu()) {
            kijyunmen_id = 1;
        }
    }


    //-------------------------------------------
    public int get_kijyunmen_id() {
        return kijyunmen_id;
    }


    //-------------------------------------------
    public Ten get_kijyunmen_migiue_Ten() {

        return c.get_men_migiue_Ten(kijyunmen_id);

    }

    //-------------------------------------------
    public Ten get_ten_of_kijyunmen_ob() {

        return ten_of_kijyunmen_ob;

    }

    //-------------------------------------------
    public Ten get_ten_of_kijyunmen_tv() {

        return camera.object2TV(ten_of_kijyunmen_ob);

    }


    //-------------------------------------------
    public int set_kijyunmen_id(int i) {
        kijyunmen_id = i;


        if (kijyunmen_id > c.getMensuu()) {
            kijyunmen_id = c.getMensuu();
        }
        if (kijyunmen_id < 1) {
            kijyunmen_id = 1;
        }

        ten_of_kijyunmen_ob = c.naibuTen_motome(kijyunmen_id);


        return kijyunmen_id;
    }


    //-----------����͊�?��ʎw�胂?[�h�Ń}�E�X�������ꂽ�Ƃ��̑Ή�201503
    public int set_kijyunmen_id(Ten p0) {//��?ۂɗL���ɂȂ��Ă����?���id��Ԃ�
        Ten p = new Ten();
        p.set(camera.TV2object(p0));
        if (c.naibu(p) > 0) {
            kijyunmen_id = c.naibu(p);
            ten_of_kijyunmen_ob.set(p);
        }//c.naibu(p)=0�Ȃ�ǂ̖ʂ̓����ɂ��Ȃ�?A�}�C�i�X�Ȃ狫�E?�?�?A?���?��Ȃ����?B�Y������ʔ�?�����?�����?�?��͔�?���?������ق����Ԃ����?B
        return kijyunmen_id;
    }


    //-----------Ten p0��?܂�?オ��?}�̓����ɗL�邩�ǂ����𔻒肷��
    public int naibu_hantei(Ten p0) {//��?ۂ�p0�������id��Ԃ�
        Ten p = new Ten();
        p.set(camera.TV2object(p0));
        return c.naibu(p);//c.naibu(p)=0�Ȃ�ǂ̖ʂ̓����ɂ��Ȃ�?A�}�C�i�X�Ȃ狫�E?�?�?A?���?��Ȃ����?B�Y������ʔ�?�����?�����?�?��͔�?���?������ق����Ԃ����?B
    }

    //-----------Ten p0��?܂�?オ��?}(�\)�̓����ɗL�邩�ǂ����𔻒肷��
    public int naibu_hantei_omote(Ten p0) {//��?ۂ�p0�������id��Ԃ�
        Ten p = new Ten();
        p.set(cam_omote.TV2object(p0));
        return c.naibu(p);//Tensyuugou c.naibu(p)=0�Ȃ�ǂ̖ʂ̓����ɂ��Ȃ�?A�}�C�i�X�Ȃ狫�E?�?�?A?���?��Ȃ����?B�Y������ʔ�?�����?�����?�?��͔�?���?������ق����Ԃ����?B
    }

    //-----------Ten p0��?܂�?オ��?}(��)�̓����ɗL�邩�ǂ����𔻒肷��
    public int naibu_hantei_ura(Ten p0) {//��?ۂ�p0�������id��Ԃ�
        Ten p = new Ten();
        p.set(cam_ura.TV2object(p0));
        return c.naibu(p);//Tensyuugou c.naibu(p)=0�Ȃ�ǂ̖ʂ̓����ɂ��Ȃ�?A�}�C�i�X�Ȃ狫�E?�?�?A?���?��Ȃ����?B�Y������ʔ�?�����?�����?�?��͔�?���?������ق����Ԃ����?B
    }

    //-----------Ten p0��?܂�?オ��?}�ɕt�����ĕ\������铧��?}(�\)�̓����ɗL�邩�ǂ����𔻒肷��
    public int naibu_hantei_touka_omote(Ten p0) {//��?ۂ�p0�������id��Ԃ�
        Ten p = new Ten();
        p.set(cam_touka_omote.TV2object(p0));
        return c.naibu(p);//Tensyuugou c.naibu(p)=0�Ȃ�ǂ̖ʂ̓����ɂ��Ȃ�?A�}�C�i�X�Ȃ狫�E?�?�?A?���?��Ȃ����?B�Y������ʔ�?�����?�����?�?��͔�?���?������ق����Ԃ����?B
    }

    //-----------Ten p0��?܂�?オ��?}�ɕt�����ĕ\������铧��?}(��)�̓����ɗL�邩�ǂ����𔻒肷��
    public int naibu_hantei_touka_ura(Ten p0) {//��?ۂ�p0�������id��Ԃ�
        Ten p = new Ten();
        p.set(cam_touka_ura.TV2object(p0));
        return c.naibu(p);//Tensyuugou c.naibu(p)=0�Ȃ�ǂ̖ʂ̓����ɂ��Ȃ�?A�}�C�i�X�Ȃ狫�E?�?�?A?���?��Ȃ����?B�Y������ʔ�?�����?�����?�?��͔�?���?������ق����Ԃ����?B
    }


    //--------------------------------------------
    public void set_r(double r0) {
        r = r0;
    }

    //--------------------------------------------
    public void setCamera(Camera cam0) {
        camera.set_camera_kagami(cam0.get_camera_kagami());
        camera.set_camera_ichi_x(cam0.get_camera_ichi_x());
        camera.set_camera_ichi_y(cam0.get_camera_ichi_y());
        camera.set_camera_bairitsu_x(cam0.get_camera_bairitsu_x());
        camera.set_camera_bairitsu_y(cam0.get_camera_bairitsu_y());
        camera.set_camera_kakudo(cam0.get_camera_kakudo());
        camera.set_hyouji_ichi_x(cam0.get_hyouji_ichi_x());
        camera.set_hyouji_ichi_y(cam0.get_hyouji_ichi_y());
    }


    public void setCam_omote(Camera cam0) {
        cam_omote.set_camera_kagami(cam0.get_camera_kagami());
        cam_omote.set_camera_ichi_x(cam0.get_camera_ichi_x());
        cam_omote.set_camera_ichi_y(cam0.get_camera_ichi_y());
        cam_omote.set_camera_bairitsu_x(cam0.get_camera_bairitsu_x());
        cam_omote.set_camera_bairitsu_y(cam0.get_camera_bairitsu_y());
        cam_omote.set_camera_kakudo(cam0.get_camera_kakudo());
        cam_omote.set_hyouji_ichi_x(cam0.get_hyouji_ichi_x());
        cam_omote.set_hyouji_ichi_y(cam0.get_hyouji_ichi_y());
    }

    public void setCam_ura(Camera cam0) {
        cam_ura.set_camera_kagami(cam0.get_camera_kagami());
        cam_ura.set_camera_ichi_x(cam0.get_camera_ichi_x());
        cam_ura.set_camera_ichi_y(cam0.get_camera_ichi_y());
        cam_ura.set_camera_bairitsu_x(cam0.get_camera_bairitsu_x());
        cam_ura.set_camera_bairitsu_y(cam0.get_camera_bairitsu_y());
        cam_ura.set_camera_kakudo(cam0.get_camera_kakudo());
        cam_ura.set_hyouji_ichi_x(cam0.get_hyouji_ichi_x());
        cam_ura.set_hyouji_ichi_y(cam0.get_hyouji_ichi_y());
    }


    public void setCam_touka_omote(Camera cam0) {
        cam_touka_omote.set_camera_kagami(cam0.get_camera_kagami());
        cam_touka_omote.set_camera_ichi_x(cam0.get_camera_ichi_x());
        cam_touka_omote.set_camera_ichi_y(cam0.get_camera_ichi_y());
        cam_touka_omote.set_camera_bairitsu_x(cam0.get_camera_bairitsu_x());
        cam_touka_omote.set_camera_bairitsu_y(cam0.get_camera_bairitsu_y());
        cam_touka_omote.set_camera_kakudo(cam0.get_camera_kakudo());
        cam_touka_omote.set_hyouji_ichi_x(cam0.get_hyouji_ichi_x());
        cam_touka_omote.set_hyouji_ichi_y(cam0.get_hyouji_ichi_y());
    }

    public void setCam_touka_ura(Camera cam0) {
        cam_touka_ura.set_camera_kagami(cam0.get_camera_kagami());
        cam_touka_ura.set_camera_ichi_x(cam0.get_camera_ichi_x());
        cam_touka_ura.set_camera_ichi_y(cam0.get_camera_ichi_y());
        cam_touka_ura.set_camera_bairitsu_x(cam0.get_camera_bairitsu_x());
        cam_touka_ura.set_camera_bairitsu_y(cam0.get_camera_bairitsu_y());
        cam_touka_ura.set_camera_kakudo(cam0.get_camera_kakudo());
        cam_touka_ura.set_hyouji_ichi_x(cam0.get_hyouji_ichi_x());
        cam_touka_ura.set_hyouji_ichi_y(cam0.get_hyouji_ichi_y());
    }


    // ----------------
    public int getMensuu() {
        return c.getMensuu();
    }

    //-------------
    public void heikou_idou(double x, double y) {
        c.heikou_idou(x, y);
    }

    //
    public void uragaesi() {//?d?S�̈ʒu��?S��?��E�ɗ��Ԃ�?B
        c.uragaesi();
    }

    //�ʂ̓����̓_���?�߂�//---------------------------------------
    public Ten naibuTen_motome(int i) {
        return c.naibuTen_motome(i);
    }

    //�_?W?��̎?�_�̑??��𓾂�
    public int getBousuu() {
        return c.getBousuu();
    }

    //�_?W?��̎?�_��?F�𓾂�?i�_?W?���W�J?}�Ƃ��Ĉ���?�?��ł�?A����?F�͎R�J������킷?j?B
    public int getcolor(int i) {
        return c.getcolor(i);
    }

    //-------------------------------------------
    public int getiMeniti(int i) {
        return iMeniti[i];
    }

    //-------------------------------------------
    //?܂肽����?���?i�����łł���͖̂ʂ�?d�Ȃ��?l���Ă��Ȃ�?j��?}?j
    public Tensyuugou oritatami() {//?܂肽����?���
        Tensyuugou cn = new Tensyuugou();    //�W�J?}
        cn.settei(c.getTensuu(), c.getBousuu(), c.getMensuu());
        cn.set(c);


//System.out.println("?܂肽����?���001   c.getTenx(1) = "+c.getTenx(1)+"   :   cn.getTenx(1) = "+cn.getTenx(1));

        //kijyunmen_id=1;//��?��ɂȂ�ʂ��w�肷��

        for (int i = 0; i <= c.getMensuu(); i++) {
            tonariMenid[i] = 0;
            kyoukaiBouid[i] = 0;
            iMeniti[i] = 0;
        }
//System.out.println("?܂肽����?���002   c.getTenx(1) = "+c.getTenx(1)+"   :   cn.getTenx(1) = "+cn.getTenx(1));
        //?܂肽���݂�?����Ƃ��Ėʓ��m�̈ʒu�֌W��c������
        System.out.println("?܂肽���݂�?����Ƃ��Ėʓ��m�̈ʒu�֌W��c������");
        iMeniti[kijyunmen_id] = 1;

        int imano_Meniti = 1;
        int nokori_Mensuu;
        nokori_Mensuu = c.getMensuu() - 1;

        while (nokori_Mensuu > 0) {
            for (int i = 1; i <= c.getMensuu(); i++) {
                if (iMeniti[i] == imano_Meniti) {
                    for (int j = 1; j <= c.getMensuu(); j++) {
                        int mth = c.Men_tonari_hantei(i, j);
                        if ((mth > 0) && (iMeniti[j] == 0)) {
                            iMeniti[j] = imano_Meniti + 1;
                            tonariMenid[j] = i;
                            kyoukaiBouid[j] = mth;
                        }
                    }
                }
            }

            imano_Meniti = imano_Meniti + 1;

            nokori_Mensuu = 0;
            for (int i = 1; i <= c.getMensuu(); i++) {
                if (iMeniti[i] == 0) {
                    nokori_Mensuu = nokori_Mensuu + 1;
                }
            }

            System.out.println("nokori_Mensuu = " + nokori_Mensuu);
        }
//System.out.println("?܂肽����?���003   c.getTenx(1) = "+c.getTenx(1)+"   :   cn.getTenx(1) = "+cn.getTenx(1));
        System.out.println("?܂����Ƃ��̓_�̈ʒu���?�߂�?B");
        //?܂����Ƃ��̓_�̈ʒu���?�߂�?B
        //�_it����im�Ɋ܂܂��?�?���?A
        //�W�J?}��?܂�ꂽ�Ƃ��ɂǂ��Ɉړ����邩��?A��im�̈ړ��ɂ���ċ?�߂�?B

        System.out.println("?܂����Ƃ��̓_�̈ʒu���?�߂�?i�J�n?j");
        for (int it = 1; it <= c.getTensuu(); it++) {
            tnew[it].reset();
            for (int im = 1; im <= c.getMensuu(); im++) {
                if (c.Ten_moti_hantei(im, it) == 1) {//c.Ten_moti_hantei��?AMen[im]�̋��E��Ten[it]���܂܂��Ȃ�1?A�܂܂�Ȃ��Ȃ�0��Ԃ�
                    tnew[it].addTen(ori_idou(it, im));
                    cn.setTen(it, tnew[it].getHeikin_Ten());
                }
            }
        }
        System.out.println("?܂����Ƃ��̓_�̈ʒu���?�߂�?i?I��?j");

//System.out.println("?܂肽����?���004   c.getTenx(1) = "+c.getTenx(1)+"   :   cn.getTenx(1) = "+cn.getTenx(1));
        return cn;
    }

    //------------------------------------------------------------
    private Ten ori_idou(int it, int im) { //�_it����im�̈���Ƃ���?܂�ꂽ?�?��̈ړ�?�̈ʒu���?�߂��?�

        Ten p = new Ten();  // p1.set(s.geta());
        p.set(c.getTen(it));
        int idousakino_Menid;
        idousakino_Menid = im;//?�?��̖ʂ�id��?�?B���ꂩ���?��ʂ̕����ɗ�?ڂ���ʂ����ǂ��Ă���?B
        while (idousakino_Menid != kijyunmen_id) {
            //p.set(sentaisyou_ten_motome(c.getBou(kyoukaiBouid[idousakino_Menid]),p));
            p.set(sentaisyou_ten_motome(kyoukaiBouid[idousakino_Menid], p));
            idousakino_Menid = tonariMenid[idousakino_Menid];
        }
        return p;
    }


// ***********************************

    //?܂肽����?���?i�����łł���͖̂ʂ�?d�Ȃ��?l���Ă��Ȃ�?j��?}?j
    public Tensyuugou men_iti_motome() {//?܂肽����?���

        Tensyuugou cn = new Tensyuugou();    //�W�J?}
        cn.settei(c.getTensuu(), c.getBousuu(), c.getMensuu());
        cn.set(c);


//System.out.println("?܂肽����?���001   c.getTenx(1) = "+c.getTenx(1)+"   :   cn.getTenx(1) = "+cn.getTenx(1));

        //kijyunmen_id=1;//��?��ɂȂ�ʂ��w�肷��

        for (int i = 0; i <= c.getMensuu(); i++) {
            tonariMenid[i] = 0;
            kyoukaiBouid[i] = 0;
            iMeniti[i] = 0;
        }
//System.out.println("?܂肽����?���002   c.getTenx(1) = "+c.getTenx(1)+"   :   cn.getTenx(1) = "+cn.getTenx(1));
        //?܂肽���݂�?����Ƃ��Ėʓ��m�̈ʒu�֌W��c������
        System.out.println("?܂肽���݂�?����Ƃ��Ėʓ��m�̈ʒu�֌W��c������");
        iMeniti[kijyunmen_id] = 1;

        int imano_Meniti = 1;
        int nokori_Mensuu;
        nokori_Mensuu = c.getMensuu() - 1;

        while (nokori_Mensuu > 0) {
            for (int i = 1; i <= c.getMensuu(); i++) {
                if (iMeniti[i] == imano_Meniti) {
                    for (int j = 1; j <= c.getMensuu(); j++) {
                        int mth = c.Men_tonari_hantei(i, j);
                        if ((mth > 0) && (iMeniti[j] == 0)) {
                            iMeniti[j] = imano_Meniti + 1;
                            tonariMenid[j] = i;
                            kyoukaiBouid[j] = mth;
                        }
                    }
                }
            }

            imano_Meniti = imano_Meniti + 1;

            nokori_Mensuu = 0;
            for (int i = 1; i <= c.getMensuu(); i++) {
                if (iMeniti[i] == 0) {
                    nokori_Mensuu = nokori_Mensuu + 1;
                }
            }

            System.out.println("nokori_Mensuu = " + nokori_Mensuu);
        }


//System.out.println("?܂肽����?���004   c.getTenx(1) = "+c.getTenx(1)+"   :   cn.getTenx(1) = "+cn.getTenx(1));
        return cn;
    }


// **********************************


    private Ten sentaisyou_ten_motome(int bouid, Ten tn) {//�_��id��?A�C�ӂ̓_��^����?Aid���Ή�����_�ɑ΂���?A�^�����_��?���?̂ɂȂ�_��Ԃ�
        return oc.sentaisyou_ten_motome(c.get_maeTen_from_Bou_id(bouid), c.get_atoTen_from_Bou_id(bouid), tn);
    }


    public int getTensuu() {
        return c.getTensuu();
    }
//	int getBousuu(){return c.getBousuu();}	
//	int getMensuu(){return c.getMensuu();}	


    //-------------------------------------------
    public void set(Tensyuugou ts) {
        settei(ts.getTensuu(), ts.getBousuu(), ts.getMensuu());
        c.settei(ts.getTensuu(), ts.getBousuu(), ts.getMensuu());
        c.set(ts);
//System.out.println("?܂肽����set 001   c.getTenx(1) = "+c.getTenx(1));		

    }

    public Tensyuugou get() {
        return c;
    }

    //------------------
    public Senbunsyuugou getSenbunsyuugou() {
        Senbunsyuugou ss = new Senbunsyuugou();    //��{�}?\���̃C���X�^���X��

        ss.setsousuu(c.getBousuu());
        for (int i = 1; i <= c.getBousuu(); i++) {
            ss.set(i, c.getTen(c.getmae(i)), c.getTen(c.getato(i)), c.getcolor(i), 0);
        }
        return ss;
    }


    //?@������ class Tenkaizu_Syokunin  �̒��ł�

    //--------------------------------------------------------------------------
    public void Senbunsyuugou2Tensyuugou(Senbunsyuugou k) {

        //   settei(k.getsousuu(),k.getsousuu(),k.getsousuu());
        //   c.settei(k.getsousuu(),k.getsousuu(),k.getsousuu());

        Ten ti = new Ten();
        reset();

        //�܂�?ATensyuugou���œ_���`����?B
        System.out.println("?���?W?�->�_?W?�?F�_?W?����œ_�̒�`");
        int icol;
        int flag1;
        double x, y;

        double[] addTenx = new double[k.getsousuu() + 1];//+1�������Ȃ��Ɩʂ�?���1�̎��ɃG��?[��?o��
        double[] addTeny = new double[k.getsousuu() + 1];//+1�������Ȃ��Ɩʂ�?���1�̎��ɃG��?[��?o��
        int addTensuu = 0;

        for (int i = 1; i <= k.getsousuu(); i++) {
            flag1 = 0;
            ti = k.geta(i);
            x = ti.getx();
            y = ti.gety();
            //	for(int j=1;j<=c.getTensuu();j++){
            //		if(oc.hitosii(ti,c.getTen(j) )){flag1=1;}
            //	}

            for (int j = 1; j <= addTensuu; j++) {
                if (oc.hitosii(ti, new Ten(addTenx[j], addTeny[j]))) {
                    flag1 = 1;
                }
            }


            if (flag1 == 0) {
                //	c.addTen(x,y);
                addTensuu = addTensuu + 1;
                addTenx[addTensuu] = x;
                addTeny[addTensuu] = y;
            }
            flag1 = 0;
            ti = k.getb(i);
            x = ti.getx();
            y = ti.gety();
            //for(int j=1;j<=c.getTensuu();j++){
            //	if(oc.hitosii(ti,c.getTen(j) )){flag1=1;}
            //}
            for (int j = 1; j <= addTensuu; j++) {
                if (oc.hitosii(ti, new Ten(addTenx[j], addTeny[j]))) {
                    flag1 = 1;
                }
            }


            if (flag1 == 0) {
                //	c.addTen(x,y);
                addTensuu = addTensuu + 1;
                addTenx[addTensuu] = x;
                addTeny[addTensuu] = y;

            }
        }

        System.out.print("�_�̑S?�?@addTensuu???@");
        System.out.println(addTensuu);//System.out.println(c.getTensuu());

        //settei(addTensuu,k.getsousuu(),k.getsousuu()-addTensuu+1);//      <<������?A?璷?��m�ۂ̂��߂����Ɨ]�T���?�������ق���������������Ȃ�?B
        //c.settei(addTensuu,k.getsousuu(),k.getsousuu()-addTensuu+1);//      <<������?A?璷?��m�ۂ̂��߂����Ɨ]�T���?�������ق���������������Ȃ�?B

        settei(addTensuu, k.getsousuu(), k.getsousuu() - addTensuu + 100);//      <<������?A?璷?��m�ۂ̂��߂����Ɨ]�T���?�������ق���������������Ȃ�?B�v����20150315
        c.settei(addTensuu, k.getsousuu(), k.getsousuu() - addTensuu + 100);//      <<������?A?璷?��m�ۂ̂��߂����Ɨ]�T���?�������ق���������������Ȃ�?B�v����20150315

        for (int i = 1; i <= addTensuu; i++) {
            c.addTen(addTenx[i], addTeny[i]);

        }

        //����?ATensyuugou���Ŗ_���`����?B
        System.out.println("?���?W?�->�_?W?�?F�_?W?����Ŗ_�̒�`");

        int[] ika2ic = new int[k.getsousuu() + 1];
        int[] ikb2ic = new int[k.getsousuu() + 1];
        for (int n = 1; n <= k.getsousuu(); n++) {
            for (int i = 1; i <= c.getTensuu(); i++) {
                if (oc.hitosii(k.geta(n), c.getTen(i))) {
                    ika2ic[n] = i;
                    break;
                }
            }
            for (int i = 1; i <= c.getTensuu(); i++) {
                if (oc.hitosii(k.getb(n), c.getTen(i))) {
                    ikb2ic[n] = i;
                    break;
                }
            }

        }

        for (int n = 1; n <= k.getsousuu(); n++) {
            c.addBou(ika2ic[n], ikb2ic[n], k.getcolor(n));
        }


        System.out.print("�_�̑S?�?@???@");
        System.out.println(c.getBousuu());
        //
        System.out.println("?���?W?�->�_?W?�?F�_?W?����Ŗʂ�?�?@�J�n");
        //���̎���?ATensyuugou���Ŗʂ�?�������?B
        c.Menhassei();

        System.out.println("?���?W?�->�_?W?�?F�_?W?����Ŗʂ�?�?@?I��");

    }


//----------------------------------------------------------------------------------------------------------------------------------------    

    //�_ib�����E�Ƃ��Ċ܂ޖ�(?ő��2�ʂ���)�̂�����Menid��?������ق���Menid��Ԃ�?B�_�����E�Ƃ��Ċ܂ޖʂ�����?�?���0��Ԃ�
    public int Bou_moti_Menid_min_motome(int ib) {
        return c.Bou_moti_Menid_min_motome(ib);
    }

    //�_ib�����E�Ƃ��Ċ܂ޖ�(?ő��2�ʂ���)�̂�����Menid�̑傫���ق���Menid��Ԃ�?B�_�����E�Ƃ��Ċ܂ޖʂ�����?�?���0��Ԃ�
    public int Bou_moti_Menid_max_motome(int ib) {
        return c.Bou_moti_Menid_max_motome(ib);
    }

    //?@������ class Tenkaizu_Syokunin  �̒��ł�


    //�}�E�X��?�(�{�^�����������Ƃ�)����?��----------------------------------------------------
    public int mPressed(Ten p, int ura_omote) {
        //�}�E�X�Ƌ߂��ʒu�ɂ���Ten��T��?B
        Ten pn = new Ten();
        pn.set(p);
        if (ura_omote == 1) {
            pn.setx(-p.getx() + 2.0 * 700.0);
        }//�����\����?�?���?��??B
        i_ugokasuTen = c.mottomo_tikai_Tenid(pn, r * 3);
        return i_ugokasuTen;
    }

    //�}�E�X��?�(�h���b�O�����Ƃ�)��?s����?�----------------------------------------------------
    public int mDragged(Ten p, int ura_omote) {


        if (i_ugokasuTen != 0) {//Ten���?X

            Ten pn = new Ten();
            pn.set(p);
            if (ura_omote == 1) {
                pn.setx(-p.getx() + 2.0 * 700.0);
            }//�����\����?�?���?��??B
            c.set(i_ugokasuTen, pn);
        }
        return i_ugokasuTen;
    }


    //�}�E�X��?�(�{�^���𗣂����Ƃ�)��?s����?�----------------------------------------------------
    public int mReleased(Ten p, int ura_omote) {
        int ireturn = 0;

        if (i_ugokasuTen != 0) {
            Ten pn = new Ten();
            pn.set(p);
            if (ura_omote == 1) {
                pn.setx(-p.getx() + 2.0 * 700.0);
            }//�����\����?�?���?��??B
            c.set(i_ugokasuTen, pn);
        } //Ten���?X
        ireturn = i_ugokasuTen;
        i_ugokasuTen = 0;
        return ireturn;

    }


//�}�E�X��?� with camera

    //�}�E�X��?�(�{�^�����������Ƃ�)����?��----------------------------------------------------


    public int mPressed_with_camera(Ten p0, int ip4) {
        Ten p = new Ten();
        if (ip4 == 0) {
            p.set(cam_omote.TV2object(p0));
        }
        if (ip4 == 1) {
            p.set(cam_ura.TV2object(p0));
        }


        //�}�E�X�Ƌ߂��ʒu�ɂ���Ten��T��?B
        //Ten pn = new Ten(); pn.set(p);
        //i_ugokasuTen=c.mottomo_tikai_Tenid(pn,r*3);

        i_ugokasuTen = c.mottomo_tikai_Tenid(p, r * 3);
        return i_ugokasuTen;
    }


    //�}�E�X��?�(�h���b�O�����Ƃ�)��?s����?�----------------------------------------------------

/*
	public int mDragged_with_camera(Ten p0,int ip4) {   

		Ten p =new Ten(); 
		if(ip4==0){	p.set(cam_omote.TV2object(p0));}
		if(ip4==1){	p.set(cam_ura.TV2object(p0));}
		

		if(i_ugokasuTen!=0){//Ten���?X
                	//Ten pn = new Ten(); pn.set(p); 
			//c.set(i_ugokasuTen,pn);
			c.set(i_ugokasuTen,p);
		} 
		return i_ugokasuTen;
	}
*/

    //--------------------------------------------------
    public void mDragged_sentakuten_ugokasi_with_camera(Ten p0, int ip4) {   //�I�����ꂽ�_�𓮂���

        Ten p = new Ten();
        if (ip4 == 0) {
            p.set(cam_omote.TV2object(p0));
        }
        if (ip4 == 1) {
            p.set(cam_ura.TV2object(p0));
        }

        c.sentaku_ten_move(p);
/*
		if(i_ugokasuTen!=0){//Ten���?X
                	//Ten pn = new Ten(); pn.set(p); 
			//c.set(i_ugokasuTen,pn);
			c.set(i_ugokasuTen,p);
		} 
		//return i_ugokasuTen;

*/
    }


    //--------------------------------------------------
    public void mDragged_sentakuten_ugokasi_with_camera(Ten ugokasu_maeno_sentaku_ten, Ten p0, Ten p1, int ip4) {   //�I�����ꂽ�_�𓮂���

        Ten pa = new Ten();
        if (ip4 == 0) {
            pa.set(cam_omote.TV2object(p0));
        }
        if (ip4 == 1) {
            pa.set(cam_ura.TV2object(p0));
        }

        Ten pb = new Ten();
        if (ip4 == 0) {
            pb.set(cam_omote.TV2object(p1));
        }
        if (ip4 == 1) {
            pb.set(cam_ura.TV2object(p1));
        }


        Ten p_u = new Ten();
        p_u.set(ugokasu_maeno_sentaku_ten.getx(), ugokasu_maeno_sentaku_ten.gety());
        p_u.idou(pa.tano_Ten_iti(pb));

        c.sentaku_ten_move(p_u);


    }

    //--------------------------------------------------
    public void mReleased_sentakuten_ugokasi_with_camera(Ten ugokasu_maeno_sentaku_ten, Ten p0, Ten p1, int ip4) {   //�I�����ꂽ�_�𓮂���

        Ten pa = new Ten();
        if (ip4 == 0) {
            pa.set(cam_omote.TV2object(p0));
        }
        if (ip4 == 1) {
            pa.set(cam_ura.TV2object(p0));
        }

        Ten pb = new Ten();
        if (ip4 == 0) {
            pb.set(cam_omote.TV2object(p1));
        }
        if (ip4 == 1) {
            pb.set(cam_ura.TV2object(p1));
        }


        Ten p_u = new Ten();
        p_u.set(ugokasu_maeno_sentaku_ten.getx(), ugokasu_maeno_sentaku_ten.gety());
        p_u.idou(pa.tano_Ten_iti(pb));

        c.sentaku_ten_move(p_u);


    }

    //�}�E�X��?�(�{�^���𗣂����Ƃ�)��?s����?�----------------------------------------------------


    public int mReleased_with_camera(Ten p0, int ip4) {

        Ten p = new Ten();
        if (ip4 == 0) {
            p.set(cam_omote.TV2object(p0));
        }
        if (ip4 == 1) {
            p.set(cam_ura.TV2object(p0));
        }


        int ireturn = 0;

        if (i_ugokasuTen != 0) {
            //Ten pn = new Ten(); pn.set(p);
            //c.set(i_ugokasuTen,pn);
            c.set(i_ugokasuTen, p);

        } //Ten���?X


        ireturn = i_ugokasuTen;
        i_ugokasuTen = 0;
        return ireturn;
    }

// -----------------------

    public void mReleased_sentakuten_ugokasi_with_camera(Ten p0, int ip4) {

        Ten p = new Ten();
        if (ip4 == 0) {
            p.set(cam_omote.TV2object(p0));
        }
        if (ip4 == 1) {
            p.set(cam_ura.TV2object(p0));
        }


        c.sentaku_ten_move(p);

        //	if(i_ugokasuTen!=0){
//			c.set(i_ugokasuTen,p); 
//		} //Ten���?X

//                i_ugokasuTen=0;
    }


    //?}������?ۂ�?��l�ϊ��p��?�-----------------------------------------------------------------

    public int gx(double d) {
        return (int) d;
    }

    public int gy(double d) {
        return (int) d;
    }

    //�W�J?}�̕`��-----------------------------------------------------------------

    //?@������ class Tenkaizu_Syokunin  �̒��ł�

    public void oekaki(Graphics g) {
        String text = "";//������?��?�p�̃N���X�̃C���X�^���X��
        //int ir=(int)r;
        //	for (int i=1; i<=c.getTensuu(); i++ ){ g.drawOval( gx(c.getTenx(i)-r),gy(c.getTeny(i)-r),2*ir,2*ir);} //�~
        //	for (int i=1; i<=c.getTensuu(); i++ ){ g.drawOval( gx(tnew[i].getx()-r),gy(tnew[i].gety()-r),2*ir,2*ir);} //�~
        g.setColor(Color.black);
        //	for (int i=1; i<=c.getTensuu(); i++ ){ g.drawString( text.valueOf(i),gx(c.getTenx(i)),gy(c.getTeny(i)));}
        for (int i = 1; i <= c.getBousuu(); i++) {
            if (c.getcolor(i) == 0) {
                g.setColor(Color.black);
            }
            if (c.getcolor(i) == 1) {
                g.setColor(Color.red);
            }
            if (c.getcolor(i) == 2) {
                g.setColor(Color.blue);
            }
            g.drawLine(gx(c.getmaex(i)), gy(c.getmaey(i)), gx(c.getatox(i)), gy(c.getatoy(i))); //��?�
            //g.drawLine( gx(tnew[c.getmae(i)].getx()),gy(tnew[c.getmae(i)].gety()), gx(tnew[c.getato(i)].getx()),gy(tnew[c.getato(i)].gety())); //��?�
        }
    }


    //�W�J?}�̕`�� with camera-----------------------------------------------------------------

    public void oekaki_with_camera(Graphics g) {
//System.out.println("?܂肽���� oekaki 001   c.getTenx(1) = "+c.getTenx(1));	
        Senbun s_tv = new Senbun();
        String text = "";//������?��?�p�̃N���X�̃C���X�^���X��
        g.setColor(Color.black);
        for (int i = 1; i <= c.getBousuu(); i++) {
            if (c.getcolor(i) == 0) {
                g.setColor(Color.black);
            }
            if (c.getcolor(i) == 1) {
                g.setColor(Color.red);
            }
            if (c.getcolor(i) == 2) {
                g.setColor(Color.blue);
            }

            s_tv.set(camera.object2TV(c.get_Senbun_from_Bou_id(i)));

            g.drawLine(gx(s_tv.getax()), gy(s_tv.getay()), gx(s_tv.getbx()), gy(s_tv.getby())); //��?�
        }
    }

    // ------------------------------
    public void oekaki_Ten_id_with_camera(Graphics g, int i) {    //�_��`��
        Ten tn = new Ten();
        tn.set(camera.object2TV(c.getTen(i)));
        int ir = 7;//���a
        g.setColor(new Color(0, 255, 255, 100));//?�?F
        g.fillOval(gx(tn.getx()) - ir, gy(tn.gety()) - ir, 2 * ir, 2 * ir); //�~
    }

    // ------------------------------
    public void oekaki_Ten_id_with_camera_green(Graphics g, int i) {    //�_��`��
        Ten tn = new Ten();
        tn.set(camera.object2TV(c.getTen(i)));
        int ir = 15;//���a
        g.setColor(new Color(0, 255, 0, 100));//��?F
        g.fillOval(gx(tn.getx()) - ir, gy(tn.gety()) - ir, 2 * ir, 2 * ir); //�~
    }


//g.setColor(Color.cyan);


    public void oekaki_Ten_id_with_camera(Graphics g, int i, int ip4) {
        //�_��`��
        Ten tn = new Ten();
        tn.set(camera.object2TV(c.getTen(i)));
        int ir = 10;//���a
        g.setColor(new Color(0, 255, 0, 50));//��?F

        if (ip4 == 0) {
            tn.set(cam_omote.object2TV(c.getTen(i)));
            g.fillOval(gx(tn.getx()) - ir, gy(tn.gety()) - ir, 2 * ir, 2 * ir); //�~
        }
        if (ip4 == 1) {
            tn.set(cam_ura.object2TV(c.getTen(i)));
            g.fillOval(gx(tn.getx()) - ir, gy(tn.gety()) - ir, 2 * ir, 2 * ir); //�~
        }
        if ((ip4 == 2) || (ip4 == 3)) {
            tn.set(cam_omote.object2TV(c.getTen(i)));
            g.fillOval(gx(tn.getx()) - ir, gy(tn.gety()) - ir, 2 * ir, 2 * ir); //�~
            tn.set(cam_ura.object2TV(c.getTen(i)));
            g.fillOval(gx(tn.getx()) - ir, gy(tn.gety()) - ir, 2 * ir, 2 * ir); //�~
        }

    }


    public void oekaki_with_camera(Graphics g, int ip4) {

        Senbun s_tv = new Senbun();
        String text = "";//������?��?�p�̃N���X�̃C���X�^���X��
        g.setColor(Color.black);
        for (int i = 1; i <= c.getBousuu(); i++) {
            if (c.getcolor(i) == 0) {
                g.setColor(Color.black);
            }
            if (c.getcolor(i) == 1) {
                g.setColor(Color.red);
            }
            if (c.getcolor(i) == 2) {
                g.setColor(Color.blue);
            }

            if (ip4 == 0) {
                s_tv.set(cam_omote.object2TV(c.get_Senbun_from_Bou_id(i)));
                g.drawLine(gx(s_tv.getax()), gy(s_tv.getay()), gx(s_tv.getbx()), gy(s_tv.getby())); //��?�
            }
            if (ip4 == 1) {
                s_tv.set(cam_ura.object2TV(c.get_Senbun_from_Bou_id(i)));
                g.drawLine(gx(s_tv.getax()), gy(s_tv.getay()), gx(s_tv.getbx()), gy(s_tv.getby())); //��?�
            }
            if ((ip4 == 2) || (ip4 == 3)) {
                s_tv.set(cam_omote.object2TV(c.get_Senbun_from_Bou_id(i)));
                g.drawLine(gx(s_tv.getax()), gy(s_tv.getay()), gx(s_tv.getbx()), gy(s_tv.getby())); //��?�
                s_tv.set(cam_ura.object2TV(c.get_Senbun_from_Bou_id(i)));
                g.drawLine(gx(s_tv.getax()), gy(s_tv.getay()), gx(s_tv.getbx()), gy(s_tv.getby())); //��?�
            }


            //g.drawLine( gx(s_tv.getax()),gy(s_tv.getay()),gx(s_tv.getbx()),gy(s_tv.getby())); //��?�
        }
    }


    public void oekaki_kijyunmen_id_with_camera(Graphics g) {
        //�ʓ����̓_��`��
        Ten tn = new Ten();
        //tn.reset();
        tn.set(camera.object2TV(ten_of_kijyunmen_ob));

        g.setColor(new Color(200, 50, 255, 90));
        g.fillOval(gx(tn.getx()) - 50, gy(tn.gety()) - 50, 100, 100); //�~

        g.setColor(Color.yellow);
        g.fillOval(gx(tn.getx()) - 5, gy(tn.gety()) - 5, 10, 10); //�~
        g.setColor(Color.black);
        g.drawOval(gx(tn.getx()) - 5, gy(tn.gety()) - 5, 10, 10); //�~
        g.setColor(Color.black);

    }


    //---------------------------------------------------
    public void Ten_awase(double r) {
        c.Ten_awase(r);
    }

    public void Ten_Bou_awase(double r) {
        c.Ten_Bou_awase(r);
    }

    //-------------------------------------------------


    public int get_ten_sentakusuu() {
        return c.get_ten_sentakusuu();
    }


    //--------------------
    public void set_ten_sentaku_1(int i) {
        c.set_ten_sentaku_1(i);
    }

    //--------------------
    public void set_ten_sentaku_0(int i) {
        c.set_ten_sentaku_0(i);
    }

    //--------------------
    public void set_all_ten_sentaku_0() {
        c.set_all_ten_sentaku_0();
    }

    //--------------------
    public void change_ten_sentaku(int i) {
        c.change_ten_sentaku(i);
    }

    //--------------------
    public byte get_ten_sentaku(int i) {
        return c.get_ten_sentaku(i);
    }//i�Ԗڂ̓_�̑I��?�Ԃ��O���P���𓾂�

    //-----------------uuuuuuu---


    double d_h_k = 10.0;//���̋������߂��ߖT���̔��苗��

    //�^����ꂽ?��W�ƈ��̋������߂��ߖT�ɂ�����?A����?ł��߂��_�̔�?���Ԃ�?B����?A���̋����ȓ���Ten���Ȃ��Ȃ�0��Ԃ�?B
    public int mottomo_tikai_Tenid_with_camera(Ten p0) {//�W�J?}�p
        Ten p = new Ten();
        p.set(camera.TV2object(p0));

        return c.mottomo_tikai_Tenid(p, d_h_k / camera.get_camera_bairitsu_x());
    }


    //�^����ꂽ?��W�ƈ��̋������߂��ߖT�ɂ�����?A����?ł��߂��_�̔�?���Ԃ�?B����?A���̋����ȓ���Ten���Ȃ��Ȃ�0��Ԃ�?B
    public int mottomo_tikai_Tenid_with_camera(Ten p0, int ip4) {//?܂�?オ��?}�p
        Ten p = new Ten();
        if (ip4 == 0) {
            p.set(cam_omote.TV2object(p0));
            return c.mottomo_tikai_Tenid(p, d_h_k / cam_omote.get_camera_bairitsu_x());
        }
        if (ip4 == 1) {
            p.set(cam_ura.TV2object(p0));
            return c.mottomo_tikai_Tenid(p, d_h_k / cam_ura.get_camera_bairitsu_x());
        }
        return 0;
    }


    //--------------------

    //�^����ꂽ?��W�ƈ��̋������߂��ߖT�ɂ�����?A����?ł��߂��_�̋�����Ԃ�?B����?A���̋����ȓ���Ten���Ȃ��Ȃ�1000000.0��Ԃ�?B
    public double mottomo_tikai_Ten_kyori_with_camera(Ten p0) {//p0��TV?��W?B���^?[�������̂�ob�ł̋���
        Ten p = new Ten();
        p.set(camera.TV2object(p0));
        return c.mottomo_tikai_Ten_kyori(p, d_h_k / camera.get_camera_bairitsu_x());
    }


    //�^����ꂽ?��W�ƈ��̋������߂��ߖT�ɂ�����?A����?ł��߂��_�̋�����Ԃ�?B����?A���̋����ȓ���Ten���Ȃ��Ȃ�1000000.0��Ԃ�?B
    public double mottomo_tikai_Ten_kyori_with_camera(Ten p0, int ip4) {//p0��TV?��W?B���^?[�������̂�ob�ł̋���
        Ten p = new Ten();
        if (ip4 == 0) {
            p.set(cam_omote.TV2object(p0));
            return c.mottomo_tikai_Ten_kyori(p, d_h_k / cam_omote.get_camera_bairitsu_x());
        }
        if (ip4 == 1) {
            p.set(cam_ura.TV2object(p0));
            return c.mottomo_tikai_Ten_kyori(p, d_h_k / cam_ura.get_camera_bairitsu_x());
        }
        return 1000000.0;
    }

    // ------------------------------
    public Ten getTen(int i) {
        return c.getTen(i);
    }


    // ---------------------------------------------------------------------------------------------
    public void set_Ubox_undo_suu(int i) {
        Ubox.set_i_undo_suu(i);
    }

//String s_title=new String(); //�t��?[����?�?�[��?o�Ă���^�C�g����ێ?���邽�߂Ɏg�p

    public void kiroku() {
        Ubox.kiroku(getMemo());
    }


    public void undo() {
        setMemo_for_redo_undo(Ubox.undo());

    }


    public void redo() {
        setMemo_for_redo_undo(Ubox.redo());


    }


    public Memo getMemo() {
        return c.getMemo();
    }


    public void setMemo_for_redo_undo(Memo memo1) {//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<undo,redo�ł�kiroku�����p

        c.setMemo(memo1);
    }


//?܂�?オ��?}�ό`�ŕ�?X�����̂�?@c.sentaku_ten_move(p_u);c��Tensyuugou


}   //?@ class Tenkaizu_Syokunin  �͂����܂łł�