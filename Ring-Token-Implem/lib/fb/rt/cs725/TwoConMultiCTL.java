/* Copyright (c)2020 Rockwell Automation. All rights reserved. */
package fb.rt.cs725;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK TwoConMultiCTL
  * @author JHC
  * @version 20201027/JHC
  */
public class TwoConMultiCTL extends FBInstance
{
/** VAR Candidate */
  public BOOL Candidate = new BOOL();
/** VAR Block */
  public BOOL Block = new BOOL();
/** VAR PE */
  public BOOL PE = new BOOL();
/** VAR PE_14 */
  public BOOL PE_14 = new BOOL();
/** VAR Multi_ID */
  public INT Multi_ID = new INT();
/** VAR Multi_Time_In */
  public INT Multi_Time_In = new INT();
/** VAR Access_Req */
  public BOOL Access_Req = new BOOL();
/** VAR MotoRotate1 */
  public BOOL MotoRotate1 = new BOOL();
/** VAR MotoRotate2 */
  public BOOL MotoRotate2 = new BOOL();
/** VAR BlockCon */
  public BOOL BlockCon = new BOOL();
/** VAR Multi_ID_Out */
  public INT Multi_ID_Out = new INT();
/** VAR Multi_Time_Out */
  public INT Multi_Time_Out = new INT();
/** VAR Access_Req_Out */
  public BOOL Access_Req_Out = new BOOL();
/** Initialization Request */
 public EventOutput INIT = new EventOutput();
/** Normal Execution Request */
 public EventOutput REQ = new EventOutput();
/** EVENT START */
 public EventOutput START = new EventOutput();
/** EVENT STOP */
 public EventOutput STOP = new EventOutput();
/** EVENT MULTI_IN */
 public EventOutput MULTI_IN = new EventOutput();
/** Initialization Confirm */
 public EventOutput INITO = new EventOutput();
/** Execution Confirmation */
 public EventOutput CNF = new EventOutput();
/** EVENT MULTI_OUT */
 public EventOutput MULTI_OUT = new EventOutput();
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventServer eiNamed(String s){
    if("INIT".equals(s)) return INIT;
    if("REQ".equals(s)) return REQ;
    if("START".equals(s)) return START;
    if("STOP".equals(s)) return STOP;
    if("MULTI_IN".equals(s)) return MULTI_IN;
    return super.eiNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventOutput eoNamed(String s){
    if("INITO".equals(s)) return INITO;
    if("CNF".equals(s)) return CNF;
    if("MULTI_OUT".equals(s)) return MULTI_OUT;
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
    if("MotoRotate1".equals(s)) return MotoRotate1;
    if("MotoRotate2".equals(s)) return MotoRotate2;
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
    if("Candidate".equals(ivName)) connect_Candidate((BOOL)newIV);
    else if("Block".equals(ivName)) connect_Block((BOOL)newIV);
    else if("PE".equals(ivName)) connect_PE((BOOL)newIV);
    else if("PE_14".equals(ivName)) connect_PE_14((BOOL)newIV);
    else if("Multi_ID".equals(ivName)) connect_Multi_ID((INT)newIV);
    else if("Multi_Time_In".equals(ivName)) connect_Multi_Time_In((INT)newIV);
    else if("Access_Req".equals(ivName)) connect_Access_Req((BOOL)newIV);
    else super.connectIV(ivName, newIV);
    }
/** Connect the given variable to the input variable Candidate
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_Candidate(BOOL newIV) throws FBRManagementException{
    Candidate = newIV;
    Con11.connectIVNoException("Candidate",Candidate);
    }
/** Connect the given variable to the input variable Block
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_Block(BOOL newIV) throws FBRManagementException{
    Block = newIV;
    Con11.connectIVNoException("Block",Block);
    }
/** Connect the given variable to the input variable PE
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_PE(BOOL newIV) throws FBRManagementException{
    PE = newIV;
    Con11.connectIVNoException("PE",PE);
    }
/** Connect the given variable to the input variable PE_14
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_PE_14(BOOL newIV) throws FBRManagementException{
    PE_14 = newIV;
    Con11.connectIVNoException("PE_14",PE_14);
    }
/** Connect the given variable to the input variable Multi_ID
  * @param newIV The variable to connect
 */
  public void connect_Multi_ID(INT newIV){
    Multi_ID = newIV;
    }
/** Connect the given variable to the input variable Multi_Time_In
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_Multi_Time_In(INT newIV) throws FBRManagementException{
    Multi_Time_In = newIV;
    Con11.connectIVNoException("Multi_Time_In",Multi_Time_In);
    }
/** Connect the given variable to the input variable Access_Req
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_Access_Req(BOOL newIV) throws FBRManagementException{
    Access_Req = newIV;
    Con11.connectIVNoException("Access_Req",Access_Req);
    }
/** FB FC11 */
  protected ConveyorCTL FC11 = new ConveyorCTL() ;
/** FB Con11 */
  protected ConveyorCTLMulticast Con11 = new ConveyorCTLMulticast() ;
/** The default constructor. */
public TwoConMultiCTL(){
    super();
    INIT.connectTo(FC11.INIT);
    REQ.connectTo(FC11.REQ);
    Con11.INITO.connectTo(INITO);
    Con11.CNF.connectTo(CNF);
    REQ.connectTo(Con11.REQ);
    STOP.connectTo(Con11.CAS_STOP);
    START.connectTo(Con11.CAS_START);
    Con11.STOP.connectTo(FC11.CAS_STOP);
    Con11.START.connectTo(FC11.CAS_START);
    FC11.INITO.connectTo(Con11.INIT);
    MULTI_IN.connectTo(Con11.MULTI_IN);
    Con11.MULTI_OUT.connectTo(MULTI_OUT);
    Con11.connectIVNoException("Block",Block);
    Con11.connectIVNoException("Candidate",Candidate);
    Con11.connectIVNoException("PE",PE);
    BlockCon = (BOOL)Con11.ovNamedNoException("BlockCon");
    MotoRotate1 = (BOOL)FC11.ovNamedNoException("MotoRotate");
    MotoRotate2 = (BOOL)Con11.ovNamedNoException("MotoRotate");
    Multi_ID_Out = (INT)Con11.ovNamedNoException("Multi_ID_Out");
    Multi_Time_Out = (INT)Con11.ovNamedNoException("Multi_Time_Out");
    Access_Req_Out = (BOOL)Con11.ovNamedNoException("Access_Req_Out");
    Con11.connectIVNoException("PE_14",PE_14);
    Con11.connectIVNoException("Access_Req",Access_Req);
    Con11.connectIVNoException("Multi_Time_In",Multi_Time_In);
    FC11.PE.initializeNoException("0");
    FC11.Block.initializeNoException("0");
    FC11.Candidate.initializeNoException("0");
    Con11.Multi_ID.initializeNoException("1");
  }
/** {@inheritDoc}
 * @param fbName {@inheritDoc}
 * @param r {@inheritDoc}
 * @throws FBRManagementException {@inheritDoc} */
  public void initialize(String fbName, Resource r)
  throws FBRManagementException{
    super.initialize(fbName,r);
    FC11.initialize("FC11",r);
    Con11.initialize("Con11",r);
}
/** Start the FB instances. */
public void start( ){
  FC11.start();
  Con11.start();
}
/** Stop the FB instances. */
public void stop( ){
  FC11.stop();
  Con11.stop();
}
}
