package jp.gr.java_conf.mt777.origami.orihime.oriagari_zu;

//import java.awt.MouseInfo;
//import java.awt.PointerInfo;

import jp.gr.java_conf.mt777.origami.orihime.ap;


// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
//public class Oriagari_Zu_01 {
public class Oriagari_Zu_01 extends Oriagari_Zu {//Oriagari_Zu‚ªŠî–{‚Æ‚È‚é?Ü?ã‚ª‚è—\‘ªƒAƒ‹ƒSƒŠƒYƒ€
/*
	ap orihime_ap;

	OritaCalc oc =new OritaCalc(); 
	Moji_sousa ms =new Moji_sousa(); //•¶Žš—ñ‘€?ì—p‚ÌŠÖ?”‚ð?W‚ß‚½ƒNƒ‰ƒX

	double r=3.0;                   //Šî–{Ž}?\‘¢‚Ì’¼?ü‚Ì—¼’[‚Ì‰~‚Ì”¼Œa?AŽ}‚ÆŠeŽíƒ|ƒCƒ“ƒg‚Ì‹ß‚³‚Ì”»’èŠî?€


	public double d_oriagarizu_syukusyaku_keisuu=1.0;//?Ü‚è?ã‚ª‚è?}‚Ì?kŽÚŒW?”
	public double d_oriagarizu_kaiten_hosei=0.0;//?Ü‚è?ã‚ª‚è?}‚Ì‰ñ“]•\Ž¦Šp“x‚Ì•â?³Šp“x

	public Kihonshi_Syokunin ks2       = new Kihonshi_Syokunin(r);    //Šî–{Ž}?E?l?Bts2‚ÌŽ?‚Â“_?W?‡‚ðts3‚É“n‚·‘O‚É?A
                                                             //ts2‚ÌŽ?‚Â“_?W?‡‚Í–_‚ª?d‚È‚Á‚Ä‚¢‚½‚è‚·‚é‚©‚à‚µ‚ê‚È‚¢‚Ì‚Å?A
                                                             //‚¢‚Á‚½‚ñks2‚É“n‚µ‚Ä?ü•ª?W?‡‚Æ‚µ‚Ä?®—?‚·‚é?B

	public Tenkaizu_Syokunin ts1       = new Tenkaizu_Syokunin(r);    //“WŠJ?}?E?l?B“ü—Í‚³‚ê‚½?ü•ª?W?‡‚ð?Å?‰‚É?Ü‚Á‚Ä?j‹à?ó‚Ì“_?W?‡‚Ì?Ü‚è?ã‚ª‚è?}‚ð?ì‚é
	public Tenkaizu_Syokunin ts2       = new Tenkaizu_Syokunin(r);    //“WŠJ?}?E?l?Bts1‚Ì?ì‚Á‚½?j‹à?ó‚Ì“_?W?‡‚Ì?Ü‚è?ã‚ª‚è?}‚ð•ÛŽ?‚µ?A?ü•ª?W?‡‚É‚·‚é‚È‚Ç‚Ì“­‚«‚ð‚·‚é?B  
	public Tenkaizu_Syokunin ts3       = new Tenkaizu_Syokunin(r);    //“WŠJ?}?E?l?Bts1‚Ì?ì‚Á‚½?j‹à?ó‚Ì“_?W?‡‚ð?®—?‚µ?B?V‚½‚É–Ê‚ð”FŽ¯‚·‚é‚È‚Ç‚Ì“­‚«‚ðŽ?‚Â?B  

	public Jyougehyou_Syokunin js     ;
	//public Jyougehyou_Syokunin js      = new Jyougehyou_Syokunin();
	//public Jyougehyou_Syokunin(ap ap0){ orihime_ap=ap0;    reset();	}    //ƒRƒ“ƒXƒgƒ‰ƒNƒ^

        public Camera camera_of_oriagarizu	= new Camera();
        public Camera camera_of_oriagari_omote	= new Camera();
        public Camera camera_of_oriagari_ura	= new Camera();
        public Camera camera_of_touka_omote	= new Camera();
        public Camera camera_of_touka_ura	= new Camera();

	public Color oriagarizu_F_color=new Color(255,255,50);//?Ü‚è?ã‚ª‚è?}‚Ì•\–Ê‚Ì?F
	public Color oriagarizu_B_color=new Color(233,233,233);//?Ü‚è?ã‚ª‚è?}‚Ì— –Ê‚Ì?F
	public Color oriagarizu_L_color=Color.black;//?Ü‚è?ã‚ª‚è?}‚Ì?ü‚Ì?F

	public  int hyouji_flg_backup=4;//•\Ž¦—lŽ®hyouji_flg‚ÌˆêŽž“IƒoƒbƒNƒAƒbƒv—p
 		//int hyouji_flg_backup=4;//•\Ž¦—lŽ®hyouji_flg‚ÌˆêŽž“IƒoƒbƒNƒAƒbƒv—p
	public int hyouji_flg=0;//?Ü‚è?ã‚ª‚è?}‚Ì•\Ž¦—lŽ®‚ÌŽw’è?B1‚È‚ç“WŠJ?}?®—??A2‚È‚ç?j‹à?}?B3‚È‚ç“§‰ß?}?B4‚È‚çŽÀ?Û‚É?Ü‚èŽ†‚ð?Ü‚Á‚½?ê?‡‚Æ“¯‚¶?B
	public int i_suitei_meirei=0;//?Ü‚è?ô‚Ý?„’è‚ð‚Ç‚Ì’iŠK‚Ü‚Å?s‚¤‚©‚ÌŽwŽ¦
	public int i_suitei_dankai=0;//?Ü‚è?ô‚Ý?„’è‚ª‚Ç‚Ì’iŠK‚Ü‚Å‚Å‚«‚½‚©‚Ì•\Ž¦
	//public int i_suitei_jissi_umu=0;//int i_suitei_jissi_umu‚Í?A?Ü‚è?ô‚Ý?„’è‚ÌŒvŽZ‚ðŽÀŽ{‚µ‚½‚©‚Ç‚¤‚©‚ð•\‚·?Bint i_suitei_jissi_umu=0‚È‚çŽÀŽ{‚µ‚È‚¢?B1‚È‚çŽÀŽ{‚µ‚½?B


	//•\Ž¦—p‚Ì’l‚ðŠi”[‚·‚é•Ï?”
	public int ip1=-1;//?ã‰º•\?E?l‚Ì?‰Šú?Ý’èŽž‚É?A?Ü‚Á‚½Œã‚Ì•\— ‚ª“¯‚¶–Ê‚ª
		//—×?Ú‚·‚é‚Æ‚¢‚¤Œë?·‚ª‚ ‚ê‚ª0‚ð?A–³‚¯‚ê‚Î1000‚ðŠi”[‚·‚é•Ï?”?B
		//‚±‚±‚Å‚Ì?‰Šú’l‚Í(0‚©1000)ˆÈŠO‚Ì?”‚È‚ç‚È‚ñ‚Å‚à‚¢‚¢?B	
	public int ip2=-1;//?ã‰º•\?E?l‚ª?Ü‚è?ô‚Ý‰Â”\‚È?d‚È‚è•û‚ð’T‚µ‚½?Û‚É?A
		//‰Â”\‚È?d‚È‚è•û‚ª‚È‚¯‚ê‚Î0‚ð?A‰Â”\‚È?d‚È‚è•û‚ª‚ ‚ê‚Î1000‚ðŠi”[‚·‚é•Ï?”?B
		//‚±‚±‚Å‚Ì?‰Šú’l‚Í(0‚©1000)ˆÈŠO‚Ì?”‚È‚ç‚È‚ñ‚Å‚à‚¢‚¢?B	
	//int ip3a=1;
	public int ip3=1;//ts1‚ª?Ü‚è?ô‚Ý‚ð?s‚¤?Û‚ÌŠî?€–Ê‚ðŽw’è‚·‚é‚Ì‚ÉŽg‚¤?B

	public int ip4=0;//‚±‚ê‚Í?Ats1‚Ì?Å?‰‚É— •Ô‚µ‚ð‚·‚é‚©‚Ç‚¤‚©‚ðŽw’è‚·‚é?B0‚È‚ç‚µ‚È‚¢?B1‚È‚ç— •Ô‚·?B

	public int ip5=-1;	//?ã‰º•\?E?l‚ªˆê’U?Ü‚è?ô‚Ý‰Â”\‚ÈŽ†‚Ì?d‚È‚è‚ðŽ¦‚µ‚½‚ ‚Æ‚Å?A
			//‚³‚ç‚É•Ê‚ÌŽ†‚Ì?d‚È‚è‚ð‚³‚ª‚·Žž‚Ì?Å?‰‚Ìjs.susumu(Smensuu)‚ÌŒ‹‰Ê?B
			//0‚È‚ç?V‚½‚Ésusumu—]’n‚ª‚È‚©‚Á‚½?B0ˆÈŠO‚È‚ç•Ï‰»‚µ‚½Smen‚Ìid‚Ì?Å‚à?¬‚³‚¢”Ô?†

	public int ip6=-1;	//?ã‰º•\?E?l‚ªˆê’U?Ü‚è?ô‚Ý‰Â”\‚ÈŽ†‚Ì?d‚È‚è‚ðŽ¦‚µ‚½‚ ‚Æ‚Å?A
			//‚³‚ç‚É•Ê‚ÌŽ†‚Ì?d‚È‚è‚ð‚³‚ª‚·Žž‚Ì js.kanou_kasanari_sagasi()‚ÌŒ‹‰Ê?B
			//0‚È‚ç‰Â”\‚È?d‚È‚è‚©‚½‚Æ‚È‚é?ó‘Ô‚Í‘¶?Ý‚µ‚È‚¢?B
                         //1000‚È‚ç•Ê‚Ì?d‚È‚è•û‚ªŒ©‚Â‚©‚Á‚½?B                           

	public int betu_sagasi_flg=0;     //‚±‚ê‚Í?u•Ê‚Ì?d‚È‚è‚ð’T‚·?v‚±‚Æ‚ª—LŒø‚Ì?ê?‡‚Í‚P?A–³Œø‚Ì?ê?‡‚Í‚O‚ð‚Æ‚é?B
	public int hakkenn_sita_kazu=0;    //?Ü‚è?d‚È‚è•û‚Å?A‰½’Ê‚è”­Œ©‚µ‚½‚©‚ðŠi”[‚·‚é?B


	//public int i_AS_matome =100;//?Ü?ô‚Ý?„’è‚Ì•Ê‰ð‚ð‚Ü‚Æ‚ß‚Ä?o‚·ŒÂ?”//20171217 ver3.030‚Å‚ÍŽg‚í‚ê‚Ä‚¢‚È‚¢?B


	public int toukazu_toukado=16;//“§‰ß?}‚ðƒJƒ‰?[•`‰æ‚·‚é?Û‚Ì“§‰ß“x


	public int i_oriagari_sousa_mode=1;//1=•ÏŒ`Žž‚Í?j‹à?}‚É‚È‚è?A•ÏŒ`Œã‚É?ã‰º•\‚ð?ÄŒvŽZ‚·‚é?A‹Œ—ˆ‚©‚ç‚Ìƒ‚?[ƒh?A2=•ÏŒ`Žž‚à?Ü‚è?ã‚ª‚è?}‚Ì‚Ü‚Ü‚Å?AŠî–{“I‚É•ÏŒ`Œã‚É?ã‰º•\‚Í?ÄŒvŽZ‚µ‚È‚¢ƒ‚?[ƒh
















	//public Keijiban keijiban =new Keijiban(this);
	public Keijiban keijiban;



	public boolean w_image_jikkoutyuu = false;//?Ü?ô‚Ý‚Ü‚Æ‚ßŽÀ?s‚Ì?B’Pˆê‰ñ‚ÌƒCƒ??[ƒW?‘‚«?o‚µ‚ªŽÀ?s’†‚È‚çture‚É‚È‚é?B
	public boolean matome_write_image_jikkoutyuu = false;//matome_write_image‚ªŽÀ?s’†‚È‚çture‚É‚È‚é?B‚±‚ê‚Í?A•¡?”‚Ì?Ü‚è‚ ‚ª‚èŒ`‚Ì—\‘ª‚Ì?‘‚«?o‚µ‚ª‚©‚·‚ê‚È‚¢‚æ‚¤‚ÉŽg‚¤?B20170613

	String fname_and_number;//‚Ü‚Æ‚ß?‘‚«?o‚µ‚ÉŽg‚¤?B





	//ŠeŽí•Ï?”‚Ì’è‹`
	String c=new String();                //•¶Žš—ñ?ˆ—?—p‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰»
	public String text_kekka=new String();                //Œ‹‰Ê•\Ž¦—p•¶Žš—ñ‚ÌƒNƒ‰ƒX‚ÌƒCƒ“ƒXƒ^ƒ“ƒX‰» 




	int i_fold_type=0;//=0‚Í’Ê?í‚Ì“WŠJ?}‚Ì‘S?Ü?ü‚ð‘Î?Û‚Æ‚µ‚½?Ü‚è?ô‚Ý?„’è?A=1‚Íselect‚³‚ê‚½?Ü?ü‚ð‘Î?Û‚Æ‚µ‚½?Ü‚è?ô‚Ý?„’è?A	

	
	public int i_toukazu_color=0;//“§‰ß?}‚ðƒJƒ‰?[‚É‚·‚é‚È‚ç‚P?A‚µ‚È‚¢‚È‚ç‚O


*/
// **************************************************
//ƒRƒ“ƒXƒgƒ‰ƒNƒ^

    public Oriagari_Zu_01(ap ap0) {
        super(ap0);

    }


/*
	public Oriagari_Zu_01(ap ap0){ 
super("default");
		orihime_ap=ap0; 

		js      = new Jyougehyou_Syokunin(ap0);
		keijiban =new Keijiban(ap0);

		//ƒJƒ?ƒ‰‚Ì?Ý’è ------------------------------------------------------------------
		oriagari_camera_syokika();
		//ƒJƒ?ƒ‰‚Ì?Ý’è‚Í‚±‚±‚Ü‚Å----------------------------------------------------

text_kekka="";

	}
*/
    //----------------------------------------------------------


}