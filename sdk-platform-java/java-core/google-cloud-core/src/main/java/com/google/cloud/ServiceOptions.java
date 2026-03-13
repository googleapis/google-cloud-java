/*
 * Copyright 2015 Google LLC
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
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.core.ApiClock;
import com.google.api.core.BetaApi;
import com.google.api.core.CurrentMillisClock;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.NoHeaderProvider;
import com.google.api.gax.tracing.ApiTracer;
import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.QuotaProjectIdProvider;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.spi.ServiceRpcFactory;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.io.Files;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Abstract class representing service options.
 *
 * @param <ServiceT> the service subclass
 * @param <OptionsT> the {@code ServiceOptions} subclass corresponding to the service
 */
public abstract class ServiceOptions<
        ServiceT extends Service<OptionsT>, OptionsT extends ServiceOptions<ServiceT, OptionsT>>
    implements Serializable {

  public static final String CREDENTIAL_ENV_NAME = "GOOGLE_APPLICATION_CREDENTIALS";
  private static final String DEFAULT_HOST = "https://www.googleapis.com";
  private static final String LEGACY_PROJECT_ENV_NAME = "GCLOUD_PROJECT";
  private static final String PROJECT_ENV_NAME = "GOOGLE_CLOUD_PROJECT";

  private static final RetrySettings DEFAULT_RETRY_SETTINGS =
      getDefaultRetrySettingsBuilder().build();
  private static final RetrySettings NO_RETRY_SETTINGS =
      getDefaultRetrySettingsBuilder().setMaxAttempts(1).build();

  private static final long serialVersionUID = 9198896031667942014L;
  protected final String clientLibToken;

  private final String projectId;
  private final String universeDomain;
  private final String host;
  private final RetrySettings retrySettings;
  private final String serviceRpcFactoryClassName;
  private final String serviceFactoryClassName;
  private final ApiClock clock;
  protected Credentials credentials;
  private final TransportOptions transportOptions;
  private final HeaderProvider headerProvider;
  private final String quotaProjectId;

  private transient ServiceRpcFactory<OptionsT> serviceRpcFactory;
  private transient ServiceFactory<ServiceT, OptionsT> serviceFactory;
  private transient ServiceT service;
  private transient ServiceRpc rpc;

  private final ApiTracerFactory apiTracerFactory;

  /**
   * Builder for {@code ServiceOptions}.
   *
   * @param <ServiceT> the service subclass
   * @param <OptionsT> the {@code ServiceOptions} subclass corresponding to the service
   * @param <B> the {@code ServiceOptions} builder
   */
  public abstract static class Builder<
      ServiceT extends Service<OptionsT>,
      OptionsT extends ServiceOptions<ServiceT, OptionsT>,
      B extends Builder<ServiceT, OptionsT, B>> {

    private final ImmutableSet<String> allowedClientLibTokens =
        ImmutableSet.of(ServiceOptions.getGoogApiClientLibName());
    private String projectId;
    private String universeDomain;
    private String host;
    protected Credentials credentials;
    private RetrySettings retrySettings;
    private ServiceFactory<ServiceT, OptionsT> serviceFactory;
    private ServiceRpcFactory<OptionsT> serviceRpcFactory;
    private ApiClock clock;
    private TransportOptions transportOptions;
    private HeaderProvider headerProvider;
    private String clientLibToken = ServiceOptions.getGoogApiClientLibName();
    private String quotaProjectId;

    private ApiTracerFactory apiTracerFactory;

    @InternalApi("This class should only be extended within google-cloud-java")
    protected Builder() {}

    @InternalApi("This class should only be extended within google-cloud-java")
    protected Builder(ServiceOptions<ServiceT, OptionsT> options) {
      projectId = options.projectId;
      universeDomain = options.universeDomain;
      host = options.host;
      credentials = options.credentials;
      retrySettings = options.retrySettings;
      serviceFactory = options.serviceFactory;
      serviceRpcFactory = options.serviceRpcFactory;
      clock = options.clock;
      transportOptions = options.transportOptions;
      clientLibToken = options.clientLibToken;
      quotaProjectId = options.quotaProjectId;
      apiTracerFactory = options.apiTracerFactory;
    }

    protected abstract ServiceOptions<ServiceT, OptionsT> build();

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }

    /** Sets the service factory. */
    public B setServiceFactory(ServiceFactory<ServiceT, OptionsT> serviceFactory) {
      this.serviceFactory = serviceFactory;
      return self();
    }

    /**
     * Sets the service's clock. The clock is mainly used for testing purpose. {@link ApiClock} will
     * be replaced by Java8's {@code java.time.Clock}.
     *
     * @param clock the clock to set
     * @return the builder
     */
    public B setClock(ApiClock clock) {
      this.clock = clock;
      return self();
    }

    /**
     * Sets the project ID. If no project ID is set, {@link #getDefaultProjectId()} will be used to
     * attempt getting the project ID from the environment.
     *
     * @return the builder
     */
    public B setProjectId(String projectId) {
      this.projectId = projectId;
      return self();
    }

    /**
     * Sets service host.
     *
     * @return the builder
     */
    public B setHost(String host) {
      this.host = host;
      return self();
    }

    /**
     * Universe Domain is the domain for Google Cloud Services. A Google Cloud endpoint follows the
     * format of `{ServiceName}.{UniverseDomain}`. For example, speech.googleapis.com would have a
     * Universe Domain value of `googleapis.com` and cloudasset.test.com would have a Universe
     * Domain of `test.com`.
     *
     * <p>If this value is not set, the resolved UniverseDomain will default to `googleapis.com`.
     *
     * @throws NullPointerException if {@code universeDomain} is {@code null}. The resolved
     *     universeDomain will be `googleapis.com` if this value is not set.
     */
    public B setUniverseDomain(String universeDomain) {
      this.universeDomain = checkNotNull(universeDomain);
      return self();
    }

    /**
     * Sets the service authentication credentials. If no credentials are set, {@link
     * GoogleCredentials#getApplicationDefault()} will be used to attempt getting credentials from
     * the environment. Use {@link NoCredentials#getInstance()} to skip authentication, this is
     * typically useful when using local service emulators.
     *
     * @param credentials authentication credentials, should not be {@code null}
     * @return the builder
     * @throws NullPointerException if {@code credentials} is {@code null}. To disable
     *     authentication use {@link NoCredentials#getInstance()}
     */
    public B setCredentials(Credentials credentials) {
      this.credentials = checkNotNull(credentials);
      // set project id if available
      if (this.projectId == null && credentials instanceof ServiceAccountCredentials) {
        this.projectId = ((ServiceAccountCredentials) credentials).getProjectId();
      }

      if (this.quotaProjectId == null && credentials instanceof QuotaProjectIdProvider) {
        this.quotaProjectId = ((QuotaProjectIdProvider) credentials).getQuotaProjectId();
      }
      return self();
    }

    /**
     * Sets configuration parameters for request retries.
     *
     * @return the builder
     */
    public B setRetrySettings(RetrySettings retrySettings) {
      this.retrySettings = retrySettings;
      return self();
    }

    /**
     * Sets the factory for rpc services.
     *
     * @return the builder
     */
    public B setServiceRpcFactory(ServiceRpcFactory<OptionsT> serviceRpcFactory) {
      this.serviceRpcFactory = serviceRpcFactory;
      return self();
    }

    /**
     * Sets the transport options.
     *
     * @return the builder
     */
    public B setTransportOptions(TransportOptions transportOptions) {
      this.transportOptions = transportOptions;
      return self();
    }

    /**
     * Sets the static header provider. The header provider will be called during client
     * construction only once. The headers returned by the provider will be cached and supplied as
     * is for each request issued by the constructed client. Some reserved headers can be overridden
     * (e.g. Content-Type) or merged with the default value (e.g. User-Agent) by the underlying
     * transport layer.
     *
     * @param headerProvider the header provider
     * @return the builder
     */
    @BetaApi
    public B setHeaderProvider(HeaderProvider headerProvider) {
      this.headerProvider = headerProvider;
      return self();
    }

    @InternalApi
    public B setClientLibToken(String clientLibToken) {
      Preconditions.checkArgument(
          getAllowedClientLibTokens().contains(clientLibToken), "Illegal client lib token");
      this.clientLibToken = clientLibToken;
      return self();
    }

    /**
     * Sets the quotaProjectId that specifies the project used for quota and billing purposes.
     *
     * @see <a href="https://cloud.google.com/apis/docs/system-parameters">See system parameter
     *     $userProject</a>
     */
    public B setQuotaProjectId(String quotaProjectId) {
      this.quotaProjectId = quotaProjectId;
      return self();
    }

    /**
     * Sets the {@link ApiTracerFactory}. It will be used to create an {@link ApiTracer} that is
     * annotated throughout the lifecycle of an RPC operation.
     */
    @BetaApi
    @InternalApi
    public B setApiTracerFactory(ApiTracerFactory apiTracerFactory) {
      this.apiTracerFactory = apiTracerFactory;
      return self();
    }

    protected Set<String> getAllowedClientLibTokens() {
      return allowedClientLibTokens;
    }
  }

  @InternalApi("This class should only be extended within google-cloud-java")
  protected ServiceOptions(
      Class<? extends ServiceFactory<ServiceT, OptionsT>> serviceFactoryClass,
      Class<? extends ServiceRpcFactory<OptionsT>> rpcFactoryClass,
      Builder<ServiceT, OptionsT, ?> builder,
      ServiceDefaults<ServiceT, OptionsT> serviceDefaults) {
    projectId = builder.projectId != null ? builder.projectId : getDefaultProject();
    if (projectIdRequired()) {
      checkArgument(
          projectId != null,
          "A project ID is required for this service but could not be determined from the builder "
              + "or the environment.  Please set a project ID using the builder.");
    }
    universeDomain = builder.universeDomain;
    host = firstNonNull(builder.host, getDefaultHost());
    credentials = builder.credentials != null ? builder.credentials : defaultCredentials();
    retrySettings = firstNonNull(builder.retrySettings, getDefaultRetrySettings());
    serviceFactory =
        firstNonNull(
            builder.serviceFactory,
            getFromServiceLoader(serviceFactoryClass, serviceDefaults.getDefaultServiceFactory()));
    serviceFactoryClassName = serviceFactory.getClass().getName();
    serviceRpcFactory =
        firstNonNull(
            builder.serviceRpcFactory,
            getFromServiceLoader(rpcFactoryClass, serviceDefaults.getDefaultRpcFactory()));
    serviceRpcFactoryClassName = serviceRpcFactory.getClass().getName();
    clock = firstNonNull(builder.clock, CurrentMillisClock.getDefaultClock());
    transportOptions =
        firstNonNull(builder.transportOptions, serviceDefaults.getDefaultTransportOptions());
    headerProvider = firstNonNull(builder.headerProvider, new NoHeaderProvider());
    clientLibToken = builder.clientLibToken;
    quotaProjectId =
        builder.quotaProjectId != null
            ? builder.quotaProjectId
            : getValueFromCredentialsFile(getCredentialsPath(), "quota_project_id");
    apiTracerFactory = builder.apiTracerFactory;
  }

  private static String getCredentialsPath() {
    return System.getProperty(CREDENTIAL_ENV_NAME, System.getenv(CREDENTIAL_ENV_NAME));
  }

  /**
   * Returns whether a service requires a project ID. This method may be overridden in
   * service-specific Options objects.
   *
   * @return true if a project ID is required to use the service, false if not
   */
  protected boolean projectIdRequired() {
    return true;
  }

  private static GoogleCredentials defaultCredentials() {
    try {
      return GoogleCredentials.getApplicationDefault();
    } catch (Exception ex) {
      return null;
    }
  }

  protected String getDefaultHost() {
    return DEFAULT_HOST;
  }

  protected String getDefaultProject() {
    return getDefaultProjectId();
  }

  /**
   * Returns the default project ID, or {@code null} if no default project ID could be found. This
   * method returns the first available project ID among the following sources:
   *
   * <ol>
   *   <li>The project ID specified by the GOOGLE_CLOUD_PROJECT environment variable
   *   <li>The App Engine project ID
   *   <li>The project ID specified in the JSON credentials file pointed by the {@code
   *       GOOGLE_APPLICATION_CREDENTIALS} environment variable
   *   <li>The Google Cloud SDK project ID
   *   <li>The Compute Engine project ID
   * </ol>
   */
  public static String getDefaultProjectId() {
    String projectId = System.getProperty(PROJECT_ENV_NAME, System.getenv(PROJECT_ENV_NAME));
    if (projectId == null) {
      projectId =
          System.getProperty(LEGACY_PROJECT_ENV_NAME, System.getenv(LEGACY_PROJECT_ENV_NAME));
    }
    if (projectId == null) {
      projectId = getAppEngineProjectId();
    }
    if (projectId == null) {
      projectId = getServiceAccountProjectId();
    }
    return projectId != null ? projectId : getGoogleCloudProjectId();
  }

  public static String getAppEngineAppId() {
    return System.getProperty("com.google.appengine.application.id");
  }

  private static String getActiveGoogleCloudConfig(File configDir) {
    String activeGoogleCloudConfig = null;
    try {
      activeGoogleCloudConfig =
          Files.asCharSource(new File(configDir, "active_config"), Charset.defaultCharset())
              .readFirstLine();
    } catch (IOException ex) {
      // ignore
    }
    // if reading active_config failed or the file is empty we try default
    return firstNonNull(activeGoogleCloudConfig, "default");
  }

  protected static String getGoogleCloudProjectId() {
    File configDir;
    if (System.getenv().containsKey("CLOUDSDK_CONFIG")) {
      configDir = new File(System.getenv("CLOUDSDK_CONFIG"));
    } else if (isWindows() && System.getenv().containsKey("APPDATA")) {
      configDir = new File(System.getenv("APPDATA"), "gcloud");
    } else {
      configDir = new File(System.getProperty("user.home"), ".config/gcloud");
    }
    String activeConfig = getActiveGoogleCloudConfig(configDir);
    FileReader fileReader = null;
    try {
      fileReader = new FileReader(new File(configDir, "configurations/config_" + activeConfig));
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
    // return project id from metadata config
    return MetadataConfig.getProjectId();
  }

  private static boolean isWindows() {
    return System.getProperty("os.name").toLowerCase(Locale.ENGLISH).contains("windows");
  }

  protected static String getAppEngineProjectId() {
    String projectId = null;
    if (PlatformInformation.isOnGAEStandard7()) {
      projectId = getAppEngineProjectIdFromAppId();
    } else {
      // for GAE flex and standard Java 8 environment
      projectId = System.getenv("GOOGLE_CLOUD_PROJECT");
      if (projectId == null) {
        projectId = System.getenv("GCLOUD_PROJECT");
      }
      if (projectId == null) {
        projectId = getAppEngineProjectIdFromAppId();
      }
      if (projectId == null) {
        try {
          projectId = getAppEngineProjectIdFromMetadataServer();
        } catch (IOException ignore) {
          projectId = null;
        }
      }
    }
    return projectId;
  }

  protected static String getAppEngineProjectIdFromAppId() {
    String projectId = getAppEngineAppId();
    if (projectId != null && projectId.contains(":")) {
      int colonIndex = projectId.indexOf(":");
      projectId = projectId.substring(colonIndex + 1);
    }
    return projectId;
  }

  private static String getAppEngineProjectIdFromMetadataServer() throws IOException {
    String metadata = "http://metadata.google.internal";
    String projectIdURL = "/computeMetadata/v1/project/project-id";
    GenericUrl url = new GenericUrl(metadata + projectIdURL);

    HttpTransport netHttpTransport = new NetHttpTransport();
    HttpRequestFactory requestFactory = netHttpTransport.createRequestFactory();
    HttpRequest request =
        requestFactory
            .buildGetRequest(url)
            .setConnectTimeout(500)
            .setReadTimeout(500)
            .setHeaders(new HttpHeaders().set("Metadata-Flavor", "Google"));
    HttpResponse response = request.execute();
    return headerContainsMetadataFlavor(response) ? response.parseAsString() : null;
  }

  @InternalApi("Visible for testing")
  static boolean headerContainsMetadataFlavor(HttpResponse response) {
    String metadataFlavorValue = response.getHeaders().getFirstHeaderStringValue("Metadata-Flavor");
    return "Google".equals(metadataFlavorValue);
  }

  protected static String getServiceAccountProjectId() {
    return getValueFromCredentialsFile(getCredentialsPath(), "project_id");
  }

  @InternalApi("Visible for testing")
  static String getValueFromCredentialsFile(String credentialsPath, String key) {
    if (credentialsPath != null) {
      try (InputStream credentialsStream = new FileInputStream(credentialsPath)) {
        JsonFactory jsonFactory = GsonFactory.getDefaultInstance();
        JsonObjectParser parser = new JsonObjectParser(jsonFactory);
        GenericJson fileContents =
            parser.parseAndClose(credentialsStream, StandardCharsets.UTF_8, GenericJson.class);
        return (String) fileContents.get(key);
      } catch (IOException | IllegalArgumentException ex) {
        return null;
      }
    }
    return null;
  }

  /**
   * Returns a Service object for the current service. For instance, when using Google Cloud
   * Storage, it returns a Storage object.
   */
  @SuppressWarnings("unchecked")
  public ServiceT getService() {
    if (shouldRefreshService(service)) {
      service = serviceFactory.create((OptionsT) this);
    }
    return service;
  }

  /**
   * @param cachedService The currently cached service object
   * @return true if the currently cached service object should be refreshed.
   */
  protected boolean shouldRefreshService(ServiceT cachedService) {
    return cachedService == null;
  }

  /**
   * Returns a Service RPC object for the current service. For instance, when using Google Cloud
   * Storage, it returns a StorageRpc object.
   */
  @SuppressWarnings("unchecked")
  public ServiceRpc getRpc() {
    if (shouldRefreshRpc(rpc)) {
      rpc = serviceRpcFactory.create((OptionsT) this);
    }
    return rpc;
  }

  /**
   * @param cachedRpc The currently cached service object
   * @return true if the currently cached service object should be refreshed.
   */
  protected boolean shouldRefreshRpc(ServiceRpc cachedRpc) {
    return cachedRpc == null;
  }

  /**
   * Returns the project ID. Return value can be null (for services that don't require a project
   * ID).
   */
  public String getProjectId() {
    return projectId;
  }

  /**
   * Universe Domain is the domain for Google Cloud Services. A Google Cloud endpoint follows the
   * format of `{ServiceName}.{UniverseDomain}`. For example, speech.googleapis.com would have a
   * Universe Domain value of `googleapis.com` and cloudasset.test.com would have a Universe Domain
   * of `test.com`.
   *
   * @return The universe domain value set in the Builder's setter. This is not the resolved
   *     Universe Domain
   */
  public String getUniverseDomain() {
    return universeDomain;
  }

  /** Returns the service host. */
  public String getHost() {
    return host;
  }

  /** Returns the authentication credentials. */
  public Credentials getCredentials() {
    return credentials;
  }

  /** Returns the authentication credentials. If required, credentials are scoped. */
  public Credentials getScopedCredentials() {
    Credentials credentialsToReturn = credentials;
    if (credentials instanceof GoogleCredentials
        && ((GoogleCredentials) credentials).createScopedRequired()) {
      credentialsToReturn = ((GoogleCredentials) credentials).createScoped(getScopes());
    }
    return credentialsToReturn;
  }

  /** Returns configuration parameters for request retries. */
  public RetrySettings getRetrySettings() {
    return retrySettings;
  }

  /**
   * Returns the service's clock. Default time source uses {@link System#currentTimeMillis()} to get
   * current time.
   */
  public ApiClock getClock() {
    return clock;
  }

  /** Returns the transport-specific options for this service. */
  public TransportOptions getTransportOptions() {
    return transportOptions;
  }

  /**
   * Returns the application's name as a string in the format {@code gcloud-java/[version]},
   * optionally prepended with externally supplied User-Agent header value (via setting custom
   * header provider).
   */
  public String getApplicationName() {
    String libraryVersion = getLibraryVersion();

    // We have to do the following since underlying layers often do not appreciate User-Agent
    // provided as a normal header and override it or treat setting "application name" as the only
    // way to append something to User-Agent header.
    StringBuilder sb = new StringBuilder();
    String customUserAgentValue = getUserAgent();
    if (customUserAgentValue != null) {
      sb.append(customUserAgentValue).append(' ');
    }
    if (libraryVersion == null) {
      sb.append(getLibraryName());
    } else {
      sb.append(getLibraryName()).append('/').append(libraryVersion);
    }

    return sb.toString();
  }

  /** Returns the library's name, {@code gcloud-java}, as a string. */
  public static String getLibraryName() {
    return "gcloud-java";
  }

  /** Returns the library's name used by x-goog-api-client header as a string. */
  public static String getGoogApiClientLibName() {
    return "gccl";
  }

  /** Returns the library's version as a string. */
  public String getLibraryVersion() {
    return GaxProperties.getLibraryVersion(this.getClass());
  }

  public ApiTracerFactory getApiTracerFactory() {
    return apiTracerFactory;
  }

  @InternalApi
  public final HeaderProvider getMergedHeaderProvider(HeaderProvider internalHeaderProvider) {
    Map<String, String> mergedHeaders =
        ImmutableMap.<String, String>builder()
            .putAll(internalHeaderProvider.getHeaders())
            .putAll(headerProvider.getHeaders())
            .build();
    return FixedHeaderProvider.create(mergedHeaders);
  }

  @InternalApi
  public final String getUserAgent() {
    if (headerProvider != null) {
      for (Map.Entry<String, String> entry : headerProvider.getHeaders().entrySet()) {
        if ("user-agent".equals(entry.getKey().toLowerCase())) {
          return entry.getValue();
        }
      }
    }
    return null;
  }

  protected int baseHashCode() {
    return Objects.hash(
        projectId,
        host,
        credentials,
        retrySettings,
        serviceFactoryClassName,
        serviceRpcFactoryClassName,
        clock,
        quotaProjectId);
  }

  protected boolean baseEquals(ServiceOptions<?, ?> other) {
    return Objects.equals(projectId, other.projectId)
        && Objects.equals(host, other.host)
        && Objects.equals(credentials, other.credentials)
        && Objects.equals(retrySettings, other.retrySettings)
        && Objects.equals(serviceFactoryClassName, other.serviceFactoryClassName)
        && Objects.equals(serviceRpcFactoryClassName, other.serviceRpcFactoryClassName)
        && Objects.equals(clock, other.clock)
        && Objects.equals(quotaProjectId, other.quotaProjectId);
  }

  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();
    serviceFactory = newInstance(serviceFactoryClassName);
    serviceRpcFactory = newInstance(serviceRpcFactoryClassName);
  }

  @SuppressWarnings("unchecked")
  @InternalApi
  public static <T> T newInstance(String className) throws IOException, ClassNotFoundException {
    try {
      return (T) Class.forName(className).newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      throw new IOException(e);
    }
  }

  public static RetrySettings getDefaultRetrySettings() {
    return DEFAULT_RETRY_SETTINGS;
  }

  public static RetrySettings getNoRetrySettings() {
    return NO_RETRY_SETTINGS;
  }

  private static RetrySettings.Builder getDefaultRetrySettingsBuilder() {
    return RetrySettings.newBuilder()
        .setMaxAttempts(6)
        .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
        .setMaxRetryDelayDuration(Duration.ofMillis(32_000L))
        .setRetryDelayMultiplier(2.0)
        .setTotalTimeoutDuration(Duration.ofMillis(50_000L))
        .setInitialRpcTimeoutDuration(Duration.ofMillis(50_000L))
        .setRpcTimeoutMultiplier(1.0)
        .setMaxRpcTimeoutDuration(Duration.ofMillis(50_000L));
  }

  protected abstract Set<String> getScopes();

  public abstract <B extends Builder<ServiceT, OptionsT, B>> B toBuilder();

  /**
   * Some services may have different backoff requirements listed in their SLAs. Be sure to override
   * this method in options subclasses when the service's backoff requirement differs from the
   * default parameters listed in {@link RetrySettings}.
   */
  protected RetrySettings defaultRetrySettings() {
    return getDefaultRetrySettings();
  }

  @InternalApi
  public static <T> T getFromServiceLoader(Class<? extends T> clazz, T defaultInstance) {
    return Iterables.getFirst(ServiceLoader.load(clazz), defaultInstance);
  }

  public String getClientLibToken() {
    return clientLibToken;
  }

  /** Returns the quotaProjectId that specifies the project used for quota and billing purposes. */
  public String getQuotaProjectId() {
    return quotaProjectId;
  }

  /**
   * Returns the resolved host for the Service to connect to Google Cloud
   *
   * <p>The resolved host will be in `https://{serviceName}.{resolvedUniverseDomain}` format. The
   * resolvedUniverseDomain will be set to `googleapis.com` if universeDomain is null. The format is
   * similar to the DEFAULT_HOST value in java-core.
   *
   * @see <a
   *     href="https://github.com/googleapis/sdk-platform-java/blob/097964f24fa1989bc74b4807a253f0be4e9dd1ea/java-core/google-cloud-core/src/main/java/com/google/cloud/ServiceOptions.java#L85">DEFAULT_HOST</a>
   */
  @InternalApi
  public String getResolvedHost(String serviceName) {
    if (universeDomain != null && universeDomain.isEmpty()) {
      throw new IllegalArgumentException("The universe domain cannot be empty");
    }
    String resolvedUniverseDomain =
        universeDomain != null ? universeDomain : Credentials.GOOGLE_DEFAULT_UNIVERSE;
    // The host value set to DEFAULT_HOST if the user didn't configure a host. If the
    // user set a host the library uses that value, otherwise, construct the host for the user.
    // The DEFAULT_HOST value is not a valid host for handwritten libraries and should be
    // overriden to include the serviceName.
    if (!DEFAULT_HOST.equals(host)) {
      return host;
    }
    return "https://" + serviceName + "." + resolvedUniverseDomain;
  }

  /**
   * Returns a host value to be used for BigQuery and Storage Apiary Wrapped Libraries. To be
   * removed in the future when Apiary clients can resolve their endpoints. Returns the host to be
   * used as the rootUrl.
   *
   * <p>The resolved host will be in `https://{serviceName}.{resolvedUniverseDomain}/` format. The
   * resolvedUniverseDomain will be set to `googleapis.com` if universeDomain is null.
   *
   * <p>The host value is set to DEFAULT_HOST if the user didn't configure a host. Returns the host
   * value the user set, otherwise constructs the host for the user.
   *
   * @see <a
   *     href="https://github.com/googleapis/google-api-java-client/blob/76765d5f9689be9d266a7d62fa6ffb4cabf701f5/google-api-client/src/main/java/com/google/api/client/googleapis/services/AbstractGoogleClient.java#L49">rootUrl</a>
   */
  @InternalApi
  public String getResolvedApiaryHost(String serviceName) {
    if (!DEFAULT_HOST.equals(host)) {
      return host;
    }
    String resolvedUniverseDomain =
        universeDomain != null ? universeDomain : Credentials.GOOGLE_DEFAULT_UNIVERSE;
    return "https://" + serviceName + "." + resolvedUniverseDomain + "/";
  }

  /**
   * Validates that Credentials' Universe Domain matches the resolved Universe Domain. Currently,
   * this is only intended for BigQuery and Storage Apiary Wrapped Libraries.
   *
   * <p>This validation call should be made prior to any RPC invocation. This call is used to gate
   * the RPC invocation if there is no valid universe domain.
   */
  @InternalApi
  public boolean hasValidUniverseDomain() throws IOException {
    String resolvedUniverseDomain =
        universeDomain != null ? universeDomain : Credentials.GOOGLE_DEFAULT_UNIVERSE;
    return resolvedUniverseDomain.equals(getCredentials().getUniverseDomain());
  }
}
