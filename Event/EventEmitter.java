// package callbackIml;

// import inter.EventService;
// import inter.EventCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventEmitter implements EventService {

	private Map<String, List<EventCallback>> eventMap = new HashMap<String, List<EventCallback>>();

	@Override
	public void on(String eventName, EventCallback ec) {

		List<EventCallback> callbackList = eventMap.get(eventName);

		if (null == callbackList) {
			callbackList = new ArrayList<EventCallback>();
		}

		if (callbackList.isEmpty()) {
			eventMap.put(eventName, callbackList);
		}

		callbackList.add(ec);
	}

	@Override
	public void remove(String eventName) {

		eventMap.remove(eventName);
	}

	@Override
	public void trigger(String eventName) {

		List<EventCallback> callbackList = eventMap.get(eventName);

		for (EventCallback inter : callbackList) {

			inter.callback(this);
		}

	}
}
