package com.company;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
        DataOutputStream dout = null;
        DataInputStream din = null;
        DataOutputStream dout2 = null;
        DataInputStream din2 = null;
        try{
            File f1 = new File("C:\\lab7\\inp.txt");
            if(f1.exists()) f1.delete();
            f1.createNewFile();
            dout = new DataOutputStream(new FileOutputStream(f1));
            System.out.println("count");
            int count = sc.nextInt();
            for (int i=0; i<count; i++) {
                double d = sc.nextDouble();
                dout.writeDouble(d);
            }
            din = new DataInputStream(new FileInputStream(f1));

         /*   while(true){
                double readD = din.readDouble();
                System.out.println(readD);
            } */

            File f2 = new File("C:\\lab7\\out.txt");
            if (f2.exists()) f2.delete();
            f2.createNewFile();
            dout2 = new DataOutputStream(new FileOutputStream(f2));
            double[] arr = new double[count];
            for (int i =0; i<count; i++){
                double readD = din.readDouble();
                arr[i] = readD;
                if (readD>0) {
                    dout2.writeDouble(readD);
                }
            }
            double max = -1;
            for (int i = 0; i<arr.length; i++){
                if (arr[i]>max){
                    max=arr[i];
                }
            }
            dout2.writeDouble(max);
            din2 = new DataInputStream(new FileInputStream(f2));
            while (true){
                double readD = din.readDouble();
                System.out.println(readD);
            }

        }
        catch (EOFException eof) {

        }
        catch (IOException io) {
            io.printStackTrace();
        }
        finally {
            dout.flush();
            dout.close();
        }
    }
}
