package jp.gr.java_conf.mt777.zukei2d.heikinzahyou;

public class HeikinZahyou {
    double x, y;
    int kosuu;

    public HeikinZahyou() {
        x = 0.0;
        y = 0.0;
        kosuu = 0;
    } //�R���X�g���N�^

    public void reset() {
        x = 0.0;
        y = 0.0;
        kosuu = 0;
    }

    public void add(double a, double b) {
        x = x + a;
        y = y + b;
        kosuu = kosuu + 1;
    }

    public void addTen(Ten tn) {
        x = x + tn.getx();
        y = y + tn.gety();
        kosuu = kosuu + 1;
    }

    public Ten getHeikin_Ten() {
        Ten tn = new Ten();
        tn.set(getHeikin_x(), getHeikin_y());
        return tn;
    }

    public double getHeikin_x() {
        return x / ((double) kosuu);
    }

    public double getHeikin_y() {
        return y / ((double) kosuu);
    }
}