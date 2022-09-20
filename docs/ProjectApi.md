# ProjectApi

All URIs are relative to *https://api.tidbcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**listProjects**](ProjectApi.md#listProjects) | **GET** /api/v1beta/projects | List all accessible projects.


<a name="listProjects"></a>
# **listProjects**
> GetProjectsResp listProjects(page, pageSize)

List all accessible projects.

### Example
```java
// Import classes:
//import com.github.icemap.invoker.ApiException;
//import com.github.icemap.api.ProjectApi;


ProjectApi apiInstance = new ProjectApi();
Long page = 1L; // Long | The number of pages.
Long pageSize = 10L; // Long | The size of a page.
try {
    GetProjectsResp result = apiInstance.listProjects(page, pageSize);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectApi#listProjects");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **Long**| The number of pages. | [optional] [default to 1]
 **pageSize** | **Long**| The size of a page. | [optional] [default to 10]

### Return type

[**GetProjectsResp**](GetProjectsResp.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

