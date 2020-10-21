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


public class Jyougehyou_Syokunin {//?ã‰º•\?@?Ü‚è‚½‚½‚Þ‘O‚Ì“WŠJ?}‚Ì–Ê‚ª?Ü‚è‚½‚½‚ñ‚¾‚ ‚Æ‚Å‚Ç‚Ì‚æ‚¤‚È?ã‰ºŠÖŒW‚É‚È‚é‚©‚ð‹L˜^‚µŠˆ—p‚·‚é
	//String c=new String();
	//int Mensuu;             //?Ü‚è‚½‚½‚Þ‘O‚Ì“WŠJ?}‚Ì–Ê‚Ì?? 
	Jyougehyou jg = new Jyougehyou();
	Touka_jyouken errorPos = null;
	//Jyougehyou jg;// =new Jyougehyou();
	//Jyougehyou jg_syokiti =new Jyougehyou();//“WŠJ?}‚Ì‚Ý‚©‚ç“¾‚ç‚ê‚é?ã‰ºŠÖŒW‚ð‹L˜^‚µ‚Ä‚¨‚­?B
	int Smensuu;//Smen‚Ì??
	int Smen_yuukou_suu;//Smen‚Í‘S‚Ä’²‚×‚È‚­‚Ä‚à?AMen‚Ì?ã‰ºŠÖŒW‚Í–Ô—…‚Å‚«‚é?BMen‚Ì?ã‰ºŠÖŒW‚ð–Ô—…‚·‚é‚Ì‚É•K—v‚ÈSmen‚Ì?”‚ª—D???‡ˆÊ‚Ì‰½”Ô–Ú‚Ü‚Å‚©‚ð‚³‚ª‚·?B
	int Menidsuu_max;//ŠeSmen‚Ì??‚ÂMenidsuu‚Ì?Å‘å’l?B‚·‚È‚í‚¿?A?Å‚àŽ†‚É?d‚È‚è‚ª‘½‚¢‚Æ‚±‚ë‚Ì–‡???B
	//paint —p‚ÌintŠi”[—pVVVVVVVVVVVVVVVVVVVVVV
	int ip1 = 0; //0‚Í?Ü‚è?ô‚Ý?}‚Ì•\‘¤‚ð•\Ž¦‚·‚éƒ‚?[ƒh?B1‚Í?Ü‚è?ô‚Ý?}‚Ì— ‘¤‚ð•\Ž¦‚·‚éƒ‚?[ƒh?B
	// int ip1,ip2,ip3,ip4,ip5;
	int hyouji_yousiki = 0;//•\Ž¦—lŽ®‚ÌŽw’è
	//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
	//  jg[][]‚Í?Ü‚é‘O‚Ì“WŠJ?}‚Ì‚·‚×‚Ä‚Ì–Ê“¯Žm‚Ì?ã‰ºŠÖŒW‚ð1‚Â‚Ì•\‚É‚Ü‚Æ‚ß‚½‚à‚Ì‚Æ‚µ‚Äˆµ‚¤
	//?@jg[i][j]‚ª1‚È‚ç–Êi‚Í–Êj‚Ì?ã‘¤?B0‚È‚ç‰º‘¤?B
	//  jg[i][j]‚ª-50‚È‚ç?A–Êi‚Æj‚Í?d‚È‚ª?A?ã‰ºŠÖŒW‚ÍŒˆ‚ß‚ç‚ê‚Ä‚¢‚È‚¢?B
	//jg[i][j]‚ª-100‚È‚ç?A–Êi‚Æj‚Í?d‚È‚é‚Æ‚±‚ë‚ª‚È‚¢?B

	Smen[] s0;//Smen_zu‚©‚ç“¾‚ç‚ê‚éSmen
	Smen[] s;//s‚Í—D?æ“x‚Ì?‚‚¢?‡‚És0‚ð•À‚×‘Ö‚¦‚½‚à‚Ì?B
	int[] s0_no_yusenjyun;
	int[] yusenjyun_kara_s0id;

	int i_kage = 0; //‰e‚ð•\Ž¦‚·‚é‚©‚Ç‚¤‚©?B0‚Í•\Ž¦‚µ‚È‚¢?A1‚Í•\Ž¦‚·‚é

	Camera camera = new Camera();

	ap orihime_ap;
	Moji_sousa ms = new Moji_sousa();


	public double[] men_rating;
	public int[] i_men_rating;

	public Narabebako_int_double nbox = new Narabebako_int_double();//20180227?@nbox‚É‚Ímen‚Ìid‚ªmen_rating‚Æ‘g‚É‚È‚Á‚Ä?Amen_rating‚Ì?¬‚³‚¢?‡‚É•À‚×‘Ö‚¦‚ç‚ê‚Ä“ü‚Á‚Ä‚¢‚é?B


	//-----------------------------------------------------------------
	public Jyougehyou_Syokunin() {
		reset();
	}    //ƒRƒ“ƒXƒgƒ‰ƒNƒ^

	//-----------------------------------------------------------------
	public Jyougehyou_Syokunin(ap ap0) {
		orihime_ap = ap0;
		reset();
	}    //ƒRƒ“ƒXƒgƒ‰ƒNƒ^

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

	//?@‚±‚±‚Í  class Jyougehyou_Syokunin  ‚Ì’†‚Å‚·?B
	//?ã‰º•\‚Ì?‰Š??Ý’è?B“WŠJ?}‚É1’¸“_‚©‚çŠï?”‚Ì?Ü??‚ª‚Å‚éŒë‚è‚ª‚ ‚é????0‚ð•Ô‚·?B‚»‚ê‚ª–³‚¯‚ê‚Î1000‚ð•Ô‚·?B
	//“WŠJ?}‚ÉŽR’J?Ü??‚ÌŠg’£‚É‚æ‚éŒë‚è‚ª‚ ‚é????2‚ð•Ô‚·?B

	//----------------------------------------------------------------------
/*
	public int Jyougehyou_settei  (Tenkaizu_Syokunin orite,Tensyuugou otta_Men_zu,Tensyuugou Smen_zu){//js.Jyougehyou_settei(ts1,ts2.get(),ts3.get()){
         	Smen_settei           (                  orite,           otta_Men_zu,           Smen_zu);
         return Jyougehyou_settei_2   (                  orite,           otta_Men_zu,           Smen_zu);
       }
*/
	public void Smen_settei(Tenkaizu_Syokunin orite, Tensyuugou otta_Men_zu, Tensyuugou Smen_zu) {//js.Jyougehyou_settei(ts1,ts2.get(),ts3.get());
		//–Ê(?Ü‚è‚½‚½‚Þ‘O‚Ì“WŠJ?}‚Ì–Ê‚Ì‚±‚Æ)‚Ì?ã‰º•\‚ð??‚é?B
		//‚±‚ê‚É‚Íts2‚Ì??‚Â“_?W???i?Ü‚è‚½‚½‚ñ‚¾‚ ‚Æ‚Ì–Ê‚ÌˆÊ’uŠÖŒW‚Ì?û±ñ‚ðŽ?‚Â?j‚Æ  <-------------otta_Men_zu
		//ts3‚Ì??‚Â“_?W???i?j‹à?}‚Å–Ê‚ð?×•ªŠ„‚µ‚½Smen‚Ì?û±ñ‚ðŽ?‚Â?j‚ðŽg‚¤?B <-------------Smen_zu
		//‚Ü‚½?Ats1‚Ì??‚Â?A?Ü‚Á‚½‚Æ‚«‚Ì–Ê‚ÌˆÊ’uŠÖŒW‚Ì?û±ñ‚àŽg‚¤?B


		System.out.println("Smen‚Ì?‰Š??Ý’è");
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

		//ŠeSmen‚ÉŠÜ‚Ü‚ê‚é–Ê‚ð‹L˜^‚·‚é?B
		System.out.println("ŠeSmen‚ÉŠÜ‚Ü‚ê‚é–Ê‚ð‹L˜^‚·‚é‚½‚ß?AŠeSmen‚Ì“à•”“_‚ð“o˜^");
		Ten[] Smen_naibuTen = new Ten[Smensuu + 1];  //<<<<<<<<<<<<<<<<<<<<<<<<<<<ƒIƒuƒWƒFƒNƒg‚Ì”z—ñ‚ð“®“I‚ÉŽw’è
		for (int i = 1; i <= Smensuu; i++) {
			Smen_naibuTen[i] = Smen_zu.naibuTen_motome(i);
		}

		System.out.println("ŠeSmen‚ÉŠÜ‚Ü‚ê‚é–Ê‚ð‹L˜^‚·‚é");
		otta_Men_zu.BouMenMaxMinZahyou();//tttttttttt

		int[] s0addMenid = new int[otta_Men_zu.getMensuu() + 1];  //Smen‚É’Ç‰Á‚·‚é–Ê‚ðˆêŽž‹L˜^‚µ‚Ä‚¨‚­

/*
		for(int i=1;i<=Smensuu;i++){
		       int s0addMenidsuu=0;

			for(int j=1;j<=jg.getMensuu();j++){
				//if(otta_Men_zu.naibu(Smen_zu.naibuTen_motome(i),j)==2){
				if(otta_Men_zu.kantan_naibu(Smen_naibuTen[i],j)==2){
					s0[i].addMenid(j)	;//‚±‚±‚Å–Ê”Ô??j‚Í?¬‚³‚¢•û‚ª?æ‚É’Ç‰Á‚³‚ê‚é?B
				}
			}
                        s0[i].setKetasuu();
		}
*/

		for (int i = 1; i <= Smensuu; i++) {
			int s0addMenidsuu = 0;
			//System.out.println("Œ»?Ý????’†‚ÌSmen‚Í?A"+i+" / "+Smensuu );
			//for(int j=1;j<=jg.getMensuu();j++){

			for (int j = 1; j <= otta_Men_zu.getMensuu(); j++) {

				//System.out.print("Œ»?Ý????’†‚ÌSmen‚Í?A"+i+" / "+Smensuu +"     :::     "   +j+"/"+jg.getMensuu()+"-");
				if (otta_Men_zu.kantan_naibu(Smen_naibuTen[i], j) == 2) {
					//System.out.println(j);
					s0addMenidsuu = s0addMenidsuu + 1;
					s0addMenid[s0addMenidsuu] = j;
				}

			}
			//if (s0addMenidsuu==0){
			//System.out.println("**1** Œ»?Ý????’†‚ÌSmen‚Í?A"+i+" / "+Smensuu+"  :::  s0addMenidsuu= "+s0addMenidsuu+" ::: –Ê?Ï= "+Smen_zu.menseki_motome(i));
			//}/////////20150308

			s0[i].setKetasuu(s0addMenidsuu);

			//System.out.println("**2**");
			for (int j = 1; j <= s0addMenidsuu; j++) {
				s0[i].setMenid(j, s0addMenid[j]);//‚±‚±‚Å–Ê”Ô??j‚Í?¬‚³‚¢•û‚ª?æ‚É’Ç‰Á‚³‚ê‚é?B
			}
			//System.out.println("**3**");
		}

		//4956                     System.out.print("Smensuu = "); System.out.println(Smensuu);System.exit(0);
		//‚±‚±‚Ü‚Å‚Å?ASmensuu??	Smen_zu.getMensuu()‚Ì‚Ü‚Ü‚©‚í‚è‚È‚µ?B
		System.out.println("ŠeSmen‚ÉŠÜ‚Ü‚ê‚é–Ê‚Ì?”‚Ì“à‚Å?Å‘å‚Ì‚à‚Ì‚ð??‚ß‚é");
		//ŠeSmen‚ÉŠÜ‚Ü‚ê‚é–Ê‚Ì?”‚Ì“à‚Å?Å‘å‚Ì‚à‚Ì‚ð??‚ß‚é?B
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

		//ŽR?Ü‚è’J?Ü‚è‚Ì?û±ñ‚©‚çŒˆ’è‚³‚ê‚é?ã‰ºŠÖŒW‚ð?ã‰º•\‚É“ü‚ê‚é
		System.out.println("ŽR?Ü‚è’J?Ü‚è‚Ì?û±ñ‚©‚çŒˆ’è‚³‚ê‚é?ã‰ºŠÖŒW‚ð?ã‰º•\‚É“ü‚ê‚é");
		int Mid_min, Mid_max;
		for (int ib = 1; ib <= orite.getBousuu(); ib++) {
			Mid_min = orite.Bou_moti_Menid_min_motome(ib);
			Mid_max = orite.Bou_moti_Menid_max_motome(ib);
			if (Mid_min != Mid_max) {//“WŠJ?}‚É‚¨‚¢‚Ä?A–_ib‚Ì—¼˜e‚É–Ê‚ª‚ ‚é
				//if(orite.getcolor(ib)==1){//?Ô‚¢??‚ÅŽR?Ü‚è‚ðˆÓ–¡‚·‚é
				if (otta_Men_zu.getcolor(ib) == 1) {//?Ô‚¢??‚ÅŽR?Ü‚è‚ðˆÓ–¡‚·‚é
					if (orite.getiMeniti(Mid_min) % 2 == 1) {//–ÊMid_min‚ÍŠî??–Ê‚Æ“¯‚¶Œü‚«(•\–Ê‚ª?ã‚ðŒ?‚­)
						jg.set(Mid_min, Mid_max, 1);
						jg.set(Mid_max, Mid_min, 0);
					}
					if (orite.getiMeniti(Mid_max) % 2 == 1) {//–ÊMid_max‚ÍŠî??–Ê‚Æ“¯‚¶Œü‚«(•\–Ê‚ª?ã‚ðŒ?‚­)
						jg.set(Mid_max, Mid_min, 1);
						jg.set(Mid_min, Mid_max, 0);
					}
				}
				//if(orite.getcolor(ib)==2){//?Â‚¢??‚Å’J?Ü‚è‚ðˆÓ–¡‚·‚é
				if (otta_Men_zu.getcolor(ib) == 2) {//?Â‚¢??‚Å’J?Ü‚è‚ðˆÓ–¡‚·‚é
					if (orite.getiMeniti(Mid_min) % 2 == 1) {//–ÊMid_min‚ÍŠî??–Ê‚Æ“¯‚¶Œü‚«(•\–Ê‚ª?ã‚ðŒ?‚­)
						jg.set(Mid_min, Mid_max, 0);
						jg.set(Mid_max, Mid_min, 1);
					}
					if (orite.getiMeniti(Mid_max) % 2 == 1) {//–ÊMid_max‚ÍŠî??–Ê‚Æ“¯‚¶Œü‚«(•\–Ê‚ª?ã‚ðŒ?‚­)
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
		System.out.println("“™‰¿?ðŒ?‚ð?Ý’è‚·‚é   ");
		//“™‰¿?ðŒ?‚ð?Ý’è‚·‚é?B–_ib‚ð‹«ŠE‚Æ‚µ‚Ä—×?Ú‚·‚é2‚Â‚Ì–Êim1,im2‚ª—L‚é?????A?Ü‚è?ô‚Ý??’è‚µ‚½???‡‚É
		//–_ib‚Ìˆê•”‚Æ?d‚È‚éˆÊ’u‚É—L‚é–Êim‚Í–Êim1‚Æ–Êim2‚É?ã‰º•ûŒü‚Å‹²‚Ü‚ê‚é‚±‚Æ‚Í‚È‚¢?B‚±‚Ì‚±‚Æ‚©‚ç
		//gj[im1][im]=gj[im2][im]‚Æ‚¢‚¤“™‰¿?ðŒ?‚ª?¬‚è—§‚Â?B
		for (int ib = 1; ib <= orite.getBousuu(); ib++) {
			Mid_min = orite.Bou_moti_Menid_min_motome(ib);
			Mid_max = orite.Bou_moti_Menid_max_motome(ib);
			if (Mid_min != Mid_max) {//“WŠJ?}‚É‚¨‚¢‚Ä?A–_ib‚Ì—¼˜e‚É–Ê‚ª‚ ‚é
				for (int im = 1; im <= jg.getMensuu(); im++) {
					if ((im != Mid_min) && (im != Mid_max)) {
						if (otta_Men_zu.kantan_totu_naibu(ib, im) == 1) {
							//‰º‚Ì‚Q‚Â‚Ìif‚ÍŽb’è“I‚È?????B‚ ‚Æ‚Å’u‚«Š·‚¦—\’è
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
		System.out.print("‚R–Ê‚ªŠÖ—^‚·‚é“Ë‚«”²‚¯?ðŒ?‚Ì???@???@");
		System.out.println(jg.getTouka_jyoukensuu());
		orihime_ap.keijiban.tuiki("           Jyougehyou_settei   step3   start ");
		//“™‰¿?ðŒ?‚Ì’Ç‰Á?B–_ib‚Ì‹«ŠE‚Æ‚µ‚Ä—×?Ú‚·‚é2‚Â‚Ì–Êim1,im2‚ª—L‚è?A
		//‚Ü‚½–_jb‚Ì‹«ŠE‚Æ‚µ‚Ä—×?Ú‚·‚é2‚Â‚Ì–Êim3,im4‚ª—L‚è?Aib‚Æjb‚ª•½?s‚Å?Aˆê•”?d‚È‚é?????A?Ü‚è?ô‚Ý??’è‚µ‚½???‡‚É
		//–_ib‚Ì–Ê‚Æ–Êjb‚Ì–Ê‚ªi,j,i,j?@‚Ü‚½‚Í?@j,i,j,i?@‚Æ•À‚Ô‚±‚Æ‚Í‚È‚¢?B‚à‚µ‚±‚ê‚ª‚¨‚«‚½‚ç?A
		//?Å?‰‚©‚ç3”Ô–Ú‚ÅŠÔˆá‚¢‚ª‹N‚«‚Ä‚¢‚é‚Ì‚Å?A‚±‚Ì3”Ô–Ú‚Ì‚Æ‚±‚ë‚ªSmen‚Å‰½Œ…–Ú‚©‚ð??‚ß‚Ä?A‚±‚ÌŒ…‚ð‚P?i‚ß‚é?B
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
		System.out.print("‚S–Ê‚ªŠÖ—^‚·‚é“Ë‚«”²‚¯?ðŒ?‚Ì???@???@");
		System.out.println(jg.get_uTouka_jyoukensuu());
		//5154                      System.out.print("Smensuu = "); System.out.println(Smensuu);System.exit(0);

		orihime_ap.keijiban.tuiki("           Jyougehyou_settei   step4   start ");
		//’Ç‰Á??’è
		int ituika;

		ituika = tuika_suitei();
		if (ituika != 1000) {
			return ituika;
		}

		System.out.println("’Ç‰Á??’è ?I—¹‚µ?A?ã‰º•\‚ð•Û‘¶------------------------??????????????????????????????????????????");

		//*************?Å?‰‚É?s‚¤‰‰ãˆ“I??˜_‚ÌŒ‹‰Ê‚Ì•Û‘¶**************************
		jg.jg_hozon();//ŽR?Ü‚è’J?Ü‚è‚Ì?û±ñ‚©‚çŒˆ’è‚³‚ê‚é?ã‰ºŠÖŒW‚ð•Û‘¶‚µ‚Ä‚¨‚­?B
		//************************************************************************
		orihime_ap.keijiban.tuiki("           Jyougehyou_settei   step5   start ");
//orihime_ap.keijiban.tuiki("00000           ");
		//Smen–ˆ‚ÉˆÄ“à?‘‚???‚é
		System.out.println("Smen–ˆ‚ÉˆÄ“à?‘‚???‚é");
		for (int i = 1; i <= Smensuu; i++) {
			//System.out.print("Smen");System.out.print(i);System.out.println("‚É‚Ä?B");
			s0[i].setAnnaisyo(jg);
		}

		//s0‚É—D???‡ˆÊ‚ð‚Â‚¯‚é(‚±‚Ì‚Æ‚«jg‚Ì-100‚Ì‚Æ‚±‚ë‚ª•Ï‚é‚Æ‚±‚ë‚ª‚ ‚é)
		System.out.println("Smen(s0)‚É—D???‡ˆÊ‚ð‚Â‚¯‚é");
		//‚Ü‚¸?A‘¼‚ÌSmen‚ÉŠÛ‚²‚ÆŠÜ‚Ü‚ê‚Ä‚¢‚éSmen‚ð?œŠO‚·‚é

		int[] Smen_no_dokujisei = new int[Smensuu + 1];  //<<<<<<<<<<<<<<<Smen‚Ì“ÆŽ©?«
		for (int i = 1; i <= Smensuu; i++) {
			Smen_no_dokujisei[i] = 1;
		}
		for (int i = 1; i <= Smensuu; i++) {
			Smen_no_dokujisei[i] = 1;
			for (int j = 1; j <= Smensuu; j++) {
				if (Smen_no_dokujisei[j] == 1) {

					if (i != j) {//s0[j]‚ªs0[i]‚ðŠÜ‚Þ‚©‚ð‚Ý‚é?B
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
			System.out.print("Smen[s0]‚Ì“Æ—§?«?@" );
			System.out.print(Smen_no_dokujisei[i]);
			System.out.print("?@:?@");
            		for(int j=1;j<=s0[i].getMenidsuu();j++){
				System.out.print(s0[i].getMenid(j));System.out.print(",");
			}
			System.out.println("");
		}
*/
//
		int[] i_yusendo_max = new int[Smensuu + 1];     //<<<<<<<<<<<<<<<—ÕŽž
		//5115                     System.out.print("Smensuu = "); System.out.println(Smensuu);System.exit(0);

		for (int i = 1; i <= Smensuu; i++) {//—D?æ“xi”Ô–Ú‚ÌSmenid‚ð‚³‚ª‚·?B
			int yusendo_max = -10000;//—D?æ“xi”Ô–Ú‚Ì—D?æ“x‚Ì’l?i‘å‚«‚¢‚Ù‚¤‚ª—D?æ“x‚ª?‚‚¢?j?B
			int i_yusen = 0;

			for (int is0 = 1; is0 <= Smensuu; is0++) { //Smen‚ð‚P‚©‚çSmensuu”Ô–Ú‚Ü‚ÅƒT?[ƒ`
				int Sy;//Smenid_yusendo(is0)+Smen_no_dokujisei[is0] ‚ðŠi”[
				if (s0_no_yusenjyun[is0] == 0) {//‚Ü‚¾—D???‡ˆÊ‚ª‚Â‚¢‚Ä‚¢‚È‚¢Smen‚¾‚¯‚ðˆµ‚¤
					Sy = Smenid_yusendo(is0)/*+Smen_no_dokujisei[is0]*/;//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
					if (yusendo_max < Sy) {
						yusendo_max = Sy;
						i_yusen = is0;// i_yusen‚ªi”Ô–Ú‚Ì—D?æ“x‚ð’T‚µ‚Ä‚¢‚é?Û‚Ì?Å‚à—L—Í‚ÈŒó•â‚Ì”Ô??
					}
					if (yusendo_max == Sy) {
						if (s0[i_yusen].getMenidsuu() < s0[is0].getMenidsuu()) {
							yusendo_max = Sy;
							i_yusen = is0;
						}
					}
				}
			}

			s0_no_yusenjyun[i_yusen] = i; //—D?æ“xi”Ô–Ú‚ÌSmenid‚Íi_yusen?B
			i_yusendo_max[i_yusen] = yusendo_max;//—D?æ“xi”Ô–Ú‚Ì—D?æ“x‚Ì’l?i‘å‚«‚¢‚Ù‚¤‚ª—D?æ“x‚ª?‚‚¢?j?B
/*
			if(yusendo_max>0){
				System.out.print("—D?æ“xŒˆ‚ß?@");System.out.print(i);System.out.print("”Ô–Ú‚Ì—D?æ“x ");
				System.out.println(yusendo_max);
			}
*/

			s0[i_yusen].jg_ni_Smen_no_tantoubasyo_wo_nyuuryoku(jg); //jg‚Ì-100‚Ì‚Æ‚±‚ë‚ð•Ï‚é?B<<<<<<<<<<<<<<<<<<<<<<
		}

		//—D?æ“x‚©‚çs0‚Ìid‚ðŽw’è‚Å‚«‚é‚æ‚¤‚É‚·‚é

		for (int i = 1; i <= Smensuu; i++) {
			for (int is0 = 1; is0 <= Smensuu; is0++) {
				if (i == s0_no_yusenjyun[is0]) {
					yusenjyun_kara_s0id[i] = is0;
				}
			}
		}


		//System.out.println("------------" );
		System.out.println("?ã‰º•\?E?l“à?@Smensuu = " + Smensuu);
		System.out.println("?ã‰º•\?E?l“à?@s0‚É—D???‡ˆÊ‚ð‚Â‚¯‚é");
		for (int i = 1; i <= Smensuu; i++) {
			System.out.println(s0_no_yusenjyun[i]);
		}
		System.out.println("?ã‰º•\?E?l“à?@—D?æ“x‚©‚çs0‚Ìid");
		for (int i = 1; i <= Smensuu; i++) {
			System.out.println(yusenjyun_kara_s0id[i]);
		}


		for (int i = 1; i <= Smensuu; i++) {
			//System.out.println(yusenjyun_kara_s0id[i]);
			if (i_yusendo_max[yusenjyun_kara_s0id[i]] != 0) {
				Smen_yuukou_suu = i;       //??‚¢‚ª•Ï‚ÈŒ‹‰Ê‚É‚È‚é‚±‚Æ‚ ‚è?B
//20191012 wwwww				Smen_yuukou_suu=Smensuu;//’x‚¢‚ªŠmŽÀ

				//System.out.print("‘æ");
				//System.out.print(i);
				//System.out.print("ˆÊ(–¢’èƒyƒA????");
				//System.out.print(i_yusendo_max[yusenjyun_kara_s0id[i]]);

				//System.out.print("?@||?@");
			}
		}


//20191012 				Smen_yuukou_suu=Smensuu;//’x‚¢‚ªŠmŽÀ//20191012


		//System.out.println();
		//

		for (int i = 1; i <= Smensuu; i++) {
			s[i] = s0[yusenjyun_kara_s0id[i]];
		}

		//—D???‡ˆÊ‚ð‹t“]‚³‚¹‚é?B‚±‚ê‚ª—LŒø‚©‚Ç‚¤‚©‚Í•s–¾wwwww
		//for(int i=1;i<=Smen_yuukou_suu;i++){s[Smen_yuukou_suu-i+1]=s0[yusenjyun_kara_s0id[i]];}

/*
		for(int i=1;i<=Smensuu;i++){
                       if(i_yusendo_max[yusenjyun_kara_s0id[i]]!=0){
				System.out.print("‘æ");
				System.out.print(i);
				System.out.print("ˆÊ(–¢’èƒyƒA????");
				System.out.print(i_yusendo_max[yusenjyun_kara_s0id[i]]);
				System.out.print("?A–Ê????");
				System.out.print(s[i].getMenidsuu());
				System.out.print("?@||?@");
			}
		}

		System.out.println();
*/

		//Smen‚Í—D???‡‚Ì‰½”Ô–Ú‚Ü‚Å‚â‚é‚©‚ðŒˆ‚ß‚é
/*
		for(int i=1;i<=Smensuu;i++){
	  		if(s[i].getMenidsuu()>=1){
				Smen_yuukou_suu=i; ;
			}
		}
		Smen_yuukou_suu=Smensuu;   //<<<<<<<<<<<<<<<<<<<<<<<
*/
		System.out.print("Smen—LŒø?”‚Í?@");
		System.out.print(Smen_yuukou_suu);
		System.out.print("?^");
		System.out.println(Smensuu);


		//jg.jg_hozon();//ŽR?Ü‚è’J?Ü‚è‚Ì?û±ñ‚©‚çŒˆ’è‚³‚ê‚é?ã‰ºŠÖŒW‚ð•Û‘¶‚µ‚Ä‚¨‚­?B


		//jg[][]‚Ì?d‚È‚è‚Ì‚ ‚é–Ê‚Ì‘g‚Ý?‡‚úž¹‚ÌˆÊ’u‚Ì’l‚ð-100‚©‚ç-50‚É•Ï‚¦‚é?B
		for (int k = 1; k <= Smensuu; k++) {
			for (int i = 1; i <= s[k].getMenidsuu() - 1; i++) {
				for (int j = i + 1; j <= s[k].getMenidsuu(); j++) {
					jg.set(i, j, -50);
					jg.set(j, i, -50);
				}
			}
		}


		System.out.println("?ã‰º•\?‰Š??Ý’è?I—¹");


//		jg.jg_hozon();//ŽR?Ü‚è’J?Ü‚è‚Ì?û±ñ‚©‚çŒˆ’è‚³‚ê‚é?ã‰ºŠÖŒW‚ð•Û‘¶‚µ‚Ä‚¨‚­?B

		//System.out.print("–Ê?”‚Í1?@");  System.out.println(s[1].getMenidsuu());
		return ireturn;
	}

	//------------------------------------------------------------
	public int tuika_suitei() {
		//ŽR?Ü‚è’J?Ü‚è‚Ì?û±ñ‚©‚ç?X‚ÉŒˆ’è‚Å‚«‚éŠÖŒW‚ð?„‘ª‚µ‚Ä‚¢‚­?B

		int Mid;//3–Ê‚Ì”äŠr‚Å’†ŠÔ‚É‚­‚é–Ê
		int flg_c = 1;
		System.out.println("’Ç‰Á??’èŠJŽn---------------------????????????????????????????????????????????");

		while (flg_c >= 1) {
			flg_c = 0;
			System.out.println("’Ç‰Á??’è------------------------");
			//System.out.println("ŽR?Ü‚è’J?Ü‚è‚Ì?û±ñ‚©‚ç’Ç‰Á??’è   " );

			int flg_b = 1;
			while (flg_b >= 1) {
				flg_b = 0;

				for (int iS = 1; iS <= Smensuu; iS++) {

					int flg_a = 1;
					while (flg_a >= 1) {
						flg_a = 0;
						for (int iM = 1; iM <= s0[iS].getMenidsuu(); iM++) {//3–Ê‚Ì”äŠr‚Å’†ŠÔ‚É‚­‚é–Ê
							int[] ueMenid = new int[s0[iS].getMenidsuu() + 1];//S–Ê‚ÉŠÜ‚Ü‚ê‚é‚ ‚éMen‚Ì?ã‚ª‚í‚É‚ ‚éid”Ô??‚ð‹L˜^‚·‚é?B‚±‚ê‚ª20‚Æ‚¢‚¤‚±‚Æ‚Í?A
							int[] sitaMenid = new int[s0[iS].getMenidsuu() + 1];//S–Ê‚ÉŠÜ‚Ü‚ê‚é‚ ‚éMen‚Ì‰º‚ª‚í‚É‚ ‚éid”Ô??‚ð‹L˜^‚·‚é?B‚±‚ê‚ª20‚Æ‚¢‚¤‚±‚Æ‚Í?A
							int ueMenid_max = 0;
							int sitaMenid_max = 0;
							Mid = s0[iS].getMenid(iM);

							//?l‚¦•û?F‚ ‚éSmen‚Ì‚ ‚é–ÊMid‚É‚Â‚¢‚Ä?l‚¦‚é?B
							//‚±‚ÌSmenˆÈŠO‚Å–ÊA‚Í–ÊMid‚Ì?ã‘¤?A–ÊB‚Í–ÊMid‚Ì‰º‘¤‚ÆŒˆ‚Ü‚Á‚Ä‚¢‚½‚Æ‚·‚é?B
							//ˆê”Ê‚É•Ê?X‚ÌSmen‚Å?A–ÊA‚Í–ÊMid‚Ì?ã‘¤‚Å?A–ÊB‚Í–ÊMid‚Ì‰º‘¤‚¾‚Á‚½‚©‚ç‚ÆŒ¾‚Á‚Ä?A–ÊA‚Í–ÊB‚Ì?ã‘¤‚Æ‚ÍŒˆ’è‚Å‚«‚È‚¢?B
							//‚µ‚©‚µ?A‚±‚±‚ªƒ|ƒCƒ“ƒg‚¾‚ª?A–ÊA?A–ÊMid?A–ÊB‚ª‚¢‚Á‚µ‚å‚ÉŠÜ‚Ü‚ê‚Ä‚¢‚éSmen‚ª‚ ‚é‚È‚ç?A‚»‚ÌSmen‚Ì?ã‰ºŠÖŒW‚ª‚í‚©‚Á‚Ä‚¢‚È‚­‚Ä‚à
							//–ÊA‚Í–ÊB‚Ì?ã‘¤‚Æ‚È‚é?B‚¾‚©‚ç?A‚±‚Ì‘€??‚Å‚Í‚ ‚éSmen‚©‚ç“¾‚é?û±ñ‚Í‚R‚Â‚Ì–Ê‚ª‚¢‚Á‚µ‚å‚É‚ ‚é‚©‚Æ‚¢‚¤‚±‚Æ‚Å‚ ‚é?B
							//‚ ‚éSmen“à‚Ì?ã‰ºŠÖŒW‚Í•K—v‚È‚¢?B
							//
							//‚±‚±‚Ì‘€??‚Í‚ ‚éSmen‚Ì?ã‰ºŠÖŒW‚ð?ã‰º•\‚©‚ç?Ì?W‚µ‚Ä‚¢‚é?B
							for (int i = 1; i <= s0[iS].getMenidsuu(); i++) {//Menid[iM]‚æ‚è?ã‚É‚ ‚é–Ê?B
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
							for (int iuM = 1; iuM <= ueMenid_max; iuM++) {//Menid[iM]‚æ‚è?ã‚É‚ ‚é–Ê?B
								for (int isM = 1; isM <= sitaMenid_max; isM++) {//Menid[iM]‚æ‚è‰º‚É‚ ‚é–Ê?B

									//  System.out.print(ueMenid[iuM]);System.out.print("<-??:‰º->");System.out.println(sitaMenid[isM]);


									if (jg.get(ueMenid[iuM], sitaMenid[isM]) == 0) {
										errorPos = new Touka_jyouken(sitaMenid[isM], ueMenid[iuM], sitaMenid[isM], ueMenid[iuM]);
										return 2;
									}//–Ê‚Ì?ã‰ºŠÖŒW‚ÌŠg’£‚Å–µ?‚”­?¶?B
									if (jg.get(sitaMenid[isM], ueMenid[iuM]) == 1) {
										errorPos = new Touka_jyouken(sitaMenid[isM], ueMenid[iuM], sitaMenid[isM], ueMenid[iuM]);
										return 2;
									}//–Ê‚Ì?ã‰ºŠÖŒW‚ÌŠg’£‚Å–µ?‚”­?¶?B

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

				//System.out.print("?„‘ª‚³‚ê‚½ŠÖŒW‚Ì?? ?? ");System.out.println(flg_b);
			}

			//
			//jg.jg_hozon();//ŽR?Ü‚è’J?Ü‚è‚Ì?û±ñ‚©‚çŒˆ’è‚³‚ê‚é?ã‰ºŠÖŒW‚ð•Û‘¶‚µ‚Ä‚¨‚­?B


			//jg ‚Ìreset“K?Ø‚É?s‚í‚ê‚Ä‚¢‚é‚©Šm”F‚Ì‚±‚Æ

			//System.out.println ("‚R–Ê‚ªŠÖ—^‚·‚é“Ë‚«”²‚¯?ðŒ?‚©‚ç’Ç‰Á??’è   " );
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
				//System.out.print("?„‘ª‚³‚ê‚½ŠÖŒW‚Ì?”‚Í ?? ");System.out.println(flg_a);
			}

			//----------------

//	System.out.println ("‚S–Ê‚ªŠÖ—^‚·‚é“Ë‚«”²‚¯?ðŒ?‚©‚ç’Ç‰Á??’è   " );
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


					//?@a>b>c?@‚¾‚¯‚È‚çd‚ÌˆÊ’u‚ÍŒˆ‚Ü‚ç‚È‚¢


					//?@a>c && b>d ‚È‚ç a>d && b>c
					//  a>d && b>c ‚È‚ç a>c && b>d
					//?@a<c && b<d ‚È‚ç a<d && b<c
					//  a<d && b<c ‚È‚ç a<c && b<d


					//?@a>c>b?@‚È‚ç?@a>d>b

					//a>c && b>d ‚È‚ç a>d && b>c
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
					//a>d && b>c ‚È‚ç a>c && b>d
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

					//a<c && b<d ‚È‚ç a<d && b<c
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
					//a<d && b<c ‚È‚ç a<c && b<d
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


					//?@a>c>b?@‚È‚ç?@a>d>b
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
					//?@a>d>b?@‚È‚ç?@a>c>b
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
					//?@b>c>a?@‚È‚ç?@b>d>a
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
					//?@b>d>a?@‚È‚ç?@b>c>a
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


					//?@c>a>d?@‚È‚ç?@c>b>d
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
					//?@c>b>d?@‚È‚ç?@c>a>d
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
					//?@d>a>c?@‚È‚ç?@d>b>c
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
					//?@d>b>c?@‚È‚ç?@d>a>c
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
				//System.out.print("?„‘ª‚³‚ê‚½ŠÖŒW‚Ì?”‚Í ?? ");System.out.println(flg_a);
			}

			//----------------

			System.out.print("?„‘ª‚³‚ê‚½ŠÖŒW‚Ì?”‚Ì?‡Œv ?? ");
			System.out.println(flg_c);

		}


		System.out.println("’Ç‰Á??’è ?I—¹------------------------???????–‚±‚±‚Ü‚Å20150310??????????????????????");

		return 1000;

	}

	//------------------------------------------

	private int tuika_suitei_2() {
		//ŽR?Ü‚è’J?Ü‚è‚Ì?û±ñ‚©‚ç?X‚ÉŒˆ’è‚Å‚«‚éŠÖŒW‚ð?„‘ª‚µ‚Ä‚¢‚­?B

		int Mid;//3–Ê‚Ì”äŠr‚Å’†ŠÔ‚É‚­‚é–Ê
		int flg_c = 1;
		System.out.println("’Ç‰Á??’èŠJŽn---------------------????????????????????????????????????????????");

		while (flg_c >= 1) {
			flg_c = 0;
			System.out.println("’Ç‰Á??’è------------------------");
			//System.out.println("ŽR?Ü‚è’J?Ü‚è‚Ì?û±ñ‚©‚ç’Ç‰Á??’è   " );

			int flg_b = 1;
			while (flg_b >= 1) {
				flg_b = 0;

				for (int iS = 1; iS <= Smensuu; iS++) {

					int flg_a = 1;
					while (flg_a >= 1) {
						flg_a = 0;
						for (int iM = 1; iM <= s0[iS].getMenidsuu(); iM++) {//3–Ê‚Ì”äŠr‚Å’†ŠÔ‚É‚­‚é–Ê
							int[] ueMenid = new int[s0[iS].getMenidsuu() + 1];//S–Ê‚ÉŠÜ‚Ü‚ê‚é‚ ‚éMen‚Ì?ã‚ª‚í‚É‚ ‚éid”Ô??‚ð‹L˜^‚·‚é?B‚±‚ê‚ª20‚Æ‚¢‚¤‚±‚Æ‚Í?A
							int[] sitaMenid = new int[s0[iS].getMenidsuu() + 1];//S–Ê‚ÉŠÜ‚Ü‚ê‚é‚ ‚éMen‚Ì‰º‚ª‚í‚É‚ ‚éid”Ô??‚ð‹L˜^‚·‚é?B‚±‚ê‚ª20‚Æ‚¢‚¤‚±‚Æ‚Í?A
							int ueMenid_max = 0;
							int sitaMenid_max = 0;
							Mid = s0[iS].getMenid(iM);

							//?l‚¦•û?F‚ ‚éSmen‚Ì‚ ‚é–ÊMid‚É‚Â‚¢‚Ä?l‚¦‚é?B
							//‚±‚ÌSmenˆÈŠO‚Å–ÊA‚Í–ÊMid‚Ì?ã‘¤?A–ÊB‚Í–ÊMid‚Ì‰º‘¤‚ÆŒˆ‚Ü‚Á‚Ä‚¢‚½‚Æ‚·‚é?B
							//ˆê”Ê‚É•Ê?X‚ÌSmen‚Å?A–ÊA‚Í–ÊMid‚Ì?ã‘¤‚Å?A–ÊB‚Í–ÊMid‚Ì‰º‘¤‚¾‚Á‚½‚©‚ç‚ÆŒ¾‚Á‚Ä?A–ÊA‚Í–ÊB‚Ì?ã‘¤‚Æ‚ÍŒˆ’è‚Å‚«‚È‚¢?B
							//‚µ‚©‚µ?A‚±‚±‚ªƒ|ƒCƒ“ƒg‚¾‚ª?A–ÊA?A–ÊMid?A–ÊB‚ª‚¢‚Á‚µ‚å‚ÉŠÜ‚Ü‚ê‚Ä‚¢‚éSmen‚ª‚ ‚é‚È‚ç?A‚»‚ÌSmen‚Ì?ã‰ºŠÖŒW‚ª‚í‚©‚Á‚Ä‚¢‚È‚­‚Ä‚à
							//–ÊA‚Í–ÊB‚Ì?ã‘¤‚Æ‚È‚é?B‚¾‚©‚ç?A‚±‚Ì‘€??‚Å‚Í‚ ‚éSmen‚©‚ç“¾‚é?û±ñ‚Í‚R‚Â‚Ì–Ê‚ª‚¢‚Á‚µ‚å‚É‚ ‚é‚©‚Æ‚¢‚¤‚±‚Æ‚Å‚ ‚é?B
							//‚ ‚éSmen“à‚Ì?ã‰ºŠÖŒW‚Í•K—v‚È‚¢?B
							//
							//‚±‚±‚Ì‘€??‚Í‚ ‚éSmen‚Ì?ã‰ºŠÖŒW‚ð?ã‰º•\‚©‚ç?Ì?W‚µ‚Ä‚¢‚é?B
							for (int i = 1; i <= s0[iS].getMenidsuu(); i++) {//Menid[iM]‚æ‚è?ã‚É‚ ‚é–Ê?B
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
							for (int iuM = 1; iuM <= ueMenid_max; iuM++) {//Menid[iM]‚æ‚è?ã‚É‚ ‚é–Ê?B
								for (int isM = 1; isM <= sitaMenid_max; isM++) {//Menid[iM]‚æ‚è‰º‚É‚ ‚é–Ê?B

									/**/      //  System.out.print(ueMenid[iuM]);System.out.print("<-??:‰º->");System.out.println(sitaMenid[isM]);


									if (jg.get(ueMenid[iuM], sitaMenid[isM]) == 0) {
										return 2;
									}//–Ê‚Ì?ã‰ºŠÖŒW‚ÌŠg’£‚Å–µ?‚”­?¶?B
									if (jg.get(sitaMenid[isM], ueMenid[iuM]) == 1) {
										return 2;
									}//–Ê‚Ì?ã‰ºŠÖŒW‚ÌŠg’£‚Å–µ?‚”­?¶?B

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

			//System.out.print("?„‘ª‚³‚ê‚½ŠÖŒW‚Ì?? ?? ");System.out.println(flg_b);
		}


		System.out.println("’Ç‰Á??’è ?I—¹------------------------??????????????????????????????????????????");

		return 1000;

	}


	//-----------------------------------------------------------------------------------------

	private int Smen_i_ga_j_ni_fukumareru(int s0i, int s0j) { //ŠÜ‚Ü‚ê‚é‚È‚ç‚P?A‚È‚¢‚È‚ç‚O
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

	//s0(Smen)‚Ì—D?æ“x‚ðŽ¦‚·’l‚ð??‚ß‚é?B‚±‚Ì’l‚ª?‚‚¢‚Ù‚¤‚ª—D?æ“x‚ª???i”z—ñ‚Ì?æ“ª‚É‹ß‚¢?B?j
	int Smenid_yusendo(int s0id) {
		//return s0[s0id].getMenidsuu();

		//Œ»?Ý‚Ì?ã‰º•\‚ÉSmen‚ð“ü‚ê‚½‚ç‰½ŒÂ‚Ì?ã‰ºŠÖŒW‚ª?V‚½‚É“o˜^‚³‚ê‚é‚©‚ð’²‚×‚é?B
		return s0[s0id].sinki_jyouhou_suu(jg);


	}

	//-----------
	//------------------------
	//ˆø?”‚Ì‚R‚Â‚Ì–Ê‚ð“¯Žž‚ÉŠÜ‚ÞSmen‚ª1‚ÂˆÈ?ã‘¶?Ý‚·‚é‚È‚ç‚P?A‚µ‚È‚¢‚È‚ç‚O‚ð•Ô‚·?B
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
	//ˆø?”‚Ì‚S‚Â‚Ì–Ê‚ð“¯Žž‚ÉŠÜ‚ÞSmen‚ª1‚ÂˆÈ?ã‘¶?Ý‚·‚é‚È‚ç‚P?A‚µ‚È‚¢‚È‚ç‚O‚ð•Ô‚·?B
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


	//?@‚±‚±‚Í  class Jyougehyou_Syokunin  ‚Ì’†‚Å‚·?B


	//Smen‚Ì–Ê‚Ì?d‚È‚è?ó‘Ô‚ðŽŸ‚Ì?ó‘Ô‚É‚·‚é?B
	//‚à‚µŒ»?Ý‚Ì–Ê‚Ì?d‚È‚è?ó‘Ô‚ª?A?ÅŒã‚Ì‚à‚Ì‚¾‚Á‚½‚ç0‚ðreturn‚µ‚Ä?A–Ê‚Ì?d‚È‚è?ó‘Ô‚Í?Å?‰‚Ì‚à‚Ì‚É–ß‚é?B
	//zzzzzzzz

	public int susumu(int ss) {
		int isusumu;//=0‚Ì???‡Smen‚ª•Ï‚í‚é?iŒ…‚ª•Ï‚é‚æ‚¤‚ÈƒC???[ƒW?j?B
		int Sid;//•Ï‰»‚ª‹y‚ñ‚¾Smen‚Ìid”Ô??
		isusumu = 0;
		//ss+1”Ô–ÚˆÈ?ã‚ÌSmen‚Í‚Ý‚È?‰Šú’l‚É‚·‚é?BSmen‚ÉŠÜ‚Ü‚ê‚é–Ê?”‚ª0‚Ì‚Æ‚«‚ÍƒGƒ‰?[‚É‚È‚é?B
//System.out.println("    js.susumu 001      ss+1”Ô–ÚˆÈ?ã‚ÌSmen‚Í‚Ý‚È?‰Šú’l‚É‚·‚é?B");

		for (int i = ss + 1; i <= Smensuu; i++) {

//System.out.println("    js.susumu i= "+i+"        Smensuu= "+Smensuu);

			s[i].Jyunretu_1banme();
		}
//System.out.println("    js.susumu 002      ss+1”Ô–ÚˆÈ?ã‚ÌSmen‚Í‚Ý‚È?‰Šú’l‚É‚·‚é?B");
		//Smen‚Ìid”Ô??‚Ì‘å‚«‚¢‚à‚Ì‚©‚ç?¬‚³‚¢‚à‚Ì‚Ì?‡‚É–Ê‚Ì?d‚È‚è?ó‘Ô‚ð•Ï‚¦‚Ä‚¢‚­?B
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
public int yuukouk_Smen_susumu(){//yuuko‚ÈSmen?”‚¾‚¯Œ…‚ª•Ï‚í‚é
		int isusumu;//=0‚Ì???‡Smen‚ª•Ï‚í‚é?iŒ…‚ª•Ï‚é‚æ‚¤‚ÈƒC???[ƒW?j?B
		int Sid;//•Ï‰»‚ª‹y‚ñ‚¾Smen‚Ìid”Ô??
		isusumu =0;
int ss; ss=getSmen_yuukou_suu();
	//ss+1”Ô–ÚˆÈ?ã‚ÌSmen‚Í‚Ý‚È?‰Šú’l‚É‚·‚é?B—LŒø?”ˆÈ?ã‚ÍŽg‚í‚È‚¢‚Ì‚Å?A‰½‚à‚µ‚È‚¢‚±‚Æ‚É‚·‚é?B
//System.out.println("    js.susumu 001      ss+1”Ô–ÚˆÈ?ã‚ÌSmen‚Í‚Ý‚È?‰Šú’l‚É‚·‚é?B");

		//for(int i=ss+1;i<=Smensuu;i++){

//System.out.println("    js.susumu i= "+i+"        Smensuu= "+Smensuu);

		 // s[i].Jyunretu_1banme();
		//}
//System.out.println("    js.susumu 002      ss+1”Ô–ÚˆÈ?ã‚ÌSmen‚Í‚Ý‚È?‰Šú’l‚É‚·‚é?B");
		  //Smen‚Ìid”Ô??‚Ì‘å‚«‚¢‚à‚Ì‚©‚ç?¬‚³‚¢‚à‚Ì‚Ì?‡‚É–Ê‚Ì?d‚È‚è?ó‘Ô‚ð•Ï‚¦‚Ä‚¢‚­?B
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
//System.out.print("Smen—LŒø??/Smensuu?@" );System.out.print(Smen_yuukou_suu );System.out.print("?^");System.out.println(Smensuu );
		if (Smen_yuukou_suu == 0) {
			return 1000;
		}//Smen_yuukou_suu==0‚Æ‚¢‚¤‚±‚Æ‚Í?A?ã‰º•\‚É?V‚½‚È?û±ñ‚ð‰Á‚¦‚éSmen‚ª‚È‚¢‚Æ‚¢‚¤‚±‚Æ?B‚·‚È‚í‚¿?A?ã‰º•\‚ª‚·‚×‚Ä–„‚Ü‚Á‚Ä‚¢‚é‚Æ‚¢‚¤‚±‚Æ‚ðŽ¦‚·‚½‚ß?A‚±‚êˆÈ?ã‚Ì?d‚È‚è??’è‚Í•s—v?B


		return kanou_kasanari_sagasi_self(1);
	}

	//---------------------------------------------------------------------------------------------------------------------------------------------
	public int kanou_kasanari_sagasi_self(int ss) {
		//orihime_ap.keijiban.tuiki("ss = "+ss  +"  :  Smen_yuukou_suu = "+Smen_yuukou_suu );
		//?Å?IŒ…‚Å‚Ì????
		if (ss == Smen_yuukou_suu) {

			if (s[ss].kanou_kasanari_sagasi(jg) == 1000) {//==0‚Æ‚¢‚¤‚±‚Æ‚Í?A‰Â”\‚È?d‚È‚è‚©‚½‚Æ‚È‚é?Úñ‚Í‘¶?Ý‚µ‚È‚¢?B?@==1000?@‚±‚ÌSmen‚Í?A–µ?‚‚Í‚È‚¢?ó‘Ô‚É‚È‚Á‚Ä‚¢‚é?B
				return 100;//?Ü‚è?ô‚Ý‰Â”\‚È?Úñ‘g‚Ý?‡‚úž¹‚ªŒ©‚Â‚©‚Á‚½?B
			} else {
				return 0;
			}

		}


		//?Å?IŒ…ˆÈŠO‚Å‚Ì????
		if (s[ss].kanou_kasanari_sagasi(jg) == 1000) {//==0‚Æ‚¢‚¤‚±‚Æ‚Í?A‰Â”\‚È?d‚È‚è‚©‚½‚Æ‚È‚é?Úñ‚Í‘¶?Ý‚µ‚È‚¢?B?@==1000?@‚±‚ÌSmen‚Í?A–µ?‚‚Í‚È‚¢?ó‘Ô‚É‚È‚Á‚Ä‚¢‚é?B


			while (kanou_kasanari_sagasi_self(ss + 1) == 0) {//ŽŸ‚ÌŒ…‚Å‰Â”\‚È?d‚È‚è‚©‚½‚Æ‚È‚é?Úñ‚Í‘¶?Ý‚µ‚È‚¢
				if (s[ss].susumu() == 0) {
					return 0;
				}//‚±‚ÌŒ…‚Å‚Í?i‚ß‚È‚¢?i?V‚½‚È?Úñ‚Í–³‚¢?j

			}

			return 1000;//?Ü‚è?ô‚Ý‰Â”\‚È?Úñ‘g‚Ý?‡‚úž¹‚ªŒ©‚Â‚©‚Á‚½?B

		}

		return 0;


		//for(int ss=1;ss<=Smen_yuukou_suu;ss++){      //<<<<<<<<<<<<<<?‚‘¬‰»‚Ì‚½‚ß•Ï?X?B070417
		//        s[ss].jg_ni_Smen_wo_nyuuryoku(jg);//ss”Ô–Ú‚ÌSmen‚Ì?ã‰º?û±ñ‚ðjg‚É“ü—Í‚·‚é?B
		//  }
// return 100;

	}


	public int susumu_new() {
		return 0;
	}
//------------------------------------------------------------------------------------------------------

	//Œ»?Ý‚Ì?Ú??ó‘Ô‚©‚çŠJŽn‚µ‚Ä?A‰Â”\‚È?d‚È‚è‚©‚½‚Æ‚È‚é?ó‘Ô‚ð’T‚·?B‚È‚¨?A‚±‚±‚Í?‚‘¬‰»‚Ì—]’n‚ª‚ ‚é?B
	public int kanou_kasanari_sagasi() {      //‚±‚ê‚Íjg‚ð•Ï‚¦‚È‚¢‚Í‚¸?B
		orihime_ap.keijiban.tuiki("_ _______");
		orihime_ap.keijiban.tuiki("__ ______");
		orihime_ap.keijiban.tuiki("___ _____");
		orihime_ap.keijiban.tuiki("____ ____");
		int ms, Sid;
		ms = 0;

		//System.out.print("–Ê?”‚Í2?@");  System.out.println(s[1].getMenidsuu());

		Sid = 1;//Sid‚Ì?‰Šú’l‚Í0ˆÈŠO‚È‚ç‚È‚ñ‚Å‚à‚¢‚¢?B
		while (Sid != 0) { //Sid==0‚È‚ç?ASmen‚Ì?Å‚à”Ô??‚Ì?¬‚³‚¢‚à‚Ì‚Ü‚Å’²‚×?s‚­‚µ‚½‚Æ‚¢‚¤ˆÓ–¡?B

			ms = mujyun_Smen_motome();
			if (ms == 1000) {
				return 1000;
			}//‘S‚Ä‚ÌSmen‚Å?A–µ?‚‚Í‚È‚¢?B
			Sid = susumu(ms - 1);
			orihime_ap.keijiban.kakikae(9, "susumu(" + ms + "-1 = )" + Sid);
		}
		return 0;//‰Â”\‚È?d‚È‚è‚©‚½‚Æ‚È‚é?ó‘Ô‚Í‘¶?Ý‚µ‚È‚¢
	}

	//-----------------------------------------------------------------------------------------------------------------
	//?Ü‚è?d‚È‚è•û‚ª–µ?‚‚·‚éSmen‚ð”Ô??‚Ì?¬‚³‚¢?‡‚©‚ç‚³‚ª‚·?B  ‚È‚¨?A‚±‚±‚à?‚‘¬‰»‚Ì—]’n‚ª‚ ‚é?B
	private int mujyun_Smen_motome() { //jg‚Í•Ï‰»‚·‚é?B

		//orihime_ap.keijiban.kakikae(9,"mujyun_Smen_motome()");
		int kks;
		jg.jg_fukugen();//<<<<<<<<<<<<<<<<<<<<<<<<<<<,,

		for (int ss = 1; ss <= Smen_yuukou_suu; ss++) {      //<<<<<<<<<<<<<<?‚‘¬‰»‚Ì‚½‚ß•Ï?X?B070417

			orihime_ap.keijiban.kakikae(7, "mujyun_Smen_motome( " + ss + ") , Menidsuu = " + s[ss].getMenidsuu() + " , Men_pair_suu = " + s[ss].getMenidsuu() * (s[ss].getMenidsuu() - 1) / 2);
			orihime_ap.keijiban.kakikae(8, " kasanari_bunryi_mitei = " + s[ss].kasanari_bunryi_mitei(jg));
			orihime_ap.keijiban.kakikae(9, " kasanari_bunryi_ketteizumi = " + s[ss].kasanari_bunryi_ketteizumi(jg));


			kks = s[ss].kanou_kasanari_sagasi(jg);
			orihime_ap.keijiban.kakikae(10, Jyunretu_count(ss));


			if (kks == 0) {//kks==0‚Æ‚¢‚¤‚±‚Æ‚Í?A‰Â”\‚È?d‚È‚è‚©‚½‚Æ‚È‚é?Úñ‚Í‘¶?Ý‚µ‚È‚¢

				return ss;
			}
			s[ss].jg_ni_Smen_wo_nyuuryoku(jg);//ss”Ô–Ú‚ÌSmen‚Ì?ã‰º?û±ñ‚ðjg‚É“ü—Í‚·‚é?B


		}

		if (tuika_suitei() != 1000) {
			return Smen_yuukou_suu;
		} //ttttttttttt

		return 1000;
	}

// ---------------------------------------------------------------

	//?@‚±‚±‚Í  class Jyougehyou_Syokunin  ‚Ì’†‚Å‚·?B
	//-----------------------------------------------------
	public void set_hyouji_yousiki(int i) {
		hyouji_yousiki = i;
	}


	//?}‚ð‚©‚­?Û‚Ì?”’l•ÏŠ·—pŠÖ??-----------------------------------------------------------------

	private int gx(double d) {
		//if(ip1==1){return (int)(-d+2.0*700.0);} //— ‘¤•\Ž¦   <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		//if(ip1==1){return (int)(-d);} //— ‘¤•\Ž¦   <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		// if(ip1==0){return (int)d;} //•\‘¤•\Ž¦
		return (int) d; //•\‘¤•\Ž¦
	}

	private int gy(double d) {
		return (int) d;
	}

	//---------------------------------------------------------
	//---------------------------------------------------------


	Color F_color = new Color(255, 255, 50);//•\–Ê‚Ì?F
	Color B_color = new Color(233, 233, 233);//— –Ê‚Ì?F
	Color L_color = Color.black;//??‚Ì?F

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


		//hyouji_flg‚Í?Ü‚è?ã‚ª‚è?}‚Ì•\Ž¦—lŽ®‚ÌŽw’è?B4‚È‚çŽÀ?Û‚É?Ü‚èŽ†‚ð?Ü‚Á‚½???‡‚Æ“¯‚¶?B3‚È‚ç“§‰ß?}
		String text = "";//•¶Žš—ñ????—p‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»
		ip1 = omote_ura;
		//  System.out.println(Smensuu);
		for (int im = 1; im <= Smensuu; im++) { //Smen‚©‚ç?ã‚©‚ç‚ÌŽw’è‚µ‚½”Ô–Ú‚Ì–Ê‚Ìid‚ð??‚ß‚é?B
			s0[im].set_Menid2uekara_kazoeta_iti(jg);//Smen‚Ì.set_Menid2uekara_kazoeta_iti‚ÍŒ»?Ý‚Ì?ã‰º•\‚ð‚à‚Æ‚É?A?ã‚©‚ç?”‚¦‚Äi”Ô‚ß‚Ì–Ê‚Ìid”Ô??‚ð‘S‚Ä‚Ì?‡”Ô‚É‚Â‚«Ši”[‚·‚é?B
		}

		//–Ê‚ð•`‚­
		int[] x = new int[100];
		int[] y = new int[100];

		if (hyouji_flg == 4) {//?ÜŽ†•\Ž¦---------------------------------------------------------------------------
			//–Ê‚ð•`‚­
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

			//–_‚ð•`‚­
			int Mid_min, Mid_max;
			int Men_jyunban_min, Men_jyunban_max;
			for (int ib = 1; ib <= Smen_zu.getBousuu(); ib++) {
				Mid_min = Smen_zu.Bou_moti_Menid_min_motome(ib);
				Mid_max = Smen_zu.Bou_moti_Menid_max_motome(ib);
				if (Mid_min == Mid_max) {//‚±‚Ì–_‚Í‹«ŠE??‚È‚Ì‚Å‚±‚Ì–_‚Í•`‚­?B
					g.drawLine(gx(Smen_zu.getmaex(ib)), gy(Smen_zu.getmaey(ib)), gx(Smen_zu.getatox(ib)), gy(Smen_zu.getatoy(ib))); //’¼??
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
				) {//‚±‚Ì–_‚Å—×?Ú‚·‚éSmen‚Ì1”Ô?ã‚Ì–Ê‚ÍˆÙ‚È‚é‚Ì‚Å?A‚±‚Ì–_‚Í•`‚­?B
					g.drawLine(gx(Smen_zu.getmaex(ib)), gy(Smen_zu.getmaey(ib)), gx(Smen_zu.getatox(ib)), gy(Smen_zu.getatoy(ib))); //’¼??
				}
			}
		}

		if (hyouji_flg == -3) {//“§‰ß•\Ž¦--------------------------------------------------------------------------------
			int col_hiku = 10;
			int colmax = 250;
			int col_kosa;
			System.out.println("Smen“§‰ß•\Ž¦");
			//–Ê‚ð•`‚­
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

			//–_‚ð•`‚­
			int Mid_min, Mid_max;
			int Men_jyunban_min, Men_jyunban_max;
			for (int ib = 1; ib <= Smen_zu.getBousuu(); ib++) {
				g.drawLine(gx(Smen_zu.getmaex(ib)), gy(Smen_zu.getmaey(ib)), gx(Smen_zu.getatox(ib)), gy(Smen_zu.getatoy(ib))); //’¼??
			}
		}
/*
	        if(hyouji_flg==2){  //?j‹à•\Ž¦--------------------------------------------------------------------------------------------------
			int  col_hiku=10;int colmax=250;
			int col_kosa;
			//–Ê‚ð•`‚­
			g.setColor(Color.black);

			//–_‚ð•`‚­
			for(int ib=1;ib<=otta_Men_zu.getBousuu();ib++){
                         	g.drawLine( gx(otta_Men_zu.getmaex(ib)),gy(otta_Men_zu.getmaey(ib)),gx(otta_Men_zu.getatox(ib)),gy(otta_Men_zu.getatoy(ib))); //’¼??
			}
		}



	        if(hyouji_flg==4){  //Smen•\Ž¦--------------------------------------------------------------------------------------------------
			//–Ê‚ð•`‚­
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
		//•\Ž¦—lŽ®‚PSmen‚ð•`‚­
		if (hyouji_yousiki == 1) {
			for (int iu = 1; iu <= Smen_yuukou_suu; iu++) {
				int im;
				im = yusenjyun_kara_s0id[iu]; //Smen‚Ì—D???‡ˆÊ
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

	public Memo getMemo_for_svg_with_camera(Tenkaizu_Syokunin orite, Tensyuugou otta_Men_zu, Tensyuugou Smen_zu) {//?Ü‚è?ã‚ª‚è?}(hyouji_flg==5)
		int omote_ura = 0;
		if (camera.get_camera_kagami() == 1.0) {
			omote_ura = 0;
		}//ƒJ??ƒ‰‚Ì‹¾?Ý’è‚ª1‚È‚ç?A?Ü‚è?ã‚ª‚è?}‚Í•\•\Ž¦
		if (camera.get_camera_kagami() == -1.0) {
			omote_ura = 1;
		}//ƒJ??ƒ‰‚Ì‹¾?Ý’è‚ª-1(xŽ²‚Ì•„??‚ð”½“])‚È‚ç?A?Ü‚è?ã‚ª‚è?}‚Í— •\Ž¦

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


		//–Ê‚ð•`‚­-----------------------------------------------------------------------------------------------------
		int[] x = new int[100];
		int[] y = new int[100];
		double[] xd = new double[100];
		double[] yd = new double[100];

		//Smen‚Ì.set_Menid2uekara_kazoeta_iti‚ÍŒ»?Ý‚Ì?ã‰º•\‚ð‚à‚Æ‚É?A?ã‚©‚ç?”‚¦‚Äi”Ô‚ß‚Ì–Ê‚Ìid”Ô??‚ð‘S‚Ä‚Ì?‡”Ô‚É‚Â‚«Ši”[‚·‚é?B
		for (int im = 1; im <= Smensuu; im++) { //Smen‚©‚ç?ã‚©‚ç‚ÌŽw’è‚µ‚½”Ô–Ú‚Ì–Ê‚Ìid‚ð??‚ß‚é?B
			s0[im].set_Menid2uekara_kazoeta_iti(jg);//s0[]‚ÍSmen_zu‚©‚ç“¾‚ç‚ê‚éSmen‚»‚Ì‚à‚Ì?Ajg‚Í?ã‰º•\Jyougehyou‚Ì‚±‚Æ
		}
		//‚±‚±‚Ü‚Å‚Å?A?ã‰º•\‚Ì?û±ñ‚ªSmen‚ÌŠe–Ê‚É“ü‚Á‚½

		//–Ê‚ð•`‚­
		//g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);//ƒAƒ“ƒ`ƒFƒCƒŠƒAƒX?@ƒIƒt
		int Men_jyunban;
		for (int im = 1; im <= Smensuu; im++) {//im‚ÍŠeSmen‚Ì”Ô??
			if (s0[im].getMenidsuu() > 0) {//Menidsuu‚ÍSmen(?Ü‚è?ô‚Ý??’è‚µ‚Ä‚¦‚ç‚ê‚½?j‹à?}‚ð?×•ªŠ„‚µ‚½–Ê)‚Å?d‚È‚Á‚Ä‚¢‚éMen(?Ü‚è‚½‚½‚Þ‘O‚Ì“WŠJ?}‚Ì–Ê)‚Ì???B‚±‚ê‚ª0‚È‚ç?Aƒh?[ƒiƒc?ó‚ÌŒŠ‚Ì–Ê‚È‚Ì‚Å•`‰æ‘Î?ÛŠO

				//?Ü‚è?ã‚ª‚è?}‚ð•`‚­‚Æ‚«‚Ìim”Ô–Ú‚ÌSmen‚Ì?F‚ðŒˆ‚ß‚é
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

				//?Ü‚è?ã‚ª‚è?}‚ð•`‚­‚Æ‚«‚ÌSmen‚Ì?F‚ðŒˆ‚ß‚é‚Ì‚Í‚±‚±‚Ü‚Å

				//?Ü‚è?ã‚ª‚è?}‚ð•`‚­‚Æ‚«‚Ìim”Ô–Ú‚ÌSmen‚Ì‘½ŠpŒ`‚Ì’¸“_‚Ì?À•W?iPC•\Ž¦???j‚ð??‚ß‚é
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
				//?Ü‚è?ã‚ª‚è?}‚ð•`‚­‚Æ‚«‚Ìim”Ô–Ú‚ÌSmen‚Ì‘½ŠpŒ`‚Ì’¸“_‚Ì?À•W?iPC•\Ž¦???j‚ð??‚ß‚é‚Ì‚Í‚±‚±‚Ü‚Å

				//g2.fill(new Polygon(x,y,Smen_zu.getTenidsuu(im)));  //svg?o—Í

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
		//–Ê‚ð•`‚­?@‚±‚±‚Ü‚Å-----------------------------------------------------------------------------------------


		//–_‚ð•`‚­-----------------------------------------------------------------------------------------
/*
		if(i_anti_alias==1){
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);//ƒAƒ“ƒ`ƒFƒCƒŠƒAƒX?@ƒIƒ“
			BasicStroke BStroke = new BasicStroke(1.2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);g2.setStroke(BStroke);//??‚Ì‘¾‚³‚â??‚Ì––’[‚ÌŒ`??
		}
		if(i_anti_alias==0){
	  		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);//ƒAƒ“ƒ`ƒFƒCƒŠƒAƒX?@ƒIƒt
			BasicStroke BStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);g2.setStroke(BStroke);//??‚Ì‘¾‚³‚â??‚Ì––’[‚ÌŒ`??
		}
*/
		//g.setColor(L_color);//?Ü‚è?ã‚ª‚è?}‚ð•`‚­‚Æ‚«‚Ì–_‚Ì?F‚ðŒˆ‚ß‚é

		//str_stroke = "black";
		str_stroke = ms.toHtmlColor(L_color);

		//System.out.println("?ã‰º•\?E?l?@oekaki_with_camera+++++++++++++++?ÜŽ†•\Ž¦?@–_‚ð•`‚­");
		for (int ib = 1; ib <= Smen_zu.getBousuu(); ib++) {

			int Mid_min, Mid_max; //–_‚Ì—¼‘¤‚ÌSmen‚Ì”Ô??‚Ì?¬‚³‚¢‚Ù‚¤‚ªMid_min,?@‘å‚«‚¢‚Ù‚¤‚ªMid_max
			int Men_jyunban_min, Men_jyunban_max;//PC‰æ–Ê‚É•\Ž¦‚µ‚½‚Æ‚«Smen(Mid_min) ‚ÅŒ©‚¦‚é–Ê‚Ì”Ô??‚ªMen_jyunban_min?ASmen(Mid_max) ‚ÅŒ©‚¦‚é–Ê‚Ì”Ô??‚ªMen_jyunban_max
			int oekaki_flg;

			oekaki_flg = 0;
			Mid_min = Smen_zu.Bou_moti_Menid_min_motome(ib);//–_ib‚ð‹«ŠE‚Æ‚µ‚ÄŠÜ‚Þ–Ê(?Å‘å‚Å2–Ê‚ ‚é)‚Ì‚¤‚¿‚ÅMenid‚Ì?¬‚³‚¢‚Ù‚¤‚ÌMenid‚ð•Ô‚·?B–_‚ð‹«ŠE‚Æ‚µ‚ÄŠÜ‚Þ–Ê‚ª–³‚¢???‡‚Í0‚ð•Ô‚·
			Mid_max = Smen_zu.Bou_moti_Menid_max_motome(ib);

			if (s0[Mid_min].getMenidsuu() == 0) {
				oekaki_flg = 1;
			}//men‚ð‚à‚½‚È‚¢?Aƒh?[ƒiƒc‚ÌŒŠ?ó‚ÌSmen‚Í‹«ŠE‚Ì–_‚ð•`‚­
			else if (s0[Mid_max].getMenidsuu() == 0) {
				oekaki_flg = 1;
			} else if (Mid_min == Mid_max) {
				oekaki_flg = 1;
			}//ˆê–{‚Ì–_‚Ì•Ð–Ê‚¾‚¯‚ÉSmen—L‚è
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
				}//‚±‚Ì–_‚Å—×?Ú‚·‚éSmen‚Ì1”Ô?ã‚Ì–Ê‚ÍˆÙ‚È‚é‚Ì‚Å?A‚±‚Ì–_‚Í•`‚­?B
			}

			if (oekaki_flg == 1) {//–_‚ð•`‚­?B
				s_ob.set(Smen_zu.getmaex(ib), Smen_zu.getmaey(ib), Smen_zu.getatox(ib), Smen_zu.getatoy(ib));
				s_tv.set(camera.object2TV(s_ob));
				//g.drawLine( gx(s_tv.getax()),gy(s_tv.getay()),gx(s_tv.getbx()),gy(s_tv.getby())); //svg ‚É’¼??‚ð?o—Í

				a.set(s_tv.geta());
				b.set(s_tv.getb());//a.set(s_tv.getax()+0.000001,s_tv.getay()+0.000001); b.set(s_tv.getbx()+0.000001,s_tv.getby()+0.000001);//‚È‚º0.000001‚ð‘«‚·‚©‚Æ‚¢‚¤‚Æ,ƒfƒBƒXƒvƒŒƒC‚É•`‰æ‚·‚é‚Æ‚«Œ³‚Ì?Ü??‚ª?V‚µ‚¢?Ü??‚É‰e‹¿‚³‚ê‚Ä“®‚¢‚Ä‚µ‚Ü‚¤‚Ì‚ð–h‚®‚½‚ß

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


		//hyouji_flg‚Í?Ü‚è?ã‚ª‚è?}‚Ì•\Ž¦—lŽ®‚ÌŽw’è?B4‚È‚çŽÀ?Û‚É?Ü‚èŽ†‚ð?Ü‚Á‚½???‡‚Æ“¯‚¶?B3‚È‚ç“§‰ß?}
		OritaOekaki OO = new OritaOekaki();
		Ten t0 = new Ten();
		Ten t1 = new Ten();
		Senbun s_ob = new Senbun();
		Senbun s_tv = new Senbun();
		String text = "";//•¶Žš—ñ????—p‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»
		ip1 = omote_ura;
		//  System.out.println(Smensuu);

		//–Ê‚ð•`‚­
		int[] x = new int[100];
		int[] y = new int[100];


		if (hyouji_flg == 5) {//?ÜŽ†•\Ž¦---------------------------------------------------------------------------

			for (int im = 1; im <= Smensuu; im++) { //Smen‚©‚ç?ã‚©‚ç‚ÌŽw’è‚µ‚½”Ô–Ú‚Ì–Ê‚Ìid‚ð??‚ß‚é?B
				s0[im].set_Menid2uekara_kazoeta_iti(jg);
			}


			//–Ê‚ð•`‚­
//System.out.println("?ã‰º•\?E?l?@oekaki_with_camera+++++++++++++++?ÜŽ†•\Ž¦?@–Ê‚ð•`‚­");
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
//System.out.println("?ã‰º•\?E?l?@oekaki_with_camera+++++++++++++++?ÜŽ†•\Ž¦?@–_‚ð•`‚­");
			//–_‚ð•`‚­
			int Mid_min, Mid_max;
			int Men_jyunban_min, Men_jyunban_max;
			int oekaki_flg;
			for (int ib = 1; ib <= Smen_zu.getBousuu(); ib++) {
				oekaki_flg = 0;
				Mid_min = Smen_zu.Bou_moti_Menid_min_motome(ib);//–_ib‚ð‹«ŠE‚Æ‚µ‚ÄŠÜ‚Þ–Ê(?Å‘å‚Å2–Ê‚ ‚é)‚Ì‚¤‚¿‚ÅMenid‚Ì?¬‚³‚¢‚Ù‚¤‚ÌMenid‚ð•Ô‚·?B–_‚ð‹«ŠE‚Æ‚µ‚ÄŠÜ‚Þ–Ê‚ª–³‚¢???‡‚Í0‚ð•Ô‚·
				Mid_max = Smen_zu.Bou_moti_Menid_max_motome(ib);

				if (s0[Mid_min].getMenidsuu() == 0) {
					oekaki_flg = 1;
				}//men‚ð‚à‚½‚È‚¢?Aƒh?[ƒiƒc‚ÌŒŠ?ó‚ÌSmen‚Í‹«ŠE‚Ì–_‚ð•`‚­
				else if (s0[Mid_max].getMenidsuu() == 0) {
					oekaki_flg = 1;
				} else if (Mid_min == Mid_max) {
					oekaki_flg = 1;
				}//ˆê–{‚Ì–_‚Ì•Ð–Ê‚¾‚¯‚ÉSmen—L‚è
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
					}//‚±‚Ì–_‚Å—×?Ú‚·‚éSmen‚Ì1”Ô?ã‚Ì–Ê‚ÍˆÙ‚È‚é‚Ì‚Å?A‚±‚Ì–_‚Í•`‚­?B
				}

				if (oekaki_flg == 1) {//–_‚ð•`‚­?B
					s_ob.set(Smen_zu.getmaex(ib), Smen_zu.getmaey(ib), Smen_zu.getatox(ib), Smen_zu.getatoy(ib));
					s_tv.set(camera.object2TV(s_ob));
					g.drawLine(gx(s_tv.getax()), gy(s_tv.getay()), gx(s_tv.getbx()), gy(s_tv.getby())); //’¼??
					//g.drawLine( gx(Smen_zu.getmaex(ib)),gy(Smen_zu.getmaey(ib)),gx(Smen_zu.getatox(ib)),gy(Smen_zu.getatoy(ib))); //’¼??
				}


			}
			//System.out.println("?ã‰º•\?E?l?@oekaki_with_camera+++++++++++++++?ÜŽ†•\Ž¦?@?I—¹");
		}


//System.out.println("?ã‰º•\?E?l?@oekaki_with_camera+++++++++++++++hyouji_yousiki = "+hyouji_yousiki);

		//•\Ž¦—lŽ®‚PSmen‚ð•`‚­
		if (hyouji_yousiki == 1) {
			for (int iu = 1; iu <= Smen_yuukou_suu; iu++) {
				int im;
				im = yusenjyun_kara_s0id[iu]; //Smen‚Ì—D???‡ˆÊ
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


		//camera’†?S‚ð?\Žš‚Å•`‚­
		OO.jyuuji(g, camera.object2TV(camera.get_camera_ichi()), 5.0, 2.0, 4);


	}


	//
	//---------------------------------------------------------
	public Memo getMemo_hariganezu_for_svg_kakidasi(Tenkaizu_Syokunin orite, Tensyuugou otta_Men_zu, Tensyuugou Smen_zu, int i_fill) {
		//System.out.println("getMemo_hariganezu_for_svg_kakidasi");
		int omote_ura = 0;
		if (camera.get_camera_kagami() == 1.0) {
			omote_ura = 0;
		}//ƒJ??ƒ‰‚Ì‹¾?Ý’è‚ª1‚È‚ç?A?Ü‚è?ã‚ª‚è?}‚Í•\•\Ž¦
		if (camera.get_camera_kagami() == -1.0) {
			omote_ura = 1;
		}//ƒJ??ƒ‰‚Ì‹¾?Ý’è‚ª-1(xŽ²‚Ì•„??‚ð”½“])‚È‚ç?A?Ü‚è?ã‚ª‚è?}‚Í— •\Ž¦

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

		//System.out.println("?ã‰º•\?E?l?@oekaki_with_camera+++++++++++++++“§‰ß•\Ž¦");


		rating2();


		//–Ê‚ð•`‚­??”õ
		int[] x = new int[100];
		int[] y = new int[100];

		//BigDecimal‚ÌƒRƒ“ƒXƒgƒ‰ƒNƒ^‚Ìˆø?”‚Í•‚“®?¬?”“_?”Œ^‚Æ•¶Žš—ñŒ^‚Ç‚¿‚ç‚àok?Bˆø?”‚ª•‚“®?¬?”“_?”Œ^‚ÍŒë?·‚ª”­?¶?B?³Šm‚È’l‚ðˆµ‚¤‚½‚ß‚É‚Í?Aˆø?”‚Í•¶Žš—ñŒ^‚ÅŽw’è?B

		for (int i_nbox = 1; i_nbox <= otta_Men_zu.getMensuu(); i_nbox++) {
			int im = 0;
			if (camera.get_camera_kagami() == -1.0) {//ƒJ??ƒ‰‚Ì‹¾?Ý’è‚ª-1(xŽ²‚Ì•„??‚ð”½“])‚È‚ç?A?Ü‚è?ã‚ª‚è?}‚Í— •\Ž¦
				im = nbox.usirokara_get_int(i_nbox);
			} else {
				im = nbox.get_int(i_nbox);
			}

			String text = "";//•¶Žš—ñ????—p‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»

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

//ƒJƒ‰?[‚Ì“§‰ß?}
//toukazu_toukado=col_hiku;
		g.setColor(new Color(100,100, 100,50));

		//–Ê‚ð•`‚­
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

		//System.out.println("?ã‰º•\?E?l?@oekaki_with_camera+++++++++++++++“§‰ß•\Ž¦");
		OritaOekaki OO = new OritaOekaki();
		Ten t0 = new Ten();
		Ten t1 = new Ten();
		Senbun s_ob = new Senbun();
		Senbun s_tv = new Senbun();
		String text = "";//•¶Žš—ñ????—p‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»

		//–Ê‚ð•`‚­??”õ
		int[] x = new int[100];
		int[] y = new int[100];

		//–Ê‚Ì“K?Ø‚È”Z‚³‚ð??‚ß‚é
		int col_hiku = 0;
		int colmax = 255;
		int colmin = 30;//colmax=255(?^‚Á”’)ˆÈ‰º?Acolmin=0(?^‚Á??)ˆÈ??
		//Menidsuu_max‚Í1ˆÈ?ã‚Å‚ ‚é‚±‚Æ
		if (Menidsuu_max > 0) {
			col_hiku = (colmax - colmin) / Menidsuu_max;
		}
		//if(Menidsuu_max<=0){System.out.println("?ã‰º•\?E?l?@oekaki_toukazu_with_camera!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!    Menidsuu_max<=0  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");}


//if(orihime_ap.ckbox_toukazu_color.isSelected()){//ƒJƒ‰?[‚Ì“§‰ß?}
//if(orihime_ap.OZ.i_toukazu_color==1){//ƒJƒ‰?[‚Ì“§‰ß?}
		if (i_toukazu_color == 1) {//ƒJƒ‰?[‚Ì“§‰ß?}

//toukazu_toukado=col_hiku;
			g.setColor(new Color(F_color.getRed(), F_color.getGreen(), F_color.getBlue(), toukazu_toukado));

			//–Ê‚ð•`‚­
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

			//–_‚ð•`‚­??”õ
			//g.setColor(Color.black);


			if (i_anti_alias == 1) {
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//ƒAƒ“ƒ`ƒFƒCƒŠƒAƒX?@ƒIƒ“
				BasicStroke BStroke = new BasicStroke(1.2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
				g2.setStroke(BStroke);//??‚Ì‘¾‚³‚â??‚Ì––’[‚ÌŒ`??
			}
			if (i_anti_alias == 0) {
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);//ƒAƒ“ƒ`ƒFƒCƒŠƒAƒX?@ƒIƒt
				BasicStroke BStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
				g2.setStroke(BStroke);//??‚Ì‘¾‚³‚â??‚Ì––’[‚ÌŒ`??
			}

			g.setColor(new Color(F_color.getRed(), F_color.getGreen(), F_color.getBlue(), 2 * toukazu_toukado));
			//–_‚ð•`‚­
			int Mid_min, Mid_max;
			int Men_jyunban_min, Men_jyunban_max;
			for (int ib = 1; ib <= Smen_zu.getBousuu(); ib++) {
				s_ob.set(Smen_zu.getmaex(ib), Smen_zu.getmaey(ib), Smen_zu.getatox(ib), Smen_zu.getatoy(ib));
				s_tv.set(camera.object2TV(s_ob));
				g.drawLine(gx(s_tv.getax()), gy(s_tv.getay()), gx(s_tv.getbx()), gy(s_tv.getby())); //’¼??
			}


		} else {//”’?•‚Ì“§‰ß?}?i‹ŒŽ®?j



/*
		int col_hiku=0;int colmax=255;int colmin=30;//colmax=255(?^‚Á”’)ˆÈ‰º?Acolmin=0(?^‚Á??)ˆÈ??
		//Menidsuu_max‚Í1ˆÈ?ã‚Å‚ ‚é‚±‚Æ
		if(Menidsuu_max>0){col_hiku=(colmax-colmin)/Menidsuu_max;}
		//if(Menidsuu_max<=0){System.out.println("?ã‰º•\?E?l?@oekaki_toukazu_with_camera!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!    Menidsuu_max<=0  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");}
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

			//–_‚ð•`‚­??”õ
			g.setColor(Color.black);


			if (i_anti_alias == 1) {
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//ƒAƒ“ƒ`ƒFƒCƒŠƒAƒX?@ƒIƒ“
				BasicStroke BStroke = new BasicStroke(1.2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
				g2.setStroke(BStroke);//??‚Ì‘¾‚³‚â??‚Ì––’[‚ÌŒ`??
			}
			if (i_anti_alias == 0) {
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);//ƒAƒ“ƒ`ƒFƒCƒŠƒAƒX?@ƒIƒt
				BasicStroke BStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
				g2.setStroke(BStroke);//??‚Ì‘¾‚³‚â??‚Ì––’[‚ÌŒ`??
			}


			//–_‚ð•`‚­
			int Mid_min, Mid_max;
			int Men_jyunban_min, Men_jyunban_max;
			for (int ib = 1; ib <= Smen_zu.getBousuu(); ib++) {
				s_ob.set(Smen_zu.getmaex(ib), Smen_zu.getmaey(ib), Smen_zu.getatox(ib), Smen_zu.getatoy(ib));
				s_tv.set(camera.object2TV(s_ob));
				g.drawLine(gx(s_tv.getax()), gy(s_tv.getay()), gx(s_tv.getbx()), gy(s_tv.getby())); //’¼??
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
		}//ƒJ??ƒ‰‚Ì‹¾?Ý’è‚ª1‚È‚ç?A?Ü‚è?ã‚ª‚è?}‚Í•\•\Ž¦
		if (camera.get_camera_kagami() == -1.0) {
			omote_ura = 1;
		}//ƒJ??ƒ‰‚Ì‹¾?Ý’è‚ª-1(xŽ²‚Ì•„??‚ð”½“])‚È‚ç?A?Ü‚è?ã‚ª‚è?}‚Í— •\Ž¦
		//System.out.println("?ã‰º•\?E?l?@oekaki_with_camera+++++++++++++++?ÜŽ†•\Ž¦?@–Ê‚ð•`‚­");
		OritaOekaki OO = new OritaOekaki();
		Ten t0 = new Ten();
		Ten t1 = new Ten();
		Senbun s_ob = new Senbun();
		Senbun s_tv = new Senbun();
		String text = "";//•¶Žš—ñ????—p‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»
		ip1 = omote_ura;
		//  System.out.println(Smensuu);

		//–Ê‚ð•`‚­
		int[] x = new int[100];
		int[] y = new int[100];

		double[] xd = new double[100];
		double[] yd = new double[100];


		//if(hyouji_flg==5){//?ÜŽ†•\Ž¦---------------------------------------------------------------------------

		//Smen‚Ì.set_Menid2uekara_kazoeta_iti‚ÍŒ»?Ý‚Ì?ã‰º•\‚ð‚à‚Æ‚É?A?ã‚©‚ç?”‚¦‚Äi”Ô‚ß‚Ì–Ê‚Ìid”Ô??‚ð‘S‚Ä‚Ì?‡”Ô‚É‚Â‚«Ši”[‚·‚é?B
		for (int im = 1; im <= Smensuu; im++) { //Smen‚©‚ç?ã‚©‚ç‚ÌŽw’è‚µ‚½”Ô–Ú‚Ì–Ê‚Ìid‚ð??‚ß‚é?B
			s0[im].set_Menid2uekara_kazoeta_iti(jg);//s0[]‚ÍSmen_zu‚©‚ç“¾‚ç‚ê‚éSmen‚»‚Ì‚à‚Ì?Ajg‚Í?ã‰º•\Jyougehyou‚Ì‚±‚Æ
		}
		//‚±‚±‚Ü‚Å‚Å?A?ã‰º•\‚Ì?û±ñ‚ªSmen‚ÌŠe–Ê‚É“ü‚Á‚½


		//–Ê‚ð•`‚­-----------------------------------------------------------------------------------------------------
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);//ƒAƒ“ƒ`ƒFƒCƒŠƒAƒX?@ƒIƒt

		int Men_jyunban;
		for (int im = 1; im <= Smensuu; im++) {//im‚ÍŠeSmen‚Ì”Ô??
			if (s0[im].getMenidsuu() > 0) {//Menidsuu‚ÍSmen(?Ü‚è?ô‚Ý??’è‚µ‚Ä‚¦‚ç‚ê‚½?j‹à?}‚ð?×•ªŠ„‚µ‚½–Ê)‚Å?d‚È‚Á‚Ä‚¢‚éMen(?Ü‚è‚½‚½‚Þ‘O‚Ì“WŠJ?}‚Ì–Ê)‚Ì???B‚±‚ê‚ª0‚È‚ç?Aƒh?[ƒiƒc?ó‚ÌŒŠ‚Ì–Ê‚È‚Ì‚Å•`‰æ‘Î?ÛŠO

				//?Ü‚è?ã‚ª‚è?}‚ð•`‚­‚Æ‚«‚Ìim”Ô–Ú‚ÌSmen‚Ì?F‚ðŒˆ‚ß‚é
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


				//?Ü‚è?ã‚ª‚è?}‚ð•`‚­‚Æ‚«‚ÌSmen‚Ì?F‚ðŒˆ‚ß‚é‚Ì‚Í‚±‚±‚Ü‚Å

				//?Ü‚è?ã‚ª‚è?}‚ð•`‚­‚Æ‚«‚Ìim”Ô–Ú‚ÌSmen‚Ì‘½ŠpŒ`‚Ì’¸“_‚Ì?À•W?iPC•\Ž¦???j‚ð??‚ß‚é

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

				//?Ü‚è?ã‚ª‚è?}‚ð•`‚­‚Æ‚«‚Ìim”Ô–Ú‚ÌSmen‚Ì‘½ŠpŒ`‚Ì’¸“_‚Ì?À•W?iPC•\Ž¦???j‚ð??‚ß‚é‚Ì‚Í‚±‚±‚Ü‚Å

				g2.fill(new Polygon(x, y, Smen_zu.getTenidsuu(im)));
				//g.fillPolygon(x,y,Smen_zu.getTenidsuu(im));
			}
		}
		//–Ê‚ð•`‚­?@‚±‚±‚Ü‚Å

		//g.setColor(new Color(0,0,0));		//??
		//g.setColor(new Color(255,255,255));	//”’


		//‰e‚ð‚Â‚¯‚é ------------------------------------------------------------------------------------
		if (i_kage == 1) {

			for (int ib = 1; ib <= Smen_zu.getBousuu(); ib++) {
				int im = bou_no_bangou_kara_kagenoaru_Smen_no_bangou_wo_motomeru(ib, Smen_zu, omote_ura);//‰e‚ð‚Â‚¯‚éSmen‚Ìid
				if (im != 0) {//‰e‚ð•`‚­?B

					//?Ü‚è?ã‚ª‚è?}‚ð•`‚­‚Æ‚«‚Ìim”Ô–Ú‚ÌSmen‚Ì‘½ŠpŒ`‚Ì’¸“_‚Ì?À•W?iPC•\Ž¦???j‚ð??‚ß‚é
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

				//?Ü‚è?ã‚ª‚è?}‚ð•`‚­‚Æ‚«‚Ìim”Ô–Ú‚ÌSmen‚Ì‘½ŠpŒ`‚Ì’¸“_‚Ì?À•W?iPC•\Ž¦???j‚ð??‚ß‚é‚Ì‚Í‚±‚±‚Ü‚Å
*/


					//–_‚Ì?À•W   Smen_zu.getmaex(ib),Smen_zu.getmaey(ib)   -    Smen_zu.getatox(ib) , Smen_zu.getatoy(ib)
					Ten b_mae = new Ten(Smen_zu.getmaex(ib), Smen_zu.getmaey(ib));
					Ten b_ato = new Ten(Smen_zu.getatox(ib), Smen_zu.getatoy(ib));
					double b_nagasa = b_mae.kyori(b_ato);

					//–_‚Æ’¼Œð‚·‚éƒxƒNƒgƒ‹
					double o_btx = -(Smen_zu.getmaey(ib) - Smen_zu.getatoy(ib)) * 10.0 / b_nagasa;//–_‚Æ’¼Œð‚·‚éxƒxƒNƒgƒ‹
					double o_bty = (Smen_zu.getmaex(ib) - Smen_zu.getatox(ib)) * 10.0 / b_nagasa;//–_‚Æ’¼Œð‚·‚éyƒxƒNƒgƒ‹

					//–_‚Ì’†“_
					double o_bmx, o_bmy;
					double t_bmx, t_bmy;

					o_bmx = (Smen_zu.getmaex(ib) + Smen_zu.getatox(ib)) / 2.0;
					o_bmy = (Smen_zu.getmaey(ib) + Smen_zu.getatoy(ib)) / 2.0;

					t0.setx(o_bmx);
					t0.sety(o_bmy);
					t1.set(camera.object2TV(t0));
					t_bmx = t1.getx();
					t_bmy = t1.gety();

					//–_‚Ì’†“_‚ð’Ê‚é’¼Œð???ã‚Ì“_
					double o_bmtx, o_bmty;
					double t_bmtx, t_bmty;


					//–_‚Ì’†“_‚ð’Ê‚é’¼Œð???ã‚Ì“_
					o_bmtx = o_bmx + o_btx;
					o_bmty = o_bmy + o_bty;

					if (Smen_zu.naibu(new Ten(o_bmx + 0.01 * o_btx, o_bmy + 0.01 * o_bty), im) != 0) {//0=ŠO•”?A?@1=‹«ŠE?A?@2=“à•”


						t0.setx(o_bmtx);
						t0.sety(o_bmty);
						t1.set(camera.object2TV(t0));
						t_bmtx = t1.getx();
						t_bmty = t1.gety();


						//‰e‚Ì’·•ûŒ`

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


					//----------------------------------–_‚Æ’¼Œð‚·‚éxƒxƒNƒgƒ‹‚ÌŒü‚«‚ð•Ï‚¦‚Ä‰e‚ð•`‰æ
					o_btx = -o_btx;//–_‚Æ’¼Œð‚·‚éxƒxƒNƒgƒ‹
					o_bty = -o_bty;//–_‚Æ’¼Œð‚·‚éyƒxƒNƒgƒ‹


					//-----------------------------------------------
					//–_‚Ì’†“_‚ð’Ê‚é’¼Œð???ã‚Ì“_
					o_bmtx = o_bmx + o_btx;
					o_bmty = o_bmy + o_bty;


					if (Smen_zu.naibu(new Ten(o_bmx + 0.01 * o_btx, o_bmy + 0.01 * o_bty), im) != 0) {//0=ŠO•”?A?@1=‹«ŠE?A?@2=“à•”

						t0.setx(o_bmtx);
						t0.sety(o_bmty);
						t1.set(camera.object2TV(t0));
						t_bmtx = t1.getx();
						t_bmty = t1.gety();


						//‰e‚Ì’·•ûŒ`

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
		}//‰e‚ð‚Â‚¯‚é‚Í?A‚±‚±‚Å?I‚í‚è

		//–_‚ð•`‚­-----------------------------------------------------------------------------------------


		if (i_anti_alias == 1) {
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//ƒAƒ“ƒ`ƒFƒCƒŠƒAƒX?@ƒIƒ“
			BasicStroke BStroke = new BasicStroke(1.2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
			g2.setStroke(BStroke);//??‚Ì‘¾‚³‚â??‚Ì––’[‚ÌŒ`??
		}
		if (i_anti_alias == 0) {
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);//ƒAƒ“ƒ`ƒFƒCƒŠƒAƒX?@ƒIƒt
			BasicStroke BStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
			g2.setStroke(BStroke);//??‚Ì‘¾‚³‚â??‚Ì––’[‚ÌŒ`??
		}

		g.setColor(L_color);//g.setColor(Color.black);


		//System.out.println("?ã‰º•\?E?l?@oekaki_with_camera+++++++++++++++?ÜŽ†•\Ž¦?@–_‚ð•`‚­");


		for (int ib = 1; ib <= Smen_zu.getBousuu(); ib++) {

			int Mid_min, Mid_max; //–_‚Ì—¼‘¤‚ÌSmen‚Ì”Ô??‚Ì?¬‚³‚¢‚Ù‚¤‚ªMid_min,?@‘å‚«‚¢‚Ù‚¤‚ªMid_max
			int Men_jyunban_min, Men_jyunban_max;//PC‰æ–Ê‚É•\Ž¦‚µ‚½‚Æ‚«Smen(Mid_min) ‚ÅŒ©‚¦‚é–Ê‚Ì”Ô??‚ªMen_jyunban_min?ASmen(Mid_max) ‚ÅŒ©‚¦‚é–Ê‚Ì”Ô??‚ªMen_jyunban_max
			int oekaki_flg;

			oekaki_flg = 0;
			Mid_min = Smen_zu.Bou_moti_Menid_min_motome(ib);//–_ib‚ð‹«ŠE‚Æ‚µ‚ÄŠÜ‚Þ–Ê(?Å‘å‚Å2–Ê‚ ‚é)‚Ì‚¤‚¿‚ÅMenid‚Ì?¬‚³‚¢‚Ù‚¤‚ÌMenid‚ð•Ô‚·?B–_‚ð‹«ŠE‚Æ‚µ‚ÄŠÜ‚Þ–Ê‚ª–³‚¢???‡‚Í0‚ð•Ô‚·
			Mid_max = Smen_zu.Bou_moti_Menid_max_motome(ib);

			if (s0[Mid_min].getMenidsuu() == 0) {
				oekaki_flg = 1;
			}//men‚ð‚à‚½‚È‚¢?Aƒh?[ƒiƒc‚ÌŒŠ?ó‚ÌSmen‚Í‹«ŠE‚Ì–_‚ð•`‚­
			else if (s0[Mid_max].getMenidsuu() == 0) {
				oekaki_flg = 1;
			} else if (Mid_min == Mid_max) {
				oekaki_flg = 1;
			}//ˆê–{‚Ì–_‚Ì•Ð–Ê‚¾‚¯‚ÉSmen—L‚è
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
				}//‚±‚Ì–_‚Å—×?Ú‚·‚éSmen‚Ì1”Ô?ã‚Ì–Ê‚ÍˆÙ‚È‚é‚Ì‚Å?A‚±‚Ì–_‚Í•`‚­?B
			}

			if (oekaki_flg == 1) {//–_‚ð•`‚­?B
				s_ob.set(Smen_zu.getmaex(ib), Smen_zu.getmaey(ib), Smen_zu.getatox(ib), Smen_zu.getatoy(ib));
				s_tv.set(camera.object2TV(s_ob));
				//g2.draw(new Line2D.Double( gx(s_tv.getax()),gy(s_tv.getay()),gx(s_tv.getbx()),gy(s_tv.getby())));
				g.drawLine(gx(s_tv.getax()), gy(s_tv.getay()), gx(s_tv.getbx()), gy(s_tv.getby())); //’¼??
				//g.drawLine( gx(Smen_zu.getmaex(ib)),gy(Smen_zu.getmaey(ib)),gx(Smen_zu.getatox(ib)),gy(Smen_zu.getatoy(ib))); //’¼??
			}


		}


		//g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);//ƒAƒ“ƒ`ƒFƒCƒŠƒAƒX?@ƒIƒt


		//System.out.println("?ã‰º•\?E?l?@oekaki_with_camera+++++++++++++++?ÜŽ†•\Ž¦?@?I—¹");
		//}


		//camera’†?S‚ð?\Žš‚Å•`‚­
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

		//?Ü‚è?ã‚ª‚è?}‚ð•`‚­‚Æ‚«‚Ìim”Ô–Ú‚ÌSmen‚Ì‘½ŠpŒ`‚Ì’¸“_‚Ì?À•W?iPC•\Ž¦???j‚ð??‚ß‚é‚Ì‚Í‚±‚±‚Ü‚Å

		g.fill(new Polygon(x, y, faces.getTenidsuu(id)));
	}


	//---------------------------------------------------------
	public void oekaki_jyuuji_with_camera(Graphics g) {
		//System.out.println("?Ü‚è?ã‚ª‚è?}‚Ì“®‚©‚µ’†?S‚Ì?\Žš•\Ž¦");
		//System.out.println("?ã‰º•\?E?l?@oekaki_jyuuji_with_camera+++++++++++++++?Ü‚è?ã‚ª‚è?}‚Ì“®‚©‚µ’†?S‚Ì?\Žš•\Ž¦");
		OritaOekaki OO = new OritaOekaki();

		//camera’†?S‚ð?\Žš‚Å•`‚­
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

	public int bou_no_bangou_kara_kagenoaru_Smen_no_bangou_wo_motomeru(int ib, Tensyuugou Smen_zu, int omote_ura) {//–_‚Ì”Ô??‚©‚ç?A‚»‚Ì–_‚Ì‰e‚ª”­?¶‚·‚éSmen ‚Ì”Ô??‚ð??‚ß‚é?B‰e‚ª”­?¶‚µ‚È‚¢???‡‚Í0‚ð•Ô‚·?B

		int i_return = 0;

		int Mid_min, Mid_max; //–_‚Ì—¼‘¤‚ÌSmen‚Ì”Ô??‚Ì?¬‚³‚¢‚Ù‚¤‚ªMid_min,?@‘å‚«‚¢‚Ù‚¤‚ªMid_max
		int Men_jyunban_min, Men_jyunban_max;//PC‰æ–Ê‚É•\Ž¦‚µ‚½‚Æ‚«Smen(Mid_min) ‚ÅŒ©‚¦‚é–Ê‚Ì?A‚»‚ÌSmen‚Å‚Ì?d‚È‚è?‡‚ªMen_jyunban_min?ASmen(Mid_max) ‚ÅŒ©‚¦‚é–Ê‚Ì‚»‚ÌSmen‚Å‚Ì?d‚È‚è?‡‚ªMen_jyunban_max

		Mid_min = Smen_zu.Bou_moti_Menid_min_motome(ib);//–_ib‚ð‹«ŠE‚Æ‚µ‚ÄŠÜ‚Þ–Ê(?Å‘å‚Å2–Ê‚ ‚é)‚Ì‚¤‚¿‚ÅMenid‚Ì?¬‚³‚¢‚Ù‚¤‚ÌMenid‚ð•Ô‚·?B–_‚ð‹«ŠE‚Æ‚µ‚ÄŠÜ‚Þ–Ê‚ª–³‚¢???‡‚Í0‚ð•Ô‚·
		Mid_max = Smen_zu.Bou_moti_Menid_max_motome(ib);

		if (s0[Mid_min].getMenidsuu() == 0) {
			return 0;
		}//men‚ð‚à‚½‚È‚¢?Aƒh?[ƒiƒc‚ÌŒŠ?ó‚ÌSmen‚Æ‚Ì‹«ŠE‚Ì–_‚É‚Í‰e‚È‚µ
		if (s0[Mid_max].getMenidsuu() == 0) {
			return 0;
		}//men‚ð‚à‚½‚È‚¢?Aƒh?[ƒiƒc‚ÌŒŠ?ó‚ÌSmen‚Æ‚Ì‹«ŠE‚Ì–_‚É‚Í‰e‚È‚µ
		if (Mid_min == Mid_max) {
			return 0;
		}//ˆê–{‚Ì–_‚Ì•Ð–Ê‚¾‚¯‚ÉSmen—L‚è

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
		}//‚±‚Ì–_‚Å—×?Ú‚·‚éSmen‚ÅŒ©‚¦‚Ä‚é–Ê‚ª“¯‚¶‚È‚Ì‚Å?A–_Ž©‘Ì‚ª•`‚©‚ê‚¸‰e‚à‚È‚µ?B


		//Jyougehyou
		//public int get(int i,int j){return jg[i][j];}
		//?@jg[i][j]‚ª1‚È‚ç–Êi‚Í–Êj‚Ì?ã‘¤?B0‚È‚ç‰º‘¤?B
		//  jg[i][j]‚ª-50‚È‚ç?A–Êi‚Æj‚Í?d‚È‚ª?A?ã‰ºŠÖŒW‚ÍŒˆ‚ß‚ç‚ê‚Ä‚¢‚È‚¢?B
		//jg[i][j]‚ª-100‚È‚ç?A–Êi‚Æj‚Í?d‚È‚é‚Æ‚±‚ë‚ª‚È‚¢?B
		if (jg.get(Mid_min_mieteru_men_id, Mid_max_mieteru_men_id) == -50) {
			return 0;
		}//‚±‚Ì–_‚Å—×?Ú‚·‚éSmen‚ÅŒ©‚¦‚Ä‚é–Ê‚Ì?ã‰ºŠÖŒW•s–¾‚È‚Ì‚Å?A‰e‚Í‚È‚µ
		if (jg.get(Mid_min_mieteru_men_id, Mid_max_mieteru_men_id) == -100) {
			return 0;
		}//‚±‚Ì–_‚Å—×?Ú‚·‚éSmen‚ÅŒ©‚¦‚Ä‚é–Ê‚Ì?ã‰ºŠÖŒW‚È‚¢?i?d‚È‚ç‚È‚¢?j‚Ì‚Å?A‰e‚Í‚È‚µ

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
		double katen=100.0;//‰Á“_
		for (int ism=1; ism<=Smensuu; ism++ ){
			int Mensuu=	s0[ism].getMenidsuu();//Smen‚Å‚Ì–Ê??
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
							if (jg.get(ia, ib) == 1) {//wiki‚ÌƒC??ƒŒ?[ƒeƒBƒ“ƒO‚Ì?«ŠûƒNƒ‰ƒu24ŽQ?Æ
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
						if(jg.get(ia,ib)==1){//wiki‚ÌƒC??ƒŒ?[ƒeƒBƒ“ƒO‚Ì?«ŠûƒNƒ‰ƒu24ŽQ?Æ
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

	int makesuu0no_menno_kazu = 0;//?ã‚É‘¼‚Ì–Ê‚ª‚È‚¢?ó‘Ô‚Å?‡ˆÊ•t‚¯‚Å‚«‚é–Ê‚Ì??
	int makesuu1ijyouno_menno_kazu = 0;//?ã‚É‘¼‚Ì–Ê‚ª1ˆÈ?ã‚?‚é?ó‘Ô‚Å‚È‚¢‚Æ?‡ˆÊ•t‚¯‚Å‚«‚È‚¢–Ê‚Ì??

	private void rating2() {
		int jgms = jg.getMensuu();//–Ê‚Ì???”‚ð‹?‚ß‚é?B
//System.out.println("*********  rating2()   *************");
		double[] men_r = new double[jgms + 1];
		men_rating = men_r;

		int[] i_m_r = new int[jgms + 1];//Še–Ê‚Ì?®?”ƒ??[ƒeƒBƒ“ƒO?irating2()‚ÅŽg‚¤?j?j
		i_men_rating = i_m_r;


		makesuu0no_menno_kazu = 0;//?ã‚É‘¼‚Ì–Ê‚ª‚È‚¢?ó‘Ô‚Å?‡ˆÊ•t‚¯‚Å‚«‚é–Ê‚Ì??
		makesuu1ijyouno_menno_kazu = 0;//?ã‚É‘¼‚Ì–Ê‚ª1ˆÈ?ã‚?‚é?ó‘Ô‚Å‚È‚¢‚Æ?‡ˆÊ•t‚¯‚Å‚«‚È‚¢–Ê‚Ì??


		for (int i = 0; i <= jgms; i++) {
			i_men_rating[i] = 0;
		}


//s–Ê‚Ì‚P‚©‚ç?‡‚Éˆê”Ô?ã‚É‚ ‚é–Ê‚ð??‚ß‚é?iƒŒ?[ƒg‚ª‚Â‚¢‚½–Ê‚Í?œ‚­?j?B
//s–Ê‚Ì‚P‚©‚ç?‡‚É‚»‚Ì–Ê‚Ì?ã‚É‚ ‚é–Ê???iƒŒ?[ƒg‚ª‚Â‚¢‚½–Ê‚Í?œ‚­?j‚ð??‚ß?A??Œv‚ð??‚ß‚é
//‚»‚Ì–Ê‚Ì?ã‚Ì‚ ‚é–Ê???iƒŒ?[ƒg‚ª‚Â‚¢‚½–Ê‚Í?œ‚­?j‚ª?Å?¬‚Ì–Ê‚ð??‚ßƒŒ?[ƒg‚ð‚Â‚¯‚é


		for (int i = 1; i <= jgms; i++) {
			int i_rate = 1 + jgms - i;


			int top_men_id = get_top_men_id_without_rated_men();

//System.out.println("*********  rating2()   rating = "+i_rate+"   top_men_id = "+top_men_id);

			i_men_rating[top_men_id] = i_rate;
			men_rating[top_men_id] = i_rate;
		}

//System.out.println("*********  rating2()   end *************");


		System.out.println("?ã‚É‘¼‚Ì–Ê‚ª‚È‚¢?ó‘Ô‚Å?‡ˆÊ•t‚¯‚Å‚«‚½–Ê‚Ì?? = " + makesuu0no_menno_kazu);
		System.out.println("?ã‚É‘¼‚Ì–Ê‚ª1ˆÈ?ã‚?‚é?ó‘Ô‚Å?‡ˆÊ•t‚¯‚µ‚½–Ê‚Ì?? = " + makesuu1ijyouno_menno_kazu);











/*

		Random rand = new Random();
		double dr=0.0;
		double men_r[]= new double[jgms+1]; ;
		men_rating=men_r;

		for (int im=1; im<=jgms; im++ ){ men_rating[im]=10000.0;}
*/
/*
		//------------------------------------------------------------------------------
		double katen=100.0;//‰Á“_
		for (int ism=1; ism<=Smensuu; ism++ ){
			int Mensuu=	s0[ism].getMenidsuu();//Smen‚Å‚Ì–Ê??
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
							if(jg.get(ia,ib)==1){//wiki‚ÌƒC??ƒŒ?[ƒeƒBƒ“ƒO‚Ì?«ŠûƒNƒ‰ƒu24ŽQ?Æ
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
						if(jg.get(ia,ib)==1){//wiki‚ÌƒC??ƒŒ?[ƒeƒBƒ“ƒO‚Ì?«ŠûƒNƒ‰ƒu24ŽQ?Æ
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
//ˆÈ‰º‚ÌŠeŠÖ?”‚Å‚ÍSmen‚Æ‚µ‚Äs0[]‚ðŽg‚¤20180305


	private int top_men_id_ga_maketa_kazu_goukei_without_rated_men = 0;

	//------------------------------------------------------------
	private int get_top_men_id_without_rated_men() {
//System.out.println("20180307*********   get_top_men_id_without_rated_men()   *************");
		int top_men_id = 0;
		top_men_id_ga_maketa_kazu_goukei_without_rated_men = jg.getMensuu() + 100;


		int jgms = jg.getMensuu();//–Ê‚Ì???”‚ð‹?‚ß‚é?B

		int[] i_kentouzumi = new int[jgms + 1];//ŒŸ“¢?Ï‚Ý‚Ì–ÊID‚Í‚P‚É‚·‚é
		for (int i = 0; i <= jgms; i++) {
			i_kentouzumi[i] = 0;
		}

		for (int i = 1; i <= Smensuu; i++) {
			int s_top_id = get_s_top_id_without_rated_men(i);//Šes–Ê‚Ì?iƒŒ?[ƒg‚ª‚Â‚¢‚½–Ê‚Í?œ‚­?jˆê”Ô?ã‚Ì–Ê?Bs_top_id=0‚È‚ç‚»‚Ìs–Ê‚É‚ÍƒŒ?[ƒg‚ª–¢’è‚Ì–Ê‚Í‚È‚¢
			//System.out.println("*********   get_top_men_id_without_rated_men()   Smen ID = "+I+"  s_top_id = "+s_top_id+  "   •‰‚¯?? = "+get_maketa_kazu_goukei_without_rated_men(s_top_id));


			if (s_top_id != 0) {
				if (i_kentouzumi[s_top_id] == 0) {
					//int makesuu=get_maketa_kazu_goukei_without_rated_men(s_top_id);
					//System.out.println("*********     Smen ID = "+i+"  s_top_id = "+s_top_id+  "   •‰‚¯?? = "+get_maketa_kazu_goukei_without_rated_men(s_top_id));


					int mkg = get_maketa_kazu_goukei_without_rated_men(s_top_id);
					if (mkg == 0) {
						makesuu0no_menno_kazu = makesuu0no_menno_kazu + 1;
						return s_top_id;
					}//‚±‚±‚Í?A‚±‚ê‚Å‚æ‚¢‚©—vŒŸ“¢20180306
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
		//makesuu0no_menno_kazu=0;//?ã‚É‘¼‚Ì–Ê‚ª‚È‚¢?ó‘Ô‚Å?‡ˆÊ•t‚¯‚Å‚«‚é–Ê‚Ì??
		//makesuu1ijyouno_menno_kazu=0;//?ã‚É‘¼‚Ì–Ê‚ª1ˆÈ?ã‚?‚é?ó‘Ô‚Å‚È‚¢‚Æ?‡ˆÊ•t‚¯‚Å‚«‚È‚¢–Ê‚Ì??
		if (top_men_id_ga_maketa_kazu_goukei_without_rated_men == 0) {
			makesuu0no_menno_kazu = makesuu0no_menno_kazu + 1;
		} else if (top_men_id_ga_maketa_kazu_goukei_without_rated_men > 0) {
			makesuu1ijyouno_menno_kazu = makesuu1ijyouno_menno_kazu + 1;
		}


//System.out.println("*?ã‚É‘¼‚Ì–Ê‚ª‚È‚¢?ó‘Ô‚Å?‡ˆÊ•t‚¯‚Å‚«‚½–Ê‚Ì?? = "+makesuu0no_menno_kazu);
//System.out.println("*?ã‚É‘¼‚Ì–Ê‚ª1ˆÈ?ã‚?‚é?ó‘Ô‚Å?‡ˆÊ•t‚¯‚µ‚½–Ê‚Ì?? = "+makesuu1ijyouno_menno_kazu);


		return top_men_id;
	}

//-----------------------------------

	private int get_s_top_id_without_rated_men(int ism) {//ism‚Ís–Ê‚Ìid
//System.out.println("*********   get_s_top_id_without_rated_men   *************");
		int Mensuu = s0[ism].getMenidsuu();//Smen‚Å‚Ì–Ê??//Smen s0[];//Smen_zu‚©‚ç“¾‚ç‚ê‚éSmen
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
			}//20180306?‚‘¬‰»‚Ì‚½‚ß‚±‚Ì‚P?s‚ð“ü‚ê‚Ä‚¢‚é‚ª?A–{“–‚ÉŒø‰Ê‚ª‚ ‚é‚©‚Í•s–¾?B‚±‚Ì?s‚¾‚¯ƒR??ƒ“ƒgƒAƒEƒg‚µ‚Ä‚à?³?úžÉ‚Í“®‚­‚Í‚¸?B

		}
//System.out.println("*********   get_maketa_kazu_goukei_without_rated_men   end *************");
		return i_make;
	}


	//-----------------------------------
	private int get_smen_de_maketa_kazu_without_rated_men(int ism, int men_id) {//ism‚Ísmen‚Ìid
//System.out.println("*********   get_smen_de_maketa_kazu_without_rated_men   *************");
		int Mensuu = s0[ism].getMenidsuu();//Smen‚Å‚Ì–Ê??//Smen s0[];//Smen_zu‚©‚ç“¾‚ç‚ê‚éSmen
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


