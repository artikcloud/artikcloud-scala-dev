package cloud.artik.api

import cloud.artik.model.NormalizedMessagesEnvelope
import cloud.artik.model.MessageAction
import cloud.artik.model.MessageIDEnvelope
import cloud.artik.model.AggregatesResponse
import cloud.artik.model.AggregatesHistogramResponse
import cloud.artik.model.FieldPresenceEnvelope
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import javax.ws.rs.core.MediaType

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class MessagesApi(val defBasePath: String = "https://api.artik.cloud/v1.1",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  
  /**
   * Get Normalized Messages
   * Get the messages normalized
   * @param uid User ID. If not specified, assume that of the current authenticated user. If specified, it must be that of a user for which the current authenticated user has read access to.
   * @param sdid Source device ID of the messages being searched.
   * @param mid The SAMI message ID being searched.
   * @param fieldPresence String representing a field from the specified device ID.
   * @param filter Filter.
   * @param offset A string that represents the starting item, should be the value of &#39;next&#39; field received in the last response. (required for pagination)
   * @param count count
   * @param startDate startDate
   * @param endDate endDate
   * @param order Desired sort order: &#39;asc&#39; or &#39;desc&#39;
   * @return NormalizedMessagesEnvelope
   */
  def getNormalizedMessages (uid: String, sdid: String, mid: String, fieldPresence: String, filter: String, offset: String, count: Integer, startDate: Long, endDate: Long, order: String) : Option[NormalizedMessagesEnvelope] = {
    // create path and map variables
    val path = "/messages".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(uid) != "null") queryParams += "uid" -> uid.toString
    if(String.valueOf(sdid) != "null") queryParams += "sdid" -> sdid.toString
    if(String.valueOf(mid) != "null") queryParams += "mid" -> mid.toString
    if(String.valueOf(fieldPresence) != "null") queryParams += "fieldPresence" -> fieldPresence.toString
    if(String.valueOf(filter) != "null") queryParams += "filter" -> filter.toString
    if(String.valueOf(offset) != "null") queryParams += "offset" -> offset.toString
    if(String.valueOf(count) != "null") queryParams += "count" -> count.toString
    if(String.valueOf(startDate) != "null") queryParams += "startDate" -> startDate.toString
    if(String.valueOf(endDate) != "null") queryParams += "endDate" -> endDate.toString
    if(String.valueOf(order) != "null") queryParams += "order" -> order.toString
    
    
    

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
           Some(ApiInvoker.deserialize(s, "", classOf[NormalizedMessagesEnvelope]).asInstanceOf[NormalizedMessagesEnvelope])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Send Message Action
   * Send a message or an Action:&lt;br/&gt;&lt;table&gt;&lt;tr&gt;&lt;th&gt;Combination&lt;/th&gt;&lt;th&gt;Parameters&lt;/th&gt;&lt;th&gt;Description&lt;/th&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;Send Message&lt;/td&gt;&lt;td&gt;sdid, type=message&lt;/td&gt;&lt;td&gt;Send a message from a Source Device&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;Send Action&lt;/td&gt;&lt;td&gt;ddid, type=action&lt;/td&gt;&lt;td&gt;Send an action to a Destination Device&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;Common&lt;/td&gt;&lt;td&gt;data, ts, token&lt;/td&gt;&lt;td&gt;Parameters that can be used with the above combinations.&lt;/td&gt;&lt;/tr&gt;&lt;/table&gt;
   * @param data Message or Action object that is passed in the body
   * @return MessageIDEnvelope
   */
  def sendMessageAction (data: MessageAction) : Option[MessageIDEnvelope] = {
    // create path and map variables
    val path = "/messages".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    
    
    

    var postBody: AnyRef = data

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "POST", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[MessageIDEnvelope]).asInstanceOf[MessageIDEnvelope])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get Normalized Message Aggregates
   * Get Aggregates on normalized messages.
   * @param sdid Source device ID of the messages being searched.
   * @param field Message field being queried for aggregates.
   * @param startDate Timestamp of earliest message (in milliseconds since epoch).
   * @param endDate Timestamp of latest message (in milliseconds since epoch).
   * @return AggregatesResponse
   */
  def getMessageAggregates (sdid: String, field: String, startDate: Long, endDate: Long) : Option[AggregatesResponse] = {
    // create path and map variables
    val path = "/messages/analytics/aggregates".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(sdid) != "null") queryParams += "sdid" -> sdid.toString
    if(String.valueOf(field) != "null") queryParams += "field" -> field.toString
    if(String.valueOf(startDate) != "null") queryParams += "startDate" -> startDate.toString
    if(String.valueOf(endDate) != "null") queryParams += "endDate" -> endDate.toString
    
    
    

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
           Some(ApiInvoker.deserialize(s, "", classOf[AggregatesResponse]).asInstanceOf[AggregatesResponse])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get Histogram aggregates
   * Get Histogram on normalized messages.
   * @param startDate Timestamp of earliest message (in milliseconds since epoch).
   * @param endDate Timestamp of latest message (in milliseconds since epoch).
   * @param sdid Source device ID of the messages being searched.
   * @param field Message field being queried for building histogram.
   * @param interval Interval of time for building histogram blocks. (Valid values: minute, hour, day, month, year)
   * @return AggregatesHistogramResponse
   */
  def getAggregatesHistogram (startDate: Long, endDate: Long, sdid: String, field: String, interval: String) : Option[AggregatesHistogramResponse] = {
    // create path and map variables
    val path = "/messages/analytics/histogram".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(startDate) != "null") queryParams += "startDate" -> startDate.toString
    if(String.valueOf(endDate) != "null") queryParams += "endDate" -> endDate.toString
    if(String.valueOf(sdid) != "null") queryParams += "sdid" -> sdid.toString
    if(String.valueOf(field) != "null") queryParams += "field" -> field.toString
    if(String.valueOf(interval) != "null") queryParams += "interval" -> interval.toString
    
    
    

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
           Some(ApiInvoker.deserialize(s, "", classOf[AggregatesHistogramResponse]).asInstanceOf[AggregatesHistogramResponse])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get Last Normalized Message
   * Get last messages normalized.
   * @param count Number of items to return per query.
   * @param sdids Comma separated list of source device IDs (minimum: 1).
   * @param fieldPresence String representing a field from the specified device ID.
   * @return NormalizedMessagesEnvelope
   */
  def getLastNormalizedMessages (count: Integer, sdids: String, fieldPresence: String) : Option[NormalizedMessagesEnvelope] = {
    // create path and map variables
    val path = "/messages/last".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(count) != "null") queryParams += "count" -> count.toString
    if(String.valueOf(sdids) != "null") queryParams += "sdids" -> sdids.toString
    if(String.valueOf(fieldPresence) != "null") queryParams += "fieldPresence" -> fieldPresence.toString
    
    
    

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
           Some(ApiInvoker.deserialize(s, "", classOf[NormalizedMessagesEnvelope]).asInstanceOf[NormalizedMessagesEnvelope])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get normalized message presence
   * Get normalized message presence.
   * @param startDate startDate
   * @param endDate endDate
   * @param interval String representing grouping interval. One of: &#39;minute&#39; (1 hour limit), &#39;hour&#39; (1 day limit), &#39;day&#39; (31 days limit), &#39;month&#39; (1 year limit), or &#39;year&#39; (10 years limit).
   * @param sdid Source device ID of the messages being searched.
   * @param fieldPresence String representing a field from the specified device ID.
   * @return FieldPresenceEnvelope
   */
  def getFieldPresence (startDate: Long, endDate: Long, interval: String, sdid: String, fieldPresence: String) : Option[FieldPresenceEnvelope] = {
    // create path and map variables
    val path = "/messages/presence".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(sdid) != "null") queryParams += "sdid" -> sdid.toString
    if(String.valueOf(fieldPresence) != "null") queryParams += "fieldPresence" -> fieldPresence.toString
    if(String.valueOf(startDate) != "null") queryParams += "startDate" -> startDate.toString
    if(String.valueOf(endDate) != "null") queryParams += "endDate" -> endDate.toString
    if(String.valueOf(interval) != "null") queryParams += "interval" -> interval.toString
    
    
    

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
           Some(ApiInvoker.deserialize(s, "", classOf[FieldPresenceEnvelope]).asInstanceOf[FieldPresenceEnvelope])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
}
