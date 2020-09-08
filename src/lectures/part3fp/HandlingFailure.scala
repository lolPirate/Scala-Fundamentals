package lectures.part3fp

import scala.util.{Failure, Random, Success, Try}


object HandlingFailure extends App {

  val aSuccess = Success(23)
  val aFailure = Failure(new RuntimeException("failed"))
  println(aSuccess)
  println(aFailure)

  def unSafeMethod: String = throw new RuntimeException("failed")

  // Try options
  val potentialFailure = Try(unSafeMethod)
  println(potentialFailure)

  val anotherFailure = Try {
    // code
  }
  println(potentialFailure.isSuccess)

  // orElse
  def backup: String = "Valid"

  val fallBack = Try(unSafeMethod) orElse Try(backup)
  println(fallBack)

  // map, flatMap, filter
  println(aSuccess.map(_ * 2))
  println(aSuccess.flatMap(x => Success(x * 110)))
  println(aSuccess.filter(_ > 1000))

  val hostname = "localhost"
  val port = "8080"

  def renderHTML(page: String) = println(page)

  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())
      if (random.nextBoolean()) "page rendered"
      else throw new RuntimeException("No connection")
    }
  }

  object HTTPService {
    val random = new Random(System.nanoTime())

    def getConnection(host: String, port: String): Connection =
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("port unavailable")
  }

  val page = for {
    connection <- Try(HTTPService.getConnection(hostname, port))
    renderedPage <- Try(connection.get(hostname + " " + port))
  } yield (renderedPage)
  println(page)
  page.foreach(x => renderHTML(x))

}
