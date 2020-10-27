/* Copyright (c)2020 Rockwell Automation. All rights reserved. */
package fb.rt.cs725;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK RingTokenHasCTL
  * @author JHC
  * @version 20201026/JHC
  */
public class RingTokenHasCTL extends FBInstance
{
/** Input event qualifier */
  public BOOL PE = new BOOL();
/** VAR Block */
  public BOOL Block = new BOOL();
/** VAR Candidate */
  public BOOL Candidate = new BOOL();
/** VAR PE13 */
  public BOOL PE13 = new BOOL();
/** VAR TokenIN */
  public BOOL TokenIN = new BOOL();
/** Output event qualifier */
  public BOOL MotoRotate = new BOOL();
/** VAR BlockCon */
  public BOOL BlockCon = new BOOL();
/** VAR Token */
  public BOOL Token = new BOOL();
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
/** EVENT TokenUpdateIN */
 public EventServer TokenUpdateIN = new EventInput(this);
/** Initialization Confirm */
 public EventOutput INITO = new EventOutput();
/** Execution Confirmation */
 public EventOutput CNF = new EventOutput();
/** EVENT STOP */
 public EventOutput STOP = new EventOutput();
/** EVENT START */
 public EventOutput START = new EventOutput();
/** EVENT TokenUpdate */
 public EventOutput TokenUpdate = new EventOutput();
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventServer eiNamed(String s){
    if("INIT".equals(s)) return INIT;
    if("REQ".equals(s)) return REQ;
    if("CAS_STOP".equals(s)) return CAS_STOP;
    if("CAS_START".equals(s)) return CAS_START;
    if("TokenUpdateIN".equals(s)) return TokenUpdateIN;
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
    if("TokenUpdate".equals(s)) return TokenUpdate;
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
    if("PE13".equals(s)) return PE13;
    if("TokenIN".equals(s)) return TokenIN;
    return super.ivNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
* @throws FBRManagementException {@inheritDoc}
*/
  public ANY ovNamed(String s) throws FBRManagementException{
    if("MotoRotate".equals(s)) return MotoRotate;
    if("BlockCon".equals(s)) return BlockCon;
    if("Token".equals(s)) return Token;
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
    else if("PE13".equals(ivName)) connect_PE13((BOOL)newIV);
    else if("TokenIN".equals(ivName)) connect_TokenIN((BOOL)newIV);
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
/** Connect the given variable to the input variable PE13
  * @param newIV The variable to connect
 */
  public void connect_PE13(BOOL newIV){
    PE13 = newIV;
    }
/** Connect the given variable to the input variable TokenIN
  * @param newIV The variable to connect
 */
  public void connect_TokenIN(BOOL newIV){
    TokenIN = newIV;
    }
private static final int index_TOKEN = 0;
private void state_TOKEN(){
  eccState = index_TOKEN;
  alg_START();
  START.serviceEvent(this);
  CNF.serviceEvent(this);
  alg_DISCARD();
  TokenUpdate.serviceEvent(this);
}
private static final int index_NO_TOKEN = 1;
private void state_NO_TOKEN(){
  eccState = index_NO_TOKEN;
  alg_SEND();
  TokenUpdate.serviceEvent(this);
  alg_SEND();
  CNF.serviceEvent(this);
}
private static final int index_INIT = 2;
private void state_INIT(){
  eccState = index_INIT;
  alg_INIT();
  INITO.serviceEvent(this);
  CNF.serviceEvent(this);
state_TOKEN();
}
private static final int index_CRITICAL_SECTION = 3;
private void state_CRITICAL_SECTION(){
  eccState = index_CRITICAL_SECTION;
  alg_START();
  START.serviceEvent(this);
  CNF.serviceEvent(this);
}
private static final int index_CRITICAL_SECTION_Dept = 4;
private void state_CRITICAL_SECTION_Dept(){
  eccState = index_CRITICAL_SECTION_Dept;
}
private static final int index_CS_FROZEN = 5;
private void state_CS_FROZEN(){
  eccState = index_CS_FROZEN;
  alg_STOP();
  STOP.serviceEvent(this);
  CNF.serviceEvent(this);
}
private static final int index_WANT = 6;
private void state_WANT(){
  eccState = index_WANT;
  alg_STOP();
  STOP.serviceEvent(this);
  CNF.serviceEvent(this);
}
/** The default constructor. */
public RingTokenHasCTL(){
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
    else if (e == TokenUpdateIN) service_TokenUpdateIN();
  }
/** Services the INIT event. */
  public void service_INIT(){
    if ((eccState == index_TOKEN)) state_INIT();
  }
/** Services the REQ event. */
  public void service_REQ(){
    if ((eccState == index_TOKEN) && (PE.value)) state_NO_TOKEN();
    else if ((eccState == index_TOKEN) && (!PE.value)) state_CRITICAL_SECTION();
    else if ((eccState == index_CRITICAL_SECTION) && (PE.value)) state_CRITICAL_SECTION_Dept();
    else if ((eccState == index_CRITICAL_SECTION_Dept) && (!PE.value)) state_CS_FROZEN();
    else if ((eccState == index_CRITICAL_SECTION_Dept) && (!PE13.value)) state_NO_TOKEN();
    else if ((eccState == index_CS_FROZEN) && (!PE13.value)) state_NO_TOKEN();
    else if ((eccState == index_NO_TOKEN) && (!PE.value)) state_WANT();
  }
/** Services the CAS_STOP event. */
  public void service_CAS_STOP(){
  }
/** Services the CAS_START event. */
  public void service_CAS_START(){
  }
/** Services the TokenUpdateIN event. */
  public void service_TokenUpdateIN(){
    if ((eccState == index_NO_TOKEN) && (TokenIN.value)) state_TOKEN();
    else if ((eccState == index_WANT) && (TokenIN.value)) state_CRITICAL_SECTION();
  }
  /** ALGORITHM INIT IN ST*/
public void alg_INIT(){
MotoRotate.value=true;
Block.value=false;
}
  /** ALGORITHM REQ IN Java*/
public void alg_REQ(){
if(Candidate.value){
if(lastPE.value!=PE.value){
if(!PE.value){
BlockCon.value=true;
}
 else {
BlockCon.value=false;
}
lastPE.value=PE.value;
}
if(lastBlock.value!=Block.value){
if(Block.value){
STOP.serviceEvent(this);
MotoRotate.value=false;
}
 else {
START.serviceEvent(this);
MotoRotate.value=true;
}
lastBlock.value=Block.value;
}
}

}
  /** ALGORITHM START IN ST*/
public void alg_START(){
MotoRotate.value=true;
}
  /** ALGORITHM STOP IN ST*/
public void alg_STOP(){
MotoRotate.value=false;
}
  /** ALGORITHM DISCARD IN Java*/
public void alg_DISCARD(){
Token.value = false;

}
  /** ALGORITHM SEND IN Java*/
public void alg_SEND(){
Token.value = true;

}
}
