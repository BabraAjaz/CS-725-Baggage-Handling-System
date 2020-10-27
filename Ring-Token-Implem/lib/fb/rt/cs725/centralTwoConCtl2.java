/* Copyright (c)2020 Rockwell Automation. All rights reserved. */
package fb.rt.cs725;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK centralTwoConCtl2
  * @author JHC
  * @version 20201027/JHC
  */
public class centralTwoConCtl2 extends FBInstance
{
/** VAR Candidate */
  public BOOL Candidate = new BOOL();
/** VAR Block */
  public BOOL Block = new BOOL();
/** VAR PE_ENTER */
  public BOOL PE_ENTER = new BOOL();
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
/** EVENT TOKEN_GET */
 public EventOutput TOKEN_GET = new EventOutput();
/** Initialization Confirm */
 public EventOutput INITO = new EventOutput();
/** Execution Confirmation */
 public EventOutput CNF = new EventOutput();
/** EVENT REL_TOKEN */
 public EventOutput REL_TOKEN = new EventOutput();
/** EVENT REQ_TOKEN */
 public EventOutput REQ_TOKEN = new EventOutput();
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventServer eiNamed(String s){
    if("INIT".equals(s)) return INIT;
    if("REQ".equals(s)) return REQ;
    if("START".equals(s)) return START;
    if("STOP".equals(s)) return STOP;
    if("TOKEN_GET".equals(s)) return TOKEN_GET;
    return super.eiNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventOutput eoNamed(String s){
    if("INITO".equals(s)) return INITO;
    if("CNF".equals(s)) return CNF;
    if("REL_TOKEN".equals(s)) return REL_TOKEN;
    if("REQ_TOKEN".equals(s)) return REQ_TOKEN;
    return super.eoNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
* @throws FBRManagementException {@inheritDoc}
*/
  public ANY ivNamed(String s) throws FBRManagementException{
    if("Candidate".equals(s)) return Candidate;
    if("Block".equals(s)) return Block;
    if("PE_ENTER".equals(s)) return PE_ENTER;
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
    else if("PE_ENTER".equals(ivName)) connect_PE_ENTER((BOOL)newIV);
    else if("PE_EXIT".equals(ivName)) connect_PE_EXIT((BOOL)newIV);
    else super.connectIV(ivName, newIV);
    }
/** Connect the given variable to the input variable Candidate
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_Candidate(BOOL newIV) throws FBRManagementException{
    Candidate = newIV;
    Conveyor6.connectIVNoException("Candidate",Candidate);
    }
/** Connect the given variable to the input variable Block
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_Block(BOOL newIV) throws FBRManagementException{
    Block = newIV;
    Conveyor6.connectIVNoException("Block",Block);
    }
/** Connect the given variable to the input variable PE_ENTER
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_PE_ENTER(BOOL newIV) throws FBRManagementException{
    PE_ENTER = newIV;
    Conveyor6.connectIVNoException("PE_ENTER",PE_ENTER);
    }
/** Connect the given variable to the input variable PE_EXIT
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_PE_EXIT(BOOL newIV) throws FBRManagementException{
    PE_EXIT = newIV;
    Conveyor6.connectIVNoException("PE_EXIT",PE_EXIT);
    }
/** FB FC11 */
  protected ConveyorCTL FC11 = new ConveyorCTL() ;
/** FB Conveyor6 */
  protected centralConCTL Conveyor6 = new centralConCTL() ;
/** The default constructor. */
public centralTwoConCtl2(){
    super();
    INIT.connectTo(FC11.INIT);
    REQ.connectTo(FC11.REQ);
    FC11.INITO.connectTo(Conveyor6.INIT);
    REQ.connectTo(Conveyor6.REQ);
    STOP.connectTo(Conveyor6.CAS_STOP);
    START.connectTo(Conveyor6.CAS_START);
    TOKEN_GET.connectTo(Conveyor6.TOK_GIVEN);
    Conveyor6.INITO.connectTo(INITO);
    Conveyor6.CNF.connectTo(CNF);
    Conveyor6.TOK_REQ.connectTo(REQ_TOKEN);
    Conveyor6.TOK_REL.connectTo(REL_TOKEN);
    Conveyor6.STOP.connectTo(FC11.CAS_STOP);
    Conveyor6.START.connectTo(FC11.CAS_START);
    MotoRotate1 = (BOOL)FC11.ovNamedNoException("MotoRotate");
    Conveyor6.connectIVNoException("PE_ENTER",PE_ENTER);
    Conveyor6.connectIVNoException("Block",Block);
    Conveyor6.connectIVNoException("Candidate",Candidate);
    Conveyor6.connectIVNoException("PE_EXIT",PE_EXIT);
    MotoRotate2 = (BOOL)Conveyor6.ovNamedNoException("MotoRotate");
    BlockCon = (BOOL)Conveyor6.ovNamedNoException("BlockCon");
    FC11.PE.initializeNoException("0");
    FC11.Block.initializeNoException("0");
    FC11.Candidate.initializeNoException("0");
  }
/** {@inheritDoc}
 * @param fbName {@inheritDoc}
 * @param r {@inheritDoc}
 * @throws FBRManagementException {@inheritDoc} */
  public void initialize(String fbName, Resource r)
  throws FBRManagementException{
    super.initialize(fbName,r);
    FC11.initialize("FC11",r);
    Conveyor6.initialize("Conveyor6",r);
}
/** Start the FB instances. */
public void start( ){
  FC11.start();
  Conveyor6.start();
}
/** Stop the FB instances. */
public void stop( ){
  FC11.stop();
  Conveyor6.stop();
}
}
