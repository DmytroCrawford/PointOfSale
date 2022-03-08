package store.model.items

class Item (var desc:String, var bas:Double){

  // TODO: Complete this class according to the features listed in the HW document


  def description(): String = {
    this.desc
  }

  def setBasePrice(para:Double):Unit = {
    this.bas = para
  }

  def price(): Double = {
    this.bas
  }

  def addModifier(mod): Unit ={

  }


}
