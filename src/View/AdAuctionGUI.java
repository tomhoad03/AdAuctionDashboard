package View;

import Models.Campaign;
import Models.ChartCalculator;
import Models.MetricCalculator;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class AdAuctionGUI extends JFrame{
    private static JFrame gui;
    private static JLayeredPane menu;

    // private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    static Color orange = new Color(220,120,27);
    static Color blue = new Color(14,139,229);
    static Color grey = new Color(242,236,236);

    static Font mainFont = new Font("Impact", Font.PLAIN, 15);

    public static Color getPrimaryColor(){
       return blue;
    }

    public static Color getSecondaryColor(){
       return orange;
    }

    public static Font getMainFont(){
        return mainFont;
    }

    public static void prepareGui(MetricCalculator calculator) {
        gui = new JFrame("Ad Auction Monitor");
        gui.setVisible(true);
        gui.setExtendedState(JFrame.MAXIMIZED_BOTH);
        gui.setResizable(false);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
        createMenu(calculator);
        gui.add(menu);
    }

    /*
    public static void makeFrameFullSize(JFrame aFrame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        aFrame.setSize(screenSize.width, screenSize.height);
    }*/

    public static void createMenu(MetricCalculator calculator){
        menu = new JLayeredPane();
        menu.setSize(gui.getWidth(),gui.getHeight());
        menu.setOpaque(true);
        menu.setBackground(Color.WHITE);

        createTopMenu();
        createVerticalMenu();
        createInsightsGrid(calculator);
    }

    public static void createVerticalMenu() {
        JPanel verticalMenu = new JPanel(new GridLayout(5, 1));
        verticalMenu.setBounds(0,100,200,gui.getHeight()-100);
        verticalMenu.setAlignmentY(100);
        verticalMenu.setOpaque(true);
        verticalMenu.setBackground(grey);

        //start panel
        JPanel insightsButtonPanel = new JPanel(new BorderLayout());
        insightsButtonPanel.setOpaque(false);
        insightsButtonPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));

        JButton insightsButton = new JButton("Insights");
        insightsButton.setFont(getMainFont());
        insightsButton.setBorderPainted(false);
        insightsButton.setContentAreaFilled(false);
        insightsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        insightsButtonPanel.add(insightsButton);
        //end panel

        //start panel
        JPanel chartsButtonPanel = new JPanel(new BorderLayout());
        chartsButtonPanel.setOpaque(false);
        chartsButtonPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));

        JButton chartsButton = new JButton("Charts");
        chartsButton.setBorderPainted(false);
        chartsButton.setContentAreaFilled(false);
        chartsButton.setFont(getMainFont());
        chartsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        chartsButtonPanel.add(chartsButton);
        //end panel

        //start panel
        JPanel histogramsButtonPanel = new JPanel(new BorderLayout());
        histogramsButtonPanel.setOpaque(false);
        histogramsButtonPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));

        JButton histogramsButton = new JButton("Histograms");
        histogramsButton.setBorderPainted(false);
        histogramsButton.setContentAreaFilled(false);
        histogramsButton.setFont(getMainFont());
        histogramsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        histogramsButtonPanel.add(histogramsButton);
        //end panel

        //start panel
        JPanel compareButtonPanel = new JPanel(new BorderLayout());
        compareButtonPanel.setOpaque(false);
        compareButtonPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));

        JButton compareButton = new JButton("Compare");
        compareButton.setBorderPainted(false);
        compareButton.setContentAreaFilled(false);
        compareButton.setFont(getMainFont());
        compareButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        compareButtonPanel.add(compareButton);
        //end panel

        //start panel
        JPanel settingsButtonPanel = new JPanel(new BorderLayout());
        settingsButtonPanel.setOpaque(false);
        settingsButtonPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));

        JButton settingsButton = new JButton("Settings");
        settingsButton.setBorderPainted(false);
        settingsButton.setContentAreaFilled(false);
        settingsButton.setFont(getMainFont());
        settingsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        settingsButtonPanel.add(settingsButton);
        //end panel

        verticalMenu.add(insightsButtonPanel);
        verticalMenu.add(chartsButtonPanel);
        verticalMenu.add(histogramsButtonPanel);
        verticalMenu.add(compareButtonPanel);
        verticalMenu.add(settingsButtonPanel);

        menu.add(verticalMenu, BorderLayout.WEST,0);
    }

    public static void createTopMenu() {
        JLayeredPane topMenu = new JLayeredPane();
        topMenu.setSize(gui.getWidth(),100);
        topMenu.setOpaque(true);
        topMenu.setBackground(new Color(14,139,229));

        JLabel productName = new JLabel("Ad Monitor");
        productName.setBackground(getPrimaryColor());
        productName.setSize(100,100);
        productName.setAlignmentX(20);
        productName.setBounds(20,0,100,100);
        productName.setForeground(Color.WHITE);
        productName.setFont(getMainFont());

        JLabel customerName = new JLabel("Customer Name");
        productName.setSize(100,100);
        customerName.setBounds(gui.getWidth()-120,0,100,100);
        customerName.setForeground(Color.WHITE);

        topMenu.add(productName,BorderLayout.WEST,0);
        topMenu.add(customerName,BorderLayout.EAST,1);
        menu.add(topMenu,BorderLayout.NORTH,1);
    }

    public static void createInsightsGrid(MetricCalculator calculator) {
        Font fontOfText = new Font("Impact", Font.PLAIN, 25);
        Font fontOfValue = new Font("Impact", Font.BOLD, 30);
        Border blackBorder = BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10,10,10,10), BorderFactory.createLineBorder(grey, 1));

        JPanel insightsGrid = new JPanel(new GridLayout(4, 3));
        insightsGrid.setBounds(200,100,gui.getWidth()-200,gui.getHeight()-100);
        insightsGrid.setAlignmentY(100);
        insightsGrid.setOpaque(true);
        insightsGrid.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));

        //start panel
        JPanel impressionsPanel = new JPanel(new GridBagLayout());
        impressionsPanel.setBorder(blackBorder);
        impressionsPanel.setOpaque(false);

        JLabel impressions = new JLabel("Impressions");
        impressions.setAlignmentX(CENTER_ALIGNMENT);
        impressions.setForeground(getSecondaryColor());
        impressions.setFont(fontOfText);

        JLabel impressionsValue = new JLabel(toString(calculator.getImpressionsNo()));
        impressionsValue.setAlignmentX(CENTER_ALIGNMENT);
        impressionsValue.setFont(fontOfValue);

        Box insightsVBox = Box.createVerticalBox();
        insightsVBox.add(impressionsValue);
        insightsVBox.add(impressions);
        impressionsPanel.add(insightsVBox);
        //end panel

        //start panel
        JPanel clicksPanel = new JPanel(new GridBagLayout());
        clicksPanel.setBorder(blackBorder);
        clicksPanel.setOpaque(false);

        JLabel clicks = new JLabel("Clicks");
        clicks.setAlignmentX(CENTER_ALIGNMENT);
        clicks.setForeground(getSecondaryColor());
        clicks.setFont(fontOfText);

        JLabel clicksValue = new JLabel(toString(calculator.getClicksNo()));
        clicksValue.setAlignmentX(CENTER_ALIGNMENT);
        clicksValue.setFont(fontOfValue);

        Box clicksVbox = Box.createVerticalBox();
        clicksVbox.add(clicksValue);
        clicksVbox.add(clicks);
        clicksPanel.add(clicksVbox);
        //end panel

        //start panel
        JPanel uniquesPanel = new JPanel(new GridBagLayout());
        uniquesPanel.setBorder(blackBorder);
        uniquesPanel.setOpaque(false);

        JLabel uniques = new JLabel("Clicks");
        uniques.setAlignmentX(CENTER_ALIGNMENT);
        uniques.setForeground(getSecondaryColor());
        uniques.setFont(fontOfText);

        JLabel uniquesValue = new JLabel(toString(calculator.getUniquesNo()));
        uniquesValue.setAlignmentX(CENTER_ALIGNMENT);
        uniquesValue.setFont(fontOfValue);

        Box uniquesBox = Box.createVerticalBox();
        uniquesBox.add(uniquesValue);
        uniquesBox.add(uniques);
        uniquesPanel.add(uniquesBox);
        //end panel

        //start panel
        JPanel ctrPanel = new JPanel(new GridBagLayout());
        ctrPanel.setBorder(blackBorder);
        ctrPanel.setOpaque(false);

        JLabel ctr = new JLabel("CTR");
        ctr.setAlignmentX(CENTER_ALIGNMENT);
        ctr.setForeground(getSecondaryColor());
        ctr.setFont(fontOfText);

        JLabel ctrValues = new JLabel(toString(calculator.getCtr()));
        ctrValues.setAlignmentX(CENTER_ALIGNMENT);
        ctrValues.setFont(fontOfValue);

        Box ctrBox = Box.createVerticalBox();
        ctrBox.add(ctrValues);
        ctrBox.add(ctr);
        ctrPanel.add(ctrBox);
        //end panel

        //start panel
        JPanel cpaPanel = new JPanel(new GridBagLayout());
        cpaPanel.setBorder(blackBorder);
        cpaPanel.setOpaque(false);

        JLabel cpa = new JLabel("CPA");
        cpa.setAlignmentX(CENTER_ALIGNMENT);
        cpa.setForeground(getSecondaryColor());
        cpa.setFont(fontOfText);

        JLabel cpaValues = new JLabel(toString(calculator.getCpa()));
        cpaValues.setAlignmentX(CENTER_ALIGNMENT);
        cpaValues.setFont(fontOfValue);

        Box cpaBox = Box.createVerticalBox();
        cpaBox.add(cpaValues);
        cpaBox.add(cpa);
        cpaPanel.add(cpaBox);
        //end panel

        //start panel
        JPanel cpcPanel = new JPanel(new GridBagLayout());
        cpcPanel.setBorder(blackBorder);
        cpcPanel.setOpaque(false);

        JLabel cpc = new JLabel("CPC");
        cpc.setAlignmentX(CENTER_ALIGNMENT);
        cpc.setForeground(getSecondaryColor());
        cpc.setFont(fontOfText);

        JLabel cpcValues = new JLabel(toString(calculator.getCpc()));
        cpcValues.setAlignmentX(CENTER_ALIGNMENT);
        cpcValues.setFont(fontOfValue);

        Box cpcBox = Box.createVerticalBox();
        cpcBox.add(cpcValues);
        cpcBox.add(cpc);
        cpcPanel.add(cpcBox);
        //end panel

        //start panel
        JPanel cpmPanel = new JPanel(new GridBagLayout());
        cpmPanel.setBorder(blackBorder);
        cpmPanel.setOpaque(false);

        JLabel cpm = new JLabel("CPM");
        cpm.setAlignmentX(CENTER_ALIGNMENT);
        cpm.setForeground(getSecondaryColor());
        cpm.setFont(fontOfText);

        JLabel cpmValues = new JLabel(toString(calculator.getCpm()));
        cpmValues.setAlignmentX(CENTER_ALIGNMENT);
        cpmValues.setFont(fontOfValue);

        Box cpmBox = Box.createVerticalBox();
        cpmBox.add(cpmValues);
        cpmBox.add(cpm);
        cpmPanel.add(cpmBox);
        //end panel

        //start panel
        JPanel conversionsPanel = new JPanel(new GridBagLayout());
        conversionsPanel.setBorder(blackBorder);
        conversionsPanel.setOpaque(false);

        JLabel conversions = new JLabel("Conversions");
        conversions.setAlignmentX(CENTER_ALIGNMENT);
        conversions.setForeground(getSecondaryColor());
        conversions.setFont(fontOfText);

        JLabel conversionsValues = new JLabel(toString(calculator.getConversionsNo()));
        conversionsValues.setAlignmentX(CENTER_ALIGNMENT);
        conversionsValues.setFont(fontOfValue);

        Box conversionsBox = Box.createVerticalBox();
        conversionsBox.add(conversionsValues);
        conversionsBox.add(conversions);
        conversionsPanel.add(conversionsBox);
        //end panel

        //start panel
        JPanel totalCostPanel = new JPanel(new GridBagLayout());
        totalCostPanel.setBorder(blackBorder);
        totalCostPanel.setOpaque(false);

        JLabel totalCost = new JLabel("Total Cost");
        totalCost.setAlignmentX(CENTER_ALIGNMENT);
        totalCost.setForeground(getSecondaryColor());
        totalCost.setFont(fontOfText);

        JLabel totalCostValues = new JLabel(toString(calculator.getTotalImpressionCost()));
        totalCostValues.setAlignmentX(CENTER_ALIGNMENT);
        totalCostValues.setFont(fontOfValue);

        Box totalCostBox = Box.createVerticalBox();
        totalCostBox.add(totalCostValues);
        totalCostBox.add(totalCost);
        totalCostPanel.add(totalCostBox);
        //end panel

        //start panel
        JPanel bouncePanel = new JPanel(new GridBagLayout());
        bouncePanel.setBorder(blackBorder);
        bouncePanel.setOpaque(false);

        JLabel bounce = new JLabel("Bounces");
        bounce.setAlignmentX(CENTER_ALIGNMENT);
        bounce.setForeground(getSecondaryColor());
        bounce.setFont(fontOfText);

        JLabel bounceValues = new JLabel(toString(calculator.getBouncesNo()));
        bounceValues.setAlignmentX(CENTER_ALIGNMENT);
        bounceValues.setFont(fontOfValue);

        Box bounceBox = Box.createVerticalBox();
        bounceBox.add(bounceValues);
        bounceBox.add(bounce);
        bouncePanel.add(bounceBox);
        //end panel

        //start panel
        JPanel bounceRatePanel = new JPanel(new GridBagLayout());
        bounceRatePanel.setBorder(blackBorder);
        bounceRatePanel.setOpaque(false);

        JLabel bounceRate = new JLabel("Bounce Rate");
        bounceRate.setAlignmentX(CENTER_ALIGNMENT);
        bounceRate.setForeground(getSecondaryColor());
        bounceRate.setFont(fontOfText);

        JLabel bounceRateValues = new JLabel(toString(calculator.getBr()));
        bounceRateValues.setAlignmentX(CENTER_ALIGNMENT);
        bounceRateValues.setFont(fontOfValue);

        Box bounceRateBox = Box.createVerticalBox();
        bounceRateBox.add(bounceRateValues);
        bounceRateBox.add(bounceRate);
        bounceRatePanel.add(bounceRateBox);
        //end panel

        //start panel
        JPanel bounceTimePanel = new JPanel(new GridBagLayout());
        bounceTimePanel.setBorder(blackBorder);
        bounceTimePanel.setOpaque(false);

        JLabel bounceTime = new JLabel("Time");
        bounceTime.setAlignmentX(CENTER_ALIGNMENT);
        bounceTime.setFont(fontOfValue);

        JLabel bounceTimeValues = new JLabel("Bounce Type");
        bounceTimeValues.setAlignmentX(CENTER_ALIGNMENT);
        bounceTimeValues.setForeground(getSecondaryColor());
        bounceTimeValues.setFont(fontOfText);

        Box bounceTimeBox = Box.createVerticalBox();
        bounceTimeBox.add(bounceTime);
        bounceTimeBox.add(bounceTimeValues);

        bounceTimePanel.add(bounceTimeBox);
        //end panel

        insightsGrid.add(impressionsPanel);
        insightsGrid.add(clicksPanel);
        insightsGrid.add(uniquesPanel);
        insightsGrid.add(ctrPanel);
        insightsGrid.add(cpaPanel);
        insightsGrid.add(cpcPanel);
        insightsGrid.add(cpmPanel);
        insightsGrid.add(conversionsPanel);
        insightsGrid.add(totalCostPanel);
        insightsGrid.add(bouncePanel);
        insightsGrid.add(bounceRatePanel);
        insightsGrid.add(bounceTimePanel);

        menu.add(insightsGrid);
    }

    // converts a metric to a readable string
    public static String toString(float metric)
    {
        if (metric == (int) metric) // only rounds this floats
            return String.format("%d", (int) metric);
        else
            return String.format("%.4g%n", metric); // change the 4 to change the sf for floats
    }

    public static void main(String[] args) {
        // reads the files and stores the logs - only create one campaign otherwise it will be slow
        Campaign campaign = new Campaign("src/Logs/impression_log.csv", "src/Logs/click_log.csv", "src/Logs/server_log.csv"); // string inputs temporary

        // used to display metrics as values
        MetricCalculator calculator1 = campaign.newMetricCalculator();
        calculator1.calculateMetrics();

        prepareGui(calculator1);

        // used to display metrics as charts
        ChartCalculator calculator2 = campaign.newChartCalculator();
        calculator2.calculateCharts("days", calculator2.getImpressionLog().getFirstDate(), calculator2.getImpressionLog().getLastDate());

        Chart chart = new Chart( "Metrics vs Time" , "Metrics vs Time","impressions", calculator2);
        chart.pack();
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );

        /*
         * notes:
         * all the backend is in Models, all the GUI stuff is in View - MVC
         * file reading is only done once - unavoidably slow
         * jfreechart needs to be installed to run - downloads in whatsapp
         *
         * to do:
         * find any possible performance improvements in the backend
         * create class diagrams for 1st deliverable
         *
         * for later:
         * filtering was removed due to my bad implementation - leave till 2nd deliverable
         * bounce factors are hardcoded - leave till 2nd deliverable
         * will later add a class HistogramCalculator - leave till 2nd deliverable
         */
    }
}
