package jp.gr.java_conf.mt777.zukei2d.oritacalc;

import jp.gr.java_conf.mt777.zukei2d.en.En;
import jp.gr.java_conf.mt777.zukei2d.oritacalc.tyokusen.Tyokusen;
import jp.gr.java_conf.mt777.zukei2d.senbun.Senbun;

import java.math.BigDecimal;

public class OritaCalc {


    //d2s �_�u�����X�g�����O�ɕς���?@?�?��_2���ڂŎl�̌ܓ�("");���Q��
    public String d2s(double d0) {
        BigDecimal bd = new BigDecimal(d0);

        //?�?���2�ʂŎl�̌ܓ�
        BigDecimal bd1 = bd.setScale(1, BigDecimal.ROUND_HALF_UP);

        String sr = "";
        sr = bd1.toString();
        return sr;
    }


    //������System.out.println("String");
    public void hyouji(String s0) {
        System.out.println(s0);
    }


    //��?�t?�̓_p�̉e�̈ʒu?i�_p��?ł��߂���?�t?�̈ʒu?j���?�߂�?B
    public Ten kage_motome(Tyokusen t, Ten p) {

        Tyokusen t1 = new Tyokusen();
        t1.set(t);
        t1.tyokkouka(p);//�_p1��ʂ��� t�ɒ�?s���钼?�u1���?�߂�?B
        return kouten_motome(t, t1);
    }

    //�_P0��P1��ʂ钼?�t?�̓_p�̉e�̈ʒu?i�_p��?ł��߂���?�t?�̈ʒu?j���?�߂�?B
    public Ten kage_motome(Ten p0, Ten p1, Ten p) {
        Tyokusen t = new Tyokusen(p0, p1);
        return kage_motome(t, p);
    }

    //?���s0���܂ޒ�?�t?�̓_p�̉e�̈ʒu?i�_p��?ł��߂���?�t?�̈ʒu?j���?�߂�?B
    public Ten kage_motome(Senbun s0, Ten p) {
        return kage_motome(s0.geta(), s0.getb(), p);
    }


    //2�̓_�������ʒu(true)���قȂ�(false)�����肷���?�----------------------------------
    public boolean hitosii(Ten p1, Ten p2) {
        return hitosii(p1, p2, 0.1);//�����Ō�?�����`����Ă���?B
    }

    public boolean hitosii(Ten p1, Ten p2, double r) {//r�͌�?��̋��e�x?Br�����Ȃ猵������?B

        //�����ɔ���?B
        if (r <= 0.0) {
            if ((p1.getx() == p2.getx()) && (p1.gety() == p2.gety())) {
                return true;
            }
        }
        //��?������e?B
        if (r > 0) {
            return kyori(p1, p2) <= r;
        }
        return false;
    }

    //�Q�_�Ԃ̋���?i?�?�?j���?�߂��?�----------------------------------------------------
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
    //�Q�_��a,b���w�肵��?A�x�N�g��ab��x���̂Ȃ��p�x���?�߂��?�?B����a=b�Ȃ�-10000.0��Ԃ�----------------------------------------------------
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


    //?������w�肵��?A�x�N�g��ab��x���̂Ȃ��p�x���?�߂��?�?B����a=b�Ȃ�-10000.0��Ԃ�----------------------------------------------------
    public double kakudo(Senbun s) {
        return kakudo(s.geta(), s.getb());
    }

    //?������w�肵��?A�x�N�g��ab��x���̂Ȃ��p�x���?�߂��?�?B����a=b�Ȃ�-10000.0��Ԃ�----------------------------------------------------
    public double kakudozure(Senbun s, double a) {
        double b;//��?ۂ̊p�x��a�Ŋ���������?�]
        b = kakudo(s) % a;
        if (a - b < b) {
            b = a - b;
        }
        return b;
    }

    //�_pa��?A��_p1,p2��[�_�Ƃ���?����ɓ_p1�Ɠ_p2�Œ�?s����?A2��?������܂ޒ����`���ɂ���?�?���2��Ԃ���?�
    public int hakononaka(Ten p1, Ten pa, Ten p2) {
        Tyokusen t = new Tyokusen(p1, p2);//p1,p2��ʂ钼?�t���?�߂�?B
        Tyokusen u1 = new Tyokusen(p1, p2);
        u1.tyokkouka(p1);//�_p1��ʂ��� t�ɒ�?s���钼?�u1���?�߂�?B
        Tyokusen u2 = new Tyokusen(p1, p2);
        u2.tyokkouka(p2);//�_p2��ʂ��� t�ɒ�?s���钼?�u2���?�߂�?B

        if (u1.dainyuukeisan(pa) * u2.dainyuukeisan(pa) == 0.0) {
            return 1;
        }
        if (u1.dainyuukeisan(pa) * u2.dainyuukeisan(pa) < 0.0) {
            return 2;
        }
        return 0;//���̊O���ɂ���?�?�
    }


    //�_pa��?A��_p1,p2��[�_�Ƃ���?����ɓ_p1�Ɠ_p2�Œ�?s����?A2��?������܂ޒ����`���ɂ���?�?���2��Ԃ���?�?B����� ?����͂�?o���Ă������`���ɂ���Ƃ݂Ȃ�?B
    //��̓I�ɂ�?����̒��ɓ_�����邩�̔����?�?A�킸���ɓ_��?����̊O�ɂ���?�?���?A?����̒��ɂ����?A�Â����肷��?B�`��?E?l�œW�J?}��`���Ƃ���?A���̊Â��ق����g��Ȃ���T���^��?����̌�?������Ɏ��s����
    //������?A�Ȃ���?A?܂�?��?���ɂ��̊Â��ق����g���Ɩ�����?[�v�ɂȂ�悤��?A���܂������Ȃ�?B����?��m�ȉ𖾂͖�����20161105
    public int hakononaka_amai(Ten p1, Ten pa, Ten p2) {
        Tyokusen t = new Tyokusen(p1, p2);//p1,p2��ʂ钼?�t���?�߂�?B
        Tyokusen u1 = new Tyokusen(p1, p2);
        u1.tyokkouka(p1);//�_p1��ʂ��� t�ɒ�?s���钼?�u1���?�߂�?B
        Tyokusen u2 = new Tyokusen(p1, p2);
        u2.tyokkouka(p2);//�_p2��ʂ��� t�ɒ�?s���钼?�u2���?�߂�?B

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
        return 0;//���̊O���ɂ���?�?�
    }


    //�_p���w�肳�ꂽ?����Ƃǂ̕�?��ŋ߂�(r�ȓ�)���ǂ����𔻒肷���?�?@---------------------------------
    //0=�߂��Ȃ�?A1=a�_�ɋ߂�?A2=b�_�ɋ߂�?A3=���̕����ɋ߂�
    public int senbun_busyo_sagasi(Ten p, Senbun s0, double r) {
        if (r > kyori(p, s0.geta())) {
            return 1;
        }//a�_�ɋ߂����ǂ���
        if (r > kyori(p, s0.getb())) {
            return 2;
        }//b�_�ɋ߂����ǂ���
        if (r > kyori_senbun(p, s0)) {
            return 3;
        }//���̕����ɋ߂����ǂ���
        return 0;
    }


    //�_p0��?A��_p1,p2�𗼒[�Ƃ���?����Ƃ̊Ԃ̋������?�߂��?�----------------------------------------------------
    public double kyori_senbun(Ten p0, Ten p1, Ten p2) {
        // Ten p1 = new Ten();   p1.set(s.geta());
        // Ten p2 = new Ten();   p2.set(s.getb());

        //p1��p2������?�?�
        if (kyori(p1, p2) == 0.0) {
            return kyori(p0, p1);
        }

        //p1��p2���قȂ�?�?�
        Tyokusen t = new Tyokusen(p1, p2);//p1,p2��ʂ钼?�t���?�߂�?B
        Tyokusen u = new Tyokusen(p1, p2);
        u.tyokkouka(p0);//�_p0��ʂ��� t�ɒ�?s���钼?�u���?�߂�?B

        if (hakononaka(p1, kouten_motome(t, u), p2) >= 1) {
            return t.kyorikeisan(p0);
        }//t��u�̌�_��p1��p2�̊Ԃɂ���?�?�?B
        return Math.min(kyori(p0, p1), kyori(p0, p2));//t��u�̌�_��p1��p2�̊ԂɂȂ�?�?�?B
    }

    //�_p0��?A?���s�Ƃ̊Ԃ̋������?�߂��?�----------------------------------------------------
    public double kyori_senbun(Ten p0, Senbun s) {
        Ten p1 = new Ten();
        p1.set(s.geta());
        Ten p2 = new Ten();
        p2.set(s.getb());
        return kyori_senbun(p0, p1, p2);
    }

    //�Q��?�����?A��?����邩�ǂ����𔻒肷���?�----------------------------------------------------
    // 0=��?����Ȃ�?A?@
    // 1=�Q��?�������?s�łȂ�?A��_��?\���H�^�Ō�?�����?A
    // 2�ԑ�=�Q��?�������?s�łȂ�?A��_�łs���H�^�܂��͂��̎��^�Ō�?�����
    // 3=�Q��?�������?s��?A��?�����
    // 4=?���s1��?���s2���_��?A��?�����
    // 5=?���s1���_��?A��?�����
    // 6=?���s2���_��?A��?�����
    //�?��?Ip1��p2������?A�܂���p3��p4������?�?��͌��ʂ����������Ȃ邪��?A
    //���̊�?����̂ɂ̓`�F�b�N�@?\�����Ă��Ȃ��̂�?A�C�Â��ɂ������Ƃ�����?B
    public int senbun_kousa_hantei(Senbun s1, Senbun s2) {
        //return senbun_kousa_hantei( s1,s2,0.001,0.001) ;
        return senbun_kousa_hantei(s1, s2, 0.01, 0.01);

        //return senbun_kousa_hantei( s1,s2,0.000001,0.000001) ;
    }


    public int senbun_kousa_hantei_amai(Senbun s1, Senbun s2) {
        //return senbun_kousa_hantei_amai( s1,s2,0.000001,0.000001) ;
        return senbun_kousa_hantei_amai(s1, s2, 0.01, 0.01);
    }


    public int senbun_kousa_hantei(Senbun s1, Senbun s2, double rhit, double rhei) {    //r_hitosii��r_heikouhantei��?Ahitosii��heikou_hantei�̂���̋��e���x
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
        //System.out.print("?@?@?�����?�����ł̕�?s����̌���?@???@");
        //System.out.println (heikou_hantei(t1,t2,rhei));
        // heikou_hantei(t1,t2,rhei)

        //��O?��??@?���s1��?���s2���_��?�?�
        if (((p1.getx() == p2.getx()) && (p1.gety() == p2.gety()))
                &&
                ((p3.getx() == p4.getx()) && (p3.gety() == p4.gety()))) {
            if ((p1.getx() == p3.getx()) && (p1.gety() == p3.gety())) {
                return 4;
            }
            return 0;
        }

        //��O?��??@?���s1���_��?�?�
        if ((p1.getx() == p2.getx()) && (p1.gety() == p2.gety())) {
            if ((hakononaka(p3, p1, p4) >= 1) && (t2.dainyuukeisan(p1) == 0.0)) {
                return 5;
            }
            return 0;
        }

        //��O?��??@?���s2���_��?�?�
        if ((p3.getx() == p4.getx()) && (p3.gety() == p4.gety())) {
            if ((hakononaka(p1, p3, p2) >= 1) && (t1.dainyuukeisan(p3) == 0.0)) {
                return 6;
            }
            return 0;
        }

        // System.out.println("AAAAAAAAAAAA");
        if (heikou_hantei(t1, t2, rhei) == 0) {    //�Q�̒�?�����?s�łȂ�
            Ten pk = new Ten();
            pk.set(kouten_motome(t1, t2));    //<<<<<<<<<<<<<<<<<<<<<<<
            if ((hakononaka(p1, pk, p2) >= 1)
                    && (hakononaka(p3, pk, p4) >= 1)) {
                if (hitosii(p1, p3, rhit)) {
                    return 21;
                }//L���^
                if (hitosii(p1, p4, rhit)) {
                    return 22;
                }//L���^
                if (hitosii(p2, p3, rhit)) {
                    return 23;
                }//L���^
                if (hitosii(p2, p4, rhit)) {
                    return 24;
                }//L���^
                if (hitosii(p1, pk, rhit)) {
                    return 25;
                }//T���^ s1��?c�_
                if (hitosii(p2, pk, rhit)) {
                    return 26;
                }//T���^ s1��?c�_
                if (hitosii(p3, pk, rhit)) {
                    return 27;
                }//T���^ s2��?c�_
                if (hitosii(p4, pk, rhit)) {
                    return 28;
                }//T���^ s2��?c�_
                return 1;                    // <<<<<<<<<<<<<<<<< return 1;
            }
            return 0;
        }

        if (heikou_hantei(t1, t2, rhei) == 1) { //�Q�̒�?�����?s��?Ay?ؕЂ͈�v���Ȃ�
            // System.out.println("BBBBBBBBBBB");
            return 0;
        }

        // �Q��?������S������
        if (hitosii(p1, p3, rhit) && hitosii(p2, p4, rhit)) {
            return 31;
        }
        if (hitosii(p1, p4, rhit) && hitosii(p2, p3, rhit)) {
            return 31;
        }

        // System.out.println("###########");

        //�Q�̒�?�����?s��?Ay?ؕЂ���v����
        if (heikou_hantei(t1, t2, rhei) == 2) {
            if (hitosii(p1, p3, rhit)) { //2��?����̒[�_�ǂ�����1�_��?d�Ȃ�?�?�
                if (hakononaka(p1, p4, p2) == 2) {
                    return 321;
                }
                if (hakononaka(p3, p2, p4) == 2) {
                    return 322;
                }
                if (hakononaka(p2, p1, p4) == 2) {
                    return 323;
                }//2��?�����1�_��?d�Ȃ邾����?A����ȊO�ł�?d�Ȃ�Ȃ�
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
                }//2��?�����1�_��?d�Ȃ邾����?A����ȊO�ł�?d�Ȃ�Ȃ�
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
                }//2��?�����1�_��?d�Ȃ邾����?A����ȊO�ł�?d�Ȃ�Ȃ�
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
                }//2��?�����1�_��?d�Ȃ邾����?A����ȊO�ł�?d�Ȃ�Ȃ�
            }

            //2��?����̒[�_�ǂ�����?d�Ȃ�Ȃ�?�?�
            if ((hakononaka(p1, p3, p4) == 2) && (hakononaka(p3, p4, p2) == 2)) {
                return 361;
            }//?���(p1,p2)��?���(p3,p4)���܂܂��
            if ((hakononaka(p1, p4, p3) == 2) && (hakononaka(p4, p3, p2) == 2)) {
                return 362;
            }//?���(p1,p2)��?���(p3,p4)���܂܂��

            if ((hakononaka(p3, p1, p2) == 2) && (hakononaka(p1, p2, p4) == 2)) {
                return 363;
            }//?���(p3,p4)��?���(p1,p2)���܂܂��
            if ((hakononaka(p3, p2, p1) == 2) && (hakononaka(p2, p1, p4) == 2)) {
                return 364;
            }//?���(p3,p4)��?���(p1,p2)���܂܂��


            if ((hakononaka(p1, p3, p2) == 2) && (hakononaka(p3, p2, p4) == 2)) {
                return 371;
            }//?���(p1,p2)��P2����?���(p3,p4)��P3���������I��?d�Ȃ�
            if ((hakononaka(p1, p4, p2) == 2) && (hakononaka(p4, p2, p3) == 2)) {
                return 372;
            }//?���(p1,p2)��P2����?���(p4,p3)��P4���������I��?d�Ȃ�

            if ((hakononaka(p3, p1, p4) == 2) && (hakononaka(p1, p4, p2) == 2)) {
                return 373;
            }//?���(p3,p4)��P4����?���(p1,p2)��P1���������I��?d�Ȃ�
            if ((hakononaka(p4, p1, p3) == 2) && (hakononaka(p1, p3, p2) == 2)) {
                return 374;
            }//?���(p4,p3)��P3����?���(p1,p2)��P1���������I��?d�Ȃ�

            return 0;
        }
        return -1;//�����͉��炩�̃G��?[�̎��ɒʂ�?B

    }


    //senbun_kousa_hantei_amai�̊Â��Ƃ����?A��̓I�ɂ�return 21����return 28�܂ł̑O��ɂȂ�	if( (hakononaka(p1,pk,p2)>=1)&& (hakononaka(p3,pk,p4)>=1) )�̂�����
    // (hakononaka_amai(p1,pk,p2)>=1)&& (hakononaka_amai(p3,pk,p4)���g���Ă��邱��?Bhakononaka_amai��
    //�_pa��?A��_p1,p2��[�_�Ƃ���?����ɓ_p1�Ɠ_p2�Œ�?s����?A2��?������܂ޒ����`���ɂ���?�?���2��Ԃ���?�?B����� ?����͂�?o���Ă������`���ɂ���Ƃ݂Ȃ�?B
    //��̓I�ɂ�?����̒��ɓ_�����邩�̔����?�?A�킸���ɓ_��?����̊O�ɂ���?�?���?A?����̒��ɂ����?A�Â����肷��?B�`��?E?l�œW�J?}��`���Ƃ���?A���̊Â��ق����g��Ȃ���T���^��?����̌�?������Ɏ��s����
    //������?A�Ȃ���?A?܂�?��?���ɂ��̊Â��ق����g���Ɩ�����?[�v�ɂȂ�悤��?A���܂������Ȃ�?B����?��m�ȉ𖾂͖�����20161105

    public int senbun_kousa_hantei_amai(Senbun s1, Senbun s2, double rhit, double rhei) {    //r_hitosii��r_heikouhantei��?Ahitosii��heikou_hantei�̂���̋��e���x
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
        //System.out.print("?@?@?�����?�����ł̕�?s����̌���?@???@");
        //System.out.println (heikou_hantei(t1,t2,rhei));
        // heikou_hantei(t1,t2,rhei)

        //��O?��??@?���s1��?���s2���_��?�?�
        if (((p1.getx() == p2.getx()) && (p1.gety() == p2.gety()))
                &&
                ((p3.getx() == p4.getx()) && (p3.gety() == p4.gety()))) {
            if ((p1.getx() == p3.getx()) && (p1.gety() == p3.gety())) {
                return 4;
            }
            return 0;
        }

        //��O?��??@?���s1���_��?�?�
        if ((p1.getx() == p2.getx()) && (p1.gety() == p2.gety())) {
            if ((hakononaka(p3, p1, p4) >= 1) && (t2.dainyuukeisan(p1) == 0.0)) {
                return 5;
            }
            return 0;
        }

        //��O?��??@?���s2���_��?�?�
        if ((p3.getx() == p4.getx()) && (p3.gety() == p4.gety())) {
            if ((hakononaka(p1, p3, p2) >= 1) && (t1.dainyuukeisan(p3) == 0.0)) {
                return 6;
            }
            return 0;
        }

        // System.out.println("AAAAAAAAAAAA");
        if (heikou_hantei(t1, t2, rhei) == 0) {    //�Q�̒�?�����?s�łȂ�
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

        if (heikou_hantei(t1, t2, rhei) == 1) { //�Q�̒�?�����?s��?Ay?ؕЂ͈�v���Ȃ�
            // System.out.println("BBBBBBBBBBB");
            return 0;
        }

        // �Q��?������S������
        if (hitosii(p1, p3, rhit) && hitosii(p2, p4, rhit)) {
            return 31;
        }
        if (hitosii(p1, p4, rhit) && hitosii(p2, p3, rhit)) {
            return 31;
        }

        // System.out.println("###########");

        //�Q�̒�?�����?s��?Ay?ؕЂ���v����
        if (heikou_hantei(t1, t2, rhei) == 2) {
            if (hitosii(p1, p3, rhit)) { //2��?����̒[�_�ǂ�����1�_��?d�Ȃ�?�?�
                if (hakononaka(p1, p4, p2) == 2) {
                    return 321;
                }//����?����ɒZ��?������܂܂��
                if (hakononaka(p3, p2, p4) == 2) {
                    return 322;
                }//����?����ɒZ��?������܂܂��
                if (hakononaka(p2, p1, p4) == 2) {
                    return 323;
                }//2��?�����1�_��?d�Ȃ邾����?A����ȊO�ł�?d�Ȃ�Ȃ�
            }

            if (hitosii(p1, p4, rhit)) {
                if (hakononaka(p1, p3, p2) == 2) {
                    return 331;
                }//����?����ɒZ��?������܂܂��
                if (hakononaka(p4, p2, p3) == 2) {
                    return 332;
                }//����?����ɒZ��?������܂܂��
                if (hakononaka(p2, p1, p3) == 2) {
                    return 333;
                }//2��?�����1�_��?d�Ȃ邾����?A����ȊO�ł�?d�Ȃ�Ȃ�
            }

            if (hitosii(p2, p3, rhit)) {
                if (hakononaka(p2, p4, p1) == 2) {
                    return 341;
                }//����?����ɒZ��?������܂܂��
                if (hakononaka(p3, p1, p4) == 2) {
                    return 342;
                }//����?����ɒZ��?������܂܂��
                if (hakononaka(p1, p2, p4) == 2) {
                    return 343;
                }//2��?�����1�_��?d�Ȃ邾����?A����ȊO�ł�?d�Ȃ�Ȃ�
            }

            if (hitosii(p2, p4, rhit)) {
                if (hakononaka(p2, p3, p1) == 2) {
                    return 351;
                }//����?����ɒZ��?������܂܂��
                if (hakononaka(p4, p1, p3) == 2) {
                    return 352;
                }//����?����ɒZ��?������܂܂��
                if (hakononaka(p1, p2, p3) == 2) {
                    return 353;
                }//2��?�����1�_��?d�Ȃ邾����?A����ȊO�ł�?d�Ȃ�Ȃ�
            }

            //2��?����̒[�_�ǂ�����?d�Ȃ�Ȃ�?�?�
            if ((hakononaka(p1, p3, p4) == 2) && (hakononaka(p3, p4, p2) == 2)) {
                return 361;
            }//?���(p1,p2)��?���(p3,p4)���܂܂��
            if ((hakononaka(p1, p4, p3) == 2) && (hakononaka(p4, p3, p2) == 2)) {
                return 362;
            }//?���(p1,p2)��?���(p3,p4)���܂܂��

            if ((hakononaka(p3, p1, p2) == 2) && (hakononaka(p1, p2, p4) == 2)) {
                return 363;
            }//?���(p3,p4)��?���(p1,p2)���܂܂��
            if ((hakononaka(p3, p2, p1) == 2) && (hakononaka(p2, p1, p4) == 2)) {
                return 364;
            }//?���(p3,p4)��?���(p1,p2)���܂܂��

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
        return -1;//�����͉��炩�̃G��?[�̎��ɒʂ�?B

    }


    //�Q�̒�?�����?s���ǂ����𔻒肷���?�?B
    public int heikou_hantei(Tyokusen t1, Tyokusen t2) {
        return heikou_hantei(t1, t2, 0.1);
    }

    //�Q��?�������?s���ǂ����𔻒肷���?�?B
    public int heikou_hantei(Senbun s1, Senbun s2, double r) {
        return heikou_hantei(Senbun2Tyokusen(s1), Senbun2Tyokusen(s2), r);
    }


    public int heikou_hantei(Tyokusen t1, Tyokusen t2, double r) {//r�͌�?��̋��e�x?Br�����Ȃ猵������?B
        //0=��?s�łȂ�?A1=��?s�łQ��?�����v���Ȃ�?A2=��?s�łQ��?�����v����
        double a1 = t1.geta(), b1 = t1.getb(), c1 = t1.getc();//��?�t1, a1*x+b1*y+c1=0�̊e�W?����?�߂�?B
        double a2 = t2.geta(), b2 = t2.getb(), c2 = t2.getc();//��?�t2, a2*x+b2*y+c2=0�̊e�W?����?�߂�?B

        //System.out.print("��?s�����r?@???@");System.out.println(r);
        //�����ɔ���----------------------------------------
        if (r <= 0.0) {
            //�Q��?�����?s��?�?�
            if (a1 * b2 - a2 * b1 == 0) {
                //�Q��?��͓����?�?�
                if ((a1 * a1 + b1 * b1) * c2 * c2 == (a2 * a2 + b2 * b2) * c1 * c1) {
                    return 2;
                }//�����ɔ���?B
                //�Q��?����قȂ�?�?�
                else {
                    return 1;
                }
            }
        }

        //��?������e----------------------------------------
        if (r > 0) {
            //�Q��?�����?s��?�?�
            if (Math.abs(a1 * b2 - a2 * b1) < r) {
                //�Q��?��͓����?�?�


                //���_?i0?A0?j�Ɗe��?��Ƃ̋������r
                //double kyoriT=Math.abs(c1/Math.sqrt(a1*a1+b1*b1)-c2/Math.sqrt(a2*a2+b2*b2));//20181027?Aver3.049�܂ł̃o�O�����?��?
                //double kyoriT=Math.abs(   Math.abs(  c1/Math.sqrt(a1*a1+b1*b1)  )  -   Math.abs(  c2/Math.sqrt(a2*a2+b2*b2)  )      );//20181027?Aver3.050��?~�̃o�O������?��?
                double kyoriT = t2.kyorikeisan(t1.kage_motome(new Ten(0.0, 0.0)));//t1?�̓_��t2�Ƃ̋���//t1.kage_motome(new Ten(0.0,0.0))   �͓_?i0,0?j��t1?�̉e���?�߂�?it1?�̓_�Ȃ�Ȃ�ł�����?j//20181115?C?�


                if (kyoriT < r) {//��?������e?B
                    return 2;
                }
                //�Q��?����قȂ�?�?�
                else {
                    return 1;
                }
            }
        }

        //�Q��?�����?s��?�?�-------------------------------------------------
        return 0;
    }


    //�Q�̒�?��̌�_���?�߂��?�
    public Ten kouten_motome(Tyokusen t1, Tyokusen t2) {
        double a1 = t1.geta(), b1 = t1.getb(), c1 = t1.getc();//��?�t1, a1*x+b1*y+c1=0�̊e�W?����?�߂�?B
        double a2 = t2.geta(), b2 = t2.getb(), c2 = t2.getc();//��?�t2, a2*x+b2*y+c2=0�̊e�W?����?�߂�?B

//System.out.println("   "+(b1*c2-b2*c1)/(a1*b2-a2*b1)+"::::::::"+(a2*c1-a1*c2)/(a1*b2-a2*b1));

        return new Ten((b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1), (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1));
    }


    //�Q�̒�?��̌�_���?�߂��?�(��?�)
    public Ten kouten_motome_01(Tyokusen t1, Tyokusen t2) {
        double a1 = t1.geta(), b1 = t1.getb(), c1 = t1.getc();//��?�t1, a1*x+b1*y+c1=0�̊e�W?����?�߂�?B
        double a2 = t2.geta(), b2 = t2.getb(), c2 = t2.getc();//��?�t2, a2*x+b2*y+c2=0�̊e�W?����?�߂�?B
        return new Ten((b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1), (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1));
    }


    public Tyokusen Senbun2Tyokusen(Senbun s) {//?������܂ޒ�?��𓾂�
        Tyokusen t = new Tyokusen(s.geta(), s.getb());
        return t;
    }

    //�Q��?�����?��Ƃ݂Ȃ��Č�_���?�߂��?�?B?����Ƃ��Ă͌�?����Ȃ��Ă�?A��?��Ƃ��Č�?����Ă���?�?��̌�_��Ԃ�
    public Ten kouten_motome(Senbun s1, Senbun s2) {
        return kouten_motome(Senbun2Tyokusen(s1), Senbun2Tyokusen(s2));
    }

    //?�����?��Ƃ݂Ȃ��đ��̒�?��Ƃ̌�_���?�߂��?�?B?����Ƃ��Ă͌�?����Ȃ��Ă�?A��?��Ƃ��Č�?����Ă���?�?��̌�_��Ԃ�
    public Ten kouten_motome(Tyokusen t1, Senbun s2) {
        return kouten_motome(t1, Senbun2Tyokusen(s2));
    }

    //?�����?��Ƃ݂Ȃ��đ��̒�?��Ƃ̌�_���?�߂��?�?B?����Ƃ��Ă͌�?����Ȃ��Ă�?A��?��Ƃ��Č�?����Ă���?�?��̌�_��Ԃ�
    public Ten kouten_motome(Senbun s1, Tyokusen t2) {
        return kouten_motome(Senbun2Tyokusen(s1), t2);
    }


    //?�����?^���ɕ�?s�ړ������?�?i����?����͕ς�����?V����?�����Ԃ�?j
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
    //�_a��?S�ɓ_b��d�x��]�����_��Ԃ���?�?i���̓_�͕ς�����?V�����_��Ԃ�?j
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
    //�_a��?S�ɓ_b��d�x��]��ab�̋�����r�{�̓_��Ԃ���?�?i���̓_�͕ς�����?V�����_��Ԃ�?j
    public Ten ten_kaiten(Ten a, Ten b, double d, double r) {

        double Mcd = Math.cos(d * Math.PI / 180.0);
        double Msd = Math.sin(d * Math.PI / 180.0);

        double bx1 = r * (Mcd * (b.getx() - a.getx()) - Msd * (b.gety() - a.gety())) + a.getx();
        double by1 = r * (Msd * (b.getx() - a.getx()) + Mcd * (b.gety() - a.gety())) + a.gety();

        Ten t_return = new Ten(bx1, by1);

        return t_return;
    }

    //------------------------------------
    //�_a��?S�ɓ_b�����ɂ���ab�̋�����r�{�̓_��Ԃ���?�?i���̓_�͕ς�����?V�����_��Ԃ�?j20161224 ����?�
    public Ten ten_bai(Ten a, Ten b, double r) {
        double bx1 = r * (b.getx() - a.getx()) + a.getx();
        double by1 = r * (b.gety() - a.gety()) + a.gety();

        Ten t_return = new Ten(bx1, by1);

        return t_return;
    }


//------------------------------------

    //?���ab��c��?S��r�{����d�x��]����?�����Ԃ���?�?i����?����͕ς�����?V����?�����Ԃ�?j
    public Senbun Senbun_kaiten(Senbun s0, Ten c, double d, double r) {
        Senbun s_return = new Senbun(ten_kaiten(s0.geta(), c, d, r), ten_kaiten(s0.getb(), c, d, r));
        return s_return;
    }


// ------------------------------------

    //?���ab��a��?S��d�x��]����?�����Ԃ���?�?i����?����͕ς�����?V����?�����Ԃ�?j
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


    //?���ab��a��?S��r�{����d�x��]����?�����Ԃ���?�?i����?����͕ς�����?V����?�����Ԃ�?j
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


    //?���ab��a��?S��r�{����?�����Ԃ���?�?i����?����͕ς�����?V����?�����Ԃ�?j
    public Senbun Senbun_bai(Senbun s0, double r) {

        double bx1 = r * (s0.getbx() - s0.getax()) + s0.getax();
        double by1 = r * (s0.getby() - s0.getay()) + s0.getay();

        double ax1 = s0.getax();
        double ay1 = s0.getay();
        Senbun s_return = new Senbun(ax1, ay1, bx1, by1);

        return s_return;
    }


    //?���A��?A?���J�����Ƃ�����?ƈʒu�ɂ���?���B���?�߂��?�
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


    //��?�t0�Ɋւ���?A�_p�̑�?ƈʒu�ɂ���_���?�߂��?�
    public Ten sentaisyou_ten_motome(Tyokusen t0, Ten p) {
        Ten p1 = new Ten();  // p1.set(s.geta());
        Ten p2 = new Ten();  // p2.set(s.getb());

        Tyokusen s1 = new Tyokusen();
        s1.set(t0);
        Tyokusen s2 = new Tyokusen();
        s2.set(t0);

        s2.tyokkouka(p);//�_p��ʂ��� s1�ɒ�?s���钼?�s2���?�߂�?B

        p1 = kouten_motome(s1, s2);
        p2.set(2.0 * p1.getx() - p.getx(), 2.0 * p1.gety() - p.gety());
        return p2;
    }

    //�Q�̓_t1,t2��ʂ钼?��Ɋւ���?A�_p�̑�?ƈʒu�ɂ���_���?�߂��?�
    public Ten sentaisyou_ten_motome(Ten t1, Ten t2, Ten p) {
        Ten p1 = new Ten();  // p1.set(s.geta());
        Ten p2 = new Ten();  // p2.set(s.getb());

        Tyokusen s1 = new Tyokusen(t1, t2);
        Tyokusen s2 = new Tyokusen(t1, t2);

        s2.tyokkouka(p);//�_p��ʂ��� s1�ɒ�?s���钼?�s2���?�߂�?B

        p1 = kouten_motome(s1, s2);
        p2.set(2.0 * p1.getx() - p.getx(), 2.0 * p1.gety() - p.gety());
        return p2;
    }

    //�p�x��-180.0�x���傫��180.0�x�ȉ��ɉ��������?�
    public double kakudo_osame_m180_180(double kakudo) {
        while (kakudo <= -180.0) {
            kakudo = kakudo + 360.0;
        }
        while (kakudo > 180.0) {
            kakudo = kakudo - 360.0;
        }
        return kakudo;
    }

    //�p�x��0.0�x��?�360.0�x�����ɉ��������?�
    public double kakudo_osame_0_360(double kakudo) {
        while (kakudo < 0.0) {
            kakudo = kakudo + 360.0;
        }
        while (kakudo >= 360.0) {
            kakudo = kakudo - 360.0;
        }
        return kakudo;
    }


    //�p�x��0.0�x��?�kmax�x�����ɉ��������?�(�~??�̒��_�̕�����?�ȂǂŎg��)
    public double kakudo_osame_0_kmax(double kakudo, double kmax) {
        while (kakudo < 0.0) {
            kakudo = kakudo + kmax;
        }
        while (kakudo >= kmax) {
            kakudo = kakudo - kmax;
        }
        return kakudo;
    }


    //?���s1��s2�̂Ȃ��p�x
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


    //�x�N�g��ab��cd�̂Ȃ��p�x
    public double kakudo(Ten a, Ten b, Ten c, Ten d) {
        return kakudo_osame_0_360(kakudo(c, d) - kakudo(a, b));
    }

    //�O�p�`�̓�?S���?�߂�
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
    //�����_���?�߂�?B
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
        double nagasa_a = t0.kyorikeisan(e1.get_tyuusin());  //t0��t1�̌�_����e1�̒�?S�܂ł̒���

//double nagasa_a=kyori(kouten_t0t1,e1.get_tyuusin());  //t0��t1�̌�_����e1�̒�?S�܂ł̒���
        double nagasa_b = Math.sqrt(e1.getr() * e1.getr() - nagasa_a * nagasa_a); //t0��t1�̌�_����e1��e2�̌�_�܂ł̒���
//t0�ƕ�?s�ȕ����x�N�g����(t0.getb() , -t0.geta())
//t0�ƕ�?s�ȕ����x�N�g���Œ�����nagasa_b�̂��̂�(t0.getb()*nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta() ) , -t0.geta()*nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta() ))

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
        double nagasa_a = t0.kyorikeisan(e1.get_tyuusin());  //t0��t1�̌�_����e1�̒�?S�܂ł̒���

//double nagasa_a=kyori(kouten_t0t1,e1.get_tyuusin());  //t0��t1�̌�_����e1�̒�?S�܂ł̒���
        double nagasa_b = Math.sqrt(e1.getr() * e1.getr() - nagasa_a * nagasa_a); //t0��t1�̌�_����e1��e2�̌�_�܂ł̒���
//t0�ƕ�?s�ȕ����x�N�g����(t0.getb() , -t0.geta())
//t0�ƕ�?s�ȕ����x�N�g���Œ�����nagasa_b�̂��̂�(t0.getb()*nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta() ) , -t0.geta()*nagasa_b/Math.sqrt(t0.getb()*t0.getb()+ t0.geta()*t0.geta() ))

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

    //�_p0��?A�~e0�̉~���Ƃ̊Ԃ̋������?�߂��?�----------------------------------------------------
    public double kyori_ensyuu(Ten p0, En e0) {


        return Math.abs(kyori(p0, e0.get_tyuusin()) - e0.getr());
    }

    //Min��Ԃ���?�
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