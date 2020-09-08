package lectures.part3fp

import scala.util.Random

object Options extends App {

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None
  println(myFirstOption)
  println(noOption)

  // Deals with unsafe API
  def unsafeMethod(): String = null

  // val result = Some(unsafeMethod()) // wrong
  val result = Option(unsafeMethod())
  println(result)
  // Never do null checks

  // Chained methods
  def backupMethod: String = "A valid result"

  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod))

  // designing unsafe api
  def betterUnsafeMethod: Option[String] = None

  def betterBackupMethod: Option[String] = Some("A valid response")

  val betterChainedResult = betterBackupMethod orElse betterBackupMethod

  // Functions
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) // Unsafe - Do not use

  // map, flatmap, filter
  println(myFirstOption.map(x => x * 4))
  println(myFirstOption.filter(x => x > 10))
  println(myFirstOption.flatMap(x => Option(x * 5)))

  // Exercise

  val config: Map[String, String] = Map(
    "host" -> "192.168.0.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected"
  }

  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] = {
      if (random.nextBoolean()) Some(new Connection)
      else None
    }
  }

  // Establish a connection
  val host = config.get("host")
  val port = config.get("port")
  val connection = host.flatMap(h => port.flatMap(p => Connection(h, p)))
  println(connection)
  connection.foreach(c => println(c.connect))

  println("Using for each comprehension")

  val connectionStatus = for {
    h <- config.get("host")
    p <- config.get("port")
    connection <- Connection(h, p)
  } yield connection.connect
  println(connectionStatus)
  connectionStatus.foreach(println)

}
