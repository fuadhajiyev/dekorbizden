var path = window.location.pathname;
var typename =  'vip';


const dekorlar = 'http://localhost:8080/api/1.0/alldekorlar?type='+'standart';
const getAlldekorlar2 = 'http://localhost:8080/api/1.0/alldekorlar?type='+typename;
const page_url2 = `http://localhost:8080/api/1.0/dekorlar?page=`;

let   count2 = 0;

var content2 = document.getElementById("vip-content2");

const userCardTemplate2 = document.querySelector("[data-user-template-a]")
const userCardContainer2 = document.querySelector("[data-user-cards-container-a]")
const searchInput2 = document.querySelector("[data-search]");



let users2 = []

// searchInput.addEventListener("input", e => {
//   console.log("dekorlar =", users);

//   const value = e.target.value.toUpperCase()
//   users.forEach(user => {

//     const isVisible =
//       user.itemCode.toUpperCase().includes(value)
//       user.element.classList.toggle("hide", !isVisible)
//   })
// })
// https://drive.google.com/file/d/1FMUnAlgIKQf_VLSRGEhgqEWaUqDW0mdo/view?usp=share_link




var getAll = function (pageCount = 0) {

  fetch(getAlldekorlar2,  {
    method: 'GET',
    mode: 'cors',
    headers: {
      'Content-Type': 'application/json',
      'X-Content-Type-Options': 'nosniff',
      'Access-Control-Allow-Origin': '*'

    }
  })
  .then(res => res.json())
  .then(data => {

    console.log(data);

    users2 = data.map(user => {
      const card = userCardTemplate2.content.cloneNode(true).children[0]
      const header = card.querySelector("[data-header-a]")
      const body = card.querySelector("[data-body-a]")
      const img = card.querySelector("[data-img-a]")
      const btn = card.querySelector("[data-btn-a]")
      let img_cutId = null;
      if(user.cover_img != null){
       img_cutId = user.cover_img.split("/" , 6)[5];
      }

      img.innerHTML = `
      <img class="img-responsive"
                                            
      src="https://drive.google.com/uc?export=view&id=${img_cutId}"
      alt="standart set - code:${user.itemCode}" width="300" height="300">`
      
      btn.innerHTML =  `       <form  action="../magaza/standart/item-details.html" class="thumb-link" method="get">
      <button type="submit" name="itemCode" value="${user.itemCode}" class="btn btn-primary btn-add mb-3 add-to-cart-btn"
          data-id=${user.id}> Bax
       </button>
       </form>`

      header.textContent = "Standart Set - kod: "+ user.itemCode ;
      body.textContent = user.price + " azn";
      userCardContainer2.append(card)
      return { price: user.price, itemCode: user.itemCode, img: user.cover_img, element: card }
    })
    

  })

}
getAll()












var getAllmasaDekor = function () {
  fetch(getAlldekorlar , {
    method: 'GET',
    // mode: 'no-cors',
    headers: {
      'Content-Type': 'application/json',
      'X-Content-Type-Options': 'nosniff',
      'Access-Control-Allow-Origin': '*'

    }
  })
    .then(res =>
      res.json(),
    )
    .then(data => {
      console.log(data);
      dekors =   data.map(element => {
        // const img = element.cover_img.split("/" , 6);
        var img = "";
      content.innerHTML += `
      <div class="product-item best-selling style-04 rows-space-30 col-lg-4 col-12">
      <div class="product-inner tooltip-top tooltip-all-top">
          <div class="product-thumb">
              <div class="flash">
              </div>

              
                  <img class="img-responsive" src="https://drive.google.com/uc?export=view&id=${img[5]}"
                      alt="standart set -${element.itemCode}" width="300" height="300">
            
          </div>
          <div class="product-info">
              <h3 class="product-name product_title">
                  <a href="../magaza/standart/code-s1001.html">${element.type} Set -
                      kod: ${element.itemCode}</a>
              </h3>


              <span class="price">
                  <span class="agch-Price-amount amount">${element.price}<span
                          class="agch-Price-currencySymbol"> ₼</span></span> </span>

          </div>
          <div>
           
              <form  action="../magaza/standart/item-details.html" class="thumb-link" method="get">
              <button type="submit" name="itemCode" value="${element.itemCode}" class="btn btn-primary btn-add mb-3 add-to-cart-btn"
                  data-id=${element.id}> Bax
               </button>
               </form>
            
          </div>


      </div>
  </div>
      `;

      });

      var myProducts = document.getElementById('content');

      myProducts.addEventListener("scroll", myPageScroll);

      function myPageScroll() {

        var myScrollTop = myProducts.scrollTop;
        var myScrollHeight = myProducts.scrollHeight;
        var diff = myScrollHeight - myScrollTop;
        var height = myProducts.clientHeight;
        var offPageHeight = 500;
        if (diff < (height + offPageHeight)) {
          console.log(data.totalPages);
          if (count < data.totalPages) {
            count++;
            console.log("count:" + count);
            getAllmasaDekor(count);
          }
        }

        // console.log(myScrollTop+" "+myScrollHeight);
      }




    } );


}
// getAllmasaDekor();




















