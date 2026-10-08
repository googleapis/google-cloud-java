/*
 * Copyright 2026 Google LLC
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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.LineItemServiceClient.ListLineItemsPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonLineItemServiceStub;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.collect.Lists;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.type.Money;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class LineItemServiceClientTest {
  private static MockHttpService mockService;
  private static LineItemServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonLineItemServiceStub.getMethodDescriptors(),
            LineItemServiceSettings.getDefaultEndpoint());
    LineItemServiceSettings settings =
        LineItemServiceSettings.newBuilder()
            .setTransportChannelProvider(
                LineItemServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = LineItemServiceClient.create(settings);
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
  public void getLineItemTest() throws Exception {
    LineItem expectedResponse =
        LineItem.newBuilder()
            .setName(LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]").toString())
            .setOrder(OrderName.of("[NETWORK_CODE]", "[ORDER]").toString())
            .setDisplayName("displayName1714148973")
            .setExternalLineItemId("externalLineItemId760028877")
            .setOrderDisplayName("orderDisplayName1559886399")
            .setStartTime(Timestamp.newBuilder().build())
            .setTargetEndTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setAutoExtensionDays(2065627367)
            .setEndTimeUnlimited(true)
            .setCustomPacingCurve(CustomPacingCurve.newBuilder().build())
            .addAllFrequencyCaps(new ArrayList<FrequencyCap>())
            .setPriority(-1165461084)
            .setRate(Money.newBuilder().build())
            .setValueCpm(Money.newBuilder().build())
            .setDiscount(LineItemDiscount.newBuilder().build())
            .setContractedUnitsBought(-424175607)
            .addAllCreativePlaceholders(new ArrayList<CreativePlaceholder>())
            .setAllowOverbook(true)
            .setSkipInventoryCheck(true)
            .setSkipCrossSellingRuleWarningChecks(true)
            .setReserveOnCreation(true)
            .setStats(LineItemStats.newBuilder().build())
            .setDeliveryIndicator(DeliveryIndicator.newBuilder().build())
            .setBudget(Money.newBuilder().build())
            .setArchived(true)
            .setWebPropertyCode("webPropertyCode98815702")
            .addAllAppliedLabels(new ArrayList<AppliedLabel>())
            .addAllEffectiveAppliedLabels(new ArrayList<AppliedLabel>())
            .setSameAdvertiserExceptionEnabled(true)
            .setUpdateSource("updateSource-944762300")
            .setNotes("notes105008833")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllCustomFieldValues(new ArrayList<CustomFieldValue>())
            .setMissingCreatives(true)
            .setThirdPartyMeasurementSettings(ThirdPartyMeasurementSettings.newBuilder().build())
            .setYoutubeKidsRestricted(true)
            .setMaxVideoCreativeDuration(Duration.newBuilder().build())
            .setGoal(Goal.newBuilder().build())
            .addAllSecondaryGoals(new ArrayList<Goal>())
            .setGrpSettings(GrpSettings.newBuilder().build())
            .setDealInfo(LineItemDealInfo.newBuilder().build())
            .addAllViewabilityProviderCompanies(new ArrayList<String>())
            .setCustomVastExtension("customVastExtension-456132766")
            .setSponsorshipExclusivityEnabled(true)
            .setRepeatedCreativeServingEnabled(true)
            .setTargeting(Targeting.newBuilder().build())
            .addAllCreativeTargetings(new ArrayList<CreativeTargeting>())
            .addAllAllowedFormats(new ArrayList<LineItemAllowedFormatEnum.LineItemAllowedFormat>())
            .build();
    mockService.addResponse(expectedResponse);

    LineItemName name = LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]");

    LineItem actualResponse = client.getLineItem(name);
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
  public void getLineItemExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LineItemName name = LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]");
      client.getLineItem(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLineItemTest2() throws Exception {
    LineItem expectedResponse =
        LineItem.newBuilder()
            .setName(LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]").toString())
            .setOrder(OrderName.of("[NETWORK_CODE]", "[ORDER]").toString())
            .setDisplayName("displayName1714148973")
            .setExternalLineItemId("externalLineItemId760028877")
            .setOrderDisplayName("orderDisplayName1559886399")
            .setStartTime(Timestamp.newBuilder().build())
            .setTargetEndTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setAutoExtensionDays(2065627367)
            .setEndTimeUnlimited(true)
            .setCustomPacingCurve(CustomPacingCurve.newBuilder().build())
            .addAllFrequencyCaps(new ArrayList<FrequencyCap>())
            .setPriority(-1165461084)
            .setRate(Money.newBuilder().build())
            .setValueCpm(Money.newBuilder().build())
            .setDiscount(LineItemDiscount.newBuilder().build())
            .setContractedUnitsBought(-424175607)
            .addAllCreativePlaceholders(new ArrayList<CreativePlaceholder>())
            .setAllowOverbook(true)
            .setSkipInventoryCheck(true)
            .setSkipCrossSellingRuleWarningChecks(true)
            .setReserveOnCreation(true)
            .setStats(LineItemStats.newBuilder().build())
            .setDeliveryIndicator(DeliveryIndicator.newBuilder().build())
            .setBudget(Money.newBuilder().build())
            .setArchived(true)
            .setWebPropertyCode("webPropertyCode98815702")
            .addAllAppliedLabels(new ArrayList<AppliedLabel>())
            .addAllEffectiveAppliedLabels(new ArrayList<AppliedLabel>())
            .setSameAdvertiserExceptionEnabled(true)
            .setUpdateSource("updateSource-944762300")
            .setNotes("notes105008833")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllCustomFieldValues(new ArrayList<CustomFieldValue>())
            .setMissingCreatives(true)
            .setThirdPartyMeasurementSettings(ThirdPartyMeasurementSettings.newBuilder().build())
            .setYoutubeKidsRestricted(true)
            .setMaxVideoCreativeDuration(Duration.newBuilder().build())
            .setGoal(Goal.newBuilder().build())
            .addAllSecondaryGoals(new ArrayList<Goal>())
            .setGrpSettings(GrpSettings.newBuilder().build())
            .setDealInfo(LineItemDealInfo.newBuilder().build())
            .addAllViewabilityProviderCompanies(new ArrayList<String>())
            .setCustomVastExtension("customVastExtension-456132766")
            .setSponsorshipExclusivityEnabled(true)
            .setRepeatedCreativeServingEnabled(true)
            .setTargeting(Targeting.newBuilder().build())
            .addAllCreativeTargetings(new ArrayList<CreativeTargeting>())
            .addAllAllowedFormats(new ArrayList<LineItemAllowedFormatEnum.LineItemAllowedFormat>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-6627/lineItems/lineItem-6627";

    LineItem actualResponse = client.getLineItem(name);
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
  public void getLineItemExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-6627/lineItems/lineItem-6627";
      client.getLineItem(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLineItemsTest() throws Exception {
    LineItem responsesElement = LineItem.newBuilder().build();
    ListLineItemsResponse expectedResponse =
        ListLineItemsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLineItems(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListLineItemsPagedResponse pagedListResponse = client.listLineItems(parent);

    List<LineItem> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLineItemsList().get(0), resources.get(0));

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
  public void listLineItemsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listLineItems(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLineItemsTest2() throws Exception {
    LineItem responsesElement = LineItem.newBuilder().build();
    ListLineItemsResponse expectedResponse =
        ListLineItemsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLineItems(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListLineItemsPagedResponse pagedListResponse = client.listLineItems(parent);

    List<LineItem> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLineItemsList().get(0), resources.get(0));

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
  public void listLineItemsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listLineItems(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createLineItemTest() throws Exception {
    LineItem expectedResponse =
        LineItem.newBuilder()
            .setName(LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]").toString())
            .setOrder(OrderName.of("[NETWORK_CODE]", "[ORDER]").toString())
            .setDisplayName("displayName1714148973")
            .setExternalLineItemId("externalLineItemId760028877")
            .setOrderDisplayName("orderDisplayName1559886399")
            .setStartTime(Timestamp.newBuilder().build())
            .setTargetEndTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setAutoExtensionDays(2065627367)
            .setEndTimeUnlimited(true)
            .setCustomPacingCurve(CustomPacingCurve.newBuilder().build())
            .addAllFrequencyCaps(new ArrayList<FrequencyCap>())
            .setPriority(-1165461084)
            .setRate(Money.newBuilder().build())
            .setValueCpm(Money.newBuilder().build())
            .setDiscount(LineItemDiscount.newBuilder().build())
            .setContractedUnitsBought(-424175607)
            .addAllCreativePlaceholders(new ArrayList<CreativePlaceholder>())
            .setAllowOverbook(true)
            .setSkipInventoryCheck(true)
            .setSkipCrossSellingRuleWarningChecks(true)
            .setReserveOnCreation(true)
            .setStats(LineItemStats.newBuilder().build())
            .setDeliveryIndicator(DeliveryIndicator.newBuilder().build())
            .setBudget(Money.newBuilder().build())
            .setArchived(true)
            .setWebPropertyCode("webPropertyCode98815702")
            .addAllAppliedLabels(new ArrayList<AppliedLabel>())
            .addAllEffectiveAppliedLabels(new ArrayList<AppliedLabel>())
            .setSameAdvertiserExceptionEnabled(true)
            .setUpdateSource("updateSource-944762300")
            .setNotes("notes105008833")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllCustomFieldValues(new ArrayList<CustomFieldValue>())
            .setMissingCreatives(true)
            .setThirdPartyMeasurementSettings(ThirdPartyMeasurementSettings.newBuilder().build())
            .setYoutubeKidsRestricted(true)
            .setMaxVideoCreativeDuration(Duration.newBuilder().build())
            .setGoal(Goal.newBuilder().build())
            .addAllSecondaryGoals(new ArrayList<Goal>())
            .setGrpSettings(GrpSettings.newBuilder().build())
            .setDealInfo(LineItemDealInfo.newBuilder().build())
            .addAllViewabilityProviderCompanies(new ArrayList<String>())
            .setCustomVastExtension("customVastExtension-456132766")
            .setSponsorshipExclusivityEnabled(true)
            .setRepeatedCreativeServingEnabled(true)
            .setTargeting(Targeting.newBuilder().build())
            .addAllCreativeTargetings(new ArrayList<CreativeTargeting>())
            .addAllAllowedFormats(new ArrayList<LineItemAllowedFormatEnum.LineItemAllowedFormat>())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    LineItem lineItem = LineItem.newBuilder().build();

    LineItem actualResponse = client.createLineItem(parent, lineItem);
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
  public void createLineItemExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      LineItem lineItem = LineItem.newBuilder().build();
      client.createLineItem(parent, lineItem);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createLineItemTest2() throws Exception {
    LineItem expectedResponse =
        LineItem.newBuilder()
            .setName(LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]").toString())
            .setOrder(OrderName.of("[NETWORK_CODE]", "[ORDER]").toString())
            .setDisplayName("displayName1714148973")
            .setExternalLineItemId("externalLineItemId760028877")
            .setOrderDisplayName("orderDisplayName1559886399")
            .setStartTime(Timestamp.newBuilder().build())
            .setTargetEndTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setAutoExtensionDays(2065627367)
            .setEndTimeUnlimited(true)
            .setCustomPacingCurve(CustomPacingCurve.newBuilder().build())
            .addAllFrequencyCaps(new ArrayList<FrequencyCap>())
            .setPriority(-1165461084)
            .setRate(Money.newBuilder().build())
            .setValueCpm(Money.newBuilder().build())
            .setDiscount(LineItemDiscount.newBuilder().build())
            .setContractedUnitsBought(-424175607)
            .addAllCreativePlaceholders(new ArrayList<CreativePlaceholder>())
            .setAllowOverbook(true)
            .setSkipInventoryCheck(true)
            .setSkipCrossSellingRuleWarningChecks(true)
            .setReserveOnCreation(true)
            .setStats(LineItemStats.newBuilder().build())
            .setDeliveryIndicator(DeliveryIndicator.newBuilder().build())
            .setBudget(Money.newBuilder().build())
            .setArchived(true)
            .setWebPropertyCode("webPropertyCode98815702")
            .addAllAppliedLabels(new ArrayList<AppliedLabel>())
            .addAllEffectiveAppliedLabels(new ArrayList<AppliedLabel>())
            .setSameAdvertiserExceptionEnabled(true)
            .setUpdateSource("updateSource-944762300")
            .setNotes("notes105008833")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllCustomFieldValues(new ArrayList<CustomFieldValue>())
            .setMissingCreatives(true)
            .setThirdPartyMeasurementSettings(ThirdPartyMeasurementSettings.newBuilder().build())
            .setYoutubeKidsRestricted(true)
            .setMaxVideoCreativeDuration(Duration.newBuilder().build())
            .setGoal(Goal.newBuilder().build())
            .addAllSecondaryGoals(new ArrayList<Goal>())
            .setGrpSettings(GrpSettings.newBuilder().build())
            .setDealInfo(LineItemDealInfo.newBuilder().build())
            .addAllViewabilityProviderCompanies(new ArrayList<String>())
            .setCustomVastExtension("customVastExtension-456132766")
            .setSponsorshipExclusivityEnabled(true)
            .setRepeatedCreativeServingEnabled(true)
            .setTargeting(Targeting.newBuilder().build())
            .addAllCreativeTargetings(new ArrayList<CreativeTargeting>())
            .addAllAllowedFormats(new ArrayList<LineItemAllowedFormatEnum.LineItemAllowedFormat>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    LineItem lineItem = LineItem.newBuilder().build();

    LineItem actualResponse = client.createLineItem(parent, lineItem);
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
  public void createLineItemExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      LineItem lineItem = LineItem.newBuilder().build();
      client.createLineItem(parent, lineItem);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateLineItemsTest() throws Exception {
    BatchCreateLineItemsResponse expectedResponse =
        BatchCreateLineItemsResponse.newBuilder()
            .addAllLineItems(new ArrayList<LineItem>())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<CreateLineItemRequest> requests = new ArrayList<>();

    BatchCreateLineItemsResponse actualResponse = client.batchCreateLineItems(parent, requests);
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
  public void batchCreateLineItemsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<CreateLineItemRequest> requests = new ArrayList<>();
      client.batchCreateLineItems(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateLineItemsTest2() throws Exception {
    BatchCreateLineItemsResponse expectedResponse =
        BatchCreateLineItemsResponse.newBuilder()
            .addAllLineItems(new ArrayList<LineItem>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<CreateLineItemRequest> requests = new ArrayList<>();

    BatchCreateLineItemsResponse actualResponse = client.batchCreateLineItems(parent, requests);
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
  public void batchCreateLineItemsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<CreateLineItemRequest> requests = new ArrayList<>();
      client.batchCreateLineItems(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateLineItemTest() throws Exception {
    LineItem expectedResponse =
        LineItem.newBuilder()
            .setName(LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]").toString())
            .setOrder(OrderName.of("[NETWORK_CODE]", "[ORDER]").toString())
            .setDisplayName("displayName1714148973")
            .setExternalLineItemId("externalLineItemId760028877")
            .setOrderDisplayName("orderDisplayName1559886399")
            .setStartTime(Timestamp.newBuilder().build())
            .setTargetEndTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setAutoExtensionDays(2065627367)
            .setEndTimeUnlimited(true)
            .setCustomPacingCurve(CustomPacingCurve.newBuilder().build())
            .addAllFrequencyCaps(new ArrayList<FrequencyCap>())
            .setPriority(-1165461084)
            .setRate(Money.newBuilder().build())
            .setValueCpm(Money.newBuilder().build())
            .setDiscount(LineItemDiscount.newBuilder().build())
            .setContractedUnitsBought(-424175607)
            .addAllCreativePlaceholders(new ArrayList<CreativePlaceholder>())
            .setAllowOverbook(true)
            .setSkipInventoryCheck(true)
            .setSkipCrossSellingRuleWarningChecks(true)
            .setReserveOnCreation(true)
            .setStats(LineItemStats.newBuilder().build())
            .setDeliveryIndicator(DeliveryIndicator.newBuilder().build())
            .setBudget(Money.newBuilder().build())
            .setArchived(true)
            .setWebPropertyCode("webPropertyCode98815702")
            .addAllAppliedLabels(new ArrayList<AppliedLabel>())
            .addAllEffectiveAppliedLabels(new ArrayList<AppliedLabel>())
            .setSameAdvertiserExceptionEnabled(true)
            .setUpdateSource("updateSource-944762300")
            .setNotes("notes105008833")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllCustomFieldValues(new ArrayList<CustomFieldValue>())
            .setMissingCreatives(true)
            .setThirdPartyMeasurementSettings(ThirdPartyMeasurementSettings.newBuilder().build())
            .setYoutubeKidsRestricted(true)
            .setMaxVideoCreativeDuration(Duration.newBuilder().build())
            .setGoal(Goal.newBuilder().build())
            .addAllSecondaryGoals(new ArrayList<Goal>())
            .setGrpSettings(GrpSettings.newBuilder().build())
            .setDealInfo(LineItemDealInfo.newBuilder().build())
            .addAllViewabilityProviderCompanies(new ArrayList<String>())
            .setCustomVastExtension("customVastExtension-456132766")
            .setSponsorshipExclusivityEnabled(true)
            .setRepeatedCreativeServingEnabled(true)
            .setTargeting(Targeting.newBuilder().build())
            .addAllCreativeTargetings(new ArrayList<CreativeTargeting>())
            .addAllAllowedFormats(new ArrayList<LineItemAllowedFormatEnum.LineItemAllowedFormat>())
            .build();
    mockService.addResponse(expectedResponse);

    LineItem lineItem =
        LineItem.newBuilder()
            .setName(LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]").toString())
            .setOrder(OrderName.of("[NETWORK_CODE]", "[ORDER]").toString())
            .setDisplayName("displayName1714148973")
            .setExternalLineItemId("externalLineItemId760028877")
            .setOrderDisplayName("orderDisplayName1559886399")
            .setStartTime(Timestamp.newBuilder().build())
            .setTargetEndTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setAutoExtensionDays(2065627367)
            .setEndTimeUnlimited(true)
            .setCustomPacingCurve(CustomPacingCurve.newBuilder().build())
            .addAllFrequencyCaps(new ArrayList<FrequencyCap>())
            .setPriority(-1165461084)
            .setRate(Money.newBuilder().build())
            .setValueCpm(Money.newBuilder().build())
            .setDiscount(LineItemDiscount.newBuilder().build())
            .setContractedUnitsBought(-424175607)
            .addAllCreativePlaceholders(new ArrayList<CreativePlaceholder>())
            .setAllowOverbook(true)
            .setSkipInventoryCheck(true)
            .setSkipCrossSellingRuleWarningChecks(true)
            .setReserveOnCreation(true)
            .setStats(LineItemStats.newBuilder().build())
            .setDeliveryIndicator(DeliveryIndicator.newBuilder().build())
            .setBudget(Money.newBuilder().build())
            .setArchived(true)
            .setWebPropertyCode("webPropertyCode98815702")
            .addAllAppliedLabels(new ArrayList<AppliedLabel>())
            .addAllEffectiveAppliedLabels(new ArrayList<AppliedLabel>())
            .setSameAdvertiserExceptionEnabled(true)
            .setUpdateSource("updateSource-944762300")
            .setNotes("notes105008833")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllCustomFieldValues(new ArrayList<CustomFieldValue>())
            .setMissingCreatives(true)
            .setThirdPartyMeasurementSettings(ThirdPartyMeasurementSettings.newBuilder().build())
            .setYoutubeKidsRestricted(true)
            .setMaxVideoCreativeDuration(Duration.newBuilder().build())
            .setGoal(Goal.newBuilder().build())
            .addAllSecondaryGoals(new ArrayList<Goal>())
            .setGrpSettings(GrpSettings.newBuilder().build())
            .setDealInfo(LineItemDealInfo.newBuilder().build())
            .addAllViewabilityProviderCompanies(new ArrayList<String>())
            .setCustomVastExtension("customVastExtension-456132766")
            .setSponsorshipExclusivityEnabled(true)
            .setRepeatedCreativeServingEnabled(true)
            .setTargeting(Targeting.newBuilder().build())
            .addAllCreativeTargetings(new ArrayList<CreativeTargeting>())
            .addAllAllowedFormats(new ArrayList<LineItemAllowedFormatEnum.LineItemAllowedFormat>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    LineItem actualResponse = client.updateLineItem(lineItem, updateMask);
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
  public void updateLineItemExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LineItem lineItem =
          LineItem.newBuilder()
              .setName(LineItemName.of("[NETWORK_CODE]", "[LINE_ITEM]").toString())
              .setOrder(OrderName.of("[NETWORK_CODE]", "[ORDER]").toString())
              .setDisplayName("displayName1714148973")
              .setExternalLineItemId("externalLineItemId760028877")
              .setOrderDisplayName("orderDisplayName1559886399")
              .setStartTime(Timestamp.newBuilder().build())
              .setTargetEndTime(Timestamp.newBuilder().build())
              .setEndTime(Timestamp.newBuilder().build())
              .setAutoExtensionDays(2065627367)
              .setEndTimeUnlimited(true)
              .setCustomPacingCurve(CustomPacingCurve.newBuilder().build())
              .addAllFrequencyCaps(new ArrayList<FrequencyCap>())
              .setPriority(-1165461084)
              .setRate(Money.newBuilder().build())
              .setValueCpm(Money.newBuilder().build())
              .setDiscount(LineItemDiscount.newBuilder().build())
              .setContractedUnitsBought(-424175607)
              .addAllCreativePlaceholders(new ArrayList<CreativePlaceholder>())
              .setAllowOverbook(true)
              .setSkipInventoryCheck(true)
              .setSkipCrossSellingRuleWarningChecks(true)
              .setReserveOnCreation(true)
              .setStats(LineItemStats.newBuilder().build())
              .setDeliveryIndicator(DeliveryIndicator.newBuilder().build())
              .setBudget(Money.newBuilder().build())
              .setArchived(true)
              .setWebPropertyCode("webPropertyCode98815702")
              .addAllAppliedLabels(new ArrayList<AppliedLabel>())
              .addAllEffectiveAppliedLabels(new ArrayList<AppliedLabel>())
              .setSameAdvertiserExceptionEnabled(true)
              .setUpdateSource("updateSource-944762300")
              .setNotes("notes105008833")
              .setUpdateTime(Timestamp.newBuilder().build())
              .setCreateTime(Timestamp.newBuilder().build())
              .addAllCustomFieldValues(new ArrayList<CustomFieldValue>())
              .setMissingCreatives(true)
              .setThirdPartyMeasurementSettings(ThirdPartyMeasurementSettings.newBuilder().build())
              .setYoutubeKidsRestricted(true)
              .setMaxVideoCreativeDuration(Duration.newBuilder().build())
              .setGoal(Goal.newBuilder().build())
              .addAllSecondaryGoals(new ArrayList<Goal>())
              .setGrpSettings(GrpSettings.newBuilder().build())
              .setDealInfo(LineItemDealInfo.newBuilder().build())
              .addAllViewabilityProviderCompanies(new ArrayList<String>())
              .setCustomVastExtension("customVastExtension-456132766")
              .setSponsorshipExclusivityEnabled(true)
              .setRepeatedCreativeServingEnabled(true)
              .setTargeting(Targeting.newBuilder().build())
              .addAllCreativeTargetings(new ArrayList<CreativeTargeting>())
              .addAllAllowedFormats(
                  new ArrayList<LineItemAllowedFormatEnum.LineItemAllowedFormat>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateLineItem(lineItem, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateLineItemsTest() throws Exception {
    BatchUpdateLineItemsResponse expectedResponse =
        BatchUpdateLineItemsResponse.newBuilder()
            .addAllLineItems(new ArrayList<LineItem>())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<UpdateLineItemRequest> requests = new ArrayList<>();

    BatchUpdateLineItemsResponse actualResponse = client.batchUpdateLineItems(parent, requests);
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
  public void batchUpdateLineItemsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<UpdateLineItemRequest> requests = new ArrayList<>();
      client.batchUpdateLineItems(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateLineItemsTest2() throws Exception {
    BatchUpdateLineItemsResponse expectedResponse =
        BatchUpdateLineItemsResponse.newBuilder()
            .addAllLineItems(new ArrayList<LineItem>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<UpdateLineItemRequest> requests = new ArrayList<>();

    BatchUpdateLineItemsResponse actualResponse = client.batchUpdateLineItems(parent, requests);
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
  public void batchUpdateLineItemsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<UpdateLineItemRequest> requests = new ArrayList<>();
      client.batchUpdateLineItems(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchActivateLineItemsTest() throws Exception {
    BatchActivateLineItemsResponse expectedResponse =
        BatchActivateLineItemsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchActivateLineItemsResponse actualResponse = client.batchActivateLineItems(parent, names);
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
  public void batchActivateLineItemsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchActivateLineItems(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchActivateLineItemsTest2() throws Exception {
    BatchActivateLineItemsResponse expectedResponse =
        BatchActivateLineItemsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchActivateLineItemsResponse actualResponse = client.batchActivateLineItems(parent, names);
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
  public void batchActivateLineItemsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchActivateLineItems(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchPauseLineItemsTest() throws Exception {
    BatchPauseLineItemsResponse expectedResponse = BatchPauseLineItemsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchPauseLineItemsResponse actualResponse = client.batchPauseLineItems(parent, names);
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
  public void batchPauseLineItemsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchPauseLineItems(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchPauseLineItemsTest2() throws Exception {
    BatchPauseLineItemsResponse expectedResponse = BatchPauseLineItemsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchPauseLineItemsResponse actualResponse = client.batchPauseLineItems(parent, names);
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
  public void batchPauseLineItemsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchPauseLineItems(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchResumeLineItemsTest() throws Exception {
    BatchResumeLineItemsResponse expectedResponse =
        BatchResumeLineItemsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchResumeLineItemsResponse actualResponse = client.batchResumeLineItems(parent, names);
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
  public void batchResumeLineItemsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchResumeLineItems(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchResumeLineItemsTest2() throws Exception {
    BatchResumeLineItemsResponse expectedResponse =
        BatchResumeLineItemsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchResumeLineItemsResponse actualResponse = client.batchResumeLineItems(parent, names);
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
  public void batchResumeLineItemsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchResumeLineItems(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchResumeAndOverbookLineItemsTest() throws Exception {
    BatchResumeAndOverbookLineItemsResponse expectedResponse =
        BatchResumeAndOverbookLineItemsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchResumeAndOverbookLineItemsResponse actualResponse =
        client.batchResumeAndOverbookLineItems(parent, names);
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
  public void batchResumeAndOverbookLineItemsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchResumeAndOverbookLineItems(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchResumeAndOverbookLineItemsTest2() throws Exception {
    BatchResumeAndOverbookLineItemsResponse expectedResponse =
        BatchResumeAndOverbookLineItemsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchResumeAndOverbookLineItemsResponse actualResponse =
        client.batchResumeAndOverbookLineItems(parent, names);
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
  public void batchResumeAndOverbookLineItemsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchResumeAndOverbookLineItems(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDeleteLineItemsTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    client.batchDeleteLineItems(parent, names);

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
  public void batchDeleteLineItemsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchDeleteLineItems(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDeleteLineItemsTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    client.batchDeleteLineItems(parent, names);

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
  public void batchDeleteLineItemsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchDeleteLineItems(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchReserveLineItemsTest() throws Exception {
    BatchReserveLineItemsResponse expectedResponse =
        BatchReserveLineItemsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchReserveLineItemsResponse actualResponse = client.batchReserveLineItems(parent, names);
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
  public void batchReserveLineItemsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchReserveLineItems(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchReserveLineItemsTest2() throws Exception {
    BatchReserveLineItemsResponse expectedResponse =
        BatchReserveLineItemsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchReserveLineItemsResponse actualResponse = client.batchReserveLineItems(parent, names);
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
  public void batchReserveLineItemsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchReserveLineItems(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchReserveAndOverbookLineItemsTest() throws Exception {
    BatchReserveAndOverbookLineItemsResponse expectedResponse =
        BatchReserveAndOverbookLineItemsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchReserveAndOverbookLineItemsResponse actualResponse =
        client.batchReserveAndOverbookLineItems(parent, names);
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
  public void batchReserveAndOverbookLineItemsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchReserveAndOverbookLineItems(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchReserveAndOverbookLineItemsTest2() throws Exception {
    BatchReserveAndOverbookLineItemsResponse expectedResponse =
        BatchReserveAndOverbookLineItemsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchReserveAndOverbookLineItemsResponse actualResponse =
        client.batchReserveAndOverbookLineItems(parent, names);
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
  public void batchReserveAndOverbookLineItemsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchReserveAndOverbookLineItems(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchReleaseLineItemsTest() throws Exception {
    BatchReleaseLineItemsResponse expectedResponse =
        BatchReleaseLineItemsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchReleaseLineItemsResponse actualResponse = client.batchReleaseLineItems(parent, names);
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
  public void batchReleaseLineItemsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchReleaseLineItems(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchReleaseLineItemsTest2() throws Exception {
    BatchReleaseLineItemsResponse expectedResponse =
        BatchReleaseLineItemsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchReleaseLineItemsResponse actualResponse = client.batchReleaseLineItems(parent, names);
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
  public void batchReleaseLineItemsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchReleaseLineItems(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchArchiveLineItemsTest() throws Exception {
    BatchArchiveLineItemsResponse expectedResponse =
        BatchArchiveLineItemsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchArchiveLineItemsResponse actualResponse = client.batchArchiveLineItems(parent, names);
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
  public void batchArchiveLineItemsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchArchiveLineItems(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchArchiveLineItemsTest2() throws Exception {
    BatchArchiveLineItemsResponse expectedResponse =
        BatchArchiveLineItemsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchArchiveLineItemsResponse actualResponse = client.batchArchiveLineItems(parent, names);
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
  public void batchArchiveLineItemsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchArchiveLineItems(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUnarchiveLineItemsTest() throws Exception {
    BatchUnarchiveLineItemsResponse expectedResponse =
        BatchUnarchiveLineItemsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchUnarchiveLineItemsResponse actualResponse = client.batchUnarchiveLineItems(parent, names);
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
  public void batchUnarchiveLineItemsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchUnarchiveLineItems(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUnarchiveLineItemsTest2() throws Exception {
    BatchUnarchiveLineItemsResponse expectedResponse =
        BatchUnarchiveLineItemsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchUnarchiveLineItemsResponse actualResponse = client.batchUnarchiveLineItems(parent, names);
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
  public void batchUnarchiveLineItemsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchUnarchiveLineItems(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
