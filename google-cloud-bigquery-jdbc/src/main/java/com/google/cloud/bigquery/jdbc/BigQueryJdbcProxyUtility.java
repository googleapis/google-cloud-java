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
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import javax.net.ssl.SSLContext;
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

final class BigQueryJdbcProxyUtility {
  private static final BigQueryJdbcCustomLogger LOG =
      new BigQueryJdbcCustomLogger(BigQueryJdbcProxyUtility.class.getName());
  static final String validPortRegex =
      "^([1-9][0-9]{0,3}|[1-5][0-9]{4}|6[0-4][0-9]{3}|65[0-4][0-9]{2}|655[0-2][0-9]|6553[0-5])$";

  private BigQueryJdbcProxyUtility() {}

  static Map<String, String> parseProxyProperties(String URL, String callerClassName) {
    LOG.finest("++enter++\t" + callerClassName);
    Map<String, String> proxyProperties = new HashMap<>();
    String proxyHost =
        BigQueryJdbcUrlUtility.parseUriProperty(
            URL, BigQueryJdbcUrlUtility.PROXY_HOST_PROPERTY_NAME);
    if (proxyHost != null) {
      proxyProperties.put(BigQueryJdbcUrlUtility.PROXY_HOST_PROPERTY_NAME, proxyHost);
    }
    String proxyPort =
        BigQueryJdbcUrlUtility.parseUriProperty(
            URL, BigQueryJdbcUrlUtility.PROXY_PORT_PROPERTY_NAME);
    if (proxyPort != null) {
      if (!Pattern.compile(validPortRegex).matcher(proxyPort).find()) {
        throw new IllegalArgumentException(
            "Illegal port number provided %s. Please provide a valid port number.");
      }
      proxyProperties.put(BigQueryJdbcUrlUtility.PROXY_PORT_PROPERTY_NAME, proxyPort);
    }
    String proxyUid =
        BigQueryJdbcUrlUtility.parseUriProperty(
            URL, BigQueryJdbcUrlUtility.PROXY_USER_ID_PROPERTY_NAME);
    if (proxyUid != null) {
      proxyProperties.put(BigQueryJdbcUrlUtility.PROXY_USER_ID_PROPERTY_NAME, proxyUid);
    }
    String proxyPwd =
        BigQueryJdbcUrlUtility.parseUriProperty(
            URL, BigQueryJdbcUrlUtility.PROXY_PASSWORD_PROPERTY_NAME);
    if (proxyPwd != null) {
      proxyProperties.put(BigQueryJdbcUrlUtility.PROXY_PASSWORD_PROPERTY_NAME, proxyPwd);
    }

    boolean isMissingProxyHostOrPortWhenProxySet =
        (proxyHost == null && proxyPort != null) || (proxyHost != null && proxyPort == null);
    if (isMissingProxyHostOrPortWhenProxySet) {
      throw new IllegalArgumentException(
          "Both ProxyHost and ProxyPort parameters need to be specified. No defaulting behavior occurs.");
    }
    boolean isMissingProxyUidOrPwdWhenAuthSet =
        (proxyUid == null && proxyPwd != null) || (proxyUid != null && proxyPwd == null);
    if (isMissingProxyUidOrPwdWhenAuthSet) {
      throw new IllegalArgumentException(
          "Both ProxyUid and ProxyPwd parameters need to be specified for authentication.");
    }
    boolean isProxyAuthSetWithoutProxySettings = proxyUid != null && proxyHost == null;
    if (isProxyAuthSetWithoutProxySettings) {
      throw new IllegalArgumentException(
          "Proxy authentication provided via connection string with no proxy host or port set.");
    }
    return proxyProperties;
  }

  static HttpTransportOptions getHttpTransportOptions(
      Map<String, String> proxyProperties,
      String sslTrustStorePath,
      String sslTrustStorePassword,
      String callerClassName) {
    LOG.finest("++enter++\t" + callerClassName);

    if (!proxyProperties.containsKey(BigQueryJdbcUrlUtility.PROXY_HOST_PROPERTY_NAME)
        && sslTrustStorePath == null) {
      return null;
    }
    return HttpTransportOptions.newBuilder()
        .setHttpTransportFactory(
            getHttpTransportFactory(
                proxyProperties, sslTrustStorePath, sslTrustStorePassword, callerClassName))
        .build();
  }

  private static HttpTransportFactory getHttpTransportFactory(
      Map<String, String> proxyProperties,
      String sslTrustStorePath,
      String sslTrustStorePassword,
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
    } else {
      httpClientBuilder.useSystemProperties();
    }

    if (sslTrustStorePath != null) {
      try (FileInputStream trustStoreStream = new FileInputStream(sslTrustStorePath)) {
        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        char[] trustStorePasswordChars =
            sslTrustStorePassword != null ? sslTrustStorePassword.toCharArray() : null;
        trustStore.load(trustStoreStream, trustStorePasswordChars);

        TrustManagerFactory trustManagerFactory =
            TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(trustStore);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, trustManagerFactory.getTrustManagers(), null);

        SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext);
        httpClientBuilder.setConnectionManager(
            PoolingHttpClientConnectionManagerBuilder.create()
                .setSSLSocketFactory(sslSocketFactory)
                .build());
      } catch (IOException | GeneralSecurityException e) {
        throw new BigQueryJdbcRuntimeException(e);
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
                      KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
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
                      throw new BigQueryJdbcRuntimeException(e);
                    }
                  }
                  return managedChannelBuilder;
                })
            .build();
    return transportChannelProvider;
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
