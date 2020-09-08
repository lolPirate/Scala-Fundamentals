package exercises.part3fp

object SocialNetwork {
  var network: Map[String, List[String]] = Map()

  def joinNetwork(person: String): Map[String, List[String]] = {
    val newPerson = (person, List[String]())
    network = network + newPerson
    network
  }

  def quitNetwork(person: String): Map[String, List[String]] = {
    val friendList = network(person)
    friendList.foreach(friend => {
      val friendsFriendList = network(friend)
      val newFriendsFriendList = friendsFriendList.filter(friend => !friend.contains(person))
      val updatedFriendList = friend -> newFriendsFriendList
      network = network + updatedFriendList
    })
    network = network.filter(pair => !pair._1.contains(person))
    network
  }

  def makeFriends(person1: String, person2: String): Map[String, List[String]] = {
    val updatedPerson1friends = {
      val friends = network(person1)
      val newFriends = friends :+ person2
      newFriends
    }
    val newPerson2 = person1 -> updatedPerson1friends
    network = network + newPerson2

    val updatedPerson2friends = {
      val friends = network(person2)
      val newFriends = friends :+ person1
      newFriends
    }
    val newPerson1 = person2 -> updatedPerson2friends
    network = network + newPerson1
    network
  }

  def unfriend(person1: String, person2: String): Map[String, List[String]] = {
    val updatedPerson1friends = {
      val friends = network(person1)
      val newFriends = friends.filter(friend => !friend.contains(person2))
      newFriends
    }
    val newPerson2 = person1 -> updatedPerson1friends
    network = network + newPerson2

    val updatedPerson2friends = {
      val friends = network(person2)
      val newFriends = friends.filter(friend => !friend.contains(person1))
      newFriends
    }
    val newPerson1 = person2 -> updatedPerson2friends
    network = network + newPerson1
    network
  }

  // Stats

  def getFriendCount(person: String): Int = network(person).length

  def noFriendCount: Int = network.count(pair => getFriendCount(pair._1) == 0)

  def friendCount: Map[String, Int] = for {
    pair <- network
  } yield (pair._1, SocialNetwork.getFriendCount(pair._1))

  def highestFriend: (String, Int) = {
    val friendCount = SocialNetwork.friendCount
    val personWithHighestFriend = friendCount.reduce((pair1, pair2) => if (pair1._2 > pair2._2) pair1 else pair2)
    personWithHighestFriend
  }

  def hasConnection(person1: String, person2: String): Boolean = {
    def helper(person: String, considered: List[String], discovered: List[String]): Boolean = {
      if (discovered.isEmpty) false
      else if (person == discovered.head) true
      else helper(person, considered :+ discovered.head, discovered.tail ++ network(discovered.head))
    }

    helper(person2, List[String](), network(person1))
  }

}

object SocialNetworkTest extends App {
  var network = SocialNetwork.joinNetwork("Emily")
  network = SocialNetwork.joinNetwork("Richard")
  network = SocialNetwork.makeFriends("Emily", "Richard")
  network = SocialNetwork.joinNetwork("Debamalya")
  network = SocialNetwork.makeFriends("Debamalya", "Richard")
  network = SocialNetwork.makeFriends("Emily", "Debamalya")
  println(network)
  println(SocialNetwork.friendCount)
  network = SocialNetwork.unfriend("Emily", "Richard")
  println(SocialNetwork.hasConnection("Emily", "Richard"))
  // network = SocialNetwork.unfriend("Emily", "Debamalya")
  println(network)
  println(SocialNetwork.noFriendCount)
  println(SocialNetwork.highestFriend)

  network = SocialNetwork.quitNetwork("Debamalya")
  println(network)
  network = SocialNetwork.unfriend("Emily", "Richard")
  println(network)
  println(SocialNetwork.hasConnection("Emily", "Richard"))


}