package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static int MESSAGINGPORT = 8080;
	public static String MESSAGINGHOST = "localhost";

	public static byte[] encapsulate(Message message) {
		
		byte[] segment = null;
		byte[] data;

		// TODO - START
		
		// encapulate/encode the payload data of the message and form a segment
		// according to the segment format for the messaging layer
		data = message.getData();

		if(data!=null && data.length <= SEGMENTSIZE){
			segment = new byte[SEGMENTSIZE];
			// Store the length of the message data at the first index of the segment
			segment[0] = (byte) data.length;
			// Copy the message data into the segment
			for (int i = 1; i <= data.length; i++) {
				segment[i] = data[i-1];
			}
		} else{
			throw new IllegalArgumentException("Data is too large to encapsulate.");
		}

		/* Done
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		*/
		// TODO - END
		return segment;
		
	}

	public static Message decapsulate(byte[] segment) {

		Message message = null;
		
		// TODO - START
		// decapsulate segment and put received payload data into a message
		if(segment != null && segment.length == SEGMENTSIZE){
			int length = segment[0];
			byte[] data = new byte[length];
			for (int i = 1; i < length + 1; i++) {
				data[i-1] = segment[i];
			}
			message = new Message(data);
		} else {
			throw new IllegalArgumentException("Illegal segment for decapsulation.");
		}

		/* done
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		*/
		// TODO - END
		
		return message;
		
	}
	
}
