package org.derekmorr

import akka.actor.{ActorLogging, Actor}
import akka.event.LoggingReceive
import org.derekmorr.HelloActor._

/**
 * An actor that prints out messages.
 */
class HelloActor extends Actor with ActorLogging {

  override def receive = {
    case SaySomething(msg) =>  {
      log.info(s"received message: $msg")
      throw new Exception("kaboom")
    }
  }
}

object HelloActor {
  case class SaySomething(message: String)
}
