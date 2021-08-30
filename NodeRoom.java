
public class NodeRoom {

    String roomId;
    int size;
    boolean multimedia;
    

    NodeRoom(String roomId, int size, boolean multimedia) {
        this.roomId = roomId;
        this.size = size;
        this.multimedia = multimedia;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setMultimedia(boolean multimedia) {
        this.multimedia = multimedia;
    }

    public String getRoomId() {
        return roomId;
    }

    public int getSize() {
        return size;
    }

    public boolean isMultimedia() {
        return multimedia;
    }
}
