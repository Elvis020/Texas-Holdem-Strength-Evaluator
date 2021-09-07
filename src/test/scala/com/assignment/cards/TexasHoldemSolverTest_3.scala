package com.assignment.cards

import com.assignment.cards.Solver.process
import junit.framework.TestCase
import org.junit.Assert.assertEquals


class TexasHoldemSolverTest_3 extends TestCase{
  def test_th_3d4s5dJsQd(): Unit = {
    assertEquals(
      "9h7h 2dTc KcAs 7sJd TsJc Qh8c 5c4h",
      process("texas-holdem 3d4s5dJsQd 5c4h 7sJd KcAs 9h7h 2dTc Qh8c TsJc"),
    )
  }
}