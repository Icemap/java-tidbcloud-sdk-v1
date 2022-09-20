# BackupApi

All URIs are relative to *https://api.tidbcloud.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createBackup**](BackupApi.md#createBackup) | **POST** /api/v1beta/projects/{project_id}/clusters/{cluster_id}/backups | Create a backup for a cluster.
[**deleteBackup**](BackupApi.md#deleteBackup) | **DELETE** /api/v1beta/projects/{project_id}/clusters/{cluster_id}/backups/{backup_id} | Delete a backup for a cluster.
[**getBackupOfCluster**](BackupApi.md#getBackupOfCluster) | **GET** /api/v1beta/projects/{project_id}/clusters/{cluster_id}/backups/{backup_id} | Get a backup for a cluster.
[**listBackUpOfCluster**](BackupApi.md#listBackUpOfCluster) | **GET** /api/v1beta/projects/{project_id}/clusters/{cluster_id}/backups | List all backups for a cluster.


<a name="createBackup"></a>
# **createBackup**
> CreateBackupResp createBackup(projectId, clusterId, body)

Create a backup for a cluster.

- For Dedicated Tier clusters, you can create as many manual backups as you need. - For Developer Tier clusters, you cannot create backups via API. You can use [Dumpling](https://docs.pingcap.com/tidb/stable/dumpling-overview) to export your data as backups.

### Example
```java
// Import classes:
//import com.github.icemap.invoker.ApiException;
//import com.github.icemap.api.BackupApi;


BackupApi apiInstance = new BackupApi();
String projectId = "projectId_example"; // String | The ID of your project. You can get the project ID from the response of [List all accessible projects.](#tag/Project/operation/ListProjects).
String clusterId = "clusterId_example"; // String | The ID of your cluster that you want to take a manual backup. You can get the cluster ID from the response of [Get all clusters in a project](#tag/Cluster/operation/ListClustersOfProject).
CreateBackupReq body = new CreateBackupReq(); // CreateBackupReq | 
try {
    CreateBackupResp result = apiInstance.createBackup(projectId, clusterId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BackupApi#createBackup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| The ID of your project. You can get the project ID from the response of [List all accessible projects.](#tag/Project/operation/ListProjects). |
 **clusterId** | **String**| The ID of your cluster that you want to take a manual backup. You can get the cluster ID from the response of [Get all clusters in a project](#tag/Cluster/operation/ListClustersOfProject). |
 **body** | [**CreateBackupReq**](CreateBackupReq.md)|  |

### Return type

[**CreateBackupResp**](CreateBackupResp.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteBackup"></a>
# **deleteBackup**
> Object deleteBackup(projectId, clusterId, backupId)

Delete a backup for a cluster.

For Developer Tier clusters, you cannot manage backups via API. You can use [Dumpling](https://docs.pingcap.com/tidb/stable/dumpling-overview) to export your data as backups.

### Example
```java
// Import classes:
//import com.github.icemap.invoker.ApiException;
//import com.github.icemap.api.BackupApi;


BackupApi apiInstance = new BackupApi();
String projectId = "projectId_example"; // String | The ID of your project. You can get the project ID from the response of [List all accessible projects.](#tag/Project/operation/ListProjects).
String clusterId = "clusterId_example"; // String | The ID of your cluster. You can get the cluster ID from the response of [Get all clusters in a project](#tag/Cluster/operation/ListClustersOfProject).
String backupId = "backupId_example"; // String | The ID of the backup. You can get the backup ID from the response of [List all backups for a cluster](#tag/Project/operation/ListBackUpOfCluster).
try {
    Object result = apiInstance.deleteBackup(projectId, clusterId, backupId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BackupApi#deleteBackup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| The ID of your project. You can get the project ID from the response of [List all accessible projects.](#tag/Project/operation/ListProjects). |
 **clusterId** | **String**| The ID of your cluster. You can get the cluster ID from the response of [Get all clusters in a project](#tag/Cluster/operation/ListClustersOfProject). |
 **backupId** | **String**| The ID of the backup. You can get the backup ID from the response of [List all backups for a cluster](#tag/Project/operation/ListBackUpOfCluster). |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getBackupOfCluster"></a>
# **getBackupOfCluster**
> GetBackupOfClusterResp getBackupOfCluster(projectId, clusterId, backupId)

Get a backup for a cluster.

For Developer Tier clusters, you cannot manage backups via API. You can use [Dumpling](https://docs.pingcap.com/tidb/stable/dumpling-overview) to export your data as backups.

### Example
```java
// Import classes:
//import com.github.icemap.invoker.ApiException;
//import com.github.icemap.api.BackupApi;


BackupApi apiInstance = new BackupApi();
String projectId = "projectId_example"; // String | The ID of your project. You can get the project ID from the response of [List all accessible projects.](#tag/Project/operation/ListProjects).
String clusterId = "clusterId_example"; // String | The ID of your cluster. You can get the cluster ID from the response of [Get all clusters in a project](#tag/Cluster/operation/ListClustersOfProject).
String backupId = "backupId_example"; // String | The ID of the backup.
try {
    GetBackupOfClusterResp result = apiInstance.getBackupOfCluster(projectId, clusterId, backupId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BackupApi#getBackupOfCluster");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| The ID of your project. You can get the project ID from the response of [List all accessible projects.](#tag/Project/operation/ListProjects). |
 **clusterId** | **String**| The ID of your cluster. You can get the cluster ID from the response of [Get all clusters in a project](#tag/Cluster/operation/ListClustersOfProject). |
 **backupId** | **String**| The ID of the backup. |

### Return type

[**GetBackupOfClusterResp**](GetBackupOfClusterResp.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listBackUpOfCluster"></a>
# **listBackUpOfCluster**
> ListBackupOfClusterResp listBackUpOfCluster(projectId, clusterId, page, pageSize)

List all backups for a cluster.

For Developer Tier clusters, you cannot manage backups via API. You can use [Dumpling](https://docs.pingcap.com/tidb/stable/dumpling-overview) to export your data as backups.

### Example
```java
// Import classes:
//import com.github.icemap.invoker.ApiException;
//import com.github.icemap.api.BackupApi;


BackupApi apiInstance = new BackupApi();
String projectId = "projectId_example"; // String | The ID of your project. You can get the project ID from the response of [List all accessible projects.](#tag/Project/operation/ListProjects).
String clusterId = "clusterId_example"; // String | The ID of your cluster. You can get the cluster ID from the response of [Get all clusters in a project](#tag/Cluster/operation/ListClustersOfProject).
Integer page = 1; // Integer | The number of pages.
Integer pageSize = 10; // Integer | The size of a page.
try {
    ListBackupOfClusterResp result = apiInstance.listBackUpOfCluster(projectId, clusterId, page, pageSize);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BackupApi#listBackUpOfCluster");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| The ID of your project. You can get the project ID from the response of [List all accessible projects.](#tag/Project/operation/ListProjects). |
 **clusterId** | **String**| The ID of your cluster. You can get the cluster ID from the response of [Get all clusters in a project](#tag/Cluster/operation/ListClustersOfProject). |
 **page** | **Integer**| The number of pages. | [optional] [default to 1]
 **pageSize** | **Integer**| The size of a page. | [optional] [default to 10]

### Return type

[**ListBackupOfClusterResp**](ListBackupOfClusterResp.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

