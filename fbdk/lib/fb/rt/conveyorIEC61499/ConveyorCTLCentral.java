/* Copyright (c)2020 Rockwell Automation. All rights reserved. */
package fb.rt.conveyorIEC61499;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK ConveyorCTLCentral
  * @author JHC
  * @version 20201025/JHC
  */
public class ConveyorCTLCentral extends FBInstance
{
/** Input event qualifier */
  public BOOL PE = new BOOL();
/** VAR Block */
  public BOOL Block = new BOOL();
/** VAR Candidate */
  public BOOL Candidate = new BOOL();
/** VAR PE_EXIT */
  public BOOL PE_EXIT = new BOOL();
/** Output event qualifier */
  public BOOL MotoRotate = new BOOL();
/** VAR BlockCon */
  public BOOL BlockCon = new BOOL();
/** VAR lastPE */
  public BOOL lastPE = new BOOL();
/** VAR lastBlock */
  public BOOL lastBlock = new BOOL();
/** Initialization Request */
 public EventServer INIT = new EventInput(this);
/** Normal Execution Request */
 public EventServer REQ = new EventInput(this);
/** EVENT CAS_STOP */
 public EventServer CAS_STOP = new EventInput(this);
/** EVENT CAS_START */
 public EventServer CAS_START = new EventInput(this);
/** EVENT TokenGranted */
 public EventServer TokenGranted = new EventInput(this);
/** Initialization Confirm */
 public EventOutput INITO = new EventOutput();
/** Execution Confirmation */
 public EventOutput CNF = new EventOutput();
/** EVENT STOP */
 public EventOutput STOP = new EventOutput();
/** EVENT START */
 public EventOutput START = new EventOutput();
/** EVENT RequestToken */
 public EventOutput RequestToken = new EventOutput();
/** EVENT ReleaseToken */
 public EventOutput ReleaseToken = new EventOutput();
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventServer eiNamed(String s){
    if("INIT".equals(s)) return INIT;
    if("REQ".equals(s)) return REQ;
    if("CAS_STOP".equals(s)) return CAS_STOP;
    if("CAS_START".equals(s)) return CAS_START;
    if("TokenGranted".equals(s)) return TokenGranted;
    return super.eiNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventOutput eoNamed(String s){
    if("INITO".equals(s)) return INITO;
    if("CNF".equals(s)) return CNF;
    if("STOP".equals(s)) return STOP;
    if("START".equals(s)) return START;
    if("RequestToken".equals(s)) return RequestToken;
    if("ReleaseToken".equals(s)) return ReleaseToken;
    return super.eoNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
* @throws FBRManagementException {@inheritDoc}
*/
  public ANY ivNamed(String s) throws FBRManagementException{
    if("PE".equals(s)) return PE;
    if("Block".equals(s)) return Block;
    if("Candidate".equals(s)) return Candidate;
    if("PE_EXIT".equals(s)) return PE_EXIT;
    return super.ivNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
* @throws FBRManagementException {@inheritDoc}
*/
  public ANY ovNamed(String s) throws FBRManagementException{
    if("MotoRotate".equals(s)) return MotoRotate;
    if("BlockCon".equals(s)) return BlockCon;
    return super.ovNamed(s);}
/** {@inheritDoc}
* @param ivName {@inheritDoc}
* @param newIV {@inheritDoc}
* @throws FBRManagementException {@inheritDoc} */
  public void connectIV(String ivName, ANY newIV)
    throws FBRManagementException{
    if("PE".equals(ivName)) connect_PE((BOOL)newIV);
    else if("Block".equals(ivName)) connect_Block((BOOL)newIV);
    else if("Candidate".equals(ivName)) connect_Candidate((BOOL)newIV);
    else if("PE_EXIT".equals(ivName)) connect_PE_EXIT((BOOL)newIV);
    else super.connectIV(ivName, newIV);
    }
/** Connect the given variable to the input variable PE
  * @param newIV The variable to connect
 */
  public void connect_PE(BOOL newIV){
    PE = newIV;
    }
/** Connect the given variable to the input variable Block
  * @param newIV The variable to connect
 */
  public void connect_Block(BOOL newIV){
    Block = newIV;
    }
/** Connect the given variable to the input variable Candidate
  * @param newIV The variable to connect
 */
  public void connect_Candidate(BOOL newIV){
    Candidate = newIV;
    }
/** Connect the given variable to the input variable PE_EXIT
  * @param newIV The variable to connect
 */
  public void connect_PE_EXIT(BOOL newIV){
    PE_EXIT = newIV;
    }
private static final int index_IDLE = 0;
private void state_IDLE(){
  eccState = index_IDLE;
  alg_START();
  START.serviceEvent(this);
  CNF.serviceEvent(this);
}
private static final int index_INIT = 1;
private void state_INIT(){
  eccState = index_INIT;
  alg_INIT();
  INITO.serviceEvent(this);
  CNF.serviceEvent(this);
state_IDLE();
}
private static final int index_WANT = 2;
private void state_WANT(){
  eccState = index_WANT;
  alg_STOP();
  STOP.serviceEvent(this);
  CNF.serviceEvent(this);
  RequestToken.serviceEvent(this);
  alg_WANT_TEST();
}
private static final int index_RECEIVED = 3;
private void state_RECEIVED(){
  eccState = index_RECEIVED;
  alg_START();
  START.serviceEvent(this);
  CNF.serviceEvent(this);
  alg_RECEIVED_TEST();
}
private static final int index_WAIT_NEXT = 4;
private void state_WAIT_NEXT(){
  eccState = index_WAIT_NEXT;
  alg_STOP();
  STOP.serviceEvent(this);
  CNF.serviceEvent(this);
}
private static final int index_DEPARTED_CURRENT = 5;
private void state_DEPARTED_CURRENT(){
  eccState = index_DEPARTED_CURRENT;
}
private static final int index_RELEASE = 6;
private void state_RELEASE(){
  eccState = index_RELEASE;
}
private static final int index_RELEASE_AND_WANT = 7;
private void state_RELEASE_AND_WANT(){
  eccState = index_RELEASE_AND_WANT;
  alg_STOP();
  STOP.serviceEvent(this);
  CNF.serviceEvent(this);
}
private static final int index_DELAY_WANT = 8;
private void state_DELAY_WANT(){
  eccState = index_DELAY_WANT;
state_WANT();
}
private static final int index_DELAY_RELEASE = 9;
private void state_DELAY_RELEASE(){
  eccState = index_DELAY_RELEASE;
  ReleaseToken.serviceEvent(this);
state_IDLE();
}
private static final int index_DELAY_RELEASE_AND_WANT = 10;
private void state_DELAY_RELEASE_AND_WANT(){
  eccState = index_DELAY_RELEASE_AND_WANT;
  ReleaseToken.serviceEvent(this);
state_WANT();
}
/** The default constructor. */
public ConveyorCTLCentral(){
    super();
    lastPE.initializeNoException("1");
    lastBlock.initializeNoException("0");
  }
/** {@inheritDoc}
* @param e {@inheritDoc} */
  public void serviceEvent(EventServer e){
    if (e == INIT) service_INIT();
    else if (e == REQ) service_REQ();
    else if (e == CAS_STOP) service_CAS_STOP();
    else if (e == CAS_START) service_CAS_START();
    else if (e == TokenGranted) service_TokenGranted();
  }
/** Services the INIT event. */
  public void service_INIT(){
    if ((eccState == index_IDLE)) state_INIT();
  }
/** Services the REQ event. */
  public void service_REQ(){
    if ((eccState == index_RECEIVED) && (PE.value)) state_DEPARTED_CURRENT();
    else if ((eccState == index_DEPARTED_CURRENT) && (!PE.value)) state_WAIT_NEXT();
    else if ((eccState == index_WAIT_NEXT) && (!PE_EXIT.value)) state_RELEASE_AND_WANT();
    else if ((eccState == index_DEPARTED_CURRENT) && (!PE_EXIT.value)) state_RELEASE();
    else if ((eccState == index_IDLE) && (!PE.value)) state_DELAY_WANT();
    else if ((eccState == index_RELEASE) && (PE_EXIT.value)) state_DELAY_RELEASE();
    else if ((eccState == index_RELEASE_AND_WANT) && (PE_EXIT.value)) state_DELAY_RELEASE_AND_WANT();
    else if ((eccState == index_RELEASE) && (!PE.value)) state_RELEASE_AND_WANT();
  }
/** Services the CAS_STOP event. */
  public void service_CAS_STOP(){
  }
/** Services the CAS_START event. */
  public void service_CAS_START(){
  }
/** Services the TokenGranted event. */
  public void service_TokenGranted(){
    if ((eccState == index_WANT)) state_RECEIVED();
  }
  /** ALGORITHM INIT IN ST*/
public void alg_INIT(){
MotoRotate.value=true;
Block.value=false;

System.out.println(this+" "+MotoRotate.value);
System.out.println(MotoRotate.value);
}
  /** ALGORITHM REQ IN ST*/
public void alg_REQ(){
System.out.println(this+" -> Candidate"+Candidate.value);
if(Candidate.value){
if(lastPE.value!=PE.value){
if(!PE.value){
BlockCon.value=true;
System.out.println("BlockCon = true");
}
else{
BlockCon.value=false;
System.out.println("BlockCon = false");
}
lastPE.value=PE.value;
}
if(lastBlock.value!=Block.value){
if(Block.value){
STOP.serviceEvent(this);
MotoRotate.value=false;
System.out.println("Cas Stop");
}
else{
START.serviceEvent(this);
MotoRotate.value=true;
System.out.println("Cas Start");
}
lastBlock.value=Block.value;
}
}
}
  /** ALGORITHM START IN ST*/
public void alg_START(){
MotoRotate.value=true;
System.out.println(this+" Start "+MotoRotate.value);

System.out.println("Start "+MotoRotate.value);
}
  /** ALGORITHM STOP IN ST*/
public void alg_STOP(){
MotoRotate.value=false;
System.out.println(this+" Stop "+MotoRotate.value);

System.out.println("Stop "+MotoRotate.value);
}
  /** ALGORITHM WANT_TEST IN Java*/
public void alg_WANT_TEST(){
System.out.println("IN WANTTTTTTTTTTTTTTTTTTTTTTTTTTT");

}
  /** ALGORITHM RECEIVED_TEST IN Java*/
public void alg_RECEIVED_TEST(){
System.out.println("RECEIVEDDDDD");

}
}
