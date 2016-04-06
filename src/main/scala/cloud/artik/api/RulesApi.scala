package cloud.artik.api

import cloud.artik.model.RuleEnvelope
import cloud.artik.model.RuleCreationInfo
import cloud.artik.model.RuleUpdateInfo
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import javax.ws.rs.core.MediaType

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class RulesApi(val defBasePath: String = "https://api.artik.cloud/v1.1",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  
  /**
   * Create Rule
   * Create a new Rule
   * @param ruleInfo Rule object that needs to be added
   * @param userId User ID
   * @return RuleEnvelope
   */
  def createRule (ruleInfo: RuleCreationInfo, userId: String) : Option[RuleEnvelope] = {
    // create path and map variables
    val path = "/rules".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(userId) != "null") queryParams += "userId" -> userId.toString
    
    
    

    var postBody: AnyRef = ruleInfo

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "POST", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[RuleEnvelope]).asInstanceOf[RuleEnvelope])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get Rule
   * Get a rule using the Rule ID
   * @param ruleId Rule ID.
   * @return RuleEnvelope
   */
  def getRule (ruleId: String) : Option[RuleEnvelope] = {
    // create path and map variables
    val path = "/rules/{ruleId}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "ruleId" + "\\}",apiInvoker.escape(ruleId))

    

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
           Some(ApiInvoker.deserialize(s, "", classOf[RuleEnvelope]).asInstanceOf[RuleEnvelope])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Update Rule
   * Update an existing Rule
   * @param ruleId Rule ID.
   * @param ruleInfo Rule object that needs to be updated
   * @return RuleEnvelope
   */
  def updateRule (ruleId: String, ruleInfo: RuleUpdateInfo) : Option[RuleEnvelope] = {
    // create path and map variables
    val path = "/rules/{ruleId}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "ruleId" + "\\}",apiInvoker.escape(ruleId))

    

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    
    
    

    var postBody: AnyRef = ruleInfo

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "PUT", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[RuleEnvelope]).asInstanceOf[RuleEnvelope])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Delete Rule
   * Delete a Rule
   * @param ruleId Rule ID.
   * @return RuleEnvelope
   */
  def deleteRule (ruleId: String) : Option[RuleEnvelope] = {
    // create path and map variables
    val path = "/rules/{ruleId}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "ruleId" + "\\}",apiInvoker.escape(ruleId))

    

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
           Some(ApiInvoker.deserialize(s, "", classOf[RuleEnvelope]).asInstanceOf[RuleEnvelope])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
}
