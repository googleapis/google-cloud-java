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

package com.google.cloud.video.stitcher.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.video.stitcher.v1.stub.VideoStitcherServiceStub;
import com.google.cloud.video.stitcher.v1.stub.VideoStitcherServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Video-On-Demand content stitching API allows you to insert ads into (VoD)
 * video on demand files. You will be able to render custom scrubber bars with highlighted ads,
 * enforce ad policies, allow seamless playback and tracking on native players and monetize content
 * with any standard VMAP compliant ad server.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (VideoStitcherServiceClient videoStitcherServiceClient =
 *     VideoStitcherServiceClient.create()) {
 *   CdnKeyName name = CdnKeyName.of("[PROJECT]", "[LOCATION]", "[CDN_KEY]");
 *   CdnKey response = videoStitcherServiceClient.getCdnKey(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the VideoStitcherServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> CreateCdnKey</td>
 *      <td><p> Creates a new CDN key.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createCdnKeyAsync(CreateCdnKeyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createCdnKeyAsync(LocationName parent, CdnKey cdnKey, String cdnKeyId)
 *           <li><p> createCdnKeyAsync(String parent, CdnKey cdnKey, String cdnKeyId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createCdnKeyOperationCallable()
 *           <li><p> createCdnKeyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCdnKeys</td>
 *      <td><p> Lists all CDN keys in the specified project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCdnKeys(ListCdnKeysRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCdnKeys(LocationName parent)
 *           <li><p> listCdnKeys(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCdnKeysPagedCallable()
 *           <li><p> listCdnKeysCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetCdnKey</td>
 *      <td><p> Returns the specified CDN key.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCdnKey(GetCdnKeyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCdnKey(CdnKeyName name)
 *           <li><p> getCdnKey(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCdnKeyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteCdnKey</td>
 *      <td><p> Deletes the specified CDN key.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteCdnKeyAsync(DeleteCdnKeyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteCdnKeyAsync(CdnKeyName name)
 *           <li><p> deleteCdnKeyAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteCdnKeyOperationCallable()
 *           <li><p> deleteCdnKeyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateCdnKey</td>
 *      <td><p> Updates the specified CDN key. Only update fields specified in the call method body.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateCdnKeyAsync(UpdateCdnKeyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateCdnKeyAsync(CdnKey cdnKey, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateCdnKeyOperationCallable()
 *           <li><p> updateCdnKeyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateVodSession</td>
 *      <td><p> Creates a client side playback VOD session and returns the full tracking and playback metadata of the session.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createVodSession(CreateVodSessionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createVodSession(LocationName parent, VodSession vodSession)
 *           <li><p> createVodSession(String parent, VodSession vodSession)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createVodSessionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetVodSession</td>
 *      <td><p> Returns the full tracking, playback metadata, and relevant ad-ops logs for the specified VOD session.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getVodSession(GetVodSessionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getVodSession(VodSessionName name)
 *           <li><p> getVodSession(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getVodSessionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListVodStitchDetails</td>
 *      <td><p> Returns a list of detailed stitching information of the specified VOD session.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listVodStitchDetails(ListVodStitchDetailsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listVodStitchDetails(VodSessionName parent)
 *           <li><p> listVodStitchDetails(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listVodStitchDetailsPagedCallable()
 *           <li><p> listVodStitchDetailsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetVodStitchDetail</td>
 *      <td><p> Returns the specified stitching information for the specified VOD session.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getVodStitchDetail(GetVodStitchDetailRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getVodStitchDetail(VodStitchDetailName name)
 *           <li><p> getVodStitchDetail(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getVodStitchDetailCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListVodAdTagDetails</td>
 *      <td><p> Return the list of ad tag details for the specified VOD session.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listVodAdTagDetails(ListVodAdTagDetailsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listVodAdTagDetails(VodSessionName parent)
 *           <li><p> listVodAdTagDetails(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listVodAdTagDetailsPagedCallable()
 *           <li><p> listVodAdTagDetailsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetVodAdTagDetail</td>
 *      <td><p> Returns the specified ad tag detail for the specified VOD session.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getVodAdTagDetail(GetVodAdTagDetailRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getVodAdTagDetail(VodAdTagDetailName name)
 *           <li><p> getVodAdTagDetail(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getVodAdTagDetailCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLiveAdTagDetails</td>
 *      <td><p> Return the list of ad tag details for the specified live session.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLiveAdTagDetails(ListLiveAdTagDetailsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listLiveAdTagDetails(LiveSessionName parent)
 *           <li><p> listLiveAdTagDetails(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLiveAdTagDetailsPagedCallable()
 *           <li><p> listLiveAdTagDetailsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLiveAdTagDetail</td>
 *      <td><p> Returns the specified ad tag detail for the specified live session.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLiveAdTagDetail(GetLiveAdTagDetailRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getLiveAdTagDetail(LiveAdTagDetailName name)
 *           <li><p> getLiveAdTagDetail(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLiveAdTagDetailCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSlate</td>
 *      <td><p> Creates a slate.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSlateAsync(CreateSlateRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createSlateAsync(LocationName parent, Slate slate, String slateId)
 *           <li><p> createSlateAsync(String parent, Slate slate, String slateId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSlateOperationCallable()
 *           <li><p> createSlateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSlates</td>
 *      <td><p> Lists all slates in the specified project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSlates(ListSlatesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSlates(LocationName parent)
 *           <li><p> listSlates(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSlatesPagedCallable()
 *           <li><p> listSlatesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSlate</td>
 *      <td><p> Returns the specified slate.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSlate(GetSlateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSlate(SlateName name)
 *           <li><p> getSlate(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSlateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSlate</td>
 *      <td><p> Updates the specified slate.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSlateAsync(UpdateSlateRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateSlateAsync(Slate slate, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSlateOperationCallable()
 *           <li><p> updateSlateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSlate</td>
 *      <td><p> Deletes the specified slate.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSlateAsync(DeleteSlateRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteSlateAsync(SlateName name)
 *           <li><p> deleteSlateAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSlateOperationCallable()
 *           <li><p> deleteSlateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateLiveSession</td>
 *      <td><p> Creates a new live session.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createLiveSession(CreateLiveSessionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createLiveSession(LocationName parent, LiveSession liveSession)
 *           <li><p> createLiveSession(String parent, LiveSession liveSession)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createLiveSessionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLiveSession</td>
 *      <td><p> Returns the details for the specified live session.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLiveSession(GetLiveSessionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getLiveSession(LiveSessionName name)
 *           <li><p> getLiveSession(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLiveSessionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateLiveConfig</td>
 *      <td><p> Registers the live config with the provided unique ID in the specified region.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createLiveConfigAsync(CreateLiveConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createLiveConfigAsync(LocationName parent, LiveConfig liveConfig, String liveConfigId)
 *           <li><p> createLiveConfigAsync(String parent, LiveConfig liveConfig, String liveConfigId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createLiveConfigOperationCallable()
 *           <li><p> createLiveConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLiveConfigs</td>
 *      <td><p> Lists all live configs managed by the Video Stitcher that belong to the specified project and region.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLiveConfigs(ListLiveConfigsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listLiveConfigs(LocationName parent)
 *           <li><p> listLiveConfigs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLiveConfigsPagedCallable()
 *           <li><p> listLiveConfigsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLiveConfig</td>
 *      <td><p> Returns the specified live config managed by the Video Stitcher service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLiveConfig(GetLiveConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getLiveConfig(LiveConfigName name)
 *           <li><p> getLiveConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLiveConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteLiveConfig</td>
 *      <td><p> Deletes the specified live config.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteLiveConfigAsync(DeleteLiveConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteLiveConfigAsync(LiveConfigName name)
 *           <li><p> deleteLiveConfigAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteLiveConfigOperationCallable()
 *           <li><p> deleteLiveConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateLiveConfig</td>
 *      <td><p> Updates the specified LiveConfig. Only update fields specified in the call method body.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateLiveConfigAsync(UpdateLiveConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateLiveConfigAsync(LiveConfig liveConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateLiveConfigOperationCallable()
 *           <li><p> updateLiveConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateVodConfig</td>
 *      <td><p> Registers the VOD config with the provided unique ID in the specified region.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createVodConfigAsync(CreateVodConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createVodConfigAsync(LocationName parent, VodConfig vodConfig, String vodConfigId)
 *           <li><p> createVodConfigAsync(String parent, VodConfig vodConfig, String vodConfigId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createVodConfigOperationCallable()
 *           <li><p> createVodConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListVodConfigs</td>
 *      <td><p> Lists all VOD configs managed by the Video Stitcher API that belong to the specified project and region.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listVodConfigs(ListVodConfigsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listVodConfigs(LocationName parent)
 *           <li><p> listVodConfigs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listVodConfigsPagedCallable()
 *           <li><p> listVodConfigsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetVodConfig</td>
 *      <td><p> Returns the specified VOD config managed by the Video Stitcher API service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getVodConfig(GetVodConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getVodConfig(VodConfigName name)
 *           <li><p> getVodConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getVodConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteVodConfig</td>
 *      <td><p> Deletes the specified VOD config.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteVodConfigAsync(DeleteVodConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteVodConfigAsync(VodConfigName name)
 *           <li><p> deleteVodConfigAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteVodConfigOperationCallable()
 *           <li><p> deleteVodConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateVodConfig</td>
 *      <td><p> Updates the specified VOD config. Only update fields specified in the call method body.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateVodConfigAsync(UpdateVodConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateVodConfigAsync(VodConfig vodConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateVodConfigOperationCallable()
 *           <li><p> updateVodConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of VideoStitcherServiceSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * VideoStitcherServiceSettings videoStitcherServiceSettings =
 *     VideoStitcherServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * VideoStitcherServiceClient videoStitcherServiceClient =
 *     VideoStitcherServiceClient.create(videoStitcherServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * VideoStitcherServiceSettings videoStitcherServiceSettings =
 *     VideoStitcherServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * VideoStitcherServiceClient videoStitcherServiceClient =
 *     VideoStitcherServiceClient.create(videoStitcherServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class VideoStitcherServiceClient implements BackgroundResource {
  private final VideoStitcherServiceSettings settings;
  private final VideoStitcherServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of VideoStitcherServiceClient with default settings. */
  public static final VideoStitcherServiceClient create() throws IOException {
    return create(VideoStitcherServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of VideoStitcherServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final VideoStitcherServiceClient create(VideoStitcherServiceSettings settings)
      throws IOException {
    return new VideoStitcherServiceClient(settings);
  }

  /**
   * Constructs an instance of VideoStitcherServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(VideoStitcherServiceSettings).
   */
  public static final VideoStitcherServiceClient create(VideoStitcherServiceStub stub) {
    return new VideoStitcherServiceClient(stub);
  }

  /**
   * Constructs an instance of VideoStitcherServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected VideoStitcherServiceClient(VideoStitcherServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((VideoStitcherServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected VideoStitcherServiceClient(VideoStitcherServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final VideoStitcherServiceSettings getSettings() {
    return settings;
  }

  public VideoStitcherServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CDN key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   CdnKey cdnKey = CdnKey.newBuilder().build();
   *   String cdnKeyId = "cdnKeyId-1777782867";
   *   CdnKey response =
   *       videoStitcherServiceClient.createCdnKeyAsync(parent, cdnKey, cdnKeyId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project in which the CDN key should be created, in the form of
   *     `projects/{project_number}/locations/{location}`.
   * @param cdnKey Required. The CDN key resource to create.
   * @param cdnKeyId Required. The ID to use for the CDN key, which will become the final component
   *     of the CDN key's resource name.
   *     <p>This value should conform to RFC-1034, which restricts to lower-case letters, numbers,
   *     and hyphen, with the first character a letter, the last a letter or a number, and a 63
   *     character maximum.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CdnKey, OperationMetadata> createCdnKeyAsync(
      LocationName parent, CdnKey cdnKey, String cdnKeyId) {
    CreateCdnKeyRequest request =
        CreateCdnKeyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCdnKey(cdnKey)
            .setCdnKeyId(cdnKeyId)
            .build();
    return createCdnKeyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CDN key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   CdnKey cdnKey = CdnKey.newBuilder().build();
   *   String cdnKeyId = "cdnKeyId-1777782867";
   *   CdnKey response =
   *       videoStitcherServiceClient.createCdnKeyAsync(parent, cdnKey, cdnKeyId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project in which the CDN key should be created, in the form of
   *     `projects/{project_number}/locations/{location}`.
   * @param cdnKey Required. The CDN key resource to create.
   * @param cdnKeyId Required. The ID to use for the CDN key, which will become the final component
   *     of the CDN key's resource name.
   *     <p>This value should conform to RFC-1034, which restricts to lower-case letters, numbers,
   *     and hyphen, with the first character a letter, the last a letter or a number, and a 63
   *     character maximum.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CdnKey, OperationMetadata> createCdnKeyAsync(
      String parent, CdnKey cdnKey, String cdnKeyId) {
    CreateCdnKeyRequest request =
        CreateCdnKeyRequest.newBuilder()
            .setParent(parent)
            .setCdnKey(cdnKey)
            .setCdnKeyId(cdnKeyId)
            .build();
    return createCdnKeyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CDN key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   CreateCdnKeyRequest request =
   *       CreateCdnKeyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCdnKey(CdnKey.newBuilder().build())
   *           .setCdnKeyId("cdnKeyId-1777782867")
   *           .build();
   *   CdnKey response = videoStitcherServiceClient.createCdnKeyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CdnKey, OperationMetadata> createCdnKeyAsync(
      CreateCdnKeyRequest request) {
    return createCdnKeyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CDN key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   CreateCdnKeyRequest request =
   *       CreateCdnKeyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCdnKey(CdnKey.newBuilder().build())
   *           .setCdnKeyId("cdnKeyId-1777782867")
   *           .build();
   *   OperationFuture<CdnKey, OperationMetadata> future =
   *       videoStitcherServiceClient.createCdnKeyOperationCallable().futureCall(request);
   *   // Do something.
   *   CdnKey response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateCdnKeyRequest, CdnKey, OperationMetadata>
      createCdnKeyOperationCallable() {
    return stub.createCdnKeyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CDN key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   CreateCdnKeyRequest request =
   *       CreateCdnKeyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCdnKey(CdnKey.newBuilder().build())
   *           .setCdnKeyId("cdnKeyId-1777782867")
   *           .build();
   *   ApiFuture<Operation> future =
   *       videoStitcherServiceClient.createCdnKeyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCdnKeyRequest, Operation> createCdnKeyCallable() {
    return stub.createCdnKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all CDN keys in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (CdnKey element : videoStitcherServiceClient.listCdnKeys(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project that contains the list of CDN keys, in the form of
   *     `projects/{project_number}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCdnKeysPagedResponse listCdnKeys(LocationName parent) {
    ListCdnKeysRequest request =
        ListCdnKeysRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCdnKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all CDN keys in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (CdnKey element : videoStitcherServiceClient.listCdnKeys(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project that contains the list of CDN keys, in the form of
   *     `projects/{project_number}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCdnKeysPagedResponse listCdnKeys(String parent) {
    ListCdnKeysRequest request = ListCdnKeysRequest.newBuilder().setParent(parent).build();
    return listCdnKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all CDN keys in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListCdnKeysRequest request =
   *       ListCdnKeysRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (CdnKey element : videoStitcherServiceClient.listCdnKeys(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCdnKeysPagedResponse listCdnKeys(ListCdnKeysRequest request) {
    return listCdnKeysPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all CDN keys in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListCdnKeysRequest request =
   *       ListCdnKeysRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<CdnKey> future =
   *       videoStitcherServiceClient.listCdnKeysPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CdnKey element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCdnKeysRequest, ListCdnKeysPagedResponse>
      listCdnKeysPagedCallable() {
    return stub.listCdnKeysPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all CDN keys in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListCdnKeysRequest request =
   *       ListCdnKeysRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListCdnKeysResponse response =
   *         videoStitcherServiceClient.listCdnKeysCallable().call(request);
   *     for (CdnKey element : response.getCdnKeysList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCdnKeysRequest, ListCdnKeysResponse> listCdnKeysCallable() {
    return stub.listCdnKeysCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified CDN key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   CdnKeyName name = CdnKeyName.of("[PROJECT]", "[LOCATION]", "[CDN_KEY]");
   *   CdnKey response = videoStitcherServiceClient.getCdnKey(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the CDN key to be retrieved, in the form of
   *     `projects/{project}/locations/{location}/cdnKeys/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CdnKey getCdnKey(CdnKeyName name) {
    GetCdnKeyRequest request =
        GetCdnKeyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCdnKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified CDN key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String name = CdnKeyName.of("[PROJECT]", "[LOCATION]", "[CDN_KEY]").toString();
   *   CdnKey response = videoStitcherServiceClient.getCdnKey(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the CDN key to be retrieved, in the form of
   *     `projects/{project}/locations/{location}/cdnKeys/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CdnKey getCdnKey(String name) {
    GetCdnKeyRequest request = GetCdnKeyRequest.newBuilder().setName(name).build();
    return getCdnKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified CDN key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   GetCdnKeyRequest request =
   *       GetCdnKeyRequest.newBuilder()
   *           .setName(CdnKeyName.of("[PROJECT]", "[LOCATION]", "[CDN_KEY]").toString())
   *           .build();
   *   CdnKey response = videoStitcherServiceClient.getCdnKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CdnKey getCdnKey(GetCdnKeyRequest request) {
    return getCdnKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified CDN key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   GetCdnKeyRequest request =
   *       GetCdnKeyRequest.newBuilder()
   *           .setName(CdnKeyName.of("[PROJECT]", "[LOCATION]", "[CDN_KEY]").toString())
   *           .build();
   *   ApiFuture<CdnKey> future = videoStitcherServiceClient.getCdnKeyCallable().futureCall(request);
   *   // Do something.
   *   CdnKey response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCdnKeyRequest, CdnKey> getCdnKeyCallable() {
    return stub.getCdnKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified CDN key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   CdnKeyName name = CdnKeyName.of("[PROJECT]", "[LOCATION]", "[CDN_KEY]");
   *   videoStitcherServiceClient.deleteCdnKeyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the CDN key to be deleted, in the form of
   *     `projects/{project_number}/locations/{location}/cdnKeys/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCdnKeyAsync(CdnKeyName name) {
    DeleteCdnKeyRequest request =
        DeleteCdnKeyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteCdnKeyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified CDN key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String name = CdnKeyName.of("[PROJECT]", "[LOCATION]", "[CDN_KEY]").toString();
   *   videoStitcherServiceClient.deleteCdnKeyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the CDN key to be deleted, in the form of
   *     `projects/{project_number}/locations/{location}/cdnKeys/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCdnKeyAsync(String name) {
    DeleteCdnKeyRequest request = DeleteCdnKeyRequest.newBuilder().setName(name).build();
    return deleteCdnKeyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified CDN key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   DeleteCdnKeyRequest request =
   *       DeleteCdnKeyRequest.newBuilder()
   *           .setName(CdnKeyName.of("[PROJECT]", "[LOCATION]", "[CDN_KEY]").toString())
   *           .build();
   *   videoStitcherServiceClient.deleteCdnKeyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCdnKeyAsync(
      DeleteCdnKeyRequest request) {
    return deleteCdnKeyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified CDN key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   DeleteCdnKeyRequest request =
   *       DeleteCdnKeyRequest.newBuilder()
   *           .setName(CdnKeyName.of("[PROJECT]", "[LOCATION]", "[CDN_KEY]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       videoStitcherServiceClient.deleteCdnKeyOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteCdnKeyRequest, Empty, OperationMetadata>
      deleteCdnKeyOperationCallable() {
    return stub.deleteCdnKeyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified CDN key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   DeleteCdnKeyRequest request =
   *       DeleteCdnKeyRequest.newBuilder()
   *           .setName(CdnKeyName.of("[PROJECT]", "[LOCATION]", "[CDN_KEY]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       videoStitcherServiceClient.deleteCdnKeyCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCdnKeyRequest, Operation> deleteCdnKeyCallable() {
    return stub.deleteCdnKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified CDN key. Only update fields specified in the call method body.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   CdnKey cdnKey = CdnKey.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   CdnKey response = videoStitcherServiceClient.updateCdnKeyAsync(cdnKey, updateMask).get();
   * }
   * }</pre>
   *
   * @param cdnKey Required. The CDN key resource which replaces the resource on the server.
   * @param updateMask Required. The update mask applies to the resource. For the `FieldMask`
   *     definition, see
   *     https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CdnKey, OperationMetadata> updateCdnKeyAsync(
      CdnKey cdnKey, FieldMask updateMask) {
    UpdateCdnKeyRequest request =
        UpdateCdnKeyRequest.newBuilder().setCdnKey(cdnKey).setUpdateMask(updateMask).build();
    return updateCdnKeyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified CDN key. Only update fields specified in the call method body.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   UpdateCdnKeyRequest request =
   *       UpdateCdnKeyRequest.newBuilder()
   *           .setCdnKey(CdnKey.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   CdnKey response = videoStitcherServiceClient.updateCdnKeyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CdnKey, OperationMetadata> updateCdnKeyAsync(
      UpdateCdnKeyRequest request) {
    return updateCdnKeyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified CDN key. Only update fields specified in the call method body.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   UpdateCdnKeyRequest request =
   *       UpdateCdnKeyRequest.newBuilder()
   *           .setCdnKey(CdnKey.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<CdnKey, OperationMetadata> future =
   *       videoStitcherServiceClient.updateCdnKeyOperationCallable().futureCall(request);
   *   // Do something.
   *   CdnKey response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateCdnKeyRequest, CdnKey, OperationMetadata>
      updateCdnKeyOperationCallable() {
    return stub.updateCdnKeyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified CDN key. Only update fields specified in the call method body.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   UpdateCdnKeyRequest request =
   *       UpdateCdnKeyRequest.newBuilder()
   *           .setCdnKey(CdnKey.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       videoStitcherServiceClient.updateCdnKeyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCdnKeyRequest, Operation> updateCdnKeyCallable() {
    return stub.updateCdnKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a client side playback VOD session and returns the full tracking and playback metadata
   * of the session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   VodSession vodSession = VodSession.newBuilder().build();
   *   VodSession response = videoStitcherServiceClient.createVodSession(parent, vodSession);
   * }
   * }</pre>
   *
   * @param parent Required. The project and location in which the VOD session should be created, in
   *     the form of `projects/{project_number}/locations/{location}`.
   * @param vodSession Required. Parameters for creating a session.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VodSession createVodSession(LocationName parent, VodSession vodSession) {
    CreateVodSessionRequest request =
        CreateVodSessionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setVodSession(vodSession)
            .build();
    return createVodSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a client side playback VOD session and returns the full tracking and playback metadata
   * of the session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   VodSession vodSession = VodSession.newBuilder().build();
   *   VodSession response = videoStitcherServiceClient.createVodSession(parent, vodSession);
   * }
   * }</pre>
   *
   * @param parent Required. The project and location in which the VOD session should be created, in
   *     the form of `projects/{project_number}/locations/{location}`.
   * @param vodSession Required. Parameters for creating a session.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VodSession createVodSession(String parent, VodSession vodSession) {
    CreateVodSessionRequest request =
        CreateVodSessionRequest.newBuilder().setParent(parent).setVodSession(vodSession).build();
    return createVodSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a client side playback VOD session and returns the full tracking and playback metadata
   * of the session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   CreateVodSessionRequest request =
   *       CreateVodSessionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setVodSession(VodSession.newBuilder().build())
   *           .build();
   *   VodSession response = videoStitcherServiceClient.createVodSession(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VodSession createVodSession(CreateVodSessionRequest request) {
    return createVodSessionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a client side playback VOD session and returns the full tracking and playback metadata
   * of the session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   CreateVodSessionRequest request =
   *       CreateVodSessionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setVodSession(VodSession.newBuilder().build())
   *           .build();
   *   ApiFuture<VodSession> future =
   *       videoStitcherServiceClient.createVodSessionCallable().futureCall(request);
   *   // Do something.
   *   VodSession response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateVodSessionRequest, VodSession> createVodSessionCallable() {
    return stub.createVodSessionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the full tracking, playback metadata, and relevant ad-ops logs for the specified VOD
   * session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   VodSessionName name = VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]");
   *   VodSession response = videoStitcherServiceClient.getVodSession(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the VOD session to be retrieved, in the form of
   *     `projects/{project_number}/locations/{location}/vodSessions/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VodSession getVodSession(VodSessionName name) {
    GetVodSessionRequest request =
        GetVodSessionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getVodSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the full tracking, playback metadata, and relevant ad-ops logs for the specified VOD
   * session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String name = VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]").toString();
   *   VodSession response = videoStitcherServiceClient.getVodSession(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the VOD session to be retrieved, in the form of
   *     `projects/{project_number}/locations/{location}/vodSessions/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VodSession getVodSession(String name) {
    GetVodSessionRequest request = GetVodSessionRequest.newBuilder().setName(name).build();
    return getVodSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the full tracking, playback metadata, and relevant ad-ops logs for the specified VOD
   * session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   GetVodSessionRequest request =
   *       GetVodSessionRequest.newBuilder()
   *           .setName(VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]").toString())
   *           .build();
   *   VodSession response = videoStitcherServiceClient.getVodSession(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VodSession getVodSession(GetVodSessionRequest request) {
    return getVodSessionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the full tracking, playback metadata, and relevant ad-ops logs for the specified VOD
   * session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   GetVodSessionRequest request =
   *       GetVodSessionRequest.newBuilder()
   *           .setName(VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]").toString())
   *           .build();
   *   ApiFuture<VodSession> future =
   *       videoStitcherServiceClient.getVodSessionCallable().futureCall(request);
   *   // Do something.
   *   VodSession response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetVodSessionRequest, VodSession> getVodSessionCallable() {
    return stub.getVodSessionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of detailed stitching information of the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   VodSessionName parent = VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]");
   *   for (VodStitchDetail element :
   *       videoStitcherServiceClient.listVodStitchDetails(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The VOD session where the stitch details belong to, in the form of
   *     `projects/{project}/locations/{location}/vodSessions/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVodStitchDetailsPagedResponse listVodStitchDetails(VodSessionName parent) {
    ListVodStitchDetailsRequest request =
        ListVodStitchDetailsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listVodStitchDetails(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of detailed stitching information of the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String parent = VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]").toString();
   *   for (VodStitchDetail element :
   *       videoStitcherServiceClient.listVodStitchDetails(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The VOD session where the stitch details belong to, in the form of
   *     `projects/{project}/locations/{location}/vodSessions/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVodStitchDetailsPagedResponse listVodStitchDetails(String parent) {
    ListVodStitchDetailsRequest request =
        ListVodStitchDetailsRequest.newBuilder().setParent(parent).build();
    return listVodStitchDetails(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of detailed stitching information of the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListVodStitchDetailsRequest request =
   *       ListVodStitchDetailsRequest.newBuilder()
   *           .setParent(VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (VodStitchDetail element :
   *       videoStitcherServiceClient.listVodStitchDetails(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVodStitchDetailsPagedResponse listVodStitchDetails(
      ListVodStitchDetailsRequest request) {
    return listVodStitchDetailsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of detailed stitching information of the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListVodStitchDetailsRequest request =
   *       ListVodStitchDetailsRequest.newBuilder()
   *           .setParent(VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<VodStitchDetail> future =
   *       videoStitcherServiceClient.listVodStitchDetailsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (VodStitchDetail element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListVodStitchDetailsRequest, ListVodStitchDetailsPagedResponse>
      listVodStitchDetailsPagedCallable() {
    return stub.listVodStitchDetailsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of detailed stitching information of the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListVodStitchDetailsRequest request =
   *       ListVodStitchDetailsRequest.newBuilder()
   *           .setParent(VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListVodStitchDetailsResponse response =
   *         videoStitcherServiceClient.listVodStitchDetailsCallable().call(request);
   *     for (VodStitchDetail element : response.getVodStitchDetailsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListVodStitchDetailsRequest, ListVodStitchDetailsResponse>
      listVodStitchDetailsCallable() {
    return stub.listVodStitchDetailsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified stitching information for the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   VodStitchDetailName name =
   *       VodStitchDetailName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]", "[VOD_STITCH_DETAIL]");
   *   VodStitchDetail response = videoStitcherServiceClient.getVodStitchDetail(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the stitch detail in the specified VOD session, in the form
   *     of
   *     `projects/{project}/locations/{location}/vodSessions/{vod_session_id}/vodStitchDetails/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VodStitchDetail getVodStitchDetail(VodStitchDetailName name) {
    GetVodStitchDetailRequest request =
        GetVodStitchDetailRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getVodStitchDetail(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified stitching information for the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String name =
   *       VodStitchDetailName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]", "[VOD_STITCH_DETAIL]")
   *           .toString();
   *   VodStitchDetail response = videoStitcherServiceClient.getVodStitchDetail(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the stitch detail in the specified VOD session, in the form
   *     of
   *     `projects/{project}/locations/{location}/vodSessions/{vod_session_id}/vodStitchDetails/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VodStitchDetail getVodStitchDetail(String name) {
    GetVodStitchDetailRequest request =
        GetVodStitchDetailRequest.newBuilder().setName(name).build();
    return getVodStitchDetail(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified stitching information for the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   GetVodStitchDetailRequest request =
   *       GetVodStitchDetailRequest.newBuilder()
   *           .setName(
   *               VodStitchDetailName.of(
   *                       "[PROJECT]", "[LOCATION]", "[VOD_SESSION]", "[VOD_STITCH_DETAIL]")
   *                   .toString())
   *           .build();
   *   VodStitchDetail response = videoStitcherServiceClient.getVodStitchDetail(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VodStitchDetail getVodStitchDetail(GetVodStitchDetailRequest request) {
    return getVodStitchDetailCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified stitching information for the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   GetVodStitchDetailRequest request =
   *       GetVodStitchDetailRequest.newBuilder()
   *           .setName(
   *               VodStitchDetailName.of(
   *                       "[PROJECT]", "[LOCATION]", "[VOD_SESSION]", "[VOD_STITCH_DETAIL]")
   *                   .toString())
   *           .build();
   *   ApiFuture<VodStitchDetail> future =
   *       videoStitcherServiceClient.getVodStitchDetailCallable().futureCall(request);
   *   // Do something.
   *   VodStitchDetail response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetVodStitchDetailRequest, VodStitchDetail>
      getVodStitchDetailCallable() {
    return stub.getVodStitchDetailCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Return the list of ad tag details for the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   VodSessionName parent = VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]");
   *   for (VodAdTagDetail element :
   *       videoStitcherServiceClient.listVodAdTagDetails(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The VOD session which the ad tag details belong to, in the form of
   *     `projects/{project}/locations/{location}/vodSessions/{vod_session_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVodAdTagDetailsPagedResponse listVodAdTagDetails(VodSessionName parent) {
    ListVodAdTagDetailsRequest request =
        ListVodAdTagDetailsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listVodAdTagDetails(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Return the list of ad tag details for the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String parent = VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]").toString();
   *   for (VodAdTagDetail element :
   *       videoStitcherServiceClient.listVodAdTagDetails(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The VOD session which the ad tag details belong to, in the form of
   *     `projects/{project}/locations/{location}/vodSessions/{vod_session_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVodAdTagDetailsPagedResponse listVodAdTagDetails(String parent) {
    ListVodAdTagDetailsRequest request =
        ListVodAdTagDetailsRequest.newBuilder().setParent(parent).build();
    return listVodAdTagDetails(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Return the list of ad tag details for the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListVodAdTagDetailsRequest request =
   *       ListVodAdTagDetailsRequest.newBuilder()
   *           .setParent(VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (VodAdTagDetail element :
   *       videoStitcherServiceClient.listVodAdTagDetails(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVodAdTagDetailsPagedResponse listVodAdTagDetails(
      ListVodAdTagDetailsRequest request) {
    return listVodAdTagDetailsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Return the list of ad tag details for the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListVodAdTagDetailsRequest request =
   *       ListVodAdTagDetailsRequest.newBuilder()
   *           .setParent(VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<VodAdTagDetail> future =
   *       videoStitcherServiceClient.listVodAdTagDetailsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (VodAdTagDetail element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListVodAdTagDetailsRequest, ListVodAdTagDetailsPagedResponse>
      listVodAdTagDetailsPagedCallable() {
    return stub.listVodAdTagDetailsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Return the list of ad tag details for the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListVodAdTagDetailsRequest request =
   *       ListVodAdTagDetailsRequest.newBuilder()
   *           .setParent(VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListVodAdTagDetailsResponse response =
   *         videoStitcherServiceClient.listVodAdTagDetailsCallable().call(request);
   *     for (VodAdTagDetail element : response.getVodAdTagDetailsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListVodAdTagDetailsRequest, ListVodAdTagDetailsResponse>
      listVodAdTagDetailsCallable() {
    return stub.listVodAdTagDetailsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified ad tag detail for the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   VodAdTagDetailName name =
   *       VodAdTagDetailName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]", "[VOD_AD_TAG_DETAIL]");
   *   VodAdTagDetail response = videoStitcherServiceClient.getVodAdTagDetail(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the ad tag detail for the specified VOD session, in the form
   *     of
   *     `projects/{project}/locations/{location}/vodSessions/{vod_session_id}/vodAdTagDetails/{vod_ad_tag_detail}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VodAdTagDetail getVodAdTagDetail(VodAdTagDetailName name) {
    GetVodAdTagDetailRequest request =
        GetVodAdTagDetailRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getVodAdTagDetail(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified ad tag detail for the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String name =
   *       VodAdTagDetailName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]", "[VOD_AD_TAG_DETAIL]")
   *           .toString();
   *   VodAdTagDetail response = videoStitcherServiceClient.getVodAdTagDetail(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the ad tag detail for the specified VOD session, in the form
   *     of
   *     `projects/{project}/locations/{location}/vodSessions/{vod_session_id}/vodAdTagDetails/{vod_ad_tag_detail}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VodAdTagDetail getVodAdTagDetail(String name) {
    GetVodAdTagDetailRequest request = GetVodAdTagDetailRequest.newBuilder().setName(name).build();
    return getVodAdTagDetail(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified ad tag detail for the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   GetVodAdTagDetailRequest request =
   *       GetVodAdTagDetailRequest.newBuilder()
   *           .setName(
   *               VodAdTagDetailName.of(
   *                       "[PROJECT]", "[LOCATION]", "[VOD_SESSION]", "[VOD_AD_TAG_DETAIL]")
   *                   .toString())
   *           .build();
   *   VodAdTagDetail response = videoStitcherServiceClient.getVodAdTagDetail(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VodAdTagDetail getVodAdTagDetail(GetVodAdTagDetailRequest request) {
    return getVodAdTagDetailCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified ad tag detail for the specified VOD session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   GetVodAdTagDetailRequest request =
   *       GetVodAdTagDetailRequest.newBuilder()
   *           .setName(
   *               VodAdTagDetailName.of(
   *                       "[PROJECT]", "[LOCATION]", "[VOD_SESSION]", "[VOD_AD_TAG_DETAIL]")
   *                   .toString())
   *           .build();
   *   ApiFuture<VodAdTagDetail> future =
   *       videoStitcherServiceClient.getVodAdTagDetailCallable().futureCall(request);
   *   // Do something.
   *   VodAdTagDetail response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetVodAdTagDetailRequest, VodAdTagDetail> getVodAdTagDetailCallable() {
    return stub.getVodAdTagDetailCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Return the list of ad tag details for the specified live session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   LiveSessionName parent = LiveSessionName.of("[PROJECT]", "[LOCATION]", "[LIVE_SESSION]");
   *   for (LiveAdTagDetail element :
   *       videoStitcherServiceClient.listLiveAdTagDetails(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource parent in the form of
   *     `projects/{project}/locations/{location}/liveSessions/{live_session}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLiveAdTagDetailsPagedResponse listLiveAdTagDetails(LiveSessionName parent) {
    ListLiveAdTagDetailsRequest request =
        ListLiveAdTagDetailsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listLiveAdTagDetails(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Return the list of ad tag details for the specified live session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String parent = LiveSessionName.of("[PROJECT]", "[LOCATION]", "[LIVE_SESSION]").toString();
   *   for (LiveAdTagDetail element :
   *       videoStitcherServiceClient.listLiveAdTagDetails(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource parent in the form of
   *     `projects/{project}/locations/{location}/liveSessions/{live_session}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLiveAdTagDetailsPagedResponse listLiveAdTagDetails(String parent) {
    ListLiveAdTagDetailsRequest request =
        ListLiveAdTagDetailsRequest.newBuilder().setParent(parent).build();
    return listLiveAdTagDetails(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Return the list of ad tag details for the specified live session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListLiveAdTagDetailsRequest request =
   *       ListLiveAdTagDetailsRequest.newBuilder()
   *           .setParent(LiveSessionName.of("[PROJECT]", "[LOCATION]", "[LIVE_SESSION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (LiveAdTagDetail element :
   *       videoStitcherServiceClient.listLiveAdTagDetails(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLiveAdTagDetailsPagedResponse listLiveAdTagDetails(
      ListLiveAdTagDetailsRequest request) {
    return listLiveAdTagDetailsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Return the list of ad tag details for the specified live session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListLiveAdTagDetailsRequest request =
   *       ListLiveAdTagDetailsRequest.newBuilder()
   *           .setParent(LiveSessionName.of("[PROJECT]", "[LOCATION]", "[LIVE_SESSION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<LiveAdTagDetail> future =
   *       videoStitcherServiceClient.listLiveAdTagDetailsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (LiveAdTagDetail element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLiveAdTagDetailsRequest, ListLiveAdTagDetailsPagedResponse>
      listLiveAdTagDetailsPagedCallable() {
    return stub.listLiveAdTagDetailsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Return the list of ad tag details for the specified live session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListLiveAdTagDetailsRequest request =
   *       ListLiveAdTagDetailsRequest.newBuilder()
   *           .setParent(LiveSessionName.of("[PROJECT]", "[LOCATION]", "[LIVE_SESSION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLiveAdTagDetailsResponse response =
   *         videoStitcherServiceClient.listLiveAdTagDetailsCallable().call(request);
   *     for (LiveAdTagDetail element : response.getLiveAdTagDetailsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLiveAdTagDetailsRequest, ListLiveAdTagDetailsResponse>
      listLiveAdTagDetailsCallable() {
    return stub.listLiveAdTagDetailsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified ad tag detail for the specified live session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   LiveAdTagDetailName name =
   *       LiveAdTagDetailName.of(
   *           "[PROJECT]", "[LOCATION]", "[LIVE_SESSION]", "[LIVE_AD_TAG_DETAIL]");
   *   LiveAdTagDetail response = videoStitcherServiceClient.getLiveAdTagDetail(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name in the form of
   *     `projects/{project}/locations/{location}/liveSessions/{live_session}/liveAdTagDetails/{live_ad_tag_detail}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LiveAdTagDetail getLiveAdTagDetail(LiveAdTagDetailName name) {
    GetLiveAdTagDetailRequest request =
        GetLiveAdTagDetailRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getLiveAdTagDetail(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified ad tag detail for the specified live session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String name =
   *       LiveAdTagDetailName.of(
   *               "[PROJECT]", "[LOCATION]", "[LIVE_SESSION]", "[LIVE_AD_TAG_DETAIL]")
   *           .toString();
   *   LiveAdTagDetail response = videoStitcherServiceClient.getLiveAdTagDetail(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name in the form of
   *     `projects/{project}/locations/{location}/liveSessions/{live_session}/liveAdTagDetails/{live_ad_tag_detail}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LiveAdTagDetail getLiveAdTagDetail(String name) {
    GetLiveAdTagDetailRequest request =
        GetLiveAdTagDetailRequest.newBuilder().setName(name).build();
    return getLiveAdTagDetail(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified ad tag detail for the specified live session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   GetLiveAdTagDetailRequest request =
   *       GetLiveAdTagDetailRequest.newBuilder()
   *           .setName(
   *               LiveAdTagDetailName.of(
   *                       "[PROJECT]", "[LOCATION]", "[LIVE_SESSION]", "[LIVE_AD_TAG_DETAIL]")
   *                   .toString())
   *           .build();
   *   LiveAdTagDetail response = videoStitcherServiceClient.getLiveAdTagDetail(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LiveAdTagDetail getLiveAdTagDetail(GetLiveAdTagDetailRequest request) {
    return getLiveAdTagDetailCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified ad tag detail for the specified live session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   GetLiveAdTagDetailRequest request =
   *       GetLiveAdTagDetailRequest.newBuilder()
   *           .setName(
   *               LiveAdTagDetailName.of(
   *                       "[PROJECT]", "[LOCATION]", "[LIVE_SESSION]", "[LIVE_AD_TAG_DETAIL]")
   *                   .toString())
   *           .build();
   *   ApiFuture<LiveAdTagDetail> future =
   *       videoStitcherServiceClient.getLiveAdTagDetailCallable().futureCall(request);
   *   // Do something.
   *   LiveAdTagDetail response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLiveAdTagDetailRequest, LiveAdTagDetail>
      getLiveAdTagDetailCallable() {
    return stub.getLiveAdTagDetailCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a slate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Slate slate = Slate.newBuilder().build();
   *   String slateId = "slateId-2126174060";
   *   Slate response = videoStitcherServiceClient.createSlateAsync(parent, slate, slateId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project in which the slate should be created, in the form of
   *     `projects/{project_number}/locations/{location}`.
   * @param slate Required. The slate to create.
   * @param slateId Required. The unique identifier for the slate. This value should conform to
   *     RFC-1034, which restricts to lower-case letters, numbers, and hyphen, with the first
   *     character a letter, the last a letter or a number, and a 63 character maximum.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Slate, OperationMetadata> createSlateAsync(
      LocationName parent, Slate slate, String slateId) {
    CreateSlateRequest request =
        CreateSlateRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSlate(slate)
            .setSlateId(slateId)
            .build();
    return createSlateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a slate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Slate slate = Slate.newBuilder().build();
   *   String slateId = "slateId-2126174060";
   *   Slate response = videoStitcherServiceClient.createSlateAsync(parent, slate, slateId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project in which the slate should be created, in the form of
   *     `projects/{project_number}/locations/{location}`.
   * @param slate Required. The slate to create.
   * @param slateId Required. The unique identifier for the slate. This value should conform to
   *     RFC-1034, which restricts to lower-case letters, numbers, and hyphen, with the first
   *     character a letter, the last a letter or a number, and a 63 character maximum.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Slate, OperationMetadata> createSlateAsync(
      String parent, Slate slate, String slateId) {
    CreateSlateRequest request =
        CreateSlateRequest.newBuilder()
            .setParent(parent)
            .setSlate(slate)
            .setSlateId(slateId)
            .build();
    return createSlateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a slate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   CreateSlateRequest request =
   *       CreateSlateRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSlateId("slateId-2126174060")
   *           .setSlate(Slate.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Slate response = videoStitcherServiceClient.createSlateAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Slate, OperationMetadata> createSlateAsync(
      CreateSlateRequest request) {
    return createSlateOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a slate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   CreateSlateRequest request =
   *       CreateSlateRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSlateId("slateId-2126174060")
   *           .setSlate(Slate.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Slate, OperationMetadata> future =
   *       videoStitcherServiceClient.createSlateOperationCallable().futureCall(request);
   *   // Do something.
   *   Slate response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateSlateRequest, Slate, OperationMetadata>
      createSlateOperationCallable() {
    return stub.createSlateOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a slate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   CreateSlateRequest request =
   *       CreateSlateRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSlateId("slateId-2126174060")
   *           .setSlate(Slate.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       videoStitcherServiceClient.createSlateCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSlateRequest, Operation> createSlateCallable() {
    return stub.createSlateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all slates in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Slate element : videoStitcherServiceClient.listSlates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project to list slates, in the form of
   *     `projects/{project_number}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSlatesPagedResponse listSlates(LocationName parent) {
    ListSlatesRequest request =
        ListSlatesRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listSlates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all slates in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Slate element : videoStitcherServiceClient.listSlates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project to list slates, in the form of
   *     `projects/{project_number}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSlatesPagedResponse listSlates(String parent) {
    ListSlatesRequest request = ListSlatesRequest.newBuilder().setParent(parent).build();
    return listSlates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all slates in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListSlatesRequest request =
   *       ListSlatesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Slate element : videoStitcherServiceClient.listSlates(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSlatesPagedResponse listSlates(ListSlatesRequest request) {
    return listSlatesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all slates in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListSlatesRequest request =
   *       ListSlatesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Slate> future =
   *       videoStitcherServiceClient.listSlatesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Slate element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSlatesRequest, ListSlatesPagedResponse> listSlatesPagedCallable() {
    return stub.listSlatesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all slates in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListSlatesRequest request =
   *       ListSlatesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListSlatesResponse response = videoStitcherServiceClient.listSlatesCallable().call(request);
   *     for (Slate element : response.getSlatesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSlatesRequest, ListSlatesResponse> listSlatesCallable() {
    return stub.listSlatesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified slate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   SlateName name = SlateName.of("[PROJECT]", "[LOCATION]", "[SLATE]");
   *   Slate response = videoStitcherServiceClient.getSlate(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the slate to be retrieved, of the slate, in the form of
   *     `projects/{project_number}/locations/{location}/slates/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Slate getSlate(SlateName name) {
    GetSlateRequest request =
        GetSlateRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSlate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified slate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String name = SlateName.of("[PROJECT]", "[LOCATION]", "[SLATE]").toString();
   *   Slate response = videoStitcherServiceClient.getSlate(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the slate to be retrieved, of the slate, in the form of
   *     `projects/{project_number}/locations/{location}/slates/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Slate getSlate(String name) {
    GetSlateRequest request = GetSlateRequest.newBuilder().setName(name).build();
    return getSlate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified slate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   GetSlateRequest request =
   *       GetSlateRequest.newBuilder()
   *           .setName(SlateName.of("[PROJECT]", "[LOCATION]", "[SLATE]").toString())
   *           .build();
   *   Slate response = videoStitcherServiceClient.getSlate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Slate getSlate(GetSlateRequest request) {
    return getSlateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified slate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   GetSlateRequest request =
   *       GetSlateRequest.newBuilder()
   *           .setName(SlateName.of("[PROJECT]", "[LOCATION]", "[SLATE]").toString())
   *           .build();
   *   ApiFuture<Slate> future = videoStitcherServiceClient.getSlateCallable().futureCall(request);
   *   // Do something.
   *   Slate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSlateRequest, Slate> getSlateCallable() {
    return stub.getSlateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified slate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   Slate slate = Slate.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Slate response = videoStitcherServiceClient.updateSlateAsync(slate, updateMask).get();
   * }
   * }</pre>
   *
   * @param slate Required. The resource with updated fields.
   * @param updateMask Required. The update mask which specifies fields which should be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Slate, OperationMetadata> updateSlateAsync(
      Slate slate, FieldMask updateMask) {
    UpdateSlateRequest request =
        UpdateSlateRequest.newBuilder().setSlate(slate).setUpdateMask(updateMask).build();
    return updateSlateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified slate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   UpdateSlateRequest request =
   *       UpdateSlateRequest.newBuilder()
   *           .setSlate(Slate.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Slate response = videoStitcherServiceClient.updateSlateAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Slate, OperationMetadata> updateSlateAsync(
      UpdateSlateRequest request) {
    return updateSlateOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified slate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   UpdateSlateRequest request =
   *       UpdateSlateRequest.newBuilder()
   *           .setSlate(Slate.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Slate, OperationMetadata> future =
   *       videoStitcherServiceClient.updateSlateOperationCallable().futureCall(request);
   *   // Do something.
   *   Slate response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateSlateRequest, Slate, OperationMetadata>
      updateSlateOperationCallable() {
    return stub.updateSlateOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified slate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   UpdateSlateRequest request =
   *       UpdateSlateRequest.newBuilder()
   *           .setSlate(Slate.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       videoStitcherServiceClient.updateSlateCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSlateRequest, Operation> updateSlateCallable() {
    return stub.updateSlateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified slate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   SlateName name = SlateName.of("[PROJECT]", "[LOCATION]", "[SLATE]");
   *   videoStitcherServiceClient.deleteSlateAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the slate to be deleted, in the form of
   *     `projects/{project_number}/locations/{location}/slates/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSlateAsync(SlateName name) {
    DeleteSlateRequest request =
        DeleteSlateRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteSlateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified slate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String name = SlateName.of("[PROJECT]", "[LOCATION]", "[SLATE]").toString();
   *   videoStitcherServiceClient.deleteSlateAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the slate to be deleted, in the form of
   *     `projects/{project_number}/locations/{location}/slates/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSlateAsync(String name) {
    DeleteSlateRequest request = DeleteSlateRequest.newBuilder().setName(name).build();
    return deleteSlateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified slate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   DeleteSlateRequest request =
   *       DeleteSlateRequest.newBuilder()
   *           .setName(SlateName.of("[PROJECT]", "[LOCATION]", "[SLATE]").toString())
   *           .build();
   *   videoStitcherServiceClient.deleteSlateAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSlateAsync(
      DeleteSlateRequest request) {
    return deleteSlateOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified slate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   DeleteSlateRequest request =
   *       DeleteSlateRequest.newBuilder()
   *           .setName(SlateName.of("[PROJECT]", "[LOCATION]", "[SLATE]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       videoStitcherServiceClient.deleteSlateOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteSlateRequest, Empty, OperationMetadata>
      deleteSlateOperationCallable() {
    return stub.deleteSlateOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified slate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   DeleteSlateRequest request =
   *       DeleteSlateRequest.newBuilder()
   *           .setName(SlateName.of("[PROJECT]", "[LOCATION]", "[SLATE]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       videoStitcherServiceClient.deleteSlateCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSlateRequest, Operation> deleteSlateCallable() {
    return stub.deleteSlateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new live session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   LiveSession liveSession = LiveSession.newBuilder().build();
   *   LiveSession response = videoStitcherServiceClient.createLiveSession(parent, liveSession);
   * }
   * }</pre>
   *
   * @param parent Required. The project and location in which the live session should be created,
   *     in the form of `projects/{project_number}/locations/{location}`.
   * @param liveSession Required. Parameters for creating a live session.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LiveSession createLiveSession(LocationName parent, LiveSession liveSession) {
    CreateLiveSessionRequest request =
        CreateLiveSessionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setLiveSession(liveSession)
            .build();
    return createLiveSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new live session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   LiveSession liveSession = LiveSession.newBuilder().build();
   *   LiveSession response = videoStitcherServiceClient.createLiveSession(parent, liveSession);
   * }
   * }</pre>
   *
   * @param parent Required. The project and location in which the live session should be created,
   *     in the form of `projects/{project_number}/locations/{location}`.
   * @param liveSession Required. Parameters for creating a live session.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LiveSession createLiveSession(String parent, LiveSession liveSession) {
    CreateLiveSessionRequest request =
        CreateLiveSessionRequest.newBuilder().setParent(parent).setLiveSession(liveSession).build();
    return createLiveSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new live session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   CreateLiveSessionRequest request =
   *       CreateLiveSessionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setLiveSession(LiveSession.newBuilder().build())
   *           .build();
   *   LiveSession response = videoStitcherServiceClient.createLiveSession(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LiveSession createLiveSession(CreateLiveSessionRequest request) {
    return createLiveSessionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new live session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   CreateLiveSessionRequest request =
   *       CreateLiveSessionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setLiveSession(LiveSession.newBuilder().build())
   *           .build();
   *   ApiFuture<LiveSession> future =
   *       videoStitcherServiceClient.createLiveSessionCallable().futureCall(request);
   *   // Do something.
   *   LiveSession response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateLiveSessionRequest, LiveSession> createLiveSessionCallable() {
    return stub.createLiveSessionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details for the specified live session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   LiveSessionName name = LiveSessionName.of("[PROJECT]", "[LOCATION]", "[LIVE_SESSION]");
   *   LiveSession response = videoStitcherServiceClient.getLiveSession(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the live session, in the form of
   *     `projects/{project_number}/locations/{location}/liveSessions/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LiveSession getLiveSession(LiveSessionName name) {
    GetLiveSessionRequest request =
        GetLiveSessionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getLiveSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details for the specified live session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String name = LiveSessionName.of("[PROJECT]", "[LOCATION]", "[LIVE_SESSION]").toString();
   *   LiveSession response = videoStitcherServiceClient.getLiveSession(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the live session, in the form of
   *     `projects/{project_number}/locations/{location}/liveSessions/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LiveSession getLiveSession(String name) {
    GetLiveSessionRequest request = GetLiveSessionRequest.newBuilder().setName(name).build();
    return getLiveSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details for the specified live session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   GetLiveSessionRequest request =
   *       GetLiveSessionRequest.newBuilder()
   *           .setName(LiveSessionName.of("[PROJECT]", "[LOCATION]", "[LIVE_SESSION]").toString())
   *           .build();
   *   LiveSession response = videoStitcherServiceClient.getLiveSession(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LiveSession getLiveSession(GetLiveSessionRequest request) {
    return getLiveSessionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details for the specified live session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   GetLiveSessionRequest request =
   *       GetLiveSessionRequest.newBuilder()
   *           .setName(LiveSessionName.of("[PROJECT]", "[LOCATION]", "[LIVE_SESSION]").toString())
   *           .build();
   *   ApiFuture<LiveSession> future =
   *       videoStitcherServiceClient.getLiveSessionCallable().futureCall(request);
   *   // Do something.
   *   LiveSession response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLiveSessionRequest, LiveSession> getLiveSessionCallable() {
    return stub.getLiveSessionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers the live config with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   LiveConfig liveConfig = LiveConfig.newBuilder().build();
   *   String liveConfigId = "liveConfigId1256140041";
   *   LiveConfig response =
   *       videoStitcherServiceClient.createLiveConfigAsync(parent, liveConfig, liveConfigId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project in which the live config should be created, in the form of
   *     `projects/{project_number}/locations/{location}`.
   * @param liveConfig Required. The live config resource to create.
   * @param liveConfigId Required. The unique identifier ID to use for the live config.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<LiveConfig, OperationMetadata> createLiveConfigAsync(
      LocationName parent, LiveConfig liveConfig, String liveConfigId) {
    CreateLiveConfigRequest request =
        CreateLiveConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setLiveConfig(liveConfig)
            .setLiveConfigId(liveConfigId)
            .build();
    return createLiveConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers the live config with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   LiveConfig liveConfig = LiveConfig.newBuilder().build();
   *   String liveConfigId = "liveConfigId1256140041";
   *   LiveConfig response =
   *       videoStitcherServiceClient.createLiveConfigAsync(parent, liveConfig, liveConfigId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project in which the live config should be created, in the form of
   *     `projects/{project_number}/locations/{location}`.
   * @param liveConfig Required. The live config resource to create.
   * @param liveConfigId Required. The unique identifier ID to use for the live config.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<LiveConfig, OperationMetadata> createLiveConfigAsync(
      String parent, LiveConfig liveConfig, String liveConfigId) {
    CreateLiveConfigRequest request =
        CreateLiveConfigRequest.newBuilder()
            .setParent(parent)
            .setLiveConfig(liveConfig)
            .setLiveConfigId(liveConfigId)
            .build();
    return createLiveConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers the live config with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   CreateLiveConfigRequest request =
   *       CreateLiveConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setLiveConfigId("liveConfigId1256140041")
   *           .setLiveConfig(LiveConfig.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   LiveConfig response = videoStitcherServiceClient.createLiveConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<LiveConfig, OperationMetadata> createLiveConfigAsync(
      CreateLiveConfigRequest request) {
    return createLiveConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers the live config with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   CreateLiveConfigRequest request =
   *       CreateLiveConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setLiveConfigId("liveConfigId1256140041")
   *           .setLiveConfig(LiveConfig.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<LiveConfig, OperationMetadata> future =
   *       videoStitcherServiceClient.createLiveConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   LiveConfig response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateLiveConfigRequest, LiveConfig, OperationMetadata>
      createLiveConfigOperationCallable() {
    return stub.createLiveConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers the live config with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   CreateLiveConfigRequest request =
   *       CreateLiveConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setLiveConfigId("liveConfigId1256140041")
   *           .setLiveConfig(LiveConfig.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       videoStitcherServiceClient.createLiveConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateLiveConfigRequest, Operation> createLiveConfigCallable() {
    return stub.createLiveConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all live configs managed by the Video Stitcher that belong to the specified project and
   * region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (LiveConfig element : videoStitcherServiceClient.listLiveConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project that contains the list of live configs, in the form of
   *     `projects/{project_number}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLiveConfigsPagedResponse listLiveConfigs(LocationName parent) {
    ListLiveConfigsRequest request =
        ListLiveConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listLiveConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all live configs managed by the Video Stitcher that belong to the specified project and
   * region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (LiveConfig element : videoStitcherServiceClient.listLiveConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project that contains the list of live configs, in the form of
   *     `projects/{project_number}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLiveConfigsPagedResponse listLiveConfigs(String parent) {
    ListLiveConfigsRequest request = ListLiveConfigsRequest.newBuilder().setParent(parent).build();
    return listLiveConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all live configs managed by the Video Stitcher that belong to the specified project and
   * region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListLiveConfigsRequest request =
   *       ListLiveConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (LiveConfig element : videoStitcherServiceClient.listLiveConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLiveConfigsPagedResponse listLiveConfigs(ListLiveConfigsRequest request) {
    return listLiveConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all live configs managed by the Video Stitcher that belong to the specified project and
   * region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListLiveConfigsRequest request =
   *       ListLiveConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<LiveConfig> future =
   *       videoStitcherServiceClient.listLiveConfigsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (LiveConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLiveConfigsRequest, ListLiveConfigsPagedResponse>
      listLiveConfigsPagedCallable() {
    return stub.listLiveConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all live configs managed by the Video Stitcher that belong to the specified project and
   * region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListLiveConfigsRequest request =
   *       ListLiveConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListLiveConfigsResponse response =
   *         videoStitcherServiceClient.listLiveConfigsCallable().call(request);
   *     for (LiveConfig element : response.getLiveConfigsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLiveConfigsRequest, ListLiveConfigsResponse>
      listLiveConfigsCallable() {
    return stub.listLiveConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified live config managed by the Video Stitcher service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   LiveConfigName name = LiveConfigName.of("[PROJECT]", "[LOCATION]", "[LIVE_CONFIG]");
   *   LiveConfig response = videoStitcherServiceClient.getLiveConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the live config to be retrieved, in the form of
   *     `projects/{project_number}/locations/{location}/liveConfigs/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LiveConfig getLiveConfig(LiveConfigName name) {
    GetLiveConfigRequest request =
        GetLiveConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getLiveConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified live config managed by the Video Stitcher service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String name = LiveConfigName.of("[PROJECT]", "[LOCATION]", "[LIVE_CONFIG]").toString();
   *   LiveConfig response = videoStitcherServiceClient.getLiveConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the live config to be retrieved, in the form of
   *     `projects/{project_number}/locations/{location}/liveConfigs/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LiveConfig getLiveConfig(String name) {
    GetLiveConfigRequest request = GetLiveConfigRequest.newBuilder().setName(name).build();
    return getLiveConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified live config managed by the Video Stitcher service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   GetLiveConfigRequest request =
   *       GetLiveConfigRequest.newBuilder()
   *           .setName(LiveConfigName.of("[PROJECT]", "[LOCATION]", "[LIVE_CONFIG]").toString())
   *           .build();
   *   LiveConfig response = videoStitcherServiceClient.getLiveConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LiveConfig getLiveConfig(GetLiveConfigRequest request) {
    return getLiveConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified live config managed by the Video Stitcher service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   GetLiveConfigRequest request =
   *       GetLiveConfigRequest.newBuilder()
   *           .setName(LiveConfigName.of("[PROJECT]", "[LOCATION]", "[LIVE_CONFIG]").toString())
   *           .build();
   *   ApiFuture<LiveConfig> future =
   *       videoStitcherServiceClient.getLiveConfigCallable().futureCall(request);
   *   // Do something.
   *   LiveConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLiveConfigRequest, LiveConfig> getLiveConfigCallable() {
    return stub.getLiveConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified live config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   LiveConfigName name = LiveConfigName.of("[PROJECT]", "[LOCATION]", "[LIVE_CONFIG]");
   *   videoStitcherServiceClient.deleteLiveConfigAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the live config to be deleted, in the form of
   *     `projects/{project_number}/locations/{location}/liveConfigs/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteLiveConfigAsync(
      LiveConfigName name) {
    DeleteLiveConfigRequest request =
        DeleteLiveConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteLiveConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified live config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String name = LiveConfigName.of("[PROJECT]", "[LOCATION]", "[LIVE_CONFIG]").toString();
   *   videoStitcherServiceClient.deleteLiveConfigAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the live config to be deleted, in the form of
   *     `projects/{project_number}/locations/{location}/liveConfigs/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteLiveConfigAsync(String name) {
    DeleteLiveConfigRequest request = DeleteLiveConfigRequest.newBuilder().setName(name).build();
    return deleteLiveConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified live config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   DeleteLiveConfigRequest request =
   *       DeleteLiveConfigRequest.newBuilder()
   *           .setName(LiveConfigName.of("[PROJECT]", "[LOCATION]", "[LIVE_CONFIG]").toString())
   *           .build();
   *   videoStitcherServiceClient.deleteLiveConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteLiveConfigAsync(
      DeleteLiveConfigRequest request) {
    return deleteLiveConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified live config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   DeleteLiveConfigRequest request =
   *       DeleteLiveConfigRequest.newBuilder()
   *           .setName(LiveConfigName.of("[PROJECT]", "[LOCATION]", "[LIVE_CONFIG]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       videoStitcherServiceClient.deleteLiveConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteLiveConfigRequest, Empty, OperationMetadata>
      deleteLiveConfigOperationCallable() {
    return stub.deleteLiveConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified live config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   DeleteLiveConfigRequest request =
   *       DeleteLiveConfigRequest.newBuilder()
   *           .setName(LiveConfigName.of("[PROJECT]", "[LOCATION]", "[LIVE_CONFIG]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       videoStitcherServiceClient.deleteLiveConfigCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteLiveConfigRequest, Operation> deleteLiveConfigCallable() {
    return stub.deleteLiveConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified LiveConfig. Only update fields specified in the call method body.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   LiveConfig liveConfig = LiveConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   LiveConfig response =
   *       videoStitcherServiceClient.updateLiveConfigAsync(liveConfig, updateMask).get();
   * }
   * }</pre>
   *
   * @param liveConfig Required. The LiveConfig resource which replaces the resource on the server.
   * @param updateMask Required. The update mask applies to the resource. For the `FieldMask`
   *     definition, see
   *     https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<LiveConfig, OperationMetadata> updateLiveConfigAsync(
      LiveConfig liveConfig, FieldMask updateMask) {
    UpdateLiveConfigRequest request =
        UpdateLiveConfigRequest.newBuilder()
            .setLiveConfig(liveConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateLiveConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified LiveConfig. Only update fields specified in the call method body.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   UpdateLiveConfigRequest request =
   *       UpdateLiveConfigRequest.newBuilder()
   *           .setLiveConfig(LiveConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   LiveConfig response = videoStitcherServiceClient.updateLiveConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<LiveConfig, OperationMetadata> updateLiveConfigAsync(
      UpdateLiveConfigRequest request) {
    return updateLiveConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified LiveConfig. Only update fields specified in the call method body.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   UpdateLiveConfigRequest request =
   *       UpdateLiveConfigRequest.newBuilder()
   *           .setLiveConfig(LiveConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<LiveConfig, OperationMetadata> future =
   *       videoStitcherServiceClient.updateLiveConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   LiveConfig response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateLiveConfigRequest, LiveConfig, OperationMetadata>
      updateLiveConfigOperationCallable() {
    return stub.updateLiveConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified LiveConfig. Only update fields specified in the call method body.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   UpdateLiveConfigRequest request =
   *       UpdateLiveConfigRequest.newBuilder()
   *           .setLiveConfig(LiveConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       videoStitcherServiceClient.updateLiveConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateLiveConfigRequest, Operation> updateLiveConfigCallable() {
    return stub.updateLiveConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers the VOD config with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   VodConfig vodConfig = VodConfig.newBuilder().build();
   *   String vodConfigId = "vodConfigId1497626088";
   *   VodConfig response =
   *       videoStitcherServiceClient.createVodConfigAsync(parent, vodConfig, vodConfigId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project in which the VOD config should be created, in the form of
   *     `projects/{project_number}/locations/{location}`.
   * @param vodConfig Required. The VOD config resource to create.
   * @param vodConfigId Required. The unique identifier ID to use for the VOD config.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<VodConfig, OperationMetadata> createVodConfigAsync(
      LocationName parent, VodConfig vodConfig, String vodConfigId) {
    CreateVodConfigRequest request =
        CreateVodConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setVodConfig(vodConfig)
            .setVodConfigId(vodConfigId)
            .build();
    return createVodConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers the VOD config with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   VodConfig vodConfig = VodConfig.newBuilder().build();
   *   String vodConfigId = "vodConfigId1497626088";
   *   VodConfig response =
   *       videoStitcherServiceClient.createVodConfigAsync(parent, vodConfig, vodConfigId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project in which the VOD config should be created, in the form of
   *     `projects/{project_number}/locations/{location}`.
   * @param vodConfig Required. The VOD config resource to create.
   * @param vodConfigId Required. The unique identifier ID to use for the VOD config.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<VodConfig, OperationMetadata> createVodConfigAsync(
      String parent, VodConfig vodConfig, String vodConfigId) {
    CreateVodConfigRequest request =
        CreateVodConfigRequest.newBuilder()
            .setParent(parent)
            .setVodConfig(vodConfig)
            .setVodConfigId(vodConfigId)
            .build();
    return createVodConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers the VOD config with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   CreateVodConfigRequest request =
   *       CreateVodConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setVodConfigId("vodConfigId1497626088")
   *           .setVodConfig(VodConfig.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   VodConfig response = videoStitcherServiceClient.createVodConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<VodConfig, OperationMetadata> createVodConfigAsync(
      CreateVodConfigRequest request) {
    return createVodConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers the VOD config with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   CreateVodConfigRequest request =
   *       CreateVodConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setVodConfigId("vodConfigId1497626088")
   *           .setVodConfig(VodConfig.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<VodConfig, OperationMetadata> future =
   *       videoStitcherServiceClient.createVodConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   VodConfig response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateVodConfigRequest, VodConfig, OperationMetadata>
      createVodConfigOperationCallable() {
    return stub.createVodConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers the VOD config with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   CreateVodConfigRequest request =
   *       CreateVodConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setVodConfigId("vodConfigId1497626088")
   *           .setVodConfig(VodConfig.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       videoStitcherServiceClient.createVodConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateVodConfigRequest, Operation> createVodConfigCallable() {
    return stub.createVodConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all VOD configs managed by the Video Stitcher API that belong to the specified project
   * and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (VodConfig element : videoStitcherServiceClient.listVodConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project that contains the list of VOD configs, in the form of
   *     `projects/{project_number}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVodConfigsPagedResponse listVodConfigs(LocationName parent) {
    ListVodConfigsRequest request =
        ListVodConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listVodConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all VOD configs managed by the Video Stitcher API that belong to the specified project
   * and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (VodConfig element : videoStitcherServiceClient.listVodConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project that contains the list of VOD configs, in the form of
   *     `projects/{project_number}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVodConfigsPagedResponse listVodConfigs(String parent) {
    ListVodConfigsRequest request = ListVodConfigsRequest.newBuilder().setParent(parent).build();
    return listVodConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all VOD configs managed by the Video Stitcher API that belong to the specified project
   * and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListVodConfigsRequest request =
   *       ListVodConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (VodConfig element : videoStitcherServiceClient.listVodConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVodConfigsPagedResponse listVodConfigs(ListVodConfigsRequest request) {
    return listVodConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all VOD configs managed by the Video Stitcher API that belong to the specified project
   * and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListVodConfigsRequest request =
   *       ListVodConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<VodConfig> future =
   *       videoStitcherServiceClient.listVodConfigsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (VodConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListVodConfigsRequest, ListVodConfigsPagedResponse>
      listVodConfigsPagedCallable() {
    return stub.listVodConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all VOD configs managed by the Video Stitcher API that belong to the specified project
   * and region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   ListVodConfigsRequest request =
   *       ListVodConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListVodConfigsResponse response =
   *         videoStitcherServiceClient.listVodConfigsCallable().call(request);
   *     for (VodConfig element : response.getVodConfigsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListVodConfigsRequest, ListVodConfigsResponse>
      listVodConfigsCallable() {
    return stub.listVodConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified VOD config managed by the Video Stitcher API service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   VodConfigName name = VodConfigName.of("[PROJECT]", "[LOCATION]", "[VOD_CONFIG]");
   *   VodConfig response = videoStitcherServiceClient.getVodConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the VOD config to be retrieved, in the form of
   *     `projects/{project_number}/locations/{location}/vodConfigs/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VodConfig getVodConfig(VodConfigName name) {
    GetVodConfigRequest request =
        GetVodConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getVodConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified VOD config managed by the Video Stitcher API service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String name = VodConfigName.of("[PROJECT]", "[LOCATION]", "[VOD_CONFIG]").toString();
   *   VodConfig response = videoStitcherServiceClient.getVodConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the VOD config to be retrieved, in the form of
   *     `projects/{project_number}/locations/{location}/vodConfigs/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VodConfig getVodConfig(String name) {
    GetVodConfigRequest request = GetVodConfigRequest.newBuilder().setName(name).build();
    return getVodConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified VOD config managed by the Video Stitcher API service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   GetVodConfigRequest request =
   *       GetVodConfigRequest.newBuilder()
   *           .setName(VodConfigName.of("[PROJECT]", "[LOCATION]", "[VOD_CONFIG]").toString())
   *           .build();
   *   VodConfig response = videoStitcherServiceClient.getVodConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VodConfig getVodConfig(GetVodConfigRequest request) {
    return getVodConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified VOD config managed by the Video Stitcher API service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   GetVodConfigRequest request =
   *       GetVodConfigRequest.newBuilder()
   *           .setName(VodConfigName.of("[PROJECT]", "[LOCATION]", "[VOD_CONFIG]").toString())
   *           .build();
   *   ApiFuture<VodConfig> future =
   *       videoStitcherServiceClient.getVodConfigCallable().futureCall(request);
   *   // Do something.
   *   VodConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetVodConfigRequest, VodConfig> getVodConfigCallable() {
    return stub.getVodConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified VOD config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   VodConfigName name = VodConfigName.of("[PROJECT]", "[LOCATION]", "[VOD_CONFIG]");
   *   videoStitcherServiceClient.deleteVodConfigAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the VOD config to be deleted, in the form of
   *     `projects/{project_number}/locations/{location}/vodConfigs/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteVodConfigAsync(VodConfigName name) {
    DeleteVodConfigRequest request =
        DeleteVodConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteVodConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified VOD config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   String name = VodConfigName.of("[PROJECT]", "[LOCATION]", "[VOD_CONFIG]").toString();
   *   videoStitcherServiceClient.deleteVodConfigAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the VOD config to be deleted, in the form of
   *     `projects/{project_number}/locations/{location}/vodConfigs/{id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteVodConfigAsync(String name) {
    DeleteVodConfigRequest request = DeleteVodConfigRequest.newBuilder().setName(name).build();
    return deleteVodConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified VOD config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   DeleteVodConfigRequest request =
   *       DeleteVodConfigRequest.newBuilder()
   *           .setName(VodConfigName.of("[PROJECT]", "[LOCATION]", "[VOD_CONFIG]").toString())
   *           .build();
   *   videoStitcherServiceClient.deleteVodConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteVodConfigAsync(
      DeleteVodConfigRequest request) {
    return deleteVodConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified VOD config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   DeleteVodConfigRequest request =
   *       DeleteVodConfigRequest.newBuilder()
   *           .setName(VodConfigName.of("[PROJECT]", "[LOCATION]", "[VOD_CONFIG]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       videoStitcherServiceClient.deleteVodConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteVodConfigRequest, Empty, OperationMetadata>
      deleteVodConfigOperationCallable() {
    return stub.deleteVodConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified VOD config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   DeleteVodConfigRequest request =
   *       DeleteVodConfigRequest.newBuilder()
   *           .setName(VodConfigName.of("[PROJECT]", "[LOCATION]", "[VOD_CONFIG]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       videoStitcherServiceClient.deleteVodConfigCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteVodConfigRequest, Operation> deleteVodConfigCallable() {
    return stub.deleteVodConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified VOD config. Only update fields specified in the call method body.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   VodConfig vodConfig = VodConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   VodConfig response =
   *       videoStitcherServiceClient.updateVodConfigAsync(vodConfig, updateMask).get();
   * }
   * }</pre>
   *
   * @param vodConfig Required. The VOD config resource which replaces the resource on the server.
   * @param updateMask Required. The update mask applies to the resource. For the `FieldMask`
   *     definition, see
   *     https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<VodConfig, OperationMetadata> updateVodConfigAsync(
      VodConfig vodConfig, FieldMask updateMask) {
    UpdateVodConfigRequest request =
        UpdateVodConfigRequest.newBuilder()
            .setVodConfig(vodConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateVodConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified VOD config. Only update fields specified in the call method body.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   UpdateVodConfigRequest request =
   *       UpdateVodConfigRequest.newBuilder()
   *           .setVodConfig(VodConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   VodConfig response = videoStitcherServiceClient.updateVodConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<VodConfig, OperationMetadata> updateVodConfigAsync(
      UpdateVodConfigRequest request) {
    return updateVodConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified VOD config. Only update fields specified in the call method body.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   UpdateVodConfigRequest request =
   *       UpdateVodConfigRequest.newBuilder()
   *           .setVodConfig(VodConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<VodConfig, OperationMetadata> future =
   *       videoStitcherServiceClient.updateVodConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   VodConfig response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateVodConfigRequest, VodConfig, OperationMetadata>
      updateVodConfigOperationCallable() {
    return stub.updateVodConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified VOD config. Only update fields specified in the call method body.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VideoStitcherServiceClient videoStitcherServiceClient =
   *     VideoStitcherServiceClient.create()) {
   *   UpdateVodConfigRequest request =
   *       UpdateVodConfigRequest.newBuilder()
   *           .setVodConfig(VodConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       videoStitcherServiceClient.updateVodConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateVodConfigRequest, Operation> updateVodConfigCallable() {
    return stub.updateVodConfigCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }

  public static class ListCdnKeysPagedResponse
      extends AbstractPagedListResponse<
          ListCdnKeysRequest,
          ListCdnKeysResponse,
          CdnKey,
          ListCdnKeysPage,
          ListCdnKeysFixedSizeCollection> {

    public static ApiFuture<ListCdnKeysPagedResponse> createAsync(
        PageContext<ListCdnKeysRequest, ListCdnKeysResponse, CdnKey> context,
        ApiFuture<ListCdnKeysResponse> futureResponse) {
      ApiFuture<ListCdnKeysPage> futurePage =
          ListCdnKeysPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListCdnKeysPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListCdnKeysPagedResponse(ListCdnKeysPage page) {
      super(page, ListCdnKeysFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCdnKeysPage
      extends AbstractPage<ListCdnKeysRequest, ListCdnKeysResponse, CdnKey, ListCdnKeysPage> {

    private ListCdnKeysPage(
        PageContext<ListCdnKeysRequest, ListCdnKeysResponse, CdnKey> context,
        ListCdnKeysResponse response) {
      super(context, response);
    }

    private static ListCdnKeysPage createEmptyPage() {
      return new ListCdnKeysPage(null, null);
    }

    @Override
    protected ListCdnKeysPage createPage(
        PageContext<ListCdnKeysRequest, ListCdnKeysResponse, CdnKey> context,
        ListCdnKeysResponse response) {
      return new ListCdnKeysPage(context, response);
    }

    @Override
    public ApiFuture<ListCdnKeysPage> createPageAsync(
        PageContext<ListCdnKeysRequest, ListCdnKeysResponse, CdnKey> context,
        ApiFuture<ListCdnKeysResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCdnKeysFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCdnKeysRequest,
          ListCdnKeysResponse,
          CdnKey,
          ListCdnKeysPage,
          ListCdnKeysFixedSizeCollection> {

    private ListCdnKeysFixedSizeCollection(List<ListCdnKeysPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCdnKeysFixedSizeCollection createEmptyCollection() {
      return new ListCdnKeysFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCdnKeysFixedSizeCollection createCollection(
        List<ListCdnKeysPage> pages, int collectionSize) {
      return new ListCdnKeysFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListVodStitchDetailsPagedResponse
      extends AbstractPagedListResponse<
          ListVodStitchDetailsRequest,
          ListVodStitchDetailsResponse,
          VodStitchDetail,
          ListVodStitchDetailsPage,
          ListVodStitchDetailsFixedSizeCollection> {

    public static ApiFuture<ListVodStitchDetailsPagedResponse> createAsync(
        PageContext<ListVodStitchDetailsRequest, ListVodStitchDetailsResponse, VodStitchDetail>
            context,
        ApiFuture<ListVodStitchDetailsResponse> futureResponse) {
      ApiFuture<ListVodStitchDetailsPage> futurePage =
          ListVodStitchDetailsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListVodStitchDetailsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListVodStitchDetailsPagedResponse(ListVodStitchDetailsPage page) {
      super(page, ListVodStitchDetailsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListVodStitchDetailsPage
      extends AbstractPage<
          ListVodStitchDetailsRequest,
          ListVodStitchDetailsResponse,
          VodStitchDetail,
          ListVodStitchDetailsPage> {

    private ListVodStitchDetailsPage(
        PageContext<ListVodStitchDetailsRequest, ListVodStitchDetailsResponse, VodStitchDetail>
            context,
        ListVodStitchDetailsResponse response) {
      super(context, response);
    }

    private static ListVodStitchDetailsPage createEmptyPage() {
      return new ListVodStitchDetailsPage(null, null);
    }

    @Override
    protected ListVodStitchDetailsPage createPage(
        PageContext<ListVodStitchDetailsRequest, ListVodStitchDetailsResponse, VodStitchDetail>
            context,
        ListVodStitchDetailsResponse response) {
      return new ListVodStitchDetailsPage(context, response);
    }

    @Override
    public ApiFuture<ListVodStitchDetailsPage> createPageAsync(
        PageContext<ListVodStitchDetailsRequest, ListVodStitchDetailsResponse, VodStitchDetail>
            context,
        ApiFuture<ListVodStitchDetailsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListVodStitchDetailsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListVodStitchDetailsRequest,
          ListVodStitchDetailsResponse,
          VodStitchDetail,
          ListVodStitchDetailsPage,
          ListVodStitchDetailsFixedSizeCollection> {

    private ListVodStitchDetailsFixedSizeCollection(
        List<ListVodStitchDetailsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListVodStitchDetailsFixedSizeCollection createEmptyCollection() {
      return new ListVodStitchDetailsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListVodStitchDetailsFixedSizeCollection createCollection(
        List<ListVodStitchDetailsPage> pages, int collectionSize) {
      return new ListVodStitchDetailsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListVodAdTagDetailsPagedResponse
      extends AbstractPagedListResponse<
          ListVodAdTagDetailsRequest,
          ListVodAdTagDetailsResponse,
          VodAdTagDetail,
          ListVodAdTagDetailsPage,
          ListVodAdTagDetailsFixedSizeCollection> {

    public static ApiFuture<ListVodAdTagDetailsPagedResponse> createAsync(
        PageContext<ListVodAdTagDetailsRequest, ListVodAdTagDetailsResponse, VodAdTagDetail>
            context,
        ApiFuture<ListVodAdTagDetailsResponse> futureResponse) {
      ApiFuture<ListVodAdTagDetailsPage> futurePage =
          ListVodAdTagDetailsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListVodAdTagDetailsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListVodAdTagDetailsPagedResponse(ListVodAdTagDetailsPage page) {
      super(page, ListVodAdTagDetailsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListVodAdTagDetailsPage
      extends AbstractPage<
          ListVodAdTagDetailsRequest,
          ListVodAdTagDetailsResponse,
          VodAdTagDetail,
          ListVodAdTagDetailsPage> {

    private ListVodAdTagDetailsPage(
        PageContext<ListVodAdTagDetailsRequest, ListVodAdTagDetailsResponse, VodAdTagDetail>
            context,
        ListVodAdTagDetailsResponse response) {
      super(context, response);
    }

    private static ListVodAdTagDetailsPage createEmptyPage() {
      return new ListVodAdTagDetailsPage(null, null);
    }

    @Override
    protected ListVodAdTagDetailsPage createPage(
        PageContext<ListVodAdTagDetailsRequest, ListVodAdTagDetailsResponse, VodAdTagDetail>
            context,
        ListVodAdTagDetailsResponse response) {
      return new ListVodAdTagDetailsPage(context, response);
    }

    @Override
    public ApiFuture<ListVodAdTagDetailsPage> createPageAsync(
        PageContext<ListVodAdTagDetailsRequest, ListVodAdTagDetailsResponse, VodAdTagDetail>
            context,
        ApiFuture<ListVodAdTagDetailsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListVodAdTagDetailsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListVodAdTagDetailsRequest,
          ListVodAdTagDetailsResponse,
          VodAdTagDetail,
          ListVodAdTagDetailsPage,
          ListVodAdTagDetailsFixedSizeCollection> {

    private ListVodAdTagDetailsFixedSizeCollection(
        List<ListVodAdTagDetailsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListVodAdTagDetailsFixedSizeCollection createEmptyCollection() {
      return new ListVodAdTagDetailsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListVodAdTagDetailsFixedSizeCollection createCollection(
        List<ListVodAdTagDetailsPage> pages, int collectionSize) {
      return new ListVodAdTagDetailsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLiveAdTagDetailsPagedResponse
      extends AbstractPagedListResponse<
          ListLiveAdTagDetailsRequest,
          ListLiveAdTagDetailsResponse,
          LiveAdTagDetail,
          ListLiveAdTagDetailsPage,
          ListLiveAdTagDetailsFixedSizeCollection> {

    public static ApiFuture<ListLiveAdTagDetailsPagedResponse> createAsync(
        PageContext<ListLiveAdTagDetailsRequest, ListLiveAdTagDetailsResponse, LiveAdTagDetail>
            context,
        ApiFuture<ListLiveAdTagDetailsResponse> futureResponse) {
      ApiFuture<ListLiveAdTagDetailsPage> futurePage =
          ListLiveAdTagDetailsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLiveAdTagDetailsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLiveAdTagDetailsPagedResponse(ListLiveAdTagDetailsPage page) {
      super(page, ListLiveAdTagDetailsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLiveAdTagDetailsPage
      extends AbstractPage<
          ListLiveAdTagDetailsRequest,
          ListLiveAdTagDetailsResponse,
          LiveAdTagDetail,
          ListLiveAdTagDetailsPage> {

    private ListLiveAdTagDetailsPage(
        PageContext<ListLiveAdTagDetailsRequest, ListLiveAdTagDetailsResponse, LiveAdTagDetail>
            context,
        ListLiveAdTagDetailsResponse response) {
      super(context, response);
    }

    private static ListLiveAdTagDetailsPage createEmptyPage() {
      return new ListLiveAdTagDetailsPage(null, null);
    }

    @Override
    protected ListLiveAdTagDetailsPage createPage(
        PageContext<ListLiveAdTagDetailsRequest, ListLiveAdTagDetailsResponse, LiveAdTagDetail>
            context,
        ListLiveAdTagDetailsResponse response) {
      return new ListLiveAdTagDetailsPage(context, response);
    }

    @Override
    public ApiFuture<ListLiveAdTagDetailsPage> createPageAsync(
        PageContext<ListLiveAdTagDetailsRequest, ListLiveAdTagDetailsResponse, LiveAdTagDetail>
            context,
        ApiFuture<ListLiveAdTagDetailsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLiveAdTagDetailsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLiveAdTagDetailsRequest,
          ListLiveAdTagDetailsResponse,
          LiveAdTagDetail,
          ListLiveAdTagDetailsPage,
          ListLiveAdTagDetailsFixedSizeCollection> {

    private ListLiveAdTagDetailsFixedSizeCollection(
        List<ListLiveAdTagDetailsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLiveAdTagDetailsFixedSizeCollection createEmptyCollection() {
      return new ListLiveAdTagDetailsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLiveAdTagDetailsFixedSizeCollection createCollection(
        List<ListLiveAdTagDetailsPage> pages, int collectionSize) {
      return new ListLiveAdTagDetailsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSlatesPagedResponse
      extends AbstractPagedListResponse<
          ListSlatesRequest,
          ListSlatesResponse,
          Slate,
          ListSlatesPage,
          ListSlatesFixedSizeCollection> {

    public static ApiFuture<ListSlatesPagedResponse> createAsync(
        PageContext<ListSlatesRequest, ListSlatesResponse, Slate> context,
        ApiFuture<ListSlatesResponse> futureResponse) {
      ApiFuture<ListSlatesPage> futurePage =
          ListSlatesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListSlatesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListSlatesPagedResponse(ListSlatesPage page) {
      super(page, ListSlatesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSlatesPage
      extends AbstractPage<ListSlatesRequest, ListSlatesResponse, Slate, ListSlatesPage> {

    private ListSlatesPage(
        PageContext<ListSlatesRequest, ListSlatesResponse, Slate> context,
        ListSlatesResponse response) {
      super(context, response);
    }

    private static ListSlatesPage createEmptyPage() {
      return new ListSlatesPage(null, null);
    }

    @Override
    protected ListSlatesPage createPage(
        PageContext<ListSlatesRequest, ListSlatesResponse, Slate> context,
        ListSlatesResponse response) {
      return new ListSlatesPage(context, response);
    }

    @Override
    public ApiFuture<ListSlatesPage> createPageAsync(
        PageContext<ListSlatesRequest, ListSlatesResponse, Slate> context,
        ApiFuture<ListSlatesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSlatesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSlatesRequest,
          ListSlatesResponse,
          Slate,
          ListSlatesPage,
          ListSlatesFixedSizeCollection> {

    private ListSlatesFixedSizeCollection(List<ListSlatesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSlatesFixedSizeCollection createEmptyCollection() {
      return new ListSlatesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSlatesFixedSizeCollection createCollection(
        List<ListSlatesPage> pages, int collectionSize) {
      return new ListSlatesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLiveConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListLiveConfigsRequest,
          ListLiveConfigsResponse,
          LiveConfig,
          ListLiveConfigsPage,
          ListLiveConfigsFixedSizeCollection> {

    public static ApiFuture<ListLiveConfigsPagedResponse> createAsync(
        PageContext<ListLiveConfigsRequest, ListLiveConfigsResponse, LiveConfig> context,
        ApiFuture<ListLiveConfigsResponse> futureResponse) {
      ApiFuture<ListLiveConfigsPage> futurePage =
          ListLiveConfigsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLiveConfigsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLiveConfigsPagedResponse(ListLiveConfigsPage page) {
      super(page, ListLiveConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLiveConfigsPage
      extends AbstractPage<
          ListLiveConfigsRequest, ListLiveConfigsResponse, LiveConfig, ListLiveConfigsPage> {

    private ListLiveConfigsPage(
        PageContext<ListLiveConfigsRequest, ListLiveConfigsResponse, LiveConfig> context,
        ListLiveConfigsResponse response) {
      super(context, response);
    }

    private static ListLiveConfigsPage createEmptyPage() {
      return new ListLiveConfigsPage(null, null);
    }

    @Override
    protected ListLiveConfigsPage createPage(
        PageContext<ListLiveConfigsRequest, ListLiveConfigsResponse, LiveConfig> context,
        ListLiveConfigsResponse response) {
      return new ListLiveConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListLiveConfigsPage> createPageAsync(
        PageContext<ListLiveConfigsRequest, ListLiveConfigsResponse, LiveConfig> context,
        ApiFuture<ListLiveConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLiveConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLiveConfigsRequest,
          ListLiveConfigsResponse,
          LiveConfig,
          ListLiveConfigsPage,
          ListLiveConfigsFixedSizeCollection> {

    private ListLiveConfigsFixedSizeCollection(
        List<ListLiveConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLiveConfigsFixedSizeCollection createEmptyCollection() {
      return new ListLiveConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLiveConfigsFixedSizeCollection createCollection(
        List<ListLiveConfigsPage> pages, int collectionSize) {
      return new ListLiveConfigsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListVodConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListVodConfigsRequest,
          ListVodConfigsResponse,
          VodConfig,
          ListVodConfigsPage,
          ListVodConfigsFixedSizeCollection> {

    public static ApiFuture<ListVodConfigsPagedResponse> createAsync(
        PageContext<ListVodConfigsRequest, ListVodConfigsResponse, VodConfig> context,
        ApiFuture<ListVodConfigsResponse> futureResponse) {
      ApiFuture<ListVodConfigsPage> futurePage =
          ListVodConfigsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListVodConfigsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListVodConfigsPagedResponse(ListVodConfigsPage page) {
      super(page, ListVodConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListVodConfigsPage
      extends AbstractPage<
          ListVodConfigsRequest, ListVodConfigsResponse, VodConfig, ListVodConfigsPage> {

    private ListVodConfigsPage(
        PageContext<ListVodConfigsRequest, ListVodConfigsResponse, VodConfig> context,
        ListVodConfigsResponse response) {
      super(context, response);
    }

    private static ListVodConfigsPage createEmptyPage() {
      return new ListVodConfigsPage(null, null);
    }

    @Override
    protected ListVodConfigsPage createPage(
        PageContext<ListVodConfigsRequest, ListVodConfigsResponse, VodConfig> context,
        ListVodConfigsResponse response) {
      return new ListVodConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListVodConfigsPage> createPageAsync(
        PageContext<ListVodConfigsRequest, ListVodConfigsResponse, VodConfig> context,
        ApiFuture<ListVodConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListVodConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListVodConfigsRequest,
          ListVodConfigsResponse,
          VodConfig,
          ListVodConfigsPage,
          ListVodConfigsFixedSizeCollection> {

    private ListVodConfigsFixedSizeCollection(List<ListVodConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListVodConfigsFixedSizeCollection createEmptyCollection() {
      return new ListVodConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListVodConfigsFixedSizeCollection createCollection(
        List<ListVodConfigsPage> pages, int collectionSize) {
      return new ListVodConfigsFixedSizeCollection(pages, collectionSize);
    }
  }
}
