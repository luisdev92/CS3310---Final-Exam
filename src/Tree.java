
public interface Tree<T> {
	public void traversal(int choice);
	public void insert(T data);
	public void delete(T data);
	public T getMaxValue();
	public T getMinValue();
	public String getTraversalString();
}
