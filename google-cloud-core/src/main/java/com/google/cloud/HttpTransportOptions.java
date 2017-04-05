/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud;

import static com.google.common.base.MoreObjects.firstNonNull;

import com.google.api.client.extensions.appengine.http.UrlFetchTransport;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.auth.Credentials;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.http.HttpTransportFactory;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Objects;

/**
 * Class representing service options for those services that use HTTP as the transport
 * layer.
 */
public class HttpTransportOptions implements TransportOptions {

  private static final long serialVersionUID = 7890117765045419810L;
  private final int connectTimeout;
  private final int readTimeout;
  private final String httpTransportFactoryClassName;

  private transient HttpTransportFactory httpTransportFactory;

  public static class DefaultHttpTransportFactory implements HttpTransportFactory {

    private static final HttpTransportFactory INSTANCE = new DefaultHttpTransportFactory();

    @Override
    public HttpTransport create() {
      // Consider App Engine
      if (ServiceOptions.getAppEngineAppId() != null) {
        try {
          return new UrlFetchTransport();
        } catch (Exception ignore) {
          // Maybe not on App Engine
        }
      }
      return new NetHttpTransport();
    }
  }

  /**
   * Builder for {@code HttpTransportOptions}.
   */
  public static class Builder {

    private HttpTransportFactory httpTransportFactory;
    private int connectTimeout = -1;
    private int readTimeout = -1;

    private Builder() {}

    private Builder(HttpTransportOptions options) {
      httpTransportFactory = options.httpTransportFactory;
      connectTimeout = options.connectTimeout;
      readTimeout = options.readTimeout;
    }

    public HttpTransportOptions build() {
      return new HttpTransportOptions(this);
    }

    /**
     * Sets the HTTP transport factory.
     *
     * @return the builder
     */
    public Builder setHttpTransportFactory(HttpTransportFactory httpTransportFactory) {
      this.httpTransportFactory = httpTransportFactory;
      return this;
    }

    /**
     * Sets the timeout in milliseconds to establish a connection.
     *
     * @param connectTimeout connection timeout in milliseconds. 0 for an infinite timeout, a
     *        negative number for the default value (20000).
     * @return the builder
     */
    public Builder setConnectTimeout(int connectTimeout) {
      this.connectTimeout = connectTimeout;
      return this;
    }

    /**
     * Sets the timeout in milliseconds to read data from an established connection.
     *
     * @param readTimeout read timeout in milliseconds. 0 for an infinite timeout, a negative number
     *        for the default value (20000).
     * @return the builder
     */
    public Builder setReadTimeout(int readTimeout) {
      this.readTimeout = readTimeout;
      return this;
    }
  }

  protected HttpTransportOptions(Builder builder) {
    httpTransportFactory = firstNonNull(builder.httpTransportFactory,
        ServiceOptions.getFromServiceLoader(HttpTransportFactory.class,
            DefaultHttpTransportFactory.INSTANCE));
    httpTransportFactoryClassName = httpTransportFactory.getClass().getName();
    connectTimeout = builder.connectTimeout;
    readTimeout = builder.readTimeout;
  }

  /**
   * Returns the HTTP transport factory.
   */
  public HttpTransportFactory getHttpTransportFactory() {
    return httpTransportFactory;
  }

  /**
   * Returns a request initializer responsible for initializing requests according to service
   * options.
   */
  public HttpRequestInitializer getHttpRequestInitializer(ServiceOptions<?, ?> serviceOptions) {
    Credentials scopedCredentials = serviceOptions.getScopedCredentials();
    final HttpRequestInitializer delegate =
        scopedCredentials != null && scopedCredentials != NoCredentials.getInstance()
            ? new HttpCredentialsAdapter(scopedCredentials) : null;
    return new HttpRequestInitializer() {
      @Override
      public void initialize(HttpRequest httpRequest) throws IOException {
        if (delegate != null) {
          delegate.initialize(httpRequest);
        }
        if (connectTimeout >= 0) {
          httpRequest.setConnectTimeout(connectTimeout);
        }
        if (readTimeout >= 0) {
          httpRequest.setReadTimeout(readTimeout);
        }

        HttpHeaders headers = httpRequest.getHeaders();
        headers.set("x-goog-api-client", getXGoogApiClientHeader());
      }
    };
  }

  String getXGoogApiClientHeader() {
    return String.format(
        "gl-java/%s %s/%s",
        getJavaVersion(),
        ServiceOptions.getGoogApiClientLibName(),
        ServiceOptions.getLibraryVersion());
  }

  private static String getJavaVersion() {
    String javaVersion = Runtime.class.getPackage().getImplementationVersion();
    return javaVersion != null ? javaVersion : "";
  }

  /**
   * Returns the timeout in milliseconds to establish a connection. 0 is an infinite timeout, a
   * negative number is the default value (20000).
   */
  public int getConnectTimeout() {
    return connectTimeout;
  }

  /**
   * Returns the timeout in milliseconds to read from an established connection. 0 is an infinite
   * timeout, a negative number is the default value (20000).
   */
  public int getReadTimeout() {
    return readTimeout;
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public int hashCode() {
    return Objects.hash(httpTransportFactoryClassName, connectTimeout,
        readTimeout);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    HttpTransportOptions other = (HttpTransportOptions) obj;
    return Objects.equals(httpTransportFactoryClassName, other.httpTransportFactoryClassName)
        && Objects.equals(connectTimeout, other.connectTimeout)
        && Objects.equals(readTimeout, other.readTimeout);
  }

  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();
    httpTransportFactory = ServiceOptions.newInstance(httpTransportFactoryClassName);
  }

  public static Builder newBuilder() {
    return new Builder();
  }
}
