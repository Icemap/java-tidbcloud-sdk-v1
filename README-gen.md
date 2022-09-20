# java-tidbcloud-sdk-v1

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>com.github.icemap</groupId>
    <artifactId>java-tidbcloud-sdk-v1</artifactId>
    <version>0.0.1</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "com.github.icemap:java-tidbcloud-sdk-v1:0.0.1"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/java-tidbcloud-sdk-v1-0.0.1.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import com.github.icemap.invoker.*;
import com.github.icemap.invoker.auth.*;
import com.github.icemap.invoker.model.*;
import com.github.icemap.api.BackupApi;

import java.io.File;
import java.util.*;

public class BackupApiExample {

    public static void main(String[] args) {
        
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
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://api.tidbcloud.com*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*BackupApi* | [**createBackup**](docs/BackupApi.md#createBackup) | **POST** /api/v1beta/projects/{project_id}/clusters/{cluster_id}/backups | Create a backup for a cluster.
*BackupApi* | [**deleteBackup**](docs/BackupApi.md#deleteBackup) | **DELETE** /api/v1beta/projects/{project_id}/clusters/{cluster_id}/backups/{backup_id} | Delete a backup for a cluster.
*BackupApi* | [**getBackupOfCluster**](docs/BackupApi.md#getBackupOfCluster) | **GET** /api/v1beta/projects/{project_id}/clusters/{cluster_id}/backups/{backup_id} | Get a backup for a cluster.
*BackupApi* | [**listBackUpOfCluster**](docs/BackupApi.md#listBackUpOfCluster) | **GET** /api/v1beta/projects/{project_id}/clusters/{cluster_id}/backups | List all backups for a cluster.
*ClusterApi* | [**createCluster**](docs/ClusterApi.md#createCluster) | **POST** /api/v1beta/projects/{project_id}/clusters | Create a cluster.
*ClusterApi* | [**deleteCluster**](docs/ClusterApi.md#deleteCluster) | **DELETE** /api/v1beta/projects/{project_id}/clusters/{cluster_id} | Delete a cluster.
*ClusterApi* | [**getCluster**](docs/ClusterApi.md#getCluster) | **GET** /api/v1beta/projects/{project_id}/clusters/{cluster_id} | Get a cluster by ID.
*ClusterApi* | [**listClustersOfProject**](docs/ClusterApi.md#listClustersOfProject) | **GET** /api/v1beta/projects/{project_id}/clusters | List all clusters in a project.
*ClusterApi* | [**listProviderRegions**](docs/ClusterApi.md#listProviderRegions) | **GET** /api/v1beta/clusters/provider/regions | List the cloud providers, regions and available specifications.
*ClusterApi* | [**updateCluster**](docs/ClusterApi.md#updateCluster) | **PATCH** /api/v1beta/projects/{project_id}/clusters/{cluster_id} | Modify a Dedicated Tier cluster.
*ProjectApi* | [**listProjects**](docs/ProjectApi.md#listProjects) | **GET** /api/v1beta/projects | List all accessible projects.
*RestoreApi* | [**createRestoreTask**](docs/RestoreApi.md#createRestoreTask) | **POST** /api/v1beta/projects/{project_id}/restores | Create a restore task.
*RestoreApi* | [**getRestoreTask**](docs/RestoreApi.md#getRestoreTask) | **GET** /api/v1beta/projects/{project_id}/restores/{restore_id} | Get a restore task.
*RestoreApi* | [**listRestoreTasks**](docs/RestoreApi.md#listRestoreTasks) | **GET** /api/v1beta/projects/{project_id}/restores | List the restore tasks in a project.


## Documentation for Models

 - [Apiv1betaprojectsprojectIdclustersConfig](docs/Apiv1betaprojectsprojectIdclustersConfig.md)
 - [Apiv1betaprojectsprojectIdclustersConfigComponents](docs/Apiv1betaprojectsprojectIdclustersConfigComponents.md)
 - [Apiv1betaprojectsprojectIdclustersConfigIpAccessList](docs/Apiv1betaprojectsprojectIdclustersConfigIpAccessList.md)
 - [Apiv1betaprojectsprojectIdclustersclusterIdConfig](docs/Apiv1betaprojectsprojectIdclustersclusterIdConfig.md)
 - [Apiv1betaprojectsprojectIdclustersclusterIdConfigComponents](docs/Apiv1betaprojectsprojectIdclustersclusterIdConfigComponents.md)
 - [Apiv1betaprojectsprojectIdclustersclusterIdConfigComponentsTidb](docs/Apiv1betaprojectsprojectIdclustersclusterIdConfigComponentsTidb.md)
 - [Apiv1betaprojectsprojectIdclustersclusterIdConfigComponentsTiflash](docs/Apiv1betaprojectsprojectIdclustersclusterIdConfigComponentsTiflash.md)
 - [Apiv1betaprojectsprojectIdclustersclusterIdConfigComponentsTikv](docs/Apiv1betaprojectsprojectIdclustersclusterIdConfigComponentsTikv.md)
 - [CreateBackupReq](docs/CreateBackupReq.md)
 - [CreateBackupResp](docs/CreateBackupResp.md)
 - [CreateClusterReq](docs/CreateClusterReq.md)
 - [CreateClusterResp](docs/CreateClusterResp.md)
 - [CreateRestoreReq](docs/CreateRestoreReq.md)
 - [CreateRestoreResp](docs/CreateRestoreResp.md)
 - [ErrorResponse](docs/ErrorResponse.md)
 - [GetBackupOfClusterResp](docs/GetBackupOfClusterResp.md)
 - [GetClustersOfProjectResp](docs/GetClustersOfProjectResp.md)
 - [GetClustersOfProjectRespConfig](docs/GetClustersOfProjectRespConfig.md)
 - [GetClustersOfProjectRespConfigComponents](docs/GetClustersOfProjectRespConfigComponents.md)
 - [GetClustersOfProjectRespConfigComponentsTidb](docs/GetClustersOfProjectRespConfigComponentsTidb.md)
 - [GetClustersOfProjectRespConfigComponentsTiflash](docs/GetClustersOfProjectRespConfigComponentsTiflash.md)
 - [GetClustersOfProjectRespConfigComponentsTikv](docs/GetClustersOfProjectRespConfigComponentsTikv.md)
 - [GetClustersOfProjectRespItems](docs/GetClustersOfProjectRespItems.md)
 - [GetClustersOfProjectRespStatus](docs/GetClustersOfProjectRespStatus.md)
 - [GetClustersOfProjectRespStatusConnectionStrings](docs/GetClustersOfProjectRespStatusConnectionStrings.md)
 - [GetClustersOfProjectRespStatusConnectionStringsStandard](docs/GetClustersOfProjectRespStatusConnectionStringsStandard.md)
 - [GetClustersOfProjectRespStatusConnectionStringsVpcPeering](docs/GetClustersOfProjectRespStatusConnectionStringsVpcPeering.md)
 - [GetClustersOfProjectRespStatusNodeMap](docs/GetClustersOfProjectRespStatusNodeMap.md)
 - [GetClustersOfProjectRespStatusNodeMapTidb](docs/GetClustersOfProjectRespStatusNodeMapTidb.md)
 - [GetClustersOfProjectRespStatusNodeMapTiflash](docs/GetClustersOfProjectRespStatusNodeMapTiflash.md)
 - [GetClustersOfProjectRespStatusNodeMapTikv](docs/GetClustersOfProjectRespStatusNodeMapTikv.md)
 - [GetProjectsResp](docs/GetProjectsResp.md)
 - [GetProjectsRespItems](docs/GetProjectsRespItems.md)
 - [GetProviderRegionsResp](docs/GetProviderRegionsResp.md)
 - [GetProviderRegionsRespItems](docs/GetProviderRegionsRespItems.md)
 - [GetProviderRegionsRespNodeQuantityRange](docs/GetProviderRegionsRespNodeQuantityRange.md)
 - [GetProviderRegionsRespNodeQuantityRange1](docs/GetProviderRegionsRespNodeQuantityRange1.md)
 - [GetProviderRegionsRespNodeQuantityRange2](docs/GetProviderRegionsRespNodeQuantityRange2.md)
 - [GetProviderRegionsRespStorageSizeGibRange](docs/GetProviderRegionsRespStorageSizeGibRange.md)
 - [GetProviderRegionsRespStorageSizeGibRange1](docs/GetProviderRegionsRespStorageSizeGibRange1.md)
 - [GetProviderRegionsRespTidb](docs/GetProviderRegionsRespTidb.md)
 - [GetProviderRegionsRespTiflash](docs/GetProviderRegionsRespTiflash.md)
 - [GetProviderRegionsRespTikv](docs/GetProviderRegionsRespTikv.md)
 - [GetRestoreResp](docs/GetRestoreResp.md)
 - [InlineResponse400](docs/InlineResponse400.md)
 - [InlineResponseDefault](docs/InlineResponseDefault.md)
 - [ListBackupOfClusterResp](docs/ListBackupOfClusterResp.md)
 - [ListBackupOfClusterRespItems](docs/ListBackupOfClusterRespItems.md)
 - [ListRestoreResp](docs/ListRestoreResp.md)
 - [ListRestoreRespCluster](docs/ListRestoreRespCluster.md)
 - [ListRestoreRespItems](docs/ListRestoreRespItems.md)
 - [OpenapiBackupTypeEnum](docs/OpenapiBackupTypeEnum.md)
 - [OpenapiCloudProvider](docs/OpenapiCloudProvider.md)
 - [OpenapiClusterComponents](docs/OpenapiClusterComponents.md)
 - [OpenapiClusterConfig](docs/OpenapiClusterConfig.md)
 - [OpenapiClusterConnectionStrings](docs/OpenapiClusterConnectionStrings.md)
 - [OpenapiClusterInfoOfRestore](docs/OpenapiClusterInfoOfRestore.md)
 - [OpenapiClusterItem](docs/OpenapiClusterItem.md)
 - [OpenapiClusterItemStatus](docs/OpenapiClusterItemStatus.md)
 - [OpenapiClusterNodeMap](docs/OpenapiClusterNodeMap.md)
 - [OpenapiClusterStatus](docs/OpenapiClusterStatus.md)
 - [OpenapiClusterType](docs/OpenapiClusterType.md)
 - [OpenapiCreateBackupResp](docs/OpenapiCreateBackupResp.md)
 - [OpenapiCreateClusterResp](docs/OpenapiCreateClusterResp.md)
 - [OpenapiCreateRestoreResp](docs/OpenapiCreateRestoreResp.md)
 - [OpenapiGetBackupOfClusterResp](docs/OpenapiGetBackupOfClusterResp.md)
 - [OpenapiGetBackupOfClusterRespStatusEnum](docs/OpenapiGetBackupOfClusterRespStatusEnum.md)
 - [OpenapiGetClusterConfig](docs/OpenapiGetClusterConfig.md)
 - [OpenapiGetRestoreResp](docs/OpenapiGetRestoreResp.md)
 - [OpenapiGetRestoreRespStatusEnum](docs/OpenapiGetRestoreRespStatusEnum.md)
 - [OpenapiIpAccessListItem](docs/OpenapiIpAccessListItem.md)
 - [OpenapiListBackupItem](docs/OpenapiListBackupItem.md)
 - [OpenapiListBackupItemStatusEnum](docs/OpenapiListBackupItemStatusEnum.md)
 - [OpenapiListBackupOfClusterResp](docs/OpenapiListBackupOfClusterResp.md)
 - [OpenapiListClustersOfProjectResp](docs/OpenapiListClustersOfProjectResp.md)
 - [OpenapiListProjectItem](docs/OpenapiListProjectItem.md)
 - [OpenapiListProjectsResp](docs/OpenapiListProjectsResp.md)
 - [OpenapiListProviderRegionsItem](docs/OpenapiListProviderRegionsItem.md)
 - [OpenapiListProviderRegionsResp](docs/OpenapiListProviderRegionsResp.md)
 - [OpenapiListRestoreOfProjectResp](docs/OpenapiListRestoreOfProjectResp.md)
 - [OpenapiListRestoreRespItem](docs/OpenapiListRestoreRespItem.md)
 - [OpenapiListRestoreRespItemStatusEnum](docs/OpenapiListRestoreRespItemStatusEnum.md)
 - [OpenapiNodeQuantityRange](docs/OpenapiNodeQuantityRange.md)
 - [OpenapiNodeStatus](docs/OpenapiNodeStatus.md)
 - [OpenapiNodeStorageSizeRange](docs/OpenapiNodeStorageSizeRange.md)
 - [OpenapiStandardConnection](docs/OpenapiStandardConnection.md)
 - [OpenapiTiDBComponent](docs/OpenapiTiDBComponent.md)
 - [OpenapiTiDBNodeMap](docs/OpenapiTiDBNodeMap.md)
 - [OpenapiTiDBProfile](docs/OpenapiTiDBProfile.md)
 - [OpenapiTiFlashComponent](docs/OpenapiTiFlashComponent.md)
 - [OpenapiTiFlashNodeMap](docs/OpenapiTiFlashNodeMap.md)
 - [OpenapiTiFlashProfile](docs/OpenapiTiFlashProfile.md)
 - [OpenapiTiKVComponent](docs/OpenapiTiKVComponent.md)
 - [OpenapiTiKVNodeMap](docs/OpenapiTiKVNodeMap.md)
 - [OpenapiTiKVProfile](docs/OpenapiTiKVProfile.md)
 - [OpenapiUpdateClusterComponents](docs/OpenapiUpdateClusterComponents.md)
 - [OpenapiUpdateClusterConfig](docs/OpenapiUpdateClusterConfig.md)
 - [OpenapiUpdateTiDBComponent](docs/OpenapiUpdateTiDBComponent.md)
 - [OpenapiUpdateTiFlashComponent](docs/OpenapiUpdateTiFlashComponent.md)
 - [OpenapiUpdateTiKVComponent](docs/OpenapiUpdateTiKVComponent.md)
 - [OpenapiVPCPeeringConnection](docs/OpenapiVPCPeeringConnection.md)
 - [ProtobufAny](docs/ProtobufAny.md)
 - [RpcStatus](docs/RpcStatus.md)
 - [UpdateClusterReq](docs/UpdateClusterReq.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issue.

## Author



