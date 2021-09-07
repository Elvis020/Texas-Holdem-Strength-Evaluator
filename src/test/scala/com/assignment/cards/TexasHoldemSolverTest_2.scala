package com.assignment.cards

import com.assignment.cards.Solver.process
import junit.framework.TestCase
import org.junit.Assert.assertEquals

class TexasHoldemSolverTest_2 extends TestCase {
  def test_th_2h5c8sAsKc(): Unit = {
    assertEquals(
      "Jc6s Qs9h 3cKh KdQh",
      process("texas-holdem 2h5c8sAsKc Qs9h KdQh 3cKh Jc6s"),
    )
  }
}


