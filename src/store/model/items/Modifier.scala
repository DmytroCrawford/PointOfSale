package store.model.items

abstract class Modifier {

  def updatePrice(newPrice:Double): Double = {
    0.0
  }
  def computeTax(TaxPrice:Double): Double = {
    0.0
  }

}
