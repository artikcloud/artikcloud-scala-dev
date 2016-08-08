package cloud.artik.api

import io.swagger.client._
import cloud.artik.api._
import cloud.artik.model._
import org.junit.runner.RunWith
import org.scalatest._
import scala.collection.JavaConverters._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class UsersApiTest extends FlatSpec with Matchers with BeforeAndAfterAll {
    behavior of "UsersApi"
    val applicationId = "b6951bf387b84f63b38911ae35d65e28"
    val userId = "04ddbd35d57d4d7b8f07f219c44457b2"
    val userToken = "fad4f2e4c7ed48548692e8799f1d7acd"

    val api = new UsersApi
    api.apiInvoker.defaultHeaders += "Authorization" -> s"Bearer $userToken"

    // preparation before running a test
    override def beforeAll() {

    }

    // cleanup after running a test
    override def afterAll() {
    }

    it should "fetch a user's details" in {
        api.getSelf match {
            case Some(userEnvelope) => {
                val user = userEnvelope.data

                user.id should be(userId)
                user.name should be("maneesh")
                user.fullName should be("Maneesh Sahu")
            }
            case None =>
                fail("Couldnt get User Profile")
        }
    }

    it should "fetch a user's device details" in {
        api.getUserDevices(userId, 0, 100, true) match {
            case Some(userDevicesEnvelope) => {
                (userDevicesEnvelope.total > 5) should be(true)
            }
            case None =>
                fail("Couldn't retrieve User Devices")
        }
    }

    it should "perform app properties CRUD" in {
        val newProperties = new AppProperties(userId, applicationId, "xyz=mno")

        api.getUserProperties(userId, applicationId) match {
            case Some(userPropertiesEnvelope) => {
                // Update the properties

                api.updateUserProperties(userId, newProperties, applicationId) match {
                    case Some(updatedPropertiesEnvelope) => {
                        updatedPropertiesEnvelope.data.properties should be("xyz=mno")
                    }
                    case None =>
                        fail("Couldn't Update Properties")
                }
            }
            case _ => {
                // Properties not found, create them
                api.createUserProperties(userId, newProperties, applicationId) match {
                    case Some(createdPropertiesEnvelope) => {
                        createdPropertiesEnvelope.data.properties should be("xyz=mno")
                    }
                    case None =>
                        fail("Couldn't Create Properties")
                }
            }
        }
    }
}
