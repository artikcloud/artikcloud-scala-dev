package cloud.artik.model




case class FieldPresenceEnvelope (
  sdid: String,
  fieldPresence: String,
  startDate: Long,
  endDate: Long,
  interval: String,
  size: Long,
  data: List[FieldPresence])
  
