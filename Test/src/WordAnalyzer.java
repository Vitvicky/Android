
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PushbackInputStream;
import java.util.LinkedList;

public class WordAnalyzer {
	private LinkedList<Word> word = null;
	private PushbackInputStream reader = null;
	private int next;

	public WordAnalyzer(String path) {
		try {
			reader = new PushbackInputStream((new BufferedInputStream(
					new FileInputStream(path))));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		word = new LinkedList<Word>();
	}

	public void execute() {
		try {
			next = reader.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (next != -1) {
			char nextChar = (char) next;
			if (Character.isSpaceChar(nextChar))
				;
			else if (isLetter(nextChar)) {
				StringBuilder sign = new StringBuilder(10);
				sign.append(nextChar);
				try {
					nextChar = (char) reader.read();
				} catch (IOException e) {
					e.printStackTrace();
				}
				while (isLetter(nextChar) || isDigit(nextChar)) {
					sign.append(nextChar);
					try {
						nextChar = (char) reader.read();
					} catch (IOException e) {

						e.printStackTrace();
					}
				}
				if (sign.toString().equals("if")) {
					Word w = new Word(WordType.IFSYM, sign.toString(), 0);
					word.add(w);
				} else if (sign.toString().equals("CONST")) {
					Word w = new Word(WordType.CONSTSYM, sign.toString(), 0);
					word.add(w);
				} else if (sign.toString().equals("begin")) {
					Word w = new Word(WordType.BEGINSYM, sign.toString(), 0);
					word.add(w);
				} else if (sign.toString().equals("VAR")) {
					Word w = new Word(WordType.VARSYM, sign.toString(), 0);
					word.add(w);
				} else if (sign.toString().equals("procedure")) {
					Word w = new Word(WordType.PROCEDURESYM, sign.toString(), 0);
					word.add(w);
				} else if (sign.toString().equals("odd")) {
					Word w = new Word(WordType.ODDSYM, sign.toString(), 0);
					word.add(w);
				} else if (sign.toString().equals("if")) {
					Word w = new Word(WordType.IFSYM, sign.toString(), 0);
					word.add(w);
				} else if (sign.toString().equals("then")) {
					Word w = new Word(WordType.THENSYM, sign.toString(), 0);
					word.add(w);
				} else if (sign.toString().equals("call")) {
					Word w = new Word(WordType.CALLSYM, sign.toString(), 0);
					word.add(w);
				} else if (sign.toString().equals("while")) {
					Word w = new Word(WordType.WHILESYM, sign.toString(), 0);
					word.add(w);
				} else if (sign.toString().equals("do")) {
					Word w = new Word(WordType.DOSYM, sign.toString(), 0);
					word.add(w);
				} else if (sign.toString().equals("read")) {
					Word w = new Word(WordType.READSYM, sign.toString(), 0);
					word.add(w);
				} else if (sign.toString().equals("write")) {
					Word w = new Word(WordType.WRITESYM, sign.toString(), 0);
					word.add(w);
				} else {
					Word w = new Word(WordType.IDENT, sign.toString(), 0);
					word.add(w);
				}
				try {
					reader.unread(nextChar);
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println(sign);
			} else if (isDigit(nextChar)) {
				StringBuilder sign = new StringBuilder(10);
				sign.append(nextChar);
				try {
					nextChar = (char) reader.read();
				} catch (IOException e) {
					e.printStackTrace();
				}
				while (isDigit(nextChar)) {
					sign.append(nextChar);
					try {
						nextChar = (char) reader.read();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				Word w = new Word(WordType.NUMBER, null, Integer.parseInt(sign
						.toString()));
				word.add(w);
				try {
					reader.unread(nextChar);
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println(sign);
			} else if (nextChar == '=') {
				Word w = new Word(WordType.EQUALSIGN, null, 0);
				word.add(w);
				System.out.println("=");
			} else if (nextChar == '#') {
				Word w = new Word(WordType.JINGSIGN, null, 0);
				word.add(w);
				System.out.println("#");
			} else if (nextChar == '<') {
				try {
					nextChar = (char) reader.read();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (nextChar == '=') {
					Word w = new Word(WordType.LESSEQUALSIGN, null, 0);
					word.add(w);
				} else {
					Word w = new Word(WordType.LESSSIGN, null, 0);
					word.add(w);
					try {
						reader.unread(nextChar);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else if (nextChar == '>') {
				try {
					nextChar = (char) reader.read();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (nextChar == '=') {
					Word w = new Word(WordType.LARGEEQUALSIGN, null, 0);
					word.add(w);
				} else {
					Word w = new Word(WordType.LARGE, null, 0);
					word.add(w);
					try {
						reader.unread(nextChar);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			} else if (nextChar == ',') {
				Word w = new Word(WordType.DOU, null, 0);
				word.add(w);
			} else if (nextChar == ';') {
				Word w = new Word(WordType.FEN, null, 0);
				word.add(w);
			} else if (nextChar == '(') {
				Word w = new Word(WordType.ZUO, null, 0);
				word.add(w);
			} else if (nextChar == ')') {
				Word w = new Word(WordType.YOU, null, 0);
				word.add(w);
			}
			try {
				next = reader.read();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

	public boolean isLetter(char c) {
		if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
			return true;
		}
		return false;
	}

	public boolean isDigit(char c) {
		if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4'
				|| c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		WordAnalyzer w=new WordAnalyzer("G:\\test.txt");
		w.execute();
	}
}

class Word {
	public WordType SYM;
	public String ID;
	public int NUM;

	public Word(WordType SYM, String ID, int NUM) {
		this.SYM = SYM;
		this.ID = ID;
		this.NUM = NUM;
	}
}

enum WordType {
	IDENT, NUMBER, EQUALSIGN, JINGSIGN, LESSEQUALSIGN, LESSSIGN, LARGEEQUALSIGN, LARGE, DOU, FEN, ZUO, YOU, IFSYM, CONSTSYM, VARSYM, PROCEDURESYM, BEGINSYM, ODDSYM, THENSYM, CALLSYM, WHILESYM, DOSYM, READSYM, WRITESYM;
}
