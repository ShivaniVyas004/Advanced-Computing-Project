package searche;

import java.io.*;
import javax.swing.text.html.*;
import javax.swing.text.html.parser.*;

public class HTMLtoText extends HTMLEditorKit.ParserCallback {
	StringBuffer s;

	public static void main(String a[]) {
		try {
			File folder = new File("C:/Users/rachs/Desktop/Project/SearchE/Web Pages/");
			for (File file : folder.listFiles()) {
				String name = file.getName();
				// System.out.println(name);
				String[] file_name = name.split("\\.htm");
				String file_name1 = file_name[0];
				System.out.println(file_name1);

				FileReader in = new FileReader(file);
				HTMLtoText parser = new HTMLtoText();
				parser.parse(in);
				in.close();
				String textHTML = parser.getText();
				// System.out.println(textHTML);

				// Write the text to a file
				BufferedWriter writerTxt = new BufferedWriter(new FileWriter(
						"C:/Users/rachs/Desktop/Project/SearchE/filesToIndex/"
								+ file_name1 + ".txt"));
				writerTxt.write(textHTML);
				writerTxt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void parse(Reader in) throws IOException {
		s = new StringBuffer();
		ParserDelegator delegator = new ParserDelegator();
		// the third parameter is TRUE to ignore charset directive
		delegator.parse(in, this, Boolean.TRUE);
	}

	public void handleText(char[] text, int pos) {
		s.append(text);
	}

	public String getText() {
		return s.toString();
	}
}
