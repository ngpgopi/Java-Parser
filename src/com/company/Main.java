package com.company;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {

        ParsingMethods pass= new ParsingMethods();
        

        try {

           pass.ParseFilesInDir();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
