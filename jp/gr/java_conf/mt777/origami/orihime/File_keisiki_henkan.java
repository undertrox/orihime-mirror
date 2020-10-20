package jp.gr.java_conf.mt777.origami.orihime;

import jp.gr.java_conf.mt777.kiroku.memo.Memo;
import jp.gr.java_conf.mt777.origami.dougu.bou.Bou;
import jp.gr.java_conf.mt777.zukei2d.ten.Ten;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class File_keisiki_henkan {

    //public File_keisiki_henkan(){   } //コンストラクタ

    //---------------
    Memo obj2orihime(Memo mem) {
        System.out.println("objファイルをオリヒ??用にする");
        Memo MemR = new Memo();
        int ibangou = 0;
        int jtok;
        String st = "";
        Double Dd = new Double(0.0);
        Integer Ii = new Integer(0);

        ArrayList tL = new ArrayList();

        tL.add(new Ten());

        Ten tn = new Ten();
        int Tenmax = 0;

        ArrayList bL = new ArrayList();
        bL.add(new Bou());

        Bou bu = new Bou();
        int Boumax = 0;

        ArrayList itempL = new ArrayList();
        itempL.add(new Integer(0));

        int ia, ib, ic, id;
        double d1, d2, d3, d4;

        double xmax = -10000.0;
        double xmin = 10000.0;
        double ymax = -10000.0;
        double ymin = 10000.0;

        double ax, ay, bx, by;
        String str = "";

        int isen = 0;
        for (int ig = 1; ig <= mem.getGyousuu(); ig++) {
            //  System.out.print("v,f,#eの読みこみ..."); System.out.println(ig);
            if (mem.getGyou(ig).length() != 0) {
                StringTokenizer tk = new StringTokenizer(mem.getGyou(ig), " ");
                jtok = tk.countTokens();

                str = tk.nextToken();

                if (str.equals("v")) {
                    d1 = Double.parseDouble(tk.nextToken());
                    d2 = Double.parseDouble(tk.nextToken());
                    d3 = Double.parseDouble(tk.nextToken());

                    if (d1 > xmax) {
                        xmax = d1;
                    }
                    if (d1 < xmin) {
                        xmin = d1;
                    }
                    if (d2 > ymax) {
                        ymax = d2;
                    }
                    if (d2 < ymin) {
                        ymin = d2;
                    }

                    Tenmax = Tenmax + 1;
                    tL.add(new Ten(d1, d2));
                }
                if (str.equals("f")) {
                    itempL.clear();
                    itempL.add(new Integer(0));
                    for (int i = 2; i <= jtok; i++) {
                        int ite = Integer.parseInt(tk.nextToken());
                        itempL.add(new Integer(ite));
                    }
                    itempL.set(0, itempL.get(jtok - 1));
                    for (int i = 1; i <= jtok - 1; i++) {
                        int iflg = 0;
                        Integer I_itempL = (Integer) itempL.get(i);
                        Integer Im1_itempL = (Integer) itempL.get(i - 1);
                        for (int j = 1; j <= Boumax; j++) {
                            bu = (Bou) bL.get(j);
                            if ((bu.getmae() == Im1_itempL.intValue()) && (bu.getato() == I_itempL.intValue())) {
                                iflg = iflg + 1;
                            }
                            if ((bu.getmae() == I_itempL.intValue()) && (bu.getato() == Im1_itempL.intValue())) {
                                iflg = iflg + 1;
                            }
                        }
                        if (iflg == 0) {
                            Boumax = Boumax + 1;
                            bL.add(new Bou(Im1_itempL.intValue(), I_itempL.intValue(), 0));
                        }
                    }
                }

                if (str.equals("#e")) {
                    ia = Integer.parseInt(tk.nextToken());
                    ib = Integer.parseInt(tk.nextToken());
                    ic = Integer.parseInt(tk.nextToken());
                    id = Integer.parseInt(tk.nextToken());
                    for (int i = 1; i <= Boumax; i++) {
                        bu = (Bou) bL.get(i);
                        if ((bu.getmae() == ia) && (bu.getato() == ib)) {
                            bu.setcolor(ic);
                        }
                        if ((bu.getmae() == ib) && (bu.getato() == ia)) {
                            bu.setcolor(ic);
                        }
                    }
                }
            }
            //	str=tk.nextToken();
            //	System.out.print("jtok=" );System.out.println(jtok);
            //	System.out.println(mem.getGyou(i));
        }

        //  writeMemo2File(MemR) ;

        MemR.reset();
        MemR.addGyou("<??分?W??>");
        for (int i = 1; i <= Boumax; i++) {
            MemR.addGyou("番??," + i);
            //System.out.println("番??,"+str.valueOf(i));
            bu = (Bou) bL.get(i);

            int icol;
            icol = bu.getcolor() - 1;
            bu.setcolor(icol);
            if (bu.getcolor() == 1) {
                icol = 2;
            }
            if (bu.getcolor() == 2) {
                icol = 1;
            }

            if (icol != 0) {
                bu.setcolor(icol);
            }

            MemR.addGyou("?F," + icol);

            tn = (Ten) tL.get(bu.getmae());
            d1 = tn.getx();
            d2 = tn.gety();

            tn = (Ten) tL.get(bu.getato());
            d3 = tn.getx();
            d4 = tn.gety();

            //d1=d1-xmin+150.0;
            //d2=d2-ymin+150.0;
            //d3=d3-xmin+150.0;
            //d4=d4-ymin+150.0;

            MemR.addGyou("?ﾀ標," + d1 + "," + d2 + "," + d3 + "," + d4);

            //System.out.println("?ﾀ標,"+str.valueOf(d1)+","+str.valueOf(d2)+","+str.valueOf(d3)+","+str.valueOf(d4)     );
            //MemR.addGyou("?ﾀ標,"+str.valueOf(t[b[i].getmae()].getx())+","
            //+str.valueOf(t[b[i].getmae()].gety())+","
            //+str.valueOf(t[b[i].getato()].getx())+","
            //+str.valueOf(t[b[i].getato()].gety())     );
            //
        }
        return MemR;
    }

    //---------------
    Memo cp2orihime(Memo mem) {
        System.out.println("cpファイルをオリヒ??用にする");
        System.out.println("cpファイルをオリヒ??用にする");
        Memo MemR = new Memo();

        int ibangou = 0;
        Double Dd = new Double(0.0);
        double d1, d2, d3, d4;
        String str = "";
        int icol;

        //オリヒ???@0.Contour, 1.Mountain, 2.Valley?@?AORIPA 1.Contour, 2.Mountain, 3.Valley

        MemR.reset();
        MemR.addGyou("<??分?W??>");

        //  int isen=0;
        for (int ig = 1; ig <= mem.getGyousuu(); ig++) {
            //     System.out.print("cpファイルの?s?∑ﾔ..."); System.out.println(ig);
            if (mem.getGyou(ig).length() != 0) {
                StringTokenizer tk = new StringTokenizer(mem.getGyou(ig), " ");
                str = tk.nextToken();
                //    System.out.print("..."+str+"..."); System.out.println(ig);
                if (str.equals("1")) {
                    icol = 0;
                    ibangou = ibangou + 1;
                    d1 = Double.parseDouble(tk.nextToken());
                    d2 = Double.parseDouble(tk.nextToken());
                    d3 = Double.parseDouble(tk.nextToken());
                    d4 = Double.parseDouble(tk.nextToken());
                    // if(d1>xmax){xmax=d1;}
                    // if(d1<xmin){xmin=d1;}
                    // if(d2>ymax){ymax=d2;}
                    // if(d2<ymin){ymin=d2;}
                    MemR.addGyou("番??," + ibangou);
                    System.out.println("番??," + ibangou);
                    MemR.addGyou("?F," + icol);
                    //System.out.println("?F,"  +str.valueOf(icol) );

                    //d1=d1+350.0;d2=d2+350.0;d3=d3+350.0;d4=d4+350.0;//ORIPAからオリヒ??へ移すときの?ﾀ標調?ｮ

                    MemR.addGyou("?ﾀ標," + d1 + "," + d2 + "," + d3 + "," + d4);
                    //System.out.println("?ﾀ標,"+str.valueOf(d1)+","+str.valueOf(d2)+","+str.valueOf(d3)+","+str.valueOf(d4)     );
                }
                if (str.equals("2")) {
                    icol = 1;
                    ibangou = ibangou + 1;
                    d1 = Double.parseDouble(tk.nextToken());
                    d2 = Double.parseDouble(tk.nextToken());
                    d3 = Double.parseDouble(tk.nextToken());
                    d4 = Double.parseDouble(tk.nextToken());
                    MemR.addGyou("番??," + ibangou);
                    MemR.addGyou("?F," + icol);

                    //d1=d1+350.0;d2=d2+350.0;d3=d3+350.0;d4=d4+350.0;//ORIPAからオリヒ??へ移すときの?ﾀ標調?ｮ

                    MemR.addGyou("?ﾀ標," + d1 + "," + d2 + "," + d3 + "," + d4);
                }
                if (str.equals("3")) {
                    icol = 2;
                    ibangou = ibangou + 1;
                    d1 = Double.parseDouble(tk.nextToken());
                    d2 = Double.parseDouble(tk.nextToken());
                    d3 = Double.parseDouble(tk.nextToken());
                    d4 = Double.parseDouble(tk.nextToken());
                    MemR.addGyou("番??," + ibangou);
                    MemR.addGyou("?F," + icol);

                    //d1=d1+350.0;d2=d2+350.0;d3=d3+350.0;d4=d4+350.0;//ORIPAからオリヒ??へ移すときの?ﾀ標調?ｮ

                    MemR.addGyou("?ﾀ標," + d1 + "," + d2 + "," + d3 + "," + d4);
                }
            }
        }

        return MemR;
    }
    //-----------------------------------------------------------------------------------------------------

    Memo orihime2cp(Memo mem) {
        System.out.println("オリヒ??用ファイルをcp用にする");
        Memo MemR = new Memo();
        int ibangou = 0;
        Integer Ii = new Integer(0);
        Double Dd = new Double(0.0);
        double d1, d2, d3, d4;
        String str = "";
        int icol = 0;

        //オリヒ???@0.Contour, 1.Mountain, 2.Valley?@?AORIPA 1.Contour, 2.Mountain, 3.Valley

        MemR.reset();
        //MemR.addGyou("<??分?W??>");

        //  int isen=0;
        for (int ig = 1; ig <= mem.getGyousuu(); ig++) {
            //     System.out.print("cpファイルの?s?∑ﾔ..."); System.out.println(ig);
            if (mem.getGyou(ig).length() != 0) {
                StringTokenizer tk = new StringTokenizer(mem.getGyou(ig), ",");
                str = tk.nextToken();
                //    System.out.print("..."+str+"..."); System.out.println(ig);
                if (str.equals("番??")) {
                    ibangou = ibangou + 1;
                }
                if (str.equals("?F")) {
                    icol = Integer.parseInt(tk.nextToken()) + 1;
                }
                if (str.equals("?ﾀ標")) {
                    d1 = Double.parseDouble(tk.nextToken());
                    d2 = Double.parseDouble(tk.nextToken());
                    d3 = Double.parseDouble(tk.nextToken());
                    d4 = Double.parseDouble(tk.nextToken());
                    // if(d1>xmax){xmax=d1;}
                    // if(d1<xmin){xmin=d1;}
                    // if(d2>ymax){ymax=d2;}
                    // if(d2<ymin){ymin=d2;}
                    //MemR.addGyou("番??,"+str.valueOf(ibangou));
                    //System.out.println("番??,"+str.valueOf(ibangou));

                    //System.out.println("?F,"  +str.valueOf(icol) );

                    //d1=d1-350.0;d2=d2-350.0;d3=d3-350.0;d4=d4-350.0;//オリヒ??からORIPAへ移すときの?ﾀ標調?ｮ
                    MemR.addGyou(icol + " " + d1 + " " + d2 + " " + d3 + " " + d4);
                    //MemR.addGyou("?ﾀ標,"+str.valueOf(d1)+","+str.valueOf(d2)+","+str.valueOf(d3)+","+str.valueOf(d4)     );
                    //System.out.println("?ﾀ標,"+str.valueOf(d1)+","+str.valueOf(d2)+","+str.valueOf(d3)+","+str.valueOf(d4)     );
                }
            }
        }
        return MemR;
    }

    //-----------------------------------------------------------------------------------------------------

    Memo orihime2svg(Memo mem) {//これはes1.getMemo_for_kakidasi()を入力して展開?}の?ｶデ?[タのsvgを?o力
        System.out.println("オリヒ??用ファイルをsvg用にする");
        Memo MemR = new Memo();
        int ibangou = 0;
        Integer Ii = new Integer(0);
        Double Dd = new Double(0.0);
        double d1, d2, d3, d4;
        String str = "";
        String str_stroke = "";
        String str_strokewidth = "";
        str_strokewidth = "1";
        int icol = 0;

        //オリヒ???@0.Contour, 1.Mountain, 2.Valley?@?AORIPA 1.Contour, 2.Mountain, 3.Valley

        MemR.reset();

        MemR.addGyou("<svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\">");

        //MemR.addGyou("<??分?W??>");

        //  int isen=0;
        for (int ig = 1; ig <= mem.getGyousuu(); ig++) {
            //     System.out.print("cpファイルの?s?∑ﾔ..."); System.out.println(ig);
            if (mem.getGyou(ig).length() != 0) {
                StringTokenizer tk = new StringTokenizer(mem.getGyou(ig), ",");
                str = tk.nextToken();
                //    System.out.print("..."+str+"..."); System.out.println(ig);
                if (str.equals("番??")) {
                    ibangou = ibangou + 1;
                }
                if (str.equals("?F")) {
                    icol = Integer.parseInt(tk.nextToken());
                }
                str_stroke = "black";
                if (icol == 0) {
                    str_stroke = "black";
                } else if (icol == 1) {
                    str_stroke = "red";
                } else if (icol == 2) {
                    str_stroke = "blue";
                }


                if (str.equals("?ﾀ標")) {
                    d1 = Double.parseDouble(tk.nextToken());
                    d2 = Double.parseDouble(tk.nextToken());
                    d3 = Double.parseDouble(tk.nextToken());
                    d4 = Double.parseDouble(tk.nextToken());


                    MemR.addGyou("<line x1=\"" + d1 + "\"" +
                            " y1=\"" + d2 + "\"" +
                            " x2=\"" + d3 + "\"" +
                            " y2=\"" + d4 + "\"" +
                            " stroke=\"" + str_stroke + "\"" +
                            " stroke-width=\"" + str_strokewidth + "\"" + " />"
                    );
                    //	<line x1="0" y1="10" x2="200" y2="10" stroke="black" y="10" stroke-width="1" />
                }
            }

        }

        MemR.addGyou("</svg>");
        return MemR;
    }

/*
<svg xmlns="http://www.w3.org/2000/svg"
     xmlns:xlink="http://www.w3.org/1999/xlink">
  <circle cx="100" cy="100" r="100" fill="red" />
  <rect x="130" y="130" width="300" height="200" fill="blue" />
</svg>


<line x1="0" y1="10" x2="200" y2="10"
      stroke="black" y="10" stroke-width="1" />
<line x1="0" y1="30" x2="200" y2="30"
      stroke="black" y="10" stroke-width="2" />
<line x1="0" y1="50" x2="200" y2="50"
      stroke="black" y="10" stroke-width="4" />
<line x1="0" y1="70" x2="200" y2="70"
      stroke="black" y="10" stroke-width="6" />





*/

    Memo orihime2svg(Memo mem_tenkaizu, Memo mem_oriagarizu) {
        System.out.println("svg画像?o力");
        Memo MemR = new Memo();
/*
                int ibangou=0;
		Integer Ii    = new Integer(0);
		Double Dd = new Double(0.0);
		 double d1,d2,d3,d4;
		String str =new String(); 
		String str_stroke =new String(); 
		String str_strokewidth =new String(); 
		str_strokewidth = "1";
		int icol=0;
*/
        MemR.reset();

        MemR.addGyou("<svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\">");

        MemR.addMemo(mem_tenkaizu);
        MemR.addMemo(mem_oriagarizu);


/*
		//MemR.addGyou("<??分?W??>");    

                //  int isen=0;
		for(int ig=1;ig<=mem.getGyousuu();ig++){
                 //     System.out.print("cpファイルの?s?∑ﾔ..."); System.out.println(ig);
			if( mem.getGyou(ig).length()!=0){
			 	StringTokenizer tk = new StringTokenizer(mem.getGyou(ig),",");
				str=tk.nextToken();
                    //    System.out.print("..."+str+"..."); System.out.println(ig);				
				if (str.equals("番??")){ibangou=ibangou+1;}  
				if (str.equals("?F")){icol=Ii.parseInt(tk.nextToken());} 
			 		str_stroke="black";
					if(icol==0){str_stroke="black";
					}else if(icol==1){str_stroke="red";
					}else if(icol==2){str_stroke="blue";
					}


				if (str.equals("?ﾀ標")){ 
					d1=Dd.parseDouble(tk.nextToken());
					d2=Dd.parseDouble(tk.nextToken());
					d3=Dd.parseDouble(tk.nextToken());
					d4=Dd.parseDouble(tk.nextToken());				       




					MemR.addGyou(    "<line x1=\"" + str.valueOf(d1) + "\"" +
							      " y1=\"" + str.valueOf(d2) + "\"" + 
							      " x2=\"" + str.valueOf(d3) + "\"" +
							      " y2=\"" + str.valueOf(d4) + "\"" +
							  " stroke=\"" + str_stroke	 + "\"" +
						    " stroke-width=\"" + str_strokewidth + "\"" +" />"
													);
						//	<line x1="0" y1="10" x2="200" y2="10" stroke="black" y="10" stroke-width="1" />
				}
			} 
		
		}				
*/
        MemR.addGyou("</svg>");
        return MemR;
    }


    //----------------

}