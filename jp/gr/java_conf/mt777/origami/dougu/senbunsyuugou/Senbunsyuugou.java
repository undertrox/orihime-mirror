package jp.gr.java_conf.mt777.origami.dougu.senbunsyuugou;

import jp.gr.java_conf.mt777.kiroku.memo.Memo;
import jp.gr.java_conf.mt777.zukei2d.oritacalc.OritaCalc;
import jp.gr.java_conf.mt777.zukei2d.senbun.Senbun;
import jp.gr.java_conf.mt777.zukei2d.ten.Ten;

import java.util.ArrayList;
import java.util.StringTokenizer;

// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
public class Senbunsyuugou {
    int sousuu;               //��?ۂɎg��??����????
    ArrayList Senb = new ArrayList(); //??���̃C���X�^���X��
    OritaCalc oc = new OritaCalc();          //�e��v�Z�p�̊�?����g�����߂̃N���X�̃C���X�^���X��

    public Senbunsyuugou() {
        reset();
    } //�R���X�g���N�^

    public void reset() {
        sousuu = 0;
        Senb.clear();
        Senb.add(new Senbun());
    }

    public void set(Senbunsyuugou ss) {
        sousuu = ss.getsousuu();
        for (int i = 0; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);
            s.set(ss.get(i));
        }
    }

    private Senbun sen(int i) {
        if (sousuu + 1 > Senb.size()) {
            while (sousuu + 1 > Senb.size()) {
                Senb.add(new Senbun());
            }
        }//���̕����Ȃ��Ƃ��܂�?s���Ȃ�?B�Ȃ����̕��łȂ��Ƃ����Ȃ����Ƃ���??�R��?��m�ɂ͂킩��Ȃ�?B
        return (Senbun) Senb.get(i);
    }

    //
    private void senset(int i, Senbun s) {
        if (sousuu + 1 > Senb.size()) {
            while (sousuu + 1 > Senb.size()) {
                Senb.add(new Senbun());
            }
        }//���̕����Ȃ��Ƃ��܂�?s���Ȃ�?B�Ȃ����̕��łȂ��Ƃ����Ȃ����Ƃ���??�R��?��m�ɂ͂킩��Ȃ�?B
        if (i + 1 <= Senb.size()) {
            Senb.set(i, s);
        } //�Ȃ���?A����if���Ȃ��Ƃ��܂�?s���Ȃ�
    }

    //??����???��𓾂�
    public int getsousuu() {
        return sousuu;
    }

    public void setsousuu(int i) {
        sousuu = i;
    }

    //??���𓾂�
    public Senbun get(int i) {
        //Senbun s;s= sen(i);return s;
        return sen(i);
    }

    //i�Ԗڂ�??���̒[�_�𓾂�
    public Ten geta(int i) {
        Senbun s;
        s = sen(i);
        return s.geta();
    }

    public Ten getb(int i) {
        Senbun s;
        s = sen(i);
        return s.getb();
    }

    //i�Ԗڂ�??���̒[�_�𓾂�
    public double getax(int i) {
        Senbun s;
        s = sen(i);
        return s.getax();
    }

    public double getbx(int i) {
        Senbun s;
        s = sen(i);
        return s.getbx();
    }

    public double getay(int i) {
        Senbun s;
        s = sen(i);
        return s.getay();
    }

    public double getby(int i) {
        Senbun s;
        s = sen(i);
        return s.getby();
    }

    //i�Ԗڂ�??���̒[�_�̈ʒu���Z�b�g����
    public void seta(int i, Ten p) {
        Senbun s;
        s = sen(i);
        s.seta(p);
    }

    public void setb(int i, Ten p) {
        Senbun s;
        s = sen(i);
        s.setb(p);
    }

    //i�Ԗڂ�??���̒l����͂���
    public void set(int i, Ten p, Ten q, int ic, int ia) {
        Senbun s;
        s = sen(i);
        s.set(p, q, ic, ia);
    }

    //i�Ԗڂ�??����?F����͂���
    public void setcolor(int i, int icol) {
        Senbun s;
        s = sen(i);
        s.setcolor(icol);
    }

    //i�Ԗڂ�??����?F��?o�͂���
    public int getcolor(int i) {
        Senbun s;
        s = sen(i);
        return s.getcolor();
    }

    //i�Ԗڂ�??���̊�?���?o�͂���
    public int getiactive(int i) {
        Senbun s;
        s = sen(i);
        return s.getiactive();
    }

    //??��?W?��̑S??����?���? Memo�Ƃ���?o�͂���?B
    public Memo getMemo() {
        String str = "";//������????�p�̃N���X�̃C���X�^���X��

        Memo memo1 = new Memo();
        memo1.reset();
        memo1.addGyou("<??��?W??>");

        for (int i = 1; i <= sousuu; i++) {
            memo1.addGyou("��??," + i);
            Senbun s;
            s = sen(i);
            memo1.addGyou("?F," + s.getcolor());
            memo1.addGyou("?��W," + s.getax() + "," + s.getay() + "," +
                    s.getbx() + "," + s.getby());


        }


        return memo1;
    }

    //-----------------------------
    public void setMemo(Memo memo1) {
        int yomiflg = 0;//0�Ȃ�ǂ�?��݂�?s��Ȃ�?B1�Ȃ�ǂ�?���?B
        int ibangou = 0;
        int ic = 0;

        String st = "";
        Double Dd = new Double(0.0);
        Integer Ii = new Integer(0);

        double ax, ay, bx, by;
        String str = "";
        //int jtok;

//�I���q??�p�t�@�C��.orh��ǂ�

//?�?���??����???����?�߂�
        int isen = 0;
        for (int i = 1; i <= memo1.getGyousuu(); i++) {


            StringTokenizer tk = new StringTokenizer(memo1.getGyou(i), ",");
            //jtok=    tk.countTokens();


            str = tk.nextToken();
            if (str.equals("<??��?W??>")) {
                yomiflg = 1;
            }

            if ((yomiflg == 1) && (str.equals("��??"))) {
                isen = isen + 1;

            }
        }

        sousuu = isen;
//?�?���??����???���??�߂�ꂽ
        //

        for (int i = 1; i <= memo1.getGyousuu(); i++) {


            StringTokenizer tk = new StringTokenizer(memo1.getGyou(i), ",");
            //jtok=    tk.countTokens();
            str = tk.nextToken();
            //  	System.out.println("::::::::::"+ str+"<<<<<" );

            if (str.equals("<??��?W??>")) {
                yomiflg = 1;
            }

            if ((yomiflg == 1) && (str.equals("��??"))) {
                str = tk.nextToken();
                ibangou = Integer.parseInt(str);

            }
            if ((yomiflg == 1) && (str.equals("?F"))) {
                str = tk.nextToken();
                ic = Integer.parseInt(str);
                Senbun s;
                s = sen(ibangou);
                s.setcolor(ic);

            }
            if ((yomiflg == 1) && (str.equals("?��W"))) {
                str = tk.nextToken();
                ax = Double.parseDouble(str);
                str = tk.nextToken();
                ay = Double.parseDouble(str);
                str = tk.nextToken();
                bx = Double.parseDouble(str);
                str = tk.nextToken();
                by = Double.parseDouble(str);

                Senbun s;
                s = sen(ibangou);
                s.set(ax, ay, bx, by);
                //	System.out.println(ax );
            }
        }
    }

    //�W�J?}���͎���??��?W?���?�??

    public void bunkatu_seiri() {//?܂�?��??��Ȃǂœ�����?j��?}��?�??
        System.out.println("����?�???@�P?A�_????");
        ten_sakujyo();          //�O�̂���?A�_?��??����?���
        System.out.println("����?�???@�Q?A?d��??��????");
        jyuufuku_senbun_sakujyo();//�O�̂���?A�S����v����??�����Q����΂P��?���
        System.out.println("����?�???@�R?A��?�����");
        kousabunkatu();
        System.out.println("����?�???@�S?A�_????");
        ten_sakujyo();             //?܂�?��??���?j��?}��?�??�̂���?A�_?��??����?���
        System.out.println("����?�???@�T?A?d��??��????");
        jyuufuku_senbun_sakujyo(); //?܂�?��??���?j��?}��?�??�̂���?A�S����v����??�����Q����΂P��?���
    }


    //�S??���̎R�J�����ւ���?B���E??���̎R�J�ȊO��??��͕ω��Ȃ�?B
    public void zen_yama_tani_henkan() {
        int ic_temp;

        for (int ic_id = 1; ic_id <= sousuu; ic_id++) {
            ic_temp = getcolor(ic_id);
            if (ic_temp == 1) {
                ic_temp = 2;
            } else if (ic_temp == 2) {
                ic_temp = 1;
            }
            setcolor(ic_id, ic_temp);
        }
    }


    //Smen��?������邽�߂�??��?W?���?�??

    public void bunkatu_seiri_for_Smen_hassei() {//?܂�?��??��Ȃǂœ�����?j��?}��?�??
        System.out.println("?@?@Senbunsyuugou�̒���?ASmen��?������邽�߂�??��?W?���?�??");
        System.out.println("����?�???@�P?A�_???��O	getsousuu() = " + getsousuu());
        ten_sakujyo();          //�O�̂���?A�_?��??����?���
        System.out.println("����?�???@�Q?A?d��??��???��O	getsousuu() = " + getsousuu());
        jyuufuku_senbun_sakujyo();//�O�̂���?A�S����v����??�����Q����΂P��?���
        System.out.println("����?�???@�R?A��?������O	getsousuu() = " + getsousuu());
        kousabunkatu();
        System.out.println("����?�???@�S?A�_???��O	getsousuu() = " + getsousuu());
        ten_sakujyo();             //?܂�?��??���?j��?}��?�??�̂���?A�_?��??����?���
        System.out.println("����?�???@�T?A?d��??��???��O	getsousuu() = " + getsousuu());
        jyuufuku_senbun_sakujyo(); //?܂�?��??���?j��?}��?�??�̂���?A�S����v����??�����Q����΂P��?���
        System.out.println("����?�???@�T?A?d��??��???��?	getsousuu() = " + getsousuu());
    }


    //�_?��??����????
    public void ten_sakujyo() {
        for (int i = 1; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);
            if (oc.hitosii(s.geta(), s.getb())) {
                delsenbun(i);
                i = i - 1;
            }
        }
    }

    public void ten_sakujyo(double r) {
        for (int i = 1; i <= sousuu; i++) {
            Senbun s;
            s = sen(i);
            if (oc.hitosii(s.geta(), s.getb(), r)) {
                delsenbun(i);
                i = i - 1;
            }
        }
    }

    // �S��?d�Ȃ�??����2�{��?݂���Ƃ��ɔ�??�̒x���ق���???�����?B
    public void jyuufuku_senbun_sakujyo(double r) {
        int[] sakujyo_flg = new int[sousuu + 1];
        Senbun[] snew = new Senbun[sousuu + 1];
        for (int i = 1; i <= sousuu; i++) {
            sakujyo_flg[i] = 0;
            snew[i] = new Senbun();
        }

        for (int i = 1; i <= sousuu - 1; i++) {
            Senbun si;
            si = sen(i);
            for (int j = i + 1; j <= sousuu; j++) {
                Senbun sj;
                sj = sen(j);
                if (r <= -9999.9) {
                    if (oc.senbun_kousa_hantei(si, sj) == 31) {
                        sakujyo_flg[j] = 1;
                    }
                } else {
                    if (oc.senbun_kousa_hantei(si, sj, r, r) == 31) {
                        sakujyo_flg[j] = 1;
                    }
                }
            }
        }

        int smax = 0;
        for (int i = 1; i <= sousuu; i++) {
            if (sakujyo_flg[i] == 0) {
                Senbun si;
                si = sen(i);
                smax = smax + 1;
                snew[smax].set(si);
            }
        }

        sousuu = smax;
        for (int i = 1; i <= sousuu; i++) {
            Senbun si;
            si = sen(i);
            si.set(snew[i]);
        }
    }

    //
    public void jyuufuku_senbun_sakujyo() {
        jyuufuku_senbun_sakujyo(-10000.0);
    }

    //
    public int jyuufuku_senbun_sakujyo(int i, int j) {    //?d����???���������1?A���Ȃ����0��Ԃ�
        if (i == j) {
            return 0;
        }
        Senbun si;
        si = sen(i);
        Senbun sj;
        sj = sen(j);
        if (oc.senbun_kousa_hantei(si, sj) == 31) {  //31��si��sj���S��������?d�Ȃ邱�Ƃ�����
            delsenbun(j);
            return 1;
        }
        return 0;
    }

    //��?����Ă���Q��??���̌�_�łQ��??���𕪊�����?B?@�܂�����?d�Ȃ�??�����Q������???���?A�Ȃ��????���Ȃ���Ȃ��܂܂Q�Ƃ��c��?B
    public void kousabunkatu() {
        int ibunkatu = 1;//�����������1?A�Ȃ����0

        ArrayList k_flg = new ArrayList();//��?������̉e�������邱�Ƃ������t���b�O?B

        for (int i = 0; i <= sousuu + 1; i++) {
            k_flg.add(new Integer(1));
        }

        while (ibunkatu != 0) {
            ibunkatu = 0;
            for (int i = 1; i <= sousuu; i++) {
                Integer I_k_flag = (Integer) k_flg.get(i);
                if (I_k_flag.intValue() == 1) {
                    k_flg.set(i, new Integer(0));
                    for (int j = 1; j <= sousuu; j++) {
                        if (i != j) {
                            Integer J_k_flag = (Integer) k_flg.get(j);
                            if (J_k_flag.intValue() == 1) {
                                int itemp = 0;
                                int old_sousuu = sousuu;
                                itemp = kousabunkatu(i, j);
                                if (old_sousuu < sousuu) {
                                    for (int is = old_sousuu + 1; is <= sousuu; is++) {
                                        k_flg.add(new Integer(1));
                                    }
                                }
                                if (itemp == 1) {
                                    ibunkatu = ibunkatu + 1;
                                    k_flg.set(i, new Integer(1));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

//---------------------

    //��?����Ă���Q��??���̌�_�łQ��??���𕪊�����?B������?s������1?B?s��Ȃ�������0��Ԃ�?B�I���q??2.002���番�����??��?F��?��䂷��悤�ɂ���(?d����������???��͈�{����?A��??�̒x���ق���?F�ɂȂ�)?B
    public int kousabunkatu(int i, int j) {
        if (i == j) {
            return 0;
        }

        Senbun si;
        si = sen(i);
        Senbun sj;
        sj = sen(j);

        Ten p1 = new Ten();
        p1.set(si.geta());
        Ten p2 = new Ten();
        p2.set(si.getb());
        Ten p3 = new Ten();
        p3.set(sj.geta());
        Ten p4 = new Ten();
        p4.set(sj.getb());
        Ten pk = new Ten();


        double ixmax;
        double ixmin;
        double iymax;
        double iymin;

        ixmax = si.getax();
        ixmin = si.getax();
        iymax = si.getay();
        iymin = si.getay();

        if (ixmax < si.getbx()) {
            ixmax = si.getbx();
        }
        if (ixmin > si.getbx()) {
            ixmin = si.getbx();
        }
        if (iymax < si.getby()) {
            iymax = si.getby();
        }
        if (iymin > si.getby()) {
            iymin = si.getby();
        }

        double jxmax;
        double jxmin;
        double jymax;
        double jymin;

        jxmax = sj.getax();
        jxmin = sj.getax();
        jymax = sj.getay();
        jymin = sj.getay();

        if (jxmax < sj.getbx()) {
            jxmax = sj.getbx();
        }
        if (jxmin > sj.getbx()) {
            jxmin = sj.getbx();
        }
        if (jymax < sj.getby()) {
            jymax = sj.getby();
        }
        if (jymin > sj.getby()) {
            jymin = sj.getby();
        }

        if (ixmax + 0.5 < jxmin) {
            return 0;
        }
        if (jxmax + 0.5 < ixmin) {
            return 0;
        }
        if (iymax + 0.5 < jymin) {
            return 0;
        }
        if (jymax + 0.5 < iymin) {
            return 0;
        }

        if (oc.senbun_kousa_hantei(si, sj) == 1) {
            pk.set(oc.kouten_motome(si, sj));    //<<<<<<<<<<<<<<<<<<<<<<<
            si.seta(p1);
            si.setb(pk);
            sj.seta(p3);
            sj.setb(pk);
            addsenbun(p2, pk, si.getcolor());
            addsenbun(p4, pk, sj.getcolor());
            return 1;
        }

        //oc.senbun_kousa_hantei(si,sj)��21����24�܂ł͂��̎��^�̌�?���?A�Ȃɂ����Ȃ�?B

        if (oc.senbun_kousa_hantei(si, sj) == 25) {
            pk.set(oc.kouten_motome(si, sj));    //<<<<<<<<<<<<<<<<<<<<<<<
            sj.seta(p3);
            sj.setb(pk);
            addsenbun(p4, pk, sj.getcolor());
            return 1;
        }

        if (oc.senbun_kousa_hantei(si, sj) == 26) {
            pk.set(oc.kouten_motome(si, sj));    //<<<<<<<<<<<<<<<<<<<<<<<
            sj.seta(p3);
            sj.setb(pk);
            addsenbun(p4, pk, sj.getcolor());
            return 1;
        }

        if (oc.senbun_kousa_hantei(si, sj) == 27) {
            pk.set(oc.kouten_motome(si, sj));    //<<<<<<<<<<<<<<<<<<<<<<<
            si.seta(p1);
            si.setb(pk);
            addsenbun(p2, pk, si.getcolor());
            return 1;
        }

        if (oc.senbun_kousa_hantei(si, sj) == 28) {
            pk.set(oc.kouten_motome(si, sj));    //<<<<<<<<<<<<<<<<<<<<<<<
            si.seta(p1);
            si.setb(pk);
            addsenbun(p2, pk, si.getcolor());
            return 1;
        }
        //
        if (oc.senbun_kousa_hantei(si, sj) == 31) {//2��??�����܂���������???���?A�������Ȃ�?B
            return 0;
        }


        if (oc.senbun_kousa_hantei(si, sj) == 321) {//2��??���̒[�_�ǂ���(p1��p3)��1�_��?d�Ȃ�?Bsi��sj���܂܂��
            si.seta(p2);
            si.setb(p4);

            int jyuufuku_col;
            jyuufuku_col = si.getcolor();
            if (i < j) {
                jyuufuku_col = sj.getcolor();
            }
            sj.setcolor(jyuufuku_col);

            return 1;


        }

        if (oc.senbun_kousa_hantei(si, sj) == 322) {//2��??���̒[�_�ǂ���(p1��p3)��1�_��?d�Ȃ�?Bsj��si���܂܂��
            sj.seta(p2);
            sj.setb(p4);
            int jyuufuku_col;
            jyuufuku_col = si.getcolor();
            if (i < j) {
                jyuufuku_col = sj.getcolor();
            }
            si.setcolor(jyuufuku_col);

            return 1;
        }

        if (oc.senbun_kousa_hantei(si, sj) == 331) {//2��??���̒[�_�ǂ���(p1��p4)��1�_��?d�Ȃ�?Bsi��sj���܂܂��
            si.seta(p2);
            si.setb(p3);

            int jyuufuku_col;
            jyuufuku_col = si.getcolor();
            if (i < j) {
                jyuufuku_col = sj.getcolor();
            }
            sj.setcolor(jyuufuku_col);

            return 1;
        }

        if (oc.senbun_kousa_hantei(si, sj) == 332) {//2��??���̒[�_�ǂ���(p1��p4)��1�_��?d�Ȃ�?Bsj��si���܂܂��
            sj.seta(p2);
            sj.setb(p3);
            int jyuufuku_col;
            jyuufuku_col = si.getcolor();
            if (i < j) {
                jyuufuku_col = sj.getcolor();
            }
            si.setcolor(jyuufuku_col);
            return 1;
        }

        if (oc.senbun_kousa_hantei(si, sj) == 341) {//2��??���̒[�_�ǂ���(p2��p3)��1�_��?d�Ȃ�?Bsi��sj���܂܂��
            si.seta(p1);
            si.setb(p4);
            int jyuufuku_col;
            jyuufuku_col = si.getcolor();
            if (i < j) {
                jyuufuku_col = sj.getcolor();
            }
            sj.setcolor(jyuufuku_col);

            return 1;
        }

        if (oc.senbun_kousa_hantei(si, sj) == 342) {//2��??���̒[�_�ǂ���(p2��p3)��1�_��?d�Ȃ�?Bsj��si���܂܂��
            sj.seta(p1);
            sj.setb(p4);
            int jyuufuku_col;
            jyuufuku_col = si.getcolor();
            if (i < j) {
                jyuufuku_col = sj.getcolor();
            }
            si.setcolor(jyuufuku_col);


            return 1;
        }

        if (oc.senbun_kousa_hantei(si, sj) == 351) {//2��??���̒[�_�ǂ���(p2��p4)��1�_��?d�Ȃ�?Bsi��sj���܂܂��


            si.seta(p1);
            si.setb(p3);

            int jyuufuku_col;
            jyuufuku_col = si.getcolor();
            if (i < j) {
                jyuufuku_col = sj.getcolor();
            }
            sj.setcolor(jyuufuku_col);

            return 1;
        }

        if (oc.senbun_kousa_hantei(si, sj) == 352) {//2��??���̒[�_�ǂ���(p2��p4)��1�_��?d�Ȃ�?Bsj��si���܂܂��
            sj.seta(p1);
            sj.setb(p3);
            int jyuufuku_col;
            jyuufuku_col = si.getcolor();
            if (i < j) {
                jyuufuku_col = sj.getcolor();
            }
            si.setcolor(jyuufuku_col);

            return 1;
        }


        if (oc.senbun_kousa_hantei(si, sj) == 361) {//p1-p3-p4-p2��??
            si.seta(p1);
            si.setb(p3);

            addsenbun(p2, p4, si.getcolor());
            int jyuufuku_col;
            jyuufuku_col = si.getcolor();
            if (i < j) {
                jyuufuku_col = sj.getcolor();
            }
            sj.setcolor(jyuufuku_col);

            return 1;
        }

        if (oc.senbun_kousa_hantei(si, sj) == 362) {//p1-p4-p3-p2��??
            si.seta(p1);
            si.setb(p4);

            addsenbun(p2, p3, si.getcolor());

            int jyuufuku_col;
            jyuufuku_col = si.getcolor();
            if (i < j) {
                jyuufuku_col = sj.getcolor();
            }
            sj.setcolor(jyuufuku_col);

            return 1;
        }

        if (oc.senbun_kousa_hantei(si, sj) == 363) {//p3-p1-p2-p4��??
            sj.seta(p1);
            sj.setb(p3);

            addsenbun(p2, p4, sj.getcolor());

            int jyuufuku_col;
            jyuufuku_col = si.getcolor();
            if (i < j) {
                jyuufuku_col = sj.getcolor();
            }
            si.setcolor(jyuufuku_col);

            return 1;
        }

        if (oc.senbun_kousa_hantei(si, sj) == 364) {//p3-p2-p1-p4��??
            sj.seta(p1);
            sj.setb(p4);

            addsenbun(p2, p3, sj.getcolor());

            int jyuufuku_col;
            jyuufuku_col = si.getcolor();
            if (i < j) {
                jyuufuku_col = sj.getcolor();
            }
            si.setcolor(jyuufuku_col);

            return 1;
        }

        //
        if (oc.senbun_kousa_hantei(si, sj) == 371) {//p1-p3-p2-p4��??
            //System.out.println("371");
            si.seta(p1);
            si.setb(p3);

            sj.seta(p2);
            sj.setb(p4);

            int jyuufuku_col;
            jyuufuku_col = si.getcolor();
            if (i < j) {
                jyuufuku_col = sj.getcolor();
            }
            addsenbun(p2, p3, jyuufuku_col);
            return 1;
        }

        if (oc.senbun_kousa_hantei(si, sj) == 372) {//p1-p4-p2-p3��??
            //System.out.println("372");
            si.seta(p1);
            si.setb(p4);

            sj.seta(p3);
            sj.setb(p2);

            int jyuufuku_col;
            jyuufuku_col = si.getcolor();
            if (i < j) {
                jyuufuku_col = sj.getcolor();
            }
            addsenbun(p2, p4, jyuufuku_col);
            return 1;
        }

        if (oc.senbun_kousa_hantei(si, sj) == 373) {//p3-p1-p4-p2��??
            //System.out.println("373");
            sj.seta(p1);
            sj.setb(p3);
            si.seta(p2);
            si.setb(p4);
            int jyuufuku_col;
            jyuufuku_col = si.getcolor();
            if (i < j) {
                jyuufuku_col = sj.getcolor();
            }
            addsenbun(p1, p4, jyuufuku_col);
            return 1;
        }

        if (oc.senbun_kousa_hantei(si, sj) == 374) {//p4-p1-p3-p2��??
            //System.out.println("374");
            sj.seta(p1);
            sj.setb(p4);
            si.seta(p3);
            si.setb(p2);
            int jyuufuku_col;
            jyuufuku_col = si.getcolor();
            if (i < j) {
                jyuufuku_col = sj.getcolor();
            }
            addsenbun(p1, p3, jyuufuku_col);
            return 1;
        }

        return 0;
    }


    //??���̒ǉ�-------------------------------
    public void addsenbun(Ten pi, Ten pj, int i_c) {
        sousuu++;

        Senbun s;
        s = sen(sousuu);
        s.set(pi, pj, i_c);
    }

    //??���̒ǉ�-------------------------------
    public void addsenbun(double ax, double ay, double bx, double by, int ic) {
        sousuu++;

        Senbun s;
        s = sen(sousuu);
        s.set(ax, ay, bx, by, ic);
    }

    //??���̒ǉ�-------------------------------
    public void addsenbun(Ten pi, Ten pj) {
        sousuu++;

        Senbun s;
        s = sen(sousuu);

        s.seta(pi);
        s.setb(pj);
    }

    //??����????-----------------------------------------
    public void delsenbun(int j) {   //j�Ԗڂ�??����???�����
        for (int i = j; i <= sousuu - 1; i++) {
            Senbun si;
            si = sen(i);
            Senbun si1;
            si1 = sen(i + 1);
            si.set(si1);

        }
        sousuu--;
    }

    //i�Ԗڂ�??���̒����𓾂�---------------------------
    public double getnagasa(int i) {
        Senbun s;
        s = sen(i);
        return s.getnagasa();
    }

    //���p�`���`?�����?A�}?�ɂȂ��Ă���??����???�����?B
    public void eda_kesi(double r) {
        int iflga = 0;
        int iflgb = 0;
        for (int i = 1; i <= sousuu; i++) {
            iflga = 0;
            iflgb = 0;
            Senbun si;
            si = sen(i);
            for (int j = 1; j <= sousuu; j++) {
                if (i != j) {
                    Senbun sj;
                    sj = sen(j);
                    if (oc.kyori(si.geta(), sj.geta()) < r) {
                        iflga = 1;
                    }
                    if (oc.kyori(si.geta(), sj.getb()) < r) {
                        iflga = 1;
                    }
                    if (oc.kyori(si.getb(), sj.geta()) < r) {
                        iflgb = 1;
                    }
                    if (oc.kyori(si.getb(), sj.getb()) < r) {
                        iflgb = 1;
                    }
                }
            }

            if ((iflga == 0) || (iflgb == 0)) {
                delsenbun(i);
                i = 1;
            }
        }
    }

    //��{�����̗���Ă���??����???�����?B
    public void tanSenbun_sakujyo(double r) {
        int iflg = 0;
        for (int i = 1; i <= sousuu; i++) {
            iflg = 0;
            Senbun si;
            si = sen(i);
            for (int j = 1; j <= sousuu; j++) {
                if (i != j) {
                    Senbun sj;
                    sj = sen(j);
                    if (oc.kyori(si.geta(), sj.geta()) < r) {
                        iflg = 1;
                    }
                    if (oc.kyori(si.getb(), sj.getb()) < r) {
                        iflg = 1;
                    }
                    if (oc.kyori(si.geta(), sj.getb()) < r) {
                        iflg = 1;
                    }
                    if (oc.kyori(si.getb(), sj.geta()) < r) {
                        iflg = 1;
                    }
                }
            }

            if (iflg == 0) {
                delsenbun(i);
                i = 1;
            }
        }
    }


    //�_p�ɋ߂�(r�ȓ�)??����������?A���̔�??��Ԃ���??(������?Aj�Ԗڂ�??���͑�?ۊO)?B�߂�??�����Ȃ����?A0��Ԃ�---------------------------------
    //������?ۊO�ɂ���??��������???���?Aj��0�Ƃ�����?�?��Ƃ��ɂ���?B
    //070317?@�ǉ��@�\?@j?@��?@-10?@�̎���?@��?������Ă��Ȃ��}?igetiactive(i)��0?j���?ۂɂ���?B

    public int senbun_sagasi(Ten p, double r, int j) {
        if (j == -10) {
            for (int i = 1; i <= sousuu; i++) {
                if (((senbun_busyo_sagasi(i, p, r) == 1) && (i != j)) && (getiactive(i) == 0)) {
                    return i;
                }
            }
            for (int i = 1; i <= sousuu; i++) {
                if (((senbun_busyo_sagasi(i, p, r) == 2) && (i != j)) && (getiactive(i) == 0)) {
                    return i;
                }
            }
            for (int i = 1; i <= sousuu; i++) {
                if (((senbun_busyo_sagasi(i, p, r) == 3) && (i != j)) && (getiactive(i) == 0)) {
                    return i;
                }
            }
            return 0;
        }

        for (int i = 1; i <= sousuu; i++) {
            if ((senbun_busyo_sagasi(i, p, r) == 1) && (i != j)) {
                return i;
            }
        }
        for (int i = 1; i <= sousuu; i++) {
            if ((senbun_busyo_sagasi(i, p, r) == 2) && (i != j)) {
                return i;
            }
        }
        for (int i = 1; i <= sousuu; i++) {
            if ((senbun_busyo_sagasi(i, p, r) == 3) && (i != j)) {
                return i;
            }
        }
        return 0;
    }


    //�_p���w�肳�ꂽ??���Ƃǂ̕�?��ŋ߂�(r�ȓ�)���ǂ����𔻒肷���???@---------------------------------
    //0=�߂��Ȃ�?A1=a�_�ɋ߂�?A2=b�_�ɋ߂�?A3=���̕����ɋ߂�
    public int senbun_busyo_sagasi(int i, Ten p, double r) {
        if (r > oc.kyori(p, geta(i))) {
            return 1;
        }//a�_�ɋ߂����ǂ���
        if (r > oc.kyori(p, getb(i))) {
            return 2;
        }//b�_�ɋ߂����ǂ���
        if (r > oc.kyori_senbun(p, get(i))) {
            return 3;
        }//���̕����ɋ߂����ǂ���
        return 0;
    }


    //�_p��?ł��߂�??���̔�??��Ԃ�
    public int mottomo_tikai_senbun_sagasi(Ten p) {
        int minrid = 0;
        double minr = 100000;
        for (int i = 1; i <= sousuu; i++) {
            double sk = oc.kyori_senbun(p, get(i));
            if (minr > sk) {
                minr = sk;
                minrid = i;
            }//���̕����ɋ߂����ǂ���

        }
        return minrid;
    }


    //�_p��?ł��߂�??���̒[�_��Ԃ�
    public Ten mottomo_tikai_Ten_sagasi(Ten p) {

        Ten p_return = new Ten();
        p_return.set(100000.0, 100000.0);
        Ten p_temp = new Ten();
        for (int i = 1; i <= sousuu; i++) {
            p_temp.set(geta(i));
            if (p.kyori2jyou(p_temp) < p.kyori2jyou(p_return)) {
                p_return.set(p_temp.getx(), p_temp.gety());
            }
            p_temp.set(getb(i));
            if (p.kyori2jyou(p_temp) < p.kyori2jyou(p_return)) {
                p_return.set(p_temp.getx(), p_temp.gety());
            }
            //p_temp.set(geta(i));if(p.kyori(p_temp)<p.kyori(p_return) ) {p_return.set(p_temp.getx(),p_temp.gety()); }
            //p_temp.set(getb(i));if(p.kyori(p_temp)<p.kyori(p_return) ) {p_return.set(p_temp.getx(),p_temp.gety()); }

        }
        return p_return;
    }


    //�_p�̋߂���??���̊�?���
    public void kasseika(Ten p, double r) {
        for (int i = 1; i <= sousuu; i++) {
            Senbun si;
            si = sen(i);
            si.kasseika(p, r);
        }
    }

    //�S??���̔�?���
    public void hikasseika() {
        for (int i = 1; i <= sousuu; i++) {
            Senbun si;
            si = sen(i);
            si.hikasseika();
        }
    }


    //??���̊�?������ꂽ���̂�_p��?��W�ɂ���
    public void set(Ten p) {
        for (int i = 1; i <= sousuu; i++) {
            Senbun si;
            si = sen(i);
            si.set(p);
        }

    }

    //??��?W?��̒���??��i0��?Ai0�ȊO��?A�S��?d�Ȃ�??���������?A���̔�??��Ԃ�?B�Ȃ����-10��Ԃ�?B
    public int kasanari_senbun_sagasi(int i0) {
        //int minrid=0;double minr=100000;
        for (int i = 1; i <= sousuu; i++) {
            if (i != i0) {
                if (oc.senbun_kousa_hantei(get(i), get(i0)) == 31) {
                    return i;
                }
            }
        }
        return -10;


    }


}