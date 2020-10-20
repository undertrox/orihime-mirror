package jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin.smen;

import jp.gr.java_conf.mt777.origami.orihime.ap;
import jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin.jyougehyou.Jyougehyou;
import jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin.smen.jyuufuku_jyunretu_hasseiki.Jyuufuku_Jyunretu_hasseiki;

public class Smen {//‚±‚ÌƒNƒ‰ƒX‚Í“WŠJ?}‚ð‚ð?Ü‚è?ô‚Ý?„’è‚µ‚Ä‚¦‚ç‚ê‚½?j‹à?}‚Ì–Ê‚Ì?d‚È‚è?î•ñ‚ð
    //‹L˜^Šˆ—p‚·‚é‚½‚ß‚ÉŽg‚¤?BJyougehyou_SyokuninƒNƒ‰ƒX‚Ì’†‚Å‚Ì‚ÝŽg‚¤
    int Menidsuu;//Smen(?Ü‚è?ô‚Ý?„’è‚µ‚Ä‚¦‚ç‚ê‚½?j‹à?}‚ð?×•ªŠ„‚µ‚½–Ê)‚Å?d‚È‚Á‚Ä‚¢‚éMen(?Ü‚è‚½‚½‚Þ‘O‚Ì“WŠJ?}‚Ì–Ê)‚Ì?”?B
    int[] Menid;//S–Ê‚ÉŠÜ‚Ü‚ê‚éMen‚Ìid”Ô?†‚ð‹L˜^‚·‚é?B‚±‚ê‚ª20‚Æ‚¢‚¤‚±‚Æ‚Í?A
    //?Ü‚Á‚½Œã‚ÌŽ†‚Ì?d‚È‚è‚ª?Å‘å‚Ì?ê?Š‚Å‚à20-1=19–Ê‚Ü‚Å‚Æ‚¢‚¤‚±‚Æ‚ðˆÓ–¡‚·‚é?B//‚±‚Ì?§ŒÀ‚ÍŒ»?Ý‚Í–³‚µ20150309
    //Jyunretu_hasseiki jh = new Jyunretu_hasseiki();
    Jyuufuku_Jyunretu_hasseiki jh;// = new Jyuufuku_Jyunretu_hasseiki();


    int Jyunretu_count = 1;


    //Annaisyo ann = new Annaisyo();

    int[] Menid2uekara_kazoeta_iti;//–Ê(Menid)‚Ì?ã‚©‚ç?”‚¦‚½ˆÊ’u‚ð•\‚·?B
    int[] uekara_kazoeta_iti2Menid;//?ã‚©‚ç?”‚¦‚½ˆÊ’u‚Ì–Ê‚ð•\‚·?B

    ap orihime_ap;

    public Smen() {
        reset();
    }  //ƒRƒ“ƒXƒgƒ‰ƒNƒ^

    public Smen(ap ap0) {
        orihime_ap = ap0;
        reset();
    }  //ƒRƒ“ƒXƒgƒ‰ƒNƒ^


    private void reset() {
        Menidsuu = 0;
    }

    //--------------------------------------
    //Ketasuu‚Æ?‡—ñ”­?¶‹@‚Ì?‰Šú?Ý’è?B–Y‚ê‚¸‚É‚·‚é‚±‚Æ?B
    public void setKetasuu(int Midsuu) {
        Menidsuu = Midsuu;

        int[] Men_id = new int[Menidsuu + 1];
        Menid = Men_id;

        int[] Menid_2_uekara_kazoeta_iti = new int[Menidsuu + 1];  //–Ê(Menid)‚Ì?ã‚©‚ç?”‚¦‚½ˆÊ’u‚ð•\‚·?B
        int[] uekara_kazoeta_iti_2_Menid = new int[Menidsuu + 1];  //?ã‚©‚ç?”‚¦‚½ˆÊ’u‚Ì–Ê‚ð•\‚·?B
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

    // ‚±‚±‚Í?@class Smen ‚Ì’†‚¾‚æ?B
 /*      //Smen‚ÌˆÊ’u‚ÉMen‚ª—L‚é‚È‚ç1?A–³‚¢‚È‚ç0‚ð•Ô‚·?B
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

    } //?‡—ñ‚Ì1”Ô–Ú‚É‚à‚Ç‚é?B


    //--------------------------------------
    public int susumu() {
        return 0;
    }

/*
        //?‡—ñ”­?¶‹@‚ð?i‚ß?A–Ê‚Ì?d‚È‚è?ó‘Ô‚ðŽŸ‚Ì?ó‘Ô‚É‚·‚é?B’Ê?í‚Í0‚ðreturn‚·‚é?B
	//‚à‚µŒ»?Ý‚Ì–Ê‚Ì?d‚È‚è?ó‘Ô‚ª?A?ÅŒã‚Ì‚à‚Ì‚¾‚Á‚½‚ç1‚ðreturn‚µ‚Ä?A–Ê‚Ì?d‚È‚è?ó‘Ô‚Í?Å?‰‚Ì‚à‚Ì‚É–ß‚é?B
	int susumu(Jyougehyou jg){
		return jh.susumu();
	}   //<<<<<<<<<<<<<<<<<<<‚±‚±‚ÍŒã‚Å‹@”\‚ð‹­‰»‚µ‚Ä?‚‘¬‰»‚µ‚½‚¢?B
*/

    //kŒ…–Ú‚Ì?‡—ñ”­?¶‹@‚ð?i‚ß?A–Ê‚Ì?d‚È‚è?ó‘Ô‚ðŽŸ‚Ì?ó‘Ô‚É‚·‚é?B’Ê?í‚Í0‚ðreturn‚·‚é?B
    //‚à‚µŒ»?Ý‚Ì–Ê‚Ì?d‚È‚è?ó‘Ô‚ª?A?ÅŒã‚Ì‚à‚Ì‚¾‚Á‚½‚ç1‚ðreturn‚·‚é?B
    //‚±‚Ì?ê?‡‚Í–Ê‚Ì?d‚È‚è?ó‘Ô‚Í?ÅŒã‚Ì‚à‚Ì‚Ì‚Ü‚Ü?B
    public int susumu(int k) {
        Jyunretu_count = Jyunretu_count + 1;
        return jh.susumu(k);
    }   //<<<<<<<<<<<<<<<<<<<‚±‚±‚ÍŒã‚Å‹@”\‚ð‹­‰»‚µ‚Ä?‚‘¬‰»‚µ‚½‚¢?B
    // ‚±‚±‚Í?@class Smen ‚Ì’†‚¾‚æ?B

    //Œ»?Ý‚Ì?‡—ñ?ó‘Ô‚©‚çŠJŽn‚µ‚Ä?A‰Â”\‚È?d‚È‚è‚©‚½‚Æ‚È‚é?‡—ñ‚ð’T‚·
    public int kanou_kasanari_sagasi(Jyougehyou jg) {//‚±‚ê‚Íjg‚ð•Ï‚¦‚È‚¢‚Í‚¸?B
        int mk, ijh;
        mk = 0;
        ijh = 1;//ijh‚Ì?‰Šú’l‚Í0ˆÈŠO‚È‚ç‚È‚ñ‚Å‚à‚¢‚¢?B
        while (ijh != 0) { //ijh==0‚È‚ç?AŒ…‚Ì?ÅŒã‚Ü‚Å‚«‚½?B
            mk = mujyun_keta_motome(jg);

            //orihime_ap.keijiban.kakikae(8,"Smen_mujyun_keta_motome(jg) =  "+mk);
            if (mk == 1000) {
                return 1000;
            }//‚±‚ÌSmen‚Í?A–µ?‚‚Í‚È‚¢?ó‘Ô‚É‚È‚Á‚Ä‚¢‚é?B

            ijh = susumu(mk);

            //	orihime_ap.keijiban.kakikae(9,"Smen_kanou_kasanari_sagasi(jg) =  "+ijh);

            String s0 = "";
            for (int i = 1; i <= Menidsuu; i++) {
                s0 = s0 + " : " + getJyunretu(i);
            }
            orihime_ap.keijiban.kakikae(10, "Smen_kanou_kasanari_sagasi(jg) =  " + s0);


            //try{Thread.sleep(1000);}catch (InterruptedException e){}// 1000ƒ~ƒŠ•b‘Ò‹@‚·‚é?B


        }
        return 0;//‰Â”\‚È?d‚È‚è‚©‚½‚Æ‚È‚é?‡—ñ‚Í‘¶?Ý‚µ‚È‚¢
    }

    // ‚±‚±‚Í?@class Smen ‚Ì’†‚¾‚æ?B


    /*    //‚±‚ÌSmen‚Å?d‚È‚é–Ê‚Ì?d‚È‚è?‡?˜‚Ì‘??”
        int getJyunretusuu(){
		int ir;
		for(int i=1;i<=Menidsuu;i++){
			ir=ir*i;
		}
		return ir;
	}
     */

    // Œ»?Ý‚Ì?‡—ñ?ó‘Ô‚ð‚à‚Æ‚É?A?ã‚©‚ç?”‚¦‚Äi”Ô‚ß‚Ì–Ê‚Ìid”Ô?†‚ð•Ô‚·?B

    private int get_uekara_kazoeta_itino_Menid(int i) {
        return Menid[getJyunretu(i)];
    }


    //Œ»?Ý‚Ì?ã‰º•\‚ð‚à‚Æ‚É?A?ã‚©‚ç?”‚¦‚Äi”Ô‚ß‚Ì–Ê‚Ìid”Ô?†‚ðŠi”[‚·‚é?B
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

    //Œ»?Ý‚Ì?ã‰º•\‚ð‚à‚Æ‚É?A?ã‚©‚ç?”‚¦‚Äi”Ô‚ß‚Ì–Ê‚Ìid”Ô?†‚ð•Ô‚·?B?ã‰º•\‚ÍŠ®?¬‚µ‚½‚à‚Ì‚ðŽg‚í‚È‚¢‚ÆŒ‹‰Ê‚ª‚¨‚©‚µ‚­‚È‚é‹°‚ê—L‚è?B
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



              return 0;//‚±‚±‚ÍƒGƒ‰?[‚ª‚È‚¯‚ê‚Î’Ê‚é‚±‚Æ‚Í–³‚¢?B
            */

    }

    //
    private int getJyunretu(int i) {
        return jh.getJyunretu(i);
    }

    //ˆê”Ô?ã‚Ì–Ê‚©‚çƒ`ƒFƒbƒN‚µ‚Ä‚¢‚Á‚Ä‰½Œ…–Ú‚Å?Ü‚è?d‚È‚è‚É–µ?‚‚ª?¶‚¶‚é‚©‚ð‹?‚ß‚é?B
    //‚±‚Ì?Ûjg‚Í•Ï‰»‚µ‚È‚¢?B‚È‚¨‚±‚±‚Å‚Í—×?Ú–Ê‚Ì‹«ŠE?ü‚Ì“Ë‚«”²‚¯?ðŒ?‚Íƒ`ƒFƒbƒN‚µ‚Ä‚¢‚È‚¢?B
    //‚±‚ÌSmen‚Å‚Í?Ü‚è?d‚È‚è‚É–µ?‚‚ª‚È‚¢?ê?‡‚Í1000‚ð•Ô‚·?B
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

    //–Êim‚Ì?d‚È‚è?‡‚ª?ã‚©‚ç‰½”Ô–Ú‚©‚ð‹?‚ß‚é?B‚±‚ÌSmen‚ÉMen‚ªŠÜ‚Ü‚ê‚È‚¢‚Æ‚«‚Í0‚ð•Ô‚·?B
    public int Menid2Jyunretuketa(int im) {
        for (int i = 1; i <= Menidsuu; i++) {
            if (Menid[getJyunretu(i)] == im) {
                return i;
            }
        }
        return 0;
    }


    // ‚±‚±‚Í?@class Smen ‚Ì’†‚¾‚æ?B


    //ˆê”Ô?ã‚Ì–Ê‚©‚çƒ`ƒFƒbƒN‚µ‚Ä‚¢‚Á‚Ä‰½”Ô–Ú‚Å—×?Ú–Ê‚Ì‹«ŠE?ü‚Ì“Ë‚«”²‚¯?ðŒ?‚É–µ?‚‚ª?¶‚¶‚é‚©‚ð‹?‚ß‚é?B
    //‚±‚Ì?Ûjg‚Í•Ï‰»‚µ‚È‚¢?B‚±‚ÌSmen‚Å‚Í“Ë‚«”²‚¯?ðŒ?‚É–µ?‚‚ª‚È‚¢?ê?‡‚Í1000‚ð•Ô‚·?B
    private int tukinuke_mujyun_keta_motome(Touka_jyouken tj) {
        int mm, M1, M2; //?Ü‚è?ô‚Ý?„’è‚Ì?Û‚Ì“™‰¿?ðŒ?‚Ì“o˜^‚Í?@addTouka_jyouken(im,Mid_min,im,Mid_max);  ‚É‚æ‚é
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

        // if(ketaMim==Menidsuu-1) {  return 1000;}    <<<<<<<<ƒeƒXƒg—p

        return ketaMim;

    }


    //ˆê”Ô?ã‚Ì–Ê‚©‚çƒ`ƒFƒbƒN‚µ‚Ä‚¢‚Á‚Ä‰½”Ô–Ú‚Å‹«ŠE?ü‚Ìˆê•”‚ð‹¤—L‚·‚é‚Q–Ê‚Æ‚Q–Ê‚Ì“Ë‚«”²‚¯?ðŒ?‚É–µ?‚‚ª?¶‚¶‚é‚©‚ð‹?‚ß‚é?B
    //‚±‚Ì?Ûjg‚Í•Ï‰»‚µ‚È‚¢?B‚±‚ÌSmen‚Å‚Í–µ?‚‚ª‚È‚¢?ê?‡‚Í1000‚ð•Ô‚·?B
    private int u_tukinuke_mujyun_keta_motome(Touka_jyouken uj) {
        int mi1, mi2, mj1, mj2, itemp; //?Ü‚è?ô‚Ý?„’è‚Ì?Û‚Ì“™‰¿?ðŒ?‚Ì“o˜^‚Í?@u_addTouka_jyouken(im1,im2,im3,im4);  ‚É‚æ‚é
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

        // if(ketaMim==Menidsuu-1) {  return 1000;}    <<<<<<<<ƒeƒXƒg—p

        return ketaMim;


    }


    // ‚±‚±‚Í?@class Smen ‚Ì’†‚¾‚æ?B


    //ˆê”Ô?ã‚Ì–Ê‚©‚çƒ`ƒFƒbƒN‚µ‚Ä‚¢‚Á‚Ä‰½”Ô–Ú‚Å–µ?‚‚ª?¶‚¶‚é‚©‚ð‹?‚ß‚é?B
    //‚±‚Ì?Ûjg‚Í•Ï‰»‚µ‚È‚¢?B‚±‚ÌSmen‚Å‚Í–µ?‚‚ª‚È‚¢?ê?‡‚Í1000‚ð•Ô‚·?B
    private int mujyun_keta_motome(Jyougehyou jg) {
        int min1, min2, min3;
        min1 = kasanari_mujyun_keta_motome(jg);
        min2 = tukinuke_mujyun_keta_motome(jg);
        min3 = u_tukinuke_mujyun_keta_motome(jg);

        //min1,min2,min3‚Ì’†‚Å?Å?¬’l‚ðƒŠƒ^?[ƒ“‚·‚é?B
        if (min3 < min2) {
            min2 = min3;
        }
        if (min2 < min1) {
            min1 = min2;
        }

        return min1;

    }


    //?ã‰º•\‚ÉSmen‚Ì–Ê‚Ì?d‚È‚è‚É‚æ‚é?î•ñ‚ð“ü‚ê‚é
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


    //?ã‰º•\‚ÉSmen‚Ì–Ê‚Ì?d‚È‚è‚É‚æ‚é?î•ñ‚ð“ü‚ê‚é?B‚±‚ê‚Í?‰Šú‚ÌŒvŽZ?€”õ‚Ì?Û‚ÉSmen‚Ì—LŒø?”‚ð‹?‚ß‚é‚Ì‚ÉŽg‚¤?B
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

    //?ã‰º•\‚ÉSmen‚É‚æ‚Á‚Ä‰½ŒÂ‚Ì?V?î•ñ‚ª“ü‚é‚©‚ð•Ô‚·?B
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


    //  jg[][]‚Í?Ü‚é‘O‚Ì“WŠJ?}‚Ì‚·‚×‚Ä‚Ì–Ê“¯Žm‚Ì?ã‰ºŠÖŒW‚ð1‚Â‚Ì•\‚É‚Ü‚Æ‚ß‚½‚à‚Ì‚Æ‚µ‚Äˆµ‚¤
    //?@jg[i][j]‚ª1‚È‚ç–Êi‚Í–Êj‚Ì?ã‘¤?B0‚È‚ç‰º‘¤?B
    //  jg[i][j]‚ª-50‚È‚ç?A–Êi‚Æj‚Í?d‚È‚ª?A?ã‰ºŠÖŒW‚ÍŒˆ‚ß‚ç‚ê‚Ä‚¢‚È‚¢?B
    //jg[i][j]‚ª-100‚È‚ç?A–Êi‚Æj‚Í?d‚È‚é‚Æ‚±‚ë‚ª‚È‚¢?B


    public void setAnnaisyo(Jyougehyou jg) { //?d•¡?‡—ñ”­?¶‹@‚ÌˆÄ“à?‘‚ðSmen‚Å?€”õ‚µ‚Ä‚â‚é?B
        int[] ueMenid = new int[Menidsuu + 1];
        int[] ueMenidFlg = new int[Menidsuu + 1];//ueMenid[]‚ª—LŒø‚È‚ç1?A–³Œø‚È‚ç0

        for (int iMen = 1; iMen <= Menidsuu; iMen++) {
            int ueMenidsuu = 0;//ueMenid[]‚ª?A1‚©‚ç‚¢‚­‚Â‚Ü‚Å‚ ‚é‚©‚ðŠi”[?B

            //‚Ü‚¸?A?ã‚É‚ ‚é–Ê‚ÌSmen‚Å‚Ìid”Ô?†‚ðueMenid[]‚ÉŽû?W
            for (int i = 1; i <= Menidsuu; i++) {
                if (jg.get(Menid[i], Menid[iMen]) == 1) {
                    ueMenidsuu = ueMenidsuu + 1;
                    ueMenid[ueMenidsuu] = i;
                    ueMenidFlg[ueMenidsuu] = 1;
                }
            }

            //–³Œø‚É‚·‚éid”Ô?†‚ÌueMenidFlg[id]‚ð0‚É‚·‚é?B
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

            //ˆÄ“à?‘‚ÉŠi”[
            for (int i = 1; i <= ueMenidsuu; i++) {
                if (ueMenidFlg[i] == 1) {
                    jh.addAnnai(iMen, ueMenid[i]);
                }
            }

        }

    }

    //-----------------------------------------------------------
    //?ã‰º•\‚É‚æ‚é?A‚±‚ÌSmen‚ÉŠÜ‚Ü‚ê‚é–Ê“¯Žm‚ÌƒyƒA‚Ì?d‚È‚è•ª—Þ‚ª–¢’è‚Ì“?Œv‚ð‚Æ‚é
    public int kasanari_bunryi_mitei(Jyougehyou jg) {
        int iret = 0;
        for (int i = 1; i <= Menidsuu - 1; i++) {
            for (int j = i + 1; j <= Menidsuu; j++) {
                if (jg.get(Menid[getJyunretu(i)], Menid[getJyunretu(j)]) == -100) {
                    iret = iret + 1;
                }//20171021–{“–‚Í-50‚Ì‚Â‚à‚è‚¾‚Á‚½‚ªŒ»?ó‚Í-100‚Æ‚È‚Á‚Ä‚¢‚é
            }
        }
        return iret;
    }

    //-----------------------------------------------------------
    //?ã‰º•\‚É‚æ‚é?A‚±‚ÌSmen‚ÉŠÜ‚Ü‚ê‚é–Ê“¯Žm‚ÌƒyƒA‚Ì?d‚È‚è•ª—Þ‚ªŒˆ’è?Ï‚Ý‚Ì“?Œv‚ð‚Æ‚é
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