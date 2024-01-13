const deleteStudent = () => {
	var form = document.forms["formDeleteStudent"]
	var requestParameters = "id=" + form["id"].value
	fetch("http://localhost:8080/Examples/deleteStudent", {
		method: 'POST',
		headers: {
			'Content-Type': 'application/x-www-form-urlencoded'
		},
		body: requestParameters
	})
	.then(response => {
		if (!response.ok) {
			 throw new Error(`HTTP Error! Status: ${response.status}`);
		}
		return response.json
	})
	.then(data => {
		handleResponse(data)
	})
	.catch(error => {
		alert("Post request failed: " + error)
	})
}

const handleResponse = data => {
	switch (data) {
		case 0:
			alert('Student data deleted')
			break
		case 1:
			alert('Student data not deleted. Unknown id')
			break
		case -1:
			alert('The database is temporarily unavail.')
			break
		default:
			alert('Unknown')
	}
}