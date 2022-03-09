package store.model.items

class BottleDeposit (number:Double) extends Modifier () {
  override def updatePrice(Yup:Double): Double={
    Yup
  }
  override def computeTax(place:Double): Double={
    number
  }

}
