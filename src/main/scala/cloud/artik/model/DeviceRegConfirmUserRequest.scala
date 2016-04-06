package cloud.artik.model




case class DeviceRegConfirmUserRequest (
  /* Device ID. Optional if deviceName is present */
  deviceId: String,
  /* Device Name. Optional if deviceId is present */
  deviceName: String,
  /* Pin obtained in the registrations call. */
  pin: String)
  
