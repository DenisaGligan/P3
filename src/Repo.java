public class Repo {

    private int dimElevi=0;
    private Elev[] lista_elevi=new Elev[20];
    private String[] materii={"romana","matematica","istorie","geografie","engleza"};

    public int getDimElevi()
    {
        return dimElevi;
    }

    Elev[] getLista_elevi()
    {
        return lista_elevi;
    }
    String[] getLista_Materii(){return materii;}

    //add
    public void addElev(Elev e)
    {
        lista_elevi[dimElevi]=e;
        dimElevi++;
    }

    //update
    public void updateElev(Elev e, int poz)
    {
        lista_elevi[poz]=e;
    }

    //delete
    public void deleteElev(int poz)
    {
        int i=poz;
        while(i<getDimElevi())
        {
            lista_elevi[i]=lista_elevi[i++];
            i++;
        }
        dimElevi--;
    }

    // find the object in the list and return the position or -1

    public int findElev(Elev e)
    {
        int i=0;
        int k=-1;
        boolean ok=true;
        while( i<dimElevi)
        {
            if((lista_elevi[i].getNume().equals(e.getNume()))&& (lista_elevi[i].getData_nasterii().getZi()==e.getData_nasterii().getZi()) && (lista_elevi[i].getData_nasterii().getLuna()==e.getData_nasterii().getLuna())
                && (lista_elevi[i].getData_nasterii().getAn()==e.getData_nasterii().getAn()) && (lista_elevi[i].getMatricol()==e.getMatricol()))
            {
                for(int j=0;j<5;j++)
                {
                    if(lista_elevi[i].getNote()[j]!=e.getNote()[j])
                    {
                        ok=false;
                    }
                }
                if(ok==true)
                {
                    k=i;
                }
            }
            i++;
            ok=true;
        }
        return k;
    }



}
