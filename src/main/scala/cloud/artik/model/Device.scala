package cloud.artik.model




case class Device (
  /* Device ID */
  id: String,
  /* User ID */
  uid: String,
  /* Device Type ID */
  dtid: String,
  /* Name */
  name: String,
  /* Manifest Version */
  manifestVersion: Integer,
  /* Manifest Version Policy (LATEST, DEVICE) */
  manifestVersionPolicy: String,
  /* Needs Provider Authentication */
  needProviderAuth: Boolean,
  properties: Map[String, Any],
  /* Created On (milliseconds since epoch) */
  createdOn: Long,
  /* Is Connected */
  connected: Boolean,
  /* Certificate Info (if any) */
  certificateInfo: String,
  /* Certificate Signature (if any) */
  certificateSignature: String,
  /* External ID (if any) */
  eid: String,
  providerCredentials: Map[String, Any])
  
