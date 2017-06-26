package net.minecraft.afyaan.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.List;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

import org.lwjgl.Sys;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class FriendsUtils {
	public static String line = "";
	public static PrintWriter writer;
	public static ArrayList<FriendUser> friendsList = new ArrayList<FriendUser>();
	
	public static void CreateFile(){
		try{
			//writer = new PrintWriter("friends.txt", "UTF-8");
		}catch(Exception ex) {}
	}
	
	public static void DeleteFriend(String friendname){
		try{
			BufferedReader br = new BufferedReader(new FileReader("friends.txt"));   
		    String line = "";
		    while ((line = br.readLine()) != null) {
		    	Path path = Paths.get("friends.txt");
		    	Charset charset = StandardCharsets.UTF_8;

		    	String content = new String(Files.readAllBytes(path), charset);
		    	if(line.equals(System.getProperty("line.separator") + friendname)){
		    		content = content.replaceFirst(System.getProperty("line.separator") + friendname, "");
		    	}else{
		    		content = content.replaceFirst(friendname + System.getProperty("line.separator"), "");
		    		if(line.equals(friendname)){
		    			content = content.replaceFirst(friendname, "");
		    		}
		    	}
		    	Files.write(path, content.getBytes(charset));
		    }
			
			
			
		}catch(Exception ex){}
	}
	
	public static void Update(){
		friendsList.clear();
		try {
			if(new File("friends.txt").exists() != true){
				return;
			}
			
			BufferedReader br = new BufferedReader(new FileReader("friends.txt"));
		    
		    String line = "";
		    while ((line = br.readLine()) != null) {
		    	for(String s : line.split("\\r\\n|\\n|\\r")){
		    		for(int i = 0; i < friendsList.size(); i++){
		    			
		    			if(s.equalsIgnoreCase(friendsList.get(i).nick)){
		    				return;
		    			}
		    		}
					friendsList.add(new FriendUser(s));
					System.out.println("DODANO + " + s);
				}
		    }
			
			
			System.out.println(line.split("[\\r\\n]+").length);
		} catch (Exception e) 
		{
			//System.out.println(e);
		}
	}
	
	public static void addFriend(String nick)
	{
		for(int i = 0; i < friendsList.size(); i++){
			
			if(nick.equalsIgnoreCase(friendsList.get(i).nick)){
				//friendsList.remove(i);
				DeleteFriend(friendsList.get(i).nick);
				//System.out.println("USUNIETO + " + friendsList.get(i).nick);
				Update();
				return;
			}
		}
		
		try {
			
			Writer output;
			output = new BufferedWriter(new FileWriter("friends.txt", true));
			Reader reader = new FileReader("friends.txt");
			int readSize = reader.read();
			if (readSize == -1)
				output.append(nick);
			else
				output.append(System.getProperty("line.separator") + nick);
			
			output.close();
		} catch (IOException e) {}  
		
		friendsList.add(new FriendUser(nick));
		//Update();
		//CreateFile();
		//writer.println(nick);
		//writer.close();
	}
}
