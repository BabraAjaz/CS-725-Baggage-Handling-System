/* Copyright (c)2020 Rockwell Automation. All rights reserved. */
package fb.rt.cs725;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK ConveyorCTLMulticast
  * @author JHC
  * @version 20201027/JHC
  */
public class ConveyorCTLMulticast extends FBInstance
{
/** Input event qualifier */
  public BOOL PE = new BOOL();
/** VAR Block */
  public BOOL Block = new BOOL();
/** VAR Candidate */
  public BOOL Candidate = new BOOL();
/** VAR PE_14 */
  public BOOL PE_14 = new BOOL();
/** VAR Multi_ID */
  public INT Multi_ID = new INT();
/** VAR Multi_Time_In */
  public INT Multi_Time_In = new INT();
/** VAR Access_Req */
  public BOOL Access_Req = new BOOL();
/** Output event qualifier */
  public BOOL MotoRotate = new BOOL();
/** VAR BlockCon */
  public BOOL BlockCon = new BOOL();
/** VAR Multi_ID_Out */
  public INT Multi_ID_Out = new INT();
/** VAR Multi_Time_Out */
  public INT Multi_Time_Out = new INT();
/** VAR Access_Req_Out */
  public BOOL Access_Req_Out = new BOOL();
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
/** EVENT MULTI_IN */
 public EventServer MULTI_IN = new EventInput(this);
/** Initialization Confirm */
 public EventOutput INITO = new EventOutput();
/** Execution Confirmation */
 public EventOutput CNF = new EventOutput();
/** EVENT STOP */
 public EventOutput STOP = new EventOutput();
/** EVENT START */
 public EventOutput START = new EventOutput();
/** EVENT MULTI_OUT */
 public EventOutput MULTI_OUT = new EventOutput();
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventServer eiNamed(String s){
    if("INIT".equals(s)) return INIT;
    if("REQ".equals(s)) return REQ;
    if("CAS_STOP".equals(s)) return CAS_STOP;
    if("CAS_START".equals(s)) return CAS_START;
    if("MULTI_IN".equals(s)) return MULTI_IN;
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
    if("MULTI_OUT".equals(s)) return MULTI_OUT;
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
    if("PE_14".equals(s)) return PE_14;
    if("Multi_ID".equals(s)) return Multi_ID;
    if("Multi_Time_In".equals(s)) return Multi_Time_In;
    if("Access_Req".equals(s)) return Access_Req;
    return super.ivNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
* @throws FBRManagementException {@inheritDoc}
*/
  public ANY ovNamed(String s) throws FBRManagementException{
    if("MotoRotate".equals(s)) return MotoRotate;
    if("BlockCon".equals(s)) return BlockCon;
    if("Multi_ID_Out".equals(s)) return Multi_ID_Out;
    if("Multi_Time_Out".equals(s)) return Multi_Time_Out;
    if("Access_Req_Out".equals(s)) return Access_Req_Out;
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
    else if("PE_14".equals(ivName)) connect_PE_14((BOOL)newIV);
    else if("Multi_ID".equals(ivName)) connect_Multi_ID((INT)newIV);
    else if("Multi_Time_In".equals(ivName)) connect_Multi_Time_In((INT)newIV);
    else if("Access_Req".equals(ivName)) connect_Access_Req((BOOL)newIV);
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
/** Connect the given variable to the input variable PE_14
  * @param newIV The variable to connect
 */
  public void connect_PE_14(BOOL newIV){
    PE_14 = newIV;
    }
/** Connect the given variable to the input variable Multi_ID
  * @param newIV The variable to connect
 */
  public void connect_Multi_ID(INT newIV){
    Multi_ID = newIV;
    }
/** Connect the given variable to the input variable Multi_Time_In
  * @param newIV The variable to connect
 */
  public void connect_Multi_Time_In(INT newIV){
    Multi_Time_In = newIV;
    }
/** Connect the given variable to the input variable Access_Req
  * @param newIV The variable to connect
 */
  public void connect_Access_Req(BOOL newIV){
    Access_Req = newIV;
    }
private static final int index_START = 0;
private void state_START(){
  eccState = index_START;
}
private static final int index_INIT = 1;
private void state_INIT(){
  eccState = index_INIT;
  alg_INIT();
  INITO.serviceEvent(this);
  CNF.serviceEvent(this);
state_RELEASE();
}
private static final int index_RELEASE = 2;
private void state_RELEASE(){
  eccState = index_RELEASE;
  alg_START();
  START.serviceEvent(this);
  CNF.serviceEvent(this);
  alg_PRINT_RELEASED();
}
private static final int index_WANT = 3;
private void state_WANT(){
  eccState = index_WANT;
  alg_STOP();
  STOP.serviceEvent(this);
  alg_REQUEST();
  MULTI_OUT.serviceEvent(this);
  alg_PRINT_WANT();
  CNF.serviceEvent(this);
}
private static final int index_HELD = 4;
private void state_HELD(){
  eccState = index_HELD;
  alg_START();
  START.serviceEvent(this);
  alg_PRINT_HELD();
  CNF.serviceEvent(this);
}
private static final int index_GRANT = 5;
private void state_GRANT(){
  eccState = index_GRANT;
  alg_REPLY();
  MULTI_OUT.serviceEvent(this);
  alg_PRINT_GRANT();
state_RELEASE();
}
private static final int index_GRANT_DELAY = 6;
private void state_GRANT_DELAY(){
  eccState = index_GRANT_DELAY;
  alg_PRINT_TRANSITION();
}
/** The default constructor. */
public ConveyorCTLMulticast(){
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
    else if (e == MULTI_IN) service_MULTI_IN();
  }
/** Services the INIT event. */
  public void service_INIT(){
    if ((eccState == index_START)) state_INIT();
  }
/** Services the REQ event. */
  public void service_REQ(){
    if ((eccState == index_RELEASE) && (!PE.value)) state_WANT();
    else if ((eccState == index_GRANT_DELAY) && (PE.value&!PE_14.value)) state_GRANT();
    else if ((eccState == index_HELD) && (PE.value&!PE_14.value)) state_RELEASE();
  }
/** Services the CAS_STOP event. */
  public void service_CAS_STOP(){
  }
/** Services the CAS_START event. */
  public void service_CAS_START(){
  }
/** Services the MULTI_IN event. */
  public void service_MULTI_IN(){
    if ((eccState == index_WANT) && (!Access_Req.value)) state_HELD();
    else if ((eccState == index_HELD) && (Access_Req.value)) state_GRANT_DELAY();
    else if ((eccState == index_RELEASE) && (Access_Req.value)) state_GRANT();
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
  /** ALGORITHM REQUEST IN Java*/
public void alg_REQUEST(){
System.out.println("----------REQUEST----------");
Access_Req_Out.value = true;

}
  /** ALGORITHM REPLY IN Java*/
public void alg_REPLY(){
System.out.println("----------REPLY----------");
Access_Req_Out.value = false;

}
  /** ALGORITHM PRINT_GRANT IN Java*/
public void alg_PRINT_GRANT(){
System.out.println(this+"----------GRANT STATE----------");

}
  /** ALGORITHM PRINT_RELEASED IN Java*/
public void alg_PRINT_RELEASED(){
System.out.println(this+"----------RELEASED STATE----------");

}
  /** ALGORITHM PRINT_WANT IN Java*/
public void alg_PRINT_WANT(){
System.out.println(this+"----------WANT STATE----------");

}
  /** ALGORITHM PRINT_HELD IN Java*/
public void alg_PRINT_HELD(){
System.out.println(this+"----------HELD STATE----------");

}
  /** ALGORITHM PRINT_TRANSITION IN Java*/
public void alg_PRINT_TRANSITION(){
System.out.println(this+"----------GRANT DELAY STATE----------");

}
}
