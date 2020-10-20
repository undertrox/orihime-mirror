package jp.gr.java_conf.mt777.origami.orihime.kihonshi_syokunin;

import jp.gr.java_conf.mt777.kiroku.memo.Memo;
import jp.gr.java_conf.mt777.origami.dougu.camera.Camera;
import jp.gr.java_conf.mt777.origami.dougu.senbunsyuugou.Senbunsyuugou;
import jp.gr.java_conf.mt777.zukei2d.oritacalc.OritaCalc;
import jp.gr.java_conf.mt777.zukei2d.oritaoekaki.OritaOekaki;
import jp.gr.java_conf.mt777.zukei2d.senbun.Senbun;
import jp.gr.java_conf.mt777.zukei2d.takakukei.Takakukei;
import jp.gr.java_conf.mt777.zukei2d.ten.Ten;

import java.awt.*;

// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
public class Kihonshi_Syokunin {
    OritaCalc oc = new OritaCalc(); //各種計算用の関?狽gうためのクラスのインスタンス化
    double r = 3.0;                   //基本枝?\造の直??の両端の円の半径?A枝と各種ポイントの近さの判定基??
    int icol;//??分の?F
    int taisyousei;

    Ten pa = new Ten(); //マウスボタンが押された位置からa点までのベクトル
    Ten pb = new Ten(); //マウスボタンが押された位置からb点までのベクトル

    int ugokasi_mode = 0;    //枝を動かす動??モ?[ド?B0=なにもしない?A1=a点を動かす?A2=b点を動かす?A3=枝を平?s移動 ?A4=?V規追加
    int ieda;              //アクティブな枝の番??

    int i_saigo_no_senbun_no_maru_kaku = 1;    //1描く?A0描かない

    Senbunsyuugou k = new Senbunsyuugou();    //基本枝?\造のインスタンス化
    // Senbunsyuugou k ;    //基本枝?\造
    Takakukei gomibako = new Takakukei(4);    //ゴミ箱のインスタンス化
    Takakukei tyuuoutai = new Takakukei(4);    //中央帯のインスタンス化
    double tyuuoutai_xmin = 180.0;
    double tyuuoutai_xmax = 206.0;
    double tyuuoutai_ymin = 50.0;
    double tyuuoutai_ymax = 300.0;

    double kijyun_kakudo = 22.5; //<<<<<<<<<<<<<<<<<<<<<<<基??角度<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    //入力方法用のパラ???[タ
    int nyuuryoku_houhou = 0;
    int nyuuryoku_kitei = 0;
    int kensa_houhou = 0;
    int nhi = 0;

    Ten nhTen = new Ten();
    Ten nhTen1 = new Ten();

    int kousi_haba = 24;  //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<格子??
    int i_kousi_x_min = -1000;
    int i_kousi_x_max = 2000;
    int i_kousi_y_min = -1000;
    int i_kousi_y_max = 1000;
    Camera camera = new Camera();

    //---------------------------------
    // Kihonshi_Syokunin(  Senbunsyuugou k0,double r0 ){  //コンストラクタ
    public Kihonshi_Syokunin(double r0) {  //コンストラクタ
        r = r0;
        ugokasi_mode = 0;
        ieda = 0;
        icol = 0;
        gomibako.set(new Ten(10.0, 150.0), 1, new Ten(0.0, 0.0));
        gomibako.set(new Ten(10.0, 150.0), 2, new Ten(50.0, 0.0));
        gomibako.set(new Ten(10.0, 150.0), 3, new Ten(40.0, 50.0));
        gomibako.set(new Ten(10.0, 150.0), 4, new Ten(10.0, 50.0));

        tyuuoutai.set(1, new Ten(tyuuoutai_xmin, tyuuoutai_ymin));
        tyuuoutai.set(2, new Ten(tyuuoutai_xmax, tyuuoutai_ymin));
        tyuuoutai.set(3, new Ten(tyuuoutai_xmax, tyuuoutai_ymax));
        tyuuoutai.set(4, new Ten(tyuuoutai_xmin, tyuuoutai_ymax));

        taisyousei = 0;
    }


    //---------------------------------
    public void reset() {
        r = 2.0;
        k.reset();
        ugokasi_mode = 0;
        ieda = 0;
        icol = 0;
        taisyousei = 0;

        camera.reset();
    }

    //-----------------------------
    public void setMemo(Memo memo1) {
        k.setMemo(memo1);
    }

    //-----------------------------
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

    //-----------------------------
    public void zen_yama_tani_henkan() {
        k.zen_yama_tani_henkan();
    }

    //----------------
    public void eda_kesi(double r) {
        k.eda_kesi(r);
    }

    //--------------------------------------------
    public void set(Senbunsyuugou ss) {
        k.set(ss);
    }

    //----------------------------------------------
    public Senbunsyuugou get() {
        return k;
    }

    //--------------------------------------------
    public void set_r(double r0) {
        r = r0;
    }

    //--------------------------------------------
    public void set_nyuuryoku_houhou(int i) {
        nyuuryoku_houhou = i;
    }

    //--------------------------------------------
    public void set_nyuuryoku_kitei(int i) {
        nyuuryoku_kitei = i;
        if (nyuuryoku_kitei == 1) {
            kousi_haba = 48;
        }
        if (nyuuryoku_kitei == 2) {
            kousi_haba = 24;
        }
        if (nyuuryoku_kitei == 3) {
            kousi_haba = 48;
        }
    }

    //--------------------------------------------
    public void set_kensa_houhou(int i) {
        kensa_houhou = i;
    }

    //--------------------------------------------
    public int getsousuu() {
        return k.getsousuu();
    }


    //-----------------------------
    public void set_kijyun_kakudo(double x) {
        kijyun_kakudo = x;
    } //<<<<<<<<<<<<<<<<<<<<<<<基??角度<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    //------------------------
    public Memo getMemo() {
        return k.getMemo();
    }

    //対?ﾌ?ｫの指定
    public void settaisyousei(int i) {
        taisyousei = i;
    }

    public void setcolor(int i) {
        icol = i;
    }
    //


    //
   /*
      void 	k_kasseika(Ten t,double r){
       	//Ten p1=new Ten();

       if(nyuuryoku_kitei==1){
       //  p1.set(kitei_idou(p1));}
         t.set(kitei_idou(t));}
         k.kasseika( t,r);
     }

      //
     void k_set(Ten t){
       	Ten p1=new Ten();

       if(nyuuryoku_kitei==1){
         p1.set(kitei_idou(p1));}

         k.set( p1);
     }

      //--------------
      void   k_addsenbun(Ten t1,Ten t2){

	Ten p1=new Ten();
        Ten p2=new Ten();

	p1.set(t1);p2.set(t2);

        if(nyuuryoku_kitei==1){
         p1.set(kitei_idou(p1));
         p2.set(kitei_idou(p2));


	}

      k.addsenbun(p1,p2);
      }

    */

    //---------------------------------
    public int get_ieda() {
        return ieda;
    }


    //不要な??分を?ﾁ去する-----------------------------------------------
    public void gomisute() {

        for (int i = 1; i <= k.getsousuu(); i++) {
            int idel = 0;
            //if(gomibako.naibu(k.geta(i))>0){idel=1;}    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            //if(gomibako.kousa(k.get( i))){idel=1;}

            if (gomibako.totu_naibu(k.get(i)) == 1) {
                idel = 1;
            }


            if (idel == 1) {
                k.delsenbun(i);
                i = i - 1;
                ieda = k.getsousuu() + 1;    //<<<<<<<<<<<<<<<<<<
            }
        }
    }

    //枝を動かした後の????を?sう関??----------------------------------------------------
    public void eda_atosyori_01() {//枝の長さを変えずに?A枝全体を平?s移動して微調?ｮする?B
        //アクティブな帯の位置を微調?ｮする
        Ten ab = new Ten(1, k.getb(ieda), -1, k.geta(ieda));//アクティブな枝の?A点aから点bへ向かうベクトル
        Ten ba = new Ten(1, k.geta(ieda), -1, k.getb(ieda));//アクティブな枝の?A点aから点bへ向かうベクトル

        int jeda;   //アクティブな枝と近い別の枝
        int jbasyo; //アクティブな枝と近い別の枝のどこが近いのかを示すための番??

        //?@アクティブな枝のa点?@と?@別の枝?@との距離が?@ｒ?@より近い????

        jeda = k.senbun_sagasi(k.geta(ieda), 2 * r, ieda);//アクティブな枝のa点と近い別の枝を??める?B
        jbasyo = k.senbun_busyo_sagasi(jeda, k.geta(ieda), 2 * r);//別の枝のどの部?鰍ｪ近いかを??める?B
        if ((jeda != 0) && (jbasyo == 1)) { //アクティブな枝のa点と?A別の枝のa点が近い????
            k.seta(ieda, k.geta(jeda));
            k.setb(ieda, new Ten(1, k.geta(ieda), 1, ab));//こう?曹｢てもちゃんと動く様なので?Aこのまま使う?B
        }
        if ((jeda != 0) && (jbasyo == 2)) { //アクティブな枝のa点と?A別の枝のb点が近い????
            k.seta(ieda, k.getb(jeda));
            k.setb(ieda, new Ten(1, k.geta(ieda), 1, ab));
        }

        //?@アクティブな枝のb点?@と?@別の枝?@との距離が?@ｒ?@より近い????
        jeda = k.senbun_sagasi(k.getb(ieda), 2 * r, ieda);//アクティブな枝のb点と近い別の枝を??める?B
        jbasyo = k.senbun_busyo_sagasi(jeda, k.getb(ieda), 2 * r);//別の枝のどの部?鰍ｪ近いかを??める?B
        if ((jeda != 0) && (jbasyo == 1)) { //アクティブな枝のb点と?A別の枝のa点が近い????
            k.setb(ieda, k.geta(jeda));
            k.seta(ieda, new Ten(1, k.getb(ieda), 1, ba));
        }
        if ((jeda != 0) && (jbasyo == 2)) { //アクティブな枝のb点と?A別の枝のb点が近い????
            k.setb(ieda, k.getb(jeda));
            k.seta(ieda, new Ten(1, k.getb(ieda), 1, ba));
        }
    }


    //枝を動かした後の????を?sう関??----------------------------------------------------
    public void eda_atosyori_02() {//一端の点だけを移動して反対の端の点は動かさないで微調?ｮする?B
        //アクティブな帯の位置を微調?ｮする

        int jeda;   //アクティブな枝と近い別の枝
        int jbasyo; //アクティブな枝と近い別の枝のどこが近いのかを示すための番??
        if (k.getnagasa(ieda) >= r) {
            //?@アクティブな枝のa点?@と?@別の枝との距離が?@ｒ?@より近い????
            jeda = k.senbun_sagasi(k.geta(ieda), r, ieda);//アクティブな枝のa点と近い別の枝を??める?B
            jbasyo = k.senbun_busyo_sagasi(jeda, k.geta(ieda), r);//別の枝のどの部?鰍ｪ近いかを??める?B
            if ((jeda != 0) && (jbasyo == 1)) {
                k.seta(ieda, k.geta(jeda));
            }//アクティブな枝のa点と?A別の枝のa点が近い????
            if ((jeda != 0) && (jbasyo == 2)) {
                k.seta(ieda, k.getb(jeda));
            }//アクティブな枝のa点と?A別の枝のb点が近い????

            //?@アクティブな枝(ieda)のb点?@と?@別の枝(jeda)との距離が?@ｒ?@より近い????
            jeda = k.senbun_sagasi(k.getb(ieda), r, ieda);//アクティブな枝のb点と近い別の枝を??める?B
            jbasyo = k.senbun_busyo_sagasi(jeda, k.getb(ieda), r);//別の枝のどの部?鰍ｪ近いかを??める?B
            if ((jeda != 0) && (jbasyo == 1)) {
                k.setb(ieda, k.geta(jeda));
            }//アクティブな枝のb点と?A別の枝のa点が近い????
            if ((jeda != 0) && (jbasyo == 2)) {
                k.setb(ieda, k.getb(jeda));
            }//アクティブな枝のb点と?A別の枝のb点が近い????

            //以下は070317に追加 複?狽ﾌ??分が?Wまった頂点を別の頂点近くに??っていったときの後????用
//150312?@?@2*r?@を?@r?@に?C?ｳ


            //?@アクティブな枝のa点?@と?@別の枝との距離が?@ｒ?@より近い????
            jeda = k.senbun_sagasi(k.geta(ieda), r, -10);//アクティブなieda枝のa点と近い別の枝を??める?B
            jbasyo = k.senbun_busyo_sagasi(jeda, k.geta(ieda), r);//別の枝のどの部?鰍ｪ近いかを??める?B

            if ((jeda != 0) && (jbasyo == 1)) {
                k.kasseika(k.geta(jeda), r);
                k.set(k.geta(jeda));
            }//アクティブなieda枝のa点と?A別の枝のa点が近い????
            if ((jeda != 0) && (jbasyo == 2)) {
                k.kasseika(k.getb(jeda), r);
                k.set(k.getb(jeda));
            }//アクティブなieda枝のa点と?A別の枝のb点が近い????

            //?@アクティブな枝(ieda)のb点?@と?@別の枝(jeda)との距離が?@ｒ?@より近い????
            jeda = k.senbun_sagasi(k.getb(ieda), r, -10);//アクティブなieda枝のb点と近い別の枝を??める?B
            jbasyo = k.senbun_busyo_sagasi(jeda, k.getb(ieda), r);//別の枝のどの部?鰍ｪ近いかを??める?B

            if ((jeda != 0) && (jbasyo == 1)) {
                k.kasseika(k.geta(jeda), r);
                k.set(k.geta(jeda));
            }//アクティブなieda枝のb点と?A別の枝のa点が近い????
            if ((jeda != 0) && (jbasyo == 2)) {
                k.kasseika(k.getb(jeda), r);
                k.set(k.getb(jeda));
            }//アクティブなieda枝のb点と?A別の枝のb点が近い????
        }

    }

    public void bunkatu_seiri() {
        k.bunkatu_seiri();
    }

    public void bunkatu_seiri_for_Smen_hassei() {
        k.bunkatu_seiri_for_Smen_hassei();
    }//kとは??分?W?№ﾌこと?ASenbunsyuugou k =new Senbunsyuugou();

    public void kousabunkatu() {
        k.kousabunkatu();
    }

    public void ten_sakujyo() {
        k.ten_sakujyo();
    }

    public void ten_sakujyo(double r) {
        k.ten_sakujyo(r);
    }

    public void jyuufuku_senbun_sakujyo() {
        k.jyuufuku_senbun_sakujyo();
    }

    public void jyuufuku_senbun_sakujyo(double r) {
        k.jyuufuku_senbun_sakujyo(r);
    }


    //------------------------------------------------------------------------------
//基本枝の描画000000000000000000000000000000000000000000000000000000000000000000
//------------------------------------------------------------------------------
    public void oekaki(Graphics g, int iTenkaizuSenhaba) {
        String text = "";//文字列????用のクラスのインスタンス化
        double d;
        OritaOekaki OO = new OritaOekaki();

        if (kensa_houhou == 1) {//検?ｸ用
            int kr = 10;
            g.setColor(Color.red);
            for (int i = 1; i <= k.getsousuu(); i++) {
                if (oc.hitosii(k.geta(i), k.getb(i), r)) {
                    g.fillOval((int) k.getax(i) - kr, (int) k.getay(i) - kr, 2 * kr, 2 * kr); //円
                }
            }
            for (int i = 1; i <= k.getsousuu() - 1; i++) {
                for (int j = i + 1; j <= k.getsousuu(); j++) {
                    if (oc.senbun_kousa_hantei(k.get(i), k.get(j)) == 31) {
                        OO.habaLine(g, k.get(i), kr, 1);//  太??
                        g.fillOval((int) k.getax(i) - kr, (int) k.getay(i) - kr, 2 * kr, 2 * kr); //円
                        g.fillOval((int) k.getbx(i) - kr, (int) k.getby(i) - kr, 2 * kr, 2 * kr); //円
                    }
                }
            }
        }
        g.setColor(Color.black);

        //-------------------------------
        if (taisyousei > 0) {
            g.setColor(Color.green);
            tyuuoutai.oekaki(g);
            g.setColor(Color.black);
        }

        //  ごみ箱の描画
        g.setColor(new Color(150, 150, 150));
        //g.setColor(new Color(100,100,100));
        gomibako.oekaki(g);
        g.setColor(Color.black);
        g.drawString("ごみ箱", 18, 180);

        g.drawString("??分の???@" + k.getsousuu(), 30, 50);

        //描画
        Ten a = new Ten();
        Ten b = new Ten();
        int ir = (int) r;

        //入力規定が1?i格子?jの???№ﾌ格子??の描画
        if (nyuuryoku_kitei >= 1) {
            g.setColor(Color.gray);
            for (int i = 1; i <= 700 / kousi_haba; i++) {
                g.drawLine(0, kousi_haba * i, 1000, kousi_haba * i); //直??
            }
            for (int i = 1; i <= 1000 / kousi_haba; i++) {
                g.drawLine(kousi_haba * i, 0, kousi_haba * i, 700); //直??
            }
        }

        //対?ﾌ?ｫがある???№ﾌ????
        g.setColor(new Color(200, 200, 200));
        if (taisyousei > 0) {
            for (int i = 1; i <= k.getsousuu(); i++) {
                if ((k.geta(i).getx() < tyuuoutai_xmin)
                        ||
                        (k.getb(i).getx() < tyuuoutai_xmin)) {
                    a.set(k.geta(i));
                    b.set(k.getb(i));
                    a.set(tyuuoutai_xmin + tyuuoutai_xmax - a.getx(), a.gety());
                    b.set(tyuuoutai_xmin + tyuuoutai_xmax - b.getx(), b.gety());

                    g.drawLine((int) a.getx(), (int) a.gety(), (int) b.getx(), (int) b.gety()); //直??
                    g.drawOval((int) a.getx() - ir, (int) a.gety() - ir, 2 * ir, 2 * ir); //円
                    g.drawOval((int) b.getx() - ir, (int) b.gety() - ir, 2 * ir, 2 * ir); //円
                }
            }
        }
        g.setColor(Color.black);

        //対?ﾌ?ｫがあってもなくても?sう描画
        double L = 100.0;
        if (icol == -2) { //角度系用icol=-2
            g.setColor(new Color(245, 245, 245));
            for (int i = 1; i <= k.getsousuu(); i++) {
                a.set(k.geta(i));
                b.set(k.getb(i));
                d = 0.0;
                while (d < 360.0) {
                    g.drawLine((int) a.getx(), (int) a.gety(), (int) (a.getx() + L * Math.cos(d * 3.14159265 / 180.0)), (int) (a.gety() + L * Math.sin(d * 3.14159265 / 180.0))); //直??
                    g.drawLine((int) b.getx(), (int) b.gety(), (int) (b.getx() + L * Math.cos(d * 3.14159265 / 180.0)), (int) (b.gety() + L * Math.sin(d * 3.14159265 / 180.0))); //直??
                    d = d + kijyun_kakudo;
                }
            }

            if (ieda <= k.getsousuu()) {
                g.setColor(new Color(205, 245, 245));
                d = 0.0;
                a.set(k.geta(ieda));
                b.set(k.getb(ieda));
                if (ugokasi_mode == 1) {
                    while (d < 360.0) {
                        g.drawLine((int) a.getx(), (int) a.gety(), (int) (a.getx() + L * Math.cos(d * 3.14159265 / 180.0)), (int) (a.gety() + L * Math.sin(d * 3.14159265 / 180.0))); //直??
                        //g.drawLine( (int)b.getx(),(int)b.gety(),(int)(b.getx()+L*Math.cos(d*3.14159265/180.0)),(int)(b.gety()+L*Math.sin(d*3.14159265/180.0))); //直??
                        d = d + kijyun_kakudo;
                    }
                }
                if (ugokasi_mode == 2) {
                    while (d < 360.0) {
                        //g.drawLine( (int)a.getx(),(int)a.gety(),(int)(a.getx()+L*Math.cos(d*3.14159265/180.0)),(int)(a.gety()+L*Math.sin(d*3.14159265/180.0))); //直??
                        g.drawLine((int) b.getx(), (int) b.gety(), (int) (b.getx() + L * Math.cos(d * 3.14159265 / 180.0)), (int) (b.gety() + L * Math.sin(d * 3.14159265 / 180.0))); //直??
                        d = d + kijyun_kakudo;
                    }
                }

                if (ugokasi_mode == 3) {
                    while (d < 360.0) {
                        g.drawLine((int) a.getx(), (int) a.gety(), (int) (a.getx() + L * Math.cos(d * 3.14159265 / 180.0)), (int) (a.gety() + L * Math.sin(d * 3.14159265 / 180.0))); //直??
                        g.drawLine((int) b.getx(), (int) b.gety(), (int) (b.getx() + L * Math.cos(d * 3.14159265 / 180.0)), (int) (b.gety() + L * Math.sin(d * 3.14159265 / 180.0))); //直??
                        d = d + kijyun_kakudo;
                    }
                }

                if (ugokasi_mode == 4) {
                    while (d < 360.0) {
                        //g.drawLine( (int)a.getx(),(int)a.gety(),(int)(a.getx()+L*Math.cos(d*3.14159265/180.0)),(int)(a.gety()+L*Math.sin(d*3.14159265/180.0))); //直??
                        g.drawLine((int) b.getx(), (int) b.gety(), (int) (b.getx() + L * Math.cos(d * 3.14159265 / 180.0)), (int) (b.gety() + L * Math.sin(d * 3.14159265 / 180.0))); //直??
                        d = d + kijyun_kakudo;
                    }
                }
            }
        }

/*
      int itemp=0;
      for (int i=1; i<=k.getsousuu()-1; i++ ){
      for (int j=i+1; j<=k.getsousuu(); j++ ){
            if(oc.senbun_kousa_hantei(k.get(i),k.get(j))!=0) {
             g.drawString("交?ｷ点?@"+text.valueOf(oc.senbun_kousa_hantei(k.get(i),k.get(j)) ),30,150+10*itemp);
	     itemp++;
	    }

      }
      }
*/

        for (int i = 1; i <= k.getsousuu(); i++) {
            a.set(k.geta(i));
            b.set(k.getb(i));
            if (k.getcolor(i) == 0) {
                g.setColor(Color.black);
            }
            if (k.getcolor(i) == 1) {
                g.setColor(Color.red);
            }
            if (k.getcolor(i) == 2) {
                g.setColor(Color.blue);
            }
            if (icol == -1) {
            }
            if (icol == -2) {
                g.setColor(new Color(100, 200, 0));//竹?F
                if (oc.kakudozure(k.get(i), kijyun_kakudo) < 2.0) {
                    g.setColor(new Color(200, 100, 0));//おうど?F
                }
                if (oc.kakudozure(k.get(i), kijyun_kakudo) < 0.5) {
                    g.setColor(Color.black);
                }
            }
            g.drawLine((int) a.getx(), (int) a.gety(), (int) b.getx(), (int) b.gety()); //直??

            if (iTenkaizuSenhaba != 1) {
                OO.habaLine(g, k.get(i), iTenkaizuSenhaba, k.getcolor(i));
            }//  太??
            //  OO.habaLine( g,k.get(i),ir,k.getcolor(i));//  太??

            g.setColor(Color.white);
            g.fillOval((int) a.getx() - ir, (int) a.gety() - ir, 2 * ir, 2 * ir); //円
            g.fillOval((int) b.getx() - ir, (int) b.gety() - ir, 2 * ir, 2 * ir); //円

            g.setColor(Color.black);
            g.drawOval((int) a.getx() - ir, (int) a.gety() - ir, 2 * ir, 2 * ir); //円
            g.drawOval((int) b.getx() - ir, (int) b.gety() - ir, 2 * ir, 2 * ir); //円
        }
        g.setColor(Color.black);
    }


    //------------------------------------------------------------------------------
//基本枝の描画111111111111111111111111111111111111111111111111111111111111111111
//------------------------------------------------------------------------------
    public void oekaki_with_camera(Graphics g, int iTenkaizuSenhaba) {
        String text = "";//文字列????用のクラスのインスタンス化
        double d;
        OritaOekaki OO = new OritaOekaki();

        Senbun s_tv = new Senbun();
        Ten a = new Ten();
        Ten b = new Ten();
        int ir = (int) (r * camera.get_camera_bairitsu_x());

        //格子??の描画
        Senbun s_ob = new Senbun();
        //入力規定が1か2?i?ｳ方格子?jの???№ﾌ格子??の描画


        if ((nyuuryoku_kitei == 1) || (nyuuryoku_kitei == 2)) {
            g.setColor(Color.gray);
            for (int i = i_kousi_y_min / kousi_haba; i <= i_kousi_y_max / kousi_haba; i++) {
//				g.drawLine( 	i_kousi_x_min,	kousi_haba*i,	i_kousi_x_max,	kousi_haba*i); //直??
                s_ob.set(i_kousi_x_min, kousi_haba * i, i_kousi_x_max, kousi_haba * i);
                s_tv.set(camera.object2TV(s_ob));
                g.drawLine((int) s_tv.getax(), (int) s_tv.getay(), (int) s_tv.getbx(), (int) s_tv.getby()); //直??

            }
            for (int i = i_kousi_x_min / kousi_haba; i <= i_kousi_x_max / kousi_haba; i++) {
//				g.drawLine(	kousi_haba*i,	i_kousi_y_min,	kousi_haba*i,	i_kousi_y_max); //直??
                s_ob.set(kousi_haba * i, i_kousi_y_min, kousi_haba * i, i_kousi_y_max);
                s_tv.set(camera.object2TV(s_ob));
                g.drawLine((int) s_tv.getax(), (int) s_tv.getay(), (int) s_tv.getbx(), (int) s_tv.getby()); //直??

            }


            //格子点に丸を描く

            g.setColor(Color.gray);
            Ten t_ob = new Ten();
            Ten t_tv = new Ten();
            for (int i = i_kousi_x_min / kousi_haba; i <= i_kousi_x_max / kousi_haba; i++) {
                for (int j = i_kousi_y_min / kousi_haba; j <= i_kousi_y_max / kousi_haba; j++) {
                    t_ob.set(kousi_haba * i, kousi_haba * j);
                    t_tv.set(camera.object2TV(t_ob));
                    g.drawOval((int) t_tv.getx() - ir, (int) t_tv.gety() - ir, 2 * ir, 2 * ir); //円

                }
            }


        }

        //入力規定が1か3?i三角格子?jの???№ﾌ格子??の描画


        double sqr3 = 1.732051;
        double sankaku_kousi_takasa;
        sankaku_kousi_takasa = kousi_haba * sqr3 / 2.0;
        if (nyuuryoku_kitei == 3) {
            g.setColor(Color.gray);
            for (int i = -30; i <= 30; i++) {
//				g.drawLine( 	-3000,	sankaku_kousi_haba*i,	3000,	sankaku_kousi_haba*i); //直??
                s_ob.set(-3000, sankaku_kousi_takasa * i, 3000, sankaku_kousi_takasa * i);
                s_tv.set(camera.object2TV(s_ob));
                g.drawLine((int) s_tv.getax(), (int) s_tv.getay(), (int) s_tv.getbx(), (int) s_tv.getby()); //直??

            }

            //  y=sqr3*x + 2.0*sankaku_kousi_haba*i
            for (int i = -30; i <= 30; i++) {
                s_ob.set(-3000, -3000.0 * sqr3 + 2.0 * sankaku_kousi_takasa * i, 3000, 3000.0 * sqr3 + 2.0 * sankaku_kousi_takasa * i);
                s_tv.set(camera.object2TV(s_ob));
                g.drawLine((int) s_tv.getax(), (int) s_tv.getay(), (int) s_tv.getbx(), (int) s_tv.getby()); //直??
            }


            //  y=-sqr3*x + sankaku_kousi_haba*i
            for (int i = -30; i <= 30; i++) {
                s_ob.set(-3000, -3000.0 * (-sqr3) + 2.0 * sankaku_kousi_takasa * i, 3000, 3000.0 * (-sqr3) + 2.0 * sankaku_kousi_takasa * i);
                s_tv.set(camera.object2TV(s_ob));
                g.drawLine((int) s_tv.getax(), (int) s_tv.getay(), (int) s_tv.getbx(), (int) s_tv.getby()); //直??
            }

            //格子点に丸を描く

            g.setColor(Color.gray);
            Ten t_ob = new Ten();
            Ten t_tv = new Ten();
            for (int i = -30; i <= 30; i++) {
                for (int j = -30; j <= 30; j = j + 2) {
                    t_ob.set(kousi_haba * i, sankaku_kousi_takasa * j);
                    t_tv.set(camera.object2TV(t_ob));
                    g.drawOval((int) t_tv.getx() - ir, (int) t_tv.gety() - ir, 2 * ir, 2 * ir); //円
                }
                for (int j = -31; j <= 31; j = j + 2) {
                    t_ob.set(kousi_haba * i + kousi_haba / 2.0, sankaku_kousi_takasa * j);
                    t_tv.set(camera.object2TV(t_ob));
                    g.drawOval((int) t_tv.getx() - ir, (int) t_tv.gety() - ir, 2 * ir, 2 * ir); //円
                }

            }


        }


        //camera中?Sを?\字で描く
        OO.jyuuji(g, camera.object2TV(camera.get_camera_ichi()), 5.0, 2.0, 3);


        //展開?}の描画

        for (int i = 1; i <= k.getsousuu() - 1; i++) {

            if (k.getcolor(i) == 0) {
                g.setColor(Color.black);
            }
            if (k.getcolor(i) == 1) {
                g.setColor(Color.red);
            }
            if (k.getcolor(i) == 2) {
                g.setColor(Color.blue);
            }

            s_tv.set(camera.object2TV(k.get(i)));
            a.set(s_tv.geta());
            b.set(s_tv.getb());

            g.drawLine((int) a.getx(), (int) a.gety(), (int) b.getx(), (int) b.gety()); //直??
            if (iTenkaizuSenhaba != 1) {
                OO.habaLine(g, s_tv, iTenkaizuSenhaba, k.getcolor(i));
            }//  太??

            //OO.habaLine( g,s_tv,iTenkaizuSenhaba,k.getcolor(i));

            g.setColor(Color.white);
            g.fillOval((int) a.getx() - ir, (int) a.gety() - ir, 2 * ir, 2 * ir); //円
            g.fillOval((int) b.getx() - ir, (int) b.gety() - ir, 2 * ir, 2 * ir); //円

            g.setColor(Color.black);
            g.drawOval((int) a.getx() - ir, (int) a.gety() - ir, 2 * ir, 2 * ir); //円
            g.drawOval((int) b.getx() - ir, (int) b.gety() - ir, 2 * ir, 2 * ir); //円
        }

        int i = k.getsousuu();

        if (i != 0) {

            if (k.getcolor(i) == 0) {
                g.setColor(Color.black);
            }
            if (k.getcolor(i) == 1) {
                g.setColor(Color.red);
            }
            if (k.getcolor(i) == 2) {
                g.setColor(Color.blue);
            }

            s_tv.set(camera.object2TV(k.get(i)));
            a.set(s_tv.geta());
            b.set(s_tv.getb());

            g.drawLine((int) a.getx(), (int) a.gety(), (int) b.getx(), (int) b.gety()); //直??
            if (iTenkaizuSenhaba != 1) {
                OO.habaLine(g, s_tv, iTenkaizuSenhaba, k.getcolor(i));
            }//  太??

            if (i_saigo_no_senbun_no_maru_kaku == 1) {
                g.setColor(Color.white);
                g.fillOval((int) a.getx() - ir, (int) a.gety() - ir, 2 * ir, 2 * ir); //円
                g.fillOval((int) b.getx() - ir, (int) b.gety() - ir, 2 * ir, 2 * ir); //円

                g.setColor(Color.black);
                g.drawOval((int) a.getx() - ir, (int) a.gety() - ir, 2 * ir, 2 * ir); //円
                g.drawOval((int) b.getx() - ir, (int) b.gety() - ir, 2 * ir, 2 * ir); //円

            }
        }


        g.setColor(Color.black);
    }


//--------------------------------------------------------------------------------------
//マウス操??----------------------------------------------------------------------------
//--------------------------------------------------------------------------------------


    //マウス操??(ボタンを押したとき)時の??業----------------------------------------------------
    public void mPressed(Ten p) {
        //ゴミ箱がクリックされたら?A単独の??分を???怩ｷる

        if (gomibako.naibu(p) >= 1) {
            k.tanSenbun_sakujyo(r);
            nhi = 0;//入力方法が多角形の???№ﾌ?炎匀ｻを?sう
        }

        //
        if (nyuuryoku_houhou != 2) {
            nhi = 0;
        }

        if (nyuuryoku_houhou <= 1) {

            if (nyuuryoku_houhou == 1) {
                int mtsid = k.mottomo_tikai_senbun_sagasi(p);
                k.addsenbun(k.getb(mtsid), p);

                k.set(mtsid, k.geta(mtsid), p, k.getcolor(mtsid), 0);
                k.setcolor(k.getsousuu(), k.getcolor(mtsid));
                if (icol >= 0) {
                    k.set(mtsid, k.geta(mtsid), p, icol, 0);
                    k.setcolor(k.getsousuu(), icol);

                }
            }

            //マウスと近い位置にある枝を探す?B
            ieda = k.senbun_sagasi(p, r, 0);
            //基本枝?\造の中の?Aどの枝とも遠い?????B
            if (ieda == 0) {
                k.addsenbun(p, p);
                ieda = k.getsousuu();
                ugokasi_mode = 4;
                if (icol >= 0) {
                    k.setcolor(ieda, icol);
                }
            }
            //基本枝?\造の中の?Aどれかの枝に近い?????B
            else {
                if (1 == k.senbun_busyo_sagasi(ieda, p, r)) {
                    ugokasi_mode = 1;
                } //a点に近い?????B
                if (2 == k.senbun_busyo_sagasi(ieda, p, r)) {
                    ugokasi_mode = 2;
                } //b点に近い?????B
                if (3 == k.senbun_busyo_sagasi(ieda, p, r)) {                 //柄の部分に近い?????B
                    pa.set(1, k.geta(ieda), -1, p);
                    pb.set(1, k.getb(ieda), -1, p);
                    ugokasi_mode = 3;
                    if (icol >= 0) {
                        k.setcolor(ieda, icol);
                    }
                }
            }

            System.out.print("ieda = ");
            System.out.println(ieda);
          /*     System.out.print("6:") ;
		System.out.print(k.getax(6)) ;System.out.print(",") ;
	        System.out.print(k.getay(6)) ;System.out.print(",") ;
		System.out.print(k.getbx(6)) ;System.out.print(",") ;
	        System.out.print(k.getby(6)) ;System.out.println(",");
                System.out.print("7:") ;
		System.out.print(k.getax(7)) ;System.out.print(",") ;
	        System.out.print(k.getay(7)) ;System.out.print(",") ;
		System.out.print(k.getbx(7)) ;System.out.print(",") ;
	        System.out.print(k.getby(7)) ;System.out.println(",,,") ;
                System.out.println(oc.senbun_kousa_hantei(k.get(6),k.get(7)));
	   */
            k.kasseika(p, r);
        }
        //--------------
        if (nyuuryoku_houhou == 2) {
	    /*     ugokasi_mode=0;
	     		// 枝の平?s移動はできるようにする?B
                ieda=k.senbun_sagasi(p,r,0);
				//基本枝?\造の中の?Aどれかの枝に近い?????B
		if( ieda!=0){
			if(3==k.senbun_busyo_sagasi(ieda,p,r)){                 //柄の部分に近い?????B
				pa.set(1,k.geta(ieda),-1,p);
				pb.set(1,k.getb(ieda),-1,p);
				ugokasi_mode=3 ;
				if(icol>=0){k.setcolor(ieda,icol);}
			}
		k.kasseika(p,r);
                }

		//


	        //---------

	       else{ */

            nhi = nhi + 1;

            //System.out.print("nh1 = ");System.out.print("nh1 = ")

            if (nhi == 1) {
                k.addsenbun(p, p);
                nhTen = p;
                for (int i = 1; i <= k.getsousuu() - 1; i++) {
                    if (oc.hitosii(k.geta(i), p, 2.0 * r)) {
                        k.set(k.getsousuu(), k.geta(i), k.geta(i), 0, 0);
                        nhTen = k.geta(i);
                        break;
                    }
                    if (oc.hitosii(k.getb(i), p, 2.0 * r)) {
                        k.set(k.getsousuu(), k.getb(i), k.getb(i), 0, 0);
                        nhTen = k.getb(i);
                        break;
                    }
                }


            }
            if (nhi != 1) {   // set(int i, Ten p,Ten q,int ic,int ia)

                k.addsenbun(nhTen, p);
                for (int i = 1; i <= k.getsousuu() - 1; i++) {
                    if (oc.hitosii(k.geta(i), p, 2.0 * r)) {
                        k.set(k.getsousuu(), k.geta(i), k.getb(k.getsousuu() - 1), 0, 0);
                        nhi = 0;
                        break;
                    }
                    if (oc.hitosii(k.getb(i), p, 2.0 * r)) {
                        k.set(k.getsousuu(), k.getb(i), k.getb(k.getsousuu() - 1), 0, 0);
                        nhi = 0;
                        break;
                    }
                }
                nhTen = p;
            }

            if (icol >= 0) {
                k.setcolor(k.getsousuu(), icol);
            }
        }

        //--------------
        if (nyuuryoku_houhou == 2) {

        }


    }

    //マウス操??(ドラッグしたとき)を?sう関??----------------------------------------------------
    public void mDragged(Ten p) {

        if (nyuuryoku_houhou <= 1) {

            if (ugokasi_mode == 1) {
                k.set(p);
            } //a点を変?X
            if (ugokasi_mode == 2) {
                k.set(p);
            } //b点を変?X
            if (ugokasi_mode == 3) {//枝を平?s移動
                k.seta(ieda, new Ten(1, p, 1, pa));
                k.setb(ieda, new Ten(1, p, 1, pb));
            }
            if (ugokasi_mode == 4) {
                k.set(p);
            } //a点を変?X(ugokasi_mode==1)と同じ動??をする

        }
        //--------------
        if (nyuuryoku_houhou == 1) {
	    /*
		if(ugokasi_mode==3){//枝を平?s移動
			k.seta(ieda,new Ten(1,p,1,pa));
			k.setb(ieda,new Ten(1,p,1,pb));
		}
	     */
        }

        //--------------
        if (nyuuryoku_houhou == 2) {

        }


    }

    //マウス操??(ボタンを離したとき)を?sう関??----------------------------------------------------
    public void mReleased(Ten p) {

        if (nyuuryoku_houhou <= 1) {

            if (ugokasi_mode == 1) {
                k.set(p);
            } //a点を変?X
            if (ugokasi_mode == 2) {
                k.set(p);
            } //b点を変?X
            if (ugokasi_mode == 3) {//枝を平?s移動
                k.seta(ieda, new Ten(1, p, 1, pa));
                k.setb(ieda, new Ten(1, p, 1, pb));
                if (ugokasi_mode == 4) {
                    k.set(p);
                }//a点を変?X(ugokasi_mode==1)と同じ動??をする

            }
            //

            //eda_atosyori_01();                //枝の長さを変えずに?A枝全体を平?s移動して微調?ｮする?B<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            eda_atosyori_02();                //一端の点だけを移動して反対の端の点は動かさないで微調?ｮする?B <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


            //----------格子に?謔ｹる
            if ((nyuuryoku_kitei == 1) || (nyuuryoku_kitei == 2)) {
                //  int i=get_ieda();
                //  k.seta(i,kitei_idou(k.geta(i)));
                //  k.setb(i,kitei_idou(k.getb(i)));

                // k.set(kitei_idou(p)) ;


                for (int i = 1; i <= k.getsousuu(); i++) {
                    // Ten tn=new Ten();
                    //tn.set(k.get(i));
                    //   k.set(i,kitei_idou(k.geta(i)));

                    System.out.print("iactive ");
                    System.out.print(i);
                    System.out.print(": ");
                    System.out.println(k.getiactive(i));
                    if (k.getiactive(i) >= 1) {
                        k.seta(i, kitei_idou(k.geta(i)));
                        k.setb(i, kitei_idou(k.getb(i)));
                    }

                }
                /**/

            }


            k.hikasseika(); //非活?ｫ化

            //対?ﾌ?ｫがある???№ﾌ????
            if (taisyousei > 0) {
                if (((tyuuoutai_xmin < k.geta(ieda).getx()) && (k.geta(ieda).getx() < tyuuoutai_xmax))
                        &&
                        ((tyuuoutai_xmin < k.getb(ieda).getx()) && (k.getb(ieda).getx() < tyuuoutai_xmax))) {
                    k.seta(ieda, new Ten((tyuuoutai_xmin + tyuuoutai_xmax) / 2, k.geta(ieda).gety()));
                    k.setb(ieda, new Ten((tyuuoutai_xmin + tyuuoutai_xmax) / 2, k.getb(ieda).gety()));
                }
            }

            //ゴミ捨て?B?@これをやるとアクティブなieda枝の番??がずれるので?A一応eda_atosyoriの後でやるようにする?B
            if ((ugokasi_mode == 4) && (k.getnagasa(k.getsousuu()) < r)) { //?V規追加分の??分が点?ﾌ?i長さがrより?ｬさい?jとき?????B
                k.delsenbun(k.getsousuu());
            } else {
                gomisute();//ごみ箱に入った??分の?ﾁ去
            }


        }
        //--------------
        if (nyuuryoku_houhou == 1) {

        }

        //--------------
        if (nyuuryoku_houhou == 2) {

        }
    }


    //000000000000000000000000000000000000000000000000000000000000000000000000000000000
    //マウス操??(i_mouse_modeA==0?@旧動???@見本のために残している?B???怏ﾂ----------------------------------------------------
    public void mPressed_A_00(Ten p) {
        //ゴミ箱がクリックされたら?A単独の??分を???怩ｷる
        if (gomibako.naibu(p) >= 1) {
            k.tanSenbun_sakujyo(r);
            nhi = 0;//入力方法が多角形の???№ﾌ?炎匀ｻを?sう
        }
        // nyuuryoku_houhouは入力方法の指定?B0なら通?墲ﾌ方法?A1なら多角形入力?A２なら直??を指定した点に引き寄せる
        if (nyuuryoku_houhou != 2) {
            nhi = 0;
        }
        if (nyuuryoku_houhou <= 1) {
            if (nyuuryoku_houhou == 1) {
                int mtsid = k.mottomo_tikai_senbun_sagasi(p);
                k.addsenbun(k.getb(mtsid), p);

                k.set(mtsid, k.geta(mtsid), p, k.getcolor(mtsid), 0);
                k.setcolor(k.getsousuu(), k.getcolor(mtsid));
                if (icol >= 0) {
                    k.set(mtsid, k.geta(mtsid), p, icol, 0);
                    k.setcolor(k.getsousuu(), icol);
                }
            }

            //マウスと近い位置にある枝を探す?B
            ieda = k.senbun_sagasi(p, r, 0);
            //基本枝?\造の中の?Aどの枝とも遠い?????B
            if (ieda == 0) {
                k.addsenbun(p, p);
                ieda = k.getsousuu();
                ugokasi_mode = 4;
                if (icol >= 0) {
                    k.setcolor(ieda, icol);
                }
            }
            //基本枝?\造の中の?Aどれかの枝に近い?????B
            else {
                if (1 == k.senbun_busyo_sagasi(ieda, p, r)) {
                    ugokasi_mode = 1;
                } //a点に近い?????B
                if (2 == k.senbun_busyo_sagasi(ieda, p, r)) {
                    ugokasi_mode = 2;
                } //b点に近い?????B
                if (3 == k.senbun_busyo_sagasi(ieda, p, r)) {                 //柄の部分に近い?????B
                    pa.set(1, k.geta(ieda), -1, p);
                    pb.set(1, k.getb(ieda), -1, p);
                    ugokasi_mode = 3;
                    if (icol >= 0) {
                        k.setcolor(ieda, icol);
                    }
                }
            }
            System.out.print("ieda = ");
            System.out.println(ieda);
            k.kasseika(p, r);
        }
        //--------------
        if (nyuuryoku_houhou == 2) {
            nhi = nhi + 1;
            //System.out.print("nh1 = ");System.out.print("nh1 = ")
            if (nhi == 1) {
                k.addsenbun(p, p);
                nhTen = p;
                for (int i = 1; i <= k.getsousuu() - 1; i++) {
                    if (oc.hitosii(k.geta(i), p, 2.0 * r)) {
                        k.set(k.getsousuu(), k.geta(i), k.geta(i), 0, 0);
                        nhTen = k.geta(i);
                        break;
                    }
                    if (oc.hitosii(k.getb(i), p, 2.0 * r)) {
                        k.set(k.getsousuu(), k.getb(i), k.getb(i), 0, 0);
                        nhTen = k.getb(i);
                        break;
                    }
                }
            }
            if (nhi != 1) {   // set(int i, Ten p,Ten q,int ic,int ia)
                k.addsenbun(nhTen, p);
                for (int i = 1; i <= k.getsousuu() - 1; i++) {
                    if (oc.hitosii(k.geta(i), p, 2.0 * r)) {
                        k.set(k.getsousuu(), k.geta(i), k.getb(k.getsousuu() - 1), 0, 0);
                        nhi = 0;
                        break;
                    }
                    if (oc.hitosii(k.getb(i), p, 2.0 * r)) {
                        k.set(k.getsousuu(), k.getb(i), k.getb(k.getsousuu() - 1), 0, 0);
                        nhi = 0;
                        break;
                    }
                }
                nhTen = p;
            }
            if (icol >= 0) {
                k.setcolor(k.getsousuu(), icol);
            }
        }
    }


    //マウス操??(i_mouse_modeA==0?@旧動???@見本のために残している?B???怏ﾂ----------------------------------------------------
    public void mDragged_A_00(Ten p) {
        if (nyuuryoku_houhou <= 1) {
            if (ugokasi_mode == 1) {
                k.set(p);
            } //a点を変?X
            if (ugokasi_mode == 2) {
                k.set(p);
            } //b点を変?X
            if (ugokasi_mode == 3) {        //枝を平?s移動
                k.seta(ieda, new Ten(1, p, 1, pa));
                k.setb(ieda, new Ten(1, p, 1, pb));
            }
            if (ugokasi_mode == 4) {
                k.set(p);
            } //a点を変?X(ugokasi_mode==1)と同じ動??をする
        }
        //--------------
        if (nyuuryoku_houhou == 1) {
        }
        //--------------
        if (nyuuryoku_houhou == 2) {
        }
    }

    //マウス操??(i_mouse_modeA==0?@旧動???@見本のために残している?B???怏ﾂ----------------------------------------------------
    public void mReleased_A_00(Ten p) {
        if (nyuuryoku_houhou <= 1) {
            if (ugokasi_mode == 1) {
                k.set(p);
            } //a点を変?X
            if (ugokasi_mode == 2) {
                k.set(p);
            } //b点を変?X
            if (ugokasi_mode == 3) {//枝を平?s移動
                k.seta(ieda, new Ten(1, p, 1, pa));
                k.setb(ieda, new Ten(1, p, 1, pb));
                if (ugokasi_mode == 4) {
                    k.set(p);
                }//a点を変?X(ugokasi_mode==1)と同じ動??をする
            }
            //eda_atosyori_01();                //枝の長さを変えずに?A枝全体を平?s移動して微調?ｮする?B<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            eda_atosyori_02();                //一端の点だけを移動して反対の端の点は動かさないで微調?ｮする?B <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

            //----------格子に?謔ｹる
            if (nyuuryoku_kitei >= 1) {
                for (int i = 1; i <= k.getsousuu(); i++) {
                    System.out.print("iactive ");
                    System.out.print(i);
                    System.out.print(": ");
                    System.out.println(k.getiactive(i));
                    if (k.getiactive(i) >= 1) {
                        k.seta(i, kitei_idou(k.geta(i)));
                        k.setb(i, kitei_idou(k.getb(i)));
                    }

                }
            }

            k.hikasseika(); //非活?ｫ化

            //対?ﾌ?ｫがある???№ﾌ????
            if (taisyousei > 0) {
                if (((tyuuoutai_xmin < k.geta(ieda).getx()) && (k.geta(ieda).getx() < tyuuoutai_xmax))
                        &&
                        ((tyuuoutai_xmin < k.getb(ieda).getx()) && (k.getb(ieda).getx() < tyuuoutai_xmax))) {
                    k.seta(ieda, new Ten((tyuuoutai_xmin + tyuuoutai_xmax) / 2, k.geta(ieda).gety()));
                    k.setb(ieda, new Ten((tyuuoutai_xmin + tyuuoutai_xmax) / 2, k.getb(ieda).gety()));
                }
            }

            //ゴミ捨て?B?@これをやるとアクティブなieda枝の番??がずれるので?A一応eda_atosyoriの後でやるようにする?B
            if ((ugokasi_mode == 4) && (k.getnagasa(k.getsousuu()) < r)) { //?V規追加分の??分が点?ﾌ?i長さがrより?ｬさい?jとき?????B
                k.delsenbun(k.getsousuu());
            } else {
                gomisute();//ごみ箱に入った??分の?ﾁ去
            }
        }
        //--------------
        if (nyuuryoku_houhou == 1) {
        }

        //--------------
        if (nyuuryoku_houhou == 2) {
        }
    }

    //1111111111111111111111111111111111111111111111111111111
    //マウス操??(i_mouse_modeA==1??分入力?@でボタンを押したとき)時の??業----------------------------------------------------
    public void mPressed_A_01(Ten p0) {

        i_saigo_no_senbun_no_maru_kaku = 0;
        Ten p = new Ten();
        p.set(camera.TV2object(p0));
        k.addsenbun(p, p);
        ieda = k.getsousuu();
        k.setcolor(ieda, icol);
    }

    //マウス操??(i_mouse_modeA==1??分入力?@でドラッグしたとき)を?sう関??----------------------------------------------------
    public void mDragged_A_01(Ten p0) {
        Ten p = new Ten();
        p.set(camera.TV2object(p0));
        k.seta(ieda, p);
    }

    //マウス操??(i_mouse_modeA==1??分入力?@でボタンを離したとき)を?sう関??----------------------------------------------------
    public void mReleased_A_01(Ten p0) {
        i_saigo_no_senbun_no_maru_kaku = 1;
        Ten p = new Ten();
        p.set(camera.TV2object(p0));
        k.seta(ieda, p);
        eda_atosyori_02();                //一端の点だけを移動して反対の端の点は動かさないで微調?ｮする?B <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

        //----------格子に?謔ｹる
        if ((nyuuryoku_kitei == 1) || (nyuuryoku_kitei == 2)) {
            //for(int i=1;i<=k.getsousuu();i++){
            //System.out.print("iactive 20150312"); System.out.print(i); System.out.print(": ");
            //System.out.println(k.getiactive(i));
            //if(k.getiactive(i)>=1){
            k.seta(k.getsousuu(), kitei_idou(k.geta(k.getsousuu())));
            k.setb(k.getsousuu(), kitei_idou(k.getb(k.getsousuu())));
            //}
            //}
        }


        if (nyuuryoku_kitei == 3) {

            k.seta(k.getsousuu(), sankaku_kitei_idou(k.geta(k.getsousuu())));
            k.setb(k.getsousuu(), sankaku_kitei_idou(k.getb(k.getsousuu())));

        }


        //?｡入力した??分が?A?｡までに入力?ﾏみのどれかの??分と全く同じ位置で一致する???№ﾍ?A?｡入力した??分の?Fだけ反映させて?A?｡入力した??分は追加はしない?B
        int i_kasanari;
        i_kasanari = k.kasanari_senbun_sagasi(k.getsousuu());
        if (i_kasanari > 0) {
            k.setcolor(i_kasanari, k.getcolor(k.getsousuu()));
            k.delsenbun(getsousuu());
        }
        k.kousabunkatu();//全く?dなる??分がない?ﾔで実施される?B//2回やらないと反応しない???№ｪある?B原因不明?B
        k.kousabunkatu();


    }

    //------------------------------------------------------
    public Ten kitei_idou(Ten t1) {
        Ten t_ob = new Ten();

        for (int i = i_kousi_x_min / kousi_haba; i <= i_kousi_x_max / kousi_haba; i++) {
            for (int j = i_kousi_y_min / kousi_haba; j <= i_kousi_y_max / kousi_haba; j++) {
                t_ob.set(kousi_haba * i, kousi_haba * j);
                if (oc.kyori(t_ob, t1) < r) {
                    return t_ob;
                }

            }
        }


        return t1;
    }

    //------------------------------------------------------
    public Ten sankaku_kitei_idou(Ten t1) {
        double sqr3 = 1.732051;
        double sankaku_kousi_takasa;
        sankaku_kousi_takasa = kousi_haba * sqr3 / 2.0;
        Ten t_ob = new Ten();
        for (int i = -30; i <= 30; i++) {
            for (int j = -30; j <= 30; j = j + 2) {
                t_ob.set(kousi_haba * i, sankaku_kousi_takasa * j);
                if (oc.kyori(t_ob, t1) < r) {
                    return t_ob;
                }
            }
            for (int j = -31; j <= 31; j = j + 2) {
                t_ob.set(kousi_haba * i + kousi_haba / 2.0, sankaku_kousi_takasa * j);
                if (oc.kyori(t_ob, t1) < r) {
                    return t_ob;
                }
            }

        }


        return t1;
    }

/*

			//格子点に丸を描く

			g.setColor(Color.gray);	Ten t_ob =new Ten();	Ten t_tv =new Ten();
			for(int i=-30;i<=30;i++ ){
				for(int j=-30;j<=30;j=j+2 ){
					t_ob.set(kousi_haba*i,sankaku_kousi_takasa*j);
					t_tv.set(camera.object2TV(t_ob));
					g.drawOval( (int)t_tv.getx()-ir,(int)t_tv.gety()-ir,2*ir,2*ir); //円
				}
				for(int j=-31;j<=31;j=j+2 ){
					t_ob.set(kousi_haba*i+kousi_haba/2.0,sankaku_kousi_takasa*j);
					t_tv.set(camera.object2TV(t_ob));
					g.drawOval( (int)t_tv.getx()-ir,(int)t_tv.gety()-ir,2*ir,2*ir); //円
				}

			}
*/


    //22222222222222222222222222222222222222222222222222222222222222
    public void mPressed_A_02(Ten p0) {
    }//マウス操??(i_mouse_modeA==2展開?}調?ｮ?@でボタンを押したとき)時の??業

    public void mDragged_A_02(Ten p0) {
    }//マウス操??(i_mouse_modeA==2??分入力?@でドラッグしたとき)を?sう関??

    public void mReleased_A_02(Ten p0) {
    }//マウス操??(i_mouse_modeA==2??分入力?@でボタンを離したとき)を?sう関??

    //3333333333333333333333333333333333333333333333333333333333333
    //マウス操??(i_mouse_modeA==3??分?????@でボタンを押したとき)時の??業----------------------------------------------------
    public void mPressed_A_03(Ten p0) {
    }

    //マウス操??(i_mouse_modeA==3??分?????@?@でドラッグしたとき)を?sう関??----------------------------------------------------
    public void mDragged_A_03(Ten p0) {
    }

    //マウス操??(i_mouse_modeA==3??分?????@?@でボタンを離したとき)を?sう関??----------------------------------------------------
    public void mReleased_A_03(Ten p0) {
        Ten p = new Ten();
        p.set(camera.TV2object(p0));
        int minrid;
        double minr;
        minrid = k.mottomo_tikai_senbun_sagasi(p);
        if (k.senbun_busyo_sagasi(minrid, p, r) != 0) {
            k.delsenbun(minrid);
        }
    }

    //44444444444444444444444444444444444444444444444444444444444444
    public void mPressed_A_04(Ten p0) {
    }//マウス操??(i_mouse_modeA==4??_変換?@でボタンを押したとき)時の??業

    public void mDragged_A_04(Ten p0) {
    }//マウス操??(i_mouse_modeA==4??_変換?@でドラッグしたとき)を?sう関??

    public void mReleased_A_04(Ten p0) {
        Ten p = new Ten();
        p.set(camera.TV2object(p0));
        int minrid;
        double minr;
        minrid = k.mottomo_tikai_senbun_sagasi(p);
        if (k.senbun_busyo_sagasi(minrid, p, r) != 0) {
            int ic_temp;
            ic_temp = k.getcolor(minrid);
            ic_temp = ic_temp + 1;
            if (ic_temp == 3) {
                ic_temp = 0;
            }
            k.setcolor(minrid, ic_temp);
        }


    }//マウス操??(i_mouse_modeA==4??_変換?@でボタンを離したとき)を?sう関??


}