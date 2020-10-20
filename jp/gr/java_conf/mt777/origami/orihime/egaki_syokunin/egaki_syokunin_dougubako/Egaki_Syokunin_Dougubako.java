package jp.gr.java_conf.mt777.origami.orihime.egaki_syokunin.egaki_syokunin_dougubako;

import jp.gr.java_conf.mt777.origami.dougu.orisensyuugou.Orisensyuugou;
import jp.gr.java_conf.mt777.zukei2d.oritacalc.OritaCalc;
import jp.gr.java_conf.mt777.zukei2d.oritacalc.tyokusen.Tyokusen;
import jp.gr.java_conf.mt777.zukei2d.senbun.Senbun;
import jp.gr.java_conf.mt777.zukei2d.ten.Ten;

// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
public class Egaki_Syokunin_Dougubako {


    OritaCalc oc = new OritaCalc(); //�e��v�Z�p�̊�?����g�����߂̃N���X�̃C���X�^���X��
    Orisensyuugou ori_s;


    public Egaki_Syokunin_Dougubako(Orisensyuugou o_s) {  //�R���X�g���N�^
        ori_s = o_s;
    }

    //�x�N�g��ab(=s0)��_a����b������?A?�?��ɑ���?�??�ƌ�?�����Ƃ���܂ŉ�������
    Senbun kousaten_made_nobasi_senbun = new Senbun();
    Ten kousaten_made_nobasi_ten = new Ten();
    int kousaten_made_nobasi_flg = 0;//ab��?L�΂���?�?��̌�_��?�
    int kousaten_made_nobasi_orisen_fukumu_flg = 0;//ab��??�������̂�?A������?�??���܂ނȂ�3
    Senbun kousaten_made_nobasi_saisyono_senbun = new Senbun();//ab��??�������̂�?A?�?��ɂԂ��������?�??



/*
	public void kousaten_made_nobasi_keisan(Ten a,Ten b) {//�x�N�g��ab(=s0)��_a����b������?A?�?��ɑ���?�??�ƌ�?�����Ƃ���܂ŉ�������//����?�??�ƌ�?����Ȃ��Ȃ�?ATen a��Ԃ�
			Senbun s0=new Senbun();s0.set(a,b);
			Senbun add_sen=new Senbun();add_sen.set(s0);
			Ten kousa_ten =new Ten(1000000.0,1000000.0); //���̕��@����?A�G��?[�̌����ɂȂ肤��?B�{���Ȃ�S??����x_max?Ay_max��?�̓_�����΂���?B?���?C?��\��20161120
			double kousa_ten_kyori=kousa_ten.kyori(add_sen.geta());
			Tyokusen tyoku1 =new Tyokusen(add_sen.geta(),add_sen.getb());
			int i_kousa_flg;

			kousaten_made_nobasi_flg=0;
			kousaten_made_nobasi_orisen_fukumu_flg=0;
			for (int i=1; i<=ori_s.getsousuu(); i++ ){
				
				i_kousa_flg=tyoku1.senbun_kousa_hantei_kuwasii(ori_s.get(i));//0=���̒�??�͗^����ꂽ??���ƌ�?����Ȃ�?A1=X�^�Ō�?�����?A2=T�^�Ō�?�����?A3=??���͒�??�Ɋ܂܂��?B
				if(i_kousa_flg==3){kousaten_made_nobasi_orisen_fukumu_flg=3;}
				if((i_kousa_flg==1||i_kousa_flg==21)||i_kousa_flg==22){

					kousa_ten.set(oc.kouten_motome(tyoku1,ori_s.get(i)));

					if(kousa_ten.kyori(add_sen.geta())>0.00001     ){

						if(kousa_ten.kyori(add_sen.geta())<kousa_ten_kyori   ){
							double d_kakudo=oc.kakudo(add_sen.geta(),add_sen.getb(),add_sen.geta(),kousa_ten);

							if(d_kakudo<1.0||d_kakudo>359.0){

								kousa_ten_kyori=kousa_ten.kyori(add_sen.geta());
								add_sen.set(add_sen.geta(),kousa_ten);
							
								kousaten_made_nobasi_flg=i_kousa_flg;
								kousaten_made_nobasi_saisyono_senbun.set(ori_s.get(i));

							}
					
						}

					}

				}
	
			}
		//return add_sen.getb();

		kousaten_made_nobasi_senbun.set(add_sen);
		kousaten_made_nobasi_ten.set(add_sen.getb());
	}

*/

    // -------------------
    public void kousaten_made_nobasi_keisan_fukumu_senbun_musi(Ten a, Ten b) {//�x�N�g��ab(=s0)��_a����b������?A?�?��ɑ���?�??(��??�Ɋ܂܂��??���͖���?B)�ƌ�?�����Ƃ���܂ŉ�������//����?�??�ƌ�?����Ȃ��Ȃ�?ATen a��Ԃ�
        Senbun s0 = new Senbun();
        s0.set(a, b);
        Senbun add_sen = new Senbun();
        add_sen.set(s0);
        Ten kousa_ten = new Ten(1000000.0, 1000000.0); //���̕��@����?A�G��?[�̌����ɂȂ肤��?B�{���Ȃ�S??����x_max?Ay_max��?�̓_�����΂���?B?���?C?��\��20161120
        double kousa_ten_kyori = kousa_ten.kyori(add_sen.geta());
        Tyokusen tyoku1 = new Tyokusen(add_sen.geta(), add_sen.getb());
        int i_kousa_flg;

        kousaten_made_nobasi_flg = 0;
        kousaten_made_nobasi_orisen_fukumu_flg = 0;
        for (int i = 1; i <= ori_s.getsousuu(); i++) {

            i_kousa_flg = tyoku1.senbun_kousa_hantei_kuwasii(ori_s.get(i));//0=���̒�??�͗^����ꂽ??���ƌ�?����Ȃ�?A1=X�^�Ō�?�����?A2=T�^�Ō�?�����?A3=??���͒�??�Ɋ܂܂��?B
            //if(i_kousa_flg==3){kousaten_made_nobasi_orisen_fukumu_flg=3;}
            if ((i_kousa_flg == 1 || i_kousa_flg == 21) || i_kousa_flg == 22) {

                kousa_ten.set(oc.kouten_motome(tyoku1, ori_s.get(i)));

                if (kousa_ten.kyori(add_sen.geta()) > 0.00001) {

                    if (kousa_ten.kyori(add_sen.geta()) < kousa_ten_kyori) {
                        double d_kakudo = oc.kakudo(add_sen.geta(), add_sen.getb(), add_sen.geta(), kousa_ten);

                        if (d_kakudo < 1.0 || d_kakudo > 359.0) {

                            kousa_ten_kyori = kousa_ten.kyori(add_sen.geta());
                            add_sen.set(add_sen.geta(), kousa_ten);

                            kousaten_made_nobasi_flg = i_kousa_flg;
                            kousaten_made_nobasi_saisyono_senbun.set(ori_s.get(i));

                        }

                    }

                }

            }

        }
        //return add_sen.getb();

        kousaten_made_nobasi_senbun.set(add_sen);
        kousaten_made_nobasi_ten.set(add_sen.getb());
    }


    // -------------------
    public int get_kousaten_made_nobasi_flg(Ten a, Ten b) {//0=���̒�??�͗^����ꂽ??���ƌ�?����Ȃ�?A1=X�^�Ō�?�����?A2=T�^�Ō�?�����?A3=??���͒�??�Ɋ܂܂��?B
        kousaten_made_nobasi_keisan_fukumu_senbun_musi(a, b);
        return kousaten_made_nobasi_flg;
    }

    // -------------------
/*
public int get_kousaten_made_nobasi_orisen_fukumu_flg(Ten a,Ten b){//ab��??�������̂�?A������?�??���܂ނȂ�3
	kousaten_made_nobasi_keisan(a,b);
	return kousaten_made_nobasi_orisen_fukumu_flg;
}
*/
// -------------------
    public Senbun get_kousaten_made_nobasi_senbun(Ten a, Ten b) {
        kousaten_made_nobasi_keisan_fukumu_senbun_musi(a, b);
        return kousaten_made_nobasi_senbun;
    }


    // -------------------
    public Senbun get_kousaten_made_nobasi_saisyono_senbun(Ten a, Ten b) {
        kousaten_made_nobasi_keisan_fukumu_senbun_musi(a, b);
        return kousaten_made_nobasi_saisyono_senbun;
    }


    // -------------------
    public Ten get_kousaten_made_nobasi_ten(Ten a, Ten b) {
        kousaten_made_nobasi_keisan_fukumu_senbun_musi(a, b);
        return kousaten_made_nobasi_ten;
    }


//e_s_dougubako





/*
��l���������?�itti_bunkai();

public void itti_bunkai(){//?i�P?j2�_a,b���w��







}

?i�P?j2�_a,b���w��
?i�Q?ja����_�Ƃ���x�N�g��ab��?�?��ɂԂ���?�??�Ƃ̌�_c��??�߂�?Bab��?d�Ȃ�?�??�͖���
?i�R?j
c��������?�??�̕��̕���������?????A����??�ŋ��f��?Ac��a�Ƃ�?Ab�����f??��?�̓_�Ƃ���?ċA�I��?B
c���_������?????A���łɒʉ߂��Ă����_�Ȃ�?Areturn;


c����x�N�g��ac�ƈ�l?���??�x�N�g����??�߂�?A




















*/






/*


	public Ten kousaten_made_nobasi(Ten a,Ten b) {//�x�N�g��ab(=s0)��_a����b������?A����?�??�ƌ�?�����Ƃ���܂ŉ�������?V����Ten��Ԃ�//����?�??�ƌ�?����Ȃ��Ȃ�?ATen a��Ԃ�
			Senbun s0=new Senbun();s0.set(a,b);

			Senbun add_sen=new Senbun();add_sen.set(s0);
			Ten kousa_ten =new Ten(1000000.0,1000000.0); //���̕��@����?A�G��?[�̌����ɂȂ肤��?B�{���Ȃ�S??����x_max?Ay_max��?�̓_�����΂���?B?���?C?��\��20161120
			double kousa_ten_kyori=kousa_ten.kyori(add_sen.geta());


			Tyokusen tyoku1 =new Tyokusen(add_sen.geta(),add_sen.getb());
			int i_kousa_flg;
			for (int i=1; i<=ori_s.getsousuu(); i++ ){
				i_kousa_flg=tyoku1.senbun_kousa_hantei_kuwasii(ori_s.get(i));//0=���̒�??�͗^����ꂽ??���ƌ�?����Ȃ�?A1=X�^�Ō�?�����?A2=T�^�Ō�?�����?A3=??���͒�??�Ɋ܂܂��?B

				if((i_kousa_flg==1||i_kousa_flg==21)||i_kousa_flg==22){
					kousa_ten.set(oc.kouten_motome(tyoku1,ori_s.get(i)));
					if(kousa_ten.kyori(add_sen.geta())>0.00001     ){

						if(kousa_ten.kyori(add_sen.geta())<kousa_ten_kyori   ){

							double d_kakudo=oc.kakudo(add_sen.geta(),add_sen.getb(),add_sen.geta(),kousa_ten);
							if(d_kakudo<1.0||d_kakudo>359.0){
								//i_kouten_ari_nasi=1;
								kousa_ten_kyori=kousa_ten.kyori(add_sen.geta());
								add_sen.set(add_sen.geta(),kousa_ten);
							}
						}
					}
				}
			}
		return add_sen.getb();
	}


*/


    //--------------------------------------------
    public void test1() {//�f�o�b�N���̃e�X�g�p

        System.out.println("_________");

    }

    //--------------------------------------------

    //??��
    //icol=0 black
    //icol=1 red
    //icol=2 blue
    //icol=3 cyan
    //icol=4 orange
    //icol=5 mazenta
    //icol=6 green
    //icol=7 yellow
    //icol=8 new Color(210,0,255) //��


}