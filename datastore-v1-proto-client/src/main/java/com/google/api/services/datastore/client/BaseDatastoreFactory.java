/*
 * Copyright 2013 Google Inc. All Rights Reserved.
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
package com.google.api.services.datastore.client;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

import java.util.Arrays;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

/**
 * Client factory for {@link Datastore}.
 *
 */
abstract class BaseDatastoreFactory<T> {

  // Non-javadoc.
  // This class allows RemoteRpc to be used by factory implementations defined
  // outside of this package.
  public static class RemoteRpc
      extends com.google.api.services.datastore.client.RemoteRpc {
    public RemoteRpc(HttpRequestFactory client, HttpRequestInitializer initializer, String url) {
      super(client, initializer, url);
    }
  }

  private static final Logger logger = Logger.getLogger(BaseDatastoreFactory.class.getName());

  // Lazy load this because we might be running inside App Engine and this
  // class isn't on the whitelist.
  private static ConsoleHandler methodHandler;

  protected abstract String buildUrl(DatastoreOptions options, String overrideUrl);
  public abstract T create(DatastoreOptions options) throws IllegalArgumentException;

  // TODO(user): Support something other than console handler for when we're
  // running in App Engine
  private static synchronized StreamHandler getStreamHandler() {
    if (methodHandler == null) {
      methodHandler = new ConsoleHandler();
      methodHandler.setFormatter(new Formatter() {
        @Override
        public String format(LogRecord record) {
          return record.getMessage() + "\n";
        }
      });
      methodHandler.setLevel(Level.FINE);
    }
    return methodHandler;
  }

  protected BaseDatastoreFactory() { }

  protected RemoteRpc
      newRemoteRpc(DatastoreOptions options) {
    return newRemoteRpc(options, System.getenv("DATASTORE_URL_INTERNAL_OVERRIDE"));
  }

  protected RemoteRpc newRemoteRpc(DatastoreOptions options, String  urlOverride) {
    if (options == null) {
      throw new IllegalArgumentException("options not set");
    }
    HttpRequestFactory client = makeClient(options);
    return new RemoteRpc(client, options.getInitializer(), buildUrl(options, urlOverride));
  }

  /**
   * Constructs a Google APIs HTTP client with the associated credentials.
   */
  public HttpRequestFactory makeClient(DatastoreOptions options) {
    Credential credential = options.getCredential();
    if (credential == null) {
      logger.warning("Not using any credentials");
    }
    HttpTransport transport = options.getTransport();
    if (transport == null) {
      transport = credential == null ? new NetHttpTransport() : credential.getTransport();
    }
    return transport.createRequestFactory(credential);
  }

  /**
   * Starts logging datastore method calls to the console. (Useful within tests.)
   */
  public static void logMethodCalls() {
    Logger logger = Logger.getLogger(Datastore.class.getName());
    logger.setLevel(Level.FINE);
    if (!Arrays.asList(logger.getHandlers()).contains(getStreamHandler())) {
      logger.addHandler(getStreamHandler());
    }
  }
}
