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
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.auth.Credentials;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.http.HttpTransportFactory;
import com.google.cloud.spi.ServiceRpcFactory;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Objects;

/**
 * Abstract class representing service options for those services that use HTTP as the transport
 * layer.
 *
 * @param <ServiceT> the service subclass
 * @param <ServiceRpcT> the spi-layer class corresponding to the service
 * @param <OptionsT> the {@code ServiceOptions} subclass corresponding to the service
 */
public abstract class HttpServiceOptions<ServiceT extends Service<OptionsT>, ServiceRpcT,
    OptionsT extends HttpServiceOptions<ServiceT, ServiceRpcT, OptionsT>>
    extends ServiceOptions<ServiceT, ServiceRpcT, OptionsT> {

  private static final long serialVersionUID = 4765436436821178975L;
  private final int connectTimeout;
  private final int readTimeout;
  private final String httpTransportFactoryClassName;

  private transient HttpTransportFactory httpTransportFactory;

  public static class DefaultHttpTransportFactory implements HttpTransportFactory {

    private static final HttpTransportFactory INSTANCE = new DefaultHttpTransportFactory();

    @Override
    public HttpTransport create() {
      // Consider App Engine
      if (getAppEngineAppId() != null) {
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
   * Builder for {@code HttpServiceOptions}.
   *
   * @param <ServiceT> the service subclass
   * @param <ServiceRpcT> the spi-layer class corresponding to the service
   * @param <OptionsT> the {@code HttpServiceOptions} subclass corresponding to the service
   * @param <B> the {@code ServiceOptions} builder
   */
  protected abstract static class Builder<ServiceT extends Service<OptionsT>, ServiceRpcT,
      OptionsT extends HttpServiceOptions<ServiceT, ServiceRpcT, OptionsT>,
      B extends Builder<ServiceT, ServiceRpcT, OptionsT, B>>
      extends ServiceOptions.Builder<ServiceT, ServiceRpcT, OptionsT, B> {

    private HttpTransportFactory httpTransportFactory;
    private int connectTimeout = -1;
    private int readTimeout = -1;

    protected Builder() {}

    protected Builder(HttpServiceOptions<ServiceT, ServiceRpcT, OptionsT> options) {
      super(options);
      httpTransportFactory = options.httpTransportFactory;
      connectTimeout = options.connectTimeout;
      readTimeout = options.readTimeout;
    }

    @Override
    protected abstract HttpServiceOptions<ServiceT, ServiceRpcT, OptionsT> build();

    @Override
    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }

    /**
     * Sets the HTTP transport factory.
     *
     * @return the builder
     */
    public B setHttpTransportFactory(HttpTransportFactory httpTransportFactory) {
      this.httpTransportFactory = httpTransportFactory;
      return self();
    }

    /**
     * Sets the timeout in milliseconds to establish a connection.
     *
     * @param connectTimeout connection timeout in milliseconds. 0 for an infinite timeout, a
     *        negative number for the default value (20000).
     * @return the builder
     */
    public B setConnectTimeout(int connectTimeout) {
      this.connectTimeout = connectTimeout;
      return self();
    }

    /**
     * Sets the timeout in milliseconds to read data from an established connection.
     *
     * @param readTimeout read timeout in milliseconds. 0 for an infinite timeout, a negative number
     *        for the default value (20000).
     * @return the builder
     */
    public B setReadTimeout(int readTimeout) {
      this.readTimeout = readTimeout;
      return self();
    }
  }

  protected HttpServiceOptions(
      Class<? extends ServiceFactory<ServiceT, OptionsT>> serviceFactoryClass,
      Class<? extends ServiceRpcFactory<ServiceRpcT, OptionsT>> rpcFactoryClass, Builder<ServiceT,
      ServiceRpcT, OptionsT, ?> builder) {
    super(serviceFactoryClass, rpcFactoryClass, builder);
    httpTransportFactory = firstNonNull(builder.httpTransportFactory,
        getFromServiceLoader(HttpTransportFactory.class, DefaultHttpTransportFactory.INSTANCE));
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
  public HttpRequestInitializer getHttpRequestInitializer() {
    Credentials scopedCredentials = getScopedCredentials();
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
      }
    };
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

  @Override
  protected int baseHashCode() {
    return Objects.hash(super.baseHashCode(), httpTransportFactoryClassName, connectTimeout,
        readTimeout);
  }

  protected boolean baseEquals(HttpServiceOptions<?, ?, ?> other) {
    return super.baseEquals(other)
        && Objects.equals(httpTransportFactoryClassName, other.httpTransportFactoryClassName)
        && Objects.equals(connectTimeout, other.connectTimeout)
        && Objects.equals(readTimeout, other.readTimeout);
  }

  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();
    httpTransportFactory = newInstance(httpTransportFactoryClassName);
  }
}
