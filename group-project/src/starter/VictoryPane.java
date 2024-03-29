package starter;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import acm.graphics.GLabel;
import acm.graphics.GObject;

public class VictoryPane extends GraphicsPane {
private MainApplication program;

private GButton rematch = new GButton("Rematch", 95, 180, 200, 50);
private GButton replay = new GButton("Recreate your Chess group on the board", 95, 260, 200, 50);
private GButton Return = new GButton("Return to the Main Screen",95, 340, 200, 50);
	
public VictoryPane(MainApplication app) {
		program = app;
	}

public void playvictorySound() {
	try{
	      AudioInputStream audioInputStream =AudioSystem.getAudioInputStream(this.getClass().getResource("victorysoundeffect.wav"));
	     Clip clip = AudioSystem.getClip();
	     clip.open(audioInputStream);
	     clip.start( );
	    }
	   catch(Exception ex)
	   {  }
}

	@Override
	public void showContents() {
		// TODO Auto-generated method stub
		playvictorySound();
		program.setSize(450, 450);
		GLabel v = new GLabel("Victory", 145, 100);
		v.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
		v.setColor(Color.red);

		program.add(rematch);
	    program.add(replay);
		program.add(Return);
		program.add(v);
	}

	@Override
	public void hideContents() {
		program.removeAll();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if(obj == rematch)
		{
			program.loadOriginalBoard();
			program.setSize(900, 900);
			program.switchToGame();
		}
		if(obj == replay)
		{
			program.setSize(900, 900);
			program.loadEmptyBoard();
			program.switchToPieceShop();
		}
		if(obj == Return)
		{
			program.setSize(900, 900);
			program.switchToMenu();
		}
	}

}