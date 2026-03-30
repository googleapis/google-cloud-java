/*
 * Copyright 2026 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.google.api.gax.tracing;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;

/**
 * Utility class with common attribute names in app-centric observability.
 *
 * <p>For internal use only.
 */
@InternalApi
@BetaApi
public class ObservabilityAttributes {
  /** The address of the server being called (e.g., "pubsub.googleapis.com"). */
  public static final String SERVER_ADDRESS_ATTRIBUTE = "server.address";

  /** The port of the server being called (e.g., 443). */
  public static final String SERVER_PORT_ATTRIBUTE = "server.port";

  /** The repository of the client library (e.g., "googleapis/google-cloud-java"). */
  public static final String REPO_ATTRIBUTE = "gcp.client.repo";

  /** The artifact name of the client library (e.g., "google-cloud-vision"). */
  public static final String ARTIFACT_ATTRIBUTE = "gcp.client.artifact";

  /** The version of the client library (e.g., "1.2.3"). */
  public static final String VERSION_ATTRIBUTE = "gcp.client.version";

  /** The full RPC method name, including package, service, and method. */
  public static final String GRPC_RPC_METHOD_ATTRIBUTE = "rpc.method";

  /** The RPC system name, e.g. 'grpc' or 'http'. */
  public static final String RPC_SYSTEM_NAME_ATTRIBUTE = "rpc.system.name";

  /** The HTTP method of the request (e.g., "GET"). Only used in HTTP transport. */
  public static final String HTTP_METHOD_ATTRIBUTE = "http.request.method";

  /**
   * The HTTP URL template of the request (e.g. "/v1/{name}:access"). Only used in HTTP transport.
   */
  public static final String HTTP_URL_TEMPLATE_ATTRIBUTE = "url.template";

  /**
   * The error codes of the request. The value will be the string representation of the canonical
   * gRPC status code (e.g., "OK", "INTERNAL").
   */
  public static final String RPC_RESPONSE_STATUS_ATTRIBUTE = "rpc.response.status_code";

  /** The service name of a client (e.g. "bigtable", "spanner"). */
  public static final String GCP_CLIENT_SERVICE_ATTRIBUTE = "gcp.client.service";

  /** The url domain of the request (e.g. "pubsub.googleapis.com"). */
  public static final String URL_DOMAIN_ATTRIBUTE = "url.domain";

  /** The url template of the request (e.g. /v1/{name}:access). */
  public static final String URL_TEMPLATE_ATTRIBUTE = "url.template";

  /** Size of the response body in bytes. */
  public static final String HTTP_RESPONSE_BODY_SIZE = "http.response.body.size";

  /** The resend count of the request. Only used in HTTP transport. */
  public static final String HTTP_RESEND_COUNT_ATTRIBUTE = "http.request.resend_count";

  /** The resend count of the request. Only used in gRPC transport. */
  public static final String GRPC_RESEND_COUNT_ATTRIBUTE = "gcp.grpc.resend_count";

  /** The destination resource id of the request (e.g. projects/p/locations/l/topics/t). */
  public static final String DESTINATION_RESOURCE_ID_ATTRIBUTE = "gcp.resource.destination.id";

  /** The full URL of the HTTP request, with sensitive query parameters redacted. */
  public static final String HTTP_URL_FULL_ATTRIBUTE = "url.full";

  /** The type of error that occurred (e.g., from google.rpc.ErrorInfo.reason). */
  public static final String ERROR_TYPE_ATTRIBUTE = "error.type";

  /** The domain of the error (e.g., from google.rpc.ErrorInfo.domain). */
  public static final String ERROR_DOMAIN_ATTRIBUTE = "gcp.errors.domain";

  /** The prefix for error metadata (e.g., from google.rpc.ErrorInfo.metadata). */
  public static final String ERROR_METADATA_ATTRIBUTE_PREFIX = "gcp.errors.metadata.";
}
