package org.sonar.java.rule.checks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.sonar.check.Rule;

import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.*;

import com.google.common.collect.ImmutableList;

/**
 * 命名规约
 * 代码中不能出现abc
 */
//@Rule(
//        key = "UnderlineDollarNameCheck",
//        name = "Can't abc",
//        description = "Can't abc",
//        priority = Priority.CRITICAL,
//        tags = {"bug"})
@Rule(key = "MyFirstCustomCheck")
public class MyFirstCustomCheck extends IssuableSubscriptionVisitor {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyFirstCustomCheck.class);
    
    @Override
    public List<Tree.Kind> nodesToVisit() {
        //指定要扫描的节点，在visitNode方法中获取到指定的节点
        return ImmutableList.of(Tree.Kind.METHOD, Tree.Kind.VARIABLE);
    }

    @Override
    public void scanFile(JavaFileScannerContext context) {
        super.scanFile(context);
        visitFile(context.getFile());
    }
    
    
    private void visitFile(File file) {
        // 直接获取当前java文件的所有文本
    	
    	List<String> lines = new ArrayList<String>();;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while((line = reader.readLine()) != null){
                lines.add(line);
            }
            reader.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        
        for (int i = 0; i < lines.size(); i++) {
        	String origLine = (String)lines.get(i);
        	int res = origLine.indexOf("abc");
        	if (res != -1) {
        	 
        		addIssue(i+1, "Can't abc");
            }
//        	else { 
//        		System.out.println(i+1 + "true"); 
//        	}
        }
        
    }
}