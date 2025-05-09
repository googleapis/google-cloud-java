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

package com.google.cloud.apihub.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apihub.v1.stub.ApiHubStub;
import com.google.cloud.apihub.v1.stub.ApiHubStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: This service provides all methods related to the API hub.
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
 * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   Api api = Api.newBuilder().build();
 *   String apiId = "apiId93021397";
 *   Api response = apiHubClient.createApi(parent, api, apiId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ApiHubClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> CreateApi</td>
 *      <td><p> Create an API resource in the API hub. Once an API resource is created, versions can be added to it.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createApi(CreateApiRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createApi(LocationName parent, Api api, String apiId)
 *           <li><p> createApi(String parent, Api api, String apiId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createApiCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetApi</td>
 *      <td><p> Get API resource details including the API versions contained in it.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getApi(GetApiRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getApi(ApiName name)
 *           <li><p> getApi(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getApiCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListApis</td>
 *      <td><p> List API resources in the API hub.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listApis(ListApisRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listApis(LocationName parent)
 *           <li><p> listApis(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listApisPagedCallable()
 *           <li><p> listApisCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateApi</td>
 *      <td><p> Update an API resource in the API hub. The following fields in the [API][] can be updated:
 * <ul>
 * <li>  [display_name][google.cloud.apihub.v1.Api.display_name]
 * <li>  [description][google.cloud.apihub.v1.Api.description]
 * <li>  [owner][google.cloud.apihub.v1.Api.owner]
 * <li>  [documentation][google.cloud.apihub.v1.Api.documentation]
 * <li>  [target_user][google.cloud.apihub.v1.Api.target_user]
 * <li>  [team][google.cloud.apihub.v1.Api.team]
 * <li>  [business_unit][google.cloud.apihub.v1.Api.business_unit]
 * <li>  [maturity_level][google.cloud.apihub.v1.Api.maturity_level]
 * <li>  [attributes][google.cloud.apihub.v1.Api.attributes]
 * </ul>
 * <p>  The [update_mask][google.cloud.apihub.v1.UpdateApiRequest.update_mask] should be used to specify the fields being updated.
 * <p>  Updating the owner field requires complete owner message and updates both owner and email fields.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateApi(UpdateApiRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateApi(Api api, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateApiCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteApi</td>
 *      <td><p> Delete an API resource in the API hub. API can only be deleted if all underlying versions are deleted.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteApi(DeleteApiRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteApi(ApiName name)
 *           <li><p> deleteApi(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteApiCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateVersion</td>
 *      <td><p> Create an API version for an API resource in the API hub.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createVersion(CreateVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createVersion(ApiName parent, Version version, String versionId)
 *           <li><p> createVersion(String parent, Version version, String versionId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetVersion</td>
 *      <td><p> Get details about the API version of an API resource. This will include information about the specs and operations present in the API version as well as the deployments linked to it.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getVersion(GetVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getVersion(VersionName name)
 *           <li><p> getVersion(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListVersions</td>
 *      <td><p> List API versions of an API resource in the API hub.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listVersions(ListVersionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listVersions(ApiName parent)
 *           <li><p> listVersions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listVersionsPagedCallable()
 *           <li><p> listVersionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateVersion</td>
 *      <td><p> Update API version. The following fields in the [version][google.cloud.apihub.v1.Version] can be updated currently:
 * <ul>
 * <li>  [display_name][google.cloud.apihub.v1.Version.display_name]
 * <li>  [description][google.cloud.apihub.v1.Version.description]
 * <li>  [documentation][google.cloud.apihub.v1.Version.documentation]
 * <li>  [deployments][google.cloud.apihub.v1.Version.deployments]
 * <li>  [lifecycle][google.cloud.apihub.v1.Version.lifecycle]
 * <li>  [compliance][google.cloud.apihub.v1.Version.compliance]
 * <li>  [accreditation][google.cloud.apihub.v1.Version.accreditation]
 * <li>  [attributes][google.cloud.apihub.v1.Version.attributes]
 * </ul>
 * <p>  The [update_mask][google.cloud.apihub.v1.UpdateVersionRequest.update_mask] should be used to specify the fields being updated.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateVersion(UpdateVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateVersion(Version version, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteVersion</td>
 *      <td><p> Delete an API version. Version can only be deleted if all underlying specs, operations, definitions and linked deployments are deleted.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteVersion(DeleteVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteVersion(VersionName name)
 *           <li><p> deleteVersion(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSpec</td>
 *      <td><p> Add a spec to an API version in the API hub. Multiple specs can be added to an API version. Note, while adding a spec, at least one of `contents` or `source_uri` must be provided. If `contents` is provided, then `spec_type` must also be provided.
 * <p>  On adding a spec with contents to the version, the operations present in it will be added to the version.Note that the file contents in the spec should be of the same type as defined in the `projects/{project}/locations/{location}/attributes/system-spec-type` attribute associated with spec resource. Note that specs of various types can be uploaded, however parsing of details is supported for OpenAPI spec currently.
 * <p>  In order to access the information parsed from the spec, use the [GetSpec][google.cloud.apihub.v1.ApiHub.GetSpec] method. In order to access the raw contents for a particular spec, use the [GetSpecContents][google.cloud.apihub.v1.ApiHub.GetSpecContents] method. In order to access the operations parsed from the spec, use the [ListAPIOperations][google.cloud.apihub.v1.ApiHub.ListApiOperations] method.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSpec(CreateSpecRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createSpec(VersionName parent, Spec spec, String specId)
 *           <li><p> createSpec(String parent, Spec spec, String specId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSpecCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSpec</td>
 *      <td><p> Get details about the information parsed from a spec. Note that this method does not return the raw spec contents. Use [GetSpecContents][google.cloud.apihub.v1.ApiHub.GetSpecContents] method to retrieve the same.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSpec(GetSpecRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSpec(SpecName name)
 *           <li><p> getSpec(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSpecCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSpecContents</td>
 *      <td><p> Get spec contents.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSpecContents(GetSpecContentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSpecContents(SpecName name)
 *           <li><p> getSpecContents(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSpecContentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSpecs</td>
 *      <td><p> List specs corresponding to a particular API resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSpecs(ListSpecsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSpecs(VersionName parent)
 *           <li><p> listSpecs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSpecsPagedCallable()
 *           <li><p> listSpecsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSpec</td>
 *      <td><p> Update spec. The following fields in the [spec][google.cloud.apihub.v1.Spec] can be updated:
 * <ul>
 * <li>  [display_name][google.cloud.apihub.v1.Spec.display_name]
 * <li>  [source_uri][google.cloud.apihub.v1.Spec.source_uri]
 * <li>  [lint_response][google.cloud.apihub.v1.Spec.lint_response]
 * <li>  [attributes][google.cloud.apihub.v1.Spec.attributes]
 * <li>  [contents][google.cloud.apihub.v1.Spec.contents]
 * <li>  [spec_type][google.cloud.apihub.v1.Spec.spec_type]
 * </ul>
 * <p>  In case of an OAS spec, updating spec contents can lead to: 1. Creation, deletion and update of operations. 2. Creation, deletion and update of definitions. 3. Update of other info parsed out from the new spec.
 * <p>  In case of contents or source_uri being present in update mask, spec_type must also be present. Also, spec_type can not be present in update mask if contents or source_uri is not present.
 * <p>  The [update_mask][google.cloud.apihub.v1.UpdateSpecRequest.update_mask] should be used to specify the fields being updated.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSpec(UpdateSpecRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateSpec(Spec spec, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSpecCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSpec</td>
 *      <td><p> Delete a spec. Deleting a spec will also delete the associated operations from the version.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSpec(DeleteSpecRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteSpec(SpecName name)
 *           <li><p> deleteSpec(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSpecCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetApiOperation</td>
 *      <td><p> Get details about a particular operation in API version.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getApiOperation(GetApiOperationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getApiOperation(ApiOperationName name)
 *           <li><p> getApiOperation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getApiOperationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListApiOperations</td>
 *      <td><p> List operations in an API version.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listApiOperations(ListApiOperationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listApiOperations(VersionName parent)
 *           <li><p> listApiOperations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listApiOperationsPagedCallable()
 *           <li><p> listApiOperationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDefinition</td>
 *      <td><p> Get details about a definition in an API version.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDefinition(GetDefinitionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDefinition(DefinitionName name)
 *           <li><p> getDefinition(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDefinitionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateDeployment</td>
 *      <td><p> Create a deployment resource in the API hub. Once a deployment resource is created, it can be associated with API versions.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDeployment(CreateDeploymentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createDeployment(LocationName parent, Deployment deployment, String deploymentId)
 *           <li><p> createDeployment(String parent, Deployment deployment, String deploymentId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDeployment</td>
 *      <td><p> Get details about a deployment and the API versions linked to it.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDeployment(GetDeploymentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDeployment(DeploymentName name)
 *           <li><p> getDeployment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDeployments</td>
 *      <td><p> List deployment resources in the API hub.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDeployments(ListDeploymentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDeployments(LocationName parent)
 *           <li><p> listDeployments(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDeploymentsPagedCallable()
 *           <li><p> listDeploymentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDeployment</td>
 *      <td><p> Update a deployment resource in the API hub. The following fields in the [deployment resource][google.cloud.apihub.v1.Deployment] can be updated:
 * <ul>
 * <li>  [display_name][google.cloud.apihub.v1.Deployment.display_name]
 * <li>  [description][google.cloud.apihub.v1.Deployment.description]
 * <li>  [documentation][google.cloud.apihub.v1.Deployment.documentation]
 * <li>  [deployment_type][google.cloud.apihub.v1.Deployment.deployment_type]
 * <li>  [resource_uri][google.cloud.apihub.v1.Deployment.resource_uri]
 * <li>  [endpoints][google.cloud.apihub.v1.Deployment.endpoints]
 * <li>  [slo][google.cloud.apihub.v1.Deployment.slo]
 * <li>  [environment][google.cloud.apihub.v1.Deployment.environment]
 * <li>  [attributes][google.cloud.apihub.v1.Deployment.attributes]
 * </ul>
 * <p>  The [update_mask][google.cloud.apihub.v1.UpdateDeploymentRequest.update_mask] should be used to specify the fields being updated.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDeployment(UpdateDeploymentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateDeployment(Deployment deployment, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteDeployment</td>
 *      <td><p> Delete a deployment resource in the API hub.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteDeployment(DeleteDeploymentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteDeployment(DeploymentName name)
 *           <li><p> deleteDeployment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateAttribute</td>
 *      <td><p> Create a user defined attribute.
 * <p>  Certain pre defined attributes are already created by the API hub. These attributes will have type as `SYSTEM_DEFINED` and can be listed via [ListAttributes][google.cloud.apihub.v1.ApiHub.ListAttributes] method. Allowed values for the same can be updated via [UpdateAttribute][google.cloud.apihub.v1.ApiHub.UpdateAttribute] method.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAttribute(CreateAttributeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createAttribute(LocationName parent, Attribute attribute, String attributeId)
 *           <li><p> createAttribute(String parent, Attribute attribute, String attributeId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAttributeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAttribute</td>
 *      <td><p> Get details about the attribute.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAttribute(GetAttributeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAttribute(AttributeName name)
 *           <li><p> getAttribute(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAttributeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateAttribute</td>
 *      <td><p> Update the attribute.  The following fields in the [Attribute resource][google.cloud.apihub.v1.Attribute] can be updated:
 * <ul>
 * <li>  [display_name][google.cloud.apihub.v1.Attribute.display_name] The display name can be updated for user defined attributes only.
 * <li>  [description][google.cloud.apihub.v1.Attribute.description] The description can be updated for user defined attributes only.
 * <li>  [allowed_values][google.cloud.apihub.v1.Attribute.allowed_values] To update the list of allowed values, clients need to use the fetched list of allowed values and add or remove values to or from the same list. The mutable allowed values can be updated for both user defined and System defined attributes. The immutable allowed values cannot be updated or deleted. The updated list of allowed values cannot be empty. If an allowed value that is already used by some resource's attribute is deleted, then the association between the resource and the attribute value will also be deleted.
 * <li>  [cardinality][google.cloud.apihub.v1.Attribute.cardinality] The cardinality can be updated for user defined attributes only. Cardinality can only be increased during an update.
 * </ul>
 * <p>  The [update_mask][google.cloud.apihub.v1.UpdateAttributeRequest.update_mask] should be used to specify the fields being updated.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAttribute(UpdateAttributeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateAttribute(Attribute attribute, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAttributeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteAttribute</td>
 *      <td><p> Delete an attribute.
 * <p>  Note: System defined attributes cannot be deleted. All associations of the attribute being deleted with any API hub resource will also get deleted.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAttribute(DeleteAttributeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteAttribute(AttributeName name)
 *           <li><p> deleteAttribute(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteAttributeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAttributes</td>
 *      <td><p> List all attributes.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAttributes(ListAttributesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAttributes(LocationName parent)
 *           <li><p> listAttributes(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAttributesPagedCallable()
 *           <li><p> listAttributesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SearchResources</td>
 *      <td><p> Search across API-Hub resources.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchResources(SearchResourcesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> searchResources(LocationName location, String query)
 *           <li><p> searchResources(String location, String query)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchResourcesPagedCallable()
 *           <li><p> searchResourcesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateExternalApi</td>
 *      <td><p> Create an External API resource in the API hub.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createExternalApi(CreateExternalApiRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createExternalApi(LocationName parent, ExternalApi externalApi, String externalApiId)
 *           <li><p> createExternalApi(String parent, ExternalApi externalApi, String externalApiId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createExternalApiCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetExternalApi</td>
 *      <td><p> Get details about an External API resource in the API hub.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getExternalApi(GetExternalApiRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getExternalApi(ExternalApiName name)
 *           <li><p> getExternalApi(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getExternalApiCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateExternalApi</td>
 *      <td><p> Update an External API resource in the API hub. The following fields can be updated:
 * <ul>
 * <li>  [display_name][google.cloud.apihub.v1.ExternalApi.display_name]
 * <li>  [description][google.cloud.apihub.v1.ExternalApi.description]
 * <li>  [documentation][google.cloud.apihub.v1.ExternalApi.documentation]
 * <li>  [endpoints][google.cloud.apihub.v1.ExternalApi.endpoints]
 * <li>  [paths][google.cloud.apihub.v1.ExternalApi.paths]
 * </ul>
 * <p>  The [update_mask][google.cloud.apihub.v1.UpdateExternalApiRequest.update_mask] should be used to specify the fields being updated.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateExternalApi(UpdateExternalApiRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateExternalApi(ExternalApi externalApi, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateExternalApiCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteExternalApi</td>
 *      <td><p> Delete an External API resource in the API hub.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteExternalApi(DeleteExternalApiRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteExternalApi(ExternalApiName name)
 *           <li><p> deleteExternalApi(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteExternalApiCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListExternalApis</td>
 *      <td><p> List External API resources in the API hub.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listExternalApis(ListExternalApisRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listExternalApis(LocationName parent)
 *           <li><p> listExternalApis(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listExternalApisPagedCallable()
 *           <li><p> listExternalApisCallable()
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
 * <p>This class can be customized by passing in a custom instance of ApiHubSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ApiHubSettings apiHubSettings =
 *     ApiHubSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ApiHubClient apiHubClient = ApiHubClient.create(apiHubSettings);
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
 * ApiHubSettings apiHubSettings = ApiHubSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ApiHubClient apiHubClient = ApiHubClient.create(apiHubSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ApiHubClient implements BackgroundResource {
  private final ApiHubSettings settings;
  private final ApiHubStub stub;

  /** Constructs an instance of ApiHubClient with default settings. */
  public static final ApiHubClient create() throws IOException {
    return create(ApiHubSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ApiHubClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ApiHubClient create(ApiHubSettings settings) throws IOException {
    return new ApiHubClient(settings);
  }

  /**
   * Constructs an instance of ApiHubClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(ApiHubSettings).
   */
  public static final ApiHubClient create(ApiHubStub stub) {
    return new ApiHubClient(stub);
  }

  /**
   * Constructs an instance of ApiHubClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected ApiHubClient(ApiHubSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ApiHubStubSettings) settings.getStubSettings()).createStub();
  }

  protected ApiHubClient(ApiHubStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ApiHubSettings getSettings() {
    return settings;
  }

  public ApiHubStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an API resource in the API hub. Once an API resource is created, versions can be added
   * to it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Api api = Api.newBuilder().build();
   *   String apiId = "apiId93021397";
   *   Api response = apiHubClient.createApi(parent, api, apiId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource for the API resource. Format:
   *     `projects/{project}/locations/{location}`
   * @param api Required. The API resource to create.
   * @param apiId Optional. The ID to use for the API resource, which will become the final
   *     component of the API's resource name. This field is optional.
   *     <ul>
   *       <li>If provided, the same will be used. The service will throw an error if the specified
   *           id is already used by another API resource in the API hub.
   *       <li>If not provided, a system generated id will be used.
   *     </ul>
   *     <p>This value should be 4-500 characters, and valid characters are /[a-z][A-Z][0-9]-_/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Api createApi(LocationName parent, Api api, String apiId) {
    CreateApiRequest request =
        CreateApiRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setApi(api)
            .setApiId(apiId)
            .build();
    return createApi(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an API resource in the API hub. Once an API resource is created, versions can be added
   * to it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Api api = Api.newBuilder().build();
   *   String apiId = "apiId93021397";
   *   Api response = apiHubClient.createApi(parent, api, apiId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource for the API resource. Format:
   *     `projects/{project}/locations/{location}`
   * @param api Required. The API resource to create.
   * @param apiId Optional. The ID to use for the API resource, which will become the final
   *     component of the API's resource name. This field is optional.
   *     <ul>
   *       <li>If provided, the same will be used. The service will throw an error if the specified
   *           id is already used by another API resource in the API hub.
   *       <li>If not provided, a system generated id will be used.
   *     </ul>
   *     <p>This value should be 4-500 characters, and valid characters are /[a-z][A-Z][0-9]-_/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Api createApi(String parent, Api api, String apiId) {
    CreateApiRequest request =
        CreateApiRequest.newBuilder().setParent(parent).setApi(api).setApiId(apiId).build();
    return createApi(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an API resource in the API hub. Once an API resource is created, versions can be added
   * to it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   CreateApiRequest request =
   *       CreateApiRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setApiId("apiId93021397")
   *           .setApi(Api.newBuilder().build())
   *           .build();
   *   Api response = apiHubClient.createApi(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Api createApi(CreateApiRequest request) {
    return createApiCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an API resource in the API hub. Once an API resource is created, versions can be added
   * to it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   CreateApiRequest request =
   *       CreateApiRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setApiId("apiId93021397")
   *           .setApi(Api.newBuilder().build())
   *           .build();
   *   ApiFuture<Api> future = apiHubClient.createApiCallable().futureCall(request);
   *   // Do something.
   *   Api response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateApiRequest, Api> createApiCallable() {
    return stub.createApiCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get API resource details including the API versions contained in it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   ApiName name = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");
   *   Api response = apiHubClient.getApi(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the API resource to retrieve. Format:
   *     `projects/{project}/locations/{location}/apis/{api}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Api getApi(ApiName name) {
    GetApiRequest request =
        GetApiRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getApi(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get API resource details including the API versions contained in it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   String name = ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString();
   *   Api response = apiHubClient.getApi(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the API resource to retrieve. Format:
   *     `projects/{project}/locations/{location}/apis/{api}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Api getApi(String name) {
    GetApiRequest request = GetApiRequest.newBuilder().setName(name).build();
    return getApi(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get API resource details including the API versions contained in it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   GetApiRequest request =
   *       GetApiRequest.newBuilder()
   *           .setName(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
   *           .build();
   *   Api response = apiHubClient.getApi(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Api getApi(GetApiRequest request) {
    return getApiCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get API resource details including the API versions contained in it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   GetApiRequest request =
   *       GetApiRequest.newBuilder()
   *           .setName(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
   *           .build();
   *   ApiFuture<Api> future = apiHubClient.getApiCallable().futureCall(request);
   *   // Do something.
   *   Api response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetApiRequest, Api> getApiCallable() {
    return stub.getApiCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List API resources in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Api element : apiHubClient.listApis(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of API resources. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApisPagedResponse listApis(LocationName parent) {
    ListApisRequest request =
        ListApisRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listApis(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List API resources in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Api element : apiHubClient.listApis(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of API resources. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApisPagedResponse listApis(String parent) {
    ListApisRequest request = ListApisRequest.newBuilder().setParent(parent).build();
    return listApis(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List API resources in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   ListApisRequest request =
   *       ListApisRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Api element : apiHubClient.listApis(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApisPagedResponse listApis(ListApisRequest request) {
    return listApisPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List API resources in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   ListApisRequest request =
   *       ListApisRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Api> future = apiHubClient.listApisPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Api element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListApisRequest, ListApisPagedResponse> listApisPagedCallable() {
    return stub.listApisPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List API resources in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   ListApisRequest request =
   *       ListApisRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListApisResponse response = apiHubClient.listApisCallable().call(request);
   *     for (Api element : response.getApisList()) {
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
  public final UnaryCallable<ListApisRequest, ListApisResponse> listApisCallable() {
    return stub.listApisCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update an API resource in the API hub. The following fields in the [API][] can be updated:
   *
   * <ul>
   *   <li>[display_name][google.cloud.apihub.v1.Api.display_name]
   *   <li>[description][google.cloud.apihub.v1.Api.description]
   *   <li>[owner][google.cloud.apihub.v1.Api.owner]
   *   <li>[documentation][google.cloud.apihub.v1.Api.documentation]
   *   <li>[target_user][google.cloud.apihub.v1.Api.target_user]
   *   <li>[team][google.cloud.apihub.v1.Api.team]
   *   <li>[business_unit][google.cloud.apihub.v1.Api.business_unit]
   *   <li>[maturity_level][google.cloud.apihub.v1.Api.maturity_level]
   *   <li>[attributes][google.cloud.apihub.v1.Api.attributes]
   * </ul>
   *
   * <p>The [update_mask][google.cloud.apihub.v1.UpdateApiRequest.update_mask] should be used to
   * specify the fields being updated.
   *
   * <p>Updating the owner field requires complete owner message and updates both owner and email
   * fields.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   Api api = Api.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Api response = apiHubClient.updateApi(api, updateMask);
   * }
   * }</pre>
   *
   * @param api Required. The API resource to update.
   *     <p>The API resource's `name` field is used to identify the API resource to update. Format:
   *     `projects/{project}/locations/{location}/apis/{api}`
   * @param updateMask Required. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Api updateApi(Api api, FieldMask updateMask) {
    UpdateApiRequest request =
        UpdateApiRequest.newBuilder().setApi(api).setUpdateMask(updateMask).build();
    return updateApi(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update an API resource in the API hub. The following fields in the [API][] can be updated:
   *
   * <ul>
   *   <li>[display_name][google.cloud.apihub.v1.Api.display_name]
   *   <li>[description][google.cloud.apihub.v1.Api.description]
   *   <li>[owner][google.cloud.apihub.v1.Api.owner]
   *   <li>[documentation][google.cloud.apihub.v1.Api.documentation]
   *   <li>[target_user][google.cloud.apihub.v1.Api.target_user]
   *   <li>[team][google.cloud.apihub.v1.Api.team]
   *   <li>[business_unit][google.cloud.apihub.v1.Api.business_unit]
   *   <li>[maturity_level][google.cloud.apihub.v1.Api.maturity_level]
   *   <li>[attributes][google.cloud.apihub.v1.Api.attributes]
   * </ul>
   *
   * <p>The [update_mask][google.cloud.apihub.v1.UpdateApiRequest.update_mask] should be used to
   * specify the fields being updated.
   *
   * <p>Updating the owner field requires complete owner message and updates both owner and email
   * fields.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   UpdateApiRequest request =
   *       UpdateApiRequest.newBuilder()
   *           .setApi(Api.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Api response = apiHubClient.updateApi(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Api updateApi(UpdateApiRequest request) {
    return updateApiCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update an API resource in the API hub. The following fields in the [API][] can be updated:
   *
   * <ul>
   *   <li>[display_name][google.cloud.apihub.v1.Api.display_name]
   *   <li>[description][google.cloud.apihub.v1.Api.description]
   *   <li>[owner][google.cloud.apihub.v1.Api.owner]
   *   <li>[documentation][google.cloud.apihub.v1.Api.documentation]
   *   <li>[target_user][google.cloud.apihub.v1.Api.target_user]
   *   <li>[team][google.cloud.apihub.v1.Api.team]
   *   <li>[business_unit][google.cloud.apihub.v1.Api.business_unit]
   *   <li>[maturity_level][google.cloud.apihub.v1.Api.maturity_level]
   *   <li>[attributes][google.cloud.apihub.v1.Api.attributes]
   * </ul>
   *
   * <p>The [update_mask][google.cloud.apihub.v1.UpdateApiRequest.update_mask] should be used to
   * specify the fields being updated.
   *
   * <p>Updating the owner field requires complete owner message and updates both owner and email
   * fields.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   UpdateApiRequest request =
   *       UpdateApiRequest.newBuilder()
   *           .setApi(Api.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Api> future = apiHubClient.updateApiCallable().futureCall(request);
   *   // Do something.
   *   Api response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateApiRequest, Api> updateApiCallable() {
    return stub.updateApiCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an API resource in the API hub. API can only be deleted if all underlying versions are
   * deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   ApiName name = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");
   *   apiHubClient.deleteApi(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the API resource to delete. Format:
   *     `projects/{project}/locations/{location}/apis/{api}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteApi(ApiName name) {
    DeleteApiRequest request =
        DeleteApiRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteApi(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an API resource in the API hub. API can only be deleted if all underlying versions are
   * deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   String name = ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString();
   *   apiHubClient.deleteApi(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the API resource to delete. Format:
   *     `projects/{project}/locations/{location}/apis/{api}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteApi(String name) {
    DeleteApiRequest request = DeleteApiRequest.newBuilder().setName(name).build();
    deleteApi(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an API resource in the API hub. API can only be deleted if all underlying versions are
   * deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   DeleteApiRequest request =
   *       DeleteApiRequest.newBuilder()
   *           .setName(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
   *           .setForce(true)
   *           .build();
   *   apiHubClient.deleteApi(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteApi(DeleteApiRequest request) {
    deleteApiCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an API resource in the API hub. API can only be deleted if all underlying versions are
   * deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   DeleteApiRequest request =
   *       DeleteApiRequest.newBuilder()
   *           .setName(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future = apiHubClient.deleteApiCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteApiRequest, Empty> deleteApiCallable() {
    return stub.deleteApiCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an API version for an API resource in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   ApiName parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");
   *   Version version = Version.newBuilder().build();
   *   String versionId = "versionId-1407102957";
   *   Version response = apiHubClient.createVersion(parent, version, versionId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource for API version. Format:
   *     `projects/{project}/locations/{location}/apis/{api}`
   * @param version Required. The version to create.
   * @param versionId Optional. The ID to use for the API version, which will become the final
   *     component of the version's resource name. This field is optional.
   *     <ul>
   *       <li>If provided, the same will be used. The service will throw an error if the specified
   *           id is already used by another version in the API resource.
   *       <li>If not provided, a system generated id will be used.
   *     </ul>
   *     <p>This value should be 4-500 characters, and valid characters are /[a-z][A-Z][0-9]-_/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Version createVersion(ApiName parent, Version version, String versionId) {
    CreateVersionRequest request =
        CreateVersionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setVersion(version)
            .setVersionId(versionId)
            .build();
    return createVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an API version for an API resource in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   String parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString();
   *   Version version = Version.newBuilder().build();
   *   String versionId = "versionId-1407102957";
   *   Version response = apiHubClient.createVersion(parent, version, versionId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource for API version. Format:
   *     `projects/{project}/locations/{location}/apis/{api}`
   * @param version Required. The version to create.
   * @param versionId Optional. The ID to use for the API version, which will become the final
   *     component of the version's resource name. This field is optional.
   *     <ul>
   *       <li>If provided, the same will be used. The service will throw an error if the specified
   *           id is already used by another version in the API resource.
   *       <li>If not provided, a system generated id will be used.
   *     </ul>
   *     <p>This value should be 4-500 characters, and valid characters are /[a-z][A-Z][0-9]-_/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Version createVersion(String parent, Version version, String versionId) {
    CreateVersionRequest request =
        CreateVersionRequest.newBuilder()
            .setParent(parent)
            .setVersion(version)
            .setVersionId(versionId)
            .build();
    return createVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an API version for an API resource in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   CreateVersionRequest request =
   *       CreateVersionRequest.newBuilder()
   *           .setParent(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
   *           .setVersionId("versionId-1407102957")
   *           .setVersion(Version.newBuilder().build())
   *           .build();
   *   Version response = apiHubClient.createVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Version createVersion(CreateVersionRequest request) {
    return createVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an API version for an API resource in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   CreateVersionRequest request =
   *       CreateVersionRequest.newBuilder()
   *           .setParent(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
   *           .setVersionId("versionId-1407102957")
   *           .setVersion(Version.newBuilder().build())
   *           .build();
   *   ApiFuture<Version> future = apiHubClient.createVersionCallable().futureCall(request);
   *   // Do something.
   *   Version response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateVersionRequest, Version> createVersionCallable() {
    return stub.createVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about the API version of an API resource. This will include information about the
   * specs and operations present in the API version as well as the deployments linked to it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   VersionName name = VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");
   *   Version response = apiHubClient.getVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the API version to retrieve. Format:
   *     `projects/{project}/locations/{location}/apis/{api}/versions/{version}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Version getVersion(VersionName name) {
    GetVersionRequest request =
        GetVersionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about the API version of an API resource. This will include information about the
   * specs and operations present in the API version as well as the deployments linked to it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   String name = VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString();
   *   Version response = apiHubClient.getVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the API version to retrieve. Format:
   *     `projects/{project}/locations/{location}/apis/{api}/versions/{version}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Version getVersion(String name) {
    GetVersionRequest request = GetVersionRequest.newBuilder().setName(name).build();
    return getVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about the API version of an API resource. This will include information about the
   * specs and operations present in the API version as well as the deployments linked to it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   GetVersionRequest request =
   *       GetVersionRequest.newBuilder()
   *           .setName(VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
   *           .build();
   *   Version response = apiHubClient.getVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Version getVersion(GetVersionRequest request) {
    return getVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about the API version of an API resource. This will include information about the
   * specs and operations present in the API version as well as the deployments linked to it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   GetVersionRequest request =
   *       GetVersionRequest.newBuilder()
   *           .setName(VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
   *           .build();
   *   ApiFuture<Version> future = apiHubClient.getVersionCallable().futureCall(request);
   *   // Do something.
   *   Version response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetVersionRequest, Version> getVersionCallable() {
    return stub.getVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List API versions of an API resource in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   ApiName parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");
   *   for (Version element : apiHubClient.listVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent which owns this collection of API versions i.e., the API
   *     resource Format: `projects/{project}/locations/{location}/apis/{api}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVersionsPagedResponse listVersions(ApiName parent) {
    ListVersionsRequest request =
        ListVersionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List API versions of an API resource in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   String parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString();
   *   for (Version element : apiHubClient.listVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent which owns this collection of API versions i.e., the API
   *     resource Format: `projects/{project}/locations/{location}/apis/{api}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVersionsPagedResponse listVersions(String parent) {
    ListVersionsRequest request = ListVersionsRequest.newBuilder().setParent(parent).build();
    return listVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List API versions of an API resource in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   ListVersionsRequest request =
   *       ListVersionsRequest.newBuilder()
   *           .setParent(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Version element : apiHubClient.listVersions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVersionsPagedResponse listVersions(ListVersionsRequest request) {
    return listVersionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List API versions of an API resource in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   ListVersionsRequest request =
   *       ListVersionsRequest.newBuilder()
   *           .setParent(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Version> future = apiHubClient.listVersionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Version element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListVersionsRequest, ListVersionsPagedResponse>
      listVersionsPagedCallable() {
    return stub.listVersionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List API versions of an API resource in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   ListVersionsRequest request =
   *       ListVersionsRequest.newBuilder()
   *           .setParent(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListVersionsResponse response = apiHubClient.listVersionsCallable().call(request);
   *     for (Version element : response.getVersionsList()) {
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
  public final UnaryCallable<ListVersionsRequest, ListVersionsResponse> listVersionsCallable() {
    return stub.listVersionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update API version. The following fields in the [version][google.cloud.apihub.v1.Version] can
   * be updated currently:
   *
   * <ul>
   *   <li>[display_name][google.cloud.apihub.v1.Version.display_name]
   *   <li>[description][google.cloud.apihub.v1.Version.description]
   *   <li>[documentation][google.cloud.apihub.v1.Version.documentation]
   *   <li>[deployments][google.cloud.apihub.v1.Version.deployments]
   *   <li>[lifecycle][google.cloud.apihub.v1.Version.lifecycle]
   *   <li>[compliance][google.cloud.apihub.v1.Version.compliance]
   *   <li>[accreditation][google.cloud.apihub.v1.Version.accreditation]
   *   <li>[attributes][google.cloud.apihub.v1.Version.attributes]
   * </ul>
   *
   * <p>The [update_mask][google.cloud.apihub.v1.UpdateVersionRequest.update_mask] should be used to
   * specify the fields being updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   Version version = Version.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Version response = apiHubClient.updateVersion(version, updateMask);
   * }
   * }</pre>
   *
   * @param version Required. The API version to update.
   *     <p>The version's `name` field is used to identify the API version to update. Format:
   *     `projects/{project}/locations/{location}/apis/{api}/versions/{version}`
   * @param updateMask Required. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Version updateVersion(Version version, FieldMask updateMask) {
    UpdateVersionRequest request =
        UpdateVersionRequest.newBuilder().setVersion(version).setUpdateMask(updateMask).build();
    return updateVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update API version. The following fields in the [version][google.cloud.apihub.v1.Version] can
   * be updated currently:
   *
   * <ul>
   *   <li>[display_name][google.cloud.apihub.v1.Version.display_name]
   *   <li>[description][google.cloud.apihub.v1.Version.description]
   *   <li>[documentation][google.cloud.apihub.v1.Version.documentation]
   *   <li>[deployments][google.cloud.apihub.v1.Version.deployments]
   *   <li>[lifecycle][google.cloud.apihub.v1.Version.lifecycle]
   *   <li>[compliance][google.cloud.apihub.v1.Version.compliance]
   *   <li>[accreditation][google.cloud.apihub.v1.Version.accreditation]
   *   <li>[attributes][google.cloud.apihub.v1.Version.attributes]
   * </ul>
   *
   * <p>The [update_mask][google.cloud.apihub.v1.UpdateVersionRequest.update_mask] should be used to
   * specify the fields being updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   UpdateVersionRequest request =
   *       UpdateVersionRequest.newBuilder()
   *           .setVersion(Version.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Version response = apiHubClient.updateVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Version updateVersion(UpdateVersionRequest request) {
    return updateVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update API version. The following fields in the [version][google.cloud.apihub.v1.Version] can
   * be updated currently:
   *
   * <ul>
   *   <li>[display_name][google.cloud.apihub.v1.Version.display_name]
   *   <li>[description][google.cloud.apihub.v1.Version.description]
   *   <li>[documentation][google.cloud.apihub.v1.Version.documentation]
   *   <li>[deployments][google.cloud.apihub.v1.Version.deployments]
   *   <li>[lifecycle][google.cloud.apihub.v1.Version.lifecycle]
   *   <li>[compliance][google.cloud.apihub.v1.Version.compliance]
   *   <li>[accreditation][google.cloud.apihub.v1.Version.accreditation]
   *   <li>[attributes][google.cloud.apihub.v1.Version.attributes]
   * </ul>
   *
   * <p>The [update_mask][google.cloud.apihub.v1.UpdateVersionRequest.update_mask] should be used to
   * specify the fields being updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   UpdateVersionRequest request =
   *       UpdateVersionRequest.newBuilder()
   *           .setVersion(Version.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Version> future = apiHubClient.updateVersionCallable().futureCall(request);
   *   // Do something.
   *   Version response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateVersionRequest, Version> updateVersionCallable() {
    return stub.updateVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an API version. Version can only be deleted if all underlying specs, operations,
   * definitions and linked deployments are deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   VersionName name = VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");
   *   apiHubClient.deleteVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the version to delete. Format:
   *     `projects/{project}/locations/{location}/apis/{api}/versions/{version}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteVersion(VersionName name) {
    DeleteVersionRequest request =
        DeleteVersionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an API version. Version can only be deleted if all underlying specs, operations,
   * definitions and linked deployments are deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   String name = VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString();
   *   apiHubClient.deleteVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the version to delete. Format:
   *     `projects/{project}/locations/{location}/apis/{api}/versions/{version}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteVersion(String name) {
    DeleteVersionRequest request = DeleteVersionRequest.newBuilder().setName(name).build();
    deleteVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an API version. Version can only be deleted if all underlying specs, operations,
   * definitions and linked deployments are deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   DeleteVersionRequest request =
   *       DeleteVersionRequest.newBuilder()
   *           .setName(VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
   *           .setForce(true)
   *           .build();
   *   apiHubClient.deleteVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteVersion(DeleteVersionRequest request) {
    deleteVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an API version. Version can only be deleted if all underlying specs, operations,
   * definitions and linked deployments are deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   DeleteVersionRequest request =
   *       DeleteVersionRequest.newBuilder()
   *           .setName(VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future = apiHubClient.deleteVersionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteVersionRequest, Empty> deleteVersionCallable() {
    return stub.deleteVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Add a spec to an API version in the API hub. Multiple specs can be added to an API version.
   * Note, while adding a spec, at least one of `contents` or `source_uri` must be provided. If
   * `contents` is provided, then `spec_type` must also be provided.
   *
   * <p>On adding a spec with contents to the version, the operations present in it will be added to
   * the version.Note that the file contents in the spec should be of the same type as defined in
   * the `projects/{project}/locations/{location}/attributes/system-spec-type` attribute associated
   * with spec resource. Note that specs of various types can be uploaded, however parsing of
   * details is supported for OpenAPI spec currently.
   *
   * <p>In order to access the information parsed from the spec, use the
   * [GetSpec][google.cloud.apihub.v1.ApiHub.GetSpec] method. In order to access the raw contents
   * for a particular spec, use the [GetSpecContents][google.cloud.apihub.v1.ApiHub.GetSpecContents]
   * method. In order to access the operations parsed from the spec, use the
   * [ListAPIOperations][google.cloud.apihub.v1.ApiHub.ListApiOperations] method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   VersionName parent = VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");
   *   Spec spec = Spec.newBuilder().build();
   *   String specId = "specId-896074186";
   *   Spec response = apiHubClient.createSpec(parent, spec, specId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource for Spec. Format:
   *     `projects/{project}/locations/{location}/apis/{api}/versions/{version}`
   * @param spec Required. The spec to create.
   * @param specId Optional. The ID to use for the spec, which will become the final component of
   *     the spec's resource name. This field is optional.
   *     <ul>
   *       <li>If provided, the same will be used. The service will throw an error if the specified
   *           id is already used by another spec in the API resource.
   *       <li>If not provided, a system generated id will be used.
   *     </ul>
   *     <p>This value should be 4-500 characters, and valid characters are /[a-z][A-Z][0-9]-_/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Spec createSpec(VersionName parent, Spec spec, String specId) {
    CreateSpecRequest request =
        CreateSpecRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSpec(spec)
            .setSpecId(specId)
            .build();
    return createSpec(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Add a spec to an API version in the API hub. Multiple specs can be added to an API version.
   * Note, while adding a spec, at least one of `contents` or `source_uri` must be provided. If
   * `contents` is provided, then `spec_type` must also be provided.
   *
   * <p>On adding a spec with contents to the version, the operations present in it will be added to
   * the version.Note that the file contents in the spec should be of the same type as defined in
   * the `projects/{project}/locations/{location}/attributes/system-spec-type` attribute associated
   * with spec resource. Note that specs of various types can be uploaded, however parsing of
   * details is supported for OpenAPI spec currently.
   *
   * <p>In order to access the information parsed from the spec, use the
   * [GetSpec][google.cloud.apihub.v1.ApiHub.GetSpec] method. In order to access the raw contents
   * for a particular spec, use the [GetSpecContents][google.cloud.apihub.v1.ApiHub.GetSpecContents]
   * method. In order to access the operations parsed from the spec, use the
   * [ListAPIOperations][google.cloud.apihub.v1.ApiHub.ListApiOperations] method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   String parent = VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString();
   *   Spec spec = Spec.newBuilder().build();
   *   String specId = "specId-896074186";
   *   Spec response = apiHubClient.createSpec(parent, spec, specId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource for Spec. Format:
   *     `projects/{project}/locations/{location}/apis/{api}/versions/{version}`
   * @param spec Required. The spec to create.
   * @param specId Optional. The ID to use for the spec, which will become the final component of
   *     the spec's resource name. This field is optional.
   *     <ul>
   *       <li>If provided, the same will be used. The service will throw an error if the specified
   *           id is already used by another spec in the API resource.
   *       <li>If not provided, a system generated id will be used.
   *     </ul>
   *     <p>This value should be 4-500 characters, and valid characters are /[a-z][A-Z][0-9]-_/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Spec createSpec(String parent, Spec spec, String specId) {
    CreateSpecRequest request =
        CreateSpecRequest.newBuilder().setParent(parent).setSpec(spec).setSpecId(specId).build();
    return createSpec(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Add a spec to an API version in the API hub. Multiple specs can be added to an API version.
   * Note, while adding a spec, at least one of `contents` or `source_uri` must be provided. If
   * `contents` is provided, then `spec_type` must also be provided.
   *
   * <p>On adding a spec with contents to the version, the operations present in it will be added to
   * the version.Note that the file contents in the spec should be of the same type as defined in
   * the `projects/{project}/locations/{location}/attributes/system-spec-type` attribute associated
   * with spec resource. Note that specs of various types can be uploaded, however parsing of
   * details is supported for OpenAPI spec currently.
   *
   * <p>In order to access the information parsed from the spec, use the
   * [GetSpec][google.cloud.apihub.v1.ApiHub.GetSpec] method. In order to access the raw contents
   * for a particular spec, use the [GetSpecContents][google.cloud.apihub.v1.ApiHub.GetSpecContents]
   * method. In order to access the operations parsed from the spec, use the
   * [ListAPIOperations][google.cloud.apihub.v1.ApiHub.ListApiOperations] method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   CreateSpecRequest request =
   *       CreateSpecRequest.newBuilder()
   *           .setParent(VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
   *           .setSpecId("specId-896074186")
   *           .setSpec(Spec.newBuilder().build())
   *           .build();
   *   Spec response = apiHubClient.createSpec(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Spec createSpec(CreateSpecRequest request) {
    return createSpecCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Add a spec to an API version in the API hub. Multiple specs can be added to an API version.
   * Note, while adding a spec, at least one of `contents` or `source_uri` must be provided. If
   * `contents` is provided, then `spec_type` must also be provided.
   *
   * <p>On adding a spec with contents to the version, the operations present in it will be added to
   * the version.Note that the file contents in the spec should be of the same type as defined in
   * the `projects/{project}/locations/{location}/attributes/system-spec-type` attribute associated
   * with spec resource. Note that specs of various types can be uploaded, however parsing of
   * details is supported for OpenAPI spec currently.
   *
   * <p>In order to access the information parsed from the spec, use the
   * [GetSpec][google.cloud.apihub.v1.ApiHub.GetSpec] method. In order to access the raw contents
   * for a particular spec, use the [GetSpecContents][google.cloud.apihub.v1.ApiHub.GetSpecContents]
   * method. In order to access the operations parsed from the spec, use the
   * [ListAPIOperations][google.cloud.apihub.v1.ApiHub.ListApiOperations] method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   CreateSpecRequest request =
   *       CreateSpecRequest.newBuilder()
   *           .setParent(VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
   *           .setSpecId("specId-896074186")
   *           .setSpec(Spec.newBuilder().build())
   *           .build();
   *   ApiFuture<Spec> future = apiHubClient.createSpecCallable().futureCall(request);
   *   // Do something.
   *   Spec response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSpecRequest, Spec> createSpecCallable() {
    return stub.createSpecCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about the information parsed from a spec. Note that this method does not return the
   * raw spec contents. Use [GetSpecContents][google.cloud.apihub.v1.ApiHub.GetSpecContents] method
   * to retrieve the same.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   SpecName name = SpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]");
   *   Spec response = apiHubClient.getSpec(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the spec to retrieve. Format:
   *     `projects/{project}/locations/{location}/apis/{api}/versions/{version}/specs/{spec}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Spec getSpec(SpecName name) {
    GetSpecRequest request =
        GetSpecRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSpec(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about the information parsed from a spec. Note that this method does not return the
   * raw spec contents. Use [GetSpecContents][google.cloud.apihub.v1.ApiHub.GetSpecContents] method
   * to retrieve the same.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   String name =
   *       SpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]").toString();
   *   Spec response = apiHubClient.getSpec(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the spec to retrieve. Format:
   *     `projects/{project}/locations/{location}/apis/{api}/versions/{version}/specs/{spec}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Spec getSpec(String name) {
    GetSpecRequest request = GetSpecRequest.newBuilder().setName(name).build();
    return getSpec(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about the information parsed from a spec. Note that this method does not return the
   * raw spec contents. Use [GetSpecContents][google.cloud.apihub.v1.ApiHub.GetSpecContents] method
   * to retrieve the same.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   GetSpecRequest request =
   *       GetSpecRequest.newBuilder()
   *           .setName(
   *               SpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]").toString())
   *           .build();
   *   Spec response = apiHubClient.getSpec(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Spec getSpec(GetSpecRequest request) {
    return getSpecCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about the information parsed from a spec. Note that this method does not return the
   * raw spec contents. Use [GetSpecContents][google.cloud.apihub.v1.ApiHub.GetSpecContents] method
   * to retrieve the same.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   GetSpecRequest request =
   *       GetSpecRequest.newBuilder()
   *           .setName(
   *               SpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]").toString())
   *           .build();
   *   ApiFuture<Spec> future = apiHubClient.getSpecCallable().futureCall(request);
   *   // Do something.
   *   Spec response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSpecRequest, Spec> getSpecCallable() {
    return stub.getSpecCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get spec contents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   SpecName name = SpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]");
   *   SpecContents response = apiHubClient.getSpecContents(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the spec whose contents need to be retrieved. Format:
   *     `projects/{project}/locations/{location}/apis/{api}/versions/{version}/specs/{spec}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SpecContents getSpecContents(SpecName name) {
    GetSpecContentsRequest request =
        GetSpecContentsRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSpecContents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get spec contents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   String name =
   *       SpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]").toString();
   *   SpecContents response = apiHubClient.getSpecContents(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the spec whose contents need to be retrieved. Format:
   *     `projects/{project}/locations/{location}/apis/{api}/versions/{version}/specs/{spec}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SpecContents getSpecContents(String name) {
    GetSpecContentsRequest request = GetSpecContentsRequest.newBuilder().setName(name).build();
    return getSpecContents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get spec contents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   GetSpecContentsRequest request =
   *       GetSpecContentsRequest.newBuilder()
   *           .setName(
   *               SpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]").toString())
   *           .build();
   *   SpecContents response = apiHubClient.getSpecContents(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SpecContents getSpecContents(GetSpecContentsRequest request) {
    return getSpecContentsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get spec contents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   GetSpecContentsRequest request =
   *       GetSpecContentsRequest.newBuilder()
   *           .setName(
   *               SpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]").toString())
   *           .build();
   *   ApiFuture<SpecContents> future = apiHubClient.getSpecContentsCallable().futureCall(request);
   *   // Do something.
   *   SpecContents response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSpecContentsRequest, SpecContents> getSpecContentsCallable() {
    return stub.getSpecContentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List specs corresponding to a particular API resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   VersionName parent = VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");
   *   for (Spec element : apiHubClient.listSpecs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of specs. Format:
   *     `projects/{project}/locations/{location}/apis/{api}/versions/{version}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSpecsPagedResponse listSpecs(VersionName parent) {
    ListSpecsRequest request =
        ListSpecsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listSpecs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List specs corresponding to a particular API resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   String parent = VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString();
   *   for (Spec element : apiHubClient.listSpecs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of specs. Format:
   *     `projects/{project}/locations/{location}/apis/{api}/versions/{version}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSpecsPagedResponse listSpecs(String parent) {
    ListSpecsRequest request = ListSpecsRequest.newBuilder().setParent(parent).build();
    return listSpecs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List specs corresponding to a particular API resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   ListSpecsRequest request =
   *       ListSpecsRequest.newBuilder()
   *           .setParent(VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Spec element : apiHubClient.listSpecs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSpecsPagedResponse listSpecs(ListSpecsRequest request) {
    return listSpecsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List specs corresponding to a particular API resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   ListSpecsRequest request =
   *       ListSpecsRequest.newBuilder()
   *           .setParent(VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Spec> future = apiHubClient.listSpecsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Spec element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSpecsRequest, ListSpecsPagedResponse> listSpecsPagedCallable() {
    return stub.listSpecsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List specs corresponding to a particular API resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   ListSpecsRequest request =
   *       ListSpecsRequest.newBuilder()
   *           .setParent(VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSpecsResponse response = apiHubClient.listSpecsCallable().call(request);
   *     for (Spec element : response.getSpecsList()) {
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
  public final UnaryCallable<ListSpecsRequest, ListSpecsResponse> listSpecsCallable() {
    return stub.listSpecsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update spec. The following fields in the [spec][google.cloud.apihub.v1.Spec] can be updated:
   *
   * <ul>
   *   <li>[display_name][google.cloud.apihub.v1.Spec.display_name]
   *   <li>[source_uri][google.cloud.apihub.v1.Spec.source_uri]
   *   <li>[lint_response][google.cloud.apihub.v1.Spec.lint_response]
   *   <li>[attributes][google.cloud.apihub.v1.Spec.attributes]
   *   <li>[contents][google.cloud.apihub.v1.Spec.contents]
   *   <li>[spec_type][google.cloud.apihub.v1.Spec.spec_type]
   * </ul>
   *
   * <p>In case of an OAS spec, updating spec contents can lead to: 1. Creation, deletion and update
   * of operations. 2. Creation, deletion and update of definitions. 3. Update of other info parsed
   * out from the new spec.
   *
   * <p>In case of contents or source_uri being present in update mask, spec_type must also be
   * present. Also, spec_type can not be present in update mask if contents or source_uri is not
   * present.
   *
   * <p>The [update_mask][google.cloud.apihub.v1.UpdateSpecRequest.update_mask] should be used to
   * specify the fields being updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   Spec spec = Spec.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Spec response = apiHubClient.updateSpec(spec, updateMask);
   * }
   * }</pre>
   *
   * @param spec Required. The spec to update.
   *     <p>The spec's `name` field is used to identify the spec to update. Format:
   *     `projects/{project}/locations/{location}/apis/{api}/versions/{version}/specs/{spec}`
   * @param updateMask Required. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Spec updateSpec(Spec spec, FieldMask updateMask) {
    UpdateSpecRequest request =
        UpdateSpecRequest.newBuilder().setSpec(spec).setUpdateMask(updateMask).build();
    return updateSpec(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update spec. The following fields in the [spec][google.cloud.apihub.v1.Spec] can be updated:
   *
   * <ul>
   *   <li>[display_name][google.cloud.apihub.v1.Spec.display_name]
   *   <li>[source_uri][google.cloud.apihub.v1.Spec.source_uri]
   *   <li>[lint_response][google.cloud.apihub.v1.Spec.lint_response]
   *   <li>[attributes][google.cloud.apihub.v1.Spec.attributes]
   *   <li>[contents][google.cloud.apihub.v1.Spec.contents]
   *   <li>[spec_type][google.cloud.apihub.v1.Spec.spec_type]
   * </ul>
   *
   * <p>In case of an OAS spec, updating spec contents can lead to: 1. Creation, deletion and update
   * of operations. 2. Creation, deletion and update of definitions. 3. Update of other info parsed
   * out from the new spec.
   *
   * <p>In case of contents or source_uri being present in update mask, spec_type must also be
   * present. Also, spec_type can not be present in update mask if contents or source_uri is not
   * present.
   *
   * <p>The [update_mask][google.cloud.apihub.v1.UpdateSpecRequest.update_mask] should be used to
   * specify the fields being updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   UpdateSpecRequest request =
   *       UpdateSpecRequest.newBuilder()
   *           .setSpec(Spec.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Spec response = apiHubClient.updateSpec(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Spec updateSpec(UpdateSpecRequest request) {
    return updateSpecCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update spec. The following fields in the [spec][google.cloud.apihub.v1.Spec] can be updated:
   *
   * <ul>
   *   <li>[display_name][google.cloud.apihub.v1.Spec.display_name]
   *   <li>[source_uri][google.cloud.apihub.v1.Spec.source_uri]
   *   <li>[lint_response][google.cloud.apihub.v1.Spec.lint_response]
   *   <li>[attributes][google.cloud.apihub.v1.Spec.attributes]
   *   <li>[contents][google.cloud.apihub.v1.Spec.contents]
   *   <li>[spec_type][google.cloud.apihub.v1.Spec.spec_type]
   * </ul>
   *
   * <p>In case of an OAS spec, updating spec contents can lead to: 1. Creation, deletion and update
   * of operations. 2. Creation, deletion and update of definitions. 3. Update of other info parsed
   * out from the new spec.
   *
   * <p>In case of contents or source_uri being present in update mask, spec_type must also be
   * present. Also, spec_type can not be present in update mask if contents or source_uri is not
   * present.
   *
   * <p>The [update_mask][google.cloud.apihub.v1.UpdateSpecRequest.update_mask] should be used to
   * specify the fields being updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   UpdateSpecRequest request =
   *       UpdateSpecRequest.newBuilder()
   *           .setSpec(Spec.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Spec> future = apiHubClient.updateSpecCallable().futureCall(request);
   *   // Do something.
   *   Spec response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSpecRequest, Spec> updateSpecCallable() {
    return stub.updateSpecCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a spec. Deleting a spec will also delete the associated operations from the version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   SpecName name = SpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]");
   *   apiHubClient.deleteSpec(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the spec to delete. Format:
   *     `projects/{project}/locations/{location}/apis/{api}/versions/{version}/specs/{spec}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSpec(SpecName name) {
    DeleteSpecRequest request =
        DeleteSpecRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteSpec(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a spec. Deleting a spec will also delete the associated operations from the version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   String name =
   *       SpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]").toString();
   *   apiHubClient.deleteSpec(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the spec to delete. Format:
   *     `projects/{project}/locations/{location}/apis/{api}/versions/{version}/specs/{spec}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSpec(String name) {
    DeleteSpecRequest request = DeleteSpecRequest.newBuilder().setName(name).build();
    deleteSpec(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a spec. Deleting a spec will also delete the associated operations from the version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   DeleteSpecRequest request =
   *       DeleteSpecRequest.newBuilder()
   *           .setName(
   *               SpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]").toString())
   *           .build();
   *   apiHubClient.deleteSpec(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSpec(DeleteSpecRequest request) {
    deleteSpecCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a spec. Deleting a spec will also delete the associated operations from the version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   DeleteSpecRequest request =
   *       DeleteSpecRequest.newBuilder()
   *           .setName(
   *               SpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]").toString())
   *           .build();
   *   ApiFuture<Empty> future = apiHubClient.deleteSpecCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSpecRequest, Empty> deleteSpecCallable() {
    return stub.deleteSpecCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about a particular operation in API version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   ApiOperationName name =
   *       ApiOperationName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[OPERATION]");
   *   ApiOperation response = apiHubClient.getApiOperation(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the operation to retrieve. Format:
   *     `projects/{project}/locations/{location}/apis/{api}/versions/{version}/operations/{operation}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiOperation getApiOperation(ApiOperationName name) {
    GetApiOperationRequest request =
        GetApiOperationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getApiOperation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about a particular operation in API version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   String name =
   *       ApiOperationName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[OPERATION]")
   *           .toString();
   *   ApiOperation response = apiHubClient.getApiOperation(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the operation to retrieve. Format:
   *     `projects/{project}/locations/{location}/apis/{api}/versions/{version}/operations/{operation}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiOperation getApiOperation(String name) {
    GetApiOperationRequest request = GetApiOperationRequest.newBuilder().setName(name).build();
    return getApiOperation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about a particular operation in API version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   GetApiOperationRequest request =
   *       GetApiOperationRequest.newBuilder()
   *           .setName(
   *               ApiOperationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[OPERATION]")
   *                   .toString())
   *           .build();
   *   ApiOperation response = apiHubClient.getApiOperation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ApiOperation getApiOperation(GetApiOperationRequest request) {
    return getApiOperationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about a particular operation in API version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   GetApiOperationRequest request =
   *       GetApiOperationRequest.newBuilder()
   *           .setName(
   *               ApiOperationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[OPERATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ApiOperation> future = apiHubClient.getApiOperationCallable().futureCall(request);
   *   // Do something.
   *   ApiOperation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetApiOperationRequest, ApiOperation> getApiOperationCallable() {
    return stub.getApiOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List operations in an API version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   VersionName parent = VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");
   *   for (ApiOperation element : apiHubClient.listApiOperations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent which owns this collection of operations i.e., the API
   *     version. Format: `projects/{project}/locations/{location}/apis/{api}/versions/{version}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApiOperationsPagedResponse listApiOperations(VersionName parent) {
    ListApiOperationsRequest request =
        ListApiOperationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listApiOperations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List operations in an API version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   String parent = VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString();
   *   for (ApiOperation element : apiHubClient.listApiOperations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent which owns this collection of operations i.e., the API
   *     version. Format: `projects/{project}/locations/{location}/apis/{api}/versions/{version}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApiOperationsPagedResponse listApiOperations(String parent) {
    ListApiOperationsRequest request =
        ListApiOperationsRequest.newBuilder().setParent(parent).build();
    return listApiOperations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List operations in an API version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   ListApiOperationsRequest request =
   *       ListApiOperationsRequest.newBuilder()
   *           .setParent(VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ApiOperation element : apiHubClient.listApiOperations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApiOperationsPagedResponse listApiOperations(ListApiOperationsRequest request) {
    return listApiOperationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List operations in an API version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   ListApiOperationsRequest request =
   *       ListApiOperationsRequest.newBuilder()
   *           .setParent(VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ApiOperation> future =
   *       apiHubClient.listApiOperationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ApiOperation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListApiOperationsRequest, ListApiOperationsPagedResponse>
      listApiOperationsPagedCallable() {
    return stub.listApiOperationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List operations in an API version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   ListApiOperationsRequest request =
   *       ListApiOperationsRequest.newBuilder()
   *           .setParent(VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListApiOperationsResponse response = apiHubClient.listApiOperationsCallable().call(request);
   *     for (ApiOperation element : response.getApiOperationsList()) {
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
  public final UnaryCallable<ListApiOperationsRequest, ListApiOperationsResponse>
      listApiOperationsCallable() {
    return stub.listApiOperationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about a definition in an API version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   DefinitionName name =
   *       DefinitionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[DEFINITION]");
   *   Definition response = apiHubClient.getDefinition(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the definition to retrieve. Format:
   *     `projects/{project}/locations/{location}/apis/{api}/versions/{version}/definitions/{definition}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Definition getDefinition(DefinitionName name) {
    GetDefinitionRequest request =
        GetDefinitionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDefinition(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about a definition in an API version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   String name =
   *       DefinitionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[DEFINITION]")
   *           .toString();
   *   Definition response = apiHubClient.getDefinition(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the definition to retrieve. Format:
   *     `projects/{project}/locations/{location}/apis/{api}/versions/{version}/definitions/{definition}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Definition getDefinition(String name) {
    GetDefinitionRequest request = GetDefinitionRequest.newBuilder().setName(name).build();
    return getDefinition(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about a definition in an API version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   GetDefinitionRequest request =
   *       GetDefinitionRequest.newBuilder()
   *           .setName(
   *               DefinitionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[DEFINITION]")
   *                   .toString())
   *           .build();
   *   Definition response = apiHubClient.getDefinition(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Definition getDefinition(GetDefinitionRequest request) {
    return getDefinitionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about a definition in an API version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   GetDefinitionRequest request =
   *       GetDefinitionRequest.newBuilder()
   *           .setName(
   *               DefinitionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[DEFINITION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Definition> future = apiHubClient.getDefinitionCallable().futureCall(request);
   *   // Do something.
   *   Definition response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDefinitionRequest, Definition> getDefinitionCallable() {
    return stub.getDefinitionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a deployment resource in the API hub. Once a deployment resource is created, it can be
   * associated with API versions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Deployment deployment = Deployment.newBuilder().build();
   *   String deploymentId = "deploymentId-136894784";
   *   Deployment response = apiHubClient.createDeployment(parent, deployment, deploymentId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource for the deployment resource. Format:
   *     `projects/{project}/locations/{location}`
   * @param deployment Required. The deployment resource to create.
   * @param deploymentId Optional. The ID to use for the deployment resource, which will become the
   *     final component of the deployment's resource name. This field is optional.
   *     <ul>
   *       <li>If provided, the same will be used. The service will throw an error if the specified
   *           id is already used by another deployment resource in the API hub.
   *       <li>If not provided, a system generated id will be used.
   *     </ul>
   *     <p>This value should be 4-500 characters, and valid characters are /[a-z][A-Z][0-9]-_/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment createDeployment(
      LocationName parent, Deployment deployment, String deploymentId) {
    CreateDeploymentRequest request =
        CreateDeploymentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDeployment(deployment)
            .setDeploymentId(deploymentId)
            .build();
    return createDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a deployment resource in the API hub. Once a deployment resource is created, it can be
   * associated with API versions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Deployment deployment = Deployment.newBuilder().build();
   *   String deploymentId = "deploymentId-136894784";
   *   Deployment response = apiHubClient.createDeployment(parent, deployment, deploymentId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource for the deployment resource. Format:
   *     `projects/{project}/locations/{location}`
   * @param deployment Required. The deployment resource to create.
   * @param deploymentId Optional. The ID to use for the deployment resource, which will become the
   *     final component of the deployment's resource name. This field is optional.
   *     <ul>
   *       <li>If provided, the same will be used. The service will throw an error if the specified
   *           id is already used by another deployment resource in the API hub.
   *       <li>If not provided, a system generated id will be used.
   *     </ul>
   *     <p>This value should be 4-500 characters, and valid characters are /[a-z][A-Z][0-9]-_/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment createDeployment(
      String parent, Deployment deployment, String deploymentId) {
    CreateDeploymentRequest request =
        CreateDeploymentRequest.newBuilder()
            .setParent(parent)
            .setDeployment(deployment)
            .setDeploymentId(deploymentId)
            .build();
    return createDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a deployment resource in the API hub. Once a deployment resource is created, it can be
   * associated with API versions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   CreateDeploymentRequest request =
   *       CreateDeploymentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDeploymentId("deploymentId-136894784")
   *           .setDeployment(Deployment.newBuilder().build())
   *           .build();
   *   Deployment response = apiHubClient.createDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment createDeployment(CreateDeploymentRequest request) {
    return createDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a deployment resource in the API hub. Once a deployment resource is created, it can be
   * associated with API versions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   CreateDeploymentRequest request =
   *       CreateDeploymentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDeploymentId("deploymentId-136894784")
   *           .setDeployment(Deployment.newBuilder().build())
   *           .build();
   *   ApiFuture<Deployment> future = apiHubClient.createDeploymentCallable().futureCall(request);
   *   // Do something.
   *   Deployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDeploymentRequest, Deployment> createDeploymentCallable() {
    return stub.createDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about a deployment and the API versions linked to it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
   *   Deployment response = apiHubClient.getDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment resource to retrieve. Format:
   *     `projects/{project}/locations/{location}/deployments/{deployment}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment getDeployment(DeploymentName name) {
    GetDeploymentRequest request =
        GetDeploymentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about a deployment and the API versions linked to it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   String name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString();
   *   Deployment response = apiHubClient.getDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment resource to retrieve. Format:
   *     `projects/{project}/locations/{location}/deployments/{deployment}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment getDeployment(String name) {
    GetDeploymentRequest request = GetDeploymentRequest.newBuilder().setName(name).build();
    return getDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about a deployment and the API versions linked to it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   GetDeploymentRequest request =
   *       GetDeploymentRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .build();
   *   Deployment response = apiHubClient.getDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment getDeployment(GetDeploymentRequest request) {
    return getDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about a deployment and the API versions linked to it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   GetDeploymentRequest request =
   *       GetDeploymentRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .build();
   *   ApiFuture<Deployment> future = apiHubClient.getDeploymentCallable().futureCall(request);
   *   // Do something.
   *   Deployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDeploymentRequest, Deployment> getDeploymentCallable() {
    return stub.getDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List deployment resources in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Deployment element : apiHubClient.listDeployments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of deployment resources. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeploymentsPagedResponse listDeployments(LocationName parent) {
    ListDeploymentsRequest request =
        ListDeploymentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List deployment resources in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Deployment element : apiHubClient.listDeployments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of deployment resources. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeploymentsPagedResponse listDeployments(String parent) {
    ListDeploymentsRequest request = ListDeploymentsRequest.newBuilder().setParent(parent).build();
    return listDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List deployment resources in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   ListDeploymentsRequest request =
   *       ListDeploymentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Deployment element : apiHubClient.listDeployments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeploymentsPagedResponse listDeployments(ListDeploymentsRequest request) {
    return listDeploymentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List deployment resources in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   ListDeploymentsRequest request =
   *       ListDeploymentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Deployment> future =
   *       apiHubClient.listDeploymentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Deployment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDeploymentsRequest, ListDeploymentsPagedResponse>
      listDeploymentsPagedCallable() {
    return stub.listDeploymentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List deployment resources in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   ListDeploymentsRequest request =
   *       ListDeploymentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDeploymentsResponse response = apiHubClient.listDeploymentsCallable().call(request);
   *     for (Deployment element : response.getDeploymentsList()) {
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
  public final UnaryCallable<ListDeploymentsRequest, ListDeploymentsResponse>
      listDeploymentsCallable() {
    return stub.listDeploymentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a deployment resource in the API hub. The following fields in the [deployment
   * resource][google.cloud.apihub.v1.Deployment] can be updated:
   *
   * <ul>
   *   <li>[display_name][google.cloud.apihub.v1.Deployment.display_name]
   *   <li>[description][google.cloud.apihub.v1.Deployment.description]
   *   <li>[documentation][google.cloud.apihub.v1.Deployment.documentation]
   *   <li>[deployment_type][google.cloud.apihub.v1.Deployment.deployment_type]
   *   <li>[resource_uri][google.cloud.apihub.v1.Deployment.resource_uri]
   *   <li>[endpoints][google.cloud.apihub.v1.Deployment.endpoints]
   *   <li>[slo][google.cloud.apihub.v1.Deployment.slo]
   *   <li>[environment][google.cloud.apihub.v1.Deployment.environment]
   *   <li>[attributes][google.cloud.apihub.v1.Deployment.attributes]
   * </ul>
   *
   * <p>The [update_mask][google.cloud.apihub.v1.UpdateDeploymentRequest.update_mask] should be used
   * to specify the fields being updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   Deployment deployment = Deployment.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Deployment response = apiHubClient.updateDeployment(deployment, updateMask);
   * }
   * }</pre>
   *
   * @param deployment Required. The deployment resource to update.
   *     <p>The deployment resource's `name` field is used to identify the deployment resource to
   *     update. Format: `projects/{project}/locations/{location}/deployments/{deployment}`
   * @param updateMask Required. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment updateDeployment(Deployment deployment, FieldMask updateMask) {
    UpdateDeploymentRequest request =
        UpdateDeploymentRequest.newBuilder()
            .setDeployment(deployment)
            .setUpdateMask(updateMask)
            .build();
    return updateDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a deployment resource in the API hub. The following fields in the [deployment
   * resource][google.cloud.apihub.v1.Deployment] can be updated:
   *
   * <ul>
   *   <li>[display_name][google.cloud.apihub.v1.Deployment.display_name]
   *   <li>[description][google.cloud.apihub.v1.Deployment.description]
   *   <li>[documentation][google.cloud.apihub.v1.Deployment.documentation]
   *   <li>[deployment_type][google.cloud.apihub.v1.Deployment.deployment_type]
   *   <li>[resource_uri][google.cloud.apihub.v1.Deployment.resource_uri]
   *   <li>[endpoints][google.cloud.apihub.v1.Deployment.endpoints]
   *   <li>[slo][google.cloud.apihub.v1.Deployment.slo]
   *   <li>[environment][google.cloud.apihub.v1.Deployment.environment]
   *   <li>[attributes][google.cloud.apihub.v1.Deployment.attributes]
   * </ul>
   *
   * <p>The [update_mask][google.cloud.apihub.v1.UpdateDeploymentRequest.update_mask] should be used
   * to specify the fields being updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   UpdateDeploymentRequest request =
   *       UpdateDeploymentRequest.newBuilder()
   *           .setDeployment(Deployment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Deployment response = apiHubClient.updateDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment updateDeployment(UpdateDeploymentRequest request) {
    return updateDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a deployment resource in the API hub. The following fields in the [deployment
   * resource][google.cloud.apihub.v1.Deployment] can be updated:
   *
   * <ul>
   *   <li>[display_name][google.cloud.apihub.v1.Deployment.display_name]
   *   <li>[description][google.cloud.apihub.v1.Deployment.description]
   *   <li>[documentation][google.cloud.apihub.v1.Deployment.documentation]
   *   <li>[deployment_type][google.cloud.apihub.v1.Deployment.deployment_type]
   *   <li>[resource_uri][google.cloud.apihub.v1.Deployment.resource_uri]
   *   <li>[endpoints][google.cloud.apihub.v1.Deployment.endpoints]
   *   <li>[slo][google.cloud.apihub.v1.Deployment.slo]
   *   <li>[environment][google.cloud.apihub.v1.Deployment.environment]
   *   <li>[attributes][google.cloud.apihub.v1.Deployment.attributes]
   * </ul>
   *
   * <p>The [update_mask][google.cloud.apihub.v1.UpdateDeploymentRequest.update_mask] should be used
   * to specify the fields being updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   UpdateDeploymentRequest request =
   *       UpdateDeploymentRequest.newBuilder()
   *           .setDeployment(Deployment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Deployment> future = apiHubClient.updateDeploymentCallable().futureCall(request);
   *   // Do something.
   *   Deployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDeploymentRequest, Deployment> updateDeploymentCallable() {
    return stub.updateDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a deployment resource in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
   *   apiHubClient.deleteDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment resource to delete. Format:
   *     `projects/{project}/locations/{location}/deployments/{deployment}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDeployment(DeploymentName name) {
    DeleteDeploymentRequest request =
        DeleteDeploymentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a deployment resource in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   String name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString();
   *   apiHubClient.deleteDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment resource to delete. Format:
   *     `projects/{project}/locations/{location}/deployments/{deployment}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDeployment(String name) {
    DeleteDeploymentRequest request = DeleteDeploymentRequest.newBuilder().setName(name).build();
    deleteDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a deployment resource in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   DeleteDeploymentRequest request =
   *       DeleteDeploymentRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .build();
   *   apiHubClient.deleteDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDeployment(DeleteDeploymentRequest request) {
    deleteDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a deployment resource in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   DeleteDeploymentRequest request =
   *       DeleteDeploymentRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .build();
   *   ApiFuture<Empty> future = apiHubClient.deleteDeploymentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDeploymentRequest, Empty> deleteDeploymentCallable() {
    return stub.deleteDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a user defined attribute.
   *
   * <p>Certain pre defined attributes are already created by the API hub. These attributes will
   * have type as `SYSTEM_DEFINED` and can be listed via
   * [ListAttributes][google.cloud.apihub.v1.ApiHub.ListAttributes] method. Allowed values for the
   * same can be updated via [UpdateAttribute][google.cloud.apihub.v1.ApiHub.UpdateAttribute]
   * method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Attribute attribute = Attribute.newBuilder().build();
   *   String attributeId = "attributeId-309887785";
   *   Attribute response = apiHubClient.createAttribute(parent, attribute, attributeId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource for Attribute. Format:
   *     `projects/{project}/locations/{location}`
   * @param attribute Required. The attribute to create.
   * @param attributeId Optional. The ID to use for the attribute, which will become the final
   *     component of the attribute's resource name. This field is optional.
   *     <ul>
   *       <li>If provided, the same will be used. The service will throw an error if the specified
   *           id is already used by another attribute resource in the API hub.
   *       <li>If not provided, a system generated id will be used.
   *     </ul>
   *     <p>This value should be 4-500 characters, and valid characters are /[a-z][A-Z][0-9]-_/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Attribute createAttribute(
      LocationName parent, Attribute attribute, String attributeId) {
    CreateAttributeRequest request =
        CreateAttributeRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAttribute(attribute)
            .setAttributeId(attributeId)
            .build();
    return createAttribute(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a user defined attribute.
   *
   * <p>Certain pre defined attributes are already created by the API hub. These attributes will
   * have type as `SYSTEM_DEFINED` and can be listed via
   * [ListAttributes][google.cloud.apihub.v1.ApiHub.ListAttributes] method. Allowed values for the
   * same can be updated via [UpdateAttribute][google.cloud.apihub.v1.ApiHub.UpdateAttribute]
   * method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Attribute attribute = Attribute.newBuilder().build();
   *   String attributeId = "attributeId-309887785";
   *   Attribute response = apiHubClient.createAttribute(parent, attribute, attributeId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource for Attribute. Format:
   *     `projects/{project}/locations/{location}`
   * @param attribute Required. The attribute to create.
   * @param attributeId Optional. The ID to use for the attribute, which will become the final
   *     component of the attribute's resource name. This field is optional.
   *     <ul>
   *       <li>If provided, the same will be used. The service will throw an error if the specified
   *           id is already used by another attribute resource in the API hub.
   *       <li>If not provided, a system generated id will be used.
   *     </ul>
   *     <p>This value should be 4-500 characters, and valid characters are /[a-z][A-Z][0-9]-_/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Attribute createAttribute(String parent, Attribute attribute, String attributeId) {
    CreateAttributeRequest request =
        CreateAttributeRequest.newBuilder()
            .setParent(parent)
            .setAttribute(attribute)
            .setAttributeId(attributeId)
            .build();
    return createAttribute(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a user defined attribute.
   *
   * <p>Certain pre defined attributes are already created by the API hub. These attributes will
   * have type as `SYSTEM_DEFINED` and can be listed via
   * [ListAttributes][google.cloud.apihub.v1.ApiHub.ListAttributes] method. Allowed values for the
   * same can be updated via [UpdateAttribute][google.cloud.apihub.v1.ApiHub.UpdateAttribute]
   * method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   CreateAttributeRequest request =
   *       CreateAttributeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAttributeId("attributeId-309887785")
   *           .setAttribute(Attribute.newBuilder().build())
   *           .build();
   *   Attribute response = apiHubClient.createAttribute(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Attribute createAttribute(CreateAttributeRequest request) {
    return createAttributeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a user defined attribute.
   *
   * <p>Certain pre defined attributes are already created by the API hub. These attributes will
   * have type as `SYSTEM_DEFINED` and can be listed via
   * [ListAttributes][google.cloud.apihub.v1.ApiHub.ListAttributes] method. Allowed values for the
   * same can be updated via [UpdateAttribute][google.cloud.apihub.v1.ApiHub.UpdateAttribute]
   * method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   CreateAttributeRequest request =
   *       CreateAttributeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAttributeId("attributeId-309887785")
   *           .setAttribute(Attribute.newBuilder().build())
   *           .build();
   *   ApiFuture<Attribute> future = apiHubClient.createAttributeCallable().futureCall(request);
   *   // Do something.
   *   Attribute response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAttributeRequest, Attribute> createAttributeCallable() {
    return stub.createAttributeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about the attribute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   AttributeName name = AttributeName.of("[PROJECT]", "[LOCATION]", "[ATTRIBUTE]");
   *   Attribute response = apiHubClient.getAttribute(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the attribute to retrieve. Format:
   *     `projects/{project}/locations/{location}/attributes/{attribute}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Attribute getAttribute(AttributeName name) {
    GetAttributeRequest request =
        GetAttributeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAttribute(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about the attribute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   String name = AttributeName.of("[PROJECT]", "[LOCATION]", "[ATTRIBUTE]").toString();
   *   Attribute response = apiHubClient.getAttribute(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the attribute to retrieve. Format:
   *     `projects/{project}/locations/{location}/attributes/{attribute}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Attribute getAttribute(String name) {
    GetAttributeRequest request = GetAttributeRequest.newBuilder().setName(name).build();
    return getAttribute(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about the attribute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   GetAttributeRequest request =
   *       GetAttributeRequest.newBuilder()
   *           .setName(AttributeName.of("[PROJECT]", "[LOCATION]", "[ATTRIBUTE]").toString())
   *           .build();
   *   Attribute response = apiHubClient.getAttribute(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Attribute getAttribute(GetAttributeRequest request) {
    return getAttributeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about the attribute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   GetAttributeRequest request =
   *       GetAttributeRequest.newBuilder()
   *           .setName(AttributeName.of("[PROJECT]", "[LOCATION]", "[ATTRIBUTE]").toString())
   *           .build();
   *   ApiFuture<Attribute> future = apiHubClient.getAttributeCallable().futureCall(request);
   *   // Do something.
   *   Attribute response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAttributeRequest, Attribute> getAttributeCallable() {
    return stub.getAttributeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the attribute. The following fields in the [Attribute
   * resource][google.cloud.apihub.v1.Attribute] can be updated:
   *
   * <ul>
   *   <li>[display_name][google.cloud.apihub.v1.Attribute.display_name] The display name can be
   *       updated for user defined attributes only.
   *   <li>[description][google.cloud.apihub.v1.Attribute.description] The description can be
   *       updated for user defined attributes only.
   *   <li>[allowed_values][google.cloud.apihub.v1.Attribute.allowed_values] To update the list of
   *       allowed values, clients need to use the fetched list of allowed values and add or remove
   *       values to or from the same list. The mutable allowed values can be updated for both user
   *       defined and System defined attributes. The immutable allowed values cannot be updated or
   *       deleted. The updated list of allowed values cannot be empty. If an allowed value that is
   *       already used by some resource's attribute is deleted, then the association between the
   *       resource and the attribute value will also be deleted.
   *   <li>[cardinality][google.cloud.apihub.v1.Attribute.cardinality] The cardinality can be
   *       updated for user defined attributes only. Cardinality can only be increased during an
   *       update.
   * </ul>
   *
   * <p>The [update_mask][google.cloud.apihub.v1.UpdateAttributeRequest.update_mask] should be used
   * to specify the fields being updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   Attribute attribute = Attribute.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Attribute response = apiHubClient.updateAttribute(attribute, updateMask);
   * }
   * }</pre>
   *
   * @param attribute Required. The attribute to update.
   *     <p>The attribute's `name` field is used to identify the attribute to update. Format:
   *     `projects/{project}/locations/{location}/attributes/{attribute}`
   * @param updateMask Required. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Attribute updateAttribute(Attribute attribute, FieldMask updateMask) {
    UpdateAttributeRequest request =
        UpdateAttributeRequest.newBuilder()
            .setAttribute(attribute)
            .setUpdateMask(updateMask)
            .build();
    return updateAttribute(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the attribute. The following fields in the [Attribute
   * resource][google.cloud.apihub.v1.Attribute] can be updated:
   *
   * <ul>
   *   <li>[display_name][google.cloud.apihub.v1.Attribute.display_name] The display name can be
   *       updated for user defined attributes only.
   *   <li>[description][google.cloud.apihub.v1.Attribute.description] The description can be
   *       updated for user defined attributes only.
   *   <li>[allowed_values][google.cloud.apihub.v1.Attribute.allowed_values] To update the list of
   *       allowed values, clients need to use the fetched list of allowed values and add or remove
   *       values to or from the same list. The mutable allowed values can be updated for both user
   *       defined and System defined attributes. The immutable allowed values cannot be updated or
   *       deleted. The updated list of allowed values cannot be empty. If an allowed value that is
   *       already used by some resource's attribute is deleted, then the association between the
   *       resource and the attribute value will also be deleted.
   *   <li>[cardinality][google.cloud.apihub.v1.Attribute.cardinality] The cardinality can be
   *       updated for user defined attributes only. Cardinality can only be increased during an
   *       update.
   * </ul>
   *
   * <p>The [update_mask][google.cloud.apihub.v1.UpdateAttributeRequest.update_mask] should be used
   * to specify the fields being updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   UpdateAttributeRequest request =
   *       UpdateAttributeRequest.newBuilder()
   *           .setAttribute(Attribute.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Attribute response = apiHubClient.updateAttribute(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Attribute updateAttribute(UpdateAttributeRequest request) {
    return updateAttributeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the attribute. The following fields in the [Attribute
   * resource][google.cloud.apihub.v1.Attribute] can be updated:
   *
   * <ul>
   *   <li>[display_name][google.cloud.apihub.v1.Attribute.display_name] The display name can be
   *       updated for user defined attributes only.
   *   <li>[description][google.cloud.apihub.v1.Attribute.description] The description can be
   *       updated for user defined attributes only.
   *   <li>[allowed_values][google.cloud.apihub.v1.Attribute.allowed_values] To update the list of
   *       allowed values, clients need to use the fetched list of allowed values and add or remove
   *       values to or from the same list. The mutable allowed values can be updated for both user
   *       defined and System defined attributes. The immutable allowed values cannot be updated or
   *       deleted. The updated list of allowed values cannot be empty. If an allowed value that is
   *       already used by some resource's attribute is deleted, then the association between the
   *       resource and the attribute value will also be deleted.
   *   <li>[cardinality][google.cloud.apihub.v1.Attribute.cardinality] The cardinality can be
   *       updated for user defined attributes only. Cardinality can only be increased during an
   *       update.
   * </ul>
   *
   * <p>The [update_mask][google.cloud.apihub.v1.UpdateAttributeRequest.update_mask] should be used
   * to specify the fields being updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   UpdateAttributeRequest request =
   *       UpdateAttributeRequest.newBuilder()
   *           .setAttribute(Attribute.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Attribute> future = apiHubClient.updateAttributeCallable().futureCall(request);
   *   // Do something.
   *   Attribute response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAttributeRequest, Attribute> updateAttributeCallable() {
    return stub.updateAttributeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an attribute.
   *
   * <p>Note: System defined attributes cannot be deleted. All associations of the attribute being
   * deleted with any API hub resource will also get deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   AttributeName name = AttributeName.of("[PROJECT]", "[LOCATION]", "[ATTRIBUTE]");
   *   apiHubClient.deleteAttribute(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the attribute to delete. Format:
   *     `projects/{project}/locations/{location}/attributes/{attribute}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAttribute(AttributeName name) {
    DeleteAttributeRequest request =
        DeleteAttributeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteAttribute(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an attribute.
   *
   * <p>Note: System defined attributes cannot be deleted. All associations of the attribute being
   * deleted with any API hub resource will also get deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   String name = AttributeName.of("[PROJECT]", "[LOCATION]", "[ATTRIBUTE]").toString();
   *   apiHubClient.deleteAttribute(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the attribute to delete. Format:
   *     `projects/{project}/locations/{location}/attributes/{attribute}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAttribute(String name) {
    DeleteAttributeRequest request = DeleteAttributeRequest.newBuilder().setName(name).build();
    deleteAttribute(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an attribute.
   *
   * <p>Note: System defined attributes cannot be deleted. All associations of the attribute being
   * deleted with any API hub resource will also get deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   DeleteAttributeRequest request =
   *       DeleteAttributeRequest.newBuilder()
   *           .setName(AttributeName.of("[PROJECT]", "[LOCATION]", "[ATTRIBUTE]").toString())
   *           .build();
   *   apiHubClient.deleteAttribute(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAttribute(DeleteAttributeRequest request) {
    deleteAttributeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an attribute.
   *
   * <p>Note: System defined attributes cannot be deleted. All associations of the attribute being
   * deleted with any API hub resource will also get deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   DeleteAttributeRequest request =
   *       DeleteAttributeRequest.newBuilder()
   *           .setName(AttributeName.of("[PROJECT]", "[LOCATION]", "[ATTRIBUTE]").toString())
   *           .build();
   *   ApiFuture<Empty> future = apiHubClient.deleteAttributeCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAttributeRequest, Empty> deleteAttributeCallable() {
    return stub.deleteAttributeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all attributes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Attribute element : apiHubClient.listAttributes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource for Attribute. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAttributesPagedResponse listAttributes(LocationName parent) {
    ListAttributesRequest request =
        ListAttributesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAttributes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all attributes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Attribute element : apiHubClient.listAttributes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource for Attribute. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAttributesPagedResponse listAttributes(String parent) {
    ListAttributesRequest request = ListAttributesRequest.newBuilder().setParent(parent).build();
    return listAttributes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all attributes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   ListAttributesRequest request =
   *       ListAttributesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Attribute element : apiHubClient.listAttributes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAttributesPagedResponse listAttributes(ListAttributesRequest request) {
    return listAttributesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all attributes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   ListAttributesRequest request =
   *       ListAttributesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Attribute> future = apiHubClient.listAttributesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Attribute element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAttributesRequest, ListAttributesPagedResponse>
      listAttributesPagedCallable() {
    return stub.listAttributesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all attributes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   ListAttributesRequest request =
   *       ListAttributesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAttributesResponse response = apiHubClient.listAttributesCallable().call(request);
   *     for (Attribute element : response.getAttributesList()) {
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
  public final UnaryCallable<ListAttributesRequest, ListAttributesResponse>
      listAttributesCallable() {
    return stub.listAttributesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search across API-Hub resources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String query = "query107944136";
   *   for (SearchResult element : apiHubClient.searchResources(location, query).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param location Required. The resource name of the location which will be of the type
   *     `projects/{project_id}/locations/{location_id}`. This field is used to identify the
   *     instance of API-Hub in which resources should be searched.
   * @param query Required. The free text search query. This query can contain keywords which could
   *     be related to any detail of the API-Hub resources such display names, descriptions,
   *     attributes etc.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchResourcesPagedResponse searchResources(LocationName location, String query) {
    SearchResourcesRequest request =
        SearchResourcesRequest.newBuilder()
            .setLocation(location == null ? null : location.toString())
            .setQuery(query)
            .build();
    return searchResources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search across API-Hub resources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   String location = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String query = "query107944136";
   *   for (SearchResult element : apiHubClient.searchResources(location, query).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param location Required. The resource name of the location which will be of the type
   *     `projects/{project_id}/locations/{location_id}`. This field is used to identify the
   *     instance of API-Hub in which resources should be searched.
   * @param query Required. The free text search query. This query can contain keywords which could
   *     be related to any detail of the API-Hub resources such display names, descriptions,
   *     attributes etc.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchResourcesPagedResponse searchResources(String location, String query) {
    SearchResourcesRequest request =
        SearchResourcesRequest.newBuilder().setLocation(location).setQuery(query).build();
    return searchResources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search across API-Hub resources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   SearchResourcesRequest request =
   *       SearchResourcesRequest.newBuilder()
   *           .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setQuery("query107944136")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (SearchResult element : apiHubClient.searchResources(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchResourcesPagedResponse searchResources(SearchResourcesRequest request) {
    return searchResourcesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search across API-Hub resources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   SearchResourcesRequest request =
   *       SearchResourcesRequest.newBuilder()
   *           .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setQuery("query107944136")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<SearchResult> future =
   *       apiHubClient.searchResourcesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SearchResult element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchResourcesRequest, SearchResourcesPagedResponse>
      searchResourcesPagedCallable() {
    return stub.searchResourcesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search across API-Hub resources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   SearchResourcesRequest request =
   *       SearchResourcesRequest.newBuilder()
   *           .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setQuery("query107944136")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     SearchResourcesResponse response = apiHubClient.searchResourcesCallable().call(request);
   *     for (SearchResult element : response.getSearchResultsList()) {
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
  public final UnaryCallable<SearchResourcesRequest, SearchResourcesResponse>
      searchResourcesCallable() {
    return stub.searchResourcesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an External API resource in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ExternalApi externalApi = ExternalApi.newBuilder().build();
   *   String externalApiId = "externalApiId-31672374";
   *   ExternalApi response = apiHubClient.createExternalApi(parent, externalApi, externalApiId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource for the External API resource. Format:
   *     `projects/{project}/locations/{location}`
   * @param externalApi Required. The External API resource to create.
   * @param externalApiId Optional. The ID to use for the External API resource, which will become
   *     the final component of the External API's resource name. This field is optional.
   *     <ul>
   *       <li>If provided, the same will be used. The service will throw an error if the specified
   *           id is already used by another External API resource in the API hub.
   *       <li>If not provided, a system generated id will be used.
   *     </ul>
   *     <p>This value should be 4-500 characters, and valid characters are /[a-z][A-Z][0-9]-_/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExternalApi createExternalApi(
      LocationName parent, ExternalApi externalApi, String externalApiId) {
    CreateExternalApiRequest request =
        CreateExternalApiRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setExternalApi(externalApi)
            .setExternalApiId(externalApiId)
            .build();
    return createExternalApi(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an External API resource in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ExternalApi externalApi = ExternalApi.newBuilder().build();
   *   String externalApiId = "externalApiId-31672374";
   *   ExternalApi response = apiHubClient.createExternalApi(parent, externalApi, externalApiId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource for the External API resource. Format:
   *     `projects/{project}/locations/{location}`
   * @param externalApi Required. The External API resource to create.
   * @param externalApiId Optional. The ID to use for the External API resource, which will become
   *     the final component of the External API's resource name. This field is optional.
   *     <ul>
   *       <li>If provided, the same will be used. The service will throw an error if the specified
   *           id is already used by another External API resource in the API hub.
   *       <li>If not provided, a system generated id will be used.
   *     </ul>
   *     <p>This value should be 4-500 characters, and valid characters are /[a-z][A-Z][0-9]-_/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExternalApi createExternalApi(
      String parent, ExternalApi externalApi, String externalApiId) {
    CreateExternalApiRequest request =
        CreateExternalApiRequest.newBuilder()
            .setParent(parent)
            .setExternalApi(externalApi)
            .setExternalApiId(externalApiId)
            .build();
    return createExternalApi(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an External API resource in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   CreateExternalApiRequest request =
   *       CreateExternalApiRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setExternalApiId("externalApiId-31672374")
   *           .setExternalApi(ExternalApi.newBuilder().build())
   *           .build();
   *   ExternalApi response = apiHubClient.createExternalApi(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExternalApi createExternalApi(CreateExternalApiRequest request) {
    return createExternalApiCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an External API resource in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   CreateExternalApiRequest request =
   *       CreateExternalApiRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setExternalApiId("externalApiId-31672374")
   *           .setExternalApi(ExternalApi.newBuilder().build())
   *           .build();
   *   ApiFuture<ExternalApi> future = apiHubClient.createExternalApiCallable().futureCall(request);
   *   // Do something.
   *   ExternalApi response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateExternalApiRequest, ExternalApi> createExternalApiCallable() {
    return stub.createExternalApiCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about an External API resource in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   ExternalApiName name = ExternalApiName.of("[PROJECT]", "[LOCATION]", "[EXTERNAL_API]");
   *   ExternalApi response = apiHubClient.getExternalApi(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the External API resource to retrieve. Format:
   *     `projects/{project}/locations/{location}/externalApis/{externalApi}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExternalApi getExternalApi(ExternalApiName name) {
    GetExternalApiRequest request =
        GetExternalApiRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getExternalApi(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about an External API resource in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   String name = ExternalApiName.of("[PROJECT]", "[LOCATION]", "[EXTERNAL_API]").toString();
   *   ExternalApi response = apiHubClient.getExternalApi(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the External API resource to retrieve. Format:
   *     `projects/{project}/locations/{location}/externalApis/{externalApi}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExternalApi getExternalApi(String name) {
    GetExternalApiRequest request = GetExternalApiRequest.newBuilder().setName(name).build();
    return getExternalApi(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about an External API resource in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   GetExternalApiRequest request =
   *       GetExternalApiRequest.newBuilder()
   *           .setName(ExternalApiName.of("[PROJECT]", "[LOCATION]", "[EXTERNAL_API]").toString())
   *           .build();
   *   ExternalApi response = apiHubClient.getExternalApi(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExternalApi getExternalApi(GetExternalApiRequest request) {
    return getExternalApiCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about an External API resource in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   GetExternalApiRequest request =
   *       GetExternalApiRequest.newBuilder()
   *           .setName(ExternalApiName.of("[PROJECT]", "[LOCATION]", "[EXTERNAL_API]").toString())
   *           .build();
   *   ApiFuture<ExternalApi> future = apiHubClient.getExternalApiCallable().futureCall(request);
   *   // Do something.
   *   ExternalApi response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetExternalApiRequest, ExternalApi> getExternalApiCallable() {
    return stub.getExternalApiCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update an External API resource in the API hub. The following fields can be updated:
   *
   * <ul>
   *   <li>[display_name][google.cloud.apihub.v1.ExternalApi.display_name]
   *   <li>[description][google.cloud.apihub.v1.ExternalApi.description]
   *   <li>[documentation][google.cloud.apihub.v1.ExternalApi.documentation]
   *   <li>[endpoints][google.cloud.apihub.v1.ExternalApi.endpoints]
   *   <li>[paths][google.cloud.apihub.v1.ExternalApi.paths]
   * </ul>
   *
   * <p>The [update_mask][google.cloud.apihub.v1.UpdateExternalApiRequest.update_mask] should be
   * used to specify the fields being updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   ExternalApi externalApi = ExternalApi.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ExternalApi response = apiHubClient.updateExternalApi(externalApi, updateMask);
   * }
   * }</pre>
   *
   * @param externalApi Required. The External API resource to update.
   *     <p>The External API resource's `name` field is used to identify the External API resource
   *     to update. Format: `projects/{project}/locations/{location}/externalApis/{externalApi}`
   * @param updateMask Required. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExternalApi updateExternalApi(ExternalApi externalApi, FieldMask updateMask) {
    UpdateExternalApiRequest request =
        UpdateExternalApiRequest.newBuilder()
            .setExternalApi(externalApi)
            .setUpdateMask(updateMask)
            .build();
    return updateExternalApi(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update an External API resource in the API hub. The following fields can be updated:
   *
   * <ul>
   *   <li>[display_name][google.cloud.apihub.v1.ExternalApi.display_name]
   *   <li>[description][google.cloud.apihub.v1.ExternalApi.description]
   *   <li>[documentation][google.cloud.apihub.v1.ExternalApi.documentation]
   *   <li>[endpoints][google.cloud.apihub.v1.ExternalApi.endpoints]
   *   <li>[paths][google.cloud.apihub.v1.ExternalApi.paths]
   * </ul>
   *
   * <p>The [update_mask][google.cloud.apihub.v1.UpdateExternalApiRequest.update_mask] should be
   * used to specify the fields being updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   UpdateExternalApiRequest request =
   *       UpdateExternalApiRequest.newBuilder()
   *           .setExternalApi(ExternalApi.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ExternalApi response = apiHubClient.updateExternalApi(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExternalApi updateExternalApi(UpdateExternalApiRequest request) {
    return updateExternalApiCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update an External API resource in the API hub. The following fields can be updated:
   *
   * <ul>
   *   <li>[display_name][google.cloud.apihub.v1.ExternalApi.display_name]
   *   <li>[description][google.cloud.apihub.v1.ExternalApi.description]
   *   <li>[documentation][google.cloud.apihub.v1.ExternalApi.documentation]
   *   <li>[endpoints][google.cloud.apihub.v1.ExternalApi.endpoints]
   *   <li>[paths][google.cloud.apihub.v1.ExternalApi.paths]
   * </ul>
   *
   * <p>The [update_mask][google.cloud.apihub.v1.UpdateExternalApiRequest.update_mask] should be
   * used to specify the fields being updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   UpdateExternalApiRequest request =
   *       UpdateExternalApiRequest.newBuilder()
   *           .setExternalApi(ExternalApi.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<ExternalApi> future = apiHubClient.updateExternalApiCallable().futureCall(request);
   *   // Do something.
   *   ExternalApi response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateExternalApiRequest, ExternalApi> updateExternalApiCallable() {
    return stub.updateExternalApiCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an External API resource in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   ExternalApiName name = ExternalApiName.of("[PROJECT]", "[LOCATION]", "[EXTERNAL_API]");
   *   apiHubClient.deleteExternalApi(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the External API resource to delete. Format:
   *     `projects/{project}/locations/{location}/externalApis/{externalApi}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteExternalApi(ExternalApiName name) {
    DeleteExternalApiRequest request =
        DeleteExternalApiRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteExternalApi(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an External API resource in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   String name = ExternalApiName.of("[PROJECT]", "[LOCATION]", "[EXTERNAL_API]").toString();
   *   apiHubClient.deleteExternalApi(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the External API resource to delete. Format:
   *     `projects/{project}/locations/{location}/externalApis/{externalApi}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteExternalApi(String name) {
    DeleteExternalApiRequest request = DeleteExternalApiRequest.newBuilder().setName(name).build();
    deleteExternalApi(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an External API resource in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   DeleteExternalApiRequest request =
   *       DeleteExternalApiRequest.newBuilder()
   *           .setName(ExternalApiName.of("[PROJECT]", "[LOCATION]", "[EXTERNAL_API]").toString())
   *           .build();
   *   apiHubClient.deleteExternalApi(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteExternalApi(DeleteExternalApiRequest request) {
    deleteExternalApiCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an External API resource in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   DeleteExternalApiRequest request =
   *       DeleteExternalApiRequest.newBuilder()
   *           .setName(ExternalApiName.of("[PROJECT]", "[LOCATION]", "[EXTERNAL_API]").toString())
   *           .build();
   *   ApiFuture<Empty> future = apiHubClient.deleteExternalApiCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteExternalApiRequest, Empty> deleteExternalApiCallable() {
    return stub.deleteExternalApiCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List External API resources in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ExternalApi element : apiHubClient.listExternalApis(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of External API resources.
   *     Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExternalApisPagedResponse listExternalApis(LocationName parent) {
    ListExternalApisRequest request =
        ListExternalApisRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listExternalApis(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List External API resources in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ExternalApi element : apiHubClient.listExternalApis(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of External API resources.
   *     Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExternalApisPagedResponse listExternalApis(String parent) {
    ListExternalApisRequest request =
        ListExternalApisRequest.newBuilder().setParent(parent).build();
    return listExternalApis(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List External API resources in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   ListExternalApisRequest request =
   *       ListExternalApisRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ExternalApi element : apiHubClient.listExternalApis(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExternalApisPagedResponse listExternalApis(ListExternalApisRequest request) {
    return listExternalApisPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List External API resources in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   ListExternalApisRequest request =
   *       ListExternalApisRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ExternalApi> future =
   *       apiHubClient.listExternalApisPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ExternalApi element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListExternalApisRequest, ListExternalApisPagedResponse>
      listExternalApisPagedCallable() {
    return stub.listExternalApisPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List External API resources in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   ListExternalApisRequest request =
   *       ListExternalApisRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListExternalApisResponse response = apiHubClient.listExternalApisCallable().call(request);
   *     for (ExternalApi element : response.getExternalApisList()) {
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
  public final UnaryCallable<ListExternalApisRequest, ListExternalApisResponse>
      listExternalApisCallable() {
    return stub.listExternalApisCallable();
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
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : apiHubClient.listLocations(request).iterateAll()) {
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
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future = apiHubClient.listLocationsPagedCallable().futureCall(request);
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
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = apiHubClient.listLocationsCallable().call(request);
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
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = apiHubClient.getLocation(request);
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
   * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = apiHubClient.getLocationCallable().futureCall(request);
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

  public static class ListApisPagedResponse
      extends AbstractPagedListResponse<
          ListApisRequest, ListApisResponse, Api, ListApisPage, ListApisFixedSizeCollection> {

    public static ApiFuture<ListApisPagedResponse> createAsync(
        PageContext<ListApisRequest, ListApisResponse, Api> context,
        ApiFuture<ListApisResponse> futureResponse) {
      ApiFuture<ListApisPage> futurePage =
          ListApisPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListApisPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListApisPagedResponse(ListApisPage page) {
      super(page, ListApisFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListApisPage
      extends AbstractPage<ListApisRequest, ListApisResponse, Api, ListApisPage> {

    private ListApisPage(
        PageContext<ListApisRequest, ListApisResponse, Api> context, ListApisResponse response) {
      super(context, response);
    }

    private static ListApisPage createEmptyPage() {
      return new ListApisPage(null, null);
    }

    @Override
    protected ListApisPage createPage(
        PageContext<ListApisRequest, ListApisResponse, Api> context, ListApisResponse response) {
      return new ListApisPage(context, response);
    }

    @Override
    public ApiFuture<ListApisPage> createPageAsync(
        PageContext<ListApisRequest, ListApisResponse, Api> context,
        ApiFuture<ListApisResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListApisFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListApisRequest, ListApisResponse, Api, ListApisPage, ListApisFixedSizeCollection> {

    private ListApisFixedSizeCollection(List<ListApisPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListApisFixedSizeCollection createEmptyCollection() {
      return new ListApisFixedSizeCollection(null, 0);
    }

    @Override
    protected ListApisFixedSizeCollection createCollection(
        List<ListApisPage> pages, int collectionSize) {
      return new ListApisFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListVersionsPagedResponse
      extends AbstractPagedListResponse<
          ListVersionsRequest,
          ListVersionsResponse,
          Version,
          ListVersionsPage,
          ListVersionsFixedSizeCollection> {

    public static ApiFuture<ListVersionsPagedResponse> createAsync(
        PageContext<ListVersionsRequest, ListVersionsResponse, Version> context,
        ApiFuture<ListVersionsResponse> futureResponse) {
      ApiFuture<ListVersionsPage> futurePage =
          ListVersionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListVersionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListVersionsPagedResponse(ListVersionsPage page) {
      super(page, ListVersionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListVersionsPage
      extends AbstractPage<ListVersionsRequest, ListVersionsResponse, Version, ListVersionsPage> {

    private ListVersionsPage(
        PageContext<ListVersionsRequest, ListVersionsResponse, Version> context,
        ListVersionsResponse response) {
      super(context, response);
    }

    private static ListVersionsPage createEmptyPage() {
      return new ListVersionsPage(null, null);
    }

    @Override
    protected ListVersionsPage createPage(
        PageContext<ListVersionsRequest, ListVersionsResponse, Version> context,
        ListVersionsResponse response) {
      return new ListVersionsPage(context, response);
    }

    @Override
    public ApiFuture<ListVersionsPage> createPageAsync(
        PageContext<ListVersionsRequest, ListVersionsResponse, Version> context,
        ApiFuture<ListVersionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListVersionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListVersionsRequest,
          ListVersionsResponse,
          Version,
          ListVersionsPage,
          ListVersionsFixedSizeCollection> {

    private ListVersionsFixedSizeCollection(List<ListVersionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListVersionsFixedSizeCollection createEmptyCollection() {
      return new ListVersionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListVersionsFixedSizeCollection createCollection(
        List<ListVersionsPage> pages, int collectionSize) {
      return new ListVersionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSpecsPagedResponse
      extends AbstractPagedListResponse<
          ListSpecsRequest, ListSpecsResponse, Spec, ListSpecsPage, ListSpecsFixedSizeCollection> {

    public static ApiFuture<ListSpecsPagedResponse> createAsync(
        PageContext<ListSpecsRequest, ListSpecsResponse, Spec> context,
        ApiFuture<ListSpecsResponse> futureResponse) {
      ApiFuture<ListSpecsPage> futurePage =
          ListSpecsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListSpecsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListSpecsPagedResponse(ListSpecsPage page) {
      super(page, ListSpecsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSpecsPage
      extends AbstractPage<ListSpecsRequest, ListSpecsResponse, Spec, ListSpecsPage> {

    private ListSpecsPage(
        PageContext<ListSpecsRequest, ListSpecsResponse, Spec> context,
        ListSpecsResponse response) {
      super(context, response);
    }

    private static ListSpecsPage createEmptyPage() {
      return new ListSpecsPage(null, null);
    }

    @Override
    protected ListSpecsPage createPage(
        PageContext<ListSpecsRequest, ListSpecsResponse, Spec> context,
        ListSpecsResponse response) {
      return new ListSpecsPage(context, response);
    }

    @Override
    public ApiFuture<ListSpecsPage> createPageAsync(
        PageContext<ListSpecsRequest, ListSpecsResponse, Spec> context,
        ApiFuture<ListSpecsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSpecsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSpecsRequest, ListSpecsResponse, Spec, ListSpecsPage, ListSpecsFixedSizeCollection> {

    private ListSpecsFixedSizeCollection(List<ListSpecsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSpecsFixedSizeCollection createEmptyCollection() {
      return new ListSpecsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSpecsFixedSizeCollection createCollection(
        List<ListSpecsPage> pages, int collectionSize) {
      return new ListSpecsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListApiOperationsPagedResponse
      extends AbstractPagedListResponse<
          ListApiOperationsRequest,
          ListApiOperationsResponse,
          ApiOperation,
          ListApiOperationsPage,
          ListApiOperationsFixedSizeCollection> {

    public static ApiFuture<ListApiOperationsPagedResponse> createAsync(
        PageContext<ListApiOperationsRequest, ListApiOperationsResponse, ApiOperation> context,
        ApiFuture<ListApiOperationsResponse> futureResponse) {
      ApiFuture<ListApiOperationsPage> futurePage =
          ListApiOperationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListApiOperationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListApiOperationsPagedResponse(ListApiOperationsPage page) {
      super(page, ListApiOperationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListApiOperationsPage
      extends AbstractPage<
          ListApiOperationsRequest,
          ListApiOperationsResponse,
          ApiOperation,
          ListApiOperationsPage> {

    private ListApiOperationsPage(
        PageContext<ListApiOperationsRequest, ListApiOperationsResponse, ApiOperation> context,
        ListApiOperationsResponse response) {
      super(context, response);
    }

    private static ListApiOperationsPage createEmptyPage() {
      return new ListApiOperationsPage(null, null);
    }

    @Override
    protected ListApiOperationsPage createPage(
        PageContext<ListApiOperationsRequest, ListApiOperationsResponse, ApiOperation> context,
        ListApiOperationsResponse response) {
      return new ListApiOperationsPage(context, response);
    }

    @Override
    public ApiFuture<ListApiOperationsPage> createPageAsync(
        PageContext<ListApiOperationsRequest, ListApiOperationsResponse, ApiOperation> context,
        ApiFuture<ListApiOperationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListApiOperationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListApiOperationsRequest,
          ListApiOperationsResponse,
          ApiOperation,
          ListApiOperationsPage,
          ListApiOperationsFixedSizeCollection> {

    private ListApiOperationsFixedSizeCollection(
        List<ListApiOperationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListApiOperationsFixedSizeCollection createEmptyCollection() {
      return new ListApiOperationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListApiOperationsFixedSizeCollection createCollection(
        List<ListApiOperationsPage> pages, int collectionSize) {
      return new ListApiOperationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDeploymentsPagedResponse
      extends AbstractPagedListResponse<
          ListDeploymentsRequest,
          ListDeploymentsResponse,
          Deployment,
          ListDeploymentsPage,
          ListDeploymentsFixedSizeCollection> {

    public static ApiFuture<ListDeploymentsPagedResponse> createAsync(
        PageContext<ListDeploymentsRequest, ListDeploymentsResponse, Deployment> context,
        ApiFuture<ListDeploymentsResponse> futureResponse) {
      ApiFuture<ListDeploymentsPage> futurePage =
          ListDeploymentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDeploymentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDeploymentsPagedResponse(ListDeploymentsPage page) {
      super(page, ListDeploymentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDeploymentsPage
      extends AbstractPage<
          ListDeploymentsRequest, ListDeploymentsResponse, Deployment, ListDeploymentsPage> {

    private ListDeploymentsPage(
        PageContext<ListDeploymentsRequest, ListDeploymentsResponse, Deployment> context,
        ListDeploymentsResponse response) {
      super(context, response);
    }

    private static ListDeploymentsPage createEmptyPage() {
      return new ListDeploymentsPage(null, null);
    }

    @Override
    protected ListDeploymentsPage createPage(
        PageContext<ListDeploymentsRequest, ListDeploymentsResponse, Deployment> context,
        ListDeploymentsResponse response) {
      return new ListDeploymentsPage(context, response);
    }

    @Override
    public ApiFuture<ListDeploymentsPage> createPageAsync(
        PageContext<ListDeploymentsRequest, ListDeploymentsResponse, Deployment> context,
        ApiFuture<ListDeploymentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDeploymentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDeploymentsRequest,
          ListDeploymentsResponse,
          Deployment,
          ListDeploymentsPage,
          ListDeploymentsFixedSizeCollection> {

    private ListDeploymentsFixedSizeCollection(
        List<ListDeploymentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDeploymentsFixedSizeCollection createEmptyCollection() {
      return new ListDeploymentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDeploymentsFixedSizeCollection createCollection(
        List<ListDeploymentsPage> pages, int collectionSize) {
      return new ListDeploymentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAttributesPagedResponse
      extends AbstractPagedListResponse<
          ListAttributesRequest,
          ListAttributesResponse,
          Attribute,
          ListAttributesPage,
          ListAttributesFixedSizeCollection> {

    public static ApiFuture<ListAttributesPagedResponse> createAsync(
        PageContext<ListAttributesRequest, ListAttributesResponse, Attribute> context,
        ApiFuture<ListAttributesResponse> futureResponse) {
      ApiFuture<ListAttributesPage> futurePage =
          ListAttributesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAttributesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAttributesPagedResponse(ListAttributesPage page) {
      super(page, ListAttributesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAttributesPage
      extends AbstractPage<
          ListAttributesRequest, ListAttributesResponse, Attribute, ListAttributesPage> {

    private ListAttributesPage(
        PageContext<ListAttributesRequest, ListAttributesResponse, Attribute> context,
        ListAttributesResponse response) {
      super(context, response);
    }

    private static ListAttributesPage createEmptyPage() {
      return new ListAttributesPage(null, null);
    }

    @Override
    protected ListAttributesPage createPage(
        PageContext<ListAttributesRequest, ListAttributesResponse, Attribute> context,
        ListAttributesResponse response) {
      return new ListAttributesPage(context, response);
    }

    @Override
    public ApiFuture<ListAttributesPage> createPageAsync(
        PageContext<ListAttributesRequest, ListAttributesResponse, Attribute> context,
        ApiFuture<ListAttributesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAttributesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAttributesRequest,
          ListAttributesResponse,
          Attribute,
          ListAttributesPage,
          ListAttributesFixedSizeCollection> {

    private ListAttributesFixedSizeCollection(List<ListAttributesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAttributesFixedSizeCollection createEmptyCollection() {
      return new ListAttributesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAttributesFixedSizeCollection createCollection(
        List<ListAttributesPage> pages, int collectionSize) {
      return new ListAttributesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchResourcesPagedResponse
      extends AbstractPagedListResponse<
          SearchResourcesRequest,
          SearchResourcesResponse,
          SearchResult,
          SearchResourcesPage,
          SearchResourcesFixedSizeCollection> {

    public static ApiFuture<SearchResourcesPagedResponse> createAsync(
        PageContext<SearchResourcesRequest, SearchResourcesResponse, SearchResult> context,
        ApiFuture<SearchResourcesResponse> futureResponse) {
      ApiFuture<SearchResourcesPage> futurePage =
          SearchResourcesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchResourcesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchResourcesPagedResponse(SearchResourcesPage page) {
      super(page, SearchResourcesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchResourcesPage
      extends AbstractPage<
          SearchResourcesRequest, SearchResourcesResponse, SearchResult, SearchResourcesPage> {

    private SearchResourcesPage(
        PageContext<SearchResourcesRequest, SearchResourcesResponse, SearchResult> context,
        SearchResourcesResponse response) {
      super(context, response);
    }

    private static SearchResourcesPage createEmptyPage() {
      return new SearchResourcesPage(null, null);
    }

    @Override
    protected SearchResourcesPage createPage(
        PageContext<SearchResourcesRequest, SearchResourcesResponse, SearchResult> context,
        SearchResourcesResponse response) {
      return new SearchResourcesPage(context, response);
    }

    @Override
    public ApiFuture<SearchResourcesPage> createPageAsync(
        PageContext<SearchResourcesRequest, SearchResourcesResponse, SearchResult> context,
        ApiFuture<SearchResourcesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchResourcesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchResourcesRequest,
          SearchResourcesResponse,
          SearchResult,
          SearchResourcesPage,
          SearchResourcesFixedSizeCollection> {

    private SearchResourcesFixedSizeCollection(
        List<SearchResourcesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchResourcesFixedSizeCollection createEmptyCollection() {
      return new SearchResourcesFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchResourcesFixedSizeCollection createCollection(
        List<SearchResourcesPage> pages, int collectionSize) {
      return new SearchResourcesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListExternalApisPagedResponse
      extends AbstractPagedListResponse<
          ListExternalApisRequest,
          ListExternalApisResponse,
          ExternalApi,
          ListExternalApisPage,
          ListExternalApisFixedSizeCollection> {

    public static ApiFuture<ListExternalApisPagedResponse> createAsync(
        PageContext<ListExternalApisRequest, ListExternalApisResponse, ExternalApi> context,
        ApiFuture<ListExternalApisResponse> futureResponse) {
      ApiFuture<ListExternalApisPage> futurePage =
          ListExternalApisPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListExternalApisPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListExternalApisPagedResponse(ListExternalApisPage page) {
      super(page, ListExternalApisFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListExternalApisPage
      extends AbstractPage<
          ListExternalApisRequest, ListExternalApisResponse, ExternalApi, ListExternalApisPage> {

    private ListExternalApisPage(
        PageContext<ListExternalApisRequest, ListExternalApisResponse, ExternalApi> context,
        ListExternalApisResponse response) {
      super(context, response);
    }

    private static ListExternalApisPage createEmptyPage() {
      return new ListExternalApisPage(null, null);
    }

    @Override
    protected ListExternalApisPage createPage(
        PageContext<ListExternalApisRequest, ListExternalApisResponse, ExternalApi> context,
        ListExternalApisResponse response) {
      return new ListExternalApisPage(context, response);
    }

    @Override
    public ApiFuture<ListExternalApisPage> createPageAsync(
        PageContext<ListExternalApisRequest, ListExternalApisResponse, ExternalApi> context,
        ApiFuture<ListExternalApisResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListExternalApisFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListExternalApisRequest,
          ListExternalApisResponse,
          ExternalApi,
          ListExternalApisPage,
          ListExternalApisFixedSizeCollection> {

    private ListExternalApisFixedSizeCollection(
        List<ListExternalApisPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListExternalApisFixedSizeCollection createEmptyCollection() {
      return new ListExternalApisFixedSizeCollection(null, 0);
    }

    @Override
    protected ListExternalApisFixedSizeCollection createCollection(
        List<ListExternalApisPage> pages, int collectionSize) {
      return new ListExternalApisFixedSizeCollection(pages, collectionSize);
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
