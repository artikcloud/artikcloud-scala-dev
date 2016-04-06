package cloud.artik.model




case class Token (
  access_token: String,
  expires_in: Long,
  scope: String,
  token_type: String)
  
