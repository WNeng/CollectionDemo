package com.collection.demo.backup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CopyFileUtil {
	/*
	 * 编写一个程序,将指定目录下所有.java文件拷贝到另一个目录中，
		并将扩展名改为.txt
	 */
	public static void main(String[] args) throws IOException {
		File src = getDir();
		File dest = getDir();
		copy(src, dest);

		String srcPath = "/Users/wneng/IdeaProjects/collection_cloud_admin/grails-app/component";
	}

	public static void copy(File src, File dest) throws IOException {
		File newDir = new File(dest, src.getName());
		newDir.mkdir();
		File[] subFiles = src.listFiles();
		for (File subFile : subFiles) {
			if (subFile.isFile()) {
				if (subFile.getName().endsWith(".java") || subFile.getName().endsWith(".groovy")) {
					File newFile = new File(subFile, subFile.getName().replace(
							subFile.getName().endsWith(".java") ?".java" : ".groovy", ".txt"));

					// 用BufferedInputStream和BufferedOutputStream也可以
					BufferedReader br = new BufferedReader(new FileReader(subFile));
					BufferedWriter bw = new BufferedWriter(new FileWriter(new File(newDir, newFile.getName())));
					String line;
					while ((line = br.readLine()) != null) {
						bw.write(line);
						bw.flush();
						bw.newLine();
					}
					br.close();
					bw.close();
				}
			} else {
				copy(subFile, newDir);
			}

		}
	}

	public static File getDir() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入文件夹路径：");
		while (true) {
			String line = sc.nextLine();
			File file = new File(line);
			if (!file.exists()) {
				System.out.println("您输入的文件夹路径不存在，请重新输入!");
			} else if (file.isFile()) {
				System.out.println("您输入的是一个文件路径，请重新输入!");
			} else {
				return file;
			}
			sc.close();
		}
	}
}

