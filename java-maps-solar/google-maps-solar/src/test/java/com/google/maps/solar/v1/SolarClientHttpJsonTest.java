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

package com.google.maps.solar.v1;

import com.google.api.HttpBody;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.maps.solar.v1.stub.HttpJsonSolarStub;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.type.Date;
import com.google.type.LatLng;
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
public class SolarClientHttpJsonTest {
  private static MockHttpService mockService;
  private static SolarClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonSolarStub.getMethodDescriptors(), SolarSettings.getDefaultEndpoint());
    SolarSettings settings =
        SolarSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                SolarSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SolarClient.create(settings);
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
  public void findClosestBuildingInsightsTest() throws Exception {
    BuildingInsights expectedResponse =
        BuildingInsights.newBuilder()
            .setName("name3373707")
            .setCenter(LatLng.newBuilder().build())
            .setBoundingBox(LatLngBox.newBuilder().build())
            .setImageryDate(Date.newBuilder().build())
            .setImageryProcessedDate(Date.newBuilder().build())
            .setPostalCode("postalCode2011152728")
            .setAdministrativeArea("administrativeArea995589851")
            .setStatisticalArea("statisticalArea1274904744")
            .setRegionCode("regionCode-1991004415")
            .setSolarPotential(SolarPotential.newBuilder().build())
            .setImageryQuality(ImageryQuality.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    FindClosestBuildingInsightsRequest request =
        FindClosestBuildingInsightsRequest.newBuilder()
            .setLocation(LatLng.newBuilder().build())
            .setRequiredQuality(ImageryQuality.forNumber(0))
            .setExactQualityRequired(true)
            .build();

    BuildingInsights actualResponse = client.findClosestBuildingInsights(request);
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
  public void findClosestBuildingInsightsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FindClosestBuildingInsightsRequest request =
          FindClosestBuildingInsightsRequest.newBuilder()
              .setLocation(LatLng.newBuilder().build())
              .setRequiredQuality(ImageryQuality.forNumber(0))
              .setExactQualityRequired(true)
              .build();
      client.findClosestBuildingInsights(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataLayersTest() throws Exception {
    DataLayers expectedResponse =
        DataLayers.newBuilder()
            .setImageryDate(Date.newBuilder().build())
            .setImageryProcessedDate(Date.newBuilder().build())
            .setDsmUrl("dsmUrl-1322514735")
            .setRgbUrl("rgbUrl-933116574")
            .setMaskUrl("maskUrl840158947")
            .setAnnualFluxUrl("annualFluxUrl-2069548057")
            .setMonthlyFluxUrl("monthlyFluxUrl1983899129")
            .addAllHourlyShadeUrls(new ArrayList<String>())
            .setImageryQuality(ImageryQuality.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    GetDataLayersRequest request =
        GetDataLayersRequest.newBuilder()
            .setLocation(LatLng.newBuilder().build())
            .setRadiusMeters(1254190679)
            .setView(DataLayerView.forNumber(0))
            .setRequiredQuality(ImageryQuality.forNumber(0))
            .setPixelSizeMeters(-1623742513)
            .setExactQualityRequired(true)
            .build();

    DataLayers actualResponse = client.getDataLayers(request);
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
  public void getDataLayersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetDataLayersRequest request =
          GetDataLayersRequest.newBuilder()
              .setLocation(LatLng.newBuilder().build())
              .setRadiusMeters(1254190679)
              .setView(DataLayerView.forNumber(0))
              .setRequiredQuality(ImageryQuality.forNumber(0))
              .setPixelSizeMeters(-1623742513)
              .setExactQualityRequired(true)
              .build();
      client.getDataLayers(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGeoTiffTest() throws Exception {
    HttpBody expectedResponse =
        HttpBody.newBuilder()
            .setContentType("contentType-389131437")
            .setData(ByteString.EMPTY)
            .addAllExtensions(new ArrayList<Any>())
            .build();
    mockService.addResponse(expectedResponse);

    GetGeoTiffRequest request = GetGeoTiffRequest.newBuilder().setId("id3355").build();

    HttpBody actualResponse = client.getGeoTiff(request);
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
  public void getGeoTiffExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetGeoTiffRequest request = GetGeoTiffRequest.newBuilder().setId("id3355").build();
      client.getGeoTiff(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
