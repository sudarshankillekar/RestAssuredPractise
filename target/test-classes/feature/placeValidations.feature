Feature: Validating Place API's

Scenario Outline: Verify if Place is being Succesfully added using AddPlaceAPI

Given Add Place Payload with "<name>" "<number>" "<launge>"
When user calls "AddPlaceAPI" with "GET" http request
Then the API call got success with status code 200
And "status" in response body is "OK"
And verify place id created that map's to "<name>" created using "GetPlaceApi"

Examples:
|name |number |launge |
|sudarsha  |8904356647 |heje |
|sindhu  |8678787 |nagpur |

Scenario:

Given Deletplace payload
When user calls "DeletePlaceApi" with "POST" http request
Then the API call got success with status code 200
And "status" in response body is "OK"
