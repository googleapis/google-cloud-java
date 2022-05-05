/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.datastream.v1alpha1;

import static com.google.cloud.datastream.v1alpha1.DatastreamClient.FetchStaticIpsPagedResponse;
import static com.google.cloud.datastream.v1alpha1.DatastreamClient.ListConnectionProfilesPagedResponse;
import static com.google.cloud.datastream.v1alpha1.DatastreamClient.ListPrivateConnectionsPagedResponse;
import static com.google.cloud.datastream.v1alpha1.DatastreamClient.ListRoutesPagedResponse;
import static com.google.cloud.datastream.v1alpha1.DatastreamClient.ListStreamsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class DatastreamClientTest {
  private static MockDatastream mockDatastream;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DatastreamClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDatastream = new MockDatastream();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockDatastream));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
    DatastreamSettings settings =
        DatastreamSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DatastreamClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listConnectionProfilesTest() throws Exception {
    ConnectionProfile responsesElement = ConnectionProfile.newBuilder().build();
    ListConnectionProfilesResponse expectedResponse =
        ListConnectionProfilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllConnectionProfiles(Arrays.asList(responsesElement))
            .build();
    mockDatastream.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListConnectionProfilesPagedResponse pagedListResponse = client.listConnectionProfiles(parent);

    List<ConnectionProfile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConnectionProfilesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConnectionProfilesRequest actualRequest =
        ((ListConnectionProfilesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConnectionProfilesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listConnectionProfiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConnectionProfilesTest2() throws Exception {
    ConnectionProfile responsesElement = ConnectionProfile.newBuilder().build();
    ListConnectionProfilesResponse expectedResponse =
        ListConnectionProfilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllConnectionProfiles(Arrays.asList(responsesElement))
            .build();
    mockDatastream.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListConnectionProfilesPagedResponse pagedListResponse = client.listConnectionProfiles(parent);

    List<ConnectionProfile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConnectionProfilesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConnectionProfilesRequest actualRequest =
        ((ListConnectionProfilesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConnectionProfilesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listConnectionProfiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConnectionProfileTest() throws Exception {
    ConnectionProfile expectedResponse =
        ConnectionProfile.newBuilder()
            .setName(
                ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .build();
    mockDatastream.addResponse(expectedResponse);

    ConnectionProfileName name =
        ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]");

    ConnectionProfile actualResponse = client.getConnectionProfile(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConnectionProfileRequest actualRequest =
        ((GetConnectionProfileRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getConnectionProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      ConnectionProfileName name =
          ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]");
      client.getConnectionProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConnectionProfileTest2() throws Exception {
    ConnectionProfile expectedResponse =
        ConnectionProfile.newBuilder()
            .setName(
                ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .build();
    mockDatastream.addResponse(expectedResponse);

    String name = "name3373707";

    ConnectionProfile actualResponse = client.getConnectionProfile(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConnectionProfileRequest actualRequest =
        ((GetConnectionProfileRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getConnectionProfileExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      String name = "name3373707";
      client.getConnectionProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createConnectionProfileTest() throws Exception {
    ConnectionProfile expectedResponse =
        ConnectionProfile.newBuilder()
            .setName(
                ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createConnectionProfileTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatastream.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ConnectionProfile connectionProfile = ConnectionProfile.newBuilder().build();
    String connectionProfileId = "connectionProfileId597575526";

    ConnectionProfile actualResponse =
        client.createConnectionProfileAsync(parent, connectionProfile, connectionProfileId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateConnectionProfileRequest actualRequest =
        ((CreateConnectionProfileRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(connectionProfile, actualRequest.getConnectionProfile());
    Assert.assertEquals(connectionProfileId, actualRequest.getConnectionProfileId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createConnectionProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ConnectionProfile connectionProfile = ConnectionProfile.newBuilder().build();
      String connectionProfileId = "connectionProfileId597575526";
      client.createConnectionProfileAsync(parent, connectionProfile, connectionProfileId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createConnectionProfileTest2() throws Exception {
    ConnectionProfile expectedResponse =
        ConnectionProfile.newBuilder()
            .setName(
                ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createConnectionProfileTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatastream.addResponse(resultOperation);

    String parent = "parent-995424086";
    ConnectionProfile connectionProfile = ConnectionProfile.newBuilder().build();
    String connectionProfileId = "connectionProfileId597575526";

    ConnectionProfile actualResponse =
        client.createConnectionProfileAsync(parent, connectionProfile, connectionProfileId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateConnectionProfileRequest actualRequest =
        ((CreateConnectionProfileRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(connectionProfile, actualRequest.getConnectionProfile());
    Assert.assertEquals(connectionProfileId, actualRequest.getConnectionProfileId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createConnectionProfileExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      String parent = "parent-995424086";
      ConnectionProfile connectionProfile = ConnectionProfile.newBuilder().build();
      String connectionProfileId = "connectionProfileId597575526";
      client.createConnectionProfileAsync(parent, connectionProfile, connectionProfileId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateConnectionProfileTest() throws Exception {
    ConnectionProfile expectedResponse =
        ConnectionProfile.newBuilder()
            .setName(
                ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateConnectionProfileTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatastream.addResponse(resultOperation);

    ConnectionProfile connectionProfile = ConnectionProfile.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ConnectionProfile actualResponse =
        client.updateConnectionProfileAsync(connectionProfile, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateConnectionProfileRequest actualRequest =
        ((UpdateConnectionProfileRequest) actualRequests.get(0));

    Assert.assertEquals(connectionProfile, actualRequest.getConnectionProfile());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateConnectionProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      ConnectionProfile connectionProfile = ConnectionProfile.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateConnectionProfileAsync(connectionProfile, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteConnectionProfileTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteConnectionProfileTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatastream.addResponse(resultOperation);

    ConnectionProfileName name =
        ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]");

    client.deleteConnectionProfileAsync(name).get();

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteConnectionProfileRequest actualRequest =
        ((DeleteConnectionProfileRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteConnectionProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      ConnectionProfileName name =
          ConnectionProfileName.of("[PROJECT]", "[LOCATION]", "[CONNECTION_PROFILE]");
      client.deleteConnectionProfileAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteConnectionProfileTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteConnectionProfileTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatastream.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteConnectionProfileAsync(name).get();

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteConnectionProfileRequest actualRequest =
        ((DeleteConnectionProfileRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteConnectionProfileExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      String name = "name3373707";
      client.deleteConnectionProfileAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void discoverConnectionProfileTest() throws Exception {
    DiscoverConnectionProfileResponse expectedResponse =
        DiscoverConnectionProfileResponse.newBuilder().build();
    mockDatastream.addResponse(expectedResponse);

    DiscoverConnectionProfileRequest request =
        DiscoverConnectionProfileRequest.newBuilder()
            .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .build();

    DiscoverConnectionProfileResponse actualResponse = client.discoverConnectionProfile(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DiscoverConnectionProfileRequest actualRequest =
        ((DiscoverConnectionProfileRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getConnectionProfile(), actualRequest.getConnectionProfile());
    Assert.assertEquals(
        request.getConnectionProfileName(), actualRequest.getConnectionProfileName());
    Assert.assertEquals(request.getRecursive(), actualRequest.getRecursive());
    Assert.assertEquals(request.getRecursionDepth(), actualRequest.getRecursionDepth());
    Assert.assertEquals(request.getOracleRdbms(), actualRequest.getOracleRdbms());
    Assert.assertEquals(request.getMysqlRdbms(), actualRequest.getMysqlRdbms());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void discoverConnectionProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      DiscoverConnectionProfileRequest request =
          DiscoverConnectionProfileRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .build();
      client.discoverConnectionProfile(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listStreamsTest() throws Exception {
    Stream responsesElement = Stream.newBuilder().build();
    ListStreamsResponse expectedResponse =
        ListStreamsResponse.newBuilder()
            .setNextPageToken("")
            .addAllStreams(Arrays.asList(responsesElement))
            .build();
    mockDatastream.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListStreamsPagedResponse pagedListResponse = client.listStreams(parent);

    List<Stream> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getStreamsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListStreamsRequest actualRequest = ((ListStreamsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listStreamsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listStreams(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listStreamsTest2() throws Exception {
    Stream responsesElement = Stream.newBuilder().build();
    ListStreamsResponse expectedResponse =
        ListStreamsResponse.newBuilder()
            .setNextPageToken("")
            .addAllStreams(Arrays.asList(responsesElement))
            .build();
    mockDatastream.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListStreamsPagedResponse pagedListResponse = client.listStreams(parent);

    List<Stream> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getStreamsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListStreamsRequest actualRequest = ((ListStreamsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listStreamsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listStreams(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getStreamTest() throws Exception {
    Stream expectedResponse =
        Stream.newBuilder()
            .setName(StreamName.of("[PROJECT]", "[LOCATION]", "[STREAM]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setSourceConfig(SourceConfig.newBuilder().build())
            .setDestinationConfig(DestinationConfig.newBuilder().build())
            .addAllErrors(new ArrayList<Error>())
            .build();
    mockDatastream.addResponse(expectedResponse);

    StreamName name = StreamName.of("[PROJECT]", "[LOCATION]", "[STREAM]");

    Stream actualResponse = client.getStream(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetStreamRequest actualRequest = ((GetStreamRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      StreamName name = StreamName.of("[PROJECT]", "[LOCATION]", "[STREAM]");
      client.getStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getStreamTest2() throws Exception {
    Stream expectedResponse =
        Stream.newBuilder()
            .setName(StreamName.of("[PROJECT]", "[LOCATION]", "[STREAM]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setSourceConfig(SourceConfig.newBuilder().build())
            .setDestinationConfig(DestinationConfig.newBuilder().build())
            .addAllErrors(new ArrayList<Error>())
            .build();
    mockDatastream.addResponse(expectedResponse);

    String name = "name3373707";

    Stream actualResponse = client.getStream(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetStreamRequest actualRequest = ((GetStreamRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getStreamExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      String name = "name3373707";
      client.getStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createStreamTest() throws Exception {
    Stream expectedResponse =
        Stream.newBuilder()
            .setName(StreamName.of("[PROJECT]", "[LOCATION]", "[STREAM]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setSourceConfig(SourceConfig.newBuilder().build())
            .setDestinationConfig(DestinationConfig.newBuilder().build())
            .addAllErrors(new ArrayList<Error>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createStreamTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatastream.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Stream stream = Stream.newBuilder().build();
    String streamId = "streamId1790933179";

    Stream actualResponse = client.createStreamAsync(parent, stream, streamId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateStreamRequest actualRequest = ((CreateStreamRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(stream, actualRequest.getStream());
    Assert.assertEquals(streamId, actualRequest.getStreamId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Stream stream = Stream.newBuilder().build();
      String streamId = "streamId1790933179";
      client.createStreamAsync(parent, stream, streamId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createStreamTest2() throws Exception {
    Stream expectedResponse =
        Stream.newBuilder()
            .setName(StreamName.of("[PROJECT]", "[LOCATION]", "[STREAM]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setSourceConfig(SourceConfig.newBuilder().build())
            .setDestinationConfig(DestinationConfig.newBuilder().build())
            .addAllErrors(new ArrayList<Error>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createStreamTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatastream.addResponse(resultOperation);

    String parent = "parent-995424086";
    Stream stream = Stream.newBuilder().build();
    String streamId = "streamId1790933179";

    Stream actualResponse = client.createStreamAsync(parent, stream, streamId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateStreamRequest actualRequest = ((CreateStreamRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(stream, actualRequest.getStream());
    Assert.assertEquals(streamId, actualRequest.getStreamId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createStreamExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      String parent = "parent-995424086";
      Stream stream = Stream.newBuilder().build();
      String streamId = "streamId1790933179";
      client.createStreamAsync(parent, stream, streamId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateStreamTest() throws Exception {
    Stream expectedResponse =
        Stream.newBuilder()
            .setName(StreamName.of("[PROJECT]", "[LOCATION]", "[STREAM]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setSourceConfig(SourceConfig.newBuilder().build())
            .setDestinationConfig(DestinationConfig.newBuilder().build())
            .addAllErrors(new ArrayList<Error>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateStreamTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatastream.addResponse(resultOperation);

    Stream stream = Stream.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Stream actualResponse = client.updateStreamAsync(stream, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateStreamRequest actualRequest = ((UpdateStreamRequest) actualRequests.get(0));

    Assert.assertEquals(stream, actualRequest.getStream());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      Stream stream = Stream.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateStreamAsync(stream, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteStreamTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteStreamTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatastream.addResponse(resultOperation);

    StreamName name = StreamName.of("[PROJECT]", "[LOCATION]", "[STREAM]");

    client.deleteStreamAsync(name).get();

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteStreamRequest actualRequest = ((DeleteStreamRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      StreamName name = StreamName.of("[PROJECT]", "[LOCATION]", "[STREAM]");
      client.deleteStreamAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteStreamTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteStreamTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatastream.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteStreamAsync(name).get();

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteStreamRequest actualRequest = ((DeleteStreamRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteStreamExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      String name = "name3373707";
      client.deleteStreamAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void fetchErrorsTest() throws Exception {
    FetchErrorsResponse expectedResponse =
        FetchErrorsResponse.newBuilder().addAllErrors(new ArrayList<Error>()).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("fetchErrorsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatastream.addResponse(resultOperation);

    FetchErrorsRequest request =
        FetchErrorsRequest.newBuilder()
            .setStream(StreamName.of("[PROJECT]", "[LOCATION]", "[STREAM]").toString())
            .build();

    FetchErrorsResponse actualResponse = client.fetchErrorsAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchErrorsRequest actualRequest = ((FetchErrorsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getStream(), actualRequest.getStream());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchErrorsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      FetchErrorsRequest request =
          FetchErrorsRequest.newBuilder()
              .setStream(StreamName.of("[PROJECT]", "[LOCATION]", "[STREAM]").toString())
              .build();
      client.fetchErrorsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void fetchStaticIpsTest() throws Exception {
    String responsesElement = "responsesElement-318365110";
    FetchStaticIpsResponse expectedResponse =
        FetchStaticIpsResponse.newBuilder()
            .setNextPageToken("")
            .addAllStaticIps(Arrays.asList(responsesElement))
            .build();
    mockDatastream.addResponse(expectedResponse);

    LocationName name = LocationName.of("[PROJECT]", "[LOCATION]");

    FetchStaticIpsPagedResponse pagedListResponse = client.fetchStaticIps(name);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getStaticIpsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchStaticIpsRequest actualRequest = ((FetchStaticIpsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchStaticIpsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      LocationName name = LocationName.of("[PROJECT]", "[LOCATION]");
      client.fetchStaticIps(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchStaticIpsTest2() throws Exception {
    String responsesElement = "responsesElement-318365110";
    FetchStaticIpsResponse expectedResponse =
        FetchStaticIpsResponse.newBuilder()
            .setNextPageToken("")
            .addAllStaticIps(Arrays.asList(responsesElement))
            .build();
    mockDatastream.addResponse(expectedResponse);

    String name = "name3373707";

    FetchStaticIpsPagedResponse pagedListResponse = client.fetchStaticIps(name);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getStaticIpsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchStaticIpsRequest actualRequest = ((FetchStaticIpsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchStaticIpsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      String name = "name3373707";
      client.fetchStaticIps(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPrivateConnectionTest() throws Exception {
    PrivateConnection expectedResponse =
        PrivateConnection.newBuilder()
            .setName(
                PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setError(Error.newBuilder().build())
            .setVpcPeeringConfig(VpcPeeringConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPrivateConnectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatastream.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    PrivateConnection privateConnection = PrivateConnection.newBuilder().build();
    String privateConnectionId = "privateConnectionId-1926654532";

    PrivateConnection actualResponse =
        client.createPrivateConnectionAsync(parent, privateConnection, privateConnectionId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePrivateConnectionRequest actualRequest =
        ((CreatePrivateConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(privateConnection, actualRequest.getPrivateConnection());
    Assert.assertEquals(privateConnectionId, actualRequest.getPrivateConnectionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPrivateConnectionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      PrivateConnection privateConnection = PrivateConnection.newBuilder().build();
      String privateConnectionId = "privateConnectionId-1926654532";
      client.createPrivateConnectionAsync(parent, privateConnection, privateConnectionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createPrivateConnectionTest2() throws Exception {
    PrivateConnection expectedResponse =
        PrivateConnection.newBuilder()
            .setName(
                PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setError(Error.newBuilder().build())
            .setVpcPeeringConfig(VpcPeeringConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPrivateConnectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatastream.addResponse(resultOperation);

    String parent = "parent-995424086";
    PrivateConnection privateConnection = PrivateConnection.newBuilder().build();
    String privateConnectionId = "privateConnectionId-1926654532";

    PrivateConnection actualResponse =
        client.createPrivateConnectionAsync(parent, privateConnection, privateConnectionId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePrivateConnectionRequest actualRequest =
        ((CreatePrivateConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(privateConnection, actualRequest.getPrivateConnection());
    Assert.assertEquals(privateConnectionId, actualRequest.getPrivateConnectionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPrivateConnectionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      String parent = "parent-995424086";
      PrivateConnection privateConnection = PrivateConnection.newBuilder().build();
      String privateConnectionId = "privateConnectionId-1926654532";
      client.createPrivateConnectionAsync(parent, privateConnection, privateConnectionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getPrivateConnectionTest() throws Exception {
    PrivateConnection expectedResponse =
        PrivateConnection.newBuilder()
            .setName(
                PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setError(Error.newBuilder().build())
            .setVpcPeeringConfig(VpcPeeringConfig.newBuilder().build())
            .build();
    mockDatastream.addResponse(expectedResponse);

    PrivateConnectionName name =
        PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]");

    PrivateConnection actualResponse = client.getPrivateConnection(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPrivateConnectionRequest actualRequest =
        ((GetPrivateConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPrivateConnectionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      PrivateConnectionName name =
          PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]");
      client.getPrivateConnection(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPrivateConnectionTest2() throws Exception {
    PrivateConnection expectedResponse =
        PrivateConnection.newBuilder()
            .setName(
                PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setError(Error.newBuilder().build())
            .setVpcPeeringConfig(VpcPeeringConfig.newBuilder().build())
            .build();
    mockDatastream.addResponse(expectedResponse);

    String name = "name3373707";

    PrivateConnection actualResponse = client.getPrivateConnection(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPrivateConnectionRequest actualRequest =
        ((GetPrivateConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPrivateConnectionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      String name = "name3373707";
      client.getPrivateConnection(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPrivateConnectionsTest() throws Exception {
    PrivateConnection responsesElement = PrivateConnection.newBuilder().build();
    ListPrivateConnectionsResponse expectedResponse =
        ListPrivateConnectionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPrivateConnections(Arrays.asList(responsesElement))
            .build();
    mockDatastream.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListPrivateConnectionsPagedResponse pagedListResponse = client.listPrivateConnections(parent);

    List<PrivateConnection> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPrivateConnectionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPrivateConnectionsRequest actualRequest =
        ((ListPrivateConnectionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPrivateConnectionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listPrivateConnections(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPrivateConnectionsTest2() throws Exception {
    PrivateConnection responsesElement = PrivateConnection.newBuilder().build();
    ListPrivateConnectionsResponse expectedResponse =
        ListPrivateConnectionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPrivateConnections(Arrays.asList(responsesElement))
            .build();
    mockDatastream.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPrivateConnectionsPagedResponse pagedListResponse = client.listPrivateConnections(parent);

    List<PrivateConnection> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPrivateConnectionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPrivateConnectionsRequest actualRequest =
        ((ListPrivateConnectionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPrivateConnectionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listPrivateConnections(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePrivateConnectionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePrivateConnectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatastream.addResponse(resultOperation);

    PrivateConnectionName name =
        PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]");

    client.deletePrivateConnectionAsync(name).get();

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePrivateConnectionRequest actualRequest =
        ((DeletePrivateConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePrivateConnectionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      PrivateConnectionName name =
          PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]");
      client.deletePrivateConnectionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deletePrivateConnectionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePrivateConnectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatastream.addResponse(resultOperation);

    String name = "name3373707";

    client.deletePrivateConnectionAsync(name).get();

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePrivateConnectionRequest actualRequest =
        ((DeletePrivateConnectionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePrivateConnectionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      String name = "name3373707";
      client.deletePrivateConnectionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createRouteTest() throws Exception {
    Route expectedResponse =
        Route.newBuilder()
            .setName(
                RouteName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]", "[ROUTE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDestinationAddress("destinationAddress1736827910")
            .setDestinationPort(1205298706)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatastream.addResponse(resultOperation);

    PrivateConnectionName parent =
        PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]");
    Route route = Route.newBuilder().build();
    String routeId = "routeId1385647428";

    Route actualResponse = client.createRouteAsync(parent, route, routeId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRouteRequest actualRequest = ((CreateRouteRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(route, actualRequest.getRoute());
    Assert.assertEquals(routeId, actualRequest.getRouteId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRouteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      PrivateConnectionName parent =
          PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]");
      Route route = Route.newBuilder().build();
      String routeId = "routeId1385647428";
      client.createRouteAsync(parent, route, routeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createRouteTest2() throws Exception {
    Route expectedResponse =
        Route.newBuilder()
            .setName(
                RouteName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]", "[ROUTE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDestinationAddress("destinationAddress1736827910")
            .setDestinationPort(1205298706)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatastream.addResponse(resultOperation);

    String parent = "parent-995424086";
    Route route = Route.newBuilder().build();
    String routeId = "routeId1385647428";

    Route actualResponse = client.createRouteAsync(parent, route, routeId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRouteRequest actualRequest = ((CreateRouteRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(route, actualRequest.getRoute());
    Assert.assertEquals(routeId, actualRequest.getRouteId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRouteExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      String parent = "parent-995424086";
      Route route = Route.newBuilder().build();
      String routeId = "routeId1385647428";
      client.createRouteAsync(parent, route, routeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getRouteTest() throws Exception {
    Route expectedResponse =
        Route.newBuilder()
            .setName(
                RouteName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]", "[ROUTE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDestinationAddress("destinationAddress1736827910")
            .setDestinationPort(1205298706)
            .build();
    mockDatastream.addResponse(expectedResponse);

    RouteName name = RouteName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]", "[ROUTE]");

    Route actualResponse = client.getRoute(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRouteRequest actualRequest = ((GetRouteRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRouteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      RouteName name = RouteName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]", "[ROUTE]");
      client.getRoute(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRouteTest2() throws Exception {
    Route expectedResponse =
        Route.newBuilder()
            .setName(
                RouteName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]", "[ROUTE]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDestinationAddress("destinationAddress1736827910")
            .setDestinationPort(1205298706)
            .build();
    mockDatastream.addResponse(expectedResponse);

    String name = "name3373707";

    Route actualResponse = client.getRoute(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRouteRequest actualRequest = ((GetRouteRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRouteExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      String name = "name3373707";
      client.getRoute(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRoutesTest() throws Exception {
    Route responsesElement = Route.newBuilder().build();
    ListRoutesResponse expectedResponse =
        ListRoutesResponse.newBuilder()
            .setNextPageToken("")
            .addAllRoutes(Arrays.asList(responsesElement))
            .build();
    mockDatastream.addResponse(expectedResponse);

    PrivateConnectionName parent =
        PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]");

    ListRoutesPagedResponse pagedListResponse = client.listRoutes(parent);

    List<Route> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRoutesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRoutesRequest actualRequest = ((ListRoutesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRoutesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      PrivateConnectionName parent =
          PrivateConnectionName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]");
      client.listRoutes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRoutesTest2() throws Exception {
    Route responsesElement = Route.newBuilder().build();
    ListRoutesResponse expectedResponse =
        ListRoutesResponse.newBuilder()
            .setNextPageToken("")
            .addAllRoutes(Arrays.asList(responsesElement))
            .build();
    mockDatastream.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRoutesPagedResponse pagedListResponse = client.listRoutes(parent);

    List<Route> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRoutesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRoutesRequest actualRequest = ((ListRoutesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRoutesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listRoutes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteRouteTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatastream.addResponse(resultOperation);

    RouteName name = RouteName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]", "[ROUTE]");

    client.deleteRouteAsync(name).get();

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRouteRequest actualRequest = ((DeleteRouteRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRouteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      RouteName name = RouteName.of("[PROJECT]", "[LOCATION]", "[PRIVATE_CONNECTION]", "[ROUTE]");
      client.deleteRouteAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteRouteTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteRouteTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatastream.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteRouteAsync(name).get();

    List<AbstractMessage> actualRequests = mockDatastream.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRouteRequest actualRequest = ((DeleteRouteRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRouteExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastream.addException(exception);

    try {
      String name = "name3373707";
      client.deleteRouteAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
