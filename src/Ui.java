import java.util.Scanner;
public class Ui {

    private Ctrl ctrl;

    public Ui(Ctrl ctrl){this.ctrl=ctrl;}

    public void menu()
    {
        System.out.println("--------Meniu--------");
        System.out.println("0.Exit");
        System.out.println("1.Adauga elev");
        System.out.println("2.Update elev");
        System.out.println("3.Sterge elev");
        System.out.println("4.Afiseaza elevii");
        System.out.println("5.Clasament in ordine descrescatoare dupa medie");
        System.out.println("6.Elevi corigenti si materiile pe care nu le-au promovat");
        System.out.println("7. Discipline in ordinea descrec a mediilor ");
        System.out.println("8.Ordonare elevi in ordine descrecatoare dupa varsta");

    }



    public void addUi()
    {
        System.out.println("introduceti numele: ");
        Scanner input=new Scanner(System.in);
        String nume=input.nextLine();
        System.out.println("introduceti data: ");
        System.out.println("zi: ");
        int zi=input.nextInt();
        System.out.println("luna: ");
        int luna=input.nextInt();
        System.out.println("an: ");
        int an=input.nextInt();
        Data data_nasterii= new Data(zi,luna,an);
        System.out.println("introduceti nr matricol: ");
        int matricol=input.nextInt();
        System.out.println("introduceti cele 5 note : ");
        int[] note=new int[5];
        for (int i=0;i<5;i++)
        {
            int n=input.nextInt();
            note[i]=n;
        }
        ctrl.addCtrl(nume,data_nasterii,matricol,note);
    }

    public void updateUi()
    {

        System.out.println("introduceti numele: ");
        Scanner input=new Scanner(System.in);
        String nume=input.nextLine();
        System.out.println("introduceti data: ");
        System.out.println("zi: ");
        int zi=input.nextInt();
        System.out.println("luna: ");
        int luna=input.nextInt();
        System.out.println("an: ");
        int an=input.nextInt();
        Data data_nasterii= new Data(zi,luna,an);
        System.out.println("introduceti nr matricol: ");
        int matricol=input.nextInt();
        System.out.println("introduceti cele 5 note : ");
        int[] note=new int[5];
        for (int i=0;i<5;i++)
        {
            int n=input.nextInt();
            note[i]=n;
        }

        System.out.println("introduceti datele cu care facem update: ");
        System.out.println("introduceti numele: ");
        Scanner sc=new Scanner(System.in);
        String nume2=sc.nextLine();
        System.out.println("introduceti data ");
        System.out.println("zi: ");
        int zi2=sc.nextInt();
        System.out.println("luna: ");
        int luna2=sc.nextInt();
        System.out.println("an: ");
        int an2=sc.nextInt();
        Data data_nasterii2= new Data(zi2,luna2,an2);
        System.out.println("introduceti nr matricol: ");
        int matricol2=sc.nextInt();
        System.out.println("introduceti cele 5 note : ");
        int[] note2=new int[5];
        int j=0;
        while(j<5)
        {
            int x=sc.nextInt();
            note2[j]=x;
            j++;
        }

        ctrl.updateCtrl(nume,data_nasterii,matricol,note,nume2,data_nasterii2,matricol2,note2);

    }

    public void deleteUi()
    {
        System.out.println("introduceti numele: ");
        Scanner input=new Scanner(System.in);
        String nume=input.nextLine();
        System.out.println("introduceti data: ");
        System.out.println("zi: ");
        int zi=input.nextInt();
        System.out.println("luna: ");
        int luna=input.nextInt();
        System.out.println("an: ");
        int an=input.nextInt();
        Data data_nasterii= new Data(zi,luna,an);
        System.out.println("introduceti nr matricol: ");
        int matricol=input.nextInt();
        System.out.println("introduceti cele 5 note : ");
        int[] note=new int[5];
        for (int i=0;i<5;i++)
        {
            int n=input.nextInt();
            note[i]=n;
        }

        ctrl.deleteCtrl(nume,data_nasterii,matricol,note);

    }

    public void afisareUi()
    {
        ctrl.afisare();
    }

    public void run()
    {
        menu();
        Scanner sc=new Scanner(System.in);
        int opt=sc.nextInt();

        while(opt!=0)
        {
            switch(opt)
            {
                case 1: { addUi();menu();break;}
                case 2: {updateUi();menu();break;}
                case 3:{deleteUi();menu();break;}
                case 4:{afisareUi();menu();break;}
                case 5:{ctrl.clasament();menu();break; }
                case 6: {ctrl.corigenti();menu();break;}
                case 7:{ctrl.discipline();menu();break;}
                case 8:{ctrl.varsta();menu();break;}

                default: {System.out.println("Invalid option. Try again."); menu(); break; }
            }

            System.out.print("Choose an option: ");
            opt = sc.nextInt();
            if(opt == 0)
                break;
        }

    }
}
