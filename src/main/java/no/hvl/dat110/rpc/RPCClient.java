package no.hvl.dat110.rpc;

import no.hvl.dat110.TODO;
import no.hvl.dat110.messaging.*;

import java.io.IOException;
import java.net.UnknownHostException;

public class RPCClient {

	// underlying messaging client used for RPC communication
	private MessagingClient msgclient;

	// underlying messaging connection used for RPC communication
	private MessageConnection connection;
	
	public RPCClient(String server, int port) {
	
		msgclient = new MessagingClient(server,port);
	}
	
	public void connect() { //throws UnknownHostException, IOException
		
		// TODO - START
		// connect using the RPC client
		connection = msgclient.connect();

		/* done
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		*/
		// TODO - END
	}
	
	public void disconnect() {
		
		// TODO - START
		// disconnect by closing the underlying messaging connection
		connection.close();

		/* done
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		*/
		// TODO - END
	}

	/*
	 Make a remote call om the method on the RPC server by sending an RPC request message and receive an RPC reply message

	 rpcid is the identifier on the server side of the method to be called
	 param is the marshalled parameter of the method to be called
	 */

	public byte[] call(byte rpcid, byte[] param) {
		
		byte[] returnval = null;
		
		// TODO - START

		/*

		The rpcid and param must be encapsulated according to the RPC message format

		The return value from the RPC call must be decapsulated according to the RPC message format

		*/
		connection.send(new Message(RPCUtils.encapsulate(rpcid, param)));
		returnval = RPCUtils.decapsulate(connection.receive().getData());

//		try {
//			connection.send(new Message(RPCUtils.encapsulate(rpcid, param)));
//			returnval = RPCUtils.decapsulate(connection.receive().getData());
//		} catch (IOException ex) {
//			System.out.println("Error at call: " + ex);
//			ex.printStackTrace();
//		}

		/* done
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		*/
		// TODO - END
		return returnval;
		
	}

}
