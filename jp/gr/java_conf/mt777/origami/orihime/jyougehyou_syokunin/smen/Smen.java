package jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin.smen;

import jp.gr.java_conf.mt777.origami.orihime.ap;
import jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin.jyougehyou.Jyougehyou;
import jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin.smen.jyuufuku_jyunretu_hasseiki.Jyuufuku_Jyunretu_hasseiki;

public class Smen {//���̃N���X�͓W�J?}����?܂�?��?��肵�Ă���ꂽ?j��?}�̖ʂ�?d�Ȃ�?���
    //�L�^���p���邽�߂Ɏg��?BJyougehyou_Syokunin�N���X�̒��ł̂ݎg��
    int Menidsuu;//Smen(?܂�?��?��肵�Ă���ꂽ?j��?}��?ו���������)��?d�Ȃ��Ă���Men(?܂肽���ޑO�̓W�J?}�̖�)��?�?B
    int[] Menid;//S�ʂɊ܂܂��Men��id��?����L�^����?B���ꂪ20�Ƃ������Ƃ�?A
    //?܂�����̎���?d�Ȃ肪?ő��?�?��ł�20-1=19�ʂ܂łƂ������Ƃ��Ӗ�����?B//����?����͌�?݂͖���20150309
    //Jyunretu_hasseiki jh = new Jyunretu_hasseiki();
    Jyuufuku_Jyunretu_hasseiki jh;// = new Jyuufuku_Jyunretu_hasseiki();


    int Jyunretu_count = 1;


    //Annaisyo ann = new Annaisyo();

    int[] Menid2uekara_kazoeta_iti;//��(Menid)��?ォ��?������ʒu��\��?B
    int[] uekara_kazoeta_iti2Menid;//?ォ��?������ʒu�̖ʂ�\��?B

    ap orihime_ap;

    public Smen() {
        reset();
    }  //�R���X�g���N�^

    public Smen(ap ap0) {
        orihime_ap = ap0;
        reset();
    }  //�R���X�g���N�^


    private void reset() {
        Menidsuu = 0;
    }

    //--------------------------------------
    //Ketasuu��?���?��@��?���?ݒ�?B�Y�ꂸ�ɂ��邱��?B
    public void setKetasuu(int Midsuu) {
        Menidsuu = Midsuu;

        int[] Men_id = new int[Menidsuu + 1];
        Menid = Men_id;

        int[] Menid_2_uekara_kazoeta_iti = new int[Menidsuu + 1];  //��(Menid)��?ォ��?������ʒu��\��?B
        int[] uekara_kazoeta_iti_2_Menid = new int[Menidsuu + 1];  //?ォ��?������ʒu�̖ʂ�\��?B
        Menid2uekara_kazoeta_iti = Menid_2_uekara_kazoeta_iti;
        uekara_kazoeta_iti2Menid = uekara_kazoeta_iti_2_Menid;

        for (int i = 0; i <= Menidsuu; i++) {
            Menid[i] = 0;

            Menid2uekara_kazoeta_iti[i] = 0;
            uekara_kazoeta_iti2Menid[i] = 0;
        }
        if (Midsuu > 0) {
            //System.out.println("20150309@@@@@@@2222222222222222222@@@@@@@@@" );
            Jyuufuku_Jyunretu_hasseiki jyh = new Jyuufuku_Jyunretu_hasseiki(Menidsuu);
            jh = jyh;
            //System.out.println("20150309@@@@@@@333333333333333333@@@@@@@@@" );
            Jyunretu_1banme();

        }
    }

    //--------------------------------------
    public int getMenidsuu() {
        return Menidsuu;
    }

    //--------------------------------------
    public int getMenid(int i) {
        return Menid[i];
    }

//--------------------------------------

    public void setMenid(int i, int Mid) {
        Menid[i] = Mid;
    }

    // ������?@class Smen �̒�����?B
 /*      //Smen�̈ʒu��Men���L��Ȃ�1?A�����Ȃ�0��Ԃ�?B
	int Men_no_ari_nasi(int id){
		for(int i=1;i<=Menidsuu;i++){
			if(id==Menid[i]){return 1;}
		}
		return 0;
	}
   */

    //--------------------------------------
    public int get_Jyunretu_count() {
        return Jyunretu_count;
    }

//--------------------------------------


    public void Jyunretu_1banme() {


        if (getMenidsuu() > 0) {//System.out.println("20150309@@@@@@@2222222222222222222@@@@@@@@@" );
            jh.Jyunretu_1banme();
            Jyunretu_count = 1;
        }//System.out.println("20150309@@@@@@@333333333333333333@@@@@@@@@" );

    } //?����1�Ԗڂɂ��ǂ�?B


    //--------------------------------------
    public int susumu() {
        return 0;
    }

/*
        //?���?��@��?i��?A�ʂ�?d�Ȃ�?�Ԃ�����?�Ԃɂ���?B��?��0��return����?B
	//������?݂̖ʂ�?d�Ȃ�?�Ԃ�?A?Ō�̂��̂�������1��return����?A�ʂ�?d�Ȃ�?�Ԃ�?�?��̂��̂ɖ߂�?B
	int susumu(Jyougehyou jg){
		return jh.susumu();
	}   //<<<<<<<<<<<<<<<<<<<�����͌�ŋ@�\����������?�����������?B
*/

    //k���ڂ�?���?��@��?i��?A�ʂ�?d�Ȃ�?�Ԃ�����?�Ԃɂ���?B��?��0��return����?B
    //������?݂̖ʂ�?d�Ȃ�?�Ԃ�?A?Ō�̂��̂�������1��return����?B
    //����?�?��͖ʂ�?d�Ȃ�?�Ԃ�?Ō�̂��̂̂܂�?B
    public int susumu(int k) {
        Jyunretu_count = Jyunretu_count + 1;
        return jh.susumu(k);
    }   //<<<<<<<<<<<<<<<<<<<�����͌�ŋ@�\����������?�����������?B
    // ������?@class Smen �̒�����?B

    //��?݂�?���?�Ԃ���J�n����?A�\��?d�Ȃ肩���ƂȂ�?����T��
    public int kanou_kasanari_sagasi(Jyougehyou jg) {//�����jg��ς��Ȃ��͂�?B
        int mk, ijh;
        mk = 0;
        ijh = 1;//ijh��?����l��0�ȊO�Ȃ�Ȃ�ł�����?B
        while (ijh != 0) { //ijh==0�Ȃ�?A����?Ō�܂ł���?B
            mk = mujyun_keta_motome(jg);

            //orihime_ap.keijiban.kakikae(8,"Smen_mujyun_keta_motome(jg) =  "+mk);
            if (mk == 1000) {
                return 1000;
            }//����Smen��?A��?��͂Ȃ�?�ԂɂȂ��Ă���?B

            ijh = susumu(mk);

            //	orihime_ap.keijiban.kakikae(9,"Smen_kanou_kasanari_sagasi(jg) =  "+ijh);

            String s0 = "";
            for (int i = 1; i <= Menidsuu; i++) {
                s0 = s0 + " : " + getJyunretu(i);
            }
            orihime_ap.keijiban.kakikae(10, "Smen_kanou_kasanari_sagasi(jg) =  " + s0);


            //try{Thread.sleep(1000);}catch (InterruptedException e){}// 1000�~���b�ҋ@����?B


        }
        return 0;//�\��?d�Ȃ肩���ƂȂ�?���͑�?݂��Ȃ�
    }

    // ������?@class Smen �̒�����?B


    /*    //����Smen��?d�Ȃ�ʂ�?d�Ȃ�?�?��̑??�
        int getJyunretusuu(){
		int ir;
		for(int i=1;i<=Menidsuu;i++){
			ir=ir*i;
		}
		return ir;
	}
     */

    // ��?݂�?���?�Ԃ����Ƃ�?A?ォ��?�����i�Ԃ߂̖ʂ�id��?���Ԃ�?B

    private int get_uekara_kazoeta_itino_Menid(int i) {
        return Menid[getJyunretu(i)];
    }


    //��?݂�?㉺�\�����Ƃ�?A?ォ��?�����i�Ԃ߂̖ʂ�id��?����i�[����?B
    public void set_Menid2uekara_kazoeta_iti(Jyougehyou jg) {
        for (int i = 1; i <= Menidsuu; i++) {
            Menid2uekara_kazoeta_iti[i] = 0;
            for (int j = 1; j <= Menidsuu; j++) {
                if (jg.get(Menid[i], Menid[j]) == 1) {
                    Menid2uekara_kazoeta_iti[i] = Menid2uekara_kazoeta_iti[i] + 1;
                }
            }
            Menid2uekara_kazoeta_iti[i] = Menidsuu - Menid2uekara_kazoeta_iti[i];
        }

        for (int iban = 1; iban <= Menidsuu; iban++) {
            for (int i = 1; i <= Menidsuu; i++) {
                if (Menid2uekara_kazoeta_iti[i] == iban) {
                    uekara_kazoeta_iti2Menid[iban] = i;
                }
            }
        }
    }

    //--------------
    public int uekara_kazoeta_Menid(int iban) {
        return Menid[uekara_kazoeta_iti2Menid[iban]];
    }

    //��?݂�?㉺�\�����Ƃ�?A?ォ��?�����i�Ԃ߂̖ʂ�id��?���Ԃ�?B?㉺�\�͊�?��������̂��g��Ȃ��ƌ��ʂ����������Ȃ鋰��L��?B
    private int get_uekara_kazoeta_itino_Menid(int iban, Jyougehyou jg) {
        set_Menid2uekara_kazoeta_iti(jg);
        return Menid[uekara_kazoeta_iti2Menid[iban]];
     
            /*  
		for(int i=1;i<=Menidsuu;i++){
		    Menid2uekara_kazoeta_iti[i] = 0;
		
		   for(int j=1;j<=Menidsuu;j++){
	              if(jg.get(Menid[i],Menid[j])==1){Menid2uekara_kazoeta_iti[i] = Menid2uekara_kazoeta_iti[i]+1;}
		   }	
                   Menid2uekara_kazoeta_iti[i]=Menidsuu-Menid2uekara_kazoeta_iti[i];
		}

                //
                for(int i=1;i<=Menidsuu;i++){
			if (Menid2uekara_kazoeta_iti[i]==iban){return Menid[i];}
		}



              return 0;//�����̓G��?[���Ȃ���Βʂ邱�Ƃ͖���?B
            */

    }

    //
    private int getJyunretu(int i) {
        return jh.getJyunretu(i);
    }

    //���?�̖ʂ���`�F�b�N���Ă����ĉ����ڂ�?܂�?d�Ȃ�ɖ�?���?����邩���?�߂�?B
    //����?�jg�͕ω����Ȃ�?B�Ȃ������ł͗�?ږʂ̋��E?��̓˂�����?��?�̓`�F�b�N���Ă��Ȃ�?B
    //����Smen�ł�?܂�?d�Ȃ�ɖ�?����Ȃ�?�?���1000��Ԃ�?B
    private int kasanari_mujyun_keta_motome(Jyougehyou jg) {
        for (int i = 1; i <= Menidsuu - 1; i++) {
            for (int j = i + 1; j <= Menidsuu; j++) {
                if (jg.get(Menid[getJyunretu(i)], Menid[getJyunretu(j)]) == 0) {
                    return i;
                }
            }
        }
        return 1000;
    }

    //��im��?d�Ȃ�?���?ォ�牽�Ԗڂ����?�߂�?B����Smen��Men���܂܂�Ȃ��Ƃ���0��Ԃ�?B
    public int Menid2Jyunretuketa(int im) {
        for (int i = 1; i <= Menidsuu; i++) {
            if (Menid[getJyunretu(i)] == im) {
                return i;
            }
        }
        return 0;
    }


    // ������?@class Smen �̒�����?B


    //���?�̖ʂ���`�F�b�N���Ă����ĉ��Ԗڂŗ�?ږʂ̋��E?��̓˂�����?��?�ɖ�?���?����邩���?�߂�?B
    //����?�jg�͕ω����Ȃ�?B����Smen�ł͓˂�����?��?�ɖ�?����Ȃ�?�?���1000��Ԃ�?B
    private int tukinuke_mujyun_keta_motome(Touka_jyouken tj) {
        int mm, M1, M2; //?܂�?��?����?ۂ̓���?��?�̓o�^��?@addTouka_jyouken(im,Mid_min,im,Mid_max);  �ɂ��
        mm = Menid2Jyunretuketa(tj.geta());
        M1 = Menid2Jyunretuketa(tj.getb());
        M2 = Menid2Jyunretuketa(tj.getd());
        if (mm * M1 * M2 == 0) {
            return 1000;
        }
        //if ((mm-M1)*(mm-M2)<0) {if(mm!=Menidsuu-1) {  return mm;} }   //qqqqqqqqqqqqqq
        //if ((mm-M1)*(mm-M2)<0) {if(mm!=2) {  return mm;} }   //qqqqqqqqqqqqqq

        if ((mm - M1) * (mm - M2) < 0) {
            return mm;
        }
        return 1000;
    }

    //

    private int tukinuke_mujyun_keta_motome(Jyougehyou jg) {
        int ketaMim = 1000;
        int tmk = 1000;
        for (int i = 1; i <= jg.getTouka_jyoukensuu(); i++) {
            tmk = tukinuke_mujyun_keta_motome(jg.getTouka_jyouken(i));

            if (tmk <= ketaMim) {
                ketaMim = tmk;
            }
        }

        // if(ketaMim==Menidsuu-1) {  return 1000;}    <<<<<<<<�e�X�g�p

        return ketaMim;

    }


    //���?�̖ʂ���`�F�b�N���Ă����ĉ��Ԗڂŋ��E?��̈ꕔ�����L����Q�ʂƂQ�ʂ̓˂�����?��?�ɖ�?���?����邩���?�߂�?B
    //����?�jg�͕ω����Ȃ�?B����Smen�ł͖�?����Ȃ�?�?���1000��Ԃ�?B
    private int u_tukinuke_mujyun_keta_motome(Touka_jyouken uj) {
        int mi1, mi2, mj1, mj2, itemp; //?܂�?��?����?ۂ̓���?��?�̓o�^��?@u_addTouka_jyouken(im1,im2,im3,im4);  �ɂ��
        mi1 = Menid2Jyunretuketa(uj.geta());
        mi2 = Menid2Jyunretuketa(uj.getb());
        if (mi2 < mi1) {
            itemp = mi1;
            mi1 = mi2;
            mi2 = itemp;
        }

        mj1 = Menid2Jyunretuketa(uj.getc());
        mj2 = Menid2Jyunretuketa(uj.getd());
        if (mj2 < mj1) {
            itemp = mj1;
            mj1 = mj2;
            mj2 = itemp;
        }

        if (mi1 * mi2 * mj1 * mj2 != 0) {
            if (((mi1 < mj1) && (mj1 < mi2)) && (mi2 < mj2)) {
                //System.out.print(mi1);
                //System.out.print(",");
                //System.out.print(mj1);
                //System.out.print(",aaa,");
                //System.out.print(mi2);
                //System.out.print(",");
                //System.out.println(mj2);
                return mi2;
            }
            if (((mj1 < mi1) && (mi1 < mj2)) && (mj2 < mi2)) {
                //System.out.print(mi1);
                //System.out.print(",");
                //System.out.print(mj1);
                //System.out.print(",bbb,");
                //System.out.print(mi2);
                //System.out.print(",");
                //System.out.println(mj2);
                return mj2;
            }
        }

        return 1000;
    }

    //

    private int u_tukinuke_mujyun_keta_motome(Jyougehyou jg) {
        int ketaMim = 1000;
        int tmk = 1000;
        for (int i = 1; i <= jg.get_uTouka_jyoukensuu(); i++) {
            tmk = u_tukinuke_mujyun_keta_motome(jg.get_uTouka_jyouken(i));

            if (tmk <= ketaMim) {
                ketaMim = tmk;
            }
        }

        // if(ketaMim==Menidsuu-1) {  return 1000;}    <<<<<<<<�e�X�g�p

        return ketaMim;


    }


    // ������?@class Smen �̒�����?B


    //���?�̖ʂ���`�F�b�N���Ă����ĉ��ԖڂŖ�?���?����邩���?�߂�?B
    //����?�jg�͕ω����Ȃ�?B����Smen�ł͖�?����Ȃ�?�?���1000��Ԃ�?B
    private int mujyun_keta_motome(Jyougehyou jg) {
        int min1, min2, min3;
        min1 = kasanari_mujyun_keta_motome(jg);
        min2 = tukinuke_mujyun_keta_motome(jg);
        min3 = u_tukinuke_mujyun_keta_motome(jg);

        //min1,min2,min3�̒���?�?��l�����^?[������?B
        if (min3 < min2) {
            min2 = min3;
        }
        if (min2 < min1) {
            min1 = min2;
        }

        return min1;

    }


    //?㉺�\��Smen�̖ʂ�?d�Ȃ�ɂ��?�������
    public void jg_ni_Smen_wo_nyuuryoku(Jyougehyou jg) {

        for (int i = 1; i <= Menidsuu; i++) {
            for (int j = 1; j <= i - 1; j++) {
                jg.set(Menid[getJyunretu(i)], Menid[getJyunretu(j)], 0);
            }

            for (int j = i + 1; j <= Menidsuu; j++) {
                jg.set(Menid[getJyunretu(i)], Menid[getJyunretu(j)], 1);
            }
        }
    }


    //?㉺�\��Smen�̖ʂ�?d�Ȃ�ɂ��?�������?B�����?����̌v�Z?�����?ۂ�Smen�̗L��?����?�߂�̂Ɏg��?B
    public void jg_ni_Smen_no_tantoubasyo_wo_nyuuryoku(Jyougehyou jg) {

        for (int i = 1; i <= Menidsuu; i++) {
            for (int j = 1; j <= i - 1; j++) {
                if (jg.get(Menid[getJyunretu(i)], Menid[getJyunretu(j)]) == -100) {
                    jg.set(Menid[getJyunretu(i)], Menid[getJyunretu(j)], -50);
                }
            }

            for (int j = i + 1; j <= Menidsuu; j++) {
                if (jg.get(Menid[getJyunretu(i)], Menid[getJyunretu(j)]) == -100) {
                    jg.set(Menid[getJyunretu(i)], Menid[getJyunretu(j)], -50);
                }
            }
        }
    }

    //?㉺�\��Smen�ɂ���ĉ���?V?�񂪓��邩��Ԃ�?B
    public int sinki_jyouhou_suu(Jyougehyou jg) {
        int inew = 0;
        for (int i = 1; i <= Menidsuu; i++) {
            for (int j = 1; j <= i - 1; j++) {
                if (jg.get(Menid[getJyunretu(i)], Menid[getJyunretu(j)]) == -100) {
                    inew = inew + 1;
                }
            }

            for (int j = i + 1; j <= Menidsuu; j++) {
                if (jg.get(Menid[getJyunretu(i)], Menid[getJyunretu(j)]) == -100) {
                    inew = inew + 1;
                }
            }
        }
        //
        return inew;
    }
    //


    //  jg[][]��?܂�O�̓W�J?}�̂��ׂĂ̖ʓ��m��?㉺�֌W��1�̕\�ɂ܂Ƃ߂����̂Ƃ��Ĉ���
    //?@jg[i][j]��1�Ȃ��i�͖�j��?㑤?B0�Ȃ牺��?B
    //  jg[i][j]��-50�Ȃ�?A��i��j��?d�Ȃ�?A?㉺�֌W�͌��߂��Ă��Ȃ�?B
    //jg[i][j]��-100�Ȃ�?A��i��j��?d�Ȃ�Ƃ��낪�Ȃ�?B


    public void setAnnaisyo(Jyougehyou jg) { //?d��?���?��@�̈ē�?���Smen��?������Ă��?B
        int[] ueMenid = new int[Menidsuu + 1];
        int[] ueMenidFlg = new int[Menidsuu + 1];//ueMenid[]���L���Ȃ�1?A�����Ȃ�0

        for (int iMen = 1; iMen <= Menidsuu; iMen++) {
            int ueMenidsuu = 0;//ueMenid[]��?A1���炢���܂ł��邩���i�[?B

            //�܂�?A?�ɂ���ʂ�Smen�ł�id��?���ueMenid[]�Ɏ�?W
            for (int i = 1; i <= Menidsuu; i++) {
                if (jg.get(Menid[i], Menid[iMen]) == 1) {
                    ueMenidsuu = ueMenidsuu + 1;
                    ueMenid[ueMenidsuu] = i;
                    ueMenidFlg[ueMenidsuu] = 1;
                }
            }

            //�����ɂ���id��?���ueMenidFlg[id]��0�ɂ���?B
            for (int i = 1; i <= ueMenidsuu - 1; i++) {
                for (int j = i + 1; j <= ueMenidsuu; j++) {
                    if (jg.get(Menid[ueMenid[i]], Menid[ueMenid[j]]) == 1) {
                        ueMenidFlg[i] = 0;
                    }
                    if (jg.get(Menid[ueMenid[j]], Menid[ueMenid[i]]) == 1) {
                        ueMenidFlg[j] = 0;
                    }
                }
            }

            //�ē�?��Ɋi�[
            for (int i = 1; i <= ueMenidsuu; i++) {
                if (ueMenidFlg[i] == 1) {
                    jh.addAnnai(iMen, ueMenid[i]);
                }
            }

        }

    }

    //-----------------------------------------------------------
    //?㉺�\�ɂ��?A����Smen�Ɋ܂܂��ʓ��m�̃y�A��?d�Ȃ蕪�ނ�����̓?�v���Ƃ�
    public int kasanari_bunryi_mitei(Jyougehyou jg) {
        int iret = 0;
        for (int i = 1; i <= Menidsuu - 1; i++) {
            for (int j = i + 1; j <= Menidsuu; j++) {
                if (jg.get(Menid[getJyunretu(i)], Menid[getJyunretu(j)]) == -100) {
                    iret = iret + 1;
                }//20171021�{����-50�̂��肾��������?��-100�ƂȂ��Ă���
            }
        }
        return iret;
    }

    //-----------------------------------------------------------
    //?㉺�\�ɂ��?A����Smen�Ɋ܂܂��ʓ��m�̃y�A��?d�Ȃ蕪�ނ�����?ς݂̓?�v���Ƃ�
    public int kasanari_bunryi_ketteizumi(Jyougehyou jg) {
        int iret = 0;
        for (int i = 1; i <= Menidsuu - 1; i++) {
            for (int j = i + 1; j <= Menidsuu; j++) {
                if (jg.get(Menid[getJyunretu(i)], Menid[getJyunretu(j)]) == 0) {
                    iret = iret + 1;
                }
                if (jg.get(Menid[getJyunretu(i)], Menid[getJyunretu(j)]) == 1) {
                    iret = iret + 1;
                }
            }
        }
        return iret;
    }


}