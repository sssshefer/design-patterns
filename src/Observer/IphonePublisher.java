package Observer;

public class IphonePublisher {
    public EventManager events;
    private String lastIphoneVersion;

    public IphonePublisher(){
        events = new EventManager();
    }

    public void releaseNewIphone(String iphoneVersion) {
        lastIphoneVersion = iphoneVersion;
        events.notify("newIphone", iphoneVersion);
    }
}
