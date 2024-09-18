package RPG.World;

import RPG.GameCharacter.GameCharacter;
import RPG.NPC;

import java.util.ArrayList;
import java.util.List;


public class World {
    List<GameCharacter> gameCharacters = new ArrayList<GameCharacter>();
    List<NPC> npcs = new ArrayList<NPC>();

    public WorldEventManager events;

    TimeOfDay currentTimeOfDay;

    //Singleton pattern
    private static World instance;

    World() {
        this.currentTimeOfDay = TimeOfDay.DAY;
        //Observer pattern
        this.events = new WorldEventManager("Time Change");
    }

    //Singleton pattern
    public static World getInstance() {
        if (instance == null) {
            instance = new World();
        }
        return instance;
    }

    public void addGameCharacter(GameCharacter gameCharacter) {
        gameCharacters.add(gameCharacter);
        //Observer pattern
        events.subscribe("Time Change", gameCharacter);
    }

    public void removeGameCharacter(GameCharacter gameCharacter) {
        gameCharacters.remove(gameCharacter);
        //Observer pattern
        events.unsubscribe("Time Change", gameCharacter);
    }

    public void skipTime() {
        if (currentTimeOfDay == TimeOfDay.DAY) {
            currentTimeOfDay = TimeOfDay.NIGHT;
        } else {
            currentTimeOfDay = TimeOfDay.DAY;
        }
        events.notify("Time Change", currentTimeOfDay);
    }


}
