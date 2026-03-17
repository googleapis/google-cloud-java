package com.google.cloud.bigquery.telemetry;

/** Utility class for identifying exception types for telemetry tracking. */
public final class ExceptionTypeUtil {

  private ExceptionTypeUtil() {
    // Utility class, no instantiation
  }

  public static boolean isClientTimeout(Exception e) {
    return e instanceof java.net.SocketTimeoutException;
  }

  public static boolean isClientConnectionError(Exception e) {
    return e instanceof java.net.ConnectException
        || e instanceof java.net.UnknownHostException
        || e instanceof javax.net.ssl.SSLHandshakeException;
  }

  public static boolean isHttpResponseException(Exception e) {
    return e instanceof com.google.api.client.http.HttpResponseException;
  }

  public static boolean isClientResponseDecodeError(Exception e) {
    return e.getClass().getName().contains("Json")
        || e.getClass().getName().contains("Gson")
        || (e.getCause() != null && e.getCause().getClass().getName().contains("Gson"));
  }

  public static boolean isClientRedirectError(Exception e) {
    return e.getMessage() != null && e.getMessage().contains("redirect");
  }

  public static boolean isClientAuthenticationError(Exception e) {
    return e.getClass().getName().contains("GoogleAuthException");
  }

  public static boolean isClientRequestError(Exception e) {
    return e instanceof java.lang.IllegalArgumentException;
  }
}
