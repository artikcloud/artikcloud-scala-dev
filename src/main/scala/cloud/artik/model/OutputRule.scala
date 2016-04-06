package cloud.artik.model




case class OutputRule (
  aid: String,
  createdOn: Long,
  description: String,
  enabled: Boolean,
  error: RuleError,
  id: String,
  index: Integer,
  invalidatedOn: Long,
  languageVersion: Integer,
  modifiedOn: Long,
  name: String,
  rule: Map[String, Any],
  uid: String,
  warning: RuleWarningOutput)
  
