package org.mtransit.parser.ca_toronto_ttc_bus;

import org.mtransit.parser.DefaultAgencyTools;
import org.mtransit.parser.Utils;

public class TorontoTTCBusAgencyTools extends DefaultAgencyTools {

    @Override
    public void start(String[] args) {
        System.out.printf("Generating TTC bus data...\n");
        long start = System.currentTimeMillis();
        super.start(args);
        System.out.printf("Generating TTC bus data... DONE in %s.\n",
                Utils.getPrettyDuration(System.currentTimeMillis() - start));
    }

    public static void main(String[] args) {
        TorontoTTCBusAgencyTools ttcTools = new TorontoTTCBusAgencyTools();

        args = new String[3];
        args[0] = "input/gtfs.zip";
        args[1] = "output";
        args[2] = "";

        ttcTools.start(args);
    }

}
