package cloud.artik.model




case class ExportHistoryResponse (
  count: Long,
  data: ExportDataArray,
  offset: Long,
  total: Long)
  
