package RPG.Actions;

import RPG.GameCharacter.GameCharacter;
import RPG.Inventory;
import RPG.Weapons.Weapon;

public class EquipWeapon extends Action {
    Weapon weapon;
    Inventory inventory;
    Weapon equippedWeapon;

    public EquipWeapon(GameCharacter gameCharacter, Weapon weapon) {
        super(gameCharacter);
        this.weapon = weapon;
        this.inventory = gameCharacter.getInventory();
        this.equippedWeapon = gameCharacter.getEquippedWeapon();
    }

    @Override
    public boolean execute() {
        if (inventory.isContainItem(weapon)) {
            inventory.addItem(equippedWeapon);
            this.equippedWeapon = weapon;
            inventory.removeItem(weapon);
            return true;
        }
        return false;
    }
}
