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

package io.gapi.gax.grpc;

import com.google.auth.Credentials;

import io.grpc.ManagedChannel;

/**
 * A settings class to configure a service api class.
 */
public class ServiceApiSettings {
  private boolean isIdempotentRetrying;

  private Credentials credentials;

  private String serviceAddress;
  private int port;

  private ManagedChannel channel;

  public ServiceApiSettings() {
    isIdempotentRetrying = true;
    credentials = null;
    serviceAddress = null;
    port = 0;
  }

  /**
   * Set to true in order to have the service retry all idempotent methods,
   * set to false otherwise. The default is true. This setting generally translates to
   * doing retries for calls which perform gets, deletes, and updates, but not calls which
   * perform creates.
   */
  public ServiceApiSettings setIsIdempotentRetrying(boolean isIdempotentRetrying) {
    this.isIdempotentRetrying = isIdempotentRetrying;
    return this;
  }

  public boolean getIsIdempotentRetrying() {
    return isIdempotentRetrying;
  }

  /**
   * Sets the credentials to use in order to call the service. The default is to acquire
   * the credentials using GoogleCredentials.getApplicationDefault(). These credentials
   * will not be used if the channel is set.
   */
  public ServiceApiSettings setCredentials(Credentials credentials) {
    this.credentials = credentials;
    return this;
  }

  public Credentials getCredentials() {
    return credentials;
  }

  /**
   * The path used to reach the service. This value will not be used if the channel is set.
   */
  public ServiceApiSettings setServiceAddress(String serviceAddress) {
    this.serviceAddress = serviceAddress;
    return this;
  }

  public String getServiceAddress() {
    return serviceAddress;
  }

  /**
   * The port used to reach the service. This value will not be used if the channel is set.
   */
  public ServiceApiSettings setPort(int port) {
    this.port = port;
    return this;
  }

  public int getPort() {
    return port;
  }

  /**
   * The channel used to send requests to the service. Whichever service api class that
   * this instance of ServiceApiSettings is passed to will call shutdown() on this
   * channel. This injection mechanism is intended for use by unit tests to override
   * the channel that would be created by default for real calls to the service.
   */
  public ServiceApiSettings setChannel(ManagedChannel channel) {
    this.channel = channel;
    return this;
  }

  public ManagedChannel getChannel() {
    return channel;
  }
}
