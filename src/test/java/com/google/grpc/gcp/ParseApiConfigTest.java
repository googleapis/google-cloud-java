package com.google.grpc.gcp;

import static org.junit.Assert.assertEquals;

import com.google.grpc.gcp.proto.AffinityConfig;
import com.google.grpc.gcp.proto.ApiConfig;
import com.google.grpc.gcp.proto.ChannelPoolConfig;
import com.google.grpc.gcp.proto.MethodConfig;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.junit.Before;
import org.junit.Test;

/** Unit tests for ParseApiConfig. */
public class ParseApiConfigTest {
  private static final String GOOD_FILE = "src/test/resources/apiconfigtests/apiconfig.json";
  private static final String EMPTY_METHOD_FILE = "src/test/resources/apiconfigtests/empty_method.json";
  private static final String EMPTY_CHANNEL_FILE = "src/test/resources/apiconfigtests/empty_channel.json";

  @Test
  public void testGoodFile() throws Exception {
    ApiConfig apiconfig = ParseApiConfig.parseJson(GOOD_FILE);
    ChannelPoolConfig expectedChannel = ChannelPoolConfig.newBuilder().setMaxSize(10).setMaxConcurrentStreamsLowWatermark(1).build();
    assertEquals(expectedChannel, apiconfig.getChannelPool());

    assertEquals(3, apiconfig.getMethodCount());
    MethodConfig.Builder expectedMethod1 = MethodConfig.newBuilder();
    expectedMethod1.addName("/google.spanner.v1.Spanner/CreateSession");
    expectedMethod1.setAffinity(AffinityConfig.newBuilder().setAffinityKey("name").setCommand(AffinityConfig.Command.BIND).build());
    assertEquals(expectedMethod1.build(), apiconfig.getMethod(0));
    MethodConfig.Builder expectedMethod2 = MethodConfig.newBuilder();
	expectedMethod2.addName("/google.spanner.v1.Spanner/GetSession");
    expectedMethod2.setAffinity(AffinityConfig.newBuilder().setAffinityKey("name").setCommand(AffinityConfig.Command.BOUND).build());
    assertEquals(expectedMethod2.build(), apiconfig.getMethod(1));
    MethodConfig.Builder expectedMethod3 = MethodConfig.newBuilder();
    expectedMethod3.addName("/google.spanner.v1.Spanner/DeleteSession");
    expectedMethod3.setAffinity(AffinityConfig.newBuilder().setAffinityKey("name").setCommand(AffinityConfig.Command.UNBIND).build());
    assertEquals(expectedMethod3.build(), apiconfig.getMethod(2));
  }

  @Test
  public void testEmptyMethodFile() throws Exception {
  	ApiConfig apiconfig = ParseApiConfig.parseJson(EMPTY_METHOD_FILE);
    ChannelPoolConfig expectedChannel = ChannelPoolConfig.newBuilder().setMaxSize(1011).setIdleTimeout(1000).setMaxConcurrentStreamsLowWatermark(100).build();
    assertEquals(expectedChannel, apiconfig.getChannelPool());

    assertEquals(0, apiconfig.getMethodCount());
  }

  @Test
  public void testEmptyChannelFile() throws Exception {
  	ApiConfig apiconfig = ParseApiConfig.parseJson(EMPTY_CHANNEL_FILE);
    assertEquals(ChannelPoolConfig.getDefaultInstance(), apiconfig.getChannelPool());

    assertEquals(3, apiconfig.getMethodCount());
    MethodConfig.Builder expectedMethod1 = MethodConfig.newBuilder();
    expectedMethod1.addName("/google.spanner.v1.Spanner/CreateSession");
    assertEquals(expectedMethod1.build(), apiconfig.getMethod(0));
    MethodConfig.Builder expectedMethod2 = MethodConfig.newBuilder();
	expectedMethod2.addName("/google.spanner.v1.Spanner/GetSession").addName("additional name");
    expectedMethod2.setAffinity(AffinityConfig.newBuilder().setAffinityKey("name").setCommand(AffinityConfig.Command.BOUND).build());
    assertEquals(expectedMethod2.build(), apiconfig.getMethod(1));
    assertEquals(MethodConfig.getDefaultInstance(), apiconfig.getMethod(2));
  }
}
