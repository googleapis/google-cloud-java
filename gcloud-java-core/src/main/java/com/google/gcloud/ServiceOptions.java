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
import static com.google.common.base.Preconditions.checkNotNull;
import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.api.client.extensions.appengine.http.UrlFetchTransport;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.common.collect.Iterables;
import com.google.gcloud.spi.ServiceRpcFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ServiceOptions<
        ServiceRpcT,
        OptionsT extends ServiceOptions<ServiceRpcT, OptionsT>>
    implements Serializable {

  private static final String DEFAULT_HOST = "https://www.googleapis.com";
  private static final long serialVersionUID = 1203687993961393350L;
  private static final String PROJECT_ENV_NAME = "GCLOUD_PROJECT";

  private final String projectId;
  private final String host;
  private final HttpTransportFactory httpTransportFactory;
  private final AuthCredentials authCredentials;
  private final RetryParams retryParams;
  private final ServiceRpcFactory<ServiceRpcT, OptionsT> serviceRpcFactory;
  private final int connectTimeout;
  private final int readTimeout;
  private final Clock clock;

  public interface HttpTransportFactory extends Serializable {
    HttpTransport create();
  }

  private enum DefaultHttpTransportFactory implements HttpTransportFactory {

    INSTANCE;

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

  /**
   * A class providing access to the current time in milliseconds. This class is mainly used for
   * testing and will be replaced by Java8's {@code java.time.Clock}.
   *
   * Implementations should implement {@code Serializable} wherever possible and must document
   * whether or not they do support serialization.
   */
  public static abstract class Clock {

    private static ServiceOptions.Clock DEFAULT_TIME_SOURCE = new DefaultClock();

    /**
     * Returns current time in milliseconds according to this clock.
     */
    public abstract long millis();

    /**
     * Returns the default clock. Default clock uses {@link System#currentTimeMillis()} to get time
     * in milliseconds.
     */
    public static ServiceOptions.Clock defaultClock() {
      return DEFAULT_TIME_SOURCE;
    }

    private static class DefaultClock extends ServiceOptions.Clock implements Serializable {

      private static final long serialVersionUID = -5077300394286703864L;

      @Override
      public long millis() {
        return System.currentTimeMillis();
      }
    }
  }

  protected abstract static class Builder<
      ServiceRpcT,
      OptionsT extends ServiceOptions<ServiceRpcT, OptionsT>,
      B extends Builder<ServiceRpcT, OptionsT, B>> {

    private String projectId;
    private String host;
    private HttpTransportFactory httpTransportFactory;
    private AuthCredentials authCredentials;
    private RetryParams retryParams;
    private ServiceRpcFactory<ServiceRpcT, OptionsT> serviceRpcFactory;
    private int connectTimeout = -1;
    private int readTimeout = -1;
    private Clock clock;

    protected Builder() {}

    protected Builder(ServiceOptions<ServiceRpcT, OptionsT> options) {
      projectId = options.projectId;
      host = options.host;
      httpTransportFactory = options.httpTransportFactory;
      authCredentials = options.authCredentials;
      retryParams = options.retryParams;
      serviceRpcFactory = options.serviceRpcFactory;
    }

    protected abstract ServiceOptions<ServiceRpcT, OptionsT> build();

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }

    /**
     * Sets the service's clock. The clock is mainly used for testing purpose. {@link Clock} will be
     * replaced by Java8's {@code java.time.Clock}.
     *
     * @param clock the clock to set
     * @return the builder.
     */
    public B clock(Clock clock) {
      this.clock = clock;
      return self();
    }

    /**
     * Sets project id.
     *
     * @return the builder.
     */
    public B projectId(String projectId) {
      this.projectId = projectId;
      return self();
    }

    /**
     * Sets service host.
     *
     * @return the builder.
     */
    public B host(String host) {
      this.host = host;
      return self();
    }

    /**
     * Sets the transport factory.
     *
     * @return the builder.
     */
    public B httpTransportFactory(HttpTransportFactory httpTransportFactory) {
      this.httpTransportFactory = httpTransportFactory;
      return self();
    }

    /**
     * Sets the service authentication credentials.
     *
     * @return the builder.
     */
    public B authCredentials(AuthCredentials authCredentials) {
      this.authCredentials = authCredentials;
      return self();
    }

    /**
     * Sets configuration parameters for request retries. If no configuration is set
     * {@link RetryParams#noRetries()} is used.
     *
     * @return the builder.
     */
    public B retryParams(RetryParams retryParams) {
      this.retryParams = retryParams;
      return self();
    }

    /**
     * Sets the factory for rpc services.
     *
     * @return the builder
     */
    public B serviceRpcFactory(ServiceRpcFactory<ServiceRpcT, OptionsT> serviceRpcFactory) {
      this.serviceRpcFactory = serviceRpcFactory;
      return self();
    }

    /**
     * Sets the timeout in milliseconds to establish a connection.
     *
     * @param connectTimeout connection timeout in milliseconds. 0 for an infinite timeout, a
     * negative number for the default value (20000).
     * @return the builder.
     */
    public B connectTimeout(int connectTimeout) {
      this.connectTimeout = connectTimeout;
      return self();
    }

    /**
     * Sets the timeout in milliseconds to read data from an established connection.
     *
     * @param readTimeout read timeout in milliseconds. 0 for an infinite timeout, a
     * negative number for the default value (20000).
     * @return the builder.
     */
    public B readTimeout(int readTimeout) {
      this.readTimeout = readTimeout;
      return self();
    }
  }

  protected ServiceOptions(Builder<ServiceRpcT, OptionsT, ?> builder) {
    projectId = checkNotNull(builder.projectId != null ? builder.projectId : defaultProject());
    host = firstNonNull(builder.host, defaultHost());
    httpTransportFactory =
        firstNonNull(builder.httpTransportFactory, DefaultHttpTransportFactory.INSTANCE);
    authCredentials = firstNonNull(builder.authCredentials, defaultAuthCredentials());
    retryParams = builder.retryParams;
    serviceRpcFactory = builder.serviceRpcFactory;
    connectTimeout = builder.connectTimeout;
    readTimeout = builder.readTimeout;
    clock = firstNonNull(builder.clock, Clock.defaultClock());
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

  protected String defaultHost() {
    return DEFAULT_HOST;
  }

  protected String defaultProject() {
    String projectId = System.getProperty(PROJECT_ENV_NAME, System.getenv(PROJECT_ENV_NAME));
    if (projectId == null) {
      projectId = getAppEngineProjectId();
    }
    return projectId != null ? projectId : googleCloudProjectId();
  }

  protected static String googleCloudProjectId() {
    try {
      URL url = new URL("http://metadata/computeMetadata/v1/project/project-id");
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestProperty("X-Google-Metadata-Request", "True");
      InputStream input = connection.getInputStream();
      if (connection.getResponseCode() == 200) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input, UTF_8))) {
          return reader.readLine();
        }
      }
    } catch (IOException ignore) {
      // ignore
    }
   File configDir;
    if (System.getenv().containsKey("CLOUDSDK_CONFIG")) {
      configDir = new File(System.getenv("CLOUDSDK_CONFIG"));
    } else if (isWindows() &&  System.getenv().containsKey("APPDATA")) {
      configDir = new File(System.getenv("APPDATA"), "gcloud");
    } else {
      configDir = new File(System.getProperty("user.home"), ".config/gcloud");
    }
    try (BufferedReader reader =
        new BufferedReader(new FileReader(new File(configDir, "properties")))) {
      String line;
      String section = null;
      Pattern projectPattern = Pattern.compile("^project\\s*=\\s*(.*)$");
      Pattern sectionPattern = Pattern.compile("^\\[(.*)\\]$");
      while ((line = reader.readLine()) != null) {
        if (line.isEmpty() || line.startsWith(";")) {
          continue;
        }
        line = line.trim();
        Matcher matcher = sectionPattern.matcher(line);
        if (matcher.matches()) {
          section = matcher.group(1);
        } else if (section == null || section.equals("core")) {
          matcher = projectPattern.matcher(line);
          if (matcher.matches()) {
            return matcher.group(1);
          }
        }
      }
    } catch (IOException ex) {
      // ignore
    }
    // return null if can't determine
    return null;
  }

  private static boolean isWindows() {
    return System.getProperty("os.name").toLowerCase(Locale.ENGLISH).contains("windows");
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

  /**
   * Returns the project id. 
   */
  public String projectId() {
    return projectId;
  }

  /**
   * Returns the service host.
   */
  public String host() {
    return host;
  }

  /**
   * Returns the transport factory.
   */
  public HttpTransportFactory httpTransportFactory() {
    return httpTransportFactory;
  }

  /**
   * Returns the authentication credentials.
   */
  public AuthCredentials authCredentials() {
    return authCredentials;
  }

  /**
   * Returns configuration parameters for request retries. By default requests are not retried:
   * {@link RetryParams#noRetries()} is used.
   */
  public RetryParams retryParams() {
    return retryParams != null ? retryParams : RetryParams.noRetries();
  }

  /**
   * Returns the factory for rpc services.
   */
  public ServiceRpcFactory<ServiceRpcT, OptionsT> serviceRpcFactory() {
    return serviceRpcFactory;
  }

  /**
   * Returns a request initializer responsible for initializing requests according to service
   * options.
   */
  public HttpRequestInitializer httpRequestInitializer() {
    HttpTransport httpTransport = httpTransportFactory.create();
    final HttpRequestInitializer baseRequestInitializer =
        authCredentials().httpRequestInitializer(httpTransport, scopes());
    return new HttpRequestInitializer() {
      @Override
      public void initialize(HttpRequest httpRequest) throws IOException {
        baseRequestInitializer.initialize(httpRequest);
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
  public int connectTimeout() {
    return connectTimeout;
  }

  /**
   * Returns the timeout in milliseconds to read from an established connection. 0 is an infinite
   * timeout, a negative number is the default value (20000).
   */
  public int readTimeout() {
    return readTimeout;
  }

  /**
   * Returns the service's clock. Default time source uses {@link System#currentTimeMillis()} to
   * get current time. 
   */
  public Clock clock() {
    return clock;
  }

  protected int baseHashCode() {
    return Objects.hash(projectId, host, httpTransportFactory, authCredentials, retryParams,
        serviceRpcFactory, connectTimeout, readTimeout, clock);
  }

  protected boolean baseEquals(ServiceOptions<?, ?> other) {
    return Objects.equals(projectId, other.projectId)
        && Objects.equals(host, other.host)
        && Objects.equals(httpTransportFactory, other.httpTransportFactory)
        && Objects.equals(authCredentials, other.authCredentials)
        && Objects.equals(retryParams, other.retryParams)
        && Objects.equals(serviceRpcFactory, other.serviceRpcFactory)
        && Objects.equals(connectTimeout, other.connectTimeout)
        && Objects.equals(readTimeout, other.readTimeout)
        && Objects.equals(clock, clock);
  }

  public abstract Builder<ServiceRpcT, OptionsT, ?> toBuilder();

  /**
   * Creates a service RPC using a factory loaded by {@link ServiceLoader}.
   */
  protected static
      <ServiceRpcT, OptionsT extends ServiceOptions<ServiceRpcT, OptionsT>>
      ServiceRpcT createRpc(OptionsT options,
          Class<? extends ServiceRpcFactory<ServiceRpcT, OptionsT>> factoryClass) {
    ServiceRpcFactory<ServiceRpcT, OptionsT> factory =
        Iterables.getFirst(ServiceLoader.load(factoryClass), null);
    return factory == null ? null : factory.create(options);
  }
}
