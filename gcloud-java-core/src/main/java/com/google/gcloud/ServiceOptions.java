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
import static com.google.common.base.Preconditions.checkArgument;
import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.api.client.extensions.appengine.http.UrlFetchTransport;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.common.collect.Iterables;
import com.google.gcloud.spi.ServiceRpcFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("rawtypes")
public abstract class ServiceOptions<
    ServiceT extends Service,
    ServiceRpcT,
    OptionsT extends ServiceOptions<ServiceT, ServiceRpcT, OptionsT>>
    implements Serializable {

  private static final String DEFAULT_HOST = "https://www.googleapis.com";
  private static final long serialVersionUID = 1203687993961393350L;
  private static final String PROJECT_ENV_NAME = "GCLOUD_PROJECT";
  private static final String MANIFEST_ARTIFACT_ID_KEY = "artifactId";
  private static final String MANIFEST_VERSION_KEY = "Implementation-Version";
  private static final String ARTIFACT_ID = "gcloud-java-core";
  private static final String APPLICATION_BASE_NAME = "gcloud-java";
  private static final String APPLICATION_NAME = getApplicationName();

  private final String projectId;
  private final String host;
  private final String httpTransportFactoryClassName;
  private final RestorableState<AuthCredentials> authCredentialsState;
  private final RetryParams retryParams;
  private final String serviceRpcFactoryClassName;
  private final String serviceFactoryClassName;
  private final int connectTimeout;
  private final int readTimeout;
  private final Clock clock;

  private transient HttpTransportFactory httpTransportFactory;
  private transient AuthCredentials authCredentials;
  private transient ServiceRpcFactory<ServiceRpcT, OptionsT> serviceRpcFactory;
  private transient ServiceFactory<ServiceT, OptionsT> serviceFactory;
  private transient ServiceT service;
  private transient ServiceRpcT rpc;

  /**
   * A base interface for all {@link HttpTransport} factories.
   *
   * Implementation must provide a public no-arg constructor. Loading of a factory implementation is
   * done via {@link java.util.ServiceLoader}.
   */
  public interface HttpTransportFactory {
    HttpTransport create();
  }

  public static class DefaultHttpTransportFactory implements HttpTransportFactory {

    private static final HttpTransportFactory INSTANCE = new DefaultHttpTransportFactory();

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
  public abstract static class Clock {

    private static final ServiceOptions.Clock DEFAULT_TIME_SOURCE = new DefaultClock();

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

      private Object readResolve() throws ObjectStreamException {
        return DEFAULT_TIME_SOURCE;
      }
    }
  }

  protected abstract static class Builder<
      ServiceT extends Service,
      ServiceRpcT,
      OptionsT extends ServiceOptions<ServiceT, ServiceRpcT, OptionsT>,
      B extends Builder<ServiceT, ServiceRpcT, OptionsT, B>> {

    private String projectId;
    private String host;
    private HttpTransportFactory httpTransportFactory;
    private AuthCredentials authCredentials;
    private RetryParams retryParams;
    private ServiceFactory<ServiceT, OptionsT> serviceFactory;
    private ServiceRpcFactory<ServiceRpcT, OptionsT> serviceRpcFactory;
    private int connectTimeout = -1;
    private int readTimeout = -1;
    private Clock clock;

    protected Builder() {}

    protected Builder(ServiceOptions<ServiceT, ServiceRpcT, OptionsT> options) {
      projectId = options.projectId;
      host = options.host;
      httpTransportFactory = options.httpTransportFactory;
      authCredentials = options.authCredentials;
      retryParams = options.retryParams;
      serviceFactory = options.serviceFactory;
      serviceRpcFactory = options.serviceRpcFactory;
      connectTimeout = options.connectTimeout;
      readTimeout = options.readTimeout;
      clock = options.clock;
    }

    protected abstract ServiceOptions<ServiceT, ServiceRpcT, OptionsT> build();

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }

    /**
     * Sets the service factory.
     */
    public B serviceFactory(ServiceFactory<ServiceT, OptionsT> serviceFactory) {
      this.serviceFactory = serviceFactory;
      return self();
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
     *        negative number for the default value (20000).
     * @return the builder.
     */
    public B connectTimeout(int connectTimeout) {
      this.connectTimeout = connectTimeout;
      return self();
    }

    /**
     * Sets the timeout in milliseconds to read data from an established connection.
     *
     * @param readTimeout read timeout in milliseconds. 0 for an infinite timeout, a negative number
     *        for the default value (20000).
     * @return the builder.
     */
    public B readTimeout(int readTimeout) {
      this.readTimeout = readTimeout;
      return self();
    }
  }

  protected ServiceOptions(Class<? extends ServiceFactory<ServiceT, OptionsT>> serviceFactoryClass,
      Class<? extends ServiceRpcFactory<ServiceRpcT, OptionsT>> rpcFactoryClass,
      Builder<ServiceT, ServiceRpcT, OptionsT, ?> builder) {
    projectId = builder.projectId != null ? builder.projectId : defaultProject();
    if (projectIdRequired()) {
      checkArgument(
          projectId != null,
          "A project ID is required for this service but could not be determined from the builder "
          + "or the environment.  Please set a project ID using the builder.");
    }
    host = firstNonNull(builder.host, defaultHost());
    httpTransportFactory = firstNonNull(builder.httpTransportFactory,
        getFromServiceLoader(HttpTransportFactory.class, DefaultHttpTransportFactory.INSTANCE));
    httpTransportFactoryClassName = httpTransportFactory.getClass().getName();
    authCredentials =
        builder.authCredentials != null ? builder.authCredentials : defaultAuthCredentials();
    authCredentialsState = authCredentials != null ? authCredentials.capture() : null;
    retryParams = builder.retryParams;
    serviceFactory = firstNonNull(builder.serviceFactory,
        getFromServiceLoader(serviceFactoryClass, defaultServiceFactory()));
    serviceFactoryClassName = serviceFactory.getClass().getName();
    serviceRpcFactory = firstNonNull(builder.serviceRpcFactory,
        getFromServiceLoader(rpcFactoryClass, defaultRpcFactory()));
    serviceRpcFactoryClassName = serviceRpcFactory.getClass().getName();
    connectTimeout = builder.connectTimeout;
    readTimeout = builder.readTimeout;
    clock = firstNonNull(builder.clock, Clock.defaultClock());
  }

  /**
   * Returns whether a service requires a project ID. This method may be overridden in
   * service-specific Options objects.
   *
   * @return true if a project ID is required to use the service, false if not.
   */
  protected boolean projectIdRequired() {
    return true;
  }

  private static AuthCredentials defaultAuthCredentials() {
    // Consider App Engine.
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
      return null;
    }
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
    File configDir;
    if (System.getenv().containsKey("CLOUDSDK_CONFIG")) {
      configDir = new File(System.getenv("CLOUDSDK_CONFIG"));
    } else if (isWindows() && System.getenv().containsKey("APPDATA")) {
      configDir = new File(System.getenv("APPDATA"), "gcloud");
    } else {
      configDir = new File(System.getProperty("user.home"), ".config/gcloud");
    }
    FileReader fileReader = null;
    try {
      fileReader = new FileReader(new File(configDir, "configurations/config_default"));
    } catch (FileNotFoundException newConfigFileNotFoundEx) {
      try {
        fileReader = new FileReader(new File(configDir, "properties"));
      } catch (FileNotFoundException oldConfigFileNotFoundEx) {
        // ignore
      }
    }
    if (fileReader != null) {
      try (BufferedReader reader = new BufferedReader(fileReader)) {
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
    }
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
    // return null if can't determine
    return null;
  }

  private static boolean isWindows() {
    return System.getProperty("os.name").toLowerCase(Locale.ENGLISH).contains("windows");
  }

  protected static String getAppEngineProjectId() {
    try {
      Class<?> factoryClass =
          Class.forName("com.google.appengine.api.appidentity.AppIdentityServiceFactory");
      Class<?> serviceClass =
          Class.forName("com.google.appengine.api.appidentity.AppIdentityService");
      Method method = factoryClass.getMethod("getAppIdentityService");
      Object appIdentityService = method.invoke(null);
      method = serviceClass.getMethod("getServiceAccountName");
      String serviceAccountName = (String) method.invoke(appIdentityService);
      int indexOfAtSign = serviceAccountName.indexOf('@');
      return serviceAccountName.substring(0, indexOfAtSign);
    } catch (Exception ignore) {
      // return null if can't determine
      return null;
    }
  }

  @SuppressWarnings("unchecked")
  public ServiceT service() {
    if (service == null) {
      service = serviceFactory.create((OptionsT) this);
    }
    return service;
  }

  @SuppressWarnings("unchecked")
  public ServiceRpcT rpc() {
    if (rpc == null) {
      rpc = serviceRpcFactory.create((OptionsT) this);
    }
    return rpc;
  }

  /**
   * Returns the project id.
   *
   * Return value can be null (for services that don't require a project id).
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
   * Returns a request initializer responsible for initializing requests according to service
   * options.
   */
  public HttpRequestInitializer httpRequestInitializer() {
    final HttpRequestInitializer delegate = authCredentials() != null
        ? new HttpCredentialsAdapter(authCredentials().credentials().createScoped(scopes()))
        : null;
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
   * Returns the service's clock. Default time source uses {@link System#currentTimeMillis()} to get
   * current time.
   */
  public Clock clock() {
    return clock;
  }

  /**
   * Returns the application's name as a string in the format {@code gcloud-java/[version]}.
   */
  public String applicationName() {
    return APPLICATION_NAME;
  }

  protected int baseHashCode() {
    return Objects.hash(projectId, host, httpTransportFactoryClassName, authCredentialsState,
        retryParams, serviceFactoryClassName, serviceRpcFactoryClassName, connectTimeout,
        readTimeout, clock);
  }

  protected boolean baseEquals(ServiceOptions<?, ?, ?> other) {
    return Objects.equals(projectId, other.projectId)
        && Objects.equals(host, other.host)
        && Objects.equals(httpTransportFactoryClassName, other.httpTransportFactoryClassName)
        && Objects.equals(authCredentialsState, other.authCredentialsState)
        && Objects.equals(retryParams, other.retryParams)
        && Objects.equals(serviceFactoryClassName, other.serviceFactoryClassName)
        && Objects.equals(serviceRpcFactoryClassName, other.serviceRpcFactoryClassName)
        && Objects.equals(connectTimeout, other.connectTimeout)
        && Objects.equals(readTimeout, other.readTimeout)
        && Objects.equals(clock, clock);
  }

  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();
    httpTransportFactory = newInstance(httpTransportFactoryClassName);
    serviceFactory = newInstance(serviceFactoryClassName);
    serviceRpcFactory = newInstance(serviceRpcFactoryClassName);
    authCredentials = authCredentialsState != null ? authCredentialsState.restore() : null;
  }

  @SuppressWarnings("unchecked")
  private static <T> T newInstance(String className) throws IOException, ClassNotFoundException {
    try {
      return (T) Class.forName(className).newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      throw new IOException(e);
    }
  }

  protected abstract <T extends ServiceFactory<ServiceT, OptionsT>> T defaultServiceFactory();

  protected abstract <T extends ServiceRpcFactory<ServiceRpcT, OptionsT>> T defaultRpcFactory();

  protected abstract Set<String> scopes();

  public abstract <B extends Builder<ServiceT, ServiceRpcT, OptionsT, B>> B toBuilder();

  private static <T> T getFromServiceLoader(Class<? extends T> clazz, T defaultInstance) {
    return Iterables.getFirst(ServiceLoader.load(clazz), defaultInstance);
  }

  private static String getApplicationName() {
    String version = null;
    try {
      Enumeration<URL> resources =
          ServiceOptions.class.getClassLoader().getResources(JarFile.MANIFEST_NAME);
      while (resources.hasMoreElements() && version == null) {
        Manifest manifest = new Manifest(resources.nextElement().openStream());
        Attributes manifestAttributes = manifest.getMainAttributes();
        String artifactId = manifestAttributes.getValue(MANIFEST_ARTIFACT_ID_KEY);
        if (artifactId != null && artifactId.equals(ARTIFACT_ID)) {
          version = manifestAttributes.getValue(MANIFEST_VERSION_KEY);
        }
      }
    } catch (IOException e) {
      // ignore
    }
    return version != null ? APPLICATION_BASE_NAME + "/" + version : APPLICATION_BASE_NAME;
  }
}
