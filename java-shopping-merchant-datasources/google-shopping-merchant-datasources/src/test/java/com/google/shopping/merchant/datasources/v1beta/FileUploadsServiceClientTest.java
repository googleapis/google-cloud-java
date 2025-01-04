/*
 * Copyright 2025 Google LLC
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

package com.google.shopping.merchant.datasources.v1beta;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class FileUploadsServiceClientTest {
  private static MockFileUploadsService mockFileUploadsService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private FileUploadsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockFileUploadsService = new MockFileUploadsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockFileUploadsService));
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
    FileUploadsServiceSettings settings =
        FileUploadsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = FileUploadsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getFileUploadTest() throws Exception {
    FileUpload expectedResponse =
        FileUpload.newBuilder()
            .setName(FileUploadName.of("[ACCOUNT]", "[DATASOURCE]", "[FILEUPLOAD]").toString())
            .setDataSourceId(-1015796374)
            .addAllIssues(new ArrayList<FileUpload.Issue>())
            .setItemsTotal(-384543227)
            .setItemsCreated(1985498473)
            .setItemsUpdated(722513724)
            .setUploadTime(Timestamp.newBuilder().build())
            .build();
    mockFileUploadsService.addResponse(expectedResponse);

    FileUploadName name = FileUploadName.of("[ACCOUNT]", "[DATASOURCE]", "[FILEUPLOAD]");

    FileUpload actualResponse = client.getFileUpload(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFileUploadsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFileUploadRequest actualRequest = ((GetFileUploadRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFileUploadExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFileUploadsService.addException(exception);

    try {
      FileUploadName name = FileUploadName.of("[ACCOUNT]", "[DATASOURCE]", "[FILEUPLOAD]");
      client.getFileUpload(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFileUploadTest2() throws Exception {
    FileUpload expectedResponse =
        FileUpload.newBuilder()
            .setName(FileUploadName.of("[ACCOUNT]", "[DATASOURCE]", "[FILEUPLOAD]").toString())
            .setDataSourceId(-1015796374)
            .addAllIssues(new ArrayList<FileUpload.Issue>())
            .setItemsTotal(-384543227)
            .setItemsCreated(1985498473)
            .setItemsUpdated(722513724)
            .setUploadTime(Timestamp.newBuilder().build())
            .build();
    mockFileUploadsService.addResponse(expectedResponse);

    String name = "name3373707";

    FileUpload actualResponse = client.getFileUpload(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFileUploadsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFileUploadRequest actualRequest = ((GetFileUploadRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFileUploadExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFileUploadsService.addException(exception);

    try {
      String name = "name3373707";
      client.getFileUpload(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
