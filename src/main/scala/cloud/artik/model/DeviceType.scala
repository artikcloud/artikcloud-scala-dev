package cloud.artik.model




case class DeviceType (
  /* Device Type ID. */
  id: String,
  /* Unique Name. */
  uniqueName: String,
  /* Latest Manifest version. */
  latestVersion: Integer,
  lastUpdated: Long,
  /* Name. */
  name: String,
  /* Description. */
  description: String,
  /* User ID. */
  uid: String,
  /* Organization ID. */
  oid: String,
  /* Uses Cloud Connectors SDK */
  hasCloudConnector: Boolean,
  /* Approval status. */
  approved: Boolean,
  /* Published status. */
  published: Boolean,
  /* Protected status. */
  _protected: Boolean,
  /* In Store. */
  inStore: Boolean,
  /* Does the current user own a device of this device type */
  ownedByCurrentUser: Boolean,
  /* Tags */
  tags: List[Tag],
  /* Require Secure Device Registration (SDR) Protocol. */
  rsp: Boolean,
  /* Issuer Distinguished Name (Used in SDR) */
  issuerDn: String,
  /* Vendor ID. (Used in SDR) */
  vid: String)
  
