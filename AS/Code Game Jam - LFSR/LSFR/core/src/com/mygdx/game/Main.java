/*import javax.swing.SwingWorker;

public class Main{

    public static void main (String [] args){

	Zone z;
	for (int i = 0 ; i < 9 ; i++){
	    z = new Zone ();
	}

	Zone.getZoneById(0).activer();
	Zone.getZoneById(4).activer();
        
        //System.out.println(Animal.toStringAnimal(0));
	//affichZones();
       
	/*Animal a1 = new Animal (0);
	affichAnimaux();
	autoLvlUp();

        Ut.pause(3000);
	affichAnimaux();

	Ut.pause(3000);
	affichAnimaux();
	
    }

    public static void affichZones (){
	Zone z;
	int n = Zone.getNbZones ();
	for ( int i = 0 ; i < n ; i++ ){
	    z = Zone.getZoneById(i);
	    System.out.println (z);
	}
    }
    
    public static void affichAnimaux (){
	Animal animal;
	int n = Animal.getNbAnimaux();
	for ( int i = 0 ; i < n ; i++ ){
	    animal = Animal.getAnimalById(i);
	    System.out.println (animal);
	}
    }
    /*
    public static void autoLvlUp(){
	SwingWorker sw = new SwingWorker(){
		protected Object doInBackground() throws Exception{ 
		    Animal a;
		    while (true){
			for (int i=0;i<Animal.getNbAnimaux();i++){
			    a = Animal.getAnimalById(i);
			    a.lvlUp();
			}
			Thread.sleep(1000);
		    }
		}
		
		public void done(){
		}
	    };
	sw.execute();
    }

    public static void autoSoldeUp(){
	SwingWorker sw = new SwingWorker(){
		protected Object doInBackground() throws Exception{ 
		    Animal a;
		    while (true){
			for (int i=0;i<Animal.getNbAnimaux();i++){
			    a = Animal.getAnimalById(i);
			    a.setSolde(a.getSolde()+1);
			}
			Thread.sleep(1000);
		    }
		}
		
		public void done(){
		}
	    };
	sw.execute();
	}
}*/
