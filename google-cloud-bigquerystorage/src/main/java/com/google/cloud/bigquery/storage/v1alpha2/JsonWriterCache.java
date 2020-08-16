/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.bigquery.storage.v1alpha2;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.protobuf.Descriptors;
import java.io.IOException;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A cache of JsonStreamWriters that can be looked up by Table Name. The entries will expire after 5
 * minutes if not used. Code sample: JsonWriterCache cache = JsonWriterCache.getInstance();
 * JsonStreamWriter writer = cache.getWriter(); // Use... cache.returnWriter(writer);
 */
public class JsonWriterCache {
  private static final Logger LOG = Logger.getLogger(JsonWriterCache.class.getName());

  private static String tablePatternString = "(projects/[^/]+/datasets/[^/]+/tables/[^/]+)";
  private static Pattern tablePattern = Pattern.compile(tablePatternString);

  private static JsonWriterCache instance;
  private Cache<String, JsonStreamWriter> jsonWriterCache;

  // Maximum number of tables to hold in the cache, once the maxium exceeded, the cache will be
  // evicted based on least recent used.
  private static final int MAX_TABLE_ENTRY = 100;
  private static final int MAX_WRITERS_PER_TABLE = 1;

  private final BigQueryWriteClient stub;

  private JsonWriterCache(BigQueryWriteClient stub, int maxTableEntry) {
    this.stub = stub;
    jsonWriterCache =
        CacheBuilder.newBuilder().maximumSize(maxTableEntry).<String, JsonStreamWriter>build();
  }

  public static JsonWriterCache getInstance() throws IOException {
    if (instance == null) {
      BigQueryWriteSettings stubSettings = BigQueryWriteSettings.newBuilder().build();
      BigQueryWriteClient stub = BigQueryWriteClient.create(stubSettings);
      instance = new JsonWriterCache(stub, MAX_TABLE_ENTRY);
    }
    return instance;
  }

  /** Returns a cache with custom stub used by test. */
  @VisibleForTesting
  public static JsonWriterCache getTestInstance(BigQueryWriteClient stub, int maxTableEntry) {
    Preconditions.checkNotNull(stub, "Stub is null.");
    return new JsonWriterCache(stub, maxTableEntry);
  }

  private Stream.WriteStream CreateNewWriteStream(String tableName) {
    Stream.WriteStream stream =
        Stream.WriteStream.newBuilder().setType(Stream.WriteStream.Type.COMMITTED).build();
    stream =
        stub.createWriteStream(
            Storage.CreateWriteStreamRequest.newBuilder()
                .setParent(tableName)
                .setWriteStream(stream)
                .build());
    LOG.info("Created write stream:" + stream.getName());
    return stream;
  }

  JsonStreamWriter CreateNewWriter(Stream.WriteStream writeStream)
      throws IllegalArgumentException, IOException, InterruptedException,
          Descriptors.DescriptorValidationException {
    return JsonStreamWriter.newBuilder(writeStream.getName(), writeStream.getTableSchema())
        .setChannelProvider(stub.getSettings().getTransportChannelProvider())
        .setCredentialsProvider(stub.getSettings().getCredentialsProvider())
        .setExecutorProvider(stub.getSettings().getExecutorProvider())
        .build();
  }
  /**
   * Gets a writer for a given table with the given tableName
   *
   * @param tableName
   * @return
   * @throws Exception
   */
  public JsonStreamWriter getTableWriter(String tableName)
      throws IllegalArgumentException, IOException, InterruptedException,
          Descriptors.DescriptorValidationException {
    Preconditions.checkNotNull(tableName, "TableName is null.");
    Matcher matcher = tablePattern.matcher(tableName);
    if (!matcher.matches()) {
      throw new IllegalArgumentException("Invalid table name: " + tableName);
    }

    Stream.WriteStream writeStream = null;
    JsonStreamWriter writer = null;

    synchronized (this) {
      writer = jsonWriterCache.getIfPresent(tableName);
      if (writer != null) {
        if (!writer.expired()) {
          return writer;
        } else {
          writer.close();
        }
      }
      writeStream = CreateNewWriteStream(tableName);
      writer = CreateNewWriter(writeStream);
      jsonWriterCache.put(tableName, writer);
    }
    return writer;
  }

  /** Clear the cache and close all the writers in the cache. */
  public void clear() {
    synchronized (this) {
      ConcurrentMap<String, JsonStreamWriter> map = jsonWriterCache.asMap();
      for (String key : map.keySet()) {
        JsonStreamWriter entry = jsonWriterCache.getIfPresent(key);
        entry.close();
      }
      jsonWriterCache.cleanUp();
    }
  }

  @VisibleForTesting
  public long cachedTableCount() {
    synchronized (jsonWriterCache) {
      return jsonWriterCache.size();
    }
  }
}
