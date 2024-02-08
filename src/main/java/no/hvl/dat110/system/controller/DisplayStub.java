package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;

import static no.hvl.dat110.system.controller.Common.READ_RPCID;

public class DisplayStub extends RPCLocalStub {

	public DisplayStub(RPCClient rpcclient)
	{
		super(rpcclient);
	}

	public void write (String message) {

		// TODO - START
		byte[] request = RPCUtils.marshallString(message);

		rpcclient.call((byte)Common.WRITE_RPCID, request);

		//RPCUtils.unmarshallString(request);


		//remove code under after implementing write-method
		/*
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		*/
		// TODO - END

	}
}
