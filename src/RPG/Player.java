package RPG;

import RPG.GameCharacter.GameCharacter;

public class Player  {
    String username;
    GameCharacter gameCharacter;

    Player(String username) {
        this.username = username;
        this.gameCharacter = null;
    }

    public String getUsername() {
        return username;
    }

    public void setPlayableCharacter(GameCharacter gameCharacter) {
        if (this.gameCharacter == null)
            this.gameCharacter = gameCharacter;
    }

}
