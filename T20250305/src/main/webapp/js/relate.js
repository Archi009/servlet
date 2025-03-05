/**
 * relate.js
 */




const loc = document.getElementById("mock")


const mockUp = `
            <div class="container px-4 px-lg-5 mt-5">
                <h2 class="fw-bolder mb-4">평점순 정렬된 목록</h2>
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center" id="starList">
                </div>
                </div>
              `
let code = document.querySelector("#code").innerText               
console.log(code.substring(6));
let data = {
  prdCode : code.substring(6).trim()
}
fetch("starList.do" ,{
  method: "POST", 
  headers: {
    "Content-Type": "application/json", 
  },
  body: JSON.stringify(data)
}).then(result => result.json())
.then(result=>{
  loc.innerHTML = mockUp;
  const locStar = document.getElementById('starList')
  console.log(result);
  let html = ""
  result.forEach(item => {
    html += `<div class="col mb-5">
                        <div class="card h-100">
                            <!-- Sale badge-->
                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
                            <!-- Product image-->
                            <img class="card-img-top" src="images/${item.prodImage}" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">${item.prdName}</h5>
                                    <!-- Product reviews-->
                                   
                                   <div class="d-flex justify-content-center small text-warning mb-2">`
                                        for(let i=0; i<item.starPoint;i++){
                                          html += `<div class="bi-star-fill"></div>`
                                        }
                                        for(let i=0; i<(5-item.starPoint);i++){
                                          html += `<div class="bi-star"></div>`
                                        }
                                    
                                    
    html += `</div>
    <!-- Product price-->
                                    <span class="text-muted text-decoration-line-through">${item.originPrice}</span>
                                    ${item.salePrice}
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>
                            </div>
                        </div>
                    </div>`                               
  locStar.innerHTML = html               
  });
}).catch(err=>console.log(err))

