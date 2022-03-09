package store.model.items

import scala.+:

class Item (var desc:String, var bas:Double)  {

  // TODO: Complete this class according to the features listed in the HW document

  var addList:List[Modifier] = List()

  def description(): String = {
    this.desc
  }

  def setBasePrice(para:Double):Unit = {
    this.bas = para
  }

  def price(): Double = {
    var bruh:Double = bas
    for (mods <- addList){
      bruh = mods.updatePrice(bas)
    }
    bruh
  }

  def addModifier(modifier: Modifier): Unit ={
    this.addList = addList :+ modifier
  }

  def tax(): Double={
    var igh:Double = 0.0
    for (mods <- addList){
      igh = mods.computeTax(bas)
    }
    igh
  }

}
