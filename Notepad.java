import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;
public class Notepad extends JFrame implements ActionListener{
TextArea textarea=new TextArea("",0,0,TextArea.SCROLLBARS_VERTICAL_ONLY);
MenuBar menubar =new MenuBar();
Menu file =new Menu("File");
MenuItem savefile=new MenuItem("savefile");
MenuItem openfile=new MenuItem("openfile");
MenuItem close=new MenuItem("close");
Menu tools =new Menu("Tools");
MenuItem compile=new MenuItem("Compile");
MenuItem run=new MenuItem("Run");
public Notepad(){
this.setSize(600,350);
this.setTitle("Basic IDE");
this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
this.textarea.setFont(new Font("Century Gothic", Font.BOLD, 12)); 
		this.getContentPane().setLayout(new BorderLayout()); 
		this.getContentPane().add(textarea);
		this.setMenuBar(this.menubar);
		
		this.openfile.addActionListener(this); 
		this.openfile.setShortcut(new MenuShortcut(KeyEvent.VK_O, false));
		this.file.add(this.openfile);
		this.savefile.addActionListener(this);
		this.savefile.setShortcut(new MenuShortcut(KeyEvent.VK_S, false));
		this.file.add(this.savefile);
		this.close.setShortcut(new MenuShortcut(KeyEvent.VK_F4, false));
		this.close.addActionListener(this);
		this.file.add(this.close);
		this.compile.setShortcut(new MenuShortcut(KeyEvent.VK_W, false));
		this.compile.addActionListener(this);
		this.tools.add(this.compile);
		this.run.setShortcut(new MenuShortcut(KeyEvent.VK_E, false));
		this.run.addActionListener(this);
		this.tools.add(this.run);
		this.menubar.add(this.file); 
 		this.menubar.add(this.tools);
		this.setVisible(true);
	
}
	public void actionPerformed (ActionEvent e) {
		if (e.getSource() == this.close)
			this.dispose(); 
		else if (e.getSource() == this.openfile) {
			JFileChooser open = new JFileChooser();
			int option = open.showOpenDialog(this); 
			if (option == JFileChooser.APPROVE_OPTION) {
				this.textarea.setText(""); 
				try {
					Scanner scan = new Scanner(new FileReader(open.getSelectedFile().getPath()));
					while (scan.hasNext()) 
						this.textarea.append(scan.nextLine() + "\n");
				} catch (Exception ex) { 
					System.out.println(ex.getMessage());
				}
			}
		}
 		else if (e.getSource() == this.savefile) {
			JFileChooser save = new JFileChooser();
			int option = save.showSaveDialog(this);
			if (option == JFileChooser.APPROVE_OPTION) {
				try {
					
					BufferedWriter out = new BufferedWriter(new FileWriter(save.getSelectedFile().getPath()));
					out.write(this.textarea.getText()); 
					out.close();
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}


			
		}else if (e.getSource() == this.compile) {
			this.textarea.append("compiling");
			}
		else if (e.getSource() == this.run) {
			this.textarea.append("running");
			}
		}
	}


public static void main(String args[]) {
        Notepad np = new Notepad();
        	
}
}
