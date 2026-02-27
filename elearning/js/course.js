function loadCourse() {


    axios({
        url: 'http://localhost:2404/api/course',
        method: 'GET',
        // headers:{'Authorization': 'Bearer '+localStorage.getItem(ACCESS_TOKEN)}


    })
        .then(function (res) {
            this.rendercourse(res.data);

        })

            .catch(function (err) {
                console.log(err)
            })
}
function rendercourse(arr) {
    var noidungsale = '';
    var noidungnotsale = '';
    for (var i = 0; i < arr.length; i++) {
        if (arr[i].discout !== 0) {
            
       noidungsale += ` <div class="col-md-3">
      <div class="course">
          <img src="./img/html-css.jpg" />
          <h6 class="course-title">${arr[i].description}</h6>
          <small class="course-content">
              Become an ethical hacker that can hack computer systems like black hat hackers and
              secure
              them like security experts.
          </small>
          <div class="course-price">
              <span>${arr[i].promotion_price}</span>
              <small>${arr[i].price} đ </small>
          </div>
          <div class="seller-label">Sale ${arr[i].discout} %</div>
          <div class="course-overlay">
              <a href="details.html">
                  <h6 class="course-title">
                      The Complete Digital Marketing Course - 12 Courses in 1
                  </h6>
                  <div class="course-author">
                      <b>Lê Quang Song</b>
                      <span class="mx-1"> | </span>
                      <b>Development</b>
                  </div>
                  <div class="course-info">
                      <span><i class="fa fa-play-circle"></i> ${arr[i].letures_count} lectures</span>
                      <span class="mx-1"> | </span>
                      <span><i class="fa fa-clock-o"></i> 40 hours</span>
                  </div>
                  <small class="course-content">
                      Become an ethical hacker that can hack computer systems like black hat
                      hackers and
                      secure them like security experts.
                  </small>
              </a>
              <a href="#" class="btn btn-sm btn-danger text-white w-100">Add to cart</a>
          </div>
      </div>
  </div>
      `
      console.log("noidungsale",noidungsale);
        } 
        else {

            noidungnotsale += ` <div class="col-md-2">
            <div class="course">
                <img src="./img/html-css.jpg" />
                <h6 class="course-title">The Complete Digital Marketing Course - 12 Courses in 1</h6>
                <small class="course-content">
                    Become an ethical hacker that can hack computer systems like black hat hackers and secure
                    them like security experts.
                </small>
                <div class="course-price">
                    <span>${arr[i].price} đ</span>
                </div>
                <div class="course-overlay">
                    <a href="details.html">
                        <h6 class="course-title">
                            ${arr[i].title}
                        </h6>
                        <div class="course-author">
                            <b>Lê Quang Song</b>
                            <span class="mx-1"> | </span>
                            <b>Development</b>
                        </div>
                        <div class="course-info">
                            <span><i class="fa fa-play-circle"></i> ${arr[i].letures_count} lectures</span>
                            <span class="mx-1"> | </span>
                            <span><i class="fa fa-clock-o"></i> ${arr[i].hour_count} hours</span>
                        </div>
                        <small class="course-content">
                            Become an ethical hacker that can hack computer systems like black hat hackers and
                            secure them like security experts.
                        </small>
                    </a>
                    <a href="#" class="btn btn-sm btn-danger text-white w-100">Add to cart</a>
                </div>
            </div>
        </div>
            `
console.log("nótale",noidungnotsale);
        }
    }
    document.querySelector('.courseSale').innerHTML = noidungsale;  
    document.querySelector('.coursenotsale').innerHTML=noidungnotsale;

}

    
   
