/*
 * Copyright 2024 Google LLC
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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.protobuf.Timestamp;
import com.google.shopping.merchant.datasources.v1beta.stub.HttpJsonFileUploadsServiceStub;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class FileUploadsServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static FileUploadsServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonFileUploadsServiceStub.getMethodDescriptors(),
            FileUploadsServiceSettings.getDefaultEndpoint());
    FileUploadsServiceSettings settings =
        FileUploadsServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                FileUploadsServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = FileUploadsServiceClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
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
    mockService.addResponse(expectedResponse);

    FileUploadName name = FileUploadName.of("[ACCOUNT]", "[DATASOURCE]", "[FILEUPLOAD]");

    FileUpload actualResponse = client.getFileUpload(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getFileUploadExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-7624/dataSources/dataSource-7624/fileUploads/fileUpload-7624";

    FileUpload actualResponse = client.getFileUpload(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getFileUploadExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-7624/dataSources/dataSource-7624/fileUploads/fileUpload-7624";
      client.getFileUpload(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
