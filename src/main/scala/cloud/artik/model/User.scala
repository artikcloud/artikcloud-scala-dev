package cloud.artik.model




case class User (
  id: String,
  name: String,
  email: String,
  fullName: String,
  saIdentity: String,
  createdOn: Long,
  modifiedOn: Long)
  
