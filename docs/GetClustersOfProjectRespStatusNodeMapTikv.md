
# GetClustersOfProjectRespStatusNodeMapTikv

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**nodeName** | **String** | The name of a node in the cluster. |  [optional]
**availabilityZone** | **String** | The availability zone of a node in the cluster. |  [optional]
**nodeSize** | **String** | The size of the TiKV component in the cluster. |  [optional]
**vcpuNum** | **Integer** | The total vCPUs of a node in the cluster. If the &#x60;cluster_type&#x60; is &#x60;\&quot;DEVELOPER\&quot;&#x60;, &#x60;vcpu_num&#x60; is always 0. |  [optional]
**ramBytes** | **String** | The RAM size of a node in the cluster. If the &#x60;cluster_type&#x60; is &#x60;\&quot;DEVELOPER\&quot;&#x60;, &#x60;ram_bytes&#x60; is always 0. |  [optional]
**storageSizeGib** | **Integer** | The storage size of a node in the cluster. |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | The status of a node in the cluster. |  [optional]


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
AVAILABLE | &quot;NODE_STATUS_AVAILABLE&quot;
UNAVAILABLE | &quot;NODE_STATUS_UNAVAILABLE&quot;
CREATING | &quot;NODE_STATUS_CREATING&quot;
DELETING | &quot;NODE_STATUS_DELETING&quot;



