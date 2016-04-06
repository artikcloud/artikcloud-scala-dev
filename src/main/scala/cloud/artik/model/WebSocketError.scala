package cloud.artik.model




case class WebSocketError (
  /* Message. */
  message: String,
  /* Code */
  code: Integer,
  /* Confirmation ID */
  cid: String)
  
