package mySQLAndOracle;

public class DataContainer<T> {
	private T data;

	/**
	 * Constructor by default.
	 */
	public DataContainer() {

	}

	/**
	 * Constructor fast.
	 * 
	 * @param data<T> from any type.
	 */
	public DataContainer(T data) {
		this.setData(data);
	}

	/**
	 * Get data from container.
	 * 
	 * @return Data<T>
	 */
	public T getData() {
		return data;
	}

	/**
	 * Set data<T>
	 * 
	 * @param data<T>
	 */
	public void setData(T data) {
		this.data = data;
	}

}
