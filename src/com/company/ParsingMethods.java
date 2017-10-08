package com.company;

import org.eclipse.jdt.core.dom.*;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class ParsingMethods {

    public static void parse(String str) {
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource(str.toCharArray());
        parser.setKind(ASTParser.K_COMPILATION_UNIT);
        PrintWriter writer= null;
        try {
            writer = new PrintWriter(new File("text.txt"));
            final CompilationUnit cu = (CompilationUnit) parser.createAST(null);

            PrintWriter finalWriter = writer;
            cu.accept(new ASTVisitor() {
                Set names = new HashSet();

                public boolean visit(VariableDeclarationFragment node) {
                    SimpleName name = node.getName();
                    this.names.add(name.getIdentifier());
                    System.out.println("Declaration of '" + name + "' at line"
                            + cu.getLineNumber(name.getStartPosition()));
                    finalWriter.println("Declaration of '" + name + "' at line"
                            + cu.getLineNumber(name.getStartPosition()));
                    return false; // do not continue
                }

                public boolean visit(SimpleName node) {
                    if (this.names.contains(node.getIdentifier())) {
                        System.out.println("Usage of '" + node + "' at line "
                                + cu.getLineNumber(node.getStartPosition()));
                    }
                    return true;
                }
                });
           } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.close();
    }

    //read file content into a string
    public static String readFileToString(String filePath) throws IOException {
        StringBuilder fileData = new StringBuilder(1000);
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        char[] buf = new char[10];
        int numRead = 0;
        while ((numRead = reader.read(buf)) != -1) {
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
            buf = new char[1024];
        }
        reader.close();
        return  fileData.toString();
    }


    public static void ParseFilesInDir() throws IOException{
        File dirs = new File(".");
        String dirPath = dirs.getCanonicalPath() + File.separator+"src"+File.separator;

        File root = new File(dirPath);
        File[] files = root.listFiles ( );
        String filePath = null;

        for (File f : files ) {
            filePath = f.getAbsolutePath();
            if(f.isFile()){
                parse(readFileToString(filePath));

            }
        }
    }

}
