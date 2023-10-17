package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 3000);

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            System.out.println("Connessione Effettuata");

            String num = "";

            do {

                System.out.println("Inserisci il numero:");
                String n = scanner.nextLine();
                out.writeBytes( n + "\n");
                num = in.readLine();

                if(num.equals("1")){
                    System.out.println("Numero troppo piccolo\n");
                } 
                
                else if(num.equals("2"))
                    System.out.println("Numero troppo grande\n");

            }while(!num.equals("3"));

            System.out.println("HAI INDOVINATO IN " + in.readLine() + " TENTATIVI");

            scanner.close();
            s.close();
        } catch (Exception e) {
            System.out.println("Qualcosa è andato storto");
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}