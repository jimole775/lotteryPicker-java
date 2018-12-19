// package callbackIml;

public interface EventService {
	void on(String eventName, EventCallback e);

	void remove(String eventName);

	void trigger(String eventName);
}
