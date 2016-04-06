package cloud.artik.model




case class Acknowledgement (
  /* Message ID. */
  mid: String,
  /* Confirmation ID. */
  cid: String,
  /* Message. */
  message: String,
  /* Code */
  code: String)
  
