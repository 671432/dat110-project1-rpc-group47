package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.util.Arrays;
import no.hvl.dat110.TODO;

public class RPCUtils {
	
	public static byte[] encapsulate(byte rpcid, byte[] payload) {
		
		byte[] rpcmsg = null;
		
		// TODO - START
		// Encapsulate the rpcid and payload in a byte array according to the RPC message syntax / format
		rpcmsg = new byte[payload.length + 1];
		rpcmsg[0] = rpcid;
		for (int i = 0; i < rpcmsg.length-1; i++){
			rpcmsg[i+1] = payload[i];
		}

		/* done
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		*/
		// TODO - END
		
		return rpcmsg;
	}
	
	public static byte[] decapsulate(byte[] rpcmsg) {
		
		byte[] payload = null;
		
		// TODO - START
		// Decapsulate the rpcid and payload in a byte array according to the RPC message syntax
		payload = new byte[rpcmsg.length - 1];
		for (int i = 0; i < rpcmsg.length - 1; i++) {
			payload[i] = rpcmsg[i + 1];
		}
		/* done
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		*/
		// TODO - END
		
		return payload;
		
	}

	// convert String to byte array
	public static byte[] marshallString(String str) {
		
		byte[] encoded = null;
		
		// TODO - START
		encoded = str.getBytes();

		/* done
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		*/
		// TODO - END
		
		return encoded;
	}

	// convert byte array to a String
	public static String unmarshallString(byte[] data) {
		
		String decoded = null; 
		
		// TODO - START 
		decoded = "";
		char[] results = new char[data.length];
		for(int i = 0; i<data.length; i++) {
			results[i] = (char) data[i];
			decoded += results[i];
		}
		decoded = new String(data);

		/* done
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		*/
		// TODO - END
		
		return decoded;
	}
	
	public static byte[] marshallVoid() {
		
		byte[] encoded = null;
		
		// TODO - START 
		encoded = new byte[0];

		/* done
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		*/
		// TODO - END
		
		return encoded;
		
	}
	
	public static void unmarshallVoid(byte[] data) {
		
		// TODO
		/* done
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		*/
	}

	// convert boolean to a byte array representation
	public static byte[] marshallBoolean(boolean b) {
		
		byte[] encoded = new byte[1];
				
		if (b) {
			encoded[0] = 1;
		} else
		{
			encoded[0] = 0;
		}
		
		return encoded;
	}

	// convert byte array to a boolean representation
	public static boolean unmarshallBoolean(byte[] data) {
		
		return (data[0] > 0);
		
	}

	// integer to byte array representation
	public static byte[] marshallInteger(int x) {
		
		byte[] encoded = null;
		
		// TODO - START
		ByteBuffer bb = ByteBuffer.allocate(4);
		bb.putInt(x);
		encoded = bb.array();

		/* done
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		*/
		// TODO - END
		
		return encoded;
	}
	
	// byte array representation to integer
	public static int unmarshallInteger(byte[] data) {
		
		int decoded = 0;
		
		// TODO - START 
		decoded = ByteBuffer.wrap(data).getInt();

		/* done
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		*/
		// TODO - END
		
		return decoded;
		
	}
}
