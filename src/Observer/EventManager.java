package Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface EventListener {
    void update(String filename);
}

public class EventManager {
    private static Map<String, List<EventListener>> listeners= new HashMap<>();

    public void subscribe(String eventType, EventListener listener){
        listeners.computeIfAbsent(eventType, k -> new ArrayList<>()).add(listener);
    }

    public void unsubscribe(String eventType, EventListener listener){
        List <EventListener> users = listeners.get(eventType);
        if(users != null){
            users.remove(listener);
        }
    }

    public void notify(String eventType, String data){
        List<EventListener> users = listeners.get(eventType);
        if(users!= null){
            for(EventListener listener:users){
                listener.update(data);
            }
        }
    }
}