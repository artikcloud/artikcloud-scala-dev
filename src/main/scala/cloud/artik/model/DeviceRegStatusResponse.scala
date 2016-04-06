package cloud.artik.model




case class DeviceRegStatusResponse (
  /* The created or existing device id. */
  did: String,
  /* Status of the ongoing device registration request. */
  status: String)
  
