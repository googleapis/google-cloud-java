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

package com.google.cloud.configdelivery.v1beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.configdelivery.v1beta.stub.ConfigDeliveryStub;
import com.google.cloud.configdelivery.v1beta.stub.ConfigDeliveryStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: ConfigDelivery service manages the deployment of kubernetes configuration to
 * a fleet of kubernetes clusters.
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
 * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
 *   ResourceBundleName name =
 *       ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]");
 *   ResourceBundle response = configDeliveryClient.getResourceBundle(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ConfigDeliveryClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListResourceBundles</td>
 *      <td><p> Lists ResourceBundles in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listResourceBundles(ListResourceBundlesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listResourceBundles(LocationName parent)
 *           <li><p> listResourceBundles(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listResourceBundlesPagedCallable()
 *           <li><p> listResourceBundlesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetResourceBundle</td>
 *      <td><p> Gets details of a single ResourceBundle.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getResourceBundle(GetResourceBundleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getResourceBundle(ResourceBundleName name)
 *           <li><p> getResourceBundle(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getResourceBundleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateResourceBundle</td>
 *      <td><p> Creates a new ResourceBundle in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createResourceBundleAsync(CreateResourceBundleRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createResourceBundleAsync(LocationName parent, ResourceBundle resourceBundle, String resourceBundleId)
 *           <li><p> createResourceBundleAsync(String parent, ResourceBundle resourceBundle, String resourceBundleId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createResourceBundleOperationCallable()
 *           <li><p> createResourceBundleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateResourceBundle</td>
 *      <td><p> Updates the parameters of a single ResourceBundle.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateResourceBundleAsync(UpdateResourceBundleRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateResourceBundleAsync(ResourceBundle resourceBundle, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateResourceBundleOperationCallable()
 *           <li><p> updateResourceBundleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteResourceBundle</td>
 *      <td><p> Deletes a single ResourceBundle.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteResourceBundleAsync(DeleteResourceBundleRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteResourceBundleAsync(ResourceBundleName name)
 *           <li><p> deleteResourceBundleAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteResourceBundleOperationCallable()
 *           <li><p> deleteResourceBundleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListFleetPackages</td>
 *      <td><p> Lists FleetPackages in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listFleetPackages(ListFleetPackagesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listFleetPackages(LocationName parent)
 *           <li><p> listFleetPackages(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listFleetPackagesPagedCallable()
 *           <li><p> listFleetPackagesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetFleetPackage</td>
 *      <td><p> Gets details of a single FleetPackage.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getFleetPackage(GetFleetPackageRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getFleetPackage(FleetPackageName name)
 *           <li><p> getFleetPackage(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getFleetPackageCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateFleetPackage</td>
 *      <td><p> Creates a new FleetPackage in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createFleetPackageAsync(CreateFleetPackageRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createFleetPackageAsync(LocationName parent, FleetPackage fleetPackage, String fleetPackageId)
 *           <li><p> createFleetPackageAsync(String parent, FleetPackage fleetPackage, String fleetPackageId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createFleetPackageOperationCallable()
 *           <li><p> createFleetPackageCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateFleetPackage</td>
 *      <td><p> Updates the parameters of a single FleetPackage.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateFleetPackageAsync(UpdateFleetPackageRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateFleetPackageAsync(FleetPackage fleetPackage, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateFleetPackageOperationCallable()
 *           <li><p> updateFleetPackageCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteFleetPackage</td>
 *      <td><p> Deletes a single FleetPackage.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteFleetPackageAsync(DeleteFleetPackageRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteFleetPackageAsync(FleetPackageName name)
 *           <li><p> deleteFleetPackageAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteFleetPackageOperationCallable()
 *           <li><p> deleteFleetPackageCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListReleases</td>
 *      <td><p> Lists Releases in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listReleases(ListReleasesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listReleases(ResourceBundleName parent)
 *           <li><p> listReleases(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listReleasesPagedCallable()
 *           <li><p> listReleasesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRelease</td>
 *      <td><p> Gets details of a single Release.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRelease(GetReleaseRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRelease(ReleaseName name)
 *           <li><p> getRelease(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getReleaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateRelease</td>
 *      <td><p> Creates a new Release in a given project, location and resource bundle.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createReleaseAsync(CreateReleaseRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createReleaseAsync(ResourceBundleName parent, Release release, String releaseId)
 *           <li><p> createReleaseAsync(String parent, Release release, String releaseId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createReleaseOperationCallable()
 *           <li><p> createReleaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateRelease</td>
 *      <td><p> Updates the parameters of a single Release.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateReleaseAsync(UpdateReleaseRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateReleaseAsync(Release release, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateReleaseOperationCallable()
 *           <li><p> updateReleaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteRelease</td>
 *      <td><p> Deletes a single Release.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteReleaseAsync(DeleteReleaseRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteReleaseAsync(ReleaseName name)
 *           <li><p> deleteReleaseAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteReleaseOperationCallable()
 *           <li><p> deleteReleaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListVariants</td>
 *      <td><p> Lists Variants in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listVariants(ListVariantsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listVariants(ReleaseName parent)
 *           <li><p> listVariants(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listVariantsPagedCallable()
 *           <li><p> listVariantsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetVariant</td>
 *      <td><p> Gets details of a single Variant.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getVariant(GetVariantRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getVariant(VariantName name)
 *           <li><p> getVariant(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getVariantCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateVariant</td>
 *      <td><p> Creates a new Variant in a given project, location, resource bundle, and release.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createVariantAsync(CreateVariantRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createVariantAsync(ReleaseName parent, Variant variant, String variantId)
 *           <li><p> createVariantAsync(String parent, Variant variant, String variantId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createVariantOperationCallable()
 *           <li><p> createVariantCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateVariant</td>
 *      <td><p> Updates the parameters of a single Variant.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateVariantAsync(UpdateVariantRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateVariantAsync(Variant variant, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateVariantOperationCallable()
 *           <li><p> updateVariantCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteVariant</td>
 *      <td><p> Deletes a single Variant.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteVariantAsync(DeleteVariantRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteVariantAsync(VariantName name)
 *           <li><p> deleteVariantAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteVariantOperationCallable()
 *           <li><p> deleteVariantCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListRollouts</td>
 *      <td><p> Lists Rollouts in a given project, location, and Fleet Package.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRollouts(ListRolloutsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRollouts(FleetPackageName parent)
 *           <li><p> listRollouts(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRolloutsPagedCallable()
 *           <li><p> listRolloutsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRollout</td>
 *      <td><p> Gets details of a single Rollout.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRollout(GetRolloutRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRollout(RolloutName name)
 *           <li><p> getRollout(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRolloutCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SuspendRollout</td>
 *      <td><p> Suspend a Rollout.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> suspendRolloutAsync(SuspendRolloutRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> suspendRolloutAsync(RolloutName name)
 *           <li><p> suspendRolloutAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> suspendRolloutOperationCallable()
 *           <li><p> suspendRolloutCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ResumeRollout</td>
 *      <td><p> Resume a Rollout.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> resumeRolloutAsync(ResumeRolloutRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> resumeRolloutAsync(RolloutName name)
 *           <li><p> resumeRolloutAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> resumeRolloutOperationCallable()
 *           <li><p> resumeRolloutCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AbortRollout</td>
 *      <td><p> Abort a Rollout.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> abortRolloutAsync(AbortRolloutRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> abortRolloutAsync(RolloutName name)
 *           <li><p> abortRolloutAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> abortRolloutOperationCallable()
 *           <li><p> abortRolloutCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLocations(ListLocationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLocationsPagedCallable()
 *           <li><p> listLocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLocation</td>
 *      <td><p> Gets information about a location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLocation(GetLocationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLocationCallable()
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
 * <p>This class can be customized by passing in a custom instance of ConfigDeliverySettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ConfigDeliverySettings configDeliverySettings =
 *     ConfigDeliverySettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create(configDeliverySettings);
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
 * ConfigDeliverySettings configDeliverySettings =
 *     ConfigDeliverySettings.newBuilder().setEndpoint(myEndpoint).build();
 * ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create(configDeliverySettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ConfigDeliverySettings configDeliverySettings =
 *     ConfigDeliverySettings.newHttpJsonBuilder().build();
 * ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create(configDeliverySettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ConfigDeliveryClient implements BackgroundResource {
  private final ConfigDeliverySettings settings;
  private final ConfigDeliveryStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of ConfigDeliveryClient with default settings. */
  public static final ConfigDeliveryClient create() throws IOException {
    return create(ConfigDeliverySettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ConfigDeliveryClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ConfigDeliveryClient create(ConfigDeliverySettings settings)
      throws IOException {
    return new ConfigDeliveryClient(settings);
  }

  /**
   * Constructs an instance of ConfigDeliveryClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ConfigDeliverySettings).
   */
  public static final ConfigDeliveryClient create(ConfigDeliveryStub stub) {
    return new ConfigDeliveryClient(stub);
  }

  /**
   * Constructs an instance of ConfigDeliveryClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ConfigDeliveryClient(ConfigDeliverySettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ConfigDeliveryStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected ConfigDeliveryClient(ConfigDeliveryStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final ConfigDeliverySettings getSettings() {
    return settings;
  }

  public ConfigDeliveryStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ResourceBundles in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ResourceBundle element : configDeliveryClient.listResourceBundles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListResourceBundlesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListResourceBundlesPagedResponse listResourceBundles(LocationName parent) {
    ListResourceBundlesRequest request =
        ListResourceBundlesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listResourceBundles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ResourceBundles in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ResourceBundle element : configDeliveryClient.listResourceBundles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListResourceBundlesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListResourceBundlesPagedResponse listResourceBundles(String parent) {
    ListResourceBundlesRequest request =
        ListResourceBundlesRequest.newBuilder().setParent(parent).build();
    return listResourceBundles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ResourceBundles in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   ListResourceBundlesRequest request =
   *       ListResourceBundlesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ResourceBundle element :
   *       configDeliveryClient.listResourceBundles(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListResourceBundlesPagedResponse listResourceBundles(
      ListResourceBundlesRequest request) {
    return listResourceBundlesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ResourceBundles in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   ListResourceBundlesRequest request =
   *       ListResourceBundlesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ResourceBundle> future =
   *       configDeliveryClient.listResourceBundlesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ResourceBundle element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListResourceBundlesRequest, ListResourceBundlesPagedResponse>
      listResourceBundlesPagedCallable() {
    return stub.listResourceBundlesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ResourceBundles in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   ListResourceBundlesRequest request =
   *       ListResourceBundlesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListResourceBundlesResponse response =
   *         configDeliveryClient.listResourceBundlesCallable().call(request);
   *     for (ResourceBundle element : response.getResourceBundlesList()) {
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
  public final UnaryCallable<ListResourceBundlesRequest, ListResourceBundlesResponse>
      listResourceBundlesCallable() {
    return stub.listResourceBundlesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ResourceBundle.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   ResourceBundleName name =
   *       ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]");
   *   ResourceBundle response = configDeliveryClient.getResourceBundle(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResourceBundle getResourceBundle(ResourceBundleName name) {
    GetResourceBundleRequest request =
        GetResourceBundleRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getResourceBundle(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ResourceBundle.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   String name =
   *       ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]").toString();
   *   ResourceBundle response = configDeliveryClient.getResourceBundle(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResourceBundle getResourceBundle(String name) {
    GetResourceBundleRequest request = GetResourceBundleRequest.newBuilder().setName(name).build();
    return getResourceBundle(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ResourceBundle.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   GetResourceBundleRequest request =
   *       GetResourceBundleRequest.newBuilder()
   *           .setName(
   *               ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]").toString())
   *           .build();
   *   ResourceBundle response = configDeliveryClient.getResourceBundle(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResourceBundle getResourceBundle(GetResourceBundleRequest request) {
    return getResourceBundleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ResourceBundle.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   GetResourceBundleRequest request =
   *       GetResourceBundleRequest.newBuilder()
   *           .setName(
   *               ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]").toString())
   *           .build();
   *   ApiFuture<ResourceBundle> future =
   *       configDeliveryClient.getResourceBundleCallable().futureCall(request);
   *   // Do something.
   *   ResourceBundle response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetResourceBundleRequest, ResourceBundle> getResourceBundleCallable() {
    return stub.getResourceBundleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ResourceBundle in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ResourceBundle resourceBundle = ResourceBundle.newBuilder().build();
   *   String resourceBundleId = "resourceBundleId1209359211";
   *   ResourceBundle response =
   *       configDeliveryClient
   *           .createResourceBundleAsync(parent, resourceBundle, resourceBundleId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param resourceBundle Required. The resource being created
   * @param resourceBundleId Required. Id of the requesting object If auto-generating Id
   *     server-side, remove this field and resource_bundle_id from the method_signature of Create
   *     RPC
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ResourceBundle, OperationMetadata> createResourceBundleAsync(
      LocationName parent, ResourceBundle resourceBundle, String resourceBundleId) {
    CreateResourceBundleRequest request =
        CreateResourceBundleRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setResourceBundle(resourceBundle)
            .setResourceBundleId(resourceBundleId)
            .build();
    return createResourceBundleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ResourceBundle in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ResourceBundle resourceBundle = ResourceBundle.newBuilder().build();
   *   String resourceBundleId = "resourceBundleId1209359211";
   *   ResourceBundle response =
   *       configDeliveryClient
   *           .createResourceBundleAsync(parent, resourceBundle, resourceBundleId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param resourceBundle Required. The resource being created
   * @param resourceBundleId Required. Id of the requesting object If auto-generating Id
   *     server-side, remove this field and resource_bundle_id from the method_signature of Create
   *     RPC
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ResourceBundle, OperationMetadata> createResourceBundleAsync(
      String parent, ResourceBundle resourceBundle, String resourceBundleId) {
    CreateResourceBundleRequest request =
        CreateResourceBundleRequest.newBuilder()
            .setParent(parent)
            .setResourceBundle(resourceBundle)
            .setResourceBundleId(resourceBundleId)
            .build();
    return createResourceBundleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ResourceBundle in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   CreateResourceBundleRequest request =
   *       CreateResourceBundleRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setResourceBundleId("resourceBundleId1209359211")
   *           .setResourceBundle(ResourceBundle.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ResourceBundle response = configDeliveryClient.createResourceBundleAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ResourceBundle, OperationMetadata> createResourceBundleAsync(
      CreateResourceBundleRequest request) {
    return createResourceBundleOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ResourceBundle in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   CreateResourceBundleRequest request =
   *       CreateResourceBundleRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setResourceBundleId("resourceBundleId1209359211")
   *           .setResourceBundle(ResourceBundle.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ResourceBundle, OperationMetadata> future =
   *       configDeliveryClient.createResourceBundleOperationCallable().futureCall(request);
   *   // Do something.
   *   ResourceBundle response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateResourceBundleRequest, ResourceBundle, OperationMetadata>
      createResourceBundleOperationCallable() {
    return stub.createResourceBundleOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ResourceBundle in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   CreateResourceBundleRequest request =
   *       CreateResourceBundleRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setResourceBundleId("resourceBundleId1209359211")
   *           .setResourceBundle(ResourceBundle.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       configDeliveryClient.createResourceBundleCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateResourceBundleRequest, Operation>
      createResourceBundleCallable() {
    return stub.createResourceBundleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ResourceBundle.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   ResourceBundle resourceBundle = ResourceBundle.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ResourceBundle response =
   *       configDeliveryClient.updateResourceBundleAsync(resourceBundle, updateMask).get();
   * }
   * }</pre>
   *
   * @param resourceBundle Required. The resource being updated
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     ResourceBundle resource by the update. The fields specified in the update_mask are relative
   *     to the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ResourceBundle, OperationMetadata> updateResourceBundleAsync(
      ResourceBundle resourceBundle, FieldMask updateMask) {
    UpdateResourceBundleRequest request =
        UpdateResourceBundleRequest.newBuilder()
            .setResourceBundle(resourceBundle)
            .setUpdateMask(updateMask)
            .build();
    return updateResourceBundleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ResourceBundle.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   UpdateResourceBundleRequest request =
   *       UpdateResourceBundleRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setResourceBundle(ResourceBundle.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ResourceBundle response = configDeliveryClient.updateResourceBundleAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ResourceBundle, OperationMetadata> updateResourceBundleAsync(
      UpdateResourceBundleRequest request) {
    return updateResourceBundleOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ResourceBundle.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   UpdateResourceBundleRequest request =
   *       UpdateResourceBundleRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setResourceBundle(ResourceBundle.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ResourceBundle, OperationMetadata> future =
   *       configDeliveryClient.updateResourceBundleOperationCallable().futureCall(request);
   *   // Do something.
   *   ResourceBundle response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateResourceBundleRequest, ResourceBundle, OperationMetadata>
      updateResourceBundleOperationCallable() {
    return stub.updateResourceBundleOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single ResourceBundle.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   UpdateResourceBundleRequest request =
   *       UpdateResourceBundleRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setResourceBundle(ResourceBundle.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       configDeliveryClient.updateResourceBundleCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateResourceBundleRequest, Operation>
      updateResourceBundleCallable() {
    return stub.updateResourceBundleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ResourceBundle.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   ResourceBundleName name =
   *       ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]");
   *   configDeliveryClient.deleteResourceBundleAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteResourceBundleAsync(
      ResourceBundleName name) {
    DeleteResourceBundleRequest request =
        DeleteResourceBundleRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteResourceBundleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ResourceBundle.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   String name =
   *       ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]").toString();
   *   configDeliveryClient.deleteResourceBundleAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteResourceBundleAsync(String name) {
    DeleteResourceBundleRequest request =
        DeleteResourceBundleRequest.newBuilder().setName(name).build();
    return deleteResourceBundleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ResourceBundle.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   DeleteResourceBundleRequest request =
   *       DeleteResourceBundleRequest.newBuilder()
   *           .setName(
   *               ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   configDeliveryClient.deleteResourceBundleAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteResourceBundleAsync(
      DeleteResourceBundleRequest request) {
    return deleteResourceBundleOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ResourceBundle.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   DeleteResourceBundleRequest request =
   *       DeleteResourceBundleRequest.newBuilder()
   *           .setName(
   *               ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       configDeliveryClient.deleteResourceBundleOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteResourceBundleRequest, Empty, OperationMetadata>
      deleteResourceBundleOperationCallable() {
    return stub.deleteResourceBundleOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ResourceBundle.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   DeleteResourceBundleRequest request =
   *       DeleteResourceBundleRequest.newBuilder()
   *           .setName(
   *               ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       configDeliveryClient.deleteResourceBundleCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteResourceBundleRequest, Operation>
      deleteResourceBundleCallable() {
    return stub.deleteResourceBundleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FleetPackages in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (FleetPackage element : configDeliveryClient.listFleetPackages(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListFleetPackagesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFleetPackagesPagedResponse listFleetPackages(LocationName parent) {
    ListFleetPackagesRequest request =
        ListFleetPackagesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listFleetPackages(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FleetPackages in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (FleetPackage element : configDeliveryClient.listFleetPackages(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListFleetPackagesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFleetPackagesPagedResponse listFleetPackages(String parent) {
    ListFleetPackagesRequest request =
        ListFleetPackagesRequest.newBuilder().setParent(parent).build();
    return listFleetPackages(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FleetPackages in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   ListFleetPackagesRequest request =
   *       ListFleetPackagesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (FleetPackage element : configDeliveryClient.listFleetPackages(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFleetPackagesPagedResponse listFleetPackages(ListFleetPackagesRequest request) {
    return listFleetPackagesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FleetPackages in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   ListFleetPackagesRequest request =
   *       ListFleetPackagesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<FleetPackage> future =
   *       configDeliveryClient.listFleetPackagesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (FleetPackage element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListFleetPackagesRequest, ListFleetPackagesPagedResponse>
      listFleetPackagesPagedCallable() {
    return stub.listFleetPackagesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists FleetPackages in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   ListFleetPackagesRequest request =
   *       ListFleetPackagesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListFleetPackagesResponse response =
   *         configDeliveryClient.listFleetPackagesCallable().call(request);
   *     for (FleetPackage element : response.getFleetPackagesList()) {
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
  public final UnaryCallable<ListFleetPackagesRequest, ListFleetPackagesResponse>
      listFleetPackagesCallable() {
    return stub.listFleetPackagesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single FleetPackage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   FleetPackageName name = FleetPackageName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]");
   *   FleetPackage response = configDeliveryClient.getFleetPackage(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FleetPackage getFleetPackage(FleetPackageName name) {
    GetFleetPackageRequest request =
        GetFleetPackageRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getFleetPackage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single FleetPackage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   String name = FleetPackageName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]").toString();
   *   FleetPackage response = configDeliveryClient.getFleetPackage(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FleetPackage getFleetPackage(String name) {
    GetFleetPackageRequest request = GetFleetPackageRequest.newBuilder().setName(name).build();
    return getFleetPackage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single FleetPackage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   GetFleetPackageRequest request =
   *       GetFleetPackageRequest.newBuilder()
   *           .setName(FleetPackageName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]").toString())
   *           .build();
   *   FleetPackage response = configDeliveryClient.getFleetPackage(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FleetPackage getFleetPackage(GetFleetPackageRequest request) {
    return getFleetPackageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single FleetPackage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   GetFleetPackageRequest request =
   *       GetFleetPackageRequest.newBuilder()
   *           .setName(FleetPackageName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]").toString())
   *           .build();
   *   ApiFuture<FleetPackage> future =
   *       configDeliveryClient.getFleetPackageCallable().futureCall(request);
   *   // Do something.
   *   FleetPackage response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetFleetPackageRequest, FleetPackage> getFleetPackageCallable() {
    return stub.getFleetPackageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new FleetPackage in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   FleetPackage fleetPackage = FleetPackage.newBuilder().build();
   *   String fleetPackageId = "fleetPackageId-115835309";
   *   FleetPackage response =
   *       configDeliveryClient.createFleetPackageAsync(parent, fleetPackage, fleetPackageId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param fleetPackage Required. The resource being created.
   * @param fleetPackageId Required. Id of the requesting object If auto-generating Id server-side,
   *     remove this field and fleet_package_id from the method_signature of Create RPC
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FleetPackage, OperationMetadata> createFleetPackageAsync(
      LocationName parent, FleetPackage fleetPackage, String fleetPackageId) {
    CreateFleetPackageRequest request =
        CreateFleetPackageRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFleetPackage(fleetPackage)
            .setFleetPackageId(fleetPackageId)
            .build();
    return createFleetPackageAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new FleetPackage in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   FleetPackage fleetPackage = FleetPackage.newBuilder().build();
   *   String fleetPackageId = "fleetPackageId-115835309";
   *   FleetPackage response =
   *       configDeliveryClient.createFleetPackageAsync(parent, fleetPackage, fleetPackageId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param fleetPackage Required. The resource being created.
   * @param fleetPackageId Required. Id of the requesting object If auto-generating Id server-side,
   *     remove this field and fleet_package_id from the method_signature of Create RPC
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FleetPackage, OperationMetadata> createFleetPackageAsync(
      String parent, FleetPackage fleetPackage, String fleetPackageId) {
    CreateFleetPackageRequest request =
        CreateFleetPackageRequest.newBuilder()
            .setParent(parent)
            .setFleetPackage(fleetPackage)
            .setFleetPackageId(fleetPackageId)
            .build();
    return createFleetPackageAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new FleetPackage in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   CreateFleetPackageRequest request =
   *       CreateFleetPackageRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFleetPackageId("fleetPackageId-115835309")
   *           .setFleetPackage(FleetPackage.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   FleetPackage response = configDeliveryClient.createFleetPackageAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FleetPackage, OperationMetadata> createFleetPackageAsync(
      CreateFleetPackageRequest request) {
    return createFleetPackageOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new FleetPackage in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   CreateFleetPackageRequest request =
   *       CreateFleetPackageRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFleetPackageId("fleetPackageId-115835309")
   *           .setFleetPackage(FleetPackage.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<FleetPackage, OperationMetadata> future =
   *       configDeliveryClient.createFleetPackageOperationCallable().futureCall(request);
   *   // Do something.
   *   FleetPackage response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateFleetPackageRequest, FleetPackage, OperationMetadata>
      createFleetPackageOperationCallable() {
    return stub.createFleetPackageOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new FleetPackage in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   CreateFleetPackageRequest request =
   *       CreateFleetPackageRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFleetPackageId("fleetPackageId-115835309")
   *           .setFleetPackage(FleetPackage.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       configDeliveryClient.createFleetPackageCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateFleetPackageRequest, Operation> createFleetPackageCallable() {
    return stub.createFleetPackageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single FleetPackage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   FleetPackage fleetPackage = FleetPackage.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   FleetPackage response =
   *       configDeliveryClient.updateFleetPackageAsync(fleetPackage, updateMask).get();
   * }
   * }</pre>
   *
   * @param fleetPackage Required. The resource being updated
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     FleetPackage resource by the update. The fields specified in the update_mask are relative
   *     to the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FleetPackage, OperationMetadata> updateFleetPackageAsync(
      FleetPackage fleetPackage, FieldMask updateMask) {
    UpdateFleetPackageRequest request =
        UpdateFleetPackageRequest.newBuilder()
            .setFleetPackage(fleetPackage)
            .setUpdateMask(updateMask)
            .build();
    return updateFleetPackageAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single FleetPackage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   UpdateFleetPackageRequest request =
   *       UpdateFleetPackageRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setFleetPackage(FleetPackage.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   FleetPackage response = configDeliveryClient.updateFleetPackageAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FleetPackage, OperationMetadata> updateFleetPackageAsync(
      UpdateFleetPackageRequest request) {
    return updateFleetPackageOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single FleetPackage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   UpdateFleetPackageRequest request =
   *       UpdateFleetPackageRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setFleetPackage(FleetPackage.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<FleetPackage, OperationMetadata> future =
   *       configDeliveryClient.updateFleetPackageOperationCallable().futureCall(request);
   *   // Do something.
   *   FleetPackage response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateFleetPackageRequest, FleetPackage, OperationMetadata>
      updateFleetPackageOperationCallable() {
    return stub.updateFleetPackageOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single FleetPackage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   UpdateFleetPackageRequest request =
   *       UpdateFleetPackageRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setFleetPackage(FleetPackage.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       configDeliveryClient.updateFleetPackageCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateFleetPackageRequest, Operation> updateFleetPackageCallable() {
    return stub.updateFleetPackageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single FleetPackage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   FleetPackageName name = FleetPackageName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]");
   *   configDeliveryClient.deleteFleetPackageAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteFleetPackageAsync(
      FleetPackageName name) {
    DeleteFleetPackageRequest request =
        DeleteFleetPackageRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteFleetPackageAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single FleetPackage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   String name = FleetPackageName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]").toString();
   *   configDeliveryClient.deleteFleetPackageAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteFleetPackageAsync(String name) {
    DeleteFleetPackageRequest request =
        DeleteFleetPackageRequest.newBuilder().setName(name).build();
    return deleteFleetPackageAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single FleetPackage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   DeleteFleetPackageRequest request =
   *       DeleteFleetPackageRequest.newBuilder()
   *           .setName(FleetPackageName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .setAllowMissing(true)
   *           .build();
   *   configDeliveryClient.deleteFleetPackageAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteFleetPackageAsync(
      DeleteFleetPackageRequest request) {
    return deleteFleetPackageOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single FleetPackage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   DeleteFleetPackageRequest request =
   *       DeleteFleetPackageRequest.newBuilder()
   *           .setName(FleetPackageName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .setAllowMissing(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       configDeliveryClient.deleteFleetPackageOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteFleetPackageRequest, Empty, OperationMetadata>
      deleteFleetPackageOperationCallable() {
    return stub.deleteFleetPackageOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single FleetPackage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   DeleteFleetPackageRequest request =
   *       DeleteFleetPackageRequest.newBuilder()
   *           .setName(FleetPackageName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       configDeliveryClient.deleteFleetPackageCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteFleetPackageRequest, Operation> deleteFleetPackageCallable() {
    return stub.deleteFleetPackageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Releases in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   ResourceBundleName parent =
   *       ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]");
   *   for (Release element : configDeliveryClient.listReleases(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListReleasesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReleasesPagedResponse listReleases(ResourceBundleName parent) {
    ListReleasesRequest request =
        ListReleasesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listReleases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Releases in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   String parent =
   *       ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]").toString();
   *   for (Release element : configDeliveryClient.listReleases(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListReleasesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReleasesPagedResponse listReleases(String parent) {
    ListReleasesRequest request = ListReleasesRequest.newBuilder().setParent(parent).build();
    return listReleases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Releases in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   ListReleasesRequest request =
   *       ListReleasesRequest.newBuilder()
   *           .setParent(
   *               ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Release element : configDeliveryClient.listReleases(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReleasesPagedResponse listReleases(ListReleasesRequest request) {
    return listReleasesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Releases in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   ListReleasesRequest request =
   *       ListReleasesRequest.newBuilder()
   *           .setParent(
   *               ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Release> future =
   *       configDeliveryClient.listReleasesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Release element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListReleasesRequest, ListReleasesPagedResponse>
      listReleasesPagedCallable() {
    return stub.listReleasesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Releases in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   ListReleasesRequest request =
   *       ListReleasesRequest.newBuilder()
   *           .setParent(
   *               ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListReleasesResponse response = configDeliveryClient.listReleasesCallable().call(request);
   *     for (Release element : response.getReleasesList()) {
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
  public final UnaryCallable<ListReleasesRequest, ListReleasesResponse> listReleasesCallable() {
    return stub.listReleasesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   ReleaseName name =
   *       ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]");
   *   Release response = configDeliveryClient.getRelease(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Release getRelease(ReleaseName name) {
    GetReleaseRequest request =
        GetReleaseRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRelease(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   String name =
   *       ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]").toString();
   *   Release response = configDeliveryClient.getRelease(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Release getRelease(String name) {
    GetReleaseRequest request = GetReleaseRequest.newBuilder().setName(name).build();
    return getRelease(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   GetReleaseRequest request =
   *       GetReleaseRequest.newBuilder()
   *           .setName(
   *               ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]")
   *                   .toString())
   *           .build();
   *   Release response = configDeliveryClient.getRelease(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Release getRelease(GetReleaseRequest request) {
    return getReleaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   GetReleaseRequest request =
   *       GetReleaseRequest.newBuilder()
   *           .setName(
   *               ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Release> future = configDeliveryClient.getReleaseCallable().futureCall(request);
   *   // Do something.
   *   Release response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetReleaseRequest, Release> getReleaseCallable() {
    return stub.getReleaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Release in a given project, location and resource bundle.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   ResourceBundleName parent =
   *       ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]");
   *   Release release = Release.newBuilder().build();
   *   String releaseId = "releaseId89607042";
   *   Release response = configDeliveryClient.createReleaseAsync(parent, release, releaseId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param release Required. The resource being created
   * @param releaseId Required. Id of the requesting object If auto-generating Id server-side,
   *     remove this field and release_id from the method_signature of Create RPC
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Release, OperationMetadata> createReleaseAsync(
      ResourceBundleName parent, Release release, String releaseId) {
    CreateReleaseRequest request =
        CreateReleaseRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRelease(release)
            .setReleaseId(releaseId)
            .build();
    return createReleaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Release in a given project, location and resource bundle.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   String parent =
   *       ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]").toString();
   *   Release release = Release.newBuilder().build();
   *   String releaseId = "releaseId89607042";
   *   Release response = configDeliveryClient.createReleaseAsync(parent, release, releaseId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param release Required. The resource being created
   * @param releaseId Required. Id of the requesting object If auto-generating Id server-side,
   *     remove this field and release_id from the method_signature of Create RPC
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Release, OperationMetadata> createReleaseAsync(
      String parent, Release release, String releaseId) {
    CreateReleaseRequest request =
        CreateReleaseRequest.newBuilder()
            .setParent(parent)
            .setRelease(release)
            .setReleaseId(releaseId)
            .build();
    return createReleaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Release in a given project, location and resource bundle.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   CreateReleaseRequest request =
   *       CreateReleaseRequest.newBuilder()
   *           .setParent(
   *               ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]").toString())
   *           .setReleaseId("releaseId89607042")
   *           .setRelease(Release.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Release response = configDeliveryClient.createReleaseAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Release, OperationMetadata> createReleaseAsync(
      CreateReleaseRequest request) {
    return createReleaseOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Release in a given project, location and resource bundle.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   CreateReleaseRequest request =
   *       CreateReleaseRequest.newBuilder()
   *           .setParent(
   *               ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]").toString())
   *           .setReleaseId("releaseId89607042")
   *           .setRelease(Release.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Release, OperationMetadata> future =
   *       configDeliveryClient.createReleaseOperationCallable().futureCall(request);
   *   // Do something.
   *   Release response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateReleaseRequest, Release, OperationMetadata>
      createReleaseOperationCallable() {
    return stub.createReleaseOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Release in a given project, location and resource bundle.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   CreateReleaseRequest request =
   *       CreateReleaseRequest.newBuilder()
   *           .setParent(
   *               ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]").toString())
   *           .setReleaseId("releaseId89607042")
   *           .setRelease(Release.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       configDeliveryClient.createReleaseCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateReleaseRequest, Operation> createReleaseCallable() {
    return stub.createReleaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   Release release = Release.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Release response = configDeliveryClient.updateReleaseAsync(release, updateMask).get();
   * }
   * }</pre>
   *
   * @param release Required. The resource being updated
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     Release resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Release, OperationMetadata> updateReleaseAsync(
      Release release, FieldMask updateMask) {
    UpdateReleaseRequest request =
        UpdateReleaseRequest.newBuilder().setRelease(release).setUpdateMask(updateMask).build();
    return updateReleaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   UpdateReleaseRequest request =
   *       UpdateReleaseRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRelease(Release.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Release response = configDeliveryClient.updateReleaseAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Release, OperationMetadata> updateReleaseAsync(
      UpdateReleaseRequest request) {
    return updateReleaseOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   UpdateReleaseRequest request =
   *       UpdateReleaseRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRelease(Release.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Release, OperationMetadata> future =
   *       configDeliveryClient.updateReleaseOperationCallable().futureCall(request);
   *   // Do something.
   *   Release response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateReleaseRequest, Release, OperationMetadata>
      updateReleaseOperationCallable() {
    return stub.updateReleaseOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   UpdateReleaseRequest request =
   *       UpdateReleaseRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRelease(Release.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       configDeliveryClient.updateReleaseCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateReleaseRequest, Operation> updateReleaseCallable() {
    return stub.updateReleaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   ReleaseName name =
   *       ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]");
   *   configDeliveryClient.deleteReleaseAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteReleaseAsync(ReleaseName name) {
    DeleteReleaseRequest request =
        DeleteReleaseRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteReleaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   String name =
   *       ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]").toString();
   *   configDeliveryClient.deleteReleaseAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteReleaseAsync(String name) {
    DeleteReleaseRequest request = DeleteReleaseRequest.newBuilder().setName(name).build();
    return deleteReleaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   DeleteReleaseRequest request =
   *       DeleteReleaseRequest.newBuilder()
   *           .setName(
   *               ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   configDeliveryClient.deleteReleaseAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteReleaseAsync(
      DeleteReleaseRequest request) {
    return deleteReleaseOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   DeleteReleaseRequest request =
   *       DeleteReleaseRequest.newBuilder()
   *           .setName(
   *               ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       configDeliveryClient.deleteReleaseOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteReleaseRequest, Empty, OperationMetadata>
      deleteReleaseOperationCallable() {
    return stub.deleteReleaseOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   DeleteReleaseRequest request =
   *       DeleteReleaseRequest.newBuilder()
   *           .setName(
   *               ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       configDeliveryClient.deleteReleaseCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteReleaseRequest, Operation> deleteReleaseCallable() {
    return stub.deleteReleaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Variants in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   ReleaseName parent =
   *       ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]");
   *   for (Variant element : configDeliveryClient.listVariants(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListVariantsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVariantsPagedResponse listVariants(ReleaseName parent) {
    ListVariantsRequest request =
        ListVariantsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listVariants(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Variants in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   String parent =
   *       ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]").toString();
   *   for (Variant element : configDeliveryClient.listVariants(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListVariantsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVariantsPagedResponse listVariants(String parent) {
    ListVariantsRequest request = ListVariantsRequest.newBuilder().setParent(parent).build();
    return listVariants(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Variants in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   ListVariantsRequest request =
   *       ListVariantsRequest.newBuilder()
   *           .setParent(
   *               ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Variant element : configDeliveryClient.listVariants(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVariantsPagedResponse listVariants(ListVariantsRequest request) {
    return listVariantsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Variants in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   ListVariantsRequest request =
   *       ListVariantsRequest.newBuilder()
   *           .setParent(
   *               ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Variant> future =
   *       configDeliveryClient.listVariantsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Variant element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListVariantsRequest, ListVariantsPagedResponse>
      listVariantsPagedCallable() {
    return stub.listVariantsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Variants in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   ListVariantsRequest request =
   *       ListVariantsRequest.newBuilder()
   *           .setParent(
   *               ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListVariantsResponse response = configDeliveryClient.listVariantsCallable().call(request);
   *     for (Variant element : response.getVariantsList()) {
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
  public final UnaryCallable<ListVariantsRequest, ListVariantsResponse> listVariantsCallable() {
    return stub.listVariantsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Variant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   VariantName name =
   *       VariantName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]", "[VARIANT]");
   *   Variant response = configDeliveryClient.getVariant(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Variant getVariant(VariantName name) {
    GetVariantRequest request =
        GetVariantRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getVariant(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Variant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   String name =
   *       VariantName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]", "[VARIANT]")
   *           .toString();
   *   Variant response = configDeliveryClient.getVariant(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Variant getVariant(String name) {
    GetVariantRequest request = GetVariantRequest.newBuilder().setName(name).build();
    return getVariant(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Variant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   GetVariantRequest request =
   *       GetVariantRequest.newBuilder()
   *           .setName(
   *               VariantName.of(
   *                       "[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]", "[VARIANT]")
   *                   .toString())
   *           .build();
   *   Variant response = configDeliveryClient.getVariant(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Variant getVariant(GetVariantRequest request) {
    return getVariantCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Variant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   GetVariantRequest request =
   *       GetVariantRequest.newBuilder()
   *           .setName(
   *               VariantName.of(
   *                       "[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]", "[VARIANT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Variant> future = configDeliveryClient.getVariantCallable().futureCall(request);
   *   // Do something.
   *   Variant response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetVariantRequest, Variant> getVariantCallable() {
    return stub.getVariantCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Variant in a given project, location, resource bundle, and release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   ReleaseName parent =
   *       ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]");
   *   Variant variant = Variant.newBuilder().build();
   *   String variantId = "variantId-82113408";
   *   Variant response = configDeliveryClient.createVariantAsync(parent, variant, variantId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param variant Required. The resource being created
   * @param variantId Required. Id of the requesting object
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Variant, OperationMetadata> createVariantAsync(
      ReleaseName parent, Variant variant, String variantId) {
    CreateVariantRequest request =
        CreateVariantRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setVariant(variant)
            .setVariantId(variantId)
            .build();
    return createVariantAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Variant in a given project, location, resource bundle, and release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   String parent =
   *       ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]").toString();
   *   Variant variant = Variant.newBuilder().build();
   *   String variantId = "variantId-82113408";
   *   Variant response = configDeliveryClient.createVariantAsync(parent, variant, variantId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param variant Required. The resource being created
   * @param variantId Required. Id of the requesting object
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Variant, OperationMetadata> createVariantAsync(
      String parent, Variant variant, String variantId) {
    CreateVariantRequest request =
        CreateVariantRequest.newBuilder()
            .setParent(parent)
            .setVariant(variant)
            .setVariantId(variantId)
            .build();
    return createVariantAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Variant in a given project, location, resource bundle, and release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   CreateVariantRequest request =
   *       CreateVariantRequest.newBuilder()
   *           .setParent(
   *               ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]")
   *                   .toString())
   *           .setVariantId("variantId-82113408")
   *           .setVariant(Variant.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Variant response = configDeliveryClient.createVariantAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Variant, OperationMetadata> createVariantAsync(
      CreateVariantRequest request) {
    return createVariantOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Variant in a given project, location, resource bundle, and release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   CreateVariantRequest request =
   *       CreateVariantRequest.newBuilder()
   *           .setParent(
   *               ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]")
   *                   .toString())
   *           .setVariantId("variantId-82113408")
   *           .setVariant(Variant.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Variant, OperationMetadata> future =
   *       configDeliveryClient.createVariantOperationCallable().futureCall(request);
   *   // Do something.
   *   Variant response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateVariantRequest, Variant, OperationMetadata>
      createVariantOperationCallable() {
    return stub.createVariantOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Variant in a given project, location, resource bundle, and release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   CreateVariantRequest request =
   *       CreateVariantRequest.newBuilder()
   *           .setParent(
   *               ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]")
   *                   .toString())
   *           .setVariantId("variantId-82113408")
   *           .setVariant(Variant.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       configDeliveryClient.createVariantCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateVariantRequest, Operation> createVariantCallable() {
    return stub.createVariantCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Variant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   Variant variant = Variant.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Variant response = configDeliveryClient.updateVariantAsync(variant, updateMask).get();
   * }
   * }</pre>
   *
   * @param variant Required. The resource being updated
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     Variant resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Variant, OperationMetadata> updateVariantAsync(
      Variant variant, FieldMask updateMask) {
    UpdateVariantRequest request =
        UpdateVariantRequest.newBuilder().setVariant(variant).setUpdateMask(updateMask).build();
    return updateVariantAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Variant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   UpdateVariantRequest request =
   *       UpdateVariantRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setVariant(Variant.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Variant response = configDeliveryClient.updateVariantAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Variant, OperationMetadata> updateVariantAsync(
      UpdateVariantRequest request) {
    return updateVariantOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Variant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   UpdateVariantRequest request =
   *       UpdateVariantRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setVariant(Variant.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Variant, OperationMetadata> future =
   *       configDeliveryClient.updateVariantOperationCallable().futureCall(request);
   *   // Do something.
   *   Variant response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateVariantRequest, Variant, OperationMetadata>
      updateVariantOperationCallable() {
    return stub.updateVariantOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Variant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   UpdateVariantRequest request =
   *       UpdateVariantRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setVariant(Variant.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       configDeliveryClient.updateVariantCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateVariantRequest, Operation> updateVariantCallable() {
    return stub.updateVariantCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Variant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   VariantName name =
   *       VariantName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]", "[VARIANT]");
   *   configDeliveryClient.deleteVariantAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteVariantAsync(VariantName name) {
    DeleteVariantRequest request =
        DeleteVariantRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteVariantAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Variant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   String name =
   *       VariantName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]", "[VARIANT]")
   *           .toString();
   *   configDeliveryClient.deleteVariantAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteVariantAsync(String name) {
    DeleteVariantRequest request = DeleteVariantRequest.newBuilder().setName(name).build();
    return deleteVariantAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Variant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   DeleteVariantRequest request =
   *       DeleteVariantRequest.newBuilder()
   *           .setName(
   *               VariantName.of(
   *                       "[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]", "[VARIANT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   configDeliveryClient.deleteVariantAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteVariantAsync(
      DeleteVariantRequest request) {
    return deleteVariantOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Variant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   DeleteVariantRequest request =
   *       DeleteVariantRequest.newBuilder()
   *           .setName(
   *               VariantName.of(
   *                       "[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]", "[VARIANT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       configDeliveryClient.deleteVariantOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteVariantRequest, Empty, OperationMetadata>
      deleteVariantOperationCallable() {
    return stub.deleteVariantOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Variant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   DeleteVariantRequest request =
   *       DeleteVariantRequest.newBuilder()
   *           .setName(
   *               VariantName.of(
   *                       "[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]", "[VARIANT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       configDeliveryClient.deleteVariantCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteVariantRequest, Operation> deleteVariantCallable() {
    return stub.deleteVariantCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Rollouts in a given project, location, and Fleet Package.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   FleetPackageName parent = FleetPackageName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]");
   *   for (Rollout element : configDeliveryClient.listRollouts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListRolloutsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRolloutsPagedResponse listRollouts(FleetPackageName parent) {
    ListRolloutsRequest request =
        ListRolloutsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRollouts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Rollouts in a given project, location, and Fleet Package.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   String parent = FleetPackageName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]").toString();
   *   for (Rollout element : configDeliveryClient.listRollouts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListRolloutsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRolloutsPagedResponse listRollouts(String parent) {
    ListRolloutsRequest request = ListRolloutsRequest.newBuilder().setParent(parent).build();
    return listRollouts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Rollouts in a given project, location, and Fleet Package.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   ListRolloutsRequest request =
   *       ListRolloutsRequest.newBuilder()
   *           .setParent(
   *               FleetPackageName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Rollout element : configDeliveryClient.listRollouts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRolloutsPagedResponse listRollouts(ListRolloutsRequest request) {
    return listRolloutsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Rollouts in a given project, location, and Fleet Package.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   ListRolloutsRequest request =
   *       ListRolloutsRequest.newBuilder()
   *           .setParent(
   *               FleetPackageName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Rollout> future =
   *       configDeliveryClient.listRolloutsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Rollout element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRolloutsRequest, ListRolloutsPagedResponse>
      listRolloutsPagedCallable() {
    return stub.listRolloutsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Rollouts in a given project, location, and Fleet Package.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   ListRolloutsRequest request =
   *       ListRolloutsRequest.newBuilder()
   *           .setParent(
   *               FleetPackageName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListRolloutsResponse response = configDeliveryClient.listRolloutsCallable().call(request);
   *     for (Rollout element : response.getRolloutsList()) {
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
  public final UnaryCallable<ListRolloutsRequest, ListRolloutsResponse> listRolloutsCallable() {
    return stub.listRolloutsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   RolloutName name = RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]");
   *   Rollout response = configDeliveryClient.getRollout(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rollout getRollout(RolloutName name) {
    GetRolloutRequest request =
        GetRolloutRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRollout(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   String name =
   *       RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]").toString();
   *   Rollout response = configDeliveryClient.getRollout(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rollout getRollout(String name) {
    GetRolloutRequest request = GetRolloutRequest.newBuilder().setName(name).build();
    return getRollout(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   GetRolloutRequest request =
   *       GetRolloutRequest.newBuilder()
   *           .setName(
   *               RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]")
   *                   .toString())
   *           .build();
   *   Rollout response = configDeliveryClient.getRollout(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Rollout getRollout(GetRolloutRequest request) {
    return getRolloutCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   GetRolloutRequest request =
   *       GetRolloutRequest.newBuilder()
   *           .setName(
   *               RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Rollout> future = configDeliveryClient.getRolloutCallable().futureCall(request);
   *   // Do something.
   *   Rollout response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRolloutRequest, Rollout> getRolloutCallable() {
    return stub.getRolloutCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Suspend a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   RolloutName name = RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]");
   *   Rollout response = configDeliveryClient.suspendRolloutAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the Rollout.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Rollout, OperationMetadata> suspendRolloutAsync(RolloutName name) {
    SuspendRolloutRequest request =
        SuspendRolloutRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return suspendRolloutAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Suspend a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   String name =
   *       RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]").toString();
   *   Rollout response = configDeliveryClient.suspendRolloutAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the Rollout.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Rollout, OperationMetadata> suspendRolloutAsync(String name) {
    SuspendRolloutRequest request = SuspendRolloutRequest.newBuilder().setName(name).build();
    return suspendRolloutAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Suspend a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   SuspendRolloutRequest request =
   *       SuspendRolloutRequest.newBuilder()
   *           .setName(
   *               RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]")
   *                   .toString())
   *           .setReason("reason-934964668")
   *           .build();
   *   Rollout response = configDeliveryClient.suspendRolloutAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Rollout, OperationMetadata> suspendRolloutAsync(
      SuspendRolloutRequest request) {
    return suspendRolloutOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Suspend a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   SuspendRolloutRequest request =
   *       SuspendRolloutRequest.newBuilder()
   *           .setName(
   *               RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]")
   *                   .toString())
   *           .setReason("reason-934964668")
   *           .build();
   *   OperationFuture<Rollout, OperationMetadata> future =
   *       configDeliveryClient.suspendRolloutOperationCallable().futureCall(request);
   *   // Do something.
   *   Rollout response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SuspendRolloutRequest, Rollout, OperationMetadata>
      suspendRolloutOperationCallable() {
    return stub.suspendRolloutOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Suspend a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   SuspendRolloutRequest request =
   *       SuspendRolloutRequest.newBuilder()
   *           .setName(
   *               RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]")
   *                   .toString())
   *           .setReason("reason-934964668")
   *           .build();
   *   ApiFuture<Operation> future =
   *       configDeliveryClient.suspendRolloutCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SuspendRolloutRequest, Operation> suspendRolloutCallable() {
    return stub.suspendRolloutCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resume a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   RolloutName name = RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]");
   *   Rollout response = configDeliveryClient.resumeRolloutAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the Rollout.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Rollout, OperationMetadata> resumeRolloutAsync(RolloutName name) {
    ResumeRolloutRequest request =
        ResumeRolloutRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return resumeRolloutAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resume a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   String name =
   *       RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]").toString();
   *   Rollout response = configDeliveryClient.resumeRolloutAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the Rollout.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Rollout, OperationMetadata> resumeRolloutAsync(String name) {
    ResumeRolloutRequest request = ResumeRolloutRequest.newBuilder().setName(name).build();
    return resumeRolloutAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resume a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   ResumeRolloutRequest request =
   *       ResumeRolloutRequest.newBuilder()
   *           .setName(
   *               RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]")
   *                   .toString())
   *           .setReason("reason-934964668")
   *           .build();
   *   Rollout response = configDeliveryClient.resumeRolloutAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Rollout, OperationMetadata> resumeRolloutAsync(
      ResumeRolloutRequest request) {
    return resumeRolloutOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resume a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   ResumeRolloutRequest request =
   *       ResumeRolloutRequest.newBuilder()
   *           .setName(
   *               RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]")
   *                   .toString())
   *           .setReason("reason-934964668")
   *           .build();
   *   OperationFuture<Rollout, OperationMetadata> future =
   *       configDeliveryClient.resumeRolloutOperationCallable().futureCall(request);
   *   // Do something.
   *   Rollout response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ResumeRolloutRequest, Rollout, OperationMetadata>
      resumeRolloutOperationCallable() {
    return stub.resumeRolloutOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resume a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   ResumeRolloutRequest request =
   *       ResumeRolloutRequest.newBuilder()
   *           .setName(
   *               RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]")
   *                   .toString())
   *           .setReason("reason-934964668")
   *           .build();
   *   ApiFuture<Operation> future =
   *       configDeliveryClient.resumeRolloutCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ResumeRolloutRequest, Operation> resumeRolloutCallable() {
    return stub.resumeRolloutCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Abort a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   RolloutName name = RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]");
   *   Rollout response = configDeliveryClient.abortRolloutAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the Rollout.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Rollout, OperationMetadata> abortRolloutAsync(RolloutName name) {
    AbortRolloutRequest request =
        AbortRolloutRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return abortRolloutAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Abort a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   String name =
   *       RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]").toString();
   *   Rollout response = configDeliveryClient.abortRolloutAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the Rollout.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Rollout, OperationMetadata> abortRolloutAsync(String name) {
    AbortRolloutRequest request = AbortRolloutRequest.newBuilder().setName(name).build();
    return abortRolloutAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Abort a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   AbortRolloutRequest request =
   *       AbortRolloutRequest.newBuilder()
   *           .setName(
   *               RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]")
   *                   .toString())
   *           .setReason("reason-934964668")
   *           .build();
   *   Rollout response = configDeliveryClient.abortRolloutAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Rollout, OperationMetadata> abortRolloutAsync(
      AbortRolloutRequest request) {
    return abortRolloutOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Abort a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   AbortRolloutRequest request =
   *       AbortRolloutRequest.newBuilder()
   *           .setName(
   *               RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]")
   *                   .toString())
   *           .setReason("reason-934964668")
   *           .build();
   *   OperationFuture<Rollout, OperationMetadata> future =
   *       configDeliveryClient.abortRolloutOperationCallable().futureCall(request);
   *   // Do something.
   *   Rollout response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<AbortRolloutRequest, Rollout, OperationMetadata>
      abortRolloutOperationCallable() {
    return stub.abortRolloutOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Abort a Rollout.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   AbortRolloutRequest request =
   *       AbortRolloutRequest.newBuilder()
   *           .setName(
   *               RolloutName.of("[PROJECT]", "[LOCATION]", "[FLEET_PACKAGE]", "[ROLLOUT]")
   *                   .toString())
   *           .setReason("reason-934964668")
   *           .build();
   *   ApiFuture<Operation> future = configDeliveryClient.abortRolloutCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AbortRolloutRequest, Operation> abortRolloutCallable() {
    return stub.abortRolloutCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : configDeliveryClient.listLocations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLocationsPagedResponse listLocations(ListLocationsRequest request) {
    return listLocationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       configDeliveryClient.listLocationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Location element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return stub.listLocationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = configDeliveryClient.listLocationsCallable().call(request);
   *     for (Location element : response.getLocationsList()) {
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
  public final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return stub.listLocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = configDeliveryClient.getLocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Location getLocation(GetLocationRequest request) {
    return getLocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = configDeliveryClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
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

  public static class ListResourceBundlesPagedResponse
      extends AbstractPagedListResponse<
          ListResourceBundlesRequest,
          ListResourceBundlesResponse,
          ResourceBundle,
          ListResourceBundlesPage,
          ListResourceBundlesFixedSizeCollection> {

    public static ApiFuture<ListResourceBundlesPagedResponse> createAsync(
        PageContext<ListResourceBundlesRequest, ListResourceBundlesResponse, ResourceBundle>
            context,
        ApiFuture<ListResourceBundlesResponse> futureResponse) {
      ApiFuture<ListResourceBundlesPage> futurePage =
          ListResourceBundlesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListResourceBundlesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListResourceBundlesPagedResponse(ListResourceBundlesPage page) {
      super(page, ListResourceBundlesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListResourceBundlesPage
      extends AbstractPage<
          ListResourceBundlesRequest,
          ListResourceBundlesResponse,
          ResourceBundle,
          ListResourceBundlesPage> {

    private ListResourceBundlesPage(
        PageContext<ListResourceBundlesRequest, ListResourceBundlesResponse, ResourceBundle>
            context,
        ListResourceBundlesResponse response) {
      super(context, response);
    }

    private static ListResourceBundlesPage createEmptyPage() {
      return new ListResourceBundlesPage(null, null);
    }

    @Override
    protected ListResourceBundlesPage createPage(
        PageContext<ListResourceBundlesRequest, ListResourceBundlesResponse, ResourceBundle>
            context,
        ListResourceBundlesResponse response) {
      return new ListResourceBundlesPage(context, response);
    }

    @Override
    public ApiFuture<ListResourceBundlesPage> createPageAsync(
        PageContext<ListResourceBundlesRequest, ListResourceBundlesResponse, ResourceBundle>
            context,
        ApiFuture<ListResourceBundlesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListResourceBundlesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListResourceBundlesRequest,
          ListResourceBundlesResponse,
          ResourceBundle,
          ListResourceBundlesPage,
          ListResourceBundlesFixedSizeCollection> {

    private ListResourceBundlesFixedSizeCollection(
        List<ListResourceBundlesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListResourceBundlesFixedSizeCollection createEmptyCollection() {
      return new ListResourceBundlesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListResourceBundlesFixedSizeCollection createCollection(
        List<ListResourceBundlesPage> pages, int collectionSize) {
      return new ListResourceBundlesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListFleetPackagesPagedResponse
      extends AbstractPagedListResponse<
          ListFleetPackagesRequest,
          ListFleetPackagesResponse,
          FleetPackage,
          ListFleetPackagesPage,
          ListFleetPackagesFixedSizeCollection> {

    public static ApiFuture<ListFleetPackagesPagedResponse> createAsync(
        PageContext<ListFleetPackagesRequest, ListFleetPackagesResponse, FleetPackage> context,
        ApiFuture<ListFleetPackagesResponse> futureResponse) {
      ApiFuture<ListFleetPackagesPage> futurePage =
          ListFleetPackagesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListFleetPackagesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListFleetPackagesPagedResponse(ListFleetPackagesPage page) {
      super(page, ListFleetPackagesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFleetPackagesPage
      extends AbstractPage<
          ListFleetPackagesRequest,
          ListFleetPackagesResponse,
          FleetPackage,
          ListFleetPackagesPage> {

    private ListFleetPackagesPage(
        PageContext<ListFleetPackagesRequest, ListFleetPackagesResponse, FleetPackage> context,
        ListFleetPackagesResponse response) {
      super(context, response);
    }

    private static ListFleetPackagesPage createEmptyPage() {
      return new ListFleetPackagesPage(null, null);
    }

    @Override
    protected ListFleetPackagesPage createPage(
        PageContext<ListFleetPackagesRequest, ListFleetPackagesResponse, FleetPackage> context,
        ListFleetPackagesResponse response) {
      return new ListFleetPackagesPage(context, response);
    }

    @Override
    public ApiFuture<ListFleetPackagesPage> createPageAsync(
        PageContext<ListFleetPackagesRequest, ListFleetPackagesResponse, FleetPackage> context,
        ApiFuture<ListFleetPackagesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFleetPackagesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFleetPackagesRequest,
          ListFleetPackagesResponse,
          FleetPackage,
          ListFleetPackagesPage,
          ListFleetPackagesFixedSizeCollection> {

    private ListFleetPackagesFixedSizeCollection(
        List<ListFleetPackagesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFleetPackagesFixedSizeCollection createEmptyCollection() {
      return new ListFleetPackagesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFleetPackagesFixedSizeCollection createCollection(
        List<ListFleetPackagesPage> pages, int collectionSize) {
      return new ListFleetPackagesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListReleasesPagedResponse
      extends AbstractPagedListResponse<
          ListReleasesRequest,
          ListReleasesResponse,
          Release,
          ListReleasesPage,
          ListReleasesFixedSizeCollection> {

    public static ApiFuture<ListReleasesPagedResponse> createAsync(
        PageContext<ListReleasesRequest, ListReleasesResponse, Release> context,
        ApiFuture<ListReleasesResponse> futureResponse) {
      ApiFuture<ListReleasesPage> futurePage =
          ListReleasesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListReleasesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListReleasesPagedResponse(ListReleasesPage page) {
      super(page, ListReleasesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListReleasesPage
      extends AbstractPage<ListReleasesRequest, ListReleasesResponse, Release, ListReleasesPage> {

    private ListReleasesPage(
        PageContext<ListReleasesRequest, ListReleasesResponse, Release> context,
        ListReleasesResponse response) {
      super(context, response);
    }

    private static ListReleasesPage createEmptyPage() {
      return new ListReleasesPage(null, null);
    }

    @Override
    protected ListReleasesPage createPage(
        PageContext<ListReleasesRequest, ListReleasesResponse, Release> context,
        ListReleasesResponse response) {
      return new ListReleasesPage(context, response);
    }

    @Override
    public ApiFuture<ListReleasesPage> createPageAsync(
        PageContext<ListReleasesRequest, ListReleasesResponse, Release> context,
        ApiFuture<ListReleasesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListReleasesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListReleasesRequest,
          ListReleasesResponse,
          Release,
          ListReleasesPage,
          ListReleasesFixedSizeCollection> {

    private ListReleasesFixedSizeCollection(List<ListReleasesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListReleasesFixedSizeCollection createEmptyCollection() {
      return new ListReleasesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListReleasesFixedSizeCollection createCollection(
        List<ListReleasesPage> pages, int collectionSize) {
      return new ListReleasesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListVariantsPagedResponse
      extends AbstractPagedListResponse<
          ListVariantsRequest,
          ListVariantsResponse,
          Variant,
          ListVariantsPage,
          ListVariantsFixedSizeCollection> {

    public static ApiFuture<ListVariantsPagedResponse> createAsync(
        PageContext<ListVariantsRequest, ListVariantsResponse, Variant> context,
        ApiFuture<ListVariantsResponse> futureResponse) {
      ApiFuture<ListVariantsPage> futurePage =
          ListVariantsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListVariantsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListVariantsPagedResponse(ListVariantsPage page) {
      super(page, ListVariantsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListVariantsPage
      extends AbstractPage<ListVariantsRequest, ListVariantsResponse, Variant, ListVariantsPage> {

    private ListVariantsPage(
        PageContext<ListVariantsRequest, ListVariantsResponse, Variant> context,
        ListVariantsResponse response) {
      super(context, response);
    }

    private static ListVariantsPage createEmptyPage() {
      return new ListVariantsPage(null, null);
    }

    @Override
    protected ListVariantsPage createPage(
        PageContext<ListVariantsRequest, ListVariantsResponse, Variant> context,
        ListVariantsResponse response) {
      return new ListVariantsPage(context, response);
    }

    @Override
    public ApiFuture<ListVariantsPage> createPageAsync(
        PageContext<ListVariantsRequest, ListVariantsResponse, Variant> context,
        ApiFuture<ListVariantsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListVariantsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListVariantsRequest,
          ListVariantsResponse,
          Variant,
          ListVariantsPage,
          ListVariantsFixedSizeCollection> {

    private ListVariantsFixedSizeCollection(List<ListVariantsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListVariantsFixedSizeCollection createEmptyCollection() {
      return new ListVariantsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListVariantsFixedSizeCollection createCollection(
        List<ListVariantsPage> pages, int collectionSize) {
      return new ListVariantsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRolloutsPagedResponse
      extends AbstractPagedListResponse<
          ListRolloutsRequest,
          ListRolloutsResponse,
          Rollout,
          ListRolloutsPage,
          ListRolloutsFixedSizeCollection> {

    public static ApiFuture<ListRolloutsPagedResponse> createAsync(
        PageContext<ListRolloutsRequest, ListRolloutsResponse, Rollout> context,
        ApiFuture<ListRolloutsResponse> futureResponse) {
      ApiFuture<ListRolloutsPage> futurePage =
          ListRolloutsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRolloutsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRolloutsPagedResponse(ListRolloutsPage page) {
      super(page, ListRolloutsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRolloutsPage
      extends AbstractPage<ListRolloutsRequest, ListRolloutsResponse, Rollout, ListRolloutsPage> {

    private ListRolloutsPage(
        PageContext<ListRolloutsRequest, ListRolloutsResponse, Rollout> context,
        ListRolloutsResponse response) {
      super(context, response);
    }

    private static ListRolloutsPage createEmptyPage() {
      return new ListRolloutsPage(null, null);
    }

    @Override
    protected ListRolloutsPage createPage(
        PageContext<ListRolloutsRequest, ListRolloutsResponse, Rollout> context,
        ListRolloutsResponse response) {
      return new ListRolloutsPage(context, response);
    }

    @Override
    public ApiFuture<ListRolloutsPage> createPageAsync(
        PageContext<ListRolloutsRequest, ListRolloutsResponse, Rollout> context,
        ApiFuture<ListRolloutsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRolloutsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRolloutsRequest,
          ListRolloutsResponse,
          Rollout,
          ListRolloutsPage,
          ListRolloutsFixedSizeCollection> {

    private ListRolloutsFixedSizeCollection(List<ListRolloutsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRolloutsFixedSizeCollection createEmptyCollection() {
      return new ListRolloutsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRolloutsFixedSizeCollection createCollection(
        List<ListRolloutsPage> pages, int collectionSize) {
      return new ListRolloutsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLocationsPagedResponse
      extends AbstractPagedListResponse<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    public static ApiFuture<ListLocationsPagedResponse> createAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      ApiFuture<ListLocationsPage> futurePage =
          ListLocationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLocationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLocationsPagedResponse(ListLocationsPage page) {
      super(page, ListLocationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLocationsPage
      extends AbstractPage<
          ListLocationsRequest, ListLocationsResponse, Location, ListLocationsPage> {

    private ListLocationsPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLocationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    private ListLocationsFixedSizeCollection(List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
