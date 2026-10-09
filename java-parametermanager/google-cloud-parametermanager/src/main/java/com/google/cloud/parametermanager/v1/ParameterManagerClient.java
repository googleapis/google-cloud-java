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

package com.google.cloud.parametermanager.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.parametermanager.v1.stub.ParameterManagerStub;
import com.google.cloud.parametermanager.v1.stub.ParameterManagerStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service describing handlers for resources
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
 * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
 *   ParameterName name = ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]");
 *   Parameter response = parameterManagerClient.getParameter(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ParameterManagerClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListParameters</td>
 *      <td><p> Lists Parameters in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listParameters(ListParametersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listParameters(LocationName parent)
 *           <li><p> listParameters(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listParametersPagedCallable()
 *           <li><p> listParametersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetParameter</td>
 *      <td><p> Gets details of a single Parameter.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getParameter(GetParameterRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getParameter(ParameterName name)
 *           <li><p> getParameter(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getParameterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateParameter</td>
 *      <td><p> Creates a new Parameter in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createParameter(CreateParameterRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createParameter(LocationName parent, Parameter parameter, String parameterId)
 *           <li><p> createParameter(String parent, Parameter parameter, String parameterId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createParameterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateParameter</td>
 *      <td><p> Updates a single Parameter.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateParameter(UpdateParameterRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateParameter(Parameter parameter, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateParameterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteParameter</td>
 *      <td><p> Deletes a single Parameter.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteParameter(DeleteParameterRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteParameter(ParameterName name)
 *           <li><p> deleteParameter(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteParameterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListParameterVersions</td>
 *      <td><p> Lists ParameterVersions in a given project, location, and parameter.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listParameterVersions(ListParameterVersionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listParameterVersions(ParameterName parent)
 *           <li><p> listParameterVersions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listParameterVersionsPagedCallable()
 *           <li><p> listParameterVersionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetParameterVersion</td>
 *      <td><p> Gets details of a single ParameterVersion.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getParameterVersion(GetParameterVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getParameterVersion(ParameterVersionName name)
 *           <li><p> getParameterVersion(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getParameterVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RenderParameterVersion</td>
 *      <td><p> Gets rendered version of a ParameterVersion.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> renderParameterVersion(RenderParameterVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> renderParameterVersion(ParameterVersionName name)
 *           <li><p> renderParameterVersion(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> renderParameterVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateParameterVersion</td>
 *      <td><p> Creates a new ParameterVersion in a given project, location, and parameter.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createParameterVersion(CreateParameterVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createParameterVersion(ParameterName parent, ParameterVersion parameterVersion, String parameterVersionId)
 *           <li><p> createParameterVersion(String parent, ParameterVersion parameterVersion, String parameterVersionId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createParameterVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateParameterVersion</td>
 *      <td><p> Updates a single ParameterVersion.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateParameterVersion(UpdateParameterVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateParameterVersion(ParameterVersion parameterVersion, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateParameterVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteParameterVersion</td>
 *      <td><p> Deletes a single ParameterVersion.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteParameterVersion(DeleteParameterVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteParameterVersion(ParameterVersionName name)
 *           <li><p> deleteParameterVersion(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteParameterVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListTemplates</td>
 *      <td><p> Lists Templates in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listTemplates(ListTemplatesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listTemplates(LocationName parent)
 *           <li><p> listTemplates(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listTemplatesPagedCallable()
 *           <li><p> listTemplatesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetTemplate</td>
 *      <td><p> Gets details of a single Template.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getTemplate(GetTemplateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getTemplate(TemplateName name)
 *           <li><p> getTemplate(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateTemplate</td>
 *      <td><p> Creates a new Template in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createTemplate(CreateTemplateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createTemplate(LocationName parent, Template template, String templateId)
 *           <li><p> createTemplate(String parent, Template template, String templateId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateTemplate</td>
 *      <td><p> Updates a single Template.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateTemplate(UpdateTemplateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateTemplate(Template template, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteTemplate</td>
 *      <td><p> Deletes a single Template.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteTemplate(DeleteTemplateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteTemplate(TemplateName name)
 *           <li><p> deleteTemplate(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListTemplateVersions</td>
 *      <td><p> Lists TemplateVersions in a given project, location, and template.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listTemplateVersions(ListTemplateVersionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listTemplateVersions(TemplateName parent)
 *           <li><p> listTemplateVersions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listTemplateVersionsPagedCallable()
 *           <li><p> listTemplateVersionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetTemplateVersion</td>
 *      <td><p> Gets details of a single TemplateVersion.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getTemplateVersion(GetTemplateVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getTemplateVersion(TemplateVersionName name)
 *           <li><p> getTemplateVersion(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getTemplateVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateTemplateVersion</td>
 *      <td><p> Creates a new TemplateVersion in a given project, location, and template.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createTemplateVersion(CreateTemplateVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createTemplateVersion(TemplateName parent, TemplateVersion templateVersion, String templateVersionId)
 *           <li><p> createTemplateVersion(String parent, TemplateVersion templateVersion, String templateVersionId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createTemplateVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateTemplateVersion</td>
 *      <td><p> Updates a single TemplateVersion.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateTemplateVersion(UpdateTemplateVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateTemplateVersion(TemplateVersion templateVersion, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateTemplateVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteTemplateVersion</td>
 *      <td><p> Deletes a single TemplateVersion.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteTemplateVersion(DeleteTemplateVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteTemplateVersion(TemplateVersionName name)
 *           <li><p> deleteTemplateVersion(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteTemplateVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RenderTemplateVersion</td>
 *      <td><p> Gets rendered version of a TemplateVersion.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> renderTemplateVersion(RenderTemplateVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> renderTemplateVersion(TemplateVersionName name)
 *           <li><p> renderTemplateVersion(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> renderTemplateVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.
 * <p> This method lists locations based on the resource scope provided inthe [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field: &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If `name` follows the format`projects/{project}`, the method lists locations visible to thatspecific project. This includes public, private, or otherproject-specific locations enabled for the project.
 * <p> For gRPC and client library implementations, the resource name ispassed as the `name` field. For direct service calls, the resourcename isincorporated into the request path based on the specific serviceimplementation and version.</td>
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
 * <p>This class can be customized by passing in a custom instance of ParameterManagerSettings to
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
 * ParameterManagerSettings parameterManagerSettings =
 *     ParameterManagerSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ParameterManagerClient parameterManagerClient =
 *     ParameterManagerClient.create(parameterManagerSettings);
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
 * ParameterManagerSettings parameterManagerSettings =
 *     ParameterManagerSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ParameterManagerClient parameterManagerClient =
 *     ParameterManagerClient.create(parameterManagerSettings);
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
 * ParameterManagerSettings parameterManagerSettings =
 *     ParameterManagerSettings.newHttpJsonBuilder().build();
 * ParameterManagerClient parameterManagerClient =
 *     ParameterManagerClient.create(parameterManagerSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class ParameterManagerClient implements BackgroundResource {
  private final @Nullable ParameterManagerSettings settings;
  private final ParameterManagerStub stub;

  /** Constructs an instance of ParameterManagerClient with default settings. */
  public static final ParameterManagerClient create() throws IOException {
    return create(ParameterManagerSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ParameterManagerClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ParameterManagerClient create(ParameterManagerSettings settings)
      throws IOException {
    return new ParameterManagerClient(settings);
  }

  /**
   * Constructs an instance of ParameterManagerClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(ParameterManagerSettings).
   */
  public static final ParameterManagerClient create(ParameterManagerStub stub) {
    return new ParameterManagerClient(stub);
  }

  /**
   * Constructs an instance of ParameterManagerClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ParameterManagerClient(ParameterManagerSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ParameterManagerStubSettings) settings.getStubSettings()).createStub();
  }

  protected ParameterManagerClient(ParameterManagerStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable ParameterManagerSettings getSettings() {
    return settings;
  }

  public ParameterManagerStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Parameters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Parameter element : parameterManagerClient.listParameters(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListParametersRequest in the format
   *     `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListParametersPagedResponse listParameters(@Nullable LocationName parent) {
    ListParametersRequest request =
        ListParametersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listParameters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Parameters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Parameter element : parameterManagerClient.listParameters(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListParametersRequest in the format
   *     `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListParametersPagedResponse listParameters(String parent) {
    ListParametersRequest request = ListParametersRequest.newBuilder().setParent(parent).build();
    return listParameters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Parameters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   ListParametersRequest request =
   *       ListParametersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Parameter element : parameterManagerClient.listParameters(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListParametersPagedResponse listParameters(ListParametersRequest request) {
    return listParametersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Parameters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   ListParametersRequest request =
   *       ListParametersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Parameter> future =
   *       parameterManagerClient.listParametersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Parameter element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListParametersRequest, ListParametersPagedResponse>
      listParametersPagedCallable() {
    return stub.listParametersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Parameters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   ListParametersRequest request =
   *       ListParametersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListParametersResponse response =
   *         parameterManagerClient.listParametersCallable().call(request);
   *     for (Parameter element : response.getParametersList()) {
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
  public final UnaryCallable<ListParametersRequest, ListParametersResponse>
      listParametersCallable() {
    return stub.listParametersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Parameter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   ParameterName name = ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]");
   *   Parameter response = parameterManagerClient.getParameter(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource in the format
   *     `projects/&#42;/locations/&#42;/parameters/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Parameter getParameter(@Nullable ParameterName name) {
    GetParameterRequest request =
        GetParameterRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getParameter(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Parameter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   String name = ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]").toString();
   *   Parameter response = parameterManagerClient.getParameter(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource in the format
   *     `projects/&#42;/locations/&#42;/parameters/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Parameter getParameter(String name) {
    GetParameterRequest request = GetParameterRequest.newBuilder().setName(name).build();
    return getParameter(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Parameter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   GetParameterRequest request =
   *       GetParameterRequest.newBuilder()
   *           .setName(ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]").toString())
   *           .build();
   *   Parameter response = parameterManagerClient.getParameter(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Parameter getParameter(GetParameterRequest request) {
    return getParameterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Parameter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   GetParameterRequest request =
   *       GetParameterRequest.newBuilder()
   *           .setName(ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]").toString())
   *           .build();
   *   ApiFuture<Parameter> future =
   *       parameterManagerClient.getParameterCallable().futureCall(request);
   *   // Do something.
   *   Parameter response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetParameterRequest, Parameter> getParameterCallable() {
    return stub.getParameterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Parameter in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Parameter parameter = Parameter.newBuilder().build();
   *   String parameterId = "parameterId1335916196";
   *   Parameter response = parameterManagerClient.createParameter(parent, parameter, parameterId);
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent in the format `projects/&#42;/locations/&#42;`.
   * @param parameter Required. The Parameter resource being created
   * @param parameterId Required. Id of the Parameter resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Parameter createParameter(
      @Nullable LocationName parent, Parameter parameter, String parameterId) {
    CreateParameterRequest request =
        CreateParameterRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setParameter(parameter)
            .setParameterId(parameterId)
            .build();
    return createParameter(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Parameter in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Parameter parameter = Parameter.newBuilder().build();
   *   String parameterId = "parameterId1335916196";
   *   Parameter response = parameterManagerClient.createParameter(parent, parameter, parameterId);
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent in the format `projects/&#42;/locations/&#42;`.
   * @param parameter Required. The Parameter resource being created
   * @param parameterId Required. Id of the Parameter resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Parameter createParameter(String parent, Parameter parameter, String parameterId) {
    CreateParameterRequest request =
        CreateParameterRequest.newBuilder()
            .setParent(parent)
            .setParameter(parameter)
            .setParameterId(parameterId)
            .build();
    return createParameter(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Parameter in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   CreateParameterRequest request =
   *       CreateParameterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setParameterId("parameterId1335916196")
   *           .setParameter(Parameter.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Parameter response = parameterManagerClient.createParameter(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Parameter createParameter(CreateParameterRequest request) {
    return createParameterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Parameter in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   CreateParameterRequest request =
   *       CreateParameterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setParameterId("parameterId1335916196")
   *           .setParameter(Parameter.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Parameter> future =
   *       parameterManagerClient.createParameterCallable().futureCall(request);
   *   // Do something.
   *   Parameter response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateParameterRequest, Parameter> createParameterCallable() {
    return stub.createParameterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single Parameter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   Parameter parameter = Parameter.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Parameter response = parameterManagerClient.updateParameter(parameter, updateMask);
   * }
   * }</pre>
   *
   * @param parameter Required. The Parameter resource being updated
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     Parameter resource by the update. The fields specified in the update_mask are relative to
   *     the resource, not the full request. A mutable field will be overwritten if it is in the
   *     mask. If the user does not provide a mask then all mutable fields present in the request
   *     will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Parameter updateParameter(Parameter parameter, FieldMask updateMask) {
    UpdateParameterRequest request =
        UpdateParameterRequest.newBuilder()
            .setParameter(parameter)
            .setUpdateMask(updateMask)
            .build();
    return updateParameter(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single Parameter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   UpdateParameterRequest request =
   *       UpdateParameterRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setParameter(Parameter.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Parameter response = parameterManagerClient.updateParameter(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Parameter updateParameter(UpdateParameterRequest request) {
    return updateParameterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single Parameter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   UpdateParameterRequest request =
   *       UpdateParameterRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setParameter(Parameter.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Parameter> future =
   *       parameterManagerClient.updateParameterCallable().futureCall(request);
   *   // Do something.
   *   Parameter response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateParameterRequest, Parameter> updateParameterCallable() {
    return stub.updateParameterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Parameter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   ParameterName name = ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]");
   *   parameterManagerClient.deleteParameter(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource in the format
   *     `projects/&#42;/locations/&#42;/parameters/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteParameter(@Nullable ParameterName name) {
    DeleteParameterRequest request =
        DeleteParameterRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteParameter(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Parameter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   String name = ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]").toString();
   *   parameterManagerClient.deleteParameter(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource in the format
   *     `projects/&#42;/locations/&#42;/parameters/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteParameter(String name) {
    DeleteParameterRequest request = DeleteParameterRequest.newBuilder().setName(name).build();
    deleteParameter(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Parameter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   DeleteParameterRequest request =
   *       DeleteParameterRequest.newBuilder()
   *           .setName(ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   parameterManagerClient.deleteParameter(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteParameter(DeleteParameterRequest request) {
    deleteParameterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Parameter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   DeleteParameterRequest request =
   *       DeleteParameterRequest.newBuilder()
   *           .setName(ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Empty> future =
   *       parameterManagerClient.deleteParameterCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteParameterRequest, Empty> deleteParameterCallable() {
    return stub.deleteParameterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ParameterVersions in a given project, location, and parameter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   ParameterName parent = ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]");
   *   for (ParameterVersion element :
   *       parameterManagerClient.listParameterVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListParameterVersionsRequest in the format
   *     `projects/&#42;/locations/&#42;/parameters/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListParameterVersionsPagedResponse listParameterVersions(
      @Nullable ParameterName parent) {
    ListParameterVersionsRequest request =
        ListParameterVersionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listParameterVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ParameterVersions in a given project, location, and parameter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   String parent = ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]").toString();
   *   for (ParameterVersion element :
   *       parameterManagerClient.listParameterVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListParameterVersionsRequest in the format
   *     `projects/&#42;/locations/&#42;/parameters/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListParameterVersionsPagedResponse listParameterVersions(String parent) {
    ListParameterVersionsRequest request =
        ListParameterVersionsRequest.newBuilder().setParent(parent).build();
    return listParameterVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ParameterVersions in a given project, location, and parameter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   ListParameterVersionsRequest request =
   *       ListParameterVersionsRequest.newBuilder()
   *           .setParent(ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ParameterVersion element :
   *       parameterManagerClient.listParameterVersions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListParameterVersionsPagedResponse listParameterVersions(
      ListParameterVersionsRequest request) {
    return listParameterVersionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ParameterVersions in a given project, location, and parameter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   ListParameterVersionsRequest request =
   *       ListParameterVersionsRequest.newBuilder()
   *           .setParent(ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ParameterVersion> future =
   *       parameterManagerClient.listParameterVersionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ParameterVersion element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListParameterVersionsRequest, ListParameterVersionsPagedResponse>
      listParameterVersionsPagedCallable() {
    return stub.listParameterVersionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ParameterVersions in a given project, location, and parameter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   ListParameterVersionsRequest request =
   *       ListParameterVersionsRequest.newBuilder()
   *           .setParent(ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListParameterVersionsResponse response =
   *         parameterManagerClient.listParameterVersionsCallable().call(request);
   *     for (ParameterVersion element : response.getParameterVersionsList()) {
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
  public final UnaryCallable<ListParameterVersionsRequest, ListParameterVersionsResponse>
      listParameterVersionsCallable() {
    return stub.listParameterVersionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ParameterVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   ParameterVersionName name =
   *       ParameterVersionName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]");
   *   ParameterVersion response = parameterManagerClient.getParameterVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource in the format
   *     `projects/&#42;/locations/&#42;/parameters/&#42;/versions/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ParameterVersion getParameterVersion(@Nullable ParameterVersionName name) {
    GetParameterVersionRequest request =
        GetParameterVersionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getParameterVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ParameterVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   String name =
   *       ParameterVersionName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]")
   *           .toString();
   *   ParameterVersion response = parameterManagerClient.getParameterVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource in the format
   *     `projects/&#42;/locations/&#42;/parameters/&#42;/versions/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ParameterVersion getParameterVersion(String name) {
    GetParameterVersionRequest request =
        GetParameterVersionRequest.newBuilder().setName(name).build();
    return getParameterVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ParameterVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   GetParameterVersionRequest request =
   *       GetParameterVersionRequest.newBuilder()
   *           .setName(
   *               ParameterVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]")
   *                   .toString())
   *           .setView(View.forNumber(0))
   *           .build();
   *   ParameterVersion response = parameterManagerClient.getParameterVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ParameterVersion getParameterVersion(GetParameterVersionRequest request) {
    return getParameterVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ParameterVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   GetParameterVersionRequest request =
   *       GetParameterVersionRequest.newBuilder()
   *           .setName(
   *               ParameterVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]")
   *                   .toString())
   *           .setView(View.forNumber(0))
   *           .build();
   *   ApiFuture<ParameterVersion> future =
   *       parameterManagerClient.getParameterVersionCallable().futureCall(request);
   *   // Do something.
   *   ParameterVersion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetParameterVersionRequest, ParameterVersion>
      getParameterVersionCallable() {
    return stub.getParameterVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets rendered version of a ParameterVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   ParameterVersionName name =
   *       ParameterVersionName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]");
   *   RenderParameterVersionResponse response = parameterManagerClient.renderParameterVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RenderParameterVersionResponse renderParameterVersion(
      @Nullable ParameterVersionName name) {
    RenderParameterVersionRequest request =
        RenderParameterVersionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return renderParameterVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets rendered version of a ParameterVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   String name =
   *       ParameterVersionName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]")
   *           .toString();
   *   RenderParameterVersionResponse response = parameterManagerClient.renderParameterVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RenderParameterVersionResponse renderParameterVersion(String name) {
    RenderParameterVersionRequest request =
        RenderParameterVersionRequest.newBuilder().setName(name).build();
    return renderParameterVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets rendered version of a ParameterVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   RenderParameterVersionRequest request =
   *       RenderParameterVersionRequest.newBuilder()
   *           .setName(
   *               ParameterVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]")
   *                   .toString())
   *           .build();
   *   RenderParameterVersionResponse response =
   *       parameterManagerClient.renderParameterVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RenderParameterVersionResponse renderParameterVersion(
      RenderParameterVersionRequest request) {
    return renderParameterVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets rendered version of a ParameterVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   RenderParameterVersionRequest request =
   *       RenderParameterVersionRequest.newBuilder()
   *           .setName(
   *               ParameterVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<RenderParameterVersionResponse> future =
   *       parameterManagerClient.renderParameterVersionCallable().futureCall(request);
   *   // Do something.
   *   RenderParameterVersionResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RenderParameterVersionRequest, RenderParameterVersionResponse>
      renderParameterVersionCallable() {
    return stub.renderParameterVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ParameterVersion in a given project, location, and parameter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   ParameterName parent = ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]");
   *   ParameterVersion parameterVersion = ParameterVersion.newBuilder().build();
   *   String parameterVersionId = "parameterVersionId2070530666";
   *   ParameterVersion response =
   *       parameterManagerClient.createParameterVersion(
   *           parent, parameterVersion, parameterVersionId);
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent in the format
   *     `projects/&#42;/locations/&#42;/parameters/&#42;`.
   * @param parameterVersion Required. The ParameterVersion resource being created
   * @param parameterVersionId Required. Id of the ParameterVersion resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ParameterVersion createParameterVersion(
      @Nullable ParameterName parent,
      ParameterVersion parameterVersion,
      String parameterVersionId) {
    CreateParameterVersionRequest request =
        CreateParameterVersionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setParameterVersion(parameterVersion)
            .setParameterVersionId(parameterVersionId)
            .build();
    return createParameterVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ParameterVersion in a given project, location, and parameter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   String parent = ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]").toString();
   *   ParameterVersion parameterVersion = ParameterVersion.newBuilder().build();
   *   String parameterVersionId = "parameterVersionId2070530666";
   *   ParameterVersion response =
   *       parameterManagerClient.createParameterVersion(
   *           parent, parameterVersion, parameterVersionId);
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent in the format
   *     `projects/&#42;/locations/&#42;/parameters/&#42;`.
   * @param parameterVersion Required. The ParameterVersion resource being created
   * @param parameterVersionId Required. Id of the ParameterVersion resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ParameterVersion createParameterVersion(
      String parent, ParameterVersion parameterVersion, String parameterVersionId) {
    CreateParameterVersionRequest request =
        CreateParameterVersionRequest.newBuilder()
            .setParent(parent)
            .setParameterVersion(parameterVersion)
            .setParameterVersionId(parameterVersionId)
            .build();
    return createParameterVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ParameterVersion in a given project, location, and parameter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   CreateParameterVersionRequest request =
   *       CreateParameterVersionRequest.newBuilder()
   *           .setParent(ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]").toString())
   *           .setParameterVersionId("parameterVersionId2070530666")
   *           .setParameterVersion(ParameterVersion.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ParameterVersion response = parameterManagerClient.createParameterVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ParameterVersion createParameterVersion(CreateParameterVersionRequest request) {
    return createParameterVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ParameterVersion in a given project, location, and parameter.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   CreateParameterVersionRequest request =
   *       CreateParameterVersionRequest.newBuilder()
   *           .setParent(ParameterName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]").toString())
   *           .setParameterVersionId("parameterVersionId2070530666")
   *           .setParameterVersion(ParameterVersion.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<ParameterVersion> future =
   *       parameterManagerClient.createParameterVersionCallable().futureCall(request);
   *   // Do something.
   *   ParameterVersion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateParameterVersionRequest, ParameterVersion>
      createParameterVersionCallable() {
    return stub.createParameterVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single ParameterVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   ParameterVersion parameterVersion = ParameterVersion.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ParameterVersion response =
   *       parameterManagerClient.updateParameterVersion(parameterVersion, updateMask);
   * }
   * }</pre>
   *
   * @param parameterVersion Required. The ParameterVersion resource being updated
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     ParameterVersion resource by the update. The fields specified in the update_mask are
   *     relative to the resource, not the full request. A mutable field will be overwritten if it
   *     is in the mask. If the user does not provide a mask then all mutable fields present in the
   *     request will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ParameterVersion updateParameterVersion(
      ParameterVersion parameterVersion, FieldMask updateMask) {
    UpdateParameterVersionRequest request =
        UpdateParameterVersionRequest.newBuilder()
            .setParameterVersion(parameterVersion)
            .setUpdateMask(updateMask)
            .build();
    return updateParameterVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single ParameterVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   UpdateParameterVersionRequest request =
   *       UpdateParameterVersionRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setParameterVersion(ParameterVersion.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ParameterVersion response = parameterManagerClient.updateParameterVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ParameterVersion updateParameterVersion(UpdateParameterVersionRequest request) {
    return updateParameterVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single ParameterVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   UpdateParameterVersionRequest request =
   *       UpdateParameterVersionRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setParameterVersion(ParameterVersion.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<ParameterVersion> future =
   *       parameterManagerClient.updateParameterVersionCallable().futureCall(request);
   *   // Do something.
   *   ParameterVersion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateParameterVersionRequest, ParameterVersion>
      updateParameterVersionCallable() {
    return stub.updateParameterVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ParameterVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   ParameterVersionName name =
   *       ParameterVersionName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]");
   *   parameterManagerClient.deleteParameterVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource in the format
   *     `projects/&#42;/locations/&#42;/parameters/&#42;/versions/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteParameterVersion(@Nullable ParameterVersionName name) {
    DeleteParameterVersionRequest request =
        DeleteParameterVersionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteParameterVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ParameterVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   String name =
   *       ParameterVersionName.of("[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]")
   *           .toString();
   *   parameterManagerClient.deleteParameterVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource in the format
   *     `projects/&#42;/locations/&#42;/parameters/&#42;/versions/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteParameterVersion(String name) {
    DeleteParameterVersionRequest request =
        DeleteParameterVersionRequest.newBuilder().setName(name).build();
    deleteParameterVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ParameterVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   DeleteParameterVersionRequest request =
   *       DeleteParameterVersionRequest.newBuilder()
   *           .setName(
   *               ParameterVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   parameterManagerClient.deleteParameterVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteParameterVersion(DeleteParameterVersionRequest request) {
    deleteParameterVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ParameterVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   DeleteParameterVersionRequest request =
   *       DeleteParameterVersionRequest.newBuilder()
   *           .setName(
   *               ParameterVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Empty> future =
   *       parameterManagerClient.deleteParameterVersionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteParameterVersionRequest, Empty>
      deleteParameterVersionCallable() {
    return stub.deleteParameterVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Templates in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Template element : parameterManagerClient.listTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListTemplatesRequest in the format
   *     `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTemplatesPagedResponse listTemplates(@Nullable LocationName parent) {
    ListTemplatesRequest request =
        ListTemplatesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Templates in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Template element : parameterManagerClient.listTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListTemplatesRequest in the format
   *     `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTemplatesPagedResponse listTemplates(String parent) {
    ListTemplatesRequest request = ListTemplatesRequest.newBuilder().setParent(parent).build();
    return listTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Templates in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   ListTemplatesRequest request =
   *       ListTemplatesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Template element : parameterManagerClient.listTemplates(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTemplatesPagedResponse listTemplates(ListTemplatesRequest request) {
    return listTemplatesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Templates in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   ListTemplatesRequest request =
   *       ListTemplatesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Template> future =
   *       parameterManagerClient.listTemplatesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Template element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTemplatesRequest, ListTemplatesPagedResponse>
      listTemplatesPagedCallable() {
    return stub.listTemplatesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Templates in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   ListTemplatesRequest request =
   *       ListTemplatesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListTemplatesResponse response =
   *         parameterManagerClient.listTemplatesCallable().call(request);
   *     for (Template element : response.getTemplatesList()) {
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
  public final UnaryCallable<ListTemplatesRequest, ListTemplatesResponse> listTemplatesCallable() {
    return stub.listTemplatesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   TemplateName name = TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]");
   *   Template response = parameterManagerClient.getTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource in the format
   *     `projects/&#42;/locations/&#42;/templates/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Template getTemplate(@Nullable TemplateName name) {
    GetTemplateRequest request =
        GetTemplateRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   String name = TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString();
   *   Template response = parameterManagerClient.getTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource in the format
   *     `projects/&#42;/locations/&#42;/templates/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Template getTemplate(String name) {
    GetTemplateRequest request = GetTemplateRequest.newBuilder().setName(name).build();
    return getTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   GetTemplateRequest request =
   *       GetTemplateRequest.newBuilder()
   *           .setName(TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
   *           .build();
   *   Template response = parameterManagerClient.getTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Template getTemplate(GetTemplateRequest request) {
    return getTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   GetTemplateRequest request =
   *       GetTemplateRequest.newBuilder()
   *           .setName(TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
   *           .build();
   *   ApiFuture<Template> future = parameterManagerClient.getTemplateCallable().futureCall(request);
   *   // Do something.
   *   Template response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTemplateRequest, Template> getTemplateCallable() {
    return stub.getTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Template in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Template template = Template.newBuilder().build();
   *   String templateId = "templateId1304010549";
   *   Template response = parameterManagerClient.createTemplate(parent, template, templateId);
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent in the format `projects/&#42;/locations/&#42;`.
   * @param template Required. The Template resource being created
   * @param templateId Required. Id of the Template resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Template createTemplate(
      @Nullable LocationName parent, Template template, String templateId) {
    CreateTemplateRequest request =
        CreateTemplateRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTemplate(template)
            .setTemplateId(templateId)
            .build();
    return createTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Template in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Template template = Template.newBuilder().build();
   *   String templateId = "templateId1304010549";
   *   Template response = parameterManagerClient.createTemplate(parent, template, templateId);
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent in the format `projects/&#42;/locations/&#42;`.
   * @param template Required. The Template resource being created
   * @param templateId Required. Id of the Template resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Template createTemplate(String parent, Template template, String templateId) {
    CreateTemplateRequest request =
        CreateTemplateRequest.newBuilder()
            .setParent(parent)
            .setTemplate(template)
            .setTemplateId(templateId)
            .build();
    return createTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Template in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   CreateTemplateRequest request =
   *       CreateTemplateRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTemplateId("templateId1304010549")
   *           .setTemplate(Template.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Template response = parameterManagerClient.createTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Template createTemplate(CreateTemplateRequest request) {
    return createTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Template in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   CreateTemplateRequest request =
   *       CreateTemplateRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTemplateId("templateId1304010549")
   *           .setTemplate(Template.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Template> future =
   *       parameterManagerClient.createTemplateCallable().futureCall(request);
   *   // Do something.
   *   Template response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTemplateRequest, Template> createTemplateCallable() {
    return stub.createTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single Template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   Template template = Template.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Template response = parameterManagerClient.updateTemplate(template, updateMask);
   * }
   * }</pre>
   *
   * @param template Required. The Template resource being updated
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     Template resource by the update. The fields specified in the update_mask are relative to
   *     the resource, not the full request. A mutable field will be overwritten if it is in the
   *     mask. If the user does not provide a mask then all mutable fields present in the request
   *     will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Template updateTemplate(Template template, FieldMask updateMask) {
    UpdateTemplateRequest request =
        UpdateTemplateRequest.newBuilder().setTemplate(template).setUpdateMask(updateMask).build();
    return updateTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single Template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   UpdateTemplateRequest request =
   *       UpdateTemplateRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTemplate(Template.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Template response = parameterManagerClient.updateTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Template updateTemplate(UpdateTemplateRequest request) {
    return updateTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single Template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   UpdateTemplateRequest request =
   *       UpdateTemplateRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTemplate(Template.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Template> future =
   *       parameterManagerClient.updateTemplateCallable().futureCall(request);
   *   // Do something.
   *   Template response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTemplateRequest, Template> updateTemplateCallable() {
    return stub.updateTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   TemplateName name = TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]");
   *   parameterManagerClient.deleteTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource in the format
   *     `projects/&#42;/locations/&#42;/templates/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTemplate(@Nullable TemplateName name) {
    DeleteTemplateRequest request =
        DeleteTemplateRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   String name = TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString();
   *   parameterManagerClient.deleteTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource in the format
   *     `projects/&#42;/locations/&#42;/templates/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTemplate(String name) {
    DeleteTemplateRequest request = DeleteTemplateRequest.newBuilder().setName(name).build();
    deleteTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   DeleteTemplateRequest request =
   *       DeleteTemplateRequest.newBuilder()
   *           .setName(TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   parameterManagerClient.deleteTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTemplate(DeleteTemplateRequest request) {
    deleteTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   DeleteTemplateRequest request =
   *       DeleteTemplateRequest.newBuilder()
   *           .setName(TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Empty> future = parameterManagerClient.deleteTemplateCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTemplateRequest, Empty> deleteTemplateCallable() {
    return stub.deleteTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TemplateVersions in a given project, location, and template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   TemplateName parent = TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]");
   *   for (TemplateVersion element :
   *       parameterManagerClient.listTemplateVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListTemplateVersionsRequest in the format
   *     `projects/&#42;/locations/&#42;/templates/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTemplateVersionsPagedResponse listTemplateVersions(
      @Nullable TemplateName parent) {
    ListTemplateVersionsRequest request =
        ListTemplateVersionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTemplateVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TemplateVersions in a given project, location, and template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   String parent = TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString();
   *   for (TemplateVersion element :
   *       parameterManagerClient.listTemplateVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListTemplateVersionsRequest in the format
   *     `projects/&#42;/locations/&#42;/templates/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTemplateVersionsPagedResponse listTemplateVersions(String parent) {
    ListTemplateVersionsRequest request =
        ListTemplateVersionsRequest.newBuilder().setParent(parent).build();
    return listTemplateVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TemplateVersions in a given project, location, and template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   ListTemplateVersionsRequest request =
   *       ListTemplateVersionsRequest.newBuilder()
   *           .setParent(TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (TemplateVersion element :
   *       parameterManagerClient.listTemplateVersions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTemplateVersionsPagedResponse listTemplateVersions(
      ListTemplateVersionsRequest request) {
    return listTemplateVersionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TemplateVersions in a given project, location, and template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   ListTemplateVersionsRequest request =
   *       ListTemplateVersionsRequest.newBuilder()
   *           .setParent(TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<TemplateVersion> future =
   *       parameterManagerClient.listTemplateVersionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TemplateVersion element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTemplateVersionsRequest, ListTemplateVersionsPagedResponse>
      listTemplateVersionsPagedCallable() {
    return stub.listTemplateVersionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TemplateVersions in a given project, location, and template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   ListTemplateVersionsRequest request =
   *       ListTemplateVersionsRequest.newBuilder()
   *           .setParent(TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListTemplateVersionsResponse response =
   *         parameterManagerClient.listTemplateVersionsCallable().call(request);
   *     for (TemplateVersion element : response.getTemplateVersionsList()) {
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
  public final UnaryCallable<ListTemplateVersionsRequest, ListTemplateVersionsResponse>
      listTemplateVersionsCallable() {
    return stub.listTemplateVersionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single TemplateVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   TemplateVersionName name =
   *       TemplateVersionName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]", "[TEMPLATE_VERSION]");
   *   TemplateVersion response = parameterManagerClient.getTemplateVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource in the format
   *     `projects/&#42;/locations/&#42;/templates/&#42;/versions/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TemplateVersion getTemplateVersion(@Nullable TemplateVersionName name) {
    GetTemplateVersionRequest request =
        GetTemplateVersionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getTemplateVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single TemplateVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   String name =
   *       TemplateVersionName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]", "[TEMPLATE_VERSION]")
   *           .toString();
   *   TemplateVersion response = parameterManagerClient.getTemplateVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource in the format
   *     `projects/&#42;/locations/&#42;/templates/&#42;/versions/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TemplateVersion getTemplateVersion(String name) {
    GetTemplateVersionRequest request =
        GetTemplateVersionRequest.newBuilder().setName(name).build();
    return getTemplateVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single TemplateVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   GetTemplateVersionRequest request =
   *       GetTemplateVersionRequest.newBuilder()
   *           .setName(
   *               TemplateVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[TEMPLATE]", "[TEMPLATE_VERSION]")
   *                   .toString())
   *           .setView(View.forNumber(0))
   *           .build();
   *   TemplateVersion response = parameterManagerClient.getTemplateVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TemplateVersion getTemplateVersion(GetTemplateVersionRequest request) {
    return getTemplateVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single TemplateVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   GetTemplateVersionRequest request =
   *       GetTemplateVersionRequest.newBuilder()
   *           .setName(
   *               TemplateVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[TEMPLATE]", "[TEMPLATE_VERSION]")
   *                   .toString())
   *           .setView(View.forNumber(0))
   *           .build();
   *   ApiFuture<TemplateVersion> future =
   *       parameterManagerClient.getTemplateVersionCallable().futureCall(request);
   *   // Do something.
   *   TemplateVersion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTemplateVersionRequest, TemplateVersion>
      getTemplateVersionCallable() {
    return stub.getTemplateVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TemplateVersion in a given project, location, and template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   TemplateName parent = TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]");
   *   TemplateVersion templateVersion = TemplateVersion.newBuilder().build();
   *   String templateVersionId = "templateVersionId616434873";
   *   TemplateVersion response =
   *       parameterManagerClient.createTemplateVersion(parent, templateVersion, templateVersionId);
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent in the format
   *     `projects/&#42;/locations/&#42;/templates/&#42;`.
   * @param templateVersion Required. The TemplateVersion resource being created
   * @param templateVersionId Required. Id of the TemplateVersion resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TemplateVersion createTemplateVersion(
      @Nullable TemplateName parent, TemplateVersion templateVersion, String templateVersionId) {
    CreateTemplateVersionRequest request =
        CreateTemplateVersionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTemplateVersion(templateVersion)
            .setTemplateVersionId(templateVersionId)
            .build();
    return createTemplateVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TemplateVersion in a given project, location, and template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   String parent = TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString();
   *   TemplateVersion templateVersion = TemplateVersion.newBuilder().build();
   *   String templateVersionId = "templateVersionId616434873";
   *   TemplateVersion response =
   *       parameterManagerClient.createTemplateVersion(parent, templateVersion, templateVersionId);
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent in the format
   *     `projects/&#42;/locations/&#42;/templates/&#42;`.
   * @param templateVersion Required. The TemplateVersion resource being created
   * @param templateVersionId Required. Id of the TemplateVersion resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TemplateVersion createTemplateVersion(
      String parent, TemplateVersion templateVersion, String templateVersionId) {
    CreateTemplateVersionRequest request =
        CreateTemplateVersionRequest.newBuilder()
            .setParent(parent)
            .setTemplateVersion(templateVersion)
            .setTemplateVersionId(templateVersionId)
            .build();
    return createTemplateVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TemplateVersion in a given project, location, and template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   CreateTemplateVersionRequest request =
   *       CreateTemplateVersionRequest.newBuilder()
   *           .setParent(TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
   *           .setTemplateVersionId("templateVersionId616434873")
   *           .setTemplateVersion(TemplateVersion.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   TemplateVersion response = parameterManagerClient.createTemplateVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TemplateVersion createTemplateVersion(CreateTemplateVersionRequest request) {
    return createTemplateVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TemplateVersion in a given project, location, and template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   CreateTemplateVersionRequest request =
   *       CreateTemplateVersionRequest.newBuilder()
   *           .setParent(TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
   *           .setTemplateVersionId("templateVersionId616434873")
   *           .setTemplateVersion(TemplateVersion.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<TemplateVersion> future =
   *       parameterManagerClient.createTemplateVersionCallable().futureCall(request);
   *   // Do something.
   *   TemplateVersion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTemplateVersionRequest, TemplateVersion>
      createTemplateVersionCallable() {
    return stub.createTemplateVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single TemplateVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   TemplateVersion templateVersion = TemplateVersion.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   TemplateVersion response =
   *       parameterManagerClient.updateTemplateVersion(templateVersion, updateMask);
   * }
   * }</pre>
   *
   * @param templateVersion Required. The TemplateVersion resource being updated
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     TemplateVersion resource by the update. The fields specified in the update_mask are
   *     relative to the resource, not the full request. A mutable field will be overwritten if it
   *     is in the mask. If the user does not provide a mask then all mutable fields present in the
   *     request will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TemplateVersion updateTemplateVersion(
      TemplateVersion templateVersion, FieldMask updateMask) {
    UpdateTemplateVersionRequest request =
        UpdateTemplateVersionRequest.newBuilder()
            .setTemplateVersion(templateVersion)
            .setUpdateMask(updateMask)
            .build();
    return updateTemplateVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single TemplateVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   UpdateTemplateVersionRequest request =
   *       UpdateTemplateVersionRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTemplateVersion(TemplateVersion.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   TemplateVersion response = parameterManagerClient.updateTemplateVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TemplateVersion updateTemplateVersion(UpdateTemplateVersionRequest request) {
    return updateTemplateVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single TemplateVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   UpdateTemplateVersionRequest request =
   *       UpdateTemplateVersionRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTemplateVersion(TemplateVersion.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<TemplateVersion> future =
   *       parameterManagerClient.updateTemplateVersionCallable().futureCall(request);
   *   // Do something.
   *   TemplateVersion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTemplateVersionRequest, TemplateVersion>
      updateTemplateVersionCallable() {
    return stub.updateTemplateVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single TemplateVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   TemplateVersionName name =
   *       TemplateVersionName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]", "[TEMPLATE_VERSION]");
   *   parameterManagerClient.deleteTemplateVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource in the format
   *     `projects/&#42;/locations/&#42;/templates/&#42;/versions/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTemplateVersion(@Nullable TemplateVersionName name) {
    DeleteTemplateVersionRequest request =
        DeleteTemplateVersionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteTemplateVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single TemplateVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   String name =
   *       TemplateVersionName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]", "[TEMPLATE_VERSION]")
   *           .toString();
   *   parameterManagerClient.deleteTemplateVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource in the format
   *     `projects/&#42;/locations/&#42;/templates/&#42;/versions/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTemplateVersion(String name) {
    DeleteTemplateVersionRequest request =
        DeleteTemplateVersionRequest.newBuilder().setName(name).build();
    deleteTemplateVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single TemplateVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   DeleteTemplateVersionRequest request =
   *       DeleteTemplateVersionRequest.newBuilder()
   *           .setName(
   *               TemplateVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[TEMPLATE]", "[TEMPLATE_VERSION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   parameterManagerClient.deleteTemplateVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTemplateVersion(DeleteTemplateVersionRequest request) {
    deleteTemplateVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single TemplateVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   DeleteTemplateVersionRequest request =
   *       DeleteTemplateVersionRequest.newBuilder()
   *           .setName(
   *               TemplateVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[TEMPLATE]", "[TEMPLATE_VERSION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Empty> future =
   *       parameterManagerClient.deleteTemplateVersionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTemplateVersionRequest, Empty> deleteTemplateVersionCallable() {
    return stub.deleteTemplateVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets rendered version of a TemplateVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   TemplateVersionName name =
   *       TemplateVersionName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]", "[TEMPLATE_VERSION]");
   *   RenderTemplateVersionResponse response = parameterManagerClient.renderTemplateVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RenderTemplateVersionResponse renderTemplateVersion(
      @Nullable TemplateVersionName name) {
    RenderTemplateVersionRequest request =
        RenderTemplateVersionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return renderTemplateVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets rendered version of a TemplateVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   String name =
   *       TemplateVersionName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]", "[TEMPLATE_VERSION]")
   *           .toString();
   *   RenderTemplateVersionResponse response = parameterManagerClient.renderTemplateVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RenderTemplateVersionResponse renderTemplateVersion(String name) {
    RenderTemplateVersionRequest request =
        RenderTemplateVersionRequest.newBuilder().setName(name).build();
    return renderTemplateVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets rendered version of a TemplateVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   RenderTemplateVersionRequest request =
   *       RenderTemplateVersionRequest.newBuilder()
   *           .setName(
   *               TemplateVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[TEMPLATE]", "[TEMPLATE_VERSION]")
   *                   .toString())
   *           .setParameterVersion(
   *               ParameterVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]")
   *                   .toString())
   *           .build();
   *   RenderTemplateVersionResponse response =
   *       parameterManagerClient.renderTemplateVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RenderTemplateVersionResponse renderTemplateVersion(
      RenderTemplateVersionRequest request) {
    return renderTemplateVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets rendered version of a TemplateVersion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   RenderTemplateVersionRequest request =
   *       RenderTemplateVersionRequest.newBuilder()
   *           .setName(
   *               TemplateVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[TEMPLATE]", "[TEMPLATE_VERSION]")
   *                   .toString())
   *           .setParameterVersion(
   *               ParameterVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PARAMETER]", "[PARAMETER_VERSION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<RenderTemplateVersionResponse> future =
   *       parameterManagerClient.renderTemplateVersionCallable().futureCall(request);
   *   // Do something.
   *   RenderTemplateVersionResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RenderTemplateVersionRequest, RenderTemplateVersionResponse>
      renderTemplateVersionCallable() {
    return stub.renderTemplateVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : parameterManagerClient.listLocations(request).iterateAll()) {
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
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       parameterManagerClient.listLocationsPagedCallable().futureCall(request);
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
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         parameterManagerClient.listLocationsCallable().call(request);
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
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = parameterManagerClient.getLocation(request);
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
   * try (ParameterManagerClient parameterManagerClient = ParameterManagerClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = parameterManagerClient.getLocationCallable().futureCall(request);
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

  public static class ListParametersPagedResponse
      extends AbstractPagedListResponse<
          ListParametersRequest,
          ListParametersResponse,
          Parameter,
          ListParametersPage,
          ListParametersFixedSizeCollection> {

    public static ApiFuture<ListParametersPagedResponse> createAsync(
        PageContext<ListParametersRequest, ListParametersResponse, Parameter> context,
        ApiFuture<ListParametersResponse> futureResponse) {
      ApiFuture<ListParametersPage> futurePage =
          ListParametersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListParametersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListParametersPagedResponse(ListParametersPage page) {
      super(page, ListParametersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListParametersPage
      extends AbstractPage<
          ListParametersRequest, ListParametersResponse, Parameter, ListParametersPage> {

    private ListParametersPage(
        @Nullable PageContext<ListParametersRequest, ListParametersResponse, Parameter> context,
        @Nullable ListParametersResponse response) {
      super(context, response);
    }

    private static ListParametersPage createEmptyPage() {
      return new ListParametersPage(null, null);
    }

    @Override
    protected ListParametersPage createPage(
        @Nullable PageContext<ListParametersRequest, ListParametersResponse, Parameter> context,
        @Nullable ListParametersResponse response) {
      return new ListParametersPage(context, response);
    }

    @Override
    public ApiFuture<ListParametersPage> createPageAsync(
        @Nullable PageContext<ListParametersRequest, ListParametersResponse, Parameter> context,
        ApiFuture<ListParametersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListParametersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListParametersRequest,
          ListParametersResponse,
          Parameter,
          ListParametersPage,
          ListParametersFixedSizeCollection> {

    private ListParametersFixedSizeCollection(
        @Nullable List<ListParametersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListParametersFixedSizeCollection createEmptyCollection() {
      return new ListParametersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListParametersFixedSizeCollection createCollection(
        @Nullable List<ListParametersPage> pages, int collectionSize) {
      return new ListParametersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListParameterVersionsPagedResponse
      extends AbstractPagedListResponse<
          ListParameterVersionsRequest,
          ListParameterVersionsResponse,
          ParameterVersion,
          ListParameterVersionsPage,
          ListParameterVersionsFixedSizeCollection> {

    public static ApiFuture<ListParameterVersionsPagedResponse> createAsync(
        PageContext<ListParameterVersionsRequest, ListParameterVersionsResponse, ParameterVersion>
            context,
        ApiFuture<ListParameterVersionsResponse> futureResponse) {
      ApiFuture<ListParameterVersionsPage> futurePage =
          ListParameterVersionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListParameterVersionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListParameterVersionsPagedResponse(ListParameterVersionsPage page) {
      super(page, ListParameterVersionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListParameterVersionsPage
      extends AbstractPage<
          ListParameterVersionsRequest,
          ListParameterVersionsResponse,
          ParameterVersion,
          ListParameterVersionsPage> {

    private ListParameterVersionsPage(
        @Nullable
            PageContext<
                ListParameterVersionsRequest, ListParameterVersionsResponse, ParameterVersion>
            context,
        @Nullable ListParameterVersionsResponse response) {
      super(context, response);
    }

    private static ListParameterVersionsPage createEmptyPage() {
      return new ListParameterVersionsPage(null, null);
    }

    @Override
    protected ListParameterVersionsPage createPage(
        @Nullable
            PageContext<
                ListParameterVersionsRequest, ListParameterVersionsResponse, ParameterVersion>
            context,
        @Nullable ListParameterVersionsResponse response) {
      return new ListParameterVersionsPage(context, response);
    }

    @Override
    public ApiFuture<ListParameterVersionsPage> createPageAsync(
        @Nullable
            PageContext<
                ListParameterVersionsRequest, ListParameterVersionsResponse, ParameterVersion>
            context,
        ApiFuture<ListParameterVersionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListParameterVersionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListParameterVersionsRequest,
          ListParameterVersionsResponse,
          ParameterVersion,
          ListParameterVersionsPage,
          ListParameterVersionsFixedSizeCollection> {

    private ListParameterVersionsFixedSizeCollection(
        @Nullable List<ListParameterVersionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListParameterVersionsFixedSizeCollection createEmptyCollection() {
      return new ListParameterVersionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListParameterVersionsFixedSizeCollection createCollection(
        @Nullable List<ListParameterVersionsPage> pages, int collectionSize) {
      return new ListParameterVersionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTemplatesPagedResponse
      extends AbstractPagedListResponse<
          ListTemplatesRequest,
          ListTemplatesResponse,
          Template,
          ListTemplatesPage,
          ListTemplatesFixedSizeCollection> {

    public static ApiFuture<ListTemplatesPagedResponse> createAsync(
        PageContext<ListTemplatesRequest, ListTemplatesResponse, Template> context,
        ApiFuture<ListTemplatesResponse> futureResponse) {
      ApiFuture<ListTemplatesPage> futurePage =
          ListTemplatesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTemplatesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTemplatesPagedResponse(ListTemplatesPage page) {
      super(page, ListTemplatesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTemplatesPage
      extends AbstractPage<
          ListTemplatesRequest, ListTemplatesResponse, Template, ListTemplatesPage> {

    private ListTemplatesPage(
        @Nullable PageContext<ListTemplatesRequest, ListTemplatesResponse, Template> context,
        @Nullable ListTemplatesResponse response) {
      super(context, response);
    }

    private static ListTemplatesPage createEmptyPage() {
      return new ListTemplatesPage(null, null);
    }

    @Override
    protected ListTemplatesPage createPage(
        @Nullable PageContext<ListTemplatesRequest, ListTemplatesResponse, Template> context,
        @Nullable ListTemplatesResponse response) {
      return new ListTemplatesPage(context, response);
    }

    @Override
    public ApiFuture<ListTemplatesPage> createPageAsync(
        @Nullable PageContext<ListTemplatesRequest, ListTemplatesResponse, Template> context,
        ApiFuture<ListTemplatesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTemplatesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTemplatesRequest,
          ListTemplatesResponse,
          Template,
          ListTemplatesPage,
          ListTemplatesFixedSizeCollection> {

    private ListTemplatesFixedSizeCollection(
        @Nullable List<ListTemplatesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTemplatesFixedSizeCollection createEmptyCollection() {
      return new ListTemplatesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTemplatesFixedSizeCollection createCollection(
        @Nullable List<ListTemplatesPage> pages, int collectionSize) {
      return new ListTemplatesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTemplateVersionsPagedResponse
      extends AbstractPagedListResponse<
          ListTemplateVersionsRequest,
          ListTemplateVersionsResponse,
          TemplateVersion,
          ListTemplateVersionsPage,
          ListTemplateVersionsFixedSizeCollection> {

    public static ApiFuture<ListTemplateVersionsPagedResponse> createAsync(
        PageContext<ListTemplateVersionsRequest, ListTemplateVersionsResponse, TemplateVersion>
            context,
        ApiFuture<ListTemplateVersionsResponse> futureResponse) {
      ApiFuture<ListTemplateVersionsPage> futurePage =
          ListTemplateVersionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTemplateVersionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTemplateVersionsPagedResponse(ListTemplateVersionsPage page) {
      super(page, ListTemplateVersionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTemplateVersionsPage
      extends AbstractPage<
          ListTemplateVersionsRequest,
          ListTemplateVersionsResponse,
          TemplateVersion,
          ListTemplateVersionsPage> {

    private ListTemplateVersionsPage(
        @Nullable
            PageContext<ListTemplateVersionsRequest, ListTemplateVersionsResponse, TemplateVersion>
            context,
        @Nullable ListTemplateVersionsResponse response) {
      super(context, response);
    }

    private static ListTemplateVersionsPage createEmptyPage() {
      return new ListTemplateVersionsPage(null, null);
    }

    @Override
    protected ListTemplateVersionsPage createPage(
        @Nullable
            PageContext<ListTemplateVersionsRequest, ListTemplateVersionsResponse, TemplateVersion>
            context,
        @Nullable ListTemplateVersionsResponse response) {
      return new ListTemplateVersionsPage(context, response);
    }

    @Override
    public ApiFuture<ListTemplateVersionsPage> createPageAsync(
        @Nullable
            PageContext<ListTemplateVersionsRequest, ListTemplateVersionsResponse, TemplateVersion>
            context,
        ApiFuture<ListTemplateVersionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTemplateVersionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTemplateVersionsRequest,
          ListTemplateVersionsResponse,
          TemplateVersion,
          ListTemplateVersionsPage,
          ListTemplateVersionsFixedSizeCollection> {

    private ListTemplateVersionsFixedSizeCollection(
        @Nullable List<ListTemplateVersionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTemplateVersionsFixedSizeCollection createEmptyCollection() {
      return new ListTemplateVersionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTemplateVersionsFixedSizeCollection createCollection(
        @Nullable List<ListTemplateVersionsPage> pages, int collectionSize) {
      return new ListTemplateVersionsFixedSizeCollection(pages, collectionSize);
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
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        @Nullable ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        @Nullable ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
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

    private ListLocationsFixedSizeCollection(
        @Nullable List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        @Nullable List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
