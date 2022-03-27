package Log_in;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;


public class PersonList extends ArrayList <Persona> {
	private String file;
	private File txt_file;
	
	private static final long serialVersionUID = -4290875890793780346L;
	
	public static final int TXT_TYPE = 1;
	public static final int OBJECT_TYPE = 2;

	
	public PersonList(final int type) {
		
		switch(type) {
		case 1:
			file = "PersonList.csv";
			txt_file = new File(file);
			this.ImportByFile();
			break;
		case 2:
			file = "PersonList.dat";
			txt_file = new File(file);
			this.ImportByFileObject();
			break;
		}
	}
	
	private void ImportByFile() {
		Scanner txt;
		
		try {
			if(txt_file.exists() == false)
				txt_file.createNewFile();
			
			txt = new Scanner(new FileInputStream(txt_file));
			while(txt.hasNextLine()) {
				String elemento[] = txt.nextLine().split(";");
				this.add(new Persona(elemento[0] , elemento[1] , elemento[2] , elemento[3] , elemento[4]));
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	
	private void ImportByFileObject() {
		FileInputStream fi;
		
		try {
			if(txt_file.exists() == false)
				txt_file.createNewFile();
			
			fi = new FileInputStream(txt_file);
			ObjectInputStream ois = new ObjectInputStream(fi);
			PersonList ob = (PersonList) ois.readObject();
			this.addAll(ob);
			ois.close();
			
			
		}catch (EOFException e) {
			System.out.println(e.toString() + "   file vuoto");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void SaveOnFileObject() {
		try {
			if(txt_file.exists() == false)
				txt_file.createNewFile();
			
			FileOutputStream fo = new FileOutputStream(txt_file);
			ObjectOutputStream oos = new ObjectOutputStream(fo);
			oos.writeObject(this);
			oos.flush();
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void SaveOnFile() {
		try {
			PrintWriter pen = new PrintWriter(file);
			for(Persona i : this) {
				pen.println(i.toString());
			}
			pen.flush();
			pen.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
