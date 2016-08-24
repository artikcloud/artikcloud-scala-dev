package cloud.artik.api

import com.typesafe.config.ConfigFactory
import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TokensApiTest extends FlatSpec with Matchers with BeforeAndAfterAll {
    behavior of "TokensApi"

    val conf = ConfigFactory.load("artik.properties")
    val userToken = conf.getString("user1.token")

    val api = new TokensApi
    api.apiInvoker.defaultHeaders += "Authorization" -> s"Bearer $userToken"

    // preparation before running a test
    override def beforeAll() {

    }

    // cleanup after running a test
    override def afterAll() {
    }

    it should "get the token info for a user access token" in {
        api.tokenInfo() match {
            case Some(response) =>
                response.data should not be(null)
            case None =>
                fail("Couldnt get token info")
        }
    }

    /*
    it should "refresh a user's token" in {
        api.refreshToken("refresh_token", refreshToken) match {
            case Some(response) =>
                response should not should be(null)
            case None =>
                fail("Couldnt refresh token")
        }
    }*/

}
