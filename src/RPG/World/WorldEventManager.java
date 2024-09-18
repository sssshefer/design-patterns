package RPG.World;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorldEventManager {
    Map<String, List<WorldListener>> listeners = new HashMap<>();

    public WorldEventManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, WorldListener listener) {
        List<WorldListener> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType, WorldListener listener) {
        List<WorldListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    public void notify(String eventType, TimeOfDay timeOfDay) {
        List<WorldListener> users = listeners.get(eventType);
        for (WorldListener listener : users) {
            listener.onWorldEvent(timeOfDay);
        }
    }
}
