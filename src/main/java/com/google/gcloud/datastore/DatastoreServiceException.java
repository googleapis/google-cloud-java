package com.google.gcloud.datastore;

import static com.google.common.base.MoreObjects.firstNonNull;

import com.google.api.services.datastore.client.DatastoreException;

import java.util.HashMap;
import java.util.Map;

public class DatastoreServiceException extends RuntimeException {

  private static final long serialVersionUID = 8170357898917041899L;
  private static final Map<Integer, Code> HTTP_TO_CODE = new HashMap<>();

  private final Code code;

  /**
   * An error code to represent the failure.
   *
   * @see <a href="https://cloud.google.com/datastore/docs/concepts/errors#Error_Codes">Google Cloud Datastore error codes</a>
   */
  public enum Code {

    ABORTED(409, true, "Request aborted"),
    DEADLINE_EXCEEDED(403, true, "Deadline exceeded"),
    UNAVAILABLE(503, true, "Could not reach service"),
    FAILED_PRECONDITION(412, false, "Invalid request"),
    INVALID_ARGUMENT(400, false, "Request parameter has an invalid value"),
    PERMISSION_DENIED(403, false, "Unauthorized request"),
    RESOURCE_EXHAUSTED(402, false, "Quota exceeded"),
    INTERNAL(500, false, "Server returned an error"),
    UNKNOWN(0, false, "Unknown failure");

    private final boolean isTransient;
    private final String msg;

    Code(int httpStatus, boolean isTransient, String msg) {
      this.isTransient = isTransient;
      this.msg = msg;
      HTTP_TO_CODE.put(httpStatus, this);
    }

    /**
     * Returns {@code true} if this exception is transient and the same request could be retried.
     * For any retry it is highly recommended to apply an exponential backoff.
     */
    public boolean isTransient() {
      return isTransient;
    }

    DatastoreServiceException translate(DatastoreException exception) {
      return new DatastoreServiceException(this, exception);
    }
  }

  public DatastoreServiceException(Code code, Exception cause) {
    super(code.msg, cause);
    this.code = code;
  }

  /**
   * Returns the code associated with this exception.
   */
  public Code code() {
    return code;
  }

  /**
   * Translate DatastoreException to DatastoreServiceException based on their
   * HTTP error codes. This method will always throw a new DatastoreServiceException.
   *
   * @throws DatastoreServiceException every time
   */
  static DatastoreServiceException translateAndThrow(DatastoreException exception) {
    throw firstNonNull(HTTP_TO_CODE.get(exception.getCode()), Code.UNKNOWN).translate(exception);
  }

  /**
   * Throw a DatastoreServiceException with {@code FAILED_PRECONDITION} code and the {@code msg}
   * in a nested exception.
   *
   * @throws DatastoreServiceException every time
   */
  static DatastoreServiceException throwInvalidRequest(String msg, Object... params) {
    if (params.length > 0) {
      msg = String.format(msg, params);
    }
    throw new DatastoreServiceException(Code.FAILED_PRECONDITION, new RuntimeException(msg));
  }
}
