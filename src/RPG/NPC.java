package RPG;

public class NPC {
    int age;
    String name;
    String greetingPhrase;

    NPC(int age, String name, String greetingPhrase) {
        this.age = age;
        this.name = name;
        this.greetingPhrase = greetingPhrase;
    }

    void sayGreetingPhrase(String playerName) {
        System.out.println("Hi " + playerName + ", \n" + greetingPhrase);
    }

    void introduceYourself() {
        System.out.println("My name is " + name);
    }
}
