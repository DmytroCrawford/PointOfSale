package tests

import org.scalatest.FunSuite
import store.model.checkout.SelfCheckout
import store.model.items.{Item, SalesTax, Modifier, Sale, BottleDeposit}


class Task2 extends FunSuite {
  test("One Item") {
    val testSelfCheckout: SelfCheckout = new SelfCheckout()
    val cunt: SalesTax = new SalesTax(10)
    val testItem: Item = new Item("test item", 100.0)
    var Bow:Item = new Item("cheese", 10.0)
    testSelfCheckout.addItemToStore("472", Bow)
    Bow.addModifier(cunt)
    testSelfCheckout.numberPressed(4)
    testSelfCheckout.numberPressed(7)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.enterPressed()

    val cart:List[Item] = testSelfCheckout.itemsInCart()
    assert(cart.size == 1)
    assert(cart.head.description() == "cheese")
    assert(Math.abs(testSelfCheckout.total - 11.0) < 0.00001)
  }
  test("Two Same Items") {
    val testSelfCheckout: SelfCheckout = new SelfCheckout()
    val cunt: SalesTax = new SalesTax(10)
    val testItem: Item = new Item("test item", 100.0)
    var Bow:Item = new Item("cheese", 10.0)
    testSelfCheckout.addItemToStore("472", Bow)
    Bow.addModifier(cunt)
    testSelfCheckout.numberPressed(4)
    testSelfCheckout.numberPressed(7)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.enterPressed()
    testSelfCheckout.numberPressed(4)
    testSelfCheckout.numberPressed(7)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.enterPressed()

    val cart:List[Item] = testSelfCheckout.itemsInCart()
    assert(cart.size == 2)
    assert(cart.head.description() == "cheese")
    assert(Math.abs(testSelfCheckout.total - 22.0) < 0.00001)
  }
}
