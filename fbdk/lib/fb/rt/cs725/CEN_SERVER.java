/* Copyright (c)2020 Rockwell Automation. All rights reserved. */
package fb.rt.cs725;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK CEN_SERVER
  * @author JHC
  * @version 20201026/JHC
  */
public class CEN_SERVER extends FBInstance
{
/** EVENT REQ1 */
 public EventServer REQ1 = new EventInput(this);
/** EVENT REQ2 */
 public EventServer REQ2 = new EventInput(this);
/** EVENT REL1 */
 public EventServer REL1 = new EventInput(this);
/** EVENT REL2 */
 public EventServer REL2 = new EventInput(this);
/** EVENT TOK_GIVE_1 */
 public EventOutput TOK_GIVE_1 = new EventOutput();
/** EVENT TOK_GIVE_2 */
 public EventOutput TOK_GIVE_2 = new EventOutput();
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventServer eiNamed(String s){
    if("REQ1".equals(s)) return REQ1;
    if("REQ2".equals(s)) return REQ2;
    if("REL1".equals(s)) return REL1;
    if("REL2".equals(s)) return REL2;
    return super.eiNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventOutput eoNamed(String s){
    if("TOK_GIVE_1".equals(s)) return TOK_GIVE_1;
    if("TOK_GIVE_2".equals(s)) return TOK_GIVE_2;
    return super.eoNamed(s);}
private static final int index_NOREQUEST = 0;
private void state_NOREQUEST(){
  eccState = index_NOREQUEST;
  alg_NOREQUEST();
}
private static final int index_Requested1 = 1;
private void state_Requested1(){
  eccState = index_Requested1;
  TOK_GIVE_1.serviceEvent(this);
  alg_REQUESTED1();
}
private static final int index_Requested2 = 2;
private void state_Requested2(){
  eccState = index_Requested2;
  TOK_GIVE_2.serviceEvent(this);
  alg_REQUESTED2();
}
private static final int index_Awaiting1Release = 3;
private void state_Awaiting1Release(){
  eccState = index_Awaiting1Release;
  alg_AWAITING1RELEASE();
}
private static final int index_Awaiting2Release = 4;
private void state_Awaiting2Release(){
  eccState = index_Awaiting2Release;
  alg_AWAITING2RELEASE();
}
/** The default constructor. */
public CEN_SERVER(){
    super();
  }
/** {@inheritDoc}
* @param e {@inheritDoc} */
  public void serviceEvent(EventServer e){
    if (e == REQ1) service_REQ1();
    else if (e == REQ2) service_REQ2();
    else if (e == REL1) service_REL1();
    else if (e == REL2) service_REL2();
  }
/** Services the REQ1 event. */
  public void service_REQ1(){
    if ((eccState == index_NOREQUEST)) state_Requested1();
    else if ((eccState == index_Requested2)) state_Awaiting2Release();
  }
/** Services the REQ2 event. */
  public void service_REQ2(){
    if ((eccState == index_NOREQUEST)) state_Requested2();
    else if ((eccState == index_Requested1)) state_Awaiting1Release();
  }
/** Services the REL1 event. */
  public void service_REL1(){
    if ((eccState == index_Requested1)) state_NOREQUEST();
    else if ((eccState == index_Awaiting1Release)) state_Requested2();
  }
/** Services the REL2 event. */
  public void service_REL2(){
    if ((eccState == index_Requested2)) state_NOREQUEST();
    else if ((eccState == index_Awaiting2Release)) state_Requested1();
  }
  /** ALGORITHM NOREQUEST IN Java*/
public void alg_NOREQUEST(){
System.out.println("Server: NOREQUEST");

}
  /** ALGORITHM REQUESTED2 IN Java*/
public void alg_REQUESTED2(){
System.out.println("Server: REQUESTED2");

}
  /** ALGORITHM REQUESTED1 IN Java*/
public void alg_REQUESTED1(){
System.out.println("Server: REQUESTED1");

}
  /** ALGORITHM AWAITING1RELEASE IN Java*/
public void alg_AWAITING1RELEASE(){
System.out.println("Server: AWAITING1RELEASE");

}
  /** ALGORITHM AWAITING2RELEASE IN Java*/
public void alg_AWAITING2RELEASE(){
System.out.println("Server: AWAITING2RELEASE");

}
}
