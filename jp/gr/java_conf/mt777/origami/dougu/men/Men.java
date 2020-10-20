package jp.gr.java_conf.mt777.origami.dougu.men;

import java.util.ArrayList;

public class Men {
    ArrayList TenidL = new ArrayList();
    int Tenidsuu;
    int icol;

    //Ten kanrenTen =new Ten();//面に関連する点を格納?B面内部の点とかを格納するのに使う?B必ずしも使う必要は無いので?A使わないときは無視していい?B
    //コンストラクタ
    public Men() {
        Tenidsuu = 0;
        icol = 0;
        TenidL.add(new Integer(0));
    }

    //コンストラクタ
    public Men(Men mn) {
        Tenidsuu = mn.getTenidsuu();
        icol = mn.getcolor();
        for (int i = 0; i <= Tenidsuu; i++) {
            TenidL.add(new Integer(mn.getTenid(i)));
        }
    }

    public void reset() {
        //System.out.println("men?Freset 000 ");
        Tenidsuu = 0;
        icol = 0;

//System.out.println("men?Freset 001 ");
        TenidL.clear();

//System.out.println("men?Freset 002 ");
        TenidL.add(new Integer(0));


    }

    public int getTenidsuu() {
        return Tenidsuu;
    }

    public void setTenidsuu(int i) {
        Tenidsuu = i;
    }

    public void addTenid(int Tid) {
        Tenidsuu = Tenidsuu + 1;
        TenidL.add(new Integer(Tid));
    }

    public int getTenid(int i) {
        Integer I_TenidL = (Integer) TenidL.get(i);
        return I_TenidL.intValue();
    }

    //private	void setTenid(int i,int id){ Tenid[i]=id;}

    private void okikae() { //Tenid[n+1]の値をTenid[n]の値に置き換える?BTenid[1]の値は?A?ﾅ後のTenidにする
        for (int i = 1; i <= Tenidsuu; i++) {
            TenidL.set(i - 1, new Integer(getTenid(i)));
        }
        TenidL.set(Tenidsuu, new Integer(getTenid(0)));
        TenidL.set(0, new Integer(0));

    }

    public void setcolor(int i) {
        icol = i;
    }

    public int getcolor() {
        return icol;
    }

    public int getTenidmin() {    //面mptempに含まれる棒のidの?ﾅ?ｬ値を�?める?B
        //int idmin=10000;
        int idmin = getTenid(1);
        //for(int i=1;i<=Tenidsuu;i++){
        for (int i = 2; i <= Tenidsuu; i++) {
            if (idmin > getTenid(i)) {
                idmin = getTenid(i);
            }
        }
        return idmin;
    }

    public void seiretu() { //Tenid[1]の値がTenid[]のなかで?ﾅ?ｬになるように?ｮ列する?B
        int idmin;
        idmin = getTenidmin();
        while (getTenid(1) != idmin) {
            okikae();
        }
    }


}