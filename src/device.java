import java.awt.*;
import javax.script.*; 
import org.python.util.PythonInterpreter;  //引入jython
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
			setTitle("警告");
			setLayout(null);
			setBounds(400,300,250,200);
			Container container=getContentPane();
			JLabel jl= new JLabel("拜托请输入正确的兑换金额");
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
	   setTitle("汇率兑换器");
	   setLayout(null);
	   setBounds(200,200,500,550);//第一个为窗口左上点的横坐标，第二个为窗口左上点的纵坐标，第三个为窗口横向大小，第四个为纵向窗口
	   Container container=getContentPane();
	   JLabel jl= new JLabel("兑换金额(美元)");
	   jl.setBounds(50,150,200,100);//相对于窗口
	   container.add(jl);
	   JLabel jl2=new JLabel("兑换金额(人民币)");
	   jl2.setBounds(45,250,200,100);
	   container.add(jl2);
	   JTextField jt=new JTextField("");
	   jt.setBounds(175,170,200,50);
	   container.add(jt);
	   JTextField jt2=new JTextField("");
	   jt2.setBounds(175,275,200,50);
	   container.add(jt2);
	   JButton jb=new JButton("重置");
	   jb.setBounds(100,400,100,50);
	   container.add(jb);
	   JButton jb2=new JButton("兑换");
	   jb2.setBounds(250,400,100,50);
	   container.add(jb2);
	   FileReader fin = new FileReader("E:\\1.txt");//读入文件
	   BufferedReader bin = new BufferedReader(fin);
	   String str=bin.readLine();//读入
	   bin.close();//关闭文件
	   if (str.isEmpty()){
		   System.out.println("没有联网\n");
	   }
	   d=Double.valueOf(str);
	   d=d/100;
	   JLabel jl3=new JLabel("当前汇率(每百美元)为:");
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
			public void actionPerformed(ActionEvent arg0) {//要判断输入是否合法
				// TODO Auto-generated method stu9b
				String s= jt.getText();
				if ((s.matches("\\d+"))||(s.matches("\\d+\\.\\d+"))){
				double n=Double.parseDouble(s);
				n=n*d;
				String ss=new java.text.DecimalFormat("#.000").format(n);//防止出现浮点数异常（比如1.000005)
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
