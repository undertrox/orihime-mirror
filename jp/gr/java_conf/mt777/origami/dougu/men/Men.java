package jp.gr.java_conf.mt777.origami.dougu.men;

import java.util.ArrayList;

public class Men {
    ArrayList TenidL = new ArrayList();
    int Tenidsuu;
    int icol;

    //Ten kanrenTen =new Ten();//–Ê‚ÉŠÖ˜A‚·‚é“_‚ðŠi”[?B–Ê“à•”‚Ì“_‚Æ‚©‚ðŠi”[‚·‚é‚Ì‚ÉŽg‚¤?B•K‚¸‚µ‚àŽg‚¤•K—v‚Í–³‚¢‚Ì‚Å?AŽg‚í‚È‚¢‚Æ‚«‚Í–³Ž‹‚µ‚Ä‚¢‚¢?B
    //ƒRƒ“ƒXƒgƒ‰ƒNƒ^
    public Men() {
        Tenidsuu = 0;
        icol = 0;
        TenidL.add(new Integer(0));
    }

    //ƒRƒ“ƒXƒgƒ‰ƒNƒ^
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

    private void okikae() { //Tenid[n+1]‚Ì’l‚ðTenid[n]‚Ì’l‚É’u‚«Š·‚¦‚é?BTenid[1]‚Ì’l‚Í?A?ÅŒã‚ÌTenid‚É‚·‚é
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

    public int getTenidmin() {    //–Êmptemp‚ÉŠÜ‚Ü‚ê‚é–_‚Ìid‚Ì?Å?¬’l‚ð‹?‚ß‚é?B
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

    public void seiretu() { //Tenid[1]‚Ì’l‚ªTenid[]‚Ì‚È‚©‚Å?Å?¬‚É‚È‚é‚æ‚¤‚É?®—ñ‚·‚é?B
        int idmin;
        idmin = getTenidmin();
        while (getTenid(1) != idmin) {
            okikae();
        }
    }


}