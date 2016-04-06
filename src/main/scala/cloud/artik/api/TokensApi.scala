package cloud.artik.api

import cloud.artik.model.TokenRequest
import cloud.artik.model.CheckTokenResponse
import cloud.artik.model.RefreshTokenResponse
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import javax.ws.rs.core.MediaType

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class TokensApi(val defBasePath: String = "https://api.artik.cloud/v1.1",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  
  /**
   * Check Token
   * Check Token
   * @param tokenInfo Token object to be checked
   * @return CheckTokenResponse
   */
  def checkToken (tokenInfo: TokenRequest) : Option[CheckTokenResponse] = {
    // create path and map variables
    val path = "/checkToken".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    
    
    

    var postBody: AnyRef = tokenInfo

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "POST", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[CheckTokenResponse]).asInstanceOf[CheckTokenResponse])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Refresh Token
   * Refresh Token
   * @param grantType Grant Type.
   * @param refreshToken Refresh Token.
   * @return RefreshTokenResponse
   */
  def refreshToken (grantType: String, refreshToken: String) : Option[RefreshTokenResponse] = {
    // create path and map variables
    val path = "/token".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/x-www-form-urlencoded", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    
    
    

    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      mp.field("grant_type", grantType.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      mp.field("refresh_token", refreshToken.toString(), MediaType.MULTIPART_FORM_DATA_TYPE)
      
      postBody = mp
    }
    else {
      formParams += "grant_type" -> grantType.toString()
      formParams += "refresh_token" -> refreshToken.toString()
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "POST", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[RefreshTokenResponse]).asInstanceOf[RefreshTokenResponse])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
}
