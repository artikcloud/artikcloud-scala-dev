package cloud.artik.model




case class NormalizedMessagesEnvelope (
  sdids: String,
  sdid: String,
  uid: String,
  startDate: Long,
  endDate: Long,
  order: String,
  next: String,
  count: Long,
  size: Long,
  data: List[NormalizedMessage])
  
