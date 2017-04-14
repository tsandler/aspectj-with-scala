package model

import annotations.Annotation

class ScalaEntity{

  @Annotation
  var name: String =_

  def setName(n: String): Unit ={
    name = n
  }
}
