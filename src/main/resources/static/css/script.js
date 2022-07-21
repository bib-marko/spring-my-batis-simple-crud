let bookIsbn = document.getElementById("isbn");
let bookTitle = document.getElementById("title");
let bookAuthor = document.getElementById("author");
let bookDesc = document.getElementById("desc");
let bookGenre = document.getElementById("genre");
let saveButton = document.getElementById("btnSave");
let addButton = document.getElementById("btnAdd");
let cancelButton = document.getElementById("btnCancel");
let getId;

fetchDataFromAPI();

async function fetchDataFromAPI() {
    const response = await fetch('http://localhost:8080/book/list');
    const names = await response.json();
    console.log(names);

    const header = `
          <tr>
            <th>ID</th>
            <th>ISBN</th>
            <th>TITLE</th>
            <th>AUTHOR</th>
            <th>DESCRIPTION</th>
            <th>GENRE</th>
            <th>ACTION</th>
          </tr>
        `
    document.querySelector("#data").innerHTML = names.reduce(( innerHTML, { id, isbn, title, author, description, genre }) => (
        `
            ${ innerHTML }
            <tr>
                  <td>${ id }</td>
                  <td>${ isbn }</td>
                  <td>${ title }</td>
                  <td>${ author }</td>
                  <td>${ description }</td>
                  <td>${ genre }</td>
                  <td>
                        <button id="btnDelete" class="button delete" value="${ genre }" onclick="deleteBook(${ id })">DELETE</button>
                        <button id="btnUpdate" class="button update" value="${ genre }" onclick="updateBook(${ id })">UPDATE</button>
                  </td>
            </tr>
          `
    ), header );
}

function validateFields(){
    const allFields = [bookIsbn.value,bookTitle.value,bookAuthor.value,bookDesc.value,bookGenre.value];
    for(let index = 0; index < allFields.length; index++){
        if (allFields[index] === ""){
            return false;
        }
    }
    return true;
}

async function addNewBook() {
    validateFields() === true ? await proccessData("http://localhost:8080/book/new", "add") : alert("Please fill out all provided details of the book!");
}

async function saveUpdate() {
    validateFields() === true ? await proccessData("http://localhost:8080/book/update/" + getId, "update") : alert("Please fill out all provided details of the book!");
}

async function proccessData(url, operation) {
    fetch(url,{
        method: "POST",
        headers: { "Content-type": "application/json", },
        body: JSON.stringify({
            id: 1,
            isbn: bookIsbn.value,
            title: bookTitle.value,
            author: bookAuthor.value,
            description: bookDesc.value,
            genre: bookGenre.value
        })
    }).then((res) => res.json()).then(data => console.log(data))
    let reloadPage = (operation === "add") ? confirm("Book added Successfully") : confirm("Book " + getId + " Updated Successfully");
    if(reloadPage){ window.location.reload(); }
}

async function deleteBook(str) {
    let isExecuted = confirm("Do you want to delete book " + str);
    if(isExecuted){
        fetch('http://localhost:8080/book/delete/'+str,{
            method: "POST",
            header: {"Content-type": "application/json",}
        }).then((res) => res.json()).then(data => console.log(data))
        window.location.reload();
    }
}

async function updateBook(str) {
    getId = str;
    if (saveButton.style.display === "none") {
        saveButton.style.display = "block";
        addButton.style.display = "none";
        cancelButton.style.display = "block";
        document.getElementById("fromTitle").innerText = "Update Book Information";
        document.getElementById("id").style.display = "block";
        document.getElementById("id").innerHTML =  "ID : " + getId;
    } else {
        saveButton.style.display = "none";
        addButton.style.display = "block";
        cancelButton.style.display = "none";
        document.getElementById("fromTitle").innerText = "Add New Book";
        document.getElementById("id").style.display = "none";
    }
}