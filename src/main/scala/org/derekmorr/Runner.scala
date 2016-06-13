package org.derekmorr

import akka.actor.{Props, ActorSystem}
import akka.routing.FromConfig
import org.derekmorr.HelloActor.SaySomething

/**
 * Driver for HelloActor
 */
object Runner extends App {

  val msg1 = SaySomething("This is message 1.")
  val msg2 = SaySomething("This is message 2.")
  val msg3 = SaySomething("This is message 3.")
  val msg4 = SaySomething("This is message 4.")

  println("starting up actor system")
  val actorSystem = ActorSystem("CrashySystem")

  val helloActor = actorSystem.actorOf(Props[HelloActor], "helloactor")

  // send our messages
  helloActor ! msg1
  helloActor ! msg2
  helloActor ! msg3
  helloActor ! msg4

  Thread.sleep(2000)
  println("shutting down actor system")
  actorSystem.terminate()
}
