package seedu.address;

import static org.apache.commons.io.FileUtils.writeStringToFile;

public class TemplateClass {
    public static void instrum(String... args) {
        String finalStr = "";
        int count = 0;
        for(int i =0 ; i < args.length ; i++){
            count++;
            if (count == 2){
                if ( i == (args.length - 1)){
                    finalStr = finalStr + args[i];
                }
                else{
                    finalStr = finalStr + args[i] + ", ";
                    count =0;
                }

            }
            else if (count == 1){
                finalStr = finalStr + args[i];
            }
        }
        try{
            writeStringToFile((MainApp.file), finalStr + "\n",true);
            System.out.println (finalStr);
        }
        catch (Exception e){}
    }
}
