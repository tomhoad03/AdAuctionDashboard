import View.AdAuctionGUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // gui
        AdAuctionGUI adAuctionGUI = new AdAuctionGUI();
        SwingUtilities.invokeLater(adAuctionGUI::prepareGui);

        // load files of campaign
        adAuctionGUI.createCampaign();
    }

    /*
     * to do:
     * significant speed improvements
     * not every metric is being calculated/displayed properly
     * load campaign from files button
     * filter dropdowns for metrics page
     * improve file reading with anomalous data
     * merge histogram and compare features
     */
}
