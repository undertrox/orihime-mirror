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


    OritaCalc oc = new OritaCalc(); //各種計算用の関?狽gうためのクラスのインスタンス化
    Orisensyuugou ori_s;


    public Egaki_Syokunin_Dougubako(Orisensyuugou o_s) {  //コンストラクタ
        ori_s = o_s;
    }

    //ベクトルab(=s0)を点aからb方向に?A?ﾅ?奄ﾉ他の?ﾜ??と交?ｷするところまで延長する
    Senbun kousaten_made_nobasi_senbun = new Senbun();
    Ten kousaten_made_nobasi_ten = new Ten();
    int kousaten_made_nobasi_flg = 0;//abを?Lばした?ﾅ?奄ﾌ交点の?ｵ
    int kousaten_made_nobasi_orisen_fukumu_flg = 0;//abを直??化したのが?A既存の?ﾜ??を含むなら3
    Senbun kousaten_made_nobasi_saisyono_senbun = new Senbun();//abを直??化したのと?A?ﾅ?奄ﾉぶつかる既存の?ﾜ??



/*
	public void kousaten_made_nobasi_keisan(Ten a,Ten b) {//ベクトルab(=s0)を点aからb方向に?A?ﾅ?奄ﾉ他の?ﾜ??と交?ｷするところまで延長する//他の?ﾜ??と交?ｷしないなら?ATen aを返す
			Senbun s0=new Senbun();s0.set(a,b);
			Senbun add_sen=new Senbun();add_sen.set(s0);
			Ten kousa_ten =new Ten(1000000.0,1000000.0); //この方法だと?Aエラ?[の原因になりうる?B本当なら全??分のx_max?Ay_max以?繧ﾌ点を取ればいい?B?｡後?C?ｳ予定20161120
			double kousa_ten_kyori=kousa_ten.kyori(add_sen.geta());
			Tyokusen tyoku1 =new Tyokusen(add_sen.geta(),add_sen.getb());
			int i_kousa_flg;

			kousaten_made_nobasi_flg=0;
			kousaten_made_nobasi_orisen_fukumu_flg=0;
			for (int i=1; i<=ori_s.getsousuu(); i++ ){
				
				i_kousa_flg=tyoku1.senbun_kousa_hantei_kuwasii(ori_s.get(i));//0=この直??は与えられた??分と交?ｷしない?A1=X型で交?ｷする?A2=T型で交?ｷする?A3=??分は直??に含まれる?B
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
    public void kousaten_made_nobasi_keisan_fukumu_senbun_musi(Ten a, Ten b) {//ベクトルab(=s0)を点aからb方向に?A?ﾅ?奄ﾉ他の?ﾜ??(直??に含まれる??分は無視?B)と交?ｷするところまで延長する//他の?ﾜ??と交?ｷしないなら?ATen aを返す
        Senbun s0 = new Senbun();
        s0.set(a, b);
        Senbun add_sen = new Senbun();
        add_sen.set(s0);
        Ten kousa_ten = new Ten(1000000.0, 1000000.0); //この方法だと?Aエラ?[の原因になりうる?B本当なら全??分のx_max?Ay_max以?繧ﾌ点を取ればいい?B?｡後?C?ｳ予定20161120
        double kousa_ten_kyori = kousa_ten.kyori(add_sen.geta());
        Tyokusen tyoku1 = new Tyokusen(add_sen.geta(), add_sen.getb());
        int i_kousa_flg;

        kousaten_made_nobasi_flg = 0;
        kousaten_made_nobasi_orisen_fukumu_flg = 0;
        for (int i = 1; i <= ori_s.getsousuu(); i++) {

            i_kousa_flg = tyoku1.senbun_kousa_hantei_kuwasii(ori_s.get(i));//0=この直??は与えられた??分と交?ｷしない?A1=X型で交?ｷする?A2=T型で交?ｷする?A3=??分は直??に含まれる?B
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
    public int get_kousaten_made_nobasi_flg(Ten a, Ten b) {//0=この直??は与えられた??分と交?ｷしない?A1=X型で交?ｷする?A2=T型で交?ｷする?A3=??分は直??に含まれる?B
        kousaten_made_nobasi_keisan_fukumu_senbun_musi(a, b);
        return kousaten_made_nobasi_flg;
    }

    // -------------------
/*
public int get_kousaten_made_nobasi_orisen_fukumu_flg(Ten a,Ten b){//abを直??化したのが?A既存の?ﾜ??を含むなら3
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
一値分解する関?琶tti_bunkai();

public void itti_bunkai(){//?i１?j2点a,bを指定







}

?i１?j2点a,bを指定
?i２?jaを基点とするベクトルabが?ﾅ?奄ﾉぶつかる?ﾜ??との交点cを??める?Babと?dなる?ﾜ??は無視
?i３?j
cが既存の?ﾜ??の柄の部分だった?????Aその??で鏡映し?Acをaとし?Abを鏡映??の?謔ﾌ点として?ﾄ帰的に?B
cが点だった?????Aすでに通過していた点なら?Areturn;


cからベクトルacと一値?ｫを??つベクトルを??める?A




















*/






/*


	public Ten kousaten_made_nobasi(Ten a,Ten b) {//ベクトルab(=s0)を点aからb方向に?A他の?ﾜ??と交?ｷするところまで延長する?VしいTenを返す//他の?ﾜ??と交?ｷしないなら?ATen aを返す
			Senbun s0=new Senbun();s0.set(a,b);

			Senbun add_sen=new Senbun();add_sen.set(s0);
			Ten kousa_ten =new Ten(1000000.0,1000000.0); //この方法だと?Aエラ?[の原因になりうる?B本当なら全??分のx_max?Ay_max以?繧ﾌ点を取ればいい?B?｡後?C?ｳ予定20161120
			double kousa_ten_kyori=kousa_ten.kyori(add_sen.geta());


			Tyokusen tyoku1 =new Tyokusen(add_sen.geta(),add_sen.getb());
			int i_kousa_flg;
			for (int i=1; i<=ori_s.getsousuu(); i++ ){
				i_kousa_flg=tyoku1.senbun_kousa_hantei_kuwasii(ori_s.get(i));//0=この直??は与えられた??分と交?ｷしない?A1=X型で交?ｷする?A2=T型で交?ｷする?A3=??分は直??に含まれる?B

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
    public void test1() {//デバック等のテスト用

        System.out.println("_________");

    }

    //--------------------------------------------

    //??モ
    //icol=0 black
    //icol=1 red
    //icol=2 blue
    //icol=3 cyan
    //icol=4 orange
    //icol=5 mazenta
    //icol=6 green
    //icol=7 yellow
    //icol=8 new Color(210,0,255) //紫


}