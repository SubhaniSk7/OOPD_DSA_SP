package DSA.HW2;

public class WordsClass {

	String data;
	int count;

	public WordsClass() {

		// data = null;
		data = "";
		count = 0;
	}

	public WordsClass(String data, int count) {

		this.data = data;
		this.count = count;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
