package com.techMahindraCodingAssignment.Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ObjectRepositoryReader {
	static FileInputStream objfile;
	
	public ObjectRepositoryReader(FileInputStream objfile) {
		
	}

	public String objectReading(String filePath, String objects) {
		Properties obj = new Properties();
		try {
			objfile = new FileInputStream(System.getProperty("user.dir") + filePath);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			obj.load(objfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		objects = obj.getProperty(objects);
		return objects;
	}
}
