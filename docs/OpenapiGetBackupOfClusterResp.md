
# OpenapiGetBackupOfClusterResp

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The ID of the backup. |  [optional]
**name** | **String** | The name of the backup. |  [optional]
**description** | **String** | The description of the backup. It is specified by the user when taking a manual type backup. It helps you add additional information to the backup. |  [optional]
**type** | [**TypeEnum**](#TypeEnum) | The type of backup. TiDB Cloud only supports manual and auto backup. For more information, see [TiDB Cloud Documentation](https://docs.pingcap.com/tidbcloud/backup-and-restore#backup). |  [optional]
**createTimestamp** | [**DateTime**](DateTime.md) | The creation time of the backup in UTC. The time format follows the [ISO8601](http://en.wikipedia.org/wiki/ISO_8601) standard, which is &#x60;YYYY-MM-DD&#x60; (year-month-day) + T +&#x60;HH:MM:SS&#x60; (hour-minutes-seconds) + Z. For example, &#x60;2020-01-01T00:00:00Z&#x60;. |  [optional]
**size** | **String** | The bytes of the backup. |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | The status of backup. |  [optional]


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
MANUAL | &quot;MANUAL&quot;
AUTO | &quot;AUTO&quot;


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
PENDING | &quot;PENDING&quot;
RUNNING | &quot;RUNNING&quot;
FAILED | &quot;FAILED&quot;
SUCCESS | &quot;SUCCESS&quot;


