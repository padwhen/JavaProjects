const addStudent = () => {
	var form = document.forms["formStudent"];
	var requestParameters = 
	"id=" + form["id"].value +
	"&firstname=" + form["firstname"].value + 
	"&lastname=" + form["lastname"].value + 
	"&streetaddress=" + form["streetaddress"].value + 
	"&postcode=" + form["postcode"].value + 
	"&postoffice=" + form["postoffice"].value
	fetch("http://localhost:8080/Examples/addStudent", {
		method:'POST',
		headers: {
			'Content-Type': 'application/x-www-form-urlencoded'
		},
		body: requestParameters
	})
	.then(response => {
		if (!response.ok) {
			throw new Error(`HTTP Error! Status: ${response.status}`)
		}
		return response.json();
	})
	.then(data => {
		handleResponse(data)
	})
	.catch(error => {
		alert("Post request failed: " + error.message)
	})
}

const handleResponse = data => {
    console.log("Received data:", data);
    if (data === 0) {
        alert('Student data added!');
    } else if (data === 1) {
        alert('Cannot add the student. The ID is already in use');
    } else if (data === -1) {
        alert('The database is temporarily unavailable. Please try again later');
    } else {
        alert('Unknown error');
    }
};
