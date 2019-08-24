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

package com.google.grpc.gcp;

import static org.junit.Assert.assertEquals;

import com.google.grpc.gcp.proto.AffinityConfig;
import com.google.grpc.gcp.proto.ApiConfig;
import com.google.grpc.gcp.proto.ChannelPoolConfig;
import com.google.grpc.gcp.proto.MethodConfig;
import com.google.spanner.v1.PartitionReadRequest;
import com.google.spanner.v1.TransactionSelector;
import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.io.File;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Unit tests for GcpManagedChannel.
 */
@RunWith(JUnit4.class)
public final class GcpManagedChannelTest {

  private static final String TARGET = "localhost";
  private static final String API_FILE = "apiconfig.json";
  private static final String EMPTY_METHOD_FILE = "empty_method.json";
  private static final String EMPTY_CHANNEL_FILE = "empty_channel.json";

  private static final int MAX_CHANNEL = 10;
  private static final int MAX_STREAM = 100;

  private GcpManagedChannel gcpChannel;
  private ManagedChannelBuilder builder;

  /**
   * Close and delete all the channelRefs inside a gcpchannel.
   */
  private void resetGcpChannel() {
    gcpChannel.shutdownNow();
    gcpChannel.channelRefs.clear();
  }

  @Before
  public void setUpChannel() {
    builder = ManagedChannelBuilder.forAddress(TARGET, 443);
    gcpChannel = (GcpManagedChannel) GcpManagedChannelBuilder.forDelegateBuilder(builder).build();
  }

  @After
  public void shutdown() throws Exception {
    gcpChannel.shutdownNow();
  }

  @Test
  public void testLoadApiConfig() throws Exception {
    resetGcpChannel();
    File configFile = new File(
        GcpManagedChannelTest.class.getClassLoader().getResource(API_FILE).getFile());
    gcpChannel = (GcpManagedChannel) GcpManagedChannelBuilder.forDelegateBuilder(builder)
        .withApiConfigJsonFile(configFile).build();
    assertEquals(1, gcpChannel.channelRefs.size());
    assertEquals(3, gcpChannel.getMaxSize());
    assertEquals(2, gcpChannel.getStreamsLowWatermark());
    assertEquals(3, gcpChannel.methodToAffinity.size());
  }

  @Test
  public void testGetChannelRefInitialization() throws Exception {
    // Should have a managedchannel by default.
    assertEquals(1, gcpChannel.channelRefs.size());
    assertEquals(0, gcpChannel.getChannelRef(null).getAffinityCount());
    // The state of this channel is idle.
    assertEquals(ConnectivityState.IDLE, gcpChannel.getState(false));
    assertEquals(1, gcpChannel.channelRefs.size());
  }

  @Test
  public void testGetChannelRefPickUpSmallest() throws Exception {
    // All channels have max number of streams
    resetGcpChannel();
    for (int i = 0; i < 5; i++) {
      ManagedChannel channel = builder.build();
      gcpChannel.channelRefs.add(gcpChannel.new ChannelRef(channel, i, i, MAX_STREAM));
    }
    assertEquals(5, gcpChannel.channelRefs.size());
    assertEquals(0, gcpChannel.getChannelRef(null).getAffinityCount());
    assertEquals(6, gcpChannel.channelRefs.size());

    // Add more channels, the smallest stream value is -1 with idx 6.
    int[] streams = new int[]{-1, 5, 7, 1};
    for (int i = 6; i < 10; i++) {
      ManagedChannel channel = builder.build();
      gcpChannel.channelRefs.add(gcpChannel.new ChannelRef(channel, i, i, streams[i - 6]));
    }
    assertEquals(10, gcpChannel.channelRefs.size());
    assertEquals(6, gcpChannel.getChannelRef(null).getAffinityCount());
  }

  @Test
  public void testGetChannelRefMaxSize() throws Exception {
    resetGcpChannel();
    for (int i = 0; i < MAX_CHANNEL; i++) {
      ManagedChannel channel = builder.build();
      gcpChannel.channelRefs.add(gcpChannel.new ChannelRef(channel, i, i, MAX_STREAM));
    }
    assertEquals(MAX_CHANNEL, gcpChannel.channelRefs.size());
    assertEquals(MAX_STREAM, gcpChannel.getChannelRef(null).getActiveStreamsCount());
    assertEquals(MAX_CHANNEL, gcpChannel.channelRefs.size());
  }

  @Test
  public void testBindUnbindKey() throws Exception {
    // Initialize the channel and bind the key, check the affinity count.
    GcpManagedChannel.ChannelRef cf1 = gcpChannel.new ChannelRef(builder.build(), 1, 0, 5);
    GcpManagedChannel.ChannelRef cf2 = gcpChannel.new ChannelRef(builder.build(), 1, 0, 4);
    gcpChannel.channelRefs.add(cf1);
    gcpChannel.channelRefs.add(cf2);
    gcpChannel.bind(cf1, "key1");
    gcpChannel.bind(cf2, "key2");
    gcpChannel.bind(cf1, "key1");
    assertEquals(2, gcpChannel.channelRefs.get(1).getAffinityCount());
    assertEquals(1, gcpChannel.channelRefs.get(2).getAffinityCount());
    assertEquals(2, gcpChannel.affinityKeyToChannelRef.size());

    // Unbind the affinity key.
    gcpChannel.unbind("key1");
    assertEquals(2, gcpChannel.affinityKeyToChannelRef.size());
    gcpChannel.unbind("key1");
    gcpChannel.unbind("key2");
    assertEquals(0, gcpChannel.affinityKeyToChannelRef.size());
    assertEquals(0, gcpChannel.channelRefs.get(1).getAffinityCount());
    assertEquals(0, gcpChannel.channelRefs.get(2).getAffinityCount());
  }

  @Test
  public void testGetKeyFromRequest() throws Exception {
    String expected = "thisisaname";
    TransactionSelector selector = TransactionSelector.getDefaultInstance();
    PartitionReadRequest req =
        PartitionReadRequest.newBuilder()
            .setSession(expected)
            .setTable("jenny")
            .setTransaction(selector)
            .addColumns("users")
            .build();
    String result = gcpChannel.getKeyFromMessage(req, "session");
    assertEquals(expected, result);
    result = gcpChannel.getKeyFromMessage(req, "fakesession");
    assertEquals(null, result);
  }

  @Test
  public void testParseGoodJsonFile() throws Exception {
    File configFile = new File(
        GcpManagedChannelTest.class.getClassLoader().getResource(API_FILE).getFile());
    ApiConfig apiconfig =
        GcpManagedChannelBuilder.forDelegateBuilder(builder)
            .withApiConfigJsonFile(configFile).apiConfig;
    ChannelPoolConfig expectedChannel =
        ChannelPoolConfig.newBuilder().setMaxSize(3).setMaxConcurrentStreamsLowWatermark(2).build();
    assertEquals(expectedChannel, apiconfig.getChannelPool());

    assertEquals(3, apiconfig.getMethodCount());
    MethodConfig.Builder expectedMethod1 = MethodConfig.newBuilder();
    expectedMethod1.addName("google.spanner.v1.Spanner/CreateSession");
    expectedMethod1.setAffinity(
        AffinityConfig.newBuilder()
            .setAffinityKey("name")
            .setCommand(AffinityConfig.Command.BIND)
            .build());
    assertEquals(expectedMethod1.build(), apiconfig.getMethod(0));
    MethodConfig.Builder expectedMethod2 = MethodConfig.newBuilder();
    expectedMethod2.addName("google.spanner.v1.Spanner/GetSession");
    expectedMethod2.setAffinity(
        AffinityConfig.newBuilder()
            .setAffinityKey("name")
            .setCommand(AffinityConfig.Command.BOUND)
            .build());
    assertEquals(expectedMethod2.build(), apiconfig.getMethod(1));
    MethodConfig.Builder expectedMethod3 = MethodConfig.newBuilder();
    expectedMethod3.addName("google.spanner.v1.Spanner/DeleteSession");
    expectedMethod3.setAffinity(
        AffinityConfig.newBuilder()
            .setAffinityKey("name")
            .setCommand(AffinityConfig.Command.UNBIND)
            .build());
    assertEquals(expectedMethod3.build(), apiconfig.getMethod(2));
  }

  @Test
  public void testParseEmptyMethodJsonFile() {
    File configFile = new File(
        GcpManagedChannelTest.class.getClassLoader().getResource(EMPTY_METHOD_FILE).getFile());
    ApiConfig apiconfig =
        GcpManagedChannelBuilder.forDelegateBuilder(builder)
            .withApiConfigJsonFile(configFile).apiConfig;
    ChannelPoolConfig expectedChannel =
        ChannelPoolConfig.newBuilder()
            .setMaxSize(5)
            .setIdleTimeout(1000)
            .setMaxConcurrentStreamsLowWatermark(5)
            .build();
    assertEquals(expectedChannel, apiconfig.getChannelPool());

    assertEquals(0, apiconfig.getMethodCount());
  }

  @Test
  public void testParseEmptyChannelJsonFile() {
    File configFile = new File(
        GcpManagedChannelTest.class.getClassLoader().getResource(EMPTY_CHANNEL_FILE).getFile());
    ApiConfig apiconfig =
        GcpManagedChannelBuilder.forDelegateBuilder(builder)
            .withApiConfigJsonFile(configFile).apiConfig;
    assertEquals(ChannelPoolConfig.getDefaultInstance(), apiconfig.getChannelPool());

    assertEquals(3, apiconfig.getMethodCount());
    MethodConfig.Builder expectedMethod1 = MethodConfig.newBuilder();
    expectedMethod1.addName("/google.spanner.v1.Spanner/CreateSession");
    expectedMethod1.setAffinity(
        AffinityConfig.newBuilder()
            .setAffinityKey("name")
            .setCommand(AffinityConfig.Command.BIND)
            .build());
    assertEquals(expectedMethod1.build(), apiconfig.getMethod(0));
    MethodConfig.Builder expectedMethod2 = MethodConfig.newBuilder();
    expectedMethod2.addName("/google.spanner.v1.Spanner/GetSession").addName("additional name");
    expectedMethod2.setAffinity(
        AffinityConfig.newBuilder()
            .setAffinityKey("name")
            .setCommand(AffinityConfig.Command.BOUND)
            .build());
    assertEquals(expectedMethod2.build(), apiconfig.getMethod(1));
    assertEquals(MethodConfig.getDefaultInstance(), apiconfig.getMethod(2));
  }
}
