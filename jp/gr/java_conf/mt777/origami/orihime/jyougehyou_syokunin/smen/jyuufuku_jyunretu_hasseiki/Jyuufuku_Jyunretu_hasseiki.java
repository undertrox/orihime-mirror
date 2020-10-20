package jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin.smen.jyuufuku_jyunretu_hasseiki;

import jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin.smen.jyuufuku_jyunretu_hasseiki.annaisyo.Annaisyo;

public class Jyuufuku_Jyunretu_hasseiki {//?d•¡?‡—ñ”­?¶‹@
    //?d•¡?‡—ñ‚ð”­?¶‚³‚¹‚éƒNƒ‰ƒX‚ð‰ü‘¢‚µ‚Ä?ASmen?\?¬‚É‰ž‚¶‚½?A–Ê‚Ì?d‚È‚è?‡—ñ‚ðŒø—¦—Ç‚­”­?¶‚³‚¹‚éƒNƒ‰ƒX?B

    int[] ij;//?d•¡?‡—ñ‚ðŠi”[‚·‚é?B
    int Ketasuu = 0;//?d•¡?‡—ñ‚ÌŒ…?”?B‚½‚Æ‚¦‚Î?AŒ…?”‚ª5‚È‚ç?A1‚©‚ç5‚Ü‚Å‚Ì?”Žš‚Å‚Å‚«‚é?‡—ñ‚ð”­?¶‚·‚é
    int i_tabibito;//—·?l‚ÌˆÊ’u
    int[] tizu;//’n?}‚ÌƒCƒ??[ƒW?BŠe–Ê‚ª‚¢‚Ü‚¢‚é“¹‚µ‚é‚×‚Ü‚Å‚É?o‚Ä‚«‚½?”?B?¡‚Ì“¹‚µ‚é‚×‚Ì?ó‘Ô‚Í?”‚¦‚È‚¢?B
    //Annaisyo ann = new Annaisyo();//ˆÄ“à?‘‚ÌƒCƒ??[ƒW?B
    Annaisyo ann; //‚È‚º‚©?A‚±‚Ì?s‚Ì?‘‚«•û‚Å‚ÍƒRƒ“ƒpƒCƒ‹‚Íok‚È‚Ì‚ÉŽÀ?s’†‚ÉƒGƒ‰?[‚ª‚Å‚é‚ª?A‰º‚Ì?s‚Ì?‘‚«•û‚¾‚Æ‚¤‚Ü‚­‚¢‚­
    //  Annaisyo ann = new Annaisyo(0);


    public Jyuufuku_Jyunretu_hasseiki(int k) {  //ƒRƒ“ƒXƒgƒ‰ƒNƒ^
        Ketasuu = k;
        i_tabibito = 0;
        int[] ij0 = new int[k + 10];//?d•¡?‡—ñ‚ðŠi”[‚·‚é?B
        int[] tizu0 = new int[k + 10];  //’n?}‚ÌƒCƒ??[ƒW?BŠe–Ê‚ª‚¢‚Ü‚¢‚é“¹‚µ‚é‚×‚Ü‚Å‚É?o‚Ä‚«‚½?”?B?¡‚Ì“¹‚µ‚é‚×‚Ì?ó‘Ô‚Í?”‚¦‚È‚¢?B
        ij = ij0;
        tizu = tizu0;
        Annaisyo a = new Annaisyo(k + 10);
        ann = a;

//System.out.println("20150309@@@@@@@44444444444444444444@@@@@@@@@" );
        Jyunretu_1banme();
//System.out.println("20150309@@@@@@@55555555555555555555@@@@@@@@@" );
    }

    //---------------
    //private void set_i_tabibito(int i){i_tabibito=i;}

    // ----------------------------------------------------------------
    //Œ»?ó‚Ì?‡—ñ‚©‚çŽŸ‚Ì?‡—ñ‚É?i‚Þ?B
    //kŒ…–Ú‚ð1‚Â?i‚ß‚Ä?Ak-1Œ…ˆÈ‰º‚Í‚Ý‚È1‚É‚·‚é?B•Ô‚è’l‚Í?‡—ñ‚Æ‚µ‚Ä•Ï‚í‚Á‚½Œ…?”
    //Œ»?ó‚Ì?‡—ñ‚ª?ÅŒã‚Ì‚à‚Ì‚¾‚Á‚½?ê?‡‚Í0‚ðreturn‚·‚é?B

    public int susumu(int idousuru_keta) {
        //—·?lˆÚ“®     Œ…?”‚ª‘å‚«‚­‚È‚é•ûŒü‚É?i‚Þ‚Æ‚«‚Í
        //Šeij[]‚Ì’l‚ð“¹‚µ‚é‚×‚É?i‚Þ?BŒ…?”‚ª‘å‚«‚¢‚Æ‚±‚ë‚©‚ç?¬‚³‚¢‚Ù‚¤‚É–ß‚Á‚Ä‚«‚½‚Æ‚«‚ÍŠeij[]‚Ì’l‚ð•Ï‚¦‚é?B
        //’n?}‚ÍŠe“¹‚µ‚é‚×‚Å?CŒ…?”‚ª‚»‚±ˆÈ‰º?i‚»‚±‚àŠÜ‚Þ?j‚Ì“¹‚µ‚é‚×‚Ì?î•ñ‚ðŠÜ‚Þ?B‹ï‘Ì“I‚É‚Í?A‚»‚±‚Ü‚Å?o‚Ä‚«‚½ŠeƒOƒ‹?[ƒv‚²‚Æ‚ÌŒÂ?”?B
        //i_tabibito==Ketasuu‚È‚ç1Œ…–ß‚é?B‚à‚Ç‚Á‚½‚ç?A‚»‚±‚Å’¼‚¿‚É‚»‚±‚ÌˆÊ’u?i“¹‚µ‚é‚×?j‚Æ’n?}‚Ì?C?³?B
        //i_tabibito< Ketasuu‚È‚ç?Aij[i_tabibito]==Gsuu‚È‚ç1Œ…Œ¸‚é•ûŒü‚É–ß‚é?B‚à‚Ç‚Á‚½‚ç?A‚»‚±‚Å’¼‚¿‚É‚»‚±‚ÌˆÊ’u?i“¹‚µ‚é‚×?j‚Æ’n?}‚Ì?C?³?B
        //i_tabibito< Ketasuu‚È‚ç?Aij[i_tabibito]< Gsuu‚È‚ç1Œ…‘?‚¦‚é•ûŒü‚É?i‚Þ?B?i‚ñ‚¾‚ç?A‚»‚±‚Å’¼‚¿‚É‚»‚±‚ÌˆÊ’u?i“¹‚µ‚é‚×?j‚Æ’n?}‚Ì?C?³?B“¹‚µ‚é‚×‚Í‰Â”\‚ÈŒÀ‚èŽá‚¢”Ô?†‚É‚·‚é?B
        i_tabibito = idousuru_keta;
        int ireturn = idousuru_keta;

        while (i_tabibito <= Ketasuu) {

            if (i_tabibito == 0) {
                i_tabibito = i_tabibito + 1;
                ij[i_tabibito] = 0;//Œ…?”‘å‚«‚­‚È‚é•û‚É?i‚Þ
            }

            ij[i_tabibito] = mitisirube_tatekae(ij[i_tabibito]);

            if (ij[i_tabibito] <= Ketasuu) {//Œ…?”‘å‚«‚­‚È‚é•û‚É?i‚Þ
                i_tabibito = i_tabibito + 1;
                ij[i_tabibito] = 0;
                if (i_tabibito == Ketasuu + 1) {
                    break;
                }
            } else {//Œ…?”?¬‚³‚­‚È‚é•û‚É–ß‚é
                i_tabibito = i_tabibito - 1;
                ireturn = i_tabibito;
            }
        }


//System.out.println("susumu("+idousuru_keta+")");
//			for(int i=1;i<=Ketasuu;i++){System.out.print(ij[i] );System.out.print(",");}System.out.println();

        return ireturn;
    }

    //
    private int mitisirube_tatekae(int ig) {

        for (int i = 1; i <= Ketasuu; i++) {
            tizu[i] = 0;
        }

        for (int i = 1; i <= i_tabibito - 1; i++) {
            tizu[ij[i]] = tizu[ij[i]] + 1;
        }

        //‚±‚±‚ÍƒoƒO‚ª‚È‚¢‚©ŒŸ“¢‚ð—v‚·‚é?B
        int ignew = ig;
        while (true) {
            ignew = ignew + 1;
            if (ignew > Ketasuu) {
                break;
            }
            int nukedasi_flg = 1;
            if (tizu[ignew] == 1) {
                nukedasi_flg = 0;
            }

            for (int i = 1; i <= ann.get(ignew, 0); i++) {
                if (tizu[ann.get(ignew, i)] == 0) {
                    nukedasi_flg = 0;
                }
            }

            if (nukedasi_flg == 1) {
                break;
            }

        }

        return ignew;
    }

    public int getJyunretu(int i) {
        return ij[i];
    }

    //?‡—ñ‚ðˆê”Ô?Å?‰‚Ì‚à‚Ì‚É‚·‚é
    public void Jyunretu_1banme() {
        susumu(0);
    }

    //ˆÄ“à?‘?î•ñ‚ÌŽó‚¯“n‚µ
    public void addAnnai(int iM, int i) {
        ann.add(iM, i);
    }
    //
    //int getAnnai(int iM,int i){return ann.get(iM,i);}

}