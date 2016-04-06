package cloud.artik.model




case class RuleError (
  errorCode: Integer,
  fieldPath: FieldPath,
  messageArgs: List[String],
  messageKey: String)
  
