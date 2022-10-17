var selectedRow = null


function onFormsubmit(){
    var formData = readFormData();
    if(selectedRow == null)
        insertNewRecord(formData);
        else
    resetForm();
}

function readFormData(){
    var formData = {};
    formData["Employee Name"] = document.getElementById("Employee Name").value;
    formData["Employee Location"] = document.getElementById("Employee Location").value;
    formData["Employee Salary"] = document.getElementById("Employee Salary").value;
    formData["Employee Id"] = document.getElementById("Employee Id").value;
    return formData;
}

function insertNewRecord(data){
    var table = document.getElementById("EmployeeList").getElementsByTagName('tbody')[0];
    var newRow = table.insertRow(tabe.length);
    cell1 = newRow.insertCell(0);
    cell1.innerHTML = data.EmployeeName;
    cell2 = newRow.insertCell(1);
    cell2.innerHTMl = data.EmployeeLocation;
    cell3 = newRow.insertCell(2);
    cell3.innerHTMl = data.EmployeeSalary;
    cell4 = newRow.insertCell(3);
    cell4.innerHTMl = data.EmployeeId;
    cell4 = newRow.insertCell(4);
    cell4.innerHTMl = `<a onClick="onEdit(this)">Edit</a>
                        <a onClick="onDelete(this)">Delete</a>`;

}

function resetForm(){
    document.getElementById("Employee Name").value = "";
    document.getElementById("Employee Location").value = "";
    document.getElementById("Employee Salary").value = "";
    document.getElementById("Employee Id").value = "";
    var selectedRow = null;
}

function onedit(td){
    selectedRow = td.parentElement.parentElement;
    document.getElementById("Employee Name").value = selectRow.cells[0].innerHTML;
    document.getElementById("Employee Location").value = selectRow.cells[0].innerHTML;
    document.getElementById("Employee salary").value = selectRow.cells[0].innerHTML;
    document.getElementById("Employee Id").value = selectRow.cells[0].innerHTML;
}

function updateRecord(formData){
    selectedRow.cells[0].innerHTML = formData.EmployeeName;
    selectedRow.cells[1].innerHTML = formData.EmployeeLocation;
    selectedRow.cells[2].innerHTML = formData.EmployeeSalary;
    selectedRow.cells[3].innerHTML = formData.EmployeeId;
}

function onDelete(td){
    if(confirm('are you sure to delete this record ?')){
        row = td.parentElement.parentElement;
        document.getElementById("EmployeeList").deleteRow(row.rowIndex);
        resetForm();
    }
}