import org.apache.commons.cli.*;

class SystemOptions {

    private Options options = new Options();

    SystemOptions(){
        OptionGroup action = new OptionGroup();
        action.addOption(Option.builder("e").desc("encrypt").hasArg(true).argName("public_key_file").build());
        action.addOption(Option.builder("d").desc("decrypt").hasArg(true).argName("private_key_file").build());
        action.setRequired(true);

        options.addOptionGroup(action);
        options.addOption(Option.builder("i").desc("input file").hasArg(true).argName("input_file").required(true).build());
        options.addOption(Option.builder("o").desc("output file").hasArg(true).argName("output_file").required(false).build());
    }

    Options getOptions(){
        return options;
    }

}
