package cloud.artik.api

import io.swagger.client._
import cloud.artik.api._
import cloud.artik.model._
import org.junit.runner.RunWith
import org.scalatest._
import scala.collection.JavaConverters._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TokensApiTest extends FlatSpec with Matchers with BeforeAndAfterAll {
    behavior of "TokensApi"

    val userToken = "76a15b2f29e741eeb407d3891a7aa222"
    val refreshToken = "bb90333aee114b3e97284814d978080d"

    val api = new TokensApi("https://accounts.artik.cloud")
    api.apiInvoker.defaultHeaders += "Authorization" -> s"Bearer $userToken"

    // preparation before running a test
    override def beforeAll() {

    }

    // cleanup after running a test
    override def afterAll() {
    }

    it should "check a user's token for validity" in {
        val request = new TokenRequest(userToken)
        api.checkToken(request) match {
            case Some(response) =>
                response.data.message should be("Valid token")
            case None =>
                fail("Couldnt check token")
        }
    }

    it should "refresh a user's token" in {
        api.refreshToken("refresh_token", refreshToken) match {
            case Some(response) =>
                response should not should be(null)
            case None =>
                fail("Couldnt refresh token")
        }
    }

}
