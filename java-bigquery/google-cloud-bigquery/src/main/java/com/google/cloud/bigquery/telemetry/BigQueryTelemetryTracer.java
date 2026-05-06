/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.telemetry;

import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.core.InternalApi;
import com.google.api.gax.tracing.ErrorTypeUtil;
import com.google.api.gax.tracing.ObservabilityAttributes;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;

/** BigQuery Telemetry class that stores generic telemetry attributes and values */
@InternalApi
public final class BigQueryTelemetryTracer {

  private BigQueryTelemetryTracer() {}

  public static final String BQ_GCP_CLIENT_SERVICE = "bigquery";
  public static final String BQ_GCP_CLIENT_REPO = "googleapis/google-cloud-java";
  public static final String BQ_GCP_CLIENT_ARTIFACT = "google-cloud-bigquery";

  // TODO: migrate to use gax attributes keys
  // https://github.com/googleapis/google-cloud-java/issues/12099
  // Common GCP Attributes
  public static final AttributeKey<String> GCP_CLIENT_SERVICE =
      AttributeKey.stringKey(ObservabilityAttributes.GCP_CLIENT_SERVICE_ATTRIBUTE);
  public static final AttributeKey<String> GCP_CLIENT_VERSION =
      AttributeKey.stringKey("gcp.client.version");
  public static final AttributeKey<String> GCP_CLIENT_REPO =
      AttributeKey.stringKey(ObservabilityAttributes.REPO_ATTRIBUTE);
  public static final AttributeKey<String> GCP_CLIENT_ARTIFACT =
      AttributeKey.stringKey("gcp.client.artifact");
  public static final AttributeKey<String> GCP_RESOURCE_DESTINATION_ID =
      AttributeKey.stringKey(ObservabilityAttributes.DESTINATION_RESOURCE_ID_ATTRIBUTE);
  public static final AttributeKey<String> RPC_SYSTEM_NAME =
      AttributeKey.stringKey(ObservabilityAttributes.RPC_SYSTEM_NAME_ATTRIBUTE);

  // Common Error Attributes
  public static final AttributeKey<String> ERROR_TYPE =
      AttributeKey.stringKey(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE);
  public static final AttributeKey<String> EXCEPTION_TYPE =
      AttributeKey.stringKey(ObservabilityAttributes.EXCEPTION_TYPE_ATTRIBUTE);
  public static final AttributeKey<String> STATUS_MESSAGE =
      AttributeKey.stringKey(ObservabilityAttributes.STATUS_MESSAGE_ATTRIBUTE);

  public static final AttributeKey<String> URL_TEMPLATE =
      AttributeKey.stringKey(ObservabilityAttributes.URL_TEMPLATE_ATTRIBUTE);
  public static final AttributeKey<String> URL_DOMAIN =
      AttributeKey.stringKey(ObservabilityAttributes.URL_DOMAIN_ATTRIBUTE);

  public static void addCommonAttributeToSpan(Span span) {
    span.setAttribute(GCP_CLIENT_SERVICE, BQ_GCP_CLIENT_SERVICE)
        .setAttribute(GCP_CLIENT_REPO, BQ_GCP_CLIENT_REPO)
        .setAttribute(GCP_CLIENT_ARTIFACT, BQ_GCP_CLIENT_ARTIFACT)
        .setAttribute(GCP_CLIENT_VERSION, Version.VERSION);
  }

  /**
   * Adds the following error attributes to trace span: STATUS_MESSAGE: the name of the exception +
   * message if available EXCEPTION_TYPE: full name of exception ex: java.net.UnknownHostException
   * ERROR_TYPE: mapped string based on {@link ErrorTypeUtil#getClientErrorType(Exception)}
   */
  public static void addExceptionToSpan(Exception e, Span span) {
    span.recordException(e);
    String message = e.getMessage();
    String simpleName = e.getClass().getSimpleName();
    String statusMessage = simpleName + (message != null ? ": " + message : "");
    span.setAttribute(BigQueryTelemetryTracer.EXCEPTION_TYPE, e.getClass().getName());
    span.setAttribute(BigQueryTelemetryTracer.ERROR_TYPE, ErrorTypeUtil.extractErrorType(e));
    span.setAttribute(BigQueryTelemetryTracer.STATUS_MESSAGE, statusMessage);
    span.setStatus(StatusCode.ERROR, statusMessage);
  }

  /**
   * Adds the following error attributes to trace span from GoogleJsonResponseException:
   * STATUS_MESSAGE: user readable error message ERROR_TYPE: reason if available otherwise the
   * status code
   */
  public static void addServerErrorResponseToSpan(
      GoogleJsonResponseException errorResponse, Span span) {
    span.setStatus(StatusCode.ERROR);
    // set default values in case details aren't available below
    if (errorResponse.getDetails() != null) {
      span.setAttribute(
          BigQueryTelemetryTracer.STATUS_MESSAGE, errorResponse.getDetails().getMessage());
    } else {
      span.setAttribute(BigQueryTelemetryTracer.STATUS_MESSAGE, errorResponse.getStatusMessage());
    }
    span.setAttribute(
        BigQueryTelemetryTracer.ERROR_TYPE, Integer.toString(errorResponse.getStatusCode()));

    // reads error details from GoogleJsonResponseException and override any available error details
    if (errorResponse.getDetails() != null
        && errorResponse.getDetails().getErrors() != null
        && !errorResponse.getDetails().getErrors().isEmpty()) {
      GoogleJsonError.ErrorInfo errorInfo = errorResponse.getDetails().getErrors().get(0);
      String message = errorInfo.getMessage();
      if (message != null) {
        span.setAttribute(BigQueryTelemetryTracer.STATUS_MESSAGE, message);
      }
      String reason = errorInfo.getReason();
      if (reason != null) {
        span.setAttribute(BigQueryTelemetryTracer.ERROR_TYPE, reason);
      }
    }
  }
}
