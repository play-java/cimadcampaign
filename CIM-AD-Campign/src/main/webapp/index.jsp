<html>
<body>
<h2>CIM AD Campaign</h2>

<ul>
  <li>API: add campaign </li>
  <li>Method: POST</li>
  <li>Action: http://localhost:8080/cimadcampain/ad/</li>
  <li>Content type: application/json</li>
  <li>Content</li>
  <li>{
	"partnerId": "2",
	"duration": 12345,
	"adContent": "Message goes here"
	}</li>
</ul>

<ul>
  <li>API: Get ad campain data by partner id - </li>
  <li>Method: GET</li>
  <li>Action: http://localhost:8080/cimadcampain/ad/{partnerid}</li>
</ul>

<ul>
  <li>API: Get list of all campaign - </li>
  <li>Method: GET</li>
  <li>Action:http://localhost:8080/cimadcampain/ad/getallcampaign</li>
</ul>


</body>
</html>
