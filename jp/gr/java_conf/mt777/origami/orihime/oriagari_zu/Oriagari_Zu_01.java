package jp.gr.java_conf.mt777.origami.orihime.oriagari_zu;

//import java.awt.MouseInfo;
//import java.awt.PointerInfo;

import jp.gr.java_conf.mt777.origami.orihime.ap;


// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
//public class Oriagari_Zu_01 {
public class Oriagari_Zu_01 extends Oriagari_Zu {//Oriagari_Zu����{�ƂȂ�?�?オ��\���A���S���Y��
/*
	ap orihime_ap;

	OritaCalc oc =new OritaCalc(); 
	Moji_sousa ms =new Moji_sousa(); //������?�p�̊�?���?W�߂��N���X

	double r=3.0;                   //��{�}?\���̒�?��̗��[�̉~�̔��a?A�}�Ɗe��|�C���g�̋߂��̔����?�


	public double d_oriagarizu_syukusyaku_keisuu=1.0;//?܂�?オ��?}��?k�ڌW?�
	public double d_oriagarizu_kaiten_hosei=0.0;//?܂�?オ��?}�̉�]�\���p�x�̕�?��p�x

	public Kihonshi_Syokunin ks2       = new Kihonshi_Syokunin(r);    //��{�}?E?l?Bts2�̎?�_?W?���ts3�ɓn���O��?A
                                                             //ts2�̎?�_?W?��͖_��?d�Ȃ��Ă����肷�邩������Ȃ��̂�?A
                                                             //��������ks2�ɓn����?���?W?��Ƃ���?��?����?B

	public Tenkaizu_Syokunin ts1       = new Tenkaizu_Syokunin(r);    //�W�J?}?E?l?B���͂��ꂽ?���?W?���?�?���?܂���?j��?�̓_?W?���?܂�?オ��?}��?��
	public Tenkaizu_Syokunin ts2       = new Tenkaizu_Syokunin(r);    //�W�J?}?E?l?Bts1��?����?j��?�̓_?W?���?܂�?オ��?}��ێ?��?A?���?W?��ɂ���Ȃǂ̓���������?B  
	public Tenkaizu_Syokunin ts3       = new Tenkaizu_Syokunin(r);    //�W�J?}?E?l?Bts1��?����?j��?�̓_?W?���?��?��?B?V���ɖʂ�F������Ȃǂ̓������?��?B  

	public Jyougehyou_Syokunin js     ;
	//public Jyougehyou_Syokunin js      = new Jyougehyou_Syokunin();
	//public Jyougehyou_Syokunin(ap ap0){ orihime_ap=ap0;    reset();	}    //�R���X�g���N�^

        public Camera camera_of_oriagarizu	= new Camera();
        public Camera camera_of_oriagari_omote	= new Camera();
        public Camera camera_of_oriagari_ura	= new Camera();
        public Camera camera_of_touka_omote	= new Camera();
        public Camera camera_of_touka_ura	= new Camera();

	public Color oriagarizu_F_color=new Color(255,255,50);//?܂�?オ��?}�̕\�ʂ�?F
	public Color oriagarizu_B_color=new Color(233,233,233);//?܂�?オ��?}�̗��ʂ�?F
	public Color oriagarizu_L_color=Color.black;//?܂�?オ��?}��?���?F

	public  int hyouji_flg_backup=4;//�\���l��hyouji_flg�̈ꎞ�I�o�b�N�A�b�v�p
 		//int hyouji_flg_backup=4;//�\���l��hyouji_flg�̈ꎞ�I�o�b�N�A�b�v�p
	public int hyouji_flg=0;//?܂�?オ��?}�̕\���l���̎w��?B1�Ȃ�W�J?}?��??A2�Ȃ�?j��?}?B3�Ȃ瓧��?}?B4�Ȃ��?ۂ�?܂莆��?܂���?�?��Ɠ���?B
	public int i_suitei_meirei=0;//?܂�?��?�����ǂ̒i�K�܂�?s�����̎w��
	public int i_suitei_dankai=0;//?܂�?��?��肪�ǂ̒i�K�܂łł������̕\��
	//public int i_suitei_jissi_umu=0;//int i_suitei_jissi_umu��?A?܂�?��?���̌v�Z�����{�������ǂ�����\��?Bint i_suitei_jissi_umu=0�Ȃ���{���Ȃ�?B1�Ȃ���{����?B


	//�\���p�̒l���i�[�����?�
	public int ip1=-1;//?㉺�\?E?l��?���?ݒ莞��?A?܂�����̕\���������ʂ�
		//��?ڂ���Ƃ�����?������ꂪ0��?A�������1000���i�[�����?�?B
		//�����ł�?����l��(0��1000)�ȊO��?��Ȃ�Ȃ�ł�����?B	
	public int ip2=-1;//?㉺�\?E?l��?܂�?�݉\��?d�Ȃ����T����?ۂ�?A
		//�\��?d�Ȃ�����Ȃ����0��?A�\��?d�Ȃ���������1000���i�[�����?�?B
		//�����ł�?����l��(0��1000)�ȊO��?��Ȃ�Ȃ�ł�����?B	
	//int ip3a=1;
	public int ip3=1;//ts1��?܂�?�݂�?s��?ۂ̊�?��ʂ��w�肷��̂Ɏg��?B

	public int ip4=0;//�����?Ats1��?�?��ɗ��Ԃ������邩�ǂ������w�肷��?B0�Ȃ炵�Ȃ�?B1�Ȃ痠�Ԃ�?B

	public int ip5=-1;	//?㉺�\?E?l����U?܂�?�݉\�Ȏ���?d�Ȃ�����������Ƃ�?A
			//����ɕʂ̎���?d�Ȃ������������?�?���js.susumu(Smensuu)�̌���?B
			//0�Ȃ�?V����susumu�]�n���Ȃ�����?B0�ȊO�Ȃ�ω�����Smen��id��?ł�?�������?�

	public int ip6=-1;	//?㉺�\?E?l����U?܂�?�݉\�Ȏ���?d�Ȃ�����������Ƃ�?A
			//����ɕʂ̎���?d�Ȃ������������ js.kanou_kasanari_sagasi()�̌���?B
			//0�Ȃ�\��?d�Ȃ肩���ƂȂ�?�Ԃ͑�?݂��Ȃ�?B
                         //1000�Ȃ�ʂ�?d�Ȃ������������?B                           

	public int betu_sagasi_flg=0;     //�����?u�ʂ�?d�Ȃ��T��?v���Ƃ��L����?�?��͂P?A������?�?��͂O���Ƃ�?B
	public int hakkenn_sita_kazu=0;    //?܂�?d�Ȃ����?A���ʂ蔭�����������i�[����?B


	//public int i_AS_matome =100;//?�?��?���̕ʉ����܂Ƃ߂�?o����?�//20171217 ver3.030�ł͎g���Ă��Ȃ�?B


	public int toukazu_toukado=16;//����?}���J��?[�`�悷��?ۂ̓��ߓx


	public int i_oriagari_sousa_mode=1;//1=�ό`����?j��?}�ɂȂ�?A�ό`���?㉺�\��?Čv�Z����?A��������̃�?[�h?A2=�ό`����?܂�?オ��?}�̂܂܂�?A��{�I�ɕό`���?㉺�\��?Čv�Z���Ȃ���?[�h
















	//public Keijiban keijiban =new Keijiban(this);
	public Keijiban keijiban;



	public boolean w_image_jikkoutyuu = false;//?�?�݂܂Ƃߎ�?s��?B�P���̃C�??[�W?���?o������?s���Ȃ�ture�ɂȂ�?B
	public boolean matome_write_image_jikkoutyuu = false;//matome_write_image����?s���Ȃ�ture�ɂȂ�?B�����?A��?���?܂肠����`�̗\����?���?o����������Ȃ��悤�Ɏg��?B20170613

	String fname_and_number;//�܂Ƃ�?���?o���Ɏg��?B





	//�e���?��̒�`
	String c=new String();                //������?��?�p�̃N���X�̃C���X�^���X��
	public String text_kekka=new String();                //���ʕ\���p������̃N���X�̃C���X�^���X�� 




	int i_fold_type=0;//=0�͒�?�̓W�J?}�̑S?�?����?ۂƂ���?܂�?��?���?A=1��select���ꂽ?�?����?ۂƂ���?܂�?��?���?A	

	
	public int i_toukazu_color=0;//����?}���J��?[�ɂ���Ȃ�P?A���Ȃ��Ȃ�O


*/
// **************************************************
//�R���X�g���N�^

    public Oriagari_Zu_01(ap ap0) {
        super(ap0);

    }


/*
	public Oriagari_Zu_01(ap ap0){ 
super("default");
		orihime_ap=ap0; 

		js      = new Jyougehyou_Syokunin(ap0);
		keijiban =new Keijiban(ap0);

		//�J�?����?ݒ� ------------------------------------------------------------------
		oriagari_camera_syokika();
		//�J�?����?ݒ�͂����܂�----------------------------------------------------

text_kekka="";

	}
*/
    //----------------------------------------------------------


}