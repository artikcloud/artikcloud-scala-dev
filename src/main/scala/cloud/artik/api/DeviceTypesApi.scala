package cloud.artik.api

import cloud.artik.model.DeviceTypesEnvelope
import cloud.artik.model.DeviceTypeEnvelope
import cloud.artik.model.ManifestVersionsEnvelope
import cloud.artik.model.ManifestPropertiesEnvelope
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import javax.ws.rs.core.MediaType

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class DeviceTypesApi(val defBasePath: String = "https://api.artik.cloud/v1.1",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  
  /**
   * Get Device Types
   * Retrieves Device Types
   * @param name Device Type name
   * @param offset Offset for pagination.
   * @param count Desired count of items in the result set
   * @param tags Elements tagged with the list of tags. (comma separated)
   * @return DeviceTypesEnvelope
   */
  def getDeviceTypes (name: String, offset: Integer, count: Integer, tags: String) : Option[DeviceTypesEnvelope] = {
    // create path and map variables
    val path = "/devicetypes".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(name) != "null") queryParams += "name" -> name.toString
    if(String.valueOf(offset) != "null") queryParams += "offset" -> offset.toString
    if(String.valueOf(count) != "null") queryParams += "count" -> count.toString
    if(String.valueOf(tags) != "null") queryParams += "tags" -> tags.toString
    
    
    

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
   * Get Device Type
   * Retrieves a Device Type
   * @param deviceTypeId deviceTypeId
   * @return DeviceTypeEnvelope
   */
  def getDeviceType (deviceTypeId: String) : Option[DeviceTypeEnvelope] = {
    // create path and map variables
    val path = "/devicetypes/{deviceTypeId}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "deviceTypeId" + "\\}",apiInvoker.escape(deviceTypeId))

    

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
           Some(ApiInvoker.deserialize(s, "", classOf[DeviceTypeEnvelope]).asInstanceOf[DeviceTypeEnvelope])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get Available Manifest Versions
   * Get a Device Type&#39;s available manifest versions
   * @param deviceTypeId deviceTypeId
   * @return ManifestVersionsEnvelope
   */
  def getAvailableManifestVersions (deviceTypeId: String) : Option[ManifestVersionsEnvelope] = {
    // create path and map variables
    val path = "/devicetypes/{deviceTypeId}/availablemanifestversions".replaceAll("\\{format\\}","json").replaceAll("\\{" + "deviceTypeId" + "\\}",apiInvoker.escape(deviceTypeId))

    

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
           Some(ApiInvoker.deserialize(s, "", classOf[ManifestVersionsEnvelope]).asInstanceOf[ManifestVersionsEnvelope])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get Latest Manifest Properties
   * Get a Device Type&#39;s manifest properties for the latest version.
   * @param deviceTypeId Device Type ID.
   * @return ManifestPropertiesEnvelope
   */
  def getLatestManifestProperties (deviceTypeId: String) : Option[ManifestPropertiesEnvelope] = {
    // create path and map variables
    val path = "/devicetypes/{deviceTypeId}/manifests/latest/properties".replaceAll("\\{format\\}","json").replaceAll("\\{" + "deviceTypeId" + "\\}",apiInvoker.escape(deviceTypeId))

    

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
           Some(ApiInvoker.deserialize(s, "", classOf[ManifestPropertiesEnvelope]).asInstanceOf[ManifestPropertiesEnvelope])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get manifest properties
   * Get a Device Type&#39;s manifest properties for a specific version.
   * @param deviceTypeId Device Type ID.
   * @param version Manifest Version.
   * @return ManifestPropertiesEnvelope
   */
  def getManifestProperties (deviceTypeId: String, version: String) : Option[ManifestPropertiesEnvelope] = {
    // create path and map variables
    val path = "/devicetypes/{deviceTypeId}/manifests/{version}/properties".replaceAll("\\{format\\}","json").replaceAll("\\{" + "deviceTypeId" + "\\}",apiInvoker.escape(deviceTypeId))

    .replaceAll("\\{" + "version" + "\\}",apiInvoker.escape(version))

    

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
           Some(ApiInvoker.deserialize(s, "", classOf[ManifestPropertiesEnvelope]).asInstanceOf[ManifestPropertiesEnvelope])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
}