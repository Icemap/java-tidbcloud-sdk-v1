# RestoreApi

All URIs are relative to *https://api.tidbcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createRestoreTask**](RestoreApi.md#createRestoreTask) | **POST** /api/v1beta/projects/{project_id}/restores | Create a restore task.
[**getRestoreTask**](RestoreApi.md#getRestoreTask) | **GET** /api/v1beta/projects/{project_id}/restores/{restore_id} | Get a restore task.
[**listRestoreTasks**](RestoreApi.md#listRestoreTasks) | **GET** /api/v1beta/projects/{project_id}/restores | List the restore tasks in a project.


<a name="createRestoreTask"></a>
# **createRestoreTask**
> CreateRestoreResp createRestoreTask(projectId, body)

Create a restore task.

You can use this endpoint to restore data from a previously created backup file to a new cluster. In this endpoint, you must specify the configuration of the new cluster you want to restore data to.  **Limitations:**  - For Dedicated Tier, you can only restore data from a smaller node size to a larger node size.  - You cannot restore data from a Dedicated Tier cluster to a Developer Tier cluster.  For Developer Tier clusters, you cannot create restore tasks via API.

### Example
```java
// Import classes:
//import com.github.icemap.invoker.ApiException;
//import com.github.icemap.api.RestoreApi;


RestoreApi apiInstance = new RestoreApi();
String projectId = "projectId_example"; // String | The ID of the project. You can get the project ID from the response of [List all accessible projects.](#tag/Project/operation/ListProjects).
CreateRestoreReq body = new CreateRestoreReq(); // CreateRestoreReq | 
try {
    CreateRestoreResp result = apiInstance.createRestoreTask(projectId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RestoreApi#createRestoreTask");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| The ID of the project. You can get the project ID from the response of [List all accessible projects.](#tag/Project/operation/ListProjects). |
 **body** | [**CreateRestoreReq**](CreateRestoreReq.md)|  |

### Return type

[**CreateRestoreResp**](CreateRestoreResp.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getRestoreTask"></a>
# **getRestoreTask**
> GetRestoreResp getRestoreTask(projectId, restoreId)

Get a restore task.

 For Developer Tier clusters, you cannot manage restore tasks via API.

### Example
```java
// Import classes:
//import com.github.icemap.invoker.ApiException;
//import com.github.icemap.api.RestoreApi;


RestoreApi apiInstance = new RestoreApi();
String projectId = "projectId_example"; // String | The ID of your project. You can get the project ID from the response of [List all accessible projects.](#tag/Project/operation/ListProjects).
String restoreId = "restoreId_example"; // String | The ID of the restore task.
try {
    GetRestoreResp result = apiInstance.getRestoreTask(projectId, restoreId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RestoreApi#getRestoreTask");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| The ID of your project. You can get the project ID from the response of [List all accessible projects.](#tag/Project/operation/ListProjects). |
 **restoreId** | **String**| The ID of the restore task. |

### Return type

[**GetRestoreResp**](GetRestoreResp.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listRestoreTasks"></a>
# **listRestoreTasks**
> ListRestoreResp listRestoreTasks(projectId, page, pageSize)

List the restore tasks in a project.

 For Developer Tier clusters, you cannot create or manage restore tasks via API.

### Example
```java
// Import classes:
//import com.github.icemap.invoker.ApiException;
//import com.github.icemap.api.RestoreApi;


RestoreApi apiInstance = new RestoreApi();
String projectId = "projectId_example"; // String | The ID of your project. You can get the project ID from the response of [List all accessible projects.](#tag/Project/operation/ListProjects).
Integer page = 1; // Integer | The number of pages.
Integer pageSize = 10; // Integer | The size of a page.
try {
    ListRestoreResp result = apiInstance.listRestoreTasks(projectId, page, pageSize);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RestoreApi#listRestoreTasks");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| The ID of your project. You can get the project ID from the response of [List all accessible projects.](#tag/Project/operation/ListProjects). |
 **page** | **Integer**| The number of pages. | [optional] [default to 1]
 **pageSize** | **Integer**| The size of a page. | [optional] [default to 10]

### Return type

[**ListRestoreResp**](ListRestoreResp.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

