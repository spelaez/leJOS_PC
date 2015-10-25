package objetos.futbol.UI;

import java.io.*;

import lejos.nxt.comm.*;
import lejos.pc.comm.NXTComm;
import lejos.pc.comm.NXTCommException;
import lejos.pc.comm.NXTCommFactory;
import lejos.pc.comm.NXTInfo;
public class Main {
	public static void main(String [] args) throws NXTCommException, IOException{
		NXTComm nxtComm = NXTCommFactory.createNXTComm(NXTCommFactory.BLUETOOTH);
		NXTInfo nxtInfo = new NXTInfo(NXTCommFactory.BLUETOOTH, "NXT", "00:16:53:00:78:48");
		NXTInfo[] nxtInfoo = nxtComm.search("NXT");
		nxtComm.open(nxtInfoo[0]);
		DataOutputStream Op = (DataOutputStream)nxtComm.getOutputStream();
		Op.writeInt(1);
	}
}
