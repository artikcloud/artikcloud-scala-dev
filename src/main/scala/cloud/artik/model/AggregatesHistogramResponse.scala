package cloud.artik.model




case class AggregatesHistogramResponse (
  data: List[AggregatesHistogramData],
  endDate: Long,
  field: String,
  interval: String,
  sdid: String,
  size: Long,
  startDate: Long)
  
