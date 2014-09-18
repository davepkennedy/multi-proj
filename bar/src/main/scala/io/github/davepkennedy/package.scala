package io.github

/**
 * Created by dakennedy on 18/09/2014.
 */
package object davepkennedy {
  def serializerFor (t: String): Serializer = t match {
    case "json" => JsonSerialization
    case _ => NullSerialization
  }

  def deserializerFor (t: String): Deserializer = t match {
    case "json" => JsonSerialization
    case _ => NullSerialization
  }
}
