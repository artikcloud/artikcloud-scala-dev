package cloud.artik.model




case class ExportData (
  expirationDate: Long,
  exportId: String,
  fileSize: Long,
  md5: String,
  request: ExportRequest,
  /* Export status */
  status: String,
  totalMessages: Long)
  
