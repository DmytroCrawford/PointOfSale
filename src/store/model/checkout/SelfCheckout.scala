package store.model.checkout

import store.model.items.{Item, SalesTax}

class SelfCheckout {
  var zero:Double= 0.0
  var barstring:String=""
  var store:Map[String,Item]=Map()
  var cart:List[Item]=List()

  def addItemToStore(barcode: String, item: Item): Unit = {
    // This method adds an item to your store's checkout system. It does not add an item to the customer's cart
    store += (barcode -> item)
    // TODO
  }

  def numberPressed(number: Int): Unit = {
    this.barstring+=number.toString
    // TODO
  }

  def clearPressed(): Unit = {
    // TODO
    this.barstring=""
  }

  def enterPressed(): Unit = {
    // TODO
    var error:Item = new Item("error", 0.0)
    this.cart= cart :+ store.getOrElse(barstring, error)
    clearPressed()
  }

  def checkoutPressed(): Unit = {
    // TODO
  }

  def cashPressed(): Unit = {
    // TODO
  }

  def creditPressed(): Unit = {
    // TODO
  }

  def loyaltyCardPressed(): Unit = {
    // TODO
  }

  def displayString(): String = {
    this.barstring
    // TODO
  }

  def itemsInCart(): List[Item] = {
    this.cart
  }

  def subtotal(): Double = {
    var total=0.0
    for (items <- cart)
      total += items.price
    total
  }

  def tax(): Double = {
    var TaxTo=0.0
    for (items <- cart)
      TaxTo += items.tax
    TaxTo
  }

  def total(): Double = {
    subtotal()+tax()
  }

  def prepareStore(): Unit = {
    val cunt: SalesTax = new SalesTax(10)
    val testItem: Item = new Item("test item", 100.0)
    testItem.addModifier(cunt)
    this.addItemToStore("472", testItem)
  }

}
