package jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin;

import jp.gr.java_conf.mt777.origami.dougu.camera.Camera;
import jp.gr.java_conf.mt777.origami.dougu.tensyuugou.Tensyuugou;
import jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin.jyougehyou.Jyougehyou;
import jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin.smen.Smen;
import jp.gr.java_conf.mt777.origami.orihime.tenkaizu_syokunin.Tenkaizu_Syokunin;
import jp.gr.java_conf.mt777.zukei2d.oritaoekaki.OritaOekaki;
import jp.gr.java_conf.mt777.zukei2d.senbun.Senbun;

import java.awt.*;


public class Jyougehyou_Syokunin {//?ã‰º•\?@?Ü‚è‚½‚½‚Þ‘O‚Ì“WŠJ?}‚Ì–Ê‚ª?Ü‚è‚½‚½‚ñ‚¾‚ ‚Æ‚Å‚Ç‚Ì‚æ‚¤‚È?ã‰ºŠÖŒW‚É‚È‚é‚©‚ð‹L˜^‚µŠˆ—p‚·‚é
	//String c=new String();
	//int Mensuu;             //?Ü‚è‚½‚½‚Þ‘O‚Ì“WŠJ?}‚Ì–Ê‚Ì?”
	Jyougehyou jg = new Jyougehyou();
	//Jyougehyou jg;// =new Jyougehyou();
	//Jyougehyou jg_syokiti =new Jyougehyou();//“WŠJ?}‚Ì‚Ý‚©‚ç“¾‚ç‚ê‚é?ã‰ºŠÖŒW‚ð‹L˜^‚µ‚Ä‚¨‚­?B
	int Smensuu;//Smen‚Ì?”
	int Smen_yuukou_suu;//Smen‚Í‘S‚Ä’²‚×‚È‚­‚Ä‚à?AMen‚Ì?ã‰ºŠÖŒW‚Í–Ô—…‚Å‚«‚é?BMen‚Ì?ã‰ºŠÖŒW‚ð–Ô—…‚·‚é‚Ì‚É•K—v‚ÈSmen‚Ì?”‚ª—D?æ?‡ˆÊ‚Ì‰½”Ô–Ú‚Ü‚Å‚©‚ð‚³‚ª‚·?B
	int Menidsuu_max;//ŠeSmen‚ÌŽ?‚ÂMenidsuu‚Ì?Å‘å’l?B‚·‚È‚í‚¿?A?Å‚àŽ†‚É?d‚È‚è‚ª‘½‚¢‚Æ‚±‚ë‚Ì–‡?”?B
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

	Camera camera = new Camera();

	public Jyougehyou_Syokunin() {
		reset();
	}    //ƒRƒ“ƒXƒgƒ‰ƒNƒ^

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
	//?ã‰º•\‚Ì?‰Šú?Ý’è?B“WŠJ?}‚É1’¸“_‚©‚çŠï?”‚Ì?Ü?ü‚ª‚Å‚éŒë‚è‚ª‚ ‚é?ê?‡0‚ð•Ô‚·?B‚»‚ê‚ª–³‚¯‚ê‚Î1000‚ð•Ô‚·?B
	//“WŠJ?}‚ÉŽR’J?Ü?ü‚ÌŠg’£‚É‚æ‚éŒë‚è‚ª‚ ‚é?ê?‡2‚ð•Ô‚·?B

	//----------------------------------------------------------------------
/*
	public int Jyougehyou_settei  (Tenkaizu_Syokunin orite,Tensyuugou otta_Men_zu,Tensyuugou Smen_zu){//js.Jyougehyou_settei(ts1,ts2.get(),ts3.get()){
         	Smen_settei           (                  orite,           otta_Men_zu,           Smen_zu);
         return Jyougehyou_settei_2   (                  orite,           otta_Men_zu,           Smen_zu);
       }
*/
	public void Smen_settei(Tenkaizu_Syokunin orite, Tensyuugou otta_Men_zu, Tensyuugou Smen_zu) {//js.Jyougehyou_settei(ts1,ts2.get(),ts3.get());
		//–Ê(?Ü‚è‚½‚½‚Þ‘O‚Ì“WŠJ?}‚Ì–Ê‚Ì‚±‚Æ)‚Ì?ã‰º•\‚ð?ì‚é?B
		//‚±‚ê‚É‚Íts2‚ÌŽ?‚Â“_?W?‡?i?Ü‚è‚½‚½‚ñ‚¾‚ ‚Æ‚Ì–Ê‚ÌˆÊ’uŠÖŒW‚Ì?î•ñ‚ðŽ?‚Â?j‚Æ  <-------------otta_Men_zu
		//ts3‚ÌŽ?‚Â“_?W?‡?i?j‹à?}‚Å–Ê‚ð?×•ªŠ„‚µ‚½Smen‚Ì?î•ñ‚ðŽ?‚Â?j‚ðŽg‚¤?B <-------------Smen_zu
		//‚Ü‚½?Ats1‚ÌŽ?‚Â?A?Ü‚Á‚½‚Æ‚«‚Ì–Ê‚ÌˆÊ’uŠÖŒW‚Ì?î•ñ‚àŽg‚¤?B


		System.out.println("Smen‚Ì?‰Šú?Ý’è");
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
					s0[i].addMenid(j)	;//‚±‚±‚Å–Ê”Ô?†j‚Í?¬‚³‚¢•û‚ª?æ‚É’Ç‰Á‚³‚ê‚é?B
				}
			}
                        s0[i].setKetasuu();
		}
*/

		for (int i = 1; i <= Smensuu; i++) {
			int s0addMenidsuu = 0;
			//System.out.println("Œ»?Ý?ˆ—?’†‚ÌSmen‚Í?A"+i+" / "+Smensuu );
			//for(int j=1;j<=jg.getMensuu();j++){

			for (int j = 1; j <= otta_Men_zu.getMensuu(); j++) {

				//System.out.print("Œ»?Ý?ˆ—?’†‚ÌSmen‚Í?A"+i+" / "+Smensuu +"     :::     "   +j+"/"+jg.getMensuu()+"-");
				if (otta_Men_zu.kantan_naibu(Smen_naibuTen[i], j) == 2) {
					//System.out.println(j);
					s0addMenidsuu = s0addMenidsuu + 1;
					s0addMenid[s0addMenidsuu] = j;
				}

			}
			//if (s0addMenidsuu==0){
			//System.out.println("**1** Œ»?Ý?ˆ—?’†‚ÌSmen‚Í?A"+i+" / "+Smensuu+"  :::  s0addMenidsuu= "+s0addMenidsuu+" ::: –Ê?Ï= "+Smen_zu.menseki_motome(i));
			//}/////////20150308

			s0[i].setKetasuu(s0addMenidsuu);

			//System.out.println("**2**");
			for (int j = 1; j <= s0addMenidsuu; j++) {
				s0[i].setMenid(j, s0addMenid[j]);//‚±‚±‚Å–Ê”Ô?†j‚Í?¬‚³‚¢•û‚ª?æ‚É’Ç‰Á‚³‚ê‚é?B
			}
			//System.out.println("**3**");
		}


//4956                     System.out.print("Smensuu = "); System.out.println(Smensuu);System.exit(0);
//‚±‚±‚Ü‚Å‚Å?ASmensuu??	Smen_zu.getMensuu()‚Ì‚Ü‚Ü‚©‚í‚è‚È‚µ?B
		System.out.println("ŠeSmen‚ÉŠÜ‚Ü‚ê‚é–Ê‚Ì?”‚Ì“à‚Å?Å‘å‚Ì‚à‚Ì‚ð‹?‚ß‚é");
		//ŠeSmen‚ÉŠÜ‚Ü‚ê‚é–Ê‚Ì?”‚Ì“à‚Å?Å‘å‚Ì‚à‚Ì‚ð‹?‚ß‚é?B
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

		//ŽR?Ü‚è’J?Ü‚è‚Ì?î•ñ‚©‚çŒˆ’è‚³‚ê‚é?ã‰ºŠÖŒW‚ð?ã‰º•\‚É“ü‚ê‚é
		System.out.println("ŽR?Ü‚è’J?Ü‚è‚Ì?î•ñ‚©‚çŒˆ’è‚³‚ê‚é?ã‰ºŠÖŒW‚ð?ã‰º•\‚É“ü‚ê‚é");
		int Mid_min, Mid_max;
		for (int ib = 1; ib <= orite.getBousuu(); ib++) {
			Mid_min = orite.Bou_moti_Menid_min_motome(ib);
			Mid_max = orite.Bou_moti_Menid_max_motome(ib);
			if (Mid_min != Mid_max) {//“WŠJ?}‚É‚¨‚¢‚Ä?A–_ib‚Ì—¼˜e‚É–Ê‚ª‚ ‚é
				//if(orite.getcolor(ib)==1){//?Ô‚¢?ü‚ÅŽR?Ü‚è‚ðˆÓ–¡‚·‚é
				if (otta_Men_zu.getcolor(ib) == 1) {//?Ô‚¢?ü‚ÅŽR?Ü‚è‚ðˆÓ–¡‚·‚é
					if (orite.getiMeniti(Mid_min) % 2 == 1) {//–ÊMid_min‚ÍŠî?€–Ê‚Æ“¯‚¶Œü‚«(•\–Ê‚ª?ã‚ðŒü‚­)
						jg.set(Mid_min, Mid_max, 1);
						jg.set(Mid_max, Mid_min, 0);
					}
					if (orite.getiMeniti(Mid_max) % 2 == 1) {//–ÊMid_max‚ÍŠî?€–Ê‚Æ“¯‚¶Œü‚«(•\–Ê‚ª?ã‚ðŒü‚­)
						jg.set(Mid_max, Mid_min, 1);
						jg.set(Mid_min, Mid_max, 0);
					}
				}
				//if(orite.getcolor(ib)==2){//?Â‚¢?ü‚Å’J?Ü‚è‚ðˆÓ–¡‚·‚é
				if (otta_Men_zu.getcolor(ib) == 2) {//?Â‚¢?ü‚Å’J?Ü‚è‚ðˆÓ–¡‚·‚é
					if (orite.getiMeniti(Mid_min) % 2 == 1) {//–ÊMid_min‚ÍŠî?€–Ê‚Æ“¯‚¶Œü‚«(•\–Ê‚ª?ã‚ðŒü‚­)
						jg.set(Mid_min, Mid_max, 0);
						jg.set(Mid_max, Mid_min, 1);
					}
					if (orite.getiMeniti(Mid_max) % 2 == 1) {//–ÊMid_max‚ÍŠî?€–Ê‚Æ“¯‚¶Œü‚«(•\–Ê‚ª?ã‚ðŒü‚­)
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


		System.out.println("“™‰¿?ðŒ?‚ð?Ý’è‚·‚é   ");
		//“™‰¿?ðŒ?‚ð?Ý’è‚·‚é?B–_ib‚Ì‹«ŠE‚Æ‚µ‚Ä—×?Ú‚·‚é2‚Â‚Ì–Êim1,im2‚ª—L‚é?ê?‡?A?Ü‚è?ô‚Ý?„’è‚µ‚½?ê?‡‚É
		//–_ib‚Ìˆê•”‚Æ?d‚È‚éˆÊ’u‚É—L‚é–Êim‚Í–Êim1‚Æ–Êim2‚É?ã‰º•ûŒü‚Å‹²‚Ü‚ê‚é‚±‚Æ‚Í‚È‚¢?B‚±‚Ì‚±‚Æ‚©‚ç
		//gj[im1][im]=gj[im2][im]‚Æ‚¢‚¤“™‰¿?ðŒ?‚ª?¬‚è—§‚Â?B
		for (int ib = 1; ib <= orite.getBousuu(); ib++) {
			Mid_min = orite.Bou_moti_Menid_min_motome(ib);
			Mid_max = orite.Bou_moti_Menid_max_motome(ib);
			if (Mid_min != Mid_max) {//“WŠJ?}‚É‚¨‚¢‚Ä?A–_ib‚Ì—¼˜e‚É–Ê‚ª‚ ‚é
				for (int im = 1; im <= jg.getMensuu(); im++) {
					if ((im != Mid_min) && (im != Mid_max)) {
						if (otta_Men_zu.kantan_totu_naibu(ib, im) == 1) {
							//‰º‚Ì‚Q‚Â‚Ìif‚ÍŽb’è“I‚È?ˆ—??B‚ ‚Æ‚Å’u‚«Š·‚¦—\’è
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
		System.out.print("‚R–Ê‚ªŠÖ—^‚·‚é“Ë‚«”²‚¯?ðŒ?‚Ì?”?@???@");
		System.out.println(jg.getTouka_jyoukensuu());

		//“™‰¿?ðŒ?‚Ì’Ç‰Á?B–_ib‚Ì‹«ŠE‚Æ‚µ‚Ä—×?Ú‚·‚é2‚Â‚Ì–Êim1,im2‚ª—L‚è?A
		//‚Ü‚½–_jb‚Ì‹«ŠE‚Æ‚µ‚Ä—×?Ú‚·‚é2‚Â‚Ì–Êim3,im4‚ª—L‚è?Aib‚Æjb‚ª•½?s‚Å?Aˆê•”?d‚È‚é?ê?‡?A?Ü‚è?ô‚Ý?„’è‚µ‚½?ê?‡‚É
		//–_ib‚Ì–Ê‚Æ–Êjb‚Ì–Ê‚ªi,j,i,j?@‚Ü‚½‚Í?@j,i,j,i?@‚Æ•À‚Ô‚±‚Æ‚Í‚È‚¢?B‚à‚µ‚±‚ê‚ª‚¨‚«‚½‚ç?A
		//?Å?‰‚©‚ç3”Ô–Ú‚ÅŠÔˆá‚¢‚ª‹N‚«‚Ä‚¢‚é‚Ì‚Å?A‚±‚Ì3”Ô–Ú‚Ì‚Æ‚±‚ë‚ªSmen‚Å‰½Œ…–Ú‚©‚ð‹?‚ß‚Ä?A‚±‚ÌŒ…‚ð‚P?i‚ß‚é?B
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
		System.out.print("‚S–Ê‚ªŠÖ—^‚·‚é“Ë‚«”²‚¯?ðŒ?‚Ì?”?@???@");
		System.out.println(jg.get_uTouka_jyoukensuu());
//5154                      System.out.print("Smensuu = "); System.out.println(Smensuu);System.exit(0);


		//’Ç‰Á?„’è
		int ituika;

		ituika = tuika_suitei();
		if (ituika != 1000) {
			return ituika;
		}

		System.out.println("’Ç‰Á?„’è ?I—¹‚µ?A?ã‰º•\‚ð•Û‘¶------------------------?–?–?–?–?–?–?–?–?–?–?–?–?–?–?–?–?–?–?–?–?–");


		//*************?Å?‰‚É?s‚¤‰‰ãˆ“I?„˜_‚ÌŒ‹‰Ê‚Ì•Û‘¶**************************
		jg.jg_hozon();//ŽR?Ü‚è’J?Ü‚è‚Ì?î•ñ‚©‚çŒˆ’è‚³‚ê‚é?ã‰ºŠÖŒW‚ð•Û‘¶‚µ‚Ä‚¨‚­?B
		//************************************************************************

		//Smen–ˆ‚ÉˆÄ“à?‘‚ð?ì‚é
		System.out.println("Smen–ˆ‚ÉˆÄ“à?‘‚ð?ì‚é");
		for (int i = 1; i <= Smensuu; i++) {
			//System.out.print("Smen");System.out.print(i);System.out.println("‚É‚Ä?B");
			s0[i].setAnnaisyo(jg);
		}

		//s0‚É—D?æ?‡ˆÊ‚ð‚Â‚¯‚é(‚±‚Ì‚Æ‚«jg‚Ì-100‚Ì‚Æ‚±‚ë‚ª•Ï‚é‚Æ‚±‚ë‚ª‚ ‚é)
		System.out.println("Smen(s0)‚É—D?æ?‡ˆÊ‚ð‚Â‚¯‚é");
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
				if (s0_no_yusenjyun[is0] == 0) {//‚Ü‚¾—D?æ?‡ˆÊ‚ª‚Â‚¢‚Ä‚¢‚È‚¢Smen‚¾‚¯‚ðˆµ‚¤
					Sy = Smenid_yusendo(is0)/*+Smen_no_dokujisei[is0]*/;//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
					if (yusendo_max < Sy) {
						yusendo_max = Sy;
						i_yusen = is0;// i_yusen‚ªi”Ô–Ú‚Ì—D?æ“x‚ð’T‚µ‚Ä‚¢‚é?Û‚Ì?Å‚à—L—Í‚ÈŒó•â‚Ì”Ô?†
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
		//System.out.println(Smensuu );
		//System.out.println("s0‚É—D?æ?‡ˆÊ‚ð‚Â‚¯‚é" );
		//for(int i=1;i<=Smensuu;i++){System.out.println(s0_no_yusenjyun[i]);}
		//System.out.println("—D?æ“x‚©‚çs0‚Ìid" );
		for (int i = 1; i <= Smensuu; i++) {
			//System.out.println(yusenjyun_kara_s0id[i]);
			if (i_yusendo_max[yusenjyun_kara_s0id[i]] != 0) {

				Smen_yuukou_suu = i;       //‘?‚¢‚ª•Ï‚ÈŒ‹‰Ê‚É‚È‚é‚±‚Æ‚ ‚è?B


				//	Smen_yuukou_suu=Smensuu;//’x‚¢‚ªŠmŽÀ

//System.out.print("‘æ");
//System.out.print(i);
//System.out.print("ˆÊ(–¢’èƒyƒA?”??");
//System.out.print(i_yusendo_max[yusenjyun_kara_s0id[i]]);

//System.out.print("?@||?@");


			}


		}

		System.out.println();
		//

		for (int i = 1; i <= Smensuu; i++) {
			s[i] = s0[yusenjyun_kara_s0id[i]];
		}

		//—D?æ?‡ˆÊ‚ð‹t“]‚³‚¹‚é?B‚±‚ê‚ª—LŒø‚©‚Ç‚¤‚©‚Í•s–¾
		//for(int i=1;i<=Smen_yuukou_suu;i++){s[Smen_yuukou_suu-i+1]=s0[yusenjyun_kara_s0id[i]];}

/*
        for(int i=1;i<=Smensuu;i++){
                       if(i_yusendo_max[yusenjyun_kara_s0id[i]]!=0){
System.out.print("‘æ");
System.out.print(i);
System.out.print("ˆÊ(–¢’èƒyƒA?”??");
System.out.print(i_yusendo_max[yusenjyun_kara_s0id[i]]);
System.out.print("?A–Ê?”??");
System.out.print(s[i].getMenidsuu());
System.out.print("?@||?@");
                        }
      }

System.out.println();
 */


		//Smen‚Í—D?æ?‡‚Ì‰½”Ô–Ú‚Ü‚Å‚â‚é‚©‚ðŒˆ‚ß‚é
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


		//jg[][]‚Ì?d‚È‚è‚Ì‚ ‚é–Ê‚Ì‘g‚Ý?‡‚í‚¹‚ÌˆÊ’u‚Ì’l‚ð-100‚©‚ç-50‚É•Ï‚¦‚é?B
		for (int k = 1; k <= Smensuu; k++) {
			for (int i = 1; i <= s[k].getMenidsuu() - 1; i++) {
				for (int j = i + 1; j <= s[k].getMenidsuu(); j++) {
					jg.set(i, j, -50);
					jg.set(j, i, -50);
				}
			}
		}
		System.out.println("?ã‰º•\?‰Šú?Ý’è?I—¹");

		//System.out.print("–Ê?”‚Í1?@");  System.out.println(s[1].getMenidsuu());
		return ireturn;


	}

	//------------------------------------------------------------
	public int tuika_suitei() {
		//ŽR?Ü‚è’J?Ü‚è‚Ì?î•ñ‚©‚ç?X‚ÉŒˆ’è‚Å‚«‚éŠÖŒW‚ð?„‘ª‚µ‚Ä‚¢‚­?B

		int Mid;//3–Ê‚Ì”äŠr‚Å’†ŠÔ‚É‚­‚é–Ê
		int flg_c = 1;
		System.out.println("’Ç‰Á?„’èŠJŽn---------------------?–?–?–?–?–?–?–?–?–?–?–?–?–?–?–?–?–?–?–?–?–?–");

		while (flg_c >= 1) {
			flg_c = 0;
			System.out.println("’Ç‰Á?„’è------------------------");
			//System.out.println("ŽR?Ü‚è’J?Ü‚è‚Ì?î•ñ‚©‚ç’Ç‰Á?„’è   " );

			int flg_b = 1;
			while (flg_b >= 1) {
				flg_b = 0;

				for (int iS = 1; iS <= Smensuu; iS++) {

					int flg_a = 1;
					while (flg_a >= 1) {
						flg_a = 0;
						for (int iM = 1; iM <= s0[iS].getMenidsuu(); iM++) {//3–Ê‚Ì”äŠr‚Å’†ŠÔ‚É‚­‚é–Ê
							int[] ueMenid = new int[s0[iS].getMenidsuu() + 1];//S–Ê‚ÉŠÜ‚Ü‚ê‚é‚ ‚éMen‚Ì?ã‚ª‚í‚É‚ ‚éid”Ô?†‚ð‹L˜^‚·‚é?B‚±‚ê‚ª20‚Æ‚¢‚¤‚±‚Æ‚Í?A
							int[] sitaMenid = new int[s0[iS].getMenidsuu() + 1];//S–Ê‚ÉŠÜ‚Ü‚ê‚é‚ ‚éMen‚Ì‰º‚ª‚í‚É‚ ‚éid”Ô?†‚ð‹L˜^‚·‚é?B‚±‚ê‚ª20‚Æ‚¢‚¤‚±‚Æ‚Í?A
							int ueMenid_max = 0;
							int sitaMenid_max = 0;
							Mid = s0[iS].getMenid(iM);

							//?l‚¦•û?F‚ ‚éSmen‚Ì‚ ‚é–ÊMid‚É‚Â‚¢‚Ä?l‚¦‚é?B
							//‚±‚ÌSmenˆÈŠO‚Å–ÊA‚Í–ÊMid‚Ì?ã‘¤?A–ÊB‚Í–ÊMid‚Ì‰º‘¤‚ÆŒˆ‚Ü‚Á‚Ä‚¢‚½‚Æ‚·‚é?B
							//ˆê”Ê‚É•Ê?X‚ÌSmen‚Å?A–ÊA‚Í–ÊMid‚Ì?ã‘¤‚Å?A–ÊB‚Í–ÊMid‚Ì‰º‘¤‚¾‚Á‚½‚©‚ç‚ÆŒ¾‚Á‚Ä?A–ÊA‚Í–ÊB‚Ì?ã‘¤‚Æ‚ÍŒˆ’è‚Å‚«‚È‚¢?B
							//‚µ‚©‚µ?A‚±‚±‚ªƒ|ƒCƒ“ƒg‚¾‚ª?A–ÊA?A–ÊMid?A–ÊB‚ª‚¢‚Á‚µ‚å‚ÉŠÜ‚Ü‚ê‚Ä‚¢‚éSmen‚ª‚ ‚é‚È‚ç?A‚»‚ÌSmen‚Ì?ã‰ºŠÖŒW‚ª‚í‚©‚Á‚Ä‚¢‚È‚­‚Ä‚à
							//–ÊA‚Í–ÊB‚Ì?ã‘¤‚Æ‚È‚é?B‚¾‚©‚ç?A‚±‚Ì‘€?ì‚Å‚Í‚ ‚éSmen‚©‚ç“¾‚é?î•ñ‚Í‚R‚Â‚Ì–Ê‚ª‚¢‚Á‚µ‚å‚É‚ ‚é‚©‚Æ‚¢‚¤‚±‚Æ‚Å‚ ‚é?B
							//‚ ‚éSmen“à‚Ì?ã‰ºŠÖŒW‚Í•K—v‚È‚¢?B
							//
							//‚±‚±‚Ì‘€?ì‚Í‚ ‚éSmen‚Ì?ã‰ºŠÖŒW‚ð?ã‰º•\‚©‚ç?Ì?W‚µ‚Ä‚¢‚é?B
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

									//  System.out.print(ueMenid[iuM]);System.out.print("<-?ã:‰º->");System.out.println(sitaMenid[isM]);


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

				//System.out.print("?„‘ª‚³‚ê‚½ŠÖŒW‚Ì?” ?? ");System.out.println(flg_b);
			}

			//
			//jg.jg_hozon();//ŽR?Ü‚è’J?Ü‚è‚Ì?î•ñ‚©‚çŒˆ’è‚³‚ê‚é?ã‰ºŠÖŒW‚ð•Û‘¶‚µ‚Ä‚¨‚­?B


			//jg ‚Ìreset“K?Ø‚É?s‚í‚ê‚Ä‚¢‚é‚©Šm”F‚Ì‚±‚Æ

			//System.out.println ("‚R–Ê‚ªŠÖ—^‚·‚é“Ë‚«”²‚¯?ðŒ?‚©‚ç’Ç‰Á?„’è   " );
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
				//System.out.print("?„‘ª‚³‚ê‚½ŠÖŒW‚Ì?”‚Í ?? ");System.out.println(flg_a);
			}

			//----------------

//	System.out.println ("‚S–Ê‚ªŠÖ—^‚·‚é“Ë‚«”²‚¯?ðŒ?‚©‚ç’Ç‰Á?„’è   " );
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
					//a>d && b>c ‚È‚ç a>c && b>d
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

					//a<c && b<d ‚È‚ç a<d && b<c
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
					//a<d && b<c ‚È‚ç a<c && b<d
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


					//?@a>c>b?@‚È‚ç?@a>d>b
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
					//?@a>d>b?@‚È‚ç?@a>c>b
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
					//?@b>c>a?@‚È‚ç?@b>d>a
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
					//?@b>d>a?@‚È‚ç?@b>c>a
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


					//?@c>a>d?@‚È‚ç?@c>b>d
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
					//?@c>b>d?@‚È‚ç?@c>a>d
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
					//?@d>a>c?@‚È‚ç?@d>b>c
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
					//?@d>b>c?@‚È‚ç?@d>a>c
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
				//System.out.print("?„‘ª‚³‚ê‚½ŠÖŒW‚Ì?”‚Í ?? ");System.out.println(flg_a);
			}

			//----------------

			System.out.print("?„‘ª‚³‚ê‚½ŠÖŒW‚Ì?”‚Ì?‡Œv ?? ");
			System.out.println(flg_c);

		}


		System.out.println("’Ç‰Á?„’è ?I—¹------------------------?–?–?–?–‚±‚±‚Ü‚Å20150310?–?–?–?–?–?–?–?–?–?–?–");

		return 1000;

	}

	//------------------------------------------

	private int tuika_suitei_2() {
		//ŽR?Ü‚è’J?Ü‚è‚Ì?î•ñ‚©‚ç?X‚ÉŒˆ’è‚Å‚«‚éŠÖŒW‚ð?„‘ª‚µ‚Ä‚¢‚­?B

		int Mid;//3–Ê‚Ì”äŠr‚Å’†ŠÔ‚É‚­‚é–Ê
		int flg_c = 1;
		System.out.println("’Ç‰Á?„’èŠJŽn---------------------?–?–?–?–?–?–?–?–?–?–?–?–?–?–?–?–?–?–?–?–?–?–");

		while (flg_c >= 1) {
			flg_c = 0;
			System.out.println("’Ç‰Á?„’è------------------------");
			//System.out.println("ŽR?Ü‚è’J?Ü‚è‚Ì?î•ñ‚©‚ç’Ç‰Á?„’è   " );

			int flg_b = 1;
			while (flg_b >= 1) {
				flg_b = 0;

				for (int iS = 1; iS <= Smensuu; iS++) {

					int flg_a = 1;
					while (flg_a >= 1) {
						flg_a = 0;
						for (int iM = 1; iM <= s0[iS].getMenidsuu(); iM++) {//3–Ê‚Ì”äŠr‚Å’†ŠÔ‚É‚­‚é–Ê
							int[] ueMenid = new int[s0[iS].getMenidsuu() + 1];//S–Ê‚ÉŠÜ‚Ü‚ê‚é‚ ‚éMen‚Ì?ã‚ª‚í‚É‚ ‚éid”Ô?†‚ð‹L˜^‚·‚é?B‚±‚ê‚ª20‚Æ‚¢‚¤‚±‚Æ‚Í?A
							int[] sitaMenid = new int[s0[iS].getMenidsuu() + 1];//S–Ê‚ÉŠÜ‚Ü‚ê‚é‚ ‚éMen‚Ì‰º‚ª‚í‚É‚ ‚éid”Ô?†‚ð‹L˜^‚·‚é?B‚±‚ê‚ª20‚Æ‚¢‚¤‚±‚Æ‚Í?A
							int ueMenid_max = 0;
							int sitaMenid_max = 0;
							Mid = s0[iS].getMenid(iM);

							//?l‚¦•û?F‚ ‚éSmen‚Ì‚ ‚é–ÊMid‚É‚Â‚¢‚Ä?l‚¦‚é?B
							//‚±‚ÌSmenˆÈŠO‚Å–ÊA‚Í–ÊMid‚Ì?ã‘¤?A–ÊB‚Í–ÊMid‚Ì‰º‘¤‚ÆŒˆ‚Ü‚Á‚Ä‚¢‚½‚Æ‚·‚é?B
							//ˆê”Ê‚É•Ê?X‚ÌSmen‚Å?A–ÊA‚Í–ÊMid‚Ì?ã‘¤‚Å?A–ÊB‚Í–ÊMid‚Ì‰º‘¤‚¾‚Á‚½‚©‚ç‚ÆŒ¾‚Á‚Ä?A–ÊA‚Í–ÊB‚Ì?ã‘¤‚Æ‚ÍŒˆ’è‚Å‚«‚È‚¢?B
							//‚µ‚©‚µ?A‚±‚±‚ªƒ|ƒCƒ“ƒg‚¾‚ª?A–ÊA?A–ÊMid?A–ÊB‚ª‚¢‚Á‚µ‚å‚ÉŠÜ‚Ü‚ê‚Ä‚¢‚éSmen‚ª‚ ‚é‚È‚ç?A‚»‚ÌSmen‚Ì?ã‰ºŠÖŒW‚ª‚í‚©‚Á‚Ä‚¢‚È‚­‚Ä‚à
							//–ÊA‚Í–ÊB‚Ì?ã‘¤‚Æ‚È‚é?B‚¾‚©‚ç?A‚±‚Ì‘€?ì‚Å‚Í‚ ‚éSmen‚©‚ç“¾‚é?î•ñ‚Í‚R‚Â‚Ì–Ê‚ª‚¢‚Á‚µ‚å‚É‚ ‚é‚©‚Æ‚¢‚¤‚±‚Æ‚Å‚ ‚é?B
							//‚ ‚éSmen“à‚Ì?ã‰ºŠÖŒW‚Í•K—v‚È‚¢?B
							//
							//‚±‚±‚Ì‘€?ì‚Í‚ ‚éSmen‚Ì?ã‰ºŠÖŒW‚ð?ã‰º•\‚©‚ç?Ì?W‚µ‚Ä‚¢‚é?B
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

									/**/      //  System.out.print(ueMenid[iuM]);System.out.print("<-?ã:‰º->");System.out.println(sitaMenid[isM]);


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

			//System.out.print("?„‘ª‚³‚ê‚½ŠÖŒW‚Ì?” ?? ");System.out.println(flg_b);
		}


		System.out.println("’Ç‰Á?„’è ?I—¹------------------------?–?–?–?–?–?–?–?–?–?–?–?–?–?–?–?–?–?–?–?–?–");

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

	//s0(Smen)‚Ì—D?æ“x‚ðŽ¦‚·’l‚ð‹?‚ß‚é?B‚±‚Ì’l‚ª?‚‚¢‚Ù‚¤‚ª—D?æ“x‚ª?ã?i”z—ñ‚Ì?æ“ª‚É‹ß‚¢?B?j
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
		int isusumu;//=0‚Ì?ê?‡Smen‚ª•Ï‚í‚é?iŒ…‚ª•Ï‚é‚æ‚¤‚ÈƒCƒ??[ƒW?j?B
		int Sid;//•Ï‰»‚ª‹y‚ñ‚¾Smen‚Ìid”Ô?†
		isusumu = 0;
		//ss+1”Ô–ÚˆÈ?ã‚ÌSmen‚Í‚Ý‚È?‰Šú’l‚É‚·‚é?BSmen‚ÉŠÜ‚Ü‚ê‚é–Ê?”‚ª0‚Ì‚Æ‚«‚ÍƒGƒ‰?[‚É‚È‚é?B
//System.out.println("    js.susumu 001      ss+1”Ô–ÚˆÈ?ã‚ÌSmen‚Í‚Ý‚È?‰Šú’l‚É‚·‚é?B");

		for (int i = ss + 1; i <= Smensuu; i++) {

//System.out.println("    js.susumu i= "+i+"        Smensuu= "+Smensuu);

			s[i].Jyunretu_1banme();
		}
//System.out.println("    js.susumu 002      ss+1”Ô–ÚˆÈ?ã‚ÌSmen‚Í‚Ý‚È?‰Šú’l‚É‚·‚é?B");
		//Smen‚Ìid”Ô?†‚Ì‘å‚«‚¢‚à‚Ì‚©‚ç?¬‚³‚¢‚à‚Ì‚Ì?‡‚É–Ê‚Ì?d‚È‚è?ó‘Ô‚ð•Ï‚¦‚Ä‚¢‚­?B
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
		int isusumu;//=0‚Ì?ê?‡Smen‚ª•Ï‚í‚é?iŒ…‚ª•Ï‚é‚æ‚¤‚ÈƒCƒ??[ƒW?j?B
		int Sid;//•Ï‰»‚ª‹y‚ñ‚¾Smen‚Ìid”Ô?†
		isusumu =0;
int ss; ss=getSmen_yuukou_suu();
	//ss+1”Ô–ÚˆÈ?ã‚ÌSmen‚Í‚Ý‚È?‰Šú’l‚É‚·‚é?B—LŒø?”ˆÈ?ã‚ÍŽg‚í‚È‚¢‚Ì‚Å?A‰½‚à‚µ‚È‚¢‚±‚Æ‚É‚·‚é?B
//System.out.println("    js.susumu 001      ss+1”Ô–ÚˆÈ?ã‚ÌSmen‚Í‚Ý‚È?‰Šú’l‚É‚·‚é?B");

		//for(int i=ss+1;i<=Smensuu;i++){

//System.out.println("    js.susumu i= "+i+"        Smensuu= "+Smensuu);

		 // s[i].Jyunretu_1banme();
		//}
//System.out.println("    js.susumu 002      ss+1”Ô–ÚˆÈ?ã‚ÌSmen‚Í‚Ý‚È?‰Šú’l‚É‚·‚é?B");
		  //Smen‚Ìid”Ô?†‚Ì‘å‚«‚¢‚à‚Ì‚©‚ç?¬‚³‚¢‚à‚Ì‚Ì?‡‚É–Ê‚Ì?d‚È‚è?ó‘Ô‚ð•Ï‚¦‚Ä‚¢‚­?B
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
	//Œ»?Ý‚Ì?‡—ñ?ó‘Ô‚©‚çŠJŽn‚µ‚Ä?A‰Â”\‚È?d‚È‚è‚©‚½‚Æ‚È‚é?ó‘Ô‚ð’T‚·?B‚È‚¨?A‚±‚±‚Í?‚‘¬‰»‚Ì—]’n‚ª‚ ‚é?B
	public int kanou_kasanari_sagasi() {      //‚±‚ê‚Íjg‚ð•Ï‚¦‚È‚¢‚Í‚¸?B
		int ms, Sid;
		ms = 0;

		//System.out.print("–Ê?”‚Í2?@");  System.out.println(s[1].getMenidsuu());

		Sid = 1;//Sid‚Ì?‰Šú’l‚Í0ˆÈŠO‚È‚ç‚È‚ñ‚Å‚à‚¢‚¢?B
		while (Sid != 0) { //Sid==0‚È‚ç?ASmen‚Ì?Å‚à”Ô?†‚Ì?¬‚³‚¢‚à‚Ì‚Ü‚Å’²‚×?s‚­‚µ‚½‚Æ‚¢‚¤ˆÓ–¡?B

			ms = mujyun_Smen_motome();
			if (ms == 1000) {
				return 1000;
			}//‘S‚Ä‚ÌSmen‚Å?A–µ?‚‚Í‚È‚¢?B
			Sid = susumu(ms - 1);

		}
		return 0;//‰Â”\‚È?d‚È‚è‚©‚½‚Æ‚È‚é?ó‘Ô‚Í‘¶?Ý‚µ‚È‚¢
	}

	//-----------------------------------------------------------------------------------------------------------------
	//?Ü‚è?d‚È‚è•û‚ª–µ?‚‚·‚éSmen‚ð”Ô?†‚Ì?¬‚³‚¢?‡‚©‚ç‚³‚ª‚·?B  ‚È‚¨?A‚±‚±‚à?‚‘¬‰»‚Ì—]’n‚ª‚ ‚é?B
	private int mujyun_Smen_motome() { //jg‚Í•Ï‰»‚·‚é?B
		int kks;
		jg.jg_fukugen();//<<<<<<<<<<<<<<<<<<<<<<<<<<<,,
		//for(int ss=1;ss<=Smensuu;ss++){
		for (int ss = 1; ss <= Smen_yuukou_suu; ss++) {      //<<<<<<<<<<<<<<?‚‘¬‰»‚Ì‚½‚ß•Ï?X?B070417
			kks = s[ss].kanou_kasanari_sagasi(jg);

			if (kks == 0) {
				return ss;
			}//kks==0‚Æ‚¢‚¤‚±‚Æ‚Í?A‰Â”\‚È?d‚È‚è‚©‚½
			//‚Æ‚È‚é?‡—ñ‚Í‘¶?Ý‚µ‚È‚¢
			s[ss].jg_ni_Smen_wo_nyuuryoku(jg);//ss”Ô–Ú‚ÌSmen‚Ì?ã‰º?î•ñ‚ðjg‚É“ü—Í‚·‚é?B
		}


		if (tuika_suitei() != 1000) {
			return Smen_yuukou_suu;
		} //ttttttttttt
	/*
		for(int ss=Smen_yuukou_suu+1;ss<=Smensuu;ss++){      //<<<<<<<<<<<<<<
			kks=s[ss].kanou_kasanari_sagasi(jg);

	                if(kks==0){return  Smen_yuukou_suu;}//kks==0‚Æ‚¢‚¤‚±‚Æ‚Í?A‰Â”\‚È?d‚È‚è‚©‚½
						//‚Æ‚È‚é?‡—ñ‚Í‘¶?Ý‚µ‚È‚¢
                        s[ss].jg_ni_Smen_wo_nyuuryoku(jg);//ss”Ô–Ú‚ÌSmen‚Ì?ã‰º?î•ñ‚ðjg‚É“ü—Í‚·‚é?B
	        }
	*/


		return 1000;
	}

	// ---------------------------------------------------------------
	private void kanou_kasanari_kensa() {//‚ÌSmen‚ª‰½’Ê‚è‚Ì‰Â”\‚È?d‚È‚è•û‚ðŽ?‚Â‚©‚ð’²‚×‚é?B
		for (int i = 1; i <= Smen_yuukou_suu; i++) {
			System.out.print("–Ê?”‚Í?@");
			System.out.print(s[i].getMenidsuu());
			int kanou_kasanari_suu = 0;
			kanou_kasanari_suu = kanou_kasanari_kensa(i);

			System.out.print("  ?A ‰Â”\?d‚È‚è?”‚Í?@");
			System.out.println(kanou_kasanari_suu);
		}
	}

	private int kanou_kasanari_kensa(int i) {//‚ÌSmen‚ª‰½’Ê‚è‚Ì‰Â”\‚È?d‚È‚è•û‚ðŽ?‚Â‚©‚ð’²‚×‚é?B
		jg.jg_fukugen();
		s[i].Jyunretu_1banme();
		System.out.print("—D?æ?‡ˆÊ");
		System.out.print(i);
		System.out.println("”Ô‚Ì‰Â”\‚È?d‚È‚è‚Ì—\”õŒŸ?¸");
		//kanou_kasanari_sagasi‚Ì’l‚Í1000‚È‚çSmen‚ª–µ?‚‚Í‚È‚¢?ó‘Ô‚É‚È‚Á‚½?B0‚È‚ç?ASmen‚ª–µ?‚‚Í‚È‚¢?ó‘Ô‚Å‚Í‘¶?Ý‚µ‚È‚¢?B

		int kanou_kasanari_suu = 0;
		int kks;
		int sus;
		kks = s[i].kanou_kasanari_sagasi(jg);

		if (kks == 0) {
			return kanou_kasanari_suu;
		}
		kanou_kasanari_suu = kanou_kasanari_suu + 1;
		//System.out.print("‰Â”\?d‚È‚è?”?@");System.out.println(kanou_kasanari_suu);
		sus = s[i].susumu(s[i].getMenidsuu());
		while (sus != 0) {
			kks = s[i].kanou_kasanari_sagasi(jg);


			if (kks == 0) {
				return kanou_kasanari_suu;
			}

			kanou_kasanari_suu = kanou_kasanari_suu + 1;
			//System.out.print("‰Â”\?d‚È‚è?”?@");System.out.println(kanou_kasanari_suu);

			sus = s[i].susumu(s[i].getMenidsuu());
		}
		return kanou_kasanari_suu;

	}

	//?@‚±‚±‚Í  class Jyougehyou_Syokunin  ‚Ì’†‚Å‚·?B
	//-----------------------------------------------------
	public void set_hyouji_yousiki(int i) {
		hyouji_yousiki = i;
	}


	//?}‚ð‚©‚­?Û‚Ì?”’l•ÏŠ·—pŠÖ?”-----------------------------------------------------------------

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

	public void oekaki(Graphics g, Tenkaizu_Syokunin orite, Tensyuugou otta_Men_zu, Tensyuugou Smen_zu, int omote_ura, int hyouji_flg) {


		//hyouji_flg‚Í?Ü‚è?ã‚ª‚è?}‚Ì•\Ž¦—lŽ®‚ÌŽw’è?B4‚È‚çŽÀ?Û‚É?Ü‚èŽ†‚ð?Ü‚Á‚½?ê?‡‚Æ“¯‚¶?B3‚È‚ç“§‰ß?}
		String text = "";//•¶Žš—ñ?ˆ—?—p‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»
		ip1 = omote_ura;
		//  System.out.println(Smensuu);
		for (int im = 1; im <= Smensuu; im++) { //Smen‚©‚ç?ã‚©‚ç‚ÌŽw’è‚µ‚½”Ô–Ú‚Ì–Ê‚Ìid‚ð‹?‚ß‚é?B
			s0[im].set_Menid2uekara_kazoeta_iti(jg);
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
				if (Mid_min == Mid_max) {//‚±‚Ì–_‚Í‹«ŠE?ü‚È‚Ì‚Å‚±‚Ì–_‚Í•`‚­?B
					g.drawLine(gx(Smen_zu.getmaex(ib)), gy(Smen_zu.getmaey(ib)), gx(Smen_zu.getatox(ib)), gy(Smen_zu.getatoy(ib))); //’¼?ü
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
					g.drawLine(gx(Smen_zu.getmaex(ib)), gy(Smen_zu.getmaey(ib)), gx(Smen_zu.getatox(ib)), gy(Smen_zu.getatoy(ib))); //’¼?ü
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
				g.drawLine(gx(Smen_zu.getmaex(ib)), gy(Smen_zu.getmaey(ib)), gx(Smen_zu.getatox(ib)), gy(Smen_zu.getatoy(ib))); //’¼?ü
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
                         	g.drawLine( gx(otta_Men_zu.getmaex(ib)),gy(otta_Men_zu.getmaey(ib)),gx(otta_Men_zu.getatox(ib)),gy(otta_Men_zu.getatoy(ib))); //’¼?ü
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
				im = yusenjyun_kara_s0id[iu]; //Smen‚Ì—D?æ?‡ˆÊ
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


		//hyouji_flg‚Í?Ü‚è?ã‚ª‚è?}‚Ì•\Ž¦—lŽ®‚ÌŽw’è?B4‚È‚çŽÀ?Û‚É?Ü‚èŽ†‚ð?Ü‚Á‚½?ê?‡‚Æ“¯‚¶?B3‚È‚ç“§‰ß?}
		OritaOekaki OO = new OritaOekaki();
		Ten t0 = new Ten();
		Ten t1 = new Ten();
		Senbun s_ob = new Senbun();
		Senbun s_tv = new Senbun();
		String text = "";//•¶Žš—ñ?ˆ—?—p‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»
		ip1 = omote_ura;
		//  System.out.println(Smensuu);

		//–Ê‚ð•`‚­
		int[] x = new int[100];
		int[] y = new int[100];


		if (hyouji_flg == 5) {//?ÜŽ†•\Ž¦---------------------------------------------------------------------------

			for (int im = 1; im <= Smensuu; im++) { //Smen‚©‚ç?ã‚©‚ç‚ÌŽw’è‚µ‚½”Ô–Ú‚Ì–Ê‚Ìid‚ð‹?‚ß‚é?B
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
				Mid_min = Smen_zu.Bou_moti_Menid_min_motome(ib);//–_ib‚ð‹«ŠE‚Æ‚µ‚ÄŠÜ‚Þ–Ê(?Å‘å‚Å2–Ê‚ ‚é)‚Ì‚¤‚¿‚ÅMenid‚Ì?¬‚³‚¢‚Ù‚¤‚ÌMenid‚ð•Ô‚·?B–_‚ð‹«ŠE‚Æ‚µ‚ÄŠÜ‚Þ–Ê‚ª–³‚¢?ê?‡‚Í0‚ð•Ô‚·
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
					g.drawLine(gx(s_tv.getax()), gy(s_tv.getay()), gx(s_tv.getbx()), gy(s_tv.getby())); //’¼?ü
					//g.drawLine( gx(Smen_zu.getmaex(ib)),gy(Smen_zu.getmaey(ib)),gx(Smen_zu.getatox(ib)),gy(Smen_zu.getatoy(ib))); //’¼?ü
				}


			}
			//System.out.println("?ã‰º•\?E?l?@oekaki_with_camera+++++++++++++++?ÜŽ†•\Ž¦?@?I—¹");
		}


//System.out.println("?ã‰º•\?E?l?@oekaki_with_camera+++++++++++++++hyouji_yousiki = "+hyouji_yousiki);

		//•\Ž¦—lŽ®‚PSmen‚ð•`‚­
		if (hyouji_yousiki == 1) {
			for (int iu = 1; iu <= Smen_yuukou_suu; iu++) {
				int im;
				im = yusenjyun_kara_s0id[iu]; //Smen‚Ì—D?æ?‡ˆÊ
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


	//---------------------------------------------------------
	public void oekaki_toukazu_with_camera(Graphics g, Tenkaizu_Syokunin orite, Tensyuugou otta_Men_zu, Tensyuugou Smen_zu, int omote_ura) {
		//System.out.println("Smen“§‰ß•\Ž¦003");
		//System.out.println("?ã‰º•\?E?l?@oekaki_with_camera+++++++++++++++“§‰ß•\Ž¦");
		OritaOekaki OO = new OritaOekaki();
		Ten t0 = new Ten();
		Ten t1 = new Ten();
		Senbun s_ob = new Senbun();
		Senbun s_tv = new Senbun();
		String text = "";//•¶Žš—ñ?ˆ—?—p‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»

		//–Ê‚ð•`‚­
		int[] x = new int[100];
		int[] y = new int[100];

		int col_hiku = 0;
		int colmax = 255;
		int colmin = 30;//colmax=255(?^‚Á”’)ˆÈ‰º?Acolmin=0(?^‚Á?•)ˆÈ?ã
		//Menidsuu_max‚Í1ˆÈ?ã‚Å‚ ‚é‚±‚Æ
		if (Menidsuu_max > 0) {
			col_hiku = (colmax - colmin) / Menidsuu_max;
		}
//if(Menidsuu_max<=0){System.out.println("?ã‰º•\?E?l?@oekaki_toukazu_with_camera!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!    Menidsuu_max<=0  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");}

		int col_kosa;

		//–Ê‚ð•`‚­
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

		//–_‚ð•`‚­
		int Mid_min, Mid_max;
		int Men_jyunban_min, Men_jyunban_max;
		for (int ib = 1; ib <= Smen_zu.getBousuu(); ib++) {
			s_ob.set(Smen_zu.getmaex(ib), Smen_zu.getmaey(ib), Smen_zu.getatox(ib), Smen_zu.getatoy(ib));
			s_tv.set(camera.object2TV(s_ob));
			g.drawLine(gx(s_tv.getax()), gy(s_tv.getay()), gx(s_tv.getbx()), gy(s_tv.getby())); //’¼?ü
		}

		//camera’†?S‚ð?\Žš‚Å•`‚­
		OO.jyuuji(g, camera.object2TV(camera.get_camera_ichi()), 5.0, 2.0, 4);
	}


	//---------------------------------------------------------

	Color F_color = new Color(255, 255, 50);//•\–Ê‚Ì?F
	Color B_color = new Color(233, 233, 233);//— –Ê‚Ì?F

	public void set_F_color(Color color0) {
		F_color = color0;
	}

	//---------------------------------------------------------

	public void oekaki_oriagarizu_with_camera(Graphics g, Tenkaizu_Syokunin orite, Tensyuugou otta_Men_zu, Tensyuugou Smen_zu, int omote_ura) {
		//System.out.println("?ã‰º•\?E?l?@oekaki_with_camera+++++++++++++++?ÜŽ†•\Ž¦?@–Ê‚ð•`‚­");
		OritaOekaki OO = new OritaOekaki();
		Ten t0 = new Ten();
		Ten t1 = new Ten();
		Senbun s_ob = new Senbun();
		Senbun s_tv = new Senbun();
		String text = "";//•¶Žš—ñ?ˆ—?—p‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»
		ip1 = omote_ura;
		//  System.out.println(Smensuu);

		//–Ê‚ð•`‚­
		int[] x = new int[100];
		int[] y = new int[100];


		//if(hyouji_flg==5){//?ÜŽ†•\Ž¦---------------------------------------------------------------------------

		for (int im = 1; im <= Smensuu; im++) { //Smen‚©‚ç?ã‚©‚ç‚ÌŽw’è‚µ‚½”Ô–Ú‚Ì–Ê‚Ìid‚ð‹?‚ß‚é?B
			s0[im].set_Menid2uekara_kazoeta_iti(jg);
		}


		//–Ê‚ð•`‚­

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
		//System.out.println("?ã‰º•\?E?l?@oekaki_with_camera+++++++++++++++?ÜŽ†•\Ž¦?@–_‚ð•`‚­");
		//–_‚ð•`‚­
		int Mid_min, Mid_max;
		int Men_jyunban_min, Men_jyunban_max;
		int oekaki_flg;
		for (int ib = 1; ib <= Smen_zu.getBousuu(); ib++) {
			oekaki_flg = 0;
			Mid_min = Smen_zu.Bou_moti_Menid_min_motome(ib);//–_ib‚ð‹«ŠE‚Æ‚µ‚ÄŠÜ‚Þ–Ê(?Å‘å‚Å2–Ê‚ ‚é)‚Ì‚¤‚¿‚ÅMenid‚Ì?¬‚³‚¢‚Ù‚¤‚ÌMenid‚ð•Ô‚·?B–_‚ð‹«ŠE‚Æ‚µ‚ÄŠÜ‚Þ–Ê‚ª–³‚¢?ê?‡‚Í0‚ð•Ô‚·
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
				g.drawLine(gx(s_tv.getax()), gy(s_tv.getay()), gx(s_tv.getbx()), gy(s_tv.getby())); //’¼?ü
				//g.drawLine( gx(Smen_zu.getmaex(ib)),gy(Smen_zu.getmaey(ib)),gx(Smen_zu.getatox(ib)),gy(Smen_zu.getatoy(ib))); //’¼?ü
			}


		}
		//System.out.println("?ã‰º•\?E?l?@oekaki_with_camera+++++++++++++++?ÜŽ†•\Ž¦?@?I—¹");
		//}


		//camera’†?S‚ð?\Žš‚Å•`‚­
		OO.jyuuji(g, camera.object2TV(camera.get_camera_ichi()), 5.0, 2.0, 4);
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


}     


