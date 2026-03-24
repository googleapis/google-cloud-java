package com.google.showcase.v1beta1.it;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnauthenticatedException;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.truth.Truth;
import com.google.showcase.v1beta1.EchoClient;
import com.google.showcase.v1beta1.EchoRequest;
import com.google.showcase.v1beta1.EchoSettings;
import com.google.showcase.v1beta1.it.util.TestClientInitializer;
import com.google.showcase.v1beta1.stub.EchoStub;
import com.google.showcase.v1beta1.stub.EchoStubSettings;
import io.grpc.ManagedChannelBuilder;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

/**
 * This IT tests the different user configurations allowed and their effects on endpoint and
 * universe domain resolution.
 *
 * <p>In these tests, the client is not initialized with the default configuration:
 * `EchoClient.create()`. For showcase tests run in CI, the client must be supplied explicitly
 * supplied with a Credentials value. The tests use a wrapped Credentials and Credentials Provider
 * (UniverseDomainCredentials and UniverseDomainCredentialsProvider) which allow for testing this.
 *
 * <p>Endpoint resolution has the same behavior for both gRPC and HttpJson. The showcase tests below
 * only use the gRPC transport for testing. HttpJson functionality exists inside the wrapper
 * classes, but is not being used.
 */
class ITEndpointContext {
  /**
   * Inside the test cases below, we must explicitly configure serviceName. Normally this should not
   * be configured at all, but showcase clients do not have a serviceName. The ExtendStubSettings
   * wrapper return the serviceName by overriding the `getServiceName()` result.
   */
  private static class ExtendedEchoStubSettings extends EchoStubSettings {

    private static final String DUMMY_MTLS_ENDPOINT = "mtls.googleapis.com:443";

    protected ExtendedEchoStubSettings(Builder settingsBuilder) throws IOException {
      super(settingsBuilder);
    }

    @Override
    public String getServiceName() {
      return "test";
    }

    public static ExtendedEchoStubSettings.Builder newBuilder() {
      return ExtendedEchoStubSettings.Builder.createDefault();
    }

    public static ExtendedEchoStubSettings.Builder newHttpJsonBuilder() {
      return ExtendedEchoStubSettings.Builder.createHttpJsonDefault();
    }

    public static class Builder extends EchoStubSettings.Builder {

      protected Builder(ClientContext clientContext) {
        super(clientContext);
      }

      private static ExtendedEchoStubSettings.Builder createDefault() {
        Builder builder = new Builder(((ClientContext) null));
        builder.setTransportChannelProvider(defaultTransportChannelProvider());
        builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
        builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
        builder.setMtlsEndpoint(DUMMY_MTLS_ENDPOINT);
        builder.setSwitchToMtlsEndpointAllowed(true);
        return builder;
      }

      private static ExtendedEchoStubSettings.Builder createHttpJsonDefault() {
        Builder builder = new Builder(((ClientContext) null));
        builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
        builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
        builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
        builder.setMtlsEndpoint(DUMMY_MTLS_ENDPOINT);
        builder.setSwitchToMtlsEndpointAllowed(true);
        return builder;
      }

      @Override
      public ExtendedEchoStubSettings build() throws IOException {
        return new ExtendedEchoStubSettings(this);
      }
    }
  }

  /**
   * Without this ClientSettings wrapper, we must expose a serviceName setter to
   * (Client|Stub)Settings and pass the StubSettings to the client. However, this will result in a
   * null ClientSettings (See {@link EchoClient#create(EchoStub)}). Passing the stub to the Client
   * will result in a NPE when doing `Client.getSettings().get(Endpoint|UniverseDomain)` as the
   * ClientSettings is stored as null.
   */
  private static class ExtendedEchoSettings extends EchoSettings {

    protected ExtendedEchoSettings(Builder settingsBuilder) throws IOException {
      super(settingsBuilder);
    }

    public static EchoSettings.Builder newBuilder() {
      return ExtendedEchoSettings.Builder.createDefault();
    }

    public static EchoSettings.Builder newHttpJsonBuilder() {
      return ExtendedEchoSettings.Builder.createHttpJsonDefault();
    }

    public static class Builder extends EchoSettings.Builder {
      protected Builder() throws IOException {}

      private static ExtendedEchoSettings.Builder createDefault() {
        return new ExtendedEchoSettings.Builder(ExtendedEchoStubSettings.newBuilder());
      }

      private static ExtendedEchoSettings.Builder createHttpJsonDefault() {
        return new ExtendedEchoSettings.Builder(ExtendedEchoStubSettings.newHttpJsonBuilder());
      }

      protected Builder(ClientContext clientContext) {
        super(clientContext);
      }

      protected Builder(EchoSettings settings) {
        super(settings);
      }

      protected Builder(ExtendedEchoStubSettings.Builder stubSettings) {
        super(stubSettings);
      }
    }
  }

  /**
   * Credentials Wrapper for showcase testing which is used to override the Universe Domain value.
   *
   * <p>For the tests below, it will act as a valid Credentials and is used to test the flows where
   * the user passes in a Credentials (i.e. ServiceAccount, AccessToken, Oauth, etc.)
   */
  private static class UniverseDomainCredentials extends Credentials {

    private final String universeDomain;

    private UniverseDomainCredentials(String universeDomain) {
      this.universeDomain = universeDomain;
    }

    @Override
    public String getAuthenticationType() {
      return null;
    }

    @Override
    public Map<String, List<String>> getRequestMetadata(URI uri) {
      return new HashMap<>();
    }

    @Override
    public boolean hasRequestMetadata() {
      return false;
    }

    @Override
    public boolean hasRequestMetadataOnly() {
      return false;
    }

    @Override
    public void refresh() {
      // no-op
    }

    @Override
    public String getUniverseDomain() {
      return universeDomain;
    }
  }

  /**
   * CredentialsProvider wrapper to return the wrapped Universe Domain Credentials. This will return
   * the custom Universe Domain value.
   */
  private static class UniverseDomainCredentialsProvider implements CredentialsProvider {

    private final String universeDomain;

    public UniverseDomainCredentialsProvider(String universeDomain) {
      this.universeDomain = universeDomain;
    }

    public static UniverseDomainCredentialsProvider create() {
      return new UniverseDomainCredentialsProvider(GoogleCredentials.GOOGLE_DEFAULT_UNIVERSE);
    }

    public static UniverseDomainCredentialsProvider create(String universeDomain) {
      return new UniverseDomainCredentialsProvider(universeDomain);
    }

    @Override
    public Credentials getCredentials() {
      return new UniverseDomainCredentials(universeDomain);
    }
  }

  private static final String DEFAULT_ENDPOINT = "test.googleapis.com:443";
  private static final EchoRequest DEFAULT_REQUEST =
      EchoRequest.newBuilder().setContent("echo").build();

  private EchoClient echoClient;

  @AfterEach
  void cleanup() throws InterruptedException {
    if (echoClient != null) {
      echoClient.close();
      echoClient.awaitTermination(
          TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
    }
  }

  // Default (no configuration)
  @Test
  void endpointResolution_default() throws IOException {
    EchoSettings echoSettings =
        ExtendedEchoSettings.newBuilder()
            .setCredentialsProvider(UniverseDomainCredentialsProvider.create())
            .build();
    echoClient = EchoClient.create(echoSettings);
    Truth.assertThat(echoClient.getSettings().getEndpoint()).isEqualTo(DEFAULT_ENDPOINT);
    Truth.assertThat(echoClient.getSettings().getUniverseDomain())
        .isEqualTo(GoogleCredentials.GOOGLE_DEFAULT_UNIVERSE);
  }

  // User configuration
  @Test
  void endpointResolution_userSetEndpoint() throws IOException {
    String customEndpoint = "test.com:123";
    EchoSettings echoSettings =
        ExtendedEchoSettings.newBuilder()
            .setCredentialsProvider(UniverseDomainCredentialsProvider.create())
            .setEndpoint(customEndpoint)
            .build();
    echoClient = EchoClient.create(echoSettings);
    Truth.assertThat(echoClient.getSettings().getEndpoint()).isEqualTo(customEndpoint);
    Truth.assertThat(echoClient.getSettings().getUniverseDomain())
        .isEqualTo(GoogleCredentials.GOOGLE_DEFAULT_UNIVERSE);
  }

  @Test
  void endpointResolution_userSetUniverseDomainAndNoUserSetEndpoint() throws IOException {
    String customUniverseDomain = "random.com";
    EchoSettings echoSettings =
        ExtendedEchoSettings.newBuilder()
            .setCredentialsProvider(UniverseDomainCredentialsProvider.create())
            .setUniverseDomain(customUniverseDomain)
            .build();
    echoClient = EchoClient.create(echoSettings);
    // If user configured the universe domain, the endpoint is constructed from it
    Truth.assertThat(echoClient.getSettings().getEndpoint()).isEqualTo("test.random.com:443");
    Truth.assertThat(echoClient.getSettings().getUniverseDomain()).isEqualTo(customUniverseDomain);
  }

  @Test
  void endpointResolution_userSetEndpointAndUniverseDomain() throws IOException {
    String customEndpoint = "custom.endpoint.com:443";
    String customUniverseDomain = "random.com";
    EchoSettings echoSettings =
        ExtendedEchoSettings.newBuilder()
            .setCredentialsProvider(UniverseDomainCredentialsProvider.create())
            .setEndpoint(customEndpoint)
            .setUniverseDomain(customUniverseDomain)
            .build();
    echoClient = EchoClient.create(echoSettings);
    // Custom Endpoint sets the endpoint for the client to use
    Truth.assertThat(echoClient.getSettings().getEndpoint()).isEqualTo(customEndpoint);
    // The universe domain doesn't match the endpoint. The call will fail validation when RPC is
    // called.
    Truth.assertThat(echoClient.getSettings().getUniverseDomain()).isEqualTo(customUniverseDomain);
  }

  @Test
  void universeDomainValidation_credentialsGDU_noUserConfiguration() throws IOException {
    EchoSettings echoSettings =
        ExtendedEchoSettings.newBuilder()
            .setCredentialsProvider(UniverseDomainCredentialsProvider.create())
            .setEndpoint(TestClientInitializer.DEFAULT_GRPC_ENDPOINT)
            .setTransportChannelProvider(
                EchoSettings.defaultGrpcTransportProviderBuilder()
                    .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
                    .build())
            .build();
    echoClient = EchoClient.create(echoSettings);

    // Does not throw an error
    echoClient.echo(DEFAULT_REQUEST);
  }

  @Test
  void universeDomainValidation_credentialsNonGDU_noUserConfiguration() throws IOException {
    EchoSettings echoSettings =
        ExtendedEchoSettings.newBuilder()
            .setCredentialsProvider(UniverseDomainCredentialsProvider.create("random.com"))
            .setEndpoint(TestClientInitializer.DEFAULT_GRPC_ENDPOINT)
            .setTransportChannelProvider(
                EchoSettings.defaultGrpcTransportProviderBuilder()
                    .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
                    .build())
            .build();
    echoClient = EchoClient.create(echoSettings);

    UnauthenticatedException exception =
        assertThrows(UnauthenticatedException.class, () -> echoClient.echo(DEFAULT_REQUEST));
    Truth.assertThat(exception.getMessage())
        .contains(
            "The configured universe domain (googleapis.com) does not match the universe domain"
                + " found in the credentials (random.com).");
  }

  @Test
  void universeDomainValidation_credentialsNonGDUMatchesUserConfiguration() throws IOException {
    String universeDomain = "random.com";
    EchoSettings echoSettings =
        ExtendedEchoSettings.newBuilder()
            .setCredentialsProvider(UniverseDomainCredentialsProvider.create(universeDomain))
            .setEndpoint(TestClientInitializer.DEFAULT_GRPC_ENDPOINT)
            .setUniverseDomain(universeDomain)
            .setTransportChannelProvider(
                EchoSettings.defaultGrpcTransportProviderBuilder()
                    .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
                    .build())
            .build();
    echoClient = EchoClient.create(echoSettings);

    // Does not throw an error
    echoClient.echo(DEFAULT_REQUEST);
  }

  @Test
  void universeDomainValidation_credentialsNonGDUDoesNotMatchUserConfiguration()
      throws IOException {
    String universeDomain = "random.com";
    String userConfigurationUniverseDomain = "test.com";
    EchoSettings echoSettings =
        ExtendedEchoSettings.newBuilder()
            .setCredentialsProvider(UniverseDomainCredentialsProvider.create(universeDomain))
            .setEndpoint(TestClientInitializer.DEFAULT_GRPC_ENDPOINT)
            .setUniverseDomain(userConfigurationUniverseDomain)
            .setTransportChannelProvider(
                EchoSettings.defaultGrpcTransportProviderBuilder()
                    .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
                    .build())
            .build();
    echoClient = EchoClient.create(echoSettings);

    UnauthenticatedException exception =
        assertThrows(UnauthenticatedException.class, () -> echoClient.echo(DEFAULT_REQUEST));
    Truth.assertThat(exception.getMessage())
        .contains(
            "The configured universe domain (test.com) does not match the universe domain found in"
                + " the credentials (random.com).");
  }

  // This test uses NoCredentialsProvider (will default to GDU)
  @Test
  void universeDomainValidation_noCredentials_noUserSetUniverseDomain() throws IOException {
    EchoSettings echoSettings =
        ExtendedEchoSettings.newBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setEndpoint(TestClientInitializer.DEFAULT_GRPC_ENDPOINT)
            .setTransportChannelProvider(
                EchoSettings.defaultGrpcTransportProviderBuilder()
                    .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
                    .build())
            .build();
    echoClient = EchoClient.create(echoSettings);

    // Does not throw an error
    echoClient.echo(DEFAULT_REQUEST);
  }

  // This test uses NoCredentialsProvider (will default to GDU)
  @Test
  void universeDomainValidation_noCredentials_userSetUniverseDomain() throws IOException {
    String universeDomain = "random.com";
    EchoSettings echoSettings =
        ExtendedEchoSettings.newBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setEndpoint(TestClientInitializer.DEFAULT_GRPC_ENDPOINT)
            .setUniverseDomain(universeDomain)
            .setTransportChannelProvider(
                EchoSettings.defaultGrpcTransportProviderBuilder()
                    .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
                    .build())
            .build();
    echoClient = EchoClient.create(echoSettings);

    UnauthenticatedException exception =
        assertThrows(UnauthenticatedException.class, () -> echoClient.echo(DEFAULT_REQUEST));
    Truth.assertThat(exception.getMessage())
        .contains(
            "The configured universe domain (random.com) does not match the universe domain found"
                + " in the credentials (googleapis.com).");
  }

  // Default in Builder (no configuration)
  @Test
  void endpointResolution_defaultViaBuilder() {
    EchoSettings.Builder echoSettingsBuilder = EchoSettings.newBuilder();
    // `StubSettings.newBuilder()` will return the clientSettingsEndpoint
    Truth.assertThat(echoSettingsBuilder.getEndpoint()).isEqualTo(null);
  }

  // User configuration in Builder
  @Test
  void endpointResolution_userConfigurationViaBuilder() {
    EchoSettings.Builder echoSettingsBuilder =
        EchoSettings.newBuilder().setEndpoint("test.com:123");
    // `StubSettings.newBuilder()` will return the clientSettingsEndpoint
    Truth.assertThat(echoSettingsBuilder.getEndpoint()).isEqualTo("test.com:123");
  }

  @Test
  void endpointResolution_builderBuilderBackToBuilder() throws IOException {
    String customEndpoint = "test.com:123";
    EchoStubSettings.Builder echoStubSettingsBuilder =
        EchoStubSettings.newBuilder().setEndpoint(customEndpoint);
    // `StubSettings.newBuilder()` will return the clientSettingsEndpoint
    Truth.assertThat(echoStubSettingsBuilder.getEndpoint()).isEqualTo(customEndpoint);

    // EndpointContext is recomputed when the Builder is re-built
    EchoStubSettings echoStubSettings = echoStubSettingsBuilder.build();
    Truth.assertThat(echoStubSettings.getEndpoint()).isEqualTo(customEndpoint);

    // Calling toBuilder on StubSettings keeps the configurations the same
    echoStubSettingsBuilder = echoStubSettings.toBuilder();
    Truth.assertThat(echoStubSettingsBuilder.getEndpoint()).isEqualTo(customEndpoint);
  }

  @Test
  void universeDomainValidation_quotaProjectId_credentialsNonGDUMatchesUserConfiguration()
      throws IOException {
    String universeDomain = "random.com";
    EchoSettings echoSettings =
        ExtendedEchoSettings.newBuilder()
            .setQuotaProjectId("exampleProject")
            .setCredentialsProvider(UniverseDomainCredentialsProvider.create(universeDomain))
            .setEndpoint(TestClientInitializer.DEFAULT_GRPC_ENDPOINT)
            .setUniverseDomain(universeDomain)
            .setTransportChannelProvider(
                EchoSettings.defaultGrpcTransportProviderBuilder()
                    .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
                    .build())
            .build();
    echoClient = EchoClient.create(echoSettings);
    Truth.assertThat(echoClient.echo(DEFAULT_REQUEST).getContent()).isEqualTo("echo");
  }
}
