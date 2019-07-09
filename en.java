package en;

	import java.awt.Color;
	import java.awt.Dimension;
	import java.awt.Graphics;
	import java.awt.Graphics2D;
	import java.lang.String;
	import java.lang.System;
	import java.util.Map;
	import java.util.LinkedHashMap;
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.JLabel;
	import javax.swing.JButton;
	import javax.swing.border.*;
	import static java.awt.RenderingHints.KEY_ANTIALIASING;
	import static java.awt.RenderingHints.VALUE_ANTIALIAS_ON;



	public class en extends JFrame {

	    public en() {
	        add(new DrawPanel());
	    }

	    public static void main(String[] A00) {
	        JFrame L00 = new en();
	        L00.setTitle("円グラフ");
	        L00.setDefaultCloseOperation(EXIT_ON_CLOSE);
	        L00.setBackground(Color.black);
	        L00.pack();
	        L00.setResizable(false);
	        L00.setVisible(true);
	        
	        
	   }
	
		}	
	
	//わける
	class DrawPanel extends JPanel {
		
		JLabel label = new JLabel("aaa");

		
	    private static final int C00 = 200;
	    private static final int C01 = 200;
	    private static final int C02 = 20;  // グラフの表示位置(x方向、y方向兼用)
	    private static final int C03 = 5;   // 影のずらし間隔(x方向、y方向兼用)
	    private static final int C04 = 150;
	    private Color I00 = new Color(64, 64, 64);    // 影とふちの色

	    private Map<Color, Integer> I01;
	    private int I02;

	    public DrawPanel() {
	        setBackground(Color.white);
	        setPreferredSize(new Dimension(C00, C01));
	        add(label);
	        I01 = new LinkedHashMap<Color, Integer>();
	        I01.put(new Color(255, 32, 32), 50);
	        I01.put(new Color(64, 192, 32), 18);
	        I01.put(new Color(96, 32, 255), 32);
	        I01.put(new Color(255, 192, 0), 42);
	        I01.put(new Color(0, 192, 255), 15);

	        
	        
	        
	        I02 = 0;
	        for (int L01 : I01.values()) {
	            I02 += L01;
	        }
	    }
		

	    public void paintComponent(Graphics A00) {
	        super.paintComponent(A00);

	        Graphics2D L00 = (Graphics2D)A00;
	        L00.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);

	        L00.setColor(I00);
	        L00.fillOval(C02 + C03, C02 + C03, C04, C04);

	        int L01 = 90;   // 円グラフの描画開始角度
	        int L02 = 0;    // 扇形の中心角
	        
	        for (Color L03 : I01.keySet()) {
	            L02 = Math.round(360f * I01.get(L03) / I02);
	            L01 -= L02;
	            L00.setColor(L03);
	            L00.fillArc(C02, C02, C04, C04, L01, L02);
	        }
	        // 四捨五入の都合で塗り残しが出た場合の対処
	        L00.fillArc(C02, C02, C04, C04, -270, L02);

	        L00.setColor(I00);
	        L00.drawOval(C02, C02, C04, C04);
	    }
	}
	


