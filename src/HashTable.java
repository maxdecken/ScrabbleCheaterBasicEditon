
public interface HashTable<T> {
	
	long generateHashCode(T object);
	
	void removeObject(T nodeData);
	
	T getObject(T word);
	
	void addObject(T data);
}
