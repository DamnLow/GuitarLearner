package model.Chords;

public class Chord {

    private String chordName;
    private Object data;

    public Chord(String name, Object data){
        this.chordName = name;
        this.data = data;
    }

    public String getChordName() {
        return chordName;
    }

    public void setChordName(String chordName) {
        this.chordName = chordName;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}