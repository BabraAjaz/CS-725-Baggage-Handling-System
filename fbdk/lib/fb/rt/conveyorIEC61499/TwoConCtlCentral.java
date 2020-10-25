/* Copyright (c)2020 Rockwell Automation. All rights reserved. */
package fb.rt.conveyorIEC61499;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK TwoConCtlCentral
  * @author JHC
  * @version 20201025/JHC
  */
public class TwoConCtlCentral extends FBInstance
{
/** VAR Candidate */
  public BOOL Candidate = new BOOL();
/** VAR Block */
  public BOOL Block = new BOOL();
/** VAR PE */
  public BOOL PE = new BOOL();
/** VAR PE_EXIT */
  public BOOL PE_EXIT = new BOOL();
/** VAR MotoRotate1 */
  public BOOL MotoRotate1 = new BOOL();
/** VAR MotoRotate2 */
  public BOOL MotoRotate2 = new BOOL();
/** VAR BlockCon */
  public BOOL BlockCon = new BOOL();
/** Initialization Request */
 public EventOutput INIT = new EventOutput();
/** Normal Execution Request */
 public EventOutput REQ = new EventOutput();
/** EVENT START */
 public EventOutput START = new EventOutput();
/** EVENT STOP */
 public EventOutput STOP = new EventOutput();
/** EVENT TOKEN_IN */
 public EventOutput TOKEN_IN = new EventOutput();
/** Initialization Confirm */
 public EventOutput INITO = new EventOutput();
/** Execution Confirmation */
 public EventOutput CNF = new EventOutput();
/** EVENT RELEASE_TOKEN */
 public EventOutput RELEASE_TOKEN = new EventOutput();
/** EVENT REQUEST_TOKEN */
 public EventOutput REQUEST_TOKEN = new EventOutput();
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventServer eiNamed(String s){
    if("INIT".equals(s)) return INIT;
    if("REQ".equals(s)) return REQ;
    if("START".equals(s)) return START;
    if("STOP".equals(s)) return STOP;
    if("TOKEN_IN".equals(s)) return TOKEN_IN;
    return super.eiNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventOutput eoNamed(String s){
    if("INITO".equals(s)) return INITO;
    if("CNF".equals(s)) return CNF;
    if("RELEASE_TOKEN".equals(s)) return RELEASE_TOKEN;
    if("REQUEST_TOKEN".equals(s)) return REQUEST_TOKEN;
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
    if("PE_EXIT".equals(s)) return PE_EXIT;
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
    else if("PE_EXIT".equals(ivName)) connect_PE_EXIT((BOOL)newIV);
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
/** Connect the given variable to the input variable PE_EXIT
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_PE_EXIT(BOOL newIV) throws FBRManagementException{
    PE_EXIT = newIV;
    FC12.connectIVNoException("PE_EXIT",PE_EXIT);
    }
/** FB FC12 */
  protected ConveyorCTLCentral FC12 = new ConveyorCTLCentral() ;
/** FB FC11 */
  protected ConveyorCTL FC11 = new ConveyorCTL() ;
/** FB CENTRAL_START_DELAY */
  protected E_DELAY CENTRAL_START_DELAY = new E_DELAY() ;
/** FB CENTRAL_STOP_DELAY */
  protected E_DELAY CENTRAL_STOP_DELAY = new E_DELAY() ;
/** The default constructor. */
public TwoConCtlCentral(){
    super();
    START.connectTo(FC12.CAS_START);
    STOP.connectTo(FC12.CAS_STOP);
    REQ.connectTo(FC12.REQ);
    FC11.INITO.connectTo(FC12.INIT);
    FC12.INITO.connectTo(INITO);
    FC12.CNF.connectTo(CNF);
    INIT.connectTo(FC11.INIT);
    REQ.connectTo(FC11.REQ);
    FC12.RequestToken.connectTo(RELEASE_TOKEN);
    FC12.RequestToken.connectTo(REQUEST_TOKEN);
    FC12.ReleaseToken.connectTo(RELEASE_TOKEN);
    TOKEN_IN.connectTo(FC12.TokenGranted);
    FC12.START.connectTo(CENTRAL_START_DELAY.START);
    CENTRAL_START_DELAY.EO.connectTo(FC11.CAS_START);
    FC12.STOP.connectTo(CENTRAL_STOP_DELAY.START);
    CENTRAL_STOP_DELAY.EO.connectTo(FC11.CAS_STOP);
    MotoRotate1 = (BOOL)FC11.ovNamedNoException("MotoRotate");
    MotoRotate2 = (BOOL)FC12.ovNamedNoException("MotoRotate");
    BlockCon = (BOOL)FC12.ovNamedNoException("BlockCon");
    FC12.connectIVNoException("Candidate",Candidate);
    FC12.connectIVNoException("Block",Block);
    FC12.connectIVNoException("PE",PE);
    FC12.connectIVNoException("PE_EXIT",PE_EXIT);
    FC11.PE.initializeNoException("0");
    FC11.Block.initializeNoException("0");
    FC11.Candidate.initializeNoException("0");
    CENTRAL_START_DELAY.DT.initializeNoException("t#1000ms");
    CENTRAL_STOP_DELAY.DT.initializeNoException("t#1000ms");
  }
/** {@inheritDoc}
 * @param fbName {@inheritDoc}
 * @param r {@inheritDoc}
 * @throws FBRManagementException {@inheritDoc} */
  public void initialize(String fbName, Resource r)
  throws FBRManagementException{
    super.initialize(fbName,r);
    FC12.initialize("FC12",r);
    FC11.initialize("FC11",r);
    CENTRAL_START_DELAY.initialize("CENTRAL_START_DELAY",r);
    CENTRAL_STOP_DELAY.initialize("CENTRAL_STOP_DELAY",r);
}
/** Start the FB instances. */
public void start( ){
  FC12.start();
  FC11.start();
  CENTRAL_START_DELAY.start();
  CENTRAL_STOP_DELAY.start();
}
/** Stop the FB instances. */
public void stop( ){
  FC12.stop();
  FC11.stop();
  CENTRAL_START_DELAY.stop();
  CENTRAL_STOP_DELAY.stop();
}
}
