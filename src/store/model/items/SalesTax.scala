package store.model.items

class SalesTax (TaxRate:Double) extends Modifier () {
  override def updatePrice(Yup:Double): Double={
    Yup
  }
  override def computeTax(Yup:Double): Double={
    var tax = TaxRate/100 * Yup
    tax
  }
}
