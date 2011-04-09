package core;

public class Note {
    private Letter letter;
    private Integer octave;
    private Integer rank;

    public Note (Letter l, Integer o) {
        this.letter = l;
        this.octave = o;
        
        this.rank = (12 * octave) + letter.ordinal();
    }
    
    public Note (Integer r) {
        this.rank = r;
        
        this.octave = r / 12;
        this.letter = Letter.values()[r%12];
    }
    
    public Integer getRank() {
        return rank;
    }
}
