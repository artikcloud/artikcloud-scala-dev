package cloud.artik.model




case class RegisterMessage (
  /* Confirmation ID. */
  cid: String,
  /* Authorization header containing access token (Bearer <access_token>). */
  authorization: String,
  /* Source Device ID. */
  sdid: String,
  /* Timestamp (past, present or future). Defaults to current time if not provided. */
  ts: Long,
  /* Type. */
  _type: String)
  
