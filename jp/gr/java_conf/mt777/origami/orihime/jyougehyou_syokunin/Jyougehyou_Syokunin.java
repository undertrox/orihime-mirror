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


public class Jyougehyou_Syokunin {//?㉺�\?@?܂肽���ޑO�̓W�J?}�̖ʂ�?܂肽���񂾂��Ƃłǂ̂悤��?㉺�֌W�ɂȂ邩���L�^�����p����
	//String c=new String();
	//int Mensuu;             //?܂肽���ޑO�̓W�J?}�̖ʂ�?? 
	Jyougehyou jg = new Jyougehyou();
	Touka_jyouken errorPos = null;
	//Jyougehyou jg;// =new Jyougehyou();
	//Jyougehyou jg_syokiti =new Jyougehyou();//�W�J?}�݂̂��瓾����?㉺�֌W���L�^���Ă���?B
	int Smensuu;//Smen��??
	int Smen_yuukou_suu;//Smen�͑S�Ē��ׂȂ��Ă�?AMen��?㉺�֌W�͖ԗ��ł���?BMen��?㉺�֌W��ԗ�����̂ɕK�v��Smen��?����D???��ʂ̉��Ԗڂ܂ł���������?B
	int Menidsuu_max;//�eSmen��??��Menidsuu��?ő�l?B���Ȃ킿?A?ł�����?d�Ȃ肪�����Ƃ���̖�???B
	//paint �p��int�i�[�pVVVVVVVVVVVVVVVVVVVVVV
	int ip1 = 0; //0��?܂�?��?}�̕\����\�����郂?[�h?B1��?܂�?��?}�̗�����\�����郂?[�h?B
	// int ip1,ip2,ip3,ip4,ip5;
	int hyouji_yousiki = 0;//�\���l���̎w��
	//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
	//  jg[][]��?܂�O�̓W�J?}�̂��ׂĂ̖ʓ��m��?㉺�֌W��1�̕\�ɂ܂Ƃ߂����̂Ƃ��Ĉ���
	//?@jg[i][j]��1�Ȃ��i�͖�j��?㑤?B0�Ȃ牺��?B
	//  jg[i][j]��-50�Ȃ�?A��i��j��?d�Ȃ�?A?㉺�֌W�͌��߂��Ă��Ȃ�?B
	//jg[i][j]��-100�Ȃ�?A��i��j��?d�Ȃ�Ƃ��낪�Ȃ�?B

	Smen[] s0;//Smen_zu���瓾����Smen
	Smen[] s;//s�͗D?�x��?���?���s0����בւ�������?B
	int[] s0_no_yusenjyun;
	int[] yusenjyun_kara_s0id;

	int i_kage = 0; //�e��\�����邩�ǂ���?B0�͕\�����Ȃ�?A1�͕\������

	Camera camera = new Camera();

	ap orihime_ap;
	Moji_sousa ms = new Moji_sousa();


	public double[] men_rating;
	public int[] i_men_rating;

	public Narabebako_int_double nbox = new Narabebako_int_double();//20180227?@nbox�ɂ�men��id��men_rating�Ƒg�ɂȂ���?Amen_rating��?�����?��ɕ��בւ����ē����Ă���?B


	//-----------------------------------------------------------------
	public Jyougehyou_Syokunin() {
		reset();
	}    //�R���X�g���N�^

	//-----------------------------------------------------------------
	public Jyougehyou_Syokunin(ap ap0) {
		orihime_ap = ap0;
		reset();
	}    //�R���X�g���N�^

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

	//?@������  class Jyougehyou_Syokunin  �̒��ł�?B
	//?㉺�\��?��??ݒ�?B�W�J?}��1���_�����?���?�??���ł��肪����????0��Ԃ�?B���ꂪ�������1000��Ԃ�?B
	//�W�J?}�ɎR�J?�??�̊g���ɂ���肪����????2��Ԃ�?B

	//----------------------------------------------------------------------
/*
	public int Jyougehyou_settei  (Tenkaizu_Syokunin orite,Tensyuugou otta_Men_zu,Tensyuugou Smen_zu){//js.Jyougehyou_settei(ts1,ts2.get(),ts3.get()){
         	Smen_settei           (                  orite,           otta_Men_zu,           Smen_zu);
         return Jyougehyou_settei_2   (                  orite,           otta_Men_zu,           Smen_zu);
       }
*/
	public void Smen_settei(Tenkaizu_Syokunin orite, Tensyuugou otta_Men_zu, Tensyuugou Smen_zu) {//js.Jyougehyou_settei(ts1,ts2.get(),ts3.get());
		//��(?܂肽���ޑO�̓W�J?}�̖ʂ̂���)��?㉺�\��??��?B
		//����ɂ�ts2��??�_?W???i?܂肽���񂾂��Ƃ̖ʂ̈ʒu�֌W��?�����?��?j��  <-------------otta_Men_zu
		//ts3��??�_?W???i?j��?}�Ŗʂ�?ו�������Smen��?�����?��?j���g��?B <-------------Smen_zu
		//�܂�?Ats1��??��?A?܂����Ƃ��̖ʂ̈ʒu�֌W��?�����g��?B


		System.out.println("Smen��?��??ݒ�");
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

		//�eSmen�Ɋ܂܂��ʂ��L�^����?B
		System.out.println("�eSmen�Ɋ܂܂��ʂ��L�^���邽��?A�eSmen�̓����_��o�^");
		Ten[] Smen_naibuTen = new Ten[Smensuu + 1];  //<<<<<<<<<<<<<<<<<<<<<<<<<<<�I�u�W�F�N�g�̔z��𓮓I�Ɏw��
		for (int i = 1; i <= Smensuu; i++) {
			Smen_naibuTen[i] = Smen_zu.naibuTen_motome(i);
		}

		System.out.println("�eSmen�Ɋ܂܂��ʂ��L�^����");
		otta_Men_zu.BouMenMaxMinZahyou();//tttttttttt

		int[] s0addMenid = new int[otta_Men_zu.getMensuu() + 1];  //Smen�ɒǉ�����ʂ��ꎞ�L�^���Ă���

/*
		for(int i=1;i<=Smensuu;i++){
		       int s0addMenidsuu=0;

			for(int j=1;j<=jg.getMensuu();j++){
				//if(otta_Men_zu.naibu(Smen_zu.naibuTen_motome(i),j)==2){
				if(otta_Men_zu.kantan_naibu(Smen_naibuTen[i],j)==2){
					s0[i].addMenid(j)	;//�����Ŗʔ�??j��?���������?�ɒǉ������?B
				}
			}
                        s0[i].setKetasuu();
		}
*/

		for (int i = 1; i <= Smensuu; i++) {
			int s0addMenidsuu = 0;
			//System.out.println("��?�????����Smen��?A"+i+" / "+Smensuu );
			//for(int j=1;j<=jg.getMensuu();j++){

			for (int j = 1; j <= otta_Men_zu.getMensuu(); j++) {

				//System.out.print("��?�????����Smen��?A"+i+" / "+Smensuu +"     :::     "   +j+"/"+jg.getMensuu()+"-");
				if (otta_Men_zu.kantan_naibu(Smen_naibuTen[i], j) == 2) {
					//System.out.println(j);
					s0addMenidsuu = s0addMenidsuu + 1;
					s0addMenid[s0addMenidsuu] = j;
				}

			}
			//if (s0addMenidsuu==0){
			//System.out.println("**1** ��?�????����Smen��?A"+i+" / "+Smensuu+"  :::  s0addMenidsuu= "+s0addMenidsuu+" ::: ��?�= "+Smen_zu.menseki_motome(i));
			//}/////////20150308

			s0[i].setKetasuu(s0addMenidsuu);

			//System.out.println("**2**");
			for (int j = 1; j <= s0addMenidsuu; j++) {
				s0[i].setMenid(j, s0addMenid[j]);//�����Ŗʔ�??j��?���������?�ɒǉ������?B
			}
			//System.out.println("**3**");
		}

		//4956                     System.out.print("Smensuu = "); System.out.println(Smensuu);System.exit(0);
		//�����܂ł�?ASmensuu??	Smen_zu.getMensuu()�̂܂܂����Ȃ�?B
		System.out.println("�eSmen�Ɋ܂܂��ʂ�?��̓���?ő�̂��̂�??�߂�");
		//�eSmen�Ɋ܂܂��ʂ�?��̓���?ő�̂��̂�??�߂�?B
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

		//�R?܂�J?܂��?��񂩂猈�肳���?㉺�֌W��?㉺�\�ɓ����
		System.out.println("�R?܂�J?܂��?��񂩂猈�肳���?㉺�֌W��?㉺�\�ɓ����");
		int Mid_min, Mid_max;
		for (int ib = 1; ib <= orite.getBousuu(); ib++) {
			Mid_min = orite.Bou_moti_Menid_min_motome(ib);
			Mid_max = orite.Bou_moti_Menid_max_motome(ib);
			if (Mid_min != Mid_max) {//�W�J?}�ɂ�����?A�_ib�̗��e�ɖʂ�����
				//if(orite.getcolor(ib)==1){//?Ԃ�??�ŎR?܂���Ӗ�����
				if (otta_Men_zu.getcolor(ib) == 1) {//?Ԃ�??�ŎR?܂���Ӗ�����
					if (orite.getiMeniti(Mid_min) % 2 == 1) {//��Mid_min�͊�??�ʂƓ�������(�\�ʂ�?���?��)
						jg.set(Mid_min, Mid_max, 1);
						jg.set(Mid_max, Mid_min, 0);
					}
					if (orite.getiMeniti(Mid_max) % 2 == 1) {//��Mid_max�͊�??�ʂƓ�������(�\�ʂ�?���?��)
						jg.set(Mid_max, Mid_min, 1);
						jg.set(Mid_min, Mid_max, 0);
					}
				}
				//if(orite.getcolor(ib)==2){//?�??�ŒJ?܂���Ӗ�����
				if (otta_Men_zu.getcolor(ib) == 2) {//?�??�ŒJ?܂���Ӗ�����
					if (orite.getiMeniti(Mid_min) % 2 == 1) {//��Mid_min�͊�??�ʂƓ�������(�\�ʂ�?���?��)
						jg.set(Mid_min, Mid_max, 0);
						jg.set(Mid_max, Mid_min, 1);
					}
					if (orite.getiMeniti(Mid_max) % 2 == 1) {//��Mid_max�͊�??�ʂƓ�������(�\�ʂ�?���?��)
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
		System.out.println("����?��?��?ݒ肷��   ");
		//����?��?��?ݒ肷��?B�_ib�����E�Ƃ��ė�?ڂ���2�̖�im1,im2���L��?????A?܂�?��??�肵��???���
		//�_ib�̈ꕔ��?d�Ȃ�ʒu�ɗL���im�͖�im1�Ɩ�im2��?㉺�����ŋ��܂�邱�Ƃ͂Ȃ�?B���̂��Ƃ���
		//gj[im1][im]=gj[im2][im]�Ƃ�������?��?��?��藧��?B
		for (int ib = 1; ib <= orite.getBousuu(); ib++) {
			Mid_min = orite.Bou_moti_Menid_min_motome(ib);
			Mid_max = orite.Bou_moti_Menid_max_motome(ib);
			if (Mid_min != Mid_max) {//�W�J?}�ɂ�����?A�_ib�̗��e�ɖʂ�����
				for (int im = 1; im <= jg.getMensuu(); im++) {
					if ((im != Mid_min) && (im != Mid_max)) {
						if (otta_Men_zu.kantan_totu_naibu(ib, im) == 1) {
							//���̂Q��if�͎b��I��?????B���ƂŒu�������\��
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
		System.out.print("�R�ʂ��֗^����˂�����?��?��???@???@");
		System.out.println(jg.getTouka_jyoukensuu());
		orihime_ap.keijiban.tuiki("           Jyougehyou_settei   step3   start ");
		//����?��?�̒ǉ�?B�_ib�̋��E�Ƃ��ė�?ڂ���2�̖�im1,im2���L��?A
		//�܂��_jb�̋��E�Ƃ��ė�?ڂ���2�̖�im3,im4���L��?Aib��jb����?s��?A�ꕔ?d�Ȃ�?????A?܂�?��??�肵��???���
		//�_ib�̖ʂƖ�jb�̖ʂ�i,j,i,j?@�܂���?@j,i,j,i?@�ƕ��Ԃ��Ƃ͂Ȃ�?B�������ꂪ��������?A
		//?�?�����3�ԖڂŊԈႢ���N���Ă���̂�?A����3�Ԗڂ̂Ƃ��낪Smen�ŉ����ڂ���??�߂�?A���̌����P?i�߂�?B
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
		System.out.print("�S�ʂ��֗^����˂�����?��?��???@???@");
		System.out.println(jg.get_uTouka_jyoukensuu());
		//5154                      System.out.print("Smensuu = "); System.out.println(Smensuu);System.exit(0);

		orihime_ap.keijiban.tuiki("           Jyougehyou_settei   step4   start ");
		//�ǉ�??��
		int ituika;

		ituika = tuika_suitei();
		if (ituika != 1000) {
			return ituika;
		}

		System.out.println("�ǉ�??�� ?I����?A?㉺�\��ۑ�------------------------??????????????????????????????????????????");

		//*************?�?���?s����㈓I??�_�̌��ʂ̕ۑ�**************************
		jg.jg_hozon();//�R?܂�J?܂��?��񂩂猈�肳���?㉺�֌W��ۑ����Ă���?B
		//************************************************************************
		orihime_ap.keijiban.tuiki("           Jyougehyou_settei   step5   start ");
//orihime_ap.keijiban.tuiki("00000           ");
		//Smen���Ɉē�?��???��
		System.out.println("Smen���Ɉē�?��???��");
		for (int i = 1; i <= Smensuu; i++) {
			//System.out.print("Smen");System.out.print(i);System.out.println("�ɂ�?B");
			s0[i].setAnnaisyo(jg);
		}

		//s0�ɗD???��ʂ�����(���̂Ƃ�jg��-100�̂Ƃ��낪�ς�Ƃ��낪����)
		System.out.println("Smen(s0)�ɗD???��ʂ�����");
		//�܂�?A����Smen�Ɋۂ��Ɗ܂܂�Ă���Smen��?��O����

		int[] Smen_no_dokujisei = new int[Smensuu + 1];  //<<<<<<<<<<<<<<<Smen�̓Ǝ�?�
		for (int i = 1; i <= Smensuu; i++) {
			Smen_no_dokujisei[i] = 1;
		}
		for (int i = 1; i <= Smensuu; i++) {
			Smen_no_dokujisei[i] = 1;
			for (int j = 1; j <= Smensuu; j++) {
				if (Smen_no_dokujisei[j] == 1) {

					if (i != j) {//s0[j]��s0[i]���܂ނ����݂�?B
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
			System.out.print("Smen[s0]�̓Ɨ�?�?@" );
			System.out.print(Smen_no_dokujisei[i]);
			System.out.print("?@:?@");
            		for(int j=1;j<=s0[i].getMenidsuu();j++){
				System.out.print(s0[i].getMenid(j));System.out.print(",");
			}
			System.out.println("");
		}
*/
//
		int[] i_yusendo_max = new int[Smensuu + 1];     //<<<<<<<<<<<<<<<�Վ�
		//5115                     System.out.print("Smensuu = "); System.out.println(Smensuu);System.exit(0);

		for (int i = 1; i <= Smensuu; i++) {//�D?�xi�Ԗڂ�Smenid��������?B
			int yusendo_max = -10000;//�D?�xi�Ԗڂ̗D?�x�̒l?i�傫���ق����D?�x��?���?j?B
			int i_yusen = 0;

			for (int is0 = 1; is0 <= Smensuu; is0++) { //Smen���P����Smensuu�Ԗڂ܂ŃT?[�`
				int Sy;//Smenid_yusendo(is0)+Smen_no_dokujisei[is0] ���i�[
				if (s0_no_yusenjyun[is0] == 0) {//�܂��D???��ʂ����Ă��Ȃ�Smen����������
					Sy = Smenid_yusendo(is0)/*+Smen_no_dokujisei[is0]*/;//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
					if (yusendo_max < Sy) {
						yusendo_max = Sy;
						i_yusen = is0;// i_yusen��i�Ԗڂ̗D?�x��T���Ă���?ۂ�?ł��L�͂Ȍ��̔�??
					}
					if (yusendo_max == Sy) {
						if (s0[i_yusen].getMenidsuu() < s0[is0].getMenidsuu()) {
							yusendo_max = Sy;
							i_yusen = is0;
						}
					}
				}
			}

			s0_no_yusenjyun[i_yusen] = i; //�D?�xi�Ԗڂ�Smenid��i_yusen?B
			i_yusendo_max[i_yusen] = yusendo_max;//�D?�xi�Ԗڂ̗D?�x�̒l?i�傫���ق����D?�x��?���?j?B
/*
			if(yusendo_max>0){
				System.out.print("�D?�x����?@");System.out.print(i);System.out.print("�Ԗڂ̗D?�x ");
				System.out.println(yusendo_max);
			}
*/

			s0[i_yusen].jg_ni_Smen_no_tantoubasyo_wo_nyuuryoku(jg); //jg��-100�̂Ƃ����ς�?B<<<<<<<<<<<<<<<<<<<<<<
		}

		//�D?�x����s0��id���w��ł���悤�ɂ���

		for (int i = 1; i <= Smensuu; i++) {
			for (int is0 = 1; is0 <= Smensuu; is0++) {
				if (i == s0_no_yusenjyun[is0]) {
					yusenjyun_kara_s0id[i] = is0;
				}
			}
		}


		//System.out.println("------------" );
		System.out.println("?㉺�\?E?l��?@Smensuu = " + Smensuu);
		System.out.println("?㉺�\?E?l��?@s0�ɗD???��ʂ�����");
		for (int i = 1; i <= Smensuu; i++) {
			System.out.println(s0_no_yusenjyun[i]);
		}
		System.out.println("?㉺�\?E?l��?@�D?�x����s0��id");
		for (int i = 1; i <= Smensuu; i++) {
			System.out.println(yusenjyun_kara_s0id[i]);
		}


		for (int i = 1; i <= Smensuu; i++) {
			//System.out.println(yusenjyun_kara_s0id[i]);
			if (i_yusendo_max[yusenjyun_kara_s0id[i]] != 0) {
				Smen_yuukou_suu = i;       //??�����ςȌ��ʂɂȂ邱�Ƃ���?B
//20191012 wwwww				Smen_yuukou_suu=Smensuu;//�x�����m��

				//System.out.print("��");
				//System.out.print(i);
				//System.out.print("��(����y�A????");
				//System.out.print(i_yusendo_max[yusenjyun_kara_s0id[i]]);

				//System.out.print("?@||?@");
			}
		}


//20191012 				Smen_yuukou_suu=Smensuu;//�x�����m��//20191012


		//System.out.println();
		//

		for (int i = 1; i <= Smensuu; i++) {
			s[i] = s0[yusenjyun_kara_s0id[i]];
		}

		//�D???��ʂ��t�]������?B���ꂪ�L�����ǂ����͕s��wwwww
		//for(int i=1;i<=Smen_yuukou_suu;i++){s[Smen_yuukou_suu-i+1]=s0[yusenjyun_kara_s0id[i]];}

/*
		for(int i=1;i<=Smensuu;i++){
                       if(i_yusendo_max[yusenjyun_kara_s0id[i]]!=0){
				System.out.print("��");
				System.out.print(i);
				System.out.print("��(����y�A????");
				System.out.print(i_yusendo_max[yusenjyun_kara_s0id[i]]);
				System.out.print("?A��????");
				System.out.print(s[i].getMenidsuu());
				System.out.print("?@||?@");
			}
		}

		System.out.println();
*/

		//Smen�͗D???��̉��Ԗڂ܂ł�邩�����߂�
/*
		for(int i=1;i<=Smensuu;i++){
	  		if(s[i].getMenidsuu()>=1){
				Smen_yuukou_suu=i; ;
			}
		}
		Smen_yuukou_suu=Smensuu;   //<<<<<<<<<<<<<<<<<<<<<<<
*/
		System.out.print("Smen�L��?���?@");
		System.out.print(Smen_yuukou_suu);
		System.out.print("?^");
		System.out.println(Smensuu);


		//jg.jg_hozon();//�R?܂�J?܂��?��񂩂猈�肳���?㉺�֌W��ۑ����Ă���?B


		//jg[][]��?d�Ȃ�̂���ʂ̑g��?������̈ʒu�̒l��-100����-50�ɕς���?B
		for (int k = 1; k <= Smensuu; k++) {
			for (int i = 1; i <= s[k].getMenidsuu() - 1; i++) {
				for (int j = i + 1; j <= s[k].getMenidsuu(); j++) {
					jg.set(i, j, -50);
					jg.set(j, i, -50);
				}
			}
		}


		System.out.println("?㉺�\?��??ݒ�?I��");


//		jg.jg_hozon();//�R?܂�J?܂��?��񂩂猈�肳���?㉺�֌W��ۑ����Ă���?B

		//System.out.print("��?���1?@");  System.out.println(s[1].getMenidsuu());
		return ireturn;
	}

	//------------------------------------------------------------
	public int tuika_suitei() {
		//�R?܂�J?܂��?��񂩂�?X�Ɍ���ł���֌W��?������Ă���?B

		int Mid;//3�ʂ̔�r�Œ��Ԃɂ����
		int flg_c = 1;
		System.out.println("�ǉ�??��J�n---------------------????????????????????????????????????????????");

		while (flg_c >= 1) {
			flg_c = 0;
			System.out.println("�ǉ�??��------------------------");
			//System.out.println("�R?܂�J?܂��?��񂩂�ǉ�??��   " );

			int flg_b = 1;
			while (flg_b >= 1) {
				flg_b = 0;

				for (int iS = 1; iS <= Smensuu; iS++) {

					int flg_a = 1;
					while (flg_a >= 1) {
						flg_a = 0;
						for (int iM = 1; iM <= s0[iS].getMenidsuu(); iM++) {//3�ʂ̔�r�Œ��Ԃɂ����
							int[] ueMenid = new int[s0[iS].getMenidsuu() + 1];//S�ʂɊ܂܂�邠��Men��?オ��ɂ���id��??���L�^����?B���ꂪ20�Ƃ������Ƃ�?A
							int[] sitaMenid = new int[s0[iS].getMenidsuu() + 1];//S�ʂɊ܂܂�邠��Men�̉�����ɂ���id��??���L�^����?B���ꂪ20�Ƃ������Ƃ�?A
							int ueMenid_max = 0;
							int sitaMenid_max = 0;
							Mid = s0[iS].getMenid(iM);

							//?l����?F����Smen�̂����Mid�ɂ���?l����?B
							//����Smen�ȊO�Ŗ�A�͖�Mid��?㑤?A��B�͖�Mid�̉����ƌ��܂��Ă����Ƃ���?B
							//��ʂɕ�?X��Smen��?A��A�͖�Mid��?㑤��?A��B�͖�Mid�̉�������������ƌ�����?A��A�͖�B��?㑤�Ƃ͌���ł��Ȃ�?B
							//������?A�������|�C���g����?A��A?A��Mid?A��B����������Ɋ܂܂�Ă���Smen������Ȃ�?A����Smen��?㉺�֌W���킩���Ă��Ȃ��Ă�
							//��A�͖�B��?㑤�ƂȂ�?B������?A���̑�??�ł͂���Smen���瓾��?���͂R�̖ʂ���������ɂ��邩�Ƃ������Ƃł���?B
							//����Smen����?㉺�֌W�͕K�v�Ȃ�?B
							//
							//�����̑�??�͂���Smen��?㉺�֌W��?㉺�\����?�?W���Ă���?B
							for (int i = 1; i <= s0[iS].getMenidsuu(); i++) {//Menid[iM]���?�ɂ����?B
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
							for (int iuM = 1; iuM <= ueMenid_max; iuM++) {//Menid[iM]���?�ɂ����?B
								for (int isM = 1; isM <= sitaMenid_max; isM++) {//Menid[iM]��艺�ɂ����?B

									//  System.out.print(ueMenid[iuM]);System.out.print("<-??:��->");System.out.println(sitaMenid[isM]);


									if (jg.get(ueMenid[iuM], sitaMenid[isM]) == 0) {
										errorPos = new Touka_jyouken(sitaMenid[isM], ueMenid[iuM], sitaMenid[isM], ueMenid[iuM]);
										return 2;
									}//�ʂ�?㉺�֌W�̊g���Ŗ�?���?�?B
									if (jg.get(sitaMenid[isM], ueMenid[iuM]) == 1) {
										errorPos = new Touka_jyouken(sitaMenid[isM], ueMenid[iuM], sitaMenid[isM], ueMenid[iuM]);
										return 2;
									}//�ʂ�?㉺�֌W�̊g���Ŗ�?���?�?B

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

				//System.out.print("?������ꂽ�֌W��?? ?? ");System.out.println(flg_b);
			}

			//
			//jg.jg_hozon();//�R?܂�J?܂��?��񂩂猈�肳���?㉺�֌W��ۑ����Ă���?B


			//jg ��reset�K?؂�?s���Ă��邩�m�F�̂���

			//System.out.println ("�R�ʂ��֗^����˂�����?��?����ǉ�??��   " );
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
				//System.out.print("?������ꂽ�֌W��?��� ?? ");System.out.println(flg_a);
			}

			//----------------

//	System.out.println ("�S�ʂ��֗^����˂�����?��?����ǉ�??��   " );
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


					//?@a>b>c?@�����Ȃ�d�̈ʒu�͌��܂�Ȃ�


					//?@a>c && b>d �Ȃ� a>d && b>c
					//  a>d && b>c �Ȃ� a>c && b>d
					//?@a<c && b<d �Ȃ� a<d && b<c
					//  a<d && b<c �Ȃ� a<c && b<d


					//?@a>c>b?@�Ȃ�?@a>d>b

					//a>c && b>d �Ȃ� a>d && b>c
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
					//a>d && b>c �Ȃ� a>c && b>d
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

					//a<c && b<d �Ȃ� a<d && b<c
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
					//a<d && b<c �Ȃ� a<c && b<d
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


					//?@a>c>b?@�Ȃ�?@a>d>b
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
					//?@a>d>b?@�Ȃ�?@a>c>b
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
					//?@b>c>a?@�Ȃ�?@b>d>a
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
					//?@b>d>a?@�Ȃ�?@b>c>a
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


					//?@c>a>d?@�Ȃ�?@c>b>d
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
					//?@c>b>d?@�Ȃ�?@c>a>d
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
					//?@d>a>c?@�Ȃ�?@d>b>c
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
					//?@d>b>c?@�Ȃ�?@d>a>c
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
				//System.out.print("?������ꂽ�֌W��?��� ?? ");System.out.println(flg_a);
			}

			//----------------

			System.out.print("?������ꂽ�֌W��?���?��v ?? ");
			System.out.println(flg_c);

		}


		System.out.println("�ǉ�??�� ?I��------------------------???????������܂�20150310??????????????????????");

		return 1000;

	}

	//------------------------------------------

	private int tuika_suitei_2() {
		//�R?܂�J?܂��?��񂩂�?X�Ɍ���ł���֌W��?������Ă���?B

		int Mid;//3�ʂ̔�r�Œ��Ԃɂ����
		int flg_c = 1;
		System.out.println("�ǉ�??��J�n---------------------????????????????????????????????????????????");

		while (flg_c >= 1) {
			flg_c = 0;
			System.out.println("�ǉ�??��------------------------");
			//System.out.println("�R?܂�J?܂��?��񂩂�ǉ�??��   " );

			int flg_b = 1;
			while (flg_b >= 1) {
				flg_b = 0;

				for (int iS = 1; iS <= Smensuu; iS++) {

					int flg_a = 1;
					while (flg_a >= 1) {
						flg_a = 0;
						for (int iM = 1; iM <= s0[iS].getMenidsuu(); iM++) {//3�ʂ̔�r�Œ��Ԃɂ����
							int[] ueMenid = new int[s0[iS].getMenidsuu() + 1];//S�ʂɊ܂܂�邠��Men��?オ��ɂ���id��??���L�^����?B���ꂪ20�Ƃ������Ƃ�?A
							int[] sitaMenid = new int[s0[iS].getMenidsuu() + 1];//S�ʂɊ܂܂�邠��Men�̉�����ɂ���id��??���L�^����?B���ꂪ20�Ƃ������Ƃ�?A
							int ueMenid_max = 0;
							int sitaMenid_max = 0;
							Mid = s0[iS].getMenid(iM);

							//?l����?F����Smen�̂����Mid�ɂ���?l����?B
							//����Smen�ȊO�Ŗ�A�͖�Mid��?㑤?A��B�͖�Mid�̉����ƌ��܂��Ă����Ƃ���?B
							//��ʂɕ�?X��Smen��?A��A�͖�Mid��?㑤��?A��B�͖�Mid�̉�������������ƌ�����?A��A�͖�B��?㑤�Ƃ͌���ł��Ȃ�?B
							//������?A�������|�C���g����?A��A?A��Mid?A��B����������Ɋ܂܂�Ă���Smen������Ȃ�?A����Smen��?㉺�֌W���킩���Ă��Ȃ��Ă�
							//��A�͖�B��?㑤�ƂȂ�?B������?A���̑�??�ł͂���Smen���瓾��?���͂R�̖ʂ���������ɂ��邩�Ƃ������Ƃł���?B
							//����Smen����?㉺�֌W�͕K�v�Ȃ�?B
							//
							//�����̑�??�͂���Smen��?㉺�֌W��?㉺�\����?�?W���Ă���?B
							for (int i = 1; i <= s0[iS].getMenidsuu(); i++) {//Menid[iM]���?�ɂ����?B
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
							for (int iuM = 1; iuM <= ueMenid_max; iuM++) {//Menid[iM]���?�ɂ����?B
								for (int isM = 1; isM <= sitaMenid_max; isM++) {//Menid[iM]��艺�ɂ����?B

									/**/      //  System.out.print(ueMenid[iuM]);System.out.print("<-??:��->");System.out.println(sitaMenid[isM]);


									if (jg.get(ueMenid[iuM], sitaMenid[isM]) == 0) {
										return 2;
									}//�ʂ�?㉺�֌W�̊g���Ŗ�?���?�?B
									if (jg.get(sitaMenid[isM], ueMenid[iuM]) == 1) {
										return 2;
									}//�ʂ�?㉺�֌W�̊g���Ŗ�?���?�?B

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

			//System.out.print("?������ꂽ�֌W��?? ?? ");System.out.println(flg_b);
		}


		System.out.println("�ǉ�??�� ?I��------------------------??????????????????????????????????????????");

		return 1000;

	}


	//-----------------------------------------------------------------------------------------

	private int Smen_i_ga_j_ni_fukumareru(int s0i, int s0j) { //�܂܂��Ȃ�P?A�Ȃ��Ȃ�O
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

	//s0(Smen)�̗D?�x�������l��??�߂�?B���̒l��?����ق����D?�x��???i�z���?擪�ɋ߂�?B?j
	int Smenid_yusendo(int s0id) {
		//return s0[s0id].getMenidsuu();

		//��?݂�?㉺�\��Smen����ꂽ�牽��?㉺�֌W��?V���ɓo�^����邩�𒲂ׂ�?B
		return s0[s0id].sinki_jyouhou_suu(jg);


	}

	//-----------
	//------------------------
	//��?��̂R�̖ʂ𓯎��Ɋ܂�Smen��1��?㑶?݂���Ȃ�P?A���Ȃ��Ȃ�O��Ԃ�?B
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
	//��?��̂S�̖ʂ𓯎��Ɋ܂�Smen��1��?㑶?݂���Ȃ�P?A���Ȃ��Ȃ�O��Ԃ�?B
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


	//?@������  class Jyougehyou_Syokunin  �̒��ł�?B


	//Smen�̖ʂ�?d�Ȃ�?�Ԃ�����?�Ԃɂ���?B
	//������?݂̖ʂ�?d�Ȃ�?�Ԃ�?A?Ō�̂��̂�������0��return����?A�ʂ�?d�Ȃ�?�Ԃ�?�?��̂��̂ɖ߂�?B
	//zzzzzzzz

	public int susumu(int ss) {
		int isusumu;//=0��???�Smen���ς��?i�����ς�悤�ȃC???[�W?j?B
		int Sid;//�ω����y��Smen��id��??
		isusumu = 0;
		//ss+1�Ԗڈ�?��Smen�݂͂�?����l�ɂ���?BSmen�Ɋ܂܂���?���0�̂Ƃ��̓G��?[�ɂȂ�?B
//System.out.println("    js.susumu 001      ss+1�Ԗڈ�?��Smen�݂͂�?����l�ɂ���?B");

		for (int i = ss + 1; i <= Smensuu; i++) {

//System.out.println("    js.susumu i= "+i+"        Smensuu= "+Smensuu);

			s[i].Jyunretu_1banme();
		}
//System.out.println("    js.susumu 002      ss+1�Ԗڈ�?��Smen�݂͂�?����l�ɂ���?B");
		//Smen��id��??�̑傫�����̂���?��������̂�?��ɖʂ�?d�Ȃ�?�Ԃ�ς��Ă���?B
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
public int yuukouk_Smen_susumu(){//yuuko��Smen?����������ς��
		int isusumu;//=0��???�Smen���ς��?i�����ς�悤�ȃC???[�W?j?B
		int Sid;//�ω����y��Smen��id��??
		isusumu =0;
int ss; ss=getSmen_yuukou_suu();
	//ss+1�Ԗڈ�?��Smen�݂͂�?����l�ɂ���?B�L��?���?�͎g��Ȃ��̂�?A�������Ȃ����Ƃɂ���?B
//System.out.println("    js.susumu 001      ss+1�Ԗڈ�?��Smen�݂͂�?����l�ɂ���?B");

		//for(int i=ss+1;i<=Smensuu;i++){

//System.out.println("    js.susumu i= "+i+"        Smensuu= "+Smensuu);

		 // s[i].Jyunretu_1banme();
		//}
//System.out.println("    js.susumu 002      ss+1�Ԗڈ�?��Smen�݂͂�?����l�ɂ���?B");
		  //Smen��id��??�̑傫�����̂���?��������̂�?��ɖʂ�?d�Ȃ�?�Ԃ�ς��Ă���?B
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
//System.out.print("Smen�L��??/Smensuu?@" );System.out.print(Smen_yuukou_suu );System.out.print("?^");System.out.println(Smensuu );
		if (Smen_yuukou_suu == 0) {
			return 1000;
		}//Smen_yuukou_suu==0�Ƃ������Ƃ�?A?㉺�\��?V����?����������Smen���Ȃ��Ƃ�������?B���Ȃ킿?A?㉺�\�����ׂĖ��܂��Ă���Ƃ������Ƃ���������?A�����?��?d�Ȃ�??��͕s�v?B


		return kanou_kasanari_sagasi_self(1);
	}

	//---------------------------------------------------------------------------------------------------------------------------------------------
	public int kanou_kasanari_sagasi_self(int ss) {
		//orihime_ap.keijiban.tuiki("ss = "+ss  +"  :  Smen_yuukou_suu = "+Smen_yuukou_suu );
		//?�?I���ł�????
		if (ss == Smen_yuukou_suu) {

			if (s[ss].kanou_kasanari_sagasi(jg) == 1000) {//==0�Ƃ������Ƃ�?A�\��?d�Ȃ肩���ƂȂ�?���͑�?݂��Ȃ�?B?@==1000?@����Smen��?A��?��͂Ȃ�?�ԂɂȂ��Ă���?B
				return 100;//?܂�?�݉\��?���g��?���������������?B
			} else {
				return 0;
			}

		}


		//?�?I���ȊO�ł�????
		if (s[ss].kanou_kasanari_sagasi(jg) == 1000) {//==0�Ƃ������Ƃ�?A�\��?d�Ȃ肩���ƂȂ�?���͑�?݂��Ȃ�?B?@==1000?@����Smen��?A��?��͂Ȃ�?�ԂɂȂ��Ă���?B


			while (kanou_kasanari_sagasi_self(ss + 1) == 0) {//���̌��ŉ\��?d�Ȃ肩���ƂȂ�?���͑�?݂��Ȃ�
				if (s[ss].susumu() == 0) {
					return 0;
				}//���̌��ł�?i�߂Ȃ�?i?V����?���͖���?j

			}

			return 1000;//?܂�?�݉\��?���g��?���������������?B

		}

		return 0;


		//for(int ss=1;ss<=Smen_yuukou_suu;ss++){      //<<<<<<<<<<<<<<?������̂��ߕ�?X?B070417
		//        s[ss].jg_ni_Smen_wo_nyuuryoku(jg);//ss�Ԗڂ�Smen��?㉺?����jg�ɓ��͂���?B
		//  }
// return 100;

	}


	public int susumu_new() {
		return 0;
	}
//------------------------------------------------------------------------------------------------------

	//��?݂�?��??�Ԃ���J�n����?A�\��?d�Ȃ肩���ƂȂ�?�Ԃ�T��?B�Ȃ�?A������?������̗]�n������?B
	public int kanou_kasanari_sagasi() {      //�����jg��ς��Ȃ��͂�?B
		orihime_ap.keijiban.tuiki("_ _______");
		orihime_ap.keijiban.tuiki("__ ______");
		orihime_ap.keijiban.tuiki("___ _____");
		orihime_ap.keijiban.tuiki("____ ____");
		int ms, Sid;
		ms = 0;

		//System.out.print("��?���2?@");  System.out.println(s[1].getMenidsuu());

		Sid = 1;//Sid��?����l��0�ȊO�Ȃ�Ȃ�ł�����?B
		while (Sid != 0) { //Sid==0�Ȃ�?ASmen��?ł���??��?��������̂܂Œ���?s�������Ƃ����Ӗ�?B

			ms = mujyun_Smen_motome();
			if (ms == 1000) {
				return 1000;
			}//�S�Ă�Smen��?A��?��͂Ȃ�?B
			Sid = susumu(ms - 1);
			orihime_ap.keijiban.kakikae(9, "susumu(" + ms + "-1 = )" + Sid);
		}
		return 0;//�\��?d�Ȃ肩���ƂȂ�?�Ԃ͑�?݂��Ȃ�
	}

	//-----------------------------------------------------------------------------------------------------------------
	//?܂�?d�Ȃ������?�����Smen���??��?�����?����炳����?B  �Ȃ�?A������?������̗]�n������?B
	private int mujyun_Smen_motome() { //jg�͕ω�����?B

		//orihime_ap.keijiban.kakikae(9,"mujyun_Smen_motome()");
		int kks;
		jg.jg_fukugen();//<<<<<<<<<<<<<<<<<<<<<<<<<<<,,

		for (int ss = 1; ss <= Smen_yuukou_suu; ss++) {      //<<<<<<<<<<<<<<?������̂��ߕ�?X?B070417

			orihime_ap.keijiban.kakikae(7, "mujyun_Smen_motome( " + ss + ") , Menidsuu = " + s[ss].getMenidsuu() + " , Men_pair_suu = " + s[ss].getMenidsuu() * (s[ss].getMenidsuu() - 1) / 2);
			orihime_ap.keijiban.kakikae(8, " kasanari_bunryi_mitei = " + s[ss].kasanari_bunryi_mitei(jg));
			orihime_ap.keijiban.kakikae(9, " kasanari_bunryi_ketteizumi = " + s[ss].kasanari_bunryi_ketteizumi(jg));


			kks = s[ss].kanou_kasanari_sagasi(jg);
			orihime_ap.keijiban.kakikae(10, Jyunretu_count(ss));


			if (kks == 0) {//kks==0�Ƃ������Ƃ�?A�\��?d�Ȃ肩���ƂȂ�?���͑�?݂��Ȃ�

				return ss;
			}
			s[ss].jg_ni_Smen_wo_nyuuryoku(jg);//ss�Ԗڂ�Smen��?㉺?����jg�ɓ��͂���?B


		}

		if (tuika_suitei() != 1000) {
			return Smen_yuukou_suu;
		} //ttttttttttt

		return 1000;
	}

// ---------------------------------------------------------------

	//?@������  class Jyougehyou_Syokunin  �̒��ł�?B
	//-----------------------------------------------------
	public void set_hyouji_yousiki(int i) {
		hyouji_yousiki = i;
	}


	//?}������?ۂ�?��l�ϊ��p��??-----------------------------------------------------------------

	private int gx(double d) {
		//if(ip1==1){return (int)(-d+2.0*700.0);} //�����\��   <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		//if(ip1==1){return (int)(-d);} //�����\��   <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		// if(ip1==0){return (int)d;} //�\���\��
		return (int) d; //�\���\��
	}

	private int gy(double d) {
		return (int) d;
	}

	//---------------------------------------------------------
	//---------------------------------------------------------


	Color F_color = new Color(255, 255, 50);//�\�ʂ�?F
	Color B_color = new Color(233, 233, 233);//���ʂ�?F
	Color L_color = Color.black;//??��?F

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


		//hyouji_flg��?܂�?オ��?}�̕\���l���̎w��?B4�Ȃ��?ۂ�?܂莆��?܂���???��Ɠ���?B3�Ȃ瓧��?}
		String text = "";//������????�p�̃N���X�̃C���X�^���X��
		ip1 = omote_ura;
		//  System.out.println(Smensuu);
		for (int im = 1; im <= Smensuu; im++) { //Smen����?ォ��̎w�肵���Ԗڂ̖ʂ�id��??�߂�?B
			s0[im].set_Menid2uekara_kazoeta_iti(jg);//Smen��.set_Menid2uekara_kazoeta_iti�͌�?݂�?㉺�\�����Ƃ�?A?ォ��?�����i�Ԃ߂̖ʂ�id��??��S�Ă�?��Ԃɂ��i�[����?B
		}

		//�ʂ�`��
		int[] x = new int[100];
		int[] y = new int[100];

		if (hyouji_flg == 4) {//?܎��\��---------------------------------------------------------------------------
			//�ʂ�`��
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

			//�_��`��
			int Mid_min, Mid_max;
			int Men_jyunban_min, Men_jyunban_max;
			for (int ib = 1; ib <= Smen_zu.getBousuu(); ib++) {
				Mid_min = Smen_zu.Bou_moti_Menid_min_motome(ib);
				Mid_max = Smen_zu.Bou_moti_Menid_max_motome(ib);
				if (Mid_min == Mid_max) {//���̖_�͋��E??�Ȃ̂ł��̖_�͕`��?B
					g.drawLine(gx(Smen_zu.getmaex(ib)), gy(Smen_zu.getmaey(ib)), gx(Smen_zu.getatox(ib)), gy(Smen_zu.getatoy(ib))); //��??
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
				) {//���̖_�ŗ�?ڂ���Smen��1��?�̖ʂ͈قȂ�̂�?A���̖_�͕`��?B
					g.drawLine(gx(Smen_zu.getmaex(ib)), gy(Smen_zu.getmaey(ib)), gx(Smen_zu.getatox(ib)), gy(Smen_zu.getatoy(ib))); //��??
				}
			}
		}

		if (hyouji_flg == -3) {//���ߕ\��--------------------------------------------------------------------------------
			int col_hiku = 10;
			int colmax = 250;
			int col_kosa;
			System.out.println("Smen���ߕ\��");
			//�ʂ�`��
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

			//�_��`��
			int Mid_min, Mid_max;
			int Men_jyunban_min, Men_jyunban_max;
			for (int ib = 1; ib <= Smen_zu.getBousuu(); ib++) {
				g.drawLine(gx(Smen_zu.getmaex(ib)), gy(Smen_zu.getmaey(ib)), gx(Smen_zu.getatox(ib)), gy(Smen_zu.getatoy(ib))); //��??
			}
		}
/*
	        if(hyouji_flg==2){  //?j���\��--------------------------------------------------------------------------------------------------
			int  col_hiku=10;int colmax=250;
			int col_kosa;
			//�ʂ�`��
			g.setColor(Color.black);

			//�_��`��
			for(int ib=1;ib<=otta_Men_zu.getBousuu();ib++){
                         	g.drawLine( gx(otta_Men_zu.getmaex(ib)),gy(otta_Men_zu.getmaey(ib)),gx(otta_Men_zu.getatox(ib)),gy(otta_Men_zu.getatoy(ib))); //��??
			}
		}



	        if(hyouji_flg==4){  //Smen�\��--------------------------------------------------------------------------------------------------
			//�ʂ�`��
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
		//�\���l���PSmen��`��
		if (hyouji_yousiki == 1) {
			for (int iu = 1; iu <= Smen_yuukou_suu; iu++) {
				int im;
				im = yusenjyun_kara_s0id[iu]; //Smen�̗D???���
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

	public Memo getMemo_for_svg_with_camera(Tenkaizu_Syokunin orite, Tensyuugou otta_Men_zu, Tensyuugou Smen_zu) {//?܂�?オ��?}(hyouji_flg==5)
		int omote_ura = 0;
		if (camera.get_camera_kagami() == 1.0) {
			omote_ura = 0;
		}//�J??���̋�?ݒ肪1�Ȃ�?A?܂�?オ��?}�͕\�\��
		if (camera.get_camera_kagami() == -1.0) {
			omote_ura = 1;
		}//�J??���̋�?ݒ肪-1(x���̕�??�𔽓])�Ȃ�?A?܂�?オ��?}�͗��\��

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


		//�ʂ�`��-----------------------------------------------------------------------------------------------------
		int[] x = new int[100];
		int[] y = new int[100];
		double[] xd = new double[100];
		double[] yd = new double[100];

		//Smen��.set_Menid2uekara_kazoeta_iti�͌�?݂�?㉺�\�����Ƃ�?A?ォ��?�����i�Ԃ߂̖ʂ�id��??��S�Ă�?��Ԃɂ��i�[����?B
		for (int im = 1; im <= Smensuu; im++) { //Smen����?ォ��̎w�肵���Ԗڂ̖ʂ�id��??�߂�?B
			s0[im].set_Menid2uekara_kazoeta_iti(jg);//s0[]��Smen_zu���瓾����Smen���̂���?Ajg��?㉺�\Jyougehyou�̂���
		}
		//�����܂ł�?A?㉺�\��?���Smen�̊e�ʂɓ�����

		//�ʂ�`��
		//g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);//�A���`�F�C���A�X?@�I�t
		int Men_jyunban;
		for (int im = 1; im <= Smensuu; im++) {//im�͊eSmen�̔�??
			if (s0[im].getMenidsuu() > 0) {//Menidsuu��Smen(?܂�?��??�肵�Ă���ꂽ?j��?}��?ו���������)��?d�Ȃ��Ă���Men(?܂肽���ޑO�̓W�J?}�̖�)��???B���ꂪ0�Ȃ�?A�h?[�i�c?�̌��̖ʂȂ̂ŕ`���?ۊO

				//?܂�?オ��?}��`���Ƃ���im�Ԗڂ�Smen��?F�����߂�
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

				//?܂�?オ��?}��`���Ƃ���Smen��?F�����߂�̂͂����܂�

				//?܂�?オ��?}��`���Ƃ���im�Ԗڂ�Smen�̑��p�`�̒��_��?��W?iPC�\��???j��??�߂�
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
				//?܂�?オ��?}��`���Ƃ���im�Ԗڂ�Smen�̑��p�`�̒��_��?��W?iPC�\��???j��??�߂�̂͂����܂�

				//g2.fill(new Polygon(x,y,Smen_zu.getTenidsuu(im)));  //svg?o��

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
		//�ʂ�`��?@�����܂�-----------------------------------------------------------------------------------------


		//�_��`��-----------------------------------------------------------------------------------------
/*
		if(i_anti_alias==1){
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);//�A���`�F�C���A�X?@�I��
			BasicStroke BStroke = new BasicStroke(1.2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);g2.setStroke(BStroke);//??�̑�����??�̖��[�̌`??
		}
		if(i_anti_alias==0){
	  		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);//�A���`�F�C���A�X?@�I�t
			BasicStroke BStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);g2.setStroke(BStroke);//??�̑�����??�̖��[�̌`??
		}
*/
		//g.setColor(L_color);//?܂�?オ��?}��`���Ƃ��̖_��?F�����߂�

		//str_stroke = "black";
		str_stroke = ms.toHtmlColor(L_color);

		//System.out.println("?㉺�\?E?l?@oekaki_with_camera+++++++++++++++?܎��\��?@�_��`��");
		for (int ib = 1; ib <= Smen_zu.getBousuu(); ib++) {

			int Mid_min, Mid_max; //�_�̗�����Smen�̔�??��?������ق���Mid_min,?@�傫���ق���Mid_max
			int Men_jyunban_min, Men_jyunban_max;//PC��ʂɕ\�������Ƃ�Smen(Mid_min) �Ō�����ʂ̔�??��Men_jyunban_min?ASmen(Mid_max) �Ō�����ʂ̔�??��Men_jyunban_max
			int oekaki_flg;

			oekaki_flg = 0;
			Mid_min = Smen_zu.Bou_moti_Menid_min_motome(ib);//�_ib�����E�Ƃ��Ċ܂ޖ�(?ő��2�ʂ���)�̂�����Menid��?������ق���Menid��Ԃ�?B�_�����E�Ƃ��Ċ܂ޖʂ�����???���0��Ԃ�
			Mid_max = Smen_zu.Bou_moti_Menid_max_motome(ib);

			if (s0[Mid_min].getMenidsuu() == 0) {
				oekaki_flg = 1;
			}//men�������Ȃ�?A�h?[�i�c�̌�?��Smen�͋��E�̖_��`��
			else if (s0[Mid_max].getMenidsuu() == 0) {
				oekaki_flg = 1;
			} else if (Mid_min == Mid_max) {
				oekaki_flg = 1;
			}//��{�̖_�̕Жʂ�����Smen�L��
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
				}//���̖_�ŗ�?ڂ���Smen��1��?�̖ʂ͈قȂ�̂�?A���̖_�͕`��?B
			}

			if (oekaki_flg == 1) {//�_��`��?B
				s_ob.set(Smen_zu.getmaex(ib), Smen_zu.getmaey(ib), Smen_zu.getatox(ib), Smen_zu.getatoy(ib));
				s_tv.set(camera.object2TV(s_ob));
				//g.drawLine( gx(s_tv.getax()),gy(s_tv.getay()),gx(s_tv.getbx()),gy(s_tv.getby())); //svg �ɒ�??��?o��

				a.set(s_tv.geta());
				b.set(s_tv.getb());//a.set(s_tv.getax()+0.000001,s_tv.getay()+0.000001); b.set(s_tv.getbx()+0.000001,s_tv.getby()+0.000001);//�Ȃ�0.000001�𑫂����Ƃ�����,�f�B�X�v���C�ɕ`�悷��Ƃ�����?�??��?V����?�??�ɉe������ē����Ă��܂��̂�h������

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


		//hyouji_flg��?܂�?オ��?}�̕\���l���̎w��?B4�Ȃ��?ۂ�?܂莆��?܂���???��Ɠ���?B3�Ȃ瓧��?}
		OritaOekaki OO = new OritaOekaki();
		Ten t0 = new Ten();
		Ten t1 = new Ten();
		Senbun s_ob = new Senbun();
		Senbun s_tv = new Senbun();
		String text = "";//������????�p�̃N���X�̃C���X�^���X��
		ip1 = omote_ura;
		//  System.out.println(Smensuu);

		//�ʂ�`��
		int[] x = new int[100];
		int[] y = new int[100];


		if (hyouji_flg == 5) {//?܎��\��---------------------------------------------------------------------------

			for (int im = 1; im <= Smensuu; im++) { //Smen����?ォ��̎w�肵���Ԗڂ̖ʂ�id��??�߂�?B
				s0[im].set_Menid2uekara_kazoeta_iti(jg);
			}


			//�ʂ�`��
//System.out.println("?㉺�\?E?l?@oekaki_with_camera+++++++++++++++?܎��\��?@�ʂ�`��");
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
//System.out.println("?㉺�\?E?l?@oekaki_with_camera+++++++++++++++?܎��\��?@�_��`��");
			//�_��`��
			int Mid_min, Mid_max;
			int Men_jyunban_min, Men_jyunban_max;
			int oekaki_flg;
			for (int ib = 1; ib <= Smen_zu.getBousuu(); ib++) {
				oekaki_flg = 0;
				Mid_min = Smen_zu.Bou_moti_Menid_min_motome(ib);//�_ib�����E�Ƃ��Ċ܂ޖ�(?ő��2�ʂ���)�̂�����Menid��?������ق���Menid��Ԃ�?B�_�����E�Ƃ��Ċ܂ޖʂ�����???���0��Ԃ�
				Mid_max = Smen_zu.Bou_moti_Menid_max_motome(ib);

				if (s0[Mid_min].getMenidsuu() == 0) {
					oekaki_flg = 1;
				}//men�������Ȃ�?A�h?[�i�c�̌�?��Smen�͋��E�̖_��`��
				else if (s0[Mid_max].getMenidsuu() == 0) {
					oekaki_flg = 1;
				} else if (Mid_min == Mid_max) {
					oekaki_flg = 1;
				}//��{�̖_�̕Жʂ�����Smen�L��
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
					}//���̖_�ŗ�?ڂ���Smen��1��?�̖ʂ͈قȂ�̂�?A���̖_�͕`��?B
				}

				if (oekaki_flg == 1) {//�_��`��?B
					s_ob.set(Smen_zu.getmaex(ib), Smen_zu.getmaey(ib), Smen_zu.getatox(ib), Smen_zu.getatoy(ib));
					s_tv.set(camera.object2TV(s_ob));
					g.drawLine(gx(s_tv.getax()), gy(s_tv.getay()), gx(s_tv.getbx()), gy(s_tv.getby())); //��??
					//g.drawLine( gx(Smen_zu.getmaex(ib)),gy(Smen_zu.getmaey(ib)),gx(Smen_zu.getatox(ib)),gy(Smen_zu.getatoy(ib))); //��??
				}


			}
			//System.out.println("?㉺�\?E?l?@oekaki_with_camera+++++++++++++++?܎��\��?@?I��");
		}


//System.out.println("?㉺�\?E?l?@oekaki_with_camera+++++++++++++++hyouji_yousiki = "+hyouji_yousiki);

		//�\���l���PSmen��`��
		if (hyouji_yousiki == 1) {
			for (int iu = 1; iu <= Smen_yuukou_suu; iu++) {
				int im;
				im = yusenjyun_kara_s0id[iu]; //Smen�̗D???���
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


		//camera��?S��?\���ŕ`��
		OO.jyuuji(g, camera.object2TV(camera.get_camera_ichi()), 5.0, 2.0, 4);


	}


	//
	//---------------------------------------------------------
	public Memo getMemo_hariganezu_for_svg_kakidasi(Tenkaizu_Syokunin orite, Tensyuugou otta_Men_zu, Tensyuugou Smen_zu, int i_fill) {
		//System.out.println("getMemo_hariganezu_for_svg_kakidasi");
		int omote_ura = 0;
		if (camera.get_camera_kagami() == 1.0) {
			omote_ura = 0;
		}//�J??���̋�?ݒ肪1�Ȃ�?A?܂�?オ��?}�͕\�\��
		if (camera.get_camera_kagami() == -1.0) {
			omote_ura = 1;
		}//�J??���̋�?ݒ肪-1(x���̕�??�𔽓])�Ȃ�?A?܂�?オ��?}�͗��\��

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

		//System.out.println("?㉺�\?E?l?@oekaki_with_camera+++++++++++++++���ߕ\��");


		rating2();


		//�ʂ�`��??��
		int[] x = new int[100];
		int[] y = new int[100];

		//BigDecimal�̃R���X�g���N�^�̈�?��͕���?�?��_?��^�ƕ�����^�ǂ����ok?B��?�������?�?��_?��^�͌�?�����?�?B?��m�Ȓl���������߂ɂ�?A��?��͕�����^�Ŏw��?B

		for (int i_nbox = 1; i_nbox <= otta_Men_zu.getMensuu(); i_nbox++) {
			int im = 0;
			if (camera.get_camera_kagami() == -1.0) {//�J??���̋�?ݒ肪-1(x���̕�??�𔽓])�Ȃ�?A?܂�?オ��?}�͗��\��
				im = nbox.usirokara_get_int(i_nbox);
			} else {
				im = nbox.get_int(i_nbox);
			}

			String text = "";//������????�p�̃N���X�̃C���X�^���X��

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

//�J��?[�̓���?}
//toukazu_toukado=col_hiku;
		g.setColor(new Color(100,100, 100,50));

		//�ʂ�`��
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

		//System.out.println("?㉺�\?E?l?@oekaki_with_camera+++++++++++++++���ߕ\��");
		OritaOekaki OO = new OritaOekaki();
		Ten t0 = new Ten();
		Ten t1 = new Ten();
		Senbun s_ob = new Senbun();
		Senbun s_tv = new Senbun();
		String text = "";//������????�p�̃N���X�̃C���X�^���X��

		//�ʂ�`��??��
		int[] x = new int[100];
		int[] y = new int[100];

		//�ʂ̓K?؂ȔZ����??�߂�
		int col_hiku = 0;
		int colmax = 255;
		int colmin = 30;//colmax=255(?^����)�ȉ�?Acolmin=0(?^��??)��??
		//Menidsuu_max��1��?�ł��邱��
		if (Menidsuu_max > 0) {
			col_hiku = (colmax - colmin) / Menidsuu_max;
		}
		//if(Menidsuu_max<=0){System.out.println("?㉺�\?E?l?@oekaki_toukazu_with_camera!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!    Menidsuu_max<=0  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");}


//if(orihime_ap.ckbox_toukazu_color.isSelected()){//�J��?[�̓���?}
//if(orihime_ap.OZ.i_toukazu_color==1){//�J��?[�̓���?}
		if (i_toukazu_color == 1) {//�J��?[�̓���?}

//toukazu_toukado=col_hiku;
			g.setColor(new Color(F_color.getRed(), F_color.getGreen(), F_color.getBlue(), toukazu_toukado));

			//�ʂ�`��
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

			//�_��`��??��
			//g.setColor(Color.black);


			if (i_anti_alias == 1) {
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//�A���`�F�C���A�X?@�I��
				BasicStroke BStroke = new BasicStroke(1.2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
				g2.setStroke(BStroke);//??�̑�����??�̖��[�̌`??
			}
			if (i_anti_alias == 0) {
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);//�A���`�F�C���A�X?@�I�t
				BasicStroke BStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
				g2.setStroke(BStroke);//??�̑�����??�̖��[�̌`??
			}

			g.setColor(new Color(F_color.getRed(), F_color.getGreen(), F_color.getBlue(), 2 * toukazu_toukado));
			//�_��`��
			int Mid_min, Mid_max;
			int Men_jyunban_min, Men_jyunban_max;
			for (int ib = 1; ib <= Smen_zu.getBousuu(); ib++) {
				s_ob.set(Smen_zu.getmaex(ib), Smen_zu.getmaey(ib), Smen_zu.getatox(ib), Smen_zu.getatoy(ib));
				s_tv.set(camera.object2TV(s_ob));
				g.drawLine(gx(s_tv.getax()), gy(s_tv.getay()), gx(s_tv.getbx()), gy(s_tv.getby())); //��??
			}


		} else {//��?��̓���?}?i����?j



/*
		int col_hiku=0;int colmax=255;int colmin=30;//colmax=255(?^����)�ȉ�?Acolmin=0(?^��??)��??
		//Menidsuu_max��1��?�ł��邱��
		if(Menidsuu_max>0){col_hiku=(colmax-colmin)/Menidsuu_max;}
		//if(Menidsuu_max<=0){System.out.println("?㉺�\?E?l?@oekaki_toukazu_with_camera!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!    Menidsuu_max<=0  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");}
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

			//�_��`��??��
			g.setColor(Color.black);


			if (i_anti_alias == 1) {
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//�A���`�F�C���A�X?@�I��
				BasicStroke BStroke = new BasicStroke(1.2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
				g2.setStroke(BStroke);//??�̑�����??�̖��[�̌`??
			}
			if (i_anti_alias == 0) {
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);//�A���`�F�C���A�X?@�I�t
				BasicStroke BStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
				g2.setStroke(BStroke);//??�̑�����??�̖��[�̌`??
			}


			//�_��`��
			int Mid_min, Mid_max;
			int Men_jyunban_min, Men_jyunban_max;
			for (int ib = 1; ib <= Smen_zu.getBousuu(); ib++) {
				s_ob.set(Smen_zu.getmaex(ib), Smen_zu.getmaey(ib), Smen_zu.getatox(ib), Smen_zu.getatoy(ib));
				s_tv.set(camera.object2TV(s_ob));
				g.drawLine(gx(s_tv.getax()), gy(s_tv.getay()), gx(s_tv.getbx()), gy(s_tv.getby())); //��??
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
		}//�J??���̋�?ݒ肪1�Ȃ�?A?܂�?オ��?}�͕\�\��
		if (camera.get_camera_kagami() == -1.0) {
			omote_ura = 1;
		}//�J??���̋�?ݒ肪-1(x���̕�??�𔽓])�Ȃ�?A?܂�?オ��?}�͗��\��
		//System.out.println("?㉺�\?E?l?@oekaki_with_camera+++++++++++++++?܎��\��?@�ʂ�`��");
		OritaOekaki OO = new OritaOekaki();
		Ten t0 = new Ten();
		Ten t1 = new Ten();
		Senbun s_ob = new Senbun();
		Senbun s_tv = new Senbun();
		String text = "";//������????�p�̃N���X�̃C���X�^���X��
		ip1 = omote_ura;
		//  System.out.println(Smensuu);

		//�ʂ�`��
		int[] x = new int[100];
		int[] y = new int[100];

		double[] xd = new double[100];
		double[] yd = new double[100];


		//if(hyouji_flg==5){//?܎��\��---------------------------------------------------------------------------

		//Smen��.set_Menid2uekara_kazoeta_iti�͌�?݂�?㉺�\�����Ƃ�?A?ォ��?�����i�Ԃ߂̖ʂ�id��??��S�Ă�?��Ԃɂ��i�[����?B
		for (int im = 1; im <= Smensuu; im++) { //Smen����?ォ��̎w�肵���Ԗڂ̖ʂ�id��??�߂�?B
			s0[im].set_Menid2uekara_kazoeta_iti(jg);//s0[]��Smen_zu���瓾����Smen���̂���?Ajg��?㉺�\Jyougehyou�̂���
		}
		//�����܂ł�?A?㉺�\��?���Smen�̊e�ʂɓ�����


		//�ʂ�`��-----------------------------------------------------------------------------------------------------
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);//�A���`�F�C���A�X?@�I�t

		int Men_jyunban;
		for (int im = 1; im <= Smensuu; im++) {//im�͊eSmen�̔�??
			if (s0[im].getMenidsuu() > 0) {//Menidsuu��Smen(?܂�?��??�肵�Ă���ꂽ?j��?}��?ו���������)��?d�Ȃ��Ă���Men(?܂肽���ޑO�̓W�J?}�̖�)��???B���ꂪ0�Ȃ�?A�h?[�i�c?�̌��̖ʂȂ̂ŕ`���?ۊO

				//?܂�?オ��?}��`���Ƃ���im�Ԗڂ�Smen��?F�����߂�
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


				//?܂�?オ��?}��`���Ƃ���Smen��?F�����߂�̂͂����܂�

				//?܂�?オ��?}��`���Ƃ���im�Ԗڂ�Smen�̑��p�`�̒��_��?��W?iPC�\��???j��??�߂�

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

				//?܂�?オ��?}��`���Ƃ���im�Ԗڂ�Smen�̑��p�`�̒��_��?��W?iPC�\��???j��??�߂�̂͂����܂�

				g2.fill(new Polygon(x, y, Smen_zu.getTenidsuu(im)));
				//g.fillPolygon(x,y,Smen_zu.getTenidsuu(im));
			}
		}
		//�ʂ�`��?@�����܂�

		//g.setColor(new Color(0,0,0));		//??
		//g.setColor(new Color(255,255,255));	//��


		//�e������ ------------------------------------------------------------------------------------
		if (i_kage == 1) {

			for (int ib = 1; ib <= Smen_zu.getBousuu(); ib++) {
				int im = bou_no_bangou_kara_kagenoaru_Smen_no_bangou_wo_motomeru(ib, Smen_zu, omote_ura);//�e������Smen��id
				if (im != 0) {//�e��`��?B

					//?܂�?オ��?}��`���Ƃ���im�Ԗڂ�Smen�̑��p�`�̒��_��?��W?iPC�\��???j��??�߂�
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

				//?܂�?オ��?}��`���Ƃ���im�Ԗڂ�Smen�̑��p�`�̒��_��?��W?iPC�\��???j��??�߂�̂͂����܂�
*/


					//�_��?��W   Smen_zu.getmaex(ib),Smen_zu.getmaey(ib)   -    Smen_zu.getatox(ib) , Smen_zu.getatoy(ib)
					Ten b_mae = new Ten(Smen_zu.getmaex(ib), Smen_zu.getmaey(ib));
					Ten b_ato = new Ten(Smen_zu.getatox(ib), Smen_zu.getatoy(ib));
					double b_nagasa = b_mae.kyori(b_ato);

					//�_�ƒ�������x�N�g��
					double o_btx = -(Smen_zu.getmaey(ib) - Smen_zu.getatoy(ib)) * 10.0 / b_nagasa;//�_�ƒ�������x�x�N�g��
					double o_bty = (Smen_zu.getmaex(ib) - Smen_zu.getatox(ib)) * 10.0 / b_nagasa;//�_�ƒ�������y�x�N�g��

					//�_�̒��_
					double o_bmx, o_bmy;
					double t_bmx, t_bmy;

					o_bmx = (Smen_zu.getmaex(ib) + Smen_zu.getatox(ib)) / 2.0;
					o_bmy = (Smen_zu.getmaey(ib) + Smen_zu.getatoy(ib)) / 2.0;

					t0.setx(o_bmx);
					t0.sety(o_bmy);
					t1.set(camera.object2TV(t0));
					t_bmx = t1.getx();
					t_bmy = t1.gety();

					//�_�̒��_��ʂ钼��???�̓_
					double o_bmtx, o_bmty;
					double t_bmtx, t_bmty;


					//�_�̒��_��ʂ钼��???�̓_
					o_bmtx = o_bmx + o_btx;
					o_bmty = o_bmy + o_bty;

					if (Smen_zu.naibu(new Ten(o_bmx + 0.01 * o_btx, o_bmy + 0.01 * o_bty), im) != 0) {//0=�O��?A?@1=���E?A?@2=����


						t0.setx(o_bmtx);
						t0.sety(o_bmty);
						t1.set(camera.object2TV(t0));
						t_bmtx = t1.getx();
						t_bmty = t1.gety();


						//�e�̒����`

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


					//----------------------------------�_�ƒ�������x�x�N�g���̌�����ς��ĉe��`��
					o_btx = -o_btx;//�_�ƒ�������x�x�N�g��
					o_bty = -o_bty;//�_�ƒ�������y�x�N�g��


					//-----------------------------------------------
					//�_�̒��_��ʂ钼��???�̓_
					o_bmtx = o_bmx + o_btx;
					o_bmty = o_bmy + o_bty;


					if (Smen_zu.naibu(new Ten(o_bmx + 0.01 * o_btx, o_bmy + 0.01 * o_bty), im) != 0) {//0=�O��?A?@1=���E?A?@2=����

						t0.setx(o_bmtx);
						t0.sety(o_bmty);
						t1.set(camera.object2TV(t0));
						t_bmtx = t1.getx();
						t_bmty = t1.gety();


						//�e�̒����`

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
		}//�e�������?A������?I���

		//�_��`��-----------------------------------------------------------------------------------------


		if (i_anti_alias == 1) {
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//�A���`�F�C���A�X?@�I��
			BasicStroke BStroke = new BasicStroke(1.2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
			g2.setStroke(BStroke);//??�̑�����??�̖��[�̌`??
		}
		if (i_anti_alias == 0) {
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);//�A���`�F�C���A�X?@�I�t
			BasicStroke BStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
			g2.setStroke(BStroke);//??�̑�����??�̖��[�̌`??
		}

		g.setColor(L_color);//g.setColor(Color.black);


		//System.out.println("?㉺�\?E?l?@oekaki_with_camera+++++++++++++++?܎��\��?@�_��`��");


		for (int ib = 1; ib <= Smen_zu.getBousuu(); ib++) {

			int Mid_min, Mid_max; //�_�̗�����Smen�̔�??��?������ق���Mid_min,?@�傫���ق���Mid_max
			int Men_jyunban_min, Men_jyunban_max;//PC��ʂɕ\�������Ƃ�Smen(Mid_min) �Ō�����ʂ̔�??��Men_jyunban_min?ASmen(Mid_max) �Ō�����ʂ̔�??��Men_jyunban_max
			int oekaki_flg;

			oekaki_flg = 0;
			Mid_min = Smen_zu.Bou_moti_Menid_min_motome(ib);//�_ib�����E�Ƃ��Ċ܂ޖ�(?ő��2�ʂ���)�̂�����Menid��?������ق���Menid��Ԃ�?B�_�����E�Ƃ��Ċ܂ޖʂ�����???���0��Ԃ�
			Mid_max = Smen_zu.Bou_moti_Menid_max_motome(ib);

			if (s0[Mid_min].getMenidsuu() == 0) {
				oekaki_flg = 1;
			}//men�������Ȃ�?A�h?[�i�c�̌�?��Smen�͋��E�̖_��`��
			else if (s0[Mid_max].getMenidsuu() == 0) {
				oekaki_flg = 1;
			} else if (Mid_min == Mid_max) {
				oekaki_flg = 1;
			}//��{�̖_�̕Жʂ�����Smen�L��
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
				}//���̖_�ŗ�?ڂ���Smen��1��?�̖ʂ͈قȂ�̂�?A���̖_�͕`��?B
			}

			if (oekaki_flg == 1) {//�_��`��?B
				s_ob.set(Smen_zu.getmaex(ib), Smen_zu.getmaey(ib), Smen_zu.getatox(ib), Smen_zu.getatoy(ib));
				s_tv.set(camera.object2TV(s_ob));
				//g2.draw(new Line2D.Double( gx(s_tv.getax()),gy(s_tv.getay()),gx(s_tv.getbx()),gy(s_tv.getby())));
				g.drawLine(gx(s_tv.getax()), gy(s_tv.getay()), gx(s_tv.getbx()), gy(s_tv.getby())); //��??
				//g.drawLine( gx(Smen_zu.getmaex(ib)),gy(Smen_zu.getmaey(ib)),gx(Smen_zu.getatox(ib)),gy(Smen_zu.getatoy(ib))); //��??
			}


		}


		//g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);//�A���`�F�C���A�X?@�I�t


		//System.out.println("?㉺�\?E?l?@oekaki_with_camera+++++++++++++++?܎��\��?@?I��");
		//}


		//camera��?S��?\���ŕ`��
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

		//?܂�?オ��?}��`���Ƃ���im�Ԗڂ�Smen�̑��p�`�̒��_��?��W?iPC�\��???j��??�߂�̂͂����܂�

		g.fill(new Polygon(x, y, faces.getTenidsuu(id)));
	}


	//---------------------------------------------------------
	public void oekaki_jyuuji_with_camera(Graphics g) {
		//System.out.println("?܂�?オ��?}�̓�������?S��?\���\��");
		//System.out.println("?㉺�\?E?l?@oekaki_jyuuji_with_camera+++++++++++++++?܂�?オ��?}�̓�������?S��?\���\��");
		OritaOekaki OO = new OritaOekaki();

		//camera��?S��?\���ŕ`��
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

	public int bou_no_bangou_kara_kagenoaru_Smen_no_bangou_wo_motomeru(int ib, Tensyuugou Smen_zu, int omote_ura) {//�_�̔�??����?A���̖_�̉e����?�����Smen �̔�??��??�߂�?B�e����?����Ȃ�???���0��Ԃ�?B

		int i_return = 0;

		int Mid_min, Mid_max; //�_�̗�����Smen�̔�??��?������ق���Mid_min,?@�傫���ق���Mid_max
		int Men_jyunban_min, Men_jyunban_max;//PC��ʂɕ\�������Ƃ�Smen(Mid_min) �Ō�����ʂ�?A����Smen�ł�?d�Ȃ�?���Men_jyunban_min?ASmen(Mid_max) �Ō�����ʂ̂���Smen�ł�?d�Ȃ�?���Men_jyunban_max

		Mid_min = Smen_zu.Bou_moti_Menid_min_motome(ib);//�_ib�����E�Ƃ��Ċ܂ޖ�(?ő��2�ʂ���)�̂�����Menid��?������ق���Menid��Ԃ�?B�_�����E�Ƃ��Ċ܂ޖʂ�����???���0��Ԃ�
		Mid_max = Smen_zu.Bou_moti_Menid_max_motome(ib);

		if (s0[Mid_min].getMenidsuu() == 0) {
			return 0;
		}//men�������Ȃ�?A�h?[�i�c�̌�?��Smen�Ƃ̋��E�̖_�ɂ͉e�Ȃ�
		if (s0[Mid_max].getMenidsuu() == 0) {
			return 0;
		}//men�������Ȃ�?A�h?[�i�c�̌�?��Smen�Ƃ̋��E�̖_�ɂ͉e�Ȃ�
		if (Mid_min == Mid_max) {
			return 0;
		}//��{�̖_�̕Жʂ�����Smen�L��

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
		}//���̖_�ŗ�?ڂ���Smen�Ō����Ă�ʂ������Ȃ̂�?A�_���̂��`���ꂸ�e���Ȃ�?B


		//Jyougehyou
		//public int get(int i,int j){return jg[i][j];}
		//?@jg[i][j]��1�Ȃ��i�͖�j��?㑤?B0�Ȃ牺��?B
		//  jg[i][j]��-50�Ȃ�?A��i��j��?d�Ȃ�?A?㉺�֌W�͌��߂��Ă��Ȃ�?B
		//jg[i][j]��-100�Ȃ�?A��i��j��?d�Ȃ�Ƃ��낪�Ȃ�?B
		if (jg.get(Mid_min_mieteru_men_id, Mid_max_mieteru_men_id) == -50) {
			return 0;
		}//���̖_�ŗ�?ڂ���Smen�Ō����Ă�ʂ�?㉺�֌W�s���Ȃ̂�?A�e�͂Ȃ�
		if (jg.get(Mid_min_mieteru_men_id, Mid_max_mieteru_men_id) == -100) {
			return 0;
		}//���̖_�ŗ�?ڂ���Smen�Ō����Ă�ʂ�?㉺�֌W�Ȃ�?i?d�Ȃ�Ȃ�?j�̂�?A�e�͂Ȃ�

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
		double katen=100.0;//���_
		for (int ism=1; ism<=Smensuu; ism++ ){
			int Mensuu=	s0[ism].getMenidsuu();//Smen�ł̖�??
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
							if (jg.get(ia, ib) == 1) {//wiki�̃C??��?[�e�B���O��?����N���u24�Q?�
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
						if(jg.get(ia,ib)==1){//wiki�̃C??��?[�e�B���O��?����N���u24�Q?�
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

	int makesuu0no_menno_kazu = 0;//?�ɑ��̖ʂ��Ȃ�?�Ԃ�?��ʕt���ł���ʂ�??
	int makesuu1ijyouno_menno_kazu = 0;//?�ɑ��̖ʂ�1��?�?��?�ԂłȂ���?��ʕt���ł��Ȃ��ʂ�??

	private void rating2() {
		int jgms = jg.getMensuu();//�ʂ�???����?�߂�?B
//System.out.println("*********  rating2()   *************");
		double[] men_r = new double[jgms + 1];
		men_rating = men_r;

		int[] i_m_r = new int[jgms + 1];//�e�ʂ�?�?��??[�e�B���O?irating2()�Ŏg��?j?j
		i_men_rating = i_m_r;


		makesuu0no_menno_kazu = 0;//?�ɑ��̖ʂ��Ȃ�?�Ԃ�?��ʕt���ł���ʂ�??
		makesuu1ijyouno_menno_kazu = 0;//?�ɑ��̖ʂ�1��?�?��?�ԂłȂ���?��ʕt���ł��Ȃ��ʂ�??


		for (int i = 0; i <= jgms; i++) {
			i_men_rating[i] = 0;
		}


//s�ʂ̂P����?��Ɉ��?�ɂ���ʂ�??�߂�?i��?[�g�������ʂ�?���?j?B
//s�ʂ̂P����?��ɂ��̖ʂ�?�ɂ����???i��?[�g�������ʂ�?���?j��??��?A??�v��??�߂�
//���̖ʂ�?�̂����???i��?[�g�������ʂ�?���?j��?�?��̖ʂ�??�߃�?[�g������


		for (int i = 1; i <= jgms; i++) {
			int i_rate = 1 + jgms - i;


			int top_men_id = get_top_men_id_without_rated_men();

//System.out.println("*********  rating2()   rating = "+i_rate+"   top_men_id = "+top_men_id);

			i_men_rating[top_men_id] = i_rate;
			men_rating[top_men_id] = i_rate;
		}

//System.out.println("*********  rating2()   end *************");


		System.out.println("?�ɑ��̖ʂ��Ȃ�?�Ԃ�?��ʕt���ł����ʂ�?? = " + makesuu0no_menno_kazu);
		System.out.println("?�ɑ��̖ʂ�1��?�?��?�Ԃ�?��ʕt�������ʂ�?? = " + makesuu1ijyouno_menno_kazu);











/*

		Random rand = new Random();
		double dr=0.0;
		double men_r[]= new double[jgms+1]; ;
		men_rating=men_r;

		for (int im=1; im<=jgms; im++ ){ men_rating[im]=10000.0;}
*/
/*
		//------------------------------------------------------------------------------
		double katen=100.0;//���_
		for (int ism=1; ism<=Smensuu; ism++ ){
			int Mensuu=	s0[ism].getMenidsuu();//Smen�ł̖�??
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
							if(jg.get(ia,ib)==1){//wiki�̃C??��?[�e�B���O��?����N���u24�Q?�
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
						if(jg.get(ia,ib)==1){//wiki�̃C??��?[�e�B���O��?����N���u24�Q?�
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
//�ȉ��̊e��?��ł�Smen�Ƃ���s0[]���g��20180305


	private int top_men_id_ga_maketa_kazu_goukei_without_rated_men = 0;

	//------------------------------------------------------------
	private int get_top_men_id_without_rated_men() {
//System.out.println("20180307*********   get_top_men_id_without_rated_men()   *************");
		int top_men_id = 0;
		top_men_id_ga_maketa_kazu_goukei_without_rated_men = jg.getMensuu() + 100;


		int jgms = jg.getMensuu();//�ʂ�???����?�߂�?B

		int[] i_kentouzumi = new int[jgms + 1];//����?ς݂̖�ID�͂P�ɂ���
		for (int i = 0; i <= jgms; i++) {
			i_kentouzumi[i] = 0;
		}

		for (int i = 1; i <= Smensuu; i++) {
			int s_top_id = get_s_top_id_without_rated_men(i);//�es�ʂ�?i��?[�g�������ʂ�?���?j���?�̖�?Bs_top_id=0�Ȃ炻��s�ʂɂ̓�?[�g������̖ʂ͂Ȃ�
			//System.out.println("*********   get_top_men_id_without_rated_men()   Smen ID = "+I+"  s_top_id = "+s_top_id+  "   ����?? = "+get_maketa_kazu_goukei_without_rated_men(s_top_id));


			if (s_top_id != 0) {
				if (i_kentouzumi[s_top_id] == 0) {
					//int makesuu=get_maketa_kazu_goukei_without_rated_men(s_top_id);
					//System.out.println("*********     Smen ID = "+i+"  s_top_id = "+s_top_id+  "   ����?? = "+get_maketa_kazu_goukei_without_rated_men(s_top_id));


					int mkg = get_maketa_kazu_goukei_without_rated_men(s_top_id);
					if (mkg == 0) {
						makesuu0no_menno_kazu = makesuu0no_menno_kazu + 1;
						return s_top_id;
					}//������?A����ł悢���v����20180306
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
		//makesuu0no_menno_kazu=0;//?�ɑ��̖ʂ��Ȃ�?�Ԃ�?��ʕt���ł���ʂ�??
		//makesuu1ijyouno_menno_kazu=0;//?�ɑ��̖ʂ�1��?�?��?�ԂłȂ���?��ʕt���ł��Ȃ��ʂ�??
		if (top_men_id_ga_maketa_kazu_goukei_without_rated_men == 0) {
			makesuu0no_menno_kazu = makesuu0no_menno_kazu + 1;
		} else if (top_men_id_ga_maketa_kazu_goukei_without_rated_men > 0) {
			makesuu1ijyouno_menno_kazu = makesuu1ijyouno_menno_kazu + 1;
		}


//System.out.println("*?�ɑ��̖ʂ��Ȃ�?�Ԃ�?��ʕt���ł����ʂ�?? = "+makesuu0no_menno_kazu);
//System.out.println("*?�ɑ��̖ʂ�1��?�?��?�Ԃ�?��ʕt�������ʂ�?? = "+makesuu1ijyouno_menno_kazu);


		return top_men_id;
	}

//-----------------------------------

	private int get_s_top_id_without_rated_men(int ism) {//ism��s�ʂ�id
//System.out.println("*********   get_s_top_id_without_rated_men   *************");
		int Mensuu = s0[ism].getMenidsuu();//Smen�ł̖�??//Smen s0[];//Smen_zu���瓾����Smen
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
			}//20180306?������̂��߂��̂P?s�����Ă��邪?A�{���Ɍ��ʂ����邩�͕s��?B����?s�����R??���g�A�E�g���Ă�?�?��ɂ͓����͂�?B

		}
//System.out.println("*********   get_maketa_kazu_goukei_without_rated_men   end *************");
		return i_make;
	}


	//-----------------------------------
	private int get_smen_de_maketa_kazu_without_rated_men(int ism, int men_id) {//ism��smen��id
//System.out.println("*********   get_smen_de_maketa_kazu_without_rated_men   *************");
		int Mensuu = s0[ism].getMenidsuu();//Smen�ł̖�??//Smen s0[];//Smen_zu���瓾����Smen
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


