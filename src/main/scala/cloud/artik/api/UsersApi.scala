package cloud.artik.api

import cloud.artik.model.UserEnvelope
import cloud.artik.model.DevicesEnvelope
import cloud.artik.model.DeviceTypesEnvelope
import cloud.artik.model.PropertiesEnvelope
import cloud.artik.model.AppProperties
import cloud.artik.model.RulesEnvelope
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import javax.ws.rs.core.MediaType

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class UsersApi(val defBasePath: String = "https://api.artik.cloud/v1.1",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  
  /**
   * Get Current User Profile
   * Get&#39;s the current user&#39;s profile
   * @return UserEnvelope
   */
  def getSelf () : Option[UserEnvelope] = {
    // create path and map variables
    val path = "/users/self".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    
    
    

    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[UserEnvelope]).asInstanceOf[UserEnvelope])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get User Devices
   * Retrieve User&#39;s Devices
   * @param userId User ID
   * @param offset Offset for pagination.
   * @param count Desired count of items in the result set
   * @param includeProperties Optional. Boolean (true/false) - If false, only return the user&#39;s device types. If true, also return device types shared by other users.
   * @return DevicesEnvelope
   */
  def getUserDevices (userId: String, offset: Integer, count: Integer, includeProperties: Boolean) : Option[DevicesEnvelope] = {
    // create path and map variables
    val path = "/users/{userId}/devices".replaceAll("\\{format\\}","json").replaceAll("\\{" + "userId" + "\\}",apiInvoker.escape(userId))

    

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(offset) != "null") queryParams += "offset" -> offset.toString
    if(String.valueOf(count) != "null") queryParams += "count" -> count.toString
    if(String.valueOf(includeProperties) != "null") queryParams += "includeProperties" -> includeProperties.toString
    
    
    

    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[DevicesEnvelope]).asInstanceOf[DevicesEnvelope])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get User Device Types
   * Retrieve User&#39;s Device Types
   * @param userId User ID.
   * @param offset Offset for pagination.
   * @param count Desired count of items in the result set
   * @param includeShared Optional. Boolean (true/false) - If false, only return the user&#39;s device types. If true, also return device types shared by other users.
   * @return DeviceTypesEnvelope
   */
  def getUserDeviceTypes (userId: String, offset: Integer, count: Integer, includeShared: Boolean) : Option[DeviceTypesEnvelope] = {
    // create path and map variables
    val path = "/users/{userId}/devicetypes".replaceAll("\\{format\\}","json").replaceAll("\\{" + "userId" + "\\}",apiInvoker.escape(userId))

    

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(offset) != "null") queryParams += "offset" -> offset.toString
    if(String.valueOf(count) != "null") queryParams += "count" -> count.toString
    if(String.valueOf(includeShared) != "null") queryParams += "includeShared" -> includeShared.toString
    
    
    

    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[DeviceTypesEnvelope]).asInstanceOf[DeviceTypesEnvelope])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get User application properties
   * Get application properties of a user
   * @param userId User Id
   * @param aid Application ID
   * @return PropertiesEnvelope
   */
  def getUserProperties (userId: String, aid: String) : Option[PropertiesEnvelope] = {
    // create path and map variables
    val path = "/users/{userId}/properties".replaceAll("\\{format\\}","json").replaceAll("\\{" + "userId" + "\\}",apiInvoker.escape(userId))

    

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(aid) != "null") queryParams += "aid" -> aid.toString
    
    
    

    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[PropertiesEnvelope]).asInstanceOf[PropertiesEnvelope])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Update User Application Properties
   * Updates application properties of a user
   * @param userId User Id
   * @param properties Properties to be updated
   * @param aid Application ID
   * @return PropertiesEnvelope
   */
  def updateUserProperties (userId: String, properties: AppProperties, aid: String) : Option[PropertiesEnvelope] = {
    // create path and map variables
    val path = "/users/{userId}/properties".replaceAll("\\{format\\}","json").replaceAll("\\{" + "userId" + "\\}",apiInvoker.escape(userId))

    

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(aid) != "null") queryParams += "aid" -> aid.toString
    
    
    

    var postBody: AnyRef = properties

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "PUT", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[PropertiesEnvelope]).asInstanceOf[PropertiesEnvelope])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Create User Application Properties
   * Create application properties for a user
   * @param userId User Id
   * @param properties Properties to be updated
   * @param aid Application ID
   * @return PropertiesEnvelope
   */
  def createUserProperties (userId: String, properties: AppProperties, aid: String) : Option[PropertiesEnvelope] = {
    // create path and map variables
    val path = "/users/{userId}/properties".replaceAll("\\{format\\}","json").replaceAll("\\{" + "userId" + "\\}",apiInvoker.escape(userId))

    

    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(aid) != "null") queryParams += "aid" -> aid.toString
    
    
    

    var postBody: AnyRef = properties

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "POST", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[PropertiesEnvelope]).asInstanceOf[PropertiesEnvelope])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Delete User Application Properties
   * Deletes a user&#39;s application properties
   * @param userId User Id
   * @param aid Application ID
   * @return PropertiesEnvelope
   */
  def deleteUserProperties (userId: String, aid: String) : Option[PropertiesEnvelope] = {
    // create path and map variables
    val path = "/users/{userId}/properties".replaceAll("\\{format\\}","json").replaceAll("\\{" + "userId" + "\\}",apiInvoker.escape(userId))

    

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(aid) != "null") queryParams += "aid" -> aid.toString
    
    
    

    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "DELETE", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[PropertiesEnvelope]).asInstanceOf[PropertiesEnvelope])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get User Rules
   * Retrieve User&#39;s Rules
   * @param userId User ID.
   * @param excludeDisabled Exclude disabled rules in the result.
   * @param otherApplications List rules of other applications if current application id has full read access
   * @param count Desired count of items in the result set.
   * @param offset Offset for pagination.
   * @return RulesEnvelope
   */
  def getUserRules (userId: String, excludeDisabled: Boolean, otherApplications: Boolean, count: Integer, offset: Integer) : Option[RulesEnvelope] = {
    // create path and map variables
    val path = "/users/{userId}/rules".replaceAll("\\{format\\}","json").replaceAll("\\{" + "userId" + "\\}",apiInvoker.escape(userId))

    

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(excludeDisabled) != "null") queryParams += "excludeDisabled" -> excludeDisabled.toString
    if(String.valueOf(otherApplications) != "null") queryParams += "otherApplications" -> otherApplications.toString
    if(String.valueOf(count) != "null") queryParams += "count" -> count.toString
    if(String.valueOf(offset) != "null") queryParams += "offset" -> offset.toString
    
    
    

    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[RulesEnvelope]).asInstanceOf[RulesEnvelope])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
}
