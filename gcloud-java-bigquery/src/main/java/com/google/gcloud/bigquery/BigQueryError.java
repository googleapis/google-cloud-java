package com.google.gcloud.bigquery;

import com.google.api.services.bigquery.model.ErrorProto;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Objects;

/**
 * Google Cloud BigQuery Error. Objects of this class represent errors encountered by the BigQuery
 * service while executing a request. A BigQuery Job that terminated with an error has a non-null
 * {@link JobStatus#error()}. A job can also encounter errors during its execution that do not cause
 * the whole job to fail (see {@link JobStatus#executionErrors()}). Similarly, queries and insert
 * all requests can cause BigQuery errors that do not mean the whole operation failed (see
 * {@link QueryResponse#executionErrors()} and {@link InsertAllResponse#insertErrors()}). When a
 * {@link BigQueryException} is thrown the BigQuery Error that caused it, if any, can be accessed
 * with {@link BigQueryException#error()}.
 */
public class BigQueryError implements Serializable {

  static final Function<ErrorProto, BigQueryError> FROM_PB_FUNCTION =
      new Function<ErrorProto, BigQueryError>() {
        @Override
        public BigQueryError apply(ErrorProto pb) {
          return BigQueryError.fromPb(pb);
        }
      };
  static final Function<BigQueryError, ErrorProto> TO_PB_FUNCTION =
      new Function<BigQueryError, ErrorProto>() {
        @Override
        public ErrorProto apply(BigQueryError error) {
          return error.toPb();
        }
      };
  private static final long serialVersionUID = -6566785320629096688L;

  private final String reason;
  private final String location;
  private final String debugInfo;
  private final String message;

  public BigQueryError(String reason, String location, String message, String debugInfo) {
    this.reason = reason;
    this.location = location;
    this.debugInfo = debugInfo;
    this.message = message;
  }

  public BigQueryError(String reason, String location, String message) {
    this.reason = reason;
    this.location = location;
    this.message = message;
    this.debugInfo = null;
  }

  /**
   * Returns short error code that summarizes the error.
   *
   * @see <a href="https://cloud.google.com/bigquery/troubleshooting-errors">Troubleshooting
   *     Errors</a>
   */
  public String reason() {
    return reason;
  }

  /**
   * Returns where the error occurred, if present.
   */
  public String location() {
    return location;
  }

  String debugInfo() {
    return debugInfo;
  }

  /**
   * Returns a human-readable description of the error.
   */
  public String message() {
    return message;
  }

  @Override
  public int hashCode() {
    return Objects.hash(reason, location, message);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("reason", reason)
        .add("location", location)
        .add("message", message)
        .toString();
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof BigQueryError && Objects.equals(toPb(), ((BigQueryError) obj).toPb());
  }

  ErrorProto toPb() {
    ErrorProto errorPb = new ErrorProto();
    if (reason != null) {
      errorPb.setReason(reason);
    }
    if (location != null) {
      errorPb.setLocation(location);
    }
    if (message != null) {
      errorPb.setMessage(message);
    }
    if (debugInfo != null) {
      errorPb.setDebugInfo(debugInfo);
    }
    return errorPb;
  }

  static BigQueryError fromPb(ErrorProto errorPb) {
    return new BigQueryError(errorPb.getReason(), errorPb.getLocation(), errorPb.getMessage(),
        errorPb.getDebugInfo());
  }
}
