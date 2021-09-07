import java.io.File;
public class Delete {
  /** Recursively delete multiple files and directories specified in command line */
  public static void main(String paths[]) {
    for(String path : paths) if(path != null) delete(new File(path));
  }
  /** Recursively delete Directory and File on best effort basis */
  public static void delete(File file) {
    if(file != null && file.exists()) {
      if(file.isDirectory()) for(File f : file.listFiles()) delete(f);
      if(!file.delete()) file.deleteOnExit();
    }
  }
}
