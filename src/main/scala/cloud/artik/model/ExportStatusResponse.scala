package cloud.artik.model




case class ExportStatusResponse (
  expirationDate: Long,
  exportId: String,
  md5: String,
  /* Export status */
  status: String,
  ttl: String)
  
