function addUser(){

let email=document.getElementById("email").value;
let pass=document.getElementById("pass").value;
let name=document.getElementById("name").value;
let sdt=document.getElementById("sdt").value;
let diachi=document.getElementById("diachi").value;
let role_id=document.getElementById("role_id").value;

let datathem={"address": diachi,
"avatar": "null",
"email": email,
"fullname": name,
"password": pass,
"phone": sdt,
"role_id": role_id

}

    axios({
        url: 'http://localhost:2404/api/admin/user',
        method: 'POST',
        data:datathem,
        headers:{'Authorization': 'Bearer '+localStorage.getItem("acesssToken")}
       
       
    })
    .then(function(res){
        let tookkeenn= localStorage.getItem('acesssToken');
       document.getElementById('save').href="./user-list.html"
       window.location="./user-list.html"

       
    })
    .catch(function(err){
        console.log(err)
    })


}
function loaduser() {
    axios({
        url: 'http://localhost:2404/api/admin/user',
        method: 'GET',
        headers:{'Authorization': 'Bearer '+ localStorage.getItem("acesssToken")}
    }).then(function(res){
 this. rendertable(res.data);      
 }).catch(function(err){
        console.log(err)
    })
}

function rendertable(arr){
    var noidung='';
    for(var i=0;i<arr.length;i++)
    {
       
  noidung+=  `<tr  >        
            <td>${arr[i].id}</td>
            <td>${arr[i].fullname}</td>
            <td>${arr[i].email}</td>
            <td>${arr[i].phone}</td>
            <td>${ROLE_MAP[arr[i].role_id] || "Unknown"}</td>
            <td>
                <a href="./user-edit.html" class="btn btn-sm btn-info" onclick="edit('${arr[i].id}')">
                    <i class="fa fa-pencil-square-o"></i>
                </a>
                <a href="#" class="btn btn-sm btn-danger" onclick="deleteUser('${arr[i].id}')" >
                    <i class="fa fa-trash-o"></i>
                </a>
            </td>
            </tr>
            `
        
    }
    document.querySelector('.userlist').innerHTML=noidung;

}
function edit(id)
{
    localStorage.setItem('id',id)
}
const ROLE_MAP = {
  1: "Admin",
  2: "Teacher",
  3: "Student"
};




function editUser(id){

    let email=document.getElementById("email").value;
   // let pass=document.getElementById("password").value;
    let name=document.getElementById("fullname").value;
    let sdt=document.getElementById("phone").value;
    let diachi=document.getElementById("address").value;
    let role_id=document.getElementById("role_id").value;
    
    let dataedit={"address": diachi,
    "avatar": "null",
    "email": email,
    "fullname": name,
    
    "phone": sdt,
    "role_id": role_id,
    "id":id
    
    }
           
        axios({
            url: 'http://localhost:2404/api/admin/user/edit/'+id,
            method: 'PUT',
            data:dataedit,
            headers:{'Authorization': 'Bearer '+localStorage.getItem("acesssToken")}
      
        })  
        .then(function(res){
            let tookkeenn= localStorage.getItem('acesssToken');
           document.getElementById('edit').href="./user-list.html"
              window.location="./user-list.html"
        })
        .catch(function(err){
            console.log(err)
        })

    }

    function deleteUser(id){
         localStorage.setItem('id',id)
   
            axios({
                url: 'http://localhost:2404/api/admin/user/delete/'+id,
                method: 'DELETE',
                
                headers:{'Authorization': 'Bearer '+localStorage.getItem("acesssToken")}
               
               
            })  
            .then(function(res){
                setTimeout(function () {
                 location.reload()
             }, 100)
            })
            .catch(function(err){
                console.log(err)
            })
        
        
        }