package jp.gr.java_conf.mt777.origami.dougu.bou;

public class Bou {
    int mae;
    int ato;
    int icol;//0�Ȃ�R�J�Ȃ�?B1�Ȃ�?A�R?B2�Ȃ�J?B

    //�R���X�g���N�^
    public Bou() {
        mae = 0;
        ato = 0;
        icol = 0;
    }

    //�R���X�g���N�^
    public Bou(int ma, int at, int ic) {
        mae = ma;
        ato = at;
        icol = ic;
    }

    //����
    public void set(Bou bu) {
        mae = bu.getmae();
        ato = bu.getato();
        icol = bu.getcolor();
    }

    public void set(int i, int j, int k) {
        mae = i;
        ato = j;
        icol = k;
    }

    public void setmae(int i) {
        mae = i;
    }

    public void setato(int i) {
        ato = i;
    }

    public void setcolor(int i) {
        icol = i;
    }

    //?o��
    public int getmae() {
        return mae;
    }

    public int getato() {
        return ato;
    }

    public int getcolor() {
        return icol;
    }

    public void reset() {
        mae = 0;
        ato = 0;
        icol = 0;
    }
}