package jp.gr.java_conf.mt777.origami.orihime.tenkaizu_syokunin;

import jp.gr.java_conf.mt777.kiroku.memo.Memo;
import jp.gr.java_conf.mt777.origami.dougu.camera.Camera;
import jp.gr.java_conf.mt777.origami.dougu.senbunsyuugou.Senbunsyuugou;
import jp.gr.java_conf.mt777.origami.dougu.tensyuugou.Tensyuugou;
import jp.gr.java_conf.mt777.origami.orihime.undo_box.Undo_Box;
import jp.gr.java_conf.mt777.zukei2d.heikinzahyou.HeikinZahyou;
import jp.gr.java_conf.mt777.zukei2d.oritacalc.OritaCalc;
import jp.gr.java_conf.mt777.zukei2d.senbun.Senbun;
import jp.gr.java_conf.mt777.zukei2d.ten.Ten;

import java.awt.*;
// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------

public class Tenkaizu_Syokunin {//この展開?}?E?lクラスは展開?}としてのTensyuugou cを１つだけもつ?B
    //?ﾜり?ﾝ等をやった結果得られるTensyuugouは外部に返すようにして?A自分自?gでは保??しない?B
    OritaCalc oc = new OritaCalc(); //各種計算用の関?狽gうためのクラスのインスタンス化
    double r = 3.0;                   //基本枝?\造の直??の両端の円の半径?A枝と各種ポイントの近さの判定基??

    Tensyuugou c = new Tensyuugou();    //展開?}

    Undo_Box Ubox = new Undo_Box();

    //VVVVVVVVVVVV oritatami?@と?@oekaki で使う変???@の定義?@VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV
    int[] iMeniti;//ある面が基??面と何面離れているかを示す?B基??面では1?A基??面の隣では2?Aその隣では3という様に値を入れる
    int kijyunmen_id;
    int[] tonariMenid;//ある面の隣の面?i基??面側?jのid
    int[] kyoukaiBouid;//ある面と隣の面?i基??面側?jの間の棒のid

    HeikinZahyou[] tnew;//?ﾜった時の点の位置を格納

    //  Ten naibuTen [] = new Ten[888];         //面の内部の点を格納

    //マウスでTenを選択した???№ﾌTenの番??を格納
    public int i_ugokasuTen = 0;

    Camera camera = new Camera();
    Camera cam_omote = new Camera();
    Camera cam_ura = new Camera();

    Camera cam_touka_omote = new Camera();
    Camera cam_touka_ura = new Camera();


    public Ten ten_of_kijyunmen_ob = new Ten();

    //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA

    public Tenkaizu_Syokunin(double r0) {  //コンストラクタ
        //	 reset();
        r = r0;
    }

    public void reset() {
        r = 3.0;
        c.reset();
        //for(int i=0;i<=c.getTensuu();i++){tnew[i].reset();}

        camera.reset();
        cam_omote.reset();
        cam_ura.reset();


        cam_touka_omote.reset();
        cam_touka_ura.reset();

    }

    private void settei(int Tsuu, int Bsuu, int Msuu) {
        HeikinZahyou[] t_new = new HeikinZahyou[Tsuu + 1];
        tnew = t_new;
        for (int i = 0; i <= Tsuu; i++) {
            tnew[i] = new HeikinZahyou();
        }
        int[] i_Meniti = new int[Msuu + 1];
        iMeniti = i_Meniti;
        int[] tonari_Menid = new int[Msuu + 1];
        tonariMenid = tonari_Menid;         //ある面の隣の面?i基??面側?jのid
        int[] kyoukai_Bouid = new int[Msuu + 1];
        kyoukaiBouid = kyoukai_Bouid;         //ある面と隣の面?i基??面側?jの間の棒のid
    }

    //---------------
    //public void Iti_sitei(double x, double y){c.Iti_sitei(x ,y);}

    //-----------
    public void add_kijyunmen_id() {
        kijyunmen_id = kijyunmen_id + 1;
        if (kijyunmen_id > c.getMensuu()) {
            kijyunmen_id = 1;
        }
    }


    //-------------------------------------------
    public int get_kijyunmen_id() {
        return kijyunmen_id;
    }


    //-------------------------------------------
    public Ten get_kijyunmen_migiue_Ten() {

        return c.get_men_migiue_Ten(kijyunmen_id);

    }

    //-------------------------------------------
    public Ten get_ten_of_kijyunmen_ob() {

        return ten_of_kijyunmen_ob;

    }

    //-------------------------------------------
    public Ten get_ten_of_kijyunmen_tv() {

        return camera.object2TV(ten_of_kijyunmen_ob);

    }


    //-------------------------------------------
    public int set_kijyunmen_id(int i) {
        kijyunmen_id = i;


        if (kijyunmen_id > c.getMensuu()) {
            kijyunmen_id = c.getMensuu();
        }
        if (kijyunmen_id < 1) {
            kijyunmen_id = 1;
        }

        ten_of_kijyunmen_ob = c.naibuTen_motome(kijyunmen_id);


        return kijyunmen_id;
    }


    //-----------これは基??面指定モ?[ドでマウスを押されたときの対応201503
    public int set_kijyunmen_id(Ten p0) {//実?ﾛに有効になっている基??面idを返す
        Ten p = new Ten();
        p.set(camera.TV2object(p0));
        if (c.naibu(p) > 0) {
            kijyunmen_id = c.naibu(p);
            ten_of_kijyunmen_ob.set(p);
        }//c.naibu(p)=0ならどの面の内部にもない?Aマイナスなら境界?????A?ｳの?狽ﾈら内部?B該当する面番??が複?狽?る???№ﾍ番??の?ｬさいほうが返される?B
        return kijyunmen_id;
    }


    //-----------Ten p0が?ﾜり?繧ｪり?}の内部に有るかどうかを判定する
    public int naibu_hantei(Ten p0) {//実?ﾛにp0がある面idを返す
        Ten p = new Ten();
        p.set(camera.TV2object(p0));
        return c.naibu(p);//c.naibu(p)=0ならどの面の内部にもない?Aマイナスなら境界?????A?ｳの?狽ﾈら内部?B該当する面番??が複?狽?る???№ﾍ番??の?ｬさいほうが返される?B
    }

    //-----------Ten p0が?ﾜり?繧ｪり?}(表)の内部に有るかどうかを判定する
    public int naibu_hantei_omote(Ten p0) {//実?ﾛにp0がある面idを返す
        Ten p = new Ten();
        p.set(cam_omote.TV2object(p0));
        return c.naibu(p);//Tensyuugou c.naibu(p)=0ならどの面の内部にもない?Aマイナスなら境界?????A?ｳの?狽ﾈら内部?B該当する面番??が複?狽?る???№ﾍ番??の?ｬさいほうが返される?B
    }

    //-----------Ten p0が?ﾜり?繧ｪり?}(裏)の内部に有るかどうかを判定する
    public int naibu_hantei_ura(Ten p0) {//実?ﾛにp0がある面idを返す
        Ten p = new Ten();
        p.set(cam_ura.TV2object(p0));
        return c.naibu(p);//Tensyuugou c.naibu(p)=0ならどの面の内部にもない?Aマイナスなら境界?????A?ｳの?狽ﾈら内部?B該当する面番??が複?狽?る???№ﾍ番??の?ｬさいほうが返される?B
    }

    //-----------Ten p0が?ﾜり?繧ｪり?}に付属して表示される透過?}(表)の内部に有るかどうかを判定する
    public int naibu_hantei_touka_omote(Ten p0) {//実?ﾛにp0がある面idを返す
        Ten p = new Ten();
        p.set(cam_touka_omote.TV2object(p0));
        return c.naibu(p);//Tensyuugou c.naibu(p)=0ならどの面の内部にもない?Aマイナスなら境界?????A?ｳの?狽ﾈら内部?B該当する面番??が複?狽?る???№ﾍ番??の?ｬさいほうが返される?B
    }

    //-----------Ten p0が?ﾜり?繧ｪり?}に付属して表示される透過?}(裏)の内部に有るかどうかを判定する
    public int naibu_hantei_touka_ura(Ten p0) {//実?ﾛにp0がある面idを返す
        Ten p = new Ten();
        p.set(cam_touka_ura.TV2object(p0));
        return c.naibu(p);//Tensyuugou c.naibu(p)=0ならどの面の内部にもない?Aマイナスなら境界?????A?ｳの?狽ﾈら内部?B該当する面番??が複?狽?る???№ﾍ番??の?ｬさいほうが返される?B
    }


    //--------------------------------------------
    public void set_r(double r0) {
        r = r0;
    }

    //--------------------------------------------
    public void setCamera(Camera cam0) {
        camera.set_camera_kagami(cam0.get_camera_kagami());
        camera.set_camera_ichi_x(cam0.get_camera_ichi_x());
        camera.set_camera_ichi_y(cam0.get_camera_ichi_y());
        camera.set_camera_bairitsu_x(cam0.get_camera_bairitsu_x());
        camera.set_camera_bairitsu_y(cam0.get_camera_bairitsu_y());
        camera.set_camera_kakudo(cam0.get_camera_kakudo());
        camera.set_hyouji_ichi_x(cam0.get_hyouji_ichi_x());
        camera.set_hyouji_ichi_y(cam0.get_hyouji_ichi_y());
    }


    public void setCam_omote(Camera cam0) {
        cam_omote.set_camera_kagami(cam0.get_camera_kagami());
        cam_omote.set_camera_ichi_x(cam0.get_camera_ichi_x());
        cam_omote.set_camera_ichi_y(cam0.get_camera_ichi_y());
        cam_omote.set_camera_bairitsu_x(cam0.get_camera_bairitsu_x());
        cam_omote.set_camera_bairitsu_y(cam0.get_camera_bairitsu_y());
        cam_omote.set_camera_kakudo(cam0.get_camera_kakudo());
        cam_omote.set_hyouji_ichi_x(cam0.get_hyouji_ichi_x());
        cam_omote.set_hyouji_ichi_y(cam0.get_hyouji_ichi_y());
    }

    public void setCam_ura(Camera cam0) {
        cam_ura.set_camera_kagami(cam0.get_camera_kagami());
        cam_ura.set_camera_ichi_x(cam0.get_camera_ichi_x());
        cam_ura.set_camera_ichi_y(cam0.get_camera_ichi_y());
        cam_ura.set_camera_bairitsu_x(cam0.get_camera_bairitsu_x());
        cam_ura.set_camera_bairitsu_y(cam0.get_camera_bairitsu_y());
        cam_ura.set_camera_kakudo(cam0.get_camera_kakudo());
        cam_ura.set_hyouji_ichi_x(cam0.get_hyouji_ichi_x());
        cam_ura.set_hyouji_ichi_y(cam0.get_hyouji_ichi_y());
    }


    public void setCam_touka_omote(Camera cam0) {
        cam_touka_omote.set_camera_kagami(cam0.get_camera_kagami());
        cam_touka_omote.set_camera_ichi_x(cam0.get_camera_ichi_x());
        cam_touka_omote.set_camera_ichi_y(cam0.get_camera_ichi_y());
        cam_touka_omote.set_camera_bairitsu_x(cam0.get_camera_bairitsu_x());
        cam_touka_omote.set_camera_bairitsu_y(cam0.get_camera_bairitsu_y());
        cam_touka_omote.set_camera_kakudo(cam0.get_camera_kakudo());
        cam_touka_omote.set_hyouji_ichi_x(cam0.get_hyouji_ichi_x());
        cam_touka_omote.set_hyouji_ichi_y(cam0.get_hyouji_ichi_y());
    }

    public void setCam_touka_ura(Camera cam0) {
        cam_touka_ura.set_camera_kagami(cam0.get_camera_kagami());
        cam_touka_ura.set_camera_ichi_x(cam0.get_camera_ichi_x());
        cam_touka_ura.set_camera_ichi_y(cam0.get_camera_ichi_y());
        cam_touka_ura.set_camera_bairitsu_x(cam0.get_camera_bairitsu_x());
        cam_touka_ura.set_camera_bairitsu_y(cam0.get_camera_bairitsu_y());
        cam_touka_ura.set_camera_kakudo(cam0.get_camera_kakudo());
        cam_touka_ura.set_hyouji_ichi_x(cam0.get_hyouji_ichi_x());
        cam_touka_ura.set_hyouji_ichi_y(cam0.get_hyouji_ichi_y());
    }


    // ----------------
    public int getMensuu() {
        return c.getMensuu();
    }

    //-------------
    public void heikou_idou(double x, double y) {
        c.heikou_idou(x, y);
    }

    //
    public void uragaesi() {//?d?Sの位置を中?Sに?ｶ右に裏返す?B
        c.uragaesi();
    }

    //面の内部の点を??める//---------------------------------------
    public Ten naibuTen_motome(int i) {
        return c.naibuTen_motome(i);
    }

    //点?W?№ﾌ??つ棒の???狽ｾる
    public int getBousuu() {
        return c.getBousuu();
    }

    //点?W?№ﾌ??つ棒の?Fを得る?i点?W?№W開?}として扱う???№ﾅは?Aこの?Fは山谷をあらわす?j?B
    public int getcolor(int i) {
        return c.getcolor(i);
    }

    //-------------------------------------------
    public int getiMeniti(int i) {
        return iMeniti[i];
    }

    //-------------------------------------------
    //?ﾜりたたみ??定?iここでできるのは面の?dなりを?lえていない?j金?}?j
    public Tensyuugou oritatami() {//?ﾜりたたみ??定
        Tensyuugou cn = new Tensyuugou();    //展開?}
        cn.settei(c.getTensuu(), c.getBousuu(), c.getMensuu());
        cn.set(c);


//System.out.println("?ﾜりたたみ??定001   c.getTenx(1) = "+c.getTenx(1)+"   :   cn.getTenx(1) = "+cn.getTenx(1));

        //kijyunmen_id=1;//基??になる面を指定する

        for (int i = 0; i <= c.getMensuu(); i++) {
            tonariMenid[i] = 0;
            kyoukaiBouid[i] = 0;
            iMeniti[i] = 0;
        }
//System.out.println("?ﾜりたたみ??定002   c.getTenx(1) = "+c.getTenx(1)+"   :   cn.getTenx(1) = "+cn.getTenx(1));
        //?ﾜりたたみの??備として面同士の位置関係を把握する
        System.out.println("?ﾜりたたみの??備として面同士の位置関係を把握する");
        iMeniti[kijyunmen_id] = 1;

        int imano_Meniti = 1;
        int nokori_Mensuu;
        nokori_Mensuu = c.getMensuu() - 1;

        while (nokori_Mensuu > 0) {
            for (int i = 1; i <= c.getMensuu(); i++) {
                if (iMeniti[i] == imano_Meniti) {
                    for (int j = 1; j <= c.getMensuu(); j++) {
                        int mth = c.Men_tonari_hantei(i, j);
                        if ((mth > 0) && (iMeniti[j] == 0)) {
                            iMeniti[j] = imano_Meniti + 1;
                            tonariMenid[j] = i;
                            kyoukaiBouid[j] = mth;
                        }
                    }
                }
            }

            imano_Meniti = imano_Meniti + 1;

            nokori_Mensuu = 0;
            for (int i = 1; i <= c.getMensuu(); i++) {
                if (iMeniti[i] == 0) {
                    nokori_Mensuu = nokori_Mensuu + 1;
                }
            }

            System.out.println("nokori_Mensuu = " + nokori_Mensuu);
        }
//System.out.println("?ﾜりたたみ??定003   c.getTenx(1) = "+c.getTenx(1)+"   :   cn.getTenx(1) = "+cn.getTenx(1));
        System.out.println("?ﾜったときの点の位置を??める?B");
        //?ﾜったときの点の位置を??める?B
        //点itが面imに含まれる???№ﾉ?A
        //展開?}が?ﾜられたときにどこに移動するかを?A面imの移動によって??める?B

        System.out.println("?ﾜったときの点の位置を??める?i開始?j");
        for (int it = 1; it <= c.getTensuu(); it++) {
            tnew[it].reset();
            for (int im = 1; im <= c.getMensuu(); im++) {
                if (c.Ten_moti_hantei(im, it) == 1) {//c.Ten_moti_hanteiは?AMen[im]の境界にTen[it]が含まれるなら1?A含まれないなら0を返す
                    tnew[it].addTen(ori_idou(it, im));
                    cn.setTen(it, tnew[it].getHeikin_Ten());
                }
            }
        }
        System.out.println("?ﾜったときの点の位置を??めた?i?I了?j");

//System.out.println("?ﾜりたたみ??定004   c.getTenx(1) = "+c.getTenx(1)+"   :   cn.getTenx(1) = "+cn.getTenx(1));
        return cn;
    }

    //------------------------------------------------------------
    private Ten ori_idou(int it, int im) { //点itが面imの一員として?ﾜられた???№ﾌ移動?謔ﾌ位置を??める関??

        Ten p = new Ten();  // p1.set(s.geta());
        p.set(c.getTen(it));
        int idousakino_Menid;
        idousakino_Menid = im;//?ﾅ?奄ﾌ面のid番???Bこれから基??面の方向に隣?ﾚする面をたどっていく?B
        while (idousakino_Menid != kijyunmen_id) {
            //p.set(sentaisyou_ten_motome(c.getBou(kyoukaiBouid[idousakino_Menid]),p));
            p.set(sentaisyou_ten_motome(kyoukaiBouid[idousakino_Menid], p));
            idousakino_Menid = tonariMenid[idousakino_Menid];
        }
        return p;
    }


// ***********************************

    //?ﾜりたたみ??定?iここでできるのは面の?dなりを?lえていない?j金?}?j
    public Tensyuugou men_iti_motome() {//?ﾜりたたみ??定

        Tensyuugou cn = new Tensyuugou();    //展開?}
        cn.settei(c.getTensuu(), c.getBousuu(), c.getMensuu());
        cn.set(c);


//System.out.println("?ﾜりたたみ??定001   c.getTenx(1) = "+c.getTenx(1)+"   :   cn.getTenx(1) = "+cn.getTenx(1));

        //kijyunmen_id=1;//基??になる面を指定する

        for (int i = 0; i <= c.getMensuu(); i++) {
            tonariMenid[i] = 0;
            kyoukaiBouid[i] = 0;
            iMeniti[i] = 0;
        }
//System.out.println("?ﾜりたたみ??定002   c.getTenx(1) = "+c.getTenx(1)+"   :   cn.getTenx(1) = "+cn.getTenx(1));
        //?ﾜりたたみの??備として面同士の位置関係を把握する
        System.out.println("?ﾜりたたみの??備として面同士の位置関係を把握する");
        iMeniti[kijyunmen_id] = 1;

        int imano_Meniti = 1;
        int nokori_Mensuu;
        nokori_Mensuu = c.getMensuu() - 1;

        while (nokori_Mensuu > 0) {
            for (int i = 1; i <= c.getMensuu(); i++) {
                if (iMeniti[i] == imano_Meniti) {
                    for (int j = 1; j <= c.getMensuu(); j++) {
                        int mth = c.Men_tonari_hantei(i, j);
                        if ((mth > 0) && (iMeniti[j] == 0)) {
                            iMeniti[j] = imano_Meniti + 1;
                            tonariMenid[j] = i;
                            kyoukaiBouid[j] = mth;
                        }
                    }
                }
            }

            imano_Meniti = imano_Meniti + 1;

            nokori_Mensuu = 0;
            for (int i = 1; i <= c.getMensuu(); i++) {
                if (iMeniti[i] == 0) {
                    nokori_Mensuu = nokori_Mensuu + 1;
                }
            }

            System.out.println("nokori_Mensuu = " + nokori_Mensuu);
        }


//System.out.println("?ﾜりたたみ??定004   c.getTenx(1) = "+c.getTenx(1)+"   :   cn.getTenx(1) = "+cn.getTenx(1));
        return cn;
    }


// **********************************


    private Ten sentaisyou_ten_motome(int bouid, Ten tn) {//棒のidと?A任意の点を与えて?Aidが対応する棒に対して?A与えた点の??対?ﾌになる点を返す
        return oc.sentaisyou_ten_motome(c.get_maeTen_from_Bou_id(bouid), c.get_atoTen_from_Bou_id(bouid), tn);
    }


    public int getTensuu() {
        return c.getTensuu();
    }
//	int getBousuu(){return c.getBousuu();}	
//	int getMensuu(){return c.getMensuu();}	


    //-------------------------------------------
    public void set(Tensyuugou ts) {
        settei(ts.getTensuu(), ts.getBousuu(), ts.getMensuu());
        c.settei(ts.getTensuu(), ts.getBousuu(), ts.getMensuu());
        c.set(ts);
//System.out.println("?ﾜりたたみset 001   c.getTenx(1) = "+c.getTenx(1));		

    }

    public Tensyuugou get() {
        return c;
    }

    //------------------
    public Senbunsyuugou getSenbunsyuugou() {
        Senbunsyuugou ss = new Senbunsyuugou();    //基本枝?\造のインスタンス化

        ss.setsousuu(c.getBousuu());
        for (int i = 1; i <= c.getBousuu(); i++) {
            ss.set(i, c.getTen(c.getmae(i)), c.getTen(c.getato(i)), c.getcolor(i), 0);
        }
        return ss;
    }


    //?@ここは class Tenkaizu_Syokunin  の中です

    //--------------------------------------------------------------------------
    public void Senbunsyuugou2Tensyuugou(Senbunsyuugou k) {

        //   settei(k.getsousuu(),k.getsousuu(),k.getsousuu());
        //   c.settei(k.getsousuu(),k.getsousuu(),k.getsousuu());

        Ten ti = new Ten();
        reset();

        //まず?ATensyuugou内で点を定義する?B
        System.out.println("??分?W??->点?W???F点?W?∮烽ﾅ点の定義");
        int icol;
        int flag1;
        double x, y;

        double[] addTenx = new double[k.getsousuu() + 1];//+1を加えないと面の?狽ｪ1の時にエラ?[が?oる
        double[] addTeny = new double[k.getsousuu() + 1];//+1を加えないと面の?狽ｪ1の時にエラ?[が?oる
        int addTensuu = 0;

        for (int i = 1; i <= k.getsousuu(); i++) {
            flag1 = 0;
            ti = k.geta(i);
            x = ti.getx();
            y = ti.gety();
            //	for(int j=1;j<=c.getTensuu();j++){
            //		if(oc.hitosii(ti,c.getTen(j) )){flag1=1;}
            //	}

            for (int j = 1; j <= addTensuu; j++) {
                if (oc.hitosii(ti, new Ten(addTenx[j], addTeny[j]))) {
                    flag1 = 1;
                }
            }


            if (flag1 == 0) {
                //	c.addTen(x,y);
                addTensuu = addTensuu + 1;
                addTenx[addTensuu] = x;
                addTeny[addTensuu] = y;
            }
            flag1 = 0;
            ti = k.getb(i);
            x = ti.getx();
            y = ti.gety();
            //for(int j=1;j<=c.getTensuu();j++){
            //	if(oc.hitosii(ti,c.getTen(j) )){flag1=1;}
            //}
            for (int j = 1; j <= addTensuu; j++) {
                if (oc.hitosii(ti, new Ten(addTenx[j], addTeny[j]))) {
                    flag1 = 1;
                }
            }


            if (flag1 == 0) {
                //	c.addTen(x,y);
                addTensuu = addTensuu + 1;
                addTenx[addTensuu] = x;
                addTeny[addTensuu] = y;

            }
        }

        System.out.print("点の全???@addTensuu???@");
        System.out.println(addTensuu);//System.out.println(c.getTensuu());

        //settei(addTensuu,k.getsousuu(),k.getsousuu()-addTensuu+1);//      <<ここは?A?迺ｷ?ｫ確保のためもっと余裕を??たせたほうがいいかもしれない?B
        //c.settei(addTensuu,k.getsousuu(),k.getsousuu()-addTensuu+1);//      <<ここは?A?迺ｷ?ｫ確保のためもっと余裕を??たせたほうがいいかもしれない?B

        settei(addTensuu, k.getsousuu(), k.getsousuu() - addTensuu + 100);//      <<ここは?A?迺ｷ?ｫ確保のためもっと余裕を??たせたほうがいいかもしれない?B要検討20150315
        c.settei(addTensuu, k.getsousuu(), k.getsousuu() - addTensuu + 100);//      <<ここは?A?迺ｷ?ｫ確保のためもっと余裕を??たせたほうがいいかもしれない?B要検討20150315

        for (int i = 1; i <= addTensuu; i++) {
            c.addTen(addTenx[i], addTeny[i]);

        }

        //次に?ATensyuugou内で棒を定義する?B
        System.out.println("??分?W??->点?W???F点?W?∮烽ﾅ棒の定義");

        int[] ika2ic = new int[k.getsousuu() + 1];
        int[] ikb2ic = new int[k.getsousuu() + 1];
        for (int n = 1; n <= k.getsousuu(); n++) {
            for (int i = 1; i <= c.getTensuu(); i++) {
                if (oc.hitosii(k.geta(n), c.getTen(i))) {
                    ika2ic[n] = i;
                    break;
                }
            }
            for (int i = 1; i <= c.getTensuu(); i++) {
                if (oc.hitosii(k.getb(n), c.getTen(i))) {
                    ikb2ic[n] = i;
                    break;
                }
            }

        }

        for (int n = 1; n <= k.getsousuu(); n++) {
            c.addBou(ika2ic[n], ikb2ic[n], k.getcolor(n));
        }


        System.out.print("棒の全???@???@");
        System.out.println(c.getBousuu());
        //
        System.out.println("??分?W??->点?W???F点?W?∮烽ﾅ面を発?ｶ?@開始");
        //その次に?ATensyuugou内で面を発?ｶさせる?B
        c.Menhassei();

        System.out.println("??分?W??->点?W???F点?W?∮烽ﾅ面を発?ｶ?@?I了");

    }


//----------------------------------------------------------------------------------------------------------------------------------------    

    //棒ibを境界として含む面(?ﾅ大で2面ある)のうちでMenidの?ｬさいほうのMenidを返す?B棒を境界として含む面が無い???№ﾍ0を返す
    public int Bou_moti_Menid_min_motome(int ib) {
        return c.Bou_moti_Menid_min_motome(ib);
    }

    //棒ibを境界として含む面(?ﾅ大で2面ある)のうちでMenidの大きいほうのMenidを返す?B棒を境界として含む面が無い???№ﾍ0を返す
    public int Bou_moti_Menid_max_motome(int ib) {
        return c.Bou_moti_Menid_max_motome(ib);
    }

    //?@ここは class Tenkaizu_Syokunin  の中です


    //マウス操??(ボタンを押したとき)時の??業----------------------------------------------------
    public int mPressed(Ten p, int ura_omote) {
        //マウスと近い位置にあるTenを探す?B
        Ten pn = new Ten();
        pn.set(p);
        if (ura_omote == 1) {
            pn.setx(-p.getx() + 2.0 * 700.0);
        }//裏側表示の???№ﾌ?????B
        i_ugokasuTen = c.mottomo_tikai_Tenid(pn, r * 3);
        return i_ugokasuTen;
    }

    //マウス操??(ドラッグしたとき)を?sう関??----------------------------------------------------
    public int mDragged(Ten p, int ura_omote) {


        if (i_ugokasuTen != 0) {//Tenを変?X

            Ten pn = new Ten();
            pn.set(p);
            if (ura_omote == 1) {
                pn.setx(-p.getx() + 2.0 * 700.0);
            }//裏側表示の???№ﾌ?????B
            c.set(i_ugokasuTen, pn);
        }
        return i_ugokasuTen;
    }


    //マウス操??(ボタンを離したとき)を?sう関??----------------------------------------------------
    public int mReleased(Ten p, int ura_omote) {
        int ireturn = 0;

        if (i_ugokasuTen != 0) {
            Ten pn = new Ten();
            pn.set(p);
            if (ura_omote == 1) {
                pn.setx(-p.getx() + 2.0 * 700.0);
            }//裏側表示の???№ﾌ?????B
            c.set(i_ugokasuTen, pn);
        } //Tenを変?X
        ireturn = i_ugokasuTen;
        i_ugokasuTen = 0;
        return ireturn;

    }


//マウス操?? with camera

    //マウス操??(ボタンを押したとき)時の??業----------------------------------------------------


    public int mPressed_with_camera(Ten p0, int ip4) {
        Ten p = new Ten();
        if (ip4 == 0) {
            p.set(cam_omote.TV2object(p0));
        }
        if (ip4 == 1) {
            p.set(cam_ura.TV2object(p0));
        }


        //マウスと近い位置にあるTenを探す?B
        //Ten pn = new Ten(); pn.set(p);
        //i_ugokasuTen=c.mottomo_tikai_Tenid(pn,r*3);

        i_ugokasuTen = c.mottomo_tikai_Tenid(p, r * 3);
        return i_ugokasuTen;
    }


    //マウス操??(ドラッグしたとき)を?sう関??----------------------------------------------------

/*
	public int mDragged_with_camera(Ten p0,int ip4) {   

		Ten p =new Ten(); 
		if(ip4==0){	p.set(cam_omote.TV2object(p0));}
		if(ip4==1){	p.set(cam_ura.TV2object(p0));}
		

		if(i_ugokasuTen!=0){//Tenを変?X
                	//Ten pn = new Ten(); pn.set(p); 
			//c.set(i_ugokasuTen,pn);
			c.set(i_ugokasuTen,p);
		} 
		return i_ugokasuTen;
	}
*/

    //--------------------------------------------------
    public void mDragged_sentakuten_ugokasi_with_camera(Ten p0, int ip4) {   //選択された点を動かす

        Ten p = new Ten();
        if (ip4 == 0) {
            p.set(cam_omote.TV2object(p0));
        }
        if (ip4 == 1) {
            p.set(cam_ura.TV2object(p0));
        }

        c.sentaku_ten_move(p);
/*
		if(i_ugokasuTen!=0){//Tenを変?X
                	//Ten pn = new Ten(); pn.set(p); 
			//c.set(i_ugokasuTen,pn);
			c.set(i_ugokasuTen,p);
		} 
		//return i_ugokasuTen;

*/
    }


    //--------------------------------------------------
    public void mDragged_sentakuten_ugokasi_with_camera(Ten ugokasu_maeno_sentaku_ten, Ten p0, Ten p1, int ip4) {   //選択された点を動かす

        Ten pa = new Ten();
        if (ip4 == 0) {
            pa.set(cam_omote.TV2object(p0));
        }
        if (ip4 == 1) {
            pa.set(cam_ura.TV2object(p0));
        }

        Ten pb = new Ten();
        if (ip4 == 0) {
            pb.set(cam_omote.TV2object(p1));
        }
        if (ip4 == 1) {
            pb.set(cam_ura.TV2object(p1));
        }


        Ten p_u = new Ten();
        p_u.set(ugokasu_maeno_sentaku_ten.getx(), ugokasu_maeno_sentaku_ten.gety());
        p_u.idou(pa.tano_Ten_iti(pb));

        c.sentaku_ten_move(p_u);


    }

    //--------------------------------------------------
    public void mReleased_sentakuten_ugokasi_with_camera(Ten ugokasu_maeno_sentaku_ten, Ten p0, Ten p1, int ip4) {   //選択された点を動かす

        Ten pa = new Ten();
        if (ip4 == 0) {
            pa.set(cam_omote.TV2object(p0));
        }
        if (ip4 == 1) {
            pa.set(cam_ura.TV2object(p0));
        }

        Ten pb = new Ten();
        if (ip4 == 0) {
            pb.set(cam_omote.TV2object(p1));
        }
        if (ip4 == 1) {
            pb.set(cam_ura.TV2object(p1));
        }


        Ten p_u = new Ten();
        p_u.set(ugokasu_maeno_sentaku_ten.getx(), ugokasu_maeno_sentaku_ten.gety());
        p_u.idou(pa.tano_Ten_iti(pb));

        c.sentaku_ten_move(p_u);


    }

    //マウス操??(ボタンを離したとき)を?sう関??----------------------------------------------------


    public int mReleased_with_camera(Ten p0, int ip4) {

        Ten p = new Ten();
        if (ip4 == 0) {
            p.set(cam_omote.TV2object(p0));
        }
        if (ip4 == 1) {
            p.set(cam_ura.TV2object(p0));
        }


        int ireturn = 0;

        if (i_ugokasuTen != 0) {
            //Ten pn = new Ten(); pn.set(p);
            //c.set(i_ugokasuTen,pn);
            c.set(i_ugokasuTen, p);

        } //Tenを変?X


        ireturn = i_ugokasuTen;
        i_ugokasuTen = 0;
        return ireturn;
    }

// -----------------------

    public void mReleased_sentakuten_ugokasi_with_camera(Ten p0, int ip4) {

        Ten p = new Ten();
        if (ip4 == 0) {
            p.set(cam_omote.TV2object(p0));
        }
        if (ip4 == 1) {
            p.set(cam_ura.TV2object(p0));
        }


        c.sentaku_ten_move(p);

        //	if(i_ugokasuTen!=0){
//			c.set(i_ugokasuTen,p); 
//		} //Tenを変?X

//                i_ugokasuTen=0;
    }


    //?}をかく?ﾛの?白l変換用関??-----------------------------------------------------------------

    public int gx(double d) {
        return (int) d;
    }

    public int gy(double d) {
        return (int) d;
    }

    //展開?}の描画-----------------------------------------------------------------

    //?@ここは class Tenkaizu_Syokunin  の中です

    public void oekaki(Graphics g) {
        String text = "";//文字列????用のクラスのインスタンス化
        //int ir=(int)r;
        //	for (int i=1; i<=c.getTensuu(); i++ ){ g.drawOval( gx(c.getTenx(i)-r),gy(c.getTeny(i)-r),2*ir,2*ir);} //円
        //	for (int i=1; i<=c.getTensuu(); i++ ){ g.drawOval( gx(tnew[i].getx()-r),gy(tnew[i].gety()-r),2*ir,2*ir);} //円
        g.setColor(Color.black);
        //	for (int i=1; i<=c.getTensuu(); i++ ){ g.drawString( text.valueOf(i),gx(c.getTenx(i)),gy(c.getTeny(i)));}
        for (int i = 1; i <= c.getBousuu(); i++) {
            if (c.getcolor(i) == 0) {
                g.setColor(Color.black);
            }
            if (c.getcolor(i) == 1) {
                g.setColor(Color.red);
            }
            if (c.getcolor(i) == 2) {
                g.setColor(Color.blue);
            }
            g.drawLine(gx(c.getmaex(i)), gy(c.getmaey(i)), gx(c.getatox(i)), gy(c.getatoy(i))); //直??
            //g.drawLine( gx(tnew[c.getmae(i)].getx()),gy(tnew[c.getmae(i)].gety()), gx(tnew[c.getato(i)].getx()),gy(tnew[c.getato(i)].gety())); //直??
        }
    }


    //展開?}の描画 with camera-----------------------------------------------------------------

    public void oekaki_with_camera(Graphics g) {
//System.out.println("?ﾜりたたみ oekaki 001   c.getTenx(1) = "+c.getTenx(1));	
        Senbun s_tv = new Senbun();
        String text = "";//文字列????用のクラスのインスタンス化
        g.setColor(Color.black);
        for (int i = 1; i <= c.getBousuu(); i++) {
            if (c.getcolor(i) == 0) {
                g.setColor(Color.black);
            }
            if (c.getcolor(i) == 1) {
                g.setColor(Color.red);
            }
            if (c.getcolor(i) == 2) {
                g.setColor(Color.blue);
            }

            s_tv.set(camera.object2TV(c.get_Senbun_from_Bou_id(i)));

            g.drawLine(gx(s_tv.getax()), gy(s_tv.getay()), gx(s_tv.getbx()), gy(s_tv.getby())); //直??
        }
    }

    // ------------------------------
    public void oekaki_Ten_id_with_camera(Graphics g, int i) {    //点を描く
        Ten tn = new Ten();
        tn.set(camera.object2TV(c.getTen(i)));
        int ir = 7;//半径
        g.setColor(new Color(0, 255, 255, 100));//???F
        g.fillOval(gx(tn.getx()) - ir, gy(tn.gety()) - ir, 2 * ir, 2 * ir); //円
    }

    // ------------------------------
    public void oekaki_Ten_id_with_camera_green(Graphics g, int i) {    //点を描く
        Ten tn = new Ten();
        tn.set(camera.object2TV(c.getTen(i)));
        int ir = 15;//半径
        g.setColor(new Color(0, 255, 0, 100));//緑?F
        g.fillOval(gx(tn.getx()) - ir, gy(tn.gety()) - ir, 2 * ir, 2 * ir); //円
    }


//g.setColor(Color.cyan);


    public void oekaki_Ten_id_with_camera(Graphics g, int i, int ip4) {
        //点を描く
        Ten tn = new Ten();
        tn.set(camera.object2TV(c.getTen(i)));
        int ir = 10;//半径
        g.setColor(new Color(0, 255, 0, 50));//緑?F

        if (ip4 == 0) {
            tn.set(cam_omote.object2TV(c.getTen(i)));
            g.fillOval(gx(tn.getx()) - ir, gy(tn.gety()) - ir, 2 * ir, 2 * ir); //円
        }
        if (ip4 == 1) {
            tn.set(cam_ura.object2TV(c.getTen(i)));
            g.fillOval(gx(tn.getx()) - ir, gy(tn.gety()) - ir, 2 * ir, 2 * ir); //円
        }
        if ((ip4 == 2) || (ip4 == 3)) {
            tn.set(cam_omote.object2TV(c.getTen(i)));
            g.fillOval(gx(tn.getx()) - ir, gy(tn.gety()) - ir, 2 * ir, 2 * ir); //円
            tn.set(cam_ura.object2TV(c.getTen(i)));
            g.fillOval(gx(tn.getx()) - ir, gy(tn.gety()) - ir, 2 * ir, 2 * ir); //円
        }

    }


    public void oekaki_with_camera(Graphics g, int ip4) {

        Senbun s_tv = new Senbun();
        String text = "";//文字列????用のクラスのインスタンス化
        g.setColor(Color.black);
        for (int i = 1; i <= c.getBousuu(); i++) {
            if (c.getcolor(i) == 0) {
                g.setColor(Color.black);
            }
            if (c.getcolor(i) == 1) {
                g.setColor(Color.red);
            }
            if (c.getcolor(i) == 2) {
                g.setColor(Color.blue);
            }

            if (ip4 == 0) {
                s_tv.set(cam_omote.object2TV(c.get_Senbun_from_Bou_id(i)));
                g.drawLine(gx(s_tv.getax()), gy(s_tv.getay()), gx(s_tv.getbx()), gy(s_tv.getby())); //直??
            }
            if (ip4 == 1) {
                s_tv.set(cam_ura.object2TV(c.get_Senbun_from_Bou_id(i)));
                g.drawLine(gx(s_tv.getax()), gy(s_tv.getay()), gx(s_tv.getbx()), gy(s_tv.getby())); //直??
            }
            if ((ip4 == 2) || (ip4 == 3)) {
                s_tv.set(cam_omote.object2TV(c.get_Senbun_from_Bou_id(i)));
                g.drawLine(gx(s_tv.getax()), gy(s_tv.getay()), gx(s_tv.getbx()), gy(s_tv.getby())); //直??
                s_tv.set(cam_ura.object2TV(c.get_Senbun_from_Bou_id(i)));
                g.drawLine(gx(s_tv.getax()), gy(s_tv.getay()), gx(s_tv.getbx()), gy(s_tv.getby())); //直??
            }


            //g.drawLine( gx(s_tv.getax()),gy(s_tv.getay()),gx(s_tv.getbx()),gy(s_tv.getby())); //直??
        }
    }


    public void oekaki_kijyunmen_id_with_camera(Graphics g) {
        //面内部の点を描く
        Ten tn = new Ten();
        //tn.reset();
        tn.set(camera.object2TV(ten_of_kijyunmen_ob));

        g.setColor(new Color(200, 50, 255, 90));
        g.fillOval(gx(tn.getx()) - 50, gy(tn.gety()) - 50, 100, 100); //円

        g.setColor(Color.yellow);
        g.fillOval(gx(tn.getx()) - 5, gy(tn.gety()) - 5, 10, 10); //円
        g.setColor(Color.black);
        g.drawOval(gx(tn.getx()) - 5, gy(tn.gety()) - 5, 10, 10); //円
        g.setColor(Color.black);

    }


    //---------------------------------------------------
    public void Ten_awase(double r) {
        c.Ten_awase(r);
    }

    public void Ten_Bou_awase(double r) {
        c.Ten_Bou_awase(r);
    }

    //-------------------------------------------------


    public int get_ten_sentakusuu() {
        return c.get_ten_sentakusuu();
    }


    //--------------------
    public void set_ten_sentaku_1(int i) {
        c.set_ten_sentaku_1(i);
    }

    //--------------------
    public void set_ten_sentaku_0(int i) {
        c.set_ten_sentaku_0(i);
    }

    //--------------------
    public void set_all_ten_sentaku_0() {
        c.set_all_ten_sentaku_0();
    }

    //--------------------
    public void change_ten_sentaku(int i) {
        c.change_ten_sentaku(i);
    }

    //--------------------
    public byte get_ten_sentaku(int i) {
        return c.get_ten_sentaku(i);
    }//i番目の点の選択?ﾔが０か１かを得る

    //-----------------uuuuuuu---


    double d_h_k = 10.0;//一定の距離より近い近傍かの判定距離

    //与えられた?ﾀ標と一定の距離より近い近傍にあって?Aかつ?ﾅも近い点の番??を返す?Bもし?A一定の距離以内にTenがないなら0を返す?B
    public int mottomo_tikai_Tenid_with_camera(Ten p0) {//展開?}用
        Ten p = new Ten();
        p.set(camera.TV2object(p0));

        return c.mottomo_tikai_Tenid(p, d_h_k / camera.get_camera_bairitsu_x());
    }


    //与えられた?ﾀ標と一定の距離より近い近傍にあって?Aかつ?ﾅも近い点の番??を返す?Bもし?A一定の距離以内にTenがないなら0を返す?B
    public int mottomo_tikai_Tenid_with_camera(Ten p0, int ip4) {//?ﾜり?繧ｪり?}用
        Ten p = new Ten();
        if (ip4 == 0) {
            p.set(cam_omote.TV2object(p0));
            return c.mottomo_tikai_Tenid(p, d_h_k / cam_omote.get_camera_bairitsu_x());
        }
        if (ip4 == 1) {
            p.set(cam_ura.TV2object(p0));
            return c.mottomo_tikai_Tenid(p, d_h_k / cam_ura.get_camera_bairitsu_x());
        }
        return 0;
    }


    //--------------------

    //与えられた?ﾀ標と一定の距離より近い近傍にあって?Aかつ?ﾅも近い点の距離を返す?Bもし?A一定の距離以内にTenがないなら1000000.0を返す?B
    public double mottomo_tikai_Ten_kyori_with_camera(Ten p0) {//p0はTV?ﾀ標?Bリタ?[ンされるのはobでの距離
        Ten p = new Ten();
        p.set(camera.TV2object(p0));
        return c.mottomo_tikai_Ten_kyori(p, d_h_k / camera.get_camera_bairitsu_x());
    }


    //与えられた?ﾀ標と一定の距離より近い近傍にあって?Aかつ?ﾅも近い点の距離を返す?Bもし?A一定の距離以内にTenがないなら1000000.0を返す?B
    public double mottomo_tikai_Ten_kyori_with_camera(Ten p0, int ip4) {//p0はTV?ﾀ標?Bリタ?[ンされるのはobでの距離
        Ten p = new Ten();
        if (ip4 == 0) {
            p.set(cam_omote.TV2object(p0));
            return c.mottomo_tikai_Ten_kyori(p, d_h_k / cam_omote.get_camera_bairitsu_x());
        }
        if (ip4 == 1) {
            p.set(cam_ura.TV2object(p0));
            return c.mottomo_tikai_Ten_kyori(p, d_h_k / cam_ura.get_camera_bairitsu_x());
        }
        return 1000000.0;
    }

    // ------------------------------
    public Ten getTen(int i) {
        return c.getTen(i);
    }


    // ---------------------------------------------------------------------------------------------
    public void set_Ubox_undo_suu(int i) {
        Ubox.set_i_undo_suu(i);
    }

//String s_title=new String(); //フレ?[ムの?ﾅ?纈[に?oてくるタイトルを保??するために使用

    public void kiroku() {
        Ubox.kiroku(getMemo());
    }


    public void undo() {
        setMemo_for_redo_undo(Ubox.undo());

    }


    public void redo() {
        setMemo_for_redo_undo(Ubox.redo());


    }


    public Memo getMemo() {
        return c.getMemo();
    }


    public void setMemo_for_redo_undo(Memo memo1) {//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<undo,redoでのkiroku復元用

        c.setMemo(memo1);
    }


//?ﾜり?繧ｪり?}変形で変?Xされるのは?@c.sentaku_ten_move(p_u);cはTensyuugou


}   //?@ class Tenkaizu_Syokunin  はここまでです