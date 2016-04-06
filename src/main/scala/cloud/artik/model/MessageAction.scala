package cloud.artik.model




case class MessageAction (
  data: Map[String, Any],
  /* Destination Device ID. */
  ddid: String,
  /* Source Device ID. */
  sdid: String,
  /* Timestamp (past, present or future). Defaults to current time if not provided. */
  ts: Long,
  /* Type. */
  _type: String)
  
