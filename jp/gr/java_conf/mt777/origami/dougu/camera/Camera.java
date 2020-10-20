package jp.gr.java_conf.mt777.origami.dougu.camera;

//import java.util.*;

import jp.gr.java_conf.mt777.zukei2d.senbun.Senbun;

public class Camera {//ŽÀ?Û‚Ì?À•W‚Æ?A•\Ž¦?À•W‚Ì’‡—§‚¿

    //int camera_id;//camera‚ÌŽ¯•Ê—p?B–¼‘O‚Ì•Ï‚í‚è‚ÉŽg‚¤‚¾‚¯

    double camera_ichi_x, camera_ichi_y;
    double camera_kakudo;
    double camera_kagami; //-1.0‚©1.0‚Ì‚Ç‚¿‚ç‚©?@xŽ²‚¾‚¯•„?†‚ð•Ï‚¦‚é       //‹¾
    double camera_bairitsu_x;
    double camera_bairitsu_y;
    double hyouji_ichi_x, hyouji_ichi_y;

    double do2rad, rad2do;
    double camera_rad;
    double sin_rad, cos_rad;


    public Camera() {//ƒRƒ“ƒXƒgƒ‰ƒNƒ^

        //camera_id=0;
        do2rad = 3.14159265 / 180.0;
        rad2do = 180.0 / 3.14159265;
        camera_ichi_x = 0.0;
        camera_ichi_y = 0.0;
        camera_kakudo = 0.0;
        camera_rad = camera_kakudo * do2rad;
        sin_rad = Math.sin(camera_rad);
        cos_rad = Math.cos(camera_rad);
        camera_kagami = 1.0;       //‹¾
        camera_bairitsu_x = 1.0;
        camera_bairitsu_y = 1.0;

        hyouji_ichi_x = 0.0;
        hyouji_ichi_y = 0.0;
    }

    /*
        public Camera(double cx,double cy,double b_x,double b_y,double k,double hx,double hy){//ƒRƒ“ƒXƒgƒ‰ƒNƒ^
            do2rad=3.14159265/180.0;
            rad2do=180.0/3.14159265;
            camera_ichi_x=cx;
            camera_ichi_y=cy;
            camera_bairitsu_x=b_x;camera_bairitsu_y=b_y;
            camera_kakudo=k;camera_rad=camera_kakudo*do2rad;  sin_rad=Math.sin(camera_rad);  cos_rad=Math.cos(camera_rad);
            hyouji_ichi_x=hx;
            hyouji_ichi_y=hy;
        }
    */
    public void reset() {
        //camera_id=0;

        camera_ichi_x = 0.0;
        camera_ichi_y = 0.0;
        camera_kakudo = 0.0;
        camera_rad = camera_kakudo * do2rad;
        sin_rad = Math.sin(camera_rad);
        cos_rad = Math.cos(camera_rad);
        camera_kagami = 1.0;       //‹¾
        camera_bairitsu_x = 1.0;
        camera_bairitsu_y = 1.0;

        hyouji_ichi_x = 0.0;
        hyouji_ichi_y = 0.0;
    }

    //public void set_camera_id(int i){camera_id=i;}
    public void set_camera_ichi_x(double d) {
        camera_ichi_x = d;
    }

    public void set_camera_ichi_y(double d) {
        camera_ichi_y = d;
    }

    public void set_camera_kakudo(double d) {
        camera_kakudo = d;
        camera_rad = camera_kakudo * do2rad;
        sin_rad = Math.sin(camera_rad);
        cos_rad = Math.cos(camera_rad);
    }

    public void set_camera_kagami(double d) {
        camera_kagami = d;
    }       //‹¾

    public void set_camera_bairitsu_x(double d) {
        camera_bairitsu_x = d;
    }

    public void set_camera_bairitsu_y(double d) {
        camera_bairitsu_y = d;
    }

    public void kakezan_camera_bairitsu_x(double d) {
        camera_bairitsu_x = d * camera_bairitsu_x;
    }

    public void kakezan_camera_bairitsu_y(double d) {
        camera_bairitsu_y = d * camera_bairitsu_y;
    }


    public void set_hyouji_ichi_x(double d) {
        hyouji_ichi_x = d;
    }

    public void set_hyouji_ichi_y(double d) {
        hyouji_ichi_y = d;
    }


    //public int get_camera_id(){return camera_id;}

    public void set_camera(Camera c0) {
        double d_camera_ichi_x = c0.get_camera_ichi_x();
        double d_camera_ichi_y = c0.get_camera_ichi_y();
        double d_camera_kakudo = c0.get_camera_kakudo();
        double d_camera_kagami = c0.get_camera_kagami();
        double d_camera_bairitsu_x = c0.get_camera_bairitsu_x();
        double d_camera_bairitsu_y = c0.get_camera_bairitsu_y();

        double d_hyouji_ichi_x = c0.get_hyouji_ichi_x();
        double d_hyouji_ichi_y = c0.get_hyouji_ichi_y();

        set_camera_ichi_x(d_camera_ichi_x);
        set_camera_ichi_y(d_camera_ichi_y);
        set_camera_kakudo(d_camera_kakudo);
        set_camera_kagami(d_camera_kagami);
        set_camera_bairitsu_x(d_camera_bairitsu_x);
        set_camera_bairitsu_y(d_camera_bairitsu_y);

        set_hyouji_ichi_x(d_hyouji_ichi_x);
        set_hyouji_ichi_y(d_hyouji_ichi_y);
    }


    public void hyouji() {//ŠeŽíƒpƒ‰ƒ??[ƒ^‚ð•\Ž¦‚·‚é

        System.out.println("camera.hyouji() VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV ");
        System.out.println("camera_ichi_x = " + camera_ichi_x);
        System.out.println("camera_ichi_y = " + camera_ichi_y);
        System.out.println("camera_kakudo = " + camera_kakudo);
        System.out.println("camera_kagami = " + camera_kagami);
        System.out.println("camera_bairitsu_x = " + camera_bairitsu_x);
        System.out.println("camera_bairitsu_y = " + camera_bairitsu_y);

        System.out.println("hyouji_ichi_x = " + hyouji_ichi_x);
        System.out.println("hyouji_ichi_y = " + hyouji_ichi_y);
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA ");
    }


    public double get_camera_ichi_x() {
        return camera_ichi_x;
    }

    public double get_camera_ichi_y() {
        return camera_ichi_y;
    }

    public double get_camera_kakudo() {
        return camera_kakudo;
    }

    public double get_camera_kagami() {
        return camera_kagami;
    }       //‹¾

    public double get_camera_bairitsu_x() {
        return camera_bairitsu_x;
    }

    public double get_camera_bairitsu_y() {
        return camera_bairitsu_y;
    }

    public double get_hyouji_ichi_x() {
        return hyouji_ichi_x;
    }

    public double get_hyouji_ichi_y() {
        return hyouji_ichi_y;
    }

    public void set_camera_ichi(Ten p) {
        set_camera_ichi_x(p.getx());
        set_camera_ichi_y(p.gety());
    }

    public void set_hyouji_ichi(Ten p) {
        set_hyouji_ichi_x(p.getx());
        set_hyouji_ichi_y(p.gety());
    }


    public Ten get_camera_ichi() {
        Ten t_ichi = new Ten();
        t_ichi.setx(camera_ichi_x);
        t_ichi.sety(camera_ichi_y);
        return t_ichi;
    }


    public Ten object2TV(Ten t_ob) {
        Ten t_tv = new Ten();
        double x1, y1;
        double x2, y2;
        x1 = t_ob.getx() - camera_ichi_x;
        y1 = t_ob.gety() - camera_ichi_y;
        x2 = cos_rad * x1 + sin_rad * y1;
        y2 = -sin_rad * x1 + cos_rad * y1;

        //x2= Math.cos(camera_rad)*x1+Math.sin(camera_rad)*y1;
        //y2=-Math.sin(camera_rad)*x1+Math.cos(camera_rad)*y1;
        //System.out.println("camera_id =  "+  camera_id   +"   :in object2TV camera_kagami     =   "+camera_kagami);
        x2 = x2 * camera_kagami;       //‹¾


        x2 = x2 * camera_bairitsu_x;
        y2 = y2 * camera_bairitsu_y;
        t_tv.setx(x2 + hyouji_ichi_x);
        t_tv.sety(y2 + hyouji_ichi_y);
        return t_tv;
    }


    public Senbun object2TV(Senbun s_ob) {
        Senbun s_tv = new Senbun();
        s_tv.set(s_ob);
        s_tv.seta(object2TV(s_ob.geta()));
        s_tv.setb(object2TV(s_ob.getb()));
        return s_tv;
    }


    public Ten TV2object(Ten t_tv) {
        Ten t_ob = new Ten();
        double x1, y1;
        double x2, y2;
        x1 = t_tv.getx();
        y1 = t_tv.gety();
        x1 = x1 - hyouji_ichi_x;
        y1 = y1 - hyouji_ichi_y;
        x1 = x1 / camera_bairitsu_x;
        y1 = y1 / camera_bairitsu_y;

        x1 = x1 * camera_kagami;       //‹¾

        x2 = cos_rad * x1 - sin_rad * y1;
        y2 = sin_rad * x1 + cos_rad * y1;


        //x2= Math.cos(camera_rad)*x1-Math.sin(camera_rad)*y1;
        //y2= Math.sin(camera_rad)*x1+Math.cos(camera_rad)*y1;
        t_ob.setx(x2 + camera_ichi_x);
        t_ob.sety(y2 + camera_ichi_y);
        return t_ob;
    }

    public Senbun TV2object(Senbun s_tv) {
        Senbun s_ob = new Senbun();
        s_ob.set(s_tv);
        s_ob.seta(TV2object(s_tv.geta()));
        s_ob.setb(TV2object(s_tv.getb()));
        return s_ob;
    }

    public void hyouji_ichi_idou(Ten tuika) {
        hyouji_ichi_x = hyouji_ichi_x + tuika.getx();
        hyouji_ichi_y = hyouji_ichi_y + tuika.gety();
    }

    //TV?ã‚Ì•\Ž¦‚Í•Ï‰»‚µ‚È‚¢‚æ‚¤‚É‚µ‚Ä?ATV?ã‚Ì?À•WTen?@P?@‚É‘Î‰ž‚·‚é?A”íŽÊ‘Ì‚ÌˆÊ’u‚ÉcameraˆÊ’u‚ð‚ ‚í‚¹‚é?B
    public void camera_ichi_sitei_from_TV(Ten p) {

        set_camera_ichi(TV2object(p));
        set_hyouji_ichi(p);

    }


}