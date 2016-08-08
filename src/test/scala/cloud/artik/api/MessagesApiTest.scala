package cloud.artik.api

import io.swagger.client._
import cloud.artik.api._
import cloud.artik.model._
import org.junit.runner.RunWith
import org.scalatest._
import scala.collection.JavaConverters._
import org.scalatest.junit.JUnitRunner
import java.util.HashMap

@RunWith(classOf[JUnitRunner])
class MessagesApiTest extends FlatSpec with Matchers with BeforeAndAfterAll {
    behavior of "MessagesApi"
    val deviceToken = "dc43d12e2b59495daf94631e6ddfe3e8"
    val sourceDeviceId = "19da42ee01414722a6ad1224097c38d4"

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

        val message = new MessageAction(data, null, sourceDeviceId, System.currentTimeMillis, "message")

        api.sendMessageAction(message) match {
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
