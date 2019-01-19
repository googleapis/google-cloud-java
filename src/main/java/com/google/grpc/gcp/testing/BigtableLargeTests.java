/*
 * Copyright 2019 Google LLC
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

package com.google.grpc.gcp.testing;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.BigtableGrpc.BigtableBlockingStub;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.common.collect.ImmutableList;
import com.google.grpc.gcp.GcpManagedChannel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.auth.MoreCallCredentials;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

/**
 * A testing program for running 105 streams concurrently using different channels.
 *
 * <p>The original ManagedChannel is not able to hold 105 streams concurrently. The 101st stream
 * will be blocked and throws a TimeoutException.
 *
 * <p>On the other hand, our GcpManagedChannel is able to manage 101 streams concurrently.
 */
public final class BigtableLargeTests {

  private static final Logger logger = Logger.getLogger(BigtableLargeTests.class.getName());

  private static final int DEFAULT_MAX_STREAM = 100;
  private static final int MAX_MSG_SIZE = 8 * 1024 * 1024;

  private static final String BIGTABLE_TARGET = "bigtable.googleapis.com";
  private static final String FAMILY_NAME = "test-family";
  private static final String TABLE_NAME =
      "projects/cloudprober-test/instances/test-instance/tables/test-table";
  private static final String LARGE_TABLE_NAME =
      "projects/cloudprober-test/instances/test-instance/tables/test-large-table";
  private static final String OAUTH_SCOPE = "https://www.googleapis.com/auth/cloud-platform";

  private static GoogleCredentials getCreds() {
    GoogleCredentials creds;
    try {
      creds = GoogleCredentials.getApplicationDefault();
    } catch (Exception e) {
      return null;
    }
    ImmutableList<String> requiredScopes = ImmutableList.of(OAUTH_SCOPE);
    creds = creds.createScoped(requiredScopes);
    return creds;
  }

  private static List<Iterator<ReadRowsResponse>> getReadRowsResponses(ManagedChannel channel) {
    GoogleCredentials creds = getCreds();
    BigtableBlockingStub stub =
        BigtableGrpc.newBlockingStub(channel).withCallCredentials(MoreCallCredentials.from(creds));

    List<Iterator<ReadRowsResponse>> res = new ArrayList<>();
    ReadRowsRequest request = ReadRowsRequest.newBuilder().setTableName(LARGE_TABLE_NAME).build();
    for (int i = 0; i < DEFAULT_MAX_STREAM + 5; i++) {
      Iterator<ReadRowsResponse> iter = stub.readRows(request);
      res.add(iter);
    }
    return res;
  }

  private static boolean readReadRowsResponses(List<Iterator<ReadRowsResponse>> res) {
    for (Iterator<ReadRowsResponse> iter : res) {
      iter.next();
    }
    return true;
  }

  // Clear all the pending streams in the iterators.
  private static void finishReadRowsResponses(List<Iterator<ReadRowsResponse>> res) {
    for (Iterator<ReadRowsResponse> iter : res) {
      while (iter.hasNext()) {
        iter.next();
      }
    }
  }

  private static boolean runManyManyStreams(ManagedChannel channel)
      throws InterruptedException, ExecutionException {
    boolean finishRunning = true;
    List<Iterator<ReadRowsResponse>> res = getReadRowsResponses(channel);

    ExecutorService executor = Executors.newSingleThreadExecutor();
    Callable<Object> task =
        new Callable<Object>() {
          public Object call() {
            return readReadRowsResponses(res);
          }
        };
    Future<Object> future = executor.submit(task);
    try {
      Object result = future.get(90, TimeUnit.SECONDS);
    } catch (TimeoutException e) {
      finishRunning = false;
    } finally {
      executor.shutdownNow();
    }
    return finishRunning;
  }

  public static void main(String[] args) throws InterruptedException, ExecutionException {

    ManagedChannelBuilder builder =
        ManagedChannelBuilder.forAddress(BIGTABLE_TARGET, 443).maxInboundMessageSize(MAX_MSG_SIZE);

    // Running 105 streaming using GcpManagedChannel.
    GcpManagedChannel gcpChannel = new GcpManagedChannel(builder);
    logger.info("Start running 105 concurrent streams using GcpManagedChannel.");
    if (runManyManyStreams(gcpChannel)) {
      logger.info("Finish running 105 concurrent streams using GcpManagedChannel.");
    } else {
      logger.severe("Unable to run 105 concurrent streams using GcpManagedChannel.");
    }
    gcpChannel.shutdownNow();

    // Running 105 streaming using ManagedChannel.
    ManagedChannel channel = builder.build();
    logger.info("Start running 105 concurrent streams using ManagedChannel.");
    if (runManyManyStreams(channel)) {
      logger.severe("Finish running 105 concurrent streams using ManagedChannel.");
    } else {
      logger.info("Unable to run 105 concurrent streams using ManagedChannel.");
    }
    channel.shutdownNow();
  }
}
