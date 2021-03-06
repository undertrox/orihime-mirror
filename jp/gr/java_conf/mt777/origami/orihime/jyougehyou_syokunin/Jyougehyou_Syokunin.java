package jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin;

import jp.gr.java_conf.mt777.kiroku.memo.Memo;
import jp.gr.java_conf.mt777.kiroku.moji_sousa.Moji_sousa;
import jp.gr.java_conf.mt777.origami.dougu.camera.Camera;
import jp.gr.java_conf.mt777.origami.dougu.tensyuugou.Tensyuugou;
import jp.gr.java_conf.mt777.origami.orihime.ap;
import jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin.jyougehyou.Jyougehyou;
import jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin.jyougehyou.touka_jyouken.Touka_jyouken;
import jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin.smen.Smen;
import jp.gr.java_conf.mt777.origami.orihime.tenkaizu_syokunin.Tenkaizu_Syokunin;
import jp.gr.java_conf.mt777.seiretu.narabebako.Narabebako_int_double;
import jp.gr.java_conf.mt777.seiretu.narabebako.int_double;
import jp.gr.java_conf.mt777.zukei2d.oritaoekaki.OritaOekaki;
import jp.gr.java_conf.mt777.zukei2d.senbun.Senbun;
import jp.gr.java_conf.mt777.zukei2d.ten.Ten;

import java.awt.*;
import java.math.BigDecimal;
import java.util.Random;


public class Jyougehyou_Syokunin {//?繪ｺ表?@?ﾜりたたむ前の展開?}の面が?ﾜりたたんだあとでどのような?繪ｺ関係になるかを記録し活用する
	//String c=new String();
	//int Mensuu;             //?ﾜりたたむ前の展開?}の面の?? 
	Jyougehyou jg = new Jyougehyou();
	Touka_jyouken errorPos = null;
	//Jyougehyou jg;// =new Jyougehyou();
	//Jyougehyou jg_syokiti =new Jyougehyou();//展開?}のみから得られる?繪ｺ関係を記録しておく?B
	int Smensuu;//Smenの??
	int Smen_yuukou_suu;//Smenは全て調べなくても?AMenの?繪ｺ関係は網羅できる?BMenの?繪ｺ関係を網羅するのに必要なSmenの?狽ｪ優???�位の何番目までかをさがす?B
	int Menidsuu_max;//各Smenの??つMenidsuuの?ﾅ大値?Bすなわち?A?ﾅも紙に?dなりが多いところの枚???B
	//paint 用のint格納用VVVVVVVVVVVVVVVVVVVVVV
	int ip1 = 0; //0は?ﾜり?�み?}の表側を表示するモ?[ド?B1は?ﾜり?�み?}の裏側を表示するモ?[ド?B
	// int ip1,ip2,ip3,ip4,ip5;
	int hyouji_yousiki = 0;//表示様式の指定
	//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
	//  jg[][]は?ﾜる前の展開?}のすべての面同士の?繪ｺ関係を1つの表にまとめたものとして扱う
	//?@jg[i][j]が1なら面iは面jの?繿､?B0なら下側?B
	//  jg[i][j]が-50なら?A面iとjは?dなが?A?繪ｺ関係は決められていない?B
	//jg[i][j]が-100なら?A面iとjは?dなるところがない?B

	Smen[] s0;//Smen_zuから得られるSmen
	Smen[] s;//sは優?謫xの?ｂ｢?�にs0を並べ替えたもの?B
	int[] s0_no_yusenjyun;
	int[] yusenjyun_kara_s0id;

	int i_kage = 0; //影を表示するかどうか?B0は表示しない?A1は表示する

	Camera camera = new Camera();

	ap orihime_ap;
	Moji_sousa ms = new Moji_sousa();


	public double[] men_rating;
	public int[] i_men_rating;

	public Narabebako_int_double nbox = new Narabebako_int_double();//20180227?@nboxにはmenのidがmen_ratingと組になって?Amen_ratingの?ｬさい?�に並べ替えられて入っている?B


	//-----------------------------------------------------------------
	public Jyougehyou_Syokunin() {
		reset();
	}    //コンストラクタ

	//-----------------------------------------------------------------
	public Jyougehyou_Syokunin(ap ap0) {
		orihime_ap = ap0;
		reset();
	}    //コンストラクタ

	//-----------------------------------------------------------------
	public void reset() {
		jg.reset();//jg_syokiti.reset();
		Smensuu = 0;
		Smen_yuukou_suu = 0;
		ip1 = 0;
		Menidsuu_max = 0;
		camera.reset();
	}


	//--------
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


	public int getSmensuu() {
		return Smensuu;
	}

	public int getSmen_yuukou_suu() {
		return Smen_yuukou_suu;
	}

	//?@ここは  class Jyougehyou_Syokunin  の中です?B
	//?繪ｺ表の?炎??ﾝ定?B展開?}に1頂点から奇?狽ﾌ?ﾜ??がでる誤りがある????0を返す?Bそれが無ければ1000を返す?B
	//展開?}に山谷?ﾜ??の拡張による誤りがある????2を返す?B

	//----------------------------------------------------------------------
/*
	public int Jyougehyou_settei  (Tenkaizu_Syokunin orite,Tensyuugou otta_Men_zu,Tensyuugou Smen_zu){//js.Jyougehyou_settei(ts1,ts2.get(),ts3.get()){
         	Smen_settei           (                  orite,           otta_Men_zu,           Smen_zu);
         return Jyougehyou_settei_2   (                  orite,           otta_Men_zu,           Smen_zu);
       }
*/
	public void Smen_settei(Tenkaizu_Syokunin orite, Tensyuugou otta_Men_zu, Tensyuugou Smen_zu) {//js.Jyougehyou_settei(ts1,ts2.get(),ts3.get());
		//面(?ﾜりたたむ前の展開?}の面のこと)の?繪ｺ表を??る?B
		//これにはts2の??つ点?W???i?ﾜりたたんだあとの面の位置関係の?�ｱ�を�?つ?jと  <-------------otta_Men_zu
		//ts3の??つ点?W???i?j金?}で面を?ﾗ分割したSmenの?�ｱ�を�?つ?jを使う?B <-------------Smen_zu
		//また?Ats1の??つ?A?ﾜったときの面の位置関係の?�ｱ�も使う?B


		System.out.println("Smenの?炎??ﾝ定");
		reset();
		Smensuu = Smen_zu.getMensuu();
		//4915                      System.out.print("Smensuu = "); System.out.println(Smensuu);System.exit(0);

		Smen[] s0_ori = new Smen[Smensuu + 1];
		Smen[] s_ori = new Smen[Smensuu + 1];
		s0 = s0_ori;
		s = s_ori;
		int[] s0yj = new int[Smensuu + 1];
		int[] yjs0 = new int[Smensuu + 1];
		s0_no_yusenjyun = s0yj;
		yusenjyun_kara_s0id = yjs0;

		//	Smensuu=Smen_zu.getMensuu();
		//int ireturn=1000;

		// Jyougehyou j_g =new Jyougehyou();
		// jg=j_g;
		//jg.setMensuu(otta_Men_zu.getMensuu());

		//4926                     System.out.print("Smensuu = "); System.out.println(Smensuu);System.exit(0);

		//
		for (int i = 0; i < Smensuu + 1; i++) {
			s0[i] = new Smen(orihime_ap);
			s[i] = s0[i];
			s0_no_yusenjyun[i] = 0;
			yusenjyun_kara_s0id[i] = i;
		}
		//

		//各Smenに含まれる面を記録する?B
		System.out.println("各Smenに含まれる面を記録するため?A各Smenの内部点を登録");
		Ten[] Smen_naibuTen = new Ten[Smensuu + 1];  //<<<<<<<<<<<<<<<<<<<<<<<<<<<オブジェクトの配列を動的に指定
		for (int i = 1; i <= Smensuu; i++) {
			Smen_naibuTen[i] = Smen_zu.naibuTen_motome(i);
		}

		System.out.println("各Smenに含まれる面を記録する");
		otta_Men_zu.BouMenMaxMinZahyou();//tttttttttt

		int[] s0addMenid = new int[otta_Men_zu.getMensuu() + 1];  //Smenに追加する面を一時記録しておく

/*
		for(int i=1;i<=Smensuu;i++){
		       int s0addMenidsuu=0;

			for(int j=1;j<=jg.getMensuu();j++){
				//if(otta_Men_zu.naibu(Smen_zu.naibuTen_motome(i),j)==2){
				if(otta_Men_zu.kantan_naibu(Smen_naibuTen[i],j)==2){
					s0[i].addMenid(j)	;//ここで面番??jは?ｬさい方が?謔ﾉ追加される?B
				}
			}
                        s0[i].setKetasuu();
		}
*/

		for (int i = 1; i <= Smensuu; i++) {
			int s0addMenidsuu = 0;
			//System.out.println("現?ﾝ????中のSmenは?A"+i+" / "+Smensuu );
			//for(int j=1;j<=jg.getMensuu();j++){

			for (int j = 1; j <= otta_Men_zu.getMensuu(); j++) {

				//System.out.print("現?ﾝ????中のSmenは?A"+i+" / "+Smensuu +"     :::     "   +j+"/"+jg.getMensuu()+"-");
				if (otta_Men_zu.kantan_naibu(Smen_naibuTen[i], j) == 2) {
					//System.out.println(j);
					s0addMenidsuu = s0addMenidsuu + 1;
					s0addMenid[s0addMenidsuu] = j;
				}

			}
			//if (s0addMenidsuu==0){
			//System.out.println("**1** 現?ﾝ????中のSmenは?A"+i+" / "+Smensuu+"  :::  s0addMenidsuu= "+s0addMenidsuu+" ::: 面?ﾏ= "+Smen_zu.menseki_motome(i));
			//}/////////20150308

			s0[i].setKetasuu(s0addMenidsuu);

			//System.out.println("**2**");
			for (int j = 1; j <= s0addMenidsuu; j++) {
				s0[i].setMenid(j, s0addMenid[j]);//ここで面番??jは?ｬさい方が?謔ﾉ追加される?B
			}
			//System.out.println("**3**");
		}

		//4956                     System.out.print("Smensuu = "); System.out.println(Smensuu);System.exit(0);
		//ここまでで?ASmensuu??	Smen_zu.getMensuu()のままかわりなし?B
		System.out.println("各Smenに含まれる面の?狽ﾌ内で?ﾅ大のものを??める");
		//各Smenに含まれる面の?狽ﾌ内で?ﾅ大のものを??める?B
		Menidsuu_max = 0;
		for (int i = 1; i <= Smensuu; i++) {
			if (s0[i].getMenidsuu() > Menidsuu_max) {
				Menidsuu_max = s0[i].getMenidsuu();
			}
		}
	}

// --------------------------------------------------------------------------------------------------------------------------
/*
	public int getMenidsuu_max(){
		int M_id_max;M_id_max=0;
		for(int i=1;i<=Smen_zu.getMensuu();i++){
			if(s0[i].getMenidsuu()>M_id_max){M_id_max = s0[i].getMenidsuu();}
		}
		return M_id_max;
	}
*/

	//------------------------------------------------------
	public int Jyougehyou_settei(Tenkaizu_Syokunin orite, Tensyuugou otta_Men_zu, Tensyuugou Smen_zu) {//js.Jyougehyou_settei(ts1,ts2.get(),ts3.get());
		orihime_ap.keijiban.tuiki("           Jyougehyou_settei   step1   start ");
		int ireturn = 1000;
		jg.setMensuu(otta_Men_zu.getMensuu());

		//山?ﾜり谷?ﾜりの?�ｱ�から決定される?繪ｺ関係を?繪ｺ表に入れる
		System.out.println("山?ﾜり谷?ﾜりの?�ｱ�から決定される?繪ｺ関係を?繪ｺ表に入れる");
		int Mid_min, Mid_max;
		for (int ib = 1; ib <= orite.getBousuu(); ib++) {
			Mid_min = orite.Bou_moti_Menid_min_motome(ib);
			Mid_max = orite.Bou_moti_Menid_max_motome(ib);
			if (Mid_min != Mid_max) {//展開?}において?A棒ibの両脇に面がある
				//if(orite.getcolor(ib)==1){//?ﾔい??で山?ﾜりを意味する
				if (otta_Men_zu.getcolor(ib) == 1) {//?ﾔい??で山?ﾜりを意味する
					if (orite.getiMeniti(Mid_min) % 2 == 1) {//面Mid_minは基??面と同じ向き(表面が?繧��?く)
						jg.set(Mid_min, Mid_max, 1);
						jg.set(Mid_max, Mid_min, 0);
					}
					if (orite.getiMeniti(Mid_max) % 2 == 1) {//面Mid_maxは基??面と同じ向き(表面が?繧��?く)
						jg.set(Mid_max, Mid_min, 1);
						jg.set(Mid_min, Mid_max, 0);
					}
				}
				//if(orite.getcolor(ib)==2){//?ﾂい??で谷?ﾜりを意味する
				if (otta_Men_zu.getcolor(ib) == 2) {//?ﾂい??で谷?ﾜりを意味する
					if (orite.getiMeniti(Mid_min) % 2 == 1) {//面Mid_minは基??面と同じ向き(表面が?繧��?く)
						jg.set(Mid_min, Mid_max, 0);
						jg.set(Mid_max, Mid_min, 1);
					}
					if (orite.getiMeniti(Mid_max) % 2 == 1) {//面Mid_maxは基??面と同じ向き(表面が?繧��?く)
						jg.set(Mid_max, Mid_min, 0);
						jg.set(Mid_min, Mid_max, 1);
					}
				}

				if ((orite.getiMeniti(Mid_min) % 2 == 0) && (orite.getiMeniti(Mid_max) % 2 == 0)) {
					ireturn = 0;
				}
				if ((orite.getiMeniti(Mid_min) % 2 == 1) && (orite.getiMeniti(Mid_max) % 2 == 1)) {
					ireturn = 0;
				}
			}
		}

		//----------------------------------------------
		orihime_ap.keijiban.tuiki("           Jyougehyou_settei   step2   start ");
		System.out.println("等価?��?を?ﾝ定する   ");
		//等価?��?を?ﾝ定する?B棒ibを境界として隣?ﾚする2つの面im1,im2が有る?????A?ﾜり?�み??定した???�に
		//棒ibの一部と?dなる位置に有る面imは面im1と面im2に?繪ｺ方向で挟まれることはない?Bこのことから
		//gj[im1][im]=gj[im2][im]という等価?��?が?ｬり立つ?B
		for (int ib = 1; ib <= orite.getBousuu(); ib++) {
			Mid_min = orite.Bou_moti_Menid_min_motome(ib);
			Mid_max = orite.Bou_moti_Menid_max_motome(ib);
			if (Mid_min != Mid_max) {//展開?}において?A棒ibの両脇に面がある
				for (int im = 1; im <= jg.getMensuu(); im++) {
					if ((im != Mid_min) && (im != Mid_max)) {
						if (otta_Men_zu.kantan_totu_naibu(ib, im) == 1) {
							//下の２つのifは暫定的な?????Bあとで置き換え予定
							if (otta_Men_zu.totu_naibu(0.5, ib, im) == 1) {
								if (otta_Men_zu.totu_naibu(-0.5, ib, im) == 1) {
									jg.addTouka_jyouken(im, Mid_min, im, Mid_max);
								}
							}
						}
					}
				}
			}
		}
		System.out.print("３面が関与する突き抜け?��?の???@???@");
		System.out.println(jg.getTouka_jyoukensuu());
		orihime_ap.keijiban.tuiki("           Jyougehyou_settei   step3   start ");
		//等価?��?の追加?B棒ibの境界として隣?ﾚする2つの面im1,im2が有り?A
		//また棒jbの境界として隣?ﾚする2つの面im3,im4が有り?Aibとjbが平?sで?A一部?dなる?????A?ﾜり?�み??定した???�に
		//棒ibの面と面jbの面がi,j,i,j?@または?@j,i,j,i?@と並ぶことはない?Bもしこれがおきたら?A
		//?ﾅ?奄ｩら3番目で間違いが起きているので?Aこの3番目のところがSmenで何桁目かを??めて?Aこの桁を１?iめる?B
		int mi1, mi2, mj1, mj2;

		for (int ib = 1; ib <= orite.getBousuu() - 1; ib++) {
			for (int jb = ib + 1; jb <= orite.getBousuu(); jb++) {
				if (otta_Men_zu.heikou_kasanai(ib, jb) == 1) {
					mi1 = orite.Bou_moti_Menid_min_motome(ib);
					mi2 = orite.Bou_moti_Menid_max_motome(ib);
					if (mi1 != mi2) {
						mj1 = orite.Bou_moti_Menid_min_motome(jb);
						mj2 = orite.Bou_moti_Menid_max_motome(jb);
						if (mj1 != mj2) {
							if (mi1 * mi2 * mj1 * mj2 != 0) {
								if (onaji_Smen_ni_sonzai(mi1, mi2, mj1, mj2) == 1) {
									jg.add_uTouka_jyouken(mi1, mi2, mj1, mj2);
								}
							}
						}
					}
				}
			}
		}
		System.out.print("４面が関与する突き抜け?��?の???@???@");
		System.out.println(jg.get_uTouka_jyoukensuu());
		//5154                      System.out.print("Smensuu = "); System.out.println(Smensuu);System.exit(0);

		orihime_ap.keijiban.tuiki("           Jyougehyou_settei   step4   start ");
		//追加??定
		int ituika;

		ituika = tuika_suitei();
		if (ituika != 1000) {
			return ituika;
		}

		System.out.println("追加??定 ?I了し?A?繪ｺ表を保存------------------------??????????????????????????????????????????");

		//*************?ﾅ?奄ﾉ?sう演繹的??論の結果の保存**************************
		jg.jg_hozon();//山?ﾜり谷?ﾜりの?�ｱ�から決定される?繪ｺ関係を保存しておく?B
		//************************************************************************
		orihime_ap.keijiban.tuiki("           Jyougehyou_settei   step5   start ");
//orihime_ap.keijiban.tuiki("00000           ");
		//Smen毎に案内?曹???る
		System.out.println("Smen毎に案内?曹???る");
		for (int i = 1; i <= Smensuu; i++) {
			//System.out.print("Smen");System.out.print(i);System.out.println("にて?B");
			s0[i].setAnnaisyo(jg);
		}

		//s0に優???�位をつける(このときjgの-100のところが変るところがある)
		System.out.println("Smen(s0)に優???�位をつける");
		//まず?A他のSmenに丸ごと含まれているSmenを?怺Oする

		int[] Smen_no_dokujisei = new int[Smensuu + 1];  //<<<<<<<<<<<<<<<Smenの独自?ｫ
		for (int i = 1; i <= Smensuu; i++) {
			Smen_no_dokujisei[i] = 1;
		}
		for (int i = 1; i <= Smensuu; i++) {
			Smen_no_dokujisei[i] = 1;
			for (int j = 1; j <= Smensuu; j++) {
				if (Smen_no_dokujisei[j] == 1) {

					if (i != j) {//s0[j]がs0[i]を含むかをみる?B
						if (Smen_i_ga_j_ni_fukumareru(i, j) == 1) {
							Smen_no_dokujisei[i] = 0;
							break;
						}
					}
				}
			}
		}


/*
		for(int i=1;i<=Smensuu;i++){
			System.out.print("Smen[s0]の独立?ｫ?@" );
			System.out.print(Smen_no_dokujisei[i]);
			System.out.print("?@:?@");
            		for(int j=1;j<=s0[i].getMenidsuu();j++){
				System.out.print(s0[i].getMenid(j));System.out.print(",");
			}
			System.out.println("");
		}
*/
//
		int[] i_yusendo_max = new int[Smensuu + 1];     //<<<<<<<<<<<<<<<臨時
		//5115                     System.out.print("Smensuu = "); System.out.println(Smensuu);System.exit(0);

		for (int i = 1; i <= Smensuu; i++) {//優?謫xi番目のSmenidをさがす?B
			int yusendo_max = -10000;//優?謫xi番目の優?謫xの値?i大きいほうが優?謫xが?ｂ｢?j?B
			int i_yusen = 0;

			for (int is0 = 1; is0 <= Smensuu; is0++) { //Smenを１からSmensuu番目までサ?[チ
				int Sy;//Smenid_yusendo(is0)+Smen_no_dokujisei[is0] を格納
				if (s0_no_yusenjyun[is0] == 0) {//まだ優???�位がついていないSmenだけを扱う
					Sy = Smenid_yusendo(is0)/*+Smen_no_dokujisei[is0]*/;//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
					if (yusendo_max < Sy) {
						yusendo_max = Sy;
						i_yusen = is0;// i_yusenがi番目の優?謫xを探している?ﾛの?ﾅも有力な候補の番??
					}
					if (yusendo_max == Sy) {
						if (s0[i_yusen].getMenidsuu() < s0[is0].getMenidsuu()) {
							yusendo_max = Sy;
							i_yusen = is0;
						}
					}
				}
			}

			s0_no_yusenjyun[i_yusen] = i; //優?謫xi番目のSmenidはi_yusen?B
			i_yusendo_max[i_yusen] = yusendo_max;//優?謫xi番目の優?謫xの値?i大きいほうが優?謫xが?ｂ｢?j?B
/*
			if(yusendo_max>0){
				System.out.print("優?謫x決め?@");System.out.print(i);System.out.print("番目の優?謫x ");
				System.out.println(yusendo_max);
			}
*/

			s0[i_yusen].jg_ni_Smen_no_tantoubasyo_wo_nyuuryoku(jg); //jgの-100のところを変る?B<<<<<<<<<<<<<<<<<<<<<<
		}

		//優?謫xからs0のidを指定できるようにする

		for (int i = 1; i <= Smensuu; i++) {
			for (int is0 = 1; is0 <= Smensuu; is0++) {
				if (i == s0_no_yusenjyun[is0]) {
					yusenjyun_kara_s0id[i] = is0;
				}
			}
		}


		//System.out.println("------------" );
		System.out.println("?繪ｺ表?E?l内?@Smensuu = " + Smensuu);
		System.out.println("?繪ｺ表?E?l内?@s0に優???�位をつける");
		for (int i = 1; i <= Smensuu; i++) {
			System.out.println(s0_no_yusenjyun[i]);
		}
		System.out.println("?繪ｺ表?E?l内?@優?謫xからs0のid");
		for (int i = 1; i <= Smensuu; i++) {
			System.out.println(yusenjyun_kara_s0id[i]);
		}


		for (int i = 1; i <= Smensuu; i++) {
			//System.out.println(yusenjyun_kara_s0id[i]);
			if (i_yusendo_max[yusenjyun_kara_s0id[i]] != 0) {
				Smen_yuukou_suu = i;       //??いが変な結果になることあり?B
//20191012 wwwww				Smen_yuukou_suu=Smensuu;//遅いが確実

				//System.out.print("第");
				//System.out.print(i);
				//System.out.print("位(未定ペア????");
				//System.out.print(i_yusendo_max[yusenjyun_kara_s0id[i]]);

				//System.out.print("?@||?@");
			}
		}


//20191012 				Smen_yuukou_suu=Smensuu;//遅いが確実//20191012


		//System.out.println();
		//

		for (int i = 1; i <= Smensuu; i++) {
			s[i] = s0[yusenjyun_kara_s0id[i]];
		}

		//優???�位を逆転させる?Bこれが有効かどうかは不明wwwww
		//for(int i=1;i<=Smen_yuukou_suu;i++){s[Smen_yuukou_suu-i+1]=s0[yusenjyun_kara_s0id[i]];}

/*
		for(int i=1;i<=Smensuu;i++){
                       if(i_yusendo_max[yusenjyun_kara_s0id[i]]!=0){
				System.out.print("第");
				System.out.print(i);
				System.out.print("位(未定ペア????");
				System.out.print(i_yusendo_max[yusenjyun_kara_s0id[i]]);
				System.out.print("?A面????");
				System.out.print(s[i].getMenidsuu());
				System.out.print("?@||?@");
			}
		}

		System.out.println();
*/

		//Smenは優???�の何番目までやるかを決める
/*
		for(int i=1;i<=Smensuu;i++){
	  		if(s[i].getMenidsuu()>=1){
				Smen_yuukou_suu=i; ;
			}
		}
		Smen_yuukou_suu=Smensuu;   //<<<<<<<<<<<<<<<<<<<<<<<
*/
		System.out.print("Smen有効?狽ﾍ?@");
		System.out.print(Smen_yuukou_suu);
		System.out.print("?^");
		System.out.println(Smensuu);


		//jg.jg_hozon();//山?ﾜり谷?ﾜりの?�ｱ�から決定される?繪ｺ関係を保存しておく?B


		//jg[][]の?dなりのある面の組み?���椹の位置の値を-100から-50に変える?B
		for (int k = 1; k <= Smensuu; k++) {
			for (int i = 1; i <= s[k].getMenidsuu() - 1; i++) {
				for (int j = i + 1; j <= s[k].getMenidsuu(); j++) {
					jg.set(i, j, -50);
					jg.set(j, i, -50);
				}
			}
		}


		System.out.println("?繪ｺ表?炎??ﾝ定?I了");


//		jg.jg_hozon();//山?ﾜり谷?ﾜりの?�ｱ�から決定される?繪ｺ関係を保存しておく?B

		//System.out.print("面?狽ﾍ1?@");  System.out.println(s[1].getMenidsuu());
		return ireturn;
	}

	//------------------------------------------------------------
	public int tuika_suitei() {
		//山?ﾜり谷?ﾜりの?�ｱ�から?Xに決定できる関係を?яｪしていく?B

		int Mid;//3面の比較で中間にくる面
		int flg_c = 1;
		System.out.println("追加??定開始---------------------????????????????????????????????????????????");

		while (flg_c >= 1) {
			flg_c = 0;
			System.out.println("追加??定------------------------");
			//System.out.println("山?ﾜり谷?ﾜりの?�ｱ�から追加??定   " );

			int flg_b = 1;
			while (flg_b >= 1) {
				flg_b = 0;

				for (int iS = 1; iS <= Smensuu; iS++) {

					int flg_a = 1;
					while (flg_a >= 1) {
						flg_a = 0;
						for (int iM = 1; iM <= s0[iS].getMenidsuu(); iM++) {//3面の比較で中間にくる面
							int[] ueMenid = new int[s0[iS].getMenidsuu() + 1];//S面に含まれるあるMenの?繧ｪわにあるid番??を記録する?Bこれが20ということは?A
							int[] sitaMenid = new int[s0[iS].getMenidsuu() + 1];//S面に含まれるあるMenの下がわにあるid番??を記録する?Bこれが20ということは?A
							int ueMenid_max = 0;
							int sitaMenid_max = 0;
							Mid = s0[iS].getMenid(iM);

							//?lえ方?FあるSmenのある面Midについて?lえる?B
							//このSmen以外で面Aは面Midの?繿､?A面Bは面Midの下側と決まっていたとする?B
							//一般に別?XのSmenで?A面Aは面Midの?繿､で?A面Bは面Midの下側だったからと言って?A面Aは面Bの?繿､とは決定できない?B
							//しかし?Aここがポイントだが?A面A?A面Mid?A面Bがいっしょに含まれているSmenがあるなら?AそのSmenの?繪ｺ関係がわかっていなくても
							//面Aは面Bの?繿､となる?Bだから?Aこの操??ではあるSmenから得る?�ｱ�は３つの面がいっしょにあるかということである?B
							//あるSmen内の?繪ｺ関係は必要ない?B
							//
							//ここの操??はあるSmenの?繪ｺ関係を?繪ｺ表から?ﾌ?Wしている?B
							for (int i = 1; i <= s0[iS].getMenidsuu(); i++) {//Menid[iM]より?繧ﾉある面?B
								if (iM != i) {
									if (jg.get(Mid, s0[iS].getMenid(i)) == 0) {
										ueMenid_max = ueMenid_max + 1;
										ueMenid[ueMenid_max] = s0[iS].getMenid(i);
									}
									if (jg.get(Mid, s0[iS].getMenid(i)) == 1) {
										sitaMenid_max = sitaMenid_max + 1;
										sitaMenid[sitaMenid_max] = s0[iS].getMenid(i);
									}
								}
							}

							//  System.out.print("VVVVVVVVVVVueMenid_max:sitaMenid_max = ");System.out.print(ueMenid_max);
							//  System.out.print(":");System.out.println(sitaMenid_max);
							//
							for (int iuM = 1; iuM <= ueMenid_max; iuM++) {//Menid[iM]より?繧ﾉある面?B
								for (int isM = 1; isM <= sitaMenid_max; isM++) {//Menid[iM]より下にある面?B

									//  System.out.print(ueMenid[iuM]);System.out.print("<-??:下->");System.out.println(sitaMenid[isM]);


									if (jg.get(ueMenid[iuM], sitaMenid[isM]) == 0) {
										errorPos = new Touka_jyouken(sitaMenid[isM], ueMenid[iuM], sitaMenid[isM], ueMenid[iuM]);
										return 2;
									}//面の?繪ｺ関係の拡張で矛?ｔｭ?ｶ?B
									if (jg.get(sitaMenid[isM], ueMenid[iuM]) == 1) {
										errorPos = new Touka_jyouken(sitaMenid[isM], ueMenid[iuM], sitaMenid[isM], ueMenid[iuM]);
										return 2;
									}//面の?繪ｺ関係の拡張で矛?ｔｭ?ｶ?B

									if (jg.get(ueMenid[iuM], sitaMenid[isM]) < 0) {
										jg.set(ueMenid[iuM], sitaMenid[isM], 1);
										flg_a = flg_a + 1;
										flg_b = flg_b + 1;
										flg_c = flg_c + 1;
									}
									if (jg.get(sitaMenid[isM], ueMenid[iuM]) < 0) {
										jg.set(sitaMenid[isM], ueMenid[iuM], 0);
										flg_a = flg_a + 1;
										flg_b = flg_b + 1;
										flg_c = flg_c + 1;
									}
									//   System.out.print("AAAAAAAAAAAflg_a:");System.out.println(flg_a);
								}
							}
						}
					}


				}

				//System.out.print("?яｪされた関係の?? ?? ");System.out.println(flg_b);
			}

			//
			//jg.jg_hozon();//山?ﾜり谷?ﾜりの?�ｱ�から決定される?繪ｺ関係を保存しておく?B


			//jg のreset適?ﾘに?sわれているか確認のこと

			//System.out.println ("３面が関与する突き抜け?��?から追加??定   " );
			//jg.addTouka_jyouken(im,Mid_min,im,Mid_max)qqqqqqqqqqqq
			//(im,Mid_min,im,Mid_max);
			Touka_jyouken tg = new Touka_jyouken();

			int flg_a = 1;
			while (flg_a >= 1) {
				flg_a = 0;
				for (int i = 1; i <= jg.getTouka_jyoukensuu(); i++) {
					tg = jg.getTouka_jyouken(i);
					//if(onaji_Smen_ni_sonzai(tg.geta(),tg.getb(),tg.getd())==1) {
					if (jg.get(tg.geta(), tg.getb()) == 1) {
						if (jg.get(tg.geta(), tg.getd()) == 0) {
							errorPos = tg;
							return 3;
						}
						if (jg.get(tg.getd(), tg.geta()) == 1) {
							errorPos = tg;
							return 3;
						}
						if (jg.get(tg.geta(), tg.getd()) < 0) {
							jg.set(tg.geta(), tg.getd(), 1);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(tg.getd(), tg.geta()) < 0) {
							jg.set(tg.getd(), tg.geta(), 0);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
					}
					if (jg.get(tg.geta(), tg.getb()) == 0) {
						if (jg.get(tg.geta(), tg.getd()) == 1) {
							errorPos = tg;
							return 3;
						}
						if (jg.get(tg.getd(), tg.geta()) == 0) {
							errorPos = tg;
							return 3;
						}
						if (jg.get(tg.geta(), tg.getd()) < 0) {
							jg.set(tg.geta(), tg.getd(), 0);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(tg.getd(), tg.geta()) < 0) {
							jg.set(tg.getd(), tg.geta(), 1);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
					}
					//
					if (jg.get(tg.geta(), tg.getd()) == 1) {
						if (jg.get(tg.geta(), tg.getb()) == 0) {
							errorPos = tg;
							return 3;
						}
						if (jg.get(tg.getb(), tg.geta()) == 1) {
							errorPos = tg;
							return 3;
						}
						if (jg.get(tg.geta(), tg.getb()) < 0) {
							jg.set(tg.geta(), tg.getb(), 1);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(tg.getb(), tg.geta()) < 0) {
							jg.set(tg.getb(), tg.geta(), 0);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
					}
					if (jg.get(tg.geta(), tg.getd()) == 0) {
						if (jg.get(tg.geta(), tg.getb()) == 1) {
							errorPos = tg;
							return 3;
						}
						if (jg.get(tg.getb(), tg.geta()) == 0) {
							errorPos = tg;
							return 3;
						}
						if (jg.get(tg.geta(), tg.getb()) < 0) {
							jg.set(tg.geta(), tg.getb(), 0);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(tg.getb(), tg.geta()) < 0) {
							jg.set(tg.getb(), tg.geta(), 1);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
					}
					// }
				}
				//System.out.print("?яｪされた関係の?狽ﾍ ?? ");System.out.println(flg_a);
			}

			//----------------

//	System.out.println ("４面が関与する突き抜け?��?から追加??定   " );
			//jg.addTouka_jyouken(im,Mid_min,im,Mid_max)qqqqqqqqqqqq
			//(im,Mid_min,im,Mid_max);
			//Touka_jyouken tg = new Touka_jyouken();

			flg_a = 1;
			while (flg_a >= 1) {
				flg_a = 0;
				for (int i = 1; i <= jg.get_uTouka_jyoukensuu(); i++) {
					tg = jg.get_uTouka_jyouken(i);
					int a, b, c, d;
					a = tg.geta();
					b = tg.getb();
					c = tg.getc();
					d = tg.getd();


					//?@a>b>c?@だけならdの位置は決まらない


					//?@a>c && b>d なら a>d && b>c
					//  a>d && b>c なら a>c && b>d
					//?@a<c && b<d なら a<d && b<c
					//  a<d && b<c なら a<c && b<d


					//?@a>c>b?@なら?@a>d>b

					//a>c && b>d なら a>d && b>c
					if ((jg.get(a, c) == 1) && (jg.get(b, d) == 1)) {
						if (jg.get(a, d) == 0) {
							errorPos = tg;
							return 4;
						}
						if (jg.get(b, c) == 0) {
							errorPos = tg;
							return 4;
						}
						if (jg.get(a, d) < 0) {
							jg.set(a, d, 1);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(b, c) < 0) {
							jg.set(b, c, 1);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(d, a) < 0) {
							jg.set(d, a, 0);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(c, b) < 0) {
							jg.set(c, b, 0);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
					}
					//a>d && b>c なら a>c && b>d
					if ((jg.get(a, d) == 1) && (jg.get(b, c) == 1)) {
						if (jg.get(a, c) == 0) {
							errorPos = tg;
							return 4;
						}
						if (jg.get(b, d) == 0) {
							errorPos = tg;
							return 4;
						}
						if (jg.get(a, c) < 0) {
							jg.set(a, c, 1);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(b, d) < 0) {
							jg.set(b, d, 1);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(c, a) < 0) {
							jg.set(c, a, 0);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(d, b) < 0) {
							jg.set(d, b, 0);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
					}

					//a<c && b<d なら a<d && b<c
					if ((jg.get(a, c) == 0) && (jg.get(b, d) == 0)) {
						if (jg.get(a, d) == 1) {
							errorPos = tg;
							return 4;
						}
						if (jg.get(b, c) == 1) {
							errorPos = tg;
							return 4;
						}
						if (jg.get(a, d) < 0) {
							jg.set(a, d, 0);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(b, c) < 0) {
							jg.set(b, c, 0);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(d, a) < 0) {
							jg.set(d, a, 1);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(c, b) < 0) {
							jg.set(c, b, 1);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
					}
					//a<d && b<c なら a<c && b<d
					if ((jg.get(a, d) == 0) && (jg.get(b, c) == 0)) {
						if (jg.get(a, c) == 1) {
							errorPos = tg;
							return 4;
						}
						if (jg.get(b, d) == 1) {
							errorPos = tg;
							return 4;
						}
						if (jg.get(a, c) < 0) {
							jg.set(a, c, 0);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(b, d) < 0) {
							jg.set(b, d, 0);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(c, a) < 0) {
							jg.set(c, a, 1);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(d, b) < 0) {
							jg.set(d, b, 1);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
					}


					//?@a>c>b?@なら?@a>d>b
					if ((jg.get(a, c) == 1) && (jg.get(c, b) == 1)) {
						if (jg.get(d, a) == 1) {
							errorPos = tg;
							return 4;
						}
						if (jg.get(b, d) == 1) {
							errorPos = tg;
							return 4;
						}
						if (jg.get(a, d) < 0) {
							jg.set(a, d, 1);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(d, b) < 0) {
							jg.set(d, b, 1);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(d, a) < 0) {
							jg.set(d, a, 0);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(b, d) < 0) {
							jg.set(b, d, 0);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
					}
					//?@a>d>b?@なら?@a>c>b
					if ((jg.get(a, d) == 1) && (jg.get(d, b) == 1)) {
						if (jg.get(c, a) == 1) {
							errorPos = tg;
							return 4;
						}
						if (jg.get(b, c) == 1) {
							errorPos = tg;
							return 4;
						}
						if (jg.get(a, c) < 0) {
							jg.set(a, c, 1);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(c, b) < 0) {
							jg.set(c, b, 1);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(c, a) < 0) {
							jg.set(c, a, 0);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(b, c) < 0) {
							jg.set(b, c, 0);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
					}
					//?@b>c>a?@なら?@b>d>a
					if ((jg.get(b, c) == 1) && (jg.get(c, a) == 1)) {
						if (jg.get(d, b) == 1) {
							errorPos = tg;
							return 4;
						}
						if (jg.get(a, d) == 1) {
							errorPos = tg;
							return 4;
						}
						if (jg.get(b, d) < 0) {
							jg.set(b, d, 1);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(d, a) < 0) {
							jg.set(d, a, 1);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(d, b) < 0) {
							jg.set(d, b, 0);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(a, d) < 0) {
							jg.set(a, d, 0);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
					}
					//?@b>d>a?@なら?@b>c>a
					if ((jg.get(b, d) == 1) && (jg.get(d, a) == 1)) {
						if (jg.get(c, b) == 1) {
							errorPos = tg;
							return 4;
						}
						if (jg.get(a, c) == 1) {
							errorPos = tg;
							return 4;
						}
						if (jg.get(b, c) < 0) {
							jg.set(b, c, 1);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(c, a) < 0) {
							jg.set(c, a, 1);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(c, b) < 0) {
							jg.set(c, b, 0);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(a, c) < 0) {
							jg.set(a, c, 0);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
					}


					//?@c>a>d?@なら?@c>b>d
					if ((jg.get(c, a) == 1) && (jg.get(a, d) == 1)) {
						if (jg.get(b, c) == 1) {
							errorPos = tg;
							return 4;
						}
						if (jg.get(d, b) == 1) {
							errorPos = tg;
							return 4;
						}
						if (jg.get(c, b) < 0) {
							jg.set(c, b, 1);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(b, d) < 0) {
							jg.set(b, d, 1);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(b, c) < 0) {
							jg.set(b, c, 0);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(d, b) < 0) {
							jg.set(d, b, 0);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
					}
					//?@c>b>d?@なら?@c>a>d
					if ((jg.get(c, b) == 1) && (jg.get(b, d) == 1)) {
						if (jg.get(a, c) == 1) {
							errorPos = tg;
							return 4;
						}
						if (jg.get(d, a) == 1) {
							errorPos = tg;
							return 4;
						}
						if (jg.get(c, a) < 0) {
							jg.set(c, a, 1);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(a, d) < 0) {
							jg.set(a, d, 1);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(a, c) < 0) {
							jg.set(a, c, 0);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(d, a) < 0) {
							jg.set(d, a, 0);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
					}
					//?@d>a>c?@なら?@d>b>c
					if ((jg.get(d, a) == 1) && (jg.get(a, c) == 1)) {
						if (jg.get(b, d) == 1) {
							errorPos = tg;
							return 4;
						}
						if (jg.get(c, b) == 1) {
							errorPos = tg;
							return 4;
						}
						if (jg.get(d, b) < 0) {
							jg.set(d, b, 1);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(b, c) < 0) {
							jg.set(b, c, 1);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(b, d) < 0) {
							jg.set(b, d, 0);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(c, b) < 0) {
							jg.set(c, b, 0);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
					}
					//?@d>b>c?@なら?@d>a>c
					if ((jg.get(d, b) == 1) && (jg.get(b, c) == 1)) {
						if (jg.get(a, d) == 1) {
							errorPos = tg;
							return 4;
						}
						if (jg.get(c, a) == 1) {
							errorPos = tg;
							return 4;
						}
						if (jg.get(d, a) < 0) {
							jg.set(d, a, 1);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(a, c) < 0) {
							jg.set(a, c, 1);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(a, d) < 0) {
							jg.set(a, d, 0);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
						if (jg.get(c, a) < 0) {
							jg.set(c, a, 0);
							flg_a = flg_a + 1;
							flg_c = flg_c + 1;
						}
					}


					// }
				}
				//System.out.print("?яｪされた関係の?狽ﾍ ?? ");System.out.println(flg_a);
			}

			//----------------

			System.out.print("?яｪされた関係の?狽ﾌ?�計 ?? ");
			System.out.println(flg_c);

		}


		System.out.println("追加??定 ?I了------------------------???????魔ｱこまで20150310??????????????????????");

		return 1000;

	}

	//------------------------------------------

	private int tuika_suitei_2() {
		//山?ﾜり谷?ﾜりの?�ｱ�から?Xに決定できる関係を?яｪしていく?B

		int Mid;//3面の比較で中間にくる面
		int flg_c = 1;
		System.out.println("追加??定開始---------------------????????????????????????????????????????????");

		while (flg_c >= 1) {
			flg_c = 0;
			System.out.println("追加??定------------------------");
			//System.out.println("山?ﾜり谷?ﾜりの?�ｱ�から追加??定   " );

			int flg_b = 1;
			while (flg_b >= 1) {
				flg_b = 0;

				for (int iS = 1; iS <= Smensuu; iS++) {

					int flg_a = 1;
					while (flg_a >= 1) {
						flg_a = 0;
						for (int iM = 1; iM <= s0[iS].getMenidsuu(); iM++) {//3面の比較で中間にくる面
							int[] ueMenid = new int[s0[iS].getMenidsuu() + 1];//S面に含まれるあるMenの?繧ｪわにあるid番??を記録する?Bこれが20ということは?A
							int[] sitaMenid = new int[s0[iS].getMenidsuu() + 1];//S面に含まれるあるMenの下がわにあるid番??を記録する?Bこれが20ということは?A
							int ueMenid_max = 0;
							int sitaMenid_max = 0;
							Mid = s0[iS].getMenid(iM);

							//?lえ方?FあるSmenのある面Midについて?lえる?B
							//このSmen以外で面Aは面Midの?繿､?A面Bは面Midの下側と決まっていたとする?B
							//一般に別?XのSmenで?A面Aは面Midの?繿､で?A面Bは面Midの下側だったからと言って?A面Aは面Bの?繿､とは決定できない?B
							//しかし?Aここがポイントだが?A面A?A面Mid?A面Bがいっしょに含まれているSmenがあるなら?AそのSmenの?繪ｺ関係がわかっていなくても
							//面Aは面Bの?繿､となる?Bだから?Aこの操??ではあるSmenから得る?�ｱ�は３つの面がいっしょにあるかということである?B
							//あるSmen内の?繪ｺ関係は必要ない?B
							//
							//ここの操??はあるSmenの?繪ｺ関係を?繪ｺ表から?ﾌ?Wしている?B
							for (int i = 1; i <= s0[iS].getMenidsuu(); i++) {//Menid[iM]より?繧ﾉある面?B
								if (iM != i) {
									if (jg.get(Mid, s0[iS].getMenid(i)) == 0) {
										ueMenid_max = ueMenid_max + 1;
										ueMenid[ueMenid_max] = s0[iS].getMenid(i);
									}
									if (jg.get(Mid, s0[iS].getMenid(i)) == 1) {
										sitaMenid_max = sitaMenid_max + 1;
										sitaMenid[sitaMenid_max] = s0[iS].getMenid(i);
									}
								}
							}

							//  System.out.print("VVVVVVVVVVVueMenid_max:sitaMenid_max = ");System.out.print(ueMenid_max);
							//  System.out.print(":");System.out.println(sitaMenid_max);
							//
							for (int iuM = 1; iuM <= ueMenid_max; iuM++) {//Menid[iM]より?繧ﾉある面?B
								for (int isM = 1; isM <= sitaMenid_max; isM++) {//Menid[iM]より下にある面?B

									/**/      //  System.out.print(ueMenid[iuM]);System.out.print("<-??:下->");System.out.println(sitaMenid[isM]);


									if (jg.get(ueMenid[iuM], sitaMenid[isM]) == 0) {
										return 2;
									}//面の?繪ｺ関係の拡張で矛?ｔｭ?ｶ?B
									if (jg.get(sitaMenid[isM], ueMenid[iuM]) == 1) {
										return 2;
									}//面の?繪ｺ関係の拡張で矛?ｔｭ?ｶ?B

									if (jg.get(ueMenid[iuM], sitaMenid[isM]) < 0) {
										jg.set(ueMenid[iuM], sitaMenid[isM], 1);
										flg_a = flg_a + 1;
										flg_b = flg_b + 1;
										flg_c = flg_c + 1;
									}
									if (jg.get(sitaMenid[isM], ueMenid[iuM]) < 0) {
										jg.set(sitaMenid[isM], ueMenid[iuM], 0);
										flg_a = flg_a + 1;
										flg_b = flg_b + 1;
										flg_c = flg_c + 1;
									}
									//   System.out.print("AAAAAAAAAAAflg_a:");System.out.println(flg_a);
								}
							}
						}
					}
				}


			}

			//System.out.print("?яｪされた関係の?? ?? ");System.out.println(flg_b);
		}


		System.out.println("追加??定 ?I了------------------------??????????????????????????????????????????");

		return 1000;

	}


	//-----------------------------------------------------------------------------------------

	private int Smen_i_ga_j_ni_fukumareru(int s0i, int s0j) { //含まれるなら１?Aないなら０
		if (s0[s0i].getMenidsuu() > s0[s0j].getMenidsuu()) {
			return 0;
		}


		for (int i = 1; i <= s0[s0i].getMenidsuu(); i++) {
			for (int j = 1; j <= s0[s0j].getMenidsuu(); j++) {
				if (s0[s0i].getMenid(i) == s0[s0j].getMenid(j)) {
					break;
				}
				if (j == s0[s0j].getMenidsuu()) {
					return 0;
				}
			}
		}

		return 1;

	}

	//s0(Smen)の優?謫xを示す値を??める?Bこの値が?ｂ｢ほうが優?謫xが???i配列の?謫ｪに近い?B?j
	int Smenid_yusendo(int s0id) {
		//return s0[s0id].getMenidsuu();

		//現?ﾝの?繪ｺ表にSmenを入れたら何個の?繪ｺ関係が?Vたに登録されるかを調べる?B
		return s0[s0id].sinki_jyouhou_suu(jg);


	}

	//-----------
	//------------------------
	//引?狽ﾌ３つの面を同時に含むSmenが1つ以?繿ｶ?ﾝするなら１?Aしないなら０を返す?B
	private int onaji_Smen_ni_sonzai(int im1, int im2, int im3) {
		for (int i = 1; i <= Smensuu; i++) {
			if (s[i].Menid2Jyunretuketa(im1) >= 1) {
				if (s[i].Menid2Jyunretuketa(im2) >= 1) {
					if (s[i].Menid2Jyunretuketa(im3) >= 1) {

						return 1;
					}
				}
			}

		}
		return 0;

	}


	//------------------------
	//引?狽ﾌ４つの面を同時に含むSmenが1つ以?繿ｶ?ﾝするなら１?Aしないなら０を返す?B
	private int onaji_Smen_ni_sonzai(int im1, int im2, int im3, int im4) {
		for (int i = 1; i <= Smensuu; i++) {
			if (s[i].Menid2Jyunretuketa(im1) >= 1) {
				if (s[i].Menid2Jyunretuketa(im2) >= 1) {
					if (s[i].Menid2Jyunretuketa(im3) >= 1) {
						if (s[i].Menid2Jyunretuketa(im4) >= 1) {
							return 1;
						}
					}
				}
			}
		}
		return 0;

	}


	//?@ここは  class Jyougehyou_Syokunin  の中です?B


	//Smenの面の?dなり?�態を次の?�態にする?B
	//もし現?ﾝの面の?dなり?�態が?A?ﾅ後のものだったら0をreturnして?A面の?dなり?�態は?ﾅ?奄ﾌものに戻る?B
	//zzzzzzzz

	public int susumu(int ss) {
		int isusumu;//=0の???�Smenが変わる?i桁が変るようなイ???[ジ?j?B
		int Sid;//変化が及んだSmenのid番??
		isusumu = 0;
		//ss+1番目以?繧ﾌSmenはみな?炎�値にする?BSmenに含まれる面?狽ｪ0のときはエラ?[になる?B
//System.out.println("    js.susumu 001      ss+1番目以?繧ﾌSmenはみな?炎�値にする?B");

		for (int i = ss + 1; i <= Smensuu; i++) {

//System.out.println("    js.susumu i= "+i+"        Smensuu= "+Smensuu);

			s[i].Jyunretu_1banme();
		}
//System.out.println("    js.susumu 002      ss+1番目以?繧ﾌSmenはみな?炎�値にする?B");
		//Smenのid番??の大きいものから?ｬさいものの?�に面の?dなり?�態を変えていく?B
		Sid = ss;
		//isusumu =s[ss].susumu(s);
		for (int i = ss; i >= 1; i--) {
			if (isusumu == 0) {
				isusumu = s[i].susumu(s[i].getMenidsuu());
				Sid = i;
			}

		}
		if (isusumu == 0) {
			Sid = 0;
		}

		return Sid;
	}


	/*
public int yuukouk_Smen_susumu(){//yuukoなSmen?狽ｾけ桁が変わる
		int isusumu;//=0の???�Smenが変わる?i桁が変るようなイ???[ジ?j?B
		int Sid;//変化が及んだSmenのid番??
		isusumu =0;
int ss; ss=getSmen_yuukou_suu();
	//ss+1番目以?繧ﾌSmenはみな?炎�値にする?B有効?蝿ﾈ?繧ﾍ使わないので?A何もしないことにする?B
//System.out.println("    js.susumu 001      ss+1番目以?繧ﾌSmenはみな?炎�値にする?B");

		//for(int i=ss+1;i<=Smensuu;i++){

//System.out.println("    js.susumu i= "+i+"        Smensuu= "+Smensuu);

		 // s[i].Jyunretu_1banme();
		//}
//System.out.println("    js.susumu 002      ss+1番目以?繧ﾌSmenはみな?炎�値にする?B");
		  //Smenのid番??の大きいものから?ｬさいものの?�に面の?dなり?�態を変えていく?B
                Sid=ss;
		//isusumu =s[ss].susumu(s);
		for(int i=ss;i>=1;i--){
			if(isusumu == 0){isusumu=s[i].susumu(s[i].getMenidsuu());Sid=i;}

		}
		if (isusumu==0){Sid=0;}

		return Sid;
	}


*/
//---------------------------------------------------------------------------------------------------------------------------------------------
	public String Jyunretu_count() {
		String s0 = "";

		for (int ss = 1; ss <= Smen_yuukou_suu; ss++) {
			s0 = s0 + " : " + s[ss].get_Jyunretu_count();
		}
		return s0;
	}

	//---------------------------------------------------------------------------------------------------------------------------------------------
	public String Jyunretu_count(int imax) {
		String s0 = "";

		for (int ss = 1; ss <= imax; ss++) {
			s0 = s0 + " : " + s[ss].get_Jyunretu_count();
		}
		return s0;
	}

	//---------------------------------------------------------------------------------------------------------------------------------------------
	public int kanou_kasanari_sagasi_new() {

//System.out.println(" Jyougehyou_syokunin          kanou_kasanari_sagasi()   ");
//System.out.print("Smen有効??/Smensuu?@" );System.out.print(Smen_yuukou_suu );System.out.print("?^");System.out.println(Smensuu );
		if (Smen_yuukou_suu == 0) {
			return 1000;
		}//Smen_yuukou_suu==0ということは?A?繪ｺ表に?Vたな?�ｱ�を加えるSmenがないということ?Bすなわち?A?繪ｺ表がすべて埋まっているということを示すため?Aこれ以?繧ﾌ?dなり??定は不要?B


		return kanou_kasanari_sagasi_self(1);
	}

	//---------------------------------------------------------------------------------------------------------------------------------------------
	public int kanou_kasanari_sagasi_self(int ss) {
		//orihime_ap.keijiban.tuiki("ss = "+ss  +"  :  Smen_yuukou_suu = "+Smen_yuukou_suu );
		//?ﾅ?I桁での????
		if (ss == Smen_yuukou_suu) {

			if (s[ss].kanou_kasanari_sagasi(jg) == 1000) {//==0ということは?A可能な?dなりかたとなる?∠�は存?ﾝしない?B?@==1000?@このSmenは?A矛?ｂﾍない?�態になっている?B
				return 100;//?ﾜり?�み可能な?∠�組み?���椹が見つかった?B
			} else {
				return 0;
			}

		}


		//?ﾅ?I桁以外での????
		if (s[ss].kanou_kasanari_sagasi(jg) == 1000) {//==0ということは?A可能な?dなりかたとなる?∠�は存?ﾝしない?B?@==1000?@このSmenは?A矛?ｂﾍない?�態になっている?B


			while (kanou_kasanari_sagasi_self(ss + 1) == 0) {//次の桁で可能な?dなりかたとなる?∠�は存?ﾝしない
				if (s[ss].susumu() == 0) {
					return 0;
				}//この桁では?iめない?i?Vたな?∠�は無い?j

			}

			return 1000;//?ﾜり?�み可能な?∠�組み?���椹が見つかった?B

		}

		return 0;


		//for(int ss=1;ss<=Smen_yuukou_suu;ss++){      //<<<<<<<<<<<<<<?ｑｬ化のため変?X?B070417
		//        s[ss].jg_ni_Smen_wo_nyuuryoku(jg);//ss番目のSmenの?繪ｺ?�ｱ�をjgに入力する?B
		//  }
// return 100;

	}


	public int susumu_new() {
		return 0;
	}
//------------------------------------------------------------------------------------------------------

	//現?ﾝの?∠??�態から開始して?A可能な?dなりかたとなる?�態を探す?Bなお?Aここは?ｑｬ化の余地がある?B
	public int kanou_kasanari_sagasi() {      //これはjgを変えないはず?B
		orihime_ap.keijiban.tuiki("_ _______");
		orihime_ap.keijiban.tuiki("__ ______");
		orihime_ap.keijiban.tuiki("___ _____");
		orihime_ap.keijiban.tuiki("____ ____");
		int ms, Sid;
		ms = 0;

		//System.out.print("面?狽ﾍ2?@");  System.out.println(s[1].getMenidsuu());

		Sid = 1;//Sidの?炎�値は0以外ならなんでもいい?B
		while (Sid != 0) { //Sid==0なら?ASmenの?ﾅも番??の?ｬさいものまで調べ?sくしたという意味?B

			ms = mujyun_Smen_motome();
			if (ms == 1000) {
				return 1000;
			}//全てのSmenで?A矛?ｂﾍない?B
			Sid = susumu(ms - 1);
			orihime_ap.keijiban.kakikae(9, "susumu(" + ms + "-1 = )" + Sid);
		}
		return 0;//可能な?dなりかたとなる?�態は存?ﾝしない
	}

	//-----------------------------------------------------------------------------------------------------------------
	//?ﾜり?dなり方が矛?ｂｷるSmenを番??の?ｬさい?�からさがす?B  なお?Aここも?ｑｬ化の余地がある?B
	private int mujyun_Smen_motome() { //jgは変化する?B

		//orihime_ap.keijiban.kakikae(9,"mujyun_Smen_motome()");
		int kks;
		jg.jg_fukugen();//<<<<<<<<<<<<<<<<<<<<<<<<<<<,,

		for (int ss = 1; ss <= Smen_yuukou_suu; ss++) {      //<<<<<<<<<<<<<<?ｑｬ化のため変?X?B070417

			orihime_ap.keijiban.kakikae(7, "mujyun_Smen_motome( " + ss + ") , Menidsuu = " + s[ss].getMenidsuu() + " , Men_pair_suu = " + s[ss].getMenidsuu() * (s[ss].getMenidsuu() - 1) / 2);
			orihime_ap.keijiban.kakikae(8, " kasanari_bunryi_mitei = " + s[ss].kasanari_bunryi_mitei(jg));
			orihime_ap.keijiban.kakikae(9, " kasanari_bunryi_ketteizumi = " + s[ss].kasanari_bunryi_ketteizumi(jg));


			kks = s[ss].kanou_kasanari_sagasi(jg);
			orihime_ap.keijiban.kakikae(10, Jyunretu_count(ss));


			if (kks == 0) {//kks==0ということは?A可能な?dなりかたとなる?∠�は存?ﾝしない

				return ss;
			}
			s[ss].jg_ni_Smen_wo_nyuuryoku(jg);//ss番目のSmenの?繪ｺ?�ｱ�をjgに入力する?B


		}

		if (tuika_suitei() != 1000) {
			return Smen_yuukou_suu;
		} //ttttttttttt

		return 1000;
	}

// ---------------------------------------------------------------

	//?@ここは  class Jyougehyou_Syokunin  の中です?B
	//-----------------------------------------------------
	public void set_hyouji_yousiki(int i) {
		hyouji_yousiki = i;
	}


	//?}をかく?ﾛの?白l変換用関??-----------------------------------------------------------------

	private int gx(double d) {
		//if(ip1==1){return (int)(-d+2.0*700.0);} //裏側表示   <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		//if(ip1==1){return (int)(-d);} //裏側表示   <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		// if(ip1==0){return (int)d;} //表側表示
		return (int) d; //表側表示
	}

	private int gy(double d) {
		return (int) d;
	}

	//---------------------------------------------------------
	//---------------------------------------------------------


	Color F_color = new Color(255, 255, 50);//表面の?F
	Color B_color = new Color(233, 233, 233);//裏面の?F
	Color L_color = Color.black;//??の?F

	public void set_F_color(Color color0) {
		F_color = color0;
	}

	public void set_B_color(Color color0) {
		B_color = color0;
	}

	public void set_L_color(Color color0) {
		L_color = color0;
	}

	public Color get_F_color() {
		return F_color;
	}

	public Color get_B_color() {
		return B_color;
	}

	public Color get_L_color() {
		return L_color;
	}


	int i_anti_alias = 1;
	double senhaba_for_anti_alias = 1.2;

	//---------------------------------------------------------


	public void set_i_anti_alias(int i) {
		i_anti_alias = i;
	}

	public void change_i_anti_alias() {

		i_anti_alias = i_anti_alias + 1;
		if (i_anti_alias >= 2) {
			i_anti_alias = 0;
		}

		if (i_anti_alias == 0) {
			senhaba_for_anti_alias = 1.0;
		}
		if (i_anti_alias == 1) {
			senhaba_for_anti_alias = 1.2;
		}

	}


	public void oekaki(Graphics g, Tenkaizu_Syokunin orite, Tensyuugou otta_Men_zu, Tensyuugou Smen_zu, int omote_ura, int hyouji_flg) {


		//hyouji_flgは?ﾜり?繧ｪり?}の表示様式の指定?B4なら実?ﾛに?ﾜり紙を?ﾜった???�と同じ?B3なら透過?}
		String text = "";//文字列????用のクラスのインスタンス化
		ip1 = omote_ura;
		//  System.out.println(Smensuu);
		for (int im = 1; im <= Smensuu; im++) { //Smenから?繧ｩらの指定した番目の面のidを??める?B
			s0[im].set_Menid2uekara_kazoeta_iti(jg);//Smenの.set_Menid2uekara_kazoeta_itiは現?ﾝの?繪ｺ表をもとに?A?繧ｩら?狽ｦてi番めの面のid番??を全ての?�番につき格納する?B
		}

		//面を描く
		int[] x = new int[100];
		int[] y = new int[100];

		if (hyouji_flg == 4) {//?ﾜ紙表示---------------------------------------------------------------------------
			//面を描く
			int Men_jyunban;
			for (int im = 1; im <= Smensuu; im++) {
				Men_jyunban = 1;
				if (omote_ura == 1) {
					Men_jyunban = s0[im].getMenidsuu();
				}

				if (orite.getiMeniti(s0[im].uekara_kazoeta_Menid(Men_jyunban)) % 2 == 1) {
					g.setColor(new Color(255, 255, 50));
				}
				if (orite.getiMeniti(s0[im].uekara_kazoeta_Menid(Men_jyunban)) % 2 == 0) {
					g.setColor(new Color(233, 233, 233));
				}

				if (omote_ura == 1) {
					if (orite.getiMeniti(s0[im].uekara_kazoeta_Menid(Men_jyunban)) % 2 == 0) {
						g.setColor(new Color(255, 255, 50));
					}
					if (orite.getiMeniti(s0[im].uekara_kazoeta_Menid(Men_jyunban)) % 2 == 1) {
						g.setColor(new Color(233, 233, 233));
					}
				}

				for (int i = 1; i <= Smen_zu.getTenidsuu(im) - 1; i++) {
					x[i] = gx(Smen_zu.getTenx(Smen_zu.getTenid(im, i)));
					y[i] = gy(Smen_zu.getTeny(Smen_zu.getTenid(im, i)));
				}

				x[0] = gx(Smen_zu.getTenx(Smen_zu.getTenid(im, Smen_zu.getTenidsuu(im))));
				y[0] = gy(Smen_zu.getTeny(Smen_zu.getTenid(im, Smen_zu.getTenidsuu(im))));

				g.fillPolygon(x, y, Smen_zu.getTenidsuu(im));
			}

			g.setColor(Color.black);

			//棒を描く
			int Mid_min, Mid_max;
			int Men_jyunban_min, Men_jyunban_max;
			for (int ib = 1; ib <= Smen_zu.getBousuu(); ib++) {
				Mid_min = Smen_zu.Bou_moti_Menid_min_motome(ib);
				Mid_max = Smen_zu.Bou_moti_Menid_max_motome(ib);
				if (Mid_min == Mid_max) {//この棒は境界??なのでこの棒は描く?B
					g.drawLine(gx(Smen_zu.getmaex(ib)), gy(Smen_zu.getmaey(ib)), gx(Smen_zu.getatox(ib)), gy(Smen_zu.getatoy(ib))); //直??
				}

				Men_jyunban_min = 1;
				if (omote_ura == 1) {
					Men_jyunban_min = s0[Mid_min].getMenidsuu();
				}
				Men_jyunban_max = 1;
				if (omote_ura == 1) {
					Men_jyunban_max = s0[Mid_max].getMenidsuu();
				}

				if (
						(Mid_min != Mid_max)
								&&
								(s0[Mid_min].uekara_kazoeta_Menid(Men_jyunban_min) !=
										s0[Mid_max].uekara_kazoeta_Menid(Men_jyunban_max))
				) {//この棒で隣?ﾚするSmenの1番?繧ﾌ面は異なるので?Aこの棒は描く?B
					g.drawLine(gx(Smen_zu.getmaex(ib)), gy(Smen_zu.getmaey(ib)), gx(Smen_zu.getatox(ib)), gy(Smen_zu.getatoy(ib))); //直??
				}
			}
		}

		if (hyouji_flg == -3) {//透過表示--------------------------------------------------------------------------------
			int col_hiku = 10;
			int colmax = 250;
			int col_kosa;
			System.out.println("Smen透過表示");
			//面を描く
			for (int im = 1; im <= Smen_zu.getMensuu(); im++) {
				col_kosa = colmax - col_hiku * (s0[im].getMenidsuu() - 1);
				if (col_kosa < 0) {
					col_kosa = 0;
				}
				g.setColor(new Color(col_kosa, col_kosa, col_kosa));

				for (int i = 1; i <= Smen_zu.getTenidsuu(im) - 1; i++) {
					x[i] = gx(Smen_zu.getTenx(Smen_zu.getTenid(im, i)));
					y[i] = gy(Smen_zu.getTeny(Smen_zu.getTenid(im, i)));
				}

				x[0] = gx(Smen_zu.getTenx(Smen_zu.getTenid(im, Smen_zu.getTenidsuu(im))));
				y[0] = gy(Smen_zu.getTeny(Smen_zu.getTenid(im, Smen_zu.getTenidsuu(im))));

				g.fillPolygon(x, y, Smen_zu.getTenidsuu(im));
			}

			g.setColor(Color.black);

			//棒を描く
			int Mid_min, Mid_max;
			int Men_jyunban_min, Men_jyunban_max;
			for (int ib = 1; ib <= Smen_zu.getBousuu(); ib++) {
				g.drawLine(gx(Smen_zu.getmaex(ib)), gy(Smen_zu.getmaey(ib)), gx(Smen_zu.getatox(ib)), gy(Smen_zu.getatoy(ib))); //直??
			}
		}
/*
	        if(hyouji_flg==2){  //?j金表示--------------------------------------------------------------------------------------------------
			int  col_hiku=10;int colmax=250;
			int col_kosa;
			//面を描く
			g.setColor(Color.black);

			//棒を描く
			for(int ib=1;ib<=otta_Men_zu.getBousuu();ib++){
                         	g.drawLine( gx(otta_Men_zu.getmaex(ib)),gy(otta_Men_zu.getmaey(ib)),gx(otta_Men_zu.getatox(ib)),gy(otta_Men_zu.getatoy(ib))); //直??
			}
		}



	        if(hyouji_flg==4){  //Smen表示--------------------------------------------------------------------------------------------------
			//面を描く
 			System.out.println("Smensuu="+Smensuu);

			for (int im=1; im<=Smensuu; im++ ){

				g.setColor(Color.black);
				for (int i=1; i<=Smen_zu.getTenidsuu(im)-1; i++ ){
					x[i]=gx(Smen_zu.getTenx(Smen_zu.getTenid(im,i)));
					y[i]=gy(Smen_zu.getTeny(Smen_zu.getTenid(im,i)));
				}

				x[0]=gx(Smen_zu.getTenx(Smen_zu.getTenid(im,Smen_zu.getTenidsuu(im))));
				y[0]=gy(Smen_zu.getTeny(Smen_zu.getTenid(im,Smen_zu.getTenidsuu(im))));

				g.setColor(Color.red)  ;g.fillPolygon(x,y,Smen_zu.getTenidsuu(im));
				g.setColor(Color.black);g.drawPolygon(x,y,Smen_zu.getTenidsuu(im));
			}

		}
*/
		//表示様式１Smenを描く
		if (hyouji_yousiki == 1) {
			for (int iu = 1; iu <= Smen_yuukou_suu; iu++) {
				int im;
				im = yusenjyun_kara_s0id[iu]; //Smenの優???�位
				int col_kosa;
				col_kosa = 255 - 20 * iu;
				if (col_kosa < 0) {
					col_kosa = 0;
				}
				g.setColor(new Color(col_kosa, 0, 0));

				for (int i = 1; i <= Smen_zu.getTenidsuu(im) - 1; i++) {
					x[i] = gx(Smen_zu.getTenx(Smen_zu.getTenid(im, i)));
					y[i] = gy(Smen_zu.getTeny(Smen_zu.getTenid(im, i)));
				}

				x[0] = gx(Smen_zu.getTenx(Smen_zu.getTenid(im, Smen_zu.getTenidsuu(im))));
				y[0] = gy(Smen_zu.getTeny(Smen_zu.getTenid(im, Smen_zu.getTenidsuu(im))));

				g.fillPolygon(x, y, Smen_zu.getTenidsuu(im));
			}
		}
	}


	//---------------------------------------------------------

	public Memo getMemo_for_svg_kakidasi() {
		Memo memo_temp = new Memo();

		//memo_temp.set(ori_s.getMemo());
		//	memo_temp.addMemo(hoj_s.h_getMemo());
		//	Memo_jyouhou_tuika(memo_temp);


		return memo_temp;
	}


	//---------------------------------------------------------

	public Memo getMemo_for_svg_with_camera(Tenkaizu_Syokunin orite, Tensyuugou otta_Men_zu, Tensyuugou Smen_zu) {//?ﾜり?繧ｪり?}(hyouji_flg==5)
		int omote_ura = 0;
		if (camera.get_camera_kagami() == 1.0) {
			omote_ura = 0;
		}//カ??ラの鏡?ﾝ定が1なら?A?ﾜり?繧ｪり?}は表表示
		if (camera.get_camera_kagami() == -1.0) {
			omote_ura = 1;
		}//カ??ラの鏡?ﾝ定が-1(x軸の符??を反転)なら?A?ﾜり?繧ｪり?}は裏表示

		Ten t0 = new Ten();
		Ten t1 = new Ten();
		Senbun s_ob = new Senbun();
		Senbun s_tv = new Senbun();

		ip1 = omote_ura;
		//  System.out.println(Smensuu);

		Memo memo_temp = new Memo();

		Ten a = new Ten();
		Ten b = new Ten();
		String str = "";
		String str_zahyou = "";
		String str_stroke = "";
		str_stroke = "black";
		String str_strokewidth = "";
		str_strokewidth = "1";


		//面を描く-----------------------------------------------------------------------------------------------------
		int[] x = new int[100];
		int[] y = new int[100];
		double[] xd = new double[100];
		double[] yd = new double[100];

		//Smenの.set_Menid2uekara_kazoeta_itiは現?ﾝの?繪ｺ表をもとに?A?繧ｩら?狽ｦてi番めの面のid番??を全ての?�番につき格納する?B
		for (int im = 1; im <= Smensuu; im++) { //Smenから?繧ｩらの指定した番目の面のidを??める?B
			s0[im].set_Menid2uekara_kazoeta_iti(jg);//s0[]はSmen_zuから得られるSmenそのもの?Ajgは?繪ｺ表Jyougehyouのこと
		}
		//ここまでで?A?繪ｺ表の?�ｱ�がSmenの各面に入った

		//面を描く
		//g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);//アンチェイリアス?@オフ
		int Men_jyunban;
		for (int im = 1; im <= Smensuu; im++) {//imは各Smenの番??
			if (s0[im].getMenidsuu() > 0) {//MenidsuuはSmen(?ﾜり?�み??定してえられた?j金?}を?ﾗ分割した面)で?dなっているMen(?ﾜりたたむ前の展開?}の面)の???Bこれが0なら?Aド?[ナツ?�の穴の面なので描画対?ﾛ外

				//?ﾜり?繧ｪり?}を描くときのim番目のSmenの?Fを決める
				Men_jyunban = 1;
				if (omote_ura == 1) {
					Men_jyunban = s0[im].getMenidsuu();
				}


				if (orite.getiMeniti(s0[im].uekara_kazoeta_Menid(Men_jyunban)) % 2 == 1) {
					str_stroke = ms.toHtmlColor(F_color);
				}//g.setColor(F_color)
				if (orite.getiMeniti(s0[im].uekara_kazoeta_Menid(Men_jyunban)) % 2 == 0) {
					str_stroke = ms.toHtmlColor(B_color);
				}//g.setColor(B_color)


				//if(orite.getiMeniti(s0[im].uekara_kazoeta_Menid(Men_jyunban))%2==1){str_stroke ="yellow";}//g.setColor(F_color)
				//if(orite.getiMeniti(s0[im].uekara_kazoeta_Menid(Men_jyunban))%2==0){str_stroke ="gray";}//g.setColor(B_color)


				if (omote_ura == 1) {
					if (orite.getiMeniti(s0[im].uekara_kazoeta_Menid(Men_jyunban)) % 2 == 0) {
						str_stroke = "yellow";
					}//g.setColor(F_color)
					if (orite.getiMeniti(s0[im].uekara_kazoeta_Menid(Men_jyunban)) % 2 == 1) {
						str_stroke = "gray";
					}//g.setColor(B_color)
				}

				//?ﾜり?繧ｪり?}を描くときのSmenの?Fを決めるのはここまで

				//?ﾜり?繧ｪり?}を描くときのim番目のSmenの多角形の頂点の?ﾀ標?iPC表示???jを??める
				for (int i = 1; i <= Smen_zu.getTenidsuu(im) - 1; i++) {
					t0.setx(Smen_zu.getTenx(Smen_zu.getTenid(im, i)));
					t0.sety(Smen_zu.getTeny(Smen_zu.getTenid(im, i)));
					t1.set(camera.object2TV(t0));
					x[i] = gx(t1.getx());
					y[i] = gy(t1.gety());
				}

				t0.setx(Smen_zu.getTenx(Smen_zu.getTenid(im, Smen_zu.getTenidsuu(im))));
				t0.sety(Smen_zu.getTeny(Smen_zu.getTenid(im, Smen_zu.getTenidsuu(im))));
				t1.set(camera.object2TV(t0));
				x[0] = gx(t1.getx());
				y[0] = gy(t1.gety());
				//?ﾜり?繧ｪり?}を描くときのim番目のSmenの多角形の頂点の?ﾀ標?iPC表示???jを??めるのはここまで

				//g2.fill(new Polygon(x,y,Smen_zu.getTenidsuu(im)));  //svg?o力

				str_zahyou = x[0] + "," + y[0];
				for (int i = 1; i <= Smen_zu.getTenidsuu(im) - 1; i++) {
					str_zahyou = str_zahyou + " " + x[i] + "," + y[i];

				}

/*
				memo_temp.addGyou(    "<polygon points=\"" + str_zahyou + "\"" +
							    " fill=\"" + str_stroke	 + "\"" +
							  " stroke=\"" + str_stroke	 + "\"" +
						    " stroke-width=\"" + str_strokewidth + "\"" +" />"
													);
*/

				memo_temp.addGyou("<polygon points=\"" + str_zahyou + "\"" +
						" style=\"" + "stroke:" + str_stroke + ";fill:" + str_stroke + "\"" +
						" stroke-width=\"" + str_strokewidth + "\"" + " />"
				);


//"stroke:#ff0000;fill:#ff0000"
				//<polygon points="40,380 120,320 200,380" fill="red" stroke="red" stroke-width="1" />


			}
		}
		//面を描く?@ここまで-----------------------------------------------------------------------------------------


		//棒を描く-----------------------------------------------------------------------------------------
/*
		if(i_anti_alias==1){
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);//アンチェイリアス?@オン
			BasicStroke BStroke = new BasicStroke(1.2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);g2.setStroke(BStroke);//??の太さや??の末端の形??
		}
		if(i_anti_alias==0){
	  		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);//アンチェイリアス?@オフ
			BasicStroke BStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);g2.setStroke(BStroke);//??の太さや??の末端の形??
		}
*/
		//g.setColor(L_color);//?ﾜり?繧ｪり?}を描くときの棒の?Fを決める

		//str_stroke = "black";
		str_stroke = ms.toHtmlColor(L_color);

		//System.out.println("?繪ｺ表?E?l?@oekaki_with_camera+++++++++++++++?ﾜ紙表示?@棒を描く");
		for (int ib = 1; ib <= Smen_zu.getBousuu(); ib++) {

			int Mid_min, Mid_max; //棒の両側のSmenの番??の?ｬさいほうがMid_min,?@大きいほうがMid_max
			int Men_jyunban_min, Men_jyunban_max;//PC画面に表示したときSmen(Mid_min) で見える面の番??がMen_jyunban_min?ASmen(Mid_max) で見える面の番??がMen_jyunban_max
			int oekaki_flg;

			oekaki_flg = 0;
			Mid_min = Smen_zu.Bou_moti_Menid_min_motome(ib);//棒ibを境界として含む面(?ﾅ大で2面ある)のうちでMenidの?ｬさいほうのMenidを返す?B棒を境界として含む面が無い???�は0を返す
			Mid_max = Smen_zu.Bou_moti_Menid_max_motome(ib);

			if (s0[Mid_min].getMenidsuu() == 0) {
				oekaki_flg = 1;
			}//menをもたない?Aド?[ナツの穴?�のSmenは境界の棒を描く
			else if (s0[Mid_max].getMenidsuu() == 0) {
				oekaki_flg = 1;
			} else if (Mid_min == Mid_max) {
				oekaki_flg = 1;
			}//一本の棒の片面だけにSmen有り
			else {
				Men_jyunban_min = 1;
				if (omote_ura == 1) {
					Men_jyunban_min = s0[Mid_min].getMenidsuu();
				}
				Men_jyunban_max = 1;
				if (omote_ura == 1) {
					Men_jyunban_max = s0[Mid_max].getMenidsuu();
				}
				if (s0[Mid_min].uekara_kazoeta_Menid(Men_jyunban_min) != s0[Mid_max].uekara_kazoeta_Menid(Men_jyunban_max)) {
					oekaki_flg = 1;
				}//この棒で隣?ﾚするSmenの1番?繧ﾌ面は異なるので?Aこの棒は描く?B
			}

			if (oekaki_flg == 1) {//棒を描く?B
				s_ob.set(Smen_zu.getmaex(ib), Smen_zu.getmaey(ib), Smen_zu.getatox(ib), Smen_zu.getatoy(ib));
				s_tv.set(camera.object2TV(s_ob));
				//g.drawLine( gx(s_tv.getax()),gy(s_tv.getay()),gx(s_tv.getbx()),gy(s_tv.getby())); //svg に直??を?o力

				a.set(s_tv.geta());
				b.set(s_tv.getb());//a.set(s_tv.getax()+0.000001,s_tv.getay()+0.000001); b.set(s_tv.getbx()+0.000001,s_tv.getby()+0.000001);//なぜ0.000001を足すかというと,ディスプレイに描画するとき元の?ﾜ??が?Vしい?ﾜ??に影響されて動いてしまうのを防ぐため

				BigDecimal b_ax = new BigDecimal(String.valueOf(a.getx()));
				BigDecimal b_ay = new BigDecimal(String.valueOf(a.gety()));
				BigDecimal b_bx = new BigDecimal(String.valueOf(b.getx()));
				BigDecimal b_by = new BigDecimal(String.valueOf(b.gety()));


				memo_temp.addGyou("<line x1=\"" + b_ax.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "\"" +
						" y1=\"" + b_ay.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "\"" +
						" x2=\"" + b_bx.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "\"" +
						" y2=\"" + b_by.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "\"" +
						" style=\"" + "stroke:" + str_stroke + "\"" +
						" stroke-width=\"" + str_strokewidth + "\"" + " />"
				);


/*

					memo_temp.addGyou(    "<line x1=\"" + str.valueOf(a.getx()) + "\"" +
							      " y1=\"" + str.valueOf(a.gety()) + "\"" +
							      " x2=\"" + str.valueOf(b.getx()) + "\"" +
							      " y2=\"" + str.valueOf(b.gety()) + "\"" +
							//  " stroke=\"" + str_stroke	 + "\"" +
						      " style=\"" + "stroke:"+str_stroke + "\"" +
						    " stroke-width=\"" + str_strokewidth + "\"" +" />"
													);
*/


			}
		}


		return memo_temp;
	}
	//---------------------------------------------------------

	public void oekaki_with_camera(Graphics g, Tenkaizu_Syokunin orite, Tensyuugou otta_Men_zu, Tensyuugou Smen_zu, int omote_ura, int hyouji_flg) {


		//hyouji_flgは?ﾜり?繧ｪり?}の表示様式の指定?B4なら実?ﾛに?ﾜり紙を?ﾜった???�と同じ?B3なら透過?}
		OritaOekaki OO = new OritaOekaki();
		Ten t0 = new Ten();
		Ten t1 = new Ten();
		Senbun s_ob = new Senbun();
		Senbun s_tv = new Senbun();
		String text = "";//文字列????用のクラスのインスタンス化
		ip1 = omote_ura;
		//  System.out.println(Smensuu);

		//面を描く
		int[] x = new int[100];
		int[] y = new int[100];


		if (hyouji_flg == 5) {//?ﾜ紙表示---------------------------------------------------------------------------

			for (int im = 1; im <= Smensuu; im++) { //Smenから?繧ｩらの指定した番目の面のidを??める?B
				s0[im].set_Menid2uekara_kazoeta_iti(jg);
			}


			//面を描く
//System.out.println("?繪ｺ表?E?l?@oekaki_with_camera+++++++++++++++?ﾜ紙表示?@面を描く");
			int Men_jyunban;
			for (int im = 1; im <= Smensuu; im++) {
				if (s0[im].getMenidsuu() > 0) {
					Men_jyunban = 1;
					if (omote_ura == 1) {
						Men_jyunban = s0[im].getMenidsuu();
					}

					if (orite.getiMeniti(s0[im].uekara_kazoeta_Menid(Men_jyunban)) % 2 == 1) {
						g.setColor(new Color(255, 255, 50));
					}
					if (orite.getiMeniti(s0[im].uekara_kazoeta_Menid(Men_jyunban)) % 2 == 0) {
						g.setColor(new Color(233, 233, 233));
					}

					if (omote_ura == 1) {
						if (orite.getiMeniti(s0[im].uekara_kazoeta_Menid(Men_jyunban)) % 2 == 0) {
							g.setColor(new Color(255, 255, 50));
						}
						if (orite.getiMeniti(s0[im].uekara_kazoeta_Menid(Men_jyunban)) % 2 == 1) {
							g.setColor(new Color(233, 233, 233));
						}
					}

					for (int i = 1; i <= Smen_zu.getTenidsuu(im) - 1; i++) {

						t0.setx(Smen_zu.getTenx(Smen_zu.getTenid(im, i)));
						t0.sety(Smen_zu.getTeny(Smen_zu.getTenid(im, i)));
						t1.set(camera.object2TV(t0));
						x[i] = gx(t1.getx());
						y[i] = gy(t1.gety());
						//x[i]=gx(Smen_zu.getTenx(Smen_zu.getTenid(im,i)));
						//y[i]=gy(Smen_zu.getTeny(Smen_zu.getTenid(im,i)));
					}

					t0.setx(Smen_zu.getTenx(Smen_zu.getTenid(im, Smen_zu.getTenidsuu(im))));
					t0.sety(Smen_zu.getTeny(Smen_zu.getTenid(im, Smen_zu.getTenidsuu(im))));
					t1.set(camera.object2TV(t0));
					x[0] = gx(t1.getx());
					y[0] = gy(t1.gety());
					//x[0]=gx(Smen_zu.getTenx(Smen_zu.getTenid(im,Smen_zu.getTenidsuu(im))));
					//y[0]=gy(Smen_zu.getTeny(Smen_zu.getTenid(im,Smen_zu.getTenidsuu(im))));

					g.fillPolygon(x, y, Smen_zu.getTenidsuu(im));
				}
			}

			g.setColor(Color.black);
//System.out.println("?繪ｺ表?E?l?@oekaki_with_camera+++++++++++++++?ﾜ紙表示?@棒を描く");
			//棒を描く
			int Mid_min, Mid_max;
			int Men_jyunban_min, Men_jyunban_max;
			int oekaki_flg;
			for (int ib = 1; ib <= Smen_zu.getBousuu(); ib++) {
				oekaki_flg = 0;
				Mid_min = Smen_zu.Bou_moti_Menid_min_motome(ib);//棒ibを境界として含む面(?ﾅ大で2面ある)のうちでMenidの?ｬさいほうのMenidを返す?B棒を境界として含む面が無い???�は0を返す
				Mid_max = Smen_zu.Bou_moti_Menid_max_motome(ib);

				if (s0[Mid_min].getMenidsuu() == 0) {
					oekaki_flg = 1;
				}//menをもたない?Aド?[ナツの穴?�のSmenは境界の棒を描く
				else if (s0[Mid_max].getMenidsuu() == 0) {
					oekaki_flg = 1;
				} else if (Mid_min == Mid_max) {
					oekaki_flg = 1;
				}//一本の棒の片面だけにSmen有り
				else {
					Men_jyunban_min = 1;
					if (omote_ura == 1) {
						Men_jyunban_min = s0[Mid_min].getMenidsuu();
					}
					Men_jyunban_max = 1;
					if (omote_ura == 1) {
						Men_jyunban_max = s0[Mid_max].getMenidsuu();
					}
					if (s0[Mid_min].uekara_kazoeta_Menid(Men_jyunban_min) != s0[Mid_max].uekara_kazoeta_Menid(Men_jyunban_max)) {
						oekaki_flg = 1;
					}//この棒で隣?ﾚするSmenの1番?繧ﾌ面は異なるので?Aこの棒は描く?B
				}

				if (oekaki_flg == 1) {//棒を描く?B
					s_ob.set(Smen_zu.getmaex(ib), Smen_zu.getmaey(ib), Smen_zu.getatox(ib), Smen_zu.getatoy(ib));
					s_tv.set(camera.object2TV(s_ob));
					g.drawLine(gx(s_tv.getax()), gy(s_tv.getay()), gx(s_tv.getbx()), gy(s_tv.getby())); //直??
					//g.drawLine( gx(Smen_zu.getmaex(ib)),gy(Smen_zu.getmaey(ib)),gx(Smen_zu.getatox(ib)),gy(Smen_zu.getatoy(ib))); //直??
				}


			}
			//System.out.println("?繪ｺ表?E?l?@oekaki_with_camera+++++++++++++++?ﾜ紙表示?@?I了");
		}


//System.out.println("?繪ｺ表?E?l?@oekaki_with_camera+++++++++++++++hyouji_yousiki = "+hyouji_yousiki);

		//表示様式１Smenを描く
		if (hyouji_yousiki == 1) {
			for (int iu = 1; iu <= Smen_yuukou_suu; iu++) {
				int im;
				im = yusenjyun_kara_s0id[iu]; //Smenの優???�位
				int col_kosa;
				col_kosa = 255 - 20 * iu;
				if (col_kosa < 0) {
					col_kosa = 0;
				}
				g.setColor(new Color(col_kosa, 0, 0));

				for (int i = 1; i <= Smen_zu.getTenidsuu(im) - 1; i++) {

					t0.setx(Smen_zu.getTenx(Smen_zu.getTenid(im, i)));
					t0.sety(Smen_zu.getTeny(Smen_zu.getTenid(im, i)));
					t1.set(camera.object2TV(t0));
					x[i] = gx(t1.getx());
					y[i] = gy(t1.gety());
					//x[i]=gx(Smen_zu.getTenx(Smen_zu.getTenid(im,i)));
					//y[i]=gy(Smen_zu.getTeny(Smen_zu.getTenid(im,i)));
					//x[i]=gx(Smen_zu.getTenx(Smen_zu.getTenid(im,i)));
					//y[i]=gy(Smen_zu.getTeny(Smen_zu.getTenid(im,i)));
				}

				t0.setx(Smen_zu.getTenx(Smen_zu.getTenid(im, Smen_zu.getTenidsuu(im))));
				t0.sety(Smen_zu.getTeny(Smen_zu.getTenid(im, Smen_zu.getTenidsuu(im))));
				t1.set(camera.object2TV(t0));
				x[0] = gx(t1.getx());
				y[0] = gy(t1.gety());
				//x[0]=gx(Smen_zu.getTenx(Smen_zu.getTenid(im,Smen_zu.getTenidsuu(im))));
				//y[0]=gy(Smen_zu.getTeny(Smen_zu.getTenid(im,Smen_zu.getTenidsuu(im))));
				//x[0]=gx(Smen_zu.getTenx(Smen_zu.getTenid(im,Smen_zu.getTenidsuu(im))));
				//y[0]=gy(Smen_zu.getTeny(Smen_zu.getTenid(im,Smen_zu.getTenidsuu(im))));

				g.fillPolygon(x, y, Smen_zu.getTenidsuu(im));
			}
		}


		//camera中?Sを?\字で描く
		OO.jyuuji(g, camera.object2TV(camera.get_camera_ichi()), 5.0, 2.0, 4);


	}


	//
	//---------------------------------------------------------
	public Memo getMemo_hariganezu_for_svg_kakidasi(Tenkaizu_Syokunin orite, Tensyuugou otta_Men_zu, Tensyuugou Smen_zu, int i_fill) {
		//System.out.println("getMemo_hariganezu_for_svg_kakidasi");
		int omote_ura = 0;
		if (camera.get_camera_kagami() == 1.0) {
			omote_ura = 0;
		}//カ??ラの鏡?ﾝ定が1なら?A?ﾜり?繧ｪり?}は表表示
		if (camera.get_camera_kagami() == -1.0) {
			omote_ura = 1;
		}//カ??ラの鏡?ﾝ定が-1(x軸の符??を反転)なら?A?ﾜり?繧ｪり?}は裏表示

		Ten t_ob = new Ten();
		Ten t_tv = new Ten();
		Senbun s_ob = new Senbun();
		Senbun s_tv = new Senbun();

		ip1 = omote_ura;
		//  System.out.println(Smensuu);

		Memo memo_temp = new Memo();

		Ten a = new Ten();
		Ten b = new Ten();
		String str = "";
		String str_zahyou = "";
		String str_stroke = "";
		str_stroke = "black";
		String str_strokewidth = "";
		str_strokewidth = "1";
		String str_fill = "";
		str_fill = "";

		//System.out.println("?繪ｺ表?E?l?@oekaki_with_camera+++++++++++++++透過表示");


		rating2();


		//面を描く??備
		int[] x = new int[100];
		int[] y = new int[100];

		//BigDecimalのコンストラクタの引?狽ﾍ浮動?ｬ?箔_?伯^と文字列型どちらもok?B引?狽ｪ浮動?ｬ?箔_?伯^は誤?ｷが発?ｶ?B?ｳ確な値を扱うためには?A引?狽ﾍ文字列型で指定?B

		for (int i_nbox = 1; i_nbox <= otta_Men_zu.getMensuu(); i_nbox++) {
			int im = 0;
			if (camera.get_camera_kagami() == -1.0) {//カ??ラの鏡?ﾝ定が-1(x軸の符??を反転)なら?A?ﾜり?繧ｪり?}は裏表示
				im = nbox.usirokara_get_int(i_nbox);
			} else {
				im = nbox.get_int(i_nbox);
			}

			String text = "";//文字列????用のクラスのインスタンス化

			text = "M ";
			t_ob.setx(otta_Men_zu.getTenx(otta_Men_zu.getTenid(im, 1)));
			t_ob.sety(otta_Men_zu.getTeny(otta_Men_zu.getTenid(im, 1)));
			t_tv.set(camera.object2TV(t_ob));
			BigDecimal b_t_tv_x = new BigDecimal(String.valueOf(t_tv.getx()));
			BigDecimal b_t_tv_y = new BigDecimal(String.valueOf(t_tv.gety()));

			text = text + b_t_tv_x.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + " " +
					b_t_tv_y.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + " ";


			for (int i = 2; i <= otta_Men_zu.getTenidsuu(im); i++) {
				text = text + "L ";
				t_ob.setx(otta_Men_zu.getTenx(otta_Men_zu.getTenid(im, i)));
				t_ob.sety(otta_Men_zu.getTeny(otta_Men_zu.getTenid(im, i)));
				t_tv.set(camera.object2TV(t_ob));
				BigDecimal b_t_tv_x_i = new BigDecimal(String.valueOf(t_tv.getx()));
				BigDecimal b_t_tv_y_i = new BigDecimal(String.valueOf(t_tv.gety()));

				text = text + b_t_tv_x_i.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + " " +
						b_t_tv_y_i.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + " ";
			}

			text = text + "Z";


//<polygon points="250 50 300 100 250 100" stroke="black" fill="none"/>
//<path d="M 100 100 L 300 100 L 200 300 z" fill="red" stroke="blue" stroke-width="3" />
/*
					memo_temp.addGyou(    "<polygon points=\"" + str.valueOf( b_ax.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()) + "\"" +
							           " y1=\"" + str.valueOf( b_ay.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()) + "\"" +
							           " x2=\"" + str.valueOf( b_bx.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()) + "\"" +
							           " y2=\"" + str.valueOf( b_by.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()) + "\"" +
						      " style=\"" + "stroke:"+str_stroke + "\"" +
						    " stroke-width=\"" + str_strokewidth + "\"" +" />"

							);
*/

			if (i_fill == 0) {
				str_fill = "none";

			}

			if (i_fill == 1) {

				if (orite.getiMeniti(im) % 2 == 1) {
					str_fill = ms.toHtmlColor(F_color);
				}
				if (orite.getiMeniti(im) % 2 == 0) {
					str_fill = ms.toHtmlColor(B_color);
				}

				if (omote_ura == 1) {
					if (orite.getiMeniti(im) % 2 == 1) {
						str_fill = ms.toHtmlColor(B_color);
					}
					if (orite.getiMeniti(im) % 2 == 0) {
						str_fill = ms.toHtmlColor(F_color);
					}


				}


			}

			memo_temp.addGyou("<path d=\"" + text + "\"" +
					" style=\"" + "stroke:" + str_stroke + "\"" +
					" stroke-width=\"" + str_strokewidth + "\"" +
					//" fill=\"none\"" +" />"
					" fill=\"" + str_fill + "\"" + " />"
			);


		}

/*

//カラ?[の透過?}
//toukazu_toukado=col_hiku;
		g.setColor(new Color(100,100, 100,50));

		//面を描く
		for (int im=1; im<=otta_Men_zu.getMensuu(); im++ ){
			for (int i=1; i<=otta_Men_zu.getTenidsuu(im)-1; i++ ){
				t0.setx(otta_Men_zu.getTenx(otta_Men_zu.getTenid(im,i)));
				t0.sety(otta_Men_zu.getTeny(otta_Men_zu.getTenid(im,i)));
				t1.set(camera.object2TV(t0));
				x[i]=gx(t1.getx());
				y[i]=gy(t1.gety());
			}

				t0.setx(otta_Men_zu.getTenx(otta_Men_zu.getTenid(im,otta_Men_zu.getTenidsuu(im))));
				t0.sety(otta_Men_zu.getTeny(otta_Men_zu.getTenid(im,otta_Men_zu.getTenidsuu(im))));
				t1.set(camera.object2TV(t0));
				x[0]=gx(t1.getx());
				y[0]=gy(t1.gety());
			g.fillPolygon(x,y,otta_Men_zu.getTenidsuu(im));
			//g.drawPolygon(x,y,otta_Men_zu.getTenidsuu(im));
		}
*/


		return memo_temp;

	}


	//---------------------------------------------------------
	public void oekaki_toukazu_with_camera(Graphics g, Tenkaizu_Syokunin orite, Tensyuugou otta_Men_zu, Tensyuugou Smen_zu, int i_toukazu_color, int toukazu_toukado) {
		Graphics2D g2 = (Graphics2D) g;

		//System.out.println("?繪ｺ表?E?l?@oekaki_with_camera+++++++++++++++透過表示");
		OritaOekaki OO = new OritaOekaki();
		Ten t0 = new Ten();
		Ten t1 = new Ten();
		Senbun s_ob = new Senbun();
		Senbun s_tv = new Senbun();
		String text = "";//文字列????用のクラスのインスタンス化

		//面を描く??備
		int[] x = new int[100];
		int[] y = new int[100];

		//面の適?ﾘな濃さを??める
		int col_hiku = 0;
		int colmax = 255;
		int colmin = 30;//colmax=255(?^っ白)以下?Acolmin=0(?^っ??)以??
		//Menidsuu_maxは1以?繧ﾅあること
		if (Menidsuu_max > 0) {
			col_hiku = (colmax - colmin) / Menidsuu_max;
		}
		//if(Menidsuu_max<=0){System.out.println("?繪ｺ表?E?l?@oekaki_toukazu_with_camera!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!    Menidsuu_max<=0  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");}


//if(orihime_ap.ckbox_toukazu_color.isSelected()){//カラ?[の透過?}
//if(orihime_ap.OZ.i_toukazu_color==1){//カラ?[の透過?}
		if (i_toukazu_color == 1) {//カラ?[の透過?}

//toukazu_toukado=col_hiku;
			g.setColor(new Color(F_color.getRed(), F_color.getGreen(), F_color.getBlue(), toukazu_toukado));

			//面を描く
			for (int im = 1; im <= otta_Men_zu.getMensuu(); im++) {
				for (int i = 1; i <= otta_Men_zu.getTenidsuu(im) - 1; i++) {
					t0.setx(otta_Men_zu.getTenx(otta_Men_zu.getTenid(im, i)));
					t0.sety(otta_Men_zu.getTeny(otta_Men_zu.getTenid(im, i)));
					t1.set(camera.object2TV(t0));
					x[i] = gx(t1.getx());
					y[i] = gy(t1.gety());
				}

				t0.setx(otta_Men_zu.getTenx(otta_Men_zu.getTenid(im, otta_Men_zu.getTenidsuu(im))));
				t0.sety(otta_Men_zu.getTeny(otta_Men_zu.getTenid(im, otta_Men_zu.getTenidsuu(im))));
				t1.set(camera.object2TV(t0));
				x[0] = gx(t1.getx());
				y[0] = gy(t1.gety());
				g.fillPolygon(x, y, otta_Men_zu.getTenidsuu(im));
				//g.drawPolygon(x,y,otta_Men_zu.getTenidsuu(im));
			}

			//棒を描く??備
			//g.setColor(Color.black);


			if (i_anti_alias == 1) {
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//アンチェイリアス?@オン
				BasicStroke BStroke = new BasicStroke(1.2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
				g2.setStroke(BStroke);//??の太さや??の末端の形??
			}
			if (i_anti_alias == 0) {
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);//アンチェイリアス?@オフ
				BasicStroke BStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
				g2.setStroke(BStroke);//??の太さや??の末端の形??
			}

			g.setColor(new Color(F_color.getRed(), F_color.getGreen(), F_color.getBlue(), 2 * toukazu_toukado));
			//棒を描く
			int Mid_min, Mid_max;
			int Men_jyunban_min, Men_jyunban_max;
			for (int ib = 1; ib <= Smen_zu.getBousuu(); ib++) {
				s_ob.set(Smen_zu.getmaex(ib), Smen_zu.getmaey(ib), Smen_zu.getatox(ib), Smen_zu.getatoy(ib));
				s_tv.set(camera.object2TV(s_ob));
				g.drawLine(gx(s_tv.getax()), gy(s_tv.getay()), gx(s_tv.getbx()), gy(s_tv.getby())); //直??
			}


		} else {//白?浮ﾌ透過?}?i旧式?j



/*
		int col_hiku=0;int colmax=255;int colmin=30;//colmax=255(?^っ白)以下?Acolmin=0(?^っ??)以??
		//Menidsuu_maxは1以?繧ﾅあること
		if(Menidsuu_max>0){col_hiku=(colmax-colmin)/Menidsuu_max;}
		//if(Menidsuu_max<=0){System.out.println("?繪ｺ表?E?l?@oekaki_toukazu_with_camera!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!    Menidsuu_max<=0  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");}
*/
			int col_kosa;


			for (int im = 1; im <= Smen_zu.getMensuu(); im++) {

				col_kosa = colmax - col_hiku * (s0[im].getMenidsuu());


				if (col_kosa > 255) {
					col_kosa = 255;
				}

				if (col_kosa < 0) {
					col_kosa = 0;
				}
				//System.out.println("col_kosa="+col_kosa);
				g.setColor(new Color(col_kosa, col_kosa, col_kosa));

				for (int i = 1; i <= Smen_zu.getTenidsuu(im) - 1; i++) {
					t0.setx(Smen_zu.getTenx(Smen_zu.getTenid(im, i)));
					t0.sety(Smen_zu.getTeny(Smen_zu.getTenid(im, i)));
					t1.set(camera.object2TV(t0));
					x[i] = gx(t1.getx());
					y[i] = gy(t1.gety());
				}

				t0.setx(Smen_zu.getTenx(Smen_zu.getTenid(im, Smen_zu.getTenidsuu(im))));
				t0.sety(Smen_zu.getTeny(Smen_zu.getTenid(im, Smen_zu.getTenidsuu(im))));
				t1.set(camera.object2TV(t0));
				x[0] = gx(t1.getx());
				y[0] = gy(t1.gety());
				g.fillPolygon(x, y, Smen_zu.getTenidsuu(im));
			}

			//棒を描く??備
			g.setColor(Color.black);


			if (i_anti_alias == 1) {
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//アンチェイリアス?@オン
				BasicStroke BStroke = new BasicStroke(1.2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
				g2.setStroke(BStroke);//??の太さや??の末端の形??
			}
			if (i_anti_alias == 0) {
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);//アンチェイリアス?@オフ
				BasicStroke BStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
				g2.setStroke(BStroke);//??の太さや??の末端の形??
			}


			//棒を描く
			int Mid_min, Mid_max;
			int Men_jyunban_min, Men_jyunban_max;
			for (int ib = 1; ib <= Smen_zu.getBousuu(); ib++) {
				s_ob.set(Smen_zu.getmaex(ib), Smen_zu.getmaey(ib), Smen_zu.getatox(ib), Smen_zu.getatoy(ib));
				s_tv.set(camera.object2TV(s_ob));
				g.drawLine(gx(s_tv.getax()), gy(s_tv.getay()), gx(s_tv.getbx()), gy(s_tv.getby())); //直??
			}

			if (errorPos != null) {
				g2.setColor(new Color(255, 0, 0, 75));
				fillPolygon(g2, errorPos.geta(), otta_Men_zu, camera);
				fillPolygon(g2, errorPos.getb(), otta_Men_zu, camera);
				fillPolygon(g2, errorPos.getc(), otta_Men_zu, camera);
				fillPolygon(g2, errorPos.getd(), otta_Men_zu, camera);


				fillPolygon(g2, errorPos.geta(), orite.get(), orihime_ap.camera_of_orisen_nyuuryokuzu);
				fillPolygon(g2, errorPos.getb(), orite.get(), orihime_ap.camera_of_orisen_nyuuryokuzu);
				fillPolygon(g2, errorPos.getc(), orite.get(), orihime_ap.camera_of_orisen_nyuuryokuzu);
				fillPolygon(g2, errorPos.getd(), orite.get(), orihime_ap.camera_of_orisen_nyuuryokuzu);
			}

		}

	}


	//---------------------------------------------------------

	public void oekaki_oriagarizu_with_camera(Graphics g, Tenkaizu_Syokunin orite, Tensyuugou otta_Men_zu, Tensyuugou Smen_zu) {
		Graphics2D g2 = (Graphics2D) g;
		int omote_ura = 0;
		if (camera.get_camera_kagami() == 1.0) {
			omote_ura = 0;
		}//カ??ラの鏡?ﾝ定が1なら?A?ﾜり?繧ｪり?}は表表示
		if (camera.get_camera_kagami() == -1.0) {
			omote_ura = 1;
		}//カ??ラの鏡?ﾝ定が-1(x軸の符??を反転)なら?A?ﾜり?繧ｪり?}は裏表示
		//System.out.println("?繪ｺ表?E?l?@oekaki_with_camera+++++++++++++++?ﾜ紙表示?@面を描く");
		OritaOekaki OO = new OritaOekaki();
		Ten t0 = new Ten();
		Ten t1 = new Ten();
		Senbun s_ob = new Senbun();
		Senbun s_tv = new Senbun();
		String text = "";//文字列????用のクラスのインスタンス化
		ip1 = omote_ura;
		//  System.out.println(Smensuu);

		//面を描く
		int[] x = new int[100];
		int[] y = new int[100];

		double[] xd = new double[100];
		double[] yd = new double[100];


		//if(hyouji_flg==5){//?ﾜ紙表示---------------------------------------------------------------------------

		//Smenの.set_Menid2uekara_kazoeta_itiは現?ﾝの?繪ｺ表をもとに?A?繧ｩら?狽ｦてi番めの面のid番??を全ての?�番につき格納する?B
		for (int im = 1; im <= Smensuu; im++) { //Smenから?繧ｩらの指定した番目の面のidを??める?B
			s0[im].set_Menid2uekara_kazoeta_iti(jg);//s0[]はSmen_zuから得られるSmenそのもの?Ajgは?繪ｺ表Jyougehyouのこと
		}
		//ここまでで?A?繪ｺ表の?�ｱ�がSmenの各面に入った


		//面を描く-----------------------------------------------------------------------------------------------------
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);//アンチェイリアス?@オフ

		int Men_jyunban;
		for (int im = 1; im <= Smensuu; im++) {//imは各Smenの番??
			if (s0[im].getMenidsuu() > 0) {//MenidsuuはSmen(?ﾜり?�み??定してえられた?j金?}を?ﾗ分割した面)で?dなっているMen(?ﾜりたたむ前の展開?}の面)の???Bこれが0なら?Aド?[ナツ?�の穴の面なので描画対?ﾛ外

				//?ﾜり?繧ｪり?}を描くときのim番目のSmenの?Fを決める
				Men_jyunban = 1;
				if (omote_ura == 1) {
					Men_jyunban = s0[im].getMenidsuu();
				}

				//if(orite.getiMeniti(s0[im].uekara_kazoeta_Menid(Men_jyunban))%2==1){g.setColor(new Color(255,255,50));}
				//if(orite.getiMeniti(s0[im].uekara_kazoeta_Menid(Men_jyunban))%2==0){g.setColor(new Color(233,233,233));}
				if (orite.getiMeniti(s0[im].uekara_kazoeta_Menid(Men_jyunban)) % 2 == 1) {
					g.setColor(F_color);
				}
				if (orite.getiMeniti(s0[im].uekara_kazoeta_Menid(Men_jyunban)) % 2 == 0) {
					g.setColor(B_color);
				}


				if (omote_ura == 1) {
					//if(orite.getiMeniti(s0[im].uekara_kazoeta_Menid(Men_jyunban))%2==0){g.setColor(new Color(255,255,50));}
					//if(orite.getiMeniti(s0[im].uekara_kazoeta_Menid(Men_jyunban))%2==1){g.setColor(new Color(233,233,233));}

					if (orite.getiMeniti(s0[im].uekara_kazoeta_Menid(Men_jyunban)) % 2 == 0) {
						g.setColor(F_color);
					}
					if (orite.getiMeniti(s0[im].uekara_kazoeta_Menid(Men_jyunban)) % 2 == 1) {
						g.setColor(B_color);
					}
				}


				//?ﾜり?繧ｪり?}を描くときのSmenの?Fを決めるのはここまで

				//?ﾜり?繧ｪり?}を描くときのim番目のSmenの多角形の頂点の?ﾀ標?iPC表示???jを??める

				for (int i = 1; i <= Smen_zu.getTenidsuu(im) - 1; i++) {

					t0.setx(Smen_zu.getTenx(Smen_zu.getTenid(im, i)));
					t0.sety(Smen_zu.getTeny(Smen_zu.getTenid(im, i)));
					t1.set(camera.object2TV(t0));
					x[i] = gx(t1.getx());
					y[i] = gy(t1.gety());
					//x[i]=gx(Smen_zu.getTenx(Smen_zu.getTenid(im,i)));
					//y[i]=gy(Smen_zu.getTeny(Smen_zu.getTenid(im,i)));
				}

				t0.setx(Smen_zu.getTenx(Smen_zu.getTenid(im, Smen_zu.getTenidsuu(im))));
				t0.sety(Smen_zu.getTeny(Smen_zu.getTenid(im, Smen_zu.getTenidsuu(im))));
				t1.set(camera.object2TV(t0));
				x[0] = gx(t1.getx());
				y[0] = gy(t1.gety());
				//x[0]=gx(Smen_zu.getTenx(Smen_zu.getTenid(im,Smen_zu.getTenidsuu(im))));
				//y[0]=gy(Smen_zu.getTeny(Smen_zu.getTenid(im,Smen_zu.getTenidsuu(im))));

				//?ﾜり?繧ｪり?}を描くときのim番目のSmenの多角形の頂点の?ﾀ標?iPC表示???jを??めるのはここまで

				g2.fill(new Polygon(x, y, Smen_zu.getTenidsuu(im)));
				//g.fillPolygon(x,y,Smen_zu.getTenidsuu(im));
			}
		}
		//面を描く?@ここまで

		//g.setColor(new Color(0,0,0));		//??
		//g.setColor(new Color(255,255,255));	//白


		//影をつける ------------------------------------------------------------------------------------
		if (i_kage == 1) {

			for (int ib = 1; ib <= Smen_zu.getBousuu(); ib++) {
				int im = bou_no_bangou_kara_kagenoaru_Smen_no_bangou_wo_motomeru(ib, Smen_zu, omote_ura);//影をつけるSmenのid
				if (im != 0) {//影を描く?B

					//?ﾜり?繧ｪり?}を描くときのim番目のSmenの多角形の頂点の?ﾀ標?iPC表示???jを??める
		   /*
				for (int i=1; i<=Smen_zu.getTenidsuu(im)-1; i++ ){

					t0.setx(Smen_zu.getTenx(Smen_zu.getTenid(im,i)));
					t0.sety(Smen_zu.getTeny(Smen_zu.getTenid(im,i)));
					t1.set(camera.object2TV(t0));
					x[i]=gx(t1.getx());
					y[i]=gy(t1.gety());
				}

				t0.setx(Smen_zu.getTenx(Smen_zu.getTenid(im,Smen_zu.getTenidsuu(im))));
				t0.sety(Smen_zu.getTeny(Smen_zu.getTenid(im,Smen_zu.getTenidsuu(im))));
				t1.set(camera.object2TV(t0));
				x[0]=gx(t1.getx());
				y[0]=gy(t1.gety());

				//?ﾜり?繧ｪり?}を描くときのim番目のSmenの多角形の頂点の?ﾀ標?iPC表示???jを??めるのはここまで
*/


					//棒の?ﾀ標   Smen_zu.getmaex(ib),Smen_zu.getmaey(ib)   -    Smen_zu.getatox(ib) , Smen_zu.getatoy(ib)
					Ten b_mae = new Ten(Smen_zu.getmaex(ib), Smen_zu.getmaey(ib));
					Ten b_ato = new Ten(Smen_zu.getatox(ib), Smen_zu.getatoy(ib));
					double b_nagasa = b_mae.kyori(b_ato);

					//棒と直交するベクトル
					double o_btx = -(Smen_zu.getmaey(ib) - Smen_zu.getatoy(ib)) * 10.0 / b_nagasa;//棒と直交するxベクトル
					double o_bty = (Smen_zu.getmaex(ib) - Smen_zu.getatox(ib)) * 10.0 / b_nagasa;//棒と直交するyベクトル

					//棒の中点
					double o_bmx, o_bmy;
					double t_bmx, t_bmy;

					o_bmx = (Smen_zu.getmaex(ib) + Smen_zu.getatox(ib)) / 2.0;
					o_bmy = (Smen_zu.getmaey(ib) + Smen_zu.getatoy(ib)) / 2.0;

					t0.setx(o_bmx);
					t0.sety(o_bmy);
					t1.set(camera.object2TV(t0));
					t_bmx = t1.getx();
					t_bmy = t1.gety();

					//棒の中点を通る直交???繧ﾌ点
					double o_bmtx, o_bmty;
					double t_bmtx, t_bmty;


					//棒の中点を通る直交???繧ﾌ点
					o_bmtx = o_bmx + o_btx;
					o_bmty = o_bmy + o_bty;

					if (Smen_zu.naibu(new Ten(o_bmx + 0.01 * o_btx, o_bmy + 0.01 * o_bty), im) != 0) {//0=外部?A?@1=境界?A?@2=内部


						t0.setx(o_bmtx);
						t0.sety(o_bmty);
						t1.set(camera.object2TV(t0));
						t_bmtx = t1.getx();
						t_bmty = t1.gety();


						//影の長方形

						// ---------- [0] ----------------
						t0.setx(Smen_zu.getmaex(ib));
						t0.sety(Smen_zu.getmaey(ib));
						t1.set(camera.object2TV(t0));
						xd[0] = t1.getx();
						yd[0] = t1.gety();
						x[0] = (int) xd[0];
						y[0] = (int) yd[0];

						// ---------- [1] ----------------
						t0.setx(Smen_zu.getmaex(ib) + o_btx);
						t0.sety(Smen_zu.getmaey(ib) + o_bty);
						t1.set(camera.object2TV(t0));
						xd[1] = t1.getx();
						yd[1] = t1.gety();
						x[1] = (int) xd[1];
						y[1] = (int) yd[1];

						// ---------- [2] ----------------
						t0.setx(Smen_zu.getatox(ib) + o_btx);
						t0.sety(Smen_zu.getatoy(ib) + o_bty);
						t1.set(camera.object2TV(t0));
						xd[2] = t1.getx();
						yd[2] = t1.gety();
						x[2] = (int) xd[2];
						y[2] = (int) yd[2];

						// ---------- [3] ----------------
						t0.setx(Smen_zu.getatox(ib));
						t0.sety(Smen_zu.getatoy(ib));
						t1.set(camera.object2TV(t0));
						xd[3] = t1.getx();
						yd[3] = t1.gety();
						x[3] = (int) xd[3];
						y[3] = (int) yd[3];

						g2.setPaint(new GradientPaint((float) t_bmx, (float) t_bmy, new Color(0, 0, 0, 50), (float) t_bmtx, (float) t_bmty, new Color(0, 0, 0, 0)));
						//g2.setPaint( new GradientPaint( (float)xd[0], (float)yd[0], new Color(0,0,0,50),     (float)xd[1], (float)yd[1],  new Color(0,0,0,0)  ));


						g2.fill(new Polygon(x, y, 4));

					}


					//----------------------------------棒と直交するxベクトルの向きを変えて影を描画
					o_btx = -o_btx;//棒と直交するxベクトル
					o_bty = -o_bty;//棒と直交するyベクトル


					//-----------------------------------------------
					//棒の中点を通る直交???繧ﾌ点
					o_bmtx = o_bmx + o_btx;
					o_bmty = o_bmy + o_bty;


					if (Smen_zu.naibu(new Ten(o_bmx + 0.01 * o_btx, o_bmy + 0.01 * o_bty), im) != 0) {//0=外部?A?@1=境界?A?@2=内部

						t0.setx(o_bmtx);
						t0.sety(o_bmty);
						t1.set(camera.object2TV(t0));
						t_bmtx = t1.getx();
						t_bmty = t1.gety();


						//影の長方形

						// ---------- [0] ----------------
						t0.setx(Smen_zu.getmaex(ib));
						t0.sety(Smen_zu.getmaey(ib));
						t1.set(camera.object2TV(t0));
						xd[0] = t1.getx();
						yd[0] = t1.gety();
						x[0] = (int) xd[0];
						y[0] = (int) yd[0];

						// ---------- [1] ----------------
						t0.setx(Smen_zu.getmaex(ib) + o_btx);
						t0.sety(Smen_zu.getmaey(ib) + o_bty);
						t1.set(camera.object2TV(t0));
						xd[1] = t1.getx();
						yd[1] = t1.gety();
						x[1] = (int) xd[1];
						y[1] = (int) yd[1];

						// ---------- [2] ----------------
						t0.setx(Smen_zu.getatox(ib) + o_btx);
						t0.sety(Smen_zu.getatoy(ib) + o_bty);
						t1.set(camera.object2TV(t0));
						xd[2] = t1.getx();
						yd[2] = t1.gety();
						x[2] = (int) xd[2];
						y[2] = (int) yd[2];

						// ---------- [3] ----------------
						t0.setx(Smen_zu.getatox(ib));
						t0.sety(Smen_zu.getatoy(ib));
						t1.set(camera.object2TV(t0));
						xd[3] = t1.getx();
						yd[3] = t1.gety();
						x[3] = (int) xd[3];
						y[3] = (int) yd[3];


						//g2.setPaint( new GradientPaint( (float)t_bmx, (float)t_bmy, new Color(0,0,0,50),     (float)t_bmtx, (float)t_bmty,  new Color(0,0,0,0)  ));
						g2.setPaint(new GradientPaint((float) xd[0], (float) yd[0], new Color(0, 0, 0, 50), (float) xd[1], (float) yd[1], new Color(0, 0, 0, 0)));
						g2.fill(new Polygon(x, y, 4));
					}

//-------------------------------------------------------


				}
			}
		}//影をつけるは?Aここで?Iわり

		//棒を描く-----------------------------------------------------------------------------------------


		if (i_anti_alias == 1) {
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//アンチェイリアス?@オン
			BasicStroke BStroke = new BasicStroke(1.2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
			g2.setStroke(BStroke);//??の太さや??の末端の形??
		}
		if (i_anti_alias == 0) {
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);//アンチェイリアス?@オフ
			BasicStroke BStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
			g2.setStroke(BStroke);//??の太さや??の末端の形??
		}

		g.setColor(L_color);//g.setColor(Color.black);


		//System.out.println("?繪ｺ表?E?l?@oekaki_with_camera+++++++++++++++?ﾜ紙表示?@棒を描く");


		for (int ib = 1; ib <= Smen_zu.getBousuu(); ib++) {

			int Mid_min, Mid_max; //棒の両側のSmenの番??の?ｬさいほうがMid_min,?@大きいほうがMid_max
			int Men_jyunban_min, Men_jyunban_max;//PC画面に表示したときSmen(Mid_min) で見える面の番??がMen_jyunban_min?ASmen(Mid_max) で見える面の番??がMen_jyunban_max
			int oekaki_flg;

			oekaki_flg = 0;
			Mid_min = Smen_zu.Bou_moti_Menid_min_motome(ib);//棒ibを境界として含む面(?ﾅ大で2面ある)のうちでMenidの?ｬさいほうのMenidを返す?B棒を境界として含む面が無い???�は0を返す
			Mid_max = Smen_zu.Bou_moti_Menid_max_motome(ib);

			if (s0[Mid_min].getMenidsuu() == 0) {
				oekaki_flg = 1;
			}//menをもたない?Aド?[ナツの穴?�のSmenは境界の棒を描く
			else if (s0[Mid_max].getMenidsuu() == 0) {
				oekaki_flg = 1;
			} else if (Mid_min == Mid_max) {
				oekaki_flg = 1;
			}//一本の棒の片面だけにSmen有り
			else {
				Men_jyunban_min = 1;
				if (omote_ura == 1) {
					Men_jyunban_min = s0[Mid_min].getMenidsuu();
				}
				Men_jyunban_max = 1;
				if (omote_ura == 1) {
					Men_jyunban_max = s0[Mid_max].getMenidsuu();
				}
				if (s0[Mid_min].uekara_kazoeta_Menid(Men_jyunban_min) != s0[Mid_max].uekara_kazoeta_Menid(Men_jyunban_max)) {
					oekaki_flg = 1;
				}//この棒で隣?ﾚするSmenの1番?繧ﾌ面は異なるので?Aこの棒は描く?B
			}

			if (oekaki_flg == 1) {//棒を描く?B
				s_ob.set(Smen_zu.getmaex(ib), Smen_zu.getmaey(ib), Smen_zu.getatox(ib), Smen_zu.getatoy(ib));
				s_tv.set(camera.object2TV(s_ob));
				//g2.draw(new Line2D.Double( gx(s_tv.getax()),gy(s_tv.getay()),gx(s_tv.getbx()),gy(s_tv.getby())));
				g.drawLine(gx(s_tv.getax()), gy(s_tv.getay()), gx(s_tv.getbx()), gy(s_tv.getby())); //直??
				//g.drawLine( gx(Smen_zu.getmaex(ib)),gy(Smen_zu.getmaey(ib)),gx(Smen_zu.getatox(ib)),gy(Smen_zu.getatoy(ib))); //直??
			}


		}


		//g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);//アンチェイリアス?@オフ


		//System.out.println("?繪ｺ表?E?l?@oekaki_with_camera+++++++++++++++?ﾜ紙表示?@?I了");
		//}


		//camera中?Sを?\字で描く
		//OO.jyuuji(g,camera.object2TV(camera.get_camera_ichi()), 5.0 , 2.0 , 4);
	}

	private void fillPolygon(Graphics2D g, int id, Tensyuugou faces, Camera transform) {
		Ten t0 = new Ten();
		Ten t1 = new Ten();

		int[] x = new int[faces.getTenidsuu(id)+1];
		int[] y = new int[faces.getTenidsuu(id)+1];

		for (int i = 1; i <= faces.getTenidsuu(id) - 1; i++) {

			t0.setx(faces.getTenx(faces.getTenid(id, i)));
			t0.sety(faces.getTeny(faces.getTenid(id, i)));
			t1.set(transform.object2TV(t0));
			x[i] = gx(t1.getx());
			y[i] = gy(t1.gety());
			//x[i]=gx(Smen_zu.getTenx(Smen_zu.getTenid(im,i)));
			//y[i]=gy(Smen_zu.getTeny(Smen_zu.getTenid(im,i)));
		}

		t0.setx(faces.getTenx(faces.getTenid(id, faces.getTenidsuu(id))));
		t0.sety(faces.getTeny(faces.getTenid(id, faces.getTenidsuu(id))));
		t1.set(transform.object2TV(t0));
		x[0] = gx(t1.getx());
		y[0] = gy(t1.gety());
		//x[0]=gx(Smen_zu.getTenx(Smen_zu.getTenid(im,Smen_zu.getTenidsuu(im))));
		//y[0]=gy(Smen_zu.getTeny(Smen_zu.getTenid(im,Smen_zu.getTenidsuu(im))));

		//?ﾜり?繧ｪり?}を描くときのim番目のSmenの多角形の頂点の?ﾀ標?iPC表示???jを??めるのはここまで

		g.fill(new Polygon(x, y, faces.getTenidsuu(id)));
	}


	//---------------------------------------------------------
	public void oekaki_jyuuji_with_camera(Graphics g) {
		//System.out.println("?ﾜり?繧ｪり?}の動かし中?Sの?\字表示");
		//System.out.println("?繪ｺ表?E?l?@oekaki_jyuuji_with_camera+++++++++++++++?ﾜり?繧ｪり?}の動かし中?Sの?\字表示");
		OritaOekaki OO = new OritaOekaki();

		//camera中?Sを?\字で描く
		OO.jyuuji(g, camera.object2TV(camera.get_camera_ichi()), 5.0, 2.0, 4);
	}


	//---------------------------------------------------------

	public void change_i_kage() {

		i_kage = i_kage + 1;
		if (i_kage >= 2) {
			i_kage = 0;
		}

	}


	//---------------------------------------------------------

	public int bou_no_bangou_kara_kagenoaru_Smen_no_bangou_wo_motomeru(int ib, Tensyuugou Smen_zu, int omote_ura) {//棒の番??から?Aその棒の影が発?ｶするSmen の番??を??める?B影が発?ｶしない???�は0を返す?B

		int i_return = 0;

		int Mid_min, Mid_max; //棒の両側のSmenの番??の?ｬさいほうがMid_min,?@大きいほうがMid_max
		int Men_jyunban_min, Men_jyunban_max;//PC画面に表示したときSmen(Mid_min) で見える面の?AそのSmenでの?dなり?�がMen_jyunban_min?ASmen(Mid_max) で見える面のそのSmenでの?dなり?�がMen_jyunban_max

		Mid_min = Smen_zu.Bou_moti_Menid_min_motome(ib);//棒ibを境界として含む面(?ﾅ大で2面ある)のうちでMenidの?ｬさいほうのMenidを返す?B棒を境界として含む面が無い???�は0を返す
		Mid_max = Smen_zu.Bou_moti_Menid_max_motome(ib);

		if (s0[Mid_min].getMenidsuu() == 0) {
			return 0;
		}//menをもたない?Aド?[ナツの穴?�のSmenとの境界の棒には影なし
		if (s0[Mid_max].getMenidsuu() == 0) {
			return 0;
		}//menをもたない?Aド?[ナツの穴?�のSmenとの境界の棒には影なし
		if (Mid_min == Mid_max) {
			return 0;
		}//一本の棒の片面だけにSmen有り

		Men_jyunban_min = 1;
		if (omote_ura == 1) {
			Men_jyunban_min = s0[Mid_min].getMenidsuu();
		}
		Men_jyunban_max = 1;
		if (omote_ura == 1) {
			Men_jyunban_max = s0[Mid_max].getMenidsuu();
		}

		int Mid_min_mieteru_men_id = s0[Mid_min].uekara_kazoeta_Menid(Men_jyunban_min);
		int Mid_max_mieteru_men_id = s0[Mid_max].uekara_kazoeta_Menid(Men_jyunban_max);
		if (Mid_min_mieteru_men_id == Mid_max_mieteru_men_id) {
			return 0;
		}//この棒で隣?ﾚするSmenで見えてる面が同じなので?A棒自体が描かれず影もなし?B


		//Jyougehyou
		//public int get(int i,int j){return jg[i][j];}
		//?@jg[i][j]が1なら面iは面jの?繿､?B0なら下側?B
		//  jg[i][j]が-50なら?A面iとjは?dなが?A?繪ｺ関係は決められていない?B
		//jg[i][j]が-100なら?A面iとjは?dなるところがない?B
		if (jg.get(Mid_min_mieteru_men_id, Mid_max_mieteru_men_id) == -50) {
			return 0;
		}//この棒で隣?ﾚするSmenで見えてる面の?繪ｺ関係不明なので?A影はなし
		if (jg.get(Mid_min_mieteru_men_id, Mid_max_mieteru_men_id) == -100) {
			return 0;
		}//この棒で隣?ﾚするSmenで見えてる面の?繪ｺ関係ない?i?dならない?jので?A影はなし

		i_return = Mid_min;
		if (jg.get(Mid_min_mieteru_men_id, Mid_max_mieteru_men_id) == 1) {
			i_return = Mid_max;
		}

		if (omote_ura == 1) {
			if (i_return == Mid_min) {
				return Mid_max;
			} else if (i_return == Mid_max) {
				return Mid_min;
			}
		}

		return i_return;
	}

// -----------------------------

	private void rating() {
		int jgms = jg.getMensuu();
		Random rand = new Random();
		double dr = 0.0;
		double[] men_r = new double[jgms + 1];
		men_rating = men_r;

		for (int im = 1; im <= jgms; im++) {
			men_rating[im] = 10000.0;
		}

/*
		//------------------------------------------------------------------------------
		double katen=100.0;//加点
		for (int ism=1; ism<=Smensuu; ism++ ){
			int Mensuu=	s0[ism].getMenidsuu();//Smenでの面??
			for (int jyunban=1; jyunban<=Mensuu; jyunban++ ){
				int im=	s0[ism].uekara_kazoeta_Menid(jyunban);
				men_rating[im]=men_rating[im]+(double)(Mensuu-2*jyunban+1)*katen;
			}
		}
		//------------------------------------------------------------------------------
*/


		for (int j = 1; j <= 100; j++) {

			//------------------------------------------------------------

			for (int i = 1; i <= 10; i++) {
				for (int ia = 1; ia <= jg.getMensuu(); ia++) {
					for (int ib = 1; ib <= jg.getMensuu(); ib++) {
						//ia=rand.nextInt(jgms)+1 ;
						//ib=rand.nextInt(jgms)+1 ;
						if (ia != ib) {
							if (jg.get(ia, ib) == 1) {//wikiのイ??レ?[ティングの?ｫ棋クラブ24参?ﾆ
								dr = 12.0 + (men_rating[ib] - men_rating[ia]) * 0.04;
								if (dr < 1.0) {
									dr = 1.0;
								}
								if (dr > 31.0) {
									dr = 31.0;
								}
								men_rating[ia] = men_rating[ia] + dr;
								men_rating[ib] = men_rating[ib] - dr;
							} else if (jg.get(ia, ib) == 0) {
								dr = 12.0 + (men_rating[ia] - men_rating[ib]) * 0.04;
								if (dr < 1.0) {
									dr = 1.0;
								}
								if (dr > 31.0) {
									dr = 31.0;
								}
								men_rating[ia] = men_rating[ia] - dr;
								men_rating[ib] = men_rating[ib] + dr;
							}
						}
					}
				}
			}

/*			//------------------------------------------------------------

			for (int i=1; i<=10*jgms*jgms; i++ ){
				int ia;int ib;
			//for (int iaa=1; iaa<=jg.getMensuu(); iaa++ ){


				//for (int ibb=1; ibb<=jg.getMensuu(); ibb++ ){
					ia=rand.nextInt(jgms)+1 ;
					ib=rand.nextInt(jgms)+1 ;

					if(ia != ib){
						if(jg.get(ia,ib)==1){//wikiのイ??レ?[ティングの?ｫ棋クラブ24参?ﾆ
							dr=12.0+( men_rating[ib]-men_rating[ia]   )*0.04;
							if(dr<1.0){dr=1.0;}
							if(dr>31.0){dr=31.0;}
							men_rating[ia]=men_rating[ia]+dr;
							men_rating[ib]=men_rating[ib]-dr;
						}else if(jg.get(ia,ib)==0){
							dr=12.0+( men_rating[ia]-men_rating[ib]   )*0.04;
							if(dr<1.0){dr=1.0;}
							if(dr>31.0){dr=31.0;}
							men_rating[ia]=men_rating[ia]-dr;
							men_rating[ib]=men_rating[ib]+dr;
						}


					}
				//}

			//}
			}
*/
			//------------------------------------------------------------


		}


		//System.out.println("jg.getMensuu() = "+jg.getMensuu());

		nbox.reset();
		for (int i = 1; i <= jg.getMensuu(); i++) {
			nbox.ire_i_tiisaijyun(new int_double(i, men_rating[i]));
		}
		//System.out.println("jg.getMensuu() = "+jg.getMensuu());
		//for (int i=1; i<=10; i++ ){nbox.ire_i_tiisaijyun(new int_double( 1  , 3.0 ));	}
	}


//-----------------------------------

	int makesuu0no_menno_kazu = 0;//?繧ﾉ他の面がない?�態で?�位付けできる面の??
	int makesuu1ijyouno_menno_kazu = 0;//?繧ﾉ他の面が1以?繧?る?�態でないと?�位付けできない面の??

	private void rating2() {
		int jgms = jg.getMensuu();//面の???狽��?める?B
//System.out.println("*********  rating2()   *************");
		double[] men_r = new double[jgms + 1];
		men_rating = men_r;

		int[] i_m_r = new int[jgms + 1];//各面の?ｮ?買??[ティング?irating2()で使う?j?j
		i_men_rating = i_m_r;


		makesuu0no_menno_kazu = 0;//?繧ﾉ他の面がない?�態で?�位付けできる面の??
		makesuu1ijyouno_menno_kazu = 0;//?繧ﾉ他の面が1以?繧?る?�態でないと?�位付けできない面の??


		for (int i = 0; i <= jgms; i++) {
			i_men_rating[i] = 0;
		}


//s面の１から?�に一番?繧ﾉある面を??める?iレ?[トがついた面は?怩ｭ?j?B
//s面の１から?�にその面の?繧ﾉある面???iレ?[トがついた面は?怩ｭ?jを??め?A??計を??める
//その面の?繧ﾌある面???iレ?[トがついた面は?怩ｭ?jが?ﾅ?ｬの面を??めレ?[トをつける


		for (int i = 1; i <= jgms; i++) {
			int i_rate = 1 + jgms - i;


			int top_men_id = get_top_men_id_without_rated_men();

//System.out.println("*********  rating2()   rating = "+i_rate+"   top_men_id = "+top_men_id);

			i_men_rating[top_men_id] = i_rate;
			men_rating[top_men_id] = i_rate;
		}

//System.out.println("*********  rating2()   end *************");


		System.out.println("?繧ﾉ他の面がない?�態で?�位付けできた面の?? = " + makesuu0no_menno_kazu);
		System.out.println("?繧ﾉ他の面が1以?繧?る?�態で?�位付けした面の?? = " + makesuu1ijyouno_menno_kazu);











/*

		Random rand = new Random();
		double dr=0.0;
		double men_r[]= new double[jgms+1]; ;
		men_rating=men_r;

		for (int im=1; im<=jgms; im++ ){ men_rating[im]=10000.0;}
*/
/*
		//------------------------------------------------------------------------------
		double katen=100.0;//加点
		for (int ism=1; ism<=Smensuu; ism++ ){
			int Mensuu=	s0[ism].getMenidsuu();//Smenでの面??
			for (int jyunban=1; jyunban<=Mensuu; jyunban++ ){
				int im=	s0[ism].uekara_kazoeta_Menid(jyunban);
				men_rating[im]=men_rating[im]+(double)(Mensuu-2*jyunban+1)*katen;
			}
		}
		//------------------------------------------------------------------------------
*/

/*
		for (int j=1; j<=100; j++ ){

			//------------------------------------------------------------

			for (int i=1; i<=10; i++ ){
				for (int ia=1; ia<=jg.getMensuu(); ia++ ){
					for (int ib=1; ib<=jg.getMensuu(); ib++ ){
						//ia=rand.nextInt(jgms)+1 ;
						//ib=rand.nextInt(jgms)+1 ;
						if(ia != ib){
							if(jg.get(ia,ib)==1){//wikiのイ??レ?[ティングの?ｫ棋クラブ24参?ﾆ
								dr=12.0+( men_rating[ib]-men_rating[ia]   )*0.04;
								if(dr<1.0){dr=1.0;}
								if(dr>31.0){dr=31.0;}
								men_rating[ia]=men_rating[ia]+dr;
								men_rating[ib]=men_rating[ib]-dr;
							}else if(jg.get(ia,ib)==0){
								dr=12.0+( men_rating[ia]-men_rating[ib]   )*0.04;
								if(dr<1.0){dr=1.0;}
								if(dr>31.0){dr=31.0;}
								men_rating[ia]=men_rating[ia]-dr;
								men_rating[ib]=men_rating[ib]+dr;
							}
						}
					}
				}
			}
*/
/*			//------------------------------------------------------------

			for (int i=1; i<=10*jgms*jgms; i++ ){
				int ia;int ib;
			//for (int iaa=1; iaa<=jg.getMensuu(); iaa++ ){


				//for (int ibb=1; ibb<=jg.getMensuu(); ibb++ ){
					ia=rand.nextInt(jgms)+1 ;
					ib=rand.nextInt(jgms)+1 ;

					if(ia != ib){
						if(jg.get(ia,ib)==1){//wikiのイ??レ?[ティングの?ｫ棋クラブ24参?ﾆ
							dr=12.0+( men_rating[ib]-men_rating[ia]   )*0.04;
							if(dr<1.0){dr=1.0;}
							if(dr>31.0){dr=31.0;}
							men_rating[ia]=men_rating[ia]+dr;
							men_rating[ib]=men_rating[ib]-dr;
						}else if(jg.get(ia,ib)==0){
							dr=12.0+( men_rating[ia]-men_rating[ib]   )*0.04;
							if(dr<1.0){dr=1.0;}
							if(dr>31.0){dr=31.0;}
							men_rating[ia]=men_rating[ia]-dr;
							men_rating[ib]=men_rating[ib]+dr;
						}


					}
				//}

			//}
			}
*/
		//------------------------------------------------------------
/*

		}


*/
		//System.out.println("jg.getMensuu() = "+jg.getMensuu());

		nbox.reset();
		for (int i = 1; i <= jg.getMensuu(); i++) {
			nbox.ire_i_tiisaijyun(new int_double(i, men_rating[i]));
		}
		//System.out.println("jg.getMensuu() = "+jg.getMensuu());
		//for (int i=1; i<=10; i++ ){nbox.ire_i_tiisaijyun(new int_double( 1  , 3.0 ));	}

	}
//------------------------------------------------------------
//以下の各関?狽ﾅはSmenとしてs0[]を使う20180305


	private int top_men_id_ga_maketa_kazu_goukei_without_rated_men = 0;

	//------------------------------------------------------------
	private int get_top_men_id_without_rated_men() {
//System.out.println("20180307*********   get_top_men_id_without_rated_men()   *************");
		int top_men_id = 0;
		top_men_id_ga_maketa_kazu_goukei_without_rated_men = jg.getMensuu() + 100;


		int jgms = jg.getMensuu();//面の???狽��?める?B

		int[] i_kentouzumi = new int[jgms + 1];//検討?ﾏみの面IDは１にする
		for (int i = 0; i <= jgms; i++) {
			i_kentouzumi[i] = 0;
		}

		for (int i = 1; i <= Smensuu; i++) {
			int s_top_id = get_s_top_id_without_rated_men(i);//各s面の?iレ?[トがついた面は?怩ｭ?j一番?繧ﾌ面?Bs_top_id=0ならそのs面にはレ?[トが未定の面はない
			//System.out.println("*********   get_top_men_id_without_rated_men()   Smen ID = "+I+"  s_top_id = "+s_top_id+  "   負け?? = "+get_maketa_kazu_goukei_without_rated_men(s_top_id));


			if (s_top_id != 0) {
				if (i_kentouzumi[s_top_id] == 0) {
					//int makesuu=get_maketa_kazu_goukei_without_rated_men(s_top_id);
					//System.out.println("*********     Smen ID = "+i+"  s_top_id = "+s_top_id+  "   負け?? = "+get_maketa_kazu_goukei_without_rated_men(s_top_id));


					int mkg = get_maketa_kazu_goukei_without_rated_men(s_top_id);
					if (mkg == 0) {
						makesuu0no_menno_kazu = makesuu0no_menno_kazu + 1;
						return s_top_id;
					}//ここは?Aこれでよいか要検討20180306
					//if(top_men_id_ga_maketa_kazu_goukei_without_rated_men>get_maketa_kazu_goukei_without_rated_men(s_top_id)){
					if (top_men_id_ga_maketa_kazu_goukei_without_rated_men > mkg) {
						//if()
						//top_men_id_ga_maketa_kazu_goukei_without_rated_men=get_maketa_kazu_goukei_without_rated_men(s_top_id);
						top_men_id_ga_maketa_kazu_goukei_without_rated_men = mkg;
						top_men_id = s_top_id;
					}
				}
			}

			i_kentouzumi[s_top_id] = 1;
		}

//System.out.println("*********   get_top_men_id_without_rated_men()   end *************");
		//makesuu0no_menno_kazu=0;//?繧ﾉ他の面がない?�態で?�位付けできる面の??
		//makesuu1ijyouno_menno_kazu=0;//?繧ﾉ他の面が1以?繧?る?�態でないと?�位付けできない面の??
		if (top_men_id_ga_maketa_kazu_goukei_without_rated_men == 0) {
			makesuu0no_menno_kazu = makesuu0no_menno_kazu + 1;
		} else if (top_men_id_ga_maketa_kazu_goukei_without_rated_men > 0) {
			makesuu1ijyouno_menno_kazu = makesuu1ijyouno_menno_kazu + 1;
		}


//System.out.println("*?繧ﾉ他の面がない?�態で?�位付けできた面の?? = "+makesuu0no_menno_kazu);
//System.out.println("*?繧ﾉ他の面が1以?繧?る?�態で?�位付けした面の?? = "+makesuu1ijyouno_menno_kazu);


		return top_men_id;
	}

//-----------------------------------

	private int get_s_top_id_without_rated_men(int ism) {//ismはs面のid
//System.out.println("*********   get_s_top_id_without_rated_men   *************");
		int Mensuu = s0[ism].getMenidsuu();//Smenでの面??//Smen s0[];//Smen_zuから得られるSmen
		for (int jyunban = 1; jyunban <= Mensuu; jyunban++) {
			int im = s0[ism].uekara_kazoeta_Menid(jyunban);
			if (i_men_rating[im] == 0) {
				return im;
			}
		}
		return 0;
	}

// -----------------------------

	private int get_maketa_kazu_goukei_without_rated_men(int men_id) {
//System.out.println("*********   get_maketa_kazu_goukei_without_rated_men   *************");
		int i_make = 0;
		for (int ism = 1; ism <= Smensuu; ism++) {
			i_make = i_make + get_smen_de_maketa_kazu_without_rated_men(ism, men_id);
			if (i_make >= top_men_id_ga_maketa_kazu_goukei_without_rated_men) {
				return i_make;
			}//20180306?ｑｬ化のためこの１?sを入れているが?A本当に効果があるかは不明?Bこの?sだけコ??ントアウトしても?ｳ?�榾は動くはず?B

		}
//System.out.println("*********   get_maketa_kazu_goukei_without_rated_men   end *************");
		return i_make;
	}


	//-----------------------------------
	private int get_smen_de_maketa_kazu_without_rated_men(int ism, int men_id) {//ismはsmenのid
//System.out.println("*********   get_smen_de_maketa_kazu_without_rated_men   *************");
		int Mensuu = s0[ism].getMenidsuu();//Smenでの面??//Smen s0[];//Smen_zuから得られるSmen
		int maketa_kazu = 0;
//System.out.println("*********   get_smen_de_maketa_kazu_without_rated_men   ********Mensuu = "+Mensuu);
//System.out.println("*********   get_smen_de_maketa_kazu_without_rated_men   ********men_id = "+men_id);

		for (int i = 1; i <= Mensuu; i++) {
			int im = s0[ism].uekara_kazoeta_Menid(i);
			if (im == men_id) {
				return maketa_kazu;
			}
			if (i_men_rating[im] == 0) {
				maketa_kazu = maketa_kazu + 1;
			}
		}
		return 0;
	}


//-----------------------------------


}     


