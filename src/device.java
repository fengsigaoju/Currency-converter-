import java.awt.*;
import javax.script.*; 
import org.python.util.PythonInterpreter;  //����jython
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import java.io.*;  
import static java.lang.System.*;  
public class device extends JFrame{
	private double d;
public class alert extends JDialog{
		public alert(){
			setTitle("����");
			setLayout(null);
			setBounds(400,300,250,200);
			Container container=getContentPane();
			JLabel jl= new JLabel("������������ȷ�Ķһ����");
		    jl.setBounds(50,50,200,100);
			container.add(jl);
			container.setBackground(Color.white);
		    setVisible(true);
		    }
}
   public device()throws IOException{
	   Process proc = Runtime.getRuntime().exec("python  C:\\Python27\\c.py");  
	   try {
		proc.waitFor();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
	   setTitle("���ʶһ���");
	   setLayout(null);
	   setBounds(200,200,500,550);//��һ��Ϊ�������ϵ�ĺ����꣬�ڶ���Ϊ�������ϵ�������꣬������Ϊ���ں����С�����ĸ�Ϊ���򴰿�
	   Container container=getContentPane();
	   JLabel jl= new JLabel("�һ����(��Ԫ)");
	   jl.setBounds(50,150,200,100);//����ڴ���
	   container.add(jl);
	   JLabel jl2=new JLabel("�һ����(�����)");
	   jl2.setBounds(45,250,200,100);
	   container.add(jl2);
	   JTextField jt=new JTextField("");
	   jt.setBounds(175,170,200,50);
	   container.add(jt);
	   JTextField jt2=new JTextField("");
	   jt2.setBounds(175,275,200,50);
	   container.add(jt2);
	   JButton jb=new JButton("����");
	   jb.setBounds(100,400,100,50);
	   container.add(jb);
	   JButton jb2=new JButton("�һ�");
	   jb2.setBounds(250,400,100,50);
	   container.add(jb2);
	   FileReader fin = new FileReader("E:\\1.txt");//�����ļ�
	   BufferedReader bin = new BufferedReader(fin);
	   String str=bin.readLine();//����
	   bin.close();//�ر��ļ�
	   if (str.isEmpty()){
		   System.out.println("û������\n");
	   }
	   d=Double.valueOf(str);
	   d=d/100;
	   JLabel jl3=new JLabel("��ǰ����(ÿ����Ԫ)Ϊ:");
	   jl3.setBounds(30,50,200,100);
	   container.add(jl3);
	   JTextField jt3=new JTextField(str);
	   jt3.setBounds(175,75,200,50);
	   container.add(jt3);
	   container.setBackground(Color.white);
	   setVisible(true);
	   jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stu9b
			  jt.setText("");
			  jt2.setText("");
			}
		});
	   jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {//Ҫ�ж������Ƿ�Ϸ�
				// TODO Auto-generated method stu9b
				String s= jt.getText();
				if ((s.matches("\\d+"))||(s.matches("\\d+\\.\\d+"))){
				double n=Double.parseDouble(s);
				n=n*d;
				String ss=new java.text.DecimalFormat("#.000").format(n);//��ֹ���ָ������쳣������1.000005)
				jt2.setText(ss);
			}
				else {
					new alert();
					jt.setText("");
				     }
			}
		});
}
      public static void main(String args[]){
    	 
		 try {
			new device();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
