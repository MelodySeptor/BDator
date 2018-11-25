package components;

public class DataContainer<T> {
	private T data;

	public DataContainer() {

	}

	public DataContainer(T data) {
		this.setData(data);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
