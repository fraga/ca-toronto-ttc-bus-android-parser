package org.mtransit.parser.ca_toronto_ttc_bus;

import org.mtransit.parser.DefaultAgencyTools;

public class TorontoTTCBusAgencyTools extends DefaultAgencyTools {

    public static void main(String[] args) {
        TorontoTTCBusAgencyTools ttcTools = new TorontoTTCBusAgencyTools();

        args = new String[3];
        args[0] = "input/gtfs.zip";
        args[1] = "output";
        args[2] = "";

        ttcTools.start(args);
    }

}
