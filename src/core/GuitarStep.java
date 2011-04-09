package core;

public class GuitarStep {
    public static final int STEP_SIZE = 1;
    
    public static final int NUM_STRINGS = 6;

    private static Note[] strings = {
            new Note(Letter.E, 4),
            new Note(Letter.B, 3),
            new Note(Letter.G, 3),
            new Note(Letter.D, 3),
            new Note(Letter.A, 2),
            new Note(Letter.E, 2),
            };
    
    private Integer[] frets = { null, null, null, null, null, null };
    
    public GuitarStep(Note n) {
        if (null == n)
            return;
        int r = n.getRank();
        boolean done = false;
        // start at highest string, move down until a string can play the note
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].getRank() < r) {
                frets[i] = r - strings[i].getRank();
                done = true;
                break;
            }
        }
        if (!done) {
            //can't play the note
            frets[strings.length-1] = r - strings[strings.length-1].getRank();
        }
    }
    
    public GuitarStep(Integer[] fs) {
        this.frets = fs;
    }

    public String getString(int i) {
        String ret;
        if (i<0 || i>=strings.length) {
            ret = "-";
        } else {
            if (frets[i] == null)
                ret = "-";
            else
                ret = frets[i].toString();
        }
        while (ret.length() < STEP_SIZE)
            ret = ret + "-";
        return ret;
    }
    
    public Note getNote() {
        for (int i=0; i<frets.length; i++) {
            if (frets[i] != null)
                return new Note(strings[i].getRank() + frets[i]);
        }
        return null;
    }
}
