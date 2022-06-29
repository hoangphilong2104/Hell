package blog.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import blog.entity.BlogPost;

public class BlogObjectDao extends BlogMemoryDao {
	private static final String FILENAME = "blog-object.dat";

	public static void readObj() {
		try (FileInputStream fi = new FileInputStream(FILENAME)) {
			ObjectInputStream os = new ObjectInputStream(fi);
			Object obj = os.readObject();
			if (obj instanceof BlogPost) {
				BlogPost post = (BlogPost) obj;
//                postRepo.add(post);
			}
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void writeObj() {
		try (FileOutputStream fs = new FileOutputStream(FILENAME)) {
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(null);
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
