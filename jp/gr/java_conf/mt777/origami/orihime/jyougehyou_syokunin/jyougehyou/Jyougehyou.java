package jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin.jyougehyou;


import jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin.jyougehyou.touka_jyouken.Touka_jyouken;

import java.util.ArrayList;

public class Jyougehyou {//���̃N���X��?܂�?��?ۂ̖ʂ�?㉺�֌W���L�^?A���p����̂Ɏg��?B
    int Mensuu;             //?܂肽���ޑO�̓W�J?}�̖ʂ�??

    //  jg[][]��?܂�O�̓W�J?}�̂��ׂĂ̖ʓ��m��?㉺�֌W��1�̕\�ɂ܂Ƃ߂����̂Ƃ��Ĉ���
    //?@jg[i][j]��1�Ȃ��i�͖�j��?㑤?B0�Ȃ牺��?B
    //  jg[i][j]��-50�Ȃ�?A��i��j��?d�Ȃ�?A?㉺�֌W�͌��߂��Ă��Ȃ�?B
    //jg[i][j]��-100�Ȃ�?A��i��j��?d�Ȃ�Ƃ��낪�Ȃ�?B
    int[][] jg;
    int[][] jg_h;
    int Touka_jyoukensuu;   //�Q�̗�?ڂ���ʂ̋��E??�𑼂̖ʂ��˂�������?󋵂�?�������g��?�����?B
    Touka_jyouken tj = new Touka_jyouken();

    ArrayList tL = new ArrayList();

    int uTouka_jyoukensuu;

    ArrayList uL = new ArrayList();
    Touka_jyouken uj = new Touka_jyouken();//�Q�̗�?ڂ����a,b�̋��E??�ƂQ�̗�?ڂ����c,d�̋��E??��?A��?s���ꕔ?d�Ȃ��Ă���?A
    //�����a,b,c,d������Smen�ŋ�������???���?A���E??�œ˂�������?�������g��?�����


    public Jyougehyou() {//�R���X�g���N�^
        reset();
    }

    //
    public void reset() {
        tL.clear();
        tL.add(new Touka_jyouken());
        uL.clear();
        uL.add(new Touka_jyouken());
        Touka_jyoukensuu = 0;
        uTouka_jyoukensuu = 0;
    }

    //
    public void jg_hozon() {
        for (int i = 1; i <= Mensuu; i++) {
            for (int j = 1; j <= Mensuu; j++) {
                jg_h[i][j] = jg[i][j];
            }
        }
    }

    //
    public void jg_fukugen() {
        for (int i = 1; i <= Mensuu; i++) {
            for (int j = 1; j <= Mensuu; j++) {
                jg[i][j] = jg_h[i][j];
            }
        }
    }

    //
    public void set(int i, int j, int jyoutai) {
        jg[i][j] = jyoutai;
        //	System.out.print(i);System.out.print(":?㉺�\:");System.out.println(j);
    }

    public int get(int i, int j) {
        return jg[i][j];
    }

    public void setMensuu(int iM) {
        Mensuu = iM;

        int[][] j_g = new int[Mensuu + 1][Mensuu + 1];
        int[][] j_g_h = new int[Mensuu + 1][Mensuu + 1];

        jg = j_g;
        jg_h = j_g_h;


        for (int i = 0; i <= Mensuu; i++) {
            for (int j = 0; j <= Mensuu; j++) {
                jg[i][j] = -100;
                jg_h[i][j] = -100;
            }
        }
    }


    public int getMensuu() {
        return Mensuu;
    }


    public int getTouka_jyoukensuu() {
        return Touka_jyoukensuu;
    }

    public Touka_jyouken getTouka_jyouken(int i) {
        return (Touka_jyouken) tL.get(i);
    }


    //����?��?�̒ǉ�?B�_ib�̋��E�Ƃ��ė�?ڂ���2�̖�im1,im2���L��?????A?܂�?��??�肵��???���
    //�_ib�̈ꕔ��?d�Ȃ�ʒu�ɗL���im�͖�im1�Ɩ�im2��?㉺�����ŋ��܂�邱�Ƃ͂Ȃ�?B���̂��Ƃ���
    //gj[im1][im]=gj[im2][im]�Ƃ�������?��?��?��藧��?B
    public void addTouka_jyouken(int ai, int bi, int ci, int di) {
        Touka_jyoukensuu = Touka_jyoukensuu + 1;
        tL.add(new Touka_jyouken(ai, bi, ci, di));
    }

    public int get_uTouka_jyoukensuu() {
        return uTouka_jyoukensuu;
    }

    public Touka_jyouken get_uTouka_jyouken(int i) {
        return (Touka_jyouken) uL.get(i);
    }


    //����?��?�̒ǉ�?B�_ib�̋��E�Ƃ��ė�?ڂ���2�̖�im1,im2���L��?A
    //�܂��_jb�̋��E�Ƃ��ė�?ڂ���2�̖�im3,im4���L��?Aib��jb����?s��?A�ꕔ?d�Ȃ�?????A?܂�?��??�肵��???���
    //�_ib�̖ʂƖ�jb�̖ʂ�i,j,i,j?@�܂���?@j,i,j,i?@�ƕ��Ԃ��Ƃ͂Ȃ�?B�������ꂪ��������?A
    //?�?�����3�ԖڂŊԈႢ���N���Ă���̂�?A����3�Ԗڂ̂Ƃ��낪Smen�ŉ����ڂ���??�߂�?A���̌����P?i�߂�?B

    public void add_uTouka_jyouken(int ai, int bi, int ci, int di) {
        uTouka_jyoukensuu = uTouka_jyoukensuu + 1;

        uL.add(new Touka_jyouken(ai, bi, ci, di));
    }


}