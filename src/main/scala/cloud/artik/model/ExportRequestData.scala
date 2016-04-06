package cloud.artik.model




case class ExportRequestData (
  /* Add header to csv format */
  csvHeaders: Boolean,
  /* Timestamp of latest message (in milliseconds since epoch). */
  endDate: Long,
  /* Returned Export ID that should be used to check status and get the export result. */
  exportId: String,
  /* Format of the export. */
  format: String,
  /* Ascending or descending sort order. */
  order: String,
  /* Source Device IDs being searched for messages (Comma-separated for multiple Device IDs). */
  sdids: String,
  /* Source Device Type IDs being searched for messages (Comma-separated for multiple Device Type IDs). */
  sdtids: String,
  /* Timestamp of earliest message (in milliseconds since epoch). */
  startDate: Long,
  /* Trial ID being searched for messages. */
  trialId: String,
  /* Owner's user IDs being searched for messages (Comma-separated for multiple User IDs). */
  uids: String,
  /* URL added to successful email message. */
  url: String)
  
