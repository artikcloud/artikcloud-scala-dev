package cloud.artik.api

import cloud.artik.model.TagsEnvelope
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import javax.ws.rs.core.MediaType

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class TagsApi(val defBasePath: String = "https://api.artik.cloud/v1.1",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  
  /**
   * Get all tags of categories
   * Get all tags related to the list of categories
   * @param categories Comma separated list of categories.
   * @return TagsEnvelope
   */
  def getTagsByCategories (categories: String) : Option[TagsEnvelope] = {
    // create path and map variables
    val path = "/tags".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(categories) != "null") queryParams += "categories" -> categories.toString
    
    
    

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
           Some(ApiInvoker.deserialize(s, "", classOf[TagsEnvelope]).asInstanceOf[TagsEnvelope])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get all categories
   * Get all tags marked as categories
   * @return TagsEnvelope
   */
  def getTagCategories () : Option[TagsEnvelope] = {
    // create path and map variables
    val path = "/tags/categories".replaceAll("\\{format\\}","json")

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
           Some(ApiInvoker.deserialize(s, "", classOf[TagsEnvelope]).asInstanceOf[TagsEnvelope])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get tag suggestions
   * Get tag suggestions for applications, device types that have been most used with a group of tags.
   * @param entityType Entity type name.
   * @param tags Comma separated list of tags.
   * @param name Name of tags used for type ahead.
   * @param count Number of results to return. Max 10.
   * @return TagsEnvelope
   */
  def getTagSuggestions (entityType: String, tags: String, name: String, count: Integer) : Option[TagsEnvelope] = {
    // create path and map variables
    val path = "/tags/suggestions".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(entityType) != "null") queryParams += "entity_type" -> entityType.toString
    if(String.valueOf(tags) != "null") queryParams += "tags" -> tags.toString
    if(String.valueOf(name) != "null") queryParams += "name" -> name.toString
    if(String.valueOf(count) != "null") queryParams += "count" -> count.toString
    
    
    

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
           Some(ApiInvoker.deserialize(s, "", classOf[TagsEnvelope]).asInstanceOf[TagsEnvelope])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
}
