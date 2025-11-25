package network.tcp.v5;

import java.util.ArrayList;
import java.util.List;

public class SessionManagerV5 {
    private List<SessionV5> sessions = new ArrayList<>();

    public synchronized void add(SessionV5 session) {
        sessions.add(session);
    }

    public synchronized void remove(SessionV5 session){
        sessions.remove(session);
    }

    public synchronized void closeAll(){
        for (SessionV5 session : sessions) {
            session.close();
        }
        sessions.clear();
    }
}
