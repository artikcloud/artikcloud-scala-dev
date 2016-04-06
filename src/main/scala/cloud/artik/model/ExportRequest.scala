package cloud.artik.model




case class ExportRequest (
  endDate: Long,
  format: String,
  order: String,
  sdids: String,
  sdtids: String,
  startDate: Long,
  trialId: String,
  uids: String)
  
