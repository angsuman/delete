import java.io.File;
public class Delete {
  public static void main(String paths[]) {
    for(String path : paths) if(path != null) delete(new File(path));
  }
  
  /** Recursively delete Directory and File on best effort basis */
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
  
  /* Delete a File or Directory. On failure schedule it to delete on exit. */
  private static void tryDelete(File file) {
    if(!file.delete()) {
      //System.out.println("Failed, scheduling: " + file);
      file.deleteOnExit();
    } else {
      //System.out.println("Success: " + file);
    }
  }
}
