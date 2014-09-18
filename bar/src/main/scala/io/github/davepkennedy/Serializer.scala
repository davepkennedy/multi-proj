package io.github.davepkennedy

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule

trait Serializer {
  def toString (value: AnyRef): Option[String]
}

trait Deserializer {
  def fromString[T] (string: String, classType: Class[T]): Option[T]
}

object JsonSerialization extends Serializer with Deserializer {
  private val mapper = new ObjectMapper()
  mapper.registerModule(DefaultScalaModule)

  override def toString(value: AnyRef): Option[String] = Some(mapper.writeValueAsString(value))

  override def fromString[T](string: String, classType: Class[T]): Option[T] = Some(mapper.readValue(string, classType))
}

object NullSerialization extends Serializer with Deserializer {
  override def toString(value: AnyRef): Option[String] = None

  override def fromString[T](string: String, classType: Class[T]): Option[T] = None
}