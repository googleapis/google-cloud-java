/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud;


import static com.google.common.base.MoreObjects.firstNonNull;
import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.api.client.extensions.appengine.http.UrlFetchTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.gcloud.spi.ServiceRpcFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;
import java.util.Set;

public abstract class ServiceOptions<R, O extends ServiceOptions<R, O>> implements Serializable {

  private static final String DEFAULT_HOST = "https://www.googleapis.com";
  private static final long serialVersionUID = 1203687993961393350L;

  private final String host;
  private final HttpTransportFactory httpTransportFactory;
  private final AuthCredentials authCredentials;
  private final RetryParams retryParams;
  private final ServiceRpcFactory<R, O> serviceRpcFactory;

  public interface HttpTransportFactory extends Serializable {
    HttpTransport create();
  }

  private static class DefaultHttpTransportFactory implements HttpTransportFactory {

    private static final long serialVersionUID = 2684907202489506911L;

    @Override
    public HttpTransport create() {
      // Consider App Engine
      if (appEngineAppId() != null) {
        try {
          return new UrlFetchTransport();
        } catch (Exception ignore) {
          // Maybe not on App Engine
        }
      }
      // Consider Compute
      try {
        return AuthCredentials.getComputeCredential().getTransport();
      } catch (Exception e) {
        // Maybe not on GCE
      }
      return new NetHttpTransport();
    }
  }

  protected abstract static class Builder<R, O extends ServiceOptions<R, O>,
      B extends Builder<R, O, B>> {

    private String host;
    private HttpTransportFactory httpTransportFactory;
    private AuthCredentials authCredentials;
    private RetryParams retryParams;
    private ServiceRpcFactory<R, O> serviceRpcFactory;

    protected Builder() {}

    protected Builder(ServiceOptions options) {
      host = options.host;
      httpTransportFactory = options.httpTransportFactory;
      authCredentials = options.authCredentials;
      retryParams = options.retryParams;
      serviceRpcFactory = options.serviceRpcFactory;
    }

    protected abstract ServiceOptions build();

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }

    public B host(String host) {
      this.host = host;
      return self();
    }

    public B httpTransportFactory(HttpTransportFactory httpTransportFactory) {
      this.httpTransportFactory = httpTransportFactory;
      return self();
    }

    public B authCredentials(AuthCredentials authCredentials) {
      this.authCredentials = authCredentials;
      return self();
    }

    public B retryParams(RetryParams retryParams) {
      this.retryParams = retryParams;
      return self();
    }

    public B serviceRpcFactory(ServiceRpcFactory<R, O> serviceRpcFactory) {
      this.serviceRpcFactory = serviceRpcFactory;
      return self();
    }
  }

  protected ServiceOptions(Builder<R, O, ?> builder) {
    host = firstNonNull(builder.host, DEFAULT_HOST);
    httpTransportFactory =
        firstNonNull(builder.httpTransportFactory, new DefaultHttpTransportFactory());
    authCredentials = firstNonNull(builder.authCredentials, defaultAuthCredentials());
    retryParams = builder.retryParams;
    serviceRpcFactory = builder.serviceRpcFactory;
  }

  private static AuthCredentials defaultAuthCredentials() {
    // Consider App Engine. This will not be needed once issue #21 is fixed.
    if (appEngineAppId() != null) {
      try {
        return AuthCredentials.createForAppEngine();
      } catch (Exception ignore) {
        // Maybe not on App Engine
      }
    }

    try {
      return AuthCredentials.createApplicationDefaults();
    } catch (Exception ex) {
      // fallback to old-style
    }

    // Consider old-style Compute. This will not be needed once issue #21 is fixed.
    try {
      return AuthCredentials.createForComputeEngine();
    } catch (Exception ignore) {
      // Maybe not on GCE
    }
    return AuthCredentials.noCredentials();
  }

  protected static String appEngineAppId() {
    return System.getProperty("com.google.appengine.application.id");
  }

  protected static String googleCloudProjectId() {
    try {
      URL url = new URL("http://metadata/computeMetadata/v1/project/project-id");
      URLConnection connection = url.openConnection();
      connection.setRequestProperty("X-Google-Metadata-Request", "True");
      try (BufferedReader reader =
          new BufferedReader(new InputStreamReader(connection.getInputStream(), UTF_8))) {
        return reader.readLine();
      }
    } catch (IOException ignore) {
      // return null if can't determine
      return null;
    }
  }

  protected static String getAppEngineProjectId() {
    // TODO(ozarov): An alternative to reflection would be to depend on AE api jar:
    // http://mvnrepository.com/artifact/com.google.appengine/appengine-api-1.0-sdk/1.2.0
    try {
      Class<?> factoryClass =
          Class.forName("com.google.appengine.api.appidentity.AppIdentityServiceFactory");
      Method method = factoryClass.getMethod("getAppIdentityService");
      Object appIdentityService = method.invoke(null);
      method = appIdentityService.getClass().getMethod("getServiceAccountName");
      String serviceAccountName = (String) method.invoke(appIdentityService);
      int indexOfAtSign = serviceAccountName.indexOf('@');
      return serviceAccountName.substring(0, indexOfAtSign);
    } catch (Exception ignore) {
      // return null if can't determine
      return null;
    }
  }

  protected abstract Set<String> scopes();

  public String host() {
    return host;
  }

  public HttpTransportFactory httpTransportFactory() {
    return httpTransportFactory;
  }

  public AuthCredentials authCredentials() {
    return authCredentials;
  }

  public RetryParams retryParams() {
    return retryParams;
  }

  public ServiceRpcFactory<R, O> serviceRpcFactory() {
    return serviceRpcFactory;
  }

  public HttpRequestInitializer httpRequestInitializer() {
    HttpTransport httpTransport = httpTransportFactory.create();
    return authCredentials().httpRequestInitializer(httpTransport, scopes());
  }

  public abstract Builder<R, O, ?> toBuilder();
}
