package jp.gr.java_conf.mt777.origami.orihime.oriagari_zu;

//import java.awt.MouseInfo;
//import java.awt.PointerInfo;

import jp.gr.java_conf.mt777.origami.orihime.ap;


// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
//public class Oriagari_Zu_01 {
public class Oriagari_Zu_01 extends Oriagari_Zu {//Oriagari_Zuªî{ÆÈé?Ü?ãªè\ªASY
/*
	ap orihime_ap;

	OritaCalc oc =new OritaCalc(); 
	Moji_sousa ms =new Moji_sousa(); //¶ñ?ìpÌÖ?ð?Wß½NX

	double r=3.0;                   //î{}?\¢Ì¼?üÌ¼[Ì~Ì¼a?A}Æeí|CgÌß³Ì»èî?


	public double d_oriagarizu_syukusyaku_keisuu=1.0;//?Üè?ãªè?}Ì?kÚW?
	public double d_oriagarizu_kaiten_hosei=0.0;//?Üè?ãªè?}Ìñ]\¦pxÌâ?³px

	public Kihonshi_Syokunin ks2       = new Kihonshi_Syokunin(r);    //î{}?E?l?Bts2Ì?Â_?W?ðts3Én·OÉ?A
                                                             //ts2Ì?Â_?W?Í_ª?dÈÁÄ¢½è·é©àµêÈ¢ÌÅ?A
                                                             //¢Á½ñks2ÉnµÄ?üª?W?ÆµÄ?®?·é?B

	public Tenkaizu_Syokunin ts1       = new Tenkaizu_Syokunin(r);    //WJ?}?E?l?BüÍ³ê½?üª?W?ð?Å?É?ÜÁÄ?jà?óÌ_?W?Ì?Üè?ãªè?}ð?ìé
	public Tenkaizu_Syokunin ts2       = new Tenkaizu_Syokunin(r);    //WJ?}?E?l?Bts1Ì?ìÁ½?jà?óÌ_?W?Ì?Üè?ãªè?}ðÛ?µ?A?üª?W?É·éÈÇÌ­«ð·é?B  
	public Tenkaizu_Syokunin ts3       = new Tenkaizu_Syokunin(r);    //WJ?}?E?l?Bts1Ì?ìÁ½?jà?óÌ_?W?ð?®?µ?B?V½ÉÊðF¯·éÈÇÌ­«ð?Â?B  

	public Jyougehyou_Syokunin js     ;
	//public Jyougehyou_Syokunin js      = new Jyougehyou_Syokunin();
	//public Jyougehyou_Syokunin(ap ap0){ orihime_ap=ap0;    reset();	}    //RXgN^

        public Camera camera_of_oriagarizu	= new Camera();
        public Camera camera_of_oriagari_omote	= new Camera();
        public Camera camera_of_oriagari_ura	= new Camera();
        public Camera camera_of_touka_omote	= new Camera();
        public Camera camera_of_touka_ura	= new Camera();

	public Color oriagarizu_F_color=new Color(255,255,50);//?Üè?ãªè?}Ì\ÊÌ?F
	public Color oriagarizu_B_color=new Color(233,233,233);//?Üè?ãªè?}Ì ÊÌ?F
	public Color oriagarizu_L_color=Color.black;//?Üè?ãªè?}Ì?üÌ?F

	public  int hyouji_flg_backup=4;//\¦l®hyouji_flgÌêIobNAbvp
 		//int hyouji_flg_backup=4;//\¦l®hyouji_flgÌêIobNAbvp
	public int hyouji_flg=0;//?Üè?ãªè?}Ì\¦l®Ìwè?B1ÈçWJ?}?®??A2Èç?jà?}?B3Èç§ß?}?B4ÈçÀ?ÛÉ?Üèð?ÜÁ½?ê?Æ¯¶?B
	public int i_suitei_meirei=0;//?Üè?ôÝ?èðÇÌiKÜÅ?s¤©Ìw¦
	public int i_suitei_dankai=0;//?Üè?ôÝ?èªÇÌiKÜÅÅ«½©Ì\¦
	//public int i_suitei_jissi_umu=0;//int i_suitei_jissi_umuÍ?A?Üè?ôÝ?èÌvZðÀ{µ½©Ç¤©ð\·?Bint i_suitei_jissi_umu=0ÈçÀ{µÈ¢?B1ÈçÀ{µ½?B


	//\¦pÌlði[·éÏ?
	public int ip1=-1;//?ãº\?E?lÌ?ú?ÝèÉ?A?ÜÁ½ãÌ\ ª¯¶Êª
		//×?Ú·éÆ¢¤ë?·ª êª0ð?A³¯êÎ1000ði[·éÏ??B
		//±±ÅÌ?úlÍ(0©1000)ÈOÌ?ÈçÈñÅà¢¢?B	
	public int ip2=-1;//?ãº\?E?lª?Üè?ôÝÂ\È?dÈèûðTµ½?ÛÉ?A
		//Â\È?dÈèûªÈ¯êÎ0ð?AÂ\È?dÈèûª êÎ1000ði[·éÏ??B
		//±±ÅÌ?úlÍ(0©1000)ÈOÌ?ÈçÈñÅà¢¢?B	
	//int ip3a=1;
	public int ip3=1;//ts1ª?Üè?ôÝð?s¤?ÛÌî?Êðwè·éÌÉg¤?B

	public int ip4=0;//±êÍ?Ats1Ì?Å?É Ôµð·é©Ç¤©ðwè·é?B0ÈçµÈ¢?B1Èç Ô·?B

	public int ip5=-1;	//?ãº\?E?lªêU?Üè?ôÝÂ\ÈÌ?dÈèð¦µ½ ÆÅ?A
			//³çÉÊÌÌ?dÈèð³ª·Ì?Å?Ìjs.susumu(Smensuu)ÌÊ?B
			//0Èç?V½Ésusumu]nªÈ©Á½?B0ÈOÈçÏ»µ½SmenÌidÌ?Åà?¬³¢Ô?

	public int ip6=-1;	//?ãº\?E?lªêU?Üè?ôÝÂ\ÈÌ?dÈèð¦µ½ ÆÅ?A
			//³çÉÊÌÌ?dÈèð³ª·Ì js.kanou_kasanari_sagasi()ÌÊ?B
			//0ÈçÂ\È?dÈè©½ÆÈé?óÔÍ¶?ÝµÈ¢?B
                         //1000ÈçÊÌ?dÈèûª©Â©Á½?B                           

	public int betu_sagasi_flg=0;     //±êÍ?uÊÌ?dÈèðT·?v±ÆªLøÌ?ê?ÍP?A³øÌ?ê?ÍOðÆé?B
	public int hakkenn_sita_kazu=0;    //?Üè?dÈèûÅ?A½Êè­©µ½©ði[·é?B


	//public int i_AS_matome =100;//?Ü?ôÝ?èÌÊððÜÆßÄ?o·Â?//20171217 ver3.030ÅÍgíêÄ¢È¢?B


	public int toukazu_toukado=16;//§ß?}ðJ?[`æ·é?ÛÌ§ßx


	public int i_oriagari_sousa_mode=1;//1=Ï`Í?jà?}ÉÈè?AÏ`ãÉ?ãº\ð?ÄvZ·é?A©çÌ?[h?A2=Ï`à?Üè?ãªè?}ÌÜÜÅ?Aî{IÉÏ`ãÉ?ãº\Í?ÄvZµÈ¢?[h
















	//public Keijiban keijiban =new Keijiban(this);
	public Keijiban keijiban;



	public boolean w_image_jikkoutyuu = false;//?Ü?ôÝÜÆßÀ?sÌ?BPêñÌC??[W?«?oµªÀ?sÈçtureÉÈé?B
	public boolean matome_write_image_jikkoutyuu = false;//matome_write_imageªÀ?sÈçtureÉÈé?B±êÍ?A¡?Ì?Üè ªè`Ì\ªÌ?«?oµª©·êÈ¢æ¤Ég¤?B20170613

	String fname_and_number;//ÜÆß?«?oµÉg¤?B





	//eíÏ?Ìè`
	String c=new String();                //¶ñ??pÌNXÌCX^X»
	public String text_kekka=new String();                //Ê\¦p¶ñÌNXÌCX^X» 




	int i_fold_type=0;//=0ÍÊ?íÌWJ?}ÌS?Ü?üðÎ?ÛÆµ½?Üè?ôÝ?è?A=1Íselect³ê½?Ü?üðÎ?ÛÆµ½?Üè?ôÝ?è?A	

	
	public int i_toukazu_color=0;//§ß?}ðJ?[É·éÈçP?AµÈ¢ÈçO


*/
// **************************************************
//RXgN^

    public Oriagari_Zu_01(ap ap0) {
        super(ap0);

    }


/*
	public Oriagari_Zu_01(ap ap0){ 
super("default");
		orihime_ap=ap0; 

		js      = new Jyougehyou_Syokunin(ap0);
		keijiban =new Keijiban(ap0);

		//J?Ì?Ýè ------------------------------------------------------------------
		oriagari_camera_syokika();
		//J?Ì?ÝèÍ±±ÜÅ----------------------------------------------------

text_kekka="";

	}
*/
    //----------------------------------------------------------


}