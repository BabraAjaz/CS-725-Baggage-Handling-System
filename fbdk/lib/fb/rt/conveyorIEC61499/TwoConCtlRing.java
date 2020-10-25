/* Copyright (c)2020 Rockwell Automation. All rights reserved. */
package fb.rt.conveyorIEC61499;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK TwoConCtlRing
  * @author JHC
  * @version 20201025/JHC
  */
public class TwoConCtlRing extends FBInstance
{
/** VAR Candidate */
  public BOOL Candidate = new BOOL();
/** VAR Block */
  public BOOL Block = new BOOL();
/** VAR PE */
  public BOOL PE = new BOOL();
/** VAR TokenIN */
  public BOOL TokenIN = new BOOL();
/** VAR PE13 */
  public BOOL PE13 = new BOOL();
/** VAR MotoRotate1 */
  public BOOL MotoRotate1 = new BOOL();
/** VAR MotoRotate2 */
  public BOOL MotoRotate2 = new BOOL();
/** VAR BlockCon */
  public BOOL BlockCon = new BOOL();
/** VAR Token */
  public BOOL Token = new BOOL();
/** Initialization Request */
 public EventOutput INIT = new EventOutput();
/** Normal Execution Request */
 public EventOutput REQ = new EventOutput();
/** EVENT START */
 public EventOutput START = new EventOutput();
/** EVENT STOP */
 public EventOutput STOP = new EventOutput();
/** EVENT TokenUpdateIN */
 public EventOutput TokenUpdateIN = new EventOutput();
/** Initialization Confirm */
 public EventOutput INITO = new EventOutput();
/** Execution Confirmation */
 public EventOutput CNF = new EventOutput();
/** EVENT TokenUpdate */
 public EventOutput TokenUpdate = new EventOutput();
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventServer eiNamed(String s){
    if("INIT".equals(s)) return INIT;
    if("REQ".equals(s)) return REQ;
    if("START".equals(s)) return START;
    if("STOP".equals(s)) return STOP;
    if("TokenUpdateIN".equals(s)) return TokenUpdateIN;
    return super.eiNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventOutput eoNamed(String s){
    if("INITO".equals(s)) return INITO;
    if("CNF".equals(s)) return CNF;
    if("TokenUpdate".equals(s)) return TokenUpdate;
    return super.eoNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
* @throws FBRManagementException {@inheritDoc}
*/
  public ANY ivNamed(String s) throws FBRManagementException{
    if("Candidate".equals(s)) return Candidate;
    if("Block".equals(s)) return Block;
    if("PE".equals(s)) return PE;
    if("TokenIN".equals(s)) return TokenIN;
    if("PE13".equals(s)) return PE13;
    return super.ivNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
* @throws FBRManagementException {@inheritDoc}
*/
  public ANY ovNamed(String s) throws FBRManagementException{
    if("MotoRotate1".equals(s)) return MotoRotate1;
    if("MotoRotate2".equals(s)) return MotoRotate2;
    if("BlockCon".equals(s)) return BlockCon;
    if("Token".equals(s)) return Token;
    return super.ovNamed(s);}
/** {@inheritDoc}
* @param ivName {@inheritDoc}
* @param newIV {@inheritDoc}
* @throws FBRManagementException {@inheritDoc} */
  public void connectIV(String ivName, ANY newIV)
    throws FBRManagementException{
    if("Candidate".equals(ivName)) connect_Candidate((BOOL)newIV);
    else if("Block".equals(ivName)) connect_Block((BOOL)newIV);
    else if("PE".equals(ivName)) connect_PE((BOOL)newIV);
    else if("TokenIN".equals(ivName)) connect_TokenIN((BOOL)newIV);
    else if("PE13".equals(ivName)) connect_PE13((BOOL)newIV);
    else super.connectIV(ivName, newIV);
    }
/** Connect the given variable to the input variable Candidate
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_Candidate(BOOL newIV) throws FBRManagementException{
    Candidate = newIV;
    FC12.connectIVNoException("Candidate",Candidate);
    }
/** Connect the given variable to the input variable Block
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_Block(BOOL newIV) throws FBRManagementException{
    Block = newIV;
    FC12.connectIVNoException("Block",Block);
    }
/** Connect the given variable to the input variable PE
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_PE(BOOL newIV) throws FBRManagementException{
    PE = newIV;
    FC12.connectIVNoException("PE",PE);
    }
/** Connect the given variable to the input variable TokenIN
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_TokenIN(BOOL newIV) throws FBRManagementException{
    TokenIN = newIV;
    FC12.connectIVNoException("TokenIN",TokenIN);
    }
/** Connect the given variable to the input variable PE13
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_PE13(BOOL newIV) throws FBRManagementException{
    PE13 = newIV;
    FC12.connectIVNoException("PE13",PE13);
    }
/** FB FC11 */
  protected ConveyorCTL FC11 = new ConveyorCTL() ;
/** FB FC12 */
  protected ConveyorCTLRing FC12 = new ConveyorCTLRing() ;
/** FB RING_STOP_DELAY */
  protected E_DELAY RING_STOP_DELAY = new E_DELAY() ;
/** FB RING_START_DELAY */
  protected E_DELAY RING_START_DELAY = new E_DELAY() ;
/** The default constructor. */
public TwoConCtlRing(){
    super();
    INIT.connectTo(FC11.INIT);
    REQ.connectTo(FC11.REQ);
    FC11.INITO.connectTo(FC12.INIT);
    REQ.connectTo(FC12.REQ);
    STOP.connectTo(FC12.CAS_STOP);
    START.connectTo(FC12.CAS_START);
    FC12.INITO.connectTo(INITO);
    FC12.CNF.connectTo(CNF);
    TokenUpdateIN.connectTo(FC12.TokenUpdateIN);
    FC12.TokenUpdate.connectTo(TokenUpdate);
    FC12.STOP.connectTo(RING_STOP_DELAY.START);
    RING_STOP_DELAY.EO.connectTo(FC11.CAS_STOP);
    FC12.START.connectTo(RING_START_DELAY.START);
    RING_START_DELAY.EO.connectTo(FC11.CAS_START);
    MotoRotate1 = (BOOL)FC11.ovNamedNoException("MotoRotate");
    FC12.connectIVNoException("PE",PE);
    FC12.connectIVNoException("Block",Block);
    FC12.connectIVNoException("Candidate",Candidate);
    MotoRotate2 = (BOOL)FC12.ovNamedNoException("MotoRotate");
    BlockCon = (BOOL)FC12.ovNamedNoException("BlockCon");
    Token = (BOOL)FC12.ovNamedNoException("Token");
    FC12.connectIVNoException("TokenIN",TokenIN);
    FC12.connectIVNoException("PE13",PE13);
    FC11.PE.initializeNoException("0");
    FC11.Block.initializeNoException("0");
    FC11.Candidate.initializeNoException("0");
    RING_STOP_DELAY.DT.initializeNoException("t#1000ms");
    RING_START_DELAY.DT.initializeNoException("t#1000ms");
  }
/** {@inheritDoc}
 * @param fbName {@inheritDoc}
 * @param r {@inheritDoc}
 * @throws FBRManagementException {@inheritDoc} */
  public void initialize(String fbName, Resource r)
  throws FBRManagementException{
    super.initialize(fbName,r);
    FC11.initialize("FC11",r);
    FC12.initialize("FC12",r);
    RING_STOP_DELAY.initialize("RING_STOP_DELAY",r);
    RING_START_DELAY.initialize("RING_START_DELAY",r);
}
/** Start the FB instances. */
public void start( ){
  FC11.start();
  FC12.start();
  RING_STOP_DELAY.start();
  RING_START_DELAY.start();
}
/** Stop the FB instances. */
public void stop( ){
  FC11.stop();
  FC12.stop();
  RING_STOP_DELAY.stop();
  RING_START_DELAY.stop();
}
}
