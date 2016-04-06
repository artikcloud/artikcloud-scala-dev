package cloud.artik.model




case class RuleUpdateInfo (
  /* Description */
  description: String,
  /* Is Enabled */
  enabled: Boolean,
  /* Name */
  name: String,
  /* Rule */
  rule: Map[String, Any])
  
