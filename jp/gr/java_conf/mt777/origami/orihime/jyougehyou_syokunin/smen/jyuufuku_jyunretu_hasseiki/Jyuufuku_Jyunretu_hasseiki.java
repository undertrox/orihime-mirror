package jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin.smen.jyuufuku_jyunretu_hasseiki;

import jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin.smen.jyuufuku_jyunretu_hasseiki.annaisyo.Annaisyo;

public class Jyuufuku_Jyunretu_hasseiki {//?d��?���?��@
    //?d��?����?�������N���X����������?ASmen?\?��ɉ�����?A�ʂ�?d�Ȃ�?���������ǂ���?�������N���X?B

    int[] ij;//?d��?�����i�[����?B
    int Ketasuu = 0;//?d��?���̌�?�?B���Ƃ���?A��?���5�Ȃ�?A1����5�܂ł�?����łł���?����?�����
    int i_tabibito;//��?l�̈ʒu
    int[] tizu;//�n?}�̃C�??[�W?B�e�ʂ����܂��铹����ׂ܂ł�?o�Ă���?�?B?��̓�����ׂ�?�Ԃ�?����Ȃ�?B
    //Annaisyo ann = new Annaisyo();//�ē�?��̃C�??[�W?B
    Annaisyo ann; //�Ȃ���?A����?s��?������ł̓R���p�C����ok�Ȃ̂Ɏ�?s���ɃG��?[���ł邪?A����?s��?��������Ƃ��܂�����
    //  Annaisyo ann = new Annaisyo(0);


    public Jyuufuku_Jyunretu_hasseiki(int k) {  //�R���X�g���N�^
        Ketasuu = k;
        i_tabibito = 0;
        int[] ij0 = new int[k + 10];//?d��?�����i�[����?B
        int[] tizu0 = new int[k + 10];  //�n?}�̃C�??[�W?B�e�ʂ����܂��铹����ׂ܂ł�?o�Ă���?�?B?��̓�����ׂ�?�Ԃ�?����Ȃ�?B
        ij = ij0;
        tizu = tizu0;
        Annaisyo a = new Annaisyo(k + 10);
        ann = a;

//System.out.println("20150309@@@@@@@44444444444444444444@@@@@@@@@" );
        Jyunretu_1banme();
//System.out.println("20150309@@@@@@@55555555555555555555@@@@@@@@@" );
    }

    //---------------
    //private void set_i_tabibito(int i){i_tabibito=i;}

    // ----------------------------------------------------------------
    //��?��?��񂩂玟��?����?i��?B
    //k���ڂ�1��?i�߂�?Ak-1���ȉ��݂͂�1�ɂ���?B�Ԃ�l��?���Ƃ��ĕς������?�
    //��?��?���?Ō�̂��̂�����?�?���0��return����?B

    public int susumu(int idousuru_keta) {
        //��?l�ړ�     ��?����傫���Ȃ������?i�ނƂ���
        //�eij[]�̒l�𓹂���ׂ�?i��?B��?����傫���Ƃ��납��?������ق��ɖ߂��Ă����Ƃ��͊eij[]�̒l��ς���?B
        //�n?}�͊e������ׂ�?C��?��������ȉ�?i�������܂�?j�̓�����ׂ�?����܂�?B��̓I�ɂ�?A�����܂�?o�Ă����e�O��?[�v���Ƃ̌�?�?B
        //i_tabibito==Ketasuu�Ȃ�1���߂�?B���ǂ�����?A�����Œ����ɂ����̈ʒu?i�������?j�ƒn?}��?C?�?B
        //i_tabibito< Ketasuu�Ȃ�?Aij[i_tabibito]==Gsuu�Ȃ�1����������ɖ߂�?B���ǂ�����?A�����Œ����ɂ����̈ʒu?i�������?j�ƒn?}��?C?�?B
        //i_tabibito< Ketasuu�Ȃ�?Aij[i_tabibito]< Gsuu�Ȃ�1���?���������?i��?B?i�񂾂�?A�����Œ����ɂ����̈ʒu?i�������?j�ƒn?}��?C?�?B������ׂ͉\�Ȍ���Ⴂ��?��ɂ���?B
        i_tabibito = idousuru_keta;
        int ireturn = idousuru_keta;

        while (i_tabibito <= Ketasuu) {

            if (i_tabibito == 0) {
                i_tabibito = i_tabibito + 1;
                ij[i_tabibito] = 0;//��?��傫���Ȃ����?i��
            }

            ij[i_tabibito] = mitisirube_tatekae(ij[i_tabibito]);

            if (ij[i_tabibito] <= Ketasuu) {//��?��傫���Ȃ����?i��
                i_tabibito = i_tabibito + 1;
                ij[i_tabibito] = 0;
                if (i_tabibito == Ketasuu + 1) {
                    break;
                }
            } else {//��?�?������Ȃ���ɖ߂�
                i_tabibito = i_tabibito - 1;
                ireturn = i_tabibito;
            }
        }


//System.out.println("susumu("+idousuru_keta+")");
//			for(int i=1;i<=Ketasuu;i++){System.out.print(ij[i] );System.out.print(",");}System.out.println();

        return ireturn;
    }

    //
    private int mitisirube_tatekae(int ig) {

        for (int i = 1; i <= Ketasuu; i++) {
            tizu[i] = 0;
        }

        for (int i = 1; i <= i_tabibito - 1; i++) {
            tizu[ij[i]] = tizu[ij[i]] + 1;
        }

        //�����̓o�O���Ȃ���������v����?B
        int ignew = ig;
        while (true) {
            ignew = ignew + 1;
            if (ignew > Ketasuu) {
                break;
            }
            int nukedasi_flg = 1;
            if (tizu[ignew] == 1) {
                nukedasi_flg = 0;
            }

            for (int i = 1; i <= ann.get(ignew, 0); i++) {
                if (tizu[ann.get(ignew, i)] == 0) {
                    nukedasi_flg = 0;
                }
            }

            if (nukedasi_flg == 1) {
                break;
            }

        }

        return ignew;
    }

    public int getJyunretu(int i) {
        return ij[i];
    }

    //?�������?�?��̂��̂ɂ���
    public void Jyunretu_1banme() {
        susumu(0);
    }

    //�ē�?�?��̎󂯓n��
    public void addAnnai(int iM, int i) {
        ann.add(iM, i);
    }
    //
    //int getAnnai(int iM,int i){return ann.get(iM,i);}

}