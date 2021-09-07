package com.assignment.cards

import junit.framework.TestCase
import org.junit.Assert._
import Solver.process

class TexasHoldemSolverTest_1 extends TestCase {
  def test_th_5c6dAcAsQs(): Unit = {
    assertEquals(
      "2cJc Kh4h=Ks4c Kc7h KdJs 6h7d 2hAh",
      process("texas-holdem 5c6dAcAsQs Ks4c KdJs 2hAh Kh4h Kc7h 6h7d 2cJc"),
    )
  }
}


