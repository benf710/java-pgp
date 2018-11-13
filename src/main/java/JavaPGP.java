import org.apache.commons.cli.*;
import org.bouncycastle.openpgp.examples.KeyBasedLargeFileProcessor;
import java.time.LocalDateTime;

public class JavaPGP {
    public static void main(String[] args) throws Exception {

        Options options = new SystemOptions().getOptions();
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();

        try {
            CommandLine line = parser.parse(options, args);
            String outputFile;
            if (line.hasOption("o")){
                outputFile = line.getOptionValue("o");
            } else {
                outputFile = String.format("JavaPGP-Output-%s.bgp", LocalDateTime.now());
            }
            if (line.hasOption("e")){
                KeyBasedLargeFileProcessor.main(new String[] { "-e", line.getOptionValue("i"), line.getOptionValue("e"), outputFile});
            } else {
                KeyBasedLargeFileProcessor.main(new String[] {"-d", line.getOptionValue("i"), line.getOptionValue("d"), outputFile});
                System.out.println(String.format("Decrypting this input file %s with private-key file %s to this output file %s", line.getOptionValue("i"), line.getOptionValue("d"), outputFile));
            }
        }
        catch (ParseException e){
            formatter.printHelp("java -jar JavaPGP.jar", "Encrypt or decypt PGP files. Default output file is JavaPGP-Output-YYYY-MM-DDTHH-MM-SS.ZZZ", options, "", true);
        }
    }

}
