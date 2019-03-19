public class Data {

    private int zi;
    private int luna;
    private int an;

    public Data()
    {
        zi=0;
        luna=0;
        an=0;
    }

    public Data(int zi,int luna,int an)
    {
        this.zi=zi;
        this.luna=luna;
        this.an=an;
    }

    public Data(Data d)
    {
        this.zi=d.zi;
        this.luna=d.luna;
        this.an=d.an;
    }

    public int getZi()
    {
        return zi;
    }

    public int getLuna()
    {
        return luna;
    }

    public int getAn()
    {
        return an;
    }

    public void setAn(int an)
    {
        this.an=an;
    }

    public void setZi(int zi)
    {
        this.zi=zi;
    }

    public void setLuna(int luna)
    {
        this.luna=luna;
    }
}

