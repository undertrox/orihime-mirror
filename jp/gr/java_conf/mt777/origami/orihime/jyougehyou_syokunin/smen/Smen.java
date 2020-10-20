package jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin.smen;

import jp.gr.java_conf.mt777.origami.orihime.ap;
import jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin.jyougehyou.Jyougehyou;
import jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin.jyougehyou.touka_jyouken.Touka_jyouken;
import jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin.smen.jyuufuku_jyunretu_hasseiki.Jyuufuku_Jyunretu_hasseiki;

public class Smen {//このクラスは展開?}をを?ﾜり?ﾝ??定してえられた?j金?}の面の?dなり?﨣?
    //記録活用するために使う?BJyougehyou_Syokuninクラスの中でのみ使う
    int Menidsuu;//Smen(?ﾜり?ﾝ??定してえられた?j金?}を?ﾗ分割した面)で?dなっているMen(?ﾜりたたむ前の展開?}の面)の???B
    int[] Menid;//S面に含まれるMenのid番??を記録する?Bこれが20ということは?A
    //?ﾜった後の紙の?dなりが?ﾅ大の???鰍ﾅも20-1=19面までということを意味する?B//この?ｧ限は現?ﾝは無し20150309
    //Jyunretu_hasseiki jh = new Jyunretu_hasseiki();
    Jyuufuku_Jyunretu_hasseiki jh;// = new Jyuufuku_Jyunretu_hasseiki();


    int Jyunretu_count = 1;


    //Annaisyo ann = new Annaisyo();

    int[] Menid2uekara_kazoeta_iti;//面(Menid)の?繧ｩら?狽ｦた位置を表す?B
    int[] uekara_kazoeta_iti2Menid;//?繧ｩら?狽ｦた位置の面を表す?B

    ap orihime_ap;

    public Smen() {
        reset();
    }  //コンストラクタ

    public Smen(ap ap0) {
        orihime_ap = ap0;
        reset();
    }  //コンストラクタ


    private void reset() {
        Menidsuu = 0;
    }

    //--------------------------------------
    //Ketasuuと?∠ｭ?ｶ機の?炎??ﾝ定?B忘れずにすること?B
    public void setKetasuu(int Midsuu) {
        Menidsuu = Midsuu;

        int[] Men_id = new int[Menidsuu + 1];
        Menid = Men_id;

        int[] Menid_2_uekara_kazoeta_iti = new int[Menidsuu + 1];  //面(Menid)の?繧ｩら?狽ｦた位置を表す?B
        int[] uekara_kazoeta_iti_2_Menid = new int[Menidsuu + 1];  //?繧ｩら?狽ｦた位置の面を表す?B
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

    // ここは?@class Smen の中だよ?B
 /*      //Smenの位置にMenが有るなら1?A無いなら0を返す?B
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

    } //?∠ﾌ1番目にもどる?B


    //--------------------------------------
    public int susumu() {
        return 0;
    }

/*
        //?∠ｭ?ｶ機を?iめ?A面の?dなり?ﾔを次の?ﾔにする?B通?墲ﾍ0をreturnする?B
	//もし現?ﾝの面の?dなり?ﾔが?A?ﾅ後のものだったら1をreturnして?A面の?dなり?ﾔは?ﾅ?奄ﾌものに戻る?B
	int susumu(Jyougehyou jg){
		return jh.susumu();
	}   //<<<<<<<<<<<<<<<<<<<ここは後で機能を強化して?ｑｬ化したい?B
*/

    //k桁目の?∠ｭ?ｶ機を?iめ?A面の?dなり?ﾔを次の?ﾔにする?B通?墲ﾍ0をreturnする?B
    //もし現?ﾝの面の?dなり?ﾔが?A?ﾅ後のものだったら1をreturnする?B
    //この???№ﾍ面の?dなり?ﾔは?ﾅ後のもののまま?B
    public int susumu(int k) {
        Jyunretu_count = Jyunretu_count + 1;
        return jh.susumu(k);
    }   //<<<<<<<<<<<<<<<<<<<ここは後で機能を強化して?ｑｬ化したい?B
    // ここは?@class Smen の中だよ?B

    //現?ﾝの?∠??ﾔから開始して?A可能な?dなりかたとなる?∠Tす
    public int kanou_kasanari_sagasi(Jyougehyou jg) {//これはjgを変えないはず?B
        int mk, ijh;
        mk = 0;
        ijh = 1;//ijhの?炎咊lは0以外ならなんでもいい?B
        while (ijh != 0) { //ijh==0なら?A桁の?ﾅ後まできた?B
            mk = mujyun_keta_motome(jg);

            //orihime_ap.keijiban.kakikae(8,"Smen_mujyun_keta_motome(jg) =  "+mk);
            if (mk == 1000) {
                return 1000;
            }//このSmenは?A矛?ｂﾍない?ﾔになっている?B

            ijh = susumu(mk);

            //	orihime_ap.keijiban.kakikae(9,"Smen_kanou_kasanari_sagasi(jg) =  "+ijh);

            String s0 = "";
            for (int i = 1; i <= Menidsuu; i++) {
                s0 = s0 + " : " + getJyunretu(i);
            }
            orihime_ap.keijiban.kakikae(10, "Smen_kanou_kasanari_sagasi(jg) =  " + s0);


            //try{Thread.sleep(1000);}catch (InterruptedException e){}// 1000ミリ秒待機する?B


        }
        return 0;//可能な?dなりかたとなる?∠ﾍ存?ﾝしない
    }

    // ここは?@class Smen の中だよ?B


    /*    //このSmenで?dなる面の?dなり????の????
        int getJyunretusuu(){
		int ir;
		for(int i=1;i<=Menidsuu;i++){
			ir=ir*i;
		}
		return ir;
	}
     */

    // 現?ﾝの?∠??ﾔをもとに?A?繧ｩら?狽ｦてi番めの面のid番??を返す?B

    private int get_uekara_kazoeta_itino_Menid(int i) {
        return Menid[getJyunretu(i)];
    }


    //現?ﾝの?繪ｺ表をもとに?A?繧ｩら?狽ｦてi番めの面のid番??を格納する?B
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

    //現?ﾝの?繪ｺ表をもとに?A?繧ｩら?狽ｦてi番めの面のid番??を返す?B?繪ｺ表は完?ｬしたものを使わないと結果がおかしくなる恐れ有り?B
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



              return 0;//ここはエラ?[がなければ通ることは無い?B
            */

    }

    //
    private int getJyunretu(int i) {
        return jh.getJyunretu(i);
    }

    //一番?繧ﾌ面からチェックしていって何桁目で?ﾜり?dなりに矛?ｂｪ?ｶじるかを??める?B
    //この?ﾛjgは変化しない?Bなおここでは隣?ﾚ面の境界??の突き抜け??はチェックしていない?B
    //このSmenでは?ﾜり?dなりに矛?ｂｪない???№ﾍ1000を返す?B
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

    //面imの?dなり?№ｪ?繧ｩら何番目かを??める?BこのSmenにMenが含まれないときは0を返す?B
    public int Menid2Jyunretuketa(int im) {
        for (int i = 1; i <= Menidsuu; i++) {
            if (Menid[getJyunretu(i)] == im) {
                return i;
            }
        }
        return 0;
    }


    // ここは?@class Smen の中だよ?B


    //一番?繧ﾌ面からチェックしていって何番目で隣?ﾚ面の境界??の突き抜け??に矛?ｂｪ?ｶじるかを??める?B
    //この?ﾛjgは変化しない?BこのSmenでは突き抜け??に矛?ｂｪない???№ﾍ1000を返す?B
    private int tukinuke_mujyun_keta_motome(Touka_jyouken tj) {
        int mm, M1, M2; //?ﾜり?ﾝ??定の?ﾛの等価??の登録は?@addTouka_jyouken(im,Mid_min,im,Mid_max);  による
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

        // if(ketaMim==Menidsuu-1) {  return 1000;}    <<<<<<<<テスト用

        return ketaMim;

    }


    //一番?繧ﾌ面からチェックしていって何番目で境界??の一部を共有する２面と２面の突き抜け??に矛?ｂｪ?ｶじるかを??める?B
    //この?ﾛjgは変化しない?BこのSmenでは矛?ｂｪない???№ﾍ1000を返す?B
    private int u_tukinuke_mujyun_keta_motome(Touka_jyouken uj) {
        int mi1, mi2, mj1, mj2, itemp; //?ﾜり?ﾝ??定の?ﾛの等価??の登録は?@u_addTouka_jyouken(im1,im2,im3,im4);  による
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

        // if(ketaMim==Menidsuu-1) {  return 1000;}    <<<<<<<<テスト用

        return ketaMim;


    }


    // ここは?@class Smen の中だよ?B


    //一番?繧ﾌ面からチェックしていって何番目で矛?ｂｪ?ｶじるかを??める?B
    //この?ﾛjgは変化しない?BこのSmenでは矛?ｂｪない???№ﾍ1000を返す?B
    private int mujyun_keta_motome(Jyougehyou jg) {
        int min1, min2, min3;
        min1 = kasanari_mujyun_keta_motome(jg);
        min2 = tukinuke_mujyun_keta_motome(jg);
        min3 = u_tukinuke_mujyun_keta_motome(jg);

        //min1,min2,min3の中で?ﾅ?ｬ値をリタ?[ンする?B
        if (min3 < min2) {
            min2 = min3;
        }
        if (min2 < min1) {
            min1 = min2;
        }

        return min1;

    }


    //?繪ｺ表にSmenの面の?dなりによる?﨣?れる
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


    //?繪ｺ表にSmenの面の?dなりによる?﨣?れる?Bこれは?炎冾ﾌ計算??備の?ﾛにSmenの有効?狽?めるのに使う?B
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

    //?繪ｺ表にSmenによって何個の?V?﨣ｪ入るかを返す?B
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


    //  jg[][]は?ﾜる前の展開?}のすべての面同士の?繪ｺ関係を1つの表にまとめたものとして扱う
    //?@jg[i][j]が1なら面iは面jの?繿､?B0なら下側?B
    //  jg[i][j]が-50なら?A面iとjは?dなが?A?繪ｺ関係は決められていない?B
    //jg[i][j]が-100なら?A面iとjは?dなるところがない?B


    public void setAnnaisyo(Jyougehyou jg) { //?d複?∠ｭ?ｶ機の案内?曹menで??備してやる?B
        int[] ueMenid = new int[Menidsuu + 1];
        int[] ueMenidFlg = new int[Menidsuu + 1];//ueMenid[]が有効なら1?A無効なら0

        for (int iMen = 1; iMen <= Menidsuu; iMen++) {
            int ueMenidsuu = 0;//ueMenid[]が?A1からいくつまであるかを格納?B

            //まず?A?繧ﾉある面のSmenでのid番??をueMenid[]に収?W
            for (int i = 1; i <= Menidsuu; i++) {
                if (jg.get(Menid[i], Menid[iMen]) == 1) {
                    ueMenidsuu = ueMenidsuu + 1;
                    ueMenid[ueMenidsuu] = i;
                    ueMenidFlg[ueMenidsuu] = 1;
                }
            }

            //無効にするid番??のueMenidFlg[id]を0にする?B
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

            //案内?曹ﾉ格納
            for (int i = 1; i <= ueMenidsuu; i++) {
                if (ueMenidFlg[i] == 1) {
                    jh.addAnnai(iMen, ueMenid[i]);
                }
            }

        }

    }

    //-----------------------------------------------------------
    //?繪ｺ表による?AこのSmenに含まれる面同士のペアの?dなり分類が未定の??計をとる
    public int kasanari_bunryi_mitei(Jyougehyou jg) {
        int iret = 0;
        for (int i = 1; i <= Menidsuu - 1; i++) {
            for (int j = i + 1; j <= Menidsuu; j++) {
                if (jg.get(Menid[getJyunretu(i)], Menid[getJyunretu(j)]) == -100) {
                    iret = iret + 1;
                }//20171021本当は-50のつもりだったが現?ﾍ-100となっている
            }
        }
        return iret;
    }

    //-----------------------------------------------------------
    //?繪ｺ表による?AこのSmenに含まれる面同士のペアの?dなり分類が決定?ﾏみの??計をとる
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