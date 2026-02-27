function saveAvatar() {
    let avatarInput = document.getElementById("avatar");
    // KIỂM TRA XEM CHỌN HÌNH CHƯA
    if(avatarInput.files.length === 0){
        alert("Vui lòng chọn file!");
        return;
    }

    // ADD FILE VÀO ĐỐI TƯỢNG FORMDATA
    let formData = new FormData();
    formData.append('file', avatarInput.files[0]);

    axios({
        url: 'http://localhost:8080/api/file/upload',
        method: 'POST',
        data: formData,
        headers: {
            'Content-Type': 'multipart/form-data'
        }
    })
    .then(function(resp){
        let imageUrl = resp.data;
        // TRUY CẬP TỚI THẺ IMG
        let imgAvatar = document.getElementById('imgAvatar');
        // THAY ĐỔI GIÁ TRI CỦA THẺ SRC
        imgAvatar.setAttribute('src', `http://localhost:8080/${imageUrl}`);
    })
    .catch(function(err){
        console.log(err)
    })
    
    

//load profile
}
function  loadprofile() {

    axios({
        url: 'http://localhost:2404/api/user/profile',
        method: 'GET',
        headers:{'Authorization': 'Bearer '+ localStorage.getItem("acesssToken")}
       
    }).then(function(res){
        console.log(res.data);
      
        document.getElementById('email').value=res.data.email;
        document.getElementById('fullname').value=res.data.fullname;
        document.getElementById('address').value=res.data.address;
        document.getElementById('phone').value=res.data.phone;   
        document.getElementById('emailSecu').value=res.data.email;
 }).catch(function(res){
    console.log(res)
    })
}
function validatePassword() {
    let pass = document.getElementById("password").value;
    let confirm = document.getElementById("cfpassword").value;

    if (pass !== confirm) {
        alert("Confirm password không trùng khớp!");
        return false;  
    }

    return true;
}
function validatePassword() {
    let pass = document.getElementById("password");
    let confirm = document.getElementById("cfpassword");

    if (pass.value !== confirm.value) {
        confirm.style.border = "1px solid red";
        return false;
    } else {
        confirm.style.border = "1px solid #ced4da";
        return true;
    }
}
function editUser(id) {

    if (!validatePassword()) return;
 console.log("trung"+id);
    let email = document.getElementById("emailSecu").value;
    let password = document.getElementById("password").value;

    axios({
        url: 'http://localhost:2404/api/user/edit/' + id,
        method: 'PUT',
        headers: {
            'Authorization': 'Bearer ' + localStorage.getItem("acesssToken")
        },
        data: {
            email: email,
            password: password
        }
    })
    .then(function (res) {
        alert("Cập nhật thành công!");
    })
    .catch(function (err) {
        console.log(err);
        alert("Lỗi khi lưu thông tin!");
    });
}

    
    
    