package cloud.artik.model




case class RuleCreationInfo (
  /* Description */
  description: String,
  /* Is Enabled */
  enabled: Boolean,
  /* Name */
  name: String,
  /* Rule */
  rule: Map[String, Any])
  
