# ClusterApi

All URIs are relative to *https://api.tidbcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createCluster**](ClusterApi.md#createCluster) | **POST** /api/v1beta/projects/{project_id}/clusters | Create a cluster.
[**deleteCluster**](ClusterApi.md#deleteCluster) | **DELETE** /api/v1beta/projects/{project_id}/clusters/{cluster_id} | Delete a cluster.
[**getCluster**](ClusterApi.md#getCluster) | **GET** /api/v1beta/projects/{project_id}/clusters/{cluster_id} | Get a cluster by ID.
[**listClustersOfProject**](ClusterApi.md#listClustersOfProject) | **GET** /api/v1beta/projects/{project_id}/clusters | List all clusters in a project.
[**listProviderRegions**](ClusterApi.md#listProviderRegions) | **GET** /api/v1beta/clusters/provider/regions | List the cloud providers, regions and available specifications.
[**updateCluster**](ClusterApi.md#updateCluster) | **PATCH** /api/v1beta/projects/{project_id}/clusters/{cluster_id} | Modify a Dedicated Tier cluster.


<a name="createCluster"></a>
# **createCluster**
> CreateClusterResp createCluster(projectId, body)

Create a cluster.

Before creating a Dedicated Tier cluster, you must [set a Project CIDR](https://docs.pingcap.com/tidbcloud/set-up-vpc-peering-connections#prerequisite-set-a-project-cidr) on [TiDB Cloud console](https://tidbcloud.com/).

### Example
```java
// Import classes:
//import com.github.icemap.invoker.ApiException;
//import com.github.icemap.api.ClusterApi;


ClusterApi apiInstance = new ClusterApi();
String projectId = "projectId_example"; // String | The ID of the project. You can get the project ID from the response of [List all accessible projects](#tag/Project/operation/ListProjects).
CreateClusterReq body = new CreateClusterReq(); // CreateClusterReq | 
try {
    CreateClusterResp result = apiInstance.createCluster(projectId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ClusterApi#createCluster");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| The ID of the project. You can get the project ID from the response of [List all accessible projects](#tag/Project/operation/ListProjects). |
 **body** | [**CreateClusterReq**](CreateClusterReq.md)|  |

### Return type

[**CreateClusterResp**](CreateClusterResp.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteCluster"></a>
# **deleteCluster**
> Object deleteCluster(projectId, clusterId)

Delete a cluster.

### Example
```java
// Import classes:
//import com.github.icemap.invoker.ApiException;
//import com.github.icemap.api.ClusterApi;


ClusterApi apiInstance = new ClusterApi();
String projectId = "projectId_example"; // String | The ID of the project. You can get the project ID from the response of [List all accessible projects](#tag/Project/operation/ListProjects).
String clusterId = "clusterId_example"; // String | The ID of the cluster.
try {
    Object result = apiInstance.deleteCluster(projectId, clusterId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ClusterApi#deleteCluster");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| The ID of the project. You can get the project ID from the response of [List all accessible projects](#tag/Project/operation/ListProjects). |
 **clusterId** | **String**| The ID of the cluster. |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getCluster"></a>
# **getCluster**
> GetClustersOfProjectRespItems getCluster(projectId, clusterId)

Get a cluster by ID.

### Example
```java
// Import classes:
//import com.github.icemap.invoker.ApiException;
//import com.github.icemap.api.ClusterApi;


ClusterApi apiInstance = new ClusterApi();
String projectId = "projectId_example"; // String | The ID of the project. You can get the project ID from the response of [List all accessible projects](#tag/Project/operation/ListProjects).
String clusterId = "clusterId_example"; // String | The ID of the cluster.
try {
    GetClustersOfProjectRespItems result = apiInstance.getCluster(projectId, clusterId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ClusterApi#getCluster");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| The ID of the project. You can get the project ID from the response of [List all accessible projects](#tag/Project/operation/ListProjects). |
 **clusterId** | **String**| The ID of the cluster. |

### Return type

[**GetClustersOfProjectRespItems**](GetClustersOfProjectRespItems.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listClustersOfProject"></a>
# **listClustersOfProject**
> GetClustersOfProjectResp listClustersOfProject(projectId, page, pageSize)

List all clusters in a project.

### Example
```java
// Import classes:
//import com.github.icemap.invoker.ApiException;
//import com.github.icemap.api.ClusterApi;


ClusterApi apiInstance = new ClusterApi();
String projectId = "projectId_example"; // String | The ID of the project. You can get the project ID from the response of [List all accessible projects](#tag/Project/operation/ListProjects).
Long page = 1L; // Long | The number of pages.
Long pageSize = 10L; // Long | The size of a page.
try {
    GetClustersOfProjectResp result = apiInstance.listClustersOfProject(projectId, page, pageSize);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ClusterApi#listClustersOfProject");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| The ID of the project. You can get the project ID from the response of [List all accessible projects](#tag/Project/operation/ListProjects). |
 **page** | **Long**| The number of pages. | [optional] [default to 1]
 **pageSize** | **Long**| The size of a page. | [optional] [default to 10]

### Return type

[**GetClustersOfProjectResp**](GetClustersOfProjectResp.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listProviderRegions"></a>
# **listProviderRegions**
> GetProviderRegionsResp listProviderRegions()

List the cloud providers, regions and available specifications.

### Example
```java
// Import classes:
//import com.github.icemap.invoker.ApiException;
//import com.github.icemap.api.ClusterApi;


ClusterApi apiInstance = new ClusterApi();
try {
    GetProviderRegionsResp result = apiInstance.listProviderRegions();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ClusterApi#listProviderRegions");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetProviderRegionsResp**](GetProviderRegionsResp.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateCluster"></a>
# **updateCluster**
> Object updateCluster(projectId, clusterId, body)

Modify a Dedicated Tier cluster.

With this endpoint, you can modify the components of a cluster using the &#x60;config.components&#x60; parameter, or pause or resume a cluster using the &#x60;config.paused&#x60; parameter.

### Example
```java
// Import classes:
//import com.github.icemap.invoker.ApiException;
//import com.github.icemap.api.ClusterApi;


ClusterApi apiInstance = new ClusterApi();
String projectId = "projectId_example"; // String | The ID of the project. You can get the project ID from the response of [List all accessible projects](#tag/Project/operation/ListProjects).
String clusterId = "clusterId_example"; // String | The ID of the cluster.
UpdateClusterReq body = new UpdateClusterReq(); // UpdateClusterReq | 
try {
    Object result = apiInstance.updateCluster(projectId, clusterId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ClusterApi#updateCluster");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| The ID of the project. You can get the project ID from the response of [List all accessible projects](#tag/Project/operation/ListProjects). |
 **clusterId** | **String**| The ID of the cluster. |
 **body** | [**UpdateClusterReq**](UpdateClusterReq.md)|  |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

