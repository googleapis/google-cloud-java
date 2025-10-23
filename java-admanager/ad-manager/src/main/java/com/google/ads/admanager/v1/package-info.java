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

/**
 * A client to Google Ad Manager API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= AdBreakServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `AdBreak` objects.
 *
 * <p>Sample for AdBreakServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (AdBreakServiceClient adBreakServiceClient = AdBreakServiceClient.create()) {
 *   AdBreakName name = AdBreakName.of("[NETWORK_CODE]", "[ASSET_KEY]", "[AD_BREAK]");
 *   AdBreak response = adBreakServiceClient.getAdBreak(name);
 * }
 * }</pre>
 *
 * <p>======================= AdReviewCenterAdServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling AdReviewCenterAd objects.
 *
 * <p>Sample for AdReviewCenterAdServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (AdReviewCenterAdServiceClient adReviewCenterAdServiceClient =
 *     AdReviewCenterAdServiceClient.create()) {
 *   WebPropertyName parent = WebPropertyName.of("[NETWORK_CODE]", "[WEB_PROPERTY]");
 *   for (AdReviewCenterAd element :
 *       adReviewCenterAdServiceClient.searchAdReviewCenterAds(parent).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>======================= AdUnitServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling AdUnit objects.
 *
 * <p>Sample for AdUnitServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
 *   AdUnitName name = AdUnitName.of("[NETWORK_CODE]", "[AD_UNIT]");
 *   AdUnit response = adUnitServiceClient.getAdUnit(name);
 * }
 * }</pre>
 *
 * <p>======================= ApplicationServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `Application` objects.
 *
 * <p>Sample for ApplicationServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ApplicationServiceClient applicationServiceClient = ApplicationServiceClient.create()) {
 *   ApplicationName name = ApplicationName.of("[NETWORK_CODE]", "[APPLICATION]");
 *   Application response = applicationServiceClient.getApplication(name);
 * }
 * }</pre>
 *
 * <p>======================= AudienceSegmentServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `AudienceSegment` objects.
 *
 * <p>Sample for AudienceSegmentServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (AudienceSegmentServiceClient audienceSegmentServiceClient =
 *     AudienceSegmentServiceClient.create()) {
 *   AudienceSegmentName name = AudienceSegmentName.of("[NETWORK_CODE]", "[AUDIENCE_SEGMENT]");
 *   AudienceSegment response = audienceSegmentServiceClient.getAudienceSegment(name);
 * }
 * }</pre>
 *
 * <p>======================= BandwidthGroupServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `BandwidthGroup` objects.
 *
 * <p>Sample for BandwidthGroupServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (BandwidthGroupServiceClient bandwidthGroupServiceClient =
 *     BandwidthGroupServiceClient.create()) {
 *   BandwidthGroupName name = BandwidthGroupName.of("[NETWORK_CODE]", "[BANDWIDTH_GROUP]");
 *   BandwidthGroup response = bandwidthGroupServiceClient.getBandwidthGroup(name);
 * }
 * }</pre>
 *
 * <p>======================= BrowserLanguageServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `BrowserLanguage` objects.
 *
 * <p>Sample for BrowserLanguageServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (BrowserLanguageServiceClient browserLanguageServiceClient =
 *     BrowserLanguageServiceClient.create()) {
 *   BrowserLanguageName name = BrowserLanguageName.of("[NETWORK_CODE]", "[BROWSER_LANGUAGE]");
 *   BrowserLanguage response = browserLanguageServiceClient.getBrowserLanguage(name);
 * }
 * }</pre>
 *
 * <p>======================= BrowserServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `Browser` objects.
 *
 * <p>Sample for BrowserServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (BrowserServiceClient browserServiceClient = BrowserServiceClient.create()) {
 *   BrowserName name = BrowserName.of("[NETWORK_CODE]", "[BROWSER]");
 *   Browser response = browserServiceClient.getBrowser(name);
 * }
 * }</pre>
 *
 * <p>======================= CmsMetadataKeyServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `CmsMetadataKey` objects.
 *
 * <p>Sample for CmsMetadataKeyServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (CmsMetadataKeyServiceClient cmsMetadataKeyServiceClient =
 *     CmsMetadataKeyServiceClient.create()) {
 *   CmsMetadataKeyName name = CmsMetadataKeyName.of("[NETWORK_CODE]", "[CMS_METADATA_KEY]");
 *   CmsMetadataKey response = cmsMetadataKeyServiceClient.getCmsMetadataKey(name);
 * }
 * }</pre>
 *
 * <p>======================= CmsMetadataValueServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `CmsMetadataValue` objects.
 *
 * <p>Sample for CmsMetadataValueServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (CmsMetadataValueServiceClient cmsMetadataValueServiceClient =
 *     CmsMetadataValueServiceClient.create()) {
 *   CmsMetadataValueName name = CmsMetadataValueName.of("[NETWORK_CODE]", "[CMS_METADATA_VALUE]");
 *   CmsMetadataValue response = cmsMetadataValueServiceClient.getCmsMetadataValue(name);
 * }
 * }</pre>
 *
 * <p>======================= CompanyServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `Company` objects.
 *
 * <p>Sample for CompanyServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (CompanyServiceClient companyServiceClient = CompanyServiceClient.create()) {
 *   CompanyName name = CompanyName.of("[NETWORK_CODE]", "[COMPANY]");
 *   Company response = companyServiceClient.getCompany(name);
 * }
 * }</pre>
 *
 * <p>======================= ContactServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `Contact` objects.
 *
 * <p>Sample for ContactServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ContactServiceClient contactServiceClient = ContactServiceClient.create()) {
 *   ContactName name = ContactName.of("[NETWORK_CODE]", "[CONTACT]");
 *   Contact response = contactServiceClient.getContact(name);
 * }
 * }</pre>
 *
 * <p>======================= ContentBundleServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `ContentBundle` objects.
 *
 * <p>Sample for ContentBundleServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ContentBundleServiceClient contentBundleServiceClient =
 *     ContentBundleServiceClient.create()) {
 *   ContentBundleName name = ContentBundleName.of("[NETWORK_CODE]", "[CONTENT_BUNDLE]");
 *   ContentBundle response = contentBundleServiceClient.getContentBundle(name);
 * }
 * }</pre>
 *
 * <p>======================= ContentLabelServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `ContentLabel` objects.
 *
 * <p>Sample for ContentLabelServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ContentLabelServiceClient contentLabelServiceClient = ContentLabelServiceClient.create()) {
 *   ContentLabelName name = ContentLabelName.of("[NETWORK_CODE]", "[CONTENT_LABEL]");
 *   ContentLabel response = contentLabelServiceClient.getContentLabel(name);
 * }
 * }</pre>
 *
 * <p>======================= ContentServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `Content` objects.
 *
 * <p>Sample for ContentServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ContentServiceClient contentServiceClient = ContentServiceClient.create()) {
 *   ContentName name = ContentName.of("[NETWORK_CODE]", "[CONTENT]");
 *   Content response = contentServiceClient.getContent(name);
 * }
 * }</pre>
 *
 * <p>======================= CreativeTemplateServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `CreativeTemplate` objects.
 *
 * <p>Sample for CreativeTemplateServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (CreativeTemplateServiceClient creativeTemplateServiceClient =
 *     CreativeTemplateServiceClient.create()) {
 *   CreativeTemplateName name = CreativeTemplateName.of("[NETWORK_CODE]", "[CREATIVE_TEMPLATE]");
 *   CreativeTemplate response = creativeTemplateServiceClient.getCreativeTemplate(name);
 * }
 * }</pre>
 *
 * <p>======================= CustomFieldServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `CustomField` objects.
 *
 * <p>Sample for CustomFieldServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (CustomFieldServiceClient customFieldServiceClient = CustomFieldServiceClient.create()) {
 *   CustomFieldName name = CustomFieldName.of("[NETWORK_CODE]", "[CUSTOM_FIELD]");
 *   CustomField response = customFieldServiceClient.getCustomField(name);
 * }
 * }</pre>
 *
 * <p>======================= CustomTargetingKeyServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `CustomTargetingKey` objects.
 *
 * <p>Sample for CustomTargetingKeyServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
 *     CustomTargetingKeyServiceClient.create()) {
 *   CustomTargetingKeyName name =
 *       CustomTargetingKeyName.of("[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]");
 *   CustomTargetingKey response = customTargetingKeyServiceClient.getCustomTargetingKey(name);
 * }
 * }</pre>
 *
 * <p>======================= CustomTargetingValueServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `CustomTargetingValue` objects.
 *
 * <p>Sample for CustomTargetingValueServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
 *     CustomTargetingValueServiceClient.create()) {
 *   CustomTargetingValueName name =
 *       CustomTargetingValueName.of("[NETWORK_CODE]", "[CUSTOM_TARGETING_VALUE]");
 *   CustomTargetingValue response =
 *       customTargetingValueServiceClient.getCustomTargetingValue(name);
 * }
 * }</pre>
 *
 * <p>======================= DeviceCapabilityServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `DeviceCapability` objects.
 *
 * <p>Sample for DeviceCapabilityServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DeviceCapabilityServiceClient deviceCapabilityServiceClient =
 *     DeviceCapabilityServiceClient.create()) {
 *   DeviceCapabilityName name = DeviceCapabilityName.of("[NETWORK_CODE]", "[DEVICE_CAPABILITY]");
 *   DeviceCapability response = deviceCapabilityServiceClient.getDeviceCapability(name);
 * }
 * }</pre>
 *
 * <p>======================= DeviceCategoryServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `DeviceCategory` objects.
 *
 * <p>Sample for DeviceCategoryServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DeviceCategoryServiceClient deviceCategoryServiceClient =
 *     DeviceCategoryServiceClient.create()) {
 *   DeviceCategoryName name = DeviceCategoryName.of("[NETWORK_CODE]", "[DEVICE_CATEGORY]");
 *   DeviceCategory response = deviceCategoryServiceClient.getDeviceCategory(name);
 * }
 * }</pre>
 *
 * <p>======================= DeviceManufacturerServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `DeviceManufacturer` objects.
 *
 * <p>Sample for DeviceManufacturerServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DeviceManufacturerServiceClient deviceManufacturerServiceClient =
 *     DeviceManufacturerServiceClient.create()) {
 *   DeviceManufacturerName name =
 *       DeviceManufacturerName.of("[NETWORK_CODE]", "[DEVICE_MANUFACTURER]");
 *   DeviceManufacturer response = deviceManufacturerServiceClient.getDeviceManufacturer(name);
 * }
 * }</pre>
 *
 * <p>======================= EntitySignalsMappingServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `EntitySignalsMapping` objects.
 *
 * <p>Sample for EntitySignalsMappingServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (EntitySignalsMappingServiceClient entitySignalsMappingServiceClient =
 *     EntitySignalsMappingServiceClient.create()) {
 *   EntitySignalsMappingName name =
 *       EntitySignalsMappingName.of("[NETWORK_CODE]", "[ENTITY_SIGNALS_MAPPING]");
 *   EntitySignalsMapping response =
 *       entitySignalsMappingServiceClient.getEntitySignalsMapping(name);
 * }
 * }</pre>
 *
 * <p>======================= GeoTargetServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `GeoTarget` objects.
 *
 * <p>Sample for GeoTargetServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (GeoTargetServiceClient geoTargetServiceClient = GeoTargetServiceClient.create()) {
 *   GeoTargetName name = GeoTargetName.of("[NETWORK_CODE]", "[GEO_TARGET]");
 *   GeoTarget response = geoTargetServiceClient.getGeoTarget(name);
 * }
 * }</pre>
 *
 * <p>======================= MobileCarrierServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `MobileCarrier` objects.
 *
 * <p>Sample for MobileCarrierServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (MobileCarrierServiceClient mobileCarrierServiceClient =
 *     MobileCarrierServiceClient.create()) {
 *   MobileCarrierName name = MobileCarrierName.of("[NETWORK_CODE]", "[MOBILE_CARRIER]");
 *   MobileCarrier response = mobileCarrierServiceClient.getMobileCarrier(name);
 * }
 * }</pre>
 *
 * <p>======================= MobileDeviceServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `MobileDevice` objects.
 *
 * <p>Sample for MobileDeviceServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (MobileDeviceServiceClient mobileDeviceServiceClient = MobileDeviceServiceClient.create()) {
 *   MobileDeviceName name = MobileDeviceName.of("[NETWORK_CODE]", "[MOBILE_DEVICE]");
 *   MobileDevice response = mobileDeviceServiceClient.getMobileDevice(name);
 * }
 * }</pre>
 *
 * <p>======================= MobileDeviceSubmodelServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `MobileDeviceSubmodel` objects.
 *
 * <p>Sample for MobileDeviceSubmodelServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (MobileDeviceSubmodelServiceClient mobileDeviceSubmodelServiceClient =
 *     MobileDeviceSubmodelServiceClient.create()) {
 *   MobileDeviceSubmodelName name =
 *       MobileDeviceSubmodelName.of("[NETWORK_CODE]", "[MOBILE_DEVICE_SUBMODEL]");
 *   MobileDeviceSubmodel response =
 *       mobileDeviceSubmodelServiceClient.getMobileDeviceSubmodel(name);
 * }
 * }</pre>
 *
 * <p>======================= NetworkServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `Network` objects.
 *
 * <p>Sample for NetworkServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (NetworkServiceClient networkServiceClient = NetworkServiceClient.create()) {
 *   NetworkName name = NetworkName.of("[NETWORK_CODE]");
 *   Network response = networkServiceClient.getNetwork(name);
 * }
 * }</pre>
 *
 * <p>======================= OperatingSystemServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `OperatingSystem` objects.
 *
 * <p>Sample for OperatingSystemServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (OperatingSystemServiceClient operatingSystemServiceClient =
 *     OperatingSystemServiceClient.create()) {
 *   OperatingSystemName name = OperatingSystemName.of("[NETWORK_CODE]", "[OPERATING_SYSTEM]");
 *   OperatingSystem response = operatingSystemServiceClient.getOperatingSystem(name);
 * }
 * }</pre>
 *
 * <p>======================= OperatingSystemVersionServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `OperatingSystemVersion` objects.
 *
 * <p>Sample for OperatingSystemVersionServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (OperatingSystemVersionServiceClient operatingSystemVersionServiceClient =
 *     OperatingSystemVersionServiceClient.create()) {
 *   OperatingSystemVersionName name =
 *       OperatingSystemVersionName.of("[NETWORK_CODE]", "[OPERATING_SYSTEM_VERSION]");
 *   OperatingSystemVersion response =
 *       operatingSystemVersionServiceClient.getOperatingSystemVersion(name);
 * }
 * }</pre>
 *
 * <p>======================= OrderServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `Order` objects.
 *
 * <p>Sample for OrderServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (OrderServiceClient orderServiceClient = OrderServiceClient.create()) {
 *   OrderName name = OrderName.of("[NETWORK_CODE]", "[ORDER]");
 *   Order response = orderServiceClient.getOrder(name);
 * }
 * }</pre>
 *
 * <p>======================= PlacementServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `Placement` objects.
 *
 * <p>Sample for PlacementServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
 *   PlacementName name = PlacementName.of("[NETWORK_CODE]", "[PLACEMENT]");
 *   Placement response = placementServiceClient.getPlacement(name);
 * }
 * }</pre>
 *
 * <p>======================= PrivateAuctionDealServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `PrivateAuctionDeal` objects.
 *
 * <p>Sample for PrivateAuctionDealServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (PrivateAuctionDealServiceClient privateAuctionDealServiceClient =
 *     PrivateAuctionDealServiceClient.create()) {
 *   PrivateAuctionDealName name =
 *       PrivateAuctionDealName.of("[NETWORK_CODE]", "[PRIVATE_AUCTION_DEAL]");
 *   PrivateAuctionDeal response = privateAuctionDealServiceClient.getPrivateAuctionDeal(name);
 * }
 * }</pre>
 *
 * <p>======================= PrivateAuctionServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `PrivateAuction` objects.
 *
 * <p>Sample for PrivateAuctionServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (PrivateAuctionServiceClient privateAuctionServiceClient =
 *     PrivateAuctionServiceClient.create()) {
 *   PrivateAuctionName name = PrivateAuctionName.of("[NETWORK_CODE]", "[PRIVATE_AUCTION]");
 *   PrivateAuction response = privateAuctionServiceClient.getPrivateAuction(name);
 * }
 * }</pre>
 *
 * <p>======================= ProgrammaticBuyerServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `ProgrammaticBuyer` objects.
 *
 * <p>Sample for ProgrammaticBuyerServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ProgrammaticBuyerServiceClient programmaticBuyerServiceClient =
 *     ProgrammaticBuyerServiceClient.create()) {
 *   ProgrammaticBuyerName name =
 *       ProgrammaticBuyerName.of("[NETWORK_CODE]", "[PROGRAMMATIC_BUYER]");
 *   ProgrammaticBuyer response = programmaticBuyerServiceClient.getProgrammaticBuyer(name);
 * }
 * }</pre>
 *
 * <p>======================= ReportServiceClient =======================
 *
 * <p>Service Description: Provides methods for interacting with reports.
 *
 * <p>Sample for ReportServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ReportServiceClient reportServiceClient = ReportServiceClient.create()) {
 *   ReportName name = ReportName.of("[NETWORK_CODE]", "[REPORT]");
 *   Report response = reportServiceClient.getReport(name);
 * }
 * }</pre>
 *
 * <p>======================= RoleServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `Role` objects.
 *
 * <p>Sample for RoleServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (RoleServiceClient roleServiceClient = RoleServiceClient.create()) {
 *   RoleName name = RoleName.of("[NETWORK_CODE]", "[ROLE]");
 *   Role response = roleServiceClient.getRole(name);
 * }
 * }</pre>
 *
 * <p>======================= SiteServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `Site` objects.
 *
 * <p>Sample for SiteServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SiteServiceClient siteServiceClient = SiteServiceClient.create()) {
 *   SiteName name = SiteName.of("[NETWORK_CODE]", "[SITE]");
 *   Site response = siteServiceClient.getSite(name);
 * }
 * }</pre>
 *
 * <p>======================= TaxonomyCategoryServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `TaxonomyCategory` objects.
 *
 * <p>Sample for TaxonomyCategoryServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (TaxonomyCategoryServiceClient taxonomyCategoryServiceClient =
 *     TaxonomyCategoryServiceClient.create()) {
 *   TaxonomyCategoryName name = TaxonomyCategoryName.of("[NETWORK_CODE]", "[TAXONOMY_CATEGORY]");
 *   TaxonomyCategory response = taxonomyCategoryServiceClient.getTaxonomyCategory(name);
 * }
 * }</pre>
 *
 * <p>======================= TeamServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling `Team` objects.
 *
 * <p>Sample for TeamServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (TeamServiceClient teamServiceClient = TeamServiceClient.create()) {
 *   TeamName name = TeamName.of("[NETWORK_CODE]", "[TEAM]");
 *   Team response = teamServiceClient.getTeam(name);
 * }
 * }</pre>
 *
 * <p>======================= UserServiceClient =======================
 *
 * <p>Service Description: Provides methods for handling User objects.
 *
 * <p>Sample for UserServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (UserServiceClient userServiceClient = UserServiceClient.create()) {
 *   UserName name = UserName.of("[NETWORK_CODE]", "[USER]");
 *   User response = userServiceClient.getUser(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.ads.admanager.v1;

import javax.annotation.Generated;
