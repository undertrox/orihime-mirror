package jp.gr.java_conf.mt777.origami.orihime.egaki_syokunin.egaki_syokunin_dougubako;

import jp.gr.java_conf.mt777.origami.dougu.orisensyuugou.Orisensyuugou;
import jp.gr.java_conf.mt777.zukei2d.oritacalc.OritaCalc;
import jp.gr.java_conf.mt777.zukei2d.senbun.Senbun;

// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
public class Egaki_Syokunin_Dougubako {


    OritaCalc oc = new OritaCalc(); //ŠeŽíŒvŽZ—p‚ÌŠÖ?”‚ðŽg‚¤‚½‚ß‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»
    Orisensyuugou ori_s;


    public Egaki_Syokunin_Dougubako(Orisensyuugou o_s) {  //ƒRƒ“ƒXƒgƒ‰ƒNƒ^
        ori_s = o_s;
    }

    //ƒxƒNƒgƒ‹ab(=s0)‚ð“_a‚©‚çb•ûŒü‚É?A?Å?‰‚É‘¼‚Ì?Ü?ü‚ÆŒð?·‚·‚é‚Æ‚±‚ë‚Ü‚Å‰„’·‚·‚é
    Senbun kousaten_made_nobasi_senbun = new Senbun();
    Ten kousaten_made_nobasi_ten = new Ten();
    int kousaten_made_nobasi_flg = 0;//ab‚ð?L‚Î‚µ‚½?Å?‰‚ÌŒð“_‚Ì?ó‹µ
    int kousaten_made_nobasi_orisen_fukumu_flg = 0;//ab‚ð’¼?ü‰»‚µ‚½‚Ì‚ª?AŠù‘¶‚Ì?Ü?ü‚ðŠÜ‚Þ‚È‚ç3
    Senbun kousaten_made_nobasi_saisyono_senbun = new Senbun();//ab‚ð’¼?ü‰»‚µ‚½‚Ì‚Æ?A?Å?‰‚É‚Ô‚Â‚©‚éŠù‘¶‚Ì?Ü?ü



/*
	public void kousaten_made_nobasi_keisan(Ten a,Ten b) {//ƒxƒNƒgƒ‹ab(=s0)‚ð“_a‚©‚çb•ûŒü‚É?A?Å?‰‚É‘¼‚Ì?Ü?ü‚ÆŒð?·‚·‚é‚Æ‚±‚ë‚Ü‚Å‰„’·‚·‚é//‘¼‚Ì?Ü?ü‚ÆŒð?·‚µ‚È‚¢‚È‚ç?ATen a‚ð•Ô‚·
			Senbun s0=new Senbun();s0.set(a,b);
			Senbun add_sen=new Senbun();add_sen.set(s0);
			Ten kousa_ten =new Ten(1000000.0,1000000.0); //‚±‚Ì•û–@‚¾‚Æ?AƒGƒ‰?[‚ÌŒ´ˆö‚É‚È‚è‚¤‚é?B–{“–‚È‚ç‘S?ü•ª‚Ìx_max?Ay_maxˆÈ?ã‚Ì“_‚ðŽæ‚ê‚Î‚¢‚¢?B?¡Œã?C?³—\’è20161120
			double kousa_ten_kyori=kousa_ten.kyori(add_sen.geta());
			Tyokusen tyoku1 =new Tyokusen(add_sen.geta(),add_sen.getb());
			int i_kousa_flg;

			kousaten_made_nobasi_flg=0;
			kousaten_made_nobasi_orisen_fukumu_flg=0;
			for (int i=1; i<=ori_s.getsousuu(); i++ ){
				
				i_kousa_flg=tyoku1.senbun_kousa_hantei_kuwasii(ori_s.get(i));//0=‚±‚Ì’¼?ü‚Í—^‚¦‚ç‚ê‚½?ü•ª‚ÆŒð?·‚µ‚È‚¢?A1=XŒ^‚ÅŒð?·‚·‚é?A2=TŒ^‚ÅŒð?·‚·‚é?A3=?ü•ª‚Í’¼?ü‚ÉŠÜ‚Ü‚ê‚é?B
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
    public void kousaten_made_nobasi_keisan_fukumu_senbun_musi(Ten a, Ten b) {//ƒxƒNƒgƒ‹ab(=s0)‚ð“_a‚©‚çb•ûŒü‚É?A?Å?‰‚É‘¼‚Ì?Ü?ü(’¼?ü‚ÉŠÜ‚Ü‚ê‚é?ü•ª‚Í–³Ž‹?B)‚ÆŒð?·‚·‚é‚Æ‚±‚ë‚Ü‚Å‰„’·‚·‚é//‘¼‚Ì?Ü?ü‚ÆŒð?·‚µ‚È‚¢‚È‚ç?ATen a‚ð•Ô‚·
        Senbun s0 = new Senbun();
        s0.set(a, b);
        Senbun add_sen = new Senbun();
        add_sen.set(s0);
        Ten kousa_ten = new Ten(1000000.0, 1000000.0); //‚±‚Ì•û–@‚¾‚Æ?AƒGƒ‰?[‚ÌŒ´ˆö‚É‚È‚è‚¤‚é?B–{“–‚È‚ç‘S?ü•ª‚Ìx_max?Ay_maxˆÈ?ã‚Ì“_‚ðŽæ‚ê‚Î‚¢‚¢?B?¡Œã?C?³—\’è20161120
        double kousa_ten_kyori = kousa_ten.kyori(add_sen.geta());
        Tyokusen tyoku1 = new Tyokusen(add_sen.geta(), add_sen.getb());
        int i_kousa_flg;

        kousaten_made_nobasi_flg = 0;
        kousaten_made_nobasi_orisen_fukumu_flg = 0;
        for (int i = 1; i <= ori_s.getsousuu(); i++) {

            i_kousa_flg = tyoku1.senbun_kousa_hantei_kuwasii(ori_s.get(i));//0=‚±‚Ì’¼?ü‚Í—^‚¦‚ç‚ê‚½?ü•ª‚ÆŒð?·‚µ‚È‚¢?A1=XŒ^‚ÅŒð?·‚·‚é?A2=TŒ^‚ÅŒð?·‚·‚é?A3=?ü•ª‚Í’¼?ü‚ÉŠÜ‚Ü‚ê‚é?B
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
    public int get_kousaten_made_nobasi_flg(Ten a, Ten b) {//0=‚±‚Ì’¼?ü‚Í—^‚¦‚ç‚ê‚½?ü•ª‚ÆŒð?·‚µ‚È‚¢?A1=XŒ^‚ÅŒð?·‚·‚é?A2=TŒ^‚ÅŒð?·‚·‚é?A3=?ü•ª‚Í’¼?ü‚ÉŠÜ‚Ü‚ê‚é?B
        kousaten_made_nobasi_keisan_fukumu_senbun_musi(a, b);
        return kousaten_made_nobasi_flg;
    }

    // -------------------
/*
public int get_kousaten_made_nobasi_orisen_fukumu_flg(Ten a,Ten b){//ab‚ð’¼?ü‰»‚µ‚½‚Ì‚ª?AŠù‘¶‚Ì?Ü?ü‚ðŠÜ‚Þ‚È‚ç3
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
ˆê’l•ª‰ð‚·‚éŠÖ?”itti_bunkai();

public void itti_bunkai(){//?i‚P?j2“_a,b‚ðŽw’è







}

?i‚P?j2“_a,b‚ðŽw’è
?i‚Q?ja‚ðŠî“_‚Æ‚·‚éƒxƒNƒgƒ‹ab‚ª?Å?‰‚É‚Ô‚Â‚©‚é?Ü?ü‚Æ‚ÌŒð“_c‚ð‹?‚ß‚é?Bab‚Æ?d‚È‚é?Ü?ü‚Í–³Ž‹
?i‚R?j
c‚ªŠù‘¶‚Ì?Ü?ü‚Ì•¿‚Ì•”•ª‚¾‚Á‚½?ê?‡?A‚»‚Ì?ü‚Å‹¾‰f‚µ?Ac‚ða‚Æ‚µ?Ab‚ð‹¾‰f?ü‚Ì?æ‚Ì“_‚Æ‚µ‚Ä?Ä‹A“I‚É?B
c‚ª“_‚¾‚Á‚½?ê?‡?A‚·‚Å‚É’Ê‰ß‚µ‚Ä‚¢‚½“_‚È‚ç?Areturn;


c‚©‚çƒxƒNƒgƒ‹ac‚Æˆê’l?«‚ðŽ?‚ÂƒxƒNƒgƒ‹‚ð‹?‚ß‚é?A




















*/






/*


	public Ten kousaten_made_nobasi(Ten a,Ten b) {//ƒxƒNƒgƒ‹ab(=s0)‚ð“_a‚©‚çb•ûŒü‚É?A‘¼‚Ì?Ü?ü‚ÆŒð?·‚·‚é‚Æ‚±‚ë‚Ü‚Å‰„’·‚·‚é?V‚µ‚¢Ten‚ð•Ô‚·//‘¼‚Ì?Ü?ü‚ÆŒð?·‚µ‚È‚¢‚È‚ç?ATen a‚ð•Ô‚·
			Senbun s0=new Senbun();s0.set(a,b);

			Senbun add_sen=new Senbun();add_sen.set(s0);
			Ten kousa_ten =new Ten(1000000.0,1000000.0); //‚±‚Ì•û–@‚¾‚Æ?AƒGƒ‰?[‚ÌŒ´ˆö‚É‚È‚è‚¤‚é?B–{“–‚È‚ç‘S?ü•ª‚Ìx_max?Ay_maxˆÈ?ã‚Ì“_‚ðŽæ‚ê‚Î‚¢‚¢?B?¡Œã?C?³—\’è20161120
			double kousa_ten_kyori=kousa_ten.kyori(add_sen.geta());


			Tyokusen tyoku1 =new Tyokusen(add_sen.geta(),add_sen.getb());
			int i_kousa_flg;
			for (int i=1; i<=ori_s.getsousuu(); i++ ){
				i_kousa_flg=tyoku1.senbun_kousa_hantei_kuwasii(ori_s.get(i));//0=‚±‚Ì’¼?ü‚Í—^‚¦‚ç‚ê‚½?ü•ª‚ÆŒð?·‚µ‚È‚¢?A1=XŒ^‚ÅŒð?·‚·‚é?A2=TŒ^‚ÅŒð?·‚·‚é?A3=?ü•ª‚Í’¼?ü‚ÉŠÜ‚Ü‚ê‚é?B

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
    public void test1() {//ƒfƒoƒbƒN“™‚ÌƒeƒXƒg—p

        System.out.println("_________");

    }

    //--------------------------------------------

    //ƒ?ƒ‚
    //icol=0 black
    //icol=1 red
    //icol=2 blue
    //icol=3 cyan
    //icol=4 orange
    //icol=5 mazenta
    //icol=6 green
    //icol=7 yellow
    //icol=8 new Color(210,0,255) //Ž‡


}