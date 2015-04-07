package org.mtransit.parser.ca_toronto_ttc_bus;

import org.mtransit.parser.DefaultAgencyTools;
import org.mtransit.parser.Utils;
import org.mtransit.parser.gtfs.data.GRoute;
import org.mtransit.parser.gtfs.data.GTrip;
import org.mtransit.parser.mt.data.MAgency;
import org.mtransit.parser.mt.data.MRoute;
import org.mtransit.parser.mt.data.MTrip;

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

    @Override
    public boolean excludeRoute(GRoute gRoute) {
        if (gRoute == null)
            return true;
        return false;
    }

    @Override
    public Integer getAgencyRouteType() {
        return MAgency.ROUTE_TYPE_BUS;
    }

    @Override
    public void setTripHeadsign(MRoute mRoute, MTrip mTrip, GTrip gTrip) {
        if (gTrip.direction_id < 0 || gTrip.direction_id > 1) {
            System.out
                    .println("ERROR: default agency implementation required 'direction_id' field in 'trips.txt'!");
            System.exit(-1);
        }
        try {
            mTrip.setHeadsignString(gTrip.service_id + "-"
                    + gTrip.trip_headsign, gTrip.direction_id);
        } catch (NumberFormatException nfe) {
            System.out
                    .println("ERROR: default agency implementation required integer 'direction_id' field in 'trips.txt'!");
            System.exit(-1);
        }
    }
}
