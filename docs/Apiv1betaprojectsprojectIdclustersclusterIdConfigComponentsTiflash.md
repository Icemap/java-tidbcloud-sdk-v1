
# Apiv1betaprojectsprojectIdclustersclusterIdConfigComponentsTiflash

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**nodeSize** | **String** | The size of the TiFlash component in the cluster. You can get the available node size of each region from the response of [List the cloud providers, regions and available specifications](#tag/Cluster/operation/ListProviderRegions).  **Additional combination rules**: - If the vCPUs of TiDB or TiKV component is 2 or 4, then their vCPUs need to be the same. - If the vCPUs of TiDB or TiKV component is 2 or 4, then the cluster does not support TiFlash.  **Limitations**: - You cannot modify &#x60;node_size&#x60; for TiFlash of an existing cluster. |  [optional]
**storageSizeGib** | **Integer** | The storage size of a node in the cluster. You can get the minimum and maximum of storage size from the response of [List the cloud providers, regions and available specifications](#tag/Cluster/operation/ListProviderRegions).  **Limitations**: - You cannot decrease storage size for TiFlash. - If your TiDB cluster is hosted by AWS, after changing the storage size of TiFlash, you must wait at least six hours before you can change it again. |  [optional]
**nodeQuantity** | **Integer** | The number of nodes in the cluster. You can get the minimum and step of a node quantity from the response of [List the cloud providers, regions and available specifications](#tag/Cluster/operation/ListProviderRegions).  **Limitations**: - You cannot decrease node quantity for TiFlash. |  [optional]



