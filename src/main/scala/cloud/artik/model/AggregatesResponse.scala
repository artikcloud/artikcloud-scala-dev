package cloud.artik.model




case class AggregatesResponse (
  data: List[AggregateData],
  endDate: Long,
  field: String,
  sdid: String,
  size: Integer,
  startDate: Long)
  
