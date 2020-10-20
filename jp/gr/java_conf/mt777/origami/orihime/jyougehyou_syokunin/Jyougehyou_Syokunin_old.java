package jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin;

import jp.gr.java_conf.mt777.origami.dougu.camera.Camera;
import jp.gr.java_conf.mt777.origami.dougu.tensyuugou.Tensyuugou;
import jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin.jyougehyou.Jyougehyou;
import jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin.smen.Smen;
import jp.gr.java_conf.mt777.origami.orihime.tenkaizu_syokunin.Tenkaizu_Syokunin;
import jp.gr.java_conf.mt777.zukei2d.oritaoekaki.OritaOekaki;
import jp.gr.java_conf.mt777.zukei2d.senbun.Senbun;

import java.awt.*;


public class Jyougehyou_Syokunin {//?繪ｺ表?@?ﾜりたたむ前の展開?}の面が?ﾜりたたんだあとでどのような?繪ｺ関係になるかを記録し活用する
	//String c=new String();
	//int Mensuu;             //?ﾜりたたむ前の展開?}の面の?�
	Jyougehyou jg = new Jyougehyou();
	//Jyougehyou jg;// =new Jyougehyou();
	//Jyougehyou jg_syokiti =new Jyougehyou();//展開?}のみから得られる?繪ｺ関係を記録しておく?B
	int Smensuu;//Smenの?�
	int Smen_yuukou_suu;//Smenは全て調べなくても?AMenの?繪ｺ関係は網羅できる?BMenの?繪ｺ関係を網羅するのに必要なSmenの?狽ｪ優?�?�位の何番目までかをさがす?B
	int Menidsuu_max;//各Smenの�?つMenidsuuの?ﾅ大値?Bすなわち?A?ﾅも紙に?dなりが多いところの枚?�?B
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

	Camera camera = new Camera();

	public Jyougehyou_Syokunin() {
		reset();
	}    //コンストラクタ

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
	//?繪ｺ表の?炎�?ﾝ定?B展開?}に1頂点から奇?狽ﾌ?ﾜ?�がでる誤りがある?�?�0を返す?Bそれが無ければ1000を返す?B
	//展開?}に山谷?ﾜ?�の拡張による誤りがある?�?�2を返す?B

	//----------------------------------------------------------------------
/*
	public int Jyougehyou_settei  (Tenkaizu_Syokunin orite,Tensyuugou otta_Men_zu,Tensyuugou Smen_zu){//js.Jyougehyou_settei(ts1,ts2.get(),ts3.get()){
         	Smen_settei           (                  orite,           otta_Men_zu,           Smen_zu);
         return Jyougehyou_settei_2   (                  orite,           otta_Men_zu,           Smen_zu);
       }
*/
	public void Smen_settei(Tenkaizu_Syokunin orite, Tensyuugou otta_Men_zu, Tensyuugou Smen_zu) {//js.Jyougehyou_settei(ts1,ts2.get(),ts3.get());
		//面(?ﾜりたたむ前の展開?}の面のこと)の?繪ｺ表を?�る?B
		//これにはts2の�?つ点?W?�?i?ﾜりたたんだあとの面の位置関係の?�報を�?つ?jと  <-------------otta_Men_zu
		//ts3の�?つ点?W?�?i?j金?}で面を?ﾗ分割したSmenの?�報を�?つ?jを使う?B <-------------Smen_zu
		//また?Ats1の�?つ?A?ﾜったときの面の位置関係の?�報も使う?B


		System.out.println("Smenの?炎�?ﾝ定");
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
			s0[i] = new Smen();
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
					s0[i].addMenid(j)	;//ここで面番?�jは?ｬさい方が?謔ﾉ追加される?B
				}
			}
                        s0[i].setKetasuu();
		}
*/

		for (int i = 1; i <= Smensuu; i++) {
			int s0addMenidsuu = 0;
			//System.out.println("現?ﾝ?��?中のSmenは?A"+i+" / "+Smensuu );
			//for(int j=1;j<=jg.getMensuu();j++){

			for (int j = 1; j <= otta_Men_zu.getMensuu(); j++) {

				//System.out.print("現?ﾝ?��?中のSmenは?A"+i+" / "+Smensuu +"     :::     "   +j+"/"+jg.getMensuu()+"-");
				if (otta_Men_zu.kantan_naibu(Smen_naibuTen[i], j) == 2) {
					//System.out.println(j);
					s0addMenidsuu = s0addMenidsuu + 1;
					s0addMenid[s0addMenidsuu] = j;
				}

			}
			//if (s0addMenidsuu==0){
			//System.out.println("**1** 現?ﾝ?��?中のSmenは?A"+i+" / "+Smensuu+"  :::  s0addMenidsuu= "+s0addMenidsuu+" ::: 面?ﾏ= "+Smen_zu.menseki_motome(i));
			//}/////////20150308

			s0[i].setKetasuu(s0addMenidsuu);

			//System.out.println("**2**");
			for (int j = 1; j <= s0addMenidsuu; j++) {
				s0[i].setMenid(j, s0addMenid[j]);//ここで面番?�jは?ｬさい方が?謔ﾉ追加される?B
			}
			//System.out.println("**3**");
		}


//4956                     System.out.print("Smensuu = "); System.out.println(Smensuu);System.exit(0);
//ここまでで?ASmensuu??	Smen_zu.getMensuu()のままかわりなし?B
		System.out.println("各Smenに含まれる面の?狽ﾌ内で?ﾅ大のものを�?める");
		//各Smenに含まれる面の?狽ﾌ内で?ﾅ大のものを�?める?B
		Menidsuu_max = 0;
		for (int i = 1; i <= Smensuu; i++) {

			if (s0[i].getMenidsuu() > Menidsuu_max) {
				Menidsuu_max = s0[i].getMenidsuu();
			}

		}

	}


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

		int ireturn = 1000;
		jg.setMensuu(otta_Men_zu.getMensuu());

		//山?ﾜり谷?ﾜりの?�報から決定される?繪ｺ関係を?繪ｺ表に入れる
		System.out.println("山?ﾜり谷?ﾜりの?�報から決定される?繪ｺ関係を?繪ｺ表に入れる");
		int Mid_min, Mid_max;
		for (int ib = 1; ib <= orite.getBousuu(); ib++) {
			Mid_min = orite.Bou_moti_Menid_min_motome(ib);
			Mid_max = orite.Bou_moti_Menid_max_motome(ib);
			if (Mid_min != Mid_max) {//展開?}において?A棒ibの両脇に面がある
				//if(orite.getcolor(ib)==1){//?ﾔい?�で山?ﾜりを意味する
				if (otta_Men_zu.getcolor(ib) == 1) {//?ﾔい?�で山?ﾜりを意味する
					if (orite.getiMeniti(Mid_min) % 2 == 1) {//面Mid_minは基?�面と同じ向き(表面が?繧�向く)
						jg.set(Mid_min, Mid_max, 1);
						jg.set(Mid_max, Mid_min, 0);
					}
					if (orite.getiMeniti(Mid_max) % 2 == 1) {//面Mid_maxは基?�面と同じ向き(表面が?繧�向く)
						jg.set(Mid_max, Mid_min, 1);
						jg.set(Mid_min, Mid_max, 0);
					}
				}
				//if(orite.getcolor(ib)==2){//?ﾂい?�で谷?ﾜりを意味する
				if (otta_Men_zu.getcolor(ib) == 2) {//?ﾂい?�で谷?ﾜりを意味する
					if (orite.getiMeniti(Mid_min) % 2 == 1) {//面Mid_minは基?�面と同じ向き(表面が?繧�向く)
						jg.set(Mid_min, Mid_max, 0);
						jg.set(Mid_max, Mid_min, 1);
					}
					if (orite.getiMeniti(Mid_max) % 2 == 1) {//面Mid_maxは基?�面と同じ向き(表面が?繧�向く)
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


		System.out.println("等価?��?を?ﾝ定する   ");
		//等価?��?を?ﾝ定する?B棒ibの境界として隣?ﾚする2つの面im1,im2が有る?�?�?A?ﾜり?�み?�定した?�?�に
		//棒ibの一部と?dなる位置に有る面imは面im1と面im2に?繪ｺ方向で挟まれることはない?Bこのことから
		//gj[im1][im]=gj[im2][im]という等価?��?が?ｬり立つ?B
		for (int ib = 1; ib <= orite.getBousuu(); ib++) {
			Mid_min = orite.Bou_moti_Menid_min_motome(ib);
			Mid_max = orite.Bou_moti_Menid_max_motome(ib);
			if (Mid_min != Mid_max) {//展開?}において?A棒ibの両脇に面がある
				for (int im = 1; im <= jg.getMensuu(); im++) {
					if ((im != Mid_min) && (im != Mid_max)) {
						if (otta_Men_zu.kantan_totu_naibu(ib, im) == 1) {
							//下の２つのifは暫定的な?��??Bあとで置き換え予定
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
		System.out.print("３面が関与する突き抜け?��?の?�?@???@");
		System.out.println(jg.getTouka_jyoukensuu());

		//等価?��?の追加?B棒ibの境界として隣?ﾚする2つの面im1,im2が有り?A
		//また棒jbの境界として隣?ﾚする2つの面im3,im4が有り?Aibとjbが平?sで?A一部?dなる?�?�?A?ﾜり?�み?�定した?�?�に
		//棒ibの面と面jbの面がi,j,i,j?@または?@j,i,j,i?@と並ぶことはない?Bもしこれがおきたら?A
		//?ﾅ?奄ｩら3番目で間違いが起きているので?Aこの3番目のところがSmenで何桁目かを�?めて?Aこの桁を１?iめる?B
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
		System.out.print("４面が関与する突き抜け?��?の?�?@???@");
		System.out.println(jg.get_uTouka_jyoukensuu());
//5154                      System.out.print("Smensuu = "); System.out.println(Smensuu);System.exit(0);


		//追加?�定
		int ituika;

		ituika = tuika_suitei();
		if (ituika != 1000) {
			return ituika;
		}

		System.out.println("追加?�定 ?I了し?A?繪ｺ表を保存------------------------?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�");


		//*************?ﾅ?奄ﾉ?sう演繹的?�論の結果の保存**************************
		jg.jg_hozon();//山?ﾜり谷?ﾜりの?�報から決定される?繪ｺ関係を保存しておく?B
		//************************************************************************

		//Smen毎に案内?曹�?�る
		System.out.println("Smen毎に案内?曹�?�る");
		for (int i = 1; i <= Smensuu; i++) {
			//System.out.print("Smen");System.out.print(i);System.out.println("にて?B");
			s0[i].setAnnaisyo(jg);
		}

		//s0に優?�?�位をつける(このときjgの-100のところが変るところがある)
		System.out.println("Smen(s0)に優?�?�位をつける");
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
				if (s0_no_yusenjyun[is0] == 0) {//まだ優?�?�位がついていないSmenだけを扱う
					Sy = Smenid_yusendo(is0)/*+Smen_no_dokujisei[is0]*/;//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
					if (yusendo_max < Sy) {
						yusendo_max = Sy;
						i_yusen = is0;// i_yusenがi番目の優?謫xを探している?ﾛの?ﾅも有力な候補の番?�
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
		//System.out.println(Smensuu );
		//System.out.println("s0に優?�?�位をつける" );
		//for(int i=1;i<=Smensuu;i++){System.out.println(s0_no_yusenjyun[i]);}
		//System.out.println("優?謫xからs0のid" );
		for (int i = 1; i <= Smensuu; i++) {
			//System.out.println(yusenjyun_kara_s0id[i]);
			if (i_yusendo_max[yusenjyun_kara_s0id[i]] != 0) {

				Smen_yuukou_suu = i;       //�?いが変な結果になることあり?B


				//	Smen_yuukou_suu=Smensuu;//遅いが確実

//System.out.print("第");
//System.out.print(i);
//System.out.print("位(未定ペア?�??");
//System.out.print(i_yusendo_max[yusenjyun_kara_s0id[i]]);

//System.out.print("?@||?@");


			}


		}

		System.out.println();
		//

		for (int i = 1; i <= Smensuu; i++) {
			s[i] = s0[yusenjyun_kara_s0id[i]];
		}

		//優?�?�位を逆転させる?Bこれが有効かどうかは不明
		//for(int i=1;i<=Smen_yuukou_suu;i++){s[Smen_yuukou_suu-i+1]=s0[yusenjyun_kara_s0id[i]];}

/*
        for(int i=1;i<=Smensuu;i++){
                       if(i_yusendo_max[yusenjyun_kara_s0id[i]]!=0){
System.out.print("第");
System.out.print(i);
System.out.print("位(未定ペア?�??");
System.out.print(i_yusendo_max[yusenjyun_kara_s0id[i]]);
System.out.print("?A面?�??");
System.out.print(s[i].getMenidsuu());
System.out.print("?@||?@");
                        }
      }

System.out.println();
 */


		//Smenは優?�?�の何番目までやるかを決める
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


		//jg[][]の?dなりのある面の組み?�わせの位置の値を-100から-50に変える?B
		for (int k = 1; k <= Smensuu; k++) {
			for (int i = 1; i <= s[k].getMenidsuu() - 1; i++) {
				for (int j = i + 1; j <= s[k].getMenidsuu(); j++) {
					jg.set(i, j, -50);
					jg.set(j, i, -50);
				}
			}
		}
		System.out.println("?繪ｺ表?炎�?ﾝ定?I了");

		//System.out.print("面?狽ﾍ1?@");  System.out.println(s[1].getMenidsuu());
		return ireturn;


	}

	//------------------------------------------------------------
	public int tuika_suitei() {
		//山?ﾜり谷?ﾜりの?�報から?Xに決定できる関係を?яｪしていく?B

		int Mid;//3面の比較で中間にくる面
		int flg_c = 1;
		System.out.println("追加?�定開始---------------------?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�");

		while (flg_c >= 1) {
			flg_c = 0;
			System.out.println("追加?�定------------------------");
			//System.out.println("山?ﾜり谷?ﾜりの?�報から追加?�定   " );

			int flg_b = 1;
			while (flg_b >= 1) {
				flg_b = 0;

				for (int iS = 1; iS <= Smensuu; iS++) {

					int flg_a = 1;
					while (flg_a >= 1) {
						flg_a = 0;
						for (int iM = 1; iM <= s0[iS].getMenidsuu(); iM++) {//3面の比較で中間にくる面
							int[] ueMenid = new int[s0[iS].getMenidsuu() + 1];//S面に含まれるあるMenの?繧ｪわにあるid番?�を記録する?Bこれが20ということは?A
							int[] sitaMenid = new int[s0[iS].getMenidsuu() + 1];//S面に含まれるあるMenの下がわにあるid番?�を記録する?Bこれが20ということは?A
							int ueMenid_max = 0;
							int sitaMenid_max = 0;
							Mid = s0[iS].getMenid(iM);

							//?lえ方?FあるSmenのある面Midについて?lえる?B
							//このSmen以外で面Aは面Midの?繿､?A面Bは面Midの下側と決まっていたとする?B
							//一般に別?XのSmenで?A面Aは面Midの?繿､で?A面Bは面Midの下側だったからと言って?A面Aは面Bの?繿､とは決定できない?B
							//しかし?Aここがポイントだが?A面A?A面Mid?A面Bがいっしょに含まれているSmenがあるなら?AそのSmenの?繪ｺ関係がわかっていなくても
							//面Aは面Bの?繿､となる?Bだから?Aこの操?�ではあるSmenから得る?�報は３つの面がいっしょにあるかということである?B
							//あるSmen内の?繪ｺ関係は必要ない?B
							//
							//ここの操?�はあるSmenの?繪ｺ関係を?繪ｺ表から?ﾌ?Wしている?B
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

									//  System.out.print(ueMenid[iuM]);System.out.print("<-?�:下->");System.out.println(sitaMenid[isM]);


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

				//System.out.print("?яｪされた関係の?� ?? ");System.out.println(flg_b);
			}

			//
			//jg.jg_hozon();//山?ﾜり谷?ﾜりの?�報から決定される?繪ｺ関係を保存しておく?B


			//jg のreset適?ﾘに?sわれているか確認のこと

			//System.out.println ("３面が関与する突き抜け?��?から追加?�定   " );
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
							return 3;
						}
						if (jg.get(tg.getd(), tg.geta()) == 1) {
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
							return 3;
						}
						if (jg.get(tg.getd(), tg.geta()) == 0) {
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
							return 3;
						}
						if (jg.get(tg.getb(), tg.geta()) == 1) {
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
							return 3;
						}
						if (jg.get(tg.getb(), tg.geta()) == 0) {
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

//	System.out.println ("４面が関与する突き抜け?��?から追加?�定   " );
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
							return 4;
						}
						if (jg.get(b, c) == 0) {
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
							return 4;
						}
						if (jg.get(b, d) == 0) {
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
							return 4;
						}
						if (jg.get(b, c) == 1) {
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
							return 4;
						}
						if (jg.get(b, d) == 1) {
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
							return 4;
						}
						if (jg.get(b, d) == 1) {
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
							return 4;
						}
						if (jg.get(b, c) == 1) {
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
							return 4;
						}
						if (jg.get(a, d) == 1) {
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
							return 4;
						}
						if (jg.get(a, c) == 1) {
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
							return 4;
						}
						if (jg.get(d, b) == 1) {
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
							return 4;
						}
						if (jg.get(d, a) == 1) {
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
							return 4;
						}
						if (jg.get(c, b) == 1) {
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
							return 4;
						}
						if (jg.get(c, a) == 1) {
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


		System.out.println("追加?�定 ?I了------------------------?�?�?�?魔ｱこまで20150310?�?�?�?�?�?�?�?�?�?�?�");

		return 1000;

	}

	//------------------------------------------

	private int tuika_suitei_2() {
		//山?ﾜり谷?ﾜりの?�報から?Xに決定できる関係を?яｪしていく?B

		int Mid;//3面の比較で中間にくる面
		int flg_c = 1;
		System.out.println("追加?�定開始---------------------?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�");

		while (flg_c >= 1) {
			flg_c = 0;
			System.out.println("追加?�定------------------------");
			//System.out.println("山?ﾜり谷?ﾜりの?�報から追加?�定   " );

			int flg_b = 1;
			while (flg_b >= 1) {
				flg_b = 0;

				for (int iS = 1; iS <= Smensuu; iS++) {

					int flg_a = 1;
					while (flg_a >= 1) {
						flg_a = 0;
						for (int iM = 1; iM <= s0[iS].getMenidsuu(); iM++) {//3面の比較で中間にくる面
							int[] ueMenid = new int[s0[iS].getMenidsuu() + 1];//S面に含まれるあるMenの?繧ｪわにあるid番?�を記録する?Bこれが20ということは?A
							int[] sitaMenid = new int[s0[iS].getMenidsuu() + 1];//S面に含まれるあるMenの下がわにあるid番?�を記録する?Bこれが20ということは?A
							int ueMenid_max = 0;
							int sitaMenid_max = 0;
							Mid = s0[iS].getMenid(iM);

							//?lえ方?FあるSmenのある面Midについて?lえる?B
							//このSmen以外で面Aは面Midの?繿､?A面Bは面Midの下側と決まっていたとする?B
							//一般に別?XのSmenで?A面Aは面Midの?繿､で?A面Bは面Midの下側だったからと言って?A面Aは面Bの?繿､とは決定できない?B
							//しかし?Aここがポイントだが?A面A?A面Mid?A面Bがいっしょに含まれているSmenがあるなら?AそのSmenの?繪ｺ関係がわかっていなくても
							//面Aは面Bの?繿､となる?Bだから?Aこの操?�ではあるSmenから得る?�報は３つの面がいっしょにあるかということである?B
							//あるSmen内の?繪ｺ関係は必要ない?B
							//
							//ここの操?�はあるSmenの?繪ｺ関係を?繪ｺ表から?ﾌ?Wしている?B
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

									/**/      //  System.out.print(ueMenid[iuM]);System.out.print("<-?�:下->");System.out.println(sitaMenid[isM]);


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

			//System.out.print("?яｪされた関係の?� ?? ");System.out.println(flg_b);
		}


		System.out.println("追加?�定 ?I了------------------------?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�");

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

	//s0(Smen)の優?謫xを示す値を�?める?Bこの値が?ｂ｢ほうが優?謫xが?�?i配列の?謫ｪに近い?B?j
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
		int isusumu;//=0の?�?�Smenが変わる?i桁が変るようなイ�??[ジ?j?B
		int Sid;//変化が及んだSmenのid番?�
		isusumu = 0;
		//ss+1番目以?繧ﾌSmenはみな?炎�値にする?BSmenに含まれる面?狽ｪ0のときはエラ?[になる?B
//System.out.println("    js.susumu 001      ss+1番目以?繧ﾌSmenはみな?炎�値にする?B");

		for (int i = ss + 1; i <= Smensuu; i++) {

//System.out.println("    js.susumu i= "+i+"        Smensuu= "+Smensuu);

			s[i].Jyunretu_1banme();
		}
//System.out.println("    js.susumu 002      ss+1番目以?繧ﾌSmenはみな?炎�値にする?B");
		//Smenのid番?�の大きいものから?ｬさいものの?�に面の?dなり?�態を変えていく?B
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
		int isusumu;//=0の?�?�Smenが変わる?i桁が変るようなイ�??[ジ?j?B
		int Sid;//変化が及んだSmenのid番?�
		isusumu =0;
int ss; ss=getSmen_yuukou_suu();
	//ss+1番目以?繧ﾌSmenはみな?炎�値にする?B有効?蝿ﾈ?繧ﾍ使わないので?A何もしないことにする?B
//System.out.println("    js.susumu 001      ss+1番目以?繧ﾌSmenはみな?炎�値にする?B");

		//for(int i=ss+1;i<=Smensuu;i++){

//System.out.println("    js.susumu i= "+i+"        Smensuu= "+Smensuu);

		 // s[i].Jyunretu_1banme();
		//}
//System.out.println("    js.susumu 002      ss+1番目以?繧ﾌSmenはみな?炎�値にする?B");
		  //Smenのid番?�の大きいものから?ｬさいものの?�に面の?dなり?�態を変えていく?B
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
	//現?ﾝの?�列?�態から開始して?A可能な?dなりかたとなる?�態を探す?Bなお?Aここは?ｑｬ化の余地がある?B
	public int kanou_kasanari_sagasi() {      //これはjgを変えないはず?B
		int ms, Sid;
		ms = 0;

		//System.out.print("面?狽ﾍ2?@");  System.out.println(s[1].getMenidsuu());

		Sid = 1;//Sidの?炎�値は0以外ならなんでもいい?B
		while (Sid != 0) { //Sid==0なら?ASmenの?ﾅも番?�の?ｬさいものまで調べ?sくしたという意味?B

			ms = mujyun_Smen_motome();
			if (ms == 1000) {
				return 1000;
			}//全てのSmenで?A矛?ｂﾍない?B
			Sid = susumu(ms - 1);

		}
		return 0;//可能な?dなりかたとなる?�態は存?ﾝしない
	}

	//-----------------------------------------------------------------------------------------------------------------
	//?ﾜり?dなり方が矛?ｂｷるSmenを番?�の?ｬさい?�からさがす?B  なお?Aここも?ｑｬ化の余地がある?B
	private int mujyun_Smen_motome() { //jgは変化する?B
		int kks;
		jg.jg_fukugen();//<<<<<<<<<<<<<<<<<<<<<<<<<<<,,
		//for(int ss=1;ss<=Smensuu;ss++){
		for (int ss = 1; ss <= Smen_yuukou_suu; ss++) {      //<<<<<<<<<<<<<<?ｑｬ化のため変?X?B070417
			kks = s[ss].kanou_kasanari_sagasi(jg);

			if (kks == 0) {
				return ss;
			}//kks==0ということは?A可能な?dなりかた
			//となる?�列は存?ﾝしない
			s[ss].jg_ni_Smen_wo_nyuuryoku(jg);//ss番目のSmenの?繪ｺ?�報をjgに入力する?B
		}


		if (tuika_suitei() != 1000) {
			return Smen_yuukou_suu;
		} //ttttttttttt
	/*
		for(int ss=Smen_yuukou_suu+1;ss<=Smensuu;ss++){      //<<<<<<<<<<<<<<
			kks=s[ss].kanou_kasanari_sagasi(jg);

	                if(kks==0){return  Smen_yuukou_suu;}//kks==0ということは?A可能な?dなりかた
						//となる?�列は存?ﾝしない
                        s[ss].jg_ni_Smen_wo_nyuuryoku(jg);//ss番目のSmenの?繪ｺ?�報をjgに入力する?B
	        }
	*/


		return 1000;
	}

	// ---------------------------------------------------------------
	private void kanou_kasanari_kensa() {//のSmenが何通りの可能な?dなり方を�?つかを調べる?B
		for (int i = 1; i <= Smen_yuukou_suu; i++) {
			System.out.print("面?狽ﾍ?@");
			System.out.print(s[i].getMenidsuu());
			int kanou_kasanari_suu = 0;
			kanou_kasanari_suu = kanou_kasanari_kensa(i);

			System.out.print("  ?A 可能?dなり?狽ﾍ?@");
			System.out.println(kanou_kasanari_suu);
		}
	}

	private int kanou_kasanari_kensa(int i) {//のSmenが何通りの可能な?dなり方を�?つかを調べる?B
		jg.jg_fukugen();
		s[i].Jyunretu_1banme();
		System.out.print("優?�?�位");
		System.out.print(i);
		System.out.println("番の可能な?dなりの予備検?ｸ");
		//kanou_kasanari_sagasiの値は1000ならSmenが矛?ｂﾍない?�態になった?B0なら?ASmenが矛?ｂﾍない?�態では存?ﾝしない?B

		int kanou_kasanari_suu = 0;
		int kks;
		int sus;
		kks = s[i].kanou_kasanari_sagasi(jg);

		if (kks == 0) {
			return kanou_kasanari_suu;
		}
		kanou_kasanari_suu = kanou_kasanari_suu + 1;
		//System.out.print("可能?dなり?�?@");System.out.println(kanou_kasanari_suu);
		sus = s[i].susumu(s[i].getMenidsuu());
		while (sus != 0) {
			kks = s[i].kanou_kasanari_sagasi(jg);


			if (kks == 0) {
				return kanou_kasanari_suu;
			}

			kanou_kasanari_suu = kanou_kasanari_suu + 1;
			//System.out.print("可能?dなり?�?@");System.out.println(kanou_kasanari_suu);

			sus = s[i].susumu(s[i].getMenidsuu());
		}
		return kanou_kasanari_suu;

	}

	//?@ここは  class Jyougehyou_Syokunin  の中です?B
	//-----------------------------------------------------
	public void set_hyouji_yousiki(int i) {
		hyouji_yousiki = i;
	}


	//?}をかく?ﾛの?白l変換用関?�-----------------------------------------------------------------

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

	public void oekaki(Graphics g, Tenkaizu_Syokunin orite, Tensyuugou otta_Men_zu, Tensyuugou Smen_zu, int omote_ura, int hyouji_flg) {


		//hyouji_flgは?ﾜり?繧ｪり?}の表示様式の指定?B4なら実?ﾛに?ﾜり紙を?ﾜった?�?�と同じ?B3なら透過?}
		String text = "";//文字列?��?用のクラスのインスタンス化
		ip1 = omote_ura;
		//  System.out.println(Smensuu);
		for (int im = 1; im <= Smensuu; im++) { //Smenから?繧ｩらの指定した番目の面のidを�?める?B
			s0[im].set_Menid2uekara_kazoeta_iti(jg);
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
				if (Mid_min == Mid_max) {//この棒は境界?�なのでこの棒は描く?B
					g.drawLine(gx(Smen_zu.getmaex(ib)), gy(Smen_zu.getmaey(ib)), gx(Smen_zu.getatox(ib)), gy(Smen_zu.getatoy(ib))); //直?�
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
					g.drawLine(gx(Smen_zu.getmaex(ib)), gy(Smen_zu.getmaey(ib)), gx(Smen_zu.getatox(ib)), gy(Smen_zu.getatoy(ib))); //直?�
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
				g.drawLine(gx(Smen_zu.getmaex(ib)), gy(Smen_zu.getmaey(ib)), gx(Smen_zu.getatox(ib)), gy(Smen_zu.getatoy(ib))); //直?�
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
                         	g.drawLine( gx(otta_Men_zu.getmaex(ib)),gy(otta_Men_zu.getmaey(ib)),gx(otta_Men_zu.getatox(ib)),gy(otta_Men_zu.getatoy(ib))); //直?�
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
				im = yusenjyun_kara_s0id[iu]; //Smenの優?�?�位
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

	public void oekaki_with_camera(Graphics g, Tenkaizu_Syokunin orite, Tensyuugou otta_Men_zu, Tensyuugou Smen_zu, int omote_ura, int hyouji_flg) {


		//hyouji_flgは?ﾜり?繧ｪり?}の表示様式の指定?B4なら実?ﾛに?ﾜり紙を?ﾜった?�?�と同じ?B3なら透過?}
		OritaOekaki OO = new OritaOekaki();
		Ten t0 = new Ten();
		Ten t1 = new Ten();
		Senbun s_ob = new Senbun();
		Senbun s_tv = new Senbun();
		String text = "";//文字列?��?用のクラスのインスタンス化
		ip1 = omote_ura;
		//  System.out.println(Smensuu);

		//面を描く
		int[] x = new int[100];
		int[] y = new int[100];


		if (hyouji_flg == 5) {//?ﾜ紙表示---------------------------------------------------------------------------

			for (int im = 1; im <= Smensuu; im++) { //Smenから?繧ｩらの指定した番目の面のidを�?める?B
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
				Mid_min = Smen_zu.Bou_moti_Menid_min_motome(ib);//棒ibを境界として含む面(?ﾅ大で2面ある)のうちでMenidの?ｬさいほうのMenidを返す?B棒を境界として含む面が無い?�?�は0を返す
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
					g.drawLine(gx(s_tv.getax()), gy(s_tv.getay()), gx(s_tv.getbx()), gy(s_tv.getby())); //直?�
					//g.drawLine( gx(Smen_zu.getmaex(ib)),gy(Smen_zu.getmaey(ib)),gx(Smen_zu.getatox(ib)),gy(Smen_zu.getatoy(ib))); //直?�
				}


			}
			//System.out.println("?繪ｺ表?E?l?@oekaki_with_camera+++++++++++++++?ﾜ紙表示?@?I了");
		}


//System.out.println("?繪ｺ表?E?l?@oekaki_with_camera+++++++++++++++hyouji_yousiki = "+hyouji_yousiki);

		//表示様式１Smenを描く
		if (hyouji_yousiki == 1) {
			for (int iu = 1; iu <= Smen_yuukou_suu; iu++) {
				int im;
				im = yusenjyun_kara_s0id[iu]; //Smenの優?�?�位
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


	//---------------------------------------------------------
	public void oekaki_toukazu_with_camera(Graphics g, Tenkaizu_Syokunin orite, Tensyuugou otta_Men_zu, Tensyuugou Smen_zu, int omote_ura) {
		//System.out.println("Smen透過表示003");
		//System.out.println("?繪ｺ表?E?l?@oekaki_with_camera+++++++++++++++透過表示");
		OritaOekaki OO = new OritaOekaki();
		Ten t0 = new Ten();
		Ten t1 = new Ten();
		Senbun s_ob = new Senbun();
		Senbun s_tv = new Senbun();
		String text = "";//文字列?��?用のクラスのインスタンス化

		//面を描く
		int[] x = new int[100];
		int[] y = new int[100];

		int col_hiku = 0;
		int colmax = 255;
		int colmin = 30;//colmax=255(?^っ白)以下?Acolmin=0(?^っ?�)以?�
		//Menidsuu_maxは1以?繧ﾅあること
		if (Menidsuu_max > 0) {
			col_hiku = (colmax - colmin) / Menidsuu_max;
		}
//if(Menidsuu_max<=0){System.out.println("?繪ｺ表?E?l?@oekaki_toukazu_with_camera!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!    Menidsuu_max<=0  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");}

		int col_kosa;

		//面を描く
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

		g.setColor(Color.black);

		//棒を描く
		int Mid_min, Mid_max;
		int Men_jyunban_min, Men_jyunban_max;
		for (int ib = 1; ib <= Smen_zu.getBousuu(); ib++) {
			s_ob.set(Smen_zu.getmaex(ib), Smen_zu.getmaey(ib), Smen_zu.getatox(ib), Smen_zu.getatoy(ib));
			s_tv.set(camera.object2TV(s_ob));
			g.drawLine(gx(s_tv.getax()), gy(s_tv.getay()), gx(s_tv.getbx()), gy(s_tv.getby())); //直?�
		}

		//camera中?Sを?\字で描く
		OO.jyuuji(g, camera.object2TV(camera.get_camera_ichi()), 5.0, 2.0, 4);
	}


	//---------------------------------------------------------

	Color F_color = new Color(255, 255, 50);//表面の?F
	Color B_color = new Color(233, 233, 233);//裏面の?F

	public void set_F_color(Color color0) {
		F_color = color0;
	}

	//---------------------------------------------------------

	public void oekaki_oriagarizu_with_camera(Graphics g, Tenkaizu_Syokunin orite, Tensyuugou otta_Men_zu, Tensyuugou Smen_zu, int omote_ura) {
		//System.out.println("?繪ｺ表?E?l?@oekaki_with_camera+++++++++++++++?ﾜ紙表示?@面を描く");
		OritaOekaki OO = new OritaOekaki();
		Ten t0 = new Ten();
		Ten t1 = new Ten();
		Senbun s_ob = new Senbun();
		Senbun s_tv = new Senbun();
		String text = "";//文字列?��?用のクラスのインスタンス化
		ip1 = omote_ura;
		//  System.out.println(Smensuu);

		//面を描く
		int[] x = new int[100];
		int[] y = new int[100];


		//if(hyouji_flg==5){//?ﾜ紙表示---------------------------------------------------------------------------

		for (int im = 1; im <= Smensuu; im++) { //Smenから?繧ｩらの指定した番目の面のidを�?める?B
			s0[im].set_Menid2uekara_kazoeta_iti(jg);
		}


		//面を描く

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

				//if(orite.getiMeniti(s0[im].uekara_kazoeta_Menid(Men_jyunban))%2==1){g.setColor(F_color);}
				//if(orite.getiMeniti(s0[im].uekara_kazoeta_Menid(Men_jyunban))%2==0){g.setColor(B_color);}

				if (omote_ura == 1) {
					if (orite.getiMeniti(s0[im].uekara_kazoeta_Menid(Men_jyunban)) % 2 == 0) {
						g.setColor(new Color(255, 255, 50));
					}
					if (orite.getiMeniti(s0[im].uekara_kazoeta_Menid(Men_jyunban)) % 2 == 1) {
						g.setColor(new Color(233, 233, 233));
					}
				}
				g.setColor(F_color);
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
			Mid_min = Smen_zu.Bou_moti_Menid_min_motome(ib);//棒ibを境界として含む面(?ﾅ大で2面ある)のうちでMenidの?ｬさいほうのMenidを返す?B棒を境界として含む面が無い?�?�は0を返す
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
				g.drawLine(gx(s_tv.getax()), gy(s_tv.getay()), gx(s_tv.getbx()), gy(s_tv.getby())); //直?�
				//g.drawLine( gx(Smen_zu.getmaex(ib)),gy(Smen_zu.getmaey(ib)),gx(Smen_zu.getatox(ib)),gy(Smen_zu.getatoy(ib))); //直?�
			}


		}
		//System.out.println("?繪ｺ表?E?l?@oekaki_with_camera+++++++++++++++?ﾜ紙表示?@?I了");
		//}


		//camera中?Sを?\字で描く
		OO.jyuuji(g, camera.object2TV(camera.get_camera_ichi()), 5.0, 2.0, 4);
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


}     


