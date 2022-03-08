package tests

import org.scalatest.FunSuite
import store.model.checkout.SelfCheckout
import store.model.items.Item

class Task1 extends FunSuite {

  test("1") {
    //    var testSelfCheckout: SelfCheckout = new SelfCheckout()
    //
    //    var testItem: Item = new Item("test item", 100.0)
    //
    //    testSelfCheckout.addItemToStore("123", testItem)
    // TODO
    var descriptions:List[String]=List()
    var prices:List[Double]=List()
    descriptions=descriptions:+"My description"
    prices=prices:+5.99
    descriptions=descriptions:+"Oreos"
    prices=prices:+4.50
    var items:List[Item]=List()
    for (index <- descriptions.indices){
     items=items:+new Item(descriptions(index),prices(index))

      assert(items(index).description()==descriptions(index),"testing description "+
        "explected: "+descriptions(index)+" actually got: "+items(index).description())
      assert(Math.abs(items(index).price()-prices(index))<.0001,"testing constructor "+
        "expected: "+prices(index)+" got: "+items(index).price())
      items(index).setBasePrice(prices(index)-5)
      assert(Math.abs(items(index).price()-(prices(index)-5))<.0001,"testing setBasePrice "+
        "expected: "+(prices(index)-5)+" got: "+items(index).price())
    }
  }
  test("2") {
    val testItem: Item = new Item("test", 100.0)
    assert(testItem.description() == "test")
    }
  test("pusha t") {
    val testSelfCheckout: SelfCheckout = new SelfCheckout()
    var testItem:Item = new Item("cheese", 12.0)
    testSelfCheckout.addItemToStore("472", testItem)

    assert(testSelfCheckout.displayString() == "")
    testSelfCheckout.numberPressed(4)
    assert(testSelfCheckout.displayString() == "4")
    testSelfCheckout.numberPressed(7)
    assert(testSelfCheckout.displayString() == "47")
    testSelfCheckout.numberPressed(2)
    assert(testSelfCheckout.displayString() == "472")

    testSelfCheckout.enterPressed()

    val cart:List[Item] = testSelfCheckout.itemsInCart()
    assert(cart.size == 1)
    assert(cart.head.description() == "cheese")
    assert(Math.abs(cart.head.price()-12.0) < 0.00001)
  }/*
  test("pusha 0") {
    val testSelfCheckout: SelfCheckout = new SelfCheckout()
    var testItem:Item = new Item("cheese", 12.0)
    testSelfCheckout.addItemToStore("472", testItem)
    testSelfCheckout.addItemToStore("472", testItem)


    testSelfCheckout.enterPressed()

    val cart:List[Item] = testSelfCheckout.itemsInCart()
    assert(cart.size == 1)
    assert(cart.head.description() == "error")
    assert(Math.abs(cart.head.price()-0.0) < 0.00001)
  }*/
  test("pushin c") {
    val testSelfCheckout: SelfCheckout = new SelfCheckout()
    var testItem:Item = new Item("cheese", 12.0)
    var coochieman:Item = new Item("cheese", 12.0)
    testSelfCheckout.addItemToStore("472", testItem)
    testSelfCheckout.addItemToStore("472", testItem)
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
    assert(cart == List(testItem,testItem))
  }
  test("pushin y") {
    val testSelfCheckout: SelfCheckout = new SelfCheckout()
    var testItem:Item = new Item("cheese", 12.0)
    testSelfCheckout.addItemToStore("072", testItem)
    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(7)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.enterPressed()

    val cart:List[Item] = testSelfCheckout.itemsInCart()
    assert(cart.size == 1)
    assert(cart.head.description() == "cheese")
    assert(Math.abs(cart.head.price()-12.0) < 0.00001)
  }
  test("pushin Cappin crunch") {
    val testSelfCheckout: SelfCheckout = new SelfCheckout()
    var testItem:Item = new Item("cheese", 12.0)
    testSelfCheckout.addItemToStore("472", testItem)
    testSelfCheckout.numberPressed(4)
    testSelfCheckout.numberPressed(7)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.enterPressed()

    val cart:List[Item] = testSelfCheckout.itemsInCart()
    assert(cart.size == 1)
    cart.head.setBasePrice(5.00)
    assert(cart.head.description() == "cheese")
    assert(Math.abs(cart.head.price()-5.0) < 0.00001)
  }
  test("pushin Cokkie") {
    val testSelfCheckout: SelfCheckout = new SelfCheckout()
    var testItem:Item = new Item("cheese", 12.0)
    var pipeItem:Item = new Item("lol", 6.0)
    testSelfCheckout.addItemToStore("472", testItem)
    testSelfCheckout.addItemToStore("482", pipeItem)

    testSelfCheckout.numberPressed(4)
    testSelfCheckout.numberPressed(7)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.enterPressed()
    testSelfCheckout.numberPressed(4)
    testSelfCheckout.numberPressed(8)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.enterPressed()

    val cart:List[Item] = testSelfCheckout.itemsInCart()
    assert(cart == List(testItem, pipeItem))
  }
  test("pushin shoot") {
    val testSelfCheckout: SelfCheckout = new SelfCheckout()
    var testItem: Item = new Item("cheese", 12.0)
    testSelfCheckout.addItemToStore("072", testItem)
    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(7)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.clearPressed()
    val cart:List[Item] = testSelfCheckout.itemsInCart()
    assert(testSelfCheckout.displayString == "")
  }
  test("push") {
    val testSelfCheckout: SelfCheckout = new SelfCheckout()
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.numberPressed(3)
    testSelfCheckout.enterPressed()

    val cart: List[Item] = testSelfCheckout.itemsInCart()
    assert(cart.head.description() == "error")
  }
}
