/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.datastore.utils;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.logging.*;

/** Client factory for {@link com.google.datastore.utils.Datastore}. */
public class DatastoreFactory {

  // Lazy load this because we might be running inside App Engine and this
  // class isn't on the whitelist.
  private static ConsoleHandler methodHandler;

  /** API version. */
  public static final String VERSION = "v1";

  public static final String DEFAULT_HOST = "https://datastore.googleapis.com";

  /** Singleton factory instance. */
  private static final DatastoreFactory INSTANCE = new DatastoreFactory();

  public static DatastoreFactory get() {
    return INSTANCE;
  }

  /**
   * Provides access to a datastore using the provided options. Logs into the application using the
   * credentials available via these options.
   *
   * @throws IllegalArgumentException if the server or credentials weren't provided.
   */
  public com.google.datastore.utils.Datastore create(
      com.google.datastore.utils.DatastoreOptions options) {
    return new com.google.datastore.utils.Datastore(newRemoteRpc(options));
  }

  /** Constructs a Google APIs HTTP client with the associated credentials. */
  public HttpRequestFactory makeClient(com.google.datastore.utils.DatastoreOptions options) {
    Credential credential = options.getCredential();
    HttpTransport transport = options.getTransport();
    if (transport == null) {
      transport = credential == null ? new NetHttpTransport() : credential.getTransport();
      transport = transport == null ? new NetHttpTransport() : transport;
    }
    return transport.createRequestFactory(credential);
  }

  /** Starts logging datastore method calls to the console. (Useful within tests.) */
  public static void logMethodCalls() {
    Logger logger = Logger.getLogger(Datastore.class.getName());
    logger.setLevel(Level.FINE);
    if (!Arrays.asList(logger.getHandlers()).contains(getStreamHandler())) {
      logger.addHandler(getStreamHandler());
    }
  }

  /** Build a valid datastore URL. */
  String buildProjectEndpoint(com.google.datastore.utils.DatastoreOptions options) {
    if (options.getProjectEndpoint() != null) {
      return options.getProjectEndpoint();
    }
    // DatastoreOptions ensures either project endpoint or project ID is set.
    String projectId = checkNotNull(options.getProjectId());
    if (options.getHost() != null) {
      return validateUrl(
          String.format("https://%s/%s/projects/%s", options.getHost(), VERSION, projectId));
    } else if (options.getLocalHost() != null) {
      return validateUrl(
          String.format("http://%s/%s/projects/%s", options.getLocalHost(), VERSION, projectId));
    }
    return validateUrl(String.format("%s/%s/projects/%s", DEFAULT_HOST, VERSION, projectId));
  }

  protected com.google.datastore.utils.RemoteRpc newRemoteRpc(DatastoreOptions options) {
    checkNotNull(options);
    HttpRequestFactory client = makeClient(options);
    return new com.google.datastore.utils.RemoteRpc(
        client, options.getInitializer(), buildProjectEndpoint(options));
  }

  private static String validateUrl(String url) {
    try {
      return new URI(url).toString();
    } catch (URISyntaxException e) {
      throw new IllegalArgumentException(e);
    }
  }

  // TODO: Support something other than console handler for when we're
  // running in App Engine
  private static synchronized StreamHandler getStreamHandler() {
    if (methodHandler == null) {
      methodHandler = new ConsoleHandler();
      methodHandler.setFormatter(
          new Formatter() {
            @Override
            public String format(LogRecord record) {
              return record.getMessage() + "\n";
            }
          });
      methodHandler.setLevel(Level.FINE);
    }
    return methodHandler;
  }
}
