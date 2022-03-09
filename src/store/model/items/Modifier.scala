package store.model.items

abstract class Modifier {

  def updatePrice(newPrice:Double): Double
  def computeTax(TaxPrice:Double): Double

}
