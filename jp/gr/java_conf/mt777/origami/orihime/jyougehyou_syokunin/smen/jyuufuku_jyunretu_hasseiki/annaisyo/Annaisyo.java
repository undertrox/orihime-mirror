package jp.gr.java_conf.mt777.origami.orihime.jyougehyou_syokunin.smen.jyuufuku_jyunretu_hasseiki.annaisyo;

public class Annaisyo {//ˆÄ“à?‘?BSmen‚Ì’†‚Å?ì?¬‚·‚é?B?d•¡?‡—ñ?ì?¬‹@‚Ì‘O‚Å?A‚ ‚é–Ê‚Ì’¼‚®?ã‚Ì–Ê‚ð“o˜^‚·‚é
    //ˆÄ“à?}‚ÌƒCƒ??[ƒW?B’n?}‚Æ‚¢‚Á‚µ‚å‚ÉŒ©‚ÄŽŸ‚Ç‚¤‚·‚é‚©‚ð”»’f‚·‚é?BŠe–Ê‚ª‚¢‚Ü‚¢‚é“¹‚µ‚é‚×‚Ü‚Å‚É?o‚Ä‚«‚½?”?B?¡‚Ì“¹‚µ‚é‚×‚Ì?ó‘Ô‚Í?”‚¦‚È‚¢?B
    //annai[i][j]‚Í–Êi‚ª?o‚é‘O‚É?o‚Ä‚¢‚é‚Í‚¸‚Ì–Ê‚ð•\‚·?Bannaisyo[i][0]‚Í?A‚»‚¤‚¢‚Á‚½–Ê‚Ì?”?B
    int[][] annai;
    int ketasuu;

    public Annaisyo(int keta) {//ƒRƒ“ƒXƒgƒ‰ƒNƒ^
        ketasuu = keta;
        int[][] a = new int[keta + 11][50];


        annai = a;
        for (int i = 0; i <= keta + 10; i++) {
            annai[i][0] = 0;
        }
    }

    public void add(int Menidid, int ueMenidid) {
        annai[Menidid][0] = annai[Menidid][0] + 1;
        annai[Menidid][annai[Menidid][0]] = ueMenidid;
    }

    public int get(int iMen, int i) {
        //  System.out.print("ketasuu = ");System.out.print(ketasuu); System.out.print(" : iMen = ");System.out.println(iMen);
        return annai[iMen][i];
    }

}