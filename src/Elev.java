import java.util.Arrays;

public class Elev {

    private String nume;
    private Data data_nasterii;
    private int matricol;
    private int[] note;

    //constructori


    public Elev(String nume, Data dat, int mat, int[] note)
    {
        this.nume=nume;
        this.data_nasterii=dat;
        this.matricol=mat;
        this.note=note;
    }

    public Elev( Elev e)
    {
        this.nume=e.nume;
        this.data_nasterii=e.data_nasterii;
        this.matricol=e.matricol;
        this.note=e.note;
    }

    //gett-eri

    public String getNume()
    {
        return nume;
    }

    public Data getData_nasterii()
    {
        return data_nasterii;
    }

    public int getMatricol()
    {
        return matricol;
    }
    public int[] getNote()
    {
        return note;
    }

    //sett-eri

    public void setNume(String nume){this.nume=nume;}
    public void setData(Data data){this.data_nasterii=data;}
    public void setMatricol(int matricol){this.matricol=matricol;}
    public void setNote(int[] note){this.note=note;}


    /*public void printElev(Elev e)
    {
        System.out.println("Nume: "+nume);
        System.out.println("Data: "+data_nasterii.getZi()+"/"+data_nasterii.getLuna()+"/"+data_nasterii.getAn());
        System.out.println("Matricol: "+matricol);
        System.out.print("Notele: ");
        for(int i=0;i<note.length;i++)
        {
            System.out.print(note[i]+" ");
        }
        System.out.println();

    }*/


}
