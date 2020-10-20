package jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin.smen.jyuufuku_jyunretu_hasseiki.annaisyo;

public class Annaisyo {//�ē�?�?BSmen�̒���?�?�����?B?d��?���?�?��@�̑O��?A����ʂ̒���?�̖ʂ�o�^����
    //�ē�?}�̃C�??[�W?B�n?}�Ƃ�������Ɍ��Ď��ǂ����邩�𔻒f����?B�e�ʂ����܂��铹����ׂ܂ł�?o�Ă���?�?B?��̓�����ׂ�?�Ԃ�?����Ȃ�?B
    //annai[i][j]�͖�i��?o��O��?o�Ă���͂��̖ʂ�\��?Bannaisyo[i][0]��?A�����������ʂ�?�?B
    int[][] annai;
    int ketasuu;

    public Annaisyo(int keta) {//�R���X�g���N�^
        ketasuu = keta;
        int[][] a = new int[keta + 11][50];


        annai = a;
        for (int i = 0; i <= keta + 10; i++) {
            annai[i][0] = 0;
        }
    }

    public void add(int Menidid, int ueMenidid) {
        annai[Menidid][0] = annai[Menidid][0] + 1;
        annai[Menidid][annai[Menidid][0]] = ueMenidid;
    }

    public int get(int iMen, int i) {
        //  System.out.print("ketasuu = ");System.out.print(ketasuu); System.out.print(" : iMen = ");System.out.println(iMen);
        return annai[iMen][i];
    }

}