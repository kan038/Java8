package example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SDTest {

	public static void main(String args[]) throws Exception{
		//シリアライズ
		//objectToDisk();
		//デシリアライズ
		//diskToObject();
	}
	
	// デシリアライズ
	private static void diskToObject() throws Exception {
		FileInputStream inFile = new FileInputStream("C:\\tmp\\20151213\\tempdata.ser"); 
		ObjectInputStream inObject = new ObjectInputStream(inFile);
		
		Object obj = inObject.readObject();
		
		if (obj instanceof Todo) {
			Todo todo = (Todo)obj;
			System.out.println("デシリアライズ + id = " + todo.getId());
		} else {
			System.out.println("予期しないデータ");
		}
		
		inObject.close();

	}

	// シリアライズ
	private static void objectToDisk() throws Exception {

		Todo todo = new Todo();
		todo.setId("777");
        FileOutputStream fos = new FileOutputStream("C:\\tmp\\20151213\\tempdata.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(todo);
        oos.close();
	}
	
	
}
