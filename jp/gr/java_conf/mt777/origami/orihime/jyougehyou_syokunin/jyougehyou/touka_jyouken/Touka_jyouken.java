package jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin.jyougehyou.touka_jyouken;
//package a;

public class Touka_jyouken {//���̃N���X��?㉺�\��jg[a][b]=jg[c][d]�Ƃ����֌W���L�^?A���p����̂Ɏg��?B
    int a, b, c, d;

    //�R���X�g���N�^
    public Touka_jyouken() {
        a = 0;
        b = 0;
        c = 0;
        d = 0;
    }

    //�R���X�g���N�^
    public Touka_jyouken(int ia, int ib, int ic, int id) {
        a = ia;
        b = ib;
        c = ic;
        d = id;
    }

    //
    public void reset() {
        a = 0;
        b = 0;
        c = 0;
        d = 0;
    }

    public void set(int ai, int bi, int ci, int di) {
        a = ai;
        b = bi;
        c = ci;
        d = di;
    }

    public void set(Touka_jyouken tj) {
        a = tj.geta();
        b = tj.getb();
        c = tj.getc();
        d = tj.getd();
    }

    public int geta() {
        return a;
    }

    public int getb() {
        return b;
    }

    public int getc() {
        return c;
    }

    public int getd() {
        return d;
    }

    //?܂�?��?����?ۂ̓���?��?�̓o�^��?@addTouka_jyouken(im,Mid_min,im,Mid_max);  �ɂ��

}