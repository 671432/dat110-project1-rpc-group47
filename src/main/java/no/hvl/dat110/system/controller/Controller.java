package no.hvl.dat110.system.controller;

import no.hvl.dat110.rpc.*;

public class Controller {

	private static int N = 5; // Number of readings to perform

	public static void main(String[] args) {

		DisplayStub display;
		SensorStub sensor;

		RPCClient displayClient, sensorClient;

		System.out.println("Controller starting ...");

		// Create RPC clients for the display and sensor
		displayClient = new RPCClient(Common.DISPLAYHOST, Common.DISPLAYPORT);
		sensorClient = new RPCClient(Common.SENSORHOST, Common.SENSORPORT);

		// Set up stop methods in the RPC middleware
		RPCClientStopStub stopDisplay = new RPCClientStopStub(displayClient);
		RPCClientStopStub stopSensor = new RPCClientStopStub(sensorClient);

		// TODO - START

		display = new DisplayStub(displayClient);
		sensor = new SensorStub(sensorClient);

		displayClient.connect();
		sensorClient.connect();


		for (int i = 0; i < N; i++) {
//			int temp = sensor.read();
//			display.write(String.valueOf(temp)); // Write temperature to the display
			display.write(" Temperatur: " + sensor.read());
			// Code under for sleeping if necessary

			/*
			try {
				Thread.sleep(1000); // Sleep for 1 second
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			 */

		}

		// TODO - END

		// Stop the display and sensor RPC servers
		stopDisplay.stop();
		stopSensor.stop();

		// Disconnect the RPC clients
		displayClient.disconnect();
		sensorClient.disconnect();

		System.out.println("Controller stopping ...");
	}
}
