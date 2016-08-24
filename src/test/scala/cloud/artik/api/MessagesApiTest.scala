package cloud.artik.api

import cloud.artik.model._
import com.typesafe.config.ConfigFactory
import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class MessagesApiTest extends FlatSpec with Matchers with BeforeAndAfterAll {
    behavior of "MessagesApi"

    val conf = ConfigFactory.load("artik.properties")
    val sourceDeviceId = conf.getString("device1.id")
    val deviceToken = conf.getString("device1.token")

    val api = new MessagesApi
    api.apiInvoker.defaultHeaders += "Authorization" -> s"Bearer $deviceToken"

    // preparation before running a test
    override def beforeAll() {

    }

    // cleanup after running a test
    override def afterAll() {
    }

    it should "send a message to ArtikCloud and retrieve the normalized message" in {
        val data = Map("steps" -> 500)

        val message = new Message(data, sourceDeviceId, System.currentTimeMillis, "message")

        api.sendMessage(message) match {
            case Some(messageIdEnvelope) =>
                val messageId = messageIdEnvelope.data.mid
                messageId should not be ("")

                Thread.sleep(2000)

                api.getNormalizedMessages(null, null, messageId, null, null, null, null, 0, 100, null) match {
                    case Some(normalizedMessagesEnvelope) =>
                        normalizedMessagesEnvelope.size should be(1)

                        val normalizedMessage = normalizedMessagesEnvelope.data(0)
                        normalizedMessage.mid should be(messageId)

                        val stepsOpt = Option(normalizedMessage.data("steps"))
                        stepsOpt match {
                            case None =>
                                fail("Volume should not be null")
                            case Some(steps) =>
                                steps should be(500)
                        }
                    case None =>
                        fail(s"Couldnt retrieve normalized message by Message Id $messageId")
                }

            case None =>
                fail("Couldn't send message")
        }
    }
}
