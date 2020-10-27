/* Copyright (c)2020 Rockwell Automation. All rights reserved. */
package fb.rt.cs725;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK centralServer
  * @author JHC
  * @version 20201027/JHC
  */
public class centralServer extends FBInstance
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
private static final int index_IDLE = 0;
private void state_IDLE(){
  eccState = index_IDLE;
  alg_IDLE();
}
private static final int index_FCOne_REQ = 1;
private void state_FCOne_REQ(){
  eccState = index_FCOne_REQ;
  TOK_GIVE_1.serviceEvent(this);
  alg_FCOneREQ();
}
private static final int index_FCThreeREQ = 2;
private void state_FCThreeREQ(){
  eccState = index_FCThreeREQ;
  TOK_GIVE_2.serviceEvent(this);
  alg_FCThreeREQ();
}
private static final int index_AWAIT_REQ1 = 3;
private void state_AWAIT_REQ1(){
  eccState = index_AWAIT_REQ1;
  alg_AWAITING1REL();
}
private static final int index_AWAIT_REQ2 = 4;
private void state_AWAIT_REQ2(){
  eccState = index_AWAIT_REQ2;
  alg_AWAITING2REL();
}
/** The default constructor. */
public centralServer(){
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
    if ((eccState == index_IDLE)) state_FCOne_REQ();
    else if ((eccState == index_FCThreeREQ)) state_AWAIT_REQ2();
  }
/** Services the REQ2 event. */
  public void service_REQ2(){
    if ((eccState == index_IDLE)) state_FCThreeREQ();
    else if ((eccState == index_FCOne_REQ)) state_AWAIT_REQ1();
  }
/** Services the REL1 event. */
  public void service_REL1(){
    if ((eccState == index_FCOne_REQ)) state_IDLE();
    else if ((eccState == index_AWAIT_REQ1)) state_FCThreeREQ();
  }
/** Services the REL2 event. */
  public void service_REL2(){
    if ((eccState == index_FCThreeREQ)) state_IDLE();
    else if ((eccState == index_AWAIT_REQ2)) state_FCOne_REQ();
  }
  /** ALGORITHM IDLE IN Java*/
public void alg_IDLE(){

}
  /** ALGORITHM FCThreeREQ IN Java*/
public void alg_FCThreeREQ(){

}
  /** ALGORITHM FCOneREQ IN Java*/
public void alg_FCOneREQ(){

}
  /** ALGORITHM AWAITING1REL IN Java*/
public void alg_AWAITING1REL(){

}
  /** ALGORITHM AWAITING2REL IN Java*/
public void alg_AWAITING2REL(){

}
}
