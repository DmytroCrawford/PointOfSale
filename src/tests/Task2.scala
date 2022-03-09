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
  test("Multiple Modifiers") {
    val testSelfCheckout: SelfCheckout = new SelfCheckout()
    val cunt: SalesTax = new SalesTax(10)
    val cunt2: Sale = new Sale(20)
    val testItem: Item = new Item("test item", 100.0)
    var Bow:Item = new Item("cheese", 10.0)
    testSelfCheckout.addItemToStore("472", Bow)
    Bow.addModifier(cunt2)
    Bow.addModifier(cunt)
    testSelfCheckout.numberPressed(4)
    testSelfCheckout.numberPressed(7)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.enterPressed()

    val cart:List[Item] = testSelfCheckout.itemsInCart()
    assert(cart.size == 1)
    assert(cart.head.description() == "cheese")
    assert(Math.abs(testSelfCheckout.total - 8.8) < 0.00001)
  }
  test("error") {
    val testSelfCheckout: SelfCheckout = new SelfCheckout()
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.numberPressed(3)
    testSelfCheckout.enterPressed()

    val cart: List[Item] = testSelfCheckout.itemsInCart()
    assert((testSelfCheckout.total())-0.0 < 0.0001)
    assert(cart.head.description() == "error")
  }
  test("Multiple Sales") {
    val testSelfCheckout: SelfCheckout = new SelfCheckout()
    val cunt: Sale = new Sale(10)
    val cunt2: Sale = new Sale(20)
    var Bow:Item = new Item("cheese", 10.0)
    testSelfCheckout.addItemToStore("472", Bow)
    Bow.addModifier(cunt2)
    Bow.addModifier(cunt)
    testSelfCheckout.numberPressed(4)
    testSelfCheckout.numberPressed(7)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.enterPressed()

    val cart:List[Item] = testSelfCheckout.itemsInCart()
    assert(cart.size == 1)
    assert(cart.head.description() == "cheese")
    assert(Math.abs(testSelfCheckout.total - 7.2) < 0.00001)
  }
  test("Bottle") {
    val testSelfCheckout: SelfCheckout = new SelfCheckout()
    val cunt: BottleDeposit = new BottleDeposit(10)
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
    assert(Math.abs(testSelfCheckout.total - 20.0) < 0.00001)
  }
}
