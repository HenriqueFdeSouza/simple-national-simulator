import com.github.henriquefdesouza.simulator.Annexs;
import com.github.henriquefdesouza.simulator.PanelOfAnnexes;
import com.github.henriquefdesouza.simulator.annexone.AnnexOne;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {

//        Annexs annexOne = new AnnexOne();
//        Annexs annexs = new AnnexTwo();
//        Annexs annexs = new AnnexThree();
//        Annexs annexs = new AnnexFour();

//        annexOne.printGuideAliquots();

        PanelOfAnnexes panelOfAnnexes = new PanelOfAnnexes();
        panelOfAnnexes.choiceAnnex();
    }
}