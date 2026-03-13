/*
 * Copyright 2016 Google LLC
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
package com.google.api.gax.grpc;

import static com.google.api.gax.util.TimeConversionUtils.toJavaTimeDuration;
import static com.google.api.gax.util.TimeConversionUtils.toThreetenDuration;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannel;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.internal.EnvironmentProvider;
import com.google.api.gax.rpc.mtls.CertificateBasedAccess;
import com.google.auth.ApiKeyCredentials;
import com.google.auth.Credentials;
import com.google.auth.mtls.CertificateSourceUnavailableException;
import com.google.auth.mtls.DefaultMtlsProviderFactory;
import com.google.auth.mtls.MtlsProvider;
import com.google.auth.oauth2.ComputeEngineCredentials;
import com.google.auth.oauth2.SecureSessionAgent;
import com.google.auth.oauth2.SecureSessionAgentConfig;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.Files;
import io.grpc.CallCredentials;
import io.grpc.ChannelCredentials;
import io.grpc.CompositeChannelCredentials;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.TlsChannelCredentials;
import io.grpc.alts.GoogleDefaultChannelCredentials;
import io.grpc.auth.MoreCallCredentials;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.KeyManagerFactory;

/**
 * InstantiatingGrpcChannelProvider is a TransportChannelProvider which constructs a gRPC
 * ManagedChannel with a number of configured inputs every time getChannel(...) is called. These
 * inputs include a port, a service address, and credentials.
 *
 * <p>The credentials can either be supplied directly (by providing a FixedCredentialsProvider to
 * Builder.setCredentialsProvider()) or acquired implicitly from Application Default Credentials (by
 * providing a GoogleCredentialsProvider to Builder.setCredentialsProvider()).
 *
 * <p>The client lib header and generator header values are used to form a value that goes into the
 * http header of requests to the service.
 */
public final class InstantiatingGrpcChannelProvider implements TransportChannelProvider {

  private static String systemProductName;

  @VisibleForTesting
  static final Logger LOG = Logger.getLogger(InstantiatingGrpcChannelProvider.class.getName());

  static final String DIRECT_PATH_ENV_DISABLE_DIRECT_PATH = "GOOGLE_CLOUD_DISABLE_DIRECT_PATH";

  @VisibleForTesting
  static final String DIRECT_PATH_ENV_ENABLE_XDS = "GOOGLE_CLOUD_ENABLE_DIRECT_PATH_XDS";

  // The public portion of the mTLS MDS root certificate is stored for performing
  // cert verification when establishing an mTLS connection with the MDS. See
  // {@link <a
  // href="https://cloud.google.com/compute/docs/metadata/overview#https-mds-root-certs">this</a>
  // for more information.}
  private static final String MTLS_MDS_ROOT_PATH = "/run/google-mds-mtls/root.crt";
  // The mTLS MDS credentials are formatted as the concatenation of a PEM-encoded certificate chain
  // followed by a PEM-encoded private key. See
  // {@link <a
  // href="https://cloud.google.com/compute/docs/metadata/overview#https-mds-client-certs">this</a>
  // for more information.}
  private static final String MTLS_MDS_CERT_CHAIN_AND_KEY_PATH = "/run/google-mds-mtls/client.key";

  static final long DIRECT_PATH_KEEP_ALIVE_TIME_SECONDS = 3600;
  static final long DIRECT_PATH_KEEP_ALIVE_TIMEOUT_SECONDS = 20;
  static final String GCE_PRODUCTION_NAME_PRIOR_2016 = "Google";
  static final String GCE_PRODUCTION_NAME_AFTER_2016 = "Google Compute Engine";

  private final int processorCount;
  private final Executor executor;
  @Nullable private final ScheduledExecutorService backgroundExecutor;
  private final HeaderProvider headerProvider;
  private final boolean useS2A;
  private final String endpoint;
  private final String mtlsEndpoint;
  // TODO: remove. envProvider currently provides DirectPath environment variable, and is only used
  // during initial rollout for DirectPath. This provider will be removed once the DirectPath
  // environment is not used.
  private final EnvironmentProvider envProvider;
  @Nullable private final GrpcInterceptorProvider interceptorProvider;
  @Nullable private final Integer maxInboundMessageSize;
  @Nullable private final Integer maxInboundMetadataSize;
  @Nullable private final java.time.Duration keepAliveTime;
  @Nullable private final java.time.Duration keepAliveTimeout;
  @Nullable private final Boolean keepAliveWithoutCalls;
  private final ChannelPoolSettings channelPoolSettings;
  @Nullable private final Credentials credentials;
  @Nullable private final CallCredentials altsCallCredentials;
  @Nullable private final CallCredentials mtlsS2ACallCredentials;
  @Nullable private final ChannelPrimer channelPrimer;
  @Nullable private final Boolean attemptDirectPath;
  @Nullable private final Boolean attemptDirectPathXds;
  @Nullable private final Boolean allowNonDefaultServiceAccount;
  @VisibleForTesting final ImmutableMap<String, ?> directPathServiceConfig;
  @Nullable private final MtlsProvider mtlsProvider;
  private final CertificateBasedAccess certificateBasedAccess;
  @Nullable private final SecureSessionAgent s2aConfigProvider;
  private final List<HardBoundTokenTypes> allowedHardBoundTokenTypes;
  @VisibleForTesting final Map<String, String> headersWithDuplicatesRemoved = new HashMap<>();

  @Nullable
  private final ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> channelConfigurator;

  // This is initialized once for the lifetime of the application. This enables re-using
  // channels to S2A.
  private static volatile ChannelCredentials s2aChannelCredentials;

  /**
   * Resets the s2aChannelCredentials of the {@link InstantiatingGrpcChannelProvider} class for
   * testing purposes.
   *
   * <p>This should only be called from tests.
   */
  @VisibleForTesting
  static void resetS2AChannelCredentials() {
    synchronized (InstantiatingGrpcChannelProvider.class) {
      s2aChannelCredentials = null;
    }
  }

  /**
   * Returns the s2aChannelCredentials of the {@link InstantiatingGrpcChannelProvider} class for
   * testing purposes.
   *
   * <p>This should only be called from tests.
   */
  @VisibleForTesting
  static ChannelCredentials getS2AChannelCredentials() {
    return s2aChannelCredentials;
  }

  /*
   * Experimental feature
   *
   * <p>{@link HardBoundTokenTypes} specifies if hard bound tokens should be used if DirectPath
   * or S2A is used to estabilsh a connection to Google APIs.
   *
   */
  @InternalApi
  public enum HardBoundTokenTypes {
    // If DirectPath is used to create the channel, use hard ALTS-bound tokens for requests sent on
    // that channel.
    ALTS,
    // If MTLS via S2A is used to create the channel, use hard MTLS-bound tokens for requests sent
    // on that channel.
    MTLS_S2A
  }

  private InstantiatingGrpcChannelProvider(Builder builder) {
    this.processorCount = builder.processorCount;
    this.executor = builder.executor;
    this.backgroundExecutor = builder.backgroundExecutor;
    this.headerProvider = builder.headerProvider;
    this.useS2A = builder.useS2A;
    this.endpoint = builder.endpoint;
    this.mtlsEndpoint = builder.mtlsEndpoint;
    this.allowedHardBoundTokenTypes = builder.allowedHardBoundTokenTypes;
    this.mtlsProvider = builder.mtlsProvider;
    this.certificateBasedAccess = builder.certificateBasedAccess;
    this.s2aConfigProvider = builder.s2aConfigProvider;
    this.envProvider = builder.envProvider;
    this.interceptorProvider = builder.interceptorProvider;
    this.maxInboundMessageSize = builder.maxInboundMessageSize;
    this.maxInboundMetadataSize = builder.maxInboundMetadataSize;
    this.keepAliveTime = builder.keepAliveTime;
    this.keepAliveTimeout = builder.keepAliveTimeout;
    this.keepAliveWithoutCalls = builder.keepAliveWithoutCalls;
    this.channelPoolSettings = builder.channelPoolSettings;
    this.channelConfigurator = builder.channelConfigurator;
    this.credentials = builder.credentials;
    this.altsCallCredentials = builder.altsCallCredentials;
    this.mtlsS2ACallCredentials = builder.mtlsS2ACallCredentials;
    this.channelPrimer = builder.channelPrimer;
    this.attemptDirectPath = builder.attemptDirectPath;
    this.attemptDirectPathXds = builder.attemptDirectPathXds;
    this.allowNonDefaultServiceAccount = builder.allowNonDefaultServiceAccount;
    this.directPathServiceConfig =
        builder.directPathServiceConfig == null
            ? getDefaultDirectPathServiceConfig()
            : builder.directPathServiceConfig;
  }

  /**
   * Package-Private constructor that is only visible for testing DirectPath functionality inside
   * tests. This overrides the computed systemProductName when the class is initialized to help
   * configure the result of {@link #isOnComputeEngine()} check.
   *
   * <p>If productName is null, that represents the result of an IOException
   */
  @VisibleForTesting
  InstantiatingGrpcChannelProvider(Builder builder, String productName) {
    this(builder);
    systemProductName = productName;
  }

  /**
   * @deprecated If executor is not set, this channel provider will create channels with default
   *     grpc executor.
   */
  @Deprecated
  @Override
  public boolean needsExecutor() {
    return executor == null;
  }

  @Deprecated
  @Override
  public TransportChannelProvider withExecutor(ScheduledExecutorService executor) {
    return withExecutor((Executor) executor);
  }

  @Override
  public TransportChannelProvider withExecutor(Executor executor) {
    return toBuilder().setExecutor(executor).build();
  }

  @Override
  public boolean needsBackgroundExecutor() {
    return backgroundExecutor == null;
  }

  @Override
  public TransportChannelProvider withBackgroundExecutor(ScheduledExecutorService executor) {
    return toBuilder().setBackgroundExecutor(executor).build();
  }

  @Override
  public boolean needsHeaders() {
    return headerProvider == null;
  }

  @Override
  public TransportChannelProvider withHeaders(Map<String, String> headers) {
    return toBuilder().setHeaderProvider(FixedHeaderProvider.create(headers)).build();
  }

  @Override
  public String getTransportName() {
    return GrpcTransportChannel.getGrpcTransportName();
  }

  @Override
  public boolean needsEndpoint() {
    return endpoint == null;
  }

  @InternalApi("This public method is used by Gax to help configure the MTLS endpoint for S2A")
  @Override
  public boolean needsMtlsEndpoint() {
    return mtlsEndpoint == null;
  }

  /**
   * Specify the endpoint the channel should connect to.
   *
   * <p>The value of {@code endpoint} must be of the form {@code host:port}.
   *
   * @param endpoint The endpoint to connect to
   * @return A new {@link InstantiatingGrpcChannelProvider} with the specified endpoint configured
   */
  @Override
  public TransportChannelProvider withEndpoint(String endpoint) {
    validateEndpoint(endpoint);
    return toBuilder().setEndpoint(endpoint).build();
  }

  /**
   * Specify the mTLS endpoint the channel should connect to when using S2A.
   *
   * <p>The value of {@code mtlsEndpoint} must be of the form {@code host:port}.
   *
   * @param mtlsEndpoint The mtTLS endpoint to connect to
   * @return A new {@link InstantiatingGrpcChannelProvider} with the specified mTLS endpoint
   *     configured
   */
  @InternalApi("This public method is used by Gax to help configure the MTLS endpoint for S2A")
  @Override
  public TransportChannelProvider withMtlsEndpoint(String mtlsEndpoint) {
    validateEndpoint(mtlsEndpoint);
    return toBuilder().setMtlsEndpoint(mtlsEndpoint).build();
  }

  /**
   * Specify whether or not to use S2A.
   *
   * @param useS2A
   * @return A new {@link InstantiatingGrpcChannelProvider} with useS2A set.
   */
  @Override
  public TransportChannelProvider withUseS2A(boolean useS2A) {
    return toBuilder().setUseS2A(useS2A).build();
  }

  /**
   * @deprecated Please modify pool settings via {@link #toBuilder()}
   */
  @Deprecated
  @Override
  public boolean acceptsPoolSize() {
    return true;
  }

  /**
   * @deprecated Please modify pool settings via {@link #toBuilder()}
   */
  @Deprecated
  @Override
  public TransportChannelProvider withPoolSize(int size) {
    return toBuilder().setPoolSize(size).build();
  }

  @Override
  public boolean needsCredentials() {
    return credentials == null;
  }

  @Override
  public TransportChannelProvider withCredentials(Credentials credentials) {
    return toBuilder().setCredentials(credentials).build();
  }

  @Override
  public TransportChannel getTransportChannel() throws IOException {
    if (needsHeaders()) {
      throw new IllegalStateException("getTransportChannel() called when needsHeaders() is true");
    } else if (needsEndpoint()) {
      throw new IllegalStateException("getTransportChannel() called when needsEndpoint() is true");
    } else {
      logDirectPathMisconfig();
      return createChannel();
    }
  }

  private TransportChannel createChannel() throws IOException {
    return GrpcTransportChannel.newBuilder()
        .setManagedChannel(
            ChannelPool.create(
                channelPoolSettings,
                InstantiatingGrpcChannelProvider.this::createSingleChannel,
                backgroundExecutor))
        .setDirectPath(this.canUseDirectPath())
        .build();
  }

  private boolean isDirectPathEnabled() {
    String disableDirectPathEnv = envProvider.getenv(DIRECT_PATH_ENV_DISABLE_DIRECT_PATH);
    boolean isDirectPathDisabled = Boolean.parseBoolean(disableDirectPathEnv);
    if (isDirectPathDisabled) {
      return false;
    }
    // Only check attemptDirectPath when DIRECT_PATH_ENV_DISABLE_DIRECT_PATH is not set.
    if (attemptDirectPath != null) {
      return attemptDirectPath;
    }
    return false;
  }

  private boolean isDirectPathXdsEnabledViaBuilderOption() {
    return Boolean.TRUE.equals(attemptDirectPathXds);
  }

  private boolean isDirectPathXdsEnabledViaEnv() {
    String directPathXdsEnv = envProvider.getenv(DIRECT_PATH_ENV_ENABLE_XDS);
    return Boolean.parseBoolean(directPathXdsEnv);
  }

  /**
   * This method tells if Direct Path xDS was enabled. There are two ways of enabling it: via
   * environment variable (by setting GOOGLE_CLOUD_ENABLE_DIRECT_PATH_XDS=true) or when building
   * this channel provider (via the {@link Builder#setAttemptDirectPathXds()} method).
   *
   * @return true if Direct Path xDS was either enabled via env var or via builder option
   */
  @InternalApi
  public boolean isDirectPathXdsEnabled() {
    return isDirectPathXdsEnabledViaEnv() || isDirectPathXdsEnabledViaBuilderOption();
  }

  // This method should be called once per client initialization, hence can not be called in the
  // builder or createSingleChannel, only in getTransportChannel which creates the first channel
  // for a client.
  private void logDirectPathMisconfig() {
    if (isDirectPathXdsEnabled()) {
      if (!isDirectPathEnabled()) {
        // This misconfiguration occurs when Direct Path xDS is enabled, but Direct Path is not
        // Direct Path xDS can be enabled two ways: via environment variable or via builder.
        // Case 1: Direct Path is only enabled via xDS env var. We will _warn_ the user that this is
        // a misconfiguration if they intended to set the env var.
        if (isDirectPathXdsEnabledViaEnv()) {
          LOG.log(
              Level.WARNING,
              "Env var "
                  + DIRECT_PATH_ENV_ENABLE_XDS
                  + " was found and set to TRUE, but DirectPath was not enabled for this client. If this is intended for "
                  + "this client, please note that this is a misconfiguration and set the attemptDirectPath option as well.");
        }
        // Case 2: Direct Path xDS was enabled via Builder. Direct Path Traffic Director must be set
        // (enabled with `setAttemptDirectPath(true)`) along with xDS.
        // Here we warn the user about this.
        else if (isDirectPathXdsEnabledViaBuilderOption()) {
          LOG.log(
              Level.WARNING,
              "DirectPath is misconfigured. The DirectPath XDS option was set, but the attemptDirectPath option was not. Please set both the attemptDirectPath and attemptDirectPathXds options.");
        }
      } else {
        // Case 3: credential is not correctly set
        if (!isCredentialDirectPathCompatible()) {
          LOG.log(
              Level.WARNING,
              "DirectPath is misconfigured. Please make sure the credential is an instance of "
                  + ComputeEngineCredentials.class.getName()
                  + " .");
        }
        // Case 4: not running on GCE
        if (!isOnComputeEngine()) {
          LOG.log(
              Level.WARNING,
              "DirectPath is misconfigured. DirectPath is only available in a GCE environment.");
        }
      }
    }
  }

  @VisibleForTesting
  boolean isCredentialDirectPathCompatible() {
    // DirectPath requires a call credential during gRPC channel construction.
    if (needsCredentials()) {
      return false;
    }
    if (allowNonDefaultServiceAccount != null && allowNonDefaultServiceAccount) {
      return true;
    }
    return credentials instanceof ComputeEngineCredentials;
  }

  // DirectPath should only be used on Compute Engine.
  // Notice Windows is supported for now.
  @VisibleForTesting
  static boolean isOnComputeEngine() {
    String osName = System.getProperty("os.name");
    if ("Linux".equals(osName)) {
      String systemProductName = getSystemProductName();
      // systemProductName will be empty string if not on Compute Engine
      return systemProductName.contains(GCE_PRODUCTION_NAME_PRIOR_2016)
          || systemProductName.contains(GCE_PRODUCTION_NAME_AFTER_2016);
    }
    return false;
  }

  private static String getSystemProductName() {
    // The static field systemProductName should only be set in tests
    if (systemProductName != null) {
      return systemProductName;
    }
    try {
      return Files.asCharSource(new File("/sys/class/dmi/id/product_name"), StandardCharsets.UTF_8)
          .readFirstLine();
    } catch (IOException e) {
      // If not on Compute Engine, FileNotFoundException will be thrown. Use empty string
      // as it won't match with the GCE_PRODUCTION_NAME constants
      return "";
    }
  }

  // Universe Domain configuration is currently only supported in the GDU
  @VisibleForTesting
  boolean canUseDirectPathWithUniverseDomain() {
    return endpoint.contains(Credentials.GOOGLE_DEFAULT_UNIVERSE);
  }

  @VisibleForTesting
  ChannelCredentials createMtlsChannelCredentials() throws IOException, GeneralSecurityException {
    if (mtlsProvider == null) {
      return null;
    }
    if (certificateBasedAccess.useMtlsClientCertificate()) {
      KeyStore mtlsKeyStore = mtlsProvider.getKeyStore();
      if (mtlsKeyStore != null) {
        KeyManagerFactory factory =
            KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        factory.init(mtlsKeyStore, new char[] {});
        return TlsChannelCredentials.newBuilder().keyManager(factory.getKeyManagers()).build();
      }
    }
    return null;
  }

  /**
   * Create the S2A-Secured Channel credentials. Load the API using reflection. Once the S2A API is
   * stable in gRPC-Java, all callers of this method can simply use the S2A APIs directly and this
   * method can be deleted.
   *
   * @param s2aAddress the address of the S2A server used to secure the connection.
   * @param s2aChannelCredentials the credentials to be used when connecting to the S2A.
   * @return {@code ChannelCredentials} instance.
   */
  ChannelCredentials buildS2AChannelCredentials(
      String s2aAddress, ChannelCredentials s2aChannelCredentials) {
    try {
      // Load the S2A API.
      Class<?> s2aChannelCreds = Class.forName("io.grpc.s2a.S2AChannelCredentials");
      Class<?> s2aChannelCredsBuilder = Class.forName("io.grpc.s2a.S2AChannelCredentials$Builder");

      // Load and invoke the S2A API methods.
      Class<?>[] partypes = new Class[2];
      partypes[0] = String.class;
      partypes[1] = ChannelCredentials.class;
      Method newBuilder = s2aChannelCreds.getMethod("newBuilder", partypes);
      Object arglist[] = new Object[2];
      arglist[0] = s2aAddress;
      arglist[1] = s2aChannelCredentials;
      Object retObjBuilder = newBuilder.invoke(null, arglist);
      Method build = s2aChannelCredsBuilder.getMethod("build", null);
      Object retObjCreds = build.invoke(retObjBuilder, null);
      return (ChannelCredentials) retObjCreds;
    } catch (Throwable t) {
      LOG.log(
          Level.WARNING,
          "Falling back to default (TLS without S2A) because S2A APIs cannot be used: "
              + t.getMessage());
      return null;
    }
  }

  /**
   * This method creates {@link TlsChannelCredentials} to be used by the client to establish an mTLS
   * connection to S2A. Returns null if any of {@param trustBundle}, {@param privateKey} or {@param
   * certChain} are missing.
   *
   * @param trustBundle the trust bundle to be used to establish the client -> S2A mTLS connection
   * @param privateKey the client's private key to be used to establish the client -> S2A mtls
   *     connection
   * @param certChain the client's cert chain to be used to establish the client -> S2A mtls
   *     connection
   * @return {@link ChannelCredentials} to use to create an mtls connection between client and S2A
   * @throws IOException on error
   */
  @VisibleForTesting
  ChannelCredentials createMtlsToS2AChannelCredentials(
      File trustBundle, File privateKey, File certChain) throws IOException {
    if (trustBundle == null || privateKey == null || certChain == null) {
      return null;
    }
    return TlsChannelCredentials.newBuilder()
        .keyManager(privateKey, certChain)
        .trustManager(trustBundle)
        .build();
  }

  /**
   * This method creates {@link ChannelCredentials} to be used by client to establish a plaintext
   * connection to S2A. if {@param plaintextAddress} is not present, returns null.
   *
   * @param plaintextAddress the address to reach S2A which accepts plaintext connections
   * @return {@link ChannelCredentials} to use to create a plaintext connection between client and
   *     S2A
   */
  ChannelCredentials createPlaintextToS2AChannelCredentials(String plaintextAddress) {
    if (Strings.isNullOrEmpty(plaintextAddress)) {
      return null;
    }
    return buildS2AChannelCredentials(plaintextAddress, InsecureChannelCredentials.create());
  }

  /**
   * This method creates gRPC {@link ChannelCredentials} configured to use S2A to estbalish a mTLS
   * connection. First, the address of S2A is discovered by using the {@link S2A} utility to learn
   * the {@code mtlsAddress} to reach S2A and the {@code plaintextAddress} to reach S2A. Prefer to
   * use the {@code mtlsAddress} address to reach S2A if it is non-empty and the MTLS-MDS
   * credentials can successfully be discovered and used to create {@link TlsChannelCredentials}. If
   * there is any failure using mTLS-to-S2A, fallback to using a plaintext connection to S2A using
   * the {@code plaintextAddress}. If {@code plaintextAddress} is not available, this function
   * returns null; in this case S2A will not be used, and a TLS connection to the service will be
   * established.
   *
   * @return {@link ChannelCredentials} configured to use S2A to create mTLS connection.
   */
  ChannelCredentials createS2ASecuredChannelCredentials() {
    if (s2aChannelCredentials == null) {
      // s2aChannelCredentials is initialized once and shared by all instances of the class.
      // To prevent a race on initialization, the object initialization is synchronized on the class
      // object.
      synchronized (InstantiatingGrpcChannelProvider.class) {
        if (s2aChannelCredentials != null) {
          return s2aChannelCredentials;
        }
        SecureSessionAgentConfig config = s2aConfigProvider.getConfig();
        String plaintextAddress = config.getPlaintextAddress();
        String mtlsAddress = config.getMtlsAddress();
        if (Strings.isNullOrEmpty(mtlsAddress)) {
          // Fallback to plaintext connection to S2A.
          LOG.log(
              Level.INFO,
              "Cannot establish an mTLS connection to S2A because autoconfig endpoint did not return a mtls address to reach S2A.");
          s2aChannelCredentials = createPlaintextToS2AChannelCredentials(plaintextAddress);
          return s2aChannelCredentials;
        }
        // Currently, MTLS to MDS is only available on GCE. See:
        // https://cloud.google.com/compute/docs/metadata/overview#https-mds
        // Try to load MTLS-MDS creds.
        File rootFile = new File(MTLS_MDS_ROOT_PATH);
        File certKeyFile = new File(MTLS_MDS_CERT_CHAIN_AND_KEY_PATH);
        if (rootFile.isFile() && certKeyFile.isFile()) {
          // Try to connect to S2A using mTLS.
          ChannelCredentials mtlsToS2AChannelCredentials = null;
          try {
            mtlsToS2AChannelCredentials =
                createMtlsToS2AChannelCredentials(rootFile, certKeyFile, certKeyFile);
          } catch (IOException ignore) {
            // Fallback to plaintext-to-S2A connection on error.
            LOG.log(
                Level.WARNING,
                "Cannot establish an mTLS connection to S2A due to error creating MTLS to MDS TlsChannelCredentials credentials, falling back to plaintext connection to S2A: "
                    + ignore.getMessage());
            s2aChannelCredentials = createPlaintextToS2AChannelCredentials(plaintextAddress);
            return s2aChannelCredentials;
          }
          s2aChannelCredentials =
              buildS2AChannelCredentials(mtlsAddress, mtlsToS2AChannelCredentials);
          return s2aChannelCredentials;
        } else {
          // Fallback to plaintext-to-S2A connection if MTLS-MDS creds do not exist.
          LOG.log(
              Level.INFO,
              "Cannot establish an mTLS connection to S2A because MTLS to MDS credentials do not"
                  + " exist on filesystem, falling back to plaintext connection to S2A");
          s2aChannelCredentials = createPlaintextToS2AChannelCredentials(plaintextAddress);
          return s2aChannelCredentials;
        }
      }
    }
    return s2aChannelCredentials;
  }

  private ManagedChannel createSingleChannel() throws IOException {
    GrpcHeaderInterceptor headerInterceptor =
        new GrpcHeaderInterceptor(headersWithDuplicatesRemoved);

    GrpcMetadataHandlerInterceptor metadataHandlerInterceptor =
        new GrpcMetadataHandlerInterceptor();

    int colon = endpoint.lastIndexOf(':');
    if (colon < 0) {
      throw new IllegalStateException("invalid endpoint - should have been validated: " + endpoint);
    }
    int port = Integer.parseInt(endpoint.substring(colon + 1));
    String serviceAddress = endpoint.substring(0, colon);

    ManagedChannelBuilder<?> builder;

    // Check DirectPath traffic.
    boolean useDirectPathXds = false;
    if (canUseDirectPath()) {
      CallCredentials callCreds = MoreCallCredentials.from(credentials);
      // altsCallCredentials may be null and GoogleDefaultChannelCredentials
      // will solely use callCreds. Otherwise it uses altsCallCredentials
      // for DirectPath connections and callCreds for CloudPath fallbacks.
      ChannelCredentials channelCreds =
          GoogleDefaultChannelCredentials.newBuilder()
              .callCredentials(callCreds)
              .altsCallCredentials(altsCallCredentials)
              .build();
      useDirectPathXds = isDirectPathXdsEnabled();
      if (useDirectPathXds) {
        // google-c2p: CloudToProd(C2P) Directpath. This scheme is defined in
        // io.grpc.googleapis.GoogleCloudToProdNameResolverProvider.
        // This resolver target must not have a port number.
        builder = Grpc.newChannelBuilder("google-c2p:///" + serviceAddress, channelCreds);
      } else {
        builder = Grpc.newChannelBuilderForAddress(serviceAddress, port, channelCreds);
        builder.defaultServiceConfig(directPathServiceConfig);
      }
      // Set default keepAliveTime and keepAliveTimeout when directpath environment is enabled.
      // Will be overridden by user defined values if any.
      builder.keepAliveTime(DIRECT_PATH_KEEP_ALIVE_TIME_SECONDS, TimeUnit.SECONDS);
      builder.keepAliveTimeout(DIRECT_PATH_KEEP_ALIVE_TIMEOUT_SECONDS, TimeUnit.SECONDS);
    } else {
      ChannelCredentials channelCredentials;
      try {
        // Try and create credentials via DCA. See https://google.aip.dev/auth/4114.
        channelCredentials = createMtlsChannelCredentials();
      } catch (GeneralSecurityException e) {
        throw new IOException(e);
      }
      if (channelCredentials != null) {
        // Create the channel using channel credentials created via DCA.
        builder = Grpc.newChannelBuilder(endpoint, channelCredentials);
      } else {
        // Could not create channel credentials via DCA. In accordance with
        // https://google.aip.dev/auth/4115, if credentials not available through
        // DCA, try mTLS with credentials held by the S2A (Secure Session Agent).
        if (useS2A) {
          channelCredentials = createS2ASecuredChannelCredentials();
        }
        if (channelCredentials != null) {
          // Create the channel using S2A-secured channel credentials.
          if (mtlsS2ACallCredentials != null) {
            // Set {@code mtlsS2ACallCredentials} to be per-RPC call credentials,
            // which will be used to fetch MTLS_S2A hard bound tokens from the metdata server.
            channelCredentials =
                CompositeChannelCredentials.create(channelCredentials, mtlsS2ACallCredentials);
          }
          // Connect to the MTLS endpoint when using S2A because S2A is used to perform an MTLS
          // handshake.
          builder = Grpc.newChannelBuilder(mtlsEndpoint, channelCredentials);
        } else {
          // Use default if we cannot initialize channel credentials via DCA or S2A.
          builder = ManagedChannelBuilder.forAddress(serviceAddress, port);
        }
      }
    }
    // google-c2p resolver requires service config lookup
    if (!useDirectPathXds) {
      // See https://github.com/googleapis/gapic-generator/issues/2816
      builder.disableServiceConfigLookUp();
    }
    builder =
        builder
            .intercept(new GrpcChannelUUIDInterceptor())
            .intercept(new GrpcLoggingInterceptor())
            .intercept(headerInterceptor)
            .intercept(metadataHandlerInterceptor)
            .userAgent(headerInterceptor.getUserAgentHeader())
            .executor(executor);

    if (maxInboundMetadataSize != null) {
      builder.maxInboundMetadataSize(maxInboundMetadataSize);
    }
    if (maxInboundMessageSize != null) {
      builder.maxInboundMessageSize(maxInboundMessageSize);
    }
    if (keepAliveTime != null) {
      builder.keepAliveTime(keepAliveTime.toMillis(), TimeUnit.MILLISECONDS);
    }
    if (keepAliveTimeout != null) {
      builder.keepAliveTimeout(keepAliveTimeout.toMillis(), TimeUnit.MILLISECONDS);
    }
    if (keepAliveWithoutCalls != null) {
      builder.keepAliveWithoutCalls(keepAliveWithoutCalls);
    }
    if (interceptorProvider != null) {
      builder.intercept(interceptorProvider.getInterceptors());
    }
    if (channelConfigurator != null) {
      builder = channelConfigurator.apply(builder);
    }

    ManagedChannel managedChannel = builder.build();
    if (channelPrimer != null) {
      channelPrimer.primeChannel(managedChannel);
    }
    return managedChannel;
  }

  /* Remove provided headers that will also get set by {@link com.google.auth.ApiKeyCredentials}. They will be added as part of the grpc call when performing auth
   * {@link io.grpc.auth.GoogleAuthLibraryCallCredentials#applyRequestMetadata}.  GRPC does not dedup headers {@link https://github.com/grpc/grpc-java/blob/a140e1bb0cfa662bcdb7823d73320eb8d49046f1/api/src/main/java/io/grpc/Metadata.java#L504} so we must before initiating the call.
   *
   * Note: This is specific for ApiKeyCredentials as duplicate API key headers causes a failure on the back end.  At this time we are not sure of the behavior for other credentials.
   */
  private void removeApiKeyCredentialDuplicateHeaders() {
    if (headerProvider != null) {
      headersWithDuplicatesRemoved.putAll(headerProvider.getHeaders());
    }
    if (credentials != null && credentials instanceof ApiKeyCredentials) {
      try {
        Map<String, List<String>> credentialRequestMetatData = credentials.getRequestMetadata();
        if (credentialRequestMetatData != null) {
          headersWithDuplicatesRemoved.keySet().removeAll(credentialRequestMetatData.keySet());
        }
      } catch (IOException e) {
        // unreachable, there is no scenario that getRequestMetatData for ApiKeyCredentials will
        // throw an IOException
      }
    }
  }

  /**
   * Marked as Internal Api and intended for internal use. DirectPath must be enabled via the
   * settings and a few other configurations/settings must also be valid for the request to go
   * through DirectPath.
   *
   * <p>Checks: 1. Credentials are compatible 2.Running on Compute Engine 3. Universe Domain is
   * configured to for the Google Default Universe
   *
   * @return if DirectPath is enabled for the client AND if the configurations are valid
   */
  @InternalApi
  public boolean canUseDirectPath() {
    return isDirectPathEnabled()
        && isCredentialDirectPathCompatible()
        && isOnComputeEngine()
        && canUseDirectPathWithUniverseDomain();
  }

  /** The endpoint to be used for the channel. */
  @Override
  public String getEndpoint() {
    return endpoint;
  }

  /** This method is obsolete. Use {@link #getKeepAliveTimeDuration()} instead. */
  @ObsoleteApi("Use getKeepAliveTimeDuration() instead")
  public org.threeten.bp.Duration getKeepAliveTime() {
    return toThreetenDuration(getKeepAliveTimeDuration());
  }

  /** The time without read activity before sending a keepalive ping. */
  public java.time.Duration getKeepAliveTimeDuration() {
    return keepAliveTime;
  }

  /** This method is obsolete. Use {@link #getKeepAliveTimeoutDuration()} instead */
  @ObsoleteApi("Use getKeepAliveTimeoutDuration() instead")
  public org.threeten.bp.Duration getKeepAliveTimeout() {
    return toThreetenDuration(getKeepAliveTimeoutDuration());
  }

  /** The time without read activity after sending a keepalive ping. */
  public java.time.Duration getKeepAliveTimeoutDuration() {
    return keepAliveTimeout;
  }

  /** Whether keepalive will be performed when there are no outstanding RPCs. */
  public Boolean getKeepAliveWithoutCalls() {
    return keepAliveWithoutCalls;
  }

  /** The maximum metadata size allowed to be received on the channel. */
  @BetaApi("The surface for maximum metadata size is not stable yet and may change in the future.")
  public Integer getMaxInboundMetadataSize() {
    return maxInboundMetadataSize;
  }

  /** The configured channel pool settings used for gRPC's ChannelProvider */
  @BetaApi("Channel pool sizing api is not yet stable")
  public ChannelPoolSettings getChannelPoolSettings() {
    return channelPoolSettings;
  }

  /** Gets the background executor for channel refresh and resize. */
  ScheduledExecutorService getBackgroundExecutor() {
    return backgroundExecutor;
  }

  @Override
  public boolean shouldAutoClose() {
    return true;
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static final class Builder {
    @Deprecated private int processorCount;
    private Executor executor;
    private ScheduledExecutorService backgroundExecutor;
    private HeaderProvider headerProvider;
    private String endpoint;
    private String mtlsEndpoint;
    private boolean useS2A;
    private EnvironmentProvider envProvider;
    private SecureSessionAgent s2aConfigProvider = SecureSessionAgent.create();
    @Nullable private MtlsProvider mtlsProvider;
    private CertificateBasedAccess certificateBasedAccess;
    @Nullable private GrpcInterceptorProvider interceptorProvider;
    @Nullable private Integer maxInboundMessageSize;
    @Nullable private Integer maxInboundMetadataSize;
    @Nullable private java.time.Duration keepAliveTime;
    @Nullable private java.time.Duration keepAliveTimeout;
    @Nullable private Boolean keepAliveWithoutCalls;
    @Nullable private ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> channelConfigurator;
    @Nullable private Credentials credentials;
    @Nullable private CallCredentials altsCallCredentials;
    @Nullable private CallCredentials mtlsS2ACallCredentials;
    @Nullable private ChannelPrimer channelPrimer;
    private ChannelPoolSettings channelPoolSettings;
    @Nullable private Boolean attemptDirectPath;
    @Nullable private Boolean attemptDirectPathXds;
    @Nullable private Boolean allowNonDefaultServiceAccount;
    @Nullable private ImmutableMap<String, ?> directPathServiceConfig;
    private List<HardBoundTokenTypes> allowedHardBoundTokenTypes;

    private Builder() {
      processorCount = Runtime.getRuntime().availableProcessors();
      envProvider = System::getenv;
      channelPoolSettings = ChannelPoolSettings.staticallySized(1);
      allowedHardBoundTokenTypes = new ArrayList<>();
    }

    private Builder(InstantiatingGrpcChannelProvider provider) {
      this.processorCount = provider.processorCount;
      this.executor = provider.executor;
      this.backgroundExecutor = provider.backgroundExecutor;
      this.headerProvider = provider.headerProvider;
      this.endpoint = provider.endpoint;
      this.useS2A = provider.useS2A;
      this.envProvider = provider.envProvider;
      this.interceptorProvider = provider.interceptorProvider;
      this.maxInboundMessageSize = provider.maxInboundMessageSize;
      this.maxInboundMetadataSize = provider.maxInboundMetadataSize;
      this.keepAliveTime = provider.keepAliveTime;
      this.keepAliveTimeout = provider.keepAliveTimeout;
      this.keepAliveWithoutCalls = provider.keepAliveWithoutCalls;
      this.channelConfigurator = provider.channelConfigurator;
      this.credentials = provider.credentials;
      this.altsCallCredentials = provider.altsCallCredentials;
      this.mtlsS2ACallCredentials = provider.mtlsS2ACallCredentials;
      this.channelPrimer = provider.channelPrimer;
      this.channelPoolSettings = provider.channelPoolSettings;
      this.attemptDirectPath = provider.attemptDirectPath;
      this.attemptDirectPathXds = provider.attemptDirectPathXds;
      this.allowNonDefaultServiceAccount = provider.allowNonDefaultServiceAccount;
      this.allowedHardBoundTokenTypes = provider.allowedHardBoundTokenTypes;
      this.directPathServiceConfig = provider.directPathServiceConfig;
      this.mtlsProvider = provider.mtlsProvider;
      this.certificateBasedAccess = provider.certificateBasedAccess;
      this.s2aConfigProvider = provider.s2aConfigProvider;
    }

    /**
     * Sets the number of available CPUs, used internally for testing.
     *
     * @deprecated CPU based channel scaling is deprecated, please use RPC based scaling instead via
     *     {@link Builder#setChannelPoolSettings(ChannelPoolSettings)}
     */
    @Deprecated
    Builder setProcessorCount(int processorCount) {
      this.processorCount = processorCount;
      return this;
    }

    /**
     * Sets the Executor for this TransportChannelProvider.
     *
     * <p>This is optional; if it is not provided, needsExecutor() will return true, meaning that an
     * Executor must be provided when getChannel is called on the constructed
     * TransportChannelProvider instance. Note: GrpcTransportProvider will automatically provide its
     * own Executor in this circumstance when it calls getChannel.
     */
    public Builder setExecutor(Executor executor) {
      this.executor = executor;
      return this;
    }

    /**
     * @deprecated Please use {@link #setExecutor(Executor)}.
     */
    @Deprecated
    public Builder setExecutorProvider(ExecutorProvider executorProvider) {
      return setExecutor((Executor) executorProvider.getExecutor());
    }

    /**
     * Sets the background executor for this TransportChannelProvider. The life cycle of the
     * executor should be managed by the caller.
     */
    public Builder setBackgroundExecutor(ScheduledExecutorService executor) {
      this.backgroundExecutor = executor;
      return this;
    }

    /**
     * Sets the HeaderProvider for this TransportChannelProvider.
     *
     * <p>This is optional; if it is not provided, needsHeaders() will return true, meaning that
     * headers must be provided when getChannel is called on the constructed
     * TransportChannelProvider instance.
     */
    public Builder setHeaderProvider(HeaderProvider headerProvider) {
      this.headerProvider = headerProvider;
      return this;
    }

    /** Sets the endpoint used to reach the service, eg "localhost:8080". */
    public Builder setEndpoint(String endpoint) {
      validateEndpoint(endpoint);
      this.endpoint = endpoint;
      return this;
    }

    /** Sets the mTLS Endpoint used to reach the service, eg "localhost:8080". */
    @InternalApi("This public method is used by Gax to help configure the MTLS endpoint for S2A")
    public Builder setMtlsEndpoint(String mtlsEndpoint) {
      validateEndpoint(mtlsEndpoint);
      this.mtlsEndpoint = mtlsEndpoint;
      return this;
    }

    Builder setUseS2A(boolean useS2A) {
      this.useS2A = useS2A;
      return this;
    }

    /*
     * Sets the allowed hard bound token types for this TransportChannelProvider.
     *
     * <p>The list of
     * {@link HardBoundTokenTypes} indicates for which methods of connecting to Google APIs hard bound tokens should
     * be used. This is optional; if it is not provided, bearer tokens will be used.
     */
    @InternalApi
    public Builder setAllowHardBoundTokenTypes(List<HardBoundTokenTypes> allowedValues) {
      this.allowedHardBoundTokenTypes =
          Preconditions.checkNotNull(
              allowedValues, "List of allowed HardBoundTokenTypes cannot be null");
      ;
      return this;
    }

    @VisibleForTesting
    Builder setMtlsProvider(MtlsProvider mtlsProvider) {
      this.mtlsProvider = mtlsProvider;
      return this;
    }

    @VisibleForTesting
    Builder setCertificateBasedAccess(CertificateBasedAccess certificateBasedAccess) {
      this.certificateBasedAccess = certificateBasedAccess;
      return this;
    }

    @VisibleForTesting
    Builder setS2AConfigProvider(SecureSessionAgent s2aConfigProvider) {
      this.s2aConfigProvider = s2aConfigProvider;
      return this;
    }

    /**
     * Sets the GrpcInterceptorProvider for this TransportChannelProvider.
     *
     * <p>The provider will be called once for each underlying gRPC ManagedChannel that is created.
     * It is recommended to return a new list of new interceptors on each call so that interceptors
     * are not shared among channels, but this is not required.
     */
    public Builder setInterceptorProvider(GrpcInterceptorProvider interceptorProvider) {
      this.interceptorProvider = interceptorProvider;
      return this;
    }

    public String getEndpoint() {
      return endpoint;
    }

    /** The maximum message size allowed to be received on the channel. */
    public Builder setMaxInboundMessageSize(Integer max) {
      this.maxInboundMessageSize = max;
      return this;
    }

    /** The maximum message size allowed to be received on the channel. */
    public Integer getMaxInboundMessageSize() {
      return maxInboundMessageSize;
    }

    /** The maximum metadata size allowed to be received on the channel. */
    @BetaApi(
        "The surface for maximum metadata size is not stable yet and may change in the future.")
    public Builder setMaxInboundMetadataSize(Integer max) {
      this.maxInboundMetadataSize = max;
      return this;
    }

    /** The maximum metadata size allowed to be received on the channel. */
    @BetaApi(
        "The surface for maximum metadata size is not stable yet and may change in the future.")
    public Integer getMaxInboundMetadataSize() {
      return maxInboundMetadataSize;
    }

    /**
     * This method is obsolete. Use {@link #setKeepAliveTimeDuration(java.time.Duration)} instead.
     */
    @ObsoleteApi("Use setKeepAliveTimeDuration(java.time.Duration) instead")
    public Builder setKeepAliveTime(org.threeten.bp.Duration duration) {
      return setKeepAliveTimeDuration(toJavaTimeDuration(duration));
    }

    /** The time without read activity before sending a keepalive ping. */
    public Builder setKeepAliveTimeDuration(java.time.Duration duration) {
      this.keepAliveTime = duration;
      return this;
    }

    /** This method is obsolete. Use {@link #getKeepAliveTimeDuration()} instead. */
    @ObsoleteApi("Use getKeepAliveTimeDuration() instead")
    public org.threeten.bp.Duration getKeepAliveTime() {
      return toThreetenDuration(getKeepAliveTimeDuration());
    }

    /** The time without read activity before sending a keepalive ping. */
    public java.time.Duration getKeepAliveTimeDuration() {
      return keepAliveTime;
    }

    /**
     * This method is obsolete. Use {@link #setKeepAliveTimeoutDuration(java.time.Duration)}
     * instead.
     */
    @ObsoleteApi("Use setKeepAliveTimeoutDuration(java.time.Duration) instead")
    public Builder setKeepAliveTimeout(org.threeten.bp.Duration duration) {
      return setKeepAliveTimeoutDuration(toJavaTimeDuration(duration));
    }

    /** The time without read activity after sending a keepalive ping. */
    public Builder setKeepAliveTimeoutDuration(java.time.Duration duration) {
      this.keepAliveTimeout = duration;
      return this;
    }

    /** This method is obsolete. Use {@link #getKeepAliveTimeoutDuration()} instead */
    @ObsoleteApi("Use getKeepAliveTimeoutDuration() instead")
    public org.threeten.bp.Duration getKeepAliveTimeout() {
      return toThreetenDuration(getKeepAliveTimeoutDuration());
    }

    /** The time without read activity after sending a keepalive ping. */
    public java.time.Duration getKeepAliveTimeoutDuration() {
      return keepAliveTimeout;
    }

    /** Whether keepalive will be performed when there are no outstanding RPCs. */
    public Builder setKeepAliveWithoutCalls(Boolean keepalive) {
      this.keepAliveWithoutCalls = keepalive;
      return this;
    }

    /** Whether keepalive will be performed when there are no outstanding RPCs. */
    public Boolean getKeepAliveWithoutCalls() {
      return keepAliveWithoutCalls;
    }

    /**
     * @deprecated Please use {@link #setChannelPoolSettings(ChannelPoolSettings)}
     */
    @Deprecated
    public int getPoolSize() {
      return channelPoolSettings.getInitialChannelCount();
    }

    /**
     * @deprecated Please use {@link #setChannelPoolSettings(ChannelPoolSettings)}
     */
    @Deprecated
    public Builder setPoolSize(int poolSize) {
      channelPoolSettings = ChannelPoolSettings.staticallySized(poolSize);
      return this;
    }

    /**
     * @deprecated Please use {@link #setChannelPoolSettings(ChannelPoolSettings)}
     */
    @Deprecated
    public Builder setChannelsPerCpu(double multiplier) {
      return setChannelsPerCpu(multiplier, 100);
    }

    /**
     * @deprecated Please use {@link #setChannelPoolSettings(ChannelPoolSettings)}
     */
    @Deprecated
    public Builder setChannelsPerCpu(double multiplier, int maxChannels) {
      Preconditions.checkArgument(multiplier > 0, "multiplier must be positive");
      Preconditions.checkArgument(maxChannels > 0, "maxChannels must be positive");

      int channelCount = (int) Math.ceil(processorCount * multiplier);
      if (channelCount > maxChannels) {
        channelCount = maxChannels;
      }
      return setChannelPoolSettings(ChannelPoolSettings.staticallySized(channelCount));
    }

    @BetaApi("Channel pool sizing api is not yet stable")
    public Builder setChannelPoolSettings(ChannelPoolSettings settings) {
      this.channelPoolSettings = settings;
      return this;
    }

    public Builder setCredentials(Credentials credentials) {
      this.credentials = credentials;
      return this;
    }

    /**
     * By setting a channelPrimer, the ChannelPool created by the provider will be refreshing
     * ChannelPool. channelPrimer will be invoked periodically when the channels are refreshed
     *
     * <p>This is public only for technical reasons, for advanced usage.
     *
     * @param channelPrimer invoked when the channels are refreshed
     * @return builder for the provider
     */
    @InternalApi("For internal use by google-cloud-java clients only")
    public Builder setChannelPrimer(ChannelPrimer channelPrimer) {
      this.channelPrimer = channelPrimer;
      return this;
    }

    /** Whether attempt DirectPath. */
    @InternalApi("For internal use by google-cloud-java clients only")
    public Builder setAttemptDirectPath(boolean attemptDirectPath) {
      this.attemptDirectPath = attemptDirectPath;
      return this;
    }

    /** Whether allow non-default service account for DirectPath. */
    @InternalApi("For internal use by google-cloud-java clients only")
    public Builder setAllowNonDefaultServiceAccount(boolean allowNonDefaultServiceAccount) {
      this.allowNonDefaultServiceAccount = allowNonDefaultServiceAccount;
      return this;
    }

    /** Use DirectPath xDS. Only valid if DirectPath is attempted. */
    @InternalApi("For internal use by google-cloud-java clients only")
    public Builder setAttemptDirectPathXds() {
      this.attemptDirectPathXds = true;
      return this;
    }

    @VisibleForTesting
    Builder setEnvProvider(EnvironmentProvider envProvider) {
      this.envProvider = envProvider;
      return this;
    }

    /**
     * Sets a service config for direct path. If direct path is not enabled, the provided service
     * config will be ignored.
     *
     * <p>See <a href=
     * "https://github.com/grpc/grpc-proto/blob/master/grpc/service_config/service_config.proto">
     * the service config proto definition</a> for more details.
     */
    @InternalApi("For internal use by google-cloud-java clients only")
    public Builder setDirectPathServiceConfig(Map<String, ?> serviceConfig) {
      Preconditions.checkNotNull(serviceConfig, "serviceConfig");
      this.directPathServiceConfig = ImmutableMap.copyOf(serviceConfig);
      return this;
    }

    boolean isMtlsS2AHardBoundTokensEnabled() {
      // If S2A cannot be used, the list of allowed hard bound token types is empty or doesn't
      // contain
      // {@code HardBoundTokenTypes.MTLS_S2A}, the {@code credentials} are null or not of type
      // {@code
      // ComputeEngineCredentials} then {@code HardBoundTokenTypes.MTLS_S2A} hard bound tokens
      // should
      // not
      // be used. {@code HardBoundTokenTypes.MTLS_S2A} hard bound tokens can only be used on MTLS
      // channels established using S2A and when tokens from MDS (i.e {@code
      // ComputeEngineCredentials}
      // are being used.
      if (!this.useS2A
          || this.allowedHardBoundTokenTypes.isEmpty()
          || this.credentials == null
          || !(this.credentials instanceof ComputeEngineCredentials)) {
        return false;
      }
      return allowedHardBoundTokenTypes.stream()
          .anyMatch(val -> val.equals(HardBoundTokenTypes.MTLS_S2A));
    }

    boolean isDirectPathBoundTokenEnabled() {
      // If the list of allowed hard bound token types is empty or doesn't contain
      // {@code HardBoundTokenTypes.ALTS}, the {@code credentials} are null or not of type
      // {@code ComputeEngineCredentials} then DirectPath hard bound tokens should not be used.
      // DirectPath hard bound tokens should only be used on ALTS channels.
      if (allowedHardBoundTokenTypes.isEmpty()
          || this.credentials == null
          || !(credentials instanceof ComputeEngineCredentials)) return false;
      return allowedHardBoundTokenTypes.stream()
          .anyMatch(val -> val.equals(HardBoundTokenTypes.ALTS));
    }

    CallCredentials createHardBoundTokensCallCredentials(
        ComputeEngineCredentials.GoogleAuthTransport googleAuthTransport,
        ComputeEngineCredentials.BindingEnforcement bindingEnforcement) {
      ComputeEngineCredentials.Builder credsBuilder =
          ((ComputeEngineCredentials) credentials).toBuilder();
      // We only set scopes and HTTP transport factory from the original credentials because
      // only those are used in gRPC CallCredentials to fetch request metadata. We create a new
      // credential
      // via {@code newBuilder} as opposed to {@code toBuilder} because we don't want a reference to
      // the
      // access token held by {@code credentials}; we want this new credential to fetch a new access
      // token
      // from MDS using the {@param googleAuthTransport} and {@param bindingEnforcement}.
      return MoreCallCredentials.from(
          ComputeEngineCredentials.newBuilder()
              .setScopes(credsBuilder.getScopes())
              .setHttpTransportFactory(credsBuilder.getHttpTransportFactory())
              .setGoogleAuthTransport(googleAuthTransport)
              .setBindingEnforcement(bindingEnforcement)
              .build());
    }

    public InstantiatingGrpcChannelProvider build() {
      if (certificateBasedAccess == null) {
        certificateBasedAccess = CertificateBasedAccess.createWithSystemEnv();
      }
      if (certificateBasedAccess.useMtlsClientCertificate()) {
        if (mtlsProvider == null) {
          // Attempt to create default MtlsProvider from environment.
          try {
            mtlsProvider = DefaultMtlsProviderFactory.create();
          } catch (CertificateSourceUnavailableException e) {
            // This is okay. Leave mtlsProvider as null so that we will not auto-upgrade
            // to mTLS endpoints. See https://google.aip.dev/auth/4114.
          } catch (IOException e) {
            LOG.log(
                Level.WARNING,
                "DefaultMtlsProviderFactory encountered unexpected IOException: " + e.getMessage());
            LOG.log(
                Level.WARNING,
                "mTLS configuration was detected on the device, but mTLS failed to initialize. Falling back to non-mTLS channel.");
          }
        }
      }

      if (isMtlsS2AHardBoundTokensEnabled()) {
        // Set a {@code ComputeEngineCredentials} instance to be per-RPC call credentials,
        // which will be used to fetch MTLS_S2A hard bound tokens from the metdata server.
        this.mtlsS2ACallCredentials =
            createHardBoundTokensCallCredentials(
                ComputeEngineCredentials.GoogleAuthTransport.MTLS,
                ComputeEngineCredentials.BindingEnforcement.ON);
      }
      if (isDirectPathBoundTokenEnabled()) {
        this.altsCallCredentials =
            createHardBoundTokensCallCredentials(
                ComputeEngineCredentials.GoogleAuthTransport.ALTS, null);
      }
      InstantiatingGrpcChannelProvider instantiatingGrpcChannelProvider =
          new InstantiatingGrpcChannelProvider(this);
      instantiatingGrpcChannelProvider.removeApiKeyCredentialDuplicateHeaders();
      return instantiatingGrpcChannelProvider;
    }

    /**
     * Add a callback that can intercept channel creation.
     *
     * <p>This can be used for advanced configuration like setting the netty event loop. The
     * callback will be invoked with a fully configured channel builder, which the callback can
     * augment or replace.
     */
    @BetaApi("Surface for advanced channel configuration is not yet stable")
    public Builder setChannelConfigurator(
        @Nullable ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> channelConfigurator) {
      this.channelConfigurator = channelConfigurator;
      return this;
    }

    @Nullable
    public ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> getChannelConfigurator() {
      return channelConfigurator;
    }
  }

  private static ImmutableMap<String, ?> getDefaultDirectPathServiceConfig() {
    // When channel pooling is enabled, force the pick_first grpclb strategy.
    // This is necessary to avoid the multiplicative effect of creating channel pool with
    // `poolSize` number of `ManagedChannel`s, each with a `subSetting` number of number of
    // subchannels.
    // See the service config proto definition for more details:
    // https://github.com/grpc/grpc-proto/blob/master/grpc/service_config/service_config.proto
    ImmutableMap<String, Object> pickFirstStrategy =
        ImmutableMap.<String, Object>of("pick_first", ImmutableMap.of());

    ImmutableMap<String, Object> childPolicy =
        ImmutableMap.<String, Object>of("childPolicy", ImmutableList.of(pickFirstStrategy));

    ImmutableMap<String, Object> grpcLbPolicy =
        ImmutableMap.<String, Object>of("grpclb", childPolicy);

    return ImmutableMap.<String, Object>of("loadBalancingConfig", ImmutableList.of(grpcLbPolicy));
  }

  private static void validateEndpoint(String endpoint) {
    int colon = endpoint.lastIndexOf(':');
    if (colon < 0) {
      throw new IllegalArgumentException(
          String.format("invalid endpoint, expecting \"<host>:<port>\""));
    }
    Integer.parseInt(endpoint.substring(colon + 1));
  }
}
