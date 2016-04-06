package cloud.artik.model




case class UnregisterDeviceResponse (
  /* Device certificate information. */
  certificateInfo: String,
  /* Certificate's signature. */
  certificateSignature: String,
  /* Device created on date. */
  createdOn: Long,
  /* Device type id. */
  dtid: String,
  /* External ID of the device. */
  eid: String,
  /* Device id. */
  id: String,
  /* Device manifest version. */
  manifestVersion: Long,
  /* Device manifest version policy. */
  manifestVersionPolicy: String,
  /* Device name. */
  name: String,
  /* Device need provider auth. */
  needProviderAuth: Boolean,
  /* User id. */
  uid: String)
  
