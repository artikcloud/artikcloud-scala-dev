package cloud.artik.model




case class RefreshTokenResponse (
  access_token: String,
  expires_in: Long,
  refresh_token: String,
  token_type: String)
  
