package jp.gr.java_conf.mt777.zukei2d.oritacalc;

import jp.gr.java_conf.mt777.zukei2d.en.En;
import jp.gr.java_conf.mt777.zukei2d.oritacalc.tyokusen.Tyokusen;
import jp.gr.java_conf.mt777.zukei2d.senbun.Senbun;
import jp.gr.java_conf.mt777.zukei2d.ten.Ten;

import java.math.BigDecimal;

public class OritaCalc {


    //d2s ダブルをストリングに変える?@?ｬ?箔_2桁目で四捨五入("");ｄ２ｓ
    public String d2s(double d0) {
        BigDecimal bd = new BigDecimal(d0);

        //?ｬ?泊?2位で四捨五入
        BigDecimal bd1 = bd.setScale(1, BigDecimal.ROUND_HALF_UP);

        String sr = "";
        sr = bd1.toString();
        return sr;
    }


    //ただのSystem.out.println("String");
    public void hyouji(String s0) {
        System.out.println(s0);
    }


    //直??t?繧ﾌ点pの影の位置?i点pと?ﾅも近い直??t?繧ﾌ位置?jを??める?B
    public Ten kage_motome(Tyokusen t, Ten p) {

        Tyokusen t1 = new Tyokusen();
        t1.set(t);
        t1.tyokkouka(p);//点p1を通って tに直?sする直??u1を??める?B
        return kouten_motome(t, t1);
    }

    //点P0とP1を通る直??t?繧ﾌ点pの影の位置?i点pと?ﾅも近い直??t?繧ﾌ位置?jを??める?B
    public Ten kage_motome(Ten p0, Ten p1, Ten p) {
        Tyokusen t = new Tyokusen(p0, p1);
        return kage_motome(t, p);
    }

    //??分s0を含む直??t?繧ﾌ点pの影の位置?i点pと?ﾅも近い直??t?繧ﾌ位置?jを??める?B
    public Ten kage_motome(Senbun s0, Ten p) {
        return kage_motome(s0.geta(), s0.getb(), p);
    }


    //2つの点が同じ位置(true)か異なる(false)か判定する関??----------------------------------
    public boolean hitosii(Ten p1, Ten p2) {
        return hitosii(p1, p2, 0.1);//ここで誤?ｷが定義されている?B
    }

    public boolean hitosii(Ten p1, Ten p2, double r) {//rは誤?ｷの許容度?Brが負なら厳密判定?B

        //厳密に判定?B
        if (r <= 0.0) {
            if ((p1.getx() == p2.getx()) && (p1.gety() == p2.gety())) {
                return true;
            }
        }
        //誤?ｷを許容?B
        if (r > 0) {
            return kyori(p1, p2) <= r;
        }
        return false;
    }

    //２点間の距離?i?ｮ???jを??める関??----------------------------------------------------
    public double kyori(Ten p0, Ten p1) {
        return p0.kyori(p1);
    }

    /*
	public double kyori(Ten p0,Ten p1){
		double x0=p0.getx(),y0=p0.gety();
		double x1=p1.getx(),y1=p1.gety();
		return Math.sqrt((x1-x0)*(x1-x0)+(y1-y0)*(y1-y0));
	}
*/
    //２点間a,bを指定して?Aベクトルabとx軸のなす角度を??める関???Bもしa=bなら-10000.0を返す----------------------------------------------------
    public double kakudo(Ten a, Ten b) {
        double ax, ay, bx, by, x, y, L, c, ret;
        ax = a.getx();
        ay = a.gety();
        bx = b.getx();
        by = b.gety();
        x = bx - ax;
        y = by - ay;
        L = Math.sqrt(x * x + y * y);
        if (L <= 0.0) {
            return -10000.0;
        }
        c = x / L;
        if (c > 1.0) {
            c = 1.0;
        }

        ret = Math.acos(c);
        if (y < 0.0) {
            ret = -ret;
        }
        ret = 180.0 * ret / Math.PI;
        if (ret < 0) {
            ret = ret + 360.0;
        }
        return ret;
    }


    //??分を指定して?Aベクトルabとx軸のなす角度を??める関???Bもしa=bなら-10000.0を返す----------------------------------------------------
    public double kakudo(Senbun s) {
        return kakudo(s.geta(), s.getb());
    }

    //??分を指定して?Aベクトルabとx軸のなす角度を??める関???Bもしa=bなら-10000.0を返す----------------------------------------------------
    public double kakudozure(Senbun s, double a) {
        double b;//実?ﾛの角度をaで割った時の?阯]
        b = kakudo(s) % a;
        if (a - b < b) {
            b = a - b;
        }
        return b;
    }

    //点paが?A二点p1,p2を端点とする??分に点p1と点p2で直?sする?A2つの??分を含む長方形内にある???№ﾍ2を返す関??
    public int hakononaka(Ten p1, Ten pa, Ten p2) {
        Tyokusen t = new Tyokusen(p1, p2);//p1,p2を通る直??tを??める?B
        Tyokusen u1 = new Tyokusen(p1, p2);
        u1.tyokkouka(p1);//点p1を通って tに直?sする直??u1を??める?B
        Tyokusen u2 = new Tyokusen(p1, p2);
        u2.tyokkouka(p2);//点p2を通って tに直?sする直??u2を??める?B

        if (u1.dainyuukeisan(pa) * u2.dainyuukeisan(pa) == 0.0) {
            return 1;
        }
        if (u1.dainyuukeisan(pa) * u2.dainyuukeisan(pa) < 0.0) {
            return 2;
        }
        return 0;//箱の外部にある????
    }


    //点paが?A二点p1,p2を端点とする??分に点p1と点p2で直?sする?A2つの??分を含む長方形内にある???№ﾍ2を返す関???Bこれは ?ｭしはみ?oしても長方形内にあるとみなす?B
    //具体的には??分の中に点があるかの判定の?ﾛ?Aわずかに点が??分の外にある???№ﾍ?A??分の中にあると?A甘く判定する?B描き?E?lで展開?}を描くときは?Aこの甘いほうを使わないとT字型の??分の交?ｷ分割に失敗する
    //しかし?Aなぜか?A?ﾜり?ﾝ??定にこの甘いほうを使うと無限ル?[プになるようで?Aうまくいかない?Bこの?ｳ確な解明は未解決20161105
    public int hakononaka_amai(Ten p1, Ten pa, Ten p2) {
        Tyokusen t = new Tyokusen(p1, p2);//p1,p2を通る直??tを??める?B
        Tyokusen u1 = new Tyokusen(p1, p2);
        u1.tyokkouka(p1);//点p1を通って tに直?sする直??u1を??める?B
        Tyokusen u2 = new Tyokusen(p1, p2);
        u2.tyokkouka(p2);//点p2を通って tに直?sする直??u2を??める?B

        //if(u1.dainyuukeisan(pa)*u2.dainyuukeisan(pa) ==0.0){return 1;}

        if (u1.kyorikeisan(pa) < 0.00001) {
            return 1;
        }
        if (u2.kyorikeisan(pa) < 0.00001) {
            return 1;
        }

        if (u1.dainyuukeisan(pa) * u2.dainyuukeisan(pa) < 0.0) {
            return 2;
        }
        return 0;//箱の外部にある????
    }


    //点pが指定された??分とどの部?鰍ﾅ近い(r以内)かどうかを判定する関???@---------------------------------
    //0=近くない?A1=a点に近い?A2=b点に近い?A3=柄の部分に近い
    public int senbun_busyo_sagasi(Ten p, Senbun s0, double r) {
        if (r > kyori(p, s0.geta())) {
            return 1;
        }//a点に近いかどうか
        if (r > kyori(p, s0.getb())) {
            return 2;
        }//b点に近いかどうか
        if (r > kyori_senbun(p, s0)) {
            return 3;
        }//柄の部分に近いかどうか
        return 0;
    }


    //点p0と?A二点p1,p2を両端とする??分との間の距離を??める関??----------------------------------------------------
    public double kyori_senbun(Ten p0, Ten p1, Ten p2) {
        // Ten p1 = new Ten();   p1.set(s.geta());
        // Ten p2 = new Ten();   p2.set(s.getb());

        //p1とp2が同じ????
        if (kyori(p1, p2) == 0.0) {
            return kyori(p0, p1);
        }

        //p1とp2が異なる????
        Tyokusen t = new Tyokusen(p1, p2);//p1,p2を通る直??tを??める?B
        Tyokusen u = new Tyokusen(p1, p2);
        u.tyokkouka(p0);//点p0を通って tに直?sする直??uを??める?B

        if (hakononaka(p1, kouten_motome(t, u), p2) >= 1) {
            return t.kyorikeisan(p0);
        }//tとuの交点がp1とp2の間にある?????B
        return Math.min(kyori(p0, p1), kyori(p0, p2));//tとuの交点がp1とp2の間にない?????B
    }

    //点p0と?A??分sとの間の距離を??める関??----------------------------------------------------
    public double kyori_senbun(Ten p0, Senbun s) {
        Ten p1 = new Ten();
        p1.set(s.geta());
        Ten p2 = new Ten();
        p2.set(s.getb());
        return kyori_senbun(p0, p1, p2);
    }

    //２つの??分が?A交?ｷするかどうかを判定する関??----------------------------------------------------
    // 0=交?ｷしない?A?@
    // 1=２つの??分が平?sでなく?A一点で?\字路型で交?ｷする?A
    // 2番代=２つの??分が平?sでなく?A一点でＴ字路型またはくの字型で交?ｷする
    // 3=２つの??分が平?sで?A交?ｷする
    // 4=??分s1と??分s2が点で?A交?ｷする
    // 5=??分s1が点で?A交?ｷする
    // 6=??分s2が点で?A交?ｷする
    //??意?Ip1とp2が同じ?Aまたはp3とp4が同じ???№ﾍ結果がおかしくなるがが?A
    //この関?博ｩ体にはチェック機?\をつけていないので?A気づきにくいことがある?B
    public int senbun_kousa_hantei(Senbun s1, Senbun s2) {
        //return senbun_kousa_hantei( s1,s2,0.001,0.001) ;
        return senbun_kousa_hantei(s1, s2, 0.01, 0.01);

        //return senbun_kousa_hantei( s1,s2,0.000001,0.000001) ;
    }


    public int senbun_kousa_hantei_amai(Senbun s1, Senbun s2) {
        //return senbun_kousa_hantei_amai( s1,s2,0.000001,0.000001) ;
        return senbun_kousa_hantei_amai(s1, s2, 0.01, 0.01);
    }


    public int senbun_kousa_hantei(Senbun s1, Senbun s2, double rhit, double rhei) {    //r_hitosiiとr_heikouhanteiは?Ahitosiiとheikou_hanteiのずれの許容程度
        double x1max = s1.getax();
        double x1min = s1.getax();
        double y1max = s1.getay();
        double y1min = s1.getay();
        if (x1max < s1.getbx()) {
            x1max = s1.getbx();
        }
        if (x1min > s1.getbx()) {
            x1min = s1.getbx();
        }
        if (y1max < s1.getby()) {
            y1max = s1.getby();
        }
        if (y1min > s1.getby()) {
            y1min = s1.getby();
        }
        double x2max = s2.getax();
        double x2min = s2.getax();
        double y2max = s2.getay();
        double y2min = s2.getay();
        if (x2max < s2.getbx()) {
            x2max = s2.getbx();
        }
        if (x2min > s2.getbx()) {
            x2min = s2.getbx();
        }
        if (y2max < s2.getby()) {
            y2max = s2.getby();
        }
        if (y2min > s2.getby()) {
            y2min = s2.getby();
        }

        if (x1max + rhit + 0.1 < x2min) {
            return 0;
        }
        if (x1min - rhit - 0.1 > x2max) {
            return 0;
        }
        if (y1max + rhit + 0.1 < y2min) {
            return 0;
        }
        if (y1min - rhit - 0.1 > y2max) {
            return 0;
        }

        //System.out.println("###########");

        Ten p1 = new Ten();
        p1.set(s1.geta());
        Ten p2 = new Ten();
        p2.set(s1.getb());
        Ten p3 = new Ten();
        p3.set(s2.geta());
        Ten p4 = new Ten();
        p4.set(s2.getb());

        Tyokusen t1 = new Tyokusen(p1, p2);
        Tyokusen t2 = new Tyokusen(p3, p4);
        //System.out.print("?@?@??分交?ｷ判定での平?s判定の結果?@???@");
        //System.out.println (heikou_hantei(t1,t2,rhei));
        // heikou_hantei(t1,t2,rhei)

        //例外?????@??分s1と??分s2が点の????
        if (((p1.getx() == p2.getx()) && (p1.gety() == p2.gety()))
                &&
                ((p3.getx() == p4.getx()) && (p3.gety() == p4.gety()))) {
            if ((p1.getx() == p3.getx()) && (p1.gety() == p3.gety())) {
                return 4;
            }
            return 0;
        }

        //例外?????@??分s1が点の????
        if ((p1.getx() == p2.getx()) && (p1.gety() == p2.gety())) {
            if ((hakononaka(p3, p1, p4) >= 1) && (t2.dainyuukeisan(p1) == 0.0)) {
                return 5;
            }
            return 0;
        }

        //例外?????@??分s2が点の????
        if ((p3.getx() == p4.getx()) && (p3.gety() == p4.gety())) {
            if ((hakononaka(p1, p3, p2) >= 1) && (t1.dainyuukeisan(p3) == 0.0)) {
                return 6;
            }
            return 0;
        }

        // System.out.println("AAAAAAAAAAAA");
        if (heikou_hantei(t1, t2, rhei) == 0) {    //２つの直??が平?sでない
            Ten pk = new Ten();
            pk.set(kouten_motome(t1, t2));    //<<<<<<<<<<<<<<<<<<<<<<<
            if ((hakononaka(p1, pk, p2) >= 1)
                    && (hakononaka(p3, pk, p4) >= 1)) {
                if (hitosii(p1, p3, rhit)) {
                    return 21;
                }//L字型
                if (hitosii(p1, p4, rhit)) {
                    return 22;
                }//L字型
                if (hitosii(p2, p3, rhit)) {
                    return 23;
                }//L字型
                if (hitosii(p2, p4, rhit)) {
                    return 24;
                }//L字型
                if (hitosii(p1, pk, rhit)) {
                    return 25;
                }//T字型 s1が?c棒
                if (hitosii(p2, pk, rhit)) {
                    return 26;
                }//T字型 s1が?c棒
                if (hitosii(p3, pk, rhit)) {
                    return 27;
                }//T字型 s2が?c棒
                if (hitosii(p4, pk, rhit)) {
                    return 28;
                }//T字型 s2が?c棒
                return 1;                    // <<<<<<<<<<<<<<<<< return 1;
            }
            return 0;
        }

        if (heikou_hantei(t1, t2, rhei) == 1) { //２つの直??が平?sで?Ay?ﾘ片は一致しない
            // System.out.println("BBBBBBBBBBB");
            return 0;
        }

        // ２つの??分が全く同じ
        if (hitosii(p1, p3, rhit) && hitosii(p2, p4, rhit)) {
            return 31;
        }
        if (hitosii(p1, p4, rhit) && hitosii(p2, p3, rhit)) {
            return 31;
        }

        // System.out.println("###########");

        //２つの直??が平?sで?Ay?ﾘ片も一致する
        if (heikou_hantei(t1, t2, rhei) == 2) {
            if (hitosii(p1, p3, rhit)) { //2つの??分の端点どうしが1点で?dなる????
                if (hakononaka(p1, p4, p2) == 2) {
                    return 321;
                }
                if (hakononaka(p3, p2, p4) == 2) {
                    return 322;
                }
                if (hakononaka(p2, p1, p4) == 2) {
                    return 323;
                }//2つの??分は1点で?dなるだけで?Aそれ以外では?dならない
            }

            if (hitosii(p1, p4, rhit)) {
                if (hakononaka(p1, p3, p2) == 2) {
                    return 331;
                }
                if (hakononaka(p4, p2, p3) == 2) {
                    return 332;
                }
                if (hakononaka(p2, p1, p3) == 2) {
                    return 333;
                }//2つの??分は1点で?dなるだけで?Aそれ以外では?dならない
            }

            if (hitosii(p2, p3, rhit)) {
                if (hakononaka(p2, p4, p1) == 2) {
                    return 341;
                }
                if (hakononaka(p3, p1, p4) == 2) {
                    return 342;
                }
                if (hakononaka(p1, p2, p4) == 2) {
                    return 343;
                }//2つの??分は1点で?dなるだけで?Aそれ以外では?dならない
            }

            if (hitosii(p2, p4, rhit)) {
                if (hakononaka(p2, p3, p1) == 2) {
                    return 351;
                }
                if (hakononaka(p4, p1, p3) == 2) {
                    return 352;
                }
                if (hakononaka(p1, p2, p3) == 2) {
                    return 353;
                }//2つの??分は1点で?dなるだけで?Aそれ以外では?dならない
            }

            //2つの??分の端点どうしが?dならない????
            if ((hakononaka(p1, p3, p4) == 2) && (hakononaka(p3, p4, p2) == 2)) {
                return 361;
            }//??分(p1,p2)に??分(p3,p4)が含まれる
            if ((hakononaka(p1, p4, p3) == 2) && (hakononaka(p4, p3, p2) == 2)) {
                return 362;
            }//??分(p1,p2)に??分(p3,p4)が含まれる

            if ((hakononaka(p3, p1, p2) == 2) && (hakononaka(p1, p2, p4) == 2)) {
                return 363;
            }//??分(p3,p4)に??分(p1,p2)が含まれる
            if ((hakononaka(p3, p2, p1) == 2) && (hakononaka(p2, p1, p4) == 2)) {
                return 364;
            }//??分(p3,p4)に??分(p1,p2)が含まれる


            if ((hakononaka(p1, p3, p2) == 2) && (hakononaka(p3, p2, p4) == 2)) {
                return 371;
            }//??分(p1,p2)のP2側と??分(p3,p4)のP3側が部分的に?dなる
            if ((hakononaka(p1, p4, p2) == 2) && (hakononaka(p4, p2, p3) == 2)) {
                return 372;
            }//??分(p1,p2)のP2側と??分(p4,p3)のP4側が部分的に?dなる

            if ((hakononaka(p3, p1, p4) == 2) && (hakononaka(p1, p4, p2) == 2)) {
                return 373;
            }//??分(p3,p4)のP4側と??分(p1,p2)のP1側が部分的に?dなる
            if ((hakononaka(p4, p1, p3) == 2) && (hakononaka(p1, p3, p2) == 2)) {
                return 374;
            }//??分(p4,p3)のP3側と??分(p1,p2)のP1側が部分的に?dなる

            return 0;
        }
        return -1;//ここは何らかのエラ?[の時に通る?B

    }


    //senbun_kousa_hantei_amaiの甘いところは?A具体的にはreturn 21からreturn 28までの前提になる	if( (hakononaka(p1,pk,p2)>=1)&& (hakononaka(p3,pk,p4)>=1) )のかわりに
    // (hakononaka_amai(p1,pk,p2)>=1)&& (hakononaka_amai(p3,pk,p4)を使っていること?Bhakononaka_amaiは
    //点paが?A二点p1,p2を端点とする??分に点p1と点p2で直?sする?A2つの??分を含む長方形内にある???№ﾍ2を返す関???Bこれは ?ｭしはみ?oしても長方形内にあるとみなす?B
    //具体的には??分の中に点があるかの判定の?ﾛ?Aわずかに点が??分の外にある???№ﾍ?A??分の中にあると?A甘く判定する?B描き?E?lで展開?}を描くときは?Aこの甘いほうを使わないとT字型の??分の交?ｷ分割に失敗する
    //しかし?Aなぜか?A?ﾜり?ﾝ??定にこの甘いほうを使うと無限ル?[プになるようで?Aうまくいかない?Bこの?ｳ確な解明は未解決20161105

    public int senbun_kousa_hantei_amai(Senbun s1, Senbun s2, double rhit, double rhei) {    //r_hitosiiとr_heikouhanteiは?Ahitosiiとheikou_hanteiのずれの許容程度
        double x1max = s1.getax();
        double x1min = s1.getax();
        double y1max = s1.getay();
        double y1min = s1.getay();
        if (x1max < s1.getbx()) {
            x1max = s1.getbx();
        }
        if (x1min > s1.getbx()) {
            x1min = s1.getbx();
        }
        if (y1max < s1.getby()) {
            y1max = s1.getby();
        }
        if (y1min > s1.getby()) {
            y1min = s1.getby();
        }
        double x2max = s2.getax();
        double x2min = s2.getax();
        double y2max = s2.getay();
        double y2min = s2.getay();
        if (x2max < s2.getbx()) {
            x2max = s2.getbx();
        }
        if (x2min > s2.getbx()) {
            x2min = s2.getbx();
        }
        if (y2max < s2.getby()) {
            y2max = s2.getby();
        }
        if (y2min > s2.getby()) {
            y2min = s2.getby();
        }

        if (x1max + rhit + 0.1 < x2min) {
            return 0;
        }
        if (x1min - rhit - 0.1 > x2max) {
            return 0;
        }
        if (y1max + rhit + 0.1 < y2min) {
            return 0;
        }
        if (y1min - rhit - 0.1 > y2max) {
            return 0;
        }

        //System.out.println("###########");

        Ten p1 = new Ten();
        p1.set(s1.geta());
        Ten p2 = new Ten();
        p2.set(s1.getb());
        Ten p3 = new Ten();
        p3.set(s2.geta());
        Ten p4 = new Ten();
        p4.set(s2.getb());

        Tyokusen t1 = new Tyokusen(p1, p2);
        Tyokusen t2 = new Tyokusen(p3, p4);
        //System.out.print("?@?@??分交?ｷ判定での平?s判定の結果?@???@");
        //System.out.println (heikou_hantei(t1,t2,rhei));
        // heikou_hantei(t1,t2,rhei)

        //例外?????@??分s1と??分s2が点の????
        if (((p1.getx() == p2.getx()) && (p1.gety() == p2.gety()))
                &&
                ((p3.getx() == p4.getx()) && (p3.gety() == p4.gety()))) {
            if ((p1.getx() == p3.getx()) && (p1.gety() == p3.gety())) {
                return 4;
            }
            return 0;
        }

        //例外?????@??分s1が点の????
        if ((p1.getx() == p2.getx()) && (p1.gety() == p2.gety())) {
            if ((hakononaka(p3, p1, p4) >= 1) && (t2.dainyuukeisan(p1) == 0.0)) {
                return 5;
            }
            return 0;
        }

        //例外?????@??分s2が点の????
        if ((p3.getx() == p4.getx()) && (p3.gety() == p4.gety())) {
            if ((hakononaka(p1, p3, p2) >= 1) && (t1.dainyuukeisan(p3) == 0.0)) {
                return 6;
            }
            return 0;
        }

        // System.out.println("AAAAAAAAAAAA");
        if (heikou_hantei(t1, t2, rhei) == 0) {    //２つの直??が平?sでない
            Ten pk = new Ten();
            pk.set(kouten_motome(t1, t2));    //<<<<<<<<<<<<<<<<<<<<<<<
            if ((hakononaka_amai(p1, pk, p2) >= 1)
                    && (hakononaka_amai(p3, pk, p4) >= 1)) {
                if (hitosii(p1, p3, rhit)) {
                    return 21;
                }
                if (hitosii(p1, p4, rhit)) {
                    return 22;
                }
                if (hitosii(p2, p3, rhit)) {
                    return 23;
                }
                if (hitosii(p2, p4, rhit)) {
                    return 24;
                }
                if (hitosii(p1, pk, rhit)) {
                    return 25;
                }
                if (hitosii(p2, pk, rhit)) {
                    return 26;
                }
                if (hitosii(p3, pk, rhit)) {
                    return 27;
                }
                if (hitosii(p4, pk, rhit)) {
                    return 28;
                }
                return 1;
            }
            return 0;
        }

        if (heikou_hantei(t1, t2, rhei) == 1) { //２つの直??が平?sで?Ay?ﾘ片は一致しない
            // System.out.println("BBBBBBBBBBB");
            return 0;
        }

        // ２つの??分が全く同じ
        if (hitosii(p1, p3, rhit) && hitosii(p2, p4, rhit)) {
            return 31;
        }
        if (hitosii(p1, p4, rhit) && hitosii(p2, p3, rhit)) {
            return 31;
        }

        // System.out.println("###########");

        //２つの直??が平?sで?Ay?ﾘ片も一致する
        if (heikou_hantei(t1, t2, rhei) == 2) {
            if (hitosii(p1, p3, rhit)) { //2つの??分の端点どうしが1点で?dなる????
                if (hakononaka(p1, p4, p2) == 2) {
                    return 321;
                }//長い??分に短い??分が含まれる
                if (hakononaka(p3, p2, p4) == 2) {
                    return 322;
                }//長い??分に短い??分が含まれる
                if (hakononaka(p2, p1, p4) == 2) {
                    return 323;
                }//2つの??分は1点で?dなるだけで?Aそれ以外では?dならない
            }

            if (hitosii(p1, p4, rhit)) {
                if (hakononaka(p1, p3, p2) == 2) {
                    return 331;
                }//長い??分に短い??分が含まれる
                if (hakononaka(p4, p2, p3) == 2) {
                    return 332;
                }//長い??分に短い??分が含まれる
                if (hakononaka(p2, p1, p3) == 2) {
                    return 333;
                }//2つの??分は1点で?dなるだけで?Aそれ以外では?dならない
            }

            if (hitosii(p2, p3, rhit)) {
                if (hakononaka(p2, p4, p1) == 2) {
                    return 341;
                }//長い??分に短い??分が含まれる
                if (hakononaka(p3, p1, p4) == 2) {
                    return 342;
                }//長い??分に短い??分が含まれる
                if (hakononaka(p1, p2, p4) == 2) {
                    return 343;
                }//2つの??分は1点で?dなるだけで?Aそれ以外では?dならない
            }

            if (hitosii(p2, p4, rhit)) {
                if (hakononaka(p2, p3, p1) == 2) {
                    return 351;
                }//長い??分に短い??分が含まれる
                if (hakononaka(p4, p1, p3) == 2) {
                    return 352;
                }//長い??分に短い??分が含まれる
                if (hakononaka(p1, p2, p3) == 2) {
                    return 353;
                }//2つの??分は1点で?dなるだけで?Aそれ以外では?dならない
            }

            //2つの??分の端点どうしが?dならない????
            if ((hakononaka(p1, p3, p4) == 2) && (hakononaka(p3, p4, p2) == 2)) {
                return 361;
            }//??分(p1,p2)に??分(p3,p4)が含まれる
            if ((hakononaka(p1, p4, p3) == 2) && (hakononaka(p4, p3, p2) == 2)) {
                return 362;
            }//??分(p1,p2)に??分(p3,p4)が含まれる

            if ((hakononaka(p3, p1, p2) == 2) && (hakononaka(p1, p2, p4) == 2)) {
                return 363;
            }//??分(p3,p4)に??分(p1,p2)が含まれる
            if ((hakononaka(p3, p2, p1) == 2) && (hakononaka(p2, p1, p4) == 2)) {
                return 364;
            }//??分(p3,p4)に??分(p1,p2)が含まれる

            if ((hakononaka(p1, p3, p2) == 2) && (hakononaka(p3, p2, p4) == 2)) {
                return 371;
            }
            if ((hakononaka(p1, p4, p2) == 2) && (hakononaka(p4, p2, p3) == 2)) {
                return 372;
            }
            if ((hakononaka(p3, p1, p4) == 2) && (hakononaka(p1, p4, p2) == 2)) {
                return 373;
            }
            if ((hakononaka(p4, p1, p3) == 2) && (hakononaka(p1, p3, p2) == 2)) {
                return 374;
            }

            return 0;
        }
        return -1;//ここは何らかのエラ?[の時に通る?B

    }


    //２つの直??が平?sかどうかを判定する関???B
    public int heikou_hantei(Tyokusen t1, Tyokusen t2) {
        return heikou_hantei(t1, t2, 0.1);
    }

    //２つの??分が平?sかどうかを判定する関???B
    public int heikou_hantei(Senbun s1, Senbun s2, double r) {
        return heikou_hantei(Senbun2Tyokusen(s1), Senbun2Tyokusen(s2), r);
    }


    public int heikou_hantei(Tyokusen t1, Tyokusen t2, double r) {//rは誤?ｷの許容度?Brが負なら厳密判定?B
        //0=平?sでない?A1=平?sで２直??が一致しない?A2=平?sで２直??が一致する
        double a1 = t1.geta(), b1 = t1.getb(), c1 = t1.getc();//直??t1, a1*x+b1*y+c1=0の各係?狽?める?B
        double a2 = t2.geta(), b2 = t2.getb(), c2 = t2.getc();//直??t2, a2*x+b2*y+c2=0の各係?狽?める?B

        //System.out.print("平?s判定のr?@???@");System.out.println(r);
        //厳密に判定----------------------------------------
        if (r <= 0.0) {
            //２直??が平?sの????
            if (a1 * b2 - a2 * b1 == 0) {
                //２直??は同一の????
                if ((a1 * a1 + b1 * b1) * c2 * c2 == (a2 * a2 + b2 * b2) * c1 * c1) {
                    return 2;
                }//厳密に判定?B
                //２直??が異なる????
                else {
                    return 1;
                }
            }
        }

        //誤?ｷを許容----------------------------------------
        if (r > 0) {
            //２直??が平?sの????
            if (Math.abs(a1 * b2 - a2 * b1) < r) {
                //２直??は同一の????


                //原点?i0?A0?jと各直??との距離を比較
                //double kyoriT=Math.abs(c1/Math.sqrt(a1*a1+b1*b1)-c2/Math.sqrt(a2*a2+b2*b2));//20181027?Aver3.049までのバグありの????
                //double kyoriT=Math.abs(   Math.abs(  c1/Math.sqrt(a1*a1+b1*b1)  )  -   Math.abs(  c2/Math.sqrt(a2*a2+b2*b2)  )      );//20181027?Aver3.050以?~のバグ無しの????
                double kyoriT = t2.kyorikeisan(t1.kage_motome(new Ten(0.0, 0.0)));//t1?繧ﾌ点とt2との距離//t1.kage_motome(new Ten(0.0,0.0))   は点?i0,0?jのt1?繧ﾌ影を??める?it1?繧ﾌ点ならなんでもいい?j//20181115?C?ｳ


                if (kyoriT < r) {//誤?ｷを許容?B
                    return 2;
                }
                //２直??が異なる????
                else {
                    return 1;
                }
            }
        }

        //２直??が非平?sの????-------------------------------------------------
        return 0;
    }


    //２つの直??の交点を??める関??
    public Ten kouten_motome(Tyokusen t1, Tyokusen t2) {
        double a1 = t1.geta(), b1 = t1.getb(), c1 = t1.getc();//直??t1, a1*x+b1*y+c1=0の各係?狽?める?B
        double a2 = t2.geta(), b2 = t2.getb(), c2 = t2.getc();//直??t2, a2*x+b2*y+c2=0の各係?狽?める?B

//System.out.println("   "+(b1*c2-b2*c1)/(a1*b2-a2*b1)+"::::::::"+(a2*c1-a1*c2)/(a1*b2-a2*b1));

        return new Ten((b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1), (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1));
    }


    //２つの直??の交点を??める関??(複?ｻ)
    public Ten kouten_motome_01(Tyokusen t1, Tyokusen t2) {
        double a1 = t1.geta(), b1 = t1.getb(), c1 = t1.getc();//直??t1, a1*x+b1*y+c1=0の各係?狽?める?B
        double a2 = t2.geta(), b2 = t2.getb(), c2 = t2.getc();//直??t2, a2*x+b2*y+c2=0の各係?狽?める?B
        return new Ten((b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1), (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1));
    }


    public Tyokusen Senbun2Tyokusen(Senbun s) {//??分を含む直??を得る
        Tyokusen t = new Tyokusen(s.geta(), s.getb());
        return t;
    }

    //２つの??分を直??とみなして交点を??める関???B??分としては交?ｷしなくても?A直??として交?ｷしている???№ﾌ交点を返す
    public Ten kouten_motome(Senbun s1, Senbun s2) {
        return kouten_motome(Senbun2Tyokusen(s1), Senbun2Tyokusen(s2));
    }

    //??分を直??とみなして他の直??との交点を??める関???B??分としては交?ｷしなくても?A直??として交?ｷしている???№ﾌ交点を返す
    public Ten kouten_motome(Tyokusen t1, Senbun s2) {
        return kouten_motome(t1, Senbun2Tyokusen(s2));
    }

    //??分を直??とみなして他の直??との交点を??める関???B??分としては交?ｷしなくても?A直??として交?ｷしている???№ﾌ交点を返す
    public Ten kouten_motome(Senbun s1, Tyokusen t2) {
        return kouten_motome(Senbun2Tyokusen(s1), t2);
    }


    //??分を?^横に平?s移動する関???i元の??分は変えずに?Vしい??分を返す?j
    public Senbun mayoko_idou(Senbun s, double d) {
        Tyokusen t = new Tyokusen(s.geta(), s.getb());
        Tyokusen ta = new Tyokusen(s.geta(), s.getb());
        Tyokusen tb = new Tyokusen(s.geta(), s.getb());
        ta.tyokkouka(s.geta());
        tb.tyokkouka(s.getb());
        Tyokusen td = new Tyokusen(s.geta(), s.getb());
        td.heikouidou(d);

        Senbun sreturn = new Senbun(kouten_motome_01(ta, td), kouten_motome_01(tb, td));

        return sreturn;
    }

    //------------------------------------
    //点aを中?Sに点bをd度回転した点を返す関???i元の点は変えずに?Vしい点を返す?j
    public Ten ten_kaiten(Ten a, Ten b, double d) {

        double Mcd = Math.cos(d * Math.PI / 180.0);
        double Msd = Math.sin(d * Math.PI / 180.0);

        double bx1 = Mcd * (b.getx() - a.getx()) - Msd * (b.gety() - a.gety()) + a.getx();
        double by1 = Msd * (b.getx() - a.getx()) + Mcd * (b.gety() - a.gety()) + a.gety();

//double ax1=s0.getax();
//double ay1=s0.getay();
        Ten t_return = new Ten(bx1, by1);

        return t_return;
    }

    //------------------------------------
    //点aを中?Sに点bをd度回転しabの距離がr倍の点を返す関???i元の点は変えずに?Vしい点を返す?j
    public Ten ten_kaiten(Ten a, Ten b, double d, double r) {

        double Mcd = Math.cos(d * Math.PI / 180.0);
        double Msd = Math.sin(d * Math.PI / 180.0);

        double bx1 = r * (Mcd * (b.getx() - a.getx()) - Msd * (b.gety() - a.gety())) + a.getx();
        double by1 = r * (Msd * (b.getx() - a.getx()) + Mcd * (b.gety() - a.gety())) + a.gety();

        Ten t_return = new Ten(bx1, by1);

        return t_return;
    }

    //------------------------------------
    //点aを中?Sに点bを元にしてabの距離がr倍の点を返す関???i元の点は変えずに?Vしい点を返す?j20161224 未検?ﾘ
    public Ten ten_bai(Ten a, Ten b, double r) {
        double bx1 = r * (b.getx() - a.getx()) + a.getx();
        double by1 = r * (b.gety() - a.gety()) + a.gety();

        Ten t_return = new Ten(bx1, by1);

        return t_return;
    }


//------------------------------------

    //??分abをcを中?Sにr倍してd度回転した??分を返す関???i元の??分は変えずに?Vしい??分を返す?j
    public Senbun Senbun_kaiten(Senbun s0, Ten c, double d, double r) {
        Senbun s_return = new Senbun(ten_kaiten(s0.geta(), c, d, r), ten_kaiten(s0.getb(), c, d, r));
        return s_return;
    }


// ------------------------------------

    //??分abをaを中?Sにd度回転した??分を返す関???i元の??分は変えずに?Vしい??分を返す?j
    public Senbun Senbun_kaiten(Senbun s0, double d) {
//s0.getax(),s0.getay()

//(Math.cos(d*3.14159265/180.0),-Math.sin(d*3.14159265/180.0) )  (s0.getbx()-s0.getax()) + (s0.getax())
//(Math.sin(d*3.14159265/180.0), Math.cos(d*3.14159265/180.0) )  (s0.getby()-s0.getay())   (s0.getay())

//double Mcd=Math.cos(d*3.14159265/180.0);
//double Msd=Math.sin(d*3.14159265/180.0);
        double Mcd = Math.cos(d * Math.PI / 180.0);
        double Msd = Math.sin(d * Math.PI / 180.0);

        double bx1 = Mcd * (s0.getbx() - s0.getax()) - Msd * (s0.getby() - s0.getay()) + s0.getax();
        double by1 = Msd * (s0.getbx() - s0.getax()) + Mcd * (s0.getby() - s0.getay()) + s0.getay();

        double ax1 = s0.getax();
        double ay1 = s0.getay();
        Senbun s_return = new Senbun(ax1, ay1, bx1, by1);

        return s_return;
    }


    //??分abをaを中?Sにr倍してd度回転した??分を返す関???i元の??分は変えずに?Vしい??分を返す?j
    public Senbun Senbun_kaiten(Senbun s0, double d, double r) {
        //s0.getax(),s0.getay()

        //(Math.cos(d*3.14159265/180.0),-Math.sin(d*3.14159265/180.0) )  (s0.getbx()-s0.getax()) + (s0.getax())
        //(Math.sin(d*3.14159265/180.0), Math.cos(d*3.14159265/180.0) )  (s0.getby()-s0.getay())   (s0.getay())

        double Mcd = Math.cos(d * Math.PI / 180.0);
        double Msd = Math.sin(d * Math.PI / 180.0);

        double bx1 = r * (Mcd * (s0.getbx() - s0.getax()) - Msd * (s0.getby() - s0.getay())) + s0.getax();
        double by1 = r * (Msd * (s0.getbx() - s0.getax()) + Mcd * (s0.getby() - s0.getay())) + s0.getay();

        double ax1 = s0.getax();
        double ay1 = s0.getay();
        Senbun s_return = new Senbun(ax1, ay1, bx1, by1);

        return s_return;
    }


    //??分abをaを中?Sにr倍した??分を返す関???i元の??分は変えずに?Vしい??分を返す?j
    public Senbun Senbun_bai(Senbun s0, double r) {

        double bx1 = r * (s0.getbx() - s0.getax()) + s0.getax();
        double by1 = r * (s0.getby() - s0.getay()) + s0.getay();

        double ax1 = s0.getax();
        double ay1 = s0.getay();
        Senbun s_return = new Senbun(ax1, ay1, bx1, by1);

        return s_return;
    }


    //??分Aの?A??分Jを軸とした対?ﾆ位置にある??分Bを??める関??
    public Senbun sentaisyou_senbun_motome(Senbun s0, Senbun jiku) {
        Ten p_a = new Ten();
        p_a.set(s0.geta());
        Ten p_b = new Ten();
        p_b.set(s0.getb());
        Ten jiku_a = new Ten();
        jiku_a.set(jiku.geta());
        Ten jiku_b = new Ten();
        jiku_b.set(jiku.getb());

        Senbun s1 = new Senbun();
        s1.set(sentaisyou_ten_motome(jiku_a, jiku_b, p_a), sentaisyou_ten_motome(jiku_a, jiku_b, p_b));

        return s1;
    }


    //直??t0に関して?A点pの対?ﾆ位置にある点を??める関??
    public Ten sentaisyou_ten_motome(Tyokusen t0, Ten p) {
        Ten p1 = new Ten();  // p1.set(s.geta());
        Ten p2 = new Ten();  // p2.set(s.getb());

        Tyokusen s1 = new Tyokusen();
        s1.set(t0);
        Tyokusen s2 = new Tyokusen();
        s2.set(t0);

        s2.tyokkouka(p);//点pを通って s1に直?sする直??s2を??める?B

        p1 = kouten_motome(s1, s2);
        p2.set(2.0 * p1.getx() - p.getx(), 2.0 * p1.gety() - p.gety());
        return p2;
    }

    //２つの点t1,t2を通る直??に関して?A点pの対?ﾆ位置にある点を??める関??
    public Ten sentaisyou_ten_motome(Ten t1, Ten t2, Ten p) {
        Ten p1 = new Ten();  // p1.set(s.geta());
        Ten p2 = new Ten();  // p2.set(s.getb());

        Tyokusen s1 = new Tyokusen(t1, t2);
        Tyokusen s2 = new Tyokusen(t1, t2);

        s2.tyokkouka(p);//点pを通って s1に直?sする直??s2を??める?B

        p1 = kouten_motome(s1, s2);
        p2.set(2.0 * p1.getx() - p.getx(), 2.0 * p1.gety() - p.gety());
        return p2;
    }

    //角度を-180.0度より大きく180.0度以下に押さえる関??
    public double kakudo_osame_m180_180(double kakudo) {
        while (kakudo <= -180.0) {
            kakudo = kakudo + 360.0;
        }
        while (kakudo > 180.0) {
            kakudo = kakudo - 360.0;
        }
        return kakudo;
    }

    //角度を0.0度以??360.0度未満に押さえる関??
    public double kakudo_osame_0_360(double kakudo) {
        while (kakudo < 0.0) {
            kakudo = kakudo + 360.0;
        }
        while (kakudo >= 360.0) {
            kakudo = kakudo - 360.0;
        }
        return kakudo;
    }


    //角度を0.0度以?緻max度未満に押さえる関??(円??の頂点の伏見定??などで使う)
    public double kakudo_osame_0_kmax(double kakudo, double kmax) {
        while (kakudo < 0.0) {
            kakudo = kakudo + kmax;
        }
        while (kakudo >= kmax) {
            kakudo = kakudo - kmax;
        }
        return kakudo;
    }


    //??分s1とs2のなす角度
    public double kakudo(Senbun s1, Senbun s2) {
        Ten a = new Ten();
        a.set(s1.geta());
        Ten b = new Ten();
        b.set(s1.getb());
        Ten c = new Ten();
        c.set(s2.geta());
        Ten d = new Ten();
        d.set(s2.getb());

        return kakudo_osame_0_360(kakudo(c, d) - kakudo(a, b));
    }


    //ベクトルabとcdのなす角度
    public double kakudo(Ten a, Ten b, Ten c, Ten d) {
        return kakudo_osame_0_360(kakudo(c, d) - kakudo(a, b));
    }

    //三角形の内?Sを??める
    public Ten naisin(Ten ta, Ten tb, Ten tc) {
        double A, B, C, XA, XB, XC, YA, YB, YC, XD, YD, XE, YE, G, H, K, L, P, Q, XN, YN;
        Ten tn = new Ten();
        XA = ta.getx();
        YA = ta.gety();
        XB = tb.getx();
        YB = tb.gety();
        XC = tc.getx();
        YC = tc.gety();

        A = Math.sqrt((XC - XB) * (XC - XB) + (YC - YB) * (YC - YB));
        B = Math.sqrt((XA - XC) * (XA - XC) + (YA - YC) * (YA - YC));
        C = Math.sqrt((XB - XA) * (XB - XA) + (YB - YA) * (YB - YA));
        XD = (C * XC + B * XB) / (B + C);
        YD = (C * YC + B * YB) / (B + C);
        XE = (C * XC + A * XA) / (A + C);
        YE = (C * YC + A * YA) / (A + C);
        G = XD - XA;
        H = YD - YA;
        K = XE - XB;
        L = YE - YB;
        P = G * YA - H * XA;
        Q = K * YB - L * XB;
        XN = (G * Q - K * P) / (H * K - G * L);
        YN = (L * P - H * Q) / (G * L - H * K);

        tn.set(XN, YN);

        return tn;
    }

    // -------------------------------
    //内分点を??める?B
    public Ten naibun(Ten a, Ten b, double d_naibun_s, double d_naibun_t) {
        Ten r_ten = new Ten(-10000.0, -10000.0);
        if (kyori(a, b) < 0.000001) {
            return r_ten;
        }

        if ((d_naibun_s == 0.0) && (d_naibun_t == 0.0)) {
            return r_ten;
        }
        if ((d_naibun_s == 0.0) && (d_naibun_t != 0.0)) {
            return a;
        }
        if ((d_naibun_s != 0.0) && (d_naibun_t == 0.0)) {
            return b;
        }
        if ((d_naibun_s != 0.0) && (d_naibun_t != 0.0)) {
            Senbun s_ab = new Senbun(a, b);
            double nx = (d_naibun_t * s_ab.getax() + d_naibun_s * s_ab.getbx()) / (d_naibun_s + d_naibun_t);
            double ny = (d_naibun_t * s_ab.getay() + d_naibun_s * s_ab.getby()) / (d_naibun_s + d_naibun_t);
            r_ten.set(nx, ny);
            return r_ten;
        }
        return r_ten;
    }

    // -------------------------------
    public Tyokusen en_to_en_no_kouten_wo_tooru_tyokusen(En e1, En e2) {
        double x1 = e1.getx();
        double y1 = e1.gety();
        double r1 = e1.getr();
        double x2 = e2.getx();
        double y2 = e2.gety();
        double r2 = e2.getr();

        double a = 2.0 * x1 - 2.0 * x2;
        double b = 2.0 * y1 - 2.0 * y2;
        double c = x2 * x2 - x1 * x1 + y2 * y2 - y1 * y1 + r1 * r1 - r2 * r2;

        Tyokusen r_t = new Tyokusen(a, b, c);

        return r_t;
    }

    // -------------------------------
    public Senbun en_to_en_no_kouten_wo_musubu_senbun(En e1, En e2) {

//System.out.println(" 20170301  e1="+e1.getx() +",    "+ e1.gety() +",    "+e1.getr());
//System.out.println(" 20170301  e2="+e2.getx() +",    "+ e2.gety() +",    "+e2.getr());

        Tyokusen t0 = new Tyokusen();
        t0.set(en_to_en_no_kouten_wo_tooru_tyokusen(e1, e2));
        Tyokusen t1 = new Tyokusen(e1.get_tyuusin(), e2.get_tyuusin());
        Ten kouten_t0t1 = new Ten();
        kouten_t0t1.set(kouten_motome(t0, t1));
        double nagasa_a = t0.kyorikeisan(e1.get_tyuusin());  //t0とt1の交点からe1の中?Sまでの長さ

//double nagasa_a=kyori(kouten_t0t1,e1.get_tyuusin());  //t0とt1の交点からe1の中?Sまでの長さ
        double nagasa_b = Math.sqrt(e1.getr() * e1.getr() - nagasa_a * nagasa_a); //t0とt1の交点からe1とe2の交点までの長さ
//t0と平?sな方向ベクトルは(t0.getb() , -t0.geta())
//t0と平?sな方向ベクトルで長さがnagasa_bのものは(t0.getb()*nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta() ) , -t0.geta()*nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta() ))

//Senbun r_s=new Senbun();

        Senbun r_s = new Senbun(
                kouten_t0t1.getx() + t0.getb() * nagasa_b / Math.sqrt(t0.getb() * t0.getb() + t0.geta() * t0.geta()),
                kouten_t0t1.gety() - t0.geta() * nagasa_b / Math.sqrt(t0.getb() * t0.getb() + t0.geta() * t0.geta()),
                kouten_t0t1.getx() - t0.getb() * nagasa_b / Math.sqrt(t0.getb() * t0.getb() + t0.geta() * t0.geta()),
                kouten_t0t1.gety() + t0.geta() * nagasa_b / Math.sqrt(t0.getb() * t0.getb() + t0.geta() * t0.geta())
        );
/*
double ax,ay,bx,by;
//System.out.println(" 20170301 nagasa_b "+nagasa_b);
//System.out.println(" 20170301  "+nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta()));


//ax=kouten_t0t1.getx()+t0.getb()*nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta() );
ax=kouten_t0t1.getx()+t0.getb()*  0.2;//  nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta() );
ay=kouten_t0t1.gety()-t0.geta()*  0.2;//  nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta() );
bx=kouten_t0t1.getx()-t0.getb()*  0.2;//  nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta() );
by=kouten_t0t1.gety()+t0.geta()*  0.2;//  nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta() );
Ten ta=new Ten(ax+1.0,ay);
Ten tb=new Ten(bx,by+2.0);
r_s.set(ax,ay,bx,by);
*/

        return r_s;
    }


    // --------qqqqqqqqqqqqqqq-----------------------
    public Senbun en_to_tyokusen_no_kouten_wo_musubu_senbun(En e1, Tyokusen t0) {

//System.out.println(" 20170301  e1="+e1.getx() +",    "+ e1.gety() +",    "+e1.getr());
//System.out.println(" 20170301  e2="+e2.getx() +",    "+ e2.gety() +",    "+e2.getr());

//En e2 = new En(sentaisyou_ten_motome(t0,e1.get_tyuusin()),e1.getr(),3);
//Tyokusen t1 = new Tyokusen(e1.get_tyuusin(),e2.get_tyuusin());
        Ten kouten_t0t1 = new Ten();
        kouten_t0t1.set(kage_motome(t0, e1.get_tyuusin()));
        double nagasa_a = t0.kyorikeisan(e1.get_tyuusin());  //t0とt1の交点からe1の中?Sまでの長さ

//double nagasa_a=kyori(kouten_t0t1,e1.get_tyuusin());  //t0とt1の交点からe1の中?Sまでの長さ
        double nagasa_b = Math.sqrt(e1.getr() * e1.getr() - nagasa_a * nagasa_a); //t0とt1の交点からe1とe2の交点までの長さ
//t0と平?sな方向ベクトルは(t0.getb() , -t0.geta())
//t0と平?sな方向ベクトルで長さがnagasa_bのものは(t0.getb()*nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta() ) , -t0.geta()*nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta() ))

//Senbun r_s=new Senbun();

        Senbun r_s = new Senbun(
                kouten_t0t1.getx() + t0.getb() * nagasa_b / Math.sqrt(t0.getb() * t0.getb() + t0.geta() * t0.geta()),
                kouten_t0t1.gety() - t0.geta() * nagasa_b / Math.sqrt(t0.getb() * t0.getb() + t0.geta() * t0.geta()),
                kouten_t0t1.getx() - t0.getb() * nagasa_b / Math.sqrt(t0.getb() * t0.getb() + t0.geta() * t0.geta()),
                kouten_t0t1.gety() + t0.geta() * nagasa_b / Math.sqrt(t0.getb() * t0.getb() + t0.geta() * t0.geta())
        );
/*
double ax,ay,bx,by;
//System.out.println(" 20170301 nagasa_b "+nagasa_b);
//System.out.println(" 20170301  "+nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta()));


//ax=kouten_t0t1.getx()+t0.getb()*nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta() );
ax=kouten_t0t1.getx()+t0.getb()*  0.2;//  nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta() );
ay=kouten_t0t1.gety()-t0.geta()*  0.2;//  nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta() );
bx=kouten_t0t1.getx()-t0.getb()*  0.2;//  nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta() );
by=kouten_t0t1.gety()+t0.geta()*  0.2;//  nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta() );
Ten ta=new Ten(ax+1.0,ay);
Ten tb=new Ten(bx,by+2.0);
r_s.set(ax,ay,bx,by);
*/

        return r_s;
    }

    //点p0と?A円e0の円周との間の距離を??める関??----------------------------------------------------
    public double kyori_ensyuu(Ten p0, En e0) {


        return Math.abs(kyori(p0, e0.get_tyuusin()) - e0.getr());
    }

    //Minを返す関??
    public double min(double d1, double d2, double d3, double d4) {
        double min_d = d1;
        if (min_d > d2) {
            min_d = d2;
        }
        if (min_d > d3) {
            min_d = d3;
        }
        if (min_d > d4) {
            min_d = d4;
        }
        return min_d;
    }


    public Senbun nitoubunsen(Ten t1, Ten t2, double d0) {

//s_step[i].geta(),s_step[j].geta(),200.0
        //double bx1=   r* (s0.getbx()-s0.getax())  +  s0.getax();
        //double by1=   r* (s0.getby()-s0.getay())  +  s0.getay();

        //double ax1=s0.getax();
        //double ay1=s0.getay();


        Ten tm = new Ten((t1.getx() + t2.getx()) / 2.0, (t1.gety() + t2.gety()) / 2.0);

        double bai = d0 / kyori(t1, t2);

        Senbun s1 = new Senbun();
        s1.set(Senbun_kaiten(new Senbun(tm, t1), 90.0, bai));
        Senbun s2 = new Senbun();
        s2.set(Senbun_kaiten(new Senbun(tm, t2), 90.0, bai));

        Senbun s_return = new Senbun(s1.getb(), s2.getb());
//Senbun s_return =new Senbun(t1, t2);
        return s_return;
    }
}