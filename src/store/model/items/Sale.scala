package store.model.items

class Sale (SalePercent:Double) extends Modifier () {
  override def updatePrice(Yup:Double): Double={
    var off = SalePercent/100 * Yup
    var finalPrice = Yup - off
    finalPrice
  }
  override def computeTax(double:Double):Double = {
    0.0
  }
}
