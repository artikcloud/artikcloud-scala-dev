package cloud.artik.model




case class ActionOut (
  /* Message ID. */
  mid: String,
  /* User ID. */
  uid: String,
  /* Source Device Type ID. */
  sdtid: String,
  /* Created Timestamp (past, present or future). Defaults to current time if not provided. */
  cts: Long,
  /* Manifest Version. */
  mv: Integer)
  
