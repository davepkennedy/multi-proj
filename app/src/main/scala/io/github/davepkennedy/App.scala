package io.github.davepkennedy

/**
 * Created by dakennedy on 18/09/2014.
 */
object App {
  def main(args: Array[String]): Unit = {
    val s = serializerFor("json").toString(Person("Danny", 6))
    println(s)
  }
}
