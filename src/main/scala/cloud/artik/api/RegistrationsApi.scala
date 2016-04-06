package cloud.artik.api

import cloud.artik.model.DeviceRegConfirmUserRequest
import cloud.artik.model.DeviceRegConfirmUserResponseEnvelope
import cloud.artik.model.DeviceRegStatusResponseEnvelope
import cloud.artik.model.UnregisterDeviceResponseEnvelope
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import javax.ws.rs.core.MediaType

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class RegistrationsApi(val defBasePath: String = "https://api.artik.cloud/v1.1",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  
  /**
   * Confirm User
   * This call updates the registration request issued earlier by associating it with an authenticated user and captures all additional information required to add a new device.
   * @param registrationInfo Device Registration information.
   * @return DeviceRegConfirmUserResponseEnvelope
   */
  def confirmUser (registrationInfo: DeviceRegConfirmUserRequest) : Option[DeviceRegConfirmUserResponseEnvelope] = {
    // create path and map variables
    val path = "/devices/registrations/pin".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    
    
    

    var postBody: AnyRef = registrationInfo

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "PUT", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[DeviceRegConfirmUserResponseEnvelope]).asInstanceOf[DeviceRegConfirmUserResponseEnvelope])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get Request Status For User
   * This call checks the status of the request so users can poll and know when registration is complete.
   * @param requestId Request ID.
   * @return DeviceRegStatusResponseEnvelope
   */
  def getRequestStatusForUser (requestId: String) : Option[DeviceRegStatusResponseEnvelope] = {
    // create path and map variables
    val path = "/devices/registrations/{requestId}/status".replaceAll("\\{format\\}","json").replaceAll("\\{" + "requestId" + "\\}",apiInvoker.escape(requestId))

    

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
           Some(ApiInvoker.deserialize(s, "", classOf[DeviceRegStatusResponseEnvelope]).asInstanceOf[DeviceRegStatusResponseEnvelope])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Unregister Device
   * This call clears any associations from the secure device registration.
   * @param deviceId Device ID.
   * @return UnregisterDeviceResponseEnvelope
   */
  def unregisterDevice (deviceId: String) : Option[UnregisterDeviceResponseEnvelope] = {
    // create path and map variables
    val path = "/devices/{deviceId}/registrations".replaceAll("\\{format\\}","json").replaceAll("\\{" + "deviceId" + "\\}",apiInvoker.escape(deviceId))

    

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
      apiInvoker.invokeApi(basePath, path, "DELETE", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[UnregisterDeviceResponseEnvelope]).asInstanceOf[UnregisterDeviceResponseEnvelope])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
}
