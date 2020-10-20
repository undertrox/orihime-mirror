package jp.gr.java_conf.mt777.origami.orihime.undo_box;

import jp.gr.java_conf.mt777.kiroku.memo.Memo;

import java.util.LinkedList;

// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------
public class Undo_Box {
    int i_undo_suu = 20;//?Å‘å‰½‰ñ‘O‚Ü‚Åundo‚Å‚«‚é‚©‚Æ‚¢‚¤?”

    int i_kiroku_suu = -1;//‰½‰ñ‘O‚Ü‚Å‹L˜^‚µ‚Ä‚¢‚é‚©‚Æ‚¢‚¤?”?B5‰ñ‘O‚Ü‚Å‹L˜^‚µ‚Ä‚¢‚é‚È‚çi_kiroku_suu=5‚Å‚±‚ê‚É‚Í?Å?V‚Ì‹L˜^•ª‚Ìmemo[0]‚ÍŠÜ‚Ü‚È‚¢
    int i_kiroku_iti = 0;//0‚È‚ç?A?Å?V‚Ì‹L˜^ˆÊ’u?A‚Ž‚È‚ç‚Ž‘O‚Ì‹L˜^ˆÊ’u

    LinkedList Mem = new LinkedList(); //LinkedList‚ÌƒIƒuƒWƒFƒNƒg‚ð?ì?¬
    //Memo memo[] = new Memo[21];//ˆêŽž‹L˜^—p‚ÉŽg‚¤?Bmemo[0] ‚Í?Å?V‚Ì‹L˜^?Amemo[1]‚Íˆê‚Â‘O‚Ì‹L˜^?B

    int i_tokeiban_iti = -1;//‹L˜^‚Í?‡ŽŸ?A i_undo_suu+1‚ÌŽž??‚Ì‚ ‚éŽžŒv”Õ‚ÌŠeŽž??‚ÉŠi”[‚·‚éƒCƒ??[ƒW?B?Å?V‚ÌŠi”[?ê?Š‚ªi_tokeiban_iti

    //---------------------------------
    public Undo_Box() {  //ƒRƒ“ƒXƒgƒ‰ƒNƒ^
        Mem.clear();
        for (int i = 0; i <= i_undo_suu; i++) {
            Mem.add(new Memo());
        }

        //for(int i=0;i<=20;i++){memo[i]  = new Memo();}
    }

    //---------------------------------
    public void reset() {

    }

    //---------------------------------
    public void kiroku(Memo m0) {
        //?i‚P?j?Å?‰‚ÉŒ»?Ý‚Ì‹L˜^ˆÊ’u‚Ìmemo(i_kiroku_iti)‚ªmemo(0)?Amemo(i_kiroku_iti?@+?@1)‚ªmemo(10)?A?A?A‚É‚È‚é‚æ‚¤‚É‚¸‚ç‚·
        for (int i = 1; i <= i_kiroku_iti; i++) {
            Mem.remove(0);
            Mem.add(new Memo());
        }

        //i_tokeiban_iti=i_tokeiban_iti-i_kiroku_iti;
        i_kiroku_suu = i_kiroku_suu - i_kiroku_iti;
        i_kiroku_iti = 0;


        //?i‚Q?j?V‚µ‚¢‹L˜^‚Ì’Ç‰Á
        Mem.remove(i_undo_suu);
        Mem.add(0, m0);

        //i_tokeiban_iti=i_tokeiban_iti+1; if(i_tokeiban_iti>i_undo_suu){i_tokeiban_iti=0;}
        //memo[i_tokeiban_iti].set(m0);

        i_kiroku_suu = i_kiroku_suu + 1;
        if (i_kiroku_suu > i_undo_suu) {
            i_kiroku_suu = i_undo_suu;
        }
    }

    //---------------------------------
/*
	public void kiroku_old001(Memo m0){
		for(int i=0;i<=i_kiroku_suu-i_kiroku_iti;i++){
			memo[i].set(memo[i+i_kiroku_iti]);
		}

		i_kiroku_suu=i_kiroku_suu-i_kiroku_iti;
		i_kiroku_iti=0;

		for(int i=i_undo_suu;i>=1;i--){
			memo[i].set(memo[i-1]);
		}
		memo[0].set(m0);

		i_kiroku_suu=i_kiroku_suu+1;if(i_kiroku_suu>i_undo_suu){i_kiroku_suu=i_undo_suu;}
	}

//---------------------------------
	public void kiroku_old(Memo m0){
		//i_kiroku_iti
		for(int i=0;i<=i_kiroku_suu-i_kiroku_iti;i++){
			Memo ma = new Memo();
			ma.set(memo[i+i_kiroku_iti]);
			memo[i].set(ma);
			//	memo[i].set(memo[i+i_kiroku_iti]);
		}

		i_kiroku_suu=i_kiroku_suu-i_kiroku_iti;
		i_kiroku_iti=0;

		for(int i=10;i<=1;i=i-1){
			Memo ma = new Memo();
			//Memo mb = new Memo();

			ma.set(memo[i-1]);
			memo[i].set(ma);

			//memo[i].set(memo[i-1])	;
		}

		memo[10].set(memo[9]);
		memo[9].set(memo[8]);
		memo[8].set(memo[7]);
		memo[7].set(memo[6]);
		memo[6].set(memo[5]);
		memo[5].set(memo[4]);
		memo[4].set(memo[3]);
		memo[3].set(memo[2]);
		memo[2].set(memo[1]);
		memo[1].set(memo[0]);
		memo[0].set(m0);

		i_kiroku_suu=i_kiroku_suu+1;if(i_kiroku_suu>10){i_kiroku_suu=10;}

		//System.out.println("i_kiroku_suu="+i_kiroku_suu);
		//System.out.println("i_kiroku_iti="+i_kiroku_iti);
		//for(int i=0;i<=10;i++){	System.out.println("memo"+i+":"+memo[i].getGyousuu());}
	}
*/
    //-----------------------------
    public Memo undo() {
        i_kiroku_iti = i_kiroku_iti + 1;
        if (i_kiroku_iti > i_kiroku_suu) {
            i_kiroku_iti = i_kiroku_suu;
        }
        return (Memo) Mem.get(i_kiroku_iti);
        //int i_t=i_tokeiban_iti-i_kiroku_iti;if(i_t<0){i_t=i_t+i_undo_suu+1;}
        //return memo[i_t];
    }

    //-----------------------------
    public Memo redo() {
        i_kiroku_iti = i_kiroku_iti - 1;
        if (i_kiroku_iti < 0) {
            i_kiroku_iti = 0;
        }
        return (Memo) Mem.get(i_kiroku_iti);
        //int i_t=i_tokeiban_iti-i_kiroku_iti;if(i_t<0){i_t=i_t+i_undo_suu+1;}
        //return memo[i_t];
    }

    //-----------------------------
    public void set_i_undo_suu(int i_new) {
        if (i_undo_suu <= i_new) {
            for (int i = i_undo_suu + 1; i <= i_new; i++) {
                Mem.add(new Memo());
            }
            i_undo_suu = i_new;
        } else if (i_undo_suu > i_new) {  //‹L˜^?”‚ð?­‚È‚­‚·‚é?ê?‡
            //?Å?‰‚É‹L˜^?”‚Ì’·Œã‚©‚çi_undo_suu‚Ü‚Å‚ÌMemo‚ð?Á‚·
            for (int i = i_kiroku_suu + 1; i <= i_undo_suu; i++) {
                Mem.removeLast();
            }

            //ŽŸ‚É?æ“ª‚©‚ç‹L˜^ˆÊ’u’¼‘O‚Ü‚Å‚ÌMemo‚ð?Á‚·
            for (int i = 0; i <= i_kiroku_iti - 1; i++) {
                Mem.removeFirst();
            }

            //?ã‹L‚Ì‘€?ì‚É‰ž‚¶‚Äi_kiroku_iti‚Æi_kiroku_suu‚Æi_undo_suu‚Æ‚ð?X?V
            i_kiroku_suu = i_kiroku_suu - i_kiroku_iti;
            i_kiroku_iti = 0;
            i_undo_suu = i_kiroku_suu;

            if (i_kiroku_suu <= i_new) {
                for (int i = i_undo_suu + 1; i <= i_new; i++) {
                    Mem.add(new Memo());
                }
                i_undo_suu = i_new;
            } else if (i_kiroku_suu > i_new) {  //‹L˜^?”‚ð?­‚È‚­‚·‚é?ê?‡
                //‹L˜^?”‚ªi_new‚É‚È‚é‚æ‚¤‚ÉŒã”¼‚ÌMemo‚ð?Á‚·
                for (int i = i_new + 1; i <= i_kiroku_suu; i++) {
                    Mem.removeLast();
                }
                i_kiroku_suu = i_new;
                i_undo_suu = i_new;

            }

        }

        int i_undo_suu = 20;//?Å‘å‰½‰ñ‘O‚Ü‚Åundo‚Å‚«‚é‚©‚Æ‚¢‚¤?”

        int i_kiroku_suu = -1;//‰½‰ñ‘O‚Ü‚Å‹L˜^‚µ‚Ä‚¢‚é‚©‚Æ‚¢‚¤?”?B5‰ñ‘O‚Ü‚Å‹L˜^‚µ‚Ä‚¢‚é‚È‚çi_kiroku_suu=5‚Å‚±‚ê‚É‚Í?Å?V‚Ì‹L˜^•ª‚Ìmemo[0]‚ÍŠÜ‚Ü‚È‚¢
        int i_kiroku_iti = 0;//0‚È‚ç?A?Å?V‚Ì‹L˜^ˆÊ’u?A‚Ž‚È‚ç‚Ž‘O‚Ì‹L˜^ˆÊ’u

    }
    //-----------------------------
    //public Memo getMemo(){
    //	return m1;
    //}
    //--------------------------------------------
    //public void test1(){//ƒfƒoƒbƒN“™‚ÌƒeƒXƒg—p
    //	System.out.println("Undo_Box");
    //}
    //--------------------------------------------
}