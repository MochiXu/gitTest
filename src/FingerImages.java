
import java.io.Serializable;
import java.util.*;
import java.util.function.BiConsumer;

public class FingerImages implements Serializable {
    private Map<Integer, byte[]> fingers;


    private float scale_time = 0;

    private int rotate_degree = 0;

    private String fingerTemp;

    // TODO: deprecate this method
    public FingerImages() {
        fingers = new HashMap<>();
    }

    public FingerImages(Map<Integer, byte[]> fingers) {
        this.fingers = fingers;
    }

    public Map<Integer, byte[]> getFingers() {
        return Collections.unmodifiableMap(fingers);
    }

    public void setFingers(Map<Integer, byte[]> fingers) {
        this.fingers = fingers;
    }

    public void setFinger(int finger, byte[] image) {
        this.fingers.put(finger, image);
    }

    public void forEach(BiConsumer<Integer, byte[]> action) {
        fingers.forEach(action);
    }

    public boolean contains(Integer finger) {
        return fingers.containsKey(finger);
    }

    public int size() {
        return fingers.size();
    }

    // do not name this function to isEmpty(), otherwise msgpack will treat "empty" as a field
    public boolean empty() {
        return fingers.isEmpty();
    }

    public Set<Integer> indexSet() {
        return fingers.keySet();
    }

    public void deleteFinger(int finger) {
        this.fingers.remove(finger);
    }

    public float getScale_time() {
        return scale_time;
    }

    public void setScale_time(float scale_time) {
        this.scale_time = scale_time;
    }

    public int getRotate_degree() {
        return rotate_degree;
    }

    public void setRotate_degree(int rotate_degree) {
        this.rotate_degree = rotate_degree;
    }

    public String getFingerTemp() {
        return fingerTemp;
    }

    public void setFingerTemp(String fingerTemp) {
        this.fingerTemp = fingerTemp;
    }
}
