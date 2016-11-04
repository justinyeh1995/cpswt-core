/**
 * * @author Greg Varga <greg@sph3r.com>
 */

package c2w.hla;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import java.io.*;
import java.util.Properties;
import java.util.function.Function;

public class FederationManagerParameter {
    @JsonProperty
    public String FederationName;

    @JsonProperty
    public String FOMFilename;

    @JsonProperty
    public String ScriptFilename;

    @Deprecated
    public String DBName;

    @JsonProperty
    public String LogLevel;

    @JsonProperty
    public boolean RealTimeMode;

    @JsonProperty
    public String LockFilename;

    @JsonProperty
    public double Step;

    @JsonProperty
    public double Lookahead;

    @JsonProperty
    public boolean TerminateOnCOAFinish;

    @JsonProperty
    public double FederationEndTime;

    @JsonProperty
    public long Seed4Dur;

    @JsonProperty
    public boolean AutoStart;

    @FunctionalInterface
    interface Function2<T1, T2, R> {
        R apply(T1 p1, T2 p2);
    }

    static FederationManagerParameter readArgs(Function<String, String> fn, Function2<String, String, String> fnWithDefaultVal) {
        FederationManagerParameter p = new FederationManagerParameter();

        p.FederationName = fn.apply("federationName");
        p.FOMFilename = fn.apply("fomFilename");
        p.ScriptFilename = fn.apply("scriptFilename");
        p.DBName = null; // not using DB anymore
        p.LogLevel = fn.apply("logLevel");
        p.RealTimeMode = Boolean.parseBoolean(fnWithDefaultVal.apply("realtime", "false"));
        p.LockFilename = fn.apply("lockfile");
        p.Step = Double.parseDouble(fn.apply("step"));
        p.Lookahead = Double.parseDouble(fn.apply("lookahead"));
        p.TerminateOnCOAFinish = Boolean.parseBoolean(fnWithDefaultVal.apply("terminateOnCOAFinish", "false"));
        p.FederationEndTime = Double.parseDouble(fnWithDefaultVal.apply("federationEndTime", "-1"));
        p.Seed4Dur = Long.parseLong(fn.apply("seed4DurRNG"));
        p.AutoStart = Boolean.parseBoolean(fn.apply("autoStart"));

        return p;
    }

    public static FederationManagerParameter ParseInputs(final CommandLine line) {
        Function<String, String> fn = new Function<String, String>() {
            public String apply(String s) {
                return line.getOptionValue(s);
            }
        };
        Function2<String, String, String> fnWithDefaultVal = new Function2<String, String, String>() {
            public String apply(String opt, String defaultValue) {
                return line.getOptionValue(opt, defaultValue);
            }
        };

        FederationManagerParameter p = readArgs(fn, fnWithDefaultVal);
        return p;
    }

    public static FederationManagerParameter ParsePropertiesFile(String propertiesFilePath) throws IOException {
        InputStream inputStream = null;
        FederationManagerParameter p = new FederationManagerParameter();

        try {
            final Properties prop = new Properties();
            File propertiesFile = new File(propertiesFilePath);
            inputStream = new FileInputStream(propertiesFile);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("Property file '" + propertiesFilePath + "' not found!");
            }

            Function<String, String> fn = new Function<String, String>() {
                public String apply(String s) {
                    return prop.getProperty(s);
                }
            };
            Function2<String, String, String> fnWithDefaultVal = new Function2<String, String, String>() {
                public String apply(String opt, String defaultValue) {
                    return prop.getProperty(opt, defaultValue);
                }
            };

            p = readArgs(fn, fnWithDefaultVal);
        } finally {
            inputStream.close();
        }
        return p;
    }

    public static Options GetCLIOptions() {
        Options options = new Options();

        options.addOption(Option.builder("s")
                .longOpt("step")
                .argName("step")
                .hasArg()
                .desc("Step size for simulation")
                .required()
                .type(double.class)
                .build()
        );

        options.addOption(Option.builder("a")
                .longOpt("lookahead")
                .argName("lookahead")
                .hasArg()
                .desc("The lookahead value for the simulation")
                .required()
                .type(double.class)
                .build()
        );

        options.addOption(Option.builder("l")
                .longOpt("lockfile")
                .argName("lockfile")
                .hasArg()
                .desc("Path to the lock file")
                .required()
                .type(String.class)
                .build()
        );

        options.addOption(Option.builder("r")
                .longOpt("realtime")
                .argName("realtime")
                .optionalArg(true)
                .desc("Indicates if real-time mode is on")
                .type(boolean.class)
                .build()
        );

        options.addOption(Option.builder("t")
                .longOpt("terminateOnCOAFinish")
                .argName("terminateOnCOAFinish")
                .optionalArg(true)
                .desc("Indicates whether to terminate when COA finishes")
                .type(boolean.class)
                .build()
        );

        options.addOption(Option.builder("e")
                .longOpt("federationEndTime")
                .argName("federationEndTime")
                .hasArg()
                .desc("Federation end time")
                .type(double.class)
                .build()
        );

        options.addOption(Option.builder("g")
                .longOpt("seed4DurRNG")
                .argName("seed4DurRNG")
                .hasArg()
                .desc("seed4DurRNG")
                .type(long.class)
                .build()
        );

        options.addOption(Option.builder("u")
                .longOpt("autoStart")
                .argName("autoStart")
                .optionalArg(true)
                .desc("Indicates if federation should start automatically")
                .type(boolean.class)
                .build()
        );

        options.addOption(Option.builder()
                .longOpt("federationName")
                .argName("federationName")
                .hasArg()
                .desc("The name of the federation")
                .required()
                .type(String.class)
                .build()
        );

        options.addOption(Option.builder()
                .longOpt("fomFilename")
                .argName("fomFilename")
                .hasArg()
                .desc("Path to the FOM filename")
                .required()
                .type(String.class)
                .build()
        );

        options.addOption(Option.builder()
                .longOpt("scriptFilename")
                .argName("scriptFilename")
                .hasArg()
                .desc("Path to the script.xml file")
                .required()
                .type(String.class)
                .build()
        );

        options.addOption(Option.builder()
                .longOpt("logLevel")
                .argName("logLevel")
                .hasArg()
                .desc("Log level")
                .required()
                .type(String.class)
                .build()
        );

        return options;
    }
}
