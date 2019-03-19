import java.util.Scanner;
import java.io.*;
public class Ctrl {

    private Repo repo;
    private Scanner sc;

    public Ctrl(Repo repo){this.repo=repo;}


    public void readFromFile()
    {
        try{
            sc=new Scanner(new File("in.txt"));
        }
        catch(Exception e)
        {
            System.out.println("could not find file");
        }

        while(sc.hasNext())
        {
            String nume=sc.next();
            int zi=sc.nextInt();
            int luna=sc.nextInt();
            int an=sc.nextInt();
            Data data=new Data(zi,luna,an);
            int matricol=sc.nextInt();


        }

    }

    public void addCtrl(String nume, Data data, int matricol, int[] note)
    {
        Elev e=new Elev(nume,data,matricol,note);
        repo.addElev(e);
    }



    public void updateCtrl(String nume, Data data, int matricol, int[] note,String nume2, Data data2, int matricol2, int[] note2)
    {
        Elev e=new Elev(nume,data,matricol,note);
        Elev e2=new Elev(nume2,data2,matricol2,note2);

        int poz=repo.findElev(e);
        if(poz!=-1)
        {
            repo.updateElev(e2,poz);
            System.out.println("update-ul s-a realizat");
        }
        else
            {
                System.out.println("elevul nu a fost gasit ");
            }

    }

    public void deleteCtrl(String nume, Data data, int matricol, int[] note)
    {
        Elev e=new Elev(nume,data,matricol,note);
        int poz=repo.findElev(e);
        if (poz!=-1)
        {
            repo.deleteElev(poz);
            System.out.println("elevul a fost sters");
        }
        else{
            System.out.println("stergere efectuata");
            }
    }
    public void printElev(Elev e)
    {
        System.out.println("Nume: "+e.getNume());
        System.out.println("Data: "+e.getData_nasterii().getZi()+"/"+e.getData_nasterii().getLuna()+"/"+e.getData_nasterii().getAn());
        System.out.println("Matricol: "+e.getMatricol());
        System.out.print("Notele: ");
        for(int i=0;i<e.getNote().length;i++)
        {
            System.out.print(e.getNote()[i]+" ");
        }
        System.out.println();

    }

    public void afisare()
    {

        System.out.println("elevii sunt: ");
        Elev[] sir=this.repo.getLista_elevi();
        int dim=this.repo.getDimElevi();
        System.out.println("dimensiuea sirului este: "+dim);
        if(dim>0)
        {
            for (int i = 0; i < dim ; i++) {
                printElev(sir[i]);
            }

        }
        else {
            System.out.println("sir vid ");
        }
    }

    //calculeaza media generala
    public double medie(Elev e)
    {
        double suma=0;
        for(int i=0;i<5;i++)
        {
            suma=suma+e.getNote()[i];
        }
        double med=suma/5;
        return med;
    }

    //clasamentul elevilor  descrescator dupa medie

    public void clasament()
    {
        Elev[] sir=repo.getLista_elevi();
        for(int i=0;i<repo.getDimElevi()-1;i++)
        {
            for(int j=i+1;j<repo.getDimElevi();j++)
            {
                if(medie(sir[i])<medie(sir[j]))
                {
                    Elev e=new Elev(sir[i]);
                    sir[i]=sir[j];
                    sir[j]=e;
                }
            }
        }
        afisare();
    }

    //elevii corigenti si materiile la care nu au promovat

    public void  corigenti()
    {
        Elev[] sir=repo.getLista_elevi();
        int[] mat={0,0,0,0,0};
        int k=0;
        for (int i=0;i<repo.getDimElevi();i++)
        {
            for(int j=0;j<5;j++)
            {
                if(sir[i].getNote()[j]<5)
                {
                    k++;
                    mat[j]=1;

                }
            }
            if(k!=0) {
                printElev(sir[i]);
                System.out.print("Discipline: ");
                for(int c=0;c<5;c++)
                {
                    if(mat[c]==1)
                    {
                        System.out.print(repo.getLista_Materii()[c]+"  ");
                    }
                }
                System.out.println();

            }
            else{ System.out.println("nu sunt elevi corigenti");}
            for(int c=0;c<5;c++)
            {
                mat[c]=0;
            }
            k=0;
        }
    }

    //discipline in ordinea descrecatoare a mediilor
    public void discipline()
    {
        double[] sir={0,0,0,0,0};
        Elev[] elevi=repo.getLista_elevi();
        for(int i =0;i<repo.getDimElevi();i++)
        {
            sir[0]=sir[0]+elevi[i].getNote()[0];
            sir[1]=sir[1]+elevi[i].getNote()[1];
            sir[2]=sir[2]+elevi[i].getNote()[2];
            sir[3]=sir[3]+elevi[i].getNote()[3];
            sir[4]=sir[4]+elevi[i].getNote()[4];

        }
        int k=repo.getDimElevi();
        for(int i=0;i<5;i++)
        {
            sir[i]=sir[i]/k;
        }
        String aux;
        for(int i=0;i<5-1;i++)
        {
            for(int j=i+1;j<5;j++)
            {
                if(sir[i]<sir[j])
                {
                   aux=repo.getLista_Materii()[i];
                   repo.getLista_Materii()[i]=repo.getLista_Materii()[j];
                   repo.getLista_Materii()[j]=aux;
                }
            }
        }
        for(int i=0;i<5;i++)
        {
            System.out.println(repo.getLista_Materii()[i]);
        }

    }

    //elevii in ordinea descrec a varstei
    public void varsta()
    {

        Elev[] sir=repo.getLista_elevi();
        for(int i=0;i<repo.getDimElevi()-1;i++) {
            for (int j = i + 1; j < repo.getDimElevi(); j++) {
                if(sir[i].getData_nasterii().getAn()>sir[j].getData_nasterii().getAn())
                {
                    Elev aux= new Elev(sir[i]);
                    sir[i]=sir[j];
                    sir[j]=aux;
                }
                else if(sir[i].getData_nasterii().getAn()==sir[j].getData_nasterii().getAn())
                {
                    if(sir[i].getData_nasterii().getLuna()>sir[j].getData_nasterii().getLuna())
                    {
                        Elev aux=new Elev(sir[i]);
                        sir[i]=sir[j];
                        sir[j]=aux;
                    }
                    else if(sir[i].getData_nasterii().getLuna()==sir[j].getData_nasterii().getLuna())
                    {
                        if(sir[i].getData_nasterii().getZi()>sir[j].getData_nasterii().getZi())
                        {
                            Elev aux=new Elev(sir[i]);
                            sir[i]=sir[j];
                            sir[j]=aux;
                        }
                    }
                }

            }
        }

    }





}
