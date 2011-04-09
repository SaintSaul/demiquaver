package core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class demiquaver {
    
    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        String inputFile = "friends.txt", line;
        List<String> lines = new ArrayList<String>();
        List<MandolinStep> steps = new ArrayList<MandolinStep>();
        File input = new File(inputFile);
        BufferedReader br = new BufferedReader(new FileReader(input));
        
        
        while ((line = br.readLine()) != null)
            lines.add(line);
        
        while (lines.size() >= GuitarStep.NUM_STRINGS) {
            for (int i = 3; i < lines.get(0).length(); i++) {
                Integer[] frets = new Integer[GuitarStep.NUM_STRINGS];
                for (int j = 0; j < GuitarStep.NUM_STRINGS; j++) {
    //                System.out.println(lines.get(j).substring(i, i+MandolinStep.STEP_SIZE));
                    try {
                        frets[j] = Integer.parseInt(lines.get(j).substring(i, i+1));
    //                    System.out.print(frets[j]);
                    } catch (Exception e) {
                        frets[j] = null;
                    }
                }
                GuitarStep m = new GuitarStep(frets);
                Note temp = m.getNote();
                if (temp != null)
                    temp = new Note(temp.getRank()+12);
                MandolinStep g = new MandolinStep(temp);
                steps.add(g);
    //            System.out.println();
            }
            
            for (int j=0; j<MandolinStep.NUM_STRINGS; j++) {
                for (int i=0; i<steps.size(); i++) {
                   System.out.print(steps.get(i).getString(j));
                }
                System.out.println();
            }
            steps.clear();
            System.out.println();
            
            for (int i=0; (i<=GuitarStep.NUM_STRINGS && !lines.isEmpty()); i++)
                lines.remove(0);
        }
        
    }
    
}
