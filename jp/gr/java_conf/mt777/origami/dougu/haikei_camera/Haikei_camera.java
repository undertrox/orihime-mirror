package jp.gr.java_conf.mt777.origami.dougu.haikei_camera;


import jp.gr.java_conf.mt777.origami.dougu.camera.Camera;
import jp.gr.java_conf.mt777.zukei2d.oritacalc.OritaCalc;
import jp.gr.java_conf.mt777.zukei2d.ten.Ten;

public class Haikei_camera {//実?ﾛの?ﾀ標と?A表示?ﾀ標の仲立ち

	//背景画を?A画像の?ｶ?繧ﾍしを?Aウィンドウの(0,0)に?���椹て回転や拡大なしで表示した???�を�????�態とする?B
//背景画?繧ﾌ点h1を中?Sとしてa倍拡大する?B次に?Ah1を展開?}?繧ﾌ点h3と?dなるように背景画を平?s移動する?Bこの?�態の展開?}を?Ah3を中?Sにb度回転したよう見えるように?ﾀ標を回転させて貼り付けて?Aその後?A?ﾀ標の回転を元に戻すという関???B
//引?狽ﾍ?AGraphics2D g2h,Image imgh,Ten h1,Ten h2,Ten h3,Ten h4
//h2,とh4も?dなるようにする
	OritaCalc oc = new OritaCalc();
	Ten h1 = new Ten();
	Ten h2 = new Ten();
	Ten h3 = new Ten();
	Ten h4 = new Ten();

	Ten h3_obj = new Ten();
	Ten h4_obj = new Ten();

	double haikei_haba;
	double haikei_takasa;

	Camera camera = new Camera();
//		Ten p =new Ten();p.set(camera.TV2object(p0)) ;

	double p_bairitu = 1.0;
	double p_idou_x = 0.0;
	double p_idou_y = 0.0;
	double p_kaiten_kakudo = 0.0;
	double p_kaiten_x = 0.0;
	double p_kaiten_y = 0.0;

	int i_Lock_on = 0;

	//int camera_id;//cameraの識別用?B名前の変わりに使うだけ

	public Haikei_camera() {//コンストラクタ
		reset();
	}


	public void reset() {
		set_h1(new Ten(0.0, 0.0));
		set_h2(new Ten(1.0, 1.0));
		set_h3(new Ten(120.0, 120.0));
		set_h4(new Ten(121.0, 121.0));

		parameter_keisan();

	}


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


	public Ten get_kijyun_jyoutai_iti(Ten pt) {
		Ten pt1 = new Ten();
		Ten pt2 = new Ten();
		Ten pt3 = new Ten();

		pt1.set(oc.ten_kaiten(new Ten(p_kaiten_x, p_kaiten_y), pt, -get_kakudo()));
		pt2.set(pt1.getx() - p_idou_x, pt1.gety() - p_idou_y);
		pt3.set(pt2.getx() / p_bairitu, pt2.gety() / p_bairitu);

		return pt3;
	}


	//public void set_h1(Ten ht){h1.set(ht);}
//public void set_h2(Ten ht){h2.set(ht);}
	public void set_h1(Ten ht) {
		h1.set(get_kijyun_jyoutai_iti(ht));
	}

	public void set_h2(Ten ht) {
		h2.set(get_kijyun_jyoutai_iti(ht));
	}

	public void set_h3(Ten ht) {
		h3.set(ht);
	}

	public void set_h4(Ten ht) {
		h4.set(ht);
	}

	public void set_h3_obj(Ten ht) {
		h3_obj.set(ht);
	}

	public void set_h4_obj(Ten ht) {
		h4_obj.set(ht);
	}

	public Ten get_h1() {
		return h1;
	}

	public Ten get_h2() {
		return h2;
	}

	public Ten get_h3() {
		return h3;
	}

	public Ten get_h4() {
		return h4;
	}

	public Ten get_h3_obj() {
		return h3_obj;
	}

	public Ten get_h4_obj() {
		return h4_obj;
	}

	public void parameter_keisan() {
		p_bairitu = h3.kyori(h4) / h1.kyori(h2);
		p_idou_x = (1.0 - p_bairitu) * h1.getx() + h3.getx() - h1.getx();
		p_idou_y = (1.0 - p_bairitu) * h1.gety() + h3.gety() - h1.gety();
		p_kaiten_kakudo = oc.kakudo(h1, h2, h3, h4);
		p_kaiten_x = h3.getx();
		p_kaiten_y = h3.gety();

		oc.hyouji("Haikei_camera--------------------parameter_keisan()");
		h1.hyouji(" h1  ");
		h2.hyouji(" h2  ");
		h3.hyouji(" h3  ");
		h4.hyouji(" h4  ");


	}


	public void set_haikei_haba(double d0) {
		haikei_haba = d0;
	}

	public void set_haikei_takasa(double d0) {
		haikei_takasa = d0;
	}

//?@g.drawImage(BufferedImage型変?薄ｼ,横位置,?c位置,表示??,表示?ｂｳ,this);
//  g.drawImage(image, x0,y0,x1,y1,this);


	public int get_x0() {
		return (int) ((1.0 - p_bairitu) * h1.getx() + h3.getx() - h1.getx());
	}

	public int get_y0() {
		return (int) ((1.0 - p_bairitu) * h1.gety() + h3.gety() - h1.gety());
	}

	public int get_x1() {
		return (int) (haikei_haba * p_bairitu);
	}

	public int get_y1() {
		return (int) (haikei_takasa * p_bairitu);
	}

//public double get_bai(){return h3.kyori(h4)/h1.kyori(h2);}

	public double get_kakudo() {
		return p_kaiten_kakudo;
	}

	public int get_cx() {
		return (int) p_kaiten_x;
	}

	public int get_cy() {
		return (int) p_kaiten_y;
	}


	public void set_i_Lock_on(int i_L) {
		i_Lock_on = i_L;
	}

	public void h3_obj_and_h4_obj_keisan() {
		h3_obj.set(camera.TV2object(h3));
		h4_obj.set(camera.TV2object(h4));
	}

	public void h3_and_h4_keisan() {
		h3.set(camera.object2TV(h3_obj));
		h4.set(camera.object2TV(h4_obj));
	}

}


  

