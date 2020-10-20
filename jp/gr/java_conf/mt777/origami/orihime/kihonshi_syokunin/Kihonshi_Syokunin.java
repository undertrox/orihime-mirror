package jp.gr.java_conf.mt777.origami.orihime.kihonshi_syokunin;

import jp.gr.java_conf.mt777.kiroku.memo.Memo;
import jp.gr.java_conf.mt777.origami.dougu.camera.Camera;
import jp.gr.java_conf.mt777.origami.dougu.senbunsyuugou.Senbunsyuugou;
import jp.gr.java_conf.mt777.zukei2d.oritacalc.OritaCalc;
import jp.gr.java_conf.mt777.zukei2d.oritaoekaki.OritaOekaki;
import jp.gr.java_conf.mt777.zukei2d.senbun.Senbun;
import jp.gr.java_conf.mt777.zukei2d.takakukei.Takakukei;
import jp.gr.java_conf.mt777.zukei2d.ten.Ten;

import java.awt.*;

// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
public class Kihonshi_Syokunin {
    OritaCalc oc = new OritaCalc(); //�e��v�Z�p�̊�?����g�����߂̃N���X�̃C���X�^���X��
    double r = 3.0;                   //��{�}?\���̒�??�̗��[�̉~�̔��a?A�}�Ɗe��|�C���g�̋߂��̔����??
    int icol;//??����?F
    int taisyousei;

    Ten pa = new Ten(); //�}�E�X�{�^���������ꂽ�ʒu����a�_�܂ł̃x�N�g��
    Ten pb = new Ten(); //�}�E�X�{�^���������ꂽ�ʒu����b�_�܂ł̃x�N�g��

    int ugokasi_mode = 0;    //�}�𓮂�����??��?[�h?B0=�Ȃɂ����Ȃ�?A1=a�_�𓮂���?A2=b�_�𓮂���?A3=�}��?s�ړ� ?A4=?V�K�ǉ�
    int ieda;              //�A�N�e�B�u�Ȏ}�̔�??

    int i_saigo_no_senbun_no_maru_kaku = 1;    //1�`��?A0�`���Ȃ�

    Senbunsyuugou k = new Senbunsyuugou();    //��{�}?\���̃C���X�^���X��
    // Senbunsyuugou k ;    //��{�}?\��
    Takakukei gomibako = new Takakukei(4);    //�S�~���̃C���X�^���X��
    Takakukei tyuuoutai = new Takakukei(4);    //�����т̃C���X�^���X��
    double tyuuoutai_xmin = 180.0;
    double tyuuoutai_xmax = 206.0;
    double tyuuoutai_ymin = 50.0;
    double tyuuoutai_ymax = 300.0;

    double kijyun_kakudo = 22.5; //<<<<<<<<<<<<<<<<<<<<<<<��??�p�x<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    //���͕��@�p�̃p��???[�^
    int nyuuryoku_houhou = 0;
    int nyuuryoku_kitei = 0;
    int kensa_houhou = 0;
    int nhi = 0;

    Ten nhTen = new Ten();
    Ten nhTen1 = new Ten();

    int kousi_haba = 24;  //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<�i�q??
    int i_kousi_x_min = -1000;
    int i_kousi_x_max = 2000;
    int i_kousi_y_min = -1000;
    int i_kousi_y_max = 1000;
    Camera camera = new Camera();

    //---------------------------------
    // Kihonshi_Syokunin(  Senbunsyuugou k0,double r0 ){  //�R���X�g���N�^
    public Kihonshi_Syokunin(double r0) {  //�R���X�g���N�^
        r = r0;
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

        taisyousei = 0;
    }


    //---------------------------------
    public void reset() {
        r = 2.0;
        k.reset();
        ugokasi_mode = 0;
        ieda = 0;
        icol = 0;
        taisyousei = 0;

        camera.reset();
    }

    //-----------------------------
    public void setMemo(Memo memo1) {
        k.setMemo(memo1);
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
    }

    //-----------------------------
    public void zen_yama_tani_henkan() {
        k.zen_yama_tani_henkan();
    }

    //----------------
    public void eda_kesi(double r) {
        k.eda_kesi(r);
    }

    //--------------------------------------------
    public void set(Senbunsyuugou ss) {
        k.set(ss);
    }

    //----------------------------------------------
    public Senbunsyuugou get() {
        return k;
    }

    //--------------------------------------------
    public void set_r(double r0) {
        r = r0;
    }

    //--------------------------------------------
    public void set_nyuuryoku_houhou(int i) {
        nyuuryoku_houhou = i;
    }

    //--------------------------------------------
    public void set_nyuuryoku_kitei(int i) {
        nyuuryoku_kitei = i;
        if (nyuuryoku_kitei == 1) {
            kousi_haba = 48;
        }
        if (nyuuryoku_kitei == 2) {
            kousi_haba = 24;
        }
        if (nyuuryoku_kitei == 3) {
            kousi_haba = 48;
        }
    }

    //--------------------------------------------
    public void set_kensa_houhou(int i) {
        kensa_houhou = i;
    }

    //--------------------------------------------
    public int getsousuu() {
        return k.getsousuu();
    }


    //-----------------------------
    public void set_kijyun_kakudo(double x) {
        kijyun_kakudo = x;
    } //<<<<<<<<<<<<<<<<<<<<<<<��??�p�x<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    //------------------------
    public Memo getMemo() {
        return k.getMemo();
    }

    //��?�?��̎w��
    public void settaisyousei(int i) {
        taisyousei = i;
    }

    public void setcolor(int i) {
        icol = i;
    }
    //


    //
   /*
      void 	k_kasseika(Ten t,double r){
       	//Ten p1=new Ten();

       if(nyuuryoku_kitei==1){
       //  p1.set(kitei_idou(p1));}
         t.set(kitei_idou(t));}
         k.kasseika( t,r);
     }

      //
     void k_set(Ten t){
       	Ten p1=new Ten();

       if(nyuuryoku_kitei==1){
         p1.set(kitei_idou(p1));}

         k.set( p1);
     }

      //--------------
      void   k_addsenbun(Ten t1,Ten t2){

	Ten p1=new Ten();
        Ten p2=new Ten();

	p1.set(t1);p2.set(t2);

        if(nyuuryoku_kitei==1){
         p1.set(kitei_idou(p1));
         p2.set(kitei_idou(p2));


	}

      k.addsenbun(p1,p2);
      }

    */

    //---------------------------------
    public int get_ieda() {
        return ieda;
    }


    //�s�v��??����?�������-----------------------------------------------
    public void gomisute() {

        for (int i = 1; i <= k.getsousuu(); i++) {
            int idel = 0;
            //if(gomibako.naibu(k.geta(i))>0){idel=1;}    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            //if(gomibako.kousa(k.get( i))){idel=1;}

            if (gomibako.totu_naibu(k.get(i)) == 1) {
                idel = 1;
            }


            if (idel == 1) {
                k.delsenbun(i);
                i = i - 1;
                ieda = k.getsousuu() + 1;    //<<<<<<<<<<<<<<<<<<
            }
        }
    }

    //�}�𓮂��������????��?s����??----------------------------------------------------
    public void eda_atosyori_01() {//�}�̒�����ς�����?A�}�S�̂�?s�ړ����Ĕ���?�����?B
        //�A�N�e�B�u�ȑт̈ʒu�����?�����
        Ten ab = new Ten(1, k.getb(ieda), -1, k.geta(ieda));//�A�N�e�B�u�Ȏ}��?A�_a����_b�֌������x�N�g��
        Ten ba = new Ten(1, k.geta(ieda), -1, k.getb(ieda));//�A�N�e�B�u�Ȏ}��?A�_a����_b�֌������x�N�g��

        int jeda;   //�A�N�e�B�u�Ȏ}�Ƌ߂��ʂ̎}
        int jbasyo; //�A�N�e�B�u�Ȏ}�Ƌ߂��ʂ̎}�̂ǂ����߂��̂����������߂̔�??

        //?@�A�N�e�B�u�Ȏ}��a�_?@��?@�ʂ̎}?@�Ƃ̋�����?@��?@���߂�????

        jeda = k.senbun_sagasi(k.geta(ieda), 2 * r, ieda);//�A�N�e�B�u�Ȏ}��a�_�Ƌ߂��ʂ̎}��??�߂�?B
        jbasyo = k.senbun_busyo_sagasi(jeda, k.geta(ieda), 2 * r);//�ʂ̎}�̂ǂ̕�?����߂�����??�߂�?B
        if ((jeda != 0) && (jbasyo == 1)) { //�A�N�e�B�u�Ȏ}��a�_��?A�ʂ̎}��a�_���߂�????
            k.seta(ieda, k.geta(jeda));
            k.setb(ieda, new Ten(1, k.geta(ieda), 1, ab));//����?����Ă������Ɠ����l�Ȃ̂�?A���̂܂܎g��?B
        }
        if ((jeda != 0) && (jbasyo == 2)) { //�A�N�e�B�u�Ȏ}��a�_��?A�ʂ̎}��b�_���߂�????
            k.seta(ieda, k.getb(jeda));
            k.setb(ieda, new Ten(1, k.geta(ieda), 1, ab));
        }

        //?@�A�N�e�B�u�Ȏ}��b�_?@��?@�ʂ̎}?@�Ƃ̋�����?@��?@���߂�????
        jeda = k.senbun_sagasi(k.getb(ieda), 2 * r, ieda);//�A�N�e�B�u�Ȏ}��b�_�Ƌ߂��ʂ̎}��??�߂�?B
        jbasyo = k.senbun_busyo_sagasi(jeda, k.getb(ieda), 2 * r);//�ʂ̎}�̂ǂ̕�?����߂�����??�߂�?B
        if ((jeda != 0) && (jbasyo == 1)) { //�A�N�e�B�u�Ȏ}��b�_��?A�ʂ̎}��a�_���߂�????
            k.setb(ieda, k.geta(jeda));
            k.seta(ieda, new Ten(1, k.getb(ieda), 1, ba));
        }
        if ((jeda != 0) && (jbasyo == 2)) { //�A�N�e�B�u�Ȏ}��b�_��?A�ʂ̎}��b�_���߂�????
            k.setb(ieda, k.getb(jeda));
            k.seta(ieda, new Ten(1, k.getb(ieda), 1, ba));
        }
    }


    //�}�𓮂��������????��?s����??----------------------------------------------------
    public void eda_atosyori_02() {//��[�̓_�������ړ����Ĕ��΂̒[�̓_�͓������Ȃ��Ŕ���?�����?B
        //�A�N�e�B�u�ȑт̈ʒu�����?�����

        int jeda;   //�A�N�e�B�u�Ȏ}�Ƌ߂��ʂ̎}
        int jbasyo; //�A�N�e�B�u�Ȏ}�Ƌ߂��ʂ̎}�̂ǂ����߂��̂����������߂̔�??
        if (k.getnagasa(ieda) >= r) {
            //?@�A�N�e�B�u�Ȏ}��a�_?@��?@�ʂ̎}�Ƃ̋�����?@��?@���߂�????
            jeda = k.senbun_sagasi(k.geta(ieda), r, ieda);//�A�N�e�B�u�Ȏ}��a�_�Ƌ߂��ʂ̎}��??�߂�?B
            jbasyo = k.senbun_busyo_sagasi(jeda, k.geta(ieda), r);//�ʂ̎}�̂ǂ̕�?����߂�����??�߂�?B
            if ((jeda != 0) && (jbasyo == 1)) {
                k.seta(ieda, k.geta(jeda));
            }//�A�N�e�B�u�Ȏ}��a�_��?A�ʂ̎}��a�_���߂�????
            if ((jeda != 0) && (jbasyo == 2)) {
                k.seta(ieda, k.getb(jeda));
            }//�A�N�e�B�u�Ȏ}��a�_��?A�ʂ̎}��b�_���߂�????

            //?@�A�N�e�B�u�Ȏ}(ieda)��b�_?@��?@�ʂ̎}(jeda)�Ƃ̋�����?@��?@���߂�????
            jeda = k.senbun_sagasi(k.getb(ieda), r, ieda);//�A�N�e�B�u�Ȏ}��b�_�Ƌ߂��ʂ̎}��??�߂�?B
            jbasyo = k.senbun_busyo_sagasi(jeda, k.getb(ieda), r);//�ʂ̎}�̂ǂ̕�?����߂�����??�߂�?B
            if ((jeda != 0) && (jbasyo == 1)) {
                k.setb(ieda, k.geta(jeda));
            }//�A�N�e�B�u�Ȏ}��b�_��?A�ʂ̎}��a�_���߂�????
            if ((jeda != 0) && (jbasyo == 2)) {
                k.setb(ieda, k.getb(jeda));
            }//�A�N�e�B�u�Ȏ}��b�_��?A�ʂ̎}��b�_���߂�????

            //�ȉ���070317�ɒǉ� ��?���??����?W�܂������_��ʂ̒��_�߂���??���Ă������Ƃ��̌�????�p
//150312?@?@2*r?@��?@r?@��?C?�


            //?@�A�N�e�B�u�Ȏ}��a�_?@��?@�ʂ̎}�Ƃ̋�����?@��?@���߂�????
            jeda = k.senbun_sagasi(k.geta(ieda), r, -10);//�A�N�e�B�u��ieda�}��a�_�Ƌ߂��ʂ̎}��??�߂�?B
            jbasyo = k.senbun_busyo_sagasi(jeda, k.geta(ieda), r);//�ʂ̎}�̂ǂ̕�?����߂�����??�߂�?B

            if ((jeda != 0) && (jbasyo == 1)) {
                k.kasseika(k.geta(jeda), r);
                k.set(k.geta(jeda));
            }//�A�N�e�B�u��ieda�}��a�_��?A�ʂ̎}��a�_���߂�????
            if ((jeda != 0) && (jbasyo == 2)) {
                k.kasseika(k.getb(jeda), r);
                k.set(k.getb(jeda));
            }//�A�N�e�B�u��ieda�}��a�_��?A�ʂ̎}��b�_���߂�????

            //?@�A�N�e�B�u�Ȏ}(ieda)��b�_?@��?@�ʂ̎}(jeda)�Ƃ̋�����?@��?@���߂�????
            jeda = k.senbun_sagasi(k.getb(ieda), r, -10);//�A�N�e�B�u��ieda�}��b�_�Ƌ߂��ʂ̎}��??�߂�?B
            jbasyo = k.senbun_busyo_sagasi(jeda, k.getb(ieda), r);//�ʂ̎}�̂ǂ̕�?����߂�����??�߂�?B

            if ((jeda != 0) && (jbasyo == 1)) {
                k.kasseika(k.geta(jeda), r);
                k.set(k.geta(jeda));
            }//�A�N�e�B�u��ieda�}��b�_��?A�ʂ̎}��a�_���߂�????
            if ((jeda != 0) && (jbasyo == 2)) {
                k.kasseika(k.getb(jeda), r);
                k.set(k.getb(jeda));
            }//�A�N�e�B�u��ieda�}��b�_��?A�ʂ̎}��b�_���߂�????
        }

    }

    public void bunkatu_seiri() {
        k.bunkatu_seiri();
    }

    public void bunkatu_seiri_for_Smen_hassei() {
        k.bunkatu_seiri_for_Smen_hassei();
    }//k�Ƃ�??��?W?��̂���?ASenbunsyuugou k =new Senbunsyuugou();

    public void kousabunkatu() {
        k.kousabunkatu();
    }

    public void ten_sakujyo() {
        k.ten_sakujyo();
    }

    public void ten_sakujyo(double r) {
        k.ten_sakujyo(r);
    }

    public void jyuufuku_senbun_sakujyo() {
        k.jyuufuku_senbun_sakujyo();
    }

    public void jyuufuku_senbun_sakujyo(double r) {
        k.jyuufuku_senbun_sakujyo(r);
    }


    //------------------------------------------------------------------------------
//��{�}�̕`��000000000000000000000000000000000000000000000000000000000000000000
//------------------------------------------------------------------------------
    public void oekaki(Graphics g, int iTenkaizuSenhaba) {
        String text = "";//������????�p�̃N���X�̃C���X�^���X��
        double d;
        OritaOekaki OO = new OritaOekaki();

        if (kensa_houhou == 1) {//��?��p
            int kr = 10;
            g.setColor(Color.red);
            for (int i = 1; i <= k.getsousuu(); i++) {
                if (oc.hitosii(k.geta(i), k.getb(i), r)) {
                    g.fillOval((int) k.getax(i) - kr, (int) k.getay(i) - kr, 2 * kr, 2 * kr); //�~
                }
            }
            for (int i = 1; i <= k.getsousuu() - 1; i++) {
                for (int j = i + 1; j <= k.getsousuu(); j++) {
                    if (oc.senbun_kousa_hantei(k.get(i), k.get(j)) == 31) {
                        OO.habaLine(g, k.get(i), kr, 1);//  ��??
                        g.fillOval((int) k.getax(i) - kr, (int) k.getay(i) - kr, 2 * kr, 2 * kr); //�~
                        g.fillOval((int) k.getbx(i) - kr, (int) k.getby(i) - kr, 2 * kr, 2 * kr); //�~
                    }
                }
            }
        }
        g.setColor(Color.black);

        //-------------------------------
        if (taisyousei > 0) {
            g.setColor(Color.green);
            tyuuoutai.oekaki(g);
            g.setColor(Color.black);
        }

        //  ���ݔ��̕`��
        g.setColor(new Color(150, 150, 150));
        //g.setColor(new Color(100,100,100));
        gomibako.oekaki(g);
        g.setColor(Color.black);
        g.drawString("���ݔ�", 18, 180);

        g.drawString("??����???@" + k.getsousuu(), 30, 50);

        //�`��
        Ten a = new Ten();
        Ten b = new Ten();
        int ir = (int) r;

        //���͋K�肪1?i�i�q?j��???��̊i�q??�̕`��
        if (nyuuryoku_kitei >= 1) {
            g.setColor(Color.gray);
            for (int i = 1; i <= 700 / kousi_haba; i++) {
                g.drawLine(0, kousi_haba * i, 1000, kousi_haba * i); //��??
            }
            for (int i = 1; i <= 1000 / kousi_haba; i++) {
                g.drawLine(kousi_haba * i, 0, kousi_haba * i, 700); //��??
            }
        }

        //��?�?�������???���????
        g.setColor(new Color(200, 200, 200));
        if (taisyousei > 0) {
            for (int i = 1; i <= k.getsousuu(); i++) {
                if ((k.geta(i).getx() < tyuuoutai_xmin)
                        ||
                        (k.getb(i).getx() < tyuuoutai_xmin)) {
                    a.set(k.geta(i));
                    b.set(k.getb(i));
                    a.set(tyuuoutai_xmin + tyuuoutai_xmax - a.getx(), a.gety());
                    b.set(tyuuoutai_xmin + tyuuoutai_xmax - b.getx(), b.gety());

                    g.drawLine((int) a.getx(), (int) a.gety(), (int) b.getx(), (int) b.gety()); //��??
                    g.drawOval((int) a.getx() - ir, (int) a.gety() - ir, 2 * ir, 2 * ir); //�~
                    g.drawOval((int) b.getx() - ir, (int) b.gety() - ir, 2 * ir, 2 * ir); //�~
                }
            }
        }
        g.setColor(Color.black);

        //��?�?��������Ă��Ȃ��Ă�?s���`��
        double L = 100.0;
        if (icol == -2) { //�p�x�n�picol=-2
            g.setColor(new Color(245, 245, 245));
            for (int i = 1; i <= k.getsousuu(); i++) {
                a.set(k.geta(i));
                b.set(k.getb(i));
                d = 0.0;
                while (d < 360.0) {
                    g.drawLine((int) a.getx(), (int) a.gety(), (int) (a.getx() + L * Math.cos(d * 3.14159265 / 180.0)), (int) (a.gety() + L * Math.sin(d * 3.14159265 / 180.0))); //��??
                    g.drawLine((int) b.getx(), (int) b.gety(), (int) (b.getx() + L * Math.cos(d * 3.14159265 / 180.0)), (int) (b.gety() + L * Math.sin(d * 3.14159265 / 180.0))); //��??
                    d = d + kijyun_kakudo;
                }
            }

            if (ieda <= k.getsousuu()) {
                g.setColor(new Color(205, 245, 245));
                d = 0.0;
                a.set(k.geta(ieda));
                b.set(k.getb(ieda));
                if (ugokasi_mode == 1) {
                    while (d < 360.0) {
                        g.drawLine((int) a.getx(), (int) a.gety(), (int) (a.getx() + L * Math.cos(d * 3.14159265 / 180.0)), (int) (a.gety() + L * Math.sin(d * 3.14159265 / 180.0))); //��??
                        //g.drawLine( (int)b.getx(),(int)b.gety(),(int)(b.getx()+L*Math.cos(d*3.14159265/180.0)),(int)(b.gety()+L*Math.sin(d*3.14159265/180.0))); //��??
                        d = d + kijyun_kakudo;
                    }
                }
                if (ugokasi_mode == 2) {
                    while (d < 360.0) {
                        //g.drawLine( (int)a.getx(),(int)a.gety(),(int)(a.getx()+L*Math.cos(d*3.14159265/180.0)),(int)(a.gety()+L*Math.sin(d*3.14159265/180.0))); //��??
                        g.drawLine((int) b.getx(), (int) b.gety(), (int) (b.getx() + L * Math.cos(d * 3.14159265 / 180.0)), (int) (b.gety() + L * Math.sin(d * 3.14159265 / 180.0))); //��??
                        d = d + kijyun_kakudo;
                    }
                }

                if (ugokasi_mode == 3) {
                    while (d < 360.0) {
                        g.drawLine((int) a.getx(), (int) a.gety(), (int) (a.getx() + L * Math.cos(d * 3.14159265 / 180.0)), (int) (a.gety() + L * Math.sin(d * 3.14159265 / 180.0))); //��??
                        g.drawLine((int) b.getx(), (int) b.gety(), (int) (b.getx() + L * Math.cos(d * 3.14159265 / 180.0)), (int) (b.gety() + L * Math.sin(d * 3.14159265 / 180.0))); //��??
                        d = d + kijyun_kakudo;
                    }
                }

                if (ugokasi_mode == 4) {
                    while (d < 360.0) {
                        //g.drawLine( (int)a.getx(),(int)a.gety(),(int)(a.getx()+L*Math.cos(d*3.14159265/180.0)),(int)(a.gety()+L*Math.sin(d*3.14159265/180.0))); //��??
                        g.drawLine((int) b.getx(), (int) b.gety(), (int) (b.getx() + L * Math.cos(d * 3.14159265 / 180.0)), (int) (b.gety() + L * Math.sin(d * 3.14159265 / 180.0))); //��??
                        d = d + kijyun_kakudo;
                    }
                }
            }
        }

/*
      int itemp=0;
      for (int i=1; i<=k.getsousuu()-1; i++ ){
      for (int j=i+1; j<=k.getsousuu(); j++ ){
            if(oc.senbun_kousa_hantei(k.get(i),k.get(j))!=0) {
             g.drawString("��?��_?@"+text.valueOf(oc.senbun_kousa_hantei(k.get(i),k.get(j)) ),30,150+10*itemp);
	     itemp++;
	    }

      }
      }
*/

        for (int i = 1; i <= k.getsousuu(); i++) {
            a.set(k.geta(i));
            b.set(k.getb(i));
            if (k.getcolor(i) == 0) {
                g.setColor(Color.black);
            }
            if (k.getcolor(i) == 1) {
                g.setColor(Color.red);
            }
            if (k.getcolor(i) == 2) {
                g.setColor(Color.blue);
            }
            if (icol == -1) {
            }
            if (icol == -2) {
                g.setColor(new Color(100, 200, 0));//�|?F
                if (oc.kakudozure(k.get(i), kijyun_kakudo) < 2.0) {
                    g.setColor(new Color(200, 100, 0));//������?F
                }
                if (oc.kakudozure(k.get(i), kijyun_kakudo) < 0.5) {
                    g.setColor(Color.black);
                }
            }
            g.drawLine((int) a.getx(), (int) a.gety(), (int) b.getx(), (int) b.gety()); //��??

            if (iTenkaizuSenhaba != 1) {
                OO.habaLine(g, k.get(i), iTenkaizuSenhaba, k.getcolor(i));
            }//  ��??
            //  OO.habaLine( g,k.get(i),ir,k.getcolor(i));//  ��??

            g.setColor(Color.white);
            g.fillOval((int) a.getx() - ir, (int) a.gety() - ir, 2 * ir, 2 * ir); //�~
            g.fillOval((int) b.getx() - ir, (int) b.gety() - ir, 2 * ir, 2 * ir); //�~

            g.setColor(Color.black);
            g.drawOval((int) a.getx() - ir, (int) a.gety() - ir, 2 * ir, 2 * ir); //�~
            g.drawOval((int) b.getx() - ir, (int) b.gety() - ir, 2 * ir, 2 * ir); //�~
        }
        g.setColor(Color.black);
    }


    //------------------------------------------------------------------------------
//��{�}�̕`��111111111111111111111111111111111111111111111111111111111111111111
//------------------------------------------------------------------------------
    public void oekaki_with_camera(Graphics g, int iTenkaizuSenhaba) {
        String text = "";//������????�p�̃N���X�̃C���X�^���X��
        double d;
        OritaOekaki OO = new OritaOekaki();

        Senbun s_tv = new Senbun();
        Ten a = new Ten();
        Ten b = new Ten();
        int ir = (int) (r * camera.get_camera_bairitsu_x());

        //�i�q??�̕`��
        Senbun s_ob = new Senbun();
        //���͋K�肪1��2?i?����i�q?j��???��̊i�q??�̕`��


        if ((nyuuryoku_kitei == 1) || (nyuuryoku_kitei == 2)) {
            g.setColor(Color.gray);
            for (int i = i_kousi_y_min / kousi_haba; i <= i_kousi_y_max / kousi_haba; i++) {
//				g.drawLine( 	i_kousi_x_min,	kousi_haba*i,	i_kousi_x_max,	kousi_haba*i); //��??
                s_ob.set(i_kousi_x_min, kousi_haba * i, i_kousi_x_max, kousi_haba * i);
                s_tv.set(camera.object2TV(s_ob));
                g.drawLine((int) s_tv.getax(), (int) s_tv.getay(), (int) s_tv.getbx(), (int) s_tv.getby()); //��??

            }
            for (int i = i_kousi_x_min / kousi_haba; i <= i_kousi_x_max / kousi_haba; i++) {
//				g.drawLine(	kousi_haba*i,	i_kousi_y_min,	kousi_haba*i,	i_kousi_y_max); //��??
                s_ob.set(kousi_haba * i, i_kousi_y_min, kousi_haba * i, i_kousi_y_max);
                s_tv.set(camera.object2TV(s_ob));
                g.drawLine((int) s_tv.getax(), (int) s_tv.getay(), (int) s_tv.getbx(), (int) s_tv.getby()); //��??

            }


            //�i�q�_�Ɋۂ�`��

            g.setColor(Color.gray);
            Ten t_ob = new Ten();
            Ten t_tv = new Ten();
            for (int i = i_kousi_x_min / kousi_haba; i <= i_kousi_x_max / kousi_haba; i++) {
                for (int j = i_kousi_y_min / kousi_haba; j <= i_kousi_y_max / kousi_haba; j++) {
                    t_ob.set(kousi_haba * i, kousi_haba * j);
                    t_tv.set(camera.object2TV(t_ob));
                    g.drawOval((int) t_tv.getx() - ir, (int) t_tv.gety() - ir, 2 * ir, 2 * ir); //�~

                }
            }


        }

        //���͋K�肪1��3?i�O�p�i�q?j��???��̊i�q??�̕`��


        double sqr3 = 1.732051;
        double sankaku_kousi_takasa;
        sankaku_kousi_takasa = kousi_haba * sqr3 / 2.0;
        if (nyuuryoku_kitei == 3) {
            g.setColor(Color.gray);
            for (int i = -30; i <= 30; i++) {
//				g.drawLine( 	-3000,	sankaku_kousi_haba*i,	3000,	sankaku_kousi_haba*i); //��??
                s_ob.set(-3000, sankaku_kousi_takasa * i, 3000, sankaku_kousi_takasa * i);
                s_tv.set(camera.object2TV(s_ob));
                g.drawLine((int) s_tv.getax(), (int) s_tv.getay(), (int) s_tv.getbx(), (int) s_tv.getby()); //��??

            }

            //  y=sqr3*x + 2.0*sankaku_kousi_haba*i
            for (int i = -30; i <= 30; i++) {
                s_ob.set(-3000, -3000.0 * sqr3 + 2.0 * sankaku_kousi_takasa * i, 3000, 3000.0 * sqr3 + 2.0 * sankaku_kousi_takasa * i);
                s_tv.set(camera.object2TV(s_ob));
                g.drawLine((int) s_tv.getax(), (int) s_tv.getay(), (int) s_tv.getbx(), (int) s_tv.getby()); //��??
            }


            //  y=-sqr3*x + sankaku_kousi_haba*i
            for (int i = -30; i <= 30; i++) {
                s_ob.set(-3000, -3000.0 * (-sqr3) + 2.0 * sankaku_kousi_takasa * i, 3000, 3000.0 * (-sqr3) + 2.0 * sankaku_kousi_takasa * i);
                s_tv.set(camera.object2TV(s_ob));
                g.drawLine((int) s_tv.getax(), (int) s_tv.getay(), (int) s_tv.getbx(), (int) s_tv.getby()); //��??
            }

            //�i�q�_�Ɋۂ�`��

            g.setColor(Color.gray);
            Ten t_ob = new Ten();
            Ten t_tv = new Ten();
            for (int i = -30; i <= 30; i++) {
                for (int j = -30; j <= 30; j = j + 2) {
                    t_ob.set(kousi_haba * i, sankaku_kousi_takasa * j);
                    t_tv.set(camera.object2TV(t_ob));
                    g.drawOval((int) t_tv.getx() - ir, (int) t_tv.gety() - ir, 2 * ir, 2 * ir); //�~
                }
                for (int j = -31; j <= 31; j = j + 2) {
                    t_ob.set(kousi_haba * i + kousi_haba / 2.0, sankaku_kousi_takasa * j);
                    t_tv.set(camera.object2TV(t_ob));
                    g.drawOval((int) t_tv.getx() - ir, (int) t_tv.gety() - ir, 2 * ir, 2 * ir); //�~
                }

            }


        }


        //camera��?S��?\���ŕ`��
        OO.jyuuji(g, camera.object2TV(camera.get_camera_ichi()), 5.0, 2.0, 3);


        //�W�J?}�̕`��

        for (int i = 1; i <= k.getsousuu() - 1; i++) {

            if (k.getcolor(i) == 0) {
                g.setColor(Color.black);
            }
            if (k.getcolor(i) == 1) {
                g.setColor(Color.red);
            }
            if (k.getcolor(i) == 2) {
                g.setColor(Color.blue);
            }

            s_tv.set(camera.object2TV(k.get(i)));
            a.set(s_tv.geta());
            b.set(s_tv.getb());

            g.drawLine((int) a.getx(), (int) a.gety(), (int) b.getx(), (int) b.gety()); //��??
            if (iTenkaizuSenhaba != 1) {
                OO.habaLine(g, s_tv, iTenkaizuSenhaba, k.getcolor(i));
            }//  ��??

            //OO.habaLine( g,s_tv,iTenkaizuSenhaba,k.getcolor(i));

            g.setColor(Color.white);
            g.fillOval((int) a.getx() - ir, (int) a.gety() - ir, 2 * ir, 2 * ir); //�~
            g.fillOval((int) b.getx() - ir, (int) b.gety() - ir, 2 * ir, 2 * ir); //�~

            g.setColor(Color.black);
            g.drawOval((int) a.getx() - ir, (int) a.gety() - ir, 2 * ir, 2 * ir); //�~
            g.drawOval((int) b.getx() - ir, (int) b.gety() - ir, 2 * ir, 2 * ir); //�~
        }

        int i = k.getsousuu();

        if (i != 0) {

            if (k.getcolor(i) == 0) {
                g.setColor(Color.black);
            }
            if (k.getcolor(i) == 1) {
                g.setColor(Color.red);
            }
            if (k.getcolor(i) == 2) {
                g.setColor(Color.blue);
            }

            s_tv.set(camera.object2TV(k.get(i)));
            a.set(s_tv.geta());
            b.set(s_tv.getb());

            g.drawLine((int) a.getx(), (int) a.gety(), (int) b.getx(), (int) b.gety()); //��??
            if (iTenkaizuSenhaba != 1) {
                OO.habaLine(g, s_tv, iTenkaizuSenhaba, k.getcolor(i));
            }//  ��??

            if (i_saigo_no_senbun_no_maru_kaku == 1) {
                g.setColor(Color.white);
                g.fillOval((int) a.getx() - ir, (int) a.gety() - ir, 2 * ir, 2 * ir); //�~
                g.fillOval((int) b.getx() - ir, (int) b.gety() - ir, 2 * ir, 2 * ir); //�~

                g.setColor(Color.black);
                g.drawOval((int) a.getx() - ir, (int) a.gety() - ir, 2 * ir, 2 * ir); //�~
                g.drawOval((int) b.getx() - ir, (int) b.gety() - ir, 2 * ir, 2 * ir); //�~

            }
        }


        g.setColor(Color.black);
    }


//--------------------------------------------------------------------------------------
//�}�E�X��??----------------------------------------------------------------------------
//--------------------------------------------------------------------------------------


    //�}�E�X��??(�{�^�����������Ƃ�)����??��----------------------------------------------------
    public void mPressed(Ten p) {
        //�S�~�����N���b�N���ꂽ��?A�P�Ƃ�??����???�����

        if (gomibako.naibu(p) >= 1) {
            k.tanSenbun_sakujyo(r);
            nhi = 0;//���͕��@�����p�`��???���?�������?s��
        }

        //
        if (nyuuryoku_houhou != 2) {
            nhi = 0;
        }

        if (nyuuryoku_houhou <= 1) {

            if (nyuuryoku_houhou == 1) {
                int mtsid = k.mottomo_tikai_senbun_sagasi(p);
                k.addsenbun(k.getb(mtsid), p);

                k.set(mtsid, k.geta(mtsid), p, k.getcolor(mtsid), 0);
                k.setcolor(k.getsousuu(), k.getcolor(mtsid));
                if (icol >= 0) {
                    k.set(mtsid, k.geta(mtsid), p, icol, 0);
                    k.setcolor(k.getsousuu(), icol);

                }
            }

            //�}�E�X�Ƌ߂��ʒu�ɂ���}��T��?B
            ieda = k.senbun_sagasi(p, r, 0);
            //��{�}?\���̒���?A�ǂ̎}�Ƃ�����?????B
            if (ieda == 0) {
                k.addsenbun(p, p);
                ieda = k.getsousuu();
                ugokasi_mode = 4;
                if (icol >= 0) {
                    k.setcolor(ieda, icol);
                }
            }
            //��{�}?\���̒���?A�ǂꂩ�̎}�ɋ߂�?????B
            else {
                if (1 == k.senbun_busyo_sagasi(ieda, p, r)) {
                    ugokasi_mode = 1;
                } //a�_�ɋ߂�?????B
                if (2 == k.senbun_busyo_sagasi(ieda, p, r)) {
                    ugokasi_mode = 2;
                } //b�_�ɋ߂�?????B
                if (3 == k.senbun_busyo_sagasi(ieda, p, r)) {                 //���̕����ɋ߂�?????B
                    pa.set(1, k.geta(ieda), -1, p);
                    pb.set(1, k.getb(ieda), -1, p);
                    ugokasi_mode = 3;
                    if (icol >= 0) {
                        k.setcolor(ieda, icol);
                    }
                }
            }

            System.out.print("ieda = ");
            System.out.println(ieda);
          /*     System.out.print("6:") ;
		System.out.print(k.getax(6)) ;System.out.print(",") ;
	        System.out.print(k.getay(6)) ;System.out.print(",") ;
		System.out.print(k.getbx(6)) ;System.out.print(",") ;
	        System.out.print(k.getby(6)) ;System.out.println(",");
                System.out.print("7:") ;
		System.out.print(k.getax(7)) ;System.out.print(",") ;
	        System.out.print(k.getay(7)) ;System.out.print(",") ;
		System.out.print(k.getbx(7)) ;System.out.print(",") ;
	        System.out.print(k.getby(7)) ;System.out.println(",,,") ;
                System.out.println(oc.senbun_kousa_hantei(k.get(6),k.get(7)));
	   */
            k.kasseika(p, r);
        }
        //--------------
        if (nyuuryoku_houhou == 2) {
	    /*     ugokasi_mode=0;
	     		// �}�̕�?s�ړ��͂ł���悤�ɂ���?B
                ieda=k.senbun_sagasi(p,r,0);
				//��{�}?\���̒���?A�ǂꂩ�̎}�ɋ߂�?????B
		if( ieda!=0){
			if(3==k.senbun_busyo_sagasi(ieda,p,r)){                 //���̕����ɋ߂�?????B
				pa.set(1,k.geta(ieda),-1,p);
				pb.set(1,k.getb(ieda),-1,p);
				ugokasi_mode=3 ;
				if(icol>=0){k.setcolor(ieda,icol);}
			}
		k.kasseika(p,r);
                }

		//


	        //---------

	       else{ */

            nhi = nhi + 1;

            //System.out.print("nh1 = ");System.out.print("nh1 = ")

            if (nhi == 1) {
                k.addsenbun(p, p);
                nhTen = p;
                for (int i = 1; i <= k.getsousuu() - 1; i++) {
                    if (oc.hitosii(k.geta(i), p, 2.0 * r)) {
                        k.set(k.getsousuu(), k.geta(i), k.geta(i), 0, 0);
                        nhTen = k.geta(i);
                        break;
                    }
                    if (oc.hitosii(k.getb(i), p, 2.0 * r)) {
                        k.set(k.getsousuu(), k.getb(i), k.getb(i), 0, 0);
                        nhTen = k.getb(i);
                        break;
                    }
                }


            }
            if (nhi != 1) {   // set(int i, Ten p,Ten q,int ic,int ia)

                k.addsenbun(nhTen, p);
                for (int i = 1; i <= k.getsousuu() - 1; i++) {
                    if (oc.hitosii(k.geta(i), p, 2.0 * r)) {
                        k.set(k.getsousuu(), k.geta(i), k.getb(k.getsousuu() - 1), 0, 0);
                        nhi = 0;
                        break;
                    }
                    if (oc.hitosii(k.getb(i), p, 2.0 * r)) {
                        k.set(k.getsousuu(), k.getb(i), k.getb(k.getsousuu() - 1), 0, 0);
                        nhi = 0;
                        break;
                    }
                }
                nhTen = p;
            }

            if (icol >= 0) {
                k.setcolor(k.getsousuu(), icol);
            }
        }

        //--------------
        if (nyuuryoku_houhou == 2) {

        }


    }

    //�}�E�X��??(�h���b�O�����Ƃ�)��?s����??----------------------------------------------------
    public void mDragged(Ten p) {

        if (nyuuryoku_houhou <= 1) {

            if (ugokasi_mode == 1) {
                k.set(p);
            } //a�_���?X
            if (ugokasi_mode == 2) {
                k.set(p);
            } //b�_���?X
            if (ugokasi_mode == 3) {//�}��?s�ړ�
                k.seta(ieda, new Ten(1, p, 1, pa));
                k.setb(ieda, new Ten(1, p, 1, pb));
            }
            if (ugokasi_mode == 4) {
                k.set(p);
            } //a�_���?X(ugokasi_mode==1)�Ɠ�����??������

        }
        //--------------
        if (nyuuryoku_houhou == 1) {
	    /*
		if(ugokasi_mode==3){//�}��?s�ړ�
			k.seta(ieda,new Ten(1,p,1,pa));
			k.setb(ieda,new Ten(1,p,1,pb));
		}
	     */
        }

        //--------------
        if (nyuuryoku_houhou == 2) {

        }


    }

    //�}�E�X��??(�{�^���𗣂����Ƃ�)��?s����??----------------------------------------------------
    public void mReleased(Ten p) {

        if (nyuuryoku_houhou <= 1) {

            if (ugokasi_mode == 1) {
                k.set(p);
            } //a�_���?X
            if (ugokasi_mode == 2) {
                k.set(p);
            } //b�_���?X
            if (ugokasi_mode == 3) {//�}��?s�ړ�
                k.seta(ieda, new Ten(1, p, 1, pa));
                k.setb(ieda, new Ten(1, p, 1, pb));
                if (ugokasi_mode == 4) {
                    k.set(p);
                }//a�_���?X(ugokasi_mode==1)�Ɠ�����??������

            }
            //

            //eda_atosyori_01();                //�}�̒�����ς�����?A�}�S�̂�?s�ړ����Ĕ���?�����?B<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            eda_atosyori_02();                //��[�̓_�������ړ����Ĕ��΂̒[�̓_�͓������Ȃ��Ŕ���?�����?B <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


            //----------�i�q��?悹��
            if ((nyuuryoku_kitei == 1) || (nyuuryoku_kitei == 2)) {
                //  int i=get_ieda();
                //  k.seta(i,kitei_idou(k.geta(i)));
                //  k.setb(i,kitei_idou(k.getb(i)));

                // k.set(kitei_idou(p)) ;


                for (int i = 1; i <= k.getsousuu(); i++) {
                    // Ten tn=new Ten();
                    //tn.set(k.get(i));
                    //   k.set(i,kitei_idou(k.geta(i)));

                    System.out.print("iactive ");
                    System.out.print(i);
                    System.out.print(": ");
                    System.out.println(k.getiactive(i));
                    if (k.getiactive(i) >= 1) {
                        k.seta(i, kitei_idou(k.geta(i)));
                        k.setb(i, kitei_idou(k.getb(i)));
                    }

                }
                /**/

            }


            k.hikasseika(); //��?���

            //��?�?�������???���????
            if (taisyousei > 0) {
                if (((tyuuoutai_xmin < k.geta(ieda).getx()) && (k.geta(ieda).getx() < tyuuoutai_xmax))
                        &&
                        ((tyuuoutai_xmin < k.getb(ieda).getx()) && (k.getb(ieda).getx() < tyuuoutai_xmax))) {
                    k.seta(ieda, new Ten((tyuuoutai_xmin + tyuuoutai_xmax) / 2, k.geta(ieda).gety()));
                    k.setb(ieda, new Ten((tyuuoutai_xmin + tyuuoutai_xmax) / 2, k.getb(ieda).gety()));
                }
            }

            //�S�~�̂�?B?@��������ƃA�N�e�B�u��ieda�}�̔�??�������̂�?A�ꉞeda_atosyori�̌�ł��悤�ɂ���?B
            if ((ugokasi_mode == 4) && (k.getnagasa(k.getsousuu()) < r)) { //?V�K�ǉ�����??�����_?��?i������r���?�����?j�Ƃ�?????B
                k.delsenbun(k.getsousuu());
            } else {
                gomisute();//���ݔ��ɓ�����??����?���
            }


        }
        //--------------
        if (nyuuryoku_houhou == 1) {

        }

        //--------------
        if (nyuuryoku_houhou == 2) {

        }
    }


    //000000000000000000000000000000000000000000000000000000000000000000000000000000000
    //�}�E�X��??(i_mouse_modeA==0?@����???@���{�̂��߂Ɏc���Ă���?B???���----------------------------------------------------
    public void mPressed_A_00(Ten p) {
        //�S�~�����N���b�N���ꂽ��?A�P�Ƃ�??����???�����
        if (gomibako.naibu(p) >= 1) {
            k.tanSenbun_sakujyo(r);
            nhi = 0;//���͕��@�����p�`��???���?�������?s��
        }
        // nyuuryoku_houhou�͓��͕��@�̎w��?B0�Ȃ��?��̕��@?A1�Ȃ瑽�p�`����?A�Q�Ȃ璼??���w�肵���_�Ɉ����񂹂�
        if (nyuuryoku_houhou != 2) {
            nhi = 0;
        }
        if (nyuuryoku_houhou <= 1) {
            if (nyuuryoku_houhou == 1) {
                int mtsid = k.mottomo_tikai_senbun_sagasi(p);
                k.addsenbun(k.getb(mtsid), p);

                k.set(mtsid, k.geta(mtsid), p, k.getcolor(mtsid), 0);
                k.setcolor(k.getsousuu(), k.getcolor(mtsid));
                if (icol >= 0) {
                    k.set(mtsid, k.geta(mtsid), p, icol, 0);
                    k.setcolor(k.getsousuu(), icol);
                }
            }

            //�}�E�X�Ƌ߂��ʒu�ɂ���}��T��?B
            ieda = k.senbun_sagasi(p, r, 0);
            //��{�}?\���̒���?A�ǂ̎}�Ƃ�����?????B
            if (ieda == 0) {
                k.addsenbun(p, p);
                ieda = k.getsousuu();
                ugokasi_mode = 4;
                if (icol >= 0) {
                    k.setcolor(ieda, icol);
                }
            }
            //��{�}?\���̒���?A�ǂꂩ�̎}�ɋ߂�?????B
            else {
                if (1 == k.senbun_busyo_sagasi(ieda, p, r)) {
                    ugokasi_mode = 1;
                } //a�_�ɋ߂�?????B
                if (2 == k.senbun_busyo_sagasi(ieda, p, r)) {
                    ugokasi_mode = 2;
                } //b�_�ɋ߂�?????B
                if (3 == k.senbun_busyo_sagasi(ieda, p, r)) {                 //���̕����ɋ߂�?????B
                    pa.set(1, k.geta(ieda), -1, p);
                    pb.set(1, k.getb(ieda), -1, p);
                    ugokasi_mode = 3;
                    if (icol >= 0) {
                        k.setcolor(ieda, icol);
                    }
                }
            }
            System.out.print("ieda = ");
            System.out.println(ieda);
            k.kasseika(p, r);
        }
        //--------------
        if (nyuuryoku_houhou == 2) {
            nhi = nhi + 1;
            //System.out.print("nh1 = ");System.out.print("nh1 = ")
            if (nhi == 1) {
                k.addsenbun(p, p);
                nhTen = p;
                for (int i = 1; i <= k.getsousuu() - 1; i++) {
                    if (oc.hitosii(k.geta(i), p, 2.0 * r)) {
                        k.set(k.getsousuu(), k.geta(i), k.geta(i), 0, 0);
                        nhTen = k.geta(i);
                        break;
                    }
                    if (oc.hitosii(k.getb(i), p, 2.0 * r)) {
                        k.set(k.getsousuu(), k.getb(i), k.getb(i), 0, 0);
                        nhTen = k.getb(i);
                        break;
                    }
                }
            }
            if (nhi != 1) {   // set(int i, Ten p,Ten q,int ic,int ia)
                k.addsenbun(nhTen, p);
                for (int i = 1; i <= k.getsousuu() - 1; i++) {
                    if (oc.hitosii(k.geta(i), p, 2.0 * r)) {
                        k.set(k.getsousuu(), k.geta(i), k.getb(k.getsousuu() - 1), 0, 0);
                        nhi = 0;
                        break;
                    }
                    if (oc.hitosii(k.getb(i), p, 2.0 * r)) {
                        k.set(k.getsousuu(), k.getb(i), k.getb(k.getsousuu() - 1), 0, 0);
                        nhi = 0;
                        break;
                    }
                }
                nhTen = p;
            }
            if (icol >= 0) {
                k.setcolor(k.getsousuu(), icol);
            }
        }
    }


    //�}�E�X��??(i_mouse_modeA==0?@����???@���{�̂��߂Ɏc���Ă���?B???���----------------------------------------------------
    public void mDragged_A_00(Ten p) {
        if (nyuuryoku_houhou <= 1) {
            if (ugokasi_mode == 1) {
                k.set(p);
            } //a�_���?X
            if (ugokasi_mode == 2) {
                k.set(p);
            } //b�_���?X
            if (ugokasi_mode == 3) {        //�}��?s�ړ�
                k.seta(ieda, new Ten(1, p, 1, pa));
                k.setb(ieda, new Ten(1, p, 1, pb));
            }
            if (ugokasi_mode == 4) {
                k.set(p);
            } //a�_���?X(ugokasi_mode==1)�Ɠ�����??������
        }
        //--------------
        if (nyuuryoku_houhou == 1) {
        }
        //--------------
        if (nyuuryoku_houhou == 2) {
        }
    }

    //�}�E�X��??(i_mouse_modeA==0?@����???@���{�̂��߂Ɏc���Ă���?B???���----------------------------------------------------
    public void mReleased_A_00(Ten p) {
        if (nyuuryoku_houhou <= 1) {
            if (ugokasi_mode == 1) {
                k.set(p);
            } //a�_���?X
            if (ugokasi_mode == 2) {
                k.set(p);
            } //b�_���?X
            if (ugokasi_mode == 3) {//�}��?s�ړ�
                k.seta(ieda, new Ten(1, p, 1, pa));
                k.setb(ieda, new Ten(1, p, 1, pb));
                if (ugokasi_mode == 4) {
                    k.set(p);
                }//a�_���?X(ugokasi_mode==1)�Ɠ�����??������
            }
            //eda_atosyori_01();                //�}�̒�����ς�����?A�}�S�̂�?s�ړ����Ĕ���?�����?B<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            eda_atosyori_02();                //��[�̓_�������ړ����Ĕ��΂̒[�̓_�͓������Ȃ��Ŕ���?�����?B <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

            //----------�i�q��?悹��
            if (nyuuryoku_kitei >= 1) {
                for (int i = 1; i <= k.getsousuu(); i++) {
                    System.out.print("iactive ");
                    System.out.print(i);
                    System.out.print(": ");
                    System.out.println(k.getiactive(i));
                    if (k.getiactive(i) >= 1) {
                        k.seta(i, kitei_idou(k.geta(i)));
                        k.setb(i, kitei_idou(k.getb(i)));
                    }

                }
            }

            k.hikasseika(); //��?���

            //��?�?�������???���????
            if (taisyousei > 0) {
                if (((tyuuoutai_xmin < k.geta(ieda).getx()) && (k.geta(ieda).getx() < tyuuoutai_xmax))
                        &&
                        ((tyuuoutai_xmin < k.getb(ieda).getx()) && (k.getb(ieda).getx() < tyuuoutai_xmax))) {
                    k.seta(ieda, new Ten((tyuuoutai_xmin + tyuuoutai_xmax) / 2, k.geta(ieda).gety()));
                    k.setb(ieda, new Ten((tyuuoutai_xmin + tyuuoutai_xmax) / 2, k.getb(ieda).gety()));
                }
            }

            //�S�~�̂�?B?@��������ƃA�N�e�B�u��ieda�}�̔�??�������̂�?A�ꉞeda_atosyori�̌�ł��悤�ɂ���?B
            if ((ugokasi_mode == 4) && (k.getnagasa(k.getsousuu()) < r)) { //?V�K�ǉ�����??�����_?��?i������r���?�����?j�Ƃ�?????B
                k.delsenbun(k.getsousuu());
            } else {
                gomisute();//���ݔ��ɓ�����??����?���
            }
        }
        //--------------
        if (nyuuryoku_houhou == 1) {
        }

        //--------------
        if (nyuuryoku_houhou == 2) {
        }
    }

    //1111111111111111111111111111111111111111111111111111111
    //�}�E�X��??(i_mouse_modeA==1??������?@�Ń{�^�����������Ƃ�)����??��----------------------------------------------------
    public void mPressed_A_01(Ten p0) {

        i_saigo_no_senbun_no_maru_kaku = 0;
        Ten p = new Ten();
        p.set(camera.TV2object(p0));
        k.addsenbun(p, p);
        ieda = k.getsousuu();
        k.setcolor(ieda, icol);
    }

    //�}�E�X��??(i_mouse_modeA==1??������?@�Ńh���b�O�����Ƃ�)��?s����??----------------------------------------------------
    public void mDragged_A_01(Ten p0) {
        Ten p = new Ten();
        p.set(camera.TV2object(p0));
        k.seta(ieda, p);
    }

    //�}�E�X��??(i_mouse_modeA==1??������?@�Ń{�^���𗣂����Ƃ�)��?s����??----------------------------------------------------
    public void mReleased_A_01(Ten p0) {
        i_saigo_no_senbun_no_maru_kaku = 1;
        Ten p = new Ten();
        p.set(camera.TV2object(p0));
        k.seta(ieda, p);
        eda_atosyori_02();                //��[�̓_�������ړ����Ĕ��΂̒[�̓_�͓������Ȃ��Ŕ���?�����?B <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

        //----------�i�q��?悹��
        if ((nyuuryoku_kitei == 1) || (nyuuryoku_kitei == 2)) {
            //for(int i=1;i<=k.getsousuu();i++){
            //System.out.print("iactive 20150312"); System.out.print(i); System.out.print(": ");
            //System.out.println(k.getiactive(i));
            //if(k.getiactive(i)>=1){
            k.seta(k.getsousuu(), kitei_idou(k.geta(k.getsousuu())));
            k.setb(k.getsousuu(), kitei_idou(k.getb(k.getsousuu())));
            //}
            //}
        }


        if (nyuuryoku_kitei == 3) {

            k.seta(k.getsousuu(), sankaku_kitei_idou(k.geta(k.getsousuu())));
            k.setb(k.getsousuu(), sankaku_kitei_idou(k.getb(k.getsousuu())));

        }


        //?����͂���??����?A?��܂łɓ���?ς݂̂ǂꂩ��??���ƑS�������ʒu�ň�v����???���?A?����͂���??����?F�������f������?A?����͂���??���͒ǉ��͂��Ȃ�?B
        int i_kasanari;
        i_kasanari = k.kasanari_senbun_sagasi(k.getsousuu());
        if (i_kasanari > 0) {
            k.setcolor(i_kasanari, k.getcolor(k.getsousuu()));
            k.delsenbun(getsousuu());
        }
        k.kousabunkatu();//�S��?d�Ȃ�??�����Ȃ�?�ԂŎ��{�����?B//2����Ȃ��Ɣ������Ȃ�???�������?B�����s��?B
        k.kousabunkatu();


    }

    //------------------------------------------------------
    public Ten kitei_idou(Ten t1) {
        Ten t_ob = new Ten();

        for (int i = i_kousi_x_min / kousi_haba; i <= i_kousi_x_max / kousi_haba; i++) {
            for (int j = i_kousi_y_min / kousi_haba; j <= i_kousi_y_max / kousi_haba; j++) {
                t_ob.set(kousi_haba * i, kousi_haba * j);
                if (oc.kyori(t_ob, t1) < r) {
                    return t_ob;
                }

            }
        }


        return t1;
    }

    //------------------------------------------------------
    public Ten sankaku_kitei_idou(Ten t1) {
        double sqr3 = 1.732051;
        double sankaku_kousi_takasa;
        sankaku_kousi_takasa = kousi_haba * sqr3 / 2.0;
        Ten t_ob = new Ten();
        for (int i = -30; i <= 30; i++) {
            for (int j = -30; j <= 30; j = j + 2) {
                t_ob.set(kousi_haba * i, sankaku_kousi_takasa * j);
                if (oc.kyori(t_ob, t1) < r) {
                    return t_ob;
                }
            }
            for (int j = -31; j <= 31; j = j + 2) {
                t_ob.set(kousi_haba * i + kousi_haba / 2.0, sankaku_kousi_takasa * j);
                if (oc.kyori(t_ob, t1) < r) {
                    return t_ob;
                }
            }

        }


        return t1;
    }

/*

			//�i�q�_�Ɋۂ�`��

			g.setColor(Color.gray);	Ten t_ob =new Ten();	Ten t_tv =new Ten();
			for(int i=-30;i<=30;i++ ){
				for(int j=-30;j<=30;j=j+2 ){
					t_ob.set(kousi_haba*i,sankaku_kousi_takasa*j);
					t_tv.set(camera.object2TV(t_ob));
					g.drawOval( (int)t_tv.getx()-ir,(int)t_tv.gety()-ir,2*ir,2*ir); //�~
				}
				for(int j=-31;j<=31;j=j+2 ){
					t_ob.set(kousi_haba*i+kousi_haba/2.0,sankaku_kousi_takasa*j);
					t_tv.set(camera.object2TV(t_ob));
					g.drawOval( (int)t_tv.getx()-ir,(int)t_tv.gety()-ir,2*ir,2*ir); //�~
				}

			}
*/


    //22222222222222222222222222222222222222222222222222222222222222
    public void mPressed_A_02(Ten p0) {
    }//�}�E�X��??(i_mouse_modeA==2�W�J?}��?�?@�Ń{�^�����������Ƃ�)����??��

    public void mDragged_A_02(Ten p0) {
    }//�}�E�X��??(i_mouse_modeA==2??������?@�Ńh���b�O�����Ƃ�)��?s����??

    public void mReleased_A_02(Ten p0) {
    }//�}�E�X��??(i_mouse_modeA==2??������?@�Ń{�^���𗣂����Ƃ�)��?s����??

    //3333333333333333333333333333333333333333333333333333333333333
    //�}�E�X��??(i_mouse_modeA==3??��?????@�Ń{�^�����������Ƃ�)����??��----------------------------------------------------
    public void mPressed_A_03(Ten p0) {
    }

    //�}�E�X��??(i_mouse_modeA==3??��?????@?@�Ńh���b�O�����Ƃ�)��?s����??----------------------------------------------------
    public void mDragged_A_03(Ten p0) {
    }

    //�}�E�X��??(i_mouse_modeA==3??��?????@?@�Ń{�^���𗣂����Ƃ�)��?s����??----------------------------------------------------
    public void mReleased_A_03(Ten p0) {
        Ten p = new Ten();
        p.set(camera.TV2object(p0));
        int minrid;
        double minr;
        minrid = k.mottomo_tikai_senbun_sagasi(p);
        if (k.senbun_busyo_sagasi(minrid, p, r) != 0) {
            k.delsenbun(minrid);
        }
    }

    //44444444444444444444444444444444444444444444444444444444444444
    public void mPressed_A_04(Ten p0) {
    }//�}�E�X��??(i_mouse_modeA==4??_�ϊ�?@�Ń{�^�����������Ƃ�)����??��

    public void mDragged_A_04(Ten p0) {
    }//�}�E�X��??(i_mouse_modeA==4??_�ϊ�?@�Ńh���b�O�����Ƃ�)��?s����??

    public void mReleased_A_04(Ten p0) {
        Ten p = new Ten();
        p.set(camera.TV2object(p0));
        int minrid;
        double minr;
        minrid = k.mottomo_tikai_senbun_sagasi(p);
        if (k.senbun_busyo_sagasi(minrid, p, r) != 0) {
            int ic_temp;
            ic_temp = k.getcolor(minrid);
            ic_temp = ic_temp + 1;
            if (ic_temp == 3) {
                ic_temp = 0;
            }
            k.setcolor(minrid, ic_temp);
        }


    }//�}�E�X��??(i_mouse_modeA==4??_�ϊ�?@�Ń{�^���𗣂����Ƃ�)��?s����??


}