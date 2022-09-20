
# GetClustersOfProjectRespStatus

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tidbVersion** | **String** | TiDB version. |  [optional]
**clusterStatus** | [**ClusterStatusEnum**](#ClusterStatusEnum) | Status of the cluster. |  [optional]
**nodeMap** | [**GetClustersOfProjectRespStatusNodeMap**](GetClustersOfProjectRespStatusNodeMap.md) |  |  [optional]
**connectionStrings** | [**GetClustersOfProjectRespStatusConnectionStrings**](GetClustersOfProjectRespStatusConnectionStrings.md) |  |  [optional]


<a name="ClusterStatusEnum"></a>
## Enum: ClusterStatusEnum
Name | Value
---- | -----
AVAILABLE | &quot;AVAILABLE&quot;
CREATING | &quot;CREATING&quot;
MODIFYING | &quot;MODIFYING&quot;
PAUSED | &quot;PAUSED&quot;
RESUMING | &quot;RESUMING&quot;
UNAVAILABLE | &quot;UNAVAILABLE&quot;
IMPORTING | &quot;IMPORTING&quot;



