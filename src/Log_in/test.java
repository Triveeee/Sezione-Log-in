package Log_in;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PersonList personlist = new PersonList(PersonList.TXT_TYPE);
		personlist.add(new Persona("0" , "riccardo" , "trivellato" , "1234" , "xtrive004"));
		personlist.add(new Persona("0" , "riccardo" , "trivellato" , "1234" , "xtrive005"));
		personlist.add(new Persona("0" , "riccardo" , "trivellato" , "1234" , "xtrive006"));
		personlist.SaveOnFile();
	}

}
