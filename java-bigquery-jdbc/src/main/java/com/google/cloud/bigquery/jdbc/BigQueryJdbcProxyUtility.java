/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import static com.google.cloud.bigquery.storage.v1.stub.BigQueryReadStubSettings.defaultGrpcTransportProviderBuilder;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.apache.v5.Apache5HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.gax.httpjson.HttpJsonConscryptUtils;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.auth.http.HttpTransportFactory;
import com.google.cloud.bigquery.exception.BigQueryJdbcRuntimeException;
import com.google.cloud.http.HttpTransportOptions;
import io.grpc.HttpConnectProxiedSocketAddress;
import io.grpc.ProxiedSocketAddress;
import io.grpc.ProxyDetector;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslContext;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.Provider;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManagerFactory;
import org.apache.hc.client5.http.auth.AuthScope;
import org.apache.hc.client5.http.auth.UsernamePasswordCredentials;
import org.apache.hc.client5.http.impl.DefaultAuthenticationStrategy;
import org.apache.hc.client5.http.impl.auth.BasicCredentialsProvider;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.client5.http.impl.routing.DefaultProxyRoutePlanner;
import org.apache.hc.client5.http.routing.HttpRoutePlanner;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.core5.http.HttpHost;
import org.conscrypt.Conscrypt;

final class BigQueryJdbcProxyUtility {
  private static final BigQueryJdbcCustomLogger LOG =
      new BigQueryJdbcCustomLogger(BigQueryJdbcProxyUtility.class.getName());
  static final String validPortRegex =
      "^([1-9][0-9]{0,3}|[1-5][0-9]{4}|6[0-4][0-9]{3}|65[0-4][0-9]{2}|655[0-2][0-9]|6553[0-5])$";
  private static final String[] DEFAULT_CONSCRYPT_NAMED_GROUPS =
      new String[] {"X25519MLKEM768", "MLKEM1024", "X25519", "secp256r1", "secp384r1"};
  private static final Provider CONSCRYPT_PROVIDER = createConscryptProvider();
  private static final HttpTransport DEFAULT_TRANSPORT =
      HttpJsonConscryptUtils.configureConscryptSecurityProvider(new NetHttpTransport.Builder())
          .build();

  private BigQueryJdbcProxyUtility() {}

  private static Provider createConscryptProvider() {
    try {
      return Conscrypt.newProvider();
    } catch (SecurityException | LinkageError t) {
      LOG.fine(
          "Conscrypt native library unavailable, falling back to default SSL provider: "
              + t.getMessage());
      return null;
    }
  }

  private static SSLConnectionSocketFactory createSslConnectionSocketFactory(
      SSLContext sslContext) {
    return new SSLConnectionSocketFactory(sslContext) {
      @Override
      protected void prepareSocket(SSLSocket socket) throws IOException {
        if (Conscrypt.isConscrypt(socket)) {
          try {
            Conscrypt.setNamedGroups(socket, DEFAULT_CONSCRYPT_NAMED_GROUPS);
          } catch (Exception e) {
            LOG.fine("Failed to set PQC named groups on Conscrypt socket: " + e.getMessage());
          }
        }
      }
    };
  }

  static Map<String, String> parseProxyProperties(DataSource ds, String callerClassName) {
    LOG.finest("++enter++\t" + callerClassName);
    Map<String, String> proxyProperties = new HashMap<>();
    String proxyHost = ds.getProxyHost();
    if (proxyHost != null) {
      proxyProperties.put(BigQueryJdbcUrlUtility.PROXY_HOST_PROPERTY_NAME, proxyHost);
    }
    String proxyPort = ds.getProxyPort();
    if (proxyPort != null) {
      if (!Pattern.compile(validPortRegex).matcher(proxyPort).find()) {
        IllegalArgumentException ex =
            new IllegalArgumentException(
                String.format(
                    "Illegal port number provided %s. Please provide a valid port number.",
                    proxyPort));
        LOG.severe(ex.getMessage(), ex);
        throw ex;
      }
      proxyProperties.put(BigQueryJdbcUrlUtility.PROXY_PORT_PROPERTY_NAME, proxyPort);
    }
    String proxyUid = ds.getProxyUid();
    if (proxyUid != null) {
      proxyProperties.put(BigQueryJdbcUrlUtility.PROXY_USER_ID_PROPERTY_NAME, proxyUid);
    }
    String proxyPwd = ds.getProxyPwd();
    if (proxyPwd != null) {
      proxyProperties.put(BigQueryJdbcUrlUtility.PROXY_PASSWORD_PROPERTY_NAME, proxyPwd);
    }

    boolean isMissingProxyHostOrPortWhenProxySet =
        (proxyHost == null && proxyPort != null) || (proxyHost != null && proxyPort == null);
    if (isMissingProxyHostOrPortWhenProxySet) {
      IllegalArgumentException ex =
          new IllegalArgumentException(
              "Both ProxyHost and ProxyPort parameters need to be specified. No defaulting behavior"
                  + " occurs.");
      LOG.severe(ex.getMessage(), ex);
      throw ex;
    }
    boolean isMissingProxyUidOrPwdWhenAuthSet =
        (proxyUid == null && proxyPwd != null) || (proxyUid != null && proxyPwd == null);
    if (isMissingProxyUidOrPwdWhenAuthSet) {
      IllegalArgumentException ex =
          new IllegalArgumentException(
              "Both ProxyUid and ProxyPwd parameters need to be specified for authentication.");
      LOG.severe(ex.getMessage(), ex);
      throw ex;
    }
    boolean isProxyAuthSetWithoutProxySettings = proxyUid != null && proxyHost == null;
    if (isProxyAuthSetWithoutProxySettings) {
      IllegalArgumentException ex =
          new IllegalArgumentException(
              "Proxy authentication provided via connection string with no proxy host or port set.");
      LOG.severe(ex.getMessage(), ex);
      throw ex;
    }
    return proxyProperties;
  }

  static Map<String, String> parseProxyProperties(String URL, String callerClassName) {
    return parseProxyProperties(DataSource.fromUrl(URL), callerClassName);
  }

  static HttpTransportOptions getHttpTransportOptions(
      Map<String, String> proxyProperties,
      String sslTrustStorePath,
      String sslTrustStorePassword,
      String sslTrustStoreType,
      String sslTrustStoreProvider,
      Integer connectTimeout,
      Integer readTimeout,
      String callerClassName) {
    LOG.finest("++enter++\t" + callerClassName);

    boolean hasProxyOrSsl =
        proxyProperties.containsKey(BigQueryJdbcUrlUtility.PROXY_HOST_PROPERTY_NAME)
            || sslTrustStorePath != null;

    HttpTransportOptions.Builder httpTransportOptionsBuilder = HttpTransportOptions.newBuilder();
    if (hasProxyOrSsl) {
      httpTransportOptionsBuilder.setHttpTransportFactory(
          getHttpTransportFactory(
              proxyProperties,
              sslTrustStorePath,
              sslTrustStorePassword,
              sslTrustStoreType,
              sslTrustStoreProvider,
              callerClassName));
    } else {
      httpTransportOptionsBuilder.setHttpTransportFactory(() -> DEFAULT_TRANSPORT);
    }

    if (connectTimeout != null) {
      httpTransportOptionsBuilder.setConnectTimeout(connectTimeout);
    }
    if (readTimeout != null) {
      httpTransportOptionsBuilder.setReadTimeout(readTimeout);
    }

    return httpTransportOptionsBuilder.build();
  }

  private static HttpTransportFactory getHttpTransportFactory(
      Map<String, String> proxyProperties,
      String sslTrustStorePath,
      String sslTrustStorePassword,
      String sslTrustStoreType,
      String sslTrustStoreProvider,
      String callerClassName) {
    LOG.finest("++enter++\t" + callerClassName);
    HttpClientBuilder httpClientBuilder = HttpClients.custom();
    boolean explicitProxySet =
        proxyProperties.containsKey(BigQueryJdbcUrlUtility.PROXY_HOST_PROPERTY_NAME);

    if (explicitProxySet) {
      HttpHost proxyHostDetails =
          new HttpHost(
              proxyProperties.get(BigQueryJdbcUrlUtility.PROXY_HOST_PROPERTY_NAME),
              Integer.parseInt(
                  proxyProperties.get(BigQueryJdbcUrlUtility.PROXY_PORT_PROPERTY_NAME)));
      HttpRoutePlanner httpRoutePlanner = new DefaultProxyRoutePlanner(proxyHostDetails);
      httpClientBuilder.setRoutePlanner(httpRoutePlanner);
      addAuthToProxyIfPresent(proxyProperties, httpClientBuilder, callerClassName);
    }
    httpClientBuilder.useSystemProperties();

    if (sslTrustStorePath != null) {
      try (FileInputStream trustStoreStream = new FileInputStream(sslTrustStorePath)) {
        KeyStore trustStore = loadKeyStore(sslTrustStoreType, sslTrustStoreProvider);
        char[] trustStorePasswordChars =
            sslTrustStorePassword != null ? sslTrustStorePassword.toCharArray() : null;
        trustStore.load(trustStoreStream, trustStorePasswordChars);

        TrustManagerFactory trustManagerFactory =
            CONSCRYPT_PROVIDER != null
                ? TrustManagerFactory.getInstance(
                    TrustManagerFactory.getDefaultAlgorithm(), CONSCRYPT_PROVIDER)
                : TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(trustStore);

        SSLContext sslContext =
            CONSCRYPT_PROVIDER != null
                ? SSLContext.getInstance("TLS", CONSCRYPT_PROVIDER)
                : SSLContext.getInstance("TLS");
        sslContext.init(null, trustManagerFactory.getTrustManagers(), null);

        SSLConnectionSocketFactory sslSocketFactory = createSslConnectionSocketFactory(sslContext);
        httpClientBuilder.setConnectionManager(
            PoolingHttpClientConnectionManagerBuilder.create()
                .setSSLSocketFactory(sslSocketFactory)
                .build());
      } catch (IOException | GeneralSecurityException e) {
        throw new BigQueryJdbcRuntimeException(
            "Failed to configure SSL TrustStore for HTTP transport", e);
      }
    } else if (CONSCRYPT_PROVIDER != null) {
      try {
        TrustManagerFactory trustManagerFactory =
            TrustManagerFactory.getInstance(
                TrustManagerFactory.getDefaultAlgorithm(), CONSCRYPT_PROVIDER);
        trustManagerFactory.init((KeyStore) null);
        SSLContext sslContext = SSLContext.getInstance("TLS", CONSCRYPT_PROVIDER);
        sslContext.init(null, trustManagerFactory.getTrustManagers(), null);
        SSLConnectionSocketFactory sslSocketFactory = createSslConnectionSocketFactory(sslContext);
        httpClientBuilder.setConnectionManager(
            PoolingHttpClientConnectionManagerBuilder.create()
                .setSSLSocketFactory(sslSocketFactory)
                .build());
      } catch (GeneralSecurityException e) {
        LOG.fine(
            "Failed to configure Conscrypt SSLContext for proxy HTTP transport. Falling back to"
                + " default SSLContext: "
                + e.getMessage());
      }
    }
    addAuthToProxyIfPresent(proxyProperties, httpClientBuilder, callerClassName);

    CloseableHttpClient httpClient = httpClientBuilder.build();
    final HttpTransport httpTransport = new Apache5HttpTransport(httpClient);
    return () -> httpTransport;
  }

  private static void addAuthToProxyIfPresent(
      Map<String, String> proxyProperties,
      HttpClientBuilder closeableHttpClientBuilder,
      String callerClassName) {
    LOG.finest("++enter++\t" + callerClassName);
    if (proxyProperties.containsKey(BigQueryJdbcUrlUtility.PROXY_USER_ID_PROPERTY_NAME)
        && proxyProperties.containsKey(BigQueryJdbcUrlUtility.PROXY_PASSWORD_PROPERTY_NAME)) {

      AuthScope authScope =
          new AuthScope(
              proxyProperties.get(BigQueryJdbcUrlUtility.PROXY_HOST_PROPERTY_NAME),
              Integer.parseInt(
                  proxyProperties.get(BigQueryJdbcUrlUtility.PROXY_PORT_PROPERTY_NAME)));
      UsernamePasswordCredentials usernamePasswordCredentials =
          new UsernamePasswordCredentials(
              proxyProperties.get(BigQueryJdbcUrlUtility.PROXY_USER_ID_PROPERTY_NAME),
              proxyProperties
                  .get(BigQueryJdbcUrlUtility.PROXY_PASSWORD_PROPERTY_NAME)
                  .toCharArray());

      BasicCredentialsProvider proxyCredentialsProvider = new BasicCredentialsProvider();
      proxyCredentialsProvider.setCredentials(authScope, usernamePasswordCredentials);
      closeableHttpClientBuilder.setDefaultCredentialsProvider(proxyCredentialsProvider);
      closeableHttpClientBuilder.setProxyAuthenticationStrategy(
          DefaultAuthenticationStrategy.INSTANCE); // order of challenge? so it will show up
    }
  }

  static TransportChannelProvider getTransportChannelProvider(
      Map<String, String> proxyProperties,
      String sslTrustStorePath,
      String sslTrustStorePassword,
      String sslTrustStoreType,
      String sslTrustStoreProvider,
      String callerClassName) {
    LOG.finest("++enter++\t" + callerClassName);
    boolean hasProxy = proxyProperties.containsKey(BigQueryJdbcUrlUtility.PROXY_HOST_PROPERTY_NAME);
    boolean hasSsl = sslTrustStorePath != null;

    if (!hasProxy && !hasSsl) {
      return null;
    }

    TransportChannelProvider transportChannelProvider =
        defaultGrpcTransportProviderBuilder()
            .setChannelConfigurator(
                managedChannelBuilder -> {
                  if (hasProxy) {
                    managedChannelBuilder.proxyDetector(
                        new ProxyDetector() {
                          @Override
                          public ProxiedSocketAddress proxyFor(SocketAddress socketAddress) {
                            return getHttpConnectProxiedSocketAddress(
                                (InetSocketAddress) socketAddress, proxyProperties);
                          }
                        });
                  }
                  if (hasSsl
                      && managedChannelBuilder
                          instanceof io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder) {
                    try (FileInputStream trustStoreStream =
                        new FileInputStream(sslTrustStorePath)) {
                      KeyStore trustStore = loadKeyStore(sslTrustStoreType, sslTrustStoreProvider);
                      char[] trustStorePasswordChars =
                          sslTrustStorePassword != null
                              ? sslTrustStorePassword.toCharArray()
                              : null;
                      trustStore.load(trustStoreStream, trustStorePasswordChars);

                      TrustManagerFactory trustManagerFactory =
                          TrustManagerFactory.getInstance(
                              TrustManagerFactory.getDefaultAlgorithm());
                      trustManagerFactory.init(trustStore);

                      SslContext grpcSslContext =
                          GrpcSslContexts.forClient().trustManager(trustManagerFactory).build();
                      ((io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder)
                              managedChannelBuilder)
                          .sslContext(grpcSslContext);

                    } catch (IOException | GeneralSecurityException e) {
                      throw new BigQueryJdbcRuntimeException(
                          "Failed to configure SSL TrustStore for GRPC channel", e);
                    }
                  }
                  return managedChannelBuilder;
                })
            .build();
    return transportChannelProvider;
  }

  private static KeyStore loadKeyStore(String type, String provider)
      throws GeneralSecurityException {
    String resolvedType =
        (type != null && !type.trim().isEmpty()) ? type.trim() : KeyStore.getDefaultType();
    return (provider != null && !provider.trim().isEmpty())
        ? KeyStore.getInstance(resolvedType, provider.trim())
        : KeyStore.getInstance(resolvedType);
  }

  private static HttpConnectProxiedSocketAddress getHttpConnectProxiedSocketAddress(
      InetSocketAddress socketAddress, Map<String, String> proxyProperties) {
    String proxyHost = proxyProperties.get(BigQueryJdbcUrlUtility.PROXY_HOST_PROPERTY_NAME);
    int proxyPort =
        Integer.parseInt(proxyProperties.get(BigQueryJdbcUrlUtility.PROXY_PORT_PROPERTY_NAME));
    HttpConnectProxiedSocketAddress.Builder builder =
        HttpConnectProxiedSocketAddress.newBuilder()
            .setProxyAddress(new InetSocketAddress(proxyHost, proxyPort))
            .setTargetAddress(socketAddress);
    if (proxyProperties.containsKey(BigQueryJdbcUrlUtility.PROXY_USER_ID_PROPERTY_NAME)
        && proxyProperties.containsKey(BigQueryJdbcUrlUtility.PROXY_PASSWORD_PROPERTY_NAME)) {
      builder.setUsername(proxyProperties.get(BigQueryJdbcUrlUtility.PROXY_USER_ID_PROPERTY_NAME));
      builder.setPassword(proxyProperties.get(BigQueryJdbcUrlUtility.PROXY_PASSWORD_PROPERTY_NAME));
    }
    return builder.build();
  }
}
