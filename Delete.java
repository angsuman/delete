import java.io.File;
public class Delete {
  public static void main(String paths[]) {
    for(String path : paths) if(path != null) delete(new File(path));
  }
  
  /** Delete a file / directory on best effort basis */
  public static void delete(File file) {
    if(file != null && file.exists()) {
      if(file.isFile()) tryDelete(file);
      else if(file.isDirectory()) {
        File [] files = file.listFiles();
        for(File f : files) delete(f);
        tryDelete(file);
      }
    }
  }
  
  private static void tryDelete(File file) {
    if(!file.delete()) file.deleteOnExit();
  }
}
