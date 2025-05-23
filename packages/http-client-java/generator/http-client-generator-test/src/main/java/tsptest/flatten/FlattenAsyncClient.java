// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package tsptest.flatten;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceClient;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.exception.ClientAuthenticationException;
import com.azure.core.exception.HttpResponseException;
import com.azure.core.exception.ResourceModifiedException;
import com.azure.core.exception.ResourceNotFoundException;
import com.azure.core.http.rest.RequestOptions;
import com.azure.core.http.rest.Response;
import com.azure.core.util.BinaryData;
import com.azure.core.util.FluxUtil;
import reactor.core.publisher.Mono;
import tsptest.flatten.implementation.FlattenClientImpl;
import tsptest.flatten.implementation.JsonMergePatchHelper;
import tsptest.flatten.implementation.models.SendLongRequest;
import tsptest.flatten.implementation.models.SendOptionalBodyRequest;
import tsptest.flatten.implementation.models.SendProjectedNameRequest;
import tsptest.flatten.implementation.models.SendRequest;
import tsptest.flatten.models.SendLongOptions;
import tsptest.flatten.models.TodoItem;
import tsptest.flatten.models.UpdatePatchRequest;
import tsptest.flatten.models.User;

/**
 * Initializes a new instance of the asynchronous FlattenClient type.
 */
@ServiceClient(builder = FlattenClientBuilder.class, isAsync = true)
public final class FlattenAsyncClient {
    @Generated
    private final FlattenClientImpl serviceClient;

    /**
     * Initializes an instance of FlattenAsyncClient class.
     * 
     * @param serviceClient the service client implementation.
     */
    @Generated
    FlattenAsyncClient(FlattenClientImpl serviceClient) {
        this.serviceClient = serviceClient;
    }

    /**
     * The send operation.
     * <p><strong>Query Parameters</strong></p>
     * <table border="1">
     * <caption>Query Parameters</caption>
     * <tr><th>Name</th><th>Type</th><th>Required</th><th>Description</th></tr>
     * <tr><td>maxpagesize</td><td>Integer</td><td>No</td><td>The maxPageSize parameter</td></tr>
     * </table>
     * You can add these to a request with {@link RequestOptions#addQueryParam}
     * <p><strong>Request Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     endpoint: String (Required)
     *     user (Optional): {
     *         user: String (Required)
     *     }
     *     input: String (Required)
     *     constant: String (Required)
     *     requiredInt: int (Required)
     * }
     * }
     * </pre>
     * 
     * @param id The id parameter.
     * @param sendRequest The sendRequest parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> sendWithResponse(String id, BinaryData sendRequest, RequestOptions requestOptions) {
        return this.serviceClient.sendWithResponseAsync(id, sendRequest, requestOptions);
    }

    /**
     * The sendProjectedName operation.
     * <p><strong>Request Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     file_id: String (Required)
     * }
     * }
     * </pre>
     * 
     * @param id The id parameter.
     * @param sendProjectedNameRequest The sendProjectedNameRequest parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> sendProjectedNameWithResponse(String id, BinaryData sendProjectedNameRequest,
        RequestOptions requestOptions) {
        return this.serviceClient.sendProjectedNameWithResponseAsync(id, sendProjectedNameRequest, requestOptions);
    }

    /**
     * The sendLong operation.
     * <p><strong>Query Parameters</strong></p>
     * <table border="1">
     * <caption>Query Parameters</caption>
     * <tr><th>Name</th><th>Type</th><th>Required</th><th>Description</th></tr>
     * <tr><td>filter</td><td>String</td><td>No</td><td>The filter parameter</td></tr>
     * </table>
     * You can add these to a request with {@link RequestOptions#addQueryParam}
     * <p><strong>Request Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     user (Optional): {
     *         user: String (Required)
     *     }
     *     input: String (Required)
     *     dataInt: int (Required)
     *     dataIntOptional: Integer (Optional)
     *     dataLong: Long (Optional)
     *     requiredUser (Required): (recursive schema, see requiredUser above)
     *     data_float: Double (Optional)
     *     long: Long (Optional)
     *     title: String (Required)
     *     description: String (Optional)
     *     status: String(NotStarted/InProgress/Completed) (Required)
     *     _dummy: String (Optional)
     *     constant: String (Required)
     * }
     * }
     * </pre>
     * 
     * @param name The name parameter.
     * @param sendLongRequest The sendLongRequest parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> sendLongWithResponse(String name, BinaryData sendLongRequest,
        RequestOptions requestOptions) {
        return this.serviceClient.sendLongWithResponseAsync(name, sendLongRequest, requestOptions);
    }

    /**
     * The update operation.
     * <p><strong>Request Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     patch (Optional, Required on create): {
     *         title: String (Optional)
     *         description: String (Optional)
     *         status: String(NotStarted/InProgress/Completed) (Optional)
     *     }
     * }
     * }
     * </pre>
     * 
     * <p><strong>Response Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     id: long (Required)
     *     title: String (Required)
     *     description: String (Optional)
     *     status: String(NotStarted/InProgress/Completed) (Required)
     *     createdAt: OffsetDateTime (Required)
     *     updatedAt: OffsetDateTime (Required)
     *     completedAt: OffsetDateTime (Optional)
     *     _dummy: String (Optional)
     * }
     * }
     * </pre>
     * 
     * @param id The id parameter.
     * @param updateRequest The updateRequest parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the response body along with {@link Response} on successful completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<BinaryData>> updateWithResponse(long id, BinaryData updateRequest,
        RequestOptions requestOptions) {
        return this.serviceClient.updateWithResponseAsync(id, updateRequest, requestOptions);
    }

    /**
     * The sendOptionalBody operation.
     * <p><strong>Request Body Schema</strong></p>
     * 
     * <pre>
     * {@code
     * {
     *     name: String (Optional)
     * }
     * }
     * </pre>
     * 
     * @param sendOptionalBodyRequest The sendOptionalBodyRequest parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> sendOptionalBodyWithResponse(BinaryData sendOptionalBodyRequest,
        RequestOptions requestOptions) {
        return this.serviceClient.sendOptionalBodyWithResponseAsync(sendOptionalBodyRequest, requestOptions);
    }

    /**
     * The send operation.
     * 
     * @param id The id parameter.
     * @param endpoint The endpoint parameter.
     * @param input The input parameter.
     * @param requiredInt The requiredInt parameter.
     * @param maxPageSize The maxPageSize parameter.
     * @param user The user parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return A {@link Mono} that completes when a successful response is received.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> send(String id, String endpoint, String input, int requiredInt, Integer maxPageSize, User user) {
        // Generated convenience method for sendWithResponse
        RequestOptions requestOptions = new RequestOptions();
        SendRequest sendRequestObj = new SendRequest(endpoint, input, requiredInt).setUser(user);
        BinaryData sendRequest = BinaryData.fromObject(sendRequestObj);
        if (maxPageSize != null) {
            requestOptions.addQueryParam("maxpagesize", String.valueOf(maxPageSize), false);
        }
        return sendWithResponse(id, sendRequest, requestOptions).flatMap(FluxUtil::toMono);
    }

    /**
     * The send operation.
     * 
     * @param id The id parameter.
     * @param endpoint The endpoint parameter.
     * @param input The input parameter.
     * @param requiredInt The requiredInt parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return A {@link Mono} that completes when a successful response is received.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> send(String id, String endpoint, String input, int requiredInt) {
        // Generated convenience method for sendWithResponse
        RequestOptions requestOptions = new RequestOptions();
        SendRequest sendRequestObj = new SendRequest(endpoint, input, requiredInt);
        BinaryData sendRequest = BinaryData.fromObject(sendRequestObj);
        return sendWithResponse(id, sendRequest, requestOptions).flatMap(FluxUtil::toMono);
    }

    /**
     * The sendProjectedName operation.
     * 
     * @param id The id parameter.
     * @param fileIdentifier The fileIdentifier parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return A {@link Mono} that completes when a successful response is received.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> sendProjectedName(String id, String fileIdentifier) {
        // Generated convenience method for sendProjectedNameWithResponse
        RequestOptions requestOptions = new RequestOptions();
        SendProjectedNameRequest sendProjectedNameRequestObj = new SendProjectedNameRequest(fileIdentifier);
        BinaryData sendProjectedNameRequest = BinaryData.fromObject(sendProjectedNameRequestObj);
        return sendProjectedNameWithResponse(id, sendProjectedNameRequest, requestOptions).flatMap(FluxUtil::toMono);
    }

    /**
     * The sendLong operation.
     * 
     * @param options Options for sendLong API.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return A {@link Mono} that completes when a successful response is received.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> sendLong(SendLongOptions options) {
        // Generated convenience method for sendLongWithResponse
        RequestOptions requestOptions = new RequestOptions();
        String name = options.getName();
        String filter = options.getFilter();
        SendLongRequest sendLongRequestObj = new SendLongRequest(options.getInput(), options.getDataInt(),
            options.getRequiredUser(), options.getTitle(), options.getStatus()).setUser(options.getUser())
                .setDataIntOptional(options.getDataIntOptional())
                .setDataLong(options.getDataLong())
                .setDataFloat(options.getDataFloat())
                .setLongProperty(options.getLongParameter())
                .setDescription(options.getDescription())
                .setDummy(options.getDummy());
        BinaryData sendLongRequest = BinaryData.fromObject(sendLongRequestObj);
        if (filter != null) {
            requestOptions.addQueryParam("filter", filter, false);
        }
        return sendLongWithResponse(name, sendLongRequest, requestOptions).flatMap(FluxUtil::toMono);
    }

    /**
     * The update operation.
     * 
     * @param id The id parameter.
     * @param updateRequest The updateRequest parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response body on successful completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<TodoItem> update(long id, UpdatePatchRequest updateRequest) {
        // Generated convenience method for updateWithResponse
        RequestOptions requestOptions = new RequestOptions();
        JsonMergePatchHelper.getUpdatePatchRequestAccessor().prepareModelForJsonMergePatch(updateRequest, true);
        BinaryData updateRequestInBinaryData = BinaryData.fromObject(updateRequest);
        // BinaryData.fromObject() will not fire serialization, use getLength() to fire serialization.
        updateRequestInBinaryData.getLength();
        JsonMergePatchHelper.getUpdatePatchRequestAccessor().prepareModelForJsonMergePatch(updateRequest, false);
        return updateWithResponse(id, updateRequestInBinaryData, requestOptions).flatMap(FluxUtil::toMono)
            .map(protocolMethodData -> protocolMethodData.toObject(TodoItem.class));
    }

    /**
     * The sendOptionalBody operation.
     * 
     * @param name The name parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return A {@link Mono} that completes when a successful response is received.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> sendOptionalBody(String name) {
        // Generated convenience method for sendOptionalBodyWithResponse
        RequestOptions requestOptions = new RequestOptions();
        SendOptionalBodyRequest sendOptionalBodyRequestObj = new SendOptionalBodyRequest().setName(name);
        BinaryData sendOptionalBodyRequest = BinaryData.fromObject(sendOptionalBodyRequestObj);
        return sendOptionalBodyWithResponse(sendOptionalBodyRequest, requestOptions).flatMap(FluxUtil::toMono);
    }

    /**
     * The sendOptionalBody operation.
     * 
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return A {@link Mono} that completes when a successful response is received.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> sendOptionalBody() {
        // Generated convenience method for sendOptionalBodyWithResponse
        RequestOptions requestOptions = new RequestOptions();
        SendOptionalBodyRequest sendOptionalBodyRequestObj = new SendOptionalBodyRequest();
        BinaryData sendOptionalBodyRequest = BinaryData.fromObject(sendOptionalBodyRequestObj);
        return sendOptionalBodyWithResponse(sendOptionalBodyRequest, requestOptions).flatMap(FluxUtil::toMono);
    }
}
