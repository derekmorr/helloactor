package org.derekmorr

import akka.actor.{Props, ActorSystem}
import akka.routing.FromConfig
import org.derekmorr.HelloActor.SaySomething

/**
 * Driver for HelloActor
 */
object Runner extends App {
  println("starting up actor system")
  val actorSystem = ActorSystem("CrashySystem")

  val helloActor = actorSystem.actorOf(Props[HelloActor], "helloactor")

  // send our messages
  helloActor ! SaySomething("This is message 1.")
  helloActor ! SaySomething("This is message 2.")
  helloActor ! SaySomething("This is message 3.")
  helloActor ! SaySomething("This is message 4.")

  Thread.sleep(2000)
  println("shutting down actor system")
  actorSystem.terminate()
}
