package jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin;

import jp.gr.java_conf.mt777.origami.dougu.camera.Camera;
import jp.gr.java_conf.mt777.origami.dougu.tensyuugou.Tensyuugou;
import jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin.jyougehyou.Jyougehyou;
import jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin.smen.Smen;
import jp.gr.java_conf.mt777.origami.orihime.tenkaizu_syokunin.Tenkaizu_Syokunin;
import jp.gr.java_conf.mt777.zukei2d.oritaoekaki.OritaOekaki;
import jp.gr.java_conf.mt777.zukei2d.senbun.Senbun;

import java.awt.*;


public class Jyougehyou_Syokunin {//?㉺�\?@?܂肽���ޑO�̓W�J?}�̖ʂ�?܂肽���񂾂��Ƃłǂ̂悤��?㉺�֌W�ɂȂ邩���L�^�����p����
	//String c=new String();
	//int Mensuu;             //?܂肽���ޑO�̓W�J?}�̖ʂ�?�
	Jyougehyou jg = new Jyougehyou();
	//Jyougehyou jg;// =new Jyougehyou();
	//Jyougehyou jg_syokiti =new Jyougehyou();//�W�J?}�݂̂��瓾����?㉺�֌W���L�^���Ă���?B
	int Smensuu;//Smen��?�
	int Smen_yuukou_suu;//Smen�͑S�Ē��ׂȂ��Ă�?AMen��?㉺�֌W�͖ԗ��ł���?BMen��?㉺�֌W��ԗ�����̂ɕK�v��Smen��?����D?�?��ʂ̉��Ԗڂ܂ł���������?B
	int Menidsuu_max;//�eSmen�̎?��Menidsuu��?ő�l?B���Ȃ킿?A?ł�����?d�Ȃ肪�����Ƃ���̖�?�?B
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

	Camera camera = new Camera();

	public Jyougehyou_Syokunin() {
		reset();
	}    //�R���X�g���N�^

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
	//?㉺�\��?���?ݒ�?B�W�J?}��1���_�����?���?�?����ł��肪����?�?�0��Ԃ�?B���ꂪ�������1000��Ԃ�?B
	//�W�J?}�ɎR�J?�?��̊g���ɂ���肪����?�?�2��Ԃ�?B

	//----------------------------------------------------------------------
/*
	public int Jyougehyou_settei  (Tenkaizu_Syokunin orite,Tensyuugou otta_Men_zu,Tensyuugou Smen_zu){//js.Jyougehyou_settei(ts1,ts2.get(),ts3.get()){
         	Smen_settei           (                  orite,           otta_Men_zu,           Smen_zu);
         return Jyougehyou_settei_2   (                  orite,           otta_Men_zu,           Smen_zu);
       }
*/
	public void Smen_settei(Tenkaizu_Syokunin orite, Tensyuugou otta_Men_zu, Tensyuugou Smen_zu) {//js.Jyougehyou_settei(ts1,ts2.get(),ts3.get());
		//��(?܂肽���ޑO�̓W�J?}�̖ʂ̂���)��?㉺�\��?��?B
		//����ɂ�ts2�̎?�_?W?�?i?܂肽���񂾂��Ƃ̖ʂ̈ʒu�֌W��?����?��?j��  <-------------otta_Men_zu
		//ts3�̎?�_?W?�?i?j��?}�Ŗʂ�?ו�������Smen��?����?��?j���g��?B <-------------Smen_zu
		//�܂�?Ats1�̎?��?A?܂����Ƃ��̖ʂ̈ʒu�֌W��?����g��?B


		System.out.println("Smen��?���?ݒ�");
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
					s0[i].addMenid(j)	;//�����Ŗʔ�?�j��?���������?�ɒǉ������?B
				}
			}
                        s0[i].setKetasuu();
		}
*/

		for (int i = 1; i <= Smensuu; i++) {
			int s0addMenidsuu = 0;
			//System.out.println("��?�?��?����Smen��?A"+i+" / "+Smensuu );
			//for(int j=1;j<=jg.getMensuu();j++){

			for (int j = 1; j <= otta_Men_zu.getMensuu(); j++) {

				//System.out.print("��?�?��?����Smen��?A"+i+" / "+Smensuu +"     :::     "   +j+"/"+jg.getMensuu()+"-");
				if (otta_Men_zu.kantan_naibu(Smen_naibuTen[i], j) == 2) {
					//System.out.println(j);
					s0addMenidsuu = s0addMenidsuu + 1;
					s0addMenid[s0addMenidsuu] = j;
				}

			}
			//if (s0addMenidsuu==0){
			//System.out.println("**1** ��?�?��?����Smen��?A"+i+" / "+Smensuu+"  :::  s0addMenidsuu= "+s0addMenidsuu+" ::: ��?�= "+Smen_zu.menseki_motome(i));
			//}/////////20150308

			s0[i].setKetasuu(s0addMenidsuu);

			//System.out.println("**2**");
			for (int j = 1; j <= s0addMenidsuu; j++) {
				s0[i].setMenid(j, s0addMenid[j]);//�����Ŗʔ�?�j��?���������?�ɒǉ������?B
			}
			//System.out.println("**3**");
		}


//4956                     System.out.print("Smensuu = "); System.out.println(Smensuu);System.exit(0);
//�����܂ł�?ASmensuu??	Smen_zu.getMensuu()�̂܂܂����Ȃ�?B
		System.out.println("�eSmen�Ɋ܂܂��ʂ�?��̓���?ő�̂��̂��?�߂�");
		//�eSmen�Ɋ܂܂��ʂ�?��̓���?ő�̂��̂��?�߂�?B
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

		//�R?܂�J?܂��?�񂩂猈�肳���?㉺�֌W��?㉺�\�ɓ����
		System.out.println("�R?܂�J?܂��?�񂩂猈�肳���?㉺�֌W��?㉺�\�ɓ����");
		int Mid_min, Mid_max;
		for (int ib = 1; ib <= orite.getBousuu(); ib++) {
			Mid_min = orite.Bou_moti_Menid_min_motome(ib);
			Mid_max = orite.Bou_moti_Menid_max_motome(ib);
			if (Mid_min != Mid_max) {//�W�J?}�ɂ�����?A�_ib�̗��e�ɖʂ�����
				//if(orite.getcolor(ib)==1){//?Ԃ�?��ŎR?܂���Ӗ�����
				if (otta_Men_zu.getcolor(ib) == 1) {//?Ԃ�?��ŎR?܂���Ӗ�����
					if (orite.getiMeniti(Mid_min) % 2 == 1) {//��Mid_min�͊�?��ʂƓ�������(�\�ʂ�?������)
						jg.set(Mid_min, Mid_max, 1);
						jg.set(Mid_max, Mid_min, 0);
					}
					if (orite.getiMeniti(Mid_max) % 2 == 1) {//��Mid_max�͊�?��ʂƓ�������(�\�ʂ�?������)
						jg.set(Mid_max, Mid_min, 1);
						jg.set(Mid_min, Mid_max, 0);
					}
				}
				//if(orite.getcolor(ib)==2){//?�?��ŒJ?܂���Ӗ�����
				if (otta_Men_zu.getcolor(ib) == 2) {//?�?��ŒJ?܂���Ӗ�����
					if (orite.getiMeniti(Mid_min) % 2 == 1) {//��Mid_min�͊�?��ʂƓ�������(�\�ʂ�?������)
						jg.set(Mid_min, Mid_max, 0);
						jg.set(Mid_max, Mid_min, 1);
					}
					if (orite.getiMeniti(Mid_max) % 2 == 1) {//��Mid_max�͊�?��ʂƓ�������(�\�ʂ�?������)
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


		System.out.println("����?��?��?ݒ肷��   ");
		//����?��?��?ݒ肷��?B�_ib�̋��E�Ƃ��ė�?ڂ���2�̖�im1,im2���L��?�?�?A?܂�?��?��肵��?�?���
		//�_ib�̈ꕔ��?d�Ȃ�ʒu�ɗL���im�͖�im1�Ɩ�im2��?㉺�����ŋ��܂�邱�Ƃ͂Ȃ�?B���̂��Ƃ���
		//gj[im1][im]=gj[im2][im]�Ƃ�������?��?��?��藧��?B
		for (int ib = 1; ib <= orite.getBousuu(); ib++) {
			Mid_min = orite.Bou_moti_Menid_min_motome(ib);
			Mid_max = orite.Bou_moti_Menid_max_motome(ib);
			if (Mid_min != Mid_max) {//�W�J?}�ɂ�����?A�_ib�̗��e�ɖʂ�����
				for (int im = 1; im <= jg.getMensuu(); im++) {
					if ((im != Mid_min) && (im != Mid_max)) {
						if (otta_Men_zu.kantan_totu_naibu(ib, im) == 1) {
							//���̂Q��if�͎b��I��?��??B���ƂŒu�������\��
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
		System.out.print("�R�ʂ��֗^����˂�����?��?��?�?@???@");
		System.out.println(jg.getTouka_jyoukensuu());

		//����?��?�̒ǉ�?B�_ib�̋��E�Ƃ��ė�?ڂ���2�̖�im1,im2���L��?A
		//�܂��_jb�̋��E�Ƃ��ė�?ڂ���2�̖�im3,im4���L��?Aib��jb����?s��?A�ꕔ?d�Ȃ�?�?�?A?܂�?��?��肵��?�?���
		//�_ib�̖ʂƖ�jb�̖ʂ�i,j,i,j?@�܂���?@j,i,j,i?@�ƕ��Ԃ��Ƃ͂Ȃ�?B�������ꂪ��������?A
		//?�?�����3�ԖڂŊԈႢ���N���Ă���̂�?A����3�Ԗڂ̂Ƃ��낪Smen�ŉ����ڂ����?�߂�?A���̌����P?i�߂�?B
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
		System.out.print("�S�ʂ��֗^����˂�����?��?��?�?@???@");
		System.out.println(jg.get_uTouka_jyoukensuu());
//5154                      System.out.print("Smensuu = "); System.out.println(Smensuu);System.exit(0);


		//�ǉ�?���
		int ituika;

		ituika = tuika_suitei();
		if (ituika != 1000) {
			return ituika;
		}

		System.out.println("�ǉ�?��� ?I����?A?㉺�\��ۑ�------------------------?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�");


		//*************?�?���?s����㈓I?��_�̌��ʂ̕ۑ�**************************
		jg.jg_hozon();//�R?܂�J?܂��?�񂩂猈�肳���?㉺�֌W��ۑ����Ă���?B
		//************************************************************************

		//Smen���Ɉē�?���?��
		System.out.println("Smen���Ɉē�?���?��");
		for (int i = 1; i <= Smensuu; i++) {
			//System.out.print("Smen");System.out.print(i);System.out.println("�ɂ�?B");
			s0[i].setAnnaisyo(jg);
		}

		//s0�ɗD?�?��ʂ�����(���̂Ƃ�jg��-100�̂Ƃ��낪�ς�Ƃ��낪����)
		System.out.println("Smen(s0)�ɗD?�?��ʂ�����");
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
				if (s0_no_yusenjyun[is0] == 0) {//�܂��D?�?��ʂ����Ă��Ȃ�Smen����������
					Sy = Smenid_yusendo(is0)/*+Smen_no_dokujisei[is0]*/;//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
					if (yusendo_max < Sy) {
						yusendo_max = Sy;
						i_yusen = is0;// i_yusen��i�Ԗڂ̗D?�x��T���Ă���?ۂ�?ł��L�͂Ȍ��̔�?�
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
		//System.out.println(Smensuu );
		//System.out.println("s0�ɗD?�?��ʂ�����" );
		//for(int i=1;i<=Smensuu;i++){System.out.println(s0_no_yusenjyun[i]);}
		//System.out.println("�D?�x����s0��id" );
		for (int i = 1; i <= Smensuu; i++) {
			//System.out.println(yusenjyun_kara_s0id[i]);
			if (i_yusendo_max[yusenjyun_kara_s0id[i]] != 0) {

				Smen_yuukou_suu = i;       //�?�����ςȌ��ʂɂȂ邱�Ƃ���?B


				//	Smen_yuukou_suu=Smensuu;//�x�����m��

//System.out.print("��");
//System.out.print(i);
//System.out.print("��(����y�A?�??");
//System.out.print(i_yusendo_max[yusenjyun_kara_s0id[i]]);

//System.out.print("?@||?@");


			}


		}

		System.out.println();
		//

		for (int i = 1; i <= Smensuu; i++) {
			s[i] = s0[yusenjyun_kara_s0id[i]];
		}

		//�D?�?��ʂ��t�]������?B���ꂪ�L�����ǂ����͕s��
		//for(int i=1;i<=Smen_yuukou_suu;i++){s[Smen_yuukou_suu-i+1]=s0[yusenjyun_kara_s0id[i]];}

/*
        for(int i=1;i<=Smensuu;i++){
                       if(i_yusendo_max[yusenjyun_kara_s0id[i]]!=0){
System.out.print("��");
System.out.print(i);
System.out.print("��(����y�A?�??");
System.out.print(i_yusendo_max[yusenjyun_kara_s0id[i]]);
System.out.print("?A��?�??");
System.out.print(s[i].getMenidsuu());
System.out.print("?@||?@");
                        }
      }

System.out.println();
 */


		//Smen�͗D?�?��̉��Ԗڂ܂ł�邩�����߂�
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


		//jg[][]��?d�Ȃ�̂���ʂ̑g��?��킹�̈ʒu�̒l��-100����-50�ɕς���?B
		for (int k = 1; k <= Smensuu; k++) {
			for (int i = 1; i <= s[k].getMenidsuu() - 1; i++) {
				for (int j = i + 1; j <= s[k].getMenidsuu(); j++) {
					jg.set(i, j, -50);
					jg.set(j, i, -50);
				}
			}
		}
		System.out.println("?㉺�\?���?ݒ�?I��");

		//System.out.print("��?���1?@");  System.out.println(s[1].getMenidsuu());
		return ireturn;


	}

	//------------------------------------------------------------
	public int tuika_suitei() {
		//�R?܂�J?܂��?�񂩂�?X�Ɍ���ł���֌W��?������Ă���?B

		int Mid;//3�ʂ̔�r�Œ��Ԃɂ����
		int flg_c = 1;
		System.out.println("�ǉ�?���J�n---------------------?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�");

		while (flg_c >= 1) {
			flg_c = 0;
			System.out.println("�ǉ�?���------------------------");
			//System.out.println("�R?܂�J?܂��?�񂩂�ǉ�?���   " );

			int flg_b = 1;
			while (flg_b >= 1) {
				flg_b = 0;

				for (int iS = 1; iS <= Smensuu; iS++) {

					int flg_a = 1;
					while (flg_a >= 1) {
						flg_a = 0;
						for (int iM = 1; iM <= s0[iS].getMenidsuu(); iM++) {//3�ʂ̔�r�Œ��Ԃɂ����
							int[] ueMenid = new int[s0[iS].getMenidsuu() + 1];//S�ʂɊ܂܂�邠��Men��?オ��ɂ���id��?����L�^����?B���ꂪ20�Ƃ������Ƃ�?A
							int[] sitaMenid = new int[s0[iS].getMenidsuu() + 1];//S�ʂɊ܂܂�邠��Men�̉�����ɂ���id��?����L�^����?B���ꂪ20�Ƃ������Ƃ�?A
							int ueMenid_max = 0;
							int sitaMenid_max = 0;
							Mid = s0[iS].getMenid(iM);

							//?l����?F����Smen�̂����Mid�ɂ���?l����?B
							//����Smen�ȊO�Ŗ�A�͖�Mid��?㑤?A��B�͖�Mid�̉����ƌ��܂��Ă����Ƃ���?B
							//��ʂɕ�?X��Smen��?A��A�͖�Mid��?㑤��?A��B�͖�Mid�̉�������������ƌ�����?A��A�͖�B��?㑤�Ƃ͌���ł��Ȃ�?B
							//������?A�������|�C���g����?A��A?A��Mid?A��B����������Ɋ܂܂�Ă���Smen������Ȃ�?A����Smen��?㉺�֌W���킩���Ă��Ȃ��Ă�
							//��A�͖�B��?㑤�ƂȂ�?B������?A���̑�?�ł͂���Smen���瓾��?��͂R�̖ʂ���������ɂ��邩�Ƃ������Ƃł���?B
							//����Smen����?㉺�֌W�͕K�v�Ȃ�?B
							//
							//�����̑�?�͂���Smen��?㉺�֌W��?㉺�\����?�?W���Ă���?B
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

									//  System.out.print(ueMenid[iuM]);System.out.print("<-?�:��->");System.out.println(sitaMenid[isM]);


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

				//System.out.print("?������ꂽ�֌W��?� ?? ");System.out.println(flg_b);
			}

			//
			//jg.jg_hozon();//�R?܂�J?܂��?�񂩂猈�肳���?㉺�֌W��ۑ����Ă���?B


			//jg ��reset�K?؂�?s���Ă��邩�m�F�̂���

			//System.out.println ("�R�ʂ��֗^����˂�����?��?����ǉ�?���   " );
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
				//System.out.print("?������ꂽ�֌W��?��� ?? ");System.out.println(flg_a);
			}

			//----------------

//	System.out.println ("�S�ʂ��֗^����˂�����?��?����ǉ�?���   " );
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
					//a>d && b>c �Ȃ� a>c && b>d
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

					//a<c && b<d �Ȃ� a<d && b<c
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
					//a<d && b<c �Ȃ� a<c && b<d
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


					//?@a>c>b?@�Ȃ�?@a>d>b
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
					//?@a>d>b?@�Ȃ�?@a>c>b
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
					//?@b>c>a?@�Ȃ�?@b>d>a
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
					//?@b>d>a?@�Ȃ�?@b>c>a
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


					//?@c>a>d?@�Ȃ�?@c>b>d
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
					//?@c>b>d?@�Ȃ�?@c>a>d
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
					//?@d>a>c?@�Ȃ�?@d>b>c
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
					//?@d>b>c?@�Ȃ�?@d>a>c
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
				//System.out.print("?������ꂽ�֌W��?��� ?? ");System.out.println(flg_a);
			}

			//----------------

			System.out.print("?������ꂽ�֌W��?���?��v ?? ");
			System.out.println(flg_c);

		}


		System.out.println("�ǉ�?��� ?I��------------------------?�?�?�?������܂�20150310?�?�?�?�?�?�?�?�?�?�?�");

		return 1000;

	}

	//------------------------------------------

	private int tuika_suitei_2() {
		//�R?܂�J?܂��?�񂩂�?X�Ɍ���ł���֌W��?������Ă���?B

		int Mid;//3�ʂ̔�r�Œ��Ԃɂ����
		int flg_c = 1;
		System.out.println("�ǉ�?���J�n---------------------?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�");

		while (flg_c >= 1) {
			flg_c = 0;
			System.out.println("�ǉ�?���------------------------");
			//System.out.println("�R?܂�J?܂��?�񂩂�ǉ�?���   " );

			int flg_b = 1;
			while (flg_b >= 1) {
				flg_b = 0;

				for (int iS = 1; iS <= Smensuu; iS++) {

					int flg_a = 1;
					while (flg_a >= 1) {
						flg_a = 0;
						for (int iM = 1; iM <= s0[iS].getMenidsuu(); iM++) {//3�ʂ̔�r�Œ��Ԃɂ����
							int[] ueMenid = new int[s0[iS].getMenidsuu() + 1];//S�ʂɊ܂܂�邠��Men��?オ��ɂ���id��?����L�^����?B���ꂪ20�Ƃ������Ƃ�?A
							int[] sitaMenid = new int[s0[iS].getMenidsuu() + 1];//S�ʂɊ܂܂�邠��Men�̉�����ɂ���id��?����L�^����?B���ꂪ20�Ƃ������Ƃ�?A
							int ueMenid_max = 0;
							int sitaMenid_max = 0;
							Mid = s0[iS].getMenid(iM);

							//?l����?F����Smen�̂����Mid�ɂ���?l����?B
							//����Smen�ȊO�Ŗ�A�͖�Mid��?㑤?A��B�͖�Mid�̉����ƌ��܂��Ă����Ƃ���?B
							//��ʂɕ�?X��Smen��?A��A�͖�Mid��?㑤��?A��B�͖�Mid�̉�������������ƌ�����?A��A�͖�B��?㑤�Ƃ͌���ł��Ȃ�?B
							//������?A�������|�C���g����?A��A?A��Mid?A��B����������Ɋ܂܂�Ă���Smen������Ȃ�?A����Smen��?㉺�֌W���킩���Ă��Ȃ��Ă�
							//��A�͖�B��?㑤�ƂȂ�?B������?A���̑�?�ł͂���Smen���瓾��?��͂R�̖ʂ���������ɂ��邩�Ƃ������Ƃł���?B
							//����Smen����?㉺�֌W�͕K�v�Ȃ�?B
							//
							//�����̑�?�͂���Smen��?㉺�֌W��?㉺�\����?�?W���Ă���?B
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

									/**/      //  System.out.print(ueMenid[iuM]);System.out.print("<-?�:��->");System.out.println(sitaMenid[isM]);


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

			//System.out.print("?������ꂽ�֌W��?� ?? ");System.out.println(flg_b);
		}


		System.out.println("�ǉ�?��� ?I��------------------------?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�?�");

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

	//s0(Smen)�̗D?�x�������l���?�߂�?B���̒l��?����ق����D?�x��?�?i�z���?擪�ɋ߂�?B?j
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
		int isusumu;//=0��?�?�Smen���ς��?i�����ς�悤�ȃC�??[�W?j?B
		int Sid;//�ω����y��Smen��id��?�
		isusumu = 0;
		//ss+1�Ԗڈ�?��Smen�݂͂�?����l�ɂ���?BSmen�Ɋ܂܂���?���0�̂Ƃ��̓G��?[�ɂȂ�?B
//System.out.println("    js.susumu 001      ss+1�Ԗڈ�?��Smen�݂͂�?����l�ɂ���?B");

		for (int i = ss + 1; i <= Smensuu; i++) {

//System.out.println("    js.susumu i= "+i+"        Smensuu= "+Smensuu);

			s[i].Jyunretu_1banme();
		}
//System.out.println("    js.susumu 002      ss+1�Ԗڈ�?��Smen�݂͂�?����l�ɂ���?B");
		//Smen��id��?��̑傫�����̂���?��������̂�?��ɖʂ�?d�Ȃ�?�Ԃ�ς��Ă���?B
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
		int isusumu;//=0��?�?�Smen���ς��?i�����ς�悤�ȃC�??[�W?j?B
		int Sid;//�ω����y��Smen��id��?�
		isusumu =0;
int ss; ss=getSmen_yuukou_suu();
	//ss+1�Ԗڈ�?��Smen�݂͂�?����l�ɂ���?B�L��?���?�͎g��Ȃ��̂�?A�������Ȃ����Ƃɂ���?B
//System.out.println("    js.susumu 001      ss+1�Ԗڈ�?��Smen�݂͂�?����l�ɂ���?B");

		//for(int i=ss+1;i<=Smensuu;i++){

//System.out.println("    js.susumu i= "+i+"        Smensuu= "+Smensuu);

		 // s[i].Jyunretu_1banme();
		//}
//System.out.println("    js.susumu 002      ss+1�Ԗڈ�?��Smen�݂͂�?����l�ɂ���?B");
		  //Smen��id��?��̑傫�����̂���?��������̂�?��ɖʂ�?d�Ȃ�?�Ԃ�ς��Ă���?B
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
	//��?݂�?���?�Ԃ���J�n����?A�\��?d�Ȃ肩���ƂȂ�?�Ԃ�T��?B�Ȃ�?A������?������̗]�n������?B
	public int kanou_kasanari_sagasi() {      //�����jg��ς��Ȃ��͂�?B
		int ms, Sid;
		ms = 0;

		//System.out.print("��?���2?@");  System.out.println(s[1].getMenidsuu());

		Sid = 1;//Sid��?����l��0�ȊO�Ȃ�Ȃ�ł�����?B
		while (Sid != 0) { //Sid==0�Ȃ�?ASmen��?ł���?���?��������̂܂Œ���?s�������Ƃ����Ӗ�?B

			ms = mujyun_Smen_motome();
			if (ms == 1000) {
				return 1000;
			}//�S�Ă�Smen��?A��?��͂Ȃ�?B
			Sid = susumu(ms - 1);

		}
		return 0;//�\��?d�Ȃ肩���ƂȂ�?�Ԃ͑�?݂��Ȃ�
	}

	//-----------------------------------------------------------------------------------------------------------------
	//?܂�?d�Ȃ������?�����Smen���?���?�����?����炳����?B  �Ȃ�?A������?������̗]�n������?B
	private int mujyun_Smen_motome() { //jg�͕ω�����?B
		int kks;
		jg.jg_fukugen();//<<<<<<<<<<<<<<<<<<<<<<<<<<<,,
		//for(int ss=1;ss<=Smensuu;ss++){
		for (int ss = 1; ss <= Smen_yuukou_suu; ss++) {      //<<<<<<<<<<<<<<?������̂��ߕ�?X?B070417
			kks = s[ss].kanou_kasanari_sagasi(jg);

			if (kks == 0) {
				return ss;
			}//kks==0�Ƃ������Ƃ�?A�\��?d�Ȃ肩��
			//�ƂȂ�?���͑�?݂��Ȃ�
			s[ss].jg_ni_Smen_wo_nyuuryoku(jg);//ss�Ԗڂ�Smen��?㉺?���jg�ɓ��͂���?B
		}


		if (tuika_suitei() != 1000) {
			return Smen_yuukou_suu;
		} //ttttttttttt
	/*
		for(int ss=Smen_yuukou_suu+1;ss<=Smensuu;ss++){      //<<<<<<<<<<<<<<
			kks=s[ss].kanou_kasanari_sagasi(jg);

	                if(kks==0){return  Smen_yuukou_suu;}//kks==0�Ƃ������Ƃ�?A�\��?d�Ȃ肩��
						//�ƂȂ�?���͑�?݂��Ȃ�
                        s[ss].jg_ni_Smen_wo_nyuuryoku(jg);//ss�Ԗڂ�Smen��?㉺?���jg�ɓ��͂���?B
	        }
	*/


		return 1000;
	}

	// ---------------------------------------------------------------
	private void kanou_kasanari_kensa() {//��Smen�����ʂ�̉\��?d�Ȃ�����?���𒲂ׂ�?B
		for (int i = 1; i <= Smen_yuukou_suu; i++) {
			System.out.print("��?���?@");
			System.out.print(s[i].getMenidsuu());
			int kanou_kasanari_suu = 0;
			kanou_kasanari_suu = kanou_kasanari_kensa(i);

			System.out.print("  ?A �\?d�Ȃ�?���?@");
			System.out.println(kanou_kasanari_suu);
		}
	}

	private int kanou_kasanari_kensa(int i) {//��Smen�����ʂ�̉\��?d�Ȃ�����?���𒲂ׂ�?B
		jg.jg_fukugen();
		s[i].Jyunretu_1banme();
		System.out.print("�D?�?���");
		System.out.print(i);
		System.out.println("�Ԃ̉\��?d�Ȃ�̗\����?�");
		//kanou_kasanari_sagasi�̒l��1000�Ȃ�Smen����?��͂Ȃ�?�ԂɂȂ���?B0�Ȃ�?ASmen����?��͂Ȃ�?�Ԃł͑�?݂��Ȃ�?B

		int kanou_kasanari_suu = 0;
		int kks;
		int sus;
		kks = s[i].kanou_kasanari_sagasi(jg);

		if (kks == 0) {
			return kanou_kasanari_suu;
		}
		kanou_kasanari_suu = kanou_kasanari_suu + 1;
		//System.out.print("�\?d�Ȃ�?�?@");System.out.println(kanou_kasanari_suu);
		sus = s[i].susumu(s[i].getMenidsuu());
		while (sus != 0) {
			kks = s[i].kanou_kasanari_sagasi(jg);


			if (kks == 0) {
				return kanou_kasanari_suu;
			}

			kanou_kasanari_suu = kanou_kasanari_suu + 1;
			//System.out.print("�\?d�Ȃ�?�?@");System.out.println(kanou_kasanari_suu);

			sus = s[i].susumu(s[i].getMenidsuu());
		}
		return kanou_kasanari_suu;

	}

	//?@������  class Jyougehyou_Syokunin  �̒��ł�?B
	//-----------------------------------------------------
	public void set_hyouji_yousiki(int i) {
		hyouji_yousiki = i;
	}


	//?}������?ۂ�?��l�ϊ��p��?�-----------------------------------------------------------------

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

	public void oekaki(Graphics g, Tenkaizu_Syokunin orite, Tensyuugou otta_Men_zu, Tensyuugou Smen_zu, int omote_ura, int hyouji_flg) {


		//hyouji_flg��?܂�?オ��?}�̕\���l���̎w��?B4�Ȃ��?ۂ�?܂莆��?܂���?�?��Ɠ���?B3�Ȃ瓧��?}
		String text = "";//������?��?�p�̃N���X�̃C���X�^���X��
		ip1 = omote_ura;
		//  System.out.println(Smensuu);
		for (int im = 1; im <= Smensuu; im++) { //Smen����?ォ��̎w�肵���Ԗڂ̖ʂ�id���?�߂�?B
			s0[im].set_Menid2uekara_kazoeta_iti(jg);
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
				if (Mid_min == Mid_max) {//���̖_�͋��E?��Ȃ̂ł��̖_�͕`��?B
					g.drawLine(gx(Smen_zu.getmaex(ib)), gy(Smen_zu.getmaey(ib)), gx(Smen_zu.getatox(ib)), gy(Smen_zu.getatoy(ib))); //��?�
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
					g.drawLine(gx(Smen_zu.getmaex(ib)), gy(Smen_zu.getmaey(ib)), gx(Smen_zu.getatox(ib)), gy(Smen_zu.getatoy(ib))); //��?�
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
				g.drawLine(gx(Smen_zu.getmaex(ib)), gy(Smen_zu.getmaey(ib)), gx(Smen_zu.getatox(ib)), gy(Smen_zu.getatoy(ib))); //��?�
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
                         	g.drawLine( gx(otta_Men_zu.getmaex(ib)),gy(otta_Men_zu.getmaey(ib)),gx(otta_Men_zu.getatox(ib)),gy(otta_Men_zu.getatoy(ib))); //��?�
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
				im = yusenjyun_kara_s0id[iu]; //Smen�̗D?�?���
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


		//hyouji_flg��?܂�?オ��?}�̕\���l���̎w��?B4�Ȃ��?ۂ�?܂莆��?܂���?�?��Ɠ���?B3�Ȃ瓧��?}
		OritaOekaki OO = new OritaOekaki();
		Ten t0 = new Ten();
		Ten t1 = new Ten();
		Senbun s_ob = new Senbun();
		Senbun s_tv = new Senbun();
		String text = "";//������?��?�p�̃N���X�̃C���X�^���X��
		ip1 = omote_ura;
		//  System.out.println(Smensuu);

		//�ʂ�`��
		int[] x = new int[100];
		int[] y = new int[100];


		if (hyouji_flg == 5) {//?܎��\��---------------------------------------------------------------------------

			for (int im = 1; im <= Smensuu; im++) { //Smen����?ォ��̎w�肵���Ԗڂ̖ʂ�id���?�߂�?B
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
				Mid_min = Smen_zu.Bou_moti_Menid_min_motome(ib);//�_ib�����E�Ƃ��Ċ܂ޖ�(?ő��2�ʂ���)�̂�����Menid��?������ق���Menid��Ԃ�?B�_�����E�Ƃ��Ċ܂ޖʂ�����?�?���0��Ԃ�
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
					g.drawLine(gx(s_tv.getax()), gy(s_tv.getay()), gx(s_tv.getbx()), gy(s_tv.getby())); //��?�
					//g.drawLine( gx(Smen_zu.getmaex(ib)),gy(Smen_zu.getmaey(ib)),gx(Smen_zu.getatox(ib)),gy(Smen_zu.getatoy(ib))); //��?�
				}


			}
			//System.out.println("?㉺�\?E?l?@oekaki_with_camera+++++++++++++++?܎��\��?@?I��");
		}


//System.out.println("?㉺�\?E?l?@oekaki_with_camera+++++++++++++++hyouji_yousiki = "+hyouji_yousiki);

		//�\���l���PSmen��`��
		if (hyouji_yousiki == 1) {
			for (int iu = 1; iu <= Smen_yuukou_suu; iu++) {
				int im;
				im = yusenjyun_kara_s0id[iu]; //Smen�̗D?�?���
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


	//---------------------------------------------------------
	public void oekaki_toukazu_with_camera(Graphics g, Tenkaizu_Syokunin orite, Tensyuugou otta_Men_zu, Tensyuugou Smen_zu, int omote_ura) {
		//System.out.println("Smen���ߕ\��003");
		//System.out.println("?㉺�\?E?l?@oekaki_with_camera+++++++++++++++���ߕ\��");
		OritaOekaki OO = new OritaOekaki();
		Ten t0 = new Ten();
		Ten t1 = new Ten();
		Senbun s_ob = new Senbun();
		Senbun s_tv = new Senbun();
		String text = "";//������?��?�p�̃N���X�̃C���X�^���X��

		//�ʂ�`��
		int[] x = new int[100];
		int[] y = new int[100];

		int col_hiku = 0;
		int colmax = 255;
		int colmin = 30;//colmax=255(?^����)�ȉ�?Acolmin=0(?^��?�)��?�
		//Menidsuu_max��1��?�ł��邱��
		if (Menidsuu_max > 0) {
			col_hiku = (colmax - colmin) / Menidsuu_max;
		}
//if(Menidsuu_max<=0){System.out.println("?㉺�\?E?l?@oekaki_toukazu_with_camera!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!    Menidsuu_max<=0  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");}

		int col_kosa;

		//�ʂ�`��
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

		//�_��`��
		int Mid_min, Mid_max;
		int Men_jyunban_min, Men_jyunban_max;
		for (int ib = 1; ib <= Smen_zu.getBousuu(); ib++) {
			s_ob.set(Smen_zu.getmaex(ib), Smen_zu.getmaey(ib), Smen_zu.getatox(ib), Smen_zu.getatoy(ib));
			s_tv.set(camera.object2TV(s_ob));
			g.drawLine(gx(s_tv.getax()), gy(s_tv.getay()), gx(s_tv.getbx()), gy(s_tv.getby())); //��?�
		}

		//camera��?S��?\���ŕ`��
		OO.jyuuji(g, camera.object2TV(camera.get_camera_ichi()), 5.0, 2.0, 4);
	}


	//---------------------------------------------------------

	Color F_color = new Color(255, 255, 50);//�\�ʂ�?F
	Color B_color = new Color(233, 233, 233);//���ʂ�?F

	public void set_F_color(Color color0) {
		F_color = color0;
	}

	//---------------------------------------------------------

	public void oekaki_oriagarizu_with_camera(Graphics g, Tenkaizu_Syokunin orite, Tensyuugou otta_Men_zu, Tensyuugou Smen_zu, int omote_ura) {
		//System.out.println("?㉺�\?E?l?@oekaki_with_camera+++++++++++++++?܎��\��?@�ʂ�`��");
		OritaOekaki OO = new OritaOekaki();
		Ten t0 = new Ten();
		Ten t1 = new Ten();
		Senbun s_ob = new Senbun();
		Senbun s_tv = new Senbun();
		String text = "";//������?��?�p�̃N���X�̃C���X�^���X��
		ip1 = omote_ura;
		//  System.out.println(Smensuu);

		//�ʂ�`��
		int[] x = new int[100];
		int[] y = new int[100];


		//if(hyouji_flg==5){//?܎��\��---------------------------------------------------------------------------

		for (int im = 1; im <= Smensuu; im++) { //Smen����?ォ��̎w�肵���Ԗڂ̖ʂ�id���?�߂�?B
			s0[im].set_Menid2uekara_kazoeta_iti(jg);
		}


		//�ʂ�`��

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
		//System.out.println("?㉺�\?E?l?@oekaki_with_camera+++++++++++++++?܎��\��?@�_��`��");
		//�_��`��
		int Mid_min, Mid_max;
		int Men_jyunban_min, Men_jyunban_max;
		int oekaki_flg;
		for (int ib = 1; ib <= Smen_zu.getBousuu(); ib++) {
			oekaki_flg = 0;
			Mid_min = Smen_zu.Bou_moti_Menid_min_motome(ib);//�_ib�����E�Ƃ��Ċ܂ޖ�(?ő��2�ʂ���)�̂�����Menid��?������ق���Menid��Ԃ�?B�_�����E�Ƃ��Ċ܂ޖʂ�����?�?���0��Ԃ�
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
				g.drawLine(gx(s_tv.getax()), gy(s_tv.getay()), gx(s_tv.getbx()), gy(s_tv.getby())); //��?�
				//g.drawLine( gx(Smen_zu.getmaex(ib)),gy(Smen_zu.getmaey(ib)),gx(Smen_zu.getatox(ib)),gy(Smen_zu.getatoy(ib))); //��?�
			}


		}
		//System.out.println("?㉺�\?E?l?@oekaki_with_camera+++++++++++++++?܎��\��?@?I��");
		//}


		//camera��?S��?\���ŕ`��
		OO.jyuuji(g, camera.object2TV(camera.get_camera_ichi()), 5.0, 2.0, 4);
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


}     


