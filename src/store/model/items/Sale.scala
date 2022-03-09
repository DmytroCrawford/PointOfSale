package store.model.items

class Sale (SalePercent:Double) extends Modifier () {
  override def updatePrice(Price:Double): Double={
    var off = SalePercent/100 * Price
    var finalPrice = Price - off
    finalPrice
  }
  override def computeTax(double:Double):Double = {
    0.0
  }
}
