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

package com.google.appengine.v1;

import static com.google.appengine.v1.AuthorizedDomainsClient.ListAuthorizedDomainsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class AuthorizedDomainsClientTest {
  private static MockAuthorizedDomains mockAuthorizedDomains;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AuthorizedDomainsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAuthorizedDomains = new MockAuthorizedDomains();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockAuthorizedDomains));
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
    AuthorizedDomainsSettings settings =
        AuthorizedDomainsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AuthorizedDomainsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listAuthorizedDomainsTest() throws Exception {
    AuthorizedDomain responsesElement = AuthorizedDomain.newBuilder().build();
    ListAuthorizedDomainsResponse expectedResponse =
        ListAuthorizedDomainsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDomains(Arrays.asList(responsesElement))
            .build();
    mockAuthorizedDomains.addResponse(expectedResponse);

    ListAuthorizedDomainsRequest request =
        ListAuthorizedDomainsRequest.newBuilder()
            .setParent("parent-995424086")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListAuthorizedDomainsPagedResponse pagedListResponse = client.listAuthorizedDomains(request);

    List<AuthorizedDomain> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDomainsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAuthorizedDomains.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAuthorizedDomainsRequest actualRequest =
        ((ListAuthorizedDomainsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAuthorizedDomainsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthorizedDomains.addException(exception);

    try {
      ListAuthorizedDomainsRequest request =
          ListAuthorizedDomainsRequest.newBuilder()
              .setParent("parent-995424086")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listAuthorizedDomains(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
