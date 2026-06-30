/*
 * Copyright 2015, Google Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 *    * Neither the name of Google Inc. nor the names of its
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

package com.google.auth;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/** Represents an abstract authorized identity instance. */
public abstract class Credentials implements Serializable {

  private static final long serialVersionUID = 808575179767517313L;

  public static final String GOOGLE_DEFAULT_UNIVERSE = "googleapis.com";

  /**
   * A constant string name describing the authentication technology.
   *
   * <p>E.g. “OAuth2”, “SSL”. For use by the transport layer to determine whether it supports the
   * type of authentication in the case where {@link Credentials#hasRequestMetadataOnly} is false.
   * Also serves as a debugging helper.
   *
   * @return The type of authentication used.
   */
  public abstract String getAuthenticationType();

  /**
   * Gets the universe domain for the credential in a blocking manner, refreshing tokens if
   * required.
   *
   * @return a universe domain value in the format some-domain.xyz. By default, returns the Google
   *     universe domain googleapis.com.
   * @throws IOException extending classes might have to do remote calls to determine the universe
   *     domain. The exception must implement {@link Retryable} and {@code isRetryable()} will
   *     return true if the operation may be retried.
   */
  public String getUniverseDomain() throws IOException {
    return GOOGLE_DEFAULT_UNIVERSE;
  }

  /**
   * Gets the credential type used for internal metrics header.
   *
   * <p>The default is {@code CredentialTypeForMetrics.DO_NOT_SEND}. For a credential that is
   * established to track for metrics, this default should be overridden.
   *
   * @return a enum value for credential type
   */
  public CredentialTypeForMetrics getMetricsCredentialType() {
    return CredentialTypeForMetrics.DO_NOT_SEND;
  }

  /**
   * Get the current request metadata, refreshing tokens if required.
   *
   * <p>This should be called by the transport layer on each request, and the data should be
   * populated in headers or other context. The operation can block and fail to complete and may do
   * things such as refreshing access tokens.
   *
   * <p>The convention for handling binary data is for the key in the returned map to end with
   * {@code "-bin"} and for the corresponding values to be base64 encoded.
   *
   * @return The request metadata used for populating headers or other context.
   * @throws IOException if there was an error getting up-to-date access.
   */
  public Map<String, List<String>> getRequestMetadata() throws IOException {
    return getRequestMetadata(null);
  }

  /**
   * Get the current request metadata without blocking.
   *
   * <p>This should be called by the transport layer on each request, and the data should be
   * populated in headers or other context. The implementation can either call the callback inline
   * or asynchronously. Either way it should <strong>never block</strong> in this method. The
   * executor is provided for tasks that may block.
   *
   * <p>The default implementation will just call {@link #getRequestMetadata(URI)} then the callback
   * from the given executor.
   *
   * <p>The convention for handling binary data is for the key in the returned map to end with
   * {@code "-bin"} and for the corresponding values to be base64 encoded.
   *
   * @param uri URI of the entry point for the request.
   * @param executor Executor to perform the request.
   * @param callback Callback to execute when the request is finished.
   */
  public void getRequestMetadata(
      final URI uri, Executor executor, final RequestMetadataCallback callback) {
    executor.execute(
        new Runnable() {
          @Override
          public void run() {
            blockingGetToCallback(uri, callback);
          }
        });
  }

  /**
   * Call {@link #getRequestMetadata(URI)} and pass the result or error to the callback.
   *
   * @param uri URI of the entry point for the request.
   * @param callback Callback handler to execute when the metadata completes.
   */
  protected final void blockingGetToCallback(URI uri, RequestMetadataCallback callback) {
    Map<String, List<String>> result;
    try {
      result = getRequestMetadata(uri);
    } catch (Throwable e) {
      callback.onFailure(e);
      return;
    }
    callback.onSuccess(result);
  }

  /**
   * Get the current request metadata in a blocking manner, refreshing tokens if required.
   *
   * <p>This should be called by the transport layer on each request, and the data should be
   * populated in headers or other context. The operation can block and fail to complete and may do
   * things such as refreshing access tokens.
   *
   * <p>The convention for handling binary data is for the key in the returned map to end with
   * {@code "-bin"} and for the corresponding values to be base64 encoded.
   *
   * @param uri URI of the entry point for the request.
   * @return The request metadata used for populating headers or other context.
   * @throws IOException if there was an error getting up-to-date access. The exception should
   *     implement {@link Retryable} and {@code isRetryable()} will return true if the operation may
   *     be retried.
   */
  public abstract Map<String, List<String>> getRequestMetadata(URI uri) throws IOException;

  /**
   * Whether the credentials have metadata entries that should be added to each request.
   *
   * <p>This should be called by the transport layer to see if {@link
   * Credentials#getRequestMetadata} should be used for each request.
   *
   * @return Whether or not the transport layer should call {@link Credentials#getRequestMetadata}
   */
  public abstract boolean hasRequestMetadata();

  /**
   * Indicates whether or not the Auth mechanism works purely by including request metadata.
   *
   * <p>This is meant for the transport layer. If this is true a transport does not need to take
   * actions other than including the request metadata. If this is false, a transport must
   * specifically know about the authentication technology to support it, and should fail to accept
   * the credentials otherwise.
   *
   * @return Whether or not the Auth mechanism works purely by including request metadata.
   */
  public abstract boolean hasRequestMetadataOnly();

  /**
   * Refresh the authorization data, discarding any cached state.
   *
   * <p>For use by the transport to allow retry after getting an error indicating there may be
   * invalid tokens or other cached state.
   *
   * @throws IOException if there was an error getting up-to-date access.
   */
  public abstract void refresh() throws IOException;
}
