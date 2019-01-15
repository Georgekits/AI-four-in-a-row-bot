/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourinarow2;
// BG.java

import ch.aplu.jgamegrid.Actor;

public class BG extends Actor
{
  public BG()
  {
    super(false, "sprites/4inARowBG.png");
  }

  public void reset()
  {
    this.setLocationOffset(new java.awt.Point(0, 4 * 70));
    this.setOnTop();
  }
}
