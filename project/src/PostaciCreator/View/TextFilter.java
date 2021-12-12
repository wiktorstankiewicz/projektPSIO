package PostaciCreator.View;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class TextFilter extends FileFilter {
	public boolean accept(File file) {
		if (file.isDirectory()) {
			return true;
		}

		String extension = null;
		String fName = file.getName();

		int i = fName.lastIndexOf('.');

		if (i>0 &&  i<fName.length() - 1) {
			extension = fName.substring(i+1).toLowerCase();
		}

		if (extension != null) {
			if (extension.equals("txt")) return true;
			else  return false;
		}

		return false;
	}

	public String getDescription() {
		return "Text files *.txt";
	}
}
