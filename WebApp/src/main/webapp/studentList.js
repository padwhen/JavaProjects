function main() {
	fetch("http://localhost:8080/Examples/students")
	.then(response => response.json())
	.then(studentList => printStudents(studentList))
}
function printStudents(studentList) {
	const tableBody = document.getElementById("studentTableBody");
	studentList.forEach(student => {
		const row = `
		<tr>
		<td>${student.id}</td>
		<td>${student.firstname}</td>
		<td>${student.lastname}</td>
		<td>${student.streetaddress}</td>
		<td>${student.postcode}</td>
		<td>${student.postoffice}</td>`
		tableBody.innerHTML += row
	})
	
}
main()