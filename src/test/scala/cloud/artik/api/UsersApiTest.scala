package cloud.artik.api

import cloud.artik.model._
import com.typesafe.config.ConfigFactory
import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class UsersApiTest extends FlatSpec with Matchers with BeforeAndAfterAll {
    behavior of "UsersApi"

    val conf = ConfigFactory.load("artik.properties")
    val userId = conf.getString("user1.id")
    val userToken = conf.getString("user1.token")
    val applicationId = conf.getString("user1.aid")

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
                user.name should be(conf.getString("user1.name"))
                user.fullName should be(conf.getString("user1.fullname"))
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
