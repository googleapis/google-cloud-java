package com.google.gcloud.datastore;

import com.google.api.services.datastore.client.DatastoreException;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;
import com.google.gcloud.RetryHelper;
import com.google.gcloud.RetryHelper.RetryHelperException;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.HashMap;
import java.util.Map;

public class DatastoreServiceException extends RuntimeException {

  private static final long serialVersionUID = 8170357898917041899L;
  private static final ImmutableMap<String, Code> REASON_TO_CODE;
  private static final ImmutableMap<Integer, Code> HTTP_TO_CODE;

  private final Code code;

  /**
   * An error code to represent the failure.
   *
   * @see <a href="https://cloud.google.com/datastore/docs/concepts/errors#Error_Codes">Google Cloud Datastore error codes</a>
   */
  public enum Code {

    ABORTED(true, "Request aborted", 409),
    DEADLINE_EXCEEDED(true, "Deadline exceeded", 403),
    UNAVAILABLE(true, "Could not reach service", 503),
    FAILED_PRECONDITION(false, "Invalid request", 412),
    INVALID_ARGUMENT(false, "Request parameter has an invalid value", 400),
    PERMISSION_DENIED(false, "Unauthorized request", 403),
    UNAUTHORIZED(false, "Unauthorized", 401),
    RESOURCE_EXHAUSTED(false, "Quota exceeded", 402),
    INTERNAL(false, "Server returned an error", 500),
    UNKNOWN(false, "Unknown failure", -1);

    private final boolean isTransient;
    private final String defaultMessage;
    private final int httpCode;

    Code(boolean isTransient, String msg, int httpCode) {
      this.isTransient = isTransient;
      defaultMessage = msg;
      this.httpCode = httpCode;
    }

    public Integer httpCode() {
      return httpCode;
    }

    /**
     * Returns {@code true} if this exception is transient and the same request could be retried.
     * For any retry it is highly recommended to apply an exponential backoff.
     */
    public boolean isTransient() {
      return isTransient;
    }

    DatastoreServiceException translate(DatastoreException exception, String msg) {
      return new DatastoreServiceException(this, msg, exception);
    }
  }

  static {
    ImmutableMap.Builder<String, Code> builder = ImmutableMap.builder();
    Map<Integer, Code> httpCodes = new HashMap<>();
    for (Code code : Code.values()) {
      builder.put(code.name(), code);
      httpCodes.put(code.httpCode(), code);
    }
    REASON_TO_CODE = builder.build();
    HTTP_TO_CODE = ImmutableMap.copyOf(httpCodes);
  }

  public DatastoreServiceException(Code code, String msg, Exception cause) {
    super(MoreObjects.firstNonNull(msg, code.defaultMessage), cause);
    this.code = code;
  }

  public DatastoreServiceException(Code code, String msg) {
    this(code, msg, null);
  }

  /**
   * Returns the code associated with this exception.
   */
  public Code code() {
    return code;
  }

  static DatastoreServiceException translateAndThrow(RetryHelperException ex) {
    if (ex.getCause() instanceof DatastoreException) {
      return translateAndThrow((DatastoreException) ex.getCause());
    }
    if (ex instanceof RetryHelper.RetryInterruptedException) {
      RetryHelper.RetryInterruptedException.propagate();
    }
    throw new DatastoreServiceException(Code.UNKNOWN, ex.getMessage(), ex);
  }

  /**
   * Translate DatastoreException to DatastoreServiceException based on their
   * HTTP error codes. This method will always throw a new DatastoreServiceException.
   *
   * @throws DatastoreServiceException every time
   */
  static DatastoreServiceException translateAndThrow(DatastoreException exception) {
    String message = exception.getMessage();
    String reason = "";
    if (message != null) {
      try {
        JSONObject json = new JSONObject(new JSONTokener(exception.getMessage()));
        JSONObject error = json.getJSONObject("error").getJSONArray("errors").getJSONObject(0);
        reason = error.getString("reason");
        message = error.getString("message");
      } catch (JSONException ex) {
        // ignore - will be converted to unknown
      }
    }
    Code code = REASON_TO_CODE.get(reason);
    if (code == null) {
      code = MoreObjects.firstNonNull(HTTP_TO_CODE.get(exception.getCode()), Code.UNKNOWN);
    }
    throw code.translate(exception, message);
  }


  /**
   * Throw a DatastoreServiceException with {@code FAILED_PRECONDITION} code and the {@code msg}
   * in a nested exception.
   *
   * @throws DatastoreServiceException every time
   */
  static DatastoreServiceException throwInvalidRequest(String msg, Object... params) {
    throw new DatastoreServiceException(Code.FAILED_PRECONDITION, String.format(msg, params));
  }
}
