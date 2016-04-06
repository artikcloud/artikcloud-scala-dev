package cloud.artik.model




case class NormalizedMessage (
  cts: Long,
  ts: Long,
  mid: String,
  sdid: String,
  sdtid: String,
  uid: String,
  mv: Integer,
  data: Map[String, Any])
  
